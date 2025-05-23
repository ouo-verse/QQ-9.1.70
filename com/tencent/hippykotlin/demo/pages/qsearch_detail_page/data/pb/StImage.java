package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class StImage implements ISSOReqModel, ISSORspModel<StImage> {
    public final int height;
    public final String layerPicUrl;
    public final String picUrl;
    public final int width;

    public StImage() {
        this(0, 0, null, null, 15, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.t("width", this.width);
        eVar.t("height", this.height);
        eVar.v("pic_url", this.picUrl);
        eVar.v("layer_pic_url", this.layerPicUrl);
        return eVar;
    }

    public StImage(int i3, int i16, String str, String str2) {
        this.width = i3;
        this.height = i16;
        this.picUrl = str;
        this.layerPicUrl = str2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final StImage decode(e eVar) {
        return new StImage(eVar.k("width", 0), eVar.k("height", 0), eVar.q("pic_url", ""), eVar.q("layer_pic_url", ""));
    }

    public /* synthetic */ StImage(int i3, int i16, String str, String str2, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, 0, "", "");
    }
}
