package com.tencent.mobileqq.guild.api.impl;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.Map;

/* compiled from: P */
@Deprecated
/* loaded from: classes12.dex */
public class e {
    public static void a(View view, @Nullable String str, @Nullable String str2, @Nullable Map<String, ?> map, @Nullable ExposurePolicy exposurePolicy, @Nullable EndExposurePolicy endExposurePolicy, @Nullable ClickPolicy clickPolicy) {
        if (str != null) {
            VideoReport.setPageId(view, str);
        }
        if (str2 != null) {
            VideoReport.setElementId(view, str2);
        }
        if (map != null) {
            VideoReport.setElementParams(view, map);
        }
        if (exposurePolicy != null) {
            VideoReport.setElementExposePolicy(view, exposurePolicy);
        }
        if (endExposurePolicy != null) {
            VideoReport.setElementEndExposePolicy(view, endExposurePolicy);
        }
        if (clickPolicy != null) {
            VideoReport.setElementClickPolicy(view, clickPolicy);
        }
    }

    public static void b(Object obj, String str) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
                    c16 = 0;
                    break;
                }
                break;
            case 49:
                if (str.equals("1")) {
                    c16 = 1;
                    break;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    c16 = 2;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                VideoReport.setElementExposePolicy(obj, ExposurePolicy.REPORT_NONE);
                return;
            case 1:
                VideoReport.setElementExposePolicy(obj, ExposurePolicy.REPORT_FIRST);
                return;
            case 2:
                VideoReport.setElementExposePolicy(obj, ExposurePolicy.REPORT_ALL);
                return;
            default:
                return;
        }
    }

    public static boolean c(Object obj, String str) {
        if (obj != null && !TextUtils.isEmpty(str)) {
            try {
                VideoReport.setElementId(obj, str);
                return true;
            } catch (Exception e16) {
                Log.d("Guild.report.GuildDTReportWraper", "Tatong setElementId elementObject=" + obj + ",ElementID=" + str + ",exception=[" + e16.getMessage() + "]");
            }
        }
        return false;
    }

    public static void d(Object obj, String str) {
        str.hashCode();
        if (!str.equals("0")) {
            if (str.equals("1")) {
                VideoReport.setElementClickPolicy(obj, ClickPolicy.REPORT_ALL);
                return;
            }
            return;
        }
        VideoReport.setElementClickPolicy(obj, ClickPolicy.REPORT_NONE);
    }

    public static boolean e(Object obj, Map<String, Object> map) {
        if (obj != null && map != null && map.size() != 0) {
            try {
                VideoReport.setElementParams(obj, map);
                return true;
            } catch (Exception e16) {
                Log.d("Guild.report.GuildDTReportWraper", "Tatong setElementParams elementObject=" + obj + ",elementParams=" + map + ",exception=[" + e16.getMessage() + "]");
            }
        }
        return false;
    }

    public static boolean f(Object obj, String str) {
        try {
            VideoReport.setElementReuseIdentifier(obj, str);
            return true;
        } catch (Exception e16) {
            Log.d("Guild.report.GuildDTReportWraper", "Tatong setElementReuseIdentifer ,exception=[" + e16.getMessage() + "]");
            return false;
        }
    }
}
