package com.tencent.turingcam;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class RYhXO {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static final RYhXO f382018b;

    /* renamed from: a, reason: collision with root package name */
    private final List<SkEpO> f382019a;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class ShGzN implements SkEpO {
        static IPatchRedirector $redirector_;

        public ShGzN() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.turingcam.RYhXO.SkEpO
        public void a(Context context, JSONObject jSONObject) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) jSONObject);
                return;
            }
            try {
                Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                if (registerReceiver != null && TextUtils.equals(registerReceiver.getAction(), "android.intent.action.BATTERY_CHANGED")) {
                    int i3 = 0;
                    int intExtra = registerReceiver.getIntExtra("level", 0);
                    int i16 = 100;
                    int intExtra2 = registerReceiver.getIntExtra("scale", 100);
                    int intExtra3 = registerReceiver.getIntExtra("status", -1);
                    int intExtra4 = registerReceiver.getIntExtra("plugged", -1);
                    if (intExtra3 != 2 && intExtra3 != 5) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (z16 && intExtra4 == 2) {
                        jSONObject.put("chargeState", 1);
                    } else if (z16 && intExtra4 == 1) {
                        jSONObject.put("chargeState", 2);
                    } else {
                        jSONObject.put("chargeState", 0);
                    }
                    if (intExtra2 != 0) {
                        int i17 = (intExtra * 100) / intExtra2;
                        if (i17 >= 0) {
                            i3 = i17;
                        }
                        if (i3 <= 100) {
                            i16 = i3;
                        }
                    } else {
                        i16 = -1;
                    }
                    jSONObject.put("batterLevel", i16);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface SkEpO {
        void a(Context context, JSONObject jSONObject);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class spXPg implements SkEpO {
        static IPatchRedirector $redirector_;

        public spXPg() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.turingcam.RYhXO.SkEpO
        public void a(Context context, JSONObject jSONObject) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) jSONObject);
            } else {
                jSONObject.put("bootTime", System.currentTimeMillis() - SystemClock.elapsedRealtime());
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11924);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f382018b = new RYhXO();
        }
    }

    RYhXO() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.f382019a = arrayList;
        arrayList.add(new ShGzN());
        arrayList.add(new spXPg());
    }

    public static RYhXO a() {
        return f382018b;
    }

    public JSONObject a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (JSONObject) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        }
        if (context == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        Iterator<SkEpO> it = this.f382019a.iterator();
        while (it.hasNext()) {
            try {
                it.next().a(context, jSONObject);
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }
}
