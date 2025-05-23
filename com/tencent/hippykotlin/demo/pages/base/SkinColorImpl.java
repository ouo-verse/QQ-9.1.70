package com.tencent.hippykotlin.demo.pages.base;

import com.tencent.kuikly.core.base.h;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class SkinColorImpl implements ISkinColor {
    public final String pagerId;

    public SkinColorImpl(String str) {
        this.pagerId = str;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISkinColor
    public final h getBackgroundColor() {
        return SkinColor.INSTANCE.bgColor(this.pagerId);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISkinColor
    public final h getDividerColor() {
        return SkinColor.INSTANCE.sepColor(this.pagerId);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISkinColor
    public final h getForegroundColor() {
        return SkinColor.INSTANCE.fgColor(this.pagerId);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISkinColor
    public final h getPrimaryTextColor() {
        return SkinColor.INSTANCE.blackTextColor(this.pagerId);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISkinColor
    public final h getRedTextColor() {
        if (SkinColor.INSTANCE.isNightMode(this.pagerId)) {
            return SkinColorKt.access$toUniqueColor("qecommerce_skin_color_text_red_brand");
        }
        return SkinColorKt.access$toUniqueColor("qecommerce_skin_color_text_red_brand");
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISkinColor
    public final h getSecondaryTextColor() {
        return SkinColor.INSTANCE.subTextColor(this.pagerId);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISkinColor
    public final h getSkeletonColor() {
        if (SkinColor.INSTANCE.isNightMode(this.pagerId)) {
            return SkinColorKt.access$toUniqueColor("qecommerce_skin_color_bg_skeleton_loading_start");
        }
        return SkinColorKt.access$toUniqueColor("qecommerce_skin_color_bg_skeleton_loading_start");
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISkinColor
    public final h tokenColor(String str, boolean z16) {
        return SkinColor.INSTANCE.tokenColor(str, z16);
    }
}
