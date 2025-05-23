package bl2;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b,\b\u0086\b\u0018\u00002\u00020\u0001B\u00a7\u0001\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010-\u001a\u00020\u0007\u0012\b\u0010/\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u00100\u001a\u00020\u0007\u00a2\u0006\u0004\b1\u00102J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\fR\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u0017\u0010\u001b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u001a\u0010\fR\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u0019\u0010 \u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001f\u0010\u0011R\u0019\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b!\u0010\u0011R\u0019\u0010$\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u000f\u001a\u0004\b\t\u0010\u0011R\u0019\u0010%\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u000f\u001a\u0004\b\u001e\u0010\u0011R\u0019\u0010&\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u000f\u001a\u0004\b#\u0010\u0011R\u0019\u0010'\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011R\u0019\u0010(\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u001c\u0010\u0011R\u0019\u0010)\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u000e\u0010\u0011R\u0017\u0010-\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010*\u001a\u0004\b+\u0010,R\u0019\u0010/\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b.\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011R\u0017\u00100\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b+\u0010*\u001a\u0004\b.\u0010,\u00a8\u00063"}, d2 = {"Lbl2/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()I", "skinId", "b", "Ljava/lang/String;", h.F, "()Ljava/lang/String;", "outerSkinId", "c", "l", "skinFrom", "d", DomainData.DOMAIN_NAME, "title", "e", "o", "type", "f", "defaultUrl", "g", "k", "popUrl", "j", "popOpenUrl", "i", "aioUrl", "makeUrl", "popBrokenUrl", "expireDatePrompt", "labelStr", "badgeUrl", "Z", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Z", "isDisable", "p", "disableText", "isDefault", "<init>", "(ILjava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Z)V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: bl2.c, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class HbSkinInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int skinId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String outerSkinId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int skinFrom;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String title;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int type;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String defaultUrl;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String popUrl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String popOpenUrl;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String aioUrl;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String makeUrl;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String popBrokenUrl;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String expireDatePrompt;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String labelStr;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String badgeUrl;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isDisable;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String disableText;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isDefault;

    public HbSkinInfo(int i3, @NotNull String outerSkinId, int i16, @Nullable String str, int i17, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, boolean z16, @Nullable String str11, boolean z17) {
        Intrinsics.checkNotNullParameter(outerSkinId, "outerSkinId");
        this.skinId = i3;
        this.outerSkinId = outerSkinId;
        this.skinFrom = i16;
        this.title = str;
        this.type = i17;
        this.defaultUrl = str2;
        this.popUrl = str3;
        this.popOpenUrl = str4;
        this.aioUrl = str5;
        this.makeUrl = str6;
        this.popBrokenUrl = str7;
        this.expireDatePrompt = str8;
        this.labelStr = str9;
        this.badgeUrl = str10;
        this.isDisable = z16;
        this.disableText = str11;
        this.isDefault = z17;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getAioUrl() {
        return this.aioUrl;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getBadgeUrl() {
        return this.badgeUrl;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getDefaultUrl() {
        return this.defaultUrl;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final String getDisableText() {
        return this.disableText;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final String getExpireDatePrompt() {
        return this.expireDatePrompt;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HbSkinInfo)) {
            return false;
        }
        HbSkinInfo hbSkinInfo = (HbSkinInfo) other;
        if (this.skinId == hbSkinInfo.skinId && Intrinsics.areEqual(this.outerSkinId, hbSkinInfo.outerSkinId) && this.skinFrom == hbSkinInfo.skinFrom && Intrinsics.areEqual(this.title, hbSkinInfo.title) && this.type == hbSkinInfo.type && Intrinsics.areEqual(this.defaultUrl, hbSkinInfo.defaultUrl) && Intrinsics.areEqual(this.popUrl, hbSkinInfo.popUrl) && Intrinsics.areEqual(this.popOpenUrl, hbSkinInfo.popOpenUrl) && Intrinsics.areEqual(this.aioUrl, hbSkinInfo.aioUrl) && Intrinsics.areEqual(this.makeUrl, hbSkinInfo.makeUrl) && Intrinsics.areEqual(this.popBrokenUrl, hbSkinInfo.popBrokenUrl) && Intrinsics.areEqual(this.expireDatePrompt, hbSkinInfo.expireDatePrompt) && Intrinsics.areEqual(this.labelStr, hbSkinInfo.labelStr) && Intrinsics.areEqual(this.badgeUrl, hbSkinInfo.badgeUrl) && this.isDisable == hbSkinInfo.isDisable && Intrinsics.areEqual(this.disableText, hbSkinInfo.disableText) && this.isDefault == hbSkinInfo.isDefault) {
            return true;
        }
        return false;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final String getLabelStr() {
        return this.labelStr;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final String getMakeUrl() {
        return this.makeUrl;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getOuterSkinId() {
        return this.outerSkinId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int hashCode8;
        int hashCode9;
        int hashCode10;
        int hashCode11 = ((((this.skinId * 31) + this.outerSkinId.hashCode()) * 31) + this.skinFrom) * 31;
        String str = this.title;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = (((hashCode11 + hashCode) * 31) + this.type) * 31;
        String str2 = this.defaultUrl;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str3 = this.popUrl;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        String str4 = this.popOpenUrl;
        if (str4 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str4.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        String str5 = this.aioUrl;
        if (str5 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = str5.hashCode();
        }
        int i26 = (i19 + hashCode5) * 31;
        String str6 = this.makeUrl;
        if (str6 == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = str6.hashCode();
        }
        int i27 = (i26 + hashCode6) * 31;
        String str7 = this.popBrokenUrl;
        if (str7 == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = str7.hashCode();
        }
        int i28 = (i27 + hashCode7) * 31;
        String str8 = this.expireDatePrompt;
        if (str8 == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = str8.hashCode();
        }
        int i29 = (i28 + hashCode8) * 31;
        String str9 = this.labelStr;
        if (str9 == null) {
            hashCode9 = 0;
        } else {
            hashCode9 = str9.hashCode();
        }
        int i36 = (i29 + hashCode9) * 31;
        String str10 = this.badgeUrl;
        if (str10 == null) {
            hashCode10 = 0;
        } else {
            hashCode10 = str10.hashCode();
        }
        int i37 = (i36 + hashCode10) * 31;
        boolean z16 = this.isDisable;
        int i38 = 1;
        int i39 = z16;
        if (z16 != 0) {
            i39 = 1;
        }
        int i46 = (i37 + i39) * 31;
        String str11 = this.disableText;
        if (str11 != null) {
            i3 = str11.hashCode();
        }
        int i47 = (i46 + i3) * 31;
        boolean z17 = this.isDefault;
        if (!z17) {
            i38 = z17 ? 1 : 0;
        }
        return i47 + i38;
    }

    @Nullable
    /* renamed from: i, reason: from getter */
    public final String getPopBrokenUrl() {
        return this.popBrokenUrl;
    }

    @Nullable
    /* renamed from: j, reason: from getter */
    public final String getPopOpenUrl() {
        return this.popOpenUrl;
    }

    @Nullable
    /* renamed from: k, reason: from getter */
    public final String getPopUrl() {
        return this.popUrl;
    }

    /* renamed from: l, reason: from getter */
    public final int getSkinFrom() {
        return this.skinFrom;
    }

    /* renamed from: m, reason: from getter */
    public final int getSkinId() {
        return this.skinId;
    }

    @Nullable
    /* renamed from: n, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: o, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: p, reason: from getter */
    public final boolean getIsDefault() {
        return this.isDefault;
    }

    /* renamed from: q, reason: from getter */
    public final boolean getIsDisable() {
        return this.isDisable;
    }

    @NotNull
    public String toString() {
        return "HbSkinInfo(skinId=" + this.skinId + ", outerSkinId=" + this.outerSkinId + ", skinFrom=" + this.skinFrom + ", title=" + this.title + ", type=" + this.type + ", defaultUrl=" + this.defaultUrl + ", popUrl=" + this.popUrl + ", popOpenUrl=" + this.popOpenUrl + ", aioUrl=" + this.aioUrl + ", makeUrl=" + this.makeUrl + ", popBrokenUrl=" + this.popBrokenUrl + ", expireDatePrompt=" + this.expireDatePrompt + ", labelStr=" + this.labelStr + ", badgeUrl=" + this.badgeUrl + ", isDisable=" + this.isDisable + ", disableText=" + this.disableText + ", isDefault=" + this.isDefault + ")";
    }

    public /* synthetic */ HbSkinInfo(int i3, String str, int i16, String str2, int i17, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, boolean z16, String str12, boolean z17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, i16, str2, i17, str3, str4, str5, str6, str7, str8, str9, str10, str11, z16, str12, (i18 & 65536) != 0 ? false : z17);
    }
}
