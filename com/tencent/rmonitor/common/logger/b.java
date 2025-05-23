package com.tencent.rmonitor.common.logger;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
/* loaded from: classes25.dex */
public final /* synthetic */ class b {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f365507a;

    static {
        int[] iArr = new int[LogState.values().length];
        f365507a = iArr;
        iArr[LogState.VERBOS.ordinal()] = 1;
        iArr[LogState.DEBUG.ordinal()] = 2;
        iArr[LogState.INFO.ordinal()] = 3;
        iArr[LogState.WARN.ordinal()] = 4;
        iArr[LogState.ERROR.ordinal()] = 5;
    }
}
