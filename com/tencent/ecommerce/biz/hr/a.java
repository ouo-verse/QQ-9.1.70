package com.tencent.ecommerce.biz.hr;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final /* synthetic */ class a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f102514a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f102515b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f102516c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int[] f102517d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int[] f102518e;

    static {
        int[] iArr = new int[ExecuteContextMode.values().length];
        f102514a = iArr;
        iArr[ExecuteContextMode.JVM.ordinal()] = 1;
        int[] iArr2 = new int[ExecuteContextMode.values().length];
        f102515b = iArr2;
        ExecuteContextMode executeContextMode = ExecuteContextMode.DEX;
        iArr2[executeContextMode.ordinal()] = 1;
        int[] iArr3 = new int[ExecuteContextMode.values().length];
        f102516c = iArr3;
        iArr3[ExecuteContextMode.JS.ordinal()] = 1;
        iArr3[ExecuteContextMode.SO.ordinal()] = 2;
        iArr3[executeContextMode.ordinal()] = 3;
        int[] iArr4 = new int[ExecuteContextMode.values().length];
        f102517d = iArr4;
        iArr4[executeContextMode.ordinal()] = 1;
        int[] iArr5 = new int[ExecuteContextMode.values().length];
        f102518e = iArr5;
        iArr5[executeContextMode.ordinal()] = 1;
    }
}
