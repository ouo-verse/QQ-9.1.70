package com.tencent.mobileqq.filemanager.core;

import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.ad.tangram.util.AdHexUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ThreadPoolParams;
import com.tencent.mobileqq.app.TroopFileHandler;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.an;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tencent.turingfd.sdk.xq.IteApkInfoReq;
import com.tencent.turingfd.sdk.xq.IteApkInfoResp;
import com.tencent.turingfd.sdk.xq.IteApkInfoRespCallback;
import com.tencent.turingfd.sdk.xq.TuringSecurityService;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes12.dex */
public class MMApkFileSafeChecker {

    /* renamed from: h, reason: collision with root package name */
    static int f207432h = 1;

    /* renamed from: a, reason: collision with root package name */
    QQAppInterface f207433a;

    /* renamed from: c, reason: collision with root package name */
    private Executor f207435c;

    /* renamed from: b, reason: collision with root package name */
    Map<String, CheckTask> f207434b = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private Map<String, e> f207436d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private h f207437e = new a();

    /* renamed from: f, reason: collision with root package name */
    private boolean f207438f = true;

    /* renamed from: g, reason: collision with root package name */
    private boolean f207439g = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class CheckTask {

        /* renamed from: a, reason: collision with root package name */
        String f207445a;

        /* renamed from: b, reason: collision with root package name */
        String f207446b;

        /* renamed from: c, reason: collision with root package name */
        d f207447c;

        /* renamed from: d, reason: collision with root package name */
        long f207448d;

        /* renamed from: e, reason: collision with root package name */
        String f207449e;

        /* renamed from: f, reason: collision with root package name */
        Signature[] f207450f;

        /* renamed from: h, reason: collision with root package name */
        h f207452h;

        /* renamed from: i, reason: collision with root package name */
        Timer f207453i;

        /* renamed from: k, reason: collision with root package name */
        int f207455k;

        /* renamed from: g, reason: collision with root package name */
        Set<f> f207451g = new HashSet();

        /* renamed from: j, reason: collision with root package name */
        volatile boolean f207454j = true;

        CheckTask(String str, String str2, Signature[] signatureArr, long j3, d dVar, h hVar) {
            this.f207446b = str;
            this.f207445a = FileManagerUtil.getFileName(str);
            this.f207449e = str2;
            this.f207450f = signatureArr;
            this.f207448d = j3;
            this.f207447c = dVar;
            this.f207452h = hVar;
            int i3 = MMApkFileSafeChecker.f207432h;
            MMApkFileSafeChecker.f207432h = i3 + 1;
            this.f207455k = i3;
        }

        void a(f fVar) {
            if (fVar != null) {
                this.f207451g.add(fVar);
            }
        }

        synchronized void b() {
            Timer timer = this.f207453i;
            if (timer != null) {
                timer.cancel();
                this.f207453i = null;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x008b  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0094  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void c() {
            String str;
            int i3;
            String bytes2HexString;
            Signature[] signatureArr = this.f207450f;
            if (signatureArr != null && signatureArr.length > 0) {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                    messageDigest.update(this.f207450f[0].toByteArray());
                    bytes2HexString = AdHexUtil.bytes2HexString(messageDigest.digest());
                } catch (Exception unused) {
                    QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] <" + this.f207455k + "> sign md5 calc err");
                }
                if (!TextUtils.isEmpty(bytes2HexString)) {
                    str = bytes2HexString.toUpperCase();
                    HashMap hashMap = new HashMap();
                    IteApkInfoReq.Builder localQQ = IteApkInfoReq.newBuilder().pkgName(this.f207449e).certMd5(str).fileName(this.f207445a).fileSize(this.f207448d).fileMd5(this.f207447c.f207480g).fileSha1(this.f207447c.f207481h).localQQ("");
                    i3 = this.f207447c.f207474a;
                    if (i3 != 1) {
                        localQQ.chattingQQ(new ArrayList<>());
                    } else if (i3 == 2) {
                        localQQ.chattingRoomQQ(new ArrayList<>());
                    }
                    QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] <" + this.f207455k + "> run check task. fileName:" + this.f207445a + " pkgName:" + this.f207449e + " fileSize:" + this.f207448d + " pkgSignMd5:" + str + " " + this.f207447c.toString());
                    hashMap.put(Integer.valueOf(this.f207455k), localQQ.build());
                    TuringSecurityService.checkApk(hashMap, new IteApkInfoRespCallback() { // from class: com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker.CheckTask.2
                        @Override // com.tencent.turingfd.sdk.xq.IteApkInfoRespCallback
                        public void onResult(long j3, Map<Integer, IteApkInfoResp> map) {
                            final int i16;
                            final int i17;
                            final String str2;
                            final String str3;
                            IteApkInfoResp iteApkInfoResp;
                            if (map != null && (iteApkInfoResp = map.get(Integer.valueOf(CheckTask.this.f207455k))) != null) {
                                int errorCode = (int) iteApkInfoResp.getErrorCode();
                                int safeLevel = iteApkInfoResp.getSafeLevel();
                                String riskTips = iteApkInfoResp.getRiskTips();
                                str3 = iteApkInfoResp.getHandleUrl();
                                i16 = errorCode;
                                i17 = safeLevel;
                                str2 = riskTips;
                            } else {
                                i16 = 2;
                                i17 = 0;
                                str2 = "";
                                str3 = str2;
                            }
                            QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] <" + CheckTask.this.f207455k + "> on checkresult. errCode:" + i16 + " safeLevel:" + i17 + " tipString:" + str2 + " jumpDetailUrl:" + str3);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker.CheckTask.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (CheckTask.this.f207454j) {
                                        return;
                                    }
                                    CheckTask.this.d(i16, i17, str2, str3, null);
                                }
                            });
                        }
                    });
                    e();
                }
            }
            str = "";
            HashMap hashMap2 = new HashMap();
            IteApkInfoReq.Builder localQQ2 = IteApkInfoReq.newBuilder().pkgName(this.f207449e).certMd5(str).fileName(this.f207445a).fileSize(this.f207448d).fileMd5(this.f207447c.f207480g).fileSha1(this.f207447c.f207481h).localQQ("");
            i3 = this.f207447c.f207474a;
            if (i3 != 1) {
            }
            QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] <" + this.f207455k + "> run check task. fileName:" + this.f207445a + " pkgName:" + this.f207449e + " fileSize:" + this.f207448d + " pkgSignMd5:" + str + " " + this.f207447c.toString());
            hashMap2.put(Integer.valueOf(this.f207455k), localQQ2.build());
            TuringSecurityService.checkApk(hashMap2, new IteApkInfoRespCallback() { // from class: com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker.CheckTask.2
                @Override // com.tencent.turingfd.sdk.xq.IteApkInfoRespCallback
                public void onResult(long j3, Map<Integer, IteApkInfoResp> map) {
                    final int i16;
                    final int i17;
                    final String str2;
                    final String str3;
                    IteApkInfoResp iteApkInfoResp;
                    if (map != null && (iteApkInfoResp = map.get(Integer.valueOf(CheckTask.this.f207455k))) != null) {
                        int errorCode = (int) iteApkInfoResp.getErrorCode();
                        int safeLevel = iteApkInfoResp.getSafeLevel();
                        String riskTips = iteApkInfoResp.getRiskTips();
                        str3 = iteApkInfoResp.getHandleUrl();
                        i16 = errorCode;
                        i17 = safeLevel;
                        str2 = riskTips;
                    } else {
                        i16 = 2;
                        i17 = 0;
                        str2 = "";
                        str3 = str2;
                    }
                    QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] <" + CheckTask.this.f207455k + "> on checkresult. errCode:" + i16 + " safeLevel:" + i17 + " tipString:" + str2 + " jumpDetailUrl:" + str3);
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker.CheckTask.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (CheckTask.this.f207454j) {
                                return;
                            }
                            CheckTask.this.d(i16, i17, str2, str3, null);
                        }
                    });
                }
            });
            e();
        }

        void d(int i3, int i16, String str, String str2, Bundle bundle) {
            if (this.f207454j) {
                return;
            }
            QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] <" + this.f207455k + "> task complete. errCode:" + i3 + " safeLevel:" + i16 + " tipString:" + str + " jumpDetailUrl:" + str2);
            this.f207454j = true;
            b();
            Iterator<f> it = this.f207451g.iterator();
            while (it.hasNext()) {
                it.next().a(i3, i16, str, str2, bundle);
            }
            h hVar = this.f207452h;
            if (hVar != null) {
                hVar.b(this.f207446b, null);
            }
        }

        synchronized void e() {
            if (this.f207453i != null) {
                return;
            }
            QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] <" + this.f207455k + "> setTimeoutTimer");
            BaseTimer baseTimer = new BaseTimer();
            this.f207453i = baseTimer;
            baseTimer.schedule(new TimerTask() { // from class: com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker.CheckTask.3
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (CheckTask.this.f207454j) {
                        return;
                    }
                    CheckTask.this.b();
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker.CheckTask.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (CheckTask.this.f207454j) {
                                return;
                            }
                            QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] <" + CheckTask.this.f207455k + "> check timeout!");
                            CheckTask.this.d(1, 0, "", "", null);
                        }
                    });
                }
            }, 40000L);
        }

        void f() {
            QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] <" + this.f207455k + "> start check task. filePath:" + this.f207446b);
            this.f207454j = false;
            if (TextUtils.isEmpty(this.f207447c.f207480g) && TextUtils.isEmpty(this.f207447c.f207481h)) {
                final long currentTimeMillis = System.currentTimeMillis();
                QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] <" + this.f207455k + "> to get digest of file");
                this.f207452h.a(this.f207446b, new g() { // from class: com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker.CheckTask.1
                    @Override // com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker.g
                    public void a(boolean z16, e eVar) {
                        if (CheckTask.this.f207454j) {
                            return;
                        }
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (z16) {
                            CheckTask.this.f207447c.f207480g = HexUtil.bytes2HexStr(eVar.f207483a);
                            CheckTask.this.f207447c.f207481h = HexUtil.bytes2HexStr(eVar.f207484b);
                        }
                        QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] <" + CheckTask.this.f207455k + "> on get digest result:" + z16 + " cost:" + currentTimeMillis2 + " fileMd5:" + CheckTask.this.f207447c.f207480g + " fileSha:" + CheckTask.this.f207447c.f207481h);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker.CheckTask.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (CheckTask.this.f207454j) {
                                    return;
                                }
                                CheckTask.this.c();
                            }
                        });
                    }
                });
                return;
            }
            c();
        }

        void g() {
            QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] <" + this.f207455k + "> stop task");
            this.f207454j = true;
            b();
            this.f207451g.clear();
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements h {
        a() {
        }

        @Override // com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker.h
        public void a(String str, g gVar) {
            MMApkFileSafeChecker.this.q(str, gVar);
        }

        @Override // com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker.h
        public void b(String str, Bundle bundle) {
            MMApkFileSafeChecker.this.A(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FileManagerEntity f207469a;

        b(FileManagerEntity fileManagerEntity) {
            this.f207469a = fileManagerEntity;
        }

        @Override // com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker.f
        public void a(int i3, int i16, String str, String str2, Bundle bundle) {
            QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] onCheckResult. nSessionId=" + this.f207469a.nSessionId + " errCode:" + i3);
            if (i3 == 0 && i16 != 0 && i16 != 4) {
                FileManagerEntity fileManagerEntity = this.f207469a;
                fileManagerEntity.apkSafeLevel = i16;
                fileManagerEntity.apkSafeMsg = str;
                fileManagerEntity.apkSafeDetailUrl = str2;
                QQAppInterface qQAppInterface = MMApkFileSafeChecker.this.f207433a;
                if (qQAppInterface != null) {
                    qQAppInterface.getFileManagerDataCenter().f0(this.f207469a);
                }
            }
            QQAppInterface qQAppInterface2 = MMApkFileSafeChecker.this.f207433a;
            if (qQAppInterface2 != null) {
                qQAppInterface2.getFileManagerNotifyCenter().b(true, 200, new Object[]{Long.valueOf(this.f207469a.nSessionId), Integer.valueOf(i3), Integer.valueOf(i16), str, str2, bundle});
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TroopFileTransferManager.Item f207471a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f207472b;

        c(TroopFileTransferManager.Item item, long j3) {
            this.f207471a = item;
            this.f207472b = j3;
        }

        @Override // com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker.f
        public void a(int i3, int i16, String str, String str2, Bundle bundle) {
            QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] onCheckResult. Item.Id=" + this.f207471a.getId() + " errCode:" + i3);
            if (i3 == 0 && i16 != 0 && i16 != 4) {
                TroopFileTransferManager.Item item = this.f207471a;
                item.apkSafeLevel = i16;
                item.apkSafeMsg = str;
                item.apkSafeDetailUrl = str2;
                com.tencent.mobileqq.troop.filemanager.b.d(this.f207472b, item);
                QQAppInterface qQAppInterface = MMApkFileSafeChecker.this.f207433a;
                if (qQAppInterface != null && this.f207471a.Id != null) {
                    FileManagerDataCenter fileManagerDataCenter = qQAppInterface.getFileManagerDataCenter();
                    TroopFileTransferManager.Item item2 = this.f207471a;
                    FileManagerEntity N = fileManagerDataCenter.N(item2.troopuin, item2.Id.toString());
                    if (N != null) {
                        QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] onCheckResult. Item.Id=" + this.f207471a.getId() + " update about entity:" + N.nSessionId);
                        N.apkSafeLevel = i16;
                        N.apkSafeMsg = str;
                        N.apkSafeDetailUrl = str2;
                        MMApkFileSafeChecker.this.f207433a.getFileManagerDataCenter().f0(N);
                    }
                }
            }
            QQAppInterface qQAppInterface2 = MMApkFileSafeChecker.this.f207433a;
            if (qQAppInterface2 != null) {
                ((TroopFileHandler) qQAppInterface2.getBusinessHandler(BusinessHandlerFactory.TROOP_FILE_HANDLER)).H2(new Object[]{this.f207471a.getInfo(this.f207472b), Integer.valueOf(i3), Integer.valueOf(i16), str, str2, bundle});
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d {

        /* renamed from: a, reason: collision with root package name */
        int f207474a = 0;

        /* renamed from: b, reason: collision with root package name */
        String f207475b = "";

        /* renamed from: c, reason: collision with root package name */
        String f207476c = "";

        /* renamed from: d, reason: collision with root package name */
        String f207477d = "";

        /* renamed from: e, reason: collision with root package name */
        String f207478e = "";

        /* renamed from: f, reason: collision with root package name */
        String f207479f = "";

        /* renamed from: g, reason: collision with root package name */
        String f207480g = "";

        /* renamed from: h, reason: collision with root package name */
        String f207481h = "";

        d() {
        }

        @NonNull
        public String toString() {
            return "busiType:" + this.f207474a + " fileMd5:" + this.f207480g + " fileSha:" + this.f207481h;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class e {

        /* renamed from: a, reason: collision with root package name */
        byte[] f207483a;

        /* renamed from: b, reason: collision with root package name */
        byte[] f207484b;

        /* renamed from: c, reason: collision with root package name */
        long f207485c = 0;

        /* renamed from: d, reason: collision with root package name */
        long f207486d;

        e() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface f {
        void a(int i3, int i16, String str, String str2, Bundle bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface g {
        void a(boolean z16, e eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface h {
        void a(String str, g gVar);

        void b(String str, Bundle bundle);
    }

    public MMApkFileSafeChecker(QQAppInterface qQAppInterface) {
        this.f207433a = qQAppInterface;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(String str) {
        this.f207434b.remove(str);
        QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] remTask size:" + this.f207434b.size() + " filePath:" + str);
    }

    private boolean B(String str, d dVar, f fVar) {
        Signature[] signatureArr;
        String str2;
        if (5 != FileManagerUtil.getFileType(str)) {
            return false;
        }
        QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] startCheckLocalApk. filePath=" + str + " binfo:" + dVar.toString());
        if (v(str)) {
            QLog.w("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] startCheckLocalApk. is checking");
            h(str, fVar);
            return true;
        }
        if (!q.p(str)) {
            QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] startCheckLocalApk. file not exists");
            return false;
        }
        long fileSizes = FileManagerUtil.getFileSizes(str);
        try {
            PackageInfo packageArchiveInfo = BaseApplication.getContext().getBaseContext().getPackageManager().getPackageArchiveInfo(str, 64);
            if (packageArchiveInfo != null) {
                signatureArr = packageArchiveInfo.signatures;
            } else {
                signatureArr = null;
            }
            Signature[] signatureArr2 = signatureArr;
            if (packageArchiveInfo != null) {
                str2 = packageArchiveInfo.packageName;
            } else {
                str2 = "";
            }
            CheckTask o16 = o(str, str2, signatureArr2, fileSizes, dVar, this.f207437e);
            if (o16 == null) {
                return false;
            }
            o16.a(fVar);
            j(str, o16);
            o16.f();
            return true;
        } catch (Exception e16) {
            QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] startCheckLocalApk. exception:" + e16.toString());
            return false;
        } catch (OutOfMemoryError e17) {
            QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] startCheckLocalApk. out of memory:" + e17.toString());
            return false;
        }
    }

    private void C() {
        if (this.f207435c == null) {
            QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] start DigestGet pool");
            try {
                ThreadPoolParams threadPoolParams = new ThreadPoolParams();
                threadPoolParams.priority = 5;
                threadPoolParams.poolThreadName = "FileDigestGetPool";
                this.f207435c = ThreadManagerV2.newFreeThreadPool(threadPoolParams);
            } catch (Exception e16) {
                QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] start DigestGet pool exception:" + e16.toString());
            }
        }
    }

    private void h(String str, f fVar) {
        CheckTask checkTask = this.f207434b.get(str);
        if (checkTask != null) {
            checkTask.a(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void i(String str, e eVar) {
        if (this.f207436d.size() > 50) {
            String str2 = "";
            long j3 = Long.MAX_VALUE;
            for (Map.Entry<String, e> entry : this.f207436d.entrySet()) {
                if (entry.getValue().f207486d < j3) {
                    j3 = entry.getValue().f207486d;
                    str2 = entry.getKey();
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                this.f207436d.remove(str2);
            }
        }
        this.f207436d.put(str, eVar);
    }

    private void j(String str, CheckTask checkTask) {
        if (this.f207434b.containsKey(str)) {
            return;
        }
        this.f207434b.put(str, checkTask);
        QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] addTask size:" + this.f207434b.size() + " filePath:" + str);
    }

    private synchronized void m() {
        this.f207436d.clear();
    }

    private void n() {
        if (this.f207435c != null) {
            QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] close DigestGet pool");
            try {
                Executor executor = this.f207435c;
                if (executor instanceof ExecutorService) {
                    ((ExecutorService) executor).shutdown();
                }
            } catch (Exception e16) {
                QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] close DigestGet pool exception:" + e16.toString());
            }
            this.f207435c = null;
        }
    }

    private CheckTask o(String str, String str2, Signature[] signatureArr, long j3, d dVar, h hVar) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] createCheckTask fail. filePath is null");
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] createCheckTask fail. pkgName is null");
            return null;
        }
        if (j3 == 0) {
            QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] createCheckTask fail. fileSize is 0");
            return null;
        }
        if (dVar == null) {
            QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] createCheckTask fail. fileBusiInfo is null");
            return null;
        }
        if (hVar == null) {
            QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] createCheckTask fail. safeCheckerProxy is null");
            return null;
        }
        return new CheckTask(str, str2, signatureArr, j3, dVar, hVar);
    }

    private synchronized e p(String str) {
        return this.f207436d.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q(final String str, final g gVar) {
        e p16 = p(str);
        if (p16 != null && p16.f207483a != null && p16.f207484b != null) {
            if (q.m(str) == p16.f207485c) {
                gVar.a(true, p16);
                return true;
            }
            z(str);
        }
        C();
        this.f207435c.execute(new Runnable() { // from class: com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker.6
            /* JADX WARN: Not initialized variable reg: 2, insn: 0x00ca: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:203), block:B:81:0x00ca */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0035 A[Catch: IOException -> 0x0072, FileNotFoundException -> 0x0075, all -> 0x00c9, LOOP:0: B:15:0x002f->B:17:0x0035, LOOP_END, TRY_LEAVE, TryCatch #6 {all -> 0x00c9, blocks: (B:6:0x0010, B:8:0x0012, B:10:0x0019, B:15:0x002f, B:17:0x0035, B:19:0x003c, B:20:0x0044, B:22:0x0048, B:52:0x007d, B:42:0x008b, B:60:0x0041, B:61:0x0060, B:71:0x0025), top: B:2:0x0002 }] */
            /* JADX WARN: Removed duplicated region for block: B:18:0x003c A[EDGE_INSN: B:18:0x003c->B:19:0x003c BREAK  A[LOOP:0: B:15:0x002f->B:17:0x0035], EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:28:0x00b4  */
            /* JADX WARN: Removed duplicated region for block: B:84:0x00cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                BufferedInputStream bufferedInputStream;
                byte[] bArr;
                InputStream inputStream;
                e eVar;
                byte[] bArr2;
                MessageDigest messageDigest;
                MessageDigest messageDigest2;
                int read;
                boolean z16 = false;
                InputStream inputStream2 = null;
                byte[] bArr3 = null;
                try {
                    try {
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
                        try {
                            bArr2 = new byte[10240];
                            try {
                                messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                            } catch (NoSuchAlgorithmException e16) {
                                e = e16;
                                messageDigest = null;
                            }
                        } catch (FileNotFoundException e17) {
                            e = e17;
                            bArr = null;
                        } catch (IOException e18) {
                            e = e18;
                            bArr = null;
                        }
                    } catch (FileNotFoundException e19) {
                        e = e19;
                        bufferedInputStream = null;
                        bArr = null;
                    } catch (IOException e26) {
                        e = e26;
                        bufferedInputStream = null;
                        bArr = null;
                    } catch (Throwable th5) {
                        th = th5;
                        if (inputStream2 != null) {
                        }
                        throw th;
                    }
                    try {
                        try {
                            messageDigest2 = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA1);
                        } catch (NoSuchAlgorithmException e27) {
                            e = e27;
                            e.printStackTrace();
                            messageDigest2 = null;
                            if (messageDigest2 != null) {
                                while (true) {
                                    read = bufferedInputStream.read(bArr2);
                                    if (read <= 0) {
                                    }
                                    messageDigest.update(bArr2, 0, read);
                                    messageDigest2.update(bArr2, 0, read);
                                }
                                bufferedInputStream.close();
                                byte[] bArr4 = messageDigest.digest();
                                try {
                                    bArr3 = messageDigest2.digest();
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e28) {
                                        e28.printStackTrace();
                                    }
                                    z16 = true;
                                } catch (FileNotFoundException e29) {
                                    bArr = bArr4;
                                    e = e29;
                                    e.printStackTrace();
                                    if (bufferedInputStream != null) {
                                        try {
                                            bufferedInputStream.close();
                                        } catch (IOException e36) {
                                            e = e36;
                                            e.printStackTrace();
                                            bArr4 = bArr;
                                            eVar = new e();
                                            eVar.f207483a = bArr4;
                                            eVar.f207484b = bArr3;
                                            eVar.f207485c = q.m(str);
                                            eVar.f207486d = System.currentTimeMillis();
                                            if (z16) {
                                            }
                                            gVar.a(z16, eVar);
                                            return;
                                        }
                                    }
                                    bArr4 = bArr;
                                    eVar = new e();
                                    eVar.f207483a = bArr4;
                                    eVar.f207484b = bArr3;
                                    eVar.f207485c = q.m(str);
                                    eVar.f207486d = System.currentTimeMillis();
                                    if (z16) {
                                    }
                                    gVar.a(z16, eVar);
                                    return;
                                } catch (IOException e37) {
                                    bArr = bArr4;
                                    e = e37;
                                    e.printStackTrace();
                                    if (bufferedInputStream != null) {
                                        try {
                                            bufferedInputStream.close();
                                        } catch (IOException e38) {
                                            e = e38;
                                            e.printStackTrace();
                                            bArr4 = bArr;
                                            eVar = new e();
                                            eVar.f207483a = bArr4;
                                            eVar.f207484b = bArr3;
                                            eVar.f207485c = q.m(str);
                                            eVar.f207486d = System.currentTimeMillis();
                                            if (z16) {
                                            }
                                            gVar.a(z16, eVar);
                                            return;
                                        }
                                    }
                                    bArr4 = bArr;
                                    eVar = new e();
                                    eVar.f207483a = bArr4;
                                    eVar.f207484b = bArr3;
                                    eVar.f207485c = q.m(str);
                                    eVar.f207486d = System.currentTimeMillis();
                                    if (z16) {
                                    }
                                    gVar.a(z16, eVar);
                                    return;
                                }
                                eVar = new e();
                                eVar.f207483a = bArr4;
                                eVar.f207484b = bArr3;
                                eVar.f207485c = q.m(str);
                                eVar.f207486d = System.currentTimeMillis();
                                if (z16) {
                                    MMApkFileSafeChecker.this.i(str, eVar);
                                }
                                gVar.a(z16, eVar);
                                return;
                            }
                            QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, "sha or md5 is null");
                            bufferedInputStream.close();
                            return;
                        }
                        bufferedInputStream.close();
                        return;
                    } catch (IOException e39) {
                        e39.printStackTrace();
                        return;
                    }
                    if (messageDigest2 != null && messageDigest != null) {
                        while (true) {
                            read = bufferedInputStream.read(bArr2);
                            if (read <= 0) {
                                messageDigest.update(bArr2, 0, read);
                                messageDigest2.update(bArr2, 0, read);
                            } else {
                                try {
                                    break;
                                } catch (IOException e46) {
                                    e46.printStackTrace();
                                }
                            }
                        }
                        bufferedInputStream.close();
                        byte[] bArr42 = messageDigest.digest();
                        bArr3 = messageDigest2.digest();
                        bufferedInputStream.close();
                        z16 = true;
                        eVar = new e();
                        eVar.f207483a = bArr42;
                        eVar.f207484b = bArr3;
                        eVar.f207485c = q.m(str);
                        eVar.f207486d = System.currentTimeMillis();
                        if (z16 && eVar.f207483a != null && eVar.f207484b != null) {
                            MMApkFileSafeChecker.this.i(str, eVar);
                        }
                        gVar.a(z16, eVar);
                        return;
                    }
                    QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, "sha or md5 is null");
                } catch (Throwable th6) {
                    th = th6;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e47) {
                            e47.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void x(long j3, TroopFileTransferManager.Item item) {
        d dVar = new d();
        dVar.f207475b = this.f207433a.getCurrentAccountUin();
        dVar.f207474a = 2;
        dVar.f207477d = String.valueOf(j3);
        dVar.f207479f = item.FilePath;
        QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] checkLocalApk. Item.Id=" + item.getId() + " binfo:" + dVar.toString());
        B(item.LocalFile, dVar, new c(item, j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void w(FileManagerEntity fileManagerEntity) {
        d dVar = new d();
        dVar.f207475b = this.f207433a.getCurrentAccountUin();
        dVar.f207474a = 1;
        int i3 = fileManagerEntity.peerType;
        if (i3 != 0 && i3 != 3 && i3 != 1000) {
            QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] interCheckLocalApk err. is no buddy apk");
            return;
        }
        dVar.f207476c = fileManagerEntity.peerUin;
        dVar.f207478e = fileManagerEntity.Uuid;
        QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] interCheckLocalApk. nSessionId=" + fileManagerEntity.nSessionId + " binfo:" + dVar.toString());
        B(fileManagerEntity.strFilePath, dVar, new b(fileManagerEntity));
    }

    private boolean u() {
        return ((IQFileConfigManager) this.f207433a.getRuntimeService(IQFileConfigManager.class, "")).isMMApkFileCheckEnable();
    }

    private boolean v(String str) {
        return this.f207434b.containsKey(str);
    }

    private synchronized void z(String str) {
        this.f207436d.remove(str);
    }

    public void k(final long j3, final TroopFileTransferManager.Item item) {
        if (!u()) {
            return;
        }
        if (item == null) {
            QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] checkLocalApk err. troopFileItem=null");
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (an.i()) {
            if (Thread.currentThread() == mainLooper.getThread()) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.filemanager.core.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        MMApkFileSafeChecker.this.x(j3, item);
                    }
                }, 16, null, true);
                return;
            } else {
                x(j3, item);
                return;
            }
        }
        if (Thread.currentThread() != mainLooper.getThread()) {
            new Handler(mainLooper).post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker.4
                @Override // java.lang.Runnable
                public void run() {
                    MMApkFileSafeChecker.this.x(j3, item);
                }
            });
        } else {
            x(j3, item);
        }
    }

    public void l(final FileManagerEntity fileManagerEntity) {
        if (!u()) {
            return;
        }
        if (fileManagerEntity == null) {
            QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] checkLocalApk err. entity=null");
            return;
        }
        QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] checkLocalApk. entity.nSessionId=" + fileManagerEntity.nSessionId);
        Looper mainLooper = Looper.getMainLooper();
        if (an.i()) {
            if (Thread.currentThread() == mainLooper.getThread()) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.filemanager.core.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        MMApkFileSafeChecker.this.w(fileManagerEntity);
                    }
                }, 16, null, true);
                return;
            } else {
                w(fileManagerEntity);
                return;
            }
        }
        if (Thread.currentThread() != mainLooper.getThread()) {
            new Handler(mainLooper).post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker.2
                @Override // java.lang.Runnable
                public void run() {
                    MMApkFileSafeChecker.this.w(fileManagerEntity);
                }
            });
        } else {
            w(fileManagerEntity);
        }
    }

    public void r() {
        QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] init.");
    }

    public void y() {
        QLog.w("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] release.");
        Iterator<CheckTask> it = this.f207434b.values().iterator();
        while (it.hasNext()) {
            it.next().g();
        }
        n();
        this.f207434b.clear();
        m();
        this.f207433a = null;
    }
}
