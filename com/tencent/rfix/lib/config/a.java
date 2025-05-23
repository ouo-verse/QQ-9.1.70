package com.tencent.rfix.lib.config;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.rdelivery.RDelivery;
import com.tencent.rfix.lib.RFix;
import com.tencent.rfix.lib.RFixParams;
import com.tencent.rfix.lib.config.c;
import com.tencent.rfix.lib.event.ConfigEvent;
import com.tencent.rfix.loader.entity.RFixPatchInfo;
import com.tencent.rfix.loader.log.RFixLog;
import com.tencent.rfix.loader.storage.RFixGlobalPreferences;
import com.tencent.rfix.loader.utils.PatchFileUtils;
import com.tencent.rfix.loader.utils.ProcessUtils;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final Context f364929a;

    /* renamed from: b, reason: collision with root package name */
    private PatchConfig f364930b;

    /* renamed from: c, reason: collision with root package name */
    private PatchConfig f364931c;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f364932d;

    /* renamed from: e, reason: collision with root package name */
    private e f364933e;

    public a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f364932d = new AtomicBoolean();
        this.f364929a = context;
        this.f364931c = new PatchConfig(context, true);
    }

    private void d(PatchConfig patchConfig) {
        if (!patchConfig.isValid()) {
            RFixLog.i("RFix.ConfigManager", "downloadPatchIfNeed config invalid.");
        } else {
            RFix.getInstance().getPatchDownloader().a(patchConfig);
        }
    }

    private PatchConfig e(c cVar) {
        PatchConfig patchConfig = new PatchConfig(this.f364929a, false);
        if (cVar != null) {
            patchConfig.configId = cVar.a();
            patchConfig.patchProcess = cVar.c();
            c.a b16 = cVar.b(this.f364929a);
            if (b16 != null) {
                patchConfig.patchUrl = b16.f364938a;
                patchConfig.patchMD5 = b16.f364939b;
            }
        }
        return patchConfig;
    }

    private e f(RFixParams rFixParams) {
        if (this.f364933e == null) {
            this.f364933e = new e(this.f364929a, rFixParams, this);
        }
        return this.f364933e;
    }

    private void h(PatchConfig patchConfig) {
        RFixLog.i("RFix.ConfigManager", "onUpdatePatchConfig patchConfig=" + patchConfig);
        boolean z16 = true;
        if (patchConfig == null && this.f364931c.isValid()) {
            RFixLog.i("RFix.ConfigManager", "onUpdatePatchConfig remove patch.");
            this.f364931c = new PatchConfig(this.f364929a, false);
        } else if (patchConfig != null && patchConfig.configId != this.f364931c.configId) {
            RFixLog.i("RFix.ConfigManager", "onUpdatePatchConfig update patch.");
            this.f364931c = patchConfig;
        } else {
            RFixLog.i("RFix.ConfigManager", "onUpdatePatchConfig no change.");
            z16 = false;
        }
        com.tencent.rfix.lib.covered.b.f(this.f364929a).g(this.f364931c.configId);
        this.f364931c.saveStoreInfo();
        RFixPatchInfo rFixPatchInfo = new RFixPatchInfo(this.f364929a);
        int i3 = rFixPatchInfo.lastConfigId;
        int i16 = this.f364931c.configId;
        if (i3 != i16) {
            rFixPatchInfo.lastConfigId = i16;
            rFixPatchInfo.lastDownloadResult = -100;
            rFixPatchInfo.lastInstallResult = -100;
            rFixPatchInfo.saveStoreInfo();
        }
        if (z16) {
            RFix.getInstance().cleanPatch();
        }
        d(this.f364931c);
    }

    @Override // com.tencent.rfix.lib.config.b
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (!ProcessUtils.isInMainProcess(this.f364929a)) {
            RFixLog.e("RFix.ConfigManager", "requestConfig only execute in main process.");
            return;
        }
        RFixParams params = RFix.getInstance().getParams();
        if (!params.isEnable()) {
            RFixLog.e("RFix.ConfigManager", "requestConfig enable is false.");
            return;
        }
        if (!TextUtils.isEmpty(params.getAppId()) && !TextUtils.isEmpty(params.getAppKey())) {
            if (this.f364932d.get()) {
                return;
            }
            this.f364932d.set(true);
            f(params).j();
            RFixLog.i("RFix.ConfigManager", "requestConfig submit request task.");
            return;
        }
        RFixLog.e("RFix.ConfigManager", "requestConfig appId or appKey is invalid.");
    }

    @Override // com.tencent.rfix.lib.config.b
    public void b(c cVar, String str) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) cVar, (Object) str);
            return;
        }
        RFixLog.i("RFix.ConfigManager", "onGetExtraConfig config=" + cVar + " patchFile=" + str);
        if (cVar != null && cVar.d()) {
            if (cVar.a() < this.f364931c.configId) {
                RFixLog.i("RFix.ConfigManager", "onGetExtraConfig configId < currentConfig.configId, ignored!");
                return;
            }
            if (str != null && PatchFileUtils.isLegalFile(new File(str))) {
                PatchConfig e16 = e(cVar);
                this.f364930b = e16;
                if (e16.configId != this.f364931c.configId) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    this.f364931c = e16;
                    e16.saveStoreInfo();
                }
                com.tencent.rfix.lib.covered.b.f(this.f364929a).g(this.f364931c.configId);
                RFix.getInstance().getPatchEngine().b(str, this.f364931c);
                return;
            }
            RFixLog.e("RFix.ConfigManager", "onGetExtraConfig patchFile is null or invalid, ignored!");
            return;
        }
        RFixLog.e("RFix.ConfigManager", "onGetExtraConfig config is null or invalid, ignored!");
    }

    @Override // com.tencent.rfix.lib.config.b
    public Pair<RDelivery, iz3.e> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Pair) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return f(RFix.getInstance().getParams()).f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(int i3, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) cVar);
            return;
        }
        RFixLog.i("RFix.ConfigManager", "onGetRDeliveryConfig result=" + i3 + " config=" + cVar);
        this.f364932d.set(false);
        if (new RFixGlobalPreferences(this.f364929a).disableConfig) {
            RFixLog.i("RFix.ConfigManager", "onGetConfigResponse disable config.");
            return;
        }
        PatchConfig e16 = e(cVar);
        PatchConfig patchConfig = this.f364930b;
        if (patchConfig != null && patchConfig.configId >= e16.configId) {
            RFixLog.i("RFix.ConfigManager", "onGetRDeliveryConfig configId <= extraConfig.configId, ignored!");
            return;
        }
        if (i3 == e.f364942e) {
            h(e16);
        }
        ConfigEvent configEvent = new ConfigEvent();
        configEvent.resultCode = i3;
        configEvent.config = e16;
        RFix.getInstance().getEventDispatcher().c(configEvent.isSuccess(), configEvent.resultCode, configEvent);
    }
}
