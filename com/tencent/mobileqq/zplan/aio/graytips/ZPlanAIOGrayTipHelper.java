package com.tencent.mobileqq.zplan.aio.graytips;

import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zplan.api.IZPlanAIOGrayTipApi;
import com.tencent.mobileqq.zplan.api.IZPlanShowGuideApi;
import com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.graytips.api.INtGrayTipApi;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006R\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/graytips/ZPlanAIOGrayTipHelper;", "", "", "d", "friendUin", "f", "Lcom/tencent/mobileqq/zplan/api/IZPlanAIOGrayTipApi$a;", "info", "", "g", "Lcom/tencent/qqnt/graytips/api/INtGrayTipApi;", "b", "Lkotlin/Lazy;", "e", "()Lcom/tencent/qqnt/graytips/api/INtGrayTipApi;", "grayTipApi", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanAIOGrayTipHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final ZPlanAIOGrayTipHelper f331022a = new ZPlanAIOGrayTipHelper();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy grayTipApi;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<INtGrayTipApi>() { // from class: com.tencent.mobileqq.zplan.aio.graytips.ZPlanAIOGrayTipHelper$grayTipApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final INtGrayTipApi invoke() {
                QRouteApi api = QRoute.api(INtGrayTipApi.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(INtGrayTipApi::class.java)");
                return (INtGrayTipApi) api;
            }
        });
        grayTipApi = lazy;
    }

    ZPlanAIOGrayTipHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String d() {
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        String j3;
        com.tencent.aio.api.runtime.a onGetAIOContext = ((IZPlanShowGuideApi) QRoute.api(IZPlanShowGuideApi.class)).onGetAIOContext();
        return (onGetAIOContext == null || (g16 = onGetAIOContext.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || (j3 = c16.j()) == null) ? "" : j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final INtGrayTipApi e() {
        return (INtGrayTipApi) grayTipApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String f(String friendUin) {
        return ((IZPlanShowGuideApi) QRoute.api(IZPlanShowGuideApi.class)).onGetCurrentNickname(friendUin);
    }

    public final void g(IZPlanAIOGrayTipApi.GrayTipInfo info) {
        IZPlanAIOGrayTipApi.GrayTipType grayTipType;
        Intrinsics.checkNotNullParameter(info, "info");
        if (PadUtil.a(BaseApplication.getContext()) == DeviceType.TABLET) {
            return;
        }
        boolean coupleAvatarSwitchState = ((IZPlanCoupleSceneHelper) QRoute.api(IZPlanCoupleSceneHelper.class)).getCoupleAvatarSwitchState(info.getFriendUin());
        if (coupleAvatarSwitchState) {
            grayTipType = IZPlanAIOGrayTipApi.GrayTipType.SWITCH_SCENE;
        } else {
            grayTipType = IZPlanAIOGrayTipApi.GrayTipType.OPEN_GUIDE_DIALOG;
        }
        info.e(grayTipType);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ZPlanAIOGrayTipHelper$showGrayTip$1(info, coupleAvatarSwitchState, null), 3, null);
    }
}
