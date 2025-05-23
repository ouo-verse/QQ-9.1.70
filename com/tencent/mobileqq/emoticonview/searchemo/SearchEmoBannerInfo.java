package com.tencent.mobileqq.emoticonview.searchemo;

import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0007H\u00c6\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u0007H\u00d6\u0001J\u0006\u0010\u001e\u001a\u00020\u001bJ\u0006\u0010\u001f\u001a\u00020\u001bJ\t\u0010 \u001a\u00020\u0003H\u00d6\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoBannerInfo;", "", "bannerImage", "", "bannerUrl", "leftButtonUrl", "showLeftButton", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getBannerImage", "()Ljava/lang/String;", "setBannerImage", "(Ljava/lang/String;)V", "getBannerUrl", "setBannerUrl", "getLeftButtonUrl", "setLeftButtonUrl", "getShowLeftButton", "()I", "setShowLeftButton", "(I)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "isBannerValid", "isLeftButtonValid", "toString", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final /* data */ class SearchEmoBannerInfo {
    static IPatchRedirector $redirector_;

    @SerializedName("banner_image")
    @NotNull
    private String bannerImage;

    @SerializedName("banner_url")
    @NotNull
    private String bannerUrl;

    @SerializedName("left_button_url")
    @NotNull
    private String leftButtonUrl;

    @SerializedName("show_left_button")
    private int showLeftButton;

    public SearchEmoBannerInfo() {
        this(null, null, null, 0, 15, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) {
            return;
        }
        iPatchRedirector.redirect((short) 21, (Object) this);
    }

    public static /* synthetic */ SearchEmoBannerInfo copy$default(SearchEmoBannerInfo searchEmoBannerInfo, String str, String str2, String str3, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = searchEmoBannerInfo.bannerImage;
        }
        if ((i16 & 2) != 0) {
            str2 = searchEmoBannerInfo.bannerUrl;
        }
        if ((i16 & 4) != 0) {
            str3 = searchEmoBannerInfo.leftButtonUrl;
        }
        if ((i16 & 8) != 0) {
            i3 = searchEmoBannerInfo.showLeftButton;
        }
        return searchEmoBannerInfo.copy(str, str2, str3, i3);
    }

    @NotNull
    public final String component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.bannerImage;
    }

    @NotNull
    public final String component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.bannerUrl;
    }

    @NotNull
    public final String component3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.leftButtonUrl;
    }

    public final int component4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return this.showLeftButton;
    }

    @NotNull
    public final SearchEmoBannerInfo copy(@NotNull String bannerImage, @NotNull String bannerUrl, @NotNull String leftButtonUrl, int showLeftButton) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (SearchEmoBannerInfo) iPatchRedirector.redirect((short) 17, this, bannerImage, bannerUrl, leftButtonUrl, Integer.valueOf(showLeftButton));
        }
        Intrinsics.checkNotNullParameter(bannerImage, "bannerImage");
        Intrinsics.checkNotNullParameter(bannerUrl, "bannerUrl");
        Intrinsics.checkNotNullParameter(leftButtonUrl, "leftButtonUrl");
        return new SearchEmoBannerInfo(bannerImage, bannerUrl, leftButtonUrl, showLeftButton);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchEmoBannerInfo)) {
            return false;
        }
        SearchEmoBannerInfo searchEmoBannerInfo = (SearchEmoBannerInfo) other;
        if (Intrinsics.areEqual(this.bannerImage, searchEmoBannerInfo.bannerImage) && Intrinsics.areEqual(this.bannerUrl, searchEmoBannerInfo.bannerUrl) && Intrinsics.areEqual(this.leftButtonUrl, searchEmoBannerInfo.leftButtonUrl) && this.showLeftButton == searchEmoBannerInfo.showLeftButton) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getBannerImage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.bannerImage;
    }

    @NotNull
    public final String getBannerUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.bannerUrl;
    }

    @NotNull
    public final String getLeftButtonUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.leftButtonUrl;
    }

    public final int getShowLeftButton() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.showLeftButton;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        return (((((this.bannerImage.hashCode() * 31) + this.bannerUrl.hashCode()) * 31) + this.leftButtonUrl.hashCode()) * 31) + this.showLeftButton;
    }

    public final boolean isBannerValid() {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        if (this.bannerImage.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (this.bannerUrl.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                return true;
            }
        }
        return false;
    }

    public final boolean isLeftButtonValid() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        if (this.showLeftButton != 1) {
            return false;
        }
        if (this.leftButtonUrl.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    public final void setBannerImage(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.bannerImage = str;
        }
    }

    public final void setBannerUrl(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.bannerUrl = str;
        }
    }

    public final void setLeftButtonUrl(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.leftButtonUrl = str;
        }
    }

    public final void setShowLeftButton(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.showLeftButton = i3;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return "SearchEmoBannerInfo(bannerImage=" + this.bannerImage + ", bannerUrl=" + this.bannerUrl + ", leftButtonUrl=" + this.leftButtonUrl + ", showLeftButton=" + this.showLeftButton + ")";
    }

    public SearchEmoBannerInfo(@NotNull String bannerImage, @NotNull String bannerUrl, @NotNull String leftButtonUrl, int i3) {
        Intrinsics.checkNotNullParameter(bannerImage, "bannerImage");
        Intrinsics.checkNotNullParameter(bannerUrl, "bannerUrl");
        Intrinsics.checkNotNullParameter(leftButtonUrl, "leftButtonUrl");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bannerImage, bannerUrl, leftButtonUrl, Integer.valueOf(i3));
            return;
        }
        this.bannerImage = bannerImage;
        this.bannerUrl = bannerUrl;
        this.leftButtonUrl = leftButtonUrl;
        this.showLeftButton = i3;
    }

    public /* synthetic */ SearchEmoBannerInfo(String str, String str2, String str3, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? "" : str2, (i16 & 4) == 0 ? str3 : "", (i16 & 8) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, str3, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }
}
