package com.qzone.feed.panorama;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.widget.AsyncImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.apollo.view.opengl.GLTextureView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.cl;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.panorama.IPanoramaBallView;
import com.tencent.qzonehub.api.panorama.IPanoramaGuideAnimate;
import com.tencent.qzonehub.api.panorama.IPanoramaLoadingLayout;
import com.tencent.qzonehub.api.panorama.IPanoramaUtil;
import com.tencent.qzonehub.api.panorama.IPanoramaView;
import com.tencent.qzonehub.api.panorama.OnAnimateListener;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import common.config.service.QzoneConfig;
import cooperation.qzone.panorama.callback.OnPanoramaClickListener;
import cooperation.qzone.panorama.callback.OnPanoramaLoadingListener;
import cooperation.qzone.panorama.model.CylinderModel;
import cooperation.qzone.panorama.model.ShapeModel;
import cooperation.qzone.panorama.piece.PanoramaPieceManager;
import cooperation.qzone.panorama.util.PanoramaConfig;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import mqq.app.AppRuntime;

/* loaded from: classes39.dex */
public class PanoramaLayout extends FrameLayout implements ShapeModel.OnRotateListener, OnPanoramaLoadingListener {
    private Context C;
    private View.OnClickListener D;
    private OnPanoramaClickListener E;
    private OnPanoramaLoadingListener F;
    private int G;
    private boolean H;
    private HashMap<String, String> I;
    private boolean J;
    private PanoramaPieceManager K;
    private int L;
    private View.OnClickListener M;
    private View.OnClickListener N;
    private Timer P;
    private TimerTask Q;
    private float R;

    /* renamed from: d, reason: collision with root package name */
    private GLTextureView f47262d;

    /* renamed from: e, reason: collision with root package name */
    private View f47263e;

    /* renamed from: f, reason: collision with root package name */
    private RelativeLayout f47264f;

    /* renamed from: h, reason: collision with root package name */
    private LinearLayout f47265h;

    /* renamed from: i, reason: collision with root package name */
    private PanoramaConfig.Builder f47266i;

    /* renamed from: m, reason: collision with root package name */
    private AsyncImageView f47267m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qzone.feed.panorama.PanoramaLayout$3, reason: invalid class name */
    /* loaded from: classes39.dex */
    public class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PanoramaLayout.this.f47266i == null || PanoramaLayout.this.f47265h != null) {
                return;
            }
            PanoramaLayout.this.f47265h = ((IPanoramaGuideAnimate) QRoute.api(IPanoramaGuideAnimate.class)).getPanoramaGuideAnimate(PanoramaLayout.this.C);
            ((IPanoramaGuideAnimate) QRoute.api(IPanoramaGuideAnimate.class)).addView(PanoramaLayout.this.f47265h, PanoramaLayout.this.f47266i.getPanoramaType());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            if (PanoramaLayout.this.f47266i.getPanoramaType() == 1) {
                layoutParams.gravity = 17;
                layoutParams.topMargin = ViewUtils.getStatusBarHeight(PanoramaLayout.this.C);
            } else {
                layoutParams.gravity = 81;
                layoutParams.bottomMargin = ViewUtils.dip2px(15.0f);
            }
            PanoramaLayout panoramaLayout = PanoramaLayout.this;
            panoramaLayout.addView(panoramaLayout.f47265h, layoutParams);
            ((IPanoramaGuideAnimate) QRoute.api(IPanoramaGuideAnimate.class)).setOnAnimateListener(PanoramaLayout.this.f47265h, new OnAnimateListener() { // from class: com.qzone.feed.panorama.PanoramaLayout.3.1
                @Override // com.tencent.qzonehub.api.panorama.OnAnimateListener
                public void onAnimateComplete() {
                    PanoramaLayout.this.post(new Runnable() { // from class: com.qzone.feed.panorama.PanoramaLayout.3.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PanoramaLayout.this.f47265h != null) {
                                PanoramaLayout.this.f47265h.setVisibility(8);
                                PanoramaLayout panoramaLayout2 = PanoramaLayout.this;
                                panoramaLayout2.removeView(panoramaLayout2.f47265h);
                                PanoramaLayout.this.f47265h = null;
                            }
                        }
                    });
                }
            });
        }
    }

    /* loaded from: classes39.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (PanoramaLayout.this.E != null) {
                PanoramaLayout.this.E.onPanoramaClick();
            }
            if (PanoramaLayout.this.D != null) {
                PanoramaLayout.this.D.onClick(view);
            }
            String A = PanoramaLayout.this.A();
            if (A != null) {
                ((IPanoramaUtil) QRoute.api(IPanoramaUtil.class)).reportMta(A, "click", 0);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes39.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (PanoramaLayout.this.f47263e != null) {
                PanoramaLayout.this.M(((IPanoramaBallView) QRoute.api(IPanoramaBallView.class)).getMoveDegreeX(PanoramaLayout.this.f47263e) % 360, ((IPanoramaBallView) QRoute.api(IPanoramaBallView.class)).getMoveDegreeY(PanoramaLayout.this.f47263e));
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public PanoramaLayout(Context context) {
        super(context);
        this.H = false;
        this.I = new HashMap<>();
        this.J = false;
        this.L = QzoneConfig.getInstance().getConfig("QZoneSetting", "panoramaGuideAnimateTime", 24);
        this.M = new a();
        this.N = new b();
        D(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String A() {
        PanoramaConfig.Builder builder = this.f47266i;
        if (builder != null) {
            if (builder.getPanoramaType() == 2) {
                return "qzone_feed_panorama";
            }
            if (this.f47266i.getPanoramaType() == 4) {
                return "qzone_gallery_panorama";
            }
            if (this.f47266i.getPanoramaType() == 1) {
                return "qzone_cover_panorama";
            }
        }
        return null;
    }

    private ImageLoader.Options C(int i3) {
        ImageLoader.Options obtain = ImageLoader.Options.obtain();
        if (this.f47266i.getModeType() == 0) {
            if (((IPanoramaUtil) QRoute.api(IPanoramaUtil.class)).isHighDevice()) {
                obtain.imageConfig = Bitmap.Config.ARGB_8888;
            } else {
                obtain.imageConfig = Bitmap.Config.RGB_565;
            }
        } else {
            obtain.imageConfig = Bitmap.Config.ARGB_8888;
        }
        obtain.mImageType = i3 == 1 ? 3 : 4;
        obtain.type = AppConstants.HTTP_TYPE_QZONE_DOWNLOAD_BIG_PIC;
        return obtain;
    }

    private void D(Context context) {
        this.C = context;
        setOnClickListener(this.M);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        PanoramaConfig.Builder builder = this.f47266i;
        if (builder == null || !builder.isShowGuideAnimate()) {
            return;
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).postDelayed(new Runnable() { // from class: com.qzone.feed.panorama.PanoramaLayout.2
            @Override // java.lang.Runnable
            public void run() {
                String z16 = PanoramaLayout.this.z();
                if (PanoramaLayout.this.f47266i != null && !TextUtils.isEmpty(PanoramaLayout.this.f47266i.getPanoramaExtraValue(PanoramaConfig.KEY_CURRENT_UIN))) {
                    z16 = PanoramaLayout.this.f47266i.getPanoramaExtraValue(PanoramaConfig.KEY_CURRENT_UIN);
                }
                String d16 = cl.d(PanoramaLayout.this.C, "key_panorama_guide_animation_" + z16);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date();
                if (TextUtils.isEmpty(d16)) {
                    cl.j(PanoramaLayout.this.C, "key_panorama_guide_animation_" + z16, simpleDateFormat.format(date));
                    PanoramaLayout.this.N();
                    return;
                }
                try {
                    if (((date.getTime() - simpleDateFormat.parse(d16).getTime()) * 1.0d) / 3600000.0d > PanoramaLayout.this.L) {
                        cl.j(PanoramaLayout.this.C, "key_panorama_guide_animation_" + z16, simpleDateFormat.format(date));
                        PanoramaLayout.this.N();
                    }
                } catch (ParseException e16) {
                    e16.printStackTrace();
                    QZLog.e("PanoramaLayout", "ParseException", e16);
                    cl.j(PanoramaLayout.this.C, "key_panorama_guide_animation_" + z16, simpleDateFormat.format(date));
                    PanoramaLayout.this.N();
                }
            }
        }, 1500L);
    }

    private void H() {
        if (this.f47266i == null) {
            return;
        }
        ImageLoader.Options C = C(1);
        if (this.f47266i.getPanoramaType() == 1 || this.f47266i.getPanoramaType() == 4) {
            C.mImageType = 4;
        }
        Drawable loadImage = ImageLoader.getInstance().loadImage(this.f47266i.getThumbUrl(), new PanoramaImageListener(1), ImageLoader.Options.copy(C));
        if (loadImage != null) {
            this.f47266i.setTextureDrawable(loadImage);
            v(this.f47266i);
        }
    }

    private void L() {
        if (this.f47262d != null) {
            ((IPanoramaView) QRoute.api(IPanoramaView.class)).onRecycled(this.f47262d);
            removeView(this.f47262d);
        }
        View view = this.f47263e;
        if (view != null) {
            removeView(view);
        }
        LinearLayout linearLayout = this.f47265h;
        if (linearLayout != null) {
            removeView(linearLayout);
        }
        this.f47262d = null;
        this.f47263e = null;
        this.f47265h = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(final int i3, final int i16) {
        w();
        if (i3 > 180) {
            i3 -= 360;
        } else if (i3 < -180) {
            i3 += 360;
        }
        if (i3 % 360 == 0) {
            this.R = 0.5f;
        } else {
            float abs = Math.abs(i16) / (Math.abs(i3) / 0.5f);
            this.R = abs;
            if (abs >= 0.5f) {
                this.R = 0.5f;
            }
        }
        this.P = new BaseTimer();
        TimerTask timerTask = new TimerTask() { // from class: com.qzone.feed.panorama.PanoramaLayout.7

            /* renamed from: d, reason: collision with root package name */
            private float f47274d = 0.0f;

            /* renamed from: e, reason: collision with root package name */
            private float f47275e = 0.0f;

            /* renamed from: f, reason: collision with root package name */
            private float f47276f = 0.0f;

            /* renamed from: h, reason: collision with root package name */
            private float f47277h = 0.0f;

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                float f16 = this.f47274d;
                int i17 = i3;
                if (f16 != i17) {
                    if (i17 > 0) {
                        if (f16 > i17) {
                            float f17 = i17;
                            this.f47274d = f17;
                            this.f47276f = f17 - i17;
                        } else {
                            this.f47274d = f16 + 0.5f;
                            this.f47276f = 0.5f;
                        }
                    } else if (f16 < i17) {
                        float f18 = i17;
                        this.f47274d = f18;
                        this.f47276f = f18 - i17;
                    } else {
                        this.f47274d = f16 - 0.5f;
                        this.f47276f = -0.5f;
                    }
                }
                float f19 = this.f47275e;
                int i18 = i16;
                if (f19 != i18) {
                    if (i18 > 0) {
                        if (f19 > i18) {
                            float f26 = i18;
                            this.f47275e = f26;
                            this.f47277h = f26 - i18;
                        } else {
                            this.f47275e = f19 + PanoramaLayout.this.R;
                            this.f47277h = PanoramaLayout.this.R;
                        }
                    } else if (f19 < i18) {
                        float f27 = i18;
                        this.f47275e = f27;
                        this.f47277h = f27 - i18;
                    } else {
                        this.f47275e = f19 - PanoramaLayout.this.R;
                        this.f47277h = -PanoramaLayout.this.R;
                    }
                }
                if (PanoramaLayout.this.f47262d != null) {
                    if (this.f47274d == i3) {
                        ((IPanoramaView) QRoute.api(IPanoramaView.class)).changeRotate(PanoramaLayout.this.f47262d, this.f47277h, 0.0f);
                    } else if (this.f47275e == i16) {
                        ((IPanoramaView) QRoute.api(IPanoramaView.class)).changeRotate(PanoramaLayout.this.f47262d, 0.0f, this.f47276f);
                    } else {
                        ((IPanoramaView) QRoute.api(IPanoramaView.class)).changeRotate(PanoramaLayout.this.f47262d, this.f47277h, this.f47276f);
                    }
                }
                if (this.f47274d == i3 && this.f47275e == i16) {
                    PanoramaLayout.this.P.cancel();
                    cancel();
                }
            }
        };
        this.Q = timerTask;
        this.P.schedule(timerTask, 0L, 1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        new Handler(Looper.getMainLooper()).post(new AnonymousClass3());
    }

    private void w() {
        Timer timer = this.P;
        if (timer != null) {
            timer.cancel();
        }
        TimerTask timerTask = this.Q;
        if (timerTask != null) {
            timerTask.cancel();
        }
        this.P = null;
        this.Q = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String z() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime == null) {
            return null;
        }
        QLog.i("PanoramaLayout", 4, "getCurrentUin = " + runtime.getAccount());
        return runtime.getAccount();
    }

    public PanoramaConfig.Builder B() {
        return this.f47266i;
    }

    public boolean E() {
        return (this.f47262d == null || this.f47266i == null) ? false : true;
    }

    public boolean F() {
        return this.H;
    }

    public void I() {
        GLTextureView gLTextureView = this.f47262d;
        if (gLTextureView != null) {
            gLTextureView.onPause();
        }
        w();
    }

    public void J() {
        L();
        if (this.f47264f != null) {
            ((IPanoramaLoadingLayout) QRoute.api(IPanoramaLoadingLayout.class)).onRecycled(this.f47264f);
            removeView(this.f47264f);
        }
        AsyncImageView asyncImageView = this.f47267m;
        if (asyncImageView != null) {
            removeView(asyncImageView);
            this.f47267m = null;
        }
        this.K = null;
        this.f47264f = null;
        this.f47266i = null;
    }

    public void K() {
        PanoramaPieceManager panoramaPieceManager = this.K;
        if (panoramaPieceManager != null) {
            panoramaPieceManager.onResume();
        }
        GLTextureView gLTextureView = this.f47262d;
        if (gLTextureView != null) {
            gLTextureView.onResume();
        }
    }

    public void P(PanoramaConfig.Builder builder, OnPanoramaLoadingListener onPanoramaLoadingListener) {
        this.F = onPanoramaLoadingListener;
        O(builder);
    }

    public void Q() {
        if (this.f47266i == null || !((IPanoramaUtil) QRoute.api(IPanoramaUtil.class)).isNeedShowPanorama()) {
            return;
        }
        QZLog.i("PanoramaLayout", 4, "startLoading ");
        if (this.f47264f != null) {
            ((IPanoramaLoadingLayout) QRoute.api(IPanoramaLoadingLayout.class)).startRotateAnimate(this.f47264f);
        }
        H();
    }

    @Override // cooperation.qzone.panorama.callback.OnPanoramaLoadingListener
    public void onPanoramaLoad() {
        post(new Runnable() { // from class: com.qzone.feed.panorama.PanoramaLayout.4
            @Override // java.lang.Runnable
            public void run() {
                PanoramaLayout.this.H = true;
                if (PanoramaLayout.this.F != null) {
                    PanoramaLayout.this.F.onPanoramaLoad();
                }
                if (PanoramaLayout.this.f47266i == null) {
                    return;
                }
                if (PanoramaLayout.this.f47263e == null && PanoramaLayout.this.f47266i.isShowPanoramaBall()) {
                    PanoramaLayout.this.f47263e = ((IPanoramaBallView) QRoute.api(IPanoramaBallView.class)).getPanoramaBallView(PanoramaLayout.this.C);
                    ((IPanoramaBallView) QRoute.api(IPanoramaBallView.class)).setModeType(PanoramaLayout.this.f47263e, PanoramaLayout.this.f47266i.getModeType());
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(IPanoramaBallView.WIDTH, IPanoramaBallView.HEIGHT);
                    layoutParams.rightMargin = ViewUtils.dpToPx(10.0f);
                    layoutParams.gravity = 21;
                    PanoramaLayout panoramaLayout = PanoramaLayout.this;
                    panoramaLayout.addView(panoramaLayout.f47263e, layoutParams);
                    PanoramaLayout.this.f47263e.setOnClickListener(PanoramaLayout.this.N);
                }
                PanoramaLayout.this.y(1);
                PanoramaLayout.this.G();
            }
        });
    }

    @Override // cooperation.qzone.panorama.model.ShapeModel.OnRotateListener
    public void onRotate(final int i3, final float f16, float f17, final float f18) {
        float f19;
        PanoramaConfig.Builder builder = this.f47266i;
        if (builder != null) {
            if (builder.getModeType() != 0) {
                f19 = this.f47266i.getModeType() == 2 ? CylinderModel.INIT_ROTATE : 90.0f;
            }
            f17 += f19;
        }
        final float f26 = f17;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qzone.feed.panorama.PanoramaLayout.5
            @Override // java.lang.Runnable
            public void run() {
                if (PanoramaLayout.this.f47263e != null) {
                    ((IPanoramaBallView) QRoute.api(IPanoramaBallView.class)).setDegreeChange(PanoramaLayout.this.f47263e, i3, (int) f26, (int) f16, f18);
                }
            }
        });
    }

    public void setFeedPosition(int i3) {
        this.G = i3;
    }

    public void setOnCoverClickListener(View.OnClickListener onClickListener) {
        this.D = onClickListener;
    }

    public void setOnPanoramaListener(OnPanoramaClickListener onPanoramaClickListener) {
        this.E = onPanoramaClickListener;
    }

    public void setPanoramaPlaying(boolean z16) {
        this.J = z16;
        if (z16) {
            return;
        }
        L();
        AsyncImageView asyncImageView = this.f47267m;
        if (asyncImageView != null) {
            asyncImageView.setVisibility(0);
            this.f47267m.bringToFront();
        }
        RelativeLayout relativeLayout = this.f47264f;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
            this.f47264f.bringToFront();
        }
    }

    public void setPanoramaUrls(String str, String str2) {
        if (this.I == null) {
            this.I = new HashMap<>();
        }
        this.I.put(str, str2);
    }

    public void x(String str) {
        if (TextUtils.isEmpty(str) || this.f47266i == null) {
            return;
        }
        Drawable loadImage = ImageLoader.getInstance().loadImage(str, new PanoramaImageListener(2), ImageLoader.Options.copy(C(1)));
        if (loadImage != null) {
            this.f47266i.setTextureDrawable(loadImage);
            y(1);
        }
    }

    public void y(int i3) {
        if (this.f47262d != null) {
            ((IPanoramaView) QRoute.api(IPanoramaView.class)).changeRenderMode(this.f47262d, i3);
        }
        if (i3 != 0) {
            if (this.f47264f != null) {
                ((IPanoramaLoadingLayout) QRoute.api(IPanoramaLoadingLayout.class)).stopRotateAnimate(this.f47264f);
                this.f47264f.setVisibility(8);
                PanoramaConfig.Builder builder = this.f47266i;
                if (builder != null && builder.getShowType() == 0) {
                    removeView(this.f47264f);
                }
            }
            AsyncImageView asyncImageView = this.f47267m;
            if (asyncImageView != null) {
                asyncImageView.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class PanoramaImageListener implements ImageLoader.ImageLoadListener {

        /* renamed from: d, reason: collision with root package name */
        private int f47280d;

        public PanoramaImageListener(int i3) {
            this.f47280d = i3;
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
            PanoramaLayout.this.post(new Runnable() { // from class: com.qzone.feed.panorama.PanoramaLayout.PanoramaImageListener.1
                @Override // java.lang.Runnable
                public void run() {
                    int i3 = PanoramaImageListener.this.f47280d;
                    if (i3 != 1) {
                        if (i3 != 2) {
                            QZLog.i("PanoramaLayout", 4, "onImageLoaded fail ", " operationType = ", Integer.valueOf(PanoramaImageListener.this.f47280d));
                        } else {
                            PanoramaLayout.this.y(1);
                        }
                    }
                }
            });
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, final Drawable drawable, ImageLoader.Options options) {
            if (drawable != null) {
                QZLog.e("PanoramaLayout", "width = " + drawable.getIntrinsicWidth() + " height = " + drawable.getIntrinsicHeight());
                PanoramaLayout.this.post(new Runnable() { // from class: com.qzone.feed.panorama.PanoramaLayout.PanoramaImageListener.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (PanoramaLayout.this.f47266i == null) {
                            return;
                        }
                        int i3 = PanoramaImageListener.this.f47280d;
                        if (i3 == 1) {
                            PanoramaLayout.this.f47266i.setTextureDrawable(drawable);
                            PanoramaLayout panoramaLayout = PanoramaLayout.this;
                            panoramaLayout.v(panoramaLayout.f47266i);
                        } else if (i3 != 2) {
                            QZLog.i("PanoramaLayout", 4, "onImageLoaded success ", " operationType = ", Integer.valueOf(PanoramaImageListener.this.f47280d));
                        } else {
                            PanoramaLayout.this.f47266i.setTextureDrawable(drawable);
                            PanoramaLayout.this.y(1);
                        }
                    }
                });
            }
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }

    public void O(PanoramaConfig.Builder builder) {
        if (builder == null || TextUtils.isEmpty(builder.getThumbUrl()) || builder.getModeType() == -1) {
            return;
        }
        this.f47266i = builder;
        if (builder.getPanoramaType() != 4) {
            if (this.f47267m == null) {
                AsyncImageView asyncImageView = new AsyncImageView(this.C);
                this.f47267m = asyncImageView;
                asyncImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                this.f47267m.setImageDrawable(j.g(7));
                this.f47267m.setOnClickListener(this.M);
                if (!TextUtils.isEmpty(builder.getSmallUrl()) && (builder.getSmallUrl().startsWith("http") || builder.getSmallUrl().startsWith("https"))) {
                    this.f47267m.setAsyncImage(builder.getSmallUrl());
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                layoutParams.gravity = 17;
                addView(this.f47267m, layoutParams);
            } else if (!TextUtils.isEmpty(builder.getSmallUrl()) && (builder.getSmallUrl().startsWith("http") || builder.getSmallUrl().startsWith("https"))) {
                this.f47267m.setAsyncImage(builder.getSmallUrl());
            }
        }
        if (this.f47264f == null && builder.isShowLoadingProgress() && ((IPanoramaUtil) QRoute.api(IPanoramaUtil.class)).isNeedShowPanorama() && builder.getPanoramaType() != 4) {
            this.f47264f = ((IPanoramaLoadingLayout) QRoute.api(IPanoramaLoadingLayout.class)).getPanoramaLoadingLayout(this.C);
            ((IPanoramaLoadingLayout) QRoute.api(IPanoramaLoadingLayout.class)).showLoading(this.f47264f, false, false);
            this.f47264f.setClickable(false);
            this.f47264f.setEnabled(false);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 17;
            addView(this.f47264f, layoutParams2);
        }
        if (builder.getPanoramaType() != 2) {
            Q();
        }
        String A = A();
        if (A != null) {
            ((IPanoramaUtil) QRoute.api(IPanoramaUtil.class)).reportMta(A, "expose", 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(PanoramaConfig.Builder builder) {
        File file;
        if (builder == null) {
            return;
        }
        if (this.f47262d == null) {
            GLTextureView gLTextureView = (GLTextureView) ((IPanoramaView) QRoute.api(IPanoramaView.class)).getPanoramaView(this.C);
            this.f47262d = gLTextureView;
            gLTextureView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            ((IPanoramaView) QRoute.api(IPanoramaView.class)).startShowPanorama(this.f47262d, builder, this);
            if (builder.isShowPanoramaBall()) {
                builder.setOnRotateListener(this);
            }
            if (this.f47262d != null && this.E != null) {
                ((IPanoramaView) QRoute.api(IPanoramaView.class)).setOnPanoramaClickListener(this.f47262d, this.E);
            }
            addView(this.f47262d);
        }
        AsyncImageView asyncImageView = this.f47267m;
        if (asyncImageView != null) {
            asyncImageView.bringToFront();
        }
        if (this.f47264f != null && builder.isShowLoadingProgress()) {
            this.f47264f.bringToFront();
        }
        K();
        if (builder.isNeedPieceLoad()) {
            if (ImageManager.isNetworkUrl(builder.getThumbUrl())) {
                file = ImageLoader.getInstance().getImageFile(builder.getThumbUrl());
            } else {
                file = new File(builder.getThumbUrl());
            }
            if (file == null || !file.exists()) {
                return;
            }
            QZLog.e("PanoramaLayout", 4, "getAbsoluteFile = " + file.getAbsoluteFile());
            if (this.K == null) {
                this.K = new PanoramaPieceManager(builder, file.getAbsolutePath());
            }
            builder.setPanoramaPieceManager(this.K);
        }
    }

    public PanoramaLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.H = false;
        this.I = new HashMap<>();
        this.J = false;
        this.L = QzoneConfig.getInstance().getConfig("QZoneSetting", "panoramaGuideAnimateTime", 24);
        this.M = new a();
        this.N = new b();
        D(context);
    }
}
