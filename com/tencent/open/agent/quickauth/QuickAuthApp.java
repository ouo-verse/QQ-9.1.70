package com.tencent.open.agent.quickauth;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\u000b\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/open/agent/quickauth/z;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "appName", "", "b", "J", "getAppId", "()J", "appId", "c", "packageName", "d", "getDaid", "daid", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.open.agent.quickauth.z, reason: from toString */
/* loaded from: classes22.dex */
public final /* data */ class QuickAuthApp {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String appName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long appId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String packageName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String daid;

    public QuickAuthApp(@NotNull String appName, long j3, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(appName, "appName");
        this.appName = appName;
        this.appId = j3;
        this.packageName = str;
        this.daid = str2;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QuickAuthApp)) {
            return false;
        }
        QuickAuthApp quickAuthApp = (QuickAuthApp) other;
        if (Intrinsics.areEqual(this.appName, quickAuthApp.appName) && this.appId == quickAuthApp.appId && Intrinsics.areEqual(this.packageName, quickAuthApp.packageName) && Intrinsics.areEqual(this.daid, quickAuthApp.daid)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.appName.hashCode() * 31) + androidx.fragment.app.a.a(this.appId)) * 31;
        String str = this.packageName;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = (hashCode2 + hashCode) * 31;
        String str2 = this.daid;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        return "QuickAuthApp(appName=" + this.appName + ", appId=" + this.appId + ", packageName=" + this.packageName + ", daid=" + this.daid + ")";
    }
}
