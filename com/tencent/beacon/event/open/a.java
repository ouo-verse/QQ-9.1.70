package com.tencent.beacon.event.open;

/* compiled from: P */
/* loaded from: classes2.dex */
/* synthetic */ class a {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f78050a;

    static {
        int[] iArr = new int[EventType.values().length];
        f78050a = iArr;
        try {
            iArr[EventType.NORMAL.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f78050a[EventType.DT_NORMAL.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f78050a[EventType.IMMEDIATE_MSF.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f78050a[EventType.IMMEDIATE_WNS.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f78050a[EventType.REALTIME.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f78050a[EventType.DT_REALTIME.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
