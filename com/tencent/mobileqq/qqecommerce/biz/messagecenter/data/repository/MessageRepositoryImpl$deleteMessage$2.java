package com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.repository;

import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.MessageItem;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.data_source.message.MessageLocalDataSource;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.data_source.message.a;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.repository.MessageRepositoryImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.repository.MessageRepositoryImpl$deleteMessage$2", f = "MessageRepositoryImpl.kt", i = {1, 2}, l = {152, 155, 160}, m = "invokeSuspend", n = {"isSucceed", "isSucceed"}, s = {"Z$0", "Z$0"})
/* loaded from: classes35.dex */
final class MessageRepositoryImpl$deleteMessage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $messageId;
    boolean Z$0;
    int label;
    final /* synthetic */ MessageRepositoryImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageRepositoryImpl$deleteMessage$2(MessageRepositoryImpl messageRepositoryImpl, String str, Continuation<? super MessageRepositoryImpl$deleteMessage$2> continuation) {
        super(2, continuation);
        this.this$0 = messageRepositoryImpl;
        this.$messageId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MessageRepositoryImpl$deleteMessage$2(this.this$0, this.$messageId, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00e6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00e7  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        boolean booleanValue;
        boolean z16;
        List mutableList;
        MutableStateFlow mutableStateFlow;
        MessageRepositoryImpl.b bVar;
        List list;
        boolean z17;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            a remoteDataSource = this.this$0.getRemoteDataSource();
            String str = this.$messageId;
            this.label = 1;
            obj = remoteDataSource.b(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        z17 = this.Z$0;
                        ResultKt.throwOnFailure(obj);
                        booleanValue = z17;
                        return Boxing.boxBoolean(booleanValue);
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                z16 = this.Z$0;
                ResultKt.throwOnFailure(obj);
                QLog.d("ECMsgCenter|MessageRepositoryImpl", 1, "delete msg in db. delRow: " + ((Number) obj).intValue());
                mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.this$0.b().getValue().c());
                final String str2 = this.$messageId;
                CollectionsKt__MutableCollectionsKt.removeAll(mutableList, (Function1) new Function1<MessageItem, Boolean>() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.repository.MessageRepositoryImpl$deleteMessage$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(MessageItem it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return Boolean.valueOf(Intrinsics.areEqual(it.getId(), str2));
                    }
                });
                mutableStateFlow = this.this$0._messagesState;
                list = CollectionsKt___CollectionsKt.toList(mutableList);
                bVar = new MessageRepositoryImpl.b(list, this.this$0.b().getValue().getIsEnd(), this.this$0.b().getValue().getListUIState(), this.this$0.b().getValue().getCookie());
                this.Z$0 = z16;
                this.label = 3;
                if (mutableStateFlow.emit(bVar, this) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                z17 = z16;
                booleanValue = z17;
                return Boxing.boxBoolean(booleanValue);
            }
            ResultKt.throwOnFailure(obj);
        }
        booleanValue = ((Boolean) obj).booleanValue();
        if (booleanValue) {
            MessageLocalDataSource localDataSource = this.this$0.getLocalDataSource();
            String str3 = this.$messageId;
            this.Z$0 = booleanValue;
            this.label = 2;
            Object b16 = localDataSource.b(str3, this);
            if (b16 == coroutine_suspended) {
                return coroutine_suspended;
            }
            z16 = booleanValue;
            obj = b16;
            QLog.d("ECMsgCenter|MessageRepositoryImpl", 1, "delete msg in db. delRow: " + ((Number) obj).intValue());
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.this$0.b().getValue().c());
            final String str22 = this.$messageId;
            CollectionsKt__MutableCollectionsKt.removeAll(mutableList, (Function1) new Function1<MessageItem, Boolean>() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.repository.MessageRepositoryImpl$deleteMessage$2.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(MessageItem it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(Intrinsics.areEqual(it.getId(), str22));
                }
            });
            mutableStateFlow = this.this$0._messagesState;
            list = CollectionsKt___CollectionsKt.toList(mutableList);
            bVar = new MessageRepositoryImpl.b(list, this.this$0.b().getValue().getIsEnd(), this.this$0.b().getValue().getListUIState(), this.this$0.b().getValue().getCookie());
            this.Z$0 = z16;
            this.label = 3;
            if (mutableStateFlow.emit(bVar, this) != coroutine_suspended) {
            }
        }
        return Boxing.boxBoolean(booleanValue);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((MessageRepositoryImpl$deleteMessage$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
