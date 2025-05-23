package com.qzone.reborn.layer.part;

import NS_MOBILE_PHOTO.Photo;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import com.qzone.album.ui.widget.AlbumRecomGalleryPage;
import com.qzone.album.ui.widget.a;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.preview.DynamicPictureAdapter;
import com.qzone.preview.FaceRelativeLayout;
import com.qzone.preview.LocalPictureViewer;
import com.qzone.preview.PictureAdapter;
import com.qzone.preview.QzonePictureSelectViewer;
import com.qzone.preview.business.BasePicureViewController;
import com.qzone.preview.view.PictureViewGallery;
import com.tencent.component.media.gif.NewGifDrawable;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.image.RegionDrawableData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.widget.AdapterView;
import com.tencent.widget.Gallery;
import common.config.service.QzoneConfig;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneFeedxGalleryScene extends com.tencent.common.galleryactivity.c implements PictureViewGallery.c, PictureViewGallery.a, PictureViewGallery.b {
    private com.qzone.preview.b K;
    private PictureAdapter L;
    private BasePicureViewController M;
    private LayerDrawable N;
    private Boolean P;
    private float Q;
    private float R;
    private float S;
    private boolean T;
    private boolean U;
    View V;
    View W;
    View X;
    private AlbumRecomGalleryPage Y;
    private boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f57827a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f57828b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f57829c0;

    /* renamed from: d0, reason: collision with root package name */
    private BasePicureViewController.d f57830d0;

    /* renamed from: e0, reason: collision with root package name */
    private int f57831e0;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements BasePicureViewController.d {
        a() {
        }

        @Override // com.qzone.preview.business.BasePicureViewController.d
        public void a(MotionEvent motionEvent, float f16, boolean z16) {
            if (((com.tencent.common.galleryactivity.c) QZoneFeedxGalleryScene.this).f99861h != null) {
                ((com.tencent.common.galleryactivity.c) QZoneFeedxGalleryScene.this).f99861h.onDoubleTap(motionEvent);
                ((com.tencent.common.galleryactivity.c) QZoneFeedxGalleryScene.this).f99861h.onUpForQzone(f16, z16);
            }
        }

        @Override // com.qzone.preview.business.BasePicureViewController.d
        public void b(float f16) {
            if (((com.tencent.common.galleryactivity.c) QZoneFeedxGalleryScene.this).f99861h != null) {
                ((com.tencent.common.galleryactivity.c) QZoneFeedxGalleryScene.this).f99861h.setMaxScale(f16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int i3;
            if (!QZoneFeedxGalleryScene.this.f57829c0 && QZoneFeedxGalleryScene.this.L != null && ((com.tencent.common.galleryactivity.c) QZoneFeedxGalleryScene.this).f99861h != null && QZoneFeedxGalleryScene.this.L.o(((com.tencent.common.galleryactivity.c) QZoneFeedxGalleryScene.this).f99861h.getSelectedItemPosition())) {
                if (motionEvent.getAction() == 0) {
                    QZoneFeedxGalleryScene.this.Q = motionEvent.getRawX();
                    QZoneFeedxGalleryScene.this.R = motionEvent.getRawY();
                }
                return false;
            }
            if (motionEvent.getAction() == 1) {
                if (QZoneFeedxGalleryScene.this.T) {
                    if (QZoneFeedxGalleryScene.this.c1(motionEvent.getRawY())) {
                        QZoneFeedxGalleryScene.this.X0(motionEvent.getRawY() - QZoneFeedxGalleryScene.this.S);
                        return true;
                    }
                    if (((com.tencent.common.galleryactivity.c) QZoneFeedxGalleryScene.this).f99861h != null) {
                        ((com.tencent.common.galleryactivity.c) QZoneFeedxGalleryScene.this).f99861h.scrollTo(0, 0);
                    }
                    if (!(QZoneFeedxGalleryScene.this.K instanceof QzonePictureSelectViewer) && !(QZoneFeedxGalleryScene.this.K instanceof LocalPictureViewer)) {
                        if ((BasePicureViewController.n0() || BasePicureViewController.g0() || BasePicureViewController.f0()) && QZoneFeedxGalleryScene.this.L != null && ((com.tencent.common.galleryactivity.c) QZoneFeedxGalleryScene.this).f99861h != null && !QZoneFeedxGalleryScene.this.L.o(((com.tencent.common.galleryactivity.c) QZoneFeedxGalleryScene.this).f99861h.getSelectedItemPosition())) {
                            QZoneFeedxGalleryScene.this.K.o5();
                        }
                    } else {
                        View view2 = QZoneFeedxGalleryScene.this.V;
                        if (view2 != null) {
                            view2.setVisibility(0);
                        }
                        View view3 = QZoneFeedxGalleryScene.this.W;
                        if (view3 != null) {
                            view3.setVisibility(0);
                        }
                    }
                    if (QZoneFeedxGalleryScene.this.L == null || ((com.tencent.common.galleryactivity.c) QZoneFeedxGalleryScene.this).f99861h == null || !QZoneFeedxGalleryScene.this.L.o(((com.tencent.common.galleryactivity.c) QZoneFeedxGalleryScene.this).f99861h.getSelectedItemPosition())) {
                        if (((com.tencent.common.galleryactivity.c) QZoneFeedxGalleryScene.this).f99861h != null) {
                            ((com.tencent.common.galleryactivity.c) QZoneFeedxGalleryScene.this).f99861h.setBackgroundColor(-16777216);
                        }
                    } else {
                        View view4 = QZoneFeedxGalleryScene.this.V;
                        if (view4 != null) {
                            view4.setVisibility(0);
                        }
                        View view5 = QZoneFeedxGalleryScene.this.X;
                        if (view5 != null) {
                            view5.setVisibility(0);
                        }
                        if (QZoneFeedxGalleryScene.this.P.booleanValue()) {
                            QZoneFeedxGalleryScene.this.N.setAlpha(255);
                            ((com.tencent.common.galleryactivity.c) QZoneFeedxGalleryScene.this).f99861h.setBackgroundDrawable(QZoneFeedxGalleryScene.this.N);
                        } else {
                            ((com.tencent.common.galleryactivity.c) QZoneFeedxGalleryScene.this).f99861h.setBackgroundColor(-16777216);
                        }
                    }
                    QZoneFeedxGalleryScene.this.T = false;
                    return false;
                }
            } else {
                if (motionEvent.getAction() == 2) {
                    if (motionEvent.getPointerCount() == 1 && !QZoneFeedxGalleryScene.this.T && ((com.tencent.common.galleryactivity.c) QZoneFeedxGalleryScene.this).f99861h != null && !((com.tencent.common.galleryactivity.c) QZoneFeedxGalleryScene.this).f99861h.isZoomed() && QZoneFeedxGalleryScene.this.d1(motionEvent.getRawX(), motionEvent.getRawY())) {
                        QZoneFeedxGalleryScene.this.T = true;
                        QZoneFeedxGalleryScene.this.U = true;
                    }
                    if (!QZoneFeedxGalleryScene.this.T) {
                        return false;
                    }
                    QZoneFeedxGalleryScene qZoneFeedxGalleryScene = QZoneFeedxGalleryScene.this;
                    if (qZoneFeedxGalleryScene.V == null) {
                        qZoneFeedxGalleryScene.V = qZoneFeedxGalleryScene.g().findViewById(R.id.f166518ft1);
                    }
                    View view6 = QZoneFeedxGalleryScene.this.V;
                    if (view6 != null) {
                        view6.setVisibility(4);
                    }
                    QZoneFeedxGalleryScene qZoneFeedxGalleryScene2 = QZoneFeedxGalleryScene.this;
                    if (qZoneFeedxGalleryScene2.W == null) {
                        qZoneFeedxGalleryScene2.W = qZoneFeedxGalleryScene2.g().findViewById(R.id.fth);
                    }
                    View view7 = QZoneFeedxGalleryScene.this.W;
                    if (view7 != null) {
                        view7.setVisibility(4);
                    }
                    QZoneFeedxGalleryScene qZoneFeedxGalleryScene3 = QZoneFeedxGalleryScene.this;
                    if (qZoneFeedxGalleryScene3.X == null) {
                        qZoneFeedxGalleryScene3.X = qZoneFeedxGalleryScene3.g().findViewById(R.id.fte);
                    }
                    View view8 = QZoneFeedxGalleryScene.this.X;
                    if (view8 != null) {
                        view8.setVisibility(8);
                    }
                    float rawY = motionEvent.getRawY();
                    int i16 = (int) (QZoneFeedxGalleryScene.this.R - rawY);
                    QZoneFeedxGalleryScene.this.R = rawY;
                    if (((com.tencent.common.galleryactivity.c) QZoneFeedxGalleryScene.this).f99861h != null) {
                        int scrollY = ((com.tencent.common.galleryactivity.c) QZoneFeedxGalleryScene.this).f99861h.getScrollY();
                        int height = ((com.tencent.common.galleryactivity.c) QZoneFeedxGalleryScene.this).f99861h.getHeight();
                        if (i16 < 0) {
                            int i17 = scrollY + height;
                            if (i17 > 0) {
                                ((com.tencent.common.galleryactivity.c) QZoneFeedxGalleryScene.this).f99861h.scrollBy(0, Math.max(-i17, i16));
                                if (QZoneFeedxGalleryScene.this.L == null || ((com.tencent.common.galleryactivity.c) QZoneFeedxGalleryScene.this).f99861h == null || !QZoneFeedxGalleryScene.this.L.o(((com.tencent.common.galleryactivity.c) QZoneFeedxGalleryScene.this).f99861h.getSelectedItemPosition())) {
                                    Gallery gallery = ((com.tencent.common.galleryactivity.c) QZoneFeedxGalleryScene.this).f99861h;
                                    QZoneFeedxGalleryScene qZoneFeedxGalleryScene4 = QZoneFeedxGalleryScene.this;
                                    gallery.setBackgroundColor(qZoneFeedxGalleryScene4.Z0(Math.abs(rawY - qZoneFeedxGalleryScene4.S), height));
                                } else {
                                    Gallery gallery2 = ((com.tencent.common.galleryactivity.c) QZoneFeedxGalleryScene.this).f99861h;
                                    QZoneFeedxGalleryScene qZoneFeedxGalleryScene5 = QZoneFeedxGalleryScene.this;
                                    com.qzone.reborn.feedx.widget.i.a(gallery2, (int) (qZoneFeedxGalleryScene5.Y0(Math.abs(rawY - qZoneFeedxGalleryScene5.S), height) * 255.0f));
                                }
                            }
                        } else if (i16 > 0 && (i3 = height - scrollY) > 0) {
                            ((com.tencent.common.galleryactivity.c) QZoneFeedxGalleryScene.this).f99861h.scrollBy(0, Math.min(i3, i16));
                            if (QZoneFeedxGalleryScene.this.L == null || ((com.tencent.common.galleryactivity.c) QZoneFeedxGalleryScene.this).f99861h == null || !QZoneFeedxGalleryScene.this.L.o(((com.tencent.common.galleryactivity.c) QZoneFeedxGalleryScene.this).f99861h.getSelectedItemPosition())) {
                                Gallery gallery3 = ((com.tencent.common.galleryactivity.c) QZoneFeedxGalleryScene.this).f99861h;
                                QZoneFeedxGalleryScene qZoneFeedxGalleryScene6 = QZoneFeedxGalleryScene.this;
                                gallery3.setBackgroundColor(qZoneFeedxGalleryScene6.Z0(Math.abs(rawY - qZoneFeedxGalleryScene6.S), height));
                            } else {
                                Gallery gallery4 = ((com.tencent.common.galleryactivity.c) QZoneFeedxGalleryScene.this).f99861h;
                                QZoneFeedxGalleryScene qZoneFeedxGalleryScene7 = QZoneFeedxGalleryScene.this;
                                com.qzone.reborn.feedx.widget.i.a(gallery4, (int) (qZoneFeedxGalleryScene7.Y0(Math.abs(rawY - qZoneFeedxGalleryScene7.S), height) * 255.0f));
                            }
                        }
                        return true;
                    }
                    QZLog.e("QZoneFeedxGalleryScene", 1, "[onTouch] mGallery is null, early return");
                    return true;
                }
                if (motionEvent.getAction() == 0) {
                    QZoneFeedxGalleryScene.this.Q = motionEvent.getRawX();
                    QZoneFeedxGalleryScene.this.R = motionEvent.getRawY();
                    QZoneFeedxGalleryScene qZoneFeedxGalleryScene8 = QZoneFeedxGalleryScene.this;
                    qZoneFeedxGalleryScene8.S = qZoneFeedxGalleryScene8.R;
                    QZoneFeedxGalleryScene.this.T = false;
                }
            }
            return false;
        }
    }

    public QZoneFeedxGalleryScene(Activity activity, com.qzone.preview.b bVar, com.tencent.common.galleryactivity.e eVar) {
        super(activity, eVar);
        this.P = Boolean.FALSE;
        this.T = false;
        this.U = false;
        this.Z = false;
        this.f57827a0 = false;
        this.f57828b0 = false;
        this.f57829c0 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_GALLERY_RECOM_ALBUM_FLING_CLOSE, 0) > 0;
        a aVar = new a();
        this.f57830d0 = aVar;
        this.f57831e0 = 0;
        this.K = bVar;
        BasePicureViewController basePicureViewController = (BasePicureViewController) eVar;
        this.M = basePicureViewController;
        basePicureViewController.T0(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0(float f16) {
        int scrollY;
        if (this.F != null) {
            int height = this.f99861h.getHeight();
            if (this.f99861h.getScrollY() > 0) {
                scrollY = -(height - this.f99861h.getScrollY());
            } else {
                scrollY = this.f99861h.getScrollY() + height;
            }
            float f17 = scrollY;
            long abs = (Math.abs((int) f17) * 500) / height;
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, f17);
            translateAnimation.setDuration(abs);
            translateAnimation.setAnimationListener(new d(this.F));
            translateAnimation.setFillAfter(true);
            float f18 = height;
            AlphaAnimation alphaAnimation = new AlphaAnimation(Y0(Math.abs(f16), f18), 0.0f);
            alphaAnimation.setDuration(abs);
            alphaAnimation.setFillAfter(true);
            View findViewById = g().findViewById(R.id.a4f);
            if (findViewById != null) {
                findViewById.setBackgroundColor(Z0(Math.abs(f16), f18));
                findViewById.startAnimation(alphaAnimation);
            }
            this.f99861h.setBackgroundColor(17170445);
            this.f99861h.startAnimation(translateAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float Y0(float f16, float f17) {
        float f18 = f17 * 0.6f;
        if (f16 < f18) {
            return 0.9f - ((f16 / f18) * 0.39999998f);
        }
        return 0.5f;
    }

    private int a1() {
        BasePicureViewController basePicureViewController = this.M;
        if (basePicureViewController == null) {
            return 0;
        }
        if (basePicureViewController instanceof com.qzone.preview.business.d) {
            return 2;
        }
        return basePicureViewController instanceof com.qzone.preview.business.b ? 1 : 0;
    }

    private void b1(View view) {
        if (this.Z) {
            return;
        }
        this.Z = true;
        try {
            try {
                AlbumRecomGalleryPage albumRecomGalleryPage = this.Y;
                if (albumRecomGalleryPage != null) {
                    albumRecomGalleryPage.f(this.Q, this.R);
                }
            } catch (Exception e16) {
                QZLog.e("QZoneFeedxGalleryScene", "Error Handling Item Click for RecomAlbum", e16);
            }
        } finally {
            this.Z = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c1(float f16) {
        float abs = Math.abs(f16 - this.S);
        if (this.f99861h.getSelectedView() == null) {
            return Math.abs(abs) > ((float) (com.qzone.util.ar.l() / 4));
        }
        float height = this.f99861h.getSelectedView().getHeight();
        return ((double) abs) - (((double) (((float) com.qzone.util.ar.k()) - height)) / 2.0d) > ((double) height) * 0.1d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d1(float f16, float f17) {
        return Math.abs(f16 - this.Q) < Math.abs(f17 - this.R) - 5.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e1(View view) {
        com.qzone.preview.b bVar = this.K;
        if (bVar != null) {
            bVar.k0(view);
            BasePicureViewController basePicureViewController = this.M;
            if (basePicureViewController instanceof com.qzone.preview.business.d) {
                LpReportInfo_pf00064.allReport(301, 22, 2);
            } else if (basePicureViewController instanceof com.qzone.preview.business.b) {
                LpReportInfo_pf00064.allReport(301, 22, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f1(View view) {
        BasePicureViewController basePicureViewController = this.M;
        if (basePicureViewController != null) {
            basePicureViewController.s0(this.F);
            BasePicureViewController basePicureViewController2 = this.M;
            if (basePicureViewController2 instanceof com.qzone.preview.business.d) {
                LpReportInfo_pf00064.allReport(301, 23, 2);
            } else if (basePicureViewController2 instanceof com.qzone.preview.business.b) {
                LpReportInfo_pf00064.allReport(301, 23, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g1() {
        this.M.Q(this.K.n7());
    }

    private void h1(int i3) {
        PhotoInfo item;
        if (i3 >= this.M.getCount() || i3 < 0 || (item = this.M.getItem(i3)) == null || TextUtils.isEmpty(item.bigUrl) || item.hasLoaded) {
            return;
        }
        if (QZLog.isDevelopLevel()) {
            QZLog.d("[PhotoAlbum]BasePictureViewer", 4, "QzoneGalleryScene--preload image postion:" + i3);
        }
        ImageLoader.Options obtain = ImageLoader.Options.obtain();
        obtain.justCover = false;
        obtain.needShowGifAnimation = true;
        obtain.needCallBackProcessPercent = true;
        obtain.imageConfig = Bitmap.Config.ARGB_8888;
        obtain.type = AppConstants.HTTP_TYPE_QZONE_DOWNLOAD_BIG_PIC;
        Drawable loadImage = ImageLoader.getInstance().loadImage(item.bigUrl, new c(item), obtain);
        PhotoInfo F = this.M.F();
        if (F == null || item.bigUrl.equals(F.currentUrl) || item.bigUrl.equals(F.bigUrl) || !(loadImage instanceof NewGifDrawable)) {
            return;
        }
        loadImage.setVisible(false, true);
        QZLog.d("QzoneGalleryScene", 4, "preload success:stop invisible gif animation");
    }

    private void i1(View view) {
        int config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_KEY_ALBUM_GALLERY_BG_SWITCH, 20);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < config) {
            QZLog.i("QZoneFeedxGalleryScene", 2, "[onAlbumRecomPageSelected] current sdk ", Integer.valueOf(i3), " less than lessSdkVersion ", Integer.valueOf(config));
        } else {
            LayerDrawable layerDrawable = this.N;
            if (layerDrawable != null) {
                Gallery gallery = this.f99861h;
                if (gallery != null) {
                    gallery.setBackgroundDrawable(layerDrawable);
                }
            } else {
                Photo photo = this.M.f49875e;
                if (photo != null) {
                    String str = photo.bigurl;
                    ImageLoader.Options obtain = ImageLoader.Options.obtain();
                    obtain.useMainThread = false;
                    uo.a aVar = new uo.a(50);
                    aVar.setPreProcessor(new com.qzone.preview.view.a(com.qzone.util.ar.l(), com.qzone.util.ar.k()));
                    obtain.extraProcessor = aVar;
                    QZLog.i("QZoneFeedxGalleryScene", "onAlbumRecomPageSelected, try to load bg URL=" + str);
                    ImageLoader.getInstance().loadImageAsync(str, new ImageLoader.ImageLoadListener() { // from class: com.qzone.reborn.layer.part.QZoneFeedxGalleryScene.3
                        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                        public void onImageFailed(String str2, ImageLoader.Options options) {
                            QZLog.e("QZoneFeedxGalleryScene", "\u80cc\u666f\u56fe\u7247\u52a0\u8f7d\u5931\u8d25,URL=" + str2);
                        }

                        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                        public void onImageLoaded(String str2, Drawable drawable, ImageLoader.Options options) {
                            if (drawable == null || ((com.tencent.common.galleryactivity.c) QZoneFeedxGalleryScene.this).f99861h == null) {
                                return;
                            }
                            QZoneFeedxGalleryScene.this.P = Boolean.TRUE;
                            QZoneFeedxGalleryScene.this.N = new LayerDrawable(new Drawable[]{drawable, ((com.tencent.common.galleryactivity.c) QZoneFeedxGalleryScene.this).F.getResources().getDrawable(R.drawable.avy)});
                            ((com.tencent.common.galleryactivity.c) QZoneFeedxGalleryScene.this).F.runOnUiThread(new Runnable() { // from class: com.qzone.reborn.layer.part.QZoneFeedxGalleryScene.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (QZoneFeedxGalleryScene.this.Y == null) {
                                        ((com.tencent.common.galleryactivity.c) QZoneFeedxGalleryScene.this).f99861h.setBackgroundColor(-16777216);
                                    } else {
                                        ((com.tencent.common.galleryactivity.c) QZoneFeedxGalleryScene.this).f99861h.setBackgroundDrawable(QZoneFeedxGalleryScene.this.N);
                                    }
                                }
                            });
                        }

                        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                        public void onImageCanceled(String str2, ImageLoader.Options options) {
                        }

                        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                        public void onImageProgress(String str2, float f16, ImageLoader.Options options) {
                        }
                    }, obtain);
                }
            }
        }
        this.f57828b0 = true;
        Gallery gallery2 = this.f99861h;
        if (gallery2 != null) {
            gallery2.enableDoubleTap(false);
            this.f99861h.enableScaleGesture(false);
        }
        com.qzone.preview.b bVar = this.K;
        if (bVar != null) {
            bVar.S0(false);
        }
        Object tag = view != null ? view.getTag(R.layout.bio) : null;
        if ((tag instanceof String) && tag.equals("AlbumRecomView")) {
            this.Y = ((DynamicPictureAdapter.c) view.getTag()).f49532a;
        }
        if (this.L != null) {
            BasePicureViewController basePicureViewController = this.M;
            if (basePicureViewController instanceof com.qzone.preview.business.d) {
                LpReportInfo_pf00064.allReport(301, 21, 2);
            } else if (basePicureViewController instanceof com.qzone.preview.business.b) {
                LpReportInfo_pf00064.allReport(301, 21, 1);
            }
        }
        if (this.V == null) {
            this.V = g().findViewById(R.id.f166518ft1);
        }
        View view2 = this.V;
        if (view2 == null || view2.getVisibility() == 0) {
            return;
        }
        this.V.setVisibility(0);
    }

    private void j1(int i3) {
        int j06 = this.K.j0();
        if (j06 == 0) {
            h1(i3 - 1);
            h1(i3 + 1);
        } else if (j06 == 1) {
            h1(i3 + 1);
        } else {
            if (j06 != 2) {
                return;
            }
            h1(i3 - 1);
        }
    }

    private void k1() {
        if (this.f57828b0) {
            Gallery gallery = this.f99861h;
            if (gallery != null) {
                gallery.enableDoubleTap(true);
                this.f99861h.enableScaleGesture(true);
            }
            com.qzone.preview.b bVar = this.K;
            if (bVar != null) {
                bVar.y1();
            }
            this.f57828b0 = false;
        }
    }

    private void m1(int i3) {
        PhotoInfo item;
        int i16;
        PhotoInfo item2;
        if (i3 > 0 && (item2 = this.M.getItem(i3 - 1)) != null) {
            Drawable imageDrawable = item2.getImageDrawable();
            if (imageDrawable instanceof NewGifDrawable) {
                imageDrawable.setVisible(false, true);
                QZLog.d("QzoneGalleryScene", 4, "after selected:stop invisible gif animation-pos" + i16);
            }
        }
        int i17 = i3 + 1;
        if (i17 >= this.M.getCount() || (item = this.M.getItem(i17)) == null) {
            return;
        }
        Drawable imageDrawable2 = item.getImageDrawable();
        if (imageDrawable2 instanceof NewGifDrawable) {
            imageDrawable2.setVisible(false, true);
            QZLog.d("QzoneGalleryScene", 4, "after selected:stop invisible gif animation-pos" + i17);
        }
    }

    @Override // com.tencent.common.galleryactivity.c
    protected boolean A() {
        return false;
    }

    @Override // com.tencent.common.galleryactivity.c
    protected boolean B() {
        return true;
    }

    @Override // com.tencent.common.galleryactivity.c
    public boolean C() {
        return this.M.Y0();
    }

    @Override // com.tencent.common.galleryactivity.c
    public void D() {
        if (this.K.h9()) {
            this.F.finish();
        } else {
            super.D();
        }
    }

    @Override // com.tencent.common.galleryactivity.c
    public void E(ViewGroup viewGroup) {
        super.E(viewGroup);
        Gallery gallery = this.f99861h;
        if (gallery != null) {
            if (gallery instanceof PictureViewGallery) {
                ((PictureViewGallery) gallery).setOnPageClickLinstener(this);
                ((PictureViewGallery) this.f99861h).setOnShowAreaChangedListener(this);
                ((PictureViewGallery) this.f99861h).setOnZoomBegingListener(this);
            }
            this.f99861h.setClearByTag(true);
            this.f99861h.isQzoneDefaultScale(this.f57827a0);
            this.f99861h.setInterceptTouchEventReturn(false);
            this.f99861h.setOnTouchListener(new b());
        }
    }

    @Override // com.tencent.common.galleryactivity.m
    public void h() {
        BasePicureViewController basePicureViewController = this.M;
        if (basePicureViewController == null || this.L == null) {
            return;
        }
        this.f99861h.setSelection(basePicureViewController.getSelectedIndex());
        com.qzone.preview.b bVar = this.K;
        if (bVar != null) {
            bVar.updateUI();
        }
        if (this.M.R() != null && this.M.R().canBeShown() && this.K != null) {
            this.L.t(this.M.R(), this.F, this.M.R().hasMore);
        }
        this.L.notifyDataSetChanged();
        if (this.M.f49885o == 0 && this.E != null && C()) {
            this.E.c(this.f99861h, this.M.getSelectedIndex());
        }
        m1(this.M.getSelectedIndex());
    }

    @Override // com.tencent.common.galleryactivity.m
    public void j(Configuration configuration) {
        super.j(configuration);
        PictureAdapter pictureAdapter = this.L;
        if (pictureAdapter != null) {
            pictureAdapter.g0();
        }
    }

    @Override // com.tencent.common.galleryactivity.m
    public void k() {
        super.k();
        View selectedView = this.f99861h.getSelectedView();
        if (selectedView == null || !(selectedView instanceof FaceRelativeLayout)) {
            return;
        }
        ((FaceRelativeLayout) selectedView).g();
    }

    public void l1(boolean z16) {
        this.f57827a0 = z16;
    }

    @Override // com.tencent.common.galleryactivity.c, com.tencent.common.galleryactivity.m
    public void m() {
        super.m();
        AlbumRecomGalleryPage albumRecomGalleryPage = this.Y;
        if (albumRecomGalleryPage != null) {
            albumRecomGalleryPage.d();
        }
    }

    @Override // com.tencent.common.galleryactivity.m
    public void n() {
        super.n();
        AlbumRecomGalleryPage albumRecomGalleryPage = this.Y;
        if (albumRecomGalleryPage != null) {
            albumRecomGalleryPage.e();
        }
    }

    @Override // com.tencent.common.galleryactivity.c, com.tencent.common.galleryactivity.h
    public void onEnterAnimationEnd() {
        super.onEnterAnimationEnd();
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.qzone.reborn.layer.part.r
            @Override // java.lang.Runnable
            public final void run() {
                QZoneFeedxGalleryScene.this.g1();
            }
        });
    }

    @Override // com.tencent.common.galleryactivity.c, com.tencent.common.galleryactivity.h
    public void onExitAnimationStart() {
        super.onExitAnimationStart();
        View findViewById = g().findViewById(R.id.f166518ft1);
        if (findViewById != null) {
            findViewById.setVisibility(4);
        }
        View findViewById2 = g().findViewById(R.id.f166517ft0);
        if (findViewById2 != null) {
            findViewById2.setVisibility(4);
        }
    }

    @Override // com.tencent.common.galleryactivity.c, com.tencent.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        String str;
        if (BasePicureViewController.a0()) {
            str = ProfileCardTemplate.PROFILE_COMMON_VERSION;
        } else {
            str = "582";
        }
        ClickReport.m(str, "6", "");
        PictureAdapter pictureAdapter = this.L;
        if (pictureAdapter == null || !pictureAdapter.o(i3)) {
            if (!BasePicureViewController.n0() && !BasePicureViewController.g0()) {
                if (BasePicureViewController.f0() && this.K.z0()) {
                    this.K.U7();
                    this.K.o5();
                    return;
                } else {
                    super.onItemClick(adapterView, view, i3, j3);
                    return;
                }
            }
            this.K.o5();
            if (this.K.z0()) {
                this.K.U7();
            }
        }
    }

    @Override // com.tencent.common.galleryactivity.c, com.tencent.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        PictureAdapter pictureAdapter = this.L;
        if (pictureAdapter != null && pictureAdapter.o(i3)) {
            return false;
        }
        if (!this.U) {
            this.K.w1();
            return true;
        }
        this.U = false;
        return false;
    }

    @Override // com.tencent.common.galleryactivity.c, com.tencent.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i3, long j3) {
        PictureAdapter pictureAdapter = this.L;
        if (pictureAdapter != null && pictureAdapter.o(i3)) {
            if (QZLog.isColorLevel()) {
                QZLog.i("QZoneFeedxGalleryScene", "onItemSelected to Recom Albun Page");
            }
            i1(view);
            return;
        }
        this.Y = null;
        this.f99861h.setBackgroundColor(-16777216);
        super.onItemSelected(adapterView, view, i3, j3);
        k1();
        PictureAdapter pictureAdapter2 = this.L;
        if (pictureAdapter2 != null) {
            pictureAdapter2.i0(view, i3);
        }
        if (!(this.K instanceof LocalPictureViewer)) {
            j1(i3);
        }
        this.K.updateUI();
        m1(i3);
        PictureAdapter pictureAdapter3 = this.L;
        if (pictureAdapter3 == null || i3 != pictureAdapter3.l() - 1) {
            return;
        }
        BasePicureViewController basePicureViewController = this.M;
        if (basePicureViewController instanceof com.qzone.preview.business.d) {
            LpReportInfo_pf00064.allReport(301, 20, 2);
        } else if (basePicureViewController instanceof com.qzone.preview.business.b) {
            LpReportInfo_pf00064.allReport(301, 20, 1);
        }
    }

    @Override // com.tencent.common.galleryactivity.c, com.tencent.widget.Gallery.OnScollListener
    public void onScrollEnd(int i3) {
        String str;
        super.onScrollEnd(i3);
        if (i3 != this.f57831e0) {
            if (BasePicureViewController.a0()) {
                str = ProfileCardTemplate.PROFILE_COMMON_VERSION;
            } else {
                str = "582";
            }
            ClickReport.m(str, "5", "");
            if (QZLog.isDevelopLevel()) {
                QZLog.d("QzoneGalleryScene", 4, "report scroll.");
            }
            this.f57831e0 = i3;
        }
    }

    @Override // com.tencent.common.galleryactivity.c, com.tencent.widget.Gallery.OnScollListener
    public void onScrollStart(int i3) {
        super.onScrollStart(i3);
        com.qzone.preview.b bVar = this.K;
        if (bVar == null || !bVar.z0()) {
            return;
        }
        this.K.U7();
        this.K.o5();
    }

    @Override // com.qzone.preview.view.PictureViewGallery.a
    public void onShowAreaChanged(int i3, View view, RegionDrawableData regionDrawableData) {
        PictureAdapter pictureAdapter = this.L;
        if (pictureAdapter != null) {
            pictureAdapter.j0(i3, view, W0(regionDrawableData));
        }
    }

    @Override // com.tencent.common.galleryactivity.c
    protected com.tencent.common.galleryactivity.d q(Context context) {
        PictureAdapter pictureAdapter = new PictureAdapter(this.K, this.M, this.f99861h);
        this.L = pictureAdapter;
        pictureAdapter.l0(this.f57827a0);
        this.L.u(a1());
        this.L.r(new a.c() { // from class: com.qzone.reborn.layer.part.p
            @Override // com.qzone.album.ui.widget.a.c
            public final void onClicked(View view) {
                QZoneFeedxGalleryScene.this.e1(view);
            }
        });
        this.L.s(new AlbumRecomGalleryPage.b() { // from class: com.qzone.reborn.layer.part.q
            @Override // com.qzone.album.ui.widget.AlbumRecomGalleryPage.b
            public final void onClicked(View view) {
                QZoneFeedxGalleryScene.this.f1(view);
            }
        });
        return this.L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.common.galleryactivity.c
    public com.tencent.common.galleryactivity.b r(Context context) {
        if (BasePicureViewController.n0() || BasePicureViewController.f0() || BasePicureViewController.g0() || BasePicureViewController.i0()) {
            return null;
        }
        return super.r(context);
    }

    @Override // com.tencent.common.galleryactivity.c
    protected RelativeLayout s() {
        return (RelativeLayout) LayoutInflater.from(this.F).inflate(R.layout.f169029bp2, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.common.galleryactivity.c
    public com.tencent.common.galleryactivity.g t() {
        if (BasePicureViewController.w0()) {
            return super.t();
        }
        return null;
    }

    @Override // com.tencent.common.galleryactivity.c
    public void y() {
        this.H = (int) this.F.getResources().getDimension(R.dimen.f159528ar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Z0(float f16, float f17) {
        return ((int) (Y0(f16, f17) * 255.0f)) << 24;
    }

    @Override // com.qzone.preview.view.PictureViewGallery.c
    public void c(MotionEvent motionEvent) {
        View selectedView;
        if (motionEvent == null || this.Y == null || (selectedView = this.f99861h.getSelectedView()) == null) {
            return;
        }
        Object tag = selectedView.getTag(R.layout.bio);
        if ((tag instanceof String) && tag.equals("AlbumRecomView")) {
            this.Y = ((DynamicPictureAdapter.c) selectedView.getTag()).f49532a;
        }
        b1(null);
    }

    private com.tencent.component.media.image.region.RegionDrawableData W0(RegionDrawableData regionDrawableData) {
        if (regionDrawableData == null) {
            return null;
        }
        com.tencent.component.media.image.region.RegionDrawableData regionDrawableData2 = new com.tencent.component.media.image.region.RegionDrawableData();
        regionDrawableData2.mShowRegion = regionDrawableData.mShowRegion;
        regionDrawableData2.mImageArea = regionDrawableData.mImageArea;
        regionDrawableData2.mDefaultScale = regionDrawableData.mDefaultScale;
        regionDrawableData2.mShowArea = regionDrawableData.mShowArea;
        regionDrawableData2.mScale = regionDrawableData.mScale;
        regionDrawableData2.mScrollDirection = regionDrawableData.mScrollDirection;
        regionDrawableData2.mState = regionDrawableData.mState;
        return regionDrawableData2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class c implements ImageLoader.ImageLoadListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ PhotoInfo f57836d;

        c(PhotoInfo photoInfo) {
            this.f57836d = photoInfo;
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            PhotoInfo photoInfo = this.f57836d;
            photoInfo.hasLoaded = true;
            photoInfo.progress = 100;
            PhotoInfo F = QZoneFeedxGalleryScene.this.M.F();
            if (F == null || str.equals(F.currentUrl) || str.equals(F.bigUrl) || !(drawable instanceof NewGifDrawable)) {
                return;
            }
            drawable.setVisible(false, true);
            QZLog.d("QzoneGalleryScene", 4, "preload success:stop invisible gif animation");
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
            int i3 = (int) (f16 * 100.0f);
            if (i3 > 99) {
                i3 = 99;
            }
            PhotoInfo photoInfo = this.f57836d;
            photoInfo.progress = i3;
            photoInfo.hasPreDownload = true;
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static final class d implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<Activity> f57838d;

        public d(Activity activity) {
            this.f57838d = new WeakReference<>(activity);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Activity activity = this.f57838d.get();
            if (activity != null) {
                activity.finish();
                activity.overridePendingTransition(0, 0);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    @Override // com.qzone.preview.view.PictureViewGallery.b
    public void a(int i3, View view, ViewGroup viewGroup) {
    }
}
