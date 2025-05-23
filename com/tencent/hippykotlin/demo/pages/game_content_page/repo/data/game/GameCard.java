package com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.advertisement.GamePrivilegeInfo;
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
public final class GameCard implements ISSOReqModel, ISSORspModel<GameCard> {
    public final String adtag;
    public final String androidPkgSize;
    public final String appStoreUrl;
    public final String background;
    public final String backgroundBig;
    public final String channelId;
    public final String cloudPlayUrl;
    public final String detailUrl;
    public final boolean enableCloudPlay;
    public final String enterButtonColor;
    public final int gameCardStyle;
    public final String gameIcon;
    public final List<IconButton> iconButtons;

    /* renamed from: id, reason: collision with root package name */
    public final String f114191id;
    public final String partnerDescription;
    public final List<String> partnerPortraits;
    public final String pkgName;
    public final GamePrivilegeInfo privilege;
    public final String subscribeSucUrl;
    public final String title;

    public GameCard() {
        this(null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, 0, 1048575, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("title", this.title);
        eVar.v("id", this.f114191id);
        eVar.v("channel_id", this.channelId);
        eVar.v("pkg_name", this.pkgName);
        b a16 = o.a(eVar, "app_store_url", this.appStoreUrl);
        List<String> list = this.partnerPortraits;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                a16.t((String) it.next());
            }
        }
        eVar.v("partner_portraits", a16);
        b a17 = o.a(eVar, "partner_description", this.partnerDescription);
        List<IconButton> list2 = this.iconButtons;
        if (list2 != null) {
            Iterator<T> it5 = list2.iterator();
            while (it5.hasNext()) {
                a17.t(((IconButton) it5.next()).encode());
            }
        }
        eVar.v("icon_buttons", a17);
        eVar.v("background", this.background);
        eVar.v("detail_url", this.detailUrl);
        eVar.w("enable_cloud_play", this.enableCloudPlay);
        eVar.v("cloud_play_url", this.cloudPlayUrl);
        eVar.v("enter_button_color", this.enterButtonColor);
        eVar.v("subscribe_suc_url", this.subscribeSucUrl);
        eVar.v("adtag", this.adtag);
        eVar.v("android_pkg_size", this.androidPkgSize);
        GamePrivilegeInfo gamePrivilegeInfo = this.privilege;
        if (gamePrivilegeInfo != null) {
            eVar.v("privilege", gamePrivilegeInfo.encode());
        }
        eVar.v("game_icon", this.gameIcon);
        eVar.v("background_big", this.backgroundBig);
        eVar.t("game_card_style", this.gameCardStyle);
        return eVar;
    }

    public GameCard(String str, String str2, String str3, String str4, String str5, List<String> list, String str6, List<IconButton> list2, String str7, String str8, boolean z16, String str9, String str10, String str11, String str12, String str13, GamePrivilegeInfo gamePrivilegeInfo, String str14, String str15, int i3) {
        this.title = str;
        this.f114191id = str2;
        this.channelId = str3;
        this.pkgName = str4;
        this.appStoreUrl = str5;
        this.partnerPortraits = list;
        this.partnerDescription = str6;
        this.iconButtons = list2;
        this.background = str7;
        this.detailUrl = str8;
        this.enableCloudPlay = z16;
        this.cloudPlayUrl = str9;
        this.enterButtonColor = str10;
        this.subscribeSucUrl = str11;
        this.adtag = str12;
        this.androidPkgSize = str13;
        this.privilege = gamePrivilegeInfo;
        this.gameIcon = str14;
        this.backgroundBig = str15;
        this.gameCardStyle = i3;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final GameCard decode(e eVar) {
        ArrayList arrayList;
        ArrayList arrayList2;
        List list;
        List list2;
        List list3;
        List list4;
        String q16 = eVar.q("title", "");
        String q17 = eVar.q("id", "");
        String q18 = eVar.q("channel_id", "");
        String q19 = eVar.q("pkg_name", "");
        String q26 = eVar.q("app_store_url", "");
        b l3 = eVar.l("partner_portraits");
        if (l3 != null) {
            arrayList = new ArrayList();
            int c16 = l3.c();
            for (int i3 = 0; i3 < c16; i3++) {
                String o16 = l3.o(i3);
                if (o16 != null) {
                    arrayList.add(o16);
                }
            }
        } else {
            arrayList = null;
        }
        String q27 = eVar.q("partner_description", "");
        b l16 = eVar.l("icon_buttons");
        if (l16 != null) {
            arrayList2 = new ArrayList();
            int c17 = l16.c();
            for (int i16 = 0; i16 < c17; i16++) {
                Object d16 = l16.d(i16);
                if (d16 != null) {
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    e eVar2 = (e) d16;
                    arrayList2.add(new IconButton(eVar2.q("title", ""), eVar2.q("jump_url", ""), eVar2.q("icon_default", ""), eVar2.q("icon_night", ""), eVar2.q("sub_title", "")));
                }
            }
        } else {
            arrayList2 = null;
        }
        String q28 = eVar.q("background", "");
        String q29 = eVar.q("detail_url", "");
        boolean g16 = eVar.g("enable_cloud_play", false);
        String q36 = eVar.q("cloud_play_url", "");
        String q37 = eVar.q("enter_button_color", "");
        String q38 = eVar.q("subscribe_suc_url", "");
        String q39 = eVar.q("adtag", "");
        String q46 = eVar.q("android_pkg_size", "");
        e m3 = eVar.m("privilege");
        GamePrivilegeInfo gamePrivilegeInfo = m3 != null ? new GamePrivilegeInfo(m3.q("developer", ""), m3.q("version", ""), m3.q("private_policies_text", ""), m3.q("private_policies_url", ""), m3.q("app_privileges_text", ""), m3.q("app_privileges_url", ""), m3.q("app_name", "")) : null;
        String q47 = eVar.q("game_icon", "");
        String q48 = eVar.q("background_big", "");
        int k3 = eVar.k("game_card_style", 0);
        if (arrayList != null) {
            list4 = CollectionsKt___CollectionsKt.toList(arrayList);
            list = list4;
        } else {
            list = null;
        }
        if (arrayList2 != null) {
            list3 = CollectionsKt___CollectionsKt.toList(arrayList2);
            list2 = list3;
        } else {
            list2 = null;
        }
        return new GameCard(q16, q17, q18, q19, q26, list, q27, list2, q28, q29, g16, q36, q37, q38, q39, q46, gamePrivilegeInfo, q47, q48, k3);
    }

    public /* synthetic */ GameCard(String str, String str2, String str3, String str4, String str5, List list, String str6, List list2, String str7, String str8, boolean z16, String str9, String str10, String str11, String str12, String str13, GamePrivilegeInfo gamePrivilegeInfo, String str14, String str15, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", "", "", "", null, "", null, "", "", false, "", "", "", "", "", null, "", "", 0);
    }
}
