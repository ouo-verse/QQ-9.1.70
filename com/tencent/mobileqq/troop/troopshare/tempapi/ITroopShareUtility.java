package com.tencent.mobileqq.troop.troopshare.tempapi;

import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.mobileqq.troop.data.TroopInfoData;

/* compiled from: P */
@QRouteFactory(singleton = false)
@QAPI(process = {""})
/* loaded from: classes19.dex */
public interface ITroopShareUtility extends QRouteApi {
    public static final String START_ACTIVITY_BY_FTAGMENT = "start_activity_by_fragment";

    String getTroopShareDescDefaultWording();

    void handleTroopLinkShare(TroopInfoData troopInfoData);

    void initTroopShareUtility(Activity activity, TroopInfoData troopInfoData);

    void newTroopShareUtility(Activity activity, TroopInfoData troopInfoData);

    void onDestroy();

    void showQRCodeSharePanel(QBaseActivity qBaseActivity, TroopInfoData troopInfoData, Bitmap bitmap, String str);

    void showTroopIDCardSharePanel(QBaseActivity qBaseActivity, TroopInfoData troopInfoData);

    void startTroop2DCode();

    void troopUtils_shareTroop(Activity activity, TroopInfoData troopInfoData, AppInterface appInterface);

    void troopUtils_shareTroopFromAIO(Activity activity, TroopInfoData troopInfoData, AppInterface appInterface);
}
