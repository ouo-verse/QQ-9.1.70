package com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.advertisement;

import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import defpackage.o;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class Button implements ISSOReqModel, ISSORspModel<Button> {
    public final String buttonBgColor;
    public final String buttonText;
    public final ArrayList<Redirect> jumpInfo;

    public Button(String str, String str2, ArrayList<Redirect> arrayList) {
        this.buttonText = str;
        this.buttonBgColor = str2;
        this.jumpInfo = arrayList;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v(QZoneAdTianshuFeedData.KEY_BUTTON_TEXT, this.buttonText);
        b a16 = o.a(eVar, "button_bg_color", this.buttonBgColor);
        ArrayList<Redirect> arrayList = this.jumpInfo;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                a16.t(((Redirect) it.next()).encode());
            }
        }
        eVar.v("jump_info", a16);
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final Button decode(e eVar) {
        ArrayList arrayList;
        String q16 = eVar.q(QZoneAdTianshuFeedData.KEY_BUTTON_TEXT, "");
        String q17 = eVar.q("button_bg_color", "");
        b l3 = eVar.l("jump_info");
        if (l3 != null) {
            arrayList = new ArrayList();
            int c16 = l3.c();
            for (int i3 = 0; i3 < c16; i3++) {
                Object d16 = l3.d(i3);
                if (d16 != null) {
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    e eVar2 = (e) d16;
                    arrayList.add(new Redirect(eVar2.k("jump_type", 0), eVar2.q("url", ""), eVar2.k("weight", 0)));
                }
            }
        } else {
            arrayList = null;
        }
        return new Button(q16, q17, arrayList);
    }
}
