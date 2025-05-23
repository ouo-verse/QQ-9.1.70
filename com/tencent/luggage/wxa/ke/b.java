package com.tencent.luggage.wxa.ke;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Handler;
import android.os.Looper;
import com.tencent.luggage.wxa.ne.k;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b implements e {

    /* renamed from: a, reason: collision with root package name */
    public volatile Queue f131906a;

    /* renamed from: b, reason: collision with root package name */
    public volatile com.tencent.luggage.wxa.ne.a f131907b;

    /* renamed from: c, reason: collision with root package name */
    public volatile List f131908c;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f131909d = new Handler(Looper.getMainLooper());

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ne.a f131910a;

        public a(com.tencent.luggage.wxa.ne.a aVar) {
            this.f131910a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f131910a.b();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ke.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6377b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ne.a f131912a;

        public RunnableC6377b(com.tencent.luggage.wxa.ne.a aVar) {
            this.f131912a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f131912a.b();
        }
    }

    public synchronized void a() {
        this.f131906a = new ConcurrentLinkedQueue();
        this.f131908c = new ArrayList();
    }

    public final synchronized void b() {
        com.tencent.luggage.wxa.ne.a aVar = this.f131907b;
        if (aVar == null || aVar.f135721l) {
            Queue queue = this.f131906a;
            if (queue != null && queue.size() > 0) {
                com.tencent.luggage.wxa.ne.a aVar2 = (com.tencent.luggage.wxa.ne.a) queue.poll();
                if (aVar2 == null) {
                    com.tencent.luggage.wxa.pe.a.d("MicroMsg.Ble.BleConnectDispatcher", "curSerialAction is null, err", new Object[0]);
                    return;
                }
                this.f131907b = aVar2;
                if (aVar2.f135716g) {
                    this.f131909d.postDelayed(new RunnableC6377b(aVar2), aVar2.f135719j);
                } else {
                    aVar2.b();
                }
            }
        }
    }

    public synchronized void c() {
        Queue queue = this.f131906a;
        if (queue != null) {
            queue.clear();
            this.f131906a = null;
        }
        List list = this.f131908c;
        if (list != null) {
            list.clear();
            this.f131908c = null;
        }
    }

    public void a(com.tencent.luggage.wxa.ne.a aVar) {
        com.tencent.luggage.wxa.pe.a.c("MicroMsg.Ble.BleConnectDispatcher", "doAction %s", aVar);
        if (aVar.f135717h) {
            Queue queue = this.f131906a;
            if (queue == null) {
                return;
            }
            queue.add(aVar);
            b();
            return;
        }
        if (aVar.f135716g) {
            this.f131909d.postDelayed(new a(aVar), aVar.f135719j);
        } else {
            aVar.b();
        }
    }

    @Override // com.tencent.luggage.wxa.ke.e
    public void c(BluetoothGatt bluetoothGatt, int i3, int i16) {
        com.tencent.luggage.wxa.ne.a aVar = this.f131907b;
        if (aVar != null) {
            aVar.c(bluetoothGatt, i3, i16);
        }
        List<com.tencent.luggage.wxa.ne.a> list = this.f131908c;
        if (list != null) {
            for (com.tencent.luggage.wxa.ne.a aVar2 : list) {
                if (!aVar2.f135721l) {
                    aVar2.c(bluetoothGatt, i3, i16);
                }
            }
        }
    }

    public void a(com.tencent.luggage.wxa.ne.a aVar, k kVar) {
        Object[] objArr = new Object[2];
        objArr[0] = aVar;
        Object obj = kVar;
        if (kVar == null) {
            obj = "";
        }
        objArr[1] = obj;
        com.tencent.luggage.wxa.pe.a.c("MicroMsg.Ble.BleConnectDispatcher", "actionCompleteCallback action:%s result:%s", objArr);
        if (aVar != null) {
            if (aVar.f135717h) {
                b();
                return;
            }
            List list = this.f131908c;
            if (list != null) {
                list.remove(aVar);
            } else {
                com.tencent.luggage.wxa.pe.a.c("MicroMsg.Ble.BleConnectDispatcher", "actionCompleteCallback, runActions is null", new Object[0]);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.ke.e
    public void b(BluetoothGatt bluetoothGatt, int i3) {
        com.tencent.luggage.wxa.ne.a aVar = this.f131907b;
        if (aVar != null) {
            aVar.b(bluetoothGatt, i3);
        }
        List<com.tencent.luggage.wxa.ne.a> list = this.f131908c;
        if (list != null) {
            for (com.tencent.luggage.wxa.ne.a aVar2 : list) {
                if (!aVar2.f135721l) {
                    aVar2.b(bluetoothGatt, i3);
                }
            }
        }
    }

    @Override // com.tencent.luggage.wxa.ke.e
    public void a(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i3) {
        com.tencent.luggage.wxa.ne.a aVar = this.f131907b;
        if (aVar != null) {
            aVar.a(bluetoothGatt, bluetoothGattCharacteristic, i3);
        }
        List<com.tencent.luggage.wxa.ne.a> list = this.f131908c;
        if (list != null) {
            for (com.tencent.luggage.wxa.ne.a aVar2 : list) {
                if (!aVar2.f135721l) {
                    aVar2.b(bluetoothGatt, i3);
                }
            }
        }
    }

    @Override // com.tencent.luggage.wxa.ke.e
    public void b(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i3) {
        com.tencent.luggage.wxa.ne.a aVar = this.f131907b;
        if (aVar != null) {
            aVar.b(bluetoothGatt, bluetoothGattCharacteristic, i3);
        }
        List<com.tencent.luggage.wxa.ne.a> list = this.f131908c;
        if (list != null) {
            for (com.tencent.luggage.wxa.ne.a aVar2 : list) {
                if (!aVar2.f135721l) {
                    aVar2.b(bluetoothGatt, bluetoothGattCharacteristic, i3);
                }
            }
        }
    }

    @Override // com.tencent.luggage.wxa.ke.e
    public void a(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        com.tencent.luggage.wxa.ne.a aVar = this.f131907b;
        if (aVar != null) {
            aVar.a(bluetoothGatt, bluetoothGattCharacteristic);
        }
        List<com.tencent.luggage.wxa.ne.a> list = this.f131908c;
        if (list != null) {
            for (com.tencent.luggage.wxa.ne.a aVar2 : list) {
                if (!aVar2.f135721l) {
                    aVar2.a(bluetoothGatt, bluetoothGattCharacteristic);
                }
            }
        }
    }

    @Override // com.tencent.luggage.wxa.ke.e
    public void b(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i3) {
        com.tencent.luggage.wxa.ne.a aVar = this.f131907b;
        if (aVar != null) {
            aVar.b(bluetoothGatt, bluetoothGattDescriptor, i3);
        }
        List<com.tencent.luggage.wxa.ne.a> list = this.f131908c;
        if (list != null) {
            for (com.tencent.luggage.wxa.ne.a aVar2 : list) {
                if (!aVar2.f135721l) {
                    aVar2.b(bluetoothGatt, bluetoothGattDescriptor, i3);
                }
            }
        }
    }

    @Override // com.tencent.luggage.wxa.ke.e
    public void a(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i3) {
        com.tencent.luggage.wxa.ne.a aVar = this.f131907b;
        if (aVar != null) {
            aVar.a(bluetoothGatt, bluetoothGattDescriptor, i3);
        }
        List<com.tencent.luggage.wxa.ne.a> list = this.f131908c;
        if (list != null) {
            for (com.tencent.luggage.wxa.ne.a aVar2 : list) {
                if (!aVar2.f135721l) {
                    aVar2.a(bluetoothGatt, bluetoothGattDescriptor, i3);
                }
            }
        }
    }

    @Override // com.tencent.luggage.wxa.ke.e
    public void b(BluetoothGatt bluetoothGatt, int i3, int i16) {
        com.tencent.luggage.wxa.ne.a aVar = this.f131907b;
        if (aVar != null) {
            aVar.b(bluetoothGatt, i3, i16);
        }
        List<com.tencent.luggage.wxa.ne.a> list = this.f131908c;
        if (list != null) {
            for (com.tencent.luggage.wxa.ne.a aVar2 : list) {
                if (!aVar2.f135721l) {
                    aVar2.b(bluetoothGatt, i16);
                }
            }
        }
    }

    @Override // com.tencent.luggage.wxa.ke.e
    public void a(BluetoothGatt bluetoothGatt, int i3) {
        com.tencent.luggage.wxa.ne.a aVar = this.f131907b;
        if (aVar != null) {
            aVar.a(bluetoothGatt, i3);
        }
        List<com.tencent.luggage.wxa.ne.a> list = this.f131908c;
        if (list != null) {
            for (com.tencent.luggage.wxa.ne.a aVar2 : list) {
                if (!aVar2.f135721l) {
                    aVar2.a(bluetoothGatt, i3);
                }
            }
        }
    }

    @Override // com.tencent.luggage.wxa.ke.e
    public void a(BluetoothGatt bluetoothGatt, int i3, int i16) {
        com.tencent.luggage.wxa.ne.a aVar = this.f131907b;
        if (aVar != null) {
            aVar.a(bluetoothGatt, i3, i16);
        }
        List<com.tencent.luggage.wxa.ne.a> list = this.f131908c;
        if (list != null) {
            for (com.tencent.luggage.wxa.ne.a aVar2 : list) {
                if (!aVar2.f135721l) {
                    aVar2.a(bluetoothGatt, i3, i16);
                }
            }
        }
    }
}
