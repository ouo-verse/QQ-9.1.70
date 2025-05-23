package com.tencent.rfix.lib;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Pair;
import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.rdelivery.RDelivery;
import com.tencent.rfix.lib.engine.PatchEngineBase;
import com.tencent.rfix.loader.RFixLoaderImmediate;
import com.tencent.rfix.loader.entity.RFixLoadResult;
import com.tencent.rfix.loader.log.RFixLog;
import com.tencent.rfix.loader.storage.RFixGlobalPreferences;
import com.tencent.rfix.loader.thread.RFixThreadPool;
import com.tencent.rfix.loader.utils.PatchFileUtils;
import com.tencent.rfix.loader.verify.RemoteVerifyInfo;
import iz3.e;
import java.io.File;

/* compiled from: P */
@Keep
/* loaded from: classes25.dex */
public class RFix {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "RFix.RFix";
    private static volatile boolean sInitialized;

    @SuppressLint({"StaticFieldLeak"})
    private static volatile RFix sInstance;
    private final com.tencent.rfix.lib.config.b configManager;
    private final Context context;
    private final com.tencent.rfix.lib.event.a eventDispatcher;
    private com.tencent.rfix.lib.reporter.b loadReporter;
    private RFixLoadResult loadResult;
    private final RFixParams params;
    private final File patchDirectory;
    private final com.tencent.rfix.lib.download.a patchDownloader;
    private final com.tencent.rfix.lib.engine.a patchEngine;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final Context f364908a;

        /* renamed from: b, reason: collision with root package name */
        private final RFixLoadResult f364909b;

        /* renamed from: c, reason: collision with root package name */
        private final RFixParams f364910c;

        /* renamed from: d, reason: collision with root package name */
        private final File f364911d;

        /* renamed from: e, reason: collision with root package name */
        private com.tencent.rfix.lib.config.b f364912e;

        /* renamed from: f, reason: collision with root package name */
        private com.tencent.rfix.lib.download.a f364913f;

        /* renamed from: g, reason: collision with root package name */
        private com.tencent.rfix.lib.engine.a f364914g;

        /* renamed from: h, reason: collision with root package name */
        private RFixListener f364915h;

        public b(Context context, RFixLoadResult rFixLoadResult, RFixParams rFixParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, context, rFixLoadResult, rFixParams);
                return;
            }
            if (context != null) {
                if (rFixLoadResult != null) {
                    if (rFixParams != null) {
                        this.f364908a = context;
                        this.f364909b = rFixLoadResult;
                        this.f364910c = rFixParams;
                        this.f364911d = PatchFileUtils.getPatchDirectory(context);
                        return;
                    }
                    throw new RuntimeException("params must not be null.");
                }
                throw new RuntimeException("loadResult must not be null.");
            }
            throw new RuntimeException("context must not be null.");
        }

        public RFix a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (RFix) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            if (this.f364912e == null) {
                this.f364912e = new com.tencent.rfix.lib.config.a(this.f364908a);
            }
            if (this.f364913f == null) {
                this.f364913f = new com.tencent.rfix.lib.download.b(this.f364908a);
            }
            if (this.f364914g == null) {
                this.f364914g = new PatchEngineBase(this.f364908a);
            }
            return new RFix(this.f364908a, this.f364909b, this.f364910c, this.f364911d, this.f364912e, this.f364913f, this.f364914g, this.f364915h, null);
        }

        public b b(RFixListener rFixListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (b) iPatchRedirector.redirect((short) 5, (Object) this, (Object) rFixListener);
            }
            this.f364915h = rFixListener;
            return this;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8524);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            sInitialized = false;
        }
    }

    /* synthetic */ RFix(Context context, RFixLoadResult rFixLoadResult, RFixParams rFixParams, File file, com.tencent.rfix.lib.config.b bVar, com.tencent.rfix.lib.download.a aVar, com.tencent.rfix.lib.engine.a aVar2, RFixListener rFixListener, a aVar3) {
        this(context, rFixLoadResult, rFixParams, file, bVar, aVar, aVar2, rFixListener);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
            return;
        }
        iPatchRedirector.redirect((short) 16, this, context, rFixLoadResult, rFixParams, file, bVar, aVar, aVar2, rFixListener, aVar3);
    }

    public static void bind(RFix rFix) {
        if (sInstance == null) {
            sInstance = rFix;
            sInitialized = true;
            rFix.onBind();
            return;
        }
        throw new RuntimeException("RFix instance is already set.");
    }

    protected static void destroy() {
        sInstance = null;
        sInitialized = false;
    }

    public static RFix getInstance() {
        if (sInstance != null) {
            return sInstance;
        }
        throw new RuntimeException("you must create RFix instance first!");
    }

    public static boolean isInitialized() {
        return sInitialized;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processLoadReport$1(RFixLoadResult rFixLoadResult) {
        this.loadResult = rFixLoadResult;
        this.loadReporter.d(rFixLoadResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$saveRemoteVerifyInfo$0(Context context, RFixParams rFixParams) {
        RemoteVerifyInfo remoteVerifyInfo = new RemoteVerifyInfo(context, true);
        RemoteVerifyInfo remoteVerifyInfo2 = new RemoteVerifyInfo(context, false);
        remoteVerifyInfo2.appId = rFixParams.getAppId();
        remoteVerifyInfo2.appKey = rFixParams.getAppKey();
        remoteVerifyInfo2.appVersion = rFixParams.getAppVersion(context);
        if (!remoteVerifyInfo2.equals(remoteVerifyInfo)) {
            remoteVerifyInfo2.saveStoreInfo();
        }
    }

    private void onBind() {
        if (this.params.getAutoRequestEnable()) {
            requestConfig();
        }
        processLoadReport();
        RFixLog.d(TAG, "RFix initialized! params=" + this.params);
    }

    private void processLoadReport() {
        if (this.loadReporter == null) {
            this.loadReporter = new com.tencent.rfix.lib.reporter.b(this.context);
        }
        this.loadReporter.d(this.loadResult);
        RFixLoadResult lastLoadResult = RFixLoaderImmediate.getLastLoadResult();
        if (lastLoadResult != null) {
            this.loadResult = lastLoadResult;
            this.loadReporter.d(lastLoadResult);
        }
        RFixLoaderImmediate.setListener(new RFixLoaderImmediate.ImmediateLoadListener() { // from class: com.tencent.rfix.lib.a
            @Override // com.tencent.rfix.loader.RFixLoaderImmediate.ImmediateLoadListener
            public final void onLoadResult(RFixLoadResult rFixLoadResult) {
                RFix.this.lambda$processLoadReport$1(rFixLoadResult);
            }
        });
    }

    private void saveRemoteVerifyInfo(final Context context, final RFixParams rFixParams) {
        RFixThreadPool.getInstance().execute(new Runnable() { // from class: com.tencent.rfix.lib.b
            @Override // java.lang.Runnable
            public final void run() {
                RFix.lambda$saveRemoteVerifyInfo$0(context, rFixParams);
            }
        });
    }

    private void setAutoVerifyParams(RFixParams rFixParams) {
        RFixGlobalPreferences rFixGlobalPreferences = new RFixGlobalPreferences(this.context);
        if (rFixGlobalPreferences.autoVerifyEnable) {
            rFixParams.setDummyAppVersion(rFixGlobalPreferences.dummyAppVersion);
            rFixParams.setDummyUserId(rFixGlobalPreferences.dummyAppUid);
        }
    }

    public void addListener(RFixListener rFixListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) rFixListener);
        } else {
            this.eventDispatcher.a(rFixListener);
        }
    }

    public void cleanPatch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            this.patchEngine.a();
        }
    }

    public com.tencent.rfix.lib.config.b getConfigManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.rfix.lib.config.b) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.configManager;
    }

    public Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.context;
    }

    public com.tencent.rfix.lib.event.a getEventDispatcher() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (com.tencent.rfix.lib.event.a) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.eventDispatcher;
    }

    public RFixLoadResult getLoadResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (RFixLoadResult) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.loadResult;
    }

    public RFixParams getParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (RFixParams) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.params;
    }

    public File getPatchDirectory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (File) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.patchDirectory;
    }

    public com.tencent.rfix.lib.download.a getPatchDownloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.rfix.lib.download.a) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.patchDownloader;
    }

    public com.tencent.rfix.lib.engine.a getPatchEngine() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.rfix.lib.engine.a) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.patchEngine;
    }

    public Pair<RDelivery, e> getRDeliveryPair() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Pair) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.configManager.c();
    }

    public void onPatchReceived(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else {
            this.patchEngine.c(str);
        }
    }

    public void removeListener(RFixListener rFixListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) rFixListener);
        } else {
            this.eventDispatcher.f(rFixListener);
        }
    }

    public void requestConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.configManager.a();
        }
    }

    RFix(Context context, RFixLoadResult rFixLoadResult, RFixParams rFixParams, File file, com.tencent.rfix.lib.config.b bVar, com.tencent.rfix.lib.download.a aVar, com.tencent.rfix.lib.engine.a aVar2, RFixListener rFixListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, rFixLoadResult, rFixParams, file, bVar, aVar, aVar2, rFixListener);
            return;
        }
        this.context = context;
        this.loadResult = rFixLoadResult;
        this.params = rFixParams;
        this.patchDirectory = file;
        this.configManager = bVar;
        this.patchDownloader = aVar;
        this.patchEngine = aVar2;
        com.tencent.rfix.lib.event.a aVar3 = new com.tencent.rfix.lib.event.a();
        this.eventDispatcher = aVar3;
        aVar3.a(rFixListener);
        setAutoVerifyParams(rFixParams);
        saveRemoteVerifyInfo(context, rFixParams);
    }
}
