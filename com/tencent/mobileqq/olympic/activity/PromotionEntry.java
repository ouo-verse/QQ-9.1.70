package com.tencent.mobileqq.olympic.activity;

import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.tencent.av.u;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo;
import com.tencent.mobileqq.ar.ARPromotionMgr.e;
import com.tencent.mobileqq.ar.ARPromotionMgr.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;

/* loaded from: classes16.dex */
public class PromotionEntry {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    static final String f255116f;

    /* renamed from: a, reason: collision with root package name */
    private ImageView f255117a;

    /* renamed from: b, reason: collision with root package name */
    private c f255118b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f255119c;

    /* renamed from: d, reason: collision with root package name */
    private UpdateOperateBtnStatusRunnable f255120d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f255121e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public static class UpdateOperateBtnStatusRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public boolean f255122d;

        /* renamed from: e, reason: collision with root package name */
        private WeakReference<ImageView> f255123e;

        /* renamed from: f, reason: collision with root package name */
        ObjectAnimator f255124f;

        /* renamed from: h, reason: collision with root package name */
        LottieDrawable f255125h;

        /* renamed from: i, reason: collision with root package name */
        PromotionConfigInfo.a f255126i;

        /* renamed from: m, reason: collision with root package name */
        OnCompositionLoadedListener f255127m;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes16.dex */
        public class a implements OnCompositionLoadedListener {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f255128a;

            /* renamed from: com.tencent.mobileqq.olympic.activity.PromotionEntry$UpdateOperateBtnStatusRunnable$a$a, reason: collision with other inner class name */
            /* loaded from: classes16.dex */
            class C8176a implements ImageAssetDelegate {
                static IPatchRedirector $redirector_;

                C8176a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                    }
                }

                /* JADX WARN: Removed duplicated region for block: B:14:0x0085  */
                /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
                @Override // com.airbnb.lottie.ImageAssetDelegate
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Bitmap fetchBitmap(LottieImageAsset lottieImageAsset) {
                    Bitmap bitmap;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) lottieImageAsset);
                    }
                    ImageView imageView = (ImageView) UpdateOperateBtnStatusRunnable.this.f255123e.get();
                    if (imageView != null) {
                        String fileName = lottieImageAsset.getFileName();
                        int i3 = imageView.getResources().getDisplayMetrics().densityDpi;
                        int i16 = imageView.getResources().getDisplayMetrics().densityDpi;
                        String str = a.this.f255128a + "entry_images" + File.separator + fileName;
                        try {
                            bitmap = u.a(str, i3, i16);
                        } catch (Exception e16) {
                            if (QQAudioHelper.j()) {
                                QLog.w(PromotionEntry.f255116f, 1, "UpdateOperateBtnStatusRunnable Exception, imagePath[" + str + "]", e16);
                            }
                        }
                        if (bitmap != null) {
                            return Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
                        }
                        return bitmap;
                    }
                    bitmap = null;
                    if (bitmap != null) {
                    }
                }
            }

            a(String str) {
                this.f255128a = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) UpdateOperateBtnStatusRunnable.this, (Object) str);
                }
            }

            @Override // com.airbnb.lottie.OnCompositionLoadedListener
            public void onCompositionLoaded(@Nullable LottieComposition lottieComposition) {
                ObjectAnimator objectAnimator;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) lottieComposition);
                    return;
                }
                if (lottieComposition == null) {
                    return;
                }
                UpdateOperateBtnStatusRunnable.this.f255125h = new LottieDrawable();
                UpdateOperateBtnStatusRunnable.this.f255125h.setComposition(lottieComposition);
                UpdateOperateBtnStatusRunnable.this.f255125h.setImageAssetDelegate(new C8176a());
                UpdateOperateBtnStatusRunnable.this.f255125h.loop(true);
                ImageView imageView = (ImageView) UpdateOperateBtnStatusRunnable.this.f255123e.get();
                if (imageView != null && imageView.getVisibility() == 0 && (objectAnimator = UpdateOperateBtnStatusRunnable.this.f255124f) != null && !objectAnimator.isRunning()) {
                    imageView.setImageDrawable(UpdateOperateBtnStatusRunnable.this.f255125h);
                    UpdateOperateBtnStatusRunnable.this.f255125h.playAnimation();
                }
            }
        }

        UpdateOperateBtnStatusRunnable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f255122d = false;
            this.f255123e = new WeakReference<>(null);
            this.f255124f = null;
            this.f255125h = null;
            this.f255126i = null;
            this.f255127m = null;
        }

        public void c(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            } else {
                this.f255127m = new a(str);
            }
        }

        public void d(ImageView imageView, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) imageView, i3);
                return;
            }
            if (this.f255124f != null) {
                return;
            }
            PromotionConfigInfo.a aVar = this.f255126i;
            if (aVar == null) {
                QLog.w(PromotionEntry.f255116f, 1, "createShowOperateBtnAnim, promotionItem\u4e3a\u7a7a");
                return;
            }
            if (this.f255125h == null) {
                String b16 = e.b(aVar);
                c(b16);
                try {
                    LottieComposition.Factory.fromInputStream(new FileInputStream(b16 + "entry.json"), this.f255127m);
                } catch (Exception e16) {
                    QLog.i(PromotionEntry.f255116f, 1, "createShowOperateBtnAnim, \u8bfb\u53d6json\u5931\u8d25", e16);
                }
            }
        }

        public void e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            ImageView imageView = this.f255123e.get();
            if (imageView != null) {
                imageView.setImageDrawable(null);
            }
            LottieDrawable lottieDrawable = this.f255125h;
            if (lottieDrawable != null) {
                lottieDrawable.cancelAnimation();
                this.f255125h = null;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            ImageView imageView = this.f255123e.get();
            if (imageView == null) {
                return;
            }
            if (this.f255122d) {
                if (imageView.getVisibility() != 0) {
                    imageView.setVisibility(0);
                    d(imageView, 0);
                    ObjectAnimator objectAnimator = this.f255124f;
                    if (objectAnimator != null) {
                        objectAnimator.start();
                    }
                    LottieDrawable lottieDrawable = this.f255125h;
                    if (lottieDrawable != null) {
                        imageView.setImageDrawable(lottieDrawable);
                        this.f255125h.setRepeatCount(5);
                        this.f255125h.playAnimation();
                        return;
                    }
                    return;
                }
                return;
            }
            imageView.setVisibility(8);
            ObjectAnimator objectAnimator2 = this.f255124f;
            if (objectAnimator2 != null) {
                objectAnimator2.end();
            }
            LottieDrawable lottieDrawable2 = this.f255125h;
            if (lottieDrawable2 != null) {
                imageView.setImageDrawable(lottieDrawable2);
                this.f255125h.endAnimation();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class a implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PromotionEntry.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            if (PromotionEntry.this.f255117a == null) {
                return false;
            }
            if (motionEvent.getAction() == 1) {
                PromotionEntry.this.f255117a.setAlpha(255);
            } else if (motionEvent.getAction() == 0) {
                PromotionEntry.this.f255117a.setAlpha(100);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ PromotionConfigInfo.a f255132d;

        b(PromotionConfigInfo.a aVar) {
            this.f255132d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PromotionEntry.this, (Object) aVar);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ReportController.o(null, "CliOper", "", "", "0X8009C6B", "0X8009C6B", 0, 0, this.f255132d.f196897e, "0", "0", "");
                PromotionEntry.this.f255118b.l(this.f255132d);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes16.dex */
    public interface c {
        boolean a();

        RelativeLayout getTopView();

        void l(PromotionConfigInfo.a aVar);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73418);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f255116f = f.f196950a;
        }
    }

    public PromotionEntry(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar);
            return;
        }
        this.f255119c = false;
        this.f255120d = null;
        this.f255121e = true;
        this.f255118b = cVar;
    }

    private void g(String str, PromotionConfigInfo.a aVar, boolean z16) {
        boolean z17;
        String str2;
        String str3 = f255116f;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("updateOperateBtnStatus[");
        sb5.append(str);
        sb5.append("], visible[");
        sb5.append(z16);
        sb5.append("], mIsWorldCupMode[");
        sb5.append(this.f255118b.a());
        sb5.append("], mEnterTransferDoorModeByClickEntry[");
        sb5.append(this.f255119c);
        sb5.append("], operateBtn[");
        if (this.f255117a != null) {
            z17 = true;
        } else {
            z17 = false;
        }
        sb5.append(z17);
        sb5.append("]");
        QLog.w(str3, 1, sb5.toString());
        if (this.f255117a == null) {
            return;
        }
        if (this.f255120d == null) {
            this.f255120d = new UpdateOperateBtnStatusRunnable();
        }
        if (aVar != null) {
            this.f255120d.f255126i = aVar;
        }
        UpdateOperateBtnStatusRunnable updateOperateBtnStatusRunnable = this.f255120d;
        updateOperateBtnStatusRunnable.f255122d = z16;
        updateOperateBtnStatusRunnable.f255123e = new WeakReference(this.f255117a);
        ThreadManager.getUIHandler().removeCallbacks(this.f255120d);
        if (z16) {
            if (this.f255121e) {
                if (aVar != null) {
                    str2 = aVar.f196897e;
                } else {
                    str2 = "0";
                }
                ReportController.o(null, "CliOper", "", "", "0X8009C6A", "0X8009C6A", 0, 0, str2, "0", "0", "");
                this.f255121e = false;
            }
            ThreadManager.getUIHandler().postDelayed(this.f255120d, 500L);
            return;
        }
        ThreadManager.getUIHandler().post(this.f255120d);
    }

    public void c(boolean z16, PromotionConfigInfo.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), aVar);
        } else {
            g("operateBtnOnClick", aVar, z16);
            this.f255119c = true;
        }
    }

    public void d(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appInterface);
            return;
        }
        this.f255118b = null;
        this.f255121e = true;
        UpdateOperateBtnStatusRunnable updateOperateBtnStatusRunnable = this.f255120d;
        if (updateOperateBtnStatusRunnable != null) {
            updateOperateBtnStatusRunnable.e();
            this.f255120d = null;
        }
        ImageView imageView = this.f255117a;
        if (imageView != null) {
            imageView.setOnClickListener(null);
            this.f255117a = null;
        }
    }

    public void e(AppInterface appInterface, PromotionConfigInfo.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface, (Object) aVar);
            return;
        }
        if (this.f255117a != null) {
            return;
        }
        RelativeLayout topView = this.f255118b.getTopView();
        ImageView imageView = new ImageView(topView.getContext());
        Bitmap b16 = u.b(imageView.getResources(), e.b(aVar) + "entry.png");
        if (b16 != null) {
            imageView.setImageBitmap(b16);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(BaseAIOUtils.f(217.0f, imageView.getResources()), BaseAIOUtils.f(47.0f, imageView.getResources()));
        layoutParams.addRule(10, -1);
        layoutParams.addRule(13);
        int screenHeight = ImmersiveUtils.getScreenHeight();
        if (ImmersiveUtils.isSupporImmersive() != 1) {
            screenHeight -= ImmersiveUtils.getStatusBarHeight(topView.getContext());
        }
        layoutParams.topMargin = (int) ((screenHeight * 23) / 200.0f);
        imageView.setClickable(true);
        imageView.setOnTouchListener(new a());
        imageView.setOnClickListener(new b(aVar));
        imageView.setVisibility(8);
        topView.addView(imageView, layoutParams);
        this.f255117a = imageView;
        if (this.f255118b.a()) {
            QLog.w(f255116f, 1, "reallyCreateOperateEntry, \u5df2\u7ecf\u5728\u7a7f\u8d8a\u95e8\u6a21\u5f0f\u4e86");
        } else {
            g("reallyCreateOperateEntry", aVar, true);
        }
    }

    public void f(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            g("showEntry", null, z16);
        }
    }
}
