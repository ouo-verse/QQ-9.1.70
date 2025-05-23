package com.tencent.qqnt.avatar.meta.task;

import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u000b\u0018\u0000 \u00052\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b#\u0010$J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006R\u0017\u0010\u000f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\f\u001a\u0004\b\r\u0010\u000eRI\u0010\u0019\u001a1\b\u0001\u0012\u0015\u0012\u0013\u0018\u00010\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00108\u0006\u00f8\u0001\u0000\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001bR\"\u0010\"\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001f\"\u0004\b \u0010!\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006%"}, d2 = {"Lcom/tencent/qqnt/avatar/meta/task/RunnableTask;", "", "Lcom/tencent/qqnt/avatar/meta/task/b;", "result", "", "e", "Lcom/tencent/qqnt/avatar/meta/task/a;", "task", "a", "", "f", "", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "key", "Lkotlin/Function2;", "Lwv3/a;", "Lkotlin/ParameterName;", "name", "listener", "Lkotlin/coroutines/Continuation;", "b", "Lkotlin/jvm/functions/Function2;", "()Lkotlin/jvm/functions/Function2;", "businessWork", "", "Ljava/util/List;", "taskList", "d", "Z", "()Z", "setActive", "(Z)V", "isActive", "<init>", "(Lcom/tencent/qqnt/avatar/meta/task/a;)V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class RunnableTask {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String key;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function2<wv3.a, Continuation<? super b>, Object> businessWork;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<a> taskList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isActive;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u008a@"}, d2 = {"Lwv3/a;", "listener", "Lcom/tencent/qqnt/avatar/meta/task/b;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.qqnt.avatar.meta.task.RunnableTask$1", f = "RunnableTask.kt", i = {}, l = {16}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.qqnt.avatar.meta.task.RunnableTask$1, reason: invalid class name */
    /* loaded from: classes23.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<wv3.a, Continuation<? super b>, Object> {
        static IPatchRedirector $redirector_;
        final /* synthetic */ com.tencent.qqnt.avatar.meta.task.a $task;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ RunnableTask this$0;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/avatar/meta/task/RunnableTask$1$a", "Lwv3/a;", "Lcom/tencent/qqnt/avatar/meta/task/RunnableTask;", "runnableTask", "", "b", "", "key", "a", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.qqnt.avatar.meta.task.RunnableTask$1$a */
        /* loaded from: classes23.dex */
        public static final class a implements wv3.a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ wv3.a f352962a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ RunnableTask f352963b;

            a(wv3.a aVar, RunnableTask runnableTask) {
                this.f352962a = aVar;
                this.f352963b = runnableTask;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) runnableTask);
                }
            }

            @Override // wv3.a
            public void a(@NotNull String key) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) key);
                    return;
                }
                Intrinsics.checkNotNullParameter(key, "key");
                wv3.a aVar = this.f352962a;
                if (aVar != null) {
                    aVar.a(key);
                }
            }

            @Override // wv3.a
            public void b(@Nullable RunnableTask runnableTask) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnableTask);
                    return;
                }
                wv3.a aVar = this.f352962a;
                if (aVar != null) {
                    aVar.b(this.f352963b);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(com.tencent.qqnt.avatar.meta.task.a aVar, RunnableTask runnableTask, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$task = aVar;
            this.this$0 = runnableTask;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, aVar, runnableTask, continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
            }
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$task, this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
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
                    wv3.a aVar = (wv3.a) this.L$0;
                    com.tencent.qqnt.avatar.meta.task.a aVar2 = this.$task;
                    a aVar3 = new a(aVar, this.this$0);
                    this.label = 1;
                    obj = aVar2.c(aVar3, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return (b) obj;
            }
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@Nullable wv3.a aVar, @Nullable Continuation<? super b> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass1) create(aVar, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar, (Object) continuation);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/avatar/meta/task/RunnableTask$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.avatar.meta.task.RunnableTask$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(ProfileContants.FIELD_FRIEND_INTIMATE);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public RunnableTask(@NotNull a task) {
        Intrinsics.checkNotNullParameter(task, "task");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) task);
            return;
        }
        this.key = task.a();
        ArrayList arrayList = new ArrayList();
        this.taskList = arrayList;
        this.isActive = true;
        this.businessWork = new AnonymousClass1(task, this, null);
        arrayList.add(task);
    }

    public final void a(@NotNull a task) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) task);
        } else {
            Intrinsics.checkNotNullParameter(task, "task");
            this.taskList.add(task);
        }
    }

    @NotNull
    public final Function2<wv3.a, Continuation<? super b>, Object> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Function2) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.businessWork;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.key;
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.isActive;
    }

    public final void e(@NotNull b result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) result);
            return;
        }
        Intrinsics.checkNotNullParameter(result, "result");
        Iterator<T> it = this.taskList.iterator();
        while (it.hasNext()) {
            ((a) it.next()).b(result);
        }
    }

    public final boolean f(@NotNull a task) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) task)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(task, "task");
        this.taskList.remove(task);
        if (this.taskList.size() != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isActive = z16;
        return !z16;
    }
}
