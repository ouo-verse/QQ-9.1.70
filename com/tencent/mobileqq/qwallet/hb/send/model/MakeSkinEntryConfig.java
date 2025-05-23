package com.tencent.mobileqq.qwallet.hb.send.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB5\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR(\u0010\u0015\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0004\b\u0015\u0010\u0016\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/send/model/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "entryTitle", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setEntryTitle", "(Ljava/lang/String;)V", "entryIcon", "b", "setEntryIcon", "url", "d", "setUrl", "isShareEnabled", "Z", "()Z", "setShareEnabled", "(Z)V", "isShareEnabled$annotations", "()V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "a", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qwallet.hb.send.model.b, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class MakeSkinEntryConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final MakeSkinEntryConfig f277774b = new MakeSkinEntryConfig(null, null, null, false, 15, null);

    @SerializedName("icon")
    @Nullable
    private String entryIcon;

    @SerializedName("title")
    @Nullable
    private String entryTitle;

    @SerializedName("isShareEnabled")
    private boolean isShareEnabled;

    @SerializedName("url")
    @Nullable
    private String url;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/send/model/b$a;", "", "Lcom/tencent/mobileqq/qwallet/hb/send/model/b;", "DEFAULT", "Lcom/tencent/mobileqq/qwallet/hb/send/model/b;", "a", "()Lcom/tencent/mobileqq/qwallet/hb/send/model/b;", "<init>", "()V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.hb.send.model.b$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MakeSkinEntryConfig a() {
            return MakeSkinEntryConfig.f277774b;
        }

        Companion() {
        }
    }

    public MakeSkinEntryConfig() {
        this(null, null, null, false, 15, null);
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getEntryIcon() {
        return this.entryIcon;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getEntryTitle() {
        return this.entryTitle;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MakeSkinEntryConfig)) {
            return false;
        }
        MakeSkinEntryConfig makeSkinEntryConfig = (MakeSkinEntryConfig) other;
        if (Intrinsics.areEqual(this.entryTitle, makeSkinEntryConfig.entryTitle) && Intrinsics.areEqual(this.entryIcon, makeSkinEntryConfig.entryIcon) && Intrinsics.areEqual(this.url, makeSkinEntryConfig.url) && this.isShareEnabled == makeSkinEntryConfig.isShareEnabled) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        String str = this.entryTitle;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        String str2 = this.entryIcon;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str3 = this.url;
        if (str3 != null) {
            i3 = str3.hashCode();
        }
        int i18 = (i17 + i3) * 31;
        boolean z16 = this.isShareEnabled;
        int i19 = z16;
        if (z16 != 0) {
            i19 = 1;
        }
        return i18 + i19;
    }

    @NotNull
    public String toString() {
        return "MakeSkinEntryConfig(entryTitle=" + this.entryTitle + ", entryIcon=" + this.entryIcon + ", url=" + this.url + ", isShareEnabled=" + this.isShareEnabled + ")";
    }

    public MakeSkinEntryConfig(@Nullable String str, @Nullable String str2, @Nullable String str3, boolean z16) {
        this.entryTitle = str;
        this.entryIcon = str2;
        this.url = str3;
        this.isShareEnabled = z16;
    }

    public /* synthetic */ MakeSkinEntryConfig(String str, String str2, String str3, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? false : z16);
    }
}
