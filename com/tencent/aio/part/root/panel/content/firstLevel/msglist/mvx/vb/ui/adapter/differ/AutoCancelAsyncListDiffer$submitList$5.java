package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.differ;

import androidx.recyclerview.widget.DiffUtil;
import com.tencent.aio.base.thread.DifferListDispatcher;
import com.tencent.aio.exception.AIOCancelException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.differ.AutoCancelAsyncListDiffer$submitList$5", f = "AutoCancelAsyncListDiffer.kt", i = {}, l = {240}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class AutoCancelAsyncListDiffer$submitList$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ e $callBack;
    final /* synthetic */ List $newList;
    final /* synthetic */ List $oldList;
    final /* synthetic */ int $runGeneration;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AutoCancelAsyncListDiffer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
    @DebugMetadata(c = "com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.differ.AutoCancelAsyncListDiffer$submitList$5$1", f = "AutoCancelAsyncListDiffer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.differ.AutoCancelAsyncListDiffer$submitList$5$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super DiffUtil.DiffResult>, Object> {
        static IPatchRedirector $redirector_;
        private /* synthetic */ Object L$0;
        int label;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\f\u00b8\u0006\u0000"}, d2 = {"com/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/differ/AutoCancelAsyncListDiffer$submitList$5$1$1$1", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "", "getOldListSize", "getNewListSize", "oldItemPosition", "newItemPosition", "", "areItemsTheSame", "areContentsTheSame", "", "getChangePayload", "sdk_debug"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.differ.AutoCancelAsyncListDiffer$submitList$5$1$a */
        /* loaded from: classes3.dex */
        public static final class a extends DiffUtil.Callback {
            static IPatchRedirector $redirector_;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ CoroutineScope f69650b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ Ref.ObjectRef f69651c;

            a(CoroutineScope coroutineScope, Ref.ObjectRef objectRef) {
                this.f69650b = coroutineScope;
                this.f69651c = objectRef;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, AnonymousClass1.this, coroutineScope, objectRef);
                }
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(oldItemPosition), Integer.valueOf(newItemPosition))).booleanValue();
                }
                CoroutineScopeKt.ensureActive(this.f69650b);
                Object obj = AutoCancelAsyncListDiffer$submitList$5.this.$oldList.get(oldItemPosition);
                Object obj2 = AutoCancelAsyncListDiffer$submitList$5.this.$newList.get(newItemPosition);
                if (obj != null && obj2 != null) {
                    return AutoCancelAsyncListDiffer$submitList$5.this.this$0.f().a().areContentsTheSame(obj, obj2);
                }
                if (obj == null && obj2 == null) {
                    return true;
                }
                throw new AssertionError();
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(oldItemPosition), Integer.valueOf(newItemPosition))).booleanValue();
                }
                CoroutineScopeKt.ensureActive(this.f69650b);
                Object obj = AutoCancelAsyncListDiffer$submitList$5.this.$oldList.get(oldItemPosition);
                Object obj2 = AutoCancelAsyncListDiffer$submitList$5.this.$newList.get(newItemPosition);
                if (obj != null && obj2 != null) {
                    return AutoCancelAsyncListDiffer$submitList$5.this.this$0.f().a().areItemsTheSame(obj, obj2);
                }
                if (obj == null && obj2 == null) {
                    return true;
                }
                return false;
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            @Nullable
            public Object getChangePayload(int oldItemPosition, int newItemPosition) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    return iPatchRedirector.redirect((short) 6, this, Integer.valueOf(oldItemPosition), Integer.valueOf(newItemPosition));
                }
                Object obj = AutoCancelAsyncListDiffer$submitList$5.this.$oldList.get(oldItemPosition);
                Object obj2 = AutoCancelAsyncListDiffer$submitList$5.this.$newList.get(newItemPosition);
                if (obj != null && obj2 != null) {
                    return AutoCancelAsyncListDiffer$submitList$5.this.this$0.f().a().getChangePayload(obj, obj2);
                }
                throw new AssertionError();
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getNewListSize() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
                }
                CoroutineScopeKt.ensureActive(this.f69650b);
                return AutoCancelAsyncListDiffer$submitList$5.this.$newList.size();
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getOldListSize() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
                }
                CoroutineScopeKt.ensureActive(this.f69650b);
                return AutoCancelAsyncListDiffer$submitList$5.this.$oldList.size();
            }
        }

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) AutoCancelAsyncListDiffer$submitList$5.this, (Object) continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) completion);
            }
            Intrinsics.checkNotNullParameter(completion, "completion");
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(completion);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super DiffUtil.DiffResult> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
            }
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v8, types: [T, androidx.recyclerview.widget.DiffUtil$DiffResult] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Deferred deferred;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    AutoCancelAsyncListDiffer$submitList$5.this.this$0.k("submit thread:");
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    objectRef.element = null;
                    try {
                        long currentTimeMillis = System.currentTimeMillis();
                        objectRef.element = DiffUtil.calculateDiff(new a(coroutineScope, objectRef));
                        long longValue = Boxing.boxLong(System.currentTimeMillis() - currentTimeMillis).longValue();
                        if (com.tencent.aio.base.a.f69150c.a()) {
                            com.tencent.aio.base.log.a.f69187b.d("AutoCancelAsyncListDiffer", "submit diff cost " + longValue + "  newList " + AutoCancelAsyncListDiffer$submitList$5.this.$newList.size());
                        }
                    } catch (AIOCancelException e16) {
                        if (com.tencent.aio.base.a.f69150c.a()) {
                            com.tencent.aio.base.log.a aVar = com.tencent.aio.base.log.a.f69187b;
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("cancel job ");
                            deferred = AutoCancelAsyncListDiffer$submitList$5.this.this$0.executeJob;
                            sb5.append(deferred);
                            sb5.append(" e ");
                            sb5.append(e16);
                            aVar.d("AutoCancelAsyncListDiffer", sb5.toString());
                        }
                    }
                    return (DiffUtil.DiffResult) objectRef.element;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return iPatchRedirector.redirect((short) 1, (Object) this, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoCancelAsyncListDiffer$submitList$5(AutoCancelAsyncListDiffer autoCancelAsyncListDiffer, List list, List list2, int i3, e eVar, Continuation continuation) {
        super(2, continuation);
        this.this$0 = autoCancelAsyncListDiffer;
        this.$oldList = list;
        this.$newList = list2;
        this.$runGeneration = i3;
        this.$callBack = eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, autoCancelAsyncListDiffer, list, list2, Integer.valueOf(i3), eVar, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) completion);
        }
        Intrinsics.checkNotNullParameter(completion, "completion");
        AutoCancelAsyncListDiffer$submitList$5 autoCancelAsyncListDiffer$submitList$5 = new AutoCancelAsyncListDiffer$submitList$5(this.this$0, this.$oldList, this.$newList, this.$runGeneration, this.$callBack, completion);
        autoCancelAsyncListDiffer$submitList$5.L$0 = obj;
        return autoCancelAsyncListDiffer$submitList$5;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
        }
        return ((AutoCancelAsyncListDiffer$submitList$5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Deferred async$default;
        Deferred deferred;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
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
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                AutoCancelAsyncListDiffer autoCancelAsyncListDiffer = this.this$0;
                async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, DifferListDispatcher.f69210f.plus(new CoroutineName("diffData")), null, new AnonymousClass1(null), 2, null);
                autoCancelAsyncListDiffer.executeJob = async$default;
                deferred = this.this$0.executeJob;
                if (deferred != null) {
                    this.label = 1;
                    obj = deferred.await(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    obj = null;
                }
            }
            if (com.tencent.aio.base.a.f69150c.a()) {
                com.tencent.aio.base.log.a.f69187b.d("AutoCancelAsyncListDiffer", " mMaxScheduledGeneration " + this.this$0.g() + "  runGeneration " + this.$runGeneration);
            }
            if (this.this$0.g() == this.$runGeneration) {
                AutoCancelAsyncListDiffer autoCancelAsyncListDiffer2 = this.this$0;
                List list = this.$newList;
                if (obj != null) {
                    autoCancelAsyncListDiffer2.h(list, (DiffUtil.DiffResult) obj, this.$callBack);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.DiffUtil.DiffResult");
                }
            }
            this.this$0.executeJob = null;
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 1, (Object) this, obj);
    }
}
