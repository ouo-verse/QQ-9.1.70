package com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import defpackage.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GameGoodsBlock implements ISSOReqModel, ISSORspModel<GameGoodsBlock> {
    public final Button buttonMore;
    public final List<GoodsCard> goodsCards;
    public final String title;

    public GameGoodsBlock() {
        this(null, null, null, 7, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        b a16 = o.a(eVar, "title", this.title);
        List<GoodsCard> list = this.goodsCards;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                a16.t(((GoodsCard) it.next()).encode());
            }
        }
        eVar.v("goods_cards", a16);
        Button button = this.buttonMore;
        if (button != null) {
            eVar.v("button_more", button.encode());
        }
        return eVar;
    }

    public GameGoodsBlock(String str, List<GoodsCard> list, Button button) {
        this.title = str;
        this.goodsCards = list;
        this.buttonMore = button;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final GameGoodsBlock decode(e eVar) {
        ArrayList arrayList;
        b bVar;
        Button button;
        String q16 = eVar.q("title", "");
        b l3 = eVar.l("goods_cards");
        if (l3 != null) {
            arrayList = new ArrayList();
            int c16 = l3.c();
            int i3 = 0;
            while (i3 < c16) {
                Object d16 = l3.d(i3);
                if (d16 != null) {
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    e eVar2 = (e) d16;
                    String q17 = eVar2.q("title", "");
                    String q18 = eVar2.q("price", "");
                    String q19 = eVar2.q("crossed_price", "");
                    String q26 = eVar2.q("tag", "");
                    String q27 = eVar2.q("tag_icon_url", "");
                    String q28 = eVar2.q("pic_url", "");
                    String q29 = eVar2.q("detail_url", "");
                    e m3 = eVar2.m("button_purchase");
                    if (m3 != null) {
                        bVar = l3;
                        button = new Button(m3.q("title", ""), m3.q("jump_url", ""));
                    } else {
                        bVar = l3;
                        button = null;
                    }
                    arrayList.add(new GoodsCard(q17, q18, q19, q26, q27, q28, q29, button, eVar2.q("goods_id", "")));
                } else {
                    bVar = l3;
                }
                i3++;
                l3 = bVar;
            }
        } else {
            arrayList = null;
        }
        e m16 = eVar.m("button_more");
        return new GameGoodsBlock(q16, arrayList != null ? CollectionsKt___CollectionsKt.toList(arrayList) : null, m16 != null ? new Button(m16.q("title", ""), m16.q("jump_url", "")) : null);
    }

    public /* synthetic */ GameGoodsBlock(String str, List list, Button button, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", null, null);
    }
}
