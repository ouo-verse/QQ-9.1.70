package com.tencent.luggage.wxa.z6;

import android.content.Context;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.luggage.wxa.df.h;
import com.tencent.luggage.wxa.gh.e;
import com.tencent.luggage.wxa.ic.k;
import com.tencent.luggage.wxa.ig.m;
import com.tencent.luggage.wxa.ig.q;
import com.tencent.luggage.wxa.ig.u;
import com.tencent.luggage.wxa.ig.x;
import com.tencent.luggage.wxa.ig.y;
import com.tencent.luggage.wxa.j4.g;
import com.tencent.luggage.wxa.jg.j;
import com.tencent.luggage.wxa.nf.f;
import com.tencent.luggage.wxa.nf.i;
import com.tencent.luggage.wxa.q7.s;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.xd.a1;
import com.tencent.luggage.wxa.xd.t0;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeServlet;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f146355a = new e();

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f146356b;

    /* renamed from: c, reason: collision with root package name */
    public static final Set f146357c;

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f146358d;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f146359a;

        static {
            int[] iArr = new int[j.g.values().length];
            iArr[j.g.None.ordinal()] = 1;
            f146359a = iArr;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.g7.d f146360a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f146361b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f146362c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f146363d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f146364e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f146365f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ long f146366g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f146367h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ int f146368i;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ String f146369j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ int f146370k;

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ int f146371l;

        public b(com.tencent.luggage.wxa.g7.d dVar, String str, String str2, String str3, String str4, int i3, long j3, String str5, int i16, String str6, int i17, int i18) {
            this.f146360a = dVar;
            this.f146361b = str;
            this.f146362c = str2;
            this.f146363d = str3;
            this.f146364e = str4;
            this.f146365f = i3;
            this.f146366g = j3;
            this.f146367h = str5;
            this.f146368i = i16;
            this.f146369j = str6;
            this.f146370k = i17;
            this.f146371l = i18;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean contains$default;
            boolean contains$default2;
            com.tencent.luggage.wxa.f7.b bVar = new com.tencent.luggage.wxa.f7.b(null, null, null, 0, null, 0, 0, null, 0, 0, 0, null, 0L, 0, 16383, null);
            String str = this.f146361b;
            String str2 = this.f146362c;
            int i3 = this.f146368i;
            String str3 = this.f146369j;
            int i16 = this.f146370k;
            int i17 = this.f146371l;
            String str4 = this.f146363d;
            String str5 = this.f146367h;
            int i18 = this.f146365f;
            s.d dVar = s.d.f138074a;
            bVar.d(dVar.b());
            bVar.g(str);
            bVar.e(str2);
            bVar.f(i3);
            bVar.f(str3);
            bVar.a(i16);
            bVar.b(i17);
            bVar.c(str4);
            int i19 = 2;
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) str5, (CharSequence) FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, false, 2, (Object) null);
            if (!contains$default) {
                contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) str5, (CharSequence) "cancel", false, 2, (Object) null);
                if (contains$default2) {
                    i19 = 3;
                }
            } else {
                i19 = 1;
            }
            bVar.e(i19);
            bVar.d(i18);
            bVar.c(0);
            bVar.b(str5);
            bVar.a(dVar.c());
            bVar.g(603979777);
            bVar.c();
            e.f146355a.a(this.f146360a, this.f146361b, this.f146362c, this.f146363d, this.f146364e, this.f146365f, this.f146366g, this.f146367h);
        }
    }

    static {
        String[] strArr = {"addMapCircles", "addMapControls", "addMapLines", "addMapMarkers", "createAudioInstance", com.tencent.luggage.wxa.pf.b.NAME, f.NAME, "destroyAudioInstance", "disableScrollBounce", "drawCanvas", "getAudioState", "getCurrentRoute", "getMapCenterLocation", m.NAME, q.NAME, "getSystemInfo", UIJsPlugin.EVENT_HIDE_TOAST, "moveToMapLocation", SensorJsPlugin.EVENT_ACCELEROMETER_STATE_CHANGE, SensorJsPlugin.EVENT_COMPASS_STATE_CHANGE, h.g.NAME, "onMapRegionChange", "onSocketClose", "onSocketError", "onSocketMessage", "onSocketOpen", "onTouchEnd", "onTouchMove", e.c.NAME, "onVideoTimeUpdate", "operateAudio", i.NAME, u.NAME, "reportIDKey", "reportKeyValue", "reportRealtimeAction", x.NAME, y.NAME, UIJsPlugin.EVENT_SHOW_MODAL, UIJsPlugin.EVENT_SHOW_TOAST, "syncAudioEvent", "updateCanvas", "updateMap", a1.NAME};
        f146356b = strArr;
        f146357c = new HashSet(Arrays.asList(Arrays.copyOf(strArr, 44)));
        f146358d = Pattern.compile(".*\"errMsg\":\"[^:]+:([^\"]+)\".*");
    }

    public final void b(com.tencent.luggage.wxa.g7.d dVar, String str, String str2, String str3, String str4, int i3, long j3, String ret) {
        Intrinsics.checkNotNullParameter(ret, "ret");
        com.tencent.luggage.wxa.p5.f b16 = com.tencent.luggage.wxa.p6.h.b(str);
        if (b16 == null) {
            return;
        }
        com.tencent.luggage.wxa.bk.e L1 = b16.L1();
        int i16 = L1 != null ? L1.f122984c : 0;
        com.tencent.luggage.wxa.bk.e L12 = b16.L1();
        com.tencent.luggage.wxa.zp.h.f146825d.b(new b(dVar, str, str2, str3, str4, i3, j3, ret, i16, L12 != null ? L12.f122985d : null, b16.l0() + 1, b16.C1()), "Luggage.WXA.JsApiInvokeReportProtocol");
    }

    public final boolean c(String str) {
        if (str != null && str.length() != 0) {
            return false;
        }
        return true;
    }

    public final String a(String str) {
        if (w0.c(str)) {
            return "";
        }
        Matcher matcher = f146358d.matcher(str);
        if (!matcher.matches()) {
            return "";
        }
        String d16 = w0.d(matcher.group(1));
        Intrinsics.checkNotNullExpressionValue(d16, "{\n            Util.nullA\u2026tcher.group(1))\n        }");
        return d16;
    }

    public final String a(Context context) {
        if (context == null) {
            context = z.c();
        }
        j.g a16 = j.a(context);
        String str = a.f146359a[a16.ordinal()] == 1 ? "offline" : a16.f131107a;
        Intrinsics.checkNotNullExpressionValue(str, "getNetworkType(context?:\u2026e\n            }\n        }");
        return str;
    }

    public final int b(String str) {
        boolean startsWith$default;
        boolean startsWith$default2;
        if (!w0.c(str)) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, false, 2, null);
            if (!startsWith$default) {
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(str, "fail", false, 2, null);
                if (startsWith$default2) {
                    return 2;
                }
            }
        }
        return 1;
    }

    public final int a(com.tencent.luggage.wxa.g7.d dVar, String str) {
        if (Intrinsics.areEqual("@LibraryAppId", str)) {
            return 0;
        }
        int a16 = com.tencent.luggage.wxa.z6.b.a(str, 0, 2, null);
        if (a16 < 0) {
            com.tencent.luggage.wxa.r5.a S = dVar != null ? dVar.S() : null;
            if (S != null) {
                a16 = S.I;
                com.tencent.luggage.wxa.z6.b.a(str, a16);
            } else {
                w.d("Luggage.WXA.JsApiInvokeReportProtocol", "getServiceTypeForReport null = initConfig! appServiceType:%s", Integer.valueOf(a16));
            }
        }
        return a16 + 1000;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:12|(1:153)(9:16|17|(1:19)(1:150)|20|22|23|(2:82|(6:130|131|132|(1:134)|135|136)(2:84|(2:118|119)(2:86|(1:88)(2:89|(1:91)(2:92|(1:94)(2:95|(1:97)(2:98|(3:100|101|102)(2:111|(1:113)(4:114|(1:116)|117|41)))))))))(1:39)|40|41)|42|(2:44|(13:46|47|48|49|50|51|52|53|54|55|(1:57)|58|(4:64|(1:66)(1:69)|67|68)(1:63))(1:79))(1:81)|80|47|48|49|50|51|52|53|54|55|(0)|58|(1:60)(5:61|64|(0)(0)|67|68)) */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0234, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0235, code lost:
    
        com.tencent.luggage.wxa.tn.w.a("Luggage.WXA.JsApiInvokeReportProtocol", r0, "encode keyResult path error!", new java.lang.Object[r14]);
        r0 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0220, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0221, code lost:
    
        com.tencent.luggage.wxa.tn.w.a("Luggage.WXA.JsApiInvokeReportProtocol", r0, "encode keyParam path error!", new java.lang.Object[r14]);
        r4 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x020b, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x020c, code lost:
    
        com.tencent.luggage.wxa.tn.w.a("Luggage.WXA.JsApiInvokeReportProtocol", r0, "encode page path error!", new java.lang.Object[r14]);
        r3 = r17;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0267 A[ADDED_TO_REGION, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(com.tencent.luggage.wxa.g7.d dVar, String str, String str2, String str3, String str4, int i3, long j3, String str5) {
        boolean contains;
        String str6;
        String str7;
        char c16;
        String str8;
        String str9;
        int i16;
        String str10;
        String str11;
        String str12;
        String str13;
        String d16;
        String a16;
        int b16;
        String d17;
        String a17;
        com.tencent.luggage.wxa.r5.a S;
        g j06;
        String str14;
        boolean contains$default;
        int lastIndexOf$default;
        String str15;
        String str16;
        int i17;
        JSONObject jSONObject;
        String obj;
        com.tencent.luggage.wxa.bk.e L1 = dVar != null ? dVar.L1() : null;
        if (L1 != null) {
            contains = CollectionsKt___CollectionsKt.contains(f146357c, str3);
            if (contains) {
                return;
            }
            if (w0.c(str4) || w0.c(str3)) {
                str6 = "";
                str7 = str6;
            } else {
                try {
                    jSONObject = new JSONObject(str4 == null ? "" : str4);
                    str16 = a(str3, jSONObject);
                    try {
                    } catch (JSONException e16) {
                        e = e16;
                        str15 = "";
                        i17 = 0;
                        w.a("Luggage.WXA.JsApiInvokeReportProtocol", e, "get keyParam error!", new Object[i17]);
                        Unit unit = Unit.INSTANCE;
                        str7 = str15;
                        str6 = str16;
                        String a18 = a(str5, str3);
                        if (w0.c(str2)) {
                        }
                        str10 = str9;
                        str11 = URLEncoder.encode(w0.d(str10), "UTF-8");
                        str12 = URLEncoder.encode(w0.d(str7), "UTF-8");
                        str13 = URLEncoder.encode(w0.d(a18), "UTF-8");
                        d16 = w0.d(str3);
                        a16 = a(str5);
                        b16 = b(a16);
                        d17 = w0.d(L1.f122985d);
                        a17 = a(z.c());
                        if (L1.f122984c == 0) {
                        }
                        S = dVar.S();
                        if (S == null) {
                        }
                    }
                } catch (JSONException e17) {
                    e = e17;
                    str15 = "";
                    str16 = str15;
                }
                if (jSONObject.has("url") && (Intrinsics.areEqual(str3, t0.NAME) || Intrinsics.areEqual(str3, "redirectTo") || Intrinsics.areEqual(str3, "navigateTo") || Intrinsics.areEqual(str3, Const.BUNDLE_KEY_REQUEST) || Intrinsics.areEqual(str3, "connectSocket") || Intrinsics.areEqual(str3, "uploadFile") || Intrinsics.areEqual(str3, "downloadFile"))) {
                    obj = jSONObject.optString("url");
                } else if (Intrinsics.areEqual(str3, "authorize")) {
                    try {
                        JSONArray jSONArray = new JSONArray(jSONObject.optString("scope"));
                        LinkedList linkedList = new LinkedList();
                        int length = jSONArray.length();
                        for (int i18 = 0; i18 < length; i18++) {
                            linkedList.add(jSONArray.optString(i18));
                        }
                        obj = linkedList.toString();
                    } catch (Exception e18) {
                        Object[] objArr = new Object[1];
                        try {
                            objArr[0] = e18.getMessage();
                            w.b("Luggage.WXA.JsApiInvokeReportProtocol", "Exception %s", objArr);
                            return;
                        } catch (JSONException e19) {
                            e = e19;
                            i17 = 0;
                            str15 = "";
                            w.a("Luggage.WXA.JsApiInvokeReportProtocol", e, "get keyParam error!", new Object[i17]);
                            Unit unit2 = Unit.INSTANCE;
                            str7 = str15;
                            str6 = str16;
                            String a182 = a(str5, str3);
                            if (w0.c(str2)) {
                            }
                            str10 = str9;
                            str11 = URLEncoder.encode(w0.d(str10), "UTF-8");
                            str12 = URLEncoder.encode(w0.d(str7), "UTF-8");
                            str13 = URLEncoder.encode(w0.d(a182), "UTF-8");
                            d16 = w0.d(str3);
                            a16 = a(str5);
                            b16 = b(a16);
                            d17 = w0.d(L1.f122985d);
                            a17 = a(z.c());
                            if (L1.f122984c == 0) {
                            }
                            S = dVar.S();
                            if (S == null) {
                            }
                        }
                    }
                } else if (Intrinsics.areEqual(str3, com.tencent.luggage.wxa.c3.d.NAME)) {
                    try {
                        obj = URLEncoder.encode(w0.d(jSONObject.toString()), "UTF-8");
                    } catch (UnsupportedEncodingException e26) {
                        try {
                            w.a("Luggage.WXA.JsApiInvokeReportProtocol", e26, "", new Object[0]);
                        } catch (JSONException e27) {
                            e = e27;
                            i17 = 0;
                            str15 = "";
                            w.a("Luggage.WXA.JsApiInvokeReportProtocol", e, "get keyParam error!", new Object[i17]);
                            Unit unit22 = Unit.INSTANCE;
                            str7 = str15;
                            str6 = str16;
                            String a1822 = a(str5, str3);
                            if (w0.c(str2)) {
                            }
                            str10 = str9;
                            str11 = URLEncoder.encode(w0.d(str10), "UTF-8");
                            str12 = URLEncoder.encode(w0.d(str7), "UTF-8");
                            str13 = URLEncoder.encode(w0.d(a1822), "UTF-8");
                            d16 = w0.d(str3);
                            a16 = a(str5);
                            b16 = b(a16);
                            d17 = w0.d(L1.f122985d);
                            a17 = a(z.c());
                            if (L1.f122984c == 0) {
                            }
                            S = dVar.S();
                            if (S == null) {
                            }
                        }
                    }
                } else if (Intrinsics.areEqual(str3, "requestPayment")) {
                    obj = jSONObject.optString("package");
                } else if (Intrinsics.areEqual(str3, "reportSubmitForm")) {
                    obj = k.b(str).f129898a;
                } else if (Intrinsics.areEqual(str3, "makePhoneCall")) {
                    obj = jSONObject.optString(MiniAppSendSmsCodeServlet.KEY_PHONE_NUMBER);
                } else if (Intrinsics.areEqual(str3, "chooseVideo")) {
                    obj = jSONObject.optString("maxDuration");
                } else if (Intrinsics.areEqual(str3, "updateHTMLWebView")) {
                    str15 = jSONObject.optString("src");
                    try {
                        obj = URLEncoder.encode(jSONObject.optString("src"), "UTF-8");
                    } catch (Exception e28) {
                        try {
                            w.b("Luggage.WXA.JsApiInvokeReportProtocol", e28.toString());
                        } catch (JSONException e29) {
                            e = e29;
                            i17 = 0;
                            w.a("Luggage.WXA.JsApiInvokeReportProtocol", e, "get keyParam error!", new Object[i17]);
                            Unit unit222 = Unit.INSTANCE;
                            str7 = str15;
                            str6 = str16;
                            String a18222 = a(str5, str3);
                            if (w0.c(str2)) {
                            }
                            str10 = str9;
                            str11 = URLEncoder.encode(w0.d(str10), "UTF-8");
                            str12 = URLEncoder.encode(w0.d(str7), "UTF-8");
                            str13 = URLEncoder.encode(w0.d(a18222), "UTF-8");
                            d16 = w0.d(str3);
                            a16 = a(str5);
                            b16 = b(a16);
                            d17 = w0.d(L1.f122985d);
                            a17 = a(z.c());
                            if (L1.f122984c == 0) {
                            }
                            S = dVar.S();
                            if (S == null) {
                            }
                        }
                    }
                } else if (Intrinsics.areEqual(str3, "showKeyboard")) {
                    obj = jSONObject.optString("confirmType");
                } else {
                    if (Intrinsics.areEqual(str3, "setAudioState")) {
                        obj = jSONObject.optString(InnerAudioPlugin.AUDIO_PROPERTY_VOLUME);
                    }
                    str15 = "";
                    Unit unit2222 = Unit.INSTANCE;
                    str7 = str15;
                    str6 = str16;
                }
                str15 = obj;
                Unit unit22222 = Unit.INSTANCE;
                str7 = str15;
                str6 = str16;
            }
            String a182222 = a(str5, str3);
            if (w0.c(str2)) {
                c16 = 2;
                str8 = str6;
                str9 = "";
                i16 = 0;
            } else {
                Intrinsics.checkNotNull(str2);
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) ".html", false, 2, (Object) null);
                if (contains$default) {
                    c16 = 2;
                    str8 = str6;
                    i16 = 0;
                    str9 = "";
                    lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) str2, ".html", 0, false, 6, (Object) null);
                    str10 = str2.substring(0, lastIndexOf$default + 5);
                    Intrinsics.checkNotNullExpressionValue(str10, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    str11 = URLEncoder.encode(w0.d(str10), "UTF-8");
                    str12 = URLEncoder.encode(w0.d(str7), "UTF-8");
                    str13 = URLEncoder.encode(w0.d(a182222), "UTF-8");
                    d16 = w0.d(str3);
                    a16 = a(str5);
                    b16 = b(a16);
                    d17 = w0.d(L1.f122985d);
                    a17 = a(z.c());
                    if (L1.f122984c == 0) {
                        L1.f122984c = 1000;
                    }
                    S = dVar.S();
                    if (S == null && (j06 = dVar.j0()) != null) {
                        int i19 = j06.f125966l.pkgVersion;
                        int a19 = j06.a() + 1;
                        String str17 = str13;
                        int a26 = a(dVar, str);
                        String str18 = str12;
                        if (w.d() > 1) {
                            Object[] objArr2 = new Object[21];
                            objArr2[0] = Integer.valueOf(L1.f122984c);
                            objArr2[1] = d17;
                            objArr2[c16] = str;
                            objArr2[3] = Integer.valueOf(i19);
                            objArr2[4] = Integer.valueOf(a19);
                            objArr2[5] = str10;
                            objArr2[6] = a17;
                            objArr2[7] = d16;
                            objArr2[8] = str7;
                            objArr2[9] = Integer.valueOf(b16);
                            objArr2[10] = Integer.valueOf(i3);
                            objArr2[11] = 0;
                            objArr2[12] = Long.valueOf(j3);
                            objArr2[13] = 0;
                            objArr2[14] = a16;
                            objArr2[15] = Integer.valueOf(L1.f122986e);
                            objArr2[16] = Integer.valueOf(a26);
                            objArr2[17] = a182222;
                            str14 = str8;
                            objArr2[18] = str14;
                            objArr2[19] = S.k();
                            objArr2[20] = S.j();
                            w.a("Luggage.WXA.JsApiInvokeReportProtocol", "jsapi invoke fields, scene : %s, sceneNote %s, appId %s, appVersion %d, appState %d, pagePath %s, networkType %s, functionName %s, keyParam %s, result %d, permissionValue %d, errorCode %d, costTime %s, errCode %d, errMsg %s, usedState %d, appType %d, keyResult %s, keyRequest %s, instanceId:%s, sessionId:%s", objArr2);
                        } else {
                            str14 = str8;
                        }
                        com.tencent.luggage.wxa.f7.c cVar = new com.tencent.luggage.wxa.f7.c(0, null, null, 0, 0, null, null, null, null, 0, 0, 0, 0L, 0, null, 0, 0, null, 0, null, null, null, 4194303, null);
                        cVar.i(L1.f122984c);
                        cVar.k(d17);
                        cVar.l(str);
                        cVar.c(i19);
                        cVar.a(a19);
                        cVar.i(str11);
                        cVar.h(a17);
                        cVar.c(d16);
                        cVar.e(str18);
                        cVar.h(b16);
                        cVar.f(i3);
                        cVar.d(0);
                        cVar.a(j3);
                        cVar.e(0);
                        cVar.b(a16);
                        cVar.j(L1.f122986e);
                        cVar.g(L1.f122982a);
                        cVar.j(L1.f122983b);
                        cVar.b(a26);
                        cVar.g(str17);
                        cVar.f(str14);
                        cVar.d(S.k());
                        Unit unit3 = Unit.INSTANCE;
                        cVar.c();
                        return;
                    }
                    return;
                }
                i16 = 0;
                c16 = 2;
                str8 = str6;
                str9 = "";
            }
            str10 = str9;
            str11 = URLEncoder.encode(w0.d(str10), "UTF-8");
            str12 = URLEncoder.encode(w0.d(str7), "UTF-8");
            str13 = URLEncoder.encode(w0.d(a182222), "UTF-8");
            d16 = w0.d(str3);
            a16 = a(str5);
            b16 = b(a16);
            d17 = w0.d(L1.f122985d);
            a17 = a(z.c());
            if (L1.f122984c == 0) {
            }
            S = dVar.S();
            if (S == null) {
                return;
            }
            int i192 = j06.f125966l.pkgVersion;
            int a192 = j06.a() + 1;
            String str172 = str13;
            int a262 = a(dVar, str);
            String str182 = str12;
            if (w.d() > 1) {
            }
            com.tencent.luggage.wxa.f7.c cVar2 = new com.tencent.luggage.wxa.f7.c(0, null, null, 0, 0, null, null, null, null, 0, 0, 0, 0L, 0, null, 0, 0, null, 0, null, null, null, 4194303, null);
            cVar2.i(L1.f122984c);
            cVar2.k(d17);
            cVar2.l(str);
            cVar2.c(i192);
            cVar2.a(a192);
            cVar2.i(str11);
            cVar2.h(a17);
            cVar2.c(d16);
            cVar2.e(str182);
            cVar2.h(b16);
            cVar2.f(i3);
            cVar2.d(0);
            cVar2.a(j3);
            cVar2.e(0);
            cVar2.b(a16);
            cVar2.j(L1.f122986e);
            cVar2.g(L1.f122982a);
            cVar2.j(L1.f122983b);
            cVar2.b(a262);
            cVar2.g(str172);
            cVar2.f(str14);
            cVar2.d(S.k());
            Unit unit32 = Unit.INSTANCE;
            cVar2.c();
            return;
        }
        w.b("Luggage.WXA.JsApiInvokeReportProtocol", "statObject is Null!");
    }

    public final String a(String str, String str2) {
        if (w0.c(str) || w0.c(str2)) {
            return "";
        }
        try {
            if (!Intrinsics.areEqual(str2, "getLocation")) {
                return "";
            }
            if (str == null) {
                str = "";
            }
            JSONObject jSONObject = new JSONObject(str);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%s;%s;%s;%s;%s;%s;%s", Arrays.copyOf(new Object[]{jSONObject.optString("latitude"), jSONObject.optString("longitude"), jSONObject.optString("speed"), jSONObject.optString("accuracy"), jSONObject.optString("altitude"), jSONObject.optString("verticalAccuracy"), jSONObject.optString("horizontalAccuracy")}, 7));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        } catch (JSONException e16) {
            w.a("Luggage.WXA.JsApiInvokeReportProtocol", e16, "get keyParam error!", new Object[0]);
            return "";
        }
    }

    public final String a(String str, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (Intrinsics.areEqual(str, "chooseImage")) {
                jSONObject2.put("sizeType", jSONObject.optString("sizeType"));
            }
        } catch (JSONException e16) {
            w.a("Luggage.WXA.JsApiInvokeReportProtocol", e16, "get keyParam error!", new Object[0]);
        }
        try {
            return URLEncoder.encode(jSONObject2.toString(), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }
}
