package com.tencent.biz.qqcircle.viewmodels;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.beans.QFSCommentAreaTabItemInfo;
import com.tencent.biz.qqcircle.immersive.request.QFSGetCommentAreaLikeDataRequest;
import com.tencent.biz.qqcircle.immersive.request.QFSGetCommentAreaPushDataRequest;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetLikeListByOpUIDsFeedIDRsp;
import feedcloud.FeedCloudRead$StGetPushListByOpUIDsFeedIDRsp;
import feedcloud.FeedCloudRead$UserAndLikeTips;
import feedcloud.FeedCloudRead$UserAndPushCnt;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class m extends a {
    private String C;
    private FeedCloudMeta$StFeed D;
    private String E;
    private String F;
    private ByteStringMicro J;
    private FeedCloudCommon$StCommonExt K;
    private ByteStringMicro P;
    private FeedCloudCommon$StCommonExt Q;

    /* renamed from: m, reason: collision with root package name */
    private FeedCloudMeta$StFeed f92871m;
    private final MutableLiveData<UIStateData<List<QFSCommentAreaTabItemInfo>>> G = new MutableLiveData<>();
    private final List<QFSCommentAreaTabItemInfo> H = new ArrayList();
    private final MutableLiveData<String> I = new MutableLiveData<>();
    private final MutableLiveData<UIStateData<List<QFSCommentAreaTabItemInfo>>> L = new MutableLiveData<>();
    private final List<QFSCommentAreaTabItemInfo> M = new ArrayList();
    private final MutableLiveData<String> N = new MutableLiveData<>();

    private void N1() {
        this.f92871m = null;
        this.G.setValue(null);
        this.J = null;
        this.K = null;
        this.I.setValue("");
    }

    private void O1() {
        this.D = null;
        this.L.setValue(null);
        this.P = null;
        this.Q = null;
        this.N.setValue("");
    }

    private void T1(boolean z16, long j3, FeedCloudRead$StGetLikeListByOpUIDsFeedIDRsp feedCloudRead$StGetLikeListByOpUIDsFeedIDRsp, String str, boolean z17, List<String> list) {
        if (!z17) {
            this.H.clear();
        }
        if (z16 && j3 == 0) {
            boolean z18 = false;
            boolean z19 = true;
            if (feedCloudRead$StGetLikeListByOpUIDsFeedIDRsp.likes.size() == 0) {
                if (this.M.size() == 0 && list != null && list.size() > 0) {
                    QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f188833xr), 0);
                }
                if (this.H.size() == 0) {
                    this.G.setValue(UIStateData.obtainEmpty());
                    return;
                }
                MutableLiveData<UIStateData<List<QFSCommentAreaTabItemInfo>>> mutableLiveData = this.G;
                UIStateData data = UIStateData.obtainSuccess(false).setData(z17, this.H);
                if (feedCloudRead$StGetLikeListByOpUIDsFeedIDRsp.is_finish.get() == 1) {
                    z18 = true;
                }
                mutableLiveData.setValue(data.setFinish(z18));
                return;
            }
            this.J = feedCloudRead$StGetLikeListByOpUIDsFeedIDRsp.backent_trans_data.get();
            this.K = feedCloudRead$StGetLikeListByOpUIDsFeedIDRsp.ext_info.get();
            ArrayList arrayList = new ArrayList();
            boolean z26 = false;
            for (FeedCloudRead$UserAndLikeTips feedCloudRead$UserAndLikeTips : feedCloudRead$StGetLikeListByOpUIDsFeedIDRsp.likes.get()) {
                if (feedCloudRead$UserAndLikeTips != null) {
                    QFSCommentAreaTabItemInfo qFSCommentAreaTabItemInfo = new QFSCommentAreaTabItemInfo();
                    qFSCommentAreaTabItemInfo.setLikeItemInfo(feedCloudRead$UserAndLikeTips.user.get(), feedCloudRead$UserAndLikeTips.text.get());
                    qFSCommentAreaTabItemInfo.setThanked(feedCloudRead$UserAndLikeTips.is_thanked.get());
                    qFSCommentAreaTabItemInfo.setStFeed(this.f92871m);
                    qFSCommentAreaTabItemInfo.setIsLikeTabItem(true);
                    if (feedCloudRead$UserAndLikeTips.is_highlight.get() == 1) {
                        qFSCommentAreaTabItemInfo.setNeedTopAnimation(true);
                        z26 = true;
                    }
                    arrayList.add(qFSCommentAreaTabItemInfo);
                }
            }
            if (list != null && list.size() > 0 && !z26) {
                QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f188833xr), 0);
            }
            this.I.setValue(feedCloudRead$StGetLikeListByOpUIDsFeedIDRsp.tail_text.get());
            this.H.addAll(arrayList);
            if (feedCloudRead$StGetLikeListByOpUIDsFeedIDRsp.is_finish.get() != 1) {
                z19 = false;
            }
            this.G.setValue(UIStateData.obtainSuccess(false).setData(z17, this.H).setFinish(z19));
            return;
        }
        this.G.setValue(UIStateData.obtainError(str));
    }

    private void U1(boolean z16, long j3, FeedCloudRead$StGetPushListByOpUIDsFeedIDRsp feedCloudRead$StGetPushListByOpUIDsFeedIDRsp, String str, boolean z17, String str2) {
        boolean z18;
        String str3;
        if (!z17) {
            this.M.clear();
        }
        if (z16 && j3 == 0 && feedCloudRead$StGetPushListByOpUIDsFeedIDRsp != null) {
            boolean z19 = true;
            if (!z17 && QFSCommentHelper.L().z()) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (feedCloudRead$StGetPushListByOpUIDsFeedIDRsp.pushes.size() == 0 && !z18) {
                if (this.M.size() == 0 && !TextUtils.isEmpty(str2)) {
                    QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f188843xs), 0);
                }
                if (this.M.size() == 0) {
                    this.L.setValue(UIStateData.obtainEmpty());
                    return;
                }
                MutableLiveData<UIStateData<List<QFSCommentAreaTabItemInfo>>> mutableLiveData = this.L;
                UIStateData data = UIStateData.obtainSuccess(false).setData(z17, this.M);
                if (feedCloudRead$StGetPushListByOpUIDsFeedIDRsp.is_finish.get() != 1) {
                    z19 = false;
                }
                mutableLiveData.setValue(data.setFinish(z19));
                return;
            }
            this.P = feedCloudRead$StGetPushListByOpUIDsFeedIDRsp.backent_trans_data.get();
            this.Q = feedCloudRead$StGetPushListByOpUIDsFeedIDRsp.ext_info.get();
            ArrayList arrayList = new ArrayList();
            if (z18) {
                QFSCommentAreaTabItemInfo qFSCommentAreaTabItemInfo = new QFSCommentAreaTabItemInfo();
                qFSCommentAreaTabItemInfo.setStFeed(this.D);
                qFSCommentAreaTabItemInfo.setItemViewType(1);
                arrayList.add(qFSCommentAreaTabItemInfo);
            }
            for (FeedCloudRead$UserAndPushCnt feedCloudRead$UserAndPushCnt : feedCloudRead$StGetPushListByOpUIDsFeedIDRsp.pushes.get()) {
                if (feedCloudRead$UserAndPushCnt != null) {
                    QFSCommentAreaTabItemInfo qFSCommentAreaTabItemInfo2 = new QFSCommentAreaTabItemInfo();
                    qFSCommentAreaTabItemInfo2.setPushItemInfo(feedCloudRead$UserAndPushCnt.user.get(), feedCloudRead$UserAndPushCnt.push_cnt.get());
                    qFSCommentAreaTabItemInfo2.setThanked(feedCloudRead$UserAndPushCnt.is_thanked.get());
                    qFSCommentAreaTabItemInfo2.setStFeed(this.D);
                    arrayList.add(qFSCommentAreaTabItemInfo2);
                }
            }
            QFSCommentAreaTabItemInfo qFSCommentAreaTabItemInfo3 = (QFSCommentAreaTabItemInfo) RFSafeListUtils.get(arrayList, 0);
            if (!TextUtils.isEmpty(str2)) {
                if (qFSCommentAreaTabItemInfo3 != null) {
                    if (qFSCommentAreaTabItemInfo3.getUser() != null) {
                        str3 = qFSCommentAreaTabItemInfo3.getUser().f398463id.get();
                    } else {
                        str3 = "";
                    }
                    boolean equals = TextUtils.equals(str2, str3);
                    qFSCommentAreaTabItemInfo3.setNeedTopAnimation(equals);
                    if (this.M.size() == 0 && !equals) {
                        QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f188843xs), 0);
                    }
                } else {
                    QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f188843xs), 0);
                }
            }
            this.N.setValue(feedCloudRead$StGetPushListByOpUIDsFeedIDRsp.tail_text.get());
            this.M.addAll(arrayList);
            if (feedCloudRead$StGetPushListByOpUIDsFeedIDRsp.is_finish.get() != 1) {
                z19 = false;
            }
            this.L.setValue(UIStateData.obtainSuccess(false).setData(z17, this.M).setFinish(z19));
            return;
        }
        this.L.setValue(UIStateData.obtainError(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W1(boolean z16, List list, BaseRequest baseRequest, boolean z17, long j3, String str, FeedCloudRead$StGetLikeListByOpUIDsFeedIDRsp feedCloudRead$StGetLikeListByOpUIDsFeedIDRsp) {
        QLog.d(getTAG(), 1, "requestLikeData onReceive: dispatch Success:" + z17 + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str);
        T1(z17, j3, feedCloudRead$StGetLikeListByOpUIDsFeedIDRsp, str, z16, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X1(boolean z16, String str, BaseRequest baseRequest, boolean z17, long j3, String str2, FeedCloudRead$StGetPushListByOpUIDsFeedIDRsp feedCloudRead$StGetPushListByOpUIDsFeedIDRsp) {
        QLog.d(getTAG(), 1, "requestPushData onReceive: dispatch Success:" + z17 + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str2);
        U1(z17, j3, feedCloudRead$StGetPushListByOpUIDsFeedIDRsp, str2, z16, str);
    }

    public MutableLiveData<UIStateData<List<QFSCommentAreaTabItemInfo>>> P1() {
        return this.G;
    }

    public MutableLiveData<String> Q1() {
        return this.I;
    }

    public MutableLiveData<UIStateData<List<QFSCommentAreaTabItemInfo>>> R1() {
        return this.L;
    }

    public MutableLiveData<String> S1() {
        return this.N;
    }

    public void Z1(FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str, List<String> list, String str2, int i3, boolean z16) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed3;
        if (feedCloudMeta$StFeed != null && !TextUtils.isEmpty(feedCloudMeta$StFeed.f398449id.get())) {
            if (i3 == 1 && !z16 && (feedCloudMeta$StFeed3 = this.f92871m) != null && TextUtils.equals(feedCloudMeta$StFeed3.f398449id.get(), feedCloudMeta$StFeed.f398449id.get())) {
                QLog.d("QFSCommentAreaTabVPAdapter", 4, "refreshData isSameLikeFeed");
                return;
            }
            if (i3 == 2 && !z16 && (feedCloudMeta$StFeed2 = this.D) != null && TextUtils.equals(feedCloudMeta$StFeed2.f398449id.get(), feedCloudMeta$StFeed.f398449id.get())) {
                QLog.d("QFSCommentAreaTabVPAdapter", 4, "refreshData isSamePushFeed");
                return;
            }
            this.F = str;
            if (i3 == 1) {
                N1();
                a2(feedCloudMeta$StFeed, false, list, str2);
            } else if (i3 == 2) {
                O1();
                b2(feedCloudMeta$StFeed, false, list, str2);
            }
        }
    }

    public void a2(FeedCloudMeta$StFeed feedCloudMeta$StFeed, final boolean z16, final List<String> list, String str) {
        if (!z16) {
            this.f92871m = feedCloudMeta$StFeed;
            this.C = str;
            this.G.setValue(UIStateData.obtainLoading());
        }
        sendRequest(new QFSGetCommentAreaLikeDataRequest(this.f92871m.f398449id.get(), this.J, list, this.K, this.C), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.viewmodels.l
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z17, long j3, String str2, Object obj) {
                m.this.W1(z16, list, baseRequest, z17, j3, str2, (FeedCloudRead$StGetLikeListByOpUIDsFeedIDRsp) obj);
            }
        });
    }

    public void b2(FeedCloudMeta$StFeed feedCloudMeta$StFeed, final boolean z16, List<String> list, String str) {
        final String str2;
        if (!z16) {
            this.D = feedCloudMeta$StFeed;
            this.E = str;
            this.L.setValue(UIStateData.obtainLoading());
        }
        if (list != null && list.size() > 0) {
            str2 = list.get(0);
        } else {
            str2 = "";
        }
        sendRequest(new QFSGetCommentAreaPushDataRequest(this.D.f398449id.get(), this.F, this.P, str2, this.Q, this.E), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.viewmodels.k
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z17, long j3, String str3, Object obj) {
                m.this.X1(z16, str2, baseRequest, z17, j3, str3, (FeedCloudRead$StGetPushListByOpUIDsFeedIDRsp) obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSCommentAreaTabVPAdapter";
    }
}
