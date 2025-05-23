package com.tencent.rmonitor.base.meta;

import com.tencent.bugly.BuildConfigWrapper;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/rmonitor/base/meta/UrlMeta;", "", "rmonitorDomain", "", "authorizationUrl", "attaUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAttaUrl", "()Ljava/lang/String;", "setAttaUrl", "(Ljava/lang/String;)V", "getAuthorizationUrl", "setAuthorizationUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "rmonitor-core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes25.dex */
public final /* data */ class UrlMeta {

    @NotNull
    private String attaUrl;

    @NotNull
    private String authorizationUrl;

    @JvmField
    @NotNull
    public String rmonitorDomain;

    public UrlMeta() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ UrlMeta copy$default(UrlMeta urlMeta, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = urlMeta.rmonitorDomain;
        }
        if ((i3 & 2) != 0) {
            str2 = urlMeta.authorizationUrl;
        }
        if ((i3 & 4) != 0) {
            str3 = urlMeta.attaUrl;
        }
        return urlMeta.copy(str, str2, str3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getRmonitorDomain() {
        return this.rmonitorDomain;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getAuthorizationUrl() {
        return this.authorizationUrl;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getAttaUrl() {
        return this.attaUrl;
    }

    @NotNull
    public final UrlMeta copy(@NotNull String rmonitorDomain, @NotNull String authorizationUrl, @NotNull String attaUrl) {
        Intrinsics.checkParameterIsNotNull(rmonitorDomain, "rmonitorDomain");
        Intrinsics.checkParameterIsNotNull(authorizationUrl, "authorizationUrl");
        Intrinsics.checkParameterIsNotNull(attaUrl, "attaUrl");
        return new UrlMeta(rmonitorDomain, authorizationUrl, attaUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof UrlMeta) {
                UrlMeta urlMeta = (UrlMeta) other;
                if (!Intrinsics.areEqual(this.rmonitorDomain, urlMeta.rmonitorDomain) || !Intrinsics.areEqual(this.authorizationUrl, urlMeta.authorizationUrl) || !Intrinsics.areEqual(this.attaUrl, urlMeta.attaUrl)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final String getAttaUrl() {
        return this.attaUrl;
    }

    @NotNull
    public final String getAuthorizationUrl() {
        return this.authorizationUrl;
    }

    public int hashCode() {
        int i3;
        int i16;
        String str = this.rmonitorDomain;
        int i17 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = i3 * 31;
        String str2 = this.authorizationUrl;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i19 = (i18 + i16) * 31;
        String str3 = this.attaUrl;
        if (str3 != null) {
            i17 = str3.hashCode();
        }
        return i19 + i17;
    }

    public final void setAttaUrl(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.attaUrl = str;
    }

    public final void setAuthorizationUrl(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.authorizationUrl = str;
    }

    @NotNull
    public String toString() {
        return "UrlMeta(rmonitorDomain=" + this.rmonitorDomain + ", authorizationUrl=" + this.authorizationUrl + ", attaUrl=" + this.attaUrl + ")";
    }

    public UrlMeta(@NotNull String rmonitorDomain, @NotNull String authorizationUrl, @NotNull String attaUrl) {
        Intrinsics.checkParameterIsNotNull(rmonitorDomain, "rmonitorDomain");
        Intrinsics.checkParameterIsNotNull(authorizationUrl, "authorizationUrl");
        Intrinsics.checkParameterIsNotNull(attaUrl, "attaUrl");
        this.rmonitorDomain = rmonitorDomain;
        this.authorizationUrl = authorizationUrl;
        this.attaUrl = attaUrl;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ UrlMeta(String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3);
        if ((i3 & 1) != 0) {
            str = BuildConfigWrapper.getDomain();
            Intrinsics.checkExpressionValueIsNotNull(str, "BuildConfigWrapper.getDomain()");
        }
        str2 = (i3 & 2) != 0 ? "" : str2;
        if ((i3 & 4) != 0) {
            str3 = BuildConfigWrapper.getAttaUrl();
            Intrinsics.checkExpressionValueIsNotNull(str3, "BuildConfigWrapper.getAttaUrl()");
        }
    }
}
