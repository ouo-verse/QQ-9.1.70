package com.tencent.luggage.wxa.ne;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Handler;
import android.os.Looper;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a implements com.tencent.luggage.wxa.ke.e {

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.ke.d f135710a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.ke.b f135711b;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.luggage.wxa.ne.b f135712c;

    /* renamed from: k, reason: collision with root package name */
    public k f135720k;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f135713d = new Handler(Looper.getMainLooper());

    /* renamed from: e, reason: collision with root package name */
    public final Runnable f135714e = new RunnableC6511a();

    /* renamed from: f, reason: collision with root package name */
    public boolean f135715f = com.tencent.luggage.wxa.je.a.a().f130963d;

    /* renamed from: g, reason: collision with root package name */
    public boolean f135716g = com.tencent.luggage.wxa.je.a.a().f130964e;

    /* renamed from: h, reason: collision with root package name */
    public boolean f135717h = com.tencent.luggage.wxa.je.a.a().f130965f;

    /* renamed from: i, reason: collision with root package name */
    public long f135718i = com.tencent.luggage.wxa.je.a.a().f130962c;

    /* renamed from: j, reason: collision with root package name */
    public long f135719j = com.tencent.luggage.wxa.je.a.a().f130967h;

    /* renamed from: l, reason: collision with root package name */
    public volatile boolean f135721l = false;

    /* renamed from: m, reason: collision with root package name */
    public int f135722m = hashCode();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ne.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6511a implements Runnable {
        public RunnableC6511a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f135721l) {
                return;
            }
            a.this.b(k.f135759s);
            a.this.d();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f135724a;

        public b(k kVar) {
            this.f135724a = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f135712c.a(this.f135724a);
        }
    }

    @Override // com.tencent.luggage.wxa.ke.e
    public void a(BluetoothGatt bluetoothGatt, int i3) {
    }

    @Override // com.tencent.luggage.wxa.ke.e
    public void b(BluetoothGatt bluetoothGatt, int i3) {
    }

    public abstract void c();

    public void d() {
        this.f135713d.removeCallbacks(this.f135714e);
        this.f135721l = true;
        a(this.f135720k);
        this.f135711b.a(this, this.f135720k);
    }

    public abstract String e();

    public String toString() {
        return "Action#" + this.f135722m + "{action='" + e() + "', debug=" + this.f135715f + ", mainThread=" + this.f135716g + ", serial=" + this.f135717h + '}';
    }

    @Override // com.tencent.luggage.wxa.ke.e
    public void a(BluetoothGatt bluetoothGatt, int i3, int i16) {
    }

    @Override // com.tencent.luggage.wxa.ke.e
    public void b(BluetoothGatt bluetoothGatt, int i3, int i16) {
    }

    @Override // com.tencent.luggage.wxa.ke.e
    public void a(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
    }

    @Override // com.tencent.luggage.wxa.ke.e
    public void b(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i3) {
    }

    @Override // com.tencent.luggage.wxa.ke.e
    public void a(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i3) {
    }

    @Override // com.tencent.luggage.wxa.ke.e
    public void b(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i3) {
    }

    @Override // com.tencent.luggage.wxa.ke.e
    public void a(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i3) {
    }

    public void b() {
        a();
        this.f135713d.postDelayed(this.f135714e, this.f135718i);
        c();
    }

    public void a(k kVar) {
    }

    public void a(com.tencent.luggage.wxa.ke.d dVar) {
        this.f135710a = dVar;
    }

    public void b(k kVar) {
        this.f135720k = kVar;
        if (this.f135716g) {
            this.f135713d.post(new b(kVar));
        } else {
            this.f135712c.a(kVar);
        }
    }

    public void a(com.tencent.luggage.wxa.ke.b bVar) {
        this.f135711b = bVar;
    }

    public void a(com.tencent.luggage.wxa.ne.b bVar) {
        this.f135712c = bVar;
    }

    public final void a() {
        com.tencent.luggage.wxa.er.a.a(this.f135710a);
        com.tencent.luggage.wxa.er.a.a(this.f135711b);
        com.tencent.luggage.wxa.er.a.a(this.f135712c);
    }

    @Override // com.tencent.luggage.wxa.ke.e
    public void c(BluetoothGatt bluetoothGatt, int i3, int i16) {
    }
}
