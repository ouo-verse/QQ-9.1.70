package com.tencent.mobileqq.kandian.base.msf;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.kandian.base.utils.e;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.transfile.ProtoServlet;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ReadInJoyMSFService {

    /* renamed from: d, reason: collision with root package name */
    private static ReadInJoyMSFService f239064d;

    /* renamed from: a, reason: collision with root package name */
    private int f239065a = 0;

    /* renamed from: b, reason: collision with root package name */
    private DecimalFormat f239066b = new DecimalFormat("0.00");

    /* renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<Integer, WeakReference<a>> f239067c = new ConcurrentHashMap<>();

    ReadInJoyMSFService() {
    }

    private void e(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        WeakReference<a> weakReference;
        a aVar;
        Integer num = (Integer) toServiceMsg.getAttributes().get("seq");
        if (num == null || (weakReference = this.f239067c.get(num)) == null || (aVar = weakReference.get()) == null) {
            return;
        }
        aVar.onReceive(toServiceMsg, fromServiceMsg, obj);
    }

    public static ReadInJoyMSFService f() {
        if (f239064d == null) {
            f239064d = new ReadInJoyMSFService();
        }
        return f239064d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i(ToServiceMsg toServiceMsg) {
        boolean z16 = false;
        if (toServiceMsg.getAttribute("isRetryRequest") != null) {
            boolean booleanValue = ((Boolean) toServiceMsg.getAttribute("isRetryRequest")).booleanValue();
            QLog.d("ReadInJoyMSFService", 1, "is68bRetryReq = ", Boolean.valueOf(booleanValue));
            z16 = booleanValue;
        }
        if (z16) {
            QLog.d("ReadInJoyMSFService", 1, " isRetryRequest | 68b Retry");
        }
        return z16;
    }

    public void g(final ToServiceMsg toServiceMsg) {
        e.b().post(new Runnable() { // from class: com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService.2
            @Override // java.lang.Runnable
            public void run() {
                String str;
                boolean z16;
                if (QLog.isColorLevel()) {
                    QLog.d("ReadInJoyMSFService", 2, "req cmd: " + toServiceMsg.getServiceCmd());
                }
                try {
                    if (!((Boolean) toServiceMsg.getAttribute(MobileQQServiceBase.REQ_PB_PROTOCOL_FLAG, Boolean.FALSE)).booleanValue() || toServiceMsg.getWupBuffer() == null) {
                        z16 = false;
                    } else {
                        if (!ReadInJoyMSFService.this.i(toServiceMsg)) {
                            long length = toServiceMsg.getWupBuffer().length;
                            int i3 = (int) length;
                            byte[] bArr = new byte[i3 + 4];
                            PkgTools.dWord2Byte(bArr, 0, length + 4);
                            PkgTools.copyData(bArr, 4, toServiceMsg.getWupBuffer(), i3);
                            toServiceMsg.putWupBuffer(bArr);
                        } else {
                            QLog.d("ReadInJoyMSFService", 1, "handleRequest | isRetryRequest ");
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("ReadInJoyMSFService", 2, "PB cmd: req cmd: " + toServiceMsg.getServiceCmd());
                        }
                        z16 = true;
                    }
                    if (z16) {
                        NewIntent newIntent = new NewIntent(com.tencent.mobileqq.kandian.base.utils.b.c().getApplication(), b.class);
                        newIntent.putExtra(ToServiceMsg.class.getSimpleName(), toServiceMsg);
                        if (toServiceMsg.getAttributes().get("req_enable_msf_retry") != null ? ((Boolean) toServiceMsg.getAttributes().get("req_enable_msf_retry")).booleanValue() : false) {
                            toServiceMsg.setTimeout(360000L);
                            newIntent.putExtra(ProtoServlet.QUICK_SEND_ENABLE, true);
                            newIntent.putExtra(ProtoServlet.QUICK_SEND_STRATEGY, 0);
                            QLog.d("ReadInJoyMSFService", 2, "handleRequest | MSF retry enabled");
                        }
                        com.tencent.mobileqq.kandian.base.utils.b.c().startServlet(newIntent);
                        toServiceMsg.extraData.putLong("sendtimekey", System.currentTimeMillis());
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                    if (QLog.isColorLevel()) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("handleRequest Exception. cmd=");
                        ToServiceMsg toServiceMsg2 = toServiceMsg;
                        if (toServiceMsg2 != null) {
                            str = toServiceMsg2.getServiceCmd();
                        } else {
                            str = "";
                        }
                        sb5.append(str);
                        QLog.e("ReadInJoyMSFService", 2, sb5.toString(), e16);
                    }
                    FromServiceMsg fromServiceMsg = new FromServiceMsg(toServiceMsg.getUin(), toServiceMsg.getServiceCmd());
                    fromServiceMsg.setMsgFail();
                    ReadInJoyMSFService.this.h(false, toServiceMsg, fromServiceMsg, e16);
                }
            }
        });
    }

    public void h(boolean z16, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Exception exc) {
        if (toServiceMsg == null) {
            return;
        }
        float currentTimeMillis = ((float) (System.currentTimeMillis() - toServiceMsg.extraData.getLong("sendtimekey"))) / 1000.0f;
        if (z16) {
            if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyMSFService", 2, "[RES]cmd=" + fromServiceMsg.getServiceCmd() + " app seq:" + fromServiceMsg.getAppSeq() + " during " + this.f239066b.format(currentTimeMillis) + "sec.");
            }
        } else {
            if (fromServiceMsg.getResultCode() == 2008) {
                Context context = BaseActivity.sTopActivity;
                if (context == null) {
                    context = com.tencent.mobileqq.kandian.base.utils.b.c().getApplication();
                }
                Intent intent = new Intent();
                intent.setFlags(872415232);
                intent.putExtra("type", 2);
                RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTER_NOTIFICATION);
                return;
            }
            if (exc != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                exc.printStackTrace(new PrintStream(byteArrayOutputStream));
                String str = new String(byteArrayOutputStream.toByteArray());
                if (QLog.isColorLevel()) {
                    QLog.d("ReadInJoyMSFService", 2, "[NOT SEND]cmd=" + fromServiceMsg.getServiceCmd() + ", " + str);
                }
            } else if (QLog.isColorLevel()) {
                QLog.w("ReadInJoyMSFService", 2, "[RES]cmd=" + fromServiceMsg.getServiceCmd() + ",CODE=" + fromServiceMsg.getResultCode() + " during " + this.f239066b.format(currentTimeMillis) + "sec.");
            }
        }
        boolean booleanValue = ((Boolean) toServiceMsg.getAttribute(MobileQQServiceBase.REQ_PB_PROTOCOL_FLAG, Boolean.FALSE)).booleanValue();
        if (QLog.isDevelopLevel()) {
            QLog.d("ReadInJoy", 4, "bPbResp:" + booleanValue);
        }
        byte[] bArr = null;
        if (z16) {
            if (booleanValue) {
                if (QLog.isColorLevel()) {
                    QLog.d("ReadInJoyMSFService", 2, "PB cmd: recv cmd: " + fromServiceMsg.getServiceCmd());
                }
                if (fromServiceMsg.getWupBuffer() != null) {
                    int length = fromServiceMsg.getWupBuffer().length - 4;
                    byte[] bArr2 = new byte[length];
                    PkgTools.copyData(bArr2, 0, fromServiceMsg.getWupBuffer(), 4, length);
                    fromServiceMsg.putWupBuffer(bArr2);
                    bArr = fromServiceMsg.getWupBuffer();
                }
            } else {
                try {
                    if (QLog.isColorLevel()) {
                        QLog.d("ReadInJoyMSFService", 2, "bpc null");
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.d("ReadInJoyMSFService", 2, "", e16);
                    }
                }
            }
        }
        e(toServiceMsg, fromServiceMsg, bArr);
    }

    public final void j(final ToServiceMsg toServiceMsg, a aVar) {
        if (toServiceMsg == null || aVar == null) {
            return;
        }
        toServiceMsg.addAttribute(MobileQQServiceBase.REQ_PB_PROTOCOL_FLAG, Boolean.TRUE);
        final WeakReference weakReference = new WeakReference(aVar);
        e.b().post(new Runnable() { // from class: com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService.1
            @Override // java.lang.Runnable
            public void run() {
                ReadInJoyMSFService readInJoyMSFService = ReadInJoyMSFService.this;
                int i3 = readInJoyMSFService.f239065a;
                readInJoyMSFService.f239065a = i3 + 1;
                toServiceMsg.getAttributes().put("seq", Integer.valueOf(i3));
                ReadInJoyMSFService.this.f239067c.put(Integer.valueOf(i3), weakReference);
            }
        });
        g(toServiceMsg);
    }
}
