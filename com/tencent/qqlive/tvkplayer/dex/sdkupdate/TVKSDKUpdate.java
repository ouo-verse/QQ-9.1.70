package com.tencent.qqlive.tvkplayer.dex.sdkupdate;

import android.content.Context;
import com.tencent.qqlive.tvkplayer.api.TVKSDKMgr;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKSDKUpdate {
    private static final String TAG = "TVKPlayer[TVKSDKUpdate]";
    private static TVKSDKUpdate instance = null;
    private static boolean isInit = false;
    private boolean isThreadRunning = false;
    private Context mContext = null;
    private TVKSDKUpdateHelper sdkUpdateHelper = null;
    private Thread thread;

    TVKSDKUpdate() {
    }

    public static synchronized TVKSDKUpdate getInstance(Context context) {
        TVKSDKUpdate tVKSDKUpdate;
        synchronized (TVKSDKUpdate.class) {
            if (instance == null) {
                TVKSDKUpdate tVKSDKUpdate2 = new TVKSDKUpdate();
                instance = tVKSDKUpdate2;
                isInit = tVKSDKUpdate2.initSdkUpdate(context);
            }
            tVKSDKUpdate = instance;
        }
        return tVKSDKUpdate;
    }

    private boolean initSdkUpdate(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        TVKSDKUpdateHelper tVKSDKUpdateHelper = new TVKSDKUpdateHelper(applicationContext);
        this.sdkUpdateHelper = tVKSDKUpdateHelper;
        return tVKSDKUpdateHelper.helperInit();
    }

    public boolean check() {
        if (isInit && this.sdkUpdateHelper.isFileExisted()) {
            return true;
        }
        return false;
    }

    public String getJar() {
        if (isInit) {
            return this.sdkUpdateHelper.getJar();
        }
        return null;
    }

    public String getLibs() {
        if (isInit) {
            return this.sdkUpdateHelper.getLibs();
        }
        return null;
    }

    public void setOnSDKUpdateListener(TVKSDKMgr.PluginInstallListener pluginInstallListener) {
        this.sdkUpdateHelper.setOnSDKUpdateListener(pluginInstallListener);
    }

    public void start() {
        startWithForceAndSilent(false);
    }

    public synchronized void startWithForceAndSilent(boolean z16) {
        if (this.isThreadRunning) {
            return;
        }
        if (!isInit) {
            this.sdkUpdateHelper.onFinished();
        }
        if (z16 && !TVKUpdateUtils.isWifiConnected(this.mContext)) {
            TVKUpdateUtils.i(TAG, "start no wifi, cancel");
            this.sdkUpdateHelper.onFinished();
            return;
        }
        BaseThread baseThread = new BaseThread(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.dex.sdkupdate.TVKSDKUpdate.1
            @Override // java.lang.Runnable
            public void run() {
                TVKSDKLocalConfig updateInfoWithIsUpdate;
                try {
                    try {
                        updateInfoWithIsUpdate = TVKSDKUpdate.this.sdkUpdateHelper.getUpdateInfoWithIsUpdate(false);
                    } catch (Exception e16) {
                        TVKUpdateUtils.e(TVKSDKUpdate.TAG, "startWithForceAndSilent, exception: " + e16.toString());
                    }
                    if (updateInfoWithIsUpdate == null) {
                        return;
                    }
                    TVKSDKUpdate.this.sdkUpdateHelper.downloadWithIsUpdate(updateInfoWithIsUpdate, false);
                } finally {
                    TVKSDKUpdate.this.sdkUpdateHelper.onFinished();
                    TVKSDKUpdate.this.isThreadRunning = false;
                }
            }
        });
        this.thread = baseThread;
        this.isThreadRunning = true;
        baseThread.setName("TVK_start");
        this.thread.start();
    }

    public synchronized void startWithRemoteApp() {
        if (!this.isThreadRunning && isInit) {
            BaseThread baseThread = new BaseThread(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.dex.sdkupdate.TVKSDKUpdate.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        try {
                        } catch (Exception e16) {
                            TVKUpdateUtils.e(TVKSDKUpdate.TAG, "startWithForceAndSilent, exception: " + e16.toString());
                        }
                        if (!TVKUpdateUtils.isWifiConnected(TVKSDKUpdate.this.mContext)) {
                            TVKUpdateUtils.i(TVKSDKUpdate.TAG, "start no wifi, cancel");
                        } else {
                            TVKSDKLocalConfig updateInfoWithIsUpdate = TVKSDKUpdate.this.sdkUpdateHelper.getUpdateInfoWithIsUpdate(TVKSDKUpdate.this.sdkUpdateHelper.isFileExisted());
                            if (updateInfoWithIsUpdate != null) {
                                if (TVKSDKUpdate.this.sdkUpdateHelper.isSameVersion(updateInfoWithIsUpdate)) {
                                    TVKUpdateUtils.e(TVKSDKUpdate.TAG, "startWithRemoteApp, same: " + updateInfoWithIsUpdate.version);
                                } else if (TVKSDKUpdate.this.sdkUpdateHelper.isSameVersionForRemoteAndCopy(updateInfoWithIsUpdate)) {
                                    TVKUpdateUtils.i(TVKSDKUpdate.TAG, "startWithRemoteApp, use sdcard");
                                } else {
                                    TVKSDKUpdate.this.sdkUpdateHelper.downloadWithIsUpdate(updateInfoWithIsUpdate, false);
                                }
                            }
                        }
                    } finally {
                        TVKSDKUpdate.this.isThreadRunning = false;
                    }
                }
            });
            this.thread = baseThread;
            this.isThreadRunning = true;
            baseThread.setName("TVK_remote");
            this.thread.start();
        }
    }

    public synchronized void update() {
        if (!this.isThreadRunning && isInit) {
            BaseThread baseThread = new BaseThread(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.dex.sdkupdate.TVKSDKUpdate.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        try {
                        } catch (Exception e16) {
                            TVKUpdateUtils.e(TVKSDKUpdate.TAG, "update, exception: " + e16.toString());
                        }
                        if (!TVKUpdateUtils.isWifiConnected(TVKSDKUpdate.this.mContext)) {
                            TVKUpdateUtils.i(TVKSDKUpdate.TAG, "update no wifi, cancel");
                        } else {
                            if (TVKSDKUpdate.this.sdkUpdateHelper.isFileExisted()) {
                                TVKSDKLocalConfig updateInfoWithIsUpdate = TVKSDKUpdate.this.sdkUpdateHelper.getUpdateInfoWithIsUpdate(true);
                                if (updateInfoWithIsUpdate != null && !TVKSDKUpdate.this.sdkUpdateHelper.isSameVersion(updateInfoWithIsUpdate)) {
                                    if (TVKSDKUpdate.this.sdkUpdateHelper.isSameVersionForRemoteAndCopy(updateInfoWithIsUpdate)) {
                                        TVKUpdateUtils.i(TVKSDKUpdate.TAG, "update, use sdcard");
                                    } else {
                                        TVKSDKUpdate.this.sdkUpdateHelper.downloadWithIsUpdate(updateInfoWithIsUpdate, true);
                                    }
                                }
                            } else {
                                TVKUpdateUtils.e(TVKSDKUpdate.TAG, "update, file not existed ");
                            }
                        }
                    } finally {
                        TVKSDKUpdate.this.isThreadRunning = false;
                    }
                }
            });
            this.thread = baseThread;
            this.isThreadRunning = true;
            baseThread.setName("TVK_update");
            this.thread.start();
        }
    }
}
