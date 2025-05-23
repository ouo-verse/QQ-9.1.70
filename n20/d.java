package n20;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.beans.QFSCommentInputWindowConfig;
import com.tencent.biz.qqcircle.beans.QFSFeedCommentInfo;
import com.tencent.biz.qqcircle.requests.QFSGetAiCommentsRequest;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudRead$GetAICommentsRsp;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d extends com.tencent.biz.qqcircle.viewmodels.a {
    private final LiveData<UIStateData<List<FeedCloudMeta$StComment>>> C;
    private int D;

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<UIStateData<List<FeedCloudMeta$StComment>>> f418028m;

    public d() {
        MutableLiveData<UIStateData<List<FeedCloudMeta$StComment>>> mutableLiveData = new MutableLiveData<>();
        this.f418028m = mutableLiveData;
        this.C = mutableLiveData;
    }

    private void M1(List<FeedCloudMeta$StComment> list) {
        FeedCloudMeta$StComment feedCloudMeta$StComment = new FeedCloudMeta$StComment();
        feedCloudMeta$StComment.content.set(h.a(R.string.f1913144g));
        list.add(feedCloudMeta$StComment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O1(QFSGetAiCommentsRequest qFSGetAiCommentsRequest, BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$GetAICommentsRsp feedCloudRead$GetAICommentsRsp) {
        boolean z17 = true;
        QLog.d("QFSAiCommentViewModel", 1, "[requestAiComments] -> onReceive: " + z16 + " | traceId:" + qFSGetAiCommentsRequest.getTraceId() + " | retCode:" + j3 + " | retMessage:" + str);
        if (!z16) {
            this.f418028m.setValue(UIStateData.obtainError(h.a(R.string.f181603e8)));
            return;
        }
        if (j3 != 0) {
            MutableLiveData<UIStateData<List<FeedCloudMeta$StComment>>> mutableLiveData = this.f418028m;
            UIStateData obtainError = UIStateData.obtainError(str);
            if (j3 != 10056) {
                z17 = false;
            }
            mutableLiveData.setValue(obtainError.setFinish(z17));
            return;
        }
        if (feedCloudRead$GetAICommentsRsp.trans_info.has()) {
            com.tencent.biz.qqcircle.comment.h.G().a0(feedCloudRead$GetAICommentsRsp.trans_info.get());
        }
        List<FeedCloudMeta$StComment> list = feedCloudRead$GetAICommentsRsp.comments.get();
        if (list != null && list.size() != 0) {
            M1(list);
            this.f418028m.setValue(UIStateData.obtainSuccess(false).setData(false, list));
        } else {
            this.f418028m.setValue(UIStateData.obtainEmpty().setMsg(h.a(R.string.f188053vn)));
        }
    }

    private void Q1(QFSCommentInputWindowConfig qFSCommentInputWindowConfig) {
        boolean z16;
        if (qFSCommentInputWindowConfig != null && qFSCommentInputWindowConfig.commentInfo != null) {
            QFSFeedCommentInfo qFSFeedCommentInfo = qFSCommentInputWindowConfig.commentInfo;
            final QFSGetAiCommentsRequest qFSGetAiCommentsRequest = new QFSGetAiCommentsRequest(qFSFeedCommentInfo.mFeed, qFSFeedCommentInfo.mComment, qFSFeedCommentInfo.mReply, qFSFeedCommentInfo.mCommentText);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[requestAiComments] inputText: ");
            sb5.append(qFSCommentInputWindowConfig.commentInfo.mCommentText);
            sb5.append(", comment is null:");
            boolean z17 = false;
            if (qFSCommentInputWindowConfig.commentInfo.mComment == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append(", reply is null:");
            if (qFSCommentInputWindowConfig.commentInfo.mReply == null) {
                z17 = true;
            }
            sb5.append(z17);
            QLog.d("QFSAiCommentViewModel", 1, sb5.toString());
            this.D = VSNetworkHelper.getInstance().sendRequest(qFSGetAiCommentsRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: n20.c
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z18, long j3, String str, Object obj) {
                    d.this.O1(qFSGetAiCommentsRequest, baseRequest, z18, j3, str, (FeedCloudRead$GetAICommentsRsp) obj);
                }
            });
        }
    }

    public LiveData<UIStateData<List<FeedCloudMeta$StComment>>> N1() {
        return this.C;
    }

    public void P1(QFSCommentInputWindowConfig qFSCommentInputWindowConfig) {
        if (!HostNetworkUtils.isNetworkAvailable()) {
            this.f418028m.setValue(UIStateData.obtainError(h.a(R.string.f181603e8)));
        } else {
            this.f418028m.setValue(UIStateData.obtainLoading());
            Q1(qFSCommentInputWindowConfig);
        }
    }

    public void R1() {
        VSNetworkHelper.getInstance().cancelRequest(RFWApplication.getApplication(), this.D);
        this.f418028m.setValue(UIStateData.obtainLoading());
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSAiCommentViewModel";
    }
}
