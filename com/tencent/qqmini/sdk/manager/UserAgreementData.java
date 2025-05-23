package com.tencent.qqmini.sdk.manager;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0007\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0016\u0010\fR\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u000e\u0010\u0011R\u0017\u0010\u001b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\n\u001a\u0004\b\u001a\u0010\fR\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\t\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/qqmini/sdk/manager/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "e", "()Z", "isCompulsory", "b", "Ljava/lang/String;", "getAppId", "()Ljava/lang/String;", "appId", "c", "d", "version", "f", "isSigned", "title", "text", "g", "isSubscribe", "", "Lcom/tencent/qqmini/sdk/manager/d;", h.F, "Ljava/util/List;", "()Ljava/util/List;", "linkInfos", "<init>", "(ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZLjava/util/List;)V", "lib_minisdk_internalRelease"}, k = 1, mv = {1, 4, 0})
/* renamed from: com.tencent.qqmini.sdk.manager.c, reason: from toString */
/* loaded from: classes23.dex */
public final /* data */ class UserAgreementData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isCompulsory;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String appId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String version;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSigned;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String title;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String text;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSubscribe;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<UserAgreementLink> linkInfos;

    public UserAgreementData(boolean z16, @NotNull String appId, @NotNull String version, boolean z17, @NotNull String title, @NotNull String text, boolean z18, @NotNull List<UserAgreementLink> linkInfos) {
        Intrinsics.checkParameterIsNotNull(appId, "appId");
        Intrinsics.checkParameterIsNotNull(version, "version");
        Intrinsics.checkParameterIsNotNull(title, "title");
        Intrinsics.checkParameterIsNotNull(text, "text");
        Intrinsics.checkParameterIsNotNull(linkInfos, "linkInfos");
        this.isCompulsory = z16;
        this.appId = appId;
        this.version = version;
        this.isSigned = z17;
        this.title = title;
        this.text = text;
        this.isSubscribe = z18;
        this.linkInfos = linkInfos;
    }

    @NotNull
    public final List<UserAgreementLink> a() {
        return this.linkInfos;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getText() {
        return this.text;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsCompulsory() {
        return this.isCompulsory;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof UserAgreementData) {
                UserAgreementData userAgreementData = (UserAgreementData) other;
                if (this.isCompulsory != userAgreementData.isCompulsory || !Intrinsics.areEqual(this.appId, userAgreementData.appId) || !Intrinsics.areEqual(this.version, userAgreementData.version) || this.isSigned != userAgreementData.isSigned || !Intrinsics.areEqual(this.title, userAgreementData.title) || !Intrinsics.areEqual(this.text, userAgreementData.text) || this.isSubscribe != userAgreementData.isSubscribe || !Intrinsics.areEqual(this.linkInfos, userAgreementData.linkInfos)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getIsSigned() {
        return this.isSigned;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getIsSubscribe() {
        return this.isSubscribe;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r2v6, types: [boolean] */
    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        boolean z16 = this.isCompulsory;
        int i19 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i26 = r06 * 31;
        String str = this.appId;
        int i27 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i28 = (i26 + i3) * 31;
        String str2 = this.version;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i29 = (i28 + i16) * 31;
        ?? r26 = this.isSigned;
        int i36 = r26;
        if (r26 != 0) {
            i36 = 1;
        }
        int i37 = (i29 + i36) * 31;
        String str3 = this.title;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int i38 = (i37 + i17) * 31;
        String str4 = this.text;
        if (str4 != null) {
            i18 = str4.hashCode();
        } else {
            i18 = 0;
        }
        int i39 = (i38 + i18) * 31;
        boolean z17 = this.isSubscribe;
        if (!z17) {
            i19 = z17 ? 1 : 0;
        }
        int i46 = (i39 + i19) * 31;
        List<UserAgreementLink> list = this.linkInfos;
        if (list != null) {
            i27 = list.hashCode();
        }
        return i46 + i27;
    }

    @NotNull
    public String toString() {
        return "UserAgreementData(isCompulsory=" + this.isCompulsory + ", appId=" + this.appId + ", version=" + this.version + ", isSigned=" + this.isSigned + ", title=" + this.title + ", text=" + this.text + ", isSubscribe=" + this.isSubscribe + ", linkInfos=" + this.linkInfos + ")";
    }
}
