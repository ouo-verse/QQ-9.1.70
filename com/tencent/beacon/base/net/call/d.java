package com.tencent.beacon.base.net.call;

import com.tencent.beacon.base.net.BodyType;

/* compiled from: P */
/* loaded from: classes2.dex */
/* synthetic */ class d {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f77752a;

    static {
        int[] iArr = new int[BodyType.values().length];
        f77752a = iArr;
        try {
            iArr[BodyType.JSON.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f77752a[BodyType.FORM.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f77752a[BodyType.DATA.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
