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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c extends com.tencent.mobileqq.filemanager.core.a {

    /* renamed from: c, reason: collision with root package name */
    private FMObserver f207635c;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends FMObserver {
        a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x01dd  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x01e5  */
        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected void Z(boolean z16, int i3, String str, String str2, String str3, String str4, String str5, int i16, String str6, long j3, Bundle bundle) {
            String str7;
            String str8;
            boolean z17;
            short s16;
            String str9;
            QLog.i("DiscVideoThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + j3 + "] OnGetDiscVideoThumbInfo, bSuccess[" + z16 + " retCode:" + i3 + " downloadIp:" + str4 + " downloadDomain:" + str5 + " port:" + i16 + " url:" + str6 + " cookie:" + str2);
            b t16 = c.this.t(j3, false);
            if (t16 == null) {
                QLog.e("DiscVideoThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + j3 + "] OnGetDiscVideoThumbInfo no this session");
                c.this.o(j3, false, null, 0, null, null, str2, false, null, (short) 0, null);
                return;
            }
            if (!z16) {
                c.this.f207631a.getFileManagerNotifyCenter().b(false, 50, new Object[]{t16.f207634b});
                c.this.q(j3);
                c.this.o(j3, false, null, 0, null, null, str2, false, null, (short) 0, null);
                return;
            }
            if (str6 != null && str6.length() > 0) {
                QLog.w("DiscVideoThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + j3 + "] OnGetDiscVideoThumbInfo url=null");
                c.this.f207631a.getFileManagerNotifyCenter().b(false, 50, new Object[]{t16.f207634b});
                c.this.q(j3);
                c.this.o(j3, false, null, 0, null, null, str2, false, null, (short) 0, null);
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
                    QLog.w("DiscVideoThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + j3 + "] OnGetOfflineVideoThumbInfo downloadKey invaild");
                }
                String str10 = "/ftn_video_pic/rkey=" + str3 + "&filetype=" + t16.f207638d + "&size=" + c.this.l(t16.f207637c) + ContainerUtils.FIELD_DELIMITER;
                if (((IFMConfig) QRoute.api(IFMConfig.class)).isEnableHttpsThumb4Disc(c.this.f207631a) && bundle != null) {
                    String string = bundle.getString("strHttpsDomain");
                    if (!TextUtils.isEmpty(string)) {
                        short s17 = bundle.getShort("httpsPort", (short) 0);
                        if (s17 == 0) {
                            s17 = 443;
                        }
                        str8 = string;
                        z17 = true;
                        s16 = s17;
                        if (bundle == null) {
                            str9 = bundle.getString("IPv6Dns");
                        } else {
                            str9 = "";
                        }
                        c.this.o(j3, true, str7, i16, str10, null, str2, z17, str8, s16, str9);
                        return;
                    }
                }
                str8 = null;
                z17 = false;
                s16 = 0;
                if (bundle == null) {
                }
                c.this.o(j3, true, str7, i16, str10, null, str2, z17, str8, s16, str9);
                return;
            }
            c.this.f207631a.getFileManagerNotifyCenter().b(false, 50, new Object[]{t16.f207634b});
            c.this.q(j3);
            c.this.o(j3, false, null, 0, null, null, str2, false, null, (short) 0, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class b extends a.C7549a {

        /* renamed from: c, reason: collision with root package name */
        int f207637c;

        /* renamed from: d, reason: collision with root package name */
        int f207638d;

        public b(FileManagerEntity fileManagerEntity) {
            super(fileManagerEntity);
        }
    }

    public c(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        this.f207635c = new a();
        qQAppInterface.getFileManagerNotifyCenter().addObserver(this.f207635c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b t(long j3, boolean z16) {
        a.C7549a k3 = k(j3);
        if (k3 == null || !(k3 instanceof b)) {
            return null;
        }
        return (b) k3;
    }

    @Override // com.tencent.mobileqq.filemanager.core.ThumbHttpDownloader.b
    public boolean b(long j3, ThumbHttpDownloader.a aVar) {
        b t16 = t(j3, false);
        if (t16 == null) {
            QLog.e("DiscVideoThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + j3 + "] onGetDownloadUrl no this session");
            return false;
        }
        FileTransferHandler fileTransferHandler = this.f207631a.getFileTransferHandler();
        FileManagerEntity fileManagerEntity = t16.f207634b;
        fileTransferHandler.G(fileManagerEntity.peerUin, fileManagerEntity.Uuid, j3);
        return true;
    }

    @Override // com.tencent.mobileqq.filemanager.core.a, com.tencent.mobileqq.filemanager.core.ThumbHttpDownloader.b
    public void c(long j3, boolean z16, int i3, String str, ThumbHttpDownloader.a aVar) {
        b t16 = t(j3, false);
        if (t16 == null) {
            QLog.e("DiscVideoThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + j3 + "] onDownloadCompleted no this session");
            return;
        }
        if (z16) {
            FileManagerEntity fileManagerEntity = t16.f207634b;
            fileManagerEntity.strLargeThumPath = str;
            FileManagerUtil.fixEntityThumbSize(fileManagerEntity);
            this.f207631a.getFileManagerDataCenter().f0(t16.f207634b);
        }
        this.f207631a.getFileManagerNotifyCenter().b(z16, 50, new Object[]{t16.f207634b, Integer.valueOf(t16.f207637c)});
        super.c(j3, z16, i3, str, aVar);
    }

    @Override // com.tencent.mobileqq.filemanager.core.ThumbHttpDownloader.b
    public void e(long j3, HttpMsg httpMsg) {
        httpMsg.busiType = 0;
    }

    @Override // com.tencent.mobileqq.filemanager.core.ThumbHttpDownloader.b
    public List<String> g(long j3, String str, int i3, boolean z16, List<String> list) {
        b t16 = t(j3, false);
        if (t16 != null && t16.f207634b != null && !TextUtils.isEmpty(str) && d.c().isConfigEnableIPV6(this.f207631a, 5)) {
            QLog.i("DiscVideoThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + j3 + "] [IPv6-File] discVideo thumb. is config enable IPv6. domain[" + str + "]");
            d.c iPlistForV6Domain = d.c().getIPlistForV6Domain(this.f207631a, new d.a(str, i3), 5);
            if (iPlistForV6Domain != null && !iPlistForV6Domain.a()) {
                ArrayList arrayList = new ArrayList();
                for (d.b bVar : iPlistForV6Domain.f207644b) {
                    arrayList.add(bVar.f207641a + ":" + bVar.f207642b);
                }
                QLog.i("DiscVideoThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + j3 + "] [IPv6-File] discVideo thumb. use IPv6. hostlist:" + arrayList.toString());
                return arrayList;
            }
            QLog.i("DiscVideoThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + j3 + "] [IPv6-File] discVideo thumb. use IPv4:");
            return null;
        }
        return null;
    }

    public String s(FileManagerEntity fileManagerEntity, int i3) {
        if (fileManagerEntity.Uuid == null) {
            QLog.e("DiscVideoThumbDownloader<FileAssistant>", 1, "[downloadThumb]  download. uuid = null nSession[" + fileManagerEntity.nSessionId + "]");
            this.f207631a.getFileManagerNotifyCenter().b(false, 50, new Object[]{fileManagerEntity});
            return null;
        }
        int n3 = n(fileManagerEntity.fileName);
        if (-1 == n3) {
            QLog.e("DiscVideoThumbDownloader<FileAssistant>", 1, "[downloadThumb]  download. can not getThumb of file:" + fileManagerEntity.fileName);
            this.f207631a.getFileManagerNotifyCenter().b(false, 50, new Object[]{fileManagerEntity});
            return null;
        }
        String replace = fileManagerEntity.Uuid.replace("/", "");
        j();
        String str = lc1.b.a().getDefaultThumbPath() + m(i3, replace);
        if (FileUtils.fileExistsAndNotEmpty(str)) {
            QLog.e("DiscVideoThumbDownloader<FileAssistant>", 1, "[downloadThumb] Id[" + fileManagerEntity.nSessionId + "] thumb Downloaded:" + str);
            return str;
        }
        b bVar = new b(fileManagerEntity);
        bVar.f207637c = i3;
        bVar.f207638d = n3;
        i(bVar, str, true);
        QLog.i("DiscVideoThumbDownloader<FileAssistant>", 1, "[downloadThumb] download  nSession[" + fileManagerEntity.nSessionId + "], ThumbDownloadId[" + bVar.f207633a + "]");
        return null;
    }

    @Override // com.tencent.mobileqq.filemanager.core.ThumbHttpDownloader.b
    public void a(long j3, ThumbHttpDownloader.a aVar) {
    }

    @Override // com.tencent.mobileqq.filemanager.core.ThumbHttpDownloader.b
    public void d(long j3, ThumbHttpDownloader.a aVar) {
    }
}
