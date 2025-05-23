package com.tencent.rfix.lib.engine;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.rfix.lib.RFix;
import com.tencent.rfix.lib.RFixParams;
import com.tencent.rfix.lib.config.PatchConfig;
import com.tencent.rfix.lib.entity.RFixPatchResult;
import com.tencent.rfix.lib.event.InstallEvent;
import com.tencent.rfix.lib.reporter.f;
import com.tencent.rfix.loader.RFixLoaderImmediate;
import com.tencent.rfix.loader.entity.RFixPatchInfo;
import com.tencent.rfix.loader.log.RFixLog;
import com.tencent.rfix.loader.safemode.RFixSafeModeKeeper;
import com.tencent.rfix.loader.storage.RFixGlobalPreferences;
import com.tencent.rfix.loader.thread.IRFixThreadPool;
import com.tencent.rfix.loader.thread.RFixThreadPool;
import com.tencent.rfix.loader.track.TimeTrackType;
import com.tencent.rfix.loader.track.TimeTracker;
import com.tencent.rfix.loader.utils.PatchFileUtils;
import com.tencent.rfix.loader.utils.PatchMD5Utils;
import com.tencent.rfix.loader.utils.ProcessUtils;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes25.dex */
public class PatchEngineBase implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static final AtomicBoolean f364971c;

    /* renamed from: a, reason: collision with root package name */
    protected final Context f364972a;

    /* renamed from: b, reason: collision with root package name */
    protected final Map<String, b> f364973b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9942);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            f364971c = new AtomicBoolean(false);
        }
    }

    public PatchEngineBase(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f364972a = context;
        this.f364973b = new HashMap();
        m();
    }

    private boolean i(File file, String str, File file2) {
        try {
            if (!str.equals(PatchMD5Utils.getMD5(file2))) {
                PatchFileUtils.copyFileUsingStream(file, file2);
                return true;
            }
            return true;
        } catch (IOException e16) {
            RFixLog.e("RFix.PatchEngineBase", "copyFileWithMD5Check fail.", e16);
            return false;
        }
    }

    private RFixConstants.PatchError j(String str, RFix rFix, com.tencent.rfix.lib.security.a aVar, RFixPatchResult rFixPatchResult) {
        File file = new File(str);
        String md5 = PatchMD5Utils.getMD5(file);
        rFixPatchResult.patchVersion = md5;
        rFixPatchResult.patchType = aVar.e(RFixConstants.PATCH_TYPE);
        rFixPatchResult.effectImmediate = aVar.g(RFixConstants.EFFECT_IMMEDIATE, false);
        rFixPatchResult.enableAssertDex = aVar.g(RFixConstants.ENABLE_ASSERT_DEX, false);
        rFixPatchResult.enableAssertLib = aVar.g(RFixConstants.ENABLE_ASSERT_LIB, false);
        rFixPatchResult.enableAssertRes = aVar.g(RFixConstants.ENABLE_ASSERT_RES, false);
        RFixConstants.PatchError h16 = h(rFix, file, md5, aVar);
        if (h16 == RFixConstants.PatchError.PATCH_ERROR_OK) {
            rFixPatchResult.patchId = aVar.c();
            rFixPatchResult.patchIndex = aVar.d();
        }
        rFixPatchResult.result = h16;
        rFixPatchResult.retryCount = new RFixGlobalPreferences(this.f364972a).lastInstallRetryCount;
        RFixLog.i("RFix.PatchEngineBase", String.format("doCheckPatch checkResult=%s path=%s md5=%s", h16, str, md5));
        return h16;
    }

    private static RFixConstants.PatchError k(RFixPatchResult rFixPatchResult, String str) {
        if (RFixPatchInfo.PATCH_TYPE_TINKER.equals(str)) {
            int i3 = rFixPatchResult.installResult;
            if (i3 == -103) {
                return RFixConstants.PatchError.PATCH_ERROR_APPLYING;
            }
            if (i3 == -106) {
                return RFixConstants.PatchError.PATCH_ERROR_ALREADY_APPLY;
            }
            if (i3 == -107) {
                return RFixConstants.PatchError.PATCH_ERROR_RETRY_LIMIT;
            }
            return RFixConstants.PatchError.PATCH_ERROR_INSTALL_FAIL;
        }
        return RFixConstants.PatchError.PATCH_ERROR_INSTALL_FAIL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(RFixPatchResult rFixPatchResult) {
        int i3;
        if (rFixPatchResult.isPatchSuccess()) {
            i3 = rFixPatchResult.configId;
        } else {
            i3 = 0;
        }
        com.tencent.rfix.lib.covered.b.f(this.f364972a).h(i3);
    }

    private boolean p(RFixParams rFixParams, RFixPatchResult rFixPatchResult) {
        if (RFixPatchInfo.PATCH_TYPE_TINKER.equals(rFixPatchResult.patchType)) {
            return false;
        }
        return !rFixParams.getMainVerifyEnable();
    }

    private boolean q(RFixPatchInfo rFixPatchInfo, String str) {
        if (rFixPatchInfo == null || rFixPatchInfo.removePatch || !TextUtils.equals(rFixPatchInfo.version, str)) {
            return false;
        }
        return true;
    }

    private boolean r(String str) {
        RFixGlobalPreferences rFixGlobalPreferences = new RFixGlobalPreferences(this.f364972a);
        if (!TextUtils.equals(rFixGlobalPreferences.lastInstallVersion, str)) {
            rFixGlobalPreferences.lastInstallVersion = str;
            rFixGlobalPreferences.lastInstallRetryCount = 0;
            rFixGlobalPreferences.saveStoreInfo();
            return false;
        }
        int i3 = rFixGlobalPreferences.lastInstallRetryCount;
        if (i3 >= 10) {
            return true;
        }
        rFixGlobalPreferences.lastInstallRetryCount = i3 + 1;
        rFixGlobalPreferences.saveStoreInfo();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(RFixPatchResult rFixPatchResult) {
        if (RFixPatchInfo.PATCH_TYPE_REDIRECT.equals(rFixPatchResult.patchType) && rFixPatchResult.effectImmediate) {
            RFixLoaderImmediate.tryLoad();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(RFixPatchResult rFixPatchResult) {
        String str;
        String valueOf = String.valueOf(rFixPatchResult.configId);
        String valueOf2 = String.valueOf(rFixPatchResult.configType);
        String str2 = rFixPatchResult.patchType;
        if (!TextUtils.isEmpty(rFixPatchResult.patchVersion)) {
            str = rFixPatchResult.patchVersion.substring(0, 8);
        } else {
            str = null;
        }
        String str3 = str;
        boolean isPatchSuccess = rFixPatchResult.isPatchSuccess();
        String obj = rFixPatchResult.result.toString();
        String valueOf3 = String.valueOf(rFixPatchResult.installResult);
        long j3 = rFixPatchResult.timeCost;
        f.i(this.f364972a, valueOf, valueOf2, str2, str3, "Install", isPatchSuccess, obj, valueOf3, j3, String.valueOf(rFixPatchResult.retryCount), String.valueOf(rFixPatchResult.oatGenerated), null, String.valueOf(TimeTracker.getTrackTimeMillis(TimeTrackType.PATCH_INSTALL_CHECK)), String.valueOf(TimeTracker.getTrackTimeMillis(TimeTrackType.PATCH_INSTALL_INSTALLER)), String.valueOf(TimeTracker.getTrackTimeMillis(TimeTrackType.PATCH_INSTALL_INSTALLER_DEX)), String.valueOf(TimeTracker.getTrackTimeMillis(TimeTrackType.PATCH_INSTALL_INSTALLER_RES)), String.valueOf(TimeTracker.getTrackTimeMillis(TimeTrackType.PATCH_INSTALL_INSTALLER_LIB)), String.valueOf(TimeTracker.getTrackTimeMillis(TimeTrackType.PATCH_INSTALL_INSTALLER_DEX_OPT)), String.valueOf(TimeTracker.getTrackTimeMillis(TimeTrackType.PATCH_INSTALL_INSTALLER_DEX_OPT_WAIT)), null, null, null);
        com.tencent.rfix.lib.reporter.c.a(this.f364972a, isPatchSuccess, j3, obj);
    }

    private void v(RFixPatchInfo rFixPatchInfo) {
        if (RFixPatchInfo.PATCH_TYPE_REDIRECT.equals(rFixPatchInfo.patchType) && rFixPatchInfo.effectImmediate) {
            RFixLoaderImmediate.tryUnload();
        }
    }

    @Override // com.tencent.rfix.lib.engine.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        RFixPatchInfo rFixPatchInfo = new RFixPatchInfo(this.f364972a);
        if (TextUtils.isEmpty(rFixPatchInfo.version)) {
            RFixLog.i("RFix.PatchEngineBase", "cleanPatch patch info empty.");
            return;
        }
        RFixLog.i("RFix.PatchEngineBase", String.format("cleanPatch version=%s patchType=%s", rFixPatchInfo.version, rFixPatchInfo.patchType));
        rFixPatchInfo.removePatch = true;
        rFixPatchInfo.saveStoreInfo();
        RFixGlobalPreferences rFixGlobalPreferences = new RFixGlobalPreferences(this.f364972a);
        rFixGlobalPreferences.lastInstallVersion = null;
        rFixGlobalPreferences.lastInstallRetryCount = 0;
        rFixGlobalPreferences.saveStoreInfo();
        v(rFixPatchInfo);
    }

    @Override // com.tencent.rfix.lib.engine.a
    public void b(String str, PatchConfig patchConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) patchConfig);
            return;
        }
        RFixLog.i("RFix.PatchEngineBase", String.format("onPatchReceived path=%s", str));
        if (!ProcessUtils.isInMainProcess(this.f364972a)) {
            RFixLog.e("RFix.PatchEngineBase", "onPatchReceived only execute in main process.");
        } else if (!RFix.getInstance().getParams().isEnable()) {
            RFixLog.e("RFix.PatchEngineBase", "onPatchReceived enable is false.");
        } else {
            RFixThreadPool.getInstance().execute(new Runnable(str, patchConfig) { // from class: com.tencent.rfix.lib.engine.PatchEngineBase.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f364974d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ PatchConfig f364975e;

                {
                    this.f364974d = str;
                    this.f364975e = patchConfig;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, PatchEngineBase.this, str, patchConfig);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    TimeTrackType timeTrackType = TimeTrackType.PATCH_INSTALL_TOTAL;
                    TimeTracker.beginTrack(timeTrackType);
                    RFix rFix = RFix.getInstance();
                    RFixPatchResult g16 = PatchEngineBase.this.g(this.f364974d, rFix, new com.tencent.rfix.lib.security.a(PatchEngineBase.this.f364972a, new File(this.f364974d)), this.f364975e);
                    TimeTracker.endTrack(timeTrackType);
                    g16.timeCost = TimeTracker.getTrackTimeMillis(timeTrackType);
                    PatchEngineBase.this.n(g16);
                    PatchEngineBase.this.t(g16);
                    InstallEvent installEvent = new InstallEvent();
                    installEvent.resultCode = g16.result.ordinal();
                    installEvent.patchResult = g16;
                    rFix.getEventDispatcher().e(installEvent.isSuccess(), installEvent.resultCode, installEvent);
                    if (g16.isPatchSuccessFirstTime()) {
                        RFixSafeModeKeeper.resetSafeMode(PatchEngineBase.this.f364972a);
                        PatchEngineBase.this.s(g16);
                    }
                }
            }, IRFixThreadPool.ThreadType.THREAD_IO);
        }
    }

    @Override // com.tencent.rfix.lib.engine.a
    public void c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            b(str, null);
        }
    }

    protected RFixPatchResult g(String str, RFix rFix, com.tencent.rfix.lib.security.a aVar, PatchConfig patchConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (RFixPatchResult) iPatchRedirector.redirect((short) 8, this, str, rFix, aVar, patchConfig);
        }
        RFixPatchResult rFixPatchResult = new RFixPatchResult();
        rFixPatchResult.result = RFixConstants.PatchError.PATCH_ERROR_UNKNOWN_EXCEPTION;
        rFixPatchResult.patchFilePath = str;
        if (patchConfig != null) {
            rFixPatchResult.configId = patchConfig.configId;
            rFixPatchResult.patchProcess = patchConfig.patchProcess;
        }
        if (!f364971c.compareAndSet(false, true)) {
            RFixLog.w("RFix.PatchEngineBase", "applyPatchAsync apply patch is running by another runner.");
            rFixPatchResult.result = RFixConstants.PatchError.PATCH_ERROR_APPLYING;
            return rFixPatchResult;
        }
        RFixLog.i("RFix.PatchEngineBase", "applyPatchAsync applying...");
        try {
            TimeTrackType timeTrackType = TimeTrackType.PATCH_INSTALL_CHECK;
            TimeTracker.beginTrack(timeTrackType);
            RFixConstants.PatchError j3 = j(str, rFix, aVar, rFixPatchResult);
            TimeTracker.endTrack(timeTrackType);
            RFixConstants.PatchError patchError = RFixConstants.PatchError.PATCH_ERROR_OK;
            if (j3 == patchError) {
                TimeTrackType timeTrackType2 = TimeTrackType.PATCH_INSTALL_INSTALLER;
                TimeTracker.beginTrack(timeTrackType2);
                RFixConstants.PatchError o16 = o(rFix, rFixPatchResult);
                TimeTracker.endTrack(timeTrackType2);
                rFixPatchResult.result = o16;
                RFixLog.i("RFix.PatchEngineBase", String.format("applyPatchAsync apply patch installResult=%s", o16));
            }
            RFixPatchInfo rFixPatchInfo = new RFixPatchInfo(this.f364972a);
            rFixPatchInfo.lastInstallResult = rFixPatchResult.result.ordinal();
            if (rFixPatchResult.result == patchError) {
                rFixPatchInfo.configId = rFixPatchResult.configId;
                rFixPatchInfo.configType = rFixPatchResult.configType;
                rFixPatchInfo.patchProcess = rFixPatchResult.patchProcess;
                rFixPatchInfo.version = rFixPatchResult.patchVersion;
                rFixPatchInfo.patchType = rFixPatchResult.patchType;
                rFixPatchInfo.patchId = rFixPatchResult.patchId;
                rFixPatchInfo.effectImmediate = rFixPatchResult.effectImmediate;
                rFixPatchInfo.enableAssertDex = rFixPatchResult.enableAssertDex;
                rFixPatchInfo.enableAssertLib = rFixPatchResult.enableAssertLib;
                rFixPatchInfo.enableAssertRes = rFixPatchResult.enableAssertRes;
                rFixPatchInfo.removePatch = false;
                rFixPatchInfo.mainVerified = p(rFix.getParams(), rFixPatchResult);
            }
            rFixPatchInfo.saveStoreInfo();
        } catch (Exception e16) {
            rFixPatchResult.result = RFixConstants.PatchError.PATCH_ERROR_UNKNOWN_EXCEPTION;
            rFixPatchResult.exception = e16;
            RFixLog.e("RFix.PatchEngineBase", "doApplyAsync fail.", e16);
        }
        f364971c.set(false);
        RFixLog.i("RFix.PatchEngineBase", String.format("doApplyAsync done. result=%s", rFixPatchResult));
        return rFixPatchResult;
    }

    protected RFixConstants.PatchError h(RFix rFix, File file, String str, com.tencent.rfix.lib.security.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (RFixConstants.PatchError) iPatchRedirector.redirect((short) 9, this, rFix, file, str, aVar);
        }
        if (!PatchFileUtils.isLegalFile(file)) {
            return RFixConstants.PatchError.PATCH_ERROR_NOT_EXIST;
        }
        if (PatchMD5Utils.checkIfMd5Invalid(str)) {
            return RFixConstants.PatchError.PATCH_ERROR_MD5_INVALID;
        }
        if (q(new RFixPatchInfo(this.f364972a), str)) {
            return RFixConstants.PatchError.PATCH_ERROR_ALREADY_APPLY;
        }
        if (TextUtils.equals(new RFixGlobalPreferences(this.f364972a).safeModeInterceptVersion, str)) {
            return RFixConstants.PatchError.PATCH_ERROR_SAFE_MODE_INTERCEPT;
        }
        if (r(str)) {
            return RFixConstants.PatchError.PATCH_ERROR_RETRY_LIMIT;
        }
        if (!aVar.i()) {
            return RFixConstants.PatchError.PATCH_ERROR_SIGN_NOT_MATCH;
        }
        if (!RFixPatchInfo.patchTypeValid(aVar.e(RFixConstants.PATCH_TYPE))) {
            return RFixConstants.PatchError.PATCH_ERROR_TYPE_INVALID;
        }
        if (!aVar.a()) {
            return RFixConstants.PatchError.PATCH_ERROR_ID_INVALID;
        }
        return RFixConstants.PatchError.PATCH_ERROR_OK;
    }

    public b l(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        return this.f364973b.get(str);
    }

    protected void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            u(new c(this.f364972a));
            u(new d(this.f364972a));
        }
    }

    protected RFixConstants.PatchError o(RFix rFix, RFixPatchResult rFixPatchResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (RFixConstants.PatchError) iPatchRedirector.redirect((short) 10, (Object) this, (Object) rFix, (Object) rFixPatchResult);
        }
        File file = new File(rFixPatchResult.patchFilePath);
        String str = rFixPatchResult.patchVersion;
        String str2 = rFixPatchResult.patchType;
        String absolutePath = rFix.getPatchDirectory().getAbsolutePath();
        File patchVersionDirectory = PatchFileUtils.getPatchVersionDirectory(absolutePath, str);
        RFixLog.i("RFix.PatchEngineBase", String.format("installPatch patchVersionDirectory=%s", patchVersionDirectory.getAbsolutePath()));
        File patchVersionFile = PatchFileUtils.getPatchVersionFile(absolutePath, str);
        if (!i(file, str, patchVersionFile)) {
            RFixLog.e("RFix.PatchEngineBase", "installPatch copy path file fail.");
            return RFixConstants.PatchError.PATCH_ERROR_COPY_PATCH_FAIL;
        }
        b l3 = l(str2);
        if (l3 == null) {
            RFixLog.e("RFix.PatchEngineBase", String.format("installPatch no installer support. patchType=%s", str2));
            return RFixConstants.PatchError.PATCH_ERROR_NO_INSTALLER_SUPPORT;
        }
        if (!l3.a(patchVersionFile, patchVersionDirectory, rFixPatchResult)) {
            RFixLog.e("RFix.PatchEngineBase", "installPatch install patch fail. installResult=" + rFixPatchResult.installResult);
            return k(rFixPatchResult, str2);
        }
        RFixLog.i("RFix.PatchEngineBase", "installPatch install patch success.");
        return RFixConstants.PatchError.PATCH_ERROR_OK;
    }

    public boolean u(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar)).booleanValue();
        }
        if (bVar == null) {
            return false;
        }
        String patchType = bVar.getPatchType();
        b bVar2 = this.f364973b.get(patchType);
        if (bVar2 != null) {
            RFixLog.e("RFix.PatchEngineBase", String.format("registerInstaller installer already exist. patchType=%s installer=%s", patchType, bVar2));
            return false;
        }
        this.f364973b.put(patchType, bVar);
        return true;
    }
}
