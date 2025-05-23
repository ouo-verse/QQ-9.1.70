package com.tencent.karaoke.audiobasesdk.autotune;

import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.component.utils.LogUtil;
import com.tencent.karaoke.audiobasesdk.AudiobaseContext;
import com.tencent.karaoke.audiobasesdk.KaraAudioPitchCorrection;
import com.tencent.karaoke.audiobasesdk.KaraAudioPitchCorrectionWordDesc;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0014\n\u0002\b\u001d\n\u0002\u0010\u0002\n\u0002\b\u0017\u0018\u0000 T2\u00020\u0001:\u0001TB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\u001a\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\bH\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016J\u001d\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u0006\u0010\u0013\u001a\u00020\bH\u0016\u00a2\u0006\u0002\u0010\u0018JN\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001e\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u0011H\u0016J\t\u0010#\u001a\u00020\bH\u0082 J\u0019\u0010$\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0082 J\t\u0010%\u001a\u00020\nH\u0082 J\t\u0010&\u001a\u00020\bH\u0082 J\t\u0010'\u001a\u00020\u0011H\u0082 J\u0011\u0010(\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\bH\u0082 J\t\u0010)\u001a\u00020\bH\u0082 J\u001e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u0006\u0010\u0013\u001a\u00020\bH\u0082 \u00a2\u0006\u0002\u0010\u0018JU\u0010+\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\b2\b\b\u0001\u0010-\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u0011H\u0082 J\t\u0010.\u001a\u00020\bH\u0082 J\u0011\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\bH\u0082 J!\u00101\u001a\u00020\b2\u0006\u00102\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\b2\u0006\u00104\u001a\u00020\bH\u0082 J)\u00105\u001a\u00020\b2\u0006\u00106\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\bH\u0082 J\t\u0010:\u001a\u00020\bH\u0082 J!\u0010;\u001a\u00020\b2\u0006\u00106\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\b2\u0006\u0010<\u001a\u00020\bH\u0082 J\t\u0010=\u001a\u00020>H\u0082 J\u0011\u0010?\u001a\u00020\b2\u0006\u0010@\u001a\u00020\u0004H\u0082 J\u0011\u0010A\u001a\u00020\b2\u0006\u00109\u001a\u00020\bH\u0082 J\u0011\u0010B\u001a\u00020\b2\u0006\u0010C\u001a\u00020\nH\u0082 J\u0019\u0010D\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010E\u001a\u00020\u0011H\u0082 J\b\u0010F\u001a\u00020\bH\u0016J\u0010\u0010G\u001a\u00020\b2\u0006\u00100\u001a\u00020\bH\u0016J\"\u0010H\u001a\u00020\b2\b\u00106\u001a\u0004\u0018\u00010\u000e2\u0006\u00107\u001a\u00020\b2\u0006\u00104\u001a\u00020\bH\u0016J*\u0010I\u001a\u00020\b2\b\u00106\u001a\u0004\u0018\u00010\u000e2\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\bH\u0016J\b\u0010J\u001a\u00020\bH\u0016J\"\u0010K\u001a\u00020\b2\b\u00106\u001a\u0004\u0018\u00010\u000e2\u0006\u00107\u001a\u00020\b2\u0006\u0010<\u001a\u00020\bH\u0016J\b\u0010L\u001a\u00020>H\u0016J\u0012\u0010M\u001a\u00020\b2\b\u0010@\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010N\u001a\u00020\b2\u0006\u00109\u001a\u00020\bH\u0016J\u0010\u0010O\u001a\u00020\b2\u0006\u0010P\u001a\u00020\bH\u0016J\u0010\u0010Q\u001a\u00020\b2\u0006\u0010C\u001a\u00020\nH\u0016J\u0018\u0010R\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010S\u001a\u00020\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006U"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/autotune/HWAudioPitchCorrection;", "Lcom/tencent/karaoke/audiobasesdk/autotune/IPitchCorrection;", "()V", "TAG", "", "nativeHandle", "", "getPitchCorrectMode", "", "getPitchCorrectScale", "", "getPitchCorrectionProgress", "getPitchCorrectionResult", "result", "", "resultLen", "getPitchCorrectionRunBlock", "", "getSentenceCorrectFlag", "sentenceIndex", "getSentenceCount", "getSentenceWordDescs", "", "Lcom/tencent/karaoke/audiobasesdk/KaraAudioPitchCorrectionWordDesc;", "(I)[Lcom/tencent/karaoke/audiobasesdk/KaraAudioPitchCorrectionWordDesc;", "init", "sampleRate", "channels", "configFilepath", "refFile", "vocoderMode", "pitchs", "", "pitchsLen", "isHonor", "native_getAccompanyShift", "native_getCorrectionResult", "native_getPitchCorrectScale", "native_getPitchCorrectionProgress", "native_getPitchCorrectionRunBlock", "native_getSentenceCorrectFlag", "native_getSentenceCount", "native_getSentenceWordDescs", "native_init", "refLength", "pitchCorrectVocoderAndroidMode", "native_pitchAnalyzeBegin", "native_pitchAnalyzedComplete", "totalOffset", "native_pitchAnalyzedProcess", AIInput.KEY_FRAME, "frameLen", "offset", "native_pitchCorrectionAnalyzed", "buffer", "bufferLen", "offsetms", "accompanyShift", "native_pitchCorrectionCancel", "native_pitchCorrectionRun", "correctionMode", "native_release", "", "native_saveCorrectionResultToFile", "filePath", "native_setAccompanyShift", "native_setPitchCorrectScale", "pitchCorrectScale", "native_setSentenceCorrectFlag", "correctFlag", "pitchAnalyzedBegin", "pitchAnalyzedComplete", "pitchAnalyzedProcess", "pitchCorrectionAnalyzed", "pitchCorrectionCancel", "pitchCorrectionRun", "release", "saveCorrectionResultToFile", "setAccompanyShift", "setPitchCorrectMode", "pitchCorrectMode", "setPitchCorrectScale", "setSentenceCorrectFlag", "flag", "Companion", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public final class HWAudioPitchCorrection implements IPitchCorrection {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final boolean mIsLoaded = AudiobaseContext.loadHuaweiLib();
    private static boolean mIsValid;
    private final String TAG = "KaraAudioPitchCorrection";
    private final long nativeHandle;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/autotune/HWAudioPitchCorrection$Companion;", "", "()V", "mIsLoaded", "", "getMIsLoaded", "()Z", "mIsValid", "getMIsValid", "setMIsValid", "(Z)V", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        public final boolean getMIsLoaded() {
            return HWAudioPitchCorrection.mIsLoaded;
        }

        public final boolean getMIsValid() {
            return HWAudioPitchCorrection.mIsValid;
        }

        public final void setMIsValid(boolean z16) {
            HWAudioPitchCorrection.mIsValid = z16;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final native int native_getAccompanyShift();

    private final native int native_getCorrectionResult(byte[] result, int resultLen);

    private final native float native_getPitchCorrectScale();

    private final native int native_getPitchCorrectionProgress();

    private final native boolean native_getPitchCorrectionRunBlock();

    private final native boolean native_getSentenceCorrectFlag(int sentenceIndex);

    private final native int native_getSentenceCount();

    private final native KaraAudioPitchCorrectionWordDesc[] native_getSentenceWordDescs(int sentenceIndex);

    private final native int native_init(int sampleRate, int channels, String configFilepath, byte[] refFile, int refLength, @KaraAudioPitchCorrection.Mode int pitchCorrectVocoderAndroidMode, float[] pitchs, int pitchsLen, boolean isHonor);

    private final native int native_pitchAnalyzeBegin();

    private final native int native_pitchAnalyzedComplete(int totalOffset);

    private final native int native_pitchAnalyzedProcess(byte[] frame, int frameLen, int offset);

    private final native int native_pitchCorrectionAnalyzed(byte[] buffer, int bufferLen, int offsetms, int accompanyShift);

    private final native int native_pitchCorrectionCancel();

    private final native int native_pitchCorrectionRun(byte[] buffer, int bufferLen, int correctionMode);

    private final native void native_release();

    private final native int native_saveCorrectionResultToFile(String filePath);

    private final native int native_setAccompanyShift(int accompanyShift);

    private final native int native_setPitchCorrectScale(float pitchCorrectScale);

    private final native int native_setSentenceCorrectFlag(int sentenceIndex, boolean correctFlag);

    @Override // com.tencent.karaoke.audiobasesdk.autotune.IPitchCorrection
    public int getPitchCorrectMode() {
        return 0;
    }

    @Override // com.tencent.karaoke.audiobasesdk.autotune.IPitchCorrection
    public float getPitchCorrectScale() {
        if (mIsValid) {
            return native_getPitchCorrectScale();
        }
        return 0.0f;
    }

    @Override // com.tencent.karaoke.audiobasesdk.autotune.IPitchCorrection
    public int getPitchCorrectionProgress() {
        if (mIsValid) {
            return native_getPitchCorrectionProgress();
        }
        return -1;
    }

    @Override // com.tencent.karaoke.audiobasesdk.autotune.IPitchCorrection
    public int getPitchCorrectionResult(@Nullable byte[] result, int resultLen) {
        if (mIsValid) {
            if (result == null) {
                Intrinsics.throwNpe();
            }
            return native_getCorrectionResult(result, resultLen);
        }
        return -1;
    }

    @Override // com.tencent.karaoke.audiobasesdk.autotune.IPitchCorrection
    public boolean getPitchCorrectionRunBlock() {
        if (mIsValid) {
            return native_getPitchCorrectionRunBlock();
        }
        return false;
    }

    @Override // com.tencent.karaoke.audiobasesdk.autotune.IPitchCorrection
    public boolean getSentenceCorrectFlag(int sentenceIndex) {
        if (mIsValid) {
            return native_getSentenceCorrectFlag(sentenceIndex);
        }
        return false;
    }

    @Override // com.tencent.karaoke.audiobasesdk.autotune.IPitchCorrection
    public int getSentenceCount() {
        if (mIsValid) {
            return native_getSentenceCount();
        }
        return 0;
    }

    @Override // com.tencent.karaoke.audiobasesdk.autotune.IPitchCorrection
    @Nullable
    public KaraAudioPitchCorrectionWordDesc[] getSentenceWordDescs(int sentenceIndex) {
        if (mIsValid) {
            return native_getSentenceWordDescs(sentenceIndex);
        }
        return null;
    }

    @Override // com.tencent.karaoke.audiobasesdk.autotune.IPitchCorrection
    public int init(int sampleRate, int channels, @Nullable String configFilepath, @Nullable byte[] refFile, int vocoderMode, @Nullable float[] pitchs, int pitchsLen, boolean isHonor) {
        if (mIsLoaded) {
            String str = this.TAG;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Object[] objArr = new Object[4];
            boolean z16 = false;
            objArr[0] = configFilepath;
            if (refFile == null) {
                Intrinsics.throwNpe();
            }
            objArr[1] = Integer.valueOf(refFile.length);
            objArr[2] = Integer.valueOf(vocoderMode);
            objArr[3] = Integer.valueOf(pitchsLen);
            String format = String.format("init begin. configFilepath:%s, refFile length:%d,vocoderMode=%d,pitchLen=%d", Arrays.copyOf(objArr, 4));
            Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
            LogUtil.d(str, format);
            LogUtil.i(this.TAG, "init: isHuaweiSupport autotune:isHonor:" + isHonor);
            if (configFilepath == null) {
                Intrinsics.throwNpe();
            }
            int native_init = native_init(sampleRate, channels, configFilepath, refFile, refFile.length, vocoderMode, pitchs, pitchsLen, isHonor);
            if (native_init == 0) {
                z16 = true;
            }
            mIsValid = z16;
            if (!z16) {
                LogUtil.w(this.TAG, "KaraAudioPitchCorrection init failed: " + native_init);
                return native_init;
            }
            return native_init;
        }
        return -1;
    }

    @Override // com.tencent.karaoke.audiobasesdk.autotune.IPitchCorrection
    public int pitchAnalyzedBegin() {
        if (mIsValid) {
            return native_pitchAnalyzeBegin();
        }
        return -1;
    }

    @Override // com.tencent.karaoke.audiobasesdk.autotune.IPitchCorrection
    public int pitchAnalyzedComplete(int totalOffset) {
        if (mIsValid) {
            return native_pitchAnalyzedComplete(totalOffset);
        }
        return -1;
    }

    @Override // com.tencent.karaoke.audiobasesdk.autotune.IPitchCorrection
    public int pitchAnalyzedProcess(@Nullable byte[] buffer, int bufferLen, int offset) {
        if (mIsValid) {
            if (buffer == null) {
                Intrinsics.throwNpe();
            }
            return native_pitchAnalyzedProcess(buffer, bufferLen, offset);
        }
        return -1;
    }

    @Override // com.tencent.karaoke.audiobasesdk.autotune.IPitchCorrection
    public int pitchCorrectionAnalyzed(@Nullable byte[] buffer, int bufferLen, int offsetms, int accompanyShift) {
        if (mIsValid) {
            if (buffer == null) {
                Intrinsics.throwNpe();
            }
            return native_pitchCorrectionAnalyzed(buffer, bufferLen, offsetms, accompanyShift);
        }
        return -1;
    }

    @Override // com.tencent.karaoke.audiobasesdk.autotune.IPitchCorrection
    public int pitchCorrectionCancel() {
        if (mIsValid) {
            return native_pitchCorrectionCancel();
        }
        return -1;
    }

    @Override // com.tencent.karaoke.audiobasesdk.autotune.IPitchCorrection
    public int pitchCorrectionRun(@Nullable byte[] buffer, int bufferLen, int correctionMode) {
        boolean z16;
        if (!mIsValid || buffer == null) {
            return -1;
        }
        if (buffer.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!(!z16)) {
            return -1;
        }
        return native_pitchCorrectionRun(buffer, bufferLen, correctionMode);
    }

    @Override // com.tencent.karaoke.audiobasesdk.autotune.IPitchCorrection
    public void release() {
        if (mIsValid) {
            native_release();
            mIsValid = false;
        }
    }

    @Override // com.tencent.karaoke.audiobasesdk.autotune.IPitchCorrection
    public int saveCorrectionResultToFile(@Nullable String filePath) {
        if (mIsValid) {
            if (filePath == null) {
                Intrinsics.throwNpe();
            }
            return native_saveCorrectionResultToFile(filePath);
        }
        return -1;
    }

    @Override // com.tencent.karaoke.audiobasesdk.autotune.IPitchCorrection
    public int setAccompanyShift(int accompanyShift) {
        if (mIsValid) {
            return native_setAccompanyShift(accompanyShift);
        }
        return -1;
    }

    @Override // com.tencent.karaoke.audiobasesdk.autotune.IPitchCorrection
    public int setPitchCorrectMode(int pitchCorrectMode) {
        return -1;
    }

    @Override // com.tencent.karaoke.audiobasesdk.autotune.IPitchCorrection
    public int setPitchCorrectScale(float pitchCorrectScale) {
        if (mIsValid) {
            return native_setPitchCorrectScale(pitchCorrectScale);
        }
        return -1;
    }

    @Override // com.tencent.karaoke.audiobasesdk.autotune.IPitchCorrection
    public int setSentenceCorrectFlag(int sentenceIndex, boolean flag) {
        if (mIsValid) {
            return native_setSentenceCorrectFlag(sentenceIndex, flag);
        }
        return -1;
    }
}
