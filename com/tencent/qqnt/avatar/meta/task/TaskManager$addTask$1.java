package com.tencent.qqnt.avatar.meta.task;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.avatar.util.d;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.avatar.meta.task.TaskManager$addTask$1", f = "TaskManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes23.dex */
public final class TaskManager$addTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ boolean $forceRefresh;
    final /* synthetic */ a $task;
    int label;
    final /* synthetic */ TaskManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskManager$addTask$1(TaskManager taskManager, a aVar, boolean z16, Continuation<? super TaskManager$addTask$1> continuation) {
        super(2, continuation);
        this.this$0 = taskManager;
        this.$task = aVar;
        this.$forceRefresh = z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, taskManager, aVar, Boolean.valueOf(z16), continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new TaskManager$addTask$1(this.this$0, this.$task, this.$forceRefresh, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        RunnableTask t16;
        ArrayDeque arrayDeque;
        Object obj2;
        ArrayDeque arrayDeque2;
        ArrayDeque arrayDeque3;
        String str;
        String str2;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                t16 = this.this$0.t(this.$task);
                if (t16 == null) {
                    arrayDeque = this.this$0.mWaitingQueue;
                    a aVar = this.$task;
                    Iterator<E> it = arrayDeque.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj2 = it.next();
                            if (Intrinsics.areEqual(((RunnableTask) obj2).c(), aVar.a())) {
                                break;
                            }
                        } else {
                            obj2 = null;
                            break;
                        }
                    }
                    RunnableTask runnableTask = (RunnableTask) obj2;
                    if (runnableTask == null) {
                        this.this$0.q(new RunnableTask(this.$task));
                        d dVar = d.f352991a;
                        str2 = this.this$0.TAG;
                        dVar.b(str2, new Function0<String>() { // from class: com.tencent.qqnt.avatar.meta.task.TaskManager$addTask$1.2
                            static IPatchRedirector $redirector_;

                            {
                                super(0);
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) a.this);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function0
                            @NotNull
                            public final String invoke() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                                }
                                return "mWaitingQueue addTask " + a.this.a();
                            }
                        });
                    } else {
                        runnableTask.a(this.$task);
                        arrayDeque2 = this.this$0.mWaitingQueue;
                        arrayDeque2.remove(runnableTask);
                        arrayDeque3 = this.this$0.mWaitingQueue;
                        arrayDeque3.add(runnableTask);
                        d dVar2 = d.f352991a;
                        str = this.this$0.TAG;
                        dVar2.b(str, new Function0<String>() { // from class: com.tencent.qqnt.avatar.meta.task.TaskManager$addTask$1.3
                            static IPatchRedirector $redirector_;

                            {
                                super(0);
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) a.this);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function0
                            @NotNull
                            public final String invoke() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                                }
                                return "mWaitingQueue addCallback " + a.this.a();
                            }
                        });
                    }
                    this.this$0.w();
                    return Unit.INSTANCE;
                }
                t16.a(this.$task);
                if (this.$forceRefresh) {
                    d dVar3 = d.f352991a;
                    str3 = this.this$0.TAG;
                    dVar3.a(str3, new Function0<String>() { // from class: com.tencent.qqnt.avatar.meta.task.TaskManager$addTask$1.1
                        static IPatchRedirector $redirector_;

                        {
                            super(0);
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) a.this);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @Nullable
                        public final String invoke() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                            return "addTask forceRefresh " + a.this.a();
                        }
                    });
                    this.this$0.q(t16);
                    this.this$0.r(t16.c());
                    this.this$0.u(t16);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((TaskManager$addTask$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
