package com.tencent.mobileqq.troop.troopblacklist;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopblacklist.view.adapter.TroopBlackListAdapter;
import com.tencent.mobileqq.troop.troopblacklist.viewmodel.TroopBlackListViewModel;
import com.tencent.mobileqq.troop.troopblacklist.viewmodel.a;
import com.tencent.qqnt.aio.at.widget.IndexBar;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.troopblacklist.TroopBlackListFragment$addIntentObserver$1", f = "TroopBlackListFragment.kt", i = {}, l = {217}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
public final class TroopBlackListFragment$addIntentObserver$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    int label;
    final /* synthetic */ TroopBlackListFragment this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements FlowCollector<com.tencent.mobileqq.troop.troopblacklist.viewmodel.a> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TroopBlackListFragment f299447d;

        public a(TroopBlackListFragment troopBlackListFragment) {
            this.f299447d = troopBlackListFragment;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopBlackListFragment);
            }
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(com.tencent.mobileqq.troop.troopblacklist.viewmodel.a aVar, @NotNull Continuation<? super Unit> continuation) {
            TroopBlackListViewModel Gh;
            QUIEmptyState Fh;
            IndexBar indexBar;
            TroopBlackListViewModel Gh2;
            QUIEmptyState Fh2;
            IndexBar indexBar2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar, (Object) continuation);
            }
            com.tencent.mobileqq.troop.troopblacklist.viewmodel.a aVar2 = aVar;
            TroopBlackListAdapter troopBlackListAdapter = null;
            IndexBar indexBar3 = null;
            TroopBlackListAdapter troopBlackListAdapter2 = null;
            TroopBlackListAdapter troopBlackListAdapter3 = null;
            if (aVar2 instanceof a.C8788a) {
                a.C8788a c8788a = (a.C8788a) aVar2;
                if (c8788a.b()) {
                    Fh2 = this.f299447d.Fh();
                    Fh2.setVisibility(0);
                    RecyclerView recyclerView = this.f299447d.recyclerView;
                    if (recyclerView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                        recyclerView = null;
                    }
                    recyclerView.setVisibility(8);
                    indexBar2 = this.f299447d.indexBar;
                    if (indexBar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("indexBar");
                    } else {
                        indexBar3 = indexBar2;
                    }
                    indexBar3.setVisibility(8);
                } else {
                    Fh = this.f299447d.Fh();
                    Fh.setVisibility(8);
                    RecyclerView recyclerView2 = this.f299447d.recyclerView;
                    if (recyclerView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                        recyclerView2 = null;
                    }
                    recyclerView2.setVisibility(0);
                    indexBar = this.f299447d.indexBar;
                    if (indexBar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("indexBar");
                        indexBar = null;
                    }
                    indexBar.setVisibility(0);
                    TroopBlackListAdapter troopBlackListAdapter4 = this.f299447d.adapter;
                    if (troopBlackListAdapter4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    } else {
                        troopBlackListAdapter2 = troopBlackListAdapter4;
                    }
                    troopBlackListAdapter2.p0(c8788a.a());
                }
                TroopBlackListFragment troopBlackListFragment = this.f299447d;
                Gh2 = troopBlackListFragment.Gh();
                troopBlackListFragment.Lh(Gh2.c2(), c8788a.b());
            } else if (aVar2 instanceof a.c) {
                this.f299447d.Ph(((a.c) aVar2).a());
                TroopBlackListAdapter troopBlackListAdapter5 = this.f299447d.adapter;
                if (troopBlackListAdapter5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                } else {
                    troopBlackListAdapter3 = troopBlackListAdapter5;
                }
                Gh = this.f299447d.Gh();
                troopBlackListAdapter3.o0(Gh.b2());
            } else if (aVar2 instanceof a.b) {
                a.b bVar = (a.b) aVar2;
                this.f299447d.Lh(bVar.b(), bVar.a());
                TroopBlackListAdapter troopBlackListAdapter6 = this.f299447d.adapter;
                if (troopBlackListAdapter6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                } else {
                    troopBlackListAdapter = troopBlackListAdapter6;
                }
                troopBlackListAdapter.r0(bVar.b());
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopBlackListFragment$addIntentObserver$1(TroopBlackListFragment troopBlackListFragment, Continuation<? super TroopBlackListFragment$addIntentObserver$1> continuation) {
        super(2, continuation);
        this.this$0 = troopBlackListFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopBlackListFragment, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new TroopBlackListFragment$addIntentObserver$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        TroopBlackListViewModel Gh;
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
                Gh = this.this$0.Gh();
                SharedFlow<com.tencent.mobileqq.troop.troopblacklist.viewmodel.a> W1 = Gh.W1();
                a aVar = new a(this.this$0);
                this.label = 1;
                if (W1.collect(aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((TroopBlackListFragment$addIntentObserver$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
