package com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCard implements ISSOReqModel, ISSORspModel<GoodsCard> {
    public final Button buttonPurchase;
    public final String crossedPrice;
    public final String detailUrl;
    public final String goodsId;
    public final String picUrl;
    public final String price;
    public final String tag;
    public final String tagIconUrl;
    public final String title;

    public GoodsCard() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("title", this.title);
        eVar.v("price", this.price);
        eVar.v("crossed_price", this.crossedPrice);
        eVar.v("tag", this.tag);
        eVar.v("tag_icon_url", this.tagIconUrl);
        eVar.v("pic_url", this.picUrl);
        eVar.v("detail_url", this.detailUrl);
        Button button = this.buttonPurchase;
        if (button != null) {
            eVar.v("button_purchase", button.encode());
        }
        eVar.v("goods_id", this.goodsId);
        return eVar;
    }

    public GoodsCard(String str, String str2, String str3, String str4, String str5, String str6, String str7, Button button, String str8) {
        this.title = str;
        this.price = str2;
        this.crossedPrice = str3;
        this.tag = str4;
        this.tagIconUrl = str5;
        this.picUrl = str6;
        this.detailUrl = str7;
        this.buttonPurchase = button;
        this.goodsId = str8;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final GoodsCard decode(e eVar) {
        String q16 = eVar.q("title", "");
        String q17 = eVar.q("price", "");
        String q18 = eVar.q("crossed_price", "");
        String q19 = eVar.q("tag", "");
        String q26 = eVar.q("tag_icon_url", "");
        String q27 = eVar.q("pic_url", "");
        String q28 = eVar.q("detail_url", "");
        e m3 = eVar.m("button_purchase");
        return new GoodsCard(q16, q17, q18, q19, q26, q27, q28, m3 != null ? new Button(m3.q("title", ""), m3.q("jump_url", "")) : null, eVar.q("goods_id", ""));
    }

    public /* synthetic */ GoodsCard(String str, String str2, String str3, String str4, String str5, String str6, String str7, Button button, String str8, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", "", "", "", "", "", null, "");
    }
}
