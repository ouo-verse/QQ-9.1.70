package com.tencent.luggage.wxa.eg;

import com.tencent.luggage.wxa.fd.q;
import com.tencent.luggage.wxa.ic.g;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xd.i;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Pattern;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 63;

    @NotNull
    public static final String NAME = "reportKeyValue";

    /* renamed from: a, reason: collision with root package name */
    public static final a f124761a = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0161 A[Catch: Exception -> 0x025a, TryCatch #6 {Exception -> 0x025a, blocks: (B:113:0x013f, B:24:0x0157, B:26:0x0161, B:39:0x016f), top: B:112:0x013f }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x016c  */
    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void invoke(i iVar, JSONObject jSONObject, int i3) {
        String str;
        String str2;
        JSONArray jSONArray;
        int i16;
        int i17;
        int i18;
        int i19;
        String str3;
        List emptyList;
        String[] strArr;
        boolean z16;
        String join;
        int i26;
        com.tencent.luggage.wxa.zj.d dVar;
        Object[] objArr;
        Object[] objArr2;
        String str4 = ",";
        String str5 = "value";
        if (iVar != null && jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("dataArray");
            if (optJSONArray == null) {
                iVar.a(i3, makeReturnJson("fail:invalid data"));
                return;
            }
            int optInt = jSONObject.optInt("version", -1);
            q qVar = (q) iVar.a(q.class);
            if (qVar == null) {
                w.b("MicroMsg.JsApiReportKeyValue", "config is Null!");
                iVar.a(i3, makeReturnJson("fail:interrupted"));
                return;
            }
            int length = optJSONArray.length();
            int i27 = 0;
            int i28 = 0;
            while (i28 < length) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i28);
                    int optInt2 = jSONObject2.optInt("key");
                    String optString = jSONObject2.optString(str5);
                    if (optInt2 > 0 && !w0.c(optString)) {
                        if (optInt2 == 15496) {
                            try {
                                Intrinsics.checkNotNullExpressionValue(optString, str5);
                                String quote = Pattern.quote(str4);
                                Intrinsics.checkNotNullExpressionValue(quote, "quote(\",\")");
                                List<String> split = new Regex(quote).split(optString, i27);
                                if (!split.isEmpty()) {
                                    ListIterator<String> listIterator = split.listIterator(split.size());
                                    while (listIterator.hasPrevious()) {
                                        if (listIterator.previous().length() == 0) {
                                            i26 = 1;
                                        } else {
                                            i26 = i27;
                                        }
                                        if (i26 == 0) {
                                            emptyList = CollectionsKt___CollectionsKt.take(split, listIterator.nextIndex() + 1);
                                            break;
                                        }
                                    }
                                }
                                emptyList = CollectionsKt__CollectionsKt.emptyList();
                                Object[] array = emptyList.toArray(new String[i27]);
                                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                strArr = (String[]) array;
                                int[] iArr = {17, 11, 9, 2};
                                str2 = str5;
                                jSONArray = optJSONArray;
                                int i29 = 0;
                                z16 = false;
                                for (int i36 = 4; i29 < i36; i36 = 4) {
                                    try {
                                        int i37 = iArr[i29];
                                        i17 = length;
                                        try {
                                            String str6 = strArr[i37];
                                            int[] iArr2 = iArr;
                                            str3 = optString;
                                            if (w0.d(str6).length() > 1024) {
                                                try {
                                                    String substring = str6.substring(0, 1024);
                                                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                                    strArr[i37] = substring;
                                                    z16 = true;
                                                } catch (Exception e16) {
                                                    e = e16;
                                                    try {
                                                        Object[] objArr3 = new Object[1];
                                                    } catch (Exception e17) {
                                                        e = e17;
                                                        str = str4;
                                                        i19 = 1;
                                                        i16 = optInt;
                                                        Object[] objArr4 = new Object[i19];
                                                        i18 = 0;
                                                        objArr4[0] = e.getMessage();
                                                        w.b("MicroMsg.JsApiReportKeyValue", "AppBrandComponent parse report value failed : %s", objArr4);
                                                        i28++;
                                                        i27 = i18;
                                                        str5 = str2;
                                                        optJSONArray = jSONArray;
                                                        length = i17;
                                                        str4 = str;
                                                        optInt = i16;
                                                    }
                                                    try {
                                                        objArr3[0] = e;
                                                        w.b("MicroMsg.JsApiReportKeyValue", "modify 15496 too large string-fields, e=%s", objArr3);
                                                        join = str3;
                                                        dVar = (com.tencent.luggage.wxa.zj.d) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.d.class);
                                                        if (dVar == null) {
                                                        }
                                                    } catch (Exception e18) {
                                                        e = e18;
                                                        str = str4;
                                                        i16 = optInt;
                                                        i19 = 1;
                                                        Object[] objArr42 = new Object[i19];
                                                        i18 = 0;
                                                        objArr42[0] = e.getMessage();
                                                        w.b("MicroMsg.JsApiReportKeyValue", "AppBrandComponent parse report value failed : %s", objArr42);
                                                        i28++;
                                                        i27 = i18;
                                                        str5 = str2;
                                                        optJSONArray = jSONArray;
                                                        length = i17;
                                                        str4 = str;
                                                        optInt = i16;
                                                    }
                                                }
                                            }
                                            i29++;
                                            length = i17;
                                            optString = str3;
                                            iArr = iArr2;
                                        } catch (Exception e19) {
                                            e = e19;
                                            str3 = optString;
                                            Object[] objArr32 = new Object[1];
                                            objArr32[0] = e;
                                            w.b("MicroMsg.JsApiReportKeyValue", "modify 15496 too large string-fields, e=%s", objArr32);
                                            join = str3;
                                            dVar = (com.tencent.luggage.wxa.zj.d) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.d.class);
                                            if (dVar == null) {
                                            }
                                        }
                                    } catch (Exception e26) {
                                        e = e26;
                                        i17 = length;
                                        str3 = optString;
                                        Object[] objArr322 = new Object[1];
                                        objArr322[0] = e;
                                        w.b("MicroMsg.JsApiReportKeyValue", "modify 15496 too large string-fields, e=%s", objArr322);
                                        join = str3;
                                        dVar = (com.tencent.luggage.wxa.zj.d) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.d.class);
                                        if (dVar == null) {
                                        }
                                    }
                                }
                                i17 = length;
                                str3 = optString;
                            } catch (Exception e27) {
                                e = e27;
                                str2 = str5;
                                jSONArray = optJSONArray;
                            }
                            if (z16) {
                                join = StringUtils.join(strArr, str4);
                                dVar = (com.tencent.luggage.wxa.zj.d) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.d.class);
                                if (dVar == null) {
                                    iVar.a(i3, makeReturnJson("fail:not supported"));
                                    return;
                                }
                                if (optInt >= 2) {
                                    g runtime = iVar.getRuntime();
                                    Intrinsics.checkNotNull(runtime, "null cannot be cast to non-null type com.tencent.luggage.sdk.runtime.AppBrandRuntimeLU");
                                    com.tencent.luggage.wxa.c5.e eVar = (com.tencent.luggage.wxa.c5.e) runtime;
                                    com.tencent.luggage.wxa.j4.d S = eVar.S();
                                    String k3 = S.k();
                                    String appId = eVar.getAppId();
                                    int C1 = eVar.C1();
                                    int l06 = eVar.l0() + 1;
                                    int i38 = S.I + 1000;
                                    str = str4;
                                    try {
                                        objArr = new Object[7];
                                        objArr[0] = Integer.valueOf(optInt2);
                                        objArr[1] = k3;
                                        objArr[2] = appId;
                                        objArr[3] = Integer.valueOf(C1);
                                        objArr[4] = Integer.valueOf(l06);
                                        objArr[5] = Integer.valueOf(i38);
                                        i16 = optInt;
                                    } catch (Exception e28) {
                                        e = e28;
                                        i16 = optInt;
                                        i19 = 1;
                                        Object[] objArr422 = new Object[i19];
                                        i18 = 0;
                                        objArr422[0] = e.getMessage();
                                        w.b("MicroMsg.JsApiReportKeyValue", "AppBrandComponent parse report value failed : %s", objArr422);
                                        i28++;
                                        i27 = i18;
                                        str5 = str2;
                                        optJSONArray = jSONArray;
                                        length = i17;
                                        str4 = str;
                                        optInt = i16;
                                    }
                                    try {
                                        objArr[6] = join;
                                        w.d("MicroMsg.JsApiReportKeyValue", "report kv_%d{instanceId=%s, appId=%s, appversion=%d, appstate=%d, apptype=%d, value=%s}", objArr);
                                        objArr2 = new Object[6];
                                        objArr2[0] = k3;
                                    } catch (Exception e29) {
                                        e = e29;
                                        i19 = 1;
                                        Object[] objArr4222 = new Object[i19];
                                        i18 = 0;
                                        objArr4222[0] = e.getMessage();
                                        w.b("MicroMsg.JsApiReportKeyValue", "AppBrandComponent parse report value failed : %s", objArr4222);
                                        i28++;
                                        i27 = i18;
                                        str5 = str2;
                                        optJSONArray = jSONArray;
                                        length = i17;
                                        str4 = str;
                                        optInt = i16;
                                    }
                                    try {
                                        objArr2[1] = appId;
                                        objArr2[2] = Integer.valueOf(C1);
                                        objArr2[3] = Integer.valueOf(l06);
                                        objArr2[4] = Integer.valueOf(i38);
                                        objArr2[5] = join;
                                        dVar.a(optInt2, objArr2);
                                    } catch (Exception e36) {
                                        e = e36;
                                        i19 = 1;
                                        Object[] objArr42222 = new Object[i19];
                                        i18 = 0;
                                        objArr42222[0] = e.getMessage();
                                        w.b("MicroMsg.JsApiReportKeyValue", "AppBrandComponent parse report value failed : %s", objArr42222);
                                        i28++;
                                        i27 = i18;
                                        str5 = str2;
                                        optJSONArray = jSONArray;
                                        length = i17;
                                        str4 = str;
                                        optInt = i16;
                                    }
                                } else {
                                    str = str4;
                                    i16 = optInt;
                                    Object[] objArr5 = new Object[5];
                                    objArr5[0] = Integer.valueOf(optInt2);
                                    try {
                                        objArr5[1] = iVar.getAppId();
                                        objArr5[2] = Integer.valueOf(qVar.f125966l.pkgVersion);
                                        objArr5[3] = Integer.valueOf(qVar.f125966l.f151861a + 1);
                                        objArr5[4] = join;
                                        w.d("MicroMsg.JsApiReportKeyValue", "report kv_%d{appId='%s',pkgVersion=%d,pkgDebugType=%d,value='%s'}", objArr5);
                                        Object[] objArr6 = new Object[4];
                                        objArr6[0] = iVar.getAppId();
                                        try {
                                            objArr6[1] = Integer.valueOf(qVar.f125966l.pkgVersion);
                                            objArr6[2] = Integer.valueOf(qVar.f125966l.f151861a + 1);
                                            objArr6[3] = join;
                                            dVar.a(optInt2, objArr6);
                                        } catch (Exception e37) {
                                            e = e37;
                                            i19 = 1;
                                            Object[] objArr422222 = new Object[i19];
                                            i18 = 0;
                                            objArr422222[0] = e.getMessage();
                                            w.b("MicroMsg.JsApiReportKeyValue", "AppBrandComponent parse report value failed : %s", objArr422222);
                                            i28++;
                                            i27 = i18;
                                            str5 = str2;
                                            optJSONArray = jSONArray;
                                            length = i17;
                                            str4 = str;
                                            optInt = i16;
                                        }
                                    } catch (Exception e38) {
                                        e = e38;
                                        i19 = 1;
                                    }
                                }
                                i18 = 0;
                            }
                        } else {
                            str2 = str5;
                            jSONArray = optJSONArray;
                            i17 = length;
                            str3 = optString;
                        }
                        join = str3;
                        dVar = (com.tencent.luggage.wxa.zj.d) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.d.class);
                        if (dVar == null) {
                        }
                    } else {
                        str = str4;
                        str2 = str5;
                        jSONArray = optJSONArray;
                        i16 = optInt;
                        i17 = length;
                        i18 = i27;
                    }
                } catch (Exception e39) {
                    e = e39;
                    str = str4;
                    str2 = str5;
                    jSONArray = optJSONArray;
                    i16 = optInt;
                    i17 = length;
                }
                i28++;
                i27 = i18;
                str5 = str2;
                optJSONArray = jSONArray;
                length = i17;
                str4 = str;
                optInt = i16;
            }
            iVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
        }
    }
}
