package com.tencent.ecommerce.base.cache.service;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final /* synthetic */ class b {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f100640a;

    static {
        int[] iArr = new int[SCOPE.values().length];
        f100640a = iArr;
        iArr[SCOPE.PROCESS.ordinal()] = 1;
        iArr[SCOPE.ACCOUNT.ordinal()] = 2;
        iArr[SCOPE.ECOMMERCE.ordinal()] = 3;
    }
}
