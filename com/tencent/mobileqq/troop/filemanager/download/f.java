package com.tencent.mobileqq.troop.filemanager.download;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.data.n;
import com.tencent.mobileqq.troop.filemanager.c;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker;
import com.tencent.mobileqq.troop.filemanager.e;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.utils.be;
import com.tencent.qphone.base.util.MD5;
import com.tencent.util.URLUtil;
import ef0.g;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.java_websocket.WebSocketImpl;

/* compiled from: P */
/* loaded from: classes19.dex */
public class f extends TroopFileDownloadWorker {
    static IPatchRedirector $redirector_;
    protected String A;
    g B;

    /* renamed from: x, reason: collision with root package name */
    protected List<String> f295930x;

    /* renamed from: y, reason: collision with root package name */
    protected String f295931y;

    /* renamed from: z, reason: collision with root package name */
    protected boolean f295932z;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends g {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }

        @Override // ef0.g
        public void c(boolean z16, int i3, String str, String str2, int i16, int i17, String str3, ByteStringMicro byteStringMicro, String str4, ByteStringMicro byteStringMicro2, Bundle bundle) {
            String str5;
            IPatchRedirector iPatchRedirector = $redirector_;
            int i18 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), str, str2, Integer.valueOf(i16), Integer.valueOf(i17), str3, byteStringMicro, str4, byteStringMicro2, bundle);
                return;
            }
            if (!z16) {
                e.b.b("TroopZipInnerFileDownloadWorker", e.b.f295938b, "[" + f.this.f295875c + "] onReqDownloadResult isSuccess:false  errCode:" + i3);
                f fVar = f.this;
                fVar.f295886n.f295762k = 2;
                fVar.h(true, be.a.f302115b, be.a.A, 103);
                return;
            }
            e.b.c("TroopZipInnerFileDownloadWorker", e.b.f295938b, "[" + f.this.f295875c + "] onReqDownloadResult isSuccess:true  int32_ret_code:" + i3);
            if (TextUtils.isEmpty(str3) && i16 == 0) {
                e.b.b("TroopZipInnerFileDownloadWorker", e.b.f295938b, "[" + f.this.f295875c + "] onReqDownloadResult. no host");
                f fVar2 = f.this;
                c.a aVar = fVar2.f295886n;
                aVar.f295762k = 1;
                aVar.f295763l = 101;
                fVar2.h(true, be.a.f302116c, be.a.f302137x, 1);
                return;
            }
            String binToHEX = FileManagerUtil.binToHEX(byteStringMicro);
            if (TextUtils.isEmpty(binToHEX)) {
                e.b.b("TroopZipInnerFileDownloadWorker", e.b.f295938b, "[" + f.this.f295875c + "] onReqDownloadResult. no string_download_url");
                f fVar3 = f.this;
                c.a aVar2 = fVar3.f295886n;
                aVar2.f295762k = 1;
                aVar2.f295763l = 102;
                fVar3.h(true, be.a.f302115b, be.a.f302136w, 1);
                return;
            }
            String encodeUrl = URLUtil.encodeUrl(f.this.f295874b.zipInnerPath);
            QQAppInterface qQAppInterface = (QQAppInterface) this.mApp.get();
            if (qQAppInterface != null && TroopFileUtils.u(qQAppInterface) && TroopFileUtils.v(qQAppInterface) && bundle != null) {
                String string = bundle.getString("strHttpsDomain");
                if (!TextUtils.isEmpty(string)) {
                    f fVar4 = f.this;
                    fVar4.f295932z = true;
                    fVar4.A = string;
                    i18 = (short) bundle.getInt("httpsPort", 0);
                    if (i18 == 0) {
                        i18 = WebSocketImpl.DEFAULT_WSS_PORT;
                    }
                }
            }
            f fVar5 = f.this;
            if (!fVar5.f295932z) {
                i18 = i17;
            }
            fVar5.f295931y = "/ftn_compress_getfile/rkey=" + binToHEX + "&filetype=" + f.this.f295874b.zipType + "&path=" + encodeUrl + "&mType=Other";
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str3);
            sb5.append(":");
            sb5.append(i18);
            String sb6 = sb5.toString();
            f.this.f295930x.add(sb6);
            if (i16 != 0) {
                f.this.f295930x.add(f.this.H(i16) + ":" + i18);
            }
            if (f.this.f295932z) {
                str5 = "https://" + sb6 + f.this.f295931y;
            } else {
                str5 = "http://" + sb6 + f.this.f295931y;
            }
            f.this.f295874b.PreviewUrl = str5;
            try {
                f.this.f295874b.DownloadIp = new URL(str5).getHost();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            e.b.c("TroopZipInnerFileDownloadWorker", e.b.f295938b, "[" + f.this.f295875c + "] onReqDownloadResult. str_download_dns:" + str3 + " int32_server_ip:" + i16 + " int32_server_port:" + i17 + " mUrlParm:" + f.this.f295931y + " port:" + i18 + " isHttps:" + f.this.f295932z + " httpsDomain:" + f.this.A);
            f.this.E();
        }
    }

    protected f(long j3, TroopFileTransferManager.Item item, Bundle bundle, TroopFileDownloadWorker.b bVar) {
        super(j3, item, bundle, bVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), item, bundle, bVar);
            return;
        }
        this.f295930x = new ArrayList();
        this.f295932z = false;
        this.B = new a();
    }

    public static f G(long j3, TroopFileTransferManager.Item item, Bundle bundle, TroopFileDownloadWorker.b bVar) {
        if (j3 == 0) {
            e.b.b("TroopZipInnerFileDownloadWorker", e.b.f295938b, "getWoker. troopuin=0");
            return null;
        }
        if (item == null) {
            e.b.b("TroopZipInnerFileDownloadWorker", e.b.f295938b, "getWoker. item=null");
            return null;
        }
        if (item.Id == null) {
            e.b.b("TroopZipInnerFileDownloadWorker", e.b.f295938b, "getWoker. item.id=null");
            return null;
        }
        if (TextUtils.isEmpty(item.zipFilePath)) {
            e.b.b("TroopZipInnerFileDownloadWorker", e.b.f295938b, "getWoker. zipFilePath=null");
            return null;
        }
        if (TextUtils.isEmpty(item.zipInnerPath)) {
            e.b.b("TroopZipInnerFileDownloadWorker", e.b.f295938b, "getWoker. zipInnerPath=null");
            return null;
        }
        return new f(j3, item, bundle, bVar);
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker
    public boolean D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        this.f295930x.clear();
        return super.D();
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker
    protected void E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        QQAppInterface b16 = com.tencent.mobileqq.troop.filemanager.e.b();
        if (b16 == null) {
            e.b.b("TroopZipInnerFileDownloadWorker", e.b.f295938b, "[" + this.f295875c + "] startDownload app=null");
            c.a aVar = this.f295886n;
            aVar.f295762k = 9;
            aVar.f295763l = 902;
            h(true, be.a.f302115b, be.a.f302136w, 1);
            return;
        }
        this.f295881i = this.f295880h + MD5.toMD5(this.f295874b.FilePath);
        b bVar = this.f295877e;
        if (bVar != null) {
            bVar.f();
            this.f295877e = null;
        }
        this.f295887o = System.currentTimeMillis();
        this.f295886n.f295756e = q.m(this.f295881i);
        long a16 = com.tencent.mobileqq.troop.filemanager.e.a();
        e.b.c("TroopZipInnerFileDownloadWorker", e.b.f295938b, "[" + this.f295875c + "] startDownload. nSessionId:" + a16 + " firstIP=" + this.f295874b.DownloadIp + " urlParams:" + this.f295931y + " mTmpFilePath:" + this.f295881i);
        b x16 = TroopFileDownloader.x(b16, a16, this.f295881i, this.f295874b.ProgressTotal, this.f295930x, this.f295931y, null, this.f295932z, this.A);
        this.f295877e = x16;
        if (x16 == null) {
            c.a aVar2 = this.f295886n;
            aVar2.f295762k = 9;
            aVar2.f295763l = 903;
            h(true, be.a.f302115b, be.a.f302136w, 1);
            return;
        }
        x16.l(this);
        this.f295877e.download();
        C(2);
    }

    String H(long j3) {
        return (j3 & 255) + "." + ((j3 >> 8) & 255) + "." + ((j3 >> 16) & 255) + "." + ((j3 >> 24) & 255);
    }

    @Override // com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker
    protected void z() {
        n A;
        n A2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        com.tencent.mobileqq.troop.filemanager.b.e(this.f295873a, this.f295874b, 8);
        QQAppInterface b16 = com.tencent.mobileqq.troop.filemanager.e.b();
        if (b16 == null) {
            e.b.b("TroopZipInnerFileDownloadWorker", e.b.f295938b, "[" + this.f295875c + "] reqDownload app=null");
            c.a aVar = this.f295886n;
            aVar.f295762k = 9;
            aVar.f295763l = 902;
            h(true, be.a.f302115b, be.a.f302136w, 1);
            return;
        }
        e.b.c("TroopZipInnerFileDownloadWorker", e.b.f295938b, "[" + this.f295875c + "] reqDownload");
        TroopFileManager h16 = com.tencent.mobileqq.troop.filemanager.e.h(this.f295873a);
        if (h16 != null && (A = h16.A(this.f295874b.FilePath)) != null && (A2 = h16.A(A.f294929o)) != null) {
            A.f294930p = 8;
            A2.l(A);
        }
        this.f295932z = false;
        this.A = null;
        long j3 = this.f295873a;
        TroopFileTransferManager.Item item = this.f295874b;
        this.f295884l = com.tencent.biz.troop.file.a.h(b16, j3, item.zipFilePath, item.zipBusId, this.B);
        C(1);
        be.c();
    }
}
