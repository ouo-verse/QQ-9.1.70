package com.tencent.biz.qqcircle.immersive.personal.data;

/* compiled from: P */
/* loaded from: classes4.dex */
public class m extends b {
    @Override // com.tencent.biz.qqcircle.immersive.personal.data.b
    public String a() {
        return "QFSMainPageBasicRspBaseInfo";
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.data.b
    public String b() {
        return "key_update_version_main_basic_base_rsp";
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.data.b
    public boolean e(a aVar, a aVar2) {
        aVar.b().isPenguinUser.set(aVar2.b().isPenguinUser.get());
        aVar.b().penguinModifyGuideURL.set(aVar2.b().penguinModifyGuideURL.get());
        aVar.b().share = aVar2.b().share.get();
        aVar.b().operateInfo.set(aVar2.b().operateInfo.get());
        aVar.b().guildInfo = aVar2.b().guildInfo.get();
        aVar.b().followRecomInfo = aVar2.b().followRecomInfo.get();
        aVar.b().medalWall = aVar2.b().medalWall.get();
        aVar.b().user = aVar2.b().user.get();
        aVar.b().isKandianUser.set(aVar2.b().isKandianUser.get());
        aVar.b().kandianUser = aVar2.b().kandianUser.get();
        aVar.b().redPoint = aVar2.b().redPoint;
        aVar.b().callFollow = aVar2.b().callFollow;
        aVar.b().magic_icon = aVar2.b().magic_icon;
        aVar.b().extInfo = aVar2.b().extInfo;
        aVar.b().hasFansEntryRedPoint.set(aVar2.b().hasFansEntryRedPoint.get());
        return true;
    }
}
