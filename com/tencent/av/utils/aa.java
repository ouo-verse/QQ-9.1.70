package com.tencent.av.utils;

import android.app.ActivityManager;
import android.content.pm.ApplicationInfo;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.av.so.ResMgr;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.avcore.jni.data.NtrtcAppParam;
import com.tencent.avcore.jni.data.NtrtcAudioParam;
import com.tencent.avcore.jni.data.NtrtcCommonParam;
import com.tencent.avcore.jni.data.NtrtcNetworkParam;
import com.tencent.avcore.jni.data.NtrtcVideoParam;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes3.dex */
public class aa {

    /* renamed from: a, reason: collision with root package name */
    boolean f76925a;

    public aa(boolean z16) {
        this.f76925a = z16;
    }

    public static int a() {
        if (AppNetConnInfo.isWifiConn()) {
            return 1;
        }
        if (AppNetConnInfo.isMobileConn()) {
            int mobileInfo = AppNetConnInfo.getMobileInfo();
            if (mobileInfo == 1) {
                return 3;
            }
            if (mobileInfo != 2) {
                if (mobileInfo != 3) {
                    if (mobileInfo != 4) {
                        return 100;
                    }
                    return 14;
                }
                return 11;
            }
            return 9;
        }
        return 0;
    }

    public NtrtcAppParam b(String str) {
        NtrtcAppParam ntrtcAppParam = new NtrtcAppParam();
        ntrtcAppParam.appId = String.valueOf(AppSetting.f());
        ntrtcAppParam.productId = str;
        ntrtcAppParam.productVersion = AppSetting.f99551k;
        ntrtcAppParam.productAppId = 0;
        return ntrtcAppParam;
    }

    public NtrtcAudioParam c() {
        NtrtcAudioParam ntrtcAudioParam = new NtrtcAudioParam();
        ntrtcAudioParam.configFromQqmc = ResMgr.o();
        ntrtcAudioParam.aiDenoiseModelDir = ResMgr.h();
        ntrtcAudioParam.traeSoFullFilename = AVSoUtils.k();
        ntrtcAudioParam.isUseOpenSLESInterface = af.J();
        ntrtcAudioParam.openSlesUnintPlayWaitTimeLenMs = af.q();
        if (!this.f76925a) {
            ntrtcAudioParam.penguinsCodecSoDir = ResMgr.j();
            ntrtcAudioParam.penguinsCodecModelDir = ResMgr.i();
        }
        return ntrtcAudioParam;
    }

    public NtrtcCommonParam d() {
        String str;
        String str2;
        NtrtcCommonParam ntrtcCommonParam = new NtrtcCommonParam();
        ntrtcCommonParam.configFromQqmc = ResMgr.p();
        ntrtcCommonParam.flowCtrlConfigDir = bu.a.a();
        ntrtcCommonParam.logDir = com.tencent.av.b.b();
        int myPid = Process.myPid();
        Iterator<ActivityManager.RunningAppProcessInfo> it = SystemMethodProxy.getRunningAppProcesses((ActivityManager) BaseApplication.getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).iterator();
        while (true) {
            str = "";
            if (!it.hasNext()) {
                str2 = "";
                break;
            }
            ActivityManager.RunningAppProcessInfo next = it.next();
            if (next.pid == myPid) {
                str2 = next.processName;
                break;
            }
        }
        int lastIndexOf = str2.lastIndexOf(58);
        if (lastIndexOf > 0 && lastIndexOf < str2.length() - 1) {
            str = str2.substring(lastIndexOf + 1);
        }
        String str3 = "com.tencent.mobileqq";
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, "video")) {
            str3 = "com.tencent.mobileqq_" + str;
        }
        ntrtcCommonParam.logFilePrefix = str3;
        ntrtcCommonParam.avDebugConfig = bu.a.b();
        ntrtcCommonParam.isPadForMultiDeviceLogin = AppSetting.p(BaseApplication.getContext());
        ApplicationInfo applicationInfo = BaseApplication.getContext().getApplicationInfo();
        ntrtcCommonParam.dataDir = applicationInfo.dataDir;
        ntrtcCommonParam.libDir = applicationInfo.nativeLibraryDir;
        return ntrtcCommonParam;
    }

    public NtrtcNetworkParam e(int i3) {
        NtrtcNetworkParam ntrtcNetworkParam = new NtrtcNetworkParam();
        ntrtcNetworkParam.networkType = a();
        ntrtcNetworkParam.deviceImsi = "," + i3;
        return ntrtcNetworkParam;
    }

    public NtrtcVideoParam f() {
        com.tencent.av.core.b bVar = new com.tencent.av.core.b(BaseApplication.getContext());
        NtrtcVideoParam ntrtcVideoParam = new NtrtcVideoParam();
        ntrtcVideoParam.configFromQqmc = ResMgr.A();
        ntrtcVideoParam.isUseServerVideoConfig = af.P();
        ntrtcVideoParam.screenShareEncLevel = bVar.getScreenShareEncLevel();
        ntrtcVideoParam.screenShareDecLevel = bVar.getScreenShareDecLevel();
        if (AVCoreSystemInfo.getCpuArchitecture() > 2) {
            ntrtcVideoParam.sharpVideo = 1;
        } else {
            ntrtcVideoParam.sharpVideo = 2;
        }
        ntrtcVideoParam.hwCodecAbility = bVar.getAndroidCodecInfo();
        AVSoUtils.M();
        ntrtcVideoParam.hevcEncSoDir = AVSoUtils.r();
        ntrtcVideoParam.hevcDecSoDir = AVSoUtils.p();
        ntrtcVideoParam.hardwareDetectSoDir = AVSoUtils.o();
        ntrtcVideoParam.videoSrSoDir = AVSoUtils.v();
        ntrtcVideoParam.r265EncSoDir = AVSoUtils.w();
        return ntrtcVideoParam;
    }
}
