package com.tencent.robot.adelie.kuikly.view.record;

import com.tencent.robot.adelie.kuikly.module.AdelieTtsRecordParam;
import com.tencent.xweb.FileReaderHelper;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.robot.adelie.kuikly.view.record.AdelieWavFile$saveWav$1", f = "AdelieWavFile.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes25.dex */
public final class AdelieWavFile$saveWav$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AdelieTtsRecordParam $param;
    final /* synthetic */ String $pcmForVadPath;
    final /* synthetic */ Function2<Boolean, String, Unit> $success;
    int label;
    final /* synthetic */ AdelieWavFile this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AdelieWavFile$saveWav$1(String str, AdelieWavFile adelieWavFile, AdelieTtsRecordParam adelieTtsRecordParam, Function2<? super Boolean, ? super String, Unit> function2, Continuation<? super AdelieWavFile$saveWav$1> continuation) {
        super(2, continuation);
        this.$pcmForVadPath = str;
        this.this$0 = adelieWavFile;
        this.$param = adelieTtsRecordParam;
        this.$success = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AdelieWavFile$saveWav$1(this.$pcmForVadPath, this.this$0, this.$param, this.$success, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        byte[] f16;
        String d16;
        boolean i3;
        boolean z16;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                f16 = this.this$0.f(new File(this.$pcmForVadPath));
                int sampleRate = (int) this.$param.getSampleRate();
                int channelsPerFrame = this.$param.getChannelsPerFrame();
                int bitsPerChannel = this.$param.getBitsPerChannel();
                d16 = this.this$0.d(this.$pcmForVadPath, FileReaderHelper.WAV_EXT);
                i3 = this.this$0.i(f16, sampleRate, channelsPerFrame, bitsPerChannel, new File(d16));
                if (i3) {
                    new File(this.$pcmForVadPath).delete();
                }
                Function2<Boolean, String, Unit> function2 = this.$success;
                if (i3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                function2.invoke(Boxing.boxBoolean(z16), d16);
            } catch (Exception unused) {
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AdelieWavFile$saveWav$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
