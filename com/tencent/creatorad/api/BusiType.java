package com.tencent.creatorad.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class BusiType {
    static IPatchRedirector $redirector_ = null;
    public static final int CREATOR_SHARE_ADV_XWORLD = 21;
    public static final int MINI_APP_MINI_GAME = 11;
    public static final int OFFICIAL_ACCOUNT_ADV = 4;
    public static final int OFFICIAL_ACCOUNT_ADV_GAME = 8;
    public static final int OFFICIAL_ACCOUNT_ADV_SHOP = 9;
    public static final int OFFICIAL_ACCOUNT_ADV_VIP = 7;
    public static final int OFFICIAL_ACCOUNT_LAYER_MASK_ADV = 14;
    public static final int OFFICIAL_ACCOUNT_SPORT = 13;
    public static final int OFFICIAL_ACCOUNT_TIAN_QI = 10;
    public static final int PC_QQTAB_ADV = 18;
    public static final int QIQIAOBAN_SDK = 15;
    public static final int QQ_CPS = 16;
    public static final int QQ_WALLET_CPS = 17;
    public static final int QZONE_FEEDS = 0;
    public static final int QZONE_PHOTO_TAIL = 2;
    public static final int QZONE_VIDEO_LAYER = 1;
    public static final int REWARD_GIFT_ADV = 6;
    public static final int REWARD_GROUPGIFT_ADV = 12;
    public static final int REWARD_PERSONAL_ADV = 5;
    public static final int WEISEE_OFFICIAL_ACCOUNT = 3;
    public static final int X_WORLD_CREATOR_ADV = 20;
    public static final int X_WORLD_QZONE_LAYER = 22;
    public static final int X_WORLD_VIDEO_ADV = 19;

    BusiType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
