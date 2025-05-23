package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class ImageInfo implements ISSOReqModel, ISSORspModel<ImageInfo> {
    public final String emojiId;
    public final String emojiType;
    public final String orgDownUrl;
    public final long orgImgHeight;
    public final String orgImgMd5;
    public final long orgImgSize;
    public final long orgImgWidth;
    public final String searchText;
    public final String thumbDownUrl;
    public final String thumbImgMd5;
    public final long thumbImgSize;

    public ImageInfo() {
        this(null, 0L, null, 0L, null, null, null, null, null, 0L, 0L, 2047, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("org_down_url", this.orgDownUrl);
        eVar.u("org_img_size", this.orgImgSize);
        eVar.v("thumb_down_url", this.thumbDownUrl);
        eVar.u("thumb_img_size", this.thumbImgSize);
        eVar.v("emoji_id", this.emojiId);
        eVar.v("emoji_type", this.emojiType);
        eVar.v("org_img_md5", this.orgImgMd5);
        eVar.v("thumb_img_md5", this.thumbImgMd5);
        eVar.v("search_text", this.searchText);
        eVar.u("org_img_height", this.orgImgHeight);
        eVar.u("org_img_width", this.orgImgWidth);
        return eVar;
    }

    public ImageInfo(String str, long j3, String str2, long j16, String str3, String str4, String str5, String str6, String str7, long j17, long j18) {
        this.orgDownUrl = str;
        this.orgImgSize = j3;
        this.thumbDownUrl = str2;
        this.thumbImgSize = j16;
        this.emojiId = str3;
        this.emojiType = str4;
        this.orgImgMd5 = str5;
        this.thumbImgMd5 = str6;
        this.searchText = str7;
        this.orgImgHeight = j17;
        this.orgImgWidth = j18;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final ImageInfo decode(e eVar) {
        return new ImageInfo(Utils.INSTANCE.currentBridgeModule().base64Code(eVar.q("org_down_url", ""), false), eVar.o("org_img_size", 0L), eVar.q("thumb_down_url", ""), eVar.o("thumb_img_size", 0L), eVar.q("emoji_id", ""), eVar.q("emoji_type", ""), eVar.q("org_img_md5", ""), eVar.q("thumb_img_md5", ""), eVar.q("search_text", ""), eVar.o("org_img_height", 0L), eVar.o("org_img_width", 0L));
    }

    public /* synthetic */ ImageInfo(String str, long j3, String str2, long j16, String str3, String str4, String str5, String str6, String str7, long j17, long j18, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", 0L, "", 0L, "", "", "", "", "", 0L, 0L);
    }
}
