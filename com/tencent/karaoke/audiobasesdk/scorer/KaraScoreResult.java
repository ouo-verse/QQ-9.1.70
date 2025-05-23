package com.tencent.karaoke.audiobasesdk.scorer;

import com.tencent.karaoke.audiobasesdk.KaraScore;
import com.tencent.karaoke.audiobasesdk.scorer.IScoreResult;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0016\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0019H\u0016J\b\u0010\u001a\u001a\u00020\fH\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\""}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/scorer/KaraScoreResult;", "Lcom/tencent/karaoke/audiobasesdk/scorer/IScoreResult;", "scorer", "Lcom/tencent/karaoke/audiobasesdk/KaraScore;", "(Lcom/tencent/karaoke/audiobasesdk/KaraScore;)V", "lastScoreTmp", "", "getLastScoreTmp", "()I", "setLastScoreTmp", "(I)V", InnerAudioPlugin.AUDIO_OPERATE_SEEK, "", "getSeek", "()Z", "setSeek", "(Z)V", "acfLastScore", "acfSentenceScores", "", "acfTotalScore", "getLastScore", "getNewScores", "", "getSentenceScores", "Lkotlin/Pair;", "isSeek", "pYinLastScore", "pYinSentenceScores", "pYinTotalScore", "updateScoreResult", "", "nativeHandle", "", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public final class KaraScoreResult implements IScoreResult {
    private int lastScoreTmp;
    private final KaraScore scorer;
    private boolean seek;

    public KaraScoreResult(@NotNull KaraScore scorer) {
        Intrinsics.checkParameterIsNotNull(scorer, "scorer");
        this.scorer = scorer;
        this.lastScoreTmp = -1;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.AcfScoreResult
    public int acfLastScore() {
        return 0;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.AcfScoreResult
    @Nullable
    public int[] acfSentenceScores() {
        return null;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.AcfScoreResult
    public int acfTotalScore() {
        return 0;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult
    /* renamed from: dynamicScore */
    public int getDynamicScore() {
        return IScoreResult.DefaultImpls.dynamicScore(this);
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScoreResult
    /* renamed from: getLastScore, reason: from getter */
    public int getLastScoreTmp() {
        return this.lastScoreTmp;
    }

    public final int getLastScoreTmp() {
        return this.lastScoreTmp;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScoreResult
    public int getLastSkillGlintCount() {
        return IScoreResult.DefaultImpls.getLastSkillGlintCount(this);
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScoreResult
    public int getLastSkillTransliterationCount() {
        return IScoreResult.DefaultImpls.getLastSkillTransliterationCount(this);
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScoreResult
    public int getLastSkillTrillCount() {
        return IScoreResult.DefaultImpls.getLastSkillTrillCount(this);
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScoreResult
    @Nullable
    public byte[] getNewScores() {
        return this.scorer.getNewScores();
    }

    public final boolean getSeek() {
        return this.seek;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScoreResult
    @NotNull
    public Pair<Integer, int[]> getSentenceScores() {
        int totalScore = this.scorer.getTotalScore();
        return new Pair<>(Integer.valueOf(totalScore), this.scorer.getAllScore());
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
        return IScoreResult.DefaultImpls.lastLongtoneScore(this);
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult
    public int lastRhythmScore() {
        return IScoreResult.DefaultImpls.lastRhythmScore(this);
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult
    public int lastSentenceMultiScoreIndex() {
        return IScoreResult.DefaultImpls.lastSentenceMultiScoreIndex(this);
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult
    public int lastStableScore() {
        return IScoreResult.DefaultImpls.lastStableScore(this);
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
        return 0;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.PYinScoreResult
    @Nullable
    public int[] pYinSentenceScores() {
        return null;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.PYinScoreResult
    public int pYinTotalScore() {
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

    public final void setLastScoreTmp(int i3) {
        this.lastScoreTmp = i3;
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
        this.seek = seek;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult
    public int vibNum() {
        return IScoreResult.DefaultImpls.vibNum(this);
    }
}
