package com.tencent.hippykotlin.demo.pages.goods_center.report;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterActiveInfo;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterExtraField;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterFilterCond;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterFilterOption;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterProductInfo;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterRangeCond;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterReporter {
    public static final GoodsCenterReporter INSTANCE = new GoodsCenterReporter();

    public final b getReportFilterList(List<GoodsCenterFilterCond> list, List<GoodsCenterRangeCond> list2) {
        Object obj;
        b bVar = new b();
        if (list != null) {
            for (GoodsCenterFilterCond goodsCenterFilterCond : list) {
                e eVar = new e();
                eVar.v("filter_name", goodsCenterFilterCond.name);
                List<GoodsCenterFilterOption> list3 = goodsCenterFilterCond.options;
                b bVar2 = new b();
                if (list3 != null) {
                    Iterator<GoodsCenterFilterOption> it = list3.iterator();
                    while (it.hasNext()) {
                        bVar2.t(it.next().name);
                    }
                }
                eVar.v("filter_option", bVar2);
                bVar.t(eVar);
            }
        }
        if (list2 != null) {
            for (GoodsCenterRangeCond goodsCenterRangeCond : list2) {
                long j3 = goodsCenterRangeCond.lower;
                boolean z16 = j3 != -1;
                boolean z17 = goodsCenterRangeCond.upper != -1;
                if (z16 || z17) {
                    Object obj2 = "";
                    if (!z16) {
                        obj = "";
                    } else {
                        obj = Long.valueOf(j3);
                    }
                    if (z17) {
                        obj2 = Long.valueOf(goodsCenterRangeCond.upper);
                    }
                    e eVar2 = new e();
                    eVar2.v("filter_name", goodsCenterRangeCond.name);
                    eVar2.v("lower", obj);
                    eVar2.v("upper", obj2);
                    bVar.t(eVar2);
                }
            }
        }
        return bVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x005f, code lost:
    
        if (r1 != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final e paramsWithProduct(GoodsCenterProductInfo goodsCenterProductInfo) {
        Object first;
        Object last;
        Object first2;
        Object last2;
        boolean contains$default;
        boolean contains$default2;
        e eVar = new e();
        eVar.v("saas_id", goodsCenterProductInfo.saasTypeStr);
        eVar.v(ReportDataBuilder.KEY_PRODUCT_ID, goodsCenterProductInfo.saasProductId);
        eVar.t("goods_type", goodsCenterProductInfo.goodsType);
        eVar.v("product_name", goodsCenterProductInfo.title);
        eVar.v("commission", "");
        eVar.v("product_price", "");
        eVar.u("product_sales", goodsCenterProductInfo.sales);
        if (goodsCenterProductInfo.goodsType == 3) {
            boolean z16 = false;
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) goodsCenterProductInfo.saasProductId, (CharSequence) "txvideovip", false, 2, (Object) null);
            if (!contains$default) {
                contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) goodsCenterProductInfo.saasProductId, (CharSequence) "txvideojdunion", false, 2, (Object) null);
            }
            z16 = true;
            eVar.v("txvideo_type", String.valueOf(z16 ? 1 : 2));
            eVar.v("commission_range", String.valueOf(goodsCenterProductInfo.commissions));
            eVar.v("price_range", String.valueOf(goodsCenterProductInfo.prices));
        } else {
            eVar.v("commission", String.valueOf(goodsCenterProductInfo.commission));
            eVar.v("product_price", String.valueOf(goodsCenterProductInfo.price));
        }
        ArrayList<Long> arrayList = goodsCenterProductInfo.prices;
        if (arrayList != null && (!arrayList.isEmpty())) {
            first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
            long longValue = ((Number) first2).longValue();
            last2 = CollectionsKt___CollectionsKt.last((List<? extends Object>) arrayList);
            long longValue2 = ((Number) last2).longValue();
            e eVar2 = new e();
            eVar2.u("lower", longValue);
            eVar2.u("upper", longValue2);
            eVar.v("price_range", eVar2.toString());
        }
        ArrayList<Long> arrayList2 = goodsCenterProductInfo.commissions;
        if (arrayList2 != null && (!arrayList2.isEmpty())) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList2);
            long longValue3 = ((Number) first).longValue();
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) arrayList2);
            long longValue4 = ((Number) last).longValue();
            e eVar3 = new e();
            eVar3.u("lower", longValue3);
            eVar3.u("upper", longValue4);
            eVar.v("commission_range", eVar3.toString());
        }
        ArrayList<GoodsCenterExtraField> arrayList3 = goodsCenterProductInfo.extraFields;
        if (arrayList3 != null) {
            for (GoodsCenterExtraField goodsCenterExtraField : arrayList3) {
                eVar.v(goodsCenterExtraField.f114196k, goodsCenterExtraField.f114197v);
            }
        }
        GoodsCenterActiveInfo goodsCenterActiveInfo = goodsCenterProductInfo.qshopActiveInfo;
        if (goodsCenterActiveInfo != null) {
            eVar.v("activity_id", goodsCenterActiveInfo.activeId);
            eVar.t("activity_type", goodsCenterActiveInfo.activeType);
        }
        return eVar;
    }

    public final void reportDT(String str, e eVar) {
        e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("bus_id", GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0.m(BridgeManager.f117344a, c.f117352a, WadlProxyConsts.CHANNEL));
        Iterator<String> c16 = eVar.c();
        while (c16.hasNext()) {
            String next = c16.next();
            m3.v(next, eVar.p(next));
        }
        Utils.INSTANCE.currentBridgeModule().reportDT(str, m3);
    }
}
