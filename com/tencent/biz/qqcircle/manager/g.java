package com.tencent.biz.qqcircle.manager;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.beans.QFSFastShareUserInfo;
import com.tencent.biz.qqcircle.immersive.request.QFSFastShareSecondaryLoadRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.api.IRelationNTRecentListApi;
import com.tencent.relation.common.nt.listener.RecentContactListener;
import feedcloud.FeedCloudRead$QuickShareUser;
import feedcloud.FeedCloudRead$StFeedDeatilSecondaryLoadRsp;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes4.dex */
public class g {

    /* renamed from: e, reason: collision with root package name */
    private static boolean f91562e = true;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f91563f;

    /* renamed from: a, reason: collision with root package name */
    private int f91564a = -1;

    /* renamed from: b, reason: collision with root package name */
    private final List<Integer> f91565b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private String f91566c;

    /* renamed from: d, reason: collision with root package name */
    private a f91567d;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface a {
        void a(QFSFastShareUserInfo qFSFastShareUserInfo);
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class b implements RecentContactListener {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<g> f91568a;

        public b(g gVar) {
            this.f91568a = new WeakReference<>(gVar);
        }

        @Override // com.tencent.relation.common.nt.listener.RecentContactListener
        public void onResult(@NotNull List<RecentUser> list) {
            String str;
            if (this.f91568a.get() == null) {
                return;
            }
            if (list.isEmpty()) {
                QLog.d("QFSBottomFastShareManager", 1, "[getRecentChat] null");
                this.f91568a.get().e();
                return;
            }
            QLog.d("QFSBottomFastShareManager", 1, "[getRecentChat] success");
            RecentUser recentUser = list.get(0);
            if (recentUser.getType() == 1) {
                str = recentUser.troopUin;
            } else {
                str = recentUser.uin;
            }
            this.f91568a.get().s(new QFSFastShareUserInfo(recentUser.displayName, str, recentUser.getType()));
        }
    }

    public g(String str) {
        this.f91566c = str;
    }

    public static boolean d(int i3) {
        if (!q() && (!p() || !o(i3))) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        int i3 = this.f91564a + 1;
        this.f91564a = i3;
        if (i3 < this.f91565b.size()) {
            f(this.f91565b.get(this.f91564a).intValue());
        } else {
            QLog.d("QFSBottomFastShareManager", 1, "[exeNextGetShareUserTask] exeOrder end.");
            s(null);
        }
    }

    private void f(int i3) {
        switch (i3) {
            case 1000:
                j();
                return;
            case 1001:
                k();
                return;
            case 1002:
                g();
                return;
            default:
                e();
                return;
        }
    }

    private void g() {
        String h16 = uq3.k.a().h("sp_key_fast_share_user_from_rsp", "");
        if (TextUtils.isEmpty(h16)) {
            QLog.d("QFSBottomFastShareManager", 1, "[getIntimateUser] null");
            e();
        } else {
            QLog.d("QFSBottomFastShareManager", 1, "[getIntimateUser] success");
            s(QFSFastShareUserInfo.transferShareInfoFromString(h16));
        }
    }

    private void h() {
        if (!f91562e) {
            QLog.e("QFSBottomFastShareManager", 1, "[getNewExperiment] is requested");
            return;
        }
        f91562e = false;
        final QFSFastShareSecondaryLoadRequest qFSFastShareSecondaryLoadRequest = new QFSFastShareSecondaryLoadRequest();
        VSNetworkHelper.getInstance().sendRequest(qFSFastShareSecondaryLoadRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.manager.f
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                g.this.r(qFSFastShareSecondaryLoadRequest, baseRequest, z16, j3, str, (FeedCloudRead$StFeedDeatilSecondaryLoadRsp) obj);
            }
        });
    }

    private List<Integer> i() {
        h();
        ArrayList arrayList = new ArrayList();
        if (!f91563f) {
            f91563f = uq3.k.a().c("sp_key_fast_share_experiment", false);
        }
        if (f91563f) {
            QLog.d("QFSBottomFastShareManager", 1, "[getOrder] is new experiment");
            arrayList.add(1001);
            arrayList.add(1002);
            arrayList.add(1000);
            return arrayList;
        }
        QLog.d("QFSBottomFastShareManager", 1, "[getOrder] is old experiment");
        arrayList.add(1001);
        arrayList.add(1000);
        arrayList.add(1002);
        return arrayList;
    }

    private void j() {
        ((IRelationNTRecentListApi) QRoute.api(IRelationNTRecentListApi.class)).getRecentList(QCircleServiceImpl.getAppRunTime(), new b(this), false);
    }

    private void k() {
        String h16 = uq3.k.a().h(QFSFastShareUserInfo.SP_KEY_FAST_SHARE_USER_INFO, "");
        if (TextUtils.isEmpty(h16)) {
            QLog.d("QFSBottomFastShareManager", 1, "[getRecentShare] null");
            e();
        } else {
            QLog.d("QFSBottomFastShareManager", 1, "[getRecentShare] success");
            s(QFSFastShareUserInfo.transferShareInfoFromString(h16));
        }
    }

    private QFSFastShareUserInfo m(FeedCloudRead$StFeedDeatilSecondaryLoadRsp feedCloudRead$StFeedDeatilSecondaryLoadRsp) {
        if (feedCloudRead$StFeedDeatilSecondaryLoadRsp == null) {
            return null;
        }
        if (feedCloudRead$StFeedDeatilSecondaryLoadRsp.quick_share.users.get().isEmpty()) {
            QLog.d("QFSBottomFastShareManager", 1, "[getShareUserFromRsp] null");
            return null;
        }
        FeedCloudRead$QuickShareUser feedCloudRead$QuickShareUser = feedCloudRead$StFeedDeatilSecondaryLoadRsp.quick_share.users.get(0);
        QLog.d("QFSBottomFastShareManager", 1, "[getShareUserFromRsp] success");
        return new QFSFastShareUserInfo(feedCloudRead$QuickShareUser.name.get(), feedCloudRead$QuickShareUser.uin.get(), feedCloudRead$QuickShareUser.type.get());
    }

    public static long n() {
        long currentTimeMillis = System.currentTimeMillis();
        return currentTimeMillis - ((TimeZone.getDefault().getRawOffset() + currentTimeMillis) % 86400000);
    }

    public static boolean o(int i3) {
        int i16 = -4;
        int e16 = uq3.k.a().e("sp_key_fast_share_view_show_pos", -4);
        QLog.d("QFSBottomFastShareManager", 1, "[isGapPermit] lastPos: " + e16 + " , currPos: " + i3);
        if (i3 > e16) {
            i16 = e16;
        }
        if (i3 - i16 > 3) {
            return true;
        }
        return false;
    }

    public static boolean p() {
        if (uq3.k.a().e("sp_key_fast_share_view_show_times", 0) >= 6) {
            return false;
        }
        return true;
    }

    public static boolean q() {
        if (n() - uq3.k.a().f("sp_key_fast_share_view_show_timestamp", 0L) >= 86400000) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(QFSFastShareSecondaryLoadRequest qFSFastShareSecondaryLoadRequest, BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StFeedDeatilSecondaryLoadRsp feedCloudRead$StFeedDeatilSecondaryLoadRsp) {
        QLog.d("QFSBottomFastShareManager", 1, "[getIntimateUserReq] onReceive: dispatch Success:" + z16 + " | TraceId:" + qFSFastShareSecondaryLoadRequest.getTraceId() + " | SeqId:" + qFSFastShareSecondaryLoadRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str + " | isCache:" + VSNetworkHelper.isProtocolCache(str));
        if (z16 && j3 == 0 && feedCloudRead$StFeedDeatilSecondaryLoadRsp != null) {
            f91563f = feedCloudRead$StFeedDeatilSecondaryLoadRsp.quick_share.use_recom.get();
            uq3.k.a().j("sp_key_fast_share_experiment", f91563f);
            QFSFastShareUserInfo m3 = m(feedCloudRead$StFeedDeatilSecondaryLoadRsp);
            if (m3 != null) {
                QLog.d("QFSBottomFastShareManager", 1, "get share user from rsp");
                uq3.k.a().p("sp_key_fast_share_user_from_rsp", QFSFastShareUserInfo.transferShareInfoToString(m3));
            } else {
                QLog.d("QFSBottomFastShareManager", 1, "no share user from rsp");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(QFSFastShareUserInfo qFSFastShareUserInfo) {
        a aVar = this.f91567d;
        if (aVar == null) {
            return;
        }
        aVar.a(qFSFastShareUserInfo);
    }

    public static void u(int i3) {
        if (q()) {
            uq3.k.a().n("sp_key_fast_share_view_show_timestamp", n());
            uq3.k.a().m("sp_key_fast_share_view_show_times", 1);
            uq3.k.a().m("sp_key_fast_share_view_show_pos", i3);
        } else {
            if (i3 == uq3.k.a().e("sp_key_fast_share_view_show_pos", -4)) {
                return;
            }
            int e16 = uq3.k.a().e("sp_key_fast_share_view_show_times", 0) + 1;
            uq3.k.a().m("sp_key_fast_share_view_show_times", e16);
            uq3.k.a().m("sp_key_fast_share_view_show_pos", i3);
            QLog.d("QFSBottomFastShareManager", 1, "current show times: " + e16);
        }
    }

    public void l(a aVar) {
        if (!this.f91566c.equals("pg_xsj_explore_page")) {
            QLog.d("QFSBottomFastShareManager", 1, "[getShareUser] pageId: " + this.f91566c);
            aVar.a(null);
            return;
        }
        this.f91565b.clear();
        this.f91565b.addAll(i());
        if (this.f91565b.isEmpty()) {
            QLog.d("QFSBottomFastShareManager", 1, "[getShareUser] mExeOrder size: " + this.f91565b.size());
            aVar.a(null);
            return;
        }
        this.f91567d = aVar;
        e();
    }

    public void t() {
        this.f91565b.clear();
        this.f91564a = -1;
        this.f91566c = "";
        this.f91567d = null;
    }
}
