package com.tencent.qqnt.chathistory.ui.sticker.data.datasource;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chathistory.ui.sticker.data.model.SearchStickerItemModel;
import com.tencent.qqnt.chathistory.util.d;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.ChatInfo;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.QueryMsgsParams;
import com.tencent.qqnt.msg.f;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "", "Lcom/tencent/qqnt/chathistory/ui/sticker/data/model/SearchStickerItemModel;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.chathistory.ui.sticker.data.datasource.PlatformSearchStickerSource$getStickerData$1", f = "PlatformSearchStickerSource.kt", i = {}, l = {36}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes23.dex */
public final class PlatformSearchStickerSource$getStickerData$1 extends SuspendLambda implements Function2<ProducerScope<? super List<? extends SearchStickerItemModel>>, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ int $chatType;
    final /* synthetic */ String $peerId;
    final /* synthetic */ int $requestCount;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PlatformSearchStickerSource this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlatformSearchStickerSource$getStickerData$1(int i3, String str, int i16, PlatformSearchStickerSource platformSearchStickerSource, Continuation<? super PlatformSearchStickerSource$getStickerData$1> continuation) {
        super(2, continuation);
        this.$chatType = i3;
        this.$peerId = str;
        this.$requestCount = i16;
        this.this$0 = platformSearchStickerSource;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, Integer.valueOf(i16), platformSearchStickerSource, continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(int i3, ProducerScope producerScope, PlatformSearchStickerSource platformSearchStickerSource, int i16, String str, int i17, String str2, ArrayList msgList) {
        Integer num;
        List d16;
        d dVar = d.f354054a;
        if (msgList != null) {
            num = Integer.valueOf(msgList.size());
        } else {
            num = null;
        }
        dVar.a("PlatformSearchStickerSource", "result " + i17 + ", errMsg " + str2 + " \u9996\u5c4f requestCount " + i3 + "  size " + num);
        Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
        ArrayList arrayList = new ArrayList();
        Iterator it = msgList.iterator();
        while (it.hasNext()) {
            MsgRecord it5 = (MsgRecord) it.next();
            Intrinsics.checkNotNullExpressionValue(it5, "it");
            d16 = platformSearchStickerSource.d(it5, i16, str);
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, d16);
        }
        producerScope.mo2003trySendJP2dKIU(arrayList);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        PlatformSearchStickerSource$getStickerData$1 platformSearchStickerSource$getStickerData$1 = new PlatformSearchStickerSource$getStickerData$1(this.$chatType, this.$peerId, this.$requestCount, this.this$0, continuation);
        platformSearchStickerSource$getStickerData$1.L$0 = obj;
        return platformSearchStickerSource$getStickerData$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(ProducerScope<? super List<? extends SearchStickerItemModel>> producerScope, Continuation<? super Unit> continuation) {
        return invoke2((ProducerScope<? super List<SearchStickerItemModel>>) producerScope, continuation);
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
                    QueryMsgsParams queryMsgsParams = new QueryMsgsParams(new ChatInfo(this.$chatType, this.$peerId), new ArrayList(), new ArrayList(), 0L, 0L, this.$requestCount, false, false);
                    final int i16 = this.$requestCount;
                    final PlatformSearchStickerSource platformSearchStickerSource = this.this$0;
                    final int i17 = this.$chatType;
                    final String str = this.$peerId;
                    e16.queryEmoticonMsgs(0L, 0L, 0L, queryMsgsParams, new IMsgOperateCallback() { // from class: com.tencent.qqnt.chathistory.ui.sticker.data.datasource.a
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                        public final void onResult(int i18, String str2, ArrayList arrayList) {
                            PlatformSearchStickerSource$getStickerData$1.b(i16, producerScope, platformSearchStickerSource, i17, str, i18, str2, arrayList);
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
    public final Object invoke2(@NotNull ProducerScope<? super List<SearchStickerItemModel>> producerScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((PlatformSearchStickerSource$getStickerData$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) producerScope, (Object) continuation);
    }
}
