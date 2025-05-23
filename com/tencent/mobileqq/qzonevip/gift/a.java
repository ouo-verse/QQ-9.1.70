package com.tencent.mobileqq.qzonevip.gift;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qzonevip.gift.QzoneGiftUtil;
import com.tencent.mobileqq.qzonevip.gift.particle.ParticleDropView;
import com.tencent.mobileqq.qzonevip.gift.particle.ParticleExplodeView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasTempConstant;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.mobileqq.vas.util.VasPadUtils;
import com.tencent.mobileqq.vip.diy.common.DIYLottieLoader;
import com.tencent.open.base.g;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.utils.IQzoneZipCacheHelper;
import com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable;
import com.tencent.qzonehub.reborn.QZoneDownloadSharedPreferencesProvider;
import com.tencent.vas.update.entity.UpdateListenerParams;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.net.URL;
import mqq.manager.Manager;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a implements Manager, QzoneGiftUtil.b, View.OnTouchListener {
    static IPatchRedirector $redirector_;
    public static final float L;
    private static a M;
    private ImageView C;
    private ImageView D;
    private ParticleExplodeView E;
    private ImageView F;
    private ParticleDropView G;
    private e H;
    private LottieAnimationView I;
    private DIYLottieLoader J;
    private Downloader K;

    /* renamed from: d, reason: collision with root package name */
    private f f280150d;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f280151e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f280152f;

    /* renamed from: h, reason: collision with root package name */
    private Bitmap f280153h;

    /* renamed from: i, reason: collision with root package name */
    private WeakReference<FrameLayout> f280154i;

    /* renamed from: m, reason: collision with root package name */
    private FrameLayout f280155m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qzonevip.gift.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public class C8493a implements Downloader.DownloadListener {
        static IPatchRedirector $redirector_;

        C8493a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadCanceled(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadFailed(String str, DownloadResult downloadResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) downloadResult);
            } else {
                QLog.i("QzoneGiftManager", 1, "preloadFont fail error");
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
            } else {
                QLog.i("QzoneGiftManager", 1, "preloadFont success");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class b implements IDownLoadListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f280157a;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.qzonevip.gift.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes16.dex */
        class C8494a implements Downloader.DownloadListener {
            static IPatchRedirector $redirector_;

            C8494a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
                }
            }

            @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
            public void onDownloadCanceled(String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                }
            }

            @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
            public void onDownloadFailed(String str, DownloadResult downloadResult) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) downloadResult);
                } else {
                    QLog.i("QzoneGiftManager", 1, " preloadLottieZip fail error");
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
                } else {
                    QLog.i("QzoneGiftManager", 1, " preloadLottieZip success");
                }
            }
        }

        b(String str) {
            this.f280157a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NonNull UpdateListenerParams updateListenerParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) updateListenerParams);
            } else if (a.this.K != null && a.this.w()) {
                a.this.K.download(a.this.H.f280167e, this.f280157a, new C8494a());
            } else {
                QLog.e("QzoneGiftManager", 1, "preloadPagOrLottie error");
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NonNull UpdateListenerParams updateListenerParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) updateListenerParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class c extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        boolean f280160d;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            } else {
                this.f280160d = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
                return;
            }
            QLog.i("QzoneGiftManager", 1, "onAnimationEnd");
            if (this.f280160d) {
                a.this.F(8);
                a.this.y();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
            } else {
                QLog.i("QzoneGiftManager", 1, "onAnimationStart");
                this.f280160d = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class d extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
                return;
            }
            if (a.this.G != null) {
                a.this.G.k();
            }
            a.this.F(8);
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f280163a;

        /* renamed from: b, reason: collision with root package name */
        public String f280164b;

        /* renamed from: c, reason: collision with root package name */
        public String f280165c;

        /* renamed from: d, reason: collision with root package name */
        public String f280166d;

        /* renamed from: e, reason: collision with root package name */
        public String f280167e;

        /* renamed from: f, reason: collision with root package name */
        public String f280168f;

        /* renamed from: g, reason: collision with root package name */
        public int f280169g;

        /* renamed from: h, reason: collision with root package name */
        public String f280170h;

        /* renamed from: i, reason: collision with root package name */
        public int f280171i;

        public e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public static e a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            e eVar = new e();
            try {
                JSONObject jSONObject = new JSONObject(str);
                eVar.f280163a = jSONObject.optInt("animationType");
                eVar.f280164b = jSONObject.optString("boxZipUrl", null);
                eVar.f280165c = jSONObject.optString("giftZipUrl", null);
                eVar.f280166d = jSONObject.optString("giftParticleUrl", null);
                eVar.f280167e = jSONObject.optString("lottieUrl", null);
                eVar.f280168f = jSONObject.optString(WadlProxyConsts.KEY_JUMP_URL, null);
                eVar.f280170h = jSONObject.optString("fontUrl", null);
                eVar.f280169g = jSONObject.optInt("giftId");
                eVar.f280171i = jSONObject.optInt("giftType");
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.e("QzoneGiftManager", 1, "handleFlashChatConfig failed" + e16);
            }
            return eVar;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return " mBoxZipUrl = " + this.f280164b + " mGiftZipUrl = " + this.f280165c + " mGiftUrl = " + this.f280166d + " mJumpUrl = " + this.f280168f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class f extends Handler {
        static IPatchRedirector $redirector_;

        public f(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                try {
                    switch (message.what) {
                        case 1:
                            a.this.s();
                            return;
                        case 2:
                            a.this.t();
                            return;
                        case 3:
                            a.this.J();
                            return;
                        case 4:
                            a.this.K();
                            return;
                        case 5:
                            a.this.o();
                            return;
                        case 6:
                            a.this.M();
                            return;
                        case 7:
                            a.this.H();
                            return;
                        case 8:
                            a.this.D();
                            return;
                        default:
                            return;
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                    QLog.e("QzoneGiftManager", 1, "handleMessage exception = " + e16.getMessage());
                    return;
                }
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74478);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            L = ViewUtils.getScreenWidth() / 720.0f;
            M = null;
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f280150d = new f(Looper.getMainLooper());
        DownloaderFactory.getInstance(BaseApplication.getContext());
        DownloaderFactory.init(null, null, QZoneDownloadSharedPreferencesProvider.INSTANCE);
        this.K = DownloaderFactory.getInstance(BaseApplication.getContext()).getCommonDownloader();
    }

    private void A() {
        String p16 = p(this.H.f280170h);
        if (QLog.isColorLevel()) {
            QLog.i("QzoneGiftManager", 2, " preloadFont local path = " + p16 + " url = " + this.H.f280170h);
        }
        this.K.download(this.H.f280170h, p16, new C8493a());
    }

    private void C() {
        com.tencent.mobileqq.vas.quickupdate.c cVar = (com.tencent.mobileqq.vas.quickupdate.c) QQVasUpdateBusiness.getBusiness(com.tencent.mobileqq.vas.quickupdate.c.class);
        cVar.addDownLoadListener(this.H.f280169g, new b(p(this.H.f280167e)));
        if (!cVar.isFileExists(this.H.f280169g)) {
            cVar.startDownload(this.H.f280169g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        QLog.i("QzoneGiftManager", 1, "MSG_RECYCLE_VIEW");
        if (this.f280151e != null) {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).release(this.f280151e);
        }
        if (this.f280152f != null) {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).release(this.f280152f);
        }
        DIYLottieLoader dIYLottieLoader = this.J;
        if (dIYLottieLoader != null) {
            dIYLottieLoader.destroy();
        }
        LottieAnimationView lottieAnimationView = this.I;
        if (lottieAnimationView != null) {
            lottieAnimationView.removeAllAnimatorListeners();
        }
        WeakReference<FrameLayout> weakReference = this.f280154i;
        if (weakReference != null && (frameLayout = weakReference.get()) != null && (frameLayout2 = this.f280155m) != null) {
            frameLayout.removeView(frameLayout2);
        }
    }

    private void E() {
        if (this.f280150d == null) {
            return;
        }
        for (int i3 = 1; i3 < 9; i3++) {
            if (this.f280150d.hasMessages(i3)) {
                this.f280150d.removeMessages(i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(int i3) {
        G(i3, 0);
    }

    private void G(int i3, int i16) {
        f fVar = this.f280150d;
        if (fVar == null) {
            return;
        }
        if (fVar.hasMessages(i3)) {
            this.f280150d.removeMessages(i3);
        }
        this.f280150d.sendEmptyMessageDelayed(i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        FrameLayout.LayoutParams layoutParams;
        QLog.i("QzoneGiftManager", 1, "MSG_GIFT_LOTTIE_ANIMATION_SHOW");
        if (this.I != null && this.f280155m != null) {
            VasPadUtils vasPadUtils = VasPadUtils.INSTANCE;
            if (vasPadUtils.isPadSplitLandscape(q())) {
                layoutParams = new FrameLayout.LayoutParams(ImmersiveUtils.getScreenHeight() - vasPadUtils.getSplitLeftWidth(q()), -1, 5);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            this.f280155m.addView(this.I, layoutParams);
        }
    }

    private void I() {
        QLog.i("QzoneGiftManager", 1, "MSG_SHADER_SHOW");
        ImageView imageView = this.F;
        if (imageView != null) {
            imageView.setBackgroundColor(Color.parseColor("#000000"));
            this.F.setAlpha(0);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.F, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 0.5f);
            ofFloat.setDuration(300L);
            ofFloat.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        QLog.i("QzoneGiftManager", 1, "MSG_BOX_ANIMATION_START");
        if (this.f280151e != null) {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).start(this.f280151e);
            G(5, ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).getDuration(this.f280151e) - 330);
            G(4, ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).getDuration(this.f280151e) - 300);
        }
        if (this.f280151e == null) {
            G(4, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        QLog.i("QzoneGiftManager", 1, "MSG_GIFT_ANIMATION_START");
        I();
        if (this.f280152f != null) {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).start(this.f280152f);
        }
        ParticleDropView particleDropView = this.G;
        if (particleDropView != null) {
            particleDropView.j();
        }
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.D, BasicAnimation.KeyPath.SCALE_X, 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.D, BasicAnimation.KeyPath.SCALE_Y, 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.D, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ofFloat3.setInterpolator(new DecelerateInterpolator());
        animatorSet.setDuration(400L);
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
        animatorSet.start();
        if (this.f280152f != null) {
            G(6, ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).getDuration(this.f280152f) + 2000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        QLog.i("QzoneGiftManager", 1, "MSG_GIFT_ANIMATION_STOP");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f280155m, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        ofFloat.setDuration(500L);
        ofFloat.addListener(new d());
        ofFloat.start();
    }

    private Drawable n(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("QzoneGiftManager", 1, "createAnimationDrawable mZipPath = null");
            return null;
        }
        Drawable zipAnimationDrawable = ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).getZipAnimationDrawable();
        String f16 = QzoneGiftUtil.f(str);
        if (QLog.isDevelopLevel()) {
            QLog.i("QzoneGiftManager", 4, "createAnimationDrawable mZipPath = " + str + " resUrl = " + f16);
        }
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setAnimationRes(zipAnimationDrawable, f16, i3);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setScale(zipAnimationDrawable, L);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).clearFirstFrame(zipAnimationDrawable);
        return zipAnimationDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        QLog.i("QzoneGiftManager", 1, "MSG_GIFT_PARTICLE_EXPLODE");
        ParticleExplodeView particleExplodeView = this.E;
        if (particleExplodeView != null) {
            particleExplodeView.j();
        }
    }

    private String p(String str) {
        try {
            return VasTempConstant.External.DYNAMIC_DRAWABLE_DIR + new URL(str).getHost() + "-" + g.d(str);
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    private Activity q() {
        BaseActivity baseActivity = BaseActivity.sTopActivity;
        if (baseActivity != null) {
            return baseActivity;
        }
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null) {
            return qBaseActivity;
        }
        return null;
    }

    public static a r() {
        if (M == null) {
            synchronized (a.class) {
                if (M == null) {
                    M = new a();
                }
            }
        }
        return M;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        QLog.i("QzoneGiftManager", 1, "MSG_INIT_CONTENT_VIEW");
        Activity q16 = q();
        if (q16 != null) {
            WeakReference<FrameLayout> weakReference = new WeakReference<>((FrameLayout) q16.findViewById(R.id.content));
            this.f280154i = weakReference;
            FrameLayout frameLayout = weakReference.get();
            if (frameLayout == null) {
                QLog.e("QzoneGiftManager", 1, "mParentLayout = null");
                return;
            }
            FrameLayout frameLayout2 = new FrameLayout(BaseApplication.getContext());
            this.f280155m = frameLayout2;
            frameLayout2.setOnTouchListener(this);
            frameLayout.addView(this.f280155m, new FrameLayout.LayoutParams(-1, -1));
            if (w()) {
                this.f280150d.sendEmptyMessage(7);
                return;
            } else {
                F(2);
                return;
            }
        }
        QLog.e("QzoneGiftManager", 1, "activity = null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        QLog.i("QzoneGiftManager", 1, "MSG_INIT_VIEW");
        if (this.f280155m == null) {
            QLog.e("QzoneGiftManager", 1, "mCotentLayout = null");
            return;
        }
        ImageView imageView = new ImageView(BaseApplication.getContext());
        this.F = imageView;
        this.f280155m.addView(imageView);
        ImageView imageView2 = new ImageView(BaseApplication.getContext());
        this.C = imageView2;
        imageView2.setImageDrawable(this.f280151e);
        ImageView imageView3 = new ImageView(BaseApplication.getContext());
        this.D = imageView3;
        imageView3.setImageDrawable(this.f280152f);
        this.D.setAlpha(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewUtils.dpToPx(200.0f), ViewUtils.dpToPx(200.0f));
        layoutParams.gravity = 17;
        this.f280155m.addView(this.C, layoutParams);
        this.f280155m.addView(this.D, layoutParams);
        this.E = new ParticleExplodeView(BaseApplication.getContext());
        ParticleDropView particleDropView = new ParticleDropView(BaseApplication.getContext());
        this.G = particleDropView;
        particleDropView.setBitmap(this.f280153h);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.f280155m.addView(this.E, layoutParams2);
        this.f280155m.addView(this.G, layoutParams2);
        F(3);
    }

    private void u() {
        DIYLottieLoader dIYLottieLoader = new DIYLottieLoader(BaseApplication.getContext());
        dIYLottieLoader.setMemoryCacheSize((int) (sy3.b.a() / 2));
        this.J = dIYLottieLoader;
    }

    private void v() {
        LottieAnimationView lottieAnimationView = new LottieAnimationView(BaseApplication.getContext());
        this.I = lottieAnimationView;
        lottieAnimationView.loop(false);
        this.I.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.I.addAnimatorListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        e eVar = this.H;
        if (eVar != null && !TextUtils.isEmpty(eVar.f280168f) && this.H.f280168f.startsWith("https://")) {
            Activity q16 = q();
            if (q16 == null) {
                QLog.e("QzoneGiftManager", 1, "activity null");
                return;
            }
            Intent intent = new Intent(q16, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", this.H.f280168f);
            q16.startActivity(intent);
        }
    }

    private void z() {
        if (!w()) {
            return;
        }
        u();
        v();
        this.J.fromNetworkWithCacheBitmap(this.I, this.H.f280167e, ((IQzoneZipCacheHelper) QRoute.api(IQzoneZipCacheHelper.class)).getBasePath("aio_lottie_gift", String.valueOf(this.H.f280167e.hashCode())) + ".zip", true);
        F(1);
    }

    public void B(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("QzoneGiftManager", 2, " preload data = " + str);
        }
        this.H = e.a(str);
        if (x()) {
            C();
        } else {
            e eVar = this.H;
            if (eVar != null) {
                QzoneGiftUtil.d(null, eVar.f280164b, eVar.f280165c, eVar.f280166d);
            } else {
                QLog.e("QzoneGiftManager", 1, "preloadGiftData error with data = null");
            }
        }
        if (this.H.f280171i == 17) {
            A();
        }
    }

    public void L(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("QzoneGiftManager", 2, " startPlay data = " + str);
        }
        this.H = e.a(str);
        if (w()) {
            z();
            return;
        }
        e eVar = this.H;
        if (eVar != null) {
            QzoneGiftUtil.d(this, eVar.f280164b, eVar.f280165c, eVar.f280166d);
        } else {
            QLog.e("QzoneGiftManager", 1, "preloadGiftData error with data = null");
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            E();
            F(8);
        }
    }

    @Override // com.tencent.mobileqq.qzonevip.gift.QzoneGiftUtil.b
    public void onFail() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.H == null) {
            QLog.e("QzoneGiftManager", 1, "onFail show fail mGiftData = null");
            return;
        }
        QLog.e("QzoneGiftManager", 1, "onFail show fail mGiftData = " + this.H.toString());
    }

    @Override // com.tencent.mobileqq.qzonevip.gift.QzoneGiftUtil.b
    public void onLoading() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            QLog.i("QzoneGiftManager", 1, "onLoading");
        }
    }

    @Override // com.tencent.mobileqq.qzonevip.gift.QzoneGiftUtil.b
    public void onSuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        e eVar = this.H;
        if (eVar != null && !TextUtils.isEmpty(eVar.f280165c) && !TextUtils.isEmpty(this.H.f280166d)) {
            this.f280151e = n(this.H.f280164b, 10);
            Drawable n3 = n(this.H.f280165c, 10);
            this.f280152f = n3;
            if (n3 != null) {
                ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setShowLastFrameWhenStop(this.f280152f, true);
                ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setRepeatAnimation(this.f280152f, false);
            }
            String e16 = QzoneGiftUtil.e(this.H.f280166d, "qzone_aio_gift");
            if (!TextUtils.isEmpty(e16)) {
                if (QLog.isDevelopLevel()) {
                    QLog.i("QzoneGiftManager", 4, "show Gift giftLocalPath = " + e16);
                }
                this.f280153h = BitmapFactory.decodeFile(e16);
            }
            F(1);
            return;
        }
        QLog.e("QzoneGiftManager", 1, "onSuccess show fail : data = null ");
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
        if (motionEvent.getAction() == 0) {
            E();
            F(8);
            return true;
        }
        return true;
    }

    public boolean w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        e eVar = this.H;
        if (eVar != null && eVar.f280163a == 1 && !TextUtils.isEmpty(eVar.f280167e)) {
            return true;
        }
        return false;
    }

    public boolean x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        e eVar = this.H;
        if (eVar != null && eVar.f280163a != 0 && eVar.f280169g != 0) {
            return true;
        }
        return false;
    }
}
