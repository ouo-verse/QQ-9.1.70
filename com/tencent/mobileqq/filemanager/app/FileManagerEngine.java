package com.tencent.mobileqq.filemanager.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filebrowser.FileViewMusicService;
import com.tencent.mobileqq.filemanager.api.IFMDataCacheApi;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.filemanager.api.IQQFileSelectorUtil;
import com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager;
import com.tencent.mobileqq.filemanager.core.DiscPicThumbDownloader;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker;
import com.tencent.mobileqq.filemanager.core.ThumbDownloadManager;
import com.tencent.mobileqq.filemanager.core.ThumbHttpDownloader;
import com.tencent.mobileqq.filemanager.core.o;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.data.e;
import com.tencent.mobileqq.filemanager.fileassistant.transfer.FileAssistantMgr;
import com.tencent.mobileqq.filemanager.nt.NTFileUtils;
import com.tencent.mobileqq.filemanager.uftwrapper.QFileC2CTransferWrapper;
import com.tencent.mobileqq.filemanager.uftwrapper.QFileDiscTransferWrapper;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.filemanager.util.s;
import com.tencent.mobileqq.filemanager.util.w;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.guild.temp.api.IGuildFileTransferWrapper;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.msg.api.IForwardOrderManager;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import com.tencent.mobileqq.teamwork.bj;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.troop.data.t;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.appinfo.data.AppDetail;
import cooperation.qzone.QZoneHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FileManagerEngine {

    /* renamed from: a, reason: collision with root package name */
    private DiscPicThumbDownloader f206896a = null;

    /* renamed from: b, reason: collision with root package name */
    private o f206897b = null;

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.mobileqq.filemanager.core.c f206898c = null;

    /* renamed from: d, reason: collision with root package name */
    private ThumbHttpDownloader f206899d = null;

    /* renamed from: e, reason: collision with root package name */
    QQAppInterface f206900e;

    /* renamed from: f, reason: collision with root package name */
    com.tencent.mobileqq.filemanageraux.core.b f206901f;

    /* renamed from: g, reason: collision with root package name */
    ThumbDownloadManager f206902g;

    /* renamed from: h, reason: collision with root package name */
    com.tencent.mobileqq.filemanager.app.b f206903h;

    /* renamed from: i, reason: collision with root package name */
    private QFileMsgForwardManager f206904i;

    /* renamed from: j, reason: collision with root package name */
    private com.tencent.mobileqq.filemanager.app.c f206905j;

    /* renamed from: k, reason: collision with root package name */
    private QFileAppStorePromoteManager f206906k;

    /* renamed from: l, reason: collision with root package name */
    private IQQFavProxy f206907l;

    /* renamed from: m, reason: collision with root package name */
    private MMApkFileSafeChecker f206908m;

    /* renamed from: n, reason: collision with root package name */
    private FileAssistantMgr f206909n;

    /* renamed from: o, reason: collision with root package name */
    private com.tencent.mobileqq.filemanager.fileassistant.util.f f206910o;

    /* renamed from: p, reason: collision with root package name */
    private QFileC2CTransferWrapper f206911p;

    /* renamed from: q, reason: collision with root package name */
    private QFileDiscTransferWrapper f206912q;

    /* renamed from: r, reason: collision with root package name */
    private com.tencent.mobileqq.filemanager.uftwrapper.b f206913r;

    /* renamed from: s, reason: collision with root package name */
    private IGuildFileTransferWrapper f206914s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements s {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FileManagerEntity f206921a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Runnable f206922b;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.filemanager.app.FileManagerEngine$a$a, reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        class C7544a implements QFileAppStorePromoteManager.f {
            C7544a() {
            }

            @Override // com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager.f
            public void a(boolean z16, AppDetail appDetail) {
                FileManagerEntity fileManagerEntity = a.this.f206921a;
                fileManagerEntity.yybApkPackageName = appDetail.packageName;
                fileManagerEntity.yybApkName = appDetail.appName;
                fileManagerEntity.yybApkIconUrl = appDetail.iconUrl;
            }

            @Override // com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager.f
            public void b() {
                QLog.i("FileManagerEngine<FileAssistant>", 1, "waterTest, onGetAppDetailTimeLimit. apkName[" + a.this.f206921a.yybApkName + "]");
                ah.b.a().execute(a.this.f206922b);
            }
        }

        a(FileManagerEntity fileManagerEntity, Runnable runnable) {
            this.f206921a = fileManagerEntity;
            this.f206922b = runnable;
        }

        @Override // com.tencent.mobileqq.filemanager.util.s
        public void a(String str, String str2) {
            FileManagerEntity fileManagerEntity = this.f206921a;
            fileManagerEntity.fileName = str;
            fileManagerEntity.strApkPackageName = str2;
            FileManagerEngine.this.f206900e.getFileManagerEngine().J().g(str2, new C7544a());
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f206926a;

        /* renamed from: b, reason: collision with root package name */
        public long f206927b;

        /* renamed from: c, reason: collision with root package name */
        public String f206928c;

        /* renamed from: d, reason: collision with root package name */
        public String f206929d;

        /* renamed from: e, reason: collision with root package name */
        public String f206930e;

        String a() {
            if (!TextUtils.isEmpty(this.f206929d)) {
                return this.f206929d;
            }
            return new File(this.f206926a).getName();
        }

        String b() {
            if (!TextUtils.isEmpty(this.f206928c)) {
                return this.f206928c;
            }
            return this.f206926a;
        }

        boolean c() {
            if (!TextUtils.isEmpty(this.f206926a) && this.f206927b != 0) {
                return true;
            }
            return false;
        }
    }

    public FileManagerEngine(QQAppInterface qQAppInterface) {
        this.f206900e = qQAppInterface;
        if (this.f206901f == null) {
            Y();
        }
        FileManagerUtil.initNoMedia();
        e0();
    }

    private void A(FileManagerEntity fileManagerEntity) {
        int i3;
        if (fileManagerEntity.peerUin.equals(AppConstants.DATALINE_IPAD_UIN)) {
            i3 = 1;
        } else if (fileManagerEntity.peerUin.equals(AppConstants.DATALINE_PHONE_UIN)) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        this.f206900e.getFileManagerEngine().x(3, fileManagerEntity, i3);
    }

    private void B(FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity == null) {
            if (QLog.isColorLevel()) {
                QLog.e("FileManagerEngine<FileAssistant>", 2, "FileManagerEntity is null!!!");
                return;
            }
            return;
        }
        FileManagerUtil.addCloseButtonSessionId(fileManagerEntity.nSessionId);
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            fileManagerEntity.status = 0;
            this.f206900e.getFileManagerNotifyCenter().b(false, 34, new Object[]{0, null, null, Long.valueOf(fileManagerEntity.nSessionId)});
            FileManagerUtil.reportFilemanagerFaildInfo(this.f206900e, fileManagerEntity.nSessionId, "actFileOf2Wy", 0L, "", fileManagerEntity.peerUin, fileManagerEntity.Uuid, fileManagerEntity.strFileMd5, 9004L, "Error_No_Network", 0L, 0L, 0L, "", "", 0, "Error_No_Network", "");
        } else {
            fileManagerEntity.fProgress = 0.0f;
            fileManagerEntity.status = 2;
            fileManagerEntity.nOpType = 4;
            ((IWeiyunResponseHandler) QRoute.api(IWeiyunResponseHandler.class)).startSave2Weiyun();
            this.f206900e.getFileTransferHandler().z(25, fileManagerEntity);
        }
    }

    private FileInfo N(String str) {
        FileInfo fileInfo = new FileInfo();
        fileInfo.z(str);
        fileInfo.y(FileUtils.getFileName(str));
        fileInfo.A(q.m(str));
        return fileInfo;
    }

    private void e0() {
        f0();
        this.f206910o = new com.tencent.mobileqq.filemanager.fileassistant.util.f(this.f206900e);
        T();
    }

    private synchronized void f0() {
        synchronized (this) {
            if (this.f206909n == null) {
                FileAssistantMgr fileAssistantMgr = new FileAssistantMgr();
                this.f206909n = fileAssistantMgr;
                fileAssistantMgr.f(this.f206900e);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:28:0x0066. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:29:0x0069. Please report as an issue. */
    private void l0(long j3) {
        FileManagerEntity D = this.f206900e.getFileManagerDataCenter().D(j3);
        if (D == null) {
            QLog.e("FileManagerEngine<FileAssistant>", 1, "reTry failed because entity is null.");
            return;
        }
        QLog.i("FileManagerEngine<FileAssistant>", 1, "reTry entity file name: " + D.fileName + " OpType: " + D.nOpType);
        if (p0(D)) {
            return;
        }
        int i3 = D.nOpType;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 13) {
                    if (i3 != 50) {
                        if (i3 != 24 && i3 != 25 && i3 != 28) {
                            if (i3 != 29) {
                                if (i3 != 36 && i3 != 37) {
                                    switch (i3) {
                                        case 3:
                                        case 7:
                                            break;
                                        case 4:
                                            B(D);
                                            return;
                                        case 5:
                                        case 6:
                                        case 8:
                                            break;
                                        case 9:
                                        case 10:
                                            break;
                                        default:
                                            switch (i3) {
                                                case 20:
                                                case 21:
                                                case 22:
                                                    u(D, i3);
                                                    return;
                                                default:
                                                    switch (i3) {
                                                        case 52:
                                                            break;
                                                        case 53:
                                                        case 54:
                                                        case 55:
                                                            break;
                                                        default:
                                                            QLog.e("FileManagerEngine<FileAssistant>", 1, "unknow operation type!");
                                                            return;
                                                    }
                                            }
                                    }
                                }
                            } else {
                                A(D);
                                return;
                            }
                        }
                        this.f206900e.getNTFileManageBridger().G0(D, null);
                        return;
                    }
                }
                q0(j3, D);
                return;
            }
            m0(D);
            return;
        }
        n0(D);
    }

    private void m0(FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity.getCloudType() == 0) {
            fileManagerEntity.setCloudType(1);
            this.f206900e.getFileManagerDataCenter().f0(fileManagerEntity);
        }
        this.f206900e.getFileManagerRSCenter().f(fileManagerEntity);
    }

    private void n0(FileManagerEntity fileManagerEntity) {
        int i3 = fileManagerEntity.peerType;
        if (i3 == 3000) {
            U().l(fileManagerEntity);
        } else if (i3 == 10014) {
            P().resendFile(this.f206900e, fileManagerEntity);
        } else {
            T().j(fileManagerEntity);
        }
    }

    private boolean p0(FileManagerEntity fileManagerEntity) {
        if (!com.tencent.mobileqq.filemanager.fileassistant.util.h.g(this.f206900e).equals(fileManagerEntity.peerUin)) {
            return false;
        }
        QLog.i("FileManagerEngine<FileAssistant>", 1, "reTry Fileassistant bSend:" + fileManagerEntity.bSend);
        if (fileManagerEntity.isSend()) {
            this.f206909n.i(fileManagerEntity);
        } else {
            this.f206909n.h(fileManagerEntity);
        }
        return true;
    }

    private void q0(long j3, FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity.getCloudType() == 0) {
            fileManagerEntity.bDelInFM = false;
            this.f206900e.getFileManagerDataCenter().u(fileManagerEntity);
            this.f206900e.getFileManagerNotifyCenter().b(true, 3, null);
            this.f206900e.getOnlineFileSessionCenter().x(j3);
            return;
        }
        QLog.e("FileManagerEngine<FileAssistant>", 1, "err cloud type.when reTry :" + fileManagerEntity.getCloudType());
    }

    public void A0(String str, String str2, String str3, int i3) {
        IFMDataCacheApi iFMDataCacheApi = (IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class);
        for (int i16 = 0; i16 < iFMDataCacheApi.getOfflineFiles().size(); i16++) {
            FileManagerEntity g06 = this.f206900e.getFileManagerEngine().g0(FileManagerUtil.newEntityByOfflineFileInfo(iFMDataCacheApi.getOfflineFiles().get(i16), i3), str, str2, str3, i3, true);
            g06.peerType = i3;
            g06.status = 2;
            if (i3 == 3000) {
                g06.nOpType = 28;
                QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + g06.nSessionId + "] sendOffline2Disc[" + g06.fileName + "]");
            } else {
                QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + g06.nSessionId + "] sendOffline2Offline[" + g06.fileName + "]");
            }
            C(g06);
        }
    }

    public void B0(boolean z16, String str, String str2, String str3, int i3) {
        IFMDataCacheApi iFMDataCacheApi = (IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class);
        for (int i16 = 0; i16 < iFMDataCacheApi.getRecentFiles().size(); i16++) {
            FileManagerEntity fileManagerEntity = iFMDataCacheApi.getRecentFiles().get(i16);
            if (fileManagerEntity.sendCloudUnsuccessful()) {
                QLog.w("FileManagerEngine<FileAssistant>", 1, "Id[" + fileManagerEntity.nSessionId + "] unSend success!");
            } else if (fileManagerEntity.fileSize <= QZoneHelper.Constants.NO_WIFI_UPLOAD_VIDEO_MAX_SIZE_DEFAULT && z16 && iFMDataCacheApi.isDocsFile(fileManagerEntity)) {
                new bj(this.f206900e).m(fileManagerEntity, str, str2, i3);
            } else {
                ((IQQFileSelectorUtil) QRoute.api(IQQFileSelectorUtil.class)).upDataApkPathForPackageName(fileManagerEntity);
                FileManagerReporter.addData("0X8005413");
                D0(fileManagerEntity.nSessionId, str, str2, str3, i3, true);
            }
        }
        if (iFMDataCacheApi.getRecentFiles().size() > 0) {
            ReportController.n(this.f206900e, "dc00898", "", "", "0X800AFB4", "0X800AFB4", 0, iFMDataCacheApi.getRecentFiles().size(), 0, "", "", "", "");
        }
    }

    public void C(FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity == null) {
            if (QLog.isColorLevel()) {
                QLog.e("FileManagerEngine<FileAssistant>", 2, "FileManagerEntity is null!!!");
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(fileManagerEntity.peerUid)) {
            fileManagerEntity.peerUid = FileManagerUtil.checkAndGetUid(fileManagerEntity.peerUid, fileManagerEntity.peerUin, "forwardOfflineFile");
        }
        FileManagerUtil.addCloseButtonSessionId(fileManagerEntity.nSessionId);
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            String string = BaseApplication.getContext().getString(R.string.b_o);
            fileManagerEntity.status = 0;
            this.f206900e.getFileManagerNotifyCenter().b(false, 19, new Object[]{0, string, 0L, 0L, null, Long.valueOf(fileManagerEntity.nSessionId)});
            FileManagerUtil.reportFilemanagerFaildInfo(this.f206900e, fileManagerEntity.nSessionId, "actFileOf2Of", 0L, "", fileManagerEntity.peerUin, fileManagerEntity.Uuid, fileManagerEntity.strFileMd5, 9004L, "Error_No_Network", 0L, 0L, 0L, "", "", 0, "Error_No_Network", "");
            return;
        }
        QLog.i("FileManagerEngine<FileAssistant>", 1, "ForwardOfflineFile, nId[" + fileManagerEntity.nSessionId + "], opType[" + fileManagerEntity.nOpType + "]");
        ShieldMsgManger shieldMsgManger = (ShieldMsgManger) this.f206900e.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
        if (com.tencent.mobileqq.filemanager.fileassistant.util.h.o() && !com.tencent.mobileqq.filemanager.fileassistant.util.h.k(fileManagerEntity.peerUin) && shieldMsgManger != null && shieldMsgManger.h(fileManagerEntity.peerUin)) {
            FileManagerUtil.dealWithErrCode(HardCodeUtil.qqStr(R.string.mjj));
            fileManagerEntity.status = 0;
            this.f206900e.getFileManagerNotifyCenter().b(false, 19, new Object[]{0, null, 0L, 0L, null, Long.valueOf(fileManagerEntity.nSessionId)});
            this.f206900e.getFileManagerDataCenter().f0(fileManagerEntity);
            return;
        }
        fileManagerEntity.fProgress = 0.0f;
        fileManagerEntity.status = 2;
        this.f206900e.getNTFileManageBridger().T(fileManagerEntity);
    }

    public boolean C0(FileManagerEntity fileManagerEntity, String str, String str2, int i3, int i16) {
        if (i3 == 1) {
            QLog.i("FileManagerEngine<FileAssistant>", 1, "=_= r [CS Send] Id[" + fileManagerEntity.nSessionId + "]Send FavFile to Troop ");
            if (q.f(fileManagerEntity.getFilePath())) {
                this.f206900e.getFileManagerEngine().K0(fileManagerEntity.getFilePath(), str, 0L, i16, null);
                return true;
            }
            this.f206900e.getNTFileManageBridger().S(fileManagerEntity, str, str2, i3, i16);
        } else if (i3 != 0 && i3 != 6000 && i3 != 6005 && i3 != 6003) {
            if (i3 == 3000) {
                if (q.f(fileManagerEntity.getFilePath())) {
                    this.f206900e.getFileManagerEngine().H0(fileManagerEntity.getFilePath(), this.f206900e.getCurrentUin(), str, "", i3, true, 0L, i16, null);
                } else {
                    com.tencent.mobileqq.filemanager.util.d.e(R.string.f1359702w);
                    return false;
                }
            } else {
                QLog.e("FileManagerEngine<FileAssistant>", 1, "=_= r [CS Send] Id[" + fileManagerEntity.nSessionId + "]Send QfavFile to peerType:" + i3);
                com.tencent.mobileqq.filemanager.util.d.e(R.string.f1359702w);
                return false;
            }
        } else {
            String checkAndGetUid = FileManagerUtil.checkAndGetUid(str2, str, "sendFavFile2X");
            if (q.f(fileManagerEntity.getFilePath())) {
                this.f206900e.getNTFileManageBridger().p0(fileManagerEntity.getFilePath(), "", str, checkAndGetUid, i3, true, 0L, 0);
            } else {
                this.f206900e.getNTFileManageBridger().S(fileManagerEntity, str, checkAndGetUid, i3, i16);
            }
        }
        return true;
    }

    public void D(long j3, String str) {
        y(3, j3, str);
    }

    public boolean D0(long j3, String str, String str2, String str3, int i3, boolean z16) {
        return E0(j3, str, str2, str3, i3, z16, 0);
    }

    public void E(long j3, String str, int i3) {
        z(3, j3, str, 0L, i3);
    }

    public boolean E0(long j3, String str, String str2, String str3, int i3, boolean z16, int i16) {
        FileManagerEntity M = this.f206900e.getFileManagerDataCenter().M(j3);
        if (M == null) {
            if (QLog.isColorLevel()) {
                QLog.e("FileManagerEngine<FileAssistant>", 2, "why entity is null you can choose!!!");
            }
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FileManagerEngine<FileAssistant>", 2, "Printe FileManagerEntity InfoItem [" + FileManagerUtil.printFileManagerEntityInfo(M) + " ]");
        }
        if (5 != M.cloudType) {
            FileManagerUtil.associateLocalWithCloud(M);
        }
        if (M.getCloudType() == 2 && M.WeiYunFileId != null && z16) {
            if (QLog.isColorLevel()) {
                QLog.d("FileManagerEngine<FileAssistant>", 2, "Send lastOperation list type id weiyun to offlinefile, fileid[" + M.WeiYunFileId + "], filename[" + M.fileName + "], filename[" + M.fileSize + "]");
            }
            FileManagerUtil.addCloseButtonSessionId(M.nSessionId);
            if (TextUtils.isEmpty(str)) {
                N0(M, this.f206900e.getCurrentAccountUin(), str2, str3, i3);
            } else {
                P0(M, str, str2, str3, i3);
            }
        } else if (com.tencent.mobileqq.filemanager.data.e.g(M.Uuid)) {
            ((ITeamWorkUtilsTemp) QRoute.api(ITeamWorkUtilsTemp.class)).sendTDoc2Chat(this.f206900e, M, str2, str3, i3);
        } else {
            if (M.getCloudType() == 1 && !TextUtils.isEmpty(M.Uuid)) {
                if (QLog.isColorLevel()) {
                    QLog.d("FileManagerEngine<FileAssistant>", 2, "cloud is offline,so try offline to offline!, nSessionId[" + j3 + "], strSendUin[" + FileManagerUtil.enCodecString(str) + "], recvUin[" + FileManagerUtil.enCodecString(str2) + "], peerType[" + i3 + "], toOffline[" + z16 + "]");
                }
                String account = this.f206900e.getAccount();
                if (i3 == 1004 || i3 == 1000 || i3 == 1006) {
                    account = str;
                }
                if (i3 == 1) {
                    D(j3, str2);
                    return false;
                }
                FileManagerEntity h06 = h0(M, account, str2, str3, i3, true, 0L, i16);
                FileManagerUtil.addCloseButtonSessionId(h06.nSessionId);
                FileManagerUtil.setTempParam(this.f206900e, str, str2, h06);
                int i17 = M.peerType;
                int i18 = h06.peerType;
                QLog.d("FileManagerEngine<FileAssistant>", 1, "forwardOfflineFile newPeerType=" + i17 + " oldPeerType=" + i18);
                if (i17 != 1025 && i17 != 1024 && i18 != 1025 && i18 != 1024) {
                    h06.peerType = M.peerType;
                }
                if (M.peerType == 3000) {
                    h06.selfUin = M.peerUin;
                    if (i3 == 3000) {
                        QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + h06.nSessionId + "] SendDisc2Disc[" + h06.fileName + "]");
                        this.f206900e.getFileManagerEngine().u(h06, 22);
                    } else {
                        QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + h06.nSessionId + "] SendDisc2Offline[" + h06.fileName + "]");
                        this.f206900e.getFileManagerEngine().u(h06, 21);
                    }
                } else {
                    if (i3 == 3000) {
                        h06.nOpType = 28;
                        QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + h06.nSessionId + "] SendOfline2Disc[" + h06.fileName + "]");
                    } else if (i3 != 6000 && i3 != 6003 && i3 != 6005) {
                        QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + h06.nSessionId + "] SendOfline2Ofline[" + h06.fileName + "]");
                    } else {
                        h06.nOpType = 29;
                        h06.peerType = i3;
                        QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + h06.nSessionId + "] SendOfline2dataline[" + h06.fileName + "]");
                    }
                    C(h06);
                }
            } else if (M.getFilePath() != null) {
                if (i3 == 1) {
                    I0(M.getFilePath(), str2);
                } else {
                    if (F0(M.getFilePath(), str, str2, str3, i3, z16) != null) {
                        return true;
                    }
                    return false;
                }
            } else {
                QLog.e("FileManagerEngine<FileAssistant>", 2, "what's type for this file!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            }
            return false;
        }
        return false;
    }

    public void F(FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity == null) {
            QLog.e("FileManagerEngine<FileAssistant>", 1, "forwardToDatalineFromFileAssistant entity is null!");
        } else if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            QLog.e("FileManagerEngine<FileAssistant>", 1, "forwardToDatalineFromFileAssistant netword is error!");
        } else {
            this.f206900e.getFileTransferHandler().k(38, 3, fileManagerEntity);
        }
    }

    public FileManagerEntity F0(String str, String str2, String str3, String str4, int i3, boolean z16) {
        return H0(str, str2, str3, str4, i3, z16, 0L, 0, null);
    }

    public boolean G(long j3, String str, long j16, long j17, String str2, int i3, int i16) {
        return H(j3, str, j16, j17, str2, i3, i16, 0L, 0);
    }

    public FileManagerEntity G0(String str, String str2, String str3, String str4, int i3, boolean z16, long j3, int i16) {
        return H0(str, str2, str3, str4, i3, z16, j3, i16, null);
    }

    public boolean H(long j3, String str, long j16, long j17, String str2, int i3, int i16, long j18, int i17) {
        long j19;
        boolean z16;
        long j26;
        boolean z17;
        long j27;
        boolean z18;
        long j28;
        boolean z19;
        String str3;
        long t16;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        FileManagerEntity D = this.f206900e.getFileManagerDataCenter().D(j3);
        if (D == null) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FileManagerEngine<FileAssistant>", 2, String.format("ForwardTroopFile==>fileName:%s|mEntrySessionID:%s|old filePath:%s", D.fileName, j3 + "", D.strTroopFilePath));
        }
        if (i3 != 1 && i3 != 3000 && i3 != 0 && i3 != 6000 && i3 != 6003 && i3 != 6005) {
            int i29 = 0;
            t k3 = TroopFileUtils.k(this.f206900e, j16, D.strTroopFileID, D.strTroopFilePath, D.fileName, D.fileSize, D.busId);
            if (k3 == null || k3.f294985s == null) {
                return false;
            }
            if (i3 == 1) {
                int abs = Math.abs(new Random().nextInt());
                t t06 = TroopFileTransferManager.O(this.f206900e, j17).t0(k3.f294985s, j16, k3.f294987u, k3.f294978l, k3.f294976j, k3.f294988v, abs, j3, null);
                if (t06 == null) {
                    QLog.e("FileManagerEngine<FileAssistant>", 1, "infoNew is null!!!");
                    return false;
                }
                int fileType = FileManagerUtil.getFileType(k3.f294987u);
                if (fileType != 0) {
                    str3 = "FileManagerEngine<FileAssistant>";
                    if (fileType == 2) {
                        if (q.p(k3.f294978l)) {
                            int[] videoFileRtAndTime = ShortVideoUtils.getVideoFileRtAndTime(str);
                            i26 = videoFileRtAndTime[0];
                            i27 = videoFileRtAndTime[1];
                            i28 = videoFileRtAndTime[3];
                        } else {
                            MessageForTroopFile messageForTroopFile = (MessageForTroopFile) com.tencent.mobileqq.filemanager.fileviewer.c.w(this.f206900e.getMessageFacade(), String.valueOf(k3.f294971e), 1, k3.f294985s);
                            if (messageForTroopFile != null) {
                                i26 = messageForTroopFile.width;
                                i27 = messageForTroopFile.height;
                                i28 = messageForTroopFile.duration;
                            } else {
                                i18 = 0;
                                i19 = 0;
                                t16 = TroopFileUtils.r(this.f206900e, String.valueOf(j17), t06.f294987u, t06.f294976j, t06.f294967a.toString(), abs, String.valueOf(k3.f294971e), j3, i18, i19, i29, j18, i17, null);
                            }
                        }
                        i29 = i28;
                        i18 = i26;
                        i19 = i27;
                        t16 = TroopFileUtils.r(this.f206900e, String.valueOf(j17), t06.f294987u, t06.f294976j, t06.f294967a.toString(), abs, String.valueOf(k3.f294971e), j3, i18, i19, i29, j18, i17, null);
                    } else {
                        t16 = TroopFileUtils.t(this.f206900e, String.valueOf(j17), t06.f294987u, t06.f294976j, t06.f294967a.toString(), abs, String.valueOf(k3.f294971e), j3, j18, i17);
                    }
                } else if (!q.p(k3.f294978l)) {
                    str3 = "FileManagerEngine<FileAssistant>";
                    MessageForTroopFile messageForTroopFile2 = (MessageForTroopFile) com.tencent.mobileqq.filemanager.fileviewer.c.w(this.f206900e.getMessageFacade(), String.valueOf(k3.f294971e), 1, k3.f294985s);
                    if (messageForTroopFile2 != null) {
                        t16 = TroopFileUtils.s(this.f206900e, String.valueOf(j17), t06.f294987u, t06.f294976j, t06.f294967a.toString(), abs, String.valueOf(k3.f294971e), j3, messageForTroopFile2.width, messageForTroopFile2.height, j18, i17);
                    } else {
                        t16 = TroopFileUtils.t(this.f206900e, String.valueOf(j17), t06.f294987u, t06.f294976j, t06.f294967a.toString(), abs, String.valueOf(k3.f294971e), j3, j18, i17);
                    }
                } else {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(k3.f294978l, options);
                    str3 = "FileManagerEngine<FileAssistant>";
                    t16 = TroopFileUtils.s(this.f206900e, String.valueOf(j17), t06.f294987u, t06.f294976j, t06.f294967a.toString(), abs, String.valueOf(k3.f294971e), j3, options.outWidth, options.outHeight, j18, i17);
                }
                D.structMsgSeq = t16;
                if (QLog.isColorLevel()) {
                    QLog.d(str3, 2, "ForwardTroopFile, startCopyToGroup, entrySessionID:" + j3 + "|InsertAIOMsg, msgSeq:" + t16);
                    return true;
                }
                return true;
            }
            if (i3 != 3000 && i3 != 0) {
                if (i3 == 7) {
                    TroopFileTransferManager O = TroopFileTransferManager.O(this.f206900e, j16);
                    if (j16 == 0) {
                        j28 = D.TroopUin;
                    } else {
                        j28 = j16;
                    }
                    long j29 = D.datalineEntitySessionId;
                    if (j29 != 0) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    O.v0(i16, j28, D.busId, j17, i3, D.fileName, D.strThumbPath, D.fileSize, D.strTroopFilePath, z19, j29, FileManagerUtil.getDatalineProcessCallBack(this.f206900e, 0), j18, i17, null);
                    return true;
                }
                if (i3 == 6003) {
                    TroopFileTransferManager O2 = TroopFileTransferManager.O(this.f206900e, j16);
                    if (j16 == 0) {
                        j27 = D.TroopUin;
                    } else {
                        j27 = j16;
                    }
                    long j36 = D.datalineEntitySessionId;
                    if (j36 != 0) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    z16 = true;
                    O2.v0(i16, j27, D.busId, j17, 7, D.fileName, D.strThumbPath, D.fileSize, D.strTroopFilePath, z18, j36, FileManagerUtil.getDatalineProcessCallBack(this.f206900e, 1), j18, i17, null);
                } else {
                    z16 = true;
                    if (i3 == 6005) {
                        TroopFileTransferManager O3 = TroopFileTransferManager.O(this.f206900e, j16);
                        if (j16 == 0) {
                            j26 = D.TroopUin;
                        } else {
                            j26 = j16;
                        }
                        long j37 = D.datalineEntitySessionId;
                        if (j37 != 0) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        O3.v0(i16, j26, D.busId, j17, 7, D.fileName, D.strThumbPath, D.fileSize, D.strTroopFilePath, z17, j37, FileManagerUtil.getDatalineProcessCallBack(this.f206900e, 2), j18, i17, null);
                    }
                }
                return z16;
            }
            TroopFileTransferManager O4 = TroopFileTransferManager.O(this.f206900e, j16);
            if (j16 == 0) {
                j19 = D.TroopUin;
            } else {
                j19 = j16;
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(D.yybApkPackageName)) {
                bundle.putString("yyb_apk_package_name_key", D.yybApkPackageName);
            }
            if (!TextUtils.isEmpty(D.yybApkName)) {
                bundle.putString("yyb_apk_name_key", D.yybApkName);
            }
            if (!TextUtils.isEmpty(D.yybApkIconUrl)) {
                bundle.putString("yyb_apk_icon_url_key", D.yybApkIconUrl);
            }
            O4.v0(i16, j19, D.busId, j17, i3, D.fileName, D.strThumbPath, D.fileSize, D.strTroopFilePath, false, 0L, FileManagerUtil.getC2CProcessCallBack(this.f206900e), j18, i17, bundle);
            return true;
        }
        return this.f206900e.getNTFileManageBridger().Y(D, j16, j17, str2, i3, i16, j18, i17);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FileManagerEntity H0(final String str, String str2, final String str3, String str4, final int i3, final boolean z16, long j3, int i16, final Bundle bundle) {
        int i17;
        long j16;
        final String str5;
        String str6;
        Bundle bundle2 = null;
        if (com.tencent.mobileqq.filemanager.fileassistant.util.h.k(str3)) {
            if (i16 != 0) {
                bundle2 = new Bundle();
                bundle2.putLong("forward_origin_uni_seq", j3);
                bundle2.putInt("forward_id", i16);
            }
            return this.f206909n.j(str, bundle2);
        }
        if (i3 == 3000) {
            return U().m(str, str3, bundle);
        }
        if (z16) {
            QLog.d("FileManagerEngine<FileAssistant>", 1, "sendLocalFile strFilePath: " + str + " ,srcDiscUin: " + str2 + " ,recvUin: " + str3 + " ,recvUid: " + str4 + " ,peerType: " + i3 + " ,toOffline: " + z16 + " ,originUniSeq: " + j3 + " ,forwardID: " + i16 + " ,extBundle: " + bundle);
            return T().k(str, str2, str3, FileManagerUtil.checkAndGetUid(str4, str3, "sendLocalFile"), i3, j3, i16, bundle);
        }
        if (this.f206900e.getFileManagerRSCenter() == null) {
            if (QLog.isColorLevel()) {
                QLog.e("FileManagerEngine<FileAssistant>", 2, "why FileManagerRSCenter is null???");
            }
            return null;
        }
        int i18 = 0;
        final String makeTransFileProtocolData = TransfileUtile.makeTransFileProtocolData(str, 0L, 0, true);
        String fileName = FileManagerUtil.getFileName(str);
        if (!z16) {
            i18 = 6;
        }
        if (z16) {
            j16 = com.tencent.mobileqq.service.message.q.d(-1000).uniseq;
            i17 = 2;
            ((IForwardOrderManager) QRoute.api(IForwardOrderManager.class)).mapUniSeqId(j16, j3, i16);
        } else {
            i17 = 2;
            j16 = -1;
        }
        final long j17 = j16;
        final FileManagerEntity i19 = this.f206900e.getFileManagerDataCenter().i(j17, str3, i3);
        i19.status = i17;
        i19.nOpType = i18;
        i19.fileSize = FileManagerUtil.getFileSizes(str);
        if (QLog.isColorLevel()) {
            QLog.d("FileManagerEngine<FileAssistant>", 2, "toOffline[" + String.valueOf(z16) + "], filepath[" + str + "]:size[" + String.valueOf(i19.fileSize) + "]");
        }
        i19.isReaded = true;
        i19.peerUin = str3;
        i19.peerNick = FileManagerUtil.getPeerNick(this.f206900e, str3, null, i3);
        i19.setFilePath(str);
        i19.srvTime = com.tencent.mobileqq.service.message.e.K0() * 1000;
        i19.fileName = fileName;
        i19.nFileType = FileManagerUtil.getFileType(str);
        i19.setCloudType(3);
        i19.bSend = z16;
        i19.msgSeq = FileManagerUtil.genMsgSeq();
        i19.msgUid = FileManagerUtil.genMsgUid();
        i19.strThumbPath = FileManagerUtil.createMediaThumbnail(str, 150, 150, null);
        FileManagerUtil.setTempParam(this.f206900e, str2, str3, i19);
        this.f206900e.getFileManagerDataCenter().t(i19);
        String account = this.f206900e.getAccount();
        if (i3 != 1004 && i3 != 1000) {
            if (i3 == 1006) {
                i19.tmpSessionFromPhone = str2;
                i19.tmpSessionToPhone = str3;
            } else {
                str5 = account;
                if (!TextUtils.isEmpty(i19.getFilePath())) {
                    QLog.e("FileManagerEngine<FileAssistant>", 1, "Err: Id[" + i19.nSessionId + "] sendLocalFile entryFilePath is null,strFilePath[" + str + "]");
                    str6 = FileManagerUtil.printStack();
                } else {
                    str6 = "";
                }
                final String str7 = str6;
                Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.filemanager.app.FileManagerEngine.1
                    @Override // java.lang.Runnable
                    public void run() {
                        FileManagerUtil.createMediThumbnail(i19);
                        if (z16) {
                            FileManagerDataCenter fileManagerDataCenter = FileManagerEngine.this.f206900e.getFileManagerDataCenter();
                            String str8 = str3;
                            String str9 = str5;
                            String str10 = str;
                            int i26 = i3;
                            String str11 = makeTransFileProtocolData;
                            FileManagerEntity fileManagerEntity = i19;
                            fileManagerDataCenter.q(str8, str9, true, str10, 0L, true, i26, str11, fileManagerEntity.msgSeq, j17, fileManagerEntity.msgUid, -1L, com.tencent.mobileqq.service.message.e.K0(), -1, bundle);
                        }
                        if (z16) {
                            QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + i19.nSessionId + "] SendLocalfile[" + i19.fileName + "], peerType[" + i19.peerType + "]");
                        } else {
                            QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + i19.nSessionId + "] SendLocalfileToWeiyun[" + i19.fileName + "]");
                        }
                        Bundle bundle3 = new Bundle();
                        if (!TextUtils.isEmpty(str7)) {
                            bundle3.putString("emptyPathCallStack", str7);
                        }
                        Bundle bundle4 = bundle;
                        if (bundle4 != null) {
                            bundle3.putAll(bundle4);
                        }
                        FileManagerEngine.this.f206900e.getFileManagerRSCenter().k(i19, bundle3);
                    }
                };
                if (i19.nFileType != 5) {
                    if (!((IQQFileSelectorUtil) QRoute.api(IQQFileSelectorUtil.class)).getApkPackageInfo(i19.getFilePath(), new a(i19, runnable))) {
                        ah.b.a().execute(runnable);
                    }
                } else {
                    ah.b.a().execute(runnable);
                }
                return i19;
            }
        }
        str5 = str2;
        if (!TextUtils.isEmpty(i19.getFilePath())) {
        }
        final String str72 = str6;
        Runnable runnable2 = new Runnable() { // from class: com.tencent.mobileqq.filemanager.app.FileManagerEngine.1
            @Override // java.lang.Runnable
            public void run() {
                FileManagerUtil.createMediThumbnail(i19);
                if (z16) {
                    FileManagerDataCenter fileManagerDataCenter = FileManagerEngine.this.f206900e.getFileManagerDataCenter();
                    String str8 = str3;
                    String str9 = str5;
                    String str10 = str;
                    int i26 = i3;
                    String str11 = makeTransFileProtocolData;
                    FileManagerEntity fileManagerEntity = i19;
                    fileManagerDataCenter.q(str8, str9, true, str10, 0L, true, i26, str11, fileManagerEntity.msgSeq, j17, fileManagerEntity.msgUid, -1L, com.tencent.mobileqq.service.message.e.K0(), -1, bundle);
                }
                if (z16) {
                    QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + i19.nSessionId + "] SendLocalfile[" + i19.fileName + "], peerType[" + i19.peerType + "]");
                } else {
                    QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + i19.nSessionId + "] SendLocalfileToWeiyun[" + i19.fileName + "]");
                }
                Bundle bundle3 = new Bundle();
                if (!TextUtils.isEmpty(str72)) {
                    bundle3.putString("emptyPathCallStack", str72);
                }
                Bundle bundle4 = bundle;
                if (bundle4 != null) {
                    bundle3.putAll(bundle4);
                }
                FileManagerEngine.this.f206900e.getFileManagerRSCenter().k(i19, bundle3);
            }
        };
        if (i19.nFileType != 5) {
        }
        return i19;
    }

    public void I() {
        lc1.b.a().free();
        FileViewMusicService.c().s();
        com.tencent.mobileqq.filemanager.core.g.h();
        this.f206900e.getFileManagerRSCenter().l(false);
        QFileC2CTransferWrapper qFileC2CTransferWrapper = this.f206911p;
        if (qFileC2CTransferWrapper != null) {
            qFileC2CTransferWrapper.f();
        }
        QFileDiscTransferWrapper qFileDiscTransferWrapper = this.f206912q;
        if (qFileDiscTransferWrapper != null) {
            qFileDiscTransferWrapper.i();
        }
        com.tencent.mobileqq.filemanager.uftwrapper.b bVar = this.f206913r;
        if (bVar != null) {
            bVar.d();
        }
        com.tencent.mobileqq.filemanager.fileassistant.util.f fVar = this.f206910o;
        if (fVar != null) {
            fVar.b(this.f206900e);
            this.f206910o = null;
        }
        FileAssistantMgr fileAssistantMgr = this.f206909n;
        if (fileAssistantMgr != null) {
            fileAssistantMgr.e();
        }
        try {
            this.f206900e.getFileManagerNotifyCenter().deleteObservers();
            QLog.i("FileManagerEngine<FileAssistant><QFile>", 1, "free: remove all file observers.");
        } catch (Exception unused) {
        }
        MMApkFileSafeChecker mMApkFileSafeChecker = this.f206908m;
        if (mMApkFileSafeChecker != null) {
            mMApkFileSafeChecker.y();
        }
        ((IQQFileSelector) QRoute.api(IQQFileSelector.class)).free();
    }

    public boolean I0(String str, String str2) {
        return K0(str, str2, 0L, 0, null);
    }

    public synchronized QFileAppStorePromoteManager J() {
        QFileAppStorePromoteManager qFileAppStorePromoteManager;
        synchronized (this) {
            if (this.f206906k == null) {
                this.f206906k = new QFileAppStorePromoteManager(this.f206900e);
            }
            qFileAppStorePromoteManager = this.f206906k;
        }
        return qFileAppStorePromoteManager;
        return qFileAppStorePromoteManager;
    }

    public boolean J0(String str, String str2, long j3, int i3) {
        return K0(str, str2, j3, i3, null);
    }

    FileManagerDataCenter K() {
        return this.f206900e.getFileManagerDataCenter();
    }

    public boolean K0(String str, String str2, long j3, int i3, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        TroopFileTransferManager O = TroopFileTransferManager.O(this.f206900e, Long.parseLong(str2));
        if (O != null) {
            int abs = Math.abs(new Random().nextInt());
            t A0 = O.A0(str, true, abs, bundle);
            if (A0 == null) {
                QLog.e("FileManagerEngine<FileAssistant>", 1, "sendLocalFileByTroop startUpload return info is nlll!");
                return false;
            }
            if (!NTFileUtils.f208714a) {
                VFSFile vFSFile = new VFSFile(str);
                if (FileManagerUtil.getFileType(str) == 0) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    FilePicURLDrawlableHelper.m(str, options);
                    TroopFileUtils.r(this.f206900e, str2, vFSFile.getName(), vFSFile.length(), A0.f294967a.toString(), abs, null, 0L, options.outWidth, options.outHeight, 0, j3, i3, bundle);
                } else if (FileManagerUtil.getFileType(str) == 2) {
                    int[] videoFileRtAndTime = ShortVideoUtils.getVideoFileRtAndTime(str);
                    TroopFileUtils.r(this.f206900e, str2, vFSFile.getName(), vFSFile.length(), A0.f294967a.toString(), abs, null, 0L, videoFileRtAndTime[0], videoFileRtAndTime[1], videoFileRtAndTime[2], j3, i3, bundle);
                } else {
                    TroopFileUtils.r(this.f206900e, str2, vFSFile.getName(), vFSFile.length(), A0.f294967a.toString(), abs, null, 0L, 0, 0, 0, j3, i3, bundle);
                }
            }
        }
        return true;
    }

    public void L(String str, String str2) {
        this.f206900e.getFileTransferHandler().U0(str, str2);
    }

    public void L0(String str, String str2) {
        String str3;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            IGProChannelInfo channelInfo = ((IGPSService) this.f206900e.getRuntimeService(IGPSService.class, "")).getChannelInfo(str2);
            if (channelInfo != null) {
                str3 = channelInfo.getGuildId();
            } else {
                str3 = null;
            }
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            FileInfo N = N(str);
            HashSet hashSet = new HashSet();
            hashSet.add(N);
            M0(str3, str2, hashSet);
        }
    }

    public synchronized com.tencent.mobileqq.filemanager.app.b M() {
        com.tencent.mobileqq.filemanager.app.b bVar;
        synchronized (this) {
            if (this.f206903h == null) {
                this.f206903h = new com.tencent.mobileqq.filemanager.app.b(this.f206900e);
            }
            bVar = this.f206903h;
        }
        return bVar;
        return bVar;
    }

    public void M0(String str, String str2, Set<FileInfo> set) {
        QLog.d("FileManagerEngine<FileAssistant>", 1, "sendLocalFileToGuild localFiles Size=" + set.size());
        P().uploadFileToGuild(this.f206900e, str, str2, set);
    }

    public void N0(FileManagerEntity fileManagerEntity, String str, String str2, String str3, int i3) {
        O0(fileManagerEntity, str, str2, str3, i3, 0);
    }

    public synchronized QFileMsgForwardManager O() {
        QFileMsgForwardManager qFileMsgForwardManager;
        synchronized (this) {
            if (this.f206904i == null) {
                this.f206904i = new QFileMsgForwardManager(this.f206900e);
            }
            qFileMsgForwardManager = this.f206904i;
        }
        return qFileMsgForwardManager;
        return qFileMsgForwardManager;
    }

    public void O0(FileManagerEntity fileManagerEntity, String str, String str2, String str3, int i3, int i16) {
        this.f206900e.getNTFileManageBridger().Z(fileManagerEntity, str, str2, FileManagerUtil.checkAndGetUid(str3, str2, "sendWeiYun2OfflineFile"), i3, i16);
    }

    public synchronized IGuildFileTransferWrapper P() {
        if (this.f206914s == null) {
            synchronized (FileManagerEngine.class) {
                if (this.f206914s == null) {
                    this.f206914s = (IGuildFileTransferWrapper) QRoute.api(IGuildFileTransferWrapper.class);
                }
            }
        }
        return this.f206914s;
    }

    public void P0(FileManagerEntity fileManagerEntity, String str, String str2, String str3, int i3) {
        Q0(fileManagerEntity, str, str2, str3, i3, 0);
    }

    public synchronized MMApkFileSafeChecker Q() {
        if (this.f206908m == null) {
            MMApkFileSafeChecker mMApkFileSafeChecker = new MMApkFileSafeChecker(this.f206900e);
            this.f206908m = mMApkFileSafeChecker;
            mMApkFileSafeChecker.r();
        }
        return this.f206908m;
    }

    public void Q0(FileManagerEntity fileManagerEntity, String str, String str2, String str3, int i3, int i16) {
        String currentAccountUin;
        if (i3 == 1) {
            QLog.i("FileManagerEngine<FileAssistant>", 1, "=_= r [CS Send] Id[" + fileManagerEntity.nSessionId + "]Send WeiYun to Troop ");
            this.f206900e.getNTFileManageBridger().Z(fileManagerEntity, str, str2, str3, i3, i16);
            return;
        }
        if (str != null && str.length() != 0) {
            currentAccountUin = str;
        } else {
            currentAccountUin = this.f206900e.getCurrentAccountUin();
        }
        QLog.i("FileManagerEngine<FileAssistant>", 1, "=_= r [CS Send] Id[" + fileManagerEntity.nSessionId + "]Send WeiYun to offline ");
        O0(fileManagerEntity, currentAccountUin, str2, str3, i3, i16);
    }

    public synchronized com.tencent.mobileqq.filemanager.app.c R() {
        com.tencent.mobileqq.filemanager.app.c cVar;
        synchronized (this) {
            if (this.f206905j == null) {
                this.f206905j = new com.tencent.mobileqq.filemanager.app.c(this.f206900e);
            }
            cVar = this.f206905j;
        }
        return cVar;
        return cVar;
    }

    public void R0() {
        this.f206900e.getApplication().getSharedPreferences("OfflineFileConfigV2", 0).edit().putBoolean("HasNewDownload", true).commit();
    }

    public void S(String str, String str2) {
        this.f206900e.getFileTransferHandler().V0(str, str2);
    }

    public void S0(String str) {
        Y().J(str);
    }

    public synchronized QFileC2CTransferWrapper T() {
        if (this.f206911p == null) {
            this.f206911p = new QFileC2CTransferWrapper(this.f206900e);
        }
        return this.f206911p;
    }

    public synchronized QFileDiscTransferWrapper U() {
        if (this.f206912q == null) {
            this.f206912q = new QFileDiscTransferWrapper(this.f206900e);
        }
        return this.f206912q;
    }

    public synchronized com.tencent.mobileqq.filemanager.uftwrapper.b V() {
        if (this.f206913r == null) {
            this.f206913r = new com.tencent.mobileqq.filemanager.uftwrapper.b(this.f206900e);
        }
        return this.f206913r;
    }

    public synchronized IQQFavProxy W() {
        IQQFavProxy iQQFavProxy;
        synchronized (this) {
            if (this.f206907l == null) {
                this.f206907l = (IQQFavProxy) this.f206900e.getRuntimeService(IQQFavProxy.class);
            }
            iQQFavProxy = this.f206907l;
        }
        return iQQFavProxy;
        return iQQFavProxy;
    }

    public ThumbHttpDownloader X() {
        if (this.f206899d == null) {
            synchronized (FileManagerEngine.class) {
                if (this.f206899d == null) {
                    QLog.i("FileManagerEngine<FileAssistant>", 1, "getThumbHttpDownloader need new ThumbHttpDownloader, thread id:" + Thread.currentThread().getId());
                    this.f206899d = new ThumbHttpDownloader(this.f206900e);
                }
            }
        }
        return this.f206899d;
    }

    public synchronized com.tencent.mobileqq.filemanageraux.core.b Y() {
        if (this.f206901f == null) {
            this.f206901f = new com.tencent.mobileqq.filemanageraux.core.b(this.f206900e);
        }
        return this.f206901f;
    }

    public String Z(String str, String str2, int i3, Object obj) {
        return Y().s(str, str2, i3, obj);
    }

    public void a(List<String> list, String str, String str2, String str3, int i3, boolean z16, long j3, int i16, Bundle bundle) {
        QLog.d("FileManagerEngine<FileAssistant>", 1, "sendLocalFile strFilePath: " + list.size() + " ,srcDiscUin: " + str + " ,recvUin: " + str2 + " ,recvUid: " + str3 + " ,peerType: " + i3 + " ,toOffline: " + z16 + " ,originUniSeq: " + j3 + " ,forwardID: " + i16 + " ,extBundle: " + bundle);
        T().b(list, str, str2, FileManagerUtil.checkAndGetUid(str3, str2, "sendLocalFile"), i3, j3, i16, bundle);
    }

    public void a0(String str, String str2) {
        this.f206901f.k(str, str2);
    }

    public FileManagerEntity b(c cVar) {
        if (cVar != null && cVar.c()) {
            FileManagerDataCenter K = K();
            FileManagerEntity j3 = K.j(cVar.b(), com.tencent.mobileqq.filemanager.data.e.f207742a);
            if (j3 == null) {
                j3 = f(cVar);
            }
            K.u(j3);
            return j3;
        }
        return null;
    }

    public String b0(String str, String str2, int i3, Object obj) {
        return Y().u(str, str2, i3, obj);
    }

    public void c(FileManagerEntity fileManagerEntity, Context context) {
        if (fileManagerEntity != null && context != null) {
            dc1.d dVar = new dc1.d(context, new dc1.b(this.f206900e, context, fileManagerEntity, Integer.MAX_VALUE));
            dVar.m(14);
            dVar.l(false);
            dVar.p(true);
            dVar.s(268435456);
            dVar.d();
        }
    }

    public synchronized ThumbDownloadManager c0() {
        if (this.f206902g == null) {
            this.f206902g = new ThumbDownloadManager(this.f206900e);
        }
        return this.f206902g;
    }

    public void d() {
        this.f206900e.getApplication().getSharedPreferences("OfflineFileConfigV2", 0).edit().putBoolean("HasNewDownload", false).commit();
    }

    public boolean d0() {
        return Y().v();
    }

    public FileManagerEntity e(FileManagerEntity fileManagerEntity) {
        FileManagerEntity fileManagerEntity2 = new FileManagerEntity();
        fileManagerEntity2.nSessionId = FileManagerUtil.genSessionId().longValue();
        fileManagerEntity2.Uuid = fileManagerEntity.Uuid;
        fileManagerEntity2.selfUin = fileManagerEntity.selfUin;
        fileManagerEntity2.peerUin = fileManagerEntity.selfUin;
        fileManagerEntity2.peerType = fileManagerEntity.peerType;
        fileManagerEntity2.fileName = fileManagerEntity.fileName;
        fileManagerEntity2.fileSize = fileManagerEntity.fileSize;
        fileManagerEntity2.strThumbPath = fileManagerEntity.strThumbPath;
        fileManagerEntity2.status = 2;
        fileManagerEntity2.nOpType = 29;
        fileManagerEntity2.busId = 3;
        this.f206900e.getFileManagerDataCenter().v(fileManagerEntity2);
        return fileManagerEntity2;
    }

    FileManagerEntity f(c cVar) {
        FileManagerEntity fileManagerEntity = new FileManagerEntity();
        fileManagerEntity.nSessionId = FileManagerUtil.genSessionId().longValue();
        fileManagerEntity.bSend = false;
        fileManagerEntity.peerUin = AppConstants.PUBLIC_ACCOUNT_QQ_MAIL;
        fileManagerEntity.peerType = com.tencent.mobileqq.filemanager.data.e.f207742a;
        fileManagerEntity.cloudType = 13;
        fileManagerEntity.nOpType = 54;
        fileManagerEntity.nFileType = -1;
        fileManagerEntity.fileSize = cVar.f206927b;
        fileManagerEntity.strServerPath = cVar.f206926a;
        fileManagerEntity.fileName = cVar.a();
        fileManagerEntity.Uuid = cVar.b();
        fileManagerEntity.strFileMd5 = cVar.f206930e;
        return fileManagerEntity;
    }

    public FileManagerEntity g(FileManagerEntity fileManagerEntity, String str, int i3) {
        if (fileManagerEntity == null) {
            if (QLog.isColorLevel()) {
                QLog.e("FileManagerEngine<FileAssistant>", 2, "insertForwardOfflineEntity , FilemanagerEntity is null!");
            }
            FileManagerUtil.printStack();
            return null;
        }
        FileManagerEntity fileManagerEntity2 = new FileManagerEntity();
        fileManagerEntity2.copyFrom(fileManagerEntity);
        fileManagerEntity2.nSessionId = FileManagerUtil.genSessionId().longValue();
        String str2 = fileManagerEntity2.fileName;
        if (str2 == null || str2.length() == 0) {
            fileManagerEntity2.fileName = FileManagerUtil.getFileName(fileManagerEntity2.getFilePath());
        }
        if (fileManagerEntity2.getFilePath() == null || fileManagerEntity2.getFilePath().length() == 0) {
            fileManagerEntity2.setFilePath(fileManagerEntity2.fileName);
        }
        fileManagerEntity2.uniseq = com.tencent.mobileqq.service.message.q.d(-1000).uniseq;
        fileManagerEntity2.nOpType = 26;
        fileManagerEntity2.bSend = true;
        fileManagerEntity2.isReaded = true;
        fileManagerEntity2.peerType = i3;
        fileManagerEntity2.peerUin = str;
        fileManagerEntity2.peerNick = FileManagerUtil.getPeerNick(this.f206900e, str, null, i3);
        int i16 = fileManagerEntity.peerType;
        if (i16 != 3000 && i16 != 1) {
            fileManagerEntity2.selfUin = this.f206900e.getCurrentUin();
        } else {
            fileManagerEntity2.selfUin = fileManagerEntity.peerUin;
        }
        fileManagerEntity2.srvTime = com.tencent.mobileqq.service.message.e.K0() * 1000;
        fileManagerEntity2.setCloudType(fileManagerEntity.cloudType);
        fileManagerEntity2.status = 2;
        fileManagerEntity2.msgSeq = FileManagerUtil.genMsgSeq();
        fileManagerEntity2.msgUid = FileManagerUtil.genMsgUid();
        if (QLog.isColorLevel()) {
            QLog.i("FileManagerEngine<FileAssistant>", 2, "insertForwardOfflineEntity FilemanagerEntity:" + FileManagerUtil.printFileManagerEntityInfo(fileManagerEntity2));
        }
        this.f206900e.getFileManagerDataCenter().v(fileManagerEntity2);
        return fileManagerEntity2;
    }

    public FileManagerEntity g0(FileManagerEntity fileManagerEntity, String str, String str2, String str3, int i3, boolean z16) {
        return h0(fileManagerEntity, str, str2, str3, i3, z16, 0L, 0);
    }

    public void h(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i("FileManagerEngine<FileAssistant>", 2, "delAllSelectedFiles, bDelLocalFile[" + z16 + "]");
        }
        IFMDataCacheApi iFMDataCacheApi = (IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class);
        ArrayList arrayList = new ArrayList();
        for (FileInfo fileInfo : iFMDataCacheApi.getLocalFiles()) {
            if (fileInfo.p()) {
                String k3 = fileInfo.k();
                try {
                    VFSFile vFSFile = new VFSFile(k3);
                    arrayList.add(k3);
                    vFSFile.delete();
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("FileManagerEngine<FileAssistant>", 2, "delAllSelectedFiles local exception:" + e16.toString());
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            MediaScannerConnection.scanFile(BaseApplication.getContext(), (String[]) arrayList.toArray(new String[0]), null, null);
        }
        for (int i3 = 0; i3 < iFMDataCacheApi.getWeiYunFiles().size(); i3++) {
            k(iFMDataCacheApi.getWeiYunFiles().get(i3));
        }
        for (int i16 = 0; i16 < iFMDataCacheApi.getRecentFiles().size(); i16++) {
            FileManagerEntity fileManagerEntity = iFMDataCacheApi.getRecentFiles().get(i16);
            ((IQQFileSelectorUtil) QRoute.api(IQQFileSelectorUtil.class)).upDataApkPathForPackageName(fileManagerEntity);
            i(fileManagerEntity.nSessionId);
        }
    }

    public FileManagerEntity h0(FileManagerEntity fileManagerEntity, String str, String str2, String str3, int i3, boolean z16, long j3, int i16) {
        return this.f206900e.getNTFileManageBridger().C0(fileManagerEntity, str, str2, str3, i3, z16, j3, i16);
    }

    public boolean i(long j3) {
        FileManagerEntity D = this.f206900e.getFileManagerDataCenter().D(j3);
        if (D == null) {
            if (QLog.isColorLevel()) {
                QLog.e("FileManagerEngine<FileAssistant>", 2, "delete record fail. entity is null, sessionid: " + j3);
                return false;
            }
            return false;
        }
        if (D.getCloudType() == 0) {
            this.f206900e.getOnlineFileSessionCenter().u(j3);
        } else if (!this.f206900e.getFileManagerRSCenter().m(j3) && QLog.isColorLevel()) {
            QLog.w("FileManagerEngine<FileAssistant>", 2, "Pause[" + String.valueOf(j3) + "] faild!,status[" + String.valueOf(D.status) + "]");
        }
        boolean Z = this.f206900e.getFileManagerDataCenter().Z(D);
        if (D.bDelInAio && D.bDelInFM && D.getCloudType() == 0) {
            this.f206900e.getOnlineFileSessionCenter().B(D.nSessionId);
        }
        if (FileManagerUtil.fileExist(D.getFilePath())) {
            D.cloudType = 3;
        } else {
            QLog.d("FileManagerEngine<FileAssistant>", 1, "delete file fileSize = " + D.fileSize + " fileType = " + D.nFileType + " uuid = " + D.Uuid);
            D.status = 16;
        }
        if (D.bDelInAio && D.bDelInFM) {
            return true;
        }
        this.f206900e.getFileManagerDataCenter().f0(D);
        return Z;
    }

    public boolean i0(long j3) {
        QLog.i("FileManagerEngine<FileAssistant>", 1, "sessionid[" + String.valueOf(j3) + "] call Pause");
        FileManagerEntity D = this.f206900e.getFileManagerDataCenter().D(j3);
        if (D == null) {
            if (QLog.isColorLevel()) {
                QLog.w("FileManagerEngine<FileAssistant>", 2, "sessionid[" + String.valueOf(j3) + "] item is not exist");
            }
            return false;
        }
        if (D.getCloudType() == 0 && 1 != D.nOpType) {
            this.f206900e.getOnlineFileSessionCenter().u(j3);
            return true;
        }
        if (com.tencent.mobileqq.filemanager.fileassistant.util.h.g(this.f206900e).equals(D.peerUin)) {
            if (D.bSend) {
                return this.f206909n.d(D);
            }
            return this.f206909n.c(D);
        }
        int i3 = D.nOpType;
        if (1 == i3) {
            FileManagerReporter.a aVar = new FileManagerReporter.a();
            aVar.f209157b = "recv_file_cancel";
            FileManagerReporter.addData(this.f206900e.getCurrentAccountUin(), aVar);
        } else if (i3 == 0) {
            FileManagerReporter.a aVar2 = new FileManagerReporter.a();
            aVar2.f209157b = "send_file_cancel";
            FileManagerReporter.addData(this.f206900e.getCurrentAccountUin(), aVar2);
        }
        int i16 = D.nOpType;
        if (i16 == 52) {
            if (D.peerType == 10014) {
                return P().cancelSend(this.f206900e, j3);
            }
            QLog.e("FileManagerEngine<FileAssistant>", 1, " cancel send error sessionId = " + j3);
            return false;
        }
        if (i16 == 0) {
            if (D.peerType == 3000) {
                return U().g(j3);
            }
            return T().d(j3);
        }
        if (j3 > 0) {
            return this.f206900e.getFileManagerRSCenter().m(j3);
        }
        if (D.peerUin != null && D.uniseq != -1) {
            QLog.e("FileManagerEngine<FileAssistant>", 2, "Pause: can not find file entity info.");
            return false;
        }
        return this.f206900e.getFileManagerRSCenter().n(D.peerUin, D.uniseq, D.peerType);
    }

    public void j(String str, String str2, String str3, String str4, boolean z16) {
        QLog.i("FileManagerEngine<FileAssistant>", 1, "deleteOfflineFile, peerUin[" + FileManagerUtil.enCodecString(str) + "],fileName[" + str2 + "],uuid[" + str3 + "]");
        this.f206900e.getFileTransferHandler().c1(str, str3, str4, str2, z16);
    }

    public void j0() {
        Y().y();
    }

    public void k(WeiYunFileInfo weiYunFileInfo) {
        Y().f(weiYunFileInfo);
    }

    public void k0(int i3, String str, int i16, int i17, String str2) {
        Y().z(i3, str, i16, i17, str2);
    }

    public void l(Context context) {
        int i3;
        IFMDataCacheApi iFMDataCacheApi = (IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class);
        int size = iFMDataCacheApi.getWeiYunFiles().size();
        int size2 = iFMDataCacheApi.getOfflineFiles().size();
        Iterator<FileManagerEntity> it = iFMDataCacheApi.getRecentFiles().iterator();
        int i16 = 0;
        while (it.hasNext()) {
            if (it.next().nFileType == 13) {
                i16++;
            }
        }
        int size3 = iFMDataCacheApi.getRecentFiles().size() - i16;
        QLog.i("FileManagerEngine<FileAssistant>", 1, "=_= v> Download All Select File Start!, weiyun[" + size + "],offline[" + size2 + "],recent[" + size3 + "]");
        int i17 = 2;
        if (QLog.isColorLevel()) {
            QLog.i("FileManagerEngine<FileAssistant>", 2, "downLoadAllSelectFiles,weiyun[" + iFMDataCacheApi.getWeiYunFiles().size() + "], offline[" + iFMDataCacheApi.getOfflineFiles().size() + "], recent[" + (iFMDataCacheApi.getRecentFiles().size() - i16) + "], localfile[" + iFMDataCacheApi.getLocalFiles().size() + "]");
        }
        if (i16 > 0 && size3 == 0 && size == 0 && size2 == 0) {
            DialogUtil.createCustomDialog(context, 230).setMessage(context.getString(R.string.f170959ba1)).setNegativeButton(R.string.hkf, new b()).show();
            return;
        }
        int i18 = 0;
        while (i18 < size) {
            FileManagerEntity newEntityByWeiYunFileInfo = FileManagerUtil.newEntityByWeiYunFileInfo(iFMDataCacheApi.getWeiYunFiles().get(i18));
            this.f206900e.getFileManagerDataCenter().t(newEntityByWeiYunFileInfo);
            if (QLog.isColorLevel()) {
                QLog.i("FileManagerEngine<FileAssistant>", i17, "downWeiYunFiles,weiyun[" + i18 + "]");
            }
            s0(newEntityByWeiYunFileInfo.nSessionId, newEntityByWeiYunFileInfo.uniseq, newEntityByWeiYunFileInfo.peerUin, newEntityByWeiYunFileInfo.peerType, 5);
            i18++;
            i17 = 2;
        }
        int i19 = i17;
        for (int i26 = 0; i26 < size2; i26++) {
            FileManagerEntity newEntityByOfflineFileInfo = FileManagerUtil.newEntityByOfflineFileInfo(iFMDataCacheApi.getOfflineFiles().get(i26), 0);
            newEntityByOfflineFileInfo.status = i19;
            if (QLog.isColorLevel()) {
                QLog.i("FileManagerEngine<FileAssistant>", i19, "downOfflineFiles,weiyun[" + i26 + "]");
            }
            s0(newEntityByOfflineFileInfo.nSessionId, newEntityByOfflineFileInfo.uniseq, newEntityByOfflineFileInfo.peerUin, newEntityByOfflineFileInfo.peerType, 8);
        }
        for (int i27 = 0; i27 < iFMDataCacheApi.getRecentFiles().size(); i27++) {
            FileManagerEntity fileManagerEntity = iFMDataCacheApi.getRecentFiles().get(i27);
            ((IQQFileSelectorUtil) QRoute.api(IQQFileSelectorUtil.class)).upDataApkPathForPackageName(fileManagerEntity);
            if (fileManagerEntity.status != 16 && fileManagerEntity.nFileType != 13) {
                int cloudType = fileManagerEntity.getCloudType();
                if (cloudType != 1) {
                    if (cloudType != i19) {
                        if (cloudType != 3) {
                            QLog.e("FileManagerEngine<FileAssistant>", i19, "unknow type,Engity:" + FileManagerUtil.printFileManagerEntityInfo(fileManagerEntity));
                        } else if (QLog.isColorLevel()) {
                            QLog.i("FileManagerEngine<FileAssistant>", i19, "=_= v> downRecentFiles,local[" + i27 + "] break");
                        }
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.i("FileManagerEngine<FileAssistant>", i19, "downRecentFiles,weiyun[" + i27 + "]");
                        }
                        s0(fileManagerEntity.nSessionId, fileManagerEntity.uniseq, fileManagerEntity.peerUin, fileManagerEntity.peerType, 5);
                    }
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.i("FileManagerEngine<FileAssistant>", i19, "downRecentFiles,offline[" + i27 + "]");
                    }
                    if (fileManagerEntity.bSend && (i3 = fileManagerEntity.status) != 1 && i3 != -1 && i3 != 3) {
                        QLog.w("FileManagerEngine<FileAssistant>", i19, "=_= v> downRecentFiles,but Id[" + fileManagerEntity.nSessionId + "] is sendStatus but no Success! continiu");
                    } else {
                        s0(fileManagerEntity.nSessionId, fileManagerEntity.uniseq, fileManagerEntity.peerUin, fileManagerEntity.peerType, 8);
                    }
                }
            }
        }
    }

    public String m(FileManagerEntity fileManagerEntity, int i3) {
        if (this.f206896a == null) {
            synchronized (FileManagerEngine.class) {
                if (this.f206896a == null) {
                    this.f206896a = new DiscPicThumbDownloader(this.f206900e);
                }
            }
        }
        return this.f206896a.s(fileManagerEntity, i3);
    }

    public void n(FileManagerEntity fileManagerEntity, int i3) {
        if (fileManagerEntity.nFileType == 0) {
            m(fileManagerEntity, i3);
        } else if (fileManagerEntity.peerType == 3000) {
            o(fileManagerEntity);
        } else {
            p(fileManagerEntity);
        }
    }

    public String o(FileManagerEntity fileManagerEntity) {
        if (this.f206898c == null) {
            synchronized (FileManagerEngine.class) {
                if (this.f206898c == null) {
                    this.f206898c = new com.tencent.mobileqq.filemanager.core.c(this.f206900e);
                }
            }
        }
        return this.f206898c.s(fileManagerEntity, 7);
    }

    public void o0(long j3) {
        l0(j3);
    }

    public String p(FileManagerEntity fileManagerEntity) {
        if (this.f206897b == null) {
            synchronized (FileManagerEngine.class) {
                if (this.f206897b == null) {
                    this.f206897b = new o(this.f206900e);
                }
            }
        }
        return this.f206897b.s(fileManagerEntity, 7);
    }

    public String q(FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity == null) {
            return null;
        }
        String zipThumbSavePath = FileManagerUtil.getZipThumbSavePath(fileManagerEntity);
        if (q.f(zipThumbSavePath)) {
            return zipThumbSavePath;
        }
        c0().p(fileManagerEntity.nSessionId, zipThumbSavePath, fileManagerEntity.strServerPath);
        return null;
    }

    public void r0(MessageRecord messageRecord, FileManagerEntity fileManagerEntity, e.a aVar) {
        if (fileManagerEntity.peerType == 3000) {
            this.f206900e.getFileTransferHandler().e1(messageRecord.frienduin, messageRecord.senderuin, fileManagerEntity.Uuid, aVar);
        } else {
            this.f206900e.getFileTransferHandler().d1(fileManagerEntity, aVar);
        }
    }

    public void s0(long j3, long j16, String str, int i3, int i16) {
        this.f206900e.getFileManagerRSCenter().g(j3, j16, str, i3, i16);
    }

    public void t(long j3, String str) {
        y(38, j3, str);
    }

    public void t0(FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity == null) {
            if (QLog.isColorLevel()) {
                QLog.e("FileManagerEngine<FileAssistant>", 2, "ReviceFile,entity is null!");
                return;
            }
            return;
        }
        if (com.tencent.mobileqq.filemanager.fileassistant.util.h.k(fileManagerEntity.peerUin)) {
            if (QLog.isColorLevel()) {
                QLog.w("FileManagerEngine<FileAssistant>.NFRV", 2, "ReviceFile, entity[" + fileManagerEntity.nSessionId + "] is newFileAssistant ");
            }
            this.f206909n.g(fileManagerEntity);
            return;
        }
        int cloudType = fileManagerEntity.getCloudType();
        if (cloudType != 1) {
            if (cloudType != 2) {
                if (cloudType != 3) {
                    if (cloudType != 12) {
                        if (cloudType != 13) {
                            QLog.e("FileManagerEngine<FileAssistant>", 1, "ReviceFile, cloud type error:" + fileManagerEntity.getCloudType());
                        } else {
                            QLog.i("FileManagerEngine<FileAssistant>", 1, "ReviceFile, CLOUD_TYPE_QQ_MAIL_ATTACHMENT");
                            s0(fileManagerEntity.nSessionId, fileManagerEntity.uniseq, fileManagerEntity.peerUin, fileManagerEntity.peerType, 54);
                        }
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.w("FileManagerEngine<FileAssistant>", 2, "ReviceFile, entity is CLOUD_TYPE_OFFLINE ,peerType[" + fileManagerEntity.peerType + "]");
                        }
                        s0(fileManagerEntity.nSessionId, fileManagerEntity.uniseq, fileManagerEntity.peerUin, fileManagerEntity.peerType, 53);
                    }
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.w("FileManagerEngine<FileAssistant>", 2, "ReviceFile, but entity is localFile");
                    }
                    if (!q.f(fileManagerEntity.strFilePath) && !TextUtils.isEmpty(fileManagerEntity.Uuid)) {
                        fileManagerEntity.fProgress = 0.0f;
                        s0(fileManagerEntity.nSessionId, fileManagerEntity.uniseq, fileManagerEntity.peerUin, fileManagerEntity.peerType, 1);
                        return;
                    }
                    return;
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.w("FileManagerEngine<FileAssistant>", 2, "ReviceFile, entity is CLOUD_TYPE_WEIYUN ,peerType[" + fileManagerEntity.peerType + "]");
                }
                this.f206900e.getFileManagerDataCenter().t(fileManagerEntity);
                if (fileManagerEntity.nOpType == 50) {
                    s0(fileManagerEntity.nSessionId, fileManagerEntity.uniseq, fileManagerEntity.peerUin, fileManagerEntity.peerType, 50);
                } else {
                    s0(fileManagerEntity.nSessionId, fileManagerEntity.uniseq, fileManagerEntity.peerUin, fileManagerEntity.peerType, 5);
                }
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.w("FileManagerEngine<FileAssistant>", 2, "ReviceFile, entity is CLOUD_TYPE_OFFLINE ,peerType[" + fileManagerEntity.peerType + "]");
            }
            s0(fileManagerEntity.nSessionId, fileManagerEntity.uniseq, fileManagerEntity.peerUin, fileManagerEntity.peerType, 1);
        }
        R0();
    }

    public void u(FileManagerEntity fileManagerEntity, int i3) {
        v(fileManagerEntity, i3, 0L, 0);
    }

    public ArrayList<FileManagerEntity> u0() {
        FileManagerEntity v06;
        IFMDataCacheApi iFMDataCacheApi = (IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class);
        if (QLog.isColorLevel()) {
            QLog.i("FileManagerEngine<FileAssistant>", 2, "saveAllSelectFileToWeiYun");
        }
        ArrayList<FileManagerEntity> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < iFMDataCacheApi.getOfflineFiles().size(); i3++) {
            OfflineFileInfo offlineFileInfo = iFMDataCacheApi.getOfflineFiles().get(i3);
            arrayList.add(v0(FileManagerUtil.newEntityByOfflineFileInfo(offlineFileInfo, 0), String.valueOf(offlineFileInfo.f207723h)));
        }
        for (int i16 = 0; i16 < iFMDataCacheApi.getRecentFiles().size(); i16++) {
            FileManagerEntity fileManagerEntity = iFMDataCacheApi.getRecentFiles().get(i16);
            if (!fileManagerEntity.sendCloudUnsuccessful()) {
                ((IQQFileSelectorUtil) QRoute.api(IQQFileSelectorUtil.class)).upDataApkPathForPackageName(fileManagerEntity);
                int cloudType = fileManagerEntity.getCloudType();
                if (cloudType != 1) {
                    if (cloudType != 3 && cloudType != 5) {
                        v06 = null;
                    } else if (FileUtils.fileExistsAndNotEmpty(fileManagerEntity.getFilePath())) {
                        v06 = F0(fileManagerEntity.getFilePath(), "", this.f206900e.getCurrentAccountUin(), "", 0, false);
                    }
                } else {
                    v06 = v0(fileManagerEntity, String.valueOf(fileManagerEntity.peerUin));
                }
                if (v06 != null) {
                    arrayList.add(v06);
                }
            }
        }
        for (FileInfo fileInfo : iFMDataCacheApi.getLocalFiles()) {
            FileManagerEntity F0 = F0(fileInfo.k(), "", this.f206900e.getAccount(), "", 0, false);
            F0.strApkPackageName = fileInfo.c();
            arrayList.add(F0);
        }
        return arrayList;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x00d5. Please report as an issue. */
    public void v(FileManagerEntity fileManagerEntity, int i3, long j3, int i16) {
        String str;
        String str2;
        if (fileManagerEntity == null) {
            if (QLog.isColorLevel()) {
                QLog.e("FileManagerEngine<FileAssistant>", 2, "FileManagerEntity is null!!!");
                return;
            }
            return;
        }
        fileManagerEntity.nOpType = i3;
        QLog.e("FileManagerEngine<FileAssistant>", 1, "ForwardDisc2X, nOperationType[" + i3 + "]");
        FileManagerUtil.addCloseButtonSessionId(fileManagerEntity.nSessionId);
        int i17 = 3;
        if (i3 != 27 && !NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            fileManagerEntity.status = 0;
            this.f206900e.getFileManagerNotifyCenter().b(false, 34, new Object[]{0, null, null, Long.valueOf(fileManagerEntity.nSessionId)});
            FileManagerUtil.reportFilemanagerFaildInfo(this.f206900e, fileManagerEntity.nSessionId, "actFileDisc2Wy", 0L, "", fileManagerEntity.peerUin, fileManagerEntity.Uuid, fileManagerEntity.strFileMd5, 9004L, "Error_No_Network", 0L, 0L, 0L, "", "", 0, "Error_No_Network", "");
            return;
        }
        QLog.i("FileManagerEngine<FileAssistant>", 1, "ForwardDisc2X, nId[" + fileManagerEntity.nSessionId + "], type[" + i3 + "]");
        fileManagerEntity.bSend = true;
        fileManagerEntity.fProgress = 0.0f;
        fileManagerEntity.status = 2;
        fileManagerEntity.nOpType = i3;
        if (i3 != 27) {
            switch (i3) {
                case 20:
                    QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + fileManagerEntity.nSessionId + "] Disc2Weiyun[" + fileManagerEntity.fileName + "]");
                    i17 = 25;
                    str = "FileManagerEngine<FileAssistant>";
                    break;
                case 21:
                    QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + fileManagerEntity.nSessionId + "] Disc2Offline[" + fileManagerEntity.fileName + "]");
                    str = "FileManagerEngine<FileAssistant>";
                    break;
                case 22:
                    QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + fileManagerEntity.nSessionId + "] Disc2Disc[" + fileManagerEntity.fileName + "]");
                    this.f206900e.getFileTransferHandler().x(fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.fileSize, fileManagerEntity.selfUin, fileManagerEntity.fileName, fileManagerEntity.Uuid, fileManagerEntity.strFileMd5);
                    return;
                default:
                    str = "FileManagerEngine<FileAssistant>";
                    i17 = 0;
                    break;
            }
        } else {
            QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + fileManagerEntity.nSessionId + "] Disc2Troop[" + fileManagerEntity.fileName + "]");
            if (!TextUtils.isEmpty(fileManagerEntity.strTroopFileUuid) && fileManagerEntity.mContext != null) {
                str = "FileManagerEngine<FileAssistant>";
            } else {
                w troopProcessCallback = FileManagerUtil.getTroopProcessCallback(this.f206900e);
                String currentAccountUin = this.f206900e.getCurrentAccountUin();
                int i18 = fileManagerEntity.peerType;
                str = "FileManagerEngine<FileAssistant>";
                fileManagerEntity.strTroopFileUuid = troopProcessCallback.a(currentAccountUin, i18, fileManagerEntity.peerUin, i18, fileManagerEntity.Uuid, fileManagerEntity.fileName, fileManagerEntity.fileSize, fileManagerEntity.nSessionId, j3, i16);
                fileManagerEntity.mContext = troopProcessCallback;
            }
            int i19 = fileManagerEntity.busId;
            if (i19 != 102 && i19 != 104) {
                fileManagerEntity.busId = 102;
            }
            i17 = fileManagerEntity.busId;
            if (!NetworkUtil.isNetSupport(BaseApplication.getContext()) && (fileManagerEntity.mContext instanceof w)) {
                ((w) fileManagerEntity.mContext).d(false, fileManagerEntity.strTroopFileUuid, fileManagerEntity.nSessionId, 9004, BaseApplication.getContext().getString(R.string.cjm), String.valueOf(fileManagerEntity.peerUin), "");
                return;
            }
        }
        if (fileManagerEntity.selfUin.equalsIgnoreCase(this.f206900e.getCurrentAccountUin())) {
            str2 = str;
            QLog.e(str2, 1, "ForwardDisc2X, nId[" + fileManagerEntity.nSessionId + "], type[" + i3 + "] error");
            if (QLog.isDevelopLevel()) {
                QLog.e(str2, 1, "\u591a\u4eba\u804a\u5929\u8f6c\u53d1\uff0cselfUin\u4e0d\u80fd\u4e3a\u81ea\u5df1\uff01\uff01\uff01");
                throw new NullPointerException(HardCodeUtil.qqStr(R.string.mjh));
            }
        } else {
            str2 = str;
        }
        if (QLog.isColorLevel()) {
            QLog.i(str2, 2, "ForwardDisc2X" + FileManagerUtil.printFileManagerEntityInfo(fileManagerEntity));
        }
        if (i3 == 20) {
            ((IWeiyunResponseHandler) QRoute.api(IWeiyunResponseHandler.class)).startSave2Weiyun();
        }
        this.f206900e.getFileTransferHandler().y(fileManagerEntity, i17);
    }

    public FileManagerEntity v0(FileManagerEntity fileManagerEntity, String str) {
        FileManagerEntity x16 = Y().x(fileManagerEntity, str);
        if (fileManagerEntity.peerType == 3000) {
            u(x16, 20);
            QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + x16.nSessionId + "] SendDisc2Weiyun[" + x16.fileName + "]");
        } else {
            B(x16);
            QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + x16.nSessionId + "] SendOffline2Weiyun[" + x16.fileName + "]");
        }
        return x16;
    }

    public void w(int i3, long j3, int i16) {
        FileManagerEntity D = this.f206900e.getFileManagerDataCenter().D(j3);
        if (D != null) {
            x(i3, e(D), i16);
        }
    }

    public void w0(String str, String str2, String str3, int i3) {
        IFMDataCacheApi iFMDataCacheApi = (IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class);
        for (int i16 = 0; i16 < iFMDataCacheApi.getWeiYunFiles().size(); i16++) {
            WeiYunFileInfo weiYunFileInfo = iFMDataCacheApi.getWeiYunFiles().get(i16);
            FileManagerReporter.addData("0X8005415");
            P0(FileManagerUtil.newEntityByWeiYunFileInfo(weiYunFileInfo), str, str2, str3, i3);
        }
        if (iFMDataCacheApi.getWeiYunFiles().size() > 0) {
            ReportController.n(this.f206900e, "dc00898", "", "", "0X800AFB7", "0X800AFB7", 0, iFMDataCacheApi.getWeiYunFiles().size(), 0, "", "", "", "");
        }
    }

    public boolean x(int i3, FileManagerEntity fileManagerEntity, int i16) {
        if (0 == fileManagerEntity.datalineEntitySessionId) {
            w datalineProcessCallBack = FileManagerUtil.getDatalineProcessCallBack(this.f206900e, i16);
            fileManagerEntity.datalineEntitySessionId = datalineProcessCallBack.c(fileManagerEntity.peerUin, fileManagerEntity.peerType, fileManagerEntity.selfUin, i3, fileManagerEntity.Uuid, fileManagerEntity.fileName, fileManagerEntity.strThumbPath, fileManagerEntity.fileSize, 0);
            fileManagerEntity.mContext = datalineProcessCallBack;
        } else if (fileManagerEntity.mContext == null) {
            fileManagerEntity.mContext = FileManagerUtil.getDatalineProcessCallBack(this.f206900e, i16);
        }
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            String string = BaseApplication.getContext().getString(R.string.cjm);
            fileManagerEntity.status = 0;
            this.f206900e.getFileManagerNotifyCenter().b(false, 19, new Object[]{9004, string, 0L, 0L, null, Long.valueOf(fileManagerEntity.nSessionId)});
            Object obj = fileManagerEntity.mContext;
            if (obj instanceof w) {
                ((w) obj).e(false, fileManagerEntity.datalineEntitySessionId, 9004, string, null, null, null);
            }
            return false;
        }
        this.f206900e.getFileTransferHandler().k(38, i3, fileManagerEntity);
        return true;
    }

    public void x0(String str, String str2, String str3, int i3) {
        IFMDataCacheApi iFMDataCacheApi = (IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class);
        if (iFMDataCacheApi.getFavFiles().size() > 0) {
            W().sendFavFiles(iFMDataCacheApi.getFavFiles(), str2, str3, i3, null);
        }
        if (iFMDataCacheApi.getFavFiles().size() > 0) {
            ReportController.n(this.f206900e, "dc00898", "", "", "0X800AFB6", "0X800AFB6", 0, iFMDataCacheApi.getFavFiles().size(), 0, "", "", "", "");
        }
    }

    public void y(int i3, long j3, String str) {
        z(i3, j3, str, 0L, 0);
    }

    public void y0(boolean z16, String str, String str2, String str3, int i3) {
        int i16;
        String str4;
        int i17;
        IFMDataCacheApi iFMDataCacheApi = (IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class);
        QLog.i("FileManagerEngine<FileAssistant>", 1, "=_= ^> Send All Select File Start!, weiyun[" + iFMDataCacheApi.getWeiYunFiles().size() + "],offline[" + iFMDataCacheApi.getOfflineFiles().size() + "],recent[" + iFMDataCacheApi.getRecentFiles().size() + "],local[" + iFMDataCacheApi.getLocalFiles().size() + "] sendUin[" + FileManagerUtil.enCodecString(str) + "] recvUin[" + FileManagerUtil.enCodecString(str2) + "] recvUid[" + str3 + "] peerType[" + i3 + "]");
        try {
            SharedPreferences.Editor edit = this.f206900e.getApplication().getSharedPreferences("aio_last_select_file", 0).edit();
            edit.putBoolean("last_select_send", true);
            edit.commit();
            if (iFMDataCacheApi.getWeiYunFiles().size() == 0 && iFMDataCacheApi.getOfflineFiles().size() == 0 && iFMDataCacheApi.getFavFiles().size() == 0) {
                Set<FileInfo> localFiles = iFMDataCacheApi.getLocalFiles();
                ArrayList<FileManagerEntity> recentFiles = iFMDataCacheApi.getRecentFiles();
                Iterator<FileInfo> it = localFiles.iterator();
                int i18 = 0;
                while (it.hasNext()) {
                    if (!q.f(it.next().k())) {
                        i18++;
                    }
                }
                Iterator<FileManagerEntity> it5 = recentFiles.iterator();
                while (it5.hasNext()) {
                    if (it5.next().status == 16) {
                        i18++;
                    }
                }
                if (i18 == localFiles.size() + recentFiles.size()) {
                    QLog.i("FileManagerEngine<FileAssistant>", 1, "=_= ^! Send All Select File is INVALID ");
                    com.tencent.mobileqq.filemanager.util.d.e(R.string.bet);
                    return;
                }
            }
            w0(str, str2, str3, i3);
            A0(str, str2, str3, i3);
            B0(z16, str, str2, str3, i3);
            z0(z16, str, str2, str3, i3);
            x0(str, str2, str3, i3);
            if (i3 != 1) {
                str4 = "FileManagerEngine<FileAssistant>";
            } else {
                try {
                    if (iFMDataCacheApi.getWeiYunFiles().size() > 0) {
                        i17 = 1;
                    } else {
                        i17 = 0;
                    }
                    if (iFMDataCacheApi.getLocalFiles().size() > 0) {
                        i17 += 10;
                    }
                    if (iFMDataCacheApi.getRecentFiles().size() > 0) {
                        i17 += 100;
                    }
                    str4 = "FileManagerEngine<FileAssistant>";
                } catch (Exception e16) {
                    e = e16;
                    str4 = "FileManagerEngine<FileAssistant>";
                    i16 = 1;
                    QLog.i(str4, i16, e.getMessage());
                }
                try {
                    ReportController.o(this.f206900e, "dc00899", "Grp_files", "", "oper", "Clk_send", 0, 0, str2, String.format("%03d", Integer.valueOf(i17)), "", "");
                } catch (Exception e17) {
                    e = e17;
                    i16 = 1;
                    QLog.i(str4, i16, e.getMessage());
                }
            }
            int qlinkIntroShowTime = FileManagerUtil.getQlinkIntroShowTime(this.f206900e.getCurrentAccountUin());
            if (i3 == 0 && qlinkIntroShowTime < 3 && FileManagerUtil.isBuddyIntroShow(this.f206900e.getCurrentAccountUin(), str2)) {
                FileManagerUtil.setBuddyIntroShow(this.f206900e.getCurrentAccountUin(), str2, false);
                this.f206900e.getFileManagerDataCenter().n(str2, this.f206900e.getCurrentAccountUin(), i3, MessageRecord.MSG_TYPE_QLINK_FILE_TIPS, BaseApplication.getContext().getString(R.string.f3w));
                i16 = 1;
                try {
                    FileManagerUtil.saveQlinkIntroShowTime(this.f206900e.getCurrentAccountUin(), qlinkIntroShowTime + 1);
                } catch (Exception e18) {
                    e = e18;
                    QLog.i(str4, i16, e.getMessage());
                }
            }
        } catch (Exception e19) {
            e = e19;
            i16 = 1;
            str4 = "FileManagerEngine<FileAssistant>";
        }
    }

    public void z(int i3, long j3, String str, long j16, int i16) {
        char c16;
        FileManagerEntity D = this.f206900e.getFileManagerDataCenter().D(j3);
        if (i3 == 3) {
            this.f206900e.getNTFileManageBridger().U(D, str, j16, i16);
            return;
        }
        FileManagerEntity g16 = this.f206900e.getFileManagerEngine().g(D, str, 1);
        g16.fProgress = 0.0f;
        try {
            g16.TroopUin = Long.parseLong(str);
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.e("FileManagerEngine<FileAssistant>", 2, FileManagerUtil.printStack());
            }
        }
        g16.status = 2;
        int i17 = D.peerType;
        if (i17 == 0) {
            g16.nOpType = 26;
            QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + g16.nSessionId + "] sendOffline2Troop[" + g16.fileName + "]");
        } else if (i17 == 3000) {
            g16.nOpType = 27;
            QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + g16.nSessionId + "] sendDisce2Troop[" + g16.fileName + "]");
        } else if (i17 == 6000) {
            g16.nOpType = 32;
            QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + g16.nSessionId + "] sendDataline2Troop[" + g16.fileName + "]");
        }
        if (!TextUtils.isEmpty(g16.strTroopFileUuid) && g16.mContext != null) {
            c16 = 2;
        } else {
            w troopProcessCallback = FileManagerUtil.getTroopProcessCallback(this.f206900e);
            String str2 = g16.peerUin;
            int i18 = D.peerType;
            c16 = 2;
            g16.strTroopFileUuid = troopProcessCallback.a(str2, i18, str, i18, g16.Uuid, g16.fileName, g16.fileSize, g16.nSessionId, j16, i16);
            g16.mContext = troopProcessCallback;
        }
        int i19 = g16.busId;
        if (i19 != 102 && i19 != 104) {
            g16.busId = 102;
        }
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            String string = BaseApplication.getContext().getString(R.string.cjm);
            g16.status = 0;
            FileManagerNotifyCenter fileManagerNotifyCenter = this.f206900e.getFileManagerNotifyCenter();
            Object[] objArr = new Object[6];
            objArr[0] = 9004;
            objArr[1] = string;
            objArr[c16] = 0L;
            objArr[3] = 0L;
            objArr[4] = null;
            objArr[5] = Long.valueOf(g16.nSessionId);
            fileManagerNotifyCenter.b(false, 19, objArr);
            Object obj = g16.mContext;
            if (obj instanceof w) {
                ((w) obj).d(false, g16.strTroopFileUuid, j3, 9004, string, str, "");
                return;
            }
            return;
        }
        this.f206900e.getFileTransferHandler().k(102, i3, g16);
    }

    public void z0(boolean z16, String str, String str2, String str3, int i3) {
        IFMDataCacheApi iFMDataCacheApi = (IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class);
        for (FileInfo fileInfo : iFMDataCacheApi.getLocalFiles()) {
            String k3 = fileInfo.k();
            if (z16 && fileInfo.l() <= QZoneHelper.Constants.NO_WIFI_UPLOAD_VIDEO_MAX_SIZE_DEFAULT && iFMDataCacheApi.isDocsFile(fileInfo)) {
                new bj(this.f206900e).n(k3, str, str2, i3);
            } else {
                FileManagerReporter.addData("0X8005414");
                if (i3 == 1) {
                    I0(k3, str2);
                } else {
                    FileManagerEntity F0 = F0(k3, str, str2, str3, i3, true);
                    if (F0 != null) {
                        F0.strApkPackageName = fileInfo.c();
                    }
                }
            }
        }
        if (iFMDataCacheApi.getLocalFiles().size() > 0) {
            ReportController.n(this.f206900e, "dc00898", "", "", "0X800AFB5", "0X800AFB5", 0, iFMDataCacheApi.getLocalFiles().size(), 0, "", "", "", "");
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }

    public void r(long j3, String str) {
    }

    public void s(long j3, String str) {
    }
}
