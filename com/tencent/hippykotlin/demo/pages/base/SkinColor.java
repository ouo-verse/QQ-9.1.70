package com.tencent.hippykotlin.demo.pages.base;

import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.manager.c;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class SkinColor {
    public static int colorUniqueID;
    public static final Map<String, String> customTokenMap;
    public static Boolean lastNightMode;
    public static final SkinColor INSTANCE = new SkinColor();
    public static final h whiteTextColor = h.INSTANCE.m();

    static {
        Map<String, String> mapOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("", ""));
        customTokenMap = mapOf;
    }

    public final h bgColor(String str) {
        if (isNightMode(str)) {
            return SkinColorKt.access$toUniqueColor("qecommerce_skin_color_bg_backplate");
        }
        return SkinColorKt.access$toUniqueColor("qecommerce_skin_color_bg_backplate");
    }

    public final h blackTextColor(String str) {
        if (isNightMode(str)) {
            return SkinColorKt.access$toUniqueColor("qecommerce_skin_color_text_primary");
        }
        return SkinColorKt.access$toUniqueColor("qecommerce_skin_color_text_primary");
    }

    public final h fgColor(String str) {
        if (isNightMode(str)) {
            return SkinColorKt.access$toUniqueColor("qecommerce_skin_color_bg_default");
        }
        return SkinColorKt.access$toUniqueColor("qecommerce_skin_color_bg_default");
    }

    public final boolean isNightMode(String str) {
        if (!(str.length() == 0)) {
            boolean isNightMode = c.f117352a.k(str).isNightMode();
            if (!Intrinsics.areEqual(Boolean.valueOf(isNightMode), lastNightMode)) {
                lastNightMode = Boolean.valueOf(isNightMode);
                colorUniqueID++;
            }
            return isNightMode;
        }
        throw new RuntimeException("pagerId is isEmpty when call SkinColor.isNightMode");
    }

    public final h sepColor(String str) {
        if (isNightMode(str)) {
            return SkinColorKt.access$toUniqueColor("qecommerce_skin_color_divider");
        }
        return SkinColorKt.access$toUniqueColor("qecommerce_skin_color_divider");
    }

    public final h subTextColor(String str) {
        if (isNightMode(str)) {
            return SkinColorKt.access$toUniqueColor("qecommerce_skin_color_text_secondary");
        }
        return SkinColorKt.access$toUniqueColor("qecommerce_skin_color_text_secondary");
    }

    public final h tokenColor(String str, boolean z16) {
        if (z16) {
            Map<String, String> map = customTokenMap;
            if (map.get(str) == null) {
                str = StringsKt__StringsJVMKt.replace$default(str, QCircleSkinHelper.SKIN, "", false, 4, (Object) null);
            } else {
                str = String.valueOf(map.get(str));
            }
        }
        return SkinColorKt.access$toUniqueColor(str);
    }
}
