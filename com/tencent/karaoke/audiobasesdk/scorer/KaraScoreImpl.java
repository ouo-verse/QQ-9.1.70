package com.tencent.karaoke.audiobasesdk.scorer;

import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.karaoke.audiobasesdk.KaraScore;
import com.tencent.karaoke.audiobasesdk.NoteItem;
import com.tencent.karaoke.audiobasesdk.scorer.IScore;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.ProcessConstant;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00a4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J7\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u00152\u001e\u0010\u0017\u001a\u001a\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0018H\u0016\u00a2\u0006\u0002\u0010\u0019J<\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2 \u0010\u0017\u001a\u001c\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001fH\u0016J\n\u0010 \u001a\u0004\u0018\u00010!H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010#\u001a\u00020\bH\u0016JB\u0010$\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010\u001b2\u0006\u0010(\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010\u001b2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J7\u0010.\u001a\u00020\b2\b\u0010/\u001a\u0004\u0018\u00010&2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\b2\u000e\u00101\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010\u0015H\u0016\u00a2\u0006\u0002\u00103J\u0010\u00104\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J:\u00105\u001a\u00020\u00132\u001e\u0010\u0017\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u000107\u0012\u0006\u0012\u0004\u0018\u000107\u0012\u0004\u0012\u00020\u0013\u0018\u0001062\b\u00108\u001a\u0004\u0018\u00010-2\u0006\u00109\u001a\u00020\bH\u0016J\u0010\u0010:\u001a\u00020\u00132\u0006\u0010;\u001a\u00020\bH\u0016J\u0010\u0010<\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\fH\u0016J\u0010\u0010=\u001a\u00020\u00132\u0006\u0010>\u001a\u00020?H\u0016J\b\u0010@\u001a\u00020\u0013H\u0016J6\u0010A\u001a\u00020\u00132,\u0010\u0017\u001a(\u0012\u001c\u0012\u001a\u0012\u0006\u0012\u0004\u0018\u00010C\u0018\u00010Bj\f\u0012\u0006\u0012\u0004\u0018\u00010C\u0018\u0001`D\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0018H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006E"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/scorer/KaraScoreImpl;", "Lcom/tencent/karaoke/audiobasesdk/scorer/IScore;", DownloadInfo.spKey_Config, "Lcom/tencent/karaoke/audiobasesdk/scorer/ScoreConfig;", "(Lcom/tencent/karaoke/audiobasesdk/scorer/ScoreConfig;)V", "getConfig", "()Lcom/tencent/karaoke/audiobasesdk/scorer/ScoreConfig;", "perBufLen", "", "scoreResult", "Lcom/tencent/karaoke/audiobasesdk/scorer/KaraScoreResult;", "scoreResultCallback", "Lcom/tencent/karaoke/audiobasesdk/scorer/ScoreResultCallback;", "scorer", "Lcom/tencent/karaoke/audiobasesdk/KaraScore;", "bindPublicPitch", "nativeHandle", "", "finish", "", "getAllGrove", "", "Lcom/tencent/karaoke/audiobasesdk/NoteItem;", "callback", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)[Lcom/tencent/karaoke/audiobasesdk/NoteItem;", "getGroveAndHit", "", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "", "pitch", "Lkotlin/Function3;", "getScoreResult", "Lcom/tencent/karaoke/audiobasesdk/scorer/IScoreResult;", "getValidScoreArray", "getValidSentenceNum", "initWithNoteArray", "noteBuf", "", Element.ELEMENT_NAME_TIMES, "sentenceCount", "lines", ProcessConstant.MULTI, "Lcom/tencent/karaoke/audiobasesdk/scorer/IMultiScore;", "resourceJson", "", "processWithBuffer", "pcmData", "dataLen", "pitchs", "", "([BFI[[F)I", InnerAudioPlugin.AUDIO_OPERATE_SEEK, "setFinalMultiScoreResultCallback", "Lkotlin/Function2;", "Lcom/tencent/karaoke/audiobasesdk/scorer/MultiScoreResult;", "scoreMap", "lyricSize", "setPitch", "offset", "setScoreResultCallback", "setSpeakerOriginal", "original", "", "stop", "tryGetMultiScoreTmp", "Ljava/util/ArrayList;", "Lcom/tencent/karaoke/audiobasesdk/scorer/MultiScoreStcInfo;", "Lkotlin/collections/ArrayList;", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public final class KaraScoreImpl implements IScore {

    @NotNull
    private final ScoreConfig config;
    private final int perBufLen;
    private KaraScoreResult scoreResult;
    private ScoreResultCallback scoreResultCallback;
    private KaraScore scorer;

    public KaraScoreImpl(@NotNull ScoreConfig config) {
        Intrinsics.checkParameterIsNotNull(config, "config");
        this.config = config;
        this.perBufLen = 8192;
        this.scorer = new KaraScore();
    }

    public static final /* synthetic */ KaraScoreResult access$getScoreResult$p(KaraScoreImpl karaScoreImpl) {
        KaraScoreResult karaScoreResult = karaScoreImpl.scoreResult;
        if (karaScoreResult == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scoreResult");
        }
        return karaScoreResult;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScore
    public int bindPublicPitch(long nativeHandle) {
        return 0;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScore
    public void finish() {
        this.scoreResultCallback = null;
        this.scorer.destory();
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScore
    @Nullable
    public NoteItem[] getAllGrove(@Nullable Function1<? super NoteItem[], Unit> callback) {
        if (callback != null) {
            callback.invoke(this.scorer.getAllGrove());
            return null;
        }
        return this.scorer.getAllGrove();
    }

    @NotNull
    public final ScoreConfig getConfig() {
        return this.config;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScore
    @Nullable
    public int[] getGroveAndHit(float timeStamp, float pitch, @Nullable Function3<? super Integer, ? super Integer, ? super Float, Unit> callback) {
        if (callback != null) {
            int[] groveAndHit = this.scorer.getGroveAndHit();
            if (groveAndHit != null) {
                callback.invoke(Integer.valueOf(groveAndHit[0]), Integer.valueOf(groveAndHit[1]), Float.valueOf(timeStamp));
                return null;
            }
            return null;
        }
        return this.scorer.getGroveAndHit();
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScore
    public int getSCORE_TYPE_ACF() {
        return IScore.DefaultImpls.getSCORE_TYPE_ACF(this);
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScore
    public int getSCORE_TYPE_MIX() {
        return IScore.DefaultImpls.getSCORE_TYPE_MIX(this);
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScore
    public int getSCORE_TYPE_PYIN() {
        return IScore.DefaultImpls.getSCORE_TYPE_PYIN(this);
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScore
    @Nullable
    public IScoreResult getScoreResult() {
        KaraScoreResult karaScoreResult = this.scoreResult;
        if (karaScoreResult == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scoreResult");
        }
        return karaScoreResult;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScore
    @Nullable
    public int[] getValidScoreArray() {
        return null;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScore
    public int getValidSentenceNum() {
        return this.scorer.getValidSentenceNum();
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScore
    public int initWithNoteArray(@Nullable byte[] noteBuf, @Nullable int[] times, int sentenceCount, @Nullable int[] lines, @Nullable IMultiScore multi, @Nullable String resourceJson) {
        this.scoreResult = new KaraScoreResult(this.scorer);
        return this.scorer.init(noteBuf, times, lines, this.config.getSample(), this.config.getChannel(), getSCORE_TYPE_MIX());
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScore
    public int processWithBuffer(@Nullable byte[] pcmData, float timeStamp, int dataLen, @Nullable float[][] pitchs) {
        KaraScoreResult karaScoreResult;
        ScoreResultCallback scoreResultCallback;
        if (pitchs == null) {
            this.scorer.score(pcmData, dataLen, timeStamp);
        } else {
            this.scorer.scoreWithMix(pcmData, dataLen, timeStamp, pitchs);
        }
        int lastScore = this.scorer.getLastScore();
        KaraScoreResult karaScoreResult2 = this.scoreResult;
        if (karaScoreResult2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scoreResult");
        }
        karaScoreResult2.setLastScoreTmp(lastScore);
        KaraScoreResult karaScoreResult3 = this.scoreResult;
        if (karaScoreResult3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scoreResult");
        }
        karaScoreResult3.updateScoreResult(0L, false);
        if (lastScore != -1 && (karaScoreResult = this.scoreResult) != null && (scoreResultCallback = this.scoreResultCallback) != null) {
            if (karaScoreResult == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scoreResult");
            }
            scoreResultCallback.scoreResultCallback(karaScoreResult, timeStamp);
        }
        return 0;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScore
    public void seek(float timeStamp) {
        ScoreResultCallback scoreResultCallback;
        this.scorer.seek(timeStamp);
        KaraScore karaScore = this.scorer;
        int i3 = this.perBufLen;
        karaScore.score(new byte[i3 / 2], i3 / 2, timeStamp);
        KaraScoreResult karaScoreResult = this.scoreResult;
        if (karaScoreResult == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scoreResult");
        }
        karaScoreResult.setLastScoreTmp(0);
        KaraScoreResult karaScoreResult2 = this.scoreResult;
        if (karaScoreResult2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scoreResult");
        }
        karaScoreResult2.updateScoreResult(0L, true);
        KaraScoreResult karaScoreResult3 = this.scoreResult;
        if (karaScoreResult3 != null && (scoreResultCallback = this.scoreResultCallback) != null) {
            if (karaScoreResult3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scoreResult");
            }
            scoreResultCallback.scoreResultCallback(karaScoreResult3, timeStamp);
        }
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScore
    public void setPitch(int offset) {
        this.scorer.setPitch(offset);
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScore
    public void setScoreResultCallback(@NotNull ScoreResultCallback callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        this.scoreResultCallback = callback;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScore
    public void setSpeakerOriginal(boolean original) {
        this.scorer.setSpeakerOriginal(original);
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScore
    public void stop() {
        this.scoreResultCallback = null;
        this.scorer.destory();
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScore
    public void tryGetMultiScoreTmp(@Nullable Function1<? super ArrayList<MultiScoreStcInfo>, Unit> callback) {
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IScore
    public void setFinalMultiScoreResultCallback(@Nullable Function2<? super MultiScoreResult, ? super MultiScoreResult, Unit> callback, @Nullable String scoreMap, int lyricSize) {
    }
}
