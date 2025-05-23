package com.tencent.qidian.controller;

import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qidian.data.PubAccountNavigationMenu;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import tencent.im.cs.cmd0x6ff.subcmd0x519$CRMMsgHead;
import tencent.im.cs.cmd0x6ff.subcmd0x519$GetNavigationMenuReqBody;
import tencent.im.cs.cmd0x6ff.subcmd0x519$GetNavigationMenuRspBody;
import tencent.im.cs.cmd0x6ff.subcmd0x519$ReqBody;
import tencent.im.cs.cmd0x6ff.subcmd0x519$RetInfo;
import tencent.im.cs.cmd0x6ff.subcmd0x519$RspBody;

/* loaded from: classes22.dex */
public class QidianPubAccountBigDataHandler extends BigDataHandler {
    static IPatchRedirector $redirector_;
    public static final AtomicBoolean E;
    public Map<Long, PubAccountNavigationMenu> D;

    /* renamed from: com.tencent.qidian.controller.QidianPubAccountBigDataHandler$2, reason: invalid class name */
    /* loaded from: classes22.dex */
    class AnonymousClass2 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f342849d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f342850e;
        final /* synthetic */ QidianPubAccountBigDataHandler this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            this.this$0.R2(this.f342849d);
            PubAccountNavigationMenu pubAccountNavigationMenu = this.this$0.D.get(Long.valueOf(this.f342849d));
            if (pubAccountNavigationMenu == null) {
                pubAccountNavigationMenu = new PubAccountNavigationMenu();
                pubAccountNavigationMenu.version = 0;
                pubAccountNavigationMenu.puin = this.f342849d;
                pubAccountNavigationMenu.xml = "";
            }
            this.this$0.N2(this.f342849d, pubAccountNavigationMenu, this.f342850e);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77552);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            E = new AtomicBoolean(false);
        }
    }

    public QidianPubAccountBigDataHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.D = null;
        this.D = new HashMap();
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.qidian.controller.QidianPubAccountBigDataHandler.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QidianPubAccountBigDataHandler.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    QidianPubAccountBigDataHandler.this.Q2();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        }, 8, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N2(long j3, PubAccountNavigationMenu pubAccountNavigationMenu, long j16) {
        int i3;
        try {
            long parseLong = Long.parseLong(this.f342825m.getCurrentAccountUin());
            subcmd0x519$GetNavigationMenuReqBody subcmd0x519_getnavigationmenureqbody = new subcmd0x519$GetNavigationMenuReqBody();
            subcmd0x519_getnavigationmenureqbody.uint64_puin.set(j3);
            PBUInt32Field pBUInt32Field = subcmd0x519_getnavigationmenureqbody.uint32_ver_no;
            if (pubAccountNavigationMenu == null) {
                i3 = 0;
            } else {
                i3 = pubAccountNavigationMenu.version;
            }
            pBUInt32Field.set(i3);
            subcmd0x519_getnavigationmenureqbody.uint64_uin.set(parseLong);
            subcmd0x519$ReqBody subcmd0x519_reqbody = new subcmd0x519$ReqBody();
            subcmd0x519_reqbody.uint32_sub_cmd.set(36);
            subcmd0x519_reqbody.msg_get_navigation_menu_req.set(subcmd0x519_getnavigationmenureqbody);
            subcmd0x519$CRMMsgHead subcmd0x519_crmmsghead = new subcmd0x519$CRMMsgHead();
            subcmd0x519_crmmsghead.uint32_ver_no.set(com.tencent.qidian.util.a.a(AppSetting.f99551k));
            subcmd0x519_crmmsghead.uint32_crm_sub_cmd.set(36);
            subcmd0x519_crmmsghead.uint32_clienttype.set(2);
            subcmd0x519_crmmsghead.uint64_kf_uin.set(j3);
            subcmd0x519_crmmsghead.uint64_puin.set(j3);
            subcmd0x519_reqbody.msg_crm_common_head.set(subcmd0x519_crmmsghead);
            F2(3001, subcmd0x519_reqbody, gdt_analysis_event.EVENT_MOTIVE_HIPPY_CHECK_PARAMS_SUCCESS, pubAccountNavigationMenu);
        } catch (Exception unused) {
        }
    }

    private void P2(boolean z16, byte[] bArr, Object obj) {
        boolean z17;
        String str;
        int i3;
        PubAccountNavigationMenu pubAccountNavigationMenu;
        if (z16 && bArr != null) {
            try {
                subcmd0x519$RspBody subcmd0x519_rspbody = new subcmd0x519$RspBody();
                subcmd0x519_rspbody.mergeFrom(bArr);
                subcmd0x519$GetNavigationMenuRspBody subcmd0x519_getnavigationmenurspbody = subcmd0x519_rspbody.msg_get_navigation_menu_rsp;
                subcmd0x519$RetInfo subcmd0x519_retinfo = subcmd0x519_getnavigationmenurspbody.msg_ret.get();
                int i16 = subcmd0x519_retinfo.uint32_ret_code.get();
                if (i16 == 0) {
                    if (subcmd0x519_getnavigationmenurspbody.int32_is_show.has() && subcmd0x519_getnavigationmenurspbody.int32_is_show.get() == 1) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (subcmd0x519_getnavigationmenurspbody.str_struct_msg.has()) {
                        str = subcmd0x519_getnavigationmenurspbody.str_struct_msg.get();
                    } else {
                        str = "";
                    }
                    if (subcmd0x519_getnavigationmenurspbody.uint32_ver_no.has()) {
                        i3 = subcmd0x519_getnavigationmenurspbody.uint32_ver_no.get();
                    } else {
                        i3 = 0;
                    }
                    if (obj != null) {
                        pubAccountNavigationMenu = (PubAccountNavigationMenu) obj;
                    } else {
                        pubAccountNavigationMenu = null;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("QidianPubAccountBigDataHandler", 2, "handleGetNatigationMenu isShow: " + z17 + " version: " + i3 + " | xml: " + str);
                    }
                    if (pubAccountNavigationMenu == null) {
                        pubAccountNavigationMenu = new PubAccountNavigationMenu();
                    }
                    if (str == null || str.length() == 0) {
                        str = pubAccountNavigationMenu.xml;
                    }
                    pubAccountNavigationMenu.xml = str;
                    pubAccountNavigationMenu.version = i3;
                    T2(pubAccountNavigationMenu);
                    if (z17) {
                        notifyUI(3001, true, pubAccountNavigationMenu);
                        return;
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.d("QidianPubAccountBigDataHandler", 2, "handleGetNatigationMenu no need show");
                            return;
                        }
                        return;
                    }
                }
                notifyUI(3001, false, null);
                String str2 = "Unknown error";
                if (subcmd0x519_retinfo.str_error_msg.has()) {
                    str2 = subcmd0x519_retinfo.str_error_msg.get();
                }
                if (QLog.isColorLevel()) {
                    QLog.d("QidianPubAccountBigDataHandler", 2, "handleGetNatigationMenu error: " + i16 + " msg: " + str2);
                    return;
                }
                return;
            } catch (Exception e16) {
                notifyUI(3001, false, null);
                e16.printStackTrace();
                return;
            }
        }
        notifyUI(3001, false, null);
        if (QLog.isColorLevel()) {
            QLog.d("QidianPubAccountBigDataHandler", 2, "handleGetNatigationMenu fail");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q2() {
        if (QLog.isColorLevel()) {
            QLog.d("QidianPubAccountBigDataHandler", 4, "initial ...");
        }
        EntityManager createEntityManager = this.f342825m.getEntityManagerFactory().createEntityManager();
        try {
            try {
                S2(createEntityManager);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("QidianPubAccountBigDataHandler", 2, "QidianManager get data from db error: " + e16.getMessage());
                }
            }
            E.set(true);
        } finally {
            createEntityManager.close();
        }
    }

    private void S2(EntityManager entityManager) {
        List<? extends Entity> query;
        if (entityManager != null && (query = entityManager.query(PubAccountNavigationMenu.class)) != null) {
            Iterator<? extends Entity> it = query.iterator();
            while (it.hasNext()) {
                PubAccountNavigationMenu pubAccountNavigationMenu = (PubAccountNavigationMenu) it.next();
                if (QLog.isColorLevel()) {
                    QLog.d("QidianPubAccountBigDataHandler", 4, "loadMenus query from db: " + pubAccountNavigationMenu);
                }
                if (!this.D.containsKey(Long.valueOf(pubAccountNavigationMenu.puin))) {
                    this.D.put(Long.valueOf(pubAccountNavigationMenu.puin), pubAccountNavigationMenu);
                }
            }
        }
    }

    private void T2(PubAccountNavigationMenu pubAccountNavigationMenu) {
        this.D.put(Long.valueOf(pubAccountNavigationMenu.puin), pubAccountNavigationMenu);
        ThreadManagerV2.post(new Runnable(pubAccountNavigationMenu) { // from class: com.tencent.qidian.controller.QidianPubAccountBigDataHandler.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ PubAccountNavigationMenu f342851d;

            {
                this.f342851d = pubAccountNavigationMenu;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QidianPubAccountBigDataHandler.this, (Object) pubAccountNavigationMenu);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                EntityManager createEntityManager = QidianPubAccountBigDataHandler.this.f342825m.getEntityManagerFactory().createEntityManager();
                try {
                    if (createEntityManager != null) {
                        try {
                            PubAccountNavigationMenu pubAccountNavigationMenu2 = this.f342851d;
                            if (pubAccountNavigationMenu2 != null) {
                                createEntityManager.persistOrReplace(pubAccountNavigationMenu2);
                            } else if (QLog.isColorLevel()) {
                                QLog.d("QidianPubAccountBigDataHandler", 2, "saveQidianExtInfoInSubThread externalInfo is null");
                            }
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                    }
                } finally {
                    createEntityManager.close();
                }
            }
        }, 5, null, true);
    }

    @Override // com.tencent.qidian.controller.BigDataHandler
    protected void H2(int i3, boolean z16, byte[] bArr, int i16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Boolean.valueOf(z16), bArr, Integer.valueOf(i16), obj);
            return;
        }
        if (i16 != 1305) {
            if (QLog.isColorLevel()) {
                QLog.d("QidianPubAccountBigDataHandler", 2, "recevie but not 0x519");
            }
        } else if (i3 == 3001) {
            if (QLog.isColorLevel()) {
                QLog.d("QidianPubAccountBigDataHandler", 2, "recevie CMD_BIG_DATA_GET_NATIGATION_MENU,begin to handle...");
            }
            P2(z16, bArr, obj);
        }
    }

    public PubAccountNavigationMenu O2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (PubAccountNavigationMenu) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        try {
            long parseLong = Long.parseLong(str);
            PubAccountNavigationMenu pubAccountNavigationMenu = this.D.get(Long.valueOf(parseLong));
            if (pubAccountNavigationMenu != null) {
                return pubAccountNavigationMenu;
            }
            if (E.get()) {
                return null;
            }
            R2(parseLong);
            return this.D.get(Long.valueOf(parseLong));
        } catch (Exception unused) {
            return null;
        }
    }

    public void R2(long j3) {
        EntityManager createEntityManager;
        PubAccountNavigationMenu pubAccountNavigationMenu;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, j3);
        } else if (!E.get() && (createEntityManager = this.f342825m.getEntityManagerFactory().createEntityManager()) != null && (pubAccountNavigationMenu = (PubAccountNavigationMenu) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) PubAccountNavigationMenu.class, String.valueOf(j3))) != null) {
            this.D.put(Long.valueOf(pubAccountNavigationMenu.puin), pubAccountNavigationMenu);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Class) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return a.class;
    }

    @Override // com.tencent.qidian.controller.BigDataHandler, com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.onDestroy();
        E.set(false);
        this.D.clear();
    }
}
