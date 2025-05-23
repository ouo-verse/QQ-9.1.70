package com.tencent.mobileqq.filemanager.fileviewer.data;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.d;
import com.tencent.mobileqq.filemanager.core.g;
import com.tencent.mobileqq.troop.data.t;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import ef0.m;
import java.util.UUID;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6$DownloadFileRspBody;

/* compiled from: P */
/* loaded from: classes12.dex */
public class i implements b {

    /* renamed from: a, reason: collision with root package name */
    private t f208249a;

    /* renamed from: b, reason: collision with root package name */
    private UUID f208250b;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends m {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ g.b f208251d;

        a(g.b bVar) {
            this.f208251d = bVar;
        }

        @Override // ef0.m
        public void c(boolean z16, int i3, oidb_0x6d6$DownloadFileRspBody oidb_0x6d6_downloadfilerspbody, Bundle bundle) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (!(peekAppRuntime instanceof QQAppInterface)) {
                return;
            }
            QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
            if (oidb_0x6d6_downloadfilerspbody == null) {
                if (QLog.isDevelopLevel()) {
                    QLog.e("VideoForTroop<QFile>", 4, "error DownloadFileRspBody is null!!!!!");
                }
                this.f208251d.onError(-1, "");
                return;
            }
            TroopFileTransferManager N = TroopFileTransferManager.N(i.this.f208249a.f294971e);
            if (N == null) {
                QLog.e("VideoForTroop<QFile>", 1, "getUrl: onReqDownloadFileResult: get troopFileTransferManager failed.");
                return;
            }
            TroopFileTransferManager.Item J = N.J(i.this.f208250b);
            if (J == null) {
                this.f208251d.onError(-2, "");
                return;
            }
            int i16 = oidb_0x6d6_downloadfilerspbody.int32_ret_code.get();
            QLog.e("VideoForTroop<QFile>", 1, String.format("onRspDownload - retCode: %d", Integer.valueOf(i16)));
            if (oidb_0x6d6_downloadfilerspbody.bytes_cookie_val.has()) {
                String bytes2HexStr = HexUtil.bytes2HexStr(oidb_0x6d6_downloadfilerspbody.bytes_cookie_val.get().toByteArray());
                J.cookieValue = bytes2HexStr;
                J.cookieValue = bytes2HexStr.toLowerCase();
            }
            J.DownloadIp = oidb_0x6d6_downloadfilerspbody.str_download_ip.get();
            J.DownloadUrl = HexUtil.bytes2HexStr(oidb_0x6d6_downloadfilerspbody.bytes_download_url.get().toByteArray());
            J.Md5 = oidb_0x6d6_downloadfilerspbody.bytes_md5.get().toByteArray();
            J.NameForSave = oidb_0x6d6_downloadfilerspbody.str_save_file_name.get();
            if (i16 != -133 && i16 != -132 && i16 != -134) {
                if (i16 != -103 && i16 != -301) {
                    String str = J.DownloadIp;
                    String stringUtf8 = oidb_0x6d6_downloadfilerspbody.str_download_dns.get().toStringUtf8();
                    if (!TextUtils.isEmpty(stringUtf8) && com.tencent.mobileqq.filemanager.core.d.c().isConfigEnableIPV6(qQAppInterface, 3)) {
                        QLog.i("VideoForTroop<QFile>", 1, "[IPv6-File] troopVideo download. is config enable IPv6. domain[" + stringUtf8 + "]");
                        d.c iPlistForV6Domain = com.tencent.mobileqq.filemanager.core.d.c().getIPlistForV6Domain(qQAppInterface, new d.a(stringUtf8, 0), 3);
                        if (iPlistForV6Domain != null && !iPlistForV6Domain.a()) {
                            d.b bVar = iPlistForV6Domain.f207644b.get(0);
                            if (bVar != null && !TextUtils.isEmpty(bVar.f207641a)) {
                                String str2 = bVar.f207641a;
                                QLog.i("VideoForTroop<QFile>", 1, "[IPv6-File] troopVideo download. use IPv6. hostlist:" + str2);
                                str = str2;
                            }
                        } else {
                            QLog.i("VideoForTroop<QFile>", 1, "[IPv6-File] troopVideo download. use IPv4");
                        }
                    }
                    String a16 = zb1.a.a(str, J.DownloadUrl, J.FilePath, J.cookieValue, "");
                    QLog.i("VideoForTroop<QFile>", 1, "troopVideo download. downloadUrl:" + a16);
                    if (!TextUtils.isEmpty(a16)) {
                        this.f208251d.b(a16, J.cookieValue);
                        return;
                    } else {
                        this.f208251d.onError(-3, "");
                        return;
                    }
                }
                QLog.w("VideoForTroop<QFile>", 1, "file invalidate retCode = " + i16);
                this.f208251d.onError(i16, String.format(qQAppInterface.getApp().getBaseContext().getString(R.string.ekn), J.FileName));
                return;
            }
            QLog.w("VideoForTroop<QFile>", 1, "file invalidate retCode = " + i16);
            this.f208251d.onError(i16, String.format(qQAppInterface.getApp().getBaseContext().getString(R.string.ekm), J.FileName));
        }
    }

    public i(t tVar) {
        this.f208249a = tVar;
        UUID uuid = tVar.f294967a;
        this.f208250b = uuid;
        if (uuid != null) {
        } else {
            throw new NullPointerException("TroopFileStatusInfo Id null");
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.data.b
    public String a() {
        return this.f208249a.f294985s;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.data.b
    public /* synthetic */ void b() {
        com.tencent.mobileqq.filemanager.fileviewer.data.a.a(this);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.data.b
    public String c() {
        return lc1.b.a().getDefaultTmpPath() + com.tencent.securitysdk.utils.c.b(this.f208249a.f294985s);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.data.b
    public void d(boolean z16) {
        TroopFileTransferManager N = TroopFileTransferManager.N(this.f208249a.f294971e);
        if (N == null) {
            QLog.e("VideoForTroop<QFile>", 1, "notifyFileFailed: get troopFileTransferManager failed.");
            return;
        }
        TroopFileTransferManager.Item J = N.J(this.f208249a.f294967a);
        if (J != null) {
            if (z16) {
                N.n0(J, 12);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e("VideoForTroop<QFile>", 1, "notifyFileFaild isInvalid[" + z16 + "], itemStatus[" + J.Status + "]");
            }
            if (!com.tencent.mobileqq.troop.data.a.a(J.Status) && this.f208249a.f294972f != 7) {
                N.n0(J, 3);
            } else {
                N.n0(J, 10);
            }
        }
        com.tencent.mobileqq.filemanager.core.g.i(this);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.data.b
    public void e(long j3) {
        TroopFileTransferManager N = TroopFileTransferManager.N(this.f208249a.f294971e);
        if (N == null) {
            QLog.e("VideoForTroop<QFile>", 1, "notifyProgress: get troopFileTransferManager failed.");
            return;
        }
        TroopFileTransferManager.Item J = N.J(this.f208249a.f294967a);
        if (J != null) {
            J.ProgressValue = j3;
            N.n0(J, 8);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.data.b
    public void f(String str) {
        TroopFileTransferManager N = TroopFileTransferManager.N(this.f208249a.f294971e);
        if (N == null) {
            QLog.e("VideoForTroop<QFile>", 1, "notifySuccessed: get troopFileTransferManager failed.");
            return;
        }
        TroopFileTransferManager.Item J = N.J(this.f208249a.f294967a);
        if (J != null) {
            boolean a16 = com.tencent.mobileqq.troop.data.a.a(J.Status);
            if (QLog.isColorLevel()) {
                QLog.e("VideoForTroop<QFile>", 1, "notifySuccessed  itemStatus[" + J.Status + "]");
            }
            if (!a16 && this.f208249a.f294972f != 7) {
                N.n0(J, 6);
            } else {
                J.LocalFile = str;
                N.n0(J, 11);
            }
        }
        com.tencent.mobileqq.filemanager.core.g.i(this);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            ((QQAppInterface) peekAppRuntime).getNTFileManageBridger().N0(J, true);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.data.b
    public void g(g.b bVar) {
        TroopFileTransferManager N = TroopFileTransferManager.N(this.f208249a.f294971e);
        if (N == null) {
            QLog.e("VideoForTroop<QFile>", 1, "getUrl: get troopFileTransferManager failed.");
        } else {
            t tVar = this.f208249a;
            N.d0(tVar.f294985s, tVar.f294987u, tVar.f294976j, tVar.f294988v, new a(bVar));
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.data.b
    public String getFileName() {
        return this.f208249a.f294987u;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.data.b
    public long getFileSize() {
        return this.f208249a.f294976j;
    }
}
