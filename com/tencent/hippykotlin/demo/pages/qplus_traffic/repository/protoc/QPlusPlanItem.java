package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class QPlusPlanItem implements ISSOReqModel, ISSORspModel<QPlusPlanItem> {
    public final String contentId;
    public final int contentType;
    public final String date;
    public final String icon;
    public final ArrayList<QPlusIndex> indexs;
    public final String planId;
    public final int planStatus;
    public final QPlusProgress progress;
    public final String title;

    public QPlusPlanItem() {
        this(null, 0, null, null, 0, null, null, null, null, 511, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("plan_id", this.planId);
        eVar.t("plan_status", this.planStatus);
        eVar.v("date", this.date);
        eVar.v("content_id", this.contentId);
        eVar.t("content_type", this.contentType);
        eVar.v("title", this.title);
        eVar.v("icon", this.icon);
        QPlusProgress qPlusProgress = this.progress;
        if (qPlusProgress != null) {
            eVar.v("progress", qPlusProgress.encode());
        }
        b bVar = new b();
        ArrayList<QPlusIndex> arrayList = this.indexs;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.t(((QPlusIndex) it.next()).encode());
            }
        }
        eVar.v("indexs", bVar);
        return eVar;
    }

    public QPlusPlanItem(String str, int i3, String str2, String str3, int i16, String str4, String str5, QPlusProgress qPlusProgress, ArrayList<QPlusIndex> arrayList) {
        this.planId = str;
        this.planStatus = i3;
        this.date = str2;
        this.contentId = str3;
        this.contentType = i16;
        this.title = str4;
        this.icon = str5;
        this.progress = qPlusProgress;
        this.indexs = arrayList;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusPlanItem decode(e eVar) {
        ArrayList arrayList;
        b bVar;
        String q16 = eVar.q("plan_id", "");
        int k3 = eVar.k("plan_status", 0);
        String q17 = eVar.q("date", "");
        String q18 = eVar.q("content_id", "");
        int k16 = eVar.k("content_type", 0);
        String q19 = eVar.q("title", "");
        String q26 = eVar.q("icon", "");
        e m3 = eVar.m("progress");
        QPlusProgress qPlusProgress = m3 != null ? new QPlusProgress(m3.k("expect_covers", 0), m3.k("actual_covers", 0), m3.k("percent", 0)) : null;
        b l3 = eVar.l("indexs");
        if (l3 != null) {
            ArrayList arrayList2 = new ArrayList();
            int c16 = l3.c();
            int i3 = 0;
            while (i3 < c16) {
                Object d16 = l3.d(i3);
                if (d16 != null) {
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    e eVar2 = (e) d16;
                    bVar = l3;
                    arrayList2.add(new QPlusIndex(eVar2.q("index_name", ""), eVar2.k("cnt", 0)));
                } else {
                    bVar = l3;
                }
                i3++;
                l3 = bVar;
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return new QPlusPlanItem(q16, k3, q17, q18, k16, q19, q26, qPlusProgress, arrayList);
    }

    public /* synthetic */ QPlusPlanItem(String str, int i3, String str2, String str3, int i16, String str4, String str5, QPlusProgress qPlusProgress, ArrayList arrayList, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this("", 0, "", "", 0, "", "", null, null);
    }
}
