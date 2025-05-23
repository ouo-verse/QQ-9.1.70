package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.qzone.homepage.ui.Facade.model.FacadeCacheData;
import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class ExpressionInfo implements ISSOReqModel, ISSORspModel<ExpressionInfo> {
    public final String imgOther;
    public final String md5;
    public final String srcDesc;
    public final String srcIconUrl;
    public final String srcPackName;
    public final String srcWebUrl;
    public final String thumbMd5;
    public final String thumbUrl;
    public final String url;

    public ExpressionInfo() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("md5", this.md5);
        eVar.v("url", this.url);
        eVar.v("thumb_md5", this.thumbMd5);
        eVar.v(FacadeCacheData.THUMB_URL, this.thumbUrl);
        eVar.v("src_desc", this.srcDesc);
        eVar.v("src_pack_name", this.srcPackName);
        eVar.v("src_web_url", this.srcWebUrl);
        eVar.v("src_icon_url", this.srcIconUrl);
        eVar.v("img_other", this.imgOther);
        return eVar;
    }

    public ExpressionInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.md5 = str;
        this.url = str2;
        this.thumbMd5 = str3;
        this.thumbUrl = str4;
        this.srcDesc = str5;
        this.srcPackName = str6;
        this.srcWebUrl = str7;
        this.srcIconUrl = str8;
        this.imgOther = str9;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final ExpressionInfo decode(e eVar) {
        return new ExpressionInfo(eVar.q("md5", ""), eVar.q("url", ""), eVar.q("thumb_md5", ""), eVar.q(FacadeCacheData.THUMB_URL, ""), eVar.q("src_desc", ""), eVar.q("src_pack_name", ""), eVar.q("src_web_url", ""), eVar.q("src_icon_url", ""), eVar.q("img_other", ""));
    }

    public /* synthetic */ ExpressionInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", "", "", "", "", "", "", "");
    }
}
