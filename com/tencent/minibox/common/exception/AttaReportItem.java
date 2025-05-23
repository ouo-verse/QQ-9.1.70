package com.tencent.minibox.common.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0015\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001b\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\n\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0019\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0016\u001a\u0004\b\u0013\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/minibox/common/exception/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/minibox/common/exception/AttaEventType;", "a", "Lcom/tencent/minibox/common/exception/AttaEventType;", "d", "()Lcom/tencent/minibox/common/exception/AttaEventType;", "eventType", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "appId", "c", "appVersion", "", "J", "e", "()J", "launchTime", "eventTime", "Lcom/tencent/minibox/common/exception/AttaUserAdvice;", "f", "Lcom/tencent/minibox/common/exception/AttaUserAdvice;", "()Lcom/tencent/minibox/common/exception/AttaUserAdvice;", "userAdvice", "<init>", "(Lcom/tencent/minibox/common/exception/AttaEventType;Ljava/lang/String;Ljava/lang/String;JJLcom/tencent/minibox/common/exception/AttaUserAdvice;)V", "MiniBoxCommon_release"}, k = 1, mv = {1, 4, 0})
/* renamed from: com.tencent.minibox.common.exception.c, reason: from toString */
/* loaded from: classes9.dex */
public final /* data */ class AttaReportItem {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final AttaEventType eventType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String appId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String appVersion;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final long launchTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final long eventTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final AttaUserAdvice userAdvice;

    public AttaReportItem(@NotNull AttaEventType eventType, @NotNull String appId, @NotNull String appVersion, long j3, long j16, @NotNull AttaUserAdvice userAdvice) {
        Intrinsics.checkParameterIsNotNull(eventType, "eventType");
        Intrinsics.checkParameterIsNotNull(appId, "appId");
        Intrinsics.checkParameterIsNotNull(appVersion, "appVersion");
        Intrinsics.checkParameterIsNotNull(userAdvice, "userAdvice");
        this.eventType = eventType;
        this.appId = appId;
        this.appVersion = appVersion;
        this.launchTime = j3;
        this.eventTime = j16;
        this.userAdvice = userAdvice;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getAppVersion() {
        return this.appVersion;
    }

    /* renamed from: c, reason: from getter */
    public final long getEventTime() {
        return this.eventTime;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final AttaEventType getEventType() {
        return this.eventType;
    }

    /* renamed from: e, reason: from getter */
    public final long getLaunchTime() {
        return this.launchTime;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof AttaReportItem) {
                AttaReportItem attaReportItem = (AttaReportItem) other;
                if (!Intrinsics.areEqual(this.eventType, attaReportItem.eventType) || !Intrinsics.areEqual(this.appId, attaReportItem.appId) || !Intrinsics.areEqual(this.appVersion, attaReportItem.appVersion) || this.launchTime != attaReportItem.launchTime || this.eventTime != attaReportItem.eventTime || !Intrinsics.areEqual(this.userAdvice, attaReportItem.userAdvice)) {
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
    public final AttaUserAdvice getUserAdvice() {
        return this.userAdvice;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        AttaEventType attaEventType = this.eventType;
        int i18 = 0;
        if (attaEventType != null) {
            i3 = attaEventType.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = i3 * 31;
        String str = this.appId;
        if (str != null) {
            i16 = str.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i19 + i16) * 31;
        String str2 = this.appVersion;
        if (str2 != null) {
            i17 = str2.hashCode();
        } else {
            i17 = 0;
        }
        int a16 = (((((i26 + i17) * 31) + androidx.fragment.app.a.a(this.launchTime)) * 31) + androidx.fragment.app.a.a(this.eventTime)) * 31;
        AttaUserAdvice attaUserAdvice = this.userAdvice;
        if (attaUserAdvice != null) {
            i18 = attaUserAdvice.hashCode();
        }
        return a16 + i18;
    }

    @NotNull
    public String toString() {
        return "AttaReportItem(eventType=" + this.eventType + ", appId=" + this.appId + ", appVersion=" + this.appVersion + ", launchTime=" + this.launchTime + ", eventTime=" + this.eventTime + ", userAdvice=" + this.userAdvice + ")";
    }

    public /* synthetic */ AttaReportItem(AttaEventType attaEventType, String str, String str2, long j3, long j16, AttaUserAdvice attaUserAdvice, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(attaEventType, str, str2, j3, j16, (i3 & 32) != 0 ? new AttaUserAdvice() : attaUserAdvice);
    }
}
