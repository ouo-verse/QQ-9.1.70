package com.tencent.qqperf.monitor.crash.tools;

import android.text.format.Time;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.util.AppSetting;
import java.io.File;
import java.io.FileWriter;

/* compiled from: P */
/* loaded from: classes25.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static String f363237a = "";

    /* renamed from: b, reason: collision with root package name */
    public static String f363238b = "";

    /* renamed from: c, reason: collision with root package name */
    public static String f363239c = "";

    public static void a(String str, String str2, boolean z16) {
        FileWriter fileWriter = null;
        try {
            try {
                String str3 = AppConstants.LOG_PATH_SDCARD;
                File file = new File(str3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                FileWriter fileWriter2 = new FileWriter(new File(str3 + "log.txt"), true);
                try {
                    fileWriter2.write("App Version:" + f363237a + ",Model:" + f363238b + ",AndroidVer" + f363239c + ",SubVersion:" + AppSetting.getAboutSubVersionLog());
                    fileWriter2.write("\r\n");
                    Time time = new Time();
                    time.setToNow();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(time.format("[%Y-%m-%d %H:%M:%S]"));
                    sb5.append(" ");
                    fileWriter2.write(sb5.toString());
                    fileWriter2.write("Start Log...");
                    fileWriter2.write("\r\n");
                    if (str != null) {
                        fileWriter2.write("<" + str + "> ");
                    }
                    fileWriter2.write(str2);
                    fileWriter2.write("\r\n");
                    fileWriter2.close();
                } catch (Exception e16) {
                    e = e16;
                    fileWriter = fileWriter2;
                    e.printStackTrace();
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (Exception unused) {
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    fileWriter = fileWriter2;
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }
}
