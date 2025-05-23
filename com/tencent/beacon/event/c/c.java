package com.tencent.beacon.event.c;

import com.tencent.beacon.event.open.EventType;

/* compiled from: P */
/* loaded from: classes2.dex */
/* synthetic */ class c {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f77906a;

    static {
        int[] iArr = new int[EventType.values().length];
        f77906a = iArr;
        try {
            iArr[EventType.NORMAL.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f77906a[EventType.DT_NORMAL.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f77906a[EventType.REALTIME.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f77906a[EventType.DT_REALTIME.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f77906a[EventType.IMMEDIATE_WNS.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f77906a[EventType.IMMEDIATE_MSF.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
