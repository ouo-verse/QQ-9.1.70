package com.tencent.state.square.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/square/api/OpenHippyParams;", "", "bundleName", "", "domain", "url", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBundleName", "()Ljava/lang/String;", "setBundleName", "(Ljava/lang/String;)V", "getDomain", "setDomain", "getUrl", "setUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final /* data */ class OpenHippyParams {

    @NotNull
    private String bundleName;

    @NotNull
    private String domain;

    @NotNull
    private String url;

    public OpenHippyParams(@NotNull String bundleName, @NotNull String domain, @NotNull String url) {
        Intrinsics.checkNotNullParameter(bundleName, "bundleName");
        Intrinsics.checkNotNullParameter(domain, "domain");
        Intrinsics.checkNotNullParameter(url, "url");
        this.bundleName = bundleName;
        this.domain = domain;
        this.url = url;
    }

    public static /* synthetic */ OpenHippyParams copy$default(OpenHippyParams openHippyParams, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = openHippyParams.bundleName;
        }
        if ((i3 & 2) != 0) {
            str2 = openHippyParams.domain;
        }
        if ((i3 & 4) != 0) {
            str3 = openHippyParams.url;
        }
        return openHippyParams.copy(str, str2, str3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getBundleName() {
        return this.bundleName;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getDomain() {
        return this.domain;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final OpenHippyParams copy(@NotNull String bundleName, @NotNull String domain, @NotNull String url) {
        Intrinsics.checkNotNullParameter(bundleName, "bundleName");
        Intrinsics.checkNotNullParameter(domain, "domain");
        Intrinsics.checkNotNullParameter(url, "url");
        return new OpenHippyParams(bundleName, domain, url);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof OpenHippyParams) {
                OpenHippyParams openHippyParams = (OpenHippyParams) other;
                if (!Intrinsics.areEqual(this.bundleName, openHippyParams.bundleName) || !Intrinsics.areEqual(this.domain, openHippyParams.domain) || !Intrinsics.areEqual(this.url, openHippyParams.url)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final String getBundleName() {
        return this.bundleName;
    }

    @NotNull
    public final String getDomain() {
        return this.domain;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int i3;
        int i16;
        String str = this.bundleName;
        int i17 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = i3 * 31;
        String str2 = this.domain;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i19 = (i18 + i16) * 31;
        String str3 = this.url;
        if (str3 != null) {
            i17 = str3.hashCode();
        }
        return i19 + i17;
    }

    public final void setBundleName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bundleName = str;
    }

    public final void setDomain(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.domain = str;
    }

    public final void setUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    @NotNull
    public String toString() {
        return "OpenHippyParams(bundleName=" + this.bundleName + ", domain=" + this.domain + ", url=" + this.url + ")";
    }
}
