package com.tencent.gdtad.util;

import android.content.Intent;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.minigame.api.IMiniGameVipWithoutAdManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GdtVipWithoutAdHelper {
    private static final String TAG = "GdtVipWithoutAdHelper";

    public static boolean getVipWithoutAdMemberState() {
        return ((IMiniGameVipWithoutAdManager) QRoute.api(IMiniGameVipWithoutAdManager.class)).getVipWithoutAdMemberState();
    }

    public static String getVipWithoutAdToastText() {
        return ((IMiniGameVipWithoutAdManager) QRoute.api(IMiniGameVipWithoutAdManager.class)).getVipWithoutAdToastText();
    }

    public static void showVipWithoutAdToast() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.gdtad.util.GdtVipWithoutAdHelper.1
            @Override // java.lang.Runnable
            public void run() {
                BaseApplication context = BaseApplication.getContext();
                String vipWithoutAdToastText = GdtVipWithoutAdHelper.getVipWithoutAdToastText();
                if (!TextUtils.isEmpty(vipWithoutAdToastText)) {
                    QQToast.makeText(context, vipWithoutAdToastText, 0).show();
                }
            }
        });
    }

    public static void vipWithoutAdGetReward(ResultReceiver resultReceiver) {
        Intent intent = new Intent();
        intent.putExtra("profitable_flag", true);
        resultReceiver.send(-1, intent.getExtras());
    }
}
