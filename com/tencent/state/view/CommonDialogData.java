package com.tencent.state.view;

import android.view.View;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u0012J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u000eH\u00c6\u0003J\t\u0010$\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010(\u001a\u00020\nH\u00c6\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\fH\u00c6\u0003J\t\u0010*\u001a\u00020\u000eH\u00c6\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003Jy\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u000eH\u00c6\u0001J\u0013\u0010-\u001a\u00020\u000e2\b\u0010.\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010/\u001a\u000200H\u00d6\u0001J\t\u00101\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019\u00a8\u00062"}, d2 = {"Lcom/tencent/state/view/CommonDialogData;", "", "resStyle", "Lcom/tencent/state/view/ResStyle;", "title", "", "leftButton", "rightButton", "midButton", "contentStyle", "Lcom/tencent/state/view/ContentStyle;", "contentView", "Landroid/view/View;", "isShowCloseButton", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "Lcom/tencent/state/view/CommonDialogReportParams;", "noTitle", "(Lcom/tencent/state/view/ResStyle;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/state/view/ContentStyle;Landroid/view/View;ZLcom/tencent/state/view/CommonDialogReportParams;Z)V", "getContentStyle", "()Lcom/tencent/state/view/ContentStyle;", "getContentView", "()Landroid/view/View;", "()Z", "getLeftButton", "()Ljava/lang/String;", "getMidButton", "getNoTitle", "getReportParams", "()Lcom/tencent/state/view/CommonDialogReportParams;", "getResStyle", "()Lcom/tencent/state/view/ResStyle;", "getRightButton", "getTitle", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class CommonDialogData {
    private final ContentStyle contentStyle;
    private final View contentView;
    private final boolean isShowCloseButton;
    private final String leftButton;
    private final String midButton;
    private final boolean noTitle;
    private final CommonDialogReportParams reportParams;
    private final ResStyle resStyle;
    private final String rightButton;
    private final String title;

    public CommonDialogData(ResStyle resStyle, String title, String str, String str2, String str3, ContentStyle contentStyle, View view, boolean z16, CommonDialogReportParams commonDialogReportParams, boolean z17) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(contentStyle, "contentStyle");
        this.resStyle = resStyle;
        this.title = title;
        this.leftButton = str;
        this.rightButton = str2;
        this.midButton = str3;
        this.contentStyle = contentStyle;
        this.contentView = view;
        this.isShowCloseButton = z16;
        this.reportParams = commonDialogReportParams;
        this.noTitle = z17;
    }

    /* renamed from: component1, reason: from getter */
    public final ResStyle getResStyle() {
        return this.resStyle;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getNoTitle() {
        return this.noTitle;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final String getLeftButton() {
        return this.leftButton;
    }

    /* renamed from: component4, reason: from getter */
    public final String getRightButton() {
        return this.rightButton;
    }

    /* renamed from: component5, reason: from getter */
    public final String getMidButton() {
        return this.midButton;
    }

    /* renamed from: component6, reason: from getter */
    public final ContentStyle getContentStyle() {
        return this.contentStyle;
    }

    /* renamed from: component7, reason: from getter */
    public final View getContentView() {
        return this.contentView;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getIsShowCloseButton() {
        return this.isShowCloseButton;
    }

    /* renamed from: component9, reason: from getter */
    public final CommonDialogReportParams getReportParams() {
        return this.reportParams;
    }

    public final CommonDialogData copy(ResStyle resStyle, String title, String leftButton, String rightButton, String midButton, ContentStyle contentStyle, View contentView, boolean isShowCloseButton, CommonDialogReportParams reportParams, boolean noTitle) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(contentStyle, "contentStyle");
        return new CommonDialogData(resStyle, title, leftButton, rightButton, midButton, contentStyle, contentView, isShowCloseButton, reportParams, noTitle);
    }

    public final ContentStyle getContentStyle() {
        return this.contentStyle;
    }

    public final View getContentView() {
        return this.contentView;
    }

    public final String getLeftButton() {
        return this.leftButton;
    }

    public final String getMidButton() {
        return this.midButton;
    }

    public final boolean getNoTitle() {
        return this.noTitle;
    }

    public final CommonDialogReportParams getReportParams() {
        return this.reportParams;
    }

    public final ResStyle getResStyle() {
        return this.resStyle;
    }

    public final String getRightButton() {
        return this.rightButton;
    }

    public final String getTitle() {
        return this.title;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        ResStyle resStyle = this.resStyle;
        int hashCode = (resStyle != null ? resStyle.hashCode() : 0) * 31;
        String str = this.title;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.leftButton;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.rightButton;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.midButton;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        ContentStyle contentStyle = this.contentStyle;
        int hashCode6 = (hashCode5 + (contentStyle != null ? contentStyle.hashCode() : 0)) * 31;
        View view = this.contentView;
        int hashCode7 = (hashCode6 + (view != null ? view.hashCode() : 0)) * 31;
        boolean z16 = this.isShowCloseButton;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode7 + i3) * 31;
        CommonDialogReportParams commonDialogReportParams = this.reportParams;
        int hashCode8 = (i16 + (commonDialogReportParams != null ? commonDialogReportParams.hashCode() : 0)) * 31;
        boolean z17 = this.noTitle;
        return hashCode8 + (z17 ? 1 : z17 ? 1 : 0);
    }

    public final boolean isShowCloseButton() {
        return this.isShowCloseButton;
    }

    public String toString() {
        return "CommonDialogData(resStyle=" + this.resStyle + ", title=" + this.title + ", leftButton=" + this.leftButton + ", rightButton=" + this.rightButton + ", midButton=" + this.midButton + ", contentStyle=" + this.contentStyle + ", contentView=" + this.contentView + ", isShowCloseButton=" + this.isShowCloseButton + ", reportParams=" + this.reportParams + ", noTitle=" + this.noTitle + ")";
    }

    public /* synthetic */ CommonDialogData(ResStyle resStyle, String str, String str2, String str3, String str4, ContentStyle contentStyle, View view, boolean z16, CommonDialogReportParams commonDialogReportParams, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(resStyle, str, str2, str3, str4, contentStyle, (i3 & 64) != 0 ? null : view, (i3 & 128) != 0 ? false : z16, (i3 & 256) != 0 ? null : commonDialogReportParams, (i3 & 512) != 0 ? false : z17);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommonDialogData)) {
            return false;
        }
        CommonDialogData commonDialogData = (CommonDialogData) other;
        return Intrinsics.areEqual(this.resStyle, commonDialogData.resStyle) && Intrinsics.areEqual(this.title, commonDialogData.title) && Intrinsics.areEqual(this.leftButton, commonDialogData.leftButton) && Intrinsics.areEqual(this.rightButton, commonDialogData.rightButton) && Intrinsics.areEqual(this.midButton, commonDialogData.midButton) && Intrinsics.areEqual(this.contentStyle, commonDialogData.contentStyle) && Intrinsics.areEqual(this.contentView, commonDialogData.contentView) && this.isShowCloseButton == commonDialogData.isShowCloseButton && Intrinsics.areEqual(this.reportParams, commonDialogData.reportParams) && this.noTitle == commonDialogData.noTitle;
    }
}
