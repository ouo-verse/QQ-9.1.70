package com.tencent.qqmini.sdk.launcher.dynamic;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniDynamicManager {
    private static final String TAG = "minisdk-MiniAppDexLoader_MiniDynamicManager";
    private static volatile MiniDynamicManager instance;
    private static volatile byte[] lock = new byte[0];
    private String mConfigStr;
    private String mCurrDownloadConfigStr;
    private MiniDexConfig mMiniDexConfig;

    private void doDownloadDex(final String str, final MiniDexConfig miniDexConfig) {
        if (miniDexConfig != null && !TextUtils.isEmpty(miniDexConfig.dexUrl)) {
            final String dexPath = miniDexConfig.getDexPath();
            if (TextUtils.isEmpty(dexPath)) {
                QMLog.e(TAG, "dex file path is null.");
                return;
            }
            this.mCurrDownloadConfigStr = str;
            QMLog.i(TAG, "begin to download dex: " + miniDexConfig.dexUrl);
            new BaseThread(new Runnable() { // from class: com.tencent.qqmini.sdk.launcher.dynamic.MiniDynamicManager.1
                @Override // java.lang.Runnable
                public void run() {
                    FileOutputStream fileOutputStream;
                    HttpURLConnection httpURLConnection;
                    int responseCode;
                    WnsConfigProxy wnsConfigProxy;
                    String str2;
                    InputStream inputStream = null;
                    String str3 = null;
                    try {
                        try {
                            httpURLConnection = (HttpURLConnection) new URL(miniDexConfig.dexUrl).openConnection();
                            httpURLConnection.setConnectTimeout(10000);
                            httpURLConnection.setRequestMethod("GET");
                            responseCode = httpURLConnection.getResponseCode();
                        } catch (Throwable th5) {
                            th = th5;
                            fileOutputStream = null;
                        }
                        if (responseCode != 200) {
                            QMLog.e(MiniDynamicManager.TAG, "download dex falied. status=" + responseCode);
                            return;
                        }
                        InputStream inputStream2 = httpURLConnection.getInputStream();
                        try {
                            File file = new File(dexPath);
                            if (file.exists()) {
                                file.delete();
                            }
                            if (!file.getParentFile().exists()) {
                                file.getParentFile().mkdirs();
                            }
                            file.createNewFile();
                            fileOutputStream = new FileOutputStream(file);
                        } catch (Throwable th6) {
                            fileOutputStream = null;
                            inputStream = inputStream2;
                            th = th6;
                        }
                        try {
                            byte[] bArr = new byte[8192];
                            while (true) {
                                int read = inputStream2.read(bArr);
                                if (read == -1) {
                                    break;
                                } else {
                                    fileOutputStream.write(bArr, 0, read);
                                }
                            }
                            QMLog.i(MiniDynamicManager.TAG, "download dex completed!");
                            try {
                                if (AppLoaderFactory.g().getProxyManager() != null) {
                                    wnsConfigProxy = (WnsConfigProxy) AppLoaderFactory.g().getProxyManager().get(WnsConfigProxy.class);
                                } else {
                                    wnsConfigProxy = null;
                                }
                                if (wnsConfigProxy == null) {
                                    str2 = "1";
                                } else {
                                    str2 = wnsConfigProxy.getConfig("qqminiapp", "dex_preload");
                                }
                                QMLog.i(MiniDynamicManager.TAG, "preload dex enable=" + str2);
                                if ("1".equals(str2)) {
                                    Context context = AppLoaderFactory.g().getContext();
                                    String str4 = dexPath;
                                    if (context != null) {
                                        str3 = context.getApplicationInfo().nativeLibraryDir;
                                    }
                                    QMLog.i(MiniDynamicManager.TAG, "preload dex succ. classloader=" + new MiniAppClassloader(str4, str3, getClass().getClassLoader()));
                                }
                            } catch (Throwable th7) {
                                QMLog.e(MiniDynamicManager.TAG, "preload dex exception!", th7);
                            }
                            if (str.equals(MiniDynamicManager.this.mCurrDownloadConfigStr)) {
                                MiniDynamicManager.this.setValidDexConfig(str, miniDexConfig);
                            }
                            inputStream2.close();
                        } catch (Throwable th8) {
                            th = th8;
                            inputStream = inputStream2;
                            try {
                                QMLog.e(MiniDynamicManager.TAG, "download exception!", th);
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (fileOutputStream == null) {
                                    return;
                                }
                                fileOutputStream.close();
                            } catch (Throwable th9) {
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable unused) {
                                        throw th9;
                                    }
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                throw th9;
                            }
                        }
                        fileOutputStream.close();
                    } catch (Throwable unused2) {
                    }
                }
            }).start();
            return;
        }
        QMLog.e(TAG, "dex url is null.");
    }

    public static MiniDynamicManager g() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new MiniDynamicManager();
                }
            }
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValidDexConfig(String str, MiniDexConfig miniDexConfig) {
        QMLog.i(TAG, "set valid dex config: " + str);
        this.mMiniDexConfig = miniDexConfig;
        this.mConfigStr = str;
    }

    public MiniDexConfig getValidDexConfig() {
        return this.mMiniDexConfig;
    }

    public void updateDexConfig(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.mConfigStr)) {
            QMLog.i(TAG, "update dex config:" + str);
            MiniDexConfig convertFrom = MiniDexConfig.convertFrom(str);
            if (convertFrom == null) {
                return;
            }
            if (!convertFrom.verifyDex()) {
                if (!convertFrom.isDexDownloaded() && AppLoaderFactory.g().isMainProcess()) {
                    doDownloadDex(str, convertFrom);
                    return;
                }
                return;
            }
            setValidDexConfig(str, convertFrom);
        }
    }
}
