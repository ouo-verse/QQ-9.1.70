package com.tencent.mobileqq.download.unite.core;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.download.unite.util.b;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.onlinestatus.bv;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.l;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadUtil;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes10.dex */
public class UniteDownloadDbOperator {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private EntityManager f203586a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final UniteDownloadDbOperator f203590a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71531);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f203590a = new UniteDownloadDbOperator();
            }
        }
    }

    UniteDownloadDbOperator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void b(String str) {
        this.f203586a = l.c(str).createEntityManager();
    }

    public static UniteDownloadDbOperator e() {
        return a.f203590a;
    }

    private void g(UniteDownloadEntity uniteDownloadEntity) {
        this.f203586a.remove(uniteDownloadEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str) {
        b(str);
        List<? extends Entity> query = this.f203586a.query(UniteDownloadEntity.class, UniteDownloadEntity.tableName(), false, "downloadTimestamp < ?", new String[]{String.valueOf(NetConnInfoCenter.getServerTimeMillis() - 2592000000L)}, (String) null, (String) null, (String) null, (String) null);
        if (query != null) {
            Iterator<? extends Entity> it = query.iterator();
            while (it.hasNext()) {
                g((UniteDownloadEntity) it.next());
            }
        }
    }

    public void c(String str, DownloadInfo downloadInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) downloadInfo);
            return;
        }
        ThreadManagerV2.excute(new Runnable(downloadInfo, str) { // from class: com.tencent.mobileqq.download.unite.core.UniteDownloadDbOperator.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ DownloadInfo f203587d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f203588e;

            {
                this.f203587d = downloadInfo;
                this.f203588e = str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, UniteDownloadDbOperator.this, downloadInfo, str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    UniteDownloadDbOperator.this.d(this.f203588e, UniteDownloadEntity.fromDownloadInfo(this.f203587d));
                }
            }
        }, 32, null, false);
        String apkName = ((IUniformDownloadUtil) QRoute.api(IUniformDownloadUtil.class)).getApkName(downloadInfo.L);
        if (!TextUtils.isEmpty(apkName)) {
            if (downloadInfo.f341202r0) {
                bv.d("0X800B53A", 0, "", apkName);
            } else if (com.tencent.mobileqq.download.unite.core.a.b(downloadInfo.M)) {
                b.c(apkName);
            } else {
                b.d(apkName);
            }
        }
    }

    public boolean d(String str, UniteDownloadEntity uniteDownloadEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) uniteDownloadEntity)).booleanValue();
        }
        b(str);
        QLog.d("[UniteDownload] UniteDownloadDbOperator", 1, "[db] insertOrReplaceEntity: invoked. ", " uniteDownloadEntity: ", uniteDownloadEntity);
        if (this.f203586a.isOpen()) {
            if (uniteDownloadEntity.getStatus() == 1000) {
                this.f203586a.persistOrReplace(uniteDownloadEntity);
                if (uniteDownloadEntity.getStatus() != 1001) {
                    return false;
                }
                return true;
            }
            if (uniteDownloadEntity.getStatus() == 1001 || uniteDownloadEntity.getStatus() == 1002) {
                return this.f203586a.update(uniteDownloadEntity);
            }
        }
        return false;
    }

    @Nullable
    public List<UniteDownloadEntity> f(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
        }
        b(str);
        return this.f203586a.query(UniteDownloadEntity.class, UniteDownloadEntity.tableName(), false, "source = ?", new String[]{str2}, (String) null, (String) null, (String) null, (String) null);
    }

    public void i(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            ThreadManagerV2.excute(new Runnable(str) { // from class: com.tencent.mobileqq.download.unite.core.UniteDownloadDbOperator.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f203589d;

                {
                    this.f203589d = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UniteDownloadDbOperator.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        UniteDownloadDbOperator.this.h(this.f203589d);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            }, 32, null, false);
        }
    }
}
