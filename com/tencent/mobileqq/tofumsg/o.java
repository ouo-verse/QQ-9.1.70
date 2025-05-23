package com.tencent.mobileqq.tofumsg;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class o {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final o f293312a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75925);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f293312a = new o();
            }
        }
    }

    public o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static o b() {
        return a.f293312a;
    }

    public synchronized void c(@NonNull QQAppInterface qQAppInterface, @NonNull TofuLimitMsg tofuLimitMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQAppInterface, (Object) tofuLimitMsg);
            return;
        }
        a();
        try {
            qQAppInterface.getEntityManagerFactory().createEntityManager().persistOrReplace(tofuLimitMsg);
        } catch (Throwable th5) {
            QLog.e("TofuNew.TofuProxy", 1, th5, new Object[0]);
        }
    }

    @NonNull
    public synchronized CopyOnWriteArrayList<TofuLimitMsg> d(@NonNull QQAppInterface qQAppInterface, @NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CopyOnWriteArrayList) iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQAppInterface, (Object) str);
        }
        a();
        CopyOnWriteArrayList<TofuLimitMsg> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        try {
            List<? extends Entity> query = qQAppInterface.getEntityManagerFactory().createEntityManager().query(TofuLimitMsg.class, new TofuLimitMsg().getTableName(), false, "friendUin=?", new String[]{str}, (String) null, (String) null, (String) null, (String) null);
            if (query != null) {
                copyOnWriteArrayList.addAll(query);
            }
        } catch (Throwable th5) {
            QLog.e("TofuNew.TofuProxy", 1, th5, new Object[0]);
        }
        return copyOnWriteArrayList;
    }

    @NonNull
    public synchronized CopyOnWriteArrayList<TofuLimitMsgForPush> e(@NonNull QQAppInterface qQAppInterface, @NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CopyOnWriteArrayList) iPatchRedirector.redirect((short) 4, (Object) this, (Object) qQAppInterface, (Object) str);
        }
        a();
        CopyOnWriteArrayList<TofuLimitMsgForPush> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        try {
            List<? extends Entity> query = qQAppInterface.getEntityManagerFactory().createEntityManager().query(TofuLimitMsgForPush.class, new TofuLimitMsgForPush().getTableName(), false, "friendUin=?", new String[]{str}, (String) null, (String) null, (String) null, (String) null);
            if (query != null) {
                copyOnWriteArrayList.addAll(query);
            }
        } catch (Throwable th5) {
            QLog.e("TofuNew.TofuProxy", 1, th5, new Object[0]);
        }
        return copyOnWriteArrayList;
    }

    @NonNull
    public synchronized CopyOnWriteArrayList<TofuLimitMsgForSogou> f(@NonNull QQAppInterface qQAppInterface, @NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (CopyOnWriteArrayList) iPatchRedirector.redirect((short) 5, (Object) this, (Object) qQAppInterface, (Object) str);
        }
        a();
        CopyOnWriteArrayList<TofuLimitMsgForSogou> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        try {
            List<? extends Entity> query = qQAppInterface.getEntityManagerFactory().createEntityManager().query(TofuLimitMsgForSogou.class, new TofuLimitMsgForSogou().getTableName(), false, "friendUin=?", new String[]{str}, (String) null, (String) null, (String) null, (String) null);
            if (query != null) {
                copyOnWriteArrayList.addAll(query);
            }
        } catch (Throwable th5) {
            QLog.e("TofuNew.TofuProxy", 1, th5, new Object[0]);
        }
        return copyOnWriteArrayList;
    }

    private static void a() {
    }
}
