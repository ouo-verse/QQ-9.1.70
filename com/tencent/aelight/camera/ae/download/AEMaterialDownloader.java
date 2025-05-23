package com.tencent.aelight.camera.ae.download;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEPreDownloadResMetaData;
import com.tencent.aelight.camera.ae.data.AEQZoneMaterialMetaData;
import com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialManager;
import com.tencent.aelight.camera.ae.flashshow.util.AEMaterialUtilKt;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialCategory;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.aelight.camera.util.api.IQIMShortVideoUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEMaterialDownloader {

    /* renamed from: a, reason: collision with root package name */
    private static final String f63571a = "AEMaterialDownloader";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class c implements INetEngineListener {

        /* renamed from: d, reason: collision with root package name */
        private AEMaterialMetaData f63575d;

        /* renamed from: e, reason: collision with root package name */
        private String f63576e;

        /* renamed from: f, reason: collision with root package name */
        private com.tencent.aelight.camera.download.a f63577f;

        public c(AEMaterialMetaData aEMaterialMetaData, String str, com.tencent.aelight.camera.download.a aVar) {
            this.f63575d = aEMaterialMetaData;
            this.f63576e = str;
            this.f63577f = aVar;
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            if (QLog.isColorLevel()) {
                QLog.i(AEMaterialDownloader.f63571a, 2, "onResp url: " + this.f63575d.resurl + " resultcode: " + netResp.mHttpCode + " cakeid :" + this.f63575d.cakeId);
            }
            this.f63575d.unZipFile();
            AEMaterialMetaData aEMaterialMetaData = this.f63575d;
            if (aEMaterialMetaData instanceof AEPreDownloadResMetaData) {
                aEMaterialMetaData.usable = true;
            } else {
                aEMaterialMetaData.usable = AEMaterialManager.W(aEMaterialMetaData);
            }
            AEMaterialMetaData aEMaterialMetaData2 = this.f63575d;
            aEMaterialMetaData2.downloading = false;
            com.tencent.aelight.camera.download.a aVar = this.f63577f;
            if (aVar != null) {
                aVar.onDownloadFinish(aEMaterialMetaData2, aEMaterialMetaData2.usable, netResp.mHttpCode);
            }
            int i3 = netResp.mErrCode;
            if (i3 != 0) {
                com.tencent.aelight.camera.ae.report.b b16 = com.tencent.aelight.camera.ae.report.b.b();
                AEMaterialMetaData aEMaterialMetaData3 = this.f63575d;
                b16.i1(aEMaterialMetaData3.f69050id, netResp.mErrCode, netResp.reqCost, 0L, aEMaterialMetaData3.md5);
            } else if (i3 == 0 && !this.f63575d.usable) {
                com.tencent.aelight.camera.ae.report.b b17 = com.tencent.aelight.camera.ae.report.b.b();
                AEMaterialMetaData aEMaterialMetaData4 = this.f63575d;
                b17.i1(aEMaterialMetaData4.f69050id, 1111, netResp.reqCost, 0L, aEMaterialMetaData4.md5);
            } else {
                File file = new File(this.f63576e, this.f63575d.name);
                long length = (file.exists() && file.isFile()) ? file.length() : 0L;
                com.tencent.aelight.camera.ae.report.b b18 = com.tencent.aelight.camera.ae.report.b.b();
                AEMaterialMetaData aEMaterialMetaData5 = this.f63575d;
                b18.i1(aEMaterialMetaData5.f69050id, netResp.mErrCode, netResp.reqCost, length, aEMaterialMetaData5.md5);
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
            AEMaterialMetaData aEMaterialMetaData = this.f63575d;
            aEMaterialMetaData.totalLen = j16;
            int i3 = (int) ((j3 * 100) / j16);
            aEMaterialMetaData.downloadProgress = i3;
            com.tencent.aelight.camera.download.a aVar = this.f63577f;
            if (aVar != null) {
                aVar.onProgressUpdate(aEMaterialMetaData, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(String str) {
        String str2 = f63571a;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("pre:downloadMaterialBundle exit");
        AEResInfo aEResInfo = AEResInfo.LIGHT_RES_BASE_PACKAGE;
        sb5.append(AEResUtil.V(aEResInfo.agentType));
        sb5.append(" ");
        sb5.append(((IQIMShortVideoUtil) QRoute.api(IQIMShortVideoUtil.class)).isPeakAlive(com.tencent.aelight.camera.aebase.a.a().getApplicationContext()));
        QLog.d(str2, 2, sb5.toString());
        if (((IQIMShortVideoUtil) QRoute.api(IQIMShortVideoUtil.class)).isPeakAlive(com.tencent.aelight.camera.aebase.a.a().getApplicationContext()) && AEResUtil.V(aEResInfo.agentType)) {
            AEResUtil.f(str);
        }
    }

    public static void g(final String str) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.download.AEMaterialDownloader.1
            @Override // java.lang.Runnable
            public void run() {
                AEMaterialDownloader.k(str);
            }
        }, 16, null, false);
    }

    public static void h(final String str) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.download.AEMaterialDownloader.2
            @Override // java.lang.Runnable
            public void run() {
                AEMaterialDownloader.m(str);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k(String str) {
        String str2 = f63571a;
        QLog.d(str2, 2, "pre:startDownloadMaterial");
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d(str2, 2, "pre: startDownloadMaterial is null");
                return;
            }
            return;
        }
        if (com.tencent.aelight.camera.aebase.a.a() != null && com.tencent.aelight.camera.aebase.a.a().getApplicationContext() != null) {
            if (!((IQIMShortVideoUtil) QRoute.api(IQIMShortVideoUtil.class)).isPeakAlive(com.tencent.aelight.camera.aebase.a.a().getApplicationContext())) {
                QLog.i(str2, 2, "pre: peak not Alive");
                return;
            }
            AEMaterialMetaData f16 = f(str);
            QLog.d(str2, 2, "pre: data " + f16);
            if (!AEMaterialManager.W(f16)) {
                if (f16 == null) {
                    return;
                }
                i(com.tencent.aelight.camera.aebase.a.a(), f16, f16.getZipDownloadPath(), new b(f16));
                return;
            } else {
                QLog.d(str2, 2, "pre: alread exit " + f16);
                e(f16.getLocalPath());
                return;
            }
        }
        QLog.i(str2, 2, "pre: appinterface or context is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m(String str) {
        String str2 = f63571a;
        QLog.d(str2, 2, "pre:startDownloadMaterialByUrl");
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d(str2, 2, "pre: materialUrl is null");
            }
        } else {
            AEQZoneMaterialMetaData createAEQZoneMaterialMetaData = AEQZoneMaterialMetaData.createAEQZoneMaterialMetaData(str);
            if (createAEQZoneMaterialMetaData == null) {
                QLog.d(str2, 2, "createAEQZoneMaterialMetaData failed, url is: ", str);
            } else {
                j(com.tencent.aelight.camera.aebase.a.a(), createAEQZoneMaterialMetaData, createAEQZoneMaterialMetaData.getZipDownloadPath(), new a());
            }
        }
    }

    private static AEMaterialMetaData f(String str) {
        AEFlashShowMaterialManager aEFlashShowMaterialManager = (AEFlashShowMaterialManager) com.tencent.aelight.camera.ae.control.a.b(3);
        aEFlashShowMaterialManager.F(false);
        Iterator<AEMaterialCategory> it = AEMaterialUtilKt.e(aEFlashShowMaterialManager.A(false), str).iterator();
        AEMaterialMetaData aEMaterialMetaData = null;
        while (it.hasNext()) {
            List<AEMaterialMetaData> list = it.next().f69044d;
            if (list != null) {
                Iterator<AEMaterialMetaData> it5 = list.iterator();
                while (true) {
                    if (it5.hasNext()) {
                        AEMaterialMetaData next = it5.next();
                        if (TextUtils.equals(str, next.f69050id)) {
                            ms.a.a(f63571a, "material " + next.name);
                            aEMaterialMetaData = next;
                            break;
                        }
                    }
                }
            }
        }
        return aEMaterialMetaData;
    }

    public static void l(AppRuntime appRuntime, AEMaterialMetaData aEMaterialMetaData, String str, com.tencent.aelight.camera.download.a aVar) {
        if (aEMaterialMetaData == null) {
            if (QLog.isColorLevel()) {
                QLog.d(f63571a, 2, "startDownloadMaterial is null");
                return;
            }
            return;
        }
        i(appRuntime, aEMaterialMetaData, str, aVar);
    }

    private static void i(AppRuntime appRuntime, AEMaterialMetaData aEMaterialMetaData, String str, com.tencent.aelight.camera.download.a aVar) {
        if (aEMaterialMetaData == null || appRuntime == null) {
            return;
        }
        aEMaterialMetaData.deleteAllOldFile();
        aEMaterialMetaData.startDownloadTime = System.currentTimeMillis();
        aEMaterialMetaData.downloading = true;
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mCallback = new c(aEMaterialMetaData, str, aVar);
        httpNetReq.mReqUrl = aEMaterialMetaData.resurl;
        httpNetReq.mHttpMethod = 0;
        if (aEMaterialMetaData.name == null) {
            QLog.i(f63571a, 1, "startDownloadMaterial fail, info.name is null, url:" + aEMaterialMetaData.resurl);
            return;
        }
        if (TextUtils.isEmpty(aEMaterialMetaData.md5)) {
            aEMaterialMetaData.md5 = aEMaterialMetaData.name;
        }
        httpNetReq.mOutPath = new File(str, aEMaterialMetaData.md5).getPath();
        httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
        httpNetReq.mExcuteTimeLimit = 60000L;
        try {
            ((IHttpEngineService) appRuntime.getRuntimeService(IHttpEngineService.class, "all")).sendReq(httpNetReq);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                e16.printStackTrace();
            }
        }
        httpNetReq.mCallback.onUpdateProgeress(httpNetReq, 1L, 100L);
        if (QLog.isColorLevel()) {
            QLog.i(f63571a, 2, "startDownloadMaterial url: " + aEMaterialMetaData.resurl);
        }
    }

    private static void j(AppRuntime appRuntime, AEMaterialMetaData aEMaterialMetaData, String str, com.tencent.aelight.camera.download.a aVar) {
        if (aEMaterialMetaData == null || appRuntime == null) {
            return;
        }
        aEMaterialMetaData.deleteAllOldFile();
        aEMaterialMetaData.startDownloadTime = System.currentTimeMillis();
        aEMaterialMetaData.downloading = true;
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mCallback = new c(aEMaterialMetaData, str, aVar);
        httpNetReq.mReqUrl = aEMaterialMetaData.resurl;
        httpNetReq.mHttpMethod = 0;
        httpNetReq.mOutPath = new File(str).getPath();
        httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
        httpNetReq.mExcuteTimeLimit = 60000L;
        try {
            ((IHttpEngineService) appRuntime.getRuntimeService(IHttpEngineService.class, "all")).sendReq(httpNetReq);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                e16.printStackTrace();
            }
        }
        httpNetReq.mCallback.onUpdateProgeress(httpNetReq, 1L, 100L);
        if (QLog.isColorLevel()) {
            QLog.i(f63571a, 2, "startDownloadMaterialByUrl url: " + aEMaterialMetaData.resurl);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements com.tencent.aelight.camera.download.a {
        a() {
        }

        @Override // com.tencent.aelight.camera.download.a
        public void onDownloadFinish(AEMaterialMetaData aEMaterialMetaData, boolean z16, int i3) {
            Intent intent = new Intent();
            intent.setAction(AECameraConstants.AE_CAMERA_QZONE_RES_DOWNLOAD_FINISH_BROADCAST_ACTION);
            com.tencent.aelight.camera.aebase.a.a().getApplicationContext().sendBroadcast(intent);
        }

        @Override // com.tencent.aelight.camera.download.a
        public void onProgressUpdate(AEMaterialMetaData aEMaterialMetaData, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements com.tencent.aelight.camera.download.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AEMaterialMetaData f63574d;

        b(AEMaterialMetaData aEMaterialMetaData) {
            this.f63574d = aEMaterialMetaData;
        }

        @Override // com.tencent.aelight.camera.download.a
        public void onDownloadFinish(AEMaterialMetaData aEMaterialMetaData, boolean z16, int i3) {
            QLog.d(AEMaterialDownloader.f63571a, 2, "pre: onDownloadFinish " + this.f63574d + ((IQIMShortVideoUtil) QRoute.api(IQIMShortVideoUtil.class)).isPeakAlive(com.tencent.aelight.camera.aebase.a.a().getApplicationContext()));
            if (aEMaterialMetaData == null) {
                return;
            }
            AEMaterialDownloader.e(this.f63574d.getLocalPath());
        }

        @Override // com.tencent.aelight.camera.download.a
        public void onProgressUpdate(AEMaterialMetaData aEMaterialMetaData, int i3) {
        }
    }
}
