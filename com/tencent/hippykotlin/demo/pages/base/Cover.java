package com.tencent.hippykotlin.demo.pages.base;

import com.tencent.kuikly.core.nvi.serialization.json.e;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class Cover implements ISSOReqModel, ISSORspModel<Cover> {
    public final String layerPicUrl;
    public final String picUrl;

    public Cover(String str, String str2) {
        this.picUrl = str;
        this.layerPicUrl = str2;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final Cover decode(e eVar) {
        return new Cover(eVar.q("pic_url", ""), eVar.q("layer_picUrl", ""));
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("pic_url", this.picUrl);
        eVar.v("layer_picUrl", this.layerPicUrl);
        return eVar;
    }
}
