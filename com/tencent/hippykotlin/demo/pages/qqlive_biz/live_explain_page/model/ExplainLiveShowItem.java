package com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.model;

import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class ExplainLiveShowItem {
    public ArrayList<ExplainHotLabel> hotLabels;
    public ExplainActivePicInfo mainCover;

    public final void decode(e eVar) {
        e m3 = eVar.m("main_cover");
        if (m3 != null) {
            ExplainActivePicInfo explainActivePicInfo = new ExplainActivePicInfo();
            this.mainCover = explainActivePicInfo;
            explainActivePicInfo.decode(m3);
        }
        e m16 = eVar.m("title_icon");
        if (m16 != null) {
            m16.q("url", "");
            m16.k("width", 0);
            m16.k("height", 0);
        }
        b l3 = eVar.l("hot_labels");
        if (l3 != null) {
            this.hotLabels = new ArrayList<>();
            int c16 = l3.c();
            for (int i3 = 0; i3 < c16; i3++) {
                Object d16 = l3.d(i3);
                if (d16 != null) {
                    ExplainHotLabel explainHotLabel = new ExplainHotLabel();
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    e eVar2 = (e) d16;
                    eVar2.q("text_color", "");
                    eVar2.q(LayoutAttrDefine.BorderColor, "");
                    eVar2.q("text_prefix", "");
                    explainHotLabel.text = eVar2.q("text", "");
                    ArrayList<ExplainHotLabel> arrayList = this.hotLabels;
                    if (arrayList != null) {
                        arrayList.add(explainHotLabel);
                    }
                }
            }
        }
        e m17 = eVar.m("price");
        if (m17 != null) {
            m17.k("price", 0);
            m17.q("prices_txt", "");
            m17.q("prices_suffix", "");
            m17.q("integer_txt", "");
            m17.q("decimal_txt", "");
        }
    }
}
