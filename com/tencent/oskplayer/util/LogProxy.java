package com.tencent.oskplayer.util;

import com.tencent.oskplayer.support.log.ILogger;

/* loaded from: classes22.dex */
public class LogProxy implements ILogger {
    private QLog qLog;

    public LogProxy(QLog qLog) {
        this.qLog = qLog;
    }

    @Override // com.tencent.oskplayer.support.log.ILogger
    public int d(String str, String str2) {
        return this.qLog.d(str, str2);
    }

    @Override // com.tencent.oskplayer.support.log.ILogger
    public int e(String str, String str2) {
        return this.qLog.e(str, str2);
    }

    @Override // com.tencent.oskplayer.support.log.ILogger
    public int i(String str, String str2) {
        return this.qLog.i(str, str2);
    }

    @Override // com.tencent.oskplayer.support.log.ILogger
    public int v(String str, String str2) {
        return this.qLog.v(str, str2);
    }

    @Override // com.tencent.oskplayer.support.log.ILogger
    public int w(String str, String str2) {
        return this.qLog.w(str, str2);
    }

    @Override // com.tencent.oskplayer.support.log.ILogger
    public int d(String str, String str2, Throwable th5) {
        return this.qLog.d(str, str2, th5);
    }

    @Override // com.tencent.oskplayer.support.log.ILogger
    public int e(String str, String str2, Throwable th5) {
        return this.qLog.i(str, str2, th5);
    }

    @Override // com.tencent.oskplayer.support.log.ILogger
    public int i(String str, String str2, Throwable th5) {
        return this.qLog.i(str, str2, th5);
    }

    @Override // com.tencent.oskplayer.support.log.ILogger
    public int v(String str, String str2, Throwable th5) {
        return this.qLog.v(str, str2, th5);
    }

    @Override // com.tencent.oskplayer.support.log.ILogger
    public int w(String str, String str2, Throwable th5) {
        return this.qLog.i(str, str2, th5);
    }

    @Override // com.tencent.oskplayer.support.log.ILogger
    public int w(String str, Throwable th5) {
        return this.qLog.w(str, th5);
    }
}
