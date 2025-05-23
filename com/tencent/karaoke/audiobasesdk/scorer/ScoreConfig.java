package com.tencent.karaoke.audiobasesdk.scorer;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0019\u0018\u0000 '2\u00020\u0001:\u0002&'B\u000f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004BO\b\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0002\u0010\u0010R\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001a\u0010\r\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0012\"\u0004\b\u001f\u0010\u0014R\u001a\u0010\t\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0012\"\u0004\b!\u0010\u0014R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u0006("}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/scorer/ScoreConfig;", "", "builder", "Lcom/tencent/karaoke/audiobasesdk/scorer/ScoreConfig$Builder;", "(Lcom/tencent/karaoke/audiobasesdk/scorer/ScoreConfig$Builder;)V", "sample", "", WadlProxyConsts.CHANNEL, "bitDepth", "scoreType", "enableBottomUpPlan", "", "enableMultiScore", "isRap", "skillParam", "", "(IIIIZZZLjava/lang/String;)V", "getBitDepth", "()I", "setBitDepth", "(I)V", "getChannel", "setChannel", "getEnableBottomUpPlan", "()Z", "setEnableBottomUpPlan", "(Z)V", "getEnableMultiScore", "setEnableMultiScore", "setRap", "getSample", "setSample", "getScoreType", "setScoreType", "getSkillParam", "()Ljava/lang/String;", "setSkillParam", "(Ljava/lang/String;)V", "Builder", "Companion", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public final class ScoreConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private int bitDepth;
    private int channel;
    private boolean enableBottomUpPlan;
    private boolean enableMultiScore;
    private boolean isRap;
    private int sample;
    private int scoreType;

    @Nullable
    private String skillParam;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010&\u001a\u00020'J\u0006\u0010\u0014\u001a\u00020(J\u0006\u0010)\u001a\u00020(J\u0006\u0010*\u001a\u00020(J\u0006\u0010\u0017\u001a\u00020(R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u000fX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001a\u0010\u001a\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\b\"\u0004\b\u001c\u0010\nR\u001a\u0010\u001d\u001a\u00020\u0004X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\b\"\u0004\b\u001f\u0010\nR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/scorer/ScoreConfig$Builder;", "", "()V", "acfAndPYin", "", "acfScoreSwitch", "bitDepth", "getBitDepth", "()I", "setBitDepth", "(I)V", WadlProxyConsts.CHANNEL, "getChannel", "setChannel", "enableBottomUpPlan", "", "getEnableBottomUpPlan", "()Z", "setEnableBottomUpPlan", "(Z)V", "enableMultiScore", "getEnableMultiScore$lib_audiobasesdk_release", "setEnableMultiScore$lib_audiobasesdk_release", "multiScoreIsRap", "getMultiScoreIsRap$lib_audiobasesdk_release", "setMultiScoreIsRap$lib_audiobasesdk_release", "sample", "getSample", "setSample", "scoreType", "getScoreType$lib_audiobasesdk_release", "setScoreType$lib_audiobasesdk_release", "skillParam", "", "getSkillParam", "()Ljava/lang/String;", "setSkillParam", "(Ljava/lang/String;)V", "build", "Lcom/tencent/karaoke/audiobasesdk/scorer/ScoreConfig;", "", "enableOldAcfScore", "forbidPYinScore", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes7.dex */
    public static final class Builder {
        private int acfScoreSwitch;
        private int bitDepth;
        private int channel;
        private boolean enableBottomUpPlan;
        private boolean enableMultiScore;
        private boolean multiScoreIsRap;
        private int sample;

        @Nullable
        private String skillParam;
        private int scoreType = 2;
        private int acfAndPYin = 2;

        @NotNull
        public final ScoreConfig build() {
            this.scoreType = this.acfScoreSwitch | this.acfAndPYin;
            return new ScoreConfig(this, null);
        }

        public final void enableMultiScore() {
            this.enableMultiScore = true;
        }

        public final void enableOldAcfScore() {
            this.acfScoreSwitch = 128;
        }

        public final void forbidPYinScore() {
            this.acfAndPYin = 1;
        }

        public final int getBitDepth() {
            return this.bitDepth;
        }

        public final int getChannel() {
            return this.channel;
        }

        public final boolean getEnableBottomUpPlan() {
            return this.enableBottomUpPlan;
        }

        /* renamed from: getEnableMultiScore$lib_audiobasesdk_release, reason: from getter */
        public final boolean getEnableMultiScore() {
            return this.enableMultiScore;
        }

        /* renamed from: getMultiScoreIsRap$lib_audiobasesdk_release, reason: from getter */
        public final boolean getMultiScoreIsRap() {
            return this.multiScoreIsRap;
        }

        public final int getSample() {
            return this.sample;
        }

        /* renamed from: getScoreType$lib_audiobasesdk_release, reason: from getter */
        public final int getScoreType() {
            return this.scoreType;
        }

        @Nullable
        public final String getSkillParam() {
            return this.skillParam;
        }

        public final void multiScoreIsRap() {
            this.multiScoreIsRap = true;
        }

        public final void setBitDepth(int i3) {
            this.bitDepth = i3;
        }

        public final void setChannel(int i3) {
            this.channel = i3;
        }

        public final void setEnableBottomUpPlan(boolean z16) {
            this.enableBottomUpPlan = z16;
        }

        public final void setEnableMultiScore$lib_audiobasesdk_release(boolean z16) {
            this.enableMultiScore = z16;
        }

        public final void setMultiScoreIsRap$lib_audiobasesdk_release(boolean z16) {
            this.multiScoreIsRap = z16;
        }

        public final void setSample(int i3) {
            this.sample = i3;
        }

        public final void setScoreType$lib_audiobasesdk_release(int i3) {
            this.scoreType = i3;
        }

        public final void setSkillParam(@Nullable String str) {
            this.skillParam = str;
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006\u00a2\u0006\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/scorer/ScoreConfig$Companion;", "", "()V", "with", "Lcom/tencent/karaoke/audiobasesdk/scorer/ScoreConfig;", "body", "Lkotlin/Function1;", "Lcom/tencent/karaoke/audiobasesdk/scorer/ScoreConfig$Builder;", "Lkotlin/ExtensionFunctionType;", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final ScoreConfig with(@NotNull Function1<? super Builder, ScoreConfig> body) {
            Intrinsics.checkParameterIsNotNull(body, "body");
            return body.invoke(new Builder());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    ScoreConfig(int i3, int i16, int i17, int i18, boolean z16, boolean z17, boolean z18, String str) {
        this.sample = i3;
        this.channel = i16;
        this.bitDepth = i17;
        this.scoreType = i18;
        this.enableBottomUpPlan = z16;
        this.enableMultiScore = z17;
        this.isRap = z18;
        this.skillParam = str;
    }

    public final int getBitDepth() {
        return this.bitDepth;
    }

    public final int getChannel() {
        return this.channel;
    }

    public final boolean getEnableBottomUpPlan() {
        return this.enableBottomUpPlan;
    }

    public final boolean getEnableMultiScore() {
        return this.enableMultiScore;
    }

    public final int getSample() {
        return this.sample;
    }

    public final int getScoreType() {
        return this.scoreType;
    }

    @Nullable
    public final String getSkillParam() {
        return this.skillParam;
    }

    /* renamed from: isRap, reason: from getter */
    public final boolean getIsRap() {
        return this.isRap;
    }

    public final void setBitDepth(int i3) {
        this.bitDepth = i3;
    }

    public final void setChannel(int i3) {
        this.channel = i3;
    }

    public final void setEnableBottomUpPlan(boolean z16) {
        this.enableBottomUpPlan = z16;
    }

    public final void setEnableMultiScore(boolean z16) {
        this.enableMultiScore = z16;
    }

    public final void setRap(boolean z16) {
        this.isRap = z16;
    }

    public final void setSample(int i3) {
        this.sample = i3;
    }

    public final void setScoreType(int i3) {
        this.scoreType = i3;
    }

    public final void setSkillParam(@Nullable String str) {
        this.skillParam = str;
    }

    public /* synthetic */ ScoreConfig(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    /* synthetic */ ScoreConfig(int i3, int i16, int i17, int i18, boolean z16, boolean z17, boolean z18, String str, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this((i19 & 1) != 0 ? 0 : i3, (i19 & 2) != 0 ? 0 : i16, (i19 & 4) != 0 ? 0 : i17, i18, z16, z17, z18, str);
    }

    ScoreConfig(Builder builder) {
        this(builder.getSample(), builder.getChannel(), builder.getBitDepth(), builder.getScoreType(), builder.getEnableBottomUpPlan(), builder.getEnableMultiScore(), builder.getMultiScoreIsRap(), builder.getSkillParam());
    }
}
