package com.tencent.state.square.interaction;

import com.tencent.mobileqq.vas.banner.c;
import com.tencent.state.square.interaction.settingme.InteractionSettingMeItemData;
import cooperation.qzone.QZoneShareManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pt4.p;
import pt4.r;
import pt4.v;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u00a2\u0006\u0004\b/\u00100B\t\b\u0016\u00a2\u0006\u0004\b/\u00101B\u0011\b\u0016\u0012\u0006\u00103\u001a\u000202\u00a2\u0006\u0004\b/\u00104B\u0011\b\u0016\u0012\u0006\u00103\u001a\u000205\u00a2\u0006\u0004\b/\u00106B\u0011\b\u0016\u0012\u0006\u00103\u001a\u000207\u00a2\u0006\u0004\b/\u00108J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\t\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u000b\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0006H\u00c6\u0003JO\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u0006H\u00c6\u0001J\t\u0010\u0015\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0016H\u00d6\u0001J\u0013\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010\u000e\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010\u000f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010 \u001a\u0004\b%\u0010\"\"\u0004\b&\u0010$R\"\u0010\u0010\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010 \u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R\"\u0010\u0011\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010 \u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R\"\u0010\u0012\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010 \u001a\u0004\b+\u0010\"\"\u0004\b,\u0010$R\"\u0010\u0013\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010 \u001a\u0004\b-\u0010\"\"\u0004\b.\u0010$\u00a8\u00069"}, d2 = {"Lcom/tencent/state/square/interaction/InteractionSettingOption;", "", "Lpt4/v;", "toPBUserCustomOption", "", "component1", "", "component2", "component3", "component4", "component5", "component6", "component7", "optionId", "optionIcon", "optionText", "fixedText", "customText", QZoneShareManager.QZONE_SHARE_VIDEO_TEXT, "resultMotion", "copy", "toString", "", "hashCode", "other", "", "equals", "J", "getOptionId", "()J", "setOptionId", "(J)V", "Ljava/lang/String;", "getOptionIcon", "()Ljava/lang/String;", "setOptionIcon", "(Ljava/lang/String;)V", "getOptionText", "setOptionText", "getFixedText", "setFixedText", "getCustomText", "setCustomText", "getDefaultText", "setDefaultText", "getResultMotion", "setResultMotion", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()V", "Lpt4/r;", "pb", "(Lpt4/r;)V", "Lpt4/p;", "(Lpt4/p;)V", "Lcom/tencent/state/square/interaction/settingme/InteractionSettingMeItemData;", "(Lcom/tencent/state/square/interaction/settingme/InteractionSettingMeItemData;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class InteractionSettingOption {
    private String customText;
    private String defaultText;
    private String fixedText;
    private String optionIcon;
    private long optionId;
    private String optionText;
    private String resultMotion;

    public InteractionSettingOption(long j3, String optionIcon, String optionText, String fixedText, String customText, String defaultText, String resultMotion) {
        Intrinsics.checkNotNullParameter(optionIcon, "optionIcon");
        Intrinsics.checkNotNullParameter(optionText, "optionText");
        Intrinsics.checkNotNullParameter(fixedText, "fixedText");
        Intrinsics.checkNotNullParameter(customText, "customText");
        Intrinsics.checkNotNullParameter(defaultText, "defaultText");
        Intrinsics.checkNotNullParameter(resultMotion, "resultMotion");
        this.optionId = j3;
        this.optionIcon = optionIcon;
        this.optionText = optionText;
        this.fixedText = fixedText;
        this.customText = customText;
        this.defaultText = defaultText;
        this.resultMotion = resultMotion;
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

    public final InteractionSettingOption copy(long optionId, String optionIcon, String optionText, String fixedText, String customText, String defaultText, String resultMotion) {
        Intrinsics.checkNotNullParameter(optionIcon, "optionIcon");
        Intrinsics.checkNotNullParameter(optionText, "optionText");
        Intrinsics.checkNotNullParameter(fixedText, "fixedText");
        Intrinsics.checkNotNullParameter(customText, "customText");
        Intrinsics.checkNotNullParameter(defaultText, "defaultText");
        Intrinsics.checkNotNullParameter(resultMotion, "resultMotion");
        return new InteractionSettingOption(optionId, optionIcon, optionText, fixedText, customText, defaultText, resultMotion);
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
        return hashCode5 + (str6 != null ? str6.hashCode() : 0);
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

    public final v toPBUserCustomOption() {
        v vVar = new v();
        vVar.f427244a = this.optionId;
        vVar.f427245b = this.customText;
        return vVar;
    }

    public String toString() {
        return "InteractionSettingOption(optionId=" + this.optionId + ", optionIcon=" + this.optionIcon + ", optionText=" + this.optionText + ", fixedText=" + this.fixedText + ", customText=" + this.customText + ", defaultText=" + this.defaultText + ", resultMotion=" + this.resultMotion + ")";
    }

    public InteractionSettingOption() {
        this(0L, "", "", "", "", "", "");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public InteractionSettingOption(r pb5) {
        this(r2, r4, r5, r6, r7, "", "");
        Intrinsics.checkNotNullParameter(pb5, "pb");
        long j3 = pb5.f427232a;
        String str = pb5.f427233b;
        Intrinsics.checkNotNullExpressionValue(str, "pb.optionIcon");
        String str2 = pb5.f427234c;
        Intrinsics.checkNotNullExpressionValue(str2, "pb.optionText");
        String str3 = pb5.f427235d;
        Intrinsics.checkNotNullExpressionValue(str3, "pb.fixedText");
        String str4 = pb5.f427236e;
        Intrinsics.checkNotNullExpressionValue(str4, "pb.customText");
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InteractionSettingOption)) {
            return false;
        }
        InteractionSettingOption interactionSettingOption = (InteractionSettingOption) other;
        return this.optionId == interactionSettingOption.optionId && Intrinsics.areEqual(this.optionIcon, interactionSettingOption.optionIcon) && Intrinsics.areEqual(this.optionText, interactionSettingOption.optionText) && Intrinsics.areEqual(this.fixedText, interactionSettingOption.fixedText) && Intrinsics.areEqual(this.customText, interactionSettingOption.customText) && Intrinsics.areEqual(this.defaultText, interactionSettingOption.defaultText) && Intrinsics.areEqual(this.resultMotion, interactionSettingOption.resultMotion);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public InteractionSettingOption(p pb5) {
        this(r2, r4, r5, r6, r7, r8, r9);
        Intrinsics.checkNotNullParameter(pb5, "pb");
        long j3 = pb5.f427207a;
        String str = pb5.f427208b;
        Intrinsics.checkNotNullExpressionValue(str, "pb.optionIcon");
        String str2 = pb5.f427209c;
        Intrinsics.checkNotNullExpressionValue(str2, "pb.optionText");
        String str3 = pb5.f427210d;
        Intrinsics.checkNotNullExpressionValue(str3, "pb.fixedText");
        String str4 = pb5.f427211e;
        Intrinsics.checkNotNullExpressionValue(str4, "pb.defaultText");
        String str5 = pb5.f427211e;
        Intrinsics.checkNotNullExpressionValue(str5, "pb.defaultText");
        String str6 = pb5.f427212f;
        Intrinsics.checkNotNullExpressionValue(str6, "pb.resultMotion");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InteractionSettingOption(InteractionSettingMeItemData pb5) {
        this(pb5.getOptionId(), pb5.getOptionIcon(), pb5.getOptionText(), pb5.getFixedText(), pb5.getDefaultText(), pb5.getDefaultText(), pb5.getResultMotion());
        Intrinsics.checkNotNullParameter(pb5, "pb");
    }
}
