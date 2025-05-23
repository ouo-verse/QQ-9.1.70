package com.tencent.ams.dynamicwidget.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001-BE\b\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b)\u0010*B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b)\u0010+J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\nH\u00c6\u0003JE\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\nH\u00c6\u0001J\t\u0010\u0016\u001a\u00020\nH\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u00d6\u0003R$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R$\u0010\u0012\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u001c\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R$\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u001c\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R$\u0010\u0014\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u001c\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010 \u00a8\u0006."}, d2 = {"Lcom/tencent/ams/dynamicwidget/data/LandingPageData;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "component1", "component2", "component3", "component4", "component5", "iconUrl", "title", QQWinkConstants.TAB_SUBTITLE, "actionButtonTitle", "tipsTitle", "copy", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getIconUrl", "()Ljava/lang/String;", "setIconUrl", "(Ljava/lang/String;)V", "getTitle", "setTitle", "getSubTitle", "setSubTitle", "getActionButtonTitle", "setActionButtonTitle", "getTipsTitle", "setTipsTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "lib_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final /* data */ class LandingPageData implements Serializable, Parcelable {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final long serialVersionUID = -124;

    @Nullable
    private String actionButtonTitle;

    @Nullable
    private String iconUrl;

    @Nullable
    private String subTitle;

    @Nullable
    private String tipsTitle;

    @Nullable
    private String title;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ams/dynamicwidget/data/LandingPageData$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/ams/dynamicwidget/data/LandingPageData;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/ams/dynamicwidget/data/LandingPageData;", "", "serialVersionUID", "J", "<init>", "()V", "lib_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.ams.dynamicwidget.data.LandingPageData$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion implements Parcelable.Creator<LandingPageData> {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LandingPageData createFromParcel(@NotNull Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (LandingPageData) iPatchRedirector.redirect((short) 1, (Object) this, (Object) parcel);
            }
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new LandingPageData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public LandingPageData[] newArray(int size) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (LandingPageData[]) iPatchRedirector.redirect((short) 2, (Object) this, size);
            }
            return new LandingPageData[size];
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16094);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 21)) {
            redirector.redirect((short) 21);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    @JvmOverloads
    public LandingPageData() {
        this(null, null, null, null, null, 31, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
            return;
        }
        iPatchRedirector.redirect((short) 19, (Object) this);
    }

    public static /* synthetic */ LandingPageData copy$default(LandingPageData landingPageData, String str, String str2, String str3, String str4, String str5, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = landingPageData.iconUrl;
        }
        if ((i3 & 2) != 0) {
            str2 = landingPageData.title;
        }
        String str6 = str2;
        if ((i3 & 4) != 0) {
            str3 = landingPageData.subTitle;
        }
        String str7 = str3;
        if ((i3 & 8) != 0) {
            str4 = landingPageData.actionButtonTitle;
        }
        String str8 = str4;
        if ((i3 & 16) != 0) {
            str5 = landingPageData.tipsTitle;
        }
        return landingPageData.copy(str, str6, str7, str8, str5);
    }

    @Nullable
    public final String component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.iconUrl;
    }

    @Nullable
    public final String component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this.title;
    }

    @Nullable
    public final String component3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (String) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this.subTitle;
    }

    @Nullable
    public final String component4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return this.actionButtonTitle;
    }

    @Nullable
    public final String component5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return this.tipsTitle;
    }

    @NotNull
    public final LandingPageData copy(@Nullable String iconUrl, @Nullable String title, @Nullable String subTitle, @Nullable String actionButtonTitle, @Nullable String tipsTitle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (LandingPageData) iPatchRedirector.redirect((short) 27, this, iconUrl, title, subTitle, actionButtonTitle, tipsTitle);
        }
        return new LandingPageData(iconUrl, title, subTitle, actionButtonTitle, tipsTitle);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this, other)).booleanValue();
        }
        if (this != other) {
            if (other instanceof LandingPageData) {
                LandingPageData landingPageData = (LandingPageData) other;
                if (!Intrinsics.areEqual(this.iconUrl, landingPageData.iconUrl) || !Intrinsics.areEqual(this.title, landingPageData.title) || !Intrinsics.areEqual(this.subTitle, landingPageData.subTitle) || !Intrinsics.areEqual(this.actionButtonTitle, landingPageData.actionButtonTitle) || !Intrinsics.areEqual(this.tipsTitle, landingPageData.tipsTitle)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final String getActionButtonTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.actionButtonTitle;
    }

    @Nullable
    public final String getIconUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.iconUrl;
    }

    @Nullable
    public final String getSubTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.subTitle;
    }

    @Nullable
    public final String getTipsTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.tipsTitle;
    }

    @Nullable
    public final String getTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.title;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Integer) iPatchRedirector.redirect((short) 29, (Object) this)).intValue();
        }
        String str = this.iconUrl;
        int i19 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i26 = i3 * 31;
        String str2 = this.title;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i27 = (i26 + i16) * 31;
        String str3 = this.subTitle;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int i28 = (i27 + i17) * 31;
        String str4 = this.actionButtonTitle;
        if (str4 != null) {
            i18 = str4.hashCode();
        } else {
            i18 = 0;
        }
        int i29 = (i28 + i18) * 31;
        String str5 = this.tipsTitle;
        if (str5 != null) {
            i19 = str5.hashCode();
        }
        return i29 + i19;
    }

    public final void setActionButtonTitle(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        } else {
            this.actionButtonTitle = str;
        }
    }

    public final void setIconUrl(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.iconUrl = str;
        }
    }

    public final void setSubTitle(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            this.subTitle = str;
        }
    }

    public final void setTipsTitle(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        } else {
            this.tipsTitle = str;
        }
    }

    public final void setTitle(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            this.title = str;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (String) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return "LandingPageData(iconUrl=" + this.iconUrl + ", title=" + this.title + ", subTitle=" + this.subTitle + ", actionButtonTitle=" + this.actionButtonTitle + ", tipsTitle=" + this.tipsTitle + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) parcel, flags);
            return;
        }
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.title);
        parcel.writeString(this.subTitle);
        parcel.writeString(this.actionButtonTitle);
        parcel.writeString(this.tipsTitle);
    }

    @JvmOverloads
    public LandingPageData(@Nullable String str) {
        this(str, null, null, null, null, 30, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) {
            return;
        }
        iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
    }

    @JvmOverloads
    public LandingPageData(@Nullable String str, @Nullable String str2) {
        this(str, str2, null, null, null, 28, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) {
            return;
        }
        iPatchRedirector.redirect((short) 17, (Object) this, (Object) str, (Object) str2);
    }

    @JvmOverloads
    public LandingPageData(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this(str, str2, str3, null, null, 24, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
            return;
        }
        iPatchRedirector.redirect((short) 16, this, str, str2, str3);
    }

    @JvmOverloads
    public LandingPageData(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this(str, str2, str3, str4, null, 16, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            return;
        }
        iPatchRedirector.redirect((short) 15, this, str, str2, str3, str4);
    }

    @JvmOverloads
    public LandingPageData(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, str, str2, str3, str4, str5);
            return;
        }
        this.iconUrl = str;
        this.title = str2;
        this.subTitle = str3;
        this.actionButtonTitle = str4;
        this.tipsTitle = str5;
    }

    public /* synthetic */ LandingPageData(String str, String str2, String str3, String str4, String str5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? null : str4, (i3 & 16) != 0 ? null : str5);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            return;
        }
        iPatchRedirector.redirect((short) 14, this, str, str2, str3, str4, str5, Integer.valueOf(i3), defaultConstructorMarker);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LandingPageData(@NotNull Parcel parcel) {
        this(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
            return;
        }
        iPatchRedirector.redirect((short) 20, (Object) this, (Object) parcel);
    }
}
