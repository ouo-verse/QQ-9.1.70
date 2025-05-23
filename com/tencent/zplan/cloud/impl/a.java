package com.tencent.zplan.cloud.impl;

import com.tencent.zplan.cloud.record.api.Priority;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final /* synthetic */ class a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f385260a;

    static {
        int[] iArr = new int[Priority.values().length];
        f385260a = iArr;
        iArr[Priority.IMMEDIATE.ordinal()] = 1;
        iArr[Priority.OFFLINE_HIGH.ordinal()] = 2;
    }
}
