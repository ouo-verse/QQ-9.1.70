package j13;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IThemeResCheck;
import com.tencent.mobileqq.vas.api.IVasKuiklyApi;
import com.tencent.mobileqq.vas.marketface.IMarketFaceTailConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.config.toggle.c;
import com.tenpay.sdk.download.HttpOp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\t"}, d2 = {"Lj13/b;", "", "Lmqq/app/AppRuntime;", "appRuntime", "", "a", "b", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b {
    public final void a(@NotNull AppRuntime appRuntime) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        b(appRuntime);
        if (!TextUtils.isEmpty(appRuntime.getCurrentAccountUin())) {
            new cooperation.vip.manager.a().f(appRuntime.getCurrentUin());
        }
        ((IVasKuiklyApi) QRoute.api(IVasKuiklyApi.class)).startPreload();
        ((IThemeResCheck) QRoute.api(IThemeResCheck.class)).checkThemeResAndDownload();
        ((IMarketFaceTailConfig) QRoute.api(IMarketFaceTailConfig.class)).initConfig();
    }

    public final void b(@NotNull AppRuntime appRuntime) {
        CardHandler cardHandler;
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        String currentAccountUin = appRuntime.getCurrentAccountUin();
        Intrinsics.checkNotNullExpressionValue(currentAccountUin, "appRuntime.currentAccountUin");
        String[] strArr = {currentAccountUin};
        int[] iArr = {ProfileContants.FIELD_VIP_FONT_ID_TYPE, 27025, ProfileContants.FIELD_VIP_MAGIC_FONT_FLAG, 20059, 27041, 27217, ProfileContants.FIELD_KING_GAME_ID, ProfileContants.FIELD_KING_GMAE_LAST_LOGIN_TIME, ProfileContants.FIELD_KING_GAME_DAN, ProfileContants.FIELD_KING_GAME_DAN_DISPLAY_SWITCH, 27234, 27235, 27236, 27238, HttpOp.HTTP_READTIMEOUT, ProfileContants.FIELD_QQ_LEVEL_ICON_TYPE, ProfileContants.FIELD_THEME_FONT_TYPE, ProfileContants.FIELD_VIP_DIY_FONT_TIMESTAMP, ProfileContants.FIELD_HAOMA_NAMEPLATE, ProfileContants.FILED_KID_MODE_URL_FILTER_SWITCH};
        int[] iArr2 = {27375, 42417, 42489};
        a aVar = new a();
        aVar.C(appRuntime, strArr, iArr, 99);
        if (!com.tencent.relation.common.config.toggle.b.a(5)) {
            aVar.C(appRuntime, strArr, iArr2, 22);
        }
        if ((appRuntime instanceof QQAppInterface) && (cardHandler = (CardHandler) ((QQAppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)) != null) {
            cardHandler.b3();
            boolean g16 = c.S.g(false);
            QLog.d("GetVasInfoRequest", 2, "isCombination=" + g16);
            if (g16) {
                cardHandler.T4();
            } else {
                cardHandler.Y2();
                cardHandler.U4();
            }
        }
    }
}
