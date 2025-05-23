package com.tencent.mobileqq.guild.file;

import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.d;
import com.tencent.mobileqq.filemanager.core.g;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDef;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.performance.report.GuildTelemetryTask;
import com.tencent.mobileqq.guild.performance.report.r;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoPlayUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xfc2.oidb_0xfc2$Addr;

/* compiled from: P */
/* loaded from: classes33.dex */
public class v implements com.tencent.mobileqq.filemanager.fileviewer.data.b {

    /* renamed from: e, reason: collision with root package name */
    private static int f224489e;

    /* renamed from: a, reason: collision with root package name */
    protected FileManagerEntity f224490a;

    /* renamed from: b, reason: collision with root package name */
    protected QQAppInterface f224491b;

    /* renamed from: c, reason: collision with root package name */
    private long f224492c = 0;

    /* renamed from: d, reason: collision with root package name */
    private String f224493d;

    public v(QQAppInterface qQAppInterface, FileManagerEntity fileManagerEntity) {
        this.f224491b = qQAppInterface;
        this.f224490a = fileManagerEntity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String k(String str, int i3, List<String> list, boolean z16) {
        if (!com.tencent.mobileqq.filemanager.core.d.c().isConfigEnableIPV6(this.f224491b, 1)) {
            return "";
        }
        int i16 = 0;
        if (z16 && list != null && list.size() > 0) {
            QLog.i("VideoForGuild<QFile>XOXO", 1, "[IPv6-File] offlineVideo download mediaplatform. is config enable IPv6. domain[" + str + "]");
            List<String> iPV6listForMediaPlatfrom = com.tencent.mobileqq.filemanager.core.d.c().getIPV6listForMediaPlatfrom(this.f224491b, 1, list);
            if (iPV6listForMediaPlatfrom != null && iPV6listForMediaPlatfrom.size() > 0) {
                int size = iPV6listForMediaPlatfrom.size();
                while (i16 < size) {
                    String str2 = iPV6listForMediaPlatfrom.get(i16);
                    if (!TextUtils.isEmpty(str2)) {
                        String str3 = "[" + str2 + "]";
                        QLog.i("VideoForGuild<QFile>XOXO", 1, "[IPv6-File] offlineVideo download mediaplatform. use IPv6. hostlist:" + str3);
                        return str3;
                    }
                    i16++;
                }
                return "";
            }
            QLog.i("VideoForGuild<QFile>XOXO", 1, "[IPv6-File] offlineVideo download mediaplatform. use IPv4");
            return "";
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        QLog.i("VideoForGuild<QFile>XOXO", 1, "[IPv6-File] offlineVideo download. is config enable IPv6. domain[" + str + "]");
        d.c iPlistForV6Domain = com.tencent.mobileqq.filemanager.core.d.c().getIPlistForV6Domain(this.f224491b, new d.a(str, i3), 1);
        if (iPlistForV6Domain != null && !iPlistForV6Domain.a()) {
            int size2 = iPlistForV6Domain.f207644b.size();
            while (i16 < size2) {
                d.b bVar = iPlistForV6Domain.f207644b.get(i16);
                if (bVar != null && !TextUtils.isEmpty(bVar.f207641a)) {
                    String str4 = bVar.f207641a;
                    QLog.i("VideoForGuild<QFile>XOXO", 1, "[IPv6-File] offlineVideo download. use IPv6. hostlist:" + str4);
                    return str4;
                }
                i16++;
            }
            return "";
        }
        QLog.i("VideoForGuild<QFile>XOXO", 1, "[IPv6-File] offlineVideo download. use IPv4");
        return "";
    }

    private void l(boolean z16, c cVar) {
        String str;
        String str2;
        FileManagerEntity fileManagerEntity = this.f224490a;
        long j3 = fileManagerEntity != null ? fileManagerEntity.fileSize : 0L;
        r.a aVar = new r.a();
        String str3 = "0";
        aVar.f231044a = "0";
        aVar.f231045b = this.f224493d;
        aVar.f231046c = String.valueOf(j3);
        FileManagerEntity fileManagerEntity2 = this.f224490a;
        String str4 = "";
        if (fileManagerEntity2 == null) {
            str = "";
        } else {
            str = fileManagerEntity2.strFileMd5;
        }
        aVar.f231047d = str;
        aVar.f231048e = "0";
        aVar.f231049f = String.valueOf(this.f224492c);
        long currentTimeMillis = System.currentTimeMillis() - this.f224492c;
        aVar.f231050g = String.valueOf(currentTimeMillis);
        if (!z16) {
            str3 = "1";
        }
        aVar.f231051h = str3;
        aVar.f231052i = "";
        if (currentTimeMillis > 0 && j3 > 0) {
            str2 = (((((float) j3) * 1.0f) / ((float) currentTimeMillis)) * 1000.0f) + "B/s";
        } else {
            str2 = "0B/s";
        }
        aVar.f231053j = str2;
        FileManagerEntity fileManagerEntity3 = this.f224490a;
        if (fileManagerEntity3 != null) {
            str4 = fileManagerEntity3.getFilePath();
        }
        aVar.f231054k = str4;
        com.tencent.mobileqq.guild.performance.report.r.c(GuildTelemetryTask.DOWNLOAD_FILE, aVar);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.data.b
    public String a() {
        return this.f224490a.nSessionId + "";
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.data.b
    public /* synthetic */ void b() {
        com.tencent.mobileqq.filemanager.fileviewer.data.a.a(this);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.data.b
    public String c() {
        return lc1.b.a().getDefaultTmpPath() + com.tencent.securitysdk.utils.c.b(this.f224490a.Uuid);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.data.b
    public void e(long j3) {
        FileManagerEntity fileManagerEntity = this.f224490a;
        fileManagerEntity.status = 2;
        fileManagerEntity.fProgress = ((float) j3) / ((float) fileManagerEntity.fileSize);
        FileManagerNotifyCenter fileManagerNotifyCenter = this.f224491b.getFileManagerNotifyCenter();
        FileManagerEntity fileManagerEntity2 = this.f224490a;
        fileManagerNotifyCenter.c(fileManagerEntity2.uniseq, fileManagerEntity2.nSessionId, fileManagerEntity2.peerUin, fileManagerEntity2.peerType, 16, null, 0, null);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.data.b
    public void f(String str) {
        QLog.i("VideoForGuild<QFile>XOXO", 1, "notifySuccessed fileName = " + this.f224490a.fileName + " fileSize" + this.f224490a.fileSize);
        FileManagerEntity fileManagerEntity = this.f224490a;
        fileManagerEntity.status = 1;
        fileManagerEntity.setFilePath(str);
        this.f224490a.localModifyTime = new File(this.f224490a.getFilePath()).lastModified();
        FileManagerEntity fileManagerEntity2 = this.f224490a;
        fileManagerEntity2.nOLfileSessionId = 0L;
        fileManagerEntity2.fProgress = 1.0f;
        fileManagerEntity2.setCloudType(3);
        FileManagerUtil.fixEntityThumbSize(this.f224490a);
        this.f224491b.getFileManagerDataCenter().f0(this.f224490a);
        FileManagerNotifyCenter fileManagerNotifyCenter = this.f224491b.getFileManagerNotifyCenter();
        FileManagerEntity fileManagerEntity3 = this.f224490a;
        fileManagerNotifyCenter.c(fileManagerEntity3.uniseq, fileManagerEntity3.nSessionId, fileManagerEntity3.peerUin, fileManagerEntity3.peerType, 11, new Object[]{str, Long.valueOf(fileManagerEntity3.fileSize), Boolean.TRUE, this.f224490a.strServerPath}, 0, null);
        com.tencent.mobileqq.filemanager.core.g.i(this);
        l(true, new c().c(this.f224490a.peerUin).b(String.valueOf(this.f224490a.fileSize)).e(this.f224490a.Uuid).d(String.valueOf(this.f224490a.status)).a());
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.data.b
    public void g(g.b bVar) {
        this.f224492c = System.currentTimeMillis();
        if (TextUtils.isEmpty(this.f224490a.Uuid)) {
            d(true);
            bVar.onError(-6101, BaseApplication.getContext().getResources().getString(R.string.bfo));
            QLog.e("VideoForGuild<QFile>XOXO", 2, "[" + this.f224490a.nSessionId + "],[getOnlinePlay]  uuid is null");
            return;
        }
        g gVar = (g) this.f224491b.getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildFileHandlerName());
        o oVar = new o();
        oVar.g(ExcitingTransferDef.Send.FILE_BUSINESS_ID_GUILD);
        oVar.j(this.f224490a.guildId);
        oVar.h(this.f224490a.channelId);
        oVar.i(this.f224490a.Uuid);
        int i3 = f224489e;
        f224489e = i3 + 1;
        oVar.k(i3);
        QLog.i("VideoForGuild<QFile>XOXO", 1, "getUrl fileName = " + this.f224490a.fileName + " fileSize" + this.f224490a.fileSize);
        gVar.q2(oVar, new a(bVar));
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.data.b
    public String getFileName() {
        return this.f224490a.fileName;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.data.b
    public long getFileSize() {
        return this.f224490a.fileSize;
    }

    protected void j(boolean z16, long j3, String str, String str2, ByteStringMicro byteStringMicro, boolean z17, String str3, short s16, String str4, List<String> list, String str5, String str6, String str7, List<String> list2, g.b bVar) {
        String str8;
        QLog.i("VideoForGuild<QFile>XOXO", 1, "doUpdateGetOfflineDownloadInfo isSuccess = " + z16 + " retCode = " + j3 + "fileName = " + this.f224490a.fileName + " fileSize" + this.f224490a.fileSize);
        if (z17) {
            str8 = str4 + "&isthumb=0";
        } else {
            str8 = str4;
        }
        if (TextUtils.isEmpty(this.f224490a.strFileMd5) && !TextUtils.isEmpty(str6)) {
            this.f224490a.strFileMd5 = str6;
        }
        FileManagerEntity fileManagerEntity = this.f224490a;
        fileManagerEntity.bUseMediaPlatform = z17;
        FileManagerUtil.checkFileExisted(fileManagerEntity, this.f224491b, new b(bVar, j3, z16, str3, list2, str7, s16, z17, str2, str8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class b implements ah.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g.b f224496a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f224497b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f224498c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f224499d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f224500e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f224501f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ short f224502g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f224503h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f224504i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f224505j;

        b(g.b bVar, long j3, boolean z16, String str, List list, String str2, short s16, boolean z17, String str3, String str4) {
            this.f224496a = bVar;
            this.f224497b = j3;
            this.f224498c = z16;
            this.f224499d = str;
            this.f224500e = list;
            this.f224501f = str2;
            this.f224502g = s16;
            this.f224503h = z17;
            this.f224504i = str3;
            this.f224505j = str4;
        }

        @Override // com.tencent.mobileqq.filemanager.util.ah.a
        public void a(boolean z16) {
            String str;
            List list;
            if (z16) {
                new HashMap().put(IVideoPlayUtils.KEY_BUS_TYPE, "bus_type_video_file");
                this.f224496a.e();
                return;
            }
            long j3 = this.f224497b;
            if (j3 != -100001) {
                if (j3 != -25081 && j3 != -6101 && j3 != -7003) {
                    if (!this.f224498c) {
                        this.f224496a.onError((int) 9045, BaseApplication.getContext().getResources().getString(R.string.a5j));
                        return;
                    }
                } else {
                    v.this.d(true);
                    this.f224496a.onError((int) this.f224497b, BaseApplication.getContext().getResources().getString(R.string.bfo));
                    return;
                }
            }
            String str2 = this.f224499d;
            if (str2 != null && str2.length() != 0) {
                String str3 = this.f224499d;
                List list2 = this.f224500e;
                if (list2 != null && list2.size() > 0) {
                    str = this.f224501f;
                    list = this.f224500e;
                } else {
                    str = "";
                    list = null;
                }
                String k3 = v.this.k(str, this.f224502g, list, this.f224503h);
                if (!TextUtils.isEmpty(k3)) {
                    str3 = k3;
                }
                String str4 = this.f224504i;
                String str5 = "http://" + str3 + ":" + String.valueOf((int) this.f224502g) + this.f224505j;
                v.this.f224493d = str5;
                QLog.i("VideoForGuild<QFile>XOXO", 1, "doUpdateGetOfflineDownloadInfo callback.onGetUrlCookiesfileName = " + v.this.f224490a.fileName + " fileSize" + v.this.f224490a.fileSize);
                this.f224496a.b(str5, str4);
                return;
            }
            this.f224496a.onError((int) (this.f224497b == 0 ? 9048L : 9360L), BaseApplication.getContext().getResources().getString(R.string.a5j));
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g.b f224494a;

        a(g.b bVar) {
            this.f224494a = bVar;
        }

        @Override // com.tencent.mobileqq.guild.file.f
        public void a(boolean z16, p pVar) {
            String str;
            ArrayList arrayList;
            ArrayList arrayList2;
            long j3;
            long j16 = pVar.f224420c;
            if (pVar.a() != null && pVar.a().size() > 0) {
                oidb_0xfc2$Addr oidb_0xfc2_addr = pVar.a().get(0);
                String str2 = oidb_0xfc2_addr.str_ip.get();
                long j17 = oidb_0xfc2_addr.uint32_http_port.get();
                oidb_0xfc2_addr.uint32_https_port.get();
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
                str = str2;
                arrayList = arrayList3;
                j3 = j17;
                arrayList2 = arrayList4;
            } else {
                str = "";
                arrayList = null;
                arrayList2 = null;
                j3 = 0;
            }
            v vVar = v.this;
            vVar.j(z16, j16, pVar.f224421d, pVar.f224430m, pVar.f224424g, true, str, (short) j3, pVar.f224429l, arrayList, vVar.f224490a.fileName, pVar.f224431n, pVar.f224428k, arrayList2, this.f224494a);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.data.b
    public void d(boolean z16) {
        QLog.i("VideoForGuild<QFile>XOXO", 1, "notifyFileFaild + isInvalid = " + z16 + " fileName = " + this.f224490a.fileName + " fileSize" + this.f224490a.fileSize);
        this.f224490a.status = 0;
        if (z16) {
            QLog.d("VideoForGuild<QFile>XOXO", 1, "notifyFileFaild fileSize = " + this.f224490a.fileSize + " fileType = " + this.f224490a.nFileType + " uuid = " + this.f224490a.Uuid);
            this.f224490a.status = 16;
            this.f224491b.getFileManagerDataCenter().f0(this.f224490a);
        }
        FileManagerNotifyCenter fileManagerNotifyCenter = this.f224491b.getFileManagerNotifyCenter();
        FileManagerEntity fileManagerEntity = this.f224490a;
        fileManagerNotifyCenter.c(fileManagerEntity.uniseq, fileManagerEntity.nSessionId, fileManagerEntity.peerUin, fileManagerEntity.peerType, 12, null, 2, null);
        com.tencent.mobileqq.filemanager.core.g.i(this);
        l(false, new c().c(this.f224490a.peerUin).b(String.valueOf(this.f224490a.fileSize)).e(this.f224490a.Uuid).d(String.valueOf(this.f224490a.status)).a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f224507a;

        /* renamed from: b, reason: collision with root package name */
        public String f224508b;

        /* renamed from: c, reason: collision with root package name */
        public String f224509c;

        /* renamed from: d, reason: collision with root package name */
        public String f224510d;

        c() {
        }

        public c b(String str) {
            this.f224510d = str;
            return this;
        }

        public c c(String str) {
            this.f224507a = str;
            return this;
        }

        public c d(String str) {
            this.f224508b = str;
            return this;
        }

        public c e(String str) {
            this.f224509c = str;
            return this;
        }

        public c a() {
            return this;
        }
    }
}
