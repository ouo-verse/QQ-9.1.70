package com.tencent.image;

import android.app.PendingIntent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.image.ApngDrawable;
import com.tencent.image.DownloadParams;
import com.tencent.image.GifDrawable;
import com.tencent.image.RoundRectDrawable;
import com.tencent.image.SharpDrawable;
import com.tencent.image.SliceBitmapDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.VideoDrawable;
import com.tencent.image.api.ILog;
import com.tencent.image.api.IThreadListener;
import com.tencent.image.sharp.SharpImage;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.sharpP.SharpPUtil;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.client.CookieStore;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class URLState extends Drawable.ConstantState {
    static IPatchRedirector $redirector_ = null;
    static final String CACHE_PREFIX = "Cache_";
    static final Object DOWNLOAD_ASYNC;
    static final Object FILE_DOWNLOADED;
    public static final int FLAG_BATCH_HANDLER = 2;
    public static final int FLAG_FILE_HANDLER = 0;
    public static final int FLAG_THREAD_POOL = 1;
    public static final int INTERVAL_TIME = 300000;
    public static final int LENGTH_URL_EXTRA = 60;
    public static final int REPORT_TIME = 500000;
    public static final String TENCENT_FILE_PATH;
    public static final int THREAD_COST_TIME = 500000;
    private static final Handler UI_HANDLER;
    private static String[] sSysTracePrefixs;
    static ConcurrentHashMap<String, ThreadReportParam> sThreadReportCache;
    static HashMap<String, WeakReference<URLState>> sUnFinishImageCache;
    static long slastCheckTime;
    private Vector<WeakReference<Callback>> callbacks;
    boolean isFlashPicNeedCache;
    String mCacheFile;
    CustomError mCustomError;
    boolean mDecodeFile;
    private final Object mDecodeFileLock;
    int mDecodeFileStrategy;
    boolean mDither;
    int mHeight;
    boolean mIgnorePause;
    int mIsLoadingStarted;
    String mMemoryCacheKey;
    int mOrientation;
    DownloadParams mParams;
    byte mPriority;
    int mProgress;
    ProtocolDownloader mProtocolDownloader;
    int mStatus;
    Drawable.ConstantState mSuccessed;
    PreDownloadRunnable mTask;
    URL mUrl;
    String mUrlStr;
    boolean mUseMemoryCache;
    boolean mUseThreadPool;
    boolean mUseUnFinishCache;
    int mWidth;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface Callback {
        void onFileDownloadFailed(int i3);

        void onFileDownloadStarted();

        void onFileDownloadSucceed(long j3);

        void onFileDownloaded(URLState uRLState);

        void onLoadCanceled(URLState uRLState);

        void onLoadFailed(URLState uRLState, Throwable th5);

        void onLoadStarted(URLState uRLState);

        void onLoadSuccessed(URLState uRLState);

        void onUpdateProgress(int i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class DownloadRunnable implements Runnable, URLDrawableHandler {
        static IPatchRedirector $redirector_;
        public int flag;
        private final AtomicBoolean mCancelled;
        public JobQueue mQueue;
        URL mUrl;
        public long postTime;

        DownloadRunnable(URL url) {
            JobQueue queue;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) URLState.this, (Object) url);
                return;
            }
            this.mCancelled = new AtomicBoolean();
            this.mUrl = url;
            ProtocolDownloader protocolDownloader = URLState.this.mProtocolDownloader;
            if (protocolDownloader == null) {
                queue = null;
            } else {
                queue = protocolDownloader.getQueue(url);
            }
            this.mQueue = queue;
        }

        public void cancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            } else {
                this.mCancelled.set(true);
            }
        }

        @Override // com.tencent.image.URLDrawableHandler
        public void doCancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
                return;
            }
            throw new CancellationException();
        }

        @Override // com.tencent.image.URLDrawableHandler
        public boolean isCancelled() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return this.mCancelled.get();
        }

        @Override // com.tencent.image.URLDrawableHandler
        public void onFileDownloadFailed(int i3) {
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
                synchronized (URLState.this.callbacks) {
                    int i17 = 0;
                    while (i17 < URLState.this.callbacks.size()) {
                        WeakReference weakReference = (WeakReference) URLState.this.callbacks.get(i17);
                        if (weakReference != null) {
                            Callback callback = (Callback) weakReference.get();
                            if (callback != null) {
                                callback.onFileDownloadFailed(i3);
                                i17++;
                            } else {
                                i16 = i17 - 1;
                                URLState.this.callbacks.remove(i17);
                            }
                        } else {
                            i16 = i17 - 1;
                            URLState.this.callbacks.remove(i17);
                        }
                        i17 = i16;
                        i17++;
                    }
                }
                return;
            }
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        }

        @Override // com.tencent.image.URLDrawableHandler
        public void onFileDownloadStarted() {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
                synchronized (URLState.this.callbacks) {
                    int i16 = 0;
                    while (i16 < URLState.this.callbacks.size()) {
                        WeakReference weakReference = (WeakReference) URLState.this.callbacks.get(i16);
                        if (weakReference != null) {
                            Callback callback = (Callback) weakReference.get();
                            if (callback != null) {
                                callback.onFileDownloadStarted();
                                i16++;
                            } else {
                                i3 = i16 - 1;
                                URLState.this.callbacks.remove(i16);
                            }
                        } else {
                            i3 = i16 - 1;
                            URLState.this.callbacks.remove(i16);
                        }
                        i16 = i3;
                        i16++;
                    }
                }
                return;
            }
            iPatchRedirector.redirect((short) 9, (Object) this);
        }

        @Override // com.tencent.image.URLDrawableHandler
        public void onFileDownloadSucceed(long j3) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
                synchronized (URLState.this.callbacks) {
                    int i16 = 0;
                    while (i16 < URLState.this.callbacks.size()) {
                        WeakReference weakReference = (WeakReference) URLState.this.callbacks.get(i16);
                        if (weakReference != null) {
                            Callback callback = (Callback) weakReference.get();
                            if (callback != null) {
                                callback.onFileDownloadSucceed(j3);
                                i16++;
                            } else {
                                i3 = i16 - 1;
                                URLState.this.callbacks.remove(i16);
                            }
                        } else {
                            i3 = i16 - 1;
                            URLState.this.callbacks.remove(i16);
                        }
                        i16 = i3;
                        i16++;
                    }
                }
                return;
            }
            iPatchRedirector.redirect((short) 10, (Object) this, j3);
        }

        protected void onProgressUpdate(int i3) {
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, i3);
                return;
            }
            URLState uRLState = URLState.this;
            uRLState.mProgress = i3;
            if (!URLDrawable.sPause || uRLState.mIgnorePause) {
                synchronized (uRLState.callbacks) {
                    int i17 = 0;
                    while (i17 < URLState.this.callbacks.size()) {
                        WeakReference weakReference = (WeakReference) URLState.this.callbacks.get(i17);
                        if (weakReference != null) {
                            Callback callback = (Callback) weakReference.get();
                            if (callback != null) {
                                callback.onUpdateProgress(i3);
                                i17++;
                            } else {
                                i16 = i17 - 1;
                                URLState.this.callbacks.remove(i17);
                            }
                        } else {
                            i16 = i17 - 1;
                            URLState.this.callbacks.remove(i17);
                        }
                        i17 = i16;
                        i17++;
                    }
                }
            }
        }

        @Override // com.tencent.image.URLDrawableHandler
        public void publishProgress(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            } else {
                if (i3 == URLState.this.mProgress) {
                    return;
                }
                URLState.UI_HANDLER.post(new Runnable(i3) { // from class: com.tencent.image.URLState.DownloadRunnable.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ int val$progress;

                    {
                        this.val$progress = i3;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DownloadRunnable.this, i3);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            DownloadRunnable.this.onProgressUpdate(this.val$progress);
                        }
                    }
                });
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis;
            long j3;
            ILog iLog;
            StringBuilder sb5;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            ThreadReportParam threadReportParam = new ThreadReportParam();
            threadReportParam.startTime = currentTimeMillis2;
            threadReportParam.postTime = currentTimeMillis2 - this.postTime;
            threadReportParam.type = this.flag;
            threadReportParam.mThread = Thread.currentThread();
            URLState.sThreadReportCache.put(URLState.this.mUrlStr, threadReportParam);
            try {
                if (isCancelled()) {
                    URLState.this.onLoadCancelled();
                }
                Object loadImage = URLState.this.loadImage(this.mUrl, this);
                if (loadImage != URLState.DOWNLOAD_ASYNC) {
                    URLState.this.result(loadImage);
                }
                currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                j3 = currentTimeMillis2 - this.postTime;
                URLState.sThreadReportCache.remove(URLState.this.mUrlStr);
            } catch (Throwable th5) {
                try {
                    URLState.this.result(th5);
                    currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                    j3 = currentTimeMillis2 - this.postTime;
                    URLState.sThreadReportCache.remove(URLState.this.mUrlStr);
                    if (URLDrawable.depImp.mLog.isColorLevel()) {
                        iLog = URLDrawable.depImp.mLog;
                        sb5 = new StringBuilder();
                    } else {
                        return;
                    }
                } catch (Throwable th6) {
                    long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                    long j16 = currentTimeMillis2 - this.postTime;
                    URLState.sThreadReportCache.remove(URLState.this.mUrlStr);
                    if (URLDrawable.depImp.mLog.isColorLevel()) {
                        URLDrawable.depImp.mLog.d("URLDrawable_Thread", 2, "DownloadAsyncTask.doInBackground end :postCost=" + j16 + " cost=" + currentTimeMillis3 + ",url" + URLState.this.mUrlStr + ",flag=" + this.flag + " ,isCancelled:" + isCancelled());
                    }
                    throw th6;
                }
            }
            if (URLDrawable.depImp.mLog.isColorLevel()) {
                iLog = URLDrawable.depImp.mLog;
                sb5 = new StringBuilder();
                sb5.append("DownloadAsyncTask.doInBackground end :postCost=");
                sb5.append(j3);
                sb5.append(" cost=");
                sb5.append(currentTimeMillis);
                sb5.append(",url");
                sb5.append(URLState.this.mUrlStr);
                sb5.append(",flag=");
                sb5.append(this.flag);
                sb5.append(" ,isCancelled:");
                sb5.append(isCancelled());
                iLog.d("URLDrawable_Thread", 2, sb5.toString());
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            String url = this.mUrl.toString();
            int i3 = 60;
            if (60 >= url.length()) {
                i3 = url.length();
            }
            return "URLD_" + url.substring(0, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class PostOnResult implements Runnable {
        static IPatchRedirector $redirector_;
        Object result;

        public PostOnResult(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) URLState.this, obj);
            } else {
                this.result = obj;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                URLState.this.onResult(this.result);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class PreDownloadRunnable implements Runnable, IThreadListener {
        static IPatchRedirector $redirector_ = null;
        private static final int DOWNLOAD_THREAD_POOL = 1;
        private static final int LOCAL_THREAD_POOL = 0;
        boolean hasFile;
        public long mCreateTime;
        DownloadRunnable mDownloadRunnable;
        long timePost;
        private URL url;

        PreDownloadRunnable(URL url) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) URLState.this, (Object) url);
                return;
            }
            this.hasFile = false;
            this.timePost = 0L;
            this.url = url;
            this.mDownloadRunnable = new DownloadRunnable(url);
            this.mCreateTime = SystemClock.uptimeMillis();
        }

        @Override // com.tencent.image.api.IThreadListener
        public void onAdded() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                this.timePost = SystemClock.uptimeMillis();
            }
        }

        @Override // com.tencent.image.api.IThreadListener
        public void onPostRun() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            }
        }

        @Override // com.tencent.image.api.IThreadListener
        public void onPreRun() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                URLDrawable.depImp.mReport.debug(3, Long.valueOf(SystemClock.uptimeMillis() - this.timePost));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if ("chatthumb".equals(this.url.getProtocol())) {
                URLDrawable.depImp.mReport.debug(4, Long.valueOf(SystemClock.uptimeMillis() - this.mCreateTime));
            }
            URLState uRLState = URLState.this;
            ProtocolDownloader protocolDownloader = uRLState.mProtocolDownloader;
            if (protocolDownloader != null && protocolDownloader.hasDiskFile(uRLState.mParams)) {
                this.hasFile = true;
            }
            URLState.UI_HANDLER.post(new Runnable() { // from class: com.tencent.image.URLState.PreDownloadRunnable.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PreDownloadRunnable.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (PreDownloadRunnable.this.mDownloadRunnable.isCancelled()) {
                        if (URLDrawable.depImp.mLog.isColorLevel()) {
                            URLDrawable.depImp.mLog.i(URLDrawable.TAG, 2, "PreDwonloadAsyncTask doInBackground." + PreDownloadRunnable.this.url + "isCancelled");
                            return;
                        }
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    PreDownloadRunnable preDownloadRunnable = PreDownloadRunnable.this;
                    preDownloadRunnable.mDownloadRunnable.postTime = currentTimeMillis;
                    if (currentTimeMillis - URLState.slastCheckTime > MiniBoxNoticeInfo.MIN_5) {
                        URLState.this.checkThreadState();
                    }
                    PreDownloadRunnable preDownloadRunnable2 = PreDownloadRunnable.this;
                    PreDownloadRunnable preDownloadRunnable3 = null;
                    if (preDownloadRunnable2.hasFile) {
                        DownloadRunnable downloadRunnable = preDownloadRunnable2.mDownloadRunnable;
                        downloadRunnable.flag = 0;
                        URLDrawable.depImp.mThreadManager.executeOnFileThreadExcutor(downloadRunnable, null, false);
                    } else {
                        if (URLDrawable.depImp.mLog.isColorLevel()) {
                            URLDrawable.depImp.mLog.d(URLDrawable.TAG, 2, "schedule load image " + URLState.this.mUrlStr + ",useThreadPool=" + URLState.this.mUseThreadPool);
                        }
                        PreDownloadRunnable preDownloadRunnable4 = PreDownloadRunnable.this;
                        DownloadRunnable downloadRunnable2 = preDownloadRunnable4.mDownloadRunnable;
                        downloadRunnable2.flag = 1;
                        JobQueue jobQueue = downloadRunnable2.mQueue;
                        if (jobQueue != null) {
                            jobQueue.excuteOnNetThread(downloadRunnable2, true);
                        } else {
                            if (preDownloadRunnable4.url.getProtocol().equals("chatthumb")) {
                                preDownloadRunnable3 = PreDownloadRunnable.this;
                            }
                            URLDrawable.depImp.mThreadManager.executeOnNetThreadExcutor(PreDownloadRunnable.this.mDownloadRunnable, preDownloadRunnable3, true);
                        }
                    }
                    URLState.this.onLoadStart();
                    if (URLDrawable.depImp.mLog.isColorLevel()) {
                        URLDrawable.depImp.mLog.i(URLDrawable.TAG, 2, "PreDwonloadAsyncTask onLoadStart." + PreDownloadRunnable.this.url);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class ThreadReportParam {
        static IPatchRedirector $redirector_;
        Thread mThread;
        long postTime;
        long startTime;
        int type;

        ThreadReportParam() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12744);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        TENCENT_FILE_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Tencent/";
        FILE_DOWNLOADED = new Object();
        DOWNLOAD_ASYNC = new Object();
        UI_HANDLER = new Handler(Looper.getMainLooper());
        sUnFinishImageCache = new HashMap<>();
        sThreadReportCache = new ConcurrentHashMap<>();
        slastCheckTime = 0L;
        sSysTracePrefixs = new String[]{"android.", "com.android.", "dalvik.", "com.google.", "java."};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public URLState(URL url, URLDrawable.URLDrawableOptions uRLDrawableOptions) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) url, (Object) uRLDrawableOptions);
            return;
        }
        this.mDecodeFileLock = new Object();
        this.mStatus = 0;
        this.mDither = true;
        this.mParams = new DownloadParams();
        this.mProgress = 0;
        this.mIsLoadingStarted = 0;
        this.mOrientation = 0;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mUseMemoryCache = true;
        this.mUseUnFinishCache = true;
        this.mIgnorePause = false;
        this.mDecodeFileStrategy = 1;
        this.isFlashPicNeedCache = false;
        this.mUseThreadPool = true;
        this.mPriority = URLDrawable.depImp.mCache.getNormalPriority();
        this.callbacks = new Vector<>();
        this.mUrl = url;
        this.isFlashPicNeedCache = uRLDrawableOptions.isFlashPic;
        String url2 = url.toString();
        this.mUrlStr = url2;
        this.mMemoryCacheKey = getMemoryCacheKey(url2, uRLDrawableOptions);
        this.mUseMemoryCache = uRLDrawableOptions.mUseMemoryCache;
        this.mUseUnFinishCache = uRLDrawableOptions.mUseUnFinishCache;
        this.mUseThreadPool = uRLDrawableOptions.mUseThreadPool;
        this.mDecodeFileStrategy = uRLDrawableOptions.mDecodeFileStrategy;
        this.mPriority = uRLDrawableOptions.mPriority;
        ProtocolDownloader downloader = URLDrawable.sDefaultDrawableParms.getDownloader(url.getProtocol(), uRLDrawableOptions.mHttpDownloaderParams);
        this.mProtocolDownloader = downloader;
        if (downloader == null && URLDrawable.depImp.mLog.isColorLevel()) {
            URLDrawable.depImp.mLog.e(URLDrawable.TAG, 4, "No comfortable downloader. url:" + url + AudienceReportConst.PROTOCOL + url.getProtocol());
        }
        synchronized (URLDrawable.depImp.mCache) {
            if (this.mUseUnFinishCache) {
                sUnFinishImageCache.put(this.mMemoryCacheKey, new WeakReference<>(this));
            }
        }
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int i3, int i16) {
        int i17 = 1;
        if (i3 != 0 && i16 != 0 && i3 != -1 && i16 != -1) {
            int i18 = options.outHeight;
            int i19 = options.outWidth;
            while (i18 > i16 && i19 > i3) {
                int round = Math.round(i18 / i16);
                int round2 = Math.round(i19 / i3);
                if (round <= round2) {
                    round = round2;
                }
                if (round < 2) {
                    break;
                }
                i19 >>= 1;
                i18 >>= 1;
                i17 <<= 1;
            }
        }
        return i17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkThreadState() {
        if (slastCheckTime == 0) {
            slastCheckTime = System.currentTimeMillis();
            return;
        }
        slastCheckTime = System.currentTimeMillis();
        if (sThreadReportCache.size() > 0) {
            try {
                Iterator<Map.Entry<String, ThreadReportParam>> it = sThreadReportCache.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, ThreadReportParam> next = it.next();
                    String key = next.getKey();
                    ThreadReportParam value = next.getValue();
                    long currentTimeMillis = System.currentTimeMillis() - value.startTime;
                    if (currentTimeMillis > 500000) {
                        HashMap<String, String> hashMap = new HashMap<>();
                        hashMap.put(Global.TRACKING_URL, key);
                        hashMap.put("duration", String.valueOf(currentTimeMillis));
                        hashMap.put("threadState", String.valueOf(value.mThread.getState()));
                        hashMap.put("threadStack", getAppStack(value.mThread.getStackTrace()).toString());
                        hashMap.put("postCost", String.valueOf(value.postTime));
                        hashMap.put("ThreadFlag", String.valueOf(value.type));
                        ReportBean reportBean = new ReportBean("URLDrawableThreadState");
                        reportBean.params = hashMap;
                        URLDrawable.depImp.mReport.report(reportBean);
                        if (URLDrawable.depImp.mLog.isColorLevel()) {
                            URLDrawable.depImp.mLog.d("URLDrawable_Thread", 2, "checkThreadState|params= " + hashMap);
                        }
                        it.remove();
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    private Object decodeFile(File file, URLDrawableHandler uRLDrawableHandler) throws Exception {
        Object obj;
        boolean z16;
        Bitmap bitmap;
        ProtocolDownloader protocolDownloader = this.mProtocolDownloader;
        if (protocolDownloader != null) {
            obj = protocolDownloader.decodeFile(file, this.mParams, uRLDrawableHandler);
            if (obj != null) {
                DownloadParams downloadParams = this.mParams;
                this.mOrientation = downloadParams.outOrientation;
                this.mWidth = downloadParams.outWidth;
                this.mHeight = downloadParams.outHeight;
                return obj;
            }
        } else {
            obj = null;
        }
        if (file == null || !file.exists()) {
            return null;
        }
        if (protocolDownloader != null && protocolDownloader.gifHasDifferentState()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (VideoDrawable.isVideo(file)) {
            DownloadParams downloadParams2 = this.mParams;
            return new NativeVideoImage(file, true, downloadParams2.reqWidth, downloadParams2.reqHeight, downloadParams2.mExtraInfo);
        }
        if (GifDrawable.isGifFile(file) && (z16 || this.mParams.useGifAnimation)) {
            DownloadParams downloadParams3 = this.mParams;
            return NativeGifFactory.getNativeGifObject(file, z16, false, downloadParams3.reqWidth, downloadParams3.reqHeight, downloadParams3.mGifRoundCorner, downloadParams3.mExtraInfo);
        }
        DownloadParams downloadParams4 = this.mParams;
        if (downloadParams4.useApngImage) {
            if (downloadParams4.mExtraInfo instanceof Bundle) {
                return new ApngImage(file, z16, (Bundle) this.mParams.mExtraInfo);
            }
            return new ApngImage(file, z16);
        }
        if ((downloadParams4.useSharpPImage || downloadParams4.useSharpPAnimImage) && SharpDrawable.isSharpP(file)) {
            DownloadParams downloadParams5 = this.mParams;
            if (downloadParams5.useSharpPAnimImage) {
                if (downloadParams5.mExtraInfo instanceof Bundle) {
                    return new SharpImage(file, z16, (Bundle) this.mParams.mExtraInfo);
                }
                return new SharpImage(file, z16);
            }
            try {
                return SharpPUtil.decodeSharpPByFilePath(file.getAbsolutePath());
            } catch (Throwable th5) {
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                    URLDrawable.depImp.mLog.e(URLDrawable.TAG, 2, "", th5);
                    return obj;
                }
                return obj;
            }
        }
        String absolutePath = file.getAbsolutePath();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inPreferredConfig = URLDrawable.sDefaultDrawableParms.mConfig;
        options.inDensity = 160;
        options.inTargetDensity = 160;
        options.inScreenDensity = 160;
        SafeBitmapFactory.decodeFile(absolutePath, options);
        options.inJustDecodeBounds = false;
        DownloadParams downloadParams6 = this.mParams;
        options.inSampleSize = calculateInSampleSize(options, downloadParams6.reqWidth, downloadParams6.reqHeight);
        Bitmap decodeFile = SafeBitmapFactory.decodeFile(absolutePath, options);
        if (URLDrawable.depImp.mLog.isColorLevel()) {
            URLDrawable.depImp.mLog.d(URLDrawable.TAG, 2, "decodeFile:sampleSize=" + options.inSampleSize + ", requestSize=" + this.mParams.reqWidth + "," + this.mParams.reqHeight + " " + this.mUrlStr);
        }
        if (decodeFile == null) {
            if (this.mDecodeFileStrategy == 3) {
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                    URLDrawable.depImp.mLog.d(URLDrawable.TAG, 2, "decode cache file failed,ignoreDeleteFile:" + absolutePath + " mUrlStr:" + this.mUrlStr);
                }
            } else {
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                    URLDrawable.depImp.mLog.d(URLDrawable.TAG, 2, "decode cache file failed,path:" + absolutePath + " mUrlStr:" + this.mUrlStr + " mDecodeFileStrategy:" + this.mDecodeFileStrategy);
                }
                if (absolutePath.startsWith(TENCENT_FILE_PATH)) {
                    file.delete();
                }
            }
            return null;
        }
        this.mOrientation = JpegExifReader.readOrientation(absolutePath);
        DownloadParams downloadParams7 = this.mParams;
        DownloadParams.DecodeHandler decodeHandler = downloadParams7.mDecodeHandler;
        if (decodeHandler != null) {
            bitmap = decodeHandler.run(downloadParams7, decodeFile);
        } else {
            bitmap = decodeFile;
        }
        if (SliceBitmap.needSlice(bitmap)) {
            SliceBitmap sliceBitmap = new SliceBitmap(bitmap);
            bitmap.recycle();
            return sliceBitmap;
        }
        return bitmap;
    }

    private static StringBuilder getAppStack(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb5 = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            String stackTraceElement2 = stackTraceElement.toString();
            if (isQQStackFrame(stackTraceElement2)) {
                if (sb5.length() == 0) {
                    sb5.append("[");
                } else {
                    sb5.append(",");
                }
                sb5.append(stackTraceElement2);
            }
        }
        if (sb5.length() > 0) {
            sb5.append("]");
        }
        return sb5;
    }

    static URLState getConstants(String str) {
        synchronized (URLDrawable.depImp.mCache) {
            WeakReference<URLState> weakReference = sUnFinishImageCache.get(str);
            if (weakReference != null && weakReference.get() != null) {
                return weakReference.get();
            }
            Pair pair = (Pair) URLDrawable.depImp.mCache.get(str);
            if (pair == null) {
                return null;
            }
            Object obj = pair.first;
            if (obj instanceof URLState) {
                return (URLState) obj;
            }
            return null;
        }
    }

    private static int getImageByteSize(Object obj) {
        if (obj instanceof Bitmap) {
            return Utils.getBitmapSize((Bitmap) obj);
        }
        if (obj instanceof SliceBitmap) {
            return ((SliceBitmap) obj).getByteCount();
        }
        if (obj instanceof AbstractGifImage) {
            return ((AbstractGifImage) obj).getByteSize();
        }
        if (NativeVideoImage.class.isInstance(obj)) {
            return ((NativeVideoImage) obj).getByteSize();
        }
        if (RoundRectBitmap.class.isInstance(obj)) {
            return ((RoundRectBitmap) obj).getByteSize();
        }
        if (obj instanceof ApngImage) {
            return ((ApngImage) obj).getByteSize();
        }
        if (obj instanceof SharpImage) {
            return ((SharpImage) obj).getByteSize();
        }
        return 1048576;
    }

    public static String getMemoryCacheKey(String str, URLDrawable.URLDrawableOptions uRLDrawableOptions) {
        StringBuilder sb5 = new StringBuilder(128);
        sb5.append(str);
        if (str.startsWith("qqlive://msgId")) {
            return str;
        }
        if (!str.startsWith("chatthumb") && uRLDrawableOptions.mKeyAddWHSuffix && uRLDrawableOptions.mRequestWidth != 0 && uRLDrawableOptions.mRequestHeight != 0) {
            sb5.append('#');
            sb5.append(uRLDrawableOptions.mRequestWidth);
            sb5.append("_");
            sb5.append(uRLDrawableOptions.mRequestHeight);
        }
        if (uRLDrawableOptions.mMemoryCacheKeySuffix != null) {
            sb5.append('#');
            sb5.append(uRLDrawableOptions.mMemoryCacheKeySuffix);
        }
        return sb5.toString();
    }

    private static boolean isQQStackFrame(String str) {
        for (String str2 : sSysTracePrefixs) {
            if (str.startsWith(str2)) {
                return false;
            }
        }
        return true;
    }

    private void pauseThread() {
        if (!this.mIgnorePause && Looper.myLooper() != Looper.getMainLooper()) {
            synchronized (URLDrawable.sPauseLock) {
                long currentTimeMillis = System.currentTimeMillis();
                while (URLDrawable.sPause && System.currentTimeMillis() - currentTimeMillis <= 10000) {
                    try {
                        if (URLDrawable.depImp.mLog.isColorLevel()) {
                            URLDrawable.depImp.mLog.d(URLDrawable.TAG, 2, "pauseThread:" + URLDrawable.sPause);
                        }
                        LockMethodProxy.wait(URLDrawable.sPauseLock);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void result(Object obj) {
        UI_HANDLER.post(new Runnable(obj) { // from class: com.tencent.image.URLState.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Object val$obj;

            {
                this.val$obj = obj;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) URLState.this, obj);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    URLState.this.onResult(this.val$obj);
                }
            }
        });
    }

    private boolean sharpSoLoad(URLDrawableHandler uRLDrawableHandler) {
        if (this.mParams.useSharpPAnimImage) {
            SharpSoLoader sharpSoLoader = URLDrawable.sDefaultDrawableParms.getSharpSoLoader();
            if (!sharpSoLoader.isLoaded()) {
                sharpSoLoader.load(new URLDrawableHandler.Adapter(uRLDrawableHandler) { // from class: com.tencent.image.URLState.4
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ URLDrawableHandler val$handler;

                    {
                        this.val$handler = uRLDrawableHandler;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) URLState.this, (Object) uRLDrawableHandler);
                        }
                    }

                    @Override // com.tencent.image.URLDrawableHandler.Adapter, com.tencent.image.URLDrawableHandler
                    public void onFileDownloadFailed(int i3) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                            iPatchRedirector.redirect((short) 3, (Object) this, i3);
                        } else {
                            URLState.this.mParams.useSharpPAnimImage = false;
                            onFileDownloadSucceed(0L);
                        }
                    }

                    @Override // com.tencent.image.URLDrawableHandler.Adapter, com.tencent.image.URLDrawableHandler
                    public void onFileDownloadSucceed(long j3) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, j3);
                            return;
                        }
                        try {
                            URLState uRLState = URLState.this;
                            Object loadImage = uRLState.loadImage(uRLState.mUrl, this.val$handler);
                            if (loadImage != URLState.DOWNLOAD_ASYNC) {
                                URLState.this.result(loadImage);
                            }
                        } catch (Throwable th5) {
                            URLDrawable.depImp.mLog.e(URLDrawable.TAG, 1, "SharpSoLoader error: ", th5);
                        }
                    }
                });
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addCallBack(Callback callback) {
        if (callback != null) {
            this.callbacks.add(new WeakReference<>(callback));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void downloadImediatly(Header[] headerArr, CookieStore cookieStore, Object obj, boolean z16, boolean z17, boolean z18, boolean z19, float f16, boolean z26, boolean z27, Object obj2, boolean z28, String str) {
        int i3;
        Handler handler;
        PostOnResult postOnResult;
        if (this.mStatus == 1 || (i3 = this.mIsLoadingStarted) > 0) {
            return;
        }
        this.mIsLoadingStarted = i3 + 1;
        this.mDecodeFile = z16;
        DownloadParams downloadParams = this.mParams;
        downloadParams.cookies = cookieStore;
        downloadParams.headers = headerArr;
        downloadParams.tag = obj;
        downloadParams.useGifAnimation = z17;
        downloadParams.useApngImage = z18;
        downloadParams.useSharpPImage = z19;
        downloadParams.useSharpPAnimImage = z27;
        downloadParams.useDynamicDrawable = z28;
        downloadParams.dynamicDrawableType = str;
        downloadParams.mGifRoundCorner = f16;
        downloadParams.needCheckNetType = false;
        downloadParams.useExifOrientation = z26;
        downloadParams.mExtraInfo = obj2;
        try {
            th = loadImage(this.mUrl, new URLDrawableHandler.Adapter());
        } catch (Throwable th5) {
            th = th5;
            if (th == DOWNLOAD_ASYNC) {
                return;
            }
            if (Looper.myLooper() != Looper.getMainLooper()) {
                handler = UI_HANDLER;
                postOnResult = new PostOnResult(th);
            }
        }
        if (th != DOWNLOAD_ASYNC) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                handler = UI_HANDLER;
                postOnResult = new PostOnResult(th);
                handler.post(postOnResult);
                return;
            }
            onResult(th);
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 0;
    }

    Object loadImage(URL url, URLDrawableHandler uRLDrawableHandler) throws Throwable {
        File file;
        long currentTimeMillis = System.currentTimeMillis();
        pauseThread();
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (URLDrawable.depImp.mLog.isColorLevel() && currentTimeMillis2 > 0) {
            URLDrawable.depImp.mLog.d("URLDrawable_Thread_pasueCost", 2, "DownloadAsyncTask pauseThread1 end : " + this.mUrlStr + ",cost=" + currentTimeMillis2);
        }
        if (this.mParams.useApngImage) {
            ApngSoLoader apngSoLoader = URLDrawable.sDefaultDrawableParms.getApngSoLoader();
            if (!apngSoLoader.isLoaded()) {
                apngSoLoader.load(new URLDrawableHandler.Adapter(uRLDrawableHandler) { // from class: com.tencent.image.URLState.2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ URLDrawableHandler val$handler;

                    {
                        this.val$handler = uRLDrawableHandler;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) URLState.this, (Object) uRLDrawableHandler);
                        }
                    }

                    @Override // com.tencent.image.URLDrawableHandler.Adapter, com.tencent.image.URLDrawableHandler
                    public void onFileDownloadFailed(int i3) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                            iPatchRedirector.redirect((short) 3, (Object) this, i3);
                        } else {
                            URLState.this.mParams.useApngImage = false;
                            onFileDownloadSucceed(0L);
                        }
                    }

                    @Override // com.tencent.image.URLDrawableHandler.Adapter, com.tencent.image.URLDrawableHandler
                    public void onFileDownloadSucceed(long j3) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, j3);
                            return;
                        }
                        try {
                            URLState uRLState = URLState.this;
                            Object loadImage = uRLState.loadImage(uRLState.mUrl, this.val$handler);
                            if (loadImage != URLState.DOWNLOAD_ASYNC) {
                                URLState.this.result(loadImage);
                            }
                        } catch (Throwable th5) {
                            URLDrawable.depImp.mLog.e(URLDrawable.TAG, 1, "ApngSoLoader error: ", th5);
                        }
                    }
                });
                return DOWNLOAD_ASYNC;
            }
        }
        if (sharpSoLoad(uRLDrawableHandler)) {
            return DOWNLOAD_ASYNC;
        }
        if (this.mProtocolDownloader != null) {
            if (URLDrawable.depImp.mLog.isColorLevel()) {
                URLDrawable.depImp.mLog.i(URLDrawable.TAG, 2, "call downloader loadImage." + this.mUrlStr);
            }
            if (!this.mProtocolDownloader.hasDiskFile(this.mParams)) {
                DownloadParams downloadParams = this.mParams;
                if (downloadParams.mHttpDownloaderParams != null) {
                    this.mProtocolDownloader.loadImageFile(downloadParams, new URLDrawableHandler.Adapter(url, uRLDrawableHandler) { // from class: com.tencent.image.URLState.3
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ URLDrawableHandler val$handler;
                        final /* synthetic */ URL val$url;

                        {
                            this.val$url = url;
                            this.val$handler = uRLDrawableHandler;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, this, URLState.this, url, uRLDrawableHandler);
                            }
                        }

                        @Override // com.tencent.image.URLDrawableHandler.Adapter, com.tencent.image.URLDrawableHandler
                        public void onFileDownloadFailed(int i3) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                                iPatchRedirector.redirect((short) 3, (Object) this, i3);
                                return;
                            }
                            super.onFileDownloadFailed(i3);
                            this.val$handler.onFileDownloadFailed(i3);
                            URLState.this.result(new HttpException(" http error code " + i3));
                        }

                        @Override // com.tencent.image.URLDrawableHandler.Adapter, com.tencent.image.URLDrawableHandler
                        public void onFileDownloadSucceed(long j3) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this, j3);
                                return;
                            }
                            super.onFileDownloadSucceed(j3);
                            if (URLDrawable.depImp.mLog.isColorLevel()) {
                                URLDrawable.depImp.mLog.i(URLDrawable.TAG, 2, "async onFileDownloadSucceed.");
                            }
                            try {
                                URLState uRLState = URLState.this;
                                if (uRLState.mProtocolDownloader.hasDiskFile(uRLState.mParams)) {
                                    URLState uRLState2 = URLState.this;
                                    PreDownloadRunnable preDownloadRunnable = uRLState2.mTask;
                                    if (preDownloadRunnable != null) {
                                        preDownloadRunnable.run();
                                        return;
                                    }
                                    Object loadImage = uRLState2.loadImage(this.val$url, this.val$handler);
                                    this.val$handler.onFileDownloadSucceed(j3);
                                    URLState.UI_HANDLER.post(new Runnable(loadImage) { // from class: com.tencent.image.URLState.3.1
                                        static IPatchRedirector $redirector_;
                                        final /* synthetic */ Object val$obj;

                                        {
                                            this.val$obj = loadImage;
                                            IPatchRedirector iPatchRedirector2 = $redirector_;
                                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this, loadImage);
                                            }
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            IPatchRedirector iPatchRedirector2 = $redirector_;
                                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                            } else {
                                                URLState.this.onResult(this.val$obj);
                                            }
                                        }
                                    });
                                }
                            } catch (Throwable th5) {
                                th5.printStackTrace();
                            }
                        }
                    });
                    return DOWNLOAD_ASYNC;
                }
            }
            file = this.mProtocolDownloader.loadImageFile(this.mParams, uRLDrawableHandler);
            if (file == null) {
                this.mCacheFile = null;
            } else {
                this.mCacheFile = file.getAbsolutePath();
            }
        } else {
            file = null;
        }
        synchronized (this.mDecodeFileLock) {
            if (!this.mDecodeFile) {
                this.mStatus = 4;
                this.mIsLoadingStarted--;
                return FILE_DOWNLOADED;
            }
            this.mStatus = 4;
            Object decodeFile = decodeFile(file, uRLDrawableHandler);
            if (decodeFile != null) {
                if (decodeFile instanceof Bitmap) {
                    RegionDrawable regionDrawable = new RegionDrawable((Resources) null, (Bitmap) decodeFile, this.mUrl.getPath());
                    regionDrawable.setDither(this.mDither);
                    this.mSuccessed = regionDrawable.getConstantState();
                } else if (decodeFile instanceof SliceBitmap) {
                    SliceBitmapDrawable.BitmapState bitmapState = new SliceBitmapDrawable.BitmapState((SliceBitmap) decodeFile);
                    bitmapState.mPaint.setDither(this.mDither);
                    this.mSuccessed = bitmapState;
                } else if (decodeFile instanceof AbstractGifImage) {
                    GifDrawable.GifState gifState = new GifDrawable.GifState((AbstractGifImage) decodeFile);
                    gifState.mPaint.setDither(this.mDither);
                    this.mSuccessed = gifState;
                } else if (decodeFile instanceof ApngImage) {
                    ApngDrawable.ApngState apngState = new ApngDrawable.ApngState((ApngImage) decodeFile);
                    apngState.mPaint.setDither(this.mDither);
                    this.mSuccessed = apngState;
                } else if (decodeFile instanceof RoundRectBitmap) {
                    RoundRectDrawable.RoundRectDrawableState roundRectDrawableState = new RoundRectDrawable.RoundRectDrawableState((RoundRectBitmap) decodeFile);
                    roundRectDrawableState.mBorderPaint.setDither(this.mDither);
                    roundRectDrawableState.mBitmapPaint.setDither(this.mDither);
                    this.mSuccessed = roundRectDrawableState;
                } else if (decodeFile instanceof AbstractVideoImage) {
                    VideoDrawable.VideoState videoState = new VideoDrawable.VideoState((AbstractVideoImage) decodeFile);
                    videoState.mPaint.setDither(this.mDither);
                    this.mSuccessed = videoState;
                } else if (decodeFile instanceof SharpImage) {
                    SharpDrawable.SharpState sharpState = new SharpDrawable.SharpState((SharpImage) decodeFile);
                    sharpState.mPaint.setDither(this.mDither);
                    this.mSuccessed = sharpState;
                } else if (decodeFile instanceof Drawable) {
                    this.mSuccessed = ((Drawable) decodeFile).getConstantState();
                } else {
                    throw new RuntimeException("Invalide image type " + decodeFile.getClass().getSimpleName());
                }
                Pair pair = new Pair(this, Integer.valueOf(getImageByteSize(decodeFile)));
                synchronized (URLDrawable.depImp.mCache) {
                    if (this.mUseUnFinishCache) {
                        sUnFinishImageCache.remove(this.mMemoryCacheKey);
                    }
                    if (this.mUseMemoryCache) {
                        URLDrawable.depImp.mCache.put(this.mMemoryCacheKey, pair, this.mPriority);
                    }
                }
                this.mStatus = 1;
            }
            long currentTimeMillis3 = System.currentTimeMillis();
            pauseThread();
            long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
            if (URLDrawable.depImp.mLog.isColorLevel() && currentTimeMillis4 > 0) {
                URLDrawable.depImp.mLog.d("URLDrawable_Thread_pasueCost", 2, "DownloadAsyncTask pauseThread2 end: " + this.mUrlStr + ",cost=" + currentTimeMillis4);
            }
            uRLDrawableHandler.publishProgress(10000);
            if (decodeFile != null) {
                if (this.mSuccessed != null) {
                    return decodeFile;
                }
                throw new NullPointerException("mSuccessed is null...");
            }
            throw new NullPointerException("bitmap decode failed");
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new URLDrawable(this, (Resources) null) : (Drawable) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    void onFileDownloaded() {
        int i3;
        if (URLDrawable.depImp.mLog.isColorLevel()) {
            URLDrawable.depImp.mLog.d(URLDrawable.TAG, 4, "download successed, URLState: " + this + " , url: " + this.mUrlStr + "\nnotify " + this.callbacks.size() + " callbacks");
        }
        synchronized (this.callbacks) {
            int i16 = 0;
            while (i16 < this.callbacks.size()) {
                WeakReference<Callback> weakReference = this.callbacks.get(i16);
                if (weakReference != null) {
                    Callback callback = weakReference.get();
                    if (callback != null) {
                        callback.onFileDownloaded(this);
                        i16++;
                    } else {
                        i3 = i16 - 1;
                        this.callbacks.remove(i16);
                    }
                } else {
                    i3 = i16 - 1;
                    this.callbacks.remove(i16);
                }
                i16 = i3;
                i16++;
            }
        }
    }

    void onLoadCancelled() {
        int i3;
        if (URLDrawable.depImp.mLog.isColorLevel()) {
            URLDrawable.depImp.mLog.i(URLDrawable.TAG, 2, "[onLoadCancelled]" + this.mUrlStr);
        }
        this.mStatus = 3;
        this.mIsLoadingStarted--;
        int i16 = 0;
        while (i16 < this.callbacks.size()) {
            synchronized (this.callbacks) {
                WeakReference<Callback> weakReference = this.callbacks.get(i16);
                if (weakReference != null) {
                    Callback callback = weakReference.get();
                    if (callback != null) {
                        callback.onLoadCanceled(this);
                    } else {
                        i3 = i16 - 1;
                        this.callbacks.remove(i16);
                    }
                } else {
                    i3 = i16 - 1;
                    this.callbacks.remove(i16);
                }
                i16 = i3;
            }
            i16++;
        }
    }

    void onLoadFailed(Throwable th5) {
        int i3;
        if (URLDrawable.depImp.mLog.isColorLevel()) {
            URLDrawable.depImp.mLog.e(URLDrawable.TAG, 4, wrapLog("URLState onLoadFailed():"), th5);
        }
        this.mStatus = 2;
        synchronized (this.callbacks) {
            int i16 = 0;
            while (i16 < this.callbacks.size()) {
                WeakReference<Callback> weakReference = this.callbacks.get(i16);
                if (weakReference != null) {
                    Callback callback = weakReference.get();
                    if (callback != null) {
                        callback.onLoadFailed(this, th5);
                        i16++;
                    } else {
                        i3 = i16 - 1;
                        this.callbacks.remove(i16);
                    }
                } else {
                    i3 = i16 - 1;
                    this.callbacks.remove(i16);
                }
                i16 = i3;
                i16++;
            }
        }
    }

    void onLoadStart() {
        int i3;
        synchronized (this.callbacks) {
            int i16 = 0;
            while (i16 < this.callbacks.size()) {
                WeakReference<Callback> weakReference = this.callbacks.get(i16);
                if (weakReference != null) {
                    Callback callback = weakReference.get();
                    if (callback != null) {
                        callback.onLoadStarted(this);
                        i16++;
                    } else {
                        i3 = i16 - 1;
                        this.callbacks.remove(i16);
                    }
                } else {
                    i3 = i16 - 1;
                    this.callbacks.remove(i16);
                }
                i16 = i3;
                i16++;
            }
        }
    }

    void onLoadSuccessed(Object obj) {
        Callback callback;
        if (this.mIsLoadingStarted == 0) {
            return;
        }
        synchronized (this.callbacks) {
            for (int i3 = 0; i3 < this.callbacks.size(); i3++) {
                WeakReference<Callback> weakReference = this.callbacks.get(i3);
                if (weakReference != null && (callback = weakReference.get()) != null) {
                    callback.onLoadSuccessed(this);
                }
            }
            this.callbacks.clear();
        }
    }

    void onResult(Object obj) {
        if (URLDrawable.depImp.mLog.isColorLevel()) {
            URLDrawable.depImp.mLog.d(URLDrawable.TAG, 2, "URLState.onResult " + obj + " " + this.mUrlStr);
        }
        if (obj == FILE_DOWNLOADED) {
            onFileDownloaded();
            return;
        }
        if (obj instanceof PendingIntent.CanceledException) {
            onLoadCancelled();
            return;
        }
        if (obj instanceof CustomError) {
            CustomError customError = (CustomError) obj;
            this.mCustomError = customError;
            onLoadFailed(customError);
        } else if (obj instanceof Throwable) {
            onLoadFailed((Throwable) obj);
        } else {
            onLoadSuccessed(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean reStartDownload(Header[] headerArr, CookieStore cookieStore, Object obj, boolean z16, boolean z17, boolean z18, boolean z19, float f16, boolean z26, boolean z27, Object obj2, boolean z28, String str) {
        int i3 = this.mStatus;
        if (i3 != 2 && i3 != 3) {
            return false;
        }
        this.mIsLoadingStarted = 0;
        this.mStatus = 0;
        startDownload(headerArr, cookieStore, obj, z16, z17, z18, z19, f16, z26, z27, obj2, z28, str);
        return true;
    }

    void removeCallBack(Callback callback) {
        int i3;
        synchronized (this.callbacks) {
            int i16 = 0;
            while (i16 < this.callbacks.size()) {
                WeakReference<Callback> weakReference = this.callbacks.get(i16);
                if (weakReference != null) {
                    Callback callback2 = weakReference.get();
                    if ((callback2 != null && callback2 == callback) || callback2 == null) {
                        i3 = i16 - 1;
                        this.callbacks.remove(i16);
                    } else {
                        i16++;
                    }
                } else {
                    i3 = i16 - 1;
                    this.callbacks.remove(i16);
                }
                i16 = i3;
                i16++;
            }
        }
    }

    public String saveTo(String str) throws IOException {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        if (!TextUtils.isEmpty(this.mCacheFile)) {
            File file = new File(this.mCacheFile);
            if (str.indexOf(".") == -1) {
                if (this.mSuccessed instanceof GifDrawable.GifState) {
                    str2 = QzoneEmotionUtils.SIGN_ICON_URL_END;
                } else {
                    str2 = ".jpg";
                }
                str = str + str2;
            }
            Utils.copyFile(file, new File(str));
            return str;
        }
        throw new FileNotFoundException("File is not download complete, please check getStatus() == URLDrawable.SUCCESSED first. ");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startDownload(Header[] headerArr, CookieStore cookieStore, Object obj, boolean z16, boolean z17, boolean z18, boolean z19, float f16, boolean z26, boolean z27, Object obj2, boolean z28, String str) {
        if (this.mProtocolDownloader == null) {
            onLoadFailed(new NullPointerException("mProtocolDownloader is null"));
            return;
        }
        int i3 = this.mIsLoadingStarted;
        if (i3 == 0) {
            if (URLDrawable.depImp.mLog.isColorLevel()) {
                URLDrawable.depImp.mLog.d(URLDrawable.TAG, 2, "URLState.startDownload:" + this.mUrlStr);
            }
            this.mIsLoadingStarted++;
            this.mDecodeFile = z16;
            DownloadParams downloadParams = this.mParams;
            downloadParams.cookies = cookieStore;
            downloadParams.headers = headerArr;
            downloadParams.tag = obj;
            downloadParams.useGifAnimation = z17;
            downloadParams.useApngImage = z18;
            downloadParams.useSharpPAnimImage = z27;
            downloadParams.useDynamicDrawable = z28;
            downloadParams.dynamicDrawableType = str;
            downloadParams.useSharpPImage = z19;
            downloadParams.mGifRoundCorner = f16;
            downloadParams.useExifOrientation = z26;
            downloadParams.mExtraInfo = obj2;
            PreDownloadRunnable preDownloadRunnable = new PreDownloadRunnable(this.mUrl);
            URLDrawable.depImp.mThreadManager.executeOnFileThreadExcutor(preDownloadRunnable, null, false);
            this.mTask = preDownloadRunnable;
            return;
        }
        if (!this.mDecodeFile && z16) {
            synchronized (this.mDecodeFileLock) {
                if (this.mStatus == 0) {
                    this.mDecodeFile = true;
                    return;
                } else {
                    if (this.mIsLoadingStarted == 0) {
                        startDownload(headerArr, cookieStore, obj, z16, z17, z18, z19, f16, z26, z27, obj2, z28, str);
                        return;
                    }
                    return;
                }
            }
        }
        if (i3 <= 1 || !URLDrawable.depImp.mLog.isColorLevel()) {
            return;
        }
        URLDrawable.depImp.mLog.i(URLDrawable.TAG, 2, "startDownload mIsLoadingStarted is " + this.mIsLoadingStarted);
    }

    String wrapLog(String str) {
        return str + "\n  |- URLState:" + this + "\n  |- url:" + this.mUrlStr + "\n  |- callbacks:" + this.callbacks.size();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? new URLDrawable(this, resources) : (Drawable) iPatchRedirector.redirect((short) 4, (Object) this, (Object) resources);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static URLState getConstants(String str, URLDrawable.URLDrawableOptions uRLDrawableOptions) {
        synchronized (URLDrawable.depImp.mCache) {
            String memoryCacheKey = getMemoryCacheKey(str, uRLDrawableOptions);
            WeakReference<URLState> weakReference = sUnFinishImageCache.get(memoryCacheKey);
            if (weakReference != null && weakReference.get() != null) {
                if (uRLDrawableOptions.isFlashPic != weakReference.get().isFlashPicNeedCache) {
                    return null;
                }
                return weakReference.get();
            }
            Pair pair = (Pair) URLDrawable.depImp.mCache.get(memoryCacheKey);
            if (pair != null) {
                Object obj = pair.first;
                if ((obj instanceof URLState) && uRLDrawableOptions.isFlashPic == ((URLState) obj).isFlashPicNeedCache) {
                    return (URLState) obj;
                }
                return null;
            }
            return null;
        }
    }
}
