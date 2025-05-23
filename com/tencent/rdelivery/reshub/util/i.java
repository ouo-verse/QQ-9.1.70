package com.tencent.rdelivery.reshub.util;

import com.tencent.rdelivery.reshub.core.RemoteResFileChangedStrategy;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
/* loaded from: classes25.dex */
public final /* synthetic */ class i {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f364603a;

    static {
        int[] iArr = new int[RemoteResFileChangedStrategy.values().length];
        f364603a = iArr;
        iArr[RemoteResFileChangedStrategy.ERROR.ordinal()] = 1;
        iArr[RemoteResFileChangedStrategy.OVERRIDE.ordinal()] = 2;
        iArr[RemoteResFileChangedStrategy.IGNORE.ordinal()] = 3;
    }
}
