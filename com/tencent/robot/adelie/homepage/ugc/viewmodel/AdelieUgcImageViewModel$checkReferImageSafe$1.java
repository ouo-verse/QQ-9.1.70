package com.tencent.robot.adelie.homepage.ugc.viewmodel;

import com.google.gson.Gson;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.adelie.homepage.download.AdelieGenerateImageRequest;
import d24.AdelieAvatarInfo;
import d24.AdelieAvatarInputPreprocessReply;
import d24.AdelieAvatarMediaExtra;
import d24.GenerateRequestExtra;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.ShadowAIGCGenerate$GenerateReply;
import qshadow.ShadowAIGCGenerate$GenerateRequest;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.robot.adelie.homepage.ugc.viewmodel.AdelieUgcImageViewModel$checkReferImageSafe$1", f = "AdelieUgcImageViewModel.kt", i = {}, l = {179}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes25.dex */
public final class AdelieUgcImageViewModel$checkReferImageSafe$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $callback;
    final /* synthetic */ ShadowAIGCGenerate$GenerateRequest $generateReq;
    int label;
    final /* synthetic */ AdelieUgcImageViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AdelieUgcImageViewModel$checkReferImageSafe$1(AdelieUgcImageViewModel adelieUgcImageViewModel, Function1<? super Boolean, Unit> function1, ShadowAIGCGenerate$GenerateRequest shadowAIGCGenerate$GenerateRequest, Continuation<? super AdelieUgcImageViewModel$checkReferImageSafe$1> continuation) {
        super(2, continuation);
        this.this$0 = adelieUgcImageViewModel;
        this.$callback = function1;
        this.$generateReq = shadowAIGCGenerate$GenerateRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AdelieUgcImageViewModel$checkReferImageSafe$1(this.this$0, this.$callback, this.$generateReq, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        ShadowAIGCGenerate$GenerateReply shadowAIGCGenerate$GenerateReply;
        byte b16;
        Long l3;
        byte b17;
        byte b18;
        AdelieAvatarInfo adelieAvatarInfo;
        AdelieAvatarInfo adelieAvatarInfo2;
        GenerateRequestExtra generateRequestExtra;
        AdelieAvatarInfo adelieAvatarInfo3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        String str = null;
        GenerateRequestExtra generateRequestExtra2 = null;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            AdelieUgcImageViewModel$checkReferImageSafe$1$fullReply$1 adelieUgcImageViewModel$checkReferImageSafe$1$fullReply$1 = new AdelieUgcImageViewModel$checkReferImageSafe$1$fullReply$1(this.$generateReq, this.this$0, null);
            this.label = 1;
            obj = TimeoutKt.withTimeout(30000L, adelieUgcImageViewModel$checkReferImageSafe$1$fullReply$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        AdelieGenerateImageRequest.FullReply fullReply = (AdelieGenerateImageRequest.FullReply) obj;
        if (fullReply != null) {
            shadowAIGCGenerate$GenerateReply = fullReply.getDate();
        } else {
            shadowAIGCGenerate$GenerateReply = null;
        }
        if (shadowAIGCGenerate$GenerateReply != null) {
            if (fullReply != null && fullReply.getErrorCode() == 0) {
                b17 = true;
            } else {
                b17 = false;
            }
            if (b17 != false) {
                try {
                    AdelieAvatarInputPreprocessReply adelieAvatarInputPreprocessReply = (AdelieAvatarInputPreprocessReply) new Gson().fromJson(shadowAIGCGenerate$GenerateReply.extra.get(), AdelieAvatarInputPreprocessReply.class);
                    if (adelieAvatarInputPreprocessReply.getTranslated_prompt().length() > 0) {
                        b18 = true;
                    } else {
                        b18 = false;
                    }
                    if (b18 != false) {
                        adelieAvatarInfo2 = this.this$0.mAvatarInfo;
                        if (adelieAvatarInfo2 != null) {
                            generateRequestExtra = adelieAvatarInfo2.getExtra();
                        } else {
                            generateRequestExtra = null;
                        }
                        if (generateRequestExtra != null) {
                            generateRequestExtra.g(adelieAvatarInputPreprocessReply.getTranslated_prompt());
                        }
                        adelieAvatarInfo3 = this.this$0.mAvatarInfo;
                        if (adelieAvatarInfo3 != null) {
                            adelieAvatarInfo3.e(new AdelieAvatarMediaExtra(adelieAvatarInputPreprocessReply.getMsg_id()));
                        }
                        QLog.d("AdelieUgcImageViewModel", 1, "checkReferImage reply msg_id: " + adelieAvatarInputPreprocessReply.getMsg_id());
                    }
                    adelieAvatarInfo = this.this$0.mAvatarInfo;
                    if (adelieAvatarInfo != null) {
                        generateRequestExtra2 = adelieAvatarInfo.getExtra();
                    }
                    if (generateRequestExtra2 != null) {
                        generateRequestExtra2.h(true);
                    }
                    this.$callback.invoke(Boxing.boxBoolean(true));
                    return Unit.INSTANCE;
                } catch (Exception unused) {
                    QLog.e("AdelieUgcImageViewModel", 1, "checkReferImage failed cause by gson");
                    this.$callback.invoke(Boxing.boxBoolean(false));
                    return Unit.INSTANCE;
                }
            }
        }
        if (fullReply != null && fullReply.getErrorCode() == 0) {
            b16 = true;
        } else {
            b16 = false;
        }
        if (b16 == false) {
            AdelieUgcImageViewModel adelieUgcImageViewModel = this.this$0;
            if (fullReply != null) {
                l3 = Boxing.boxLong(fullReply.getErrorCode());
            } else {
                l3 = null;
            }
            if (fullReply != null) {
                str = fullReply.getErrMsg();
            }
            adelieUgcImageViewModel.s2(l3, str);
        }
        QLog.e("AdelieUgcImageViewModel", 1, "checkReferImage failed");
        this.$callback.invoke(Boxing.boxBoolean(false));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AdelieUgcImageViewModel$checkReferImageSafe$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
