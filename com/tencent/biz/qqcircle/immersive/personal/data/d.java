package com.tencent.biz.qqcircle.immersive.personal.data;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d extends b {
    @Override // com.tencent.biz.qqcircle.immersive.personal.data.b
    public String a() {
        return "QFSExtendBaseInfo";
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.data.b
    public String b() {
        return "key_version_extend_base_info";
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.data.b
    public boolean e(a aVar, a aVar2) {
        boolean h16 = aVar2.d().h();
        if (aVar.d().h() != h16) {
            aVar.d().i(h16);
            return true;
        }
        return false;
    }
}
