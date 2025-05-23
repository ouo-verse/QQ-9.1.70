package com.tencent.ams.dynamic.impl;

import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.monitor.metric.core.MetricReportConfig;
import com.tencent.ams.dsdk.utils.DKScheduledExecutor;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.dsdk.utils.WorkThreadManager;
import com.tencent.ams.dynamic.IDynamicApi;
import com.tencent.common.config.AppSetting;
import com.tencent.gdtad.basics.motivevideo.hippy.web.GdtMotiveHippyWebView;
import com.tencent.gdtad.config.data.f;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.turingfd.sdk.xq.ITuringDID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DynamicApiImpl implements IDynamicApi {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DynamicApiImpl";
    private DKEngine.DeviceInfoGetter mDeviceInfoGetter;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements DKEngine.DeviceInfoGetter {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DynamicApiImpl.this);
            }
        }

        @Override // com.tencent.ams.dsdk.core.DKEngine.DeviceInfoGetter
        public String getGuid() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return null;
        }

        @Override // com.tencent.ams.dsdk.core.DKEngine.DeviceInfoGetter
        public String getOaid() {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            ITuringDID c16 = com.tencent.mobileqq.turingfd.c.a().c(true);
            if (c16 != null) {
                str = c16.getAIDTicket();
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return str;
        }

        @Override // com.tencent.ams.dsdk.core.DKEngine.DeviceInfoGetter
        public String getQimei36() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return null;
        }

        @Override // com.tencent.ams.dsdk.core.DKEngine.DeviceInfoGetter
        public String getTaid() {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            ITuringDID c16 = com.tencent.mobileqq.turingfd.c.a().c(true);
            if (c16 != null) {
                str = c16.getTAIDTicket();
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return str;
        }
    }

    public DynamicApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mDeviceInfoGetter = new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setGlobalParams$4(Runnable runnable, long j3) {
        new Handler(ThreadManagerV2.getQQCommonThreadLooper()).postDelayed(runnable, j3);
    }

    @Override // com.tencent.ams.dynamic.IDynamicApi
    public void initDynamicSDK() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            DLog.i(TAG, "[initDynamicSDK]");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.ams.dynamic.impl.DynamicApiImpl.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DynamicApiImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        DynamicApiImpl.this.setGlobalParams();
                        DKEngine.preloadFrontEndSrc();
                    } catch (Throwable th5) {
                        DLog.e(DynamicApiImpl.TAG, "[initDynamicSDK]", th5);
                    }
                }
            }, 128, null, true);
        }
    }

    @Override // com.tencent.ams.dynamic.IDynamicApi
    public void setGlobalParams() {
        boolean z16;
        MetricReportConfig metricReportConfig;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        try {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            concurrentHashMap.put("appName", "com.tencent.mobileqq");
            concurrentHashMap.put("appVersion", AppSetting.f99551k);
            concurrentHashMap.put("chid", String.valueOf(8));
            concurrentHashMap.put("osVersion", String.valueOf(Build.VERSION.SDK_INT));
            DKConfiguration.setDKWebView(GdtMotiveHippyWebView.class);
            DKConfiguration.setUpdateTemplateListener(new com.tencent.ams.dynamic.b());
            DKEngine.setDeviceInfoGetter(this.mDeviceInfoGetter);
            DKConfiguration.setLogSupport(new com.tencent.ams.dynamic.a());
            f a16 = com.tencent.gdtad.statistics.metric.b.b().a();
            if (a16 != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            DKConfiguration.setEnableMetricReport(z16);
            if (a16 != null) {
                metricReportConfig = new MetricReportConfig(a16.url, a16.maxCount, a16.countThreshold, a16.intervalMillisThreshold, true);
            } else {
                metricReportConfig = null;
            }
            DKConfiguration.setMetricReportConfig(metricReportConfig);
            WorkThreadManager.getInstance().setDkScheduledExecutor(new DKScheduledExecutor() { // from class: com.tencent.ams.dynamic.impl.a
                @Override // com.tencent.ams.dsdk.utils.DKScheduledExecutor
                public final void schedule(Runnable runnable, long j3) {
                    ThreadManagerV2.executeDelay(runnable, 128, null, true, j3);
                }
            });
            WorkThreadManager.getInstance().setImmediateExecutor(new Executor() { // from class: com.tencent.ams.dynamic.impl.b
                @Override // java.util.concurrent.Executor
                public final void execute(Runnable runnable) {
                    ThreadManagerV2.excute(runnable, 128, null, true);
                }
            });
            WorkThreadManager.getInstance().setHighPriorityExecutor(new Executor() { // from class: com.tencent.ams.dynamic.impl.c
                @Override // java.util.concurrent.Executor
                public final void execute(Runnable runnable) {
                    ThreadManagerV2.excute(runnable, 128, null, true);
                }
            });
            WorkThreadManager.getInstance().setLowPriorityExecutor(new Executor() { // from class: com.tencent.ams.dynamic.impl.d
                @Override // java.util.concurrent.Executor
                public final void execute(Runnable runnable) {
                    ThreadManagerV2.excute(runnable, 128, null, true);
                }
            });
            WorkThreadManager.getInstance().setSingleThreadDKScheduledPool(new DKScheduledExecutor() { // from class: com.tencent.ams.dynamic.impl.e
                @Override // com.tencent.ams.dsdk.utils.DKScheduledExecutor
                public final void schedule(Runnable runnable, long j3) {
                    DynamicApiImpl.lambda$setGlobalParams$4(runnable, j3);
                }
            });
            DKEngine.setGlobalParams(BaseApplication.getContext(), concurrentHashMap);
        } catch (Throwable th5) {
            DLog.e(TAG, "[setGlobalParams]", th5);
        }
    }
}
