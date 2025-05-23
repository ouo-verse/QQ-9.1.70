package com.tencent.hippykotlin.demo.pages.base;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotViewKt$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.h;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class SkinColorKt {
    public static final h access$toUniqueColor(String str) {
        StringBuilder m3 = HotViewKt$$ExternalSyntheticOutline0.m(str, "_color_unique_id_");
        m3.append(SkinColor.colorUniqueID);
        return new h(m3.toString());
    }
}
