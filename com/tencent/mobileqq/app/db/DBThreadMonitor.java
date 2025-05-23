package com.tencent.mobileqq.app.db;

import android.os.Looper;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.LinkedHashMap;

/* compiled from: P */
/* loaded from: classes11.dex */
public class DBThreadMonitor {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DBThreadBlockMonitor";
    private HashMap<Long, CompetitionThreadInfo> mCompetitionThreadList;
    private final Object mLock;
    private final String tag;

    public DBThreadMonitor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.mLock = new Object();
        this.mCompetitionThreadList = new LinkedHashMap();
        this.tag = "DBThreadBlockMonitor_" + str;
    }

    private String getCompetitionThreadInfo() {
        StringBuilder sb5 = new StringBuilder();
        synchronized (this.mLock) {
            for (CompetitionThreadInfo competitionThreadInfo : this.mCompetitionThreadList.values()) {
                long nanoTime = System.nanoTime() - competitionThreadInfo.enterTime;
                sb5.append("isMainThread: ");
                sb5.append(isMainThread(competitionThreadInfo.threadId));
                sb5.append(", ");
                sb5.append(competitionThreadInfo);
                sb5.append(", waitingTime: ");
                sb5.append(nanoTime);
                sb5.append(" ns; ");
                sb5.append(nanoTime / 1000000.0d);
                sb5.append("ms;");
                sb5.append("\n");
            }
        }
        return sb5.toString();
    }

    private boolean isMainThread(long j3) {
        if (Looper.getMainLooper().getThread().getId() == j3) {
            return true;
        }
        return false;
    }

    public void addCompetitionThread() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (!SQLiteDatabase.sIsLogcatDBOperation) {
            return;
        }
        long id5 = Thread.currentThread().getId();
        String name = Thread.currentThread().getName();
        synchronized (this.mLock) {
            CompetitionThreadInfo competitionThreadInfo = new CompetitionThreadInfo(id5, name, System.nanoTime());
            QLog.d(this.tag, 1, "addCompetitionThread -> isMainThread: " + isMainThread(id5) + ", curThreadInfo : " + competitionThreadInfo + ", BlockThreadList : \n" + getCompetitionThreadInfo());
            this.mCompetitionThreadList.put(Long.valueOf(id5), competitionThreadInfo);
            QLog.d(this.tag, 1, new Throwable("add competition thread stack"), new Object[0]);
        }
    }

    public void finishThread() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (!SQLiteDatabase.sIsLogcatDBOperation) {
            return;
        }
        long id5 = Thread.currentThread().getId();
        synchronized (this.mLock) {
            CompetitionThreadInfo remove = this.mCompetitionThreadList.remove(Long.valueOf(id5));
            if (remove != null) {
                String str = this.tag;
                QLog.d(str, 1, "finish thread : " + remove + ", isMainThread: " + isMainThread(id5) + ", cost: " + (System.nanoTime() - remove.enterTime) + "ns, " + ((System.nanoTime() - remove.enterTime) / 1000000.0d) + "ms, BlockThreadList : \n" + getCompetitionThreadInfo());
            }
        }
    }
}
