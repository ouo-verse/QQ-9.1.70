package com.tencent.mobileqq.zplan.aigc.helper;

import com.tencent.mobileqq.zplan.aigc.p011const.ZPlanAIGCStatusCode;
import com.tencent.mobileqq.zplan.servlet.ZPlanAIGCRequest;
import com.tencent.qphone.base.util.QLog;
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
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlinx.coroutines.CoroutineScope;
import nk3.b;
import sg3.ZPlanCosUGCAvatarKeyInfo;
import sg3.ZplanCreateAIGCResponseInfo;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.helper.AIGCCreatePublishHelper$triggerPublish$1", f = "AIGCCreatePublishHelper.kt", i = {0}, l = {65, 110}, m = "invokeSuspend", n = {"isUpload"}, s = {"I$0"})
/* loaded from: classes35.dex */
public final class AIGCCreatePublishHelper$triggerPublish$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ nk3.b $callback;
    final /* synthetic */ String $desc;
    final /* synthetic */ boolean $isOfficial;
    final /* synthetic */ long $itemId;
    final /* synthetic */ String $name;
    final /* synthetic */ String $prompt;
    final /* synthetic */ int $shareType;
    final /* synthetic */ long $ugcId;
    final /* synthetic */ List<yv4.a> $uploadCosFileHeaderInfoList;
    final /* synthetic */ List<String> $uploadCosFileList;
    int I$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIGCCreatePublishHelper$triggerPublish$1(List<yv4.a> list, long j3, long j16, String str, String str2, nk3.b bVar, List<String> list2, boolean z16, String str3, int i3, Continuation<? super AIGCCreatePublishHelper$triggerPublish$1> continuation) {
        super(2, continuation);
        this.$uploadCosFileHeaderInfoList = list;
        this.$ugcId = j3;
        this.$itemId = j16;
        this.$name = str;
        this.$desc = str2;
        this.$callback = bVar;
        this.$uploadCosFileList = list2;
        this.$isOfficial = z16;
        this.$prompt = str3;
        this.$shareType = i3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AIGCCreatePublishHelper$triggerPublish$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AIGCCreatePublishHelper$triggerPublish$1(this.$uploadCosFileHeaderInfoList, this.$ugcId, this.$itemId, this.$name, this.$desc, this.$callback, this.$uploadCosFileList, this.$isOfficial, this.$prompt, this.$shareType, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e0  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        int i3;
        Object m3;
        String str;
        Object h16;
        Throwable th5;
        nk3.b bVar;
        ZplanCreateAIGCResponseInfo zplanCreateAIGCResponseInfo;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        int i17 = 1;
        try {
            if (i16 == 0) {
                ResultKt.throwOnFailure(obj);
                ZPlanAIGCRequest zPlanAIGCRequest = ZPlanAIGCRequest.f335341a;
                Object[] array = this.$uploadCosFileHeaderInfoList.toArray(new yv4.a[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                yv4.a[] aVarArr = (yv4.a[]) array;
                long j3 = this.$ugcId;
                long j16 = this.$itemId;
                String str2 = this.$name;
                String str3 = this.$desc;
                this.I$0 = 1;
                this.label = 1;
                i3 = 1;
                try {
                    m3 = zPlanAIGCRequest.m(aVarArr, j3, j16, str2, str3, this);
                    if (m3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    i17 = 1;
                } catch (Throwable th6) {
                    th = th6;
                    QLog.e("AIGCCreatePublishHelper", i3, "[triggerPublish]requestPreCreateAIGC failed.", th);
                    String th7 = th.toString();
                    String str4 = "";
                    if ((th7.length() > 0 ? i3 : 0) != 0) {
                        MatchResult find$default = Regex.find$default(new Regex("aigcPreCreateErrToastMsg:(.+)"), th7, 0, 2, null);
                        List<String> groupValues = find$default != null ? find$default.getGroupValues() : null;
                        if (groupValues != null && groupValues.size() >= 2) {
                            str4 = groupValues.get(i3);
                        }
                    }
                    nk3.b bVar2 = this.$callback;
                    if (bVar2 != null) {
                        bVar2.a(ZPlanAIGCStatusCode.PRECREATE_AIGC_FAILED, str4);
                    }
                    return Unit.INSTANCE;
                }
            } else {
                if (i16 != 1) {
                    if (i16 == 2) {
                        try {
                            ResultKt.throwOnFailure(obj);
                            h16 = obj;
                            i3 = 1;
                            str = null;
                            zplanCreateAIGCResponseInfo = (ZplanCreateAIGCResponseInfo) h16;
                            if (zplanCreateAIGCResponseInfo != null) {
                                QLog.e("AIGCCreatePublishHelper", i3, "[triggerPublish] requestCreateAIGC failed.");
                                nk3.b bVar3 = this.$callback;
                                if (bVar3 != null) {
                                    b.a.a(bVar3, ZPlanAIGCStatusCode.CREATE_AIGC_FAILED, str, 2, str);
                                }
                                return Unit.INSTANCE;
                            }
                            nk3.b bVar4 = this.$callback;
                            if (bVar4 != null) {
                                bVar4.onSuccess(zplanCreateAIGCResponseInfo.getCouponCount());
                            }
                            return Unit.INSTANCE;
                        } catch (Throwable th8) {
                            th5 = th8;
                            i3 = 1;
                            str = null;
                            QLog.e("AIGCCreatePublishHelper", i3, "[triggerPublish] requestCreateAIGC failed.", th5);
                            bVar = this.$callback;
                            if (bVar != null) {
                                b.a.a(bVar, ZPlanAIGCStatusCode.CREATE_AIGC_FAILED, str, 2, str);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i18 = this.I$0;
                ResultKt.throwOnFailure(obj);
                i3 = 1;
                i17 = i18;
                m3 = obj;
            }
            ZPlanCosUGCAvatarKeyInfo zPlanCosUGCAvatarKeyInfo = (ZPlanCosUGCAvatarKeyInfo) m3;
            if (zPlanCosUGCAvatarKeyInfo == null) {
                QLog.e("AIGCCreatePublishHelper", i3, "[triggerPublish]requestPreCreateAIGC failed.");
                nk3.b bVar5 = this.$callback;
                if (bVar5 != null) {
                    b.a.a(bVar5, ZPlanAIGCStatusCode.PRECREATE_AIGC_FAILED, null, 2, null);
                }
                return Unit.INSTANCE;
            }
            str = null;
            if (!tg3.a.f436326a.h(this.$uploadCosFileList, zPlanCosUGCAvatarKeyInfo)) {
                QLog.e("AIGCCreatePublishHelper", i3, "[triggerPublish] upload to cos failed.");
                nk3.b bVar6 = this.$callback;
                if (bVar6 != null) {
                    b.a.a(bVar6, ZPlanAIGCStatusCode.UPLOAD_TO_COS_FAILED, null, 2, null);
                }
                return Unit.INSTANCE;
            }
            try {
                ZPlanAIGCRequest zPlanAIGCRequest2 = ZPlanAIGCRequest.f335341a;
                long j17 = this.$ugcId;
                boolean z16 = i17 != 0 ? i3 : 0;
                boolean z17 = this.$isOfficial;
                String str5 = this.$desc;
                String str6 = this.$prompt;
                int i19 = this.$shareType;
                this.label = 2;
                h16 = zPlanAIGCRequest2.h(j17, z16, z17, str5, str6, i19, this);
                if (h16 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                zplanCreateAIGCResponseInfo = (ZplanCreateAIGCResponseInfo) h16;
                if (zplanCreateAIGCResponseInfo != null) {
                }
            } catch (Throwable th9) {
                th5 = th9;
                QLog.e("AIGCCreatePublishHelper", i3, "[triggerPublish] requestCreateAIGC failed.", th5);
                bVar = this.$callback;
                if (bVar != null) {
                }
                return Unit.INSTANCE;
            }
        } catch (Throwable th10) {
            th = th10;
            i3 = i17;
        }
    }
}
