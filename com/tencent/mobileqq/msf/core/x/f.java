package com.tencent.mobileqq.msf.core.x;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public abstract class f {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    protected static final String f250248a = "MSFConfig";

    /* renamed from: b, reason: collision with root package name */
    protected static final String f250249b = "msf_config";

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract void a(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, JSONObject jSONObject, @NonNull AtomicBoolean atomicBoolean, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, jSONObject, atomicBoolean, str2);
        } else if (str.contains(str2)) {
            boolean optBoolean = jSONObject.optBoolean(str2, atomicBoolean.get());
            atomicBoolean.set(optBoolean);
            b(str2, optBoolean);
        }
    }

    protected void b(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            MsfService.getCore().getSharedPreferences(f250249b, 4).edit().putBoolean(str, z16).apply();
        } else {
            iPatchRedirector.redirect((short) 8, this, str, Boolean.valueOf(z16));
        }
    }

    protected void b(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            MsfService.getCore().getSharedPreferences(f250249b, 4).edit().putInt(str, i3).apply();
        } else {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, JSONObject jSONObject, @NonNull AtomicInteger atomicInteger, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, jSONObject, atomicInteger, str2);
        } else if (str.contains(str2)) {
            int optInt = jSONObject.optInt(str2, atomicInteger.get());
            atomicInteger.set(optInt);
            b(str2, optInt);
        }
    }

    protected void b(String str, double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            MsfService.getCore().getSharedPreferences(f250249b, 4).edit().putString(str, String.valueOf(d16)).apply();
        } else {
            iPatchRedirector.redirect((short) 12, this, str, Double.valueOf(d16));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public double a(String str, JSONObject jSONObject, String str2, double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Double) iPatchRedirector.redirect((short) 4, this, str, jSONObject, str2, Double.valueOf(d16))).doubleValue();
        }
        if (!str.contains(str2)) {
            return d16;
        }
        double optDouble = jSONObject.optDouble(str2, d16);
        b(str2, optDouble);
        return optDouble;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str, (Object) str2);
        } else {
            QLog.d(f250248a, 1, "[saveStringToSp] save: ", str, ",", str2);
            MsfService.getCore().getSharedPreferences(f250249b, 4).edit().putString(str, str2).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String a(String str, JSONObject jSONObject, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, this, str, jSONObject, str2, str3);
        }
        if (!str.contains(str2)) {
            return str3;
        }
        String optString = jSONObject.optString(str2, str3);
        b(str2, optString);
        return optString;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, JSONObject jSONObject, Set<String> set, String str2) {
        JSONArray optJSONArray;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, jSONObject, set, str2);
            return;
        }
        if (!str.contains(str2) || (optJSONArray = jSONObject.optJSONArray(str2)) == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        int length = optJSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            Object opt = optJSONArray.opt(i3);
            if (opt instanceof String) {
                if (set != null) {
                    set.add((String) opt);
                }
                sb5.append(opt);
                sb5.append("|");
            }
        }
        b(str2, sb5.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? MsfService.getCore().getSharedPreferences(f250249b, 4).getBoolean(str, z16) : ((Boolean) iPatchRedirector.redirect((short) 7, this, str, Boolean.valueOf(z16))).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) ? MsfService.getCore().getSharedPreferences(f250249b, 4).getInt(str, i3) : ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, i3)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public double a(String str, double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Double) iPatchRedirector.redirect((short) 11, this, str, Double.valueOf(d16))).doubleValue();
        }
        try {
            return Double.parseDouble(MsfService.getCore().getSharedPreferences(f250249b, 4).getString(str, String.valueOf(d16)));
        } catch (NumberFormatException e16) {
            QLog.e(f250248a, 1, "[getDoubleFromSp] error: ", e16);
            return d16;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String a(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str, (Object) str2);
        }
        try {
            return MsfService.getCore().getSharedPreferences(f250249b, 4).getString(str, str2);
        } catch (Throwable th5) {
            QLog.e(f250248a, 1, "[getStringFromSp] error: ", th5);
            return "";
        }
    }
}
