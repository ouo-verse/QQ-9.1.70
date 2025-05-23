package com.tencent.mobileqq.matchfriend.reborn.content.main.matching.surprise;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.matchfriend.aio.sign.QQStrangerAIOSigUtil;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IMsgSendHelper;
import com.tencent.util.QQToastUtil;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.content.main.matching.surprise.QQStrangerSurpriseMatchingVM$sendTextMsg$1", f = "QQStrangerSurpriseMatchingVM.kt", i = {0, 0}, l = {87}, m = "invokeSuspend", n = {"msgSendHelper", "tinyId"}, s = {"L$0", "J$0"})
/* loaded from: classes33.dex */
final class QQStrangerSurpriseMatchingVM$sendTextMsg$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $content;
    final /* synthetic */ List<Long> $tinyIds;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerSurpriseMatchingVM$sendTextMsg$1(List<Long> list, String str, Continuation<? super QQStrangerSurpriseMatchingVM$sendTextMsg$1> continuation) {
        super(2, continuation);
        this.$tinyIds = list;
        this.$content = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QQStrangerSurpriseMatchingVM$sendTextMsg$1(this.$tinyIds, this.$content, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QQStrangerSurpriseMatchingVM$sendTextMsg$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00e2  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x00d7 -> B:5:0x00da). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        IMsgSendHelper iMsgSendHelper;
        Iterator it;
        String str;
        QQStrangerSurpriseMatchingVM$sendTextMsg$1 qQStrangerSurpriseMatchingVM$sendTextMsg$1;
        String str2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        String str3 = "QQStrangerSurpriseMatchingVM";
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            QLog.i("QQStrangerSurpriseMatchingVM", 1, "sendMsg tinyIds:" + this.$tinyIds + " content:" + this.$content);
            QRouteApi api = QRoute.api(IMsgSendHelper.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IMsgSendHelper::class.java)");
            List<Long> list = this.$tinyIds;
            String str4 = this.$content;
            iMsgSendHelper = (IMsgSendHelper) api;
            it = list.iterator();
            str = str4;
            qQStrangerSurpriseMatchingVM$sendTextMsg$1 = this;
            if (it.hasNext()) {
            }
        } else if (i3 == 1) {
            long j3 = this.J$0;
            it = (Iterator) this.L$2;
            str = (String) this.L$1;
            iMsgSendHelper = (IMsgSendHelper) this.L$0;
            ResultKt.throwOnFailure(obj);
            String str5 = "QQStrangerSurpriseMatchingVM";
            long j16 = j3;
            Object h16 = obj;
            qQStrangerSurpriseMatchingVM$sendTextMsg$1 = this;
            int intValue = ((Number) h16).intValue();
            if (intValue == 0) {
                str2 = str5;
                QLog.i(str2, 1, "sendMsg prepare temp chat error " + intValue);
            } else {
                str2 = str5;
            }
            iMsgSendHelper.sendText(String.valueOf(j16), 104, str);
            QLog.i(str2, 1, "sendMsg finish tinyId:" + j16);
            str3 = str2;
            if (it.hasNext()) {
                long longValue = ((Number) it.next()).longValue();
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
                if (qQAppInterface != null) {
                    QLog.i(str3, 1, "setFirstRelationOrigin tinyId:" + longValue);
                    str5 = str3;
                    j16 = longValue;
                    ((IMatchFriendRequest) QRoute.api(IMatchFriendRequest.class)).setFirstRelationOrigin(qQAppInterface, longValue, 11, "");
                } else {
                    str5 = str3;
                    j16 = longValue;
                }
                QQStrangerAIOSigUtil qQStrangerAIOSigUtil = QQStrangerAIOSigUtil.f243975a;
                qQStrangerSurpriseMatchingVM$sendTextMsg$1.L$0 = iMsgSendHelper;
                qQStrangerSurpriseMatchingVM$sendTextMsg$1.L$1 = str;
                qQStrangerSurpriseMatchingVM$sendTextMsg$1.L$2 = it;
                qQStrangerSurpriseMatchingVM$sendTextMsg$1.J$0 = j16;
                qQStrangerSurpriseMatchingVM$sendTextMsg$1.label = 1;
                h16 = qQStrangerAIOSigUtil.h(104, j16, qQStrangerSurpriseMatchingVM$sendTextMsg$1);
                if (h16 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                int intValue2 = ((Number) h16).intValue();
                if (intValue2 == 0) {
                }
                iMsgSendHelper.sendText(String.valueOf(j16), 104, str);
                QLog.i(str2, 1, "sendMsg finish tinyId:" + j16);
                str3 = str2;
                if (it.hasNext()) {
                    QQToastUtil.showQQToastInUiThread(2, "\u6d88\u606f\u53d1\u9001\u6210\u529f");
                    return Unit.INSTANCE;
                }
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
