package com.tencent.qqperf.monitor.filedescriptor;

import android.text.TextUtils;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    int f363257d = 2;

    /* renamed from: e, reason: collision with root package name */
    float f363258e = -1.0f;

    /* renamed from: f, reason: collision with root package name */
    int f363259f = 300;

    /* renamed from: h, reason: collision with root package name */
    int f363260h = 40;

    public static a c() {
        a aVar = (a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("fd_monitor_config");
        if (aVar == null) {
            return new a();
        }
        return aVar;
    }

    public int a() {
        return this.f363257d;
    }

    public int b() {
        return this.f363259f;
    }

    public float d() {
        return this.f363258e;
    }

    public int e() {
        return this.f363260h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str) {
        int i3;
        float f16;
        int i16;
        int i17;
        if (StringUtil.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("backgroundReportLimit");
            if (!TextUtils.isEmpty(string)) {
                i3 = Integer.parseInt(string);
            } else {
                i3 = 2;
            }
            this.f363257d = i3;
            String string2 = jSONObject.getString("normalReportEventSampleRatio");
            if (!TextUtils.isEmpty(string2)) {
                f16 = Float.parseFloat(string2);
            } else {
                f16 = -1.0f;
            }
            this.f363258e = f16;
            String string3 = jSONObject.getString("dailyReportLimit");
            if (!TextUtils.isEmpty(string3)) {
                i16 = Integer.parseInt(string3);
            } else {
                i16 = 300;
            }
            this.f363259f = i16;
            String string4 = jSONObject.getString("procOnceReportLimit");
            if (!TextUtils.isEmpty(string4)) {
                i17 = Integer.parseInt(string4);
            } else {
                i17 = 40;
            }
            this.f363260h = i17;
            QLog.i("FileDescriptorMonitorConfig", 1, "parse success! " + toString());
        } catch (Throwable th5) {
            QLog.e("FileDescriptorMonitorConfig", 1, "parse failed!", th5);
        }
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(super.toString());
        sb5.append(" backgroundReportLimit:" + this.f363257d);
        sb5.append(" dailyReportLimit:" + this.f363259f);
        sb5.append(" procOnceReportLimit:" + this.f363260h);
        sb5.append(" normalReportEventSampleRatio:" + this.f363258e);
        return sb5.toString();
    }
}
