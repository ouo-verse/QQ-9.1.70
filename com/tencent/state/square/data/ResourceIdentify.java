package com.tencent.state.square.data;

import com.tencent.state.square.record.SquareRecordManager;
import com.tencent.zplan.common.utils.d;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\bH\u00c6\u0003J;\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010'\u001a\u00020\bH\u00d6\u0001J\u0006\u0010(\u001a\u00020)J\u0015\u0010*\u001a\u00020)2\b\u0010+\u001a\u0004\u0018\u00010%\u00a2\u0006\u0002\u0010,J\t\u0010-\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000b\"\u0004\b\u001d\u0010\r\u00a8\u0006."}, d2 = {"Lcom/tencent/state/square/data/ResourceIdentify;", "", "url", "", "md5", "defaultUrl", "defaultMd5", "src", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getDefaultMd5", "()Ljava/lang/String;", "setDefaultMd5", "(Ljava/lang/String;)V", "getDefaultUrl", "setDefaultUrl", "getMd5", "setMd5", "multiExtra", "Lcom/tencent/state/square/data/MultiDefault;", "getMultiExtra", "()Lcom/tencent/state/square/data/MultiDefault;", "setMultiExtra", "(Lcom/tencent/state/square/data/MultiDefault;)V", "getSrc", "()I", "setSrc", "(I)V", "getUrl", "setUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "resetDefault", "", "resetDefaultWithGender", "isMale", "(Ljava/lang/Boolean;)V", "toString", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final /* data */ class ResourceIdentify {

    @NotNull
    private String defaultMd5;

    @NotNull
    private String defaultUrl;

    @NotNull
    private String md5;

    @Nullable
    private MultiDefault multiExtra;
    private int src;

    @NotNull
    private String url;

    public ResourceIdentify() {
        this(null, null, null, null, 0, 31, null);
    }

    public static /* synthetic */ ResourceIdentify copy$default(ResourceIdentify resourceIdentify, String str, String str2, String str3, String str4, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = resourceIdentify.url;
        }
        if ((i16 & 2) != 0) {
            str2 = resourceIdentify.md5;
        }
        String str5 = str2;
        if ((i16 & 4) != 0) {
            str3 = resourceIdentify.defaultUrl;
        }
        String str6 = str3;
        if ((i16 & 8) != 0) {
            str4 = resourceIdentify.defaultMd5;
        }
        String str7 = str4;
        if ((i16 & 16) != 0) {
            i3 = resourceIdentify.src;
        }
        return resourceIdentify.copy(str, str5, str6, str7, i3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getMd5() {
        return this.md5;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getDefaultUrl() {
        return this.defaultUrl;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getDefaultMd5() {
        return this.defaultMd5;
    }

    /* renamed from: component5, reason: from getter */
    public final int getSrc() {
        return this.src;
    }

    @NotNull
    public final ResourceIdentify copy(@NotNull String url, @NotNull String md5, @NotNull String defaultUrl, @NotNull String defaultMd5, int src) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(md5, "md5");
        Intrinsics.checkNotNullParameter(defaultUrl, "defaultUrl");
        Intrinsics.checkNotNullParameter(defaultMd5, "defaultMd5");
        return new ResourceIdentify(url, md5, defaultUrl, defaultMd5, src);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ResourceIdentify) {
                ResourceIdentify resourceIdentify = (ResourceIdentify) other;
                if (!Intrinsics.areEqual(this.url, resourceIdentify.url) || !Intrinsics.areEqual(this.md5, resourceIdentify.md5) || !Intrinsics.areEqual(this.defaultUrl, resourceIdentify.defaultUrl) || !Intrinsics.areEqual(this.defaultMd5, resourceIdentify.defaultMd5) || this.src != resourceIdentify.src) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final String getDefaultMd5() {
        return this.defaultMd5;
    }

    @NotNull
    public final String getDefaultUrl() {
        return this.defaultUrl;
    }

    @NotNull
    public final String getMd5() {
        return this.md5;
    }

    @Nullable
    public final MultiDefault getMultiExtra() {
        return this.multiExtra;
    }

    public final int getSrc() {
        return this.src;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        String str = this.url;
        int i18 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = i3 * 31;
        String str2 = this.md5;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i19 + i16) * 31;
        String str3 = this.defaultUrl;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int i27 = (i26 + i17) * 31;
        String str4 = this.defaultMd5;
        if (str4 != null) {
            i18 = str4.hashCode();
        }
        return ((i27 + i18) * 31) + this.src;
    }

    public final void resetDefault() {
        this.url = this.defaultUrl;
        this.md5 = this.defaultMd5;
    }

    public final void resetDefaultWithGender(@Nullable Boolean isMale) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19 = false;
        if (isMale != null) {
            z16 = isMale.booleanValue();
        } else if (!SquareRecordManager.INSTANCE.genGenderIsMale()) {
            z16 = true;
        } else {
            z16 = false;
        }
        MultiDefault multiDefault = this.multiExtra;
        if (multiDefault != null) {
            if (z16) {
                String withMaleUrl = multiDefault.getWithMaleUrl();
                if (withMaleUrl.length() == 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    withMaleUrl = this.defaultUrl;
                }
                this.url = withMaleUrl;
                String withMaleMd5 = multiDefault.getWithMaleMd5();
                if (withMaleMd5.length() == 0) {
                    z19 = true;
                }
                if (z19) {
                    withMaleMd5 = this.defaultMd5;
                }
                this.md5 = withMaleMd5;
                return;
            }
            if (!z16) {
                String withFemaleUrl = multiDefault.getWithFemaleUrl();
                if (withFemaleUrl.length() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    withFemaleUrl = this.defaultUrl;
                }
                this.url = withFemaleUrl;
                String withFemaleMd5 = multiDefault.getWithFemaleMd5();
                if (withFemaleMd5.length() == 0) {
                    z19 = true;
                }
                if (z19) {
                    withFemaleMd5 = this.defaultMd5;
                }
                this.md5 = withFemaleMd5;
            }
        }
    }

    public final void setDefaultMd5(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.defaultMd5 = str;
    }

    public final void setDefaultUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.defaultUrl = str;
    }

    public final void setMd5(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.md5 = str;
    }

    public final void setMultiExtra(@Nullable MultiDefault multiDefault) {
        this.multiExtra = multiDefault;
    }

    public final void setSrc(int i3) {
        this.src = i3;
    }

    public final void setUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    @NotNull
    public String toString() {
        return "ResourceIdentify(url=" + this.url + ", md5=" + this.md5 + ", defaultUrl=" + this.defaultUrl + ", defaultMd5=" + this.defaultMd5 + ", src=" + this.src + ")";
    }

    public ResourceIdentify(@NotNull String url, @NotNull String md5, @NotNull String defaultUrl, @NotNull String defaultMd5, int i3) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(md5, "md5");
        Intrinsics.checkNotNullParameter(defaultUrl, "defaultUrl");
        Intrinsics.checkNotNullParameter(defaultMd5, "defaultMd5");
        this.url = url;
        this.md5 = md5;
        this.defaultUrl = defaultUrl;
        this.defaultMd5 = defaultMd5;
        this.src = i3;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ResourceIdentify(String str, String str2, String str3, String str4, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(r10, str2, (i16 & 4) != 0 ? "" : str3, (i16 & 8) == 0 ? str4 : "", (i16 & 16) != 0 ? 0 : i3);
        String str5 = (i16 & 1) != 0 ? "" : str;
        if ((i16 & 2) != 0) {
            str2 = d.c(str5);
            Intrinsics.checkNotNullExpressionValue(str2, "MD5.toMD5(url)");
        }
    }
}
