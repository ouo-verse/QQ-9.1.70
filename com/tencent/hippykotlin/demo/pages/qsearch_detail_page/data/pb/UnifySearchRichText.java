package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class UnifySearchRichText implements ISSOReqModel, ISSORspModel<UnifySearchRichText> {
    public final List<UnifySearchText> highlightText;

    public UnifySearchRichText(List<UnifySearchText> list) {
        this.highlightText = list;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        b bVar = new b();
        List<UnifySearchText> list = this.highlightText;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                bVar.t(((UnifySearchText) it.next()).encode());
            }
        }
        eVar.v("highlight_text", bVar);
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final UnifySearchRichText decode(e eVar) {
        ArrayList arrayList;
        b l3 = eVar.l("highlight_text");
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
        } else {
            arrayList = null;
        }
        return new UnifySearchRichText(arrayList);
    }
}
