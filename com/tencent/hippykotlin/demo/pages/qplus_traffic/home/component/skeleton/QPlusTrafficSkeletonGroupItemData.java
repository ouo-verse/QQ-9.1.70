package com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton;

import com.tencent.kuikly.core.layout.FlexDirection;
import com.tencent.kuikly.core.layout.FlexJustifyContent;
import java.util.ArrayList;

/* loaded from: classes31.dex */
public final class QPlusTrafficSkeletonGroupItemData implements IQPlusTrafficSkeletonItemData {
    public final int dataType;
    public final FlexDirection flexDirection;

    /* renamed from: h, reason: collision with root package name */
    public final float f114249h;
    public final ArrayList<IQPlusTrafficSkeletonItemData> itemsData;
    public final FlexJustifyContent justifyContent;
    public final float left;
    public final float top;

    /* renamed from: w, reason: collision with root package name */
    public final float f114250w;

    public QPlusTrafficSkeletonGroupItemData(ArrayList<IQPlusTrafficSkeletonItemData> arrayList, float f16, float f17, float f18, float f19, FlexDirection flexDirection, FlexJustifyContent flexJustifyContent) {
        this.itemsData = arrayList;
        this.f114250w = f16;
        this.f114249h = f17;
        this.left = f18;
        this.top = f19;
        this.flexDirection = flexDirection;
        this.justifyContent = flexJustifyContent;
        this.dataType = 2;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton.IQPlusTrafficSkeletonItemData
    public final int getDataType$enumunboxing$() {
        return this.dataType;
    }

    public /* synthetic */ QPlusTrafficSkeletonGroupItemData(ArrayList arrayList, FlexDirection flexDirection, FlexJustifyContent flexJustifyContent, int i3) {
        this(arrayList, (i3 & 2) != 0 ? -1.0f : 0.0f, (i3 & 4) != 0 ? -1.0f : 0.0f, 0.0f, 0.0f, (i3 & 32) != 0 ? FlexDirection.ROW : flexDirection, (i3 & 64) != 0 ? FlexJustifyContent.FLEX_START : flexJustifyContent);
    }
}
