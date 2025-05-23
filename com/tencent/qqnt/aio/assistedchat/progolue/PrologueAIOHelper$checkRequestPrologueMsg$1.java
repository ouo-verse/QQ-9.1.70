package com.tencent.qqnt.aio.assistedchat.progolue;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.assistedchat.panel.subpanel.d;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.aio.assistedchat.progolue.PrologueAIOHelper$checkRequestPrologueMsg$1", f = "PrologueAIOHelper.kt", i = {}, l = {224, 226}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes23.dex */
public final class PrologueAIOHelper$checkRequestPrologueMsg$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    int label;
    final /* synthetic */ PrologueAIOHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.qqnt.aio.assistedchat.progolue.PrologueAIOHelper$checkRequestPrologueMsg$1$1", f = "PrologueAIOHelper.kt", i = {}, l = {233}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.qqnt.aio.assistedchat.progolue.PrologueAIOHelper$checkRequestPrologueMsg$1$1, reason: invalid class name */
    /* loaded from: classes23.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        static IPatchRedirector $redirector_;
        final /* synthetic */ d $result;
        int label;
        final /* synthetic */ PrologueAIOHelper this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
        @DebugMetadata(c = "com.tencent.qqnt.aio.assistedchat.progolue.PrologueAIOHelper$checkRequestPrologueMsg$1$1$1", f = "PrologueAIOHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.tencent.qqnt.aio.assistedchat.progolue.PrologueAIOHelper$checkRequestPrologueMsg$1$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes23.dex */
        public static final class C94611 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            static IPatchRedirector $redirector_;
            final /* synthetic */ Contact $contact;
            final /* synthetic */ d $result;
            int label;
            final /* synthetic */ PrologueAIOHelper this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C94611(PrologueAIOHelper prologueAIOHelper, Contact contact, d dVar, Continuation<? super C94611> continuation) {
                super(2, continuation);
                this.this$0 = prologueAIOHelper;
                this.$contact = contact;
                this.$result = dVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, prologueAIOHelper, contact, dVar, continuation);
                }
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
                }
                return new C94611(this.this$0, this.$contact, this.$result, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.this$0.k(this.$contact, this.$result);
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
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((C94611) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PrologueAIOHelper prologueAIOHelper, d dVar, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = prologueAIOHelper;
            this.$result = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, prologueAIOHelper, dVar, continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
            }
            return new AnonymousClass1(this.this$0, this.$result, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            boolean n3;
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
                    n3 = this.this$0.n();
                    if (n3) {
                        com.tencent.aio.main.businesshelper.b bVar = this.this$0.helperParam;
                        if (bVar == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("helperParam");
                            bVar = null;
                        }
                        int e16 = bVar.a().g().r().c().e();
                        com.tencent.aio.main.businesshelper.b bVar2 = this.this$0.helperParam;
                        if (bVar2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("helperParam");
                            bVar2 = null;
                        }
                        Contact contact = new Contact(e16, bVar2.a().g().r().c().j(), "");
                        CoroutineDispatcher io5 = Dispatchers.getIO();
                        C94611 c94611 = new C94611(this.this$0, contact, this.$result, null);
                        this.label = 1;
                        if (BuildersKt.withContext(io5, c94611, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (QLog.isDevelopLevel()) {
                        QLog.d("PrologueAIOHelper", 4, "onReceive server data, hasSendMsg.");
                    }
                }
                return Unit.INSTANCE;
            }
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrologueAIOHelper$checkRequestPrologueMsg$1(PrologueAIOHelper prologueAIOHelper, Continuation<? super PrologueAIOHelper$checkRequestPrologueMsg$1> continuation) {
        super(2, continuation);
        this.this$0 = prologueAIOHelper;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) prologueAIOHelper, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new PrologueAIOHelper$checkRequestPrologueMsg$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
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
                PrologueAIOHelper prologueAIOHelper = this.this$0;
                this.label = 1;
                obj = prologueAIOHelper.z(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            d dVar = (d) obj;
            if (dVar.i()) {
                if (dVar.a().length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    MainCoroutineDispatcher main = Dispatchers.getMain();
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, dVar, null);
                    this.label = 2;
                    if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
            }
            QLog.e("PrologueAIOHelper", 1, "requestPrologueData failed. success=" + dVar.i() + ", dataSize=" + dVar.a().length);
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((PrologueAIOHelper$checkRequestPrologueMsg$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
