package com.tencent.biz.qqcircle.immersive.personal.data;

/* compiled from: P */
/* loaded from: classes4.dex */
public class x extends b {
    @Override // com.tencent.biz.qqcircle.immersive.personal.data.b
    public String a() {
        return "QFSUserPushInfo";
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.data.b
    public String b() {
        return "update_version_user_push";
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.data.b
    public boolean e(a aVar, a aVar2) {
        long j3 = aVar2.c().fuelCount.get();
        if (aVar.c().fuelCount.get() != j3) {
            aVar.c().fuelCount.set(j3);
            return true;
        }
        return false;
    }
}
