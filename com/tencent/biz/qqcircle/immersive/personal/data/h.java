package com.tencent.biz.qqcircle.immersive.personal.data;

/* compiled from: P */
/* loaded from: classes4.dex */
public class h extends b {
    @Override // com.tencent.biz.qqcircle.immersive.personal.data.b
    public String a() {
        return "QFSMainPageBusiDataInfo";
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.data.b
    public String b() {
        return "key_update_version_main_basic_busi_base_data";
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.data.b
    public boolean e(a aVar, a aVar2) {
        aVar.e().urlInfo.set(aVar2.e().urlInfo.get());
        aVar.e().recomTagList.set(aVar2.e().recomTagList.get());
        aVar.e().giftCnt.set(aVar2.e().giftCnt.get());
        aVar.e().wordings.set(aVar2.e().wordings.get());
        aVar.e().pushBoxInfo.set(aVar2.e().pushBoxInfo.get());
        aVar.e().rocketInfo.set(aVar2.e().rocketInfo.get());
        aVar.e().header_info.set(aVar2.e().header_info.get());
        aVar.e().giftJumpUrl.set(aVar2.e().giftJumpUrl.get());
        return true;
    }
}
