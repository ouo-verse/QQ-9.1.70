package com.tencent.karaoke.audiobasesdk.scorer;

import com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0015\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010$\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u000fH\u0016J\u0016\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001c\u0018\u000106H\u0016J\b\u0010!\u001a\u00020\u0004H\u0016J\b\u00107\u001a\u00020\u0004H\u0016J\b\u0010$\u001a\u00020\u0004H\u0016J\n\u0010'\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010*\u001a\u00020\u0004H\u0016J\b\u0010-\u001a\u00020\u0004H\u0016J\n\u00100\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u00103\u001a\u00020\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R(\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001a\u0010$\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001c\u0010'\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0011\"\u0004\b)\u0010\u0013R\u001a\u0010*\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001a\u0010-\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\u001c\u00100\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0011\"\u0004\b2\u0010\u0013R\u001a\u00103\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\b\u00a8\u00068"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/scorer/FinalMultiScoreResultImpl;", "Lcom/tencent/karaoke/audiobasesdk/scorer/MultiScoreResult;", "()V", "dynamicScore", "", "getDynamicScore", "()I", "setDynamicScore", "(I)V", "graceNum", "getGraceNum", "setGraceNum", "isRap", "setRap", "longtoneLengthArray", "", "getLongtoneLengthArray", "()[I", "setLongtoneLengthArray", "([I)V", "longtoneScore", "getLongtoneScore", "setLongtoneScore", "longtoneScoreArray", "getLongtoneScoreArray", "setLongtoneScoreArray", "loudnessArray", "Ljava/util/HashMap;", "Lcom/tencent/karaoke/audiobasesdk/scorer/LoudnessItem;", "getLoudnessArray", "()Ljava/util/HashMap;", "setLoudnessArray", "(Ljava/util/HashMap;)V", "porNum", "getPorNum", "setPorNum", "rhythmScore", "getRhythmScore", "setRhythmScore", "rhythmScoreArray", "getRhythmScoreArray", "setRhythmScoreArray", "skillScore", "getSkillScore", "setSkillScore", "stableScore", "getStableScore", "setStableScore", "stableScoreArray", "getStableScoreArray", "setStableScoreArray", "vibNum", "getVibNum", "setVibNum", "", "rap", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public final class FinalMultiScoreResultImpl implements MultiScoreResult {
    private int dynamicScore;
    private int graceNum;
    private int isRap;

    @Nullable
    private int[] longtoneLengthArray;
    private int longtoneScore;

    @Nullable
    private int[] longtoneScoreArray;

    @Nullable
    private HashMap<Integer, LoudnessItem> loudnessArray;
    private int porNum;
    private int rhythmScore;

    @Nullable
    private int[] rhythmScoreArray;
    private int skillScore;
    private int stableScore;

    @Nullable
    private int[] stableScoreArray;
    private int vibNum;

    @Override // com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult
    /* renamed from: dynamicScore, reason: from getter */
    public int getDynamicScore() {
        return this.dynamicScore;
    }

    public final int getDynamicScore() {
        return this.dynamicScore;
    }

    public final int getGraceNum() {
        return this.graceNum;
    }

    @Nullable
    public final int[] getLongtoneLengthArray() {
        return this.longtoneLengthArray;
    }

    public final int getLongtoneScore() {
        return this.longtoneScore;
    }

    @Nullable
    public final int[] getLongtoneScoreArray() {
        return this.longtoneScoreArray;
    }

    @Nullable
    public final HashMap<Integer, LoudnessItem> getLoudnessArray() {
        return this.loudnessArray;
    }

    public final int getPorNum() {
        return this.porNum;
    }

    public final int getRhythmScore() {
        return this.rhythmScore;
    }

    @Nullable
    public final int[] getRhythmScoreArray() {
        return this.rhythmScoreArray;
    }

    public final int getSkillScore() {
        return this.skillScore;
    }

    public final int getStableScore() {
        return this.stableScore;
    }

    @Nullable
    public final int[] getStableScoreArray() {
        return this.stableScoreArray;
    }

    public final int getVibNum() {
        return this.vibNum;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult
    public int graceNum() {
        return this.graceNum;
    }

    /* renamed from: isRap, reason: from getter */
    public final int getIsRap() {
        return this.isRap;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult
    public int lastLongtoneScore() {
        return MultiScoreResult.DefaultImpls.lastLongtoneScore(this);
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult
    public int lastRhythmScore() {
        return MultiScoreResult.DefaultImpls.lastRhythmScore(this);
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult
    public int lastSentenceMultiScoreIndex() {
        return MultiScoreResult.DefaultImpls.lastSentenceMultiScoreIndex(this);
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult
    public int lastStableScore() {
        return MultiScoreResult.DefaultImpls.lastStableScore(this);
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult
    @Nullable
    public int[] longtoneLengthArray() {
        return this.longtoneLengthArray;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult
    public int longtoneScore() {
        return this.longtoneScore;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult
    @Nullable
    public int[] longtoneScoreArray() {
        return this.longtoneScoreArray;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult
    @Nullable
    public Map<Integer, LoudnessItem> loudnessArray() {
        return this.loudnessArray;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult
    public int porNum() {
        return this.porNum;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult
    public int rap() {
        return this.isRap;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult
    public int rhythmScore() {
        return this.rhythmScore;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult
    @Nullable
    public int[] rhythmScoreArray() {
        return this.rhythmScoreArray;
    }

    public final void setDynamicScore(int i3) {
        this.dynamicScore = i3;
    }

    public final void setGraceNum(int i3) {
        this.graceNum = i3;
    }

    public final void setLongtoneLengthArray(@Nullable int[] iArr) {
        this.longtoneLengthArray = iArr;
    }

    public final void setLongtoneScore(int i3) {
        this.longtoneScore = i3;
    }

    public final void setLongtoneScoreArray(@Nullable int[] iArr) {
        this.longtoneScoreArray = iArr;
    }

    public final void setLoudnessArray(@Nullable HashMap<Integer, LoudnessItem> hashMap) {
        this.loudnessArray = hashMap;
    }

    public final void setPorNum(int i3) {
        this.porNum = i3;
    }

    public final void setRap(int i3) {
        this.isRap = i3;
    }

    public final void setRhythmScore(int i3) {
        this.rhythmScore = i3;
    }

    public final void setRhythmScoreArray(@Nullable int[] iArr) {
        this.rhythmScoreArray = iArr;
    }

    public final void setSkillScore(int i3) {
        this.skillScore = i3;
    }

    public final void setStableScore(int i3) {
        this.stableScore = i3;
    }

    public final void setStableScoreArray(@Nullable int[] iArr) {
        this.stableScoreArray = iArr;
    }

    public final void setVibNum(int i3) {
        this.vibNum = i3;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult
    public int skillScore() {
        return this.skillScore;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult
    public int stableScore() {
        return this.stableScore;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult
    @Nullable
    public int[] stableScoreArray() {
        return this.stableScoreArray;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.MultiScoreResult
    public int vibNum() {
        return this.vibNum;
    }
}
