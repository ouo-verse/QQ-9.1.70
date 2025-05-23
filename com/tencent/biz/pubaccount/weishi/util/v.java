package com.tencent.biz.pubaccount.weishi.util;

import com.tencent.biz.pubaccount.weishi.cache.WSRedDotPreloadManager;
import com.tencent.biz.pubaccount.weishi.config.experiment.WSExpPolicyManager;
import com.tencent.biz.pubaccount.weishi.push.WSRedDotPushMsg;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.adv.api.IVasAdvApi;

/* compiled from: P */
/* loaded from: classes32.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    private int f81797a;

    /* renamed from: b, reason: collision with root package name */
    private String f81798b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final v f81799a = new v();
    }

    v() {
    }

    public static v b() {
        return a.f81799a;
    }

    public int a() {
        return this.f81797a;
    }

    public String c() {
        return this.f81798b;
    }

    public void d() {
        WSRedDotPushMsg z16 = bb.z();
        if (z16 != null) {
            this.f81798b = z16.mPushId;
        }
        this.f81797a = 0;
        ry.a.b();
    }

    public void e() {
        com.tencent.biz.pubaccount.weishi.config.experiment.b.h().P();
        WSRedDotPreloadManager.d().k();
    }

    public void f() {
        WSExpPolicyManager.o().p();
        com.tencent.biz.pubaccount.weishi.report.f.k("QQ_official_account");
        ba.z();
    }

    public void g() {
        WSExpPolicyManager.o().p();
        com.tencent.biz.pubaccount.weishi.report.f.k("weishi_share_trendstab");
        ((IVasAdvApi) QRoute.api(IVasAdvApi.class)).initTbsEnvironment();
        ba.z();
    }

    public void h() {
        this.f81798b = "";
    }

    public void i(int i3) {
        this.f81797a = i3;
    }
}
