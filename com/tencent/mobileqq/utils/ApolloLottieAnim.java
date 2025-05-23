package com.tencent.mobileqq.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.tencent.ams.dsdk.utils.DBHelper;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.mobileqq.vas.widget.lottie.LottieLoader;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ApolloLottieAnim implements Handler.Callback {
    private WeakReferenceHandler C;
    private WeakReference<Context> D;
    private WeakReference<LottieAnimationView> E;

    /* renamed from: h, reason: collision with root package name */
    private String f306860h;

    /* renamed from: i, reason: collision with root package name */
    private String f306861i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f306862m;

    /* renamed from: d, reason: collision with root package name */
    private boolean f306857d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f306858e = false;

    /* renamed from: f, reason: collision with root package name */
    protected int f306859f = 0;
    private DecoderRunnable F = new DecoderRunnable();

    /* compiled from: P */
    /* loaded from: classes20.dex */
    static class DecoderRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private String f306864d;

        /* renamed from: e, reason: collision with root package name */
        private String f306865e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f306866f;

        /* renamed from: h, reason: collision with root package name */
        private WeakReference<ApolloLottieAnim> f306867h;

        DecoderRunnable() {
        }

        public void a(ApolloLottieAnim apolloLottieAnim, String str, String str2, boolean z16) {
            this.f306864d = str;
            this.f306865e = str2;
            this.f306866f = z16;
            this.f306867h = new WeakReference<>(apolloLottieAnim);
        }

        @Override // java.lang.Runnable
        public void run() {
            WeakReference<ApolloLottieAnim> weakReference = this.f306867h;
            if (weakReference != null && weakReference.get() != null) {
                this.f306867h.get().m(this.f306864d, this.f306865e, this.f306866f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements OnCompositionLoadedListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LottieAnimationView f306868a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f306869b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f306870c;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.utils.ApolloLottieAnim$a$a, reason: collision with other inner class name */
        /* loaded from: classes20.dex */
        class C8890a implements ImageAssetDelegate {
            C8890a() {
            }

            @Override // com.airbnb.lottie.ImageAssetDelegate
            public Bitmap fetchBitmap(LottieImageAsset lottieImageAsset) {
                String str = a.this.f306869b + "/images/" + lottieImageAsset.getFileName();
                if (!new File(str).exists()) {
                    QLog.e("ApolloLottieAnim", 1, "fetchBitmap  bitmapPath is not exists: " + str);
                    return null;
                }
                return LottieHelper.a(str);
            }
        }

        a(LottieAnimationView lottieAnimationView, String str, boolean z16) {
            this.f306868a = lottieAnimationView;
            this.f306869b = str;
            this.f306870c = z16;
        }

        @Override // com.airbnb.lottie.OnCompositionLoadedListener
        public void onCompositionLoaded(LottieComposition lottieComposition) {
            if (lottieComposition == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("ApolloLottieAnim", 2, "composition is null ,return");
                }
            } else if (ApolloLottieAnim.this.f306858e) {
                if (QLog.isColorLevel()) {
                    QLog.d("ApolloLottieAnim", 2, "anim is destroy ,return");
                }
            } else {
                this.f306868a.setComposition(lottieComposition);
                this.f306868a.setImageAssetDelegate(new C8890a());
                if (this.f306870c) {
                    this.f306868a.setVisibility(0);
                    this.f306868a.playAnimation();
                }
                ApolloLottieAnim.this.f306857d = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b extends com.tencent.mobileqq.vip.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f306873a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f306874b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f306875c;

        b(String str, String str2, String str3) {
            this.f306873a = str;
            this.f306874b = str2;
            this.f306875c = str3;
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDone(com.tencent.mobileqq.vip.g gVar) {
            super.onDone(gVar);
            if (3 == gVar.i()) {
                ApolloLottieAnim.this.k(true, this.f306873a, this.f306874b, this.f306875c);
            } else {
                ApolloLottieAnim apolloLottieAnim = ApolloLottieAnim.this;
                apolloLottieAnim.f306859f = 2;
                apolloLottieAnim.k(false, this.f306873a, this.f306874b, this.f306875c);
            }
            if (QLog.isColorLevel()) {
                QLog.d("ApolloLottieAnim", 2, "downloadZip onDone task.getStatus()->" + gVar.i());
            }
        }
    }

    public ApolloLottieAnim(QQAppInterface qQAppInterface, Context context) {
        this.C = new WeakReferenceHandler(context.getMainLooper(), this);
        this.D = new WeakReference<>(context);
    }

    private void i(boolean z16, File file, String str) {
        if (z16) {
            try {
                o(file, str);
            } catch (Exception e16) {
                QLog.e("ApolloLottieAnim", 2, e16.getMessage());
                this.f306859f = 2;
                return;
            }
        }
        if (!j(str)) {
            QLog.e("ApolloLottieAnim", 1, "Lottie Anim data.json not exit");
            return;
        }
        this.f306859f = 3;
        n();
        l(str);
    }

    private void l(String str) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        Bundle bundle = new Bundle();
        bundle.putString(DBHelper.COL_FOLDER, str);
        obtain.setData(bundle);
        this.C.sendMessage(obtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(String str, String str2, boolean z16) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f306862m = z16;
        if (!str2.equals(this.f306860h)) {
            this.f306860h = str2;
            this.f306859f = 0;
        }
        String p16 = p(this.f306860h);
        new File(p16).mkdirs();
        if (QLog.isColorLevel()) {
            QLog.d("ApolloLottieAnim", 2, "setZipData mState:", Integer.valueOf(this.f306859f), ",zipUrl:", str, ",localZipPath:", this.f306860h);
        }
        boolean j3 = j(p16);
        if (!j3) {
            QLog.w("ApolloLottieAnim", 1, "setZipData Lottie Anim data.json not exit");
            this.f306859f = 0;
        }
        int i3 = this.f306859f;
        if (i3 != 2 && i3 != 0) {
            if (i3 == 3) {
                i(false, null, p16);
                return;
            }
            return;
        }
        this.f306857d = false;
        File file = new File(this.f306860h);
        if (j3) {
            i(false, file, p16);
        } else if (file.exists()) {
            i(true, file, p16);
        } else {
            e(str, this.f306860h, p16);
        }
    }

    private void o(File file, String str) throws IOException {
        if (file.exists() && !TextUtils.isEmpty(str)) {
            ZipUtils.unZipFile(file, str);
        }
    }

    private String p(String str) {
        if (!TextUtils.isEmpty(str)) {
            int lastIndexOf = str.lastIndexOf(".zip");
            if (lastIndexOf > 0) {
                str = str.substring(0, lastIndexOf);
            }
            return str + File.separator;
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void e(String str, String str2, String str3) {
        QQAppInterface qQAppInterface;
        DownloaderFactory downloaderFactory;
        com.tencent.mobileqq.vip.h u16;
        boolean z16 = true;
        this.f306859f = 1;
        final com.tencent.mobileqq.vip.g gVar = new com.tencent.mobileqq.vip.g(str, new File(str2));
        gVar.U = true;
        gVar.Q = true;
        gVar.S = "apollo_lottie";
        gVar.f313008f = 1;
        gVar.W = true;
        gVar.X = true;
        gVar.u(new b(str, str2, str3));
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        if (application != null) {
            AppRuntime runtime = application.getRuntime();
            if (runtime instanceof QQAppInterface) {
                qQAppInterface = (QQAppInterface) runtime;
                if (qQAppInterface != null && (downloaderFactory = (DownloaderFactory) qQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY)) != null && (u16 = downloaderFactory.u(2)) != null) {
                    u16.startDownload(gVar, gVar.g(), null);
                    z16 = false;
                }
                if (!z16) {
                    ThreadManagerV2.executeOnNetWorkThread(new Runnable() { // from class: com.tencent.mobileqq.utils.ApolloLottieAnim.3
                        @Override // java.lang.Runnable
                        public void run() {
                            DownloaderFactory.o(gVar, null);
                        }
                    });
                    return;
                }
                return;
            }
        }
        qQAppInterface = null;
        if (qQAppInterface != null) {
            u16.startDownload(gVar, gVar.g(), null);
            z16 = false;
        }
        if (!z16) {
        }
    }

    public void f(Context context, @NonNull LottieAnimationView lottieAnimationView, String str, boolean z16) {
        try {
            if (this.E == null) {
                this.E = new WeakReference<>(lottieAnimationView);
            }
            g(context, lottieAnimationView, str, new FileInputStream(str + LottieLoader.FILE_DATA_JSON), z16);
        } catch (Exception e16) {
            QLog.e("ApolloLottieAnim", 1, "fromFileWithCacheBitmap:" + e16);
        } catch (OutOfMemoryError e17) {
            QLog.e("ApolloLottieAnim", 1, "fromFileWithCacheBitmap err:" + e17);
        }
    }

    public void g(Context context, @NonNull LottieAnimationView lottieAnimationView, String str, InputStream inputStream, boolean z16) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("ApolloLottieAnim", 2, "fromFileWithCacheBitmap animPathFolder:", str);
            }
            if (lottieAnimationView.isAnimating()) {
                return;
            }
            if (this.f306857d && z16) {
                lottieAnimationView.playAnimation();
                return;
            }
            try {
                LottieComposition.Factory.fromInputStream(inputStream, new a(lottieAnimationView, str, z16));
            } catch (Exception e16) {
                QLog.e("ApolloLottieAnim", 1, "playApolloGameBoxLottieAnim:" + e16);
            }
        }
    }

    public void h(@NonNull LottieAnimationView lottieAnimationView, String str, String str2, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.E = new WeakReference<>(lottieAnimationView);
        this.f306861i = str;
        this.F.a(this, str, str2, z16);
        ThreadManagerV2.removeJobFromThreadPool(this.F, 16);
        ThreadManagerV2.excute(this.F, 16, null, true);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        WeakReference<Context> weakReference;
        WeakReference<LottieAnimationView> weakReference2;
        if (message.what == 1 && (weakReference = this.D) != null && weakReference.get() != null && (weakReference2 = this.E) != null && weakReference2.get() != null) {
            f(this.D.get(), this.E.get(), message.getData().getString(DBHelper.COL_FOLDER), this.f306862m);
            return false;
        }
        return false;
    }

    public boolean j(String str) {
        return new File(str + LottieLoader.FILE_DATA_JSON).exists();
    }

    protected void k(boolean z16, String str, String str2, String str3) {
        if (QLog.isColorLevel()) {
            QLog.d("ApolloLottieAnim", 2, "onDownloadFinish\uff0cresult:" + z16 + " url:" + str + " zipFile:" + str2 + " folder:" + str3);
        }
        String str4 = this.f306860h;
        if (str4 != null && !str4.equals(str2)) {
            if (QLog.isColorLevel()) {
                QLog.d("ApolloLottieAnim", 2, "onDownloadFinish\uff0czipFile unEqual mLocalZipPath:" + this.f306860h);
                return;
            }
            return;
        }
        if (z16) {
            File file = new File(str2);
            if (file.exists()) {
                i(true, file, str3);
                return;
            } else {
                this.f306859f = 2;
                return;
            }
        }
        this.f306859f = 2;
    }

    public void n() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.utils.ApolloLottieAnim.4
            @Override // java.lang.Runnable
            public void run() {
                if (ApolloLottieAnim.this.E != null && ApolloLottieAnim.this.E.get() != null) {
                    ((LottieAnimationView) ApolloLottieAnim.this.E.get()).cancelAnimation();
                }
            }
        });
        WeakReferenceHandler weakReferenceHandler = this.C;
        if (weakReferenceHandler != null) {
            weakReferenceHandler.removeCallbacksAndMessages(null);
        }
    }
}
