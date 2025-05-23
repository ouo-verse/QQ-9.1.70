package com.tencent.qqperf.monitor.file;

import android.content.Context;
import android.os.Environment;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {

    /* renamed from: f, reason: collision with root package name */
    public static String f363247f = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;

    /* renamed from: g, reason: collision with root package name */
    public static Boolean f363248g;

    /* renamed from: h, reason: collision with root package name */
    public static Boolean f363249h;

    /* renamed from: i, reason: collision with root package name */
    public static Integer f363250i;

    /* renamed from: j, reason: collision with root package name */
    public static Boolean f363251j;

    /* renamed from: a, reason: collision with root package name */
    public List<String> f363252a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    boolean f363253b;

    /* renamed from: c, reason: collision with root package name */
    boolean f363254c;

    /* renamed from: d, reason: collision with root package name */
    int f363255d;

    /* renamed from: e, reason: collision with root package name */
    boolean f363256e;

    public static a a(String str) {
        a aVar;
        QLog.d("ExternalDirOperationConfigProcessor", 1, "ExternalDirOperationConfig fromJson content: " + str);
        try {
            aVar = new a();
            JSONObject jSONObject = new JSONObject(str);
            aVar.f363253b = jSONObject.optBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, false);
            aVar.f363254c = jSONObject.optBoolean("open_file_switch", false);
            aVar.f363255d = jSONObject.optInt("sampling", 100);
            JSONArray optJSONArray = jSONObject.optJSONArray("exclude_path");
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                aVar.f363252a.add(f363247f + ((String) optJSONArray.get(i3)));
            }
            aVar.f363256e = jSONObject.optBoolean("new_report", false);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("ExternalDirOperationConfigProcessor", 2, e16, new Object[0]);
            }
            aVar = null;
        }
        if (aVar == null) {
            aVar = b();
        }
        if (QLog.isColorLevel()) {
            QLog.d("ExternalDirOperationConfigProcessor", 2, aVar);
        }
        return aVar;
    }

    public static a b() {
        return new a();
    }

    public static void c(Context context, boolean z16) {
        context.getSharedPreferences("dt_sdk_start", 4).edit().putBoolean("sp_key_hook_switch", z16).apply();
        f363248g = Boolean.valueOf(z16);
    }

    public static void d(boolean z16) {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeBool("sp_key_new_report", z16).commitAsync();
        f363251j = Boolean.valueOf(z16);
    }

    public static void e(Context context, boolean z16) {
        context.getSharedPreferences("dt_sdk_start", 4).edit().putBoolean("sp_key_open_file_hook_switch", z16).apply();
        f363249h = Boolean.valueOf(z16);
    }

    public static void f(Context context, int i3) {
        context.getSharedPreferences("dt_sdk_start", 4).edit().putInt("sp_key_sampling", i3).apply();
        f363250i = Integer.valueOf(i3);
    }

    @NonNull
    public String toString() {
        StringBuilder sb5 = new StringBuilder("ExternalDirOperationConfig={");
        sb5.append(" hookSwitch:");
        sb5.append(this.f363253b);
        sb5.append(" openFileHookSwitch:");
        sb5.append(this.f363254c);
        sb5.append(" sampling:");
        sb5.append(this.f363255d);
        sb5.append(" newReport:");
        sb5.append(this.f363256e);
        sb5.append(" excludePaths:");
        Iterator<String> it = this.f363252a.iterator();
        while (it.hasNext()) {
            sb5.append(it.next());
            sb5.append(" ");
        }
        sb5.append("}");
        return sb5.toString();
    }
}
