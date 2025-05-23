package com.tencent.biz.pubaccount.weishi;

import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;

/* compiled from: P */
/* loaded from: classes32.dex */
public class k implements IGuardInterface {

    /* renamed from: d, reason: collision with root package name */
    private String f80905d;

    public void a(String str) {
        this.f80905d = str;
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationBackground() {
        com.tencent.biz.pubaccount.weishi.util.x.j("WSGuardInterfaceWrapper", "[onApplicationBackground] mPageId:" + this.f80905d);
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationForeground() {
        com.tencent.biz.pubaccount.weishi.util.x.j("WSGuardInterfaceWrapper", "[onApplicationForeground] mPageId:" + this.f80905d);
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onBackgroundTimeTick(long j3) {
        com.tencent.biz.pubaccount.weishi.util.x.j("WSGuardInterfaceWrapper", "[onBackgroundTimeTick] mPageId:" + this.f80905d + ", tick:" + j3);
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onBackgroundUnguardTimeTick(long j3) {
        com.tencent.biz.pubaccount.weishi.util.x.j("WSGuardInterfaceWrapper", "[onBackgroundUnGuardTimeTick] mPageId:" + this.f80905d + ", tick:" + j3);
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onLiteTimeTick(long j3) {
        com.tencent.biz.pubaccount.weishi.util.x.j("WSGuardInterfaceWrapper", "[onLiteTimeTick] mPageId:" + this.f80905d + ", tick:" + j3);
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onScreensStateChanged(boolean z16) {
        com.tencent.biz.pubaccount.weishi.util.x.j("WSGuardInterfaceWrapper", "[onScreensStateChanged] mPageId:" + this.f80905d + ", isEnabled:" + z16);
    }
}
