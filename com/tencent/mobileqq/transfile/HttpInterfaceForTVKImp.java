package com.tencent.mobileqq.transfile;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.security.InvalidParameterException;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class HttpInterfaceForTVKImp extends HttpInterfaceForTVK {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "HttpInterfaceForTVKImp";
    private boolean bComPleted;
    private int errorCode;
    public String mErrDesc;
    public int mHttpCode;
    private NetEngineResponseListener mINetEngineListener;
    private Object obj;
    private int result;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class NetEngineResponseListener implements INetEngineListener {
        static IPatchRedirector $redirector_;

        NetEngineResponseListener() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HttpInterfaceForTVKImp.this);
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                synchronized (HttpInterfaceForTVKImp.this.obj) {
                    HttpInterfaceForTVKImp.this.result = netResp.mResult;
                    HttpInterfaceForTVKImp.this.errorCode = netResp.mErrCode;
                    HttpInterfaceForTVKImp httpInterfaceForTVKImp = HttpInterfaceForTVKImp.this;
                    httpInterfaceForTVKImp.mErrDesc = netResp.mErrDesc;
                    httpInterfaceForTVKImp.mHttpCode = netResp.mHttpCode;
                    httpInterfaceForTVKImp.bComPleted = true;
                    if (QLog.isColorLevel()) {
                        QLog.d(HttpInterfaceForTVKImp.TAG, 2, "onResp, result = " + HttpInterfaceForTVKImp.this.result + " , errorCode = " + HttpInterfaceForTVKImp.this.errorCode + " , mErrDesc = " + HttpInterfaceForTVKImp.this.mErrDesc + " , mHttpCode = " + HttpInterfaceForTVKImp.this.mHttpCode);
                    }
                    HttpInterfaceForTVKImp.this.obj.notify();
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) netResp);
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, netReq, Long.valueOf(j3), Long.valueOf(j16));
            }
        }
    }

    public HttpInterfaceForTVKImp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.obj = new Object();
            this.mINetEngineListener = new NetEngineResponseListener();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int downLoadSync(String str, String str2) {
        HttpNetReq httpNetReq;
        AppRuntime runtime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2)).intValue();
        }
        this.bComPleted = false;
        if (str != null && str2 != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "downLoadSync, url = " + str + ", filePath = " + str2);
            }
            try {
                httpNetReq = new HttpNetReq();
                httpNetReq.mCallback = this.mINetEngineListener;
                httpNetReq.mReqUrl = str;
                httpNetReq.mHttpMethod = 0;
                httpNetReq.mOutPath = str2;
                httpNetReq.mMsgId = String.valueOf(System.currentTimeMillis());
                runtime = BaseApplicationImpl.getApplication().getRuntime();
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "downLoadSync, setp 1", e16);
                }
            }
            if (runtime instanceof QQAppInterface) {
                ((IHttpEngineService) ((QQAppInterface) runtime).getRuntimeService(IHttpEngineService.class, "all")).sendReq(httpNetReq);
                synchronized (this.obj) {
                    while (!this.bComPleted) {
                        try {
                            this.obj.wait(600000L);
                        } catch (InterruptedException e17) {
                            if (QLog.isColorLevel()) {
                                QLog.e(TAG, 2, "downLoadSync, setp 2", e17);
                            }
                        }
                    }
                }
                HashMap<String, String> hashMap = new HashMap<>();
                if (this.result == 0) {
                    hashMap.put("param_isSuccess", "1");
                } else {
                    hashMap.put("param_isSuccess", "0");
                }
                hashMap.put("param_ErrorCode", String.valueOf(this.errorCode));
                hashMap.put("param_ErrDesc", this.mErrDesc);
                hashMap.put("param_HttpCode", String.valueOf(this.mHttpCode));
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, TAG, true, 0L, 0L, hashMap, "");
                return this.result;
            }
            throw new InvalidParameterException("can't get AppInterface");
        }
        return -1;
    }
}
