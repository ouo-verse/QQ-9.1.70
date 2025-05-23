package com.tencent.mobileqq.activity.aio.zplan;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/zplan/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "intimateMainTitle", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "intimateSubTitle", "d", "intimateButtonTitle", "b", "intimateBackground", "a", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.activity.aio.zplan.d, reason: from toString */
/* loaded from: classes10.dex */
public final /* data */ class IntimateBannerConfig {

    @SerializedName("intimateBackground")
    @NotNull
    private final String intimateBackground;

    @SerializedName("intimateButtonTitle")
    @NotNull
    private final String intimateButtonTitle;

    @SerializedName("intimateMainTitle")
    @NotNull
    private final String intimateMainTitle;

    @SerializedName("intimateSubTitle")
    @NotNull
    private final String intimateSubTitle;

    public IntimateBannerConfig() {
        this(null, null, null, null, 15, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getIntimateBackground() {
        return this.intimateBackground;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getIntimateButtonTitle() {
        return this.intimateButtonTitle;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getIntimateMainTitle() {
        return this.intimateMainTitle;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getIntimateSubTitle() {
        return this.intimateSubTitle;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IntimateBannerConfig)) {
            return false;
        }
        IntimateBannerConfig intimateBannerConfig = (IntimateBannerConfig) other;
        if (Intrinsics.areEqual(this.intimateMainTitle, intimateBannerConfig.intimateMainTitle) && Intrinsics.areEqual(this.intimateSubTitle, intimateBannerConfig.intimateSubTitle) && Intrinsics.areEqual(this.intimateButtonTitle, intimateBannerConfig.intimateButtonTitle) && Intrinsics.areEqual(this.intimateBackground, intimateBannerConfig.intimateBackground)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.intimateMainTitle.hashCode() * 31) + this.intimateSubTitle.hashCode()) * 31) + this.intimateButtonTitle.hashCode()) * 31) + this.intimateBackground.hashCode();
    }

    @NotNull
    public String toString() {
        return "IntimateBannerConfig(intimateMainTitle=" + this.intimateMainTitle + ", intimateSubTitle=" + this.intimateSubTitle + ", intimateButtonTitle=" + this.intimateButtonTitle + ", intimateBackground=" + this.intimateBackground + ")";
    }

    public IntimateBannerConfig(@NotNull String intimateMainTitle, @NotNull String intimateSubTitle, @NotNull String intimateButtonTitle, @NotNull String intimateBackground) {
        Intrinsics.checkNotNullParameter(intimateMainTitle, "intimateMainTitle");
        Intrinsics.checkNotNullParameter(intimateSubTitle, "intimateSubTitle");
        Intrinsics.checkNotNullParameter(intimateButtonTitle, "intimateButtonTitle");
        Intrinsics.checkNotNullParameter(intimateBackground, "intimateBackground");
        this.intimateMainTitle = intimateMainTitle;
        this.intimateSubTitle = intimateSubTitle;
        this.intimateButtonTitle = intimateButtonTitle;
        this.intimateBackground = intimateBackground;
    }

    public /* synthetic */ IntimateBannerConfig(String str, String str2, String str3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "\u597d\u53cb\u65f6\u5149" : str, (i3 & 2) != 0 ? "\u8da3\u5473\u4e92\u52a8\u548c\u5168\u65b0\u804a\u5929\u80cc\u666f\uff0c\u5728\u804a\u5929\u8bbe\u7f6e\u4e2d\u53ef\u5173\u95ed" : str2, (i3 & 4) != 0 ? "\u53bb\u770b\u770b" : str3, (i3 & 8) != 0 ? "https://image.superqqshow.qq.com/qq/aio_love_space/banner.jpg" : str4);
    }
}
