package com.tencent.qqnt.ntrelation.zoneinfo.api.impl;

import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.friend.api.IFriendExtensionService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.e;
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
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.ntrelation.zoneinfo.api.impl.QQZoneInfoApiImpl$deleteZoneDetailInfo$1$1", f = "QQZoneInfoApiImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
final class QQZoneInfoApiImpl$deleteZoneDetailInfo$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppRuntime $app;
    final /* synthetic */ hx3.a<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> $iDeleteGeneralDataCallback;
    final /* synthetic */ String $it;
    final /* synthetic */ String $trace;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQZoneInfoApiImpl$deleteZoneDetailInfo$1$1(AppRuntime appRuntime, String str, hx3.a<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> aVar, String str2, Continuation<? super QQZoneInfoApiImpl$deleteZoneDetailInfo$1$1> continuation) {
        super(2, continuation);
        this.$app = appRuntime;
        this.$it = str;
        this.$iDeleteGeneralDataCallback = aVar;
        this.$trace = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QQZoneInfoApiImpl$deleteZoneDetailInfo$1$1(this.$app, this.$it, this.$iDeleteGeneralDataCallback, this.$trace, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            IRuntimeService runtimeService = this.$app.getRuntimeService(IFriendDataService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IF\u2026va, ProcessConstant.MAIN)");
            IRuntimeService runtimeService2 = this.$app.getRuntimeService(IFriendExtensionService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService2, "app.getRuntimeService(\n \u2026                        )");
            ((IFriendDataService) runtimeService).deleteFriend(this.$it);
            ((IFriendExtensionService) runtimeService2).deleteExtensionInfo(this.$it);
            hx3.a<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> aVar = this.$iDeleteGeneralDataCallback;
            if (aVar != null) {
                aVar.a(new e<>());
            }
            QLog.i(QQZoneInfoApiImpl.TAG, 1, "deleteZoneDetailInfo " + this.$trace + "  finish \n");
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QQZoneInfoApiImpl$deleteZoneDetailInfo$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
