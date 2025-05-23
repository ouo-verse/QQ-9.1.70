package com.tencent.biz.qqcircle.immersive.personal.data;

/* compiled from: P */
/* loaded from: classes4.dex */
public class l extends b {
    @Override // com.tencent.biz.qqcircle.immersive.personal.data.b
    public String a() {
        return "QFSMainBasicBusiUrgeInfo";
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.data.b
    public String b() {
        return "update_version_op_urge";
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.data.b
    public boolean e(a aVar, a aVar2) {
        boolean z16;
        int i3 = aVar2.e().urgeStatus.get();
        if (aVar.e().urgeStatus.get() != i3) {
            aVar.e().urgeStatus.set(i3);
            z16 = true;
        } else {
            z16 = false;
        }
        int i16 = aVar2.e().urgePosition.get();
        if (aVar.e().urgePosition.get() != i16) {
            aVar.e().urgePosition.set(i16);
            return true;
        }
        return z16;
    }
}
