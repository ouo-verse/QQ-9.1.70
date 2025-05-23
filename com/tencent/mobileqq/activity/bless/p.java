package com.tencent.mobileqq.activity.bless;

import android.content.SharedPreferences;
import android.text.format.DateUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import okhttp3.HttpUrl;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes10.dex */
public class p {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, Integer> f180600a;

    /* renamed from: b, reason: collision with root package name */
    private int f180601b;

    /* renamed from: c, reason: collision with root package name */
    private long f180602c;

    public p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f180600a = new HashMap<>();
            this.f180601b = 0;
        }
    }

    private void f(String str, int i3) {
        this.f180601b += i3;
        this.f180600a.put(str, Integer.valueOf(i3));
    }

    public static p g(SharedPreferences sharedPreferences, int i3) {
        String str;
        String str2;
        if (i3 == 2) {
            str = "web_uin_list";
            str2 = "web_uin_list_time_millis";
        } else {
            str = "bless_uin_list";
            str2 = "bless_uin_list_time_millis";
        }
        p pVar = new p();
        long j3 = sharedPreferences.getLong(str2, 0L);
        pVar.f180602c = j3;
        if (DateUtils.isToday(j3)) {
            try {
                String string = sharedPreferences.getString(str, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                if (QLog.isColorLevel()) {
                    QLog.d("BlessManager", 2, "read uin list from mode=" + i3 + " ,SP=" + string);
                }
                JSONArray jSONArray = new JSONArray(string);
                int i16 = 0;
                while (true) {
                    int i17 = i16 + 1;
                    if (i17 >= jSONArray.length()) {
                        break;
                    }
                    pVar.f(jSONArray.getString(i16), jSONArray.getInt(i17));
                    i16 += 2;
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                return null;
            }
        } else {
            pVar.f180602c = System.currentTimeMillis();
        }
        return pVar;
    }

    public static void h(SharedPreferences sharedPreferences, p pVar, int i3) {
        pVar.b();
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry<String, Integer> entry : pVar.f180600a.entrySet()) {
            jSONArray.mo162put(entry.getKey());
            jSONArray.mo162put(entry.getValue());
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        String jSONArray2 = jSONArray.toString();
        if (QLog.isColorLevel()) {
            QLog.d("BlessManager", 2, "save uin list to SP=" + jSONArray2);
        }
        if (i3 == 2) {
            edit.putString("web_uin_list", jSONArray2);
            edit.putLong("web_uin_list_time_millis", pVar.f180602c);
        } else {
            edit.putString("bless_uin_list", jSONArray2);
            edit.putLong("bless_uin_list_time_millis", pVar.f180602c);
        }
        edit.commit();
    }

    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        this.f180601b++;
        if (this.f180600a.containsKey(str)) {
            HashMap<String, Integer> hashMap = this.f180600a;
            hashMap.put(str, Integer.valueOf(hashMap.get(str).intValue() + 1));
        } else {
            this.f180600a.put(str, 1);
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else if (!DateUtils.isToday(this.f180602c)) {
            c();
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.f180600a.clear();
        this.f180601b = 0;
        this.f180602c = System.currentTimeMillis();
    }

    public boolean d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str)).booleanValue();
        }
        return this.f180600a.containsKey(str);
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f180601b;
    }

    public int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f180600a.size();
    }
}
