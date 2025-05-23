package com.tencent.litetransfersdk;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RouterMsgRecord;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/* loaded from: classes7.dex */
public class ProgressInfo {
    static IPatchRedirector $redirector_ = null;
    public static final int Fail = 4;
    public static final int Queueing = 1;
    public static final int Running = 2;
    public static final int Success = 3;
    public static final int Unknown = 0;
    public String filename;
    public String filepath;
    private int nCount_for_timeout;
    public String timeDes;
    private int uint32_status;
    public long uint64_fileSize;
    public long uint64_progress;
    public long uint64_sessionid;
    private long uint64_time;

    public ProgressInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.uint64_sessionid = 0L;
        this.uint64_progress = 0L;
        this.uint64_fileSize = 0L;
        this.uint64_time = 0L;
        this.uint32_status = 2;
        this.nCount_for_timeout = 0;
    }

    public void GetFilePath(QQAppInterface qQAppInterface, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, qQAppInterface, Long.valueOf(j3));
            return;
        }
        EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
        List<Entity> rawQuery = DBMethodProxy.rawQuery(createEntityManager, RouterMsgRecord.class, "select * from " + RouterMsgRecord.sBasicTableName + j3 + " where uSessionID = ?", new String[]{String.valueOf(this.uint64_sessionid)});
        createEntityManager.close();
        if (rawQuery != null && rawQuery.size() > 0) {
            this.filepath = ((RouterMsgRecord) rawQuery.get(0)).filename;
        }
    }

    public int GetStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.uint32_status;
    }

    public long GetTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
        }
        return this.uint64_time;
    }

    public int GetWeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        int i3 = this.uint32_status;
        if (i3 == 2) {
            return 20;
        }
        if (i3 == 1) {
            return 30;
        }
        if (i3 == 4) {
            return 40;
        }
        if (i3 == 3) {
            return 50;
        }
        if (i3 == 0) {
            return 60;
        }
        return 0;
    }

    public boolean IsComplete() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        int i3 = this.uint32_status;
        if (i3 != 4 && i3 != 3) {
            return false;
        }
        return true;
    }

    public boolean IsPersistentTimeout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (this.nCount_for_timeout >= 2) {
            return true;
        }
        return false;
    }

    public void SetStatus(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.nCount_for_timeout = 0;
            this.uint32_status = i3;
        }
    }

    public void SetTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, j3);
        } else {
            if (this.uint64_time == j3) {
                return;
            }
            this.uint64_time = j3;
            this.timeDes = new SimpleDateFormat("\nMM-dd HH:mm:ss").format((Date) new java.sql.Date(this.uint64_time * 1000));
        }
    }

    public void SetTimeout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else if (!IsComplete()) {
            this.nCount_for_timeout++;
        }
    }
}
