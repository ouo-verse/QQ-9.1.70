package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.ThumbHttpDownloader;
import com.tencent.mobileqq.filemanager.core.a;
import com.tencent.mobileqq.filemanager.core.d;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class o extends com.tencent.mobileqq.filemanager.core.a {

    /* renamed from: c, reason: collision with root package name */
    private FMObserver f207668c;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends FMObserver {
        a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x01ce  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x01d6  */
        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected void b0(boolean z16, int i3, String str, String str2, String str3, String str4, String str5, int i16, String str6, long j3, Bundle bundle) {
            String str7;
            String str8;
            boolean z17;
            String str9;
            QLog.i("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb]  ID[" + j3 + "] OnGetOfflineVideoThumbInfo, bSuccess[" + z16 + " retCode:" + i3 + " downloadIp:" + str4 + " downloadDomain:" + str5 + " port:" + i16 + " url:" + str6);
            short s16 = 0;
            b t16 = o.this.t(j3, false);
            if (t16 == null) {
                QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 2, "[downloadThumb]  ID[" + j3 + "] OnGetOfflineVideoThumbInfo no this session");
                o.this.o(j3, false, null, 0, null, null, str2, false, null, (short) 0, null);
                return;
            }
            if (!z16) {
                o.this.f207631a.getFileManagerNotifyCenter().b(false, 50, new Object[]{t16.f207634b});
                o.this.q(j3);
                o.this.o(j3, false, null, 0, null, null, str2, false, null, (short) 0, null);
                return;
            }
            if (str6 != null && str6.length() > 0) {
                QLog.w("OfflineVideoThumbDownLoader<FileAssistant>", 2, "[downloadThumb]  ID[" + j3 + "] OnGetOfflineVideoThumbInfo url=null");
                o.this.f207631a.getFileManagerNotifyCenter().b(false, 50, new Object[]{t16.f207634b});
                o.this.q(j3);
                o.this.o(j3, false, null, 0, null, null, str2, false, null, (short) 0, null);
                return;
            }
            if (str4 != null && str4.length() > 0) {
                str7 = str4;
            } else if (str5 != null && str5.length() > 0) {
                str7 = str5;
            } else {
                str7 = null;
            }
            if (str7 != null && str7.length() >= 0) {
                if (str3 == null || str3.length() < 0) {
                    QLog.w("OfflineVideoThumbDownLoader<FileAssistant>", 2, "[downloadThumb]  ID[" + j3 + "] OnGetOfflineVideoThumbInfo downloadKey invaild");
                }
                String str10 = "/ftn_video_pic/rkey=" + str3 + "&filetype=" + t16.f207671d + "&size=" + o.this.l(t16.f207670c) + ContainerUtils.FIELD_DELIMITER;
                if (((IFMConfig) QRoute.api(IFMConfig.class)).isEnableHttpsThumb4C2C(o.this.f207631a) && bundle != null) {
                    String string = bundle.getString("strHttpsDomain");
                    if (!TextUtils.isEmpty(string)) {
                        short s17 = bundle.getShort("httpsPort", (short) 0);
                        if (s17 == 0) {
                            s17 = 443;
                        }
                        s16 = s17;
                        str8 = string;
                        z17 = true;
                        if (bundle == null) {
                            str9 = bundle.getString("IPv6Dns");
                        } else {
                            str9 = "";
                        }
                        o.this.o(j3, true, str7, i16, str10, null, str2, z17, str8, s16, str9);
                        return;
                    }
                }
                str8 = null;
                z17 = false;
                if (bundle == null) {
                }
                o.this.o(j3, true, str7, i16, str10, null, str2, z17, str8, s16, str9);
                return;
            }
            o.this.f207631a.getFileManagerNotifyCenter().b(false, 50, new Object[]{t16.f207634b});
            o.this.q(j3);
            o.this.o(j3, false, null, 0, null, null, str2, false, null, (short) 0, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class b extends a.C7549a {

        /* renamed from: c, reason: collision with root package name */
        int f207670c;

        /* renamed from: d, reason: collision with root package name */
        int f207671d;

        public b(FileManagerEntity fileManagerEntity) {
            super(fileManagerEntity);
        }
    }

    public o(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        this.f207668c = new a();
        qQAppInterface.getFileManagerNotifyCenter().addObserver(this.f207668c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b t(long j3, boolean z16) {
        a.C7549a k3 = k(j3);
        if (k3 == null) {
            return null;
        }
        if (k3 instanceof b) {
            return (b) k3;
        }
        QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb] getSession  ID[" + j3 + "] no instance");
        return null;
    }

    @Override // com.tencent.mobileqq.filemanager.core.ThumbHttpDownloader.b
    public boolean b(long j3, ThumbHttpDownloader.a aVar) {
        b t16 = t(j3, false);
        if (t16 == null) {
            QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 2, "[downloadThumb]  ID[" + j3 + "] onGetDownloadUrl no this session");
            return false;
        }
        FileTransferHandler fileTransferHandler = this.f207631a.getFileTransferHandler();
        FileManagerEntity fileManagerEntity = t16.f207634b;
        fileTransferHandler.M(fileManagerEntity.Uuid, fileManagerEntity.fileIdCrc, j3);
        return true;
    }

    @Override // com.tencent.mobileqq.filemanager.core.a, com.tencent.mobileqq.filemanager.core.ThumbHttpDownloader.b
    public void c(long j3, boolean z16, int i3, String str, ThumbHttpDownloader.a aVar) {
        b t16 = t(j3, false);
        if (t16 == null) {
            QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 2, "[downloadThumb]  ID[" + j3 + "] onDownloadCompleted no this session");
            return;
        }
        if (z16) {
            FileManagerEntity fileManagerEntity = t16.f207634b;
            fileManagerEntity.strLargeThumPath = str;
            FileManagerUtil.fixEntityThumbSize(fileManagerEntity);
            this.f207631a.getFileManagerDataCenter().f0(t16.f207634b);
        }
        this.f207631a.getFileManagerNotifyCenter().b(z16, 50, new Object[]{t16.f207634b, Integer.valueOf(t16.f207670c)});
        super.c(j3, z16, i3, str, aVar);
    }

    @Override // com.tencent.mobileqq.filemanager.core.ThumbHttpDownloader.b
    public void e(long j3, HttpMsg httpMsg) {
        httpMsg.busiType = 0;
    }

    @Override // com.tencent.mobileqq.filemanager.core.ThumbHttpDownloader.b
    public List<String> g(long j3, String str, int i3, boolean z16, List<String> list) {
        b t16 = t(j3, false);
        if (t16 != null && t16.f207634b != null && !TextUtils.isEmpty(str) && d.c().isConfigEnableIPV6(this.f207631a, 1)) {
            QLog.i("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb]  ID[" + j3 + "] [IPv6-File] offlineVideo thumb. is config enable IPv6. domain[" + str + "]");
            d.c iPlistForV6Domain = d.c().getIPlistForV6Domain(this.f207631a, new d.a(str, i3), 1);
            if (iPlistForV6Domain != null && !iPlistForV6Domain.a()) {
                ArrayList arrayList = new ArrayList();
                for (d.b bVar : iPlistForV6Domain.f207644b) {
                    arrayList.add(bVar.f207641a + ":" + bVar.f207642b);
                }
                QLog.i("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb]  ID[" + j3 + "] [IPv6-File] offlineVideo thumb. use IPv6. hostlist:" + arrayList.toString());
                return arrayList;
            }
            QLog.i("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb]  ID[" + j3 + "] [IPv6-File] offlineVideo thumb. use IPv4");
            return null;
        }
        return null;
    }

    public String s(FileManagerEntity fileManagerEntity, int i3) {
        if (fileManagerEntity.Uuid == null) {
            QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb]  download. uuid = null nSession[" + fileManagerEntity.nSessionId + "]");
            this.f207631a.getFileManagerNotifyCenter().b(false, 50, new Object[]{fileManagerEntity});
            return null;
        }
        int n3 = n(fileManagerEntity.fileName);
        if (-1 == n3) {
            this.f207631a.getFileManagerNotifyCenter().b(false, 50, new Object[]{fileManagerEntity});
            return null;
        }
        j();
        String str = lc1.b.a().getDefaultThumbPath() + m(i3, fileManagerEntity.Uuid.replace("/", ""));
        if (!q.f(str) && !TextUtils.isEmpty(fileManagerEntity.strFileMd5)) {
            str = lc1.b.a().getDefaultThumbPath() + m(i3, com.tencent.securitysdk.utils.c.b(fileManagerEntity.strFileMd5));
        }
        if (FileUtils.fileExistsAndNotEmpty(str)) {
            QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb] Id[" + fileManagerEntity.nSessionId + "] thumb Downloaded:" + str);
            return str;
        }
        b bVar = new b(fileManagerEntity);
        bVar.f207670c = i3;
        bVar.f207671d = n3;
        i(bVar, str, true);
        QLog.i("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb] download  nSession[" + fileManagerEntity.nSessionId + "], ThumbDownloadId[" + bVar.f207633a + "]");
        return null;
    }

    @Override // com.tencent.mobileqq.filemanager.core.ThumbHttpDownloader.b
    public void a(long j3, ThumbHttpDownloader.a aVar) {
    }

    @Override // com.tencent.mobileqq.filemanager.core.ThumbHttpDownloader.b
    public void d(long j3, ThumbHttpDownloader.a aVar) {
    }
}
