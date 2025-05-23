package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypeParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class UnifySearchTabContentResult implements ISSOReqModel, ISSORspModel<UnifySearchTabContentResult> {
    public final UnifySearchEmptyPageExtraInfo emptyPageExtraInfo;
    public final List<UnifySearchTabContent> resultItems;
    public final UnifySearchTabInfo tabInfo;

    public UnifySearchTabContentResult(UnifySearchTabInfo unifySearchTabInfo, List<UnifySearchTabContent> list, UnifySearchEmptyPageExtraInfo unifySearchEmptyPageExtraInfo) {
        this.tabInfo = unifySearchTabInfo;
        this.resultItems = list;
        this.emptyPageExtraInfo = unifySearchEmptyPageExtraInfo;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        UnifySearchTabInfo unifySearchTabInfo = this.tabInfo;
        if (unifySearchTabInfo != null) {
            eVar.v("tab_info", unifySearchTabInfo.encode());
        }
        b bVar = new b();
        List<UnifySearchTabContent> list = this.resultItems;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                bVar.t(((UnifySearchTabContent) it.next()).encode());
            }
        }
        eVar.v("result_items", bVar);
        UnifySearchEmptyPageExtraInfo unifySearchEmptyPageExtraInfo = this.emptyPageExtraInfo;
        if (unifySearchEmptyPageExtraInfo != null) {
            eVar.v("empty_page_extra_info", unifySearchEmptyPageExtraInfo.encode());
        }
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final UnifySearchTabContentResult decode(e eVar) {
        ArrayList arrayList;
        UnifySearchEmptyPageExtraInfo unifySearchEmptyPageExtraInfo;
        UnifySearchRichText unifySearchRichText;
        ArrayList arrayList2;
        e m3 = eVar.m("tab_info");
        UnifySearchTabInfo unifySearchTabInfo = m3 != null ? new UnifySearchTabInfo(m3.q("tab_name", ""), m3.o("tab_mask", 0L)) : null;
        b l3 = eVar.l("result_items");
        if (l3 != null) {
            arrayList = new ArrayList();
            int c16 = l3.c();
            for (int i3 = 0; i3 < c16; i3++) {
                Object d16 = l3.d(i3);
                if (d16 != null) {
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    e eVar2 = (e) d16;
                    arrayList.add(new UnifySearchTabContent(eVar2.q("id", ""), eVar2.q("name", ""), eVar2.o("tab_content_mask", 0L), eVar2.k("layout_id", 0), eVar2.q("layout_content", ""), eVar2.q(MimeTypeParser.ATTR_EXTENSION, "")));
                }
            }
        } else {
            arrayList = null;
        }
        e m16 = eVar.m("empty_page_extra_info");
        if (m16 != null) {
            String q16 = m16.q("text", "");
            String q17 = m16.q("jump_url", "");
            e m17 = m16.m("rich_text");
            if (m17 != null) {
                b l16 = m17.l("highlight_text");
                if (l16 != null) {
                    arrayList2 = new ArrayList();
                    int c17 = l16.c();
                    for (int i16 = 0; i16 < c17; i16++) {
                        Object d17 = l16.d(i16);
                        if (d17 != null) {
                            Intrinsics.checkNotNull(d17, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                            e eVar3 = (e) d17;
                            arrayList2.add(new UnifySearchText(eVar3.q("text", ""), eVar3.q("jump_link", "")));
                        }
                    }
                } else {
                    arrayList2 = null;
                }
                unifySearchRichText = new UnifySearchRichText(arrayList2);
            } else {
                unifySearchRichText = null;
            }
            unifySearchEmptyPageExtraInfo = new UnifySearchEmptyPageExtraInfo(q16, q17, unifySearchRichText, m16.q("title", ""));
        } else {
            unifySearchEmptyPageExtraInfo = null;
        }
        return new UnifySearchTabContentResult(unifySearchTabInfo, arrayList != null ? CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList) : null, unifySearchEmptyPageExtraInfo);
    }
}
