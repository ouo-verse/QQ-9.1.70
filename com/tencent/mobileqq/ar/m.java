package com.tencent.mobileqq.ar;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.arengine.ai;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.ArModelResource;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xweb.FileReaderX5;
import cooperation.qzone.QzoneIPCModule;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes11.dex */
public class m implements INetEngineListener {
    private IHttpEngineService F;

    /* renamed from: d, reason: collision with root package name */
    public AppInterface f198375d;

    /* renamed from: e, reason: collision with root package name */
    public ArResourceManager f198376e;

    /* renamed from: f, reason: collision with root package name */
    private final byte[] f198377f = new byte[0];

    /* renamed from: h, reason: collision with root package name */
    Set<String> f198378h = Collections.synchronizedSet(new HashSet());

    /* renamed from: i, reason: collision with root package name */
    ArrayList<a> f198379i = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name */
    private long f198380m = 0;
    private long C = 0;
    private boolean D = false;
    private boolean E = false;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int f198381a;

        /* renamed from: b, reason: collision with root package name */
        String f198382b;

        /* renamed from: c, reason: collision with root package name */
        String f198383c;

        /* renamed from: d, reason: collision with root package name */
        String f198384d;

        /* renamed from: e, reason: collision with root package name */
        int f198385e;

        /* renamed from: f, reason: collision with root package name */
        long f198386f;

        /* renamed from: g, reason: collision with root package name */
        long f198387g;

        /* renamed from: h, reason: collision with root package name */
        boolean f198388h = false;

        /* renamed from: i, reason: collision with root package name */
        boolean f198389i = false;

        /* renamed from: j, reason: collision with root package name */
        HttpNetReq f198390j;

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("DownloadInfo{");
            stringBuffer.append("type=");
            stringBuffer.append(this.f198381a);
            stringBuffer.append(", url='");
            stringBuffer.append(this.f198382b);
            stringBuffer.append('\'');
            stringBuffer.append(", md5='");
            stringBuffer.append(this.f198383c);
            stringBuffer.append('\'');
            stringBuffer.append(", fileName='");
            stringBuffer.append(this.f198384d);
            stringBuffer.append('\'');
            stringBuffer.append(", fileSize=");
            stringBuffer.append(this.f198386f);
            stringBuffer.append(", downloadSize=");
            stringBuffer.append(this.f198387g);
            stringBuffer.append(", req=");
            stringBuffer.append(this.f198388h);
            stringBuffer.append('}');
            return stringBuffer.toString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class b extends AbsPreDownloadTask {

        /* renamed from: d, reason: collision with root package name */
        a f198391d;

        /* renamed from: e, reason: collision with root package name */
        m f198392e;

        public b(QQAppInterface qQAppInterface, a aVar, m mVar) {
            super(qQAppInterface, aVar.f198383c);
            this.f198391d = aVar;
            this.f198392e = mVar;
        }

        @Override // com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask
        protected void realCancel() {
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_ArResourceDownload", 2, "DownloadTask realCancel");
            }
        }

        @Override // com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask
        protected void realStart() {
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_ArResourceDownload", 2, "DownloadTask realStart");
            }
            this.f198392e.d(this.f198391d);
        }

        @Override // com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask
        public String toString() {
            return "[DownloadTask] mInfo=" + this.f198391d + ", mDownloader=" + this.f198392e;
        }
    }

    public m(AppInterface appInterface, ArResourceManager arResourceManager) {
        this.f198375d = appInterface;
        this.f198376e = arResourceManager;
    }

    private void c(ArCloudConfigInfo arCloudConfigInfo) {
        File file;
        String str;
        String str2;
        if (arCloudConfigInfo.f197702i == 100) {
            String str3 = "";
            if (arCloudConfigInfo.F != null) {
                file = new File(arCloudConfigInfo.F.D);
                str = i.e() + "ar_model/" + arCloudConfigInfo.f197702i + File.separator + arCloudConfigInfo.F.f198421e + "_model.zip";
            } else {
                file = null;
                str = "";
            }
            if (file == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("ArConfig_ArResourceDownload", 2, "copyAndCheckBinHai3dRes return for null zipfile");
                    return;
                }
                return;
            }
            File file2 = new File(str);
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_ArResourceDownload", 2, "downloadArResource:binhai:oldFilePath=" + str + ", exist=" + file2.exists());
            }
            if (file2.exists() && !file.exists()) {
                boolean mkdirs = file.mkdirs();
                QLog.d("ArConfig_ArResourceDownload", 1, "downloadArResource:binhai:copy old to new dir, ret=" + FileUtils.copyFile(file2, file) + ", mkRet=" + mkdirs);
            }
            if (file.exists()) {
                try {
                    str3 = com.tencent.mobileqq.portal.o.e(file.getAbsolutePath());
                    if (QLog.isColorLevel()) {
                        QLog.d("ArConfig_ArResourceDownload", 2, "download binhai calc md5=" + str3 + ", modelMd5=" + arCloudConfigInfo.F.f198421e);
                    }
                    if (!arCloudConfigInfo.F.f198421e.equalsIgnoreCase(str3)) {
                        file.delete();
                    }
                } catch (Throwable th5) {
                    QLog.e("ArConfig_ArResourceDownload", 1, "download binhai check md5 error", th5);
                }
            }
            boolean exists = file.exists();
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("md5", str3);
            hashMap.put("uin", this.f198375d.getCurrentAccountUin());
            if (exists) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            hashMap.put("exist", str2);
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "binhai_predownload", exists, 0L, 0L, hashMap, "", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(a aVar) {
        if (!TextUtils.isEmpty(aVar.f198382b) && !TextUtils.isEmpty(aVar.f198383c)) {
            if (QLog.isColorLevel()) {
                QLog.i("ArConfig_ArResourceDownload", 2, "downLoad:url=" + aVar.f198382b + ",md5= " + aVar.f198383c);
            }
            aVar.f198385e++;
            if (this.F == null) {
                this.F = (IHttpEngineService) this.f198375d.getRuntimeService(IHttpEngineService.class, "all");
            }
            HttpNetReq httpNetReq = new HttpNetReq();
            httpNetReq.mCallback = this;
            httpNetReq.mReqUrl = aVar.f198382b;
            httpNetReq.mHttpMethod = 0;
            httpNetReq.mOutPath = aVar.f198384d;
            httpNetReq.mPrioty = 1;
            httpNetReq.setUserData(aVar);
            httpNetReq.mSupportBreakResume = true;
            this.F.sendReq(httpNetReq);
            aVar.f198390j = httpNetReq;
        }
    }

    private boolean f(ArConfigInfo arConfigInfo) {
        if (arConfigInfo == null) {
            return true;
        }
        try {
            if (!arConfigInfo.mArCloudConfigInfos.isEmpty()) {
                Iterator<ArCloudConfigInfo> it = arConfigInfo.mArCloudConfigInfos.iterator();
                while (it.hasNext()) {
                    ArCloudConfigInfo next = it.next();
                    if (!FileUtils.fileExists(next.E.f198412h)) {
                        return false;
                    }
                    int i3 = next.f197702i;
                    if (i3 == 0 || i3 == 100) {
                        if (next.F != null && !new File(next.F.D).exists()) {
                            return false;
                        }
                    }
                }
            }
            return true;
        } catch (Exception e16) {
            QLog.i("ArConfig_ArResourceDownload", 1, "isResourceReady e=" + e16.getMessage());
            return true;
        }
    }

    public void b() {
        if (this.D) {
            synchronized (this.f198377f) {
                Iterator<a> it = this.f198379i.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next.f198387g < next.f198386f) {
                        this.F.cancelReq(next.f198390j);
                    }
                }
                this.f198379i.clear();
            }
            this.D = false;
            this.f198378h.clear();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x02c4, code lost:
    
        r23.f198379i.remove(r0);
        r23.f198378h.remove(r5.f198383c);
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x039a A[Catch: all -> 0x03a5, TryCatch #5 {, blocks: (B:15:0x002f, B:71:0x003a, B:73:0x003e, B:75:0x0044, B:76:0x004b, B:78:0x0051, B:80:0x0059, B:82:0x005d, B:85:0x0067, B:87:0x0071, B:89:0x007b, B:91:0x009e, B:92:0x00aa, B:97:0x00b7, B:99:0x00bb, B:101:0x00c1, B:102:0x00c7, B:104:0x00cd, B:107:0x00d9, B:124:0x00e6, B:110:0x010d, B:112:0x0113, B:114:0x0119, B:120:0x0122, B:122:0x012c, B:127:0x00f0, B:135:0x0154, B:137:0x0158, B:139:0x0165, B:141:0x016b, B:143:0x0177, B:145:0x017d, B:147:0x0183, B:150:0x018d, B:153:0x01c0, B:158:0x01cd, B:160:0x01fc, B:164:0x0209, B:166:0x0214, B:167:0x0224, B:169:0x0230, B:174:0x023d, B:178:0x024b, B:18:0x026e, B:20:0x0276, B:22:0x027c, B:23:0x029a, B:25:0x02a4, B:29:0x02ae, B:31:0x02b8, B:34:0x02c4, B:42:0x02d2, B:44:0x02ed, B:49:0x0316, B:51:0x0349, B:52:0x034b, B:54:0x0351, B:36:0x039a, B:37:0x03a2, B:62:0x0371, B:64:0x037c, B:69:0x039d, B:181:0x0252), top: B:14:0x002f, outer: #6, inners: #7 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void e(ArConfigInfo arConfigInfo, boolean z16, boolean z17) {
        ArFeatureInfo arFeatureInfo;
        File file;
        String str;
        String e16;
        int i3;
        int i16;
        if (QLog.isColorLevel()) {
            QLog.i("ArConfig_ArResourceDownload", 2, "downloadArResource|isDownloading=" + this.D);
        }
        if (this.D) {
            return;
        }
        synchronized (this.f198377f) {
            this.f198379i.clear();
            int i17 = 4;
            if (arConfigInfo != null) {
                try {
                    ArrayList<ArCloudConfigInfo> arrayList = arConfigInfo.mArCloudConfigInfos;
                    if (arrayList != null && arrayList.size() > 0) {
                        Iterator<ArCloudConfigInfo> it = arConfigInfo.mArCloudConfigInfos.iterator();
                        boolean z18 = false;
                        while (it.hasNext()) {
                            ArCloudConfigInfo next = it.next();
                            if (next != null && (arFeatureInfo = next.E) != null && !TextUtils.isEmpty(arFeatureInfo.f198411f)) {
                                if (!TextUtils.isEmpty(next.E.f198412h) && !FileUtils.fileExists(next.E.f198412h)) {
                                    a aVar = new a();
                                    aVar.f198381a = 2;
                                    ArFeatureInfo arFeatureInfo2 = next.E;
                                    aVar.f198382b = arFeatureInfo2.f198411f;
                                    String str2 = arFeatureInfo2.f198409d;
                                    aVar.f198383c = str2;
                                    aVar.f198384d = arFeatureInfo2.f198412h;
                                    aVar.f198386f = arFeatureInfo2.f198410e;
                                    aVar.f198388h = true;
                                    if (!this.f198378h.contains(str2)) {
                                        this.f198378h.add(aVar.f198383c);
                                        this.f198379i.add(aVar);
                                    }
                                }
                                c(next);
                                int i18 = next.f197702i;
                                if (i18 != 0 && i18 != 100) {
                                    ArrayList<ArVideoResourceInfo> arrayList2 = next.D;
                                    if (arrayList2 != null && arrayList2.size() > 0) {
                                        Iterator<ArVideoResourceInfo> it5 = next.D.iterator();
                                        while (it5.hasNext()) {
                                            ArVideoResourceInfo next2 = it5.next();
                                            if (next2.D != i17) {
                                                File file2 = new File(next2.F);
                                                if (file2.exists()) {
                                                    try {
                                                        e16 = com.tencent.mobileqq.portal.o.e(file2.getAbsolutePath());
                                                    } catch (UnsatisfiedLinkError e17) {
                                                        QLog.e("ArConfig_ArResourceDownload", 1, "e" + e17.getMessage());
                                                    }
                                                    if ((file2.exists() || TextUtils.isEmpty(e16) || !e16.equals(next2.f198430i)) && !this.f198378h.contains(next2.E)) {
                                                        a aVar2 = new a();
                                                        aVar2.f198381a = 3;
                                                        aVar2.f198382b = next2.E;
                                                        aVar2.f198383c = next2.f198430i;
                                                        aVar2.f198386f = next2.f198427e;
                                                        aVar2.f198384d = next2.F;
                                                        aVar2.f198388h = true;
                                                        this.f198379i.add(aVar2);
                                                        this.f198378h.add(next2.f198430i);
                                                    }
                                                    i17 = 4;
                                                }
                                                e16 = null;
                                                if (file2.exists()) {
                                                }
                                                a aVar22 = new a();
                                                aVar22.f198381a = 3;
                                                aVar22.f198382b = next2.E;
                                                aVar22.f198383c = next2.f198430i;
                                                aVar22.f198386f = next2.f198427e;
                                                aVar22.f198384d = next2.F;
                                                aVar22.f198388h = true;
                                                this.f198379i.add(aVar22);
                                                this.f198378h.add(next2.f198430i);
                                                i17 = 4;
                                            }
                                        }
                                    }
                                    i17 = 4;
                                }
                                if (next.F != null) {
                                    file = new File(next.F.D);
                                } else {
                                    file = null;
                                }
                                if (file != null && file.exists()) {
                                    str = com.tencent.mobileqq.portal.o.e(file.getAbsolutePath());
                                } else {
                                    str = null;
                                }
                                if (file != null && file.exists() && !TextUtils.isEmpty(str) && str.equals(next.F.f198421e)) {
                                    try {
                                        File file3 = new File(next.F.D);
                                        String str3 = next.F.D;
                                        StringBuilder sb5 = new StringBuilder();
                                        sb5.append(file3.getParentFile().getAbsolutePath());
                                        String str4 = File.separator;
                                        sb5.append(str4);
                                        sb5.append(next.F.f198421e);
                                        sb5.append(str4);
                                        ai.c(str3, sb5.toString());
                                        try {
                                            QLog.i("ArConfig_ArResourceDownload", 1, "onARMarkerModelDownloadComplete  ");
                                            z18 = true;
                                        } catch (Exception unused) {
                                            z18 = true;
                                            new File(next.F.D).delete();
                                            a aVar3 = new a();
                                            aVar3.f198381a = 3;
                                            ArModelResource arModelResource = next.F;
                                            aVar3.f198382b = arModelResource.f198422f;
                                            String str5 = arModelResource.f198421e;
                                            aVar3.f198383c = str5;
                                            aVar3.f198384d = arModelResource.D;
                                            aVar3.f198386f = arModelResource.f198420d;
                                            aVar3.f198388h = true;
                                            if (!this.f198378h.contains(str5)) {
                                                this.f198378h.add(aVar3.f198383c);
                                                this.f198379i.add(aVar3);
                                            }
                                            i17 = 4;
                                        }
                                    } catch (Exception unused2) {
                                    }
                                } else {
                                    a aVar4 = new a();
                                    aVar4.f198381a = 3;
                                    ArModelResource arModelResource2 = next.F;
                                    if (arModelResource2 != null) {
                                        aVar4.f198382b = arModelResource2.f198422f;
                                        aVar4.f198383c = arModelResource2.f198421e;
                                        aVar4.f198384d = arModelResource2.D;
                                        aVar4.f198386f = arModelResource2.f198420d;
                                    }
                                    aVar4.f198388h = true;
                                    if (!this.f198378h.contains(aVar4.f198383c)) {
                                        this.f198378h.add(aVar4.f198383c);
                                        this.f198379i.add(aVar4);
                                    }
                                }
                                i17 = 4;
                            }
                            QLog.i("ArConfig_ArResourceDownload", 1, "resource null continue ");
                            i17 = 4;
                        }
                        if (z18) {
                            this.f198376e.u(arConfigInfo);
                        }
                    }
                } catch (Exception e18) {
                    QLog.d("ArConfig_ArResourceDownload", 2, "e" + e18.getMessage());
                }
            }
            if (this.f198379i.size() > 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("ArConfig_ArResourceDownload", 2, "downloadArResource|download num= " + this.f198379i.size());
                }
                this.f198380m = 0L;
                this.C = 0L;
                this.D = true;
                this.E = false;
                try {
                    int size = this.f198379i.size() - 1;
                    i3 = 0;
                    while (true) {
                        if (size < 0) {
                            break;
                        }
                        try {
                            a aVar5 = this.f198379i.get(size);
                            if (z16) {
                                aVar5.f198389i = true;
                                if (!this.f198376e.b(aVar5.f198383c)) {
                                    break;
                                }
                            }
                            this.f198380m += aVar5.f198386f;
                            int k3 = ((ArResourceManager) this.f198375d.getManager(QQManagerFactory.AR_RESOURCE_MANAGER)).k();
                            if (QLog.isColorLevel()) {
                                QLog.d("ArConfig_ArResourceDownload", 2, "dpcNet=" + k3);
                            }
                            if (k3 != 1) {
                                if (k3 != 2) {
                                    if (k3 != 3) {
                                        i16 = 4;
                                    } else {
                                        i16 = 1;
                                    }
                                } else {
                                    i16 = 3;
                                }
                            } else {
                                i16 = 2;
                            }
                            boolean requestPreDownload = ((IPreDownloadController) ((QQAppInterface) this.f198375d).getRuntimeService(IPreDownloadController.class)).requestPreDownload(10067, PreDownloadConstants.DEPARTMENT_PRD, aVar5.f198383c, 0, aVar5.f198382b, aVar5.f198384d, i16, 0, true, new b((QQAppInterface) this.f198375d, aVar5, this));
                            if (requestPreDownload) {
                                i3++;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("ArConfig_ArResourceDownload", 2, " downloadArResource.ret=" + requestPreDownload);
                            }
                            size--;
                        } catch (Exception e19) {
                            e = e19;
                            this.f198378h.clear();
                            if (QLog.isColorLevel()) {
                                QLog.d("ArConfig_ArResourceDownload", 2, "e= " + e.getMessage());
                            }
                            if (i3 == 0) {
                            }
                        }
                    }
                } catch (Exception e26) {
                    e = e26;
                    i3 = 0;
                }
                if (i3 == 0) {
                    this.D = false;
                }
            } else {
                this.f198376e.i();
            }
        }
    }

    @Override // com.tencent.mobileqq.transfile.INetEngineListener
    public void onResp(NetResp netResp) {
        boolean z16;
        long j3;
        int i3;
        boolean z17;
        boolean z18;
        ArCloudConfigInfo modelResByMd5;
        int i16;
        int i17 = netResp.mResult;
        if (i17 == 3) {
            QLog.d("ArConfig_ArResourceDownload", 1, "doOnResp is downloading...");
            return;
        }
        if (i17 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i18 = netResp.mErrCode;
        HttpNetReq httpNetReq = (HttpNetReq) netResp.mReq;
        Object userData = httpNetReq.getUserData();
        if (userData != null && (userData instanceof a)) {
            ArConfigInfo j16 = this.f198376e.j();
            a aVar = (a) userData;
            if (TextUtils.isEmpty(httpNetReq.mOutPath)) {
                QLog.d("ArConfig_ArResourceDownload", 1, "req.mOutPath is null, md5=" + aVar.f198383c);
                if (z16) {
                    i18 = 98765;
                }
                i3 = i18;
                z17 = false;
            } else {
                i3 = i18;
                z17 = z16;
            }
            if (z17) {
                File file = new File(httpNetReq.mOutPath);
                String e16 = com.tencent.mobileqq.portal.o.e(file.getAbsolutePath());
                if (!TextUtils.isEmpty(e16) && !e16.equalsIgnoreCase(aVar.f198383c)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ArConfig_ArResourceDownload", 2, "Md5 error|fileMD5=" + e16 + ", type=" + aVar.f198381a);
                    }
                    if (aVar.f198381a != 1) {
                        file.delete();
                        i3 = -100001;
                        z17 = false;
                    }
                } else if (aVar.f198381a == 3) {
                    try {
                        synchronized (this.f198377f) {
                            if (j16 != null) {
                                try {
                                    modelResByMd5 = j16.getModelResByMd5(aVar.f198383c);
                                } finally {
                                }
                            } else {
                                modelResByMd5 = null;
                            }
                            if (!TextUtils.isEmpty(aVar.f198384d) && modelResByMd5 != null && ((i16 = modelResByMd5.f197702i) == 0 || i16 == 100)) {
                                File file2 = new File(aVar.f198384d);
                                String str = aVar.f198384d;
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append(file2.getParentFile().getAbsolutePath());
                                String str2 = File.separator;
                                sb5.append(str2);
                                sb5.append(aVar.f198383c);
                                sb5.append(str2);
                                ai.c(str, sb5.toString());
                                this.f198376e.u(j16);
                            }
                        }
                    } catch (Exception e17) {
                        file.delete();
                        if (aVar.f198388h) {
                            i3 = FileReaderX5.ERR_CODE_NOT_SUPPORT;
                            z17 = false;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("ArConfig_ArResourceDownload", 2, "e= " + e17.getMessage());
                        }
                    }
                }
                if (aVar.f198389i) {
                    this.f198376e.v(aVar.f198383c, true);
                }
            } else {
                if (aVar.f198385e <= 3 && !aVar.f198389i) {
                    d(aVar);
                    if (QLog.isColorLevel()) {
                        QLog.i("ArConfig_ArResourceDownload", 2, "retry downLoad:retryUrl=" + aVar.f198382b + ",retryMd5= " + aVar.f198383c);
                        return;
                    }
                    return;
                }
                if (aVar.f198389i) {
                    this.f198376e.v(aVar.f198383c, false);
                }
            }
            z16 = z17;
            if (this.f198378h.contains(aVar.f198383c)) {
                this.f198378h.remove(aVar.f198383c);
            }
            if (this.f198378h.isEmpty()) {
                this.D = false;
            }
            int i19 = aVar.f198381a;
            if (i19 != 1 && i19 != 2 && i19 != 3 && i19 != 4) {
                z18 = false;
            } else {
                z18 = true;
            }
            String str3 = "0";
            if (!TextUtils.isEmpty(netResp.mErrDesc)) {
                str3 = netResp.mErrDesc;
                if (QLog.isColorLevel()) {
                    QLog.d("ArConfig_ArResourceDownload", 2, "errDesc: " + str3);
                }
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("url", com.tencent.mobileqq.olympic.utils.a.a(httpNetReq.mReqUrl));
            hashMap.put(QzoneIPCModule.RESULT_CODE, String.valueOf(netResp.mResult));
            hashMap.put("fileSize", String.valueOf(aVar.f198386f));
            hashMap.put(ReportConstant.KEY_ERR_DESC, str3);
            if (z16) {
                hashMap.put("param_FailCode", "0");
                if (z18 && !this.D && f(j16)) {
                    synchronized (this.f198377f) {
                        if (!this.E) {
                            this.f198376e.i();
                            this.E = true;
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("ArConfig_ArResourceDownload", 2, "onResp:downloadSuccess!");
                    }
                }
            } else {
                hashMap.put("param_FailCode", String.valueOf(i3));
                this.f198378h.clear();
                synchronized (this.f198377f) {
                    this.D = false;
                    Iterator<a> it = this.f198379i.iterator();
                    while (it.hasNext()) {
                        a next = it.next();
                        if (next.f198387g < next.f198386f) {
                            this.F.cancelReq(next.f198390j);
                        }
                    }
                    if (z18 && !this.E) {
                        this.f198376e.f(i3, netResp.mResult);
                        this.E = true;
                    }
                }
            }
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f198375d.getCurrentAccountUin(), "olympic_ar_download", z16, 0L, 0L, hashMap, null);
        }
        File file3 = new File(httpNetReq.mOutPath);
        if (z16 && file3.exists()) {
            j3 = file3.length();
        } else {
            j3 = 0;
        }
        IPreDownloadController iPreDownloadController = (IPreDownloadController) this.f198375d.getRuntimeService(IPreDownloadController.class, "");
        String str4 = httpNetReq.mReqUrl;
        if (!z16) {
            j3 = -1;
        }
        iPreDownloadController.preDownloadSuccess(str4, j3);
        if (QLog.isColorLevel()) {
            QLog.i("ArConfig_ArResourceDownload", 2, "onResp:" + httpNetReq.mReqUrl + ", " + netResp.mResult + ", " + netResp.mErrCode);
        }
    }

    @Override // com.tencent.mobileqq.transfile.INetEngineListener
    public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
        Object userData = netReq.getUserData();
        if (userData != null && (userData instanceof a)) {
            a aVar = (a) userData;
            if (aVar.f198381a == 1) {
                return;
            }
            String str = aVar.f198383c;
            synchronized (this.f198377f) {
                Iterator<a> it = this.f198379i.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a next = it.next();
                    if (str.equals(next.f198383c)) {
                        long j17 = j3 - next.f198387g;
                        next.f198387g = j3;
                        this.C += j17;
                        break;
                    }
                }
                if (!this.E) {
                    this.f198376e.g(this.C, this.f198380m);
                }
            }
        }
    }
}
