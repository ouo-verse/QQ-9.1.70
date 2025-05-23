package com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel;

import com.tencent.aegiskmm.d;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.JSONKt$forEachIndexed$typedOpt$1;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.JSONKt$forEachIndexed$typedOpt$2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.JSONKt$forEachIndexed$typedOpt$3;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.JSONKt$forEachIndexed$typedOpt$4;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.JSONKt$forEachIndexed$typedOpt$5;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.JSONKt$forEachIndexed$typedOpt$6;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.JSONKt$forEachIndexed$typedOpt$7;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.JSONKt$forEachIndexed$typedOpt$8;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* loaded from: classes31.dex */
public final class AdelieHomePageBannerConfig {
    public static final Companion Companion = new Companion();
    public List<AdelieHomePageBannerItemData> itemList;
    public long loopInterval;

    /* loaded from: classes31.dex */
    public static final class Companion {
        public final AdelieHomePageBannerConfig fromJsonString(String str) {
            Function1 jSONKt$forEachIndexed$typedOpt$8;
            e eVar = new e(str);
            long n3 = eVar.n("loop_interval");
            b l3 = eVar.l("content");
            ArrayList arrayList = new ArrayList();
            if (l3 != null) {
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(e.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    jSONKt$forEachIndexed$typedOpt$8 = new JSONKt$forEachIndexed$typedOpt$1(l3);
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    jSONKt$forEachIndexed$typedOpt$8 = new JSONKt$forEachIndexed$typedOpt$2(l3);
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    jSONKt$forEachIndexed$typedOpt$8 = new JSONKt$forEachIndexed$typedOpt$3(l3);
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    jSONKt$forEachIndexed$typedOpt$8 = new JSONKt$forEachIndexed$typedOpt$4(l3);
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                    jSONKt$forEachIndexed$typedOpt$8 = new JSONKt$forEachIndexed$typedOpt$5(l3);
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(b.class))) {
                    jSONKt$forEachIndexed$typedOpt$8 = new JSONKt$forEachIndexed$typedOpt$6(l3);
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(e.class))) {
                    jSONKt$forEachIndexed$typedOpt$8 = new JSONKt$forEachIndexed$typedOpt$7(l3);
                } else {
                    jSONKt$forEachIndexed$typedOpt$8 = new JSONKt$forEachIndexed$typedOpt$8(l3);
                }
                int c16 = l3.c();
                for (int i3 = 0; i3 < c16; i3++) {
                    Object invoke = jSONKt$forEachIndexed$typedOpt$8.invoke(Integer.valueOf(i3));
                    if (invoke != null) {
                        e eVar2 = (e) invoke;
                        AdelieHomePageBannerItemData adelieHomePageBannerItemData = new AdelieHomePageBannerItemData();
                        adelieHomePageBannerItemData.f114178id = eVar2.p("id");
                        adelieHomePageBannerItemData.name = eVar2.p("name");
                        adelieHomePageBannerItemData.picDayUrl = eVar2.p("pic_day_url");
                        adelieHomePageBannerItemData.picNightUrl = eVar2.p("pic_night_url");
                        adelieHomePageBannerItemData.picDayUrl9070 = eVar2.p("9070_pic_day_url");
                        adelieHomePageBannerItemData.picNightUrl9070 = eVar2.p("9070_pic_night_url");
                        adelieHomePageBannerItemData.scheme = eVar2.p(ZPlanPublishSource.FROM_SCHEME);
                        arrayList.add(adelieHomePageBannerItemData);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    }
                }
            }
            return new AdelieHomePageBannerConfig(n3, arrayList);
        }
    }

    public AdelieHomePageBannerConfig() {
        this(0L, null, 3, null);
    }

    public final int hashCode() {
        return this.itemList.hashCode() + (d.a(this.loopInterval) * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("AdelieHomePageBannerConfig(loopInterval=");
        m3.append(this.loopInterval);
        m3.append(", itemList=");
        m3.append(this.itemList);
        m3.append(')');
        return m3.toString();
    }

    public AdelieHomePageBannerConfig(long j3, List<AdelieHomePageBannerItemData> list) {
        this.loopInterval = j3;
        this.itemList = list;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ AdelieHomePageBannerConfig(long j3, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(5000L, r3);
        List emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdelieHomePageBannerConfig)) {
            return false;
        }
        AdelieHomePageBannerConfig adelieHomePageBannerConfig = (AdelieHomePageBannerConfig) obj;
        return this.loopInterval == adelieHomePageBannerConfig.loopInterval && Intrinsics.areEqual(this.itemList, adelieHomePageBannerConfig.itemList);
    }
}
