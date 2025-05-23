package com.tencent.mobileqq.mini.report;

import NS_COMM.COMM;
import android.os.Build;
import com.tencent.biz.common.util.HttpUtil;
import cooperation.qzone.QUA;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes33.dex */
public class MiniProgramLpReportDC04746 {
    public static final int SPLASH_GUIDE_CLICKED = 1;
    public static final int SPLASH_GUIDE_EXPOSE = 6;
    public static final int SPLASH_GUIDE_EXPOSE_ONLY = 0;
    public static final int SPLASH_PIC_EXPOSE = 2;
    public static final int SPLASH_PIC_JUMP = 1;
    public static final int SPLASH_PIC_START = 2;
    public static final int SPLASH_VIDEO_EXPOSE = 1;
    public static final int SPLASH_VIDEO_JUMP = 1;

    public static void report(String str, String str2, int i3, int i16) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(MiniProgramReportHelper.newEntry("uin", String.valueOf(com.tencent.open.adapter.a.f().l())));
        arrayList.add(MiniProgramReportHelper.newEntry("touin", ""));
        arrayList.add(MiniProgramReportHelper.newEntry("actiontype", String.valueOf(i3)));
        arrayList.add(MiniProgramReportHelper.newEntry("subactiontype", String.valueOf(i16)));
        arrayList.add(MiniProgramReportHelper.newEntry("action_source", "shanping"));
        arrayList.add(MiniProgramReportHelper.newEntry("qua", QUA.getQUA3()));
        arrayList.add(MiniProgramReportHelper.newEntry("platform", "android"));
        arrayList.add(MiniProgramReportHelper.newEntry("os_version", Build.VERSION.RELEASE));
        arrayList.add(MiniProgramReportHelper.newEntry("network_type", HttpUtil.getNetWorkTypeByStr()));
        arrayList.add(MiniProgramReportHelper.newEntry("appid", str));
        arrayList.add(MiniProgramReportHelper.newEntry("app_version", str2));
        MiniProgramReporter.getInstance().add(MiniProgramReportHelper.newSingleDcData(8, String.valueOf(0), arrayList, (List<COMM.Entry>) null));
        MiniProgramReporter.getInstance().flush();
    }
}
