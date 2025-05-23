package com.tencent.mobileqq.guild.media.thirdapp.container.intent;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/b;", "a", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/b;", "()Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/b;", "appInfo", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/d;", "b", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/d;", "getAuthInfo", "()Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/d;", "authInfo", "<init>", "(Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/b;Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/d;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.media.thirdapp.container.intent.a, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class AppAuthResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final AppInfo appInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final AuthInfo authInfo;

    public AppAuthResult(@NotNull AppInfo appInfo, @NotNull AuthInfo authInfo) {
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        Intrinsics.checkNotNullParameter(authInfo, "authInfo");
        this.appInfo = appInfo;
        this.authInfo = authInfo;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final AppInfo getAppInfo() {
        return this.appInfo;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppAuthResult)) {
            return false;
        }
        AppAuthResult appAuthResult = (AppAuthResult) other;
        if (Intrinsics.areEqual(this.appInfo, appAuthResult.appInfo) && Intrinsics.areEqual(this.authInfo, appAuthResult.authInfo)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.appInfo.hashCode() * 31) + this.authInfo.hashCode();
    }

    @NotNull
    public String toString() {
        return "AppAuthResult(appInfo=" + this.appInfo + ", authInfo=" + this.authInfo + ")";
    }
}
