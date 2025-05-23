package com.qzone.reborn.qzmoment.part;

/* compiled from: P */
/* loaded from: classes37.dex */
public class s extends QZMBaseFeedListPart {
    private com.qzone.reborn.qzmoment.viewmodel.m F;

    @Override // com.qzone.reborn.qzmoment.part.QZMBaseFeedListPart
    protected com.qzone.reborn.qzmoment.viewmodel.c I9() {
        if (this.F == null) {
            this.F = (com.qzone.reborn.qzmoment.viewmodel.m) getViewModel(com.qzone.reborn.qzmoment.viewmodel.m.class);
        }
        return this.F;
    }

    @Override // com.qzone.reborn.qzmoment.part.QZMBaseFeedListPart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZMMyMomentListPart";
    }
}
