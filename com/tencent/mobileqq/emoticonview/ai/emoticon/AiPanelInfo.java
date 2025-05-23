package com.tencent.mobileqq.emoticonview.ai.emoticon;

import androidx.fragment.app.a;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u000fJ\t\u0010*\u001a\u00020\u0003H\u00c6\u0003J\t\u0010+\u001a\u00020\u0003H\u00c6\u0003J\t\u0010,\u001a\u00020\u000eH\u00c6\u0003J\t\u0010-\u001a\u00020\u0003H\u00c6\u0003J\t\u0010.\u001a\u00020\u0003H\u00c6\u0003J\t\u0010/\u001a\u00020\u0003H\u00c6\u0003J\t\u00100\u001a\u00020\u0003H\u00c6\u0003J\t\u00101\u001a\u00020\u0003H\u00c6\u0003J\t\u00102\u001a\u00020\u0003H\u00c6\u0003J\t\u00103\u001a\u00020\u0003H\u00c6\u0003J\t\u00104\u001a\u00020\u0003H\u00c6\u0003Jw\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000eH\u00c6\u0001J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00109\u001a\u00020:H\u00d6\u0001J\u0006\u0010;\u001a\u000207J\u0006\u0010<\u001a\u000207J\u0006\u0010=\u001a\u000207J\u0006\u0010>\u001a\u000207J\u0006\u0010?\u001a\u000207J\t\u0010@\u001a\u00020\u0003H\u00d6\u0001R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\u001e\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0011\"\u0004\b!\u0010\u0013R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0011\"\u0004\b)\u0010\u0013\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/ai/emoticon/AiPanelInfo;", "", "mainPage", "", "settingPage", "posterImage", "posterApng", "posterPage", "bannerImage", "bannerApng", "bannerPage", "bannerRedDotImage", "makeSamePage", "refreshTimeStep", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getBannerApng", "()Ljava/lang/String;", "setBannerApng", "(Ljava/lang/String;)V", "getBannerImage", "setBannerImage", "getBannerPage", "setBannerPage", "getBannerRedDotImage", "setBannerRedDotImage", "getMainPage", "setMainPage", "getMakeSamePage", "setMakeSamePage", "getPosterApng", "setPosterApng", "getPosterImage", "setPosterImage", "getPosterPage", "setPosterPage", "getRefreshTimeStep", "()J", "setRefreshTimeStep", "(J)V", "getSettingPage", "setSettingPage", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "isApngBanner", "isBannerConfigValid", "isMainPageValid", "isPosterPageValid", "isSettingPageValid", "toString", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final /* data */ class AiPanelInfo {
    static IPatchRedirector $redirector_;

    @SerializedName("banner_apng")
    @NotNull
    private String bannerApng;

    @SerializedName("banner_image")
    @NotNull
    private String bannerImage;

    @SerializedName("banner_page")
    @NotNull
    private String bannerPage;

    @SerializedName("banner_red_image")
    @NotNull
    private String bannerRedDotImage;

    @SerializedName("main_page")
    @NotNull
    private String mainPage;

    @SerializedName("make_same_page")
    @NotNull
    private String makeSamePage;

    @SerializedName("poster_apng")
    @NotNull
    private String posterApng;

    @SerializedName("poster_image")
    @NotNull
    private String posterImage;

    @SerializedName("poster_page")
    @NotNull
    private String posterPage;

    @SerializedName("refresh_time_step")
    private long refreshTimeStep;

    @SerializedName("setting_page")
    @NotNull
    private String settingPage;

    public AiPanelInfo() {
        this(null, null, null, null, null, null, null, null, null, null, 0L, 2047, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 45)) {
            return;
        }
        iPatchRedirector.redirect((short) 45, (Object) this);
    }

    public static /* synthetic */ AiPanelInfo copy$default(AiPanelInfo aiPanelInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, long j3, int i3, Object obj) {
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        long j16;
        if ((i3 & 1) != 0) {
            str11 = aiPanelInfo.mainPage;
        } else {
            str11 = str;
        }
        if ((i3 & 2) != 0) {
            str12 = aiPanelInfo.settingPage;
        } else {
            str12 = str2;
        }
        if ((i3 & 4) != 0) {
            str13 = aiPanelInfo.posterImage;
        } else {
            str13 = str3;
        }
        if ((i3 & 8) != 0) {
            str14 = aiPanelInfo.posterApng;
        } else {
            str14 = str4;
        }
        if ((i3 & 16) != 0) {
            str15 = aiPanelInfo.posterPage;
        } else {
            str15 = str5;
        }
        if ((i3 & 32) != 0) {
            str16 = aiPanelInfo.bannerImage;
        } else {
            str16 = str6;
        }
        if ((i3 & 64) != 0) {
            str17 = aiPanelInfo.bannerApng;
        } else {
            str17 = str7;
        }
        if ((i3 & 128) != 0) {
            str18 = aiPanelInfo.bannerPage;
        } else {
            str18 = str8;
        }
        if ((i3 & 256) != 0) {
            str19 = aiPanelInfo.bannerRedDotImage;
        } else {
            str19 = str9;
        }
        if ((i3 & 512) != 0) {
            str20 = aiPanelInfo.makeSamePage;
        } else {
            str20 = str10;
        }
        if ((i3 & 1024) != 0) {
            j16 = aiPanelInfo.refreshTimeStep;
        } else {
            j16 = j3;
        }
        return aiPanelInfo.copy(str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, j16);
    }

    @NotNull
    public final String component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (String) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return this.mainPage;
    }

    @NotNull
    public final String component10() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (String) iPatchRedirector.redirect((short) 39, (Object) this);
        }
        return this.makeSamePage;
    }

    public final long component11() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Long) iPatchRedirector.redirect((short) 40, (Object) this)).longValue();
        }
        return this.refreshTimeStep;
    }

    @NotNull
    public final String component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (String) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        return this.settingPage;
    }

    @NotNull
    public final String component3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (String) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        return this.posterImage;
    }

    @NotNull
    public final String component4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (String) iPatchRedirector.redirect((short) 33, (Object) this);
        }
        return this.posterApng;
    }

    @NotNull
    public final String component5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (String) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        return this.posterPage;
    }

    @NotNull
    public final String component6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (String) iPatchRedirector.redirect((short) 35, (Object) this);
        }
        return this.bannerImage;
    }

    @NotNull
    public final String component7() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (String) iPatchRedirector.redirect((short) 36, (Object) this);
        }
        return this.bannerApng;
    }

    @NotNull
    public final String component8() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (String) iPatchRedirector.redirect((short) 37, (Object) this);
        }
        return this.bannerPage;
    }

    @NotNull
    public final String component9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (String) iPatchRedirector.redirect((short) 38, (Object) this);
        }
        return this.bannerRedDotImage;
    }

    @NotNull
    public final AiPanelInfo copy(@NotNull String mainPage, @NotNull String settingPage, @NotNull String posterImage, @NotNull String posterApng, @NotNull String posterPage, @NotNull String bannerImage, @NotNull String bannerApng, @NotNull String bannerPage, @NotNull String bannerRedDotImage, @NotNull String makeSamePage, long refreshTimeStep) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return (AiPanelInfo) iPatchRedirector.redirect((short) 41, this, mainPage, settingPage, posterImage, posterApng, posterPage, bannerImage, bannerApng, bannerPage, bannerRedDotImage, makeSamePage, Long.valueOf(refreshTimeStep));
        }
        Intrinsics.checkNotNullParameter(mainPage, "mainPage");
        Intrinsics.checkNotNullParameter(settingPage, "settingPage");
        Intrinsics.checkNotNullParameter(posterImage, "posterImage");
        Intrinsics.checkNotNullParameter(posterApng, "posterApng");
        Intrinsics.checkNotNullParameter(posterPage, "posterPage");
        Intrinsics.checkNotNullParameter(bannerImage, "bannerImage");
        Intrinsics.checkNotNullParameter(bannerApng, "bannerApng");
        Intrinsics.checkNotNullParameter(bannerPage, "bannerPage");
        Intrinsics.checkNotNullParameter(bannerRedDotImage, "bannerRedDotImage");
        Intrinsics.checkNotNullParameter(makeSamePage, "makeSamePage");
        return new AiPanelInfo(mainPage, settingPage, posterImage, posterApng, posterPage, bannerImage, bannerApng, bannerPage, bannerRedDotImage, makeSamePage, refreshTimeStep);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return ((Boolean) iPatchRedirector.redirect((short) 44, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof AiPanelInfo)) {
            return false;
        }
        AiPanelInfo aiPanelInfo = (AiPanelInfo) other;
        if (Intrinsics.areEqual(this.mainPage, aiPanelInfo.mainPage) && Intrinsics.areEqual(this.settingPage, aiPanelInfo.settingPage) && Intrinsics.areEqual(this.posterImage, aiPanelInfo.posterImage) && Intrinsics.areEqual(this.posterApng, aiPanelInfo.posterApng) && Intrinsics.areEqual(this.posterPage, aiPanelInfo.posterPage) && Intrinsics.areEqual(this.bannerImage, aiPanelInfo.bannerImage) && Intrinsics.areEqual(this.bannerApng, aiPanelInfo.bannerApng) && Intrinsics.areEqual(this.bannerPage, aiPanelInfo.bannerPage) && Intrinsics.areEqual(this.bannerRedDotImage, aiPanelInfo.bannerRedDotImage) && Intrinsics.areEqual(this.makeSamePage, aiPanelInfo.makeSamePage) && this.refreshTimeStep == aiPanelInfo.refreshTimeStep) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getBannerApng() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.bannerApng;
    }

    @NotNull
    public final String getBannerImage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.bannerImage;
    }

    @NotNull
    public final String getBannerPage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.bannerPage;
    }

    @NotNull
    public final String getBannerRedDotImage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.bannerRedDotImage;
    }

    @NotNull
    public final String getMainPage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mainPage;
    }

    @NotNull
    public final String getMakeSamePage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.makeSamePage;
    }

    @NotNull
    public final String getPosterApng() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.posterApng;
    }

    @NotNull
    public final String getPosterImage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.posterImage;
    }

    @NotNull
    public final String getPosterPage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.posterPage;
    }

    public final long getRefreshTimeStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Long) iPatchRedirector.redirect((short) 23, (Object) this)).longValue();
        }
        return this.refreshTimeStep;
    }

    @NotNull
    public final String getSettingPage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.settingPage;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return ((Integer) iPatchRedirector.redirect((short) 43, (Object) this)).intValue();
        }
        return (((((((((((((((((((this.mainPage.hashCode() * 31) + this.settingPage.hashCode()) * 31) + this.posterImage.hashCode()) * 31) + this.posterApng.hashCode()) * 31) + this.posterPage.hashCode()) * 31) + this.bannerImage.hashCode()) * 31) + this.bannerApng.hashCode()) * 31) + this.bannerPage.hashCode()) * 31) + this.bannerRedDotImage.hashCode()) * 31) + this.makeSamePage.hashCode()) * 31) + a.a(this.refreshTimeStep);
    }

    public final boolean isApngBanner() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this)).booleanValue();
        }
        if (this.bannerApng.length() > 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
    
        if (r0 != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean isBannerConfigValid() {
        boolean z16;
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        if (this.bannerApng.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (this.bannerImage.length() > 0) {
                z18 = true;
            } else {
                z18 = false;
            }
        }
        if (this.bannerPage.length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            return true;
        }
        return false;
    }

    public final boolean isMainPageValid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        if (this.mainPage.length() > 0) {
            return true;
        }
        return false;
    }

    public final boolean isPosterPageValid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
        }
        if (this.posterPage.length() > 0) {
            return true;
        }
        return false;
    }

    public final boolean isSettingPageValid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        if (this.settingPage.length() > 0) {
            return true;
        }
        return false;
    }

    public final void setBannerApng(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.bannerApng = str;
        }
    }

    public final void setBannerImage(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.bannerImage = str;
        }
    }

    public final void setBannerPage(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.bannerPage = str;
        }
    }

    public final void setBannerRedDotImage(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.bannerRedDotImage = str;
        }
    }

    public final void setMainPage(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.mainPage = str;
        }
    }

    public final void setMakeSamePage(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.makeSamePage = str;
        }
    }

    public final void setPosterApng(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.posterApng = str;
        }
    }

    public final void setPosterImage(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.posterImage = str;
        }
    }

    public final void setPosterPage(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.posterPage = str;
        }
    }

    public final void setRefreshTimeStep(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, j3);
        } else {
            this.refreshTimeStep = j3;
        }
    }

    public final void setSettingPage(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.settingPage = str;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (String) iPatchRedirector.redirect((short) 42, (Object) this);
        }
        return "AiPanelInfo(mainPage=" + this.mainPage + ", settingPage=" + this.settingPage + ", posterImage=" + this.posterImage + ", posterApng=" + this.posterApng + ", posterPage=" + this.posterPage + ", bannerImage=" + this.bannerImage + ", bannerApng=" + this.bannerApng + ", bannerPage=" + this.bannerPage + ", bannerRedDotImage=" + this.bannerRedDotImage + ", makeSamePage=" + this.makeSamePage + ", refreshTimeStep=" + this.refreshTimeStep + ")";
    }

    public AiPanelInfo(@NotNull String mainPage, @NotNull String settingPage, @NotNull String posterImage, @NotNull String posterApng, @NotNull String posterPage, @NotNull String bannerImage, @NotNull String bannerApng, @NotNull String bannerPage, @NotNull String bannerRedDotImage, @NotNull String makeSamePage, long j3) {
        Intrinsics.checkNotNullParameter(mainPage, "mainPage");
        Intrinsics.checkNotNullParameter(settingPage, "settingPage");
        Intrinsics.checkNotNullParameter(posterImage, "posterImage");
        Intrinsics.checkNotNullParameter(posterApng, "posterApng");
        Intrinsics.checkNotNullParameter(posterPage, "posterPage");
        Intrinsics.checkNotNullParameter(bannerImage, "bannerImage");
        Intrinsics.checkNotNullParameter(bannerApng, "bannerApng");
        Intrinsics.checkNotNullParameter(bannerPage, "bannerPage");
        Intrinsics.checkNotNullParameter(bannerRedDotImage, "bannerRedDotImage");
        Intrinsics.checkNotNullParameter(makeSamePage, "makeSamePage");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, mainPage, settingPage, posterImage, posterApng, posterPage, bannerImage, bannerApng, bannerPage, bannerRedDotImage, makeSamePage, Long.valueOf(j3));
            return;
        }
        this.mainPage = mainPage;
        this.settingPage = settingPage;
        this.posterImage = posterImage;
        this.posterApng = posterApng;
        this.posterPage = posterPage;
        this.bannerImage = bannerImage;
        this.bannerApng = bannerApng;
        this.bannerPage = bannerPage;
        this.bannerRedDotImage = bannerRedDotImage;
        this.makeSamePage = makeSamePage;
        this.refreshTimeStep = j3;
    }

    public /* synthetic */ AiPanelInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? "" : str5, (i3 & 32) != 0 ? "" : str6, (i3 & 64) != 0 ? "" : str7, (i3 & 128) != 0 ? "" : str8, (i3 & 256) != 0 ? "" : str9, (i3 & 512) != 0 ? "https://qun.qq.com/ai-emoji-store/index.html?_wwv=8192&_wv=16777219&page_from=3" : str10, (i3 & 1024) != 0 ? 3600L : j3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, Long.valueOf(j3), Integer.valueOf(i3), defaultConstructorMarker);
    }
}
