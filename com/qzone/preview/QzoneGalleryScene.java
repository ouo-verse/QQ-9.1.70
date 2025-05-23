package com.qzone.preview;

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
import com.qzone.preview.business.BasePicureViewController;
import com.qzone.preview.view.PictureViewGallery;
import com.qzone.util.ar;
import com.tencent.common.galleryactivity.g;
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
/* loaded from: classes39.dex */
public class QzoneGalleryScene extends com.tencent.common.galleryactivity.c implements PictureViewGallery.c, PictureViewGallery.a, PictureViewGallery.b {
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
    private boolean f49685a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f49686b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f49687c0;

    /* renamed from: d0, reason: collision with root package name */
    private BasePicureViewController.d f49688d0;

    /* renamed from: e0, reason: collision with root package name */
    private final float f49689e0;

    /* renamed from: f0, reason: collision with root package name */
    private final float f49690f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f49691g0;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements BasePicureViewController.d {
        a() {
        }

        @Override // com.qzone.preview.business.BasePicureViewController.d
        public void a(MotionEvent motionEvent, float f16, boolean z16) {
            if (((com.tencent.common.galleryactivity.c) QzoneGalleryScene.this).f99861h != null) {
                ((com.tencent.common.galleryactivity.c) QzoneGalleryScene.this).f99861h.onDoubleTap(motionEvent);
                ((com.tencent.common.galleryactivity.c) QzoneGalleryScene.this).f99861h.onUpForQzone(f16, z16);
            }
        }

        @Override // com.qzone.preview.business.BasePicureViewController.d
        public void b(float f16) {
            if (((com.tencent.common.galleryactivity.c) QzoneGalleryScene.this).f99861h != null) {
                ((com.tencent.common.galleryactivity.c) QzoneGalleryScene.this).f99861h.setMaxScale(f16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int i3;
            if (!QzoneGalleryScene.this.f49687c0 && QzoneGalleryScene.this.L != null && ((com.tencent.common.galleryactivity.c) QzoneGalleryScene.this).f99861h != null && QzoneGalleryScene.this.L.o(((com.tencent.common.galleryactivity.c) QzoneGalleryScene.this).f99861h.getSelectedItemPosition())) {
                if (motionEvent.getAction() == 0) {
                    QzoneGalleryScene.this.Q = motionEvent.getRawX();
                    QzoneGalleryScene.this.R = motionEvent.getRawY();
                }
                return false;
            }
            if (motionEvent.getAction() == 1) {
                if (QzoneGalleryScene.this.T) {
                    if (QzoneGalleryScene.this.a1(motionEvent.getRawY())) {
                        QzoneGalleryScene.this.V0(motionEvent.getRawY() - QzoneGalleryScene.this.S);
                        return true;
                    }
                    if (((com.tencent.common.galleryactivity.c) QzoneGalleryScene.this).f99861h != null) {
                        ((com.tencent.common.galleryactivity.c) QzoneGalleryScene.this).f99861h.scrollTo(0, 0);
                    }
                    if (!(QzoneGalleryScene.this.K instanceof QzonePictureSelectViewer) && !(QzoneGalleryScene.this.K instanceof LocalPictureViewer)) {
                        if ((BasePicureViewController.n0() || BasePicureViewController.g0() || BasePicureViewController.f0()) && QzoneGalleryScene.this.L != null && ((com.tencent.common.galleryactivity.c) QzoneGalleryScene.this).f99861h != null && !QzoneGalleryScene.this.L.o(((com.tencent.common.galleryactivity.c) QzoneGalleryScene.this).f99861h.getSelectedItemPosition())) {
                            QzoneGalleryScene.this.K.o5();
                        }
                    } else {
                        View view2 = QzoneGalleryScene.this.V;
                        if (view2 != null) {
                            view2.setVisibility(0);
                        }
                        View view3 = QzoneGalleryScene.this.W;
                        if (view3 != null) {
                            view3.setVisibility(0);
                        }
                    }
                    if (QzoneGalleryScene.this.L == null || ((com.tencent.common.galleryactivity.c) QzoneGalleryScene.this).f99861h == null || !QzoneGalleryScene.this.L.o(((com.tencent.common.galleryactivity.c) QzoneGalleryScene.this).f99861h.getSelectedItemPosition())) {
                        if (((com.tencent.common.galleryactivity.c) QzoneGalleryScene.this).f99861h != null) {
                            ((com.tencent.common.galleryactivity.c) QzoneGalleryScene.this).f99861h.setBackgroundColor(-16777216);
                        }
                    } else {
                        View view4 = QzoneGalleryScene.this.V;
                        if (view4 != null) {
                            view4.setVisibility(0);
                        }
                        View view5 = QzoneGalleryScene.this.X;
                        if (view5 != null) {
                            view5.setVisibility(0);
                        }
                        if (QzoneGalleryScene.this.P.booleanValue()) {
                            QzoneGalleryScene.this.N.setAlpha(255);
                            ((com.tencent.common.galleryactivity.c) QzoneGalleryScene.this).f99861h.setBackgroundDrawable(QzoneGalleryScene.this.N);
                        } else {
                            ((com.tencent.common.galleryactivity.c) QzoneGalleryScene.this).f99861h.setBackgroundColor(-16777216);
                        }
                    }
                    QzoneGalleryScene.this.T = false;
                    return false;
                }
            } else {
                if (motionEvent.getAction() == 2) {
                    if (motionEvent.getPointerCount() == 1 && !QzoneGalleryScene.this.T && ((com.tencent.common.galleryactivity.c) QzoneGalleryScene.this).f99861h != null && !((com.tencent.common.galleryactivity.c) QzoneGalleryScene.this).f99861h.isZoomed() && QzoneGalleryScene.this.b1(motionEvent.getRawX(), motionEvent.getRawY())) {
                        QzoneGalleryScene.this.T = true;
                        QzoneGalleryScene.this.U = true;
                    }
                    if (!QzoneGalleryScene.this.T) {
                        return false;
                    }
                    QzoneGalleryScene qzoneGalleryScene = QzoneGalleryScene.this;
                    if (qzoneGalleryScene.V == null) {
                        qzoneGalleryScene.V = qzoneGalleryScene.g().findViewById(R.id.f166518ft1);
                    }
                    View view6 = QzoneGalleryScene.this.V;
                    if (view6 != null) {
                        view6.setVisibility(4);
                    }
                    QzoneGalleryScene qzoneGalleryScene2 = QzoneGalleryScene.this;
                    if (qzoneGalleryScene2.W == null) {
                        qzoneGalleryScene2.W = qzoneGalleryScene2.g().findViewById(R.id.fth);
                    }
                    View view7 = QzoneGalleryScene.this.W;
                    if (view7 != null) {
                        view7.setVisibility(4);
                    }
                    QzoneGalleryScene qzoneGalleryScene3 = QzoneGalleryScene.this;
                    if (qzoneGalleryScene3.X == null) {
                        qzoneGalleryScene3.X = qzoneGalleryScene3.g().findViewById(R.id.fte);
                    }
                    View view8 = QzoneGalleryScene.this.X;
                    if (view8 != null) {
                        view8.setVisibility(8);
                    }
                    float rawY = motionEvent.getRawY();
                    int i16 = (int) (QzoneGalleryScene.this.R - rawY);
                    QzoneGalleryScene.this.R = rawY;
                    if (((com.tencent.common.galleryactivity.c) QzoneGalleryScene.this).f99861h == null) {
                        QZLog.e("QzoneGalleryScene", 1, "[onTouch] mGallery is null, early return");
                        return true;
                    }
                    int scrollY = ((com.tencent.common.galleryactivity.c) QzoneGalleryScene.this).f99861h.getScrollY();
                    int height = ((com.tencent.common.galleryactivity.c) QzoneGalleryScene.this).f99861h.getHeight();
                    if (i16 < 0) {
                        int i17 = scrollY + height;
                        if (i17 > 0) {
                            ((com.tencent.common.galleryactivity.c) QzoneGalleryScene.this).f99861h.scrollBy(0, Math.max(-i17, i16));
                            if (QzoneGalleryScene.this.L == null || ((com.tencent.common.galleryactivity.c) QzoneGalleryScene.this).f99861h == null || !QzoneGalleryScene.this.L.o(((com.tencent.common.galleryactivity.c) QzoneGalleryScene.this).f99861h.getSelectedItemPosition())) {
                                Gallery gallery = ((com.tencent.common.galleryactivity.c) QzoneGalleryScene.this).f99861h;
                                QzoneGalleryScene qzoneGalleryScene4 = QzoneGalleryScene.this;
                                gallery.setBackgroundColor(qzoneGalleryScene4.X0(Math.abs(rawY - qzoneGalleryScene4.S), height));
                            } else {
                                Drawable background = ((com.tencent.common.galleryactivity.c) QzoneGalleryScene.this).f99861h.getBackground();
                                QzoneGalleryScene qzoneGalleryScene5 = QzoneGalleryScene.this;
                                background.setAlpha((int) (qzoneGalleryScene5.W0(Math.abs(rawY - qzoneGalleryScene5.S), height) * 255.0f));
                            }
                        }
                    } else if (i16 > 0 && (i3 = height - scrollY) > 0) {
                        ((com.tencent.common.galleryactivity.c) QzoneGalleryScene.this).f99861h.scrollBy(0, Math.min(i3, i16));
                        if (QzoneGalleryScene.this.L == null || ((com.tencent.common.galleryactivity.c) QzoneGalleryScene.this).f99861h == null || !QzoneGalleryScene.this.L.o(((com.tencent.common.galleryactivity.c) QzoneGalleryScene.this).f99861h.getSelectedItemPosition())) {
                            Gallery gallery2 = ((com.tencent.common.galleryactivity.c) QzoneGalleryScene.this).f99861h;
                            QzoneGalleryScene qzoneGalleryScene6 = QzoneGalleryScene.this;
                            gallery2.setBackgroundColor(qzoneGalleryScene6.X0(Math.abs(rawY - qzoneGalleryScene6.S), height));
                        } else {
                            Drawable background2 = ((com.tencent.common.galleryactivity.c) QzoneGalleryScene.this).f99861h.getBackground();
                            QzoneGalleryScene qzoneGalleryScene7 = QzoneGalleryScene.this;
                            background2.setAlpha((int) (qzoneGalleryScene7.W0(Math.abs(rawY - qzoneGalleryScene7.S), height) * 255.0f));
                        }
                    }
                    return true;
                }
                if (motionEvent.getAction() == 0) {
                    QzoneGalleryScene.this.Q = motionEvent.getRawX();
                    QzoneGalleryScene.this.R = motionEvent.getRawY();
                    QzoneGalleryScene qzoneGalleryScene8 = QzoneGalleryScene.this;
                    qzoneGalleryScene8.S = qzoneGalleryScene8.R;
                    QzoneGalleryScene.this.T = false;
                }
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c implements a.c {
        c() {
        }

        @Override // com.qzone.album.ui.widget.a.c
        public void onClicked(View view) {
            if (QzoneGalleryScene.this.K != null) {
                QzoneGalleryScene.this.K.k0(view);
                if (QzoneGalleryScene.this.M instanceof com.qzone.preview.business.d) {
                    LpReportInfo_pf00064.allReport(301, 22, 2);
                } else if (QzoneGalleryScene.this.M instanceof com.qzone.preview.business.b) {
                    LpReportInfo_pf00064.allReport(301, 22, 1);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class d implements AlbumRecomGalleryPage.b {
        d() {
        }

        @Override // com.qzone.album.ui.widget.AlbumRecomGalleryPage.b
        public void onClicked(View view) {
            if (QzoneGalleryScene.this.M != null) {
                QzoneGalleryScene.this.M.s0(((com.tencent.common.galleryactivity.c) QzoneGalleryScene.this).F);
                if (QzoneGalleryScene.this.M instanceof com.qzone.preview.business.d) {
                    LpReportInfo_pf00064.allReport(301, 23, 2);
                } else if (QzoneGalleryScene.this.M instanceof com.qzone.preview.business.b) {
                    LpReportInfo_pf00064.allReport(301, 23, 1);
                }
            }
        }
    }

    public QzoneGalleryScene(Activity activity, com.qzone.preview.b bVar, com.tencent.common.galleryactivity.e eVar) {
        super(activity, eVar);
        this.P = Boolean.FALSE;
        this.T = false;
        this.U = false;
        this.Z = false;
        this.f49685a0 = false;
        this.f49686b0 = false;
        this.f49687c0 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_GALLERY_RECOM_ALBUM_FLING_CLOSE, 0) > 0;
        a aVar = new a();
        this.f49688d0 = aVar;
        this.f49689e0 = 0.9f;
        this.f49690f0 = 0.5f;
        this.f49691g0 = 0;
        this.K = bVar;
        BasePicureViewController basePicureViewController = (BasePicureViewController) eVar;
        this.M = basePicureViewController;
        basePicureViewController.T0(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0(float f16) {
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
            translateAnimation.setAnimationListener(new f(this.F));
            translateAnimation.setFillAfter(true);
            float f18 = height;
            AlphaAnimation alphaAnimation = new AlphaAnimation(W0(Math.abs(f16), f18), 0.0f);
            alphaAnimation.setDuration(abs);
            alphaAnimation.setFillAfter(true);
            View findViewById = g().findViewById(R.id.a4f);
            if (findViewById != null) {
                findViewById.setBackgroundColor(X0(Math.abs(f16), f18));
                findViewById.startAnimation(alphaAnimation);
            }
            this.f99861h.setBackgroundColor(17170445);
            this.f99861h.startAnimation(translateAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float W0(float f16, float f17) {
        float f18 = f17 * 0.6f;
        if (f16 < f18) {
            return 0.9f - ((f16 / f18) * 0.39999998f);
        }
        return 0.5f;
    }

    private int Y0() {
        BasePicureViewController basePicureViewController = this.M;
        if (basePicureViewController == null) {
            return 0;
        }
        if (basePicureViewController instanceof com.qzone.preview.business.d) {
            return 2;
        }
        return basePicureViewController instanceof com.qzone.preview.business.b ? 1 : 0;
    }

    private void Z0(View view) {
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
                QZLog.e("QzoneGalleryScene", "Error Handling Item Click for RecomAlbum", e16);
            }
        } finally {
            this.Z = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a1(float f16) {
        float abs = Math.abs(f16 - this.S);
        if (this.f99861h.getSelectedView() == null) {
            return Math.abs(abs) > ((float) (ar.l() / 4));
        }
        float height = this.f99861h.getSelectedView().getHeight();
        return ((double) abs) - (((double) (((float) ar.k()) - height)) / 2.0d) > ((double) height) * 0.1d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b1(float f16, float f17) {
        return Math.abs(f16 - this.Q) < Math.abs(f17 - this.R) - 5.0f;
    }

    private void c1(int i3) {
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
        Drawable loadImage = ImageLoader.getInstance().loadImage(item.bigUrl, new e(item), obtain);
        PhotoInfo F = this.M.F();
        if (loadImage == null || F == null || item.bigUrl.equals(F.currentUrl) || item.bigUrl.equals(F.bigUrl) || !(loadImage instanceof NewGifDrawable)) {
            return;
        }
        loadImage.setVisible(false, true);
        QZLog.d("QzoneGalleryScene", 4, "preload success:stop invisible gif animation");
    }

    private void d1(View view) {
        int config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_KEY_ALBUM_GALLERY_BG_SWITCH, 20);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < config) {
            QZLog.i("QzoneGalleryScene", 2, "[onAlbumRecomPageSelected] current sdk ", Integer.valueOf(i3), " less than lessSdkVersion ", Integer.valueOf(config));
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
                    aVar.setPreProcessor(new com.qzone.preview.view.a(ar.l(), ar.k()));
                    obtain.extraProcessor = aVar;
                    QZLog.i("QzoneGalleryScene", "onAlbumRecomPageSelected, try to load bg URL=" + str);
                    ImageLoader.getInstance().loadImageAsync(str, new ImageLoader.ImageLoadListener() { // from class: com.qzone.preview.QzoneGalleryScene.3
                        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                        public void onImageFailed(String str2, ImageLoader.Options options) {
                            QZLog.e("QzoneGalleryScene", "\u80cc\u666f\u56fe\u7247\u52a0\u8f7d\u5931\u8d25,URL=" + str2);
                        }

                        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                        public void onImageLoaded(String str2, Drawable drawable, ImageLoader.Options options) {
                            if (drawable == null || ((com.tencent.common.galleryactivity.c) QzoneGalleryScene.this).f99861h == null) {
                                return;
                            }
                            QzoneGalleryScene.this.P = Boolean.TRUE;
                            QzoneGalleryScene.this.N = new LayerDrawable(new Drawable[]{drawable, ((com.tencent.common.galleryactivity.c) QzoneGalleryScene.this).F.getResources().getDrawable(R.drawable.avy)});
                            ((com.tencent.common.galleryactivity.c) QzoneGalleryScene.this).F.runOnUiThread(new Runnable() { // from class: com.qzone.preview.QzoneGalleryScene.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (QzoneGalleryScene.this.Y == null) {
                                        ((com.tencent.common.galleryactivity.c) QzoneGalleryScene.this).f99861h.setBackgroundColor(-16777216);
                                    } else {
                                        ((com.tencent.common.galleryactivity.c) QzoneGalleryScene.this).f99861h.setBackgroundDrawable(QzoneGalleryScene.this.N);
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
        this.f49686b0 = true;
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
        if (tag != null && (tag instanceof String) && tag.equals("AlbumRecomView")) {
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

    private void e1(int i3) {
        int j06 = this.K.j0();
        if (j06 == 0) {
            c1(i3 - 1);
            c1(i3 + 1);
        } else if (j06 == 1) {
            c1(i3 + 1);
        } else {
            if (j06 != 2) {
                return;
            }
            c1(i3 - 1);
        }
    }

    private void f1() {
        if (this.f49686b0) {
            Gallery gallery = this.f99861h;
            if (gallery != null) {
                gallery.enableDoubleTap(true);
                this.f99861h.enableScaleGesture(true);
            }
            com.qzone.preview.b bVar = this.K;
            if (bVar != null) {
                bVar.y1();
            }
            this.f49686b0 = false;
        }
    }

    private void h1(int i3) {
        PhotoInfo item;
        Drawable imageDrawable;
        int i16;
        PhotoInfo item2;
        Drawable imageDrawable2;
        if (i3 > 0 && (item2 = this.M.getItem(i3 - 1)) != null && (imageDrawable2 = item2.getImageDrawable()) != null && (imageDrawable2 instanceof NewGifDrawable)) {
            imageDrawable2.setVisible(false, true);
            QZLog.d("QzoneGalleryScene", 4, "after selected:stop invisible gif animation-pos" + i16);
        }
        int i17 = i3 + 1;
        if (i17 >= this.M.getCount() || (item = this.M.getItem(i17)) == null || (imageDrawable = item.getImageDrawable()) == null || !(imageDrawable instanceof NewGifDrawable)) {
            return;
        }
        imageDrawable.setVisible(false, true);
        QZLog.d("QzoneGalleryScene", 4, "after selected:stop invisible gif animation-pos" + i17);
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
            this.f99861h.isQzoneDefaultScale(this.f49685a0);
            this.f99861h.setInterceptTouchEventReturn(false);
            this.f99861h.setOnTouchListener(new b());
        }
    }

    @Override // com.tencent.common.galleryactivity.c
    public void F() {
        super.F();
    }

    public void g1(boolean z16) {
        this.f49685a0 = z16;
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
        h1(this.M.getSelectedIndex());
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
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.qzone.preview.QzoneGalleryScene.4
            @Override // java.lang.Runnable
            public void run() {
                QzoneGalleryScene.this.M.Q(QzoneGalleryScene.this.K.n7());
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
                QZLog.i("QzoneGalleryScene", "onItemSelected to Recom Albun Page");
            }
            d1(view);
            return;
        }
        this.Y = null;
        this.f99861h.setBackgroundColor(-16777216);
        super.onItemSelected(adapterView, view, i3, j3);
        f1();
        PictureAdapter pictureAdapter2 = this.L;
        if (pictureAdapter2 != null) {
            pictureAdapter2.i0(view, i3);
        }
        if (!(this.K instanceof LocalPictureViewer)) {
            e1(i3);
        }
        this.K.updateUI();
        h1(i3);
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
        if (i3 != this.f49691g0) {
            if (BasePicureViewController.a0()) {
                str = ProfileCardTemplate.PROFILE_COMMON_VERSION;
            } else {
                str = "582";
            }
            ClickReport.m(str, "5", "");
            if (QZLog.isDevelopLevel()) {
                QZLog.d("QzoneGalleryScene", 4, "report scroll.");
            }
            this.f49691g0 = i3;
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
            pictureAdapter.j0(i3, view, U0(regionDrawableData));
        }
    }

    @Override // com.tencent.common.galleryactivity.c
    protected com.tencent.common.galleryactivity.d q(Context context) {
        PictureAdapter pictureAdapter = new PictureAdapter(this.K, this.M, this.f99861h);
        this.L = pictureAdapter;
        pictureAdapter.l0(this.f49685a0);
        this.L.u(Y0());
        this.L.r(new c());
        this.L.s(new d());
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
    public g t() {
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
    public int X0(float f16, float f17) {
        return ((int) (W0(f16, f17) * 255.0f)) << 24;
    }

    @Override // com.qzone.preview.view.PictureViewGallery.c
    public void c(MotionEvent motionEvent) {
        View selectedView;
        if (motionEvent == null || this.Y == null || (selectedView = this.f99861h.getSelectedView()) == null) {
            return;
        }
        Object tag = selectedView.getTag(R.layout.bio);
        if (tag != null && (tag instanceof String) && tag.equals("AlbumRecomView")) {
            this.Y = ((DynamicPictureAdapter.c) selectedView.getTag()).f49532a;
        }
        Z0(null);
    }

    private com.tencent.component.media.image.region.RegionDrawableData U0(RegionDrawableData regionDrawableData) {
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
    /* loaded from: classes39.dex */
    public class e implements ImageLoader.ImageLoadListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ PhotoInfo f49698d;

        e(PhotoInfo photoInfo) {
            this.f49698d = photoInfo;
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            PhotoInfo photoInfo = this.f49698d;
            photoInfo.hasLoaded = true;
            photoInfo.progress = 100;
            PhotoInfo F = QzoneGalleryScene.this.M.F();
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
            PhotoInfo photoInfo = this.f49698d;
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
    /* loaded from: classes39.dex */
    public static final class f implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<Activity> f49700d;

        public f(Activity activity) {
            this.f49700d = new WeakReference<>(activity);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Activity activity = this.f49700d.get();
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
