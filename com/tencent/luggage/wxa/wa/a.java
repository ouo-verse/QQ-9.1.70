package com.tencent.luggage.wxa.wa;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.p9.i;
import com.tencent.luggage.wxa.tn.b0;
import com.tencent.luggage.wxa.tn.h0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.tn.z0;
import com.tencent.mars.comm.WakerLock;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static SparseArray f144133a = new SparseArray();

    /* renamed from: b, reason: collision with root package name */
    public static b0 f144134b = new b0(Looper.getMainLooper());

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f144135c = new byte[0];

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public WakerLock f144136a;

        public b(WakerLock wakerLock) {
            this.f144136a = wakerLock;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (a.f144135c) {
                c cVar = (c) a.f144133a.get(this.f144136a.hashCode());
                if (cVar != null) {
                    w.h("MicroMsg.WakeLockManager", "wakerlock held too long: [%d,%d] @[%s] force to unlock it. state: %s", Integer.valueOf(this.f144136a.hashCode()), Integer.valueOf(this.f144136a.innerWakeLockHashCode()), this.f144136a.getCreatePosStackLine(), cVar.a());
                } else {
                    w.h("MicroMsg.WakeLockManager", "wakerlock held too long: [%d,%d] @[%s] force to unlock it. state: %s", Integer.valueOf(this.f144136a.hashCode()), Integer.valueOf(this.f144136a.innerWakeLockHashCode()), this.f144136a.getCreatePosStackLine(), "#lost-trace-state#");
                }
                this.f144136a.unLock();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class c {

        /* renamed from: b, reason: collision with root package name */
        public b f144138b;

        /* renamed from: a, reason: collision with root package name */
        public volatile boolean f144137a = false;

        /* renamed from: c, reason: collision with root package name */
        public Map f144139c = new HashMap();

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.wa.a$c$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static class C6872a {

            /* renamed from: a, reason: collision with root package name */
            public String f144140a;

            /* renamed from: b, reason: collision with root package name */
            public long f144141b;

            public C6872a(String str, long j3) {
                this.f144140a = str;
                this.f144141b = j3;
            }
        }

        public c(WakerLock wakerLock) {
            this.f144138b = null;
            this.f144138b = new b(wakerLock);
        }

        public void b(b0 b0Var) {
            if (this.f144137a) {
                this.f144137a = false;
                b0Var.b(this.f144138b);
            }
        }

        public void a(String str) {
            if (this.f144139c.containsKey(str)) {
                return;
            }
            this.f144139c.put(str, new C6872a(str, SystemClock.elapsedRealtime()));
        }

        public String a() {
            Collection<C6872a> values = this.f144139c.values();
            StringBuilder sb5 = new StringBuilder();
            boolean z16 = true;
            for (C6872a c6872a : values) {
                if (z16) {
                    z16 = false;
                } else {
                    sb5.append(',');
                }
                if (c6872a.f144141b != 0) {
                    sb5.append('{');
                    sb5.append(c6872a.f144140a);
                    sb5.append(',');
                    sb5.append(SystemClock.elapsedRealtime() - c6872a.f144141b);
                    sb5.append('}');
                }
            }
            if (sb5.length() == 0) {
                sb5.append("<empty>");
            }
            return sb5.toString();
        }

        public void a(b0 b0Var) {
            if (this.f144137a) {
                return;
            }
            this.f144137a = true;
            b0Var.a(this.f144138b, 60000L);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public static int f144142a;

        /* renamed from: b, reason: collision with root package name */
        public static long f144143b;

        /* renamed from: c, reason: collision with root package name */
        public static long f144144c;

        /* renamed from: d, reason: collision with root package name */
        public static final HashMap f144145d = new HashMap();

        /* renamed from: e, reason: collision with root package name */
        public static final byte[] f144146e = new byte[0];

        /* renamed from: f, reason: collision with root package name */
        public static BroadcastReceiver f144147f = null;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.wa.a$d$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static class C6873a implements Externalizable {

            /* renamed from: a, reason: collision with root package name */
            public String f144148a;

            /* renamed from: b, reason: collision with root package name */
            public String f144149b;

            /* renamed from: c, reason: collision with root package name */
            public String f144150c;

            /* renamed from: d, reason: collision with root package name */
            public boolean f144151d;

            /* renamed from: e, reason: collision with root package name */
            public int f144152e;

            /* renamed from: f, reason: collision with root package name */
            public int f144153f;

            /* renamed from: g, reason: collision with root package name */
            public long f144154g;

            /* renamed from: h, reason: collision with root package name */
            public long f144155h;

            /* renamed from: i, reason: collision with root package name */
            public AtomicInteger f144156i;

            public C6873a() {
                this.f144148a = "";
                this.f144149b = "";
                this.f144150c = "";
                this.f144151d = false;
                this.f144152e = 0;
                this.f144153f = 0;
                this.f144154g = 0L;
                this.f144155h = 0L;
                this.f144156i = new AtomicInteger(0);
            }

            @Override // java.io.Externalizable
            public void readExternal(ObjectInput objectInput) {
                synchronized (d.f144146e) {
                    this.f144148a = objectInput.readUTF();
                    this.f144149b = objectInput.readUTF();
                    this.f144152e = objectInput.readInt();
                    this.f144153f = objectInput.readInt();
                    this.f144154g = objectInput.readLong();
                    this.f144150c = "";
                    this.f144151d = false;
                    this.f144155h = 0L;
                    this.f144156i = new AtomicInteger(0);
                }
            }

            @Override // java.io.Externalizable
            public void writeExternal(ObjectOutput objectOutput) {
                synchronized (d.f144146e) {
                    objectOutput.writeUTF(this.f144148a);
                    objectOutput.writeUTF(this.f144149b);
                    objectOutput.writeInt(this.f144152e);
                    objectOutput.writeInt(this.f144153f);
                    objectOutput.writeLong(this.f144154g);
                }
            }
        }

        public static void b(String str) {
            a(str, false);
        }

        public static boolean c() {
            return com.tencent.luggage.wxa.nn.a.f135889a;
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x0085 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static void d() {
            Throwable th5;
            v vVar;
            synchronized (f144146e) {
                ObjectOutputStream objectOutputStream = null;
                try {
                    try {
                        vVar = new v(z.c().getCacheDir(), "wakelock");
                    } catch (IOException e16) {
                        e = e16;
                    } catch (Throwable th6) {
                        th = th6;
                        if (objectOutputStream != null) {
                        }
                        throw th;
                    }
                } catch (Exception unused) {
                }
                if (x.m(vVar.g())) {
                    ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(x.b(new v(vVar, "wakelock_stats.bin")));
                    try {
                        objectOutputStream2.writeLong(f144143b);
                        objectOutputStream2.writeObject(f144145d);
                        objectOutputStream2.close();
                    } catch (IOException e17) {
                        e = e17;
                        objectOutputStream = objectOutputStream2;
                        try {
                            w.a("MicroMsg.WakeLockStatsManager", e, "failed to save stats to storage.", new Object[0]);
                            if (objectOutputStream != null) {
                                objectOutputStream.close();
                            }
                        } catch (Throwable th7) {
                            objectOutputStream2 = objectOutputStream;
                            th5 = th7;
                            ObjectOutputStream objectOutputStream3 = objectOutputStream2;
                            th = th5;
                            objectOutputStream = objectOutputStream3;
                            if (objectOutputStream != null) {
                                try {
                                    objectOutputStream.close();
                                } catch (Exception unused2) {
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th8) {
                        th5 = th8;
                        ObjectOutputStream objectOutputStream32 = objectOutputStream2;
                        th = th5;
                        objectOutputStream = objectOutputStream32;
                        if (objectOutputStream != null) {
                        }
                        throw th;
                    }
                } else {
                    throw new IOException("failed to call VFSFileOp.mkdirs(" + vVar.g() + ")");
                }
            }
        }

        public static void a(String str) {
            a(str, true);
        }

        public static void b(String str, String str2, long j3) {
            long j16;
            String str3 = str + "_" + str2;
            synchronized (f144146e) {
                C6873a c6873a = (C6873a) f144145d.get(str3);
                if (c6873a != null && c6873a.f144156i.get() > 0) {
                    c6873a.f144152e++;
                    if (c6873a.f144156i.decrementAndGet() == 0) {
                        j16 = j3 - c6873a.f144155h;
                        c6873a.f144154g += j16;
                        c6873a.f144153f++;
                    }
                }
                j16 = 0;
            }
            b();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (j16 >= 14000 || elapsedRealtime - f144144c >= 3600000) {
                w.a("MicroMsg.WakeLockStatsManager", "saveStatsToStorage triggered.");
                d();
                f144144c = elapsedRealtime;
            }
        }

        public static void a(String str, boolean z16) {
            int myPid = Process.myPid();
            String i3 = z.i();
            if (myPid == f144142a) {
                if (z16) {
                    a(i3, str, SystemClock.elapsedRealtime());
                    return;
                } else {
                    b(i3, str, SystemClock.elapsedRealtime());
                    return;
                }
            }
            if (z16) {
                Intent intent = new Intent("com.tencent.mm.ACTION.note_tracemsg_lock");
                intent.putExtra("pid", myPid);
                intent.putExtra("processName", i3);
                intent.putExtra("traceMsg", str);
                intent.putExtra("tick", SystemClock.elapsedRealtime());
                intent.setPackage(z.a());
                z.c().sendBroadcast(intent, z0.a());
                return;
            }
            Intent intent2 = new Intent("com.tencent.mm.ACTION.note_tracemsg_unlock");
            intent2.putExtra("pid", myPid);
            intent2.putExtra("processName", i3);
            intent2.putExtra("traceMsg", str);
            intent2.putExtra("tick", SystemClock.elapsedRealtime());
            intent2.setPackage(z.a());
            z.c().sendBroadcast(intent2, z0.a());
        }

        public static void b() {
            synchronized (f144146e) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime - f144143b >= 21600000) {
                    HashMap hashMap = f144145d;
                    if (!hashMap.isEmpty()) {
                        StringBuilder sb5 = new StringBuilder();
                        Iterator it = hashMap.entrySet().iterator();
                        while (it.hasNext()) {
                            C6873a c6873a = (C6873a) ((Map.Entry) it.next()).getValue();
                            if (c6873a.f144153f > 0) {
                                sb5.setLength(0);
                                sb5.append(c6873a.f144148a);
                                sb5.append(',');
                                sb5.append(c6873a.f144149b.replace(",", "##"));
                                sb5.append(',');
                                sb5.append(c6873a.f144153f);
                                sb5.append(',');
                                sb5.append(c6873a.f144152e);
                                sb5.append(',');
                                sb5.append(c6873a.f144154g);
                                sb5.append(',');
                                sb5.append(c6873a.f144151d ? 1 : 0);
                                sb5.append(',');
                                sb5.append(c6873a.f144150c);
                                String sb6 = sb5.toString();
                                i iVar = new i();
                                iVar.f137479d.f137480a = sb6;
                                iVar.c();
                                w.a("MicroMsg.WakeLockStatsManager", "kvstat-str: %s", sb5.toString());
                            }
                        }
                        f144145d.clear();
                    }
                    f144143b = elapsedRealtime;
                }
            }
        }

        public static void a(String str, String str2, long j3) {
            String str3 = str + "_" + str2;
            synchronized (f144146e) {
                HashMap hashMap = f144145d;
                C6873a c6873a = (C6873a) hashMap.get(str3);
                if (c6873a == null) {
                    c6873a = new C6873a();
                    c6873a.f144148a = str;
                    c6873a.f144149b = str2;
                    c6873a.f144154g = 0L;
                    c6873a.f144152e = 0;
                    c6873a.f144153f = 0;
                    hashMap.put(str3, c6873a);
                }
                if (c6873a.f144156i.getAndIncrement() == 0) {
                    c6873a.f144155h = j3;
                    c6873a.f144150c = h0.e(z.c());
                    c6873a.f144151d = c();
                }
            }
        }
    }

    public static void a(WakerLock wakerLock, String str) {
        synchronized (f144135c) {
            c cVar = (c) f144133a.get(wakerLock.hashCode());
            if (cVar == null) {
                cVar = new c(wakerLock);
                f144133a.put(wakerLock.hashCode(), cVar);
            }
            cVar.a(str);
            d.a(str);
            cVar.a(f144134b);
        }
    }

    public static void a(WakerLock wakerLock) {
        synchronized (f144135c) {
            c cVar = (c) f144133a.get(wakerLock.hashCode());
            if (cVar != null) {
                cVar.b(f144134b);
                Iterator it = cVar.f144139c.values().iterator();
                while (it.hasNext()) {
                    d.b(((c.C6872a) it.next()).f144140a);
                }
                cVar.f144139c.clear();
            }
        }
    }
}
