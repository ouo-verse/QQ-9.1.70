package com.tencent.qmethod.monitor.network;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final /* synthetic */ class d {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f343748a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f343749b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f343750c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int[] f343751d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int[] f343752e;

    static {
        int[] iArr = new int[Apn.values().length];
        f343748a = iArr;
        iArr[Apn.TYPE_WIFI.ordinal()] = 1;
        int[] iArr2 = new int[NetworkState.values().length];
        f343749b = iArr2;
        NetworkState networkState = NetworkState.NETWORK_2G;
        iArr2[networkState.ordinal()] = 1;
        NetworkState networkState2 = NetworkState.NETWORK_3G;
        iArr2[networkState2.ordinal()] = 2;
        int[] iArr3 = new int[NetworkState.values().length];
        f343750c = iArr3;
        iArr3[networkState.ordinal()] = 1;
        iArr3[networkState2.ordinal()] = 2;
        int[] iArr4 = new int[NetworkState.values().length];
        f343751d = iArr4;
        iArr4[networkState.ordinal()] = 1;
        iArr4[networkState2.ordinal()] = 2;
        int[] iArr5 = new int[NetworkState.values().length];
        f343752e = iArr5;
        iArr5[NetworkState.NETWORK_WIFI.ordinal()] = 1;
        iArr5[NetworkState.NETWORK_NONE.ordinal()] = 2;
    }
}
