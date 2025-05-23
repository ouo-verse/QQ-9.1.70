package com.tencent.mobileqq.minigame.leba.impl;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.c;
import com.tencent.mobileqq.mini.server.request.ClearFarmNoticeNumRedDotRequest;
import com.tencent.mobileqq.minigame.leba.IMiniGameLebaController;
import com.tencent.mobileqq.minigame.leba.impl.MiniGameLebaControllerImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedPointUIManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniGameLebaControllerImpl implements IMiniGameLebaController {
    public static final String ADS_TYPE_DYNAMIC_IMG = "19";
    private static final String TAG = "MiniGameLebaControllerImpl";
    private boolean hasNewRedInfo = false;
    private int numRedDotCount = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$clearNumRedDot$0(boolean z16, JSONObject jSONObject) {
        QLog.i(TAG, 1, "clearNumRedDot: isSuccess=" + z16);
    }

    @Override // com.tencent.mobileqq.minigame.leba.IMiniGameLebaController
    public String getLetsGoRedInfo() {
        boolean z16;
        int i3;
        synchronized (this) {
            z16 = this.hasNewRedInfo;
            i3 = this.numRedDotCount;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("hasNew", z16);
            jSONObject.put("unreadCount", i3);
            QLog.i(TAG, 1, "getRedTouchInfo: success, content=" + jSONObject);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getRedTouchInfo: failed, error=", e16);
        }
        return jSONObject.toString();
    }

    @Override // com.tencent.mobileqq.minigame.leba.IMiniGameLebaController
    public boolean hasRedInfo() {
        boolean z16;
        int i3;
        synchronized (this) {
            z16 = this.hasNewRedInfo;
            i3 = this.numRedDotCount;
        }
        if (!z16 && i3 <= 0) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.minigame.leba.IMiniGameLebaController
    public void onItemClick() {
        int i3;
        synchronized (this) {
            i3 = this.numRedDotCount;
        }
        if (i3 <= 0) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: a92.a
            @Override // java.lang.Runnable
            public final void run() {
                MiniGameLebaControllerImpl.clearNumRedDot();
            }
        }, 128, null, false);
    }

    @Override // com.tencent.mobileqq.minigame.leba.IMiniGameLebaController
    public void onItemClickBefore(BusinessInfoCheckUpdate.AppInfo appInfo) {
        boolean hasRedTouch = RedTouch.hasRedTouch(appInfo);
        boolean isSwitchOn = ((IRedPointUIManager) QRoute.api(IRedPointUIManager.class)).isSwitchOn();
        int redCount = isSwitchOn ? getRedCount() : 0;
        QLog.i(TAG, 1, "onItemClickBefore: hasNew=" + hasRedTouch + "; numRedCount=" + redCount + "; isNumRedDotSwitchOn=" + isSwitchOn);
        synchronized (this) {
            this.hasNewRedInfo = hasRedTouch;
            this.numRedDotCount = redCount;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void clearNumRedDot() {
        QLog.i(TAG, 1, "clearNumRedDot: call.");
        new ClearFarmNoticeNumRedDotRequest().request(new AsyncResult() { // from class: a92.b
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public final void onReceiveResult(boolean z16, JSONObject jSONObject) {
                MiniGameLebaControllerImpl.lambda$clearNumRedDot$0(z16, jSONObject);
            }
        });
    }

    private static int getRedCount() {
        try {
            BusinessInfoCheckUpdate.AppInfo appInfo = ((IRedTouchManager) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IRedTouchManager.class, "")).getAppInfo(0, IMiniGameLebaController.MINI_GAME_NUM_RES_ID);
            if (appInfo != null) {
                return appInfo.num.get();
            }
            return 0;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getRedCount: failed.", e16);
            return 0;
        }
    }

    @Override // com.tencent.mobileqq.minigame.leba.IMiniGameLebaController
    public void notifyLebaTabChange(boolean z16) {
    }

    @Override // com.tencent.mobileqq.minigame.leba.IMiniGameLebaController
    public void setGameViewContainer(c cVar) {
    }

    @Override // com.tencent.mobileqq.minigame.leba.IMiniGameLebaController
    public void showGridAnimation(boolean z16, BusinessInfoCheckUpdate.AppInfo appInfo) {
    }
}
