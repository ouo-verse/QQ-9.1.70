package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* loaded from: classes31.dex */
public final class QPlusCirStImage implements ISSOReqModel, ISSORspModel<QPlusCirStImage> {
    public final int height;
    public final String picUrl;
    public final int width;

    public QPlusCirStImage(int i3, int i16, String str) {
        this.width = i3;
        this.height = i16;
        this.picUrl = str;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.t("width", this.width);
        eVar.t("height", this.height);
        eVar.v("picUrl", this.picUrl);
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusCirStImage decode(e eVar) {
        return new QPlusCirStImage(eVar.k("width", 0), eVar.k("height", 0), eVar.q("picUrl", ""));
    }

    public /* synthetic */ QPlusCirStImage(String str) {
        this(0, 0, str);
    }
}
