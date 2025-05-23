package com.weibo.ssosdk;

import android.text.TextUtils;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheWeatherData;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class WeiboSsoSdk {
    private static final String AID_FILE_NAME = "weibo_sso_sdk_aid";
    private static final String INIT_FILE_NAME = "weibo_sso_sdk_init";
    private static final String LOGIN_URL = "https://login.sina.com.cn/visitor/signin";
    private static final int SDK_ACT_UPLOAD = 2;
    private static final int SDK_ACT_VISITORLOGIN = 1;
    public static final String SDK_VERSION_CODE = "1.0";
    private static final String TAG = "WeiboSsoSdk";
    private static final int VERSION = 1;
    private static WeiboSsoSdkConfig config;
    private static WeiboSsoSdk sInstance;
    private int mCallCount;
    private VisitorLoginInfo mVisitorLoginInfo;
    private volatile ReentrantLock mTaskLock = new ReentrantLock(true);
    private boolean isFirstUpload = true;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class VisitorLoginInfo {
        private String mAid = "";
        private String mSubCookie = "";

        static VisitorLoginInfo parseJson(String str) {
            VisitorLoginInfo visitorLoginInfo = new VisitorLoginInfo();
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("retcode", "");
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                if (optString.equals("20000000") && jSONObject2 != null) {
                    visitorLoginInfo.mAid = jSONObject2.optString("aid", "");
                    visitorLoginInfo.mSubCookie = jSONObject2.optString("sub", "");
                    return visitorLoginInfo;
                }
                throw new Exception("error\uff1a " + optString + " msg:" + jSONObject.optString("msg", ""));
            } catch (Exception e16) {
                throw e16;
            }
        }

        final VisitorLoginInfo cloneAidInfo() {
            VisitorLoginInfo visitorLoginInfo = new VisitorLoginInfo();
            visitorLoginInfo.mAid = this.mAid;
            visitorLoginInfo.mSubCookie = this.mSubCookie;
            return visitorLoginInfo;
        }

        public final String getAid() {
            return this.mAid;
        }

        public final String getVisitorSub() {
            return this.mSubCookie;
        }
    }

    static {
        System.loadLibrary(WidgetCacheWeatherData.WIND);
    }

    WeiboSsoSdk() {
        WeiboSsoSdkConfig weiboSsoSdkConfig = config;
        if (weiboSsoSdkConfig != null && weiboSsoSdkConfig.verify()) {
            this.mCallCount = 0;
            new BaseThread(new Runnable() { // from class: com.weibo.ssosdk.WeiboSsoSdk.1
                @Override // java.lang.Runnable
                public void run() {
                    String loadAidFromCache;
                    while (true) {
                        try {
                            LockMethodProxy.sleep(86400000L);
                            if (WeiboSsoSdk.this.mVisitorLoginInfo == null || TextUtils.isEmpty(WeiboSsoSdk.this.mVisitorLoginInfo.getAid())) {
                                loadAidFromCache = WeiboSsoSdk.this.loadAidFromCache();
                            } else {
                                loadAidFromCache = WeiboSsoSdk.this.mVisitorLoginInfo.getAid();
                            }
                            WeiboSsoSdk.getInstance().updateInfo(loadAidFromCache, 2);
                        } catch (Exception unused) {
                        }
                    }
                }
            }).start();
            new BaseThread(new Runnable() { // from class: com.weibo.ssosdk.WeiboSsoSdk.2
                @Override // java.lang.Runnable
                public void run() {
                    String loadAidFromCache;
                    try {
                        LockMethodProxy.sleep(60000L);
                        if (!WeiboSsoSdk.this.isFirstUpload) {
                            return;
                        }
                        if (WeiboSsoSdk.this.mVisitorLoginInfo == null || TextUtils.isEmpty(WeiboSsoSdk.this.mVisitorLoginInfo.getAid())) {
                            loadAidFromCache = WeiboSsoSdk.this.loadAidFromCache();
                        } else {
                            loadAidFromCache = WeiboSsoSdk.this.mVisitorLoginInfo.getAid();
                        }
                        WeiboSsoSdk.this.updateInfo(loadAidFromCache, 2);
                    } catch (Exception unused) {
                    }
                }
            }).start();
            return;
        }
        throw new Exception("config error");
    }

    private synchronized void cacheAidInfo(String str) {
        FileOutputStream fileOutputStream;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(getAidInfoFile(1));
        } catch (Exception unused) {
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            fileOutputStream.write(str.getBytes());
            try {
                fileOutputStream.close();
            } catch (IOException unused2) {
            }
        } catch (Exception unused3) {
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused4) {
                }
            }
        } catch (Throwable th6) {
            th = th6;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
    }

    private String do_post(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(LOGIN_URL).openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setReadTimeout(3000);
            httpURLConnection.setConnectTimeout(1000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(str.getBytes());
            outputStream.flush();
            if (httpURLConnection.getResponseCode() != 200) {
                return null;
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    inputStream.close();
                    byteArrayOutputStream.close();
                    return new String(byteArrayOutputStream.toByteArray());
                }
            }
        } catch (Exception unused) {
            return null;
        }
    }

    private File getAidInfoFile(int i3) {
        return new File(config.getApplicationContext().getFilesDir(), AID_FILE_NAME + i3);
    }

    private File getInitFile() {
        return new File(config.getApplicationContext().getFilesDir(), INIT_FILE_NAME);
    }

    public static synchronized WeiboSsoSdk getInstance() {
        WeiboSsoSdk weiboSsoSdk;
        synchronized (WeiboSsoSdk.class) {
            if (sInstance == null) {
                sInstance = new WeiboSsoSdk();
            }
            weiboSsoSdk = sInstance;
        }
        return weiboSsoSdk;
    }

    public static synchronized boolean initConfig(WeiboSsoSdkConfig weiboSsoSdkConfig) {
        synchronized (WeiboSsoSdk.class) {
            if (weiboSsoSdkConfig == null) {
                return false;
            }
            if (!weiboSsoSdkConfig.verify()) {
                return false;
            }
            if (config != null) {
                return false;
            }
            WeiboSsoSdkConfig weiboSsoSdkConfig2 = (WeiboSsoSdkConfig) weiboSsoSdkConfig.clone();
            config = weiboSsoSdkConfig2;
            MfpBuilder.init(weiboSsoSdkConfig2.getApplicationContext());
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String loadAidFromCache() {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(getAidInfoFile(1));
        } catch (Exception unused) {
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            String str = new String(bArr);
            try {
                fileInputStream.close();
            } catch (IOException unused2) {
            }
            return str;
        } catch (Exception unused3) {
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                    return "";
                } catch (IOException unused4) {
                    return "";
                }
            }
            return "";
        } catch (Throwable th6) {
            th = th6;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
    }

    private String loadInitFile() {
        FileInputStream fileInputStream;
        Throwable th5;
        try {
            fileInputStream = new FileInputStream(getInitFile());
        } catch (Exception unused) {
            fileInputStream = null;
        } catch (Throwable th6) {
            fileInputStream = null;
            th5 = th6;
        }
        try {
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            String str = new String(bArr);
            try {
                fileInputStream.close();
            } catch (IOException unused2) {
            }
            return str;
        } catch (Exception unused3) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException unused4) {
                }
            }
            return null;
        } catch (Throwable th7) {
            th5 = th7;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException unused5) {
                }
            }
            throw th5;
        }
    }

    private native String riseWind(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i3, int i16);

    private synchronized void saveInitFile(String str) {
        FileOutputStream fileOutputStream;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(getInitFile());
        } catch (Exception unused) {
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            fileOutputStream.write(str.getBytes());
            try {
                fileOutputStream.close();
            } catch (IOException unused2) {
            }
        } catch (Exception unused3) {
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused4) {
                }
            }
        } catch (Throwable th6) {
            th = th6;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateInfo(String str, int i3) {
        String str2;
        if (TextUtils.isEmpty(config.getAppKey(false))) {
            return;
        }
        if (!this.mTaskLock.tryLock()) {
            this.mTaskLock.lock();
            this.mTaskLock.unlock();
            return;
        }
        this.isFirstUpload = false;
        String mfp = MfpBuilder.getMfp(config.getApplicationContext());
        try {
            str2 = URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            str2 = "";
        }
        String do_post = do_post(riseWind(config.getAppKey(true), config.getApplicationContext().getPackageName(), str2, mfp, config.getFrom(true), config.getOldWm(true), config.getWm(true), config.getSub(true), config.getSmid(true), config.getExtraString(true), i3, this.mCallCount));
        this.mCallCount++;
        if (do_post != null) {
            try {
                VisitorLoginInfo parseJson = VisitorLoginInfo.parseJson(do_post);
                if (parseJson != null && !TextUtils.isEmpty(parseJson.getAid())) {
                    cacheAidInfo(parseJson.getAid());
                }
                if (i3 == 1) {
                    this.mVisitorLoginInfo = parseJson;
                }
                this.mTaskLock.unlock();
                return;
            } catch (Exception e16) {
                this.mTaskLock.unlock();
                throw e16;
            }
        }
        this.mTaskLock.unlock();
        throw new Exception("network error.");
    }

    public String getAid() {
        String loadAidFromCache = loadAidFromCache();
        if (!TextUtils.isEmpty(loadAidFromCache)) {
            return loadAidFromCache;
        }
        VisitorLoginInfo visitorLoginInfo = this.mVisitorLoginInfo;
        if (visitorLoginInfo == null || TextUtils.isEmpty(visitorLoginInfo.getAid())) {
            BaseThread baseThread = new BaseThread(new Runnable() { // from class: com.weibo.ssosdk.WeiboSsoSdk.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        WeiboSsoSdk.this.updateInfo("", 1);
                    } catch (Exception unused) {
                    }
                }
            });
            baseThread.start();
            baseThread.join();
            VisitorLoginInfo visitorLoginInfo2 = this.mVisitorLoginInfo;
            if (visitorLoginInfo2 == null || TextUtils.isEmpty(visitorLoginInfo2.getAid())) {
                throw new Exception("visitor login failed");
            }
        }
        return this.mVisitorLoginInfo.getAid();
    }

    public void updateSub(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        config.setSub(str);
        String visitorSub = this.mVisitorLoginInfo.getVisitorSub();
        if (TextUtils.isEmpty(visitorSub) || !visitorSub.equals(str)) {
            new BaseThread(new Runnable() { // from class: com.weibo.ssosdk.WeiboSsoSdk.3
                @Override // java.lang.Runnable
                public void run() {
                    String loadAidFromCache;
                    if (WeiboSsoSdk.this.mVisitorLoginInfo == null || TextUtils.isEmpty(WeiboSsoSdk.this.mVisitorLoginInfo.getAid())) {
                        loadAidFromCache = WeiboSsoSdk.this.loadAidFromCache();
                    } else {
                        loadAidFromCache = WeiboSsoSdk.this.mVisitorLoginInfo.getAid();
                    }
                    try {
                        WeiboSsoSdk.this.updateInfo(loadAidFromCache, 2);
                    } catch (Exception unused) {
                    }
                }
            }).start();
        }
    }

    public VisitorLoginInfo visitorLogin() {
        VisitorLoginInfo visitorLoginInfo = this.mVisitorLoginInfo;
        if (visitorLoginInfo == null || TextUtils.isEmpty(visitorLoginInfo.getAid()) || TextUtils.isEmpty(this.mVisitorLoginInfo.getVisitorSub())) {
            BaseThread baseThread = new BaseThread(new Runnable() { // from class: com.weibo.ssosdk.WeiboSsoSdk.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        WeiboSsoSdk.this.updateInfo("", 1);
                    } catch (Exception unused) {
                    }
                }
            });
            baseThread.start();
            baseThread.join();
            VisitorLoginInfo visitorLoginInfo2 = this.mVisitorLoginInfo;
            if (visitorLoginInfo2 == null || TextUtils.isEmpty(visitorLoginInfo2.getAid()) || TextUtils.isEmpty(this.mVisitorLoginInfo.getVisitorSub())) {
                throw new Exception("visitor login failed");
            }
        }
        return this.mVisitorLoginInfo;
    }

    public void getAid(final AidListener aidListener) {
        String loadAidFromCache = loadAidFromCache();
        if (!TextUtils.isEmpty(loadAidFromCache)) {
            aidListener.handler(loadAidFromCache);
        }
        VisitorLoginInfo visitorLoginInfo = this.mVisitorLoginInfo;
        if (visitorLoginInfo != null && !TextUtils.isEmpty(visitorLoginInfo.getAid())) {
            aidListener.handler(this.mVisitorLoginInfo.getAid());
        } else {
            ProxyExecutors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.weibo.ssosdk.WeiboSsoSdk.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        WeiboSsoSdk.this.updateInfo("", 1);
                    } catch (Exception unused) {
                    }
                    if (WeiboSsoSdk.this.mVisitorLoginInfo == null) {
                        WeiboSsoSdk.this.mVisitorLoginInfo = new VisitorLoginInfo();
                    }
                    aidListener.handler(WeiboSsoSdk.this.mVisitorLoginInfo.getAid());
                }
            });
        }
    }

    public void visitorLogin(final VisitorLoginListener visitorLoginListener) {
        VisitorLoginInfo visitorLoginInfo = this.mVisitorLoginInfo;
        if (visitorLoginInfo != null && !TextUtils.isEmpty(visitorLoginInfo.getAid()) && !TextUtils.isEmpty(this.mVisitorLoginInfo.getVisitorSub())) {
            visitorLoginListener.handler(this.mVisitorLoginInfo);
        } else {
            ProxyExecutors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.weibo.ssosdk.WeiboSsoSdk.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        WeiboSsoSdk.this.updateInfo("", 1);
                    } catch (Exception unused) {
                    }
                    if (WeiboSsoSdk.this.mVisitorLoginInfo == null) {
                        WeiboSsoSdk.this.mVisitorLoginInfo = new VisitorLoginInfo();
                    }
                    visitorLoginListener.handler(WeiboSsoSdk.this.mVisitorLoginInfo);
                }
            });
        }
    }

    private static void LogD(String str) {
    }

    private static void LogE(String str) {
    }
}
