package com.tencent.karaoke.audiobasesdk.scorer;

import com.tencent.component.utils.LogUtil;
import com.tencent.karaoke.audiobasesdk.scorer.IScoreResult;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 -2\u00020\u0001:\u0001-B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0016J\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u0016H\u0016J\b\u0010\u001d\u001a\u00020\u0016H\u0016J\b\u0010\u001e\u001a\u00020\u0016H\u0016J\b\u0010\u001f\u001a\u00020\u0016H\u0016J\n\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0016\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00180#H\u0016J\b\u0010$\u001a\u00020\u0010H\u0016J\b\u0010%\u001a\u00020\u0016H\u0016J\b\u0010&\u001a\u00020\u0016H\u0016J\b\u0010'\u001a\u00020\u0016H\u0016J\b\u0010(\u001a\u00020\u0016H\u0016J\b\u0010)\u001a\u00020\u0016H\u0016J\n\u0010*\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010+\u001a\u00020\u0016H\u0016J\u0018\u0010,\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006."}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/scorer/ScoreResult;", "Lcom/tencent/karaoke/audiobasesdk/scorer/IScoreResult;", "scorerNativeBridge", "Lcom/tencent/karaoke/audiobasesdk/scorer/ScorerNativeBridge;", "policy", "Lcom/tencent/karaoke/audiobasesdk/scorer/Policy;", "(Lcom/tencent/karaoke/audiobasesdk/scorer/ScorerNativeBridge;Lcom/tencent/karaoke/audiobasesdk/scorer/Policy;)V", "hitPolicyFlag", "", "nativeHandle", "", "getPolicy", "()Lcom/tencent/karaoke/audiobasesdk/scorer/Policy;", "setPolicy", "(Lcom/tencent/karaoke/audiobasesdk/scorer/Policy;)V", InnerAudioPlugin.AUDIO_OPERATE_SEEK, "", "getSeek", "()Z", "setSeek", "(Z)V", "acfLastScore", "", "acfSentenceScores", "", "acfTotalScore", "destroy", "", "getLastScore", "getLastSkillGlintCount", "getLastSkillTransliterationCount", "getLastSkillTrillCount", "getNewScores", "", "getSentenceScores", "Lkotlin/Pair;", "isSeek", "lastLongtoneScore", "lastRhythmScore", "lastSentenceMultiScoreIndex", "lastStableScore", "pYinLastScore", "pYinSentenceScores", "pYinTotalScore", "updateScoreResult", "Companion", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public final class ScoreResult implements IScoreResult {
    public static final int RESULT_DEFAULT_VALUE = 0;
    private boolean[] hitPolicyFlag;
    private long nativeHandle;

    @NotNull
    private Policy policy;
    private ScorerNativeBridge scorerNativeBridge;
    private boolean seek;

    public ScoreResult(@NotNull ScorerNativeBridge scorerNativeBridge, @NotNull Policy policy) {
        Intrinsics.checkParameterIsNotNull(scorerNativeBridge, "scorerNativeBridge");
        Intrinsics.checkParameterIsNotNull(policy, "policy");
        this.scorerNativeBridge = scorerNativeBridge;
        this.policy = policy;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.AcfScoreResult
    public int acfLastScore() {
        long j3 = this.nativeHandle;
        if (j3 != 0) {
            return this.scorerNativeBridge.lastScore(j3, 1);
        }
        return 0;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.AcfScoreResult
    @Nullable
    public int[] acfSentenceScores() {
        long j3 = this.nativeHandle;
        if (j3 != 0) {
            return this.scorerNativeBridge.sentenceScores(j3, 1);
        }
        return null;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.AcfScoreResult
    public int acfTotalScore() {
        long j3 = this.nativeHandle;
        if (j3 != 0) {
            return this.scorerNativeBridge.totalScore(j3, 1);
        }
        return 0;
    }

    public final void destroy() {
        this.nativeHandle = 0L;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult
    /* renamed from: dynamicScore */
    public int getDynamicScore() {
        return IScoreResult.DefaultImpls.dynamicScore(this);
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScoreResult
    /* renamed from: getLastScore */
    public int getLastScoreTmp() {
        int max;
        int acfLastScore = acfLastScore();
        int pYinLastScore = pYinLastScore();
        if (this.policy.getOriginalSpeaker()) {
            LogUtil.i(ConstantsKt.SCORE_TAG, "Hit strategy,the result will divide hitValue");
            max = Math.max(acfLastScore, pYinLastScore);
            if (max >= 0) {
                max = (max * this.policy.getHitValueNumerator()) / this.policy.getHitValueDenominator();
            }
        } else {
            max = Math.max(acfLastScore, pYinLastScore);
        }
        if (max < 0) {
            return 0;
        }
        return max;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScoreResult
    public int getLastSkillGlintCount() {
        long j3 = this.nativeHandle;
        if (j3 != 0) {
            return this.scorerNativeBridge.getLastSkillGlintCount(j3);
        }
        return 0;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScoreResult
    public int getLastSkillTransliterationCount() {
        long j3 = this.nativeHandle;
        if (j3 != 0) {
            return this.scorerNativeBridge.getLastSkillTransliterationCount(j3);
        }
        return 0;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScoreResult
    public int getLastSkillTrillCount() {
        long j3 = this.nativeHandle;
        if (j3 != 0) {
            return this.scorerNativeBridge.getLastSkillTrillCount(j3);
        }
        return 0;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScoreResult
    @Nullable
    public byte[] getNewScores() {
        long j3 = this.nativeHandle;
        if (j3 != 0) {
            return this.scorerNativeBridge.native_new_scores(j3, this.policy.getHitValueNumerator(), this.policy.getHitValueDenominator(), this.hitPolicyFlag);
        }
        return null;
    }

    @NotNull
    public final Policy getPolicy() {
        return this.policy;
    }

    public final boolean getSeek() {
        return this.seek;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScoreResult
    @NotNull
    public Pair<Integer, int[]> getSentenceScores() {
        boolean z16;
        boolean z17;
        boolean z18;
        int[] acfSentenceScores = acfSentenceScores();
        int i3 = 0;
        if (acfSentenceScores != null) {
            int[] pYinSentenceScores = pYinSentenceScores();
            if (pYinSentenceScores != null) {
                int length = acfSentenceScores.length;
                int length2 = pYinSentenceScores.length;
                if (length != length2) {
                    length = Math.min(length, length2);
                    LogUtil.w(ConstantsKt.SCORE_TAG, "warn!!!!!! AcfScores size:" + length + ",pYinSize:" + length2 + TokenParser.SP);
                }
                int[] iArr = new int[length];
                Arrays.fill(iArr, -1);
                int i16 = 0;
                for (int i17 = 0; i17 < length; i17++) {
                    boolean[] zArr = this.hitPolicyFlag;
                    if (zArr != null) {
                        z18 = zArr[i17];
                    } else {
                        z18 = false;
                    }
                    int max = Math.max(acfSentenceScores[i17], pYinSentenceScores[i17]);
                    if (max >= 0) {
                        if (z18) {
                            max = (max * this.policy.getHitValueNumerator()) / this.policy.getHitValueDenominator();
                        }
                        iArr[i17] = max;
                        i16 += max;
                    }
                }
                return new Pair<>(Integer.valueOf(i16), iArr);
            }
            if (this.policy.getOriginalSpeaker()) {
                int[] acfSentenceScores2 = acfSentenceScores();
                if (acfSentenceScores2 != null) {
                    int length3 = acfSentenceScores2.length;
                    int i18 = 0;
                    for (int i19 = 0; i19 < length3; i19++) {
                        boolean[] zArr2 = this.hitPolicyFlag;
                        if (zArr2 != null) {
                            z17 = zArr2[i19];
                        } else {
                            z17 = false;
                        }
                        int i26 = acfSentenceScores2[i19];
                        if (i26 >= 0 && z17) {
                            int hitValueNumerator = (i26 * this.policy.getHitValueNumerator()) / this.policy.getHitValueDenominator();
                            acfSentenceScores2[i19] = hitValueNumerator;
                            i18 += hitValueNumerator;
                        }
                    }
                    i3 = i18;
                }
                return new Pair<>(Integer.valueOf(i3), acfSentenceScores2);
            }
            return new Pair<>(Integer.valueOf(acfTotalScore()), acfSentenceScores());
        }
        if (this.policy.getOriginalSpeaker()) {
            int[] pYinSentenceScores2 = pYinSentenceScores();
            if (pYinSentenceScores2 != null) {
                int length4 = pYinSentenceScores2.length;
                int i27 = 0;
                for (int i28 = 0; i28 < length4; i28++) {
                    boolean[] zArr3 = this.hitPolicyFlag;
                    if (zArr3 != null) {
                        z16 = zArr3[i28];
                    } else {
                        z16 = false;
                    }
                    int i29 = pYinSentenceScores2[i28];
                    if (i29 >= 0 && z16) {
                        int hitValueNumerator2 = (i29 * this.policy.getHitValueNumerator()) / this.policy.getHitValueDenominator();
                        pYinSentenceScores2[i28] = hitValueNumerator2;
                        i27 += hitValueNumerator2;
                    }
                }
                i3 = i27;
            }
            return new Pair<>(Integer.valueOf(i3), pYinSentenceScores2);
        }
        return new Pair<>(Integer.valueOf(pYinTotalScore()), pYinSentenceScores());
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult
    public int graceNum() {
        return IScoreResult.DefaultImpls.graceNum(this);
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScoreResult
    public boolean isSeek() {
        return this.seek;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult
    public int lastLongtoneScore() {
        long j3 = this.nativeHandle;
        if (j3 != 0) {
            return this.scorerNativeBridge.getLastSentenceLongtoneScore(j3);
        }
        return 0;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult
    public int lastRhythmScore() {
        long j3 = this.nativeHandle;
        if (j3 != 0) {
            return this.scorerNativeBridge.getLastSentenceRhythmScore(j3);
        }
        return 0;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult
    public int lastSentenceMultiScoreIndex() {
        long j3 = this.nativeHandle;
        if (j3 != 0) {
            return this.scorerNativeBridge.getLastSentenceMultiScoreIndex(j3);
        }
        return 0;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult
    public int lastStableScore() {
        long j3 = this.nativeHandle;
        if (j3 != 0) {
            return this.scorerNativeBridge.getLastSentenceStableScore(j3);
        }
        return 0;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult
    @Nullable
    public int[] longtoneLengthArray() {
        return IScoreResult.DefaultImpls.longtoneLengthArray(this);
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult
    public int longtoneScore() {
        return IScoreResult.DefaultImpls.longtoneScore(this);
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult
    @Nullable
    public int[] longtoneScoreArray() {
        return IScoreResult.DefaultImpls.longtoneScoreArray(this);
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult
    @Nullable
    public Map<Integer, LoudnessItem> loudnessArray() {
        return IScoreResult.DefaultImpls.loudnessArray(this);
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.PYinScoreResult
    public int pYinLastScore() {
        long j3 = this.nativeHandle;
        if (j3 != 0) {
            return this.scorerNativeBridge.lastScore(j3, 2);
        }
        return 0;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.PYinScoreResult
    @Nullable
    public int[] pYinSentenceScores() {
        long j3 = this.nativeHandle;
        if (j3 != 0) {
            return this.scorerNativeBridge.sentenceScores(j3, 2);
        }
        return null;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.PYinScoreResult
    public int pYinTotalScore() {
        long j3 = this.nativeHandle;
        if (j3 != 0) {
            return this.scorerNativeBridge.totalScore(j3, 2);
        }
        return 0;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult
    public int porNum() {
        return IScoreResult.DefaultImpls.porNum(this);
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult
    public int rap() {
        return IScoreResult.DefaultImpls.rap(this);
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult
    public int rhythmScore() {
        return IScoreResult.DefaultImpls.rhythmScore(this);
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult
    @Nullable
    public int[] rhythmScoreArray() {
        return IScoreResult.DefaultImpls.rhythmScoreArray(this);
    }

    public final void setPolicy(@NotNull Policy policy) {
        Intrinsics.checkParameterIsNotNull(policy, "<set-?>");
        this.policy = policy;
    }

    public final void setSeek(boolean z16) {
        this.seek = z16;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult
    public int skillScore() {
        return IScoreResult.DefaultImpls.skillScore(this);
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult
    public int stableScore() {
        return IScoreResult.DefaultImpls.stableScore(this);
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult
    @Nullable
    public int[] stableScoreArray() {
        return IScoreResult.DefaultImpls.stableScoreArray(this);
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScoreResult
    public void updateScoreResult(long nativeHandle, boolean seek) {
        int stcIndex;
        boolean[] zArr;
        if (this.nativeHandle != nativeHandle) {
            this.nativeHandle = nativeHandle;
        }
        this.seek = seek;
        if (this.hitPolicyFlag == null) {
            this.hitPolicyFlag = new boolean[this.scorerNativeBridge.validSentenceNum()];
        }
        if (seek) {
            stcIndex = this.policy.getStcIndex() + 1;
        } else {
            stcIndex = this.policy.getStcIndex();
        }
        if (stcIndex >= 0) {
            boolean[] zArr2 = this.hitPolicyFlag;
            if (zArr2 == null) {
                Intrinsics.throwNpe();
            }
            int length = zArr2.length;
            for (int i3 = stcIndex; i3 < length; i3++) {
                boolean[] zArr3 = this.hitPolicyFlag;
                if (zArr3 != null) {
                    zArr3[i3] = false;
                }
            }
            boolean[] zArr4 = this.hitPolicyFlag;
            if (zArr4 == null) {
                Intrinsics.throwNpe();
            }
            if (stcIndex < zArr4.length && (zArr = this.hitPolicyFlag) != null) {
                zArr[stcIndex] = this.policy.getOriginalSpeaker();
            }
        }
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult
    public int vibNum() {
        return IScoreResult.DefaultImpls.vibNum(this);
    }
}
