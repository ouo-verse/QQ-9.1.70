package com.tencent.msfmqpsdkbridge;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mqpsdk.a;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes21.dex */
public class MSFNetTransportProvider extends BusinessHandler implements a {
    static IPatchRedirector $redirector_;
    private Map<String, a.InterfaceC9207a> mCodecMap;
    private Map<String, a.b> mEventListenerMap;
    private Map<String, String> mServiceNameMap;

    public MSFNetTransportProvider(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.mCodecMap = null;
        this.mEventListenerMap = null;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.mServiceNameMap = linkedHashMap;
        linkedHashMap.put("SecIntChkSvc.MainCmd", "intchk");
        this.mServiceNameMap.put("SecSafeChkSvc.MainCmd", "app_scan");
        this.mServiceNameMap.put("SecCheckSigSvc.UploadReq", "sig_check");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0087  */
    @Override // com.tencent.mqpsdk.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a.InterfaceC9207a getCodec(String str) {
        String str2;
        MSFCodec mSFCodec;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (a.InterfaceC9207a) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        if (this.mCodecMap == null) {
            this.mCodecMap = new LinkedHashMap();
        }
        if (this.mCodecMap.containsKey(str)) {
            return this.mCodecMap.get(str);
        }
        if (TextUtils.equals(str, "intchk") || TextUtils.equals(str, "app_scan") || TextUtils.equals(str, "sig_check")) {
            if (this.mServiceNameMap.containsValue(str)) {
                Iterator<String> it = this.mServiceNameMap.keySet().iterator();
                while (it.hasNext()) {
                    str2 = it.next();
                    if (this.mServiceNameMap.get(str2).equalsIgnoreCase(str)) {
                        break;
                    }
                }
            }
            str2 = null;
            if (!TextUtils.isEmpty(str2)) {
                mSFCodec = new MSFCodec(str2);
                if (mSFCodec != null) {
                    this.mCodecMap.put(str, mSFCodec);
                }
                return mSFCodec;
            }
        }
        mSFCodec = null;
        if (mSFCodec != null) {
        }
        return mSFCodec;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        a.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (obj == null || !fromServiceMsg.isSuccess() || this.mEventListenerMap == null) {
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (!this.mServiceNameMap.containsKey(serviceCmd)) {
            return;
        }
        String str = this.mServiceNameMap.get(serviceCmd);
        if (!this.mEventListenerMap.containsKey(str) || (bVar = this.mEventListenerMap.get(str)) == null) {
            return;
        }
        bVar.a(toServiceMsg, fromServiceMsg);
    }

    @Override // com.tencent.mqpsdk.a
    public int send(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, obj)).intValue();
        }
        if (obj instanceof ToServiceMsg) {
            sendPbReq((ToServiceMsg) obj);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.mqpsdk.a
    public void setNetTransportEventListener(String str, a.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) bVar);
        } else {
            if (TextUtils.isEmpty(str) || bVar == null) {
                return;
            }
            if (this.mEventListenerMap == null) {
                this.mEventListenerMap = new LinkedHashMap();
            }
            this.mEventListenerMap.put(str, bVar);
        }
    }
}
