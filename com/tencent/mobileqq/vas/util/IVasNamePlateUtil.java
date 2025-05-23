package com.tencent.mobileqq.vas.util;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasNamePlateUtil extends QRouteApi {
    public static final String BIG_VIP_NP_KEY = "bigclub_np_jump_url";
    public static final String DEFAULT_STAR_URL = "https://club.vip.qq.com/qqvip/svip-star/privilege?_wv=16777221&_proxy=1";
    public static final String DEFAULT_URL = "https://club.vip.qq.com/medal/mine?_proxy=1&_wvx=10&_wv=16777216&_wwv=4";
    public static final String FEATURE_NAME = "nameplate_jump_url";
    public static final String STAR_NP_KEY = "star_np_jump_url";
    public static final String VIP_NP_KEY = "vip_np_jump_url";

    /* loaded from: classes20.dex */
    public static class VipIconClickConfig {
        public String ctocGuestUrl;
        public String ctocSettingGuestUrl;
        public String ctocSettingUrl;
        public String ctocUrl;
        public String drawerUrl;
        public String itemId;
        public String nameplateType;
        public String vaProfileGuestUrl;
        public String vaProfileUrl;
        public String vipType;

        public VipIconClickConfig() {
        }

        public boolean equals(@Nullable Object obj) {
            if (obj instanceof VipIconClickConfig) {
                VipIconClickConfig vipIconClickConfig = (VipIconClickConfig) obj;
                if (TextUtils.equals(vipIconClickConfig.vipType, this.vipType) && TextUtils.equals(vipIconClickConfig.itemId, this.itemId) && TextUtils.equals(vipIconClickConfig.nameplateType, this.nameplateType)) {
                    return true;
                }
                return false;
            }
            return super.equals(obj);
        }

        public VipIconClickConfig(String str, String str2, String str3) {
            this.vipType = str;
            this.itemId = str2;
            this.nameplateType = str3;
        }
    }

    VipIconClickConfig findConfig(int i3, int i16, int i17);

    String obtainNpJumpUrl(AppRuntime appRuntime, String str);

    void preBuildConfig(boolean z16);
}
