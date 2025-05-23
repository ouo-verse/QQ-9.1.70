package com.tencent.rmonitor.base.reporter;

import com.tencent.bugly.common.reporter.data.ReportStrategy;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
/* loaded from: classes25.dex */
public final /* synthetic */ class b {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f365427a;

    static {
        int[] iArr = new int[ReportStrategy.RetryStrategy.values().length];
        f365427a = iArr;
        iArr[ReportStrategy.RetryStrategy.RETRY_IMMEDIATELY.ordinal()] = 1;
        iArr[ReportStrategy.RetryStrategy.RETRY_BACKOFF.ordinal()] = 2;
    }
}
