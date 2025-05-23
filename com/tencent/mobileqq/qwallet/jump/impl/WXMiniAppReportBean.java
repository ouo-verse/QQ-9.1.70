package com.tencent.mobileqq.qwallet.jump.impl;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.qwallet.report.ReportField;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qwallet/jump/impl/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getSchema", "()Ljava/lang/String;", QZoneDTLoginReporter.SCHEMA, "b", "getWxMiniAppId", "wxMiniAppId", "c", "isInWhiteList", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qwallet.jump.impl.c, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class WXMiniAppReportBean {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @ReportField(name = "url")
    @Nullable
    private final String schema;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @ReportField(name = AudienceReportConst.USER_NAME)
    @Nullable
    private final String wxMiniAppId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @ReportField(name = "is_in_whitelist")
    @Nullable
    private final String isInWhiteList;

    public WXMiniAppReportBean(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.schema = str;
        this.wxMiniAppId = str2;
        this.isInWhiteList = str3;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WXMiniAppReportBean)) {
            return false;
        }
        WXMiniAppReportBean wXMiniAppReportBean = (WXMiniAppReportBean) other;
        if (Intrinsics.areEqual(this.schema, wXMiniAppReportBean.schema) && Intrinsics.areEqual(this.wxMiniAppId, wXMiniAppReportBean.wxMiniAppId) && Intrinsics.areEqual(this.isInWhiteList, wXMiniAppReportBean.isInWhiteList)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        String str = this.schema;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        String str2 = this.wxMiniAppId;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str3 = this.isInWhiteList;
        if (str3 != null) {
            i3 = str3.hashCode();
        }
        return i17 + i3;
    }

    @NotNull
    public String toString() {
        return "WXMiniAppReportBean(schema=" + this.schema + ", wxMiniAppId=" + this.wxMiniAppId + ", isInWhiteList=" + this.isInWhiteList + ")";
    }
}
