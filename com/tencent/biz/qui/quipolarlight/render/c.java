package com.tencent.biz.qui.quipolarlight.render;

import com.tencent.biz.qui.quipolarlight.render.PolarImageRender;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public final /* synthetic */ class c {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f95243a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f95244b;

    static {
        int[] iArr = new int[PolarImageRender.RenderSize.values().length];
        f95243a = iArr;
        PolarImageRender.RenderSize renderSize = PolarImageRender.RenderSize.SMALL;
        iArr[renderSize.ordinal()] = 1;
        PolarImageRender.RenderSize renderSize2 = PolarImageRender.RenderSize.MEDIUM;
        iArr[renderSize2.ordinal()] = 2;
        PolarImageRender.RenderSize renderSize3 = PolarImageRender.RenderSize.LARGE;
        iArr[renderSize3.ordinal()] = 3;
        int[] iArr2 = new int[PolarImageRender.RenderSize.values().length];
        f95244b = iArr2;
        iArr2[renderSize.ordinal()] = 1;
        iArr2[renderSize2.ordinal()] = 2;
        iArr2[renderSize3.ordinal()] = 3;
    }
}
