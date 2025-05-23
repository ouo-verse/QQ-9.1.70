package com.qzone.proxy.feedcomponent.manager;

import com.tencent.oskplayer.util.QLog;
import cooperation.qzone.util.QZLog;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class i implements QLog {

    /* renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<String, String> f50219a;

    private static String a(String str) {
        if (f50219a == null) {
            f50219a = new ConcurrentHashMap<>();
        }
        if (!f50219a.containsKey(str)) {
            f50219a.put(str, "VIDEO_LOG/" + str);
        }
        return f50219a.get(str);
    }

    @Override // com.tencent.oskplayer.util.QLog
    public int d(String str, String str2) {
        if (!QZLog.isDevelopLevel()) {
            return 0;
        }
        QZLog.d(a(str), 4, str2);
        return 0;
    }

    @Override // com.tencent.oskplayer.util.QLog
    public int e(String str, String str2) {
        QZLog.e(a(str), str2);
        return 0;
    }

    @Override // com.tencent.oskplayer.util.QLog
    public int i(String str, String str2) {
        QZLog.i(a(str), 4, str2);
        return 0;
    }

    @Override // com.tencent.oskplayer.util.QLog
    public int v(String str, String str2) {
        if (!QZLog.isColorLevel()) {
            return 0;
        }
        QZLog.i(a(str), 4, str2);
        return 0;
    }

    @Override // com.tencent.oskplayer.util.QLog
    public int w(String str, String str2) {
        QZLog.w(a(str), str2);
        return 0;
    }

    @Override // com.tencent.oskplayer.util.QLog
    public int e(String str, String str2, Throwable th5) {
        QZLog.e(a(str), str2, th5);
        return 0;
    }

    @Override // com.tencent.oskplayer.util.QLog
    public int i(String str, String str2, Throwable th5) {
        QZLog.i(a(str), 4, str2, th5);
        return 0;
    }

    @Override // com.tencent.oskplayer.util.QLog
    public int w(String str, String str2, Throwable th5) {
        QZLog.w(a(str), str2, th5);
        return 0;
    }

    @Override // com.tencent.oskplayer.util.QLog
    public int d(String str, String str2, Throwable th5) {
        if (!QZLog.isDevelopLevel()) {
            return 0;
        }
        QZLog.d(a(str), 4, str2, th5);
        return 0;
    }

    @Override // com.tencent.oskplayer.util.QLog
    public int v(String str, String str2, Throwable th5) {
        if (!QZLog.isColorLevel()) {
            return 0;
        }
        QZLog.i(a(str), 4, str2, th5);
        return 0;
    }

    @Override // com.tencent.oskplayer.util.QLog
    public int w(String str, Throwable th5) {
        QZLog.w(a(str), th5.getMessage());
        return 0;
    }
}
