package NS_MOBILE_FEEDS;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class e_ad_report_cookie implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int _ADV_LANDING_PAGE_REPORT_URL = 15;
    public static final int _ADV_POSI = 10;
    public static final int _ADV_REPORT_TYPE = 14;
    public static final int _ADV_SHOW_TYPE = 8;
    public static final int _ADV_UNIQ_ID = 9;
    public static final int _AD_DROPLIST_ATTACH = 11;
    public static final int _AD_ENTRY_VIDEO_KEY = 12;
    public static final int _AD_FEED_PAGEUIN = 4;
    public static final int _AD_FEED_QUERYSTRING = 2;
    public static final int _AD_FEED_SENCE = 6;
    public static final int _AD_FEED_TOPICID = 7;
    public static final int _AD_FEED_TRACEID = 3;
    public static final int _AD_FEED_TYPE = 0;
    public static final int _AD_FEED_VIEWID = 1;
    public static final int _AD_VID = 13;
    public static final int _AD_VIDEO_SOURCE = 5;
    private String __T;
    private int __value;
    private static e_ad_report_cookie[] __values = new e_ad_report_cookie[5];
    public static final e_ad_report_cookie AD_FEED_TYPE = new e_ad_report_cookie(0, 0, "AD_FEED_TYPE");
    public static final e_ad_report_cookie AD_FEED_VIEWID = new e_ad_report_cookie(1, 1, "AD_FEED_VIEWID");
    public static final e_ad_report_cookie AD_FEED_QUERYSTRING = new e_ad_report_cookie(2, 2, "AD_FEED_QUERYSTRING");
    public static final e_ad_report_cookie AD_FEED_TRACEID = new e_ad_report_cookie(3, 3, "AD_FEED_TRACEID");
    public static final e_ad_report_cookie AD_FEED_PAGEUIN = new e_ad_report_cookie(4, 4, "AD_FEED_PAGEUIN");

    e_ad_report_cookie(int i3, int i16, String str) {
        new String();
        this.__T = str;
        this.__value = i16;
        __values[i3] = this;
    }

    public static e_ad_report_cookie convert(int i3) {
        int i16 = 0;
        while (true) {
            e_ad_report_cookie[] e_ad_report_cookieVarArr = __values;
            if (i16 >= e_ad_report_cookieVarArr.length) {
                return null;
            }
            if (e_ad_report_cookieVarArr[i16].value() == i3) {
                return __values[i16];
            }
            i16++;
        }
    }

    public String toString() {
        return this.__T;
    }

    public int value() {
        return this.__value;
    }

    public static e_ad_report_cookie convert(String str) {
        int i3 = 0;
        while (true) {
            e_ad_report_cookie[] e_ad_report_cookieVarArr = __values;
            if (i3 >= e_ad_report_cookieVarArr.length) {
                return null;
            }
            if (e_ad_report_cookieVarArr[i3].toString().equals(str)) {
                return __values[i3];
            }
            i3++;
        }
    }
}
