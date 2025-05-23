package com.tencent.mobileqq.dt.model;

import android.view.KeyEvent;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class i {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static i f203856d;

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, JSONArray> f203857a;

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, JSONArray> f203858b;

    /* renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<String, JSONArray> f203859c;

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f203857a = new ConcurrentHashMap<>();
        this.f203858b = new ConcurrentHashMap<>();
        this.f203859c = new ConcurrentHashMap<>();
    }

    private static void a(String str, JSONObject jSONObject, ConcurrentHashMap<String, JSONArray> concurrentHashMap) {
        JSONArray jSONArray = concurrentHashMap.get(str);
        if (jSONArray == null) {
            jSONArray = new JSONArray();
        }
        jSONArray.mo162put(jSONObject);
        concurrentHashMap.put(str, jSONArray);
    }

    public static i c() {
        if (f203856d == null) {
            synchronized (i.class) {
                if (f203856d == null) {
                    f203856d = new i();
                }
            }
        }
        return f203856d;
    }

    public String b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        try {
            JSONArray jSONArray = this.f203857a.get(str);
            JSONArray jSONArray2 = this.f203859c.get(str);
            JSONArray jSONArray3 = this.f203858b.get(str);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("t", jSONArray);
            jSONObject.put("k", jSONArray2);
            jSONObject.put("l", jSONArray3);
            String jSONObject2 = jSONObject.toString();
            this.f203858b.clear();
            this.f203859c.clear();
            this.f203857a.clear();
            return jSONObject2;
        } catch (Throwable th5) {
            QLog.e("FEKit_UiActionRecorder", 2, "onLongClick exception:" + th5);
            return "";
        }
    }

    public void d(String str, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) keyEvent);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("CT", System.currentTimeMillis());
            jSONObject.put("K", keyEvent.getKeyCode());
            jSONObject.put(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, keyEvent.getAction());
            jSONObject.put("D", keyEvent.getDownTime());
            a(str, jSONObject, this.f203859c);
        } catch (Throwable th5) {
            QLog.e("FEKit_UiActionRecorder", 2, "onLongClick exception:" + th5);
        }
    }

    public void e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("CT", System.currentTimeMillis());
            a(str, jSONObject, this.f203858b);
        } catch (Throwable th5) {
            QLog.e("FEKit_UiActionRecorder", 2, "onLongClick exception:" + th5);
        }
    }

    public void f(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("CT", System.currentTimeMillis());
            jSONObject.put(BdhLogUtil.LogTag.Tag_Conn, i3);
            jSONObject.put("T", i16 + i3);
            a(str, jSONObject, this.f203857a);
        } catch (Throwable th5) {
            QLog.e("FEKit_UiActionRecorder", 2, "onTextIn exception:" + th5);
        }
    }
}
