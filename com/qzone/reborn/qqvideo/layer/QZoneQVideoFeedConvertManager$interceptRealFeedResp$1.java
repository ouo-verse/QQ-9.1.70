package com.qzone.reborn.qqvideo.layer;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
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
import lc.i;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.qzone.reborn.qqvideo.layer.QZoneQVideoFeedConvertManager$interceptRealFeedResp$1", f = "QZoneQVideoFeedConvertManager.kt", i = {}, l = {49}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes37.dex */
public final class QZoneQVideoFeedConvertManager$interceptRealFeedResp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $clientKey;
    final /* synthetic */ com.qzone.proxy.feedcomponent.manager.d $fakeFeedLogic;
    final /* synthetic */ BusinessFeedData $feedData;
    final /* synthetic */ String $qzoneFeedid;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneQVideoFeedConvertManager$interceptRealFeedResp$1(String str, BusinessFeedData businessFeedData, com.qzone.proxy.feedcomponent.manager.d dVar, String str2, Continuation<? super QZoneQVideoFeedConvertManager$interceptRealFeedResp$1> continuation) {
        super(2, continuation);
        this.$qzoneFeedid = str;
        this.$feedData = businessFeedData;
        this.$fakeFeedLogic = dVar;
        this.$clientKey = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QZoneQVideoFeedConvertManager$interceptRealFeedResp$1(this.$qzoneFeedid, this.$feedData, this.$fakeFeedLogic, this.$clientKey, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            QZoneGetQQVideoFeedFeature qZoneGetQQVideoFeedFeature = new QZoneGetQQVideoFeedFeature();
            String str = this.$qzoneFeedid;
            Intrinsics.checkNotNull(str);
            this.label = 1;
            obj = qZoneGetQQVideoFeedFeature.n(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        RFWLog.d("upload2-QZoneQVideoFeedConvertManager", RFWLog.USR, "[interceptRealFeedResp] getFeedSucceed is:" + booleanValue + ",feedid:" + this.$qzoneFeedid);
        if (booleanValue) {
            this.$feedData.qqVideoFeedStatus = 1;
        } else {
            this.$feedData.qqVideoFeedStatus = 2;
        }
        com.qzone.proxy.feedcomponent.manager.d dVar = this.$fakeFeedLogic;
        if (dVar == null) {
            i.f414345a.o(this.$feedData, this.$clientKey, 1);
        } else {
            com.qzone.feed.business.service.d.t(dVar, this.$clientKey, this.$feedData);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QZoneQVideoFeedConvertManager$interceptRealFeedResp$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
