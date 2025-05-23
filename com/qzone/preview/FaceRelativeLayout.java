package com.qzone.preview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.qzone.feed.panorama.PanoramaLayout;
import com.qzone.preview.business.BasePicureViewController;
import com.qzone.preview.view.PictureImageView;
import com.qzone.proxy.feedcomponent.util.j;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager;
import com.tencent.mobileqq.qzoneplayer.video.MediaControllerListener;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.panorama.IPanoramaLoadingLayout;
import com.tencent.qzonehub.api.panorama.IPanoramaUtil;
import cooperation.qzone.IPictureViewHack;
import cooperation.qzone.panorama.callback.OnPanoramaClickListener;
import cooperation.qzone.panorama.callback.OnPanoramaLoadingListener;
import cooperation.qzone.panorama.util.PanoramaConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FaceRelativeLayout extends RelativeLayout implements IPictureViewHack {
    public RelativeLayout C;
    private SeekBar.OnSeekBarChangeListener D;

    /* renamed from: d, reason: collision with root package name */
    public PictureImageView f49533d;

    /* renamed from: e, reason: collision with root package name */
    public PictureImageView f49534e;

    /* renamed from: f, reason: collision with root package name */
    public ImageView f49535f;

    /* renamed from: h, reason: collision with root package name */
    public QzoneAlbumVideoView f49536h;

    /* renamed from: i, reason: collision with root package name */
    public ImageView f49537i;

    /* renamed from: m, reason: collision with root package name */
    public TextView f49538m;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FaceRelativeLayout.this.f49536h.o().g();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: d, reason: collision with root package name */
        private boolean f49551d = false;

        b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
            if (this.f49551d) {
                j.f("seekBar", "seekBar progress = " + seekBar.getSecondaryProgress() + " main = " + seekBar.getProgress());
                this.f49551d = false;
            }
            EventCollector.getInstance().onStopTrackingTouch(seekBar);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            this.f49551d = true;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i3, boolean z16) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f49553d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f49554e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f49555f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f49556h;

        c(Context context, String str, int i3, boolean z16) {
            this.f49553d = context;
            this.f49554e = str;
            this.f49555f = i3;
            this.f49556h = z16;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(301, 27, 1));
            ((IPanoramaUtil) QRoute.api(IPanoramaUtil.class)).reportMta("qzone_gallery_panorama", "click", 0);
            FaceRelativeLayout.this.f(this.f49553d, this.f49554e, this.f49555f, true, this.f49556h);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class d implements OnPanoramaClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f49558a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f49559b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ PanoramaLayout f49560c;

        d(boolean z16, Context context, PanoramaLayout panoramaLayout) {
            this.f49558a = z16;
            this.f49559b = context;
            this.f49560c = panoramaLayout;
        }

        @Override // cooperation.qzone.panorama.callback.OnPanoramaClickListener
        public void onPanoramaClick() {
            if (this.f49558a) {
                Context context = this.f49559b;
                if (context instanceof Activity) {
                    ((Activity) context).finish();
                }
            } else {
                ((BasePictureViewer) this.f49559b).E4();
            }
            PanoramaLayout panoramaLayout = this.f49560c;
            if (panoramaLayout != null) {
                panoramaLayout.J();
            }
        }
    }

    public FaceRelativeLayout(Context context) {
        super(context);
        this.f49533d = null;
        this.f49534e = null;
        this.f49535f = null;
        this.f49536h = null;
        this.f49537i = null;
        this.f49538m = null;
        this.C = null;
        this.D = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Context context, String str, int i3, boolean z16, boolean z17) {
        this.C.setClickable(false);
        ((IPanoramaLoadingLayout) QRoute.api(IPanoramaLoadingLayout.class)).startRotateAnimate(this.C);
        e(context, str, i3, z16, z17);
    }

    public void c(boolean z16) {
        if (this.f49533d == null) {
            PictureImageView pictureImageView = (PictureImageView) findViewById(R.id.f163822e);
            this.f49533d = pictureImageView;
            pictureImageView.setOptImageScale(z16);
        }
        if (this.f49534e == null) {
            this.f49534e = (PictureImageView) findViewById(R.id.f163823f);
        }
        if (this.f49535f == null) {
            this.f49535f = (ImageView) findViewById(R.id.cuq);
        }
        if (this.C == null) {
            this.C = (RelativeLayout) findViewById(R.id.dfp);
        }
        if (this.f49536h == null) {
            QzoneAlbumVideoView qzoneAlbumVideoView = new QzoneAlbumVideoView(getContext());
            this.f49536h = qzoneAlbumVideoView;
            qzoneAlbumVideoView.setClickable(false);
            this.f49536h.setLongClickable(false);
            addView(this.f49536h);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f49536h.getLayoutParams();
            layoutParams.addRule(14);
            layoutParams.addRule(15);
            this.f49536h.setLayoutParams(layoutParams);
            this.f49536h.setSeekBarChangeListener(this.D);
            this.f49536h.m(new a());
            this.f49536h.setMediaControllerListener(new MediaControllerListener() { // from class: com.qzone.preview.FaceRelativeLayout.2
                @Override // com.tencent.mobileqq.qzoneplayer.video.MediaControllerListener
                public void onUpdatePlayPauseButton() {
                    final ImageButton D = ((QzoneAlbumVideoControlView) FaceRelativeLayout.this.f49536h.o()).D();
                    if (FaceRelativeLayout.this.f49536h.n()) {
                        PlayerUtils.runOnUiThread(new Runnable() { // from class: com.qzone.preview.FaceRelativeLayout.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                D.setImageResource(R.drawable.f162191fx2);
                            }
                        });
                    } else {
                        PlayerUtils.runOnUiThread(new Runnable() { // from class: com.qzone.preview.FaceRelativeLayout.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                D.setImageResource(R.drawable.f162190fx1);
                            }
                        });
                    }
                }
            });
        }
        if (this.f49537i == null) {
            ImageView imageView = new ImageView(getContext());
            this.f49537i = imageView;
            imageView.setImageResource(R.drawable.ghn);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(13);
            addView(this.f49537i, layoutParams2);
        }
    }

    public void e(final Context context, String str, int i3, final boolean z16, boolean z17) {
        if (context instanceof BasePictureViewer) {
            ((IPanoramaLoadingLayout) QRoute.api(IPanoramaLoadingLayout.class)).setPanoramaLoading(true);
            final PanoramaLayout panoramaLayout = new PanoramaLayout(context);
            PanoramaConfig.Builder panoramaType = new PanoramaConfig.Builder(i3).setShowType(0).setRenderMode(0).setOpenGyroscopeSensor(true).setOpenTouchMove(true).setShowLoadingProgress(true).setShowGuideAnimate(true).setShowPanoramaBall(true).setThumbUrl(str).setPanoramaType(4);
            panoramaLayout.setOnPanoramaListener(new d(z17, context, panoramaLayout));
            final long currentTimeMillis = System.currentTimeMillis();
            panoramaLayout.P(panoramaType, new OnPanoramaLoadingListener() { // from class: com.qzone.preview.FaceRelativeLayout.6
                @Override // cooperation.qzone.panorama.callback.OnPanoramaLoadingListener
                public void onPanoramaLoad() {
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (z16 || currentTimeMillis2 > 300) {
                        FaceRelativeLayout.this.h(context, panoramaLayout);
                    } else if (currentTimeMillis2 <= 300) {
                        FaceRelativeLayout.this.postDelayed(new Runnable() { // from class: com.qzone.preview.FaceRelativeLayout.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                                FaceRelativeLayout.this.h(context, panoramaLayout);
                            }
                        }, 300 - currentTimeMillis2);
                    }
                }
            });
            ((BasePictureViewer) context).t3(panoramaLayout);
        }
    }

    public void g() {
        PictureImageView pictureImageView = this.f49533d;
        if (pictureImageView != null) {
            pictureImageView.n();
        }
    }

    @Override // cooperation.qzone.IPictureViewHack
    public boolean processGallerySingleTap(MotionEvent motionEvent, Matrix matrix) {
        PictureImageView pictureImageView = this.f49533d;
        if (pictureImageView != null) {
            return pictureImageView.processGallerySingleTap(motionEvent, matrix);
        }
        return false;
    }

    public void setController(BasePicureViewController basePicureViewController) {
        PictureImageView pictureImageView = this.f49533d;
        if (pictureImageView != null) {
            pictureImageView.setController(basePicureViewController);
        }
        PictureImageView pictureImageView2 = this.f49534e;
        if (pictureImageView2 != null) {
            pictureImageView2.setController(basePicureViewController);
        }
    }

    public void setPictureViewer(com.qzone.preview.b bVar) {
        PictureImageView pictureImageView = this.f49533d;
        if (pictureImageView != null) {
            pictureImageView.setPictureViewer(bVar);
        }
    }

    @Override // android.view.View
    public void setScaleX(float f16) {
        RelativeLayout relativeLayout;
        TextView textView;
        ImageView imageView;
        ImageView imageView2;
        super.setScaleX(f16);
        if (f16 != 0.0f && (imageView2 = this.f49535f) != null && imageView2.getVisibility() == 0) {
            this.f49535f.setScaleX(1.0f / f16);
        }
        if (f16 != 0.0f && (imageView = this.f49537i) != null && imageView.getVisibility() == 0) {
            this.f49537i.setScaleX(1.0f / f16);
        }
        if (f16 != 0.0f && (textView = this.f49538m) != null) {
            textView.getVisibility();
        }
        if (f16 == 0.0f || (relativeLayout = this.C) == null || relativeLayout.getVisibility() != 0) {
            return;
        }
        this.C.setScaleX(1.0f / f16);
    }

    @Override // android.view.View
    public void setScaleY(float f16) {
        RelativeLayout relativeLayout;
        TextView textView;
        ImageView imageView;
        ImageView imageView2;
        super.setScaleY(f16);
        this.f49533d.setScale(f16);
        if (f16 != 0.0f && (imageView2 = this.f49535f) != null && imageView2.getVisibility() == 0) {
            this.f49535f.setScaleY(1.0f / f16);
        }
        if (f16 != 0.0f && (imageView = this.f49537i) != null && imageView.getVisibility() == 0) {
            this.f49537i.setScaleY(1.0f / f16);
        }
        if (f16 != 0.0f && (textView = this.f49538m) != null) {
            textView.getVisibility();
        }
        if (f16 == 0.0f || (relativeLayout = this.C) == null || relativeLayout.getVisibility() != 0) {
            return;
        }
        this.C.setScaleY(1.0f / f16);
    }

    public void setVideoManager(BaseVideoManager baseVideoManager) {
        QzoneAlbumVideoView qzoneAlbumVideoView = this.f49536h;
        if (qzoneAlbumVideoView != null) {
            qzoneAlbumVideoView.setVideoManager(baseVideoManager);
        }
    }

    public void d(Context context, String str, int i3, boolean z16, boolean z17) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        ((IPanoramaUtil) QRoute.api(IPanoramaUtil.class)).reportMta("qzone_gallery_panorama", "expose", 0);
        this.C.setOnClickListener(new c(context, str, i3, z17));
        if (z16) {
            f(context, str, i3, false, z17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Context context, View view) {
        if (context == null || view == null || this.C == null) {
            return;
        }
        ((IPanoramaLoadingLayout) QRoute.api(IPanoramaLoadingLayout.class)).setPanoramaLoading(false);
        view.bringToFront();
        this.C.setClickable(true);
        ((IPanoramaLoadingLayout) QRoute.api(IPanoramaLoadingLayout.class)).stopRotateAnimate(this.C);
        view.startAnimation(AnimationUtils.loadAnimation(context, R.anim.f155022gz));
    }

    public FaceRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f49533d = null;
        this.f49534e = null;
        this.f49535f = null;
        this.f49536h = null;
        this.f49537i = null;
        this.f49538m = null;
        this.C = null;
        this.D = new b();
    }

    public FaceRelativeLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f49533d = null;
        this.f49534e = null;
        this.f49535f = null;
        this.f49536h = null;
        this.f49537i = null;
        this.f49538m = null;
        this.C = null;
        this.D = new b();
    }
}
