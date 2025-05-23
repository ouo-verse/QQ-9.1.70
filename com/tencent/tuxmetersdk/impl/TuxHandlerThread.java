package com.tencent.tuxmetersdk.impl;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.tuxmetersdk.export.injector.thread.ITuxHandlerThread;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TuxHandlerThread implements ITuxHandlerThread {
    static IPatchRedirector $redirector_ = null;
    private static final HandlerThread DELIVERY_HANDLER_THREAD;
    private static final String DELIVERY_HANDLER_THREAD_NAME = "DeliveryHandlerThread";
    private static final HandlerThread SDK_DATA_READY_HANDLER_THREAD;
    private static final String SDK_DATA_READY_HANDLER_THREAD_NAME = "SDKDataReadyHandlerThread";
    private static final HandlerThread SURVEY_EVENT_HANDLER_THREAD;
    private static final String SURVEY_EVENT_HANDLER_THREAD_NAME = "SurveyEventHandlerThread";
    private static final HandlerThread TRIGGER_HANDLER_THREAD;
    private static final String TRIGGER_HANDLER_THREAD_NAME = "TriggerHandlerThread";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9983);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread(TRIGGER_HANDLER_THREAD_NAME);
        TRIGGER_HANDLER_THREAD = baseHandlerThread;
        BaseHandlerThread baseHandlerThread2 = new BaseHandlerThread(DELIVERY_HANDLER_THREAD_NAME);
        DELIVERY_HANDLER_THREAD = baseHandlerThread2;
        BaseHandlerThread baseHandlerThread3 = new BaseHandlerThread(SURVEY_EVENT_HANDLER_THREAD_NAME);
        SURVEY_EVENT_HANDLER_THREAD = baseHandlerThread3;
        BaseHandlerThread baseHandlerThread4 = new BaseHandlerThread(SDK_DATA_READY_HANDLER_THREAD_NAME);
        SDK_DATA_READY_HANDLER_THREAD = baseHandlerThread4;
        baseHandlerThread.start();
        baseHandlerThread2.start();
        baseHandlerThread3.start();
        baseHandlerThread4.start();
    }

    public TuxHandlerThread() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.tuxmetersdk.export.injector.thread.ITuxHandlerThread
    public Looper getDeliveryLooper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Looper) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return DELIVERY_HANDLER_THREAD.getLooper();
    }

    @Override // com.tencent.tuxmetersdk.export.injector.thread.ITuxHandlerThread
    public Looper getSDKDataReadyLooper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Looper) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return SDK_DATA_READY_HANDLER_THREAD.getLooper();
    }

    @Override // com.tencent.tuxmetersdk.export.injector.thread.ITuxHandlerThread
    public Looper getSurveyEventLooper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Looper) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return SURVEY_EVENT_HANDLER_THREAD.getLooper();
    }

    @Override // com.tencent.tuxmetersdk.export.injector.thread.ITuxHandlerThread
    public Looper getTriggerLooper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Looper) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return TRIGGER_HANDLER_THREAD.getLooper();
    }
}
