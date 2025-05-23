package com.tencent.qmethod.monitor.report.base.reporter.data;

import com.tencent.qmethod.monitor.base.util.e;
import java.nio.charset.Charset;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import nr3.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010 \u001a\u00020\u001b\u0012\b\b\u0002\u0010&\u001a\u00020\u0007\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\t\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0018\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0010\u0010\fR\u001b\u0010\u001a\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u0019\u0010\fR\"\u0010 \u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b\u0016\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010&\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b!\u0010#\"\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/qmethod/monitor/report/base/reporter/data/ReportData;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "j", "(Ljava/lang/String;)V", "uin", "b", "I", "()I", "g", "(I)V", "dbId", "c", "Lkotlin/Lazy;", "md5Salt", "d", "paramsMD5", "Lorg/json/JSONObject;", "Lorg/json/JSONObject;", "()Lorg/json/JSONObject;", h.F, "(Lorg/json/JSONObject;)V", "params", "f", "Z", "()Z", "i", "(Z)V", "isRealTime", "<init>", "(Lorg/json/JSONObject;Z)V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final /* data */ class ReportData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String uin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int dbId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy md5Salt;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy paramsMD5;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private JSONObject params;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isRealTime;

    public ReportData() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: a, reason: from getter */
    public final int getDbId() {
        return this.dbId;
    }

    @NotNull
    public final String b() {
        return (String) this.md5Salt.getValue();
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final JSONObject getParams() {
        return this.params;
    }

    @NotNull
    public final String d() {
        return (String) this.paramsMD5.getValue();
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ReportData) {
                ReportData reportData = (ReportData) other;
                if (!Intrinsics.areEqual(this.params, reportData.params) || this.isRealTime != reportData.isRealTime) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getIsRealTime() {
        return this.isRealTime;
    }

    public final void g(int i3) {
        this.dbId = i3;
    }

    public final void h(@NotNull JSONObject jSONObject) {
        Intrinsics.checkParameterIsNotNull(jSONObject, "<set-?>");
        this.params = jSONObject;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        JSONObject jSONObject = this.params;
        if (jSONObject != null) {
            i3 = jSONObject.hashCode();
        } else {
            i3 = 0;
        }
        int i16 = i3 * 31;
        boolean z16 = this.isRealTime;
        int i17 = z16;
        if (z16 != 0) {
            i17 = 1;
        }
        return i16 + i17;
    }

    public final void i(boolean z16) {
        this.isRealTime = z16;
    }

    public final void j(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.uin = str;
    }

    @NotNull
    public String toString() {
        return "ReportData(params=" + this.params + ", uin='" + this.uin + "')";
    }

    public ReportData(@NotNull JSONObject params, boolean z16) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkParameterIsNotNull(params, "params");
        this.params = params;
        this.isRealTime = z16;
        this.uin = a.f421180b.uin;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.qmethod.monitor.report.base.reporter.data.ReportData$md5Salt$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return e.f343535a.c(8);
            }
        });
        this.md5Salt = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.qmethod.monitor.report.base.reporter.data.ReportData$paramsMD5$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                e eVar = e.f343535a;
                String str = ReportData.this.getParams().toString() + ReportData.this.b();
                Charset charset = Charsets.UTF_8;
                if (str != null) {
                    byte[] bytes = str.getBytes(charset);
                    Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
                    return eVar.b(bytes);
                }
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
        });
        this.paramsMD5 = lazy2;
    }

    public /* synthetic */ ReportData(JSONObject jSONObject, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new JSONObject() : jSONObject, (i3 & 2) != 0 ? true : z16);
    }
}
