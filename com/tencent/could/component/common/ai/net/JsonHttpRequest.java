package com.tencent.could.component.common.ai.net;

import android.text.TextUtils;
import com.tencent.could.component.common.ai.eventreport.entry.NetWorkParam;
import com.tencent.could.component.common.ai.utils.GZipUtils;
import com.tencent.local_edit.andserver.util.MediaType;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* compiled from: P */
/* loaded from: classes5.dex */
public class JsonHttpRequest implements IHttpRequest {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public volatile CallBackListener f99991a;

    /* renamed from: b, reason: collision with root package name */
    public NetWorkParam f99992b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f99993c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f99994d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f99995e;

    /* renamed from: f, reason: collision with root package name */
    public int f99996f;

    public JsonHttpRequest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f99993c = false;
        this.f99994d = false;
        this.f99995e = false;
        this.f99996f = 0;
    }

    public final void a(HttpURLConnection httpURLConnection, NetWorkParam netWorkParam) {
        String requestData;
        byte[] bytes;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) httpURLConnection, (Object) netWorkParam);
            return;
        }
        OutputStream outputStream = httpURLConnection.getOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        if (netWorkParam.getRequestData() == null) {
            requestData = null;
        } else {
            requestData = netWorkParam.getRequestData();
        }
        if (netWorkParam.isGzip()) {
            bytes = GZipUtils.compress(requestData);
        } else {
            bytes = requestData.getBytes("UTF-8");
        }
        if (bytes != null) {
            TxNetWorkHelper.getInstance().logDebug("JsonHttpRequest", "start write bytes size: " + bytes.length);
        }
        bufferedOutputStream.write(bytes);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
        outputStream.close();
        TxNetWorkHelper.getInstance().logDebug("JsonHttpRequest", "end write bytes!");
    }

    @Override // com.tencent.could.component.common.ai.net.IHttpRequest
    public void cleanExecute() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        synchronized (JsonHttpRequest.class) {
            if (this.f99991a != null) {
                this.f99991a.cleanListener();
                this.f99991a = null;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00e3 A[Catch: all -> 0x0260, IOException -> 0x0262, TRY_LEAVE, TryCatch #0 {all -> 0x0260, blocks: (B:14:0x002d, B:16:0x0039, B:18:0x0045, B:19:0x0058, B:21:0x005c, B:23:0x0068, B:24:0x007b, B:26:0x007f, B:28:0x0087, B:30:0x0092, B:32:0x009a, B:33:0x00bc, B:35:0x00e3, B:50:0x0161, B:52:0x0190, B:53:0x0198, B:55:0x019e, B:57:0x01b4, B:60:0x01bf, B:61:0x01cb, B:63:0x01d5, B:64:0x01db, B:66:0x01e5, B:67:0x01eb, B:69:0x0200, B:70:0x020f, B:72:0x0217, B:74:0x0233, B:77:0x0244, B:78:0x025f, B:81:0x0263, B:82:0x027e, B:88:0x015a), top: B:13:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0190 A[Catch: all -> 0x0260, IOException -> 0x0262, TryCatch #0 {all -> 0x0260, blocks: (B:14:0x002d, B:16:0x0039, B:18:0x0045, B:19:0x0058, B:21:0x005c, B:23:0x0068, B:24:0x007b, B:26:0x007f, B:28:0x0087, B:30:0x0092, B:32:0x009a, B:33:0x00bc, B:35:0x00e3, B:50:0x0161, B:52:0x0190, B:53:0x0198, B:55:0x019e, B:57:0x01b4, B:60:0x01bf, B:61:0x01cb, B:63:0x01d5, B:64:0x01db, B:66:0x01e5, B:67:0x01eb, B:69:0x0200, B:70:0x020f, B:72:0x0217, B:74:0x0233, B:77:0x0244, B:78:0x025f, B:81:0x0263, B:82:0x027e, B:88:0x015a), top: B:13:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01bf A[Catch: all -> 0x0260, IOException -> 0x0262, TRY_ENTER, TryCatch #0 {all -> 0x0260, blocks: (B:14:0x002d, B:16:0x0039, B:18:0x0045, B:19:0x0058, B:21:0x005c, B:23:0x0068, B:24:0x007b, B:26:0x007f, B:28:0x0087, B:30:0x0092, B:32:0x009a, B:33:0x00bc, B:35:0x00e3, B:50:0x0161, B:52:0x0190, B:53:0x0198, B:55:0x019e, B:57:0x01b4, B:60:0x01bf, B:61:0x01cb, B:63:0x01d5, B:64:0x01db, B:66:0x01e5, B:67:0x01eb, B:69:0x0200, B:70:0x020f, B:72:0x0217, B:74:0x0233, B:77:0x0244, B:78:0x025f, B:81:0x0263, B:82:0x027e, B:88:0x015a), top: B:13:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01d5 A[Catch: all -> 0x0260, IOException -> 0x0262, TryCatch #0 {all -> 0x0260, blocks: (B:14:0x002d, B:16:0x0039, B:18:0x0045, B:19:0x0058, B:21:0x005c, B:23:0x0068, B:24:0x007b, B:26:0x007f, B:28:0x0087, B:30:0x0092, B:32:0x009a, B:33:0x00bc, B:35:0x00e3, B:50:0x0161, B:52:0x0190, B:53:0x0198, B:55:0x019e, B:57:0x01b4, B:60:0x01bf, B:61:0x01cb, B:63:0x01d5, B:64:0x01db, B:66:0x01e5, B:67:0x01eb, B:69:0x0200, B:70:0x020f, B:72:0x0217, B:74:0x0233, B:77:0x0244, B:78:0x025f, B:81:0x0263, B:82:0x027e, B:88:0x015a), top: B:13:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01e5 A[Catch: all -> 0x0260, IOException -> 0x0262, TryCatch #0 {all -> 0x0260, blocks: (B:14:0x002d, B:16:0x0039, B:18:0x0045, B:19:0x0058, B:21:0x005c, B:23:0x0068, B:24:0x007b, B:26:0x007f, B:28:0x0087, B:30:0x0092, B:32:0x009a, B:33:0x00bc, B:35:0x00e3, B:50:0x0161, B:52:0x0190, B:53:0x0198, B:55:0x019e, B:57:0x01b4, B:60:0x01bf, B:61:0x01cb, B:63:0x01d5, B:64:0x01db, B:66:0x01e5, B:67:0x01eb, B:69:0x0200, B:70:0x020f, B:72:0x0217, B:74:0x0233, B:77:0x0244, B:78:0x025f, B:81:0x0263, B:82:0x027e, B:88:0x015a), top: B:13:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0200 A[Catch: all -> 0x0260, IOException -> 0x0262, TryCatch #0 {all -> 0x0260, blocks: (B:14:0x002d, B:16:0x0039, B:18:0x0045, B:19:0x0058, B:21:0x005c, B:23:0x0068, B:24:0x007b, B:26:0x007f, B:28:0x0087, B:30:0x0092, B:32:0x009a, B:33:0x00bc, B:35:0x00e3, B:50:0x0161, B:52:0x0190, B:53:0x0198, B:55:0x019e, B:57:0x01b4, B:60:0x01bf, B:61:0x01cb, B:63:0x01d5, B:64:0x01db, B:66:0x01e5, B:67:0x01eb, B:69:0x0200, B:70:0x020f, B:72:0x0217, B:74:0x0233, B:77:0x0244, B:78:0x025f, B:81:0x0263, B:82:0x027e, B:88:0x015a), top: B:13:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0217 A[Catch: all -> 0x0260, IOException -> 0x0262, TryCatch #0 {all -> 0x0260, blocks: (B:14:0x002d, B:16:0x0039, B:18:0x0045, B:19:0x0058, B:21:0x005c, B:23:0x0068, B:24:0x007b, B:26:0x007f, B:28:0x0087, B:30:0x0092, B:32:0x009a, B:33:0x00bc, B:35:0x00e3, B:50:0x0161, B:52:0x0190, B:53:0x0198, B:55:0x019e, B:57:0x01b4, B:60:0x01bf, B:61:0x01cb, B:63:0x01d5, B:64:0x01db, B:66:0x01e5, B:67:0x01eb, B:69:0x0200, B:70:0x020f, B:72:0x0217, B:74:0x0233, B:77:0x0244, B:78:0x025f, B:81:0x0263, B:82:0x027e, B:88:0x015a), top: B:13:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0244 A[Catch: all -> 0x0260, IOException -> 0x0262, TRY_ENTER, TryCatch #0 {all -> 0x0260, blocks: (B:14:0x002d, B:16:0x0039, B:18:0x0045, B:19:0x0058, B:21:0x005c, B:23:0x0068, B:24:0x007b, B:26:0x007f, B:28:0x0087, B:30:0x0092, B:32:0x009a, B:33:0x00bc, B:35:0x00e3, B:50:0x0161, B:52:0x0190, B:53:0x0198, B:55:0x019e, B:57:0x01b4, B:60:0x01bf, B:61:0x01cb, B:63:0x01d5, B:64:0x01db, B:66:0x01e5, B:67:0x01eb, B:69:0x0200, B:70:0x020f, B:72:0x0217, B:74:0x0233, B:77:0x0244, B:78:0x025f, B:81:0x0263, B:82:0x027e, B:88:0x015a), top: B:13:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x015a A[Catch: all -> 0x0260, IOException -> 0x0262, TRY_ENTER, TryCatch #0 {all -> 0x0260, blocks: (B:14:0x002d, B:16:0x0039, B:18:0x0045, B:19:0x0058, B:21:0x005c, B:23:0x0068, B:24:0x007b, B:26:0x007f, B:28:0x0087, B:30:0x0092, B:32:0x009a, B:33:0x00bc, B:35:0x00e3, B:50:0x0161, B:52:0x0190, B:53:0x0198, B:55:0x019e, B:57:0x01b4, B:60:0x01bf, B:61:0x01cb, B:63:0x01d5, B:64:0x01db, B:66:0x01e5, B:67:0x01eb, B:69:0x0200, B:70:0x020f, B:72:0x0217, B:74:0x0233, B:77:0x0244, B:78:0x025f, B:81:0x0263, B:82:0x027e, B:88:0x015a), top: B:13:0x002d }] */
    @Override // com.tencent.could.component.common.ai.net.IHttpRequest
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void execute() {
        boolean z16;
        boolean z17;
        boolean z18;
        HttpURLConnection httpURLConnection;
        HashMap<String, String> requestHeaders;
        HttpMethod httpMethod;
        HttpMethod httpMethod2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        TxNetWorkHelper.getInstance().logDebug("JsonHttpRequest", "start newExecuteHttpConnect!");
        if (this.f99991a == null) {
            TxNetWorkHelper.getInstance().logError("JsonHttpRequest", "callBackListener is null!");
            return;
        }
        HttpsURLConnection httpsURLConnection = null;
        try {
            try {
                String url = this.f99992b.getUrl();
                if (this.f99993c && !TextUtils.isEmpty(this.f99992b.getDeputyUrl())) {
                    TxNetWorkHelper.getInstance().logError("JsonHttpRequest", "use DeputyUrl");
                    url = this.f99992b.getDeputyUrl();
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (this.f99994d && !TextUtils.isEmpty(this.f99992b.getBackUpIpStringUrl())) {
                    TxNetWorkHelper.getInstance().logError("JsonHttpRequest", "use backUpIpStringUrl");
                    url = this.f99992b.getBackUpIpStringUrl();
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (this.f99995e && this.f99992b.getBackUpIpStringUrls() != null) {
                    String[] backUpIpStringUrls = this.f99992b.getBackUpIpStringUrls();
                    int i3 = this.f99996f;
                    if (i3 < backUpIpStringUrls.length && !TextUtils.isEmpty(backUpIpStringUrls[i3])) {
                        TxNetWorkHelper.getInstance().logError("JsonHttpRequest", "use backup ip urls, index: " + this.f99996f);
                        url = backUpIpStringUrls[this.f99996f];
                        z18 = true;
                        TxNetWorkHelper.getInstance().logDebug("JsonHttpRequest", "connect url: " + url);
                        URL url2 = new URL(url);
                        if (!url.startsWith("https")) {
                            HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) url2.openConnection();
                            try {
                                String httpsVerifyHost = this.f99992b.getHttpsVerifyHost();
                                if (!z17 && !z18 && !z16) {
                                    if (!TextUtils.isEmpty(this.f99992b.getDeputyUrl())) {
                                        httpsVerifyHost = new URL(this.f99992b.getDeputyUrl()).getHost();
                                        TxNetWorkHelper.getInstance().logDebug("JsonHttpRequest", "verify host url is: " + httpsVerifyHost);
                                    } else {
                                        TxNetWorkHelper.getInstance().logDebug("JsonHttpRequest", "deputy url is empty.");
                                    }
                                }
                                if (!TextUtils.isEmpty(httpsVerifyHost)) {
                                    httpsURLConnection2.setRequestProperty("Host", httpsVerifyHost);
                                    httpsURLConnection2.setSSLSocketFactory(new TxcSniSocketFactory(httpsURLConnection2));
                                    httpsURLConnection2.setHostnameVerifier(new HostnameVerifier(this, httpsVerifyHost, url) { // from class: com.tencent.could.component.common.ai.net.JsonHttpRequest.1
                                        static IPatchRedirector $redirector_;

                                        /* renamed from: a, reason: collision with root package name */
                                        public final /* synthetic */ String f99997a;

                                        /* renamed from: b, reason: collision with root package name */
                                        public final /* synthetic */ String f99998b;

                                        {
                                            this.f99997a = httpsVerifyHost;
                                            this.f99998b = url;
                                            IPatchRedirector iPatchRedirector2 = $redirector_;
                                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                                iPatchRedirector2.redirect((short) 1, this, this, httpsVerifyHost, url);
                                            }
                                        }

                                        @Override // javax.net.ssl.HostnameVerifier
                                        public boolean verify(String str, SSLSession sSLSession) {
                                            IPatchRedirector iPatchRedirector2 = $redirector_;
                                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                                return ((Boolean) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) str, (Object) sSLSession)).booleanValue();
                                            }
                                            TxNetWorkHelper.getInstance().logError("JsonHttpRequest", "verify input host: " + str + " session:");
                                            String str2 = this.f99997a;
                                            boolean verify = HttpsURLConnection.getDefaultHostnameVerifier().verify(str2, sSLSession);
                                            TxNetWorkHelper.getInstance().logError("JsonHttpRequest", "verify: " + str2 + " isSuccess: " + verify + " checkHost: " + this.f99997a);
                                            TxNetWorkHelper txNetWorkHelper = TxNetWorkHelper.getInstance();
                                            StringBuilder sb5 = new StringBuilder();
                                            sb5.append("current verify url: ");
                                            sb5.append(this.f99998b);
                                            txNetWorkHelper.logError("JsonHttpRequest", sb5.toString());
                                            return verify;
                                        }
                                    });
                                }
                                httpURLConnection = httpsURLConnection2;
                            } catch (IOException e16) {
                                e = e16;
                                throw new RuntimeException("network error IOException e : " + e.getMessage());
                            } catch (Throwable th5) {
                                th = th5;
                                httpsURLConnection = httpsURLConnection2;
                                if (httpsURLConnection != null) {
                                    httpsURLConnection.disconnect();
                                }
                                throw th;
                            }
                        } else {
                            httpURLConnection = (HttpURLConnection) url2.openConnection();
                        }
                        httpURLConnection.setConnectTimeout(this.f99992b.getTimeOutTimes());
                        httpURLConnection.setReadTimeout(this.f99992b.getTimeOutTimes());
                        httpURLConnection.setUseCaches(false);
                        httpURLConnection.setInstanceFollowRedirects(false);
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setRequestProperty("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
                        requestHeaders = this.f99992b.getRequestHeaders();
                        if (requestHeaders != null) {
                            for (Map.Entry<String, String> entry : requestHeaders.entrySet()) {
                                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                            }
                        }
                        if (this.f99992b.isGzip()) {
                            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                            httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
                        }
                        httpMethod = this.f99992b.getHttpMethod();
                        httpMethod2 = HttpMethod.POST;
                        if (httpMethod == httpMethod2) {
                            httpURLConnection.setRequestMethod("POST");
                        }
                        if (this.f99992b.getHttpMethod() == HttpMethod.GET) {
                            httpURLConnection.setRequestMethod("GET");
                        }
                        TxNetWorkHelper.getInstance().logDebug("JsonHttpRequest", "do connect!");
                        httpURLConnection.connect();
                        if (this.f99992b.getHttpMethod() == httpMethod2) {
                            TxNetWorkHelper.getInstance().logDebug("JsonHttpRequest", "sendPostDateWithCheckGzip!");
                            a(httpURLConnection, this.f99992b);
                        }
                        if (httpURLConnection.getResponseCode() != 200) {
                            TxNetWorkHelper.getInstance().logDebug("JsonHttpRequest", "get ResponseCode! ok");
                            InputStream inputStream = httpURLConnection.getInputStream();
                            TxNetWorkHelper.getInstance().logDebug("JsonHttpRequest", "get net InputStream");
                            if (this.f99991a != null) {
                                this.f99991a.onSuccess(inputStream, "gzip".equals(httpURLConnection.getContentEncoding()));
                            }
                            httpURLConnection.disconnect();
                            return;
                        }
                        throw new RuntimeException("network error, responseCode:" + httpURLConnection.getResponseCode());
                    }
                }
                z18 = false;
                TxNetWorkHelper.getInstance().logDebug("JsonHttpRequest", "connect url: " + url);
                URL url22 = new URL(url);
                if (!url.startsWith("https")) {
                }
                httpURLConnection.setConnectTimeout(this.f99992b.getTimeOutTimes());
                httpURLConnection.setReadTimeout(this.f99992b.getTimeOutTimes());
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestProperty("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
                requestHeaders = this.f99992b.getRequestHeaders();
                if (requestHeaders != null) {
                }
                if (this.f99992b.isGzip()) {
                }
                httpMethod = this.f99992b.getHttpMethod();
                httpMethod2 = HttpMethod.POST;
                if (httpMethod == httpMethod2) {
                }
                if (this.f99992b.getHttpMethod() == HttpMethod.GET) {
                }
                TxNetWorkHelper.getInstance().logDebug("JsonHttpRequest", "do connect!");
                httpURLConnection.connect();
                if (this.f99992b.getHttpMethod() == httpMethod2) {
                }
                if (httpURLConnection.getResponseCode() != 200) {
                }
            } catch (IOException e17) {
                e = e17;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public CallBackListener getCallBackListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CallBackListener) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f99991a;
    }

    @Override // com.tencent.could.component.common.ai.net.IHttpRequest
    public NetWorkParam getNetWorkParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (NetWorkParam) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f99992b;
    }

    @Override // com.tencent.could.component.common.ai.net.IHttpRequest
    public void setListener(CallBackListener callBackListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) callBackListener);
        } else {
            this.f99991a = callBackListener;
        }
    }

    @Override // com.tencent.could.component.common.ai.net.IHttpRequest
    public void setNeedIpBackUrl(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
        } else {
            this.f99994d = z16;
        }
    }

    @Override // com.tencent.could.component.common.ai.net.IHttpRequest
    public void setNeedIpBackUrls(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), Integer.valueOf(i3));
        } else {
            this.f99995e = z16;
            this.f99996f = i3;
        }
    }

    @Override // com.tencent.could.component.common.ai.net.IHttpRequest
    public void setNeedUseDeputy(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.f99993c = z16;
        }
    }

    @Override // com.tencent.could.component.common.ai.net.IHttpRequest
    public void setNetWorkParam(NetWorkParam netWorkParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) netWorkParam);
        } else {
            this.f99992b = netWorkParam;
        }
    }
}
