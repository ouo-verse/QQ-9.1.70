package com.tencent.mobileqq.profilecard.bussiness.troopgame;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilesetting.InterestSwitchEditActivity;
import com.tencent.mobileqq.profilesetting.u;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ActionSheetWithTick;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import mqq.app.MobileQQ;

/* loaded from: classes35.dex */
public class ElegantProfileGameInfoSettingHelper {
    private static final String TAG = "ElegantProfileGameInfoSettingHelper";
    private static com.tencent.mobileqq.troop.troopgame.api.a gamaHandler;
    private static volatile InterestSwitchEditActivity sActivity;

    public static void getAuthFromServer() {
        if (gamaHandler != null) {
            gamaHandler.T0(((BaseQQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).getCurrentUin());
        }
    }

    public static int getTitleBarHeight() {
        return BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height);
    }

    public static void onInterestSwitchEditActivityCreate(InterestSwitchEditActivity interestSwitchEditActivity) {
        sActivity = interestSwitchEditActivity;
        gamaHandler = (com.tencent.mobileqq.troop.troopgame.api.a) ((BaseQQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopGameHandlerName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setGameInfoPermission(int i3) {
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            QQToast.makeText(BaseApplication.getContext(), R.string.f171137ci2, 0).show(getTitleBarHeight());
            return;
        }
        com.tencent.mobileqq.troop.troopgame.api.a aVar = gamaHandler;
        if (aVar == null) {
            return;
        }
        aVar.g2(i3);
    }

    public static void showGameInfoActionSheet(boolean z16, final u uVar) {
        if (sActivity == null || sActivity.isFinishing()) {
            return;
        }
        final ActionSheetWithTick X = ActionSheetWithTick.X(sActivity, z16);
        X.a0(new ArrayList(InterestSwitchEditActivity.f260946l0.keySet()));
        X.c0(sActivity.Z2(uVar.e()));
        X.d0(true);
        X.b0(new ActionSheetWithTick.d() { // from class: com.tencent.mobileqq.profilecard.bussiness.troopgame.ElegantProfileGameInfoSettingHelper.1
            @Override // com.tencent.mobileqq.widget.ActionSheetWithTick.d
            public void onSelected(int i3) {
                if (ElegantProfileGameInfoSettingHelper.sActivity == null) {
                    return;
                }
                int b36 = ElegantProfileGameInfoSettingHelper.sActivity.b3(i3);
                if (u.this.e() != b36) {
                    ElegantProfileGameInfoSettingHelper.setGameInfoPermission(b36);
                }
                X.dismiss();
            }

            @Override // com.tencent.mobileqq.widget.ActionSheetWithTick.d
            public void onCancel() {
            }
        });
        X.show();
    }

    public static void onInterestSwitchEditActivityDestroy() {
        sActivity = null;
        if (gamaHandler != null) {
            gamaHandler = null;
        }
    }
}
