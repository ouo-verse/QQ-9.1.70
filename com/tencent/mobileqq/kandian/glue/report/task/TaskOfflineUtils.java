package com.tencent.mobileqq.kandian.glue.report.task;

import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class TaskOfflineUtils {

    /* renamed from: a, reason: collision with root package name */
    private static String f239942a = "kandianreport.TaskOfflineUtils";

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f239951a;

        /* renamed from: b, reason: collision with root package name */
        public int f239952b = -1;

        /* renamed from: c, reason: collision with root package name */
        public int f239953c = -1;
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface b {
        void onStateChange(int i3, int i16);
    }

    public static a b(String str, int i3) {
        a aVar = new a();
        String c16 = com.tencent.biz.common.offline.c.c(str);
        if (c16 == null) {
            QLog.d(f239942a, 2, "checkOffLineConfig: offline root dir is null");
            return aVar;
        }
        String str2 = (c16 + str) + "/log_task_config.geojson";
        File file = new File(str2);
        try {
        } catch (Throwable th5) {
            QLog.e(f239942a, 1, "checkOffLineConfig: throwable", th5);
        }
        if (!file.exists()) {
            QLog.d(f239942a, 2, "checkOffLineConfig: there is not file " + str2);
            return aVar;
        }
        JSONObject jSONObject = new JSONObject(d(new FileInputStream(file)));
        int i16 = jSONObject.getInt(StartupReportKey.VERSION_ID);
        int i17 = jSONObject.getInt("support_min_version_id");
        aVar.f239952b = i16;
        aVar.f239953c = i17;
        QLog.d(f239942a, 2, "version_id : " + i16 + "  support_min_version_id: " + i17);
        if (i16 == i3) {
            aVar.f239951a = true;
            return aVar;
        }
        if (i16 > i3 && i17 <= i3) {
            aVar.f239951a = true;
            return aVar;
        }
        return aVar;
    }

    public static void c(final String str, final int i3, final b bVar) {
        QLog.d(f239942a, 2, "bid : " + str);
        try {
            HtmlOffline.D();
        } catch (Throwable th5) {
            QLog.e(f239942a, 1, "HtmlOffline init ", th5);
        }
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.kandian.glue.report.task.TaskOfflineUtils.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    HtmlOffline.i(str, BaseApplicationImpl.getApplication().getRuntime(), new TaskAsyncBack(str, i3, bVar), true, 5, true);
                } catch (Throwable th6) {
                    QLog.e(TaskOfflineUtils.f239942a, 1, "checkUpByBusinessId ", th6);
                }
            }
        });
    }

    public static String d(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb5 = new StringBuilder();
        while (true) {
            try {
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb5.append(readLine);
                    } catch (IOException unused) {
                        QLog.d(f239942a, 2, "fail to read string from input stream");
                        inputStream.close();
                    } catch (OutOfMemoryError unused2) {
                        QLog.d(f239942a, 2, "fail to read string from input stream due to OOM");
                        try {
                            inputStream.close();
                            return null;
                        } catch (IOException e16) {
                            QLog.e(f239942a, 1, QLog.getStackTraceString(e16));
                            return null;
                        }
                    }
                } catch (Throwable th5) {
                    try {
                        inputStream.close();
                    } catch (IOException e17) {
                        QLog.e(f239942a, 1, QLog.getStackTraceString(e17));
                    }
                    throw th5;
                }
            } catch (IOException e18) {
                QLog.e(f239942a, 1, QLog.getStackTraceString(e18));
            }
        }
        inputStream.close();
        return sb5.toString();
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    private static class TaskAsyncBack implements com.tencent.biz.common.offline.a {

        /* renamed from: d, reason: collision with root package name */
        private final b f239946d;

        /* renamed from: e, reason: collision with root package name */
        private final String f239947e;

        /* renamed from: f, reason: collision with root package name */
        private final int f239948f;

        public TaskAsyncBack(String str, int i3, b bVar) {
            this.f239947e = str;
            this.f239946d = bVar;
            this.f239948f = i3;
        }

        @Override // com.tencent.biz.common.offline.a
        public void loaded(final String str, final int i3) {
            ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.kandian.glue.report.task.TaskOfflineUtils.TaskAsyncBack.1
                @Override // java.lang.Runnable
                public void run() {
                    QLog.d(TaskOfflineUtils.f239942a, 2, "loaded: bid : " + TaskAsyncBack.this.f239947e + " param " + str + " code : " + i3);
                    int i16 = i3;
                    int i17 = -1;
                    if (i16 == 0) {
                        i16 = 4;
                        try {
                            if (str == null) {
                                a b16 = TaskOfflineUtils.b(TaskAsyncBack.this.f239947e, TaskAsyncBack.this.f239948f);
                                i17 = b16.f239952b;
                                if (b16.f239951a) {
                                    i16 = 0;
                                }
                            }
                        } catch (Exception e16) {
                            QLog.d(TaskOfflineUtils.f239942a, 1, "loaded: bid : " + TaskAsyncBack.this.f239947e, e16);
                            c.a("loaded: bid : " + TaskAsyncBack.this.f239947e + " " + e16.getMessage());
                        }
                    }
                    if (TaskAsyncBack.this.f239946d != null) {
                        TaskAsyncBack.this.f239946d.onStateChange(i16, i17);
                    }
                }
            });
        }

        @Override // com.tencent.biz.common.offline.a
        public void progress(int i3) {
        }
    }
}
