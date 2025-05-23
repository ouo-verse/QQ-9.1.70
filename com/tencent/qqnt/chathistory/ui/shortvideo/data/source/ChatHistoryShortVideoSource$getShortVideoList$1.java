package com.tencent.qqnt.chathistory.ui.shortvideo.data.source;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chathistory.ui.shortvideo.data.model.ChatHistoryShortVideoItemModel;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.ChatInfo;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.QueryMsgsParams;
import com.tencent.qqnt.msg.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0006\u001a\u00020\u0005*\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/Pair;", "", "", "Lcom/tencent/qqnt/chathistory/ui/shortvideo/data/model/a;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.chathistory.ui.shortvideo.data.source.ChatHistoryShortVideoSource$getShortVideoList$1", f = "ChatHistoryShortVideoSource.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes23.dex */
public final class ChatHistoryShortVideoSource$getShortVideoList$1 extends SuspendLambda implements Function2<ProducerScope<? super Pair<? extends Integer, ? extends List<? extends ChatHistoryShortVideoItemModel>>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $chatType;
    final /* synthetic */ int $pageCount;
    final /* synthetic */ String $peerUid;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ChatHistoryShortVideoSource this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatHistoryShortVideoSource$getShortVideoList$1(int i3, String str, int i16, ChatHistoryShortVideoSource chatHistoryShortVideoSource, Continuation<? super ChatHistoryShortVideoSource$getShortVideoList$1> continuation) {
        super(2, continuation);
        this.$chatType = i3;
        this.$peerUid = str;
        this.$pageCount = i16;
        this.this$0 = chatHistoryShortVideoSource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ProducerScope producerScope, int i3, ChatHistoryShortVideoSource chatHistoryShortVideoSource, int i16, String str, ArrayList arrayList) {
        Integer num;
        Collection emptyList;
        int i17;
        List d16;
        if (arrayList != null) {
            num = Integer.valueOf(arrayList.size());
        } else {
            num = null;
        }
        QLog.d("QCHV-ChatHistoryShortVideoSource", 1, "[getShortVideoList] result: " + i16 + ", errMsg: " + str + ", pageCount: " + i3 + ", first size: " + num);
        if (arrayList == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            emptyList = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                MsgRecord it5 = (MsgRecord) it.next();
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                d16 = chatHistoryShortVideoSource.d(it5);
                CollectionsKt__MutableCollectionsKt.addAll(emptyList, d16);
            }
        }
        if (arrayList != null) {
            i17 = arrayList.size();
        } else {
            i17 = 0;
        }
        producerScope.mo2003trySendJP2dKIU(TuplesKt.to(Integer.valueOf(i17), emptyList));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChatHistoryShortVideoSource$getShortVideoList$1 chatHistoryShortVideoSource$getShortVideoList$1 = new ChatHistoryShortVideoSource$getShortVideoList$1(this.$chatType, this.$peerUid, this.$pageCount, this.this$0, continuation);
        chatHistoryShortVideoSource$getShortVideoList$1.L$0 = obj;
        return chatHistoryShortVideoSource$getShortVideoList$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(ProducerScope<? super Pair<? extends Integer, ? extends List<? extends ChatHistoryShortVideoItemModel>>> producerScope, Continuation<? super Unit> continuation) {
        return invoke2((ProducerScope<? super Pair<Integer, ? extends List<ChatHistoryShortVideoItemModel>>>) producerScope, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
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
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            QueryMsgsParams queryMsgsParams = new QueryMsgsParams(new ChatInfo(this.$chatType, this.$peerUid), new ArrayList(), new ArrayList(), 0L, 0L, this.$pageCount, false, false);
            w e16 = f.e();
            if (e16 != null) {
                final int i16 = this.$pageCount;
                final ChatHistoryShortVideoSource chatHistoryShortVideoSource = this.this$0;
                e16.queryShortVideoMsgs(0L, 0L, 0L, queryMsgsParams, new IMsgOperateCallback() { // from class: com.tencent.qqnt.chathistory.ui.shortvideo.data.source.b
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                    public final void onResult(int i17, String str, ArrayList arrayList) {
                        ChatHistoryShortVideoSource$getShortVideoList$1.b(ProducerScope.this, i16, chatHistoryShortVideoSource, i17, str, arrayList);
                    }
                });
            }
            AnonymousClass2 anonymousClass2 = new Function0<Unit>() { // from class: com.tencent.qqnt.chathistory.ui.shortvideo.data.source.ChatHistoryShortVideoSource$getShortVideoList$1.2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, anonymousClass2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull ProducerScope<? super Pair<Integer, ? extends List<ChatHistoryShortVideoItemModel>>> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChatHistoryShortVideoSource$getShortVideoList$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
