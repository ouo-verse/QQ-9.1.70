package cooperation.qqcircle.relation.request;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.qcircle.api.requests.QCircleRelationGroupRequest;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.QCircleConfig;
import cooperation.qqcircle.relation.entitys.NewRelationInfo;
import cooperation.qqcircle.relation.request.IQCircleRelationModel;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StRelationInfo;
import feedcloud.FeedCloudRead$RelationGroup;
import feedcloud.FeedCloudRead$StGetRelationGroupListRsp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleRelationModel implements IQCircleRelationModel, VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StGetRelationGroupListRsp> {
    private static final int MAX_LOAD_NEXT_COUNT = 50;
    private static final int RSP_EMPTY_ERROR_CODE = 1000009;
    private static final String RSP_EMPTY_ERROR_MSG = "load fail, callback rsp is null.";
    private static final String TAG = "RFL-QCircleRelationModel";
    private IQCircleRelationModel.OnLoadAtRelationListener mOnLoadAtRelationListener;
    private long mUpdateTimeInterval;
    private final Map<String, List<NewRelationInfo>> mResults = new HashMap();
    private int mRequestScene = 0;
    private String mTraceId = "";
    private int mMaxLoadNextCount = QCircleConfig.getInstance().getConfigValue("qqcircle", "qqcircle_load_max_next_count", (Integer) 50).intValue();
    private int mNextLoadCount = 0;

    private void assemblyAtRelationList(FeedCloudRead$RelationGroup feedCloudRead$RelationGroup) {
        if (feedCloudRead$RelationGroup == null) {
            QLog.d(TAG, 1, "[assemblyAtRelationList] group is null.");
            return;
        }
        String str = feedCloudRead$RelationGroup.name.get();
        if (TextUtils.isEmpty(str)) {
            QLog.d(TAG, 1, "[assemblyAtRelationList] group name not is empty.");
            return;
        }
        int i3 = feedCloudRead$RelationGroup.groupFlag.get();
        List<NewRelationInfo> convertNewRelationInfo = convertNewRelationInfo(i3, feedCloudRead$RelationGroup.gid.get(), feedCloudRead$RelationGroup.relationInfo.get());
        List<NewRelationInfo> list = this.mResults.get(str);
        if (list == null) {
            list = new ArrayList<>(convertNewRelationInfo);
            this.mResults.put(str, list);
        } else {
            list.addAll(convertNewRelationInfo);
        }
        QLog.d(TAG, 1, "[assemblyAtRelationList] relation history list count: " + list.size() + " | groupName: " + str + " | groupFlag: " + i3);
    }

    @NonNull
    private List<NewRelationInfo> convertNewRelationInfo(int i3, String str, List<FeedCloudMeta$StRelationInfo> list) {
        ArrayList arrayList = new ArrayList();
        for (FeedCloudMeta$StRelationInfo feedCloudMeta$StRelationInfo : list) {
            NewRelationInfo newRelationInfo = new NewRelationInfo();
            newRelationInfo.setRelationInfo(feedCloudMeta$StRelationInfo);
            newRelationInfo.setGroupFlag(i3);
            newRelationInfo.setGroupId(str);
            arrayList.add(newRelationInfo);
        }
        return arrayList;
    }

    private void handleRspResult(FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt, List<FeedCloudRead$RelationGroup> list, long j3) {
        if (list != null && !list.isEmpty()) {
            if (this.mNextLoadCount >= this.mMaxLoadNextCount) {
                notifyLoadAtRelationFinish();
                QLog.w(TAG, 1, "[handleRspResult] load count out of the maximum range. traceId: " + this.mTraceId);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (FeedCloudRead$RelationGroup feedCloudRead$RelationGroup : list) {
                assemblyAtRelationList(feedCloudRead$RelationGroup);
                QLog.d(TAG, 1, "[handleRspResult] group hasNext: " + feedCloudRead$RelationGroup.hasNext.get() + " | name: " + feedCloudRead$RelationGroup.name.get() + " | traceId: " + this.mTraceId);
                if (feedCloudRead$RelationGroup.hasNext.get() == 1) {
                    arrayList.add(feedCloudRead$RelationGroup);
                }
            }
            this.mNextLoadCount++;
            this.mUpdateTimeInterval = j3;
            loadNextPageData(feedCloudCommon$StCommonExt, arrayList);
            return;
        }
        QLog.w(TAG, 1, "[handleRspResult] current relation group list is empty. traceId: " + this.mTraceId);
    }

    private void loadNextPageData(FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt, List<FeedCloudRead$RelationGroup> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (FeedCloudRead$RelationGroup feedCloudRead$RelationGroup : list) {
                HashMap hashMap = new HashMap();
                hashMap.put(QCircleRelationGroupRequest.GROUP_ID, feedCloudRead$RelationGroup.gid.get());
                hashMap.put("attachInfo", feedCloudRead$RelationGroup.attachInfo.get());
                arrayList.add(hashMap);
            }
            QLog.d(TAG, 1, "[loadNextPageData] load next page, scene: " + this.mRequestScene + " | loadParams: " + arrayList + " | traceId: " + this.mTraceId);
            loadRelationData(this.mRequestScene, arrayList);
            return;
        }
        QLog.d(TAG, 1, "[loadNextPageData] load next data finish.");
        notifyLoadAtRelationFinish();
    }

    private void notifyLoadAtRelationFail(long j3, String str) {
        IQCircleRelationModel.OnLoadAtRelationListener onLoadAtRelationListener = this.mOnLoadAtRelationListener;
        if (onLoadAtRelationListener == null) {
            QLog.w(TAG, 1, "[notifyLoadAtRelationFail] load at relation listener not is null.");
        } else {
            onLoadAtRelationListener.onLoadAtRelationFail(this.mRequestScene, j3, str);
        }
    }

    private void notifyLoadAtRelationFinish() {
        IQCircleRelationModel.OnLoadAtRelationListener onLoadAtRelationListener = this.mOnLoadAtRelationListener;
        if (onLoadAtRelationListener == null) {
            QLog.w(TAG, 1, "[notifyLoadAtRelationFinish] load at relation listener not is null. traceId: " + this.mTraceId);
            return;
        }
        onLoadAtRelationListener.onLoadAtRelationFinish(this.mRequestScene, this.mResults, this.mUpdateTimeInterval);
    }

    @Override // cooperation.qqcircle.relation.request.IQCircleRelationModel
    public void loadRelationData(int i3) {
        loadRelationData(i3, new ArrayList());
    }

    public void sendDataRequest(int i3, List<Map<String, Object>> list) {
        int size;
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        QLog.d(TAG, 1, "[sendDataRequest] scene: " + i3 + " | param count: " + size);
        VSNetworkHelper.getInstance().sendRequest(new QCircleRelationGroupRequest(i3, list), this);
    }

    @Override // cooperation.qqcircle.relation.request.IQCircleRelationModel
    public void setOnLoadAtRelationListener(IQCircleRelationModel.OnLoadAtRelationListener onLoadAtRelationListener) {
        this.mOnLoadAtRelationListener = onLoadAtRelationListener;
    }

    private void loadRelationData(int i3, List<Map<String, Object>> list) {
        this.mRequestScene = i3;
        sendDataRequest(i3, list);
    }

    @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
    public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetRelationGroupListRsp feedCloudRead$StGetRelationGroupListRsp) {
        this.mTraceId = baseRequest == null ? "" : baseRequest.getTraceId();
        if (z16 && j3 == 0) {
            if (feedCloudRead$StGetRelationGroupListRsp == null) {
                notifyLoadAtRelationFail(1000009L, RSP_EMPTY_ERROR_MSG);
                QLog.w(TAG, 1, "[onReceive] response result not is null | traceId: " + this.mTraceId);
                return;
            }
            handleRspResult(feedCloudRead$StGetRelationGroupListRsp.extInfo, feedCloudRead$StGetRelationGroupListRsp.groupList.get(), feedCloudRead$StGetRelationGroupListRsp.timeInterval.get());
            return;
        }
        notifyLoadAtRelationFail(j3, str);
        QLog.w(TAG, 1, "[onReceive] request fail, error code: " + j3 + " | error msg: " + str + " | traceId: " + this.mTraceId);
    }
}
