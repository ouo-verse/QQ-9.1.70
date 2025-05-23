package com.tencent.qqnt.troopmemberlist;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.troopmemberlist.TroopMemberListRepo$getTroopMemberSyncWithTimeout$1", f = "TroopMemberListRepo.kt", i = {}, l = {402}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes25.dex */
public final class TroopMemberListRepo$getTroopMemberSyncWithTimeout$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ String $from;
    final /* synthetic */ Ref.ObjectRef<TroopMemberInfo> $info;
    final /* synthetic */ String $memberUin;
    final /* synthetic */ LifecycleOwner $owner;
    final /* synthetic */ com.tencent.qqnt.report.k $report;
    final /* synthetic */ long $timeoutMs;
    final /* synthetic */ String $troopUin;
    final /* synthetic */ String $uniqueFrom;
    final /* synthetic */ boolean $withExt;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.qqnt.troopmemberlist.TroopMemberListRepo$getTroopMemberSyncWithTimeout$1$1", f = "TroopMemberListRepo.kt", i = {}, l = {gdt_analysis_event.EVENT_MOTIVE_HIPPY_LOAD_JS_BUNDLE_SUCCESS}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.qqnt.troopmemberlist.TroopMemberListRepo$getTroopMemberSyncWithTimeout$1$1, reason: invalid class name */
    /* loaded from: classes25.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super TroopMemberInfo>, Object> {
        static IPatchRedirector $redirector_;
        final /* synthetic */ String $from;
        final /* synthetic */ String $memberUin;
        final /* synthetic */ LifecycleOwner $owner;
        final /* synthetic */ com.tencent.qqnt.report.k $report;
        final /* synthetic */ long $timeoutMs;
        final /* synthetic */ String $troopUin;
        final /* synthetic */ String $uniqueFrom;
        final /* synthetic */ boolean $withExt;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z16, String str, String str2, LifecycleOwner lifecycleOwner, String str3, String str4, com.tencent.qqnt.report.k kVar, long j3, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$withExt = z16;
            this.$troopUin = str;
            this.$memberUin = str2;
            this.$owner = lifecycleOwner;
            this.$from = str3;
            this.$uniqueFrom = str4;
            this.$report = kVar;
            this.$timeoutMs = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), str, str2, lifecycleOwner, str3, str4, kVar, Long.valueOf(j3), continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
            }
            return new AnonymousClass1(this.$withExt, this.$troopUin, this.$memberUin, this.$owner, this.$from, this.$uniqueFrom, this.$report, this.$timeoutMs, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            Continuation intercepted;
            CancellableContinuationImpl cancellableContinuationImpl;
            Object coroutine_suspended2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i3 = this.label;
                if (i3 != 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                boolean z16 = this.$withExt;
                String str = this.$troopUin;
                String str2 = this.$memberUin;
                LifecycleOwner lifecycleOwner = this.$owner;
                String str3 = this.$from;
                final String str4 = this.$uniqueFrom;
                final com.tencent.qqnt.report.k kVar = this.$report;
                final long j3 = this.$timeoutMs;
                this.L$0 = str;
                this.L$1 = str2;
                this.L$2 = lifecycleOwner;
                this.L$3 = str3;
                this.L$4 = str4;
                this.L$5 = kVar;
                this.Z$0 = z16;
                this.J$0 = j3;
                this.label = 1;
                intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this);
                final CancellableContinuationImpl cancellableContinuationImpl2 = new CancellableContinuationImpl(intercepted, 1);
                cancellableContinuationImpl2.initCancellability();
                g gVar = new g(cancellableContinuationImpl2, str4, kVar) { // from class: com.tencent.qqnt.troopmemberlist.TroopMemberListRepo$getTroopMemberSyncWithTimeout$1$1$1$callback$1
                    static IPatchRedirector $redirector_;

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ CancellableContinuation<TroopMemberInfo> f362754a;

                    /* renamed from: b, reason: collision with root package name */
                    final /* synthetic */ String f362755b;

                    /* renamed from: c, reason: collision with root package name */
                    final /* synthetic */ com.tencent.qqnt.report.k f362756c;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        this.f362754a = cancellableContinuationImpl2;
                        this.f362755b = str4;
                        this.f362756c = kVar;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, cancellableContinuationImpl2, str4, kVar);
                        }
                    }

                    @Override // com.tencent.qqnt.troopmemberlist.g
                    public final void a(@Nullable TroopMemberInfo troopMemberInfo) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) troopMemberInfo);
                            return;
                        }
                        if (QLog.isDebugVersion()) {
                            QLog.d("TroopMemberListRepo", 4, "[getTroopMemberSyncWithTimeout] callback come, active:" + this.f362754a.isActive() + ", from:" + this.f362755b);
                        }
                        if (this.f362754a.isActive()) {
                            this.f362756c.b();
                            this.f362754a.resume(troopMemberInfo, AnonymousClass1.INSTANCE);
                        }
                    }
                };
                if (z16) {
                    cancellableContinuationImpl = cancellableContinuationImpl2;
                    TroopMemberListRepo.INSTANCE.fetchTroopMemberInfoWithExtInfo(str, str2, false, lifecycleOwner, str3, str4, gVar);
                } else {
                    cancellableContinuationImpl = cancellableContinuationImpl2;
                    TroopMemberListRepo.INSTANCE.fetchTroopMemberInfo(str, str2, false, lifecycleOwner, str3, str4, gVar);
                }
                cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>(j3, str4) { // from class: com.tencent.qqnt.troopmemberlist.TroopMemberListRepo$getTroopMemberSyncWithTimeout$1$1$1$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ long $timeoutMs;
                    final /* synthetic */ String $uniqueFrom;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        this.$timeoutMs = j3;
                        this.$uniqueFrom = str4;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, com.tencent.qqnt.report.k.this, Long.valueOf(j3), str4);
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
                        com.tencent.qqnt.report.k.this.q(this.$timeoutMs);
                        com.tencent.qqnt.report.k.this.b();
                        QLog.e("TroopMemberListRepo", 2, "[getTroopMemberSyncWithTimeout] timeout:" + this.$timeoutMs + ", from:" + this.$uniqueFrom);
                    }
                });
                Object result = cancellableContinuationImpl.getResult();
                coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (result == coroutine_suspended2) {
                    DebugProbes.probeCoroutineSuspended(this);
                }
                if (result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return result;
            }
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super TroopMemberInfo> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopMemberListRepo$getTroopMemberSyncWithTimeout$1(Ref.ObjectRef<TroopMemberInfo> objectRef, long j3, String str, boolean z16, String str2, String str3, LifecycleOwner lifecycleOwner, String str4, com.tencent.qqnt.report.k kVar, Continuation<? super TroopMemberListRepo$getTroopMemberSyncWithTimeout$1> continuation) {
        super(2, continuation);
        this.$info = objectRef;
        this.$timeoutMs = j3;
        this.$uniqueFrom = str;
        this.$withExt = z16;
        this.$troopUin = str2;
        this.$memberUin = str3;
        this.$owner = lifecycleOwner;
        this.$from = str4;
        this.$report = kVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, objectRef, Long.valueOf(j3), str, Boolean.valueOf(z16), str2, str3, lifecycleOwner, str4, kVar, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new TroopMemberListRepo$getTroopMemberSyncWithTimeout$1(this.$info, this.$timeoutMs, this.$uniqueFrom, this.$withExt, this.$troopUin, this.$memberUin, this.$owner, this.$from, this.$report, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Ref.ObjectRef<TroopMemberInfo> objectRef;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
        T t16 = obj;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                objectRef = (Ref.ObjectRef) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef<TroopMemberInfo> objectRef2 = this.$info;
            long j3 = this.$timeoutMs;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$withExt, this.$troopUin, this.$memberUin, this.$owner, this.$from, this.$uniqueFrom, this.$report, j3, null);
            this.L$0 = objectRef2;
            this.label = 1;
            Object withTimeoutOrNull = TimeoutKt.withTimeoutOrNull(j3, anonymousClass1, this);
            if (withTimeoutOrNull == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef2;
            t16 = withTimeoutOrNull;
        }
        objectRef.element = t16;
        if (QLog.isDebugVersion()) {
            QLog.d("TroopMemberListRepo", 4, "[getTroopMemberSyncWithTimeout] finish, from:" + this.$uniqueFrom);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((TroopMemberListRepo$getTroopMemberSyncWithTimeout$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
