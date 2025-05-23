package com.tencent.qqnt.chathistory.ui.document.viewmodel;

import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.qqnt.chathistory.ui.base.BaseHistoryViewModel;
import com.tencent.qqnt.chathistory.ui.document.data.a;
import com.tencent.qqnt.chathistory.ui.document.data.b;
import com.tencent.qqnt.chathistory.ui.document.data.datasource.PlatformSearchDocumentSource;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.qqnt.msg.d;
import java.util.ArrayList;
import java.util.Iterator;
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
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 \"2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000eH\u0002J\"\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0014J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0016R\u0014\u0010\u0015\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001f\u001a\u00020\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/document/viewmodel/ChatHistoryDocumentViewModel;", "Lcom/tencent/qqnt/chathistory/ui/base/BaseHistoryViewModel;", "Lcom/tencent/qqnt/chathistory/ui/document/data/a;", "Lcom/tencent/qqnt/chathistory/ui/document/data/b;", "Lcom/tencent/qqnt/chathistory/ui/document/data/b$a;", "userIntent", "", "S1", "c2", "Lcom/tencent/qqnt/chathistory/ui/document/data/b$f;", "b2", "Lcom/tencent/qqnt/chathistory/ui/document/data/b$b;", "data", "T1", "Lcom/tencent/qqnt/chathistory/ui/document/data/b$c;", "W1", "Landroid/content/Context;", "context", "", "url", "", "source", "Z1", "X1", "Lcom/tencent/qqnt/chathistory/ui/document/data/datasource/PlatformSearchDocumentSource;", UserInfo.SEX_FEMALE, "Lcom/tencent/qqnt/chathistory/ui/document/data/datasource/PlatformSearchDocumentSource;", "G", "Lcom/tencent/qqnt/chathistory/ui/document/data/b;", "U1", "()Lcom/tencent/qqnt/chathistory/ui/document/data/b;", "mNoneValueIntent", "<init>", "()V", "H", "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ChatHistoryDocumentViewModel extends BaseHistoryViewModel<com.tencent.qqnt.chathistory.ui.document.data.a, b> {
    static IPatchRedirector $redirector_;

    @NotNull
    private static final a H;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final PlatformSearchDocumentSource source;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final b mNoneValueIntent;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u00042\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0000j\b\u0012\u0004\u0012\u00020\u0001`\u0002H\u008a@"}, d2 = {"Ljava/util/ArrayList;", "Lcom/tencent/qqnt/msg/d;", "Lkotlin/collections/ArrayList;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.qqnt.chathistory.ui.document.viewmodel.ChatHistoryDocumentViewModel$1", f = "ChatHistoryDocumentViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.qqnt.chathistory.ui.document.viewmodel.ChatHistoryDocumentViewModel$1, reason: invalid class name */
    /* loaded from: classes23.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<ArrayList<d>, Continuation<? super Unit>, Object> {
        static IPatchRedirector $redirector_;
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryDocumentViewModel.this, (Object) continuation);
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
                    ArrayList arrayList = (ArrayList) this.L$0;
                    ChatHistoryDocumentViewModel chatHistoryDocumentViewModel = ChatHistoryDocumentViewModel.this;
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        MsgRecord a16 = ((d) it.next()).a();
                        int i3 = a16.msgType;
                        if (i3 == 2 || i3 == 11) {
                            chatHistoryDocumentViewModel.getMUiState().setValue(new a.C9530a(new com.tencent.qqnt.chathistory.ui.document.data.model.b(a16)));
                        }
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull ArrayList<d> arrayList, @Nullable Continuation<? super Unit> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass1) create(arrayList, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) arrayList, (Object) continuation);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/document/viewmodel/ChatHistoryDocumentViewModel$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44350);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            H = new a(null);
        }
    }

    public ChatHistoryDocumentViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        FlowKt.launchIn(FlowKt.onEach(((IMsgService) QRoute.api(IMsgService.class)).registerMsgStatusUpdateNotificationFlow(), new AnonymousClass1(null)), ViewModelKt.getViewModelScope(this));
        this.source = new PlatformSearchDocumentSource();
        this.mNoneValueIntent = b.d.f353477a;
    }

    private final void S1(b.a userIntent) {
        com.tencent.qqnt.chathistory.util.d.f354054a.a("ChatHistoryDocumentViewModel", "cancelSearch " + userIntent + " ");
        this.source.g(userIntent.a(), userIntent.b());
    }

    private final void T1(b.C9531b data) {
        FlowKt.launchIn(FlowKt.onEach(PlatformSearchDocumentSource.j(this.source, M1(), N1(), 0L, 0L, 0L, data.a(), 28, null), new ChatHistoryDocumentViewModel$getFirstPageData$1(this, data, null)), ViewModelKt.getViewModelScope(this));
    }

    private final void W1(b.c data) {
        FlowKt.launchIn(FlowKt.onEach(this.source.i(M1(), N1(), data.a(), data.c(), data.b(), data.d()), new ChatHistoryDocumentViewModel$getMoreData$1(this, data, null)), ViewModelKt.getViewModelScope(this));
    }

    public static /* synthetic */ void a2(ChatHistoryDocumentViewModel chatHistoryDocumentViewModel, Context context, String str, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        chatHistoryDocumentViewModel.Z1(context, str, i3);
    }

    private final void b2(b.f userIntent) {
        com.tencent.qqnt.chathistory.util.d.f354054a.a("ChatHistoryDocumentViewModel", "searchDocumentData " + userIntent + " ");
        FlowKt.launchIn(FlowKt.onEach(this.source.l(M1(), N1(), userIntent.a()), new ChatHistoryDocumentViewModel$searchDocumentData$1(this, null)), ViewModelKt.getViewModelScope(this));
    }

    private final void c2() {
        com.tencent.qqnt.chathistory.util.d.f354054a.a("ChatHistoryDocumentViewModel", "searchMore ");
        this.source.k();
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    @NotNull
    /* renamed from: U1, reason: merged with bridge method [inline-methods] */
    public b getMNoneValueIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mNoneValueIntent;
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    /* renamed from: X1, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull b userIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) userIntent);
            return;
        }
        Intrinsics.checkNotNullParameter(userIntent, "userIntent");
        com.tencent.qqnt.chathistory.util.d.f354054a.a("ChatHistoryDocumentViewModel", "handleIntent " + userIntent + " ");
        if (!Intrinsics.areEqual(userIntent, b.d.f353477a)) {
            if (userIntent instanceof b.C9531b) {
                T1((b.C9531b) userIntent);
                return;
            }
            if (userIntent instanceof b.c) {
                W1((b.c) userIntent);
                return;
            }
            if (userIntent instanceof b.f) {
                b2((b.f) userIntent);
            } else if (userIntent instanceof b.e) {
                c2();
            } else if (userIntent instanceof b.a) {
                S1((b.a) userIntent);
            }
        }
    }

    public final void Z1(@NotNull Context context, @Nullable String url, int source) {
        boolean z16;
        boolean startsWith$default;
        boolean startsWith$default2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, url, Integer.valueOf(source));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && !((IArkAPIService) QRoute.api(IArkAPIService.class)).dispatchOpenURL(url, null, null, 0, "com.tencent.tdoc.qqpush", null)) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "http://", false, 2, null);
            if (!startsWith$default) {
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(url, "https://", false, 2, null);
                if (!startsWith$default2) {
                    return;
                }
            }
            Intent intent = new Intent();
            intent.putExtra("url", url);
            if (source == 1) {
                intent.putExtra("hide_more_button", true);
            }
            ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, RouterConstants.UI_ROUTE_BROWSER);
            activityURIRequest.extra().putAll(intent.getExtras());
            QRoute.startUri(activityURIRequest, (o) null);
        }
    }
}
