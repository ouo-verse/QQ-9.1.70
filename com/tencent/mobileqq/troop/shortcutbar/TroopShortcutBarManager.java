package com.tencent.mobileqq.troop.shortcutbar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarUtil;
import com.tencent.mobileqq.troop.troopapps.g;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import tencent.im.oidb.cmd0xece.oidb_0xece$RspBody;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopShortcutBarManager implements Manager {
    static IPatchRedirector $redirector_;
    protected com.tencent.mobileqq.troop.troopapps.api.b C;
    private MMKVOptionEntity D;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f298595d;

    /* renamed from: e, reason: collision with root package name */
    private ConcurrentHashMap<Long, TroopShortcutBarInfo> f298596e;

    /* renamed from: f, reason: collision with root package name */
    private ConcurrentHashMap<String, Long> f298597f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f298598h;

    /* renamed from: i, reason: collision with root package name */
    private BroadcastReceiver f298599i;

    /* renamed from: m, reason: collision with root package name */
    private ConcurrentHashMap<Long, Integer> f298600m;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends com.tencent.mobileqq.troop.troopapps.api.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopShortcutBarManager.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.troopapps.api.b
        protected void b(boolean z16, long j3, Object obj, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                TroopShortcutBarManager.this.n(z16, j3, obj, i3);
            } else {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Long.valueOf(j3), obj, Integer.valueOf(i3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopShortcutBarManager.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Long l3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            if ("com.tencent.mobileqq.addgroupapplication".equals(intent.getAction())) {
                String stringExtra = intent.getStringExtra("groupUin");
                String stringExtra2 = intent.getStringExtra("appId");
                if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                    if (QLog.isColorLevel()) {
                        QLog.e("TroopShortcutBarManager", 2, "BroadcastReceiver onReceive troopUin:" + stringExtra + "appId: " + stringExtra2);
                    }
                    try {
                        l3 = Long.valueOf(Long.parseLong(stringExtra));
                    } catch (Exception unused) {
                        QLog.e("TroopShortcutBarManager", 1, "parseLong troopUin exception");
                        l3 = null;
                    }
                    TroopShortcutBarInfo m3 = TroopShortcutBarManager.this.m(l3);
                    if (m3 != null) {
                        if (QLog.isColorLevel()) {
                            QLog.e("TroopShortcutBarManager", 2, "BroadcastReceiver onReceive info is not null");
                        }
                        m3.setRedPointCacheTsMil(0);
                        m3.setNextFetchRedPointTsMil(0L);
                        m3.setCacheTSMil(0);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.e("TroopShortcutBarManager", 2, "BroadcastReceiver onReceive info is null");
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.e("TroopShortcutBarManager", 2, "BroadcastReceiver onReceive Failed");
                }
            }
        }
    }

    public TroopShortcutBarManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f298596e = new ConcurrentHashMap<>();
        this.f298597f = new ConcurrentHashMap<>();
        this.f298598h = false;
        this.f298600m = new ConcurrentHashMap<>();
        this.f298595d = qQAppInterface;
        this.f298596e.clear();
        this.f298597f.clear();
        o();
        a aVar = new a();
        this.C = aVar;
        qQAppInterface.addObserver(aVar);
    }

    private void d(TroopShortcutBarApp troopShortcutBarApp, Object obj) {
        if (troopShortcutBarApp != null && obj != null && (obj instanceof Long)) {
            if (troopShortcutBarApp.getAppId() == ((Long) obj).longValue()) {
                troopShortcutBarApp.setNeedScroll(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MMKVOptionEntity k() {
        if (this.D == null) {
            this.D = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        }
        return this.D;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(boolean z16, long j3, Object obj, int i3) {
        TroopShortcutBarUtil.a b16;
        if (QLog.isColorLevel()) {
            QLog.d("TroopShortcutBarManager", 2, "handleGetAddTroopAppRemindInfo isSuccess:" + z16 + " troopUin:" + j3 + " errCode:" + i3);
        }
        if (z16 && obj != null && (obj instanceof oidb_0xece$RspBody)) {
            oidb_0xece$RspBody oidb_0xece_rspbody = (oidb_0xece$RspBody) obj;
            if (oidb_0xece_rspbody.busi_id.get() == 1053 && (b16 = TroopShortcutBarUtil.b(oidb_0xece_rspbody)) != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopShortcutBarManager", 2, "addRemindGrayTip tipItem" + b16.toString());
                }
                TroopShortcutBarUtil.a(this.f298595d, String.valueOf(j3), b16);
            }
        }
    }

    private void o() {
        this.f298599i = new b();
        q();
    }

    private void q() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tencent.mobileqq.addgroupapplication");
            this.f298595d.getApp().registerReceiver(this.f298599i, intentFilter);
        } catch (Exception unused) {
            QLog.e("TroopShortcutBarManager", 1, "registerMiniAppAdd exception.");
        }
    }

    private void x() {
        try {
            this.f298595d.getApp().unregisterReceiver(this.f298599i);
        } catch (Exception unused) {
            QLog.e("TroopShortcutBarManager", 1, "unregisterMiniAppAdd exception.");
        }
    }

    public void A(long j3, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        TroopShortcutBarInfo troopShortcutBarInfo = this.f298596e.get(Long.valueOf(j3));
        if (troopShortcutBarInfo == null) {
            return;
        }
        troopShortcutBarInfo.setDisabled(i3);
        if (z16) {
            troopShortcutBarInfo.setGroupDisabled(i3);
        }
        w(true);
    }

    public void B(long j3, long j16, int i3) {
        ArrayList<TroopShortcutBarApp> appList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3));
            return;
        }
        TroopShortcutBarInfo m3 = m(Long.valueOf(j3));
        if (m3 == null || (appList = m3.getAppList()) == null) {
            return;
        }
        for (TroopShortcutBarApp troopShortcutBarApp : appList) {
            if (troopShortcutBarApp.getAppId() == j16) {
                troopShortcutBarApp.setAppidUnReadNum(i3);
                return;
            }
        }
    }

    public void C(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, j3);
            return;
        }
        TroopShortcutBarInfo troopShortcutBarInfo = this.f298596e.get(Long.valueOf(j3));
        if (troopShortcutBarInfo != null) {
            troopShortcutBarInfo.setCacheTSMil(0);
            troopShortcutBarInfo.setRedPointCacheTsMil(0);
            troopShortcutBarInfo.setNextFetchRedPointTsMil(0L);
        }
    }

    public void c(Long l3, TroopShortcutBarInfo troopShortcutBarInfo, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, l3, troopShortcutBarInfo, Boolean.valueOf(z16), obj);
            return;
        }
        if (troopShortcutBarInfo != null && l3 != null) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopShortcutBarManager", 2, "addTroopInfoToAIOCache. troopCode:" + l3 + ", troopShortcutBarInfo:" + troopShortcutBarInfo);
            }
            TroopShortcutBarInfo troopShortcutBarInfo2 = this.f298596e.get(l3);
            if (troopShortcutBarInfo2 != null && !z16) {
                troopShortcutBarInfo.setNextFetchRedPointTsMil(troopShortcutBarInfo2.getNextFetchRedPointTsMil());
                ArrayList<TroopShortcutBarApp> appList = troopShortcutBarInfo2.getAppList();
                Iterator<TroopShortcutBarApp> it = troopShortcutBarInfo.getAppList().iterator();
                while (it.hasNext()) {
                    TroopShortcutBarApp next = it.next();
                    Iterator<TroopShortcutBarApp> it5 = appList.iterator();
                    while (true) {
                        if (it5.hasNext()) {
                            TroopShortcutBarApp next2 = it5.next();
                            if (next.getAppId() == next2.getAppId()) {
                                next.setAppidUnReadNum(next2.getAppIdUnreadNum());
                                break;
                            }
                        }
                    }
                    d(next, obj);
                }
            } else {
                troopShortcutBarInfo.setNextFetchRedPointTsMil(System.currentTimeMillis() + troopShortcutBarInfo.getRedPointCacheTsMil());
            }
            this.f298596e.put(l3, troopShortcutBarInfo);
            t(l3.longValue());
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("TroopShortcutBarManager", 2, "addTroopInfoToAIOCache. troopCode:" + l3 + "is null");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004e, code lost:
    
        if (com.tencent.mobileqq.troop.utils.TroopUtils.B(r4, r8, r4.getCurrentUin()) != false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            long parseLong = Long.parseLong(str);
            if (l(parseLong) != 0) {
                com.tencent.mobileqq.troop.troopapps.api.a aVar = (com.tencent.mobileqq.troop.troopapps.api.a) this.f298595d.getBusinessHandler(BusinessHandlerFactory.TROOP_APP_HANDLER);
                if (aVar != null) {
                    ITroopUtilsApi iTroopUtilsApi = (ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class);
                    QQAppInterface qQAppInterface = this.f298595d;
                    if (!iTroopUtilsApi.isTroopAdmin(qQAppInterface, str, qQAppInterface.getCurrentUin())) {
                        QQAppInterface qQAppInterface2 = this.f298595d;
                    }
                    aVar.Z1(parseLong);
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopShortcutBarManager", 2, "reqGetAddTroopAppRemindInfo troopUin\uff1a" + parseLong);
                    }
                }
                ((qt2.a) this.f298595d.getBusinessHandler(BusinessHandlerFactory.TROOP_RED_DOT_HANDLER)).v2(str, 101896870);
                v(parseLong, 0);
            }
        } catch (Exception unused) {
            QLog.e("TroopShortcutBarManager", 1, "getAddTroopAppRemindInfo parseLong troopUin exception");
        }
    }

    public TroopShortcutBarInfo f(Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (TroopShortcutBarInfo) iPatchRedirector.redirect((short) 7, (Object) this, (Object) l3);
        }
        MMKVOptionEntity k3 = k();
        if (k3 == null) {
            return null;
        }
        byte[] decodeBytes = k3.decodeBytes("troop_shortcut_bar_new-" + l3, null);
        if (decodeBytes == null) {
            return null;
        }
        return (TroopShortcutBarInfo) g.c(decodeBytes);
    }

    public long g(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, (Object) this, j3)).longValue();
        }
        String valueOf = String.valueOf(j3);
        if (this.f298597f.containsKey(valueOf)) {
            return this.f298597f.get(valueOf).longValue();
        }
        long h16 = h(j3);
        this.f298597f.put(valueOf, Long.valueOf(h16));
        return h16;
    }

    public long h(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this, j3)).longValue();
        }
        String valueOf = String.valueOf(j3);
        MMKVOptionEntity k3 = k();
        if (k3 == null) {
            return 0L;
        }
        return k3.decodeLong(valueOf, 0L);
    }

    public long i(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Long) iPatchRedirector.redirect((short) 23, (Object) this, (Object) str)).longValue();
        }
        MMKVOptionEntity k3 = k();
        if (TextUtils.isEmpty(str) || k3 == null) {
            return 0L;
        }
        return k3.decodeLong(str + "_last_remind_graytip_uniseq", 0L);
    }

    public long j(long j3) {
        ArrayList<TroopShortcutBarApp> appList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Long) iPatchRedirector.redirect((short) 16, (Object) this, j3)).longValue();
        }
        TroopShortcutBarInfo troopShortcutBarInfo = this.f298596e.get(Long.valueOf(j3));
        if (troopShortcutBarInfo == null || troopShortcutBarInfo.getDisabled() == 1 || troopShortcutBarInfo.getGroupDisabled() == 1 || (appList = troopShortcutBarInfo.getAppList()) == null) {
            return 0L;
        }
        long g16 = g(j3);
        Iterator<TroopShortcutBarApp> it = appList.iterator();
        while (it.hasNext()) {
            TroopShortcutBarApp next = it.next();
            if (next != null) {
                long j16 = next.getaddts();
                if (j16 > g16) {
                    g16 = j16;
                }
            }
        }
        return g16;
    }

    public int l(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this, j3)).intValue();
        }
        if (this.f298600m.containsKey(Long.valueOf(j3))) {
            return this.f298600m.get(Long.valueOf(j3)).intValue();
        }
        return 0;
    }

    public TroopShortcutBarInfo m(Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TroopShortcutBarInfo) iPatchRedirector.redirect((short) 3, (Object) this, (Object) l3);
        }
        if (l3 == null) {
            return null;
        }
        return this.f298596e.get(l3);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        x();
        com.tencent.mobileqq.troop.troopapps.api.b bVar = this.C;
        if (bVar != null) {
            this.f298595d.removeObserver(bVar);
        }
        this.f298600m.clear();
    }

    public boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        return this.f298598h;
    }

    public void r(Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) l3);
            return;
        }
        MMKVOptionEntity k3 = k();
        if (k3 == null) {
            return;
        }
        k3.removeKey("troop_shortcut_bar_new-" + l3);
        if (QLog.isColorLevel()) {
            QLog.d("TroopShortcutBarManager", 2, "removeCacheInfoFromMMKV. troopCode:" + l3);
        }
    }

    public void s(Long l3, TroopShortcutBarInfo troopShortcutBarInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) l3, (Object) troopShortcutBarInfo);
            return;
        }
        ThreadManagerV2.excute(new Runnable(l3, troopShortcutBarInfo) { // from class: com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarManager.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Long f298601d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ TroopShortcutBarInfo f298602e;

            {
                this.f298601d = l3;
                this.f298602e = troopShortcutBarInfo;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, TroopShortcutBarManager.this, l3, troopShortcutBarInfo);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    MMKVOptionEntity k3 = TroopShortcutBarManager.this.k();
                    if (k3 == null) {
                        return;
                    }
                    k3.encodeBytes("troop_shortcut_bar_new-" + this.f298601d, g.h(this.f298602e));
                    return;
                }
                iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        }, 16, null, true);
        if (QLog.isColorLevel()) {
            QLog.d("TroopShortcutBarManager", 2, "saveCacheInfoToMMKV. troopCode:" + l3 + ", troopShortcutBarInfo:" + troopShortcutBarInfo);
        }
    }

    public void t(long j3) {
        ArrayList<TroopShortcutBarApp> appList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, j3);
            return;
        }
        TroopShortcutBarInfo troopShortcutBarInfo = this.f298596e.get(Long.valueOf(j3));
        if (troopShortcutBarInfo == null || troopShortcutBarInfo.getDisabled() == 1 || troopShortcutBarInfo.getGroupDisabled() == 1 || (appList = troopShortcutBarInfo.getAppList()) == null) {
            return;
        }
        if (g(j3) == 0) {
            long j16 = j(j3);
            if (j16 > g(j3)) {
                y(j3, j16);
                return;
            }
            return;
        }
        long max = Math.max(g(j3), troopShortcutBarInfo.getSwitch_ts());
        Iterator<TroopShortcutBarApp> it = appList.iterator();
        while (it.hasNext()) {
            TroopShortcutBarApp next = it.next();
            if (next != null) {
                if (next.getaddts() > max) {
                    next.setAddPoint(true);
                } else {
                    next.setAddPoint(false);
                }
            }
        }
    }

    public void u(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, str, Long.valueOf(j3));
            return;
        }
        MMKVOptionEntity k3 = k();
        if (!TextUtils.isEmpty(str) && k3 != null) {
            k3.encodeLong(str + "_last_remind_graytip_uniseq", j3);
        }
    }

    public void v(long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Long.valueOf(j3), Integer.valueOf(i3));
        } else {
            this.f298600m.put(Long.valueOf(j3), Integer.valueOf(i3));
        }
    }

    public void w(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
        } else {
            this.f298598h = z16;
        }
    }

    public void y(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Long.valueOf(j3), Long.valueOf(j16));
        } else {
            this.f298597f.put(String.valueOf(j3), Long.valueOf(j16));
            ThreadManagerV2.postImmediately(new Runnable(j3, j16) { // from class: com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarManager.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ long f298603d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ long f298604e;

                {
                    this.f298603d = j3;
                    this.f298604e = j16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TroopShortcutBarManager.this, Long.valueOf(j3), Long.valueOf(j16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    String valueOf = String.valueOf(this.f298603d);
                    if (TextUtils.isEmpty(valueOf)) {
                        return;
                    }
                    TroopShortcutBarManager.this.z(valueOf, this.f298604e);
                }
            }, null, false);
        }
    }

    public void z(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, Long.valueOf(j3));
            return;
        }
        MMKVOptionEntity k3 = k();
        if (!str.isEmpty() && k3 != null) {
            k3.encodeLong(str, j3);
        }
    }
}
