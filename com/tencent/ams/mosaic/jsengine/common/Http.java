package com.tencent.ams.mosaic.jsengine.common;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ams.dsdk.utils.DBHelper;
import com.tencent.ams.hippo.quickjs.android.JSContext;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.hippo.quickjs.android.JSObject;
import com.tencent.ams.mosaic.jsengine.common.download.IDownload;
import com.tencent.ams.mosaic.jsengine.common.download.IDownloadStatus;
import com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager;
import com.tencent.ams.mosaic.jsengine.e;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.ams.mosaic.utils.f;
import com.tencent.ams.mosaic.utils.g;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.mobileqq.msf.core.x.q;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class Http implements IHttp {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final Context f70801a;

    /* renamed from: b, reason: collision with root package name */
    private final com.tencent.ams.mosaic.jsengine.a f70802b;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    @interface HttpRequestErrorCode {
        public static final int HTTP_REQUEST_ERROR_CODE_NETWORK_ERROR = -10;
        public static final int HTTP_REQUEST_ERROR_CODE_NO_JSCONTEXT_ERROR = -9;
        public static final int HTTP_REQUEST_ERROR_CODE_NO_JSENGINE_ERROR = -8;
        public static final int HTTP_REQUEST_ERROR_CODE_NO_URL_ERROR = -7;
        public static final int HTTP_REQUEST_ERROR_CODE_PARAMS_ERROR = -2;
        public static final int HTTP_REQUEST_ERROR_CODE_PARAMS_PARSE_ERROR = -5;
        public static final int HTTP_REQUEST_ERROR_CODE_POST_BODY_PARSE_ERROR = -6;
        public static final int HTTP_REQUEST_ERROR_CODE_TIMEOUT = -4;
        public static final int HTTP_REQUEST_ERROR_CODE_UNKNOWN = -1;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    @interface HttpRequestErrorMsg {
        public static final String ERROR_MSG_NO_JSCONTEXT = "JSContext\u4e3a\u7a7a";
        public static final String ERROR_MSG_NO_JSENGINE = "JSEngine\u4e3a\u7a7a";
        public static final String ERROR_MSG_NO_URL = "request\u53c2\u6570\u4e2d\u65e0\u6709\u6548url";
        public static final String ERROR_MSG_POST_BODY_PARSE_ERROR = "postBody\u89e3\u6790\u5931\u8d25";
        public static final String ERROR_MSG_REQUEST_PARAMS_ERROR = "request\u4f20\u53c2\u9519\u8bef";
        public static final String ERROR_MSG_REQUEST_PARAMS_PARSE_ERROR = "request\u53c2\u6570\u89e3\u6790\u5931\u8d25";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements IMosaicDownloadManager.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f70809a;

        a(JSONObject jSONObject) {
            this.f70809a = jSONObject;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Http.this, (Object) jSONObject);
            }
        }

        @Override // com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.b
        public String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            JSONObject jSONObject = this.f70809a;
            if (jSONObject != null) {
                return jSONObject.optString("md5");
            }
            return null;
        }

        @Override // com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.b
        public String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            JSONObject jSONObject = this.f70809a;
            if (jSONObject != null) {
                return jSONObject.optString(DBHelper.COL_FOLDER);
            }
            return null;
        }

        @Override // com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.b
        public String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            JSONObject jSONObject = this.f70809a;
            if (jSONObject != null) {
                return jSONObject.optString(QFSEdgeItem.KEY_EXTEND);
            }
            return null;
        }

        @Override // com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.b
        public String getName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            JSONObject jSONObject = this.f70809a;
            if (jSONObject != null) {
                return jSONObject.optString("name");
            }
            return null;
        }

        @Override // com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.b
        public String getUrl() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            JSONObject jSONObject = this.f70809a;
            if (jSONObject != null) {
                return jSONObject.optString("url");
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class b implements IMosaicDownloadManager.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final com.tencent.ams.mosaic.jsengine.a f70811a;

        /* renamed from: b, reason: collision with root package name */
        private final JSFunction f70812b;

        /* renamed from: c, reason: collision with root package name */
        private final JSFunction f70813c;

        /* renamed from: d, reason: collision with root package name */
        private final JSFunction f70814d;

        /* renamed from: e, reason: collision with root package name */
        private final JSFunction f70815e;

        /* renamed from: f, reason: collision with root package name */
        private final JSFunction f70816f;

        public b(com.tencent.ams.mosaic.jsengine.a aVar, JSFunction jSFunction, JSFunction jSFunction2, JSFunction jSFunction3, JSFunction jSFunction4, JSFunction jSFunction5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, aVar, jSFunction, jSFunction2, jSFunction3, jSFunction4, jSFunction5);
                return;
            }
            this.f70811a = aVar;
            this.f70812b = jSFunction;
            this.f70813c = jSFunction2;
            this.f70814d = jSFunction3;
            this.f70815e = jSFunction4;
            this.f70816f = jSFunction5;
        }

        private void c(@IMosaicDownloadManager.ErrorCode int i3) {
            JSFunction jSFunction;
            f.e(q.f250389u, "notifyDownloadFinish, errorCode: " + i3);
            com.tencent.ams.mosaic.jsengine.a aVar = this.f70811a;
            if (aVar != null && (jSFunction = this.f70813c) != null) {
                aVar.u(jSFunction, new Object[]{Integer.valueOf(i3)}, null);
            }
        }

        private void d() {
            JSFunction jSFunction;
            f.e(q.f250389u, "notifyDownloadStart");
            com.tencent.ams.mosaic.jsengine.a aVar = this.f70811a;
            if (aVar != null && (jSFunction = this.f70812b) != null) {
                aVar.u(jSFunction, null, null);
            }
        }

        private void e(int i3, int i16) {
            JSFunction jSFunction;
            f.a(q.f250389u, "notifyDownloadUpdate, total: " + i3 + ", current: " + i16);
            com.tencent.ams.mosaic.jsengine.a aVar = this.f70811a;
            if (aVar != null && (jSFunction = this.f70814d) != null) {
                aVar.u(jSFunction, new Object[]{Integer.valueOf(i3), Integer.valueOf(i16)}, null);
            }
        }

        @Override // com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.a
        public void a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            } else {
                c(0);
            }
        }

        @Override // com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.a
        public void b(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                e(i3, i16);
            }
        }

        @Override // com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.a
        public void onDownloadPause() {
            JSFunction jSFunction;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
                return;
            }
            f.e(q.f250389u, "onDownloadPause");
            com.tencent.ams.mosaic.jsengine.a aVar = this.f70811a;
            if (aVar != null && (jSFunction = this.f70815e) != null) {
                aVar.u(jSFunction, null, null);
            }
        }

        @Override // com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.a
        public void onDownloadResume() {
            JSFunction jSFunction;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
                return;
            }
            f.e(q.f250389u, "onDownloadResume");
            com.tencent.ams.mosaic.jsengine.a aVar = this.f70811a;
            if (aVar != null && (jSFunction = this.f70816f) != null) {
                aVar.u(jSFunction, null, null);
            }
        }

        @Override // com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.a
        public void onDownloadStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                d();
            }
        }

        @Override // com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.a
        public void onFailed(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
            } else {
                c(i3);
            }
        }
    }

    public Http(Context context, com.tencent.ams.mosaic.jsengine.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) aVar);
        } else {
            this.f70801a = context;
            this.f70802b = aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, @HttpRequestErrorCode int i3, @HttpRequestErrorMsg String str2, Map<String, String> map, JSFunction jSFunction) {
        if (jSFunction != null && this.f70802b != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, Integer.valueOf(i3));
            hashMap.put("error", str2);
            hashMap.put("headerMap", map);
            this.f70802b.p(jSFunction, new Object[]{str, hashMap}, null);
        }
    }

    private IMosaicDownloadManager.b c(JSObject jSObject) {
        JSONObject jSONObject;
        com.tencent.ams.mosaic.jsengine.a aVar = this.f70802b;
        JSONObject jSONObject2 = null;
        if (aVar == null) {
            return null;
        }
        try {
            jSONObject = new JSONObject(e.f(aVar.l(), jSObject));
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            f.e(q.f250389u, "convertDownloadRequest, request: " + jSONObject);
        } catch (Throwable th6) {
            th = th6;
            jSONObject2 = jSONObject;
            f.c(q.f250389u, "create requestObject error.", th);
            jSONObject = jSONObject2;
            return new a(jSONObject);
        }
        return new a(jSONObject);
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.IHttp
    public IDownload download(JSObject jSObject, JSFunction jSFunction, JSFunction jSFunction2, JSFunction jSFunction3, JSFunction jSFunction4, JSFunction jSFunction5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (IDownload) iPatchRedirector.redirect((short) 3, this, jSObject, jSFunction, jSFunction2, jSFunction3, jSFunction4, jSFunction5);
        }
        f.e(q.f250389u, "download");
        IMosaicDownloadManager f16 = com.tencent.ams.mosaic.f.k().f(this.f70802b);
        if (f16 == null) {
            f.h(q.f250389u, "can't support download manager.");
            com.tencent.ams.mosaic.jsengine.a aVar = this.f70802b;
            if (aVar != null && jSFunction2 != null) {
                aVar.u(jSFunction2, new Object[]{7, null}, null);
            }
            return null;
        }
        return f16.download(c(jSObject), new b(this.f70802b, jSFunction, jSFunction2, jSFunction5, jSFunction3, jSFunction4));
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.IHttp
    public IDownloadStatus queryDownload(JSObject jSObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (IDownloadStatus) iPatchRedirector.redirect((short) 4, (Object) this, (Object) jSObject);
        }
        f.e(q.f250389u, "queryDownload");
        IMosaicDownloadManager f16 = com.tencent.ams.mosaic.f.k().f(this.f70802b);
        if (f16 == null) {
            f.h(q.f250389u, "queryDownload failed: can't support download manager.");
            return null;
        }
        return f16.queryDownload(c(jSObject));
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.IHttp
    public void requestAsync(JSObject jSObject, JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSObject, (Object) jSFunction);
            return;
        }
        com.tencent.ams.mosaic.jsengine.a aVar = this.f70802b;
        if (aVar == null) {
            f.h(q.f250389u, "requestAsync, no engine.");
            return;
        }
        if (jSObject == null) {
            b(null, -2, HttpRequestErrorMsg.ERROR_MSG_REQUEST_PARAMS_ERROR, null, jSFunction);
            return;
        }
        JSContext l3 = aVar.l();
        if (l3 == null) {
            b(null, -9, HttpRequestErrorMsg.ERROR_MSG_NO_JSCONTEXT, null, jSFunction);
            return;
        }
        Map<String, Object> f16 = e.f(l3, jSObject);
        if (f16 != null && f16.size() != 0) {
            String N = MosaicUtils.N(f16, "url");
            Object obj = f16.get("body");
            String N2 = MosaicUtils.N(f16, "requestMethod");
            Object obj2 = f16.get("headerMap");
            int M = MosaicUtils.M(f16, "connectTimeout");
            int M2 = MosaicUtils.M(f16, "readTimeout");
            if (TextUtils.isEmpty(N)) {
                b(null, -7, HttpRequestErrorMsg.ERROR_MSG_NO_URL, null, jSFunction);
                return;
            } else {
                g.b().a().execute(new Runnable(N, N2, obj2, M, M2, obj, jSFunction) { // from class: com.tencent.ams.mosaic.jsengine.common.Http.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ JSFunction C;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ String f70803d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ String f70804e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ Object f70805f;

                    /* renamed from: h, reason: collision with root package name */
                    final /* synthetic */ int f70806h;

                    /* renamed from: i, reason: collision with root package name */
                    final /* synthetic */ int f70807i;

                    /* renamed from: m, reason: collision with root package name */
                    final /* synthetic */ Object f70808m;

                    {
                        this.f70803d = N;
                        this.f70804e = N2;
                        this.f70805f = obj2;
                        this.f70806h = M;
                        this.f70807i = M2;
                        this.f70808m = obj;
                        this.C = jSFunction;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, Http.this, N, N2, obj2, Integer.valueOf(M), Integer.valueOf(M2), obj, jSFunction);
                        }
                    }

                    /* JADX WARN: Can't wrap try/catch for region: R(28:8|9|10|11|12|(1:14)|15|(3:17|(4:20|(3:34|35|36)(3:22|23|(3:28|29|30))|31|18)|37)|38|(2:40|(17:42|43|(1:45)|46|(1:48)|49|50|51|52|(1:110)(5:56|57|58|(4:61|(3:63|(3:65|(2:67|68)(1:70)|69)|71)(1:73)|72|59)|74)|75|(1:77)|79|80|81|82|83))|114|43|(0)|46|(0)|49|50|51|52|(1:54)|110|75|(0)|79|80|81|82|83) */
                    /* JADX WARN: Code restructure failed: missing block: B:111:0x0145, code lost:
                    
                        r3 = th;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:112:0x0146, code lost:
                    
                        r7 = null;
                     */
                    /* JADX WARN: Removed duplicated region for block: B:45:0x00ac A[Catch: all -> 0x0148, TryCatch #6 {all -> 0x0148, blocks: (B:12:0x001d, B:14:0x0025, B:15:0x002a, B:17:0x0030, B:18:0x003a, B:20:0x0040, B:23:0x0049, B:26:0x0055, B:29:0x0059, B:38:0x0061, B:40:0x0071, B:42:0x0079, B:43:0x009b, B:45:0x00ac, B:46:0x00b2, B:48:0x00c7, B:50:0x00cf), top: B:11:0x001d }] */
                    /* JADX WARN: Removed duplicated region for block: B:48:0x00c7 A[Catch: all -> 0x0148, LOOP:1: B:47:0x00c5->B:48:0x00c7, LOOP_END, TryCatch #6 {all -> 0x0148, blocks: (B:12:0x001d, B:14:0x0025, B:15:0x002a, B:17:0x0030, B:18:0x003a, B:20:0x0040, B:23:0x0049, B:26:0x0055, B:29:0x0059, B:38:0x0061, B:40:0x0071, B:42:0x0079, B:43:0x009b, B:45:0x00ac, B:46:0x00b2, B:48:0x00c7, B:50:0x00cf), top: B:11:0x001d }] */
                    /* JADX WARN: Removed duplicated region for block: B:77:0x013a A[Catch: all -> 0x0142, TRY_LEAVE, TryCatch #2 {all -> 0x0142, blocks: (B:58:0x00e8, B:59:0x00f0, B:61:0x00f6, B:63:0x0109, B:65:0x0110, B:67:0x011d, B:69:0x0123, B:72:0x0126, B:75:0x0135, B:77:0x013a), top: B:57:0x00e8 }] */
                    @Override // java.lang.Runnable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void run() {
                        HashMap hashMap;
                        Throwable th5;
                        String str;
                        int i3;
                        String str2;
                        HttpURLConnection httpURLConnection;
                        Object obj3;
                        DataOutputStream dataOutputStream;
                        String contentEncoding;
                        String readLine;
                        Map<String, List<String>> headerFields;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        HttpURLConnection httpURLConnection2 = null;
                        try {
                            httpURLConnection = (HttpURLConnection) new URL(this.f70803d).openConnection();
                            try {
                                if (!TextUtils.isEmpty(this.f70804e)) {
                                    httpURLConnection.setRequestMethod(this.f70804e);
                                }
                                Object obj4 = this.f70805f;
                                if (obj4 instanceof Map) {
                                    for (Map.Entry entry : ((Map) obj4).entrySet()) {
                                        if (entry != null) {
                                            Object key = entry.getKey();
                                            Object value = entry.getValue();
                                            if ((key instanceof String) && (value instanceof String)) {
                                                httpURLConnection.setRequestProperty((String) key, (String) value);
                                            }
                                        }
                                    }
                                }
                                httpURLConnection.setConnectTimeout(this.f70806h);
                                httpURLConnection.setReadTimeout(this.f70807i);
                                obj3 = this.f70808m;
                            } catch (Throwable th6) {
                                hashMap = null;
                                th5 = th6;
                                str = null;
                            }
                        } catch (Throwable th7) {
                            hashMap = null;
                            th5 = th7;
                            str = null;
                        }
                        if (obj3 instanceof Map) {
                            Map map = (Map) obj3;
                            if (map.size() > 0) {
                                String jSONObject = new JSONObject(map).toString();
                                httpURLConnection.setDoOutput(true);
                                dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                                dataOutputStream.write(jSONObject.getBytes());
                                dataOutputStream.flush();
                                contentEncoding = httpURLConnection.getContentEncoding();
                                InputStream inputStream = httpURLConnection.getInputStream();
                                if ("gzip".equals(contentEncoding)) {
                                    inputStream = new GZIPInputStream(inputStream);
                                }
                                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                                StringBuilder sb5 = new StringBuilder();
                                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                                for (readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                                    sb5.append(readLine);
                                }
                                str = sb5.toString();
                                int i16 = httpURLConnection.getResponseCode();
                                headerFields = httpURLConnection.getHeaderFields();
                                if (headerFields == null && headerFields.size() > 0) {
                                    hashMap = new HashMap();
                                    try {
                                        for (Map.Entry<String, List<String>> entry2 : headerFields.entrySet()) {
                                            StringBuilder sb6 = new StringBuilder();
                                            List<String> value2 = entry2.getValue();
                                            if (value2 != null) {
                                                int size = value2.size();
                                                for (int i17 = 0; i17 < size; i17++) {
                                                    sb6.append(value2.get(i17));
                                                    if (i17 != size - 1) {
                                                        sb6.append(",");
                                                    }
                                                }
                                            }
                                            hashMap.put(entry2.getKey(), sb6.toString());
                                        }
                                    } catch (Throwable th8) {
                                        th5 = th8;
                                        httpURLConnection2 = httpURLConnection;
                                        try {
                                            String th9 = th5.toString();
                                            if (th5 instanceof SocketTimeoutException) {
                                                i3 = -4;
                                            } else {
                                                i3 = -10;
                                            }
                                            i16 = i3;
                                            if (httpURLConnection2 != null) {
                                                try {
                                                    httpURLConnection2.disconnect();
                                                } catch (Throwable unused) {
                                                }
                                            }
                                            str2 = th9;
                                            Http.this.b(str, i16, str2, hashMap, this.C);
                                        } catch (Throwable th10) {
                                            if (httpURLConnection2 != null) {
                                                try {
                                                    httpURLConnection2.disconnect();
                                                } catch (Throwable unused2) {
                                                }
                                            }
                                            throw th10;
                                        }
                                    }
                                } else {
                                    hashMap = null;
                                }
                                inputStream.close();
                                if (dataOutputStream != null) {
                                    dataOutputStream.close();
                                }
                                httpURLConnection.disconnect();
                                str2 = null;
                                Http.this.b(str, i16, str2, hashMap, this.C);
                            }
                        }
                        dataOutputStream = null;
                        contentEncoding = httpURLConnection.getContentEncoding();
                        InputStream inputStream2 = httpURLConnection.getInputStream();
                        if ("gzip".equals(contentEncoding)) {
                        }
                        InputStreamReader inputStreamReader2 = new InputStreamReader(inputStream2);
                        StringBuilder sb52 = new StringBuilder();
                        BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader2);
                        while (readLine != null) {
                        }
                        str = sb52.toString();
                        int i162 = httpURLConnection.getResponseCode();
                        headerFields = httpURLConnection.getHeaderFields();
                        if (headerFields == null) {
                        }
                        hashMap = null;
                        inputStream2.close();
                        if (dataOutputStream != null) {
                        }
                        httpURLConnection.disconnect();
                        str2 = null;
                        Http.this.b(str, i162, str2, hashMap, this.C);
                    }
                });
                return;
            }
        }
        b(null, -5, HttpRequestErrorMsg.ERROR_MSG_REQUEST_PARAMS_PARSE_ERROR, null, jSFunction);
    }
}
