package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.data.VideoForC2C;
import com.tencent.mobileqq.filemanager.nt.NTFileUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.guild.temp.api.IGuildFileTempApi;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.weiyun.api.IOpenWeiyunVipHelper;
import com.tencent.mobileqq.weiyun.api.IWeiyunUploadDownloadService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* compiled from: P */
/* loaded from: classes12.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    QQAppInterface f207645a;

    /* renamed from: b, reason: collision with root package name */
    private FMObserver f207646b = new a();

    /* renamed from: c, reason: collision with root package name */
    private LinkedHashMap<Long, vb1.b> f207647c = new LinkedHashMap<>();

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends FMObserver {
        a() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void S(boolean z16, long j3, long j16, String str, int i3, int i16, String str2) {
            if (QLog.isColorLevel()) {
                QLog.d("FileManagerRSCenter<FileAssistant>", 2, "recive TransferEnd, rmove task[" + String.valueOf(j16) + "]!");
            }
            ((IOpenWeiyunVipHelper) QRoute.api(IOpenWeiyunVipHelper.class)).showWeiYunSpaceOrFlowLimitDialog(null, i16);
            FileManagerEntity D = e.this.f207645a.getFileManagerDataCenter().D(j16);
            if (D != null && D.nOpType == 50) {
                Bundle bundle = new Bundle();
                bundle.putString(MiniAppGetGameTaskTicketServlet.KEY_TASKID, D.miniAppDownloadId);
                bundle.putInt("retCode", z16 ? 1 : 0);
                if (str2 == null) {
                    str2 = "";
                }
                bundle.putString("retMsg", str2);
                QIPCServerHelper.getInstance().callClient(((IWeiyunUploadDownloadService) QRoute.api(IWeiyunUploadDownloadService.class)).getWeiyunMiniappProcessName(), "Module_WeiyunDownloadClient", "WeiyunDownloadClientIPC_Action__Complete", bundle, null);
            }
            e.this.i(j16);
        }
    }

    public e(QQAppInterface qQAppInterface) {
        this.f207645a = qQAppInterface;
        qQAppInterface.getFileManagerNotifyCenter().addObserver(this.f207646b);
    }

    public synchronized long a(String str, long j3, long j16, int i3) {
        vb1.b bVar;
        FileManagerEntity E = this.f207645a.getFileManagerDataCenter().E(j16, str, i3);
        if (E != null && (bVar = this.f207647c.get(Long.valueOf(E.nSessionId))) != null) {
            return bVar.getProgress();
        }
        return this.f207645a.getFileManagerDataCenter().k(str, j3, j16, i3);
    }

    public synchronized boolean b(String str) {
        if (this.f207647c.size() < 1) {
            return false;
        }
        Iterator<Long> it = this.f207647c.keySet().iterator();
        while (it.hasNext()) {
            FileManagerEntity W = this.f207647c.get(it.next()).W();
            if (W.getFilePath() != null && W.getFilePath().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public synchronized FileManagerEntity c(String str) {
        if (this.f207647c.size() < 1) {
            return null;
        }
        Iterator<Long> it = this.f207647c.keySet().iterator();
        while (it.hasNext()) {
            vb1.b bVar = this.f207647c.get(it.next());
            if (str.equalsIgnoreCase(bVar.getFileId())) {
                return bVar.W();
            }
        }
        return null;
    }

    public synchronized FileManagerEntity d(String str, String str2) {
        if (this.f207647c.size() < 1) {
            return null;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Iterator<Long> it = this.f207647c.keySet().iterator();
            while (it.hasNext()) {
                vb1.b bVar = this.f207647c.get(it.next());
                FileManagerEntity W = bVar.W();
                if (str.equalsIgnoreCase((String) W.mContext) && str2.equals(W.zipInnerPath)) {
                    return bVar.W();
                }
            }
            return null;
        }
        return null;
    }

    public synchronized int e(long j3, String str, int i3, long j16) {
        vb1.b bVar = this.f207647c.get(Long.valueOf(j16));
        if (bVar != null) {
            return bVar.getStatus();
        }
        FileManagerEntity C = this.f207645a.getFileManagerDataCenter().C(j3, str, i3, j16);
        if (C == null) {
            return -1;
        }
        if (this.f207647c.get(Long.valueOf(C.nSessionId)) != null) {
            return C.status;
        }
        if (!com.tencent.mobileqq.filemanager.fileassistant.util.h.k(C.peerUin)) {
            return -1;
        }
        return C.status;
    }

    public synchronized void f(FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity == null) {
            QLog.e("FileManagerRSCenter<FileAssistant>", 1, "entry is null, retry ge mao!");
            return;
        }
        vb1.b bVar = this.f207647c.get(Long.valueOf(fileManagerEntity.nSessionId));
        if (bVar != null && !bVar.a()) {
            QLog.i("FileManagerRSCenter<FileAssistant>", 1, "uniseq[ " + String.valueOf(fileManagerEntity.uniseq) + " ],sessionid[ " + String.valueOf(fileManagerEntity.nSessionId) + " ] work,is procressing!");
            return;
        }
        int i3 = fileManagerEntity.nOpType;
        if (i3 != 1 && i3 != 8 && i3 != 50 && i3 != 5) {
            if (i3 != 6) {
                if (i3 != 53 && i3 != 54) {
                    QLog.e("FileManagerRSCenter<FileAssistant>", 1, "Unknow actionType!" + fileManagerEntity.nOpType);
                }
            } else {
                k(fileManagerEntity, null);
            }
        }
        h(fileManagerEntity);
    }

    public void g(long j3, long j16, String str, int i3, int i16) {
        String str2;
        int i17;
        com.tencent.mobileqq.filemanager.fileviewer.data.b videoForC2C;
        FileManagerEntity D = this.f207645a.getFileManagerDataCenter().D(j3);
        if (D != null) {
            QLog.e("FileManagerRSCenter<FileAssistant>", 1, "recvFile1 entity: " + D.hashCode());
        }
        if (D == null) {
            D = this.f207645a.getFileManagerDataCenter().E(j16, str, i3);
        }
        if (D != null) {
            QLog.e("FileManagerRSCenter<FileAssistant>", 1, "recvFile2 entity: " + D.hashCode());
        }
        if (D == null) {
            QLog.e("FileManagerRSCenter<FileAssistant>", 1, "=_= v! entity is null ,why you can choose!!!");
            return;
        }
        int i18 = D.cloudType;
        if (i18 == 2 || i18 == 0 || i18 == 12) {
            str2 = "=_= v! entity[";
        } else if (!q.f(D.getFilePath())) {
            str2 = "=_= v! entity[";
            if (TextUtils.isEmpty(D.Uuid) && !D.isZipInnerFile && D.ntChatType != 8) {
                FileManagerUtil.dealWithErrCode(BaseApplication.getContext().getString(R.string.bet));
                D.status = 16;
                this.f207645a.getFileManagerDataCenter().f0(D);
                this.f207645a.getFileManagerNotifyCenter().c(D.uniseq, D.nSessionId, D.peerUin, D.peerType, 12, null, 6, "");
                this.f207645a.getFileManagerNotifyCenter().b(true, 3, null);
                QLog.e("FileManagerRSCenter<FileAssistant>", 1, str2 + D.nSessionId + "] uuid null, but not Zipfile, set invalid!");
                return;
            }
        } else {
            D.status = 1;
            D.cloudType = 3;
            this.f207645a.getFileManagerDataCenter().f0(D);
            this.f207645a.getFileManagerNotifyCenter().c(D.uniseq, D.nSessionId, D.peerUin, D.peerType, 11, new Object[]{D.getFilePath(), "", Long.valueOf(D.fileSize), Boolean.TRUE, "", ""}, 0, null);
            this.f207645a.getFileManagerNotifyCenter().b(true, 3, null);
            QLog.e("FileManagerRSCenter<FileAssistant>", 1, "=_= v! entity[" + D.nSessionId + "] local existed so notify Success");
            this.f207645a.getNTFileManageBridger().M0(D, 4);
            return;
        }
        if (D.nFileType == 2 && !D.isZipInnerFile && !D.videoDownloadForceThroughNT && D.cloudType != 2 && ((i17 = D.peerType) == 3000 || i17 == 0)) {
            D.nOpType = 8;
            QLog.e("FileManagerRSCenter<FileAssistant>", 1, "=_= v> entity[" + D.nSessionId + "] is video, start init video sdk");
            if (D.getCloudType() == 12) {
                videoForC2C = (com.tencent.mobileqq.filemanager.fileviewer.data.b) ((IGuildFileTempApi) QRoute.api(IGuildFileTempApi.class)).getNewVideoForGuild(this.f207645a, D);
            } else if (D.peerType == 3000) {
                videoForC2C = new com.tencent.mobileqq.filemanager.fileviewer.data.g(this.f207645a, D);
            } else {
                videoForC2C = new VideoForC2C(this.f207645a, D);
            }
            g.b(videoForC2C).startDownload();
            this.f207645a.getFileManagerNotifyCenter().b(true, 3, null);
            return;
        }
        D.nOpType = i16;
        if (this.f207647c.containsKey(Long.valueOf(j3))) {
            QLog.e("FileManagerRSCenter<FileAssistant>", 1, str2 + j3 + "] is processing");
            return;
        }
        QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "recvFile recvFile");
        h(D);
    }

    public void h(FileManagerEntity fileManagerEntity) {
        vb1.b fileManagerRSWorker;
        com.tencent.mobileqq.filemanager.fileviewer.data.b videoForC2C;
        com.tencent.mobileqq.filemanager.fileviewer.data.b bVar;
        if (fileManagerEntity.bDelInFM) {
            fileManagerEntity.bDelInFM = false;
            this.f207645a.getFileManagerDataCenter().u(fileManagerEntity);
            this.f207645a.getFileManagerNotifyCenter().b(true, 3, null);
        }
        if (fileManagerEntity.nFileType == 2 && !fileManagerEntity.isZipInnerFile && !fileManagerEntity.videoDownloadForceThroughNT && fileManagerEntity.cloudType != 2 && fileManagerEntity.ntChatType != 8) {
            if (fileManagerEntity.getCloudType() == 12) {
                bVar = (com.tencent.mobileqq.filemanager.fileviewer.data.b) ((IGuildFileTempApi) QRoute.api(IGuildFileTempApi.class)).getNewVideoForGuild(this.f207645a, fileManagerEntity);
            } else {
                if (fileManagerEntity.getCloudType() == 13) {
                    videoForC2C = new com.tencent.mobileqq.filemanager.fileviewer.data.h(this.f207645a, fileManagerEntity);
                } else if (fileManagerEntity.peerType == 3000) {
                    videoForC2C = new com.tencent.mobileqq.filemanager.fileviewer.data.g(this.f207645a, fileManagerEntity);
                } else {
                    videoForC2C = new VideoForC2C(this.f207645a, fileManagerEntity);
                }
                bVar = videoForC2C;
            }
            g.b(bVar).startDownload();
            return;
        }
        int i3 = fileManagerEntity.peerType;
        if (i3 == 10014) {
            fileManagerRSWorker = (vb1.b) ((IGuildFileTempApi) QRoute.api(IGuildFileTempApi.class)).getNewGuildFileDownloader(this.f207645a, fileManagerEntity);
        } else {
            if (NTFileUtils.o(i3) && ((!TextUtils.isEmpty(fileManagerEntity.Uuid) || fileManagerEntity.ntChatType == 8) && fileManagerEntity.nOpType != 50)) {
                QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "downloadC2CFile  ntMId:" + fileManagerEntity.ntMsgId + " ntEId/uniseq:" + fileManagerEntity.uniseq + " sId:" + fileManagerEntity.nSessionId + " peer:" + fileManagerEntity.peerUid + "/" + fileManagerEntity.peerUin + " Uuid:" + fileManagerEntity.Uuid);
                this.f207645a.getNTFileManageBridger().P(fileManagerEntity);
                return;
            }
            fileManagerRSWorker = new FileManagerRSWorker(this.f207645a, fileManagerEntity);
        }
        synchronized (this) {
            this.f207647c.put(Long.valueOf(fileManagerEntity.nSessionId), fileManagerRSWorker);
        }
        QLog.i("FileManagerRSCenter<FileAssistant>", 1, "=_= v> entity[" + fileManagerEntity.nSessionId + "] is add to download list");
        j();
    }

    public synchronized void i(long j3) {
        vb1.b bVar = this.f207647c.get(Long.valueOf(j3));
        if (bVar != null) {
            bVar.b();
        }
        if (QLog.isColorLevel()) {
            QLog.d("FileManagerRSCenter<FileAssistant>", 2, "remove worker, sessionId[" + String.valueOf(j3) + "]");
        }
        this.f207647c.remove(Long.valueOf(j3));
        j();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0032 A[Catch: all -> 0x01ab, TryCatch #0 {, blocks: (B:4:0x0003, B:9:0x0015, B:10:0x002c, B:12:0x0032, B:92:0x0042, B:15:0x005e, B:17:0x0064, B:19:0x006c, B:21:0x0072, B:23:0x007a, B:25:0x0081, B:27:0x0089, B:29:0x0092, B:37:0x00c9, B:39:0x00f0, B:48:0x014d, B:62:0x00fc, B:68:0x010e, B:71:0x012f, B:64:0x0108, B:78:0x0188, B:79:0x0156, B:32:0x009c, B:49:0x0191, B:51:0x0197, B:52:0x019d, B:54:0x01a3), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f0 A[Catch: all -> 0x01ab, TryCatch #0 {, blocks: (B:4:0x0003, B:9:0x0015, B:10:0x002c, B:12:0x0032, B:92:0x0042, B:15:0x005e, B:17:0x0064, B:19:0x006c, B:21:0x0072, B:23:0x007a, B:25:0x0081, B:27:0x0089, B:29:0x0092, B:37:0x00c9, B:39:0x00f0, B:48:0x014d, B:62:0x00fc, B:68:0x010e, B:71:0x012f, B:64:0x0108, B:78:0x0188, B:79:0x0156, B:32:0x009c, B:49:0x0191, B:51:0x0197, B:52:0x019d, B:54:0x01a3), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0197 A[Catch: all -> 0x01ab, TryCatch #0 {, blocks: (B:4:0x0003, B:9:0x0015, B:10:0x002c, B:12:0x0032, B:92:0x0042, B:15:0x005e, B:17:0x0064, B:19:0x006c, B:21:0x0072, B:23:0x007a, B:25:0x0081, B:27:0x0089, B:29:0x0092, B:37:0x00c9, B:39:0x00f0, B:48:0x014d, B:62:0x00fc, B:68:0x010e, B:71:0x012f, B:64:0x0108, B:78:0x0188, B:79:0x0156, B:32:0x009c, B:49:0x0191, B:51:0x0197, B:52:0x019d, B:54:0x01a3), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01a3 A[Catch: all -> 0x01ab, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:9:0x0015, B:10:0x002c, B:12:0x0032, B:92:0x0042, B:15:0x005e, B:17:0x0064, B:19:0x006c, B:21:0x0072, B:23:0x007a, B:25:0x0081, B:27:0x0089, B:29:0x0092, B:37:0x00c9, B:39:0x00f0, B:48:0x014d, B:62:0x00fc, B:68:0x010e, B:71:0x012f, B:64:0x0108, B:78:0x0188, B:79:0x0156, B:32:0x009c, B:49:0x0191, B:51:0x0197, B:52:0x019d, B:54:0x01a3), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0151 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void j() {
        int i3;
        String str;
        String str2;
        int i16;
        boolean z16;
        int b16 = com.tencent.wstt.SSCM.c.b(BaseApplication.getContext());
        int i17 = 2;
        if (b16 != 1 && b16 != 2) {
            i3 = 2;
            int[] iArr = new int[3];
            long[] jArr = new long[4];
            str = "";
            str2 = "";
            int i18 = 0;
            for (Long l3 : this.f207647c.keySet()) {
                vb1.b bVar = this.f207647c.get(l3);
                if (bVar == null) {
                    str = str + "!!!!runRSWorker error, get worker null!!! sessionID[" + l3 + "]\n";
                } else {
                    if (bVar.getActionType() != 0 && bVar.getActionType() != 6) {
                        if (bVar.getActionType() != 1 && bVar.getActionType() != 8 && bVar.getActionType() != 5 && bVar.getActionType() != 50 && bVar.getActionType() != 54) {
                            if (bVar.getActionType() == 41) {
                                i16 = i17;
                                QLog.i("FileManagerRSCenter<FileAssistant>", 1, "run worker[" + l3 + "],direction Type : " + i16);
                                if (bVar.a()) {
                                    if (iArr[i16] < i3) {
                                        if (i16 == 1 || i16 == i17) {
                                            int i19 = 0;
                                            while (true) {
                                                if (i19 < 4) {
                                                    if (jArr[i19] == bVar.getFileSize()) {
                                                        z16 = true;
                                                        break;
                                                    }
                                                    i19++;
                                                } else {
                                                    z16 = false;
                                                    break;
                                                }
                                            }
                                            if (z16) {
                                                QLog.i("FileManagerRSCenter<FileAssistant>", 1, "run worker[" + l3 + "],file is uploadding continue ");
                                            } else {
                                                QLog.i("FileManagerRSCenter<FileAssistant>", 1, "!!!run worker[" + l3 + "]!!!");
                                            }
                                        }
                                        bVar.run();
                                        break;
                                    }
                                } else {
                                    if (i16 == 1 || i16 == i17) {
                                        long fileSize = bVar.getFileSize();
                                        QLog.i("FileManagerRSCenter<FileAssistant>", 1, "work[" + l3 + "] is running, setIndex[" + i18 + "] fileSize:" + fileSize);
                                        jArr[i18] = fileSize;
                                        i18++;
                                    }
                                    iArr[i16] = iArr[i16] + 1;
                                }
                                i17 = 2;
                            } else {
                                str2 = str2 + "type[" + bVar.getActionType() + "] is not processed, maxtype is 8\n";
                            }
                        }
                        i16 = 0;
                        QLog.i("FileManagerRSCenter<FileAssistant>", 1, "run worker[" + l3 + "],direction Type : " + i16);
                        if (bVar.a()) {
                        }
                        i17 = 2;
                    }
                    i16 = 1;
                    QLog.i("FileManagerRSCenter<FileAssistant>", 1, "run worker[" + l3 + "],direction Type : " + i16);
                    if (bVar.a()) {
                    }
                    i17 = 2;
                }
            }
            if (!TextUtils.isEmpty(str)) {
                QLog.e("FileManagerRSCenter<FileAssistant>", 1, str);
            }
            if (!TextUtils.isEmpty(str2)) {
                QLog.i("FileManagerRSCenter<FileAssistant>", 1, str2);
            }
        }
        i3 = 1;
        int[] iArr2 = new int[3];
        long[] jArr2 = new long[4];
        str = "";
        str2 = "";
        int i182 = 0;
        while (r9.hasNext()) {
        }
        if (!TextUtils.isEmpty(str)) {
        }
        if (!TextUtils.isEmpty(str2)) {
        }
    }

    public void k(FileManagerEntity fileManagerEntity, Bundle bundle) {
        String str;
        int i3;
        String str2;
        if (fileManagerEntity.nOpType == 0) {
            QLog.e("FileManagerRSCenter<FileAssistant>", 1, "**** nSessionId[" + String.valueOf(fileManagerEntity.nSessionId) + "] FileManagerRSCenter had not support send c2c offlinefile, please check!!!!");
            return;
        }
        if (fileManagerEntity.peerType == 3000) {
            QLog.e("FileManagerRSCenter<FileAssistant>", 1, "**** nSessionId[" + String.valueOf(fileManagerEntity.nSessionId) + "] FileManagerRSCenter had not support send disc offlinefile, please check!!!!");
            return;
        }
        int i16 = 0;
        if (fileManagerEntity.bDelInFM) {
            fileManagerEntity.bDelInFM = false;
            this.f207645a.getFileManagerDataCenter().u(fileManagerEntity);
            this.f207645a.getFileManagerNotifyCenter().b(true, 3, null);
        }
        if (!FileUtils.fileExistsAndNotEmpty(fileManagerEntity.getFilePath())) {
            QLog.e("FileManagerRSCenter<FileAssistant>", 1, "nSessionId[" + String.valueOf(fileManagerEntity.nSessionId) + "]file is not exist or empty,path[" + fileManagerEntity.getFilePath() + "], please check file!");
            String printStack = FileManagerUtil.printStack();
            if (fileManagerEntity.getFilePath() != null && fileManagerEntity.getFilePath().length() != 0) {
                if (!FileManagerUtil.fileExist(fileManagerEntity.getFilePath())) {
                    str2 = "fileNotExists:" + printStack;
                    i3 = 9042;
                } else if (FileManagerUtil.getFileSizes(fileManagerEntity.getFilePath()) == 0) {
                    str2 = "fileExistsEmpty:" + printStack;
                    i3 = 9071;
                } else {
                    str = printStack;
                    i3 = 0;
                }
                str = str2;
            } else {
                String str3 = "filePathNull:" + printStack;
                if (bundle != null) {
                    String string = bundle.getString("emptyPathCallStack");
                    if (!TextUtils.isEmpty(string)) {
                        str3 = "filePathNull sendLocalFile api callstack:" + string;
                    }
                }
                str = str3;
                i3 = 9005;
            }
            if (fileManagerEntity.nOpType == 6) {
                fileManagerEntity.status = 0;
                fileManagerEntity.isReaded = false;
                this.f207645a.getFileManagerDataCenter().f0(fileManagerEntity);
                this.f207645a.getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 38, null, 1, null);
                this.f207645a.getFileManagerDataCenter().c0();
                FileManagerUtil.reportFilemanagerFaildInfo(this.f207645a, fileManagerEntity.nSessionId, "actFileWyUp", 0L, "", fileManagerEntity.peerUin, fileManagerEntity.Uuid, fileManagerEntity.strFileMd5, i3, "", 0L, 0L, fileManagerEntity.fileSize, "", "", 0, str, null);
            }
            fileManagerEntity.status = 16;
            fileManagerEntity.fProgress = 1.0f;
            this.f207645a.getFileManagerDataCenter().f0(fileManagerEntity);
            return;
        }
        ShieldMsgManger shieldMsgManger = (ShieldMsgManger) this.f207645a.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
        if (shieldMsgManger != null && shieldMsgManger.h(fileManagerEntity.peerUin)) {
            fileManagerEntity.isReaded = false;
            if (fileManagerEntity.status == 16) {
                i16 = 16;
            }
            fileManagerEntity.status = i16;
            this.f207645a.getFileManagerDataCenter().f0(fileManagerEntity);
            QLog.e("FileManagerRSCenter<FileAssistant>", 1, "=_= ! Id[" + fileManagerEntity.nSessionId + "] frend in blacklist!");
            this.f207645a.getFileManagerNotifyCenter().c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 15, null, -1, HardCodeUtil.qqStr(R.string.mix));
            return;
        }
        FileManagerRSWorker fileManagerRSWorker = new FileManagerRSWorker(this.f207645a, fileManagerEntity);
        synchronized (this) {
            this.f207647c.put(Long.valueOf(fileManagerEntity.nSessionId), fileManagerRSWorker);
        }
        if (QLog.isColorLevel()) {
            QLog.d("FileManagerRSCenter<FileAssistant>", 2, "Add a New Send Work!, sessionId[" + String.valueOf(fileManagerEntity.nSessionId) + "]");
        }
        j();
    }

    public synchronized void l(boolean z16) {
        if (this.f207647c.size() < 1) {
            return;
        }
        ArrayList<vb1.b> arrayList = new ArrayList();
        Iterator<vb1.b> it = this.f207647c.values().iterator();
        while (it.hasNext()) {
            arrayList.add(0, it.next());
        }
        this.f207647c.clear();
        boolean z17 = false;
        for (vb1.b bVar : arrayList) {
            bVar.d();
            if (!z16) {
                bVar.f();
            } else {
                bVar.c(null, 0);
                z17 = true;
            }
        }
        if (z16 && !z17) {
            FileManagerUtil.dealWithErrCode(BaseApplication.getContext().getString(R.string.bfk));
        }
        this.f207645a.getFileManagerNotifyCenter().b(true, 3, null);
    }

    public synchronized boolean m(long j3) {
        vb1.b bVar = this.f207647c.get(Long.valueOf(j3));
        FileManagerEntity D = this.f207645a.getFileManagerDataCenter().D(j3);
        if (bVar != null) {
            bVar.e();
            this.f207647c.remove(Long.valueOf(j3));
            j();
        } else {
            this.f207645a.getNTFileManageBridger().J(D);
        }
        if (D != null && D.nFileType == 2) {
            g.a(String.valueOf(D.nSessionId));
            int i3 = D.status;
            if (i3 == 2 || i3 == -1) {
                D.status = 3;
            }
            this.f207645a.getFileManagerDataCenter().f0(D);
            this.f207645a.getFileManagerNotifyCenter().b(true, 0, null);
        }
        if (D == null || D.status != 2) {
            return false;
        }
        D.status = 3;
        this.f207645a.getFileManagerDataCenter().f0(D);
        return true;
    }

    public synchronized boolean n(String str, long j3, int i3) {
        FileManagerEntity C = this.f207645a.getFileManagerDataCenter().C(j3, str, i3, -1L);
        if (C == null) {
            return false;
        }
        return m(C.nSessionId);
    }
}
