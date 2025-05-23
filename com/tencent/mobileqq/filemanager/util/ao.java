package com.tencent.mobileqq.filemanager.util;

import android.view.View;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ao {

    /* renamed from: a, reason: collision with root package name */
    public static int f209336a = 1;

    /* renamed from: b, reason: collision with root package name */
    public static int f209337b = 2;

    /* renamed from: c, reason: collision with root package name */
    public static String f209338c = "pg_mail_appendix";

    /* renamed from: d, reason: collision with root package name */
    public static String f209339d = "em_download";

    /* renamed from: e, reason: collision with root package name */
    public static String f209340e = "em_maillapp";

    /* renamed from: f, reason: collision with root package name */
    public static String f209341f = "download_file_type";

    /* renamed from: g, reason: collision with root package name */
    public static int f209342g = 0;

    /* renamed from: h, reason: collision with root package name */
    public static int f209343h = 1;

    /* renamed from: i, reason: collision with root package name */
    public static int f209344i = 2;

    /* renamed from: j, reason: collision with root package name */
    public static int f209345j = 3;

    /* renamed from: k, reason: collision with root package name */
    public static int f209346k = 4;

    public static void a(FileBrowserModelBase fileBrowserModelBase, View view, int i3, String str) {
        String str2;
        String str3;
        if (view != null && fileBrowserModelBase != null) {
            VideoReport.setPageId(view.getRootView(), f209338c);
            if (i3 == f209336a) {
                str2 = f209339d;
            } else {
                str2 = f209340e;
            }
            VideoReport.setElementId(view, str2);
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
            HashMap hashMap = new HashMap();
            hashMap.put("pgid", f209338c);
            if (i3 == f209336a) {
                str3 = f209339d;
            } else {
                str3 = f209340e;
            }
            hashMap.put("eid", str3);
            if (i3 == f209336a) {
                hashMap.put(f209341f, Integer.valueOf(b(fileBrowserModelBase.V())));
            }
            VideoReport.reportEvent(str, view, hashMap);
        }
    }

    private static int b(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3 && i3 != 6 && i3 != 7 && i3 != 9 && i3 != 10) {
                        return f209346k;
                    }
                    return f209342g;
                }
                return f209344i;
            }
            return f209345j;
        }
        return f209343h;
    }

    public static void c(FileBrowserModelBase fileBrowserModelBase, View view, int i3) {
        a(fileBrowserModelBase, view, i3, "clck");
    }

    public static void d(FileBrowserModelBase fileBrowserModelBase, View view, int i3) {
        a(fileBrowserModelBase, view, i3, "imp");
    }
}
