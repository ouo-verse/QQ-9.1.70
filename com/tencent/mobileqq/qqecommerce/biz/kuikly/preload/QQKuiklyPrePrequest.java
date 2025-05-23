package com.tencent.mobileqq.qqecommerce.biz.kuikly.preload;

import android.os.Build;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.utils.WebSSOUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.QQKuiklyPlatformApi;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.f;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import com.tencent.mobileqq.vas.toggle.UnitedProxy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.util.URLUtil;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.api.IRuntimeService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 42\u00020\u0001:\u0001#B#\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010&\u00a2\u0006\u0004\b2\u00103J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J9\u0010\u0011\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2'\u0010\u0010\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00050\u000bj\u0002`\u000fH\u0002JL\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\t2:\u0010\u0010\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00050\u0013H\u0002J\u0018\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0002H\u0002J\u000e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J;\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022+\u0010\u0010\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bj\u0004\u0018\u0001`\u000fJ\u000e\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001cR\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R \u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R2\u0010.\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020*j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R;\u00101\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bj\u0004\u0018\u0001`\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/preload/QQKuiklyPrePrequest;", "", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_UNIQUE_ID, "rspData", "", "p", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/preload/e;", "ssoItem", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "o", "httpItem", "Lkotlin/Function2;", "error", DomainData.DOMAIN_NAME, "domain", "Lsd2/a;", "i", "pskey", "", "g", "", "k", h.F, "f", "isForceUpdate", "l", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/preload/d;", "a", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/preload/d;", "preRequestData", "", "b", "Ljava/util/Map;", QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "c", "Ljava/util/HashMap;", "cacheRequestMap", "d", "Lkotlin/jvm/functions/Function1;", "cacheCallback", "<init>", "(Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/preload/d;Ljava/util/Map;)V", "e", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QQKuiklyPrePrequest {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    private static final String f263175f = "QQ/" + AppSetting.f99551k + " Android/0.17 Android/" + Build.VERSION.RELEASE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final PreRequestData preRequestData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Map<String, Object> pageParams;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private HashMap<String, String> cacheRequestMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Function1<Object, Unit> cacheCallback;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\fR\u0014\u0010\u0012\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\fR\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\f\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/preload/QQKuiklyPrePrequest$a;", "", "Lorg/json/JSONObject;", "requestObj", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/preload/e;", "c", "", "configName", "", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/preload/d;", "b", "UA", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "CONTENT_TYPE", "COOKIE", "ORIGIN", "TAG", "", "TIME_OUT", "I", "USER_AGENT", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqecommerce.biz.kuikly.preload.QQKuiklyPrePrequest$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final PreRequestItem c(JSONObject requestObj) {
            HttpRequestItem httpRequestItem;
            RequestType a16 = RequestType.INSTANCE.a(requestObj.optInt("requestType"));
            String uniqueId = requestObj.optString(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_UNIQUE_ID);
            JSONObject optJSONObject = requestObj.optJSONObject("requestParams");
            g gVar = null;
            if (optJSONObject == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = optJSONObject.optJSONArray("dynamicParams");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                    String optString = optJSONObject2.optString("type");
                    Intrinsics.checkNotNullExpressionValue(optString, "dynamicItem.optString(\"type\")");
                    String optString2 = optJSONObject2.optString("template");
                    Intrinsics.checkNotNullExpressionValue(optString2, "dynamicItem.optString(\"template\")");
                    arrayList.add(new com.tencent.mobileqq.qqecommerce.biz.kuikly.preload.b(optString, optString2));
                }
            }
            if (a16 == RequestType.TYPE_HTTP) {
                String optString3 = optJSONObject.optString("url");
                Intrinsics.checkNotNullExpressionValue(optString3, "requestParam.optString(\"url\")");
                String optString4 = optJSONObject.optString("domain");
                Intrinsics.checkNotNullExpressionValue(optString4, "requestParam.optString(\"domain\")");
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("httpDataBody");
                httpRequestItem = new HttpRequestItem(optString3, optString4, optJSONObject3 != null ? optJSONObject3.toString() : null, arrayList);
            } else {
                httpRequestItem = null;
            }
            if (a16 == RequestType.TYPE_SSO) {
                String optString5 = optJSONObject.optString("cmd");
                Intrinsics.checkNotNullExpressionValue(optString5, "requestParam.optString(\"cmd\")");
                JSONObject optJSONObject4 = optJSONObject.optJSONObject("ssoDataBody");
                gVar = new g(optString5, optJSONObject4 != null ? optJSONObject4.toString() : null, arrayList);
            }
            Intrinsics.checkNotNullExpressionValue(uniqueId, "uniqueId");
            return new PreRequestItem(a16, uniqueId, gVar, httpRequestItem);
        }

        public final String a() {
            return QQKuiklyPrePrequest.f263175f;
        }

        Companion() {
        }

        public final Map<String, PreRequestData> b(String configName) {
            Intrinsics.checkNotNullParameter(configName, "configName");
            HashMap hashMap = new HashMap();
            try {
                JSONObject json = new UnitedProxy(configName).getJson();
                if (QLog.isColorLevel()) {
                    QLog.i("QQKuiklyPrePrequest", 1, "load business config : " + json);
                }
                JSONArray optJSONArray = json.optJSONArray(DownloadInfo.spKey_Config);
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        JSONObject jSONObject = optJSONArray.getJSONObject(i3);
                        String pageName = jSONObject.optString("page");
                        Intrinsics.checkNotNullExpressionValue(pageName, "pageName");
                        if (!(pageName.length() == 0)) {
                            JSONObject optJSONObject = jSONObject.optJSONObject("preRequest");
                            int optInt = optJSONObject != null ? optJSONObject.optInt("requestTimeType") : 0;
                            JSONArray optJSONArray2 = optJSONObject != null ? optJSONObject.optJSONArray("requestList") : null;
                            if (optJSONArray2 != null) {
                                ArrayList arrayList = new ArrayList();
                                int length2 = optJSONArray2.length();
                                for (int i16 = 0; i16 < length2; i16++) {
                                    Companion companion = QQKuiklyPrePrequest.INSTANCE;
                                    JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i16);
                                    Intrinsics.checkNotNullExpressionValue(optJSONObject2, "jsonArray.optJSONObject(j)");
                                    PreRequestItem c16 = companion.c(optJSONObject2);
                                    if (c16 != null) {
                                        arrayList.add(c16);
                                    }
                                }
                                hashMap.put(pageName, new PreRequestData(RequestTimeType.INSTANCE.a(optInt), arrayList));
                            }
                        }
                    }
                }
            } catch (JSONException e16) {
                QLog.e("QQKuiklyPrePrequest", 1, e16, new Object[0]);
            }
            return hashMap;
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/kuikly/preload/QQKuiklyPrePrequest$b", "Lsd2/a;", "", "", "domainToKeyMap", "", "onSuccess", "errMsg", "onFail", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements sd2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PreRequestItem f263180a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function2<String, String, Unit> f263181b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ QQKuiklyPrePrequest f263182c;

        /* JADX WARN: Multi-variable type inference failed */
        b(PreRequestItem preRequestItem, Function2<? super String, ? super String, Unit> function2, QQKuiklyPrePrequest qQKuiklyPrePrequest) {
            this.f263180a = preRequestItem;
            this.f263181b = function2;
            this.f263182c = qQKuiklyPrePrequest;
        }

        @Override // sd2.a
        public void onFail(String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.e("QQKuiklyPrePrequest", 1, "requestByHttp onFail errMsg:" + errMsg);
            this.f263181b.invoke(null, null);
        }

        /* JADX WARN: Code restructure failed: missing block: B:38:0x0195, code lost:
        
            r9 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r9);
         */
        @Override // sd2.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onSuccess(Map<String, String> domainToKeyMap) {
            InputStream inputStream;
            String str;
            Integer intOrNull;
            Intrinsics.checkNotNullParameter(domainToKeyMap, "domainToKeyMap");
            String str2 = domainToKeyMap.get(this.f263180a.getHttpRequestItem().getDomain());
            if (str2 == null || str2.length() == 0) {
                QLog.e("QQKuiklyPrePrequest", 1, "requestByHttp get pskey null");
                this.f263181b.invoke(null, null);
                return;
            }
            String str3 = "p_uin=o" + QQKuiklyPlatformApi.INSTANCE.a() + ";p_skey=" + str2 + ";";
            try {
                String addParameter = URLUtil.addParameter(this.f263180a.getHttpRequestItem().getUrl(), "g_tk", String.valueOf(this.f263182c.g(str2)));
                QLog.i("QQKuiklyPrePrequest", 1, "requestByHttp params:" + addParameter);
                URL url = new URL(addParameter);
                URLConnection openConnection = url.openConnection();
                Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(10000);
                httpURLConnection.addRequestProperty("user-agent", QQKuiklyPrePrequest.INSTANCE.a());
                httpURLConnection.addRequestProperty("cookie", str3);
                httpURLConnection.addRequestProperty("content-type", "application/json");
                httpURLConnection.addRequestProperty(TtmlNode.ATTR_TTS_ORIGIN, "https://" + url.getHost());
                httpURLConnection.setDoInput(true);
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                byte[] bytes = this.f263180a.getHttpRequestItem().c(this.f263182c.pageParams).getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                dataOutputStream.write(bytes);
                dataOutputStream.close();
                int responseCode = httpURLConnection.getResponseCode();
                StringBuffer stringBuffer = new StringBuffer();
                if (200 <= responseCode && responseCode < 300) {
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                            stringBuffer.append(readLine);
                        }
                        if (stringBuffer.length() == 0) {
                            List<String> list = httpURLConnection.getHeaderFields().get("Trpc-Func-Ret");
                            if (list == null) {
                                list = httpURLConnection.getHeaderFields().get("trpc-func-ret");
                            }
                            List<String> list2 = httpURLConnection.getHeaderFields().get("Trpc-Error-Msg");
                            if (list2 == null) {
                                list2 = httpURLConnection.getHeaderFields().get("trpc-error-msg");
                            }
                            if (list != null) {
                                Function2<String, String, Unit> function2 = this.f263181b;
                                f.Companion companion = com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.f.INSTANCE;
                                String str4 = list.get(0);
                                int intValue = (str4 == null || intOrNull == null) ? 0 : intOrNull.intValue();
                                if (list2 == null || (str = list2.get(0)) == null) {
                                    str = null;
                                }
                                function2.invoke(null, companion.a(intValue, str, null));
                            }
                            QLog.i("QQKuiklyPrePrequest", 1, addParameter + " error:" + list + ", " + list2);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                    return;
                                } catch (Exception e16) {
                                    QLog.e("QQKuiklyPrePrequest", 1, e16, new Object[0]);
                                    return;
                                }
                            }
                            return;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        try {
                            QLog.e("QQKuiklyPrePrequest", 1, th, new Object[0]);
                            this.f263181b.invoke(null, null);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                    return;
                                } catch (Exception e17) {
                                    QLog.e("QQKuiklyPrePrequest", 1, e17, new Object[0]);
                                    return;
                                }
                            }
                            return;
                        } catch (Throwable th6) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e18) {
                                    QLog.e("QQKuiklyPrePrequest", 1, e18, new Object[0]);
                                }
                            }
                            throw th6;
                        }
                    }
                } else {
                    inputStream = null;
                }
                this.f263181b.invoke(stringBuffer.toString(), null);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e19) {
                        QLog.e("QQKuiklyPrePrequest", 1, e19, new Object[0]);
                    }
                }
            } catch (Throwable th7) {
                th = th7;
                inputStream = null;
            }
        }
    }

    public QQKuiklyPrePrequest(PreRequestData preRequestData, Map<String, Object> pageParams) {
        Intrinsics.checkNotNullParameter(preRequestData, "preRequestData");
        Intrinsics.checkNotNullParameter(pageParams, "pageParams");
        this.preRequestData = preRequestData;
        this.pageParams = pageParams;
        this.cacheRequestMap = new HashMap<>();
    }

    private final void i(String domain, sd2.a callback) {
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        if (application == null || !(application.getRuntime() instanceof AppInterface)) {
            callback.onFail("error runtime");
        }
        IRuntimeService runtimeService = application.getRuntime().getRuntimeService(IPskeyManager.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appInterface.getRuntimeS\u2026ava, ProcessConstant.ALL)");
        ((IPskeyManager) runtimeService).getPskey(new String[]{domain}, callback);
    }

    private final String j(String uniqueId) {
        String str;
        if (this.cacheRequestMap.isEmpty()) {
            return null;
        }
        synchronized (this.cacheRequestMap) {
            str = this.cacheRequestMap.get(uniqueId);
            Unit unit = Unit.INSTANCE;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(boolean z16, QQKuiklyPrePrequest this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16 && this$0.preRequestData.getRequestTimeType() == RequestTimeType.TYPE_ONLY_DOWNLOAD) {
            this$0.q();
        } else if (this$0.preRequestData.getRequestTimeType() == RequestTimeType.TYPE_EVERY_ONCE) {
            this$0.q();
        }
    }

    private final void n(PreRequestItem httpItem, Function2<? super String, ? super String, Unit> callback) {
        if (httpItem.getHttpRequestItem() == null) {
            callback.invoke(null, null);
        } else {
            i(httpItem.getHttpRequestItem().getDomain(), new b(httpItem, callback, this));
        }
    }

    private final void o(PreRequestItem ssoItem, Function1<Object, Unit> callback) {
        if (ssoItem.getSsoRequestData() == null) {
            callback.invoke(null);
            return;
        }
        JSONObject jSONObject = new JSONObject(ssoItem.getSsoRequestData().c(this.pageParams));
        jSONObject.put("cmd", ssoItem.getSsoRequestData().getCmd());
        jSONObject.put("timeout", 10000);
        if (QLog.isColorLevel()) {
            QLog.i("QQKuiklyPrePrequest", 1, "requestBySSO params:" + jSONObject);
        }
        com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.b.INSTANCE.h(jSONObject.toString(), callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(String uniqueId, String rspData) {
        Map mapOf;
        Map mapOf2;
        synchronized (this.cacheRequestMap) {
            this.cacheRequestMap.put(uniqueId, rspData);
            Unit unit = Unit.INSTANCE;
        }
        if (this.cacheCallback != null) {
            JSONObject jSONObject = new JSONObject(rspData);
            if (jSONObject.has("errCode") && jSONObject.has("errMsg")) {
                Function1<Object, Unit> function1 = this.cacheCallback;
                if (function1 != null) {
                    mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to("errCode", Long.valueOf(jSONObject.optLong("errCode"))), TuplesKt.to("errMsg", jSONObject.optString("errMsg")));
                    function1.invoke(mapOf2);
                }
            } else {
                Function1<Object, Unit> function12 = this.cacheCallback;
                if (function12 != null) {
                    mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("errCode", 0), TuplesKt.to("data", rspData));
                    function12.invoke(mapOf);
                }
            }
            this.cacheCallback = null;
        }
    }

    private final void q() {
        for (final PreRequestItem preRequestItem : this.preRequestData.a()) {
            if (preRequestItem.getRequestType() == RequestType.TYPE_HTTP) {
                n(preRequestItem, new Function2<String, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.preload.QQKuiklyPrePrequest$startRequest$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(String str, String str2) {
                        invoke2(str, str2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String str, String str2) {
                        if (!(str2 == null || str2.length() == 0)) {
                            QQKuiklyPrePrequest.this.p(preRequestItem.getUniqueId(), str2);
                            return;
                        }
                        if (str == null) {
                            QQKuiklyPrePrequest.this.p(preRequestItem.getUniqueId(), com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.f.INSTANCE.a(-1, "request error", null));
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.i("QQKuiklyPrePrequest", 1, "requestByHttp rsp:" + str);
                        }
                        QQKuiklyPrePrequest.this.p(preRequestItem.getUniqueId(), str);
                    }
                });
            } else {
                o(preRequestItem, new Function1<Object, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.preload.QQKuiklyPrePrequest$startRequest$1$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                        invoke2(obj);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object obj) {
                        if (!(obj instanceof Map)) {
                            QQKuiklyPrePrequest.this.p(preRequestItem.getUniqueId(), com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.f.INSTANCE.a(-1, "request error", null));
                            return;
                        }
                        JSONObject jSONObject = new JSONObject();
                        Map map = (Map) obj;
                        jSONObject.put("data", map.get("data"));
                        jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_SSORET, map.get(WebSSOUtils.CALLBACK_COLUMN_SSORET));
                        jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_BUSINESSRET, map.get(WebSSOUtils.CALLBACK_COLUMN_BUSINESSRET));
                        jSONObject.put("msg", map.get("msg"));
                        if (QLog.isColorLevel()) {
                            QLog.i("QQKuiklyPrePrequest", 1, "requestBySSO rsp:" + jSONObject);
                        }
                        QQKuiklyPrePrequest qQKuiklyPrePrequest = QQKuiklyPrePrequest.this;
                        String uniqueId = preRequestItem.getUniqueId();
                        String jSONObject2 = jSONObject.toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject2, "rspObj.toString()");
                        qQKuiklyPrePrequest.p(uniqueId, jSONObject2);
                    }
                });
            }
        }
    }

    public final void f(String uniqueId, Function1<Object, Unit> callback) {
        Map mapOf;
        Map mapOf2;
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        if (!k(uniqueId)) {
            if (callback != null) {
                mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to("errCode", -2), TuplesKt.to("errMsg", "no uniqueId item preload:" + uniqueId));
                callback.invoke(mapOf2);
                return;
            }
            return;
        }
        String j3 = j(uniqueId);
        if (j3 == null) {
            this.cacheCallback = callback;
        } else if (callback != null) {
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("errCode", 0), TuplesKt.to("data", j3));
            callback.invoke(mapOf);
        }
    }

    public final String h(String uniqueId) {
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        if (!k(uniqueId)) {
            return com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.f.INSTANCE.a(-2, "no uniqueId item preload:" + uniqueId, null);
        }
        if (this.cacheRequestMap.isEmpty()) {
            return com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.f.INSTANCE.a(-3, "in preload and request now:" + uniqueId, null);
        }
        String j3 = j(uniqueId);
        if (j3 == null) {
            return com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.f.INSTANCE.a(-3, "in preload and request now:" + uniqueId, null);
        }
        return com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.f.INSTANCE.a(0, "", j3);
    }

    public final boolean k(String uniqueId) {
        Object obj;
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        Iterator<T> it = this.preRequestData.a().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((PreRequestItem) obj).getUniqueId(), uniqueId)) {
                break;
            }
        }
        return obj != null;
    }

    public final void l(final boolean isForceUpdate) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.preload.f
            @Override // java.lang.Runnable
            public final void run() {
                QQKuiklyPrePrequest.m(isForceUpdate, this);
            }
        }, 128, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long g(String pskey) {
        long j3 = 5381;
        for (int i3 = 0; i3 < pskey.length(); i3++) {
            j3 += (j3 << 5) + pskey.charAt(i3);
        }
        return j3 & TTL.MAX_VALUE;
    }
}
