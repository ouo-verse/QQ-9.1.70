package com.tencent.mobileqq.dt.app;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.common.app.AppInterface;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: collision with root package name */
    public static String f203720l;

    /* renamed from: m, reason: collision with root package name */
    public static b f203721m;

    /* renamed from: n, reason: collision with root package name */
    private static int f203722n;

    /* renamed from: a, reason: collision with root package name */
    private AtomicBoolean f203723a;

    /* renamed from: b, reason: collision with root package name */
    private int f203724b;

    /* renamed from: c, reason: collision with root package name */
    private long f203725c;

    /* renamed from: d, reason: collision with root package name */
    private SensorManager f203726d;

    /* renamed from: e, reason: collision with root package name */
    private Sensor f203727e;

    /* renamed from: f, reason: collision with root package name */
    private Sensor f203728f;

    /* renamed from: g, reason: collision with root package name */
    private Boolean f203729g;

    /* renamed from: h, reason: collision with root package name */
    private Boolean f203730h;

    /* renamed from: i, reason: collision with root package name */
    private final C7488b f203731i;

    /* renamed from: j, reason: collision with root package name */
    private final C7488b f203732j;

    /* renamed from: k, reason: collision with root package name */
    private SensorEventListener f203733k;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements SensorEventListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) sensor, i3);
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) sensorEvent);
                return;
            }
            try {
                if (sensorEvent.sensor.getType() == 4) {
                    C7488b c7488b = b.this.f203731i;
                    float[] fArr = sensorEvent.values;
                    c7488b.a(new c(fArr[0], fArr[1], fArr[2]));
                }
                if (sensorEvent.sensor.getType() == 1) {
                    float[] fArr2 = sensorEvent.values;
                    b.this.f203732j.a(new c(fArr2[0], fArr2[1], fArr2[2]));
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.dt.app.b$b, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C7488b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final int f203735a;

        /* renamed from: b, reason: collision with root package name */
        private final ConcurrentLinkedQueue<c> f203736b;

        public C7488b(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
            } else {
                this.f203735a = i3;
                this.f203736b = new ConcurrentLinkedQueue<>();
            }
        }

        public synchronized void a(c cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) cVar);
                return;
            }
            if (this.f203736b.size() >= this.f203735a) {
                this.f203736b.poll();
            }
            this.f203736b.add(cVar);
        }

        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f203736b.clear();
            }
        }

        public synchronized ArrayList<c> c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (ArrayList) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            ArrayList<c> arrayList = new ArrayList<>(Arrays.asList((c[]) this.f203736b.toArray(new c[0])));
            this.f203736b.clear();
            return arrayList;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26161);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f203720l = "FEKitMain_SensorDataManager";
            f203722n = 0;
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f203723a = new AtomicBoolean(false);
        this.f203724b = 0;
        this.f203725c = 0L;
        Boolean bool = Boolean.FALSE;
        this.f203729g = bool;
        this.f203730h = bool;
        this.f203731i = new C7488b(1000);
        this.f203732j = new C7488b(1000);
    }

    private String c(List<c> list, List<c> list2) {
        try {
            StringBuilder sb5 = new StringBuilder();
            StringBuilder sb6 = new StringBuilder();
            sb5.append("\"G\":[");
            sb6.append("\"A\":[");
            if (list.size() > 0) {
                long j3 = list.get(0).f203740d;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    sb5.append(list.get(i3).a(j3));
                    if (i3 != list.size() - 1) {
                        sb5.append(",");
                    }
                }
            }
            if (list2.size() > 0) {
                long j16 = list2.get(0).f203740d;
                for (int i16 = 0; i16 < list2.size(); i16++) {
                    sb6.append(list2.get(i16).a(j16));
                    if (i16 != list2.size() - 1) {
                        sb6.append(",");
                    }
                }
            }
            sb6.append("]");
            sb5.append("]");
            return "{" + ((Object) sb6) + "," + ((Object) sb5) + "}";
        } catch (Throwable th5) {
            QLog.e(f203720l, 1, "sensorEventToString exception:" + th5.getMessage());
            return "{}";
        }
    }

    private boolean d(String str, Object obj) {
        if ((obj instanceof MotionEvent) && ((MotionEvent) obj).getAction() == 0) {
            return true;
        }
        return false;
    }

    private ArrayList<c> h(ArrayList<c> arrayList) {
        ArrayList<c> arrayList2;
        ArrayList<c> arrayList3;
        int i3 = 1;
        QLog.d(f203720l, 1, "origin size:" + arrayList.size());
        long j3 = this.f203725c;
        long j16 = j3 - 10000;
        long j17 = j3 + 10000;
        int i16 = 1000;
        ArrayList<c> arrayList4 = new ArrayList<>(1000);
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        while (i17 < arrayList.size() - i3) {
            c cVar = arrayList.get(i17);
            if (cVar.f203742f >= i3 && !TextUtils.isEmpty(cVar.f203741e)) {
                int i26 = i17 + 1;
                if (i26 < arrayList.size()) {
                    arrayList.get(i26).f203741e = cVar.f203741e;
                } else {
                    QLog.i(f203720l, i3, "touch at end:" + i26 + ",origin size:" + arrayList.size());
                }
                arrayList2 = arrayList4;
                if (cVar.f203740d == this.f203725c) {
                    if (i26 < arrayList.size()) {
                        arrayList.get(i26).f203743g = true;
                    } else {
                        QLog.e(f203720l, 1, "bad case sensor,i:" + i17 + ",size:" + arrayList.size());
                    }
                }
            } else {
                arrayList2 = arrayList4;
            }
            long j18 = cVar.f203740d;
            if (j18 > j16 && j18 < j17 && cVar.f203742f == -1) {
                if (cVar.f203743g) {
                    i18 = i19;
                }
                arrayList3 = arrayList2;
                arrayList3.add(cVar);
                i19++;
            } else {
                arrayList3 = arrayList2;
            }
            i17++;
            arrayList4 = arrayList3;
            i3 = 1;
            i16 = 1000;
        }
        ArrayList<c> arrayList5 = arrayList4;
        m(arrayList5, i16, i18);
        QLog.i(f203720l, 1, "result size:" + arrayList5.size());
        return arrayList5;
    }

    public static b i() {
        if (f203721m == null) {
            synchronized (b.class) {
                if (f203721m == null) {
                    f203721m = new b();
                }
            }
        }
        return f203721m;
    }

    private void j(String str, int i3, long j3) {
        c cVar = new c(str, i3, j3);
        this.f203731i.a(cVar);
        this.f203732j.a(cVar);
    }

    private ArrayList<c> m(ArrayList<c> arrayList, int i3, int i16) {
        if (arrayList.size() <= i3) {
            return arrayList;
        }
        ArrayList<c> arrayList2 = new ArrayList<>(i3);
        arrayList2.add(arrayList.get(i16));
        for (int i17 = 1; i17 <= i3 / 2; i17++) {
            int i18 = i16 - i17;
            if (i18 > 0) {
                arrayList2.add(0, arrayList.get(i18));
            }
            int i19 = i16 + i17;
            if (i19 < arrayList.size()) {
                arrayList2.add(arrayList2.size(), arrayList.get(i19));
            }
        }
        return arrayList2;
    }

    public boolean e(String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, obj)).booleanValue();
        }
        if (!d(str, obj)) {
            return false;
        }
        f203722n++;
        long currentTimeMillis = System.currentTimeMillis();
        j(str, f203722n, currentTimeMillis);
        if (!this.f203723a.compareAndSet(false, true)) {
            return false;
        }
        QLog.i(f203720l, 1, "freq limit ,event:" + str);
        this.f203724b = f203722n;
        this.f203725c = currentTimeMillis;
        return true;
    }

    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        long currentTimeMillis = System.currentTimeMillis() - 20000;
        ArrayList<c> c16 = this.f203732j.c();
        ArrayList<c> c17 = this.f203731i.c();
        QLog.w(f203720l, 2, "captcha A total size:" + c16.size());
        QLog.w(f203720l, 2, "captcha G total size:" + c17.size());
        int size = c16.size() + (-1);
        int i3 = 0;
        while (size > 0) {
            i3++;
            if (c16.get(size).f203740d < currentTimeMillis || i3 > 2000) {
                break;
            }
            size--;
        }
        List<c> subList = c16.subList(size, c16.size() - 1);
        int size2 = c17.size() - 1;
        while (size2 > 0 && c17.get(size2).f203740d >= currentTimeMillis && i3 <= 2000) {
            size2--;
        }
        return c(c17.subList(size2, c17.size() - 1), subList);
    }

    public String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        this.f203723a.set(false);
        return c(h(this.f203731i.c()), h(this.f203732j.c()));
    }

    public void k(String str, AppInterface appInterface) {
        SensorManager sensorManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) appInterface);
            return;
        }
        if (this.f203726d == null) {
            this.f203726d = (SensorManager) appInterface.getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
        }
        if (this.f203727e == null && (sensorManager = this.f203726d) != null) {
            this.f203727e = SensorMonitor.getDefaultSensor(sensorManager, 4);
            this.f203728f = SensorMonitor.getDefaultSensor(this.f203726d, 1);
        }
        if (this.f203727e != null && this.f203728f != null) {
            if (this.f203733k == null) {
                this.f203733k = new a();
            }
            QLog.d(f203720l, 1, "start sensor! " + str);
            SensorMonitor.registerListener(this.f203726d, this.f203733k, this.f203728f, 2);
            SensorMonitor.registerListener(this.f203726d, this.f203733k, this.f203727e, 2);
            return;
        }
        QLog.w(f203720l, 1, " - \u4f20\u611f\u5668\u521d\u59cb\u5316\u5931\u8d25!");
    }

    public void l(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        if (this.f203727e != null && this.f203728f != null && this.f203726d != null) {
            this.f203732j.b();
            this.f203731i.b();
            this.f203726d.unregisterListener(this.f203733k);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        float f203737a;

        /* renamed from: b, reason: collision with root package name */
        float f203738b;

        /* renamed from: c, reason: collision with root package name */
        float f203739c;

        /* renamed from: d, reason: collision with root package name */
        long f203740d;

        /* renamed from: e, reason: collision with root package name */
        String f203741e;

        /* renamed from: f, reason: collision with root package name */
        int f203742f;

        /* renamed from: g, reason: collision with root package name */
        boolean f203743g;

        public c(float f16, float f17, float f18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
                return;
            }
            this.f203737a = f16;
            this.f203738b = f17;
            this.f203739c = f18;
            this.f203740d = System.currentTimeMillis();
            this.f203741e = "";
            this.f203742f = -1;
            this.f203743g = false;
        }

        public String a(long j3) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this, j3);
            }
            if (TextUtils.isEmpty(this.f203741e)) {
                str = "\"}";
            } else {
                str = "\",\"isClick\":\"1\"}";
            }
            long j16 = this.f203740d;
            if (j16 != j3) {
                j16 -= j3;
            }
            return "{" + ("\"T\":\"" + Long.toString(j16) + "\",") + "\"X\":\"" + String.format("%.5f", Float.valueOf(this.f203737a)) + "\",\"Y\":\"" + String.format("%.5f", Float.valueOf(this.f203738b)) + "\",\"Z\":\"" + String.format("%.5f", Float.valueOf(this.f203739c)) + str;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "{x=" + this.f203737a + ", y=" + this.f203738b + ", z=" + this.f203739c + ",t=" + this.f203740d + ",e=" + this.f203741e + ",id=" + this.f203742f + "}";
        }

        public c(String str, int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Long.valueOf(j3));
                return;
            }
            this.f203739c = 0.0f;
            this.f203738b = 0.0f;
            this.f203737a = 0.0f;
            this.f203740d = j3;
            this.f203741e = str;
            this.f203742f = i3;
            this.f203743g = false;
        }
    }
}
