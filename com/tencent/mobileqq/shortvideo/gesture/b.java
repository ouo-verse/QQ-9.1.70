package com.tencent.mobileqq.shortvideo.gesture;

import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
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
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    a f287872b;

    /* renamed from: a, reason: collision with root package name */
    DownloadInfo f287871a = null;

    /* renamed from: c, reason: collision with root package name */
    boolean f287873c = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        boolean f287874a = false;

        /* renamed from: b, reason: collision with root package name */
        DownloadInfo f287875b = null;

        /* renamed from: c, reason: collision with root package name */
        int f287876c = 0;

        /* renamed from: d, reason: collision with root package name */
        int f287877d = 0;

        /* renamed from: e, reason: collision with root package name */
        int f287878e = 0;

        /* renamed from: f, reason: collision with root package name */
        HttpNetReq f287879f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.shortvideo.gesture.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes18.dex */
        public class C8593a implements INetEngineListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f287880d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ DownloadInfo f287881e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f287882f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f287883h;

            C8593a(String str, DownloadInfo downloadInfo, int i3, int i16) {
                this.f287880d = str;
                this.f287881e = downloadInfo;
                this.f287882f = i3;
                this.f287883h = i16;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x006e  */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0096  */
            @Override // com.tencent.mobileqq.transfile.INetEngineListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onResp(NetResp netResp) {
                boolean z16;
                HttpNetReq httpNetReq = (HttpNetReq) netResp.mReq;
                a aVar = a.this;
                if (aVar.f287879f == httpNetReq) {
                    aVar.f287879f = null;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("QavGesture", 2, String.format("onResp, Url[%s], mResult[%s], mHttpCode[%s], md5[%s]", httpNetReq.mReqUrl, Integer.valueOf(netResp.mResult), Integer.valueOf(netResp.mHttpCode), this.f287880d));
                }
                if (netResp.mResult == 0) {
                    File file = new File(httpNetReq.mOutPath);
                    if (file.exists()) {
                        try {
                            FileUtils.uncompressZip(httpNetReq.mOutPath, file.getParent(), false);
                            b.e(this.f287881e, this.f287882f);
                            z16 = true;
                        } catch (Exception e16) {
                            e16.printStackTrace();
                            z16 = false;
                        }
                        file.delete();
                        if (!z16) {
                            a aVar2 = a.this;
                            b.g((100 / aVar2.f287876c) + aVar2.f287877d);
                            a aVar3 = a.this;
                            aVar3.f287877d += 100 / aVar3.f287876c;
                            if (!aVar3.a(this.f287881e, this.f287883h - 1)) {
                                a.this.f287874a = false;
                                return;
                            }
                            return;
                        }
                        b.g(-1);
                        a.this.f287874a = false;
                        return;
                    }
                }
                z16 = false;
                if (!z16) {
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
                a aVar = a.this;
                b.g((i3 / aVar.f287876c) + aVar.f287877d);
            }
        }

        a() {
        }

        boolean a(DownloadInfo downloadInfo, int i3) {
            String str;
            String str2;
            int i16;
            boolean z16;
            IHttpEngineService iHttpEngineService;
            if (!d.h(downloadInfo)) {
                str = downloadInfo.url_zip_so;
                str2 = downloadInfo.MD5_zip_so;
                i16 = 1;
            } else if (downloadInfo.enable && !d.g(downloadInfo)) {
                str = downloadInfo.url_zip_model;
                str2 = downloadInfo.MD5_zip_model;
                i16 = 2;
            } else if (d.a(downloadInfo) && !d.f(downloadInfo)) {
                str = downloadInfo.url_zip_gamemodel;
                str2 = downloadInfo.MD5_zip_gamemodel;
                i16 = 3;
            } else {
                b.g(100);
                return false;
            }
            String str3 = d.e() + str2;
            if (i3 < 0) {
                QLog.d("QavGesture", 1, String.format("downloadRes, \u4e0b\u8f7d\u6b7b\u5faa\u73af\u4e86. res_flag[%s], info[%s]", Integer.valueOf(i16), downloadInfo));
                b.g(-3);
                return false;
            }
            HttpNetReq httpNetReq = new HttpNetReq();
            httpNetReq.mCallback = new C8593a(str2, downloadInfo, i16, i3);
            httpNetReq.setUserData(i16 + "_" + str2);
            httpNetReq.mReqUrl = str;
            httpNetReq.mHttpMethod = 0;
            httpNetReq.mOutPath = new File(str3).getPath();
            httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if ((runtime instanceof QQAppInterface) && (iHttpEngineService = (IHttpEngineService) ((QQAppInterface) runtime).getRuntimeService(IHttpEngineService.class, "all")) != null && !TextUtils.isEmpty(httpNetReq.mReqUrl)) {
                this.f287879f = httpNetReq;
                iHttpEngineService.sendReq(httpNetReq);
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                b.g(-2);
            }
            if (QLog.isColorLevel()) {
                QLog.i("QavGesture", 2, String.format("downloadRes, res_flag[%s], md5[%s], etr[%s]", Integer.valueOf(i16), str2, Boolean.valueOf(z16)));
            }
            return z16;
        }

        boolean b(DownloadInfo downloadInfo) {
            boolean z16;
            IHttpEngineService iHttpEngineService;
            if (this.f287874a && (this.f287875b == downloadInfo || ((TextUtils.isEmpty(downloadInfo.MD5_zip_model) || downloadInfo.MD5_zip_model.equals(this.f287875b.MD5_zip_model)) && (TextUtils.isEmpty(downloadInfo.MD5_zip_so) || downloadInfo.MD5_zip_so.equals(this.f287875b.MD5_zip_so))))) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QavGesture", 2, String.format("DownloadContrl, mDownloading[%s], reDownload[%s]", Boolean.valueOf(this.f287874a), Boolean.valueOf(z16)));
            }
            if (!z16) {
                return this.f287874a;
            }
            if (this.f287879f != null) {
                AppRuntime runtime = BaseApplicationImpl.sApplication.getRuntime();
                if ((runtime instanceof AppInterface) && (iHttpEngineService = (IHttpEngineService) ((AppInterface) runtime).getRuntimeService(IHttpEngineService.class, "all")) != null) {
                    QLog.d("QavGesture", 2, String.format("DownloadContrl, cancelReq[%s]", (String) this.f287879f.getUserData()));
                    iHttpEngineService.cancelReq(this.f287879f);
                }
            }
            this.f287875b = downloadInfo;
            this.f287878e = 0;
            this.f287879f = null;
            this.f287876c = 0;
            this.f287877d = 0;
            if (!d.h(downloadInfo)) {
                this.f287878e |= 1;
                this.f287876c++;
            }
            if (!d.g(this.f287875b)) {
                this.f287878e |= 2;
                this.f287876c++;
            }
            if (d.a(this.f287875b) && !d.f(this.f287875b)) {
                this.f287878e |= 3;
                this.f287876c++;
            }
            QLog.d("QavGesture", 1, String.format("DownloadContrl, mResFlag[%s], mInfo[%s]", Integer.valueOf(this.f287878e), this.f287875b));
            if (this.f287876c == 0) {
                return this.f287874a;
            }
            boolean a16 = a(this.f287875b, 3);
            this.f287874a = a16;
            return a16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        this.f287872b = null;
        if (QLog.isDevelopLevel()) {
            QLog.d("QavGesture", 4, "GestureMgrAppDownload in QQAppInterface");
        }
        this.f287872b = new a();
    }

    public static boolean a() {
        return com.tencent.mobileqq.shortvideo.gesture.a.c().f287870b.d();
    }

    public static void b(QQAppInterface qQAppInterface, String str, ConfigInfo configInfo) {
        com.tencent.mobileqq.shortvideo.gesture.a.c().f287870b.c(qQAppInterface, str, configInfo);
    }

    public static void e(DownloadInfo downloadInfo, int i3) {
        SharedPreferences sp5 = DownloadInfo.getSP();
        if ((i3 & 1) == 1) {
            sp5.edit().putString("so_zip_md5", downloadInfo.MD5_zip_so).commit();
            f(downloadInfo.so_name);
        }
        if ((i3 & 2) == 2) {
            sp5.edit().putString("model_zip_md5", downloadInfo.MD5_zip_model).commit();
        }
        if ((i3 & 3) == 3) {
            sp5.edit().putString("gamemodel_zip_md5", downloadInfo.MD5_zip_gamemodel).commit();
        }
    }

    public static void f(String str) {
        BaseApplicationImpl.sApplication.getSharedPreferences("so_sp", 4).edit().putString("key_so_version_" + str, AppSetting.l()).commit();
    }

    static void g(int i3) {
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        Intent intent = new Intent("tencent.video.gesturemgr.notify");
        intent.setPackage(application.getPackageName());
        intent.putExtra("Event_Progress", i3);
        application.sendBroadcast(intent);
    }

    void c(QQAppInterface qQAppInterface, String str, ConfigInfo configInfo) {
        DownloadInfo downloadInfo = (DownloadInfo) configInfo;
        this.f287871a = downloadInfo;
        if (downloadInfo == null) {
            this.f287871a = DownloadInfo.get();
        }
        QLog.w("QavGesture", 1, "handle_QAG_Gesture_Config, configInfo[" + configInfo + "], mDownloadInfo[" + this.f287871a + "]");
        if (this.f287873c) {
            this.f287873c = false;
            if (this.f287871a != null) {
                a();
            }
        }
    }

    boolean d() {
        boolean z16 = true;
        if (BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface) {
            if (this.f287871a == null) {
                this.f287871a = DownloadInfo.get();
            }
            DownloadInfo downloadInfo = this.f287871a;
            if (downloadInfo == null) {
                this.f287873c = true;
                return false;
            }
            if (11 != d.b(downloadInfo)) {
                z16 = false;
            }
            if (z16) {
                return this.f287872b.b(downloadInfo);
            }
            return z16;
        }
        QLog.d("QavGesture", 1, "appRuntime \u4e0d\u662f QQAppInterface");
        return false;
    }
}
