package com.tencent.mobileqq.pttlogic.api.impl;

import android.text.TextUtils;
import com.tencent.common.a;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.ptt.api.IPttOptimizeParams;
import com.tencent.mobileqq.pttlogic.api.IPttConfigService;
import com.tencent.mobileqq.pttlogic.api.IStreamParams;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.f;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes16.dex */
public class PttConfigServiceImpl implements IPttConfigService {
    static IPatchRedirector $redirector_;
    protected WeakReference<AppRuntime> mApp;

    public PttConfigServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    protected IDPCApi getDPCApi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (IDPCApi) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return (IDPCApi) QRoute.api(IDPCApi.class);
    }

    @NotNull
    protected IPttOptimizeParams getPttOptimizeParamsApi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (IPttOptimizeParams) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return (IPttOptimizeParams) QRoute.api(IPttOptimizeParams.class);
    }

    @NotNull
    protected IStreamParams getStreamParamsApi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (IStreamParams) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return (IStreamParams) QRoute.api(IStreamParams.class);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        this.mApp = new WeakReference<>(appRuntime);
        String featureValue = getDPCApi().getFeatureValue(DPCNames.SilkCfg.name(), "null");
        if (!"null".equalsIgnoreCase(featureValue)) {
            RecordParams.i(appRuntime, featureValue);
            RecordParams.g(appRuntime, true);
        } else {
            RecordParams.g(appRuntime, false);
        }
        String featureValue2 = getDPCApi().getFeatureValue(DPCNames.StreamCfg.name(), "null");
        if (!"null".equalsIgnoreCase(featureValue2)) {
            getStreamParamsApi().saveStreamCfg(appRuntime, featureValue2);
            getStreamParamsApi().initSupportCfg(appRuntime, true);
        } else {
            getStreamParamsApi().initSupportCfg(appRuntime, false);
        }
        String[] split = getDPCApi().getFeatureValue(DPCNames.aio_config.name(), "").split("\\|");
        if (split.length > 13) {
            a.d(BaseApplication.getContext(), "1".equals(split[12]));
            if (split.length > 14) {
                f.a(BaseApplication.getContext(), "1".equals(split[13]));
            }
        }
        getDPCApi().addObserver(this);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.mApp = null;
        com.tencent.mobileqq.ptt.preop.a.f();
        getDPCApi().removeObserver(this);
        RecordParams.h();
        getStreamParamsApi().release();
    }

    @Override // com.tencent.mobileqq.dpc.DPCObserver
    public void onDpcPullFinished(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        AppRuntime tryGetApp = tryGetApp();
        if (tryGetApp != null && z16) {
            RecordParams.i(tryGetApp, getDPCApi().getFeatureValue(DPCNames.SilkCfg.name(), ""));
            RecordParams.g(tryGetApp, true);
            getStreamParamsApi().saveStreamCfg(tryGetApp, getDPCApi().getFeatureValue(DPCNames.StreamCfg.name(), ""));
            getStreamParamsApi().initSupportCfg(tryGetApp, true);
            String[] split = getDPCApi().getFeatureValue(DPCNames.aio_config.name(), "").split("\\|");
            if (split.length > 13) {
                a.d(BaseApplication.getContext(), "1".equals(split[12]));
                if (split.length > 14) {
                    f.a(BaseApplication.getContext(), "1".equals(split[13]));
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.pttlogic.api.IPttConfigService
    public void onGetPreDownloadCfg(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
            return;
        }
        TextUtils.isEmpty(str);
        NetworkCenter.getInstance();
        AppRuntime tryGetApp = tryGetApp();
        if (tryGetApp != null) {
            savePredownloadCfg(str, tryGetApp);
        }
    }

    @Override // com.tencent.mobileqq.pttlogic.api.IPttConfigService
    public void onGetPttOptimizeCfg(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            return;
        }
        AppRuntime tryGetApp = tryGetApp();
        if (tryGetApp != null) {
            getPttOptimizeParamsApi().savePttOptimizeCfg(tryGetApp, str);
            synchronized (IPttOptimizeParams.class) {
                getPttOptimizeParamsApi().initOptimizeCfg(tryGetApp, true);
            }
        }
    }

    @Override // com.tencent.mobileqq.pttlogic.api.IPttConfigService
    public void onGetStreamSliceCfg(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        AppRuntime tryGetApp = tryGetApp();
        NetworkCenter.getInstance();
        if (tryGetApp != null) {
            getStreamParamsApi().saveStreamSliceCfg(tryGetApp, str);
            getStreamParamsApi().initSliceCfg(tryGetApp, true);
        }
    }

    protected void savePredownloadCfg(String str, AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, (Object) appRuntime);
        } else {
            com.tencent.mobileqq.ptt.preop.a.g(appRuntime, str);
            com.tencent.mobileqq.ptt.preop.a.c(appRuntime, true);
        }
    }

    protected AppRuntime tryGetApp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (AppRuntime) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        WeakReference<AppRuntime> weakReference = this.mApp;
        if (weakReference != null && !weakReference.isEnqueued()) {
            return this.mApp.get();
        }
        return null;
    }
}
