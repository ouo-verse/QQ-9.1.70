package com.tencent.biz.qqcircle.list.bizblocks;

import android.app.Activity;
import android.os.Bundle;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QFSSearchBean;
import com.tencent.biz.qqcircle.immersive.bean.QFSSearchInfo;
import com.tencent.biz.qqcircle.immersive.request.QFSGetSearchPageRequest;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.qqcircle.immersive.views.search.simpleitem.QFSSearchQueryFixResultItemView;
import com.tencent.biz.qqcircle.immersive.views.search.util.p;
import com.tencent.biz.qqcircle.list.QCircleBaseListBlock;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock;
import com.tencent.biz.qqcircle.utils.cj;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.data.idata.IDataCallBack;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.AppSetting;
import cooperation.qqcircle.utils.JsonBinder;
import feedcloud.FeedCloudMeta$StTagInfo;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudRead$StCorrectionInfo;
import feedcloud.FeedCloudRead$StGetSearchPageRsp;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.light.utils.CollectionUtils;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class QFSSearchResultBaseTabBlock extends QCircleBaseListBlock<Object, FeedCloudRead$StGetSearchPageRsp> {
    protected QFSSearchInfo currentSearchInfo;
    protected FeedCloudRead$StCorrectionInfo currentStCorrectionInfo;
    private i60.b mOnGetDataListener;
    protected String mSearchKey;
    protected final com.tencent.biz.qqcircle.immersive.views.search.util.l requestWrapper;

    public QFSSearchResultBaseTabBlock(Bundle bundle) {
        super(bundle);
        this.requestWrapper = new com.tencent.biz.qqcircle.immersive.views.search.util.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$notifyLoadingComplete$0() {
        VideoReport.traverseExposure();
        return false;
    }

    private String printDataList(List<Object> list) {
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (list.get(i3) instanceof FeedCloudMeta$StUser) {
                sb5.append("StUser_");
                sb5.append(((FeedCloudMeta$StUser) list.get(i3)).f398463id.get());
                sb5.append(":");
                sb5.append(((FeedCloudMeta$StUser) list.get(i3)).nick.get());
            } else if (list.get(i3) instanceof FeedCloudMeta$StTagInfo) {
                sb5.append("StTagInfo_");
                sb5.append(((FeedCloudMeta$StTagInfo) list.get(i3)).tagId.get());
                sb5.append(":");
                sb5.append(((FeedCloudMeta$StTagInfo) list.get(i3)).tagName.get());
            } else if (list.get(i3) instanceof FeedCloudRead$StCorrectionInfo) {
                sb5.append("StCorrectionInfo_");
                sb5.append(((FeedCloudRead$StCorrectionInfo) list.get(i3)).get().correction.get());
                sb5.append(":");
                sb5.append(((FeedCloudRead$StCorrectionInfo) list.get(i3)).get().correction_word.get());
            }
            sb5.append(",");
        }
        return sb5.toString();
    }

    protected boolean canInsertCorrectionInfo(List<Object> list) {
        if (this.currentStCorrectionInfo == null || CollectionUtils.isEmpty(list)) {
            return false;
        }
        return !(list.get(0) instanceof FeedCloudRead$StCorrectionInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean canSearchCorrection() {
        if (getLoadInfo().getCurrentState() == 3 || p.x(this.currentSearchInfo.e())) {
            return false;
        }
        return this.requestWrapper.c();
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public final String getAttachInfoFromItemData(Object obj) {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public abstract /* synthetic */ String getAttachInfoFromRsp(Object obj);

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public final List<Part> getCustomParts() {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public final String getDropFrameMonitorTag() {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public final String getEmptyHint() {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public abstract /* synthetic */ boolean getIsFinishFromRsp(Object obj);

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public abstract /* synthetic */ List<Object> getListDataFromRsp(Object obj, boolean z16);

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public final int getPageCount() {
        return 0;
    }

    protected abstract List<Integer> getRequestList();

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getTitle() {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public View getTitleTabView(ViewGroup viewGroup) {
        return null;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public final int getViewTypeCount() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public boolean isEnableRefresh() {
        return false;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
        i60.b bVar;
        if (TextUtils.isEmpty(this.mSearchKey)) {
            return;
        }
        super.loadData(loadInfo);
        if (getNUM_BACKGOURND_ICON() == 0 && (bVar = this.mOnGetDataListener) != null) {
            bVar.X6();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void notifyLoadingComplete(boolean z16, boolean z17) {
        super.notifyLoadingComplete(z16, z17);
        RFWThreadManager.getUIHandler().getLooper().getQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.tencent.biz.qqcircle.list.bizblocks.g
            @Override // android.os.MessageQueue.IdleHandler
            public final boolean queueIdle() {
                boolean lambda$notifyLoadingComplete$0;
                lambda$notifyLoadingComplete$0 = QFSSearchResultBaseTabBlock.lambda$notifyLoadingComplete$0();
                return lambda$notifyLoadingComplete$0;
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        if (!(viewHolder instanceof BaseListBlock.BaseListVH)) {
            return;
        }
        BaseListBlock.BaseListVH baseListVH = (BaseListBlock.BaseListVH) viewHolder;
        View view = baseListVH.itemView;
        if (view instanceof QFSSearchQueryFixResultItemView) {
            ((QFSSearchQueryFixResultItemView) view).setSearchInfo(this.currentSearchInfo);
        }
        baseListVH.setData(this.mDataList.get(i3), i3, this.mExtraTypeInfo);
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
        super.onInitBlock(bundle);
        getBlockMerger().setNoMoreHint("");
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartSaveInstanceState(Activity activity, Bundle bundle) {
        com.tencent.biz.richframework.part.b.e(this, activity, bundle);
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartStart(Activity activity) {
        com.tencent.biz.richframework.part.b.f(this, activity);
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartStop(Activity activity) {
        com.tencent.biz.richframework.part.b.g(this, activity);
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void preHandleListData(List<Object> list, boolean z16, boolean z17, boolean z18) {
        if (!z17 && canInsertCorrectionInfo(list)) {
            list.add(0, this.currentStCorrectionInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void printSearchPageData(FeedCloudRead$StGetSearchPageRsp feedCloudRead$StGetSearchPageRsp) {
        if (!AppSetting.isDebugVersion()) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("{");
        String json = JsonBinder.getInstance().toJson(getLoadInfo());
        sb5.append("loadInfo:");
        sb5.append(json);
        sb5.append(",");
        String json2 = JsonBinder.getInstance().toJson((List) getRequestList());
        sb5.append("requestList:");
        sb5.append(json2);
        sb5.append(",");
        ArrayList arrayList = new ArrayList();
        sb5.append("StCorrectionInfo:");
        if (feedCloudRead$StGetSearchPageRsp.searchTagInfo.has()) {
            sb5.append(feedCloudRead$StGetSearchPageRsp.searchTagInfo.correction_info.get().correction_word.get());
            arrayList.addAll(feedCloudRead$StGetSearchPageRsp.searchTagInfo.tagList.get());
        }
        if (feedCloudRead$StGetSearchPageRsp.searchUserInfo.has()) {
            sb5.append(feedCloudRead$StGetSearchPageRsp.searchUserInfo.correction_info.get().correction_word.get());
            arrayList.addAll(feedCloudRead$StGetSearchPageRsp.searchUserInfo.userList.get());
        }
        sb5.append(",");
        sb5.append(printDataList(arrayList));
        sb5.append("}");
        QLog.d(getLogTag(), 1, sb5.toString());
    }

    public void reset() {
        clearData();
        notifyDataSetChanged();
    }

    public void setCurrentSearchInfo(QFSSearchInfo qFSSearchInfo) {
        this.currentSearchInfo = qFSSearchInfo;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void setInitBean(Serializable serializable) {
        super.setInitBean(serializable);
        Serializable serializable2 = this.mInitBean;
        if (serializable2 instanceof QFSSearchBean) {
            this.mSearchKey = ((QFSSearchBean) serializable2).getSearchKeyword();
        }
    }

    public void setOnGetDataListener(i60.b bVar) {
        this.mOnGetDataListener = bVar;
    }

    public void setSearchKey(String str) {
        this.mSearchKey = str;
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void showEmptyView() {
        super.showEmptyView();
        i60.b bVar = this.mOnGetDataListener;
        if (bVar != null) {
            bVar.u1();
        }
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    protected void showErrorView(String str, long j3) {
        String str2;
        i60.b bVar;
        if (TextUtils.isEmpty(str)) {
            str2 = com.tencent.biz.qqcircle.utils.h.a(R.string.f181603e8);
        } else {
            str2 = str;
        }
        QLog.w(getLogTag(), 1, " return error\uff01errMsg:" + str2);
        if (getNUM_BACKGOURND_ICON() > 0) {
            if (!QCirclePluginUtil.isRequestSecurityHit(j3)) {
                cj.c(false, j3, str2, 1, QCircleToast.f91645e);
            }
        } else if (getBlockContainer() != null && (bVar = this.mOnGetDataListener) != null) {
            bVar.S2(str, j3);
        }
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void showListView() {
        super.showListView();
        i60.b bVar = this.mOnGetDataListener;
        if (bVar != null) {
            bVar.G4();
        }
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public BaseRequest getRequest(String str) {
        return new QFSGetSearchPageRequest.a().l(this.mSearchKey).j(2).k(getRequestList()).h(str).b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void handleResponse(boolean z16, boolean z17, long j3, @Nullable BaseRequest baseRequest, String str, FeedCloudRead$StGetSearchPageRsp feedCloudRead$StGetSearchPageRsp) {
        super.handleResponse(z16, z17, j3, baseRequest, str, (String) feedCloudRead$StGetSearchPageRsp);
        if (baseRequest instanceof QFSGetSearchPageRequest) {
            ((QFSSearchBaseRequest) baseRequest).addReportExtraData(QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, String.valueOf(z17)).addReportExtraData(QFSSearchBaseRequest.EXTRA_KEY_SEARCH_TYPE, ((QFSGetSearchPageRequest) baseRequest).getSearchTypeReportData()).reportCmdSuccessRate(j3, str);
        }
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void initTitleBar(View view) {
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public final void getListDataAsync(IDataCallBack<Object> iDataCallBack, String str) {
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void onTitleTabSelectedChanged(View view, boolean z16) {
    }
}
