package com.tencent.qmethod.monitor.config.bean;

import android.util.Log;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import com.tencent.mobileqq.kandian.base.report.ReadInJoyMMapKvStorage;
import com.tencent.qmethod.pandoraex.core.o;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0010\b\u0086\b\u0018\u0000 \r2\u00020\u0001:\u0001\u000bB#\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0017\u001a\u00020\u0010\u0012\b\b\u0001\u0010\u001d\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001d\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/qmethod/monitor/config/bean/e;", "", "Lorg/json/JSONObject;", "c", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "scene", "", "b", "D", "e", "()D", h.F, "(D)V", "rate", "I", "d", "()I", "g", "(I)V", "maxReport", "<init>", "(Ljava/lang/String;DI)V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final /* data */ class e {

    /* renamed from: d, reason: collision with root package name */
    private static final Map<String, Double> f343580d;

    /* renamed from: e, reason: collision with root package name */
    private static final Map<String, Integer> f343581e;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String scene;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private double rate;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int maxReport;

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J'\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0000\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qmethod/monitor/config/bean/e$a;", "", "Lorg/json/JSONObject;", "jsonObject", "Lcom/tencent/qmethod/monitor/config/bean/e;", "a", "", "scene", "", "rate", "", "maxReport", "b", "(Ljava/lang/String;DI)Lcom/tencent/qmethod/monitor/config/bean/e;", "", "NOT_SET", "J", "TAG", "Ljava/lang/String;", "", "minLimitMaxReport", "Ljava/util/Map;", "minLimitRate", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.qmethod.monitor.config.bean.e$a, reason: from kotlin metadata */
    /* loaded from: classes22.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final e a(@NotNull JSONObject jsonObject) {
            Intrinsics.checkParameterIsNotNull(jsonObject, "jsonObject");
            String scene = jsonObject.optString("scene");
            double d16 = -1;
            double optDouble = jsonObject.optDouble("rate", d16);
            int optInt = jsonObject.optInt("maxReport", -1);
            if (d16 != optDouble && -1 != optInt) {
                Intrinsics.checkExpressionValueIsNotNull(scene, "scene");
                return new e(scene, optDouble, optInt);
            }
            o.c("SceneSampleRate", "Convert SceneSampleRate Fail, json=" + jsonObject);
            Intrinsics.checkExpressionValueIsNotNull(scene, "scene");
            return new e(scene, d16, -1);
        }

        @NotNull
        public final e b(@NotNull String scene, double rate, int maxReport) {
            double d16;
            int i3;
            Intrinsics.checkParameterIsNotNull(scene, "scene");
            Double d17 = (Double) e.f343580d.get(scene);
            double d18 = 0.0d;
            if (d17 != null) {
                d16 = d17.doubleValue();
            } else {
                d16 = 0.0d;
            }
            if (rate < d16) {
                Double d19 = (Double) e.f343580d.get(scene);
                if (d19 != null) {
                    d18 = d19.doubleValue();
                }
            } else {
                d18 = rate;
            }
            Integer num = (Integer) e.f343581e.get(scene);
            int i16 = 0;
            if (num != null) {
                i3 = num.intValue();
            } else {
                i3 = 0;
            }
            if (maxReport < i3) {
                Integer num2 = (Integer) e.f343581e.get(scene);
                if (num2 != null) {
                    i16 = num2.intValue();
                }
            } else {
                i16 = maxReport;
            }
            if (Intrinsics.areEqual(scene, "secondary_sample") && rate != 0.8d && rate != 0.5d && rate != 0.2d) {
                d18 = 0.5d;
            }
            if (d18 != rate || i16 != maxReport) {
                Log.e("SceneSampleRate", "\u8bbe\u7f6e\u91c7\u6837\u4fe1\u606f\u4f4e\u4e8e\u6700\u4f4e\u503c,\u5df2\u81ea\u52a8\u4fee\u6b63: scene=" + scene + ", rate=" + d18 + ", maxReport = " + i16);
            }
            return new e(scene, d18, i16);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Map<String, Double> mapOf;
        Map<String, Integer> mapOf2;
        Double valueOf = Double.valueOf(0.05d);
        Double valueOf2 = Double.valueOf(0.1d);
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(ReadInJoyMMapKvStorage.NAME_DEFAULT, Double.valueOf(1.0E-4d)), TuplesKt.to("before", Double.valueOf(0.25d)), TuplesKt.to("illegal_scene", valueOf), TuplesKt.to("back", valueOf2), TuplesKt.to("high_freq", valueOf2), TuplesKt.to("silence", valueOf2), TuplesKt.to("deny_retry", valueOf), TuplesKt.to("mod_no_perm", valueOf2));
        f343580d = mapOf;
        mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to(ReadInJoyMMapKvStorage.NAME_DEFAULT, 35), TuplesKt.to("before", 10), TuplesKt.to("illegal_scene", 10), TuplesKt.to("back", 15), TuplesKt.to("high_freq", 15), TuplesKt.to("silence", 15), TuplesKt.to("deny_retry", 10), TuplesKt.to("mod_no_perm", 15));
        f343581e = mapOf2;
    }

    public e(@NotNull String scene, @FloatRange(from = -1.0d, to = 1.0d) double d16, @IntRange(from = -1) int i3) {
        Intrinsics.checkParameterIsNotNull(scene, "scene");
        this.scene = scene;
        this.rate = d16;
        this.maxReport = i3;
    }

    @NotNull
    public final JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("scene", this.scene);
        jSONObject.put("rate", this.rate);
        jSONObject.put("maxReport", this.maxReport);
        return jSONObject;
    }

    /* renamed from: d, reason: from getter */
    public final int getMaxReport() {
        return this.maxReport;
    }

    /* renamed from: e, reason: from getter */
    public final double getRate() {
        return this.rate;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof e) {
                e eVar = (e) other;
                if (!Intrinsics.areEqual(this.scene, eVar.scene) || Double.compare(this.rate, eVar.rate) != 0 || this.maxReport != eVar.maxReport) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getScene() {
        return this.scene;
    }

    public final void g(int i3) {
        this.maxReport = i3;
    }

    public final void h(double d16) {
        this.rate = d16;
    }

    public int hashCode() {
        int i3;
        String str = this.scene;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        return (((i3 * 31) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.rate)) * 31) + this.maxReport;
    }

    @NotNull
    public String toString() {
        String jSONObject = c().toString(4);
        Intrinsics.checkExpressionValueIsNotNull(jSONObject, "getJSONObject().toString(4)");
        return jSONObject;
    }
}
