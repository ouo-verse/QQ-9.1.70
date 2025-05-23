package com.tencent.sqshow.utils.featureswitch.model;

import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\fR\u001a\u0010\u0014\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\fR\u001a\u0010\u0016\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/sqshow/utils/featureswitch/model/n;", "", "", "toString", "", "hashCode", "other", "", "equals", "mainTitle", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setMainTitle", "(Ljava/lang/String;)V", QQWinkConstants.TAB_SUBTITLE, "e", "setSubTitle", "buttonTitle", "b", "backgroundUrl", "a", "showTimes", "I", "d", "()I", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.utils.featureswitch.model.n, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class SuperQQShowConfig {

    @SerializedName("backgroundUrl")
    private final String backgroundUrl;

    @SerializedName("buttonTitle")
    private final String buttonTitle;

    @SerializedName("mainTitle")
    private String mainTitle;

    @SerializedName("showTimes")
    private final int showTimes;

    @SerializedName(QQWinkConstants.TAB_SUBTITLE)
    private String subTitle;

    public SuperQQShowConfig() {
        this(null, null, null, null, 0, 31, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getBackgroundUrl() {
        return this.backgroundUrl;
    }

    /* renamed from: b, reason: from getter */
    public final String getButtonTitle() {
        return this.buttonTitle;
    }

    /* renamed from: c, reason: from getter */
    public final String getMainTitle() {
        return this.mainTitle;
    }

    /* renamed from: d, reason: from getter */
    public final int getShowTimes() {
        return this.showTimes;
    }

    /* renamed from: e, reason: from getter */
    public final String getSubTitle() {
        return this.subTitle;
    }

    public int hashCode() {
        return (((((((this.mainTitle.hashCode() * 31) + this.subTitle.hashCode()) * 31) + this.buttonTitle.hashCode()) * 31) + this.backgroundUrl.hashCode()) * 31) + this.showTimes;
    }

    public String toString() {
        return "SuperQQShowConfig(mainTitle=" + this.mainTitle + ", subTitle=" + this.subTitle + ", buttonTitle=" + this.buttonTitle + ", backgroundUrl=" + this.backgroundUrl + ", showTimes=" + this.showTimes + ')';
    }

    public SuperQQShowConfig(String mainTitle, String subTitle, String buttonTitle, String backgroundUrl, int i3) {
        Intrinsics.checkNotNullParameter(mainTitle, "mainTitle");
        Intrinsics.checkNotNullParameter(subTitle, "subTitle");
        Intrinsics.checkNotNullParameter(buttonTitle, "buttonTitle");
        Intrinsics.checkNotNullParameter(backgroundUrl, "backgroundUrl");
        this.mainTitle = mainTitle;
        this.subTitle = subTitle;
        this.buttonTitle = buttonTitle;
        this.backgroundUrl = backgroundUrl;
        this.showTimes = i3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SuperQQShowConfig)) {
            return false;
        }
        SuperQQShowConfig superQQShowConfig = (SuperQQShowConfig) other;
        return Intrinsics.areEqual(this.mainTitle, superQQShowConfig.mainTitle) && Intrinsics.areEqual(this.subTitle, superQQShowConfig.subTitle) && Intrinsics.areEqual(this.buttonTitle, superQQShowConfig.buttonTitle) && Intrinsics.areEqual(this.backgroundUrl, superQQShowConfig.backgroundUrl) && this.showTimes == superQQShowConfig.showTimes;
    }

    public /* synthetic */ SuperQQShowConfig(String str, String str2, String str3, String str4, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "\u5f00\u542f\u597d\u53cb\u65f6\u5149" : str, (i16 & 2) != 0 ? "\u8da3\u5473\u4e92\u52a8\u548c\u5168\u65b0\u804a\u5929\u80cc\u666f\uff0c\u53ef\u5728\u804a\u5929\u8bbe\u7f6e\u4e2d\u5173\u95ed" : str2, (i16 & 4) != 0 ? "\u7acb\u523b\u4f53\u9a8c" : str3, (i16 & 8) != 0 ? "https://image.superqqshow.qq.com/qq/aio_love_space/fuceng_v2.webp" : str4, (i16 & 16) != 0 ? 3 : i3);
    }
}
