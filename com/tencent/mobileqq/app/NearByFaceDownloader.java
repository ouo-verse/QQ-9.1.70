package com.tencent.mobileqq.app;

import AvatarInfo.QQHeadInfo;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadExcutor;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.app.face.FaceDownloader;
import com.tencent.mobileqq.app.face.FaceHandler;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.app.face.util.AvatarDownloadUtil;
import com.tencent.mobileqq.avatar.api.IQQAvatarManagerService;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
/* loaded from: classes11.dex */
public class NearByFaceDownloader extends FaceDownloader {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    AppInterface f194854a;

    /* renamed from: b, reason: collision with root package name */
    FaceHandler f194855b;

    /* renamed from: c, reason: collision with root package name */
    IQQAvatarManagerService f194856c;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class HeadCostStatRunnable implements Runnable {
        static IPatchRedirector $redirector_;
        FaceInfo C;

        /* renamed from: d, reason: collision with root package name */
        int f194857d;

        /* renamed from: e, reason: collision with root package name */
        int f194858e;

        /* renamed from: f, reason: collision with root package name */
        int f194859f;

        /* renamed from: h, reason: collision with root package name */
        String f194860h;

        /* renamed from: i, reason: collision with root package name */
        int f194861i;

        /* renamed from: m, reason: collision with root package name */
        long f194862m;

        public HeadCostStatRunnable(int i3, FaceInfo faceInfo, int i16, int i17, String str, int i18, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, NearByFaceDownloader.this, Integer.valueOf(i3), faceInfo, Integer.valueOf(i16), Integer.valueOf(i17), str, Integer.valueOf(i18), Long.valueOf(j3));
                return;
            }
            this.f194857d = i3;
            this.f194858e = i16;
            this.f194859f = i17;
            this.f194860h = str;
            this.f194861i = i18;
            this.f194862m = j3;
            this.C = faceInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            long j3;
            long j16;
            boolean z16;
            long j17;
            boolean z17;
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 2;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            String str = ((int) this.C.mHeadInfo.dstUsrType) + "_" + this.C.idType + "_" + this.C.uin;
            NearByFaceDownloader.this.f194855b.L2(str, false);
            if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                long[] jArr = this.C.mTimes;
                long j18 = 0;
                if (jArr[FaceInfo.TIME_END_DOWNLOADINFO] > 0 && jArr[FaceInfo.TIME_BEGIN_DOWNLOADINFO] > 0) {
                    j3 = jArr[FaceInfo.TIME_END_DOWNLOADINFO] - jArr[FaceInfo.TIME_BEGIN_DOWNLOADINFO];
                } else {
                    j3 = 0;
                }
                long j19 = jArr[FaceInfo.TIME_BEGIN_DOWNLOAD];
                long j26 = jArr[FaceInfo.TIME_END_DOWNLOADINFO];
                if (j19 > j26 && j26 > 0) {
                    j16 = jArr[FaceInfo.TIME_BEGIN_DOWNLOAD] - jArr[FaceInfo.TIME_END_DOWNLOADINFO];
                } else {
                    j16 = 0;
                }
                if (jArr[FaceInfo.TIME_END_DOWNLOAD] > 0 && jArr[FaceInfo.TIME_BEGIN_DOWNLOAD] > 0) {
                    j18 = jArr[FaceInfo.TIME_END_DOWNLOAD] - jArr[FaceInfo.TIME_BEGIN_DOWNLOAD];
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("key", str);
                hashMap.put("totalTime", String.valueOf(((float) this.f194862m) / 1000.0f));
                hashMap.put("downInfo_time", String.valueOf(j3));
                hashMap.put("downInfo_stime", String.valueOf(((float) j3) / 1000.0f));
                hashMap.put("interval_time", String.valueOf(j16));
                hashMap.put("downPic_time", String.valueOf(j18));
                hashMap.put("downPic_stime", String.valueOf(((float) j18) / 1000.0f));
                hashMap.put("downPic_size", String.valueOf(this.f194859f));
                hashMap.put("download_url", this.f194860h);
                hashMap.put("param_FailCode", Integer.toString(this.f194857d));
                hashMap.put(VRReportDefine$ReportParam.FAIL_REASON, Integer.toString(this.f194861i));
                hashMap.put("ssoAndHttp", String.valueOf(this.C.mHasFaceInfo));
                String c16 = com.tencent.mobileqq.avatar.utils.b.c(32);
                StatisticCollector statisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
                String currentAccountUin = NearByFaceDownloader.this.f194854a.getCurrentAccountUin();
                if (this.f194857d == 0) {
                    j17 = j3;
                    z16 = true;
                } else {
                    z16 = false;
                    j17 = j3;
                }
                statisticCollector.collectPerformance(currentAccountUin, c16, z16, this.f194862m, 0L, hashMap, "");
                StatisticCollector statisticCollector2 = StatisticCollector.getInstance(BaseApplication.getContext());
                String currentAccountUin2 = NearByFaceDownloader.this.f194854a.getCurrentAccountUin();
                if (this.f194857d == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                statisticCollector2.collectPerformance(currentAccountUin2, "actGetNearbyHead", z17, this.f194862m, 0L, hashMap, "");
                if (QLog.isColorLevel() || this.f194862m > 3000) {
                    StringBuffer stringBuffer = new StringBuffer(200);
                    stringBuffer.append("NearByFaceDownloader resultCode=");
                    stringBuffer.append(this.f194857d);
                    stringBuffer.append(", key=");
                    stringBuffer.append(str);
                    stringBuffer.append(", totalTime=");
                    stringBuffer.append(String.format("%-5s", Long.valueOf(this.f194862m)));
                    stringBuffer.append(", downInfoTime=");
                    stringBuffer.append(j17);
                    stringBuffer.append(", intervalTime=");
                    stringBuffer.append(j16);
                    stringBuffer.append(", picSize=");
                    stringBuffer.append(String.valueOf(this.f194859f));
                    stringBuffer.append(", downPicTime=");
                    stringBuffer.append(j18);
                    stringBuffer.append(", reasonCode=");
                    stringBuffer.append(this.f194861i);
                    stringBuffer.append(", downUrl=");
                    stringBuffer.append(this.f194860h);
                    if (!QLog.isColorLevel()) {
                        i3 = 1;
                    }
                    QLog.i("Q.qqhead.NearByFaceDownloader", i3, stringBuffer.toString());
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class UpdateSettingRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        Setting f194863d;

        /* renamed from: e, reason: collision with root package name */
        FaceInfo f194864e;

        public UpdateSettingRunnable(Setting setting, FaceInfo faceInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, NearByFaceDownloader.this, setting, faceInfo);
            } else {
                this.f194863d = setting;
                this.f194864e = faceInfo;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            IQQAvatarManagerService iQQAvatarManagerService = (IQQAvatarManagerService) NearByFaceDownloader.this.f194854a.getRuntimeService(IQQAvatarManagerService.class, ProcessConstant.NEARBY);
            iQQAvatarManagerService.updateFaceSetting(this.f194863d);
            FaceInfo faceInfo = this.f194864e;
            QQHeadInfo qQHeadInfo = faceInfo.mHeadInfo;
            String facePath = iQQAvatarManagerService.getFacePath(faceInfo);
            String substring = facePath.substring(0, facePath.lastIndexOf("/"));
            String substring2 = facePath.substring(facePath.lastIndexOf("/") + 1);
            if (!TextUtils.isEmpty(substring2) && substring2.endsWith("jpg_")) {
                String str = substring + File.separator + substring2.substring(0, substring2.lastIndexOf("jpg_")) + "png";
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                    if (QLog.isColorLevel()) {
                        QLog.i("qqhead", 2, "delete old file,oldpath=" + str);
                    }
                }
            }
        }
    }

    public NearByFaceDownloader(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
            return;
        }
        this.f194854a = null;
        this.f194855b = null;
        this.f194856c = null;
        AppInterface appInterface = (AppInterface) appRuntime;
        this.f194854a = appInterface;
        this.f194855b = (FaceHandler) appInterface.getBusinessHandler(FaceConstant.Nearby.NEAR_BY_FACE_HANDLER);
        this.f194856c = (IQQAvatarManagerService) this.f194854a.getRuntimeService(IQQAvatarManagerService.class, ProcessConstant.NEARBY);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01e8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0383 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0191 A[Catch: all -> 0x01b6, TRY_LEAVE, TryCatch #10 {all -> 0x01b6, blocks: (B:146:0x0144, B:54:0x0191), top: B:145:0x0144 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0336  */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r8v15 */
    @Override // com.tencent.mobileqq.app.face.FaceDownloader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void doDownloadFace(FaceInfo faceInfo) {
        boolean z16;
        int i3;
        ThreadExcutor.IThreadListener iThreadListener;
        int i16;
        Throwable th5;
        String str;
        int i17;
        int i18;
        int i19;
        String str2;
        long j3;
        long j16;
        long j17;
        long j18;
        long j19;
        long j26;
        long j27;
        boolean z17;
        int i26;
        int i27;
        String str3;
        String str4;
        long j28;
        long j29;
        long j36;
        String facePath;
        File file;
        String qQAvatarDownLoadUrl;
        String insertMtype;
        int i28;
        int i29;
        int i36;
        ?? r85;
        int i37;
        String str5;
        int i38;
        int i39;
        int i46;
        long j37;
        long j38;
        long j39;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) faceInfo);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.qqhead.NearByFaceDownloader", 2, "doDownloadFace.begin request=" + faceInfo);
        }
        faceInfo.markTime(FaceInfo.TIME_BEGIN_DOWNLOAD);
        QQHeadInfo qQHeadInfo = faceInfo.mHeadInfo;
        String str6 = qQHeadInfo.downLoadUrl;
        try {
            if (!TextUtils.isEmpty(str6)) {
                try {
                    String str7 = "stranger_" + Integer.toString(faceInfo.idType) + "_" + faceInfo.uin;
                    IQQAvatarManagerService iQQAvatarManagerService = (IQQAvatarManagerService) this.f194854a.getRuntimeService(IQQAvatarManagerService.class, ProcessConstant.NEARBY);
                    Setting faceSetting = iQQAvatarManagerService.getFaceSetting(str7);
                    if (faceSetting == null) {
                        try {
                            faceSetting = new Setting();
                            faceSetting.uin = str7;
                        } catch (Throwable th6) {
                            th5 = th6;
                            str2 = str6;
                            z16 = false;
                            i17 = 0;
                            i18 = 0;
                            str = null;
                            i3 = 0;
                            iThreadListener = null;
                            i19 = 0;
                            try {
                                th5.printStackTrace();
                                if (faceInfo.mHasFaceInfo == 1) {
                                }
                                ThreadManagerV2.postImmediately(new HeadCostStatRunnable(FaceConstant.HeadDownload.RESULT_CODE_QQHEAD_DOWNLOAD_PIC_EXCEPTION, faceInfo, 4, i3, str2, i19, j27), iThreadListener, z16);
                                z17 = i17;
                                i26 = i18;
                                i27 = 9204;
                                str3 = str;
                                str4 = str2;
                                if (!QLog.isColorLevel()) {
                                }
                                QLog.i("Q.qqhead.NearByFaceDownloader", 2, "doDownloadFace.info=" + faceInfo + ",isDownSuccess=" + z17 + ", resultCode=" + i27 + ", uin=" + qQHeadInfo.uin + ", phoneNum=" + qQHeadInfo.phoneNum + ",cHeadType=" + qQHeadInfo.cHeadType + ",dstUsrType=" + qQHeadInfo.dstUsrType + ", faceId=" + qQHeadInfo.systemHeadID + ", reasonCode=" + i26 + ",dwTimestamp=" + qQHeadInfo.dwTimestamp + ", facePath=" + str3 + ", downUrl=" + str4 + ",originUrl=" + qQHeadInfo.downLoadUrl + ",info=" + qQHeadInfo);
                            } catch (Throwable th7) {
                                String str8 = str2;
                                ThreadExcutor.IThreadListener iThreadListener2 = iThreadListener;
                                if (faceInfo.mHasFaceInfo == 1) {
                                    long[] jArr = faceInfo.mTimes;
                                    j3 = 0;
                                    if (jArr[FaceInfo.TIME_END_DOWNLOAD] > 0) {
                                        if (jArr[FaceInfo.TIME_BEGIN_DOWNLOAD] > 0) {
                                            j16 = jArr[FaceInfo.TIME_END_DOWNLOAD];
                                            j17 = jArr[FaceInfo.TIME_BEGIN_DOWNLOAD];
                                            j18 = j16 - j17;
                                        } else {
                                            j3 = 0;
                                        }
                                    }
                                    j18 = j3;
                                } else {
                                    long[] jArr2 = faceInfo.mTimes;
                                    j3 = 0;
                                    if (jArr2[FaceInfo.TIME_END_DOWNLOAD] > 0 && jArr2[FaceInfo.TIME_BEGIN_DOWNLOADINFO] > 0) {
                                        j16 = jArr2[FaceInfo.TIME_END_DOWNLOAD];
                                        j17 = jArr2[FaceInfo.TIME_BEGIN_DOWNLOADINFO];
                                        j18 = j16 - j17;
                                    }
                                    j18 = j3;
                                }
                                ThreadManagerV2.postImmediately(new HeadCostStatRunnable(FaceConstant.HeadDownload.RESULT_CODE_QQHEAD_DOWNLOAD_PIC_EXCEPTION, faceInfo, 4, i3, str8, i19, j18), iThreadListener2, z16);
                                throw th7;
                            }
                        }
                    }
                    faceSetting.bFaceFlags = qQHeadInfo.dwFaceFlgas;
                    faceSetting.bUsrType = qQHeadInfo.dstUsrType;
                    faceSetting.url = qQHeadInfo.downLoadUrl;
                    faceSetting.updateTimestamp = System.currentTimeMillis();
                    faceSetting.bSourceType = qQHeadInfo.headLevel;
                    faceSetting.bHeadType = qQHeadInfo.cHeadType;
                    faceSetting.systemHeadID = qQHeadInfo.systemHeadID;
                    faceSetting.headImgTimestamp = qQHeadInfo.dwTimestamp;
                    faceSetting.staticZplanFaceFlag = qQHeadInfo.staticZplanFaceFlag;
                    faceSetting.dynamicZplanFaceFlag = qQHeadInfo.dynamicZplanFaceFlag;
                    faceSetting.zplanFaceBgUrl = qQHeadInfo.zplanFaceBgUrl;
                    faceSetting.apngFaceFlag = qQHeadInfo.apngFaceFlag;
                    try {
                        try {
                            facePath = iQQAvatarManagerService.getFacePath(faceInfo);
                            try {
                                File file2 = new File(facePath.substring(0, facePath.lastIndexOf("/")));
                                if (!file2.exists()) {
                                    try {
                                        file2.mkdirs();
                                    } catch (Throwable th8) {
                                        th5 = th8;
                                        str = facePath;
                                        str2 = str6;
                                        z16 = false;
                                        i17 = 0;
                                        i18 = 0;
                                        i3 = 0;
                                        iThreadListener = null;
                                        i19 = 0;
                                        th5.printStackTrace();
                                        if (faceInfo.mHasFaceInfo == 1) {
                                        }
                                        ThreadManagerV2.postImmediately(new HeadCostStatRunnable(FaceConstant.HeadDownload.RESULT_CODE_QQHEAD_DOWNLOAD_PIC_EXCEPTION, faceInfo, 4, i3, str2, i19, j27), iThreadListener, z16);
                                        z17 = i17;
                                        i26 = i18;
                                        i27 = 9204;
                                        str3 = str;
                                        str4 = str2;
                                        if (!QLog.isColorLevel()) {
                                        }
                                        QLog.i("Q.qqhead.NearByFaceDownloader", 2, "doDownloadFace.info=" + faceInfo + ",isDownSuccess=" + z17 + ", resultCode=" + i27 + ", uin=" + qQHeadInfo.uin + ", phoneNum=" + qQHeadInfo.phoneNum + ",cHeadType=" + qQHeadInfo.cHeadType + ",dstUsrType=" + qQHeadInfo.dstUsrType + ", faceId=" + qQHeadInfo.systemHeadID + ", reasonCode=" + i26 + ",dwTimestamp=" + qQHeadInfo.dwTimestamp + ", facePath=" + str3 + ", downUrl=" + str4 + ",originUrl=" + qQHeadInfo.downLoadUrl + ",info=" + qQHeadInfo);
                                    }
                                }
                                file = new File(facePath);
                                qQAvatarDownLoadUrl = AvatarDownloadUtil.getQQAvatarDownLoadUrl(qQHeadInfo.downLoadUrl, qQHeadInfo.dwFaceFlgas, qQHeadInfo.dstUsrType, qQHeadInfo.originUsrType);
                            } catch (Throwable th9) {
                                iThreadListener = null;
                                th5 = th9;
                                str = facePath;
                                str2 = str6;
                            }
                        } catch (Throwable th10) {
                            iThreadListener = null;
                            th5 = th10;
                            str2 = str6;
                            str = null;
                        }
                        try {
                            qQAvatarDownLoadUrl = MsfSdkUtils.insertMtype("QQHeadIcon", qQAvatarDownLoadUrl) + "&t=" + System.currentTimeMillis();
                            int downloadData = downloadData(qQAvatarDownLoadUrl, file, faceInfo, true);
                            if (downloadData != 0) {
                                try {
                                    if (NetConnInfoCenter.getActiveNetIpFamily(true) == 3) {
                                        qQAvatarDownLoadUrl = AvatarDownloadUtil.getQQAvatarDownLoadUrl(qQHeadInfo.downLoadUrl, qQHeadInfo.dwFaceFlgas, qQHeadInfo.dstUsrType, qQHeadInfo.originUsrType, true, (byte) 0);
                                        insertMtype = MsfSdkUtils.insertMtype("QQHeadIcon", qQAvatarDownLoadUrl);
                                        try {
                                            insertMtype = insertMtype + "&t=" + System.currentTimeMillis();
                                            downloadData = downloadData(insertMtype, file, faceInfo, true);
                                            QLog.d("Q.qqhead.NearByFaceDownloader", 1, "doDownloadFace() traAgain downLoadUrl = " + insertMtype + " errCode  =" + downloadData);
                                            if (downloadData != 0) {
                                                i3 = (int) file.length();
                                                try {
                                                    iThreadListener = null;
                                                } catch (Throwable th11) {
                                                    th = th11;
                                                    str2 = insertMtype;
                                                    i19 = downloadData;
                                                    z16 = false;
                                                    i18 = 0;
                                                    iThreadListener = null;
                                                }
                                                try {
                                                    ThreadManagerV2.postImmediately(new UpdateSettingRunnable(faceSetting, faceInfo), null, false);
                                                    i28 = 0;
                                                    i36 = 0;
                                                    i29 = 1;
                                                } catch (Throwable th12) {
                                                    th = th12;
                                                    str2 = insertMtype;
                                                    i19 = downloadData;
                                                    z16 = false;
                                                    i18 = 0;
                                                    i17 = 1;
                                                    th5 = th;
                                                    str = facePath;
                                                    th5.printStackTrace();
                                                    if (faceInfo.mHasFaceInfo == 1) {
                                                        long[] jArr3 = faceInfo.mTimes;
                                                        if (jArr3[FaceInfo.TIME_END_DOWNLOAD] > 0 && jArr3[FaceInfo.TIME_BEGIN_DOWNLOAD] > 0) {
                                                            j19 = jArr3[FaceInfo.TIME_END_DOWNLOAD];
                                                            j26 = jArr3[FaceInfo.TIME_BEGIN_DOWNLOAD];
                                                            j27 = j19 - j26;
                                                        }
                                                        j27 = 0;
                                                    } else {
                                                        long[] jArr4 = faceInfo.mTimes;
                                                        if (jArr4[FaceInfo.TIME_END_DOWNLOAD] > 0 && jArr4[FaceInfo.TIME_BEGIN_DOWNLOADINFO] > 0) {
                                                            j19 = jArr4[FaceInfo.TIME_END_DOWNLOAD];
                                                            j26 = jArr4[FaceInfo.TIME_BEGIN_DOWNLOADINFO];
                                                            j27 = j19 - j26;
                                                        }
                                                        j27 = 0;
                                                    }
                                                    ThreadManagerV2.postImmediately(new HeadCostStatRunnable(FaceConstant.HeadDownload.RESULT_CODE_QQHEAD_DOWNLOAD_PIC_EXCEPTION, faceInfo, 4, i3, str2, i19, j27), iThreadListener, z16);
                                                    z17 = i17;
                                                    i26 = i18;
                                                    i27 = 9204;
                                                    str3 = str;
                                                    str4 = str2;
                                                    if (!QLog.isColorLevel()) {
                                                    }
                                                    QLog.i("Q.qqhead.NearByFaceDownloader", 2, "doDownloadFace.info=" + faceInfo + ",isDownSuccess=" + z17 + ", resultCode=" + i27 + ", uin=" + qQHeadInfo.uin + ", phoneNum=" + qQHeadInfo.phoneNum + ",cHeadType=" + qQHeadInfo.cHeadType + ",dstUsrType=" + qQHeadInfo.dstUsrType + ", faceId=" + qQHeadInfo.systemHeadID + ", reasonCode=" + i26 + ",dwTimestamp=" + qQHeadInfo.dwTimestamp + ", facePath=" + str3 + ", downUrl=" + str4 + ",originUrl=" + qQHeadInfo.downLoadUrl + ",info=" + qQHeadInfo);
                                                }
                                            } else {
                                                iThreadListener = null;
                                                if (downloadData != 1) {
                                                    if (downloadData != 33) {
                                                        if (downloadData != 4) {
                                                            if (downloadData != 5) {
                                                                i28 = FaceConstant.HeadDownload.RESULT_CODE_QQHEAD_DOWNLOAD_PIC_HTTP_RESPONSE_FAIL;
                                                            } else {
                                                                i28 = FaceConstant.HeadDownload.RESULT_CODE_QQHEAD_DOWNLOAD_PIC_EXCEPTION;
                                                            }
                                                        } else {
                                                            i28 = FaceConstant.HeadDownload.RESULT_CODE_QQHEAD_SAVE_FILE_FAIL;
                                                        }
                                                    } else {
                                                        i28 = FaceConstant.HeadDownload.RESULT_CODE_QQHEAD_STORGE_EXCEPTION;
                                                    }
                                                    i36 = downloadData;
                                                    i29 = 0;
                                                    i3 = 0;
                                                } else {
                                                    i28 = FaceConstant.HeadDownload.RESULT_CODE_QQHEAD_DOWNLOAD_PIC_NETWORK_FAIL;
                                                }
                                                i29 = 0;
                                                i36 = 0;
                                                i3 = 0;
                                            }
                                            if (i29 == 0) {
                                                try {
                                                    r85 = 1;
                                                } catch (Throwable th13) {
                                                    th = th13;
                                                    str2 = insertMtype;
                                                    i17 = i29;
                                                    i18 = i36;
                                                    i19 = downloadData;
                                                    z16 = false;
                                                    th5 = th;
                                                    str = facePath;
                                                    th5.printStackTrace();
                                                    if (faceInfo.mHasFaceInfo == 1) {
                                                    }
                                                    ThreadManagerV2.postImmediately(new HeadCostStatRunnable(FaceConstant.HeadDownload.RESULT_CODE_QQHEAD_DOWNLOAD_PIC_EXCEPTION, faceInfo, 4, i3, str2, i19, j27), iThreadListener, z16);
                                                    z17 = i17;
                                                    i26 = i18;
                                                    i27 = 9204;
                                                    str3 = str;
                                                    str4 = str2;
                                                    if (!QLog.isColorLevel()) {
                                                    }
                                                    QLog.i("Q.qqhead.NearByFaceDownloader", 2, "doDownloadFace.info=" + faceInfo + ",isDownSuccess=" + z17 + ", resultCode=" + i27 + ", uin=" + qQHeadInfo.uin + ", phoneNum=" + qQHeadInfo.phoneNum + ",cHeadType=" + qQHeadInfo.cHeadType + ",dstUsrType=" + qQHeadInfo.dstUsrType + ", faceId=" + qQHeadInfo.systemHeadID + ", reasonCode=" + i26 + ",dwTimestamp=" + qQHeadInfo.dwTimestamp + ", facePath=" + str3 + ", downUrl=" + str4 + ",originUrl=" + qQHeadInfo.downLoadUrl + ",info=" + qQHeadInfo);
                                                }
                                                try {
                                                    this.f194855b.notifyUI(0, true, faceInfo);
                                                } catch (Throwable th14) {
                                                    th = th14;
                                                    str2 = insertMtype;
                                                    i17 = i29;
                                                    i18 = i36;
                                                    i19 = downloadData;
                                                    z16 = false;
                                                    th5 = th;
                                                    str = facePath;
                                                    th5.printStackTrace();
                                                    if (faceInfo.mHasFaceInfo == 1) {
                                                    }
                                                    ThreadManagerV2.postImmediately(new HeadCostStatRunnable(FaceConstant.HeadDownload.RESULT_CODE_QQHEAD_DOWNLOAD_PIC_EXCEPTION, faceInfo, 4, i3, str2, i19, j27), iThreadListener, z16);
                                                    z17 = i17;
                                                    i26 = i18;
                                                    i27 = 9204;
                                                    str3 = str;
                                                    str4 = str2;
                                                    if (!QLog.isColorLevel()) {
                                                    }
                                                    QLog.i("Q.qqhead.NearByFaceDownloader", 2, "doDownloadFace.info=" + faceInfo + ",isDownSuccess=" + z17 + ", resultCode=" + i27 + ", uin=" + qQHeadInfo.uin + ", phoneNum=" + qQHeadInfo.phoneNum + ",cHeadType=" + qQHeadInfo.cHeadType + ",dstUsrType=" + qQHeadInfo.dstUsrType + ", faceId=" + qQHeadInfo.systemHeadID + ", reasonCode=" + i26 + ",dwTimestamp=" + qQHeadInfo.dwTimestamp + ", facePath=" + str3 + ", downUrl=" + str4 + ",originUrl=" + qQHeadInfo.downLoadUrl + ",info=" + qQHeadInfo);
                                                }
                                            } else {
                                                r85 = 1;
                                            }
                                            this.f194855b.notifyUI(r85, r85, faceInfo);
                                            i37 = i28;
                                            str4 = insertMtype;
                                            str5 = facePath;
                                            i38 = i29;
                                            i39 = i36;
                                            i46 = downloadData;
                                        } catch (Throwable th15) {
                                            th = th15;
                                            str2 = insertMtype;
                                            i19 = downloadData;
                                            z16 = false;
                                            i17 = 0;
                                            i18 = 0;
                                            i3 = 0;
                                            iThreadListener = null;
                                            th5 = th;
                                            str = facePath;
                                            th5.printStackTrace();
                                            if (faceInfo.mHasFaceInfo == 1) {
                                            }
                                            ThreadManagerV2.postImmediately(new HeadCostStatRunnable(FaceConstant.HeadDownload.RESULT_CODE_QQHEAD_DOWNLOAD_PIC_EXCEPTION, faceInfo, 4, i3, str2, i19, j27), iThreadListener, z16);
                                            z17 = i17;
                                            i26 = i18;
                                            i27 = 9204;
                                            str3 = str;
                                            str4 = str2;
                                            if (!QLog.isColorLevel()) {
                                            }
                                            QLog.i("Q.qqhead.NearByFaceDownloader", 2, "doDownloadFace.info=" + faceInfo + ",isDownSuccess=" + z17 + ", resultCode=" + i27 + ", uin=" + qQHeadInfo.uin + ", phoneNum=" + qQHeadInfo.phoneNum + ",cHeadType=" + qQHeadInfo.cHeadType + ",dstUsrType=" + qQHeadInfo.dstUsrType + ", faceId=" + qQHeadInfo.systemHeadID + ", reasonCode=" + i26 + ",dwTimestamp=" + qQHeadInfo.dwTimestamp + ", facePath=" + str3 + ", downUrl=" + str4 + ",originUrl=" + qQHeadInfo.downLoadUrl + ",info=" + qQHeadInfo);
                                        }
                                    }
                                } catch (Throwable th16) {
                                    th5 = th16;
                                    str = facePath;
                                    str2 = qQAvatarDownLoadUrl;
                                    i19 = downloadData;
                                    z16 = false;
                                    i17 = 0;
                                    i18 = 0;
                                    i3 = 0;
                                    iThreadListener = null;
                                    th5.printStackTrace();
                                    if (faceInfo.mHasFaceInfo == 1) {
                                    }
                                    ThreadManagerV2.postImmediately(new HeadCostStatRunnable(FaceConstant.HeadDownload.RESULT_CODE_QQHEAD_DOWNLOAD_PIC_EXCEPTION, faceInfo, 4, i3, str2, i19, j27), iThreadListener, z16);
                                    z17 = i17;
                                    i26 = i18;
                                    i27 = 9204;
                                    str3 = str;
                                    str4 = str2;
                                    if (!QLog.isColorLevel()) {
                                    }
                                    QLog.i("Q.qqhead.NearByFaceDownloader", 2, "doDownloadFace.info=" + faceInfo + ",isDownSuccess=" + z17 + ", resultCode=" + i27 + ", uin=" + qQHeadInfo.uin + ", phoneNum=" + qQHeadInfo.phoneNum + ",cHeadType=" + qQHeadInfo.cHeadType + ",dstUsrType=" + qQHeadInfo.dstUsrType + ", faceId=" + qQHeadInfo.systemHeadID + ", reasonCode=" + i26 + ",dwTimestamp=" + qQHeadInfo.dwTimestamp + ", facePath=" + str3 + ", downUrl=" + str4 + ",originUrl=" + qQHeadInfo.downLoadUrl + ",info=" + qQHeadInfo);
                                }
                            }
                            insertMtype = qQAvatarDownLoadUrl;
                            if (downloadData != 0) {
                            }
                            if (i29 == 0) {
                            }
                            this.f194855b.notifyUI(r85, r85, faceInfo);
                            i37 = i28;
                            str4 = insertMtype;
                            str5 = facePath;
                            i38 = i29;
                            i39 = i36;
                            i46 = downloadData;
                        } catch (Throwable th17) {
                            iThreadListener = null;
                            th5 = th17;
                            str = facePath;
                            str2 = qQAvatarDownLoadUrl;
                            z16 = false;
                            i17 = 0;
                            i18 = 0;
                            i3 = 0;
                            i19 = 0;
                            th5.printStackTrace();
                            if (faceInfo.mHasFaceInfo == 1) {
                            }
                            ThreadManagerV2.postImmediately(new HeadCostStatRunnable(FaceConstant.HeadDownload.RESULT_CODE_QQHEAD_DOWNLOAD_PIC_EXCEPTION, faceInfo, 4, i3, str2, i19, j27), iThreadListener, z16);
                            z17 = i17;
                            i26 = i18;
                            i27 = 9204;
                            str3 = str;
                            str4 = str2;
                            if (!QLog.isColorLevel()) {
                            }
                            QLog.i("Q.qqhead.NearByFaceDownloader", 2, "doDownloadFace.info=" + faceInfo + ",isDownSuccess=" + z17 + ", resultCode=" + i27 + ", uin=" + qQHeadInfo.uin + ", phoneNum=" + qQHeadInfo.phoneNum + ",cHeadType=" + qQHeadInfo.cHeadType + ",dstUsrType=" + qQHeadInfo.dstUsrType + ", faceId=" + qQHeadInfo.systemHeadID + ", reasonCode=" + i26 + ",dwTimestamp=" + qQHeadInfo.dwTimestamp + ", facePath=" + str3 + ", downUrl=" + str4 + ",originUrl=" + qQHeadInfo.downLoadUrl + ",info=" + qQHeadInfo);
                        }
                    } catch (Exception unused) {
                        if (faceInfo.mHasFaceInfo == 1) {
                            long[] jArr5 = faceInfo.mTimes;
                            if (jArr5[FaceInfo.TIME_END_DOWNLOAD] > 0 && jArr5[FaceInfo.TIME_BEGIN_DOWNLOAD] > 0) {
                                j28 = jArr5[FaceInfo.TIME_END_DOWNLOAD];
                                j29 = jArr5[FaceInfo.TIME_BEGIN_DOWNLOAD];
                                j36 = j28 - j29;
                            }
                            j36 = 0;
                        } else {
                            long[] jArr6 = faceInfo.mTimes;
                            if (jArr6[FaceInfo.TIME_END_DOWNLOAD] > 0 && jArr6[FaceInfo.TIME_BEGIN_DOWNLOADINFO] > 0) {
                                j28 = jArr6[FaceInfo.TIME_END_DOWNLOAD];
                                j29 = jArr6[FaceInfo.TIME_BEGIN_DOWNLOADINFO];
                                j36 = j28 - j29;
                            }
                            j36 = 0;
                        }
                        ThreadManagerV2.postImmediately(new HeadCostStatRunnable(FaceConstant.HeadDownload.RESULT_CODE_QQHEAD_SAVE_FILE_FAIL, faceInfo, 4, 0, str6, 0, j36), null, false);
                        return;
                    }
                } catch (Throwable th18) {
                    i3 = 0;
                    iThreadListener = null;
                    i16 = 0;
                    th5 = th18;
                    str = null;
                    z16 = false;
                    i17 = z16 ? 1 : 0;
                    i18 = i17;
                    i19 = i16;
                    str2 = str6;
                    th5.printStackTrace();
                    if (faceInfo.mHasFaceInfo == 1) {
                    }
                    ThreadManagerV2.postImmediately(new HeadCostStatRunnable(FaceConstant.HeadDownload.RESULT_CODE_QQHEAD_DOWNLOAD_PIC_EXCEPTION, faceInfo, 4, i3, str2, i19, j27), iThreadListener, z16);
                    z17 = i17;
                    i26 = i18;
                    i27 = 9204;
                    str3 = str;
                    str4 = str2;
                    if (!QLog.isColorLevel()) {
                    }
                    QLog.i("Q.qqhead.NearByFaceDownloader", 2, "doDownloadFace.info=" + faceInfo + ",isDownSuccess=" + z17 + ", resultCode=" + i27 + ", uin=" + qQHeadInfo.uin + ", phoneNum=" + qQHeadInfo.phoneNum + ",cHeadType=" + qQHeadInfo.cHeadType + ",dstUsrType=" + qQHeadInfo.dstUsrType + ", faceId=" + qQHeadInfo.systemHeadID + ", reasonCode=" + i26 + ",dwTimestamp=" + qQHeadInfo.dwTimestamp + ", facePath=" + str3 + ", downUrl=" + str4 + ",originUrl=" + qQHeadInfo.downLoadUrl + ",info=" + qQHeadInfo);
                }
            } else {
                i3 = 0;
                iThreadListener = null;
                i46 = 0;
                str4 = str6;
                str5 = null;
                i37 = 0;
                i38 = 0;
                i39 = 0;
            }
            if (faceInfo.mHasFaceInfo == 1) {
                long[] jArr7 = faceInfo.mTimes;
                if (jArr7[FaceInfo.TIME_END_DOWNLOAD] > 0 && jArr7[FaceInfo.TIME_BEGIN_DOWNLOAD] > 0) {
                    j37 = jArr7[FaceInfo.TIME_END_DOWNLOAD];
                    j38 = jArr7[FaceInfo.TIME_BEGIN_DOWNLOAD];
                    j39 = j37 - j38;
                }
                j39 = 0;
            } else {
                long[] jArr8 = faceInfo.mTimes;
                if (jArr8[FaceInfo.TIME_END_DOWNLOAD] > 0 && jArr8[FaceInfo.TIME_BEGIN_DOWNLOADINFO] > 0) {
                    j37 = jArr8[FaceInfo.TIME_END_DOWNLOAD];
                    j38 = jArr8[FaceInfo.TIME_BEGIN_DOWNLOADINFO];
                    j39 = j37 - j38;
                }
                j39 = 0;
            }
            ThreadManagerV2.postImmediately(new HeadCostStatRunnable(i37, faceInfo, 4, i3, str4, i46, j39), iThreadListener, false);
            str3 = str5;
            i27 = i37;
            z17 = i38;
            i26 = i39;
        } catch (Throwable th19) {
            z16 = false;
            i3 = 0;
            iThreadListener = null;
            i16 = 0;
            th5 = th19;
            str = null;
        }
        if (!QLog.isColorLevel() || z17 == 0) {
            QLog.i("Q.qqhead.NearByFaceDownloader", 2, "doDownloadFace.info=" + faceInfo + ",isDownSuccess=" + z17 + ", resultCode=" + i27 + ", uin=" + qQHeadInfo.uin + ", phoneNum=" + qQHeadInfo.phoneNum + ",cHeadType=" + qQHeadInfo.cHeadType + ",dstUsrType=" + qQHeadInfo.dstUsrType + ", faceId=" + qQHeadInfo.systemHeadID + ", reasonCode=" + i26 + ",dwTimestamp=" + qQHeadInfo.dwTimestamp + ", facePath=" + str3 + ", downUrl=" + str4 + ",originUrl=" + qQHeadInfo.downLoadUrl + ",info=" + qQHeadInfo);
        }
    }

    @Override // com.tencent.mobileqq.app.face.FaceDownloader
    public String getChoosedIP() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f194856c.getChoosedIP();
    }

    @Override // com.tencent.mobileqq.app.face.FaceDownloader
    public String getChoosedStrangerGroupIp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f194856c.getChooseStrangerGroupIP();
    }
}
