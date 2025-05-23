package com.tencent.beacon.base.net.adapter;

import com.tencent.beacon.base.net.BodyType;

/* compiled from: P */
/* loaded from: classes2.dex */
/* synthetic */ class e {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f77714a;

    static {
        int[] iArr = new int[BodyType.values().length];
        f77714a = iArr;
        try {
            iArr[BodyType.FORM.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f77714a[BodyType.JSON.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f77714a[BodyType.DATA.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
