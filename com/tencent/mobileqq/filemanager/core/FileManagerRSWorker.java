package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.api.IFMSettings;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.d;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.api.IOldHttpEngineProcessor;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.mobileqq.weiyun.api.IWeiyunUploadDownloadService;
import com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.plugins.RaffleJsPlugin;
import com.tencent.weiyun.transmission.upload.UploadJobContext;
import com.tencent.weiyun.transmission.upload.UploadManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.java_websocket.WebSocketImpl;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FileManagerRSWorker implements IHttpCommunicatorListener, vb1.b {
    int C;
    String D;
    String E;
    String F;
    boolean G;
    byte[] H;
    HttpMsg I;
    int J;
    private com.tencent.mobileqq.filemanager.core.h M;
    long P;
    long Q;
    long R;
    com.tencent.wstt.SSCM.a V;
    long W;
    Runnable Y;
    boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    FileManagerEntity f207346a0;

    /* renamed from: d, reason: collision with root package name */
    QQAppInterface f207349d;

    /* renamed from: d0, reason: collision with root package name */
    byte[] f207350d0;

    /* renamed from: e, reason: collision with root package name */
    String f207351e;

    /* renamed from: e0, reason: collision with root package name */
    byte[] f207352e0;

    /* renamed from: f, reason: collision with root package name */
    String f207353f;

    /* renamed from: f0, reason: collision with root package name */
    IFMSettings f207354f0;

    /* renamed from: h, reason: collision with root package name */
    String f207356h;

    /* renamed from: h0, reason: collision with root package name */
    String f207357h0;

    /* renamed from: i, reason: collision with root package name */
    String f207358i;

    /* renamed from: i0, reason: collision with root package name */
    String f207359i0;

    /* renamed from: j0, reason: collision with root package name */
    File f207360j0;

    /* renamed from: m, reason: collision with root package name */
    String f207363m;

    /* renamed from: x0, reason: collision with root package name */
    private int f207375x0;
    long K = 0;
    private long L = 0;
    int[] N = new int[0];
    String S = null;
    OutputStream T = null;
    InputStream U = null;
    long X = 0;

    /* renamed from: b0, reason: collision with root package name */
    long f207347b0 = 0;

    /* renamed from: c0, reason: collision with root package name */
    long f207348c0 = 0;

    /* renamed from: g0, reason: collision with root package name */
    int f207355g0 = 0;

    /* renamed from: k0, reason: collision with root package name */
    boolean f207361k0 = false;

    /* renamed from: l0, reason: collision with root package name */
    String f207362l0 = null;

    /* renamed from: m0, reason: collision with root package name */
    final int f207364m0 = 1000;

    /* renamed from: n0, reason: collision with root package name */
    private com.tencent.mobileqq.filemanager.app.d f207365n0 = new f();

    /* renamed from: o0, reason: collision with root package name */
    long f207366o0 = 0;

    /* renamed from: p0, reason: collision with root package name */
    long f207367p0 = 0;

    /* renamed from: q0, reason: collision with root package name */
    int f207368q0 = 0;

    /* renamed from: r0, reason: collision with root package name */
    private int f207369r0 = 0;

    /* renamed from: s0, reason: collision with root package name */
    private int f207370s0 = 0;

    /* renamed from: t0, reason: collision with root package name */
    private int f207371t0 = 0;

    /* renamed from: u0, reason: collision with root package name */
    private int f207372u0 = 0;

    /* renamed from: v0, reason: collision with root package name */
    private String f207373v0 = "";

    /* renamed from: w0, reason: collision with root package name */
    int f207374w0 = 0;

    /* renamed from: y0, reason: collision with root package name */
    com.tencent.mobileqq.filemanageraux.core.d f207376y0 = null;

    /* renamed from: z0, reason: collision with root package name */
    long f207377z0 = 0;
    long A0 = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements lc1.a {
        c() {
        }

        @Override // lc1.a
        public void a(int i3) {
            FileManagerRSWorker.this.h0(2005);
            FileManagerNotifyCenter fileManagerNotifyCenter = FileManagerRSWorker.this.f207349d.getFileManagerNotifyCenter();
            FileManagerRSWorker fileManagerRSWorker = FileManagerRSWorker.this;
            fileManagerNotifyCenter.c(fileManagerRSWorker.P, fileManagerRSWorker.Q, fileManagerRSWorker.f207363m, fileManagerRSWorker.C, 12, null, i3, null);
            FileManagerRSWorker fileManagerRSWorker2 = FileManagerRSWorker.this;
            QQAppInterface qQAppInterface = fileManagerRSWorker2.f207349d;
            long j3 = fileManagerRSWorker2.f207346a0.nSessionId;
            String str = fileManagerRSWorker2.f207357h0;
            long j16 = fileManagerRSWorker2.f207347b0;
            String str2 = fileManagerRSWorker2.f207373v0;
            FileManagerRSWorker fileManagerRSWorker3 = FileManagerRSWorker.this;
            FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface, j3, str, j16, str2, fileManagerRSWorker3.f207363m, fileManagerRSWorker3.E, fileManagerRSWorker3.f207346a0.strFileMd5, 9040L, "", fileManagerRSWorker3.f207366o0, fileManagerRSWorker3.K, fileManagerRSWorker3.R, fileManagerRSWorker3.f207373v0, "", FileManagerRSWorker.this.f207369r0, "sdcard full", null);
            FileManagerRSWorker fileManagerRSWorker4 = FileManagerRSWorker.this;
            QQAppInterface qQAppInterface2 = fileManagerRSWorker4.f207349d;
            long j17 = fileManagerRSWorker4.f207346a0.nSessionId;
            String str3 = fileManagerRSWorker4.f207359i0;
            long j18 = fileManagerRSWorker4.f207347b0;
            String str4 = fileManagerRSWorker4.f207373v0;
            FileManagerRSWorker fileManagerRSWorker5 = FileManagerRSWorker.this;
            FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface2, j17, str3, j18, str4, fileManagerRSWorker5.f207363m, fileManagerRSWorker5.E, fileManagerRSWorker5.f207346a0.strFileMd5, 9040L, "", fileManagerRSWorker5.f207366o0, fileManagerRSWorker5.K, fileManagerRSWorker5.R, fileManagerRSWorker5.f207373v0, "", FileManagerRSWorker.this.f207372u0, "sdcard full", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d implements i {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f207383a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f207384b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f207385c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f207386d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ByteStringMicro f207387e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f207388f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f207389g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ short f207390h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f207391i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ List f207392j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ int f207393k;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ String f207394l;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f207395m;

        /* renamed from: n, reason: collision with root package name */
        final /* synthetic */ String f207396n;

        /* renamed from: o, reason: collision with root package name */
        final /* synthetic */ long f207397o;

        /* renamed from: p, reason: collision with root package name */
        final /* synthetic */ Bundle f207398p;

        d(boolean z16, long j3, String str, String str2, ByteStringMicro byteStringMicro, boolean z17, String str3, short s16, String str4, List list, int i3, String str5, String str6, String str7, long j16, Bundle bundle) {
            this.f207383a = z16;
            this.f207384b = j3;
            this.f207385c = str;
            this.f207386d = str2;
            this.f207387e = byteStringMicro;
            this.f207388f = z17;
            this.f207389g = str3;
            this.f207390h = s16;
            this.f207391i = str4;
            this.f207392j = list;
            this.f207393k = i3;
            this.f207394l = str5;
            this.f207395m = str6;
            this.f207396n = str7;
            this.f207397o = j16;
            this.f207398p = bundle;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class e implements i {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f207400a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f207401b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f207402c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f207403d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f207404e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f207405f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f207406g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f207407h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f207408i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ long f207409j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ Bundle f207410k;

        e(boolean z16, long j3, String str, String str2, String str3, int i3, String str4, String str5, int i16, long j16, Bundle bundle) {
            this.f207400a = z16;
            this.f207401b = j3;
            this.f207402c = str;
            this.f207403d = str2;
            this.f207404e = str3;
            this.f207405f = i3;
            this.f207406g = str4;
            this.f207407h = str5;
            this.f207408i = i16;
            this.f207409j = j16;
            this.f207410k = bundle;
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class f extends com.tencent.mobileqq.filemanager.app.d {
        f() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.d
        protected void a(boolean z16, long j3, String str, String str2, String str3, int i3, String str4, String str5, int i16, long j16, Bundle bundle) {
            FileManagerRSWorker.this.L(z16, j3, str, str2, str3, i3, str4, str5, i16, j16, bundle);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.filemanager.app.d
        public void b(boolean z16, com.tencent.mobileqq.filemanager.app.f fVar, StatictisInfo statictisInfo) {
            super.b(z16, fVar, statictisInfo);
            FileManagerRSWorker.this.M(z16, fVar);
        }

        @Override // com.tencent.mobileqq.filemanager.app.d
        protected void e(boolean z16, com.tencent.mobileqq.filemanager.app.f fVar, StatictisInfo statictisInfo, List<String> list) {
            FileManagerRSWorker.this.N(fVar);
        }

        @Override // com.tencent.mobileqq.filemanager.app.d
        protected void j(boolean z16, long j3, String str, String str2, ByteStringMicro byteStringMicro, boolean z17, String str3, short s16, String str4, List<String> list, int i3, String str5, String str6, String str7, long j16, Bundle bundle) {
            FileManagerRSWorker.this.O(z16, j3, str, str2, byteStringMicro, z17, str3, s16, str4, list, i3, str5, str6, str7, j16, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class g implements i {
        g() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface i {
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b8, code lost:
    
        if (r1 != 54) goto L61;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FileManagerRSWorker(QQAppInterface qQAppInterface, FileManagerEntity fileManagerEntity) {
        this.P = 0L;
        this.Q = 0L;
        this.R = 0L;
        this.Z = false;
        this.f207354f0 = null;
        this.f207357h0 = null;
        this.f207359i0 = null;
        this.f207360j0 = null;
        try {
            if (fileManagerEntity != null) {
                this.f207353f = fileManagerEntity.getFilePath();
                this.C = fileManagerEntity.peerType;
                this.E = fileManagerEntity.Uuid;
                this.F = fileManagerEntity.fileIdCrc;
                this.G = fileManagerEntity.bUseMediaPlatform;
                this.J = fileManagerEntity.nOpType;
                this.D = fileManagerEntity.strServerPath;
                this.f207363m = fileManagerEntity.peerUin;
                this.f207354f0 = lc1.b.a();
                this.f207346a0 = fileManagerEntity;
                synchronized (this) {
                    this.Z = true;
                }
                this.f207349d = qQAppInterface;
                this.f207351e = qQAppInterface.getAccount();
                FileManagerEntity fileManagerEntity2 = this.f207346a0;
                if (fileManagerEntity2 != null && fileManagerEntity2.strSrcName == null) {
                    fileManagerEntity2.strSrcName = fileManagerEntity2.fileName;
                }
                A();
                int i3 = this.J;
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 != 5) {
                            if (i3 != 6) {
                                if (i3 != 8) {
                                    if (i3 != 50) {
                                    }
                                }
                            } else {
                                if (QLog.isColorLevel()) {
                                    QLog.i("FileManagerRSWorker<FileAssistant>", 2, "upload insert nSessionId[" + String.valueOf(fileManagerEntity.nSessionId) + "] ,fileId[" + fileManagerEntity.WeiYunFileId + "], fileName[" + fileManagerEntity.fileName + "], fileSize[" + String.valueOf(fileManagerEntity.fileSize) + "], modifyTime[" + String.valueOf(fileManagerEntity.lastTime) + "]");
                                }
                                this.f207357h0 = "actFileWyUp";
                            }
                        }
                        if (QLog.isColorLevel()) {
                            QLog.i("FileManagerRSWorker<FileAssistant>", 2, "download insert, nSessionId[" + String.valueOf(fileManagerEntity.nSessionId) + "] ,fileId[" + fileManagerEntity.WeiYunFileId + "], fileName[" + fileManagerEntity.fileName + "], fileSize[" + String.valueOf(fileManagerEntity.fileSize) + "], modifyTime[" + String.valueOf(fileManagerEntity.lastTime) + "]");
                        }
                        this.f207357h0 = "actFileWyDown";
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.Q) + "]getTransferFilePath");
                    }
                    this.f207353f = I(this.f207363m, fileManagerEntity.fileName);
                    h0(2);
                    FileManagerEntity fileManagerEntity3 = this.f207346a0;
                    int i16 = fileManagerEntity3.peerType;
                    if (i16 == 0) {
                        this.f207357h0 = "actFileDown";
                        this.f207359i0 = "actFileDownDetail";
                    } else if (i16 == 3000) {
                        this.f207357h0 = "actFileDiscDownLoad";
                        this.f207359i0 = "actFileDiscDownLoadDetail";
                    }
                    if (fileManagerEntity3.isZipInnerFile) {
                        this.f207357h0 = "actFileUfGenDownload";
                        this.f207359i0 = "actFileUfGenDownloadDetail";
                    }
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + fileManagerEntity.nSessionId + "]filepath[" + this.f207353f + "]:size[" + String.valueOf(fileManagerEntity.fileSize) + "]");
                    }
                    h0(2);
                    int i17 = this.f207346a0.peerType;
                    if (i17 == 0) {
                        this.f207357h0 = "actFileUp";
                        this.f207359i0 = "actFileUpDetail";
                    } else if (i17 == 3000) {
                        this.f207357h0 = "actDiscussFileUp";
                        this.f207359i0 = "actDiscussFileUpDetail";
                    }
                    if (fileManagerEntity.getFilePath() != null && fileManagerEntity.getFilePath().length() > 0) {
                        this.f207360j0 = new File(fileManagerEntity.getFilePath());
                    }
                }
                this.R = fileManagerEntity.fileSize;
                this.P = fileManagerEntity.uniseq;
                this.Q = fileManagerEntity.nSessionId;
                fileManagerEntity.status = 0;
                qQAppInterface.getFileManagerDataCenter().f0(fileManagerEntity);
                fileManagerEntity.fProgress = 0.0f;
                fileManagerEntity.status = 2;
                if (this.V == null) {
                    this.V = new com.tencent.wstt.SSCM.a();
                    return;
                }
                return;
            }
            throw new NullPointerException("entry = null,why?");
        } catch (NullPointerException e16) {
            e16.printStackTrace();
        }
    }

    private int B() {
        return QFileUtils.Q(this.D);
    }

    private int C(int i3, Bundle bundle) {
        if (((IFMConfig) QRoute.api(IFMConfig.class)).isEnableHttpsDownload4Disc(this.f207349d) && bundle != null) {
            String string = bundle.getString("strHttpsDomain");
            short s16 = bundle.getShort("httpsPort", (short) 0);
            if (!TextUtils.isEmpty(string)) {
                this.f207361k0 = true;
                this.f207362l0 = string;
                if (s16 == 0) {
                    return WebSocketImpl.DEFAULT_WSS_PORT;
                }
                return s16;
            }
            return i3;
        }
        return i3;
    }

    private short D(short s16, Bundle bundle) {
        if (((IFMConfig) QRoute.api(IFMConfig.class)).isEnableHttpsDownload4C2C(this.f207349d) && bundle != null) {
            String string = bundle.getString("strHttpsDomain");
            short s17 = bundle.getShort("httpsPort", (short) 0);
            if (!TextUtils.isEmpty(string)) {
                this.f207361k0 = true;
                this.f207362l0 = string;
                if (s17 == 0) {
                    return (short) 443;
                }
                return s17;
            }
            return s16;
        }
        return s16;
    }

    private String E(String str, String str2, int i3, String str3, String str4) {
        if (str != null && str2 != null) {
            String u16 = u(str2);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(str + ":" + i3);
            if (!TextUtils.isEmpty(str3) && com.tencent.mobileqq.filemanager.core.d.c().isConfigEnableIPV6(this.f207349d, 5)) {
                QLog.i("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] Discfile download. is config enable IPv6. domain[" + str3 + "]");
                d.c iPlistForV6Domain = com.tencent.mobileqq.filemanager.core.d.c().getIPlistForV6Domain(this.f207349d, new d.a(str3, i3), 5);
                if (iPlistForV6Domain != null && !iPlistForV6Domain.a()) {
                    if (com.tencent.mobileqq.filemanager.core.d.b()) {
                        QLog.d("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] Discfile download.debugIsDisableIPv4OnDoubleStack");
                        arrayList.clear();
                    }
                    com.tencent.mobileqq.filemanager.core.d.a(iPlistForV6Domain.f207644b, arrayList, false, false);
                    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] Discfile download. use IPv6. hostlist:" + arrayList.toString());
                } else {
                    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] Discfile download. use IPv4");
                }
            }
            com.tencent.mobileqq.filemanager.core.h hVar = new com.tencent.mobileqq.filemanager.core.h(this.f207349d, arrayList, u16);
            this.M = hVar;
            if (this.f207361k0) {
                hVar.f(true);
            } else {
                hVar.f(false);
            }
            return this.M.a();
        }
        return str4;
    }

    @Nullable
    private String F(ByteStringMicro byteStringMicro, boolean z16, String str, short s16, Bundle bundle, String str2, short s17, ArrayList<String> arrayList) {
        ArrayList<String> arrayList2 = null;
        if (str == null || byteStringMicro == null) {
            return null;
        }
        String str3 = str + ":" + ((int) s17);
        if (((IFMConfig) QRoute.api(IFMConfig.class)).getUserFtnSpeedTest() && !this.f207361k0) {
            str3 = "113.108.29.146:" + ((int) s16);
        }
        arrayList.add(0, str3);
        String str4 = "";
        if (bundle != null) {
            str4 = bundle.getString("IPv6Dns", "");
            arrayList2 = bundle.getStringArrayList("ipv6list");
        }
        V(arrayList, str4, s17, arrayList2, z16);
        com.tencent.mobileqq.filemanager.core.h hVar = new com.tencent.mobileqq.filemanager.core.h(this.f207349d, arrayList, str2);
        this.M = hVar;
        if (this.f207361k0) {
            hVar.f(true);
        } else {
            hVar.f(false);
        }
        return this.M.a();
    }

    private static synchronized String H() {
        String format;
        synchronized (FileManagerRSWorker.class) {
            try {
                LockMethodProxy.sleep(1L);
            } catch (InterruptedException e16) {
                e16.printStackTrace();
            }
            format = new SimpleDateFormat("yyyyMMddHHmmssSS", Locale.US).format(new Date(System.currentTimeMillis()));
        }
        return format;
    }

    private void J(HttpMsg httpMsg, Bundle bundle, int i3, long j3) {
        int i16 = i3;
        int i17 = this.f207369r0 + 1;
        this.f207369r0 = i17;
        this.f207372u0++;
        int i18 = 0;
        if (i16 == 9056) {
            int i19 = this.f207370s0;
            if (i19 < 3) {
                this.f207370s0 = i19 + 1;
                this.f207369r0 = i17 - 1;
            } else {
                this.f207370s0 = 0;
            }
        }
        if (i16 == 9042) {
            int i26 = this.f207371t0;
            if (i26 < 3) {
                this.f207371t0 = i26 + 1;
                this.f207369r0--;
            } else {
                this.f207371t0 = 0;
            }
        }
        if (i16 != 9056) {
            i18 = 6000;
        }
        ThreadManager.getFileThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.7
            @Override // java.lang.Runnable
            public void run() {
                FileManagerRSWorker fileManagerRSWorker = FileManagerRSWorker.this;
                if (fileManagerRSWorker.J == 0) {
                    String str = fileManagerRSWorker.D;
                    if (str != null) {
                        fileManagerRSWorker.c0(str, 0L);
                        return;
                    } else {
                        fileManagerRSWorker.e0();
                        return;
                    }
                }
                if (fileManagerRSWorker.D.equalsIgnoreCase("")) {
                    FileManagerRSWorker.this.Z();
                    return;
                }
                try {
                    OutputStream outputStream = FileManagerRSWorker.this.T;
                    if (outputStream != null) {
                        outputStream.flush();
                    }
                } catch (IOException e16) {
                    QLog.e("FileManagerRSWorker<FileAssistant>", 1, e16.getMessage());
                }
                FileManagerRSWorker fileManagerRSWorker2 = FileManagerRSWorker.this;
                fileManagerRSWorker2.K = FileManagerUtil.getFileSizes(fileManagerRSWorker2.f207358i);
                QLog.i("FileManagerRSWorker<FileAssistant>", 1, "nSessionId[" + FileManagerRSWorker.this.Q + "]retry request Httpmsg,rd[" + String.valueOf(FileManagerRSWorker.this.K) + "]");
                FileManagerRSWorker fileManagerRSWorker3 = FileManagerRSWorker.this;
                fileManagerRSWorker3.X(fileManagerRSWorker3.K, fileManagerRSWorker3.S);
            }
        }, i18);
        QLog.w("FileManagerRSWorker<FileAssistant>", 1, "nSessionId[" + this.Q + "] after [" + i18 + "] time retry!");
        if (9048 == i16) {
            i16 = 11202;
        }
        QQAppInterface qQAppInterface = this.f207349d;
        FileManagerEntity fileManagerEntity = this.f207346a0;
        FileManagerUtil.reportFilemanagerFaildInfoEx(qQAppInterface, fileManagerEntity.nSessionId, this.f207359i0, j3, this.f207373v0, this.f207363m, this.E, fileManagerEntity.strFileMd5, i16, String.valueOf(httpMsg.getSerial()), this.f207366o0, this.K, this.R, httpMsg.getRealUrl(), httpMsg.rawRespHeader, this.f207372u0, "delayTimes[" + i18 + "]" + httpMsg.getErrorString(), null, bundle);
    }

    private void K() {
        ah.b.a().execute(new Runnable() { // from class: com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    FileManagerRSWorker fileManagerRSWorker = FileManagerRSWorker.this;
                    if (fileManagerRSWorker.T == null) {
                        fileManagerRSWorker.T = new FileOutputStream(FileManagerRSWorker.this.f207358i, true);
                    }
                    FileManagerRSWorker fileManagerRSWorker2 = FileManagerRSWorker.this;
                    if (fileManagerRSWorker2.J == 1) {
                        fileManagerRSWorker2.f207349d.getFileManagerDataCenter().a0(FileManagerRSWorker.this.Q, 2002);
                    }
                    FileManagerRSWorker fileManagerRSWorker3 = FileManagerRSWorker.this;
                    fileManagerRSWorker3.f207346a0.status = 0;
                    fileManagerRSWorker3.f207349d.getFileManagerDataCenter().f0(FileManagerRSWorker.this.f207346a0);
                    FileManagerRSWorker fileManagerRSWorker4 = FileManagerRSWorker.this;
                    fileManagerRSWorker4.f207346a0.status = 2;
                    fileManagerRSWorker4.X(fileManagerRSWorker4.K, fileManagerRSWorker4.S);
                } catch (FileNotFoundException e16) {
                    e16.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(boolean z16, long j3, String str, String str2, String str3, int i3, String str4, final String str5, int i16, long j16, Bundle bundle) {
        CharSequence charSequence;
        String str6;
        if (a()) {
            QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Disc Download Replay] id[" + this.Q + "]OnDiscDownloadInfo, network error");
            return;
        }
        if (P(z16, j3, str, i16, "=_= v! [Disc Download Replay]id[", "ret error")) {
            return;
        }
        int C = C(i3, bundle);
        String E = E(str3, str4, C, bundle != null ? bundle.getString("IPv6Dns", "") : "", null);
        if (g0(j3, str, i16, E)) {
            return;
        }
        this.D = E;
        this.f207373v0 = E;
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v [Disc Download Replay]nSessionID[" + String.valueOf(this.Q) + "],retCode[" + String.valueOf(j3) + "]downLoadUrl[" + String.valueOf(this.D) + "] mUseHttps:" + this.f207361k0 + " mHttpsDomain:" + this.f207362l0 + " downloadPort:" + C);
        if (str == null || str.length() <= 0) {
            charSequence = "";
            str6 = "FileManagerRSWorker<FileAssistant>";
        } else {
            QLog.e("FileManagerRSWorker<FileAssistant>", 1, "id[" + String.valueOf(this.Q) + "] will show taost, retCode[" + String.valueOf(j3) + "], retMsg:" + str);
            charSequence = "";
            str6 = "FileManagerRSWorker<FileAssistant>";
            this.f207349d.getFileManagerNotifyCenter().c(this.P, this.Q, this.f207363m, this.C, 4, null, (int) j3, str);
        }
        if (str2 != null && str2.length() > 0) {
            if (QLog.isColorLevel()) {
                QLog.i(str6, 2, "nSeseeId[" + String.valueOf(this.Q) + "]renamed[" + str2 + "]");
            }
            this.f207353f = I(this.f207363m, str2);
        }
        if (this.f207346a0.getCloudType() == 1) {
            this.f207353f = FileManagerUtil.recreateFilePath(this.f207353f);
        }
        this.f207358i = this.f207356h + "dsc-" + String.valueOf(this.f207346a0.Uuid.replace("/", charSequence));
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            h0(2005);
            this.f207349d.getFileManagerNotifyCenter().c(this.P, this.Q, this.f207363m, this.C, 1, null, 2, null);
            QLog.e(str6, 1, "nSessionId[" + String.valueOf(this.Q) + "], NetWork Error, notify UI!");
            QQAppInterface qQAppInterface = this.f207349d;
            FileManagerEntity fileManagerEntity = this.f207346a0;
            FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface, fileManagerEntity.nSessionId, this.f207357h0, this.f207347b0, this.f207373v0, this.f207363m, this.E, fileManagerEntity.strFileMd5, 2L, String.valueOf(i16) + ContainerUtils.FIELD_DELIMITER + String.valueOf(j3), this.f207366o0, this.K, this.R, this.f207373v0, "", this.f207369r0, "net", null);
            QQAppInterface qQAppInterface2 = this.f207349d;
            FileManagerEntity fileManagerEntity2 = this.f207346a0;
            FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface2, fileManagerEntity2.nSessionId, this.f207359i0, this.f207347b0, this.f207373v0, this.f207363m, this.E, fileManagerEntity2.strFileMd5, 2L, String.valueOf(i16) + ContainerUtils.FIELD_DELIMITER + String.valueOf(j3), this.f207366o0, this.K, this.R, this.f207373v0, "", this.f207372u0, "net", null);
            return;
        }
        this.f207349d.getFileManagerDataCenter().b0(this.Q, this.f207353f);
        if (QLog.isColorLevel()) {
            QLog.i(str6, 2, "sessionId[" + String.valueOf(this.Q) + "], strTmp[" + this.f207358i + "]");
        }
        long fileSizes = FileManagerUtil.getFileSizes(this.f207358i);
        this.K = fileSizes;
        long j17 = this.R;
        if (fileSizes == j17) {
            this.f207346a0.setCloudType(3);
            h0(2003);
            this.f207349d.getFileManagerNotifyCenter().c(this.P, this.Q, this.f207363m, this.C, 11, new Object[]{this.f207353f, Long.valueOf(this.R), Boolean.TRUE, this.D}, 0, null);
            this.f207346a0.fileName = FileManagerUtil.getFileName(this.f207353f);
            if (this.f207346a0.fileName.getBytes().length > 250) {
                FileManagerEntity fileManagerEntity3 = this.f207346a0;
                fileManagerEntity3.fileName = FileManagerUtil.cutLongName(fileManagerEntity3.fileName);
                this.f207353f = I(this.f207363m, this.f207346a0.fileName);
            }
            if (FileUtils.fileExists(this.f207353f)) {
                this.f207353f = FileManagerUtil.recreateFilePath(this.f207353f);
            }
            FileManagerUtil.renameFile(new File(this.f207358i), new File(this.f207353f));
            this.f207346a0.fileName = FileManagerUtil.getFileName(this.f207353f);
            QLog.i(str6, 1, "nSessionId[" + String.valueOf(this.Q) + "], fileExisted, notify UI!");
            QQAppInterface qQAppInterface3 = this.f207349d;
            FileManagerEntity fileManagerEntity4 = this.f207346a0;
            long j18 = fileManagerEntity4.nSessionId;
            String str7 = this.f207357h0;
            String str8 = this.D;
            FileManagerUtil.reportFilemanagerSuccessInfo(qQAppInterface3, j18, str7, 0L, str8, this.f207363m, str8, fileManagerEntity4.strFileMd5, 0L, 0L, this.R, this.f207372u0, null);
            return;
        }
        if (j17 > fileSizes) {
            long j19 = j17 - fileSizes;
            if (this.f207354f0.getDefalutStorgeFreeSpace() < j19) {
                U(j19, new e(z16, j3, str, str2, str3, i3, str4, str5, i16, j16, bundle));
                return;
            }
        }
        ah.b.a().execute(new Runnable() { // from class: com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    FileManagerRSWorker fileManagerRSWorker = FileManagerRSWorker.this;
                    if (fileManagerRSWorker.T == null) {
                        fileManagerRSWorker.T = new FileOutputStream(FileManagerRSWorker.this.f207358i, true);
                    }
                    FileManagerRSWorker.this.f207349d.getFileManagerDataCenter().a0(FileManagerRSWorker.this.Q, 2002);
                    FileManagerRSWorker fileManagerRSWorker2 = FileManagerRSWorker.this;
                    fileManagerRSWorker2.f207346a0.status = 0;
                    fileManagerRSWorker2.f207349d.getFileManagerDataCenter().f0(FileManagerRSWorker.this.f207346a0);
                    FileManagerRSWorker fileManagerRSWorker3 = FileManagerRSWorker.this;
                    fileManagerRSWorker3.f207346a0.status = 2;
                    String str9 = str5;
                    fileManagerRSWorker3.S = str9;
                    fileManagerRSWorker3.X(fileManagerRSWorker3.K, str9);
                } catch (FileNotFoundException e16) {
                    e16.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(boolean z16, com.tencent.mobileqq.filemanager.app.f fVar) {
        int i3;
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [SetFileDownloadStatus Replay] id[" + this.Q + "]onDownloadFileSuc");
        if (z16 && (((i3 = fVar.f207252a) == 2 || i3 == 0) && !this.f207346a0.bSend)) {
            QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [SetFileDownloadStatus Replay] onDownloadFileSuc isSuccess[" + z16 + "],retCode[" + fVar.f207264m + "],retMsg[" + fVar.f207265n + "],retStat[" + fVar.f207252a + "]. need to send file receipt");
            if (this.f207346a0.strSrcName != null) {
                FileTransferHandler fileTransferHandler = this.f207349d.getFileTransferHandler();
                String str = this.f207363m;
                FileManagerEntity fileManagerEntity = this.f207346a0;
                fileTransferHandler.l1(str, fileManagerEntity.strSrcName, fileManagerEntity.Uuid, this.R, fileManagerEntity.uniseq);
                return;
            }
            FileTransferHandler fileTransferHandler2 = this.f207349d.getFileTransferHandler();
            String str2 = this.f207363m;
            FileManagerEntity fileManagerEntity2 = this.f207346a0;
            fileTransferHandler2.l1(str2, fileManagerEntity2.fileName, fileManagerEntity2.Uuid, this.R, fileManagerEntity2.uniseq);
            return;
        }
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [SetFileDownloadStatus Replay] onDownloadFileSuc isSuccess[" + z16 + "],retCode[" + fVar.f207264m + "],retMsg[" + fVar.f207265n + "],retStat[" + fVar.f207252a + "]. don't need to send file receipt");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(com.tencent.mobileqq.filemanager.app.f fVar) {
        if (fVar.f207264m == 0 && !this.Z) {
            b();
            byte[] bArr = fVar.f207271t;
            if (bArr != null && bArr.length > 0) {
                String str = new String(bArr);
                this.E = str;
                this.f207346a0.Uuid = str;
            } else {
                QLog.e("FileManagerRSWorker<FileAssistant>", 1, "!!!!!Server Return the UUID is null!!!!!");
            }
            this.f207367p0 = System.currentTimeMillis();
            this.f207348c0 = System.currentTimeMillis();
            FileManagerUtil.addCloseButtonSessionId(this.f207346a0.nSessionId);
            this.f207349d.getFileManagerNotifyCenter().a(this.f207346a0, 5, this.D);
            FileTransferHandler fileTransferHandler = this.f207349d.getFileTransferHandler();
            FileManagerEntity fileManagerEntity = this.f207346a0;
            fileTransferHandler.v1(fileManagerEntity, this.f207351e, this.f207363m, fileManagerEntity.Uuid, this.f207365n0);
            FileManagerReporter.a aVar = new FileManagerReporter.a();
            aVar.f209157b = "send_file_suc";
            aVar.f209158c = 1;
            FileManagerReporter.addData(this.f207349d.getCurrentAccountUin(), aVar);
            this.f207346a0.status = 1;
            this.f207349d.getFileManagerDataCenter().f0(this.f207346a0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(boolean z16, long j3, String str, String str2, ByteStringMicro byteStringMicro, boolean z17, String str3, short s16, String str4, List<String> list, int i3, String str5, String str6, String str7, long j16, Bundle bundle) {
        String str8;
        String str9;
        if (a()) {
            QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [CS Replay], SessionId[" + this.Q + "], working stop!");
            return;
        }
        if (z17) {
            str8 = str4 + "&isthumb=0";
        } else {
            str8 = str4;
        }
        if (TextUtils.isEmpty(this.f207346a0.strFileMd5) && !TextUtils.isEmpty(str6)) {
            this.f207346a0.strFileMd5 = str6;
        }
        FileManagerEntity fileManagerEntity = this.f207346a0;
        fileManagerEntity.bUseMediaPlatform = z17;
        FileManagerUtil.checkFileExisted(fileManagerEntity, this.f207349d, null);
        if (P(z16, j3, str, i3, "=_= ^! [CS Replay]id[", "server ret error")) {
            return;
        }
        this.S = str2;
        if (str5 != null) {
            this.f207353f = I(this.f207363m, str5);
        }
        short D = D(s16, bundle);
        ArrayList<String> arrayList = new ArrayList<>();
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next() + ":" + ((int) D));
            }
        }
        IQFileConfigManager iQFileConfigManager = (IQFileConfigManager) this.f207349d.getRuntimeService(IQFileConfigManager.class, "");
        if (iQFileConfigManager.isHarcodeIP()) {
            arrayList.clear();
            str9 = iQFileConfigManager.getHarcodeIP();
        } else {
            str9 = str3;
        }
        String F = F(byteStringMicro, z17, str9, s16, bundle, str8, D, arrayList);
        Bundle bundle2 = new Bundle();
        bundle2.putInt("param_V6SelectType", this.f207355g0);
        bundle2.putInt("param_ipAddrType", B());
        bundle2.putInt("param_ishttps", this.f207361k0 ? 1 : 0);
        if (w(j3, str, i3, F, bundle2)) {
            return;
        }
        this.D = F;
        this.f207373v0 = F;
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [CS Replay]nSessionID[" + String.valueOf(this.Q) + "],retCode[" + String.valueOf(j3) + "] mUseHttps:" + this.f207361k0 + " mHttpsDomain:" + this.f207362l0 + " downloadPort:" + ((int) D));
        if (j3 != 0 && str != null && str.length() > 0) {
            QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [CS Replay]id[" + String.valueOf(this.Q) + "] will show taost, retCode[" + String.valueOf(j3) + "], retMsg:" + str);
            this.f207349d.getFileManagerNotifyCenter().c(this.P, this.Q, this.f207363m, this.C, 4, null, (int) j3, str);
        }
        if (-1 != this.P) {
            this.f207349d.getMessageFacade().w0(this.f207363m, 0, this.P);
        }
        this.f207358i = this.f207356h + MD5.toMD5(this.E);
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [CS Replay]id[" + String.valueOf(this.Q) + "] no network! return!");
            h0(2005);
            this.f207349d.getFileManagerNotifyCenter().c(this.P, this.Q, this.f207363m, this.C, 1, null, 2, null);
            QQAppInterface qQAppInterface = this.f207349d;
            FileManagerEntity fileManagerEntity2 = this.f207346a0;
            FileManagerUtil.reportFilemanagerFaildInfoEx(qQAppInterface, fileManagerEntity2.nSessionId, this.f207357h0, this.f207347b0, this.f207373v0, this.f207363m, this.E, fileManagerEntity2.strFileMd5, 2L, String.valueOf(i3) + ContainerUtils.FIELD_DELIMITER + String.valueOf(j3), this.f207366o0, this.K, this.R, this.f207373v0, "", this.f207369r0, "net", null, bundle2);
            QQAppInterface qQAppInterface2 = this.f207349d;
            FileManagerEntity fileManagerEntity3 = this.f207346a0;
            FileManagerUtil.reportFilemanagerFaildInfoEx(qQAppInterface2, fileManagerEntity3.nSessionId, this.f207359i0, this.f207347b0, this.f207373v0, this.f207363m, this.E, fileManagerEntity3.strFileMd5, 2L, String.valueOf(i3) + ContainerUtils.FIELD_DELIMITER + String.valueOf(j3), this.f207366o0, this.K, this.R, this.f207373v0, "", this.f207372u0, "net", null, bundle2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("FileManagerRSWorker<FileAssistant>", 2, "sessionId[" + String.valueOf(this.Q) + "], strTmp[" + this.f207358i + "]");
        }
        long fileSizes = FileManagerUtil.getFileSizes(this.f207358i);
        this.K = fileSizes;
        long j17 = this.R;
        if (fileSizes == j17) {
            v(bundle2);
        } else if (j17 <= fileSizes || !t(z16, j3, str, str2, byteStringMicro, z17, str9, s16, str4, i3, str5, str6, str7, j16, bundle, arrayList)) {
            K();
        }
    }

    private boolean P(boolean z16, long j3, String str, int i3, String str2, String str3) {
        long j16;
        if (!z16) {
            QLog.e("FileManagerRSWorker<FileAssistant>", 1, str2 + String.valueOf(this.Q) + "] get offlinefile info is error!retCode[" + String.valueOf(j3) + "], retMsg:" + i3);
            h0(2005);
            this.f207349d.getFileManagerNotifyCenter().c(this.P, this.Q, this.f207363m, this.C, 12, null, (int) j3, str);
            if (j3 == -100001) {
                j16 = 9043;
            } else {
                j16 = 9045;
            }
            QQAppInterface qQAppInterface = this.f207349d;
            FileManagerEntity fileManagerEntity = this.f207346a0;
            long j17 = j16;
            FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface, fileManagerEntity.nSessionId, this.f207357h0, this.f207347b0, this.f207373v0, this.f207363m, this.E, fileManagerEntity.strFileMd5, j17, String.valueOf(i3) + ContainerUtils.FIELD_DELIMITER + String.valueOf(j3), this.f207366o0, this.K, this.R, this.f207373v0, "", this.f207369r0, str3, null);
            QQAppInterface qQAppInterface2 = this.f207349d;
            FileManagerEntity fileManagerEntity2 = this.f207346a0;
            FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface2, fileManagerEntity2.nSessionId, this.f207359i0, this.f207347b0, this.f207373v0, this.f207363m, this.E, fileManagerEntity2.strFileMd5, j17, String.valueOf(i3) + ContainerUtils.FIELD_DELIMITER + String.valueOf(j3), this.f207366o0, this.K, this.R, this.f207373v0, "", this.f207372u0, str3, null);
            return true;
        }
        return false;
    }

    private boolean Q(HttpMsg httpMsg, HttpMsg httpMsg2) {
        if (httpMsg == null) {
            return false;
        }
        if (httpMsg2 != null && !NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            return false;
        }
        return true;
    }

    private boolean R(HttpMsg httpMsg) {
        if (a()) {
            if (QLog.isColorLevel()) {
                QLog.e("##########", 2, "nSessionID[" + String.valueOf(this.f207346a0.nSessionId) + "]\u5df2\u7ecf\u7ed3\u675f,\u8fd4\u56de");
            }
            return true;
        }
        HttpMsg httpMsg2 = this.I;
        if (httpMsg != httpMsg2) {
            if (httpMsg != null && httpMsg2 != null) {
                QLog.e("FileManagerRSWorker<FileAssistant>", 1, "id[" + String.valueOf(this.Q) + "],Req Serial[" + String.valueOf(httpMsg.getSerial()) + "], curRequest Serial[" + String.valueOf(this.I.getSerial()) + "]");
            } else if (httpMsg != null) {
                QLog.e("FileManagerRSWorker<FileAssistant>", 1, "id[" + String.valueOf(this.Q) + "],Req Serial[" + String.valueOf(httpMsg.getSerial()) + "]");
            } else if (httpMsg2 != null) {
                QLog.e("FileManagerRSWorker<FileAssistant>", 1, "id[" + String.valueOf(this.Q) + "],curRequest Serial[" + String.valueOf(this.I.getSerial()) + "]");
            }
            return true;
        }
        return false;
    }

    private boolean S(HttpMsg httpMsg, HttpMsg httpMsg2) {
        int i3;
        if (a() || (i3 = this.f207375x0) == 1003 || i3 == 2003) {
            return true;
        }
        if (httpMsg != null || httpMsg2 != null) {
            return false;
        }
        b();
        c(null, 0);
        return true;
    }

    private void T() {
        if (QLog.isColorLevel()) {
            QLog.i("FileManagerRSWorker<FileAssistant>", 1, "start Rsworker OfflineFileHitReq:" + com.tencent.mobileqq.service.message.e.K0());
        }
        ah.b.a().execute(new Runnable() { // from class: com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.12
            @Override // java.lang.Runnable
            public void run() {
                byte[] bArr;
                if (QLog.isColorLevel()) {
                    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "running OfflineFileHitReq:" + com.tencent.mobileqq.service.message.e.K0());
                }
                jc1.a aVar = new jc1.a();
                FileManagerRSWorker fileManagerRSWorker = FileManagerRSWorker.this;
                aVar.f409770a = fileManagerRSWorker.f207363m;
                aVar.f409771b = fileManagerRSWorker.R;
                fileManagerRSWorker.H = FileManagerUtil.getMd5(fileManagerRSWorker.f207353f);
                FileManagerRSWorker fileManagerRSWorker2 = FileManagerRSWorker.this;
                fileManagerRSWorker2.f207350d0 = FileManagerUtil.getSHA(fileManagerRSWorker2.f207353f);
                FileManagerRSWorker fileManagerRSWorker3 = FileManagerRSWorker.this;
                fileManagerRSWorker3.f207352e0 = FileManagerUtil.get3SHA(fileManagerRSWorker3.f207353f);
                FileManagerRSWorker fileManagerRSWorker4 = FileManagerRSWorker.this;
                if (fileManagerRSWorker4.H != null && fileManagerRSWorker4.f207350d0 != null && (bArr = fileManagerRSWorker4.f207352e0) != null) {
                    fileManagerRSWorker4.f207346a0.strFileSha3 = HexUtil.bytes2HexStr(bArr);
                    FileManagerRSWorker fileManagerRSWorker5 = FileManagerRSWorker.this;
                    fileManagerRSWorker5.f207346a0.str10Md5 = HexUtil.bytes2HexStr(fileManagerRSWorker5.H);
                    FileManagerRSWorker fileManagerRSWorker6 = FileManagerRSWorker.this;
                    aVar.f409776g = fileManagerRSWorker6.H;
                    aVar.f409778i = fileManagerRSWorker6.f207350d0;
                    aVar.f409779j = fileManagerRSWorker6.f207352e0;
                    try {
                        aVar.f409775f = FileManagerUtil.getFileName(fileManagerRSWorker6.f207353f).getBytes("utf-8");
                        aVar.f409774e = FileManagerRSWorker.this.f207353f.getBytes("utf-8");
                    } catch (UnsupportedEncodingException e16) {
                        e16.printStackTrace();
                    }
                    FileManagerRSWorker.this.f207349d.getFileTransferHandler().n1(aVar, FileManagerRSWorker.this.f207365n0, FileManagerRSWorker.this.f207346a0);
                    return;
                }
                fileManagerRSWorker4.c(null, 0);
            }
        });
    }

    private void U(long j3, i iVar) {
        this.f207349d.getFileManagerRSCenter().l(false);
        this.f207349d.getFileManagerEngine().T().e();
        this.f207349d.getFileManagerEngine().U().h();
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f207358i);
        this.f207354f0.justDoIt(j3, arrayList, BaseActivity.sTopActivity, new c());
    }

    private void V(List<String> list, String str, int i3, List<String> list2, boolean z16) {
        if (list != null && com.tencent.mobileqq.filemanager.core.d.c().isConfigEnableIPV6(this.f207349d, 1)) {
            if (z16 && list2 != null && list2.size() > 0) {
                QLog.i("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] mediaplatform offlinefile download. is config enable IPv6. v6ipsize[" + list2.size() + "]");
                List<String> iPV6listForMediaPlatfrom = com.tencent.mobileqq.filemanager.core.d.c().getIPV6listForMediaPlatfrom(this.f207349d, 1, list2);
                if (iPV6listForMediaPlatfrom != null && iPV6listForMediaPlatfrom.size() > 0) {
                    if (com.tencent.mobileqq.filemanager.core.d.b()) {
                        QLog.d("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] mediaplatform offlinefile download. debugIsDisableIPv4OnDoubleStack");
                        list.clear();
                    }
                    for (int size = iPV6listForMediaPlatfrom.size() - 1; size >= 0; size--) {
                        String str2 = iPV6listForMediaPlatfrom.get(size);
                        if (!TextUtils.isEmpty(str2)) {
                            list.add(0, "[" + str2 + "]:" + i3);
                        }
                    }
                    this.f207355g0 = 2;
                    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] mediaplatform offlinefile download use IPv6. iplist:" + list.toString());
                    return;
                }
                this.f207355g0 = 1;
                QLog.i("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] mediaplatform offlinefile download use IPv4");
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                QLog.i("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] offlinefile download. is config enable IPv6. domain[" + str + "]");
                d.c iPlistForV6Domain = com.tencent.mobileqq.filemanager.core.d.c().getIPlistForV6Domain(this.f207349d, new d.a(str, i3), 1);
                if (iPlistForV6Domain != null && !iPlistForV6Domain.a()) {
                    if (com.tencent.mobileqq.filemanager.core.d.b()) {
                        QLog.d("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] offlinefile download. debugIsDisableIPv4OnDoubleStack");
                        list.clear();
                    }
                    com.tencent.mobileqq.filemanager.core.d.a(iPlistForV6Domain.f207644b, list, false, false);
                    this.f207355g0 = 2;
                    if (iPlistForV6Domain.f207643a == 1) {
                        this.f207355g0 = 3;
                    }
                    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] offlinefile download. use IPv6. iplist:" + list.toString());
                    return;
                }
                this.f207355g0 = 1;
                QLog.i("FileManagerRSWorker<FileAssistant>", 1, "[IPv6-File] offlinefile download. use IPv4");
                return;
            }
            this.f207355g0 = 1;
            return;
        }
        this.f207355g0 = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(long j3, String str) {
        Y(j3, str, false);
    }

    private void Y(long j3, String str, boolean z16) {
        String str2;
        String str3;
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v> [Http Recv]id[" + String.valueOf(this.Q) + "] receviveFile, pos[" + j3 + "] url:" + this.D);
        if (this.Z) {
            QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Http Recv]id[" + String.valueOf(this.Q) + "] is stoped!");
            return;
        }
        String str4 = "bytes=" + j3 + "-";
        HttpMsg httpMsg = new HttpMsg(this.D, null, this, true);
        httpMsg.setInstanceFollowRedirects(z16);
        if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1) {
            str2 = "wifi";
        } else {
            str2 = "gprs";
        }
        httpMsg.setRequestProperty("Net-type", str2);
        httpMsg.setRequestProperty("cache-control", "no-cache");
        httpMsg.setRequestProperty("Range", str4);
        if (QLog.isColorLevel()) {
            QLog.i("FileManagerRSWorker<FileAssistant>", 1, "set cookie:" + str);
        }
        if (str != null) {
            httpMsg.setRequestProperty("Cookie", str);
        }
        httpMsg.setPriority(1);
        httpMsg.setDataSlice(true);
        httpMsg.fileType = 0;
        httpMsg.busiType = this.C;
        httpMsg.msgId = String.valueOf(this.Q);
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v> [Http Recv]Id[" + String.valueOf(this.Q) + "]recv http data RANGE[" + String.valueOf(str4) + "], peerType[" + String.valueOf(this.C) + "]");
        httpMsg.setRequestProperty("Accept-Encoding", "identity");
        String str5 = this.D;
        if (str5 != null) {
            str3 = str5.toLowerCase();
        } else {
            str3 = "";
        }
        if (this.f207361k0 && str3.startsWith("https")) {
            httpMsg.mIsHttps = true;
            httpMsg.mIsHostIP = com.tencent.mobileqq.filemanager.core.h.c(this.D);
            httpMsg.mReqHost = this.f207362l0;
        }
        httpMsg.timeoutParam = FileManagerUtil.getTimeOutParamer();
        ((IOldHttpEngineProcessor) QRoute.api(IOldHttpEngineProcessor.class)).sendMsg(httpMsg);
        this.I = httpMsg;
        if (j3 == 0) {
            h0(2001);
            this.f207349d.getFileManagerNotifyCenter().c(this.P, this.Q, this.f207363m, this.C, 10, null, 6, null);
        }
    }

    private boolean b0(HttpMsg httpMsg, Bundle bundle) {
        if (httpMsg.getResponseCode() == 206 || httpMsg.getResponseCode() == 200) {
            try {
                this.T.write(httpMsg.getRecvData());
                this.f207369r0 = 0;
                long length = httpMsg.getRecvData().length;
                this.f207366o0 += length;
                this.K += length;
                long totalLen = httpMsg.getTotalLen();
                long j3 = this.K;
                if (j3 >= totalLen) {
                    if (this.C != 3000 && !com.tencent.mobileqq.filemanager.fileassistant.util.h.k(this.f207346a0.peerUin) && !this.f207346a0.bSend) {
                        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v> [Set FileStatus]Id[" + this.Q + "] set Download Success");
                        this.f207349d.getFileTransferHandler().u1(this.f207351e, this.E, this.G, this.F, this.f207365n0);
                    }
                    this.I = null;
                    try {
                        this.T.close();
                    } catch (IOException e16) {
                        QLog.i("8pic", 1, "Id[" + String.valueOf(this.Q) + "]exception io FileMsg, " + e16.toString());
                        e16.printStackTrace();
                    }
                    this.T = null;
                    x();
                } else {
                    this.f207346a0.fProgress = ((float) j3) / ((float) this.R);
                    h0(2002);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.X < 1000) {
                        return true;
                    }
                    this.X = currentTimeMillis;
                    this.f207346a0.fProgress = ((float) this.K) / ((float) this.R);
                    this.f207349d.getFileManagerNotifyCenter().c(this.P, this.Q, this.f207363m, this.C, 16, null, 0, null);
                }
            } catch (Exception e17) {
                if (e17.getMessage().contains("ENOSPC")) {
                    synchronized (this) {
                        this.Z = true;
                        if (this.I != null) {
                            QLog.i("FileManagerRSWorker<FileAssistant>", 2, "=_= v! Id[" + String.valueOf(this.Q) + "]stop serial[" + String.valueOf(this.I.getSerial()) + "]:" + e17.getMessage());
                            ((IOldHttpEngineProcessor) QRoute.api(IOldHttpEngineProcessor.class)).cancelMsg(this.I);
                        }
                        this.f207349d.getFileManagerRSCenter().l(false);
                        try {
                            U(this.R, new g());
                        } catch (Exception unused) {
                            QQAppInterface qQAppInterface = this.f207349d;
                            FileManagerEntity fileManagerEntity = this.f207346a0;
                            long j16 = fileManagerEntity.nSessionId;
                            String str = this.f207357h0;
                            long j17 = this.f207347b0;
                            String str2 = this.f207373v0;
                            FileManagerUtil.reportFilemanagerFaildInfoEx(qQAppInterface, j16, str, j17, str2, this.f207363m, this.E, fileManagerEntity.strFileMd5, 9003L, "", this.f207366o0, this.K, this.R, str2, "", this.f207369r0, "write stream error", null, bundle);
                            QQAppInterface qQAppInterface2 = this.f207349d;
                            FileManagerEntity fileManagerEntity2 = this.f207346a0;
                            long j18 = fileManagerEntity2.nSessionId;
                            String str3 = this.f207359i0;
                            long j19 = this.f207347b0;
                            String str4 = this.f207373v0;
                            FileManagerUtil.reportFilemanagerFaildInfoEx(qQAppInterface2, j18, str3, j19, str4, this.f207363m, this.E, fileManagerEntity2.strFileMd5, 9003L, "", this.f207366o0, this.K, this.R, str4, "", this.f207372u0, "write stream error", null, bundle);
                            handleError(null, null);
                            return true;
                        }
                    }
                }
                QQAppInterface qQAppInterface3 = this.f207349d;
                FileManagerEntity fileManagerEntity3 = this.f207346a0;
                long j26 = fileManagerEntity3.nSessionId;
                String str5 = this.f207357h0;
                long j27 = this.f207347b0;
                String str6 = this.f207373v0;
                FileManagerUtil.reportFilemanagerFaildInfoEx(qQAppInterface3, j26, str5, j27, str6, this.f207363m, this.E, fileManagerEntity3.strFileMd5, 9003L, "", this.f207366o0, this.K, this.R, str6, "", this.f207369r0, "write stream error", null, bundle);
                QQAppInterface qQAppInterface4 = this.f207349d;
                FileManagerEntity fileManagerEntity4 = this.f207346a0;
                long j28 = fileManagerEntity4.nSessionId;
                String str7 = this.f207359i0;
                long j29 = this.f207347b0;
                String str8 = this.f207373v0;
                FileManagerUtil.reportFilemanagerFaildInfoEx(qQAppInterface4, j28, str7, j29, str8, this.f207363m, this.E, fileManagerEntity4.strFileMd5, 9003L, "", this.f207366o0, this.K, this.R, str8, "", this.f207372u0, "write stream error", null, bundle);
                handleError(null, null);
                return true;
            }
        }
        return false;
    }

    private void d0(String str, long j3, int i3) {
        String str2;
        this.f207366o0 += i3;
        byte[] G = G(j3, i3);
        if (G == null) {
            QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [Upload Step] Id[" + this.Q + "]sendFilePakage transferData null");
            QQAppInterface qQAppInterface = this.f207349d;
            FileManagerEntity fileManagerEntity = this.f207346a0;
            FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface, fileManagerEntity.nSessionId, this.f207357h0, this.f207347b0, this.f207373v0, this.f207363m, this.E, fileManagerEntity.strFileMd5, 9003L, "", 0L, 0L, this.R, "", "", this.f207369r0, "get Stream null", null);
            QQAppInterface qQAppInterface2 = this.f207349d;
            FileManagerEntity fileManagerEntity2 = this.f207346a0;
            FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface2, fileManagerEntity2.nSessionId, this.f207359i0, this.f207347b0, this.f207373v0, this.f207363m, this.E, fileManagerEntity2.strFileMd5, 9003L, "", 0L, 0L, this.R, "", "", this.f207372u0, "get Stream null", null);
            handleError(null, null);
            return;
        }
        HttpMsg httpMsg = new HttpMsg(str + "&bmd5=" + MD5.toMD5(G) + "&range=" + String.valueOf(j3), G, this);
        httpMsg.setInstanceFollowRedirects(false);
        httpMsg.setRequestProperty("cache-control", "no-cache");
        if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1) {
            str2 = "wifi";
        } else {
            str2 = "gprs";
        }
        httpMsg.setRequestProperty("Net-type", str2);
        httpMsg.setRequestProperty("Range", "bytes=" + j3 + "-");
        httpMsg.setRequestMethod("POST");
        httpMsg.setPriority(1);
        httpMsg.fileType = 0;
        httpMsg.busiType = this.C;
        httpMsg.msgId = String.valueOf(this.Q);
        if (QLog.isColorLevel()) {
            QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + this.Q + "]send http data size[" + i3 + "], peerType[" + this.C + "]");
        }
        ((IOldHttpEngineProcessor) QRoute.api(IOldHttpEngineProcessor.class)).sendMsg(httpMsg);
        this.I = httpMsg;
        if (QLog.isColorLevel()) {
            QLog.e("##########", 2, "\u53d1\u9001\u4e00\u4e2a\u6570\u636e\u5305,nSessionID[" + String.valueOf(this.f207346a0.nSessionId) + "]");
        }
    }

    private void f0(String str, byte[] bArr, byte[] bArr2, long j3, byte[] bArr3, com.tencent.mobileqq.filemanager.app.d dVar, FileManagerEntity fileManagerEntity) {
        jc1.a aVar = new jc1.a();
        aVar.f409770a = this.f207363m;
        aVar.f409775f = bArr2;
        aVar.f409774e = bArr;
        aVar.f409771b = this.R;
        aVar.f409776g = this.H;
        if (j3 <= GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT) {
            aVar.f409772c = FSUploadConst.ERR_FILE_NOT_EXIST;
            byte[] sha = FileManagerUtil.getSHA(new String(bArr));
            this.f207350d0 = sha;
            if (sha == null) {
                c(null, 0);
                return;
            }
            aVar.f409778i = sha;
            QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [CS Step], SessionId[" + this.Q + "], filesize < 100 get sha1");
        } else {
            aVar.f409772c = 1600;
            byte[] bArr4 = FileManagerUtil.get3SHA(new String(bArr));
            this.f207352e0 = bArr4;
            fileManagerEntity.strFileSha3 = HexUtil.bytes2HexStr(bArr4);
            fileManagerEntity.str10Md5 = HexUtil.bytes2HexStr(this.H);
            byte[] bArr5 = this.f207352e0;
            if (bArr5 == null) {
                c(null, 0);
                return;
            }
            aVar.f409779j = bArr5;
            QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [CS Step], SessionId[" + this.Q + "], filesize > 100 get sha3");
        }
        this.f207349d.getFileTransferHandler().m1(aVar, this.f207365n0, fileManagerEntity);
    }

    private boolean g0(long j3, String str, int i3, String str2) {
        long j16 = j3;
        if (str2 == null) {
            QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Disc Download Replay]id[" + String.valueOf(this.Q) + "] get DiscdownLoad info Url is null");
            h0(2005);
            this.f207349d.getFileManagerNotifyCenter().c(this.P, this.Q, this.f207363m, this.C, 12, null, (int) j16, str);
            if (j16 == 0) {
                j16 = 9048;
            }
            QQAppInterface qQAppInterface = this.f207349d;
            FileManagerEntity fileManagerEntity = this.f207346a0;
            long j17 = j16;
            FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface, fileManagerEntity.nSessionId, this.f207357h0, this.f207347b0, this.f207373v0, this.f207363m, this.E, fileManagerEntity.strFileMd5, j17, String.valueOf(i3), this.f207366o0, this.K, this.R, this.f207373v0, "", this.f207369r0, "ip url error", null);
            QQAppInterface qQAppInterface2 = this.f207349d;
            FileManagerEntity fileManagerEntity2 = this.f207346a0;
            FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface2, fileManagerEntity2.nSessionId, this.f207359i0, this.f207347b0, this.f207373v0, this.f207363m, this.E, fileManagerEntity2.strFileMd5, j17, String.valueOf(i3), this.f207366o0, this.K, this.R, this.f207373v0, "", this.f207372u0, "ip url error", null);
            return true;
        }
        return false;
    }

    private boolean r(String str) {
        if (!str.contains("-29120") && !str.contains("-502") && !str.contains("HTTP_PROXY_AUTH") && !str.contains("-29150") && !str.contains("-21122") && !str.contains("-28123") && !str.contains("-25081") && !str.contains("-28126")) {
            return false;
        }
        return true;
    }

    private boolean s(String str) {
        if (!str.contains("-6101") && !str.contains("-7003") && !str.contains("-403") && !str.contains("-9006") && !str.contains("-9004") && !str.contains("-9017") && !str.contains("-28137")) {
            return false;
        }
        return true;
    }

    private boolean t(boolean z16, long j3, String str, String str2, ByteStringMicro byteStringMicro, boolean z17, String str3, short s16, String str4, int i3, String str5, String str6, String str7, long j16, Bundle bundle, ArrayList<String> arrayList) {
        long j17 = this.R - this.K;
        if (this.f207354f0.getDefalutStorgeFreeSpace() < j17) {
            QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [CS Replay]id[" + String.valueOf(this.Q) + "] not enought space! ProcessNewPath");
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(arrayList);
            U(j17, new d(z16, j3, str, str2, byteStringMicro, z17, str3, s16, str4, arrayList2, i3, str5, str6, str7, j16, bundle));
            return true;
        }
        return false;
    }

    private String u(String str) {
        return "/ftn_handler/" + str;
    }

    private void v(Bundle bundle) {
        this.f207346a0.setCloudType(3);
        h0(2003);
        this.f207349d.getFileManagerNotifyCenter().c(this.P, this.Q, this.f207363m, this.C, 11, new Object[]{this.f207353f, Long.valueOf(this.R), Boolean.TRUE, this.D}, 0, null);
        this.f207346a0.fileName = FileManagerUtil.getFileName(this.f207353f);
        if (this.f207346a0.fileName.getBytes().length > 250) {
            FileManagerEntity fileManagerEntity = this.f207346a0;
            fileManagerEntity.fileName = FileManagerUtil.cutLongName(fileManagerEntity.fileName);
            this.f207353f = I(this.f207363m, this.f207346a0.fileName);
        }
        if (FileUtils.fileExists(this.f207353f)) {
            this.f207353f = FileManagerUtil.recreateFilePath(this.f207353f);
        }
        FileManagerUtil.renameFile(new File(this.f207358i), new File(this.f207353f));
        this.f207346a0.fileName = FileManagerUtil.getFileName(this.f207353f);
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [CS Replay]id[" + String.valueOf(this.Q) + "] is exist, and filesize is right!");
        QQAppInterface qQAppInterface = this.f207349d;
        FileManagerEntity fileManagerEntity2 = this.f207346a0;
        long j3 = fileManagerEntity2.nSessionId;
        String str = this.f207357h0;
        String str2 = this.D;
        FileManagerUtil.reportFilemanagerSuccessInfoEx(qQAppInterface, j3, str, 0L, str2, this.f207363m, str2, fileManagerEntity2.strFileMd5, 0L, 0L, this.R, this.f207372u0, null, bundle);
    }

    private boolean w(long j3, String str, int i3, String str2, Bundle bundle) {
        long j16 = j3;
        if (str2 == null) {
            QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [CS Replay]id[" + String.valueOf(this.Q) + "] get offlinefile info Url is null, IP is null too");
            h0(2005);
            if (j16 == -6101 || j16 == -7003) {
                QLog.d("FileManagerRSWorker<FileAssistant>", 1, "set file invalid fileSize = " + this.f207346a0.fileSize + " fileType = " + this.f207346a0.nFileType + " uuid = " + this.f207346a0.Uuid);
                this.f207346a0.status = 16;
            }
            this.f207349d.getFileManagerNotifyCenter().c(this.P, this.Q, this.f207363m, this.C, 12, null, (int) j16, str);
            if (j16 == 0) {
                j16 = 9048;
            }
            QQAppInterface qQAppInterface = this.f207349d;
            FileManagerEntity fileManagerEntity = this.f207346a0;
            long j17 = j16;
            FileManagerUtil.reportFilemanagerFaildInfoEx(qQAppInterface, fileManagerEntity.nSessionId, this.f207357h0, this.f207347b0, this.f207373v0, this.f207363m, this.E, fileManagerEntity.strFileMd5, j17, String.valueOf(i3), this.f207366o0, this.K, this.R, this.f207373v0, "", this.f207369r0, "ip url error", null, bundle);
            QQAppInterface qQAppInterface2 = this.f207349d;
            FileManagerEntity fileManagerEntity2 = this.f207346a0;
            FileManagerUtil.reportFilemanagerFaildInfoEx(qQAppInterface2, fileManagerEntity2.nSessionId, this.f207359i0, this.f207347b0, this.f207373v0, this.f207363m, this.E, fileManagerEntity2.strFileMd5, j17, String.valueOf(i3), this.f207366o0, this.K, this.R, this.f207373v0, "", this.f207372u0, "ip url error", null, bundle);
            this.f207349d.getFileManagerDataCenter().f0(this.f207346a0);
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x043e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x025e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void x() {
        String str;
        String str2;
        Bundle bundle;
        String str3;
        String str4;
        String str5;
        String str6;
        String bytes2HexStr;
        String str7;
        FileManagerEntity fileManagerEntity;
        int i3;
        boolean renameFile;
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Http Download]Id[" + this.Q + "] downLoad Success!");
        this.f207346a0.fileName = FileManagerUtil.getFileName(this.f207353f);
        this.f207346a0.lastSuccessTime = com.tencent.mobileqq.service.message.e.K0();
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v [Http Download]Id[" + this.Q + "] update successTime[" + this.f207346a0.lastSuccessTime + "]");
        int length = 250 - (this.f207353f.length() - this.f207346a0.fileName.length());
        if (this.f207346a0.fileName.getBytes().length > length) {
            FileManagerEntity fileManagerEntity2 = this.f207346a0;
            fileManagerEntity2.fileName = FileManagerUtil.cutLongLongFileName(fileManagerEntity2.fileName, length);
            this.f207353f = I(this.f207363m, this.f207346a0.fileName);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("param_V6SelectType", this.f207355g0);
        bundle2.putInt("param_ipAddrType", B());
        bundle2.putInt("param_ishttps", this.f207361k0 ? 1 : 0);
        if (FileUtils.fileExists(this.f207353f)) {
            this.f207353f = FileManagerUtil.recreateFilePath(this.f207353f);
        }
        try {
            renameFile = FileManagerUtil.renameFile(new File(this.f207358i), new File(this.f207353f));
            if (!renameFile) {
                renameFile = FileManagerUtil.renameFile(new File(this.f207358i), new File(this.f207353f));
                QLog.e("FileManagerRSWorker<FileAssistant>", 1, "rename with vfs error, normalResult[" + renameFile + "]");
            }
        } catch (Exception unused) {
            str = "]equalsIgnoreCase md5 success,";
            str2 = "=_= v! Id[";
        }
        if (!renameFile) {
            QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v! Id[" + this.f207346a0.nSessionId + "]rename file error, strTmpPath[" + this.f207358i + "],strFilePath[" + this.f207353f + "]");
            QQAppInterface qQAppInterface = this.f207349d;
            FileManagerEntity fileManagerEntity3 = this.f207346a0;
            long j3 = fileManagerEntity3.nSessionId;
            String str8 = this.f207357h0;
            long j16 = this.f207347b0;
            String str9 = this.f207373v0;
            str = "]equalsIgnoreCase md5 success,";
            str2 = "=_= v! Id[";
            try {
                bundle = bundle2;
                str3 = "FileManagerRSWorker<FileAssistant>";
            } catch (Exception unused2) {
                bundle = bundle2;
                str3 = "FileManagerRSWorker<FileAssistant>";
                str4 = "]";
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str2);
                sb5.append(this.f207346a0.nSessionId);
                str6 = str;
                sb5.append(str6);
                str5 = str3;
                QLog.e(str5, 1, sb5.toString());
                bytes2HexStr = com.qq.taf.jce.HexUtil.bytes2HexStr(FileManagerUtil.getMd5(this.f207353f));
                if (bytes2HexStr != null) {
                }
                this.f207346a0.setFilePath(this.f207353f);
                this.f207346a0.fileName = FileManagerUtil.getFileName(this.f207353f);
                FileManagerEntity fileManagerEntity4 = this.f207346a0;
                fileManagerEntity4.nFileType = FileManagerUtil.getFileType(fileManagerEntity4.fileName);
                fileManagerEntity = this.f207346a0;
                if (fileManagerEntity.nFileType == 0) {
                }
                this.f207346a0.localModifyTime = new File(this.f207353f).lastModified();
                FileManagerEntity fileManagerEntity5 = this.f207346a0;
                fileManagerEntity5.status = 1;
                fileManagerEntity5.setCloudType(3);
                h0(2003);
                if (QLog.isColorLevel()) {
                }
                this.f207349d.getFileManagerNotifyCenter().c(this.P, this.Q, this.f207363m, this.C, 11, new Object[]{this.f207353f, Long.valueOf(this.R), Boolean.TRUE, this.D}, 0, null);
                long currentTimeMillis = System.currentTimeMillis();
                this.f207348c0 = currentTimeMillis;
                QQAppInterface qQAppInterface2 = this.f207349d;
                FileManagerEntity fileManagerEntity6 = this.f207346a0;
                Bundle bundle3 = bundle;
                FileManagerUtil.reportFilemanagerSuccessInfoEx(qQAppInterface2, fileManagerEntity6.nSessionId, this.f207357h0, currentTimeMillis - this.f207347b0, this.D, this.f207363m, this.E, fileManagerEntity6.strFileMd5, this.f207366o0, this.K, this.R, this.f207372u0, null, bundle3);
                QQAppInterface qQAppInterface3 = this.f207349d;
                FileManagerEntity fileManagerEntity7 = this.f207346a0;
                FileManagerUtil.reportFilemanagerSuccessInfoEx(qQAppInterface3, fileManagerEntity7.nSessionId, this.f207359i0, this.f207348c0 - this.f207347b0, this.D, this.f207363m, this.E, fileManagerEntity7.strFileMd5, this.f207366o0, this.K, this.R, this.f207372u0, null, bundle3);
                FileManagerEntity fileManagerEntity8 = this.f207346a0;
                i3 = fileManagerEntity8.nFileType;
                if (i3 != 0) {
                }
                FileManagerUtil.fixEntityThumbSize(this.f207346a0);
                if (this.f207346a0.isZipInnerFile) {
                }
                FileManagerReporter.a aVar = new FileManagerReporter.a();
                aVar.f209157b = "rece_file_suc";
                aVar.f209158c = 1;
                FileManagerReporter.addData(this.f207349d.getCurrentAccountUin(), aVar);
            }
            try {
                str4 = "]";
            } catch (Exception unused3) {
                str4 = "]";
                StringBuilder sb52 = new StringBuilder();
                sb52.append(str2);
                sb52.append(this.f207346a0.nSessionId);
                str6 = str;
                sb52.append(str6);
                str5 = str3;
                QLog.e(str5, 1, sb52.toString());
                bytes2HexStr = com.qq.taf.jce.HexUtil.bytes2HexStr(FileManagerUtil.getMd5(this.f207353f));
                if (bytes2HexStr != null) {
                }
                this.f207346a0.setFilePath(this.f207353f);
                this.f207346a0.fileName = FileManagerUtil.getFileName(this.f207353f);
                FileManagerEntity fileManagerEntity42 = this.f207346a0;
                fileManagerEntity42.nFileType = FileManagerUtil.getFileType(fileManagerEntity42.fileName);
                fileManagerEntity = this.f207346a0;
                if (fileManagerEntity.nFileType == 0) {
                }
                this.f207346a0.localModifyTime = new File(this.f207353f).lastModified();
                FileManagerEntity fileManagerEntity52 = this.f207346a0;
                fileManagerEntity52.status = 1;
                fileManagerEntity52.setCloudType(3);
                h0(2003);
                if (QLog.isColorLevel()) {
                }
                this.f207349d.getFileManagerNotifyCenter().c(this.P, this.Q, this.f207363m, this.C, 11, new Object[]{this.f207353f, Long.valueOf(this.R), Boolean.TRUE, this.D}, 0, null);
                long currentTimeMillis2 = System.currentTimeMillis();
                this.f207348c0 = currentTimeMillis2;
                QQAppInterface qQAppInterface22 = this.f207349d;
                FileManagerEntity fileManagerEntity62 = this.f207346a0;
                Bundle bundle32 = bundle;
                FileManagerUtil.reportFilemanagerSuccessInfoEx(qQAppInterface22, fileManagerEntity62.nSessionId, this.f207357h0, currentTimeMillis2 - this.f207347b0, this.D, this.f207363m, this.E, fileManagerEntity62.strFileMd5, this.f207366o0, this.K, this.R, this.f207372u0, null, bundle32);
                QQAppInterface qQAppInterface32 = this.f207349d;
                FileManagerEntity fileManagerEntity72 = this.f207346a0;
                FileManagerUtil.reportFilemanagerSuccessInfoEx(qQAppInterface32, fileManagerEntity72.nSessionId, this.f207359i0, this.f207348c0 - this.f207347b0, this.D, this.f207363m, this.E, fileManagerEntity72.strFileMd5, this.f207366o0, this.K, this.R, this.f207372u0, null, bundle32);
                FileManagerEntity fileManagerEntity82 = this.f207346a0;
                i3 = fileManagerEntity82.nFileType;
                if (i3 != 0) {
                }
                FileManagerUtil.fixEntityThumbSize(this.f207346a0);
                if (this.f207346a0.isZipInnerFile) {
                }
                FileManagerReporter.a aVar2 = new FileManagerReporter.a();
                aVar2.f209157b = "rece_file_suc";
                aVar2.f209158c = 1;
                FileManagerReporter.addData(this.f207349d.getCurrentAccountUin(), aVar2);
            }
            try {
                FileManagerUtil.reportFilemanagerFaildInfoEx(qQAppInterface, j3, str8, j16, str9, this.f207363m, this.E, fileManagerEntity3.strFileMd5, 9003L, "", this.f207366o0, this.K, this.R, str9, "", this.f207369r0, "rename error", null, bundle);
                QQAppInterface qQAppInterface4 = this.f207349d;
                FileManagerEntity fileManagerEntity9 = this.f207346a0;
                long j17 = fileManagerEntity9.nSessionId;
                String str10 = this.f207359i0;
                long j18 = this.f207347b0;
                String str11 = this.f207373v0;
                FileManagerUtil.reportFilemanagerFaildInfoEx(qQAppInterface4, j17, str10, j18, str11, this.f207363m, this.E, fileManagerEntity9.strFileMd5, 9003L, "", this.f207366o0, this.K, this.R, str11, "", this.f207372u0, "rename error", null, bundle);
                handleError(null, null);
                return;
            } catch (Exception unused4) {
                StringBuilder sb522 = new StringBuilder();
                sb522.append(str2);
                sb522.append(this.f207346a0.nSessionId);
                str6 = str;
                sb522.append(str6);
                str5 = str3;
                QLog.e(str5, 1, sb522.toString());
                bytes2HexStr = com.qq.taf.jce.HexUtil.bytes2HexStr(FileManagerUtil.getMd5(this.f207353f));
                if (bytes2HexStr != null) {
                }
                this.f207346a0.setFilePath(this.f207353f);
                this.f207346a0.fileName = FileManagerUtil.getFileName(this.f207353f);
                FileManagerEntity fileManagerEntity422 = this.f207346a0;
                fileManagerEntity422.nFileType = FileManagerUtil.getFileType(fileManagerEntity422.fileName);
                fileManagerEntity = this.f207346a0;
                if (fileManagerEntity.nFileType == 0) {
                }
                this.f207346a0.localModifyTime = new File(this.f207353f).lastModified();
                FileManagerEntity fileManagerEntity522 = this.f207346a0;
                fileManagerEntity522.status = 1;
                fileManagerEntity522.setCloudType(3);
                h0(2003);
                if (QLog.isColorLevel()) {
                }
                this.f207349d.getFileManagerNotifyCenter().c(this.P, this.Q, this.f207363m, this.C, 11, new Object[]{this.f207353f, Long.valueOf(this.R), Boolean.TRUE, this.D}, 0, null);
                long currentTimeMillis22 = System.currentTimeMillis();
                this.f207348c0 = currentTimeMillis22;
                QQAppInterface qQAppInterface222 = this.f207349d;
                FileManagerEntity fileManagerEntity622 = this.f207346a0;
                Bundle bundle322 = bundle;
                FileManagerUtil.reportFilemanagerSuccessInfoEx(qQAppInterface222, fileManagerEntity622.nSessionId, this.f207357h0, currentTimeMillis22 - this.f207347b0, this.D, this.f207363m, this.E, fileManagerEntity622.strFileMd5, this.f207366o0, this.K, this.R, this.f207372u0, null, bundle322);
                QQAppInterface qQAppInterface322 = this.f207349d;
                FileManagerEntity fileManagerEntity722 = this.f207346a0;
                FileManagerUtil.reportFilemanagerSuccessInfoEx(qQAppInterface322, fileManagerEntity722.nSessionId, this.f207359i0, this.f207348c0 - this.f207347b0, this.D, this.f207363m, this.E, fileManagerEntity722.strFileMd5, this.f207366o0, this.K, this.R, this.f207372u0, null, bundle322);
                FileManagerEntity fileManagerEntity822 = this.f207346a0;
                i3 = fileManagerEntity822.nFileType;
                if (i3 != 0) {
                }
                FileManagerUtil.fixEntityThumbSize(this.f207346a0);
                if (this.f207346a0.isZipInnerFile) {
                }
                FileManagerReporter.a aVar22 = new FileManagerReporter.a();
                aVar22.f209157b = "rece_file_suc";
                aVar22.f209158c = 1;
                FileManagerReporter.addData(this.f207349d.getCurrentAccountUin(), aVar22);
            }
        }
        bundle = bundle2;
        str4 = "]";
        str6 = "]equalsIgnoreCase md5 success,";
        str5 = "FileManagerRSWorker<FileAssistant>";
        bytes2HexStr = com.qq.taf.jce.HexUtil.bytes2HexStr(FileManagerUtil.getMd5(this.f207353f));
        if (bytes2HexStr != null) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("Id[");
            sb6.append(this.f207346a0.nSessionId);
            sb6.append("] mathMd5 is null,FileMd5[");
            sb6.append(this.f207346a0.strFileMd5);
            str7 = str4;
            sb6.append(str7);
            QLog.e(str5, 1, sb6.toString());
            QQAppInterface qQAppInterface5 = this.f207349d;
            FileManagerEntity fileManagerEntity10 = this.f207346a0;
            long j19 = fileManagerEntity10.nSessionId;
            String str12 = this.f207359i0;
            long j26 = this.f207347b0;
            String str13 = this.f207373v0;
            FileManagerUtil.reportFilemanagerFaildInfoEx(qQAppInterface5, j19, str12, j26, str13, this.f207363m, this.E, fileManagerEntity10.strFileMd5, 9082L, "mathMd5 is null", this.f207366o0, this.K, this.R, str13, "", this.f207372u0, "rename error", null, bundle);
        } else {
            str7 = str4;
            String str14 = this.f207346a0.strFileMd5;
            if (str14 != null && str14.length() > 0 && !bytes2HexStr.equalsIgnoreCase(this.f207346a0.strFileMd5)) {
                QLog.e(str5, 1, "Id[" + this.f207346a0.nSessionId + "] mathMd5 is null,FileMd5[" + this.f207346a0.strFileMd5 + str7);
                QQAppInterface qQAppInterface6 = this.f207349d;
                FileManagerEntity fileManagerEntity11 = this.f207346a0;
                long j27 = fileManagerEntity11.nSessionId;
                String str15 = this.f207359i0;
                long j28 = this.f207347b0;
                String str16 = this.f207373v0;
                FileManagerUtil.reportFilemanagerFaildInfoEx(qQAppInterface6, j27, str15, j28, str16, this.f207363m, this.E, fileManagerEntity11.strFileMd5, 9082L, "md5 is not equal", this.f207366o0, this.K, this.R, str16, "", this.f207372u0, "rename error", null, bundle);
            } else {
                QLog.i(str5, 1, "Id[" + this.f207346a0.nSessionId + str6);
            }
        }
        this.f207346a0.setFilePath(this.f207353f);
        this.f207346a0.fileName = FileManagerUtil.getFileName(this.f207353f);
        FileManagerEntity fileManagerEntity4222 = this.f207346a0;
        fileManagerEntity4222.nFileType = FileManagerUtil.getFileType(fileManagerEntity4222.fileName);
        fileManagerEntity = this.f207346a0;
        if (fileManagerEntity.nFileType == 0) {
            fileManagerEntity.strFileSha3 = vb1.a.b(FileManagerUtil.getSha3(this.f207353f));
            FileManagerEntity fileManagerEntity12 = this.f207346a0;
            if (fileManagerEntity12.fileSize < GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT) {
                fileManagerEntity12.strFileSHA = vb1.a.b(FileManagerUtil.getSHA(this.f207353f));
            }
        }
        this.f207346a0.localModifyTime = new File(this.f207353f).lastModified();
        FileManagerEntity fileManagerEntity5222 = this.f207346a0;
        fileManagerEntity5222.status = 1;
        fileManagerEntity5222.setCloudType(3);
        h0(2003);
        if (QLog.isColorLevel()) {
            QLog.i(str5, 2, "Id[" + String.valueOf(this.Q) + "]recive success, set TrafficData,size[" + String.valueOf(this.K) + str7);
        }
        this.f207349d.getFileManagerNotifyCenter().c(this.P, this.Q, this.f207363m, this.C, 11, new Object[]{this.f207353f, Long.valueOf(this.R), Boolean.TRUE, this.D}, 0, null);
        long currentTimeMillis222 = System.currentTimeMillis();
        this.f207348c0 = currentTimeMillis222;
        QQAppInterface qQAppInterface2222 = this.f207349d;
        FileManagerEntity fileManagerEntity6222 = this.f207346a0;
        Bundle bundle3222 = bundle;
        FileManagerUtil.reportFilemanagerSuccessInfoEx(qQAppInterface2222, fileManagerEntity6222.nSessionId, this.f207357h0, currentTimeMillis222 - this.f207347b0, this.D, this.f207363m, this.E, fileManagerEntity6222.strFileMd5, this.f207366o0, this.K, this.R, this.f207372u0, null, bundle3222);
        QQAppInterface qQAppInterface3222 = this.f207349d;
        FileManagerEntity fileManagerEntity7222 = this.f207346a0;
        FileManagerUtil.reportFilemanagerSuccessInfoEx(qQAppInterface3222, fileManagerEntity7222.nSessionId, this.f207359i0, this.f207348c0 - this.f207347b0, this.D, this.f207363m, this.E, fileManagerEntity7222.strFileMd5, this.f207366o0, this.K, this.R, this.f207372u0, null, bundle3222);
        FileManagerEntity fileManagerEntity8222 = this.f207346a0;
        i3 = fileManagerEntity8222.nFileType;
        if (i3 != 0) {
            FilePicURLDrawlableHelper.e(fileManagerEntity8222);
            FilePicURLDrawlableHelper.k(this.f207346a0);
        } else if (i3 == 2) {
            FileManagerUtil.createMediThumbnail(fileManagerEntity8222);
        } else if (i3 == 5) {
            this.f207349d.getFileManagerEngine().Q().l(this.f207346a0);
        }
        FileManagerUtil.fixEntityThumbSize(this.f207346a0);
        if (this.f207346a0.isZipInnerFile) {
            Bundle bundle4 = new Bundle();
            bundle4.putString("FILE_TMP_SERVER_PATH", this.f207346a0.strServerPath);
            bundle4.putLong("FILE_TMP_RELATED_ID", this.f207346a0.nRelatedSessionId);
            bundle4.putString("FILE_TMP_DIR_PATH", this.f207346a0.zipInnerPath);
            bundle4.putBoolean("FILE_TMP_IS_ZIPINNER_FILE", true);
            bundle4.putString("FILE_TMP_ZIP_FILEID", this.f207346a0.zipFileId);
            this.f207349d.getFileManagerDataCenter().s(null, -1, this.f207353f, this.R, 190, null, bundle4);
        }
        FileManagerReporter.a aVar222 = new FileManagerReporter.a();
        aVar222.f209157b = "rece_file_suc";
        aVar222.f209158c = 1;
        FileManagerReporter.addData(this.f207349d.getCurrentAccountUin(), aVar222);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        long c16;
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            FileManagerEntity fileManagerEntity = this.f207346a0;
            fileManagerEntity.status = 0;
            fileManagerEntity.isReaded = false;
            this.f207349d.getFileManagerNotifyCenter().c(this.P, this.Q, this.f207363m, this.C, 36, null, 11, null);
            QLog.e("FileManagerRSWorker<FileAssistant>", 1, "net work error");
            this.f207349d.getFileManagerDataCenter().c0();
            QQAppInterface qQAppInterface = this.f207349d;
            FileManagerEntity fileManagerEntity2 = this.f207346a0;
            FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface, fileManagerEntity2.nSessionId, this.f207357h0, this.f207347b0, "", "", "", "", 9004L, "", 0L, 0L, fileManagerEntity2.fileSize, "", "", 0, RaffleJsPlugin.ERROR_REPORT_NO_NETWORK, null);
            return;
        }
        long j3 = this.R - this.K;
        if (cu.e()) {
            c16 = cu.b();
        } else {
            c16 = cu.c();
        }
        long j16 = c16 * 1024;
        if (j16 < j3) {
            QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.Q + "]downLoadWeiYunFile local space no enough!! [downsize:" + j3 + "sdcardsize:" + j16 + "]");
            FileManagerEntity fileManagerEntity3 = this.f207346a0;
            fileManagerEntity3.status = 0;
            fileManagerEntity3.isReaded = false;
            this.f207349d.getFileManagerDataCenter().c0();
            this.f207349d.getFileManagerNotifyCenter().c(this.P, this.Q, this.f207363m, this.C, 36, null, 12, null);
            QQAppInterface qQAppInterface2 = this.f207349d;
            FileManagerEntity fileManagerEntity4 = this.f207346a0;
            long j17 = fileManagerEntity4.nSessionId;
            String str = this.f207357h0;
            long j18 = this.f207347b0;
            long j19 = this.K;
            FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface2, j17, str, j18, "", "", "", "", 9040L, "", j19, j19, fileManagerEntity4.fileSize, "", "", 0, "sdcard full", null);
            return;
        }
        FileManagerEntity fileManagerEntity5 = this.f207346a0;
        this.R = fileManagerEntity5.fileSize;
        com.tencent.mobileqq.filemanageraux.core.d g16 = this.f207349d.getFileManagerEngine().Y().g(fileManagerEntity5, null, new a(fileManagerEntity5));
        this.f207376y0 = g16;
        if (g16 != null) {
            g16.b(fileManagerEntity5.WeiYunFileId);
        }
    }

    public String A() {
        boolean z16;
        String defaultRecvPath = this.f207354f0.getDefaultRecvPath();
        boolean z17 = true;
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(this.Q) + "]getTransferFilePath dir: " + defaultRecvPath);
        File file = new File(defaultRecvPath);
        if (!file.exists()) {
            z16 = file.mkdirs();
        } else {
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.i("FileManagerRSWorker<FileAssistant>", 2, "id[" + this.Q + "]getRecvDir[" + z16 + "]");
        }
        this.f207356h = this.f207354f0.getDefaultTmpPath();
        File file2 = new File(this.f207356h);
        if (!file2.exists()) {
            z17 = file2.mkdirs();
        }
        if (QLog.isColorLevel()) {
            QLog.i("FileManagerRSWorker<FileAssistant>", 2, "id[" + this.Q + "]getTmpDir[" + z17 + "]");
        }
        return this.f207356h;
    }

    byte[] G(long j3, int i3) {
        if (this.U == null) {
            try {
                this.U = new FileInputStream(this.f207353f);
                this.f207377z0 = 0L;
            } catch (FileNotFoundException e16) {
                this.U = null;
                e16.printStackTrace();
                return null;
            }
        }
        if (j3 == 0) {
            if (this.f207377z0 != 0) {
                try {
                    this.U = new FileInputStream(this.f207353f);
                    this.f207377z0 = 0L;
                } catch (FileNotFoundException e17) {
                    this.U = null;
                    e17.printStackTrace();
                    return null;
                }
            }
        } else {
            long j16 = this.f207377z0;
            if (j3 > j16) {
                try {
                    this.U.skip(j3 - j16);
                } catch (IOException e18) {
                    e18.printStackTrace();
                    return null;
                }
            } else if (j3 < j16) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(this.f207353f);
                    this.U = fileInputStream;
                    this.f207377z0 = 0L;
                    fileInputStream.skip(j3);
                } catch (IOException e19) {
                    this.U = null;
                    e19.printStackTrace();
                    return null;
                }
            }
        }
        this.f207377z0 = j3;
        byte[] bArr = new byte[i3];
        try {
            this.U.read(bArr, 0, i3);
            this.f207377z0 += i3;
            return bArr;
        } catch (Exception unused) {
            return null;
        }
    }

    public String I(String str, String str2) {
        String defaultRecvPath = this.f207354f0.getDefaultRecvPath();
        if (str2 == null) {
            str2 = H();
        }
        File file = new File(defaultRecvPath + str2);
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(this.Q) + "]getTransferFilePath : " + file.getAbsoluteFile().toString());
        return file.getAbsoluteFile().toString();
    }

    @Override // vb1.b
    public FileManagerEntity W() {
        return this.f207346a0;
    }

    public void Z() {
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v> [CS Send] Id[" + this.Q + "],call receive");
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            h0(0);
            this.f207349d.getFileManagerNotifyCenter().c(this.P, this.Q, this.f207363m, this.C, 1, null, 2, null);
            QQAppInterface qQAppInterface = this.f207349d;
            FileManagerEntity fileManagerEntity = this.f207346a0;
            FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface, fileManagerEntity.nSessionId, this.f207357h0, this.f207347b0, this.f207373v0, this.f207363m, this.E, fileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.R, "", "", this.f207369r0, "NoNetWork", null);
            QQAppInterface qQAppInterface2 = this.f207349d;
            FileManagerEntity fileManagerEntity2 = this.f207346a0;
            FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface2, fileManagerEntity2.nSessionId, this.f207359i0, this.f207347b0, this.f207373v0, this.f207363m, this.E, fileManagerEntity2.strFileMd5, 9004L, "", 0L, 0L, this.R, "", "", this.f207372u0, "NoNetWork", null);
            QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v>! [CS Send] Id[" + this.Q + "],no network!");
            return;
        }
        if (q.f(this.f207346a0.getFilePath())) {
            QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v>! [CS Send] Id[" + this.Q + "],file exists!!");
            x();
            return;
        }
        this.f207361k0 = false;
        this.f207362l0 = null;
        String str = this.E;
        if (str != null && str.length() != 0) {
            int i3 = this.C;
            if (i3 == 3000) {
                QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v> [CS Send] Id[" + this.Q + "],Send getDiscFileInfo CS\uff01");
                try {
                    FileTransferHandler fileTransferHandler = this.f207349d.getFileTransferHandler();
                    FileManagerEntity fileManagerEntity3 = this.f207346a0;
                    fileTransferHandler.F(fileManagerEntity3.nSessionId, fileManagerEntity3.fileName, Long.parseLong(fileManagerEntity3.peerUin), this.f207346a0.Uuid, this.f207365n0);
                    return;
                } catch (Exception unused) {
                    c(null, 0);
                    return;
                }
            }
            if (i3 == com.tencent.mobileqq.filemanager.data.e.f207742a) {
                a0(true);
                return;
            }
            QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v> [CS Send] Id[" + this.Q + "],Send getDownloadInfo CS\uff01");
            boolean isEnableHttpsDownload4C2C = ((IFMConfig) QRoute.api(IFMConfig.class)).isEnableHttpsDownload4C2C(this.f207349d);
            FileTransferHandler fileTransferHandler2 = this.f207349d.getFileTransferHandler();
            String str2 = this.E;
            FileManagerEntity fileManagerEntity4 = this.f207346a0;
            fileTransferHandler2.H(str2, fileManagerEntity4.fileIdCrc, fileManagerEntity4.bSend, isEnableHttpsDownload4C2C, this.f207365n0);
            return;
        }
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v> [CS Send] Id[" + this.Q + "],uuid is null! : " + FileManagerUtil.printFileManagerEntityInfo(this.f207346a0));
        a0(false);
    }

    @Override // vb1.b
    public boolean a() {
        boolean z16;
        synchronized (this) {
            z16 = this.Z;
        }
        return z16;
    }

    public void a0(boolean z16) {
        String str;
        long c16;
        int i3;
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v>!!!! [Http Downlaod] Id[" + this.Q + "],is oldMsg?");
        if (a()) {
            QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v>! [Http Downlaod] Id[" + this.Q + "],no network");
            return;
        }
        if (!TextUtils.isEmpty(this.f207346a0.strServerPath)) {
            this.D = this.f207346a0.strServerPath;
        }
        if (TextUtils.isEmpty(this.D)) {
            QLog.e("FileManagerRSWorker<FileAssistant>", 1, "id[" + String.valueOf(this.Q) + "] get old offlinefile info is error! serverPath is empty");
            if (q.f(this.f207346a0.getFilePath())) {
                this.f207346a0.setCloudType(3);
                this.f207346a0.status = 1;
                this.f207349d.getFileManagerNotifyCenter().c(this.P, this.Q, this.f207363m, this.C, 11, new Object[]{this.f207353f, Long.valueOf(this.R), Boolean.TRUE, this.D}, 0, null);
                QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v> [Http Downlaod] Id[" + this.Q + "], filee Exists");
                return;
            }
            this.f207346a0.status = 16;
            h0(2005);
            this.f207349d.getFileManagerNotifyCenter().c(this.P, this.Q, this.f207363m, this.C, 12, null, 6, null);
            int i16 = this.f207346a0.nWeiYunSrcType;
            if (i16 == -1) {
                i3 = FileMsg.RESULT_CODE_WY_OFLINE_UUID_NULL;
            } else if (i16 == -2) {
                i3 = FileMsg.RESULT_CODE_A9_OFLINE_UUID_NULL;
            } else {
                i3 = AppConstants.RichMediaErrorCode.ERROR_EXP_ILLEGAL_ARGUMENT;
            }
            QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Http Downlaod] Id[" + this.Q + "], errCode[" + i3 + "]");
            return;
        }
        this.f207358i = this.f207353f + ".tmp";
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Http Downlaod] Id[" + this.Q + "], no network");
            h0(2005);
            this.f207349d.getFileManagerNotifyCenter().c(this.P, this.Q, this.f207363m, this.C, 1, null, 2, null);
            QQAppInterface qQAppInterface = this.f207349d;
            FileManagerEntity fileManagerEntity = this.f207346a0;
            FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface, fileManagerEntity.nSessionId, this.f207357h0, this.f207347b0, this.f207373v0, this.f207363m, this.E, fileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.R, "", "", this.f207369r0, "NoNetWork", null);
            QQAppInterface qQAppInterface2 = this.f207349d;
            FileManagerEntity fileManagerEntity2 = this.f207346a0;
            FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface2, fileManagerEntity2.nSessionId, this.f207359i0, this.f207347b0, this.f207373v0, this.f207363m, this.E, fileManagerEntity2.strFileMd5, 9004L, "", 0L, 0L, this.R, "", "", this.f207372u0, "NoNetWork", null);
            return;
        }
        long fileSizes = FileManagerUtil.getFileSizes(this.f207358i);
        this.K = fileSizes;
        long j3 = this.R;
        if (fileSizes == j3) {
            QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Http Downlaod] Id[" + this.Q + "], id downloaded");
            this.f207346a0.setCloudType(3);
            h0(2003);
            this.f207349d.getFileManagerNotifyCenter().c(this.P, this.Q, this.f207363m, this.C, 11, new Object[]{this.f207353f, Long.valueOf(this.R), Boolean.TRUE, this.D}, 0, null);
            this.f207346a0.fileName = FileManagerUtil.getFileName(this.f207353f);
            if (this.f207346a0.fileName.getBytes().length > 250) {
                FileManagerEntity fileManagerEntity3 = this.f207346a0;
                fileManagerEntity3.fileName = FileManagerUtil.cutLongName(fileManagerEntity3.fileName);
                this.f207353f = I(this.f207363m, this.f207346a0.fileName);
            }
            if (FileUtils.fileExists(this.f207353f)) {
                this.f207353f = FileManagerUtil.recreateFilePath(this.f207353f);
            }
            FileManagerUtil.renameFile(new File(this.f207358i), new File(this.f207353f));
            this.f207346a0.fileName = FileManagerUtil.getFileName(this.f207353f);
            QQAppInterface qQAppInterface3 = this.f207349d;
            FileManagerEntity fileManagerEntity4 = this.f207346a0;
            FileManagerUtil.reportFilemanagerSuccessInfo(qQAppInterface3, fileManagerEntity4.nSessionId, this.f207357h0, 0L, this.D, this.f207363m, this.E, fileManagerEntity4.strFileMd5, 0L, 0L, this.R, this.f207369r0, null);
            return;
        }
        if (j3 > fileSizes) {
            long j16 = j3 - fileSizes;
            if (cu.e()) {
                c16 = cu.b();
            } else {
                c16 = cu.c();
            }
            long j17 = c16 * 1024;
            if (j17 < j16) {
                QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Http Downlaod]Id[" + String.valueOf(this.Q) + "]local sdcard space no enough!! [downsize:" + j16 + "mobile space:" + j17 + "]");
                h0(2005);
                this.f207349d.getFileManagerNotifyCenter().c(this.P, this.Q, this.f207363m, this.C, 12, null, 12, null);
                QQAppInterface qQAppInterface4 = this.f207349d;
                FileManagerEntity fileManagerEntity5 = this.f207346a0;
                long j18 = fileManagerEntity5.nSessionId;
                String str2 = this.f207357h0;
                long j19 = this.f207347b0;
                String str3 = this.f207373v0;
                FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface4, j18, str2, j19, str3, this.f207363m, this.E, fileManagerEntity5.strFileMd5, 9040L, "", this.f207366o0, this.K, this.R, str3, "", this.f207369r0, "sdcard full", null);
                QQAppInterface qQAppInterface5 = this.f207349d;
                FileManagerEntity fileManagerEntity6 = this.f207346a0;
                long j26 = fileManagerEntity6.nSessionId;
                String str4 = this.f207359i0;
                long j27 = this.f207347b0;
                String str5 = this.f207373v0;
                FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface5, j26, str4, j27, str5, this.f207363m, this.E, fileManagerEntity6.strFileMd5, 9040L, "", this.f207366o0, this.K, this.R, str5, "", this.f207372u0, "sdcard full", null);
                return;
            }
        }
        if (this.T == null) {
            try {
                this.T = new FileOutputStream(this.f207358i, true);
            } catch (FileNotFoundException unused) {
            }
        }
        if (this.J == 1) {
            this.f207349d.getFileManagerDataCenter().a0(this.Q, 2002);
        }
        this.f207346a0.status = 0;
        this.f207349d.getFileManagerDataCenter().f0(this.f207346a0);
        FileManagerEntity fileManagerEntity7 = this.f207346a0;
        fileManagerEntity7.status = 2;
        boolean z17 = fileManagerEntity7.isZipInnerFile;
        if (!z17 || (str = fileManagerEntity7.WeiYunFileId) == null) {
            str = null;
        }
        if (z17 && this.D.toLowerCase().startsWith("https")) {
            this.f207361k0 = true;
            this.f207362l0 = this.f207346a0.httpsDomain;
        }
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v>ReceiveOfflineForOldMsg Id[" + this.Q + "], mUseHttps:" + this.f207361k0 + " mHttpsDomain:" + this.f207362l0);
        Y(this.K, str, z16);
    }

    @Override // vb1.b
    public void b() {
        synchronized (this) {
            this.Z = true;
        }
        Runnable runnable = this.Y;
        if (runnable != null) {
            ThreadManagerV2.removeJobFromThreadPool(runnable, 64);
        }
        try {
            this.U.close();
            this.U = null;
        } catch (Exception unused) {
        }
        if (this.I != null) {
            if (QLog.isColorLevel()) {
                QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.Q) + "]stop serial[" + String.valueOf(this.I.getSerial()) + "]");
            }
            ((IOldHttpEngineProcessor) QRoute.api(IOldHttpEngineProcessor.class)).cancelMsg(this.I);
        }
        if (this.f207376y0 != null) {
            if (QLog.isColorLevel()) {
                QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.Q) + "]WeiyunFile stop!!!");
            }
            this.f207376y0.a();
        }
    }

    @Override // vb1.b
    public void c(Object obj, int i3) {
        int i16;
        HttpMsg httpMsg = (HttpMsg) obj;
        int i17 = this.J;
        int i18 = 16;
        if (i17 != 0) {
            if (i17 != 1) {
                if (i17 != 5) {
                    if (i17 != 6) {
                        if (i17 != 8) {
                            if (i17 != 50) {
                                if (i17 != 54) {
                                    QLog.e("FileManagerRSWorker<FileAssistant>", 1, "why actionType is out?!");
                                    return;
                                }
                            }
                        } else {
                            FileManagerEntity fileManagerEntity = this.f207346a0;
                            fileManagerEntity.isReaded = false;
                            fileManagerEntity.fProgress = ((float) this.K) / ((float) fileManagerEntity.fileSize);
                            if (fileManagerEntity.status != 16) {
                                i18 = 0;
                            }
                            fileManagerEntity.status = i18;
                            fileManagerEntity.Uuid = this.E;
                            this.f207349d.getFileManagerDataCenter().f0(this.f207346a0);
                            this.f207349d.getFileManagerDataCenter().c0();
                            this.f207349d.getFileManagerNotifyCenter().c(this.P, this.Q, this.f207363m, this.C, 12, null, 6, null);
                        }
                    } else {
                        FileManagerEntity fileManagerEntity2 = this.f207346a0;
                        if (fileManagerEntity2.status != 16) {
                            i18 = 0;
                        }
                        fileManagerEntity2.status = i18;
                        fileManagerEntity2.isReaded = false;
                        this.f207349d.getFileManagerDataCenter().c0();
                        this.f207349d.getFileManagerDataCenter().f0(this.f207346a0);
                        this.f207349d.getFileManagerNotifyCenter().c(this.P, this.Q, this.f207363m, this.C, 38, null, 11, null);
                    }
                }
                FileManagerEntity fileManagerEntity3 = this.f207346a0;
                if (fileManagerEntity3.status != 16) {
                    i18 = 0;
                }
                fileManagerEntity3.status = i18;
                fileManagerEntity3.isReaded = false;
                this.f207349d.getFileManagerDataCenter().c0();
                this.f207349d.getFileManagerDataCenter().f0(this.f207346a0);
                this.f207349d.getFileManagerNotifyCenter().c(this.P, this.Q, this.f207363m, this.C, 36, null, 11, null);
            }
            this.f207346a0.isReaded = false;
            this.f207349d.getFileManagerDataCenter().c0();
            FileManagerEntity fileManagerEntity4 = this.f207346a0;
            fileManagerEntity4.isReaded = false;
            if (fileManagerEntity4.status != 16) {
                i18 = 0;
            }
            fileManagerEntity4.status = i18;
            fileManagerEntity4.fProgress = ((float) this.K) / ((float) this.R);
            fileManagerEntity4.uniseq = this.P;
            fileManagerEntity4.Uuid = this.E;
            this.f207349d.getFileManagerDataCenter().f0(this.f207346a0);
            this.f207349d.getFileManagerNotifyCenter().c(this.P, this.Q, this.f207363m, this.C, 12, null, 6, null);
        } else {
            this.f207349d.getFileManagerDataCenter().c0();
            FileManagerEntity fileManagerEntity5 = this.f207346a0;
            fileManagerEntity5.isReaded = false;
            if (fileManagerEntity5.status != 16) {
                i18 = 0;
            }
            fileManagerEntity5.status = i18;
            fileManagerEntity5.fProgress = ((float) this.K) / ((float) this.R);
            fileManagerEntity5.uniseq = this.P;
            fileManagerEntity5.Uuid = this.E;
            this.f207349d.getFileManagerDataCenter().f0(this.f207346a0);
            this.f207349d.getFileManagerNotifyCenter().c(this.P, this.Q, this.f207363m, this.C, 15, null, 5, null);
        }
        if (httpMsg == null) {
            return;
        }
        String errorString = httpMsg.getErrorString();
        if (i3 == 0 && errorString == null) {
            errorString = "[Http_RespValue_Null]" + FileManagerUtil.printStack();
            i16 = 9001;
        } else {
            i16 = i3;
        }
        if (errorString == null) {
            errorString = "errMsgString_NUll_retCode[" + i16 + "]";
        }
        if (errorString.indexOf("-6101") > 0) {
            i16 = 9042;
        }
        if (errorString.contains("HTTP_PROXY_AUTH")) {
            i16 = 9004;
        }
        QQAppInterface qQAppInterface = this.f207349d;
        FileManagerEntity fileManagerEntity6 = this.f207346a0;
        FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface, fileManagerEntity6.nSessionId, this.f207357h0, this.f207347b0, this.f207373v0, this.f207363m, this.E, fileManagerEntity6.strFileMd5, i16, String.valueOf(httpMsg.getSerial()), this.f207366o0, this.K, this.R, httpMsg.getRealUrl(), httpMsg.rawRespHeader, this.f207372u0, errorString, null);
        this.f207349d.getFileManagerDataCenter().f0(this.f207346a0);
    }

    void c0(String str, long j3) {
        if (a()) {
            QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [Upload Step], working stoped!");
            return;
        }
        if (j3 == 0) {
            this.K = 0L;
        }
        int d16 = this.V.d(BaseApplication.getContext(), this.R, j3, 1048576);
        int b16 = com.tencent.wstt.SSCM.c.b(BaseApplication.getContext());
        if ((b16 == 1 || b16 == 2) && d16 > 16384) {
            d16 = 16384;
        }
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "sendFilePakage transferedSize[" + j3 + "], packetSize[" + d16 + "]");
        d0(str, j3, d16);
    }

    @Override // vb1.b
    public void d() {
        b();
    }

    @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
    public void decode(HttpMsg httpMsg, HttpMsg httpMsg2) {
        String str;
        int[] iArr;
        int i3;
        int[] iArr2 = this.N;
        synchronized (iArr2) {
            try {
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                Bundle bundle = new Bundle();
                try {
                } catch (Exception e16) {
                    e16.printStackTrace();
                    QLog.e("FileManagerRSWorker<FileAssistant>", 1, e16.toString());
                    String str2 = "";
                    for (StackTraceElement stackTraceElement : e16.getStackTrace()) {
                        str2 = str2 + stackTraceElement + ContainerUtils.FIELD_DELIMITER;
                    }
                    String str3 = "";
                    if (httpMsg != null) {
                        str3 = httpMsg.getRealUrl();
                    }
                    if (httpMsg2 == null) {
                        str = "";
                    } else {
                        str = httpMsg2.rawRespHeader;
                    }
                    QQAppInterface qQAppInterface = this.f207349d;
                    FileManagerEntity fileManagerEntity = this.f207346a0;
                    String str4 = str2;
                    FileManagerUtil.reportFilemanagerFaildInfoEx(qQAppInterface, fileManagerEntity.nSessionId, this.f207357h0, this.f207347b0, this.f207373v0, this.f207363m, this.E, fileManagerEntity.strFileMd5, 9001L, null, this.f207366o0, this.K, this.R, str3, str, this.f207372u0, str4, null, bundle);
                    QQAppInterface qQAppInterface2 = this.f207349d;
                    FileManagerEntity fileManagerEntity2 = this.f207346a0;
                    iArr = iArr2;
                    FileManagerUtil.reportFilemanagerFaildInfoEx(qQAppInterface2, fileManagerEntity2.nSessionId, this.f207359i0, this.f207347b0, this.f207373v0, this.f207363m, this.E, fileManagerEntity2.strFileMd5, 9001L, null, this.f207366o0, this.K, this.R, str3, str, this.f207372u0, str4, null, bundle);
                    handleError(null, null);
                }
                if (R(httpMsg)) {
                    return;
                }
                if (this.J != 0) {
                    bundle.putInt("param_V6SelectType", this.f207355g0);
                    bundle.putInt("param_ipAddrType", B());
                    if (this.f207361k0) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    bundle.putInt("param_ishttps", i3);
                    if (b0(httpMsg2, bundle)) {
                        return;
                    }
                }
                iArr = iArr2;
            } catch (Throwable th6) {
                th = th6;
                throw th;
            }
        }
    }

    @Override // vb1.b
    public void e() {
        com.tencent.mobileqq.filemanageraux.core.d dVar;
        com.tencent.mobileqq.filemanageraux.core.d dVar2;
        com.tencent.mobileqq.filemanageraux.core.d dVar3;
        b();
        FileManagerEntity fileManagerEntity = this.f207346a0;
        if (fileManagerEntity != null && fileManagerEntity.status == 1) {
            if (QLog.isColorLevel()) {
                QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.Q) + "] is Successed, return!");
                return;
            }
            return;
        }
        int i3 = this.J;
        if (i3 == 0 && fileManagerEntity != null) {
            h0(1004);
        } else if (1 == i3 && fileManagerEntity != null) {
            h0(2004);
        } else if (5 == i3 && (dVar3 = this.f207376y0) != null) {
            dVar3.a();
        } else if (6 == i3 && (dVar2 = this.f207376y0) != null) {
            dVar2.a();
        } else if (50 == i3 && (dVar = this.f207376y0) != null) {
            dVar.a();
        }
        FileManagerEntity fileManagerEntity2 = this.f207346a0;
        if (fileManagerEntity2 != null) {
            fileManagerEntity2.status = 3;
            fileManagerEntity2.fProgress = ((float) this.K) / ((float) fileManagerEntity2.fileSize);
            this.f207349d.getFileManagerDataCenter().f0(this.f207346a0);
            this.f207349d.getFileManagerNotifyCenter().b(true, 3, null);
            if (QLog.isColorLevel()) {
                QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.Q) + "]stop for pause!");
            }
            String str = "Now[" + String.valueOf(System.currentTimeMillis()) + "]startTime[" + String.valueOf(this.f207347b0) + "]notifyTime[" + String.valueOf(this.X) + "]C2CTime[" + String.valueOf(this.f207367p0) + "]";
            QQAppInterface qQAppInterface = this.f207349d;
            FileManagerEntity fileManagerEntity3 = this.f207346a0;
            long j3 = fileManagerEntity3.nSessionId;
            String str2 = this.f207357h0;
            long j16 = this.f207347b0;
            String str3 = this.f207373v0;
            FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface, j3, str2, j16, str3, this.f207363m, this.E, fileManagerEntity3.strFileMd5, 9037L, "", this.f207366o0, this.K, this.R, str3, "", this.f207369r0, str, null);
            QQAppInterface qQAppInterface2 = this.f207349d;
            FileManagerEntity fileManagerEntity4 = this.f207346a0;
            long j17 = fileManagerEntity4.nSessionId;
            String str4 = this.f207359i0;
            long j18 = this.f207347b0;
            String str5 = this.f207373v0;
            FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface2, j17, str4, j18, str5, this.f207363m, this.E, fileManagerEntity4.strFileMd5, 9037L, "", this.f207366o0, this.K, this.R, str5, "", this.f207372u0, str, null);
        }
    }

    boolean e0() {
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^ [CS Step],send LocalFile");
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            h0(0);
            this.f207349d.getFileManagerNotifyCenter().c(this.P, this.Q, this.f207363m, this.C, 1, null, 2, null);
            QQAppInterface qQAppInterface = this.f207349d;
            FileManagerEntity fileManagerEntity = this.f207346a0;
            FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface, fileManagerEntity.nSessionId, this.f207357h0, this.f207347b0, this.f207373v0, this.f207363m, this.E, fileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.R, "", "", this.f207369r0, "NoNetWork", null);
            QQAppInterface qQAppInterface2 = this.f207349d;
            FileManagerEntity fileManagerEntity2 = this.f207346a0;
            FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface2, fileManagerEntity2.nSessionId, this.f207359i0, this.f207347b0, this.f207373v0, this.f207363m, this.E, fileManagerEntity2.strFileMd5, 9004L, "", 0L, 0L, this.R, "", "", this.f207372u0, "NoNetWork", null);
            QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [CS Step], no network!");
            return false;
        }
        this.f207349d.getFileManagerNotifyCenter().c(this.P, this.Q, this.f207363m, this.C, 13, null, 0, null);
        if (this.J == 0) {
            this.f207349d.getFileManagerDataCenter().a0(this.Q, 1002);
        }
        this.f207346a0.status = 0;
        this.f207349d.getFileManagerDataCenter().f0(this.f207346a0);
        FileManagerEntity fileManagerEntity3 = this.f207346a0;
        fileManagerEntity3.status = 2;
        fileManagerEntity3.fProgress = 0.0f;
        if (this.f207353f == null) {
            if (QLog.isColorLevel()) {
                QLog.i("FileManagerRSWorker<FileAssistant>", 2, "sendLocalFile, SessionId[" + this.Q + "], strFilePath is null");
            }
            QQAppInterface qQAppInterface3 = this.f207349d;
            FileManagerEntity fileManagerEntity4 = this.f207346a0;
            FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface3, fileManagerEntity4.nSessionId, this.f207357h0, this.f207347b0, this.f207373v0, this.f207363m, this.E, fileManagerEntity4.strFileMd5, 9005L, null, this.f207366o0, this.K, this.R, "", "", this.f207372u0, FileManagerUtil.printStack(), null);
            QQAppInterface qQAppInterface4 = this.f207349d;
            FileManagerEntity fileManagerEntity5 = this.f207346a0;
            FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface4, fileManagerEntity5.nSessionId, this.f207359i0, this.f207347b0, this.f207373v0, this.f207363m, this.E, fileManagerEntity5.strFileMd5, 9005L, null, this.f207366o0, this.K, this.R, "", "", this.f207372u0, FileManagerUtil.printStack(), null);
            handleError(null, null);
            QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [CS Step], Filepath is null!");
            return false;
        }
        String str = this.D;
        if (str != null && str.length() != 0) {
            String str2 = this.D;
            this.f207373v0 = str2;
            com.tencent.mobileqq.filemanager.core.h hVar = new com.tencent.mobileqq.filemanager.core.h(this.f207349d, str2);
            this.M = hVar;
            String a16 = hVar.a();
            if (!TextUtils.isEmpty(a16)) {
                this.D = a16;
                this.f207346a0.strServerPath = a16;
                QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^ [CS Step], server Path is not empty, Goto [Upload Step]!");
                this.W = 131072L;
                this.f207366o0 = 0L;
                c0(this.D, 0L);
                return true;
            }
        }
        byte[] md5 = FileManagerUtil.getMd5(this.f207353f, this.R);
        this.H = md5;
        if (md5 == null) {
            h0(0);
            this.f207349d.getFileManagerNotifyCenter().c(this.P, this.Q, this.f207363m, this.C, 2, null, 5, null);
            if (QLog.isColorLevel()) {
                QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [CS Step], SessionId[" + this.Q + "], getMd5 failed");
            }
            QQAppInterface qQAppInterface5 = this.f207349d;
            FileManagerEntity fileManagerEntity6 = this.f207346a0;
            long j3 = fileManagerEntity6.nSessionId;
            String str3 = this.f207357h0;
            long j16 = this.f207347b0;
            String str4 = this.f207373v0;
            FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface5, j3, str3, j16, str4, this.f207363m, this.E, fileManagerEntity6.strFileMd5, 9041L, "", this.f207366o0, this.K, this.R, str4, "", this.f207369r0, "getfile md5 error", null);
            QQAppInterface qQAppInterface6 = this.f207349d;
            FileManagerEntity fileManagerEntity7 = this.f207346a0;
            long j17 = fileManagerEntity7.nSessionId;
            String str5 = this.f207359i0;
            long j18 = this.f207347b0;
            String str6 = this.f207373v0;
            FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface6, j17, str5, j18, str6, this.f207363m, this.E, fileManagerEntity7.strFileMd5, 9041L, "", this.f207366o0, this.K, this.R, str6, "", this.f207372u0, "getfile md5 error", null);
            return true;
        }
        try {
            byte[] bytes = FileManagerUtil.getFileName(this.f207353f).getBytes("utf-8");
            byte[] bytes2 = this.f207353f.getBytes("utf-8");
            if (QLog.isColorLevel()) {
                QLog.i("FileManagerRSWorker<FileAssistant>", 2, "=_= ^> sendLocalFile, SessionId[" + this.Q + "], serverPath is null, so get upload info");
            }
            FileManagerEntity fileManagerEntity8 = this.f207346a0;
            long j19 = fileManagerEntity8.tmpSessionType;
            if (j19 > 0) {
                fileManagerEntity8.tmpSessionSig = FileManagerUtil.getTempSessionSig(this.f207349d, fileManagerEntity8.peerUin, (int) j19);
            }
            f0(this.f207363m, bytes2, bytes, this.R, this.H, this.f207365n0, this.f207346a0);
            return true;
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
            QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [CS Step], SessionId[" + this.Q + "], getFilePath failed");
            h0(0);
            QQAppInterface qQAppInterface7 = this.f207349d;
            FileManagerEntity fileManagerEntity9 = this.f207346a0;
            FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface7, fileManagerEntity9.nSessionId, this.f207357h0, this.f207347b0, this.f207373v0, this.f207363m, this.E, fileManagerEntity9.strFileMd5, 9005L, null, this.f207366o0, this.K, this.R, "", "", this.f207372u0, FileManagerUtil.printStack(), null);
            QQAppInterface qQAppInterface8 = this.f207349d;
            FileManagerEntity fileManagerEntity10 = this.f207346a0;
            FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface8, fileManagerEntity10.nSessionId, this.f207359i0, this.f207347b0, this.f207373v0, this.f207363m, this.E, fileManagerEntity10.strFileMd5, 9005L, null, this.f207366o0, this.K, this.R, "", "", this.f207372u0, FileManagerUtil.printStack(), null);
            this.f207349d.getFileManagerNotifyCenter().c(this.P, this.Q, this.f207363m, this.C, 15, null, 5, null);
            return false;
        }
    }

    @Override // vb1.b
    public void f() {
        try {
            InputStream inputStream = this.U;
            if (inputStream != null) {
                inputStream.close();
                this.U = null;
            }
        } catch (Exception unused) {
        }
        h0(0);
    }

    @Override // vb1.b
    public int getActionType() {
        return this.J;
    }

    @Override // vb1.b
    public String getFileId() {
        return this.f207346a0.WeiYunFileId;
    }

    @Override // vb1.b
    public long getFileSize() {
        return this.R;
    }

    @Override // vb1.b
    public int getProgress() {
        long j3 = this.R;
        if (j3 <= 0) {
            return 0;
        }
        return (int) ((this.K * 100) / j3);
    }

    @Override // vb1.b
    public int getStatus() {
        return this.f207375x0;
    }

    public void h0(int i3) {
        int status = FileManagerUtil.getStatus(i3);
        if (this.f207375x0 == status && status == 2) {
            return;
        }
        this.f207375x0 = status;
        FileManagerEntity fileManagerEntity = this.f207346a0;
        fileManagerEntity.status = status;
        fileManagerEntity.fProgress = ((float) this.K) / ((float) this.R);
        if (status != 2) {
            fileManagerEntity.peerUin = this.f207363m;
            fileManagerEntity.peerType = this.C;
            fileManagerEntity.uniseq = this.P;
            String str = this.E;
            if (str == null) {
                str = fileManagerEntity.Uuid;
            }
            fileManagerEntity.Uuid = str;
            this.f207349d.getFileManagerDataCenter().f0(this.f207346a0);
        }
    }

    @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
    public void handleError(HttpMsg httpMsg, HttpMsg httpMsg2) {
        String str;
        int i3;
        String str2;
        String str3;
        String str4;
        int i16;
        String str5;
        int i17;
        int i18;
        String str6 = null;
        if (httpMsg2 != null) {
            str = httpMsg2.getErrorString();
        } else {
            str = null;
        }
        if (str == null) {
            str = "null";
        }
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "handleError....., Id[" + String.valueOf(this.Q) + "]transferedSize[" + this.K + "]isStop[" + String.valueOf(a()) + "],  status[" + String.valueOf(this.f207375x0) + "], strErrString[" + str + "], autoRetry[" + String.valueOf(this.f207369r0) + "]");
        if (S(httpMsg, httpMsg2)) {
            return;
        }
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext()) && (a() || (i18 = this.f207375x0) == 1003 || i18 == 2003)) {
            return;
        }
        Bundle bundle = new Bundle();
        if (this.J != 0) {
            bundle.putInt("param_V6SelectType", this.f207355g0);
            bundle.putInt("param_ipAddrType", B());
            bundle.putInt("param_ishttps", this.f207361k0 ? 1 : 0);
        }
        if (httpMsg2 == null) {
            i3 = 0;
        } else {
            i3 = httpMsg2.errCode;
        }
        if (httpMsg2 != null && vb1.a.c(httpMsg2.errCode)) {
            this.f207372u0++;
            com.tencent.mobileqq.filemanager.core.h hVar = this.M;
            if (hVar != null) {
                str6 = hVar.a();
            }
            QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.Q + "]get nextIp[" + str6 + "]errCode[" + i3 + "]");
            QQAppInterface qQAppInterface = this.f207349d;
            FileManagerEntity fileManagerEntity = this.f207346a0;
            str2 = str;
            i16 = i3;
            str4 = "Id[";
            FileManagerUtil.reportFilemanagerFaildInfoEx(qQAppInterface, fileManagerEntity.nSessionId, this.f207359i0, this.f207347b0, this.f207373v0, this.f207363m, this.E, fileManagerEntity.strFileMd5, i16, String.valueOf(httpMsg2.getSerial()), this.f207366o0, this.K, this.R, httpMsg2.getRealUrl(), httpMsg2.rawRespHeader, this.f207372u0, httpMsg2.getErrorString() + "&goChangeUrl", null, bundle);
            if (str6 != null && str6.length() != 0) {
                q(str6);
                return;
            }
            str3 = "FileManagerRSWorker<FileAssistant>";
            QLog.i(str3, 1, str4 + this.Q + "] need chang Ip ,but can not get next ip errCode[" + i16 + "]");
        } else {
            str2 = str;
            str3 = "FileManagerRSWorker<FileAssistant>";
            str4 = "Id[";
            i16 = i3;
            QLog.i(str3, 1, str4 + this.Q + "]don't need chang Ip errCode[" + i16 + "]");
        }
        long j3 = this.f207347b0;
        if (httpMsg2 != null) {
            str5 = str2;
            if (str5.contains("-29602")) {
                httpMsg2.errCode = -29602;
                QQAppInterface qQAppInterface2 = this.f207349d;
                FileManagerEntity fileManagerEntity2 = this.f207346a0;
                FileManagerUtil.reportFilemanagerFaildInfoEx(qQAppInterface2, fileManagerEntity2.nSessionId, this.f207359i0, this.f207347b0, this.f207373v0, this.f207363m, this.E, fileManagerEntity2.strFileMd5, -29602, String.valueOf(httpMsg2.getSerial()), this.f207366o0, this.K, this.R, httpMsg2.getRealUrl(), httpMsg2.rawRespHeader, this.f207372u0, httpMsg2.getErrorString(), null, bundle);
                i17 = -29602;
                this.f207369r0 = 0;
                b();
                c(httpMsg2, i17);
            }
        } else {
            str5 = str2;
        }
        if (httpMsg2 != null && Q(httpMsg, httpMsg2)) {
            if (str5.contains("SSLPeerUnverifiedException")) {
                QQAppInterface qQAppInterface3 = this.f207349d;
                FileManagerEntity fileManagerEntity3 = this.f207346a0;
                FileManagerUtil.reportFilemanagerFaildInfoEx(qQAppInterface3, fileManagerEntity3.nSessionId, this.f207359i0, this.f207347b0, this.f207373v0, this.f207363m, this.E, fileManagerEntity3.strFileMd5, i16, String.valueOf(httpMsg2.getSerial()), this.f207366o0, this.K, this.R, httpMsg2.getRealUrl(), httpMsg2.rawRespHeader, this.f207372u0, httpMsg2.getErrorString(), null, bundle);
                this.f207346a0.status = 0;
                this.f207349d.getFileManagerDataCenter().f0(this.f207346a0);
            } else {
                if (r(str5)) {
                    if (!TextUtils.isEmpty(this.E)) {
                        this.D = "";
                    } else {
                        QLog.e(str3, 1, "!!!!!!!uuid is null!!!!!!!");
                        QLog.e(str3, 1, FileManagerUtil.printFileManagerEntityInfo(this.f207346a0));
                        if (!TextUtils.isEmpty(this.f207346a0.Uuid)) {
                            this.E = this.f207346a0.Uuid;
                            this.D = "";
                        }
                    }
                    i16 = 9042;
                }
                if (s(str5)) {
                    QQAppInterface qQAppInterface4 = this.f207349d;
                    FileManagerEntity fileManagerEntity4 = this.f207346a0;
                    FileManagerUtil.reportFilemanagerFaildInfoEx(qQAppInterface4, fileManagerEntity4.nSessionId, this.f207359i0, this.f207347b0, this.f207373v0, this.f207363m, this.E, fileManagerEntity4.strFileMd5, 9042, String.valueOf(httpMsg2.getSerial()), this.f207366o0, this.K, this.R, httpMsg2.getRealUrl(), httpMsg2.rawRespHeader, this.f207372u0, httpMsg2.getErrorString(), null, bundle);
                    QLog.d(str3, 1, "checkErrorWithFileNotExist fileSize = " + this.f207346a0.fileSize + " fileType = " + this.f207346a0.nFileType + " uuid = " + this.f207346a0.Uuid);
                    this.f207346a0.status = 16;
                    i17 = 9042;
                    this.f207369r0 = 0;
                    b();
                    c(httpMsg2, i17);
                }
                this.f207349d.getFileManagerDataCenter().f0(this.f207346a0);
                if (QLog.isColorLevel()) {
                    QLog.i(str3, 2, str4 + String.valueOf(this.Q) + "]handleError-----------retryTime:" + this.f207369r0);
                }
                if (this.f207369r0 < 8) {
                    J(httpMsg2, bundle, i16, j3);
                    return;
                }
            }
        }
        i17 = i16;
        this.f207369r0 = 0;
        b();
        c(httpMsg2, i17);
    }

    @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
    public void handleRedirect(String str) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "handleRedirect, new location:" + str);
        HttpMsg httpMsg = this.I;
        if (httpMsg == null) {
            QLog.w("FileManagerRSWorker<FileAssistant>", 1, "handleRedirect, but curRequest is null");
            return;
        }
        QQAppInterface qQAppInterface = this.f207349d;
        FileManagerEntity fileManagerEntity = this.f207346a0;
        FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface, fileManagerEntity.nSessionId, this.f207357h0, this.f207347b0, this.f207373v0, this.f207363m, this.E, fileManagerEntity.strFileMd5, 9004L, String.valueOf(httpMsg.getSerial()), this.f207366o0, this.K, this.R, this.I.getRealUrl(), this.I.rawRespHeader, this.f207372u0, this.I.getErrorString() + "&UrlOver&handleRedirect", null);
        c(null, 0);
    }

    protected void i0() {
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            FileManagerEntity fileManagerEntity = this.f207346a0;
            fileManagerEntity.status = 0;
            fileManagerEntity.isReaded = false;
            this.f207349d.getFileManagerNotifyCenter().c(this.P, this.Q, this.f207363m, this.C, 38, null, 11, null);
            this.f207349d.getFileManagerDataCenter().c0();
            QLog.e("FileManagerRSWorker<FileAssistant>", 1, "net work error");
            QQAppInterface qQAppInterface = this.f207349d;
            FileManagerEntity fileManagerEntity2 = this.f207346a0;
            FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface, fileManagerEntity2.nSessionId, this.f207357h0, 0L, "", "", "", "", 9004L, "", 0L, 0L, fileManagerEntity2.fileSize, "", "", 0, RaffleJsPlugin.ERROR_REPORT_NO_NETWORK, null);
            return;
        }
        this.f207346a0.status = 0;
        this.f207349d.getFileManagerDataCenter().f0(this.f207346a0);
        FileManagerEntity fileManagerEntity3 = this.f207346a0;
        fileManagerEntity3.status = 2;
        this.R = fileManagerEntity3.fileSize;
        com.tencent.mobileqq.filemanageraux.core.d I = this.f207349d.getFileManagerEngine().Y().I(this.f207346a0.getFilePath(), null, new b());
        this.f207376y0 = I;
        if (I == null) {
            QLog.e("FileManagerRSWorker<FileAssistant>", 1, "create upload task is fail! nSessionId[" + this.Q + "] filePath[" + this.f207346a0.getFilePath() + "]");
            this.f207349d.getFileManagerNotifyCenter().c(this.P, this.Q, this.f207363m, this.C, 38, null, 11, null);
        }
    }

    void q(String str) {
        boolean z16;
        if (this.J == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.D = str;
            this.f207373v0 = str;
            this.f207374w0++;
            c0(str, 0L);
            return;
        }
        this.D = str;
        this.f207373v0 = str;
        this.f207374w0++;
        long fileSizes = FileManagerUtil.getFileSizes(this.f207358i);
        this.K = fileSizes;
        X(fileSizes, this.S);
    }

    @Override // vb1.b
    public void run() {
        synchronized (this) {
            this.Z = false;
        }
        this.Y = new Runnable() { // from class: com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.8
            /* JADX WARN: Code restructure failed: missing block: B:31:0x017d, code lost:
            
                if (r2 != 54) goto L38;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                String str;
                if (QLog.isColorLevel()) {
                    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Running RSWorker:" + com.tencent.mobileqq.service.message.e.K0());
                }
                if (QLog.isColorLevel()) {
                    if (("run task sessionid[" + String.valueOf(FileManagerRSWorker.this.Q) + "], actionType[" + String.valueOf(FileManagerRSWorker.this.J) + "], strUin[" + FileManagerRSWorker.this.f207363m) != null) {
                        str = FileManagerUtil.enCodecString(FileManagerRSWorker.this.f207363m);
                    } else {
                        if (("null], filePath[" + FileManagerRSWorker.this.f207353f) != null) {
                            str = FileManagerRSWorker.this.f207353f;
                        } else {
                            str = "null], uniseq[" + String.valueOf(FileManagerRSWorker.this.P) + "]";
                        }
                    }
                    QLog.i("FileManagerRSWorker<FileAssistant>", 2, str);
                }
                if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                    FileManagerRSWorker.this.h0(0);
                    FileManagerNotifyCenter fileManagerNotifyCenter = FileManagerRSWorker.this.f207349d.getFileManagerNotifyCenter();
                    FileManagerRSWorker fileManagerRSWorker = FileManagerRSWorker.this;
                    fileManagerNotifyCenter.c(fileManagerRSWorker.P, fileManagerRSWorker.Q, fileManagerRSWorker.f207363m, fileManagerRSWorker.C, 1, null, 2, null);
                    FileManagerRSWorker fileManagerRSWorker2 = FileManagerRSWorker.this;
                    QQAppInterface qQAppInterface = fileManagerRSWorker2.f207349d;
                    long j3 = fileManagerRSWorker2.f207346a0.nSessionId;
                    String str2 = fileManagerRSWorker2.f207357h0;
                    long j16 = fileManagerRSWorker2.f207347b0;
                    String str3 = fileManagerRSWorker2.f207373v0;
                    FileManagerRSWorker fileManagerRSWorker3 = FileManagerRSWorker.this;
                    FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface, j3, str2, j16, str3, fileManagerRSWorker3.f207363m, fileManagerRSWorker3.E, fileManagerRSWorker3.f207346a0.strFileMd5, 9004L, "", 0L, 0L, fileManagerRSWorker3.R, "", "", fileManagerRSWorker3.f207369r0, "NoNetWork", null);
                    FileManagerRSWorker fileManagerRSWorker4 = FileManagerRSWorker.this;
                    QQAppInterface qQAppInterface2 = fileManagerRSWorker4.f207349d;
                    long j17 = fileManagerRSWorker4.f207346a0.nSessionId;
                    String str4 = fileManagerRSWorker4.f207359i0;
                    long j18 = fileManagerRSWorker4.f207347b0;
                    String str5 = fileManagerRSWorker4.f207373v0;
                    FileManagerRSWorker fileManagerRSWorker5 = FileManagerRSWorker.this;
                    FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface2, j17, str4, j18, str5, fileManagerRSWorker5.f207363m, fileManagerRSWorker5.E, fileManagerRSWorker5.f207346a0.strFileMd5, 9004L, "", 0L, 0L, fileManagerRSWorker5.R, "", "", fileManagerRSWorker5.f207372u0, "NoNetWork", null);
                    return;
                }
                FileManagerRSWorker.this.f207347b0 = System.currentTimeMillis();
                FileManagerRSWorker fileManagerRSWorker6 = FileManagerRSWorker.this;
                fileManagerRSWorker6.f207366o0 = 0L;
                fileManagerRSWorker6.f207346a0.status = 2;
                int i3 = fileManagerRSWorker6.J;
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 != 5) {
                            if (i3 != 6) {
                                if (i3 != 8) {
                                    if (i3 == 50) {
                                        fileManagerRSWorker6.z();
                                    }
                                }
                            } else {
                                fileManagerRSWorker6.i0();
                            }
                        } else {
                            fileManagerRSWorker6.y();
                        }
                    }
                    FileManagerReporter.a aVar = new FileManagerReporter.a();
                    aVar.f209157b = "rece_file_number";
                    FileManagerReporter.addData(FileManagerRSWorker.this.f207349d.getCurrentAccountUin(), aVar);
                    FileManagerRSWorker.this.Z();
                } else {
                    FileManagerReporter.a aVar2 = new FileManagerReporter.a();
                    aVar2.f209157b = "send_file_number";
                    FileManagerReporter.addData(FileManagerRSWorker.this.f207349d.getCurrentAccountUin(), aVar2);
                    FileManagerRSWorker.this.e0();
                }
                FileManagerRSWorker.this.f207349d.getFileManagerNotifyCenter().b(true, 3, null);
            }
        };
        if (QLog.isColorLevel()) {
            QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Run RSWorker" + com.tencent.mobileqq.service.message.e.K0());
        }
        ah.b.a().execute(this.Y);
        if (this.J == 0 && this.f207346a0.fileSize > GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT) {
            T();
        }
    }

    @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
    public boolean statusChanged(HttpMsg httpMsg, HttpMsg httpMsg2, int i3) {
        if (5 == i3 && this.J != 0 && this.K < this.R) {
            if (QLog.isColorLevel()) {
                QLog.e("FileManagerRSWorker<FileAssistant>", 2, "nSessionID[" + String.valueOf(this.Q) + "] HttpCommunicator.status = STATUS_END . but data no recv completed. recvData=" + this.K + " filesize=" + this.R);
            }
            FileManagerUtil.reportFilemanagerFaildInfo(this.f207349d, this.Q, this.f207359i0, this.f207347b0, this.D, this.f207363m, this.E, this.f207346a0.strFileMd5, -9527L, "", this.f207366o0, this.K, this.R, httpMsg2.getRealUrl(), httpMsg2.rawRespHeader, this.f207372u0, "statusChanged mtransferedSize[" + String.valueOf(this.K) + "]nFileSize[" + String.valueOf(this.R) + "]", null);
            x();
            return true;
        }
        return true;
    }

    protected void y() {
        long c16;
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            FileManagerEntity fileManagerEntity = this.f207346a0;
            fileManagerEntity.status = 0;
            fileManagerEntity.isReaded = false;
            this.f207349d.getFileManagerNotifyCenter().c(this.P, this.Q, this.f207363m, this.C, 36, null, 11, null);
            QLog.e("FileManagerRSWorker<FileAssistant>", 1, "net work error");
            this.f207349d.getFileManagerDataCenter().c0();
            QQAppInterface qQAppInterface = this.f207349d;
            FileManagerEntity fileManagerEntity2 = this.f207346a0;
            FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface, fileManagerEntity2.nSessionId, this.f207357h0, this.f207347b0, "", "", "", "", 9004L, "", 0L, 0L, fileManagerEntity2.fileSize, "", "", 0, RaffleJsPlugin.ERROR_REPORT_NO_NETWORK, null);
            return;
        }
        long j3 = this.R - this.K;
        if (cu.e()) {
            c16 = cu.b();
        } else {
            c16 = cu.c();
        }
        long j16 = c16 * 1024;
        if (j16 < j3) {
            QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.Q + "]downLoadWeiYunFile local space no enough!! [downsize:" + j3 + "sdcardsize:" + j16 + "]");
            FileManagerEntity fileManagerEntity3 = this.f207346a0;
            fileManagerEntity3.status = 0;
            fileManagerEntity3.isReaded = false;
            this.f207349d.getFileManagerDataCenter().c0();
            this.f207349d.getFileManagerNotifyCenter().c(this.P, this.Q, this.f207363m, this.C, 36, null, 12, null);
            QQAppInterface qQAppInterface2 = this.f207349d;
            FileManagerEntity fileManagerEntity4 = this.f207346a0;
            long j17 = fileManagerEntity4.nSessionId;
            String str = this.f207357h0;
            long j18 = this.f207347b0;
            long j19 = this.K;
            FileManagerUtil.reportFilemanagerFaildInfo(qQAppInterface2, j17, str, j18, "", "", "", "", 9040L, "", j19, j19, fileManagerEntity4.fileSize, "", "", 0, "sdcard full", null);
            return;
        }
        FileManagerEntity fileManagerEntity5 = this.f207346a0;
        this.R = fileManagerEntity5.fileSize;
        com.tencent.mobileqq.filemanageraux.core.d g16 = this.f207349d.getFileManagerEngine().Y().g(fileManagerEntity5, null, new h());
        this.f207376y0 = g16;
        if (g16 == null) {
            QLog.e("FileManagerRSWorker<FileAssistant>", 1, "create download task is fail! nSessionId[" + this.Q + "]fileid[" + this.f207346a0.WeiYunFileId + "] filename[" + this.f207346a0.fileName + "] filesize[" + this.f207346a0.fileSize + "] modifytime[" + this.f207346a0.lastTime + "]");
            this.f207349d.getFileManagerNotifyCenter().c(this.P, this.Q, this.f207363m, this.C, 36, null, 11, null);
            return;
        }
        g16.b(this.f207346a0.WeiYunFileId);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements y43.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FileManagerEntity f207379a;

        a(FileManagerEntity fileManagerEntity) {
            this.f207379a = fileManagerEntity;
        }

        @Override // y43.c
        public void a(String str, long j3, com.tencent.mobileqq.weiyun.model.c cVar, boolean z16) {
            String weiyunMiniappProcessName = ((IWeiyunUploadDownloadService) QRoute.api(IWeiyunUploadDownloadService.class)).getWeiyunMiniappProcessName();
            if (z16) {
                if (cVar.f315182d == 2) {
                    if (QLog.isColorLevel()) {
                        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is onStarted");
                        return;
                    }
                    return;
                }
                if (cVar.f315182d == 5) {
                    if (QLog.isColorLevel()) {
                        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is fail");
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString(MiniAppGetGameTaskTicketServlet.KEY_TASKID, this.f207379a.miniAppDownloadId);
                    bundle.putInt("errorCode", cVar.f315183e);
                    bundle.putString("errorMsg", cVar.f315184f);
                    QIPCServerHelper.getInstance().callClient(weiyunMiniappProcessName, "Module_WeiyunDownloadClient", "WeiyunDownloadClientIPC_Action__Fail", bundle, null);
                    FileManagerRSWorker fileManagerRSWorker = FileManagerRSWorker.this;
                    FileManagerEntity fileManagerEntity = fileManagerRSWorker.f207346a0;
                    fileManagerEntity.status = 0;
                    fileManagerEntity.isReaded = false;
                    fileManagerRSWorker.f207349d.getFileManagerDataCenter().c0();
                    FileManagerRSWorker.this.f207349d.getFileManagerDataCenter().f0(FileManagerRSWorker.this.f207346a0);
                    FileManagerNotifyCenter fileManagerNotifyCenter = FileManagerRSWorker.this.f207349d.getFileManagerNotifyCenter();
                    FileManagerRSWorker fileManagerRSWorker2 = FileManagerRSWorker.this;
                    fileManagerNotifyCenter.c(fileManagerRSWorker2.P, fileManagerRSWorker2.Q, fileManagerRSWorker2.f207363m, fileManagerRSWorker2.C, 36, null, cVar.f315183e, cVar.f315184f);
                    return;
                }
                if (cVar.f315182d == 4) {
                    if (QLog.isColorLevel()) {
                        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is onSucceed");
                    }
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(MiniAppGetGameTaskTicketServlet.KEY_TASKID, this.f207379a.miniAppDownloadId);
                    bundle2.putString("filePath", cVar.f315187m);
                    QIPCServerHelper.getInstance().callClient(weiyunMiniappProcessName, "Module_WeiyunDownloadClient", "WeiyunDownloadClientIPC_Action__Suc", bundle2, null);
                    FileManagerRSWorker.this.f207346a0.setFilePath(cVar.f315187m);
                    FileManagerEntity fileManagerEntity2 = FileManagerRSWorker.this.f207346a0;
                    fileManagerEntity2.fProgress = 1.0f;
                    fileManagerEntity2.isReaded = false;
                    fileManagerEntity2.setCloudType(3);
                    FileManagerEntity fileManagerEntity3 = FileManagerRSWorker.this.f207346a0;
                    fileManagerEntity3.status = 1;
                    fileManagerEntity3.fileName = FileManagerUtil.getFileName(fileManagerEntity3.getFilePath());
                    FileManagerRSWorker fileManagerRSWorker3 = FileManagerRSWorker.this;
                    fileManagerRSWorker3.f207346a0.fileSize = cVar.f315185h;
                    fileManagerRSWorker3.f207349d.getFileManagerDataCenter().f0(FileManagerRSWorker.this.f207346a0);
                    FileManagerNotifyCenter fileManagerNotifyCenter2 = FileManagerRSWorker.this.f207349d.getFileManagerNotifyCenter();
                    FileManagerRSWorker fileManagerRSWorker4 = FileManagerRSWorker.this;
                    fileManagerNotifyCenter2.c(fileManagerRSWorker4.P, fileManagerRSWorker4.Q, fileManagerRSWorker4.f207363m, fileManagerRSWorker4.C, 35, null, 0, null);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is process");
            }
            Bundle bundle3 = new Bundle();
            bundle3.putString(MiniAppGetGameTaskTicketServlet.KEY_TASKID, this.f207379a.miniAppDownloadId);
            bundle3.putInt("progress", (int) ((((float) cVar.f315186i) / ((float) cVar.f315185h)) * 100.0f));
            bundle3.putLong("currSize", cVar.f315186i);
            bundle3.putLong("totalSize", cVar.f315185h);
            QIPCServerHelper.getInstance().callClient(weiyunMiniappProcessName, "Module_WeiyunDownloadClient", "WeiyunDownloadClientIPC_Action__Progress", bundle3, null);
            FileManagerRSWorker fileManagerRSWorker5 = FileManagerRSWorker.this;
            fileManagerRSWorker5.f207346a0.fProgress = ((float) fileManagerRSWorker5.K) / ((float) fileManagerRSWorker5.R);
            FileManagerNotifyCenter fileManagerNotifyCenter3 = fileManagerRSWorker5.f207349d.getFileManagerNotifyCenter();
            FileManagerRSWorker fileManagerRSWorker6 = FileManagerRSWorker.this;
            fileManagerNotifyCenter3.c(fileManagerRSWorker6.P, fileManagerRSWorker6.Q, fileManagerRSWorker6.f207363m, fileManagerRSWorker6.C, 16, null, 0, null);
        }

        @Override // y43.c
        public void b(String str) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class h implements y43.c {
        h() {
        }

        @Override // y43.c
        public void a(String str, long j3, com.tencent.mobileqq.weiyun.model.c cVar, boolean z16) {
            if (FileManagerRSWorker.this.f207376y0 == null) {
                return;
            }
            if (z16) {
                if (cVar.f315182d == 2) {
                    if (QLog.isColorLevel()) {
                        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is onStarted[" + FileManagerRSWorker.this.Q + "]");
                    }
                    FileManagerNotifyCenter fileManagerNotifyCenter = FileManagerRSWorker.this.f207349d.getFileManagerNotifyCenter();
                    FileManagerRSWorker fileManagerRSWorker = FileManagerRSWorker.this;
                    fileManagerNotifyCenter.c(fileManagerRSWorker.P, fileManagerRSWorker.Q, fileManagerRSWorker.f207363m, fileManagerRSWorker.C, 16, null, 0, null);
                    return;
                }
                if (cVar.f315182d == 5) {
                    if (cVar.f315183e == 1810002) {
                        if (QLog.isColorLevel()) {
                            QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is canceled[" + FileManagerRSWorker.this.Q + "],set trafficData size[" + FileManagerRSWorker.this.K + "]");
                        }
                        NetworkUtil.getNetworkType(BaseApplication.getContext());
                        FileManagerNotifyCenter fileManagerNotifyCenter2 = FileManagerRSWorker.this.f207349d.getFileManagerNotifyCenter();
                        FileManagerRSWorker fileManagerRSWorker2 = FileManagerRSWorker.this;
                        fileManagerNotifyCenter2.c(fileManagerRSWorker2.P, fileManagerRSWorker2.Q, fileManagerRSWorker2.f207363m, fileManagerRSWorker2.C, 3, null, 0, null);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is onFailed[" + FileManagerRSWorker.this.Q + "],set trafficData size[" + FileManagerRSWorker.this.K + "]");
                    }
                    NetworkUtil.getNetworkType(BaseApplication.getContext());
                    FileManagerRSWorker fileManagerRSWorker3 = FileManagerRSWorker.this;
                    FileManagerEntity fileManagerEntity = fileManagerRSWorker3.f207346a0;
                    fileManagerEntity.status = 0;
                    fileManagerEntity.isReaded = false;
                    fileManagerRSWorker3.f207349d.getFileManagerDataCenter().c0();
                    FileManagerRSWorker.this.f207349d.getFileManagerDataCenter().f0(FileManagerRSWorker.this.f207346a0);
                    FileManagerNotifyCenter fileManagerNotifyCenter3 = FileManagerRSWorker.this.f207349d.getFileManagerNotifyCenter();
                    FileManagerRSWorker fileManagerRSWorker4 = FileManagerRSWorker.this;
                    fileManagerNotifyCenter3.c(fileManagerRSWorker4.P, fileManagerRSWorker4.Q, fileManagerRSWorker4.f207363m, fileManagerRSWorker4.C, 36, null, cVar.f315183e, cVar.f315184f);
                    return;
                }
                if (cVar.f315182d == 4) {
                    if (QLog.isColorLevel()) {
                        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is onSucceed[" + FileManagerRSWorker.this.Q + "],set trafficData size[" + FileManagerRSWorker.this.K + "]");
                    }
                    FileManagerRSWorker.this.f207346a0.setFilePath(cVar.f315187m);
                    FileManagerEntity fileManagerEntity2 = FileManagerRSWorker.this.f207346a0;
                    fileManagerEntity2.fProgress = 1.0f;
                    fileManagerEntity2.isReaded = false;
                    fileManagerEntity2.setCloudType(3);
                    FileManagerEntity fileManagerEntity3 = FileManagerRSWorker.this.f207346a0;
                    fileManagerEntity3.status = 1;
                    fileManagerEntity3.fileName = FileManagerUtil.getFileName(fileManagerEntity3.getFilePath());
                    FileManagerRSWorker.this.f207348c0 = System.currentTimeMillis();
                    NetworkUtil.getNetworkType(BaseApplication.getContext());
                    FileManagerRSWorker.this.f207349d.getFileManagerDataCenter().f0(FileManagerRSWorker.this.f207346a0);
                    FileManagerNotifyCenter fileManagerNotifyCenter4 = FileManagerRSWorker.this.f207349d.getFileManagerNotifyCenter();
                    FileManagerRSWorker fileManagerRSWorker5 = FileManagerRSWorker.this;
                    fileManagerNotifyCenter4.c(fileManagerRSWorker5.P, fileManagerRSWorker5.Q, fileManagerRSWorker5.f207363m, fileManagerRSWorker5.C, 35, null, 0, null);
                    FileManagerReporter.a aVar = new FileManagerReporter.a();
                    aVar.f209157b = "rece_file_suc";
                    aVar.f209158c = 1;
                    FileManagerReporter.addData(FileManagerRSWorker.this.f207349d.getCurrentAccountUin(), aVar);
                    return;
                }
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            FileManagerRSWorker fileManagerRSWorker6 = FileManagerRSWorker.this;
            fileManagerRSWorker6.K = cVar.f315186i;
            if (currentTimeMillis - fileManagerRSWorker6.X < 1000) {
                return;
            }
            fileManagerRSWorker6.X = currentTimeMillis;
            if (QLog.isColorLevel()) {
                QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + FileManagerRSWorker.this.Q + "]WeiYun download is onProgressChange mtransferedSize[" + FileManagerRSWorker.this.K + "/" + FileManagerRSWorker.this.R + "]");
            }
            FileManagerRSWorker fileManagerRSWorker7 = FileManagerRSWorker.this;
            fileManagerRSWorker7.f207346a0.fProgress = ((float) fileManagerRSWorker7.K) / ((float) fileManagerRSWorker7.R);
            FileManagerNotifyCenter fileManagerNotifyCenter5 = fileManagerRSWorker7.f207349d.getFileManagerNotifyCenter();
            FileManagerRSWorker fileManagerRSWorker8 = FileManagerRSWorker.this;
            fileManagerNotifyCenter5.c(fileManagerRSWorker8.P, fileManagerRSWorker8.Q, fileManagerRSWorker8.f207363m, fileManagerRSWorker8.C, 16, null, 0, null);
        }

        @Override // y43.c
        public void b(String str) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements UploadManager.IUploadStatusListener {
        b() {
        }

        @Override // com.tencent.weiyun.transmission.upload.UploadManager.IUploadStatusListener
        public void onUploadStatusChanged(String str, long j3, UploadJobContext.StatusInfo statusInfo, boolean z16) {
            if (FileManagerRSWorker.this.f207376y0 == null) {
                return;
            }
            if (z16) {
                if (statusInfo.state == 3) {
                    if (QLog.isColorLevel()) {
                        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun upload is onStarted[" + FileManagerRSWorker.this.Q + "]");
                    }
                    FileManagerNotifyCenter fileManagerNotifyCenter = FileManagerRSWorker.this.f207349d.getFileManagerNotifyCenter();
                    FileManagerRSWorker fileManagerRSWorker = FileManagerRSWorker.this;
                    fileManagerNotifyCenter.c(fileManagerRSWorker.P, fileManagerRSWorker.Q, fileManagerRSWorker.f207363m, fileManagerRSWorker.C, 16, null, 0, null);
                    return;
                }
                if (statusInfo.state == 6) {
                    if (statusInfo.errorCode == 1810002) {
                        if (QLog.isColorLevel()) {
                            QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun upload is canceled[" + FileManagerRSWorker.this.Q + "],set trafficData size[" + FileManagerRSWorker.this.K + "]");
                        }
                        NetworkUtil.getNetworkType(BaseApplication.getContext());
                        FileManagerNotifyCenter fileManagerNotifyCenter2 = FileManagerRSWorker.this.f207349d.getFileManagerNotifyCenter();
                        FileManagerRSWorker fileManagerRSWorker2 = FileManagerRSWorker.this;
                        fileManagerNotifyCenter2.c(fileManagerRSWorker2.P, fileManagerRSWorker2.Q, fileManagerRSWorker2.f207363m, fileManagerRSWorker2.C, 3, null, 0, null);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun upload is onFailed[" + FileManagerRSWorker.this.Q + "],set trafficData size[" + FileManagerRSWorker.this.K + "]");
                    }
                    NetworkUtil.getNetworkType(BaseApplication.getContext());
                    FileManagerRSWorker fileManagerRSWorker3 = FileManagerRSWorker.this;
                    FileManagerEntity fileManagerEntity = fileManagerRSWorker3.f207346a0;
                    fileManagerEntity.status = 0;
                    fileManagerEntity.isReaded = false;
                    fileManagerRSWorker3.f207349d.getFileManagerDataCenter().c0();
                    FileManagerRSWorker.this.f207349d.getFileManagerDataCenter().f0(FileManagerRSWorker.this.f207346a0);
                    FileManagerNotifyCenter fileManagerNotifyCenter3 = FileManagerRSWorker.this.f207349d.getFileManagerNotifyCenter();
                    FileManagerRSWorker fileManagerRSWorker4 = FileManagerRSWorker.this;
                    fileManagerNotifyCenter3.c(fileManagerRSWorker4.P, fileManagerRSWorker4.Q, fileManagerRSWorker4.f207363m, fileManagerRSWorker4.C, 38, null, statusInfo.errorCode, statusInfo.errorMsg);
                    return;
                }
                if (statusInfo.state == 5) {
                    FileManagerRSWorker.this.f207376y0.b(statusInfo.fileId);
                    if (QLog.isColorLevel()) {
                        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun upload is onSucceed[" + FileManagerRSWorker.this.Q + "],set trafficData size[" + FileManagerRSWorker.this.R + "]");
                    }
                    FileManagerEntity fileManagerEntity2 = FileManagerRSWorker.this.f207346a0;
                    fileManagerEntity2.WeiYunFileId = statusInfo.fileId;
                    UploadJobContext uploadJobContext = statusInfo.jobContext;
                    if (uploadJobContext != null) {
                        fileManagerEntity2.WeiYunDirKey = uploadJobContext.file().pDirKey;
                        FileManagerRSWorker.this.f207346a0.strFileSHA = statusInfo.jobContext.file().sha;
                        if (!TextUtils.isEmpty(statusInfo.jobContext.file().thumbUrl)) {
                            FileManagerRSWorker.this.f207346a0.strLargeThumPath = statusInfo.jobContext.file().thumbUrl;
                        }
                    }
                    FileManagerEntity fileManagerEntity3 = FileManagerRSWorker.this.f207346a0;
                    fileManagerEntity3.fProgress = 1.0f;
                    fileManagerEntity3.setCloudType(2);
                    FileManagerRSWorker fileManagerRSWorker5 = FileManagerRSWorker.this;
                    FileManagerEntity fileManagerEntity4 = fileManagerRSWorker5.f207346a0;
                    fileManagerEntity4.status = 1;
                    fileManagerEntity4.isReaded = false;
                    fileManagerRSWorker5.f207348c0 = System.currentTimeMillis();
                    NetworkUtil.getNetworkType(BaseApplication.getContext());
                    FileManagerRSWorker.this.f207349d.getFileManagerDataCenter().f0(FileManagerRSWorker.this.f207346a0);
                    FileManagerNotifyCenter fileManagerNotifyCenter4 = FileManagerRSWorker.this.f207349d.getFileManagerNotifyCenter();
                    FileManagerRSWorker fileManagerRSWorker6 = FileManagerRSWorker.this;
                    fileManagerNotifyCenter4.c(fileManagerRSWorker6.P, fileManagerRSWorker6.Q, fileManagerRSWorker6.f207363m, fileManagerRSWorker6.C, 37, null, 0, null);
                    FileManagerReporter.a aVar = new FileManagerReporter.a();
                    aVar.f209157b = "send_file_suc";
                    aVar.f209158c = 1;
                    FileManagerReporter.addData(FileManagerRSWorker.this.f207349d.getCurrentAccountUin(), aVar);
                    return;
                }
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            FileManagerRSWorker fileManagerRSWorker7 = FileManagerRSWorker.this;
            fileManagerRSWorker7.K = statusInfo.currSize;
            fileManagerRSWorker7.R = statusInfo.totalSize;
            if (currentTimeMillis - fileManagerRSWorker7.X < 1000) {
                return;
            }
            fileManagerRSWorker7.X = currentTimeMillis;
            if (QLog.isColorLevel()) {
                QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + FileManagerRSWorker.this.Q + "]WeiYun upload is onProgressChange mtransferedSize[" + FileManagerRSWorker.this.K + "/" + FileManagerRSWorker.this.R + "]");
            }
            FileManagerRSWorker fileManagerRSWorker8 = FileManagerRSWorker.this;
            fileManagerRSWorker8.f207346a0.fProgress = ((float) fileManagerRSWorker8.K) / ((float) fileManagerRSWorker8.R);
            FileManagerNotifyCenter fileManagerNotifyCenter5 = fileManagerRSWorker8.f207349d.getFileManagerNotifyCenter();
            FileManagerRSWorker fileManagerRSWorker9 = FileManagerRSWorker.this;
            fileManagerNotifyCenter5.c(fileManagerRSWorker9.P, fileManagerRSWorker9.Q, fileManagerRSWorker9.f207363m, fileManagerRSWorker9.C, 16, null, 0, null);
        }

        @Override // com.tencent.weiyun.transmission.upload.UploadManager.IUploadStatusListener
        public void onUploadJobAdded(String str, long j3) {
        }
    }
}
