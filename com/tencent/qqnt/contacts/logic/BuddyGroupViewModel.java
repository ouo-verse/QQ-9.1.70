package com.tencent.qqnt.contacts.logic;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.base.data.a;
import com.tencent.qqnt.base.mvi.BaseViewModel;
import com.tencent.qqnt.contacts.data.b;
import com.tencent.qqnt.contacts.data.c;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0003H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/contacts/logic/BuddyGroupViewModel;", "Lcom/tencent/qqnt/base/mvi/BaseViewModel;", "Lcom/tencent/qqnt/contacts/data/b;", "Lcom/tencent/qqnt/contacts/data/c;", "", "Q1", "N1", "userIntent", "P1", "Lcom/tencent/qqnt/contacts/data/repository/a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/contacts/data/repository/a;", "repository", "Lcom/tencent/qqnt/base/dispatcher/a;", "D", "Lcom/tencent/qqnt/base/dispatcher/a;", "dispatcher", "O1", "()Lcom/tencent/qqnt/contacts/data/c;", "mNoneValueIntent", "<init>", "(Lcom/tencent/qqnt/contacts/data/repository/a;Lcom/tencent/qqnt/base/dispatcher/a;)V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class BuddyGroupViewModel extends BaseViewModel<com.tencent.qqnt.contacts.data.b, com.tencent.qqnt.contacts.data.c> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.contacts.data.repository.a repository;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.base.dispatcher.a dispatcher;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"", "Lcom/tencent/qqnt/contacts/data/item/a;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.qqnt.contacts.logic.BuddyGroupViewModel$1", f = "BuddyGroupViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.qqnt.contacts.logic.BuddyGroupViewModel$1, reason: invalid class name */
    /* loaded from: classes24.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<List<? extends com.tencent.qqnt.contacts.data.item.a>, Continuation<? super Unit>, Object> {
        static IPatchRedirector $redirector_;
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BuddyGroupViewModel.this, (Object) continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
            }
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(List<? extends com.tencent.qqnt.contacts.data.item.a> list, Continuation<? super Unit> continuation) {
            return invoke2((List<com.tencent.qqnt.contacts.data.item.a>) list, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    BuddyGroupViewModel.this.getMUiState().setValue(new b.C9607b(new a.c((List) this.L$0)));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }

        @Nullable
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull List<com.tencent.qqnt.contacts.data.item.a> list, @Nullable Continuation<? super Unit> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass1) create(list, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) list, (Object) continuation);
        }
    }

    public BuddyGroupViewModel(@NotNull com.tencent.qqnt.contacts.data.repository.a repository, @NotNull com.tencent.qqnt.base.dispatcher.a dispatcher) {
        Flow onEach;
        Intrinsics.checkNotNullParameter(repository, "repository");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) repository, (Object) dispatcher);
            return;
        }
        this.repository = repository;
        this.dispatcher = dispatcher;
        Flow<List<com.tencent.qqnt.contacts.data.item.a>> b16 = repository.b();
        if (b16 != null && (onEach = FlowKt.onEach(b16, new AnonymousClass1(null))) != null) {
            FlowKt.launchIn(onEach, ViewModelKt.getViewModelScope(this));
        }
    }

    private final void N1() {
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(this.repository.a(), new BuddyGroupViewModel$fetchContactsList$1(this, null)), this.dispatcher.a()), ViewModelKt.getViewModelScope(this));
    }

    private final void Q1() {
        this.repository.c(new IOperateCallback() { // from class: com.tencent.qqnt.contacts.logic.a
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                BuddyGroupViewModel.R1(BuddyGroupViewModel.this, i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R1(BuddyGroupViewModel this$0, int i3, String errMsg) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("ContactsViewModel", 2, "refreshContactsList success!");
                return;
            }
            return;
        }
        MutableLiveData<com.tencent.qqnt.contacts.data.b> mUiState = this$0.getMUiState();
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        mUiState.setValue(new b.C9607b(new a.C9511a(errMsg)));
        QLog.d("ContactsViewModel", 1, "refreshContactsList fail! msg:" + errMsg);
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    @NotNull
    /* renamed from: O1, reason: merged with bridge method [inline-methods] */
    public com.tencent.qqnt.contacts.data.c getMNoneValueIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.contacts.data.c) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return c.C9608c.f355836a;
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    /* renamed from: P1, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull com.tencent.qqnt.contacts.data.c userIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) userIntent);
            return;
        }
        Intrinsics.checkNotNullParameter(userIntent, "userIntent");
        if (!Intrinsics.areEqual(userIntent, c.C9608c.f355836a)) {
            if (Intrinsics.areEqual(userIntent, c.a.f355834a)) {
                N1();
                return;
            }
            if (Intrinsics.areEqual(userIntent, c.d.f355837a)) {
                Q1();
                return;
            }
            if (userIntent instanceof c.b) {
                QLog.d("ContactsViewModel", 1, "fetchIcon for user:" + ((c.b) userIntent).a());
            }
        }
    }
}
