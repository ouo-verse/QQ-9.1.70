package com.tencent.mobileqq.msf.core.stepcount.g;

import android.content.SharedPreferences;
import android.util.Pair;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants;
import com.tencent.mobileqq.msf.core.stepcount.c;
import com.tencent.mobileqq.msf.core.stepcount.e;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a implements c {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: g, reason: collision with root package name */
    private static final String f250024g = "StepDataStoreImpl";

    /* renamed from: h, reason: collision with root package name */
    private static final String f250025h = "health_step_count_data";

    /* renamed from: i, reason: collision with root package name */
    private static final String f250026i = "recent_step_records";

    /* renamed from: j, reason: collision with root package name */
    private static final String f250027j = "device_shutdown";

    /* renamed from: k, reason: collision with root package name */
    private static final String f250028k = "last_sensor_value";

    /* renamed from: l, reason: collision with root package name */
    private static final String f250029l = "last_sensor_timestamp";

    /* renamed from: m, reason: collision with root package name */
    private static final String f250030m = "init_sensor_values";

    /* renamed from: n, reason: collision with root package name */
    private static final String f250031n = "shutdown_sensor_value";

    /* renamed from: o, reason: collision with root package name */
    private static final int f250032o = 86400;

    /* renamed from: a, reason: collision with root package name */
    private volatile int f250033a;

    /* renamed from: b, reason: collision with root package name */
    private volatile long f250034b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<Long, Integer> f250035c;

    /* renamed from: d, reason: collision with root package name */
    private final Map<Long, Integer> f250036d;

    /* renamed from: e, reason: collision with root package name */
    private final Map<Long, Integer> f250037e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f250038f;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f250035c = new ConcurrentHashMap();
        this.f250036d = new HashMap();
        this.f250037e = new HashMap();
        this.f250038f = false;
    }

    private long e(long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3 * 1000);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        return calendar.getTimeInMillis() / 1000;
    }

    @Override // com.tencent.mobileqq.msf.core.stepcount.c
    public void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
            return;
        }
        SharedPreferences e16 = e();
        long serverTime = NetConnInfoCenter.getServerTime();
        this.f250038f = e16.getBoolean(f250027j, false);
        e16.edit().remove(f250027j).apply();
        if (!z16 && !this.f250038f) {
            this.f250033a = e16.getInt(f250028k, 0);
            this.f250034b = e16.getLong(f250029l, NetConnInfoCenter.getServerTime());
            QLog.d(f250024g, 1, " read last sensor info from sp to memory, lastSensorValue:" + this.f250033a + " , lastSensorTime:" + this.f250034b);
        } else {
            QLog.d(f250024g, 1, "reboot happened: autoBoot:" + z16 + " , hasShutdown:" + this.f250038f);
            this.f250033a = 0;
            this.f250034b = NetConnInfoCenter.getServerTime();
        }
        int d16 = e.a().d();
        String string = e16.getString(f250026i, "");
        String string2 = e16.getString(f250030m, "");
        String string3 = e16.getString(f250031n, "");
        a(string, this.f250035c, d16, serverTime);
        a(string2, this.f250036d, d16, serverTime);
        a(string3, this.f250037e, d16, serverTime);
    }

    @Override // com.tencent.mobileqq.msf.core.stepcount.c
    public void b(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, j3);
            return;
        }
        QLog.d(f250024g, 1, "shutdown flag is set, timestamp " + j3);
        this.f250038f = true;
        e().edit().putBoolean(f250027j, true).apply();
        long e16 = e(j3);
        Integer num = this.f250035c.get(Long.valueOf(e16));
        if (num != null) {
            this.f250037e.put(Long.valueOf(e16), num);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.stepcount.c
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            this.f250038f = false;
        } else {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.stepcount.c
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f250024g, 2, "write in memory last step and recent records to sp");
        }
        e().edit().putInt(f250028k, this.f250033a).putLong(f250029l, this.f250034b).putString(f250026i, a(this.f250035c)).putString(f250030m, a(this.f250036d)).putString(f250031n, a(this.f250037e)).apply();
    }

    @Override // com.tencent.mobileqq.msf.core.stepcount.c
    public void c(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        long e16 = e(j3);
        Integer num = this.f250035c.get(Long.valueOf(e16));
        if (QLog.isColorLevel()) {
            QLog.d(f250024g, 2, "resetByServer, old step from step history:" + num + " , step from server:" + i3 + " , timestamp:" + j3);
        }
        if (num == null || i3 > num.intValue()) {
            this.f250035c.put(Long.valueOf(e16), Integer.valueOf(i3));
        }
    }

    private SharedPreferences e() {
        return MsfService.core.getSharedPreferences(f250025h, 0);
    }

    @Override // com.tencent.mobileqq.msf.core.stepcount.c
    public Pair<Long, Integer> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? Pair.create(Long.valueOf(this.f250034b), Integer.valueOf(this.f250033a)) : (Pair) iPatchRedirector.redirect((short) 7, (Object) this);
    }

    @Override // com.tencent.mobileqq.msf.core.stepcount.c
    public void b(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        long e16 = e(j3);
        Integer num = this.f250035c.get(Long.valueOf(e16));
        if (num == null) {
            QLog.d(f250024g, 2, "today's step not found in step history, add offset as new step count, offset:" + i3 + " , timestamp:" + j3);
            this.f250035c.put(Long.valueOf(e16), Integer.valueOf(i3));
            return;
        }
        this.f250035c.put(Long.valueOf(e16), Integer.valueOf(num.intValue() + i3));
    }

    @Override // com.tencent.mobileqq.msf.core.stepcount.c
    public int c(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this, j3)).intValue();
        }
        Integer num = this.f250035c.get(Long.valueOf(e(j3)));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    private void d(int i3, long j3) {
        long e16 = e(j3);
        if (this.f250036d.containsKey(Long.valueOf(e16))) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f250024g, 2, "tryRecordInitSensorValue, today's init value inserted, sensorValue:" + i3 + " , timestamp:" + j3);
        }
        this.f250036d.put(Long.valueOf(e16), Integer.valueOf(i3));
    }

    @Override // com.tencent.mobileqq.msf.core.stepcount.c
    public Map<String, String> d(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Map) iPatchRedirector.redirect((short) 13, (Object) this, j3);
        }
        HashMap hashMap = new HashMap();
        long e16 = e(j3);
        Integer num = this.f250035c.get(Long.valueOf(e16));
        hashMap.put(StepCounterConstants.BEACON_PARAM_KEY_DATA2, String.valueOf(num != null ? num.intValue() : 0));
        Integer num2 = this.f250036d.get(Long.valueOf(e16));
        hashMap.put(StepCounterConstants.BEACON_PARAM_KEY_EXT0, String.valueOf(num2 != null ? num2.intValue() : 0));
        hashMap.put("ext1", String.valueOf(this.f250033a));
        Integer num3 = this.f250037e.get(Long.valueOf(e16));
        hashMap.put("ext2", String.valueOf(num3 != null ? num3.intValue() : 0));
        return hashMap;
    }

    private void a(String str, Map<Long, Integer> map, int i3, long j3) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            long e16 = e(j3);
            for (int i16 = 0; i16 < i3; i16++) {
                int optInt = jSONObject.optInt(String.valueOf(e16), 0);
                if (optInt > 0) {
                    map.put(Long.valueOf(e16), Integer.valueOf(optInt));
                }
            }
        } catch (JSONException e17) {
            QLog.e(f250024g, 1, "read map from json sp fail.", e17);
        }
    }

    private String a(Map<Long, Integer> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<Long, Integer> entry : map.entrySet()) {
                jSONObject.put(String.valueOf(entry.getKey()), entry.getValue());
            }
            return jSONObject.toString();
        } catch (JSONException e16) {
            QLog.e(f250024g, 1, "fail to convert map to json", e16);
            return "";
        }
    }

    @Override // com.tencent.mobileqq.msf.core.stepcount.c
    public void a(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f250024g, 2, "calibrateLastTimestamp, new timestamp:" + j3);
        }
        this.f250034b = j3;
        long e16 = e(j3);
        this.f250035c.put(Long.valueOf(e16), 0);
        this.f250036d.put(Long.valueOf(e16), Integer.valueOf(this.f250033a));
        this.f250038f = false;
    }

    @Override // com.tencent.mobileqq.msf.core.stepcount.c
    public void a(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        this.f250033a = i3;
        this.f250034b = j3;
        d(i3, j3);
    }

    @Override // com.tencent.mobileqq.msf.core.stepcount.c
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? this.f250038f : ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
    }

    @Override // com.tencent.mobileqq.msf.core.stepcount.c
    public HashMap<Long, Integer> a(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (HashMap) iPatchRedirector.redirect((short) 14, this, Long.valueOf(j3), Long.valueOf(j16));
        }
        long e16 = e(j3);
        HashMap<Long, Integer> hashMap = new HashMap<>();
        for (Map.Entry<Long, Integer> entry : this.f250035c.entrySet()) {
            long longValue = entry.getKey().longValue();
            int intValue = entry.getValue().intValue();
            if (longValue == e16) {
                hashMap.put(Long.valueOf(longValue), Integer.valueOf(intValue));
            } else if (longValue >= j16) {
                hashMap.put(Long.valueOf(longValue), Integer.valueOf(intValue));
            }
        }
        return hashMap;
    }
}
