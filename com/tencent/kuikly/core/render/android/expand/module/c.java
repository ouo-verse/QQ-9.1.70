package com.tencent.kuikly.core.render.android.expand.module;

import com.tencent.kuikly.core.render.android.expand.module.t;
import d01.w;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\u000b\u001a\u0004\u0018\u00010\n*\u00020\u0002H\u0002JI\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\f\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022+\u0010\u0014\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\rj\u0004\u0018\u0001`\u0013H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/module/c;", "Li01/e;", "", "a", "params", "d", "g", "c", "", "i", "Lorg/json/JSONObject;", "j", "method", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class c extends i01.e {
    private final String a() {
        return String.valueOf(System.currentTimeMillis());
    }

    private final String c(String params) {
        JSONObject j3;
        if (params != null && (j3 = j(params)) != null) {
            return new SimpleDateFormat(j3.optString("format"), Locale.CHINA).format(new Date(j3.optLong("timeMillis")));
        }
        w.f392617a.b("KRCalendarModule", "format: error, the params is null");
        return null;
    }

    private final String d(String params) {
        JSONObject j3;
        Long longOrNull;
        long j16;
        List<t> c16;
        if (params != null && (j3 = j(params)) != null) {
            String optString = j3.optString("timeMillis");
            Intrinsics.checkNotNullExpressionValue(optString, "paramsJSObj.optString(PARAM_TIME_MILLIS)");
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(optString);
            if (longOrNull != null) {
                j16 = longOrNull.longValue();
            } else {
                j16 = 0;
            }
            String optString2 = j3.optString("operations");
            Intrinsics.checkNotNullExpressionValue(optString2, "paramsJSObj.optString(PARAM_OPERATIONS)");
            c16 = d.c(optString2);
            int optInt = j3.optInt("field");
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j16);
            for (t tVar : c16) {
                if (tVar instanceof t.a) {
                    calendar.add(tVar.field, tVar.value);
                } else if (tVar instanceof t.b) {
                    calendar.set(tVar.field, tVar.value);
                }
            }
            return String.valueOf(calendar.get(optInt));
        }
        w.f392617a.b("KRCalendarModule", "getField: error, the params is null");
        return null;
    }

    private final String g(String params) {
        JSONObject j3;
        Long longOrNull;
        long j16;
        List<t> c16;
        if (params != null && (j3 = j(params)) != null) {
            String optString = j3.optString("timeMillis");
            Intrinsics.checkNotNullExpressionValue(optString, "paramsJSObj.optString(PARAM_TIME_MILLIS)");
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(optString);
            if (longOrNull != null) {
                j16 = longOrNull.longValue();
            } else {
                j16 = 0;
            }
            String optString2 = j3.optString("operations");
            Intrinsics.checkNotNullExpressionValue(optString2, "paramsJSObj.optString(PARAM_OPERATIONS)");
            c16 = d.c(optString2);
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j16);
            for (t tVar : c16) {
                if (tVar instanceof t.a) {
                    calendar.add(tVar.field, tVar.value);
                } else if (tVar instanceof t.b) {
                    calendar.set(tVar.field, tVar.value);
                }
            }
            Intrinsics.checkNotNullExpressionValue(calendar, "calendar");
            return String.valueOf(calendar.getTimeInMillis());
        }
        w.f392617a.b("KRCalendarModule", "getTimeInMillis: error, the params is null");
        return null;
    }

    private final long i(String params) {
        JSONObject j3;
        if (params != null && (j3 = j(params)) != null) {
            try {
                Date parse = new SimpleDateFormat(j3.optString("format"), Locale.CHINA).parse(j3.optString("formattedTime"));
                if (parse == null) {
                    return 0L;
                }
                return parse.getTime();
            } catch (ParseException e16) {
                w.f392617a.b("KRCalendarModule", "parseFormat: error, e=" + e16.getMessage());
                return 0L;
            }
        }
        w.f392617a.b("KRCalendarModule", "parseFormat: error, the params is null");
        return 0L;
    }

    private final JSONObject j(String str) {
        try {
            return new JSONObject(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        switch (method.hashCode()) {
            case -2144155231:
                if (method.equals("method_parse_format")) {
                    return String.valueOf(i(params));
                }
                return super.call(method, params, callback);
            case 230546169:
                if (method.equals("method_cur_timestamp")) {
                    return a();
                }
                return super.call(method, params, callback);
            case 648093939:
                if (method.equals("method_get_field")) {
                    return d(params);
                }
                return super.call(method, params, callback);
            case 1653915605:
                if (method.equals("method_get_time_in_millis")) {
                    return g(params);
                }
                return super.call(method, params, callback);
            case 2143851797:
                if (method.equals("method_format")) {
                    return c(params);
                }
                return super.call(method, params, callback);
            default:
                return super.call(method, params, callback);
        }
    }
}
