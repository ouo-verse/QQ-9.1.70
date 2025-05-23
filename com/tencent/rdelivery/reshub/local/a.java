package com.tencent.rdelivery.reshub.local;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
/* loaded from: classes25.dex */
public final /* synthetic */ class a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f364537a;

    static {
        int[] iArr = new int[ResUpdateCheckResult.values().length];
        f364537a = iArr;
        iArr[ResUpdateCheckResult.Update.ordinal()] = 1;
        iArr[ResUpdateCheckResult.Refreshed.ordinal()] = 2;
        iArr[ResUpdateCheckResult.Same.ordinal()] = 3;
        iArr[ResUpdateCheckResult.Older.ordinal()] = 4;
    }
}
