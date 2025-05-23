package com.tencent.mobileqq.qqguildsdk.api.impl;

import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qqguildsdk.api.IGProGlobalService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes17.dex */
public class bv {
    public static final String TAG = "[gpro_sdk]";
    protected AppRuntime mApp;
    protected com.tencent.mobileqq.qqguildsdk.engine.z mEngine;
    protected GProGlobalServiceImpl mGProGlobalService;
    private INetInfoHandler mNetInfoHandler;
    protected final AtomicBoolean mRun = new AtomicBoolean(false);
    private final AtomicInteger mGetCallerMethodCount = new AtomicInteger(0);

    private String getCallerMethod() {
        this.mGetCallerMethodCount.incrementAndGet();
        if (this.mGetCallerMethodCount.get() > 7) {
            return "";
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length <= 4) {
            return "";
        }
        return stackTrace[4].getMethodName();
    }

    private void registerNotifications() {
        AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.getContext(), this.mNetInfoHandler);
    }

    private void unregisterNotifications() {
        AppNetConnInfo.unregisterNetInfoHandler(this.mNetInfoHandler);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isRun() {
        if (!this.mRun.get()) {
            com.tencent.mobileqq.qqguildsdk.util.h.u("[gpro_sdk]", true, "sdk interface", "mRun.get() is false, caller:" + getCallerMethod());
            return false;
        }
        if (this.mEngine.fl() == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.u("[gpro_sdk]", true, "sdk interface", "mEngine.getCurrentUin() is null");
            return false;
        }
        AppRuntime appRuntime = this.mApp;
        if (appRuntime != null && appRuntime.isRunning() && this.mEngine.fl().equals(appRuntime.getCurrentUin())) {
            return this.mEngine.f266766w.get();
        }
        if (appRuntime == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.u("[gpro_sdk]", true, "sdk interface", "isRun app null");
        } else if (!appRuntime.isRunning()) {
            com.tencent.mobileqq.qqguildsdk.util.h.u("[gpro_sdk]", true, "sdk interface", "isRun app is not running");
        } else {
            com.tencent.mobileqq.qqguildsdk.util.h.u("[gpro_sdk]", true, "sdk interface", "mEngine.getCurrentUin() is not equal mApp.getCurrentUin()");
        }
        return false;
    }

    public void onCreate(AppRuntime appRuntime) {
        if (!appRuntime.isRunning()) {
            return;
        }
        this.mApp = appRuntime;
        if (MobileQQ.sProcessId != 1) {
            com.tencent.mobileqq.qqguildsdk.util.h.k("[gpro_sdk]", 1, "sdk interface", QLog.getStackTraceString(new IllegalArgumentException("GPSServiceBase can not run on this process: " + MobileQQ.sProcessId + "\uff0c\u8bf7\u8054\u7cfbAPI\u5f00\u53d1\u8005\u6c9f\u901a\u5904\u7406\u3002\n")));
            return;
        }
        com.tencent.mobileqq.qqguildsdk.util.h.s("[gpro_sdk]", 1, "sdk interface", "GPSServiceBase start to obtaining IGProGlobalService");
        this.mGProGlobalService = (GProGlobalServiceImpl) appRuntime.getRuntimeService(IGProGlobalService.class, "");
        com.tencent.mobileqq.qqguildsdk.util.h.s("[gpro_sdk]", 1, "sdk interface", "GPSServiceBase after obtain IGProGlobalService");
        this.mEngine = new com.tencent.mobileqq.qqguildsdk.engine.z(appRuntime, this.mGProGlobalService);
        this.mRun.compareAndSet(false, true);
        this.mNetInfoHandler = new a(this);
        registerNotifications();
        com.tencent.mobileqq.qqguildsdk.util.h.s("[gpro_sdk]", 1, "sdk interface", "GPSServiceBase init completed!");
    }

    public void onDestroy() {
        unregisterNotifications();
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    static class a implements INetInfoHandler {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<bv> f265334d;

        public a(bv bvVar) {
            this.f265334d = new WeakReference<>(bvVar);
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Mobile(String str) {
            com.tencent.mobileqq.qqguildsdk.util.h.u("[gpro_sdk]", true, "sdk interface", "onNetNone2Mobile");
            bv bvVar = this.f265334d.get();
            if (bvVar == null) {
                com.tencent.mobileqq.qqguildsdk.util.h.k("[gpro_sdk]", 1, "sdk interface", "onNetNone2Mobile gpsService is null!");
            } else {
                bvVar.mEngine.mj(true);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Wifi(String str) {
            com.tencent.mobileqq.qqguildsdk.util.h.u("[gpro_sdk]", true, "sdk interface", "onNetNone2Wifi");
            bv bvVar = this.f265334d.get();
            if (bvVar == null) {
                com.tencent.mobileqq.qqguildsdk.util.h.k("[gpro_sdk]", 1, "sdk interface", "onNetNone2Wifi gpsService is null!");
            } else {
                bvVar.mEngine.mj(true);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2None() {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2None() {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2Wifi(String str) {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2Mobile(String str) {
        }
    }
}
