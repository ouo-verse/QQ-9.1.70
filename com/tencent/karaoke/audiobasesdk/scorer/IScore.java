package com.tencent.karaoke.audiobasesdk.scorer;

import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.karaoke.audiobasesdk.NoteItem;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import mqq.app.api.ProcessConstant;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&J9\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u00102 \b\u0002\u0010\u0012\u001a\u001a\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0013H&\u00a2\u0006\u0002\u0010\u0014J>\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\"\b\u0002\u0010\u0012\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001aH&J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH&J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0016H&J\b\u0010\u001e\u001a\u00020\u0003H&JF\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010\u00162\u0006\u0010#\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(H&J7\u0010)\u001a\u00020\u00032\b\u0010*\u001a\u0004\u0018\u00010!2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u00032\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u0010H&\u00a2\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018H&J>\u00100\u001a\u00020\u000e2 \b\u0002\u0010\u0012\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u000102\u0012\u0006\u0012\u0004\u0018\u000102\u0012\u0004\u0012\u00020\u000e\u0018\u0001012\b\u00103\u001a\u0004\u0018\u00010(2\b\b\u0002\u00104\u001a\u00020\u0003H&J\u0010\u00105\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\u0003H&J\u0010\u00107\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u000208H&J\u0010\u00109\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020;H&J\b\u0010<\u001a\u00020\u000eH&J8\u0010=\u001a\u00020\u000e2.\b\u0002\u0010\u0012\u001a(\u0012\u001c\u0012\u001a\u0012\u0006\u0012\u0004\u0018\u00010?\u0018\u00010>j\f\u0012\u0006\u0012\u0004\u0018\u00010?\u0018\u0001`@\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0013H&R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0005\u00a8\u0006A"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/scorer/IScore;", "", "SCORE_TYPE_ACF", "", "getSCORE_TYPE_ACF", "()I", "SCORE_TYPE_MIX", "getSCORE_TYPE_MIX", "SCORE_TYPE_PYIN", "getSCORE_TYPE_PYIN", "bindPublicPitch", "nativeHandle", "", "finish", "", "getAllGrove", "", "Lcom/tencent/karaoke/audiobasesdk/NoteItem;", "callback", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)[Lcom/tencent/karaoke/audiobasesdk/NoteItem;", "getGroveAndHit", "", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "", "pitch", "Lkotlin/Function3;", "getScoreResult", "Lcom/tencent/karaoke/audiobasesdk/scorer/IScoreResult;", "getValidScoreArray", "getValidSentenceNum", "initWithNoteArray", "noteBuf", "", Element.ELEMENT_NAME_TIMES, "sentenceCount", "lines", ProcessConstant.MULTI, "Lcom/tencent/karaoke/audiobasesdk/scorer/IMultiScore;", "resourceJson", "", "processWithBuffer", "pcmData", "dataLen", "pitchs", "", "([BFI[[F)I", InnerAudioPlugin.AUDIO_OPERATE_SEEK, "setFinalMultiScoreResultCallback", "Lkotlin/Function2;", "Lcom/tencent/karaoke/audiobasesdk/scorer/MultiScoreResult;", "scoreMap", "lyricSize", "setPitch", "offset", "setScoreResultCallback", "Lcom/tencent/karaoke/audiobasesdk/scorer/ScoreResultCallback;", "setSpeakerOriginal", "original", "", "stop", "tryGetMultiScoreTmp", "Ljava/util/ArrayList;", "Lcom/tencent/karaoke/audiobasesdk/scorer/MultiScoreStcInfo;", "Lkotlin/collections/ArrayList;", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public interface IScore {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* loaded from: classes7.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        @Nullable
        public static /* synthetic */ NoteItem[] getAllGrove$default(IScore iScore, Function1 function1, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    function1 = null;
                }
                return iScore.getAllGrove(function1);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAllGrove");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Nullable
        public static /* synthetic */ int[] getGroveAndHit$default(IScore iScore, float f16, float f17, Function3 function3, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    function3 = null;
                }
                return iScore.getGroveAndHit(f16, f17, function3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getGroveAndHit");
        }

        public static int getSCORE_TYPE_ACF(IScore iScore) {
            return 0;
        }

        public static int getSCORE_TYPE_MIX(IScore iScore) {
            return 2;
        }

        public static int getSCORE_TYPE_PYIN(IScore iScore) {
            return 1;
        }

        public static /* synthetic */ int initWithNoteArray$default(IScore iScore, byte[] bArr, int[] iArr, int i3, int[] iArr2, IMultiScore iMultiScore, String str, int i16, Object obj) {
            IMultiScore iMultiScore2;
            String str2;
            if (obj == null) {
                if ((i16 & 16) != 0) {
                    iMultiScore2 = null;
                } else {
                    iMultiScore2 = iMultiScore;
                }
                if ((i16 & 32) != 0) {
                    str2 = null;
                } else {
                    str2 = str;
                }
                return iScore.initWithNoteArray(bArr, iArr, i3, iArr2, iMultiScore2, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initWithNoteArray");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void setFinalMultiScoreResultCallback$default(IScore iScore, Function2 function2, String str, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 1) != 0) {
                    function2 = null;
                }
                if ((i16 & 4) != 0) {
                    i3 = 0;
                }
                iScore.setFinalMultiScoreResultCallback(function2, str, i3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setFinalMultiScoreResultCallback");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void tryGetMultiScoreTmp$default(IScore iScore, Function1 function1, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    function1 = null;
                }
                iScore.tryGetMultiScoreTmp(function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryGetMultiScoreTmp");
        }
    }

    int bindPublicPitch(long nativeHandle);

    void finish();

    @Nullable
    NoteItem[] getAllGrove(@Nullable Function1<? super NoteItem[], Unit> callback);

    @Nullable
    int[] getGroveAndHit(float timeStamp, float pitch, @Nullable Function3<? super Integer, ? super Integer, ? super Float, Unit> callback);

    int getSCORE_TYPE_ACF();

    int getSCORE_TYPE_MIX();

    int getSCORE_TYPE_PYIN();

    @Nullable
    IScoreResult getScoreResult();

    @Nullable
    int[] getValidScoreArray();

    int getValidSentenceNum();

    int initWithNoteArray(@Nullable byte[] noteBuf, @Nullable int[] times, int sentenceCount, @Nullable int[] lines, @Nullable IMultiScore multi, @Nullable String resourceJson);

    int processWithBuffer(@Nullable byte[] pcmData, float timeStamp, int dataLen, @Nullable float[][] pitchs);

    void seek(float timeStamp);

    void setFinalMultiScoreResultCallback(@Nullable Function2<? super MultiScoreResult, ? super MultiScoreResult, Unit> callback, @Nullable String scoreMap, int lyricSize);

    void setPitch(int offset);

    void setScoreResultCallback(@NotNull ScoreResultCallback callback);

    void setSpeakerOriginal(boolean original);

    void stop();

    void tryGetMultiScoreTmp(@Nullable Function1<? super ArrayList<MultiScoreStcInfo>, Unit> callback);
}
