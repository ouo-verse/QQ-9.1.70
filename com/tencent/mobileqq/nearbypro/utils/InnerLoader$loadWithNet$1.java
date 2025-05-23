package com.tencent.mobileqq.nearbypro.utils;

import android.os.Looper;
import android.widget.ImageView;
import com.tencent.mobileqq.nearbypro.base.ILog;
import com.tencent.mobileqq.nearbypro.repository.service.BDHService;
import fu4.v;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.nearbypro.utils.InnerLoader$loadWithNet$1", f = "StImageLoader.kt", i = {0}, l = {85, 174}, m = "invokeSuspend", n = {"$this$qLaunch"}, s = {"L$0"})
/* loaded from: classes15.dex */
public final class InnerLoader$loadWithNet$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ InnerLoader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerLoader$loadWithNet$1(InnerLoader innerLoader, Continuation<? super InnerLoader$loadWithNet$1> continuation) {
        super(2, continuation);
        this.this$0 = innerLoader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        InnerLoader$loadWithNet$1 innerLoader$loadWithNet$1 = new InnerLoader$loadWithNet$1(this.this$0, continuation);
        innerLoader$loadWithNet$1.L$0 = obj;
        return innerLoader$loadWithNet$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00e6, code lost:
    
        if (r0 == true) goto L28;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object firstOrNull;
        boolean n3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        boolean z16 = true;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            BDHService bDHService = new BDHService();
            v indexNode = this.this$0.getIndexNode();
            this.L$0 = coroutineScope;
            this.label = 1;
            obj = bDHService.j(indexNode, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) obj);
        String str = (String) firstOrNull;
        if (str == null) {
            InnerLoader innerLoader = this.this$0;
            ILog.Level level = ILog.Level.ERROR;
            com.tencent.mobileqq.nearbypro.base.j.c().b("StImageLoader", level, innerLoader.logPrefix + ((Object) "loadWithNet getImageUrl failed"));
            return Unit.INSTANCE;
        }
        InnerLoader innerLoader2 = this.this$0;
        ILog.Level level2 = ILog.Level.INFO;
        com.tencent.mobileqq.nearbypro.base.j.c().b("StImageLoader", level2, innerLoader2.logPrefix + ((Object) ("loadWithNet getImageUrl success: url:" + str)));
        InnerLoader innerLoader3 = this.this$0;
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(Looper.getMainLooper(), "Looper.getMainLooper()");
        if (!Intrinsics.areEqual(currentThread, r4.getThread())) {
            MainCoroutineDispatcher main = Dispatchers.getMain();
            InnerLoader$loadWithNet$1$invokeSuspend$$inlined$checkTargetOnUI$1 innerLoader$loadWithNet$1$invokeSuspend$$inlined$checkTargetOnUI$1 = new InnerLoader$loadWithNet$1$invokeSuspend$$inlined$checkTargetOnUI$1(null, innerLoader3, innerLoader3, innerLoader3, str);
            this.L$0 = null;
            this.label = 2;
            if (BuildersKt.withContext(main, innerLoader$loadWithNet$1$invokeSuspend$$inlined$checkTargetOnUI$1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            ImageView targetView = innerLoader3.getTargetView();
            if (targetView != null) {
                n3 = innerLoader3.n(targetView, innerLoader3.getIndexNode());
            }
            z16 = false;
            if (!z16) {
                innerLoader3.p(str);
            } else {
                ILog.Level level3 = ILog.Level.ERROR;
                com.tencent.mobileqq.nearbypro.base.j.c().b("StImageLoader", level3, innerLoader3.logPrefix + ((Object) "loadWithNet not a same stImage"));
            }
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((InnerLoader$loadWithNet$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
