package com.tencent.robot.adelie.homepage.ugc.viewmodel;

import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.adelie.homepage.AdelieUtils;
import d24.AdelieAvatarInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.robot.adelie.homepage.ugc.viewmodel.AdelieUgcImageViewModel$uploadAvatarAndGetUrl$1", f = "AdelieUgcImageViewModel.kt", i = {}, l = {com.tencent.luggage.wxa.v1.b.CTRL_INDEX}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes25.dex */
public final class AdelieUgcImageViewModel$uploadAvatarAndGetUrl$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $callback;
    final /* synthetic */ String $localPath;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AdelieUgcImageViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdelieUgcImageViewModel$uploadAvatarAndGetUrl$1(AdelieUgcImageViewModel adelieUgcImageViewModel, Function0<Unit> function0, String str, Continuation<? super AdelieUgcImageViewModel$uploadAvatarAndGetUrl$1> continuation) {
        super(2, continuation);
        this.this$0 = adelieUgcImageViewModel;
        this.$callback = function0;
        this.$localPath = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        AdelieUgcImageViewModel$uploadAvatarAndGetUrl$1 adelieUgcImageViewModel$uploadAvatarAndGetUrl$1 = new AdelieUgcImageViewModel$uploadAvatarAndGetUrl$1(this.this$0, this.$callback, this.$localPath, continuation);
        adelieUgcImageViewModel$uploadAvatarAndGetUrl$1.L$0 = obj;
        return adelieUgcImageViewModel$uploadAvatarAndGetUrl$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Deferred async$default;
        AdelieAvatarInfo adelieAvatarInfo;
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
            async$default = BuildersKt__Builders_commonKt.async$default((CoroutineScope) this.L$0, null, null, new AdelieUgcImageViewModel$uploadAvatarAndGetUrl$1$originUrlJob$1(this.$localPath, null), 3, null);
            this.label = 1;
            obj = async$default.await(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        AdelieUtils.UploadResult uploadResult = (AdelieUtils.UploadResult) obj;
        QLog.i("AdelieUgcImageViewModel", 1, "originImageUrl " + uploadResult);
        adelieAvatarInfo = this.this$0.mAvatarInfo;
        Intrinsics.checkNotNull(adelieAvatarInfo);
        adelieAvatarInfo.d(uploadResult.getUrl());
        this.$callback.invoke();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AdelieUgcImageViewModel$uploadAvatarAndGetUrl$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
