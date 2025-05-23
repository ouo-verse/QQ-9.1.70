package com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.AdBannerBlock;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameCard;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameCardBlock;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameGoodsBlock;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameTab;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameTabBlock;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.IconButton;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.NavigationBlock;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.TopBannerItem;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GetFeedRsp implements ISSOReqModel, ISSORspModel<GetFeedRsp> {
    public final AdBannerBlock adBannerBlock;
    public final String cookie;
    public final GameCardBlock gameCardBlock;
    public final GameFeedBlock gameFeedBlock;
    public final GameGoodsBlock gameGoodsBlock;
    public final GameTabBlock gameTabBlock;
    public final NavigationBlock navigationBlock;

    public GetFeedRsp() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        AdBannerBlock adBannerBlock = this.adBannerBlock;
        if (adBannerBlock != null) {
            eVar.v("ad_banner_block", adBannerBlock.encode());
        }
        GameTabBlock gameTabBlock = this.gameTabBlock;
        if (gameTabBlock != null) {
            eVar.v("game_tab_block", gameTabBlock.encode());
        }
        NavigationBlock navigationBlock = this.navigationBlock;
        if (navigationBlock != null) {
            eVar.v("navigation_block", navigationBlock.encode());
        }
        GameCardBlock gameCardBlock = this.gameCardBlock;
        if (gameCardBlock != null) {
            eVar.v("game_card_block", gameCardBlock.encode());
        }
        GameGoodsBlock gameGoodsBlock = this.gameGoodsBlock;
        if (gameGoodsBlock != null) {
            eVar.v("game_goods_block", gameGoodsBlock.encode());
        }
        GameFeedBlock gameFeedBlock = this.gameFeedBlock;
        if (gameFeedBlock != null) {
            eVar.v("game_feed_block", gameFeedBlock.encode());
        }
        eVar.v("cookie", this.cookie);
        return eVar;
    }

    public GetFeedRsp(AdBannerBlock adBannerBlock, GameTabBlock gameTabBlock, NavigationBlock navigationBlock, GameCardBlock gameCardBlock, GameGoodsBlock gameGoodsBlock, GameFeedBlock gameFeedBlock, String str) {
        this.adBannerBlock = adBannerBlock;
        this.gameTabBlock = gameTabBlock;
        this.navigationBlock = navigationBlock;
        this.gameCardBlock = gameCardBlock;
        this.gameGoodsBlock = gameGoodsBlock;
        this.gameFeedBlock = gameFeedBlock;
        this.cookie = str;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final GetFeedRsp decode(e eVar) {
        AdBannerBlock adBannerBlock;
        GameTabBlock gameTabBlock;
        NavigationBlock navigationBlock;
        GameCardBlock gameCardBlock;
        GameFeedBlock gameFeedBlock;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        e m3 = eVar.m("ad_banner_block");
        if (m3 != null) {
            b l3 = m3.l("banner_list");
            if (l3 != null) {
                arrayList4 = new ArrayList();
                int c16 = l3.c();
                for (int i3 = 0; i3 < c16; i3++) {
                    Object d16 = l3.d(i3);
                    if (d16 != null) {
                        Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        e eVar2 = (e) d16;
                        arrayList4.add(new TopBannerItem(eVar2.q("banner_id", ""), eVar2.q("super_img", ""), eVar2.k("is_super_img_dynamic", 0), eVar2.q("small_img", ""), eVar2.k("is_small_img_dynamic", 0), eVar2.q("video_url", ""), eVar2.q("jump_url", "")));
                    }
                }
            } else {
                arrayList4 = null;
            }
            adBannerBlock = new AdBannerBlock(arrayList4 != null ? CollectionsKt___CollectionsKt.toList(arrayList4) : null);
        } else {
            adBannerBlock = null;
        }
        e m16 = eVar.m("game_tab_block");
        if (m16 != null) {
            b l16 = m16.l("game_tabs");
            if (l16 != null) {
                arrayList3 = new ArrayList();
                int c17 = l16.c();
                for (int i16 = 0; i16 < c17; i16++) {
                    Object d17 = l16.d(i16);
                    if (d17 != null) {
                        GameTab gameTab = new GameTab(null, null, false, 7, null);
                        Intrinsics.checkNotNull(d17, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        arrayList3.add(gameTab.decode((e) d17));
                    }
                }
            } else {
                arrayList3 = null;
            }
            gameTabBlock = new GameTabBlock(arrayList3 != null ? CollectionsKt___CollectionsKt.toList(arrayList3) : null, m16.q("located_tab_id", ""));
        } else {
            gameTabBlock = null;
        }
        e m17 = eVar.m("navigation_block");
        if (m17 != null) {
            b l17 = m17.l("icon_buttons");
            if (l17 != null) {
                arrayList2 = new ArrayList();
                int c18 = l17.c();
                for (int i17 = 0; i17 < c18; i17++) {
                    Object d18 = l17.d(i17);
                    if (d18 != null) {
                        Intrinsics.checkNotNull(d18, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        e eVar3 = (e) d18;
                        arrayList2.add(new IconButton(eVar3.q("title", ""), eVar3.q("jump_url", ""), eVar3.q("icon_default", ""), eVar3.q("icon_night", ""), eVar3.q("sub_title", "")));
                    }
                }
            } else {
                arrayList2 = null;
            }
            navigationBlock = new NavigationBlock(arrayList2 != null ? CollectionsKt___CollectionsKt.toList(arrayList2) : null);
        } else {
            navigationBlock = null;
        }
        e m18 = eVar.m("game_card_block");
        if (m18 != null) {
            b l18 = m18.l("game_cards");
            if (l18 != null) {
                arrayList = new ArrayList();
                int c19 = l18.c();
                for (int i18 = 0; i18 < c19; i18++) {
                    Object d19 = l18.d(i18);
                    if (d19 != null) {
                        GameCard gameCard = new GameCard(null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, 0, 1048575, null);
                        Intrinsics.checkNotNull(d19, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        arrayList.add(gameCard.decode((e) d19));
                    }
                }
            } else {
                arrayList = null;
            }
            gameCardBlock = new GameCardBlock(arrayList != null ? CollectionsKt___CollectionsKt.toList(arrayList) : null);
        } else {
            gameCardBlock = null;
        }
        e m19 = eVar.m("game_goods_block");
        GameGoodsBlock decode = m19 != null ? new GameGoodsBlock(null, null, null, 7, null).decode(m19) : null;
        e m26 = eVar.m("game_feed_block");
        if (m26 != null) {
            int k3 = m26.k("source", 0);
            int k16 = m26.k("sub_source", 0);
            e m27 = m26.m("base_feed_rsp");
            gameFeedBlock = new GameFeedBlock(k3, k16, m27 != null ? new StGetFeedListRsp(null, 0, null, "", "", "", false, null).decode(m27) : null);
        } else {
            gameFeedBlock = null;
        }
        return new GetFeedRsp(adBannerBlock, gameTabBlock, navigationBlock, gameCardBlock, decode, gameFeedBlock, eVar.q("cookie", ""));
    }

    public /* synthetic */ GetFeedRsp(AdBannerBlock adBannerBlock, GameTabBlock gameTabBlock, NavigationBlock navigationBlock, GameCardBlock gameCardBlock, GameGoodsBlock gameGoodsBlock, GameFeedBlock gameFeedBlock, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null, null, null, null, null, "");
    }
}
