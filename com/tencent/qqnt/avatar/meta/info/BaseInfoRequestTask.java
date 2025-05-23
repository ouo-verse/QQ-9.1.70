package com.tencent.qqnt.avatar.meta.info;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.avatar.cache.AvatarInfoCache;
import com.tencent.qqnt.avatar.meta.info.BaseInfoRequestTask;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001d\rB)\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqnt/avatar/meta/info/BaseInfoRequestTask;", "Lcom/tencent/qqnt/avatar/meta/task/a;", "Lcom/tencent/qqnt/avatar/meta/task/b;", "result", "", "Lcom/tencent/qqnt/avatar/meta/info/a;", "g", "(Lcom/tencent/qqnt/avatar/meta/task/b;)[Lcom/tencent/qqnt/avatar/meta/info/a;", "Lwv3/a;", "listener", "c", "(Lwv3/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "b", "Lcom/tencent/qqnt/avatar/meta/a;", "Lcom/tencent/qqnt/avatar/meta/a;", "avatarBean", "Lcom/tencent/qqnt/avatar/meta/info/b;", "Lcom/tencent/qqnt/avatar/meta/info/b;", "callback", "", "d", "Z", "skipMemory", "", "key", "<init>", "(Ljava/lang/String;Lcom/tencent/qqnt/avatar/meta/a;Lcom/tencent/qqnt/avatar/meta/info/b;Z)V", "e", "a", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class BaseInfoRequestTask extends com.tencent.qqnt.avatar.meta.task.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final Lazy<Boolean> f352920f;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.avatar.meta.a avatarBean;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b callback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean skipMemory;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0014\u0010\u0015J)\u0010\b\u001a\u00020\u00072\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\fR \u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/avatar/meta/info/BaseInfoRequestTask$a;", "Lcom/tencent/qqnt/avatar/meta/info/g;", "", "", "", "", "mapArr", "", "a", "([Ljava/util/Map;)V", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/qqnt/avatar/meta/a;", "Ljava/lang/ref/WeakReference;", "avatarBeanRef", "Lkotlinx/coroutines/CancellableContinuation;", "Lcom/tencent/qqnt/avatar/meta/task/b;", "b", "continuationRef", "continuation", "avatarBean", "<init>", "(Lkotlinx/coroutines/CancellableContinuation;Lcom/tencent/qqnt/avatar/meta/a;)V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a implements g {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<com.tencent.qqnt.avatar.meta.a> avatarBeanRef;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<CancellableContinuation<com.tencent.qqnt.avatar.meta.task.b>> continuationRef;

        public a(@NotNull CancellableContinuation<? super com.tencent.qqnt.avatar.meta.task.b> continuation, @NotNull com.tencent.qqnt.avatar.meta.a avatarBean) {
            Intrinsics.checkNotNullParameter(continuation, "continuation");
            Intrinsics.checkNotNullParameter(avatarBean, "avatarBean");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) continuation, (Object) avatarBean);
            } else {
                this.avatarBeanRef = new WeakReference<>(avatarBean);
                this.continuationRef = new WeakReference<>(continuation);
            }
        }

        @Override // com.tencent.qqnt.avatar.meta.info.g
        public void a(@NotNull Map<String, Object>[] mapArr) {
            com.tencent.qqnt.avatar.meta.a aVar;
            com.tencent.qqnt.avatar.meta.info.a[] aVarArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) mapArr);
                return;
            }
            Intrinsics.checkNotNullParameter(mapArr, "mapArr");
            CancellableContinuation<com.tencent.qqnt.avatar.meta.task.b> cancellableContinuation = this.continuationRef.get();
            if (cancellableContinuation == null || (aVar = this.avatarBeanRef.get()) == null) {
                return;
            }
            boolean z16 = true;
            if (BaseInfoRequestTask.INSTANCE.b()) {
                com.tencent.qqnt.avatar.meta.task.b bVar = new com.tencent.qqnt.avatar.meta.task.b(true, mapArr);
                if (cancellableContinuation.isActive()) {
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(bVar));
                    return;
                } else {
                    com.tencent.qqnt.avatar.util.d.d(com.tencent.qqnt.avatar.util.d.f352991a, "BaseInfoRequestTask", "getAvatarInfo alreadyResumedError", null, 4, null);
                    return;
                }
            }
            e a16 = c.f352932a.a();
            if (a16 != null) {
                aVarArr = a16.a(aVar, mapArr);
            } else {
                aVarArr = null;
            }
            if (aVarArr != null) {
                AvatarInfoCache.f352688a.e(aVar, aVarArr);
            }
            if (aVarArr == null) {
                z16 = false;
            }
            com.tencent.qqnt.avatar.meta.task.b bVar2 = new com.tencent.qqnt.avatar.meta.task.b(z16, aVarArr);
            if (cancellableContinuation.isActive()) {
                cancellableContinuation.resumeWith(Result.m476constructorimpl(bVar2));
            } else {
                com.tencent.qqnt.avatar.util.d.d(com.tencent.qqnt.avatar.util.d.f352991a, "BaseInfoRequestTask", "getAvatarInfo alreadyResumedError", null, 4, null);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/avatar/meta/info/BaseInfoRequestTask$b;", "", "", "isBugfixSwitchOn$delegate", "Lkotlin/Lazy;", "b", "()Z", "isBugfixSwitchOn", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.avatar.meta.info.BaseInfoRequestTask$b, reason: from kotlin metadata */
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

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean b() {
            return ((Boolean) BaseInfoRequestTask.f352920f.getValue()).booleanValue();
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
        Lazy<Boolean> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40208);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(BaseInfoRequestTask$Companion$isBugfixSwitchOn$2.INSTANCE);
        f352920f = lazy;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseInfoRequestTask(@NotNull String key, @NotNull com.tencent.qqnt.avatar.meta.a avatarBean, @NotNull b callback, boolean z16) {
        super(key);
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(avatarBean, "avatarBean");
        Intrinsics.checkNotNullParameter(callback, "callback");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, key, avatarBean, callback, Boolean.valueOf(z16));
            return;
        }
        this.avatarBean = avatarBean;
        this.callback = callback;
        this.skipMemory = z16;
    }

    private final com.tencent.qqnt.avatar.meta.info.a[] g(com.tencent.qqnt.avatar.meta.task.b result) {
        Map<String, Object>[] mapArr;
        Object a16 = result.a();
        com.tencent.qqnt.avatar.meta.info.a[] aVarArr = null;
        if (a16 instanceof Map[]) {
            mapArr = (Map[]) a16;
        } else {
            mapArr = null;
        }
        if (mapArr == null) {
            return null;
        }
        e a17 = c.f352932a.a();
        if (a17 != null) {
            aVarArr = a17.a(this.avatarBean, mapArr);
        }
        if (aVarArr != null) {
            AvatarInfoCache.f352688a.e(this.avatarBean, aVarArr);
        }
        return aVarArr;
    }

    @Override // com.tencent.qqnt.avatar.meta.task.a
    public void b(@Nullable com.tencent.qqnt.avatar.meta.task.b result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) result);
            return;
        }
        com.tencent.qqnt.avatar.meta.info.a[] aVarArr = null;
        if (result == null) {
            this.callback.a(null);
            return;
        }
        if (result.a() instanceof Object[]) {
            if (INSTANCE.b()) {
                aVarArr = g(result);
            } else {
                Object a16 = result.a();
                if (a16 instanceof com.tencent.qqnt.avatar.meta.info.a[]) {
                    aVarArr = (com.tencent.qqnt.avatar.meta.info.a[]) a16;
                }
            }
            this.callback.a(aVarArr);
            return;
        }
        this.callback.a(null);
    }

    @Override // com.tencent.qqnt.avatar.meta.task.a
    @Nullable
    public Object c(@Nullable wv3.a aVar, @NotNull Continuation<? super com.tencent.qqnt.avatar.meta.task.b> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            final d b16 = c.f352932a.b();
            final a aVar2 = new a(cancellableContinuationImpl, this.avatarBean);
            if (b16 != null) {
                b16.c(this.avatarBean, this.skipMemory, aVar2);
            }
            cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>(this, aVar2) { // from class: com.tencent.qqnt.avatar.meta.info.BaseInfoRequestTask$start$2$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ BaseInfoRequestTask.a $callback;
                final /* synthetic */ BaseInfoRequestTask this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.this$0 = this;
                    this.$callback = aVar2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, d.this, this, aVar2);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                    invoke2(th5);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Throwable th5) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) th5);
                        return;
                    }
                    com.tencent.qqnt.avatar.util.d.f352991a.a("BaseInfoRequestTask", new Function0<String>() { // from class: com.tencent.qqnt.avatar.meta.info.BaseInfoRequestTask$start$2$1.1
                        static IPatchRedirector $redirector_;

                        {
                            super(0);
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) BaseInfoRequestTask.this);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @Nullable
                        public final String invoke() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                return (String) iPatchRedirector3.redirect((short) 2, (Object) this);
                            }
                            return "getAvatarInfo be canceled. worker: " + BaseInfoRequestTask.this.avatarBean.d();
                        }
                    });
                    d dVar = d.this;
                    if (dVar != null) {
                        dVar.d(this.this$0.avatarBean, this.$callback);
                    }
                }
            });
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }
        return iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar, (Object) continuation);
    }
}
