package o61;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.item.l;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.utils.PokeBigResHandler;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.earlydownload.handler.PokeResHandler;
import com.tencent.mobileqq.earlydownload.handler.b;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.pluspanel.logic.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J(\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J<\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0014\u001a\u00020\nH\u0016\u00a8\u0006\u0018"}, d2 = {"Lo61/a;", "Lcom/tencent/qqnt/pluspanel/logic/c;", "", "a", "", "c", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "aid", "", "payId", "payType", "b", "Lcom/tencent/common/app/AppInterface;", "qqApp", "resId", "name", VipFunCallConstants.KEY_FEET_TYPE, "minVersion", IProfileCardConst.KEY_FROM_TYPE, "d", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements c {
    @Override // com.tencent.qqnt.pluspanel.logic.c
    public boolean a() {
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IEarlyDownloadService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService<IE\u2026nstant.MAIN\n            )");
        b earlyHandler = ((IEarlyDownloadService) runtimeService).getEarlyHandler("qq.android.poke.res_0625");
        Intrinsics.checkNotNull(earlyHandler, "null cannot be cast to non-null type com.tencent.mobileqq.earlydownload.handler.PokeResHandler");
        PokeResHandler pokeResHandler = (PokeResHandler) earlyHandler;
        if (pokeResHandler.A()) {
            return true;
        }
        pokeResHandler.M();
        if (!QLog.isColorLevel()) {
            return true;
        }
        QLog.d(l.f179480a, 2, "vas poke config exists, do not download, set ready");
        return true;
    }

    @Override // com.tencent.qqnt.pluspanel.logic.c
    public void c() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        AppInterface appInterface = (AppInterface) peekAppRuntime;
        IRuntimeService runtimeService = appInterface.getRuntimeService(IEarlyDownloadService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IE\u2026va, ProcessConstant.MAIN)");
        b earlyHandler = ((IEarlyDownloadService) runtimeService).getEarlyHandler("qq.android.poke.res_0625");
        Intrinsics.checkNotNull(earlyHandler, "null cannot be cast to non-null type com.tencent.mobileqq.earlydownload.handler.PokeResHandler");
        BusinessHandler businessHandler = appInterface.getBusinessHandler(BusinessHandlerFactory.POKE_BIG_RES_HANDLER);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.app.utils.PokeBigResHandler");
        PokeBigResHandler pokeBigResHandler = (PokeBigResHandler) businessHandler;
        ((PokeResHandler) earlyHandler).I(true);
        if (PokeBigResHandler.L2()) {
            return;
        }
        pokeBigResHandler.Q2(true);
    }

    @Override // com.tencent.qqnt.pluspanel.logic.c
    public void d(AppInterface qqApp, int resId, String name, int feeType, String minVersion, int fromType) {
        Intrinsics.checkNotNullParameter(qqApp, "qqApp");
        Object businessHandler = qqApp.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler");
        ((com.tencent.mobileqq.apollo.handler.b) businessHandler).y0(resId, name, feeType, minVersion, fromType);
    }

    @Override // com.tencent.qqnt.pluspanel.logic.c
    public void b(Activity activity, String aid, int payId, int payType) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(aid, "aid");
        if (2 == payType) {
            VasH5PayUtil.openClubPay(activity, aid + payId, 3, "1450000515", "LTMCLUB", MobileQQ.sMobileQQ.getString(R.string.d2p), "");
            VasWebviewUtil.reportCommercialDrainage("", "poke", "vipTipClick", "", 0, 0, 0, "", String.valueOf(payId), "vip", "", "", "", "", 0, 0, 0, 0);
            return;
        }
        VasH5PayUtil.openClubPay(activity, aid + payId, 3, "1450000516", "CJCLUBT", MobileQQ.sMobileQQ.getString(R.string.f173184hu3), "");
        VasWebviewUtil.reportCommercialDrainage("", "poke", "vipTipClick", "", 0, 0, 0, "", String.valueOf(payId), "svip", "", "", "", "", 0, 0, 0, 0);
    }
}
