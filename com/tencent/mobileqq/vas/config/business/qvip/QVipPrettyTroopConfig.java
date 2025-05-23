package com.tencent.mobileqq.vas.config.business.qvip;

/* loaded from: classes20.dex */
public class QVipPrettyTroopConfig {
    private static final String DEFAULT_CREAT_2K = "https://mc.vip.qq.com/group/create2k?_wwv=4&_wv=1027&_wvx=3";
    private static final String DEFAULT_CREAT_3K = "https://mc.vip.qq.com/group/create3k?_wwv=4&_wv=1027&_wvx=3";
    private static final String DEFAULT_HOME_URL = "https://club.vip.qq.com/grouphaoma/home?_wv=16778247&_wvx=10&_proxy=1&from={from}";
    private static final String DEFAULT_MINE_URL = "https://club.vip.qq.com/grouphaoma/mine?_wv=1031&_wvx=10&_proxy=1&from={from}&groupnum={groupnum}";
    public boolean groupCareLimitOff = false;
    public boolean showCreateIcon = true;

    public String get2KUrl() {
        return DEFAULT_CREAT_2K;
    }

    public String get3KUrl() {
        return DEFAULT_CREAT_3K;
    }

    public String getHomeUrl(String str) {
        return DEFAULT_HOME_URL.replace("{from}", str);
    }

    public String getMineUrl(String str, String str2) {
        return DEFAULT_MINE_URL.replace("{from}", str).replace("{groupnum}", str2);
    }
}
