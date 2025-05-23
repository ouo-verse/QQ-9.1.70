package com.tencent.qqnt.chathistory.ui.menu.data.datasource;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqnt.chathistory.util.d;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ae;
import com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
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
import com.tencent.qqnt.kernel.nativeinterface.SearchMsgItem;
import com.tencent.qqnt.kernel.nativeinterface.SearchMsgKeywordsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchResult;
import com.tencent.qqnt.kernel.nativeinterface.bm;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
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
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n*\u0001'\u0018\u0000 /2\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b2\u00103J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u0004J\u001a\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\nR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010$\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010\u001eR\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010(R$\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R!\u00101\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010.\u001a\u0004\b/\u00100\u00a8\u00064"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/menu/data/datasource/PlatformSearchDataSource;", "", "Lcom/tencent/qqnt/kernel/api/ae;", "l", "", h.F, "Lcom/tencent/qqnt/kernel/nativeinterface/SearchMsgItem;", "kernel", "Lcom/tencent/qqnt/chathistory/ui/menu/data/model/b;", "o", "", "keywords", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchChatMsgsParams;", "params", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/qqnt/chathistory/ui/menu/data/model/a;", "j", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchMsgKeywordsResult;", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "code", "reason", "f", "Lmqq/app/AppRuntime;", "a", "Lmqq/app/AppRuntime;", "appRuntime", "", "b", "Z", "searchMore", "c", "Ljava/lang/String;", "d", "Ljava/lang/Integer;", "searchId", "e", "setObserver", "com/tencent/qqnt/chathistory/ui/menu/data/datasource/PlatformSearchDataSource$b", "Lcom/tencent/qqnt/chathistory/ui/menu/data/datasource/PlatformSearchDataSource$b;", "observer", "Lkotlin/Function1;", "g", "Lkotlin/jvm/functions/Function1;", "msgCallback", "Lkotlin/Lazy;", "i", "()Lkotlinx/coroutines/flow/Flow;", "searchFlow", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class PlatformSearchDataSource {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AppRuntime appRuntime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean searchMore;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String keywords;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer searchId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean setObserver;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b observer;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super com.tencent.qqnt.chathistory.ui.menu.data.model.a, Unit> msgCallback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy searchFlow;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/menu/data/datasource/PlatformSearchDataSource$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chathistory.ui.menu.data.datasource.PlatformSearchDataSource$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/chathistory/ui/menu/data/datasource/PlatformSearchDataSource$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSearchListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchMsgKeywordsResult;", "result", "", "onSearchMsgKeywordsResult", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements IKernelSearchListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PlatformSearchDataSource.this);
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
            d.f354054a.a("PlatformSearchDataSource", " " + result.searchId + "->Size " + result.resultItems.size());
            Integer num = PlatformSearchDataSource.this.searchId;
            int i3 = result.searchId;
            if (num != null && num.intValue() == i3 && (function1 = PlatformSearchDataSource.this.msgCallback) != null) {
                function1.invoke(PlatformSearchDataSource.this.n(result));
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public /* synthetic */ void onSearchResult(SearchResult searchResult) {
            bm.m(this, searchResult);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48827);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PlatformSearchDataSource() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.observer = new b();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Flow<? extends com.tencent.qqnt.chathistory.ui.menu.data.model.a>>() { // from class: com.tencent.qqnt.chathistory.ui.menu.data.datasource.PlatformSearchDataSource$searchFlow$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/tencent/qqnt/chathistory/ui/menu/data/model/a;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
            @DebugMetadata(c = "com.tencent.qqnt.chathistory.ui.menu.data.datasource.PlatformSearchDataSource$searchFlow$2$1", f = "PlatformSearchDataSource.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.tencent.qqnt.chathistory.ui.menu.data.datasource.PlatformSearchDataSource$searchFlow$2$1, reason: invalid class name */
            /* loaded from: classes23.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<ProducerScope<? super com.tencent.qqnt.chathistory.ui.menu.data.model.a>, Continuation<? super Unit>, Object> {
                static IPatchRedirector $redirector_;
                private /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ PlatformSearchDataSource this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(PlatformSearchDataSource platformSearchDataSource, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = platformSearchDataSource;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) platformSearchDataSource, (Object) continuation);
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
                            this.this$0.msgCallback = new Function1<com.tencent.qqnt.chathistory.ui.menu.data.model.a, Unit>(producerScope) { // from class: com.tencent.qqnt.chathistory.ui.menu.data.datasource.PlatformSearchDataSource.searchFlow.2.1.1
                                static IPatchRedirector $redirector_;
                                final /* synthetic */ ProducerScope<com.tencent.qqnt.chathistory.ui.menu.data.model.a> $$this$callbackFlow;

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
                                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.chathistory.ui.menu.data.model.a aVar) {
                                    invoke2(aVar);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@NotNull com.tencent.qqnt.chathistory.ui.menu.data.model.a it) {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                                    } else {
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        this.$$this$callbackFlow.mo2003trySendJP2dKIU(it);
                                    }
                                }
                            };
                            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.qqnt.chathistory.ui.menu.data.datasource.PlatformSearchDataSource.searchFlow.2.1.2
                                static IPatchRedirector $redirector_;

                                {
                                    super(0);
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PlatformSearchDataSource.this);
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
                                        PlatformSearchDataSource.this.h();
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
                public final Object invoke(@NotNull ProducerScope<? super com.tencent.qqnt.chathistory.ui.menu.data.model.a> producerScope, @Nullable Continuation<? super Unit> continuation) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) producerScope, (Object) continuation);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PlatformSearchDataSource.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Flow<? extends com.tencent.qqnt.chathistory.ui.menu.data.model.a> invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? FlowKt.callbackFlow(new AnonymousClass1(PlatformSearchDataSource.this, null)) : (Flow) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.searchFlow = lazy;
    }

    public static /* synthetic */ void g(PlatformSearchDataSource platformSearchDataSource, int i3, String str, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            str = "";
        }
        platformSearchDataSource.f(i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        d.f354054a.a("PlatformSearchDataSource", "closeFlow");
        this.msgCallback = null;
        ae l3 = l();
        if (l3 != null) {
            l3.q0(this.observer);
        }
        this.searchId = null;
        this.keywords = null;
        this.setObserver = false;
    }

    private final Flow<com.tencent.qqnt.chathistory.ui.menu.data.model.a> i() {
        return (Flow) this.searchFlow.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(int i3, String str) {
        d.f354054a.a("PlatformSearchDataSource", "getSearchMsgWithKeywords result " + i3 + "  msg " + str);
    }

    private final ae l() {
        if (this.appRuntime == null) {
            this.appRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        }
        AppRuntime appRuntime = this.appRuntime;
        Intrinsics.checkNotNull(appRuntime);
        return ((IKernelService) appRuntime.getRuntimeService(IKernelService.class, "")).getSearchService();
    }

    private final com.tencent.qqnt.chathistory.ui.menu.data.model.b o(SearchMsgItem kernel) {
        return new com.tencent.qqnt.chathistory.ui.menu.data.model.b(kernel, this.keywords);
    }

    public final void f(int code, @Nullable String reason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, code, (Object) reason);
            return;
        }
        d.f354054a.a("PlatformSearchDataSource", this.searchId + "->cancelSearchMsgWithKeywords  code " + code);
        Integer num = this.searchId;
        if (num != null) {
            int intValue = num.intValue();
            ae l3 = l();
            if (l3 != null) {
                l3.cancelSearchMsgWithKeywords(intValue, code, reason);
            }
        }
        this.keywords = null;
        this.searchId = null;
    }

    @NotNull
    public final Flow<com.tencent.qqnt.chathistory.ui.menu.data.model.a> j(@NotNull String keywords, @NotNull SearchChatMsgsParams params) {
        ArrayList<String> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Flow) iPatchRedirector.redirect((short) 2, (Object) this, (Object) keywords, (Object) params);
        }
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        Intrinsics.checkNotNullParameter(params, "params");
        if (!this.setObserver) {
            ae l3 = l();
            if (l3 != null) {
                l3.addKernelSearchListener(this.observer);
            }
            this.setObserver = true;
        }
        Integer num = null;
        g(this, 1, null, 2, null);
        ae l16 = l();
        if (l16 != null) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(keywords);
            num = Integer.valueOf(l16.searchChatMsgs(arrayListOf, params, new IOperateCallback() { // from class: com.tencent.qqnt.chathistory.ui.menu.data.datasource.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    PlatformSearchDataSource.k(i3, str);
                }
            }));
        }
        this.searchId = num;
        d.f354054a.a("PlatformSearchDataSource", num + "->getSearchMsgWithKeywords  keywords " + keywords + " param " + params);
        this.searchMore = false;
        this.keywords = keywords;
        return i();
    }

    public final void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        d.f354054a.a("PlatformSearchDataSource", this.searchId + "->searchMoreMsgWithKeywords");
        Integer num = this.searchId;
        if (num != null) {
            int intValue = num.intValue();
            ae l3 = l();
            if (l3 != null) {
                l3.searchMoreMsgWithKeywords(intValue);
            }
            this.searchMore = true;
        }
    }

    @NotNull
    public final com.tencent.qqnt.chathistory.ui.menu.data.model.a n(@NotNull SearchMsgKeywordsResult kernel) {
        int collectionSizeOrDefault;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.qqnt.chathistory.ui.menu.data.model.a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) kernel);
        }
        Intrinsics.checkNotNullParameter(kernel, "kernel");
        ArrayList arrayList = new ArrayList();
        ArrayList<SearchMsgItem> arrayList2 = kernel.resultItems;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "kernel.resultItems");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
        for (SearchMsgItem it : arrayList2) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList3.add(Boolean.valueOf(arrayList.add(o(it))));
        }
        return new com.tencent.qqnt.chathistory.ui.menu.data.model.a(kernel.hasMore, arrayList, this.searchMore);
    }
}
