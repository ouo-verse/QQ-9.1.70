package com.tencent.sqshow.utils.featureswitch.model;

import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u0019\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0010R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006 "}, d2 = {"Lcom/tencent/sqshow/utils/featureswitch/model/aj;", "", "", "toString", "", "hashCode", "other", "", "equals", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ACTION_ID, "I", "a", "()I", "backgroundUrl", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "desc", "c", "fontColor", "d", "qrForegroundColor", "g", "qrBackgroundColor", "f", "", "gradientColors", "Ljava/util/List;", "e", "()Ljava/util/List;", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.utils.featureswitch.model.aj, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZPlanShareItem {

    @SerializedName(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ACTION_ID)
    private final int actionID;

    @SerializedName("backgroundUrl")
    private final String backgroundUrl;

    @SerializedName("desc")
    private final String desc;

    @SerializedName("fontColor")
    private final String fontColor;

    @SerializedName("gradientColors")
    private final List<String> gradientColors;

    @SerializedName("qrBackgroundColor")
    private final String qrBackgroundColor;

    @SerializedName("qrForegroundColor")
    private final String qrForegroundColor;

    public ZPlanShareItem() {
        this(0, null, null, null, null, null, null, 127, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getActionID() {
        return this.actionID;
    }

    /* renamed from: b, reason: from getter */
    public final String getBackgroundUrl() {
        return this.backgroundUrl;
    }

    /* renamed from: c, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    /* renamed from: d, reason: from getter */
    public final String getFontColor() {
        return this.fontColor;
    }

    public final List<String> e() {
        return this.gradientColors;
    }

    /* renamed from: f, reason: from getter */
    public final String getQrBackgroundColor() {
        return this.qrBackgroundColor;
    }

    /* renamed from: g, reason: from getter */
    public final String getQrForegroundColor() {
        return this.qrForegroundColor;
    }

    public int hashCode() {
        return (((((((((((this.actionID * 31) + this.backgroundUrl.hashCode()) * 31) + this.desc.hashCode()) * 31) + this.fontColor.hashCode()) * 31) + this.qrForegroundColor.hashCode()) * 31) + this.qrBackgroundColor.hashCode()) * 31) + this.gradientColors.hashCode();
    }

    public String toString() {
        return "ZPlanShareItem(actionID=" + this.actionID + ", backgroundUrl=" + this.backgroundUrl + ", desc=" + this.desc + ", fontColor=" + this.fontColor + ", qrForegroundColor=" + this.qrForegroundColor + ", qrBackgroundColor=" + this.qrBackgroundColor + ", gradientColors=" + this.gradientColors + ')';
    }

    public ZPlanShareItem(int i3, String backgroundUrl, String desc, String fontColor, String qrForegroundColor, String qrBackgroundColor, List<String> gradientColors) {
        Intrinsics.checkNotNullParameter(backgroundUrl, "backgroundUrl");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(fontColor, "fontColor");
        Intrinsics.checkNotNullParameter(qrForegroundColor, "qrForegroundColor");
        Intrinsics.checkNotNullParameter(qrBackgroundColor, "qrBackgroundColor");
        Intrinsics.checkNotNullParameter(gradientColors, "gradientColors");
        this.actionID = i3;
        this.backgroundUrl = backgroundUrl;
        this.desc = desc;
        this.fontColor = fontColor;
        this.qrForegroundColor = qrForegroundColor;
        this.qrBackgroundColor = qrBackgroundColor;
        this.gradientColors = gradientColors;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanShareItem)) {
            return false;
        }
        ZPlanShareItem zPlanShareItem = (ZPlanShareItem) other;
        return this.actionID == zPlanShareItem.actionID && Intrinsics.areEqual(this.backgroundUrl, zPlanShareItem.backgroundUrl) && Intrinsics.areEqual(this.desc, zPlanShareItem.desc) && Intrinsics.areEqual(this.fontColor, zPlanShareItem.fontColor) && Intrinsics.areEqual(this.qrForegroundColor, zPlanShareItem.qrForegroundColor) && Intrinsics.areEqual(this.qrBackgroundColor, zPlanShareItem.qrBackgroundColor) && Intrinsics.areEqual(this.gradientColors, zPlanShareItem.gradientColors);
    }

    public /* synthetic */ ZPlanShareItem(int i3, String str, String str2, String str3, String str4, String str5, List list, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 6580 : i3, (i16 & 2) != 0 ? "https://zplan-image-1300343094.cos.ap-nanjing.myqcloud.com/qq/share/normal.jpg" : str, (i16 & 4) != 0 ? "{nick}\u7684\u65f6\u5c1a\u7a7f\u642d" : str2, (i16 & 8) != 0 ? "#000000" : str3, (i16 & 16) != 0 ? "#FF000000" : str4, (i16 & 32) != 0 ? "#00000000" : str5, (i16 & 64) != 0 ? CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"#fffff2f6", "#fffff2f6"}) : list);
    }
}
