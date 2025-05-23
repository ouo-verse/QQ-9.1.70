package com.tencent.qqmini.minigame.manager;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Html;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qqmini.minigame.R;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.DialogUtil;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.utils.MiniAppUtils;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.widget.MiniCustomDialog;
import common.config.service.QzoneConfig;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GameCloseManager {
    private static final String PREF_KEY_MINI_GAME_CLOSE_CONFIRM_EXPOSURE_TIMES = "pref_key_mini_game_close_confirm_exposure_times";
    private static final String TAG = "GameCloseManager";
    private static final int MINI_GAME_CLOSE_CONFIRM_EXPOSURE_TIMES_THRESHOLD = WnsConfig.getConfig("qqminiapp", WnsConfig.MINI_GAME_EXIT_CONFIRM_ANIMATION_EXPOSURE_TIMES_THRESHOLD, 3);
    private static final String MINI_BATTLE_GAME_SHOW_ALERT_VIEW_SCENES = WnsConfig.getConfig("qqminiapp", QzoneConfig.MINI_GAME_RETAIN_ALERT_VIEW_SCENE, "{\"2\": [\"2072\"],\"3\": [\"1037\"]}");

    private static boolean isFromDesktop(int i3) {
        if (i3 >= 3001 && i3 <= 3010) {
            return true;
        }
        return false;
    }

    private static boolean isInWnsBlackList(int i3) {
        String[] split;
        try {
            String config = WnsConfig.getConfig("qqminiapp", WnsConfig.MINI_GAME_EXIT_CONFIRM_ANIMATION_SCENE_BLACK_LIST, "");
            if (!TextUtils.isEmpty(config) && (split = config.split(",")) != null) {
                for (String str : split) {
                    try {
                    } catch (Exception e16) {
                        QMLog.e(TAG, "isInWnsBlackList", e16);
                    }
                    if (Integer.parseInt(str) == i3) {
                        return true;
                    }
                }
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, "isInWnsBlackList", th5);
        }
        return false;
    }

    private static boolean shouldShowAlertViewForBattleGame(MiniAppInfo miniAppInfo) {
        if (miniAppInfo != null && miniAppInfo.whiteList != null && miniAppInfo.launchParam != null) {
            QMLog.d(TAG, "shouldShowAlertViewForBattleGame api " + Arrays.toString(miniAppInfo.whiteList.toArray()) + " scenes " + MINI_BATTLE_GAME_SHOW_ALERT_VIEW_SCENES);
            for (String str : miniAppInfo.whiteList) {
                if ("showRetainAlterViewType1".equals(str)) {
                    return true;
                }
                if (str.startsWith("showRetainAlterViewType")) {
                    String str2 = MINI_BATTLE_GAME_SHOW_ALERT_VIEW_SCENES;
                    if (TextUtils.isEmpty(str2)) {
                        continue;
                    } else {
                        try {
                            JSONArray optJSONArray = new JSONObject(str2).optJSONArray(str.replace("showRetainAlterViewType", ""));
                            if (optJSONArray != null) {
                                int length = optJSONArray.length();
                                for (int i3 = 0; i3 < length; i3++) {
                                    if (optJSONArray.optInt(i3, 0) == miniAppInfo.launchParam.scene) {
                                        return true;
                                    }
                                }
                            } else {
                                continue;
                            }
                        } catch (Exception e16) {
                            QMLog.e(TAG, "shouldShowAlertViewForBattleGame ", e16);
                        }
                    }
                }
            }
        }
        return false;
    }

    @Deprecated
    public static boolean showAlertViewForBattleGame(IMiniAppContext iMiniAppContext, final DialogInterface.OnClickListener onClickListener) {
        Activity attachActivity = iMiniAppContext.getAttachActivity();
        MiniAppInfo miniAppInfo = iMiniAppContext.getMiniAppInfo();
        if (attachActivity == null || miniAppInfo == null || !shouldShowAlertViewForBattleGame(miniAppInfo)) {
            return false;
        }
        MiniCustomDialog positiveButton = DialogUtil.createCustomDialog(attachActivity, 230).setTitle(attachActivity.getString(R.string.mini_sdk_tip)).setMessage(attachActivity.getString(R.string.mini_sdk_game_leave_battle_game_message)).setNegativeButton(attachActivity.getString(R.string.mini_sdk_cancel), new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.minigame.manager.GameCloseManager.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                dialogInterface.dismiss();
            }
        }).setPositiveButton(attachActivity.getString(R.string.mini_sdk_game_leave_battle_game), new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.minigame.manager.GameCloseManager.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                dialogInterface.dismiss();
                DialogInterface.OnClickListener onClickListener2 = onClickListener;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(dialogInterface, i3);
                }
            }
        });
        positiveButton.setCancelable(false);
        positiveButton.show();
        return true;
    }

    public static boolean showPullDownGuideDialog(IMiniAppContext iMiniAppContext, final DialogInterface.OnClickListener onClickListener) {
        int i3;
        int i16;
        Activity attachActivity = iMiniAppContext.getAttachActivity();
        MiniAppInfo miniAppInfo = iMiniAppContext.getMiniAppInfo();
        if (attachActivity == null || miniAppInfo == null || !QUAUtil.isQQApp()) {
            return false;
        }
        LaunchParam launchParam = miniAppInfo.launchParam;
        if ((launchParam == null || ((i16 = launchParam.scene) != 2001 && i16 != 1001 && !MiniAppUtils.isFromPullDownEntry(miniAppInfo) && !isInWnsBlackList(miniAppInfo.launchParam.scene))) && (i3 = StorageUtil.getPreference().getInt(PREF_KEY_MINI_GAME_CLOSE_CONFIRM_EXPOSURE_TIMES, 0)) < MINI_GAME_CLOSE_CONFIRM_EXPOSURE_TIMES_THRESHOLD) {
            MiniCustomDialog createCustomDialog = DialogUtil.createCustomDialog(attachActivity, 230);
            ImageView imageView = new ImageView(attachActivity);
            String config = WnsConfig.getConfig("qqminiapp", WnsConfig.MINI_GAME_EXIT_CONFIRM_ANIMATION_IMAGE_URL, "https://qzonestyle.gtimg.cn/aoi/sola/20191114160727_AqDlaIYOnx.gif");
            MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
            if (miniAppProxy != null) {
                imageView.setImageDrawable(miniAppProxy.getDrawable(attachActivity, config, 0, 0, null));
            }
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setAdjustViewBounds(true);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if (iMiniAppContext.isOrientationLandscape()) {
                int i17 = attachActivity.getResources().getDisplayMetrics().heightPixels / 2;
                layoutParams.width = i17;
                layoutParams.height = (int) (i17 / 1.05f);
            }
            layoutParams.gravity = 1;
            TextView textView = new TextView(attachActivity);
            textView.setText(Html.fromHtml(attachActivity.getApplicationContext().getString(R.string.mini_sdk_game_close_confirm_hint)), TextView.BufferType.SPANNABLE);
            textView.setTextColor(Color.parseColor("#02081B"));
            textView.setGravity(17);
            textView.setTypeface(Typeface.DEFAULT, 1);
            LinearLayout linearLayout = new LinearLayout(attachActivity);
            linearLayout.setOrientation(1);
            linearLayout.addView(imageView, layoutParams);
            linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 17;
            createCustomDialog.setCancelable(false);
            createCustomDialog.setTitle((String) null).setMessage(null).addView(linearLayout, layoutParams2).setPositiveButton("\u6211\u77e5\u9053\u4e86", new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.minigame.manager.GameCloseManager.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i18) {
                    dialogInterface.dismiss();
                    DialogInterface.OnClickListener onClickListener2 = onClickListener;
                    if (onClickListener2 != null) {
                        onClickListener2.onClick(dialogInterface, i18);
                    }
                }
            });
            createCustomDialog.getBtnight().setTypeface(Typeface.DEFAULT, 1);
            createCustomDialog.show();
            StorageUtil.getPreference().edit().putInt(PREF_KEY_MINI_GAME_CLOSE_CONFIRM_EXPOSURE_TIMES, i3 + 1).apply();
            return true;
        }
        return false;
    }
}
