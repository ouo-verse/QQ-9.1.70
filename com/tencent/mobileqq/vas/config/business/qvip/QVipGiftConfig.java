package com.tencent.mobileqq.vas.config.business.qvip;

import androidx.annotation.Keep;
import java.io.Serializable;

/* compiled from: P */
@Keep
/* loaded from: classes20.dex */
public class QVipGiftConfig implements Serializable {
    private boolean enable = false;
    public String troopAioUrl = "https://h5.qzone.qq.com/v2/vip/qun-gift/aio-dialog?_wv=16781315&_wwv=13&themeMode={themeMode}&uin={uin}&troopUin={troopUin}";
    public String troopGiftUrl = "https://qun.qq.com/qunpay/gifts/index.html?troopUin=<$GC>&uin=<$UIN>&name=<$NICK>&from=<$FROM>&_wv=1031&_bid=2204&_wvSb=1&_nav_alpha=0";
    public String anonymousFlag = "63c3ba3a1c244415af156c3fd1fc339d";

    public boolean isEnable() {
        return this.enable;
    }
}
