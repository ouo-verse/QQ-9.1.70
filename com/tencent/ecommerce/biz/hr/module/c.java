package com.tencent.ecommerce.biz.hr.module;

import com.tencent.ecommerce.biz.hr.module.k;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\u000b\u001a\u0004\u0018\u00010\n*\u00020\u0002H\u0002JI\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\f\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022+\u0010\u0014\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\rj\u0004\u0018\u0001`\u0013H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/module/c;", "Li01/e;", "", "a", "params", "d", "g", "c", "", "i", "Lorg/json/JSONObject;", "j", "method", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class c extends i01.e {
    private final String a() {
        return String.valueOf(System.currentTimeMillis());
    }

    private final String c(String params) {
        JSONObject j3;
        if (params != null && (j3 = j(params)) != null) {
            return new SimpleDateFormat(j3.optString("format"), Locale.CHINA).format(new Date(j3.optLong("timeMillis")));
        }
        cg0.a.a("ECHRCalendarModule", "format", "error, the params is null");
        return null;
    }

    private final long i(String params) {
        JSONObject j3;
        if (params != null && (j3 = j(params)) != null) {
            try {
                Date parse = new SimpleDateFormat(j3.optString("format"), Locale.CHINA).parse(j3.optString("formattedTime"));
                if (parse != null) {
                    return parse.getTime();
                }
                return 0L;
            } catch (ParseException e16) {
                cg0.a.a("ECHRCalendarModule", "parseFormat", "error, e=" + e16.getMessage());
                return 0L;
            }
        }
        cg0.a.a("ECHRCalendarModule", "parseFormat", "error, the params is null");
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
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0004. Please report as an issue. */
    @Override // i01.e, i01.a
    public Object call(String method, String params, Function1<Object, Unit> callback) {
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

    private final String d(String params) {
        JSONObject j3;
        Long longOrNull;
        List<k> c16;
        if (params != null && (j3 = j(params)) != null) {
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(j3.optString("timeMillis"));
            long longValue = longOrNull != null ? longOrNull.longValue() : 0L;
            c16 = d.c(j3.optString("operations"));
            int optInt = j3.optInt("field");
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(longValue);
            for (k kVar : c16) {
                if (kVar instanceof k.a) {
                    calendar.add(kVar.field, kVar.value);
                } else if (kVar instanceof k.b) {
                    calendar.set(kVar.field, kVar.value);
                }
            }
            return String.valueOf(calendar.get(optInt));
        }
        cg0.a.a("ECHRCalendarModule", "getField", "error, the params is null");
        return null;
    }

    private final String g(String params) {
        JSONObject j3;
        Long longOrNull;
        List<k> c16;
        if (params != null && (j3 = j(params)) != null) {
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(j3.optString("timeMillis"));
            long longValue = longOrNull != null ? longOrNull.longValue() : 0L;
            c16 = d.c(j3.optString("operations"));
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(longValue);
            for (k kVar : c16) {
                if (kVar instanceof k.a) {
                    calendar.add(kVar.field, kVar.value);
                } else if (kVar instanceof k.b) {
                    calendar.set(kVar.field, kVar.value);
                }
            }
            return String.valueOf(calendar.getTimeInMillis());
        }
        cg0.a.a("ECHRCalendarModule", "getTimeInMillis", "error, the params is null");
        return null;
    }
}
