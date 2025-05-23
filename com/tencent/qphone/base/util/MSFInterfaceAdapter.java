package com.tencent.qphone.base.util;

import android.content.Context;
import android.os.HandlerThread;
import com.tencent.mobileqq.msf.core.startup.MSFStartupListener;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MSFInterfaceAdapter {
    public void beaconReport(String str, String str2, String str3, boolean z16, Map<String, String> map, boolean z17) {
    }

    public boolean clearConfigData(int i3, String str, String str2) {
        return false;
    }

    public String getAppReportVersionName() {
        return "";
    }

    public String getAppid() {
        return "";
    }

    public String getBeaconAppKey() {
        return "";
    }

    public String getChannel() {
        return "";
    }

    public String getClientVersion() {
        return "";
    }

    public String getQUA() {
        return "";
    }

    public String getWTUinStoreFileDirLastResort() {
        return "";
    }

    public boolean isDebugVersion() {
        return false;
    }

    public boolean isGrayVersion() {
        return false;
    }

    public boolean isPublicVersion() {
        return false;
    }

    public boolean isReleaseVersion() {
        return false;
    }

    public boolean isSwitchToTestEnv() {
        return false;
    }

    public boolean isVIPAccount(String str) {
        return false;
    }

    public boolean useNtWtLogin() {
        return false;
    }

    public void beaconReport(String str, String str2, boolean z16, Map<String, String> map, boolean z17) {
    }

    public void addHandlerThreadMonitor(int i3, HandlerThread handlerThread) {
    }

    public String handleTimUinStoreFile(String str, String str2) {
        return str;
    }

    public boolean isSwitchOn(String str, boolean z16) {
        return z16;
    }

    public void onServiceInit(Context context, MSFStartupListener mSFStartupListener) {
    }

    public void handleCatchException(Thread thread, Throwable th5, String str, byte[] bArr) {
    }
}
