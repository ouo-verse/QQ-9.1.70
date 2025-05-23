package com.tencent.mobileqq.vashealth;

import android.net.Uri;
import android.net.http.Headers;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import com.tencent.util.QQDeviceInfo;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.apache.commons.fileupload.FileUploadBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import org.slf4j.Marker;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b:\u0010;J\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002JP\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013JL\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013H\u0002J\"\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0013H\u0002J\"\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0018\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\nH\u0002J,\u0010!\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J$\u0010\"\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\nH\u0002J\u001a\u0010#\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010$\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010%\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010(\u001a\u00020\n2\b\u0010'\u001a\u0004\u0018\u00010&H\u0002J\u0010\u0010*\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\nH\u0002J\u0010\u0010,\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020+H\u0002J\b\u0010-\u001a\u00020\nH\u0002J\b\u0010.\u001a\u00020\u0006H\u0002R\u0016\u00101\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u001b\u00109\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/vashealth/QQSportRequestUtil;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lh43/d;", "callback", "", BdhLogUtil.LogTag.Tag_Conn, com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "url", "isPost", "Lorg/json/JSONObject;", "param", "headers", "cookie", "", "timeout", "Lh43/c;", "rspCallback", "E", "responseCallback", DomainData.DOMAIN_NAME, "paramsJSON", "w", "method", "Ljava/net/URLConnection;", "y", "Ljava/net/HttpURLConnection;", Headers.CONN_DIRECTIVE, "G", "header", "j", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", HippyTKDListViewAdapter.X, "Ljava/io/InputStream;", "inputStream", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "pskey", ReportConstant.COSTREPORT_PREFIX, "Lh43/b;", "p", "t", "u", "b", "Ljava/lang/String;", "userAgent", "c", "I", "rankingSwitchStateDefault", "d", "Lkotlin/Lazy;", "r", "()Lorg/json/JSONObject;", "requestSafetyDeviceHeader", "<init>", "()V", "health-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class QQSportRequestUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QQSportRequestUtil f312159a = new QQSportRequestUtil();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String userAgent = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static volatile int rankingSwitchStateDefault;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy requestSafetyDeviceHeader;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/vashealth/QQSportRequestUtil$a", "Lsd2/a;", "", "", "domainToKeyMap", "", "onSuccess", "errMsg", "onFail", "health-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a implements sd2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ h43.b f312163a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f312164b;

        a(h43.b bVar, String str) {
            this.f312163a = bVar;
            this.f312164b = str;
        }

        @Override // sd2.a
        public void onFail(@NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.f312163a.onError(errMsg);
        }

        @Override // sd2.a
        public void onSuccess(@NotNull Map<String, String> domainToKeyMap) {
            Intrinsics.checkNotNullParameter(domainToKeyMap, "domainToKeyMap");
            h43.b bVar = this.f312163a;
            String str = domainToKeyMap.get(this.f312164b);
            if (str == null) {
                str = "";
            }
            bVar.onSuccess(str);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/vashealth/QQSportRequestUtil$b", "Lh43/b;", "", "psKey", "", "onSuccess", "errMsg", "onError", "health-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements h43.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f312165a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Uri f312166b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f312167c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ JSONObject f312168d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f312169e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ h43.c f312170f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ JSONObject f312171g;

        b(String str, Uri uri, boolean z16, JSONObject jSONObject, int i3, h43.c cVar, JSONObject jSONObject2) {
            this.f312165a = str;
            this.f312166b = uri;
            this.f312167c = z16;
            this.f312168d = jSONObject;
            this.f312169e = i3;
            this.f312170f = cVar;
            this.f312171g = jSONObject2;
        }

        @Override // h43.b
        public void onError(@NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.e("QQSportRequestUtil", 1, "requestWithAuth error: get PSKey error:" + errMsg);
            h43.c cVar = this.f312170f;
            if (cVar != null) {
                cVar.a(Boolean.FALSE, new JSONObject(), errMsg);
            }
        }

        @Override // h43.b
        public void onSuccess(@NotNull String psKey) {
            CharSequence trim;
            char last;
            StringBuilder sb5;
            Intrinsics.checkNotNullParameter(psKey, "psKey");
            if (TextUtils.isEmpty(psKey)) {
                QLog.e("QQSportRequestUtil", 1, "requestWithAuth error: get PSKey empty");
                return;
            }
            QQSportRequestUtil qQSportRequestUtil = QQSportRequestUtil.f312159a;
            String t16 = qQSportRequestUtil.t();
            if (TextUtils.isEmpty(t16)) {
                QLog.e("QQSportRequestUtil", 1, "requestWithAuth error: get uin empty");
                return;
            }
            String str = "uin=" + t16 + ";p_uin=" + t16 + ";p_skey=" + psKey;
            String str2 = this.f312165a;
            if (str2 != null) {
                trim = StringsKt__StringsKt.trim((CharSequence) str2);
                String obj = trim.toString();
                last = StringsKt___StringsKt.last(obj);
                if (last == ';') {
                    sb5 = new StringBuilder();
                } else {
                    sb5 = new StringBuilder();
                    sb5.append(obj);
                    obj = ";";
                }
                sb5.append(obj);
                sb5.append(str);
                str = sb5.toString();
            }
            String str3 = str;
            String uri = this.f312166b.buildUpon().appendQueryParameter("g_tk", String.valueOf(qQSportRequestUtil.s(psKey))).build().toString();
            Intrinsics.checkNotNullExpressionValue(uri, "urlObject.buildUpon().ap\u2026$gtk\").build().toString()");
            boolean z16 = this.f312167c;
            JSONObject jSONObject = this.f312168d;
            jSONObject.put(StartupReportKey.PLATFORM_ID, 2);
            Unit unit = Unit.INSTANCE;
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = this.f312171g;
            boolean z17 = this.f312167c;
            if (jSONObject3 != null) {
                Iterator keys = jSONObject3.keys();
                Intrinsics.checkNotNullExpressionValue(keys, "headers.keys()");
                while (keys.hasNext()) {
                    String str4 = (String) keys.next();
                    jSONObject2.put(str4, jSONObject3.opt(str4));
                }
            }
            if (z17) {
                jSONObject2.put("Content-Type", "application/json");
            }
            jSONObject2.put("User-Agent", QQSportRequestUtil.userAgent);
            jSONObject2.put("x-safety-device", QQSportRequestUtil.f312159a.r().toString());
            Unit unit2 = Unit.INSTANCE;
            qQSportRequestUtil.n(uri, z16, jSONObject, jSONObject2, str3, this.f312169e, this.f312170f);
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<JSONObject>() { // from class: com.tencent.mobileqq.vashealth.QQSportRequestUtil$requestSafetyDeviceHeader$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final JSONObject invoke() {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(TVKLiveRequestBuilder.RequestParamKey.QIMEI36, QQDeviceInfo.getQIMEI());
                jSONObject.put("platform", "android");
                jSONObject.put("version", AppSetting.f99554n);
                jSONObject.put("device_brand", ah.D());
                jSONObject.put("device_system", "Android");
                jSONObject.put("device_modal", ah.s());
                return jSONObject;
            }
        });
        requestSafetyDeviceHeader = lazy;
    }

    QQSportRequestUtil() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(Boolean bool, JSONObject jSONObject, String str) {
        QLog.d("QQSportRequestUtil", 1, "requestJoinRanking success:" + bool + ", data:" + jSONObject + ", errMsg:" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(h43.d dVar, Boolean success, JSONObject jSONObject, String str) {
        JSONObject jSONObject2;
        Intrinsics.checkNotNullExpressionValue(success, "success");
        int i3 = 0;
        if (success.booleanValue()) {
            if (jSONObject != null) {
                jSONObject2 = jSONObject.optJSONObject("user_switch");
            } else {
                jSONObject2 = null;
            }
            if (jSONObject2 != null) {
                JSONObject optJSONObject = jSONObject2.optJSONObject("switches");
                if (optJSONObject != null) {
                    i3 = optJSONObject.optInt("0");
                }
                rankingSwitchStateDefault = i3;
                QLog.d("QQSportRequestUtil", 1, "rankingSwitchState:" + rankingSwitchStateDefault);
                if (dVar != null) {
                    dVar.a(true, rankingSwitchStateDefault);
                }
            } else if (dVar != null) {
                dVar.a(false, 0);
            }
        } else if (dVar != null) {
            dVar.a(false, 0);
        }
        QLog.d("QQSportRequestUtil", 1, "requestRankingState success:" + success + ", data:" + jSONObject + ", errorMsg: " + str);
    }

    public static /* synthetic */ void F(QQSportRequestUtil qQSportRequestUtil, String str, boolean z16, JSONObject jSONObject, JSONObject jSONObject2, String str2, int i3, h43.c cVar, int i16, Object obj) {
        boolean z17;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        String str3;
        int i17;
        if ((i16 & 2) != 0) {
            z17 = true;
        } else {
            z17 = z16;
        }
        if ((i16 & 4) != 0) {
            jSONObject3 = new JSONObject();
        } else {
            jSONObject3 = jSONObject;
        }
        h43.c cVar2 = null;
        if ((i16 & 8) != 0) {
            jSONObject4 = null;
        } else {
            jSONObject4 = jSONObject2;
        }
        if ((i16 & 16) != 0) {
            str3 = null;
        } else {
            str3 = str2;
        }
        if ((i16 & 32) != 0) {
            i17 = 30;
        } else {
            i17 = i3;
        }
        if ((i16 & 64) == 0) {
            cVar2 = cVar;
        }
        qQSportRequestUtil.E(str, z17, jSONObject3, jSONObject4, str3, i17, cVar2);
    }

    private final void G(HttpURLConnection connection, String method) {
        connection.setRequestMethod(method);
    }

    private final void j(URLConnection connection, String method, JSONObject header, JSONObject param) {
        String l3;
        if (param != null && Intrinsics.areEqual(method, "POST")) {
            connection.setDoOutput(true);
            if (x(header)) {
                l3 = param.toString();
            } else {
                l3 = l(param);
            }
            Intrinsics.checkNotNullExpressionValue(l3, "if (isContentTypeJson(he\u2026mStr(param)\n            }");
            DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
            byte[] bytes = l3.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            dataOutputStream.write(bytes);
            dataOutputStream.close();
        }
    }

    private final void k(URLConnection connection, JSONObject header, String cookie) {
        String str;
        if (cookie != null) {
            connection.addRequestProperty("Cookie", cookie);
        }
        if (header != null) {
            Iterator keys = header.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "keys");
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                Object opt = header.opt(str2);
                if (opt == null || (str = opt.toString()) == null) {
                    str = "";
                }
                connection.addRequestProperty(str2, str);
            }
        }
    }

    private final String l(JSONObject param) {
        String str;
        if (param == null) {
            return "";
        }
        Iterator keys = param.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "keys");
        StringBuilder sb5 = null;
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            Object opt = param.opt(str2);
            if (opt == null || (str = opt.toString()) == null) {
                str = "";
            }
            if (sb5 == null) {
                sb5 = new StringBuilder();
            } else {
                sb5.append(ContainerUtils.FIELD_DELIMITER);
            }
            sb5.append(str2);
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(str);
        }
        return String.valueOf(sb5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0084, code lost:
    
        if (r15 == true) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String m(String url, JSONObject param) {
        boolean z16;
        boolean z17;
        String str;
        boolean contains$default;
        if (param == null) {
            return url;
        }
        Iterator keys = param.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "keys");
        StringBuilder sb5 = null;
        while (true) {
            z16 = true;
            if (!keys.hasNext()) {
                break;
            }
            String str2 = (String) keys.next();
            Object opt = param.opt(str2);
            if (opt != null) {
                str = opt.toString();
            } else {
                str = null;
            }
            String value = URLEncoder.encode(str);
            Intrinsics.checkNotNullExpressionValue(value, "value");
            if (value.length() <= 0) {
                z16 = false;
            }
            if (z16) {
                Intrinsics.checkNotNullExpressionValue(value, "value");
                value = StringsKt__StringsJVMKt.replace$default(value, Marker.ANY_NON_NULL_MARKER, "%20", false, 4, (Object) null);
            }
            if (sb5 == null) {
                sb5 = new StringBuilder();
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, false, 2, (Object) null);
                if (!contains$default) {
                    sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                } else {
                    sb5.append(ContainerUtils.FIELD_DELIMITER);
                }
            } else {
                sb5.append(ContainerUtils.FIELD_DELIMITER);
            }
            sb5.append(str2);
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(value);
        }
        if (sb5 != null) {
            if (sb5.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
        }
        z16 = false;
        if (z16) {
            return url + ((Object) sb5);
        }
        return url;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(final String url, boolean isPost, JSONObject param, JSONObject headers, String cookie, int timeout, final h43.c responseCallback) {
        String str;
        final JSONObject jSONObject = new JSONObject();
        if (isPost) {
            str = "POST";
        } else {
            str = "GET";
        }
        jSONObject.put("method", str);
        jSONObject.put("param", param);
        if (headers != null) {
            jSONObject.put("headers", headers);
        }
        if (cookie != null) {
            jSONObject.put("cookie", cookie);
        }
        jSONObject.put("timeout", timeout);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vashealth.r
            @Override // java.lang.Runnable
            public final void run() {
                QQSportRequestUtil.o(url, jSONObject, responseCallback);
            }
        }, 128, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(String url, JSONObject params, h43.c cVar) {
        Intrinsics.checkNotNullParameter(url, "$url");
        Intrinsics.checkNotNullParameter(params, "$params");
        f312159a.w(url, params, cVar);
    }

    private final void p(h43.b callback) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            callback.onError("appRuntime is null");
            return;
        }
        ((IPskeyManager) peekAppRuntime.getRuntimeService(IPskeyManager.class, "all")).getPskey(new String[]{"yundong.qq.com"}, new a(callback, "yundong.qq.com"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject r() {
        return (JSONObject) requestSafetyDeviceHeader.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int s(String pskey) {
        int length = pskey.length();
        int i3 = 5381;
        for (int i16 = 0; i16 < length; i16++) {
            i3 += (i3 << 5) + pskey.charAt(i16);
        }
        return Integer.MAX_VALUE & i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String t() {
        String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        if (account == null) {
            return "";
        }
        return account;
    }

    private final void u() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vashealth.q
            @Override // java.lang.Runnable
            public final void run() {
                QQSportRequestUtil.v();
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v() {
        String n3 = com.tencent.mobileqq.webview.swift.utils.i.n(com.tencent.mobileqq.webview.swift.utils.i.i(""), "", false);
        Intrinsics.checkNotNullExpressionValue(n3, "getWebViewUAForQQ(\n     \u2026, \"\", false\n            )");
        userAgent = n3;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x016f A[Catch: all -> 0x0196, TRY_LEAVE, TryCatch #5 {all -> 0x0196, blocks: (B:56:0x0158, B:58:0x016f), top: B:55:0x0158 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0186 A[Catch: IOException -> 0x0182, TryCatch #6 {IOException -> 0x0182, blocks: (B:72:0x017e, B:62:0x0186, B:64:0x018b), top: B:71:0x017e }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x018b A[Catch: IOException -> 0x0182, TRY_LEAVE, TryCatch #6 {IOException -> 0x0182, blocks: (B:72:0x017e, B:62:0x0186, B:64:0x018b), top: B:71:0x017e }] */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x017e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a1 A[Catch: IOException -> 0x019d, TryCatch #8 {IOException -> 0x019d, blocks: (B:85:0x0199, B:76:0x01a1, B:78:0x01a6), top: B:84:0x0199 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01a6 A[Catch: IOException -> 0x019d, TRY_LEAVE, TryCatch #8 {IOException -> 0x019d, blocks: (B:85:0x0199, B:76:0x01a1, B:78:0x01a6), top: B:84:0x0199 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0199 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void w(String url, JSONObject paramsJSON, h43.c callback) {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        StringBuilder sb5;
        boolean z16;
        InputStream errorStream;
        boolean startsWith$default;
        JSONObject jSONObject;
        String method = paramsJSON.optString("method");
        JSONObject optJSONObject = paramsJSON.optJSONObject("param");
        JSONObject optJSONObject2 = paramsJSON.optJSONObject("headers");
        String optString = paramsJSON.optString("cookie");
        int optInt = paramsJSON.optInt("timeout");
        InputStream inputStream2 = null;
        try {
            Intrinsics.checkNotNullExpressionValue(method, "method");
            URLConnection y16 = y(url, method, optJSONObject);
            Intrinsics.checkNotNull(y16, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) y16;
            int i3 = optInt * 1000;
            try {
                httpURLConnection2.setConnectTimeout(i3);
                httpURLConnection2.setReadTimeout(i3);
                boolean z17 = false;
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setDoInput(true);
                k(httpURLConnection2, optJSONObject2, optString);
                j(httpURLConnection2, method, optJSONObject2, optJSONObject);
                G(httpURLConnection2, method);
                int responseCode = httpURLConnection2.getResponseCode();
                if (200 <= responseCode && responseCode < 300) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    InputStream inputStream3 = httpURLConnection2.getInputStream();
                    try {
                        String z18 = z(inputStream3);
                        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(z18, "<!DOCTYPE html>", false, 2, null);
                        if (startsWith$default) {
                            if (callback != null) {
                                callback.a(Boolean.FALSE, new JSONObject(), "responseCode:" + responseCode);
                            }
                            if (inputStream3 != null) {
                                try {
                                    inputStream3.close();
                                } catch (IOException e16) {
                                    QLog.e("QQSportRequestUtil", 1, "Network module close error: " + e16);
                                    return;
                                }
                            }
                            httpURLConnection2.disconnect();
                            return;
                        }
                        if (z18.length() > 0) {
                            z17 = true;
                        }
                        if (z17) {
                            jSONObject = new JSONObject(z18);
                        } else {
                            jSONObject = new JSONObject();
                        }
                        if (callback != null) {
                            callback.a(Boolean.TRUE, jSONObject, "responseCode:" + responseCode);
                        }
                        errorStream = null;
                        inputStream2 = inputStream3;
                    } catch (Exception e17) {
                        e = e17;
                        httpURLConnection = httpURLConnection2;
                        inputStream = null;
                        inputStream2 = inputStream3;
                        try {
                            QLog.e("QQSportRequestUtil", 1, "Network error: " + e);
                            if (callback != null) {
                                callback.a(Boolean.FALSE, new JSONObject(), "io exception");
                            }
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (IOException e18) {
                                    e = e18;
                                    sb5 = new StringBuilder();
                                    sb5.append("Network module close error: ");
                                    sb5.append(e);
                                    QLog.e("QQSportRequestUtil", 1, sb5.toString());
                                    return;
                                }
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (httpURLConnection == null) {
                                httpURLConnection.disconnect();
                                return;
                            }
                            return;
                        } catch (Throwable th5) {
                            th = th5;
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (IOException e19) {
                                    QLog.e("QQSportRequestUtil", 1, "Network module close error: " + e19);
                                    throw th;
                                }
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        httpURLConnection = httpURLConnection2;
                        inputStream = null;
                        inputStream2 = inputStream3;
                        if (inputStream2 != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        throw th;
                    }
                } else {
                    errorStream = httpURLConnection2.getErrorStream();
                    try {
                        String z19 = z(errorStream);
                        if (callback != null) {
                            callback.a(Boolean.FALSE, new JSONObject(), "responseCode:" + responseCode + " error: " + z19);
                        }
                    } catch (Exception e26) {
                        httpURLConnection = httpURLConnection2;
                        inputStream = errorStream;
                        e = e26;
                        QLog.e("QQSportRequestUtil", 1, "Network error: " + e);
                        if (callback != null) {
                        }
                        if (inputStream2 != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (httpURLConnection == null) {
                        }
                    } catch (Throwable th7) {
                        httpURLConnection = httpURLConnection2;
                        inputStream = errorStream;
                        th = th7;
                        if (inputStream2 != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        throw th;
                    }
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e27) {
                        e = e27;
                        sb5 = new StringBuilder();
                        sb5.append("Network module close error: ");
                        sb5.append(e);
                        QLog.e("QQSportRequestUtil", 1, sb5.toString());
                        return;
                    }
                }
                if (errorStream != null) {
                    errorStream.close();
                }
                httpURLConnection2.disconnect();
            } catch (Exception e28) {
                e = e28;
                httpURLConnection = httpURLConnection2;
                inputStream = null;
            } catch (Throwable th8) {
                th = th8;
                httpURLConnection = httpURLConnection2;
                inputStream = null;
            }
        } catch (Exception e29) {
            e = e29;
            inputStream = null;
            httpURLConnection = null;
        } catch (Throwable th9) {
            th = th9;
            inputStream = null;
            httpURLConnection = null;
        }
    }

    private final boolean x(JSONObject header) {
        boolean contains$default;
        boolean contains$default2;
        boolean contains$default3;
        boolean contains$default4;
        if (header == null) {
            return false;
        }
        String optString = header.optString("Content-Type");
        Intrinsics.checkNotNullExpressionValue(optString, "header.optString(\"Content-Type\")");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) optString, (CharSequence) "application/json", false, 2, (Object) null);
        if (!contains$default) {
            String optString2 = header.optString("content-Type");
            Intrinsics.checkNotNullExpressionValue(optString2, "header.optString(\"content-Type\")");
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) optString2, (CharSequence) "application/json", false, 2, (Object) null);
            if (!contains$default2) {
                String optString3 = header.optString(FileUploadBase.CONTENT_TYPE);
                Intrinsics.checkNotNullExpressionValue(optString3, "header.optString(\"Content-type\")");
                contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) optString3, (CharSequence) "application/json", false, 2, (Object) null);
                if (!contains$default3) {
                    String optString4 = header.optString("content-type");
                    Intrinsics.checkNotNullExpressionValue(optString4, "header.optString(\"content-type\")");
                    contains$default4 = StringsKt__StringsKt.contains$default((CharSequence) optString4, (CharSequence) "application/json", false, 2, (Object) null);
                    if (!contains$default4) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private final URLConnection y(String url, String method, JSONObject param) {
        if (Intrinsics.areEqual(method, "GET")) {
            url = m(url, param);
        }
        URLConnection openConnection = new URL(url).openConnection();
        Intrinsics.checkNotNullExpressionValue(openConnection, "requestUrl.openConnection()");
        return openConnection;
    }

    private final String z(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return "{}";
        }
        StringBuilder sb5 = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        char[] cArr = new char[2048];
        while (true) {
            int read = bufferedReader.read(cArr);
            if (read != -1) {
                sb5.append(cArr, 0, read + 0);
                Intrinsics.checkNotNullExpressionValue(sb5, "this.append(value, start\u2026x, endIndex - startIndex)");
            } else {
                bufferedReader.close();
                String sb6 = sb5.toString();
                Intrinsics.checkNotNullExpressionValue(sb6, "builder.toString()");
                return sb6;
            }
        }
    }

    public final void A(boolean isOpen) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("join_type", isOpen ? 1 : 0);
        Unit unit = Unit.INSTANCE;
        F(this, "https://yundong.qq.com/v2/trpc/user_server/JoinRank", false, jSONObject, null, null, 0, new h43.c() { // from class: com.tencent.mobileqq.vashealth.p
            @Override // h43.c
            public final void a(Boolean bool, JSONObject jSONObject2, String str) {
                QQSportRequestUtil.B(bool, jSONObject2, str);
            }
        }, 58, null);
    }

    public final void C(@Nullable final h43.d callback) {
        F(this, "https://yundong.qq.com/v2/trpc/user_server/GetSwitch", false, null, null, null, 0, new h43.c() { // from class: com.tencent.mobileqq.vashealth.o
            @Override // h43.c
            public final void a(Boolean bool, JSONObject jSONObject, String str) {
                QQSportRequestUtil.D(h43.d.this, bool, jSONObject, str);
            }
        }, 62, null);
    }

    public final void E(@NotNull String url, boolean isPost, @NotNull JSONObject param, @Nullable JSONObject headers, @Nullable String cookie, int timeout, @Nullable h43.c rspCallback) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(param, "param");
        Uri parse = Uri.parse(url);
        u();
        p(new b(cookie, parse, isPost, param, timeout, rspCallback, headers));
    }

    public final boolean q() {
        if (rankingSwitchStateDefault != 0) {
            return true;
        }
        return false;
    }
}
