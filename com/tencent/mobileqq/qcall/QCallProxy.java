package com.tencent.mobileqq.qcall;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.imcore.message.an;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.BaseProxy;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.data.QCallRecord;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@KeepClassConstructor
/* loaded from: classes16.dex */
public class QCallProxy extends BaseProxy {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    private static volatile boolean f261535i;

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, List<QCallRecord>> f261536a;

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, Object> f261537b;

    /* renamed from: c, reason: collision with root package name */
    EntityManager f261538c;

    /* renamed from: d, reason: collision with root package name */
    private Object f261539d;

    /* renamed from: e, reason: collision with root package name */
    private int f261540e;

    /* renamed from: f, reason: collision with root package name */
    private final List<QCallRecent> f261541f;

    /* renamed from: g, reason: collision with root package name */
    private final Map<String, QCallRecent> f261542g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f261543h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class a implements Comparator<QCallRecord> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QCallProxy.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(QCallRecord qCallRecord, QCallRecord qCallRecord2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) qCallRecord, (Object) qCallRecord2)).intValue();
            }
            if (qCallRecord.type == QCallRecord.TYPE_DATE) {
                return 0;
            }
            return (int) (qCallRecord2.time - qCallRecord.time);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class b implements Comparator<QCallRecord> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QCallProxy.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(QCallRecord qCallRecord, QCallRecord qCallRecord2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) qCallRecord, (Object) qCallRecord2)).intValue();
            }
            return (int) (qCallRecord2.time - qCallRecord.time);
        }
    }

    /* loaded from: classes16.dex */
    public interface c {
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74386);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
        } else {
            f261535i = false;
        }
    }

    public QCallProxy(QQAppInterface qQAppInterface, BaseProxyManager baseProxyManager) {
        super(qQAppInterface, baseProxyManager);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) baseProxyManager);
            return;
        }
        this.f261536a = new ConcurrentHashMap<>();
        this.f261537b = new ConcurrentHashMap<>();
        this.f261538c = null;
        this.f261539d = new Object();
        this.f261540e = 20;
        this.f261541f = new ArrayList(20);
        this.f261542g = new HashMap();
    }

    private void F(QCallRecent qCallRecent, boolean z16) {
        String str;
        int i3;
        QCallRecent remove;
        if (qCallRecent != null && (str = qCallRecent.uin) != null && str.length() >= 2) {
            String str2 = qCallRecent.uin;
            if (str2 != null && str2.length() >= 2) {
                synchronized (this.f261541f) {
                    int i16 = qCallRecent.type;
                    boolean z17 = false;
                    if (i16 != 1 && i16 != 3000 && i16 != 8) {
                        ArrayList arrayList = new ArrayList();
                        for (int i17 : ao.f116570d) {
                            if (i17 != qCallRecent.type && (remove = this.f261542g.remove(u(qCallRecent.uin, i17))) != null) {
                                arrayList.add(remove);
                            }
                        }
                        int size = arrayList.size();
                        if (size > 0) {
                            if (qCallRecent.getStatus() == 1000) {
                                QCallRecent qCallRecent2 = (QCallRecent) arrayList.get(0);
                                this.f261541f.remove(qCallRecent2);
                                qCallRecent2.type = qCallRecent.type;
                                qCallRecent2.troopUin = qCallRecent.troopUin;
                                qCallRecent2.displayName = qCallRecent.displayName;
                                qCallRecent2.lastCallTime = qCallRecent.lastCallTime;
                                qCallRecent2.lastCallMsg = qCallRecent.lastCallMsg;
                                qCallRecent2.sendFlag = qCallRecent.sendFlag;
                                qCallRecent2.isVideo = qCallRecent.isVideo;
                                qCallRecent2.missedCallCount = qCallRecent.missedCallCount;
                                qCallRecent2.isLastCallRealMissed = qCallRecent.isLastCallRealMissed;
                                qCallRecent = qCallRecent2;
                                i3 = 1;
                            } else {
                                i3 = 0;
                            }
                            while (i3 < size) {
                                QCallRecent qCallRecent3 = (QCallRecent) arrayList.get(i3);
                                this.f261541f.remove(qCallRecent3);
                                D(qCallRecent3);
                                i3++;
                            }
                        }
                    }
                    Set<String> keySet = this.f261542g.keySet();
                    String[] strArr = new String[keySet.size()];
                    keySet.toArray(strArr);
                    if (QLog.isColorLevel()) {
                        QLog.d("QCallProxy", 2, "saveRecentCall before put:" + Arrays.toString(strArr));
                    }
                    this.f261542g.put(u(qCallRecent.uin, qCallRecent.type), qCallRecent);
                    Set<String> keySet2 = this.f261542g.keySet();
                    String[] strArr2 = new String[keySet2.size()];
                    keySet2.toArray(strArr2);
                    if (QLog.isColorLevel()) {
                        QLog.d("QCallProxy", 2, "saveRecentCall after put:" + Arrays.toString(strArr2));
                    }
                    this.f261541f.remove(qCallRecent);
                    int size2 = this.f261541f.size();
                    int i18 = 0;
                    while (true) {
                        if (i18 >= size2) {
                            break;
                        }
                        if (qCallRecent.lastCallTime > this.f261541f.get(i18).lastCallTime) {
                            this.f261541f.add(i18, qCallRecent);
                            z17 = true;
                            break;
                        }
                        i18++;
                    }
                    if (!z17) {
                        List<QCallRecent> list = this.f261541f;
                        list.add(list.size(), qCallRecent);
                    }
                }
                if (z16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QCallProxy", 2, "insertOrUpdateRecentCallToDB uin: " + qCallRecent.uin + ",callstatus:" + qCallRecent.state);
                    }
                    x(qCallRecent);
                    return;
                }
                return;
            }
            return;
        }
        Utils.Q("QCallProxy");
    }

    private boolean k(String str, int i3) {
        if (i3 != 3000 && i3 != 8) {
            ThreadManagerV2.excute(new Runnable(str) { // from class: com.tencent.mobileqq.qcall.QCallProxy.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f261544d;

                {
                    this.f261544d = str;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) QCallProxy.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        try {
                            Cursor v3 = QCallProxy.this.v(this.f261544d);
                            if (v3 != null) {
                                int columnIndex = v3.getColumnIndex("name");
                                while (v3.moveToNext()) {
                                    String encode = SecurityUtile.encode(v3.getString(columnIndex));
                                    int w3 = QCallProxy.this.w(encode);
                                    if (w3 != -1) {
                                        ((BaseProxy) QCallProxy.this).proxyManager.addMsgQueue(this.f261544d, w3, encode, null, null, 2, null);
                                    }
                                }
                                v3.close();
                                return;
                            }
                            return;
                        } catch (Throwable th5) {
                            QLog.i("QCallProxy", 1, "deleteAllRecordFromDB", th5);
                            return;
                        }
                    }
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }, 16, null, false);
            return true;
        }
        this.proxyManager.addMsgQueue(str, i3, QCallRecord.getTableName(str, i3), null, null, 2, null);
        return true;
    }

    private Object o(String str, int i3) {
        String r16 = r(str, i3);
        if (!this.f261537b.containsKey(r16)) {
            synchronized (this.f261537b) {
                if (!this.f261537b.containsKey(r16)) {
                    this.f261537b.put(r16, new Object());
                }
            }
        }
        return this.f261537b.get(r16);
    }

    private EntityManager p() {
        EntityManager entityManager = this.f261538c;
        if (entityManager == null || !entityManager.isOpen()) {
            synchronized (this.f261539d) {
                EntityManager entityManager2 = this.f261538c;
                if ((entityManager2 == null || !entityManager2.isOpen()) && this.app.getEntityManagerFactory() != null) {
                    this.f261538c = this.app.getEntityManagerFactory().createEntityManager();
                }
            }
        }
        return this.f261538c;
    }

    private ArrayList<QCallRecord> q(List<QCallRecord> list) {
        if (list == null) {
            return null;
        }
        Collections.sort(list, new a());
        SparseIntArray sparseIntArray = new SparseIntArray();
        ArrayList<QCallRecord> arrayList = new ArrayList<>();
        for (QCallRecord qCallRecord : list) {
            if (qCallRecord != null && qCallRecord.type != QCallRecord.TYPE_DATE) {
                if (sparseIntArray.get(qCallRecord.getDate(), -1) == -1) {
                    QCallRecord qCallRecord2 = new QCallRecord(QCallRecord.TYPE_DATE);
                    qCallRecord2.time = qCallRecord.time;
                    arrayList.add(qCallRecord2);
                    sparseIntArray.put(qCallRecord.getDate(), 0);
                }
                arrayList.add(qCallRecord);
            }
        }
        list.clear();
        return arrayList;
    }

    private String r(String str, int i3) {
        String str2;
        String currentAccountUin = ((QQAppInterface) this.app).getCurrentAccountUin();
        if (!TextUtils.isEmpty(currentAccountUin)) {
            str2 = currentAccountUin.concat("_").concat(str);
        } else {
            str2 = "";
        }
        if (i3 == 3000 || i3 == 8) {
            return str2.concat(String.valueOf(i3));
        }
        return str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00f1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<QCallRecord> t(String str, int i3) {
        List<QCallRecord> rawQuery;
        Cursor cursor;
        List list;
        Cursor cursor2;
        SQLiteDatabase writableDatabase = ((QQAppInterface) this.app).getWritableDatabase();
        if (writableDatabase == null) {
            return null;
        }
        if (i3 != 3000 && i3 != 8) {
            try {
                Cursor v3 = v(str);
                if (v3 != null) {
                    try {
                        try {
                            list = new ArrayList();
                            try {
                                int columnIndex = v3.getColumnIndex("name");
                                while (v3.moveToNext()) {
                                    String encode = SecurityUtile.encode(v3.getString(columnIndex));
                                    int count = writableDatabase.getCount(encode);
                                    if (count > 0) {
                                        int i16 = this.f261540e;
                                        if (count > i16) {
                                            writableDatabase.execSQL(String.format("delete from %s where time in (select time from %s order by time limit %s)", encode, encode, Integer.valueOf(count - i16)));
                                        }
                                        List<Entity> rawQuery2 = DBMethodProxy.rawQuery(p(), QCallRecord.class, "select * from " + encode + " order by time asc", null);
                                        if (rawQuery2 != null) {
                                            list.addAll(rawQuery2);
                                        }
                                        Collections.sort(list, new b());
                                    }
                                }
                                rawQuery = list;
                            } catch (Exception unused) {
                                cursor2 = v3;
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                rawQuery = list;
                                if (rawQuery != null) {
                                }
                                return rawQuery;
                            }
                        } catch (Exception unused2) {
                            cursor2 = v3;
                            list = null;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        cursor = v3;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } else {
                    rawQuery = null;
                }
                if (v3 != null) {
                    v3.close();
                }
            } catch (Exception unused3) {
                list = null;
                cursor2 = null;
            } catch (Throwable th6) {
                th = th6;
                cursor = null;
            }
        } else {
            String tableName = QCallRecord.getTableName(str, i3);
            int count2 = writableDatabase.getCount(tableName);
            int i17 = this.f261540e;
            if (count2 > i17) {
                writableDatabase.execSQL(String.format("delete from %s where time in (select time from %s order by time limit %s)", tableName, tableName, Integer.valueOf(count2 - i17)));
            }
            rawQuery = DBMethodProxy.rawQuery(p(), QCallRecord.class, "select * from " + tableName + " order by time asc", null);
        }
        if (rawQuery != null) {
            long K0 = com.tencent.mobileqq.service.message.e.K0();
            for (QCallRecord qCallRecord : rawQuery) {
                if (qCallRecord != null && qCallRecord.time > K0) {
                    qCallRecord.time = K0;
                }
            }
        }
        return rawQuery;
    }

    private String u(String str, int i3) {
        return str + ContainerUtils.FIELD_DELIMITER + i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Cursor v(String str) {
        String a16 = an.a(str);
        String str2 = "select name from sqlite_master where (type='table') and (name like 'qc/_%/_" + a16 + "' escape '/') and (name not like 'qc/_3000/_" + a16 + "' escape '/') and (name not like 'qc/_8/_" + a16 + "' escape '/') order by name;";
        try {
            SQLiteDatabase readableDatabase = ((QQAppInterface) this.app).getReadableDatabase();
            if (readableDatabase == null) {
                return null;
            }
            return readableDatabase.rawQuery(str2, null);
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.w("QCallProxy", 2, e16.getMessage(), e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int w(String str) {
        try {
            for (String str2 : str.split("[^0-9]")) {
                if (str2 != null && str2.length() > 0) {
                    return Integer.parseInt(str2);
                }
            }
            return -1;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return -1;
            }
            QLog.w("QCallProxy", 2, e16.getMessage(), e16);
            return -1;
        }
    }

    private boolean z(QCallRecord qCallRecord) {
        this.proxyManager.addMsgQueue(qCallRecord.friendUin, qCallRecord.uinType, qCallRecord.getTableName(), qCallRecord, 3, null);
        return true;
    }

    public List<QCallRecent> A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (List) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return B(null);
    }

    public List<QCallRecent> B(c cVar) {
        ArrayList arrayList;
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (List) iPatchRedirector.redirect((short) 16, (Object) this, (Object) cVar);
        }
        ThreadManagerV2.post(new Runnable(cVar) { // from class: com.tencent.mobileqq.qcall.QCallProxy.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QCallProxy.this, (Object) cVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                ArrayList arrayList2;
                IPhoneContactService iPhoneContactService;
                String str3;
                boolean z17;
                boolean z18;
                boolean z19;
                boolean z26;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                synchronized (QCallProxy.this.f261541f) {
                    ArrayList<QCallRecent> arrayList3 = new ArrayList();
                    ArrayList<QCallRecent> arrayList4 = new ArrayList();
                    ArrayList<QCallRecent> arrayList5 = new ArrayList();
                    ArrayList arrayList6 = new ArrayList();
                    IPhoneContactService iPhoneContactService2 = (IPhoneContactService) ((BaseProxy) QCallProxy.this).app.getRuntimeService(IPhoneContactService.class, "");
                    FriendsManager friendsManager = (FriendsManager) ((BaseProxy) QCallProxy.this).app.getManager(QQManagerFactory.FRIENDS_MANAGER);
                    if (iPhoneContactService2 != null && iPhoneContactService2.isBindContactOk() && friendsManager != null) {
                        boolean z27 = false;
                        for (QCallRecent qCallRecent : QCallProxy.this.f261541f) {
                            if (qCallRecent != null && (str3 = qCallRecent.uin) != null && str3.length() >= 2) {
                                int i3 = qCallRecent.type;
                                if (i3 == 1006) {
                                    PhoneContact queryContactByCodeNumber = iPhoneContactService2.queryContactByCodeNumber(qCallRecent.uin);
                                    if (queryContactByCodeNumber != null && friendsManager.c0(queryContactByCodeNumber.uin)) {
                                        z17 = true;
                                    } else {
                                        z17 = false;
                                    }
                                    if (queryContactByCodeNumber != null && TextUtils.isEmpty(queryContactByCodeNumber.uin)) {
                                        z18 = true;
                                    } else {
                                        z18 = false;
                                    }
                                    if (z17) {
                                        arrayList3.add(qCallRecent);
                                        z27 = true;
                                    }
                                    if (z18) {
                                        arrayList4.add(qCallRecent);
                                        z27 = true;
                                    }
                                } else if (i3 == 56938) {
                                    PhoneContact queryPhoneContactByMobile = iPhoneContactService2.queryPhoneContactByMobile(qCallRecent.uin);
                                    if (queryPhoneContactByMobile != null && friendsManager.c0(queryPhoneContactByMobile.uin)) {
                                        z19 = true;
                                    } else {
                                        z19 = false;
                                    }
                                    if (queryPhoneContactByMobile != null && !TextUtils.isEmpty(queryPhoneContactByMobile.uin)) {
                                        z26 = true;
                                    } else {
                                        z26 = false;
                                    }
                                    if (z19) {
                                        arrayList5.add(qCallRecent);
                                        z27 = true;
                                    }
                                    if (z26) {
                                        arrayList6.add(qCallRecent);
                                        z27 = true;
                                    }
                                }
                            }
                        }
                        for (QCallRecent qCallRecent2 : arrayList3) {
                            String str4 = qCallRecent2.uin;
                            QCallProxy.this.D(qCallRecent2);
                            PhoneContact queryContactByCodeNumber2 = iPhoneContactService2.queryContactByCodeNumber(str4);
                            if (queryContactByCodeNumber2 != null) {
                                QCallProxy.this.D(qCallRecent2);
                                String str5 = queryContactByCodeNumber2.uin;
                                QCallRecent qCallRecent3 = null;
                                for (int i16 : ao.f116570d) {
                                    qCallRecent3 = QCallProxy.this.m(str5, i16);
                                    if (qCallRecent3 != null) {
                                        break;
                                    }
                                }
                                QCallRecent qCallRecent4 = qCallRecent3;
                                if (qCallRecent4 != null) {
                                    arrayList2 = arrayList6;
                                    iPhoneContactService = iPhoneContactService2;
                                    if (qCallRecent2.lastCallTime > qCallRecent4.lastCallTime) {
                                        qCallRecent2.uin = str5;
                                        qCallRecent2.type = qCallRecent4.type;
                                        qCallRecent2.troopUin = qCallRecent4.troopUin;
                                        qCallRecent2.missedCallCount += qCallRecent4.missedCallCount;
                                    } else {
                                        qCallRecent4.missedCallCount += qCallRecent2.missedCallCount;
                                        qCallRecent2 = qCallRecent4;
                                    }
                                } else {
                                    arrayList2 = arrayList6;
                                    iPhoneContactService = iPhoneContactService2;
                                    qCallRecent2.uin = str5;
                                    qCallRecent2.type = 0;
                                }
                                QCallProxy.this.g(str4, 1006, str5, qCallRecent2.type);
                                QCallProxy.this.E(qCallRecent2);
                            } else {
                                arrayList2 = arrayList6;
                                iPhoneContactService = iPhoneContactService2;
                            }
                            arrayList6 = arrayList2;
                            iPhoneContactService2 = iPhoneContactService;
                        }
                        ArrayList<QCallRecent> arrayList7 = arrayList6;
                        IPhoneContactService iPhoneContactService3 = iPhoneContactService2;
                        for (QCallRecent qCallRecent5 : arrayList4) {
                            QCallProxy.this.D(qCallRecent5);
                            QCallProxy.this.j(qCallRecent5.uin, qCallRecent5.type);
                        }
                        for (QCallRecent qCallRecent6 : arrayList5) {
                            IPhoneContactService iPhoneContactService4 = iPhoneContactService3;
                            PhoneContact queryPhoneContactByMobile2 = iPhoneContactService4.queryPhoneContactByMobile(qCallRecent6.uin);
                            if (queryPhoneContactByMobile2 != null) {
                                QCallProxy.this.D(qCallRecent6);
                                String str6 = queryPhoneContactByMobile2.mobileCode;
                                String str7 = queryPhoneContactByMobile2.uin;
                                QCallRecent qCallRecent7 = null;
                                for (int i17 : ao.f116570d) {
                                    qCallRecent7 = QCallProxy.this.m(str7, i17);
                                    if (qCallRecent7 != null) {
                                        break;
                                    }
                                }
                                if (qCallRecent7 != null) {
                                    z16 = z27;
                                    if (qCallRecent6.lastCallTime > qCallRecent7.lastCallTime) {
                                        qCallRecent6.uin = str7;
                                        qCallRecent6.type = qCallRecent7.type;
                                        qCallRecent6.troopUin = qCallRecent7.troopUin;
                                        qCallRecent6.missedCallCount += qCallRecent7.missedCallCount;
                                    } else {
                                        qCallRecent7.missedCallCount += qCallRecent6.missedCallCount;
                                        qCallRecent6 = qCallRecent7;
                                    }
                                } else {
                                    z16 = z27;
                                    qCallRecent6.uin = str7;
                                    qCallRecent6.type = 0;
                                }
                                QCallProxy.this.g(str6, 1006, str7, qCallRecent6.type);
                                QCallProxy.this.E(qCallRecent6);
                            } else {
                                z16 = z27;
                            }
                            z27 = z16;
                            iPhoneContactService3 = iPhoneContactService4;
                        }
                        IPhoneContactService iPhoneContactService5 = iPhoneContactService3;
                        for (QCallRecent qCallRecent8 : arrayList7) {
                            String str8 = qCallRecent8.uin;
                            PhoneContact queryPhoneContactByMobile3 = iPhoneContactService5.queryPhoneContactByMobile(str8);
                            if (queryPhoneContactByMobile3 != null) {
                                QCallProxy.this.D(qCallRecent8);
                                String str9 = queryPhoneContactByMobile3.mobileCode;
                                QCallProxy.this.g(str8, AppConstants.VALUE.UIN_TYPE_UNBIND_PHONE_CONTACT, str9, 1006);
                                qCallRecent8.uin = str9;
                                qCallRecent8.type = 1006;
                                QCallProxy.this.E(qCallRecent8);
                            }
                        }
                    }
                }
            }
        }, 5, null, false);
        synchronized (this.f261541f) {
            arrayList = new ArrayList();
            for (QCallRecent qCallRecent : this.f261541f) {
                if (qCallRecent == null || (str2 = qCallRecent.uin) == null || str2.length() < 2) {
                    Utils.Q("QCallProxy");
                }
                if (qCallRecent != null && (str = qCallRecent.uin) != null && str.length() >= 2) {
                    arrayList.add(qCallRecent);
                }
            }
        }
        return arrayList;
    }

    public void C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QCallProxy", 2, "recentDoInit ====start====");
        }
        this.f261543h = ((QQAppInterface) this.app).getApp().getSharedPreferences(((QQAppInterface) this.app).getCurrentAccountUin(), 0).getBoolean("Conversation_call_prompt_flag", true);
        EntityManager createEntityManager = this.app.getEntityManagerFactory().createEntityManager();
        try {
            List<? extends Entity> query = createEntityManager.query(QCallRecent.class, false, null, null, null, null, "lastCallTime desc", null);
            synchronized (this.f261541f) {
                if (query != null) {
                    if (query.size() > 0) {
                        if (query.size() > 100) {
                            long currentTimeMillis = System.currentTimeMillis();
                            try {
                                StringBuffer stringBuffer = new StringBuffer();
                                stringBuffer.append("delete from");
                                stringBuffer.append(QCallRecent.TABLE_NAME);
                                stringBuffer.append(" where lastCallTime < ");
                                stringBuffer.append(((QCallRecent) query.get(90)).lastCallTime);
                                stringBuffer.append(";");
                                boolean execSQL = DBMethodProxy.execSQL(createEntityManager, stringBuffer.toString());
                                if (execSQL) {
                                    query = new ArrayList(query.subList(0, 90));
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.d("QCallProxy", 2, "doInit cache data > 100 isOk = " + execSQL + ",time:" + (System.currentTimeMillis() - currentTimeMillis));
                                }
                            } catch (Exception e16) {
                                if (QLog.isDevelopLevel()) {
                                    QLog.e("QCallProxy", 4, e16.getMessage(), e16);
                                }
                            }
                        }
                        this.f261541f.clear();
                        Iterator<? extends Entity> it = query.iterator();
                        while (it.hasNext()) {
                            QCallRecent qCallRecent = (QCallRecent) it.next();
                            int i3 = qCallRecent.state;
                            if (i3 == 5 || i3 == 6 || i3 == 7 || i3 == 1) {
                                qCallRecent.state = 0;
                            }
                            String str = qCallRecent.uin;
                            if (str != null && str.length() >= 2) {
                                this.f261541f.add(qCallRecent);
                            }
                        }
                        for (QCallRecent qCallRecent2 : this.f261541f) {
                            this.f261542g.put(u(qCallRecent2.uin, qCallRecent2.type), qCallRecent2);
                        }
                    }
                }
                if (QLog.isDevelopLevel()) {
                    QLog.d("QCallProxy", 4, this.f261541f.toString());
                }
            }
            createEntityManager.close();
            if (QLog.isColorLevel()) {
                QLog.d("QCallProxy", 2, "recentDoInit ====end====");
            }
        } catch (Throwable th5) {
            createEntityManager.close();
            throw th5;
        }
    }

    public void D(QCallRecent qCallRecent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) qCallRecent);
            return;
        }
        synchronized (this.f261541f) {
            this.f261541f.remove(qCallRecent);
            this.f261542g.remove(u(qCallRecent.uin, qCallRecent.type));
        }
        this.proxyManager.addMsgQueueDonotNotify(qCallRecent.uin, qCallRecent.type, qCallRecent.getTableName(), qCallRecent, 5, null);
    }

    public void E(QCallRecent qCallRecent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) qCallRecent);
        } else {
            F(qCallRecent, true);
        }
    }

    public void G(QCallRecent qCallRecent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) qCallRecent);
        } else {
            F(qCallRecent, false);
        }
    }

    public void H(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
            return;
        }
        this.f261543h = z16;
        SharedPreferences sharedPreferences = ((QQAppInterface) this.app).getApp().getSharedPreferences(((QQAppInterface) this.app).getCurrentAccountUin(), 0);
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean("Conversation_call_prompt_flag", false);
            edit.commit();
        }
    }

    @Override // com.tencent.mobileqq.app.proxy.BaseProxy
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        EntityManager entityManager = this.f261538c;
        if (entityManager != null && entityManager.isOpen()) {
            this.f261538c.close();
        }
        i();
        h();
        f261535i = false;
    }

    public void g(String str, int i3, String str2, int i16) {
        List<QCallRecord> s16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, str, Integer.valueOf(i3), str2, Integer.valueOf(i16));
            return;
        }
        if (!r(str, i3).equals(r(str2, i16)) && (s16 = s(str, i3)) != null) {
            for (QCallRecord qCallRecord : s16) {
                qCallRecord.friendUin = str2;
                qCallRecord.uinType = i16;
                y(qCallRecord);
            }
            j(str, i3);
        }
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        ConcurrentHashMap<String, List<QCallRecord>> concurrentHashMap = this.f261536a;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        synchronized (this.f261541f) {
            this.f261541f.clear();
            this.f261542g.clear();
        }
    }

    @Override // com.tencent.mobileqq.app.proxy.BaseProxy
    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            if (f261535i) {
                return;
            }
            f261535i = true;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qcall.QCallProxy.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QCallProxy.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        QCallProxy.this.C();
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.w("QCallProxy", 2, e16.getMessage(), e16);
                        }
                    }
                }
            }, 32, null, true);
        }
    }

    public void j(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, i3);
            return;
        }
        List<QCallRecord> list = this.f261536a.get(r(str, i3));
        if (list != null) {
            list.clear();
        }
        k(str, i3);
    }

    public QCallRecent l(String str, int i3) {
        QCallRecent qCallRecent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (QCallRecent) iPatchRedirector.redirect((short) 17, (Object) this, (Object) str, i3);
        }
        synchronized (this.f261542g) {
            qCallRecent = this.f261542g.get(u(str, i3));
            if (qCallRecent == null) {
                qCallRecent = new QCallRecent();
                qCallRecent.uin = str;
                qCallRecent.type = i3;
                qCallRecent.displayName = str;
            }
        }
        return qCallRecent;
    }

    public QCallRecent m(String str, int i3) {
        QCallRecent qCallRecent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (QCallRecent) iPatchRedirector.redirect((short) 18, (Object) this, (Object) str, i3);
        }
        synchronized (this.f261542g) {
            qCallRecent = this.f261542g.get(u(str, i3));
        }
        return qCallRecent;
    }

    public boolean n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        if (this.f261543h && this.f261541f.size() > 0) {
            return true;
        }
        return false;
    }

    public List<QCallRecord> s(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, i3);
        }
        String r16 = r(str, i3);
        Object o16 = o(str, i3);
        if (QLog.isColorLevel()) {
            QLog.d("QCallProxy", 2, "getListRecord ThreadName:" + Thread.currentThread().getName() + " getListRecord friendUin:" + str + ",uinType:" + i3);
        }
        synchronized (o16) {
            List<QCallRecord> list = this.f261536a.get(r16);
            if (list != null) {
                return list;
            }
            List<QCallRecord> t16 = t(str, i3);
            if (t16 == null) {
                t16 = new ArrayList<>();
            }
            if (QLog.isColorLevel()) {
                QLog.d("QCallProxy", 2, "getListRecord ThreadName:" + Thread.currentThread().getName() + " getListRecord (DB) records size:" + t16.size());
                StringBuilder sb5 = new StringBuilder();
                sb5.append("getListRecord");
                sb5.append(t16);
                QLog.d("QCallProxy", 2, sb5.toString());
            }
            ArrayList<QCallRecord> q16 = q(t16);
            this.f261536a.put(r16, q16);
            return q16;
        }
    }

    public void x(QCallRecent qCallRecent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) qCallRecent);
        } else if (qCallRecent.getStatus() == 1000) {
            this.proxyManager.addMsgQueueDonotNotify(qCallRecent.uin, qCallRecent.type, qCallRecent.getTableName(), qCallRecent, 3, null);
        } else {
            this.proxyManager.addMsgQueueDonotNotify(qCallRecent.uin, qCallRecent.type, qCallRecent.getTableName(), qCallRecent, 4, null);
        }
    }

    public void y(QCallRecord qCallRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) qCallRecord);
            return;
        }
        if (qCallRecord == null) {
            return;
        }
        synchronized (o(qCallRecord.friendUin, qCallRecord.uinType)) {
            String r16 = r(qCallRecord.friendUin, qCallRecord.uinType);
            List<QCallRecord> list = this.f261536a.get(r16);
            if (list == null) {
                list = s(qCallRecord.friendUin, qCallRecord.uinType);
            }
            list.add(qCallRecord);
            if (QLog.isColorLevel()) {
                QLog.d("QCallProxy", 2, "insertRecord ThreadName:" + Thread.currentThread().getName() + " insertRecord records size:" + list.size());
            }
            this.f261536a.put(r16, q(list));
        }
        z(qCallRecord);
    }
}
