package com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton;

import com.tencent.kuikly.core.layout.FlexDirection;
import com.tencent.kuikly.core.layout.FlexJustifyContent;

/* loaded from: classes31.dex */
public final class QPlusTrafficSkeletonGroupRepeatItemData implements IQPlusTrafficSkeletonItemData {
    public final int dataType;
    public final FlexDirection flexDirection;

    /* renamed from: h, reason: collision with root package name */
    public final float f114251h;
    public final IQPlusTrafficSkeletonItemData itemData;
    public final FlexJustifyContent justifyContent;
    public final float left;
    public final int repeatCount;
    public final float top;

    /* renamed from: w, reason: collision with root package name */
    public final float f114252w;

    public QPlusTrafficSkeletonGroupRepeatItemData(IQPlusTrafficSkeletonItemData iQPlusTrafficSkeletonItemData, int i3, float f16, float f17, float f18, float f19, FlexDirection flexDirection, FlexJustifyContent flexJustifyContent) {
        this.itemData = iQPlusTrafficSkeletonItemData;
        this.repeatCount = i3;
        this.f114252w = f16;
        this.f114251h = f17;
        this.left = f18;
        this.top = f19;
        this.flexDirection = flexDirection;
        this.justifyContent = flexJustifyContent;
        this.dataType = 3;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton.IQPlusTrafficSkeletonItemData
    public final int getDataType$enumunboxing$() {
        return this.dataType;
    }

    public /* synthetic */ QPlusTrafficSkeletonGroupRepeatItemData(IQPlusTrafficSkeletonItemData iQPlusTrafficSkeletonItemData, int i3, float f16, FlexDirection flexDirection, FlexJustifyContent flexJustifyContent, int i16) {
        this(iQPlusTrafficSkeletonItemData, i3, (i16 & 4) != 0 ? -1.0f : 0.0f, (i16 & 8) != 0 ? -1.0f : 0.0f, (i16 & 16) != 0 ? 0.0f : f16, 0.0f, (i16 & 64) != 0 ? FlexDirection.ROW : flexDirection, (i16 & 128) != 0 ? FlexJustifyContent.FLEX_START : flexJustifyContent);
    }
}
