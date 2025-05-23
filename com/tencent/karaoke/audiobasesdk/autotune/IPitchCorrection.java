package com.tencent.karaoke.audiobasesdk.autotune;

import com.tencent.karaoke.audiobasesdk.KaraAudioPitchCorrectionWordDesc;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u001a\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&J\u001d\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\u0003H&\u00a2\u0006\u0002\u0010\u0013JP\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\fH&J\b\u0010\u001f\u001a\u00020\u0003H&J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0003H&J\"\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\t2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0003H&J*\u0010&\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\t2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0003H&J\b\u0010)\u001a\u00020\u0003H&J\"\u0010*\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\t2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u0003H&J\b\u0010,\u001a\u00020-H&J\u0012\u0010.\u001a\u00020\u00032\b\u0010/\u001a\u0004\u0018\u00010\u0018H&J\u0010\u00100\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0003H&J\u0010\u00101\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u0003H&J\u0010\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0005H&J\u0018\u00105\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u00106\u001a\u00020\fH&\u00a8\u00067"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/autotune/IPitchCorrection;", "", "getPitchCorrectMode", "", "getPitchCorrectScale", "", "getPitchCorrectionProgress", "getPitchCorrectionResult", "result", "", "resultLen", "getPitchCorrectionRunBlock", "", "getSentenceCorrectFlag", "sentenceIndex", "getSentenceCount", "getSentenceWordDescs", "", "Lcom/tencent/karaoke/audiobasesdk/KaraAudioPitchCorrectionWordDesc;", "(I)[Lcom/tencent/karaoke/audiobasesdk/KaraAudioPitchCorrectionWordDesc;", "init", "sampleRate", "channels", "configFilepath", "", "refFile", "vocoderMode", "pitchs", "", "pitchsLen", "isHonor", "pitchAnalyzedBegin", "pitchAnalyzedComplete", "totalOffset", "pitchAnalyzedProcess", "buffer", "bufferLen", "offset", "pitchCorrectionAnalyzed", "offsetms", "accompanyShift", "pitchCorrectionCancel", "pitchCorrectionRun", "correctionMode", "release", "", "saveCorrectionResultToFile", "filePath", "setAccompanyShift", "setPitchCorrectMode", "pitchCorrectMode", "setPitchCorrectScale", "pitchCorrectScale", "setSentenceCorrectFlag", "flag", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public interface IPitchCorrection {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* loaded from: classes7.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ int init$default(IPitchCorrection iPitchCorrection, int i3, int i16, String str, byte[] bArr, int i17, float[] fArr, int i18, boolean z16, int i19, Object obj) {
            boolean z17;
            if (obj == null) {
                if ((i19 & 128) != 0) {
                    z17 = false;
                } else {
                    z17 = z16;
                }
                return iPitchCorrection.init(i3, i16, str, bArr, i17, fArr, i18, z17);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: init");
        }
    }

    int getPitchCorrectMode();

    float getPitchCorrectScale();

    int getPitchCorrectionProgress();

    int getPitchCorrectionResult(@Nullable byte[] result, int resultLen);

    boolean getPitchCorrectionRunBlock();

    boolean getSentenceCorrectFlag(int sentenceIndex);

    int getSentenceCount();

    @Nullable
    KaraAudioPitchCorrectionWordDesc[] getSentenceWordDescs(int sentenceIndex);

    int init(int sampleRate, int channels, @Nullable String configFilepath, @Nullable byte[] refFile, int vocoderMode, @Nullable float[] pitchs, int pitchsLen, boolean isHonor);

    int pitchAnalyzedBegin();

    int pitchAnalyzedComplete(int totalOffset);

    int pitchAnalyzedProcess(@Nullable byte[] buffer, int bufferLen, int offset);

    int pitchCorrectionAnalyzed(@Nullable byte[] buffer, int bufferLen, int offsetms, int accompanyShift);

    int pitchCorrectionCancel();

    int pitchCorrectionRun(@Nullable byte[] buffer, int bufferLen, int correctionMode);

    void release();

    int saveCorrectionResultToFile(@Nullable String filePath);

    int setAccompanyShift(int accompanyShift);

    int setPitchCorrectMode(int pitchCorrectMode);

    int setPitchCorrectScale(float pitchCorrectScale);

    int setSentenceCorrectFlag(int sentenceIndex, boolean flag);
}
