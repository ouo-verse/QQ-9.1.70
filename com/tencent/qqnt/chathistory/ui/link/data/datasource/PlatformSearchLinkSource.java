package com.tencent.qqnt.chathistory.ui.link.data.datasource;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.chathistory.util.d;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ae;
import com.tencent.qqnt.kernel.nativeinterface.ChatInfo;
import com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgTypeFilter;
import com.tencent.qqnt.kernel.nativeinterface.SearchAtMeChatsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchAtMeMsgsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchBuddyChatInfoResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchChatMsgsParams;
import com.tencent.qqnt.kernel.nativeinterface.SearchChatsKeywordsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchContactResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchFileKeywordsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchFunctionResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupChatInfoResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchLocalInfoResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchMsgKeywordsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchResult;
import com.tencent.qqnt.kernel.nativeinterface.bm;
import com.tencent.qqnt.msg.f;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n*\u0001*\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bJ\u0016\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\bJ\u0006\u0010\u0011\u001a\u00020\u0002JH\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0006R+\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R$\u00101\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0002\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R!\u00105\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u0010\u001f\u001a\u0004\b3\u00104\u00a8\u00068"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/link/data/datasource/PlatformSearchLinkSource;", "", "", h.F, "Lcom/tencent/qqnt/kernel/api/ae;", "o", "", "chatType", "", "peerId", "keywords", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/qqnt/chathistory/ui/link/dialog/data/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "code", "reason", "g", "k", "peerUid", "", "msgId", "msgTime", "msgSeq", "pageCount", "", "Lcom/tencent/qqnt/chathistory/ui/link/data/model/a;", "i", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgTypeFilter;", "Lkotlin/collections/ArrayList;", "a", "Lkotlin/Lazy;", "p", "()Ljava/util/ArrayList;", "typeFilter", "b", "Ljava/lang/Integer;", "searchId", "", "c", "Z", "isFirstRequest", "com/tencent/qqnt/chathistory/ui/link/data/datasource/PlatformSearchLinkSource$b", "d", "Lcom/tencent/qqnt/chathistory/ui/link/data/datasource/PlatformSearchLinkSource$b;", "observer", "Lkotlin/Function1;", "e", "Lkotlin/jvm/functions/Function1;", "msgCallback", "f", "l", "()Lkotlinx/coroutines/flow/Flow;", "searchFlow", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class PlatformSearchLinkSource {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: from kotlin metadata */
    @NotNull
    private final Lazy typeFilter;

    /* renamed from: b, reason: from kotlin metadata */
    @Nullable
    private Integer searchId;

    /* renamed from: c, reason: from kotlin metadata */
    private boolean isFirstRequest;

    /* renamed from: d, reason: from kotlin metadata */
    @NotNull
    private final b observer;

    /* renamed from: e, reason: from kotlin metadata */
    @Nullable
    private Function1<? super com.tencent.qqnt.chathistory.ui.link.dialog.data.a, Unit> msgCallback;

    /* renamed from: f, reason: from kotlin metadata */
    @NotNull
    private final Lazy searchFlow;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/link/data/datasource/PlatformSearchLinkSource$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chathistory.ui.link.data.datasource.PlatformSearchLinkSource$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/chathistory/ui/link/data/datasource/PlatformSearchLinkSource$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSearchListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchMsgKeywordsResult;", "result", "", "onSearchMsgKeywordsResult", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements IKernelSearchListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PlatformSearchLinkSource.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public /* synthetic */ void onSearchAtMeChatsResult(SearchAtMeChatsResult searchAtMeChatsResult) {
            bm.a(this, searchAtMeChatsResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public /* synthetic */ void onSearchAtMeMsgsResult(SearchAtMeMsgsResult searchAtMeMsgsResult) {
            bm.b(this, searchAtMeMsgsResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public /* synthetic */ void onSearchBuddyChatInfoResult(SearchBuddyChatInfoResult searchBuddyChatInfoResult) {
            bm.c(this, searchBuddyChatInfoResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public /* synthetic */ void onSearchCacheResult(String str, String str2, ArrayList arrayList) {
            bm.d(this, str, str2, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public /* synthetic */ void onSearchChatsKeywordsResult(SearchChatsKeywordsResult searchChatsKeywordsResult) {
            bm.e(this, searchChatsKeywordsResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public /* synthetic */ void onSearchContactResult(SearchContactResult searchContactResult) {
            bm.f(this, searchContactResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public /* synthetic */ void onSearchFileKeywordsResult(SearchFileKeywordsResult searchFileKeywordsResult) {
            bm.g(this, searchFileKeywordsResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public /* synthetic */ void onSearchFunctionResult(SearchFunctionResult searchFunctionResult) {
            bm.h(this, searchFunctionResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public /* synthetic */ void onSearchGroupChatInfoResult(SearchGroupChatInfoResult searchGroupChatInfoResult) {
            bm.i(this, searchGroupChatInfoResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public /* synthetic */ void onSearchGroupResult(SearchGroupResult searchGroupResult) {
            bm.j(this, searchGroupResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public /* synthetic */ void onSearchLocalInfoResult(SearchLocalInfoResult searchLocalInfoResult) {
            bm.k(this, searchLocalInfoResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public void onSearchMsgKeywordsResult(@NotNull SearchMsgKeywordsResult result) {
            Function1 function1;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) result);
                return;
            }
            Intrinsics.checkNotNullParameter(result, "result");
            d.f354054a.a("PlatformSearchLinkDataSource", " result  " + result + " receive Size " + result.resultItems.size());
            int i3 = result.searchId;
            Integer num = PlatformSearchLinkSource.this.searchId;
            if (num != null && i3 == num.intValue() && (function1 = PlatformSearchLinkSource.this.msgCallback) != null) {
                function1.invoke(new com.tencent.qqnt.chathistory.ui.link.dialog.data.a(PlatformSearchLinkSource.this.isFirstRequest, result));
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public /* synthetic */ void onSearchResult(SearchResult searchResult) {
            bm.m(this, searchResult);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46890);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PlatformSearchLinkSource() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(PlatformSearchLinkSource$typeFilter$2.INSTANCE);
            this.typeFilter = lazy;
            b bVar = new b();
            this.observer = bVar;
            ae o16 = o();
            if (o16 != null) {
                o16.addKernelSearchListener(bVar);
            }
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Flow<? extends com.tencent.qqnt.chathistory.ui.link.dialog.data.a>>() { // from class: com.tencent.qqnt.chathistory.ui.link.data.datasource.PlatformSearchLinkSource$searchFlow$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/tencent/qqnt/chathistory/ui/link/dialog/data/a;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
                @DebugMetadata(c = "com.tencent.qqnt.chathistory.ui.link.data.datasource.PlatformSearchLinkSource$searchFlow$2$1", f = "PlatformSearchLinkSource.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: com.tencent.qqnt.chathistory.ui.link.data.datasource.PlatformSearchLinkSource$searchFlow$2$1, reason: invalid class name */
                /* loaded from: classes23.dex */
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<ProducerScope<? super com.tencent.qqnt.chathistory.ui.link.dialog.data.a>, Continuation<? super Unit>, Object> {
                    static IPatchRedirector $redirector_;
                    private /* synthetic */ Object L$0;
                    int label;
                    final /* synthetic */ PlatformSearchLinkSource this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(PlatformSearchLinkSource platformSearchLinkSource, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.this$0 = platformSearchLinkSource;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) platformSearchLinkSource, (Object) continuation);
                        }
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
                        }
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                        anonymousClass1.L$0 = obj;
                        return anonymousClass1;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        Object coroutine_suspended;
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
                                ProducerScope producerScope = (ProducerScope) this.L$0;
                                this.this$0.msgCallback = new Function1<com.tencent.qqnt.chathistory.ui.link.dialog.data.a, Unit>(producerScope) { // from class: com.tencent.qqnt.chathistory.ui.link.data.datasource.PlatformSearchLinkSource.searchFlow.2.1.1
                                    static IPatchRedirector $redirector_;
                                    final /* synthetic */ ProducerScope<com.tencent.qqnt.chathistory.ui.link.dialog.data.a> $$this$callbackFlow;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                        this.$$this$callbackFlow = producerScope;
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) producerScope);
                                        }
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.chathistory.ui.link.dialog.data.a aVar) {
                                        invoke2(aVar);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@NotNull com.tencent.qqnt.chathistory.ui.link.dialog.data.a it) {
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                                        } else {
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            this.$$this$callbackFlow.mo2003trySendJP2dKIU(it);
                                        }
                                    }
                                };
                                Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.qqnt.chathistory.ui.link.data.datasource.PlatformSearchLinkSource.searchFlow.2.1.2
                                    static IPatchRedirector $redirector_;

                                    {
                                        super(0);
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PlatformSearchLinkSource.this);
                                        }
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                            PlatformSearchLinkSource.this.h();
                                        } else {
                                            iPatchRedirector2.redirect((short) 2, (Object) this);
                                        }
                                    }
                                };
                                this.label = 1;
                                if (ProduceKt.awaitClose(producerScope, function0, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            return Unit.INSTANCE;
                        }
                        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    @Nullable
                    public final Object invoke(@NotNull ProducerScope<? super com.tencent.qqnt.chathistory.ui.link.dialog.data.a> producerScope, @Nullable Continuation<? super Unit> continuation) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) producerScope, (Object) continuation);
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PlatformSearchLinkSource.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Flow<? extends com.tencent.qqnt.chathistory.ui.link.dialog.data.a> invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? FlowKt.callbackFlow(new AnonymousClass1(PlatformSearchLinkSource.this, null)) : (Flow) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.searchFlow = lazy2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public final void h() {
        d.f354054a.a("PlatformSearchLinkDataSource", "closeFlow");
        this.msgCallback = null;
        ae o16 = o();
        if (o16 != null) {
            o16.q0(this.observer);
        }
    }

    public static /* synthetic */ Flow j(PlatformSearchLinkSource platformSearchLinkSource, int i3, String str, long j3, long j16, long j17, int i16, int i17, Object obj) {
        long j18;
        long j19;
        long j26;
        if ((i17 & 4) != 0) {
            j18 = 0;
        } else {
            j18 = j3;
        }
        if ((i17 & 8) != 0) {
            j19 = 0;
        } else {
            j19 = j16;
        }
        if ((i17 & 16) != 0) {
            j26 = 0;
        } else {
            j26 = j17;
        }
        return platformSearchLinkSource.i(i3, str, j18, j19, j26, i16);
    }

    private final Flow<com.tencent.qqnt.chathistory.ui.link.dialog.data.a> l() {
        return (Flow) this.searchFlow.getValue();
    }

    public static final void n(int i3, String str) {
        d.f354054a.a("PlatformSearchLinkDataSource", "getSearchLinkData callBack result " + i3 + " errMsg " + str + " ");
    }

    private final ae o() {
        IKernelService i3 = f.i();
        if (i3 != null) {
            return i3.getSearchService();
        }
        return null;
    }

    private final ArrayList<MsgTypeFilter> p() {
        return (ArrayList) this.typeFilter.getValue();
    }

    public final void g(int code, @NotNull String reason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, code, (Object) reason);
            return;
        }
        Intrinsics.checkNotNullParameter(reason, "reason");
        Integer num = this.searchId;
        if (num != null) {
            int intValue = num.intValue();
            ae o16 = o();
            if (o16 != null) {
                o16.cancelSearchChatMsgs(intValue, code, reason);
            }
        }
        this.searchId = null;
    }

    @NotNull
    public final Flow<List<com.tencent.qqnt.chathistory.ui.link.data.model.a>> i(int chatType, @NotNull String peerUid, long msgId, long msgTime, long msgSeq, int pageCount) {
        List emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Flow) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(chatType), peerUid, Long.valueOf(msgId), Long.valueOf(msgTime), Long.valueOf(msgSeq), Integer.valueOf(pageCount));
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        ArrayList<MsgTypeFilter> p16 = p();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return FlowKt.callbackFlow(new PlatformSearchLinkSource$getData$$inlined$getMsgsByTypeFilterListByKernel$default$1(msgId, msgTime, msgSeq, chatType, peerUid, p16, emptyList, 0L, 0L, pageCount, null));
    }

    public final void k() {
        ae o16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.isFirstRequest = false;
        if (this.searchId != null && (o16 = o()) != null) {
            Integer num = this.searchId;
            Intrinsics.checkNotNull(num);
            o16.searchMoreChatMsgs(num.intValue());
        }
    }

    @NotNull
    public final Flow<com.tencent.qqnt.chathistory.ui.link.dialog.data.a> m(int i3, @NotNull String peerId, @NotNull String keywords) {
        Integer num;
        ArrayList<String> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Flow) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), peerId, keywords);
        }
        Intrinsics.checkNotNullParameter(peerId, "peerId");
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        this.isFirstRequest = true;
        d.f354054a.a("PlatformSearchLinkDataSource", "getSearchLinkDatachatType " + i3 + "  peerId " + peerId + "  keywords " + keywords);
        ae o16 = o();
        if (o16 != null) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(keywords);
            num = Integer.valueOf(o16.searchChatMsgs(arrayListOf, new SearchChatMsgsParams(new ChatInfo(i3, peerId), 5, p(), new ArrayList(), 0L, 0L, 20), new IOperateCallback() { // from class: com.tencent.qqnt.chathistory.ui.link.data.datasource.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i16, String str) {
                    PlatformSearchLinkSource.n(i16, str);
                }
            }));
        } else {
            num = null;
        }
        this.searchId = num;
        return l();
    }
}
