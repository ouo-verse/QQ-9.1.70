package com.tencent.mobileqq.troop.filemanager.download;

import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.core.h;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.api.IOldHttpEngineProcessor;
import com.tencent.mobileqq.troop.filemanager.e;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a implements IHttpCommunicatorListener {
    static IPatchRedirector $redirector_;
    private InterfaceC8691a C;
    private boolean D;
    private String E;

    /* renamed from: d, reason: collision with root package name */
    private final long f295916d;

    /* renamed from: e, reason: collision with root package name */
    private final int f295917e;

    /* renamed from: f, reason: collision with root package name */
    private final int f295918f;

    /* renamed from: h, reason: collision with root package name */
    private long f295919h;

    /* renamed from: i, reason: collision with root package name */
    private HttpMsg f295920i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f295921m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.filemanager.download.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public interface InterfaceC8691a {
        void c(String str);

        void d(HttpMsg httpMsg);

        void g(HttpMsg httpMsg);

        void h(int i3, String str, String str2, HttpMsg httpMsg);

        void j(byte[] bArr, long j3, String str);

        void onEnd();
    }

    public a(long j3, int i3, int i16, long j16, boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j16), Boolean.valueOf(z16), str);
            return;
        }
        this.f295921m = true;
        this.f295916d = j3;
        this.f295917e = i3;
        this.f295918f = i16;
        this.f295919h = j16;
        this.D = z16;
        this.E = str;
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.f295921m = true;
        if (this.f295920i != null) {
            e.b.c("FtnDownloader", e.b.f295938b, "[" + this.f295916d + "] cancel ftn download");
            ((IOldHttpEngineProcessor) QRoute.api(IOldHttpEngineProcessor.class)).cancelMsg(this.f295920i);
            this.f295920i = null;
        }
    }

    protected void b(int i3, String str, String str2, HttpMsg httpMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), str, str2, httpMsg);
            return;
        }
        e.b.b("FtnDownloader", e.b.f295938b, "[" + this.f295916d + "] ftn download err. errCode:" + i3 + " errMsg:" + str + " rspHeader:" + str2);
        this.f295921m = true;
        InterfaceC8691a interfaceC8691a = this.C;
        if (interfaceC8691a != null) {
            interfaceC8691a.h(i3, str, str2, httpMsg);
        }
    }

    public boolean c(String str, long j3) {
        String str2;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, str, Long.valueOf(j3))).booleanValue();
        }
        e.b.c("FtnDownloader", e.b.f295938b, "[" + this.f295916d + "] ftn download url:" + str + " pos:" + j3);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        this.f295921m = false;
        String str4 = "bytes=" + j3 + "-";
        HttpMsg httpMsg = new HttpMsg(str, null, this, true);
        httpMsg.setInstanceFollowRedirects(false);
        if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1) {
            str2 = "wifi";
        } else {
            str2 = "gprs";
        }
        httpMsg.setRequestProperty("Net-type", str2);
        httpMsg.setRequestProperty("cache-control", "no-cache");
        if (j3 != 0) {
            httpMsg.setRequestProperty("Range", str4);
        }
        httpMsg.setPriority(5);
        httpMsg.setDataSlice(true);
        httpMsg.fileType = this.f295918f;
        httpMsg.busiType = this.f295917e;
        httpMsg.msgId = String.valueOf(this.f295916d);
        httpMsg.setRequestProperty("Accept-Encoding", "identity");
        InterfaceC8691a interfaceC8691a = this.C;
        if (interfaceC8691a != null) {
            interfaceC8691a.g(httpMsg);
        }
        if (str != null) {
            str3 = str.toLowerCase();
        } else {
            str3 = "";
        }
        if (this.D && str3.startsWith("https")) {
            httpMsg.mIsHttps = true;
            httpMsg.mIsHostIP = h.c(str);
            httpMsg.mReqHost = this.E;
        }
        httpMsg.timeoutParam = FileManagerUtil.getTimeOutParamer();
        ((IOldHttpEngineProcessor) QRoute.api(IOldHttpEngineProcessor.class)).sendMsg(httpMsg);
        this.f295920i = httpMsg;
        return true;
    }

    public void d(InterfaceC8691a interfaceC8691a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) interfaceC8691a);
        } else {
            this.C = interfaceC8691a;
        }
    }

    @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
    public void decode(HttpMsg httpMsg, HttpMsg httpMsg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) httpMsg, (Object) httpMsg2);
            return;
        }
        if (this.f295921m) {
            return;
        }
        HttpMsg httpMsg3 = this.f295920i;
        if (httpMsg != httpMsg3) {
            if (httpMsg != null && httpMsg3 != null) {
                e.b.b("FtnDownloader", e.b.f295938b, "[" + this.f295916d + "],Req Serial[" + String.valueOf(httpMsg.getSerial()) + "], curRequest Serial[" + String.valueOf(this.f295920i.getSerial()) + "]");
                return;
            }
            if (httpMsg != null) {
                e.b.b("FtnDownloader", e.b.f295938b, "[" + this.f295916d + "],Req Serial[" + String.valueOf(httpMsg.getSerial()) + "]");
                return;
            }
            if (httpMsg3 != null) {
                e.b.b("FtnDownloader", e.b.f295938b, "[" + this.f295916d + "],curRequest Serial[" + String.valueOf(this.f295920i.getSerial()) + "]");
                return;
            }
            return;
        }
        if (httpMsg2.getResponseCode() != 206 && httpMsg2.getResponseCode() != 200) {
            e.b.b("FtnDownloader", e.b.f295938b, "[" + this.f295916d + "] ftn download decode resp code no 200|206");
            return;
        }
        byte[] recvData = httpMsg2.getRecvData();
        long totalLen = httpMsg2.getTotalLen();
        if (this.f295919h == 0) {
            this.f295919h = totalLen;
        }
        InterfaceC8691a interfaceC8691a = this.C;
        if (interfaceC8691a != null) {
            interfaceC8691a.j(recvData, totalLen, httpMsg2.rawReqHeader);
        }
    }

    @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
    public void handleError(HttpMsg httpMsg, HttpMsg httpMsg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) httpMsg, (Object) httpMsg2);
        } else {
            if (this.f295921m) {
                return;
            }
            if (httpMsg2 != null) {
                b(httpMsg2.errCode, httpMsg2.getErrorString(), httpMsg2.rawRespHeader, httpMsg2);
            } else {
                b(9001, "err no response", "", null);
            }
        }
    }

    @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
    public void handleRedirect(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        if (this.f295921m) {
            return;
        }
        e.b.b("FtnDownloader", e.b.f295938b, "[" + this.f295916d + "] ftn download Redirect. " + str);
        InterfaceC8691a interfaceC8691a = this.C;
        if (interfaceC8691a != null) {
            interfaceC8691a.c(str);
        }
    }

    @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
    public boolean statusChanged(HttpMsg httpMsg, HttpMsg httpMsg2, int i3) {
        InterfaceC8691a interfaceC8691a;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, httpMsg, httpMsg2, Integer.valueOf(i3))).booleanValue();
        }
        if (5 == i3) {
            if (this.f295921m) {
                return true;
            }
            this.f295921m = true;
            InterfaceC8691a interfaceC8691a2 = this.C;
            if (interfaceC8691a2 != null) {
                interfaceC8691a2.onEnd();
            }
        } else if (3 == i3 && !this.f295921m && (interfaceC8691a = this.C) != null) {
            interfaceC8691a.d(httpMsg2);
        }
        return true;
    }
}
