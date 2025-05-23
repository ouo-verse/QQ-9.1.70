package com.tencent.mobileqq.webview.webso;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import mqq.observer.BusinessObserver;
import wns_proxy.HttpReq;
import wns_proxy.HttpRsp;

/* compiled from: P */
/* loaded from: classes20.dex */
public class WebSoServlet extends MSFServlet {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private ToServiceMsg f314988d;

    /* renamed from: e, reason: collision with root package name */
    private long f314989e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class ReceiveRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private int f314990d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f314991e;

        /* renamed from: f, reason: collision with root package name */
        private Bundle f314992f;

        public ReceiveRunnable(int i3, boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                return;
            }
            this.f314990d = i3;
            this.f314991e = z16;
            this.f314992f = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                c.c().onReceive(this.f314990d, this.f314991e, this.f314992f);
            }
        }
    }

    public WebSoServlet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f314989e = 0L;
        }
    }

    public static Intent a(Intent intent, long j3, String str, HttpReq httpReq, String str2, int i3, int i16, String str3, Class<? extends BusinessObserver> cls) {
        Intent c16 = c(intent, j3, str, httpReq, str2, i3, i16, cls);
        c16.putExtra("key_uni_key", str3);
        return c16;
    }

    public static Intent b(Intent intent, long j3, String str, HttpReq httpReq, String str2) {
        return c(intent, j3, str, httpReq, str2, 60000, 100, WebSoService.class);
    }

    public static Intent c(Intent intent, long j3, String str, HttpReq httpReq, String str2, int i3, int i16, Class<? extends BusinessObserver> cls) {
        if (intent == null) {
            intent = new Intent();
        }
        intent.putExtra("hostUin", j3);
        intent.putExtra(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, httpReq);
        intent.putExtra("refer", str2);
        intent.putExtra("url", str);
        intent.putExtra("key_time_out", i3);
        intent.putExtra("key_request_code", i16);
        intent.putExtra("key_receive_class", cls);
        return intent;
    }

    private void d(FromServiceMsg fromServiceMsg, Bundle bundle, String str) {
        if (fromServiceMsg != null) {
            Object attribute = fromServiceMsg.getAttribute(BaseConstants.Attribute_TAG_SOCKET_ADDRESS);
            String[] strArr = new String[2];
            if (attribute != null && (strArr = attribute.toString().split(":")) != null && strArr.length > 1) {
                bundle.putString("key_server_ip", strArr[0]);
                bundle.putString("key_server_port", strArr[1]);
            }
            bundle.putString("key_user_ip", "");
            if (strArr != null && strArr.length > 0) {
                bundle.putString("key_dns_result", strArr[0]);
            }
            bundle.putInt("key_time_cost", (int) (System.currentTimeMillis() - this.f314989e));
        }
    }

    private static boolean e() {
        if (1 == QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_WNS_CGI_ENABLE_OPTIMIZATION, 1)) {
            return true;
        }
        return false;
    }

    @Override // mqq.app.Servlet
    public void notifyObserver(Intent intent, int i3, boolean z16, Bundle bundle, Class<? extends BusinessObserver> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, intent, Integer.valueOf(i3), Boolean.valueOf(z16), bundle, cls);
        } else if (cls == c.class && e()) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).getHandler().post(new ReceiveRunnable(i3, z16, bundle));
        } else {
            super.notifyObserver(intent, i3, z16, bundle, cls);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        if (intent == null) {
            QLog.e("WebSoServlet", 2, "onReceive, request is null");
            return;
        }
        Bundle bundle = new Bundle();
        String stringExtra = intent.getStringExtra("url");
        bundle.putString("url", stringExtra);
        if (fromServiceMsg != null) {
            bundle.putInt("rsp_code", fromServiceMsg.getResultCode());
            bundle.putString("rsp_message", fromServiceMsg.getBusinessFailMsg());
        }
        int intExtra = intent.getIntExtra("key_request_code", 100);
        Class<? extends BusinessObserver> cls = (Class) intent.getSerializableExtra("key_receive_class");
        if (cls == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("receive url: ");
        sb5.append(stringExtra);
        sb5.append(", code: ");
        if (fromServiceMsg != null) {
            i3 = fromServiceMsg.getResultCode();
        } else {
            i3 = -1;
        }
        sb5.append(i3);
        QLog.d("WebSoServlet", 2, sb5.toString());
        bundle.putString("key_uni_key", intent.getStringExtra("key_uni_key"));
        d(fromServiceMsg, bundle, stringExtra);
        if (fromServiceMsg != null && fromServiceMsg.getResultCode() == 1000) {
            byte[] wupBuffer = fromServiceMsg.getWupBuffer();
            String q16 = e.q(e.A(stringExtra));
            if (TextUtils.isEmpty(q16)) {
                QLog.w("WebSoServlet", 1, "uniKey is EMPTY OR NULL !!!");
                return;
            }
            bundle.putInt("rsp_code", 0);
            HttpRsp websoOnResponse = ((IVasDepTemp) QRoute.api(IVasDepTemp.class)).websoOnResponse(wupBuffer, q16);
            if (websoOnResponse != null) {
                bundle.putSerializable("rsp_data", websoOnResponse);
                notifyObserver(null, intExtra, true, bundle, cls);
                return;
            } else {
                QLog.d("WebSoServlet", 2, "inform WebSoServlet isSuccess false");
                notifyObserver(null, intExtra, false, bundle, cls);
                return;
            }
        }
        QLog.d("WebSoServlet", 2, "inform WebSoServlet resultcode fail.");
        notifyObserver(null, intExtra, false, bundle, cls);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        if (intent == null) {
            return;
        }
        long longExtra = intent.getLongExtra("hostUin", 0L);
        HttpReq httpReq = (HttpReq) intent.getSerializableExtra(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO);
        String stringExtra = intent.getStringExtra("refer");
        String stringExtra2 = intent.getStringExtra("url");
        int intExtra = intent.getIntExtra("key_time_out", 60000);
        byte[] websoEncode = ((IVasDepTemp) QRoute.api(IVasDepTemp.class)).websoEncode(e.A(stringExtra2), longExtra, httpReq, stringExtra);
        if (websoEncode == null) {
            websoEncode = new byte[4];
        }
        if (intExtra <= 0) {
            j3 = 60000;
        } else {
            j3 = intExtra;
        }
        packet.setTimeout(j3);
        packet.setSSOCommand(e.p(stringExtra2));
        packet.putSendData(websoEncode);
        if (QLog.isColorLevel()) {
            QLog.d("WebSoServlet", 2, "send req url: " + stringExtra2);
        }
        this.f314989e = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.MSFServlet
    public void sendToMSF(Intent intent, ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) toServiceMsg);
        } else {
            this.f314988d = toServiceMsg;
            super.sendToMSF(intent, toServiceMsg);
        }
    }
}
