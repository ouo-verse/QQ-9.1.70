package com.tencent.sqshow.utils.featureswitch.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/sqshow/utils/featureswitch/model/k;", "", "", "toString", "", "hashCode", "other", "", "equals", "backgroundId", "I", "getBackgroundId", "()I", "url", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "themeColor", "b", "textColor", "a", "qrcodeColor", "getQrcodeColor", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.utils.featureswitch.model.k, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ShareBackground {

    @SerializedName("backgroundId")
    private final int backgroundId;

    @SerializedName("qrcodeColor")
    private final String qrcodeColor;

    @SerializedName("textColor")
    private final String textColor;

    @SerializedName("themeColor")
    private final String themeColor;

    @SerializedName("url")
    private final String url;

    public ShareBackground() {
        this(0, null, null, null, null, 31, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getTextColor() {
        return this.textColor;
    }

    /* renamed from: b, reason: from getter */
    public final String getThemeColor() {
        return this.themeColor;
    }

    /* renamed from: c, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (((((((this.backgroundId * 31) + this.url.hashCode()) * 31) + this.themeColor.hashCode()) * 31) + this.textColor.hashCode()) * 31) + this.qrcodeColor.hashCode();
    }

    public String toString() {
        return "ShareBackground(backgroundId=" + this.backgroundId + ", url=" + this.url + ", themeColor=" + this.themeColor + ", textColor=" + this.textColor + ", qrcodeColor=" + this.qrcodeColor + ')';
    }

    public ShareBackground(int i3, String url, String themeColor, String textColor, String qrcodeColor) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(themeColor, "themeColor");
        Intrinsics.checkNotNullParameter(textColor, "textColor");
        Intrinsics.checkNotNullParameter(qrcodeColor, "qrcodeColor");
        this.backgroundId = i3;
        this.url = url;
        this.themeColor = themeColor;
        this.textColor = textColor;
        this.qrcodeColor = qrcodeColor;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShareBackground)) {
            return false;
        }
        ShareBackground shareBackground = (ShareBackground) other;
        return this.backgroundId == shareBackground.backgroundId && Intrinsics.areEqual(this.url, shareBackground.url) && Intrinsics.areEqual(this.themeColor, shareBackground.themeColor) && Intrinsics.areEqual(this.textColor, shareBackground.textColor) && Intrinsics.areEqual(this.qrcodeColor, shareBackground.qrcodeColor);
    }

    public /* synthetic */ ShareBackground(int i3, String str, String str2, String str3, String str4, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? "" : str, (i16 & 4) != 0 ? "" : str2, (i16 & 8) == 0 ? str3 : "", (i16 & 16) != 0 ? "#000000" : str4);
    }
}
