package com.tencent.tavcut.core.render.audio.wave;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "com.tencent.tavcut.core.render.audio.wave.MediaCodecAudioWaveDataProcessor$decodeForWaveData$1", f = "MediaCodecAudioWaveDataProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes26.dex */
public final class MediaCodecAudioWaveDataProcessor$decodeForWaveData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $perSecondSampleCnt;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ MediaCodecAudioWaveDataProcessor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaCodecAudioWaveDataProcessor$decodeForWaveData$1(MediaCodecAudioWaveDataProcessor mediaCodecAudioWaveDataProcessor, int i3, Continuation continuation) {
        super(2, continuation);
        this.this$0 = mediaCodecAudioWaveDataProcessor;
        this.$perSecondSampleCnt = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        MediaCodecAudioWaveDataProcessor$decodeForWaveData$1 mediaCodecAudioWaveDataProcessor$decodeForWaveData$1 = new MediaCodecAudioWaveDataProcessor$decodeForWaveData$1(this.this$0, this.$perSecondSampleCnt, completion);
        mediaCodecAudioWaveDataProcessor$decodeForWaveData$1.p$ = (CoroutineScope) obj;
        return mediaCodecAudioWaveDataProcessor$decodeForWaveData$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MediaCodecAudioWaveDataProcessor$decodeForWaveData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean prepare;
        IWaveDataCaptureListener iWaveDataCaptureListener;
        int i3;
        int i16;
        int i17;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            prepare = this.this$0.prepare();
            if (prepare) {
                MediaCodecAudioWaveDataProcessor mediaCodecAudioWaveDataProcessor = this.this$0;
                i3 = this.this$0.sampleRate;
                i16 = this.this$0.channelCount;
                i17 = this.this$0.encodingPcmBit;
                mediaCodecAudioWaveDataProcessor.waveDataCalculator = new AudioWaveDataCalculator(i3, i16, i17, this.$perSecondSampleCnt);
                this.this$0.decodeAudio();
            } else {
                MediaCodecAudioWaveDataProcessor.access$getMediaExtractor$p(this.this$0).release();
                iWaveDataCaptureListener = this.this$0.dataCaptureListener;
                if (iWaveDataCaptureListener != null) {
                    iWaveDataCaptureListener.onCaptureError(2, "Init mediaExtractor failed");
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
