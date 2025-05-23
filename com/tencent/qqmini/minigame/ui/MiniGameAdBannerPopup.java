package com.tencent.qqmini.minigame.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.minigame.R;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.utils.MiniAppLauncher;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.widget.MiniToast;
import cooperation.vip.pb.TianShuAccess;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public class MiniGameAdBannerPopup {
    private static final String PREF_KEY_CURRENT_SHOW_TIMES = "pref_key_banner_ad_current_show_times";
    private static final String PREF_KEY_LAST_SHOW_TIME_MILLIS = "pref_key_banner_ad_popup_last_show_time_millis";
    private static final String TAG = "MiniGameAdBannerPopup";
    private static final String WNS_KEY_SHOW_DELAY_SECONDS_AFTER_GAME_LAUNCH = "banner_ad_popup_show_delay_seconds_after_game_launch";
    private static int SHOW_DELAY_SECONDS_AFTER_GAME_LAUNCH = WnsConfig.getConfig("qqminiapp", WNS_KEY_SHOW_DELAY_SECONDS_AFTER_GAME_LAUNCH, 0);
    private static final String WNS_KEY_APPID_WHITE_LIST = "banner_ad_popup_appid_white_list";
    private static String APPID_WHITE_LIST = WnsConfig.getConfig("qqminiapp", WNS_KEY_APPID_WHITE_LIST, "");
    private static final String WNS_KEY_APPID_BLACK_LIST = "banner_ad_popup_appid_black_list";
    private static String APPID_BLACK_LIST = WnsConfig.getConfig("qqminiapp", WNS_KEY_APPID_BLACK_LIST, "");
    private static final String WNS_KEY_REFER_WHITE_LIST = "banner_ad_popup_refer_white_list";
    private static String REFER_WHITE_LIST = WnsConfig.getConfig("qqminiapp", WNS_KEY_REFER_WHITE_LIST, "");
    private static final String WNS_KEY_REFER_BLACK_LIST = "banner_ad_popup_refer_black_list";
    private static String REFER_BLACK_LIST = WnsConfig.getConfig("qqminiapp", WNS_KEY_REFER_BLACK_LIST, "");
    public static int NEED_ADS_ID_COUNT = 10;

    private static boolean allowShowForAppId(String str) {
        try {
        } catch (Exception e16) {
            QMLog.e(TAG, "allowShowForAppId", e16);
        }
        if (TextUtils.isEmpty(APPID_WHITE_LIST) && TextUtils.isEmpty(APPID_BLACK_LIST)) {
            return true;
        }
        QMLog.d(TAG, "allowShowForAppId check if appid " + str + " in whitelist " + APPID_WHITE_LIST + " or blacklist " + APPID_BLACK_LIST);
        if (!TextUtils.isEmpty(APPID_WHITE_LIST)) {
            return checkWhiteList(str);
        }
        if (!TextUtils.isEmpty(APPID_BLACK_LIST)) {
            return checkBlackList(str);
        }
        return true;
    }

    private static boolean allowShowForRefer(int i3) {
        String[] blackListRefers;
        try {
            if (TextUtils.isEmpty(REFER_WHITE_LIST) && TextUtils.isEmpty(REFER_BLACK_LIST)) {
                return true;
            }
            QMLog.d(TAG, "allowShowForRefer check if scene " + i3 + " in whitelist " + REFER_WHITE_LIST + " or blacklist " + REFER_BLACK_LIST);
            if (!TextUtils.isEmpty(REFER_WHITE_LIST)) {
                String[] whiteListRefers = getWhiteListRefers();
                if (whiteListRefers != null) {
                    for (String str : whiteListRefers) {
                        if (Integer.parseInt(str) == i3) {
                            return true;
                        }
                    }
                }
                return false;
            }
            if (!TextUtils.isEmpty(REFER_BLACK_LIST) && (blackListRefers = getBlackListRefers()) != null) {
                for (String str2 : blackListRefers) {
                    if (Integer.parseInt(str2) == i3) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Exception e16) {
            QMLog.e(TAG, "allowShowForRefer", e16);
        }
        return true;
    }

    private static boolean checkBlackList(String str) {
        String str2;
        String str3 = ",";
        if (APPID_BLACK_LIST.contains(",")) {
            str2 = APPID_BLACK_LIST;
        } else {
            str2 = APPID_BLACK_LIST;
            str3 = ";";
        }
        String[] split = str2.split(str3);
        if (split != null) {
            for (String str4 : split) {
                if (str4 != null && str4.equals(str)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public static void checkShouldShow(final Context context, final String str, final int i3, final int i16) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.ui.MiniGameAdBannerPopup.1
            @Override // java.lang.Runnable
            public void run() {
                MiniGameAdBannerPopup.checkShouldShowInternal(context, str, i3, i16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkShouldShowInternal(Context context, final String str, final int i3, final int i16) {
        if (context != null && str != null) {
            final WeakReference weakReference = new WeakReference(context);
            if (!((ChannelProxy) ProxyManager.get(ChannelProxy.class)).tianshuRequestAdv(context, str, i3, 258, i16 + 1, new AsyncResult() { // from class: com.tencent.qqmini.minigame.ui.MiniGameAdBannerPopup.3
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                    try {
                        if (z16) {
                            TianShuAccess.GetAdsRsp getAdsRsp = (TianShuAccess.GetAdsRsp) jSONObject.get("response");
                            QMLog.d(MiniGameAdBannerPopup.TAG, "onGetAdvs() called with: result = [" + jSONObject + "], getAdsRsp = [" + getAdsRsp + "]");
                            WeakReference weakReference2 = weakReference;
                            if (weakReference2 != null && weakReference2.get() != null) {
                                MiniGameAdBannerPopup.handleGetAdResult((Context) weakReference.get(), str, i3, z16, getAdsRsp, i16);
                            }
                        } else {
                            WeakReference weakReference3 = weakReference;
                            if (weakReference3 != null && weakReference3.get() != null) {
                                MiniGameAdBannerPopup.handleGetAdResult((Context) weakReference.get(), str, i3, z16, null, i16);
                            }
                        }
                    } catch (Exception e16) {
                        QMLog.e(MiniGameAdBannerPopup.TAG, "tianshuRequestAdv onReceiveResult", e16);
                    }
                }
            })) {
                MiniToast.makeText(context, 0, "\u6682\u4e0d\u652f\u6301\u5728" + QUAUtil.getApplicationName(context) + "\u4e2d\u8bf7\u6c42\u5e7f\u544a\u5f39\u7a97", 1);
                handleGetAdResult(context, str, i3, false, null, i16);
            }
        }
    }

    private static boolean checkWhiteList(String str) {
        String str2;
        String str3 = ",";
        if (APPID_WHITE_LIST.contains(",")) {
            str2 = APPID_WHITE_LIST;
        } else {
            str2 = APPID_WHITE_LIST;
            str3 = ";";
        }
        String[] split = str2.split(str3);
        if (split != null) {
            for (String str4 : split) {
                if (str4 != null && str4.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static String[] getBlackListRefers() {
        String str;
        String str2 = ",";
        if (REFER_BLACK_LIST.contains(",")) {
            str = REFER_BLACK_LIST;
        } else {
            str = REFER_BLACK_LIST;
            str2 = ";";
        }
        return str.split(str2);
    }

    private static String[] getWhiteListRefers() {
        String str;
        String str2 = ",";
        if (REFER_WHITE_LIST.contains(",")) {
            str = REFER_WHITE_LIST;
        } else {
            str = REFER_WHITE_LIST;
            str2 = ";";
        }
        return str.split(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleGetAdResult(Context context, String str, int i3, boolean z16, TianShuAccess.GetAdsRsp getAdsRsp, int i16) {
        String str2;
        String str3;
        String str4;
        String str5;
        TianShuAccess.AdItem adItem;
        TianShuAccess.AdItem adItem2;
        String str6;
        String str7;
        String str8;
        TianShuAccess.AdPlacementInfo adPlacementInfo;
        PBRepeatMessageField<TianShuAccess.MapEntry> pBRepeatMessageField;
        String str9 = null;
        if (z16 && getAdsRsp != null) {
            if (!getAdsRsp.mapAds.isEmpty()) {
                if (i16 > getAdsRsp.mapAds.size() - 1) {
                    return;
                }
                TianShuAccess.RspEntry rspEntry = getAdsRsp.mapAds.get(i16);
                if (rspEntry != null && (adPlacementInfo = rspEntry.value) != null && !adPlacementInfo.lst.isEmpty()) {
                    adItem2 = rspEntry.value.lst.get(0);
                    if (adItem2 != null && (pBRepeatMessageField = adItem2.argList) != null && !pBRepeatMessageField.isEmpty()) {
                        str6 = null;
                        str7 = null;
                        str8 = null;
                        for (TianShuAccess.MapEntry mapEntry : adItem2.argList.get()) {
                            if ("type".equals(mapEntry.key.get())) {
                                str9 = mapEntry.value.get();
                            } else if ("url".equals(mapEntry.key.get())) {
                                str6 = mapEntry.value.get();
                            } else if ("text".equals(mapEntry.key.get())) {
                                str7 = mapEntry.value.get();
                            } else if ("pic".equals(mapEntry.key.get())) {
                                str8 = mapEntry.value.get();
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
                                    QMLog.e(TAG, "handleGetAdResult", e16);
                                }
                            }
                        }
                        adItem = adItem2;
                        str3 = str6;
                        str2 = str9;
                        str4 = str7;
                        str5 = str8;
                        QMLog.d(TAG, "handleGetAdResult appid whitelist " + APPID_WHITE_LIST + "\n appid blacklist " + APPID_BLACK_LIST + "\n refer whitelist " + REFER_WHITE_LIST + "\n refer blacklist " + REFER_BLACK_LIST + "\n show time " + SHOW_DELAY_SECONDS_AFTER_GAME_LAUNCH);
                        showAdBanner(context, str, i3, str2, str3, str4, str5, adItem);
                    }
                    QMLog.e(TAG, "onGetAdvs no ad item");
                } else {
                    QMLog.e(TAG, "onGetAdvs no ad data");
                }
                adItem2 = null;
                str6 = null;
                str7 = null;
                str8 = null;
                adItem = adItem2;
                str3 = str6;
                str2 = str9;
                str4 = str7;
                str5 = str8;
                QMLog.d(TAG, "handleGetAdResult appid whitelist " + APPID_WHITE_LIST + "\n appid blacklist " + APPID_BLACK_LIST + "\n refer whitelist " + REFER_WHITE_LIST + "\n refer blacklist " + REFER_BLACK_LIST + "\n show time " + SHOW_DELAY_SECONDS_AFTER_GAME_LAUNCH);
                showAdBanner(context, str, i3, str2, str3, str4, str5, adItem);
            }
        } else {
            QMLog.e(TAG, "onGetAdvs no ad result");
        }
        str2 = null;
        str3 = null;
        str4 = null;
        str5 = null;
        adItem = null;
        QMLog.d(TAG, "handleGetAdResult appid whitelist " + APPID_WHITE_LIST + "\n appid blacklist " + APPID_BLACK_LIST + "\n refer whitelist " + REFER_WHITE_LIST + "\n refer blacklist " + REFER_BLACK_LIST + "\n show time " + SHOW_DELAY_SECONDS_AFTER_GAME_LAUNCH);
        showAdBanner(context, str, i3, str2, str3, str4, str5, adItem);
    }

    private static boolean isParamEmpty(Context context, String str, String str2, String str3) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void performReport(final TianShuAccess.AdItem adItem, final String str, final int i3) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.ui.MiniGameAdBannerPopup.8
            @Override // java.lang.Runnable
            public void run() {
                ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).tianshuReport(TianShuAccess.AdItem.this, str, i3);
            }
        });
    }

    public static void reqAdItemAdIds(final Context context, final String str, final int i3, final AsyncResult asyncResult) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.ui.MiniGameAdBannerPopup.2
            @Override // java.lang.Runnable
            public void run() {
                ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).tianshuRequestAdv(context, str, i3, 258, MiniGameAdBannerPopup.NEED_ADS_ID_COUNT, asyncResult);
            }
        });
    }

    private static void showAdBanner(final Context context, String str, int i3, final String str2, final String str3, final String str4, final String str5, final TianShuAccess.AdItem adItem) {
        if (!allowShowForAppId(str)) {
            QMLog.e(TAG, "handleGetAdResult not allow for appid " + str);
            return;
        }
        if (!allowShowForRefer(i3)) {
            QMLog.e(TAG, "handleGetAdResult not allow for refer " + i3);
            return;
        }
        if (str2 != null && str3 != null && str4 != null && str5 != null && adItem != null) {
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.qqmini.minigame.ui.MiniGameAdBannerPopup.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        MiniGameAdBannerPopup.showAdBannerPopupWindow(context, str2, str4, str5, str3, adItem);
                    } catch (Throwable th5) {
                        QMLog.e(MiniGameAdBannerPopup.TAG, "showAdBannerPopupWindow exception", th5);
                    }
                }
            }, TimeUnit.SECONDS.toMillis(SHOW_DELAY_SECONDS_AFTER_GAME_LAUNCH));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void showAdBannerPopupWindow(final Context context, final String str, String str2, String str3, final String str4, final TianShuAccess.AdItem adItem) {
        if (isParamEmpty(context, str2, str3, str4) || !(context instanceof Activity)) {
            return;
        }
        Activity activity = (Activity) context;
        if (!activity.isFinishing() && !activity.isDestroyed()) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.mini_sdk_ad_banner_popup_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.mini_sdk_ad_banner_popup_dialog_title);
            final ReportDialog reportDialog = new ReportDialog(context);
            reportDialog.setCancelable(false);
            if (reportDialog.getWindow() != null) {
                reportDialog.getWindow().requestFeature(1);
                reportDialog.getWindow().setBackgroundDrawableResource(17170445);
            }
            reportDialog.setContentView(inflate, new ViewGroup.LayoutParams(-1, -1));
            reportDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.qqmini.minigame.ui.MiniGameAdBannerPopup.5
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    StorageUtil.getPreference().edit().putLong(MiniGameAdBannerPopup.PREF_KEY_LAST_SHOW_TIME_MILLIS, System.currentTimeMillis()).putInt(MiniGameAdBannerPopup.PREF_KEY_CURRENT_SHOW_TIMES, 1).apply();
                    MiniGameAdBannerPopup.performReport(TianShuAccess.AdItem.this, str, 101);
                }
            });
            ((ImageView) inflate.findViewById(R.id.mini_sdk_ad_banner_popup_dialog_close_button)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqmini.minigame.ui.MiniGameAdBannerPopup.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    reportDialog.dismiss();
                    MiniGameAdBannerPopup.performReport(adItem, str, 122);
                    EventCollector.getInstance().onViewClicked(view);
                }
            });
            if (!TextUtils.isEmpty(str2)) {
                textView.setText(str2);
            }
            BottomCornerURLImageView bottomCornerURLImageView = new BottomCornerURLImageView(context);
            bottomCornerURLImageView.setAdjustViewBounds(true);
            bottomCornerURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            bottomCornerURLImageView.setClickable(true);
            final MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
            bottomCornerURLImageView.setImageDrawable(miniAppProxy.getDrawable(context, str3, 0, 0, null));
            bottomCornerURLImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqmini.minigame.ui.MiniGameAdBannerPopup.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    reportDialog.dismiss();
                    if ((context instanceof Activity) && !TextUtils.isEmpty(str4)) {
                        if (MiniAppLauncher.isMiniAppUrl(str4)) {
                            MiniSDK.startMiniApp((Activity) context, str4, 2094, (ResultReceiver) null);
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra("url", str4);
                            miniAppProxy.startBrowserActivity((Activity) context, intent);
                        }
                    }
                    MiniGameAdBannerPopup.performReport(adItem, str, 102);
                    EventCollector.getInstance().onViewClicked(view);
                }
            });
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 229.0f, context.getResources().getDisplayMetrics()));
            layoutParams.gravity = 1;
            ((LinearLayout) inflate.findViewById(R.id.mini_game_ad_banner_popup_dialog_content_layout)).addView(bottomCornerURLImageView, layoutParams);
            reportDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static class BottomCornerURLImageView extends ImageView {
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
}
