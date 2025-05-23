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
public final class QPlusQueryPromotionOptionsRsp implements ISSOReqModel, ISSORspModel<QPlusQueryPromotionOptionsRsp> {
    public final ArrayList<QPlusCoinSetting> coinSettings;
    public final ArrayList<QPlusPromotioOption> promotionOptions;

    public QPlusQueryPromotionOptionsRsp(ArrayList<QPlusPromotioOption> arrayList, ArrayList<QPlusCoinSetting> arrayList2) {
        this.promotionOptions = arrayList;
        this.coinSettings = arrayList2;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        b bVar = new b();
        ArrayList<QPlusPromotioOption> arrayList = this.promotionOptions;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.t(((QPlusPromotioOption) it.next()).encode());
            }
        }
        b m3 = GoodsCenterProductInfo$$ExternalSyntheticOutline0.m(eVar, "promotion_options", bVar);
        ArrayList<QPlusCoinSetting> arrayList2 = this.coinSettings;
        if (arrayList2 != null) {
            Iterator<T> it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                m3.t(((QPlusCoinSetting) it5.next()).encode());
            }
        }
        eVar.v("coin_settings", m3);
        return eVar;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusQueryPromotionOptionsRsp decode(e eVar) {
        ArrayList arrayList;
        ArrayList arrayList2;
        b l3 = eVar.l("promotion_options");
        if (l3 != null) {
            arrayList = new ArrayList();
            int c16 = l3.c();
            for (int i3 = 0; i3 < c16; i3++) {
                Object d16 = l3.d(i3);
                if (d16 != null) {
                    QPlusPromotioOption qPlusPromotioOption = new QPlusPromotioOption(null, 0, null, null, null, 31, null);
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    arrayList.add(qPlusPromotioOption.decode((e) d16));
                }
            }
        } else {
            arrayList = null;
        }
        b l16 = eVar.l("coin_settings");
        if (l16 != null) {
            arrayList2 = new ArrayList();
            int c17 = l16.c();
            for (int i16 = 0; i16 < c17; i16++) {
                Object d17 = l16.d(i16);
                if (d17 != null) {
                    Intrinsics.checkNotNull(d17, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    e eVar2 = (e) d17;
                    arrayList2.add(new QPlusCoinSetting(eVar2.q("setting_id", ""), eVar2.k("amount", 0), eVar2.k("coin_discount", 0), eVar2.k("coin_type", 0), eVar2.k("max_amount_limit", 0)));
                }
            }
        } else {
            arrayList2 = null;
        }
        return new QPlusQueryPromotionOptionsRsp(arrayList, arrayList2);
    }
}
