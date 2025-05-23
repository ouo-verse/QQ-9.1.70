package com.tencent.mobileqq.filemanager.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.filemanager.api.IQQFileSelectorUtil;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.service.message.s;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FileManagerDataCenter {

    /* renamed from: a, reason: collision with root package name */
    QQAppInterface f207331a;

    /* renamed from: b, reason: collision with root package name */
    private BroadcastReceiver f207332b = null;

    /* renamed from: c, reason: collision with root package name */
    private f f207333c = null;

    /* renamed from: d, reason: collision with root package name */
    private List<Long> f207334d;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filemanager.core.FileManagerDataCenter$1, reason: invalid class name */
    /* loaded from: classes12.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f207335d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f207336e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f207337f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f207338h;

        @Override // java.lang.Runnable
        public void run() {
            FileManagerDataCenter.f(this.f207335d, this.f207336e, this.f207337f, this.f207338h);
        }
    }

    public FileManagerDataCenter(QQAppInterface qQAppInterface) {
        this.f207331a = qQAppInterface;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(final Bundle bundle) {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.core.FileManagerDataCenter.3
            @Override // java.lang.Runnable
            public void run() {
                Bundle bundle2 = bundle;
                if (bundle2 == null) {
                    if (QLog.isColorLevel()) {
                        QLog.e("FileManagerDataCenter<FileAssistant>", 2, "INTENT_ACTION_RENAME_FILENAME extra is null!!!");
                        return;
                    }
                    return;
                }
                String string = bundle2.getString("peerUin");
                int i3 = bundle.getInt("peerType");
                String string2 = bundle.getString("sourceStr");
                FileManagerDataCenter.this.s(string, i3, bundle.getString("filePath"), bundle.getLong("dataLength"), bundle.getInt("fileSourceId"), string2, bundle.getBundle("otherData"));
            }
        });
    }

    private TransFileInfo G(MessageRecord messageRecord) {
        TransFileInfo transFileInfo;
        EntityManager createEntityManager = this.f207331a.getEntityManagerFactory().createEntityManager();
        if (messageRecord != null && createEntityManager != null) {
            transFileInfo = (TransFileInfo) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) TransFileInfo.class, String.valueOf(messageRecord.time), String.valueOf(messageRecord.msgseq), this.f207331a.getCurrentAccountUin(), messageRecord.frienduin);
        } else {
            transFileInfo = null;
        }
        if (transFileInfo == null && messageRecord != null && QLog.isColorLevel()) {
            QLog.e("FileManagerDataCenter<FileAssistant>", 2, "get TransferInfo null, time[" + String.valueOf(messageRecord.time) + "],msgseq[" + String.valueOf(messageRecord.msgseq) + "],uin[" + this.f207331a.getCurrentAccountUin() + "], frienduin[" + messageRecord.frienduin + "]");
        }
        return transFileInfo;
    }

    public static void f(QQAppInterface qQAppInterface, String str, int i3, int i16) {
        for (MessageRecord messageRecord : qQAppInterface.getMessageFacade().Q(str, i3)) {
            if (i16 == messageRecord.msgtype) {
                if (i16 != -3011) {
                    if (i16 != -3010) {
                        switch (i16) {
                            case MessageRecord.MSG_TYPE_VIP_AIO_SEND_TIPS /* -4022 */:
                                qQAppInterface.getMessageFacade().A0(str, i3, i16, messageRecord.uniseq);
                                break;
                            case MessageRecord.MSG_TYPE_VIP_KEYWORD /* -4021 */:
                                qQAppInterface.getMessageFacade().A0(str, i3, i16, messageRecord.uniseq);
                                break;
                            case MessageRecord.MSG_TYPE_RENEWAL_TAIL_TIP /* -4020 */:
                                qQAppInterface.getMessageFacade().A0(str, i3, i16, messageRecord.uniseq);
                                break;
                            default:
                                qQAppInterface.getMessageFacade().A0(str, i3, i16, messageRecord.uniseq);
                                break;
                        }
                    } else {
                        qQAppInterface.getMessageFacade().A0(str, i3, i16, messageRecord.uniseq);
                    }
                } else if (!cooperation.qlink.b.f()) {
                    qQAppInterface.getMessageFacade().A0(str, i3, i16, messageRecord.uniseq);
                }
            }
        }
    }

    public void A() {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.core.FileManagerDataCenter.2

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.filemanager.core.FileManagerDataCenter$2$a */
            /* loaded from: classes12.dex */
            class a extends BroadcastReceiver {
                a() {
                }

                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    String action = intent.getAction();
                    if (action != null && action.equalsIgnoreCase("com.opensdk.downloadmanager.renameFilename")) {
                        FileManagerDataCenter.this.B(intent.getBundleExtra("extraBundle"));
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                QQAppInterface qQAppInterface = FileManagerDataCenter.this.f207331a;
                if (qQAppInterface != null && qQAppInterface.getApp() != null) {
                    if (FileManagerDataCenter.this.f207332b != null) {
                        FileManagerDataCenter.this.f207331a.getApp().unregisterReceiver(FileManagerDataCenter.this.f207332b);
                    }
                    if (FileManagerDataCenter.this.f207332b == null) {
                        FileManagerDataCenter.this.f207332b = new a();
                    }
                    FileManagerDataCenter.this.f207331a.getApp().registerReceiver(FileManagerDataCenter.this.f207332b, new IntentFilter("com.opensdk.downloadmanager.renameFilename"));
                    lc1.b.a();
                }
            }
        });
    }

    public FileManagerEntity C(long j3, String str, int i3, long j16) {
        FileManagerEntity fileManagerEntity;
        if (-1 != j16) {
            fileManagerEntity = this.f207331a.getFileManagerDataCenter().D(j16);
        } else {
            fileManagerEntity = null;
        }
        if (fileManagerEntity == null && j3 > 0) {
            fileManagerEntity = this.f207331a.getFileManagerDataCenter().E(j3, str, i3);
        }
        if (fileManagerEntity == null) {
            if (QLog.isColorLevel()) {
                QLog.e("FileManagerDataCenter<FileAssistant>", 2, "why sessionId[" + String.valueOf(j16) + "] and uniseq[" + String.valueOf(j3) + "] is wrong");
            }
            return null;
        }
        return fileManagerEntity;
    }

    public FileManagerEntity D(long j3) {
        if (j3 == -1) {
            QLog.e("FileManagerDataCenter<FileAssistant>", 1, "QueryFileEntityBySessionId nSessionId[" + j3 + "] is error");
            return null;
        }
        FileManagerProxy fileManagerProxy = this.f207331a.getFileManagerProxy();
        if (fileManagerProxy == null) {
            QLog.e("FileManagerDataCenter<FileAssistant>", 1, "QueryFileEntityBySessionId get FileManagerProxy null! nSessionId[" + j3 + "]");
            return null;
        }
        FileManagerEntity C = fileManagerProxy.C(j3);
        if (C != null) {
            fileManagerProxy.x(C);
            ((IQQFileSelectorUtil) QRoute.api(IQQFileSelectorUtil.class)).upDataApkPathForPackageName(C);
            return C;
        }
        FileManagerEntity fileManagerEntity = (FileManagerEntity) DBMethodProxy.find(this.f207331a.getEntityManagerFactory().createEntityManager(), (Class<? extends Entity>) FileManagerEntity.class, String.valueOf(j3));
        if (fileManagerEntity != null) {
            fileManagerProxy.x(fileManagerEntity);
            ((IQQFileSelectorUtil) QRoute.api(IQQFileSelectorUtil.class)).upDataApkPathForPackageName(fileManagerEntity);
            return fileManagerEntity;
        }
        QLog.e("FileManagerDataCenter<FileAssistant>", 1, "QueryFileEntityBySessionId get entry null! nSessionId[" + j3 + "]");
        return null;
    }

    public FileManagerEntity E(long j3, String str, int i3) {
        if (str == null) {
            QLog.e("FileManagerDataCenter<FileAssistant>", 1, "QueryFileEntityByUniseq  strUin is null, uniseq[" + j3 + "], peerType[" + i3 + "]");
            return null;
        }
        if (j3 <= 0) {
            QLog.e("FileManagerDataCenter<FileAssistant>", 1, "QueryFileEntityByUniseq uniseq[" + j3 + "] is error, strUin[" + FileManagerUtil.enCodecString(str) + "], peerType[" + i3 + "]");
            return null;
        }
        FileManagerProxy fileManagerProxy = this.f207331a.getFileManagerProxy();
        if (fileManagerProxy == null) {
            QLog.e("FileManagerDataCenter<FileAssistant>", 1, "QueryFileEntityByUniseq get FileManagerProxy null! strUin[" + FileManagerUtil.enCodecString(str) + "], uniseq[" + j3 + "], peerType[" + i3 + "]");
            return null;
        }
        FileManagerEntity D = fileManagerProxy.D(j3, str, i3);
        if (D != null) {
            ((IQQFileSelectorUtil) QRoute.api(IQQFileSelectorUtil.class)).upDataApkPathForPackageName(D);
            return D;
        }
        return fileManagerProxy.F(j3, str, i3);
    }

    public FileManagerEntity F(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.w("FileManagerDataCenter<FileAssistant>", 1, "queryFileEntityByUuid, invalid arguments");
            return null;
        }
        FileManagerProxy fileManagerProxy = this.f207331a.getFileManagerProxy();
        if (fileManagerProxy == null) {
            QLog.e("FileManagerDataCenter<FileAssistant>", 1, "queryFileEntityByUuid, get FileManagerProxy null");
            return null;
        }
        FileManagerEntity K = fileManagerProxy.K(str);
        if (K != null) {
            QLog.e("FileManagerDataCenter<FileAssistant>", 1, "queryFileEntityByUuid, found from Memory, uuid=" + str + ", sessionId=" + K.nSessionId);
            fileManagerProxy.x(K);
            return K;
        }
        FileManagerEntity fileManagerEntity = (FileManagerEntity) DBMethodProxy.find(this.f207331a.getEntityManagerFactory().createEntityManager(), FileManagerEntity.class, "Uuid = ?", new String[]{str});
        if (fileManagerEntity == null) {
            QLog.e("FileManagerDataCenter<FileAssistant>", 1, "queryFileEntityByUuid, not found, uuid=" + str);
            return null;
        }
        QLog.e("FileManagerDataCenter<FileAssistant>", 1, "queryFileEntityByUuid, found from DB, uuid=" + str + ", sessionId=" + fileManagerEntity.nSessionId);
        fileManagerProxy.x(fileManagerEntity);
        return fileManagerEntity;
    }

    public FileManagerEntity H(String str) {
        return this.f207331a.getFileManagerProxy().G(str);
    }

    public List<FileManagerEntity> I(String str, long j3) {
        return this.f207331a.getFileManagerProxy().L(str, j3);
    }

    public List<FileManagerEntity> J(int i3) {
        FileManagerProxy fileManagerProxy = this.f207331a.getFileManagerProxy();
        if (fileManagerProxy == null) {
            return new ArrayList();
        }
        return fileManagerProxy.M(i3);
    }

    public FileManagerEntity K(String str) {
        return this.f207331a.getFileManagerProxy().O(str);
    }

    public FileManagerEntity L(String str) {
        return this.f207331a.getFileManagerProxy().P(str);
    }

    public FileManagerEntity M(long j3) {
        return this.f207331a.getFileManagerProxy().C(j3);
    }

    public FileManagerEntity N(long j3, String str) {
        return this.f207331a.getFileManagerProxy().Q(j3, str);
    }

    public FileManagerEntity O(String str) {
        return this.f207331a.getFileManagerProxy().R(str);
    }

    public FileManagerEntity P(String str, long j3) {
        String str2;
        if (str == null || j3 <= 0) {
            return null;
        }
        FileManagerProxy fileManagerProxy = this.f207331a.getFileManagerProxy();
        String str3 = "FileManagerDataCenter<FileAssistant>";
        if (fileManagerProxy == null) {
            QLog.e("FileManagerDataCenter<FileAssistant>", 1, "QueryFileEntityByOLfileSessionId get FileManagerProxy null! nOLfileSessionId[" + j3 + "]");
            return null;
        }
        FileManagerEntity X = fileManagerProxy.X(str, j3);
        if (X != null) {
            return X;
        }
        String str4 = "select * from " + FileManagerEntity.tableName() + " where (nOLfileSessionId = " + j3 + " or (nSessionId = " + j3 + " and nOLfileSessionId = 0)) order by srvTime desc";
        EntityManager createEntityManager = this.f207331a.getEntityManagerFactory().createEntityManager();
        List<Entity> rawQuery = DBMethodProxy.rawQuery(createEntityManager, FileManagerEntity.class, str4, null);
        if (rawQuery != null && rawQuery.size() > 0) {
            Iterator<Entity> it = rawQuery.iterator();
            while (it.hasNext()) {
                FileManagerEntity fileManagerEntity = (FileManagerEntity) it.next();
                if (str.equalsIgnoreCase(fileManagerEntity.peerUin)) {
                    long j16 = fileManagerEntity.nOLfileSessionId;
                    str2 = str3;
                    if (j3 == j16 || (j3 == fileManagerEntity.nSessionId && 0 == j16)) {
                        X = fileManagerEntity;
                        break;
                    }
                } else {
                    str2 = str3;
                }
                str3 = str2;
            }
        }
        str2 = str3;
        if (X != null && 0 == X.nOLfileSessionId) {
            QLog.i(str2, 1, "QueryOLfileSessionEntity find a old ver data. nOLfileSessionId[" + j3 + "]");
            X.nOLfileSessionId = j3;
            f0(X);
        }
        createEntityManager.close();
        return X;
    }

    public void Q(f fVar) {
        QLog.d("FileManagerDataCenter<FileAssistant>", 1, "regTmpController" + fVar.getClass().getName());
        this.f207333c = fVar;
    }

    public synchronized void R(long j3) {
        this.f207331a.getFileManagerProxy().Y(j3);
    }

    public void S(boolean z16, int i3, String str, String str2, boolean z17, String str3, long j3) {
        FileManagerEntity D = this.f207331a.getFileManagerDataCenter().D(j3);
        if (D == null) {
            if (QLog.isColorLevel()) {
                QLog.e("FileManagerDataCenter<FileAssistant>", 2, "Save of2of [" + String.valueOf(z16) + "],query FileManagerEntity renturn null, SessionId[" + String.valueOf(j3) + "], ");
                return;
            }
            return;
        }
        if (z16) {
            D.lastTime = (com.tencent.mobileqq.service.message.e.K0() * 1000) + 604800000;
            D.isReaded = false;
            D.bSend = true;
            D.status = 1;
            D.fProgress = 0.0f;
            D.Uuid = str2;
            D.bUseMediaPlatform = z17;
            D.fileIdCrc = str3;
            this.f207331a.getFileManagerDataCenter().f0(D);
            D.status = 2;
            this.f207331a.getFileManagerDataCenter().c0();
            FileManagerUtil.addCloseButtonSessionId(D.nSessionId);
            this.f207331a.getFileManagerNotifyCenter().a(D, 6, "");
            this.f207331a.getFileTransferHandler().i1(D.peerUin, D, null);
            return;
        }
        this.f207331a.getFileManagerNotifyCenter().c(D.uniseq, D.nSessionId, D.peerUin, D.peerType, 15, null, i3, str);
        D.isReaded = false;
        D.status = 0;
        if (i3 == -6101 || i3 == -7003) {
            D.status = 16;
            Object obj = D.mContext;
            if (obj != null && (obj instanceof FileManagerEntity)) {
                FileManagerEntity fileManagerEntity = (FileManagerEntity) obj;
                fileManagerEntity.status = 16;
                this.f207331a.getFileManagerDataCenter().f0(fileManagerEntity);
                D.mContext = null;
            }
        }
        this.f207331a.getFileManagerDataCenter().f0(D);
        this.f207331a.getFileManagerDataCenter().c0();
        FileManagerUtil.reportFilemanagerFaildInfo(this.f207331a, D.nSessionId, "actFileOf2Of", 0L, "", "", D.peerUin, D.Uuid, i3, str, 0L, 0L, 0L, "", "", 0, str, null);
    }

    public Map<String, List<FileManagerEntity>> T(String str) {
        return this.f207331a.getFileManagerProxy().I(str);
    }

    public List<FileManagerEntity> U(String str, String str2, boolean z16) {
        return this.f207331a.getFileManagerProxy().H(str, str2, z16);
    }

    public List<FileManagerEntity> V(List<Integer> list, String str) {
        return this.f207331a.getFileManagerProxy().N(list, str);
    }

    public List<FileManagerEntity> W(List<Integer> list, String str) {
        return this.f207331a.getFileManagerProxy().J(list, str);
    }

    public synchronized boolean X(FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity == null) {
            if (QLog.isColorLevel()) {
                QLog.e("FileManagerDataCenter<FileAssistant>", 2, "setAioDelete FileManagerEntity is null!!!");
            }
            return false;
        }
        fileManagerEntity.bDelInAio = true;
        fileManagerEntity.uniseq = -1L;
        return this.f207331a.getFileManagerProxy().o(fileManagerEntity, true);
    }

    public void Y(String str, int i3) {
        this.f207331a.getFileManagerProxy().p(str, i3);
    }

    public synchronized boolean Z(FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity == null) {
            if (QLog.isColorLevel()) {
                QLog.e("FileManagerDataCenter<FileAssistant>", 2, "setFMDelete FileManagerEntity is null!!!");
            }
            return false;
        }
        fileManagerEntity.bDelInFM = true;
        return this.f207331a.getFileManagerProxy().o(fileManagerEntity, true);
    }

    public boolean a0(long j3, int i3) {
        MessageRecord messageRecord;
        FileManagerEntity D = D(j3);
        if (D == null) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FileManagerDataCenter<FileAssistant>", 2, "strUin[" + FileManagerUtil.enCodecString(D.peerUin) + "], peeryType[" + String.valueOf(D.peerType) + "], uniseq[" + String.valueOf(D.uniseq) + "]");
        }
        if (-1 != D.uniseq) {
            messageRecord = this.f207331a.getMessageFacade().w0(D.peerUin, D.peerType, D.uniseq);
        } else {
            messageRecord = null;
        }
        EntityManager createEntityManager = this.f207331a.getEntityManagerFactory().createEntityManager();
        TransFileInfo G = G(messageRecord);
        if (createEntityManager == null || G == null) {
            return false;
        }
        G.status = i3;
        createEntityManager.update(G);
        return true;
    }

    public void b0(long j3, String str) {
        FileManagerEntity D = D(j3);
        if (D == null) {
            if (QLog.isColorLevel()) {
                QLog.w("FileManagerDataCenter<FileAssistant>", 2, "sessionnid[" + String.valueOf(j3) + "] item is not exist!may be is deleted!");
                return;
            }
            return;
        }
        this.f207331a.getFileManagerProxy().b0(D, str);
    }

    public void c0() {
        this.f207331a.getFileManagerNotifyCenter().b(true, 0, null);
    }

    public synchronized void d(long j3) {
        if (this.f207334d == null) {
            this.f207334d = new ArrayList();
        }
        this.f207334d.add(Long.valueOf(j3));
    }

    public boolean d0(String str, int i3, long j3) {
        if (QLog.isColorLevel()) {
            QLog.d("FileManagerDataCenter<FileAssistant>", 2, "SetRead: strUin[" + FileManagerUtil.enCodecString(str) + "], peeryType[" + i3 + "], uniseq[" + j3 + "]");
        }
        MessageRecord w06 = this.f207331a.getMessageFacade().w0(str, i3, j3);
        if (w06 != null) {
            w06.isread = true;
            return true;
        }
        return false;
    }

    public void e(long j3, String str) {
        this.f207331a.getFileManagerProxy().i(j3, str);
    }

    public void e0() {
        this.f207331a.getFileManagerProxy().c0();
    }

    public void f0(FileManagerEntity fileManagerEntity) {
        this.f207331a.getFileManagerProxy().e0(fileManagerEntity);
    }

    public void g() {
        this.f207331a.getFileManagerProxy().l();
    }

    public void g0(long j3, String str, int i3, long j16) {
        FileManagerEntity C = C(j3, str, i3, -1L);
        if (C == null) {
            if (QLog.isColorLevel()) {
                QLog.e("FileManagerDataCenter<FileAssistant>", 2, "updateFileManagerTime error, entity is null,uinseq[" + String.valueOf(j3) + "], frienduin[" + String.valueOf(str) + "], istroop[" + String.valueOf(i3) + "], time[" + String.valueOf(j16) + "]");
                return;
            }
            return;
        }
        C.srvTime = j16 * 1000;
        f0(C);
        this.f207331a.getFileManagerNotifyCenter().b(true, 3, null);
    }

    public long h(int i3, long j3, long j16, long j17, long j18) {
        return this.f207331a.getFileManagerProxy().q(i3, j3, j16, j17, j18);
    }

    public FileManagerEntity i(long j3, String str, int i3) {
        FileManagerProxy fileManagerProxy = this.f207331a.getFileManagerProxy();
        if (fileManagerProxy == null) {
            return null;
        }
        if (j3 > 0) {
            FileManagerEntity D = fileManagerProxy.D(j3, str, i3);
            if (D != null) {
                QLog.i("FileManagerDataCenter<FileAssistant>", 1, "getFileEntityByUniseq for memory, FileManagerEntity exist, sessionId[" + String.valueOf(D.nSessionId) + "], uniseq[" + String.valueOf(D.uniseq) + "], strUin[" + FileManagerUtil.enCodecString(D.peerUin) + "], peerType[" + String.valueOf(D.peerType) + "]");
                return D;
            }
            FileManagerEntity F = fileManagerProxy.F(j3, str, i3);
            if (F != null) {
                QLog.i("FileManagerDataCenter<FileAssistant>", 1, "getFileEntityByUniseq for db, FileManagerEntity exist, sessionId[" + String.valueOf(F.nSessionId) + "], uniseq[" + String.valueOf(F.uniseq) + "], strUin[" + FileManagerUtil.enCodecString(F.peerUin) + "], peerType[" + String.valueOf(F.peerType) + "]");
                return F;
            }
        }
        FileManagerEntity fileManagerEntity = new FileManagerEntity();
        fileManagerEntity.nSessionId = FileManagerUtil.genSessionId().longValue();
        fileManagerEntity.uniseq = j3;
        fileManagerEntity.peerUin = str;
        fileManagerEntity.peerType = i3;
        fileManagerEntity.selfUin = this.f207331a.getAccount();
        fileManagerEntity.isReaded = false;
        this.f207331a.getFileManagerProxy().x(fileManagerEntity);
        QLog.i("FileManagerDataCenter<FileAssistant>", 1, "getFileEntityByUniseq, new a FileManagerEntity, sessionId[" + String.valueOf(fileManagerEntity.nSessionId) + "], uniseq[" + String.valueOf(j3) + "], strUin[" + FileManagerUtil.enCodecString(str) + "], peerType[" + String.valueOf(i3) + "]");
        return fileManagerEntity;
    }

    public FileManagerEntity j(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            QLog.w("FileManagerDataCenter<FileAssistant>", 1, "getFileEntityByUuid, invalid arguments");
            return null;
        }
        FileManagerProxy fileManagerProxy = this.f207331a.getFileManagerProxy();
        if (fileManagerProxy == null) {
            QLog.e("FileManagerDataCenter<FileAssistant>", 1, "getFileEntityByUuid, get FileManagerProxy null");
            return null;
        }
        FileManagerEntity fileManagerEntity = (FileManagerEntity) DBMethodProxy.find(this.f207331a.getEntityManagerFactory().createEntityManager(), FileManagerEntity.class, "Uuid = ? AND peerType = ?", new String[]{str, String.valueOf(i3)});
        if (fileManagerEntity == null) {
            QLog.e("FileManagerDataCenter<FileAssistant>", 1, "getFileEntityByUuid, not found, uuid=" + str + ", peerType=" + i3);
            return null;
        }
        QLog.e("FileManagerDataCenter<FileAssistant>", 1, "getFileEntityByUuid, found, uuid=" + str + ", peerType=" + i3 + ", sessionId=" + fileManagerEntity.nSessionId);
        fileManagerProxy.x(fileManagerEntity);
        return fileManagerEntity;
    }

    public long k(String str, long j3, long j16, int i3) {
        MessageRecord messageRecord;
        TransFileInfo transFileInfo;
        long j17 = 0;
        if (j3 <= 0) {
            return 0L;
        }
        EntityManager createEntityManager = this.f207331a.getEntityManagerFactory().createEntityManager();
        if (QLog.isColorLevel()) {
            QLog.d("FileManagerDataCenter<FileAssistant>", 2, "strUin[" + FileManagerUtil.enCodecString(str) + "], peeryType[" + String.valueOf(i3) + "], uniseq[" + String.valueOf(j16) + "]");
        }
        if (j16 > 0) {
            messageRecord = this.f207331a.getMessageFacade().w0(str, i3, j16);
        } else {
            messageRecord = null;
        }
        if (messageRecord != null && (transFileInfo = (TransFileInfo) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) TransFileInfo.class, String.valueOf(messageRecord.time), String.valueOf(messageRecord.msgseq), this.f207331a.getCurrentAccountUin(), str)) != null) {
            j17 = (transFileInfo.transferedSize * 100) / j3;
        }
        createEntityManager.close();
        return j17;
    }

    public f l() {
        if (this.f207333c == null) {
            QLog.e("FileManagerDataCenter<FileAssistant>", 1, "getTmpController mTmpController is null");
        } else {
            QLog.d("FileManagerDataCenter<FileAssistant>", 1, "getTmpController " + this.f207333c.getClass().getName());
        }
        f fVar = this.f207333c;
        this.f207333c = null;
        return fVar;
    }

    public FileManagerEntity m(String str) {
        return this.f207331a.getFileManagerProxy().v(str);
    }

    public long n(String str, String str2, int i3, int i16, String str3) {
        return o(str, str2, i3, i16, null, str3, -1L, -1L, -1L);
    }

    public long o(String str, String str2, int i3, int i16, Map<String, String> map, String str3, long j3, long j16, long j17) {
        long j18;
        MessageRecord d16 = q.d(i16);
        d16.selfuin = this.f207331a.getCurrentAccountUin();
        d16.frienduin = str;
        d16.senderuin = str2;
        d16.f203106msg = str3;
        d16.msgtype = i16;
        d16.isread = true;
        d16.issend = str2.equals(this.f207331a.getAccount()) ? 1 : 0;
        d16.istroop = i3;
        if (j16 > 0) {
            j18 = j16;
        } else {
            int i17 = MobileQQServiceBase.seq;
            MobileQQServiceBase.seq = i17 + 1;
            j18 = i17;
        }
        d16.msgseq = j18;
        if (j16 <= 0) {
            j16 = Math.abs(new Random().nextInt());
        }
        d16.shmsgseq = j16;
        if (j3 <= 0) {
            j3 = FileManagerUtil.genMsgUid();
        }
        d16.msgUid = j3;
        if (j17 <= 0) {
            j17 = com.tencent.mobileqq.service.message.e.K0();
        }
        d16.time = j17;
        if (map != null && map.size() > 0) {
            for (String str4 : map.keySet()) {
                d16.saveExtInfoToExtStr(str4, map.get(str4));
            }
        }
        d16.extraflag |= -32769;
        this.f207331a.getMessageFacade().c(d16, this.f207331a.getCurrentAccountUin());
        QLog.i("FileManagerDataCenter<FileAssistant>", 1, "Inser msg to AIO, msgInfo: mrUinseq[" + String.valueOf(d16.uniseq) + "], selfuin[" + FileManagerUtil.enCodecString(d16.selfuin) + "], frienduin[" + FileManagerUtil.enCodecString(d16.frienduin) + "], senderuin[" + FileManagerUtil.enCodecString(d16.senderuin) + "], issend[" + String.valueOf(d16.issend) + "], istroop[" + String.valueOf(d16.istroop) + "], shmsgseq[" + String.valueOf(d16.shmsgseq) + "], msgUid[" + String.valueOf(d16.msgUid) + "], time[" + String.valueOf(d16.time) + "], msgtype[" + String.valueOf(str3) + "]");
        return d16.uniseq;
    }

    public long p(String str, String str2, boolean z16, String str3, long j3, boolean z17, int i3, String str4, long j16, long j17, long j18, long j19, long j26) {
        return q(str, str2, z16, str3, j3, z17, i3, str4, j16, j17, j18, j19, j26, -1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public long q(String str, String str2, boolean z16, String str3, long j3, boolean z17, int i3, String str4, long j16, long j17, long j18, long j19, long j26, int i16, Bundle bundle) {
        String makeTransFileProtocolData;
        MessageRecord d16 = q.d(-2005);
        d16.uniseq = j17;
        d16.selfuin = this.f207331a.getCurrentAccountUin();
        d16.frienduin = str;
        d16.senderuin = str2;
        if (str4 == null || str4.length() < 1) {
            makeTransFileProtocolData = TransfileUtile.makeTransFileProtocolData(str3, j3, 0, z17);
            d16 = d16;
        } else {
            makeTransFileProtocolData = str4;
        }
        d16.f203106msg = makeTransFileProtocolData;
        d16.msgtype = -2005;
        d16.isread = z17;
        d16.issend = z16 ? 1 : 0;
        d16.istroop = i3;
        d16.msgseq = j16;
        d16.shmsgseq = s.b(j16, i3);
        d16.msgUid = j18 == 0 ? s.f(s.a()) : j18;
        d16.time = j26;
        if (i3 == 3000) {
            d16.shmsgseq = this.f207331a.getMessageFacade().getLastMessage(str, i3).shmsgseq;
        }
        if (d16.isSend()) {
            ((ISVIPHandler) this.f207331a.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).addSendingBubbleId(d16);
        } else if (j19 != -1) {
            d16.vipBubbleID = j19;
        } else {
            d16.vipBubbleID = com.tencent.imcore.message.facade.i.a(this.f207331a, str);
        }
        if (!z16) {
            d16.saveExtInfoToExtStr("dataline_msg_device_type", "65793");
        }
        d16.vipBubbleDiyTextId = i16;
        MessageForFile messageForFile = (MessageForFile) d16;
        if (TextUtils.isEmpty(messageForFile.fileName)) {
            messageForFile.fileName = FileManagerUtil.getFileName(str3);
        }
        com.tencent.mobileqq.filemanager.util.k.b(d16, bundle);
        this.f207331a.getMessageFacade().c(d16, this.f207331a.getCurrentAccountUin());
        FileManagerUtil.updateBatProcessTips(this.f207331a, str2, str, i3);
        QLog.i("FileManagerDataCenter<FileAssistant>", 1, "Inser msg to AIO, msgInfo: mrUinseq[" + String.valueOf(d16.uniseq) + "], selfuin[" + FileManagerUtil.enCodecString(d16.selfuin) + "], frienduin[" + FileManagerUtil.enCodecString(d16.frienduin) + "], senderuin[" + FileManagerUtil.enCodecString(d16.senderuin) + "], issend[" + String.valueOf(d16.issend) + "], istroop[" + String.valueOf(d16.istroop) + "], shmsgseq[" + String.valueOf(d16.shmsgseq) + "], msgUid[" + String.valueOf(d16.msgUid) + "], time[" + String.valueOf(d16.time) + "], vipBubbleID[" + String.valueOf(j19) + "], vipBubbleDiyTextID[" + String.valueOf(i16) + "]");
        return d16.uniseq;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MessageRecord r(String str, String str2, boolean z16, int i3, FileManagerEntity fileManagerEntity) {
        MessageRecord d16 = q.d(-2005);
        d16.uniseq = fileManagerEntity.uniseq;
        d16.selfuin = this.f207331a.getCurrentAccountUin();
        d16.frienduin = str;
        d16.senderuin = str2;
        d16.f203106msg = TransfileUtile.makeTransFileProtocolData(fileManagerEntity.strFilePath, fileManagerEntity.fileSize, 0, true);
        d16.msgtype = -2005;
        d16.isread = true;
        d16.issend = z16 ? 1 : 0;
        int i16 = fileManagerEntity.peerType;
        d16.istroop = i16;
        long j3 = fileManagerEntity.msgSeq;
        d16.msgseq = j3;
        d16.shmsgseq = s.b(j3, i16);
        long j16 = fileManagerEntity.msgUid;
        if (j16 == 0) {
            j16 = s.f(s.a());
        }
        d16.msgUid = j16;
        d16.time = fileManagerEntity.msgTime;
        if (fileManagerEntity.peerType == 3000) {
            d16.shmsgseq = this.f207331a.getMessageFacade().getLastMessage(str, fileManagerEntity.peerType).shmsgseq;
        }
        if (d16.isSend()) {
            ((ISVIPHandler) this.f207331a.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).addSendingBubbleId(d16);
        } else {
            d16.vipBubbleID = com.tencent.imcore.message.facade.i.a(this.f207331a, str);
        }
        d16.vipBubbleDiyTextId = -1;
        ((MessageForFile) d16).fileName = fileManagerEntity.fileName;
        d16.saveExtInfoToExtStr("dataline_msg_device_type", i3 + "");
        this.f207331a.getMessageFacade().c(d16, this.f207331a.getCurrentAccountUin());
        FileManagerUtil.updateBatProcessTips(this.f207331a, str2, str, fileManagerEntity.peerType);
        if (QLog.isColorLevel()) {
            QLog.i("FileManagerDataCenter<FileAssistant>", 1, "Inser msg to AIO, msgInfo: mrUinseq[" + String.valueOf(d16.uniseq) + "], sessionid[" + fileManagerEntity.nSessionId + "], fileName[" + fileManagerEntity.fileName + "], frienduin[" + FileManagerUtil.enCodecString(d16.frienduin) + "], senderuin[" + FileManagerUtil.enCodecString(d16.senderuin) + "], issend[" + String.valueOf(d16.issend) + "], shmsgseq[" + String.valueOf(d16.shmsgseq) + "], msgUid[" + String.valueOf(d16.msgUid) + "], time[" + String.valueOf(d16.time) + "]");
        }
        return d16;
    }

    public synchronized int s(String str, int i3, String str2, long j3, int i16, String str3, Bundle bundle) {
        if (str2 == null) {
            if (QLog.isColorLevel()) {
                QLog.e("FileManagerDataCenter<FileAssistant>", 2, " insertExternalFileToFM. sourceId:" + i16);
            }
            return -1;
        }
        if (QLog.isColorLevel()) {
            QLog.i("FileManagerDataCenter<FileAssistant>", 2, " insertExternalFileToFM. filePath:" + str2 + " size:" + j3 + " sourceId:" + i16);
        }
        if (this.f207331a == null) {
            if (QLog.isColorLevel()) {
                QLog.e("FileManagerDataCenter<FileAssistant>", 2, " insertExternalFileToFM. but app = null");
            }
            return -2;
        }
        long j16 = q.d(-1000).uniseq;
        FileManagerDataCenter fileManagerDataCenter = this.f207331a.getFileManagerDataCenter();
        String str4 = AppConstants.FM_EXTERNAL_SAVEFILE_UIN;
        FileManagerEntity i17 = fileManagerDataCenter.i(j16, str4, 0);
        if (i17 == null) {
            if (QLog.isColorLevel()) {
                QLog.e("FileManagerDataCenter<FileAssistant>", 2, " insertExternalFileToFM. but entry = null");
            }
            return -3;
        }
        i17.setCloudType(3);
        i17.fileName = FileManagerUtil.getFileName(str2);
        if (0 == j3) {
            i17.fileSize = FileManagerUtil.getFileSizes(str2);
        } else {
            i17.fileSize = j3;
        }
        i17.setFilePath(str2);
        i17.nOpType = i16;
        i17.peerNick = null;
        i17.peerType = 0;
        i17.peerUin = str4;
        i17.srvTime = com.tencent.mobileqq.service.message.e.K0() * 1000;
        i17.status = 1;
        i17.Uuid = null;
        i17.isReaded = true;
        i17.bSend = false;
        if (bundle != null) {
            if (bundle.getBoolean("FILE_TMP_IS_ZIPINNER_FILE")) {
                String string = bundle.getString("FILE_TMP_SERVER_PATH");
                String string2 = bundle.getString("FILE_TMP_DIR_PATH");
                long j17 = bundle.getLong("FILE_TMP_RELATED_ID");
                String string3 = bundle.getString("FILE_TMP_ZIP_FILEID");
                i17.isZipInnerFile = true;
                i17.nRelatedSessionId = j17;
                i17.zipInnerPath = string2;
                i17.strServerPath = string;
                i17.zipFileId = string3;
                this.f207331a.getFileManagerProxy().y(i17);
            } else {
                String string4 = bundle.getString("FILE_TMP_SERVER_PATH");
                if (!TextUtils.isEmpty(string4)) {
                    i17.status = 1;
                    i17.strServerPath = string4;
                    i17.bDelInAio = true;
                }
                int i18 = bundle.getInt("FILE_FROM", -1);
                if (i18 != -1) {
                    i17.nOpType = i18;
                }
            }
        }
        this.f207331a.getFileManagerDataCenter().t(i17);
        FileManagerUtil.addExternalFileToFMRecv(str2);
        return 0;
    }

    public synchronized void t(FileManagerEntity fileManagerEntity) {
        FileManagerProxy fileManagerProxy = this.f207331a.getFileManagerProxy();
        if (fileManagerProxy == null) {
            QLog.e("FileManagerDataCenter<FileAssistant>", 1, "insertToFMList get FileManagerProxy null! nSessionId[" + fileManagerEntity.nSessionId + "], uniseq[" + fileManagerEntity.uniseq + "], peerUin[" + FileManagerUtil.enCodecString(fileManagerEntity.peerUin) + "]");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("FileManagerDataCenter<FileAssistant>", 2, "insert FM List:" + FileManagerUtil.printFileManagerEntityInfo(fileManagerEntity));
        }
        fileManagerProxy.g(fileManagerEntity);
        this.f207331a.getFileManagerNotifyCenter().b(true, 3, null);
    }

    public synchronized void u(FileManagerEntity fileManagerEntity) {
        FileManagerProxy fileManagerProxy = this.f207331a.getFileManagerProxy();
        if (fileManagerProxy == null) {
            QLog.e("FileManagerDataCenter<FileAssistant>", 1, "insertToFMListAddOrReplaceDB get FileManagerProxy null! nSessionId[" + fileManagerEntity.nSessionId + "], uniseq[" + fileManagerEntity.uniseq + "], peerUin[" + FileManagerUtil.enCodecString(fileManagerEntity.peerUin) + "]");
            return;
        }
        if (((FileManagerEntity) DBMethodProxy.find(this.f207331a.getEntityManagerFactory().createEntityManager(), (Class<? extends Entity>) FileManagerEntity.class, String.valueOf(fileManagerEntity.nSessionId))) == null) {
            fileManagerProxy.g(fileManagerEntity);
        } else {
            fileManagerProxy.w(fileManagerEntity);
            fileManagerProxy.g0(fileManagerEntity);
        }
    }

    public void v(FileManagerEntity fileManagerEntity) {
        this.f207331a.getFileManagerProxy().x(fileManagerEntity);
    }

    public boolean w(long j3) {
        return this.f207331a.getFileManagerProxy().z(j3);
    }

    public boolean x(String str, long j3) {
        return this.f207331a.getFileManagerProxy().A(str, j3);
    }

    public synchronized boolean y(long j3) {
        if (this.f207334d == null) {
            this.f207334d = new ArrayList();
        }
        return this.f207334d.contains(Long.valueOf(j3));
    }

    public void z() {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.core.FileManagerDataCenter.4
            @Override // java.lang.Runnable
            public void run() {
                QQAppInterface qQAppInterface = FileManagerDataCenter.this.f207331a;
                if (qQAppInterface != null && qQAppInterface.getApp() != null && FileManagerDataCenter.this.f207332b != null) {
                    try {
                        FileManagerDataCenter.this.f207331a.getApp().unregisterReceiver(FileManagerDataCenter.this.f207332b);
                    } catch (IllegalArgumentException e16) {
                        QLog.d("FileManagerDataCenter<FileAssistant>", 1, e16, new Object[0]);
                    }
                }
                FileManagerDataCenter.this.f207332b = null;
            }
        });
    }
}
