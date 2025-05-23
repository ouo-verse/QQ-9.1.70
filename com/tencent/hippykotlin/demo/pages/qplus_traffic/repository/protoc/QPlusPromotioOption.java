package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import defpackage.o;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class QPlusPromotioOption implements ISSOReqModel, ISSORspModel<QPlusPromotioOption> {
    public final int contentType;
    public final ArrayList<QPlusImproveOption> improveOptions;
    public final String mainText;
    public final String promotionId;
    public final String subText;

    public QPlusPromotioOption() {
        this(null, 0, null, null, null, 31, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("promotion_id", this.promotionId);
        eVar.t("content_type", this.contentType);
        eVar.v("main_text", this.mainText);
        b a16 = o.a(eVar, "sub_text", this.subText);
        ArrayList<QPlusImproveOption> arrayList = this.improveOptions;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                a16.t(((QPlusImproveOption) it.next()).encode());
            }
        }
        eVar.v("improve_options", a16);
        return eVar;
    }

    public QPlusPromotioOption(String str, int i3, String str2, String str3, ArrayList<QPlusImproveOption> arrayList) {
        this.promotionId = str;
        this.contentType = i3;
        this.mainText = str2;
        this.subText = str3;
        this.improveOptions = arrayList;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusPromotioOption decode(e eVar) {
        ArrayList arrayList;
        b bVar;
        String str;
        QPlusExpectSetting qPlusExpectSetting;
        String q16 = eVar.q("promotion_id", "");
        int i3 = 0;
        int k3 = eVar.k("content_type", 0);
        String str2 = "main_text";
        String q17 = eVar.q("main_text", "");
        String q18 = eVar.q("sub_text", "");
        b l3 = eVar.l("improve_options");
        if (l3 != null) {
            arrayList = new ArrayList();
            int c16 = l3.c();
            int i16 = 0;
            while (i16 < c16) {
                Object d16 = l3.d(i16);
                if (d16 != null) {
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    e eVar2 = (e) d16;
                    String q19 = eVar2.q("improve_id", "");
                    int k16 = eVar2.k("improve_type", i3);
                    String q26 = eVar2.q("text", "");
                    e m3 = eVar2.m("expect_setting");
                    if (m3 != null) {
                        bVar = l3;
                        str = str2;
                        qPlusExpectSetting = new QPlusExpectSetting(m3.q("setting_id", ""), m3.q(str2, ""), m3.o("lower_limit", 0L), m3.o("upper_limit", 0L), m3.q("sub_text", ""), m3.o("sub_lower_limit", 0L), m3.o("sub_upper_limit", 0L));
                    } else {
                        bVar = l3;
                        str = str2;
                        qPlusExpectSetting = null;
                    }
                    arrayList.add(new QPlusImproveOption(q19, k16, q26, qPlusExpectSetting));
                } else {
                    bVar = l3;
                    str = str2;
                }
                i16++;
                str2 = str;
                l3 = bVar;
                i3 = 0;
            }
        } else {
            arrayList = null;
        }
        return new QPlusPromotioOption(q16, k3, q17, q18, arrayList);
    }

    public /* synthetic */ QPlusPromotioOption(String str, int i3, String str2, String str3, ArrayList arrayList, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this("", 0, "", "", null);
    }
}
