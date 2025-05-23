package com.tencent.qqmini.proxyimpl;

import com.tencent.oskplayer.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes34.dex */
public class v implements QLog {

    /* renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<String, String> f348007a;

    private static String a(String str) {
        if (f348007a == null) {
            f348007a = new ConcurrentHashMap<>();
        }
        if (!f348007a.containsKey(str)) {
            f348007a.put(str, "VIDEO_LOG/" + str);
        }
        return f348007a.get(str);
    }

    @Override // com.tencent.oskplayer.util.QLog
    public int d(String str, String str2) {
        if (!com.tencent.qphone.base.util.QLog.isDevelopLevel()) {
            return 0;
        }
        com.tencent.qphone.base.util.QLog.d(a(str), 4, str2);
        return 0;
    }

    @Override // com.tencent.oskplayer.util.QLog
    public int e(String str, String str2) {
        com.tencent.qphone.base.util.QLog.e(a(str), 1, str2);
        return 0;
    }

    @Override // com.tencent.oskplayer.util.QLog
    public int i(String str, String str2) {
        com.tencent.qphone.base.util.QLog.i(a(str), 1, str2);
        return 0;
    }

    @Override // com.tencent.oskplayer.util.QLog
    public int v(String str, String str2) {
        if (!com.tencent.qphone.base.util.QLog.isColorLevel()) {
            return 0;
        }
        com.tencent.qphone.base.util.QLog.i(a(str), 2, str2);
        return 0;
    }

    @Override // com.tencent.oskplayer.util.QLog
    public int w(String str, String str2) {
        com.tencent.qphone.base.util.QLog.w(a(str), 1, str2);
        return 0;
    }

    @Override // com.tencent.oskplayer.util.QLog
    public int e(String str, String str2, Throwable th5) {
        com.tencent.qphone.base.util.QLog.e(a(str), 1, str2, th5);
        return 0;
    }

    @Override // com.tencent.oskplayer.util.QLog
    public int i(String str, String str2, Throwable th5) {
        com.tencent.qphone.base.util.QLog.i(a(str), 1, str2, th5);
        return 0;
    }

    @Override // com.tencent.oskplayer.util.QLog
    public int w(String str, String str2, Throwable th5) {
        com.tencent.qphone.base.util.QLog.w(a(str), 1, str2, th5);
        return 0;
    }

    @Override // com.tencent.oskplayer.util.QLog
    public int d(String str, String str2, Throwable th5) {
        if (!com.tencent.qphone.base.util.QLog.isDevelopLevel()) {
            return 0;
        }
        com.tencent.qphone.base.util.QLog.d(a(str), 4, str2, th5);
        return 0;
    }

    @Override // com.tencent.oskplayer.util.QLog
    public int v(String str, String str2, Throwable th5) {
        if (!com.tencent.qphone.base.util.QLog.isColorLevel()) {
            return 0;
        }
        com.tencent.qphone.base.util.QLog.i(a(str), 2, str2, th5);
        return 0;
    }

    @Override // com.tencent.oskplayer.util.QLog
    public int w(String str, Throwable th5) {
        com.tencent.qphone.base.util.QLog.w(a(str), 1, th5.getMessage());
        return 0;
    }
}
