package com.tencent.ilink.dev.interfaces;

import android.util.Log;
import com.tencent.ilink.dev.interfaces.ILinkDevInterface;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ILinkDevInterfaceService {
    private static final String TAG = "ILinkImInterfaceService";
    private static ILinkDevInterfaceService instance;
    public IILinkDevCallback iILinkCallback;
    private TimerTask task;
    private Timer timer;
    public static final int ACCOUNT_LOGGED_OUT = ILinkDevInterface.EnAccountState.ACCOUNT_LOGGED_OUT.toValue();
    public static final int ACCOUNT_LOGGING_IN = ILinkDevInterface.EnAccountState.ACCOUNT_LOGGING_IN.toValue();
    public static final int ACCOUNT_LOGGED_IN = ILinkDevInterface.EnAccountState.ACCOUNT_LOGGED_IN.toValue();
    public static final int ACCOUNT_UNREGISTERED = ILinkDevInterface.EnAccountState.ACCOUNT_UNREGISTERED.toValue();

    ILinkDevInterfaceService() {
    }

    public static ILinkDevInterfaceService getInstance() {
        if (instance == null) {
            instance = new ILinkDevInterfaceService();
        }
        return instance;
    }

    public void cancelInterfaceTimer() {
        this.timer.cancel();
    }

    public void cancelLogin() {
        ILinkDevInterface.cancelLogin();
    }

    public void changeDomain(int i3) {
        ILinkDevInterface.changeDomain(i3);
    }

    public int getAccountState() {
        return ILinkDevInterface.getAccountState();
    }

    public IILinkDevCallback getILinkCallback() {
        return this.iILinkCallback;
    }

    public String getIlinkId() {
        return ILinkDevInterface.getIlinkId();
    }

    public String getToken() {
        return ILinkDevInterface.getToken();
    }

    public long getUin() {
        return ILinkDevInterface.getUin();
    }

    public void init(byte[] bArr, int i3, String str, String str2, int i16, int i17, int i18, boolean z16) {
        ILinkDevInterface.init(bArr, i3, str, str2, i16, i17, i18, z16);
    }

    public void initLog(String str, int i3) {
        ILinkDevInterface.initLog(str, i3);
    }

    public void login(int i3) {
        Log.v(TAG, "login");
        this.timer = new BaseTimer();
        TimerTask timerTask = new TimerTask() { // from class: com.tencent.ilink.dev.interfaces.ILinkDevInterfaceService.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                IILinkDevCallback iLinkCallback = ILinkDevInterfaceService.this.getILinkCallback();
                if (iLinkCallback != null) {
                    iLinkCallback.onDevLoginComplete(303, 0);
                }
            }
        };
        this.task = timerTask;
        this.timer.schedule(timerTask, i3 * 1000);
        ILinkDevInterface.login();
    }

    public void logout(boolean z16) {
        ILinkDevInterface.logout(z16);
    }

    public int sendDevRequest(byte[] bArr) {
        return ILinkDevInterface.sendDevRequest(bArr);
    }

    public String sendIotMessage(String str, String str2, String str3, String str4) {
        return ILinkDevInterface.sendIotMessage(str, str2, str3, str4);
    }

    public void setILinkCallback(IILinkDevCallback iILinkDevCallback) {
        this.iILinkCallback = iILinkDevCallback;
    }

    public int startUploadLog(byte[] bArr) {
        return ILinkDevInterface.startUploadLog(bArr);
    }

    public void stopUploadLog() {
        ILinkDevInterface.stopUploadLog();
    }

    public void uninit() {
        ILinkDevInterface.uninit();
    }

    public void uninitLog() {
        ILinkDevInterface.uninitLog();
    }

    public void updateDeviceParams(byte[] bArr) {
        ILinkDevInterface.updateDeviceParams(bArr);
    }
}
