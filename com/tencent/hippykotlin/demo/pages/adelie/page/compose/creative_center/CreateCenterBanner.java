package com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.JSONKt$forEachIndexed$typedOpt$1;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.JSONKt$forEachIndexed$typedOpt$2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.JSONKt$forEachIndexed$typedOpt$3;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.JSONKt$forEachIndexed$typedOpt$4;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.JSONKt$forEachIndexed$typedOpt$5;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.JSONKt$forEachIndexed$typedOpt$6;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.JSONKt$forEachIndexed$typedOpt$7;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.JSONKt$forEachIndexed$typedOpt$8;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class CreateCenterBanner {
    public static final Companion Companion = new Companion();
    public final List<CreateCenterBannerItem> banner;
    public final String createCenterBkgUrlDay;
    public final String createCenterBkgUrlNight;

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public static final class Companion {
        public final CreateCenterBanner fromJsonString(String str) {
            Function1 jSONKt$forEachIndexed$typedOpt$8;
            e eVar = new e(str);
            b l3 = eVar.l("banner");
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
                        arrayList.add(new CreateCenterBannerItem(eVar2.q("url", ""), eVar2.q("title", "")));
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    }
                }
            }
            return new CreateCenterBanner(arrayList, eVar.q("createCenterBkgUrlDay", "https://bot-resource-1251316161.file.myqcloud.com/media/create_center_card_day_1.png"), eVar.q("createCenterBkgUrlNight", "https://bot-resource-1251316161.file.myqcloud.com/media/create_center_card_night_1.png"));
        }
    }

    public CreateCenterBanner() {
        this(null, null, null, 7, null);
    }

    public final int hashCode() {
        return this.createCenterBkgUrlNight.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.createCenterBkgUrlDay, this.banner.hashCode() * 31, 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("CreateCenterBanner(banner=");
        m3.append(this.banner);
        m3.append(", createCenterBkgUrlDay=");
        m3.append(this.createCenterBkgUrlDay);
        m3.append(", createCenterBkgUrlNight=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.createCenterBkgUrlNight, ')');
    }

    public CreateCenterBanner(List<CreateCenterBannerItem> list, String str, String str2) {
        this.banner = list;
        this.createCenterBkgUrlDay = str;
        this.createCenterBkgUrlNight = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CreateCenterBanner)) {
            return false;
        }
        CreateCenterBanner createCenterBanner = (CreateCenterBanner) obj;
        return Intrinsics.areEqual(this.banner, createCenterBanner.banner) && Intrinsics.areEqual(this.createCenterBkgUrlDay, createCenterBanner.createCenterBkgUrlDay) && Intrinsics.areEqual(this.createCenterBkgUrlNight, createCenterBanner.createCenterBkgUrlNight);
    }

    public /* synthetic */ CreateCenterBanner(List list, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(new ArrayList(), "https://bot-resource-1251316161.file.myqcloud.com/media/create_center_card_day_1.png", "https://bot-resource-1251316161.file.myqcloud.com/media/create_center_card_night_1.png");
    }
}
