package com.tencent.avcore.jni.data;

import android.os.Build;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;

/* compiled from: P */
/* loaded from: classes3.dex */
public class NtrtcTerminalInfo {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "NtrtcTerminalInfo";
    public NtrtcChipInfo chip;
    public NtrtcHardwareInfo hardware;

    /* renamed from: os, reason: collision with root package name */
    public NtrtcOsInfo f77481os;
    public NtrtcScreenInfo screen;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class NtrtcChipInfo {
        static IPatchRedirector $redirector_;
        public int chip;
        public int cpuFreq;
        public String cpuName;
        public String hardwareChipName;
        public int numOfCore;

        public NtrtcChipInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class NtrtcHardwareInfo {
        static IPatchRedirector $redirector_;
        public String deviceFirmware;
        public String deviceName;
        public String deviceTypeStr;
        public String fingerprint;
        public String manufacture;
        public String product;
        public int terminalType;

        public NtrtcHardwareInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class NtrtcOsInfo {
        static IPatchRedirector $redirector_;
        public String osName;
        public int osType;
        public String osVersion;
        public String platformOsVersionStr;
        public String romInfo;

        public NtrtcOsInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class NtrtcScreenInfo {
        static IPatchRedirector $redirector_;
        public int screenHeight;
        public int screenWidth;

        public NtrtcScreenInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public NtrtcTerminalInfo(AVCoreSystemInfo aVCoreSystemInfo, boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aVCoreSystemInfo, Boolean.valueOf(z16));
            return;
        }
        this.hardware = new NtrtcHardwareInfo();
        this.chip = new NtrtcChipInfo();
        this.screen = new NtrtcScreenInfo();
        this.f77481os = new NtrtcOsInfo();
        this.hardware.deviceName = DeviceInfoMonitor.getModel();
        NtrtcHardwareInfo ntrtcHardwareInfo = this.hardware;
        if (z16) {
            i3 = 8;
        } else {
            i3 = 4;
        }
        ntrtcHardwareInfo.terminalType = i3;
        ntrtcHardwareInfo.deviceTypeStr = DeviceInfoMonitor.getModel();
        this.hardware.deviceFirmware = DeviceInfoMonitor.getModel();
        NtrtcHardwareInfo ntrtcHardwareInfo2 = this.hardware;
        ntrtcHardwareInfo2.manufacture = Build.MANUFACTURER;
        ntrtcHardwareInfo2.product = Build.PRODUCT;
        ntrtcHardwareInfo2.fingerprint = Build.FINGERPRINT;
        this.chip.cpuName = AVCoreSystemInfo.getCPUName();
        this.chip.hardwareChipName = Build.HARDWARE + "_" + AVCoreSystemInfo.getCpuModel();
        this.chip.chip = AVCoreSystemInfo.getCpuArchitecture();
        NtrtcChipInfo ntrtcChipInfo = this.chip;
        ntrtcChipInfo.cpuFreq = (int) AVCoreSystemInfo.mMaxCpuFreq;
        ntrtcChipInfo.numOfCore = AVCoreSystemInfo.mCoreNumber;
        NtrtcScreenInfo ntrtcScreenInfo = this.screen;
        ntrtcScreenInfo.screenWidth = aVCoreSystemInfo.mScreenWidth;
        ntrtcScreenInfo.screenHeight = aVCoreSystemInfo.mScreenHeight;
        NtrtcOsInfo ntrtcOsInfo = this.f77481os;
        String str = Build.VERSION.RELEASE;
        ntrtcOsInfo.osName = str;
        ntrtcOsInfo.osType = aVCoreSystemInfo.getOsType();
        NtrtcOsInfo ntrtcOsInfo2 = this.f77481os;
        ntrtcOsInfo2.osVersion = str;
        ntrtcOsInfo2.platformOsVersionStr = String.valueOf(Build.VERSION.SDK_INT);
        this.f77481os.romInfo = Build.VERSION.INCREMENTAL;
    }
}
