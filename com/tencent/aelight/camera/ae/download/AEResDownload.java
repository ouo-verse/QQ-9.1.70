package com.tencent.aelight.camera.ae.download;

import com.tencent.aelight.camera.ae.g;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.ams.fusion.widget.cny2025.twist.CNYTwistArrowLayer;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IOldHttpEngineProcessor;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.LzmaUtils;
import common.config.service.QzoneConfig;
import java.io.File;
import java.io.IOException;
import org.light.CheckResult;
import org.light.LightResourceChecker;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEResDownload {

    /* renamed from: a, reason: collision with root package name */
    private static long f63579a;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface b {
        void a(String str, long j3, long j16, String str2);

        void b(String str, int i3, String str2, String str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean g(String str, AEResBeanWrapper aEResBeanWrapper) {
        if (AEResInfo.PAG_BASIC64.equals(aEResBeanWrapper.agentType) || AEResInfo.PAG_BASIC32.equals(aEResBeanWrapper.agentType) || AEResInfo.AGENT_TYPE_AE_BASE_RES.equals(aEResBeanWrapper.agentType) || !QzoneConfig.enableCheckAEResMd5(((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount())) {
            return true;
        }
        CheckResult checkResult = null;
        try {
            if (!AEResInfo.LIGHT_SDK_BASIC64.equals(aEResBeanWrapper.agentType) && !AEResInfo.FILAMENT_BASIC32.equals(aEResBeanWrapper.agentType) && !AEResInfo.LIGHT_SDK_BASIC32.equals(aEResBeanWrapper.agentType) && !AEResInfo.FILAMENT_BASIC64.equals(aEResBeanWrapper.agentType)) {
                str = str + aEResBeanWrapper.bundleName + AECameraConstants.BUNDLE;
            } else {
                if (str != null && str.length() > 1) {
                    str = str.substring(0, str.length() - 1);
                }
                if (!new File(str + AECameraConstants.META).exists()) {
                    ms.a.c("AEResDownload", "LightResourceChecker meta.txt not exit " + aEResBeanWrapper.agentType);
                    k.c(aEResBeanWrapper, str, null, true);
                    return false;
                }
            }
            ms.a.a("AEResDownload", "LightResourceChecker dir " + str);
            checkResult = LightResourceChecker.checkLightResourcesError(str);
            if (!checkResult.checkPass) {
                k.c(aEResBeanWrapper, str, checkResult, true);
            }
        } catch (Exception e16) {
            ms.a.c("AEResDownload", "checkMd5Result " + e16.getMessage());
        }
        return checkResult == null || checkResult.checkPass;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(String str, String str2, String str3) {
        ms.a.c("AEResDownload", "[onResp] storeUnzipFinalPath.error");
        FileUtils.deleteFile(str);
        FileUtils.deleteFile(str2);
        FileUtils.deleteDirectory(str3);
    }

    public static void k(final AEResBeanWrapper aEResBeanWrapper, final b bVar) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.download.AEResDownload.1
            @Override // java.lang.Runnable
            public void run() {
                AEResDownload.l(AEResBeanWrapper.this, bVar);
            }
        }, 128, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l(AEResBeanWrapper aEResBeanWrapper, b bVar) {
        i(aEResBeanWrapper);
        AEResUtil.g0(aEResBeanWrapper);
        if (aEResBeanWrapper.md5.equals(AEResUtil.p(aEResBeanWrapper.agentType))) {
            if (!AEResUtil.S(aEResBeanWrapper)) {
                ms.a.c("AEResDownload", "[realDownloadResourceInternal] remember downloaded, but check local not exist");
            } else {
                ms.a.c("AEResDownload", "[realDownloadResourceInternal] local already exist");
                bVar.b(aEResBeanWrapper.agentType, 1, AEResUtil.P(aEResBeanWrapper), aEResBeanWrapper.md5);
                return;
            }
        }
        ms.a.a("AEResDownload", "download : [startDownLoad], ~~~~" + aEResBeanWrapper.agentType + ", url:" + aEResBeanWrapper.url);
        f63579a = System.currentTimeMillis();
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mCallback = new a(aEResBeanWrapper, bVar);
        httpNetReq.mReqUrl = aEResBeanWrapper.url;
        httpNetReq.mHttpMethod = 0;
        httpNetReq.mOutPath = AEResUtil.q() + aEResBeanWrapper.agentType + "_" + aEResBeanWrapper.md5;
        httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
        httpNetReq.bAcceptNegativeContentLength = true;
        httpNetReq.setUserData(aEResBeanWrapper.agentType);
        ((IOldHttpEngineProcessor) QRoute.api(IOldHttpEngineProcessor.class)).sendReq(httpNetReq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int m(String str, String str2, AEResBeanWrapper aEResBeanWrapper, String str3) throws IOException {
        ms.a.f("AEResDownload", "[onResp] zipFilePath \uff1a " + str + " tmpUnzipPath \uff1a " + str2 + " finalUnzipPath \uff1a" + str3);
        if (j(aEResBeanWrapper)) {
            ms.a.f("AEResDownload", "[onResp] lzmaDecode");
            long currentTimeMillis = System.currentTimeMillis();
            int lzmaDecode = LzmaUtils.lzmaDecode(BaseApplicationImpl.getApplication(), str, str2);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            k.e(aEResBeanWrapper, lzmaDecode);
            ms.a.f("AEResDownload", "lzmaDecode cost " + currentTimeMillis2);
            return lzmaDecode;
        }
        long currentTimeMillis3 = System.currentTimeMillis();
        FileUtils.uncompressZip(str, str2, false);
        ms.a.f("AEResDownload", "uncompressZip cost " + (System.currentTimeMillis() - currentTimeMillis3));
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean j(AEResBeanWrapper aEResBeanWrapper) {
        if (aEResBeanWrapper == null) {
            ms.a.c("AEResDownload", "aeResInfo == null ");
            return false;
        }
        if (!AENewResUtilKt.c(aEResBeanWrapper.agentType)) {
            return false;
        }
        if (aEResBeanWrapper.url.endsWith(".zip")) {
            ms.a.f("AEResDownload", "sdk zip way");
            return false;
        }
        ms.a.f("AEResDownload", "sdk gzip way ");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements INetEngineListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AEResBeanWrapper f63583d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f63584e;

        a(AEResBeanWrapper aEResBeanWrapper, b bVar) {
            this.f63583d = aEResBeanWrapper;
            this.f63584e = bVar;
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
            AEResBeanWrapper aEResBeanWrapper = this.f63583d;
            String str = aEResBeanWrapper.agentType;
            if (str == null) {
                ms.a.c("AEResDownload", "[onUpdateProgeress] key = null");
            } else {
                this.f63584e.a(str, j3, j16, aEResBeanWrapper.md5);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0143 A[Catch: SecurityException -> 0x0322, TryCatch #0 {SecurityException -> 0x0322, blocks: (B:8:0x004a, B:10:0x0050, B:12:0x00b6, B:14:0x00d7, B:20:0x0143, B:22:0x0154, B:23:0x0157, B:25:0x0168, B:26:0x016b, B:28:0x018c, B:60:0x02c3, B:61:0x02d5, B:64:0x012c, B:68:0x00f3, B:69:0x02e6, B:70:0x0302, B:31:0x019c, B:34:0x01de, B:35:0x024d, B:37:0x0252, B:39:0x025a, B:41:0x0263, B:43:0x0271, B:51:0x0292, B:52:0x02bc, B:54:0x0216, B:57:0x021f), top: B:7:0x004a, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:48:0x032c  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x02d5 A[Catch: SecurityException -> 0x0322, TryCatch #0 {SecurityException -> 0x0322, blocks: (B:8:0x004a, B:10:0x0050, B:12:0x00b6, B:14:0x00d7, B:20:0x0143, B:22:0x0154, B:23:0x0157, B:25:0x0168, B:26:0x016b, B:28:0x018c, B:60:0x02c3, B:61:0x02d5, B:64:0x012c, B:68:0x00f3, B:69:0x02e6, B:70:0x0302, B:31:0x019c, B:34:0x01de, B:35:0x024d, B:37:0x0252, B:39:0x025a, B:41:0x0263, B:43:0x0271, B:51:0x0292, B:52:0x02bc, B:54:0x0216, B:57:0x021f), top: B:7:0x004a, inners: #1 }] */
        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onResp(NetResp netResp) {
            int i3;
            boolean z16;
            int i16;
            boolean z17;
            int i17;
            NetReq netReq = netResp.mReq;
            String str = this.f63583d.agentType;
            ms.a.f("AEResDownload", "[onResp] key:" + str);
            String str2 = "";
            if (str == null) {
                ms.a.c("AEResDownload", "[onResp] key=null ");
                this.f63584e.b("", -1, "", this.f63583d.md5);
                return;
            }
            boolean config = QzoneConfig.getInstance().getConfig("qqcircle", QzoneConfig.SECONDARY_KEY_WINK_ENABLE_UNZIP_RENAME, true);
            try {
                String str3 = netReq.mOutPath;
                if (netResp.mResult == 0) {
                    ms.a.f("AEResDownload", "[onResp] NetResp.ResultOk");
                    ms.a.f("AEResDownload", "[onResp]downloadFilePath=" + str3 + ",resp.mResult=" + netResp.mResult + ",mHttpCode=" + netResp.mHttpCode + ",mErrCode=" + netResp.mErrCode + ",mErrDesc=" + netResp.mErrDesc);
                    int w06 = AEResUtil.w0(this.f63583d.md5, str3);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("[onResp] verifyResource:success=");
                    sb5.append(w06);
                    ms.a.f("AEResDownload", sb5.toString());
                    if (w06 == 0) {
                        ms.a.a("AEResDownload", "download :[RES_SUCCESS], ~~~~" + this.f63583d.agentType);
                        if (!AEResDownload.j(this.f63583d)) {
                            str2 = AEResUtil.P(this.f63583d);
                            ms.a.f("AEResDownload", "[onResp] getZipFilePath :" + str2);
                        } else {
                            str2 = AEResUtil.r(this.f63583d);
                            ms.a.f("AEResDownload", "[onResp] getGZipFilePath :" + str2);
                        }
                        try {
                            z16 = FileUtils.moveFile(str3, str2);
                        } catch (Throwable th5) {
                            th = th5;
                            z16 = false;
                        }
                        try {
                            ms.a.f("AEResDownload", "[onResp] renameStatus :" + z16);
                        } catch (Throwable th6) {
                            th = th6;
                            ms.a.c("AEResDownload", "[onResp]" + th);
                            if (!z16) {
                            }
                            i3 = w06;
                            if (i3 == 0) {
                            }
                            this.f63584e.b(str, i3, str2, this.f63583d.md5);
                        }
                        if (!z16) {
                            String H = AEResUtil.H(this.f63583d);
                            File file = new File(H);
                            if (file.exists()) {
                                file.delete();
                            }
                            String M = AEResUtil.M(this.f63583d);
                            File file2 = new File(M);
                            if (file2.exists()) {
                                file2.delete();
                            }
                            ms.a.f("AEResDownload", "[onResp] unzipFile:[exists]mkOK=" + file2.mkdirs());
                            if (!file2.exists()) {
                                ms.a.c("AEResDownload", "[onResp] unzipFile.exists=false[error]");
                                this.f63584e.b(str, CNYTwistArrowLayer.LEFT_ARROW_CLIP_START_ANGLE, str2, this.f63583d.md5);
                                return;
                            }
                            try {
                                long currentTimeMillis = System.currentTimeMillis();
                                int m3 = AEResDownload.m(str2, M, this.f63583d, H);
                                ms.a.a("AEResDownload", "[onResp] " + this.f63583d.bundleName + " unzipFile cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                                long currentTimeMillis2 = System.currentTimeMillis();
                                if (config) {
                                    z17 = FileUtils.renameFile(file2, new File(H));
                                    ms.a.f("AEResDownload", "[onResp] " + this.f63583d.bundleName + " copyResFileToFinalDir copyOK=" + z17 + ", rename cost " + (System.currentTimeMillis() - currentTimeMillis2) + "ms");
                                } else {
                                    z17 = true;
                                    if (FileUtils.copyDirectory(M, H, true, true, true) != 0) {
                                        z17 = false;
                                    }
                                    ms.a.f("AEResDownload", "[onResp] " + this.f63583d.bundleName + " copyResFileToFinalDir copyOK=" + z17 + ", copyDirectory cost " + (System.currentTimeMillis() - currentTimeMillis2) + "ms");
                                }
                                FileUtils.deleteDirectory(M);
                                if (m3 != 0 && AEResDownload.j(this.f63583d)) {
                                    ms.a.c("AEResDownload", "[onResp] gzip  false");
                                    z17 = false;
                                }
                            } catch (Throwable th7) {
                                ms.a.d("AEResDownload", "[onResp] unzip.error:", th7);
                                FileUtils.deleteFile(netReq.mOutPath);
                                FileUtils.deleteFile(str2);
                            }
                            if (!z17) {
                                AEResDownload.h(netReq.mOutPath, str2, H);
                                i16 = CNYTwistArrowLayer.LEFT_ARROW_CLIP_START_ANGLE;
                                w06 = i16;
                            } else {
                                ms.a.c("AEResDownload", "[onResp] copyResFileToFinalDir.SUCCESS");
                                if (!AEResDownload.g(H, this.f63583d)) {
                                    ms.a.c("AEResDownload", "[onResp] checkMd5Result error" + this.f63583d.agentType);
                                    AEResDownload.h(netReq.mOutPath, str2, H);
                                    i17 = CNYTwistArrowLayer.LEFT_ARROW_CLIP_START_ANGLE;
                                } else {
                                    ms.a.c("AEResDownload", "[onResp] checkMd5ResFileToFinalDir.SUCCESS");
                                    FileUtils.deleteFile(str2);
                                    String L = AEResUtil.L(this.f63583d);
                                    FileUtils.createFile(L);
                                    ms.a.c("AEResDownload", "[onResp] checkMd5ResFileToFinalDir.SUCCESS, tagPath = " + L);
                                    i17 = 0;
                                }
                                i16 = i17;
                                w06 = i16;
                            }
                        } else {
                            ms.a.c("AEResDownload", "[onResp] ShortVideoResourceStatus.RES_RENAME_VERIFY_ERROR");
                            FileUtils.deleteFile(netReq.mOutPath);
                            FileUtils.deleteFile(str2);
                            w06 = -3;
                        }
                    } else {
                        ms.a.c("AEResDownload", "[onResp] verifyResource.error:" + w06);
                        FileUtils.deleteFile(netReq.mOutPath);
                    }
                    i3 = w06;
                } else {
                    ms.a.c("AEResDownload", "[onResp] download.error:" + netResp.mResult);
                    FileUtils.deleteFile(netReq.mOutPath);
                    i3 = -117;
                }
            } catch (SecurityException e16) {
                ms.a.d("AEResDownload", "[SecurityException]", e16);
                i3 = -1;
            }
            if (i3 == 0) {
                AEResManager.J().q0(netResp.mTotalFileLen, this.f63583d, System.currentTimeMillis() - AEResDownload.f63579a);
                q.a(this.f63583d);
            }
            this.f63584e.b(str, i3, str2, this.f63583d.md5);
        }
    }

    private static void i(final AEResBeanWrapper aEResBeanWrapper) {
        if (aEResBeanWrapper == null) {
            return;
        }
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.download.AEResDownload.3
            @Override // java.lang.Runnable
            public void run() {
                String K = AEResUtil.K(AEResBeanWrapper.this);
                String str = g.a.c.f65267b + AEResBeanWrapper.this.agentType + File.separator + AEResBeanWrapper.this.md5;
                ms.a.a("AEResDownload", "path : " + K + " doNotDelete : " + str);
                com.tencent.aelight.camera.ae.util.k.a(K, str);
            }
        });
    }
}
