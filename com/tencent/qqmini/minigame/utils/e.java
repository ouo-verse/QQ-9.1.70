package com.tencent.qqmini.minigame.utils;

import com.tencent.mobileqq.triton.utils.LogDelegate;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public final /* synthetic */ class e {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f346837a;

    static {
        int[] iArr = new int[LogDelegate.Level.values().length];
        f346837a = iArr;
        iArr[LogDelegate.Level.VERBOSE.ordinal()] = 1;
        iArr[LogDelegate.Level.INFO.ordinal()] = 2;
        iArr[LogDelegate.Level.DEBUG.ordinal()] = 3;
        iArr[LogDelegate.Level.WARN.ordinal()] = 4;
        iArr[LogDelegate.Level.ERROR.ordinal()] = 5;
    }
}
