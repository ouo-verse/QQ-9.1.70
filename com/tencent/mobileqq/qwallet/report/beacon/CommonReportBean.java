package com.tencent.mobileqq.qwallet.report.beacon;

import com.tencent.mobileqq.qwallet.report.ReportField;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\fR\u001a\u0010\u001b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u001d\u0010\f\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/qwallet/report/beacon/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getModule", "()Ljava/lang/String;", "module", "b", "getAction", "action", "c", "getStep", "step", "d", "getParams", "params", "e", "I", "getResult", "()I", "result", "f", "getFailReason", "failReason", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qwallet.report.beacon.a, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class CommonReportBean {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @ReportField(name = "module")
    @Nullable
    private final String module;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @ReportField(name = "action")
    @Nullable
    private final String action;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @ReportField(name = "step")
    @Nullable
    private final String step;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @ReportField(name = "params")
    @Nullable
    private final String params;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @ReportField(name = "result")
    private final int result;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @ReportField(name = "failReason")
    @Nullable
    private final String failReason;

    public CommonReportBean(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, int i3, @Nullable String str5) {
        this.module = str;
        this.action = str2;
        this.step = str3;
        this.params = str4;
        this.result = i3;
        this.failReason = str5;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommonReportBean)) {
            return false;
        }
        CommonReportBean commonReportBean = (CommonReportBean) other;
        if (Intrinsics.areEqual(this.module, commonReportBean.module) && Intrinsics.areEqual(this.action, commonReportBean.action) && Intrinsics.areEqual(this.step, commonReportBean.step) && Intrinsics.areEqual(this.params, commonReportBean.params) && this.result == commonReportBean.result && Intrinsics.areEqual(this.failReason, commonReportBean.failReason)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        String str = this.module;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        String str2 = this.action;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str3 = this.step;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        String str4 = this.params;
        if (str4 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str4.hashCode();
        }
        int i19 = (((i18 + hashCode4) * 31) + this.result) * 31;
        String str5 = this.failReason;
        if (str5 != null) {
            i3 = str5.hashCode();
        }
        return i19 + i3;
    }

    @NotNull
    public String toString() {
        return "CommonReportBean(module=" + this.module + ", action=" + this.action + ", step=" + this.step + ", params=" + this.params + ", result=" + this.result + ", failReason=" + this.failReason + ')';
    }
}
