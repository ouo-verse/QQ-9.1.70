package com.tencent.mobileqq.ark.core;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArkAppHandler extends BusinessHandler {

    /* renamed from: d, reason: collision with root package name */
    protected static final String[] f199287d = {ArkAppHandler.class.getName()};

    public ArkAppHandler(AppInterface appInterface) {
        super(appInterface);
    }

    private Object F2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String str = null;
        try {
            Proto$EchoRsp mergeFrom = new Proto$EchoRsp().mergeFrom((byte[]) obj);
            if (mergeFrom == null) {
                return null;
            }
            if (mergeFrom.f199324msg.has()) {
                str = mergeFrom.f199324msg.get();
            }
            if (str == null) {
                return "";
            }
            return str;
        } catch (Exception unused) {
            return null;
        }
    }

    void D2(String str, boolean z16, byte[] bArr, int i3, int i16, BusinessObserver businessObserver) {
        ToServiceMsg createToServiceMsg = super.createToServiceMsg(str, businessObserver);
        createToServiceMsg.addAttribute("SendTime", Long.valueOf(System.currentTimeMillis()));
        createToServiceMsg.addAttribute("IsGenericCmd", Boolean.valueOf(z16));
        createToServiceMsg.addAttribute("IsPanelRequest", Boolean.FALSE);
        createToServiceMsg.addAttribute("NotifyType", Integer.valueOf(i16));
        createToServiceMsg.putWupBuffer(bArr);
        if (i3 > 0) {
            createToServiceMsg.setTimeout(i3);
        }
        if (!com.tencent.mobileqq.service.a.c(str)) {
            com.tencent.mobileqq.service.a.g(str, f199287d);
        }
        super.sendPbReq(createToServiceMsg);
    }

    protected final Object E2(Object obj) {
        String str;
        try {
            str = new String((byte[]) obj, "UTF-8");
        } catch (Exception unused) {
            QLog.i("ArkApp.BusinessHandler", 1, String.format("onReceive_AppMsg, fail convert data to string", new Object[0]));
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public boolean G2(String str, int i3, int i16, BusinessObserver businessObserver) {
        if (!TextUtils.isEmpty(str) && businessObserver != null) {
            ToServiceMsg createToServiceMsg = super.createToServiceMsg(str, businessObserver);
            createToServiceMsg.addAttribute("SendTime", Long.valueOf(System.currentTimeMillis()));
            Boolean bool = Boolean.TRUE;
            createToServiceMsg.addAttribute("IsGenericCmd", bool);
            createToServiceMsg.addAttribute("IsPanelRequest", bool);
            createToServiceMsg.addAttribute("NotifyType", Integer.valueOf(i16));
            if (i3 > 0) {
                createToServiceMsg.setTimeout(i3);
            }
            if (!com.tencent.mobileqq.service.a.c(str)) {
                com.tencent.mobileqq.service.a.g(str, f199287d);
            }
            super.sendPbReq(createToServiceMsg);
            return true;
        }
        return false;
    }

    public boolean H2(String str, String str2, int i3, int i16, BusinessObserver businessObserver) {
        if (!TextUtils.isEmpty(str) && businessObserver != null) {
            if (str2 == null) {
                str2 = "";
            }
            try {
                D2(str, true, str2.getBytes("UTF-8"), i3, i16, businessObserver);
                return true;
            } catch (Exception unused) {
                QLog.i("ArkApp.BusinessHandler", 1, String.format("sendAppMsg, fail convert content to bytes array, cmd=%s, content=%s", str, str2));
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x008e  */
    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean isSuccess = fromServiceMsg.isSuccess();
        long currentTimeMillis = System.currentTimeMillis() - ((Long) toServiceMsg.getAttribute("SendTime")).longValue();
        boolean booleanValue = ((Boolean) toServiceMsg.getAttribute("IsGenericCmd")).booleanValue();
        boolean booleanValue2 = ((Boolean) toServiceMsg.getAttribute("IsPanelRequest")).booleanValue();
        int intValue = ((Integer) toServiceMsg.getAttribute("NotifyType")).intValue();
        String serviceCmd = fromServiceMsg.getServiceCmd();
        QLog.i("ArkApp.BusinessHandler", 1, String.format("onReceive, cmd=%s, app-msg=%s, panelRequest=%s, suc=%s, delay=%d, ", serviceCmd, Boolean.toString(booleanValue), Boolean.toString(booleanValue2), Boolean.toString(isSuccess), Long.valueOf(currentTimeMillis)));
        if (isSuccess) {
            if (booleanValue) {
                if (!booleanValue2) {
                    obj = E2(obj);
                }
            } else if (serviceCmd.equalsIgnoreCase("ArkAppSvc.Echo")) {
                obj = F2(toServiceMsg, fromServiceMsg, obj);
            }
            if (obj == null) {
                super.notifyUI(toServiceMsg, intValue, true, obj);
                return;
            } else {
                super.notifyUI(toServiceMsg, intValue, false, (Object) null);
                return;
            }
        }
        obj = null;
        if (obj == null) {
        }
    }
}
