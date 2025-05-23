package com.tencent.image.api;

import android.os.HandlerThread;
import android.util.Log;
import android.util.LruCache;
import android.util.Pair;
import com.tencent.image.BuildConfig;
import com.tencent.image.ReportBean;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes7.dex */
public class URLDrawableDepWrap {
    static IPatchRedirector $redirector_;
    public ICache mCache;
    public ILog mLog;
    public IReport mReport;
    public IThreadManager mThreadManager;
    public ITool mTool;
    public IVersion mVersion;

    public URLDrawableDepWrap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void defaultInit(ITool iTool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iTool);
            return;
        }
        initCache();
        initLog();
        initThreadManager();
        initReport();
        initVersion();
        this.mTool = iTool;
    }

    void initCache() {
        this.mCache = new ICache() { // from class: com.tencent.image.api.URLDrawableDepWrap.1
            static IPatchRedirector $redirector_;
            LruCache<String, Object> mLruCache;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) URLDrawableDepWrap.this);
                } else {
                    this.mLruCache = new LruCache<String, Object>(104857600) { // from class: com.tencent.image.api.URLDrawableDepWrap.1.1
                        static IPatchRedirector $redirector_;

                        {
                            super(r5);
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, r5);
                            }
                        }

                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // android.util.LruCache
                        public int sizeOf(String str, Object obj) {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                return ((Integer) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) str, obj)).intValue();
                            }
                            if (obj == null || !(obj instanceof Pair)) {
                                return 100;
                            }
                            return ((Integer) ((Pair) obj).second).intValue();
                        }
                    };
                }
            }

            @Override // com.tencent.image.api.ICache
            public void evictAll() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, (Object) this);
                } else {
                    this.mLruCache.evictAll();
                }
            }

            @Override // com.tencent.image.api.ICache
            public Object get(String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                }
                return this.mLruCache.get(str);
            }

            @Override // com.tencent.image.api.ICache
            public byte getNormalPriority() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    return ((Byte) iPatchRedirector.redirect((short) 6, (Object) this)).byteValue();
                }
                return (byte) 0;
            }

            @Override // com.tencent.image.api.ICache
            public Object put(String str, Object obj, byte b16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return iPatchRedirector.redirect((short) 3, this, str, obj, Byte.valueOf(b16));
                }
                return null;
            }

            @Override // com.tencent.image.api.ICache
            public void remove(String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
                } else {
                    this.mLruCache.remove(str);
                }
            }
        };
    }

    void initLog() {
        this.mLog = new ILog() { // from class: com.tencent.image.api.URLDrawableDepWrap.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) URLDrawableDepWrap.this);
                }
            }

            @Override // com.tencent.image.api.ILog
            public void d(String str, int i3, String str2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), str2);
                } else {
                    Log.d(str, str2);
                }
            }

            @Override // com.tencent.image.api.ILog
            public void e(String str, int i3, String str2, Throwable th5) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                    Log.e(str, str2, th5);
                } else {
                    iPatchRedirector.redirect((short) 6, this, str, Integer.valueOf(i3), str2, th5);
                }
            }

            @Override // com.tencent.image.api.ILog
            public void i(String str, int i3, String str2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                    Log.i(str, str2);
                } else {
                    iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), str2);
                }
            }

            @Override // com.tencent.image.api.ILog
            public boolean isColorLevel() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                return BuildConfig.DEBUG;
            }

            @Override // com.tencent.image.api.ILog
            public void w(String str, int i3, String str2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                    Log.w(str, str2);
                } else {
                    iPatchRedirector.redirect((short) 8, this, str, Integer.valueOf(i3), str2);
                }
            }

            @Override // com.tencent.image.api.ILog
            public void e(String str, int i3, String str2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                    Log.e(str, str2);
                } else {
                    iPatchRedirector.redirect((short) 7, this, str, Integer.valueOf(i3), str2);
                }
            }

            @Override // com.tencent.image.api.ILog
            public void i(String str, int i3, String str2, Throwable th5) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                    Log.d(str, str2, th5);
                } else {
                    iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), str2, th5);
                }
            }

            @Override // com.tencent.image.api.ILog
            public void w(String str, int i3, Throwable th5) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
                    Log.w(str, th5);
                } else {
                    iPatchRedirector.redirect((short) 9, this, str, Integer.valueOf(i3), th5);
                }
            }
        };
    }

    public void initReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.mReport = new IReport() { // from class: com.tencent.image.api.URLDrawableDepWrap.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) URLDrawableDepWrap.this);
                    }
                }

                @Override // com.tencent.image.api.IReport
                public void debug(int i3, Object obj) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this, i3, obj);
                    }
                }

                @Override // com.tencent.image.api.IReport
                public void report(ReportBean reportBean) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) reportBean);
                    }
                }

                @Override // com.tencent.image.api.IReport
                public void reportEvent(ReportEventBean reportEventBean) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                        iPatchRedirector2.redirect((short) 5, (Object) this, (Object) reportEventBean);
                    }
                }

                @Override // com.tencent.image.api.IReport
                public void reportException(String str, String str2) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                        iPatchRedirector2.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
                    }
                }
            };
        }
    }

    void initThreadManager() {
        IThreadManager iThreadManager = new IThreadManager() { // from class: com.tencent.image.api.URLDrawableDepWrap.3
            static IPatchRedirector $redirector_;
            final int BLOCKING_QUEUE_SIZE;
            final int KEEP_ALIVE_TIME;
            final int corePoolSize;
            ThreadPoolExecutor fileThreadExecutor;
            HandlerThread mFileThread;
            HandlerThread mSubThread;
            final int maxPoolSize;
            ThreadPoolExecutor netThreadExecutor;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) URLDrawableDepWrap.this);
                    return;
                }
                this.corePoolSize = 5;
                int max = Math.max(Runtime.getRuntime().availableProcessors() + 1, 5);
                this.maxPoolSize = max;
                this.KEEP_ALIVE_TIME = 2;
                this.BLOCKING_QUEUE_SIZE = 64;
                TimeUnit timeUnit = TimeUnit.SECONDS;
                this.fileThreadExecutor = new BaseThreadPoolExecutor(5, max, 2L, timeUnit, new LinkedBlockingQueue(64));
                this.netThreadExecutor = new BaseThreadPoolExecutor(5, max, 2L, timeUnit, new LinkedBlockingQueue(64));
                this.mSubThread = new BaseHandlerThread("urldrawable-sub");
                this.mFileThread = new BaseHandlerThread("urldrawable-file");
            }

            @Override // com.tencent.image.api.IThreadManager
            public void executeOnFileThreadExcutor(Runnable runnable, IThreadListener iThreadListener, boolean z16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, this, runnable, iThreadListener, Boolean.valueOf(z16));
                } else {
                    this.fileThreadExecutor.execute(runnable);
                }
            }

            @Override // com.tencent.image.api.IThreadManager
            public void executeOnNetThreadExcutor(Runnable runnable, IThreadListener iThreadListener, boolean z16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, this, runnable, iThreadListener, Boolean.valueOf(z16));
                } else {
                    this.netThreadExecutor.execute(runnable);
                }
            }

            @Override // com.tencent.image.api.IThreadManager
            public HandlerThread getFileThread() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (HandlerThread) iPatchRedirector.redirect((short) 5, (Object) this);
                }
                return this.mFileThread;
            }

            @Override // com.tencent.image.api.IThreadManager
            public HandlerThread getSubThread() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (HandlerThread) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return this.mSubThread;
            }
        };
        this.mThreadManager = iThreadManager;
        iThreadManager.getSubThread().start();
        this.mThreadManager.getFileThread().start();
    }

    public void initVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.mVersion = new IVersion() { // from class: com.tencent.image.api.URLDrawableDepWrap.5
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) URLDrawableDepWrap.this);
                    }
                }

                @Override // com.tencent.image.api.IVersion
                public boolean isPublicVersion() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return ((Boolean) iPatchRedirector2.redirect((short) 2, (Object) this)).booleanValue();
                    }
                    return true;
                }
            };
        }
    }
}
