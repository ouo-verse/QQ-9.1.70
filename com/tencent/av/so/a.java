package com.tencent.av.so;

import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.confighandler.ConfigInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static volatile a f74630b;

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<b> f74631a = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.av.so.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0750a implements INetEngineListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f74632d;

        C0750a(b bVar) {
            this.f74632d = bVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0135  */
        /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:42:0x010c  */
        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onResp(NetResp netResp) {
            boolean z16;
            b bVar;
            HttpNetReq httpNetReq = (HttpNetReq) netResp.mReq;
            if (netResp.mResult == 0) {
                File file = new File(httpNetReq.mOutPath);
                if (file.exists()) {
                    try {
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                    if (ResMgr.d(httpNetReq.mOutPath, this.f74632d.f74634a.resZipMd5)) {
                        String parent = file.getParent();
                        FileUtils.uncompressZip(httpNetReq.mOutPath, parent, false);
                        if (ResMgr.d(parent + File.separator + this.f74632d.f74634a.resFileName, this.f74632d.f74634a.resMd5)) {
                            z16 = true;
                            file.delete();
                            if (z16) {
                                QLog.i("AVResMgr", 1, "download successfully. " + this.f74632d.f74634a);
                                if (this.f74632d.f74634a.resId.equalsIgnoreCase(ResInfo.RES_ID_AV_TRAE_SO)) {
                                    ResMgr.H();
                                } else if (this.f74632d.f74634a.resId.equalsIgnoreCase(ResInfo.RES_ID_AV_AI_NS_MEDIALAB_GRU_MODEL)) {
                                    ResMgr.C();
                                } else if (this.f74632d.f74634a.resId.equalsIgnoreCase(ResInfo.RES_ID_QAV_RTC_SDK_SO)) {
                                    ResMgr.I();
                                } else if (this.f74632d.f74634a.resId.equalsIgnoreCase(ResInfo.RES_ID_AV_QQ_AUDIO_AI_NS_MODEL)) {
                                    ResMgr.F();
                                } else if (this.f74632d.f74634a.resId.equalsIgnoreCase(ResInfo.RES_ID_AV_QQ_AUDIO_AI_SO)) {
                                    ResMgr.G();
                                } else if (this.f74632d.f74634a.resId.equalsIgnoreCase(ResInfo.RES_ID_AV_AUDIO_PENGUINS_CODEC_SO)) {
                                    ResMgr.E();
                                } else if (this.f74632d.f74634a.resId.equalsIgnoreCase(ResInfo.RES_ID_AV_AUDIO_PENGUINS_CODEC_MODEL)) {
                                    ResMgr.D();
                                }
                                a.g(1, 100, this.f74632d.f74634a);
                            } else {
                                QLog.e("AVResMgr", 1, "download end but failed. uncompressZip failed or md5 not match. " + this.f74632d.f74634a);
                                b bVar2 = this.f74632d;
                                a.g(-1, bVar2.f74636c, bVar2.f74634a);
                            }
                            bVar = this.f74632d;
                            if (bVar.f74637d == httpNetReq) {
                                bVar.f74637d = null;
                                bVar.f74635b = 0;
                                a.this.f74631a.remove(this.f74632d);
                                return;
                            }
                            return;
                        }
                    }
                    z16 = false;
                    file.delete();
                    if (z16) {
                    }
                    bVar = this.f74632d;
                    if (bVar.f74637d == httpNetReq) {
                    }
                }
            }
            z16 = false;
            if (z16) {
            }
            bVar = this.f74632d;
            if (bVar.f74637d == httpNetReq) {
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
            int i3;
            if (j16 == 0) {
                i3 = 0;
            } else if (j3 >= j16) {
                i3 = 99;
            } else {
                i3 = (int) ((((float) j3) * 100.0f) / ((float) j16));
            }
            this.f74632d.f74636c = i3;
            if (i3 % 10 == 0 || i3 == 1 || i3 == 99) {
                QLog.i("AVResMgr", 1, "download... progress: " + i3 + ". " + this.f74632d.f74634a);
            }
            a.g(2, i3, this.f74632d.f74634a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public ResInfo f74634a;

        /* renamed from: b, reason: collision with root package name */
        public int f74635b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f74636c = 0;

        /* renamed from: d, reason: collision with root package name */
        public HttpNetReq f74637d;
    }

    a() {
        QLog.i("AVResMgr", 1, "ResDownloadControl for " + BaseApplicationImpl.getApplication().getQQProcessName());
    }

    public static a e() {
        if (f74630b == null) {
            synchronized (a.class) {
                if (f74630b == null) {
                    f74630b = new a();
                }
            }
        }
        return f74630b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(int i3, int i16, ResInfo resInfo) {
        i(i3, resInfo);
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        Intent intent = new Intent("ACTION_QAV_RES_DOWNLOAD_STATE_NOTIFY");
        intent.setPackage(application.getPackageName());
        intent.putExtra("ACTION_FIELD_DOWNLOAD_STATE", i3);
        intent.putExtra("ACTION_FIELD_DOWNLOAD_PROGRESS", i16);
        intent.putExtra("ACTION_FIELD_RES_MD5", resInfo.resMd5);
        application.sendBroadcast(intent);
    }

    private static void h() {
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        Intent intent = new Intent("ACTION_QAV_RES_NEW_CONFIG_NOTIFY");
        intent.setPackage(application.getPackageName());
        application.sendBroadcast(intent);
    }

    public static boolean i(int i3, ResInfo resInfo) {
        if (!resInfo.resId.equalsIgnoreCase(ResInfo.RES_ID_QAV_RTC_SDK_SO)) {
            return false;
        }
        if (i3 == 1) {
            return com.tencent.av.so.b.d("Qav_Rtc_SDK_Download", com.tencent.av.so.b.a(resInfo.resVersion, resInfo.resMd5, "success"));
        }
        if (i3 != -1 && i3 != -2) {
            return false;
        }
        return com.tencent.av.so.b.d("Qav_Rtc_SDK_Download", com.tencent.av.so.b.a(resInfo.resVersion, resInfo.resMd5, "failed"));
    }

    public boolean c(ResInfo resInfo) {
        if (BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface) {
            boolean z16 = false;
            for (int i3 = 0; i3 < this.f74631a.size(); i3++) {
                if (this.f74631a.get(i3).f74634a.resId.equalsIgnoreCase(resInfo.resId)) {
                    if (this.f74631a.get(i3).f74635b == 2) {
                        QLog.i("AVResMgr", 1, "download repeatedly. ResId = " + this.f74631a.get(i3).f74634a.resId);
                        return true;
                    }
                    z16 = true;
                }
            }
            if (z16) {
                return true;
            }
            b bVar = new b();
            bVar.f74634a = resInfo;
            this.f74631a.add(bVar);
            return j(bVar);
        }
        QLog.e("AVResMgr", 1, "download failed. appRuntime is not QQAppInterface.");
        return false;
    }

    public boolean d(String str) {
        ArrayList<ResInfo> y16 = ResMgr.y(false);
        if (y16 == null) {
            return false;
        }
        for (int i3 = 0; i3 < y16.size(); i3++) {
            if (y16.get(i3).resId.equalsIgnoreCase(str)) {
                QLog.i("AVResMgr", 1, "downloadByResId. " + y16.get(i3));
                return c(y16.get(i3));
            }
        }
        return false;
    }

    public void f(QQAppInterface qQAppInterface, String str, ConfigInfo configInfo) {
        if (str == null) {
            return;
        }
        QLog.i("AVResMgr", 1, "handleNewConfig. newConfig = " + str);
        ResMgr.K(str);
        ArrayList<ResInfo> y16 = ResMgr.y(true);
        if (y16 == null) {
            return;
        }
        h();
        ResInfo w3 = ResMgr.q().w(ResInfo.RES_ID_AV_VOICE_RECOG_SO);
        ResInfo w16 = ResMgr.q().w(ResInfo.RES_ID_AV_VOICE_RECOG_MODEL);
        ResInfo w17 = ResMgr.q().w(ResInfo.RES_ID_AV_TRAE_SO);
        ResInfo w18 = ResMgr.q().w(ResInfo.RES_ID_AV_AI_NS_MEDIALAB_GRU_MODEL);
        ResInfo w19 = ResMgr.q().w(ResInfo.RES_ID_QAV_RTC_SDK_SO);
        ResInfo w26 = ResMgr.q().w(ResInfo.RES_ID_AV_QQ_AUDIO_AI_NS_MODEL);
        ResInfo w27 = ResMgr.q().w(ResInfo.RES_ID_AV_QQ_AUDIO_AI_SO);
        ResInfo w28 = ResMgr.q().w(ResInfo.RES_ID_AV_AUDIO_PENGUINS_CODEC_SO);
        ResInfo w29 = ResMgr.q().w(ResInfo.RES_ID_AV_AUDIO_PENGUINS_CODEC_MODEL);
        for (int i3 = 0; i3 < y16.size(); i3++) {
            ResInfo resInfo = y16.get(i3);
            QLog.i("AVResMgr", 1, "handleNewConfig. " + resInfo);
            if (w3 != null && w3.resId.equalsIgnoreCase(resInfo.resId)) {
                ResMgr.f(ResMgr.u(resInfo), ResMgr.s(w3));
            } else if (w16 != null && w16.resId.equalsIgnoreCase(resInfo.resId)) {
                ResMgr.f(ResMgr.u(resInfo), ResMgr.s(w16));
            } else if (w17 != null && w17.resId.equalsIgnoreCase(resInfo.resId)) {
                ResMgr.f(ResMgr.u(resInfo), ResMgr.s(w17));
            } else if (w18 != null && w18.resId.equalsIgnoreCase(resInfo.resId)) {
                ResMgr.f(ResMgr.u(resInfo), ResMgr.s(w18));
            } else if (w19 != null && w19.resId.equalsIgnoreCase(resInfo.resId)) {
                ResMgr.f(ResMgr.u(resInfo), ResMgr.s(w19));
            } else if (w26 != null && w26.resId.equalsIgnoreCase(resInfo.resId)) {
                ResMgr.f(ResMgr.u(resInfo), ResMgr.s(w26));
            } else if (w27 != null && w27.resId.equalsIgnoreCase(resInfo.resId)) {
                ResMgr.f(ResMgr.u(resInfo), ResMgr.s(w27));
            } else if (w28 != null && w28.resId.equalsIgnoreCase(resInfo.resId)) {
                ResMgr.f(ResMgr.u(resInfo), ResMgr.s(w28));
            } else if (w29 != null && w29.resId.equalsIgnoreCase(resInfo.resId)) {
                ResMgr.f(ResMgr.u(resInfo), ResMgr.s(w29));
            }
            if (resInfo.isAutoDownload) {
                if (!ResMgr.d(ResMgr.s(resInfo) + resInfo.resFileName, resInfo.resMd5)) {
                    c(resInfo);
                }
            }
        }
    }

    boolean j(b bVar) {
        boolean z16;
        IHttpEngineService iHttpEngineService;
        IHttpEngineService iHttpEngineService2;
        if (bVar.f74637d != null) {
            AppRuntime runtime = BaseApplicationImpl.sApplication.getRuntime();
            if ((runtime instanceof AppInterface) && (iHttpEngineService2 = (IHttpEngineService) ((AppInterface) runtime).getRuntimeService(IHttpEngineService.class, "all")) != null) {
                QLog.i("AVResMgr", 1, "startDownload. cancel old download req. old res = " + ((String) bVar.f74637d.getUserData()));
                iHttpEngineService2.cancelReq(bVar.f74637d);
            }
        }
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.setUserData(bVar.f74634a.resType + "_" + bVar.f74634a.resId + "_" + bVar.f74634a.resVersion + "_" + bVar.f74634a.resZipMd5);
        httpNetReq.mReqUrl = bVar.f74634a.resZipUrl;
        httpNetReq.mHttpMethod = 0;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(ResMgr.s(bVar.f74634a));
        sb5.append(bVar.f74634a.resZipMd5);
        sb5.append(".zip");
        httpNetReq.mOutPath = new File(sb5.toString()).getPath();
        httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
        httpNetReq.mCallback = new C0750a(bVar);
        AppRuntime runtime2 = BaseApplicationImpl.getApplication().getRuntime();
        if ((runtime2 instanceof QQAppInterface) && (iHttpEngineService = (IHttpEngineService) ((QQAppInterface) runtime2).getRuntimeService(IHttpEngineService.class, "all")) != null) {
            bVar.f74637d = httpNetReq;
            iHttpEngineService.sendReq(httpNetReq);
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            QLog.e("AVResMgr", 1, "startDownload. failed. NETWORK_ERROR. " + bVar.f74634a);
            this.f74631a.remove(bVar);
            g(-2, 0, bVar.f74634a);
        } else {
            bVar.f74635b = 2;
            QLog.i("AVResMgr", 1, "startDownload. " + bVar.f74634a);
        }
        return z16;
    }
}
