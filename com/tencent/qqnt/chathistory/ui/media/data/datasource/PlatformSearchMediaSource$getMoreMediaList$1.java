package com.tencent.qqnt.chathistory.ui.media.data.datasource;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chathistory.ui.media.data.model.SearchMediaItemModel;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0006\u001a\u00020\u0005*\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/Pair;", "", "", "Lcom/tencent/qqnt/chathistory/ui/media/data/model/SearchMediaItemModel;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.chathistory.ui.media.data.datasource.PlatformSearchMediaSource$getMoreMediaList$1", f = "PlatformSearchMediaSource.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes23.dex */
public final class PlatformSearchMediaSource$getMoreMediaList$1 extends SuspendLambda implements Function2<ProducerScope<? super Pair<? extends Integer, ? extends List<? extends SearchMediaItemModel>>>, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ int $chatType;
    final /* synthetic */ long $msgId;
    final /* synthetic */ long $msgSeq;
    final /* synthetic */ long $msgTime;
    final /* synthetic */ String $peerUid;
    final /* synthetic */ int $requestCount;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PlatformSearchMediaSource this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlatformSearchMediaSource$getMoreMediaList$1(long j3, long j16, long j17, int i3, String str, int i16, PlatformSearchMediaSource platformSearchMediaSource, Continuation<? super PlatformSearchMediaSource$getMoreMediaList$1> continuation) {
        super(2, continuation);
        this.$msgId = j3;
        this.$msgTime = j16;
        this.$msgSeq = j17;
        this.$chatType = i3;
        this.$peerUid = str;
        this.$requestCount = i16;
        this.this$0 = platformSearchMediaSource;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Integer.valueOf(i3), str, Integer.valueOf(i16), platformSearchMediaSource, continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(int i3, ProducerScope producerScope, PlatformSearchMediaSource platformSearchMediaSource, int i16, String str, ArrayList arrayList) {
        Integer num;
        Collection emptyList;
        int i17;
        List d16;
        if (arrayList != null) {
            num = Integer.valueOf(arrayList.size());
        } else {
            num = null;
        }
        QLog.d("PlatformSearchMediaSource", 1, "result " + i16 + ", errMsg requestCount " + i3 + " " + str + " \u5206\u9875  size " + num);
        if (arrayList == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            emptyList = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                MsgRecord it5 = (MsgRecord) it.next();
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                d16 = platformSearchMediaSource.d(it5);
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        PlatformSearchMediaSource$getMoreMediaList$1 platformSearchMediaSource$getMoreMediaList$1 = new PlatformSearchMediaSource$getMoreMediaList$1(this.$msgId, this.$msgTime, this.$msgSeq, this.$chatType, this.$peerUid, this.$requestCount, this.this$0, continuation);
        platformSearchMediaSource$getMoreMediaList$1.L$0 = obj;
        return platformSearchMediaSource$getMoreMediaList$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(ProducerScope<? super Pair<? extends Integer, ? extends List<? extends SearchMediaItemModel>>> producerScope, Continuation<? super Unit> continuation) {
        return invoke2((ProducerScope<? super Pair<Integer, ? extends List<SearchMediaItemModel>>>) producerScope, continuation);
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
                w e16 = f.e();
                if (e16 != null) {
                    long j3 = this.$msgId;
                    long j16 = this.$msgTime;
                    long j17 = this.$msgSeq;
                    QueryMsgsParams queryMsgsParams = new QueryMsgsParams(new ChatInfo(this.$chatType, this.$peerUid), new ArrayList(), new ArrayList(), 0L, 0L, this.$requestCount, false, false);
                    final int i16 = this.$requestCount;
                    final PlatformSearchMediaSource platformSearchMediaSource = this.this$0;
                    e16.queryPicOrVideoMsgs(j3, j16, j17, queryMsgsParams, new IMsgOperateCallback() { // from class: com.tencent.qqnt.chathistory.ui.media.data.datasource.b
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                        public final void onResult(int i17, String str, ArrayList arrayList) {
                            PlatformSearchMediaSource$getMoreMediaList$1.b(i16, producerScope, platformSearchMediaSource, i17, str, arrayList);
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

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull ProducerScope<? super Pair<Integer, ? extends List<SearchMediaItemModel>>> producerScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((PlatformSearchMediaSource$getMoreMediaList$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) producerScope, (Object) continuation);
    }
}
