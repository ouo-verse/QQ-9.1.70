package com.tencent.mobileqq.filemanager.fileviewer.data;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.d;
import com.tencent.mobileqq.filemanager.core.g;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoPlayUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.af;
import com.tencent.qqnt.kernel.nativeinterface.CleanFileDetail;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class VideoForC2C implements b {

    /* renamed from: a, reason: collision with root package name */
    protected FileManagerEntity f208221a;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends com.tencent.mobileqq.filemanager.app.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f208222a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ g.b f208223b;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.filemanager.fileviewer.data.VideoForC2C$a$a, reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        class C7563a implements ah.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ long f208225a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ boolean f208226b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f208227c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Bundle f208228d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ short f208229e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ boolean f208230f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ String f208231g;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ String f208232h;

            C7563a(long j3, boolean z16, String str, Bundle bundle, short s16, boolean z17, String str2, String str3) {
                this.f208225a = j3;
                this.f208226b = z16;
                this.f208227c = str;
                this.f208228d = bundle;
                this.f208229e = s16;
                this.f208230f = z17;
                this.f208231g = str2;
                this.f208232h = str3;
            }

            @Override // com.tencent.mobileqq.filemanager.util.ah.a
            public void a(boolean z16) {
                long j3;
                ArrayList<String> arrayList;
                if (z16) {
                    new HashMap().put(IVideoPlayUtils.KEY_BUS_TYPE, "bus_type_video_file");
                    a.this.f208223b.e();
                    return;
                }
                long j16 = this.f208225a;
                if (j16 != -100001) {
                    if (j16 != -25081 && j16 != -6101 && j16 != -7003) {
                        if (!this.f208226b) {
                            a.this.f208223b.onError((int) 9045, BaseApplication.getContext().getResources().getString(R.string.a5j));
                            return;
                        }
                    } else {
                        VideoForC2C.this.d(true);
                        a.this.f208223b.onError((int) this.f208225a, BaseApplication.getContext().getResources().getString(R.string.bfo));
                        return;
                    }
                }
                String str = this.f208227c;
                if (str != null && str.length() != 0) {
                    String str2 = this.f208227c;
                    Bundle bundle = this.f208228d;
                    String str3 = "";
                    if (bundle != null) {
                        str3 = bundle.getString("IPv6Dns", "");
                        arrayList = this.f208228d.getStringArrayList("ipv6list");
                    } else {
                        arrayList = null;
                    }
                    String j17 = VideoForC2C.this.j(str3, this.f208229e, arrayList, this.f208230f);
                    if (!TextUtils.isEmpty(j17)) {
                        str2 = j17;
                    }
                    a.this.f208223b.b("http://" + str2 + ":" + String.valueOf((int) this.f208229e) + this.f208232h, this.f208231g);
                    return;
                }
                if (this.f208225a == 0) {
                    j3 = 9048;
                } else {
                    j3 = 9360;
                }
                a.this.f208223b.onError((int) j3, BaseApplication.getContext().getResources().getString(R.string.a5j));
            }
        }

        a(QQAppInterface qQAppInterface, g.b bVar) {
            this.f208222a = qQAppInterface;
            this.f208223b = bVar;
        }

        @Override // com.tencent.mobileqq.filemanager.app.d
        protected void j(boolean z16, long j3, String str, String str2, ByteStringMicro byteStringMicro, boolean z17, String str3, short s16, String str4, List<String> list, int i3, String str5, String str6, String str7, long j16, Bundle bundle) {
            String str8;
            if (z17) {
                str8 = str4 + "&isthumb=0";
            } else {
                str8 = str4;
            }
            QLog.i("VideoForC2C<QFile>XOXO", 2, "[" + VideoForC2C.this.f208221a.nSessionId + "],[getOnlinePlay]  ID[" + j16 + "]onUpdateGetOfflineDownloadInfo");
            if (TextUtils.isEmpty(VideoForC2C.this.f208221a.strFileMd5) && !TextUtils.isEmpty(str6)) {
                VideoForC2C.this.f208221a.strFileMd5 = str6;
            }
            FileManagerEntity fileManagerEntity = VideoForC2C.this.f208221a;
            fileManagerEntity.bUseMediaPlatform = z17;
            FileManagerUtil.checkFileExisted(fileManagerEntity, this.f208222a, new C7563a(j3, z16, str3, bundle, s16, z17, str2, str8));
        }
    }

    public VideoForC2C(QQAppInterface qQAppInterface, FileManagerEntity fileManagerEntity) {
        this.f208221a = fileManagerEntity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String j(String str, int i3, List<String> list, boolean z16) {
        QQAppInterface i16 = i();
        if (i16 == null) {
            QLog.d("VideoForC2C<QFile>XOXO", 1, "reGetHostForIPv6 appInterface is null return");
            return "";
        }
        if (!com.tencent.mobileqq.filemanager.core.d.c().isConfigEnableIPV6(i16, 1)) {
            return "";
        }
        int i17 = 0;
        if (z16 && list != null && list.size() > 0) {
            QLog.i("VideoForC2C<QFile>XOXO", 1, "[IPv6-File] offlineVideo download mediaplatform. is config enable IPv6. domain[" + str + "]");
            List<String> iPV6listForMediaPlatfrom = com.tencent.mobileqq.filemanager.core.d.c().getIPV6listForMediaPlatfrom(i16, 1, list);
            if (iPV6listForMediaPlatfrom != null && iPV6listForMediaPlatfrom.size() > 0) {
                int size = iPV6listForMediaPlatfrom.size();
                while (i17 < size) {
                    String str2 = iPV6listForMediaPlatfrom.get(i17);
                    if (!TextUtils.isEmpty(str2)) {
                        String str3 = "[" + str2 + "]";
                        QLog.i("VideoForC2C<QFile>XOXO", 1, "[IPv6-File] offlineVideo download mediaplatform. use IPv6. hostlist:" + str3);
                        return str3;
                    }
                    i17++;
                }
                return "";
            }
            QLog.i("VideoForC2C<QFile>XOXO", 1, "[IPv6-File] offlineVideo download mediaplatform. use IPv4");
            return "";
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        QLog.i("VideoForC2C<QFile>XOXO", 1, "[IPv6-File] offlineVideo download. is config enable IPv6. domain[" + str + "]");
        d.c iPlistForV6Domain = com.tencent.mobileqq.filemanager.core.d.c().getIPlistForV6Domain(i16, new d.a(str, i3), 1);
        if (iPlistForV6Domain != null && !iPlistForV6Domain.a()) {
            int size2 = iPlistForV6Domain.f207644b.size();
            while (i17 < size2) {
                d.b bVar = iPlistForV6Domain.f207644b.get(i17);
                if (bVar != null && !TextUtils.isEmpty(bVar.f207641a)) {
                    String str4 = bVar.f207641a;
                    QLog.i("VideoForC2C<QFile>XOXO", 1, "[IPv6-File] offlineVideo download. use IPv6. hostlist:" + str4);
                    return str4;
                }
                i17++;
            }
            return "";
        }
        QLog.i("VideoForC2C<QFile>XOXO", 1, "[IPv6-File] offlineVideo download. use IPv4");
        return "";
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.data.b
    public String a() {
        return this.f208221a.nSessionId + "";
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.data.b
    public void b() {
        QLog.d("VideoForC2C<QFile>XOXO", 1, "notifyRelease start");
        this.f208221a.status = 3;
        QQAppInterface i3 = i();
        if (i3 == null) {
            QLog.d("VideoForC2C<QFile>XOXO", 1, "notifyRelease appInterface is null return");
            return;
        }
        i3.getFileManagerDataCenter().f0(this.f208221a);
        FileManagerNotifyCenter fileManagerNotifyCenter = i3.getFileManagerNotifyCenter();
        FileManagerEntity fileManagerEntity = this.f208221a;
        fileManagerNotifyCenter.c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 23, null, 17, null);
        i3.getNTFileManageBridger().M0(this.f208221a, 6);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.data.b
    public String c() {
        return lc1.b.a().getDefaultTmpPath() + com.tencent.securitysdk.utils.c.b(this.f208221a.Uuid);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.data.b
    public void d(boolean z16) {
        this.f208221a.status = 0;
        QQAppInterface i3 = i();
        if (i3 == null) {
            QLog.d("VideoForC2C<QFile>XOXO", 1, "notifyFileFaild appInterface is null return");
            return;
        }
        if (z16) {
            this.f208221a.status = 16;
            i3.getFileManagerDataCenter().f0(this.f208221a);
        }
        FileManagerNotifyCenter fileManagerNotifyCenter = i3.getFileManagerNotifyCenter();
        FileManagerEntity fileManagerEntity = this.f208221a;
        fileManagerNotifyCenter.c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 12, null, 2, null);
        com.tencent.mobileqq.filemanager.core.g.i(this);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.data.b
    public void e(long j3) {
        FileManagerEntity fileManagerEntity = this.f208221a;
        fileManagerEntity.status = 2;
        fileManagerEntity.fProgress = ((float) j3) / ((float) fileManagerEntity.fileSize);
        QQAppInterface i3 = i();
        if (i3 == null) {
            QLog.d("VideoForC2C<QFile>XOXO", 1, "notifyProgress appInterface is null return");
            return;
        }
        FileManagerNotifyCenter fileManagerNotifyCenter = i3.getFileManagerNotifyCenter();
        FileManagerEntity fileManagerEntity2 = this.f208221a;
        fileManagerNotifyCenter.c(fileManagerEntity2.uniseq, fileManagerEntity2.nSessionId, fileManagerEntity2.peerUin, fileManagerEntity2.peerType, 16, null, 0, null);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.data.b
    public void f(String str) {
        FileManagerEntity fileManagerEntity = this.f208221a;
        fileManagerEntity.status = 1;
        fileManagerEntity.setFilePath(str);
        this.f208221a.localModifyTime = new File(this.f208221a.getFilePath()).lastModified();
        FileManagerEntity fileManagerEntity2 = this.f208221a;
        fileManagerEntity2.nOLfileSessionId = 0L;
        fileManagerEntity2.fProgress = 1.0f;
        fileManagerEntity2.setCloudType(3);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.data.VideoForC2C.1
            @Override // java.lang.Runnable
            public void run() {
                FileManagerUtil.fixEntityThumbSize(VideoForC2C.this.f208221a);
            }
        }, 64, null, false);
        QQAppInterface i3 = i();
        if (i3 == null) {
            QLog.d("VideoForC2C<QFile>XOXO", 1, "notifySuccessed appInterface is null return");
            return;
        }
        i3.getFileManagerDataCenter().f0(this.f208221a);
        FileManagerNotifyCenter fileManagerNotifyCenter = i3.getFileManagerNotifyCenter();
        FileManagerEntity fileManagerEntity3 = this.f208221a;
        fileManagerNotifyCenter.c(fileManagerEntity3.uniseq, fileManagerEntity3.nSessionId, fileManagerEntity3.peerUin, fileManagerEntity3.peerType, 11, new Object[]{str, Long.valueOf(fileManagerEntity3.fileSize), Boolean.TRUE, this.f208221a.strServerPath}, 0, null);
        com.tencent.mobileqq.filemanager.core.g.i(this);
        i3.getNTFileManageBridger().M0(this.f208221a, 4);
        af storageCleanService = ((IKernelService) i3.getRuntimeService(IKernelService.class, "")).getStorageCleanService();
        if (storageCleanService == null) {
            return;
        }
        FileManagerEntity fileManagerEntity4 = this.f208221a;
        CleanFileDetail cleanFileDetail = new CleanFileDetail(fileManagerEntity4.ntMsgId, fileManagerEntity4.ntSubMsgID, fileManagerEntity4.peerUid, fileManagerEntity4.ntChatType, 0L, "", 0L, fileManagerEntity4.strFilePath, false);
        QLog.d("VideoForC2C<QFile>XOXO", 1, "notifySuccessed strFilePath: " + this.f208221a.strFilePath + ", detail:" + cleanFileDetail);
        storageCleanService.addNewDownloadOrUploadFile(cleanFileDetail);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.data.b
    public void g(g.b bVar) {
        if (TextUtils.isEmpty(this.f208221a.Uuid)) {
            d(true);
            bVar.onError(-6101, BaseApplication.getContext().getResources().getString(R.string.bfo));
            QLog.e("VideoForC2C<QFile>XOXO", 2, "[" + this.f208221a.nSessionId + "],[getOnlinePlay]  uuid is null");
            return;
        }
        this.f208221a.nOpType = 1;
        QQAppInterface i3 = i();
        if (i3 == null) {
            QLog.d("VideoForC2C<QFile>XOXO", 1, "getUrl appInterface is null return");
            return;
        }
        FileTransferHandler fileTransferHandler = i3.getFileTransferHandler();
        FileManagerEntity fileManagerEntity = this.f208221a;
        fileTransferHandler.H(fileManagerEntity.Uuid, fileManagerEntity.fileIdCrc, fileManagerEntity.bSend, false, new a(i3, bVar));
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.data.b
    public String getFileName() {
        return this.f208221a.fileName;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.data.b
    public long getFileSize() {
        return this.f208221a.fileSize;
    }

    public QQAppInterface i() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return null;
        }
        return (QQAppInterface) peekAppRuntime;
    }
}
