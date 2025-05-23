package com.tencent.karaoke.audiobasesdk.scorer;

import com.tencent.ams.dsdk.core.DKConfiguration;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0014\n\u0002\b'\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 =2\u00020\u0001:\u0001=B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0012\b\u0002\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e\u00a2\u0006\u0002\u0010\u0010J\t\u0010+\u001a\u00020\u0003H\u00c6\u0003J\t\u0010,\u001a\u00020\u0003H\u00c6\u0003J\t\u0010-\u001a\u00020\u0003H\u00c6\u0003J\t\u0010.\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\t\u00100\u001a\u00020\u0003H\u00c6\u0003J\t\u00101\u001a\u00020\u000bH\u00c6\u0003J\t\u00102\u001a\u00020\u000bH\u00c6\u0003J\u0018\u00103\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000eH\u00c6\u0003\u00a2\u0006\u0002\u0010%Jt\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u0012\b\u0002\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000eH\u00c6\u0001\u00a2\u0006\u0002\u00105J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109H\u0096\u0002J\b\u0010:\u001a\u00020\u0003H\u0016J\t\u0010;\u001a\u00020<H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0012\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0012\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0015R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0012\"\u0004\b\u001f\u0010\u0015R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R&\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010!\"\u0004\b*\u0010#\u00a8\u0006>"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/scorer/MultiScoreStcInfo;", "Ljava/io/Serializable;", "stableSetScore", "", "rhythmSetScore", "longtoneSetScore", "longtoneSetLength", "loudnessItem", "Lcom/tencent/karaoke/audiobasesdk/scorer/LoudnessItem;", "stcIdx", DKConfiguration.Directory.TEMPLATES, "", "userTemplates", "userSkillFeatures", "", "", "(IIIILcom/tencent/karaoke/audiobasesdk/scorer/LoudnessItem;I[I[I[[F)V", "getLongtoneSetLength", "()I", "getLongtoneSetScore", "setLongtoneSetScore", "(I)V", "getLoudnessItem", "()Lcom/tencent/karaoke/audiobasesdk/scorer/LoudnessItem;", "setLoudnessItem", "(Lcom/tencent/karaoke/audiobasesdk/scorer/LoudnessItem;)V", "getRhythmSetScore", "setRhythmSetScore", "getStableSetScore", "setStableSetScore", "getStcIdx", "setStcIdx", "getTemplates", "()[I", "setTemplates", "([I)V", "getUserSkillFeatures", "()[[F", "setUserSkillFeatures", "([[F)V", "[[F", "getUserTemplates", "setUserTemplates", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(IIIILcom/tencent/karaoke/audiobasesdk/scorer/LoudnessItem;I[I[I[[F)Lcom/tencent/karaoke/audiobasesdk/scorer/MultiScoreStcInfo;", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public final /* data */ class MultiScoreStcInfo implements Serializable {
    public static final int FEATURE_END_TIME = 6;
    public static final int FEATURE_START_TIME = 5;
    public static final int INDEX_DURATION = 1;
    public static final int INDEX_FEATURE_1 = 2;
    public static final int INDEX_FEATURE_2 = 3;
    public static final int INDEX_FEATURE_3 = 4;
    public static final int INDEX_SIGN = 0;
    public static final float SKILL_GLIDE = 1.0f;
    public static final int SKILL_LENGTH = 7;
    public static final float SKILL_WARBLE = 0.0f;
    private final int longtoneSetLength;
    private int longtoneSetScore;

    @Nullable
    private LoudnessItem loudnessItem;
    private int rhythmSetScore;
    private int stableSetScore;
    private int stcIdx;

    @NotNull
    private int[] templates;

    @Nullable
    private float[][] userSkillFeatures;

    @NotNull
    private int[] userTemplates;

    public MultiScoreStcInfo(int i3, int i16, int i17, int i18, @Nullable LoudnessItem loudnessItem, int i19, @NotNull int[] templates, @NotNull int[] userTemplates, @Nullable float[][] fArr) {
        Intrinsics.checkParameterIsNotNull(templates, "templates");
        Intrinsics.checkParameterIsNotNull(userTemplates, "userTemplates");
        this.stableSetScore = i3;
        this.rhythmSetScore = i16;
        this.longtoneSetScore = i17;
        this.longtoneSetLength = i18;
        this.loudnessItem = loudnessItem;
        this.stcIdx = i19;
        this.templates = templates;
        this.userTemplates = userTemplates;
        this.userSkillFeatures = fArr;
    }

    /* renamed from: component1, reason: from getter */
    public final int getStableSetScore() {
        return this.stableSetScore;
    }

    /* renamed from: component2, reason: from getter */
    public final int getRhythmSetScore() {
        return this.rhythmSetScore;
    }

    /* renamed from: component3, reason: from getter */
    public final int getLongtoneSetScore() {
        return this.longtoneSetScore;
    }

    /* renamed from: component4, reason: from getter */
    public final int getLongtoneSetLength() {
        return this.longtoneSetLength;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final LoudnessItem getLoudnessItem() {
        return this.loudnessItem;
    }

    /* renamed from: component6, reason: from getter */
    public final int getStcIdx() {
        return this.stcIdx;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final int[] getTemplates() {
        return this.templates;
    }

    @NotNull
    /* renamed from: component8, reason: from getter */
    public final int[] getUserTemplates() {
        return this.userTemplates;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final float[][] getUserSkillFeatures() {
        return this.userSkillFeatures;
    }

    @NotNull
    public final MultiScoreStcInfo copy(int stableSetScore, int rhythmSetScore, int longtoneSetScore, int longtoneSetLength, @Nullable LoudnessItem loudnessItem, int stcIdx, @NotNull int[] templates, @NotNull int[] userTemplates, @Nullable float[][] userSkillFeatures) {
        Intrinsics.checkParameterIsNotNull(templates, "templates");
        Intrinsics.checkParameterIsNotNull(userTemplates, "userTemplates");
        return new MultiScoreStcInfo(stableSetScore, rhythmSetScore, longtoneSetScore, longtoneSetLength, loudnessItem, stcIdx, templates, userTemplates, userSkillFeatures);
    }

    public boolean equals(@Nullable Object other) {
        if (other != null && (other instanceof MultiScoreStcInfo) && ((MultiScoreStcInfo) other).stcIdx == this.stcIdx) {
            return true;
        }
        return false;
    }

    public final int getLongtoneSetLength() {
        return this.longtoneSetLength;
    }

    public final int getLongtoneSetScore() {
        return this.longtoneSetScore;
    }

    @Nullable
    public final LoudnessItem getLoudnessItem() {
        return this.loudnessItem;
    }

    public final int getRhythmSetScore() {
        return this.rhythmSetScore;
    }

    public final int getStableSetScore() {
        return this.stableSetScore;
    }

    public final int getStcIdx() {
        return this.stcIdx;
    }

    @NotNull
    public final int[] getTemplates() {
        return this.templates;
    }

    @Nullable
    public final float[][] getUserSkillFeatures() {
        return this.userSkillFeatures;
    }

    @NotNull
    public final int[] getUserTemplates() {
        return this.userTemplates;
    }

    public int hashCode() {
        int i3;
        int i16 = ((((((this.stableSetScore * 31) + this.rhythmSetScore) * 31) + this.longtoneSetScore) * 31) + this.longtoneSetLength) * 31;
        LoudnessItem loudnessItem = this.loudnessItem;
        int i17 = 0;
        if (loudnessItem != null) {
            i3 = loudnessItem.hashCode();
        } else {
            i3 = 0;
        }
        int hashCode = (((((((i16 + i3) * 31) + this.stcIdx) * 31) + Arrays.hashCode(this.templates)) * 31) + Arrays.hashCode(this.userTemplates)) * 31;
        float[][] fArr = this.userSkillFeatures;
        if (fArr != null) {
            i17 = ArraysKt.contentDeepHashCode(fArr);
        }
        return hashCode + i17;
    }

    public final void setLongtoneSetScore(int i3) {
        this.longtoneSetScore = i3;
    }

    public final void setLoudnessItem(@Nullable LoudnessItem loudnessItem) {
        this.loudnessItem = loudnessItem;
    }

    public final void setRhythmSetScore(int i3) {
        this.rhythmSetScore = i3;
    }

    public final void setStableSetScore(int i3) {
        this.stableSetScore = i3;
    }

    public final void setStcIdx(int i3) {
        this.stcIdx = i3;
    }

    public final void setTemplates(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "<set-?>");
        this.templates = iArr;
    }

    public final void setUserSkillFeatures(@Nullable float[][] fArr) {
        this.userSkillFeatures = fArr;
    }

    public final void setUserTemplates(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "<set-?>");
        this.userTemplates = iArr;
    }

    @NotNull
    public String toString() {
        return "MultiScoreStcInfo(stableSetScore=" + this.stableSetScore + ", rhythmSetScore=" + this.rhythmSetScore + ", longtoneSetScore=" + this.longtoneSetScore + ", longtoneSetLength=" + this.longtoneSetLength + ", loudnessItem=" + this.loudnessItem + ", stcIdx=" + this.stcIdx + ", templates=" + Arrays.toString(this.templates) + ", userTemplates=" + Arrays.toString(this.userTemplates) + ", userSkillFeatures=" + Arrays.toString(this.userSkillFeatures) + ")";
    }

    public /* synthetic */ MultiScoreStcInfo(int i3, int i16, int i17, int i18, LoudnessItem loudnessItem, int i19, int[] iArr, int[] iArr2, float[][] fArr, int i26, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i16, i17, i18, loudnessItem, i19, iArr, iArr2, (i26 & 256) != 0 ? null : fArr);
    }
}
