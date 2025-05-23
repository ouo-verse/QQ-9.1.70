package com.tencent.biz.qqcircle.immersive.personal.data;

/* compiled from: P */
/* loaded from: classes4.dex */
public class p extends b {
    @Override // com.tencent.biz.qqcircle.immersive.personal.data.b
    public String a() {
        return "QFSUserBaseInfo";
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.data.b
    public String b() {
        return "update_version_user_base_info";
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.data.b
    public boolean e(a aVar, a aVar2) {
        aVar.c().icon.set(aVar2.c().icon.get());
        aVar.c().nick.set(aVar2.c().nick.get());
        aVar.c().desc.set(aVar2.c().desc.get());
        aVar.c().sex.set(aVar2.c().sex.get());
        aVar.c().location.set(aVar2.c().location.get());
        aVar.c().locationCode.set(aVar2.c().locationCode.get());
        aVar.c().constellation.set(aVar2.c().constellation.get());
        aVar.c().frdState.set(aVar2.c().frdState.get());
        aVar.c().isUserInLivingStatus.set(aVar2.c().isUserInLivingStatus.get());
        aVar.c().jumpUrl.set(aVar2.c().jumpUrl.get());
        aVar.c().visitorCount.set(aVar2.c().visitorCount.get());
        aVar.c().iconDecorate.set(aVar2.c().iconDecorate.get());
        aVar.c().guild_state.set(aVar2.c().guild_state.get());
        aVar.c().login_ip_location.set(aVar2.c().login_ip_location.get());
        aVar.c().busiReport.set(aVar2.c().busiReport.get());
        aVar.c().qq_vip.set(aVar2.c().qq_vip.get());
        aVar.c().mcn_name.set(aVar2.c().mcn_name.get());
        aVar.c().level_benefit.set(aVar2.c().level_benefit.get());
        aVar.c().level_benefit_icon.set(aVar2.c().level_benefit_icon.get());
        return true;
    }
}
