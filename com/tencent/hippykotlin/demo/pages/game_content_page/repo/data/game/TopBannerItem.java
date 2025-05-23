package com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class TopBannerItem implements ISSOReqModel, ISSORspModel<TopBannerItem> {
    public final String bannerId;
    public final int isSmallImgDynamic;
    public final int isSuperImgDynamic;
    public final String jumpUrl;
    public final String smallImg;
    public final String superImg;
    public final String videoUrl;

    public TopBannerItem() {
        this(null, null, 0, null, 0, null, null, 127, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("banner_id", this.bannerId);
        eVar.v("super_img", this.superImg);
        eVar.t("is_super_img_dynamic", this.isSuperImgDynamic);
        eVar.v("small_img", this.smallImg);
        eVar.t("is_small_img_dynamic", this.isSmallImgDynamic);
        eVar.v("video_url", this.videoUrl);
        eVar.v("jump_url", this.jumpUrl);
        return eVar;
    }

    public TopBannerItem(String str, String str2, int i3, String str3, int i16, String str4, String str5) {
        this.bannerId = str;
        this.superImg = str2;
        this.isSuperImgDynamic = i3;
        this.smallImg = str3;
        this.isSmallImgDynamic = i16;
        this.videoUrl = str4;
        this.jumpUrl = str5;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final TopBannerItem decode(e eVar) {
        return new TopBannerItem(eVar.q("banner_id", ""), eVar.q("super_img", ""), eVar.k("is_super_img_dynamic", 0), eVar.q("small_img", ""), eVar.k("is_small_img_dynamic", 0), eVar.q("video_url", ""), eVar.q("jump_url", ""));
    }

    public /* synthetic */ TopBannerItem(String str, String str2, int i3, String str3, int i16, String str4, String str5, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", 0, "", 0, "", "");
    }
}
