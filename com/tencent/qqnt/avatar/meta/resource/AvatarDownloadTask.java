package com.tencent.qqnt.avatar.meta.resource;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.avatar.disklrucache.a;
import com.tencent.qqnt.avatar.util.d;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0001\u0019B%\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u0012\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\tH\u0016R\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0010R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/avatar/meta/resource/AvatarDownloadTask;", "Lcom/tencent/qqnt/avatar/meta/task/a;", "Ljava/io/File;", "file", "", "d", "(Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lwv3/a;", "listener", "Lcom/tencent/qqnt/avatar/meta/task/b;", "c", "(Lwv3/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "result", "", "b", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "callback", "", "key", "<init>", "(Ljava/lang/String;Landroid/content/Context;Lkotlin/jvm/functions/Function0;)V", "a", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AvatarDownloadTask extends com.tencent.qqnt.avatar.meta.task.a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Unit> callback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/avatar/meta/resource/AvatarDownloadTask$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.avatar.meta.resource.AvatarDownloadTask$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/avatar/meta/resource/AvatarDownloadTask$b", "Lcom/tencent/qqnt/avatar/meta/resource/a;", "", "success", "", "a", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Boolean> f352953a;

        /* JADX WARN: Multi-variable type inference failed */
        b(CancellableContinuation<? super Boolean> cancellableContinuation) {
            this.f352953a = cancellableContinuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cancellableContinuation);
            }
        }

        @Override // com.tencent.qqnt.avatar.meta.resource.a
        public void a(boolean success) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, success);
                return;
            }
            try {
                CancellableContinuation<Boolean> cancellableContinuation = this.f352953a;
                Boolean valueOf = Boolean.valueOf(success);
                if (cancellableContinuation.isActive()) {
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(valueOf));
                } else {
                    d.d(d.f352991a, "AvatarDownloadTask", "downloadFile already resumed", null, 4, null);
                }
            } catch (Exception unused) {
                d.d(d.f352991a, "AvatarDownloadTask", "downloadFinish already resumed", null, 4, null);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40307);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarDownloadTask(@NotNull String key, @NotNull Context context, @NotNull Function0<Unit> callback) {
        super(key);
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, key, context, callback);
        } else {
            this.context = context;
            this.callback = callback;
        }
    }

    private final Object d(File file, Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        com.tencent.qqnt.avatar.meta.resource.b i3 = AvatarResourceManager.f352954a.i();
        if (i3 != null) {
            i3.c(a(), file, new b(cancellableContinuationImpl));
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Override // com.tencent.qqnt.avatar.meta.task.a
    public void b(@Nullable com.tencent.qqnt.avatar.meta.task.b result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) result);
            return;
        }
        boolean z16 = false;
        if (result != null && true == result.b()) {
            z16 = true;
        }
        if (!z16) {
            d.d(d.f352991a, "AvatarDownloadTask", "download failed :" + a(), null, 4, null);
        }
        this.callback.invoke();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:8|(2:10|(8:12|13|14|(1:(3:17|18|19)(2:61|62))(5:63|64|65|(2:67|(1:69)(1:70))|(5:72|73|74|(1:76)|78)(2:81|(1:83)(1:84)))|20|(1:22)(1:45)|23|(7:25|(1:27)|28|30|31|(1:33)|35)(5:38|(1:40)|41|42|43)))|91|13|14|(0)(0)|20|(0)(0)|23|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0117, code lost:
    
        r14 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0118, code lost:
    
        com.tencent.qqnt.avatar.util.d.f352991a.c("AvatarDownloadTask", "abortUnlessCommitted error:", r14);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ee A[Catch: all -> 0x004a, Exception -> 0x004d, TryCatch #0 {Exception -> 0x004d, blocks: (B:19:0x0045, B:20:0x00bd, B:23:0x00d1, B:25:0x00ee, B:27:0x00f4, B:28:0x00f7), top: B:18:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x010d A[Catch: Exception -> 0x0117, TRY_ENTER, TryCatch #1 {Exception -> 0x0117, blocks: (B:38:0x010d, B:40:0x0113, B:48:0x012b, B:50:0x0131), top: B:14:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0131 A[Catch: Exception -> 0x0117, TRY_LEAVE, TryCatch #1 {Exception -> 0x0117, blocks: (B:38:0x010d, B:40:0x0113, B:48:0x012b, B:50:0x0131), top: B:14:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0140 A[Catch: Exception -> 0x0144, TRY_LEAVE, TryCatch #5 {Exception -> 0x0144, blocks: (B:54:0x013a, B:56:0x0140), top: B:53:0x013a }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0059  */
    /* JADX WARN: Type inference failed for: r1v6, types: [T, com.tencent.qqnt.avatar.disklrucache.a$c] */
    @Override // com.tencent.qqnt.avatar.meta.task.a
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object c(@Nullable wv3.a aVar, @NotNull Continuation<? super com.tencent.qqnt.avatar.meta.task.b> continuation) {
        AvatarDownloadTask$start$1 avatarDownloadTask$start$1;
        Object coroutine_suspended;
        int i3;
        Ref.ObjectRef objectRef;
        AvatarDownloadTask avatarDownloadTask;
        a.c cVar;
        a.c cVar2;
        boolean booleanValue;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar, (Object) continuation);
        }
        if (continuation instanceof AvatarDownloadTask$start$1) {
            avatarDownloadTask$start$1 = (AvatarDownloadTask$start$1) continuation;
            int i16 = avatarDownloadTask$start$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                avatarDownloadTask$start$1.label = i16 - Integer.MIN_VALUE;
                Object obj = avatarDownloadTask$start$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = avatarDownloadTask$start$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        objectRef = (Ref.ObjectRef) avatarDownloadTask$start$1.L$1;
                        avatarDownloadTask = (AvatarDownloadTask) avatarDownloadTask$start$1.L$0;
                        try {
                            try {
                                ResultKt.throwOnFailure(obj);
                            } catch (Throwable th5) {
                                th = th5;
                                try {
                                    cVar = (a.c) objectRef.element;
                                    if (cVar != null) {
                                        cVar.d();
                                    }
                                } catch (Exception e16) {
                                    d.f352991a.c("AvatarDownloadTask", "abortUnlessCommitted error:", e16);
                                }
                                throw th;
                            }
                        } catch (Exception e17) {
                            e = e17;
                            d.f352991a.c("AvatarDownloadTask", "put to disk cache error:", e);
                            cVar2 = (a.c) objectRef.element;
                            if (cVar2 != null) {
                                cVar2.d();
                            }
                            return new com.tencent.qqnt.avatar.meta.task.b(false, null);
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    try {
                        File g16 = AvatarResourceManager.f352954a.g(a());
                        if (g16 == null) {
                            ?? d16 = com.tencent.qqnt.avatar.cache.b.INSTANCE.a(this.context).d(a());
                            objectRef2.element = d16;
                            if (d16 != 0) {
                                g16 = d16.f(0);
                            } else {
                                g16 = null;
                            }
                        }
                        if (g16 == null) {
                            d.d(d.f352991a, "AvatarDownloadTask", "file is null", null, 4, null);
                            com.tencent.qqnt.avatar.meta.task.b bVar = new com.tencent.qqnt.avatar.meta.task.b(false, null);
                            try {
                                a.c cVar3 = (a.c) objectRef2.element;
                                if (cVar3 != null) {
                                    cVar3.d();
                                }
                            } catch (Exception e18) {
                                d.f352991a.c("AvatarDownloadTask", "abortUnlessCommitted error:", e18);
                            }
                            return bVar;
                        }
                        avatarDownloadTask$start$1.L$0 = this;
                        avatarDownloadTask$start$1.L$1 = objectRef2;
                        avatarDownloadTask$start$1.label = 1;
                        Object d17 = d(g16, avatarDownloadTask$start$1);
                        if (d17 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        objectRef = objectRef2;
                        obj = d17;
                        avatarDownloadTask = this;
                    } catch (Exception e19) {
                        e = e19;
                        objectRef = objectRef2;
                        d.f352991a.c("AvatarDownloadTask", "put to disk cache error:", e);
                        cVar2 = (a.c) objectRef.element;
                        if (cVar2 != null) {
                        }
                        return new com.tencent.qqnt.avatar.meta.task.b(false, null);
                    } catch (Throwable th6) {
                        th = th6;
                        objectRef = objectRef2;
                        cVar = (a.c) objectRef.element;
                        if (cVar != null) {
                        }
                        throw th;
                    }
                }
                booleanValue = ((Boolean) obj).booleanValue();
                d dVar = d.f352991a;
                String a16 = avatarDownloadTask.a();
                if (!booleanValue) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                d.d(dVar, "AvatarDownloadTask", a16 + " download success:" + z16, null, 4, null);
                if (!booleanValue) {
                    a.c cVar4 = (a.c) objectRef.element;
                    if (cVar4 != null) {
                        cVar4.e();
                    }
                    com.tencent.qqnt.avatar.meta.task.b bVar2 = new com.tencent.qqnt.avatar.meta.task.b(true, null);
                    try {
                        a.c cVar5 = (a.c) objectRef.element;
                        if (cVar5 != null) {
                            cVar5.d();
                        }
                    } catch (Exception e26) {
                        d.f352991a.c("AvatarDownloadTask", "abortUnlessCommitted error:", e26);
                    }
                    return bVar2;
                }
                a.c cVar6 = (a.c) objectRef.element;
                if (cVar6 != null) {
                    cVar6.d();
                }
                return new com.tencent.qqnt.avatar.meta.task.b(false, null);
            }
        }
        avatarDownloadTask$start$1 = new AvatarDownloadTask$start$1(this, continuation);
        Object obj2 = avatarDownloadTask$start$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = avatarDownloadTask$start$1.label;
        if (i3 == 0) {
        }
        booleanValue = ((Boolean) obj2).booleanValue();
        d dVar2 = d.f352991a;
        String a162 = avatarDownloadTask.a();
        if (!booleanValue) {
        }
        d.d(dVar2, "AvatarDownloadTask", a162 + " download success:" + z16, null, 4, null);
        if (!booleanValue) {
        }
    }
}
