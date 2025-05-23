package com.tencent.gdtad.api.interstitial;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;

/* compiled from: P */
@Deprecated
/* loaded from: classes6.dex */
final class f {

    /* renamed from: e, reason: collision with root package name */
    private static volatile f f108643e;

    /* renamed from: a, reason: collision with root package name */
    private volatile GdtArkPreDownloadTask f108644a;

    /* renamed from: b, reason: collision with root package name */
    private volatile long f108645b = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private AdIPCManager.Callback f108646c = new a();

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private GdtArkPreDownloadTask.a f108647d = new b();

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements AdIPCManager.Callback {
        a() {
        }

        @Override // com.tencent.ad.tangram.ipc.AdIPCManager.Callback
        public void onCallback(AdIPCManager.Params params, @Nullable AdIPCManager.Result result) {
            boolean z16 = true;
            Object[] objArr = new Object[1];
            if (result == null || !result.success) {
                z16 = false;
            }
            objArr[0] = Boolean.valueOf(z16);
            GdtLog.i("GdtInterstitialPreDownloader", String.format("predownload.onCallback %b", objArr));
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class b implements GdtArkPreDownloadTask.a {
        b() {
        }

        @Override // com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.a
        public void a(com.tencent.gdtad.api.interstitial.a aVar) {
            String str;
            String str2;
            Object[] objArr = new Object[3];
            String str3 = null;
            if (aVar != null) {
                str = aVar.f108629a;
            } else {
                str = null;
            }
            objArr[0] = str;
            if (aVar != null) {
                str2 = aVar.f108630b;
            } else {
                str2 = null;
            }
            objArr[1] = str2;
            if (aVar != null) {
                str3 = aVar.f108632d;
            }
            objArr[2] = str3;
            GdtLog.i("GdtInterstitialPreDownloader", String.format("onPreDownloaded appName:%s view:%s minVersion:%s", objArr));
            GdtAnalysisHelperForInterstitial.reportForPreDownloadInterstitialEnd(BaseApplication.getContext(), f.c().f108645b, 0, Integer.MIN_VALUE);
        }

        @Override // com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.a
        public void b(com.tencent.gdtad.api.interstitial.a aVar, int i3, int i16) {
            String str;
            String str2;
            Object[] objArr = new Object[5];
            String str3 = null;
            if (aVar != null) {
                str = aVar.f108629a;
            } else {
                str = null;
            }
            objArr[0] = str;
            if (aVar != null) {
                str2 = aVar.f108630b;
            } else {
                str2 = null;
            }
            objArr[1] = str2;
            if (aVar != null) {
                str3 = aVar.f108632d;
            }
            objArr[2] = str3;
            objArr[3] = Integer.valueOf(i3);
            objArr[4] = Integer.valueOf(i16);
            GdtLog.e("GdtInterstitialPreDownloader", String.format("onFailedToPreDownload appName:%s view:%s minVersion:%s error:%d arkError:%d", objArr));
            GdtAnalysisHelperForInterstitial.reportForPreDownloadInterstitialEnd(BaseApplication.getContext(), f.c().f108645b, i3, i16);
        }

        @Override // com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.a
        public void c(com.tencent.gdtad.api.interstitial.a aVar, int i3) {
            String str;
            String str2;
            Object[] objArr = new Object[4];
            String str3 = null;
            if (aVar != null) {
                str = aVar.f108629a;
            } else {
                str = null;
            }
            objArr[0] = str;
            if (aVar != null) {
                str2 = aVar.f108630b;
            } else {
                str2 = null;
            }
            objArr[1] = str2;
            if (aVar != null) {
                str3 = aVar.f108632d;
            }
            objArr[2] = str3;
            objArr[3] = Integer.valueOf(i3);
            GdtLog.i("GdtInterstitialPreDownloader", String.format("onStatusChanged appName:%s view:%s minVersion:%s status:%d", objArr));
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    static final class c implements AdIPCManager.Handler {
        @Override // com.tencent.ad.tangram.ipc.AdIPCManager.Handler
        @NonNull
        public AdIPCManager.Result handle(@Nullable AdIPCManager.Params params) {
            String str;
            AdIPCManager.Result result = new AdIPCManager.Result();
            if (params != null && params.isValid()) {
                f.c().e();
                result.success = true;
            }
            Object[] objArr = new Object[3];
            String str2 = null;
            if (params != null) {
                str = params.getAction();
            } else {
                str = null;
            }
            objArr[0] = str;
            if (params != null) {
                str2 = params.getToProcessName();
            }
            objArr[1] = str2;
            objArr[2] = Boolean.valueOf(result.success);
            GdtLog.i("GdtInterstitialPreDownloader", String.format("IPCHandlerForPreDownload.handle action:%s to:%s success:%b", objArr));
            return result;
        }
    }

    f() {
    }

    public static f c() {
        if (f108643e == null) {
            synchronized (f.class) {
                if (f108643e == null) {
                    f108643e = new f();
                }
            }
        }
        return f108643e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        boolean z16 = true;
        Object[] objArr = new Object[1];
        if (this.f108644a != null) {
            z16 = false;
        }
        objArr[0] = Boolean.valueOf(z16);
        GdtLog.i("GdtInterstitialPreDownloader", String.format("preDownloadImpl:%b", objArr));
        if (this.f108644a == null) {
            synchronized (this) {
                if (this.f108644a == null) {
                    this.f108645b = System.currentTimeMillis();
                    this.f108644a = new GdtArkPreDownloadTask(new WeakReference(this.f108647d), e.d().a(), WebViewConstants.WV.ENABLE_WEBAIO_SWITCH);
                    GdtAnalysisHelperForInterstitial.reportForPreDownloadInterstitialStart(BaseApplication.getContext());
                }
            }
        }
    }

    public int d() {
        if (this.f108644a != null) {
            return this.f108644a.p();
        }
        return Integer.MIN_VALUE;
    }
}
