package com.tencent.mobileqq.zplan.emoticon.grayTip;

import android.content.Context;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.event.EmotionPanelMsgIntent;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC;
import com.tencent.mvi.base.route.j;
import com.tencent.qphone.base.util.QLog;
import ih3.b;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import tl.h;
import wk3.g;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ \u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\r\u0010\u000f\u001a\u00070\u0006\u00a2\u0006\u0002\b\u000eH\u0002J\u001a\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J \u0010\u0018\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/grayTip/ZPlanEmoticonGrayTipNTHelper;", "", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlin/Pair;", "", "", "g", "", "i", "chatType", "friendUin", "", "f", "Lcom/tencent/mobileqq/zplan/emoticon/grayTip/ZPlanEmoticonGrayTipTABGroup;", h.F, "Landroid/content/Context;", "context", "Lgv3/a;", "aioAbility", "d", "j", VipFunCallConstants.KEY_GROUP, "e", "k", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanEmoticonGrayTipNTHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final ZPlanEmoticonGrayTipNTHelper f333115a = new ZPlanEmoticonGrayTipNTHelper();

    ZPlanEmoticonGrayTipNTHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(int chatType, String friendUin) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ZPlanEmoticonGrayTipNTHelper$doShowZPlanEmoticonGrayTips$1(friendUin, chatType, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String h() {
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

    private final boolean i() {
        JSONObject zPlanEmoticonGrayTipsMMKV = ((IZPlanApi) QRoute.api(IZPlanApi.class)).getZPlanEmoticonGrayTipsMMKV();
        g zPlanEmoticonGrayTipsConfig = ((IZPlanQQMC) QRoute.api(IZPlanQQMC.class)).getZPlanEmoticonGrayTipsConfig();
        try {
            if (zPlanEmoticonGrayTipsMMKV == null) {
                QLog.d("ZPlanEmoticonGrayTipNTHelper", 1, "needShowGrayTips false, statusInfo invalid.");
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
            QLog.i("ZPlanEmoticonGrayTipNTHelper", 1, "needShowGrayTips true.");
            return true;
        } catch (Throwable th5) {
            QLog.e("ZPlanEmoticonGrayTipNTHelper", 1, "check needShowGrayTips failed.", th5);
            return false;
        }
    }

    public final void e(String group, gv3.a aioAbility) {
        com.tencent.aio.api.runtime.a a16;
        Intrinsics.checkNotNullParameter(group, "group");
        boolean z16 = true;
        QLog.i("ZPlanEmoticonGrayTipNTHelper", 1, "clickOpenZPlanEmoticon");
        if (aioAbility == null || (a16 = aioAbility.a()) == null) {
            return;
        }
        int e16 = a16.g().r().c().e();
        j e17 = a16.e();
        if (e17 != null) {
            e17.h(new EmotionPanelMsgIntent.SetEmotionPanelDefaultType(17));
            e17.h(new PanelContainerMsgIntent.ShowPanelMsgIntent("ZPlanEmoticonGrayTipNTHelper", 1001, false, 0, 12, null));
        }
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).refreshZPlanEmoticonGrayTipsMMKVIfNeed();
        if (!Intrinsics.areEqual(group, ZPlanEmoticonGrayTipTABGroup.HAS_CREATED_ROLE) && !Intrinsics.areEqual(group, ZPlanEmoticonGrayTipTABGroup.CREATE_ROLE)) {
            z16 = false;
        }
        ih3.b.f407666a.d(new b.GrayTipsReportConfig(z16, e16, "click"));
    }

    public final void j(com.tencent.aio.api.runtime.a aioContext) {
        Pair<Integer, String> g16;
        CoroutineScope f16;
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        if (((IZPlanQQMC) QRoute.api(IZPlanQQMC.class)).getZPlanEmoticonGrayTipsConfig().getEnableEmoticonGrayTips() && (g16 = g(aioContext)) != null) {
            int intValue = g16.component1().intValue();
            String component2 = g16.component2();
            if (i() && (f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.c.f261781e)) != null) {
                CorountineFunKt.e(f16, "ZPlanEmoticonGrayTipNTHelper_isZPlanAccessible", null, null, null, new ZPlanEmoticonGrayTipNTHelper$showGrayTip$1(intValue, component2, null), 14, null);
            }
        }
    }

    public final void k(Context context, String group, gv3.a aioAbility) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(group, "group");
        QLog.i("ZPlanEmoticonGrayTipNTHelper", 1, "ZPlanEmoticonGrayTips clicked, action: ACTION_JUMP_CREATE_ROLE");
        ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).getIsInAlreadyCreatedRolePackage(new a(group, aioAbility, context));
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/emoticon/grayTip/ZPlanEmoticonGrayTipNTHelper$a", "Lcom/tencent/mobileqq/zplan/persistent/api/IZPlanDataHelper$a;", "", "isInPackage", "", "onResult", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements IZPlanDataHelper.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f333116a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ gv3.a f333117b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f333118c;

        a(String str, gv3.a aVar, Context context) {
            this.f333116a = str;
            this.f333117b = aVar;
            this.f333118c = context;
        }

        @Override // com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper.a
        public void onResult(int isInPackage) {
            if (isInPackage != 1) {
                ZPlanEmoticonGrayTipNTHelper.f333115a.d(this.f333118c, this.f333117b);
            } else {
                ZPlanEmoticonGrayTipNTHelper.f333115a.e(this.f333116a, this.f333117b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(Context context, gv3.a aioAbility) {
        Pair<Integer, String> g16 = g(aioAbility != null ? aioAbility.a() : null);
        if (g16 == null) {
            return;
        }
        int intValue = g16.component1().intValue();
        String emoticonGrayTipsCreateRoleScheme = ((IZPlanApi) QRoute.api(IZPlanApi.class)).getEmoticonGrayTipsCreateRoleScheme(g16.component2());
        if (emoticonGrayTipsCreateRoleScheme.length() > 0) {
            ((IZPlanApi) QRoute.api(IZPlanApi.class)).launchScheme(context, emoticonGrayTipsCreateRoleScheme);
            ((IZPlanApi) QRoute.api(IZPlanApi.class)).refreshZPlanEmoticonGrayTipsMMKVIfNeed();
        }
        ih3.b.f407666a.d(new b.GrayTipsReportConfig(false, intValue, "click"));
    }

    private final Pair<Integer, String> g(com.tencent.aio.api.runtime.a aioContext) {
        if (aioContext == null) {
            QLog.e("ZPlanEmoticonGrayTipNTHelper", 1, "getChatInfoFromAIOContext failed, aioContext null.");
            return null;
        }
        int e16 = aioContext.g().r().c().e();
        String friendUin = su3.b.b(aioContext.g().r()).f179557e;
        Intrinsics.checkNotNullExpressionValue(friendUin, "friendUin");
        if (friendUin.length() == 0) {
            return null;
        }
        return new Pair<>(Integer.valueOf(e16), friendUin);
    }
}
