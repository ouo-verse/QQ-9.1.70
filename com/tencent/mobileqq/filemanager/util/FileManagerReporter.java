package com.tencent.mobileqq.filemanager.util;

import android.text.TextUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FileManagerReporter {
    private static final String TAG = "FileManagerReporter<FileAssistant>";

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class a {

        /* renamed from: b, reason: collision with root package name */
        public String f209157b;

        /* renamed from: d, reason: collision with root package name */
        public String f209159d;

        /* renamed from: e, reason: collision with root package name */
        public long f209160e;

        /* renamed from: f, reason: collision with root package name */
        private String f209161f;

        /* renamed from: g, reason: collision with root package name */
        public String f209162g;

        /* renamed from: i, reason: collision with root package name */
        public long f209164i;

        /* renamed from: a, reason: collision with root package name */
        public String f209156a = "share_file";

        /* renamed from: c, reason: collision with root package name */
        public int f209158c = 0;

        /* renamed from: h, reason: collision with root package name */
        public int f209163h = 1;

        /* renamed from: j, reason: collision with root package name */
        public boolean f209165j = true;
    }

    public static void addData(String str, a aVar) {
        ReportController.n(null, "CliOper", "", "", aVar.f209156a, aVar.f209157b, aVar.f209158c, aVar.f209163h, !aVar.f209165j ? 1 : 0, String.valueOf(aVar.f209164i), aVar.f209162g, aVar.f209161f, aVar.f209159d);
    }

    public static void addData(String str) {
        a aVar = new a();
        aVar.f209157b = str;
        aVar.f209156a = str;
        ReportController.n(null, "CliOper", "", "", str, str, aVar.f209158c, aVar.f209163h, !aVar.f209165j ? 1 : 0, String.valueOf(aVar.f209164i), aVar.f209162g, aVar.f209161f, aVar.f209159d);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "report key:" + str);
        }
    }

    public static void addData(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ReportController.o(null, "dc00898", "", "", str, str, i3, 0, "", "", "", "");
    }
}
