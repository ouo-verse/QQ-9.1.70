package com.qzone.preview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.common.tool.ReportUtils;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.preview.BasePictureViewer;
import com.qzone.preview.business.BasePicureViewController;
import com.qzone.preview.service.PictureManager;
import com.qzone.preview.view.PictureImageView;
import com.qzone.reborn.layer.part.QZonePictureViewerPart;
import com.qzone.util.ToastUtil;
import com.qzone.util.ae;
import com.qzone.util.aj;
import com.qzone.util.ar;
import com.qzone.util.l;
import com.qzone.widget.AsyncImageable;
import com.tencent.YTFace.model.FaceStatus;
import com.tencent.YTFace.model.FaceTarget;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.region.RegionDrawable;
import com.tencent.component.media.image.region.RegionDrawableData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoManagerUtils;
import com.tencent.mobileqq.qzoneplayer.video.IndividualAutoVideoControlView;
import com.tencent.mobileqq.qzoneplayer.video.VideoPlayInfo;
import com.tencent.mobileqq.qzoneplayer.video.VideoPlayInfoHolder;
import com.tencent.mobileqq.teamwork.api.ITDocAttaReporterApi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.panorama.IPanoramaLoadingLayout;
import com.tencent.qzonehub.api.panorama.IPanoramaUtil;
import com.tencent.widget.Gallery;
import common.config.service.QZoneConfigHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.model.FaceData;
import cooperation.qzone.model.ImageTagInfo;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.VideoInfo;
import cooperation.qzone.model.VideoUrl;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.gifCoderWnsConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/* loaded from: classes39.dex */
public class PictureAdapter extends DynamicPictureAdapter {
    private com.qzone.preview.b N;
    private BasePicureViewController P;
    private Gallery Q;
    private BaseVideoManager R;
    private FaceRelativeLayout W;
    private FaceRelativeLayout X;
    private WeakReference<FaceRelativeLayout> Y;

    /* renamed from: g0, reason: collision with root package name */
    private Pair<String, View> f49600g0;

    /* renamed from: n0, reason: collision with root package name */
    Runnable f49607n0;
    private boolean S = true;
    private boolean T = false;
    private boolean U = false;
    private boolean V = false;
    private boolean Z = false;

    /* renamed from: a0, reason: collision with root package name */
    private View.OnClickListener f49594a0 = new b();

    /* renamed from: b0, reason: collision with root package name */
    private View.OnClickListener f49595b0 = new c();

    /* renamed from: c0, reason: collision with root package name */
    private BaseVideoManager.VideoPlayInfoListener f49596c0 = new d();

    /* renamed from: d0, reason: collision with root package name */
    private Runnable f49597d0 = new Runnable() { // from class: com.qzone.preview.PictureAdapter.6
        @Override // java.lang.Runnable
        public void run() {
            PictureManager.getInstance().getSender().startDownloadVideo(PictureAdapter.this.N.getHandler());
        }
    };

    /* renamed from: e0, reason: collision with root package name */
    private Runnable f49598e0 = new Runnable() { // from class: com.qzone.preview.PictureAdapter.7
        @Override // java.lang.Runnable
        public void run() {
            PictureManager.getInstance().getSender().stopDownloadVideo(PictureAdapter.this.N.getHandler());
        }
    };

    /* renamed from: f0, reason: collision with root package name */
    private int f49599f0 = 0;

    /* renamed from: h0, reason: collision with root package name */
    private String f49601h0 = "";

    /* renamed from: i0, reason: collision with root package name */
    private Runnable f49602i0 = new Runnable() { // from class: com.qzone.preview.PictureAdapter.9
        @Override // java.lang.Runnable
        public void run() {
            QZLog.i("PictureAdapter", "playVideoRunable");
            if (PictureAdapter.this.Q.getChildAt(0) instanceof FaceRelativeLayout) {
                PictureAdapter pictureAdapter = PictureAdapter.this;
                pictureAdapter.X = (FaceRelativeLayout) pictureAdapter.Q.getChildAt(0);
            }
            if (PictureAdapter.this.X != null) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(PictureAdapter.this.X.f49536h);
                BaseVideoManager.getFeedVideoManager().onListIdleSingleVideo(linkedList);
                PictureAdapter.this.X.f49537i.setVisibility(4);
            }
        }
    };

    /* renamed from: j0, reason: collision with root package name */
    q4.a f49603j0 = new q4.a();

    /* renamed from: k0, reason: collision with root package name */
    private HashMap<String, Boolean> f49604k0 = new HashMap<>();

    /* renamed from: l0, reason: collision with root package name */
    private boolean f49605l0 = false;

    /* renamed from: m0, reason: collision with root package name */
    private int f49606m0 = -1;

    /* renamed from: com.qzone.preview.PictureAdapter$11, reason: invalid class name */
    /* loaded from: classes39.dex */
    class AnonymousClass11 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f49608d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ PictureImageView f49609e;
        final /* synthetic */ PictureAdapter this$0;

        @Override // java.lang.Runnable
        public void run() {
            ImageLoader.Options obtain = ImageLoader.Options.obtain();
            obtain.useMainThread = true;
            obtain.extraProcessor = new uo.a(20);
            ImageLoader.getInstance().loadImage(this.f49608d, new a(), obtain);
        }

        /* renamed from: com.qzone.preview.PictureAdapter$11$a */
        /* loaded from: classes39.dex */
        class a implements ImageLoader.ImageLoadListener {
            a() {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
                PictureImageView pictureImageView;
                if (drawable == null || (pictureImageView = AnonymousClass11.this.f49609e) == null) {
                    return;
                }
                pictureImageView.setForeground(drawable);
                AnonymousClass11.this.f49609e.setVisibility(0);
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageCanceled(String str, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageFailed(String str, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageProgress(String str, float f16, ImageLoader.Options options) {
            }
        }
    }

    /* loaded from: classes39.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            PhotoInfo photoInfo = (PhotoInfo) PictureAdapter.this.getItem(Integer.valueOf(view.getTag().toString()).intValue());
            if (photoInfo != null && 2 == photoInfo.photoType) {
                view.setVisibility(8);
                PictureAdapter.this.N.H0(2);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes39.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!(view.getTag() instanceof Integer)) {
                QZLog.e("PictureAdapter", "play video click: invalid position");
            } else {
                PhotoInfo photoInfo = (PhotoInfo) PictureAdapter.this.getItem(((Integer) view.getTag()).intValue());
                if (!PictureAdapter.this.c0(photoInfo)) {
                    QZLog.e("PictureAdapter", "play video click: invalid video data");
                } else if (!(view.getParent() instanceof FaceRelativeLayout)) {
                    QZLog.e("PictureAdapter", "play video click: invalid parent view");
                } else {
                    if (QZLog.isDevelopLevel()) {
                        QZLog.i("PictureAdapter", 4, "playing video " + photoInfo.videodata);
                    }
                    PictureAdapter.this.X = (FaceRelativeLayout) view.getParent();
                    if (PictureAdapter.this.X.f49536h != null) {
                        IndividualAutoVideoControlView o16 = PictureAdapter.this.X.f49536h.o();
                        if (o16 != null && o16.o()) {
                            o16.g();
                        } else {
                            PictureAdapter.this.R.C(PictureAdapter.this.X.f49536h);
                            PictureAdapter.this.T = true;
                        }
                    }
                    PictureAdapter.this.X.f49537i.setVisibility(4);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes39.dex */
    class d implements BaseVideoManager.VideoPlayInfoListener {
        d() {
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
        public void onVideoPlayComplete(VideoPlayInfoHolder videoPlayInfoHolder) {
            if (QZLog.isColorLevel()) {
                QZLog.d("PictureAdapter", 2, "onVideoPlayComplete");
            }
            PictureAdapter.this.T = false;
            PictureAdapter.this.k0(false);
            PictureAdapter.this.V = false;
            if (PictureAdapter.this.N instanceof QzonePictureViewer) {
                ((QzonePictureViewer) PictureAdapter.this.N).S5();
            }
            PictureAdapter.this.N.getHandler().removeCallbacks(PictureAdapter.this.f49598e0);
            PictureAdapter.this.N.getHandler().removeCallbacks(PictureAdapter.this.f49597d0);
            PictureAdapter.this.N.getHandler().postDelayed(PictureAdapter.this.f49597d0, 1000L);
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
        public void onVideoPlayError(VideoPlayInfoHolder videoPlayInfoHolder) {
            QZLog.e("PictureAdapter", "onVideoPlayError");
            PictureAdapter.this.k0(false);
            PictureAdapter.this.V = false;
            PictureAdapter.this.T = false;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
        public void onVideoPlayPause(VideoPlayInfoHolder videoPlayInfoHolder) {
            if (QZLog.isColorLevel()) {
                QZLog.d("PictureAdapter", 2, "onVideoPlayPause");
            }
            PictureAdapter.this.T = false;
            PictureAdapter.this.k0(false);
            PictureAdapter.this.V = false;
            PictureAdapter.this.N.getHandler().removeCallbacks(PictureAdapter.this.f49598e0);
            PictureAdapter.this.N.getHandler().removeCallbacks(PictureAdapter.this.f49597d0);
            PictureAdapter.this.N.getHandler().postDelayed(PictureAdapter.this.f49597d0, 1000L);
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
        public void onVideoPlayProgressUpdate(VideoPlayInfoHolder videoPlayInfoHolder) {
            if (PictureAdapter.this.V) {
                return;
            }
            PictureAdapter.this.k0(true);
            PictureAdapter.this.V = true;
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
        public void onVideoPlayStart(VideoPlayInfoHolder videoPlayInfoHolder) {
            if (QZLog.isColorLevel()) {
                QZLog.d("PictureAdapter", 2, "onVideoPlayStart");
            }
            PictureAdapter.this.T = true;
            PictureAdapter.this.k0(true);
            PictureAdapter.this.V = true;
            PictureAdapter.this.N.getHandler().removeCallbacks(PictureAdapter.this.f49598e0);
            PictureAdapter.this.N.getHandler().removeCallbacks(PictureAdapter.this.f49597d0);
            PictureAdapter.this.N.getHandler().postDelayed(PictureAdapter.this.f49598e0, 2000L);
        }

        @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager.VideoPlayInfoListener
        public void onVideoPlayStop(VideoPlayInfoHolder videoPlayInfoHolder) {
            if (QZLog.isColorLevel()) {
                QZLog.d("PictureAdapter", 2, "onVideoPlayStop");
            }
            PictureAdapter.this.T = false;
            if (PictureAdapter.this.W != null && PictureAdapter.this.W.f49537i != null && PictureAdapter.this.W.f49537i.getVisibility() != 8) {
                PictureAdapter.this.k0(false);
            }
            PictureAdapter.this.V = false;
            PictureAdapter.this.Z();
            PictureAdapter.this.N.getHandler().removeCallbacks(PictureAdapter.this.f49598e0);
            PictureAdapter.this.N.getHandler().removeCallbacks(PictureAdapter.this.f49597d0);
            PictureAdapter.this.N.getHandler().postDelayed(PictureAdapter.this.f49597d0, 1000L);
        }
    }

    /* loaded from: classes39.dex */
    class e implements BasePictureViewer.n {

        /* renamed from: a, reason: collision with root package name */
        private boolean f49640a = false;

        e() {
        }

        @Override // com.qzone.preview.BasePictureViewer.n
        public void a() {
            if (PictureAdapter.this.W == null || !PictureAdapter.this.W.f49536h.n()) {
                return;
            }
            PictureAdapter.this.W.f49536h.onPause();
            this.f49640a = true;
        }

        @Override // com.qzone.preview.BasePictureViewer.n
        public void b() {
            if (this.f49640a && PictureAdapter.this.W != null) {
                PictureAdapter.this.R.C(PictureAdapter.this.W.f49536h);
                PictureAdapter.this.W.f49537i.setVisibility(4);
            }
            this.f49640a = false;
        }

        @Override // com.qzone.preview.BasePictureViewer.n
        public void c() {
            QZLog.i("PictureAdapter", "requestFirstVideoPlay");
            if (PictureAdapter.this.T || !PictureAdapter.this.N.X()) {
                return;
            }
            QZLog.i("PictureAdapter", "requestFirstVideoPlay startPlayVideo");
            PictureAdapter.this.o0();
            PictureAdapter.this.T = true;
        }

        @Override // com.qzone.preview.BasePictureViewer.n
        public void d() {
            PictureAdapter.this.U = true;
        }
    }

    public PictureAdapter(com.qzone.preview.b bVar, BasePicureViewController basePicureViewController, Gallery gallery) {
        this.N = bVar;
        this.P = basePicureViewController;
        this.Q = gallery;
        BaseVideoManager feedVideoManager = BaseVideoManager.getFeedVideoManager();
        this.R = feedVideoManager;
        feedVideoManager.setVideoPlayInfoListener(this.f49596c0);
        this.N.x2(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(FaceRelativeLayout faceRelativeLayout) {
        QzoneAlbumVideoView qzoneAlbumVideoView;
        RelativeLayout relativeLayout = this.N.h8() instanceof RelativeLayout ? (RelativeLayout) this.N.h8() : null;
        if (relativeLayout == null || (qzoneAlbumVideoView = faceRelativeLayout.f49536h) == null || qzoneAlbumVideoView.o() == null) {
            return;
        }
        relativeLayout.removeAllViews();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.topMargin += ar.e(4.0f);
        relativeLayout.addView(faceRelativeLayout.f49536h.o(), layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        if (this.U) {
            this.N.getHostActivity().runOnUiThread(new Runnable() { // from class: com.qzone.preview.PictureAdapter.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PictureAdapter.this.Q.getChildAt(0) instanceof FaceRelativeLayout) {
                        PictureAdapter pictureAdapter = PictureAdapter.this;
                        pictureAdapter.X = (FaceRelativeLayout) pictureAdapter.Q.getChildAt(0);
                    }
                    if (PictureAdapter.this.X != null) {
                        PictureAdapter.this.R.C(PictureAdapter.this.X.f49536h);
                        PictureAdapter.this.X.f49537i.setVisibility(4);
                    }
                    PictureAdapter.this.U = false;
                }
            });
        }
    }

    private boolean b0() {
        com.qzone.preview.b bVar = this.N;
        if (bVar instanceof QzonePictureViewer) {
            return ((QzonePictureViewer) bVar).r6();
        }
        if (bVar instanceof QZonePictureViewerPart) {
            return ((QZonePictureViewerPart) bVar).Mc();
        }
        return false;
    }

    private void d0(final FaceRelativeLayout faceRelativeLayout, ViewGroup viewGroup, int i3) {
        String str;
        String str2;
        VideoInfo videoInfo;
        final PhotoInfo photoInfo = (PhotoInfo) getItem(i3);
        if (photoInfo != null && !TextUtils.isEmpty(photoInfo.bigUrl)) {
            this.Y = new WeakReference<>(faceRelativeLayout);
            if (QZLog.isDevelopLevel()) {
                QZLog.d("PictureAdapter", 4, "loadImageData: " + aj.d(photoInfo, i3));
            }
            faceRelativeLayout.f49533d.setTag(photoInfo);
            faceRelativeLayout.setTag(Gallery.ID_USER_DEFINE_SCALE, null);
            faceRelativeLayout.setTag(Gallery.ID_USER_DEFINE_DOUBLE_TAP_SCALE, Float.valueOf(QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PICTURE_VIEWER_DOUBLE_TAP_SCALE, 2.0f)));
            faceRelativeLayout.f49533d.setEnableHighScale(photoInfo.photoType != 2 && ((videoInfo = photoInfo.videodata) == null || videoInfo.videoUrl == null));
            faceRelativeLayout.f49533d.setNeedProgress(true);
            faceRelativeLayout.f49533d.setAsyncImageListener(new PictureLoadListener(faceRelativeLayout, photoInfo, i3));
            faceRelativeLayout.f49533d.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            if (!photoInfo.isPanorama()) {
                faceRelativeLayout.f49533d.setOpenFace(this.P.f49896z);
            } else {
                faceRelativeLayout.f49533d.setOpenFace(false);
                faceRelativeLayout.f49533d.setFaceData(null);
            }
            faceRelativeLayout.f49533d.setFaceData(photoInfo.mFaceList);
            if (photoInfo.photoType == 2 && !TextUtils.isEmpty(photoInfo.orgUrl)) {
                faceRelativeLayout.f49533d.setImageType(2);
                if (photoInfo.showGifState != PhotoInfo.SHOW_GIF && !this.P.e0()) {
                    faceRelativeLayout.f49535f.setVisibility(8);
                    faceRelativeLayout.f49533d.setNeedGifStream(true);
                    faceRelativeLayout.f49533d.setAsyncImage(photoInfo.bigUrl);
                    if (QZLog.isDevelopLevel()) {
                        QZLog.d("PictureAdapter", 4, "loadImageData: [GIF] load bigUrl=" + photoInfo.bigUrl);
                    }
                } else {
                    faceRelativeLayout.f49535f.setVisibility(8);
                    faceRelativeLayout.f49533d.setNeedGifStream(true);
                    faceRelativeLayout.f49533d.setAsyncImage(photoInfo.orgUrl);
                    QZLog.d("PictureAdapter", 4, "loadImageData: [GIF] before load set gifPlaying true");
                    faceRelativeLayout.f49533d.setPlayingGif(ImageManagerEnv.g().isSupportGifPlaying());
                    if (QZLog.isDevelopLevel()) {
                        QZLog.d("PictureAdapter", 4, "loadImageData: [GIF] load orgUrl=" + photoInfo.orgUrl);
                    }
                }
            } else {
                faceRelativeLayout.f49533d.setNeedGifStream(photoInfo.photoType == 2);
                if (photoInfo.mNeedEncodeGifPics.size() > 0) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(photoInfo.mNeedEncodeGifPics.get(0), options);
                    if (options.outHeight > options.outWidth) {
                        int currentDeviceGifSize = gifCoderWnsConfig.getCurrentDeviceGifSize();
                        int i16 = (options.outHeight * currentDeviceGifSize) / options.outWidth;
                        faceRelativeLayout.f49533d.setAsyncClipSize(currentDeviceGifSize, i16);
                        faceRelativeLayout.f49533d.setDecodeConfig(Bitmap.Config.RGB_565);
                        faceRelativeLayout.f49533d.setAsyncImageProcessor(new com.qzone.album.base.a(currentDeviceGifSize, i16));
                    } else {
                        int currentDeviceGifSize2 = gifCoderWnsConfig.getCurrentDeviceGifSize();
                        int i17 = (options.outWidth * currentDeviceGifSize2) / options.outHeight;
                        faceRelativeLayout.f49533d.setAsyncClipSize(i17, currentDeviceGifSize2);
                        faceRelativeLayout.f49533d.setAsyncImageProcessor(new com.qzone.album.base.a(i17, currentDeviceGifSize2));
                    }
                    faceRelativeLayout.f49533d.setAsyncImages(photoInfo.mNeedEncodeGifPics, photoInfo.mNeedEncodeGifDelay);
                } else if (TextUtils.isEmpty(photoInfo.orgUrl)) {
                    String str3 = photoInfo.bigUrl;
                    faceRelativeLayout.setVisibility(0);
                    faceRelativeLayout.f49533d.setVisibility(0);
                    if (photoInfo.photoType == 2) {
                        QZLog.d("PictureAdapter", 4, "photoInfo.orgUrl is empty loadImageData: [GIF] before load set gifPlaying true");
                        faceRelativeLayout.f49533d.setPlayingGif(ImageManagerEnv.g().isSupportGifPlaying());
                        faceRelativeLayout.f49533d.setImageType(2);
                    }
                    faceRelativeLayout.f49533d.setAsyncImage(str3);
                    if (QZLog.isDevelopLevel()) {
                        QZLog.d("PictureAdapter", 4, "loadImageData: [NORMAL] load bigUrl=" + photoInfo.bigUrl);
                    }
                } else {
                    Boolean bool = photoInfo.hasLocalOrgFile;
                    if (bool != null) {
                        if (bool.booleanValue()) {
                            str = photoInfo.orgUrl;
                        } else {
                            str = photoInfo.bigUrl;
                        }
                        if (photoInfo.isPanorama()) {
                            str = photoInfo.bigUrl;
                        }
                        if (photoInfo.hasLocalOrgFile.booleanValue()) {
                            faceRelativeLayout.f49533d.setNeedPieceLoad(true);
                        } else {
                            faceRelativeLayout.f49533d.setNeedPieceLoad(false);
                        }
                        faceRelativeLayout.f49533d.setAsyncImage(str);
                        if (QZLog.isDevelopLevel()) {
                            QZLog.d("PictureAdapter", 4, "loadImageData: [NORMAL] load url=" + str);
                        }
                    } else {
                        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.qzone.preview.PictureAdapter.12
                            @Override // java.lang.Runnable
                            public void run() {
                                final String str4;
                                boolean z16 = ImageLoader.getInstance().getImageFile(photoInfo.orgUrl) != null;
                                photoInfo.hasLocalOrgFile = Boolean.valueOf(z16);
                                PhotoInfo photoInfo2 = photoInfo;
                                if (z16) {
                                    str4 = photoInfo2.orgUrl;
                                } else {
                                    str4 = photoInfo2.bigUrl;
                                }
                                if (photoInfo.isPanorama()) {
                                    str4 = photoInfo.bigUrl;
                                }
                                if (z16) {
                                    faceRelativeLayout.f49533d.setNeedPieceLoad(true);
                                } else {
                                    faceRelativeLayout.f49533d.setNeedPieceLoad(false);
                                }
                                PictureAdapter.this.N.getHandler().post(new Runnable() { // from class: com.qzone.preview.PictureAdapter.12.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        faceRelativeLayout.f49533d.setAsyncImage(str4);
                                        if (QZLog.isDevelopLevel()) {
                                            QZLog.d("PictureAdapter", 4, "loadImageData: [NORMAL] run load url=" + str4);
                                        }
                                    }
                                });
                            }
                        });
                    }
                }
            }
            if (!photoInfo.hasVisited) {
                if (BasePicureViewController.a0()) {
                    str2 = ProfileCardTemplate.PROFILE_COMMON_VERSION;
                } else {
                    str2 = "582";
                }
                ClickReport.m(str2, "7", "");
                if (QZLog.isDevelopLevel()) {
                    QZLog.d("PictureAdapter", 4, "report exposed.");
                }
            }
            photoInfo.hasVisited = true;
            if (PictureManager.getInstance().checkNetworkConnect()) {
                return;
            }
            this.N.q1();
            return;
        }
        QZLog.e("PictureAdapter", "loadImageData: bigUrl is empty");
    }

    private void e0(FaceRelativeLayout faceRelativeLayout, int i3) {
        PhotoInfo photoInfo = (PhotoInfo) getItem(i3);
        if (photoInfo != null && !TextUtils.isEmpty(photoInfo.currentUrl)) {
            if (QZLog.isDevelopLevel()) {
                QZLog.d("PictureAdapter", 4, String.format("loadThumbImageData: position=%d, currentUrl=%s, bigUrl=%s, orgUrl=%s", Integer.valueOf(i3), photoInfo.currentUrl, photoInfo.bigUrl, photoInfo.orgUrl));
            }
            if (photoInfo.hasLoaded) {
                return;
            }
            faceRelativeLayout.f49534e.setVisibility(4);
            faceRelativeLayout.f49534e.setNeedDownload(false);
            faceRelativeLayout.f49534e.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            PictureImageView pictureImageView = faceRelativeLayout.f49534e;
            pictureImageView.setAsyncImageListener(new a(pictureImageView, photoInfo));
            faceRelativeLayout.f49534e.setAsyncImage(photoInfo.currentUrl);
            return;
        }
        QZLog.e("PictureAdapter", "loadThumbImageData: currentUrl is empty");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(FaceTarget faceTarget, final String str) {
        ArrayList<FaceData> arrayList = new ArrayList<>();
        int t16 = com.qzone.album.env.common.a.m().t("QZoneSetting", QzoneConfig.SECONDARY_UPLOAD_CHECK_FACE_NUM, 10);
        for (int i3 = 0; i3 < faceTarget.faces.length && i3 < t16; i3++) {
            FaceData faceData = new FaceData();
            FaceStatus faceStatus = faceTarget.faces[i3];
            float f16 = faceStatus.f61315x * 10000.0f;
            int i16 = faceTarget.width;
            faceData.f390865x = f16 / i16;
            float f17 = faceStatus.f61316y * 10000.0f;
            int i17 = faceTarget.height;
            faceData.f390866y = f17 / i17;
            faceData.f390864w = (faceStatus.width * 10000.0f) / i16;
            faceData.f390863h = (faceStatus.height * 10000.0f) / i17;
            arrayList.add(faceData);
        }
        this.P.S0(arrayList, str, false);
        QZLog.d("[PhotoAlbum]FaceFuntion", 1, "newAndupdateFaceData lloc:", str);
        this.N.getHostActivity().runOnUiThread(new Runnable() { // from class: com.qzone.preview.PictureAdapter.14
            @Override // java.lang.Runnable
            public void run() {
                PictureAdapter.this.N.d1(true);
                QZLog.d("[PhotoAlbum]FaceFuntion", 1, "runOnUiThread lloc:", str);
                PictureAdapter.this.notifyDataSetChanged();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(final boolean z16) {
        this.N.getHostActivity().runOnUiThread(new Runnable() { // from class: com.qzone.preview.PictureAdapter.3
            @Override // java.lang.Runnable
            public void run() {
                if (z16 && PictureAdapter.this.X != null) {
                    if (PictureAdapter.this.X != null && PictureAdapter.this.X.f49538m != null && PictureAdapter.this.X.f49536h != null && !TextUtils.isEmpty(PictureAdapter.this.f49601h0)) {
                        PictureAdapter.this.X.f49538m.setText(PictureAdapter.this.f49601h0);
                        PictureAdapter.this.X.f49538m.setTextColor(Color.parseColor("#CCCCCC"));
                        PictureAdapter.this.X.f49536h.setOriginalVideoBtn(PictureAdapter.this.X.f49538m);
                    }
                    PictureAdapter pictureAdapter = PictureAdapter.this;
                    pictureAdapter.W = pictureAdapter.X;
                    PictureAdapter.this.X = null;
                    PictureAdapter pictureAdapter2 = PictureAdapter.this;
                    pictureAdapter2.X(pictureAdapter2.W);
                }
                if (PictureAdapter.this.W != null) {
                    PictureAdapter.this.W.f49537i.setVisibility(z16 ? 4 : 0);
                }
                PictureAdapter.this.N.S7(z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0(final int i3, int i16, int i17) {
        if (this.f49607n0 != null) {
            this.N.getHandler().removeCallbacks(this.f49607n0);
            this.f49607n0 = null;
        }
        this.f49607n0 = new Runnable() { // from class: com.qzone.preview.PictureAdapter.16
            @Override // java.lang.Runnable
            public void run() {
                PictureAdapter.this.P.getItem(i3);
                PictureAdapter.this.f49605l0 = false;
            }
        };
        this.N.getHandler().postDelayed(this.f49607n0, i17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0() {
        this.Q.removeCallbacks(this.f49602i0);
        this.Q.postDelayed(this.f49602i0, 200L);
    }

    @Override // com.tencent.common.galleryactivity.d
    public void c(View view, int i3) {
        PhotoInfo item = this.P.getItem(i3);
        if (item != null) {
            int i16 = item.progress;
            if (i16 >= 0 && i16 < 100 && !item.hasLoaded && PictureManager.getInstance().checkNetworkConnect()) {
                if (this.f49605l0) {
                    super.I0(i3, item.progress);
                }
            } else {
                k2(i3, item.hasLoaded);
                this.f49605l0 = false;
            }
        }
    }

    public void g0() {
        Object obj;
        Pair<String, View> pair = this.f49600g0;
        if (pair == null || (obj = pair.second) == null) {
            return;
        }
        ((View) obj).setTag(R.id.cql, Boolean.TRUE);
        this.f49600g0 = null;
    }

    public void h0() {
        q4.a aVar = this.f49603j0;
        if (aVar != null) {
            aVar.p();
        }
    }

    public void i0(View view, int i3) {
        com.qzone.preview.b bVar;
        VideoInfo videoInfo;
        VideoUrl videoUrl;
        QZLog.i("PictureAdapter", "onItemSelected");
        if ((view instanceof FaceRelativeLayout) && c0((PhotoInfo) getItem(i3))) {
            QZLog.i("PictureAdapter", "onItemSelected video");
            this.X = (FaceRelativeLayout) view;
            PhotoInfo photoInfo = (PhotoInfo) getItem(i3);
            this.f49601h0 = "";
            n0(photoInfo);
            if (photoInfo != null && (videoInfo = photoInfo.videodata) != null && (videoUrl = videoInfo.videoUrl) != null && !TextUtils.isEmpty(videoUrl.url) && !URLUtil.isNetworkUrl(photoInfo.videodata.videoUrl.url) && i3 != 0) {
                this.S = false;
            }
            if ((!this.S || BasePicureViewController.g0()) && (bVar = this.N) != null && bVar.X()) {
                QZLog.i("PictureAdapter", "onItemSelected startPlayVideo");
                o0();
                this.T = true;
                return;
            }
            this.S = false;
            return;
        }
        this.S = false;
    }

    public void l0(boolean z16) {
        this.Z = z16;
    }

    @Override // com.qzone.preview.DynamicPictureAdapter
    public View m(int i3, View view, ViewGroup viewGroup) {
        String str;
        FaceRelativeLayout faceRelativeLayout;
        Pair<String, View> pair;
        PhotoInfo photoInfo = (PhotoInfo) getItem(i3);
        if (photoInfo != null) {
            str = photoInfo.lloc;
        } else {
            str = "";
        }
        if (view == null) {
            if (this.f49599f0 == 1 && (pair = this.f49600g0) != null && ((String) pair.first).equals(str)) {
                view = (View) this.f49600g0.second;
            } else {
                com.qzone.preview.b bVar = this.N;
                if (bVar != null) {
                    view = bVar.getHostActivity().getLayoutInflater().inflate(R.layout.bp7, (ViewGroup) null);
                }
                if (this.f49599f0 == 0 && !TextUtils.isEmpty(str)) {
                    this.f49600g0 = new Pair<>(str, view);
                    if (view != null) {
                        view.setTag(R.id.cql, Boolean.FALSE);
                    }
                }
            }
            faceRelativeLayout = (FaceRelativeLayout) view;
        } else {
            faceRelativeLayout = (FaceRelativeLayout) view;
        }
        int i16 = this.f49599f0;
        if (i16 >= 1 && this.f49600g0 != null) {
            this.f49600g0 = null;
        }
        this.f49599f0 = i16 + 1;
        faceRelativeLayout.setMinimumWidth(10);
        faceRelativeLayout.setMinimumHeight(10);
        faceRelativeLayout.c(this.Z);
        faceRelativeLayout.setController(this.P);
        faceRelativeLayout.setPictureViewer(this.N);
        faceRelativeLayout.setVideoManager(this.R);
        faceRelativeLayout.f49535f.setOnClickListener(this.f49594a0);
        faceRelativeLayout.f49535f.setTag(Integer.valueOf(i3));
        faceRelativeLayout.f49537i.setOnClickListener(this.f49595b0);
        faceRelativeLayout.f49537i.setTag(Integer.valueOf(i3));
        com.qzone.preview.b bVar2 = this.N;
        if (bVar2 != null && bVar2.o3() != null) {
            TextView o36 = this.N.o3();
            faceRelativeLayout.f49538m = o36;
            o36.setTag(Integer.valueOf(i3));
            faceRelativeLayout.f49538m.setVisibility(4);
        }
        boolean c06 = c0(photoInfo);
        if (c06) {
            faceRelativeLayout.f49537i.setVisibility(0);
            faceRelativeLayout.f49536h.setVisibility(0);
            faceRelativeLayout.setTag(2131296418, Boolean.TRUE);
        } else {
            faceRelativeLayout.f49537i.setVisibility(4);
            faceRelativeLayout.f49536h.setVisibility(8);
            faceRelativeLayout.setTag(2131296418, Boolean.FALSE);
        }
        if (QZLog.isColorLevel()) {
            QZLog.d("[PhotoAlbum]AlbumPerformance", 1, "PictureAdapter", " getView finish");
        }
        if (c06 && (getItem(i3) instanceof PhotoInfo)) {
            faceRelativeLayout.f49536h.setVideoPlayInfo(ae.a(((PhotoInfo) getItem(i3)).videodata));
            faceRelativeLayout.f49536h.setVideoPlayBtn(faceRelativeLayout.f49537i);
        } else {
            if (this.f49599f0 == 1) {
                e0(faceRelativeLayout, i3);
            }
            d0(faceRelativeLayout, viewGroup, i3);
        }
        faceRelativeLayout.setTag(Integer.valueOf(i3));
        return faceRelativeLayout;
    }

    @Override // com.tencent.common.galleryactivity.d
    public void q(int i3, int i16) {
        PhotoInfo item = this.P.getItem(i3);
        if (item != null) {
            int i17 = item.progress;
            if (i17 >= 0 && i17 < 100 && !item.hasLoaded && PictureManager.getInstance().checkNetworkConnect()) {
                if (this.f49605l0) {
                    super.I0(i3, item.progress);
                }
            } else {
                k2(i3, item.hasLoaded);
                this.f49605l0 = false;
            }
        }
    }

    @Override // com.tencent.common.galleryactivity.d
    public void I0(final int i3, final int i16) {
        this.f49605l0 = false;
        int i17 = this.f49606m0;
        if (i17 < 0) {
            final long currentTimeMillis = System.currentTimeMillis();
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.qzone.preview.PictureAdapter.15
                @Override // java.lang.Runnable
                public void run() {
                    int currentTimeMillis2 = (int) (System.currentTimeMillis() - currentTimeMillis);
                    PictureAdapter.this.f49606m0 = QZoneConfigHelper.D0();
                    PictureAdapter.this.m0(i3, i16, PictureAdapter.this.f49606m0 - currentTimeMillis2 > 0 ? PictureAdapter.this.f49606m0 - currentTimeMillis2 : 0);
                }
            });
        } else {
            m0(i3, i16, i17);
        }
    }

    private boolean a0(PhotoInfo photoInfo) {
        VideoInfo videoInfo;
        VideoUrl videoUrl;
        if (photoInfo == null || (videoInfo = photoInfo.videodata) == null || (videoUrl = videoInfo.videoUrl) == null || TextUtils.isEmpty(videoUrl.url)) {
            return false;
        }
        String str = photoInfo.videodata.videoUrl.url;
        return str.startsWith("/storage") || str.startsWith("/data");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c0(PhotoInfo photoInfo) {
        return (photoInfo == null || photoInfo.videoflag != 1 || photoInfo.videodata == null) ? false : true;
    }

    protected void Y(final PhotoInfo photoInfo, final String str) {
        QZLog.d("[PhotoAlbum]FaceFuntion", 1, "checkFace | photoInfo.hasCheckFace:", Boolean.valueOf(photoInfo.hasCheckFace), " lloc:", str, " containsKey(lloc):", Boolean.valueOf(this.f49604k0.containsKey(str)), " photoInfo.needShowFaceIcon:", Boolean.valueOf(photoInfo.needShowFaceIcon));
        if (!photoInfo.hasCheckFace && !this.f49604k0.containsKey(str)) {
            this.f49604k0.put(str, Boolean.TRUE);
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.preview.PictureAdapter.13
                @Override // java.lang.Runnable
                public void run() {
                    final Bitmap bitmap;
                    PictureAdapter pictureAdapter = PictureAdapter.this;
                    pictureAdapter.f49603j0.m(pictureAdapter.N.getHostActivity());
                    long currentTimeMillis = System.currentTimeMillis();
                    if (URLUtil.isNetworkUrl(str)) {
                        bitmap = null;
                    } else {
                        bitmap = com.qzone.util.image.c.l(str);
                        QZLog.d("[PhotoAlbum]FaceFuntion", 1, "[Performance] getSelectedPicBitmap cost time:", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), " lloc:", str);
                        ReportUtils.a("faceReport", ITDocAttaReporterApi.REPORT_ACTION_PERFORMANCE, "faceCompressBitmap", (int) (System.currentTimeMillis() - currentTimeMillis));
                    }
                    if (bitmap == null) {
                        QZLog.e("[PhotoAlbum]FaceFuntion", "mSelectedPicBmp == null");
                        return;
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    final FaceTarget i3 = PictureAdapter.this.f49603j0.i(bitmap);
                    QZLog.d("[PhotoAlbum]FaceFuntion", 1, "[Performance] faceDetect cost time:", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2), " lloc:", str);
                    ReportUtils.a("faceReport", ITDocAttaReporterApi.REPORT_ACTION_PERFORMANCE, "faceCheckDetect", (int) (System.currentTimeMillis() - currentTimeMillis2));
                    if (i3 != null && i3.faces != null) {
                        i3.width = bitmap.getWidth();
                        i3.height = bitmap.getHeight();
                        photoInfo.needShowFaceIcon = true;
                        PictureAdapter.this.f0(i3, str);
                        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.preview.PictureAdapter.13.2
                            @Override // java.lang.Runnable
                            public void run() {
                                int t16 = com.qzone.album.env.common.a.m().t("QZoneSetting", QzoneConfig.SECONDARY_UPLOAD_CHECK_FACE_NUM, 10);
                                HashMap hashMap = new HashMap(1);
                                FaceStatus[] faceStatusArr = i3.faces;
                                hashMap.put("faceSize", String.valueOf(faceStatusArr.length < t16 ? faceStatusArr.length : t16));
                                ReportUtils.b("faceData", hashMap);
                                QZLog.d("[PhotoAlbum]FaceFuntion", 1, "target size:", Integer.valueOf(i3.size), " MaxNum:", Integer.valueOf(t16), " lloc:" + str);
                                try {
                                    ArrayList<float[]> arrayList = new ArrayList<>();
                                    long currentTimeMillis3 = System.currentTimeMillis();
                                    int i16 = 0;
                                    while (true) {
                                        FaceStatus[] faceStatusArr2 = i3.faces;
                                        if (i16 >= faceStatusArr2.length || i16 >= t16) {
                                            break;
                                        }
                                        arrayList.add(q4.a.k(bitmap, 1, faceStatusArr2[i16].xys));
                                        i16++;
                                    }
                                    ReportUtils.a("faceReport", ITDocAttaReporterApi.REPORT_ACTION_PERFORMANCE, "faceFeature", (int) (System.currentTimeMillis() - currentTimeMillis3));
                                    QZLog.d("[PhotoAlbum]FaceFuntion", 1, "[Performance] getFaceFeature cost time:", Long.valueOf(System.currentTimeMillis() - currentTimeMillis3), " lloc:", str);
                                    PictureManager.getInstance().cloudBatchFaceRecognize(PictureAdapter.this.P.J(), arrayList, i3, str);
                                } catch (OutOfMemoryError e16) {
                                    e16.printStackTrace();
                                    QZLog.e("[PhotoAlbum]FaceFuntion", "send face feature out of memory");
                                }
                            }
                        });
                        return;
                    }
                    PhotoInfo photoInfo2 = photoInfo;
                    photoInfo2.hasCheckFace = true;
                    photoInfo2.needShowFaceIcon = false;
                    QZLog.e("[PhotoAlbum]FaceFuntion", "no faces");
                    PictureAdapter.this.N.getHostActivity().runOnUiThread(new Runnable() { // from class: com.qzone.preview.PictureAdapter.13.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PictureAdapter.this.N.d1(false);
                        }
                    });
                }
            });
        } else {
            this.N.d1(photoInfo.needShowFaceIcon);
        }
    }

    public void j0(int i3, View view, RegionDrawableData regionDrawableData) {
        if (regionDrawableData == null || !FaceRelativeLayout.class.isInstance(view)) {
            return;
        }
        Drawable drawable = ((FaceRelativeLayout) view).f49533d.getDrawable();
        if (RegionDrawable.class.isInstance(drawable)) {
            ((RegionDrawable) drawable).updateRegionRect(regionDrawableData);
        }
    }

    private void n0(PhotoInfo photoInfo) {
        VideoInfo videoInfo;
        QzoneAlbumVideoView qzoneAlbumVideoView;
        if (photoInfo == null) {
            return;
        }
        VideoPlayInfo a16 = ae.a(photoInfo.videodata);
        if (a0(photoInfo)) {
            FaceRelativeLayout faceRelativeLayout = this.X;
            if (faceRelativeLayout == null || (qzoneAlbumVideoView = faceRelativeLayout.f49536h) == null) {
                return;
            }
            qzoneAlbumVideoView.setVisibility(0);
            return;
        }
        if (a16 != null && a16.videoId != null && !BaseVideoManagerUtils.getOriginalVideoMap().containsKey(a16.videoId)) {
            QZLog.d("PictureAdapter", 1, "photo video has not been installed in cache, start init");
            if (this.X == null || (videoInfo = photoInfo.videodata) == null || videoInfo.originVideoSize == 0 || !b0()) {
                return;
            }
            String a17 = l.a(R.string.f172293p73);
            this.f49601h0 = a17;
            TextView textView = this.X.f49538m;
            if (textView != null) {
                textView.setText(a17);
                this.X.f49538m.setTextColor(Color.parseColor("#CCCCCC"));
                FaceRelativeLayout faceRelativeLayout2 = this.X;
                faceRelativeLayout2.f49536h.setOriginalVideoBtn(faceRelativeLayout2.f49538m);
                return;
            }
            return;
        }
        this.X.f49536h.k();
        QZLog.d("PictureAdapter", 1, "photo video has been installed in cache");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class PictureLoadListener implements AsyncImageable.AsyncImageListener {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<FaceRelativeLayout> f49627d;

        /* renamed from: e, reason: collision with root package name */
        private PhotoInfo f49628e;

        /* renamed from: f, reason: collision with root package name */
        private int f49629f;

        public PictureLoadListener(FaceRelativeLayout faceRelativeLayout, PhotoInfo photoInfo, int i3) {
            this.f49627d = new WeakReference<>(faceRelativeLayout);
            this.f49628e = photoInfo;
            this.f49629f = i3;
        }

        private FaceRelativeLayout c() {
            WeakReference<FaceRelativeLayout> weakReference = this.f49627d;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageFailed(AsyncImageable asyncImageable) {
            if (this.f49628e == null) {
                QZLog.e("PictureAdapter", "onImageFailed: photoInfo is null");
            } else {
                QZLog.e("PictureAdapter", "onImageFailed: " + aj.d(this.f49628e, this.f49629f));
            }
            PictureAdapter.this.k2(this.f49629f, false);
            if (this.f49629f == PictureAdapter.this.P.getSelectedIndex()) {
                ToastUtil.n(R.string.ggu);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:48:0x015c  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x015e  */
        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onImageLoaded(AsyncImageable asyncImageable) {
            ArrayList<ImageTagInfo> arrayList;
            String str;
            int i3;
            if (this.f49628e == null) {
                QZLog.e("PictureAdapter", "onImageLoaded: photoInfo is null");
            } else if (QZLog.isDevelopLevel()) {
                QZLog.d("PictureAdapter", 4, "onImageLoaded: " + aj.d(this.f49628e, this.f49629f));
            }
            PhotoInfo photoInfo = this.f49628e;
            int i16 = 2;
            if (photoInfo != null && photoInfo.photoType != 2) {
                if ((PictureAdapter.this.N instanceof LocalPictureViewer) && !URLUtil.isNetworkUrl(this.f49628e.bigUrl)) {
                    QZLog.d("[PhotoAlbum]FaceFuntion", 2, "LocalPictureViewer onImageLoaded");
                    if (PictureAdapter.this.P != null && PictureAdapter.this.P.A == 1) {
                        PictureAdapter pictureAdapter = PictureAdapter.this;
                        PhotoInfo photoInfo2 = this.f49628e;
                        pictureAdapter.Y(photoInfo2, photoInfo2.bigUrl);
                    }
                } else {
                    QZLog.d("[PhotoAlbum]FaceFuntion", 2, "feed onImageLoaded imageable.getDrawable():", asyncImageable.getDrawable());
                }
            }
            PictureAdapter.this.k2(this.f49629f, true);
            PhotoInfo photoInfo3 = this.f49628e;
            if (photoInfo3 != null) {
                photoInfo3.hasLoaded = true;
                photoInfo3.progress = 100;
                final FaceRelativeLayout c16 = c();
                if (c16 == null || c16.getVisibility() != 0) {
                    return;
                }
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.preview.PictureAdapter.PictureLoadListener.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            String i17 = c16.f49533d.i();
                            if (ImageLoader.getInstance().getImageFile(i17) != null) {
                                PictureLoadListener.this.f49628e.fileSize = ImageLoader.getInstance().getImageFile(i17).length();
                            }
                            if (TextUtils.isEmpty(i17)) {
                                return;
                            }
                            if (i17.equals(PictureLoadListener.this.f49628e.bigUrl)) {
                                PictureLoadListener.this.f49628e.imageResolution = 1;
                            } else if (i17.equals(PictureLoadListener.this.f49628e.orgUrl)) {
                                PictureLoadListener.this.f49628e.imageResolution = 2;
                            }
                        } catch (Exception e16) {
                            QZLog.e("PictureAdapter", "get image file size exception ", e16);
                        }
                    }
                });
                c16.f49534e.setVisibility(8);
                if (this.f49628e != null && PictureAdapter.this.N.getShowType() == 0) {
                    boolean isPanorama = this.f49628e.isPanorama();
                    ((IPanoramaUtil) QRoute.api(IPanoramaUtil.class)).reportMta("qzone_gallery", "expose", 0);
                    if (isPanorama) {
                        PhotoInfo photoInfo4 = (PhotoInfo) PictureAdapter.this.getItem(this.f49629f);
                        if (TextUtils.isEmpty(photoInfo4.bigUrl)) {
                            str = photoInfo4.currentUrl;
                        } else {
                            str = photoInfo4.bigUrl;
                        }
                        if (!TextUtils.isEmpty(photoInfo4.orgUrl)) {
                            str = photoInfo4.orgUrl;
                        }
                        String str2 = str;
                        int i17 = photoInfo4.flag;
                        if (i17 != 16) {
                            if (i17 == 32) {
                                i3 = 0;
                                boolean z16 = PictureAdapter.this.getCount() != 1 && photoInfo4.isPanorama() && photoInfo4.appid == 311;
                                ((IPanoramaLoadingLayout) QRoute.api(IPanoramaLoadingLayout.class)).showLoading(c16.C, ((IPanoramaLoadingLayout) QRoute.api(IPanoramaLoadingLayout.class)).isPanoramaLoading(), true);
                                c16.C.setVisibility(0);
                                c16.d(PictureAdapter.this.N.getHostActivity(), str2, i3, PictureAdapter.this.f49599f0 != 1, z16);
                            } else {
                                i16 = -1;
                            }
                        }
                        i3 = i16;
                        if (PictureAdapter.this.getCount() != 1) {
                        }
                        ((IPanoramaLoadingLayout) QRoute.api(IPanoramaLoadingLayout.class)).showLoading(c16.C, ((IPanoramaLoadingLayout) QRoute.api(IPanoramaLoadingLayout.class)).isPanoramaLoading(), true);
                        c16.C.setVisibility(0);
                        c16.d(PictureAdapter.this.N.getHostActivity(), str2, i3, PictureAdapter.this.f49599f0 != 1, z16);
                    } else {
                        c16.C.setVisibility(8);
                    }
                }
                if (TextUtils.isEmpty(this.f49628e.bigUrl) || (arrayList = this.f49628e.tagList) == null || arrayList.isEmpty() || PictureAdapter.this.P == null) {
                    return;
                }
                c16.f49533d.a(PictureAdapter.this.P.T());
            }
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageStarted(AsyncImageable asyncImageable) {
            if (this.f49628e == null) {
                QZLog.e("PictureAdapter", "onImageStarted: photoInfo is null");
                return;
            }
            if (QZLog.isDevelopLevel()) {
                QZLog.d("PictureAdapter", 4, "onImageStarted: " + aj.d(this.f49628e, this.f49629f));
            }
            PhotoInfo photoInfo = this.f49628e;
            if (!photoInfo.hasLoaded) {
                PictureAdapter.this.I0(this.f49629f, photoInfo.progress);
            }
            c();
            if (PictureAdapter.this.P == null || PictureAdapter.this.P.getCount() <= 1) {
                return;
            }
            PictureAdapter.this.P.J().postDelayed(new Runnable() { // from class: com.qzone.preview.PictureAdapter.PictureLoadListener.1
                @Override // java.lang.Runnable
                public void run() {
                    if (PictureLoadListener.this.f49628e.hasLoaded) {
                        return;
                    }
                    PictureLoadListener pictureLoadListener = PictureLoadListener.this;
                    PictureAdapter.super.I0(pictureLoadListener.f49629f, PictureLoadListener.this.f49628e.progress);
                    PictureAdapter.this.f49605l0 = true;
                }
            }, 1500L);
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageProgress(AsyncImageable asyncImageable, float f16) {
            int i3 = (int) (f16 * 100.0f);
            if (i3 > 99) {
                i3 = 99;
            }
            this.f49628e.progress = i3;
            PictureAdapter.this.q(this.f49629f, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements AsyncImageable.AsyncImageListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ PictureImageView f49634d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ PhotoInfo f49635e;

        a(PictureImageView pictureImageView, PhotoInfo photoInfo) {
            this.f49634d = pictureImageView;
            this.f49635e = photoInfo;
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageLoaded(AsyncImageable asyncImageable) {
            PictureImageView pictureImageView = this.f49634d;
            if (pictureImageView == null || this.f49635e.hasLoaded) {
                return;
            }
            pictureImageView.setVisibility(0);
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageFailed(AsyncImageable asyncImageable) {
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageStarted(AsyncImageable asyncImageable) {
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageProgress(AsyncImageable asyncImageable, float f16) {
        }
    }
}
