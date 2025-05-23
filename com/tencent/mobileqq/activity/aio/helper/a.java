package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, Object> f178754a = new HashMap();

    public static void a(Object obj, String str) {
        if (obj == null) {
            return;
        }
        VideoReport.setElementId(obj, str);
        VideoReport.setElementExposePolicy(obj, ExposurePolicy.REPORT_ALL);
    }
}
