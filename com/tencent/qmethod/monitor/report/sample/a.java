package com.tencent.qmethod.monitor.report.sample;

import com.tencent.qmethod.monitor.report.sample.APILevelSampleHelper;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final /* synthetic */ class a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f343865a;

    static {
        int[] iArr = new int[APILevelSampleHelper.APIType.values().length];
        f343865a = iArr;
        iArr[APILevelSampleHelper.APIType.HIGH.ordinal()] = 1;
        iArr[APILevelSampleHelper.APIType.MIDDLE.ordinal()] = 2;
        iArr[APILevelSampleHelper.APIType.LOW.ordinal()] = 3;
    }
}
