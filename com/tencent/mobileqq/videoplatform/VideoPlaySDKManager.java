package com.tencent.mobileqq.videoplatform;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.videoplatform.api.ILoadSo;
import com.tencent.mobileqq.videoplatform.api.LoadSoCallback;
import com.tencent.mobileqq.videoplatform.util.LoadSoUtil;
import com.tencent.mobileqq.videoplatform.util.LogUtil;
import com.tencent.mobileqq.videoplatform.util.RegisterTVideoUtil;
import com.tencent.mobileqq.videoplatform.util.ThreadUtil;
import com.tencent.superplayer.api.ISuperModuleLoader;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.api.SuperPlayerSdkOption;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes20.dex */
public class VideoPlaySDKManager {
    static IPatchRedirector $redirector_ = null;
    public static final int BIZID = 20160518;
    public static final int ERR_CODE_FILE_EXPIRED = 14011001;
    public static final int ERR_VIDEO_FILE_DAMAGED = 11022003;
    private static final int PLATFORM_ID = 170303;
    private static final String TAG = "[VideoPlatForm]VideoPlaySDKManager";
    private static volatile VideoPlaySDKManager mInstance;
    private final Set<SDKInitListener> mDownloadSDKInstalledListenerSet;
    private AtomicInteger mDownloadSDKState;
    private volatile boolean mHadInjectDelegate;
    private boolean mIsDownloadSoLoadSuc;
    private boolean mIsSoLoadSuc;
    private Set<SDKInitListener> mSDKInstalledListenerSet;
    private AtomicInteger mState;
    private final Set<SDKInitListener> mSystemPlayerSDKListenerSet;
    private AtomicInteger mSystemPlayerSDKState;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class a implements SuperPlayerSDKMgr.ILogListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VideoPlaySDKManager.this);
            }
        }

        @Override // com.tencent.superplayer.api.SuperPlayerSDKMgr.ILogListener
        public int d(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2)).intValue();
            }
            if (LogUtil.isColorLevel()) {
                LogUtil.d(str, 2, str2);
                return 0;
            }
            return 0;
        }

        @Override // com.tencent.superplayer.api.SuperPlayerSDKMgr.ILogListener
        public int e(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2)).intValue();
            }
            LogUtil.e(str, 1, str2);
            return 0;
        }

        @Override // com.tencent.superplayer.api.SuperPlayerSDKMgr.ILogListener
        public int i(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2)).intValue();
            }
            if (LogUtil.isColorLevel()) {
                LogUtil.i(str, 2, str2);
                return 0;
            }
            return 0;
        }

        @Override // com.tencent.superplayer.api.SuperPlayerSDKMgr.ILogListener
        public int v(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2)).intValue();
            }
            if (LogUtil.isColorLevel()) {
                LogUtil.v(str, 2, str2);
                return 0;
            }
            return 0;
        }

        @Override // com.tencent.superplayer.api.SuperPlayerSDKMgr.ILogListener
        public int w(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2)).intValue();
            }
            if (LogUtil.isColorLevel()) {
                LogUtil.w(str, 2, str2);
                return 0;
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class b implements ISuperModuleLoader {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VideoPlaySDKManager.this);
            }
        }

        @Override // com.tencent.superplayer.api.ISuperModuleLoader
        public void loadLibrary(String str, String str2) {
            RuntimeException runtimeException;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
                return;
            }
            if (LogUtil.isColorLevel()) {
                LogUtil.d(VideoPlaySDKManager.TAG, 2, "loadLibrary, libName = " + str + " , apkSoVer = " + str2);
            }
            if (!LoadSoUtil.isTPCoreLoad() && str.equals(ILoadSo.SONAME_TPCORE_MASTER) && !LoadSoUtil.loadTPCoreSync()) {
                try {
                    throw new Throwable("LoadSoUtil.loadTPCoreSync error.");
                } finally {
                }
            } else if (!LoadSoUtil.isDownProxyLoad() && str.equals("DownloadProxy") && !LoadSoUtil.loadDownProxySync()) {
                try {
                    throw new Throwable("LoadSoUtil.loadDownProxySync error.");
                } finally {
                }
            }
        }
    }

    public VideoPlaySDKManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mState = new AtomicInteger(0);
        this.mDownloadSDKState = new AtomicInteger(0);
        this.mSystemPlayerSDKState = new AtomicInteger(0);
        this.mHadInjectDelegate = false;
        this.mSDKInstalledListenerSet = new HashSet();
        this.mDownloadSDKInstalledListenerSet = new HashSet();
        this.mSystemPlayerSDKListenerSet = new HashSet();
    }

    private ISuperModuleLoader buildLoader() {
        return new b();
    }

    private SuperPlayerSDKMgr.ILogListener buildLogListener() {
        return new a();
    }

    private synchronized boolean checkInitStateAndNotify(AtomicInteger atomicInteger, boolean z16, SDKInitListener sDKInitListener, Set<SDKInitListener> set) {
        if (atomicInteger.get() == 1) {
            if (sDKInitListener != null) {
                set.add(sDKInitListener);
            }
            if (LogUtil.isColorLevel()) {
                LogUtil.d(TAG, 2, "checkSDKNeedInit, mState.get() = " + atomicInteger.get() + " , sdk is initing,return.");
            }
            return true;
        }
        if (atomicInteger.get() == 2 && (isSoLoadSuc() || !z16)) {
            if (LogUtil.isColorLevel()) {
                LogUtil.d(TAG, 2, "checkSDKNeedInit, mState.get() = " + atomicInteger.get() + " , sdk has succeed ,return.");
            }
            if (sDKInitListener != null) {
                sDKInitListener.onSDKInited(true);
                set.remove(sDKInitListener);
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dispatchEventAndClear(Set<SDKInitListener> set, boolean z16) {
        if (set != null) {
            Iterator<SDKInitListener> it = set.iterator();
            while (it.hasNext()) {
                it.next().onSDKInited(z16);
            }
            set.clear();
        }
    }

    private static String getCacheDir(Context context) {
        return context.getApplicationContext().getExternalCacheDir() + "/superplayer";
    }

    public static VideoPlaySDKManager getInstance() {
        if (mInstance == null) {
            synchronized (VideoPlaySDKManager.class) {
                if (mInstance == null) {
                    mInstance = new VideoPlaySDKManager();
                }
            }
        }
        return mInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initDownloadSDKOnly(Context context, SuperPlayerSdkOption superPlayerSdkOption) {
        if (context == null) {
            return;
        }
        injectDelegateForSDK();
        SuperPlayerSDKMgr.initSDKForDownload(context, 170303, getCacheDir(context), superPlayerSdkOption);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSDK(Context context, SuperPlayerSdkOption superPlayerSdkOption) {
        if (context == null) {
            return;
        }
        injectDelegateForSDK();
        SuperPlayerSDKMgr.initSDK(context, 170303, getCacheDir(context), superPlayerSdkOption);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSystemPlayerOnly(Context context, SuperPlayerSdkOption superPlayerSdkOption) {
        if (context == null) {
            return;
        }
        injectDelegateForSDK();
        SuperPlayerSDKMgr.initSDKForSystemPlayer(context, 170303, getCacheDir(context), superPlayerSdkOption);
    }

    private synchronized void injectDelegateForSDK() {
        if (this.mHadInjectDelegate) {
            return;
        }
        this.mHadInjectDelegate = true;
        try {
            SuperPlayerSDKMgr.setLibLoader(buildLoader());
        } catch (Exception e16) {
            LogUtil.e(TAG, 1, "setLibLoader err.", e16);
        }
        SuperPlayerSDKMgr.setOnLogListener(buildLogListener());
    }

    public synchronized void addDownloadSDKInstalledListener(SDKInitListener sDKInitListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) sDKInitListener);
        } else {
            if (sDKInitListener != null) {
                this.mDownloadSDKInstalledListenerSet.add(sDKInitListener);
            }
        }
    }

    public void addSDKInstalledListener(SDKInitListener sDKInitListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) sDKInitListener);
        } else if (sDKInitListener != null) {
            this.mSDKInstalledListenerSet.add(sDKInitListener);
        }
    }

    public synchronized void addSystemPlayerSDKInstalledListener(SDKInitListener sDKInitListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) sDKInitListener);
        } else {
            if (sDKInitListener != null) {
                this.mSystemPlayerSDKListenerSet.add(sDKInitListener);
            }
        }
    }

    public synchronized void initDownloadSDKAsync(Context context, SuperPlayerSdkOption superPlayerSdkOption, SDKInitListener sDKInitListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, context, superPlayerSdkOption, sDKInitListener);
            return;
        }
        if (checkInitStateAndNotify(this.mState, true, sDKInitListener, this.mDownloadSDKInstalledListenerSet)) {
            return;
        }
        if (checkInitStateAndNotify(this.mDownloadSDKState, false, sDKInitListener, this.mDownloadSDKInstalledListenerSet)) {
            return;
        }
        addDownloadSDKInstalledListener(sDKInitListener);
        this.mDownloadSDKState.set(1);
        LoadSoUtil.loadDownProxyAsync(new LoadSoCallback(context, superPlayerSdkOption) { // from class: com.tencent.mobileqq.videoplatform.VideoPlaySDKManager.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ Context val$context;
            final /* synthetic */ SuperPlayerSdkOption val$option;

            {
                this.val$context = context;
                this.val$option = superPlayerSdkOption;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, VideoPlaySDKManager.this, context, superPlayerSdkOption);
                }
            }

            @Override // com.tencent.mobileqq.videoplatform.api.LoadSoCallback
            public void onLoad(boolean z16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    VideoPlaySDKManager.this.mIsDownloadSoLoadSuc = z16;
                    ThreadUtil.postOnSubThread(new Runnable(z16) { // from class: com.tencent.mobileqq.videoplatform.VideoPlaySDKManager.2.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ boolean f312676d;

                        {
                            this.f312676d = z16;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, this, AnonymousClass2.this, Boolean.valueOf(z16));
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            VideoPlaySDKManager.this.initDownloadSDKOnly(anonymousClass2.val$context, anonymousClass2.val$option);
                            VideoPlaySDKManager.this.mDownloadSDKState.set(2);
                            VideoPlaySDKManager videoPlaySDKManager = VideoPlaySDKManager.this;
                            videoPlaySDKManager.dispatchEventAndClear(videoPlaySDKManager.mDownloadSDKInstalledListenerSet, this.f312676d);
                            if (VideoPlaySDKManager.this.mState.get() == 0) {
                                LoadSoUtil.preloadSo();
                            }
                        }
                    });
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, z16);
                }
            }
        });
    }

    public synchronized void initSDKAfterSystemPlayerAsync(Context context, SuperPlayerSdkOption superPlayerSdkOption, SDKInitListener sDKInitListener, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, context, superPlayerSdkOption, sDKInitListener, Boolean.valueOf(z16));
            return;
        }
        if (isSDKReady()) {
            if (sDKInitListener != null) {
                sDKInitListener.onSDKInited(true);
            }
        } else if (LoadSoUtil.isAllSoExist() && z16) {
            initSDKAsync(context, superPlayerSdkOption, sDKInitListener);
        } else {
            if (checkInitStateAndNotify(this.mSystemPlayerSDKState, false, sDKInitListener, this.mSystemPlayerSDKListenerSet)) {
                return;
            }
            addSystemPlayerSDKInstalledListener(sDKInitListener);
            this.mSystemPlayerSDKState.set(1);
            ThreadUtil.postOnSubThread(new Runnable(context, superPlayerSdkOption) { // from class: com.tencent.mobileqq.videoplatform.VideoPlaySDKManager.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ Context val$context;
                final /* synthetic */ SuperPlayerSdkOption val$option;

                {
                    this.val$context = context;
                    this.val$option = superPlayerSdkOption;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, VideoPlaySDKManager.this, context, superPlayerSdkOption);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        VideoPlaySDKManager.this.initSystemPlayerOnly(this.val$context, this.val$option);
                        VideoPlaySDKManager.this.mSystemPlayerSDKState.set(2);
                        VideoPlaySDKManager videoPlaySDKManager = VideoPlaySDKManager.this;
                        videoPlaySDKManager.dispatchEventAndClear(videoPlaySDKManager.mSystemPlayerSDKListenerSet, true);
                        VideoPlaySDKManager.this.initSDKAsync(this.val$context, this.val$option, null);
                        return;
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
        }
    }

    public synchronized void initSDKAsync(Context context, SDKInitListener sDKInitListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            initSDKAsync(context, SuperPlayerSdkOption.option(), sDKInitListener);
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) sDKInitListener);
        }
    }

    public boolean isDownloadSDKReady() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.mDownloadSDKState.get() != 2 && !isSDKReady()) {
            return false;
        }
        return true;
    }

    public boolean isSDKReady() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this.mState.get() == 2) {
            return true;
        }
        return false;
    }

    public boolean isSoLoadSuc() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.mIsSoLoadSuc;
    }

    public synchronized void removeDownloadSDKInstalledListener(SDKInitListener sDKInitListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) sDKInitListener);
        } else {
            this.mDownloadSDKInstalledListenerSet.remove(sDKInitListener);
        }
    }

    public synchronized void removeSDKInstalledListener(SDKInitListener sDKInitListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) sDKInitListener);
        } else {
            this.mSDKInstalledListenerSet.remove(sDKInitListener);
        }
    }

    public synchronized void removeSystemPlayerSDKInstalledListener(SDKInitListener sDKInitListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) sDKInitListener);
        } else {
            if (sDKInitListener != null) {
                this.mSystemPlayerSDKListenerSet.remove(sDKInitListener);
            }
        }
    }

    public synchronized void initSDKAsync(Context context, SuperPlayerSdkOption superPlayerSdkOption, SDKInitListener sDKInitListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, context, superPlayerSdkOption, sDKInitListener);
        } else {
            if (checkInitStateAndNotify(this.mState, true, sDKInitListener, this.mSDKInstalledListenerSet)) {
                return;
            }
            addSDKInstalledListener(sDKInitListener);
            this.mState.set(1);
            LoadSoUtil.loadSo(new LoadSoCallback(context, superPlayerSdkOption) { // from class: com.tencent.mobileqq.videoplatform.VideoPlaySDKManager.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Context val$context;
                final /* synthetic */ SuperPlayerSdkOption val$option;

                {
                    this.val$context = context;
                    this.val$option = superPlayerSdkOption;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, VideoPlaySDKManager.this, context, superPlayerSdkOption);
                    }
                }

                @Override // com.tencent.mobileqq.videoplatform.api.LoadSoCallback
                public void onLoad(boolean z16) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        VideoPlaySDKManager.this.mIsSoLoadSuc = z16;
                        ThreadUtil.postOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.videoplatform.VideoPlaySDKManager.1.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                    return;
                                }
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                VideoPlaySDKManager.this.initSDK(anonymousClass1.val$context, anonymousClass1.val$option);
                                RegisterTVideoUtil.registerTVideo();
                                VideoPlaySDKManager.this.mState.set(2);
                                VideoPlaySDKManager videoPlaySDKManager = VideoPlaySDKManager.this;
                                videoPlaySDKManager.dispatchEventAndClear(videoPlaySDKManager.mSDKInstalledListenerSet, true);
                                VideoPlaySDKManager videoPlaySDKManager2 = VideoPlaySDKManager.this;
                                videoPlaySDKManager2.dispatchEventAndClear(videoPlaySDKManager2.mDownloadSDKInstalledListenerSet, true);
                                VideoPlaySDKManager videoPlaySDKManager3 = VideoPlaySDKManager.this;
                                videoPlaySDKManager3.dispatchEventAndClear(videoPlaySDKManager3.mSystemPlayerSDKListenerSet, true);
                            }
                        });
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this, z16);
                    }
                }
            });
        }
    }
}
