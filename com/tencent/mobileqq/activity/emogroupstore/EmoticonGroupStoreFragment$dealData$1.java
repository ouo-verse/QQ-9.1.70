package com.tencent.mobileqq.activity.emogroupstore;

import com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupDataSource;
import com.tencent.mobileqq.activity.emogroupstore.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment$dealData$1", f = "EmoticonGroupStoreFragment.kt", i = {}, l = {459}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes10.dex */
public final class EmoticonGroupStoreFragment$dealData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ EmoticonGroupDataSource.b $emoListResult;
    final /* synthetic */ int $requestCount;
    int label;
    final /* synthetic */ EmoticonGroupStoreFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmoticonGroupStoreFragment$dealData$1(EmoticonGroupDataSource.b bVar, EmoticonGroupStoreFragment emoticonGroupStoreFragment, int i3, Continuation<? super EmoticonGroupStoreFragment$dealData$1> continuation) {
        super(2, continuation);
        this.$emoListResult = bVar;
        this.this$0 = emoticonGroupStoreFragment;
        this.$requestCount = i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bVar, emoticonGroupStoreFragment, Integer.valueOf(i3), continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new EmoticonGroupStoreFragment$dealData$1(this.$emoListResult, this.this$0, this.$requestCount, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        EmoticonGroupViewModel emoticonGroupViewModel;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
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
                long e16 = this.$emoListResult.e();
                QLog.d("EmoticonFromGroup_Fragment", 1, "sendUserIntent GetEmoList secondPage. filterMsgFromTimeSecondPage=", Boxing.boxLong(e16));
                emoticonGroupViewModel = this.this$0.viewModel;
                if (emoticonGroupViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    emoticonGroupViewModel = null;
                }
                c.a aVar = new c.a(500 - this.$requestCount, e16);
                this.label = 1;
                if (emoticonGroupViewModel.sendUserIntent(aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((EmoticonGroupStoreFragment$dealData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
