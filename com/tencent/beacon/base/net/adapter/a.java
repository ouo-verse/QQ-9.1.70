package com.tencent.beacon.base.net.adapter;

import com.tencent.beacon.base.net.BodyType;

/* compiled from: P */
/* loaded from: classes2.dex */
/* synthetic */ class a {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f77707a;

    static {
        int[] iArr = new int[BodyType.values().length];
        f77707a = iArr;
        try {
            iArr[BodyType.DATA.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f77707a[BodyType.FORM.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f77707a[BodyType.JSON.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
