package com.qzone.reborn.groupalbum.selectmedia.part;

import aj.a;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.groupalbum.selectmedia.adapter.ChatHistorySelectMediaAdapter;
import com.qzone.reborn.groupalbum.selectmedia.data.model.SearchMediaItemModel;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import yi.PicPayLoad;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.qzone.reborn.groupalbum.selectmedia.part.ChatHistorySelectMediaPart$initStateObserver$1", f = "ChatHistorySelectMediaPart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes37.dex */
public final class ChatHistorySelectMediaPart$initStateObserver$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ChatHistorySelectMediaPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatHistorySelectMediaPart$initStateObserver$1(ChatHistorySelectMediaPart chatHistorySelectMediaPart, Continuation<? super ChatHistorySelectMediaPart$initStateObserver$1> continuation) {
        super(2, continuation);
        this.this$0 = chatHistorySelectMediaPart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChatHistorySelectMediaPart$initStateObserver$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            LiveData<com.tencent.qqnt.base.mvi.a> S1 = this.this$0.M9().S1();
            LifecycleOwner lifecycleOwner = this.this$0.getPartHost().getLifecycleOwner();
            final ChatHistorySelectMediaPart chatHistorySelectMediaPart = this.this$0;
            final Function1<com.tencent.qqnt.base.mvi.a, Unit> function1 = new Function1<com.tencent.qqnt.base.mvi.a, Unit>() { // from class: com.qzone.reborn.groupalbum.selectmedia.part.ChatHistorySelectMediaPart$initStateObserver$1.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.base.mvi.a aVar) {
                    invoke2(aVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(com.tencent.qqnt.base.mvi.a it) {
                    ChatHistorySelectMediaAdapter chatHistorySelectMediaAdapter;
                    ChatHistorySelectMediaAdapter chatHistorySelectMediaAdapter2;
                    if (it instanceof a.GetMediaListCompleted) {
                        ChatHistorySelectMediaPart chatHistorySelectMediaPart2 = ChatHistorySelectMediaPart.this;
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        chatHistorySelectMediaPart2.K9((a.GetMediaListCompleted) it);
                        return;
                    }
                    if (it instanceof a.DowLoadMediaCompleted) {
                        FileTransNotifyInfo info = ((a.DowLoadMediaCompleted) it).getInfo();
                        chatHistorySelectMediaAdapter = ChatHistorySelectMediaPart.this.adapter;
                        CopyOnWriteArrayList<wi.b> m06 = chatHistorySelectMediaAdapter.m0();
                        ChatHistorySelectMediaPart chatHistorySelectMediaPart3 = ChatHistorySelectMediaPart.this;
                        int i3 = 0;
                        for (Object obj2 : m06) {
                            int i16 = i3 + 1;
                            if (i3 < 0) {
                                CollectionsKt__CollectionsKt.throwIndexOverflow();
                            }
                            wi.b bVar = (wi.b) obj2;
                            if (bVar instanceof SearchMediaItemModel) {
                                SearchMediaItemModel searchMediaItemModel = (SearchMediaItemModel) bVar;
                                if (searchMediaItemModel.j() == info.msgId && searchMediaItemModel.getElementId() == info.msgElementId && info.thumbSize == searchMediaItemModel.f().getSecond().intValue()) {
                                    com.qzone.reborn.groupalbum.selectmedia.util.c.f56957a.a("ChatHistorySelectMediaPart", "notify " + i3 + "  error " + info.fileErrCode + " notifyPath " + info.filePath);
                                    searchMediaItemModel.t(info.fileErrCode == 2006021);
                                    if (info.fileErrCode == 0) {
                                        String str = info.filePath;
                                        Intrinsics.checkNotNullExpressionValue(str, "notifyInfo.filePath");
                                        searchMediaItemModel.u(str);
                                    }
                                    chatHistorySelectMediaAdapter2 = chatHistorySelectMediaPart3.adapter;
                                    chatHistorySelectMediaAdapter2.notifyItemChanged(i3, new com.qzone.reborn.groupalbum.selectmedia.util.f(PicPayLoad.class, new PicPayLoad(info)));
                                }
                            }
                            i3 = i16;
                        }
                        return;
                    }
                    if (it instanceof a.GetMoreMediaListCompleted) {
                        ChatHistorySelectMediaPart chatHistorySelectMediaPart4 = ChatHistorySelectMediaPart.this;
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        chatHistorySelectMediaPart4.L9((a.GetMoreMediaListCompleted) it);
                    }
                }
            };
            S1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.groupalbum.selectmedia.part.f
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj2) {
                    Function1.this.invoke(obj2);
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChatHistorySelectMediaPart$initStateObserver$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
