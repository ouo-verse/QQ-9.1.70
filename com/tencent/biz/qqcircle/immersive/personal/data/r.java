package com.tencent.biz.qqcircle.immersive.personal.data;

/* compiled from: P */
/* loaded from: classes4.dex */
public class r extends b {
    @Override // com.tencent.biz.qqcircle.immersive.personal.data.b
    public String a() {
        return "QFSCircleInfo";
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.data.b
    public String b() {
        return "update_version_base_user_busi_data";
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.data.b
    public boolean e(a aVar, a aVar2) {
        aVar.a().schoolInfos.set(aVar2.a().schoolInfos.get());
        aVar.a().companyInfos.set(aVar2.a().companyInfos.get());
        aVar.a().completionDesc.set(aVar2.a().completionDesc.get());
        aVar.a().rankData.set(aVar2.a().rankData.get());
        aVar.a().certification.set(aVar2.a().certification.get());
        aVar.a().blueCertifiDesc.set(aVar2.a().blueCertifiDesc.get());
        aVar.a().certificationDesc.set(aVar2.a().certificationDesc.get());
        aVar.a().achievement.set(aVar2.a().achievement.get());
        aVar.a().fuelRedPointCount.set(aVar2.a().fuelRedPointCount.get());
        aVar.a().certification_jump_url.set(aVar2.a().certification_jump_url.get());
        aVar.a().f429290id.set(aVar2.a().f429290id.get());
        aVar.a().realNameAuthInfo.set(aVar2.a().realNameAuthInfo.get());
        aVar.a().realNameAuthInfo.setHasFlag(aVar2.a().realNameAuthInfo.has());
        return false;
    }
}
