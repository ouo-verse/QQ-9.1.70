package com.tencent.mobileqq.pttlogic.api.impl;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ptt.preop.b;
import com.tencent.mobileqq.ptt.preop.c;
import com.tencent.mobileqq.ptt.preop.d;
import com.tencent.mobileqq.pttlogic.api.IPttPreSendService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.BaseUploadProcessor;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

/* loaded from: classes16.dex */
public class PttPreSendServiceImpl implements IPttPreSendService {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "PttPreSendManager";
    AppRuntime mApp;
    int mFileSize;
    c mFlowController;
    boolean mIsWifi;
    volatile boolean mIsWorking;
    MessageRecord mMessage;
    String mPath;
    b mStrategy;
    String mTempPath;
    int mType;
    d mVoiceChanger;
    public boolean sCpuSupport;
    private ConcurrentHashMap<String, a> sTasks;

    /* loaded from: classes16.dex */
    static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        String f261304a;

        /* renamed from: b, reason: collision with root package name */
        String f261305b;
    }

    public PttPreSendServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mType = -1;
        this.mFileSize = 0;
        this.sCpuSupport = false;
        this.mIsWorking = false;
        this.sTasks = new ConcurrentHashMap<>();
    }

    @Override // com.tencent.mobileqq.pttlogic.api.IPttPreSendService
    public void cleanUp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (!this.mIsWorking) {
            return;
        }
        this.mIsWorking = false;
        this.mPath = null;
        this.mTempPath = null;
        this.mMessage = null;
        if (QLog.isDevelopLevel()) {
            QLog.e(TAG, 4, "clean up");
        }
    }

    @Override // com.tencent.mobileqq.pttlogic.api.IPttPreSendService
    public void doOnCancelSend() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.mStrategy.b(null, -1);
        if (!this.mIsWorking) {
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.e(TAG, 4, "doOnCancelSend");
        }
        ITransFileController iTransFileController = (ITransFileController) this.mApp.getRuntimeService(ITransFileController.class, "all");
        String str = this.mMessage.frienduin + this.mMessage.uniseq;
        BaseUploadProcessor baseUploadProcessor = (BaseUploadProcessor) iTransFileController.findProcessor(str);
        if (baseUploadProcessor != null) {
            baseUploadProcessor.cancel();
        }
        this.sTasks.remove(str);
        this.mVoiceChanger.c();
        cleanUp();
    }

    @Override // com.tencent.mobileqq.pttlogic.api.IPttPreSendService
    public void doOnPreSendEnd(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        a remove = this.sTasks.remove(str);
        if (remove != null) {
            File file = new File(remove.f261305b);
            if (file.exists()) {
                File file2 = new File(remove.f261304a);
                if (file2.exists()) {
                    file2.delete();
                }
                file.renameTo(file2);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "rename presend file ! , from " + remove.f261305b + " to " + remove.f261304a);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.pttlogic.api.IPttPreSendService
    public void init() {
        int c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (!this.sCpuSupport && ((c16 = com.tencent.mobileqq.qqaudio.c.c()) == 3 || c16 == 4 || c16 == 5)) {
            this.sCpuSupport = true;
        }
        this.mFlowController = new c(this.mApp, 100000, 10000000, IPttPreSendService.FLOW_REFRESH_TIME);
        this.mStrategy = new b(this.mApp);
        this.mVoiceChanger = new d();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "init manager end ");
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) appRuntime);
        } else {
            this.mApp = appRuntime;
            init();
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        c cVar = this.mFlowController;
        if (cVar != null) {
            cVar.b();
        }
        b bVar = this.mStrategy;
        if (bVar != null) {
            bVar.c(this.mApp);
        }
    }
}
