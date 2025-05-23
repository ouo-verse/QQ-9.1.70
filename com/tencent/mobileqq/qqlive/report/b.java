package com.tencent.mobileqq.qqlive.report;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b implements com.tencent.mobileqq.qqlive.report.tianjige.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f271432a;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f271432a = null;
        }
    }

    private JSONObject d() {
        JSONObject jSONObject = this.f271432a;
        if (jSONObject != null) {
            return jSONObject;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(ht3.a.d("qqlive_task_open_telemetry_gray", "{\n\"trace_sample\": 1, \n\"telemetry_sdk_enable\":1,\n\"telemetry_exception_report\": 1\n }"));
            this.f271432a = jSONObject2;
            return jSONObject2;
        } catch (JSONException e16) {
            QLog.i("QQLiveOpenTelemetrySwitch", 1, "getGraySwitchJson exception:" + e16.getMessage());
            return null;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.report.tianjige.a
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        try {
            if (d() != null) {
                int i3 = d().getInt("telemetry_exception_report");
                QLog.i("QQLiveOpenTelemetrySwitch", 1, "TELEMETRY_EXCEPTION_REPORT enable:" + i3);
                if (i3 != 1) {
                    return false;
                }
                return true;
            }
        } catch (JSONException e16) {
            QLog.i("QQLiveOpenTelemetrySwitch", 1, "isExceptionReport exception:" + e16.getMessage());
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.report.tianjige.a
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        boolean e16 = ht3.a.e("qqlive_task_open_telemetry_enable", false);
        QLog.i("QQLiveOpenTelemetrySwitch", 1, "TELEMETRY_COLOR 1 enable:" + e16);
        return e16;
    }

    @Override // com.tencent.mobileqq.qqlive.report.tianjige.a
    public double c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Double) iPatchRedirector.redirect((short) 3, (Object) this)).doubleValue();
        }
        try {
            if (d() != null) {
                double d16 = d().getDouble("trace_sample");
                QLog.i("QQLiveOpenTelemetrySwitch", 1, "TRACE_SAMPLE sample:" + d16);
                return d16;
            }
            return 0.0d;
        } catch (JSONException e16) {
            QLog.i("QQLiveOpenTelemetrySwitch", 1, "getTraceSample exception:" + e16.getMessage());
            return 0.0d;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.report.tianjige.a
    public boolean isEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        try {
            if (d() != null) {
                int i3 = d().getInt("telemetry_sdk_enable");
                QLog.i("QQLiveOpenTelemetrySwitch", 1, "TELEMETRY_SDK_ENABLE enable:" + i3);
                if (i3 != 1) {
                    return false;
                }
                return true;
            }
        } catch (JSONException e16) {
            QLog.i("QQLiveOpenTelemetrySwitch", 1, "isEnable exception:" + e16.getMessage());
        }
        return false;
    }
}
