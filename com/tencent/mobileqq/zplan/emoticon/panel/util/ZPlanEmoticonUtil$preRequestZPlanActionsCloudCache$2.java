package com.tencent.mobileqq.zplan.emoticon.panel.util;

import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.zplan.model.ZPlanActionInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.zplan.meme.Priority;
import com.tencent.zplan.meme.action.MODE;
import com.tencent.zplan.record.ZPlanRecordResourceCenter;
import com.tencent.zplan.record.model.BatchRecordRequestParams;
import com.tencent.zplan.record.model.ReportConfig;
import com.tencent.zplan.record.model.Source;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.emoticon.panel.util.ZPlanEmoticonUtil$preRequestZPlanActionsCloudCache$2", f = "ZPlanEmoticonUtil.kt", i = {}, l = {TVKQQLiveAssetPlayerMsg.PLAYER_INFO_PROXY_AUTHENTICATION_FAILED, PlayerResources.ViewId.SWITCH_LANDSCAPE_BUTTON, PlayerResources.ViewId.SWITCH_LANDSCAPE_BUTTON}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class ZPlanEmoticonUtil$preRequestZPlanActionsCloudCache$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<ZPlanActionInfo> $actions;
    final /* synthetic */ int $height;
    final /* synthetic */ String $uin;
    final /* synthetic */ int $width;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanEmoticonUtil$preRequestZPlanActionsCloudCache$2(List<ZPlanActionInfo> list, String str, int i3, int i16, Continuation<? super ZPlanEmoticonUtil$preRequestZPlanActionsCloudCache$2> continuation) {
        super(2, continuation);
        this.$actions = list;
        this.$uin = str;
        this.$width = i3;
        this.$height = i16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZPlanEmoticonUtil$preRequestZPlanActionsCloudCache$2(this.$actions, this.$uin, this.$width, this.$height, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZPlanEmoticonUtil$preRequestZPlanActionsCloudCache$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00a7 A[RETURN] */
    /* JADX WARN: Type inference failed for: r14v4, types: [int] */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r14v8 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        boolean z16;
        Object j06;
        BatchRecordRequestParams n3;
        Object e16;
        boolean z17;
        ?? r142;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ZPlanEmoticonUtil zPlanEmoticonUtil = ZPlanEmoticonUtil.f333176e;
            List<ZPlanActionInfo> list = this.$actions;
            String str = this.$uin;
            MODE mode = MODE.FRAME;
            int i16 = this.$width;
            int i17 = this.$height;
            this.label = 1;
            z16 = true;
            j06 = zPlanEmoticonUtil.j0(list, str, mode, i16, i17, (r21 & 16) != 0 ? Priority.LOW : null, (r21 & 32) != 0 ? 0 : 2, (r21 & 64) != 0, this);
            if (j06 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        ResultKt.throwOnFailure(obj);
                        r142 = 1;
                        QLog.i("[zplan][ZPlanEmoticonUtil]", r142, "preRequestZPlanActionsCloudCache for count:" + this.$actions.size() + " finish");
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                e16 = obj;
                z17 = true;
                this.label = 3;
                r142 = z17;
                if (FlowKt.collect((Flow) e16, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                QLog.i("[zplan][ZPlanEmoticonUtil]", r142, "preRequestZPlanActionsCloudCache for count:" + this.$actions.size() + " finish");
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            j06 = obj;
            z16 = true;
        }
        n3 = r17.n((r36 & 1) != 0 ? r17.resourcesIds : null, (r36 & 2) != 0 ? r17.configs : null, (r36 & 4) != 0 ? r17.getTheme() : null, (r36 & 8) != 0 ? r17.getSender() : null, (r36 & 16) != 0 ? r17.getReceiver() : null, (r36 & 32) != 0 ? r17.getWidth() : 0, (r36 & 64) != 0 ? r17.getHeight() : 0, (r36 & 128) != 0 ? r17.getMode() : null, (r36 & 256) != 0 ? r17.getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String() : null, (r36 & 512) != 0 ? r17.getScene() : 0, (r36 & 1024) != 0 ? r17.getPriority() : null, (r36 & 2048) != 0 ? r17.getUploadConfig() : null, (r36 & 4096) != 0 ? r17.getExpireConfig() : null, (r36 & 8192) != 0 ? r17.getReqFrom() : 0, (r36 & 16384) != 0 ? r17.getDownloadFromNetIfLocalAbsent() : false, (r36 & 32768) != 0 ? r17.getCom.tencent.mobileqq.activity.QQBrowserActivity.APP_PARAM java.lang.String() : null, (r36 & 65536) != 0 ? ((BatchRecordRequestParams) j06).getReportConfig() : new ReportConfig(z16));
        ZPlanRecordResourceCenter zPlanRecordResourceCenter = ZPlanRecordResourceCenter.f386003a;
        List<Source> plus = Source.LOCAL_CACHE.plus(Source.CLOUD_CACHE);
        this.label = 2;
        e16 = zPlanRecordResourceCenter.e(n3, plus, this);
        z17 = z16;
        if (e16 == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.label = 3;
        r142 = z17;
        if (FlowKt.collect((Flow) e16, this) == coroutine_suspended) {
        }
        QLog.i("[zplan][ZPlanEmoticonUtil]", r142, "preRequestZPlanActionsCloudCache for count:" + this.$actions.size() + " finish");
        return Unit.INSTANCE;
    }
}
