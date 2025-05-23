package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes32.dex */
public final class UnifySearchEmptyPageExtraInfo implements ISSOReqModel, ISSORspModel<UnifySearchEmptyPageExtraInfo> {
    public final String jumpUrl;
    public final UnifySearchRichText richText;
    public final String text;
    public final String title;

    public UnifySearchEmptyPageExtraInfo(String str, String str2, UnifySearchRichText unifySearchRichText, String str3) {
        this.text = str;
        this.jumpUrl = str2;
        this.richText = unifySearchRichText;
        this.title = str3;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("text", this.text);
        eVar.v("jump_url", this.jumpUrl);
        UnifySearchRichText unifySearchRichText = this.richText;
        if (unifySearchRichText != null) {
            eVar.v("rich_text", unifySearchRichText.encode());
        }
        eVar.v("title", this.title);
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final UnifySearchEmptyPageExtraInfo decode(e eVar) {
        String q16 = eVar.q("text", "");
        String q17 = eVar.q("jump_url", "");
        e m3 = eVar.m("rich_text");
        UnifySearchRichText unifySearchRichText = null;
        ArrayList arrayList = null;
        if (m3 != null) {
            b l3 = m3.l("highlight_text");
            if (l3 != null) {
                arrayList = new ArrayList();
                int c16 = l3.c();
                for (int i3 = 0; i3 < c16; i3++) {
                    Object d16 = l3.d(i3);
                    if (d16 != null) {
                        Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        e eVar2 = (e) d16;
                        arrayList.add(new UnifySearchText(eVar2.q("text", ""), eVar2.q("jump_link", "")));
                    }
                }
            }
            unifySearchRichText = new UnifySearchRichText(arrayList);
        }
        return new UnifySearchEmptyPageExtraInfo(q16, q17, unifySearchRichText, eVar.q("title", ""));
    }
}
