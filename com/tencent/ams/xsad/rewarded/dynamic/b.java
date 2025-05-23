package com.tencent.ams.xsad.rewarded.dynamic;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.qq.e.tg.rewardAD.RewardDialogContentViewHolder;
import com.tencent.ams.dsdk.cache.ModuleConfigCache;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.data.ModuleInfo;
import com.tencent.ams.xsad.rewarded.RewardedAdData;
import com.tencent.ams.xsad.rewarded.utils.c;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static String a(RewardedAdData rewardedAdData) {
        if (rewardedAdData == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("maxUnlockTime", rewardedAdData.f71693g);
            jSONObject.put("unlockCountdownTipsText", rewardedAdData.f71694h);
            jSONObject.put("unlockCloseTipsText", rewardedAdData.f71692f);
            jSONObject.put("unlockSuccessTipsText", rewardedAdData.f71695i);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("url", rewardedAdData.f71691e);
            if (rewardedAdData.f71702p != null) {
                jSONObject2.put("videoParams", new JSONObject(rewardedAdData.f71702p));
            }
            jSONObject.put(AppConstants.Key.KEY_QZONE_VIDEO_URL, jSONObject2.toString());
            jSONObject.put("duration", rewardedAdData.f71690d);
            Map<String, Object> map = rewardedAdData.f71702p;
            if (map != null && map.containsKey("fileSize")) {
                jSONObject.put("fileSize", rewardedAdData.f71702p.get("fileSize"));
            }
            Map<String, Object> map2 = rewardedAdData.f71702p;
            if (map2 != null && map2.containsKey("vid")) {
                jSONObject.put("vid", rewardedAdData.f71702p.get("vid"));
            }
            jSONObject.put("posterUrl", rewardedAdData.f71705s);
            jSONObject.put("videoWidth", rewardedAdData.f71706t);
            jSONObject.put("videoHeight", rewardedAdData.f71707u);
            jSONObject.put("title", rewardedAdData.f71697k);
            jSONObject.put("subtitle", rewardedAdData.f71698l);
            jSONObject.put("iconUrl", rewardedAdData.f71696j);
            jSONObject.put("actionButtonTitle", rewardedAdData.f71699m);
            jSONObject.put("actionButtonTitleColor", rewardedAdData.f71701o);
            jSONObject.put("actionButtonBgColor", rewardedAdData.f71700n);
            jSONObject.put(RewardDialogContentViewHolder.Key.SCREEN_ORIENTATION, e(rewardedAdData.f71689c) ? 1 : 0);
            if (rewardedAdData.f71704r != null) {
                jSONObject.put("extendInfo", new JSONObject(rewardedAdData.f71704r));
            }
            jSONObject.put("displayType", rewardedAdData.f71712z);
            jSONObject.put("landingPageUrl", rewardedAdData.B);
            jSONObject.put("rewardType", rewardedAdData.A);
            jSONObject.put("isRewarded", rewardedAdData.C);
        } catch (Throwable th5) {
            c.b("DKRewardedAdUtils", "convert data error.", th5);
        }
        return jSONObject.toString();
    }

    public static int b(int i3) {
        if (i3 == 0) {
            return 1;
        }
        if (i3 == 1) {
            return 0;
        }
        if (i3 == 2) {
            return 9;
        }
        if (i3 == 3) {
            return 8;
        }
        return -1;
    }

    public static ModuleInfo c() {
        try {
            String vendorPath = DKEngine.getVendorPath();
            String bundlePath = DKEngine.getBundlePath(DKEngine.DKModuleID.REWARD_AD);
            if (!TextUtils.isEmpty(vendorPath) && !TextUtils.isEmpty(bundlePath)) {
                return ModuleConfigCache.getModuleInfo(DKEngine.DKModuleID.REWARD_AD);
            }
            return null;
        } catch (Throwable th5) {
            c.b("DKRewardedAdUtils", "get reward module info error.", th5);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int d(Context context) {
        Display display;
        int i3;
        if (context != null) {
            if (Build.VERSION.SDK_INT >= 30) {
                display = context.getDisplay();
            } else {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                if (windowManager != null) {
                    display = windowManager.getDefaultDisplay();
                }
            }
            if (display == null) {
                i3 = display.getRotation();
            } else {
                i3 = 0;
            }
            c.c("DKRewardedAdUtils", "getScreenOrientation, orientation: " + i3);
            return i3;
        }
        display = null;
        if (display == null) {
        }
        c.c("DKRewardedAdUtils", "getScreenOrientation, orientation: " + i3);
        return i3;
    }

    public static boolean e(int i3) {
        if (i3 == 1 || i3 == 3) {
            return true;
        }
        return false;
    }
}
