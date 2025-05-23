package com.tencent.qqmini.sdk.manager;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqmini/sdk/manager/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "linkText", "b", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "lib_minisdk_internalRelease"}, k = 1, mv = {1, 4, 0})
/* renamed from: com.tencent.qqmini.sdk.manager.d, reason: from toString */
/* loaded from: classes23.dex */
public final /* data */ class UserAgreementLink {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String linkText;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String url;

    public UserAgreementLink(@NotNull String linkText, @NotNull String url) {
        Intrinsics.checkParameterIsNotNull(linkText, "linkText");
        Intrinsics.checkParameterIsNotNull(url, "url");
        this.linkText = linkText;
        this.url = url;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getLinkText() {
        return this.linkText;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof UserAgreementLink) {
                UserAgreementLink userAgreementLink = (UserAgreementLink) other;
                if (!Intrinsics.areEqual(this.linkText, userAgreementLink.linkText) || !Intrinsics.areEqual(this.url, userAgreementLink.url)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3;
        String str = this.linkText;
        int i16 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        String str2 = this.url;
        if (str2 != null) {
            i16 = str2.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        return "UserAgreementLink(linkText=" + this.linkText + ", url=" + this.url + ")";
    }
}
