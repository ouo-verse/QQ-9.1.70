package com.tencent.mobileqq.matchfriend.aio.quote;

import com.tencent.mobileqq.matchfriend.reborn.utils.QQStrangerCommonProxyRequest;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.kuolie.prompt.prompt.Prompt$GetAioInteractiveContentReq;
import com.tencent.trpcprotocol.kuolie.prompt.prompt.Prompt$GetAioInteractiveContentRsp;
import com.tencent.trpcprotocol.kuolie.prompt.prompt.Prompt$InteractiveOption;
import com.tencent.trpcprotocol.qqstranger.common_proxy.common_proxy.CommonProxyPB$ProxyRsp;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ3\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/quote/QQStrangerQuoteRepo;", "", "", "appId", "", "tinyId", "", "feedId", "Lcom/tencent/mobileqq/matchfriend/aio/quote/c;", "a", "(IJLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerQuoteRepo {
    /* JADX WARN: Removed duplicated region for block: B:68:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(int i3, long j3, String str, Continuation<? super QQStrangerQuoteData> continuation) {
        QQStrangerQuoteRepo$getQuoteData$1 qQStrangerQuoteRepo$getQuoteData$1;
        Object coroutine_suspended;
        int i16;
        CommonProxyPB$ProxyRsp commonProxyPB$ProxyRsp;
        PBStringField pBStringField;
        PBInt32Field pBInt32Field;
        int collectionSizeOrDefault;
        if (continuation instanceof QQStrangerQuoteRepo$getQuoteData$1) {
            qQStrangerQuoteRepo$getQuoteData$1 = (QQStrangerQuoteRepo$getQuoteData$1) continuation;
            int i17 = qQStrangerQuoteRepo$getQuoteData$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                qQStrangerQuoteRepo$getQuoteData$1.label = i17 - Integer.MIN_VALUE;
                QQStrangerQuoteRepo$getQuoteData$1 qQStrangerQuoteRepo$getQuoteData$12 = qQStrangerQuoteRepo$getQuoteData$1;
                Object obj = qQStrangerQuoteRepo$getQuoteData$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = qQStrangerQuoteRepo$getQuoteData$12.label;
                if (i16 != 0) {
                    ResultKt.throwOnFailure(obj);
                    QLog.d("QQStrangerQuoteRepo", 1, "[getQuoteData] request tinyId=" + j3 + " feedId=" + str);
                    Prompt$GetAioInteractiveContentReq prompt$GetAioInteractiveContentReq = new Prompt$GetAioInteractiveContentReq();
                    prompt$GetAioInteractiveContentReq.interactive_type.set(1);
                    if (!(str == null || str.length() == 0)) {
                        prompt$GetAioInteractiveContentReq.param.Interactive_object.set(str);
                    }
                    prompt$GetAioInteractiveContentReq.param.tinyid.set(j3);
                    prompt$GetAioInteractiveContentReq.param.setHasFlag(true);
                    QQStrangerCommonProxyRequest qQStrangerCommonProxyRequest = QQStrangerCommonProxyRequest.f245454a;
                    byte[] byteArray = prompt$GetAioInteractiveContentReq.toByteArray();
                    Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
                    qQStrangerQuoteRepo$getQuoteData$12.label = 1;
                    obj = qQStrangerCommonProxyRequest.a(i3, "QQStranger.prompt", "SsoGetAioInteractiveContent", byteArray, qQStrangerQuoteRepo$getQuoteData$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i16 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                commonProxyPB$ProxyRsp = (CommonProxyPB$ProxyRsp) obj;
                if (commonProxyPB$ProxyRsp == null && commonProxyPB$ProxyRsp.ret_code.get() == 0) {
                    Prompt$GetAioInteractiveContentRsp prompt$GetAioInteractiveContentRsp = new Prompt$GetAioInteractiveContentRsp();
                    try {
                        prompt$GetAioInteractiveContentRsp.mergeFrom(commonProxyPB$ProxyRsp.biz_buf.get().toByteArray());
                    } catch (Exception e16) {
                        QLog.e("QQStrangerQuoteRepo", 1, "[getQuoteData] mergeFrom exception: ", e16);
                    }
                    int i18 = prompt$GetAioInteractiveContentRsp.ret_code.get();
                    String str2 = prompt$GetAioInteractiveContentRsp.err_msg.get();
                    if (i18 != 0) {
                        QLog.e("QQStrangerQuoteRepo", 1, "[getQuoteData] ret_code=" + i18 + " err_msg=" + str2);
                        return null;
                    }
                    String str3 = prompt$GetAioInteractiveContentRsp.content.head.get();
                    String str4 = str3 == null ? "" : str3;
                    String str5 = prompt$GetAioInteractiveContentRsp.content.title.get();
                    String str6 = str5 == null ? "" : str5;
                    String str7 = prompt$GetAioInteractiveContentRsp.content.content.get();
                    String str8 = str7 == null ? "" : str7;
                    String str9 = prompt$GetAioInteractiveContentRsp.content.background.get();
                    String str10 = str9 == null ? "" : str9;
                    String str11 = prompt$GetAioInteractiveContentRsp.content.feed_id.get();
                    Intrinsics.checkNotNullExpressionValue(str11, "rsp.content.feed_id.get()");
                    List<Prompt$InteractiveOption> list = prompt$GetAioInteractiveContentRsp.options.get();
                    Intrinsics.checkNotNullExpressionValue(list, "rsp.options.get()");
                    List<Prompt$InteractiveOption> list2 = list;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    for (Prompt$InteractiveOption prompt$InteractiveOption : list2) {
                        int i19 = prompt$InteractiveOption.interactive_id.get();
                        String str12 = prompt$InteractiveOption.content.get();
                        if (str12 == null) {
                            str12 = "";
                        } else {
                            Intrinsics.checkNotNullExpressionValue(str12, "it.content.get() ?: \"\"");
                        }
                        arrayList.add(new QQStrangerQuoteAction(i19, str12));
                    }
                    QQStrangerQuoteData qQStrangerQuoteData = new QQStrangerQuoteData(str4, str6, str8, str10, str11, arrayList);
                    QLog.d("QQStrangerQuoteRepo", 1, "[getQuoteData] " + qQStrangerQuoteData);
                    return qQStrangerQuoteData;
                }
                QLog.e("QQStrangerQuoteRepo", 1, "[getQuoteData] proxy error, " + ((commonProxyPB$ProxyRsp != null || (pBInt32Field = commonProxyPB$ProxyRsp.ret_code) == null) ? null : Boxing.boxInt(pBInt32Field.get())) + " " + ((commonProxyPB$ProxyRsp != null || (pBStringField = commonProxyPB$ProxyRsp.ret_msg) == null) ? null : pBStringField.get()));
                return null;
            }
        }
        qQStrangerQuoteRepo$getQuoteData$1 = new QQStrangerQuoteRepo$getQuoteData$1(this, continuation);
        QQStrangerQuoteRepo$getQuoteData$1 qQStrangerQuoteRepo$getQuoteData$122 = qQStrangerQuoteRepo$getQuoteData$1;
        Object obj2 = qQStrangerQuoteRepo$getQuoteData$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = qQStrangerQuoteRepo$getQuoteData$122.label;
        if (i16 != 0) {
        }
        commonProxyPB$ProxyRsp = (CommonProxyPB$ProxyRsp) obj2;
        if (commonProxyPB$ProxyRsp == null) {
        }
        if (commonProxyPB$ProxyRsp != null) {
        }
        if (commonProxyPB$ProxyRsp != null) {
        }
        QLog.e("QQStrangerQuoteRepo", 1, "[getQuoteData] proxy error, " + ((commonProxyPB$ProxyRsp != null || (pBInt32Field = commonProxyPB$ProxyRsp.ret_code) == null) ? null : Boxing.boxInt(pBInt32Field.get())) + " " + ((commonProxyPB$ProxyRsp != null || (pBStringField = commonProxyPB$ProxyRsp.ret_msg) == null) ? null : pBStringField.get()));
        return null;
    }

    public static /* synthetic */ Object b(QQStrangerQuoteRepo qQStrangerQuoteRepo, int i3, long j3, String str, Continuation continuation, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 1;
        }
        int i17 = i3;
        if ((i16 & 4) != 0) {
            str = null;
        }
        return qQStrangerQuoteRepo.a(i17, j3, str, continuation);
    }
}
