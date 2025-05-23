package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

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
/* loaded from: classes32.dex */
public final class UnifySearchNetResultTabsRsp implements ISSOReqModel, ISSORspModel<UnifySearchNetResultTabsRsp> {
    public final String errorMsg;
    public final UnifySearchGroupSearchFilterCondition groupFilterCondition;
    public final int resultCode;
    public final int searchHistoryCount;
    public final List<UnifySearchTabInfo> tabs;

    public UnifySearchNetResultTabsRsp() {
        this(0, null, null, null, 0, 31, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final UnifySearchNetResultTabsRsp decode(e eVar) {
        ArrayList arrayList;
        List list;
        int k3 = eVar.k("result_code", 0);
        String q16 = eVar.q("error_msg", "");
        b l3 = eVar.l("tabs");
        List list2 = null;
        if (l3 != null) {
            arrayList = new ArrayList();
            int c16 = l3.c();
            for (int i3 = 0; i3 < c16; i3++) {
                Object d16 = l3.d(i3);
                if (d16 != null) {
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    e eVar2 = (e) d16;
                    arrayList.add(new UnifySearchTabInfo(eVar2.q("tab_name", ""), eVar2.o("tab_mask", 0L)));
                }
            }
        } else {
            arrayList = null;
        }
        e m3 = eVar.m("group_filter_condition");
        UnifySearchGroupSearchFilterCondition decode = m3 != null ? new UnifySearchGroupSearchFilterCondition(null, null, null).decode(m3) : null;
        int k16 = eVar.k("searchHistoryCount", 0);
        if (arrayList != null) {
            list = CollectionsKt___CollectionsKt.toList(arrayList);
            list2 = list;
        }
        return new UnifySearchNetResultTabsRsp(k3, q16, list2, decode, k16);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.t("result_code", this.resultCode);
        b a16 = o.a(eVar, "error_msg", this.errorMsg);
        List<UnifySearchTabInfo> list = this.tabs;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                a16.t(((UnifySearchTabInfo) it.next()).encode());
            }
        }
        eVar.v("tabs", a16);
        UnifySearchGroupSearchFilterCondition unifySearchGroupSearchFilterCondition = this.groupFilterCondition;
        if (unifySearchGroupSearchFilterCondition != null) {
            eVar.v("group_filter_condition", unifySearchGroupSearchFilterCondition.encode());
        }
        eVar.t("searchHistoryCount", this.searchHistoryCount);
        return eVar;
    }

    public UnifySearchNetResultTabsRsp(int i3, String str, List<UnifySearchTabInfo> list, UnifySearchGroupSearchFilterCondition unifySearchGroupSearchFilterCondition, int i16) {
        this.resultCode = i3;
        this.errorMsg = str;
        this.tabs = list;
        this.groupFilterCondition = unifySearchGroupSearchFilterCondition;
        this.searchHistoryCount = i16;
    }

    public /* synthetic */ UnifySearchNetResultTabsRsp(int i3, String str, List list, UnifySearchGroupSearchFilterCondition unifySearchGroupSearchFilterCondition, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "", null, null, 0);
    }
}
