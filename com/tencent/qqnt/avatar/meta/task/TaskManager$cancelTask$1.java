package com.tencent.qqnt.avatar.meta.task;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.avatar.util.d;
import java.util.Iterator;
import java.util.List;
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
@DebugMetadata(c = "com.tencent.qqnt.avatar.meta.task.TaskManager$cancelTask$1", f = "TaskManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes23.dex */
public final class TaskManager$cancelTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ a $task;
    int label;
    final /* synthetic */ TaskManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskManager$cancelTask$1(TaskManager taskManager, a aVar, Continuation<? super TaskManager$cancelTask$1> continuation) {
        super(2, continuation);
        this.this$0 = taskManager;
        this.$task = aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, taskManager, aVar, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new TaskManager$cancelTask$1(this.this$0, this.$task, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        List list;
        Object obj2;
        Object obj3;
        ArrayDeque arrayDeque;
        String str;
        ArrayDeque arrayDeque2;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                list = this.this$0.mRunningQueue;
                a aVar = this.$task;
                Iterator it = list.iterator();
                while (true) {
                    obj2 = null;
                    if (it.hasNext()) {
                        obj3 = it.next();
                        if (Intrinsics.areEqual(((RunnableTask) obj3).c(), aVar.a())) {
                            break;
                        }
                    } else {
                        obj3 = null;
                        break;
                    }
                }
                RunnableTask runnableTask = (RunnableTask) obj3;
                if (runnableTask == null) {
                    arrayDeque = this.this$0.mWaitingQueue;
                    a aVar2 = this.$task;
                    Iterator<E> it5 = arrayDeque.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            break;
                        }
                        Object next = it5.next();
                        if (Intrinsics.areEqual(((RunnableTask) next).c(), aVar2.a())) {
                            obj2 = next;
                            break;
                        }
                    }
                    RunnableTask runnableTask2 = (RunnableTask) obj2;
                    if (runnableTask2 != null) {
                        TaskManager taskManager = this.this$0;
                        final a aVar3 = this.$task;
                        d dVar = d.f352991a;
                        str = taskManager.TAG;
                        dVar.b(str, new Function0<String>() { // from class: com.tencent.qqnt.avatar.meta.task.TaskManager$cancelTask$1$4$1
                            static IPatchRedirector $redirector_;

                            /* JADX INFO: Access modifiers changed from: package-private */
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
                                return "cancelTask mWaitingQueue " + a.this.a();
                            }
                        });
                        if (runnableTask2.f(aVar3)) {
                            arrayDeque2 = taskManager.mWaitingQueue;
                            arrayDeque2.remove(runnableTask2);
                        }
                    }
                    return Unit.INSTANCE;
                }
                TaskManager taskManager2 = this.this$0;
                final a aVar4 = this.$task;
                d dVar2 = d.f352991a;
                str2 = taskManager2.TAG;
                dVar2.b(str2, new Function0<String>() { // from class: com.tencent.qqnt.avatar.meta.task.TaskManager$cancelTask$1$2$1
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        return "cancelTask mRunningQueue " + a.this.a();
                    }
                });
                if (runnableTask.f(aVar4)) {
                    taskManager2.r(runnableTask.c());
                    taskManager2.u(runnableTask);
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((TaskManager$cancelTask$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
