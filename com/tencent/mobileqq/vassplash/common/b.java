package com.tencent.mobileqq.vassplash.common;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.ad.i;
import cooperation.vip.ad.w;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a extends AbsPreDownloadTask {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f312362d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f312363e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f312364f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f312365h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f312366i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(BaseQQAppInterface baseQQAppInterface, String str, String str2, String str3, int i3, String str4, String str5) {
            super(baseQQAppInterface, str);
            this.f312362d = str2;
            this.f312363e = str3;
            this.f312364f = i3;
            this.f312365h = str4;
            this.f312366i = str5;
        }

        @Override // com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask
        protected void realCancel() {
            QLog.i("QSplash@VasSplashUtil", 1, "ctrl realCancel");
        }

        @Override // com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask
        protected void realStart() {
            QLog.i("QSplash@VasSplashUtil", 1, "downloadPicAGifAVideoRes adid" + this.f312362d);
            c.d(this.f312363e + ".splashtemp");
            QLog.i("QSplash@QSplash@VasSplashDownloadManager", 1, "vas_ad_res_png realStart, key  " + this.f312362d + "_" + this.f312363e);
            HttpNetReq httpNetReq = new HttpNetReq();
            httpNetReq.mCallback = new C8946b((QQAppInterface) this.app, this.f312362d, this.f312364f, this.f312363e + ".splashtemp", this.f312365h, this.f312366i);
            httpNetReq.mReqUrl = this.f312366i;
            httpNetReq.mHttpMethod = 0;
            httpNetReq.mOutPath = this.f312363e + ".splashtemp";
            ((IHttpEngineService) this.app.getRuntimeService(IHttpEngineService.class, "all")).sendReq(httpNetReq);
        }
    }

    public static void b(QQAppInterface qQAppInterface, String str, String str2, String str3, int i3, String str4) {
        c(qQAppInterface, str, str2, str3, i3, str4, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0062, code lost:
    
        r7 = 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(QQAppInterface qQAppInterface, String str, String str2, String str3, int i3, String str4, boolean z16) {
        int i16;
        int i17;
        try {
            QLog.d("QSplash@QSplash@VasSplashDownloadManager", 1, "[download]:" + str3 + ",url:" + str2 + ",id:" + str + ",type:" + i3);
            IPreDownloadController iPreDownloadController = (IPreDownloadController) qQAppInterface.getRuntimeService(IPreDownloadController.class);
            if (iPreDownloadController.isEnable()) {
                String str5 = "vas_splash_ad_res_png";
                int i18 = 3;
                if (i3 != 2 && i3 != 3) {
                    i17 = 2;
                    i16 = 10081;
                    String str6 = str5;
                    QLog.i("QSplash@VasSplashUtil", 1, "downloadPicAGifAVideoRes request adid" + str);
                    iPreDownloadController.requestPreDownload(i16, PreDownloadConstants.DEPARTMENT_VAS, str2, 0, str2, str3 + ".splashtemp", i17, 0, true, new a(qQAppInterface, str6, str, str3, i3, str4, str2));
                }
                str5 = "vas_splash_ad_res_video";
                i16 = 10082;
                i17 = i18;
                String str62 = str5;
                QLog.i("QSplash@VasSplashUtil", 1, "downloadPicAGifAVideoRes request adid" + str);
                iPreDownloadController.requestPreDownload(i16, PreDownloadConstants.DEPARTMENT_VAS, str2, 0, str2, str3 + ".splashtemp", i17, 0, true, new a(qQAppInterface, str62, str, str3, i3, str4, str2));
            } else {
                QLog.i("QSplash@VasSplashUtil", 1, "ctrl.isEnable() = false");
            }
        } catch (Exception unused) {
        }
    }

    public static synchronized void d(QQAppInterface qQAppInterface, Collection<o43.a> collection) {
        boolean z16;
        boolean z17;
        synchronized (b.class) {
            for (o43.a aVar : collection) {
                if (!aVar.g()) {
                    QLog.i("QSplash@QSplash@VasSplashDownloadManager", 1, "adEntry should not requestRes");
                } else {
                    int i3 = aVar.f421931e;
                    if (i3 != 0) {
                        if (i3 != 1) {
                            if (i3 != 2) {
                                if (i3 == 3) {
                                    String str = aVar.f421925b;
                                    String str2 = aVar.f421933f;
                                    String str3 = aVar.f421945l;
                                    String str4 = aVar.f421951p;
                                    if (aVar.f421948m0 == 0) {
                                        z17 = true;
                                    } else {
                                        z17 = false;
                                    }
                                    c(qQAppInterface, str, str2, str3, 3, str4, z17);
                                }
                            } else {
                                String str5 = aVar.f421925b;
                                String str6 = aVar.f421933f;
                                String str7 = aVar.f421945l;
                                String str8 = aVar.f421951p;
                                if (aVar.f421948m0 == 0) {
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                                c(qQAppInterface, str5, str6, str7, 2, str8, z16);
                            }
                        } else {
                            b(qQAppInterface, aVar.f421925b, aVar.f421933f, aVar.f421945l, 1, aVar.f421951p);
                        }
                    } else {
                        b(qQAppInterface, aVar.f421925b, aVar.f421933f, aVar.f421945l, 0, aVar.f421951p);
                    }
                    b(qQAppInterface, aVar.f421925b, aVar.f421932e0, aVar.f421934f0, 0, aVar.f421951p);
                    int i16 = aVar.G;
                    if (i16 != 2 && i16 != 1) {
                        if (i16 == 4) {
                            b(qQAppInterface, aVar.f421925b, aVar.f421924a0, aVar.f421926b0, 0, aVar.f421951p);
                            b(qQAppInterface, aVar.f421925b, aVar.f421928c0, aVar.f421930d0, 0, aVar.f421951p);
                        } else if (i16 == 6 || i16 == 9) {
                            b(qQAppInterface, aVar.f421925b, aVar.f421959x, aVar.f421960y, 0, aVar.f421951p);
                        }
                    }
                    b(qQAppInterface, aVar.f421925b, aVar.H, aVar.I, 0, aVar.f421951p);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(String str, AppInterface appInterface, String str2) {
        if (appInterface == null) {
            return;
        }
        try {
            IPreDownloadController iPreDownloadController = (IPreDownloadController) appInterface.getRuntimeService(IPreDownloadController.class, "");
            if (iPreDownloadController.isEnable()) {
                iPreDownloadController.preDownloadSuccess(str, -1L);
            }
        } catch (Exception unused) {
        }
        w.q(str2, 145, str);
    }

    public static void f(String str, String str2) {
        SharedPreferences l3 = c.l(BaseApplication.getContext(), str);
        SharedPreferences.Editor edit = l3.edit();
        QLog.i("QSplash@QSplash@VasSplashDownloadManager", 1, "pic or gif download succ! MD5 checkok");
        boolean z16 = l3.getBoolean("vas_exposure_is_low_device_limit_", false);
        QLog.i("QSplash@QSplash@VasSplashDownloadManager", 1, "isLowerDeviceLimit = " + z16);
        if (!z16) {
            edit.putBoolean("vas_splash_ad_is_limited_" + str2, true);
            HashMap<String, o43.a> hashMap = c.f312379g;
            if (hashMap != null && hashMap.containsKey(str2)) {
                hashMap.get(str2).f421954s = true;
            }
        }
        edit.apply();
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.vassplash.common.b$b, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public static class C8946b implements INetEngineListener {

        /* renamed from: d, reason: collision with root package name */
        int f312367d;

        /* renamed from: e, reason: collision with root package name */
        String f312368e;

        /* renamed from: f, reason: collision with root package name */
        String f312369f;

        /* renamed from: h, reason: collision with root package name */
        String f312370h;

        /* renamed from: i, reason: collision with root package name */
        String f312371i;

        /* renamed from: m, reason: collision with root package name */
        QQAppInterface f312372m;

        public C8946b(QQAppInterface qQAppInterface, String str, int i3, String str2, String str3, String str4) {
            this.f312372m = qQAppInterface;
            this.f312368e = str;
            this.f312367d = i3;
            this.f312369f = str4;
            this.f312371i = str2;
            this.f312370h = str3;
        }

        private void a(String str) {
            o43.a aVar;
            HashMap<String, o43.a> hashMap = c.f312379g;
            if (hashMap != null && hashMap.containsKey(str) && (aVar = hashMap.get(str)) != null && aVar.h()) {
                String str2 = "vas_splash_report_download_suceess_" + RFWApplication.getAccountId() + "_" + str;
                if (!i.g().decodeBool(str2, false)) {
                    i.g().encodeBool(str2, true);
                    w.q(str, 146, aVar.f421950o);
                }
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            try {
                int i3 = netResp.mResult;
                if (i3 == 0) {
                    QLog.i("QSplash@QSplash@VasSplashDownloadManager", 1, "ResFile has download!");
                    if (!TextUtils.isEmpty(this.f312371i)) {
                        if (!o43.a.d(this.f312371i, false)) {
                            b.e(this.f312369f, this.f312372m, this.f312368e);
                            QLog.i("QSplash@VasSplashUtil", 1, "ResFile check not exist");
                            return;
                        }
                        File file = new File(this.f312371i);
                        String str = this.f312371i;
                        file.renameTo(new File(str.substring(0, str.lastIndexOf("."))));
                        long length = file.length();
                        IPreDownloadController iPreDownloadController = (IPreDownloadController) this.f312372m.getRuntimeService(IPreDownloadController.class);
                        if (iPreDownloadController.isEnable()) {
                            QLog.i("QSplash@VasSplashUtil", 1, "preDownloadSuccess");
                            iPreDownloadController.preDownloadSuccess(this.f312369f, length);
                        }
                        b.f(this.f312372m.getAccount(), this.f312368e);
                        a(this.f312368e);
                        return;
                    }
                    return;
                }
                if (i3 == 1) {
                    b.e(this.f312369f, this.f312372m, this.f312368e);
                    QLog.i("QSplash@VasSplashUtil", 1, "ResFile dowload faield");
                }
            } catch (Exception unused) {
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
        }
    }
}
