package com.qzone.reborn.feedx.util;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.qzone.feed.utils.QZoneFeedUtil;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.module.feedcomponent.ui.common.SuperLikeView;
import com.qzone.personalize.business.QzoneZipDownloadService;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CustomPraiseData;
import com.qzone.proxy.feedcomponent.service.QzoneCustomPraiseService;
import com.qzone.proxy.feedcomponent.ui.CustomPraiseView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneGiftFullScreenViewControllerProxy;
import common.config.service.QzoneConfig;
import cooperation.qzone.IQzoneGiftFullScreenViewController;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.util.QZLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ad {

    /* renamed from: c, reason: collision with root package name */
    private static int f55713c = -1;

    /* renamed from: d, reason: collision with root package name */
    private static String f55714d;

    /* renamed from: a, reason: collision with root package name */
    private int[] f55715a = new int[2];

    /* renamed from: b, reason: collision with root package name */
    private CustomPraiseView f55716b;

    private static boolean c(BusinessFeedData businessFeedData, CustomPraiseData customPraiseData) {
        if (TextUtils.isEmpty(businessFeedData.getUser().personalizedPassivePraiseUrl) && businessFeedData.getUser().cmPraiseActionid == 0) {
            return false;
        }
        return customPraiseData == null || customPraiseData.itemId < 0 || customPraiseData.subType == 4 || customPraiseData.cmShowActionId == 0;
    }

    private static boolean d(BusinessFeedData businessFeedData, boolean z16, boolean z17) {
        if (!LocalMultiProcConfig.getBool(LocalMultiProcConfig.QZONE_PASSIVE_PRAISE_ENABLED, true) || z17 || businessFeedData.getFeedCommInfo().isBizRecomFeeds()) {
            return false;
        }
        return (!z16 || businessFeedData.getUser().personalizedPassivePraiseId == -1 || QZoneFeedUtil.R(businessFeedData)) ? false : true;
    }

    public static void e(BusinessFeedData businessFeedData, CustomPraiseData customPraiseData, boolean z16, boolean z17, Activity activity) {
        if (!VasToggle.BUG_105413094.isEnable(false) && d(businessFeedData, z16, z17)) {
            l(businessFeedData, customPraiseData, activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(IQzoneGiftFullScreenViewController iQzoneGiftFullScreenViewController, BusinessFeedData businessFeedData, String str) {
        iQzoneGiftFullScreenViewController.playMaigcface(businessFeedData.getUser().personalizedPassivePraiseUrl + "", str, true, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(final BusinessFeedData businessFeedData, Activity activity) {
        try {
            String replace = businessFeedData.getUser().personalizedPassivePraiseUrl.replace("sbig", com.tencent.mobileqq.magicface.model.f.d());
            StringBuilder sb5 = new StringBuilder();
            sb5.append(CacheManager.getPraiseDir());
            String str = File.separator;
            sb5.append(str);
            sb5.append(MD5Utils.toMD5(replace));
            sb5.append(str);
            final String sb6 = sb5.toString();
            File file = new File(sb6);
            if (file.exists() && file.isDirectory()) {
                IQzoneGiftFullScreenViewControllerProxy iQzoneGiftFullScreenViewControllerProxy = (IQzoneGiftFullScreenViewControllerProxy) QRoute.api(IQzoneGiftFullScreenViewControllerProxy.class);
                if (iQzoneGiftFullScreenViewControllerProxy.isSupportMagicface()) {
                    final IQzoneGiftFullScreenViewController qzoneGiftFullScreenViewController = iQzoneGiftFullScreenViewControllerProxy.getQzoneGiftFullScreenViewController(activity);
                    ClickReport.m("633", "1", "1");
                    ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.qzone.reborn.feedx.util.ac
                        @Override // java.lang.Runnable
                        public final void run() {
                            ad.g(IQzoneGiftFullScreenViewController.this, businessFeedData, sb6);
                        }
                    }, 1000L);
                }
            } else {
                QzoneZipDownloadService.k().g(replace);
            }
        } catch (Exception e16) {
            QLog.e("QZonePraiseAnimHelper", 2, e16.toString());
        }
    }

    public void i(SuperLikeView superLikeView, Activity activity, String str) {
        f(activity);
        if (superLikeView == null || activity == null || this.f55716b == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.d("QZonePraiseAnimHelper", 1, "playHolidayPraiseAnim url is null");
            return;
        }
        superLikeView.getLocationOnScreen(this.f55715a);
        this.f55716b.setShowPos(this.f55715a[0] + (superLikeView.getWidth() / 2), (this.f55715a[1] - ViewUtils.dpToPx(72.0f)) + (superLikeView.getHeight() / 2));
        this.f55716b.setAnimationRes(str, 30, 0, superLikeView.hashCode());
        QZLog.d("QZonePraiseAnimHelper", 2, "@cmPraise oncustompraise time =" + System.currentTimeMillis());
        this.f55716b.l();
    }

    public void j(BusinessFeedData businessFeedData, SuperLikeView superLikeView, Activity activity) {
        CustomPraiseData g16;
        f(activity);
        if (this.f55716b == null) {
            return;
        }
        if (businessFeedData.isGDTAdvFeed()) {
            g16 = (businessFeedData.getCellDecorateInfo() == null || businessFeedData.getCellDecorateInfo().cellCustomPraise == null) ? null : com.qzone.proxy.feedcomponent.service.a.b().c(businessFeedData.getCellDecorateInfo().cellCustomPraise);
        } else {
            g16 = QzoneCustomPraiseService.i().g();
        }
        if (businessFeedData.getUser().customPraiseData != null && businessFeedData.getUser().customPraiseData.itemId != -1) {
            g16 = businessFeedData.getUser().customPraiseData;
        }
        if (f55713c == -1) {
            f55713c = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_SELF_PRAISE_ANIMATION, QzoneConfig.SECONDARY_KEY_SELF_PRAISE_ANIMATION_SWITCH, 1);
        }
        superLikeView.getLocationOnScreen(this.f55715a);
        if (g16 == null) {
            if (f55713c == 1) {
                this.f55716b.setShowPos(this.f55715a[0] + (superLikeView.getWidth() / 2), (this.f55715a[1] - ViewUtils.dpToPx(72.0f)) + (superLikeView.getHeight() / 2));
                if (f55714d == null) {
                    f55714d = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_SELF_PRAISE_ANIMATION, QzoneConfig.SECONDARY_KEY_SELF_PRAISE_ANIMATION_RES_URL, QzoneConfig.DEFAULT_SELF_PRAISE_ANIMATION_RES_URL);
                }
                this.f55716b.setAnimationRes(f55714d, 30, 0, businessFeedData.hashCode());
                return;
            }
            return;
        }
        this.f55716b.setShowPos(this.f55715a[0] + (superLikeView.getWidth() / 2), (this.f55715a[1] - ViewUtils.dpToPx(72.0f)) + (superLikeView.getHeight() / 2));
        this.f55716b.setAnimationRes(g16.praiseZipUrl, g16.frameRate, g16.praiseType, businessFeedData.hashCode());
        QZLog.d("QZonePraiseAnimHelper", 2, "@cmPraise oncustompraise time =" + System.currentTimeMillis());
        this.f55716b.l();
    }

    private void f(Activity activity) {
        if (activity == null || this.f55716b != null) {
            return;
        }
        this.f55716b = new CustomPraiseView(BaseApplication.getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = activity.getResources().getDimensionPixelSize(R.dimen.azw);
        layoutParams.gravity = 48;
        ((FrameLayout) activity.findViewById(android.R.id.content)).addView(this.f55716b, layoutParams);
    }

    private static void k(final BusinessFeedData businessFeedData, final Activity activity) {
        if (businessFeedData == null || businessFeedData.getUser() == null || TextUtils.isEmpty(businessFeedData.getUser().personalizedPassivePraiseUrl)) {
            return;
        }
        QLog.d("QZonePraiseAnimHelper", 2, "@cmpraise  showPassiveAnimal play");
        ThreadManagerV2.excute(new Runnable() { // from class: com.qzone.reborn.feedx.util.ab
            @Override // java.lang.Runnable
            public final void run() {
                ad.h(BusinessFeedData.this, activity);
            }
        }, 16, null, false);
    }

    private static void l(BusinessFeedData businessFeedData, CustomPraiseData customPraiseData, Activity activity) {
        if (businessFeedData == null || businessFeedData.getUser() == null) {
            return;
        }
        try {
            if (c(businessFeedData, customPraiseData)) {
                k(businessFeedData, activity);
            }
        } catch (Exception e16) {
            QZLog.e("QZonePraiseAnimHelper", 2, e16.toString());
        }
    }
}
