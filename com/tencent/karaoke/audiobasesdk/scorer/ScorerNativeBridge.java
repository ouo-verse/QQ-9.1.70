package com.tencent.karaoke.audiobasesdk.scorer;

import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.karaoke.audiobasesdk.AudiobaseContext;
import com.tencent.karaoke.audiobasesdk.NoteItem;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0002\b\u0017\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0000\u0018\u0000 S2\u00020\u0001:\u0001SB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0011\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086 J\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0086 J\u0011\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0086 J\t\u0010\f\u001a\u00020\u0006H\u0086 J\u0018\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000eH\u0086 \u00a2\u0006\u0002\u0010\u0010J\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bH\u0086 J\u0011\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0086 J\u0011\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0086 J\u0011\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0086 J\u0011\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0086 J\u0011\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0086 J\u0011\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0086 J\u0011\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0086 J\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001eH\u0086 J\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0003\u001a\u00020\u0004H\u0086 J\u000b\u0010 \u001a\u0004\u0018\u00010!H\u0086 J\u0019\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0006H\u0086 J#\u0010%\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\b\u0010&\u001a\u0004\u0018\u00010\u001eH\u0086 JO\u0010'\u001a\u00020\u00062\b\u0010(\u001a\u0004\u0018\u00010\u001e2\b\u0010)\u001a\u0004\u0018\u00010\u00122\b\u0010*\u001a\u0004\u0018\u00010\u00122\u0006\u0010+\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006H\u0086 J\u0019\u0010.\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u0006H\u0086 J\u0011\u00100\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0086 J-\u00101\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u00062\b\u00104\u001a\u0004\u0018\u00010!H\u0086 J6\u00105\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u001e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u00107\u001a\u00020\u00062\u000e\u00108\u001a\n\u0012\u0004\u0012\u000209\u0018\u00010\u000eH\u0086 \u00a2\u0006\u0002\u0010:J\u0011\u0010;\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0086 J\u001b\u0010<\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u0006H\u0086 JC\u0010=\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00042\u001e\u0010>\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010@\u0018\u00010?j\f\u0012\u0006\u0012\u0004\u0018\u00010@\u0018\u0001`A2\b\u0010B\u001a\u0004\u0018\u00010\u00122\u0006\u0010C\u001a\u00020\u0006H\u0086 J\u0019\u0010D\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010E\u001a\u00020FH\u0086 J\u0011\u0010G\u001a\u00020\n2\u0006\u0010H\u001a\u00020\u0001H\u0086 J\u0011\u0010I\u001a\u00020\n2\u0006\u0010J\u001a\u00020\u0006H\u0086 J\u0019\u0010K\u001a\u00020F2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010L\u001a\u00020\u001eH\u0086 J\t\u0010M\u001a\u00020\u0006H\u0086 J\u0019\u0010N\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u0006H\u0086 J)\u0010O\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010@\u0018\u00010?j\f\u0012\u0006\u0012\u0004\u0018\u00010@\u0018\u0001`A2\u0006\u0010\u0003\u001a\u00020\u0004H\u0086 J\t\u0010P\u001a\u00020\u0006H\u0086 J\u0011\u0010Q\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0086 J\t\u0010R\u001a\u00020\u0006H\u0086 R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006T"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/scorer/ScorerNativeBridge;", "", "()V", "nativeHandle", "", "acquirePublicPitchData", "", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "", "bindMultiScore", "", "bindPublicPitch", "finish", "getAllGrove", "", "Lcom/tencent/karaoke/audiobasesdk/NoteItem;", "()[Lcom/tencent/karaoke/audiobasesdk/NoteItem;", "getGroveAndHit", "", "pitch", "getLastSentenceLongtoneScore", "getLastSentenceMultiScoreIndex", "getLastSentenceRhythmScore", "getLastSentenceStableScore", "getLastSkillGlintCount", "getLastSkillTransliterationCount", "getLastSkillTrillCount", "getMapMultiScoreFinalResult", "Lcom/tencent/karaoke/audiobasesdk/scorer/FinalMultiScoreResultImpl;", "map", "", "getMultiScoreFinalResult", "getValidScoreArray", "", "initMultiScore", "sampleRate", "channels", "initMultiScoreAndLoadResource", "multiJson", "initWithNoteArray", "noteBuf", Element.ELEMENT_NAME_TIMES, "stcNeedToSing", "sentenceCount", "bitDepth", "scorerType", "lastScore", "type", "multiScoreUnInit", "native_new_scores", "hitValueNumerator", "hitValueDenominator", "originalSpeaker", "processWithBuffer", "pcmData", "dataLen", "pitchs", "", "([BFI[[F)I", InnerAudioPlugin.AUDIO_OPERATE_SEEK, "sentenceScores", "setNewTmpDataToMultiScore", "info", "Ljava/util/ArrayList;", "Lcom/tencent/karaoke/audiobasesdk/scorer/MultiScoreStcInfo;", "Lkotlin/collections/ArrayList;", "pyinScores", "lyricSize", "setRap", "isRap", "", "setScoreUpdateReceiver", "receiver", "setShiftKey", "offset", "setSkillParam", "skillParam", "stop", "totalScore", "tryGetMultiScoreTmp", "unInit", "unInitMultiScore", "validSentenceNum", "Companion", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public final class ScorerNativeBridge {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static boolean loaded = AudiobaseContext.loadLibrary();
    private long nativeHandle;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0087 J1\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0087 R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/scorer/ScorerNativeBridge$Companion;", "", "()V", "loaded", "", "isLoaded", "native_process", "", "ss", "", "length", "", "native_processForTotal", "scores", "scoreLength", "total", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        public final boolean isLoaded() {
            return ScorerNativeBridge.loaded;
        }

        @JvmStatic
        @Nullable
        public final int[] native_process(@NotNull byte[] ss5, int length) {
            return ScorerNativeBridge.native_process(ss5, length);
        }

        @JvmStatic
        public final int native_processForTotal(@NotNull byte[] ss5, int length, @NotNull int[] scores, int scoreLength, int total) {
            return ScorerNativeBridge.native_processForTotal(ss5, length, scores, scoreLength, total);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @JvmStatic
    @Nullable
    public static final native int[] native_process(@NotNull byte[] bArr, int i3);

    @JvmStatic
    public static final native int native_processForTotal(@NotNull byte[] bArr, int i3, @NotNull int[] iArr, int i16, int i17);

    public final native int acquirePublicPitchData(float timeStamp);

    public final native void bindMultiScore(long nativeHandle);

    public final native int bindPublicPitch(long nativeHandle);

    public final native int finish();

    @Nullable
    public final native NoteItem[] getAllGrove();

    @Nullable
    public final native int[] getGroveAndHit(float timeStamp, float pitch);

    public final native int getLastSentenceLongtoneScore(long nativeHandle);

    public final native int getLastSentenceMultiScoreIndex(long nativeHandle);

    public final native int getLastSentenceRhythmScore(long nativeHandle);

    public final native int getLastSentenceStableScore(long nativeHandle);

    public final native int getLastSkillGlintCount(long nativeHandle);

    public final native int getLastSkillTransliterationCount(long nativeHandle);

    public final native int getLastSkillTrillCount(long nativeHandle);

    @Nullable
    public final native FinalMultiScoreResultImpl getMapMultiScoreFinalResult(long nativeHandle, @NotNull byte[] map);

    @Nullable
    public final native FinalMultiScoreResultImpl getMultiScoreFinalResult(long nativeHandle);

    @Nullable
    public final native boolean[] getValidScoreArray();

    public final native long initMultiScore(int sampleRate, int channels);

    public final native long initMultiScoreAndLoadResource(int sampleRate, int channels, @Nullable byte[] multiJson);

    public final native int initWithNoteArray(@Nullable byte[] noteBuf, @Nullable int[] times, @Nullable int[] stcNeedToSing, int sentenceCount, int sampleRate, int channels, int bitDepth, int scorerType);

    public final native int lastScore(long nativeHandle, int type);

    public final native void multiScoreUnInit(long nativeHandle);

    @Nullable
    public final native byte[] native_new_scores(long nativeHandle, int hitValueNumerator, int hitValueDenominator, @Nullable boolean[] originalSpeaker);

    public final native int processWithBuffer(@NotNull byte[] pcmData, float timeStamp, int dataLen, @Nullable float[][] pitchs);

    public final native void seek(float timeStamp);

    @Nullable
    public final native int[] sentenceScores(long nativeHandle, int type);

    public final native void setNewTmpDataToMultiScore(long nativeHandle, @Nullable ArrayList<MultiScoreStcInfo> info, @Nullable int[] pyinScores, int lyricSize);

    public final native void setRap(long nativeHandle, boolean isRap);

    public final native void setScoreUpdateReceiver(@NotNull Object receiver);

    public final native void setShiftKey(int offset);

    public final native boolean setSkillParam(long nativeHandle, @NotNull byte[] skillParam);

    public final native int stop();

    public final native int totalScore(long nativeHandle, int type);

    @Nullable
    public final native ArrayList<MultiScoreStcInfo> tryGetMultiScoreTmp(long nativeHandle);

    public final native int unInit();

    public final native void unInitMultiScore(long nativeHandle);

    public final native int validSentenceNum();
}
