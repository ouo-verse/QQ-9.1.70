package com.tencent.mobileqq.perf.thread.handlerthread;

import android.text.TextUtils;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a implements IConfigData {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private boolean f258143d;

    /* renamed from: e, reason: collision with root package name */
    private float f258144e;

    /* renamed from: f, reason: collision with root package name */
    private long f258145f;

    /* renamed from: h, reason: collision with root package name */
    private float f258146h;

    /* renamed from: i, reason: collision with root package name */
    private float f258147i;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f258143d = false;
        this.f258144e = -1.0f;
        this.f258145f = 86400L;
        this.f258146h = -1.0f;
        this.f258147i = -1.0f;
    }

    public static a b() {
        a aVar = (a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("light_msg_queue");
        if (aVar == null) {
            QLog.w("LightMsgQ.Config", 1, "getInstance loadConfig is null!");
            return new a();
        }
        return aVar;
    }

    public float a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Float) iPatchRedirector.redirect((short) 6, (Object) this)).floatValue();
        }
        return this.f258146h;
    }

    public float c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Float) iPatchRedirector.redirect((short) 7, (Object) this)).floatValue();
        }
        return this.f258147i;
    }

    public void d(String str) {
        float f16;
        long j3;
        float f17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        if (StringUtil.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f258143d = jSONObject.getBoolean("hookEnable");
            float f18 = -1.0f;
            if (jSONObject.has("normalReportEventSampleRatio")) {
                String string = jSONObject.getString("normalReportEventSampleRatio");
                if (!TextUtils.isEmpty(string)) {
                    f17 = Float.parseFloat(string);
                } else {
                    f17 = -1.0f;
                }
                this.f258144e = f17;
            }
            if (jSONObject.has("normalReportMinTimeInterval")) {
                String string2 = jSONObject.getString("normalReportMinTimeInterval");
                if (!TextUtils.isEmpty(string2)) {
                    j3 = Long.parseLong(string2);
                } else {
                    j3 = 86400;
                }
                this.f258145f = j3;
            }
            if (jSONObject.has("crashReportEventSampleRatio")) {
                String string3 = jSONObject.getString("crashReportEventSampleRatio");
                if (!TextUtils.isEmpty(string3)) {
                    f16 = Float.parseFloat(string3);
                } else {
                    f16 = -1.0f;
                }
                this.f258146h = f16;
            }
            if (jSONObject.has("setFdInfoReportEventSampleRatio")) {
                String string4 = jSONObject.getString("setFdInfoReportEventSampleRatio");
                if (!TextUtils.isEmpty(string4)) {
                    f18 = Float.parseFloat(string4);
                }
                this.f258147i = f18;
            }
            QLog.i("LightMsgQ.Config", 1, "parse success! " + toString());
        } catch (Throwable th5) {
            QLog.e("LightMsgQ.Config", 1, "parse failed!", th5);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(super.toString());
        sb5.append(" isHookEnable:" + this.f258143d);
        sb5.append(" normalReportSampleRatio:" + this.f258144e);
        sb5.append(" normalReportMinTimeInterval:" + this.f258145f);
        sb5.append(" crashReportSampleRatio:" + this.f258146h);
        sb5.append(" setFdInfoReportSampleRatio:" + this.f258147i);
        return sb5.toString();
    }
}
