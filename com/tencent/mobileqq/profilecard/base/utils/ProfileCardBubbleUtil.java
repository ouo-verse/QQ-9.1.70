package com.tencent.mobileqq.profilecard.base.utils;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfileCardFeatureSwitch;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class ProfileCardBubbleUtil {
    static IPatchRedirector $redirector_ = null;
    public static final String CONVERSATION_CREATE_LABEL_VIDEO_TIPS = "\u53ef\u751f\u6210\u4e2a\u6027\u6807\u7b7e\u89c6\u9891\u54e6";
    public static final String CONVERSATION_QCIRCLE_SETTING_TIPS = "\u8bbe\u7f6e\u89c6\u9891\u5c01\u9762";
    public static final String CONVERSATION_ZPLAN_SETTING_TIPS = "\u5c06\u8d85\u7ea7QQ\u79c0\u8bbe\u7f6e\u4e3a\u5c01\u9762";
    private static final int CREATE_LABEL_VIDEO_TIPS_TIME = 3;
    private static final long DELAY_TIME = 3000;
    public static final String EDIT_SP_NAME = "profile_card_edit_tips_bubble_";
    private static final int EDIT_TIPS_TIME = 3;
    public static final String ENTER_EDIT_SP_NAME = "enter_edit_sp_name";
    private static final String PARAMS_BUBBLETIPS_TIMES = "bubbletips_times";
    private static final String PARAMS_BUBBLETIPS_TYPE = "bubbletips_type";
    public static final int QCIRCLE_TIPS_TIME = 15;
    private static final long SECONDS = 1000;
    public static final String SP_KEY_HAS_SHOWED = "has_showed";
    public static final String SP_KEY_TIME = "time";
    private static final String TAG = "ProfileCardBubbleUtil";
    public static final int TIPS_BG_RADIUS = 8;
    public static final float TIPS_TEXT_SIZE = 14.0f;
    public static final String ZPLAN_SP_NAME = "profile_card_zplan_setting_bubble_";
    public static final int ZPLAN_TIPS_TIME = 15;
    private static volatile boolean isReadyToShowBubble;
    private static int sCurrentShowTipsActivityHashCode;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static class BubbleSetUp {
        static IPatchRedirector $redirector_;
        private final int bubblePosition;
        private final String bubbleText;
        private final int lifeTimeSecond;
        private final View pointerView;

        public BubbleSetUp(View view, String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, view, str, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            this.pointerView = view;
            this.bubbleText = str;
            this.bubblePosition = i3;
            this.lifeTimeSecond = i16;
        }

        public boolean isValid() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            View view = this.pointerView;
            if (view != null && view.getVisibility() == 0) {
                if (TextUtils.isEmpty(this.bubbleText)) {
                    QLog.e(ProfileCardBubbleUtil.TAG, 1, "[BubbleSetUp.isValid] bubbleText invalid");
                    return false;
                }
                int i3 = this.bubblePosition;
                if (i3 != 49 && i3 != 50 && i3 != 51 && i3 != 52) {
                    QLog.e(ProfileCardBubbleUtil.TAG, 1, "[BubbleSetUp.isValid] bubblePosition invalid");
                    return false;
                }
                if (this.lifeTimeSecond > 0) {
                    return true;
                }
                QLog.e(ProfileCardBubbleUtil.TAG, 1, "[BubbleSetUp.isValid] lifeTimeSecond invalid");
                return false;
            }
            QLog.e(ProfileCardBubbleUtil.TAG, 1, "[BubbleSetUp.isValid] pointerView invalid");
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73986);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            isReadyToShowBubble = false;
        }
    }

    public ProfileCardBubbleUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static /* bridge */ /* synthetic */ boolean g() {
        return showEditProfileTips();
    }

    private static boolean getHasShowedEditProfileTips() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        String str = EDIT_SP_NAME + peekAppRuntime.getCurrentAccountUin();
        QMMKV.migrateToSpAdapter(BaseApplication.getContext(), str, "common_mmkv_configurations");
        if (QMMKV.fromSpAdapter(BaseApplication.getContext(), str, "common_mmkv_configurations").getLong("time", 0L) == 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showCreateLabelVideoTips$2(Activity activity, View view) {
        if (((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getIsShowCreateLabelTipsBubble()) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable(activity, view) { // from class: com.tencent.mobileqq.profilecard.base.utils.ProfileCardBubbleUtil.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ Activity val$activity;
                final /* synthetic */ View val$pointer;

                {
                    this.val$activity = activity;
                    this.val$pointer = view;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity, (Object) view);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        ProfileCardBubbleUtil.showProfileBubbleTips(this.val$activity, new BubbleSetUp(this.val$pointer, ProfileCardBubbleUtil.CONVERSATION_CREATE_LABEL_VIDEO_TIPS, 49, 3));
                    }
                }
            }, 1000L);
            ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).updateShowCreateLabelTipsBubbleSp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showQCircleSettingTips$0(Activity activity, View view) {
        showProfileBubbleTips(activity, new BubbleSetUp(view, CONVERSATION_QCIRCLE_SETTING_TIPS, 50, 15));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showQCircleSettingTips$1(final Activity activity, final View view) {
        if (!((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getIsShowQCircleSettingBubble()) {
            QLog.d(TAG, 1, "[showQCircleSettingTips] getIsShow false");
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.base.utils.a
                @Override // java.lang.Runnable
                public final void run() {
                    ProfileCardBubbleUtil.lambda$showQCircleSettingTips$0(activity, view);
                }
            });
            ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).updateShowQCircleSettingBubbleSp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportEditBubbleTipsToDT(View view, int i3) {
        int i16;
        if (view == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(PARAMS_BUBBLETIPS_TYPE, Integer.valueOf(i3));
        if (getHasShowedEditProfileTips()) {
            i16 = 2;
        } else {
            i16 = 1;
        }
        hashMap.put(PARAMS_BUBBLETIPS_TIMES, Integer.valueOf(i16));
        VideoReport.setElementId(view, ProfileCardDtReportUtil.DT_REPORT_BUBBLE_TIPS);
        PageInfo pageInfo = VideoReport.getPageInfo(null);
        if (pageInfo != null) {
            VideoReport.setLogicParent(view, pageInfo.getPageView());
            VideoReport.setElementParams(view, hashMap);
            VideoReport.reportEvent("imp", view, hashMap);
        }
    }

    public static void showCreateLabelVideoTips(final Activity activity, final View view) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.profilecard.base.utils.b
            @Override // java.lang.Runnable
            public final void run() {
                ProfileCardBubbleUtil.lambda$showCreateLabelVideoTips$2(activity, view);
            }
        }, 16, null, true);
    }

    public static synchronized void showEditProfileTips(Activity activity, View view, ProfileCardInfo profileCardInfo) {
        synchronized (ProfileCardBubbleUtil.class) {
            if (profileCardInfo == null) {
                return;
            }
            if (profileCardInfo.hasShowedEditBubble) {
                return;
            }
            ThreadManager.getUIHandler().postDelayed(new Runnable(activity, view) { // from class: com.tencent.mobileqq.profilecard.base.utils.ProfileCardBubbleUtil.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ Activity val$activity;
                final /* synthetic */ View val$pointer;

                {
                    this.val$activity = activity;
                    this.val$pointer = view;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, ProfileCardInfo.this, activity, view);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (!ProfileCardBubbleUtil.isReadyToShowBubble) {
                        ProfileCardBubbleUtil.isReadyToShowBubble = true;
                        int ordinal = ((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).getProfieEmptyStatus(ProfileCardInfo.this).ordinal();
                        String editProfileTipsText = ((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).getEditProfileTipsText(ProfileCardInfo.this);
                        if (TextUtils.isEmpty(editProfileTipsText)) {
                            ProfileCardBubbleUtil.isReadyToShowBubble = false;
                            return;
                        }
                        if (ProfileCardBubbleUtil.g()) {
                            View showProfileBubbleTips = ProfileCardBubbleUtil.showProfileBubbleTips(this.val$activity, new BubbleSetUp(this.val$pointer, editProfileTipsText, 49, 3));
                            ProfileCardInfo.this.hasShowedEditBubble = true;
                            ProfileCardBubbleUtil.reportEditBubbleTipsToDT(showProfileBubbleTips, ordinal);
                            ProfileCardBubbleUtil.updateEditTipsSp();
                        }
                        ProfileCardBubbleUtil.isReadyToShowBubble = false;
                    }
                }
            }, 3000L);
        }
    }

    public static View showProfileBubbleTips(Activity activity, BubbleSetUp bubbleSetUp) {
        int color;
        if (activity != null && !activity.isFinishing() && bubbleSetUp != null && bubbleSetUp.isValid()) {
            try {
                CalloutPopupWindow.Builder textColor = CalloutPopupWindow.builder(activity).setText(bubbleSetUp.bubbleText).setTextSize(14.0f).setTextColor(-1);
                textColor.setPosition(bubbleSetUp.bubblePosition);
                textColor.setLifetime(bubbleSetUp.lifeTimeSecond);
                if (QQTheme.isNowThemeIsNight()) {
                    color = activity.getResources().getColor(R.color.c4t);
                } else {
                    color = activity.getResources().getColor(R.color.c4v);
                }
                CalloutPopupWindow build = new CalloutPopupWindow.DrawableBuilder(textColor).setBackgroundColor(color).setBackgroundRadius(8).build().build();
                if (build != null) {
                    build.showAsPointer(bubbleSetUp.pointerView);
                    QLog.d(TAG, 1, "[showProfileBubbleTips] show");
                    return build.getContentView();
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, "[showProfileBubbleTips] exception:", e16);
            }
            return null;
        }
        QLog.e(TAG, 1, "[showProfileBubbleTips] activity unavailable or bubbleSetup unavailable");
        return null;
    }

    public static void showQCircleOrZPlanTips(Activity activity, View view) {
        if (activity.hashCode() == sCurrentShowTipsActivityHashCode) {
            QLog.d(TAG, 1, "[showQCircleOrZPlanTips] showing tips");
            return;
        }
        if (((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getIsShowZplanSettingRedDotOrBubble(ZPLAN_SP_NAME, SP_KEY_HAS_SHOWED)) {
            QLog.d(TAG, 1, "[showQCircleOrZPlanTips] show zplan");
            showZplanSettingTips(activity, view);
            sCurrentShowTipsActivityHashCode = activity.hashCode();
        } else if (((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getIsShowQCircleSettingBubble()) {
            QLog.d(TAG, 1, "[showQCircleOrZPlanTips] show qcircle");
            showQCircleSettingTips(activity, view);
            sCurrentShowTipsActivityHashCode = activity.hashCode();
        }
    }

    public static synchronized void showQCircleSettingTips(final Activity activity, final View view) {
        synchronized (ProfileCardBubbleUtil.class) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.profilecard.base.utils.c
                @Override // java.lang.Runnable
                public final void run() {
                    ProfileCardBubbleUtil.lambda$showQCircleSettingTips$1(activity, view);
                }
            }, 16, null, true);
        }
    }

    public static synchronized void showZplanSettingTips(Activity activity, View view) {
        synchronized (ProfileCardBubbleUtil.class) {
            ThreadManagerV2.excute(new Runnable(activity, view) { // from class: com.tencent.mobileqq.profilecard.base.utils.ProfileCardBubbleUtil.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Activity val$activity;
                final /* synthetic */ View val$pointer;

                {
                    this.val$activity = activity;
                    this.val$pointer = view;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity, (Object) view);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else if (!((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getIsShowZplanSettingRedDotOrBubble(ProfileCardBubbleUtil.ZPLAN_SP_NAME, ProfileCardBubbleUtil.SP_KEY_HAS_SHOWED)) {
                        QLog.d(ProfileCardBubbleUtil.TAG, 1, "[showZplanSettingTips] getIsShow false");
                    } else {
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.base.utils.ProfileCardBubbleUtil.1.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                } else {
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    ProfileCardBubbleUtil.showProfileBubbleTips(anonymousClass1.val$activity, new BubbleSetUp(anonymousClass1.val$pointer, ProfileCardBubbleUtil.CONVERSATION_ZPLAN_SETTING_TIPS, 50, 15));
                                }
                            }
                        });
                        ProfileCardBubbleUtil.updateZPlanSp();
                    }
                }
            }, 16, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateEditTipsSp() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        String str = EDIT_SP_NAME + peekAppRuntime.getCurrentAccountUin();
        QMMKV.migrateToSpAdapter(BaseApplication.getContext(), str, "common_mmkv_configurations");
        QMMKV.fromSpAdapter(BaseApplication.getContext(), str, "common_mmkv_configurations").edit().putLong("time", System.currentTimeMillis()).commit();
        QLog.d(TAG, 1, "[updateEditTipsSp] update sp success");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateZPlanSp() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        String str = ZPLAN_SP_NAME + peekAppRuntime.getCurrentAccountUin();
        QMMKV.migrateToSpAdapter(BaseApplication.getContext(), str, "common_mmkv_configurations");
        QMMKV.fromSpAdapter(BaseApplication.getContext(), str, "common_mmkv_configurations").edit().putBoolean(SP_KEY_HAS_SHOWED, true).commit();
        QLog.d(TAG, 1, "[updateZPlanSp] update sp success");
    }

    private static boolean showEditProfileTips() {
        AppRuntime peekAppRuntime;
        ProfileCardFeatureSwitch profileCardFeatureSwitch = ProfileCardFeatureSwitch.INSTANCE;
        if (!profileCardFeatureSwitch.isOwnerProfileCardEmptyItemFoldEnable() || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return false;
        }
        String currentAccountUin = peekAppRuntime.getCurrentAccountUin();
        String str = EDIT_SP_NAME + currentAccountUin;
        String str2 = ENTER_EDIT_SP_NAME + currentAccountUin;
        QMMKV.migrateToSpAdapter(BaseApplication.getContext(), str, "common_mmkv_configurations");
        long j3 = QMMKV.fromSpAdapter(BaseApplication.getContext(), str, "common_mmkv_configurations").getLong("time", 0L);
        QMMKV.migrateToSpAdapter(BaseApplication.getContext(), str2, "common_mmkv_configurations");
        long j16 = QMMKV.fromSpAdapter(BaseApplication.getContext(), str2, "common_mmkv_configurations").getLong("time", 0L);
        String str3 = profileCardFeatureSwitch.getOwnerProfileCardEmptyItemFoldParam().get(ProfileCardFeatureSwitch.PROFILE_BUBBLE_SHOW_INTERVAL);
        String str4 = profileCardFeatureSwitch.getOwnerProfileCardEmptyItemFoldParam().get(ProfileCardFeatureSwitch.PROFILE_BUBBLE_PAST_EDIT_INTERVAL);
        try {
            long parseLong = Long.parseLong(str3);
            long parseLong2 = Long.parseLong(str4);
            if ((System.currentTimeMillis() - j3) / 1000 < parseLong) {
                return false;
            }
            return (System.currentTimeMillis() - j16) / 1000 >= parseLong2;
        } catch (NumberFormatException e16) {
            QLog.e(TAG, 1, "[showEditProfileTips] NumberFormatException:", e16);
            return false;
        }
    }
}
