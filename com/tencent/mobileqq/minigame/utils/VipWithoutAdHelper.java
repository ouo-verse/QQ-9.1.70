package com.tencent.mobileqq.minigame.utils;

import NS_MINI_AD.MiniAppAd$StGetMemberStateRsp;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.servlet.MiniVipWithoutAdServlet;
import com.tencent.mobileqq.mini.utils.MiniGameMMKVUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class VipWithoutAdHelper {
    private static final long DEFAULT_REQ_FREQ = 60000;
    private static final String KEY_MINI_GAME_VIP_WITHOUT_AD_REQ_FREQ = "mini_game_vip_without_ad_req_freq_";
    private static final String KEY_MINI_GAME_VIP_WITHOUT_AD_REQ_TIME = "mini_game_vip_without_ad_req_time_";
    private static final String KEY_MINI_GAME_VIP_WITHOUT_AD_STATE = "mini_game_vip_without_ad_state_";
    private static final String KEY_MINI_GAME_VIP_WITHOUT_AD_TOAST_TEXT = "mini_game_vip_without_ad_toast_text_";
    private static final String TAG = "VipWithoutAdHelper";

    private static String getUin() {
        AppRuntime peekAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
        if (peekAppRuntime == null) {
            return "";
        }
        return peekAppRuntime.getAccount();
    }

    public static boolean getVipWithoutAdMemberState() {
        boolean bool = MiniGameMMKVUtils.INSTANCE.getBool(KEY_MINI_GAME_VIP_WITHOUT_AD_STATE + getUin());
        QLog.d(TAG, 1, "getVipWithoutAdMemberState: " + bool);
        return bool;
    }

    public static long getVipWithoutAdReqFreq() {
        long j3 = MiniGameMMKVUtils.INSTANCE.getLong(KEY_MINI_GAME_VIP_WITHOUT_AD_REQ_FREQ + getUin(), 60000L);
        QLog.d(TAG, 1, "getVipWithoutAdReqFreq: " + j3);
        return j3;
    }

    private static long getVipWithoutAdReqLastTime() {
        long j3 = MiniGameMMKVUtils.INSTANCE.getLong(KEY_MINI_GAME_VIP_WITHOUT_AD_REQ_TIME + getUin());
        QLog.d(TAG, 1, "getVipWithoutAdReqLastTime: " + j3);
        return j3;
    }

    public static String getVipWithoutAdToastText() {
        String string = MiniGameMMKVUtils.INSTANCE.getString(KEY_MINI_GAME_VIP_WITHOUT_AD_TOAST_TEXT + getUin());
        QLog.d(TAG, 1, "getVipWithoutAdToastText: " + string);
        return string;
    }

    private static boolean isRequestFreqEnable() {
        return System.currentTimeMillis() - getVipWithoutAdReqLastTime() > getVipWithoutAdReqFreq();
    }

    public static void recordVipWithoutAdMemberState(boolean z16) {
        MiniGameMMKVUtils.INSTANCE.saveBool(KEY_MINI_GAME_VIP_WITHOUT_AD_STATE + getUin(), z16);
        QLog.d(TAG, 1, "recordVipWithoutAdMemberState: " + z16);
    }

    public static void recordVipWithoutAdReqFreq(Long l3) {
        MiniGameMMKVUtils.INSTANCE.saveLong(KEY_MINI_GAME_VIP_WITHOUT_AD_REQ_FREQ + getUin(), l3.longValue());
        QLog.d(TAG, 1, "recordVipWithoutAdReqFreq: " + l3);
    }

    private static void recordVipWithoutAdReqTime() {
        MiniGameMMKVUtils.INSTANCE.saveLong(KEY_MINI_GAME_VIP_WITHOUT_AD_REQ_TIME + getUin(), System.currentTimeMillis());
    }

    public static void recordVipWithoutAdToastText(String str) {
        MiniGameMMKVUtils.INSTANCE.saveString(KEY_MINI_GAME_VIP_WITHOUT_AD_TOAST_TEXT + getUin(), str);
        QLog.d(TAG, 1, "recordVipWithoutAdToastText: " + str);
    }

    public static void requestVipWithoutAdMemberState() {
        if (!isRequestFreqEnable()) {
            QLog.e(TAG, 1, "requestVipWithoutAdMemberState: freq limit");
        } else {
            recordVipWithoutAdReqTime();
            MiniAppCmdUtil.getInstance().getVipWithoutAdMemberState(new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.minigame.utils.VipWithoutAdHelper.2
                @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                public void onCmdListener(boolean z16, JSONObject jSONObject) {
                    if (jSONObject == null) {
                        QLog.e(VipWithoutAdHelper.TAG, 1, "getVipWithoutAdMemberState receive ret == null");
                        return;
                    }
                    if (z16) {
                        try {
                            VipWithoutAdHelper.handleMemberStateRsp((MiniAppAd$StGetMemberStateRsp) jSONObject.get(MiniVipWithoutAdServlet.KEY_GET_MEMBER_STATE_RSP));
                            return;
                        } catch (Exception e16) {
                            QLog.e(VipWithoutAdHelper.TAG, 1, "getVipWithoutAdMemberState onCmdListener failed e:", e16);
                            return;
                        }
                    }
                    QLog.e(VipWithoutAdHelper.TAG, 1, "getVipWithoutAdMemberState onCmdListener isSuc false");
                }
            });
        }
    }

    public static void showToast() {
        if (getVipWithoutAdMemberState()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.minigame.utils.VipWithoutAdHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    BaseApplication context = BaseApplication.getContext();
                    String vipWithoutAdToastText = VipWithoutAdHelper.getVipWithoutAdToastText();
                    if (TextUtils.isEmpty(vipWithoutAdToastText)) {
                        return;
                    }
                    QQToast.makeText(context, vipWithoutAdToastText, 0).show();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleMemberStateRsp(MiniAppAd$StGetMemberStateRsp miniAppAd$StGetMemberStateRsp) {
        if (miniAppAd$StGetMemberStateRsp == null) {
            QLog.e(TAG, 1, "handleMemberStateRsp rsp is null");
            return;
        }
        if (miniAppAd$StGetMemberStateRsp.is_member.has()) {
            boolean z16 = miniAppAd$StGetMemberStateRsp.is_member.get();
            QLog.d(TAG, 1, "handleMemberStateRsp is_member: " + z16);
            recordVipWithoutAdMemberState(z16);
        }
        if (miniAppAd$StGetMemberStateRsp.toast_text.has()) {
            String str = miniAppAd$StGetMemberStateRsp.toast_text.get();
            QLog.d(TAG, 1, "handleMemberStateRsp toast_text: " + str);
            if (!TextUtils.equals(str, getVipWithoutAdToastText())) {
                recordVipWithoutAdToastText(str);
            }
        }
        if (miniAppAd$StGetMemberStateRsp.freqctrl_in_second.has()) {
            long j3 = miniAppAd$StGetMemberStateRsp.freqctrl_in_second.get() * 1000;
            QLog.d(TAG, 1, "handleMemberStateRsp request freqMs: " + j3);
            if (j3 != getVipWithoutAdReqFreq()) {
                recordVipWithoutAdReqFreq(Long.valueOf(j3));
            }
        }
    }
}
