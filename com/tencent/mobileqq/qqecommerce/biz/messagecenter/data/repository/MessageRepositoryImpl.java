package com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.repository;

import ag2.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qqecommerce.base.runtime.ECRuntimeManager;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.IEcommerceMsgCenterService;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.MessageItem;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.data_source.message.MessageLocalDataSource;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.UIState;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import tl.h;
import wf2.NetworkResult;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 -2\u00020\u0001:\u0002\u000b\u0017B!\u0012\u0006\u0010\u0015\u001a\u00020\u0011\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001c\u00a2\u0006\u0004\b+\u0010,J\u0013\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0004J\u001b\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\nJ\u001b\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020$0#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020$0(8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010)\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/data/repository/MessageRepositoryImpl;", "Lag2/a;", "", "k", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/b;", h.F, "", "cookie", "j", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "", "messageId", "", "c", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/data/data_source/message/MessageLocalDataSource;", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/data/data_source/message/MessageLocalDataSource;", "g", "()Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/data/data_source/message/MessageLocalDataSource;", "localDataSource", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/data/data_source/message/a;", "b", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/data/data_source/message/a;", "i", "()Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/data/data_source/message/a;", "remoteDataSource", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "coroutineContext", "", "d", "J", "uin", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/data/repository/MessageRepositoryImpl$b;", "e", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_messagesState", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "messagesState", "<init>", "(Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/data/data_source/message/MessageLocalDataSource;Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/data/data_source/message/a;Lkotlinx/coroutines/CoroutineDispatcher;)V", "f", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class MessageRepositoryImpl implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final MessageLocalDataSource localDataSource;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.data_source.message.a remoteDataSource;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final CoroutineDispatcher coroutineContext;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long uin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final MutableStateFlow<b> _messagesState;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0006\u0018\u00002\u00020\u0001B-\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\n\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0014\u001a\u0004\b\u0004\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/data/repository/MessageRepositoryImpl$b;", "", "", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/b;", "a", "Ljava/util/List;", "c", "()Ljava/util/List;", "messages", "", "b", "Z", "d", "()Z", "isEnd", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/representation/UIState;", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/representation/UIState;", "()Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/representation/UIState;", "listUIState", "", "[B", "()[B", "cookie", "<init>", "(Ljava/util/List;ZLcom/tencent/mobileqq/qqecommerce/biz/messagecenter/representation/UIState;[B)V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final List<MessageItem> messages;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final boolean isEnd;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final UIState listUIState;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final byte[] cookie;

        public b(List<MessageItem> messages, boolean z16, UIState listUIState, byte[] cookie) {
            Intrinsics.checkNotNullParameter(messages, "messages");
            Intrinsics.checkNotNullParameter(listUIState, "listUIState");
            Intrinsics.checkNotNullParameter(cookie, "cookie");
            this.messages = messages;
            this.isEnd = z16;
            this.listUIState = listUIState;
            this.cookie = cookie;
        }

        /* renamed from: a, reason: from getter */
        public final byte[] getCookie() {
            return this.cookie;
        }

        /* renamed from: b, reason: from getter */
        public final UIState getListUIState() {
            return this.listUIState;
        }

        public final List<MessageItem> c() {
            return this.messages;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getIsEnd() {
            return this.isEnd;
        }
    }

    public MessageRepositoryImpl(MessageLocalDataSource localDataSource, com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.data_source.message.a remoteDataSource, CoroutineDispatcher coroutineContext) {
        List emptyList;
        Intrinsics.checkNotNullParameter(localDataSource, "localDataSource");
        Intrinsics.checkNotNullParameter(remoteDataSource, "remoteDataSource");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
        this.coroutineContext = coroutineContext;
        this.uin = ECRuntimeManager.INSTANCE.e();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this._messagesState = StateFlowKt.MutableStateFlow(new b(emptyList, false, UIState.LOADING, new byte[0]));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object h(Continuation<? super MessageItem> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        IEcommerceMsgCenterService iEcommerceMsgCenterService;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        QQAppInterface b16 = ECRuntimeManager.INSTANCE.b();
        if (b16 != null && (iEcommerceMsgCenterService = (IEcommerceMsgCenterService) b16.getRuntimeService(IEcommerceMsgCenterService.class)) != null) {
            iEcommerceMsgCenterService.fetchRedDotMessage(new Function1<MessageItem, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.repository.MessageRepositoryImpl$getRedDotMessage$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(MessageItem messageItem) {
                    invoke2(messageItem);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(MessageItem messageItem) {
                    safeContinuation.resumeWith(Result.m476constructorimpl(messageItem));
                }
            });
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object j(byte[] bArr, Continuation<? super Unit> continuation) {
        MessageRepositoryImpl$triggerFetchMoreMessages$1 messageRepositoryImpl$triggerFetchMoreMessages$1;
        Object coroutine_suspended;
        int i3;
        MessageRepositoryImpl messageRepositoryImpl;
        NetworkResult networkResult;
        List mutableList;
        List list;
        if (continuation instanceof MessageRepositoryImpl$triggerFetchMoreMessages$1) {
            messageRepositoryImpl$triggerFetchMoreMessages$1 = (MessageRepositoryImpl$triggerFetchMoreMessages$1) continuation;
            int i16 = messageRepositoryImpl$triggerFetchMoreMessages$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                messageRepositoryImpl$triggerFetchMoreMessages$1.label = i16 - Integer.MIN_VALUE;
                Object obj = messageRepositoryImpl$triggerFetchMoreMessages$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = messageRepositoryImpl$triggerFetchMoreMessages$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.data_source.message.a aVar = this.remoteDataSource;
                    messageRepositoryImpl$triggerFetchMoreMessages$1.L$0 = this;
                    messageRepositoryImpl$triggerFetchMoreMessages$1.label = 1;
                    obj = com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.data_source.message.a.d(aVar, bArr, 0, messageRepositoryImpl$triggerFetchMoreMessages$1, 2, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    messageRepositoryImpl = this;
                } else {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            list = (List) messageRepositoryImpl$triggerFetchMoreMessages$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            QLog.d("ECMsgCenter|MessageRepositoryImpl", 2, "triggerFetchMoreMessages return remote msg. size = " + list.size());
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    messageRepositoryImpl = (MessageRepositoryImpl) messageRepositoryImpl$triggerFetchMoreMessages$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                Pair pair = (Pair) obj;
                networkResult = (NetworkResult) pair.getFirst();
                if (networkResult.getIsSucceed()) {
                    mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) messageRepositoryImpl.b().getValue().c());
                    mutableList.addAll(networkResult.a());
                    MutableStateFlow<b> mutableStateFlow = messageRepositoryImpl._messagesState;
                    b bVar = new b(mutableList, networkResult.getIsEnd(), UIState.SUCCEED, (byte[]) pair.getSecond());
                    messageRepositoryImpl$triggerFetchMoreMessages$1.L$0 = mutableList;
                    messageRepositoryImpl$triggerFetchMoreMessages$1.label = 2;
                    if (mutableStateFlow.emit(bVar, messageRepositoryImpl$triggerFetchMoreMessages$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    list = mutableList;
                    QLog.d("ECMsgCenter|MessageRepositoryImpl", 2, "triggerFetchMoreMessages return remote msg. size = " + list.size());
                }
                return Unit.INSTANCE;
            }
        }
        messageRepositoryImpl$triggerFetchMoreMessages$1 = new MessageRepositoryImpl$triggerFetchMoreMessages$1(this, continuation);
        Object obj2 = messageRepositoryImpl$triggerFetchMoreMessages$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = messageRepositoryImpl$triggerFetchMoreMessages$1.label;
        if (i3 != 0) {
        }
        Pair pair2 = (Pair) obj2;
        networkResult = (NetworkResult) pair2.getFirst();
        if (networkResult.getIsSucceed()) {
        }
        return Unit.INSTANCE;
    }

    private final Object k(Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object withContext = BuildersKt.withContext(this.coroutineContext, new MessageRepositoryImpl$triggerFirstFetchMessages$2(this, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return withContext == coroutine_suspended ? withContext : Unit.INSTANCE;
    }

    @Override // ag2.a
    public Object a(byte[] bArr, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object coroutine_suspended2;
        if (bArr.length == 0) {
            Object k3 = k(continuation);
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return k3 == coroutine_suspended2 ? k3 : Unit.INSTANCE;
        }
        Object j3 = j(bArr, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return j3 == coroutine_suspended ? j3 : Unit.INSTANCE;
    }

    @Override // ag2.a
    public StateFlow<b> b() {
        return this._messagesState;
    }

    @Override // ag2.a
    public Object c(String str, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(this.coroutineContext, new MessageRepositoryImpl$deleteMessage$2(this, str, null), continuation);
    }

    /* renamed from: g, reason: from getter */
    public final MessageLocalDataSource getLocalDataSource() {
        return this.localDataSource;
    }

    /* renamed from: i, reason: from getter */
    public final com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.data_source.message.a getRemoteDataSource() {
        return this.remoteDataSource;
    }

    public /* synthetic */ MessageRepositoryImpl(MessageLocalDataSource messageLocalDataSource, com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.data_source.message.a aVar, CoroutineDispatcher coroutineDispatcher, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(messageLocalDataSource, aVar, (i3 & 4) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }
}
