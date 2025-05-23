package com.tencent.mobileqq.pushdialog;

import android.database.sqlite.SQLiteException;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Date;
import java.util.List;

/* loaded from: classes16.dex */
public class PushDialogDbUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static volatile PushDialogDbUtil f261317b;

    /* renamed from: a, reason: collision with root package name */
    private Object f261318a;

    /* loaded from: classes16.dex */
    public interface a {
        void a(List<PushDialogTemplate> list);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74305);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f261317b = null;
        }
    }

    public PushDialogDbUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f261318a = new Object();
        }
    }

    public static PushDialogDbUtil c() {
        if (f261317b == null) {
            synchronized (PushDialogDbUtil.class) {
                if (f261317b == null) {
                    f261317b = new PushDialogDbUtil();
                }
            }
        }
        return f261317b;
    }

    public void b(EntityManager entityManager, PushDialogTemplate pushDialogTemplate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) entityManager, (Object) pushDialogTemplate);
        } else {
            ThreadManagerV2.post(new Runnable(entityManager, pushDialogTemplate) { // from class: com.tencent.mobileqq.pushdialog.PushDialogDbUtil.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ EntityManager f261324d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ PushDialogTemplate f261325e;

                {
                    this.f261324d = entityManager;
                    this.f261325e = pushDialogTemplate;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, PushDialogDbUtil.this, entityManager, pushDialogTemplate);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        synchronized (PushDialogDbUtil.this.f261318a) {
                            this.f261324d.remove(this.f261325e);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("PushDialogDbUtil", 4, "PushDialogTemplate delete: " + new Date(this.f261325e.time) + "," + this.f261325e.mUin + "," + this.f261325e.c2c_type);
                            return;
                        }
                        return;
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }, 8, null, false);
        }
    }

    public void d(EntityManager entityManager, PushDialogTemplate pushDialogTemplate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) entityManager, (Object) pushDialogTemplate);
        } else if (entityManager != null && pushDialogTemplate != null) {
            ThreadManagerV2.post(new Runnable(entityManager, pushDialogTemplate) { // from class: com.tencent.mobileqq.pushdialog.PushDialogDbUtil.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ EntityManager f261326d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ PushDialogTemplate f261327e;

                {
                    this.f261326d = entityManager;
                    this.f261327e = pushDialogTemplate;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, PushDialogDbUtil.this, entityManager, pushDialogTemplate);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        synchronized (PushDialogDbUtil.this.f261318a) {
                            try {
                                this.f261326d.persist(this.f261327e);
                            } catch (SQLiteException e16) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("PushDialogDbUtil", 2, e16.getMessage());
                                }
                            }
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("PushDialogDbUtil", 4, "PushDialogTemplate insert: " + new Date(this.f261327e.time) + "," + this.f261327e.mUin + "," + this.f261327e.c2c_type);
                            return;
                        }
                        return;
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }, 2, null, false);
        }
    }

    public void e(EntityManager entityManager, long j3, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, entityManager, Long.valueOf(j3), aVar);
        } else {
            long currentTimeMillis = System.currentTimeMillis() - 86400000;
            ThreadManagerV2.post(new Runnable(entityManager, new String[]{String.valueOf(j3), String.valueOf(currentTimeMillis)}, j3, currentTimeMillis, aVar) { // from class: com.tencent.mobileqq.pushdialog.PushDialogDbUtil.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ EntityManager f261319d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String[] f261320e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ long f261321f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ long f261322h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ a f261323i;

                {
                    this.f261319d = entityManager;
                    this.f261320e = r7;
                    this.f261321f = j3;
                    this.f261322h = currentTimeMillis;
                    this.f261323i = aVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, PushDialogDbUtil.this, entityManager, r7, Long.valueOf(j3), Long.valueOf(currentTimeMillis), aVar);
                    }
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    List<? extends Entity> query;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        synchronized (PushDialogDbUtil.this.f261318a) {
                            query = this.f261319d.query(PushDialogTemplate.class, true, "mUin=? AND time>=?", this.f261320e, null, null, null, null);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("PushDialogDbUtil", 4, "PushDialogTemplate query: " + this.f261321f + ", queryTime: " + new Date(this.f261322h));
                        }
                        a aVar2 = this.f261323i;
                        if (aVar2 != 0) {
                            aVar2.a(query);
                            return;
                        }
                        return;
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }, 8, null, false);
        }
    }
}
