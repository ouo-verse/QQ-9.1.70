package com.tencent.robot.adelie.homepage.utils;

import com.tencent.robot.adelie.homepage.utils.AdelieAvatarUgcDebugUtil;
import java.io.File;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.robot.adelie.homepage.utils.AdelieAvatarUgcDebugUtil$uploadUgcTemplateToWorkChat$1", f = "AdelieAvatarUgcDebugUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes25.dex */
public final class AdelieAvatarUgcDebugUtil$uploadUgcTemplateToWorkChat$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AdelieAvatarUgcDebugUtil.a $fileUploadCallback;
    final /* synthetic */ String $zipFilePath;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdelieAvatarUgcDebugUtil$uploadUgcTemplateToWorkChat$1(String str, AdelieAvatarUgcDebugUtil.a aVar, Continuation<? super AdelieAvatarUgcDebugUtil$uploadUgcTemplateToWorkChat$1> continuation) {
        super(2, continuation);
        this.$zipFilePath = str;
        this.$fileUploadCallback = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AdelieAvatarUgcDebugUtil$uploadUgcTemplateToWorkChat$1(this.$zipFilePath, this.$fileUploadCallback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            AdelieAvatarUgcDebugUtil.f366632a.c("e424a177-399d-4664-abbc-9db656e97133", new File(this.$zipFilePath), this.$fileUploadCallback);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AdelieAvatarUgcDebugUtil$uploadUgcTemplateToWorkChat$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
