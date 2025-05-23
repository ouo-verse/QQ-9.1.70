package com.tencent.mobileqq.guild.file;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.d;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.excitingtransfer.downloader.BaseDownloader;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDef;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadCompletedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadReqInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadSpeedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferOneSlotComplete;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xfc2.oidb_0xfc2$Addr;

/* compiled from: P */
/* loaded from: classes33.dex */
public class c extends BaseDownloader {
    private static int I;
    private FileManagerEntity C;
    private QQAppInterface D;
    b E;
    private int F;
    long G;
    boolean H;

    public c(QQAppInterface qQAppInterface, FileManagerEntity fileManagerEntity) {
        super(qQAppInterface);
        this.C = null;
        this.D = null;
        this.F = 0;
        this.G = 0L;
        this.H = false;
        QLog.i("GuildFileDownloader<FileAssistant>", 1, "file download for GuildFileDownloaderfileName = " + fileManagerEntity.fileName + " fileSize = " + fileManagerEntity.fileSize);
        this.C = fileManagerEntity;
        this.D = qQAppInterface;
        this.E.f224386b.f445362d = FileManagerUtil.getFileSuffix(fileManagerEntity.fileName);
        b bVar = this.E;
        wb1.b bVar2 = bVar.f224386b;
        FileManagerEntity fileManagerEntity2 = this.C;
        bVar2.f445365g = fileManagerEntity2.fileSize;
        bVar2.f445364f = fileManagerEntity2.peerType;
        bVar.f224398n = fileManagerEntity.strFileMd5;
        try {
            bVar2.f445363e = Long.parseLong(fileManagerEntity2.peerUin);
        } catch (Exception e16) {
            QLog.e("GuildFileDownloader<FileAssistant>", 1, e16.toString());
        }
    }

    @Override // vb1.b
    public FileManagerEntity W() {
        return this.C;
    }

    @Override // vb1.b
    public void c(Object obj, int i3) {
        FileManagerEntity fileManagerEntity = this.C;
        if (fileManagerEntity.status != 16) {
            fileManagerEntity.status = 0;
        }
        FileManagerNotifyCenter fileManagerNotifyCenter = this.D.getFileManagerNotifyCenter();
        FileManagerEntity fileManagerEntity2 = this.C;
        fileManagerNotifyCenter.c(fileManagerEntity2.uniseq, fileManagerEntity2.nSessionId, fileManagerEntity2.peerUin, fileManagerEntity2.peerType, 12, null, 6, null);
        this.D.getFileManagerDataCenter().f0(this.C);
    }

    @Override // vb1.b
    public String getFileId() {
        return this.C.WeiYunFileId;
    }

    @Override // vb1.b
    public long getFileSize() {
        return this.C.fileSize;
    }

    @Override // vb1.b
    public int getProgress() {
        return (int) (this.C.fProgress * 100.0f);
    }

    @Override // vb1.b
    public int getStatus() {
        return this.C.status;
    }

    @Override // com.tencent.mobileqq.filemanager.excitingtransfer.downloader.BaseDownloader
    protected wb1.a h(QQAppInterface qQAppInterface) {
        b bVar = new b(qQAppInterface);
        this.E = bVar;
        return bVar;
    }

    @Override // com.tencent.mobileqq.filemanager.excitingtransfer.downloader.BaseDownloader
    protected void j(ExcitingTransferDownloadReqInfo excitingTransferDownloadReqInfo) {
        this.G = System.currentTimeMillis();
        this.E.o();
        this.H = false;
        g gVar = (g) this.D.getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildFileHandlerName());
        o oVar = new o();
        oVar.g(ExcitingTransferDef.Send.FILE_BUSINESS_ID_GUILD);
        oVar.j(this.C.guildId);
        oVar.h(this.C.channelId);
        oVar.i(this.C.Uuid);
        int i3 = I;
        I = i3 + 1;
        oVar.k(i3);
        QLog.d("GuildFileDownloader<FileAssistant>", 1, "getRecvInfo begin request download infofileName = " + this.C.fileName + " fileSize = " + this.C.fileSize);
        gVar.q2(oVar, new a(excitingTransferDownloadReqInfo));
    }

    public String m() {
        return this.f207971i.getDefaultTmpPath() + MD5.toMD5(this.C.Uuid);
    }

    protected void n(boolean z16, long j3, String str, String str2, ByteStringMicro byteStringMicro, boolean z17, String str3, short s16, String str4, List<String> list, String str5, String str6, short s17, String str7, List<String> list2, ExcitingTransferDownloadReqInfo excitingTransferDownloadReqInfo) {
        short s18;
        short s19;
        List<String> list3;
        String str8;
        List<String> list4;
        if (a()) {
            QLog.e("GuildFileDownloader<FileAssistant>", 1, "=_= vk [CS Replay]id[" + String.valueOf(this.C.nSessionId) + "] but isStoped");
            return;
        }
        this.E.n();
        if (!z16) {
            this.E.r(j3);
            c(null, 0);
            return;
        }
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            this.f207967d.e();
            c(null, 0);
            return;
        }
        excitingTransferDownloadReqInfo.fileSize = this.C.fileSize;
        excitingTransferDownloadReqInfo.isSupportHttps = false;
        if (!((IFMConfig) QRoute.api(IFMConfig.class)).isEnableHttpsDownload4C2C(this.D) || TextUtils.isEmpty(str6) || TextUtils.isEmpty(str6)) {
            s18 = s16;
        } else {
            short s26 = s17 == 0 ? (short) 443 : s17;
            excitingTransferDownloadReqInfo.isSupportHttps = true;
            excitingTransferDownloadReqInfo.sslCName = str6;
            s18 = s26;
        }
        boolean z18 = excitingTransferDownloadReqInfo.isSupportHttps;
        this.H = z18;
        this.E.w(z18);
        if (o(j3, byteStringMicro, str3)) {
            return;
        }
        if (j3 == 0 || str == null || str.length() <= 0) {
            s19 = s18;
            list3 = null;
        } else {
            QLog.e("GuildFileDownloader<FileAssistant>", 1, "=_= ^> [CS Replay]id[" + String.valueOf(this.C.nSessionId) + "] will show taost, retCode[" + String.valueOf(j3) + "], retMsg:" + str);
            FileManagerNotifyCenter fileManagerNotifyCenter = this.D.getFileManagerNotifyCenter();
            FileManagerEntity fileManagerEntity = this.C;
            s19 = s18;
            list3 = null;
            fileManagerNotifyCenter.c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 4, null, (int) j3, str);
        }
        List<String> arrayList = list == null ? new ArrayList() : list;
        IQFileConfigManager iQFileConfigManager = (IQFileConfigManager) this.D.getRuntimeService(IQFileConfigManager.class, "");
        if (iQFileConfigManager.isHarcodeIP()) {
            arrayList.clear();
            arrayList.add(iQFileConfigManager.getHarcodeIP());
        }
        if (list2 == null || list2.size() <= 0) {
            str8 = "";
            list4 = list3;
        } else {
            str8 = str7;
            list4 = list2;
        }
        short s27 = s19;
        p(arrayList, str8, s27, list4, z17);
        QLog.i("GuildFileDownloader<FileAssistant>", 1, "get lstUrl size:" + arrayList.size());
        ArrayList arrayList2 = new ArrayList();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new ExcitingTransferHostInfo(it.next(), s27));
        }
        excitingTransferDownloadReqInfo.mHosts = (ExcitingTransferHostInfo[]) arrayList2.toArray(new ExcitingTransferHostInfo[arrayList2.size()]);
        excitingTransferDownloadReqInfo.strCookie = "Cookie:t=0;v=" + AppSetting.f() + ";" + str2 + ";\r\n";
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str4);
        sb5.append("&isthumb=0");
        excitingTransferDownloadReqInfo.serverPath = sb5.toString();
        excitingTransferDownloadReqInfo.strTempFilePath = m();
        excitingTransferDownloadReqInfo.strFileName = str5;
        excitingTransferDownloadReqInfo.strSaveFileDir = this.f207971i.getDefaultRecvPath();
        FileManagerEntity fileManagerEntity2 = this.C;
        fileManagerEntity2.bUseMediaPlatform = z17;
        fileManagerEntity2.status = 2;
        this.E.q();
        QLog.d("GuildFileDownloader<FileAssistant>", 1, "handleFileDownloadInfoRecv begin downloadfileName = " + this.C.fileName + " fileSize = " + this.C.fileSize);
        i();
    }

    protected boolean o(long j3, ByteStringMicro byteStringMicro, String str) {
        if (!TextUtils.isEmpty(str) && byteStringMicro != null) {
            return false;
        }
        if (j3 == -6101 || j3 == -7003) {
            QLog.d("GuildFileDownloader<FileAssistant>", 1, "handleFileDownloadReqErrorState " + j3 + " fileSize = " + this.C.fileSize + " fileType = " + this.C.nFileType + " uuid = " + this.C.Uuid);
            this.C.status = 16;
        }
        if (j3 == 0) {
            b bVar = this.E;
            wb1.b bVar2 = bVar.f224386b;
            bVar2.f445360b = 9048L;
            bVar2.f445359a = 2L;
            bVar.x(5);
            this.E.d(false);
        } else {
            this.E.s(j3);
        }
        c(null, (int) j3);
        return true;
    }

    @Override // com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.IExcitingTransferRecvListener
    public void onOneSlotComplete(int i3, ExcitingTransferOneSlotComplete excitingTransferOneSlotComplete) {
        if (excitingTransferOneSlotComplete == null) {
            QLog.i("GuildFileDownloader<FileAssistant>", 1, "OnOneSlotComplete:" + i3 + " slotInfo is null fileName = " + this.C.fileName + " fileSize = " + this.C.fileSize);
            return;
        }
        QLog.i("GuildFileDownloader<FileAssistant>", 1, "OnOneSlotComplete:" + i3 + " slotInfo : " + excitingTransferOneSlotComplete.toString() + " fileName = " + this.C.fileName + " fileSize = " + this.C.fileSize);
        int l3 = l(i3);
        int i16 = 3;
        if (l3 == 9004) {
            i16 = 5;
            l3 = 3;
        } else if (l3 != 506) {
            i16 = 4;
        }
        this.E.t(i16, l3, excitingTransferOneSlotComplete);
        q(i3, excitingTransferOneSlotComplete);
    }

    @Override // com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.IExcitingTransferRecvListener
    public void onRecvComplete(int i3, ExcitingTransferDownloadCompletedInfo excitingTransferDownloadCompletedInfo) {
        QLog.i("GuildFileDownloader<FileAssistant>", 1, "file download result:" + i3 + " fileName = " + this.C.fileName + " fileSize = " + this.C.fileSize);
        if (excitingTransferDownloadCompletedInfo != null) {
            this.E.v(0);
        }
        if (i3 != 0) {
            i3 = l(i3);
            b bVar = this.E;
            wb1.b bVar2 = bVar.f224386b;
            bVar2.f445360b = i3;
            bVar2.f445359a = 4L;
            if (i3 == 9004) {
                bVar2.f445359a = 5L;
                bVar.x(3);
            } else if (i3 == 506) {
                bVar2.f445359a = 3L;
                bVar.x(i3);
            } else {
                bVar.x(i3);
            }
            c(null, i3);
        } else {
            if (!com.tencent.mobileqq.filemanager.fileassistant.util.h.k(this.C.peerUin)) {
                FileTransferHandler fileTransferHandler = this.D.getFileTransferHandler();
                String currentUin = this.D.getCurrentUin();
                FileManagerEntity fileManagerEntity = this.C;
                fileTransferHandler.u1(currentUin, fileManagerEntity.Uuid, fileManagerEntity.bUseMediaPlatform, fileManagerEntity.fileIdCrc, null);
            }
            b bVar3 = this.E;
            wb1.b bVar4 = bVar3.f224386b;
            bVar4.f445360b = i3;
            bVar4.f445359a = 0L;
            bVar3.x(0);
            r(excitingTransferDownloadCompletedInfo);
            if (this.C.nFileType == 5) {
                this.D.getFileManagerEngine().Q().l(this.C);
            }
        }
        this.D.getFileManagerDataCenter().f0(this.C);
        if (excitingTransferDownloadCompletedInfo != null) {
            this.E.u(excitingTransferDownloadCompletedInfo);
            this.E.d(i3 == 0);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.IExcitingTransferRecvListener
    public void onSpeed(ExcitingTransferDownloadSpeedInfo excitingTransferDownloadSpeedInfo) {
        this.C.mExcitingSpeed = QFileUtils.V(excitingTransferDownloadSpeedInfo.mTotalSpeed);
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ExcitingTransferDownloadReqInfo f224399a;

        a(ExcitingTransferDownloadReqInfo excitingTransferDownloadReqInfo) {
            this.f224399a = excitingTransferDownloadReqInfo;
        }

        @Override // com.tencent.mobileqq.guild.file.f
        public void a(boolean z16, p pVar) {
            String str;
            ArrayList arrayList;
            ArrayList arrayList2;
            long j3;
            long j16;
            long j17 = pVar.f224420c;
            if (pVar.a() != null && pVar.a().size() > 0) {
                oidb_0xfc2$Addr oidb_0xfc2_addr = pVar.a().get(0);
                String str2 = oidb_0xfc2_addr.str_ip.get();
                long j18 = oidb_0xfc2_addr.uint32_http_port.get();
                long j19 = oidb_0xfc2_addr.uint32_https_port.get();
                List<oidb_0xfc2$Addr> a16 = pVar.a();
                ArrayList arrayList3 = new ArrayList();
                Iterator<oidb_0xfc2$Addr> it = a16.iterator();
                while (it.hasNext()) {
                    arrayList3.add(it.next().str_ip.get());
                }
                List<oidb_0xfc2$Addr> b16 = pVar.b();
                ArrayList arrayList4 = new ArrayList();
                Iterator<oidb_0xfc2$Addr> it5 = b16.iterator();
                while (it5.hasNext()) {
                    arrayList4.add(it5.next().str_ip.get());
                }
                arrayList = arrayList3;
                j16 = j19;
                arrayList2 = arrayList4;
                str = str2;
                j3 = j18;
            } else {
                str = "";
                arrayList = null;
                arrayList2 = null;
                j3 = 0;
                j16 = 0;
            }
            c cVar = c.this;
            b bVar = cVar.E;
            if (bVar != null) {
                bVar.f224397m = pVar.f224429l;
            }
            String str3 = pVar.f224421d;
            String str4 = pVar.f224430m;
            ByteStringMicro byteStringMicro = pVar.f224424g;
            short s16 = (short) j3;
            String str5 = pVar.f224429l;
            String str6 = cVar.C.fileName;
            String str7 = pVar.f224428k;
            cVar.n(z16, j17, str3, str4, byteStringMicro, false, str, s16, str5, arrayList, str6, str7, (short) j16, str7, arrayList2, this.f224399a);
        }
    }

    private void p(List<String> list, String str, int i3, List<String> list2, boolean z16) {
        if (list != null && com.tencent.mobileqq.filemanager.core.d.c().isConfigEnableIPV6(this.D, 1)) {
            if (z16 && list2 != null && list2.size() > 0) {
                QLog.i("GuildFileDownloader<FileAssistant>", 1, "[IPv6-File] offline mediaplatform exciting download. is config enable IPv6. v6ipsize[" + list2.size() + "]");
                List<String> iPV6listForMediaPlatfrom = com.tencent.mobileqq.filemanager.core.d.c().getIPV6listForMediaPlatfrom(this.D, 1, list2);
                if (iPV6listForMediaPlatfrom != null && iPV6listForMediaPlatfrom.size() > 0) {
                    if (com.tencent.mobileqq.filemanager.core.d.b()) {
                        QLog.d("GuildFileDownloader<FileAssistant>", 1, "[IPv6-File] offline mediaplatform exciting download. debugIsDisableIPv4OnDoubleStack");
                        list.clear();
                    }
                    list.addAll(0, iPV6listForMediaPlatfrom);
                    this.F = 2;
                    QLog.i("GuildFileDownloader<FileAssistant>", 1, "[IPv6-File] offline mediaplatform exciting download use IPv6. iplist:" + list.toString());
                } else {
                    this.F = 1;
                    QLog.i("GuildFileDownloader<FileAssistant>", 1, "[IPv6-File] offline mediaplatform exciting download use IPv4");
                }
            } else if (!TextUtils.isEmpty(str)) {
                QLog.i("GuildFileDownloader<FileAssistant>", 1, "[IPv6-File] offline exciting download. is config enable IPv6. domain[" + str + "]");
                d.c iPlistForV6Domain = com.tencent.mobileqq.filemanager.core.d.c().getIPlistForV6Domain(this.D, new d.a(str, i3), 1);
                if (iPlistForV6Domain != null && !iPlistForV6Domain.a()) {
                    if (com.tencent.mobileqq.filemanager.core.d.b()) {
                        QLog.d("GuildFileDownloader<FileAssistant>", 1, "[IPv6-File] offline exciting download. debugIsDisableIPv4OnDoubleStack");
                        list.clear();
                    }
                    com.tencent.mobileqq.filemanager.core.d.a(iPlistForV6Domain.f207644b, list, true, true);
                    this.F = 2;
                    if (iPlistForV6Domain.f207643a == 1) {
                        this.F = 3;
                    }
                    QLog.i("GuildFileDownloader<FileAssistant>", 1, "[IPv6-File] offline exciting download use IPv6. iplist:" + list.toString());
                } else {
                    this.F = 1;
                    QLog.i("GuildFileDownloader<FileAssistant>", 1, "[IPv6-File] offline exciting download use IPv4");
                }
            } else {
                this.F = 1;
            }
            this.E.y(this.F);
            return;
        }
        this.F = 1;
        this.E.y(1);
    }

    @Override // com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.IExcitingTransferRecvListener
    public void onRecvProgress(long j3, long j16, long j17) {
        this.E.p(j16);
        FileManagerEntity fileManagerEntity = this.C;
        fileManagerEntity.status = 2;
        fileManagerEntity.fProgress = ((float) j16) / ((float) fileManagerEntity.fileSize);
        FileManagerNotifyCenter fileManagerNotifyCenter = this.D.getFileManagerNotifyCenter();
        FileManagerEntity fileManagerEntity2 = this.C;
        fileManagerNotifyCenter.c(fileManagerEntity2.uniseq, fileManagerEntity2.nSessionId, fileManagerEntity2.peerUin, fileManagerEntity2.peerType, 16, null, 0, null);
    }

    protected void r(ExcitingTransferDownloadCompletedInfo excitingTransferDownloadCompletedInfo) {
        if (excitingTransferDownloadCompletedInfo == null) {
            return;
        }
        String str = excitingTransferDownloadCompletedInfo.mstrFileSavePath;
        FileManagerUtil.getFileSizes(str);
        this.C.fileName = FileManagerUtil.getFileName(str);
        int length = 250 - (str.length() - this.C.fileName.length());
        if (this.C.fileName.getBytes().length > length) {
            FileManagerEntity fileManagerEntity = this.C;
            fileManagerEntity.fileName = FileManagerUtil.cutLongLongFileName(fileManagerEntity.fileName, length);
        }
        this.C.setFilePath(str);
        this.C.fileName = FileManagerUtil.getFileName(str);
        FileManagerEntity fileManagerEntity2 = this.C;
        fileManagerEntity2.nFileType = FileManagerUtil.getFileType(fileManagerEntity2.fileName);
        FileManagerEntity fileManagerEntity3 = this.C;
        if (fileManagerEntity3.nFileType == 0) {
            fileManagerEntity3.strFileSha3 = vb1.a.b(FileManagerUtil.getSha3(str));
            FileManagerEntity fileManagerEntity4 = this.C;
            if (fileManagerEntity4.fileSize < GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT) {
                fileManagerEntity4.strFileSHA = vb1.a.b(FileManagerUtil.getSHA(str));
            }
        }
        this.C.localModifyTime = new VFSFile(str).lastModified();
        this.C.lastSuccessTime = com.tencent.mobileqq.service.message.e.K0();
        FileManagerEntity fileManagerEntity5 = this.C;
        fileManagerEntity5.status = 1;
        fileManagerEntity5.setCloudType(3);
        FileManagerEntity fileManagerEntity6 = this.C;
        int i3 = fileManagerEntity6.nFileType;
        if (i3 == 0) {
            FilePicURLDrawlableHelper.e(fileManagerEntity6);
            FilePicURLDrawlableHelper.k(this.C);
            FilePicURLDrawlableHelper.d(this.C);
        } else if (i3 == 2) {
            FileManagerUtil.createMediThumbnail(fileManagerEntity6);
        }
        FileManagerUtil.fixEntityThumbSize(this.C);
        this.D.getFileManagerDataCenter().f0(this.C);
        FileManagerNotifyCenter fileManagerNotifyCenter = this.D.getFileManagerNotifyCenter();
        FileManagerEntity fileManagerEntity7 = this.C;
        fileManagerNotifyCenter.c(fileManagerEntity7.uniseq, fileManagerEntity7.nSessionId, fileManagerEntity7.peerUin, fileManagerEntity7.peerType, 11, new Object[]{str, "", Long.valueOf(fileManagerEntity7.fileSize), Boolean.TRUE, "", ""}, 0, null);
    }

    private void q(int i3, ExcitingTransferOneSlotComplete excitingTransferOneSlotComplete) {
        String str;
        if (excitingTransferOneSlotComplete == null) {
            return;
        }
        wb1.b bVar = this.E.f224386b;
        if (bVar != null) {
            str = String.valueOf(bVar.f445363e);
        } else {
            str = "";
        }
        String str2 = str;
        Bundle bundle = new Bundle();
        bundle.putInt("param_fromType", 1);
        bundle.putInt("param_V6SelectType", this.F);
        bundle.putInt("param_ipAddrType", QFileUtils.P(excitingTransferOneSlotComplete.mstrIp));
        bundle.putInt("param_ishttps", this.H ? 1 : 0);
        if (i3 != 0) {
            QQAppInterface qQAppInterface = this.D;
            FileManagerEntity fileManagerEntity = this.C;
            long j3 = fileManagerEntity.nSessionId;
            long j16 = this.G;
            String str3 = excitingTransferOneSlotComplete.mstrIp;
            long j17 = excitingTransferOneSlotComplete.mDownloadedSize;
            FileManagerUtil.reportFilemanagerFaildInfoEx(qQAppInterface, j3, "actFileDownDetail", j16, str3, str2, fileManagerEntity.Uuid, fileManagerEntity.strFileMd5, i3, "", j17, j17, fileManagerEntity.fileSize, str3, "", 0, "", null, bundle);
            return;
        }
        QQAppInterface qQAppInterface2 = this.D;
        FileManagerEntity fileManagerEntity2 = this.C;
        long j18 = fileManagerEntity2.nSessionId;
        long j19 = excitingTransferOneSlotComplete.mTotalTimes;
        String str4 = excitingTransferOneSlotComplete.mstrIp;
        String str5 = fileManagerEntity2.Uuid;
        String str6 = fileManagerEntity2.strFileMd5;
        long j26 = excitingTransferOneSlotComplete.mDownloadedSize;
        FileManagerUtil.reportFilemanagerSuccessInfoEx(qQAppInterface2, j18, "actFileDownDetail", j19, str4, str2, str5, str6, j26, j26, fileManagerEntity2.fileSize, 0, null, bundle);
    }

    private int l(int i3) {
        long c16;
        if (i3 == 300 || i3 == 301 || i3 == 302 || i3 == 303 || i3 == 400 || i3 == 402 || i3 == 403) {
            if (!AppNetConnInfo.isNetSupport() || !this.D.isLogin()) {
                return 9004;
            }
        } else if (i3 == 501 || i3 == 502 || i3 == 503 || i3 == 505) {
            if (cu.e()) {
                c16 = cu.b();
            } else {
                c16 = cu.c();
            }
            if (this.C.fileSize > c16 * 1024) {
                return 506;
            }
        }
        return i3;
    }

    @Override // com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.IExcitingTransferRecvListener
    public void onRecvStart() {
    }
}
