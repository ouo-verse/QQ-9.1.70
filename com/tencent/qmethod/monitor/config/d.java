package com.tencent.qmethod.monitor.config;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final /* synthetic */ class d {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f343590a;

    static {
        int[] iArr = new int[GlobalConfigType.values().length];
        f343590a = iArr;
        iArr[GlobalConfigType.BAN_BAN_NORMAL.ordinal()] = 1;
        iArr[GlobalConfigType.BAN_NORMAL_NORMAL.ordinal()] = 2;
        iArr[GlobalConfigType.COMPLIANCE_TEST.ordinal()] = 3;
        iArr[GlobalConfigType.NORMAL_NORMAL_NORMAL.ordinal()] = 4;
    }
}
