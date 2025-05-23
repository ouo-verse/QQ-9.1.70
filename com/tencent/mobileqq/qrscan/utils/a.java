package com.tencent.mobileqq.qrscan.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static volatile a f276796b;

    /* renamed from: a, reason: collision with root package name */
    private final Set<String> f276797a;

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f276797a = new HashSet();
        }
    }

    public static a a() {
        if (f276796b == null) {
            synchronized (a.class) {
                if (f276796b == null) {
                    f276796b = new a();
                }
            }
        }
        return f276796b;
    }

    private synchronized void c(AppRuntime appRuntime) {
        JSONArray jSONArray;
        if (appRuntime != null) {
            if (this.f276797a.isEmpty()) {
                IFeatureRuntimeService iFeatureRuntimeService = (IFeatureRuntimeService) appRuntime.getRuntimeService(IFeatureRuntimeService.class, "all");
                if (!iFeatureRuntimeService.isFeatureSwitchEnable("qrscan_glsurfaceview_close_camera_list")) {
                    QLog.d("ARSurfaceViewCloseCameraManager", 1, "loadDeviceSet, featureSwitch not enable.");
                    return;
                }
                JSONObject jSONObject = iFeatureRuntimeService.getJSONObject("qrscan_glsurfaceview_close_camera_list", "");
                if (jSONObject == null) {
                    return;
                }
                try {
                    jSONArray = jSONObject.getJSONArray("close_camera_list");
                } catch (JSONException e16) {
                    QLog.e("ARSurfaceViewCloseCameraManager", 1, "loadDeviceSet error : " + e16);
                }
                if (jSONArray == null) {
                    return;
                }
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    this.f276797a.add(jSONArray.getString(i3).toUpperCase());
                }
            }
        }
    }

    public boolean b(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime)).booleanValue();
        }
        c(appRuntime);
        String model = DeviceInfoMonitor.getModel();
        if (TextUtils.isEmpty(model)) {
            QLog.d("ARSurfaceViewCloseCameraManager", 1, "Build.MODEL is empty.");
            return false;
        }
        return this.f276797a.contains(model.toUpperCase());
    }
}
