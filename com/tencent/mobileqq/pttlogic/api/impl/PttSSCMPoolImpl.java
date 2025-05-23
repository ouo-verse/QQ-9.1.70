package com.tencent.mobileqq.pttlogic.api.impl;

import android.os.SystemClock;
import com.tencent.mobileqq.ptt.k;
import com.tencent.mobileqq.pttlogic.api.IPttSSCMPool;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes16.dex */
public class PttSSCMPoolImpl implements IPttSSCMPool {
    static IPatchRedirector $redirector_;
    private static String TAG;
    private long expiredTime;
    private int maxObjects;
    private ArrayList<a> sscms;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public com.tencent.wstt.SSCM.a f261306a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f261307b;

        /* renamed from: c, reason: collision with root package name */
        public long f261308c;

        public a(com.tencent.wstt.SSCM.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
                return;
            }
            this.f261307b = false;
            this.f261308c = 0L;
            this.f261306a = aVar;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22018);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            TAG = PttSSCMPoolImpl.class.getSimpleName();
        }
    }

    public PttSSCMPoolImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.expiredTime = 60000L;
            this.maxObjects = 5;
        }
    }

    private com.tencent.wstt.SSCM.a findFreeObject() {
        ArrayList<a> arrayList = this.sscms;
        if (arrayList == null) {
            return null;
        }
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!next.f261307b) {
                com.tencent.wstt.SSCM.a aVar = next.f261306a;
                next.f261307b = true;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "query for sscm, get one expired:" + (elapsedRealtime - next.f261308c));
                }
                if (elapsedRealtime - next.f261308c > this.expiredTime) {
                    next.f261306a.e();
                }
                return aVar;
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.pttlogic.api.IPttSSCMPool
    public synchronized void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.sscms = null;
        }
    }

    @Override // com.tencent.mobileqq.pttlogic.api.IPttSSCMPool
    public synchronized com.tencent.wstt.SSCM.a getSSCM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.wstt.SSCM.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.sscms == null) {
            this.sscms = new ArrayList<>();
        }
        com.tencent.wstt.SSCM.a findFreeObject = findFreeObject();
        if (findFreeObject == null) {
            findFreeObject = new k();
            findFreeObject.e();
            this.sscms.add(new a(findFreeObject));
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "can't find sscm object, add new one, size= " + this.sscms.size());
            }
        }
        return findFreeObject;
    }

    @Override // com.tencent.mobileqq.pttlogic.api.IPttSSCMPool
    public synchronized void returnObject(com.tencent.wstt.SSCM.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
            return;
        }
        ArrayList<a> arrayList = this.sscms;
        if (arrayList == null) {
            return;
        }
        Iterator<a> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a next = it.next();
            if (aVar == next.f261306a) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "return sscm, current size=" + this.sscms.size());
                }
                if (this.sscms.size() > this.maxObjects) {
                    it.remove();
                } else {
                    next.f261307b = false;
                    next.f261308c = SystemClock.elapsedRealtime();
                }
            }
        }
    }
}
