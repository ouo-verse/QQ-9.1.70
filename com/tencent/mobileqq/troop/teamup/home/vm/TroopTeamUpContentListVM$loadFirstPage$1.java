package com.tencent.mobileqq.troop.teamup.home.vm;

import androidx.lifecycle.ViewModelKt;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.teamup.home.data.TroopTeamUpData;
import com.tencent.mobileqq.troop.teamup.home.data.b;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.teamup.home.vm.TroopTeamUpContentListVM$loadFirstPage$1", f = "TroopTeamUpContentListVM.kt", i = {}, l = {91, 94}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
public final class TroopTeamUpContentListVM$loadFirstPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    int label;
    final /* synthetic */ TroopTeamUpContentListVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.troop.teamup.home.vm.TroopTeamUpContentListVM$loadFirstPage$1$1", f = "TroopTeamUpContentListVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.troop.teamup.home.vm.TroopTeamUpContentListVM$loadFirstPage$1$1, reason: invalid class name */
    /* loaded from: classes19.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        static IPatchRedirector $redirector_;
        final /* synthetic */ ArrayList<TroopTeamUpData> $newList;
        final /* synthetic */ b $rsp;
        int label;
        final /* synthetic */ TroopTeamUpContentListVM this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TroopTeamUpContentListVM troopTeamUpContentListVM, b bVar, ArrayList<TroopTeamUpData> arrayList, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = troopTeamUpContentListVM;
            this.$rsp = bVar;
            this.$newList = arrayList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, troopTeamUpContentListVM, bVar, arrayList, continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
            }
            return new AnonymousClass1(this.this$0, this.$rsp, this.$newList, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.hasMore = this.$rsp.c();
                    this.this$0.a2().setValue(this.$newList);
                    this.this$0.d2().setValue(Boxing.boxBoolean(false));
                    if (this.$rsp.e()) {
                        this.this$0.X1().postValue(Boxing.boxBoolean(this.$newList.isEmpty()));
                        this.this$0.Z1().postValue(Boxing.boxBoolean(false));
                        this.this$0.currentCookie = this.$rsp.a();
                    } else {
                        BaseApplication baseApplication = BaseApplication.context;
                        if (baseApplication != null) {
                            QQToast.makeText(baseApplication, this.$rsp.d(), 0).show();
                        }
                        this.this$0.Z1().postValue(Boxing.boxBoolean(true));
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
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopTeamUpContentListVM$loadFirstPage$1(TroopTeamUpContentListVM troopTeamUpContentListVM, Continuation<? super TroopTeamUpContentListVM$loadFirstPage$1> continuation) {
        super(2, continuation);
        this.this$0 = troopTeamUpContentListVM;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopTeamUpContentListVM, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new TroopTeamUpContentListVM$loadFirstPage$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        com.tencent.mobileqq.troop.teamup.home.repo.a aVar;
        int i3;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i16 = this.label;
            if (i16 != 0) {
                if (i16 != 1) {
                    if (i16 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                aVar = this.this$0.repo;
                long b26 = this.this$0.b2();
                i3 = this.this$0.type;
                CoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this.this$0);
                this.label = 1;
                obj = aVar.e(new byte[0], b26, i3, viewModelScope, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            b bVar = (b) obj;
            ArrayList<TroopTeamUpData> b16 = bVar.b();
            com.tencent.mobileqq.troop.teamup.home.common.a aVar2 = com.tencent.mobileqq.troop.teamup.home.common.a.f298968a;
            str = TroopTeamUpContentListVM.L;
            aVar2.a(str, "loadFirstPage return " + b16.size());
            MainCoroutineDispatcher main = Dispatchers.getMain();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, bVar, b16, null);
            this.label = 2;
            if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((TroopTeamUpContentListVM$loadFirstPage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
