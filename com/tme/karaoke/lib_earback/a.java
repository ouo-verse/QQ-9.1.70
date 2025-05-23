package com.tme.karaoke.lib_earback;

import com.tme.karaoke.lib_earback.base.HeadPhoneStatus;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
/* loaded from: classes27.dex */
public final /* synthetic */ class a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f386961a;

    static {
        int[] iArr = new int[HeadPhoneStatus.values().length];
        f386961a = iArr;
        iArr[HeadPhoneStatus.Speaker.ordinal()] = 1;
        iArr[HeadPhoneStatus.Wired.ordinal()] = 2;
        iArr[HeadPhoneStatus.BlueTooth.ordinal()] = 3;
        iArr[HeadPhoneStatus.None.ordinal()] = 4;
    }
}
