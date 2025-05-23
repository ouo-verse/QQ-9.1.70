package com.qzone.proxy.feedcomponent.util;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;

/* compiled from: P */
/* loaded from: classes39.dex */
public class i {
    public static boolean d(BusinessFeedData businessFeedData) {
        return c(businessFeedData, 7);
    }

    public static boolean e(BusinessFeedData businessFeedData) {
        return a(businessFeedData, 27);
    }

    public static boolean f(BusinessFeedData businessFeedData) {
        return a(businessFeedData, 24);
    }

    public static boolean g(BusinessFeedData businessFeedData) {
        return b(businessFeedData, 22);
    }

    public static boolean h(BusinessFeedData businessFeedData) {
        return b(businessFeedData, 18);
    }

    public static boolean i(BusinessFeedData businessFeedData) {
        return a(businessFeedData, 30);
    }

    public static boolean a(BusinessFeedData businessFeedData, int i3) {
        if (businessFeedData != null) {
            return (businessFeedData.getFeedCommInfo().operatemask & (1 << i3)) != 0;
        }
        com.qzone.proxy.feedcomponent.b.i("OperatemaskUtil", "BusinessFeedData is null while checkActionEnabled for actionType " + i3 + "!");
        return false;
    }

    public static boolean b(BusinessFeedData businessFeedData, int i3) {
        if (businessFeedData != null && businessFeedData.getFeedCommInfo() != null) {
            r0 = (businessFeedData.getFeedCommInfo().operatemask2 & (1 << i3)) != 0;
            if (com.qzone.proxy.feedcomponent.b.g()) {
                com.qzone.proxy.feedcomponent.b.a("OperatemaskUtil", "checkActionEnabledForOperatemask2 actiontype: " + i3 + ", operatemask2: " + businessFeedData.getFeedCommInfo().operatemask2 + ", result: " + r0);
            }
        }
        return r0;
    }

    public static boolean c(BusinessFeedData businessFeedData, int i3) {
        return (businessFeedData == null || businessFeedData.getFeedCommInfo() == null || (businessFeedData.getFeedCommInfo().operatemask3 & ((long) (1 << i3))) == 0) ? false : true;
    }
}
