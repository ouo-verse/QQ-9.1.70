package com.tencent.mobileqq.qqgift.sso;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseBusinessHandler;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QQGiftBusinessHandler extends BusinessHandler {
    static IPatchRedirector $redirector_ = null;
    protected static final String[] HandlerId;
    public static final int PLAT_ID = 109;
    public static final String QQ_GIFT_HANDLER;
    private static final String TAG = "QQGiftBusinessHandler";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28960);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            QQ_GIFT_HANDLER = QQGiftBusinessHandler.class.getName();
            HandlerId = new String[]{QQGiftBusinessHandler.class.getName(), "com.tencent.mobileqq.qqlive.sso.QQLiveBusinessHandler"};
        }
    }

    protected QQGiftBusinessHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$selfDispatchMessage$0(BusinessObserver businessObserver, int i3, boolean z16, Object obj) {
        try {
            businessObserver.onUpdate(i3, z16, obj);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "onUpdate failed ", e16);
        }
    }

    private byte[] packSendBuffer(int i3, byte[] bArr, String str, String str2) {
        en0.b bVar = new en0.b();
        bVar.f396841f = bArr;
        bVar.f396855t = "1.1.0";
        String str3 = AppSetting.f99551k;
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        bVar.f396856u = str3;
        bVar.f396857v = str;
        bVar.f396858w = str2;
        bVar.f396859z = 109;
        bVar.f396848m = "";
        bVar.f396853r = "";
        bVar.f396850o = new en0.a[0];
        bVar.f396854s = new en0.d[0];
        bVar.A = 0;
        bVar.B = i3;
        return MessageNano.toByteArray(bVar);
    }

    private void selfDispatchMessage(final int i3, final boolean z16, final Object obj, final BusinessObserver businessObserver, boolean z17) {
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.qqgift.sso.b
            @Override // java.lang.Runnable
            public final void run() {
                QQGiftBusinessHandler.lambda$selfDispatchMessage$0(BusinessObserver.this, i3, z16, obj);
            }
        };
        if (z17) {
            ThreadManagerV2.getUIHandlerV2().post(runnable);
        } else {
            ThreadManagerV2.excute(runnable, 16, null, false);
        }
    }

    private void selfNotifyUI(ToServiceMsg toServiceMsg, int i3, boolean z16, Object obj) {
        Bundle bundle = toServiceMsg.extraData;
        String str = BaseBusinessHandler.SEQ_KEY;
        if (bundle.containsKey(str)) {
            long j3 = toServiceMsg.extraData.getLong(str);
            synchronized (this.uiObserverMap) {
                BusinessObserver remove = this.uiObserverMap.remove(Long.valueOf(j3));
                if (remove != null) {
                    selfDispatchMessage(i3, z16, obj, remove, true);
                    return;
                }
                synchronized (this.bgObserverMap) {
                    BusinessObserver remove2 = this.bgObserverMap.remove(Long.valueOf(j3));
                    if (remove2 != null) {
                        selfDispatchMessage(i3, z16, obj, remove2, false);
                        return;
                    }
                }
            }
        }
        notifyUI(i3, z16, obj);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0119  */
    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        int intValue = ((Integer) toServiceMsg.getAttribute("gift_notify_type", 0)).intValue();
        String str2 = (String) toServiceMsg.getAttribute("gift_cmd");
        int intValue2 = ((Integer) toServiceMsg.getAttribute("gift_app_id", 0)).intValue();
        boolean booleanValue = ((Boolean) toServiceMsg.getAttribute("gift_self_notify", Boolean.FALSE)).booleanValue();
        Object attribute = toServiceMsg.getAttribute("gift_extra_data");
        if (msgCmdFilter(serviceCmd)) {
            QLog.e(TAG, 1, "[Gift SSO] onReceive msgCmdFilter, cmd:" + serviceCmd + ", trulyCmd:[" + str2 + "]");
            return;
        }
        boolean isSuccess = fromServiceMsg.isSuccess();
        if (isSuccess) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "[Gift SSO] onReceive cmd[" + str2 + "] success");
            }
        } else {
            int businessFailCode = fromServiceMsg.getBusinessFailCode();
            String businessFailMsg = fromServiceMsg.getBusinessFailMsg();
            if (QLog.isColorLevel()) {
                str = "]";
                QLog.i(TAG, 2, "[Gift SSO] onReceive cmd[" + str2 + "] fail,, failCode:" + businessFailCode + ", failMsg:" + businessFailMsg);
                if (!(obj instanceof byte[])) {
                    d dVar = new d(intValue2, fromServiceMsg, (byte[]) obj, str2, this.seq);
                    if (attribute instanceof Bundle) {
                        dVar.c((Bundle) attribute);
                    }
                    if (booleanValue) {
                        selfNotifyUI(toServiceMsg, intValue, isSuccess, dVar);
                        return;
                    } else {
                        notifyUI(toServiceMsg, intValue, isSuccess, dVar);
                        return;
                    }
                }
                QLog.e(TAG, 1, "[Gift SSO] onReceive data wrong, cmd:" + serviceCmd + ", trulyCmd:[" + str2 + str);
                return;
            }
        }
        str = "]";
        if (!(obj instanceof byte[])) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendQQGiftReq(int i3, String str, String str2, byte[] bArr, int i16, int i17, boolean z16, BusinessObserver businessObserver, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), str, str2, bArr, Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z16), businessObserver, bundle);
            return;
        }
        String str3 = str + "." + str2;
        ToServiceMsg createToServiceMsg = super.createToServiceMsg("trpc.qlive.qlive_proxy_svr.TrpcProxy.*", businessObserver);
        createToServiceMsg.addAttribute("gift_self_notify", Boolean.valueOf(z16));
        createToServiceMsg.addAttribute("gift_notify_type", Integer.valueOf(i17));
        createToServiceMsg.addAttribute("gift_cmd", str3);
        createToServiceMsg.addAttribute("gift_app_id", Integer.valueOf(i3));
        createToServiceMsg.putWupBuffer(packSendBuffer(i3, bArr, str, str2));
        createToServiceMsg.addAttribute(MobileQQServiceBase.REQ_PB_PROTOCOL_FLAG, Boolean.TRUE);
        if (bundle != null) {
            createToServiceMsg.addAttribute("gift_extra_data", bundle);
        }
        if (i16 > 0) {
            long j3 = i16;
            createToServiceMsg.setTimeout(j3);
            createToServiceMsg.setSendTimeout(j3);
        }
        if (!com.tencent.mobileqq.service.a.c("trpc.qlive.qlive_proxy_svr.TrpcProxy.*")) {
            com.tencent.mobileqq.service.a.g("trpc.qlive.qlive_proxy_svr.TrpcProxy.*", HandlerId);
        }
        AppInterface a16 = com.tencent.mobileqq.qqgift.utils.a.a();
        if (a16 == null) {
            QLog.e(TAG, 1, "[sendQQGiftReq] appInterface is null");
        } else {
            createToServiceMsg.extraData.putString("moduleId", com.tencent.mobileqq.qqgift.utils.a.b());
            a16.sendToService(createToServiceMsg);
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "[sendQQGiftReq] onSend cmd:[" + str3 + "]");
        }
    }

    protected void sendQQGiftReq(int i3, String str, String str2, byte[] bArr, int i16, int i17, BusinessObserver businessObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            sendQQGiftReq(i3, str, str2, bArr, i16, i17, false, businessObserver, null);
        } else {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), str, str2, bArr, Integer.valueOf(i16), Integer.valueOf(i17), businessObserver);
        }
    }
}
