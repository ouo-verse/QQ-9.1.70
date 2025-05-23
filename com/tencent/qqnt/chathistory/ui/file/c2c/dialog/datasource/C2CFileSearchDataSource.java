package com.tencent.qqnt.chathistory.ui.file.c2c.dialog.datasource;

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
import com.tencent.qqnt.kernel.nativeinterface.SearchMsgItem;
import com.tencent.qqnt.kernel.nativeinterface.SearchMsgKeywordsResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchResult;
import com.tencent.qqnt.kernel.nativeinterface.bm;
import com.tencent.qqnt.msg.f;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t*\u0001*\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000e\u001a\u00020\u0002J\u0016\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\bR\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u0019R+\u0010)\u001a\u0012\u0012\u0004\u0012\u00020#0\"j\b\u0012\u0004\u0012\u00020#`$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R$\u00101\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0002\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R!\u00104\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010&\u001a\u0004\b2\u00103\u00a8\u00067"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/file/c2c/dialog/datasource/C2CFileSearchDataSource;", "", "", "j", "Lcom/tencent/qqnt/kernel/api/ae;", "p", "", "chatType", "", "peerId", "keywords", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/dialog/data/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "code", "reason", "i", "Lkotlinx/coroutines/CoroutineScope;", "a", "Lkotlinx/coroutines/CoroutineScope;", "l", "()Lkotlinx/coroutines/CoroutineScope;", "scope", "b", "Ljava/lang/Integer;", "searchId", "", "c", "Z", "isFirstRequest", "d", "Ljava/lang/String;", "e", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgTypeFilter;", "Lkotlin/collections/ArrayList;", "f", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Ljava/util/ArrayList;", "typeFilters", "com/tencent/qqnt/chathistory/ui/file/c2c/dialog/datasource/C2CFileSearchDataSource$b", "g", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/dialog/datasource/C2CFileSearchDataSource$b;", "observer", "Lkotlin/Function1;", h.F, "Lkotlin/jvm/functions/Function1;", "msgCallback", "o", "()Lkotlinx/coroutines/flow/Flow;", "searchFlow", "<init>", "(Lkotlinx/coroutines/CoroutineScope;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class C2CFileSearchDataSource {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private static final a f353619j;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope scope;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer searchId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstRequest;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String peerId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer chatType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy typeFilters;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b observer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super com.tencent.qqnt.chathistory.ui.file.c2c.dialog.data.a, Unit> msgCallback;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy searchFlow;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/file/c2c/dialog/datasource/C2CFileSearchDataSource$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/chathistory/ui/file/c2c/dialog/datasource/C2CFileSearchDataSource$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSearchListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchMsgKeywordsResult;", "result", "", "onSearchMsgKeywordsResult", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements IKernelSearchListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) C2CFileSearchDataSource.this);
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
            int collectionSizeOrDefault;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) result);
                return;
            }
            Intrinsics.checkNotNullParameter(result, "result");
            d.f354054a.a("PlatformSearchFileSource", " result  " + result + " receive Size " + result.resultItems.size());
            int i3 = result.searchId;
            Integer num = C2CFileSearchDataSource.this.searchId;
            if (num != null && i3 == num.intValue()) {
                ArrayList<SearchMsgItem> arrayList = result.resultItems;
                Intrinsics.checkNotNullExpressionValue(arrayList, "result.resultItems");
                C2CFileSearchDataSource c2CFileSearchDataSource = C2CFileSearchDataSource.this;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                for (SearchMsgItem it : arrayList) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    String str = c2CFileSearchDataSource.peerId;
                    Intrinsics.checkNotNull(str);
                    Integer num2 = c2CFileSearchDataSource.chatType;
                    Intrinsics.checkNotNull(num2);
                    arrayList2.add(new com.tencent.qqnt.chathistory.ui.file.c2c.dialog.data.b(it, str, num2.intValue(), c2CFileSearchDataSource.l()));
                }
                Function1 function1 = C2CFileSearchDataSource.this.msgCallback;
                if (function1 != null) {
                    function1.invoke(new com.tencent.qqnt.chathistory.ui.file.c2c.dialog.data.a(C2CFileSearchDataSource.this.isFirstRequest, arrayList2, result.hasMore));
                }
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelSearchListener
        public /* synthetic */ void onSearchResult(SearchResult searchResult) {
            bm.m(this, searchResult);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46065);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f353619j = new a(null);
        }
    }

    public C2CFileSearchDataSource(@NotNull CoroutineScope scope) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) scope);
            return;
        }
        this.scope = scope;
        lazy = LazyKt__LazyJVMKt.lazy(C2CFileSearchDataSource$typeFilters$2.INSTANCE);
        this.typeFilters = lazy;
        b bVar = new b();
        this.observer = bVar;
        ae p16 = p();
        if (p16 != null) {
            p16.addKernelSearchListener(bVar);
        }
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Flow<? extends com.tencent.qqnt.chathistory.ui.file.c2c.dialog.data.a>>() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.dialog.datasource.C2CFileSearchDataSource$searchFlow$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/dialog/data/a;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
            @DebugMetadata(c = "com.tencent.qqnt.chathistory.ui.file.c2c.dialog.datasource.C2CFileSearchDataSource$searchFlow$2$1", f = "C2CFileSearchDataSource.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.tencent.qqnt.chathistory.ui.file.c2c.dialog.datasource.C2CFileSearchDataSource$searchFlow$2$1, reason: invalid class name */
            /* loaded from: classes23.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<ProducerScope<? super com.tencent.qqnt.chathistory.ui.file.c2c.dialog.data.a>, Continuation<? super Unit>, Object> {
                static IPatchRedirector $redirector_;
                private /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ C2CFileSearchDataSource this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(C2CFileSearchDataSource c2CFileSearchDataSource, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = c2CFileSearchDataSource;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) c2CFileSearchDataSource, (Object) continuation);
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
                            this.this$0.msgCallback = new Function1<com.tencent.qqnt.chathistory.ui.file.c2c.dialog.data.a, Unit>(producerScope) { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.dialog.datasource.C2CFileSearchDataSource.searchFlow.2.1.1
                                static IPatchRedirector $redirector_;
                                final /* synthetic */ ProducerScope<com.tencent.qqnt.chathistory.ui.file.c2c.dialog.data.a> $$this$callbackFlow;

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
                                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.chathistory.ui.file.c2c.dialog.data.a aVar) {
                                    invoke2(aVar);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@NotNull com.tencent.qqnt.chathistory.ui.file.c2c.dialog.data.a it) {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                                    } else {
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        this.$$this$callbackFlow.mo2003trySendJP2dKIU(it);
                                    }
                                }
                            };
                            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.dialog.datasource.C2CFileSearchDataSource.searchFlow.2.1.2
                                static IPatchRedirector $redirector_;

                                {
                                    super(0);
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) C2CFileSearchDataSource.this);
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
                                        C2CFileSearchDataSource.this.j();
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
                public final Object invoke(@NotNull ProducerScope<? super com.tencent.qqnt.chathistory.ui.file.c2c.dialog.data.a> producerScope, @Nullable Continuation<? super Unit> continuation) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) producerScope, (Object) continuation);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) C2CFileSearchDataSource.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Flow<? extends com.tencent.qqnt.chathistory.ui.file.c2c.dialog.data.a> invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? FlowKt.callbackFlow(new AnonymousClass1(C2CFileSearchDataSource.this, null)) : (Flow) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.searchFlow = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        d.f354054a.a("C2CFileSearchDataSource", "closeFlow");
        this.msgCallback = null;
        ae p16 = p();
        if (p16 != null) {
            p16.q0(this.observer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(int i3, String str) {
        d.f354054a.a("C2CFileSearchDataSource", "getSearchFileData callBack result " + i3 + " errMsg " + str + " ");
    }

    private final Flow<com.tencent.qqnt.chathistory.ui.file.c2c.dialog.data.a> o() {
        return (Flow) this.searchFlow.getValue();
    }

    private final ae p() {
        IKernelService i3 = f.i();
        if (i3 != null) {
            return i3.getSearchService();
        }
        return null;
    }

    private final ArrayList<MsgTypeFilter> q() {
        return (ArrayList) this.typeFilters.getValue();
    }

    public final void i(int code, @NotNull String reason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, code, (Object) reason);
            return;
        }
        Intrinsics.checkNotNullParameter(reason, "reason");
        d.f354054a.a("PlatformSearchFileSource", "cancelSearch  searchId " + this.searchId + "  reason " + reason + " ");
        Integer num = this.searchId;
        if (num != null) {
            int intValue = num.intValue();
            ae p16 = p();
            if (p16 != null) {
                p16.cancelSearchChatMsgs(intValue, code, reason);
            }
        }
        this.searchId = null;
    }

    public final void k() {
        ae p16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        d.f354054a.a("C2CFileSearchDataSource", "getMoreSearchData  searchId " + this.searchId + " ");
        this.isFirstRequest = false;
        if (this.searchId != null && (p16 = p()) != null) {
            Integer num = this.searchId;
            Intrinsics.checkNotNull(num);
            p16.searchMoreChatMsgs(num.intValue());
        }
    }

    @NotNull
    public final CoroutineScope l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CoroutineScope) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.scope;
    }

    @NotNull
    public final Flow<com.tencent.qqnt.chathistory.ui.file.c2c.dialog.data.a> m(int chatType, @NotNull String peerId, @NotNull String keywords) {
        Integer num;
        ArrayList<String> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Flow) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(chatType), peerId, keywords);
        }
        Intrinsics.checkNotNullParameter(peerId, "peerId");
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        this.peerId = peerId;
        this.chatType = Integer.valueOf(chatType);
        this.isFirstRequest = true;
        d.f354054a.a("C2CFileSearchDataSource", "getSearchFileData  keywords " + keywords + " ");
        ae p16 = p();
        if (p16 != null) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(keywords);
            num = Integer.valueOf(p16.searchChatMsgs(arrayListOf, new SearchChatMsgsParams(new ChatInfo(chatType, peerId), 6, q(), new ArrayList(), 0L, 0L, 20), new IOperateCallback() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.dialog.datasource.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    C2CFileSearchDataSource.n(i3, str);
                }
            }));
        } else {
            num = null;
        }
        this.searchId = num;
        return o();
    }
}
