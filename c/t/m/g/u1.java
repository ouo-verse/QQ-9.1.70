package c.t.m.g;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.map.geolocation.TencentGeofence;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public class u1 extends BroadcastReceiver implements TencentLocationListener, PendingIntent.OnFinished {

    /* renamed from: a, reason: collision with root package name */
    public final Context f30031a;

    /* renamed from: b, reason: collision with root package name */
    public final g2 f30032b;

    /* renamed from: c, reason: collision with root package name */
    public final PowerManager.WakeLock f30033c;

    /* renamed from: d, reason: collision with root package name */
    public final PowerManager.WakeLock f30034d;

    /* renamed from: e, reason: collision with root package name */
    public final b f30035e;

    /* renamed from: f, reason: collision with root package name */
    public final d f30036f;

    /* renamed from: g, reason: collision with root package name */
    public final c f30037g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f30038h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f30039i;

    /* renamed from: j, reason: collision with root package name */
    public PendingIntent f30040j;

    /* renamed from: k, reason: collision with root package name */
    public final TencentLocationRequest f30041k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f30042l;

    /* renamed from: m, reason: collision with root package name */
    public double f30043m;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public final class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 1) {
                u1.this.a(true);
            } else if (i3 == 2) {
                u1.b("handleMessage: mock alarm --> wakeup");
                u1.this.f30031a.sendBroadcast(u1.this.b());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final List<r1> f30045a = new LinkedList();

        /* renamed from: b, reason: collision with root package name */
        public boolean f30046b = false;

        /* renamed from: c, reason: collision with root package name */
        public long f30047c = 60000;

        /* renamed from: d, reason: collision with root package name */
        public Location f30048d = null;

        /* renamed from: e, reason: collision with root package name */
        public boolean f30049e = false;

        /* renamed from: f, reason: collision with root package name */
        public final float[] f30050f = {-1.0f, -1.0f};

        public void a() {
            this.f30045a.clear();
            this.f30046b = false;
            this.f30047c = 60000L;
            this.f30048d = null;
            this.f30049e = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public final class d {

        /* renamed from: a, reason: collision with root package name */
        public LinkedList<TencentLocation> f30051a;

        /* renamed from: b, reason: collision with root package name */
        public List<Map<String, String>> f30052b;

        public d(u1 u1Var) {
            this.f30051a = new LinkedList<>();
            this.f30052b = new ArrayList();
        }

        public void a() {
        }

        public void a(int i3, TencentLocation tencentLocation) {
            if (i3 == 0) {
                this.f30051a.add(tencentLocation);
            } else {
                this.f30051a.add(h3.f29737p.a(System.currentTimeMillis()));
            }
        }
    }

    public u1(Context context, Looper looper) {
        this.f30037g = new c();
        this.f30038h = false;
        this.f30039i = false;
        this.f30041k = TencentLocationRequest.create().setRequestLevel(0).setInterval(0L).setAllowCache(false);
        this.f30043m = 1.0d;
        this.f30031a = context;
        this.f30032b = new g2(n1.b(context));
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        this.f30033c = powerManager.newWakeLock(1, "GeofenceManager");
        PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, "tencent_location");
        this.f30034d = newWakeLock;
        newWakeLock.setReferenceCounted(false);
        this.f30035e = new b(looper);
        this.f30036f = new d();
        g();
    }

    public void c(String str) {
        a();
        o3.b("GeofenceManager", "removeFence: tag=" + str);
        synchronized (this.f30037g) {
            Iterator<r1> it = this.f30037g.f30045a.iterator();
            while (it.hasNext()) {
                TencentGeofence tencentGeofence = it.next().f29958a;
                if (tencentGeofence == null || TextUtils.equals(tencentGeofence.getTag(), str)) {
                    it.remove();
                }
            }
            e("removeFence: " + str + " removed --> schedule update fence");
        }
    }

    public void d() {
        if (this.f30038h) {
            return;
        }
        k();
        Arrays.fill(this.f30037g.f30050f, -1.0f);
        this.f30031a.unregisterReceiver(this);
        synchronized (this.f30037g) {
            j();
        }
        this.f30039i = false;
        this.f30038h = true;
    }

    public final void e(String str) {
        if (this.f30037g.f30049e) {
            return;
        }
        b(str);
        this.f30037g.f30049e = true;
        this.f30035e.sendEmptyMessage(1);
    }

    public final double f() {
        float f16;
        if (t1.a(this.f30031a)) {
            return 1.0d;
        }
        float f17 = 25.0f;
        if (x3.b(n1.b(this.f30031a))) {
            f17 = (float) (25.0f * 0.6d);
            f16 = 1.0f;
        } else {
            f16 = 3.0f;
        }
        if (this.f30037g.f30050f[0] >= f16) {
            double min = (Math.min(Math.max(f16, r2), 10.0f + f17) * 0.8d) + ((f17 + f16) * 0.1d);
            double d16 = f16;
            if (min < d16) {
                return d16;
            }
            return min;
        }
        if (p3.d(this.f30031a)) {
            return f17 * 0.3d;
        }
        return f17;
    }

    public final void g() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_ON);
        intentFilter.addAction("com.tencent.map.geolocation.wakeup");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.f30031a.registerReceiver(this, intentFilter, null, this.f30035e);
    }

    public void h() {
        a();
        synchronized (this.f30037g) {
            this.f30032b.a(this);
            j();
        }
    }

    public final void i() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<r1> it = this.f30037g.f30045a.iterator();
        while (it.hasNext()) {
            if (it.next().f29960c < elapsedRealtime) {
                it.remove();
            }
        }
    }

    public final void j() {
        this.f30037g.a();
        this.f30036f.a();
    }

    public final void k() {
        a(-1L);
        this.f30035e.removeMessages(2);
        this.f30032b.a(this);
    }

    @Override // com.tencent.map.geolocation.TencentLocationListener
    public void onLocationChanged(TencentLocation tencentLocation, int i3, String str) {
        Location a16 = s1.a(tencentLocation, this.f30039i);
        b(s1.a(tencentLocation, i3));
        if (this.f30039i && i3 != 0 && !"gps".equals(tencentLocation.getProvider())) {
            return;
        }
        if (!this.f30042l) {
            this.f30032b.a(this);
        }
        if (i3 == 0) {
            this.f30036f.a(i3, tencentLocation);
            synchronized (this.f30037g) {
                c cVar = this.f30037g;
                if (cVar.f30046b) {
                    cVar.f30048d = a16;
                }
                if (cVar.f30049e) {
                    this.f30035e.removeMessages(1);
                } else {
                    cVar.f30049e = true;
                }
            }
            b("onLocationChanged: fresh location got --> update fences");
            a(false);
        } else {
            this.f30037g.f30047c = 60000L;
            this.f30036f.a(i3, tencentLocation);
        }
        if (this.f30037g.f30046b) {
            b("onLocationChanged: set a new repeat alarm, interval=" + this.f30037g.f30047c);
            a(this.f30037g.f30047c);
        }
        if (this.f30034d.isHeld()) {
            this.f30034d.release();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean z16;
        String action = intent.getAction();
        synchronized (this.f30037g) {
            if (e() == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (IECScreenReceiver.ACTION_SCREEN_ON.equals(action)) {
                if (z16) {
                    d("onReceive: screen_on and no_fresh_location --> schedule update fence");
                }
            } else if ("com.tencent.map.geolocation.wakeup".equals(action)) {
                v1.a(this.f30031a);
                this.f30035e.removeMessages(2);
                e("onReceive: alarm --> schedule update fence");
                v1.a();
            } else if ("android.intent.action.ACTION_POWER_DISCONNECTED".equals(action)) {
                if (z16) {
                    d("onReceive: power_disconnected --> schedule update fence");
                }
            } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                if (!p3.c(this.f30031a)) {
                    b("onReceive: disconnected and stop location updates temporaryly");
                    c cVar = this.f30037g;
                    cVar.f30046b = false;
                    cVar.f30047c = 60000L;
                    k();
                }
                d("onReceive: connected and no_fresh_location --> schedule update fence");
            }
        }
    }

    @Override // android.app.PendingIntent.OnFinished
    public void onSendFinished(PendingIntent pendingIntent, Intent intent, int i3, String str, Bundle bundle) {
        this.f30033c.release();
    }

    public final void b(TencentGeofence tencentGeofence, PendingIntent pendingIntent) {
        o3.b("GeofenceManager", "removeFence: fence=" + tencentGeofence + ", intent=" + pendingIntent);
        synchronized (this.f30037g) {
            Iterator<r1> it = this.f30037g.f30045a.iterator();
            while (it.hasNext()) {
                r1 next = it.next();
                if (next.f29961d.equals(pendingIntent)) {
                    if (tencentGeofence == null) {
                        it.remove();
                    } else if (tencentGeofence.equals(next.f29958a)) {
                        it.remove();
                    }
                }
            }
            e("_removeFence: --> schedule update fence");
        }
    }

    public final void a() {
        if (this.f30038h) {
            throw new IllegalStateException("this object has been destroyed!");
        }
    }

    public final Location e() {
        c cVar = this.f30037g;
        Location location = cVar.f30048d;
        List<r1> list = cVar.f30045a;
        if (location == null && !list.isEmpty()) {
            location = s1.a(this.f30032b.l(), this.f30039i);
        }
        if (location != null && System.currentTimeMillis() - location.getTime() < 60000) {
            return location;
        }
        return null;
    }

    public void a(TencentGeofence tencentGeofence, PendingIntent pendingIntent) {
        a();
        if (tencentGeofence != null && pendingIntent != null) {
            o3.b("GeofenceManager", "addFence: , geofence=" + tencentGeofence + ", intent=" + pendingIntent);
            r1 r1Var = new r1(tencentGeofence, tencentGeofence.getExpireAt(), "packageName", pendingIntent);
            c cVar = this.f30037g;
            List<r1> list = cVar.f30045a;
            synchronized (cVar) {
                int size = list.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    r1 r1Var2 = list.get(size);
                    if (tencentGeofence.equals(r1Var2.f29958a) && pendingIntent.equals(r1Var2.f29961d)) {
                        list.remove(size);
                        break;
                    }
                    size--;
                }
                list.add(r1Var);
                e("addFence: --> schedule update fence");
            }
            return;
        }
        throw null;
    }

    public final void d(String str) {
        if (!p3.c(this.f30031a)) {
            b("no data conn. skip [" + str + "]");
            return;
        }
        if (this.f30037g.f30049e) {
            return;
        }
        b(str);
        this.f30037g.f30049e = true;
        this.f30035e.sendEmptyMessage(1);
    }

    public final PendingIntent c() {
        return PendingIntent.getBroadcast(this.f30031a, 0, b(), 134217728);
    }

    public final void b(PendingIntent pendingIntent) {
        o3.b("GeofenceManager", "sendIntentExit: pendingIntent=" + pendingIntent);
        Intent intent = new Intent();
        intent.putExtra("entering", false);
        a(pendingIntent, intent);
    }

    public u1(Context context) {
        this(context, Looper.myLooper());
    }

    public final Intent b() {
        Intent intent = new Intent("com.tencent.map.geolocation.wakeup");
        intent.putExtra("com.tencent.map.geolocation.from_alarm", true);
        return intent;
    }

    public static void b(String str) {
        o3.b("log_to_file", str);
    }

    public void a(TencentGeofence tencentGeofence) {
        a();
        if (tencentGeofence == null) {
            return;
        }
        o3.b("GeofenceManager", "removeFence: fence=" + tencentGeofence);
        synchronized (this.f30037g) {
            Iterator<r1> it = this.f30037g.f30045a.iterator();
            while (it.hasNext()) {
                if (tencentGeofence.equals(it.next().f29958a)) {
                    it.remove();
                }
            }
            e("removeFence: --> schedule update fence");
        }
    }

    public final void a(boolean z16) {
        double d16;
        long j3;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        synchronized (this.f30037g) {
            this.f30037g.f30049e = false;
            i();
            Location e16 = e();
            b("updateFences: fresh_location=" + e16);
            ArrayList arrayList = new ArrayList();
            List<r1> list = this.f30037g.f30045a;
            boolean isEmpty = list.isEmpty() ^ true;
            if (e16 != null) {
                s1.a(e16);
                d16 = Double.MAX_VALUE;
                for (r1 r1Var : list) {
                    int a16 = r1Var.a(e16);
                    if ((a16 & 1) != 0) {
                        linkedList.add(r1Var.f29961d);
                    }
                    if ((a16 & 2) != 0) {
                        linkedList2.add(r1Var.f29961d);
                    }
                    double a17 = r1Var.a();
                    if (a17 < d16) {
                        d16 = a17;
                    }
                    if (r1Var.c()) {
                        arrayList.add(Float.valueOf(r1Var.b()));
                    }
                }
                a(arrayList);
            } else {
                d16 = Double.MAX_VALUE;
            }
            if (isEmpty) {
                double f16 = f();
                long j16 = 305000;
                if (e16 == null || Double.compare(d16, Double.MAX_VALUE) == 0) {
                    j3 = 60000;
                } else {
                    j3 = (long) Math.min(900000.0d, Math.max(60000.0d, (d16 * 1000.0d) / f16));
                    if (d16 < 1000.0d && j3 > 305000) {
                        j3 = 305000;
                    }
                }
                if (f16 < 5.0d && d16 > 800.0d) {
                    double d17 = this.f30043m * 1.02d;
                    this.f30043m = d17;
                    long j17 = (long) (d17 * 2.0d * 60000.0d);
                    if (j17 <= 305000) {
                        j16 = j17;
                    }
                    j3 = j16;
                } else {
                    this.f30043m = 1.0d;
                }
                this.f30037g.f30047c = j3;
                boolean z17 = z16 && e16 == null;
                b(String.format(Locale.getDefault(), "updateFences: needUpdates=%s, interval=%d, minDist=%5g, speed=%.2f, reschedule=%s, rate=%.2f", Boolean.valueOf(isEmpty), Long.valueOf(j3), Double.valueOf(d16), Double.valueOf(f16), Boolean.valueOf(z17), Double.valueOf(this.f30043m)));
                c cVar = this.f30037g;
                if (!cVar.f30046b) {
                    cVar.f30046b = true;
                    this.f30034d.acquire(12000L);
                    this.f30032b.a(this.f30041k, this, this.f30035e.getLooper());
                } else if (z17) {
                    a(-1L);
                    this.f30037g.f30046b = true;
                    this.f30034d.acquire(12000L);
                    this.f30032b.a(this.f30041k, this, this.f30035e.getLooper());
                }
            } else {
                c cVar2 = this.f30037g;
                if (cVar2.f30046b) {
                    cVar2.f30046b = false;
                    j();
                    k();
                }
            }
            HashMap hashMap = new HashMap();
            for (r1 r1Var2 : list) {
                hashMap.put(r1Var2.f29958a.getTag(), r1Var2.toString());
            }
            this.f30036f.f30052b.add(hashMap);
        }
        Iterator it = linkedList2.iterator();
        while (it.hasNext()) {
            b((PendingIntent) it.next());
        }
        Iterator it5 = linkedList.iterator();
        while (it5.hasNext()) {
            a((PendingIntent) it5.next());
        }
    }

    public float a(List<Float> list) {
        float f16;
        if (list.size() >= 1) {
            Collections.sort(list);
            Collections.reverse(list);
            f16 = list.get(0).floatValue();
        } else {
            f16 = 25.0f;
        }
        float[] fArr = this.f30037g.f30050f;
        float f17 = fArr[0];
        if (f17 > 0.0f) {
            float f18 = f17 + f16;
            fArr[0] = f18;
            fArr[0] = (float) (f18 * 0.5d);
        } else {
            fArr[0] = f16;
        }
        return fArr[0];
    }

    public final void a(PendingIntent pendingIntent) {
        o3.b("GeofenceManager", "sendIntentEnter: pendingIntent=" + pendingIntent);
        Intent intent = new Intent();
        intent.putExtra("entering", true);
        a(pendingIntent, intent);
    }

    @SuppressLint({"Wakelock"})
    public final void a(PendingIntent pendingIntent, Intent intent) {
        this.f30033c.acquire();
        try {
            pendingIntent.send(this.f30031a, 0, intent, this, null);
        } catch (PendingIntent.CanceledException unused) {
            b(null, pendingIntent);
            this.f30033c.release();
        }
    }

    public final PendingIntent a(long j3) {
        AlarmManager alarmManager = (AlarmManager) this.f30031a.getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent pendingIntent = null;
        if (alarmManager == null) {
            return null;
        }
        String str = Build.MANUFACTURER;
        boolean contains = str != null ? str.toLowerCase(Locale.US).contains("xiaomi") : false;
        PendingIntent pendingIntent2 = this.f30040j;
        if (pendingIntent2 != null) {
            alarmManager.cancel(pendingIntent2);
            this.f30040j = null;
            if (contains) {
                this.f30035e.removeMessages(2);
            }
        }
        if (j3 > 0) {
            pendingIntent = c();
            this.f30040j = pendingIntent;
            alarmManager.setRepeating(2, SystemClock.elapsedRealtime() + j3, j3, pendingIntent);
            if (contains) {
                this.f30035e.sendEmptyMessageDelayed(2, 10000 + j3);
            }
            b("setLocationAlarm: will triggered after " + j3 + " ms, isXiaomi=" + contains);
        }
        return pendingIntent;
    }

    @Override // com.tencent.map.geolocation.TencentLocationListener
    public void onStatusUpdate(String str, int i3, String str2) {
    }
}
