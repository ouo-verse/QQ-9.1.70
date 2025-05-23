package com.tencent.state.square.interaction.settingme;

import com.tencent.mobileqq.vas.banner.c;
import com.tencent.state.square.interaction.InteractionSettingOption;
import cooperation.qzone.QZoneShareManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b*\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tBY\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\u0013J\t\u0010+\u001a\u00020\u000bH\u00c6\u0003J\t\u0010,\u001a\u00020\rH\u00c6\u0003J\t\u0010-\u001a\u00020\rH\u00c6\u0003J\t\u0010.\u001a\u00020\rH\u00c6\u0003J\t\u0010/\u001a\u00020\rH\u00c6\u0003J\t\u00100\u001a\u00020\rH\u00c6\u0003J\t\u00101\u001a\u00020\rH\u00c6\u0003J\t\u00102\u001a\u00020\u0005H\u00c6\u0003J\u0015\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003Jo\u00104\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0001J\u0013\u00105\u001a\u00020\u00052\b\u00106\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00107\u001a\u000208H\u00d6\u0001J\t\u00109\u001a\u00020\rH\u00d6\u0001R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0010\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0011\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001a\u0010\u000f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\u000e\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0017\"\u0004\b(\u0010\u0019R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0017\"\u0004\b*\u0010\u0019\u00a8\u0006:"}, d2 = {"Lcom/tencent/state/square/interaction/settingme/InteractionSettingMeItemData;", "", "info", "Lcom/tencent/state/square/interaction/InteractionSettingOption;", "isSelect", "", "action", "Lkotlin/Function1;", "", "(Lcom/tencent/state/square/interaction/InteractionSettingOption;ZLkotlin/jvm/functions/Function1;)V", "optionId", "", "optionIcon", "", "optionText", "fixedText", "customText", QZoneShareManager.QZONE_SHARE_VIDEO_TEXT, "resultMotion", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function1;)V", "getAction", "()Lkotlin/jvm/functions/Function1;", "getCustomText", "()Ljava/lang/String;", "setCustomText", "(Ljava/lang/String;)V", "getDefaultText", "setDefaultText", "getFixedText", "setFixedText", "()Z", "setSelect", "(Z)V", "getOptionIcon", "setOptionIcon", "getOptionId", "()J", "setOptionId", "(J)V", "getOptionText", "setOptionText", "getResultMotion", "setResultMotion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class InteractionSettingMeItemData {
    private final Function1<InteractionSettingOption, Unit> action;
    private String customText;
    private String defaultText;
    private String fixedText;
    private boolean isSelect;
    private String optionIcon;
    private long optionId;
    private String optionText;
    private String resultMotion;

    /* JADX WARN: Multi-variable type inference failed */
    public InteractionSettingMeItemData(long j3, String optionIcon, String optionText, String fixedText, String customText, String defaultText, String resultMotion, boolean z16, Function1<? super InteractionSettingOption, Unit> action) {
        Intrinsics.checkNotNullParameter(optionIcon, "optionIcon");
        Intrinsics.checkNotNullParameter(optionText, "optionText");
        Intrinsics.checkNotNullParameter(fixedText, "fixedText");
        Intrinsics.checkNotNullParameter(customText, "customText");
        Intrinsics.checkNotNullParameter(defaultText, "defaultText");
        Intrinsics.checkNotNullParameter(resultMotion, "resultMotion");
        Intrinsics.checkNotNullParameter(action, "action");
        this.optionId = j3;
        this.optionIcon = optionIcon;
        this.optionText = optionText;
        this.fixedText = fixedText;
        this.customText = customText;
        this.defaultText = defaultText;
        this.resultMotion = resultMotion;
        this.isSelect = z16;
        this.action = action;
    }

    /* renamed from: component1, reason: from getter */
    public final long getOptionId() {
        return this.optionId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getOptionIcon() {
        return this.optionIcon;
    }

    /* renamed from: component3, reason: from getter */
    public final String getOptionText() {
        return this.optionText;
    }

    /* renamed from: component4, reason: from getter */
    public final String getFixedText() {
        return this.fixedText;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCustomText() {
        return this.customText;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDefaultText() {
        return this.defaultText;
    }

    /* renamed from: component7, reason: from getter */
    public final String getResultMotion() {
        return this.resultMotion;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getIsSelect() {
        return this.isSelect;
    }

    public final Function1<InteractionSettingOption, Unit> component9() {
        return this.action;
    }

    public final InteractionSettingMeItemData copy(long optionId, String optionIcon, String optionText, String fixedText, String customText, String defaultText, String resultMotion, boolean isSelect, Function1<? super InteractionSettingOption, Unit> action) {
        Intrinsics.checkNotNullParameter(optionIcon, "optionIcon");
        Intrinsics.checkNotNullParameter(optionText, "optionText");
        Intrinsics.checkNotNullParameter(fixedText, "fixedText");
        Intrinsics.checkNotNullParameter(customText, "customText");
        Intrinsics.checkNotNullParameter(defaultText, "defaultText");
        Intrinsics.checkNotNullParameter(resultMotion, "resultMotion");
        Intrinsics.checkNotNullParameter(action, "action");
        return new InteractionSettingMeItemData(optionId, optionIcon, optionText, fixedText, customText, defaultText, resultMotion, isSelect, action);
    }

    public final Function1<InteractionSettingOption, Unit> getAction() {
        return this.action;
    }

    public final String getCustomText() {
        return this.customText;
    }

    public final String getDefaultText() {
        return this.defaultText;
    }

    public final String getFixedText() {
        return this.fixedText;
    }

    public final String getOptionIcon() {
        return this.optionIcon;
    }

    public final long getOptionId() {
        return this.optionId;
    }

    public final String getOptionText() {
        return this.optionText;
    }

    public final String getResultMotion() {
        return this.resultMotion;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a16 = c.a(this.optionId) * 31;
        String str = this.optionIcon;
        int hashCode = (a16 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.optionText;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.fixedText;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.customText;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.defaultText;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.resultMotion;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        boolean z16 = this.isSelect;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode6 + i3) * 31;
        Function1<InteractionSettingOption, Unit> function1 = this.action;
        return i16 + (function1 != null ? function1.hashCode() : 0);
    }

    public final boolean isSelect() {
        return this.isSelect;
    }

    public final void setCustomText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.customText = str;
    }

    public final void setDefaultText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.defaultText = str;
    }

    public final void setFixedText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.fixedText = str;
    }

    public final void setOptionIcon(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.optionIcon = str;
    }

    public final void setOptionId(long j3) {
        this.optionId = j3;
    }

    public final void setOptionText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.optionText = str;
    }

    public final void setResultMotion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.resultMotion = str;
    }

    public final void setSelect(boolean z16) {
        this.isSelect = z16;
    }

    public String toString() {
        return "InteractionSettingMeItemData(optionId=" + this.optionId + ", optionIcon=" + this.optionIcon + ", optionText=" + this.optionText + ", fixedText=" + this.fixedText + ", customText=" + this.customText + ", defaultText=" + this.defaultText + ", resultMotion=" + this.resultMotion + ", isSelect=" + this.isSelect + ", action=" + this.action + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InteractionSettingMeItemData(InteractionSettingOption info, boolean z16, Function1<? super InteractionSettingOption, Unit> action) {
        this(info.getOptionId(), info.getOptionIcon(), info.getOptionText(), info.getFixedText(), info.getCustomText(), info.getDefaultText(), info.getResultMotion(), z16, action);
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(action, "action");
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InteractionSettingMeItemData)) {
            return false;
        }
        InteractionSettingMeItemData interactionSettingMeItemData = (InteractionSettingMeItemData) other;
        return this.optionId == interactionSettingMeItemData.optionId && Intrinsics.areEqual(this.optionIcon, interactionSettingMeItemData.optionIcon) && Intrinsics.areEqual(this.optionText, interactionSettingMeItemData.optionText) && Intrinsics.areEqual(this.fixedText, interactionSettingMeItemData.fixedText) && Intrinsics.areEqual(this.customText, interactionSettingMeItemData.customText) && Intrinsics.areEqual(this.defaultText, interactionSettingMeItemData.defaultText) && Intrinsics.areEqual(this.resultMotion, interactionSettingMeItemData.resultMotion) && this.isSelect == interactionSettingMeItemData.isSelect && Intrinsics.areEqual(this.action, interactionSettingMeItemData.action);
    }
}
