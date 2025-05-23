package com.tencent.mobileqq.ar;

import android.app.ActivityManager;
import android.content.SharedPreferences;
import android.content.pm.ConfigurationInfo;
import android.text.TextUtils;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.mobileqq.ar.model.ArDefaultSetting;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ARDeviceController {

    /* renamed from: o, reason: collision with root package name */
    private static ARDeviceController f196771o = new ARDeviceController();

    /* renamed from: a, reason: collision with root package name */
    private ArEffectConfig f196772a;

    /* renamed from: c, reason: collision with root package name */
    private String f196774c;

    /* renamed from: k, reason: collision with root package name */
    private int f196782k;

    /* renamed from: l, reason: collision with root package name */
    private int f196783l;

    /* renamed from: n, reason: collision with root package name */
    private boolean f196785n;

    /* renamed from: b, reason: collision with root package name */
    private String f196773b = a(DeviceInfoMonitor.getModel());

    /* renamed from: d, reason: collision with root package name */
    private int f196775d = 5;

    /* renamed from: e, reason: collision with root package name */
    private int f196776e = 1;

    /* renamed from: f, reason: collision with root package name */
    private boolean f196777f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f196778g = true;

    /* renamed from: h, reason: collision with root package name */
    private boolean f196779h = true;

    /* renamed from: i, reason: collision with root package name */
    private boolean f196780i = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean f196781j = true;

    /* renamed from: m, reason: collision with root package name */
    private boolean f196784m = true;

    ARDeviceController() {
        boolean z16 = true;
        this.f196783l = 0;
        this.f196785n = false;
        SharedPreferences sharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 4);
        String string = sharedPreferences.getString("gpu_renderer", null);
        this.f196774c = string;
        if (!TextUtils.isEmpty(string)) {
            this.f196774c = a(this.f196774c);
        }
        this.f196782k = sharedPreferences.getInt("ar_incompatible_reason", 0);
        this.f196783l = sharedPreferences.getInt("ar_load_so_crash_time", 0);
        if (!AppSetting.n().equals(sharedPreferences.getString("ar_load_so_crash_version", ""))) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt("ar_load_so_crash_time", 0);
            ea.i(edit);
            this.f196783l = 0;
        }
        if (sharedPreferences.getInt("ar_native_so_version", 0) != sharedPreferences.getInt("ar_native_so_crash_version", 0)) {
            sharedPreferences.edit().putInt("ar_load_so_crash_time", 0).commit();
            this.f196783l = 0;
        }
        try {
            ConfigurationInfo deviceConfigurationInfo = ((ActivityManager) BaseApplicationImpl.getApplication().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getDeviceConfigurationInfo();
            if (deviceConfigurationInfo != null) {
                if (deviceConfigurationInfo.reqGlEsVersion < 131072) {
                    z16 = false;
                }
                this.f196785n = z16;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String lowerCase = str.toLowerCase();
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < lowerCase.length(); i3++) {
            char charAt = lowerCase.charAt(i3);
            if ((charAt >= '0' && charAt <= '9') || (charAt >= 'a' && charAt <= 'z')) {
                sb5.append(charAt);
            }
        }
        return sb5.toString();
    }

    public static ARDeviceController b() {
        return f196771o;
    }

    private void c() {
        boolean z16;
        int i3;
        int i16;
        SharedPreferences sharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0);
        ArEffectConfig arEffectConfig = this.f196772a;
        if (arEffectConfig != null) {
            this.f196775d = -1;
            this.f196776e = -1;
            Iterator<String> it = arEffectConfig.f197712e.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (a(it.next()).equals(this.f196773b)) {
                        this.f196775d = 5;
                        this.f196776e = 1;
                        z16 = true;
                        break;
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
            if (!z16) {
                Iterator<String> it5 = this.f196772a.f197714h.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    }
                    if (a(it5.next()).equals(this.f196773b)) {
                        this.f196777f = true;
                        z16 = true;
                        break;
                    }
                }
                if (!z16) {
                    this.f196777f = false;
                }
            }
            if (!z16) {
                Iterator<ArDefaultSetting> it6 = this.f196772a.I.iterator();
                while (true) {
                    if (!it6.hasNext()) {
                        break;
                    }
                    ArDefaultSetting next = it6.next();
                    if (next.f198406e == 0 && a(next.f198405d).equals(this.f196773b)) {
                        this.f196775d = next.f198408h;
                        this.f196776e = next.f198407f;
                        z16 = true;
                        break;
                    }
                }
            }
            if (!z16) {
                Iterator<String> it7 = this.f196772a.f197713f.iterator();
                while (true) {
                    if (!it7.hasNext()) {
                        break;
                    }
                    if (a(it7.next()).equals(this.f196774c)) {
                        this.f196775d = 5;
                        this.f196776e = 1;
                        z16 = true;
                        break;
                    }
                }
            }
            if (!z16) {
                Iterator<String> it8 = this.f196772a.f197715i.iterator();
                while (true) {
                    if (!it8.hasNext()) {
                        break;
                    }
                    if (a(it8.next()).equals(this.f196774c)) {
                        this.f196777f = true;
                        z16 = true;
                        break;
                    }
                }
                if (!z16) {
                    this.f196777f = false;
                }
            }
            if (!z16) {
                Iterator<ArDefaultSetting> it9 = this.f196772a.I.iterator();
                while (true) {
                    if (!it9.hasNext()) {
                        break;
                    }
                    ArDefaultSetting next2 = it9.next();
                    if (next2.f198406e == 1 && a(next2.f198405d).equals(this.f196774c)) {
                        this.f196775d = next2.f198408h;
                        this.f196776e = next2.f198407f;
                        z16 = true;
                        break;
                    }
                }
            }
        } else {
            z16 = false;
        }
        if (z16 && (i3 = this.f196775d) >= 1 && i3 <= 5 && (i16 = this.f196776e) >= 0 && i16 <= 1) {
            this.f196778g = false;
            this.f196779h = false;
            this.f196780i = true;
            return;
        }
        int i17 = sharedPreferences.getInt("ar_adjust_track_quality", -1);
        this.f196775d = i17;
        if (i17 >= 1 && i17 <= 5) {
            this.f196778g = false;
        } else {
            this.f196778g = true;
            this.f196775d = 5;
        }
        int i18 = sharedPreferences.getInt("ar_adjust_render_quality", -1);
        this.f196776e = i18;
        if (i18 >= 0 && i18 <= 1) {
            this.f196779h = false;
        } else {
            this.f196776e = 1;
            this.f196779h = true;
        }
        this.f196780i = true;
    }

    private void f(final boolean z16, final int i3) {
        if (this.f196781j || this.f196782k != i3) {
            this.f196781j = false;
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ARDeviceController.1
                @Override // java.lang.Runnable
                public void run() {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("param_FailCode", String.valueOf(i3));
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "AREnable", z16, 0L, 0L, hashMap, null);
                    SharedPreferences.Editor edit = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0).edit();
                    edit.putInt("ar_incompatible_reason", i3);
                    ea.i(edit);
                }
            }, 5, null, true);
        }
        this.f196782k = i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x008b A[Catch: all -> 0x00c8, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0008, B:7:0x000e, B:8:0x0017, B:12:0x001f, B:14:0x0024, B:15:0x005b, B:19:0x0082, B:21:0x008b, B:23:0x00ae, B:26:0x0064, B:29:0x006c, B:32:0x0077), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ae A[Catch: all -> 0x00c8, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0008, B:7:0x000e, B:8:0x0017, B:12:0x001f, B:14:0x0024, B:15:0x005b, B:19:0x0082, B:21:0x008b, B:23:0x00ae, B:26:0x0064, B:29:0x006c, B:32:0x0077), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean d() {
        boolean z16;
        int i3;
        int i16 = this.f196783l;
        if (i16 >= 5) {
            if (QLog.isColorLevel()) {
                QLog.d("ARDeviceController", 2, "isAREnable enable= false,failCode= 870888");
            }
            f(false, 870888);
            return false;
        }
        boolean z17 = true;
        if (this.f196784m) {
            this.f196784m = false;
            this.f196783l = i16 + 1;
            SharedPreferences sharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt("ar_load_so_crash_time", this.f196783l);
            edit.putString("ar_load_so_crash_version", AppSetting.n());
            edit.putInt("ar_native_so_crash_version", sharedPreferences.getInt("ar_native_so_version", 0));
            ea.i(edit);
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.f196777f) {
            i3 = 870882;
        } else if (!this.f196785n) {
            i3 = 870883;
        } else if (AVCoreSystemInfo.getCpuArchitecture() < 3) {
            i3 = 870884;
        } else if (!com.tencent.mobileqq.olympic.utils.a.c()) {
            i3 = 870886;
        } else {
            i3 = 0;
            f(z17, i3);
            if (QLog.isColorLevel()) {
                QLog.d("ARDeviceController", 2, "isAREnable enable= " + z17 + ",failCode= " + i3);
            }
            if (z16) {
                SharedPreferences.Editor edit2 = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0).edit();
                edit2.putInt("ar_load_so_crash_time", 0);
                ea.i(edit2);
                this.f196783l = 0;
            }
            return z17;
        }
        z17 = false;
        f(z17, i3);
        if (QLog.isColorLevel()) {
        }
        if (z16) {
        }
        return z17;
    }

    public boolean e() {
        int i3;
        boolean z16 = false;
        if (this.f196783l >= 5) {
            i3 = 870888;
        } else if (this.f196777f) {
            i3 = 870882;
        } else if (!this.f196785n) {
            i3 = 870883;
        } else if (AVCoreSystemInfo.getCpuArchitecture() < 3) {
            i3 = 870884;
        } else if (!com.tencent.mobileqq.olympic.utils.a.c()) {
            i3 = 870886;
        } else {
            z16 = true;
            i3 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ARDeviceController", 2, "isSupportAr enable= " + z16 + ",errorCode= " + i3);
        }
        return z16;
    }

    public void g(ArEffectConfig arEffectConfig) {
        this.f196772a = arEffectConfig;
        if (!TextUtils.isEmpty(this.f196774c)) {
            c();
        }
    }

    public void h(String str) {
        if (!TextUtils.isEmpty(this.f196774c)) {
            return;
        }
        this.f196774c = a(str);
        SharedPreferences.Editor edit = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0).edit();
        edit.putString("gpu_renderer", str);
        ea.i(edit);
        h(str);
        if (this.f196772a != null) {
            c();
        }
    }
}
