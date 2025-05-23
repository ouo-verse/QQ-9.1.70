package com.tencent.mobileqq.profilecard.bussiness.achievement;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class LifeAchivementHelper {
    static IPatchRedirector $redirector_ = null;
    static final long CLICK_INTERVAL_MS = 500;
    static final String MINI_APP_LIFE_ACHIVEMENT_ADD_PAGE = "mqqapi://miniapp/open?_atype=0&_mappid=1110348796&_mvid=&_path=pages%2Findex%2Findex&_vt=3&referer=2062&via=2062_3&_sig=1925072163";
    static final String MINI_APP_LIFE_ACHIVEMENT_DISPALY_PAGE = "mqqapi://miniapp/open?_atype=0&_mappid=1110348796&_mvid=&_path=pages%2Fachievement%2Fachievement&_vt=3&referer=2062&via=2062_3&_sig=831969013";
    static final String TAG = "LifeAchivementHelper";

    public LifeAchivementHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String formatPraiseNum(int i3) {
        if (i3 >= 1 && i3 < 10000) {
            return String.valueOf(i3);
        }
        if (i3 >= 10000 && i3 < 100000000) {
            if (i3 % 10000 < 500) {
                return (i3 / 10000) + "\u4e07";
            }
            return ((Math.round(((i3 * 1.0f) / 10000.0f) * 10.0f) * 1.0f) / 10.0f) + "\u4e07";
        }
        if (i3 >= 100000000) {
            if (i3 % 100000000 < 5000000) {
                return (i3 / 100000000) + "\u4ebf";
            }
            return ((Math.round(((i3 * 1.0f) / 1.0E8f) * 10.0f) * 1.0f) / 10.0f) + "\u4ebf";
        }
        return "";
    }

    public static void jumpToLifeAchivementMiniAppAchiivementDetailPage(Context context, String str, int i3) {
        String str2 = "mqqapi://miniapp/open?_atype=0&_mappid=1110348796&_mvid=&_path=pages%2Fachievement%2Fachievement&_vt=3&referer=2062&via=2062_3&_sig=831969013&openid=" + str + "&achievement_id=" + i3;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("jumpToLifeAchivementMiniAppAchiivementDetailPage miniAppUrl=%s", str2));
        }
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(context, str2, 2062, null);
    }

    public static void jumpToLifeAchivementMiniAppAchivementListPage(Context context, String str) {
        String str2 = "mqqapi://miniapp/open?_atype=0&_mappid=1110348796&_mvid=&_path=pages%2Fachievement%2Fachievement&_vt=3&referer=2062&via=2062_3&_sig=831969013&openid=" + str;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("jumpToLifeAchivementMiniAppAchivementListPage miniAppUrl=%s", str2));
        }
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(context, str2, 2062, null);
    }

    public static void jumpToLifeAchivementMiniAppAddPage(Context context) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("jumpToLifeAchivementMiniAppAddPage miniAppUrl=%s", MINI_APP_LIFE_ACHIVEMENT_ADD_PAGE));
        }
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(context, MINI_APP_LIFE_ACHIVEMENT_ADD_PAGE, 2062, null);
    }

    public static void setViewClickInterval(View view) {
        if (view == null) {
            return;
        }
        view.setClickable(false);
        view.postDelayed(new Runnable(view) { // from class: com.tencent.mobileqq.profilecard.bussiness.achievement.LifeAchivementHelper.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ View val$view;

            {
                this.val$view = view;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                View view2 = this.val$view;
                if (view2 != null) {
                    view2.setClickable(true);
                }
            }
        }, 500L);
    }

    public static boolean shouldShowAchivementPanelOrNot(Card card, IProfileConfig iProfileConfig, boolean z16, boolean z17) {
        return false;
    }
}
