package com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton;

/* loaded from: classes31.dex */
public final class QPlusTrafficSkeletonItemData implements IQPlusTrafficSkeletonItemData {
    public final float bottom;
    public final int dataType;

    /* renamed from: h, reason: collision with root package name */
    public final float f114253h;
    public final float left;
    public final float right;
    public final float top;

    /* renamed from: w, reason: collision with root package name */
    public final float f114254w;

    public QPlusTrafficSkeletonItemData(float f16, float f17, float f18, float f19, float f26, float f27) {
        this.f114254w = f16;
        this.f114253h = f17;
        this.left = f18;
        this.right = f19;
        this.top = f26;
        this.bottom = f27;
        this.dataType = 1;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton.IQPlusTrafficSkeletonItemData
    public final int getDataType$enumunboxing$() {
        return this.dataType;
    }

    public /* synthetic */ QPlusTrafficSkeletonItemData(float f16, float f17, float f18, float f19, float f26, float f27, int i3) {
        this(f16, f17, (i3 & 4) != 0 ? 0.0f : f18, (i3 & 8) != 0 ? 0.0f : f19, (i3 & 16) != 0 ? 0.0f : f26, (i3 & 32) != 0 ? 0.0f : f27);
    }
}
