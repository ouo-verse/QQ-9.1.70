package com.tencent.mobileqq.uniformdownload.downloader;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* loaded from: classes17.dex */
public class UniformDownloadBPTransProxy extends BaseProxyManager {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static UniformDownloadBPTransProxy f305889f;

    /* renamed from: d, reason: collision with root package name */
    private List<UniformDownloadBPTransEntity> f305890d;

    /* renamed from: e, reason: collision with root package name */
    private AppRuntime f305891e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19417);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f305889f = null;
        }
    }

    public UniformDownloadBPTransProxy(AppRuntime appRuntime) {
        super(appRuntime);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        } else {
            this.f305890d = null;
            this.f305891e = appRuntime;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(UniformDownloadBPTransEntity uniformDownloadBPTransEntity, ProxyListener proxyListener) {
        EntityManager createEntityManager = this.f305891e.getEntityManagerFactory().createEntityManager();
        if (createEntityManager == null) {
            QLog.e("UniformDownloadBPTransProxy", 1, "[UniformDL]. addEntityToDB. EntityManager. create failed!!");
            return;
        }
        UniformDownloadBPTransEntity uniformDownloadBPTransEntity2 = new UniformDownloadBPTransEntity();
        uniformDownloadBPTransEntity2.copyFrom(uniformDownloadBPTransEntity);
        if (uniformDownloadBPTransEntity2.getStatus() == 1000) {
            createEntityManager.persist(uniformDownloadBPTransEntity2);
        } else if (uniformDownloadBPTransEntity2.getStatus() == 1001) {
            createEntityManager.update(uniformDownloadBPTransEntity2);
        } else {
            QLog.e("UniformDownloadBPTransProxy", 1, "[UniformDL]. addEntityToDB. error status of entity");
        }
        createEntityManager.close();
    }

    private synchronized void h(UniformDownloadBPTransEntity uniformDownloadBPTransEntity) {
        if (uniformDownloadBPTransEntity == null) {
            QLog.e("UniformDownloadBPTransProxy", 1, "[UniformDL]. addToCacheEntityList. entiy=null");
            return;
        }
        if (this.f305890d.contains(uniformDownloadBPTransEntity)) {
            QLog.i("UniformDownloadBPTransProxy", 1, "[UniformDL]. addToCacheEntityList. entiy is existed 1. url:" + uniformDownloadBPTransEntity.mUrl);
            return;
        }
        for (UniformDownloadBPTransEntity uniformDownloadBPTransEntity2 : this.f305890d) {
            if (uniformDownloadBPTransEntity2 != null && uniformDownloadBPTransEntity2.mUrl.equalsIgnoreCase(uniformDownloadBPTransEntity.mUrl)) {
                QLog.i("UniformDownloadBPTransProxy", 1, "[UniformDL]. addToCacheEntityList. entiy is existed 2. url:" + uniformDownloadBPTransEntity.mUrl);
                return;
            }
        }
        QLog.i("UniformDownloadBPTransProxy", 1, "[UniformDL].>>>addToCacheEntityList. add it. url:" + uniformDownloadBPTransEntity.mUrl);
        this.f305890d.add(0, uniformDownloadBPTransEntity);
        if (this.f305890d.size() > 30) {
            List<UniformDownloadBPTransEntity> list = this.f305890d;
            list.remove(list.size() - 1);
        }
    }

    private boolean i(String str, boolean z16) {
        if (str == null) {
            QLog.e("UniformDownloadBPTransProxy", 1, "[UniformDL]. delEntityFromDB. url=null");
            return false;
        }
        j(UniformDownloadBPTransEntity.tableName(), "mUrl = ?", new String[]{str}, null);
        if (z16) {
            QLog.i("UniformDownloadBPTransProxy", 1, "[UniformDL]. delEntityFromDB. bImUpdateDB = true");
            transSaveToDatabase();
        }
        return true;
    }

    private synchronized UniformDownloadBPTransEntity l(String str) {
        UniformDownloadBPTransEntity uniformDownloadBPTransEntity = null;
        if (str == null) {
            return null;
        }
        Iterator<UniformDownloadBPTransEntity> it = this.f305890d.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            UniformDownloadBPTransEntity next = it.next();
            if (next != null && str.equalsIgnoreCase(next.mUrl)) {
                uniformDownloadBPTransEntity = next;
                break;
            }
        }
        return uniformDownloadBPTransEntity;
    }

    public static synchronized UniformDownloadBPTransProxy m() {
        UniformDownloadBPTransProxy uniformDownloadBPTransProxy;
        synchronized (UniformDownloadBPTransProxy.class) {
            if (f305889f == null) {
                try {
                    if (UniformDownloadMgr.m().k() != null) {
                        f305889f = new UniformDownloadBPTransProxy(UniformDownloadMgr.m().k());
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
            uniformDownloadBPTransProxy = f305889f;
        }
        return uniformDownloadBPTransProxy;
    }

    private boolean n(int i3) {
        long id5;
        List<UniformDownloadBPTransEntity> list = this.f305890d;
        if (list == null) {
            QLog.e("UniformDownloadBPTransProxy", 1, "[UniformDL].>>>getMore. no cache");
            return false;
        }
        if (list.size() == 0) {
            id5 = Long.MAX_VALUE;
        } else {
            List<UniformDownloadBPTransEntity> list2 = this.f305890d;
            id5 = list2.get(list2.size() - 1).getId();
        }
        List<Entity> rawQuery = DBMethodProxy.rawQuery(this.f305891e.getEntityManagerFactory().createEntityManager(), UniformDownloadBPTransEntity.class, "select * from ( select * from " + UniformDownloadBPTransEntity.tableName() + " where _id < " + String.valueOf(id5) + " order by _id desc limit " + i3 + ") order by _id desc", null);
        if (rawQuery != null && (rawQuery == null || rawQuery.size() != 0)) {
            Iterator<Entity> it = rawQuery.iterator();
            while (it.hasNext()) {
                h((UniformDownloadBPTransEntity) it.next());
            }
            return true;
        }
        QLog.i("UniformDownloadBPTransProxy", 1, "[UniformDL].>>>getMore. no more. ");
        return false;
    }

    private void o() {
        if (this.f305890d != null) {
            return;
        }
        String str = "select * from ( select * from " + UniformDownloadBPTransEntity.tableName() + " order by _id desc limit 30) order by _id desc";
        EntityManager createEntityManager = this.f305891e.getEntityManagerFactory().createEntityManager();
        List rawQuery = DBMethodProxy.rawQuery(createEntityManager, UniformDownloadBPTransEntity.class, str, null);
        this.f305890d = rawQuery;
        if (rawQuery == null) {
            this.f305890d = new ArrayList();
        }
        Iterator<UniformDownloadBPTransEntity> it = this.f305890d.iterator();
        while (it.hasNext()) {
            QLog.i("UniformDownloadBPTransProxy", 1, "[UniformDL]. >>>init cache:[ " + it.next().toString() + " ]");
        }
        createEntityManager.close();
    }

    private UniformDownloadBPTransEntity q(String str) {
        String str2 = "select * from " + UniformDownloadBPTransEntity.tableName() + " where mUrl = " + str;
        EntityManager createEntityManager = this.f305891e.getEntityManagerFactory().createEntityManager();
        if (createEntityManager == null) {
            QLog.e("UniformDownloadBPTransProxy", 1, "[UniformDL]. queryEntityFromDByUrl. EntityManager. create failed!!");
            return null;
        }
        List<Entity> rawQuery = DBMethodProxy.rawQuery(createEntityManager, UniformDownloadBPTransEntity.class, str2, null);
        if (rawQuery == null) {
            createEntityManager.close();
            return null;
        }
        if (rawQuery.size() > 1) {
            QLog.w("UniformDownloadBPTransProxy", 1, "[UniformDL]. count of DB  is over 1 when query url:" + str);
        }
        UniformDownloadBPTransEntity uniformDownloadBPTransEntity = (UniformDownloadBPTransEntity) rawQuery.get(0);
        createEntityManager.close();
        return uniformDownloadBPTransEntity;
    }

    private synchronized void r(String str) {
        UniformDownloadBPTransEntity uniformDownloadBPTransEntity;
        String str2;
        if (str == null) {
            return;
        }
        Iterator<UniformDownloadBPTransEntity> it = this.f305890d.iterator();
        while (true) {
            if (it.hasNext()) {
                uniformDownloadBPTransEntity = it.next();
                if (uniformDownloadBPTransEntity != null && str.equalsIgnoreCase(uniformDownloadBPTransEntity.mUrl)) {
                    break;
                }
            } else {
                uniformDownloadBPTransEntity = null;
                break;
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[UniformDL].>>>removFromCacheEntityList. remove it. url:");
        if (uniformDownloadBPTransEntity == null) {
            str2 = "null";
        } else {
            str2 = uniformDownloadBPTransEntity.mUrl;
        }
        sb5.append(str2);
        QLog.i("UniformDownloadBPTransProxy", 1, sb5.toString());
        this.f305890d.remove(uniformDownloadBPTransEntity);
    }

    public void f(UniformDownloadBPTransEntity uniformDownloadBPTransEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) uniformDownloadBPTransEntity);
            return;
        }
        QLog.i("UniformDownloadBPTransProxy", 1, "[UniformDL]. >>>addEntity. url[" + uniformDownloadBPTransEntity.mUrl + "]");
        o();
        h(uniformDownloadBPTransEntity);
        ThreadManagerV2.executeOnSubThread(new Runnable(uniformDownloadBPTransEntity) { // from class: com.tencent.mobileqq.uniformdownload.downloader.UniformDownloadBPTransProxy.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ UniformDownloadBPTransEntity f305892d;

            {
                this.f305892d = uniformDownloadBPTransEntity;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UniformDownloadBPTransProxy.this, (Object) uniformDownloadBPTransEntity);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    try {
                        UniformDownloadBPTransProxy.this.g(this.f305892d, null);
                        return;
                    } catch (Exception e16) {
                        e16.printStackTrace();
                        return;
                    }
                }
                iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
    }

    @Override // com.tencent.mobileqq.app.proxy.BaseProxyManager
    protected void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    protected void j(String str, String str2, String[] strArr, ProxyListener proxyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, str2, strArr, proxyListener);
        } else {
            addMsgQueue(String.valueOf(0), 0, str, str2, strArr, 2, proxyListener);
        }
    }

    public void k(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        QLog.i("UniformDownloadBPTransProxy", 1, "[UniformDL]. >>>deleteEntity. url[" + str + "]");
        o();
        r(str);
        i(str, false);
        n(1);
    }

    public UniformDownloadBPTransEntity p(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (UniformDownloadBPTransEntity) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        o();
        UniformDownloadBPTransEntity l3 = l(str);
        if (l3 != null) {
            return l3;
        }
        return q(str);
    }
}
