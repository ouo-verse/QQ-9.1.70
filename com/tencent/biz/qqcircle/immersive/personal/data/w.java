package com.tencent.biz.qqcircle.immersive.personal.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSPersonalBasicRequestEvent;
import com.tencent.biz.qqcircle.immersive.utils.af;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StMedalInfo;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudRead$StGetMainPageBasicDataRsp;
import feedcloud.FeedCloudRead$StGetMainPageCommDataRsp;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import qqcircle.QQCircleBase$StUserBusiData;
import qqcircle.QQCircleFeedBase$StMainPageBasicBusiRspData;
import qqcircle.QQCircleProfile$StProfileBizData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class w implements a {

    /* renamed from: a, reason: collision with root package name */
    protected final ConcurrentHashMap<String, Long> f88581a;

    /* renamed from: b, reason: collision with root package name */
    private final y f88582b;

    /* renamed from: c, reason: collision with root package name */
    private final s f88583c;

    /* renamed from: d, reason: collision with root package name */
    private final n f88584d;

    /* renamed from: e, reason: collision with root package name */
    private final k f88585e;

    /* renamed from: f, reason: collision with root package name */
    private final f f88586f;

    /* renamed from: g, reason: collision with root package name */
    private String f88587g;

    /* renamed from: h, reason: collision with root package name */
    private long f88588h;

    public w() {
        this.f88587g = "";
        this.f88588h = 0L;
        this.f88581a = new ConcurrentHashMap<>();
        this.f88582b = new y(this);
        this.f88583c = new s(this);
        this.f88584d = new n(this);
        this.f88585e = new k(this);
        this.f88586f = new f(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(FeedCloudMeta$StUser feedCloudMeta$StUser, long j3) {
        this.f88583c.f(feedCloudMeta$StUser.busiData.get().toByteArray(), j3);
        R();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(FeedCloudRead$StGetMainPageBasicDataRsp feedCloudRead$StGetMainPageBasicDataRsp, long j3) {
        this.f88583c.f(feedCloudRead$StGetMainPageBasicDataRsp.user.busiData.get().toByteArray(), j3);
        this.f88585e.f(feedCloudRead$StGetMainPageBasicDataRsp.busiRspData.get().toByteArray(), j3);
        this.f88586f.g(false, j3);
        R();
        SimpleEventBus.getInstance().dispatchEvent(new QFSPersonalBasicRequestEvent(L(), true));
    }

    public boolean A() {
        if (e().urgeStatus.get() != 0) {
            return true;
        }
        return false;
    }

    public boolean B() {
        if (e().urgeStatus.get() == 2) {
            return true;
        }
        return false;
    }

    protected long E() {
        return System.nanoTime();
    }

    public void F() {
        this.f88585e.f88546c = null;
        this.f88584d.f88549c = null;
    }

    public void G(int i3) {
        this.f88585e.f88548e.h(i3);
    }

    public void H() {
        List<Integer> g16 = d().g();
        for (int i3 = 0; i3 < g16.size(); i3++) {
            g16.set(i3, -1);
        }
        d().p(g16);
        j("update_version_extend_feed");
    }

    public void I(long j3) {
        this.f88588h = j3;
    }

    public void J(String str) {
        this.f88587g = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void K() {
        MutableLiveData globalData = w20.a.j().getGlobalData(w.class, L());
        if (globalData != null && globalData.getValue() != 0) {
            o((w) globalData.getValue());
        }
    }

    public String L() {
        return c().f398463id.get();
    }

    public void M(FeedCloudRead$StGetMainPageCommDataRsp feedCloudRead$StGetMainPageCommDataRsp) {
        this.f88586f.f(feedCloudRead$StGetMainPageCommDataRsp, E());
    }

    public void N(boolean z16) {
        int i3;
        int a16 = d().a();
        if (z16) {
            i3 = a16 + 1;
        } else {
            i3 = a16 - 1;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        d().j(i3);
        j("update_version_extend_feed");
    }

    public void O(int i3) {
        d().k(i3);
        j("update_version_extend_feed");
    }

    public void P(int i3, int i16, int i17) {
        c().followState.set(i3);
        c().fansCount.set(i16);
        c().followCount.set(i17);
        j("update_version_user_follow");
    }

    public void Q(int i3) {
        QLog.i("QFSUserInfoData", 1, "[updateFuelCount] -> uid = " + L() + ",fuelCount = " + i3);
        long j3 = c().fuelCount.get() + ((long) i3);
        if (j3 < 0) {
            j3 = 0;
        }
        c().fuelCount.set(j3);
        j("update_version_user_push");
    }

    public void R() {
        if (TextUtils.isEmpty(L())) {
            return;
        }
        w20.a.j().initOrUpdateGlobalState((w20.a) this, true);
    }

    public void S(int i3) {
        d().l(i3);
        j("update_version_extend_feed");
    }

    public void T(boolean z16) {
        int i3;
        int c16 = d().c();
        if (z16) {
            i3 = c16 + 1;
        } else {
            i3 = c16 - 1;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        d().l(i3);
        j("update_version_extend_feed");
    }

    public void U(int i3) {
        d().o(i3);
        j("update_version_extend_feed");
    }

    public void V(boolean z16) {
        int i3;
        int f16 = d().f();
        if (z16) {
            i3 = f16 + 1;
        } else {
            i3 = f16 - 1;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        d().o(i3);
        j("update_version_extend_feed");
    }

    public void W(List<FeedCloudMeta$StMedalInfo> list) {
        b().medalWall.medalInfos.set(list);
        j("key_update_version_main_basic_base_rsp");
    }

    public void X() {
        List<Integer> g16 = d().g();
        for (int i3 = 0; i3 < g16.size(); i3++) {
            g16.set(i3, Integer.valueOf(g16.get(i3).intValue() - 1));
        }
        d().p(g16);
        j("update_version_extend_feed");
    }

    public void Y(int i3) {
        c().relationState.set(i3);
        j("update_version_user_follow");
    }

    public void Z(int i3) {
        e().urgeStatus.set(i3);
        j("update_version_op_urge");
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.data.a
    public QQCircleBase$StUserBusiData a() {
        s sVar = this.f88583c;
        if (sVar.f88574c == null) {
            sVar.f88574c = new QQCircleBase$StUserBusiData();
        }
        return this.f88583c.f88574c;
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.data.a
    public FeedCloudRead$StGetMainPageBasicDataRsp b() {
        n nVar = this.f88584d;
        if (nVar.f88549c == null) {
            nVar.f88549c = new FeedCloudRead$StGetMainPageBasicDataRsp();
        }
        return this.f88584d.f88549c;
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.data.a
    @NonNull
    public FeedCloudMeta$StUser c() {
        y yVar = this.f88582b;
        if (yVar.f88589c == null) {
            yVar.f88589c = new FeedCloudMeta$StUser();
        }
        return this.f88582b.f88589c;
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.data.a
    public g d() {
        f fVar = this.f88586f;
        if (fVar.f88536c == null) {
            fVar.f88536c = new g();
        }
        return this.f88586f.f88536c;
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.data.a
    @NonNull
    public QQCircleFeedBase$StMainPageBasicBusiRspData e() {
        k kVar = this.f88585e;
        if (kVar.f88546c == null) {
            kVar.f88546c = new QQCircleFeedBase$StMainPageBasicBusiRspData();
        }
        return this.f88585e.f88546c;
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.data.a
    public void f(String str, long j3) {
        this.f88581a.put(str, Long.valueOf(j3));
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.data.a
    public QQCircleProfile$StProfileBizData g() {
        k kVar = this.f88585e;
        if (kVar.f88547d == null) {
            kVar.f88547d = new QQCircleProfile$StProfileBizData();
        }
        return this.f88585e.f88547d;
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.data.a
    public long h(String str) {
        Long l3 = this.f88581a.get(str);
        if (l3 == null) {
            return 0L;
        }
        return l3.longValue();
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.data.a
    public ConcurrentHashMap<Integer, Boolean> i() {
        return this.f88585e.f88548e.f88545b;
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.data.a
    public void j(String str) {
        f(str, E());
    }

    public void m(int i3) {
        this.f88585e.f88548e.g(i3);
    }

    public boolean n() {
        if (e().urgePosition.get() == 2) {
            return true;
        }
        return false;
    }

    public void o(w wVar) {
        QLog.i("QFSUserInfoData", 1, "[cloneData] -> userInfoData");
        if (!TextUtils.equals(L(), wVar.L())) {
            return;
        }
        this.f88582b.c(wVar);
        this.f88583c.c(wVar);
        this.f88584d.c(wVar);
        this.f88585e.c(wVar);
        this.f88586f.c(wVar);
    }

    public void p() {
        int i3 = g().updateSchoolNum.get() - 1;
        if (i3 < 0) {
            i3 = 0;
        }
        g().updateSchoolNum.set(i3);
        QLog.i("QFSUserInfoData", 1, "[decreaseSchoolCount] -> uid = " + L() + ",decreaseSchoolCount = " + i3);
        j("update_version_user_push");
    }

    public long q() {
        return this.f88588h;
    }

    public String r() {
        return this.f88587g;
    }

    public String s(String str) {
        return af.a(e().urlInfo.get(), str);
    }

    public String t(String str) {
        if (e().wordings.get() != null && e().wordings.get().size() > 0) {
            for (FeedCloudCommon$Entry feedCloudCommon$Entry : e().wordings.get()) {
                if (feedCloudCommon$Entry.key.get().equals(str)) {
                    return feedCloudCommon$Entry.value.get();
                }
            }
        }
        return "";
    }

    public boolean u(int i3) {
        return e().opMask.get().contains(Integer.valueOf(i3));
    }

    public boolean v() {
        if (c().blackState.get() == 1 || c().blackState.get() == 3) {
            return true;
        }
        return false;
    }

    public boolean w() {
        if (c().blackState.get() != 2 && c().blackState.get() != 3) {
            return false;
        }
        return true;
    }

    public boolean x() {
        return d().h();
    }

    public boolean y() {
        if (c().blackState.get() == 0) {
            return true;
        }
        return false;
    }

    public boolean z() {
        return com.tencent.biz.qqcircle.immersive.utils.r.u0(c());
    }

    public w(String str) {
        this();
        this.f88582b.g(str);
    }

    public w(@NonNull final FeedCloudMeta$StUser feedCloudMeta$StUser) {
        this();
        final long E = E();
        this.f88582b.f(feedCloudMeta$StUser, E);
        if (!RFWThreadManager.isMainThread()) {
            this.f88583c.f(feedCloudMeta$StUser.busiData.get().toByteArray(), E);
        } else {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.data.u
                @Override // java.lang.Runnable
                public final void run() {
                    w.this.C(feedCloudMeta$StUser, E);
                }
            });
        }
    }

    public w(final FeedCloudRead$StGetMainPageBasicDataRsp feedCloudRead$StGetMainPageBasicDataRsp) {
        this();
        final long E = E();
        this.f88582b.f(feedCloudRead$StGetMainPageBasicDataRsp.user.get(), E);
        this.f88584d.f(feedCloudRead$StGetMainPageBasicDataRsp, E);
        if (!RFWThreadManager.isMainThread()) {
            this.f88583c.f(feedCloudRead$StGetMainPageBasicDataRsp.user.busiData.get().toByteArray(), E);
            this.f88585e.f(feedCloudRead$StGetMainPageBasicDataRsp.busiRspData.get().toByteArray(), E);
            this.f88586f.g(false, E);
            return;
        }
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.data.v
            @Override // java.lang.Runnable
            public final void run() {
                w.this.D(feedCloudRead$StGetMainPageBasicDataRsp, E);
            }
        });
    }
}
