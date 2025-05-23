package com.tencent.state.square.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/state/square/data/MultiDefault;", "", "withMaleUrl", "", "withMaleMd5", "withFemaleUrl", "withFemaleMd5", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getWithFemaleMd5", "()Ljava/lang/String;", "setWithFemaleMd5", "(Ljava/lang/String;)V", "getWithFemaleUrl", "setWithFemaleUrl", "getWithMaleMd5", "setWithMaleMd5", "getWithMaleUrl", "setWithMaleUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final /* data */ class MultiDefault {

    @NotNull
    private String withFemaleMd5;

    @NotNull
    private String withFemaleUrl;

    @NotNull
    private String withMaleMd5;

    @NotNull
    private String withMaleUrl;

    public MultiDefault() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ MultiDefault copy$default(MultiDefault multiDefault, String str, String str2, String str3, String str4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = multiDefault.withMaleUrl;
        }
        if ((i3 & 2) != 0) {
            str2 = multiDefault.withMaleMd5;
        }
        if ((i3 & 4) != 0) {
            str3 = multiDefault.withFemaleUrl;
        }
        if ((i3 & 8) != 0) {
            str4 = multiDefault.withFemaleMd5;
        }
        return multiDefault.copy(str, str2, str3, str4);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getWithMaleUrl() {
        return this.withMaleUrl;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getWithMaleMd5() {
        return this.withMaleMd5;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getWithFemaleUrl() {
        return this.withFemaleUrl;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getWithFemaleMd5() {
        return this.withFemaleMd5;
    }

    @NotNull
    public final MultiDefault copy(@NotNull String withMaleUrl, @NotNull String withMaleMd5, @NotNull String withFemaleUrl, @NotNull String withFemaleMd5) {
        Intrinsics.checkNotNullParameter(withMaleUrl, "withMaleUrl");
        Intrinsics.checkNotNullParameter(withMaleMd5, "withMaleMd5");
        Intrinsics.checkNotNullParameter(withFemaleUrl, "withFemaleUrl");
        Intrinsics.checkNotNullParameter(withFemaleMd5, "withFemaleMd5");
        return new MultiDefault(withMaleUrl, withMaleMd5, withFemaleUrl, withFemaleMd5);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof MultiDefault) {
                MultiDefault multiDefault = (MultiDefault) other;
                if (!Intrinsics.areEqual(this.withMaleUrl, multiDefault.withMaleUrl) || !Intrinsics.areEqual(this.withMaleMd5, multiDefault.withMaleMd5) || !Intrinsics.areEqual(this.withFemaleUrl, multiDefault.withFemaleUrl) || !Intrinsics.areEqual(this.withFemaleMd5, multiDefault.withFemaleMd5)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final String getWithFemaleMd5() {
        return this.withFemaleMd5;
    }

    @NotNull
    public final String getWithFemaleUrl() {
        return this.withFemaleUrl;
    }

    @NotNull
    public final String getWithMaleMd5() {
        return this.withMaleMd5;
    }

    @NotNull
    public final String getWithMaleUrl() {
        return this.withMaleUrl;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        String str = this.withMaleUrl;
        int i18 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = i3 * 31;
        String str2 = this.withMaleMd5;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i19 + i16) * 31;
        String str3 = this.withFemaleUrl;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int i27 = (i26 + i17) * 31;
        String str4 = this.withFemaleMd5;
        if (str4 != null) {
            i18 = str4.hashCode();
        }
        return i27 + i18;
    }

    public final void setWithFemaleMd5(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.withFemaleMd5 = str;
    }

    public final void setWithFemaleUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.withFemaleUrl = str;
    }

    public final void setWithMaleMd5(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.withMaleMd5 = str;
    }

    public final void setWithMaleUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.withMaleUrl = str;
    }

    @NotNull
    public String toString() {
        return "MultiDefault(withMaleUrl=" + this.withMaleUrl + ", withMaleMd5=" + this.withMaleMd5 + ", withFemaleUrl=" + this.withFemaleUrl + ", withFemaleMd5=" + this.withFemaleMd5 + ")";
    }

    public MultiDefault(@NotNull String withMaleUrl, @NotNull String withMaleMd5, @NotNull String withFemaleUrl, @NotNull String withFemaleMd5) {
        Intrinsics.checkNotNullParameter(withMaleUrl, "withMaleUrl");
        Intrinsics.checkNotNullParameter(withMaleMd5, "withMaleMd5");
        Intrinsics.checkNotNullParameter(withFemaleUrl, "withFemaleUrl");
        Intrinsics.checkNotNullParameter(withFemaleMd5, "withFemaleMd5");
        this.withMaleUrl = withMaleUrl;
        this.withMaleMd5 = withMaleMd5;
        this.withFemaleUrl = withFemaleUrl;
        this.withFemaleMd5 = withFemaleMd5;
    }

    public /* synthetic */ MultiDefault(String str, String str2, String str3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4);
    }
}
