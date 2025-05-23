package com.tencent.kuikly.core.nvi.serialization.json;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ark.ark;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \"2\u00020\u0001:\u0001\u000fB\u001f\b\u0000\u0012\u0014\u0010C\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010$\u00a2\u0006\u0004\bD\u0010BB\t\b\u0016\u00a2\u0006\u0004\bD\u0010EB\u0011\b\u0016\u0012\u0006\u0010F\u001a\u00020\u0004\u00a2\u0006\u0004\bD\u0010GB\"\b\u0016\u0012\u0017\u0010;\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020(09\u00a2\u0006\u0002\b:\u00a2\u0006\u0004\bD\u0010HJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\t\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002J\u0016\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\nJ\u0016\u0010\r\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\fJ\u0018\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0006J\u000e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\fJ\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0002J\u000e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\nJ\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u001fJ\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040!J\b\u0010#\u001a\u00020\u0004H\u0016J\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010$J\u000e\u0010)\u001a\u00020(2\u0006\u0010'\u001a\u00020&J\u001f\u0010-\u001a\u00020(\"\b\b\u0000\u0010+*\u00020*2\u0006\u0010,\u001a\u00028\u0000\u00a2\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020(*\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0086\u0004J!\u00102\u001a\u00020(\"\u0004\b\u0000\u0010+*\u00020\u00042\f\u00101\u001a\b\u0012\u0004\u0012\u00028\u000000H\u0086\u0004J'\u00105\u001a\u00020(\"\u0004\b\u0000\u0010+*\u00020\u00042\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u000003H\u0086\u0004J&\u00107\u001a\u00020(\"\b\b\u0000\u0010+*\u000206*\u00020\u00042\u0006\u0010\u0007\u001a\u00028\u0000H\u0086\u0004\u00a2\u0006\u0004\b7\u00108J&\u0010<\u001a\u00020(*\u00020\u00042\u0017\u0010;\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020(09\u00a2\u0006\u0002\b:H\u0086\u0004J&\u0010=\u001a\u00020(*\u00020\u00042\u0017\u0010;\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020(09\u00a2\u0006\u0002\b:H\u0086\u0004R0\u0010C\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010$8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B\u00a8\u0006I"}, d2 = {"Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "", "", "d", "", "name", "", "value", "w", "t", "", "u", "", ReportConstant.COSTREPORT_PREFIX, "v", "a", "e", "f", AdMetricTag.FALLBACK, "g", h.F, "i", "j", "k", DomainData.DOMAIN_NAME, "o", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/kuikly/core/nvi/serialization/json/b;", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "c", "", "b", "toString", "", HippyTKDListViewAdapter.X, "Lcom/tencent/kuikly/core/nvi/serialization/json/JSONStringer;", "stringer", "", "E", "Lb01/a;", "T", "target", "r", "(Lb01/a;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "list", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "map", "B", "Lb01/b;", "y", "(Ljava/lang/String;Lb01/b;)V", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "init", BdhLogUtil.LogTag.Tag_Conn, "D", "Ljava/util/Map;", "getNameValuePairs$core_release", "()Ljava/util/Map;", "setNameValuePairs$core_release", "(Ljava/util/Map;)V", "nameValuePairs", "<init>", "()V", ark.ARKMETADATA_JSON, "(Ljava/lang/String;)V", "(Lkotlin/jvm/functions/Function1;)V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Map<String, Object> nameValuePairs;

    public e(Map<String, Object> nameValuePairs) {
        Intrinsics.checkNotNullParameter(nameValuePairs, "nameValuePairs");
        this.nameValuePairs = nameValuePairs;
    }

    public final <T> void A(String str, List<? extends T> list) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(list, "list");
        v(str, b01.c.a(list));
    }

    public final <T> void B(String str, Map<String, ? extends T> map) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(map, "map");
        v(str, b01.c.b(map));
    }

    public final void C(String str, Function1<? super e, Unit> init) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        e eVar = new e();
        init.invoke(eVar);
        v(str, eVar);
    }

    public final void D(String str, Function1<? super b, Unit> init) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        b bVar = new b();
        init.invoke(bVar);
        v(str, bVar);
    }

    public final void E(JSONStringer stringer) throws JSONException {
        Intrinsics.checkNotNullParameter(stringer, "stringer");
        stringer.l();
        for (Map.Entry<String, Object> entry : this.nameValuePairs.entrySet()) {
            String key = entry.getKey();
            stringer.f(key).n(entry.getValue());
        }
        stringer.e();
    }

    public final boolean a(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.nameValuePairs.containsKey(name);
    }

    public final Set<String> b() {
        return this.nameValuePairs.keySet();
    }

    public final Iterator<String> c() {
        return this.nameValuePairs.keySet().iterator();
    }

    public final int d() {
        return this.nameValuePairs.size();
    }

    public final Object e(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.nameValuePairs.get(name);
    }

    public final boolean f(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return g(name, false);
    }

    public final boolean g(String name, boolean fallback) {
        Intrinsics.checkNotNullParameter(name, "name");
        Boolean c16 = a.f117418a.c(e(name));
        return c16 != null ? c16.booleanValue() : fallback;
    }

    public final double h(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return i(name, 0.0d);
    }

    public final double i(String name, double fallback) {
        Intrinsics.checkNotNullParameter(name, "name");
        Double d16 = a.f117418a.d(e(name));
        return d16 != null ? d16.doubleValue() : fallback;
    }

    public final int j(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return k(name, 0);
    }

    public final int k(String name, int fallback) {
        Intrinsics.checkNotNullParameter(name, "name");
        Integer e16 = a.f117418a.e(e(name));
        return e16 != null ? e16.intValue() : fallback;
    }

    public final b l(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Object e16 = e(name);
        if (e16 instanceof b) {
            return (b) e16;
        }
        if (e16 instanceof String) {
            try {
                return new b((String) e16);
            } catch (JSONException unused) {
                KLog.INSTANCE.i("JSONObject", e16 + " can not convert to json");
            }
        }
        return null;
    }

    public final e m(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Object e16 = e(name);
        if (e16 instanceof e) {
            return (e) e16;
        }
        if (e16 instanceof String) {
            try {
                return new e((String) e16);
            } catch (JSONException unused) {
                KLog.INSTANCE.i("JSONObject", e16 + " can not convert to json");
            }
        }
        return null;
    }

    public final long n(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return o(name, 0L);
    }

    public final long o(String name, long fallback) {
        Intrinsics.checkNotNullParameter(name, "name");
        Long f16 = a.f117418a.f(e(name));
        return f16 != null ? f16.longValue() : fallback;
    }

    public final String p(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return q(name, "");
    }

    public final String q(String name, String fallback) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(fallback, "fallback");
        String g16 = a.f117418a.g(e(name));
        return g16 == null ? fallback : g16;
    }

    public final <T extends b01.a> void r(T target) {
        Intrinsics.checkNotNullParameter(target, "target");
        target.deserialization(this);
    }

    public final e s(String name, double value) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.nameValuePairs.put(name, Double.valueOf(value));
        return this;
    }

    public final e t(String name, int value) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.nameValuePairs.put(name, Integer.valueOf(value));
        return this;
    }

    public String toString() {
        try {
            return c.f117421a.e(this);
        } catch (JSONException unused) {
            return "{}";
        }
    }

    public final e u(String name, long value) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.nameValuePairs.put(name, Long.valueOf(value));
        return this;
    }

    public final e v(String name, Object value) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.nameValuePairs.put(name, value);
        return this;
    }

    public final e w(String name, boolean value) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.nameValuePairs.put(name, Boolean.valueOf(value));
        return this;
    }

    public final Map<String, Object> x() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> c16 = c();
        while (c16.hasNext()) {
            String next = c16.next();
            Object e16 = e(next);
            if (e16 instanceof Integer) {
                linkedHashMap.put(next, e16);
            } else if (e16 instanceof Long) {
                linkedHashMap.put(next, e16);
            } else if (e16 instanceof Double) {
                linkedHashMap.put(next, e16);
            } else if (e16 instanceof Float) {
                linkedHashMap.put(next, e16);
            } else if (e16 instanceof String) {
                linkedHashMap.put(next, e16);
            } else if (e16 instanceof Boolean) {
                linkedHashMap.put(next, e16);
            } else if (e16 instanceof e) {
                linkedHashMap.put(next, ((e) e16).x());
            } else if (e16 instanceof b) {
                linkedHashMap.put(next, ((b) e16).w());
            }
        }
        return linkedHashMap;
    }

    public final <T extends b01.b> void y(String str, T value) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        v(str, value.serialization());
    }

    public final void z(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        v(str, obj);
    }

    public e() {
        this((Map<String, Object>) c.f117421a.b());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public e(String json) throws JSONException {
        this(((e) r3).nameValuePairs);
        Intrinsics.checkNotNullParameter(json, "json");
        Object c16 = c.f117421a.c(json);
        if (c16 instanceof e) {
            Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
            return;
        }
        throw a.f117418a.h(c16, "JSONObject");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(Function1<? super e, Unit> init) throws JSONException {
        this();
        Intrinsics.checkNotNullParameter(init, "init");
        init.invoke(this);
    }
}
