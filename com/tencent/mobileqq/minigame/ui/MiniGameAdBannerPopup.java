package com.tencent.mobileqq.minigame.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.open.adapter.a;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.vip.pb.TianShuAccess;
import cooperation.vip.tianshu.TianShuManager;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import mqq.util.WeakReference;
import oicq.wlogin_sdk.tools.util;

/* loaded from: classes33.dex */
public class MiniGameAdBannerPopup {
    private static final String PREF_KEY_CURRENT_SHOW_TIMES = "pref_key_banner_ad_current_show_times";
    private static final String PREF_KEY_LAST_SHOW_TIME_MILLIS = "pref_key_banner_ad_popup_last_show_time_millis";
    private static final String TAG = "MiniGameAdBannerPopup";
    private static final String WNS_KEY_SHOW_DELAY_SECONDS_AFTER_GAME_LAUNCH = "banner_ad_popup_show_delay_seconds_after_game_launch";
    private static int SHOW_DELAY_SECONDS_AFTER_GAME_LAUNCH = QzoneConfig.getInstance().getConfig("qqminiapp", WNS_KEY_SHOW_DELAY_SECONDS_AFTER_GAME_LAUNCH, 0);
    private static final String WNS_KEY_APPID_WHITE_LIST = "banner_ad_popup_appid_white_list";
    private static String APPID_WHITE_LIST = QzoneConfig.getInstance().getConfig("qqminiapp", WNS_KEY_APPID_WHITE_LIST, "");
    private static final String WNS_KEY_APPID_BLACK_LIST = "banner_ad_popup_appid_black_list";
    private static String APPID_BLACK_LIST = QzoneConfig.getInstance().getConfig("qqminiapp", WNS_KEY_APPID_BLACK_LIST, "");
    private static final String WNS_KEY_REFER_WHITE_LIST = "banner_ad_popup_refer_white_list";
    private static String REFER_WHITE_LIST = QzoneConfig.getInstance().getConfig("qqminiapp", WNS_KEY_REFER_WHITE_LIST, "");
    private static final String WNS_KEY_REFER_BLACK_LIST = "banner_ad_popup_refer_black_list";
    private static String REFER_BLACK_LIST = QzoneConfig.getInstance().getConfig("qqminiapp", WNS_KEY_REFER_BLACK_LIST, "");
    private static GetAdCallback GET_AD_CALLBACK = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public static class GetAdCallback implements TianShuGetAdvCallback {
        private final WeakReference<Context> context;
        private final MiniAppConfig miniAppConfig;

        GetAdCallback(Context context, MiniAppConfig miniAppConfig) {
            this.context = new WeakReference<>(context);
            this.miniAppConfig = miniAppConfig;
        }

        @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
        public void onGetAdvs(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
            QLog.d(MiniGameAdBannerPopup.TAG, 1, "onGetAdvs() called with: result = [" + z16 + "], getAdsRsp = [" + getAdsRsp + "]");
            WeakReference<Context> weakReference = this.context;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            MiniGameAdBannerPopup.handleGetAdResult(this.context.get(), this.miniAppConfig, z16, getAdsRsp);
        }
    }

    private static boolean allowShowForAppId(MiniAppConfig miniAppConfig) {
        String[] split;
        String[] split2;
        try {
            if ((!TextUtils.isEmpty(APPID_WHITE_LIST) || !TextUtils.isEmpty(APPID_BLACK_LIST)) && miniAppConfig != null && miniAppConfig.config != null) {
                QLog.d(TAG, 1, "allowShowForAppId", " check if appid " + miniAppConfig.config.appId + " in whitelist " + APPID_WHITE_LIST + " or blacklist " + APPID_BLACK_LIST);
                if (!TextUtils.isEmpty(APPID_WHITE_LIST)) {
                    if (APPID_WHITE_LIST.contains(",")) {
                        split2 = APPID_WHITE_LIST.split(",");
                    } else {
                        split2 = APPID_WHITE_LIST.split(";");
                    }
                    if (split2 != null) {
                        for (String str : split2) {
                            if (str != null && str.equals(miniAppConfig.config.appId)) {
                                return true;
                            }
                        }
                    }
                    return false;
                }
                if (!TextUtils.isEmpty(APPID_BLACK_LIST)) {
                    if (APPID_BLACK_LIST.contains(",")) {
                        split = APPID_BLACK_LIST.split(",");
                    } else {
                        split = APPID_BLACK_LIST.split(";");
                    }
                    if (split != null) {
                        for (String str2 : split) {
                            if (str2 != null && str2.equals(miniAppConfig.config.appId)) {
                                return false;
                            }
                        }
                    }
                    return true;
                }
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "allowShowForAppId", e16);
        }
        return true;
    }

    private static boolean allowShowForRefer(MiniAppConfig miniAppConfig) {
        String[] split;
        String[] split2;
        try {
            if ((!TextUtils.isEmpty(REFER_WHITE_LIST) || !TextUtils.isEmpty(REFER_BLACK_LIST)) && miniAppConfig != null && miniAppConfig.launchParam != null) {
                QLog.d(TAG, 1, "allowShowForRefer", " check if scene " + miniAppConfig.launchParam.scene + " in whitelist " + REFER_WHITE_LIST + " or blacklist " + REFER_BLACK_LIST);
                if (!TextUtils.isEmpty(REFER_WHITE_LIST)) {
                    if (REFER_WHITE_LIST.contains(",")) {
                        split2 = REFER_WHITE_LIST.split(",");
                    } else {
                        split2 = REFER_WHITE_LIST.split(";");
                    }
                    if (split2 != null) {
                        for (String str : split2) {
                            if (Integer.parseInt(str) == miniAppConfig.launchParam.scene) {
                                return true;
                            }
                        }
                    }
                    return false;
                }
                if (!TextUtils.isEmpty(REFER_BLACK_LIST)) {
                    if (REFER_BLACK_LIST.contains(",")) {
                        split = REFER_BLACK_LIST.split(",");
                    } else {
                        split = REFER_BLACK_LIST.split(";");
                    }
                    if (split != null) {
                        for (String str2 : split) {
                            if (Integer.parseInt(str2) == miniAppConfig.launchParam.scene) {
                                return false;
                            }
                        }
                    }
                    return true;
                }
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "allowShowForRefer", e16);
        }
        return true;
    }

    public static void checkShouldShow(final Context context, final MiniAppConfig miniAppConfig) {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.minigame.ui.MiniGameAdBannerPopup.1
            @Override // java.lang.Runnable
            public void run() {
                MiniGameAdBannerPopup.checkShouldShowInternal(context, miniAppConfig);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void handleGetAdResult(final Context context, MiniAppConfig miniAppConfig, boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
        final String str;
        final String str2;
        final String str3;
        final String str4;
        final TianShuAccess.AdItem adItem;
        TianShuAccess.AdItem adItem2;
        String str5;
        String str6;
        String str7;
        TianShuAccess.AdPlacementInfo adPlacementInfo;
        PBRepeatMessageField<TianShuAccess.MapEntry> pBRepeatMessageField;
        String str8 = null;
        if (z16 && getAdsRsp != null) {
            if (!getAdsRsp.mapAds.isEmpty()) {
                TianShuAccess.RspEntry rspEntry = getAdsRsp.mapAds.get(0);
                if (rspEntry != null && (adPlacementInfo = rspEntry.value) != null && !adPlacementInfo.lst.isEmpty()) {
                    adItem2 = rspEntry.value.lst.get(0);
                    if (adItem2 != null && (pBRepeatMessageField = adItem2.argList) != null && !pBRepeatMessageField.isEmpty()) {
                        str5 = null;
                        str6 = null;
                        str7 = null;
                        for (TianShuAccess.MapEntry mapEntry : adItem2.argList.get()) {
                            if ("type".equals(mapEntry.key.get())) {
                                str8 = mapEntry.value.get();
                            } else if ("url".equals(mapEntry.key.get())) {
                                str5 = mapEntry.value.get();
                            } else if ("text".equals(mapEntry.key.get())) {
                                str6 = mapEntry.value.get();
                            } else if ("pic".equals(mapEntry.key.get())) {
                                str7 = mapEntry.value.get();
                            } else if ("appid_on".equals(mapEntry.key.get())) {
                                APPID_WHITE_LIST = mapEntry.value.get();
                            } else if ("appid_off".equals(mapEntry.key.get())) {
                                APPID_BLACK_LIST = mapEntry.value.get();
                            } else if ("refer_on".equals(mapEntry.key.get())) {
                                REFER_WHITE_LIST = mapEntry.value.get();
                            } else if ("refer_off".equals(mapEntry.key.get())) {
                                REFER_BLACK_LIST = mapEntry.value.get();
                            } else if ("show_time".equals(mapEntry.key.get()) && !TextUtils.isEmpty(mapEntry.value.get())) {
                                try {
                                    SHOW_DELAY_SECONDS_AFTER_GAME_LAUNCH = Integer.parseInt(mapEntry.value.get());
                                } catch (Exception e16) {
                                    QLog.e(TAG, 1, "handleGetAdResult", e16);
                                }
                            }
                        }
                        adItem = adItem2;
                        str4 = str5;
                        str3 = str7;
                        str2 = str6;
                        str = str8;
                        QLog.d(TAG, 1, "handleGetAdResult", " appid whitelist " + APPID_WHITE_LIST + "\n appid blacklist " + APPID_BLACK_LIST + "\n refer whitelist " + REFER_WHITE_LIST + "\n refer blacklist " + REFER_BLACK_LIST + "\n show time " + SHOW_DELAY_SECONDS_AFTER_GAME_LAUNCH);
                        if (!allowShowForAppId(miniAppConfig)) {
                            if (miniAppConfig == null || miniAppConfig.config == null) {
                                return;
                            }
                            QLog.e(TAG, 1, "handleGetAdResult", " not allow for appid " + miniAppConfig.config.appId);
                            return;
                        }
                        if (allowShowForRefer(miniAppConfig)) {
                            if (str == null || str4 == null || str2 == null || str3 == null || adItem == null) {
                                return;
                            }
                            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.minigame.ui.MiniGameAdBannerPopup.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        MiniGameAdBannerPopup.showAdBannerPopupWindow(context, str, str2, str3, str4, adItem);
                                    } catch (Throwable th5) {
                                        QLog.e(MiniGameAdBannerPopup.TAG, 1, th5, new Object[0]);
                                    }
                                }
                            }, TimeUnit.SECONDS.toMillis(SHOW_DELAY_SECONDS_AFTER_GAME_LAUNCH));
                            return;
                        }
                        if (miniAppConfig == null || miniAppConfig.launchParam == null) {
                            return;
                        }
                        QLog.e(TAG, 1, "handleGetAdResult", " not allow for refer " + miniAppConfig.launchParam.scene);
                        return;
                    }
                    QLog.e(TAG, 1, "onGetAdvs", " no ad item");
                } else {
                    QLog.e(TAG, 1, "onGetAdvs", " no ad data");
                }
                adItem2 = null;
                str5 = null;
                str6 = null;
                str7 = null;
                adItem = adItem2;
                str4 = str5;
                str3 = str7;
                str2 = str6;
                str = str8;
                QLog.d(TAG, 1, "handleGetAdResult", " appid whitelist " + APPID_WHITE_LIST + "\n appid blacklist " + APPID_BLACK_LIST + "\n refer whitelist " + REFER_WHITE_LIST + "\n refer blacklist " + REFER_BLACK_LIST + "\n show time " + SHOW_DELAY_SECONDS_AFTER_GAME_LAUNCH);
                if (!allowShowForAppId(miniAppConfig)) {
                }
            }
        } else {
            QLog.e(TAG, 1, "onGetAdvs", " no ad result");
        }
        str = null;
        str2 = null;
        str3 = null;
        str4 = null;
        adItem = null;
        QLog.d(TAG, 1, "handleGetAdResult", " appid whitelist " + APPID_WHITE_LIST + "\n appid blacklist " + APPID_BLACK_LIST + "\n refer whitelist " + REFER_WHITE_LIST + "\n refer blacklist " + REFER_BLACK_LIST + "\n show time " + SHOW_DELAY_SECONDS_AFTER_GAME_LAUNCH);
        if (!allowShowForAppId(miniAppConfig)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TianShuReportData newTianShuReportData(TianShuAccess.AdItem adItem, String str, int i3) {
        int seconds = (int) TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        TianShuReportData tianShuReportData = new TianShuReportData();
        tianShuReportData.mTraceId = String.valueOf(a.f().l()) + util.base64_pad_url + seconds;
        tianShuReportData.mActionId = i3;
        tianShuReportData.mActionValue = 1;
        tianShuReportData.mItemId = String.valueOf(adItem.iAdId.get());
        tianShuReportData.mItemType = str;
        tianShuReportData.mOperTime = seconds;
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mAppId = "tianshu.81";
        tianShuReportData.mModuleId = "";
        return tianShuReportData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void performReport(final TianShuAccess.AdItem adItem, final String str, final int i3) {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.minigame.ui.MiniGameAdBannerPopup.6
            @Override // java.lang.Runnable
            public void run() {
                TianShuManager.getInstance().report(MiniGameAdBannerPopup.newTianShuReportData(TianShuAccess.AdItem.this, str, i3));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes33.dex */
    public static class BottomCornerURLImageView extends URLImageView {
        private float[] allRadius;
        private Path clippedPath;
        private RectF clippedRectF;

        public BottomCornerURLImageView(Context context, AttributeSet attributeSet, int i3) {
            super(context, attributeSet, i3);
            this.clippedRectF = new RectF();
            initView(context, attributeSet, i3);
        }

        private void initView(Context context, AttributeSet attributeSet, int i3) {
            float applyDimension = TypedValue.applyDimension(1, 6.0f, context.getResources().getDisplayMetrics());
            this.clippedPath = new Path();
            this.allRadius = new float[]{0.0f, 0.0f, 0.0f, 0.0f, applyDimension, applyDimension, applyDimension, applyDimension};
        }

        @Override // android.widget.ImageView, android.view.View
        protected void onDraw(Canvas canvas) {
            int save = canvas.save();
            if (this.clippedPath != null) {
                this.clippedRectF.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
                this.clippedPath.reset();
                this.clippedPath.addRoundRect(this.clippedRectF, this.allRadius, Path.Direction.CCW);
                canvas.clipPath(this.clippedPath);
            }
            super.onDraw(canvas);
            canvas.restoreToCount(save);
        }

        public BottomCornerURLImageView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.clippedRectF = new RectF();
            initView(context, attributeSet, 0);
        }

        public BottomCornerURLImageView(Context context) {
            super(context);
            this.clippedRectF = new RectF();
            initView(context, null, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkShouldShowInternal(Context context, MiniAppConfig miniAppConfig) {
        if (context == null || miniAppConfig == null || !miniAppConfig.isEngineTypeMiniGame()) {
            return;
        }
        try {
            TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
            tianShuAdPosItemData.mPosId = 258;
            tianShuAdPosItemData.mNeedCnt = 1;
            GET_AD_CALLBACK = new GetAdCallback(context, miniAppConfig);
            TianShuManager.getInstance().requestAdv(Collections.singletonList(tianShuAdPosItemData), GET_AD_CALLBACK);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "requestAdBannerPopupInfo", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void showAdBannerPopupWindow(final Context context, final String str, String str2, String str3, final String str4, final TianShuAccess.AdItem adItem) {
        if (context == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4) || !(context instanceof Activity)) {
            return;
        }
        Activity activity = (Activity) context;
        if (activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.f168286tq, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bn8);
        TextView textView = (TextView) inflate.findViewById(R.id.boi);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.bna);
        final Dialog dialog = new Dialog(context);
        dialog.setCancelable(false);
        if (dialog.getWindow() != null) {
            dialog.getWindow().requestFeature(1);
            dialog.getWindow().setBackgroundDrawableResource(17170445);
        }
        dialog.setContentView(inflate, new ViewGroup.LayoutParams(-1, -1));
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.mobileqq.minigame.ui.MiniGameAdBannerPopup.3
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                StorageUtil.getPreference().edit().putLong(MiniGameAdBannerPopup.PREF_KEY_LAST_SHOW_TIME_MILLIS, System.currentTimeMillis()).putInt(MiniGameAdBannerPopup.PREF_KEY_CURRENT_SHOW_TIMES, 1).apply();
                MiniGameAdBannerPopup.performReport(TianShuAccess.AdItem.this, str, 101);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.minigame.ui.MiniGameAdBannerPopup.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dialog.dismiss();
                MiniGameAdBannerPopup.performReport(adItem, str, 122);
            }
        });
        if (!TextUtils.isEmpty(str2)) {
            textView.setText(str2);
        }
        BottomCornerURLImageView bottomCornerURLImageView = new BottomCornerURLImageView(context);
        bottomCornerURLImageView.setAdjustViewBounds(true);
        bottomCornerURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        bottomCornerURLImageView.setClickable(true);
        bottomCornerURLImageView.setImageDrawable(URLDrawable.getDrawable(str3));
        bottomCornerURLImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.minigame.ui.MiniGameAdBannerPopup.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dialog.dismiss();
                if ((context instanceof Activity) && !TextUtils.isEmpty(str4)) {
                    if (MiniAppLauncher.isMiniAppUrl(str4)) {
                        MiniAppLauncher.startMiniApp(context, str4, 2094, null);
                    } else {
                        Activity activity2 = (Activity) context;
                        activity2.startActivity(new Intent(activity2, (Class<?>) QQBrowserActivity.class).putExtra("url", str4));
                    }
                }
                MiniGameAdBannerPopup.performReport(adItem, str, 102);
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 229.0f, context.getResources().getDisplayMetrics()));
        layoutParams.gravity = 1;
        linearLayout.addView(bottomCornerURLImageView, layoutParams);
        dialog.show();
    }
}
