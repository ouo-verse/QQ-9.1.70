package com.tencent.qqnt.contacts.logic;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.base.data.a;
import com.tencent.qqnt.base.mvi.BaseViewModel;
import com.tencent.qqnt.contacts.data.f;
import com.tencent.qqnt.contacts.data.h;
import com.tencent.qqnt.contacts.data.i;
import com.tencent.qqnt.contacts.data.repository.GroupListRepository;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001cB\u0017\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0003H\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0018\u001a\u00020\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/contacts/logic/GroupListViewModel;", "Lcom/tencent/qqnt/base/mvi/BaseViewModel;", "Lcom/tencent/qqnt/contacts/data/h;", "Lcom/tencent/qqnt/contacts/data/i;", "", "N1", "R1", "", "groupCode", "O1", "userIntent", "Q1", "Lcom/tencent/qqnt/contacts/data/repository/GroupListRepository;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/contacts/data/repository/GroupListRepository;", "repository", "Lcom/tencent/qqnt/base/dispatcher/a;", "D", "Lcom/tencent/qqnt/base/dispatcher/a;", "dispatchers", "E", "Lcom/tencent/qqnt/contacts/data/i;", "P1", "()Lcom/tencent/qqnt/contacts/data/i;", "mNoneValueIntent", "<init>", "(Lcom/tencent/qqnt/contacts/data/repository/GroupListRepository;Lcom/tencent/qqnt/base/dispatcher/a;)V", UserInfo.SEX_FEMALE, "a", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class GroupListViewModel extends BaseViewModel<h, i> {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final GroupListRepository repository;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.base.dispatcher.a dispatchers;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final i mNoneValueIntent;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"", "Lcom/tencent/qqnt/contacts/data/f;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.qqnt.contacts.logic.GroupListViewModel$1", f = "GroupListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.qqnt.contacts.logic.GroupListViewModel$1, reason: invalid class name */
    /* loaded from: classes24.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<List<? extends f>, Continuation<? super Unit>, Object> {
        static IPatchRedirector $redirector_;
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GroupListViewModel.this, (Object) continuation);
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

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    GroupListViewModel.this.getMUiState().setValue(new h.c(new a.c((List) this.L$0)));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull List<? extends f> list, @Nullable Continuation<? super Unit> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass1) create(list, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) list, (Object) continuation);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"", "Lcom/tencent/qqnt/contacts/data/f;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.qqnt.contacts.logic.GroupListViewModel$2", f = "GroupListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.qqnt.contacts.logic.GroupListViewModel$2, reason: invalid class name */
    /* loaded from: classes24.dex */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<List<? extends f>, Continuation<? super Unit>, Object> {
        static IPatchRedirector $redirector_;
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GroupListViewModel.this, (Object) continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
            }
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    GroupListViewModel.this.getMUiState().setValue(new h.b((List) this.L$0));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull List<? extends f> list, @Nullable Continuation<? super Unit> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass2) create(list, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) list, (Object) continuation);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/contacts/logic/GroupListViewModel$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.contacts.logic.GroupListViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35910);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public GroupListViewModel(@NotNull GroupListRepository repository, @NotNull com.tencent.qqnt.base.dispatcher.a dispatchers) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) repository, (Object) dispatchers);
            return;
        }
        this.repository = repository;
        this.dispatchers = dispatchers;
        this.mNoneValueIntent = i.c.f355865a;
        FlowKt.launchIn(FlowKt.onEach(repository.e(), new AnonymousClass1(null)), ViewModelKt.getViewModelScope(this));
        FlowKt.launchIn(FlowKt.onEach(repository.f(), new AnonymousClass2(null)), ViewModelKt.getViewModelScope(this));
    }

    private final void N1() {
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(this.repository.c(), new GroupListViewModel$fetchGroupList$1(this, null)), this.dispatchers.a()), ViewModelKt.getViewModelScope(this));
    }

    private final void O1(long groupCode) {
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(this.repository.d(groupCode), new GroupListViewModel$fetchGroupMemberList$1(this, null)), this.dispatchers.a()), ViewModelKt.getViewModelScope(this));
    }

    private final void R1() {
        this.repository.g(new IOperateCallback() { // from class: com.tencent.qqnt.contacts.logic.c
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                GroupListViewModel.S1(GroupListViewModel.this, i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S1(GroupListViewModel this$0, int i3, String errMsg) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("ContactsViewModel", 2, "refreshGroupList success!");
                return;
            }
            return;
        }
        MutableLiveData<h> mUiState = this$0.getMUiState();
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        mUiState.setValue(new h.c(new a.C9511a(errMsg)));
        QLog.d("GroupListViewModel", 1, "refreshGroupList fail! msg:" + errMsg);
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    @NotNull
    /* renamed from: P1, reason: merged with bridge method [inline-methods] */
    public i getMNoneValueIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (i) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mNoneValueIntent;
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    /* renamed from: Q1, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull i userIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) userIntent);
            return;
        }
        Intrinsics.checkNotNullParameter(userIntent, "userIntent");
        if (!Intrinsics.areEqual(userIntent, i.c.f355865a)) {
            if (Intrinsics.areEqual(userIntent, i.a.f355863a)) {
                N1();
            } else if (Intrinsics.areEqual(userIntent, i.d.f355866a)) {
                R1();
            } else if (userIntent instanceof i.b) {
                O1(((i.b) userIntent).a());
            }
        }
    }
}
