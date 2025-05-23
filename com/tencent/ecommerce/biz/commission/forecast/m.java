package com.tencent.ecommerce.biz.commission.forecast;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final /* synthetic */ class m {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f101489a;

    static {
        int[] iArr = new int[LoadingStatus.values().length];
        f101489a = iArr;
        iArr[LoadingStatus.LOADED.ordinal()] = 1;
        iArr[LoadingStatus.REFRESHED.ordinal()] = 2;
        iArr[LoadingStatus.LOAD_FAILED.ordinal()] = 3;
        iArr[LoadingStatus.REFRESH_FAILED.ordinal()] = 4;
    }
}
