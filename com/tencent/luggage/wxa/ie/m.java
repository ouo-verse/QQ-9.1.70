package com.tencent.luggage.wxa.ie;

import android.bluetooth.BluetoothDevice;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final BluetoothDevice f130140a;

    /* renamed from: b, reason: collision with root package name */
    public final int f130141b;

    /* renamed from: c, reason: collision with root package name */
    public final int f130142c;

    public m(BluetoothDevice device, int i3, int i16) {
        Intrinsics.checkNotNullParameter(device, "device");
        this.f130140a = device;
        this.f130141b = i3;
        this.f130142c = i16;
    }

    public final BluetoothDevice a() {
        return this.f130140a;
    }

    public final int b() {
        return this.f130142c;
    }

    public final int c() {
        return this.f130141b;
    }
}
