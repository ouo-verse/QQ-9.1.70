package com.tencent.state.square.interaction;

import com.tencent.mobileqq.vas.banner.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pt4.q;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\b\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\b\u0012\u0006\u0010\u0018\u001a\u00020\b\u0012\u0006\u0010\u0019\u001a\u00020\b\u0012\u0006\u0010\u001a\u001a\u00020\b\u0012\u0006\u0010\u001b\u001a\u00020\b\u0012\u0006\u0010\u001c\u001a\u00020\b\u0012\u0006\u0010\u001d\u001a\u00020\b\u0012\u0006\u0010\u001e\u001a\u00020\b\u00a2\u0006\u0004\b7\u00108B\u0011\b\u0016\u0012\u0006\u00109\u001a\u00020\u0002\u00a2\u0006\u0004\b7\u0010:J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\t\u001a\u00020\bH\u00c6\u0003J\t\u0010\n\u001a\u00020\bH\u00c6\u0003J\t\u0010\u000b\u001a\u00020\bH\u00c6\u0003J\t\u0010\f\u001a\u00020\bH\u00c6\u0003J\t\u0010\r\u001a\u00020\bH\u00c6\u0003J\t\u0010\u000e\u001a\u00020\bH\u00c6\u0003J\t\u0010\u000f\u001a\u00020\bH\u00c6\u0003J\t\u0010\u0010\u001a\u00020\bH\u00c6\u0003J\t\u0010\u0011\u001a\u00020\bH\u00c6\u0003J\t\u0010\u0012\u001a\u00020\bH\u00c6\u0003J\u0081\u0001\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\bH\u00c6\u0001J\t\u0010 \u001a\u00020\bH\u00d6\u0001J\t\u0010!\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010\u0014\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010(\u001a\u0004\b)\u0010*R\u0017\u0010\u0015\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010+\u001a\u0004\b,\u0010-R\u0017\u0010\u0016\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010+\u001a\u0004\b.\u0010-R\u0017\u0010\u0017\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010+\u001a\u0004\b/\u0010-R\u0017\u0010\u0018\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010+\u001a\u0004\b0\u0010-R\u0017\u0010\u0019\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010+\u001a\u0004\b1\u0010-R\u0017\u0010\u001a\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010+\u001a\u0004\b2\u0010-R\u0017\u0010\u001b\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010+\u001a\u0004\b3\u0010-R\u0017\u0010\u001c\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010+\u001a\u0004\b4\u0010-R\u0017\u0010\u001d\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010+\u001a\u0004\b5\u0010-R\u0017\u0010\u001e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010+\u001a\u0004\b6\u0010-\u00a8\u0006;"}, d2 = {"Lcom/tencent/state/square/interaction/InteractionOption;", "", "Lpt4/q;", "toPB", "", "component1", "", "component2", "", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "optionId", "contentType", "optionIcon", "optionText", "resultTextTpl", "bubbleTextTpl", "criticalResultTextTpl", "criticalBubbleTextTpl", "resultMotion", "customText", "settingFixText", "interactFixText", "copy", "toString", "hashCode", "other", "", "equals", "J", "getOptionId", "()J", "I", "getContentType", "()I", "Ljava/lang/String;", "getOptionIcon", "()Ljava/lang/String;", "getOptionText", "getResultTextTpl", "getBubbleTextTpl", "getCriticalResultTextTpl", "getCriticalBubbleTextTpl", "getResultMotion", "getCustomText", "getSettingFixText", "getInteractFixText", "<init>", "(JILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "pb", "(Lpt4/q;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class InteractionOption {
    private final String bubbleTextTpl;
    private final int contentType;
    private final String criticalBubbleTextTpl;
    private final String criticalResultTextTpl;
    private final String customText;
    private final String interactFixText;
    private final String optionIcon;
    private final long optionId;
    private final String optionText;
    private final String resultMotion;
    private final String resultTextTpl;
    private final String settingFixText;

    public InteractionOption(long j3, int i3, String optionIcon, String optionText, String resultTextTpl, String bubbleTextTpl, String criticalResultTextTpl, String criticalBubbleTextTpl, String resultMotion, String customText, String settingFixText, String interactFixText) {
        Intrinsics.checkNotNullParameter(optionIcon, "optionIcon");
        Intrinsics.checkNotNullParameter(optionText, "optionText");
        Intrinsics.checkNotNullParameter(resultTextTpl, "resultTextTpl");
        Intrinsics.checkNotNullParameter(bubbleTextTpl, "bubbleTextTpl");
        Intrinsics.checkNotNullParameter(criticalResultTextTpl, "criticalResultTextTpl");
        Intrinsics.checkNotNullParameter(criticalBubbleTextTpl, "criticalBubbleTextTpl");
        Intrinsics.checkNotNullParameter(resultMotion, "resultMotion");
        Intrinsics.checkNotNullParameter(customText, "customText");
        Intrinsics.checkNotNullParameter(settingFixText, "settingFixText");
        Intrinsics.checkNotNullParameter(interactFixText, "interactFixText");
        this.optionId = j3;
        this.contentType = i3;
        this.optionIcon = optionIcon;
        this.optionText = optionText;
        this.resultTextTpl = resultTextTpl;
        this.bubbleTextTpl = bubbleTextTpl;
        this.criticalResultTextTpl = criticalResultTextTpl;
        this.criticalBubbleTextTpl = criticalBubbleTextTpl;
        this.resultMotion = resultMotion;
        this.customText = customText;
        this.settingFixText = settingFixText;
        this.interactFixText = interactFixText;
    }

    /* renamed from: component1, reason: from getter */
    public final long getOptionId() {
        return this.optionId;
    }

    /* renamed from: component10, reason: from getter */
    public final String getCustomText() {
        return this.customText;
    }

    /* renamed from: component11, reason: from getter */
    public final String getSettingFixText() {
        return this.settingFixText;
    }

    /* renamed from: component12, reason: from getter */
    public final String getInteractFixText() {
        return this.interactFixText;
    }

    /* renamed from: component2, reason: from getter */
    public final int getContentType() {
        return this.contentType;
    }

    /* renamed from: component3, reason: from getter */
    public final String getOptionIcon() {
        return this.optionIcon;
    }

    /* renamed from: component4, reason: from getter */
    public final String getOptionText() {
        return this.optionText;
    }

    /* renamed from: component5, reason: from getter */
    public final String getResultTextTpl() {
        return this.resultTextTpl;
    }

    /* renamed from: component6, reason: from getter */
    public final String getBubbleTextTpl() {
        return this.bubbleTextTpl;
    }

    /* renamed from: component7, reason: from getter */
    public final String getCriticalResultTextTpl() {
        return this.criticalResultTextTpl;
    }

    /* renamed from: component8, reason: from getter */
    public final String getCriticalBubbleTextTpl() {
        return this.criticalBubbleTextTpl;
    }

    /* renamed from: component9, reason: from getter */
    public final String getResultMotion() {
        return this.resultMotion;
    }

    public final InteractionOption copy(long optionId, int contentType, String optionIcon, String optionText, String resultTextTpl, String bubbleTextTpl, String criticalResultTextTpl, String criticalBubbleTextTpl, String resultMotion, String customText, String settingFixText, String interactFixText) {
        Intrinsics.checkNotNullParameter(optionIcon, "optionIcon");
        Intrinsics.checkNotNullParameter(optionText, "optionText");
        Intrinsics.checkNotNullParameter(resultTextTpl, "resultTextTpl");
        Intrinsics.checkNotNullParameter(bubbleTextTpl, "bubbleTextTpl");
        Intrinsics.checkNotNullParameter(criticalResultTextTpl, "criticalResultTextTpl");
        Intrinsics.checkNotNullParameter(criticalBubbleTextTpl, "criticalBubbleTextTpl");
        Intrinsics.checkNotNullParameter(resultMotion, "resultMotion");
        Intrinsics.checkNotNullParameter(customText, "customText");
        Intrinsics.checkNotNullParameter(settingFixText, "settingFixText");
        Intrinsics.checkNotNullParameter(interactFixText, "interactFixText");
        return new InteractionOption(optionId, contentType, optionIcon, optionText, resultTextTpl, bubbleTextTpl, criticalResultTextTpl, criticalBubbleTextTpl, resultMotion, customText, settingFixText, interactFixText);
    }

    public final String getBubbleTextTpl() {
        return this.bubbleTextTpl;
    }

    public final int getContentType() {
        return this.contentType;
    }

    public final String getCriticalBubbleTextTpl() {
        return this.criticalBubbleTextTpl;
    }

    public final String getCriticalResultTextTpl() {
        return this.criticalResultTextTpl;
    }

    public final String getCustomText() {
        return this.customText;
    }

    public final String getInteractFixText() {
        return this.interactFixText;
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

    public final String getResultTextTpl() {
        return this.resultTextTpl;
    }

    public final String getSettingFixText() {
        return this.settingFixText;
    }

    public int hashCode() {
        int a16 = ((c.a(this.optionId) * 31) + this.contentType) * 31;
        String str = this.optionIcon;
        int hashCode = (a16 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.optionText;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.resultTextTpl;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.bubbleTextTpl;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.criticalResultTextTpl;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.criticalBubbleTextTpl;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.resultMotion;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.customText;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.settingFixText;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.interactFixText;
        return hashCode9 + (str10 != null ? str10.hashCode() : 0);
    }

    public final q toPB() {
        q qVar = new q();
        qVar.f427214a = this.optionId;
        qVar.f427218e = this.contentType;
        qVar.f427219f = this.optionIcon;
        qVar.f427220g = this.optionText;
        qVar.f427221h = this.resultTextTpl;
        qVar.f427222i = this.bubbleTextTpl;
        qVar.f427223j = this.criticalResultTextTpl;
        qVar.f427224k = this.criticalBubbleTextTpl;
        qVar.f427225l = this.resultMotion;
        qVar.f427226m = this.customText;
        qVar.f427227n = this.settingFixText;
        qVar.f427228o = this.interactFixText;
        return qVar;
    }

    public String toString() {
        return "InteractionOption(optionId=" + this.optionId + ", contentType=" + this.contentType + ", optionIcon=" + this.optionIcon + ", optionText=" + this.optionText + ", resultTextTpl=" + this.resultTextTpl + ", bubbleTextTpl=" + this.bubbleTextTpl + ", criticalResultTextTpl=" + this.criticalResultTextTpl + ", criticalBubbleTextTpl=" + this.criticalBubbleTextTpl + ", resultMotion=" + this.resultMotion + ", customText=" + this.customText + ", settingFixText=" + this.settingFixText + ", interactFixText=" + this.interactFixText + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public InteractionOption(q pb5) {
        this(r3, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
        Intrinsics.checkNotNullParameter(pb5, "pb");
        long j3 = pb5.f427214a;
        int i3 = pb5.f427218e;
        String str = pb5.f427219f;
        Intrinsics.checkNotNullExpressionValue(str, "pb.optionIcon");
        String str2 = pb5.f427220g;
        Intrinsics.checkNotNullExpressionValue(str2, "pb.optionText");
        String str3 = pb5.f427221h;
        Intrinsics.checkNotNullExpressionValue(str3, "pb.resultTextTpl");
        String str4 = pb5.f427222i;
        Intrinsics.checkNotNullExpressionValue(str4, "pb.bubbleTextTpl");
        String str5 = pb5.f427223j;
        Intrinsics.checkNotNullExpressionValue(str5, "pb.critResultTextTpl");
        String str6 = pb5.f427224k;
        Intrinsics.checkNotNullExpressionValue(str6, "pb.cirtBubbleTextTpl");
        String str7 = pb5.f427225l;
        Intrinsics.checkNotNullExpressionValue(str7, "pb.resultMotion");
        String str8 = pb5.f427226m;
        Intrinsics.checkNotNullExpressionValue(str8, "pb.customText");
        String str9 = pb5.f427227n;
        Intrinsics.checkNotNullExpressionValue(str9, "pb.settingFixText");
        String str10 = pb5.f427228o;
        Intrinsics.checkNotNullExpressionValue(str10, "pb.interactFixText");
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InteractionOption)) {
            return false;
        }
        InteractionOption interactionOption = (InteractionOption) other;
        return this.optionId == interactionOption.optionId && this.contentType == interactionOption.contentType && Intrinsics.areEqual(this.optionIcon, interactionOption.optionIcon) && Intrinsics.areEqual(this.optionText, interactionOption.optionText) && Intrinsics.areEqual(this.resultTextTpl, interactionOption.resultTextTpl) && Intrinsics.areEqual(this.bubbleTextTpl, interactionOption.bubbleTextTpl) && Intrinsics.areEqual(this.criticalResultTextTpl, interactionOption.criticalResultTextTpl) && Intrinsics.areEqual(this.criticalBubbleTextTpl, interactionOption.criticalBubbleTextTpl) && Intrinsics.areEqual(this.resultMotion, interactionOption.resultMotion) && Intrinsics.areEqual(this.customText, interactionOption.customText) && Intrinsics.areEqual(this.settingFixText, interactionOption.settingFixText) && Intrinsics.areEqual(this.interactFixText, interactionOption.interactFixText);
    }
}
