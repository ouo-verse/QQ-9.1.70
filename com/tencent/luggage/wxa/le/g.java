package com.tencent.luggage.wxa.le;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Parcelable;
import com.tencent.luggage.wxa.ne.k;
import com.tencent.luggage.wxa.xd.x;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g extends com.tencent.luggage.wxa.ne.a {

    /* renamed from: n, reason: collision with root package name */
    public final String f133320n;

    /* renamed from: o, reason: collision with root package name */
    public final byte[] f133321o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f133322p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f133323q;

    /* renamed from: r, reason: collision with root package name */
    public final String f133324r;

    /* renamed from: s, reason: collision with root package name */
    public a f133325s;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class a extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        public final Context f133326a;

        /* renamed from: b, reason: collision with root package name */
        public final BluetoothDevice f133327b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ g f133328c;

        public a(g gVar, Context context, BluetoothDevice device) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(device, "device");
            this.f133328c = gVar;
            this.f133326a = context;
            this.f133327b = device;
        }

        public final void a() {
            com.tencent.luggage.wxa.pe.a.c(this.f133328c.f133324r, "pairReceiver.registerSelf", new Object[0]);
            Context context = this.f133326a;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.device.action.PAIRING_REQUEST");
            intentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
            Unit unit = Unit.INSTANCE;
            context.registerReceiver(this, intentFilter);
        }

        public final void b() {
            com.tencent.luggage.wxa.pe.a.c(this.f133328c.f133324r, "pairReceiver.unregisterSelf", new Object[0]);
            this.f133326a.unregisterReceiver(this);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Parcelable parcelable;
            k kVar;
            BluetoothDevice bluetoothDevice = this.f133327b;
            if (intent != null) {
                parcelable = intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            } else {
                parcelable = null;
            }
            if (Intrinsics.areEqual(bluetoothDevice, parcelable)) {
                com.tencent.luggage.wxa.pe.a.c(this.f133328c.f133324r, "onReceive, intent: " + intent, new Object[0]);
                if (Intrinsics.areEqual("android.bluetooth.device.action.PAIRING_REQUEST", intent.getAction())) {
                    if (!intent.hasExtra("android.bluetooth.device.extra.PAIRING_VARIANT")) {
                        com.tencent.luggage.wxa.pe.a.d(this.f133328c.f133324r, "Cannot find EXTRA_PAIRING_VARIANT", new Object[0]);
                        return;
                    }
                    int intExtra = intent.getIntExtra("android.bluetooth.device.extra.PAIRING_VARIANT", -1);
                    if (intExtra != 0) {
                        if (intExtra == 2) {
                            com.tencent.luggage.wxa.pe.a.c(this.f133328c.f133324r, "PAIRING_VARIANT_PASSKEY_CONFIRMATION", new Object[0]);
                            return;
                        }
                        return;
                    }
                    com.tencent.luggage.wxa.pe.a.c(this.f133328c.f133324r, "PAIRING_VARIANT_PIN", new Object[0]);
                    if (this.f133328c.f133321o == null) {
                        this.f133328c.b(k.f135763w);
                        this.f133328c.d();
                        return;
                    }
                    com.tencent.luggage.wxa.pe.a.c(this.f133328c.f133324r, "setPin", new Object[0]);
                    if (this.f133327b.setPin(this.f133328c.f133321o) && !this.f133328c.f133323q) {
                        this.f133328c.b(k.f135745e);
                        this.f133328c.d();
                        return;
                    }
                    return;
                }
                if (Intrinsics.areEqual("android.bluetooth.device.action.BOND_STATE_CHANGED", intent.getAction())) {
                    if (intent.hasExtra("android.bluetooth.device.extra.BOND_STATE")) {
                        switch (intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1)) {
                            case 10:
                                com.tencent.luggage.wxa.pe.a.c(this.f133328c.f133324r, "BOND_NONE, reason: " + intent.getIntExtra("android.bluetooth.device.extra.REASON", -1), new Object[0]);
                                if (x.f144890a.a()) {
                                    kVar = k.a((String) null);
                                } else {
                                    kVar = k.f135747g;
                                }
                                this.f133328c.b(kVar);
                                this.f133328c.d();
                                return;
                            case 11:
                                com.tencent.luggage.wxa.pe.a.c(this.f133328c.f133324r, "BOND_BONDING", new Object[0]);
                                return;
                            case 12:
                                com.tencent.luggage.wxa.pe.a.c(this.f133328c.f133324r, "BOND_BONDED", new Object[0]);
                                this.f133328c.b(k.f135745e);
                                this.f133328c.d();
                                return;
                            default:
                                return;
                        }
                    }
                    com.tencent.luggage.wxa.pe.a.d(this.f133328c.f133324r, "Cannot find EXTRA_BOND_STATE", new Object[0]);
                }
            }
        }
    }

    public g(String deviceId, byte[] bArr, long j3, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        this.f133320n = deviceId;
        this.f133321o = bArr;
        this.f133322p = z16;
        this.f133323q = z17;
        this.f133324r = "MicroMsg.Ble.Action#" + hashCode();
        this.f135718i = j3;
    }

    @Override // com.tencent.luggage.wxa.ne.a
    public String e() {
        return "PairAction";
    }

    @Override // com.tencent.luggage.wxa.ne.a
    public void a(k kVar) {
        super.a(kVar);
        com.tencent.luggage.wxa.pe.a.c(this.f133324r, "onDone, result: " + kVar, new Object[0]);
        a aVar = this.f133325s;
        if (aVar != null) {
            aVar.b();
        }
        this.f133325s = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0060, code lost:
    
        if (true == r0.contains(r1)) goto L22;
     */
    @Override // com.tencent.luggage.wxa.ne.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c() {
        boolean z16;
        if (!com.tencent.luggage.wxa.pe.c.a()) {
            com.tencent.luggage.wxa.pe.a.d(this.f133324r, "Bluetooth is not enable.", new Object[0]);
            b(k.f135749i);
            d();
            return;
        }
        if (!BluetoothAdapter.checkBluetoothAddress(this.f133320n)) {
            com.tencent.luggage.wxa.pe.a.d(this.f133324r, "Invalid deviceId", new Object[0]);
            b(k.f135761u);
            d();
            return;
        }
        BluetoothAdapter e16 = com.tencent.luggage.wxa.pe.c.e();
        if (e16 == null) {
            com.tencent.luggage.wxa.pe.a.d(this.f133324r, "Bluetooth is not enable.", new Object[0]);
            b(k.f135749i);
            d();
            return;
        }
        BluetoothDevice device = e16.getRemoteDevice(this.f133320n);
        if (!this.f133322p) {
            Set<BluetoothDevice> bondedDevices = e16.getBondedDevices();
            if (bondedDevices != null) {
                z16 = true;
            }
            z16 = false;
            if (z16) {
                com.tencent.luggage.wxa.pe.a.c(this.f133324r, "already paired", new Object[0]);
                b(k.f135745e);
                d();
                return;
            }
        }
        com.tencent.luggage.wxa.pe.a.c(this.f133324r, "createBond", new Object[0]);
        if (!device.createBond()) {
            com.tencent.luggage.wxa.pe.a.d(this.f133324r, "startPairing is false", new Object[0]);
            b(x.f144890a.a() ? k.c("createBond fail") : k.f135754n);
            d();
            return;
        }
        Context c16 = this.f135710a.c();
        if (c16 == null) {
            com.tencent.luggage.wxa.pe.a.d(this.f133324r, "context is null", new Object[0]);
            b(x.f144890a.a() ? new k(com.tencent.luggage.wxa.af.e.f121309e) : k.f135754n);
            d();
        } else {
            Intrinsics.checkNotNullExpressionValue(device, "device");
            a aVar = new a(this, c16, device);
            this.f133325s = aVar;
            aVar.a();
        }
    }
}
