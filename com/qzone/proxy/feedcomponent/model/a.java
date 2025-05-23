package com.qzone.proxy.feedcomponent.model;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {
    public static boolean a(BusinessFeedData businessFeedData) {
        return !businessFeedData.getFeedCommInfo().displayTimeStrValid();
    }

    public static String b(BusinessFeedData businessFeedData) {
        return businessFeedData.getFeedCommInfo().getDisplayTimeString();
    }
}
