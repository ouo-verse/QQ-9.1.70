package com.tencent.robot.aio.bottombar.model;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b1\b\u0086\b\u0018\u00002\u00020\u0001B\u00c9\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00000\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\b\b\u0002\u0010\u0016\u001a\u00020\n\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0005\u00a2\u0006\u0004\bA\u0010BJ\u00cf\u0001\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00000\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\n2\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u0005H\u00c6\u0001J\t\u0010\u001b\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u001e\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\u0004\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u001f\u001a\u0004\b#\u0010!R\u0017\u0010\u0006\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010\u0007\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b(\u0010%\u001a\u0004\b)\u0010'R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b*\u0010\u001f\u001a\u0004\b+\u0010!R\u0017\u0010\t\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b,\u0010%\u001a\u0004\b-\u0010'R\u0017\u0010\u000b\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b+\u0010.\u001a\u0004\b,\u0010/R\u0017\u0010\f\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b)\u0010%\u001a\u0004\b$\u0010'R\u0017\u0010\r\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b0\u0010%\u001a\u0004\b1\u0010'R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00018\u0006\u00a2\u0006\f\n\u0004\b&\u00102\u001a\u0004\b*\u00103R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b4\u0010.\u001a\u0004\b5\u0010/R\u0017\u0010\u0011\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b#\u00106\u001a\u0004\b7\u00108R\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00000\u00128\u0006\u00a2\u0006\f\n\u0004\b7\u00109\u001a\u0004\b:\u0010;R\u0017\u0010\u0014\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b<\u0010%\u001a\u0004\b(\u0010'R\u0017\u0010\u0015\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b1\u0010.\u001a\u0004\b=\u0010/R\"\u0010\u0016\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010.\u001a\u0004\b>\u0010/\"\u0004\b?\u0010@R\u0017\u0010\u0017\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b5\u0010%\u001a\u0004\b4\u0010'R\u0017\u0010\u0018\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b:\u0010%\u001a\u0004\b<\u0010'R\u0017\u0010\u0019\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b-\u0010%\u001a\u0004\b0\u0010'\u00a8\u0006C"}, d2 = {"Lcom/tencent/robot/aio/bottombar/model/a;", "", "", "sectionType", "optID", "", "itemID", "iconUrl", "iconResId", "title", "", "enableBlur", "action", ZPlanPublishSource.FROM_SCHEME, "data", "showStroke", "Lcom/tencent/robot/aio/bottombar/model/OptionType;", "optionType", "", "subItemsList", "callBackData", "isDefaultChecked", "isChecked", "optDesc", "promptTemplate", "inputPlaceholder", "a", "toString", "hashCode", "other", "equals", "I", "p", "()I", "b", "l", "c", "Ljava/lang/String;", "j", "()Ljava/lang/String;", "d", h.F, "e", "g", "f", ReportConstant.COSTREPORT_PREFIX, "Z", "()Z", "i", "o", "Ljava/lang/Object;", "()Ljava/lang/Object;", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/robot/aio/bottombar/model/OptionType;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/robot/aio/bottombar/model/OptionType;", "Ljava/util/List;", "r", "()Ljava/util/List;", DomainData.DOMAIN_NAME, "u", "t", "setChecked", "(Z)V", "<init>", "(IILjava/lang/String;Ljava/lang/String;ILjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Object;ZLcom/tencent/robot/aio/bottombar/model/OptionType;Ljava/util/List;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.aio.bottombar.model.a, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class RobotBottomBarItemModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int sectionType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int optID;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String itemID;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String iconUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int iconResId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String title;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean enableBlur;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String action;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String scheme;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Object data;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean showStroke;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final OptionType optionType;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<RobotBottomBarItemModel> subItemsList;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String callBackData;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isDefaultChecked;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isChecked;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String optDesc;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String promptTemplate;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String inputPlaceholder;

    public RobotBottomBarItemModel(int i3, int i16, @NotNull String itemID, @NotNull String iconUrl, int i17, @NotNull String title, boolean z16, @NotNull String action, @NotNull String scheme, @Nullable Object obj, boolean z17, @NotNull OptionType optionType, @NotNull List<RobotBottomBarItemModel> subItemsList, @NotNull String callBackData, boolean z18, boolean z19, @NotNull String optDesc, @NotNull String promptTemplate, @NotNull String inputPlaceholder) {
        Intrinsics.checkNotNullParameter(itemID, "itemID");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Intrinsics.checkNotNullParameter(optionType, "optionType");
        Intrinsics.checkNotNullParameter(subItemsList, "subItemsList");
        Intrinsics.checkNotNullParameter(callBackData, "callBackData");
        Intrinsics.checkNotNullParameter(optDesc, "optDesc");
        Intrinsics.checkNotNullParameter(promptTemplate, "promptTemplate");
        Intrinsics.checkNotNullParameter(inputPlaceholder, "inputPlaceholder");
        this.sectionType = i3;
        this.optID = i16;
        this.itemID = itemID;
        this.iconUrl = iconUrl;
        this.iconResId = i17;
        this.title = title;
        this.enableBlur = z16;
        this.action = action;
        this.scheme = scheme;
        this.data = obj;
        this.showStroke = z17;
        this.optionType = optionType;
        this.subItemsList = subItemsList;
        this.callBackData = callBackData;
        this.isDefaultChecked = z18;
        this.isChecked = z19;
        this.optDesc = optDesc;
        this.promptTemplate = promptTemplate;
        this.inputPlaceholder = inputPlaceholder;
    }

    @NotNull
    public final RobotBottomBarItemModel a(int sectionType, int optID, @NotNull String itemID, @NotNull String iconUrl, int iconResId, @NotNull String title, boolean enableBlur, @NotNull String action, @NotNull String scheme, @Nullable Object data, boolean showStroke, @NotNull OptionType optionType, @NotNull List<RobotBottomBarItemModel> subItemsList, @NotNull String callBackData, boolean isDefaultChecked, boolean isChecked, @NotNull String optDesc, @NotNull String promptTemplate, @NotNull String inputPlaceholder) {
        Intrinsics.checkNotNullParameter(itemID, "itemID");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Intrinsics.checkNotNullParameter(optionType, "optionType");
        Intrinsics.checkNotNullParameter(subItemsList, "subItemsList");
        Intrinsics.checkNotNullParameter(callBackData, "callBackData");
        Intrinsics.checkNotNullParameter(optDesc, "optDesc");
        Intrinsics.checkNotNullParameter(promptTemplate, "promptTemplate");
        Intrinsics.checkNotNullParameter(inputPlaceholder, "inputPlaceholder");
        return new RobotBottomBarItemModel(sectionType, optID, itemID, iconUrl, iconResId, title, enableBlur, action, scheme, data, showStroke, optionType, subItemsList, callBackData, isDefaultChecked, isChecked, optDesc, promptTemplate, inputPlaceholder);
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getAction() {
        return this.action;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getCallBackData() {
        return this.callBackData;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final Object getData() {
        return this.data;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RobotBottomBarItemModel)) {
            return false;
        }
        RobotBottomBarItemModel robotBottomBarItemModel = (RobotBottomBarItemModel) other;
        if (this.sectionType == robotBottomBarItemModel.sectionType && this.optID == robotBottomBarItemModel.optID && Intrinsics.areEqual(this.itemID, robotBottomBarItemModel.itemID) && Intrinsics.areEqual(this.iconUrl, robotBottomBarItemModel.iconUrl) && this.iconResId == robotBottomBarItemModel.iconResId && Intrinsics.areEqual(this.title, robotBottomBarItemModel.title) && this.enableBlur == robotBottomBarItemModel.enableBlur && Intrinsics.areEqual(this.action, robotBottomBarItemModel.action) && Intrinsics.areEqual(this.scheme, robotBottomBarItemModel.scheme) && Intrinsics.areEqual(this.data, robotBottomBarItemModel.data) && this.showStroke == robotBottomBarItemModel.showStroke && this.optionType == robotBottomBarItemModel.optionType && Intrinsics.areEqual(this.subItemsList, robotBottomBarItemModel.subItemsList) && Intrinsics.areEqual(this.callBackData, robotBottomBarItemModel.callBackData) && this.isDefaultChecked == robotBottomBarItemModel.isDefaultChecked && this.isChecked == robotBottomBarItemModel.isChecked && Intrinsics.areEqual(this.optDesc, robotBottomBarItemModel.optDesc) && Intrinsics.areEqual(this.promptTemplate, robotBottomBarItemModel.promptTemplate) && Intrinsics.areEqual(this.inputPlaceholder, robotBottomBarItemModel.inputPlaceholder)) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getEnableBlur() {
        return this.enableBlur;
    }

    /* renamed from: g, reason: from getter */
    public final int getIconResId() {
        return this.iconResId;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((((((((this.sectionType * 31) + this.optID) * 31) + this.itemID.hashCode()) * 31) + this.iconUrl.hashCode()) * 31) + this.iconResId) * 31) + this.title.hashCode()) * 31;
        boolean z16 = this.enableBlur;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int hashCode3 = (((((hashCode2 + i16) * 31) + this.action.hashCode()) * 31) + this.scheme.hashCode()) * 31;
        Object obj = this.data;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        int i17 = (hashCode3 + hashCode) * 31;
        boolean z17 = this.showStroke;
        int i18 = z17;
        if (z17 != 0) {
            i18 = 1;
        }
        int hashCode4 = (((((((i17 + i18) * 31) + this.optionType.hashCode()) * 31) + this.subItemsList.hashCode()) * 31) + this.callBackData.hashCode()) * 31;
        boolean z18 = this.isDefaultChecked;
        int i19 = z18;
        if (z18 != 0) {
            i19 = 1;
        }
        int i26 = (hashCode4 + i19) * 31;
        boolean z19 = this.isChecked;
        if (!z19) {
            i3 = z19 ? 1 : 0;
        }
        return ((((((i26 + i3) * 31) + this.optDesc.hashCode()) * 31) + this.promptTemplate.hashCode()) * 31) + this.inputPlaceholder.hashCode();
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getInputPlaceholder() {
        return this.inputPlaceholder;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final String getItemID() {
        return this.itemID;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final String getOptDesc() {
        return this.optDesc;
    }

    /* renamed from: l, reason: from getter */
    public final int getOptID() {
        return this.optID;
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final OptionType getOptionType() {
        return this.optionType;
    }

    @NotNull
    /* renamed from: n, reason: from getter */
    public final String getPromptTemplate() {
        return this.promptTemplate;
    }

    @NotNull
    /* renamed from: o, reason: from getter */
    public final String getScheme() {
        return this.scheme;
    }

    /* renamed from: p, reason: from getter */
    public final int getSectionType() {
        return this.sectionType;
    }

    /* renamed from: q, reason: from getter */
    public final boolean getShowStroke() {
        return this.showStroke;
    }

    @NotNull
    public final List<RobotBottomBarItemModel> r() {
        return this.subItemsList;
    }

    @NotNull
    /* renamed from: s, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: t, reason: from getter */
    public final boolean getIsChecked() {
        return this.isChecked;
    }

    @NotNull
    public String toString() {
        return "RobotBottomBarItemModel(sectionType=" + this.sectionType + ", optID=" + this.optID + ", itemID=" + this.itemID + ", iconUrl=" + this.iconUrl + ", iconResId=" + this.iconResId + ", title=" + this.title + ", enableBlur=" + this.enableBlur + ", action=" + this.action + ", scheme=" + this.scheme + ", data=" + this.data + ", showStroke=" + this.showStroke + ", optionType=" + this.optionType + ", subItemsList=" + this.subItemsList + ", callBackData=" + this.callBackData + ", isDefaultChecked=" + this.isDefaultChecked + ", isChecked=" + this.isChecked + ", optDesc=" + this.optDesc + ", promptTemplate=" + this.promptTemplate + ", inputPlaceholder=" + this.inputPlaceholder + ")";
    }

    /* renamed from: u, reason: from getter */
    public final boolean getIsDefaultChecked() {
        return this.isDefaultChecked;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ RobotBottomBarItemModel(int i3, int i16, String str, String str2, int i17, String str3, boolean z16, String str4, String str5, Object obj, boolean z17, OptionType optionType, List list, String str6, boolean z18, boolean z19, String str7, String str8, String str9, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, r5, r6, r7, r8, str3, r10, r11, r12, r13, r14, r15, r16, (i18 & 8192) != 0 ? "" : str6, (i18 & 16384) != 0 ? false : z18, (32768 & i18) != 0 ? false : z19, (65536 & i18) != 0 ? "" : str7, (131072 & i18) != 0 ? "" : str8, (i18 & 262144) != 0 ? "" : str9);
        List list2;
        List emptyList;
        int i19 = (i18 & 2) != 0 ? 0 : i16;
        String str10 = (i18 & 4) != 0 ? "" : str;
        String str11 = (i18 & 8) != 0 ? "" : str2;
        int i26 = (i18 & 16) != 0 ? 0 : i17;
        boolean z26 = (i18 & 64) != 0 ? true : z16;
        String str12 = (i18 & 128) != 0 ? "" : str4;
        String str13 = (i18 & 256) != 0 ? "" : str5;
        Object obj2 = (i18 & 512) != 0 ? null : obj;
        boolean z27 = (i18 & 1024) != 0 ? true : z17;
        OptionType optionType2 = (i18 & 2048) != 0 ? OptionType.OPTION_UNKNOWN : optionType;
        if ((i18 & 4096) != 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list2 = emptyList;
        } else {
            list2 = list;
        }
    }
}
