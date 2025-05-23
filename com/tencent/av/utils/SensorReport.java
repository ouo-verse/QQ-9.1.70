package com.tencent.av.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import kotlinx.coroutines.DebugKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SensorReport {

    /* renamed from: v, reason: collision with root package name */
    static String f76780v = "actAVGSensorCaseReport";

    /* renamed from: w, reason: collision with root package name */
    private static BroadcastReceiver f76781w = new a();

    /* renamed from: f, reason: collision with root package name */
    private String f76787f;

    /* renamed from: g, reason: collision with root package name */
    private long f76788g;

    /* renamed from: h, reason: collision with root package name */
    private long f76789h;

    /* renamed from: a, reason: collision with root package name */
    private long f76782a = 0;

    /* renamed from: b, reason: collision with root package name */
    private long f76783b = 0;

    /* renamed from: c, reason: collision with root package name */
    private long f76784c = 0;

    /* renamed from: d, reason: collision with root package name */
    private long f76785d = 0;

    /* renamed from: e, reason: collision with root package name */
    private String f76786e = "";

    /* renamed from: i, reason: collision with root package name */
    int f76790i = 0;

    /* renamed from: j, reason: collision with root package name */
    int f76791j = 1;

    /* renamed from: k, reason: collision with root package name */
    int f76792k = 2;

    /* renamed from: l, reason: collision with root package name */
    int f76793l = 4;

    /* renamed from: m, reason: collision with root package name */
    int f76794m = 8;

    /* renamed from: n, reason: collision with root package name */
    int f76795n = 16;

    /* renamed from: o, reason: collision with root package name */
    int f76796o = 32;

    /* renamed from: p, reason: collision with root package name */
    b f76797p = null;

    /* renamed from: q, reason: collision with root package name */
    int f76798q = 0;

    /* renamed from: r, reason: collision with root package name */
    ArrayList<b> f76799r = new ArrayList<>();

    /* renamed from: s, reason: collision with root package name */
    final int f76800s = 0;

    /* renamed from: t, reason: collision with root package name */
    final int f76801t = 1;

    /* renamed from: u, reason: collision with root package name */
    final int f76802u = 2;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction() != null && SensorReport.f76780v.equals(intent.getAction())) {
                if (QLog.isDevelopLevel()) {
                    QLog.w("SensorReport", 1, "H264_decode");
                }
                HashMap hashMap = (HashMap) intent.getSerializableExtra("params");
                String stringExtra = intent.getStringExtra("key");
                if (stringExtra == null) {
                    stringExtra = SensorReport.f76780v;
                }
                UserAction.onUserAction(stringExtra, true, -1L, -1L, hashMap, true, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        int f76805a = 0;

        /* renamed from: b, reason: collision with root package name */
        long f76806b = 0;

        /* renamed from: c, reason: collision with root package name */
        long f76807c = 0;

        /* renamed from: d, reason: collision with root package name */
        long f76808d;

        b() {
            this.f76808d = SensorReport.this.f76790i;
        }
    }

    public static void e(final Context context) {
        e.s(context);
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(f76780v);
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.av.utils.SensorReport.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    context.registerReceiver(SensorReport.f76781w, intentFilter);
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("SensorReport", 2, "registonUserActionReceiver e = " + e16);
                    }
                }
            }
        }, 5, null, false);
    }

    private void f(int i3, ArrayList<b> arrayList) {
        String str;
        if (this.f76782a != 0 && this.f76788g != 0) {
            if (arrayList.size() <= 0) {
                str = "";
            } else {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("size", arrayList.size());
                    JSONArray jSONArray = new JSONArray();
                    Iterator<b> it = arrayList.iterator();
                    while (it.hasNext()) {
                        b next = it.next();
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("i", next.f76805a);
                        jSONObject2.put(DebugKt.DEBUG_PROPERTY_VALUE_OFF, next.f76806b);
                        jSONObject2.put("on", next.f76807c);
                        jSONObject2.put("why", next.f76808d);
                        jSONArray.mo162put(jSONObject2);
                    }
                    jSONObject.put("infos", jSONArray);
                    str = jSONObject.toString();
                } catch (JSONException unused) {
                    str = "JSONException. ";
                } catch (Exception e16) {
                    str = "json_" + e16.getClass().getName() + ". ";
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("guid", this.f76787f);
            hashMap.put("RoomID", String.valueOf(this.f76788g));
            hashMap.put("EnterRoomTime", String.valueOf(this.f76789h));
            hashMap.put("screenInfo", str);
            hashMap.put("StartSensorTime", String.valueOf(this.f76782a));
            hashMap.put("EndSensorTime", String.valueOf(this.f76783b));
            hashMap.put("SetIgnore", String.valueOf(this.f76784c));
            hashMap.put("ClearIgnore", String.valueOf(this.f76785d));
            hashMap.put(AdMetricTag.Report.TYPE, String.valueOf(i3));
            hashMap.put("Log", this.f76786e);
            hashMap.put("ScreenInfoCount", String.valueOf(this.f76798q));
            if (this.f76784c != 0) {
                hashMap.put("sdkVersion", String.valueOf(Build.VERSION.SDK_INT));
                hashMap.put("devicesInfo", com.tencent.mobileqq.utils.m.b());
            }
            if (QLog.isDevelopLevel()) {
                QLog.d(f76780v, 4, "mRoomID[" + this.f76788g + "], guid[" + this.f76787f + "], [" + str);
            }
            if (!TextUtils.isEmpty(this.f76786e)) {
                QLog.d(f76780v, 1, this.f76787f + this.f76786e);
            }
            if (i3 == 0) {
                VideoAppInterface videoAppInterface = (VideoAppInterface) BaseApplicationImpl.sApplication.getRuntime();
                if (videoAppInterface != null) {
                    Intent intent = new Intent(f76780v);
                    intent.putExtra("params", hashMap);
                    intent.setPackage(videoAppInterface.getApp().getPackageName());
                    videoAppInterface.getApp().sendBroadcast(intent);
                }
            } else {
                UserAction.onUserAction(f76780v, true, -1L, -1L, hashMap, true);
            }
            this.f76786e = "";
            this.f76797p = null;
            if (i3 != 1) {
                this.f76782a = 0L;
                this.f76783b = 0L;
                this.f76784c = 0L;
                this.f76785d = 0L;
                return;
            }
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(f76780v, 4, "report Ignore, mRoomID[" + this.f76788g + "], guid[" + this.f76787f);
        }
    }

    public static void k(Context context) {
        try {
            context.unregisterReceiver(f76781w);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("SensorReport", 2, "unregistonUserActionReceiver e = " + e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        long currentTimeMillis = System.currentTimeMillis();
        String uuid = UUID.randomUUID().toString();
        if (this.f76782a != 0) {
            this.f76786e += "[" + this.f76787f + "->" + uuid + "]begin had came[" + this.f76782a + "->" + currentTimeMillis + "]";
            if (this.f76783b == 0) {
                this.f76783b = currentTimeMillis;
            }
            ArrayList<b> arrayList = this.f76799r;
            this.f76799r = new ArrayList<>();
            f(2, arrayList);
        }
        this.f76782a = currentTimeMillis;
        this.f76787f = uuid;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f76785d != 0) {
            this.f76786e += "clearIgnoreFlag[" + this.f76785d + "->" + currentTimeMillis + "]\u3002";
        }
        this.f76785d = currentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        if (this.f76783b != 0) {
            this.f76786e += "end_came[" + this.f76783b + "]\u3002";
        }
        this.f76783b = System.currentTimeMillis();
        ArrayList<b> arrayList = this.f76799r;
        this.f76799r = new ArrayList<>();
        f(0, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f76784c != 0) {
            this.f76786e += "setIgnore[" + this.f76784c + "->" + currentTimeMillis + "]\u3002";
        }
        this.f76784c = currentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        if (com.tencent.av.r.h0() != null) {
            long O = com.tencent.av.r.h0().O();
            this.f76788g = O;
            if (O != 0) {
                int i3 = com.tencent.av.n.e().f().f73035i;
                if (i3 == 3 || i3 == 4) {
                    this.f76789h = com.tencent.av.r.h0().f0();
                }
                if (QLog.isDevelopLevel()) {
                    QLog.d(f76780v, 4, "setRoomID[" + this.f76788g + "], EnterRoomTime[" + this.f76789h);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        b bVar = new b();
        this.f76797p = bVar;
        int i3 = this.f76798q;
        bVar.f76805a = i3;
        this.f76798q = i3 + 1;
        bVar.f76806b = System.currentTimeMillis();
        this.f76799r.add(this.f76797p);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(boolean z16, boolean z17, boolean z18, int i3, boolean z19) {
        if (this.f76788g == 0) {
            h();
        }
        int i16 = this.f76790i;
        if (!z16) {
            i16 |= this.f76793l;
        }
        if (!z17) {
            i16 |= this.f76794m;
        }
        if (z18) {
            i16 |= this.f76791j;
        }
        if (i3 == 3) {
            i16 |= this.f76792k;
        }
        if (i3 == 1) {
            i16 |= this.f76795n;
        }
        if (z19) {
            i16 |= this.f76796o;
        }
        long currentTimeMillis = System.currentTimeMillis();
        b bVar = this.f76797p;
        this.f76797p = null;
        if (bVar != null) {
            bVar.f76807c = currentTimeMillis;
            bVar.f76808d = i16;
        } else {
            this.f76786e += "setScreenOn_LastScreenInfo_null[" + currentTimeMillis + "], why[" + i16 + "]\u3002";
        }
        if (!z19 && this.f76799r.size() >= 6) {
            ArrayList<b> arrayList = this.f76799r;
            this.f76799r = new ArrayList<>();
            f(1, arrayList);
        }
    }
}
