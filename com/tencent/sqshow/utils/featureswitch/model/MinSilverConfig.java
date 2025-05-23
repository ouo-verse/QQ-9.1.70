package com.tencent.sqshow.utils.featureswitch.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\fR\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\fR\u001a\u0010\u0017\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\u001a\u0010\u001d\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\u00a8\u0006!"}, d2 = {"Lcom/tencent/sqshow/utils/featureswitch/model/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "startTipText", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "endTipText", "b", "buttonTitle", "a", "maleUrl", "d", "femaleUrl", "c", "schemeUrl", "e", "todayShowTimes", "I", "g", "()I", "totalDays", tl.h.F, "totalShowTimes", "i", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;III)V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.utils.featureswitch.model.e, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class MinSilverConfig {

    @SerializedName("buttonTitle")
    private final String buttonTitle;

    @SerializedName("endTipText")
    private final String endTipText;

    @SerializedName("femaleUrl")
    private final String femaleUrl;

    @SerializedName("maleUrl")
    private final String maleUrl;

    @SerializedName("schemeUrl")
    private final String schemeUrl;

    @SerializedName("startTipText")
    private final String startTipText;

    @SerializedName("todayShowTimes")
    private final int todayShowTimes;

    @SerializedName("totalDays")
    private final int totalDays;

    @SerializedName("totalShowTimes")
    private final int totalShowTimes;

    public MinSilverConfig() {
        this(null, null, null, null, null, null, 0, 0, 0, 511, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getButtonTitle() {
        return this.buttonTitle;
    }

    /* renamed from: b, reason: from getter */
    public final String getEndTipText() {
        return this.endTipText;
    }

    /* renamed from: c, reason: from getter */
    public final String getFemaleUrl() {
        return this.femaleUrl;
    }

    /* renamed from: d, reason: from getter */
    public final String getMaleUrl() {
        return this.maleUrl;
    }

    /* renamed from: e, reason: from getter */
    public final String getSchemeUrl() {
        return this.schemeUrl;
    }

    /* renamed from: f, reason: from getter */
    public final String getStartTipText() {
        return this.startTipText;
    }

    /* renamed from: g, reason: from getter */
    public final int getTodayShowTimes() {
        return this.todayShowTimes;
    }

    /* renamed from: h, reason: from getter */
    public final int getTotalDays() {
        return this.totalDays;
    }

    public int hashCode() {
        return (((((((((((((((this.startTipText.hashCode() * 31) + this.endTipText.hashCode()) * 31) + this.buttonTitle.hashCode()) * 31) + this.maleUrl.hashCode()) * 31) + this.femaleUrl.hashCode()) * 31) + this.schemeUrl.hashCode()) * 31) + this.todayShowTimes) * 31) + this.totalDays) * 31) + this.totalShowTimes;
    }

    /* renamed from: i, reason: from getter */
    public final int getTotalShowTimes() {
        return this.totalShowTimes;
    }

    public String toString() {
        return "MinSilverConfig(startTipText=" + this.startTipText + ", endTipText=" + this.endTipText + ", buttonTitle=" + this.buttonTitle + ", maleUrl=" + this.maleUrl + ", femaleUrl=" + this.femaleUrl + ", schemeUrl=" + this.schemeUrl + ", todayShowTimes=" + this.todayShowTimes + ", totalDays=" + this.totalDays + ", totalShowTimes=" + this.totalShowTimes + ')';
    }

    public MinSilverConfig(String startTipText, String endTipText, String buttonTitle, String maleUrl, String femaleUrl, String schemeUrl, int i3, int i16, int i17) {
        Intrinsics.checkNotNullParameter(startTipText, "startTipText");
        Intrinsics.checkNotNullParameter(endTipText, "endTipText");
        Intrinsics.checkNotNullParameter(buttonTitle, "buttonTitle");
        Intrinsics.checkNotNullParameter(maleUrl, "maleUrl");
        Intrinsics.checkNotNullParameter(femaleUrl, "femaleUrl");
        Intrinsics.checkNotNullParameter(schemeUrl, "schemeUrl");
        this.startTipText = startTipText;
        this.endTipText = endTipText;
        this.buttonTitle = buttonTitle;
        this.maleUrl = maleUrl;
        this.femaleUrl = femaleUrl;
        this.schemeUrl = schemeUrl;
        this.todayShowTimes = i3;
        this.totalDays = i16;
        this.totalShowTimes = i17;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MinSilverConfig)) {
            return false;
        }
        MinSilverConfig minSilverConfig = (MinSilverConfig) other;
        return Intrinsics.areEqual(this.startTipText, minSilverConfig.startTipText) && Intrinsics.areEqual(this.endTipText, minSilverConfig.endTipText) && Intrinsics.areEqual(this.buttonTitle, minSilverConfig.buttonTitle) && Intrinsics.areEqual(this.maleUrl, minSilverConfig.maleUrl) && Intrinsics.areEqual(this.femaleUrl, minSilverConfig.femaleUrl) && Intrinsics.areEqual(this.schemeUrl, minSilverConfig.schemeUrl) && this.todayShowTimes == minSilverConfig.todayShowTimes && this.totalDays == minSilverConfig.totalDays && this.totalShowTimes == minSilverConfig.totalShowTimes;
    }

    public /* synthetic */ MinSilverConfig(String str, String str2, String str3, String str4, String str5, String str6, int i3, int i16, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? "\u4f60\u7684\u94f6\u5e01\u4f59\u989d\u5df2\u4e0d\u8db3 " : str, (i18 & 2) != 0 ? "\uff0c\u5feb\u53bb\u5b8c\u6210\u6bcf\u65e5\u4efb\u52a1\u8d5a\u53d6\u94f6\u5e01\u5427\uff01" : str2, (i18 & 4) != 0 ? "\u53bb\u8d5a\u94f6\u5e01" : str3, (i18 & 8) != 0 ? "https://image.superqqshow.qq.com/qq/sliver_guide/silver_guide_top_male.jpg" : str4, (i18 & 16) != 0 ? "https://image.superqqshow.qq.com/qq/sliver_guide/silver_guide_top_female.jpg" : str5, (i18 & 32) != 0 ? "mqqapi://zplan/openPage?src_type=app&version=1.0&referer=1001&pageID=9&sceneData=%7B%22SubScene%22%3A%7B%22SceneParams%22%3A%7B%22JumpToSource%22%3A%22pg_zplan_avatar_mall%22%7D%7D%7D" : str6, (i18 & 64) != 0 ? 1 : i3, (i18 & 128) != 0 ? 7 : i16, (i18 & 256) != 0 ? 2 : i17);
    }
}
