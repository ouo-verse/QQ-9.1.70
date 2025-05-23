package com.tencent.mobileqq.uftransfer.depend;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.TimeoutParam;
import com.tencent.mobileqq.transfile.api.IOldHttpEngineProcessor;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import java.net.HttpURLConnection;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class b implements IHttpCommunicatorListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected final AppRuntime f305126d;

    /* renamed from: e, reason: collision with root package name */
    protected final long f305127e;

    /* renamed from: f, reason: collision with root package name */
    private HttpMsg f305128f;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f305129h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f305130i;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final int f305131a;

        /* renamed from: b, reason: collision with root package name */
        final String f305132b;

        /* renamed from: c, reason: collision with root package name */
        final String f305133c;

        /* renamed from: d, reason: collision with root package name */
        final String f305134d;

        public a(int i3, String str, String str2, String str3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, str2, str3);
                return;
            }
            this.f305131a = i3;
            this.f305132b = str;
            this.f305133c = str2;
            this.f305134d = str3;
        }

        public int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.f305131a;
        }

        public String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f305132b;
        }

        public String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.f305133c;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.uftransfer.depend.b$b, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static class C8867b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final String f305135a;

        /* renamed from: b, reason: collision with root package name */
        private final byte[] f305136b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f305137c;

        /* renamed from: d, reason: collision with root package name */
        private String f305138d;

        /* renamed from: e, reason: collision with root package name */
        private int f305139e;

        /* renamed from: f, reason: collision with root package name */
        private int f305140f;

        /* renamed from: g, reason: collision with root package name */
        private int f305141g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f305142h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f305143i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f305144j;

        /* renamed from: k, reason: collision with root package name */
        private String f305145k;

        /* renamed from: l, reason: collision with root package name */
        private String f305146l;

        /* renamed from: m, reason: collision with root package name */
        private String f305147m;

        /* renamed from: n, reason: collision with root package name */
        private String f305148n;

        /* renamed from: o, reason: collision with root package name */
        private String f305149o;

        public C8867b(String str, byte[] bArr, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, bArr, Boolean.valueOf(z16));
                return;
            }
            this.f305139e = 1;
            this.f305140f = -1;
            this.f305141g = -1;
            this.f305142h = false;
            this.f305143i = false;
            this.f305144j = false;
            this.f305135a = str;
            this.f305136b = bArr;
            this.f305137c = z16;
        }

        public void p(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
            } else {
                this.f305141g = i3;
            }
        }

        public void q(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
            } else {
                this.f305140f = i3;
            }
        }

        public void r(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, z16);
            } else {
                this.f305144j = z16;
            }
        }

        public void s(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, z16);
            } else {
                this.f305143i = z16;
            }
        }

        public void t(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            } else {
                this.f305146l = str;
            }
        }

        public void u(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            } else {
                this.f305145k = str;
            }
        }

        public void v(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            } else {
                this.f305138d = str;
            }
        }

        public void w(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            } else {
                this.f305139e = i3;
            }
        }

        public void x(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            } else {
                this.f305147m = str;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final long f305150a;

        /* renamed from: b, reason: collision with root package name */
        final long f305151b;

        /* renamed from: c, reason: collision with root package name */
        final byte[] f305152c;

        /* renamed from: d, reason: collision with root package name */
        final String f305153d;

        /* renamed from: e, reason: collision with root package name */
        final long f305154e;

        public c(byte[] bArr, String str, long j3, long j16, long j17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, bArr, str, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
                return;
            }
            this.f305150a = j16;
            this.f305151b = j3;
            this.f305152c = bArr;
            this.f305153d = str;
            this.f305154e = j17;
        }

        public String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.f305153d;
        }

        public byte[] b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (byte[]) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.f305152c;
        }

        public long c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
            }
            return this.f305151b;
        }
    }

    public b(AppRuntime appRuntime, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, Long.valueOf(j3));
            return;
        }
        this.f305129h = true;
        this.f305130i = false;
        this.f305126d = appRuntime;
        this.f305127e = j3;
    }

    private void d(HttpMsg httpMsg) {
        if (httpMsg.getResponseCode() != 206 && httpMsg.getResponseCode() != 200) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTHttpCommunicator", 1, "[" + this.f305127e + "] decodeGet resp Code [" + httpMsg.getResponseCode() + "] no 200|206");
            return;
        }
        k(new c(httpMsg.getRecvData(), httpMsg.rawRespHeader, 0L, 0L, httpMsg.getTotalLen()));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void e(HttpMsg httpMsg) {
        long parseLong;
        long j3;
        if (httpMsg.getResponseCode() == 200) {
            String responseProperty = httpMsg.getResponseProperty(HttpMsg.USERRETURNCODE);
            if (!TextUtils.isEmpty(responseProperty)) {
                try {
                    parseLong = Long.parseLong(responseProperty);
                } catch (NumberFormatException unused) {
                }
                if (0 == parseLong) {
                    com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTHttpCommunicator", 1, "id[" + this.f305127e + "],decodePost userRetCode[" + parseLong + "]");
                    f(httpMsg);
                    return;
                }
                String responseProperty2 = httpMsg.getResponseProperty("Range");
                if (!TextUtils.isEmpty(responseProperty2)) {
                    try {
                        j3 = Long.parseLong(responseProperty2);
                    } catch (NumberFormatException unused2) {
                        j3 = -2;
                    }
                } else {
                    j3 = -1;
                }
                k(new c(httpMsg.getRecvData(), httpMsg.rawRespHeader, j3, parseLong, 0L));
                return;
            }
            parseLong = 0;
            if (0 == parseLong) {
            }
        } else {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTHttpCommunicator", 1, "id[" + this.f305127e + "],decodePost but response Code [" + httpMsg.getResponseCode() + "] is not 200");
        }
    }

    private void f(HttpMsg httpMsg) {
        String str = null;
        if (httpMsg != null) {
            HttpURLConnection httpURLConnection = httpMsg.mConn;
            if (httpURLConnection != null) {
                str = httpURLConnection.getHeaderField(HttpMsg.USERRETURNCODE);
            }
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTHttpCommunicator", 1, "id[" + this.f305127e + "], httpReq Error:" + httpMsg.errCode + " " + httpMsg.getErrorString());
            i(new a(httpMsg.errCode, httpMsg.getErrorString(), httpMsg.rawRespHeader, str));
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTHttpCommunicator", 1, "id[" + this.f305127e + "], httpReq Error:9001 null rsp");
        i(new a(9001, "null", "null", null));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private TimeoutParam g() {
        int i3;
        boolean z16;
        int r16;
        boolean z17;
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        boolean z18 = true;
        if (activeNetworkInfo != null) {
            i3 = NetworkMonitor.getType(activeNetworkInfo);
            if (i3 == 1) {
                z16 = true;
                r16 = com.tencent.mobileqq.uftransfer.depend.a.r();
                if (r16 != 2) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (com.tencent.mobileqq.uftransfer.depend.c.d()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("getTimeOutParamer,systemType:");
                    sb5.append(i3);
                    sb5.append(" msfType:");
                    sb5.append(r16);
                    sb5.append(" isSameNet:");
                    if (z16 != z17) {
                        z18 = false;
                    }
                    sb5.append(z18);
                    com.tencent.mobileqq.uftransfer.depend.c.a("[UFTTransfer] UFTHttpCommunicator", 4, sb5.toString());
                }
                if (z16 == z17) {
                    TimeoutParam timeoutParam = new TimeoutParam();
                    timeoutParam.readTimeoutFor2G = 20000;
                    timeoutParam.readTimeoutFor3G = 15000;
                    timeoutParam.readTimeoutForWifi = 10000;
                    timeoutParam.connectTimeoutFor2G = 10000;
                    timeoutParam.connectTimeoutFor3G = 5000;
                    timeoutParam.connectTimeoutForWifi = 5000;
                    return timeoutParam;
                }
                return null;
            }
        } else {
            i3 = -1;
        }
        z16 = false;
        r16 = com.tencent.mobileqq.uftransfer.depend.a.r();
        if (r16 != 2) {
        }
        if (com.tencent.mobileqq.uftransfer.depend.c.d()) {
        }
        if (z16 == z17) {
        }
    }

    private boolean h(HttpMsg httpMsg) {
        HttpMsg httpMsg2 = this.f305128f;
        if (httpMsg == httpMsg2) {
            return true;
        }
        if (httpMsg != null && httpMsg2 != null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTHttpCommunicator", 1, "id[" + this.f305127e + "],Req Serial[" + String.valueOf(httpMsg.getSerial()) + "], curRequest Serial[" + String.valueOf(this.f305128f.getSerial()) + "]");
            return false;
        }
        if (httpMsg != null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTHttpCommunicator", 1, "id[" + this.f305127e + "],Req Serial[" + String.valueOf(httpMsg.getSerial()) + "]");
            return false;
        }
        if (httpMsg2 != null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTHttpCommunicator", 1, "id[" + this.f305127e + "],curRequest Serial[" + String.valueOf(this.f305128f.getSerial()) + "]");
            return false;
        }
        return false;
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.f305129h = true;
        if (this.f305128f != null) {
            ((IOldHttpEngineProcessor) QRoute.api(IOldHttpEngineProcessor.class)).cancelMsg(this.f305128f);
            this.f305128f = null;
        }
    }

    @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
    public final void decode(HttpMsg httpMsg, HttpMsg httpMsg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) httpMsg, (Object) httpMsg2);
            return;
        }
        if (this.f305129h) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTHttpCommunicator", 1, "id[" + this.f305127e + "]\u5df2\u7ecf\u7ed3\u675f,\u8fd4\u56de");
            return;
        }
        if (!h(httpMsg)) {
            return;
        }
        if (this.f305130i) {
            e(httpMsg2);
        } else {
            d(httpMsg2);
        }
    }

    @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
    public final void handleError(HttpMsg httpMsg, HttpMsg httpMsg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) httpMsg, (Object) httpMsg2);
        } else {
            if (this.f305129h || !h(httpMsg)) {
                return;
            }
            f(httpMsg2);
        }
    }

    @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
    public final void handleRedirect(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        if (this.f305129h) {
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTHttpCommunicator", 1, "id[" + this.f305127e + "], onNetRedirect:" + str);
        j(str);
    }

    protected abstract void i(a aVar);

    protected abstract void j(String str);

    protected abstract void k(c cVar);

    public boolean l(C8867b c8867b) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) c8867b)).booleanValue();
        }
        if (c8867b == null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTHttpCommunicator", 1, "id[" + this.f305127e + "]sendReq. req = null");
            return false;
        }
        this.f305129h = false;
        HttpMsg httpMsg = new HttpMsg(c8867b.f305135a, c8867b.f305136b, this, c8867b.f305137c);
        this.f305128f = httpMsg;
        httpMsg.setInstanceFollowRedirects(false);
        this.f305128f.setRequestProperty("cache-control", "no-cache");
        if (!TextUtils.isEmpty(c8867b.f305138d)) {
            this.f305128f.setRequestMethod(c8867b.f305138d);
        }
        this.f305128f.setPriority(c8867b.f305139e);
        this.f305128f.fileType = c8867b.f305140f;
        this.f305128f.busiType = c8867b.f305141g;
        this.f305128f.msgId = String.valueOf(this.f305127e);
        String requestMethod = this.f305128f.getRequestMethod();
        if (TextUtils.isEmpty(requestMethod)) {
            return false;
        }
        if (requestMethod.toUpperCase().equals("POST")) {
            this.f305130i = true;
        } else {
            this.f305130i = false;
        }
        if (c8867b.f305143i) {
            HttpMsg httpMsg2 = this.f305128f;
            httpMsg2.mIsHttps = true;
            httpMsg2.mIsHostIP = c8867b.f305144j;
            this.f305128f.mReqHost = c8867b.f305145k;
        }
        this.f305128f.setDataSlice(c8867b.f305142h);
        if (com.tencent.mobileqq.uftransfer.depend.a.t() == 1) {
            str = "wifi";
        } else {
            str = "gprs";
        }
        this.f305128f.setRequestProperty("Net-type", str);
        if (!TextUtils.isEmpty(c8867b.f305147m)) {
            this.f305128f.setRequestProperty("User-Agent", c8867b.f305147m);
        }
        if (!TextUtils.isEmpty(c8867b.f305148n)) {
            this.f305128f.setRequestProperty("Cookie", c8867b.f305148n);
        }
        if (!TextUtils.isEmpty(c8867b.f305146l)) {
            this.f305128f.setRequestProperty("Range", c8867b.f305146l);
        }
        if (!TextUtils.isEmpty(c8867b.f305149o)) {
            this.f305128f.setRequestProperty("Accept-Encoding", c8867b.f305149o);
        }
        this.f305128f.timeoutParam = g();
        int sendMsg = ((IOldHttpEngineProcessor) QRoute.api(IOldHttpEngineProcessor.class)).sendMsg(this.f305128f);
        if (com.tencent.mobileqq.uftransfer.depend.c.d()) {
            com.tencent.mobileqq.uftransfer.depend.c.a("[UFTTransfer] UFTHttpCommunicator", 4, "id[" + this.f305127e + "]sendReq. url:" + c8867b.f305135a + " msgId:" + this.f305128f.msgId + " ret:" + sendMsg);
        }
        if (sendMsg != -1) {
            return true;
        }
        this.f305129h = true;
        return false;
    }

    @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
    public boolean statusChanged(HttpMsg httpMsg, HttpMsg httpMsg2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return true;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 5, this, httpMsg, httpMsg2, Integer.valueOf(i3))).booleanValue();
    }
}
