package com.tencent.mobileqq.sharepanel.multiSelect;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.sharepanel.d;
import com.tencent.mobileqq.sharepanel.model.ShareConfirmAction;
import com.tencent.mobileqq.sharepanel.model.SharePanelContactItem;
import com.tencent.mobileqq.sharepanel.p;
import com.tencent.mobileqq.sharepanel.part.i;
import com.tencent.mobileqq.sharepanel.util.ShareConfirmUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.sharepanel.multiSelect.MultiSelectContactPart$directForwardToGuild$1", f = "MultiSelectContactPart.kt", i = {0, 1}, l = {224, 235, 241}, m = "invokeSuspend", n = {"target", "hasIntercept"}, s = {"L$0", "L$0"})
/* loaded from: classes18.dex */
final class MultiSelectContactPart$directForwardToGuild$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ SharePanelContactItem $contact;
    Object L$0;
    int label;
    final /* synthetic */ MultiSelectContactPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.sharepanel.multiSelect.MultiSelectContactPart$directForwardToGuild$1$1", f = "MultiSelectContactPart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.sharepanel.multiSelect.MultiSelectContactPart$directForwardToGuild$1$1, reason: invalid class name */
    /* loaded from: classes18.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        static IPatchRedirector $redirector_;
        final /* synthetic */ Ref.BooleanRef $hasIntercept;
        final /* synthetic */ ResultRecord $target;
        int label;
        final /* synthetic */ MultiSelectContactPart this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Ref.BooleanRef booleanRef, MultiSelectContactPart multiSelectContactPart, ResultRecord resultRecord, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$hasIntercept = booleanRef;
            this.this$0 = multiSelectContactPart;
            this.$target = resultRecord;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, booleanRef, multiSelectContactPart, resultRecord, continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
            }
            return new AnonymousClass1(this.$hasIntercept, this.this$0, this.$target, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            List<? extends ResultRecord> listOf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref.BooleanRef booleanRef = this.$hasIntercept;
                    d g16 = this.this$0.F9().g();
                    boolean z16 = false;
                    if (g16 != null) {
                        listOf = CollectionsKt__CollectionsJVMKt.listOf(this.$target);
                        if (g16.J(listOf, "")) {
                            z16 = true;
                        }
                    }
                    booleanRef.element = z16;
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
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.sharepanel.multiSelect.MultiSelectContactPart$directForwardToGuild$1$2", f = "MultiSelectContactPart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.sharepanel.multiSelect.MultiSelectContactPart$directForwardToGuild$1$2, reason: invalid class name */
    /* loaded from: classes18.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        static IPatchRedirector $redirector_;
        final /* synthetic */ SharePanelContactItem $contact;
        final /* synthetic */ Ref.BooleanRef $hasIntercept;
        int label;
        final /* synthetic */ MultiSelectContactPart this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Ref.BooleanRef booleanRef, MultiSelectContactPart multiSelectContactPart, SharePanelContactItem sharePanelContactItem, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$hasIntercept = booleanRef;
            this.this$0 = multiSelectContactPart;
            this.$contact = sharePanelContactItem;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, booleanRef, multiSelectContactPart, sharePanelContactItem, continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
            }
            return new AnonymousClass2(this.$hasIntercept, this.this$0, this.$contact, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (this.$hasIntercept.element) {
                        QLog.d("MultiSelectContactPart", 1, "directForward hasIntercept");
                        this.this$0.E9();
                    } else {
                        com.tencent.mobileqq.sharepanel.channel.a v3 = this.this$0.F9().v();
                        if (v3 != null) {
                            v3.a(this.this$0.F9(), "directForward", this.$contact, null);
                        }
                        i.C9(this.this$0, null, 1, null);
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
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiSelectContactPart$directForwardToGuild$1(SharePanelContactItem sharePanelContactItem, MultiSelectContactPart multiSelectContactPart, Continuation<? super MultiSelectContactPart$directForwardToGuild$1> continuation) {
        super(2, continuation);
        this.$contact = sharePanelContactItem;
        this.this$0 = multiSelectContactPart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, sharePanelContactItem, multiSelectContactPart, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new MultiSelectContactPart$directForwardToGuild$1(this.$contact, this.this$0, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00d5 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        ResultRecord resultRecord;
        ArrayList arrayListOf;
        Ref.BooleanRef booleanRef;
        Ref.BooleanRef booleanRef2;
        MainCoroutineDispatcher main;
        AnonymousClass2 anonymousClass2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    booleanRef2 = (Ref.BooleanRef) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    booleanRef = booleanRef2;
                    main = Dispatchers.getMain();
                    anonymousClass2 = new AnonymousClass2(booleanRef, this.this$0, this.$contact, null);
                    this.L$0 = null;
                    this.label = 3;
                    if (BuildersKt.withContext(main, anonymousClass2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                resultRecord = (ResultRecord) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                resultRecord = new ResultRecord(this.$contact.e(), this.$contact.b(), this.$contact.f(), this.$contact.a());
                ShareConfirmUtil shareConfirmUtil = ShareConfirmUtil.f287597a;
                p x16 = this.this$0.F9().x();
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(resultRecord);
                ShareConfirmAction.Forward forward = new ShareConfirmAction.Forward(arrayListOf);
                this.L$0 = resultRecord;
                this.label = 1;
                obj = shareConfirmUtil.a(x16, forward, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            if (!((Boolean) obj).booleanValue()) {
                QLog.d("MultiSelectContactPart", 1, "directForward share confirm rejected");
                return Unit.INSTANCE;
            }
            booleanRef = new Ref.BooleanRef();
            if (this.$contact.g()) {
                CoroutineDispatcher io5 = Dispatchers.getIO();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(booleanRef, this.this$0, resultRecord, null);
                this.L$0 = booleanRef;
                this.label = 2;
                if (BuildersKt.withContext(io5, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                booleanRef2 = booleanRef;
                booleanRef = booleanRef2;
            }
            main = Dispatchers.getMain();
            anonymousClass2 = new AnonymousClass2(booleanRef, this.this$0, this.$contact, null);
            this.L$0 = null;
            this.label = 3;
            if (BuildersKt.withContext(main, anonymousClass2, this) == coroutine_suspended) {
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((MultiSelectContactPart$directForwardToGuild$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
