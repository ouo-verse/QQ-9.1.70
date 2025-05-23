package com.tencent.lbssearch;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.lbssearch.object.RequestParams;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.map.tools.net.NetConfig;
import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.map.tools.net.http.HttpResponseListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;

/* loaded from: classes7.dex */
public class HttpProvider {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes7.dex */
    static class a<T> extends AsyncTask<Void, Void, T> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f118533a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f118534b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ RequestParams f118535c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Class f118536d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ HttpResponseListener f118537e;

        a(String str, String str2, RequestParams requestParams, Class cls, HttpResponseListener httpResponseListener) {
            this.f118533a = str;
            this.f118534b = str2;
            this.f118535c = requestParams;
            this.f118536d = cls;
            this.f118537e = httpResponseListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, requestParams, cls, httpResponseListener);
            }
        }

        @Override // android.os.AsyncTask
        protected final /* synthetic */ Object doInBackground(Void[] voidArr) {
            NetResponse doGet = NetManager.getInstance().builder(this.f118533a).url(HttpProvider.getUrlWithQueryString(this.f118534b, this.f118535c)).doGet();
            if (this.f118535c.isDebuggable()) {
                Log.v("TencentSearch", "[RESP]:\n".concat(String.valueOf(doGet)));
            }
            return HttpProvider.parse(doGet, this.f118536d);
        }

        @Override // android.os.AsyncTask
        protected final /* synthetic */ void onPostExecute(Object obj) {
            BaseObject baseObject = (BaseObject) obj;
            super.onPostExecute(baseObject);
            HttpResponseListener httpResponseListener = this.f118537e;
            if (httpResponseListener != null) {
                if (baseObject == null) {
                    httpResponseListener.onFailure(-1, "unknown error", null);
                } else if (baseObject.isStatusOk()) {
                    this.f118537e.onSuccess(baseObject.status, baseObject);
                } else {
                    this.f118537e.onFailure(baseObject.status, baseObject.message, baseObject.exception);
                }
            }
        }
    }

    public HttpProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static String decodeUrl(String str) {
        try {
            URL url = new URL(URLDecoder.decode(str, "UTF-8"));
            return new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef()).toASCIIString();
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
            return str;
        } catch (MalformedURLException e17) {
            e17.printStackTrace();
            return str;
        } catch (URISyntaxException e18) {
            e18.printStackTrace();
            return str;
        }
    }

    public static <T extends BaseObject> void get(Context context, String str, RequestParams requestParams, Class<T> cls, String str2, HttpResponseListener<T> httpResponseListener) {
        if (!NetManager.getInstance().available()) {
            NetManager.init(context, NetConfig.create());
        }
        new a(str2, str, requestParams, cls, httpResponseListener).execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getUrlWithQueryString(String str, RequestParams requestParams) {
        if (str == null) {
            return null;
        }
        String decodeUrl = decodeUrl(str);
        if (requestParams != null) {
            String trim = requestParams.toString().trim();
            if (!trim.equals("")) {
                String str2 = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
                if (!trim.equals(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(decodeUrl);
                    if (decodeUrl.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                        str2 = ContainerUtils.FIELD_DELIMITER;
                    }
                    sb5.append(str2);
                    decodeUrl = sb5.toString() + trim;
                }
            }
        }
        if (requestParams != null && requestParams.isDebuggable()) {
            Log.v("TencentSearch", "[REQ]: ".concat(String.valueOf(decodeUrl)));
        }
        return decodeUrl;
    }

    public static <T extends BaseObject> T parse(@NonNull NetResponse netResponse, Class<T> cls) {
        if (netResponse.available()) {
            return (T) JsonUtils.parseToModel(netResponse.toString(), cls, new Object[0]);
        }
        T t16 = (T) JsonUtils.parseToModel("", cls, new Object[0]);
        if (t16 != null) {
            t16.exception = netResponse.exception;
        }
        return t16;
    }
}
