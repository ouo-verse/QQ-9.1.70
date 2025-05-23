package com.tencent.qqnt.chats.utils.preload;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chats.utils.preload.LayoutPreLoader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.chats.utils.preload.LayoutPreLoader$startPreload$1$1", f = "LayoutPreLoader.kt", i = {0, 0, 0, 0}, l = {57}, m = "invokeSuspend", n = {"list", "loader", "out", "remain"}, s = {"L$2", "L$3", "L$4", "I$0"})
/* loaded from: classes24.dex */
public final class LayoutPreLoader$startPreload$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ LayoutPreLoader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LayoutPreLoader$startPreload$1$1(LayoutPreLoader layoutPreLoader, Continuation<? super LayoutPreLoader$startPreload$1$1> continuation) {
        super(1, continuation);
        this.this$0 = layoutPreLoader;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) layoutPreLoader, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, (Object) continuation);
        }
        return new LayoutPreLoader$startPreload$1$1(this.this$0, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x00c8 -> B:12:0x00cb). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0089 -> B:13:0x00af). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        HashMap hashMap;
        LayoutPreLoader layoutPreLoader;
        Iterator it;
        LayoutPreLoader$startPreload$1$1 layoutPreLoader$startPreload$1$1;
        HashMap hashMap2;
        HashMap hashMap3;
        HashMap hashMap4;
        Object l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 == 1) {
                    int i16 = this.I$1;
                    int intValue = this.I$0;
                    CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.L$4;
                    LayoutPreLoader.c cVar = (LayoutPreLoader.c) this.L$3;
                    LinkedBlockingQueue linkedBlockingQueue = (LinkedBlockingQueue) this.L$2;
                    Iterator it5 = (Iterator) this.L$1;
                    LayoutPreLoader layoutPreLoader2 = (LayoutPreLoader) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    LayoutPreLoader$startPreload$1$1 layoutPreLoader$startPreload$1$12 = this;
                    i16++;
                    if (i16 < intValue) {
                        if (copyOnWriteArrayList.size() > 0) {
                            linkedBlockingQueue.addAll(copyOnWriteArrayList);
                        }
                        layoutPreLoader$startPreload$1$1 = layoutPreLoader$startPreload$1$12;
                        it = it5;
                        layoutPreLoader = layoutPreLoader2;
                        while (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            Object key = entry.getKey();
                            LinkedBlockingQueue linkedBlockingQueue2 = (LinkedBlockingQueue) entry.getValue();
                            hashMap2 = layoutPreLoader.loaderList;
                            LayoutPreLoader.c cVar2 = (LayoutPreLoader.c) hashMap2.get(key);
                            hashMap3 = layoutPreLoader.remainSize;
                            if (hashMap3.containsKey(key)) {
                                Intrinsics.checkNotNull(cVar2);
                                if (cVar2.b()) {
                                    hashMap4 = layoutPreLoader.remainSize;
                                    Object obj2 = hashMap4.get(key);
                                    Intrinsics.checkNotNull(obj2);
                                    it5 = it;
                                    layoutPreLoader$startPreload$1$12 = layoutPreLoader$startPreload$1$1;
                                    intValue = ((Number) obj2).intValue() - linkedBlockingQueue2.size();
                                    cVar = cVar2;
                                    linkedBlockingQueue = linkedBlockingQueue2;
                                    copyOnWriteArrayList = new CopyOnWriteArrayList();
                                    layoutPreLoader2 = layoutPreLoader;
                                    i16 = 0;
                                    if (i16 < intValue) {
                                        Intrinsics.checkNotNull(cVar);
                                        layoutPreLoader$startPreload$1$12.L$0 = layoutPreLoader2;
                                        layoutPreLoader$startPreload$1$12.L$1 = it5;
                                        layoutPreLoader$startPreload$1$12.L$2 = linkedBlockingQueue;
                                        layoutPreLoader$startPreload$1$12.L$3 = cVar;
                                        layoutPreLoader$startPreload$1$12.L$4 = copyOnWriteArrayList;
                                        layoutPreLoader$startPreload$1$12.I$0 = intValue;
                                        layoutPreLoader$startPreload$1$12.I$1 = i16;
                                        layoutPreLoader$startPreload$1$12.label = 1;
                                        l3 = layoutPreLoader2.l(cVar, copyOnWriteArrayList, layoutPreLoader$startPreload$1$12);
                                        if (l3 == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        i16++;
                                        if (i16 < intValue) {
                                        }
                                    }
                                }
                            }
                        }
                        layoutPreLoader$startPreload$1$1.this$0.preloadJob = null;
                        return Unit.INSTANCE;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                hashMap = this.this$0.pools;
                layoutPreLoader = this.this$0;
                it = hashMap.entrySet().iterator();
                layoutPreLoader$startPreload$1$1 = this;
                while (it.hasNext()) {
                }
                layoutPreLoader$startPreload$1$1.this$0.preloadJob = null;
                return Unit.INSTANCE;
            }
        } else {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    @Nullable
    public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((LayoutPreLoader$startPreload$1$1) create(continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) continuation);
    }
}
