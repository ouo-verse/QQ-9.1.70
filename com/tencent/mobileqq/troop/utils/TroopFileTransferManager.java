package com.tencent.mobileqq.troop.utils;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopFileHandler;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.TroopFileTansferItemEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager;
import com.tencent.mobileqq.troop.file.api.ITroopFileApi;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferMgr;
import com.tencent.mobileqq.troop.filemanager.e;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.be;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.appcommon.Common;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.manager.IProxyIpService;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import tencent.im.cs.group_file_common.group_file_common$FileInfo;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6$UploadFileRspBody;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopFileTransferManager implements INetInfoHandler {
    static IPatchRedirector $redirector_;
    private static Map<Long, TroopFileTransferManager> P;
    protected long C;
    private ef0.n D;
    private ef0.i E;
    private ef0.l F;
    private ef0.l G;
    private volatile long H;
    public TaskPool[] I;
    protected QQAppInterface J;
    protected long K;
    protected Map<UUID, Item> L;
    protected Map<UUID, Integer> M;
    protected boolean N;

    /* renamed from: d, reason: collision with root package name */
    private TroopFileManager f301929d;

    /* renamed from: e, reason: collision with root package name */
    private IProxyIpService f301930e;

    /* renamed from: f, reason: collision with root package name */
    private ef0.p f301931f;

    /* renamed from: h, reason: collision with root package name */
    protected long f301932h;

    /* renamed from: i, reason: collision with root package name */
    protected long f301933i;

    /* renamed from: m, reason: collision with root package name */
    protected long f301934m;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public abstract class Task implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public Item f301947d;

        /* renamed from: e, reason: collision with root package name */
        public int f301948e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f301949f;

        /* renamed from: h, reason: collision with root package name */
        public boolean f301950h;

        protected Task(Item item, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopFileTransferManager.this, item, Integer.valueOf(i3));
                return;
            }
            this.f301949f = false;
            this.f301950h = false;
            this.f301947d = item;
            this.f301948e = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class TaskHttpDownload extends Task {
        static IPatchRedirector $redirector_;
        final /* synthetic */ TroopFileTransferManager this$0;

        private HttpURLConnection a(String str, String str2, String str3, long j3, long j16, String str4, String str5, boolean z16, d dVar) {
            String str6;
            String str7 = j3 + "-" + (j16 - 1);
            if (j3 == 0) {
                str6 = "http://" + str + "/ftn_handler/" + str2 + "/?fname=" + HexUtil.string2HexString(str3) + str5;
            } else {
                str6 = "http://" + str + "/ftn_handler/" + str2 + "/?fname=" + HexUtil.string2HexString(str3) + "&range=" + str7 + str5;
            }
            String str8 = str6;
            QLog.i("TroopFileTransferManager", 1, "<TroopFile> generateConnection url:" + str8);
            Item item = this.f301947d;
            item.downUrlStr4Report = str8;
            item.transferBeginTime = System.currentTimeMillis();
            try {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str8).openConnection();
                    if (httpURLConnection == null) {
                        return null;
                    }
                    httpURLConnection.setConnectTimeout(30000);
                    httpURLConnection.setReadTimeout(30000);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setRequestProperty("User-Agent", "TroopFile");
                    if (j16 != 0) {
                        httpURLConnection.setRequestProperty("Range", "bytes=" + str7);
                    }
                    httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                    httpURLConnection.setRequestProperty("Cookie", "FTN5K=" + str4);
                    if (dVar != null) {
                        dVar.f301956a = httpURLConnection.getResponseCode();
                    }
                    if (httpURLConnection.getResponseCode() != 200 && httpURLConnection.getResponseCode() != 206) {
                        String headerField = httpURLConnection.getHeaderField(HttpMsg.USERRETURNCODE);
                        if (headerField != null && dVar != null) {
                            dVar.f301957b = headerField;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.e("TroopFileTransferManager", 2, "generateConnection, ret.getResponseCode():" + httpURLConnection.getResponseCode() + " strUsrRetCode:" + headerField);
                        }
                        return null;
                    }
                    return httpURLConnection;
                } catch (Exception e16) {
                    QLog.e("TroopFileTransferManager", 1, "generateConnection error! url:" + str8, e16);
                    return null;
                }
            } catch (MalformedURLException unused) {
                if (z16) {
                    this.this$0.o0(this.f301947d, 10, 102);
                }
                return null;
            }
        }

        private HttpURLConnection b(String str, long j3, long j16, String str2, boolean z16, d dVar) {
            String str3 = j3 + "-";
            String str4 = str + "?&range=" + j3 + "&mType=Other";
            QLog.i("TroopFileTransferManager", 1, "<TroopFile> generateZipInnerConnection url:" + str4);
            Item item = this.f301947d;
            item.downUrlStr4Report = str4;
            item.transferBeginTime = System.currentTimeMillis();
            try {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str4).openConnection();
                    if (httpURLConnection == null) {
                        return null;
                    }
                    httpURLConnection.setConnectTimeout(30000);
                    httpURLConnection.setReadTimeout(30000);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setRequestProperty("User-Agent", "Troop");
                    if (j16 != 0) {
                        httpURLConnection.setRequestProperty("Range", "bytes=" + str3);
                    }
                    httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                    if (dVar != null) {
                        dVar.f301956a = httpURLConnection.getResponseCode();
                    }
                    if (httpURLConnection.getResponseCode() != 200 && httpURLConnection.getResponseCode() != 206) {
                        String headerField = httpURLConnection.getHeaderField(HttpMsg.USERRETURNCODE);
                        if (headerField != null && dVar != null) {
                            dVar.f301957b = headerField;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.e("TroopFileTransferManager", 2, "generateConnection, ret.getResponseCode():" + httpURLConnection.getResponseCode() + " strUsrRetCode:" + headerField);
                        }
                        return null;
                    }
                    return httpURLConnection;
                } catch (IOException e16) {
                    e16.printStackTrace();
                    return null;
                } catch (NullPointerException e17) {
                    if (QLog.isColorLevel()) {
                        QLog.e("TroopFileTransferManager", 2, "getResponseCode URL: " + str4 + ", exception:" + e17.getMessage());
                    }
                    return null;
                }
            } catch (MalformedURLException unused) {
                if (z16) {
                    this.this$0.o0(this.f301947d, 10, 102);
                }
                return null;
            }
        }

        /* JADX WARN: Can't wrap try/catch for region: R(7:(5:(3:107|(5:110|(1:112)|113|(19:116|117|(1:119)(1:319)|120|(3:122|(1:316)(1:126)|(6:290|291|(1:293)|294|(8:299|300|(1:304)|305|306|(2:310|311)|312|313)(3:296|297|298)|213)(3:128|129|(1:131)))(2:317|318)|132|133|134|(2:282|283)|136|137|138|139|140|141|142|143|144|(4:145|146|147|(6:149|150|151|152|153|(1:238)(5:155|156|157|158|(5:160|161|162|163|164)(4:170|171|172|(1:174)(0))))(2:259|260)))(1:115)|108)|320)|142|143|144|(5:145|146|147|(0)(0)|174))|136|137|138|139|140|141) */
        /* JADX WARN: Can't wrap try/catch for region: R(9:99|(7:(5:(3:107|(5:110|(1:112)|113|(19:116|117|(1:119)(1:319)|120|(3:122|(1:316)(1:126)|(6:290|291|(1:293)|294|(8:299|300|(1:304)|305|306|(2:310|311)|312|313)(3:296|297|298)|213)(3:128|129|(1:131)))(2:317|318)|132|133|134|(2:282|283)|136|137|138|139|140|141|142|143|144|(4:145|146|147|(6:149|150|151|152|153|(1:238)(5:155|156|157|158|(5:160|161|162|163|164)(4:170|171|172|(1:174)(0))))(2:259|260)))(1:115)|108)|320)|142|143|144|(5:145|146|147|(0)(0)|174))|136|137|138|139|140|141)|321|120|(0)(0)|132|133|134|(0)) */
        /* JADX WARN: Code restructure failed: missing block: B:176:0x03d0, code lost:
        
            r8.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:243:0x0348, code lost:
        
            r25.this$0.o0(r7, 10, 305);
            com.tencent.mobileqq.troop.utils.be.d(com.tencent.mobileqq.troop.utils.be.a.f302115b, com.tencent.mobileqq.troop.utils.be.a.f302130q);
         */
        /* JADX WARN: Code restructure failed: missing block: B:245:0x0352, code lost:
        
            r8.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:268:0x050a, code lost:
        
            r24 = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:269:0x0511, code lost:
        
            r5 = 2;
            r6 = 0;
            r10 = 10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:271:0x0515, code lost:
        
            r25.this$0.o0(r25.f301947d, 10, 304);
            com.tencent.mobileqq.troop.utils.be.d(com.tencent.mobileqq.troop.utils.be.a.f302115b, com.tencent.mobileqq.troop.utils.be.a.f302120g);
         */
        /* JADX WARN: Code restructure failed: missing block: B:274:0x0525, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:275:0x0526, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:276:0x0531, code lost:
        
            r1 = r15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:277:0x0506, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:278:0x0507, code lost:
        
            r24 = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:279:0x052d, code lost:
        
            r5 = 2;
            r6 = 0;
            r10 = 10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:288:0x0528, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:289:0x0529, code lost:
        
            r24 = r14;
            r4 = r23;
         */
        /* JADX WARN: Removed duplicated region for block: B:122:0x0231  */
        /* JADX WARN: Removed duplicated region for block: B:149:0x0333 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:197:0x053b  */
        /* JADX WARN: Removed duplicated region for block: B:201:0x055b A[Catch: IOException -> 0x057a, TryCatch #0 {IOException -> 0x057a, blocks: (B:199:0x0557, B:201:0x055b, B:203:0x0563), top: B:198:0x0557 }] */
        /* JADX WARN: Removed duplicated region for block: B:210:0x059f  */
        /* JADX WARN: Removed duplicated region for block: B:217:0x0555  */
        /* JADX WARN: Removed duplicated region for block: B:259:0x03cd A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:282:0x030b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x03e4  */
        /* JADX WARN: Removed duplicated region for block: B:317:0x02f9 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:41:0x043a  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0448  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            int i3;
            File file;
            String str;
            String str2;
            File file2;
            int i16;
            int i17;
            int i18;
            String str3;
            int i19;
            BufferedInputStream bufferedInputStream;
            Item item;
            FileOutputStream fileOutputStream;
            BufferedInputStream bufferedInputStream2;
            int i26;
            byte[] bArr;
            int read;
            Item item2;
            long j3;
            String str4;
            List<IProxyIpService.ProxyIp> proxyIp;
            Item item3;
            int i27;
            String str5;
            IPatchRedirector iPatchRedirector = $redirector_;
            int i28 = 2;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (this.this$0.Y(this.f301947d)) {
                return;
            }
            String str6 = "TroopFileTransferManager";
            if (QLog.isDevelopLevel()) {
                QLog.d("TroopFileTransferManager", 4, "http download begin");
            }
            int i29 = 10;
            if (!Common.w()) {
                this.this$0.o0(this.f301947d, 10, 308);
                be.d(be.a.f302115b, be.a.f302127n);
                return;
            }
            String str7 = AppConstants.SDCARD_FILE_SAVE_TROOPTMP_PATH;
            File file3 = new File(str7);
            if (!file3.exists()) {
                file3.mkdirs();
            }
            this.f301947d.TmpFile = str7 + HexUtil.bytes2HexStr(this.f301947d.FilePath.getBytes()) + ".tmp";
            File file4 = new File(this.f301947d.TmpFile);
            if (!file4.exists()) {
                try {
                    file4.createNewFile();
                } catch (IOException unused) {
                    this.this$0.o0(this.f301947d, 10, 303);
                    be.d(be.a.f302115b, be.a.f302121h);
                    return;
                }
            }
            this.f301947d.ProgressValue = file4.length();
            Item item4 = this.f301947d;
            int i36 = 0;
            item4.retryTimes = 0;
            long j16 = item4.ProgressTotal;
            if (j16 > item4.ProgressValue || j16 == 0) {
                int i37 = 0;
                boolean z16 = false;
                loop1: while (true) {
                    Item item5 = this.f301947d;
                    if (item5.ProgressTotal == item5.ProgressValue) {
                        break;
                    }
                    if (i37 >= 3) {
                        this.this$0.o0(item5, i29, 105);
                        if (QLog.isColorLevel()) {
                            QLog.d(str6, i28, "status:DOWNLOAD_INTERRUPT|item.DownloadIp:" + this.f301947d.DownloadIp);
                        }
                        if (!z16) {
                            be.e(be.a.f302117d, be.a.f302129p, this.f301947d.DownloadIp);
                            return;
                        }
                        return;
                    }
                    if (i37 > 0) {
                        if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
                            this.this$0.o0(this.f301947d, i29, 106);
                            be.d(be.a.f302115b, be.a.f302124k);
                            return;
                        }
                        for (int i38 = i36; i38 < i37 * 100; i38++) {
                            try {
                                LockMethodProxy.sleep(100L);
                            } catch (InterruptedException e16) {
                                e16.printStackTrace();
                            }
                            if (this.this$0.Y(this.f301947d)) {
                                return;
                            }
                            if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
                                this.this$0.o0(this.f301947d, i29, 106);
                                be.d(be.a.f302115b, be.a.f302124k);
                                return;
                            }
                        }
                    }
                    if (this.this$0.Y(this.f301947d)) {
                        return;
                    }
                    int i39 = i37 + 1;
                    this.f301947d.retryTimes = i39;
                    d dVar = new d();
                    char c16 = 1;
                    HttpURLConnection httpURLConnection = null;
                    try {
                        try {
                            if (this.this$0.Q() != null && !this.f301947d.isZipInnerFile && (proxyIp = this.this$0.Q().getProxyIp(5)) != null && !proxyIp.isEmpty()) {
                                for (IProxyIpService.ProxyIp proxyIp2 : proxyIp) {
                                    if (QLog.isColorLevel()) {
                                        Object[] objArr = new Object[i28];
                                        objArr[i36] = proxyIp2.f417211ip;
                                        objArr[c16] = Integer.valueOf(proxyIp2.port);
                                        QLog.d(str6, i28, String.format("Http downloading, trying ip: %s, port: %d...", objArr));
                                    }
                                    Object[] objArr2 = new Object[i28];
                                    objArr2[i36] = this.f301947d.DownloadIp;
                                    objArr2[c16] = 80;
                                    String format = String.format("&bHost=%s&bPort=%d", objArr2);
                                    String str8 = proxyIp2.f417211ip;
                                    Item item6 = this.f301947d;
                                    i3 = i39;
                                    file = file4;
                                    String str9 = str6;
                                    httpURLConnection = a(str8, item6.DownloadUrl, item6.FilePath, item6.ProgressValue, item6.ProgressTotal, item6.cookieValue, format, false, dVar);
                                    if (httpURLConnection != null) {
                                        if (QLog.isColorLevel()) {
                                            str6 = str9;
                                            QLog.d(str6, 2, String.format("Http connection established!", new Object[0]));
                                        } else {
                                            str6 = str9;
                                        }
                                        if (httpURLConnection != null) {
                                            Item item7 = this.f301947d;
                                            if (item7.isZipInnerFile && (str4 = item7.PreviewUrl) != null) {
                                                httpURLConnection = b(str4, item7.ProgressValue, item7.ProgressTotal, item7.cookieValue, false, dVar);
                                                str = str6;
                                            } else {
                                                str = str6;
                                                httpURLConnection = a(item7.DownloadIp, item7.DownloadUrl, item7.FilePath, item7.ProgressValue, item7.ProgressTotal, item7.cookieValue, "", true, dVar);
                                            }
                                            if (httpURLConnection == null) {
                                                if (QLog.isColorLevel()) {
                                                    QLog.d(str, 2, "conn == null , retry:" + i3 + ",item.DownloadIp:" + this.f301947d.DownloadIp + ",item.DownloadUrl" + this.f301947d.DownloadUrl);
                                                }
                                                if (i3 == 3) {
                                                    int i46 = be.a.f302139z;
                                                    int i47 = dVar.f301956a;
                                                    if (i47 != 200 && i47 != 206) {
                                                        i46 = i47;
                                                    }
                                                    try {
                                                        String str10 = dVar.f301957b;
                                                        if (str10 != null && !TextUtils.isEmpty(str10)) {
                                                            i46 = Integer.valueOf(dVar.f301957b).intValue();
                                                        }
                                                    } catch (NumberFormatException | Exception unused2) {
                                                    }
                                                    be.e(be.a.f302117d, i46, this.f301947d.DownloadIp);
                                                    str6 = str;
                                                    i37 = i3;
                                                    file4 = file;
                                                    i36 = 0;
                                                    i29 = 10;
                                                    i28 = 2;
                                                    z16 = true;
                                                } else {
                                                    str6 = str;
                                                    i37 = i3;
                                                    file4 = file;
                                                    i36 = 0;
                                                    i29 = 10;
                                                    i28 = 2;
                                                }
                                            } else if (QLog.isColorLevel()) {
                                                QLog.d(str, 2, String.format("Original http connection established!", new Object[0]));
                                            }
                                        } else {
                                            str = str6;
                                        }
                                        bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                                        item = this.f301947d;
                                        if (item.ProgressTotal == 0) {
                                            try {
                                                item.ProgressTotal = httpURLConnection.getContentLength();
                                            } catch (IOException e17) {
                                                e = e17;
                                                str2 = str;
                                                i37 = i3;
                                                file2 = file;
                                                i16 = 2;
                                                i17 = 0;
                                                i18 = 10;
                                                if (!QLog.isDevelopLevel()) {
                                                }
                                                try {
                                                    if (e instanceof ProtocolException) {
                                                        this.this$0.o0(this.f301947d, i18, 105);
                                                        be.e(be.a.f302117d, httpURLConnection.getResponseCode(), this.f301947d.DownloadIp);
                                                        return;
                                                    }
                                                } catch (IOException unused3) {
                                                    if (QLog.isColorLevel()) {
                                                        i19 = 4;
                                                        QLog.e(str3, 4, "TroopFileTransferManager IOException" + e.toString());
                                                        if (QLog.isDevelopLevel()) {
                                                            QLog.e(str3, i19, "download retry" + i37);
                                                        }
                                                        i28 = i16;
                                                        str6 = str3;
                                                        i29 = i18;
                                                        file4 = file2;
                                                        i36 = i17;
                                                    }
                                                }
                                                i19 = 4;
                                                if (QLog.isDevelopLevel()) {
                                                }
                                                i28 = i16;
                                                str6 = str3;
                                                i29 = i18;
                                                file4 = file2;
                                                i36 = i17;
                                            }
                                        }
                                        file2 = file;
                                        fileOutputStream = new FileOutputStream(file2, true);
                                        bArr = new byte[8192];
                                        i26 = i3;
                                        while (true) {
                                            try {
                                                read = bufferedInputStream.read(bArr);
                                                if (read == -1) {
                                                    try {
                                                        item2 = this.f301947d;
                                                        bufferedInputStream2 = bufferedInputStream;
                                                        j3 = read;
                                                        str2 = str;
                                                    } catch (Throwable th5) {
                                                        th = th5;
                                                        bufferedInputStream2 = bufferedInputStream;
                                                        str2 = str;
                                                    }
                                                    try {
                                                        if (item2.ProgressValue + j3 > item2.ProgressTotal) {
                                                            break;
                                                        }
                                                        i18 = 10;
                                                        try {
                                                            try {
                                                                fileOutputStream.write(bArr, 0, read);
                                                                Item item8 = this.f301947d;
                                                                item8.ProgressValue += j3;
                                                                item8.transferedSize += j3;
                                                                this.this$0.l0(1, j3);
                                                                if (this.this$0.Y(this.f301947d)) {
                                                                    try {
                                                                        bufferedInputStream2.close();
                                                                    } catch (IOException unused4) {
                                                                    }
                                                                    try {
                                                                        fileOutputStream.close();
                                                                        return;
                                                                    } catch (IOException unused5) {
                                                                        return;
                                                                    }
                                                                }
                                                                try {
                                                                    Item item9 = this.f301947d;
                                                                    item9.retryTimes = 0;
                                                                    this.this$0.X(item9);
                                                                    Item item10 = this.f301947d;
                                                                    if (item10.ProgressValue != item10.ProgressTotal) {
                                                                        bufferedInputStream = bufferedInputStream2;
                                                                        str = str2;
                                                                        i26 = 0;
                                                                    }
                                                                } catch (Throwable th6) {
                                                                    th = th6;
                                                                    i16 = 2;
                                                                    i17 = 0;
                                                                    i26 = 0;
                                                                    try {
                                                                        bufferedInputStream2.close();
                                                                    } catch (IOException unused6) {
                                                                    }
                                                                    try {
                                                                        fileOutputStream.close();
                                                                    } catch (IOException unused7) {
                                                                    }
                                                                    try {
                                                                        throw th;
                                                                    } catch (IOException e18) {
                                                                        e = e18;
                                                                        i37 = i26;
                                                                        if (!QLog.isDevelopLevel()) {
                                                                            str3 = str2;
                                                                            QLog.e(str3, 4, "TroopFileTransferManager IOException" + e.toString());
                                                                        } else {
                                                                            str3 = str2;
                                                                        }
                                                                        if ((e instanceof ProtocolException) && 206 == httpURLConnection.getResponseCode()) {
                                                                            this.this$0.o0(this.f301947d, i18, 105);
                                                                            be.e(be.a.f302117d, httpURLConnection.getResponseCode(), this.f301947d.DownloadIp);
                                                                            return;
                                                                        }
                                                                        i19 = 4;
                                                                        if (QLog.isDevelopLevel()) {
                                                                        }
                                                                        i28 = i16;
                                                                        str6 = str3;
                                                                        i29 = i18;
                                                                        file4 = file2;
                                                                        i36 = i17;
                                                                    }
                                                                }
                                                            } catch (IOException unused8) {
                                                                this.this$0.o0(this.f301947d, 10, 306);
                                                                be.d(be.a.f302115b, be.a.f302122i);
                                                                try {
                                                                    bufferedInputStream2.close();
                                                                } catch (IOException unused9) {
                                                                }
                                                                try {
                                                                    fileOutputStream.close();
                                                                    return;
                                                                } catch (IOException unused10) {
                                                                    return;
                                                                }
                                                            } catch (Throwable th7) {
                                                                th = th7;
                                                                i17 = 0;
                                                                i16 = 2;
                                                            }
                                                        } catch (Throwable th8) {
                                                            th = th8;
                                                            i16 = 2;
                                                            i17 = 0;
                                                            bufferedInputStream2.close();
                                                            fileOutputStream.close();
                                                            throw th;
                                                        }
                                                    } catch (Throwable th9) {
                                                        th = th9;
                                                        i18 = 10;
                                                        i16 = 2;
                                                        i17 = 0;
                                                        bufferedInputStream2.close();
                                                        fileOutputStream.close();
                                                        throw th;
                                                    }
                                                } else {
                                                    bufferedInputStream2 = bufferedInputStream;
                                                    i18 = 10;
                                                    break loop1;
                                                }
                                            } catch (Throwable th10) {
                                                th = th10;
                                                bufferedInputStream2 = bufferedInputStream;
                                                str2 = str;
                                                i16 = 2;
                                                i17 = 0;
                                                i18 = 10;
                                            }
                                        }
                                    } else {
                                        i36 = 0;
                                        i39 = i3;
                                        file4 = file;
                                        str6 = str9;
                                        c16 = 1;
                                        i28 = 2;
                                    }
                                }
                            }
                            bArr = new byte[8192];
                            i26 = i3;
                            while (true) {
                                read = bufferedInputStream.read(bArr);
                                if (read == -1) {
                                }
                                bufferedInputStream = bufferedInputStream2;
                                str = str2;
                                i26 = 0;
                            }
                        } catch (Throwable th11) {
                            th = th11;
                            bufferedInputStream2 = bufferedInputStream;
                            str2 = str;
                            i16 = 2;
                            i17 = 0;
                            i18 = 10;
                            i26 = i3;
                        }
                        file2 = file;
                        fileOutputStream = new FileOutputStream(file2, true);
                    } catch (FileNotFoundException unused11) {
                        str2 = str;
                        file2 = file;
                    }
                    i3 = i39;
                    file = file4;
                    if (httpURLConnection != null) {
                    }
                    bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                    item = this.f301947d;
                    if (item.ProgressTotal == 0) {
                    }
                }
                if (this.f301947d.FileName.length() > 85) {
                    int lastIndexOf = this.f301947d.FileName.lastIndexOf(46);
                    if (lastIndexOf < 0) {
                        lastIndexOf = 0;
                    }
                    int length = this.f301947d.FileName.length() - 85;
                    if (lastIndexOf == 0) {
                        Item item11 = this.f301947d;
                        item11.FileName = item11.FileName.substring(0, 85);
                    } else if (lastIndexOf > length) {
                        this.f301947d.FileName = this.f301947d.FileName.substring(0, lastIndexOf - length) + this.f301947d.FileName.substring(lastIndexOf);
                    }
                }
                item3 = this.f301947d;
                String str11 = item3.FileName;
                if (!TextUtils.isEmpty(item3.NameForSave)) {
                    Item item12 = this.f301947d;
                    if (item12.SafeCheckRes == 2) {
                        str11 = item12.NameForSave;
                    }
                }
                for (i27 = 0; i27 < 1000; i27++) {
                    if (i27 > 0) {
                        int lastIndexOf2 = str11.lastIndexOf(46);
                        if (lastIndexOf2 < 0) {
                            lastIndexOf2 = 0;
                        }
                        str5 = AppConstants.SDCARD_FILE_SAVE_PATH + str11.substring(0, lastIndexOf2) + "(" + i27 + ")" + str11.substring(lastIndexOf2);
                    } else {
                        str5 = AppConstants.SDCARD_FILE_SAVE_PATH + str11;
                    }
                    File file5 = new File(str5);
                    if (!file5.exists() && file2.renameTo(file5)) {
                        Item item13 = this.f301947d;
                        item13.LocalFile = str5;
                        this.this$0.n0(item13, 11);
                        String bytes2HexStr = HexUtil.bytes2HexStr(this.f301947d.Md5);
                        String bytes2HexStr2 = HexUtil.bytes2HexStr(this.f301947d.Sha);
                        TroopFileTransferManager troopFileTransferManager = this.this$0;
                        troopFileTransferManager.o(this.f301947d.getInfo(troopFileTransferManager.K), false, bytes2HexStr, bytes2HexStr2, this.f301947d.Sha3);
                        be.d(be.a.f302114a, 0);
                        return;
                    }
                }
                this.this$0.o0(this.f301947d, i18, 307);
                be.d(be.a.f302115b, be.a.f302128o);
                return;
            }
            file2 = file4;
            i18 = i29;
            if (this.f301947d.FileName.length() > 85) {
            }
            item3 = this.f301947d;
            String str112 = item3.FileName;
            if (!TextUtils.isEmpty(item3.NameForSave)) {
            }
            while (i27 < 1000) {
            }
            this.this$0.o0(this.f301947d, i18, 307);
            be.d(be.a.f302115b, be.a.f302128o);
            return;
            try {
                fileOutputStream.close();
                break loop1;
            } catch (IOException unused12) {
            }
            if (this.f301947d.FileName.length() > 85) {
            }
            item3 = this.f301947d;
            String str1122 = item3.FileName;
            if (!TextUtils.isEmpty(item3.NameForSave)) {
            }
            while (i27 < 1000) {
            }
            this.this$0.o0(this.f301947d, i18, 307);
            be.d(be.a.f302115b, be.a.f302128o);
            return;
            try {
                fileOutputStream.close();
            } catch (IOException unused13) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class TaskHttpUpload extends Task {
        static IPatchRedirector $redirector_;

        public TaskHttpUpload(Item item) {
            super(item, 2);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopFileTransferManager.this, (Object) item);
            } else {
                this.f301949f = true;
            }
        }

        private HttpResponse a(HttpClient httpClient, String str, byte[] bArr) {
            if (httpClient != null && str != null && bArr != null) {
                HttpPost httpPost = new HttpPost(str);
                httpPost.setHeader("User-Agent", "TroopFile");
                httpPost.setHeader("Content-Type", "text/octet");
                httpPost.setHeader("Connection", "keep-alive");
                if (NetworkUtil.isWifiConnected(BaseApplication.getContext())) {
                    httpPost.setHeader("Net-type", com.tencent.mobileqq.msf.core.x.q.f250391w);
                } else {
                    httpPost.setHeader("Net-type", "gprs");
                }
                httpPost.setEntity(new ByteArrayEntity(bArr));
                try {
                    return httpClient.execute(httpPost);
                } catch (IllegalArgumentException unused) {
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopFileTransferManager", 2, "IllegalArgumentException, url" + str);
                    }
                    return null;
                } catch (ClientProtocolException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopFileTransferManager", 2, "ClientProtocolException, url" + str);
                    }
                    e16.printStackTrace();
                } catch (IOException e17) {
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopFileTransferManager", 2, "IOException, url" + str);
                    }
                    e17.printStackTrace();
                    return null;
                } catch (Exception unused2) {
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopFileTransferManager", 2, "Exception, url" + str);
                    }
                    return null;
                }
            }
            return null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:111:0x06c7, code lost:
        
            if (r17 == null) goto L337;
         */
        /* JADX WARN: Code restructure failed: missing block: B:113:0x06ed, code lost:
        
            if (r9 <= 3) goto L343;
         */
        /* JADX WARN: Code restructure failed: missing block: B:114:0x06ef, code lost:
        
            r26.this$0.o0(r26.f301947d, 3, 105);
         */
        /* JADX WARN: Code restructure failed: missing block: B:115:0x06fc, code lost:
        
            if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L342;
         */
        /* JADX WARN: Code restructure failed: missing block: B:116:0x06fe, code lost:
        
            com.tencent.qphone.base.util.QLog.d("TroopFileTransferManager", 2, "status:UPLOAD_INTERRUPT|item.UploadIp:" + r26.f301947d.UploadIp);
         */
        /* JADX WARN: Code restructure failed: missing block: B:117:0x0718, code lost:
        
            com.tencent.mobileqq.troop.utils.be.h(com.tencent.mobileqq.troop.utils.be.a.f302117d, r2, r26.f301947d.UploadIp);
         */
        /* JADX WARN: Code restructure failed: missing block: B:118:0x07ec, code lost:
        
            r2 = r26.f301947d;
            r2.CheckKey = null;
            r2.UploadIp = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:119:0x07f3, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:120:0x0723, code lost:
        
            r2 = r26.f301947d;
            r2.ProgressValue = r2.ProgressTotal;
            r26.this$0.n0(r2, 6);
            r26.this$0.y(r26.f301947d);
            r6 = com.tencent.mobileqq.utils.HexUtil.bytes2HexStr(r26.f301947d.Md5);
            r7 = com.tencent.mobileqq.utils.HexUtil.bytes2HexStr(r26.f301947d.Sha);
            r3 = r26.this$0;
            r3.o(r26.f301947d.getInfo(r3.K), true, r6, r7, r26.f301947d.Sha3);
            r2 = r26.f301947d;
            r2.Md5 = null;
            r2.Sha = null;
            com.tencent.mobileqq.statistics.ReportController.o(r26.this$0.J, "P_CliOper", "Grp_files", "", "oper", "upload_suc", 0, 0, r26.this$0.K + "", (!"/".equals(r26.f301947d.mParentId) ? 1 : 0) + "", "", "");
         */
        /* JADX WARN: Code restructure failed: missing block: B:121:0x07b4, code lost:
        
            if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L346;
         */
        /* JADX WARN: Code restructure failed: missing block: B:122:0x07b6, code lost:
        
            com.tencent.qphone.base.util.QLog.d("TroopFileItem", 2, "mTroopUin=" + r26.this$0.K + " " + (!"/".equals(r26.f301947d.mParentId) ? 1 : 0));
         */
        /* JADX WARN: Code restructure failed: missing block: B:123:0x07e6, code lost:
        
            com.tencent.mobileqq.troop.utils.be.g(com.tencent.mobileqq.troop.utils.be.a.f302114a, 0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:125:0x06c9, code lost:
        
            r17.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:127:0x06cd, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:129:0x06d3, code lost:
        
            if (com.tencent.qphone.base.util.QLog.isColorLevel() != false) goto L336;
         */
        /* JADX WARN: Code restructure failed: missing block: B:130:0x06d5, code lost:
        
            com.tencent.qphone.base.util.QLog.i("TroopFileTransferManager", 2, "close uploadFileStream," + r0.toString(), r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:280:0x06c5, code lost:
        
            r2 = r16;
         */
        /* JADX WARN: Removed duplicated region for block: B:174:0x056e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:184:0x05a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:192:? A[Catch: all -> 0x064e, InterruptedException -> 0x0653, SYNTHETIC, TRY_LEAVE, TryCatch #14 {InterruptedException -> 0x0653, blocks: (B:34:0x0201, B:39:0x020d, B:40:0x0238, B:44:0x0248, B:53:0x02d6, B:54:0x0330, B:245:0x0345, B:247:0x034b, B:248:0x0359, B:56:0x036b, B:61:0x037b, B:63:0x0381, B:65:0x038a, B:67:0x03b3, B:68:0x03c0, B:70:0x03c9, B:72:0x03cf, B:74:0x03e3, B:76:0x03f0, B:78:0x03fd, B:96:0x0426, B:134:0x0478, B:224:0x0498, B:159:0x050f, B:165:0x0515, B:175:0x056e, B:179:0x058f, B:185:0x05a1, B:191:0x05aa, B:190:0x05a7, B:199:0x0589, B:229:0x049e, B:249:0x030e, B:256:0x05f8, B:300:0x0219), top: B:33:0x0201 }] */
        /* JADX WARN: Removed duplicated region for block: B:198:0x0589 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:287:0x05ff A[Catch: all -> 0x0658, InterruptedException -> 0x065b, TryCatch #18 {InterruptedException -> 0x065b, blocks: (B:384:0x0084, B:424:0x0090, B:390:0x00cb, B:392:0x0100, B:396:0x010a, B:26:0x014c, B:28:0x017c, B:357:0x018b, B:341:0x01c0, B:285:0x05f9, B:287:0x05ff, B:288:0x0619, B:343:0x01c6), top: B:383:0x0084 }] */
        /* JADX WARN: Removed duplicated region for block: B:311:0x067b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:321:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:325:0x06a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:335:? A[SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            List<IProxyIpService.ProxyIp> list;
            boolean z16;
            HttpClient a16;
            boolean z17;
            int i3;
            Throwable th5;
            InterruptedException interruptedException;
            FileInputStream fileInputStream;
            IOException iOException;
            FileInputStream fileInputStream2;
            long j3;
            byte[] bArr;
            String format;
            Throwable th6;
            DataInputStream dataInputStream;
            List<IProxyIpService.ProxyIp> list2;
            long j16;
            IllegalStateException illegalStateException;
            DataInputStream dataInputStream2;
            IOException iOException2;
            DataInputStream dataInputStream3;
            IOException iOException3;
            DataInputStream dataInputStream4;
            long j17;
            Header firstHeader;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            Item item = this.f301947d;
            long j18 = item.ProgressValue;
            if (TroopFileTransferManager.this.Z(item)) {
                return;
            }
            File file = new File(this.f301947d.LocalFile);
            this.f301947d.retryTimes = 0;
            if (TroopFileTransferManager.this.Q() != null) {
                list = TroopFileTransferManager.this.Q().getProxyIp(5);
            } else {
                list = null;
            }
            if (list != null && list.size() > 0 && list.get(0) != null) {
                a16 = com.dataline.util.g.b(false, list.get(0).port, 10000, 20000);
                z17 = true;
            } else {
                if (com.dataline.util.g.d() != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                a16 = com.dataline.util.g.a(false, z16, 10000, 20000);
                z17 = false;
            }
            int i16 = 0;
            int i17 = 1024;
            int i18 = -1;
            FileInputStream fileInputStream3 = null;
            long j19 = j18;
            while (true) {
                if (i16 > 3) {
                    break;
                }
                if (i16 > 0) {
                    try {
                        try {
                            if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
                                TroopFileTransferManager.this.o0(this.f301947d, 3, 106);
                                be.g(be.a.f302115b, be.a.f302124k);
                                if (fileInputStream3 != null) {
                                    try {
                                        fileInputStream3.close();
                                        return;
                                    } catch (IOException e16) {
                                        if (QLog.isColorLevel()) {
                                            QLog.i("TroopFileTransferManager", 2, "close uploadFileStream," + e16.toString(), e16);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                return;
                            }
                            int i19 = 0;
                            while (i19 < i16 * 100) {
                                LockMethodProxy.sleep(100L);
                                HttpClient httpClient = a16;
                                if (TroopFileTransferManager.this.Z(this.f301947d)) {
                                    if (fileInputStream3 != null) {
                                        try {
                                            fileInputStream3.close();
                                            return;
                                        } catch (IOException e17) {
                                            if (QLog.isColorLevel()) {
                                                QLog.i("TroopFileTransferManager", 2, "close uploadFileStream," + e17.toString(), e17);
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    return;
                                }
                                if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
                                    TroopFileTransferManager.this.o0(this.f301947d, 3, 106);
                                    be.g(be.a.f302115b, be.a.f302124k);
                                    if (fileInputStream3 != null) {
                                        try {
                                            fileInputStream3.close();
                                            return;
                                        } catch (IOException e18) {
                                            if (QLog.isColorLevel()) {
                                                QLog.i("TroopFileTransferManager", 2, "close uploadFileStream," + e18.toString(), e18);
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    return;
                                }
                                i19++;
                                a16 = httpClient;
                            }
                        } catch (Throwable th7) {
                            th5 = th7;
                            if (fileInputStream3 == null) {
                                try {
                                    fileInputStream3.close();
                                    throw th5;
                                } catch (IOException e19) {
                                    if (QLog.isColorLevel()) {
                                        QLog.i("TroopFileTransferManager", 2, "close uploadFileStream," + e19.toString(), e19);
                                        throw th5;
                                    }
                                    throw th5;
                                }
                            }
                            throw th5;
                        }
                    } catch (InterruptedException e26) {
                        interruptedException = e26;
                        QLog.e("TroopFileTransferManager", 1, "upload file failed, http thread interrupted!", interruptedException);
                        TroopFileTransferManager.this.o0(this.f301947d, 3, 102);
                        be.h(be.a.f302115b, be.a.f302134u, this.f301947d.UploadIp);
                        if (fileInputStream3 == null) {
                            try {
                                fileInputStream3.close();
                                return;
                            } catch (IOException e27) {
                                if (QLog.isColorLevel()) {
                                    QLog.i("TroopFileTransferManager", 2, "close uploadFileStream," + e27.toString(), e27);
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    }
                }
                HttpClient httpClient2 = a16;
                if (TroopFileTransferManager.this.Z(this.f301947d)) {
                    if (fileInputStream3 != null) {
                        try {
                            fileInputStream3.close();
                            return;
                        } catch (IOException e28) {
                            if (QLog.isColorLevel()) {
                                QLog.i("TroopFileTransferManager", 2, "close uploadFileStream," + e28.toString(), e28);
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                long length = file.length();
                Item item2 = this.f301947d;
                boolean z18 = z17;
                if (length != item2.ProgressTotal) {
                    TroopFileTransferManager.this.o0(item2, 3, 206);
                    be.g(be.a.f302115b, be.a.f302133t);
                    if (fileInputStream3 != null) {
                        try {
                            fileInputStream3.close();
                            return;
                        } catch (IOException e29) {
                            if (QLog.isColorLevel()) {
                                QLog.i("TroopFileTransferManager", 2, "close uploadFileStream," + e29.toString(), e29);
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                if (fileInputStream3 == null) {
                    try {
                        fileInputStream = new FileInputStream(file);
                    } catch (FileNotFoundException unused) {
                        TroopFileTransferManager.this.o0(this.f301947d, 3, 201);
                        be.g(be.a.f302115b, be.a.f302120g);
                        if (fileInputStream3 != null) {
                            try {
                                fileInputStream3.close();
                                return;
                            } catch (IOException e36) {
                                if (QLog.isColorLevel()) {
                                    QLog.i("TroopFileTransferManager", 2, "close uploadFileStream," + e36.toString(), e36);
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    }
                } else {
                    fileInputStream = fileInputStream3;
                }
                i16++;
                try {
                    try {
                        this.f301947d.retryTimes = i16;
                        byte[] bArr2 = new byte[i17];
                        if (j18 > j19) {
                            try {
                                fileInputStream.skip(j18 - j19);
                            } catch (IOException e37) {
                                iOException = e37;
                                fileInputStream2 = fileInputStream;
                                if (QLog.isColorLevel()) {
                                    QLog.i("TroopFileTransferManager", 2, "read  file," + iOException.toString(), iOException);
                                }
                                TroopFileTransferManager.this.o0(this.f301947d, 3, 203);
                                be.g(be.a.f302115b, be.a.f302123j);
                                try {
                                    fileInputStream2.close();
                                    return;
                                } catch (IOException e38) {
                                    if (QLog.isColorLevel()) {
                                        QLog.i("TroopFileTransferManager", 2, "close uploadFileStream," + e38.toString(), e38);
                                        return;
                                    }
                                    return;
                                }
                            }
                        } else if (j18 < j19) {
                            fileInputStream.close();
                            FileInputStream fileInputStream4 = new FileInputStream(file);
                            try {
                                fileInputStream4.skip(j18);
                                fileInputStream = fileInputStream4;
                            } catch (IOException e39) {
                                iOException = e39;
                                fileInputStream2 = fileInputStream4;
                                if (QLog.isColorLevel()) {
                                }
                                TroopFileTransferManager.this.o0(this.f301947d, 3, 203);
                                be.g(be.a.f302115b, be.a.f302123j);
                                fileInputStream2.close();
                                return;
                            } catch (InterruptedException e46) {
                                interruptedException = e46;
                                fileInputStream3 = fileInputStream4;
                                QLog.e("TroopFileTransferManager", 1, "upload file failed, http thread interrupted!", interruptedException);
                                TroopFileTransferManager.this.o0(this.f301947d, 3, 102);
                                be.h(be.a.f302115b, be.a.f302134u, this.f301947d.UploadIp);
                                if (fileInputStream3 == null) {
                                }
                            } catch (Throwable th8) {
                                th5 = th8;
                                fileInputStream3 = fileInputStream4;
                                if (fileInputStream3 == null) {
                                }
                            }
                        }
                        int read = fileInputStream.read(bArr2);
                        if (read > 0) {
                            j3 = read + j18;
                        } else {
                            j3 = j18;
                        }
                        if (read < 0) {
                            fileInputStream3 = fileInputStream;
                            break;
                        }
                        Item item3 = this.f301947d;
                        File file2 = file;
                        int length2 = item3.CheckKey.length + 2 + 2 + item3.Sha.length + 20 + read;
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length2 + 16);
                        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                        long j26 = j3;
                        try {
                            try {
                                dataOutputStream.writeInt(-1412589450);
                                dataOutputStream.writeInt(1007);
                                dataOutputStream.writeInt(0);
                                dataOutputStream.writeInt(length2);
                                dataOutputStream.writeShort(this.f301947d.CheckKey.length);
                                dataOutputStream.write(this.f301947d.CheckKey);
                                dataOutputStream.writeShort(this.f301947d.Sha.length);
                                dataOutputStream.write(this.f301947d.Sha);
                                dataOutputStream.writeInt((int) (this.f301947d.ProgressTotal & 4294967295L));
                                dataOutputStream.writeInt((int) (j18 & 4294967295L));
                                dataOutputStream.writeInt(read);
                                dataOutputStream.writeInt((int) (this.f301947d.ProgressTotal >> 32));
                                dataOutputStream.writeInt((int) (j18 >> 32));
                                dataOutputStream.write(bArr2, 0, read);
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                try {
                                    byteArrayOutputStream.close();
                                    dataOutputStream.close();
                                } catch (Exception unused2) {
                                }
                                if (z18) {
                                    format = String.format("http://%s/ftn_handler?range=%d-%d&bHost=%s&bPort=%d", list.get(0).f417211ip, Long.valueOf(j18), Long.valueOf(read + j18), this.f301947d.UploadIp, 80);
                                    bArr = byteArray;
                                } else {
                                    bArr = byteArray;
                                    format = String.format("http://%s/ftn_handler?range=%d-%d", this.f301947d.UploadIp, Long.valueOf(j18), Long.valueOf(read + j18));
                                }
                                this.f301947d.transferBeginTime = System.currentTimeMillis();
                                this.f301947d.uploadUrl = format;
                                a16 = httpClient2;
                                HttpResponse a17 = a(a16, format, bArr);
                                if (a17 == null) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("TroopFileTransferManager", 2, String.format("rsp = null", new Object[0]));
                                    }
                                    i18 = be.a.f302139z;
                                    z17 = z18;
                                    i16 = i16;
                                    file = file2;
                                    j19 = j26;
                                } else {
                                    int statusCode = a17.getStatusLine().getStatusCode();
                                    if (statusCode != 200 && statusCode != 206) {
                                        Header[] allHeaders = a17.getAllHeaders();
                                        if (allHeaders != null) {
                                            StringBuilder sb5 = new StringBuilder();
                                            int length3 = allHeaders.length;
                                            int i26 = 0;
                                            while (i26 < length3) {
                                                Header header = allHeaders[i26];
                                                sb5.append("[name:");
                                                sb5.append(header.getName());
                                                sb5.append(" value:");
                                                sb5.append(header.getValue());
                                                sb5.append("] ");
                                                i26++;
                                                j18 = j18;
                                            }
                                            j17 = j18;
                                            this.f301947d.rspHeadStr = sb5.toString();
                                        } else {
                                            j17 = j18;
                                        }
                                        firstHeader = a17.getFirstHeader(HttpMsg.USERRETURNCODE);
                                        if (firstHeader != null && firstHeader.getValue() != null) {
                                            if (firstHeader.getValue().equals("-6101")) {
                                                i3 = -6101;
                                                fileInputStream3 = fileInputStream;
                                                i16 = 4;
                                                break;
                                            } else {
                                                if (firstHeader.getValue().equals("-38006") || firstHeader.getValue().equals("-38007") || firstHeader.getValue().equals("-38020")) {
                                                    break;
                                                }
                                                try {
                                                    String value = firstHeader.getValue();
                                                    if (value != null && !TextUtils.isEmpty(value)) {
                                                        i18 = Integer.valueOf(value).intValue();
                                                    } else {
                                                        i18 = statusCode;
                                                    }
                                                    z17 = z18;
                                                } catch (NumberFormatException | Exception unused3) {
                                                }
                                                i16 = i16;
                                                file = file2;
                                                j19 = j26;
                                                j18 = j17;
                                            }
                                        }
                                        z17 = z18;
                                        i18 = statusCode;
                                        i16 = i16;
                                        file = file2;
                                        j19 = j26;
                                        j18 = j17;
                                    } else {
                                        long j27 = j18;
                                        TroopFileTransferManager.this.l0(0, r9.length);
                                        try {
                                            dataInputStream4 = new DataInputStream(a17.getEntity().getContent());
                                        } catch (IOException e47) {
                                            list2 = list;
                                            j16 = j26;
                                            iOException2 = e47;
                                            j18 = j27;
                                            dataInputStream3 = null;
                                        } catch (IllegalStateException e48) {
                                            list2 = list;
                                            j16 = j26;
                                            illegalStateException = e48;
                                            j18 = j27;
                                            dataInputStream2 = null;
                                        } catch (Throwable th9) {
                                            th6 = th9;
                                            dataInputStream = null;
                                        }
                                        try {
                                            try {
                                                dataInputStream4.skip(16L);
                                                if (dataInputStream4.readByte() != 0) {
                                                    try {
                                                        dataInputStream4.close();
                                                    } catch (IOException e49) {
                                                        e49.printStackTrace();
                                                    }
                                                    fileInputStream3 = fileInputStream;
                                                    i3 = statusCode;
                                                    i16 = 0;
                                                    break;
                                                }
                                                long readInt = dataInputStream4.readInt();
                                                list2 = list;
                                                long readInt2 = dataInputStream4.readInt();
                                                try {
                                                    a17.getEntity().consumeContent();
                                                    long j28 = (readInt2 << 32) | readInt;
                                                    try {
                                                        Item item4 = this.f301947d;
                                                        if (item4.ProgressValue <= j28) {
                                                            try {
                                                                item4.ProgressValue = j28;
                                                                item4.transferedSize = j28;
                                                                TroopFileTransferManager.this.X(item4);
                                                            } catch (IOException e56) {
                                                                e = e56;
                                                                dataInputStream3 = dataInputStream4;
                                                                j18 = j28;
                                                                j16 = j26;
                                                                iOException2 = e;
                                                                try {
                                                                    QLog.e("TroopFileTransferManager", 1, "upload file failed, io error", iOException2);
                                                                    i18 = be.a.f302139z;
                                                                    if (dataInputStream3 != null) {
                                                                    }
                                                                    z17 = z18;
                                                                    j19 = j16;
                                                                    i16 = i16;
                                                                    list = list2;
                                                                    file = file2;
                                                                    i17 = 16384;
                                                                    fileInputStream3 = fileInputStream;
                                                                } catch (Throwable th10) {
                                                                    dataInputStream = dataInputStream3;
                                                                    th6 = th10;
                                                                    if (dataInputStream == null) {
                                                                    }
                                                                }
                                                            } catch (IllegalStateException e57) {
                                                                e = e57;
                                                                dataInputStream2 = dataInputStream4;
                                                                j18 = j28;
                                                                j16 = j26;
                                                                illegalStateException = e;
                                                                QLog.e("TroopFileTransferManager", 1, "upload file failed", illegalStateException);
                                                                i18 = be.a.f302139z;
                                                                if (dataInputStream2 != null) {
                                                                }
                                                                z17 = z18;
                                                                j19 = j16;
                                                                i16 = i16;
                                                                list = list2;
                                                                file = file2;
                                                                i17 = 16384;
                                                                fileInputStream3 = fileInputStream;
                                                            }
                                                        }
                                                        if (j28 != j26 && QLog.isColorLevel()) {
                                                            StringBuilder sb6 = new StringBuilder();
                                                            sb6.append("serverProgressValue=");
                                                            sb6.append(j28);
                                                            sb6.append(",tempProgressValue");
                                                            j16 = j26;
                                                            try {
                                                                sb6.append(j16);
                                                                QLog.i("TroopFileTransferManager", 2, sb6.toString());
                                                            } catch (IOException e58) {
                                                                e = e58;
                                                                dataInputStream3 = dataInputStream4;
                                                                j18 = j28;
                                                                iOException2 = e;
                                                                QLog.e("TroopFileTransferManager", 1, "upload file failed, io error", iOException2);
                                                                i18 = be.a.f302139z;
                                                                if (dataInputStream3 != null) {
                                                                }
                                                                z17 = z18;
                                                                j19 = j16;
                                                                i16 = i16;
                                                                list = list2;
                                                                file = file2;
                                                                i17 = 16384;
                                                                fileInputStream3 = fileInputStream;
                                                            } catch (IllegalStateException e59) {
                                                                e = e59;
                                                                dataInputStream2 = dataInputStream4;
                                                                j18 = j28;
                                                                illegalStateException = e;
                                                                QLog.e("TroopFileTransferManager", 1, "upload file failed", illegalStateException);
                                                                i18 = be.a.f302139z;
                                                                if (dataInputStream2 != null) {
                                                                }
                                                                z17 = z18;
                                                                j19 = j16;
                                                                i16 = i16;
                                                                list = list2;
                                                                file = file2;
                                                                i17 = 16384;
                                                                fileInputStream3 = fileInputStream;
                                                            }
                                                        } else {
                                                            j16 = j26;
                                                        }
                                                        try {
                                                            dataInputStream4.close();
                                                        } catch (IOException e65) {
                                                            e65.printStackTrace();
                                                        }
                                                        fileInputStream3 = fileInputStream;
                                                        j18 = j28;
                                                        z17 = z18;
                                                        i18 = statusCode;
                                                        j19 = j16;
                                                        list = list2;
                                                        file = file2;
                                                        i16 = 0;
                                                        i17 = 16384;
                                                    } catch (IOException e66) {
                                                        e = e66;
                                                        j16 = j26;
                                                    } catch (IllegalStateException e67) {
                                                        e = e67;
                                                        j16 = j26;
                                                    }
                                                } catch (IOException e68) {
                                                    e = e68;
                                                    j16 = j26;
                                                    iOException2 = e;
                                                    dataInputStream3 = dataInputStream4;
                                                    j18 = j27;
                                                    QLog.e("TroopFileTransferManager", 1, "upload file failed, io error", iOException2);
                                                    i18 = be.a.f302139z;
                                                    if (dataInputStream3 != null) {
                                                        try {
                                                            dataInputStream3.close();
                                                        } catch (IOException e69) {
                                                            iOException3 = e69;
                                                            iOException3.printStackTrace();
                                                            z17 = z18;
                                                            j19 = j16;
                                                            i16 = i16;
                                                            list = list2;
                                                            file = file2;
                                                            i17 = 16384;
                                                            fileInputStream3 = fileInputStream;
                                                        }
                                                    }
                                                    z17 = z18;
                                                    j19 = j16;
                                                    i16 = i16;
                                                    list = list2;
                                                    file = file2;
                                                    i17 = 16384;
                                                    fileInputStream3 = fileInputStream;
                                                } catch (IllegalStateException e75) {
                                                    e = e75;
                                                    j16 = j26;
                                                    illegalStateException = e;
                                                    dataInputStream2 = dataInputStream4;
                                                    j18 = j27;
                                                    QLog.e("TroopFileTransferManager", 1, "upload file failed", illegalStateException);
                                                    i18 = be.a.f302139z;
                                                    if (dataInputStream2 != null) {
                                                        try {
                                                            dataInputStream2.close();
                                                        } catch (IOException e76) {
                                                            iOException3 = e76;
                                                            iOException3.printStackTrace();
                                                            z17 = z18;
                                                            j19 = j16;
                                                            i16 = i16;
                                                            list = list2;
                                                            file = file2;
                                                            i17 = 16384;
                                                            fileInputStream3 = fileInputStream;
                                                        }
                                                    }
                                                    z17 = z18;
                                                    j19 = j16;
                                                    i16 = i16;
                                                    list = list2;
                                                    file = file2;
                                                    i17 = 16384;
                                                    fileInputStream3 = fileInputStream;
                                                }
                                            } catch (IOException e77) {
                                                e = e77;
                                                list2 = list;
                                            } catch (IllegalStateException e78) {
                                                e = e78;
                                                list2 = list;
                                            }
                                        } catch (Throwable th11) {
                                            th6 = th11;
                                            dataInputStream = dataInputStream4;
                                            if (dataInputStream == null) {
                                                try {
                                                    dataInputStream.close();
                                                    throw th6;
                                                } catch (IOException e79) {
                                                    e79.printStackTrace();
                                                    throw th6;
                                                }
                                            }
                                            throw th6;
                                        }
                                    }
                                }
                                i17 = 16384;
                                fileInputStream3 = fileInputStream;
                            } catch (IOException e85) {
                                QLog.e("TroopFileTransferManager", 1, "upload file failed, writing failed!", e85);
                                TroopFileTransferManager.this.o0(this.f301947d, 3, 102);
                                be.g(be.a.f302115b, be.a.f302126m);
                                try {
                                    byteArrayOutputStream.close();
                                    dataOutputStream.close();
                                } catch (Exception unused4) {
                                }
                                try {
                                    fileInputStream.close();
                                    return;
                                } catch (IOException e86) {
                                    if (QLog.isColorLevel()) {
                                        QLog.i("TroopFileTransferManager", 2, "close uploadFileStream," + e86.toString(), e86);
                                        return;
                                    }
                                    return;
                                }
                            }
                        } finally {
                        }
                    } catch (Throwable th12) {
                        th5 = th12;
                        fileInputStream3 = fileInputStream;
                    }
                } catch (InterruptedException e87) {
                    interruptedException = e87;
                    fileInputStream3 = fileInputStream;
                }
            }
            TroopFileTransferManager.this.o0(this.f301947d, 3, 206);
            be.h(be.a.f302117d, Integer.valueOf(firstHeader.getValue()).intValue(), this.f301947d.UploadIp);
            try {
                fileInputStream.close();
            } catch (IOException e88) {
                if (QLog.isColorLevel()) {
                    QLog.i("TroopFileTransferManager", 2, "close uploadFileStream," + e88.toString(), e88);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class TaskPool {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public AtomicInteger f301951a;

        /* renamed from: b, reason: collision with root package name */
        public int f301952b;

        /* renamed from: c, reason: collision with root package name */
        public LinkedList<Task> f301953c;

        public TaskPool(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
                return;
            }
            this.f301951a = new AtomicInteger();
            this.f301953c = new LinkedList<>();
            this.f301952b = i3;
        }

        public synchronized void a(Task task) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) task);
                return;
            }
            this.f301953c.add(task);
            if (this.f301951a.incrementAndGet() > this.f301952b) {
                this.f301951a.decrementAndGet();
            } else {
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskPool.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TaskPool.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Task remove;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        while (true) {
                            synchronized (TaskPool.this) {
                                if (TaskPool.this.f301953c.isEmpty()) {
                                    TaskPool.this.f301951a.decrementAndGet();
                                    return;
                                }
                                remove = TaskPool.this.f301953c.remove(0);
                            }
                            remove.run();
                            if (remove.f301948e == 0) {
                                try {
                                    LockMethodProxy.sleep(200L);
                                } catch (InterruptedException unused) {
                                }
                            }
                        }
                    }
                }, 5, null, true);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class TaskScan extends Task {
        static IPatchRedirector $redirector_;

        public TaskScan(Item item) {
            super(item, 0);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopFileTransferManager.this, (Object) item);
            } else {
                TroopFileTransferManager.this.n0(item, 0);
                this.f301949f = true;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:47:0x020d, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x020e, code lost:
        
            r0.printStackTrace();
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0211, code lost:
        
            return;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            Item item;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (TroopFileTransferManager.this.Z(this.f301947d)) {
                return;
            }
            be.f();
            Item item2 = this.f301947d;
            if (item2.DigestMd5 == null) {
                item2.ScanPos = 0L;
                try {
                    item2.DigestMd5 = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                    this.f301947d.DigestSha = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA1);
                } catch (NoSuchAlgorithmException e16) {
                    QLog.e("TroopFileTransferManager", 1, "task scan: get MessageDigest instance failed!", e16);
                    TroopFileTransferManager.this.o0(this.f301947d, 3, 102);
                    be.g(be.a.f302115b, be.a.f302132s);
                    return;
                }
            }
            File file = new File(this.f301947d.LocalFile);
            if (file.exists() && file.isFile() && file.length() > 0) {
                this.f301947d.ProgressTotal = file.length();
            }
            if (QLog.isColorLevel()) {
                QLog.d("TroopFileTransferManager", 2, "TaskScan - item.LocalFile:" + this.f301947d.LocalFile + ", file.exist():" + file.exists() + ", file.length():" + file.length());
            }
            TroopFileTransferManager.this.X(this.f301947d);
            Item item3 = this.f301947d;
            if (item3.ProgressTotal > 4294967296L) {
                TroopFileTransferManager.this.o0(item3, 3, 205);
                be.g(be.a.f302115b, be.a.f302118e);
                return;
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    try {
                        fileInputStream.skip(this.f301947d.ScanPos);
                        byte[] bArr = new byte[32768];
                        do {
                            int read = fileInputStream.read(bArr);
                            if (read < 0) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e17) {
                                    e17.printStackTrace();
                                }
                                Item item4 = this.f301947d;
                                item4.Md5 = item4.DigestMd5.digest();
                                Item item5 = this.f301947d;
                                item5.Sha = item5.DigestSha.digest();
                                Item item6 = this.f301947d;
                                item6.Sha3 = HexUtil.bytes2HexStr(FileManagerUtil.get3SHA(item6.LocalFile));
                                HexUtil.bytes2HexStr(FileManagerUtil.getSha3(this.f301947d.LocalFile));
                                Item item7 = this.f301947d;
                                item7.DigestMd5 = null;
                                item7.DigestSha = null;
                                if (FileManagerUtil.getFileType(item7.LocalFile) == 0) {
                                    try {
                                        BitmapFactory.Options options = new BitmapFactory.Options();
                                        options.inJustDecodeBounds = true;
                                        BaseImageUtil.decodeFileWithBufferedStream(this.f301947d.LocalFile, options);
                                        Item item8 = this.f301947d;
                                        item8.width = options.outWidth;
                                        item8.height = options.outHeight;
                                    } catch (Exception unused) {
                                    }
                                } else if (FileManagerUtil.getFileType(this.f301947d.LocalFile) == 2) {
                                    int[] videoFileRtAndTime = ShortVideoUtils.getVideoFileRtAndTime(this.f301947d.LocalFile);
                                    Item item9 = this.f301947d;
                                    item9.width = videoFileRtAndTime[0];
                                    item9.height = videoFileRtAndTime[1];
                                    item9.duration = videoFileRtAndTime[2];
                                }
                                if (TroopFileTransferManager.this.Z(this.f301947d)) {
                                    return;
                                }
                                QLog.i("TroopFileTransferManager", 1, "<TroopFile> on scan end. md5:" + HexUtil.bytes2HexStr(this.f301947d.Md5) + " sha1:" + HexUtil.bytes2HexStr(this.f301947d.Sha) + " sha3:" + this.f301947d.Sha3 + " mWith:" + this.f301947d.width + " mHeight:" + this.f301947d.height + " mDuration:" + this.f301947d.duration);
                                TroopFileTransferManager.this.X(this.f301947d);
                                TroopFileTransferManager.this.z(this.f301947d);
                                return;
                            }
                            this.f301947d.DigestMd5.update(bArr, 0, read);
                            this.f301947d.DigestSha.update(bArr, 0, read);
                            item = this.f301947d;
                            item.ScanPos += read;
                        } while (!TroopFileTransferManager.this.Z(item));
                        fileInputStream.close();
                    } catch (IOException e18) {
                        e18.printStackTrace();
                        TroopFileTransferManager.this.o0(this.f301947d, 3, 203);
                        be.g(be.a.f302115b, be.a.f302123j);
                        try {
                            fileInputStream.close();
                        } catch (IOException e19) {
                            e19.printStackTrace();
                        }
                    }
                } catch (Throwable th5) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e26) {
                        e26.printStackTrace();
                    }
                    throw th5;
                }
            } catch (FileNotFoundException e27) {
                QLog.e("TroopFileTransferManager", 1, "task scan: read uplad file failed!", e27);
                TroopFileTransferManager.this.o0(this.f301947d, 3, 201);
                be.g(be.a.f302115b, be.a.f302120g);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends ef0.i {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopFileTransferManager.this);
            }
        }

        @Override // ef0.i
        protected void c(boolean z16, int i3, group_file_common$FileInfo group_file_common_fileinfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), group_file_common_fileinfo);
                return;
            }
            if (z16 && group_file_common_fileinfo != null) {
                String str = group_file_common_fileinfo.str_file_id.get();
                if (!str.startsWith("/")) {
                    str = "/" + str;
                }
                com.tencent.mobileqq.troop.data.n A = TroopFileTransferManager.this.M().A(str);
                if (A != null) {
                    A.f294919e = group_file_common_fileinfo.uint32_bus_id.get();
                    A.f294923i = (int) ((System.currentTimeMillis() / 1000) + group_file_common_fileinfo.uint32_dead_time.get());
                }
                TroopFileTransferManager.this.M().O(A);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class b extends ef0.l {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopFileTransferManager.this);
            }
        }

        @Override // ef0.l
        public void c(boolean z16, int i3, int i16, String str, String str2, String str3, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), str, str2, str3, bundle);
                return;
            }
            long j3 = bundle.getLong("troopUin");
            synchronized (TroopFileTransferManager.class) {
                TroopFileTransferManager troopFileTransferManager = (TroopFileTransferManager) TroopFileTransferManager.P.get(Long.valueOf(j3));
                if (troopFileTransferManager == null) {
                    if (QLog.isDevelopLevel()) {
                        QLog.i("TroopFileTransferManager", 4, "bad troopUin" + j3);
                    }
                    return;
                }
                String string = bundle.getString("itemKey");
                if (string == null) {
                    return;
                }
                UUID fromString = UUID.fromString(string);
                synchronized (troopFileTransferManager) {
                    Item item = troopFileTransferManager.L.get(fromString);
                    if (item == null) {
                        if (QLog.isDevelopLevel()) {
                            QLog.i("TroopFileTransferManager", 4, "bad item key" + string);
                        }
                        return;
                    }
                    if (!z16) {
                        return;
                    }
                    if (QLog.isDevelopLevel()) {
                        QLog.e("TroopFileTransferManager", 4, String.format("onCopyToResult - retCode: %d", Integer.valueOf(i3)));
                    }
                    if (item.BusId == 25) {
                        synchronized (troopFileTransferManager) {
                            ((IWeiyunResponseHandler) QRoute.api(IWeiyunResponseHandler.class)).endSave2Weiyun(i3);
                            if (i3 == 0) {
                                TroopFileTransferManager.this.M.remove(fromString);
                            } else {
                                TroopFileTransferManager.this.M.put(fromString, Integer.valueOf(i3));
                            }
                            if (TroopFileTransferManager.this.M.size() == 0) {
                                TroopFileTransferManager.this.p0(item, 5, new TroopFileError.b(item.FileName, TroopFileTransferManager.this.K, 5, 604));
                            } else {
                                Iterator<UUID> it = TroopFileTransferManager.this.M.keySet().iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    } else if (TroopFileTransferManager.this.M.get(it.next()).intValue() == Integer.MAX_VALUE) {
                                        z17 = false;
                                        break;
                                    }
                                }
                                if (z17) {
                                    TroopFileTransferManager.this.p0(item, 5, new TroopFileError.b(item.FileName, TroopFileTransferManager.this.K, 5, 605));
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface c {
        void onResult(int i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        int f301956a;

        /* renamed from: b, reason: collision with root package name */
        String f301957b;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopFileTransferManager.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public boolean f301959a;

        /* renamed from: b, reason: collision with root package name */
        public String f301960b;

        /* renamed from: c, reason: collision with root package name */
        public String f301961c;

        /* renamed from: d, reason: collision with root package name */
        public String f301962d;

        /* renamed from: e, reason: collision with root package name */
        public String f301963e;

        /* renamed from: f, reason: collision with root package name */
        public int f301964f;

        /* renamed from: g, reason: collision with root package name */
        public String f301965g;

        /* renamed from: h, reason: collision with root package name */
        public String f301966h;

        /* renamed from: i, reason: collision with root package name */
        public short f301967i;

        public e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f301967i = (short) 0;
            }
        }
    }

    public TroopFileTransferManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f301931f = new ef0.p() { // from class: com.tencent.mobileqq.troop.utils.TroopFileTransferManager.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopFileTransferManager.this);
                }
            }

            @Override // ef0.p
            public void c(boolean z16, int i3, oidb_0x6d6$UploadFileRspBody oidb_0x6d6_uploadfilerspbody, Bundle bundle) {
                int i16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), oidb_0x6d6_uploadfilerspbody, bundle);
                    return;
                }
                long j3 = bundle.getLong("troopUin");
                synchronized (TroopFileTransferManager.class) {
                    TroopFileTransferManager troopFileTransferManager = (TroopFileTransferManager) TroopFileTransferManager.P.get(Long.valueOf(j3));
                    if (troopFileTransferManager == null) {
                        if (QLog.isDevelopLevel()) {
                            QLog.i("TroopFileTransferManager", 4, "bad troopUin" + j3);
                        }
                        return;
                    }
                    String string = bundle.getString("itemKey");
                    if (string == null) {
                        return;
                    }
                    UUID fromString = UUID.fromString(string);
                    synchronized (troopFileTransferManager) {
                        Item item = troopFileTransferManager.L.get(fromString);
                        if (item == null) {
                            if (QLog.isDevelopLevel()) {
                                QLog.i("TroopFileTransferManager", 4, "bad item key" + string);
                            }
                            be.g(be.a.f302115b, be.a.f302131r);
                            return;
                        }
                        if (!z16) {
                            ReportController.o(this.mApp.get(), "P_CliOper", "Grp_files", "", "file", "fail_upload", 0, 0, j3 + "", "", "", "");
                            TroopFileTransferManager.this.p0(item, 3, new TroopFileError.b(item.FileName, TroopFileTransferManager.this.K, 3, 207));
                            if (QLog.isDevelopLevel()) {
                                QLog.w("TroopFileTransferManager", 2, "onReqResendFileResult,errCode=" + i3);
                            }
                            be.g(be.a.f302115b, be.a.A);
                            return;
                        }
                        int i17 = oidb_0x6d6_uploadfilerspbody.int32_ret_code.get();
                        if (QLog.isDevelopLevel()) {
                            QLog.e("TroopFileTransferManager", 4, String.format("onRspUpload - retCode: %d", Integer.valueOf(i17)));
                        }
                        if (i17 < 0) {
                            if (i17 != -25126) {
                                i16 = -136;
                                if (i17 != -312 && i17 != -136) {
                                    if (i17 != -134) {
                                        if (i17 != -107 && i17 != -102) {
                                            if (i17 != -36) {
                                                if (i17 != -20001 && i17 != -20000 && i17 != -403) {
                                                    if (i17 != -402) {
                                                        i16 = -138;
                                                        if (i17 != -139 && i17 != -138) {
                                                            if (i17 != -2) {
                                                                if (i17 != -1) {
                                                                    i16 = 207;
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        TroopFileTransferManager.this.p0(item, 3, new TroopFileError.b(item.FileName, TroopFileTransferManager.this.K, 3, 704, oidb_0x6d6_uploadfilerspbody.str_client_wording.get()));
                                                        return;
                                                    }
                                                } else {
                                                    if (item.BusId != 104) {
                                                        item.BusId = 104;
                                                        TroopFileTransferManager.this.z(item);
                                                        return;
                                                    }
                                                    i16 = 204;
                                                }
                                            } else {
                                                new Handler(Looper.getMainLooper()).postDelayed(new Runnable(item) { // from class: com.tencent.mobileqq.troop.utils.TroopFileTransferManager.3.1
                                                    static IPatchRedirector $redirector_;

                                                    /* renamed from: d, reason: collision with root package name */
                                                    final /* synthetic */ Item f301938d;

                                                    {
                                                        this.f301938d = item;
                                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this, (Object) item);
                                                        }
                                                    }

                                                    @Override // java.lang.Runnable
                                                    public void run() {
                                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                                            iPatchRedirector3.redirect((short) 2, (Object) this);
                                                        } else {
                                                            TroopFileTransferManager.this.p0(this.f301938d, 3, new TroopFileError.b(this.f301938d.FileName, TroopFileTransferManager.this.K, 3, 210));
                                                        }
                                                    }
                                                }, 1000L);
                                                return;
                                            }
                                        }
                                        i16 = 208;
                                    }
                                    i16 = 202;
                                }
                            } else {
                                i16 = 209;
                            }
                            TroopFileTransferManager.this.p0(item, 3, new TroopFileError.b(item.FileName, TroopFileTransferManager.this.K, 3, i16));
                            be.g(be.a.f302116c, i17);
                            return;
                        }
                        item.FilePath = oidb_0x6d6_uploadfilerspbody.str_file_id.get();
                        item.UploadIp = oidb_0x6d6_uploadfilerspbody.str_upload_ip.get();
                        item.CheckKey = oidb_0x6d6_uploadfilerspbody.bytes_check_key.get().toByteArray();
                        item.BusId = oidb_0x6d6_uploadfilerspbody.uint32_bus_id.get();
                        if (!TroopFileTransferManager.this.Z(item)) {
                            TroopFileTransferManager troopFileTransferManager2 = TroopFileTransferManager.this;
                            troopFileTransferManager2.I[2].a(new TaskHttpUpload(item));
                        }
                    }
                }
            }
        };
        this.f301932h = 0L;
        this.f301933i = 0L;
        this.f301934m = 0L;
        this.C = 0L;
        this.D = new ef0.n() { // from class: com.tencent.mobileqq.troop.utils.TroopFileTransferManager.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopFileTransferManager.this);
                }
            }

            @Override // ef0.n
            public void c(boolean z16, int i3, String str, int i16, int i17, Bundle bundle) {
                String string;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), str, Integer.valueOf(i16), Integer.valueOf(i17), bundle);
                    return;
                }
                if (!z16 || (string = bundle.getString("itemKey")) == null) {
                    return;
                }
                UUID fromString = UUID.fromString(string);
                String string2 = bundle.getString("fileId");
                com.tencent.mobileqq.troop.data.n nVar = TroopFileTransferManager.this.M().f301892d.get(fromString);
                if (nVar != null && i3 == 0) {
                    TroopFileTransferManager troopFileTransferManager = TroopFileTransferManager.this;
                    com.tencent.biz.troop.file.a.m(troopFileTransferManager.J, troopFileTransferManager.K, nVar.f294919e, nVar.f294916b, troopFileTransferManager.E);
                    ThreadManagerV2.executeOnSubThread(new Runnable(string2, nVar) { // from class: com.tencent.mobileqq.troop.utils.TroopFileTransferManager.4.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ String f301941d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ com.tencent.mobileqq.troop.data.n f301942e;

                        {
                            this.f301941d = string2;
                            this.f301942e = nVar;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, this, AnonymousClass4.this, string2, nVar);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            String str2;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            String str3 = this.f301941d;
                            if (!TextUtils.isEmpty(this.f301942e.f294916b)) {
                                str3 = this.f301942e.f294916b;
                            }
                            MessageForTroopFile messageForTroopFile = (MessageForTroopFile) com.tencent.mobileqq.filemanager.fileviewer.c.w(TroopFileTransferManager.this.J.getMessageFacade(), String.valueOf(TroopFileTransferManager.this.K), 1, str3);
                            if (messageForTroopFile != null) {
                                str2 = messageForTroopFile.fileName;
                            } else {
                                str2 = "";
                            }
                            long docsImportFileMaxSize = FileManagerUtil.getDocsImportFileMaxSize(str2);
                            if (messageForTroopFile != null && messageForTroopFile.fileSize <= docsImportFileMaxSize) {
                                ((AIOMessageSpreadManager) TroopFileTransferManager.this.J.getManager(QQManagerFactory.TEAMWORK_SPREAD_MANAGER)).n(messageForTroopFile);
                                return;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.e("AIOMessageSpreadManager", 1, "can't find troopFile Msg, troop[" + TroopFileTransferManager.this.K + "], id:" + this.f301942e.f294916b);
                            }
                        }
                    });
                }
            }
        };
        this.E = new a();
        this.F = new b();
        this.G = new ef0.l() { // from class: com.tencent.mobileqq.troop.utils.TroopFileTransferManager.7
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopFileTransferManager.this);
                }
            }

            private final synchronized void e(Item item, int i3, int i16, String str, String str2, String str3, long j3) {
                if (QLog.isDevelopLevel()) {
                    QLog.e("TroopFileTransferManager", 4, String.format("onRspCopyToOffline -fileName: %s ,- retCode: %d, -retMsg: %s", item.FileName, Integer.valueOf(i3), str2));
                }
                if (i3 != 0) {
                    com.tencent.mobileqq.filemanager.util.w wVar = item.mForwardCallback;
                    if (wVar != null) {
                        wVar.e(false, j3, i3, str3, item.Id.toString(), String.valueOf(item.ForwardTroopuin), "");
                    }
                } else {
                    com.tencent.mobileqq.filemanager.util.w wVar2 = item.mForwardCallback;
                    if (wVar2 != null) {
                        wVar2.e(true, j3, i3, "", item.Id.toString(), String.valueOf(item.ForwardTroopuin), str);
                    }
                }
            }

            @Override // ef0.l
            public void c(boolean z16, int i3, int i16, String str, String str2, String str3, Bundle bundle) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), str, str2, str3, bundle);
                    return;
                }
                long j3 = bundle.getLong("troopUin");
                synchronized (TroopFileTransferManager.class) {
                    TroopFileTransferManager troopFileTransferManager = (TroopFileTransferManager) TroopFileTransferManager.P.get(Long.valueOf(j3));
                    if (troopFileTransferManager == null) {
                        if (QLog.isDevelopLevel()) {
                            QLog.i("TroopFileTransferManager", 4, "bad troopUin" + j3);
                        }
                        return;
                    }
                    String string = bundle.getString("itemKey");
                    if (string == null) {
                        return;
                    }
                    UUID fromString = UUID.fromString(string);
                    synchronized (troopFileTransferManager) {
                        Item item = troopFileTransferManager.L.get(fromString);
                        if (item == null) {
                            if (QLog.isDevelopLevel()) {
                                QLog.i("TroopFileTransferManager", 4, "bad item key" + string);
                            }
                            return;
                        }
                        if (QLog.isDevelopLevel()) {
                            QLog.e("TroopFileTransferManager", 4, String.format("onCopyToResult - retCode: %d", Integer.valueOf(i3)));
                        }
                        int i17 = item.BusId;
                        if (i17 == 25) {
                            f(item, i3, i16, str, str2, str3);
                            return;
                        }
                        if (i17 != 102 && i17 != 104) {
                            if (i17 == 3 || i17 == 106 || i17 == 38) {
                                e(item, i3, i16, str, str2, str3, bundle.getLong("sessionId"));
                                return;
                            }
                            return;
                        }
                        d(item, i3, i16, str, str2, str3);
                    }
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:47:0x0114 A[Catch: all -> 0x0176, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x0012, B:8:0x0019, B:12:0x0038, B:14:0x003e, B:45:0x00f4, B:47:0x0114, B:52:0x0098, B:53:0x00a3, B:55:0x00ab, B:57:0x00b8, B:61:0x00d2, B:63:0x00d6, B:67:0x0139, B:69:0x0156, B:70:0x0158, B:72:0x0168, B:73:0x016a), top: B:3:0x0009 }] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final synchronized void d(Item item, int i3, int i16, String str, String str2, String str3) {
                int i17;
                String str4;
                FileManagerEntity D;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, this, item, Integer.valueOf(i3), Integer.valueOf(i16), str, str2, str3);
                    return;
                }
                if (QLog.isDevelopLevel()) {
                    QLog.e("TroopFileTransferManager", 4, String.format("onRspCopyToGroup - retCode: %d", Integer.valueOf(i3)));
                }
                if (i3 < 0) {
                    if (i3 != -20001 && i3 != -20000) {
                        if (i3 != -6101) {
                            if (i3 != -403) {
                                if (i3 != -36) {
                                    if (i3 != -30) {
                                        if (i3 != -25 && i3 != -22) {
                                            i17 = -139;
                                            if (i3 != -139 && i3 != -138) {
                                                i17 = i3 != -4 ? i3 != -3 ? 207 : 202 : 600;
                                            }
                                        } else {
                                            i17 = 701;
                                        }
                                    } else {
                                        i17 = 705;
                                    }
                                } else {
                                    i17 = 706;
                                    str4 = HardCodeUtil.qqStr(R.string.uem);
                                    TroopFileTransferManager.this.p0(item, 5, new TroopFileError.b(item.FileName, item.ForwardTroopuin, 5, i17, str4));
                                    D = TroopFileTransferManager.this.J.getFileManagerDataCenter().D(item.entrySessionID);
                                    if (D != null) {
                                        long j3 = D.structMsgSeq;
                                        TroopFileTransferManager.this.J.getMessageFacade().T1("" + TroopFileTransferManager.this.K, 1, j3);
                                    }
                                    return;
                                }
                            }
                        } else {
                            if (!TextUtils.isEmpty(item.LocalFile) && new File(item.LocalFile).exists()) {
                                TroopFileTransferManager.this.n0(item, 0);
                                item.BusId = 102;
                                TroopFileTransferManager troopFileTransferManager = TroopFileTransferManager.this;
                                troopFileTransferManager.I[0].a(new TaskScan(item));
                                return;
                            }
                            i17 = 603;
                        }
                        str4 = str3;
                        TroopFileTransferManager.this.p0(item, 5, new TroopFileError.b(item.FileName, item.ForwardTroopuin, 5, i17, str4));
                        D = TroopFileTransferManager.this.J.getFileManagerDataCenter().D(item.entrySessionID);
                        if (D != null) {
                        }
                        return;
                    }
                    if (item.BusId == 102) {
                        item.BusId = 104;
                        TroopFileTransferManager troopFileTransferManager2 = TroopFileTransferManager.this;
                        QQAppInterface qQAppInterface = troopFileTransferManager2.J;
                        long j16 = troopFileTransferManager2.K;
                        com.tencent.biz.troop.file.a.p(qQAppInterface, false, j16, item, j16, 0L, troopFileTransferManager2.G);
                        return;
                    }
                    i17 = 204;
                    str4 = str3;
                    TroopFileTransferManager.this.p0(item, 5, new TroopFileError.b(item.FileName, item.ForwardTroopuin, 5, i17, str4));
                    D = TroopFileTransferManager.this.J.getFileManagerDataCenter().D(item.entrySessionID);
                    if (D != null) {
                    }
                    return;
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.troop.utils.TroopFileTransferManager.7.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass7.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                        } else {
                            QQToast.makeText(BaseApplicationImpl.sApplication, HardCodeUtil.qqStr(R.string.uef), 0).show(BaseApplicationImpl.sApplication.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                        }
                    }
                });
                item.FilePath = str;
                com.tencent.mobileqq.troop.data.t info = item.getInfo(TroopFileTransferManager.this.K);
                if (info != null) {
                    info.f294985s = str;
                }
                FileManagerEntity D2 = TroopFileTransferManager.this.J.getFileManagerDataCenter().D(item.entrySessionID);
                if (D2 != null) {
                    D2.strTroopFilePath = str;
                }
                TroopFileTransferManager.this.o0(item, 7, 0);
                TroopFileTransferManager.this.y(item);
            }

            public final synchronized void f(Item item, int i3, int i16, String str, String str2, String str3) {
                int i17;
                int i18;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, this, item, Integer.valueOf(i3), Integer.valueOf(i16), str, str2, str3);
                    return;
                }
                if (QLog.isDevelopLevel()) {
                    QLog.e("TroopFileTransferManager", 4, String.format("onRspCopyToWeiyun - retCode: %d", Integer.valueOf(i3)));
                }
                ((IWeiyunResponseHandler) QRoute.api(IWeiyunResponseHandler.class)).endSave2Weiyun(i3);
                if (i3 != 0) {
                    if (i3 != -20001 && i3 != -20000) {
                        if (i3 != -6101) {
                            if (i3 != -403) {
                                if (i3 != -30) {
                                    if (i3 != -25 && i3 != -22) {
                                        if (i3 != -3) {
                                            if (i3 != 1053) {
                                                if (i3 == 1054 && !TextUtils.isEmpty(str3)) {
                                                    i18 = 704;
                                                }
                                                i18 = 601;
                                            }
                                            i17 = 702;
                                            TroopFileTransferManager.this.p0(item, 5, new TroopFileError.b(item.FileName, TroopFileTransferManager.this.K, 5, i17, str3));
                                            return;
                                        }
                                        i18 = 202;
                                    } else {
                                        i18 = 701;
                                    }
                                } else {
                                    i18 = 705;
                                }
                            }
                        } else {
                            i18 = 703;
                        }
                        i17 = i18;
                        TroopFileTransferManager.this.p0(item, 5, new TroopFileError.b(item.FileName, TroopFileTransferManager.this.K, 5, i17, str3));
                        return;
                    }
                    if (item.BusId == 102) {
                        item.BusId = 104;
                        TroopFileTransferManager troopFileTransferManager = TroopFileTransferManager.this;
                        QQAppInterface qQAppInterface = troopFileTransferManager.J;
                        long j3 = troopFileTransferManager.K;
                        com.tencent.biz.troop.file.a.p(qQAppInterface, false, j3, item, j3, 0L, troopFileTransferManager.G);
                        return;
                    }
                    i17 = 702;
                    TroopFileTransferManager.this.p0(item, 5, new TroopFileError.b(item.FileName, TroopFileTransferManager.this.K, 5, i17, str3));
                    return;
                }
                TroopFileTransferManager.this.p0(item, 5, new TroopFileError.b(item.FileName, TroopFileTransferManager.this.K, 5, 602));
            }
        };
        this.I = new TaskPool[]{new TaskPool(1), new TaskPool(1), new TaskPool(2), new TaskPool(2), new TaskPool(2)};
        this.N = false;
    }

    public static TroopFileTransferManager N(long j3) {
        TroopFileTransferManager troopFileTransferManager;
        synchronized (TroopFileTransferManager.class) {
            troopFileTransferManager = P.get(Long.valueOf(j3));
        }
        return troopFileTransferManager;
    }

    public static TroopFileTransferManager O(QQAppInterface qQAppInterface, long j3) {
        TroopFileTransferManager troopFileTransferManager;
        synchronized (TroopFileTransferManager.class) {
            if (P == null) {
                P = new HashMap();
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.utils.TroopFileTransferManager.1
                    static IPatchRedirector $redirector_;

                    /* compiled from: P */
                    /* renamed from: com.tencent.mobileqq.troop.utils.TroopFileTransferManager$1$a */
                    /* loaded from: classes19.dex */
                    class a implements FilenameFilter {
                        static IPatchRedirector $redirector_;

                        a() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // java.io.FilenameFilter
                        public boolean accept(File file, String str) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) file, (Object) str)).booleanValue();
                            }
                            if (str == null) {
                                return false;
                            }
                            return str.startsWith(Item.ThumbnailFilePrefix);
                        }
                    }

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        File[] listFiles;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        try {
                            LockMethodProxy.sleep(3000L);
                            File file = new File(AppConstants.SDCARD_FILE_SAVE_TROOPTMP_PATH);
                            if (!file.isDirectory() || (listFiles = file.listFiles(new a())) == null || listFiles.length < 100) {
                                return;
                            }
                            ArrayList arrayList = new ArrayList(listFiles.length);
                            for (File file2 : listFiles) {
                                arrayList.add(Long.valueOf(file2.lastModified()));
                            }
                            Collections.sort(arrayList);
                            long longValue = ((Long) arrayList.get(arrayList.size() - 100)).longValue();
                            for (File file3 : listFiles) {
                                if (file3.lastModified() < longValue) {
                                    file3.deleteOnExit();
                                }
                            }
                        } catch (InterruptedException e16) {
                            e16.printStackTrace();
                        }
                    }
                }, 2, null, true);
            }
            ah.c(qQAppInterface);
            troopFileTransferManager = P.get(Long.valueOf(j3));
            if (troopFileTransferManager != null && troopFileTransferManager.J != qQAppInterface) {
                troopFileTransferManager.a0();
                troopFileTransferManager = null;
            }
            if (troopFileTransferManager == null) {
                troopFileTransferManager = new TroopFileTransferMgr(qQAppInterface, j3);
                troopFileTransferManager.S();
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.utils.TroopFileTransferManager.2
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopFileTransferManager.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            if (TroopFileTransferManager.this.q()) {
                                return;
                            }
                            TroopFileTransferManager.this.U();
                        }
                    }
                }, 8, null, true);
                P.put(Long.valueOf(j3), troopFileTransferManager);
            }
        }
        return troopFileTransferManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void T(String str) {
        new File(str).delete();
    }

    public static void W() {
        synchronized (TroopFileTransferManager.class) {
            Iterator<TroopFileTransferManager> it = P.values().iterator();
            while (it.hasNext()) {
                it.next().m();
            }
        }
    }

    public static void h0(long j3) {
        synchronized (TroopFileTransferManager.class) {
            for (TroopFileTransferManager troopFileTransferManager : P.values()) {
                if (troopFileTransferManager.K == j3) {
                    troopFileTransferManager.n();
                } else {
                    troopFileTransferManager.m();
                }
            }
        }
    }

    public static void j() {
        if (QLog.isColorLevel()) {
            QLog.d("TroopFileTransferManager", 2, "TroopFileTransferManager.ReleaseAll called!");
        }
        synchronized (TroopFileTransferManager.class) {
            Map<Long, TroopFileTransferManager> map = P;
            if (map == null) {
                return;
            }
            Iterator<TroopFileTransferManager> it = map.values().iterator();
            while (it.hasNext()) {
                it.next().a0();
            }
            P.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void l0(int i3, long j3) {
        if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1) {
            if (i3 == 0) {
                this.f301933i += j3;
            } else if (i3 == 1) {
                this.f301932h += j3;
            }
        } else {
            if (i3 == 0) {
                this.C += j3;
            } else if (i3 == 1) {
                this.f301934m += j3;
            }
            k0();
        }
    }

    private final void m0(Item item) {
        item.ErrorCode = 0;
        n0(item, 12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.utils.ag
            @Override // java.lang.Runnable
            public final void run() {
                TroopFileTransferManager.T(str);
            }
        }, 64, null, false);
    }

    public boolean A(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 37)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 37, this, str, str2, Integer.valueOf(i3))).booleanValue();
    }

    public com.tencent.mobileqq.troop.data.t A0(String str, boolean z16, int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (com.tencent.mobileqq.troop.data.t) iPatchRedirector.redirect((short) 23, this, str, Boolean.valueOf(z16), Integer.valueOf(i3), bundle);
        }
        return null;
    }

    public boolean B(UUID uuid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Boolean) iPatchRedirector.redirect((short) 38, (Object) this, (Object) uuid)).booleanValue();
        }
        return false;
    }

    public void B0(Collection<String> collection, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, collection, Boolean.valueOf(z16));
        }
    }

    public boolean C(String str, String str2, int i3, int i16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 35)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 35, this, str, str2, Integer.valueOf(i3), Integer.valueOf(i16), bundle)).booleanValue();
    }

    public synchronized boolean C0(UUID uuid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Boolean) iPatchRedirector.redirect((short) 42, (Object) this, (Object) uuid)).booleanValue();
        }
        return false;
    }

    public boolean D(UUID uuid, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Boolean) iPatchRedirector.redirect((short) 36, (Object) this, (Object) uuid, i3)).booleanValue();
        }
        return false;
    }

    public synchronized boolean D0(UUID uuid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, (Object) uuid)).booleanValue();
        }
        return false;
    }

    public boolean E(long j3, UUID uuid, String str, int i3, String str2, String str3) {
        TroopFileError.b bVar;
        int i16;
        TroopFileError.b bVar2;
        String str4 = str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return ((Boolean) iPatchRedirector.redirect((short) 53, this, Long.valueOf(j3), uuid, str, Integer.valueOf(i3), str4, str3)).booleanValue();
        }
        TroopFileManager M = M();
        synchronized (M) {
            synchronized (this) {
                if (!TextUtils.isEmpty(str2) && !str4.startsWith("/")) {
                    str4 = "/" + str4;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("TroopFileTransferManager", 2, String.format("finishCopyFrom - sessionId: %s, UUID: %s retCode: %d strNewPath:%s strErrorMsg:%s", j3 + "", uuid != null ? uuid.toString() : "", Integer.valueOf(i3), str4, str3));
                }
                com.tencent.mobileqq.troop.data.n B = uuid != null ? M.B(uuid) : null;
                if (str != null) {
                    B = M.A(str);
                }
                if (B == null) {
                    return false;
                }
                U();
                Item item = this.L.get(B.f294915a);
                if (item == null) {
                    return false;
                }
                if (item.Status != 4) {
                    return false;
                }
                if (i3 >= 0) {
                    if (TextUtils.isEmpty(str4)) {
                        if (TextUtils.isEmpty(str3)) {
                            bVar = new TroopFileError.b(item.FileName, this.K, 5, 207);
                        } else {
                            bVar = new TroopFileError.b(item.FileName, this.K, 5, 704, str3);
                        }
                        p0(item, 5, bVar);
                        return true;
                    }
                    B.f294916b = str4;
                    item.FilePath = str4;
                    com.tencent.mobileqq.troop.data.t info = item.getInfo(this.K);
                    if (info != null) {
                        info.f294985s = str4;
                    }
                    FileManagerEntity D = this.J.getFileManagerDataCenter().D(item.entrySessionID);
                    if (D != null) {
                        D.strTroopFilePath = str4;
                        String imageUrl = FileManagerUtil.getImageUrl(D);
                        D.strQRUrl = imageUrl;
                        item.strQRUrl = imageUrl;
                    }
                    TroopFileManager troopFileManager = this.f301929d;
                    if (troopFileManager != null) {
                        troopFileManager.R(B.f294916b, B);
                    }
                    o0(item, 6, 0);
                    return true;
                }
                if (i3 != -25087) {
                    if (i3 != -6101) {
                        if (i3 != -403) {
                            if (i3 == -36) {
                                new Handler(Looper.getMainLooper()).postDelayed(new Runnable(item) { // from class: com.tencent.mobileqq.troop.utils.TroopFileTransferManager.8
                                    static IPatchRedirector $redirector_;

                                    /* renamed from: d, reason: collision with root package name */
                                    final /* synthetic */ Item f301946d;

                                    {
                                        this.f301946d = item;
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopFileTransferManager.this, (Object) item);
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                            iPatchRedirector2.redirect((short) 2, (Object) this);
                                        } else {
                                            TroopFileTransferManager.this.o0(this.f301946d, 5, 706);
                                        }
                                    }
                                }, 1000L);
                                return true;
                            }
                            if (i3 == -30) {
                                i16 = 705;
                            } else if (i3 == -25 || i3 == -22) {
                                i16 = 701;
                            } else if (i3 != -20001 && i3 != -20000) {
                                if (i3 == -4) {
                                    i16 = 600;
                                } else if (i3 != -3) {
                                    if (TextUtils.isEmpty(str4)) {
                                        if (TextUtils.isEmpty(str3)) {
                                            bVar2 = new TroopFileError.b(item.FileName, this.K, 5, 207);
                                        } else {
                                            bVar2 = new TroopFileError.b(item.FileName, this.K, 5, 704, str3);
                                        }
                                        p0(item, 5, bVar2);
                                        return true;
                                    }
                                    i16 = 207;
                                } else {
                                    i16 = 202;
                                }
                            }
                        }
                        FileManagerEntity D2 = this.J.getFileManagerDataCenter().D(j3);
                        if (D2 == null) {
                            if (!TextUtils.isEmpty(str3)) {
                                p0(item, 5, new TroopFileError.b(item.FileName, this.K, 5, 704, str3));
                                return false;
                            }
                            QLog.e("TroopFileTransferManager", 1, "finishCopyFrom, but entity is null!!!sessionId:" + j3);
                        } else if (D2.busId != 104) {
                            D2.busId = 104;
                            item.BusId = 104;
                            int i17 = D2.nOpType;
                            if (i17 == 27) {
                                this.J.getFileManagerEngine().u(D2, 27);
                            } else if (i17 == 26) {
                                this.J.getFileTransferHandler().z(104, D2);
                            }
                            if (QLog.isColorLevel()) {
                                QLog.e("TroopFileTransferManager", 2, String.format("retCode:%d is, change busid to 104, try ForwardFromOfflineFile again!", Integer.valueOf(i3)));
                            }
                            return true;
                        }
                        i16 = 207;
                    } else {
                        if (!TextUtils.isEmpty(item.LocalFile) && new File(item.LocalFile).exists()) {
                            n0(item, 0);
                            item.BusId = 102;
                            this.I[0].a(new TaskScan(item));
                            return true;
                        }
                        i16 = 603;
                    }
                    o0(item, 5, i16);
                    return true;
                }
                p0(item, 5, new TroopFileError.b(item.FileName, this.K, 5, 704, str3));
                return true;
            }
        }
    }

    public final synchronized void E0(UUID uuid, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) uuid, (Object) str);
            return;
        }
        Item item = this.L.get(uuid);
        if (item != null) {
            item.FilePath = str;
            item.BusId = 102;
        }
    }

    public final boolean F(UUID uuid, int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return ((Boolean) iPatchRedirector.redirect((short) 52, this, uuid, Integer.valueOf(i3), str, str2)).booleanValue();
        }
        return E(0L, uuid, null, i3, str, str2);
    }

    public final synchronized Collection<com.tencent.mobileqq.troop.data.t> G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Collection) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        U();
        ArrayList arrayList = new ArrayList();
        Iterator<Item> it = this.L.values().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getInfo(this.K));
        }
        return arrayList;
    }

    public final synchronized com.tencent.mobileqq.troop.data.t H(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.mobileqq.troop.data.t) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        }
        if (str == null) {
            return null;
        }
        U();
        String c16 = com.tencent.mobileqq.troop.filemanager.e.c(str);
        if (c16 == null || c16.length() == 0) {
            c16 = "0";
        }
        for (Item item : this.L.values()) {
            if (str.equals(item.FilePath) || c16.equals(item.FilePath)) {
                return item.getInfo(this.K);
            }
        }
        return null;
    }

    public final synchronized com.tencent.mobileqq.troop.data.t I(UUID uuid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.mobileqq.troop.data.t) iPatchRedirector.redirect((short) 8, (Object) this, (Object) uuid);
        }
        U();
        Item item = this.L.get(uuid);
        if (item == null) {
            return null;
        }
        return item.getInfo(this.K);
    }

    public synchronized Item J(UUID uuid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            return (Item) iPatchRedirector.redirect((short) 71, (Object) this, (Object) uuid);
        }
        Map<UUID, Item> map = this.L;
        if (map == null) {
            return null;
        }
        if (uuid != null) {
            return map.get(uuid);
        }
        throw new NullPointerException("TroopFileTransferManager getItem id is Null");
    }

    public synchronized Item K(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            return (Item) iPatchRedirector.redirect((short) 72, (Object) this, j3);
        }
        return null;
    }

    public final synchronized List<com.tencent.mobileqq.troop.data.t> L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        U();
        ArrayList arrayList = new ArrayList();
        for (Item item : this.L.values()) {
            if (item != null && item.FilePath != null) {
                arrayList.add(item.getInfo(this.K));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TroopFileManager M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (TroopFileManager) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (this.f301929d == null) {
            this.f301929d = TroopFileManager.F(this.J, this.K);
        }
        return this.f301929d;
    }

    public Item P(String str, String str2, long j3, int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (Item) iPatchRedirector.redirect((short) 30, this, str, str2, Long.valueOf(j3), Integer.valueOf(i3), bundle);
        }
        return null;
    }

    protected IProxyIpService Q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (IProxyIpService) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        QQAppInterface qQAppInterface = this.J;
        if (qQAppInterface == null) {
            return null;
        }
        if (this.f301930e == null) {
            this.f301930e = (IProxyIpService) qQAppInterface.getRuntimeService(IProxyIpService.class, "all");
        }
        return this.f301930e;
    }

    public final synchronized int[] R() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (int[]) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        U();
        int[] iArr = {0, 0};
        for (Item item : this.L.values()) {
            if (item != null && item.ProgressTotal <= TroopFileManager.f301886r.longValue()) {
                int i3 = item.Status;
                if (i3 != 0 && i3 != 1) {
                    if (i3 == 2 || i3 == 3) {
                        iArr[0] = iArr[0] + 1;
                    }
                } else {
                    iArr[0] = iArr[0] + 1;
                    iArr[1] = iArr[1] + 1;
                }
            }
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    public synchronized void U() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this);
        }
    }

    protected synchronized void V(Item item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            iPatchRedirector.redirect((short) 75, (Object) this, (Object) item);
        } else {
            this.L.put(item.Id, item);
        }
    }

    protected synchronized void X(Item item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) item);
        }
    }

    protected final synchronized boolean Y(Item item) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            return ((Boolean) iPatchRedirector.redirect((short) 70, (Object) this, (Object) item)).booleanValue();
        }
        int i16 = item.Pausing;
        if (i16 != 0) {
            if (i16 == 1) {
                i3 = 9;
            } else {
                i3 = 10;
            }
            n0(item, i3);
            return true;
        }
        return false;
    }

    protected final synchronized boolean Z(Item item) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            return ((Boolean) iPatchRedirector.redirect((short) 69, (Object) this, (Object) item)).booleanValue();
        }
        int i16 = item.Pausing;
        if (i16 != 0) {
            if (i16 == 1) {
                i3 = 2;
            } else {
                i3 = 3;
            }
            n0(item, i3);
            return true;
        }
        return false;
    }

    protected void a0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            i();
            AppNetConnInfo.unregisterNetInfoHandler(this);
        }
    }

    public synchronized Item b0(UUID uuid, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (Item) iPatchRedirector.redirect((short) 20, this, uuid, Boolean.valueOf(z16));
        }
        return null;
    }

    public final synchronized boolean c0(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            return ((Boolean) iPatchRedirector.redirect((short) 74, (Object) this, (Object) str, (Object) str2)).booleanValue();
        }
        if (str == null) {
            return false;
        }
        UUID fromString = UUID.fromString(str);
        if (fromString == null) {
            return false;
        }
        U();
        Item item = this.L.get(fromString);
        if (item == null) {
            return false;
        }
        item.NameForSave = str2;
        item.LocalFile = AppConstants.SDCARD_FILE_SAVE_PATH + str2;
        i0(item);
        ((TroopFileHandler) this.J.getBusinessHandler(BusinessHandlerFactory.TROOP_FILE_HANDLER)).F2(item.getInfo(this.K));
        return true;
    }

    public boolean d0(String str, String str2, long j3, int i3, ef0.m mVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, this, str, str2, Long.valueOf(j3), Integer.valueOf(i3), mVar)).booleanValue();
        }
        TroopFileManager M = M();
        synchronized (M) {
            synchronized (this) {
                com.tencent.mobileqq.troop.data.n z16 = M.z(str, str2, j3, i3, null);
                if (z16 == null) {
                    return false;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("TroopFileTransferManager", 2, "startDownload==>" + z16.toString());
                }
                U();
                Item item = this.L.get(z16.f294915a);
                if (item == null) {
                    item = new Item(z16);
                    V(item);
                }
                Item item2 = item;
                item2.FileName = str2;
                item2.ProgressTotal = j3;
                item2.ProgressValue = z16.f294932r;
                com.tencent.biz.troop.file.a.q(this.J, this.K, item2, 0, false, true, mVar);
                return true;
            }
        }
    }

    public synchronized boolean e0(UUID uuid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Boolean) iPatchRedirector.redirect((short) 40, (Object) this, (Object) uuid)).booleanValue();
        }
        return false;
    }

    public synchronized boolean f0(UUID uuid, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Boolean) iPatchRedirector.redirect((short) 41, (Object) this, (Object) uuid, (Object) bundle)).booleanValue();
        }
        return false;
    }

    public synchronized boolean g0(UUID uuid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, (Object) uuid)).booleanValue();
        }
        return false;
    }

    protected synchronized void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        Map<UUID, Item> map = this.L;
        if (map != null) {
            for (Item item : map.values()) {
                int i3 = item.Status;
                if (i3 == 0 || i3 == 1 || i3 == 8) {
                    item.Pausing = -1;
                }
            }
        }
    }

    public void i0(Item item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, (Object) this, (Object) item);
        } else {
            v();
        }
    }

    protected synchronized boolean j0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return ((Boolean) iPatchRedirector.redirect((short) 56, (Object) this)).booleanValue();
        }
        if (!this.N) {
            return false;
        }
        return n.a(this.J, this.L, this.K);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
    
        if (r1 != 11) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final boolean k(Item item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            return ((Boolean) iPatchRedirector.redirect((short) 60, (Object) this, (Object) item)).booleanValue();
        }
        boolean z16 = false;
        if (item == null) {
            return false;
        }
        int i3 = item.Status;
        String str = "null";
        if (i3 != 6) {
            if (i3 == 7) {
                if (!TextUtils.isEmpty(item.LocalFile) && com.tencent.mobileqq.filemanager.util.q.p(item.LocalFile)) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("[");
                    UUID uuid = item.Id;
                    if (uuid != null) {
                        str = uuid.toString();
                    }
                    sb5.append(str);
                    sb5.append("], [");
                    sb5.append(item.FilePath);
                    sb5.append("], [");
                    sb5.append(item.FileName);
                    sb5.append("], check localfile is exsit, but status is not download!");
                    e.b.e("TroopFileTransferManager", e.b.f295938b, sb5.toString());
                }
            }
            if (item.ThumbnailDownloading_Small && !item.ThumbnailDownloading_Large && !item.ThumbnailDownloading_Middle) {
                if (item.HasThumbnailFile_Small && !s(item, 128)) {
                    return true;
                }
                if (item.HasThumbnailFile_Large && !s(item, 640)) {
                    return true;
                }
                if (item.HasThumbnailFile_Middle && !s(item, 383)) {
                    return true;
                }
                return z16;
            }
            return z16;
        }
        if (!TextUtils.isEmpty(item.LocalFile)) {
            if (!new File(item.LocalFile).exists()) {
                int i16 = e.b.f295938b;
                StringBuilder sb6 = new StringBuilder();
                sb6.append("[");
                UUID uuid2 = item.Id;
                if (uuid2 != null) {
                    str = uuid2.toString();
                }
                sb6.append(str);
                sb6.append("] check localfile is not exsit. set to nodownload state");
                e.b.e("TroopFileTransferManager", i16, sb6.toString());
                n0(item, 7);
            }
            if (item.ThumbnailDownloading_Small) {
            }
            return z16;
        }
        int i17 = e.b.f295938b;
        StringBuilder sb7 = new StringBuilder();
        sb7.append("[");
        UUID uuid3 = item.Id;
        if (uuid3 != null) {
            str = uuid3.toString();
        }
        sb7.append(str);
        sb7.append("] check localfile=null. set to nodownload state");
        e.b.e("TroopFileTransferManager", i17, sb7.toString());
        n0(item, 7);
        z16 = true;
        if (item.ThumbnailDownloading_Small) {
        }
        return z16;
    }

    public void k0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        if (this.J == null) {
            return;
        }
        if (this.f301932h != 0) {
            if (QLog.isDevelopLevel()) {
                QLog.d(AppConstants.FlowStatPram.PARAM_WIFIGROUP_FILE_DOWNLOAD_FLOW, 4, this.f301932h + "");
            }
            this.f301932h = 0L;
        }
        if (this.f301933i != 0) {
            this.f301933i = 0L;
        }
        if (this.f301934m != 0) {
            if (QLog.isDevelopLevel()) {
                QLog.d(AppConstants.FlowStatPram.PARAM_XGGROUP_FILE_DOWNLOAD_FLOW, 4, this.f301934m + "");
            }
            this.f301934m = 0L;
        }
        if (this.C != 0) {
            if (QLog.isDevelopLevel()) {
                QLog.d(AppConstants.FlowStatPram.PARAM_XGGROUP_FILE_UPLOAD_FLOW, 4, this.C + "");
            }
            this.C = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean l() {
        Collection<Item> values;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return ((Boolean) iPatchRedirector.redirect((short) 59, (Object) this)).booleanValue();
        }
        synchronized (this) {
            values = this.L.values();
        }
        Iterator<Item> it = values.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            z16 |= k(it.next());
        }
        return z16;
    }

    protected synchronized void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, (Object) this);
            return;
        }
        U();
        for (Item item : this.L.values()) {
            if (item.W2MPause == 2) {
                item.W2MPause = 1;
            }
        }
    }

    protected synchronized void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, (Object) this);
        }
    }

    public final void n0(Item item, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) item, i3);
        } else {
            o0(item, i3, 0);
        }
    }

    protected final void o(com.tencent.mobileqq.troop.data.t tVar, boolean z16, String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            iPatchRedirector.redirect((short) 73, this, tVar, Boolean.valueOf(z16), str, str2, str3);
            return;
        }
        FileManagerEntity newEntityByTroopFileInfo = FileManagerUtil.newEntityByTroopFileInfo(tVar);
        newEntityByTroopFileInfo.isReaded = true;
        String valueOf = String.valueOf(tVar.f294971e);
        newEntityByTroopFileInfo.peerUin = valueOf;
        newEntityByTroopFileInfo.peerNick = com.tencent.mobileqq.utils.ac.l0(this.J, valueOf);
        newEntityByTroopFileInfo.srvTime = com.tencent.mobileqq.service.message.e.K0() * 1000;
        newEntityByTroopFileInfo.setCloudType(3);
        newEntityByTroopFileInfo.bSend = z16;
        newEntityByTroopFileInfo.status = 1;
        newEntityByTroopFileInfo.fProgress = 1.0f;
        newEntityByTroopFileInfo.TroopUin = this.K;
        newEntityByTroopFileInfo.strFileMd5 = str;
        newEntityByTroopFileInfo.strFileSHA = str2;
        newEntityByTroopFileInfo.strFileSha3 = str3;
        int i3 = newEntityByTroopFileInfo.nFileType;
        if (i3 == 0 || i3 == 2) {
            if (TextUtils.isEmpty(str3)) {
                newEntityByTroopFileInfo.strFileSha3 = vb1.a.b(FileManagerUtil.getSha3(tVar.f294978l));
            }
            if (newEntityByTroopFileInfo.fileSize < GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT && TextUtils.isEmpty(newEntityByTroopFileInfo.strFileSHA)) {
                newEntityByTroopFileInfo.strFileSHA = vb1.a.b(FileManagerUtil.getSHA(tVar.f294978l));
            }
        }
        newEntityByTroopFileInfo.str10Md5 = HexUtil.bytes2HexStr(FileManagerUtil.getMd5(tVar.f294978l));
        try {
            newEntityByTroopFileInfo.localModifyTime = new File(tVar.f294978l).lastModified();
        } catch (Exception unused) {
        }
        this.J.getFileManagerDataCenter().t(newEntityByTroopFileInfo);
        newEntityByTroopFileInfo.status = 1;
        this.J.getFileManagerDataCenter().f0(newEntityByTroopFileInfo);
    }

    protected synchronized void o0(Item item, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, item, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2None() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            iPatchRedirector.redirect((short) 67, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2Wifi(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            iPatchRedirector.redirect((short) 66, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Mobile(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            iPatchRedirector.redirect((short) 63, (Object) this, (Object) str);
        } else if (QLog.isDevelopLevel()) {
            QLog.d("TroopFileTransferManager", 4, "onNetNone2Mobile");
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Wifi(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            iPatchRedirector.redirect((short) 65, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public synchronized void onNetWifi2Mobile(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, (Object) this, (Object) str);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("TroopFileTransferManager", 4, "onNetWifi2Mobile");
        }
        if (!this.N) {
            return;
        }
        boolean z16 = false;
        for (Item item : this.L.values()) {
            int i3 = item.Status;
            if (i3 == 0 || i3 == 1 || i3 == 8) {
                if (item.Pausing == 0) {
                    item.Pausing = 1;
                    item.W2MPause = 2;
                    z16 = true;
                }
            }
        }
        if (z16) {
            TroopFileError.h(this.J, this.K, 107);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2None() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            iPatchRedirector.redirect((short) 68, (Object) this);
        } else if (QLog.isDevelopLevel()) {
            QLog.d("TroopFileTransferManager", 4, "onNetWifi2None");
        }
    }

    public synchronized void p(UUID uuid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) uuid);
        }
    }

    protected synchronized void p0(Item item, int i3, TroopFileError.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, item, Integer.valueOf(i3), bVar);
        }
    }

    public boolean q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            return ((Boolean) iPatchRedirector.redirect((short) 77, (Object) this)).booleanValue();
        }
        if (this.J == null) {
            return true;
        }
        return false;
    }

    public final synchronized com.tencent.mobileqq.troop.data.t q0(FileManagerEntity fileManagerEntity, int i3, int i16, long j3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return (com.tencent.mobileqq.troop.data.t) iPatchRedirector.redirect((short) 51, this, fileManagerEntity, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), bundle);
        }
        com.tencent.mobileqq.troop.data.n d16 = M().d(fileManagerEntity.fileName, fileManagerEntity.fileSize, 102, bundle);
        if (QLog.isColorLevel()) {
            QLog.d("TroopFileTransferManager", 2, "startCopy2TroopFromFav==>" + d16.toString());
        }
        if (d16 == null) {
            return null;
        }
        U();
        d16.f294937w = fileManagerEntity.strThumbPath;
        d16.f294939y = fileManagerEntity.strMiddleThumPath;
        d16.f294938x = fileManagerEntity.strLargeThumPath;
        Item item = new Item(d16);
        V(item);
        item.RandomNum = i16;
        item.ForwardTroopuin = j3;
        item.ForwardBusId = i3;
        item.Status = 4;
        item.LocalFile = fileManagerEntity.getFilePath();
        item.entrySessionID = fileManagerEntity.nSessionId;
        item.width = fileManagerEntity.imgWidth;
        item.height = fileManagerEntity.imgHeight;
        o0(item, 4, 0);
        return item.getInfo(this.K);
    }

    public final synchronized boolean r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return ((Boolean) iPatchRedirector.redirect((short) 58, (Object) this)).booleanValue();
        }
        if (!this.N) {
            return false;
        }
        return l();
    }

    public final synchronized com.tencent.mobileqq.troop.data.t r0(String str, String str2, String str3, long j3, int i3, int i16, long j16, long j17, FileManagerEntity fileManagerEntity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return (com.tencent.mobileqq.troop.data.t) iPatchRedirector.redirect((short) 50, this, str, str2, str3, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j16), Long.valueOf(j17), fileManagerEntity, bundle);
        }
        com.tencent.mobileqq.troop.data.n d16 = M().d(str2, j3, 102, bundle);
        if (QLog.isColorLevel()) {
            QLog.d("TroopFileTransferManager", 2, "startCopy2TroopFromOfflineOrDisc==>" + d16.toString());
        }
        if (d16 == null) {
            return null;
        }
        U();
        Item item = new Item(d16);
        V(item);
        item.RandomNum = i16;
        item.ForwardTroopuin = j16;
        item.ForwardBusId = i3;
        item.Status = 4;
        item.LocalFile = str3;
        item.entrySessionID = j17;
        if (fileManagerEntity != null) {
            item.width = fileManagerEntity.imgWidth;
            item.height = fileManagerEntity.imgHeight;
            item.yybApkPackageName = fileManagerEntity.yybApkPackageName;
            item.yybApkName = fileManagerEntity.yybApkName;
            item.yybApkIconUrl = fileManagerEntity.yybApkIconUrl;
            item.fromScene = fileManagerEntity.fromScene;
        }
        o0(item, 4, 0);
        return item.getInfo(this.K);
    }

    protected boolean s(Item item, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) item, i3)).booleanValue();
        }
        return false;
    }

    public final synchronized com.tencent.mobileqq.troop.data.t s0(String str, String str2, String str3, long j3, int i3, int i16, long j16, Bundle bundle) {
        com.tencent.mobileqq.troop.data.n e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return (com.tencent.mobileqq.troop.data.t) iPatchRedirector.redirect((short) 49, this, str, str2, str3, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j16), bundle);
        }
        if (((ITroopFileApi) QRoute.api(ITroopFileApi.class)).fixWeiYunForwardFileSwitch()) {
            e16 = M().d(str2, j3, 102, bundle);
        } else {
            e16 = M().e(str, str2, j3, 102, bundle);
        }
        if (e16 == null) {
            return null;
        }
        U();
        Item item = new Item(e16);
        V(item);
        item.RandomNum = i16;
        item.ForwardTroopuin = j16;
        item.ForwardBusId = i3;
        item.Status = 4;
        item.LocalFile = str3;
        o0(item, 4, 0);
        return item.getInfo(this.K);
    }

    public boolean t(UUID uuid, long j3, long j16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 39)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 39, this, uuid, Long.valueOf(j3), Long.valueOf(j16), bundle)).booleanValue();
    }

    public com.tencent.mobileqq.troop.data.t t0(String str, long j3, String str2, String str3, long j16, int i3, int i16, long j17, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return (com.tencent.mobileqq.troop.data.t) iPatchRedirector.redirect((short) 46, this, str, Long.valueOf(j3), str2, str3, Long.valueOf(j16), Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j17), bundle);
        }
        return null;
    }

    public void u(com.tencent.mobileqq.troop.data.n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            iPatchRedirector.redirect((short) 76, (Object) this, (Object) nVar);
        }
    }

    public final void u0(int i3, long j3, int i16, long j16, int i17, String str, String str2, long j17, String str3, boolean z16, long j18, com.tencent.mobileqq.filemanager.util.w wVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, this, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Long.valueOf(j16), Integer.valueOf(i17), str, str2, Long.valueOf(j17), str3, Boolean.valueOf(z16), Long.valueOf(j18), wVar);
        } else {
            v0(i3, j3, i16, j16, i17, str, str2, j17, str3, z16, j18, wVar, 0L, 0, null);
        }
    }

    protected final synchronized void v() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this);
            return;
        }
        if (this.H == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.H = SystemClock.uptimeMillis();
        if (z16) {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.utils.TroopFileTransferManager.9
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopFileTransferManager.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    while (true) {
                        synchronized (TroopFileTransferManager.this) {
                            if (TroopFileTransferManager.this.H == 0) {
                                return;
                            }
                            if (SystemClock.uptimeMillis() > TroopFileTransferManager.this.H + 10000) {
                                TroopFileTransferManager.this.H = 0L;
                                TroopFileTransferManager.this.j0();
                                return;
                            }
                        }
                    }
                }
            }, 5, null, true);
        }
    }

    public final void v0(int i3, long j3, int i16, long j16, int i17, String str, String str2, long j17, String str3, boolean z16, long j18, com.tencent.mobileqq.filemanager.util.w wVar, long j19, int i18, Bundle bundle) {
        Item item;
        int i19;
        long j26;
        int i26 = i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i27 = 3;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, this, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Long.valueOf(j16), Integer.valueOf(i17), str, str2, Long.valueOf(j17), str3, Boolean.valueOf(z16), Long.valueOf(j18), wVar, Long.valueOf(j19), Integer.valueOf(i18), bundle);
            return;
        }
        int abs = Math.abs(new Random().nextInt());
        TroopFileManager M = M();
        synchronized (M) {
            synchronized (this) {
                if (i26 != 102 && i26 != 104) {
                    try {
                        if (this.f301929d == null) {
                            this.f301929d = M();
                        }
                        com.tencent.mobileqq.troop.data.n A = this.f301929d.A(str3);
                        i26 = A != null ? A.f294919e : 102;
                    } catch (Throwable th5) {
                        throw th5;
                    }
                }
                if (i17 == 3000) {
                    i27 = 106;
                } else if (i17 == 7 || i17 == 6003) {
                    i27 = 38;
                }
                int i28 = i27;
                com.tencent.mobileqq.troop.data.n d16 = M.d(str, j17, i26, bundle);
                if (d16 == null) {
                    return;
                }
                U();
                Item item2 = new Item(d16);
                V(item2);
                item2.RandomNum = abs;
                item2.ForwardPath = str3;
                item2.ForwardTroopuin = j3;
                item2.mForwardCallback = wVar;
                if (bundle != null) {
                    if (bundle.containsKey("yyb_apk_package_name_key")) {
                        item2.yybApkPackageName = bundle.getString("yyb_apk_package_name_key", "");
                    }
                    if (bundle.containsKey("yyb_apk_name_key")) {
                        item2.yybApkName = bundle.getString("yyb_apk_name_key", "");
                    }
                    if (bundle.containsKey("yyb_apk_icon_url_key")) {
                        item2.yybApkIconUrl = bundle.getString("yyb_apk_icon_url_key", "");
                    }
                }
                if (z16) {
                    item = item2;
                    i19 = i28;
                    j26 = j18;
                } else {
                    item = item2;
                    i19 = i28;
                    j26 = wVar.b(String.valueOf(j16), i17, String.valueOf(j3), i26, str3, str, str2, j17, i3, j19, i18);
                }
                Item item3 = item;
                item3.ForwardBusId = i26;
                item3.BusId = i19;
                com.tencent.biz.troop.file.a.p(this.J, false, this.K, item3, j16, j26, this.G);
            }
        }
    }

    public void w0(String str, String str2, long j3, int i3, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, this, str, str2, Long.valueOf(j3), Integer.valueOf(i3), cVar);
        }
    }

    public final synchronized boolean x(UUID uuid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) uuid)).booleanValue();
        }
        U();
        Item item = this.L.get(uuid);
        if (item == null) {
            return false;
        }
        int i3 = item.Status;
        if (i3 != 2 && i3 != 3 && i3 != 6 && i3 != 7) {
            switch (i3) {
                case 9:
                case 10:
                    w(item.TmpFile);
                    break;
                case 11:
                    break;
                default:
                    if (QLog.isDevelopLevel()) {
                        QLog.e("TroopFileTransferManager", 4, "deleteItem error, status:" + item.Status);
                    }
                    return false;
            }
        }
        item.deleteThumbnailFile(this.K, 128);
        item.deleteThumbnailFile(this.K, 640);
        item.deleteThumbnailFile(this.K, 383);
        if (QLog.isDevelopLevel()) {
            QLog.d("TroopFileTransferManager", 4, "delete " + item.Id + "[" + item.FilePath + "]" + item.Status);
        }
        m0(item);
        return true;
    }

    public com.tencent.mobileqq.troop.data.t x0(String str, String str2, long j3, int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (com.tencent.mobileqq.troop.data.t) iPatchRedirector.redirect((short) 31, this, str, str2, Long.valueOf(j3), Integer.valueOf(i3), bundle);
        }
        return null;
    }

    public void y(Item item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) item);
        } else {
            com.tencent.biz.troop.file.a.t(this.J, this.K, item, this.D);
        }
    }

    public int y0(FileManagerEntity fileManagerEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Integer) iPatchRedirector.redirect((short) 33, (Object) this, (Object) fileManagerEntity)).intValue();
        }
        return 0;
    }

    protected void z(Item item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) item);
        } else {
            n0(item, 1);
            com.tencent.biz.troop.file.a.v(this.J, this.K, item, this.f301931f);
        }
    }

    public void z0(List<com.tencent.mobileqq.troop.data.t> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, (Object) list);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class Item extends TroopFileTansferItemEntity {
        static IPatchRedirector $redirector_ = null;
        public static final String ThumbnailFilePrefix = "[Thumb]";
        public static final int W2M_PAUSE_CAN_RESUME = 2;
        public static final int W2M_PAUSE_NONE = 0;
        public static final int W2M_PAUSE_NO_RESUME = 1;
        public transient byte[] CheckKey;
        public transient MessageDigest DigestMd5;
        public transient MessageDigest DigestSha;
        public transient MessageDigest DigestSha3;
        public transient String DownloadDNS;
        public transient String DownloadIp;
        public transient String DownloadUrl;
        public transient boolean IsNewStatus;
        public transient int Pausing;
        public transient long ScanPos;
        public transient String ServerDns;
        public transient long StatusUpdateTimeMs;
        public transient boolean ThumbnailDownloading_Large;
        public transient boolean ThumbnailDownloading_Middle;
        public transient boolean ThumbnailDownloading_Middle_Fail;
        public transient boolean ThumbnailDownloading_Small;
        public transient String TmpFile;
        public transient String UploadIp;
        public transient int W2MPause;
        public transient boolean bExtfTransfer;
        public transient String cookieValue;
        public transient String downUrlStr4Report;
        public transient boolean genThumb_Middle_OnGettedLargeOrOrigPic;
        public transient boolean isFileExist;
        public transient String mExcitingSpeed;
        public com.tencent.mobileqq.filemanager.util.w mForwardCallback;
        public transient int retryTimes;
        public transient String rspHeadStr;
        public transient int thumbInvalidCode;
        public transient long transferBeginTime;
        public transient long transferedSize;
        public transient String uploadUrl;

        public Item() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.mForwardCallback = null;
            this.ThumbnailDownloading_Middle_Fail = false;
            this.genThumb_Middle_OnGettedLargeOrOrigPic = false;
            this.transferBeginTime = 0L;
            this.transferedSize = 0L;
            this.retryTimes = 0;
            this.bExtfTransfer = false;
        }

        public final boolean canFetchThumbnailFile(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, i3)).booleanValue();
            }
            if (this.Status == 4) {
                return false;
            }
            if (i3 == 128) {
                if (this.ThumbnailDownloading_Small) {
                    return false;
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                long j3 = this.ThumbnailFileTimeMS_Small;
                long j16 = uptimeMillis - j3;
                if (j3 != 0 && j16 <= MiniBoxNoticeInfo.MIN_5 && j16 >= 0) {
                    return false;
                }
                return true;
            }
            if (i3 == 640) {
                if (this.ThumbnailDownloading_Large) {
                    return false;
                }
                long uptimeMillis2 = SystemClock.uptimeMillis();
                long j17 = this.ThumbnailFileTimeMS_Large;
                long j18 = uptimeMillis2 - j17;
                if (j17 != 0 && j18 <= MiniBoxNoticeInfo.MIN_5 && j18 >= 0) {
                    return false;
                }
                return true;
            }
            if (i3 != 383) {
                return false;
            }
            long uptimeMillis3 = SystemClock.uptimeMillis();
            long j19 = this.ThumbnailFileTimeMS_Middle;
            long j26 = uptimeMillis3 - j19;
            if (j26 > 30000) {
                this.ThumbnailDownloading_Middle = false;
            }
            if (this.ThumbnailDownloading_Middle) {
                return false;
            }
            if (j19 != 0 && j26 <= MiniBoxNoticeInfo.MIN_5 && j26 >= 0) {
                return false;
            }
            return true;
        }

        public final void deleteThumbnailFile(long j3, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Long.valueOf(j3), Integer.valueOf(i3));
                return;
            }
            if (i3 == 128) {
                if (this.HasThumbnailFile_Small) {
                    TroopFileTransferManager.w(getThumbnailFile(j3, 128));
                }
            } else if (i3 == 383) {
                if (this.HasThumbnailFile_Middle) {
                    TroopFileTransferManager.w(getThumbnailFile(j3, 383));
                }
            } else if (i3 == 640 && this.HasThumbnailFile_Large) {
                TroopFileTransferManager.w(getThumbnailFile(j3, 640));
            }
        }

        public final com.tencent.mobileqq.troop.data.t getInfo(long j3) {
            String str;
            String str2;
            String str3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (com.tencent.mobileqq.troop.data.t) iPatchRedirector.redirect((short) 4, (Object) this, j3);
            }
            com.tencent.mobileqq.troop.data.t tVar = new com.tencent.mobileqq.troop.data.t();
            tVar.f294971e = j3;
            tVar.f294967a = this.Id;
            tVar.f294977k = this.ProgressValue;
            tVar.f294972f = this.Status;
            tVar.f294973g = this.IsNewStatus;
            tVar.f294974h = this.ErrorCode;
            tVar.f294988v = this.BusId;
            String str4 = "";
            if (this.HasThumbnailFile_Small) {
                str = getThumbnailFile(j3, 128);
            } else if (!canFetchThumbnailFile(128)) {
                str = "";
            } else {
                str = null;
            }
            tVar.f294979m = str;
            if (this.HasThumbnailFile_Large) {
                str2 = getThumbnailFile(j3, 640);
            } else if (!canFetchThumbnailFile(640)) {
                str2 = "";
            } else {
                str2 = null;
            }
            tVar.f294980n = str2;
            if (this.HasThumbnailFile_Middle) {
                str4 = getThumbnailFile(j3, 383);
            } else if (canFetchThumbnailFile(383)) {
                str4 = null;
            }
            tVar.f294981o = str4;
            tVar.f294976j = this.ProgressTotal;
            tVar.f294975i = this.UploadTime;
            tVar.f294985s = this.FilePath;
            if (!TextUtils.isEmpty(this.NameForSave) && this.SafeCheckRes == 2) {
                tVar.f294987u = this.NameForSave;
            } else {
                tVar.f294987u = this.FileName;
            }
            tVar.f294978l = this.LocalFile;
            tVar.f294990x = this.NickName;
            tVar.f294989w = this.entrySessionID;
            if (TextUtils.isEmpty(this.mParentId)) {
                str3 = "/";
            } else {
                str3 = this.mParentId;
            }
            tVar.f294991y = str3;
            boolean z16 = this.ThumbnailDownloading_Middle_Fail;
            tVar.f294992z = z16;
            if (z16 && !com.tencent.mobileqq.filemanager.util.q.f(tVar.f294981o)) {
                tVar.f294981o = null;
            }
            tVar.f294982p = this.width;
            tVar.f294983q = this.height;
            tVar.f294984r = this.duration;
            tVar.A = this.mExcitingSpeed;
            tVar.I = this.thumbInvalidCode;
            tVar.H = this.genThumb_Middle_OnGettedLargeOrOrigPic;
            tVar.B = this.yybApkPackageName;
            tVar.C = this.yybApkName;
            tVar.D = this.yybApkIconUrl;
            tVar.E = this.apkSafeLevel;
            tVar.F = this.apkSafeMsg;
            tVar.G = this.apkSafeDetailUrl;
            tVar.J = this.ntMsgId;
            tVar.K = this.ntElementId;
            return tVar;
        }

        public final String getThumbnailFile(long j3, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, this, Long.valueOf(j3), Integer.valueOf(i3));
            }
            return TroopFileUtils.q(j3, this.Id.toString(), i3);
        }

        public String idStr() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            UUID uuid = this.Id;
            if (uuid != null) {
                return uuid.toString();
            }
            return "";
        }

        public Item(TroopFileTansferItemEntity troopFileTansferItemEntity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopFileTansferItemEntity);
                return;
            }
            this.mForwardCallback = null;
            this.ThumbnailDownloading_Middle_Fail = false;
            this.genThumb_Middle_OnGettedLargeOrOrigPic = false;
            this.transferBeginTime = 0L;
            this.transferedSize = 0L;
            this.retryTimes = 0;
            this.bExtfTransfer = false;
            this.Id = troopFileTansferItemEntity.Id;
            this.LocalFile = troopFileTansferItemEntity.LocalFile;
            this.Status = troopFileTansferItemEntity.Status;
            this.FilePath = troopFileTansferItemEntity.FilePath;
            this.FileName = troopFileTansferItemEntity.FileName;
            this.ProgressTotal = troopFileTansferItemEntity.ProgressTotal;
            this.UploadTime = troopFileTansferItemEntity.UploadTime;
            this.BusId = troopFileTansferItemEntity.BusId;
            this.ErrorCode = troopFileTansferItemEntity.ErrorCode;
            this.ProgressValue = troopFileTansferItemEntity.ProgressValue;
            this.Md5 = troopFileTansferItemEntity.Md5;
            this.Sha = troopFileTansferItemEntity.Sha;
            this.isFromAIO = troopFileTansferItemEntity.isFromAIO;
            this.HasThumbnailFile_Small = troopFileTansferItemEntity.HasThumbnailFile_Small;
            this.ThumbnailFileTimeMS_Small = troopFileTansferItemEntity.ThumbnailFileTimeMS_Small;
            this.HasThumbnailFile_Large = troopFileTansferItemEntity.HasThumbnailFile_Large;
            this.ThumbnailFileTimeMS_Large = troopFileTansferItemEntity.ThumbnailFileTimeMS_Large;
            this.HasThumbnailFile_Middle = troopFileTansferItemEntity.HasThumbnailFile_Middle;
            this.ThumbnailFileTimeMS_Middle = troopFileTansferItemEntity.ThumbnailFileTimeMS_Middle;
            this.PreviewUrl = troopFileTansferItemEntity.PreviewUrl;
            this.NickName = troopFileTansferItemEntity.NickName;
            this.RandomNum = troopFileTansferItemEntity.RandomNum;
            this.NameForSave = troopFileTansferItemEntity.NameForSave;
            this.SafeCheckRes = troopFileTansferItemEntity.SafeCheckRes;
            this.ForwardPath = troopFileTansferItemEntity.ForwardPath;
            this.ForwardBusId = troopFileTansferItemEntity.ForwardBusId;
            this.ForwardTroopuin = troopFileTansferItemEntity.ForwardTroopuin;
            this.mParentId = troopFileTansferItemEntity.mParentId;
            this.width = troopFileTansferItemEntity.width;
            this.height = troopFileTansferItemEntity.height;
            this.duration = troopFileTansferItemEntity.duration;
            this.isZipInnerFile = troopFileTansferItemEntity.isZipInnerFile;
            this.zipType = troopFileTansferItemEntity.zipType;
            this.zipFilePath = troopFileTansferItemEntity.zipFilePath;
            this.zipBusId = troopFileTansferItemEntity.zipBusId;
            this.zipInnerPath = troopFileTansferItemEntity.zipInnerPath;
            this.smallThumbFile = troopFileTansferItemEntity.smallThumbFile;
            this.largeThumbnailFile = troopFileTansferItemEntity.largeThumbnailFile;
            this.middleThumbnailFile = troopFileTansferItemEntity.middleThumbnailFile;
            this.yybApkPackageName = troopFileTansferItemEntity.yybApkPackageName;
            this.yybApkName = troopFileTansferItemEntity.yybApkName;
            this.yybApkIconUrl = troopFileTansferItemEntity.yybApkIconUrl;
            this.apkSafeLevel = troopFileTansferItemEntity.apkSafeLevel;
            this.apkSafeMsg = troopFileTansferItemEntity.apkSafeMsg;
            this.apkSafeDetailUrl = troopFileTansferItemEntity.apkSafeDetailUrl;
            this.fromScene = troopFileTansferItemEntity.fromScene;
            this.troopuin = troopFileTansferItemEntity.troopuin;
            this.entrySessionID = troopFileTansferItemEntity.entrySessionID;
            this.ntMsgId = troopFileTansferItemEntity.ntMsgId;
            this.ntElementId = troopFileTansferItemEntity.ntElementId;
        }

        public Item(com.tencent.mobileqq.troop.data.n nVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) nVar);
                return;
            }
            this.mForwardCallback = null;
            boolean z16 = false;
            this.ThumbnailDownloading_Middle_Fail = false;
            this.genThumb_Middle_OnGettedLargeOrOrigPic = false;
            this.transferBeginTime = 0L;
            this.transferedSize = 0L;
            this.retryTimes = 0;
            this.bExtfTransfer = false;
            this.Id = nVar.f294915a;
            this.LocalFile = nVar.f294934t;
            this.Status = nVar.f294930p;
            this.FilePath = nVar.f294916b;
            this.FileName = nVar.f294917c;
            this.ProgressTotal = nVar.f294918d;
            this.UploadTime = nVar.f();
            this.BusId = nVar.f294919e;
            String str = nVar.f294937w;
            this.HasThumbnailFile_Small = str != null && str.length() > 0;
            String str2 = nVar.f294938x;
            if (str2 != null && str2.length() > 0) {
                z16 = true;
            }
            this.HasThumbnailFile_Large = z16;
            this.NickName = nVar.I;
            this.mParentId = nVar.f294929o;
            this.ntMsgId = nVar.G;
            this.ntElementId = nVar.H;
        }
    }
}
