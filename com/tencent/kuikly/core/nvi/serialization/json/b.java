package com.tencent.kuikly.core.nvi.serialization.json;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ark.ark;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u000e\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010$\u00a2\u0006\u0004\b4\u00102B\t\b\u0016\u00a2\u0006\u0004\b4\u00105B\u0011\b\u0016\u0012\u0006\u00106\u001a\u00020\u001e\u00a2\u0006\u0004\b4\u00107B\"\b\u0016\u0012\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000e0\f\u00a2\u0006\u0002\b\u000f\u00a2\u0006\u0004\b4\u00108J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\nJ\u001f\u0010\u0011\u001a\u00020\u000e2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f\u00a2\u0006\u0002\b\u000fJ\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0013\u001a\u00020\u0002J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0002J\u0016\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0002J\u0016\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0007J\u000e\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002J\u0016\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002J\u000e\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0002J\u0016\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\nJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0013\u001a\u00020\u0002J\u001a\u0010 \u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0013\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010!\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0013\u001a\u00020\u0002J\u0010\u0010\"\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0013\u001a\u00020\u0002J\b\u0010#\u001a\u00020\u001eH\u0016J\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00010$J\u000e\u0010(\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020&J\u0013\u0010*\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010+\u001a\u00020\u0002H\u0016J&\u0010,\u001a\u00020\u000e*\u00020\u00002\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f\u00a2\u0006\u0002\b\u000fH\u0086\u0004J\u0015\u0010-\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0001H\u0086\u0004R*\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010$8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102\u00a8\u00069"}, d2 = {"Lcom/tencent/kuikly/core/nvi/serialization/json/b;", "", "", "c", "", "value", "u", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "", ReportConstant.COSTREPORT_PREFIX, "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "", "Lkotlin/ExtensionFunctionType;", "init", "v", "t", "index", "d", "e", AdMetricTag.FALLBACK, "f", "g", h.F, "i", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "", "o", "p", "k", "l", "toString", "", "w", "Lcom/tencent/kuikly/core/nvi/serialization/json/JSONStringer;", "stringer", HippyTKDListViewAdapter.X, "other", "equals", "hashCode", "b", "a", "Ljava/util/List;", "getValues$core_release", "()Ljava/util/List;", "setValues$core_release", "(Ljava/util/List;)V", "values", "<init>", "()V", ark.ARKMETADATA_JSON, "(Ljava/lang/String;)V", "(Lkotlin/jvm/functions/Function1;)V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private List<Object> values;

    public b(List<Object> values) {
        Intrinsics.checkNotNullParameter(values, "values");
        this.values = values;
    }

    public final void a(b bVar, Object value) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        bVar.t(value);
    }

    public final void b(b bVar, Function1<? super e, Unit> init) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        e eVar = new e();
        init.invoke(eVar);
        bVar.t(eVar);
    }

    public final int c() {
        return this.values.size();
    }

    public boolean equals(Object other) {
        return (other instanceof b) && Intrinsics.areEqual(((b) other).values, this.values);
    }

    public final boolean f(int index, boolean fallback) {
        Boolean c16 = a.f117418a.c(d(index));
        return c16 != null ? c16.booleanValue() : fallback;
    }

    public final double h(int index, double fallback) {
        Double d16 = a.f117418a.d(d(index));
        return d16 != null ? d16.doubleValue() : fallback;
    }

    public int hashCode() {
        return this.values.hashCode();
    }

    public final int j(int index, int fallback) {
        Integer e16 = a.f117418a.e(d(index));
        return e16 != null ? e16.intValue() : fallback;
    }

    public final b k(int index) {
        Object d16 = d(index);
        if (d16 instanceof b) {
            return (b) d16;
        }
        return null;
    }

    public final e l(int index) {
        Object d16 = d(index);
        if (d16 instanceof e) {
            return (e) d16;
        }
        return null;
    }

    public final long n(int index, long fallback) {
        Long f16 = a.f117418a.f(d(index));
        return f16 != null ? f16.longValue() : fallback;
    }

    public final String o(int index) {
        return p(index, "");
    }

    public final String p(int index, String fallback) {
        String g16 = a.f117418a.g(d(index));
        return g16 == null ? fallback : g16;
    }

    public final b q(double value) {
        this.values.add(Double.valueOf(value));
        return this;
    }

    public final b r(int value) {
        this.values.add(Integer.valueOf(value));
        return this;
    }

    public final b s(long value) {
        this.values.add(Long.valueOf(value));
        return this;
    }

    public final b t(Object value) {
        this.values.add(value);
        return this;
    }

    public String toString() {
        try {
            return c.f117421a.d(this);
        } catch (JSONException unused) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
    }

    public final b u(boolean value) {
        this.values.add(Boolean.valueOf(value));
        return this;
    }

    public final void v(Function1<? super e, Unit> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        this.values.add(new e(init));
    }

    public final List<Object> w() {
        ArrayList arrayList = new ArrayList();
        int c16 = c();
        for (int i3 = 0; i3 < c16; i3++) {
            Object d16 = d(i3);
            if (d16 instanceof Integer) {
                arrayList.add(d16);
            } else if (d16 instanceof Long) {
                arrayList.add(d16);
            } else if (d16 instanceof Float) {
                arrayList.add(d16);
            } else if (d16 instanceof Double) {
                arrayList.add(d16);
            } else if (d16 instanceof String) {
                arrayList.add(d16);
            } else if (d16 instanceof Boolean) {
                arrayList.add(d16);
            } else if (d16 instanceof e) {
                arrayList.add(((e) d16).x());
            } else if (d16 instanceof b) {
                arrayList.add(((b) d16).w());
            }
        }
        return arrayList;
    }

    public final void x(JSONStringer stringer) throws JSONException {
        Intrinsics.checkNotNullParameter(stringer, "stringer");
        stringer.k();
        for (Object obj : this.values) {
            if (obj == null) {
                stringer.n(null);
            } else {
                stringer.n(obj);
            }
        }
        stringer.d();
    }

    public final boolean e(int index) {
        return f(index, false);
    }

    public final int i(int index) {
        return j(index, 0);
    }

    public b() {
        this((List<Object>) c.f117421a.a());
    }

    public final Object d(int index) {
        if (index < 0 || index >= this.values.size()) {
            return null;
        }
        return this.values.get(index);
    }

    public final double g(int index) {
        return h(index, Double.NaN);
    }

    public final long m(int index) {
        return n(index, 0L);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b(String json) throws JSONException {
        this(((b) r3).values);
        Intrinsics.checkNotNullParameter(json, "json");
        Object c16 = c.f117421a.c(json);
        if (c16 instanceof b) {
            Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONArray");
            return;
        }
        throw a.f117418a.h(c16, "JSONArray");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(Function1<? super b, Unit> init) throws JSONException {
        this();
        Intrinsics.checkNotNullParameter(init, "init");
        init.invoke(this);
    }
}
