package com.tencent.mobileqq.activity.emogroupstore;

import com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupDataSource;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.ChatInfo;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.MsgTypeFilter;
import com.tencent.qqnt.kernel.nativeinterface.QueryMsgsParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/tencent/mobileqq/activity/emogroupstore/EmoticonGroupDataSource$b;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupDataSource$getEmoList$2", f = "EmoticonGroupDataSource.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes10.dex */
public final class EmoticonGroupDataSource$getEmoList$2 extends SuspendLambda implements Function2<ProducerScope<? super EmoticonGroupDataSource.b>, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ int $requestCount;
    final /* synthetic */ long $requestFilterMsgFromTime;
    final /* synthetic */ ArrayList<MsgTypeFilter> $typeFilter;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ EmoticonGroupDataSource this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmoticonGroupDataSource$getEmoList$2(ArrayList<MsgTypeFilter> arrayList, long j3, int i3, EmoticonGroupDataSource emoticonGroupDataSource, Continuation<? super EmoticonGroupDataSource$getEmoList$2> continuation) {
        super(2, continuation);
        this.$typeFilter = arrayList;
        this.$requestFilterMsgFromTime = j3;
        this.$requestCount = i3;
        this.this$0 = emoticonGroupDataSource;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, arrayList, Long.valueOf(j3), Integer.valueOf(i3), emoticonGroupDataSource, continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final int i3, final long j3, final ProducerScope producerScope, final EmoticonGroupDataSource emoticonGroupDataSource, final int i16, final String str, final ArrayList arrayList) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.emogroupstore.b
            @Override // java.lang.Runnable
            public final void run() {
                EmoticonGroupDataSource$getEmoList$2.d(arrayList, i16, str, i3, j3, producerScope, emoticonGroupDataSource);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(ArrayList msgList, int i3, String str, int i16, long j3, ProducerScope producerScope, EmoticonGroupDataSource emoticonGroupDataSource) {
        long j16;
        List c16;
        Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
        ArrayList arrayList = new ArrayList();
        Iterator it = msgList.iterator();
        while (it.hasNext()) {
            MsgRecord it5 = (MsgRecord) it.next();
            Intrinsics.checkNotNullExpressionValue(it5, "it");
            c16 = emoticonGroupDataSource.c(it5);
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, c16);
        }
        boolean z16 = false;
        QLog.d("EmoticonGroupDataSource", 1, "[getEmoList]result=" + i3 + ", errMsg=" + str + ", resultCount=" + msgList.size(), ", requestCount=" + i16 + ", requestFilterMsgFromTime=" + j3, ", transformResultDataList=" + arrayList.size());
        if (msgList.size() > 0) {
            j16 = ((MsgRecord) msgList.get(msgList.size() - 1)).msgTime;
        } else {
            j16 = 0;
        }
        if (i16 == msgList.size()) {
            z16 = true;
        }
        producerScope.mo2003trySendJP2dKIU(new EmoticonGroupDataSource.b(arrayList, j16, z16, i16, j3));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        EmoticonGroupDataSource$getEmoList$2 emoticonGroupDataSource$getEmoList$2 = new EmoticonGroupDataSource$getEmoList$2(this.$typeFilter, this.$requestFilterMsgFromTime, this.$requestCount, this.this$0, continuation);
        emoticonGroupDataSource$getEmoList$2.L$0 = obj;
        return emoticonGroupDataSource$getEmoList$2;
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
                final ProducerScope producerScope = (ProducerScope) this.L$0;
                QLog.i("EmoticonGroupDataSource", 1, "[getEmoList] queryTroopEmoticonMsgs");
                w e16 = com.tencent.qqnt.msg.f.e();
                if (e16 != null) {
                    QueryMsgsParams queryMsgsParams = new QueryMsgsParams(new ChatInfo(2, ""), this.$typeFilter, new ArrayList(), this.$requestFilterMsgFromTime, 0L, this.$requestCount, false, false);
                    final int i16 = this.$requestCount;
                    final long j3 = this.$requestFilterMsgFromTime;
                    final EmoticonGroupDataSource emoticonGroupDataSource = this.this$0;
                    e16.queryTroopEmoticonMsgs(0L, 0L, 0L, queryMsgsParams, new IMsgOperateCallback() { // from class: com.tencent.mobileqq.activity.emogroupstore.a
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                        public final void onResult(int i17, String str, ArrayList arrayList) {
                            EmoticonGroupDataSource$getEmoList$2.c(i16, j3, producerScope, emoticonGroupDataSource, i17, str, arrayList);
                        }
                    });
                }
                AnonymousClass2 anonymousClass2 = AnonymousClass2.INSTANCE;
                this.label = 1;
                if (ProduceKt.awaitClose(producerScope, anonymousClass2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super EmoticonGroupDataSource.b> producerScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((EmoticonGroupDataSource$getEmoList$2) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) producerScope, (Object) continuation);
    }
}
