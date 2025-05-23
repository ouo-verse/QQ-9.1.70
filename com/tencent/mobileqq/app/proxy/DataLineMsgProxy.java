package com.tencent.mobileqq.app.proxy;

import android.content.ContentValues;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.dataline.util.m;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.l;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.message.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/* loaded from: classes11.dex */
public class DataLineMsgProxy extends BaseProxy {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private DataLineMsgSetList f196491a;

    /* renamed from: b, reason: collision with root package name */
    private DataLineMsgSetList f196492b;

    /* renamed from: c, reason: collision with root package name */
    protected String f196493c;

    /* renamed from: com.tencent.mobileqq.app.proxy.DataLineMsgProxy$11, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass11 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f196500d;
        final /* synthetic */ DataLineMsgProxy this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.this$0.f196492b.appendToList((DataLineMsgRecord) this.f196500d.get(0));
            }
        }
    }

    /* loaded from: classes11.dex */
    public interface a {
        void a(int i3);
    }

    public DataLineMsgProxy(QQAppInterface qQAppInterface, BaseProxyManager baseProxyManager) {
        super(qQAppInterface, baseProxyManager);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) baseProxyManager);
        } else {
            this.f196493c = DataLineMsgRecord.tableName();
        }
    }

    public static boolean A(BaseProxyManager baseProxyManager, String str) {
        boolean z16;
        Iterator it = ((Vector) baseProxyManager.getQueue().clone()).iterator();
        while (true) {
            z16 = false;
            if (!it.hasNext()) {
                break;
            }
            MsgQueueItem msgQueueItem = (MsgQueueItem) it.next();
            if (String.valueOf(0).equals(msgQueueItem.frindUin) && msgQueueItem.type == 0 && msgQueueItem.tableName.equals(str)) {
                int i3 = msgQueueItem.action;
                z16 = true;
                if (i3 == 1 || i3 == 2 || i3 == 0) {
                    break;
                }
            }
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(long j3) {
        DataLineMsgRecord s16 = s(j3);
        if (s16 != null) {
            ContentValues contentValues = new ContentValues();
            s16.doPrewrite();
            contentValues.put(AppConstants.Key.COLUMN_MSG_DATA, s16.msgData);
            P(this.f196493c, contentValues, "msgId=?", new String[]{String.valueOf(s16.msgId)}, null);
        }
    }

    private synchronized void J() {
        init();
        DataLineMsgSetList dataLineMsgSetList = this.f196491a;
        if (dataLineMsgSetList == null) {
            return;
        }
        Iterator<DataLineMsgSet> it = dataLineMsgSetList.iterator();
        while (it.hasNext()) {
            Iterator<DataLineMsgRecord> it5 = it.next().values().iterator();
            while (it5.hasNext()) {
                it5.next().isread = true;
            }
        }
        DataLineMsgSetList dataLineMsgSetList2 = this.f196492b;
        if (dataLineMsgSetList2 != null) {
            Iterator<DataLineMsgSet> it6 = dataLineMsgSetList2.iterator();
            while (it6.hasNext()) {
                Iterator<DataLineMsgRecord> it7 = it6.next().values().iterator();
                while (it7.hasNext()) {
                    it7.next().isread = true;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(long j3) {
        DataLineMsgRecord s16 = s(j3);
        ContentValues contentValues = new ContentValues();
        contentValues.put("issuc", Boolean.TRUE);
        contentValues.put("progress", Float.valueOf(1.0f));
        if (s16 != null) {
            s16.issuc = true;
            s16.progress = 1.0f;
            P(this.f196493c, contentValues, "msgId=?", new String[]{String.valueOf(s16.msgId)}, null);
            if (s16.path == null || s16.strMoloKey != null) {
                return;
            }
            if (!s16.isSend() || s16.fileFrom != 0) {
                new File(s16.path).setLastModified(System.currentTimeMillis());
            }
            if (s16.entityID != 0) {
                FileManagerEntity D = ((QQAppInterface) this.app).getFileManagerDataCenter().D(s16.entityID);
                if (D != null) {
                    if (!D.bDelInFM) {
                        return;
                    }
                } else {
                    s16.entityID = 0L;
                }
            }
            FileManagerEntity newEntityByDataLineFileInfo = FileManagerUtil.newEntityByDataLineFileInfo(s16);
            if (newEntityByDataLineFileInfo.getCloudType() == 6 && l.b(newEntityByDataLineFileInfo.getFilePath())) {
                newEntityByDataLineFileInfo.setCloudType(3);
            }
            F(s16.msgId);
            newEntityByDataLineFileInfo.bDelInFM = false;
            if (!s16.isSend()) {
                newEntityByDataLineFileInfo.srvTime = e.K0() * 1000;
            }
            if (!s16.bNoInsertFm) {
                ((QQAppInterface) this.app).getFileManagerDataCenter().t(newEntityByDataLineFileInfo);
            } else {
                s16.bNoInsertFm = false;
                newEntityByDataLineFileInfo.bDelInFM = true;
            }
            ((QQAppInterface) this.app).getFileManagerDataCenter().f0(newEntityByDataLineFileInfo);
        }
    }

    private synchronized void k() {
        init();
        while (this.f196491a.size() > 20) {
            DataLineMsgSet dataLineMsgSet = this.f196491a.get(0);
            if (dataLineMsgSet.getGroupType() != -2334 && dataLineMsgSet.getGroupType() != -1000 && !dataLineMsgSet.isAllCompleted()) {
                break;
            } else {
                this.f196491a.remove(0);
            }
        }
    }

    private synchronized boolean n(DataLineMsgSet dataLineMsgSet) {
        boolean z16;
        DataLineMsgSetList dataLineMsgSetList;
        init();
        DataLineMsgSetList dataLineMsgSetList2 = this.f196491a;
        boolean z17 = false;
        if (dataLineMsgSetList2 != null) {
            z16 = dataLineMsgSetList2.remove(dataLineMsgSet);
            if (z16 && this.f196491a.size() < 3) {
                this.f196491a.clear();
                this.f196491a = null;
                init();
            }
        } else {
            z16 = false;
        }
        DataLineMsgSetList dataLineMsgSetList3 = this.f196492b;
        if (dataLineMsgSetList3 != null) {
            if (dataLineMsgSetList3.remove(dataLineMsgSet) || z16) {
                z17 = true;
            }
            if (z17 && this.f196492b.size() == 0 && (dataLineMsgSetList = this.f196491a) != null) {
                this.f196492b.copyFrom(dataLineMsgSetList);
            }
            z16 = z17;
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String x(long j3, int i3) {
        String str = this.f196493c;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("select " + str + ".*, case when groupId=0 or groupId is null then msgId else groupId end as msgKey from " + str + " ");
        sb5.append("join ");
        sb5.append("(select * from ");
        sb5.append("(select case when groupId=0 or groupId is null then msgId else groupId end as msgKey2, ");
        sb5.append("max(msgId) AS rorder ");
        sb5.append("from " + str + " ");
        if (j3 != -1) {
            sb5.append("where " + str + ".msgId < ? ");
        }
        sb5.append("group by msgKey2) ");
        sb5.append("order by rorder desc ");
        sb5.append("limit " + i3 + " ) b ");
        sb5.append("on  msgKey=msgKey2 ");
        if (j3 != -1) {
            sb5.append("order by " + str + ".msgId desc");
        } else {
            sb5.append("order by " + str + ".msgId asc");
        }
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized long y(DataLineMsgRecord dataLineMsgRecord) {
        init();
        dataLineMsgRecord.msgId = this.f196491a.getLastId() + 1;
        DataLineMsgSet appendToList = this.f196491a.appendToList(dataLineMsgRecord);
        k();
        DataLineMsgSetList dataLineMsgSetList = this.f196492b;
        if (dataLineMsgSetList != null) {
            if (appendToList == null) {
                dataLineMsgSetList.appendToList(dataLineMsgRecord);
            } else {
                dataLineMsgSetList.appendToList(appendToList);
            }
        }
        return dataLineMsgRecord.msgId;
    }

    public synchronized void B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        DataLineMsgSetList dataLineMsgSetList = this.f196492b;
        if (dataLineMsgSetList != null) {
            dataLineMsgSetList.clear();
        }
        this.f196492b = null;
    }

    public int C(DataLineMsgSet dataLineMsgSet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Integer) iPatchRedirector.redirect((short) 30, (Object) this, (Object) dataLineMsgSet)).intValue();
        }
        if (dataLineMsgSet == null) {
            return -1;
        }
        Iterator<DataLineMsgRecord> it = dataLineMsgSet.values().iterator();
        while (it.hasNext()) {
            m(this.f196493c, "msgId=?", new String[]{String.valueOf(it.next().msgId)}, null);
        }
        n(dataLineMsgSet);
        return 1;
    }

    public boolean D(DataLineMsgSet dataLineMsgSet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, (Object) dataLineMsgSet)).booleanValue();
        }
        init();
        DataLineMsgSetList dataLineMsgSetList = this.f196491a;
        if (dataLineMsgSetList != null) {
            return dataLineMsgSetList.remove(dataLineMsgSet);
        }
        return false;
    }

    public void E(long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Long.valueOf(j3), str);
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() == mainLooper.getThread()) {
            DataLineMsgRecord s16 = s(j3);
            ContentValues contentValues = new ContentValues();
            contentValues.put("path", str);
            if (s16 != null) {
                P(this.f196493c, contentValues, "msgId=?", new String[]{String.valueOf(s16.msgId)}, null);
                return;
            }
            return;
        }
        new Handler(mainLooper).post(new Runnable(j3, str) { // from class: com.tencent.mobileqq.app.proxy.DataLineMsgProxy.4
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f196505d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f196506e;

            {
                this.f196505d = j3;
                this.f196506e = str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, DataLineMsgProxy.this, Long.valueOf(j3), str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                DataLineMsgRecord s17 = DataLineMsgProxy.this.s(this.f196505d);
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("path", this.f196506e);
                if (s17 != null) {
                    DataLineMsgProxy dataLineMsgProxy = DataLineMsgProxy.this;
                    dataLineMsgProxy.P(dataLineMsgProxy.f196493c, contentValues2, "msgId=?", new String[]{String.valueOf(s17.msgId)}, null);
                }
            }
        });
    }

    public void F(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, j3);
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() == mainLooper.getThread()) {
            G(j3);
        } else {
            new Handler(mainLooper).post(new Runnable(j3) { // from class: com.tencent.mobileqq.app.proxy.DataLineMsgProxy.7
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ long f196512d;

                {
                    this.f196512d = j3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, DataLineMsgProxy.this, Long.valueOf(j3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        DataLineMsgProxy.this.G(this.f196512d);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    public void H(long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, Long.valueOf(j3), str);
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() == mainLooper.getThread()) {
            DataLineMsgRecord s16 = s(j3);
            ContentValues contentValues = new ContentValues();
            contentValues.put("thumbPath", str);
            if (s16 != null) {
                P(this.f196493c, contentValues, "msgId=?", new String[]{String.valueOf(s16.msgId)}, null);
                return;
            }
            return;
        }
        new Handler(mainLooper).post(new Runnable(j3, str) { // from class: com.tencent.mobileqq.app.proxy.DataLineMsgProxy.5
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f196507d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f196508e;

            {
                this.f196507d = j3;
                this.f196508e = str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, DataLineMsgProxy.this, Long.valueOf(j3), str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                DataLineMsgRecord s17 = DataLineMsgProxy.this.s(this.f196507d);
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("thumbPath", this.f196508e);
                if (s17 != null) {
                    DataLineMsgProxy dataLineMsgProxy = DataLineMsgProxy.this;
                    dataLineMsgProxy.P(dataLineMsgProxy.f196493c, contentValues2, "msgId=?", new String[]{String.valueOf(s17.msgId)}, null);
                }
            }
        });
    }

    public void I(long j3, String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, Long.valueOf(j3), str, bArr);
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() == mainLooper.getThread()) {
            DataLineMsgRecord s16 = s(j3);
            ContentValues contentValues = new ContentValues();
            if (!TextUtils.isEmpty(str)) {
                contentValues.put("serverPath", str);
            }
            if (bArr != null && bArr.length > 0) {
                contentValues.put("md5", bArr);
            }
            if (s16 != null) {
                P(this.f196493c, contentValues, "msgId=?", new String[]{String.valueOf(s16.msgId)}, null);
                return;
            }
            return;
        }
        new Handler(mainLooper).post(new Runnable(j3, str, bArr) { // from class: com.tencent.mobileqq.app.proxy.DataLineMsgProxy.6
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f196509d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f196510e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ byte[] f196511f;

            {
                this.f196509d = j3;
                this.f196510e = str;
                this.f196511f = bArr;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, DataLineMsgProxy.this, Long.valueOf(j3), str, bArr);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                DataLineMsgRecord s17 = DataLineMsgProxy.this.s(this.f196509d);
                ContentValues contentValues2 = new ContentValues();
                if (!TextUtils.isEmpty(this.f196510e)) {
                    contentValues2.put("serverPath", this.f196510e);
                }
                byte[] bArr2 = this.f196511f;
                if (bArr2 != null && bArr2.length > 0) {
                    contentValues2.put("md5", bArr2);
                }
                if (s17 != null) {
                    DataLineMsgProxy dataLineMsgProxy = DataLineMsgProxy.this;
                    dataLineMsgProxy.P(dataLineMsgProxy.f196493c, contentValues2, "msgId=?", new String[]{String.valueOf(s17.msgId)}, null);
                }
            }
        });
    }

    public void K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        J();
        ContentValues contentValues = new ContentValues();
        contentValues.put(AppConstants.Key.COLUMN_IS_READ, Boolean.TRUE);
        P(this.f196493c, contentValues, "isread=?", new String[]{"0"}, null);
    }

    public void L(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, j3);
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() == mainLooper.getThread()) {
            DataLineMsgRecord s16 = s(j3);
            if (s16 != null) {
                s16.issuc = false;
                ContentValues contentValues = new ContentValues();
                contentValues.put("issuc", Boolean.FALSE);
                P(this.f196493c, contentValues, "msgId=?", new String[]{String.valueOf(s16.msgId)}, null);
                return;
            }
            return;
        }
        new Handler(mainLooper).post(new Runnable(j3) { // from class: com.tencent.mobileqq.app.proxy.DataLineMsgProxy.9
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f196514d;

            {
                this.f196514d = j3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, DataLineMsgProxy.this, Long.valueOf(j3));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                DataLineMsgRecord s17 = DataLineMsgProxy.this.s(this.f196514d);
                if (s17 != null) {
                    s17.issuc = false;
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("issuc", Boolean.FALSE);
                    DataLineMsgProxy dataLineMsgProxy = DataLineMsgProxy.this;
                    dataLineMsgProxy.P(dataLineMsgProxy.f196493c, contentValues2, "msgId=?", new String[]{String.valueOf(s17.msgId)}, null);
                }
            }
        });
    }

    public void M(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, j3);
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() == mainLooper.getThread()) {
            N(j3);
        } else {
            new Handler(mainLooper).post(new Runnable(j3) { // from class: com.tencent.mobileqq.app.proxy.DataLineMsgProxy.8
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ long f196513d;

                {
                    this.f196513d = j3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, DataLineMsgProxy.this, Long.valueOf(j3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        DataLineMsgProxy.this.N(this.f196513d);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    public void O() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this);
        } else {
            this.proxyManager.transSaveToDatabase(this.app.getEntityManagerFactory().createEntityManager());
        }
    }

    public void P(String str, ContentValues contentValues, String str2, String[] strArr, ProxyListener proxyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, str, contentValues, str2, strArr, proxyListener);
        }
    }

    @Override // com.tencent.mobileqq.app.proxy.BaseProxy
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        }
    }

    public synchronized DataLineMsgSetList f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (DataLineMsgSetList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        init();
        return this.f196491a;
    }

    public void g(Entity entity, ProxyListener proxyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) entity, (Object) proxyListener);
            return;
        }
        m mVar = new m(false, false);
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            new Handler(mainLooper).post(new Runnable(mVar) { // from class: com.tencent.mobileqq.app.proxy.DataLineMsgProxy.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ m f196494d;

                {
                    this.f196494d = mVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DataLineMsgProxy.this, (Object) mVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        this.f196494d.a();
                    }
                }
            });
            mVar.b(-1L);
        }
    }

    public long h(DataLineMsgRecord dataLineMsgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Long) iPatchRedirector.redirect((short) 21, (Object) this, (Object) dataLineMsgRecord)).longValue();
        }
        m mVar = new m(false, false);
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() == mainLooper.getThread()) {
            long y16 = y(dataLineMsgRecord);
            g(dataLineMsgRecord, null);
            return y16;
        }
        new Handler(mainLooper).post(new Runnable(dataLineMsgRecord, mVar) { // from class: com.tencent.mobileqq.app.proxy.DataLineMsgProxy.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ DataLineMsgRecord f196503d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ m f196504e;

            {
                this.f196503d = dataLineMsgRecord;
                this.f196504e = mVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, DataLineMsgProxy.this, dataLineMsgRecord, mVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    DataLineMsgProxy.this.y(this.f196503d);
                    DataLineMsgProxy.this.g(this.f196503d, null);
                    this.f196504e.a();
                    return;
                }
                iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        mVar.b(-1L);
        return 0L;
    }

    public long i(DataLineMsgRecord dataLineMsgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Long) iPatchRedirector.redirect((short) 19, (Object) this, (Object) dataLineMsgRecord)).longValue();
        }
        m mVar = new m(false, false);
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() == mainLooper.getThread()) {
            return y(dataLineMsgRecord);
        }
        new Handler(mainLooper).post(new Runnable(dataLineMsgRecord, mVar) { // from class: com.tencent.mobileqq.app.proxy.DataLineMsgProxy.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ DataLineMsgRecord f196501d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ m f196502e;

            {
                this.f196501d = dataLineMsgRecord;
                this.f196502e = mVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, DataLineMsgProxy.this, dataLineMsgRecord, mVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    DataLineMsgProxy.this.y(this.f196501d);
                    this.f196502e.a();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
        mVar.b(-1L);
        return 0L;
    }

    @Override // com.tencent.mobileqq.app.proxy.BaseProxy
    public synchronized void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            if (this.f196491a != null) {
                return;
            }
            this.f196491a = new DataLineMsgSetList();
        }
    }

    public synchronized int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        init();
        int size = this.f196491a.size();
        this.f196491a.clear();
        DataLineMsgSetList dataLineMsgSetList = this.f196492b;
        if (dataLineMsgSetList != null) {
            dataLineMsgSetList.clear();
        }
        m(this.f196493c, null, null, null);
        return size;
    }

    public synchronized void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            k();
        }
    }

    public void m(String str, String str2, String[] strArr, ProxyListener proxyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, str, str2, strArr, proxyListener);
        }
    }

    public synchronized DataLineMsgSetList o(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (DataLineMsgSetList) iPatchRedirector.redirect((short) 3, (Object) this, z16);
        }
        init();
        if (this.f196492b == null && z16) {
            this.f196492b = this.f196491a.m169clone();
        }
        return this.f196492b;
    }

    public List<DataLineMsgRecord> p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (List) iPatchRedirector.redirect((short) 36, (Object) this);
        }
        return DBMethodProxy.rawQuery(this.app.getEntityManagerFactory().createEntityManager(), DataLineMsgRecord.class, "select * from mr_data_line", null);
    }

    public synchronized DataLineMsgRecord q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (DataLineMsgRecord) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        init();
        DataLineMsgSetList dataLineMsgSetList = this.f196491a;
        if (dataLineMsgSetList == null) {
            return null;
        }
        return dataLineMsgSetList.get(dataLineMsgSetList.size() - 1).getLastItem();
    }

    public synchronized List<DataLineMsgRecord> r(String str) {
        DataLineMsgSetList dataLineMsgSetList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        }
        init();
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<DataLineMsgSet> it = this.f196491a.iterator();
        while (it.hasNext()) {
            Iterator<DataLineMsgRecord> it5 = it.next().values().iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                DataLineMsgRecord next = it5.next();
                String str2 = next.strMoloKey;
                if (str2 != null && str2.equals(str)) {
                    arrayList.add(next);
                    break;
                }
            }
        }
        if (arrayList.size() == 0 && (dataLineMsgSetList = this.f196492b) != null) {
            Iterator<DataLineMsgSet> it6 = dataLineMsgSetList.iterator();
            while (it6.hasNext()) {
                Iterator<DataLineMsgRecord> it7 = it6.next().values().iterator();
                while (true) {
                    if (!it7.hasNext()) {
                        break;
                    }
                    DataLineMsgRecord next2 = it7.next();
                    String str3 = next2.strMoloKey;
                    if (str3 != null && str3.equals(str)) {
                        arrayList.add(next2);
                        break;
                    }
                }
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    public synchronized DataLineMsgRecord s(long j3) {
        DataLineMsgSetList dataLineMsgSetList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (DataLineMsgRecord) iPatchRedirector.redirect((short) 6, (Object) this, j3);
        }
        init();
        DataLineMsgSetList dataLineMsgSetList2 = this.f196491a;
        DataLineMsgRecord dataLineMsgRecord = null;
        if (dataLineMsgSetList2 == null) {
            return null;
        }
        Iterator<DataLineMsgSet> it = dataLineMsgSetList2.iterator();
        while (it.hasNext()) {
            Iterator<DataLineMsgRecord> it5 = it.next().values().iterator();
            while (true) {
                if (it5.hasNext()) {
                    DataLineMsgRecord next = it5.next();
                    if (next.msgId == j3) {
                        dataLineMsgRecord = next;
                        break;
                    }
                }
            }
        }
        if (dataLineMsgRecord == null && (dataLineMsgSetList = this.f196492b) != null) {
            Iterator<DataLineMsgSet> it6 = dataLineMsgSetList.iterator();
            while (it6.hasNext()) {
                Iterator<DataLineMsgRecord> it7 = it6.next().values().iterator();
                while (true) {
                    if (it7.hasNext()) {
                        DataLineMsgRecord next2 = it7.next();
                        if (next2.msgId == j3) {
                            dataLineMsgRecord = next2;
                            break;
                        }
                    }
                }
            }
        }
        return dataLineMsgRecord;
    }

    public synchronized DataLineMsgRecord t(long j3) {
        DataLineMsgSetList dataLineMsgSetList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (DataLineMsgRecord) iPatchRedirector.redirect((short) 7, (Object) this, j3);
        }
        init();
        DataLineMsgSetList dataLineMsgSetList2 = this.f196491a;
        DataLineMsgRecord dataLineMsgRecord = null;
        if (dataLineMsgSetList2 == null) {
            return null;
        }
        Iterator<DataLineMsgSet> it = dataLineMsgSetList2.iterator();
        while (it.hasNext()) {
            Iterator<DataLineMsgRecord> it5 = it.next().values().iterator();
            while (true) {
                if (it5.hasNext()) {
                    DataLineMsgRecord next = it5.next();
                    if (next.sessionid == j3) {
                        dataLineMsgRecord = next;
                        break;
                    }
                }
            }
        }
        if (dataLineMsgRecord == null && (dataLineMsgSetList = this.f196492b) != null) {
            Iterator<DataLineMsgSet> it6 = dataLineMsgSetList.iterator();
            while (it6.hasNext()) {
                Iterator<DataLineMsgRecord> it7 = it6.next().values().iterator();
                while (true) {
                    if (it7.hasNext()) {
                        DataLineMsgRecord next2 = it7.next();
                        if (next2.sessionid == j3) {
                            dataLineMsgRecord = next2;
                            break;
                        }
                    }
                }
            }
        }
        return dataLineMsgRecord;
    }

    public synchronized DataLineMsgSet u(int i3) {
        DataLineMsgSetList dataLineMsgSetList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (DataLineMsgSet) iPatchRedirector.redirect((short) 11, (Object) this, i3);
        }
        init();
        DataLineMsgSet dataLineMsgSet = null;
        if (i3 == 0) {
            return null;
        }
        Iterator<DataLineMsgSet> it = this.f196491a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DataLineMsgSet next = it.next();
            if (!next.isSingle() && next.getGroupId() == i3) {
                dataLineMsgSet = next;
                break;
            }
        }
        if (dataLineMsgSet == null && (dataLineMsgSetList = this.f196492b) != null) {
            Iterator<DataLineMsgSet> it5 = dataLineMsgSetList.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                DataLineMsgSet next2 = it5.next();
                if (!next2.isSingle() && next2.getGroupId() == i3) {
                    dataLineMsgSet = next2;
                    break;
                }
            }
        }
        return dataLineMsgSet;
    }

    public synchronized DataLineMsgSet v(long j3) {
        DataLineMsgSetList dataLineMsgSetList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (DataLineMsgSet) iPatchRedirector.redirect((short) 8, (Object) this, j3);
        }
        init();
        DataLineMsgSetList dataLineMsgSetList2 = this.f196491a;
        DataLineMsgSet dataLineMsgSet = null;
        if (dataLineMsgSetList2 == null) {
            return null;
        }
        Iterator<DataLineMsgSet> it = dataLineMsgSetList2.iterator();
        while (it.hasNext()) {
            DataLineMsgSet next = it.next();
            Iterator<DataLineMsgRecord> it5 = next.values().iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                if (it5.next().sessionid == j3) {
                    dataLineMsgSet = next;
                    break;
                }
            }
        }
        if (dataLineMsgSet == null && (dataLineMsgSetList = this.f196492b) != null) {
            Iterator<DataLineMsgSet> it6 = dataLineMsgSetList.iterator();
            while (it6.hasNext()) {
                DataLineMsgSet next2 = it6.next();
                Iterator<DataLineMsgRecord> it7 = next2.values().iterator();
                while (true) {
                    if (!it7.hasNext()) {
                        break;
                    }
                    if (it7.next().sessionid == j3) {
                        dataLineMsgSet = next2;
                        break;
                    }
                }
            }
        }
        return dataLineMsgSet;
    }

    public List<DataLineMsgRecord> w(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (List) iPatchRedirector.redirect((short) 37, (Object) this, (Object) str);
        }
        return DBMethodProxy.rawQuery(this.app.getEntityManagerFactory().createEntityManager(), DataLineMsgRecord.class, str, null);
    }

    public void z(int i3, a aVar) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, i3, (Object) aVar);
            return;
        }
        DataLineMsgSetList dataLineMsgSetList = this.f196492b;
        if (dataLineMsgSetList != null && !dataLineMsgSetList.isEmpty()) {
            j3 = this.f196492b.getFirstId();
        } else {
            j3 = 0;
        }
        ThreadManagerV2.post(new Runnable(j3, i3, aVar) { // from class: com.tencent.mobileqq.app.proxy.DataLineMsgProxy.10
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f196495d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f196496e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ a f196497f;

            {
                this.f196495d = j3;
                this.f196496e = i3;
                this.f196497f = aVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, DataLineMsgProxy.this, Long.valueOf(j3), Integer.valueOf(i3), aVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                EntityManager createEntityManager = DataLineMsgProxy.this.app.getEntityManagerFactory().createEntityManager();
                DataLineMsgProxy dataLineMsgProxy = DataLineMsgProxy.this;
                if (DataLineMsgProxy.A(dataLineMsgProxy.proxyManager, dataLineMsgProxy.f196493c)) {
                    DataLineMsgProxy.this.proxyManager.transSaveToDatabase(createEntityManager);
                }
                List<Entity> rawQuery = DBMethodProxy.rawQuery(createEntityManager, DataLineMsgRecord.class, DataLineMsgProxy.this.x(this.f196495d, this.f196496e), new String[]{String.valueOf(this.f196495d)});
                createEntityManager.close();
                new Handler(Looper.getMainLooper()).post(new Runnable(rawQuery) { // from class: com.tencent.mobileqq.app.proxy.DataLineMsgProxy.10.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ List f196498d;

                    {
                        this.f196498d = rawQuery;
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass10.this, (Object) rawQuery);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                            return;
                        }
                        int i16 = 0;
                        if (this.f196498d != null && DataLineMsgProxy.this.f196492b != null) {
                            Iterator it = this.f196498d.iterator();
                            while (it.hasNext()) {
                                if (DataLineMsgProxy.this.f196492b.insertFrontToList((DataLineMsgRecord) it.next())) {
                                    i16++;
                                }
                            }
                        }
                        a aVar2 = AnonymousClass10.this.f196497f;
                        if (aVar2 != null) {
                            aVar2.a(i16);
                        }
                    }
                });
            }
        }, 8, null, true);
    }
}
