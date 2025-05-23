package com.tencent.qqnt.chathistory.ui.media.viewmodel;

import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.chathistory.ui.base.BaseHistoryViewModel;
import com.tencent.qqnt.chathistory.ui.media.data.a;
import com.tencent.qqnt.chathistory.ui.media.data.b;
import com.tencent.qqnt.chathistory.ui.media.data.datasource.PlatformSearchMediaSource;
import com.tencent.qqnt.chathistory.util.d;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaElementGetReq;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J(\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0003H\u0016R\u001b\u0010\u0018\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/media/viewmodel/ChatHistoryMediaViewModel;", "Lcom/tencent/qqnt/chathistory/ui/base/BaseHistoryViewModel;", "Lcom/tencent/qqnt/chathistory/ui/media/data/a;", "Lcom/tencent/qqnt/chathistory/ui/media/data/b;", "", "pageCount", "", "X1", "", "msgId", "msgTime", "msgSeq", "requestCount", "Z1", "Lcom/tencent/qqnt/chathistory/ui/media/data/b$a;", "intent", "S1", "userIntent", "W1", "Lcom/tencent/qqnt/chathistory/ui/media/data/datasource/PlatformSearchMediaSource;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "T1", "()Lcom/tencent/qqnt/chathistory/ui/media/data/datasource/PlatformSearchMediaSource;", "dataSource", "U1", "()Lcom/tencent/qqnt/chathistory/ui/media/data/b;", "mNoneValueIntent", "<init>", "()V", "G", "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ChatHistoryMediaViewModel extends BaseHistoryViewModel<a, b> {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy dataSource;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.qqnt.chathistory.ui.media.viewmodel.ChatHistoryMediaViewModel$1", f = "ChatHistoryMediaViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.qqnt.chathistory.ui.media.viewmodel.ChatHistoryMediaViewModel$1, reason: invalid class name */
    /* loaded from: classes23.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FileTransNotifyInfo, Continuation<? super Unit>, Object> {
        static IPatchRedirector $redirector_;
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryMediaViewModel.this, (Object) continuation);
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
        @Nullable
        public final Object invoke(@NotNull FileTransNotifyInfo fileTransNotifyInfo, @Nullable Continuation<? super Unit> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass1) create(fileTransNotifyInfo, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) fileTransNotifyInfo, (Object) continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    FileTransNotifyInfo fileTransNotifyInfo = (FileTransNotifyInfo) this.L$0;
                    d.f354054a.a("ChatHistoryMediaViewModel", " downLoad complete " + fileTransNotifyInfo);
                    ChatHistoryMediaViewModel.this.getMUiState().setValue(new a.C9542a(fileTransNotifyInfo));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/media/viewmodel/ChatHistoryMediaViewModel$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chathistory.ui.media.viewmodel.ChatHistoryMediaViewModel$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48625);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ChatHistoryMediaViewModel() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        FlowKt.launchIn(FlowKt.onEach(com.tencent.qqnt.chathistory.service.d.d(), new AnonymousClass1(null)), ViewModelKt.getViewModelScope(this));
        lazy = LazyKt__LazyJVMKt.lazy(ChatHistoryMediaViewModel$dataSource$2.INSTANCE);
        this.dataSource = lazy;
    }

    private final void S1(b.a intent) {
        d.f354054a.a("ChatHistoryMediaViewModel", " dowLoadMedia " + intent.a() + "  peerId " + N1() + "  chatType " + M1());
        RichMediaElementGetReq richMediaElementGetReq = new RichMediaElementGetReq();
        richMediaElementGetReq.msgId = intent.a().b();
        richMediaElementGetReq.peerUid = N1();
        richMediaElementGetReq.chatType = M1();
        richMediaElementGetReq.elementId = intent.a().a();
        richMediaElementGetReq.downloadType = intent.a().c().a();
        richMediaElementGetReq.thumbSize = intent.a().c().b();
        richMediaElementGetReq.downSourceType = 3;
        richMediaElementGetReq.triggerType = 1;
        com.tencent.qqnt.chathistory.service.d.b(richMediaElementGetReq);
    }

    private final PlatformSearchMediaSource T1() {
        return (PlatformSearchMediaSource) this.dataSource.getValue();
    }

    private final void X1(int pageCount) {
        FlowKt.launchIn(FlowKt.onEach(T1().b(M1(), N1(), pageCount), new ChatHistoryMediaViewModel$loadFirstPageMedia$1(this, pageCount, null)), ViewModelKt.getViewModelScope(this));
    }

    private final void Z1(long msgId, long msgTime, long msgSeq, int requestCount) {
        FlowKt.launchIn(FlowKt.onEach(T1().c(M1(), N1(), msgId, msgTime, msgSeq, requestCount), new ChatHistoryMediaViewModel$loadMoreMedia$1(this, requestCount, null)), ViewModelKt.getViewModelScope(this));
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    @NotNull
    /* renamed from: U1, reason: merged with bridge method [inline-methods] */
    public b getMNoneValueIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return b.d.f353781a;
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    /* renamed from: W1, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull b userIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) userIntent);
            return;
        }
        Intrinsics.checkNotNullParameter(userIntent, "userIntent");
        if (userIntent instanceof b.C9543b) {
            X1(((b.C9543b) userIntent).a());
        }
        if (userIntent instanceof b.a) {
            S1((b.a) userIntent);
        }
        if (userIntent instanceof b.c) {
            b.c cVar = (b.c) userIntent;
            Z1(cVar.a(), cVar.c(), cVar.b(), cVar.d());
        }
    }
}
