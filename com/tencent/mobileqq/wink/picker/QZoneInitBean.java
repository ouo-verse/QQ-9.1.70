package com.tencent.mobileqq.wink.picker;

import com.tencent.mobileqq.startup.step.InitSkin;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b-\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B?\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fB\u0087\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0013J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\u0003H\u00c6\u0003J\t\u0010+\u001a\u00020\u0003H\u00c6\u0003J\t\u0010,\u001a\u00020\u0003H\u00c6\u0003J\t\u0010-\u001a\u00020\u0003H\u00c6\u0003J\t\u0010.\u001a\u00020\u0005H\u00c6\u0003J\t\u0010/\u001a\u00020\u0005H\u00c6\u0003J\t\u00100\u001a\u00020\u0003H\u00c6\u0003J\t\u00101\u001a\u00020\u0005H\u00c6\u0003J\t\u00102\u001a\u00020\u0005H\u00c6\u0003J\t\u00103\u001a\u00020\u0005H\u00c6\u0003J\t\u00104\u001a\u00020\u0003H\u00c6\u0003J\t\u00105\u001a\u00020\u000bH\u00c6\u0003J\u008b\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u0003H\u00c6\u0001J\u0013\u00107\u001a\u00020\u00032\b\u00108\u001a\u0004\u0018\u000109H\u00d6\u0003J\t\u0010:\u001a\u00020\u0005H\u00d6\u0001J\t\u0010;\u001a\u00020\u000bH\u00d6\u0001R\u0011\u0010\u0010\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0011\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0015R\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u0011\u0010\u0012\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0011\u0010\t\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0017\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/QZoneInitBean;", "Lcom/tencent/mobileqq/wink/picker/InitBean;", "showNextStepButton", "", "nextStepMinMediaNum", "", "nextStepMaxMediaNum", "showVideoTemplateButton", "videoTemplateMinMediaNum", "videoTemplateMaxMediaNum", "topBannerTextContent", "", "(ZIIZIILjava/lang/String;)V", "maxVideoCountLimitNum", "showSelectionPanelThumbNail", "showSelectionPreview", "enableEdit", "isSingleSelectMode", "showTitlePublishMoodBtn", "(ZIIZIIIZLjava/lang/String;ZZZZ)V", "getEnableEdit", "()Z", "getMaxVideoCountLimitNum", "()I", "setMaxVideoCountLimitNum", "(I)V", "getNextStepMaxMediaNum", "getNextStepMinMediaNum", "getShowNextStepButton", "getShowSelectionPanelThumbNail", "setShowSelectionPanelThumbNail", "(Z)V", "getShowSelectionPreview", "getShowTitlePublishMoodBtn", "getShowVideoTemplateButton", "getTopBannerTextContent", "()Ljava/lang/String;", "setTopBannerTextContent", "(Ljava/lang/String;)V", "getVideoTemplateMaxMediaNum", "getVideoTemplateMinMediaNum", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final /* data */ class QZoneInitBean extends InitBean {
    private final boolean enableEdit;
    private final boolean isSingleSelectMode;
    private int maxVideoCountLimitNum;
    private final int nextStepMaxMediaNum;
    private final int nextStepMinMediaNum;
    private final boolean showNextStepButton;
    private boolean showSelectionPanelThumbNail;
    private final boolean showSelectionPreview;
    private final boolean showTitlePublishMoodBtn;
    private final boolean showVideoTemplateButton;

    @NotNull
    private String topBannerTextContent;
    private final int videoTemplateMaxMediaNum;
    private final int videoTemplateMinMediaNum;

    public QZoneInitBean() {
        this(false, 0, 0, false, 0, 0, 0, false, null, false, false, false, false, InitSkin.DRAWABLE_COUNT, null);
    }

    public static /* synthetic */ QZoneInitBean copy$default(QZoneInitBean qZoneInitBean, boolean z16, int i3, int i16, boolean z17, int i17, int i18, int i19, boolean z18, String str, boolean z19, boolean z26, boolean z27, boolean z28, int i26, Object obj) {
        boolean z29;
        int i27;
        int i28;
        boolean z36;
        int i29;
        int i36;
        int i37;
        boolean z37;
        String str2;
        boolean z38;
        boolean z39;
        boolean z46;
        boolean z47;
        if ((i26 & 1) != 0) {
            z29 = qZoneInitBean.showNextStepButton;
        } else {
            z29 = z16;
        }
        if ((i26 & 2) != 0) {
            i27 = qZoneInitBean.nextStepMinMediaNum;
        } else {
            i27 = i3;
        }
        if ((i26 & 4) != 0) {
            i28 = qZoneInitBean.nextStepMaxMediaNum;
        } else {
            i28 = i16;
        }
        if ((i26 & 8) != 0) {
            z36 = qZoneInitBean.showVideoTemplateButton;
        } else {
            z36 = z17;
        }
        if ((i26 & 16) != 0) {
            i29 = qZoneInitBean.videoTemplateMinMediaNum;
        } else {
            i29 = i17;
        }
        if ((i26 & 32) != 0) {
            i36 = qZoneInitBean.videoTemplateMaxMediaNum;
        } else {
            i36 = i18;
        }
        if ((i26 & 64) != 0) {
            i37 = qZoneInitBean.maxVideoCountLimitNum;
        } else {
            i37 = i19;
        }
        if ((i26 & 128) != 0) {
            z37 = qZoneInitBean.showSelectionPanelThumbNail;
        } else {
            z37 = z18;
        }
        if ((i26 & 256) != 0) {
            str2 = qZoneInitBean.topBannerTextContent;
        } else {
            str2 = str;
        }
        if ((i26 & 512) != 0) {
            z38 = qZoneInitBean.showSelectionPreview;
        } else {
            z38 = z19;
        }
        if ((i26 & 1024) != 0) {
            z39 = qZoneInitBean.enableEdit;
        } else {
            z39 = z26;
        }
        if ((i26 & 2048) != 0) {
            z46 = qZoneInitBean.isSingleSelectMode;
        } else {
            z46 = z27;
        }
        if ((i26 & 4096) != 0) {
            z47 = qZoneInitBean.showTitlePublishMoodBtn;
        } else {
            z47 = z28;
        }
        return qZoneInitBean.copy(z29, i27, i28, z36, i29, i36, i37, z37, str2, z38, z39, z46, z47);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getShowNextStepButton() {
        return this.showNextStepButton;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getShowSelectionPreview() {
        return this.showSelectionPreview;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getEnableEdit() {
        return this.enableEdit;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getIsSingleSelectMode() {
        return this.isSingleSelectMode;
    }

    /* renamed from: component13, reason: from getter */
    public final boolean getShowTitlePublishMoodBtn() {
        return this.showTitlePublishMoodBtn;
    }

    /* renamed from: component2, reason: from getter */
    public final int getNextStepMinMediaNum() {
        return this.nextStepMinMediaNum;
    }

    /* renamed from: component3, reason: from getter */
    public final int getNextStepMaxMediaNum() {
        return this.nextStepMaxMediaNum;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getShowVideoTemplateButton() {
        return this.showVideoTemplateButton;
    }

    /* renamed from: component5, reason: from getter */
    public final int getVideoTemplateMinMediaNum() {
        return this.videoTemplateMinMediaNum;
    }

    /* renamed from: component6, reason: from getter */
    public final int getVideoTemplateMaxMediaNum() {
        return this.videoTemplateMaxMediaNum;
    }

    /* renamed from: component7, reason: from getter */
    public final int getMaxVideoCountLimitNum() {
        return this.maxVideoCountLimitNum;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getShowSelectionPanelThumbNail() {
        return this.showSelectionPanelThumbNail;
    }

    @NotNull
    /* renamed from: component9, reason: from getter */
    public final String getTopBannerTextContent() {
        return this.topBannerTextContent;
    }

    @NotNull
    public final QZoneInitBean copy(boolean showNextStepButton, int nextStepMinMediaNum, int nextStepMaxMediaNum, boolean showVideoTemplateButton, int videoTemplateMinMediaNum, int videoTemplateMaxMediaNum, int maxVideoCountLimitNum, boolean showSelectionPanelThumbNail, @NotNull String topBannerTextContent, boolean showSelectionPreview, boolean enableEdit, boolean isSingleSelectMode, boolean showTitlePublishMoodBtn) {
        Intrinsics.checkNotNullParameter(topBannerTextContent, "topBannerTextContent");
        return new QZoneInitBean(showNextStepButton, nextStepMinMediaNum, nextStepMaxMediaNum, showVideoTemplateButton, videoTemplateMinMediaNum, videoTemplateMaxMediaNum, maxVideoCountLimitNum, showSelectionPanelThumbNail, topBannerTextContent, showSelectionPreview, enableEdit, isSingleSelectMode, showTitlePublishMoodBtn);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QZoneInitBean)) {
            return false;
        }
        QZoneInitBean qZoneInitBean = (QZoneInitBean) other;
        if (this.showNextStepButton == qZoneInitBean.showNextStepButton && this.nextStepMinMediaNum == qZoneInitBean.nextStepMinMediaNum && this.nextStepMaxMediaNum == qZoneInitBean.nextStepMaxMediaNum && this.showVideoTemplateButton == qZoneInitBean.showVideoTemplateButton && this.videoTemplateMinMediaNum == qZoneInitBean.videoTemplateMinMediaNum && this.videoTemplateMaxMediaNum == qZoneInitBean.videoTemplateMaxMediaNum && this.maxVideoCountLimitNum == qZoneInitBean.maxVideoCountLimitNum && this.showSelectionPanelThumbNail == qZoneInitBean.showSelectionPanelThumbNail && Intrinsics.areEqual(this.topBannerTextContent, qZoneInitBean.topBannerTextContent) && this.showSelectionPreview == qZoneInitBean.showSelectionPreview && this.enableEdit == qZoneInitBean.enableEdit && this.isSingleSelectMode == qZoneInitBean.isSingleSelectMode && this.showTitlePublishMoodBtn == qZoneInitBean.showTitlePublishMoodBtn) {
            return true;
        }
        return false;
    }

    public final boolean getEnableEdit() {
        return this.enableEdit;
    }

    public final int getMaxVideoCountLimitNum() {
        return this.maxVideoCountLimitNum;
    }

    public final int getNextStepMaxMediaNum() {
        return this.nextStepMaxMediaNum;
    }

    public final int getNextStepMinMediaNum() {
        return this.nextStepMinMediaNum;
    }

    public final boolean getShowNextStepButton() {
        return this.showNextStepButton;
    }

    public final boolean getShowSelectionPanelThumbNail() {
        return this.showSelectionPanelThumbNail;
    }

    public final boolean getShowSelectionPreview() {
        return this.showSelectionPreview;
    }

    public final boolean getShowTitlePublishMoodBtn() {
        return this.showTitlePublishMoodBtn;
    }

    public final boolean getShowVideoTemplateButton() {
        return this.showVideoTemplateButton;
    }

    @NotNull
    public final String getTopBannerTextContent() {
        return this.topBannerTextContent;
    }

    public final int getVideoTemplateMaxMediaNum() {
        return this.videoTemplateMaxMediaNum;
    }

    public final int getVideoTemplateMinMediaNum() {
        return this.videoTemplateMinMediaNum;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r2v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v13, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v15, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v7, types: [boolean] */
    public int hashCode() {
        boolean z16 = this.showNextStepButton;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = ((((r06 * 31) + this.nextStepMinMediaNum) * 31) + this.nextStepMaxMediaNum) * 31;
        ?? r26 = this.showVideoTemplateButton;
        int i17 = r26;
        if (r26 != 0) {
            i17 = 1;
        }
        int i18 = (((((((i16 + i17) * 31) + this.videoTemplateMinMediaNum) * 31) + this.videoTemplateMaxMediaNum) * 31) + this.maxVideoCountLimitNum) * 31;
        ?? r27 = this.showSelectionPanelThumbNail;
        int i19 = r27;
        if (r27 != 0) {
            i19 = 1;
        }
        int hashCode = (((i18 + i19) * 31) + this.topBannerTextContent.hashCode()) * 31;
        ?? r28 = this.showSelectionPreview;
        int i26 = r28;
        if (r28 != 0) {
            i26 = 1;
        }
        int i27 = (hashCode + i26) * 31;
        ?? r29 = this.enableEdit;
        int i28 = r29;
        if (r29 != 0) {
            i28 = 1;
        }
        int i29 = (i27 + i28) * 31;
        ?? r210 = this.isSingleSelectMode;
        int i36 = r210;
        if (r210 != 0) {
            i36 = 1;
        }
        int i37 = (i29 + i36) * 31;
        boolean z17 = this.showTitlePublishMoodBtn;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return i37 + i3;
    }

    public final boolean isSingleSelectMode() {
        return this.isSingleSelectMode;
    }

    public final void setMaxVideoCountLimitNum(int i3) {
        this.maxVideoCountLimitNum = i3;
    }

    public final void setShowSelectionPanelThumbNail(boolean z16) {
        this.showSelectionPanelThumbNail = z16;
    }

    public final void setTopBannerTextContent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.topBannerTextContent = str;
    }

    @NotNull
    public String toString() {
        return "QZoneInitBean(showNextStepButton=" + this.showNextStepButton + ", nextStepMinMediaNum=" + this.nextStepMinMediaNum + ", nextStepMaxMediaNum=" + this.nextStepMaxMediaNum + ", showVideoTemplateButton=" + this.showVideoTemplateButton + ", videoTemplateMinMediaNum=" + this.videoTemplateMinMediaNum + ", videoTemplateMaxMediaNum=" + this.videoTemplateMaxMediaNum + ", maxVideoCountLimitNum=" + this.maxVideoCountLimitNum + ", showSelectionPanelThumbNail=" + this.showSelectionPanelThumbNail + ", topBannerTextContent=" + this.topBannerTextContent + ", showSelectionPreview=" + this.showSelectionPreview + ", enableEdit=" + this.enableEdit + ", isSingleSelectMode=" + this.isSingleSelectMode + ", showTitlePublishMoodBtn=" + this.showTitlePublishMoodBtn + ")";
    }

    public /* synthetic */ QZoneInitBean(boolean z16, int i3, int i16, boolean z17, int i17, int i18, int i19, boolean z18, String str, boolean z19, boolean z26, boolean z27, boolean z28, int i26, DefaultConstructorMarker defaultConstructorMarker) {
        this((i26 & 1) != 0 ? true : z16, (i26 & 2) != 0 ? 0 : i3, (i26 & 4) != 0 ? 0 : i16, (i26 & 8) != 0 ? true : z17, (i26 & 16) != 0 ? 0 : i17, (i26 & 32) != 0 ? 0 : i18, (i26 & 64) != 0 ? 50 : i19, (i26 & 128) != 0 ? false : z18, (i26 & 256) != 0 ? "" : str, (i26 & 512) != 0 ? false : z19, (i26 & 1024) == 0 ? z26 : true, (i26 & 2048) != 0 ? false : z27, (i26 & 4096) == 0 ? z28 : false);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneInitBean(boolean z16, int i3, int i16, boolean z17, int i17, int i18, int i19, boolean z18, @NotNull String topBannerTextContent, boolean z19, boolean z26, boolean z27, boolean z28) {
        super(true, null, 2, null);
        Intrinsics.checkNotNullParameter(topBannerTextContent, "topBannerTextContent");
        this.showNextStepButton = z16;
        this.nextStepMinMediaNum = i3;
        this.nextStepMaxMediaNum = i16;
        this.showVideoTemplateButton = z17;
        this.videoTemplateMinMediaNum = i17;
        this.videoTemplateMaxMediaNum = i18;
        this.maxVideoCountLimitNum = i19;
        this.showSelectionPanelThumbNail = z18;
        this.topBannerTextContent = topBannerTextContent;
        this.showSelectionPreview = z19;
        this.enableEdit = z26;
        this.isSingleSelectMode = z27;
        this.showTitlePublishMoodBtn = z28;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZoneInitBean(boolean z16, int i3, int i16, boolean z17, int i17, int i18, @NotNull String topBannerTextContent) {
        this(z16, i3, i16, z17, i17, i18, 50, false, topBannerTextContent, false, false, false, false, 7680, null);
        Intrinsics.checkNotNullParameter(topBannerTextContent, "topBannerTextContent");
    }
}
