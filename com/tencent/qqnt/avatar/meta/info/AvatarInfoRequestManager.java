package com.tencent.qqnt.avatar.meta.info;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.avatar.cache.AvatarInfoCache;
import com.tencent.qqnt.avatar.meta.task.TaskManager;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J-\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ8\u0010\u000f\u001a\u00020\u000e2\u0014\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J-\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\tJ\u001d\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/avatar/meta/info/AvatarInfoRequestManager;", "", "Lcom/tencent/qqnt/avatar/meta/a;", "avatarBean", "", "skipMemory", "", "Lcom/tencent/qqnt/avatar/meta/info/a;", "e", "(Lcom/tencent/qqnt/avatar/meta/a;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CancellableContinuation;", "cancellableContinuation", "Lcom/tencent/qqnt/avatar/meta/info/b;", "callback", "", "d", "f", h.F, "(Lcom/tencent/qqnt/avatar/meta/a;)[Lcom/tencent/qqnt/avatar/meta/info/a;", "Lcom/tencent/qqnt/avatar/meta/task/TaskManager;", "b", "Lcom/tencent/qqnt/avatar/meta/task/TaskManager;", "taskManager", "<init>", "()V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AvatarInfoRequestManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AvatarInfoRequestManager f352916a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final TaskManager taskManager;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/avatar/meta/info/AvatarInfoRequestManager$a", "Lcom/tencent/qqnt/avatar/meta/info/b;", "", "Lcom/tencent/qqnt/avatar/meta/info/a;", "infoArr", "", "a", "([Lcom/tencent/qqnt/avatar/meta/info/a;)V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a implements b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<com.tencent.qqnt.avatar.meta.info.a[]> f352918a;

        /* JADX WARN: Multi-variable type inference failed */
        a(CancellableContinuation<? super com.tencent.qqnt.avatar.meta.info.a[]> cancellableContinuation) {
            this.f352918a = cancellableContinuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cancellableContinuation);
            }
        }

        @Override // com.tencent.qqnt.avatar.meta.info.b
        public void a(@Nullable com.tencent.qqnt.avatar.meta.info.a[] infoArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) infoArr);
                return;
            }
            CancellableContinuation<com.tencent.qqnt.avatar.meta.info.a[]> cancellableContinuation = this.f352918a;
            if (cancellableContinuation.isActive()) {
                cancellableContinuation.resumeWith(Result.m476constructorimpl(infoArr));
            } else {
                com.tencent.qqnt.avatar.util.d.d(com.tencent.qqnt.avatar.util.d.f352991a, "AvatarInfoRequestManager", "getAvatarInfo alreadyResumedError", null, 4, null);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40171);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f352916a = new AvatarInfoRequestManager();
            taskManager = new TaskManager("AvatarInfoRequestManager", null, 200, 0L, 0, 0, false, 122, null);
        }
    }

    AvatarInfoRequestManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(CancellableContinuation<? super com.tencent.qqnt.avatar.meta.info.a[]> cancellableContinuation, com.tencent.qqnt.avatar.meta.a avatarBean, boolean skipMemory, b callback) {
        String str = avatarBean.a() + "_" + avatarBean.c();
        if (skipMemory) {
            str = str + "_skipMemory";
        }
        final BaseInfoRequestTask baseInfoRequestTask = new BaseInfoRequestTask(str, avatarBean, callback, skipMemory);
        TaskManager.p(taskManager, baseInfoRequestTask, false, 2, null);
        cancellableContinuation.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.tencent.qqnt.avatar.meta.info.AvatarInfoRequestManager$asyncGetAvatarInfo$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) BaseInfoRequestTask.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                TaskManager taskManager2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) th5);
                    return;
                }
                com.tencent.qqnt.avatar.util.d.f352991a.a("AvatarInfoRequestManager", new Function0<String>() { // from class: com.tencent.qqnt.avatar.meta.info.AvatarInfoRequestManager$asyncGetAvatarInfo$1.1
                    static IPatchRedirector $redirector_;

                    {
                        super(0);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BaseInfoRequestTask.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @Nullable
                    public final String invoke() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                        return "getAvatarInfo be canceled. worker: " + BaseInfoRequestTask.this.a();
                    }
                });
                taskManager2 = AvatarInfoRequestManager.taskManager;
                taskManager2.s(BaseInfoRequestTask.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object e(com.tencent.qqnt.avatar.meta.a aVar, boolean z16, Continuation<? super com.tencent.qqnt.avatar.meta.info.a[]> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        if (!(aVar instanceof com.tencent.qqnt.avatar.meta.b) || ((com.tencent.qqnt.avatar.meta.b) aVar).l() == null) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            f352916a.d(cancellableContinuationImpl, aVar, z16, new a(cancellableContinuationImpl));
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }
        String h16 = aVar.h();
        String uri = ((com.tencent.qqnt.avatar.meta.b) aVar).l().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "avatarBean.uri.toString()");
        return new com.tencent.qqnt.avatar.meta.info.a[]{new com.tencent.qqnt.avatar.meta.info.a(h16, uri, 0L, null, 12, null)};
    }

    public static /* synthetic */ Object g(AvatarInfoRequestManager avatarInfoRequestManager, com.tencent.qqnt.avatar.meta.a aVar, boolean z16, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return avatarInfoRequestManager.f(aVar, z16, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006d  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object f(@NotNull com.tencent.qqnt.avatar.meta.a aVar, boolean z16, @NotNull Continuation<? super com.tencent.qqnt.avatar.meta.info.a[]> continuation) {
        AvatarInfoRequestManager$getAvatarInfoArr$1 avatarInfoRequestManager$getAvatarInfoArr$1;
        Object coroutine_suspended;
        int i3;
        List<com.tencent.qqnt.avatar.meta.a> a16;
        com.tencent.qqnt.avatar.meta.a aVar2;
        Ref.BooleanRef booleanRef;
        com.tencent.qqnt.avatar.meta.info.a[] aVarArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, this, aVar, Boolean.valueOf(z16), continuation);
        }
        if (continuation instanceof AvatarInfoRequestManager$getAvatarInfoArr$1) {
            avatarInfoRequestManager$getAvatarInfoArr$1 = (AvatarInfoRequestManager$getAvatarInfoArr$1) continuation;
            int i16 = avatarInfoRequestManager$getAvatarInfoArr$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                avatarInfoRequestManager$getAvatarInfoArr$1.label = i16 - Integer.MIN_VALUE;
                AvatarInfoRequestManager$getAvatarInfoArr$1 avatarInfoRequestManager$getAvatarInfoArr$12 = avatarInfoRequestManager$getAvatarInfoArr$1;
                Object obj = avatarInfoRequestManager$getAvatarInfoArr$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = avatarInfoRequestManager$getAvatarInfoArr$12.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            aVarArr = (com.tencent.qqnt.avatar.meta.info.a[]) avatarInfoRequestManager$getAvatarInfoArr$12.L$2;
                            booleanRef = (Ref.BooleanRef) avatarInfoRequestManager$getAvatarInfoArr$12.L$1;
                            aVar2 = (com.tencent.qqnt.avatar.meta.a) avatarInfoRequestManager$getAvatarInfoArr$12.L$0;
                            ResultKt.throwOnFailure(obj);
                            if (!booleanRef.element) {
                                return null;
                            }
                            Intrinsics.checkNotNull(aVarArr, "null cannot be cast to non-null type kotlin.Array<com.tencent.qqnt.avatar.meta.info.AvatarInfo>");
                            AvatarInfoCache.f352688a.e(aVar2, aVarArr);
                            return aVarArr;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                ResultKt.throwOnFailure(obj);
                f c16 = c.f352932a.c();
                if (c16 == null || (a16 = c16.a(aVar)) == null) {
                    return null;
                }
                if (a16.isEmpty()) {
                    avatarInfoRequestManager$getAvatarInfoArr$12.label = 1;
                    obj = e(aVar, z16, avatarInfoRequestManager$getAvatarInfoArr$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return obj;
                }
                Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
                com.tencent.qqnt.avatar.meta.info.a[] aVarArr2 = new com.tencent.qqnt.avatar.meta.info.a[a16.size()];
                AvatarInfoRequestManager$getAvatarInfoArr$2 avatarInfoRequestManager$getAvatarInfoArr$2 = new AvatarInfoRequestManager$getAvatarInfoArr$2(a16, booleanRef2, aVar, aVarArr2, z16, null);
                avatarInfoRequestManager$getAvatarInfoArr$12.L$0 = aVar;
                avatarInfoRequestManager$getAvatarInfoArr$12.L$1 = booleanRef2;
                avatarInfoRequestManager$getAvatarInfoArr$12.L$2 = aVarArr2;
                avatarInfoRequestManager$getAvatarInfoArr$12.label = 2;
                if (CoroutineScopeKt.coroutineScope(avatarInfoRequestManager$getAvatarInfoArr$2, avatarInfoRequestManager$getAvatarInfoArr$12) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                aVar2 = aVar;
                booleanRef = booleanRef2;
                aVarArr = aVarArr2;
                if (!booleanRef.element) {
                }
            }
        }
        avatarInfoRequestManager$getAvatarInfoArr$1 = new AvatarInfoRequestManager$getAvatarInfoArr$1(this, continuation);
        AvatarInfoRequestManager$getAvatarInfoArr$1 avatarInfoRequestManager$getAvatarInfoArr$122 = avatarInfoRequestManager$getAvatarInfoArr$1;
        Object obj2 = avatarInfoRequestManager$getAvatarInfoArr$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = avatarInfoRequestManager$getAvatarInfoArr$122.label;
        if (i3 == 0) {
        }
    }

    @Nullable
    public final com.tencent.qqnt.avatar.meta.info.a[] h(@NotNull com.tencent.qqnt.avatar.meta.a avatarBean) {
        Map<String, Object>[] mapArr;
        e a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.qqnt.avatar.meta.info.a[]) iPatchRedirector.redirect((short) 3, (Object) this, (Object) avatarBean);
        }
        Intrinsics.checkNotNullParameter(avatarBean, "avatarBean");
        if ((avatarBean instanceof com.tencent.qqnt.avatar.meta.b) && ((com.tencent.qqnt.avatar.meta.b) avatarBean).l() != null) {
            String h16 = avatarBean.h();
            String uri = ((com.tencent.qqnt.avatar.meta.b) avatarBean).l().toString();
            Intrinsics.checkNotNullExpressionValue(uri, "avatarBean.uri.toString()");
            return new com.tencent.qqnt.avatar.meta.info.a[]{new com.tencent.qqnt.avatar.meta.info.a(h16, uri, 0L, null, 12, null)};
        }
        AvatarInfoCache avatarInfoCache = AvatarInfoCache.f352688a;
        com.tencent.qqnt.avatar.meta.info.a[] c16 = avatarInfoCache.c(avatarBean);
        if (c16 != null) {
            return c16;
        }
        c cVar = c.f352932a;
        d b16 = cVar.b();
        com.tencent.qqnt.avatar.meta.info.a[] aVarArr = null;
        if (b16 != null) {
            mapArr = b16.b(avatarBean);
        } else {
            mapArr = null;
        }
        if (mapArr != null && (a16 = cVar.a()) != null) {
            aVarArr = a16.a(avatarBean, mapArr);
        }
        if (aVarArr != null) {
            avatarInfoCache.e(avatarBean, aVarArr);
        }
        return aVarArr;
    }
}
