package com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.data_source.message;

import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.MessageItem;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.MessageType;
import com.tencent.mobileqq.qqecommerce.repo.pbfile.msgDetail$MsgDetail;
import com.tencent.mobileqq.qqecommerce.repo.pbfile.msgDetail$SourceInfo;
import com.tencent.mobileqq.qqecommerce.repo.pbfile.sellerMsgReader$GetMsgListReq;
import com.tencent.mobileqq.qqecommerce.repo.pbfile.sellerMsgReader$GetMsgListRsp;
import com.tencent.mobileqq.qqecommerce.repo.pbfile.sellerMsgWriter$DeleteReq;
import com.tencent.mobileqq.qqecommerce.repo.pbfile.sellerMsgWriter$DeleteRsp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.json.JSONObject;
import wf2.NetworkResult;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0002*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J7\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/data/data_source/message/a;", "", "", "Lcom/tencent/mobileqq/qqecommerce/repo/pbfile/msgDetail$MsgDetail;", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/b;", "e", "", "cookie", "", "pageSize", "Lkotlin/Pair;", "Lwf2/a;", "c", "([BILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "messageId", "", "b", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\n\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\n\u00a2\u0006\u0004\b\n\u0010\u000b"}, d2 = {"", "isSuccess", "", "<anonymous parameter 1>", "Lorg/json/JSONObject;", "kotlin.jvm.PlatformType", "<anonymous parameter 2>", "Ltencent/trpcprotocol/b;", "response", "", "a", "(ZILorg/json/JSONObject;Ltencent/trpcprotocol/b;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    static final class b implements l52.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f263262a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Boolean> f263263b;

        /* JADX WARN: Multi-variable type inference failed */
        b(String str, CancellableContinuation<? super Boolean> cancellableContinuation) {
            this.f263262a = str;
            this.f263263b = cancellableContinuation;
        }

        @Override // l52.a
        public final void a(boolean z16, int i3, JSONObject jSONObject, tencent.trpcprotocol.b bVar) {
            boolean z17;
            if (z16) {
                if ((bVar != null ? bVar.f436079c : null) != null) {
                    sellerMsgWriter$DeleteRsp sellermsgwriter_deletersp = new sellerMsgWriter$DeleteRsp();
                    MessageMicro.mergeFrom(sellermsgwriter_deletersp, bVar.f436079c);
                    String str = sellermsgwriter_deletersp.msg_id.get();
                    z17 = Intrinsics.areEqual(str, this.f263262a);
                    QLog.d("ECMsgCenter|MessageRemoteDataSource", 2, "deleteMessage: " + this.f263262a + " isSuccess: " + z17 + ", retMsgId: " + str);
                    CancellableContinuation<Boolean> cancellableContinuation = this.f263263b;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(Boolean.valueOf(z17)));
                }
            }
            QLog.e("ECMsgCenter|MessageRemoteDataSource", 1, "deleteMessage: " + this.f263262a + " failed. isSuccess: " + z16 + ", errorCode: " + (bVar != null ? Integer.valueOf(bVar.f436077a) : null));
            z17 = false;
            CancellableContinuation<Boolean> cancellableContinuation2 = this.f263263b;
            Result.Companion companion2 = Result.INSTANCE;
            cancellableContinuation2.resumeWith(Result.m476constructorimpl(Boolean.valueOf(z17)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\n\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\n\u00a2\u0006\u0004\b\n\u0010\u000b"}, d2 = {"", "isSuccess", "", "<anonymous parameter 1>", "Lorg/json/JSONObject;", "kotlin.jvm.PlatformType", "<anonymous parameter 2>", "Ltencent/trpcprotocol/b;", "response", "", "a", "(ZILorg/json/JSONObject;Ltencent/trpcprotocol/b;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements l52.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Pair<NetworkResult<MessageItem>, byte[]>> f263265b;

        /* JADX WARN: Multi-variable type inference failed */
        c(CancellableContinuation<? super Pair<NetworkResult<MessageItem>, byte[]>> cancellableContinuation) {
            this.f263265b = cancellableContinuation;
        }

        @Override // l52.a
        public final void a(boolean z16, int i3, JSONObject jSONObject, tencent.trpcprotocol.b bVar) {
            List emptyList;
            byte[] bArr;
            NetworkResult networkResult;
            if (z16) {
                if ((bVar != null ? bVar.f436079c : null) != null) {
                    sellerMsgReader$GetMsgListRsp sellermsgreader_getmsglistrsp = new sellerMsgReader$GetMsgListRsp();
                    MessageMicro.mergeFrom(sellermsgreader_getmsglistrsp, bVar.f436079c);
                    a aVar = a.this;
                    List<msgDetail$MsgDetail> list = sellermsgreader_getmsglistrsp.msg_details.get();
                    Intrinsics.checkNotNullExpressionValue(list, "rspParam.msg_details.get()");
                    networkResult = new NetworkResult(aVar.e(list), true, sellermsgreader_getmsglistrsp.is_end.get() == 1);
                    bArr = sellermsgreader_getmsglistrsp.cookie.get().toByteArray();
                    Intrinsics.checkNotNullExpressionValue(bArr, "rspParam.cookie.get().toByteArray()");
                    QLog.d("ECMsgCenter|MessageRemoteDataSource", 2, "fetchMessageList: succeed.");
                    CancellableContinuation<Pair<NetworkResult<MessageItem>, byte[]>> cancellableContinuation = this.f263265b;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(TuplesKt.to(networkResult, bArr)));
                }
            }
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            NetworkResult networkResult2 = new NetworkResult(emptyList, false, true);
            byte[] bArr2 = new byte[0];
            QLog.e("ECMsgCenter|MessageRemoteDataSource", 1, "fetchMessageList failed. isSuccess: " + z16 + ", errorCode: " + (bVar != null ? Integer.valueOf(bVar.f436077a) : null));
            bArr = bArr2;
            networkResult = networkResult2;
            CancellableContinuation<Pair<NetworkResult<MessageItem>, byte[]>> cancellableContinuation2 = this.f263265b;
            Result.Companion companion2 = Result.INSTANCE;
            cancellableContinuation2.resumeWith(Result.m476constructorimpl(TuplesKt.to(networkResult, bArr)));
        }
    }

    public final Object b(String str, Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        sellerMsgWriter$DeleteReq sellermsgwriter_deletereq = new sellerMsgWriter$DeleteReq();
        sellermsgwriter_deletereq.msg_id.set(str);
        ((IReadInJoyHelper) QRoute.api(IReadInJoyHelper.class)).ssoForward("trpc.ecom.seller_msg_writer.SellerMsgWriter", "/trpc.ecom.seller_msg_writer.SellerMsgWriter/Delete", sellermsgwriter_deletereq.toByteArray(), 1, (Map<Object, ? extends Object>) null, new b(str, cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final Object c(byte[] bArr, int i3, Continuation<? super Pair<NetworkResult<MessageItem>, byte[]>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        sellerMsgReader$GetMsgListReq sellermsgreader_getmsglistreq = new sellerMsgReader$GetMsgListReq();
        sellermsgreader_getmsglistreq.cookie.set(ByteStringMicro.copyFrom(bArr));
        sellermsgreader_getmsglistreq.size.set(i3);
        ((IReadInJoyHelper) QRoute.api(IReadInJoyHelper.class)).ssoForward("trpc.ecom.seller_msg_reader.SellerMsgReader", "/trpc.ecom.seller_msg_reader.SellerMsgReader/GetMsgList", sellermsgreader_getmsglistreq.toByteArray(), 1, (Map<Object, ? extends Object>) null, new c(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<MessageItem> e(List<msgDetail$MsgDetail> list) {
        int collectionSizeOrDefault;
        List<msgDetail$MsgDetail> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (msgDetail$MsgDetail msgdetail_msgdetail : list2) {
            msgDetail$SourceInfo msgdetail_sourceinfo = msgdetail_msgdetail.src_info.get();
            String str = msgdetail_msgdetail.f263436id.get();
            Intrinsics.checkNotNullExpressionValue(str, "it.id.get()");
            long j3 = msgdetail_msgdetail.receiver.uin.get();
            int i3 = msgdetail_sourceinfo.type.get();
            String str2 = msgdetail_sourceinfo.type_name.get();
            Intrinsics.checkNotNullExpressionValue(str2, "sourceInfo.type_name.get()");
            MessageType messageType = new MessageType(i3, str2);
            String str3 = msgdetail_msgdetail.src_info.icon.get();
            Intrinsics.checkNotNullExpressionValue(str3, "it.src_info.icon.get()");
            String str4 = msgdetail_sourceinfo.src_name.get();
            Intrinsics.checkNotNullExpressionValue(str4, "sourceInfo.src_name.get()");
            String str5 = msgdetail_msgdetail.title.get();
            Intrinsics.checkNotNullExpressionValue(str5, "it.title.get()");
            String str6 = msgdetail_msgdetail.brief.get();
            Intrinsics.checkNotNullExpressionValue(str6, "it.brief.get()");
            String str7 = msgdetail_msgdetail.content.get();
            Intrinsics.checkNotNullExpressionValue(str7, "it.content.get()");
            String str8 = msgdetail_msgdetail.jump_url.get();
            Intrinsics.checkNotNullExpressionValue(str8, "it.jump_url.get()");
            long j16 = 1000 * msgdetail_msgdetail.create_time.get();
            String str9 = msgdetail_msgdetail.cover.url.get();
            Intrinsics.checkNotNullExpressionValue(str9, "it.cover.url.get()");
            arrayList.add(new MessageItem(str, j3, messageType, str3, str4, str5, str6, str7, str8, j16, str9, com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.data_source.message.b.a(msgdetail_msgdetail.style.get())));
        }
        return arrayList;
    }

    public static /* synthetic */ Object d(a aVar, byte[] bArr, int i3, Continuation continuation, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 10;
        }
        return aVar.c(bArr, i3, continuation);
    }
}
