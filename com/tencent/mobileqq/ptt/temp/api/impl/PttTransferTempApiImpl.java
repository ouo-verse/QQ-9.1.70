package com.tencent.mobileqq.ptt.temp.api.impl;

import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.app.bs;
import com.tencent.mobileqq.ptt.temp.api.IPttTransferTempApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.IC2CPttUploadProcessor;
import com.tencent.mobileqq.transfile.IGroupPttUploadProcessor;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes16.dex */
public class PttTransferTempApiImpl implements IPttTransferTempApi {
    static IPatchRedirector $redirector_;

    /* loaded from: classes16.dex */
    class a extends bs {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        IC2CPttUploadProcessor f261291d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IC2CPttUploadProcessor f261292e;

        a(IC2CPttUploadProcessor iC2CPttUploadProcessor) {
            this.f261292e = iC2CPttUploadProcessor;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PttTransferTempApiImpl.this, (Object) iC2CPttUploadProcessor);
            } else {
                this.f261291d = iC2CPttUploadProcessor;
            }
        }

        @Override // com.tencent.mobileqq.app.bs
        public void onNotifyResultAfterSendRich(boolean z16, long j3, StatictisInfo statictisInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Long.valueOf(j3), statictisInfo);
                return;
            }
            this.f261291d.logRichMediaEvent("sendMsgFinish", "success:" + z16);
            IC2CPttUploadProcessor iC2CPttUploadProcessor = this.f261291d;
            iC2CPttUploadProcessor.copyStatisInfo(iC2CPttUploadProcessor.getStepMsg(), false, z16, statictisInfo);
            if (z16) {
                this.f261291d.onSuccess();
            } else {
                this.f261291d.onError();
            }
        }
    }

    /* loaded from: classes16.dex */
    class b extends bs {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        IGroupPttUploadProcessor f261294d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IGroupPttUploadProcessor f261295e;

        b(IGroupPttUploadProcessor iGroupPttUploadProcessor) {
            this.f261295e = iGroupPttUploadProcessor;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PttTransferTempApiImpl.this, (Object) iGroupPttUploadProcessor);
            } else {
                this.f261294d = iGroupPttUploadProcessor;
            }
        }

        @Override // com.tencent.mobileqq.app.bs
        public void onNotifyResultAfterSendRich(boolean z16, long j3, StatictisInfo statictisInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Long.valueOf(j3), statictisInfo);
                return;
            }
            if (this.f261294d.getRequest().mUinType == 1026 && QLog.isColorLevel()) {
                QLog.i("PttShow", 2, "onNotifyResultAfterSendRich, UIN_TYPE_HOTCHAT_TOPIC  " + z16);
            }
            this.f261294d.logRichMediaEvent("sendMsgFinish", "success:" + z16);
            IGroupPttUploadProcessor iGroupPttUploadProcessor = this.f261294d;
            iGroupPttUploadProcessor.copyStatisInfo(iGroupPttUploadProcessor.getStepMsg(), false, z16, statictisInfo);
            if (z16) {
                this.f261294d.onSuccess();
                return;
            }
            if (statictisInfo != null) {
                this.f261294d.setShouldMsgReportSucc(statictisInfo.reportSucc);
            }
            this.f261294d.onError();
        }
    }

    public PttTransferTempApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.ptt.temp.api.IPttTransferTempApi
    public BaseMessageObserver getC2CPttUploadProcessorMsgObserver(IC2CPttUploadProcessor iC2CPttUploadProcessor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BaseMessageObserver) iPatchRedirector.redirect((short) 2, (Object) this, (Object) iC2CPttUploadProcessor);
        }
        return new a(iC2CPttUploadProcessor);
    }

    @Override // com.tencent.mobileqq.ptt.temp.api.IPttTransferTempApi
    public BaseMessageObserver getGroupPttUploadProcessorMsgObserver(IGroupPttUploadProcessor iGroupPttUploadProcessor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BaseMessageObserver) iPatchRedirector.redirect((short) 3, (Object) this, (Object) iGroupPttUploadProcessor);
        }
        return new b(iGroupPttUploadProcessor);
    }
}
