package com.tencent.mobileqq.zplan.emoticon.grayTip;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.f;
import com.tencent.mobileqq.graytip.g;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import ih3.b;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0013\u0010\r\u001a\u00020\fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0011\u001a\u00070\u000f\u00a2\u0006\u0002\b\u0010H\u0002J$\u0010\u0014\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/grayTip/ZPlanEmoticonGrayTipManager;", "", "Lcom/tencent/mobileqq/data/MessageRecord;", "message", "Lcom/tencent/mobileqq/activity/aio/p;", "sessionInfo", "Lcom/tencent/mobileqq/zplan/emoticon/grayTip/ZPlanEmoticonGrayTipManager$a;", "listener", "", "c", "", "e", "", "b", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lcom/tencent/mobileqq/zplan/emoticon/grayTip/ZPlanEmoticonGrayTipTABGroup;", "d", "Lcom/tencent/common/app/AppInterface;", "app", "f", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanEmoticonGrayTipManager {

    /* renamed from: a, reason: collision with root package name */
    public static final ZPlanEmoticonGrayTipManager f333111a = new ZPlanEmoticonGrayTipManager();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/grayTip/ZPlanEmoticonGrayTipManager$a;", "", "Lcom/tencent/mobileqq/graytip/g;", "grayTipsParam", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface a {
        void a(g grayTipsParam);
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/emoticon/grayTip/ZPlanEmoticonGrayTipManager$b", "Lcom/tencent/mobileqq/zplan/emoticon/grayTip/ZPlanEmoticonGrayTipManager$a;", "Lcom/tencent/mobileqq/graytip/g;", "grayTipsParam", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppInterface f333112a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ p f333113b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ MessageRecord f333114c;

        b(AppInterface appInterface, p pVar, MessageRecord messageRecord) {
            this.f333112a = appInterface;
            this.f333113b = pVar;
            this.f333114c = messageRecord;
        }

        @Override // com.tencent.mobileqq.zplan.emoticon.grayTip.ZPlanEmoticonGrayTipManager.a
        public void a(g grayTipsParam) {
            if (grayTipsParam == null) {
                QLog.e("ZPlanEmoticonGrayTipHelper", 1, "getGrayTipParam result null.");
                return;
            }
            MessageForUniteGrayTip messageForUniteGrayTip = new MessageForUniteGrayTip();
            AppInterface appInterface = this.f333112a;
            MessageRecord messageRecord = this.f333114c;
            messageForUniteGrayTip.initGrayTipMsg(appInterface, grayTipsParam);
            messageForUniteGrayTip.msgtype = MessageRecord.MSG_TYPE_UNITE_TAB_HISTORI_INVI;
            messageForUniteGrayTip.shmsgseq = messageRecord.shmsgseq;
            QLog.i("ZPlanEmoticonGrayTipHelper", 1, "do add gray tip msg.");
            f.a(this.f333112a, messageForUniteGrayTip);
            ih3.b.f407666a.d(new b.GrayTipsReportConfig(grayTipsParam.f213688k.getInt("zplan_emoticon_gray_tips_action_type", -1) == 77, this.f333113b.f179555d, "imp"));
        }
    }

    ZPlanEmoticonGrayTipManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object b(Continuation<? super Integer> continuation) {
        ZPlanEmoticonGrayTipManager$getGrayTipClickActionType$1 zPlanEmoticonGrayTipManager$getGrayTipClickActionType$1;
        Object obj;
        Object coroutine_suspended;
        int i3;
        ZPlanEmoticonGrayTipManager zPlanEmoticonGrayTipManager;
        int i16;
        if (continuation instanceof ZPlanEmoticonGrayTipManager$getGrayTipClickActionType$1) {
            zPlanEmoticonGrayTipManager$getGrayTipClickActionType$1 = (ZPlanEmoticonGrayTipManager$getGrayTipClickActionType$1) continuation;
            int i17 = zPlanEmoticonGrayTipManager$getGrayTipClickActionType$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                zPlanEmoticonGrayTipManager$getGrayTipClickActionType$1.label = i17 - Integer.MIN_VALUE;
                obj = zPlanEmoticonGrayTipManager$getGrayTipClickActionType$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanEmoticonGrayTipManager$getGrayTipClickActionType$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IZPlanDataHelper iZPlanDataHelper = (IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class);
                    zPlanEmoticonGrayTipManager$getGrayTipClickActionType$1.L$0 = this;
                    zPlanEmoticonGrayTipManager$getGrayTipClickActionType$1.label = 1;
                    obj = iZPlanDataHelper.checkCreatedRole(zPlanEmoticonGrayTipManager$getGrayTipClickActionType$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    zPlanEmoticonGrayTipManager = this;
                } else if (i3 == 1) {
                    zPlanEmoticonGrayTipManager = (ZPlanEmoticonGrayTipManager) zPlanEmoticonGrayTipManager$getGrayTipClickActionType$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (!((Boolean) obj).booleanValue()) {
                    return Boxing.boxInt(77);
                }
                String d16 = zPlanEmoticonGrayTipManager.d();
                if (Intrinsics.areEqual(d16, ZPlanEmoticonGrayTipTABGroup.OPEN_EMOTICON_PANEL)) {
                    i16 = 71;
                } else {
                    i16 = Intrinsics.areEqual(d16, ZPlanEmoticonGrayTipTABGroup.CREATE_ROLE) ? 76 : -1;
                }
                return Boxing.boxInt(i16);
            }
        }
        zPlanEmoticonGrayTipManager$getGrayTipClickActionType$1 = new ZPlanEmoticonGrayTipManager$getGrayTipClickActionType$1(this, continuation);
        obj = zPlanEmoticonGrayTipManager$getGrayTipClickActionType$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanEmoticonGrayTipManager$getGrayTipClickActionType$1.label;
        if (i3 != 0) {
        }
        if (!((Boolean) obj).booleanValue()) {
        }
    }

    private final void c(MessageRecord message, p sessionInfo, a listener) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ZPlanEmoticonGrayTipManager$getGrayTipParam$1(listener, message, sessionInfo, null), 3, null);
    }

    private final String d() {
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(ZPlanEmoticonGrayTipTABGroup.TAB_NAME);
        Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance().getExpEntity(TAB_NAME)");
        expEntity.reportExpExposure();
        String it = expEntity.getAssignment();
        if (!Intrinsics.areEqual(it, ZPlanEmoticonGrayTipTABGroup.OPEN_EMOTICON_PANEL) && !Intrinsics.areEqual(it, ZPlanEmoticonGrayTipTABGroup.CREATE_ROLE)) {
            return ZPlanEmoticonGrayTipTABGroup.CONTRAST;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        return it;
    }

    private final boolean e() {
        JSONObject zPlanEmoticonGrayTipsMMKV = ((IZPlanApi) QRoute.api(IZPlanApi.class)).getZPlanEmoticonGrayTipsMMKV();
        wk3.g zPlanEmoticonGrayTipsConfig = ZPlanQQMC.INSTANCE.getZPlanEmoticonGrayTipsConfig();
        try {
            if (zPlanEmoticonGrayTipsMMKV == null) {
                QLog.d("ZPlanEmoticonGrayTipHelper", 1, "needShowGrayTips false, statusInfo invalid.");
                return false;
            }
            if (zPlanEmoticonGrayTipsMMKV.optBoolean("has_clicked", false) || zPlanEmoticonGrayTipsMMKV.optInt("shown_times", 0) >= zPlanEmoticonGrayTipsConfig.getAppearanceTimeThreshold() || System.currentTimeMillis() - zPlanEmoticonGrayTipsMMKV.optLong("last_time_stamp", 0L) < zPlanEmoticonGrayTipsConfig.getRequestInterval()) {
                return false;
            }
            zPlanEmoticonGrayTipsMMKV.put("shown_times", zPlanEmoticonGrayTipsMMKV.optInt("shown_times", 0) + 1);
            zPlanEmoticonGrayTipsMMKV.put("last_time_stamp", System.currentTimeMillis());
            IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
            String jSONObject = zPlanEmoticonGrayTipsMMKV.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "currGrayTipsMMKV.toString()");
            iZPlanApi.setZPlanEmoticonGrayTipsMMKV(jSONObject);
            QLog.i("ZPlanEmoticonGrayTipHelper", 1, "needShowGrayTips true.");
            return true;
        } catch (Throwable th5) {
            QLog.e("ZPlanEmoticonGrayTipHelper", 1, "check needShowGrayTips failed.", th5);
            return false;
        }
    }

    public final void f(MessageRecord message, p sessionInfo, AppInterface app) {
        if (message == null || sessionInfo == null || app == null || message.isSend() || !e()) {
            return;
        }
        QLog.i("ZPlanEmoticonGrayTipHelper", 1, "start try show GrayTip");
        c(message, sessionInfo, new b(app, sessionInfo, message));
    }
}
