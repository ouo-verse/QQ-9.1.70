package com.tencent.mobileqq.qzonevip.gift;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.utils.IQzoneZipCacheHelper;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;
import java.io.File;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QzoneGiftUtil {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements Downloader.DownloadListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QzoneZipCacheHelperCallBack f280149a;

        a(QzoneZipCacheHelperCallBack qzoneZipCacheHelperCallBack) {
            this.f280149a = qzoneZipCacheHelperCallBack;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) qzoneZipCacheHelperCallBack);
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadCanceled(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            QzoneZipCacheHelperCallBack qzoneZipCacheHelperCallBack = this.f280149a;
            if (qzoneZipCacheHelperCallBack != null) {
                qzoneZipCacheHelperCallBack.onResult(false);
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadFailed(String str, DownloadResult downloadResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) downloadResult);
                return;
            }
            QzoneZipCacheHelperCallBack qzoneZipCacheHelperCallBack = this.f280149a;
            if (qzoneZipCacheHelperCallBack != null) {
                qzoneZipCacheHelperCallBack.onResult(false);
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadProgress(String str, long j3, float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, str, Long.valueOf(j3), Float.valueOf(f16));
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadSucceed(String str, DownloadResult downloadResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) downloadResult);
                return;
            }
            QzoneZipCacheHelperCallBack qzoneZipCacheHelperCallBack = this.f280149a;
            if (qzoneZipCacheHelperCallBack != null) {
                qzoneZipCacheHelperCallBack.onResult(true);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface b {
        void onFail();

        void onLoading();

        void onSuccess();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(String str, String str2) {
        return q.p(e(str, str2));
    }

    public static void c(String str, String str2, QzoneZipCacheHelperCallBack qzoneZipCacheHelperCallBack) {
        QLog.i("QzoneGiftUtil", 1, "downloadGiftPhoto");
        Downloader commonDownloader = DownloaderFactory.getInstance(BaseApplication.getContext()).getCommonDownloader();
        if (commonDownloader != null) {
            commonDownloader.download(str, e(str, str2), false, (Downloader.DownloadListener) new a(qzoneZipCacheHelperCallBack));
        }
    }

    public static void d(b bVar, String str, String str2, String str3) {
        int i3;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            if (TextUtils.isEmpty(str)) {
                i3 = 2;
            } else {
                i3 = 3;
            }
            ThreadManagerV2.executeOnFileThread(new Runnable(i3, str, str2, str3) { // from class: com.tencent.mobileqq.qzonevip.gift.QzoneGiftUtil.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String C;

                /* renamed from: d, reason: collision with root package name */
                private volatile int f280142d;

                /* renamed from: e, reason: collision with root package name */
                private volatile int f280143e;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ int f280145h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ String f280146i;

                /* renamed from: m, reason: collision with root package name */
                final /* synthetic */ String f280147m;

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.qzonevip.gift.QzoneGiftUtil$1$a */
                /* loaded from: classes16.dex */
                class a implements QzoneZipCacheHelperCallBack {
                    static IPatchRedirector $redirector_;

                    a() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                        }
                    }

                    @Override // cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack
                    public void onResult(boolean z16) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, z16);
                            return;
                        }
                        if (z16) {
                            AnonymousClass1.this.f280142d++;
                        } else {
                            AnonymousClass1.this.f280143e++;
                        }
                        QLog.i("QzoneGiftUtil", 1, "downloadGiftZip onResult mLoadSuccessTimes = " + AnonymousClass1.this.f280142d + " mLoadFailTimes = " + AnonymousClass1.this.f280143e);
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        if (b.this != null) {
                            int i3 = anonymousClass1.f280142d;
                            AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                            if (i3 == anonymousClass12.f280145h) {
                                b.this.onSuccess();
                                return;
                            }
                            int i16 = anonymousClass12.f280142d + AnonymousClass1.this.f280143e;
                            AnonymousClass1 anonymousClass13 = AnonymousClass1.this;
                            if (i16 == anonymousClass13.f280145h) {
                                b.this.onFail();
                            }
                        }
                    }

                    @Override // cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack
                    public void onResultOfNativeRequest(boolean z16, String str, String str2) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, str2);
                        }
                    }
                }

                {
                    this.f280145h = i3;
                    this.f280146i = str;
                    this.f280147m = str2;
                    this.C = str3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, b.this, Integer.valueOf(i3), str, str2, str3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    this.f280142d = 0;
                    this.f280143e = 0;
                    a aVar = new a();
                    if (!TextUtils.isEmpty(this.f280146i)) {
                        IQzoneZipCacheHelper iQzoneZipCacheHelper = (IQzoneZipCacheHelper) QRoute.api(IQzoneZipCacheHelper.class);
                        String str4 = this.f280146i;
                        if (iQzoneZipCacheHelper.checkAndDownLoadFileIfNeeded(null, str4, "qzone_aio_gift", String.valueOf(str4.hashCode()), -1, aVar)) {
                            this.f280142d++;
                        }
                    }
                    IQzoneZipCacheHelper iQzoneZipCacheHelper2 = (IQzoneZipCacheHelper) QRoute.api(IQzoneZipCacheHelper.class);
                    String str5 = this.f280147m;
                    boolean checkAndDownLoadFileIfNeeded = iQzoneZipCacheHelper2.checkAndDownLoadFileIfNeeded(null, str5, "qzone_aio_gift", String.valueOf(str5.hashCode()), -1, aVar);
                    if (checkAndDownLoadFileIfNeeded) {
                        this.f280142d++;
                    }
                    boolean b16 = QzoneGiftUtil.b(this.C, "qzone_aio_gift");
                    if (b16) {
                        this.f280142d++;
                    } else {
                        QzoneGiftUtil.c(this.C, "qzone_aio_gift", aVar);
                    }
                    if (b.this != null) {
                        if (this.f280142d == this.f280145h) {
                            b.this.onSuccess();
                        } else {
                            b.this.onLoading();
                        }
                    }
                    QLog.i("QzoneGiftUtil", 1, " isGiftZipFileExist = " + checkAndDownLoadFileIfNeeded + " isGiftExist = " + b16 + " mLoadSuccessTimes = " + this.f280142d + " mLoadFailTimes = " + this.f280143e);
                }
            });
            return;
        }
        QLog.e("QzoneGiftUtil", 1, "downloadGiftZip fail with url = null  boxZipUrl = " + str + " giftZipUrl = " + str2 + " giftUrl = " + str3);
    }

    public static String e(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(BaseApplicationImpl.getApplication().getCacheDir());
        String str3 = File.separator;
        sb5.append(str3);
        sb5.append(str2);
        sb5.append(str3);
        sb5.append(Utils.Crc64String(str));
        sb5.append(str.substring(str.lastIndexOf(".")));
        return sb5.toString();
    }

    public static String f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return ((IQzoneZipCacheHelper) QRoute.api(IQzoneZipCacheHelper.class)).getBasePath("qzone_aio_gift", String.valueOf(str.hashCode()));
    }
}
