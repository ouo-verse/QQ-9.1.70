package com.tencent.tuxmetersdk.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tuxmetersdk.export.injector.log.ITuxLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TriggerState {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "TuxTriggerState";
    private final AtomicBoolean isAnySurveyExpose;
    private final ITuxLog logger;
    private final ReentrantReadWriteLock waitingForLock;
    private final ConcurrentHashMap<String, Boolean> waitingForRspRecord;

    public TriggerState(ITuxLog iTuxLog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iTuxLog);
            return;
        }
        this.isAnySurveyExpose = new AtomicBoolean(false);
        this.waitingForLock = new ReentrantReadWriteLock();
        this.waitingForRspRecord = new ConcurrentHashMap<>();
        this.logger = iTuxLog;
    }

    public boolean getIsAnySurveyExpose() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.isAnySurveyExpose.get();
    }

    public boolean getIsWaitingForRsp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        try {
            try {
                this.waitingForLock.readLock().lock();
                return this.waitingForRspRecord.containsValue(Boolean.TRUE);
            } catch (Exception e16) {
                this.logger.e(TAG, "getIsWaitingForRsp\u5f02\u5e38: " + e16.getLocalizedMessage());
                this.waitingForLock.readLock().unlock();
                return true;
            }
        } finally {
            this.waitingForLock.readLock().unlock();
        }
    }

    public void resetControl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.isAnySurveyExpose.set(false);
            this.waitingForRspRecord.clear();
        }
    }

    public void setAnySurveyExpose() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.isAnySurveyExpose.set(true);
        }
    }

    public void setNotWaitingForRsp(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        try {
            try {
                this.waitingForLock.writeLock().lock();
                if (this.waitingForRspRecord.containsKey(str)) {
                    this.waitingForRspRecord.put(str, Boolean.FALSE);
                } else {
                    this.logger.e(TAG, String.format("setNotWaitingForRsp deliveryId%s \u4e0d\u5b58\u5728", str));
                }
            } catch (Exception e16) {
                this.logger.e(TAG, "setNotWaitingForRsp\u5f02\u5e38: " + e16.getLocalizedMessage());
            }
        } finally {
            this.waitingForLock.writeLock().unlock();
        }
    }

    public void setWaitingForRsp(List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
            return;
        }
        try {
            try {
                this.waitingForLock.writeLock().lock();
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    this.waitingForRspRecord.putIfAbsent(it.next(), Boolean.TRUE);
                }
            } catch (Exception e16) {
                this.logger.e(TAG, "setWaitingForRsp\u5f02\u5e38: " + e16.getLocalizedMessage());
            }
        } finally {
            this.waitingForLock.writeLock().unlock();
        }
    }
}
