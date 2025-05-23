package com.tencent.luggage.wxa.tn;

import android.content.Context;
import android.media.AudioManager;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import androidx.core.content.ContextCompat;
import com.tencent.bugly.common.utils.DeviceInfoUtil;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
@com.tencent.luggage.wxa.fo.b
/* loaded from: classes8.dex */
public final class i0 extends com.tencent.luggage.wxa.eo.d {

    /* renamed from: i, reason: collision with root package name */
    public static final TelephonyManager[] f141591i = {null};

    /* renamed from: h, reason: collision with root package name */
    public final List f141592h = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void a(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c extends PhoneStateListener {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements com.tencent.luggage.wxa.ca.g {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f141594a;

            public a(int i3) {
                this.f141594a = i3;
            }

            @Override // com.tencent.luggage.wxa.ca.g
            public /* bridge */ /* synthetic */ boolean a(com.tencent.luggage.wxa.ca.f fVar) {
                com.tencent.luggage.wxa.k0.d.a(fVar);
                return a((d) null);
            }

            public boolean a(d dVar) {
                dVar.a(this.f141594a);
                return false;
            }
        }

        public c() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i3, String str) {
            ArrayList arrayList;
            synchronized (i0.this.f141592h) {
                arrayList = new ArrayList(i0.this.f141592h);
            }
            w.d("MicroMsg.PhoneStatusWatcher", "alvinluo onCallStateChanged state: %d", Integer.valueOf(i3));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((b) it.next()).a(i3);
                }
            }
            com.tencent.luggage.wxa.ca.b.a(d.class, new a(i3));
            super.onCallStateChanged(i3, str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface d extends com.tencent.luggage.wxa.ca.f {
        void a(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements AudioManager.OnModeChangedListener {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements com.tencent.luggage.wxa.ca.g {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f141597a;

            public a(int i3) {
                this.f141597a = i3;
            }

            @Override // com.tencent.luggage.wxa.ca.g
            public /* bridge */ /* synthetic */ boolean a(com.tencent.luggage.wxa.ca.f fVar) {
                com.tencent.luggage.wxa.k0.d.a(fVar);
                return a((d) null);
            }

            public boolean a(d dVar) {
                dVar.a(this.f141597a);
                return false;
            }
        }

        public e() {
        }

        @Override // android.media.AudioManager.OnModeChangedListener
        public void onModeChanged(int i3) {
            int i16 = 1;
            w.d("MicroMsg.PhoneStatusWatcher", "onModeChanged, mode: %d", Integer.valueOf(i3));
            if (i3 != 1) {
                i16 = 2;
                if (i3 != 2) {
                    i16 = 0;
                }
            }
            if (i0.this.f141592h.size() > 0) {
                for (b bVar : (b[]) i0.this.f141592h.toArray(new b[i0.this.f141592h.size()])) {
                    bVar.a(i16);
                }
            }
            com.tencent.luggage.wxa.ca.b.a(d.class, new a(i16));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x004e, code lost:
    
        if (1 != com.tencent.mobileqq.perf.block.SystemMethodProxy.getCallState(r1)) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b0() {
        boolean z16;
        boolean z17;
        try {
        } catch (Throwable th5) {
            th = th5;
            z16 = false;
        }
        try {
            if (!com.tencent.luggage.wxa.aa.a.a(31) && z.c().getApplicationInfo().targetSdkVersion > 30) {
                AudioManager audioManager = (AudioManager) z.c().getSystemService("audio");
                if (audioManager.getMode() != 2) {
                    if (audioManager.getMode() == 1) {
                    }
                    z17 = false;
                    w.d("MicroMsg.PhoneStatusWatcher", "isCallingSync, isCalling:%b", Boolean.valueOf(z17));
                    return z17;
                }
                z17 = true;
                w.d("MicroMsg.PhoneStatusWatcher", "isCallingSync, isCalling:%b", Boolean.valueOf(z17));
                return z17;
            }
            w.d("MicroMsg.PhoneStatusWatcher", "isCallingSync, isCalling:%b", Boolean.valueOf(z17));
            return z17;
        } catch (Throwable th6) {
            z16 = z17;
            th = th6;
            w.b("MicroMsg.PhoneStatusWatcher", "iscalling sync checking failed %s,", th.fillInStackTrace());
            return z16;
        }
        TelephonyManager telephonyManager = (TelephonyManager) z.c().getSystemService("phone");
        if (2 != SystemMethodProxy.getCallState(telephonyManager)) {
        }
        z17 = true;
    }

    public void b(b bVar) {
        synchronized (this.f141592h) {
            this.f141592h.remove(bVar);
        }
    }

    @Override // com.tencent.luggage.wxa.eo.d
    public void n(Context context) {
        try {
            o(context);
        } catch (Throwable th5) {
            w.a("MicroMsg.PhoneStatusWatcher", th5, "Fail to do initialization.", new Object[0]);
        }
    }

    public final void o(Context context) {
        boolean z16;
        TelephonyManager[] telephonyManagerArr = f141591i;
        if (telephonyManagerArr[0] != null) {
            return;
        }
        synchronized (telephonyManagerArr) {
            if (telephonyManagerArr[0] != null) {
                return;
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            try {
                if (!com.tencent.luggage.wxa.aa.a.a(31)) {
                    ((AudioManager) z.c().getSystemService("audio")).addOnModeChangedListener(com.tencent.luggage.wxa.zp.h.f146825d.a("phone_status_watcher_task"), new e());
                } else {
                    LocationMonitor.listen(telephonyManager, new c(), 32);
                }
                telephonyManagerArr[0] = telephonyManager;
            } catch (Throwable th5) {
                if (ContextCompat.checkSelfPermission(context, DeviceInfoUtil.PERMISSION_READ_PHONE) != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                w.a("MicroMsg.PhoneStatusWatcher", th5, "Failure, read_phone_state permission: %s", Boolean.valueOf(z16));
            }
        }
    }

    public void a(b bVar) {
        o(z.c());
        synchronized (this.f141592h) {
            this.f141592h.add(bVar);
        }
    }
}
