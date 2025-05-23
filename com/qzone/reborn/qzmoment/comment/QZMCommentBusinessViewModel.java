package com.qzone.reborn.qzmoment.comment;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.qzone.reborn.base.n;
import com.qzone.reborn.qzmoment.request.QZMDoCommentRequest;
import com.qzone.reborn.qzmoment.request.QZMDoReplyRequest;
import com.qzone.reborn.qzmoment.request.QZMGetCommentListRequest;
import com.qzone.util.ToastUtil;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import qzonemoment.QZMomentMeta$StComment;
import qzonemoment.QZMomentMeta$StFeed;
import qzonemoment.QZMomentMeta$StReply;
import qzonemoment.QZMomentReader$StGetCommentListRsp;
import qzonemoment.QZMomentWriter$StDoCommentRsp;
import qzonemoment.QZMomentWriter$StDoReplyRsp;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZMCommentBusinessViewModel extends n {

    /* renamed from: i, reason: collision with root package name */
    private final MutableLiveData<UIStateData<List<QZMomentMeta$StComment>>> f58807i = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name */
    private final Map<String, ArrayList<QZMomentMeta$StComment>> f58808m = new HashMap();
    private final Map<String, Integer> C = new HashMap();
    private final Map<String, d> D = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack<QZMomentReader$StGetCommentListRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QZMomentMeta$StFeed f58823a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f58824b;

        a(QZMomentMeta$StFeed qZMomentMeta$StFeed, boolean z16) {
            this.f58823a = qZMomentMeta$StFeed;
            this.f58824b = z16;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QZMomentReader$StGetCommentListRsp qZMomentReader$StGetCommentListRsp) {
            QLog.d("QFSCommentBusiness", 1, "QFSCommentBusiness->onReceive: " + z16 + " |feedId:" + this.f58823a.f430362id.get() + " |traceId:" + baseRequest.getTraceId() + " | retCode:" + j3 + " | retMessage:" + str);
            boolean isProtocolCache = VSNetworkHelper.isProtocolCache(str);
            if (!z16 || j3 != 0 || qZMomentReader$StGetCommentListRsp == null) {
                QZMCommentBusinessViewModel.this.G2(UIStateData.obtainError(str).setRetCode(j3).setData(this.f58824b, QZMCommentBusinessViewModel.this.C2(this.f58823a.f430362id.get())).setLoadMore(this.f58824b));
                QZMCommentBusinessViewModel.this.L2(j3, R.string.f133606k);
                QLog.e("QFSCommentBusiness", 1, "getComment error:" + j3 + "  errorMsg:" + str);
                return;
            }
            QZMCommentBusinessViewModel.this.v2(qZMomentReader$StGetCommentListRsp, this.f58823a, this.f58824b, isProtocolCache);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b implements VSDispatchObserver.OnVSRspCallBack<QZMomentWriter$StDoCommentRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QZMomentMeta$StFeed f58826a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f58827b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f58828c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QZMomentMeta$StComment f58829d;

        b(QZMomentMeta$StFeed qZMomentMeta$StFeed, int i3, int i16, QZMomentMeta$StComment qZMomentMeta$StComment) {
            this.f58826a = qZMomentMeta$StFeed;
            this.f58827b = i3;
            this.f58828c = i16;
            this.f58829d = qZMomentMeta$StComment;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QZMomentWriter$StDoCommentRsp qZMomentWriter$StDoCommentRsp) {
            QLog.d("QFSCommentBusiness", 1, "do comment ->onReceive: " + z16 + " |feedId:" + this.f58826a.f430362id.get() + " |traceId:" + baseRequest.getTraceId() + " | retCode:" + j3 + " | retMessage:" + str);
            if (!z16 || j3 != 0 || qZMomentWriter$StDoCommentRsp == null) {
                QZMCommentBusinessViewModel.this.y2(this.f58827b, this.f58828c, this.f58826a, this.f58829d);
                QZMCommentBusinessViewModel.this.L2(j3, this.f58827b == 1 ? R.string.f133295q : R.string.f133255m);
                QLog.e("QFSCommentBusiness", 1, "addComment error:" + j3 + "  errorMsg:" + str);
                return;
            }
            QZMCommentBusinessViewModel.this.A2(this.f58827b, this.f58826a, this.f58829d, qZMomentWriter$StDoCommentRsp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public boolean f58837a;

        /* renamed from: b, reason: collision with root package name */
        public String f58838b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f58839c;

        d() {
        }

        public String toString() {
            return "CommentResponse{hasMore=" + this.f58837a + ", attachInfo='" + this.f58838b + "', hasResponse='" + this.f58839c + "'}";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A2(final int i3, final QZMomentMeta$StFeed qZMomentMeta$StFeed, final QZMomentMeta$StComment qZMomentMeta$StComment, final QZMomentWriter$StDoCommentRsp qZMomentWriter$StDoCommentRsp) {
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.qzone.reborn.qzmoment.comment.QZMCommentBusinessViewModel.5
            @Override // java.lang.Runnable
            public void run() {
                int i16 = i3;
                if (i16 != 0) {
                    if (i16 == 1) {
                        QZMCommentBusinessViewModel.this.s2(qZMomentMeta$StFeed, qZMomentMeta$StComment, qZMomentWriter$StDoCommentRsp);
                        return;
                    } else if (i16 != 2) {
                        return;
                    }
                }
                QZMCommentBusinessViewModel.this.x2(qZMomentMeta$StFeed, qZMomentMeta$StComment, qZMomentWriter$StDoCommentRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B2(final int i3, final QZMomentMeta$StFeed qZMomentMeta$StFeed, final QZMomentMeta$StComment qZMomentMeta$StComment, final QZMomentMeta$StReply qZMomentMeta$StReply, final QZMomentWriter$StDoReplyRsp qZMomentWriter$StDoReplyRsp) {
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.qzone.reborn.qzmoment.comment.QZMCommentBusinessViewModel.7
            @Override // java.lang.Runnable
            public void run() {
                int i16 = i3;
                if (i16 != 0) {
                    if (i16 == 1) {
                        QZMCommentBusinessViewModel.this.r2(qZMomentMeta$StFeed, qZMomentMeta$StComment, qZMomentMeta$StReply, qZMomentWriter$StDoReplyRsp);
                        return;
                    } else if (i16 != 2) {
                        return;
                    }
                }
                QZMCommentBusinessViewModel.this.w2(qZMomentMeta$StFeed, qZMomentMeta$StComment, qZMomentMeta$StReply, qZMomentWriter$StDoReplyRsp);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void F2(QZMomentMeta$StFeed qZMomentMeta$StFeed, int i3) {
        bn.b bVar;
        MutableLiveData globalData = en.a.a().getGlobalData(bn.b.class, qZMomentMeta$StFeed.f430362id.get());
        if (globalData == null || (bVar = (bn.b) globalData.getValue()) == null || bVar.a() == null) {
            return;
        }
        bVar.a().commentCount.set(i3);
        globalData.postValue(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G2(final UIStateData<List<QZMomentMeta$StComment>> uIStateData) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.qzmoment.comment.QZMCommentBusinessViewModel.1
            @Override // java.lang.Runnable
            public void run() {
                if (QZMCommentBusinessViewModel.this.f58807i == null) {
                    return;
                }
                QZMCommentBusinessViewModel.this.f58807i.postValue(uIStateData);
            }
        });
    }

    private void K2(int i3, int i16, QZMomentMeta$StFeed qZMomentMeta$StFeed, QZMomentMeta$StComment qZMomentMeta$StComment) {
        VSNetworkHelper.getInstance().sendRequest(i16, new QZMDoCommentRequest(qZMomentMeta$StFeed, qZMomentMeta$StComment, i3), new b(qZMomentMeta$StFeed, i3, i16, qZMomentMeta$StComment));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M2(String str, String str2, boolean z16, boolean z17) {
        if (this.D.get(str) != null) {
            if (z17) {
                this.D.get(str).f58837a = z16;
                this.D.get(str).f58838b = str2;
                return;
            }
            return;
        }
        d dVar = new d();
        dVar.f58838b = str2;
        dVar.f58837a = z16;
        dVar.f58839c = true;
        this.D.put(str, dVar);
        QLog.d("QFSCommentBusiness", 1, "getDetailCommentSize: feedAttachInfo:" + str2);
    }

    private void N2(QZMomentMeta$StFeed qZMomentMeta$StFeed, QZMomentMeta$StComment qZMomentMeta$StComment, QZMomentMeta$StReply qZMomentMeta$StReply) {
        List<QZMomentMeta$StReply> list;
        ArrayList<QZMomentMeta$StComment> o26 = o2(qZMomentMeta$StFeed.f430362id.get());
        if (o26 != null && !o26.isEmpty()) {
            int i3 = 0;
            while (true) {
                if (i3 >= o26.size()) {
                    break;
                }
                QZMomentMeta$StComment qZMomentMeta$StComment2 = o26.get(i3);
                if (qZMomentMeta$StComment2 == null || !TextUtils.equals(qZMomentMeta$StComment.f430361id.get(), qZMomentMeta$StComment2.f430361id.get()) || (list = qZMomentMeta$StComment2.vecReply.get()) == null || list.isEmpty()) {
                    i3++;
                } else {
                    for (int i16 = 0; i16 < list.size(); i16++) {
                        QZMomentMeta$StReply qZMomentMeta$StReply2 = list.get(i16);
                        if (qZMomentMeta$StReply2 != null && TextUtils.equals(qZMomentMeta$StReply2.f430366id.get(), ISelectMemberActivityConstants.FAKE_ID)) {
                            o26.get(i3).vecReply.get(i16).set(qZMomentMeta$StReply);
                        }
                    }
                }
            }
            this.f58808m.put(qZMomentMeta$StFeed.f430362id.get(), o26);
            G2(UIStateData.obtainSuccess(true).setFinish(!E2(p2(qZMomentMeta$StFeed.f430362id.get()))).setDataList(o26));
            en.a.a().initOrUpdateGlobalState((en.a) new QZMFeedCommentInfo(qZMomentMeta$StFeed, q2(qZMomentMeta$StFeed)), true);
            return;
        }
        QLog.e("QFSCommentBusiness", 1, "comment list is null");
    }

    private void O2(QZMomentMeta$StFeed qZMomentMeta$StFeed, QZMomentMeta$StComment qZMomentMeta$StComment) {
        ArrayList<QZMomentMeta$StComment> o26 = o2(qZMomentMeta$StFeed.f430362id.get());
        if (o26 != null && !o26.isEmpty()) {
            int i3 = 0;
            while (true) {
                if (i3 >= o26.size()) {
                    break;
                }
                QZMomentMeta$StComment qZMomentMeta$StComment2 = o26.get(i3);
                if (qZMomentMeta$StComment2 != null && TextUtils.equals(qZMomentMeta$StComment2.f430361id.get(), ISelectMemberActivityConstants.FAKE_ID)) {
                    o26.set(i3, qZMomentMeta$StComment);
                    break;
                }
                i3++;
            }
            this.f58808m.put(qZMomentMeta$StFeed.f430362id.get(), o26);
            G2(UIStateData.obtainSuccess(true).setFinish(!E2(p2(qZMomentMeta$StFeed.f430362id.get()))).setDataList(o26));
            en.a.a().initOrUpdateGlobalState((en.a) new QZMFeedCommentInfo(qZMomentMeta$StFeed, q2(qZMomentMeta$StFeed)), true);
            return;
        }
        QLog.e("QFSCommentBusiness", 1, "comment list is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q2(String str, boolean z16) {
        Map<String, d> map = this.D;
        if (map == null || map.get(str) == null) {
            return;
        }
        this.D.get(str).f58839c = z16;
    }

    private void f2(QZMomentMeta$StFeed qZMomentMeta$StFeed, QZMomentMeta$StComment qZMomentMeta$StComment, QZMomentMeta$StReply qZMomentMeta$StReply, QZMomentMeta$StReply qZMomentMeta$StReply2) {
        ArrayList<QZMomentMeta$StComment> o26 = o2(qZMomentMeta$StFeed.f430362id.get());
        if (o26 != null && !o26.isEmpty()) {
            int i3 = 0;
            int i16 = 0;
            while (true) {
                if (i16 >= o26.size()) {
                    break;
                }
                QZMomentMeta$StComment qZMomentMeta$StComment2 = o26.get(i16);
                if (qZMomentMeta$StComment2 != null && TextUtils.equals(qZMomentMeta$StComment.f430361id.get(), qZMomentMeta$StComment2.f430361id.get())) {
                    List<QZMomentMeta$StReply> list = qZMomentMeta$StComment2.vecReply.get();
                    if (list == null || list.isEmpty() || qZMomentMeta$StReply2 == null) {
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, qZMomentMeta$StReply);
                        o26.get(i16).vecReply.set(list);
                    } else {
                        while (true) {
                            if (i3 >= list.size()) {
                                break;
                            }
                            QZMomentMeta$StReply qZMomentMeta$StReply3 = list.get(i3);
                            if (qZMomentMeta$StReply3 != null && TextUtils.equals(qZMomentMeta$StReply3.f430366id.get(), qZMomentMeta$StReply2.f430366id.get())) {
                                list.add(i3 + 1, qZMomentMeta$StReply);
                                break;
                            }
                            i3++;
                        }
                    }
                } else {
                    i16++;
                }
            }
            this.f58808m.put(qZMomentMeta$StFeed.f430362id.get(), o26);
            G2(UIStateData.obtainSuccess(true).setFinish(!E2(p2(qZMomentMeta$StFeed.f430362id.get()))).setDataList(o26));
            en.a.a().initOrUpdateGlobalState((en.a) new QZMFeedCommentInfo(qZMomentMeta$StFeed, qZMomentMeta$StFeed.commentCount.get() + 1), true);
            return;
        }
        QLog.e("QFSCommentBusiness", 1, "comment list is null");
    }

    private void g2(QZMomentMeta$StFeed qZMomentMeta$StFeed, QZMomentMeta$StComment qZMomentMeta$StComment) {
        ArrayList<QZMomentMeta$StComment> o26 = o2(qZMomentMeta$StFeed.f430362id.get());
        if (o26 == null) {
            QLog.e("QFSCommentBusiness", 1, "comment list is null");
            return;
        }
        o26.add(0, qZMomentMeta$StComment);
        this.f58808m.put(qZMomentMeta$StFeed.f430362id.get(), o26);
        G2(UIStateData.obtainSuccess(true).setFinish(!E2(p2(qZMomentMeta$StFeed.f430362id.get()))).setUpTurning(true).setDataList(o26));
        en.a.a().initOrUpdateGlobalState((en.a) new QZMFeedCommentInfo(qZMomentMeta$StFeed, qZMomentMeta$StFeed.commentCount.get() + 1), true);
    }

    private void i2(QZMomentMeta$StFeed qZMomentMeta$StFeed, QZMomentMeta$StComment qZMomentMeta$StComment) {
        ArrayList<QZMomentMeta$StComment> o26 = o2(qZMomentMeta$StFeed.f430362id.get());
        if (o26 != null && !o26.isEmpty()) {
            int i3 = 0;
            while (true) {
                if (i3 >= o26.size()) {
                    break;
                }
                if (TextUtils.equals(qZMomentMeta$StComment.f430361id.get(), o26.get(i3).f430361id.get())) {
                    o26.remove(i3);
                    break;
                }
                i3++;
            }
            this.f58808m.put(qZMomentMeta$StFeed.f430362id.get(), o26);
            G2(UIStateData.obtainSuccess(true).setFinish(!E2(p2(qZMomentMeta$StFeed.f430362id.get()))).setDataList(o26));
            en.a.a().initOrUpdateGlobalState((en.a) new QZMFeedCommentInfo(qZMomentMeta$StFeed, q2(qZMomentMeta$StFeed)), true);
            return;
        }
        QLog.e("QFSCommentBusiness", 1, "comment list is null");
    }

    private d p2(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.D.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r2(QZMomentMeta$StFeed qZMomentMeta$StFeed, QZMomentMeta$StComment qZMomentMeta$StComment, QZMomentMeta$StReply qZMomentMeta$StReply, QZMomentWriter$StDoReplyRsp qZMomentWriter$StDoReplyRsp) {
        QLog.e("QFSCommentBusiness", 1, "addCommentReply Success");
        qZMomentMeta$StReply.f430366id.set(qZMomentWriter$StDoReplyRsp.reply.f430366id.get());
        qZMomentMeta$StReply.createTime.set(qZMomentWriter$StDoReplyRsp.reply.createTime.get());
        qZMomentMeta$StReply.likeInfo.set(qZMomentWriter$StDoReplyRsp.reply.likeInfo.get());
        qZMomentWriter$StDoReplyRsp.reply.set(qZMomentMeta$StReply);
        P2(qZMomentMeta$StFeed.f430362id.get(), q2(qZMomentMeta$StFeed) + 1);
        N2(qZMomentMeta$StFeed, qZMomentMeta$StComment, qZMomentMeta$StReply);
        F2(qZMomentMeta$StFeed, q2(qZMomentMeta$StFeed));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t2(QZMomentReader$StGetCommentListRsp qZMomentReader$StGetCommentListRsp, QZMomentMeta$StFeed qZMomentMeta$StFeed, boolean z16) {
        if (qZMomentMeta$StFeed == null) {
            QLog.i("QFSCommentBusiness", 1, "getComments load more feed == null");
            return;
        }
        ArrayList<QZMomentMeta$StComment> o26 = o2(qZMomentMeta$StFeed.f430362id.get());
        if (o26 != null) {
            QLog.d("QFSCommentBusiness", 2, "getCommentSize:" + qZMomentReader$StGetCommentListRsp.vecComment.size() + ", attachInfo:" + qZMomentReader$StGetCommentListRsp.feedAttchInfo.get() + "isFinish\uff1a" + qZMomentReader$StGetCommentListRsp.isFinish.get());
            o26.addAll(qZMomentReader$StGetCommentListRsp.vecComment.get());
        }
        en.a.a().initOrUpdateGlobalState((en.a) new QZMFeedCommentInfo(qZMomentMeta$StFeed, q2(qZMomentMeta$StFeed)), true);
        G2(UIStateData.obtainSuccess(z16).setFinish(qZMomentReader$StGetCommentListRsp.isFinish.get() > 0).setDataList(o26).setLoadMore(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u2(QZMomentReader$StGetCommentListRsp qZMomentReader$StGetCommentListRsp, QZMomentMeta$StFeed qZMomentMeta$StFeed, boolean z16) {
        if (qZMomentMeta$StFeed == null) {
            QLog.i("QFSCommentBusiness", 1, "getComments refresh feed == null");
            return;
        }
        String str = qZMomentMeta$StFeed.f430362id.get();
        String str2 = qZMomentReader$StGetCommentListRsp.permissionText.get();
        PBRepeatMessageField<QZMomentMeta$StComment> pBRepeatMessageField = qZMomentReader$StGetCommentListRsp.vecComment;
        ArrayList<QZMomentMeta$StComment> arrayList = (pBRepeatMessageField == null || pBRepeatMessageField.size() <= 0) ? null : (ArrayList) qZMomentReader$StGetCommentListRsp.vecComment.get();
        P2(str, qZMomentReader$StGetCommentListRsp.totalNum.get());
        if (arrayList == null) {
            arrayList = new ArrayList<>(0);
        }
        this.f58808m.put(str, arrayList);
        if (q2(qZMomentMeta$StFeed) == 0) {
            QLog.e("QFSCommentBusiness", 1, "\u540e\u53f0\u8fd4\u56de\u8bc4\u8bba\u6570\u4e3a0");
        }
        if (arrayList.isEmpty()) {
            G2(UIStateData.obtainEmpty().setDataList(arrayList).setFinish(qZMomentReader$StGetCommentListRsp.isFinish.get() > 0).setLoadMore(false));
        }
        G2(UIStateData.obtainSuccess(z16).setDataList(arrayList).setFinish(qZMomentReader$StGetCommentListRsp.isFinish.get() > 0).setLoadMore(false));
        QLog.d("QFSCommentBusiness", 1, "permission text is " + str2);
        en.a.a().initOrUpdateGlobalState((en.a) new QZMFeedCommentInfo(qZMomentMeta$StFeed, q2(qZMomentMeta$StFeed), str2), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v2(final QZMomentReader$StGetCommentListRsp qZMomentReader$StGetCommentListRsp, final QZMomentMeta$StFeed qZMomentMeta$StFeed, final boolean z16, final boolean z17) {
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.qzone.reborn.qzmoment.comment.QZMCommentBusinessViewModel.3
            @Override // java.lang.Runnable
            public void run() {
                QLog.d("QFSCommentBusiness", 1, "handleCommentResponse Success  isLoadMore:" + z16);
                QZMCommentBusinessViewModel.this.Q2(qZMomentMeta$StFeed.f430362id.get(), true);
                QZMCommentBusinessViewModel.this.M2(qZMomentMeta$StFeed.f430362id.get(), qZMomentReader$StGetCommentListRsp.feedAttchInfo.get(), qZMomentReader$StGetCommentListRsp.isFinish.get() == 0, z16);
                if (z16) {
                    QZMCommentBusinessViewModel.this.t2(qZMomentReader$StGetCommentListRsp, qZMomentMeta$StFeed, z17);
                } else {
                    QZMCommentBusinessViewModel.this.u2(qZMomentReader$StGetCommentListRsp, qZMomentMeta$StFeed, z17);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w2(QZMomentMeta$StFeed qZMomentMeta$StFeed, QZMomentMeta$StComment qZMomentMeta$StComment, QZMomentMeta$StReply qZMomentMeta$StReply, QZMomentWriter$StDoReplyRsp qZMomentWriter$StDoReplyRsp) {
        QLog.e("QFSCommentBusiness", 1, "deleteCommentReply Success");
        qZMomentWriter$StDoReplyRsp.reply.f430366id.set(qZMomentMeta$StReply.f430366id.get());
        P2(qZMomentMeta$StFeed.f430362id.get(), q2(qZMomentMeta$StFeed) - 1);
        j2(qZMomentMeta$StFeed, qZMomentMeta$StComment, qZMomentMeta$StReply);
        F2(qZMomentMeta$StFeed, q2(qZMomentMeta$StFeed));
        ToastUtil.o(R.string.f133285p, 5);
    }

    public ArrayList<QZMomentMeta$StComment> C2(String str) {
        if (o2(str) == null) {
            return new ArrayList<>();
        }
        return o2(str);
    }

    public void J2(int i3, int i16, QZMomentMeta$StFeed qZMomentMeta$StFeed, QZMomentMeta$StComment qZMomentMeta$StComment, QZMomentMeta$StReply qZMomentMeta$StReply) {
        VSNetworkHelper.getInstance().sendRequest(i16, new QZMDoReplyRequest(qZMomentMeta$StFeed, qZMomentMeta$StComment, qZMomentMeta$StReply, i3), new c(i3, i16, qZMomentMeta$StFeed, qZMomentMeta$StComment, qZMomentMeta$StReply));
    }

    public void P2(String str, int i3) {
        this.C.put(str, Integer.valueOf(i3));
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return null;
    }

    public String m2(String str) {
        d dVar;
        String str2;
        if (!TextUtils.isEmpty(str) && (dVar = this.D.get(str)) != null) {
            if (dVar.f58839c && dVar.f58837a && (str2 = dVar.f58838b) != null) {
                return str2;
            }
            QLog.i("QFSCommentBusiness", 1, dVar.toString());
        }
        return null;
    }

    public MutableLiveData<UIStateData<List<QZMomentMeta$StComment>>> n2() {
        return this.f58807i;
    }

    public ArrayList<QZMomentMeta$StComment> o2(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f58808m.get(str);
    }

    public int q2(QZMomentMeta$StFeed qZMomentMeta$StFeed) {
        Integer num = this.C.get(qZMomentMeta$StFeed.f430362id.get());
        if (num != null) {
            return num.intValue();
        }
        return qZMomentMeta$StFeed.commentCount.get();
    }

    public void H2(int i3, QZMomentMeta$StFeed qZMomentMeta$StFeed, boolean z16) {
        String str;
        if (qZMomentMeta$StFeed == null) {
            QLog.i("QFSCommentBusiness", 1, "getComments  feed == null");
            return;
        }
        if (z16) {
            str = m2(qZMomentMeta$StFeed.f430362id.get());
            if (str == null) {
                QLog.e("QFSCommentBusiness", 1, "getComments loadMore , attachInfo is null ");
                return;
            }
            QLog.i("QFSCommentBusiness", 1, "getComments, feedAttachInfo:" + str);
        } else {
            str = null;
        }
        this.f58807i.postValue(UIStateData.obtainLoading());
        I2(i3, qZMomentMeta$StFeed, str, z16);
        Q2(qZMomentMeta$StFeed.f430362id.get(), false);
    }

    public void k2(int i3, QZMomentMeta$StFeed qZMomentMeta$StFeed, QZMomentMeta$StComment qZMomentMeta$StComment, QZMomentMeta$StReply qZMomentMeta$StReply) {
        if (qZMomentMeta$StFeed != null && qZMomentMeta$StComment != null && qZMomentMeta$StReply != null) {
            if (qZMomentMeta$StReply.f430366id.get().startsWith(ISelectMemberActivityConstants.FAKE_ID)) {
                QLog.d("QFSCommentBusiness", 1, "delete fake reply");
                j2(qZMomentMeta$StFeed, qZMomentMeta$StComment, qZMomentMeta$StReply);
                return;
            } else {
                J2(i3, this.contextHashCode, qZMomentMeta$StFeed, qZMomentMeta$StComment, qZMomentMeta$StReply);
                return;
            }
        }
        QLog.e("QFSCommentBusiness", 1, "feed or comment or reply is null");
    }

    public void l2(int i3, int i16, QZMomentMeta$StFeed qZMomentMeta$StFeed, QZMomentMeta$StComment qZMomentMeta$StComment) {
        if (qZMomentMeta$StFeed != null && qZMomentMeta$StComment != null) {
            if (qZMomentMeta$StComment.f430361id.get().startsWith(ISelectMemberActivityConstants.FAKE_ID)) {
                QLog.d("QFSCommentBusiness", 1, "delete fake comment");
                i2(qZMomentMeta$StFeed, qZMomentMeta$StComment);
                return;
            } else {
                K2(i3, i16, qZMomentMeta$StFeed, qZMomentMeta$StComment);
                return;
            }
        }
        QLog.e("QFSCommentBusiness", 1, "feed or comment is null");
    }

    private void I2(int i3, QZMomentMeta$StFeed qZMomentMeta$StFeed, String str, boolean z16) {
        if (qZMomentMeta$StFeed == null) {
            QLog.i("QFSCommentBusiness", 1, "getComments  feed == null");
            return;
        }
        QZMGetCommentListRequest qZMGetCommentListRequest = new QZMGetCommentListRequest(qZMomentMeta$StFeed, str);
        qZMGetCommentListRequest.setEnableCache(false);
        VSNetworkHelper.getInstance().sendRequest(i3, qZMGetCommentListRequest, new a(qZMomentMeta$StFeed, z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s2(QZMomentMeta$StFeed qZMomentMeta$StFeed, QZMomentMeta$StComment qZMomentMeta$StComment, QZMomentWriter$StDoCommentRsp qZMomentWriter$StDoCommentRsp) {
        if (qZMomentWriter$StDoCommentRsp == null) {
            return;
        }
        qZMomentMeta$StComment.f430361id.set(qZMomentWriter$StDoCommentRsp.comment.f430361id.get());
        qZMomentMeta$StComment.createTime.set(qZMomentWriter$StDoCommentRsp.comment.createTime.get());
        qZMomentMeta$StComment.likeInfo.set(qZMomentWriter$StDoCommentRsp.comment.likeInfo.get());
        qZMomentWriter$StDoCommentRsp.comment.set(qZMomentMeta$StComment);
        P2(qZMomentMeta$StFeed.f430362id.get(), q2(qZMomentMeta$StFeed) + 1);
        O2(qZMomentMeta$StFeed, qZMomentMeta$StComment);
        F2(qZMomentMeta$StFeed, q2(qZMomentMeta$StFeed));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x2(QZMomentMeta$StFeed qZMomentMeta$StFeed, QZMomentMeta$StComment qZMomentMeta$StComment, QZMomentWriter$StDoCommentRsp qZMomentWriter$StDoCommentRsp) {
        if (qZMomentWriter$StDoCommentRsp == null) {
            return;
        }
        QLog.d("QFSCommentBusiness", 1, "deleteFeedComment Success");
        qZMomentWriter$StDoCommentRsp.comment.f430361id.set(qZMomentMeta$StComment.f430361id.get());
        P2(qZMomentMeta$StFeed.f430362id.get(), (q2(qZMomentMeta$StFeed) - 1) - qZMomentMeta$StComment.vecReply.size());
        i2(qZMomentMeta$StFeed, qZMomentMeta$StComment);
        F2(qZMomentMeta$StFeed, q2(qZMomentMeta$StFeed));
        ToastUtil.o(R.string.f133265n, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y2(int i3, int i16, QZMomentMeta$StFeed qZMomentMeta$StFeed, QZMomentMeta$StComment qZMomentMeta$StComment) {
        if (i3 == 1) {
            i2(qZMomentMeta$StFeed, qZMomentMeta$StComment);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z2(int i3, int i16, QZMomentMeta$StFeed qZMomentMeta$StFeed, QZMomentMeta$StComment qZMomentMeta$StComment, QZMomentMeta$StReply qZMomentMeta$StReply) {
        if (i3 == 1) {
            j2(qZMomentMeta$StFeed, qZMomentMeta$StComment, qZMomentMeta$StReply);
        }
    }

    public void D2(int i3, QZMomentMeta$StFeed qZMomentMeta$StFeed, boolean z16) {
        if (qZMomentMeta$StFeed == null) {
            return;
        }
        if (o2(qZMomentMeta$StFeed.f430362id.get()) == null) {
            QLog.d("QFSCommentBusiness", 1, "comments not contains in map");
            H2(i3, qZMomentMeta$StFeed, z16);
        } else {
            G2(UIStateData.obtainSuccess(true).setFinish(!E2(p2(r0))).setLoadMore(false));
        }
    }

    private boolean E2(d dVar) {
        if (dVar == null) {
            return false;
        }
        return dVar.f58837a;
    }

    private void j2(QZMomentMeta$StFeed qZMomentMeta$StFeed, QZMomentMeta$StComment qZMomentMeta$StComment, QZMomentMeta$StReply qZMomentMeta$StReply) {
        if (qZMomentMeta$StComment == null || qZMomentMeta$StReply == null) {
            return;
        }
        String str = qZMomentMeta$StComment.f430361id.get();
        String str2 = qZMomentMeta$StReply.f430366id.get();
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        ArrayList<QZMomentMeta$StComment> o26 = o2(qZMomentMeta$StFeed.f430362id.get());
        if (o26 != null && !o26.isEmpty()) {
            int i3 = 0;
            int i16 = 0;
            while (true) {
                if (i16 >= o26.size()) {
                    break;
                }
                QZMomentMeta$StComment qZMomentMeta$StComment2 = o26.get(i16);
                if (qZMomentMeta$StComment2 != null && TextUtils.equals(qZMomentMeta$StComment2.f430361id.get(), str)) {
                    List<QZMomentMeta$StReply> list = qZMomentMeta$StComment2.vecReply.get();
                    while (true) {
                        if (i3 >= list.size()) {
                            break;
                        }
                        QZMomentMeta$StReply qZMomentMeta$StReply2 = list.get(i3);
                        if (qZMomentMeta$StReply2 != null && TextUtils.equals(str2, qZMomentMeta$StReply2.f430366id.get())) {
                            o26.get(i16).vecReply.remove(i3);
                            break;
                        }
                        i3++;
                    }
                } else {
                    i16++;
                }
            }
            this.f58808m.put(qZMomentMeta$StFeed.f430362id.get(), o26);
            G2(UIStateData.obtainSuccess(true).setFinish(!E2(p2(qZMomentMeta$StFeed.f430362id.get()))).setDataList(o26));
            en.a.a().initOrUpdateGlobalState((en.a) new QZMFeedCommentInfo(qZMomentMeta$StFeed, qZMomentMeta$StFeed.commentCount.get()), true);
            return;
        }
        QLog.e("QFSCommentBusiness", 1, "comment list is null");
    }

    public void h2(int i3, QZMomentMeta$StFeed qZMomentMeta$StFeed, QZMomentMeta$StComment qZMomentMeta$StComment) {
        if (qZMomentMeta$StFeed != null && qZMomentMeta$StComment != null) {
            g2(qZMomentMeta$StFeed, qZMomentMeta$StComment);
            K2(1, i3, qZMomentMeta$StFeed, qZMomentMeta$StComment);
        } else {
            QLog.e("QFSCommentBusiness", 1, "feed or comment is null");
        }
    }

    public void e2(int i3, QZMomentMeta$StFeed qZMomentMeta$StFeed, QZMomentMeta$StComment qZMomentMeta$StComment, QZMomentMeta$StReply qZMomentMeta$StReply, QZMomentMeta$StReply qZMomentMeta$StReply2) {
        if (qZMomentMeta$StFeed != null && qZMomentMeta$StComment != null && qZMomentMeta$StReply != null) {
            f2(qZMomentMeta$StFeed, qZMomentMeta$StComment, qZMomentMeta$StReply, qZMomentMeta$StReply2);
            J2(1, i3, qZMomentMeta$StFeed, qZMomentMeta$StComment, qZMomentMeta$StReply);
        } else {
            QLog.e("QFSCommentBusiness", 1, "feed or comment or reply is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class c implements VSDispatchObserver.OnVSRspCallBack<QZMomentWriter$StDoReplyRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f58831a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f58832b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ QZMomentMeta$StFeed f58833c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QZMomentMeta$StComment f58834d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QZMomentMeta$StReply f58835e;

        c(int i3, int i16, QZMomentMeta$StFeed qZMomentMeta$StFeed, QZMomentMeta$StComment qZMomentMeta$StComment, QZMomentMeta$StReply qZMomentMeta$StReply) {
            this.f58831a = i3;
            this.f58832b = i16;
            this.f58833c = qZMomentMeta$StFeed;
            this.f58834d = qZMomentMeta$StComment;
            this.f58835e = qZMomentMeta$StReply;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QZMomentWriter$StDoReplyRsp qZMomentWriter$StDoReplyRsp) {
            if (z16 && j3 == 0 && qZMomentWriter$StDoReplyRsp != null) {
                QZMCommentBusinessViewModel.this.B2(this.f58831a, this.f58833c, this.f58834d, this.f58835e, qZMomentWriter$StDoReplyRsp);
                return;
            }
            QLog.e("QFSCommentBusiness", 1, "addCommentReply error:" + j3 + "  errorMsg:" + str);
            QZMCommentBusinessViewModel.this.z2(this.f58831a, this.f58832b, this.f58833c, this.f58834d, this.f58835e);
            QZMCommentBusinessViewModel.this.L2(j3, this.f58831a == 1 ? R.string.f133325t : R.string.f133275o);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L2(long j3, int i3) {
        if (j3 == 10014) {
            ToastUtil.o(R.string.f133215i, 4);
        } else if (!NetworkUtil.isNetworkAvailable(MobileQQ.sMobileQQ)) {
            ToastUtil.o(R.string.f1338579, 4);
        } else {
            ToastUtil.o(i3, 4);
        }
    }
}
