package com.tencent.mobileqq.troop.shortcutbar.troopapp;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.xd.c0;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.bs;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.troop.essencemsg.s;
import com.tencent.mobileqq.troop.observer.i;
import com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarApp;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarHandler;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarInfo;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarManager;
import com.tencent.mobileqq.troop.shortcutbar.troopapp.c;
import com.tencent.mobileqq.troop.utils.r;
import com.tencent.mobileqq.vas.config.business.qvip.QVipBigTroopExpiredProcessor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troop.ab;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.mobileim.structmsg.structmsg$StructMsg;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c extends com.tencent.mobileqq.troop.shortcutbar.c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.a f298785a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.mobileqq.troop.shortcutbar.a f298786b;

    /* renamed from: c, reason: collision with root package name */
    private long f298787c;

    /* renamed from: d, reason: collision with root package name */
    private String f298788d;

    /* renamed from: e, reason: collision with root package name */
    private int f298789e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.troop.shortcutbar.f f298790f;

    /* renamed from: g, reason: collision with root package name */
    private i f298791g;

    /* renamed from: h, reason: collision with root package name */
    private bs f298792h;

    /* renamed from: i, reason: collision with root package name */
    private ab f298793i;

    /* renamed from: j, reason: collision with root package name */
    private AppRuntime f298794j;

    /* renamed from: k, reason: collision with root package name */
    private Context f298795k;

    /* renamed from: l, reason: collision with root package name */
    private Activity f298796l;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.mobileqq.troop.shortcutbar.e f298797m;

    /* renamed from: n, reason: collision with root package name */
    private TroopInfo f298798n;

    /* renamed from: o, reason: collision with root package name */
    private Long f298799o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a extends com.tencent.mobileqq.troop.shortcutbar.f {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.shortcutbar.f
        protected void a(String str, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, str, Long.valueOf(j3));
            } else if (!TextUtils.isEmpty(str) && str.equals(c.this.f298788d)) {
                ((TroopShortcutBarManager) c.this.f298794j.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER)).B(Long.parseLong(str), j3, 0);
                c.this.f298786b.a(str, j3);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:47:0x00c9 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:53:0x0106 A[Catch: Exception -> 0x0136, TryCatch #0 {Exception -> 0x0136, blocks: (B:11:0x0027, B:13:0x002d, B:16:0x0043, B:18:0x004d, B:21:0x0056, B:23:0x005e, B:25:0x0065, B:27:0x006d, B:29:0x0073, B:32:0x007a, B:34:0x008b, B:35:0x009b, B:37:0x00a1, B:42:0x00b7, B:48:0x00cb, B:50:0x00d9, B:51:0x0100, B:53:0x0106, B:54:0x0124, B:56:0x012c, B:60:0x00d3, B:63:0x00f3), top: B:9:0x0025 }] */
        /* JADX WARN: Removed duplicated region for block: B:56:0x012c A[Catch: Exception -> 0x0136, TRY_LEAVE, TryCatch #0 {Exception -> 0x0136, blocks: (B:11:0x0027, B:13:0x002d, B:16:0x0043, B:18:0x004d, B:21:0x0056, B:23:0x005e, B:25:0x0065, B:27:0x006d, B:29:0x0073, B:32:0x007a, B:34:0x008b, B:35:0x009b, B:37:0x00a1, B:42:0x00b7, B:48:0x00cb, B:50:0x00d9, B:51:0x0100, B:53:0x0106, B:54:0x0124, B:56:0x012c, B:60:0x00d3, B:63:0x00f3), top: B:9:0x0025 }] */
        /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:63:0x00f3 A[Catch: Exception -> 0x0136, TryCatch #0 {Exception -> 0x0136, blocks: (B:11:0x0027, B:13:0x002d, B:16:0x0043, B:18:0x004d, B:21:0x0056, B:23:0x005e, B:25:0x0065, B:27:0x006d, B:29:0x0073, B:32:0x007a, B:34:0x008b, B:35:0x009b, B:37:0x00a1, B:42:0x00b7, B:48:0x00cb, B:50:0x00d9, B:51:0x0100, B:53:0x0106, B:54:0x0124, B:56:0x012c, B:60:0x00d3, B:63:0x00f3), top: B:9:0x0025 }] */
        @Override // com.tencent.mobileqq.troop.shortcutbar.f
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected void b(long j3, boolean z16) {
            TroopShortcutBarInfo troopShortcutBarInfo;
            boolean z17;
            boolean z18;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Boolean.valueOf(z16));
                return;
            }
            try {
                if (!z16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("AppShortcutBarProcessor", 2, "[TroopShortcutBarObserver] onGetAIOShortcutBarInfo fail, troopCode:" + j3);
                        return;
                    }
                    return;
                }
                if (j3 == c.this.f298787c && c.this.f298794j != null) {
                    TroopInfo z19 = c.this.z();
                    if (z19 == null) {
                        QLog.e("AppShortcutBarProcessor", 1, "[TroopShortcutBarObserver] onGetAIOShortcutBarInfo. troopInfo is null.");
                        return;
                    }
                    if (!c.this.v()) {
                        if (QLog.isColorLevel()) {
                            QLog.e("AppShortcutBarProcessor", 2, "[TroopShortcutBarObserver] onGetAIOShortcutBarInfo. can't show, Noting To Do!");
                            return;
                        }
                        return;
                    }
                    TroopShortcutBarManager troopShortcutBarManager = (TroopShortcutBarManager) c.this.f298794j.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER);
                    ArrayList<ShortcutBarInfo> arrayList = null;
                    if (troopShortcutBarManager != null) {
                        troopShortcutBarInfo = troopShortcutBarManager.m(Long.valueOf(c.this.f298787c));
                    } else {
                        troopShortcutBarInfo = null;
                    }
                    if (!z19.isOwnerOrAdmin() && !z19.isTroopOwner(c.this.f298794j.getCurrentAccountUin())) {
                        z17 = false;
                        if (!z17 && c.this.x().f298638c != com.tencent.mobileqq.troop.shortcutbar.e.f298635g) {
                            z18 = false;
                            if (troopShortcutBarInfo == null && ((!z17 && troopShortcutBarInfo.getDisabled() == 0) || (z17 && troopShortcutBarInfo.getGroupDisabled() == 0))) {
                                arrayList = c.this.t(troopShortcutBarInfo.getAppList());
                                troopShortcutBarManager.s(Long.valueOf(c.this.f298787c), troopShortcutBarInfo);
                            } else if (troopShortcutBarManager != null) {
                                troopShortcutBarManager.r(Long.valueOf(c.this.f298787c));
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("AppShortcutBarProcessor", 2, "[TroopShortcutBarObserver] onGetAIOShortcutBarInfo. updatePanel -> info:" + troopShortcutBarInfo + ", list:" + arrayList);
                            }
                            if (c.this.f298786b == null) {
                                c.this.f298786b.i(0, arrayList, z18);
                                return;
                            }
                            return;
                        }
                        z18 = true;
                        if (troopShortcutBarInfo == null) {
                        }
                        if (troopShortcutBarManager != null) {
                        }
                        if (QLog.isColorLevel()) {
                        }
                        if (c.this.f298786b == null) {
                        }
                    }
                    z17 = true;
                    if (!z17) {
                        z18 = false;
                        if (troopShortcutBarInfo == null) {
                        }
                        if (troopShortcutBarManager != null) {
                        }
                        if (QLog.isColorLevel()) {
                        }
                        if (c.this.f298786b == null) {
                        }
                    }
                    z18 = true;
                    if (troopShortcutBarInfo == null) {
                    }
                    if (troopShortcutBarManager != null) {
                    }
                    if (QLog.isColorLevel()) {
                    }
                    if (c.this.f298786b == null) {
                    }
                }
            } catch (Exception e16) {
                QLog.e("AppShortcutBarProcessor", 1, e16.getMessage());
            }
        }

        @Override // com.tencent.mobileqq.troop.shortcutbar.f
        protected void e(long j3, boolean z16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), Boolean.valueOf(z16), Integer.valueOf(i3));
                return;
            }
            if (z16 && c.this.f298794j != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("AppShortcutBarProcessor", 2, "[TroopShortcutBarObserver] onSetTotalSwitch troopCode:" + j3 + ", disabled:" + i3);
                }
                TroopShortcutBarManager troopShortcutBarManager = (TroopShortcutBarManager) c.this.f298794j.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER);
                if (troopShortcutBarManager != null && troopShortcutBarManager.p()) {
                    troopShortcutBarManager.w(false);
                    TroopShortcutBarInfo m3 = troopShortcutBarManager.m(Long.valueOf(c.this.f298787c));
                    if (m3 != null) {
                        m3.setCacheTSMil(0);
                        m3.setNextFetchRedPointTsMil(0L);
                        m3.setRedPointCacheTsMil(0);
                    }
                }
                c.this.w();
            }
        }

        @Override // com.tencent.mobileqq.troop.shortcutbar.f
        protected void f(long j3) {
            TroopShortcutBarInfo troopShortcutBarInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, j3);
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            try {
                try {
                    if (j3 == c.this.f298787c) {
                        if (QLog.isColorLevel()) {
                            sb5.append("onShortcutBarItemUpdated.");
                        }
                        TroopInfo k3 = ((TroopManager) c.this.f298794j.getManager(QQManagerFactory.TROOP_MANAGER)).k(c.this.f298788d);
                        if (k3 != null) {
                            if (QLog.isColorLevel()) {
                                sb5.append("onShortcutBarItemUpdated. getTroopAIOShortCutBar.");
                            }
                            TroopShortcutBarManager troopShortcutBarManager = (TroopShortcutBarManager) c.this.f298794j.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER);
                            if (troopShortcutBarManager != null) {
                                troopShortcutBarInfo = troopShortcutBarManager.m(Long.valueOf(c.this.f298787c));
                            } else {
                                troopShortcutBarInfo = null;
                            }
                            if (troopShortcutBarInfo != null) {
                                troopShortcutBarInfo.setRedPointCacheTsMil(0);
                                troopShortcutBarInfo.setNextFetchRedPointTsMil(0L);
                            }
                            TroopShortcutBarHandler troopShortcutBarHandler = (TroopShortcutBarHandler) ((QQAppInterface) c.this.f298794j).getBusinessHandler(BusinessHandlerFactory.TROOP_SHORTCUTBAR_HANDLE);
                            if (troopShortcutBarHandler != null) {
                                troopShortcutBarHandler.E2(c.this.f298787c, (int) k3.dwGroupClassExt, null);
                            }
                        } else if (QLog.isColorLevel()) {
                            sb5.append("onShortcutBarItemUpdated. TroopInfo is null!");
                        }
                    }
                    if (sb5.length() <= 0) {
                        return;
                    }
                } catch (Exception e16) {
                    QLog.e("AppShortcutBarProcessor", 1, e16.getMessage());
                    if (sb5.length() <= 0) {
                        return;
                    }
                }
                QLog.d("AppShortcutBarProcessor", 2, sb5.toString());
            } catch (Throwable th5) {
                if (sb5.length() > 0) {
                    QLog.d("AppShortcutBarProcessor", 2, sb5.toString());
                }
                throw th5;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b extends bs {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            MessageRecord messageRecord;
            List<MessageRecord> Q = ((QQAppInterface) c.this.f298794j).getMessageFacade().Q(AppConstants.TROOP_SYSTEM_MSG_UIN, 0);
            if (Q != null && Q.size() - 1 >= 0) {
                messageRecord = Q.get(Q.size() - 1);
            } else {
                messageRecord = null;
            }
            if (messageRecord instanceof MessageForSystemMsg) {
                structmsg$StructMsg systemMsg = ((MessageForSystemMsg) messageRecord).getSystemMsg();
                if (systemMsg.f436065msg.get() != null && systemMsg.msg_type.get() == 2) {
                    int i3 = systemMsg.f436065msg.group_msg_type.get();
                    if (i3 == 3 || i3 == 15) {
                        c.this.y(systemMsg);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.bs
        public void onGetSystemMsgFin(boolean z16, boolean z17, List<MessageRecord> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), list);
            } else if (c.this.f298794j != null && z16) {
                if (QLog.isColorLevel()) {
                    QLog.i("AppShortcutBarProcessor", 2, "onGetSystemMsgFin.success");
                }
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.shortcutbar.troopapp.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.b.this.b();
                    }
                }, 32, null, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.shortcutbar.troopapp.c$c, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public class C8777c implements ab {
        static IPatchRedirector $redirector_;

        C8777c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.qqnt.troop.ab
        public void a(@NonNull TroopInfo troopInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopInfo);
                return;
            }
            if (c.this.f298788d.equals(troopInfo.troopuin)) {
                long longValue = c.this.f298799o.longValue();
                long j3 = troopInfo.dwGroupClassExt;
                if (longValue != j3) {
                    c.this.f298799o = Long.valueOf(j3);
                    try {
                        TroopShortcutBarHandler troopShortcutBarHandler = (TroopShortcutBarHandler) ((QQAppInterface) c.this.f298794j).getBusinessHandler(BusinessHandlerFactory.TROOP_SHORTCUTBAR_HANDLE);
                        if (troopShortcutBarHandler != null) {
                            troopShortcutBarHandler.E2(c.this.f298787c, (int) troopInfo.dwGroupClassExt, null);
                        }
                    } catch (Exception e16) {
                        QLog.e("AppShortcutBarProcessor", 1, "onTroopInfoChanged refreshAppShortCutBarAppList error", e16);
                    }
                }
            }
        }
    }

    public c(com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.a aVar, com.tencent.mobileqq.troop.shortcutbar.a aVar2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) aVar2);
            return;
        }
        this.f298789e = 0;
        this.f298799o = 0L;
        this.f298785a = aVar;
        this.f298794j = aVar.d();
        this.f298795k = aVar.e();
        this.f298796l = aVar.c();
        this.f298786b = aVar2;
        long C = C();
        this.f298787c = C;
        this.f298788d = String.valueOf(C);
        this.f298789e = StudyModeManager.t() ? 1 : 0;
        if (z() != null) {
            this.f298799o = Long.valueOf(z().dwGroupClassExt);
        }
    }

    private TroopShortcutBarInfo A() {
        int i3;
        try {
            TroopShortcutBarManager troopShortcutBarManager = (TroopShortcutBarManager) this.f298794j.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER);
            TroopShortcutBarInfo m3 = troopShortcutBarManager.m(Long.valueOf(this.f298787c));
            if (m3 != null) {
                if (StudyModeManager.t()) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if (m3.getCacheTSMil() < System.currentTimeMillis() || ((StudyModeManager.t() && this.f298789e != i3) || (z() != null && z().dwGroupClassExt != m3.getGroupClassExt()))) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AppShortcutBarProcessor", 2, "getTroopShortcutBarInfo. AIO TroopShortcutBar cache is out of date. Getting new list from server. ");
                    }
                    this.f298789e = i3;
                    B();
                }
                return m3;
            }
            TroopShortcutBarInfo f16 = troopShortcutBarManager.f(Long.valueOf(this.f298787c));
            if (QLog.isColorLevel()) {
                QLog.d("AppShortcutBarProcessor", 2, "getTroopShortcutBarInfo. AIO TroopShortcutBar cache is null. MMKV Cache is: " + f16 + ", Getting list from server. ");
            }
            B();
            return f16;
        } catch (Exception e16) {
            QLog.e("AppShortcutBarProcessor", 1, e16.getMessage());
            return null;
        }
    }

    private void B() {
        if (QLog.isColorLevel()) {
            QLog.d("AppShortcutBarProcessor", 2, "getTroopShortcutBarInfoFromServer.");
        }
        TroopInfo z16 = z();
        if (z16 != null) {
            ((TroopShortcutBarHandler) ((QQAppInterface) this.f298794j).getBusinessHandler(BusinessHandlerFactory.TROOP_SHORTCUTBAR_HANDLE)).E2(this.f298787c, (int) z16.dwGroupClassExt, null);
        }
    }

    private long C() {
        try {
            return Long.parseLong(this.f298785a.f());
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.e("AppShortcutBarProcessor", 2, "getTroopUinNoEmpty is Exception");
            }
            return 0L;
        }
    }

    private void D() {
        this.f298790f = new a();
        this.f298792h = new b();
        this.f298793i = new C8777c();
        u(this.f298790f);
        u(this.f298792h);
        u(this.f298791g);
        ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).registerTroopInfoChangedObserver(null, this.f298793i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(ArrayList arrayList, boolean z16) {
        com.tencent.mobileqq.troop.shortcutbar.a aVar = this.f298786b;
        if (aVar != null) {
            aVar.i(0, arrayList, z16);
        }
    }

    private void F(BusinessObserver businessObserver) {
        AppRuntime appRuntime = this.f298794j;
        if (appRuntime != null && businessObserver != null) {
            ((QQAppInterface) appRuntime).removeObserver(businessObserver);
        }
    }

    private void G() {
        TroopShortcutBarManager troopShortcutBarManager = (TroopShortcutBarManager) this.f298794j.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER);
        if (!"".equals(this.f298788d) && troopShortcutBarManager != null) {
            long j3 = troopShortcutBarManager.j(this.f298787c);
            if (j3 > troopShortcutBarManager.g(this.f298787c)) {
                troopShortcutBarManager.y(this.f298787c, j3);
            }
            TroopShortcutBarInfo m3 = troopShortcutBarManager.m(Long.valueOf(this.f298787c));
            if (m3 != null) {
                Iterator<TroopShortcutBarApp> it = m3.getAppList().iterator();
                while (it.hasNext()) {
                    it.next().setAddPoint(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<ShortcutBarInfo> t(ArrayList<TroopShortcutBarApp> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList<ShortcutBarInfo> arrayList2 = new ArrayList<>();
            Iterator<TroopShortcutBarApp> it = arrayList.iterator();
            while (it.hasNext()) {
                TroopShortcutBarApp next = it.next();
                if (next != null) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return null;
    }

    private void u(BusinessObserver businessObserver) {
        AppRuntime appRuntime = this.f298794j;
        if (appRuntime != null && businessObserver != null) {
            ((QQAppInterface) appRuntime).addObserver(businessObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean v() {
        Boolean bool = Boolean.FALSE;
        try {
            AppRuntime appRuntime = this.f298794j;
            if (appRuntime != null) {
                TroopInfo k3 = ((TroopManager) appRuntime.getManager(QQManagerFactory.TROOP_MANAGER)).k(this.f298788d);
                com.tencent.mobileqq.troop.shortcutbar.e x16 = x();
                if (x16 != null && k3 != null && (x16.b((int) k3.dwGroupClassExt) || x16.c((int) k3.dwGroupClassExt))) {
                    bool = Boolean.TRUE;
                }
            }
        } catch (Exception e16) {
            QLog.e("AppShortcutBarProcessor", 1, "canShow. exception: " + e16.getMessage());
        }
        if (z() != null && z().isHomeworkTroop()) {
            bool = Boolean.TRUE;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AppShortcutBarProcessor", 2, "canShow. result: " + bool);
        }
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0061 A[Catch: Exception -> 0x00db, TryCatch #0 {Exception -> 0x00db, blocks: (B:7:0x0009, B:9:0x0010, B:11:0x0016, B:14:0x001d, B:16:0x0023, B:18:0x0029, B:21:0x0030, B:23:0x003b, B:28:0x0051, B:33:0x0061, B:36:0x0072, B:38:0x0078, B:42:0x0085, B:43:0x008f, B:45:0x0095, B:46:0x00bc, B:48:0x00c6, B:50:0x00d3, B:52:0x00d7, B:57:0x0069), top: B:6:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0078 A[Catch: Exception -> 0x00db, TryCatch #0 {Exception -> 0x00db, blocks: (B:7:0x0009, B:9:0x0010, B:11:0x0016, B:14:0x001d, B:16:0x0023, B:18:0x0029, B:21:0x0030, B:23:0x003b, B:28:0x0051, B:33:0x0061, B:36:0x0072, B:38:0x0078, B:42:0x0085, B:43:0x008f, B:45:0x0095, B:46:0x00bc, B:48:0x00c6, B:50:0x00d3, B:52:0x00d7, B:57:0x0069), top: B:6:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0085 A[Catch: Exception -> 0x00db, TryCatch #0 {Exception -> 0x00db, blocks: (B:7:0x0009, B:9:0x0010, B:11:0x0016, B:14:0x001d, B:16:0x0023, B:18:0x0029, B:21:0x0030, B:23:0x003b, B:28:0x0051, B:33:0x0061, B:36:0x0072, B:38:0x0078, B:42:0x0085, B:43:0x008f, B:45:0x0095, B:46:0x00bc, B:48:0x00c6, B:50:0x00d3, B:52:0x00d7, B:57:0x0069), top: B:6:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0095 A[Catch: Exception -> 0x00db, TryCatch #0 {Exception -> 0x00db, blocks: (B:7:0x0009, B:9:0x0010, B:11:0x0016, B:14:0x001d, B:16:0x0023, B:18:0x0029, B:21:0x0030, B:23:0x003b, B:28:0x0051, B:33:0x0061, B:36:0x0072, B:38:0x0078, B:42:0x0085, B:43:0x008f, B:45:0x0095, B:46:0x00bc, B:48:0x00c6, B:50:0x00d3, B:52:0x00d7, B:57:0x0069), top: B:6:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c6 A[Catch: Exception -> 0x00db, TryCatch #0 {Exception -> 0x00db, blocks: (B:7:0x0009, B:9:0x0010, B:11:0x0016, B:14:0x001d, B:16:0x0023, B:18:0x0029, B:21:0x0030, B:23:0x003b, B:28:0x0051, B:33:0x0061, B:36:0x0072, B:38:0x0078, B:42:0x0085, B:43:0x008f, B:45:0x0095, B:46:0x00bc, B:48:0x00c6, B:50:0x00d3, B:52:0x00d7, B:57:0x0069), top: B:6:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d3 A[Catch: Exception -> 0x00db, TryCatch #0 {Exception -> 0x00db, blocks: (B:7:0x0009, B:9:0x0010, B:11:0x0016, B:14:0x001d, B:16:0x0023, B:18:0x0029, B:21:0x0030, B:23:0x003b, B:28:0x0051, B:33:0x0061, B:36:0x0072, B:38:0x0078, B:42:0x0085, B:43:0x008f, B:45:0x0095, B:46:0x00bc, B:48:0x00c6, B:50:0x00d3, B:52:0x00d7, B:57:0x0069), top: B:6:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void w() {
        boolean z16;
        final boolean z17;
        boolean z18;
        final ArrayList<ShortcutBarInfo> arrayList;
        if (this.f298794j == null) {
            return;
        }
        try {
            if (!v()) {
                if (QLog.isColorLevel()) {
                    QLog.e("AppShortcutBarProcessor", 2, "getAIOShortcutBarInfoOnShow. canShow == false. ");
                    return;
                }
                return;
            }
            TroopShortcutBarInfo A = A();
            if (A == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("AppShortcutBarProcessor", 2, "getAIOShortcutBarInfoOnShow. getTroopShortcutBarInfo == null. ");
                    return;
                }
                return;
            }
            if (!z().isOwnerOrAdmin() && !z().isTroopOwner(this.f298794j.getCurrentAccountUin())) {
                z16 = false;
                if (!z16 && x().f298638c != com.tencent.mobileqq.troop.shortcutbar.e.f298635g) {
                    z17 = false;
                    if ((z16 && A.getDisabled() == 0) || (z16 && A.getGroupDisabled() == 0)) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (z() != null && z().isHomeworkTroop()) {
                        z18 = true;
                    }
                    if (!z18) {
                        arrayList = t(A.getAppList());
                    } else {
                        arrayList = null;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("AppShortcutBarProcessor", 2, "getAIOShortcutBarInfoOnShow. updatePanel() from cacheInfo:" + A + " isOwnerOrAdmin:" + z16 + ",bShowManageBtn:" + z17);
                    }
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.shortcutbar.troopapp.b
                            @Override // java.lang.Runnable
                            public final void run() {
                                c.this.E(arrayList, z17);
                            }
                        });
                        return;
                    }
                    com.tencent.mobileqq.troop.shortcutbar.a aVar = this.f298786b;
                    if (aVar != null) {
                        aVar.i(0, arrayList, z17);
                        return;
                    }
                    return;
                }
                z17 = true;
                if (z16) {
                }
                z18 = false;
                if (z() != null) {
                    z18 = true;
                }
                if (!z18) {
                }
                if (QLog.isColorLevel()) {
                }
                if (Looper.myLooper() == Looper.getMainLooper()) {
                }
            }
            z16 = true;
            if (!z16) {
                z17 = false;
                if (z16) {
                }
                z18 = false;
                if (z() != null) {
                }
                if (!z18) {
                }
                if (QLog.isColorLevel()) {
                }
                if (Looper.myLooper() == Looper.getMainLooper()) {
                }
            }
            z17 = true;
            if (z16) {
            }
            z18 = false;
            if (z() != null) {
            }
            if (!z18) {
            }
            if (QLog.isColorLevel()) {
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
            }
        } catch (Exception e16) {
            QLog.e("AppShortcutBarProcessor", 1, "getAIOShortcutBarInfoOnShow. exception: " + e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.tencent.mobileqq.troop.shortcutbar.e x() {
        if (this.f298797m == null) {
            this.f298797m = (com.tencent.mobileqq.troop.shortcutbar.e) am.s().x(c0.CTRL_INDEX);
        }
        return this.f298797m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(structmsg$StructMsg structmsg_structmsg) {
        TroopInfo k3;
        long j3 = structmsg_structmsg.f436065msg.group_code.get();
        if (!this.f298788d.equalsIgnoreCase("" + j3) || (k3 = ((TroopManager) this.f298794j.getManager(QQManagerFactory.TROOP_MANAGER)).k(this.f298788d)) == null) {
            return;
        }
        try {
            TroopShortcutBarManager troopShortcutBarManager = (TroopShortcutBarManager) this.f298794j.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER);
            TroopShortcutBarHandler troopShortcutBarHandler = (TroopShortcutBarHandler) ((QQAppInterface) this.f298794j).getBusinessHandler(BusinessHandlerFactory.TROOP_SHORTCUTBAR_HANDLE);
            TroopShortcutBarInfo m3 = troopShortcutBarManager.m(Long.valueOf(this.f298787c));
            if (m3 != null) {
                m3.setCacheTSMil(0);
                m3.setRedPointCacheTsMil(0);
                m3.setNextFetchRedPointTsMil(0L);
                troopShortcutBarHandler.E2(this.f298787c, (int) k3.dwGroupClassExt, null);
            }
        } catch (Exception e16) {
            QLog.e("AppShortcutBarProcessor", 1, e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TroopInfo z() {
        if (this.f298798n == null) {
            this.f298798n = ((TroopManager) this.f298794j.getManager(QQManagerFactory.TROOP_MANAGER)).k(this.f298788d);
        }
        return this.f298798n;
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.c
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        D();
        if (QLog.isColorLevel()) {
            QLog.d("AppShortcutBarProcessor", 2, "loadData -> getAIOShortcutBarInfoOnShow");
        }
        w();
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.c
    public void b(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, obj);
            return;
        }
        if (obj != null && (obj instanceof TroopShortcutBarApp)) {
            G();
            TroopShortcutBarApp troopShortcutBarApp = (TroopShortcutBarApp) obj;
            String appUrl = troopShortcutBarApp.getAppUrl();
            long appId = troopShortcutBarApp.getAppId();
            TroopInfo k3 = ((TroopManager) this.f298794j.getManager(QQManagerFactory.TROOP_MANAGER)).k(this.f298788d);
            if (k3 == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("AppShortcutBarProcessor", 2, "OnClickListener. troopInfo is null.");
                    return;
                }
                return;
            }
            if ((appId == 102148883 || appId == 102060897) && !k3.isHomeworkTroop()) {
                QQToastUtil.showQQToastInUiThread(1, "\u8bf7\u4fee\u6539\u7fa4\u5206\u7c7b\u4e3a\u8001\u5e08\u5bb6\u957f\u540e\u4f7f\u7528");
                return;
            }
            if (appId == 101847770) {
                ReportController.o(null, "dc00898", "", "", "0X800AAD4", "0X800AAD4", 0, 0, String.valueOf(troopShortcutBarApp.getAppId()), this.f298788d, String.valueOf(k3.dwGroupClassExt), "");
            }
            if (appId == 1101236949 && QVipBigTroopExpiredProcessor.getConfig().mIsEnable && k3.mIsFreezed == 1 && (k3.isOwnerOrAdmin() || k3.isTroopOwner(this.f298794j.getCurrentAccountUin()))) {
                ReportController.o(null, "dc00898", "", "", "0X800AAD4", "0X800AAD4", 0, 0, String.valueOf(troopShortcutBarApp.getAppId()), this.f298788d, String.valueOf(k3.dwGroupClassExt), "");
            }
            if (appId == 101886235) {
                s.l((QQAppInterface) this.f298794j, this.f298788d, true);
                s.m((QQAppInterface) this.f298794j, this.f298788d, true);
            }
            int appIdUnreadNum = troopShortcutBarApp.getAppIdUnreadNum();
            troopShortcutBarApp.setAppidUnReadNum(0);
            ReportController.o(null, "dc00898", "", "", "0X800AAD4", "0X800AAD4", 0, 0, String.valueOf(troopShortcutBarApp.getAppId()), this.f298788d, String.valueOf(k3.dwGroupClassExt), "");
            r.e((QQAppInterface) this.f298794j, this.f298795k, this.f298796l, this.f298788d, appId, appUrl, 0, appIdUnreadNum, true);
        }
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.b
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        G();
        F(this.f298791g);
        F(this.f298792h);
        F(this.f298790f);
        ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).unregisterTroopInfoChangedObserver(this.f298793i);
        this.f298785a = null;
        this.f298786b = null;
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.b
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.c
    public void e(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
    }
}
