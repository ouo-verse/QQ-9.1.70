package com.tencent.karaoke.audiobasesdk.scorer;

import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\nH\u0016J\u0016\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/scorer/MultiScoreResult;", "Ljava/io/Serializable;", "dynamicScore", "", "graceNum", "lastLongtoneScore", "lastRhythmScore", "lastSentenceMultiScoreIndex", "lastStableScore", "longtoneLengthArray", "", "longtoneScore", "longtoneScoreArray", "loudnessArray", "", "Lcom/tencent/karaoke/audiobasesdk/scorer/LoudnessItem;", "porNum", "rap", "rhythmScore", "rhythmScoreArray", "skillScore", "stableScore", "stableScoreArray", "vibNum", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public interface MultiScoreResult extends Serializable {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* loaded from: classes7.dex */
    public static final class DefaultImpls {
        public static int dynamicScore(MultiScoreResult multiScoreResult) {
            return 0;
        }

        public static int graceNum(MultiScoreResult multiScoreResult) {
            return 0;
        }

        public static int lastLongtoneScore(MultiScoreResult multiScoreResult) {
            return 0;
        }

        public static int lastRhythmScore(MultiScoreResult multiScoreResult) {
            return 0;
        }

        public static int lastSentenceMultiScoreIndex(MultiScoreResult multiScoreResult) {
            return 0;
        }

        public static int lastStableScore(MultiScoreResult multiScoreResult) {
            return 0;
        }

        @Nullable
        public static int[] longtoneLengthArray(MultiScoreResult multiScoreResult) {
            return null;
        }

        public static int longtoneScore(MultiScoreResult multiScoreResult) {
            return 0;
        }

        @Nullable
        public static int[] longtoneScoreArray(MultiScoreResult multiScoreResult) {
            return null;
        }

        @Nullable
        public static Map<Integer, LoudnessItem> loudnessArray(MultiScoreResult multiScoreResult) {
            return null;
        }

        public static int porNum(MultiScoreResult multiScoreResult) {
            return 0;
        }

        public static int rap(MultiScoreResult multiScoreResult) {
            return 0;
        }

        public static int rhythmScore(MultiScoreResult multiScoreResult) {
            return 0;
        }

        @Nullable
        public static int[] rhythmScoreArray(MultiScoreResult multiScoreResult) {
            return null;
        }

        public static int skillScore(MultiScoreResult multiScoreResult) {
            return 0;
        }

        public static int stableScore(MultiScoreResult multiScoreResult) {
            return 0;
        }

        @Nullable
        public static int[] stableScoreArray(MultiScoreResult multiScoreResult) {
            return null;
        }

        public static int vibNum(MultiScoreResult multiScoreResult) {
            return 0;
        }
    }

    int dynamicScore();

    int graceNum();

    int lastLongtoneScore();

    int lastRhythmScore();

    int lastSentenceMultiScoreIndex();

    int lastStableScore();

    @Nullable
    int[] longtoneLengthArray();

    int longtoneScore();

    @Nullable
    int[] longtoneScoreArray();

    @Nullable
    Map<Integer, LoudnessItem> loudnessArray();

    int porNum();

    int rap();

    int rhythmScore();

    @Nullable
    int[] rhythmScoreArray();

    int skillScore();

    int stableScore();

    @Nullable
    int[] stableScoreArray();

    int vibNum();
}
