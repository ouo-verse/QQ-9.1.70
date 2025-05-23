package com.qzone.component.banner.util;

import android.content.Context;
import android.text.TextUtils;
import com.qzone.album.business.albumlist.activity.QZonePersonalAlbumActivity;
import com.qzone.component.banner.BusinessADBannerData;
import com.qzone.misc.network.report.ClickReport;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {
    public static void e(int i3, boolean z16) {
        String str;
        String str2;
        String str3 = "";
        if (i3 == 3) {
            str = "92";
        } else {
            if (i3 > 3) {
                str3 = i3 + "";
            }
            str = "91";
        }
        if (z16) {
            str2 = "2";
        } else {
            str2 = "1";
        }
        if (TextUtils.isEmpty("302") || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        ClickReport.p("302", str, str2, str3, true);
    }

    public static void c(int i3, String str, boolean z16) {
        String[] strArr = new String[5];
        strArr[0] = String.valueOf(302);
        strArr[1] = String.valueOf(14);
        strArr[2] = String.valueOf(i3);
        strArr[3] = "0";
        if (str == null) {
            str = null;
        }
        strArr[4] = str;
        ClickReport.r("0", "", "", z16, strArr);
    }

    public static void d(int i3, boolean z16, long j3) {
        b(i3, 0, z16, String.valueOf(j3), false);
    }

    public static void a(int i3) {
        c(i3, null, false);
    }

    public static void f(Context context, int i3, BusinessADBannerData businessADBannerData, boolean z16) {
        if (context == null || businessADBannerData == null || businessADBannerData.eAdType == 4) {
            return;
        }
        ClickReport.r("0", "", "", z16, String.valueOf(425), String.valueOf(context instanceof QZonePersonalAlbumActivity ? 4 : 0), String.valueOf(i3), "0", String.valueOf(businessADBannerData.iAdID));
    }

    public static void b(int i3, int i16, boolean z16, String str, boolean z17) {
        int i17;
        if (i3 != 2) {
            if (i3 != 5) {
                if (i3 == 10) {
                    i17 = z16 ? 209 : 208;
                }
                i17 = -1;
            } else {
                i17 = z16 ? 102 : 101;
            }
        } else if (i16 == 2) {
            i17 = z16 ? 2 : 1;
        } else {
            if (i16 == 1) {
                i17 = z16 ? 4 : 3;
            }
            i17 = -1;
        }
        if (i17 == -1) {
            return;
        }
        String[] strArr = new String[5];
        strArr[0] = String.valueOf(302);
        strArr[1] = String.valueOf(14);
        strArr[2] = String.valueOf(i17);
        strArr[3] = "0";
        if (str == null) {
            str = null;
        }
        strArr[4] = str;
        ClickReport.r("0", "", "", z17, strArr);
    }
}
