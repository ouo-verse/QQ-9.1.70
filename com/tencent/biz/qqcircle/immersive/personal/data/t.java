package com.tencent.biz.qqcircle.immersive.personal.data;

/* compiled from: P */
/* loaded from: classes4.dex */
public class t extends b {
    @Override // com.tencent.biz.qqcircle.immersive.personal.data.b
    public String a() {
        return "QFSUserFollowInfo";
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.data.b
    public String b() {
        return "update_version_user_follow";
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.data.b
    public boolean e(a aVar, a aVar2) {
        boolean z16;
        int i3 = aVar2.c().followState.get();
        if (aVar.c().followState.get() != i3) {
            aVar.c().followState.set(i3);
            z16 = true;
        } else {
            z16 = false;
        }
        int i16 = aVar2.c().relationState.get();
        if (aVar.c().relationState.get() != i16) {
            aVar.c().relationState.set(i16);
            z16 = true;
        }
        long j3 = aVar2.c().followCount.get();
        if (aVar.c().followCount.get() != j3) {
            aVar.c().followCount.set(j3);
            z16 = true;
        }
        long j16 = aVar2.c().fansCount.get();
        if (aVar.c().fansCount.get() != j16) {
            aVar.c().fansCount.set(j16);
            return true;
        }
        return z16;
    }
}
