package com.tencent.qqnt.chats.utils.preload;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chats.utils.preload.LayoutPreLoader;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.chats.utils.preload.LayoutPreLoader$addPreLoader$1", f = "LayoutPreLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes24.dex */
public final class LayoutPreLoader$addPreLoader$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Object $key;
    final /* synthetic */ LayoutPreLoader.c<?> $loader;
    final /* synthetic */ int $preloadSize;
    int label;
    final /* synthetic */ LayoutPreLoader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LayoutPreLoader$addPreLoader$1(LayoutPreLoader layoutPreLoader, Object obj, int i3, LayoutPreLoader.c<?> cVar, Continuation<? super LayoutPreLoader$addPreLoader$1> continuation) {
        super(1, continuation);
        this.this$0 = layoutPreLoader;
        this.$key = obj;
        this.$preloadSize = i3;
        this.$loader = cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, layoutPreLoader, obj, Integer.valueOf(i3), cVar, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, (Object) continuation);
        }
        return new LayoutPreLoader$addPreLoader$1(this.this$0, this.$key, this.$preloadSize, this.$loader, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        HashMap hashMap;
        HashMap hashMap2;
        HashMap hashMap3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                hashMap = this.this$0.pools;
                hashMap.put(this.$key, new LinkedBlockingQueue(this.$preloadSize));
                hashMap2 = this.this$0.loaderList;
                hashMap2.put(this.$key, this.$loader);
                hashMap3 = this.this$0.remainSize;
                hashMap3.put(this.$key, Boxing.boxInt(this.$preloadSize));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function1
    @Nullable
    public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((LayoutPreLoader$addPreLoader$1) create(continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) continuation);
    }
}
