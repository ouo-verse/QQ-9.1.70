package com.qzone.proxy.feedcomponent.util;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;

/* compiled from: P */
/* loaded from: classes39.dex */
public class f {
    public static boolean c(BusinessFeedData businessFeedData) {
        return b(businessFeedData) || a(businessFeedData);
    }

    public static boolean a(BusinessFeedData businessFeedData) {
        return (businessFeedData == null || businessFeedData.getOriginalInfo() == null || businessFeedData.getOriginalInfo().getCellLuckyMoney() == null) ? false : true;
    }

    public static boolean b(BusinessFeedData businessFeedData) {
        return (businessFeedData == null || businessFeedData.getCellLuckyMoney() == null) ? false : true;
    }
}
