package com.tencent.gathererga.core.internal.provider.impl;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemProperties;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.gathererga.core.HardwareInfoProvider;
import com.tencent.gathererga.core.R;
import com.tencent.gathererga.core.f;
import com.tencent.gathererga.core.internal.provider.InfoID;
import com.tencent.gathererga.core.internal.util.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;

/* compiled from: P */
/* loaded from: classes6.dex */
public class d implements HardwareInfoProvider {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Context f108251a;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f108251a = null;
        }
    }

    private static String h(String str) {
        String str2;
        String str3 = "";
        if (TextUtils.isEmpty(str)) {
            com.tencent.gathererga.core.internal.util.d.b("getHarmonyInfoFromSystemProperties propertyName is empty");
            return "";
        }
        try {
            str2 = (String) SystemProperties.class.getDeclaredMethod("get", String.class).invoke(SystemProperties.class, str);
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            com.tencent.gathererga.core.internal.util.d.a("getHarmonyInfoFromSystemProperties value: " + str2);
            return str2;
        } catch (Throwable th6) {
            th = th6;
            str3 = str2;
            com.tencent.gathererga.core.internal.util.d.b("getHarmonyInfoFromSystemProperties error: " + th.getMessage());
            return str3;
        }
    }

    private f i(int i3) {
        return new com.tencent.gathererga.core.internal.provider.c(-777L, "");
    }

    @Override // com.tencent.gathererga.core.HardwareInfoProvider
    @InfoID(id = 115)
    public f getAndroidId(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (f) iPatchRedirector.redirect((short) 21, (Object) this, (Object) eVar);
        }
        return new com.tencent.gathererga.core.internal.provider.c(-777L, "");
    }

    @Override // com.tencent.gathererga.core.HardwareInfoProvider
    @InfoID(id = 131)
    public f getBoard(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (f) iPatchRedirector.redirect((short) 6, (Object) this, (Object) eVar);
        }
        return new com.tencent.gathererga.core.internal.provider.c(0L, Build.BOARD);
    }

    @Override // com.tencent.gathererga.core.HardwareInfoProvider
    @InfoID(id = 118)
    public f getBrand(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (f) iPatchRedirector.redirect((short) 5, (Object) this, (Object) eVar);
        }
        return new com.tencent.gathererga.core.internal.provider.c(0L, Build.BRAND);
    }

    @Override // com.tencent.gathererga.core.HardwareInfoProvider
    @InfoID(id = 123)
    public f getDevice(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (f) iPatchRedirector.redirect((short) 7, (Object) this, (Object) eVar);
        }
        return new com.tencent.gathererga.core.internal.provider.c(0L, Build.DEVICE);
    }

    @Override // com.tencent.gathererga.core.HardwareInfoProvider
    @InfoID(id = 119)
    public f getDeviceHeightAndWidth(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (f) iPatchRedirector.redirect((short) 25, (Object) this, (Object) eVar);
        }
        Display defaultDisplay = ((WindowManager) this.f108251a.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (com.tencent.gathererga.core.internal.util.b.b() >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        } else {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return new com.tencent.gathererga.core.internal.provider.c(0L, new Pair(Integer.valueOf(displayMetrics.heightPixels), Integer.valueOf(displayMetrics.widthPixels)));
    }

    @Override // com.tencent.gathererga.core.HardwareInfoProvider
    @InfoID(id = 110)
    public f getDeviceId(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (f) iPatchRedirector.redirect((short) 18, (Object) this, (Object) eVar);
        }
        return new com.tencent.gathererga.core.internal.provider.c(-777L, "");
    }

    @Override // com.tencent.gathererga.core.HardwareInfoProvider
    @InfoID(id = 111)
    public f getDeviceId0(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (f) iPatchRedirector.redirect((short) 19, (Object) this, (Object) eVar);
        }
        return new com.tencent.gathererga.core.internal.provider.c(-777L, "");
    }

    @Override // com.tencent.gathererga.core.HardwareInfoProvider
    @InfoID(id = 112)
    public f getDeviceId1(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (f) iPatchRedirector.redirect((short) 20, (Object) this, (Object) eVar);
        }
        return new com.tencent.gathererga.core.internal.provider.c(-777L, "");
    }

    @Override // com.tencent.gathererga.core.HardwareInfoProvider
    @InfoID(id = 122)
    public f getDpi(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (f) iPatchRedirector.redirect((short) 24, (Object) this, (Object) eVar);
        }
        return new com.tencent.gathererga.core.internal.provider.c(0L, Float.valueOf(this.f108251a.getResources().getDisplayMetrics().density));
    }

    @Override // com.tencent.gathererga.core.HardwareInfoProvider
    @InfoID(id = 129)
    public f getFileNode(com.tencent.gathererga.core.e eVar, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (f) iPatchRedirector.redirect((short) 31, (Object) this, (Object) eVar, (Object) str);
        }
        return new com.tencent.gathererga.core.internal.provider.c(0L, com.tencent.gathererga.core.internal.util.f.a(str));
    }

    @Override // com.tencent.gathererga.core.HardwareInfoProvider
    @InfoID(id = 124)
    public f getHarmonyOsVersion(com.tencent.gathererga.core.e eVar) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (f) iPatchRedirector.redirect((short) 26, (Object) this, (Object) eVar);
        }
        String h16 = h("hw_sc.build.platform.version");
        if (TextUtils.isEmpty(h16)) {
            j3 = -100;
        } else {
            j3 = 0;
        }
        return new com.tencent.gathererga.core.internal.provider.c(j3, h16);
    }

    @Override // com.tencent.gathererga.core.HardwareInfoProvider
    @InfoID(id = 125)
    public f getHarmonyPureMode(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (f) iPatchRedirector.redirect((short) 27, (Object) this, (Object) eVar);
        }
        int i3 = -1;
        try {
            i3 = Settings.Secure.getInt(this.f108251a.getContentResolver(), "pure_mode_state", -1);
            return new com.tencent.gathererga.core.internal.provider.c(0L, Integer.valueOf(i3));
        } catch (Throwable th5) {
            com.tencent.gathererga.core.internal.util.d.b("getHarmonyPureMode error: " + th5.getMessage());
            return new com.tencent.gathererga.core.internal.provider.c(-100L, Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.gathererga.core.HardwareInfoProvider
    @InfoID(id = 101)
    public f getImei(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (f) iPatchRedirector.redirect((short) 9, (Object) this, (Object) eVar);
        }
        return i(-1);
    }

    @Override // com.tencent.gathererga.core.HardwareInfoProvider
    @InfoID(id = 102)
    public f getImei0(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (f) iPatchRedirector.redirect((short) 10, (Object) this, (Object) eVar);
        }
        return i(0);
    }

    @Override // com.tencent.gathererga.core.HardwareInfoProvider
    @InfoID(id = 103)
    public f getImei1(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (f) iPatchRedirector.redirect((short) 11, (Object) this, (Object) eVar);
        }
        return i(1);
    }

    @Override // com.tencent.gathererga.core.HardwareInfoProvider
    @InfoID(id = 104)
    public f getImsi(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (f) iPatchRedirector.redirect((short) 12, (Object) this, (Object) eVar);
        }
        return new com.tencent.gathererga.core.internal.provider.c(-777L, "");
    }

    @Override // com.tencent.gathererga.core.HardwareInfoProvider
    @InfoID(id = 105)
    public f getImsi0(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (f) iPatchRedirector.redirect((short) 13, (Object) this, (Object) eVar);
        }
        return new com.tencent.gathererga.core.internal.provider.c(-777L, "");
    }

    @Override // com.tencent.gathererga.core.HardwareInfoProvider
    @InfoID(id = 106)
    public f getImsi1(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (f) iPatchRedirector.redirect((short) 14, (Object) this, (Object) eVar);
        }
        return new com.tencent.gathererga.core.internal.provider.c(-777L, "");
    }

    @Override // com.tencent.gathererga.core.HardwareInfoProvider
    @InfoID(id = 126)
    public f getIsHarmonyOs(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (f) iPatchRedirector.redirect((short) 28, (Object) this, (Object) eVar);
        }
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return new com.tencent.gathererga.core.internal.provider.c(0L, Boolean.valueOf(HardwareInfoProvider.HARMONY_OS.equals(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]))));
        } catch (Throwable th5) {
            com.tencent.gathererga.core.internal.util.d.b("isHarmonyOs error: " + th5.getMessage());
            return new com.tencent.gathererga.core.internal.provider.c(-100L, Boolean.FALSE);
        }
    }

    @Override // com.tencent.gathererga.core.HardwareInfoProvider
    @InfoID(id = 116)
    public f getManufacturer(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (f) iPatchRedirector.redirect((short) 3, (Object) this, (Object) eVar);
        }
        return new com.tencent.gathererga.core.internal.provider.c(0L, Build.MANUFACTURER);
    }

    @Override // com.tencent.gathererga.core.HardwareInfoProvider
    @InfoID(id = 107)
    public f getMeid(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (f) iPatchRedirector.redirect((short) 15, (Object) this, (Object) eVar);
        }
        return new com.tencent.gathererga.core.internal.provider.c(-777L, "");
    }

    @Override // com.tencent.gathererga.core.HardwareInfoProvider
    @InfoID(id = 108)
    public f getMeid0(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (f) iPatchRedirector.redirect((short) 16, (Object) this, (Object) eVar);
        }
        return new com.tencent.gathererga.core.internal.provider.c(-777L, "");
    }

    @Override // com.tencent.gathererga.core.HardwareInfoProvider
    @InfoID(id = 109)
    public f getMeid1(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (f) iPatchRedirector.redirect((short) 17, (Object) this, (Object) eVar);
        }
        return new com.tencent.gathererga.core.internal.provider.c(-777L, "");
    }

    @Override // com.tencent.gathererga.core.HardwareInfoProvider
    @InfoID(id = 117)
    public f getModel(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (f) iPatchRedirector.redirect((short) 4, (Object) this, (Object) eVar);
        }
        return new com.tencent.gathererga.core.internal.provider.c(0L, DeviceInfoMonitor.getModel());
    }

    @Override // com.tencent.gathererga.core.HardwareInfoProvider
    @InfoID(id = 127)
    public f getOpenHarmonyVersion(com.tencent.gathererga.core.e eVar) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (f) iPatchRedirector.redirect((short) 29, (Object) this, (Object) eVar);
        }
        String h16 = h("hw_sc.build.os.version");
        if (TextUtils.isEmpty(h16)) {
            j3 = -100;
        } else {
            j3 = 0;
        }
        return new com.tencent.gathererga.core.internal.provider.c(j3, h16);
    }

    @Override // com.tencent.gathererga.core.HardwareInfoProvider
    @InfoID(id = 121)
    public f getRamSize(com.tencent.gathererga.core.e eVar) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (f) iPatchRedirector.redirect((short) 23, (Object) this, (Object) eVar);
        }
        Context context = this.f108251a;
        if (context != null) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            if (activityManager != null) {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                return new com.tencent.gathererga.core.internal.provider.c(0, Long.valueOf(memoryInfo.totalMem));
            }
            i3 = -104;
        } else {
            i3 = -103;
        }
        return new com.tencent.gathererga.core.internal.provider.c(i3, -1);
    }

    @Override // com.tencent.gathererga.core.HardwareInfoProvider
    @InfoID(id = 120)
    public f getRomSize(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (f) iPatchRedirector.redirect((short) 22, (Object) this, (Object) eVar);
        }
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        if (com.tencent.gathererga.core.internal.util.b.b() >= 18) {
            return new com.tencent.gathererga.core.internal.provider.c(0L, Long.valueOf(statFs.getBlockSizeLong() * statFs.getBlockCountLong()));
        }
        return new com.tencent.gathererga.core.internal.provider.c(0L, Long.valueOf(statFs.getBlockSize() * statFs.getBlockCount()));
    }

    @Override // com.tencent.gathererga.core.HardwareInfoProvider
    @InfoID(id = 128)
    public f getScreenWidthBucket(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (f) iPatchRedirector.redirect((short) 30, (Object) this, (Object) eVar);
        }
        int a16 = k.a();
        if (a16 == -1) {
            try {
                a16 = this.f108251a.getResources().getInteger(R.integer.min_screen_width_bucket);
            } catch (Exception e16) {
                com.tencent.gathererga.core.internal.util.d.b("getScreenWidthBucket error: " + e16.getMessage());
                a16 = 1;
            }
        }
        return new com.tencent.gathererga.core.internal.provider.c(0L, Integer.valueOf(a16));
    }

    @Override // com.tencent.gathererga.core.HardwareInfoProvider
    @InfoID(id = 132)
    public f getTime(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (f) iPatchRedirector.redirect((short) 8, (Object) this, (Object) eVar);
        }
        return new com.tencent.gathererga.core.internal.provider.c(0L, Long.valueOf(Build.TIME));
    }

    @Override // com.tencent.gathererga.core.HardwareInfoProvider, com.tencent.gathererga.core.internal.c
    public void onInit(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        } else {
            this.f108251a = context;
        }
    }
}
