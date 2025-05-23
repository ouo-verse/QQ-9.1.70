package com.tencent.mobileqq.emoticonview.api.impl;

import com.tencent.mobileqq.emoticonview.ai.emoticon.AiEmoticonUploadHelper;
import com.tencent.mobileqq.emoticonview.ai.emoticon.PicModel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.CheckImageResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.emoticonview.api.impl.AiEmoticonServiceImpl$uploadPicAndCheck$1", f = "AiEmoticonServiceImpl.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
final class AiEmoticonServiceImpl$uploadPicAndCheck$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Ref.ObjectRef<CheckImageResult> $checkResult;
    final /* synthetic */ List<Pair<String, String>> $pathMd5List;
    final /* synthetic */ List<PicModel> $picModelList;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiEmoticonServiceImpl$uploadPicAndCheck$1(Ref.ObjectRef<CheckImageResult> objectRef, List<Pair<String, String>> list, List<PicModel> list2, Continuation<? super AiEmoticonServiceImpl$uploadPicAndCheck$1> continuation) {
        super(2, continuation);
        this.$checkResult = objectRef;
        this.$pathMd5List = list;
        this.$picModelList = list2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, objectRef, list, list2, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new AiEmoticonServiceImpl$uploadPicAndCheck$1(this.$checkResult, this.$pathMd5List, this.$picModelList, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Ref.ObjectRef<CheckImageResult> objectRef;
        T t16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 == 1) {
                    objectRef = (Ref.ObjectRef) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    t16 = obj;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                Ref.ObjectRef<CheckImageResult> objectRef2 = this.$checkResult;
                AiEmoticonUploadHelper aiEmoticonUploadHelper = AiEmoticonUploadHelper.INSTANCE;
                List<Pair<String, String>> list = this.$pathMd5List;
                List<PicModel> list2 = this.$picModelList;
                this.L$0 = objectRef2;
                this.label = 1;
                Object uploadPicAndCheck = aiEmoticonUploadHelper.uploadPicAndCheck(list, list2, this);
                if (uploadPicAndCheck == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef = objectRef2;
                t16 = uploadPicAndCheck;
            }
            objectRef.element = t16;
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AiEmoticonServiceImpl$uploadPicAndCheck$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
