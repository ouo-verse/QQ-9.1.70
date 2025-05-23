package com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed;

import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.advertisement.Button;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.advertisement.GameInfo;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.advertisement.Redirect;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import defpackage.o;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AdCard implements ISSOReqModel, ISSORspModel<AdCard> {
    public final Button button;
    public final GameInfo gameInfo;
    public final ArrayList<Redirect> jumpInfo;
    public final String picUrl;
    public final String subTitle;
    public final String subscribeSucUrl;
    public final String title;

    public AdCard(String str, String str2, String str3, ArrayList<Redirect> arrayList, Button button, GameInfo gameInfo, String str4) {
        this.picUrl = str;
        this.title = str2;
        this.subTitle = str3;
        this.jumpInfo = arrayList;
        this.button = button;
        this.gameInfo = gameInfo;
        this.subscribeSucUrl = str4;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("pic_url", this.picUrl);
        eVar.v("title", this.title);
        b a16 = o.a(eVar, "sub_title", this.subTitle);
        ArrayList<Redirect> arrayList = this.jumpInfo;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                a16.t(((Redirect) it.next()).encode());
            }
        }
        eVar.v("jump_info", a16);
        Button button = this.button;
        if (button != null) {
            eVar.v("button", button.encode());
        }
        GameInfo gameInfo = this.gameInfo;
        if (gameInfo != null) {
            eVar.v("game_info", gameInfo.encode());
        }
        eVar.v("subscribe_suc_url", this.subscribeSucUrl);
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final AdCard decode(e eVar) {
        ArrayList arrayList;
        Button button;
        ArrayList arrayList2;
        b bVar;
        String str;
        String str2;
        b bVar2;
        int i3;
        String q16 = eVar.q("pic_url", "");
        String q17 = eVar.q("title", "");
        String q18 = eVar.q("sub_title", "");
        b l3 = eVar.l("jump_info");
        String str3 = "jump_type";
        String str4 = "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject";
        int i16 = 0;
        if (l3 != null) {
            arrayList = new ArrayList();
            int c16 = l3.c();
            int i17 = 0;
            while (i17 < c16) {
                Object d16 = l3.d(i17);
                if (d16 != null) {
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    e eVar2 = (e) d16;
                    bVar2 = l3;
                    i3 = c16;
                    arrayList.add(new Redirect(eVar2.k("jump_type", i16), eVar2.q("url", ""), eVar2.k("weight", i16)));
                } else {
                    bVar2 = l3;
                    i3 = c16;
                }
                i17++;
                l3 = bVar2;
                c16 = i3;
                i16 = 0;
            }
        } else {
            arrayList = null;
        }
        e m3 = eVar.m("button");
        if (m3 != null) {
            String q19 = m3.q(QZoneAdTianshuFeedData.KEY_BUTTON_TEXT, "");
            String q26 = m3.q("button_bg_color", "");
            b l16 = m3.l("jump_info");
            if (l16 != null) {
                arrayList2 = new ArrayList();
                int c17 = l16.c();
                int i18 = 0;
                while (i18 < c17) {
                    int i19 = c17;
                    Object d17 = l16.d(i18);
                    if (d17 != null) {
                        Intrinsics.checkNotNull(d17, str4);
                        e eVar3 = (e) d17;
                        bVar = l16;
                        str2 = str4;
                        str = str3;
                        arrayList2.add(new Redirect(eVar3.k(str3, 0), eVar3.q("url", ""), eVar3.k("weight", 0)));
                    } else {
                        bVar = l16;
                        str = str3;
                        str2 = str4;
                    }
                    i18++;
                    c17 = i19;
                    l16 = bVar;
                    str4 = str2;
                    str3 = str;
                }
            } else {
                arrayList2 = null;
            }
            button = new Button(q19, q26, arrayList2);
        } else {
            button = null;
        }
        e m16 = eVar.m("game_info");
        return new AdCard(q16, q17, q18, arrayList, button, m16 != null ? new GameInfo(null, null, null).decode(m16) : null, eVar.q("subscribe_suc_url", ""));
    }
}
