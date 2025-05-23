package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import defpackage.o;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class Promote implements ISSOModel {
    public static final Companion Companion = new Companion();
    public final ArrayList<PromoteData> promoteDatas;
    public final String timeTxt;
    public final String title;

    public Promote() {
        this(null, null, null, 7, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("title", this.title);
        b a16 = o.a(eVar, "time_txt", this.timeTxt);
        ArrayList<PromoteData> arrayList = this.promoteDatas;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                a16.t(((PromoteData) it.next()).encode());
            }
        }
        eVar.v("promote_datas", a16);
        return eVar;
    }

    public final int hashCode() {
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.timeTxt, this.title.hashCode() * 31, 31);
        ArrayList<PromoteData> arrayList = this.promoteDatas;
        return m3 + (arrayList == null ? 0 : arrayList.hashCode());
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Promote(title=");
        m3.append(this.title);
        m3.append(", timeTxt=");
        m3.append(this.timeTxt);
        m3.append(", promoteDatas=");
        m3.append(this.promoteDatas);
        m3.append(')');
        return m3.toString();
    }

    /* loaded from: classes31.dex */
    public static final class Companion {
        public final Promote decode(e eVar) {
            ArrayList arrayList;
            ArrayList arrayList2;
            ArrayList arrayList3;
            String q16 = eVar.q("title", "");
            String q17 = eVar.q("time_txt", "");
            b l3 = eVar.l("promote_datas");
            if (l3 != null) {
                ArrayList arrayList4 = new ArrayList();
                int c16 = l3.c();
                for (int i3 = 0; i3 < c16; i3++) {
                    Object d16 = l3.d(i3);
                    if (d16 != null) {
                        Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        e eVar2 = (e) d16;
                        String q18 = eVar2.q("key", "");
                        String q19 = eVar2.q("value", "");
                        b l16 = eVar2.l("dates");
                        if (l16 != null) {
                            ArrayList arrayList5 = new ArrayList();
                            int c17 = l16.c();
                            for (int i16 = 0; i16 < c17; i16++) {
                                String o16 = l16.o(i16);
                                if (o16 != null) {
                                    arrayList5.add(o16);
                                }
                            }
                            arrayList2 = arrayList5;
                        } else {
                            arrayList2 = null;
                        }
                        b l17 = eVar2.l("datas");
                        if (l17 != null) {
                            ArrayList arrayList6 = new ArrayList();
                            int c18 = l17.c();
                            for (int i17 = 0; i17 < c18; i17++) {
                                arrayList6.add(Long.valueOf(l17.m(i17)));
                            }
                            arrayList3 = arrayList6;
                        } else {
                            arrayList3 = null;
                        }
                        arrayList4.add(new PromoteData(q18, q19, arrayList2, arrayList3, eVar2.q("tips", "")));
                    }
                }
                arrayList = arrayList4;
            } else {
                arrayList = null;
            }
            return new Promote(q16, q17, arrayList);
        }
    }

    public Promote(String str, String str2, ArrayList<PromoteData> arrayList) {
        this.title = str;
        this.timeTxt = str2;
        this.promoteDatas = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Promote)) {
            return false;
        }
        Promote promote = (Promote) obj;
        return Intrinsics.areEqual(this.title, promote.title) && Intrinsics.areEqual(this.timeTxt, promote.timeTxt) && Intrinsics.areEqual(this.promoteDatas, promote.promoteDatas);
    }

    public /* synthetic */ Promote(String str, String str2, ArrayList arrayList, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", null);
    }
}
