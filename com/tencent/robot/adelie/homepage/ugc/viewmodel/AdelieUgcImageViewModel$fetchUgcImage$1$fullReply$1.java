package com.tencent.robot.adelie.homepage.ugc.viewmodel;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.adelie.homepage.download.AdelieGenerateImageRequest;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.ShadowAIGCGenerate$GenerateRequest;
import qshadow.ShadowAIGCGenerate$Media;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/robot/adelie/homepage/download/AdelieGenerateImageRequest$b;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.robot.adelie.homepage.ugc.viewmodel.AdelieUgcImageViewModel$fetchUgcImage$1$fullReply$1", f = "AdelieUgcImageViewModel.kt", i = {}, l = {276}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes25.dex */
final class AdelieUgcImageViewModel$fetchUgcImage$1$fullReply$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AdelieGenerateImageRequest.FullReply>, Object> {
    final /* synthetic */ ShadowAIGCGenerate$GenerateRequest $generateReq;
    int label;
    final /* synthetic */ AdelieUgcImageViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdelieUgcImageViewModel$fetchUgcImage$1$fullReply$1(ShadowAIGCGenerate$GenerateRequest shadowAIGCGenerate$GenerateRequest, AdelieUgcImageViewModel adelieUgcImageViewModel, Continuation<? super AdelieUgcImageViewModel$fetchUgcImage$1$fullReply$1> continuation) {
        super(2, continuation);
        this.$generateReq = shadowAIGCGenerate$GenerateRequest;
        this.this$0 = adelieUgcImageViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AdelieUgcImageViewModel$fetchUgcImage$1$fullReply$1(this.$generateReq, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        boolean z16;
        String str;
        PBRepeatMessageField<ShadowAIGCGenerate$Media> pBRepeatMessageField;
        ShadowAIGCGenerate$Media shadowAIGCGenerate$Media;
        PBStringField pBStringField;
        String str2;
        String str3;
        AdelieGenerateImageRequest adelieGenerateImageRequest;
        PBStringField pBStringField2;
        PBStringField pBStringField3;
        PBStringField pBStringField4;
        PBRepeatMessageField<ShadowAIGCGenerate$Media> pBRepeatMessageField2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            ShadowAIGCGenerate$GenerateRequest shadowAIGCGenerate$GenerateRequest = this.$generateReq;
            if (shadowAIGCGenerate$GenerateRequest != null && (pBRepeatMessageField2 = shadowAIGCGenerate$GenerateRequest.medias) != null && pBRepeatMessageField2.isEmpty()) {
                z16 = true;
            } else {
                z16 = false;
            }
            String str4 = null;
            if (z16) {
                str = "null";
            } else {
                ShadowAIGCGenerate$GenerateRequest shadowAIGCGenerate$GenerateRequest2 = this.$generateReq;
                if (shadowAIGCGenerate$GenerateRequest2 != null && (pBRepeatMessageField = shadowAIGCGenerate$GenerateRequest2.medias) != null && (shadowAIGCGenerate$Media = pBRepeatMessageField.get(0)) != null && (pBStringField = shadowAIGCGenerate$Media.string_data) != null) {
                    str = pBStringField.get();
                } else {
                    str = null;
                }
            }
            ShadowAIGCGenerate$GenerateRequest shadowAIGCGenerate$GenerateRequest3 = this.$generateReq;
            if (shadowAIGCGenerate$GenerateRequest3 != null && (pBStringField4 = shadowAIGCGenerate$GenerateRequest3.func_id) != null) {
                str2 = pBStringField4.get();
            } else {
                str2 = null;
            }
            ShadowAIGCGenerate$GenerateRequest shadowAIGCGenerate$GenerateRequest4 = this.$generateReq;
            if (shadowAIGCGenerate$GenerateRequest4 != null && (pBStringField3 = shadowAIGCGenerate$GenerateRequest4.busi_id) != null) {
                str3 = pBStringField3.get();
            } else {
                str3 = null;
            }
            ShadowAIGCGenerate$GenerateRequest shadowAIGCGenerate$GenerateRequest5 = this.$generateReq;
            if (shadowAIGCGenerate$GenerateRequest5 != null && (pBStringField2 = shadowAIGCGenerate$GenerateRequest5.extra) != null) {
                str4 = pBStringField2.get();
            }
            QLog.d("AdelieUgcImageViewModel", 1, "fetchUgcImage generateReq  fun_id: " + str2 + " bus_id: " + str3 + " extra: " + str4 + "  imageUrl: " + str);
            adelieGenerateImageRequest = this.this$0.mRequest;
            ShadowAIGCGenerate$GenerateRequest shadowAIGCGenerate$GenerateRequest6 = this.$generateReq;
            this.label = 1;
            obj = adelieGenerateImageRequest.d(shadowAIGCGenerate$GenerateRequest6, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super AdelieGenerateImageRequest.FullReply> continuation) {
        return ((AdelieUgcImageViewModel$fetchUgcImage$1$fullReply$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
