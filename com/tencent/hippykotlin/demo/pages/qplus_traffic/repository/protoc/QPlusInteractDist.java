package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterProductInfo$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class QPlusInteractDist implements ISSOReqModel, ISSORspModel<QPlusInteractDist> {
    public final ArrayList<QPlusTimeDist> commentDist;
    public final ArrayList<QPlusTimeDist> favorDist;
    public final ArrayList<QPlusTimeDist> followDist;
    public final ArrayList<QPlusTimeDist> shareDist;
    public final ArrayList<QPlusTimeDist> viewDist;

    public QPlusInteractDist(ArrayList<QPlusTimeDist> arrayList, ArrayList<QPlusTimeDist> arrayList2, ArrayList<QPlusTimeDist> arrayList3, ArrayList<QPlusTimeDist> arrayList4, ArrayList<QPlusTimeDist> arrayList5) {
        this.viewDist = arrayList;
        this.commentDist = arrayList2;
        this.followDist = arrayList3;
        this.shareDist = arrayList4;
        this.favorDist = arrayList5;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        b bVar = new b();
        ArrayList<QPlusTimeDist> arrayList = this.viewDist;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.t(((QPlusTimeDist) it.next()).encode());
            }
        }
        b m3 = GoodsCenterProductInfo$$ExternalSyntheticOutline0.m(eVar, "view_dist", bVar);
        ArrayList<QPlusTimeDist> arrayList2 = this.commentDist;
        if (arrayList2 != null) {
            Iterator<T> it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                m3.t(((QPlusTimeDist) it5.next()).encode());
            }
        }
        b m16 = GoodsCenterProductInfo$$ExternalSyntheticOutline0.m(eVar, "comment_dist", m3);
        ArrayList<QPlusTimeDist> arrayList3 = this.followDist;
        if (arrayList3 != null) {
            Iterator<T> it6 = arrayList3.iterator();
            while (it6.hasNext()) {
                m16.t(((QPlusTimeDist) it6.next()).encode());
            }
        }
        b m17 = GoodsCenterProductInfo$$ExternalSyntheticOutline0.m(eVar, "follow_dist", m16);
        ArrayList<QPlusTimeDist> arrayList4 = this.shareDist;
        if (arrayList4 != null) {
            Iterator<T> it7 = arrayList4.iterator();
            while (it7.hasNext()) {
                m17.t(((QPlusTimeDist) it7.next()).encode());
            }
        }
        b m18 = GoodsCenterProductInfo$$ExternalSyntheticOutline0.m(eVar, "share_dist", m17);
        ArrayList<QPlusTimeDist> arrayList5 = this.favorDist;
        if (arrayList5 != null) {
            Iterator<T> it8 = arrayList5.iterator();
            while (it8.hasNext()) {
                m18.t(((QPlusTimeDist) it8.next()).encode());
            }
        }
        eVar.v("favor_dist", m18);
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusInteractDist decode(e eVar) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        b l3 = eVar.l("view_dist");
        if (l3 != null) {
            ArrayList arrayList6 = new ArrayList();
            int c16 = l3.c();
            for (int i3 = 0; i3 < c16; i3++) {
                Object d16 = l3.d(i3);
                if (d16 != null) {
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    e eVar2 = (e) d16;
                    arrayList6.add(new QPlusTimeDist(eVar2.q("time_at", ""), eVar2.k("percent", 0)));
                }
            }
            arrayList = arrayList6;
        } else {
            arrayList = null;
        }
        b l16 = eVar.l("comment_dist");
        if (l16 != null) {
            ArrayList arrayList7 = new ArrayList();
            int c17 = l16.c();
            for (int i16 = 0; i16 < c17; i16++) {
                Object d17 = l16.d(i16);
                if (d17 != null) {
                    Intrinsics.checkNotNull(d17, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    e eVar3 = (e) d17;
                    arrayList7.add(new QPlusTimeDist(eVar3.q("time_at", ""), eVar3.k("percent", 0)));
                }
            }
            arrayList2 = arrayList7;
        } else {
            arrayList2 = null;
        }
        b l17 = eVar.l("follow_dist");
        if (l17 != null) {
            ArrayList arrayList8 = new ArrayList();
            int c18 = l17.c();
            for (int i17 = 0; i17 < c18; i17++) {
                Object d18 = l17.d(i17);
                if (d18 != null) {
                    Intrinsics.checkNotNull(d18, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    e eVar4 = (e) d18;
                    arrayList8.add(new QPlusTimeDist(eVar4.q("time_at", ""), eVar4.k("percent", 0)));
                }
            }
            arrayList3 = arrayList8;
        } else {
            arrayList3 = null;
        }
        b l18 = eVar.l("share_dist");
        if (l18 != null) {
            ArrayList arrayList9 = new ArrayList();
            int c19 = l18.c();
            for (int i18 = 0; i18 < c19; i18++) {
                Object d19 = l18.d(i18);
                if (d19 != null) {
                    Intrinsics.checkNotNull(d19, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    e eVar5 = (e) d19;
                    arrayList9.add(new QPlusTimeDist(eVar5.q("time_at", ""), eVar5.k("percent", 0)));
                }
            }
            arrayList4 = arrayList9;
        } else {
            arrayList4 = null;
        }
        b l19 = eVar.l("favor_dist");
        if (l19 != null) {
            ArrayList arrayList10 = new ArrayList();
            int c26 = l19.c();
            for (int i19 = 0; i19 < c26; i19++) {
                Object d26 = l19.d(i19);
                if (d26 != null) {
                    Intrinsics.checkNotNull(d26, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    e eVar6 = (e) d26;
                    arrayList10.add(new QPlusTimeDist(eVar6.q("time_at", ""), eVar6.k("percent", 0)));
                }
            }
            arrayList5 = arrayList10;
        } else {
            arrayList5 = null;
        }
        return new QPlusInteractDist(arrayList, arrayList2, arrayList3, arrayList4, arrayList5);
    }
}
