package com.tencent.gamecenter.wadl.sdk;

import com.tencent.qphone.base.util.QLog;
import com.tencent.raft.standard.log.IRLog;

/* compiled from: P */
/* loaded from: classes6.dex */
public class WadlLogImpl implements IRLog {
    @Override // com.tencent.raft.standard.log.IRLog
    public void d(String[] strArr, String str, Throwable th5) {
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void e(String[] strArr, String str, Throwable th5) {
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void flushLog() {
        QLog.flushLog();
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void i(String[] strArr, String str, Throwable th5) {
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public boolean isColorLevel() {
        return QLog.isColorLevel();
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void log(String[] strArr, int i3, String str, Throwable th5) {
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void v(String[] strArr, String str, Throwable th5) {
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void w(String[] strArr, String str, Throwable th5) {
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void d(String str, String str2, Object... objArr) {
        QLog.d(str, 2, objArr);
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void e(String str, String str2, Object... objArr) {
        QLog.e(str, 1, objArr);
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void i(String str, String str2, Object... objArr) {
        QLog.i(str, 2, objArr != null ? objArr.toString() : "");
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void log(String str, int i3, String str2, Object... objArr) {
        QLog.i(str, i3, objArr != null ? objArr.toString() : "");
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void v(String str, String str2, Object... objArr) {
        QLog.d(str, 2, objArr);
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void w(String str, String str2, Object... objArr) {
        QLog.w(str, 2, objArr != null ? objArr.toString() : "");
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void d(String str, String str2) {
        QLog.d(str, 2, str2);
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void e(String str, String str2) {
        QLog.e(str, 1, str2);
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void i(String str, String str2) {
        QLog.i(str, 2, str2);
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void log(String str, int i3, String str2) {
        QLog.i(str, i3, str2);
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void v(String str, String str2) {
        QLog.d(str, 2, str2);
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void w(String str, String str2) {
        QLog.w(str, 2, str2);
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void d(String str, String str2, Throwable th5) {
        QLog.d(str, 2, str2, th5);
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void e(String str, String str2, Throwable th5) {
        QLog.e(str, 1, str2, th5);
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void i(String str, String str2, Throwable th5) {
        QLog.i(str, 2, str2, th5);
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void log(String str, int i3, String str2, Throwable th5) {
        QLog.i(str, i3, str2, th5);
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void v(String str, String str2, Throwable th5) {
        QLog.d(str, 2, str2, th5);
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void w(String str, String str2, Throwable th5) {
        QLog.w(str, 2, str2, th5);
    }
}
