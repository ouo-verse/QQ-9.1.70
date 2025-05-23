package com.tencent.mobileqq.enterpriseqq;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.crmqq.structmsg.StructMsg$ButtonInfo;
import com.tencent.crmqq.structmsg.StructMsg$GetCRMMenuResponse;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.EnterpriseQQHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EnterpriseQQManager {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name */
    private static EnterpriseQQManager f205309k;

    /* renamed from: l, reason: collision with root package name */
    private static byte[] f205310l;

    /* renamed from: m, reason: collision with root package name */
    private static byte[] f205311m;

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<b> f205312a;

    /* renamed from: b, reason: collision with root package name */
    private double f205313b;

    /* renamed from: c, reason: collision with root package name */
    private double f205314c;

    /* renamed from: d, reason: collision with root package name */
    private long f205315d;

    /* renamed from: e, reason: collision with root package name */
    private long f205316e;

    /* renamed from: f, reason: collision with root package name */
    private QQAppInterface f205317f;

    /* renamed from: g, reason: collision with root package name */
    private Context f205318g;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.enterpriseqq.a f205319h;

    /* renamed from: i, reason: collision with root package name */
    protected Runnable f205320i;

    /* renamed from: j, reason: collision with root package name */
    protected SosoInterfaceOnLocationListener f205321j;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends SosoInterfaceOnLocationListener {
        static IPatchRedirector $redirector_;

        a(int i3, boolean z16, boolean z17, long j3, boolean z18, boolean z19, String str) {
            super(i3, z16, z17, j3, z18, z19, str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, EnterpriseQQManager.this, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), Long.valueOf(j3), Boolean.valueOf(z18), Boolean.valueOf(z19), str);
            }
        }

        @Override // com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener
        public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) sosoLbsInfo);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("EnterpriseQQManager", 2, "onLocationFinish() errCode=" + i3);
            }
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                synchronized (EnterpriseQQManager.f205311m) {
                    if (EnterpriseQQManager.this.f205312a != null && EnterpriseQQManager.this.f205312a.size() > 0) {
                        Iterator it = EnterpriseQQManager.this.f205312a.iterator();
                        while (it.hasNext()) {
                            b bVar = (b) it.next();
                            if (bVar != null) {
                                EnterpriseQQManager enterpriseQQManager = EnterpriseQQManager.this;
                                enterpriseQQManager.m(enterpriseQQManager.f205318g, EnterpriseQQManager.this.f205317f, bVar.f205323a, bVar.f205324b, false, 0.0d, 0.0d);
                            }
                        }
                        EnterpriseQQManager.this.f205312a.clear();
                    }
                }
            } else {
                SosoLocation sosoLocation = sosoLbsInfo.mLocation;
                double d16 = sosoLocation.mLat02;
                double d17 = sosoLocation.mLon02;
                EnterpriseQQManager.this.f205313b = d16;
                EnterpriseQQManager.this.f205314c = d17;
                EnterpriseQQManager.this.f205315d = System.currentTimeMillis();
                synchronized (EnterpriseQQManager.f205311m) {
                    if (EnterpriseQQManager.this.f205312a != null && EnterpriseQQManager.this.f205312a.size() > 0) {
                        Iterator it5 = EnterpriseQQManager.this.f205312a.iterator();
                        while (it5.hasNext()) {
                            b bVar2 = (b) it5.next();
                            if (bVar2 != null) {
                                EnterpriseQQManager enterpriseQQManager2 = EnterpriseQQManager.this;
                                enterpriseQQManager2.m(enterpriseQQManager2.f205318g, EnterpriseQQManager.this.f205317f, bVar2.f205323a, bVar2.f205324b, true, d16, d17);
                            }
                        }
                        EnterpriseQQManager.this.f205312a.clear();
                    }
                }
            }
            EnterpriseQQManager.this.f205318g = null;
            EnterpriseQQManager.this.f205317f = null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f205323a;

        /* renamed from: b, reason: collision with root package name */
        public String f205324b;
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71760);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        f205309k = null;
        f205310l = new byte[0];
        f205311m = new byte[0];
    }

    EnterpriseQQManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f205312a = null;
        this.f205313b = 0.0d;
        this.f205314c = 0.0d;
        this.f205315d = 0L;
        this.f205316e = 1800000L;
        this.f205317f = null;
        this.f205318g = null;
        this.f205319h = null;
        this.f205320i = new Runnable() { // from class: com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EnterpriseQQManager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (EnterpriseQQManager.this.f205318g == null || EnterpriseQQManager.this.f205317f == null) {
                    synchronized (EnterpriseQQManager.f205311m) {
                        if (EnterpriseQQManager.this.f205312a != null && EnterpriseQQManager.this.f205312a.size() > 0) {
                            Iterator it = EnterpriseQQManager.this.f205312a.iterator();
                            while (it.hasNext()) {
                                b bVar = (b) it.next();
                                if (bVar != null) {
                                    EnterpriseQQManager enterpriseQQManager = EnterpriseQQManager.this;
                                    enterpriseQQManager.m(enterpriseQQManager.f205318g, EnterpriseQQManager.this.f205317f, bVar.f205323a, bVar.f205324b, false, 0.0d, 0.0d);
                                }
                            }
                            EnterpriseQQManager.this.f205312a.clear();
                        }
                        EnterpriseQQManager.this.f205317f = null;
                        EnterpriseQQManager.this.f205318g = null;
                    }
                    return;
                }
                ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).startLocation(EnterpriseQQManager.this.f205321j);
            }
        };
        this.f205321j = new a(4, true, true, 0L, false, false, "EnterpriseQQManager");
        this.f205319h = new com.tencent.mobileqq.enterpriseqq.a();
        this.f205312a = new ArrayList<>();
        if (qQAppInterface != null) {
            l(qQAppInterface);
        }
    }

    public static EnterpriseQQManager j(QQAppInterface qQAppInterface) {
        if (f205309k == null) {
            synchronized (f205310l) {
                if (f205309k == null) {
                    f205309k = new EnterpriseQQManager(qQAppInterface);
                }
            }
        }
        return f205309k;
    }

    public void k(QQAppInterface qQAppInterface, String str, boolean z16) {
        long j3;
        EnterpriseQQHandler enterpriseQQHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, qQAppInterface, str, Boolean.valueOf(z16));
            return;
        }
        if (qQAppInterface != null && !TextUtils.isEmpty(str)) {
            com.tencent.mobileqq.enterpriseqq.a aVar = this.f205319h;
            if (aVar != null) {
                j3 = aVar.b(str);
            } else {
                j3 = 0;
            }
            if ((z16 || (!z16 && System.currentTimeMillis() - j3 > 43200000)) && (enterpriseQQHandler = (EnterpriseQQHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.ENTERPRISEQQ_HANDLER)) != null) {
                enterpriseQQHandler.F2(str);
            }
        }
    }

    public void l(QQAppInterface qQAppInterface) {
        List<? extends Entity> query;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQAppInterface);
            return;
        }
        if (this.f205319h == null) {
            this.f205319h = new com.tencent.mobileqq.enterpriseqq.a();
        }
        if (qQAppInterface != null && (query = qQAppInterface.getEntityManagerFactory().createEntityManager().query(EnterpriseQQMenuEntity.class)) != null && query.size() > 0) {
            Iterator<? extends Entity> it = query.iterator();
            while (it.hasNext()) {
                EnterpriseQQMenuEntity enterpriseQQMenuEntity = (EnterpriseQQMenuEntity) it.next();
                if (enterpriseQQMenuEntity != null) {
                    StructMsg$GetCRMMenuResponse structMsg$GetCRMMenuResponse = new StructMsg$GetCRMMenuResponse();
                    try {
                        structMsg$GetCRMMenuResponse.mergeFrom(enterpriseQQMenuEntity.data);
                    } catch (Exception unused) {
                    }
                    if (structMsg$GetCRMMenuResponse.ret_info.has()) {
                        this.f205319h.c(enterpriseQQMenuEntity.uin, structMsg$GetCRMMenuResponse.button_info.get(), enterpriseQQMenuEntity.seqno, enterpriseQQMenuEntity.savedDateTime);
                    }
                }
            }
        }
    }

    public void m(Context context, QQAppInterface qQAppInterface, String str, String str2, boolean z16, double d16, double d17) {
        EnterpriseQQHandler enterpriseQQHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, context, qQAppInterface, str, str2, Boolean.valueOf(z16), Double.valueOf(d16), Double.valueOf(d17));
        } else if (qQAppInterface != null && !TextUtils.isEmpty(str) && (enterpriseQQHandler = (EnterpriseQQHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.ENTERPRISEQQ_HANDLER)) != null) {
            enterpriseQQHandler.L2(str, str2, 1, z16, d16, d17);
        }
    }

    public void n(QQAppInterface qQAppInterface, String str, int i3, StructMsg$GetCRMMenuResponse structMsg$GetCRMMenuResponse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, qQAppInterface, str, Integer.valueOf(i3), structMsg$GetCRMMenuResponse);
            return;
        }
        if (qQAppInterface != null && !TextUtils.isEmpty(str)) {
            if (this.f205319h == null) {
                this.f205319h = new com.tencent.mobileqq.enterpriseqq.a();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f205319h.a(str) != i3 && structMsg$GetCRMMenuResponse != null) {
                List<StructMsg$ButtonInfo> list = structMsg$GetCRMMenuResponse.button_info.get();
                EnterpriseQQMenuEntity enterpriseQQMenuEntity = new EnterpriseQQMenuEntity(str, structMsg$GetCRMMenuResponse, i3, currentTimeMillis);
                EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
                EnterpriseQQMenuEntity enterpriseQQMenuEntity2 = (EnterpriseQQMenuEntity) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) EnterpriseQQMenuEntity.class, str);
                if (enterpriseQQMenuEntity2 != null) {
                    enterpriseQQMenuEntity2.data = (byte[]) enterpriseQQMenuEntity.data.clone();
                    enterpriseQQMenuEntity2.savedDateTime = enterpriseQQMenuEntity.savedDateTime;
                    enterpriseQQMenuEntity2.seqno = enterpriseQQMenuEntity.seqno;
                    createEntityManager.update(enterpriseQQMenuEntity2);
                } else {
                    createEntityManager.persist(enterpriseQQMenuEntity);
                }
                this.f205319h.c(str, list, i3, currentTimeMillis);
                return;
            }
            if (structMsg$GetCRMMenuResponse != null) {
                EntityManager createEntityManager2 = qQAppInterface.getEntityManagerFactory().createEntityManager();
                EnterpriseQQMenuEntity enterpriseQQMenuEntity3 = (EnterpriseQQMenuEntity) DBMethodProxy.find(createEntityManager2, (Class<? extends Entity>) EnterpriseQQMenuEntity.class, str);
                if (enterpriseQQMenuEntity3 != null) {
                    enterpriseQQMenuEntity3.savedDateTime = currentTimeMillis;
                    createEntityManager2.update(enterpriseQQMenuEntity3);
                }
                this.f205319h.d(str, currentTimeMillis);
            }
        }
    }
}
