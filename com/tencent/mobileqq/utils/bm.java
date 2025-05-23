package com.tencent.mobileqq.utils;

import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes20.dex */
public class bm {

    /* renamed from: a, reason: collision with root package name */
    private static ThreadLocal<LinkedList<Long>> f307492a = new ThreadLocal<>();

    public static void a() {
        if (QLog.isColorLevel()) {
            LinkedList<Long> linkedList = f307492a.get();
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                f307492a.set(linkedList);
            }
            linkedList.addFirst(Long.valueOf(SystemClock.uptimeMillis()));
        }
    }

    public static void b(String str, String str2) {
        if (QLog.isColorLevel()) {
            LinkedList<Long> linkedList = f307492a.get();
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                f307492a.set(linkedList);
                linkedList.addFirst(Long.valueOf(SystemClock.uptimeMillis()));
            }
            StringBuilder sb5 = new StringBuilder();
            for (int i3 = 1; i3 < linkedList.size(); i3++) {
                sb5.append("    ");
            }
            if (f307492a.get().size() == 0) {
                return;
            }
            sb5.append(str2);
            sb5.append(":cost ");
            sb5.append(SystemClock.uptimeMillis() - f307492a.get().removeFirst().longValue());
            sb5.append("ms");
            QLog.i(str, 2, sb5.toString());
        }
    }

    public static void c(String str, String str2, String str3) {
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder("PreUploadVideo");
            sb5.append("[");
            sb5.append(str);
            sb5.append("] ");
            if (str2 != null) {
                sb5.append("status:");
                sb5.append(str2);
                sb5.append(" ");
            }
            sb5.append("content:");
            sb5.append(str3);
            QLog.i("PreUploadVideo", 2, sb5.toString());
        }
    }
}
