package com.tencent.karaoke.audiobasesdk.scorer;

import com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\nH&J\u0016\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\r0\fH&J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fH&\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/scorer/IScoreResult;", "Lcom/tencent/karaoke/audiobasesdk/scorer/AcfScoreResult;", "Lcom/tencent/karaoke/audiobasesdk/scorer/PYinScoreResult;", "Lcom/tencent/karaoke/audiobasesdk/scorer/MultiScoreResult;", "getLastScore", "", "getLastSkillGlintCount", "getLastSkillTransliterationCount", "getLastSkillTrillCount", "getNewScores", "", "getSentenceScores", "Lkotlin/Pair;", "", "isSeek", "", "updateScoreResult", "", "nativeHandle", "", InnerAudioPlugin.AUDIO_OPERATE_SEEK, "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public interface IScoreResult extends AcfScoreResult, PYinScoreResult, MultiScoreResult {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* loaded from: classes7.dex */
    public static final class DefaultImpls {
        public static int dynamicScore(IScoreResult iScoreResult) {
            return MultiScoreResult.DefaultImpls.dynamicScore(iScoreResult);
        }

        public static int getLastSkillGlintCount(IScoreResult iScoreResult) {
            return 0;
        }

        public static int getLastSkillTransliterationCount(IScoreResult iScoreResult) {
            return 0;
        }

        public static int getLastSkillTrillCount(IScoreResult iScoreResult) {
            return 0;
        }

        public static int graceNum(IScoreResult iScoreResult) {
            return MultiScoreResult.DefaultImpls.graceNum(iScoreResult);
        }

        public static boolean isSeek(IScoreResult iScoreResult) {
            return false;
        }

        public static int lastLongtoneScore(IScoreResult iScoreResult) {
            return MultiScoreResult.DefaultImpls.lastLongtoneScore(iScoreResult);
        }

        public static int lastRhythmScore(IScoreResult iScoreResult) {
            return MultiScoreResult.DefaultImpls.lastRhythmScore(iScoreResult);
        }

        public static int lastSentenceMultiScoreIndex(IScoreResult iScoreResult) {
            return MultiScoreResult.DefaultImpls.lastSentenceMultiScoreIndex(iScoreResult);
        }

        public static int lastStableScore(IScoreResult iScoreResult) {
            return MultiScoreResult.DefaultImpls.lastStableScore(iScoreResult);
        }

        @Nullable
        public static int[] longtoneLengthArray(IScoreResult iScoreResult) {
            return MultiScoreResult.DefaultImpls.longtoneLengthArray(iScoreResult);
        }

        public static int longtoneScore(IScoreResult iScoreResult) {
            return MultiScoreResult.DefaultImpls.longtoneScore(iScoreResult);
        }

        @Nullable
        public static int[] longtoneScoreArray(IScoreResult iScoreResult) {
            return MultiScoreResult.DefaultImpls.longtoneScoreArray(iScoreResult);
        }

        @Nullable
        public static Map<Integer, LoudnessItem> loudnessArray(IScoreResult iScoreResult) {
            return MultiScoreResult.DefaultImpls.loudnessArray(iScoreResult);
        }

        public static int porNum(IScoreResult iScoreResult) {
            return MultiScoreResult.DefaultImpls.porNum(iScoreResult);
        }

        public static int rap(IScoreResult iScoreResult) {
            return MultiScoreResult.DefaultImpls.rap(iScoreResult);
        }

        public static int rhythmScore(IScoreResult iScoreResult) {
            return MultiScoreResult.DefaultImpls.rhythmScore(iScoreResult);
        }

        @Nullable
        public static int[] rhythmScoreArray(IScoreResult iScoreResult) {
            return MultiScoreResult.DefaultImpls.rhythmScoreArray(iScoreResult);
        }

        public static int skillScore(IScoreResult iScoreResult) {
            return MultiScoreResult.DefaultImpls.skillScore(iScoreResult);
        }

        public static int stableScore(IScoreResult iScoreResult) {
            return MultiScoreResult.DefaultImpls.stableScore(iScoreResult);
        }

        @Nullable
        public static int[] stableScoreArray(IScoreResult iScoreResult) {
            return MultiScoreResult.DefaultImpls.stableScoreArray(iScoreResult);
        }

        public static int vibNum(IScoreResult iScoreResult) {
            return MultiScoreResult.DefaultImpls.vibNum(iScoreResult);
        }
    }

    int getLastScore();

    int getLastSkillGlintCount();

    int getLastSkillTransliterationCount();

    int getLastSkillTrillCount();

    @Nullable
    byte[] getNewScores();

    @NotNull
    Pair<Integer, int[]> getSentenceScores();

    boolean isSeek();

    void updateScoreResult(long nativeHandle, boolean seek);
}
