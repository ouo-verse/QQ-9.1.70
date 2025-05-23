package com.tencent.ams.fusion.widget.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.oskplayer.cache.FileDataSink;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes3.dex */
public class NetworkResLoader {
    static IPatchRedirector $redirector_ = null;
    private static final int CLEAR_CACHE_INTERVAL = 86400;
    private static final int DEFAULT_CACHE_EXPIRED_TIME = 604800000;
    private static final int DEFAULT_TIMEOUT_MS = 30000;
    private static final String TAG = "NetworkResLoader";
    private static long mLastClearCacheTime;
    private final Context mAppContext;
    private int mCacheExpiredTime;
    private LoadListener mLoadListener;
    private int mTimeoutMs;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private class DownloadTask implements Runnable {
        static IPatchRedirector $redirector_;
        private final CountDownLatch mCountDownLatch;
        private final AtomicBoolean mHasFailure;
        private final String mUrl;

        DownloadTask(String str, @NonNull CountDownLatch countDownLatch, @NonNull AtomicBoolean atomicBoolean) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, NetworkResLoader.this, str, countDownLatch, atomicBoolean);
                return;
            }
            this.mUrl = str;
            this.mCountDownLatch = countDownLatch;
            this.mHasFailure = atomicBoolean;
        }

        private boolean downloadRes(String str, String str2) {
            FileOutputStream fileOutputStream;
            BufferedInputStream bufferedInputStream;
            HttpURLConnection httpURLConnection;
            File file;
            FileOutputStream fileOutputStream2;
            File file2 = new File(str2);
            if (file2.exists()) {
                Logger.i(NetworkResLoader.TAG, "download res cancel: cache exist");
                try {
                    file2.setLastModified(System.currentTimeMillis());
                    return true;
                } catch (Throwable unused) {
                    return true;
                }
            }
            HttpURLConnection httpURLConnection2 = null;
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                try {
                } catch (Throwable th5) {
                    th = th5;
                    bufferedInputStream = null;
                    httpURLConnection2 = httpURLConnection;
                    fileOutputStream = null;
                }
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream = null;
                bufferedInputStream = null;
            }
            if (httpURLConnection.getResponseCode() == 200) {
                bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                try {
                    file = new File(str2 + FileDataSink.TEMP_FILE);
                    file.deleteOnExit();
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    fileOutputStream2 = new FileOutputStream(file);
                } catch (Throwable th7) {
                    th = th7;
                    httpURLConnection2 = httpURLConnection;
                    fileOutputStream = null;
                }
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, read);
                    }
                    boolean renameTo = file.renameTo(file2);
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable unused2) {
                    }
                    Utils.safeCloseInputStream(bufferedInputStream);
                    Utils.safeCloseOutputStream(fileOutputStream2);
                    return renameTo;
                } catch (Throwable th8) {
                    httpURLConnection2 = httpURLConnection;
                    fileOutputStream = fileOutputStream2;
                    th = th8;
                    try {
                        Logger.w(NetworkResLoader.TAG, "download res failed: " + th.getMessage());
                        return false;
                    } finally {
                        if (httpURLConnection2 != null) {
                            try {
                                httpURLConnection2.disconnect();
                            } catch (Throwable unused3) {
                            }
                        }
                        Utils.safeCloseInputStream(bufferedInputStream);
                        Utils.safeCloseOutputStream(fileOutputStream);
                    }
                }
            }
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused4) {
            }
            Utils.safeCloseInputStream(null);
            Utils.safeCloseOutputStream(null);
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                String cacheFilePath = NetworkResLoader.getCacheFilePath(NetworkResLoader.this.mAppContext, this.mUrl);
                boolean z16 = true;
                if (TextUtils.isEmpty(cacheFilePath)) {
                    this.mHasFailure.set(true);
                    return;
                }
                AtomicBoolean atomicBoolean = this.mHasFailure;
                if (downloadRes(this.mUrl, cacheFilePath)) {
                    z16 = false;
                }
                atomicBoolean.set(z16);
            } finally {
                this.mCountDownLatch.countDown();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private class FinishTask implements Runnable {
        static IPatchRedirector $redirector_;
        private final CountDownLatch mCountDownLatch;
        private final AtomicBoolean mHasFailure;

        FinishTask(CountDownLatch countDownLatch, @NonNull AtomicBoolean atomicBoolean) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, NetworkResLoader.this, countDownLatch, atomicBoolean);
            } else {
                this.mCountDownLatch = countDownLatch;
                this.mHasFailure = atomicBoolean;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                try {
                    LoadListener loadListener = NetworkResLoader.this.mLoadListener;
                    if (loadListener != null) {
                        loadListener.onLoadStart();
                    }
                    boolean await = this.mCountDownLatch.await(NetworkResLoader.this.mTimeoutMs, TimeUnit.MILLISECONDS);
                    if (loadListener != null) {
                        if (await && !this.mHasFailure.get()) {
                            loadListener.onLoadFinish();
                        } else {
                            loadListener.onLoadFailed();
                        }
                    }
                    NetworkResLoader.this.clearExpireCache();
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface LoadListener {
        void onLoadFailed();

        void onLoadFinish();

        void onLoadStart();
    }

    public NetworkResLoader(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mCacheExpiredTime = 604800000;
        this.mTimeoutMs = 30000;
        this.mAppContext = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void clearExpireCache() {
        if (mLastClearCacheTime > 0 && System.currentTimeMillis() - mLastClearCacheTime < 86400) {
            return;
        }
        Logger.d(TAG, "start clear expire cache");
        mLastClearCacheTime = System.currentTimeMillis();
        Utils.runOnAsyncThread(new Runnable() { // from class: com.tencent.ams.fusion.widget.utils.NetworkResLoader.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) NetworkResLoader.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    String cacheFileDir = NetworkResLoader.getCacheFileDir(NetworkResLoader.this.mAppContext);
                    if (cacheFileDir == null) {
                        return;
                    }
                    File file = new File(cacheFileDir);
                    if (file.exists() && file.isDirectory()) {
                        File[] listFiles = file.listFiles();
                        long currentTimeMillis = System.currentTimeMillis();
                        if (listFiles != null) {
                            for (File file2 : listFiles) {
                                if (file2 != null && currentTimeMillis - file2.lastModified() > NetworkResLoader.this.mCacheExpiredTime) {
                                    file2.delete();
                                    Logger.d(NetworkResLoader.TAG, "file expired, delete file: " + file2.getAbsolutePath());
                                }
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getCacheFileDir(Context context) {
        if (context == null) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(context.getFilesDir());
        String str = File.separator;
        sb5.append(str);
        sb5.append("ad_cache");
        sb5.append(str);
        sb5.append("fusion_widget_cache");
        return sb5.toString();
    }

    public static String getCacheFilePath(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String cacheFileDir = getCacheFileDir(context);
        if (TextUtils.isEmpty(cacheFileDir)) {
            return null;
        }
        return cacheFileDir + File.separator + Utils.toMd5(str);
    }

    public void loadRes(List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
            return;
        }
        if (list != null && list.size() != 0) {
            Logger.i(TAG, "start load res");
            CountDownLatch countDownLatch = new CountDownLatch(list.size());
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            for (String str : list) {
                if (!TextUtils.isEmpty(str) && str.startsWith("http")) {
                    Utils.runOnAsyncThread(new DownloadTask(str, countDownLatch, atomicBoolean), true);
                } else {
                    Logger.w(TAG, "invalid url: " + str);
                    countDownLatch.countDown();
                }
            }
            Utils.runOnAsyncThread(new FinishTask(countDownLatch, atomicBoolean));
            return;
        }
        Logger.w(TAG, "load res with empty urls");
    }

    public void setCacheExpiredTime(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else if (i3 > 0) {
            this.mCacheExpiredTime = i3;
        }
    }

    public void setLoadListener(LoadListener loadListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) loadListener);
        } else {
            this.mLoadListener = loadListener;
        }
    }

    public void setTimeoutMs(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else if (i3 > 0) {
            this.mTimeoutMs = i3;
        }
    }
}
