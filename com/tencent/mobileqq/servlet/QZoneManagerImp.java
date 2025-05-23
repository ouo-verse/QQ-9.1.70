package com.tencent.mobileqq.servlet;

import NS_GROUP_COUNT.mobile_group_count_rsp;
import NS_UNDEAL_COUNT.entrance_cfg;
import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.profilecommon.processor.QZoneSwitchProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.qzone.QZoneTitleTabManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneReq;
import com.tencent.qzonehub.api.report.IQzoneExceptionReport;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import cooperation.qzone.UploadEnv;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.QZoneLogTags;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QZoneManagerImp implements com.tencent.mobileqq.model.c {
    static IPatchRedirector $redirector_;
    private static boolean L;
    public ArrayList<entrance_cfg> C;
    private HashMap<String, Long> D;
    public HashMap<String, a> E;
    private long F;
    private volatile Boolean G;
    private ContentObserver H;
    private final boolean I;
    private NetworkState.NetworkStateListener J;
    private int K;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f286439d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f286440e;

    /* renamed from: f, reason: collision with root package name */
    public ConcurrentHashMap<Integer, QZoneCountInfo> f286441f;

    /* renamed from: h, reason: collision with root package name */
    private int f286442h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f286443i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f286444m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f286451a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList<String> f286452b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f286453c;

        /* renamed from: d, reason: collision with root package name */
        public long f286454d;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75047);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 26)) {
            redirector.redirect((short) 26);
        } else {
            L = true;
        }
    }

    public QZoneManagerImp(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        Handler handler = null;
        this.f286441f = null;
        this.f286442h = 1;
        this.f286443i = true;
        this.f286444m = false;
        this.C = new ArrayList<>();
        this.D = new HashMap<>();
        this.E = new HashMap<>();
        this.F = 0L;
        this.G = null;
        this.I = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_UPDATE_CONFIG_IF_IPSTACK_CHANGED, true);
        this.K = 0;
        this.f286439d = qQAppInterface;
        if (this.H == null) {
            this.H = new ContentObserver(handler) { // from class: com.tencent.mobileqq.servlet.QZoneManagerImp.1
                static IPatchRedirector $redirector_;

                {
                    super(handler);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QZoneManagerImp.this, (Object) handler);
                    }
                }

                @Override // android.database.ContentObserver
                public void onChange(boolean z16) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, z16);
                    } else {
                        super.onChange(z16);
                        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.servlet.QZoneManagerImp.1.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                    long j3 = QZoneManagerImp.this.F;
                                    QZoneManagerImp.this.o();
                                    QZoneManagerImp qZoneManagerImp = QZoneManagerImp.this;
                                    qZoneManagerImp.F = qZoneManagerImp.i();
                                    QZoneManagerImp qZoneManagerImp2 = QZoneManagerImp.this;
                                    qZoneManagerImp2.p(j3 | qZoneManagerImp2.F);
                                    if (QLog.isColorLevel()) {
                                        QLog.d("UndealCount.QZoneManagerImp.", 2, "onChange notifyQQTab type:" + Long.toBinaryString(QZoneManagerImp.this.F));
                                        return;
                                    }
                                    return;
                                }
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            }
                        }, 8, null, true);
                    }
                }
            };
        }
        try {
            if (!this.f286440e) {
                qQAppInterface.getApplication().getContentResolver().registerContentObserver(com.tencent.common.config.provider.d.E3, true, this.H);
            }
        } catch (Exception e16) {
            m(e16);
        }
        ThreadManagerV2.post(new Runnable(qQAppInterface) { // from class: com.tencent.mobileqq.servlet.QZoneManagerImp.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ QQAppInterface f286447d;

            {
                this.f286447d = qQAppInterface;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QZoneManagerImp.this, (Object) qQAppInterface);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                boolean z16 = true;
                int int4Uin = LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 1, this.f286447d.getLongAccountUin());
                QZoneManagerImp qZoneManagerImp = QZoneManagerImp.this;
                if ((int4Uin & 128) == 0) {
                    z16 = false;
                }
                qZoneManagerImp.B1(z16);
                QZoneTitleTabManager.d(this.f286447d.getCurrentAccountUin());
                QZoneManagerImp.this.o();
                QZoneManagerImp qZoneManagerImp2 = QZoneManagerImp.this;
                qZoneManagerImp2.F = qZoneManagerImp2.i();
                if (QLog.isColorLevel()) {
                    QLog.d("UndealCount.QZoneManagerImp.", 2, "QZoneManagerImp init notifyQQTab type:" + Long.toBinaryString(QZoneManagerImp.this.F));
                }
            }
        }, 8, null, true);
        r();
    }

    private boolean g(QQAppInterface qQAppInterface) {
        if (qQAppInterface == null || QZoneSwitchProcessor.a(qQAppInterface.getAccount()) <= 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long i() {
        ConcurrentHashMap<Integer, QZoneCountInfo> concurrentHashMap = this.f286441f;
        long j3 = 0;
        if (concurrentHashMap != null) {
            Iterator<Integer> it = concurrentHashMap.keySet().iterator();
            while (it.hasNext()) {
                j3 |= 1 << it.next().intValue();
            }
        }
        return j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(boolean z16) {
        int ipStack = UploadEnv.getIpStack(1);
        if (ipStack != 0 && this.K != ipStack) {
            q();
            if (QLog.isColorLevel()) {
                QLog.d("IPConfigStrategy", 1, "ipStack changed pull config,process:", Integer.valueOf(MobileQQ.sProcessId), ",old stack:", Integer.valueOf(this.K), ",new stack:", Integer.valueOf(ipStack));
            }
            this.K = ipStack;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.f286441f == null) {
            this.f286441f = new ConcurrentHashMap<>();
        }
        this.f286441f.clear();
        Cursor cursor = null;
        try {
            try {
                cursor = ContactsMonitor.query(this.f286439d.getApplication().getContentResolver(), com.tencent.common.config.provider.d.E3, null, "own_uin=?", new String[]{this.f286439d.getCurrentAccountUin()}, null);
                HashMap<Integer, QZoneCountInfo> createFromCursor = QZoneCountInfo.createFromCursor(cursor);
                if (createFromCursor != null) {
                    this.f286441f.putAll(createFromCursor);
                }
                if (cursor == null || cursor.isClosed()) {
                    return;
                }
            } catch (Exception e16) {
                m(e16);
                if (cursor == null || cursor.isClosed()) {
                    return;
                }
            }
            cursor.close();
        } catch (Throwable th5) {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            throw th5;
        }
    }

    private void q() {
        if (this.f286439d == null) {
            return;
        }
        NewIntent newIntent = new NewIntent(this.f286439d.getApplication(), QZoneNotifyServlet.class);
        newIntent.setAction("Qzone_Get_NewAndUnread_Count");
        newIntent.putExtra("qzone_send_by_time", 6);
        newIntent.putExtra("scene", 100);
        this.f286439d.startServlet(newIntent);
    }

    private void r() {
        if (MobileQQ.sProcessId == 1 && this.I && this.J == null) {
            NetworkState.NetworkStateListener networkStateListener = new NetworkState.NetworkStateListener() { // from class: com.tencent.mobileqq.servlet.l
                @Override // cooperation.qzone.util.NetworkState.NetworkStateListener
                public final void onNetworkConnect(boolean z16) {
                    QZoneManagerImp.this.n(z16);
                }
            };
            this.J = networkStateListener;
            NetworkState.addListener(networkStateListener);
        }
    }

    private void t(int i3, QZoneCountInfo qZoneCountInfo) {
        if (qZoneCountInfo != null && this.f286439d != null) {
            ThreadManagerV2.post(new Runnable(new QZoneCountInfo(qZoneCountInfo), i3) { // from class: com.tencent.mobileqq.servlet.QZoneManagerImp.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ QZoneCountInfo f286448d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f286449e;

                {
                    this.f286448d = r6;
                    this.f286449e = i3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, QZoneManagerImp.this, r6, Integer.valueOf(i3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (QZoneManagerImp.this.f286439d == null) {
                        return;
                    }
                    ContentValues convertToContentValues = this.f286448d.convertToContentValues();
                    convertToContentValues.put("own_uin", QZoneManagerImp.this.f286439d.getAccount());
                    convertToContentValues.put("type", Integer.valueOf(this.f286449e));
                    try {
                        QZoneManagerImp.this.f286439d.getApplication().getContentResolver().insert(com.tencent.common.config.provider.d.E3, convertToContentValues);
                    } catch (Exception e16) {
                        QZoneManagerImp.this.m(e16);
                    }
                }
            }, 5, null, false);
        }
    }

    private void u() {
        String account;
        try {
            ConcurrentHashMap<Integer, QZoneCountInfo> concurrentHashMap = this.f286441f;
            if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
                QZoneCountInfo[] qZoneCountInfoArr = (QZoneCountInfo[]) this.f286441f.values().toArray(new QZoneCountInfo[this.f286441f.size()]);
                Integer[] numArr = (Integer[]) this.f286441f.keySet().toArray(new Integer[this.f286441f.size()]);
                ContentValues[] contentValuesArr = new ContentValues[qZoneCountInfoArr.length];
                for (int i3 = 0; i3 < qZoneCountInfoArr.length; i3++) {
                    QQAppInterface qQAppInterface = this.f286439d;
                    if (qQAppInterface != null && (account = qQAppInterface.getAccount()) != null && account.length() > 0) {
                        ContentValues convertToContentValues = qZoneCountInfoArr[i3].convertToContentValues();
                        contentValuesArr[i3] = convertToContentValues;
                        convertToContentValues.put("own_uin", account);
                        contentValuesArr[i3].put("type", numArr[i3]);
                    }
                }
                QQAppInterface qQAppInterface2 = this.f286439d;
                if (qQAppInterface2 == null) {
                    return;
                }
                qQAppInterface2.getApplication().getContentResolver().bulkInsert(com.tencent.common.config.provider.d.E3, contentValuesArr);
            }
        } catch (Exception e16) {
            m(e16);
        }
    }

    @Override // com.tencent.mobileqq.model.c
    public void B1(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, z16);
        } else {
            this.G = Boolean.valueOf(z16);
        }
    }

    @Override // com.tencent.mobileqq.model.c
    public boolean N1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return this.f286443i;
    }

    @Override // com.tencent.mobileqq.model.c
    public void Q0(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QZoneManagerImp.", 2, "setEnterQZone.isenter=" + z16);
        }
        this.f286444m = z16;
    }

    @Override // com.tencent.mobileqq.model.c
    public boolean U1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        if (this.G == null) {
            boolean z16 = true;
            if ((LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 1, this.f286439d.getLongAccountUin()) & 128) == 0) {
                z16 = false;
            }
            B1(z16);
        }
        return this.G.booleanValue();
    }

    @Override // com.tencent.mobileqq.model.c
    public void Z(int i3) {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
            return;
        }
        if (!this.f286443i && i3 > 0 && (qQAppInterface = this.f286439d) != null && qQAppInterface.getApplication() != null) {
            if (QLog.isColorLevel()) {
                QLog.d("QZoneManagerImp..UndealCount", 2, "sendGetFeedByTime. by servlet. type:" + i3);
            }
            if (i3 == 2) {
                try {
                    NewIntent newIntent = new NewIntent(this.f286439d.getApplication(), QZoneNotifyServlet.class);
                    newIntent.setAction("Qzone_Get_NewAndUnread_Count");
                    newIntent.putExtra("qzone_send_by_time", i3);
                    newIntent.putExtra("scene", 103);
                    this.f286439d.startServlet(newIntent);
                    if (QLog.isColorLevel()) {
                        QLog.i("QZoneManagerImp..UndealCount", 2, "sendGetFeedByTime.switch to forground.");
                        return;
                    }
                    return;
                } catch (Exception e16) {
                    e16.printStackTrace();
                    return;
                }
            }
            if (i3 == 3) {
                ThreadManagerV2.post(new Runnable(i3) { // from class: com.tencent.mobileqq.servlet.QZoneManagerImp.4
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ int f286450d;

                    {
                        this.f286450d = i3;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QZoneManagerImp.this, i3);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        QQAppInterface qQAppInterface2;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        if (QLog.isColorLevel()) {
                            QLog.d("QZoneManagerImp..UndealCount", 2, "sendGetFeedByTime.click leba.nowtime: " + currentTimeMillis + ",QZoneNotifyServlet.lastGetFeedTime: " + QZoneNotifyServlet.C + ",config interval:" + QZoneHelper.getUpdateCountIntervalWhenClickFeedTab() + "difference: " + (currentTimeMillis - QZoneNotifyServlet.C));
                        }
                        if (currentTimeMillis - QZoneNotifyServlet.C > QZoneHelper.getUpdateCountIntervalWhenClickFeedTab() && (qQAppInterface2 = QZoneManagerImp.this.f286439d) != null && qQAppInterface2.getApplication() != null) {
                            NewIntent newIntent2 = new NewIntent(qQAppInterface2.getApplication(), QZoneNotifyServlet.class);
                            newIntent2.setAction("Qzone_Get_NewAndUnread_Count");
                            newIntent2.putExtra("qzone_send_by_time", this.f286450d);
                            newIntent2.putExtra("scene", 103);
                            qQAppInterface2.startServlet(newIntent2);
                            if (QLog.isColorLevel()) {
                                QLog.d("QZoneManagerImp..UndealCount", 2, "sendGetFeedByTime.click leba.");
                            }
                        }
                    }
                }, 8, null, true);
                return;
            }
            if (i3 == 5 || i3 == 6 || i3 == 7 || i3 == 8) {
                NewIntent newIntent2 = new NewIntent(this.f286439d.getApplication(), QZoneNotifyServlet.class);
                newIntent2.setAction("Qzone_Get_NewAndUnread_Count");
                newIntent2.putExtra("qzone_send_by_time", i3);
                if (i3 != 5 && i3 != 6) {
                    if (i3 == 7 || i3 == 8) {
                        newIntent2.putExtra("scene", 104);
                    }
                } else {
                    newIntent2.putExtra("scene", 100);
                }
                this.f286439d.startServlet(newIntent2);
            }
        }
    }

    @Override // com.tencent.mobileqq.model.c
    @TargetApi(9)
    public void b1(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
            return;
        }
        QQAppInterface qQAppInterface = this.f286439d;
        if (qQAppInterface == null) {
            return;
        }
        SharedPreferences.Editor edit = qQAppInterface.getApp().getSharedPreferences("Qzone_Get_UndealCount_FLAG", 0).edit();
        String account = this.f286439d.getAccount();
        if (account != null && account.length() > 0) {
            edit.putInt(account, i3);
        }
        edit.apply();
        if (QLog.isColorLevel()) {
            QLog.d("QZoneManagerImp.", 2, "setGetUndealCountFlag:" + i3);
        }
    }

    public void h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("QZoneManagerImp.", 4, "QZoneManagerImp clearUnReadCount cache arrays.type = " + i3);
        }
        ConcurrentHashMap<Integer, QZoneCountInfo> concurrentHashMap = this.f286441f;
        if (concurrentHashMap != null) {
            concurrentHashMap.remove(Integer.valueOf(i3));
        }
        try {
            py3.b.e(this.f286439d.getApplication().getContentResolver(), com.tencent.common.config.provider.d.E3, "own_uin=? AND type=?", new String[]{this.f286439d.getCurrentAccountUin(), String.valueOf(i3)});
        } catch (Exception e16) {
            m(e16);
        }
    }

    public int j(int i3) {
        QZoneCountInfo qZoneCountInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, i3)).intValue();
        }
        ConcurrentHashMap<Integer, QZoneCountInfo> concurrentHashMap = this.f286441f;
        if (concurrentHashMap != null && (qZoneCountInfo = concurrentHashMap.get(Integer.valueOf(i3))) != null) {
            int i16 = (int) qZoneCountInfo.uCount;
            QLog.d("QZoneManagerImp.", 2, "QZoneManagerImp getFeedCount type :" + i3 + ", unReadCount : " + i16);
            return i16;
        }
        return 0;
    }

    public QZoneCountInfo k(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (QZoneCountInfo) iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        ConcurrentHashMap<Integer, QZoneCountInfo> concurrentHashMap = this.f286441f;
        if (concurrentHashMap != null) {
            QZoneCountInfo qZoneCountInfo = concurrentHashMap.get(Integer.valueOf(i3));
            if (qZoneCountInfo != null) {
                QLog.d("QZoneManagerImp.", 2, "QZoneManagerImp getFeedCount type :" + i3);
            }
            return qZoneCountInfo;
        }
        return null;
    }

    public ArrayList<String> l() {
        QZoneCountInfo qZoneCountInfo;
        ArrayList<QZoneCountUserInfo> arrayList;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (ArrayList) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        ArrayList<String> arrayList2 = new ArrayList<>();
        ConcurrentHashMap<Integer, QZoneCountInfo> concurrentHashMap = this.f286441f;
        if (concurrentHashMap != null && (qZoneCountInfo = concurrentHashMap.get(2)) != null && (arrayList = qZoneCountInfo.friendList) != null && arrayList.size() > 0) {
            Iterator<QZoneCountUserInfo> it = qZoneCountInfo.friendList.iterator();
            while (it.hasNext()) {
                QZoneCountUserInfo next = it.next();
                if (next != null) {
                    long j3 = next.uin;
                    if (j3 >= 10000) {
                        arrayList2.add(String.valueOf(j3));
                    }
                }
                if (next == null) {
                    str = "userInfo==null";
                } else {
                    str = "userInfo,uin<10000,\u4e0d\u662f\u5408\u6cd5qq\u53f7";
                }
                QLog.w("UndealCount.QZoneManagerImp.", 1, str);
            }
        }
        return arrayList2;
    }

    public void m(Exception exc) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) exc);
            return;
        }
        if (this.f286439d == null) {
            QZLog.e("QZoneManagerImp.", "handleException app == null");
            return;
        }
        if (exc instanceof IllegalArgumentException) {
            if (exc.getMessage() != null && exc.getMessage().contains("Unknown URI")) {
                str = "0";
            } else {
                str = "1";
            }
        } else {
            str = "2";
        }
        QLog.e("QZoneManagerImp.", 1, exc, new Object[0]);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("exception", exc.getClass().getSimpleName());
        hashMap.put("type", str);
        hashMap.put("msg", exc.getMessage());
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f286439d.getAccount(), StatisticCollector.QZONE_CONFIGDB_ERROR, true, 0L, 0L, hashMap, (String) null, true);
        ((IQzoneExceptionReport) QRoute.api(IQzoneExceptionReport.class)).doReport(exc, "QZoneConfigProvider error");
    }

    @Override // com.tencent.mobileqq.model.c
    public void o0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else {
            if (this.f286439d == null) {
                return;
            }
            IQzoneReq iQzoneReq = (IQzoneReq) QRoute.api(IQzoneReq.class);
            QQAppInterface qQAppInterface = this.f286439d;
            iQzoneReq.sentOnlineServlet(qQAppInterface, qQAppInterface.getAccount(), d.m(this.f286439d));
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        this.f286440e = true;
        if (this.H != null) {
            this.f286439d.getApplication().getContentResolver().unregisterContentObserver(this.H);
            this.H = null;
        }
        NetworkState.NetworkStateListener networkStateListener = this.J;
        if (networkStateListener != null) {
            NetworkState.removeListener(networkStateListener);
            this.J = null;
        }
        ConcurrentHashMap<Integer, QZoneCountInfo> concurrentHashMap = this.f286441f;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
        this.f286439d = null;
        this.f286440e = false;
    }

    public void p(long j3) {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, j3);
            return;
        }
        if (this.f286439d == null) {
            return;
        }
        try {
            NewIntent newIntent = new NewIntent(this.f286439d.getApplication(), QZoneNotifyServlet.class);
            newIntent.setAction("Qzone_Refresh_UI");
            newIntent.putExtra("notify_type", j3);
            if (!this.f286440e && (qQAppInterface = this.f286439d) != null) {
                qQAppInterface.startServlet(newIntent);
            }
        } catch (Throwable th5) {
            QLog.e("QZoneManagerImp.", 1, "", th5);
        }
    }

    @Override // com.tencent.mobileqq.model.c
    public int q3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        QQAppInterface qQAppInterface = this.f286439d;
        int i3 = 0;
        if (qQAppInterface == null) {
            return 0;
        }
        SharedPreferences sharedPreferences = qQAppInterface.getApp().getSharedPreferences("Qzone_Get_UndealCount_FLAG", 0);
        String account = this.f286439d.getAccount();
        if (account != null && account.length() > 0) {
            i3 = sharedPreferences.getInt(account, 0);
        }
        if (QLog.isColorLevel()) {
            QLog.d("QZoneManagerImp.", 2, "getGetUndealCountFlag:" + i3);
        }
        return i3;
    }

    @Override // com.tencent.mobileqq.model.c
    public void r4(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (this.f286439d == null) {
            return;
        }
        if (this.f286442h != 0) {
            NewIntent newIntent = new NewIntent(this.f286439d.getApplication(), QZoneNotifyServlet.class);
            newIntent.setAction("Qzone_Get_NewAndUnread_Count");
            newIntent.putExtra("qzone_send_by_time", 1);
            newIntent.putExtra("scene", 100);
            this.f286439d.startServlet(newIntent);
        }
        if (QLog.isColorLevel()) {
            QLog.d("QZoneManagerImp.", 2, "sendGetFeedCount");
        }
        this.f286443i = false;
    }

    public boolean s(int i3, QZoneCountInfo qZoneCountInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, i3, (Object) qZoneCountInfo)).booleanValue();
        }
        boolean z16 = false;
        if (qZoneCountInfo == null) {
            QZLog.e("QZoneManagerImp.", "saveCountInfoInMemIfChanged qZoneCountInfo == null");
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QZoneManagerImp.", 2, "setFeedCountAll.feedtype=" + i3 + ",count=" + qZoneCountInfo.uCount + ",uin");
        }
        if (i3 >= 1 && i3 < 1029) {
            if (this.f286441f == null) {
                this.f286441f = new ConcurrentHashMap<>();
            }
            z16 = !qZoneCountInfo.equals(this.f286441f.get(Integer.valueOf(i3)));
            if (z16) {
                this.f286441f.put(Integer.valueOf(i3), qZoneCountInfo);
            }
        }
        return z16;
    }

    public void v(HashMap<Integer, QZoneCountInfo> hashMap, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, hashMap, Boolean.valueOf(z16));
            return;
        }
        try {
            if (this.f286444m) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("ZebraAlbum.QZoneManagerImp.", 4, "setFeedCount.user enter qzone.dismiss data.");
                    return;
                }
                return;
            }
            if (hashMap == null || hashMap.size() == 0 || this.f286439d == null) {
                return;
            }
            Object[] array = hashMap.entrySet().toArray();
            if (array != null) {
                boolean z18 = false;
                for (Object obj : array) {
                    if (obj != null && (obj instanceof Map.Entry)) {
                        Map.Entry entry = (Map.Entry) obj;
                        Integer num = (Integer) entry.getKey();
                        QZoneCountInfo qZoneCountInfo = (QZoneCountInfo) entry.getValue();
                        if (!g(this.f286439d)) {
                            if (QLog.isColorLevel()) {
                                QLog.d(QZoneLogTags.LOG_TAG_FEEDALERT, 2, "QZoneManagerImp.checkShowQZonePush" + Long.toBinaryString(this.F) + ",count" + qZoneCountInfo.uCount);
                            }
                            if (num.intValue() == 17) {
                            }
                        }
                        boolean s16 = s(num.intValue(), qZoneCountInfo);
                        if (s16 && QLog.isColorLevel()) {
                            QLog.d(QZoneLogTags.LOG_TAG_FEEDALERT, 2, "QZoneManagerImp.set feedcout map type:" + Long.toBinaryString(this.F) + "count change ,key=" + num);
                        }
                        if (!z18 && !s16) {
                            z18 = false;
                        }
                        z18 = true;
                    }
                }
                z17 = z18;
            }
            if (z17 || z16) {
                u();
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("QZoneManagerImp.", 2, e16.toString());
            }
        }
    }

    public boolean w(int i3, long j3, ArrayList<QZoneCountUserInfo> arrayList, String str, boolean z16, boolean z17, String str2) {
        ArrayList<QZoneCountUserInfo> arrayList2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Long.valueOf(j3), arrayList, str, Boolean.valueOf(z16), Boolean.valueOf(z17), str2)).booleanValue();
        }
        QLog.i("QZoneManagerImp.", 1, "qzone redtypeinfo:setFeedCount.feedtype=" + i3 + ",count=" + j3 + ",uin");
        if (i3 < 1 || i3 >= 1029) {
            return false;
        }
        if (this.f286441f == null) {
            this.f286441f = new ConcurrentHashMap<>();
        }
        QZoneCountInfo qZoneCountInfo = new QZoneCountInfo();
        qZoneCountInfo.uCount = j3;
        qZoneCountInfo.friendList = arrayList;
        qZoneCountInfo.existDL = z16;
        qZoneCountInfo.pushMesssage = str;
        if (!TextUtils.isEmpty(str2)) {
            qZoneCountInfo.schema = str2;
        }
        QZoneCountInfo qZoneCountInfo2 = this.f286441f.get(Integer.valueOf(i3));
        boolean z18 = !qZoneCountInfo.equals(qZoneCountInfo2);
        if (z18) {
            if (j3 > 0 && qZoneCountInfo2 != null && qZoneCountInfo2.friendList != null && (arrayList2 = qZoneCountInfo.friendList) != null && arrayList2.size() > 0) {
                Iterator<QZoneCountUserInfo> it = qZoneCountInfo.friendList.iterator();
                while (it.hasNext()) {
                    QZoneCountUserInfo next = it.next();
                    int i16 = 0;
                    while (i16 < qZoneCountInfo2.friendList.size() && qZoneCountInfo2.friendList.get(i16).uin != next.uin) {
                        i16++;
                    }
                    if (i16 != -1 && i16 < qZoneCountInfo2.friendList.size()) {
                        qZoneCountInfo2.friendList.remove(i16);
                    }
                }
                qZoneCountInfo.friendList.addAll(qZoneCountInfo2.friendList);
            }
            this.f286441f.put(Integer.valueOf(i3), qZoneCountInfo);
            t(i3, qZoneCountInfo);
        }
        return z18;
    }

    public void x(int i3, int i16) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        try {
            j3 = Long.parseLong(this.f286439d.getAccount());
        } catch (Exception e16) {
            m(e16);
            j3 = 0;
        }
        if (j3 > 0) {
            LocalMultiProcConfig.putInt4Uin("mine_message_count", i16, j3);
        }
        if (QLog.isColorLevel()) {
            QLog.d("QZoneManagerImp.", 2, "setPushCount type:" + i3 + ",count" + i16);
        }
    }

    public void y(String str, mobile_group_count_rsp mobile_group_count_rspVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) str, (Object) mobile_group_count_rspVar);
            return;
        }
        a aVar = this.E.get(str);
        if (aVar == null) {
            aVar = new a();
            this.E.put(str, aVar);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<Long> it = mobile_group_count_rspVar.vecUinList.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(it.next()));
        }
        aVar.f286452b = arrayList;
        aVar.f286451a = mobile_group_count_rspVar.stCount;
        aVar.f286454d = mobile_group_count_rspVar.iNextTimeout;
        int i3 = mobile_group_count_rspVar.iShowRedPoint;
        boolean z16 = true;
        if (i3 != 1) {
            z16 = false;
        }
        aVar.f286453c = z16;
    }
}
