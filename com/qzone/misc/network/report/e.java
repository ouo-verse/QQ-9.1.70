package com.qzone.misc.network.report;

import android.text.TextUtils;
import cooperation.qzone.QZoneHelper;

/* compiled from: P */
/* loaded from: classes39.dex */
public class e {
    public static void a(int i3, ro.a aVar) {
        String b16 = aVar == null ? null : aVar.b();
        if (TextUtils.isEmpty(b16)) {
            return;
        }
        if (i3 == 0) {
            if ("toolBar".equals(b16)) {
                ClickReport.q("47", "1", "", true);
                return;
            }
            if (b16.contains("getApplist")) {
                ClickReport.q("47", "2", "", true);
                return;
            } else if (b16.contains(QZoneHelper.QZoneAppConstants.REFER_PHOTO_LIST)) {
                ClickReport.q("47", "3", "", true);
                return;
            } else {
                if (b16.contains(".qzone_scheme_refer")) {
                    ClickReport.q("47", "4", "", true);
                    return;
                }
                return;
            }
        }
        if (i3 == 1) {
            if ("toolBar".equals(b16)) {
                ClickReport.q("48", "1", "", true);
                return;
            } else {
                if (b16.contains("getApplist")) {
                    ClickReport.q("48", "2", "", true);
                    return;
                }
                return;
            }
        }
        if (i3 != 3) {
            return;
        }
        if ("toolBar".equals(b16)) {
            ClickReport.q("46", "1", "", true);
        } else if (b16.contains("getApplist")) {
            ClickReport.q("46", "2", "", true);
        } else if (b16.contains(".qzone_scheme_refer")) {
            ClickReport.q("46", "3", "", true);
        }
    }
}
