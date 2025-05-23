package com.tencent.biz.qqcircle.immersive.personal.data;

/* compiled from: P */
/* loaded from: classes4.dex */
public class e extends b {
    @Override // com.tencent.biz.qqcircle.immersive.personal.data.b
    public String a() {
        return "QFSExtendFeedInfo";
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.data.b
    public String b() {
        return "update_version_extend_feed";
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.data.b
    public boolean e(a aVar, a aVar2) {
        boolean z16;
        if (aVar.d().b() != aVar2.d().b()) {
            aVar.d().k(aVar2.d().b());
            z16 = true;
        } else {
            z16 = false;
        }
        if (aVar.d().c() != aVar2.d().c()) {
            aVar.d().l(aVar2.d().c());
            z16 = true;
        }
        if (aVar.d().f() != aVar2.d().f()) {
            aVar.d().o(aVar2.d().f());
            z16 = true;
        }
        if (aVar.d().a() != aVar2.d().a()) {
            aVar.d().j(aVar2.d().a());
            z16 = true;
        }
        if (aVar.d().g() != aVar2.d().g()) {
            aVar.d().p(aVar2.d().g());
            z16 = true;
        }
        if (aVar.d().d() != aVar2.d().d()) {
            aVar.d().m(aVar2.d().d());
            z16 = true;
        }
        if (aVar.d().e() != aVar2.d().e()) {
            aVar.d().n(aVar2.d().e());
            return true;
        }
        return z16;
    }
}
