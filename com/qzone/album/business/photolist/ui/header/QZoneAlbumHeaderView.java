package com.qzone.album.business.photolist.ui.header;

import NS_MOBILE_MATERIAL.CustomAlbumItem;
import NS_MOBILE_MATERIAL.MaterialFile;
import NS_MOBILE_PHOTO.PhotoDetailPageBanner;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.qzone.adapter.feedcomponent.s;
import com.qzone.album.business.downloader.DownloadQueue;
import com.qzone.album.business.photolist.controller.ViewerModelController;
import com.qzone.album.business.photolist.ui.SharingOwnersListBar;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.data.model.PhotoPoiArea;
import com.qzone.album.data.model.SharingAlbumClientAttr;
import com.qzone.album.data.model.TravelAlbumData;
import com.qzone.album.protocol.AbsCompatRequest;
import com.qzone.album.protocol.QZoneNegativeFeedbackRequest;
import com.qzone.album.protocol.QZonePhotoListRequest;
import com.qzone.album.ui.widget.LoveWave;
import com.qzone.album.util.QZoneAlbumUtil;
import com.qzone.common.account.LoginData;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.widget.SafeTextView;
import com.qzone.util.ar;
import com.qzone.widget.AsyncImageView;
import com.qzone.widget.AsyncImageable;
import com.qzone.widget.AvatarImageView;
import com.qzone.widget.QzoneGuideBubbleHelper;
import com.tencent.aelight.camera.api.IAEEditorManagerForQzone;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.processor.SpecifiedSizeCropByPivotProcessor;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.mapview.QTextureMapView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.Projection;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.UiSettings;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tencent.view.FilterEnum;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.QZonePermission;
import cooperation.qzone.widget.RoundCornerLinearLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneAlbumHeaderView extends FrameLayout {

    /* renamed from: x2, reason: collision with root package name */
    private static boolean f43375x2 = u5.b.D("key_first_time_create_share_album", true);

    /* renamed from: y2, reason: collision with root package name */
    private static boolean f43376y2 = u5.b.D("key_first_time_enter_album_photo_list", true);
    private LinearLayout A0;
    private long A1;
    private TextView B0;
    private long B1;
    private View C;
    private RelativeLayout C0;
    private boolean C1;
    private View D;
    private Button D0;
    private boolean D1;
    private ViewStub E;
    private ImageView E0;
    private boolean E1;
    private ViewStub F;
    private boolean F0;
    private int F1;
    private ViewStub G;
    private View G0;
    private u4.g G1;
    private ViewStub H;
    private ViewSwitcher H0;
    private Runnable H1;
    private View I;
    private AsyncImageView I0;
    private AsyncImageable.AsyncImageListener I1;
    private View J;
    private AsyncImageView J0;
    private u4.h J1;
    private View K;
    private TextView K0;
    private int K1;
    private View L;
    private TextView L0;
    private RoundCornerLinearLayout L1;
    private View M;
    private ImageView M0;
    private TextView M1;
    private boolean N;
    private com.qzone.album.ui.widget.d N0;
    private boolean N1;
    private ViewGroup O0;
    private int O1;
    private View P;
    private TextView P0;
    private String P1;
    private AsyncImageView Q;
    private SafeTextView Q0;
    private Drawable Q1;
    private ViewGroup R;
    private LinearLayout R0;
    private Drawable R1;
    private LinearLayout S;
    private SafeTextView S0;
    private QZoneAlbumUtil.f S1;
    private SafeTextView T;
    private ViewGroup T0;
    private QZoneAlbumUtil.f T1;
    private SafeTextView U;
    private ViewGroup U0;
    private List<PhotoCacheData> U1;
    private RelativeLayout V;
    private CellTextView V0;
    private int V1;
    private View.OnClickListener W;
    private QTextureMapView W0;
    private int W1;
    double X0;
    private Animation X1;
    double Y0;
    private Animation Y1;
    double Z0;
    private ViewerModelController Z1;

    /* renamed from: a0, reason: collision with root package name */
    private View.OnClickListener f43377a0;

    /* renamed from: a1, reason: collision with root package name */
    double f43378a1;

    /* renamed from: a2, reason: collision with root package name */
    private Timer f43379a2;

    /* renamed from: b0, reason: collision with root package name */
    private View.OnClickListener f43380b0;

    /* renamed from: b1, reason: collision with root package name */
    double f43381b1;

    /* renamed from: b2, reason: collision with root package name */
    private TimerTask f43382b2;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f43383c0;

    /* renamed from: c1, reason: collision with root package name */
    double f43384c1;

    /* renamed from: c2, reason: collision with root package name */
    public volatile boolean f43385c2;

    /* renamed from: d, reason: collision with root package name */
    private boolean f43386d;

    /* renamed from: d0, reason: collision with root package name */
    private ImageView f43387d0;

    /* renamed from: d1, reason: collision with root package name */
    double f43388d1;

    /* renamed from: d2, reason: collision with root package name */
    private Handler f43389d2;

    /* renamed from: e, reason: collision with root package name */
    private Activity f43390e;

    /* renamed from: e0, reason: collision with root package name */
    private TextView f43391e0;

    /* renamed from: e1, reason: collision with root package name */
    double f43392e1;

    /* renamed from: e2, reason: collision with root package name */
    private Runnable f43393e2;

    /* renamed from: f, reason: collision with root package name */
    private boolean f43394f;

    /* renamed from: f0, reason: collision with root package name */
    private LinearLayout f43395f0;

    /* renamed from: f1, reason: collision with root package name */
    int f43396f1;

    /* renamed from: f2, reason: collision with root package name */
    protected View.OnClickListener f43397f2;

    /* renamed from: g0, reason: collision with root package name */
    private RelativeLayout f43398g0;

    /* renamed from: g1, reason: collision with root package name */
    ArrayList<PhotoPoiArea> f43399g1;

    /* renamed from: g2, reason: collision with root package name */
    AddPoiOnMapRunnable f43400g2;

    /* renamed from: h, reason: collision with root package name */
    private int f43401h;

    /* renamed from: h0, reason: collision with root package name */
    private LinearLayout f43402h0;

    /* renamed from: h1, reason: collision with root package name */
    ArrayList<Long> f43403h1;

    /* renamed from: h2, reason: collision with root package name */
    private List<String> f43404h2;

    /* renamed from: i, reason: collision with root package name */
    private AlbumCacheData f43405i;

    /* renamed from: i0, reason: collision with root package name */
    private TextView f43406i0;

    /* renamed from: i1, reason: collision with root package name */
    boolean f43407i1;

    /* renamed from: i2, reason: collision with root package name */
    private Marker f43408i2;

    /* renamed from: j0, reason: collision with root package name */
    private RelativeLayout f43409j0;

    /* renamed from: j1, reason: collision with root package name */
    int f43410j1;

    /* renamed from: j2, reason: collision with root package name */
    View.OnClickListener f43411j2;

    /* renamed from: k0, reason: collision with root package name */
    private com.qzone.album.business.photolist.ui.header.b f43412k0;

    /* renamed from: k1, reason: collision with root package name */
    int f43413k1;

    /* renamed from: k2, reason: collision with root package name */
    View.OnClickListener f43414k2;

    /* renamed from: l0, reason: collision with root package name */
    private com.qzone.album.business.photolist.ui.a f43415l0;

    /* renamed from: l1, reason: collision with root package name */
    private int f43416l1;

    /* renamed from: l2, reason: collision with root package name */
    View.OnClickListener f43417l2;

    /* renamed from: m, reason: collision with root package name */
    private boolean f43418m;

    /* renamed from: m0, reason: collision with root package name */
    private RelativeLayout f43419m0;

    /* renamed from: m1, reason: collision with root package name */
    private LinearLayout f43420m1;

    /* renamed from: m2, reason: collision with root package name */
    View.OnClickListener f43421m2;

    /* renamed from: n0, reason: collision with root package name */
    private SharingOwnersListBar f43422n0;

    /* renamed from: n1, reason: collision with root package name */
    private RelativeLayout f43423n1;

    /* renamed from: n2, reason: collision with root package name */
    View.OnClickListener f43424n2;

    /* renamed from: o0, reason: collision with root package name */
    private TextView f43425o0;

    /* renamed from: o1, reason: collision with root package name */
    private TextView f43426o1;

    /* renamed from: o2, reason: collision with root package name */
    View.OnClickListener f43427o2;

    /* renamed from: p0, reason: collision with root package name */
    private ImageView f43428p0;

    /* renamed from: p1, reason: collision with root package name */
    private LinearLayout f43429p1;

    /* renamed from: p2, reason: collision with root package name */
    View.OnClickListener f43430p2;

    /* renamed from: q0, reason: collision with root package name */
    private View f43431q0;

    /* renamed from: q1, reason: collision with root package name */
    private LinearLayout f43432q1;

    /* renamed from: q2, reason: collision with root package name */
    View.OnClickListener f43433q2;

    /* renamed from: r0, reason: collision with root package name */
    private ViewGroup f43434r0;

    /* renamed from: r1, reason: collision with root package name */
    private CellTextView f43435r1;

    /* renamed from: r2, reason: collision with root package name */
    View.OnClickListener f43436r2;

    /* renamed from: s0, reason: collision with root package name */
    private Button f43437s0;

    /* renamed from: s1, reason: collision with root package name */
    private CellTextView f43438s1;

    /* renamed from: s2, reason: collision with root package name */
    View.OnClickListener f43439s2;

    /* renamed from: t0, reason: collision with root package name */
    private ViewGroup f43440t0;

    /* renamed from: t1, reason: collision with root package name */
    private CellTextView f43441t1;

    /* renamed from: t2, reason: collision with root package name */
    private boolean f43442t2;

    /* renamed from: u0, reason: collision with root package name */
    private View f43443u0;

    /* renamed from: u1, reason: collision with root package name */
    private CellTextView f43444u1;

    /* renamed from: u2, reason: collision with root package name */
    private String f43445u2;

    /* renamed from: v0, reason: collision with root package name */
    private TextView f43446v0;

    /* renamed from: v1, reason: collision with root package name */
    private LinearLayout f43447v1;

    /* renamed from: v2, reason: collision with root package name */
    private boolean f43448v2;

    /* renamed from: w0, reason: collision with root package name */
    private View f43449w0;

    /* renamed from: w1, reason: collision with root package name */
    private AvatarImageView f43450w1;

    /* renamed from: w2, reason: collision with root package name */
    private boolean f43451w2;

    /* renamed from: x0, reason: collision with root package name */
    private RelativeLayout f43452x0;

    /* renamed from: x1, reason: collision with root package name */
    private AvatarImageView f43453x1;

    /* renamed from: y0, reason: collision with root package name */
    private TextView f43454y0;

    /* renamed from: y1, reason: collision with root package name */
    private LoveWave f43455y1;

    /* renamed from: z0, reason: collision with root package name */
    private TextView f43456z0;

    /* renamed from: z1, reason: collision with root package name */
    private AsyncImageView f43457z1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.qzone.album.business.photolist.ui.header.QZoneAlbumHeaderView$3, reason: invalid class name */
    /* loaded from: classes39.dex */
    public class AnonymousClass3 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f43469d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f43470e;

        AnonymousClass3(String str, View view) {
            this.f43469d = str;
            this.f43470e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageLoader.getInstance().loadImageAsync(this.f43469d, new QZoneAlbumUtil.f() { // from class: com.qzone.album.business.photolist.ui.header.QZoneAlbumHeaderView.3.1
                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageLoaded(String str, final Drawable drawable, ImageLoader.Options options) {
                    com.qzone.album.env.common.a.m().b("[PhotoAlbum] QZoneAlbumHeaderView", "setCoverImageUrl#onImageLoaded");
                    QZoneAlbumHeaderView.this.f43390e.runOnUiThread(new Runnable() { // from class: com.qzone.album.business.photolist.ui.header.QZoneAlbumHeaderView.3.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass3.this.f43470e.setBackgroundDrawable(drawable);
                        }
                    });
                }
            });
        }
    }

    /* compiled from: P */
    /* renamed from: com.qzone.album.business.photolist.ui.header.QZoneAlbumHeaderView$4, reason: invalid class name */
    /* loaded from: classes39.dex */
    class AnonymousClass4 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f43478d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f43479e;
        final /* synthetic */ QZoneAlbumHeaderView this$0;

        @Override // java.lang.Runnable
        public void run() {
            ImageLoader.getInstance().loadImageAsync(QzoneConfig.DEFAULT_BABY_ALBUM_LEFT_BG_URL, new QZoneAlbumUtil.f() { // from class: com.qzone.album.business.photolist.ui.header.QZoneAlbumHeaderView.4.1
                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageLoaded(String str, final Drawable drawable, ImageLoader.Options options) {
                    com.qzone.album.env.common.a.m().b("[PhotoAlbum] QZoneAlbumHeaderView", "setCoverImageUrl#onImageLoaded");
                    AnonymousClass4.this.this$0.f43390e.runOnUiThread(new Runnable() { // from class: com.qzone.album.business.photolist.ui.header.QZoneAlbumHeaderView.4.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass4.this.f43478d.setBackgroundDrawable(drawable);
                        }
                    });
                }
            });
            ImageLoader.getInstance().loadImageAsync(QzoneConfig.DEFAULT_BABY_ALBUM_RIGHT_BG_URL, new QZoneAlbumUtil.f() { // from class: com.qzone.album.business.photolist.ui.header.QZoneAlbumHeaderView.4.2
                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageLoaded(String str, final Drawable drawable, ImageLoader.Options options) {
                    com.qzone.album.env.common.a.m().b("[PhotoAlbum] QZoneAlbumHeaderView", "setCoverImageUrl#onImageLoaded");
                    AnonymousClass4.this.this$0.f43390e.runOnUiThread(new Runnable() { // from class: com.qzone.album.business.photolist.ui.header.QZoneAlbumHeaderView.4.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass4.this.f43479e.setBackgroundDrawable(drawable);
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class AddPoiOnMapRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        ArrayList<PhotoPoiArea> f43494d;

        public AddPoiOnMapRunnable(ArrayList<PhotoPoiArea> arrayList) {
            this.f43494d = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                QZoneAlbumHeaderView.this.M(this.f43494d);
            } catch (Throwable th5) {
                QZLog.e("[PhotoAlbum] QZoneAlbumHeaderView", "exception:", th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a extends QZoneAlbumUtil.f {
        a() {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            QZoneAlbumHeaderView.this.f43443u0.setBackgroundDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b extends QZoneAlbumUtil.f {
        b() {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            QZoneAlbumHeaderView.this.f43449w0.setBackgroundDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c extends QZoneAlbumUtil.f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SafeTextView f43497d;

        c(SafeTextView safeTextView) {
            this.f43497d = safeTextView;
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            this.f43497d.setBackgroundDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class d extends QZoneAlbumUtil.f {
        d() {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            QZoneAlbumHeaderView.this.p0(drawable, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class e extends QZoneAlbumUtil.f {
        e() {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            QZoneAlbumHeaderView.this.p0(drawable, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class f implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ViewerModelController f43501d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QZonePhotoListRequest.a f43502e;

        /* compiled from: P */
        /* loaded from: classes39.dex */
        class a implements AbsCompatRequest.a {
            a() {
            }

            @Override // com.qzone.album.protocol.AbsCompatRequest.a
            public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
                com.qzone.album.env.common.a.m().b("[PhotoAlbum] QZoneAlbumHeaderView", "QZoneNegativeFeedbackRequest has send");
            }
        }

        f(ViewerModelController viewerModelController, QZonePhotoListRequest.a aVar) {
            this.f43501d = viewerModelController;
            this.f43502e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZoneAlbumHeaderView.this.G0.setVisibility(8);
            QZoneNegativeFeedbackRequest qZoneNegativeFeedbackRequest = new QZoneNegativeFeedbackRequest(this.f43501d.S.longValue(), this.f43502e.f43961c.albumid);
            qZoneNegativeFeedbackRequest.setCallback(new a());
            u4.a.z().D().c(qZoneNegativeFeedbackRequest, null);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class g extends Handler {
        g(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 10) {
                return;
            }
            QZoneAlbumHeaderView.this.r0();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QZonePermission.requestStoragePermission((Activity) QZoneAlbumHeaderView.this.getContext(), QQPermissionConstants.Business.SCENE.QQ_QZONE_VIDEO_EDIT_READ_MEDIA)) {
                LpReportInfo_pf00064.allReport(326, 20, 2);
                DownloadQueue.j().B();
                QZoneAlbumHeaderView.this.Z1.l5(QZoneAlbumHeaderView.this.Z1.Y.f43969k, QZoneAlbumHeaderView.this.Z1.Y.f43967i);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QZoneAlbumHeaderView.this.A1 > 0) {
                ClickReport.c(326, 2, "27", false, null);
                com.qzone.album.env.common.a.m().G(QZoneAlbumHeaderView.this.f43390e, QZoneAlbumHeaderView.this.A1);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class k implements TencentMap.OnMapClickListener {
        k() {
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapClickListener
        public void onMapClick(LatLng latLng) {
            if (QZoneAlbumHeaderView.this.f43408i2 == null || TextUtils.isEmpty(QZoneAlbumHeaderView.this.f43408i2.getTitle())) {
                return;
            }
            QZoneAlbumHeaderView.this.f43408i2.setTitle("");
            QZoneAlbumHeaderView.this.f43408i2 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class m implements View.OnClickListener {
        m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QZoneAlbumHeaderView.this.B1 <= 0) {
                if (QZoneAlbumHeaderView.this.f43405i != null && ((QZoneAlbumHeaderView.this.f43405i.isSharingAlbumCreator() || QZoneAlbumHeaderView.this.f43405i.isUnsharingAlbumCreator()) && QZoneAlbumHeaderView.this.f43421m2 != null)) {
                    ClickReport.c(326, 2, "28", false, null);
                    QZoneAlbumHeaderView.this.f43421m2.onClick(view);
                }
            } else {
                ClickReport.c(326, 2, "27", false, null);
                com.qzone.album.env.common.a.m().G(QZoneAlbumHeaderView.this.f43390e, QZoneAlbumHeaderView.this.B1);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class n implements View.OnClickListener {
        n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QZoneAlbumHeaderView.this.f43452x0 != null) {
                QZoneAlbumHeaderView.this.F0 = true;
                QZoneAlbumHeaderView.this.f43452x0.setVisibility(8);
                LpReportInfo_pf00064.allReport(326, 2, Integer.parseInt("18"));
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class o implements View.OnClickListener {
        o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QZoneAlbumHeaderView.this.f43452x0 != null) {
                QZoneAlbumHeaderView.this.F0 = true;
                QZoneAlbumHeaderView.this.f43452x0.setVisibility(8);
                LpReportInfo_pf00064.allReport(326, 2, Integer.parseInt("21"));
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class p extends AnimatorListenerAdapter {
        p() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QZoneAlbumHeaderView.this.E1 = false;
            QZoneAlbumHeaderView.this.A0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class r extends QZoneAlbumUtil.f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SafeTextView f43517d;

        r(SafeTextView safeTextView) {
            this.f43517d = safeTextView;
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            this.f43517d.setBackgroundDrawable(drawable);
        }
    }

    public QZoneAlbumHeaderView(Context context) {
        super(context);
        this.f43386d = false;
        this.f43394f = false;
        this.f43418m = false;
        this.N = true;
        this.W0 = null;
        this.X0 = -500.0d;
        this.Y0 = -500.0d;
        this.Z0 = 500.0d;
        this.f43378a1 = 500.0d;
        this.f43381b1 = 0.0d;
        this.f43384c1 = 0.0d;
        this.f43388d1 = 0.0d;
        this.f43392e1 = 0.0d;
        this.f43396f1 = 0;
        this.f43407i1 = false;
        this.f43410j1 = 0;
        this.f43413k1 = 0;
        this.f43416l1 = FilterEnum.MIC_PTU_TRANS_XINXIAN;
        this.C1 = false;
        this.D1 = false;
        this.E1 = false;
        this.F1 = 0;
        this.K1 = 86400;
        this.N1 = false;
        this.O1 = -1;
        this.P1 = "";
        this.Q1 = null;
        this.R1 = null;
        this.U1 = new ArrayList();
        this.V1 = 1;
        this.W1 = 1;
        this.f43389d2 = new g(Looper.getMainLooper());
        this.f43393e2 = new Runnable() { // from class: com.qzone.album.business.photolist.ui.header.QZoneAlbumHeaderView.18
            @Override // java.lang.Runnable
            public void run() {
                if (((IAEEditorManagerForQzone) QRoute.api(IAEEditorManagerForQzone.class)).isCameraResReady()) {
                    QZoneAlbumHeaderView.this.G0.setVisibility(0);
                    LpReportInfo_pf00064.allReport(326, 20, 1);
                } else {
                    if (QZoneAlbumHeaderView.this.f43385c2) {
                        return;
                    }
                    RFWThreadManager.getUIHandler().postDelayed(QZoneAlbumHeaderView.this.f43393e2, 1000L);
                }
            }
        };
        this.f43397f2 = new h();
        this.f43404h2 = new ArrayList();
        this.f43442t2 = false;
        this.f43445u2 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumSomeoneInviteYouToJoin", "%s\u9080\u8bf7\u4f60\u52a0\u5165\u76f8\u518c\uff0c\u4e00\u8d77\u4e0a\u4f20\u7167\u7247/\u89c6\u9891");
        this.f43448v2 = false;
        this.f43451w2 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0() {
        if (!this.D1 || this.C1) {
            return;
        }
        if (this.H1 == null) {
            this.H1 = new Runnable() { // from class: com.qzone.album.business.photolist.ui.header.QZoneAlbumHeaderView.35
                @Override // java.lang.Runnable
                public void run() {
                    QZoneAlbumHeaderView.this.U();
                }
            };
        }
        Handler handler = getHandler();
        if (handler != null) {
            handler.postDelayed(this.H1, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(final Drawable drawable, final String str) {
        this.f43390e.runOnUiThread(new Runnable() { // from class: com.qzone.album.business.photolist.ui.header.QZoneAlbumHeaderView.7
            @Override // java.lang.Runnable
            public void run() {
                com.qzone.album.env.common.a.m().b("[PhotoAlbum] QZoneAlbumHeaderView", "setCover | d :", drawable);
                Drawable drawable2 = drawable;
                if (drawable2 == null) {
                    QZoneAlbumHeaderView.this.f43418m = false;
                    QZoneAlbumHeaderView.this.D0();
                    return;
                }
                if (drawable2 instanceof BitmapDrawable) {
                    QZoneAlbumHeaderView.this.C0((BitmapDrawable) drawable2, str);
                } else {
                    QZoneAlbumHeaderView.this.Q.setImageDrawable(drawable);
                }
                QZoneAlbumHeaderView.this.f43418m = true;
                QZoneAlbumHeaderView.this.E0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(BitmapDrawable bitmapDrawable, String str) {
        setImageProcessor(this.Q, bitmapDrawable.getBitmap().getWidth(), bitmapDrawable.getBitmap().getHeight(), com.tencent.mobileqq.utils.e.k(), 1.0f, ar.l(), ar.d(this.f43416l1));
        this.Q.setAsyncImage(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0() {
        AsyncImageView asyncImageView = this.Q;
        if (asyncImageView == null) {
            return;
        }
        asyncImageView.setBackgroundColor(0);
        this.P.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0() {
        if (this.f43418m) {
            this.f43390e.runOnUiThread(new Runnable() { // from class: com.qzone.album.business.photolist.ui.header.QZoneAlbumHeaderView.8
                @Override // java.lang.Runnable
                public void run() {
                    QZoneAlbumHeaderView.this.P.setVisibility(0);
                }
            });
        }
    }

    private void G0(long j3) {
        this.f43447v1.removeAllViews();
        if (j3 <= 1) {
            j3 = 1;
        }
        for (char c16 : Long.toString(j3).toCharArray()) {
            TextView textView = new TextView(getContext());
            textView.setText(c16 + "");
            textView.setBackgroundResource(R.drawable.f162179hx1);
            textView.setTextSize(19.0f);
            textView.setTextColor(Color.parseColor("#FE648B"));
            this.f43447v1.addView(textView, new LinearLayout.LayoutParams(ar.d(22.0f), ar.d(27.0f)));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
            textView.setGravity(17);
            layoutParams.leftMargin = ar.d(2.0f);
            layoutParams.rightMargin = ar.d(2.0f);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void H0() {
        int i3;
        int i16 = this.f43405i.albumrights;
        if (i16 != 2) {
            if (i16 != 3) {
                if (i16 != 4) {
                    if (i16 != 5) {
                        if (i16 != 6) {
                            i3 = i16 != 8 ? i16 != 10 ? 0 : R.drawable.f162269nx4 : R.drawable.f162265nx0;
                        }
                    }
                }
                i3 = R.drawable.f162266nx1;
            } else {
                i3 = R.drawable.f162267nx2;
            }
            if (i3 == 0) {
                this.f43387d0.setBackgroundResource(i3);
                this.f43387d0.setVisibility(0);
                return;
            }
            return;
        }
        i3 = R.drawable.f162181hx3;
        if (i3 == 0) {
        }
    }

    private void J0(String str, CustomAlbumItem customAlbumItem) {
        if (this.f43440t0 == null) {
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str.trim())) {
            this.f43440t0.setVisibility(0);
            this.f43446v0.setVisibility(0);
            this.f43446v0.setTextColor(this.f43405i.albumnum > 0 ? (int) customAlbumItem.iTextColor : -16777216);
            this.f43446v0.setText(str);
            MaterialFile materialFile = customAlbumItem.stLeftImage;
            if (materialFile != null) {
                QZoneAlbumUtil.F(materialFile.strUrl, new a());
            }
            MaterialFile materialFile2 = customAlbumItem.stRightImage;
            if (materialFile2 != null) {
                QZoneAlbumUtil.F(materialFile2.strUrl, new b());
                return;
            }
            return;
        }
        this.f43440t0.setVisibility(8);
    }

    private void K0(AlbumCacheData albumCacheData) {
        com.qzone.album.env.common.a.m().b("[PhotoAlbum] QZoneAlbumHeaderView", "setTemplateData...");
        if (com.qzone.album.util.b.f(this.f43405i)) {
            setCoverImageUrl(com.qzone.album.util.b.a(this.f43405i));
        }
        this.S.removeAllViews();
        ArrayList<CustomAlbumItem> c16 = com.qzone.album.util.b.c(albumCacheData);
        if (c16 == null || c16.isEmpty()) {
            return;
        }
        Iterator<CustomAlbumItem> it = c16.iterator();
        while (it.hasNext()) {
            CustomAlbumItem next = it.next();
            if (next != null) {
                int i3 = next.iItemType;
                if (i3 == 0) {
                    e0(this.S, next);
                } else if (i3 == 1) {
                    c0(this.S, next);
                } else if (i3 == 2) {
                    d0(this.S, next);
                } else if (i3 == 3) {
                    J0(this.f43405i.albumdesc, next);
                } else if (i3 == 4) {
                    f0(this.S, next);
                } else if (i3 != 5) {
                    com.qzone.album.env.common.a.m().e("[PhotoAlbum] QZoneAlbumHeaderView", "CustomAlbumItemType unkown type(" + next.iItemType + ")");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(ArrayList<PhotoPoiArea> arrayList) {
        boolean z16;
        ArrayList<PhotoPoiArea> arrayList2 = this.f43399g1;
        if (arrayList2 != null && arrayList2.size() == arrayList.size()) {
            for (int i3 = 0; i3 < this.f43399g1.size() && i3 < arrayList.size(); i3++) {
                if (this.f43399g1.get(i3).poiInfo != null && this.f43399g1.get(i3).poiInfo.poiX != null && this.f43399g1.get(i3).poiInfo.poiY != null && (!this.f43399g1.get(i3).poiInfo.poiX.equals(arrayList.get(i3).poiInfo.poiX) || !this.f43399g1.get(i3).poiInfo.poiY.equals(arrayList.get(i3).poiInfo.poiY))) {
                    z16 = false;
                    break;
                }
            }
            z16 = true;
            if (z16) {
                com.qzone.album.env.common.a.m().b("[PhotoAlbum] QZoneAlbumHeaderView TraveMapFunction", "addPoiOnMapForOld | Same not refresh mapview");
                return;
            }
        }
        com.qzone.album.env.common.a.m().b("[PhotoAlbum] QZoneAlbumHeaderView TraveMapFunction", "addPoiOnMapForOld");
        this.f43399g1 = (ArrayList) arrayList.clone();
        ArrayList arrayList3 = new ArrayList();
        O0(arrayList3, O(arrayList, arrayList3, 0));
    }

    private void M0(final View view) {
        if (!f43376y2 || view.getMeasuredHeight() <= 0 || view.getMeasuredWidth() <= 0) {
            return;
        }
        f43376y2 = false;
        u5.b.o0("key_first_time_enter_album_photo_list", false);
        postDelayed(new Runnable() { // from class: com.qzone.album.business.photolist.ui.header.QZoneAlbumHeaderView.36
            @Override // java.lang.Runnable
            public void run() {
                QzoneGuideBubbleHelper.g().k(QZoneAlbumHeaderView.this.f43390e, view, QZoneAlbumHeaderView.this.getContext().getString(R.string.gbs), 0, 16.0f, 5.0d, 10.0d, 5000L, -15550475, false, false, ar.e(2.0f));
            }
        }, 1000L);
    }

    private void N() {
        if (this.G1 == null) {
            this.G1 = new u4.g() { // from class: com.qzone.album.business.photolist.ui.header.QZoneAlbumHeaderView.5
                @Override // u4.g
                public void a(final int i3, final int i16) {
                    if (QZoneAlbumHeaderView.this.f43390e != null) {
                        QZoneAlbumHeaderView.this.f43390e.runOnUiThread(new Runnable() { // from class: com.qzone.album.business.photolist.ui.header.QZoneAlbumHeaderView.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (i3 == 0 && i16 == 0) {
                                    QZoneAlbumHeaderView.this.J1.X0();
                                }
                            }
                        });
                    }
                }
            };
        }
        u4.e.d().b(this.G1);
    }

    private void P0() {
        RelativeLayout relativeLayout;
        if (this.f43425o0 == null || (relativeLayout = this.f43419m0) == null || relativeLayout == null) {
            return;
        }
        Q0(0);
        b1(8);
        this.f43419m0.setVisibility(0);
        this.f43425o0.setText(getResources().getString(R.string.gbr));
        this.f43425o0.setTextColor(getResources().getColor(R.color.f158017al3));
        this.f43419m0.setOnClickListener(this.f43433q2);
        this.f43431q0.setOnClickListener(this.f43436r2);
        AccessibilityUtil.p(this.f43431q0, this.f43425o0.getText().toString());
    }

    private void Q0(int i3) {
        TextView textView = this.f43425o0;
        if (textView == null || this.f43428p0 == null) {
            return;
        }
        textView.setVisibility(i3);
        this.f43428p0.setVisibility(i3);
        this.f43431q0.setVisibility(i3);
    }

    private int R(int i3) {
        if (i3 != 0) {
            if (i3 != 2) {
                return 1;
            }
            return 5;
        }
        return 3;
    }

    private void R0() {
        if (TextUtils.isEmpty(this.f43405i.albumname)) {
            this.T.setVisibility(8);
        } else {
            L0(this.T, this.f43405i.albumname);
            this.T.setText(this.f43405i.albumname);
            this.T.setVisibility(0);
        }
        if (!this.f43394f) {
            this.T.setOnClickListener(this.f43414k2);
        } else {
            this.T.setOnClickListener(null);
        }
    }

    private void S0(String str) {
        if (this.f43383c0 == null) {
            return;
        }
        LinearLayout linearLayout = this.f43395f0;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        this.f43383c0.setVisibility(0);
        TextView textView = this.f43391e0;
        if (textView != null) {
            textView.setVisibility(0);
        }
        if (this.f43391e0 != null && com.qzone.album.util.b.f(this.f43405i)) {
            this.f43391e0.setVisibility(8);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f43383c0.setText(str);
        } else {
            this.f43383c0.setText("");
            this.f43383c0.setVisibility(8);
            TextView textView2 = this.f43391e0;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            LinearLayout linearLayout2 = this.f43395f0;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
        }
        H0();
    }

    private void T0(boolean z16, boolean z17) {
        RelativeLayout relativeLayout;
        if (this.f43425o0 == null || (relativeLayout = this.f43419m0) == null || relativeLayout == null) {
            return;
        }
        relativeLayout.setVisibility(0);
        b1(8);
        Q0(0);
        if (z17) {
            this.f43425o0.setText(getResources().getString(R.string.gbi));
            this.f43431q0.setOnClickListener(null);
            this.f43428p0.setVisibility(8);
        } else {
            this.f43425o0.setText(getResources().getString(R.string.gbj));
            this.f43431q0.setOnClickListener(this.f43439s2);
            M0(this.f43425o0);
        }
        if (z16) {
            this.f43419m0.setOnClickListener(this.f43433q2);
        } else {
            this.f43419m0.setOnClickListener(null);
        }
        TextView textView = this.f43425o0;
        AccessibilityUtil.p(textView, textView.getText());
    }

    private void U0() {
        RelativeLayout relativeLayout;
        if (this.f43425o0 == null || (relativeLayout = this.f43419m0) == null) {
            return;
        }
        relativeLayout.setVisibility(0);
        b1(0);
        Q0(8);
        this.f43419m0.setOnClickListener(this.f43433q2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        com.qzone.album.env.common.a.m().b("[PhotoAlbum] QZoneAlbumHeaderView", "inflateView | mAlbumType:", Integer.valueOf(this.f43401h));
        switch (this.f43401h) {
            case 8:
                if (this.J == null) {
                    this.J = this.E.inflate();
                }
                this.f43409j0 = (RelativeLayout) this.J.findViewById(R.id.eje);
                this.P = this.J.findViewById(R.id.ekj);
                this.Q = (AsyncImageView) this.J.findViewById(R.id.ejd);
                this.P1 = "";
                a0(this.J);
                this.f43412k0 = new com.qzone.album.business.photolist.ui.header.b(this.J);
                this.T = (SafeTextView) this.J.findViewById(R.id.ejh);
                Y(this.J);
                b0(this.J);
                Q(this.J);
                this.O0 = (ViewGroup) this.J.findViewById(R.id.f166164ek1);
                this.f43398g0 = (RelativeLayout) this.J.findViewById(R.id.iqw);
                this.f43402h0 = (LinearLayout) this.J.findViewById(R.id.iqy);
                this.f43406i0 = (TextView) this.J.findViewById(R.id.iqx);
                this.P0 = (TextView) this.J.findViewById(R.id.f166163ek0);
                this.Q0 = (SafeTextView) this.J.findViewById(R.id.ej7);
                this.R0 = (LinearLayout) this.J.findViewById(R.id.ej6);
                this.S0 = (SafeTextView) this.J.findViewById(R.id.ej8);
                this.M1 = (TextView) this.J.findViewById(R.id.l_l);
                this.f43416l1 = FilterEnum.MIC_PTU_TRANS_XINXIAN;
                W(QzoneConfig.DEFAULT_BABY_ALBUM_LEFT_BG_URL, this.J.findViewById(R.id.lrr));
                W(QzoneConfig.DEFAULT_BABY_ALBUM_RIGHT_BG_URL, this.J.findViewById(R.id.lrs));
                break;
            case 9:
                if (this.K == null) {
                    this.K = this.F.inflate();
                }
                this.L1 = (RoundCornerLinearLayout) this.K.findViewById(R.id.mbj);
                this.f43409j0 = (RelativeLayout) this.K.findViewById(R.id.eje);
                this.Q = (AsyncImageView) this.K.findViewById(R.id.ejd);
                this.P1 = "";
                this.T0 = (ViewGroup) this.K.findViewById(R.id.ekl);
                this.P = this.K.findViewById(R.id.ekj);
                a0(this.K);
                this.f43412k0 = new com.qzone.album.business.photolist.ui.header.b(this.K);
                this.U0 = (ViewGroup) this.K.findViewById(R.id.ekm);
                this.f43398g0 = (RelativeLayout) this.K.findViewById(R.id.iqw);
                this.f43402h0 = (LinearLayout) this.K.findViewById(R.id.iqy);
                this.f43406i0 = (TextView) this.K.findViewById(R.id.iqx);
                this.V0 = (CellTextView) this.K.findViewById(R.id.ekk);
                this.T = (SafeTextView) this.K.findViewById(R.id.ejh);
                Y(this.K);
                b0(this.K);
                Q(this.K);
                this.f43416l1 = 320;
                if (this.W0 == null) {
                    h0(getContext().getApplicationContext());
                }
                W(QzoneConfig.DEFAULT_TRAVEL_ALBUM_LEFT_BG_URL, this.K.findViewById(R.id.mbh));
                W(QzoneConfig.DEFAULT_TRAVEL_ALBUM_RIGHT_BG_URL, this.K.findViewById(R.id.mbi));
                break;
            case 10:
            default:
                Z();
                break;
            case 11:
                if (this.L == null) {
                    this.L = this.G.inflate();
                }
                this.f43409j0 = (RelativeLayout) this.L.findViewById(R.id.eje);
                this.P = this.L.findViewById(R.id.ekj);
                this.Q = (AsyncImageView) this.L.findViewById(R.id.ejd);
                this.P1 = "";
                a0(this.L);
                this.f43412k0 = new com.qzone.album.business.photolist.ui.header.b(this.L);
                this.f43420m1 = (LinearLayout) this.L.findViewById(R.id.ehk);
                this.f43423n1 = (RelativeLayout) this.L.findViewById(R.id.hn8);
                this.f43426o1 = (TextView) this.L.findViewById(R.id.hc8);
                this.f43429p1 = (LinearLayout) this.L.findViewById(R.id.hna);
                this.f43432q1 = (LinearLayout) this.L.findViewById(R.id.hn9);
                this.f43435r1 = (CellTextView) this.L.findViewById(R.id.hn5);
                this.f43447v1 = (LinearLayout) this.L.findViewById(R.id.f166727hn4);
                this.f43438s1 = (CellTextView) this.L.findViewById(R.id.hn6);
                this.f43441t1 = (CellTextView) this.L.findViewById(R.id.f166725hn2);
                this.f43444u1 = (CellTextView) this.L.findViewById(R.id.hn_);
                this.f43398g0 = (RelativeLayout) this.L.findViewById(R.id.iqw);
                this.f43402h0 = (LinearLayout) this.L.findViewById(R.id.iqy);
                this.f43406i0 = (TextView) this.L.findViewById(R.id.iqx);
                AvatarImageView avatarImageView = (AvatarImageView) this.L.findViewById(R.id.f166726hn3);
                this.f43450w1 = avatarImageView;
                avatarImageView.setForeground((Drawable) null);
                this.f43450w1.setDefaultAvatar(R.drawable.aqk);
                this.f43450w1.setOnClickListener(new i());
                AvatarImageView avatarImageView2 = (AvatarImageView) this.L.findViewById(R.id.hn7);
                this.f43453x1 = avatarImageView2;
                avatarImageView2.setForeground((Drawable) null);
                this.f43453x1.setDefaultAvatar(R.drawable.aqk);
                this.f43453x1.setOnClickListener(new m());
                LoveWave loveWave = (LoveWave) this.L.findViewById(R.id.hbu);
                this.f43455y1 = loveWave;
                loveWave.setClickable(true);
                this.f43457z1 = (AsyncImageView) this.L.findViewById(R.id.hbt);
                this.f43416l1 = 300;
                Q(this.L);
                W(QzoneConfig.DEFAULT_LOVE_ALBUM_BG_URL, this.f43420m1);
                break;
            case 12:
                if (this.M == null) {
                    this.M = this.H.inflate();
                }
                this.f43409j0 = (RelativeLayout) this.M.findViewById(R.id.ejo);
                this.P = this.M.findViewById(R.id.ejy);
                this.Q = (AsyncImageView) this.M.findViewById(R.id.ejn);
                this.P1 = "";
                a0(this.M);
                this.f43412k0 = new com.qzone.album.business.photolist.ui.header.b(this.M);
                this.f43398g0 = (RelativeLayout) this.M.findViewById(R.id.iqw);
                this.f43402h0 = (LinearLayout) this.M.findViewById(R.id.iqy);
                this.f43406i0 = (TextView) this.M.findViewById(R.id.iqx);
                this.S = (LinearLayout) this.M.findViewById(R.id.ejq);
                LinearLayout linearLayout = (LinearLayout) this.M.findViewById(R.id.ejp);
                this.R = linearLayout;
                AccessibilityUtil.n(linearLayout, false);
                this.U = (SafeTextView) this.M.findViewById(R.id.ejm);
                this.V = (RelativeLayout) this.M.findViewById(R.id.ejz);
                Y(this.M);
                b0(this.M);
                this.T = (SafeTextView) this.M.findViewById(R.id.ejr);
                Q(this.M);
                this.f43434r0 = (ViewGroup) this.M.findViewById(R.id.ejw);
                this.f43437s0 = (Button) this.M.findViewById(R.id.ejx);
                this.f43440t0 = (ViewGroup) this.M.findViewById(R.id.ejt);
                this.f43443u0 = this.M.findViewById(R.id.eju);
                this.f43446v0 = (TextView) this.M.findViewById(R.id.ejs);
                this.f43449w0 = this.M.findViewById(R.id.ejv);
                this.f43416l1 = FilterEnum.MIC_PTU_TRANS_XINXIAN;
                break;
        }
        switch (this.f43401h) {
            case 8:
                I0(this.I);
                I0(this.K);
                I0(this.L);
                I0(this.M);
                this.J.setVisibility(0);
                return;
            case 9:
                I0(this.J);
                I0(this.I);
                I0(this.L);
                I0(this.M);
                this.K.setVisibility(0);
                return;
            case 10:
            default:
                I0(this.J);
                I0(this.K);
                I0(this.L);
                I0(this.M);
                return;
            case 11:
                I0(this.J);
                I0(this.K);
                I0(this.I);
                I0(this.M);
                this.L.setVisibility(0);
                return;
            case 12:
                I0(this.J);
                I0(this.K);
                I0(this.I);
                I0(this.L);
                this.M.setVisibility(0);
                return;
        }
    }

    private void W(String str, View view) {
        com.qzone.album.env.common.a.m().H(new AnonymousClass3(str, view));
    }

    private void X() {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154548b2);
        this.X1 = loadAnimation;
        loadAnimation.setDuration(995L);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.f154550b4);
        this.Y1 = loadAnimation2;
        loadAnimation2.setDuration(1000L);
    }

    private void Z() {
        this.D.setVisibility(8);
        this.C.setVisibility(8);
        AlbumCacheData albumCacheData = this.f43405i;
        if (albumCacheData != null) {
            if (com.qzone.album.util.b.f(albumCacheData)) {
                this.I = this.C;
            } else {
                this.I = this.D;
            }
        } else {
            this.I = this.D;
        }
        this.f43409j0 = (RelativeLayout) this.I.findViewById(R.id.eje);
        this.P = this.I.findViewById(R.id.ekj);
        this.Q = (AsyncImageView) this.I.findViewById(R.id.ejd);
        this.P1 = "";
        a0(this.I);
        this.f43412k0 = new com.qzone.album.business.photolist.ui.header.b(this.I);
        this.I.findViewById(R.id.ek5).bringToFront();
        this.S = (LinearLayout) this.I.findViewById(R.id.ejg);
        LinearLayout linearLayout = (LinearLayout) this.I.findViewById(R.id.ejf);
        this.R = linearLayout;
        AccessibilityUtil.e(linearLayout, false);
        this.U = (SafeTextView) this.I.findViewById(R.id.ejc);
        this.V = (RelativeLayout) this.I.findViewById(R.id.ekn);
        this.T = (SafeTextView) this.I.findViewById(R.id.ejh);
        Q(this.I);
        this.f43434r0 = (ViewGroup) this.I.findViewById(R.id.ek_);
        this.f43437s0 = (Button) this.I.findViewById(R.id.eka);
        this.f43440t0 = (ViewGroup) this.I.findViewById(R.id.ek7);
        this.f43443u0 = this.I.findViewById(R.id.ek8);
        this.f43446v0 = (TextView) this.I.findViewById(R.id.ek6);
        this.f43449w0 = this.I.findViewById(R.id.ek9);
        this.f43398g0 = (RelativeLayout) this.I.findViewById(R.id.iqw);
        this.f43402h0 = (LinearLayout) this.I.findViewById(R.id.iqy);
        this.f43406i0 = (TextView) this.I.findViewById(R.id.iqx);
        this.f43452x0 = (RelativeLayout) this.I.findViewById(R.id.ekb);
        this.C0 = (RelativeLayout) this.I.findViewById(R.id.ekf);
        this.f43454y0 = (TextView) this.I.findViewById(R.id.eke);
        this.f43456z0 = (TextView) this.I.findViewById(R.id.ekg);
        this.A0 = (LinearLayout) this.I.findViewById(R.id.ekh);
        this.B0 = (TextView) this.I.findViewById(R.id.eki);
        this.D0 = (Button) this.I.findViewById(R.id.ekc);
        this.E0 = (ImageView) this.I.findViewById(R.id.ekd);
        int i3 = this.F1;
        if (i3 != 0) {
            setThemeRecommendType(i3);
        }
        this.G0 = this.I.findViewById(R.id.f67983et);
        this.H0 = (ViewSwitcher) this.I.findViewById(R.id.f68023ex);
        this.I0 = (AsyncImageView) this.I.findViewById(R.id.fgk);
        this.J0 = (AsyncImageView) this.I.findViewById(R.id.fgl);
        this.K0 = (TextView) this.I.findViewById(R.id.f68003ev);
        this.L0 = (TextView) this.I.findViewById(R.id.f68013ew);
        this.M0 = (ImageView) this.I.findViewById(R.id.f67993eu);
        this.f43416l1 = FilterEnum.MIC_PTU_TRANS_XINXIAN;
        this.I.setVisibility(0);
    }

    private void Z0(ArrayList<Long> arrayList, int i3) {
        this.f43422n0.f(this.f43405i, arrayList, i3, ar.d(30.0f), ar.d(2.0f), true);
    }

    private void c0(LinearLayout linearLayout, CustomAlbumItem customAlbumItem) {
        AvatarImageView avatarImageView = new AvatarImageView(this.f43390e);
        avatarImageView.setSelector(0);
        avatarImageView.setWillNotDraw(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(u4.a.z().o(customAlbumItem.iDiameter / 2), u4.a.z().o(customAlbumItem.iDiameter / 2));
        layoutParams.topMargin = u4.a.z().o(customAlbumItem.iMarginTop / 2);
        layoutParams.gravity = R(customAlbumItem.iAlignment);
        linearLayout.addView(avatarImageView, layoutParams);
        avatarImageView.j(this.f43405i.ownerUin);
    }

    private void d0(LinearLayout linearLayout, CustomAlbumItem customAlbumItem) {
        String str;
        SafeTextView safeTextView = new SafeTextView(this.f43390e);
        safeTextView.setMaxLines(1);
        safeTextView.setTextColor((int) customAlbumItem.iTextColor);
        safeTextView.setTextSize(0, u4.a.z().o(14.0f));
        Date date = new Date(this.f43405i.createTime * 1000);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5");
        StringBuilder sb5 = new StringBuilder();
        if (this.f43405i.createTime > 0) {
            str = simpleDateFormat.format(date);
        } else {
            str = "";
        }
        sb5.append(str);
        sb5.append(" ");
        sb5.append(this.f43405i.albumnum);
        sb5.append(com.qzone.util.l.a(R.string.ro6));
        safeTextView.setText(sb5.toString());
        safeTextView.setGravity(R(customAlbumItem.iAlignment) | 16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = R(customAlbumItem.iAlignment);
        MaterialFile materialFile = customAlbumItem.stBgImage;
        if (materialFile != null) {
            QZoneAlbumUtil.G(materialFile.strUrl, true, new r(safeTextView));
        }
        linearLayout.addView(safeTextView, layoutParams);
    }

    private void e0(LinearLayout linearLayout, CustomAlbumItem customAlbumItem) {
        AlbumCacheData albumCacheData = this.f43405i;
        if (albumCacheData == null || TextUtils.isEmpty(albumCacheData.albumname)) {
            return;
        }
        SafeTextView safeTextView = new SafeTextView(this.f43390e);
        safeTextView.setMaxLines(2);
        safeTextView.setTextColor((int) customAlbumItem.iTextColor);
        int i3 = customAlbumItem.iLargeFontSize;
        if (this.f43405i.albumname.length() > 20) {
            i3 = customAlbumItem.iSmallFontSize;
        } else if (this.f43405i.albumname.length() > 10) {
            i3 = customAlbumItem.iMiddleFontSize;
        }
        safeTextView.setTextSize(0, u4.a.z().o(i3 / 2));
        safeTextView.setText(this.f43405i.albumname);
        safeTextView.setEllipsize(TextUtils.TruncateAt.END);
        safeTextView.setGravity(R(customAlbumItem.iAlignment) | 16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = u4.a.z().o(customAlbumItem.iMarginTop / 2);
        layoutParams.gravity = R(customAlbumItem.iAlignment);
        MaterialFile materialFile = customAlbumItem.stBgImage;
        if (materialFile != null) {
            QZoneAlbumUtil.G(materialFile.strUrl, true, new c(safeTextView));
        }
        linearLayout.addView(safeTextView, layoutParams);
    }

    private void f0(LinearLayout linearLayout, CustomAlbumItem customAlbumItem) {
        if (this.f43405i != null && this.f43437s0 != null) {
            this.f43437s0.setTextColor(new ColorStateList(new int[][]{new int[0], new int[]{android.R.attr.state_pressed}}, new int[]{(int) customAlbumItem.iTextColor, (int) customAlbumItem.iTextColorClick}));
            if (customAlbumItem.stBgImage != null) {
                if (this.S1 == null) {
                    this.S1 = new d();
                }
                QZoneAlbumUtil.F(customAlbumItem.stBgImage.strUrl, this.S1);
            }
            if (customAlbumItem.stBgImageClick != null) {
                if (this.T1 == null) {
                    this.T1 = new e();
                }
                QZoneAlbumUtil.F(customAlbumItem.stBgImageClick.strUrl, this.T1);
                return;
            }
            return;
        }
        com.qzone.album.env.common.a.m().b("[PhotoAlbum] QZoneAlbumHeaderView", "initTemplateUploadButton | mAlbumCacheData == null || mTemplateUploadPhotoButton == null");
    }

    private void g0() {
        if (this.f43382b2 == null || this.f43379a2 == null) {
            this.f43379a2 = new BaseTimer();
            TimerTask timerTask = new TimerTask() { // from class: com.qzone.album.business.photolist.ui.header.QZoneAlbumHeaderView.16
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Message message = new Message();
                    message.what = 10;
                    if (QZoneAlbumHeaderView.this.f43389d2 != null) {
                        QZoneAlbumHeaderView.this.f43389d2.sendMessage(message);
                    }
                }
            };
            this.f43382b2 = timerTask;
            this.f43379a2.schedule(timerTask, 2000L, 3000L);
        }
    }

    private void i0(Context context) {
        LayoutInflater.from(context).inflate(R.layout.f168991bh3, this);
        this.C = findViewById(R.id.hbi);
        this.D = findViewById(R.id.m3j);
        this.E = (ViewStub) findViewById(R.id.hbj);
        this.F = (ViewStub) findViewById(R.id.hbk);
        this.G = (ViewStub) findViewById(R.id.hbg);
        this.H = (ViewStub) findViewById(R.id.hbh);
        V();
    }

    private boolean j0() {
        List<PhotoCacheData> list = this.U1;
        if (list != null && !list.isEmpty()) {
            Iterator<PhotoCacheData> it = this.U1.iterator();
            while (it.hasNext()) {
                if (!TextUtils.isEmpty(it.next().picItem.downloadUrl.url)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean k0(AlbumCacheData albumCacheData) {
        return albumCacheData.getShareUinAttr().status == 6 && (System.currentTimeMillis() / 1000) - albumCacheData.getShareUinAttr().add_time < ((long) this.K1);
    }

    private void q0() {
        X();
        g0();
        r0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        PhotoCacheData photoCacheData;
        PictureItem pictureItem;
        List<PhotoCacheData> list = this.U1;
        if (list != null) {
            this.V1 %= 2;
            if (this.W1 >= list.size() || (photoCacheData = this.U1.get(this.W1)) == null || (pictureItem = photoCacheData.picItem) == null || pictureItem.currentUrl == null) {
                return;
            }
            int i3 = this.W1 + 1;
            this.W1 = i3;
            if (i3 == this.U1.size()) {
                this.W1 = 0;
            }
            if (this.H0 != null) {
                if (this.V1 % 2 == 0) {
                    this.I0.setAsyncImage(photoCacheData.picItem.currentUrl.url);
                } else {
                    this.J0.setAsyncImage(photoCacheData.picItem.currentUrl.url);
                }
                this.H0.setInAnimation(this.X1);
                this.H0.setOutAnimation(this.Y1);
                ViewSwitcher viewSwitcher = this.H0;
                int i16 = this.V1;
                this.V1 = i16 + 1;
                viewSwitcher.setDisplayedChild(i16);
            }
        }
    }

    private void u0() {
        com.qzone.album.env.common.a.m().b("[PhotoAlbum] QZoneAlbumHeaderView", "refreshMultiView...");
        v0();
        a1(this.f43405i);
    }

    private void v0() {
        com.qzone.album.env.common.a.m().b("[PhotoAlbum] QZoneAlbumHeaderView", "refreshNormalView...");
        setBackgroundColor(0);
        S0(u4.a.z().I(this.f43405i.albumrights, this.f43394f));
        this.S.setVisibility(8);
        this.f43440t0.setVisibility(8);
        R0();
        String str = this.f43405i.albumdesc;
        if (str == null) {
            this.U.setVisibility(8);
        } else if (TextUtils.isEmpty(str.trim())) {
            this.U.setVisibility(8);
        } else {
            this.U.setText(this.f43405i.albumdesc);
            this.U.setVisibility(0);
        }
        com.qzone.album.business.photolist.ui.a aVar = this.f43415l0;
        if (aVar != null) {
            aVar.a(this.f43405i);
        }
        this.R.setVisibility(0);
        this.V.setOnClickListener(this.f43411j2);
        if (!this.f43394f) {
            this.f43409j0.setOnClickListener(this.f43414k2);
            this.R.setOnClickListener(this.f43414k2);
        } else {
            this.f43409j0.setOnClickListener(null);
            this.R.setOnClickListener(null);
        }
        com.qzone.album.business.photolist.ui.header.b bVar = this.f43412k0;
        if (bVar != null) {
            bVar.c(this.W, this.f43377a0, this.f43380b0);
        }
    }

    private void w0() {
        com.qzone.album.env.common.a.m().b("[PhotoAlbum] QZoneAlbumHeaderView", "refreshParentingView...");
        setBackgroundResource(R.drawable.fyx);
        AlbumCacheData albumCacheData = this.f43405i;
        if (albumCacheData.birthYear == 0 && albumCacheData.birthMonth == 0 && albumCacheData.birthDay == 0) {
            this.M1.setVisibility(8);
            this.S0.setVisibility(8);
        } else {
            this.M1.setVisibility(0);
            this.S0.setVisibility(0);
            AlbumCacheData albumCacheData2 = this.f43405i;
            long j3 = albumCacheData2.birthType;
            if (j3 == 0) {
                StringBuilder sb5 = new StringBuilder();
                if (this.f43405i.birthYear > 0) {
                    sb5.append(this.f43405i.birthYear + "\u5c81");
                }
                if (this.f43405i.birthMonth > 0) {
                    sb5.append(this.f43405i.birthMonth + "\u4e2a\u6708");
                }
                this.S0.setText(sb5.toString());
            } else if (j3 == 1 && albumCacheData2.birthDay > 0) {
                this.S0.setText(this.f43405i.birthDay + "\u5929");
            }
        }
        a1(this.f43405i);
        this.O0.setOnClickListener(this.f43411j2);
        if (!this.f43394f) {
            this.f43409j0.setOnClickListener(this.f43414k2);
        } else {
            this.f43409j0.setOnClickListener(null);
            this.O0.setVisibility(8);
        }
        com.qzone.album.business.photolist.ui.header.b bVar = this.f43412k0;
        if (bVar != null) {
            bVar.c(this.W, this.f43377a0, this.f43380b0);
        }
        S0(u4.a.z().I(this.f43405i.albumrights, this.f43394f));
        R0();
        this.f43415l0.a(this.f43405i);
        X0();
    }

    private void y0() {
        Z();
        com.qzone.album.env.common.a.m().b("[PhotoAlbum] QZoneAlbumHeaderView", "refreshTemplateView...");
        setBackgroundColor(0);
        S0(u4.a.z().I(this.f43405i.albumrights, this.f43394f));
        this.T.setVisibility(8);
        this.U.setVisibility(8);
        this.S.setVisibility(0);
        com.qzone.album.business.photolist.ui.a aVar = this.f43415l0;
        if (aVar != null) {
            aVar.b();
        }
        K0(this.f43405i);
        setBackgroundDrawable(null);
        this.S.setVisibility(0);
        this.f43437s0.setOnClickListener(this.f43411j2);
        if (!this.f43394f) {
            this.f43409j0.setOnClickListener(this.f43414k2);
            this.R.setOnClickListener(this.f43414k2);
        } else {
            this.f43409j0.setOnClickListener(null);
            this.R.setOnClickListener(null);
        }
        com.qzone.album.business.photolist.ui.header.b bVar = this.f43412k0;
        if (bVar != null) {
            bVar.c(this.W, this.f43377a0, this.f43380b0);
        }
    }

    private void z0() {
        TravelAlbumData travelAlbumData;
        ArrayList<PhotoPoiArea> arrayList;
        com.qzone.album.env.common.a.m().b("[PhotoAlbum] QZoneAlbumHeaderView", "refreshTravelView...");
        setBackgroundResource(R.drawable.fyx);
        if (this.U0 != null) {
            if (!TextUtils.isEmpty(this.f43405i.albumname)) {
                this.T.setText(this.f43405i.albumname);
                this.T.setVisibility(0);
                if (!this.f43394f) {
                    this.T.setOnClickListener(this.f43421m2);
                }
            } else {
                this.T.setVisibility(8);
            }
            if (this.W0 == null) {
                h0(getContext().getApplicationContext());
            }
            if (this.W0 != null && (travelAlbumData = this.f43405i.travelData) != null && (arrayList = travelAlbumData.photoPoiAreaList) != null && arrayList.size() >= 0) {
                this.f43400g2 = new AddPoiOnMapRunnable(this.f43405i.travelData.photoPoiAreaList);
                com.qzone.album.env.common.a.m().H(this.f43400g2);
            }
            if (this.f43394f) {
                this.U0.setVisibility(8);
            }
            this.U0.setOnClickListener(this.f43411j2);
        }
        S0(u4.a.z().I(this.f43405i.albumrights, this.f43394f));
        R0();
        a1(this.f43405i);
        QTextureMapView qTextureMapView = this.W0;
        if (qTextureMapView != null) {
            qTextureMapView.setVisibility(0);
        }
        ImageLoader.Options obtain = ImageLoader.Options.obtain();
        obtain.useMainThread = true;
        obtain.extraProcessor = new z4.a();
        obtain.imageConfig = Bitmap.Config.RGB_565;
        com.qzone.album.business.photolist.ui.header.b bVar = this.f43412k0;
        if (bVar != null) {
            bVar.c(this.W, this.f43377a0, this.f43380b0);
        }
        this.f43415l0.a(this.f43405i);
        X0();
    }

    public void N0() {
        AsyncImageView asyncImageView = this.f43457z1;
        if (asyncImageView == null || this.C1 || asyncImageView.getDrawable() == null) {
            return;
        }
        this.f43457z1.setTranslationX(r0.getWidth());
        this.f43457z1.setVisibility(0);
        this.D1 = true;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f43457z1, "TranslationX", this.f43457z1.getLayoutParams().width, 0.0f);
        ofFloat.setDuration(800L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addListener(new p());
        ofFloat.start();
        this.E1 = true;
    }

    public View T(boolean z16) {
        int i3 = this.f43401h;
        if (i3 == 8) {
            return this.O0;
        }
        if (i3 == 9) {
            return this.U0;
        }
        if (i3 == 11) {
            return this.f43444u1;
        }
        if (z16) {
            return this.f43437s0;
        }
        return this.V;
    }

    public void U() {
        AsyncImageView asyncImageView = this.f43457z1;
        if (asyncImageView == null || !asyncImageView.isShown() || this.C1 || this.E1 || this.f43457z1.getDrawable() == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f43457z1, "TranslationX", 0.0f, r0.getWidth() * 0.6397059f);
        ofFloat.setDuration(1000L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.start();
        this.C1 = true;
    }

    public void V0(int i3) {
        com.qzone.album.business.photolist.ui.header.b bVar = this.f43412k0;
        if (bVar != null) {
            bVar.e(i3);
        }
    }

    public void W0(boolean z16, int i3) {
        com.qzone.album.business.photolist.ui.header.b bVar = this.f43412k0;
        if (bVar != null) {
            bVar.f(i3);
        }
    }

    public void Y0(final Context context) {
        this.f43390e.runOnUiThread(new Runnable() { // from class: com.qzone.album.business.photolist.ui.header.QZoneAlbumHeaderView.28
            @Override // java.lang.Runnable
            public void run() {
                QZoneAlbumHeaderView.this.f43401h = 9;
                QZoneAlbumHeaderView.this.V();
                if (QZoneAlbumHeaderView.this.f43409j0 == null) {
                    QZoneAlbumHeaderView qZoneAlbumHeaderView = QZoneAlbumHeaderView.this;
                    qZoneAlbumHeaderView.f43409j0 = (RelativeLayout) qZoneAlbumHeaderView.findViewById(R.id.eje);
                }
                if (QZoneAlbumHeaderView.this.T0 == null) {
                    QZoneAlbumHeaderView qZoneAlbumHeaderView2 = QZoneAlbumHeaderView.this;
                    qZoneAlbumHeaderView2.T0 = (ViewGroup) qZoneAlbumHeaderView2.findViewById(R.id.ekl);
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (QZoneAlbumHeaderView.this.W0 == null) {
                    QZoneAlbumHeaderView.this.h0(context);
                }
                com.qzone.album.env.common.a.m().b("[PhotoAlbum] QZoneAlbumHeaderView TraveMapFunction", "updateMapViewForOld initTravelMap | cost:", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                if (QZoneAlbumHeaderView.this.W0 == null || QZoneAlbumHeaderView.this.f43405i == null || QZoneAlbumHeaderView.this.f43405i.travelData == null || QZoneAlbumHeaderView.this.f43405i.travelData.photoPoiAreaList == null || QZoneAlbumHeaderView.this.f43405i.travelData.photoPoiAreaList.size() < 0) {
                    return;
                }
                ArrayList<PhotoPoiArea> arrayList = QZoneAlbumHeaderView.this.f43405i.travelData.photoPoiAreaList;
                QZoneAlbumHeaderView qZoneAlbumHeaderView3 = QZoneAlbumHeaderView.this;
                qZoneAlbumHeaderView3.f43400g2 = new AddPoiOnMapRunnable(arrayList);
                com.qzone.album.env.common.a.m().H(QZoneAlbumHeaderView.this.f43400g2);
            }
        });
    }

    public void h0(Context context) {
        if (this.W0 != null) {
            return;
        }
        this.W0 = new QTextureMapView(context);
        RoundCornerLinearLayout roundCornerLinearLayout = this.L1;
        if (roundCornerLinearLayout != null) {
            roundCornerLinearLayout.setRadius(ar.d(8.0f));
            this.L1.addView(this.W0);
        }
        QTextureMapView qTextureMapView = this.W0;
        if (qTextureMapView == null || qTextureMapView.getMap() == null) {
            return;
        }
        UiSettings uiSettings = this.W0.getMap().getUiSettings();
        uiSettings.setScaleViewEnabled(false);
        uiSettings.setLogoPosition(5);
        TencentMap map = this.W0.getMap();
        map.moveCamera(CameraUpdateFactory.zoomTo(map.getMinZoomLevel()));
    }

    public void l0() {
        if (this.W0 != null) {
            com.qzone.album.env.common.a.m().b("[PhotoAlbum] QZoneAlbumHeaderView", "onMapViewDestroy");
            this.W0.onDestroy();
            if (this.f43400g2 != null) {
                com.qzone.album.env.common.a.m().O(this.f43400g2);
            }
        }
    }

    public void m0() {
        if (this.W0 != null) {
            com.qzone.album.env.common.a.m().b("[PhotoAlbum] QZoneAlbumHeaderView", "onMapViewPause");
            this.W0.onPause();
        }
    }

    public void n0() {
        if (this.W0 != null) {
            com.qzone.album.env.common.a.m().b("[PhotoAlbum] QZoneAlbumHeaderView", "onMapViewResume");
            this.W0.onResume();
        }
    }

    public void o0() {
        if (this.W0 != null) {
            com.qzone.album.env.common.a.m().b("[PhotoAlbum] QZoneAlbumHeaderView", "onMapViewStop");
            this.W0.onStop();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        QzoneGuideBubbleHelper.g().f();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i3) {
        super.onWindowVisibilityChanged(i3);
        if (i3 == 8) {
            this.f43385c2 = true;
            return;
        }
        ViewerModelController viewerModelController = this.Z1;
        if (viewerModelController != null) {
            viewerModelController.L2 = false;
        }
    }

    public void setAKeyGenData(QZonePhotoListRequest.a aVar, ViewerModelController viewerModelController) {
        PhotoDetailPageBanner photoDetailPageBanner;
        this.Z1 = viewerModelController;
        if (aVar != null) {
            try {
                ArrayList<PhotoCacheData> arrayList = aVar.f43967i;
                if (arrayList == null || (photoDetailPageBanner = aVar.f43970l) == null || !photoDetailPageBanner.is_visible || arrayList.size() <= 0) {
                    return;
                }
                this.U1 = aVar.f43967i;
                this.L0.setOnClickListener(this.f43397f2);
                this.K0.setText(aVar.f43970l.desc);
                this.M0.setOnClickListener(new f(viewerModelController, aVar));
                if (j0()) {
                    F0(aVar);
                    q0();
                }
            } catch (Exception e16) {
                QLog.e("[PhotoAlbum] QZoneAlbumHeaderView", 1, "setAKeyGenData Exception e = " + e16);
            }
        }
    }

    public void setAddSharingOwnersListClickListener(View.OnClickListener onClickListener) {
        this.f43436r2 = onClickListener;
    }

    public void setCommentCount(int i3, AlbumCacheData albumCacheData) {
        com.qzone.album.business.photolist.ui.header.b bVar = this.f43412k0;
        if (bVar != null) {
            bVar.a(i3);
        }
    }

    public void setCoverImageUrl(String str) {
        int i3 = this.f43401h;
        if (i3 == 8 || i3 == 11 || i3 == 9) {
            return;
        }
        com.qzone.album.env.common.a.m().i("[PhotoAlbum] QZoneAlbumHeaderView", "setCoverImageUrl()  | imageUrl = " + str + " | mImageUrl = " + this.P1);
        if (TextUtils.isEmpty(str)) {
            D0();
        } else {
            if (this.P1.equals(str)) {
                return;
            }
            this.P1 = str;
            final String L = L(str);
            com.qzone.album.env.common.a.m().b("[PhotoAlbum] QZoneAlbumHeaderView", "setCoverImageUrl(): imageUrl=", L);
            com.qzone.album.env.common.a.m().H(new Runnable() { // from class: com.qzone.album.business.photolist.ui.header.QZoneAlbumHeaderView.6

                /* compiled from: P */
                /* renamed from: com.qzone.album.business.photolist.ui.header.QZoneAlbumHeaderView$6$a */
                /* loaded from: classes39.dex */
                class a extends QZoneAlbumUtil.f {
                    a() {
                    }

                    @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                    public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
                        com.qzone.album.env.common.a.m().b("[PhotoAlbum] QZoneAlbumHeaderView", "setCoverImageUrl#onImageLoaded");
                        QZoneAlbumHeaderView.this.B0(drawable, str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    ImageLoader.getInstance().loadImageAsync(L, new a());
                }
            });
        }
    }

    public void setEditButtonClickListener(View.OnClickListener onClickListener) {
        this.f43414k2 = onClickListener;
    }

    public void setFromPublicUrlAndIsNotInShareList(boolean z16) {
        this.f43448v2 = z16;
    }

    public void setGoToEditAlbumClickListener(View.OnClickListener onClickListener) {
        this.f43421m2 = onClickListener;
    }

    public void setInviteOpenLoveZoneViewVisible(boolean z16) {
        AsyncImageView asyncImageView = this.f43457z1;
        if (asyncImageView == null) {
            return;
        }
        asyncImageView.setVisibility(z16 ? 0 : 8);
        this.D1 = z16;
    }

    public void setLikeCount(int i3, AlbumCacheData albumCacheData) {
        com.qzone.album.business.photolist.ui.header.b bVar = this.f43412k0;
        if (bVar != null) {
            bVar.b(i3);
        }
    }

    public void setOnCommentClickListener(View.OnClickListener onClickListener) {
        this.f43377a0 = onClickListener;
    }

    public void setOnInviteOpenLoveZoneClickListener(View.OnClickListener onClickListener) {
        this.f43427o2 = onClickListener;
    }

    public void setOnLikeClickListener(View.OnClickListener onClickListener) {
        this.f43380b0 = onClickListener;
    }

    public void setOnLoveWaveClickListener(View.OnClickListener onClickListener) {
        this.f43417l2 = onClickListener;
    }

    public void setOnUploadPhotoButtonClickListener(View.OnClickListener onClickListener) {
        this.f43411j2 = onClickListener;
    }

    public void setOnVisitorButtonClickListener(View.OnClickListener onClickListener) {
        this.W = onClickListener;
    }

    public void setQBossRightSideViewData(String str, String str2, String str3) {
        if (this.f43457z1 == null) {
            return;
        }
        if (this.I1 == null) {
            this.I1 = new q();
        }
        this.f43457z1.setAsyncImageListener(this.I1);
        this.f43457z1.setAsyncImage(str);
        this.f43457z1.setScaleType(ImageView.ScaleType.FIT_END);
        this.f43457z1.setTag(R.id.jam, str2);
        this.f43457z1.setTag(R.id.f166947jb4, str3);
    }

    public void setRequestToJoinMultiAlbumClickListener(View.OnClickListener onClickListener) {
        this.f43439s2 = onClickListener;
    }

    public void setShareAlbumJoinButtonClickListener(View.OnClickListener onClickListener) {
        this.f43424n2 = onClickListener;
    }

    public void setShareAlbumJoinButtonVisible(boolean z16) {
        TextView textView;
        AlbumCacheData albumCacheData;
        RelativeLayout relativeLayout = this.f43398g0;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(z16 ? 0 : 8);
            if (z16 && (textView = this.f43406i0) != null && (albumCacheData = this.f43405i) != null) {
                textView.setText(String.format(this.f43445u2, albumCacheData.albumOwner));
            }
            a1(this.f43405i);
        }
    }

    public void setSharingOwnersListBarClickListener(View.OnClickListener onClickListener) {
        this.f43433q2 = onClickListener;
    }

    public void setThemeBannerBtnClickListener(View.OnClickListener onClickListener) {
        this.f43430p2 = onClickListener;
    }

    public void setThemeRecommendType(int i3) {
        this.F1 = i3;
        RelativeLayout relativeLayout = this.f43452x0;
        if (relativeLayout != null) {
            if (this.F0) {
                relativeLayout.setVisibility(8);
                return;
            }
            if (i3 == 0) {
                relativeLayout.setVisibility(8);
                return;
            }
            if (i3 == 1) {
                relativeLayout.setVisibility(0);
                if (S(i3) != null) {
                    this.C0.setOnClickListener(S(i3));
                }
                String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumSettingBabyAlbum", "\u8bbe\u7f6e\u4eb2\u5b50\u76f8\u518c");
                String config2 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumMakeGrowUpTimeLine", "\u4eb2\u5b50\u76f8\u518c\u53ef\u4ee5\u6839\u636e\u5b9d\u5b9d\u7684\u51fa\u751f\u65e5\u671f\uff0c\u5236\u4f5c\u6210\u957f\u65f6\u5149\u8f74");
                String config3 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumShareWithFamily", "\u4e0e\u5bb6\u4eba\u4e00\u8d77\u5206\u4eab\u5b69\u5b50\u6210\u957f\u7684\u559c\u60a6");
                this.f43454y0.setText(config);
                this.f43456z0.setText(config2);
                this.B0.setText(config3);
                ImageLoader.getInstance().loadImageAsync("https://qzonestyle.gtimg.cn/aoi/sola/20170801132538_OyTIFxrlc2.png", new ImageLoader.ImageLoadListener() { // from class: com.qzone.album.business.photolist.ui.header.QZoneAlbumHeaderView.29
                    @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                    public void onImageLoaded(String str, final Drawable drawable, ImageLoader.Options options) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qzone.album.business.photolist.ui.header.QZoneAlbumHeaderView.29.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (drawable == null || QZoneAlbumHeaderView.this.E0 == null) {
                                    return;
                                }
                                QZoneAlbumHeaderView.this.E0.setBackgroundDrawable(drawable);
                            }
                        });
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
                });
                this.D0.setOnClickListener(this.f43430p2);
                if (this.f43451w2) {
                    return;
                }
                LpReportInfo_pf00064.allReport(326, 2, Integer.parseInt("16"));
                this.f43451w2 = true;
                return;
            }
            if (i3 != 2) {
                relativeLayout.setVisibility(8);
                return;
            }
            relativeLayout.setVisibility(0);
            if (S(i3) != null) {
                this.C0.setOnClickListener(S(i3));
            }
            String config4 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumSettingTravelAlbum", "\u8bbe\u7f6e\u65c5\u6e38\u76f8\u518c");
            String config5 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumRecordTravelTrace", "\u65c5\u6e38\u76f8\u518c\u6839\u636e\u5730\u7406\u4f4d\u7f6e\uff0c\u8bb0\u5f55\u65c5\u884c\u8db3\u8ff9");
            String config6 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumShareWithPartner", "\u4e0e\u5c0f\u4f19\u4f34\u4e00\u8d77\u5206\u4eab\u65c5\u6e38\u7684\u70b9\u70b9\u6ef4\u6ef4");
            this.f43454y0.setText(config4);
            this.f43456z0.setText(config5);
            this.B0.setText(config6);
            ImageLoader.getInstance().loadImageAsync("https://qzonestyle.gtimg.cn/aoi/sola/20170801132927_wGXX5DaGAO.png", new ImageLoader.ImageLoadListener() { // from class: com.qzone.album.business.photolist.ui.header.QZoneAlbumHeaderView.30
                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageLoaded(String str, final Drawable drawable, ImageLoader.Options options) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qzone.album.business.photolist.ui.header.QZoneAlbumHeaderView.30.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (drawable == null || QZoneAlbumHeaderView.this.E0 == null) {
                                return;
                            }
                            QZoneAlbumHeaderView.this.E0.setBackgroundDrawable(drawable);
                        }
                    });
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
            });
            this.D0.setOnClickListener(this.f43430p2);
            if (this.f43451w2) {
                return;
            }
            LpReportInfo_pf00064.allReport(326, 2, Integer.parseInt("19"));
            this.f43451w2 = true;
        }
    }

    public void setUploadPhotoButtonVisible(boolean z16) {
        this.f43442t2 = z16;
        ViewGroup viewGroup = this.O0;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        ViewGroup viewGroup2 = this.U0;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(8);
        }
        RelativeLayout relativeLayout = this.V;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        ViewGroup viewGroup3 = this.f43434r0;
        if (viewGroup3 != null) {
            viewGroup3.setVisibility(8);
        }
        LinearLayout linearLayout = this.f43429p1;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        int i3 = this.f43401h;
        if (i3 == 8) {
            ViewGroup viewGroup4 = this.O0;
            if (viewGroup4 != null) {
                viewGroup4.setVisibility(z16 ? 0 : 8);
                return;
            }
            return;
        }
        if (i3 == 9) {
            ViewGroup viewGroup5 = this.U0;
            if (viewGroup5 != null) {
                viewGroup5.setVisibility(z16 ? 0 : 8);
                return;
            }
            return;
        }
        if (i3 != 11) {
            if (com.qzone.album.util.b.f(this.f43405i)) {
                ViewGroup viewGroup6 = this.f43434r0;
                if (viewGroup6 != null) {
                    viewGroup6.setVisibility(0);
                }
                Button button = this.f43437s0;
                if (button != null) {
                    button.setVisibility(z16 ? 0 : 8);
                    return;
                }
                return;
            }
            RelativeLayout relativeLayout2 = this.V;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(z16 ? 0 : 8);
                return;
            }
            return;
        }
        LinearLayout linearLayout2 = this.f43429p1;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        }
        LinearLayout linearLayout3 = this.f43432q1;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(z16 ? 0 : 8);
        }
    }

    public void setVisitorsCount(int i3, AlbumCacheData albumCacheData) {
        com.qzone.album.env.common.a.m().b("[PhotoAlbum] QZoneAlbumHeaderView", "setVisitorsCount | mAlbumType:", Integer.valueOf(this.f43401h), " visitorCount:", Integer.valueOf(i3));
        com.qzone.album.business.photolist.ui.header.b bVar = this.f43412k0;
        if (bVar == null || bVar == null) {
            return;
        }
        bVar.d(i3);
    }

    private void s0() {
        ArrayList<SharingAlbumClientAttr> confirmedSharingAlbumClientAttrArrayList;
        ArrayList<SharingAlbumClientAttr> arrayList;
        com.qzone.album.env.common.a.m().b("[PhotoAlbum] QZoneAlbumHeaderView", "refreshLoversView...");
        setBackgroundColor(0);
        if (!TextUtils.isEmpty(this.f43405i.albumname)) {
            this.f43426o1.setVisibility(0);
            L0(this.f43426o1, this.f43405i.albumname);
            this.f43426o1.setText(this.f43405i.albumname);
        } else {
            this.f43426o1.setVisibility(8);
        }
        if (this.f43423n1 != null) {
            if (this.f43394f && ((arrayList = this.f43405i.sharingAlbumClientAttrArrayList) == null || (arrayList != null && (arrayList.size() == 0 || this.f43405i.sharingAlbumClientAttrArrayList.size() == 1)))) {
                this.f43423n1.setVisibility(8);
            } else {
                this.f43423n1.setVisibility(0);
            }
        }
        AlbumCacheData albumCacheData = this.f43405i;
        if (albumCacheData.sharingAlbumClientAttrArrayList != null) {
            int confirmedSharingOwnersNumber = albumCacheData.getConfirmedSharingOwnersNumber();
            if (confirmedSharingOwnersNumber == 0 || confirmedSharingOwnersNumber == 1) {
                com.qzone.album.env.common.a.m().b("[PhotoAlbum] QZoneAlbumHeaderView", "refreshQzoneAlbumHeaderView | sharingAlbumClientAttrArrayList != null | left uin:", Long.valueOf(this.f43405i.ownerUin));
                this.A1 = this.f43405i.ownerUin;
                this.B1 = 0L;
            } else if (confirmedSharingOwnersNumber == 2 && (confirmedSharingAlbumClientAttrArrayList = this.f43405i.getConfirmedSharingAlbumClientAttrArrayList()) != null) {
                if (confirmedSharingAlbumClientAttrArrayList.get(0).gender != 1 && confirmedSharingAlbumClientAttrArrayList.get(0).gender != confirmedSharingAlbumClientAttrArrayList.get(1).gender) {
                    this.A1 = confirmedSharingAlbumClientAttrArrayList.get(1).uin;
                    this.B1 = confirmedSharingAlbumClientAttrArrayList.get(0).uin;
                    com.qzone.album.env.common.a.m().b("[PhotoAlbum] QZoneAlbumHeaderView", "refreshQzoneAlbumHeaderView | sharingAlbumClientAttrArrayList != null | left uin:", Long.valueOf(this.A1), " right uin:", Long.valueOf(this.B1));
                } else {
                    this.A1 = confirmedSharingAlbumClientAttrArrayList.get(0).uin;
                    this.B1 = confirmedSharingAlbumClientAttrArrayList.get(1).uin;
                    com.qzone.album.env.common.a.m().b("[PhotoAlbum] QZoneAlbumHeaderView", "refreshQzoneAlbumHeaderView | sharingAlbumClientAttrArrayList != null | left uin:", Long.valueOf(this.A1), " right uin:", Long.valueOf(this.B1));
                }
            }
        } else {
            com.qzone.album.env.common.a.m().b("[PhotoAlbum] QZoneAlbumHeaderView", "refreshQzoneAlbumHeaderView | sharingAlbumClientAttrArrayList = null | left uin:", Long.valueOf(this.f43405i.ownerUin));
            this.A1 = this.f43405i.ownerUin;
            this.B1 = 0L;
        }
        this.f43450w1.j(this.A1);
        this.f43453x1.j(this.B1);
        int dimension = (int) getResources().getDimension(R.dimen.aor);
        this.f43450w1.setAsyncClipSize(dimension, dimension);
        this.f43453x1.setAsyncClipSize(dimension, dimension);
        G0((((((System.currentTimeMillis() - QZoneAlbumUtil.l(this.f43405i.loveTime)) / 1000) / 60) / 60) / 24) + 1);
        S0(u4.a.z().I(this.f43405i.albumrights, this.f43394f));
        this.f43455y1.setVisibility(0);
        this.f43455y1.setPercent(this.f43405i.loveValue);
        this.f43455y1.a();
        this.f43432q1.setOnClickListener(this.f43411j2);
        this.f43444u1.setOnClickListener(this.f43411j2);
        if (!this.f43394f) {
            this.f43420m1.setOnClickListener(this.f43414k2);
        } else {
            this.f43420m1.setOnClickListener(null);
        }
        this.f43455y1.setOnClickListener(this.f43417l2);
        this.f43457z1.setOnClickListener(this.f43427o2);
        com.qzone.album.business.photolist.ui.header.b bVar = this.f43412k0;
        if (bVar != null) {
            bVar.c(this.W, this.f43377a0, this.f43380b0);
        }
        X0();
        this.f43415l0.a(this.f43405i);
    }

    private void I0(View view) {
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        view.setVisibility(8);
    }

    private String L(String str) {
        String replaceAll;
        return (str == null || (replaceAll = Pattern.compile("/a/").matcher(str).replaceAll(QzoneConfig.DefaultValue.DEFAULT_IMAGE_CURRENT_URL_SEGMENT)) == null || replaceAll.length() <= 0) ? str : replaceAll;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:4|5|6|7|(10:11|12|13|(5:15|16|17|18|(11:20|(1:22)|23|(1:25)|26|(1:28)(1:36)|29|(3:31|32|33)|34|35|33))(1:44)|37|34|35|33|8|9)|47|48|(7:49|50|51|52|53|54|55)|(3:56|57|58)|(6:(3:63|64|(5:70|71|72|73|74))|61|62|41|42|43)|80|81|82|83|84|85|86|43|2) */
    /* JADX WARN: Can't wrap try/catch for region: R(25:4|5|6|7|(10:11|12|13|(5:15|16|17|18|(11:20|(1:22)|23|(1:25)|26|(1:28)(1:36)|29|(3:31|32|33)|34|35|33))(1:44)|37|34|35|33|8|9)|47|48|49|50|51|52|53|54|55|(3:56|57|58)|(6:(3:63|64|(5:70|71|72|73|74))|61|62|41|42|43)|80|81|82|83|84|85|86|43|2) */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x013f, code lost:
    
        if (r36.f43403h1.get(r8).longValue() > r36.f43403h1.get(r5).longValue()) goto L82;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void P(Object obj) {
        String str;
        String str2;
        String str3;
        List list;
        int i3;
        double latitude;
        String str4;
        int i16;
        int i17;
        double d16;
        int i18;
        double d17;
        int i19;
        double d18;
        int i26;
        int i27;
        double d19;
        double d26;
        com.qzone.album.env.common.a m3;
        Object[] objArr;
        int i28;
        int i29;
        double d27;
        double d28;
        String str5 = " num:";
        String str6 = "i:";
        String str7 = "[PhotoAlbum] QZoneAlbumHeaderView TraveMapFunction";
        List list2 = (List) obj;
        this.X0 = -2.147483648E9d;
        this.Y0 = -2.147483648E9d;
        double d29 = 2.147483647E9d;
        this.Z0 = 2.147483647E9d;
        this.f43378a1 = 2.147483647E9d;
        int i36 = 0;
        int i37 = 0;
        int i38 = 0;
        while (i36 < list2.size()) {
            Marker marker = (Marker) list2.get(i36);
            try {
                latitude = marker.getPosition().getLatitude();
                double longitude = marker.getPosition().getLongitude();
                str = str5;
                str2 = str6;
                str4 = str7;
                double d36 = d29;
                i16 = i37;
                i17 = i38;
                d16 = -2.147483648E9d;
                i18 = 0;
                d17 = d36;
                i3 = i36;
                i19 = 0;
                d18 = -2.147483648E9d;
                while (i18 < list2.size()) {
                    try {
                        try {
                            Marker marker2 = (Marker) list2.get(i18);
                            double latitude2 = marker2.getPosition().getLatitude();
                            double longitude2 = marker2.getPosition().getLongitude();
                            list = list2;
                            if (Math.abs(latitude - latitude2) * 1000000.0d < (this.f43410j1 * 0.8d) / 2.0d) {
                                try {
                                    d27 = longitude;
                                    if (Math.abs(longitude - longitude2) * 1000000.0d < (this.f43413k1 * 0.8d) / 2.0d) {
                                        i19++;
                                        if (latitude2 > d18) {
                                            d18 = latitude2;
                                        }
                                        if (latitude2 < d17) {
                                            d17 = latitude2;
                                        }
                                        if (longitude2 > d16) {
                                            d28 = d36;
                                            d16 = longitude2;
                                        } else {
                                            d28 = d36;
                                        }
                                        if (longitude2 < d28) {
                                            d36 = longitude2;
                                            i18++;
                                            longitude = d27;
                                            list2 = list;
                                        }
                                        d36 = d28;
                                        i18++;
                                        longitude = d27;
                                        list2 = list;
                                    }
                                } catch (Exception unused) {
                                    i37 = i16;
                                    i38 = i17;
                                    str3 = str4;
                                    i36 = i3 + 1;
                                    str7 = str3;
                                    str5 = str;
                                    str6 = str2;
                                    list2 = list;
                                    d29 = 2.147483647E9d;
                                }
                            } else {
                                d27 = longitude;
                            }
                            d28 = d36;
                            d36 = d28;
                            i18++;
                            longitude = d27;
                            list2 = list;
                        } catch (Exception unused2) {
                            list = list2;
                        }
                    } catch (Exception unused3) {
                        list = list2;
                    }
                }
                list = list2;
                d19 = longitude;
                d26 = d36;
            } catch (Exception unused4) {
                str = str5;
                str2 = str6;
                str3 = str7;
                list = list2;
                i3 = i36;
            }
            try {
                m3 = com.qzone.album.env.common.a.m();
                objArr = new Object[4];
                try {
                    objArr[0] = str2;
                    objArr[1] = Integer.valueOf(i3);
                    objArr[2] = " currentNum:";
                    objArr[3] = Integer.valueOf(i19);
                    str3 = str4;
                } catch (Exception unused5) {
                    i26 = i17;
                    str3 = str4;
                    i27 = i16;
                    i38 = i26;
                    i37 = i27;
                    i36 = i3 + 1;
                    str7 = str3;
                    str5 = str;
                    str6 = str2;
                    list2 = list;
                    d29 = 2.147483647E9d;
                }
            } catch (Exception unused6) {
                i26 = i17;
                str3 = str4;
                i27 = i16;
                i38 = i26;
                i37 = i27;
                i36 = i3 + 1;
                str7 = str3;
                str5 = str;
                str6 = str2;
                list2 = list;
                d29 = 2.147483647E9d;
            }
            try {
                m3.b(str3, objArr);
            } catch (Exception unused7) {
                i27 = i16;
                i26 = i17;
                i38 = i26;
                i37 = i27;
                i36 = i3 + 1;
                str7 = str3;
                str5 = str;
                str6 = str2;
                list2 = list;
                d29 = 2.147483647E9d;
            }
            if (i19 <= i16) {
                if (i19 == i16) {
                    try {
                        ArrayList<Long> arrayList = this.f43403h1;
                        if (arrayList != null && arrayList.size() > i3 && this.f43403h1.size() > i18) {
                            i28 = i16;
                            i29 = i17;
                        }
                    } catch (Exception unused8) {
                    }
                }
                i28 = i16;
                i29 = i17;
                i38 = i29;
                i37 = i28;
                i36 = i3 + 1;
                str7 = str3;
                str5 = str;
                str6 = str2;
                list2 = list;
                d29 = 2.147483647E9d;
            }
            this.X0 = d18;
            this.Z0 = d17;
            this.Y0 = d16;
            this.f43378a1 = d26;
            this.f43388d1 = latitude;
            this.f43392e1 = d19;
            com.qzone.album.env.common.a m16 = com.qzone.album.env.common.a.m();
            Object[] objArr2 = new Object[16];
            objArr2[0] = str2;
            objArr2[1] = Integer.valueOf(i3);
            objArr2[2] = str;
            objArr2[3] = this.f43403h1.get(i3);
            objArr2[4] = " maxIndex:";
            objArr2[5] = Integer.valueOf(i3);
            objArr2[6] = str;
            objArr2[7] = this.f43403h1.get(i3);
            objArr2[8] = " maxLat:";
            objArr2[9] = Double.valueOf(this.X0);
            objArr2[10] = " minLat:";
            objArr2[11] = Double.valueOf(this.Z0);
            objArr2[12] = " maxLng:";
            objArr2[13] = Double.valueOf(this.Y0);
            objArr2[14] = " minLng:";
            objArr2[15] = Double.valueOf(this.f43378a1);
            m16.b(str3, objArr2);
            i37 = i19;
            i38 = i3;
            i36 = i3 + 1;
            str7 = str3;
            str5 = str;
            str6 = str2;
            list2 = list;
            d29 = 2.147483647E9d;
        }
    }

    private void Q(View view) {
        if (view != null) {
            this.f43415l0 = new com.qzone.album.business.photolist.ui.a(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0(List<Marker> list) {
        com.qzone.album.env.common.a.m().b("[PhotoAlbum] QZoneAlbumHeaderView TraveMapFunction", "refreshMapForOld mMapView.getMap().getZoomLevel():", Float.valueOf(this.W0.getMap().getCameraPosition().zoom));
        com.qzone.album.env.common.a.m().b("[PhotoAlbum] QZoneAlbumHeaderView TraveMapFunction", "dLat:", Double.valueOf(Math.abs(this.X0 - this.Z0) * 1000000.0d), " dLng:", Double.valueOf(Math.abs(this.Y0 - this.f43378a1) * 1000000.0d));
        com.qzone.album.env.common.a.m().b("[PhotoAlbum] QZoneAlbumHeaderView TraveMapFunction", "getLatitudeSpan:", Integer.valueOf(this.f43410j1), " getLongitudeSpan:", Integer.valueOf(this.f43413k1));
        if (this.f43407i1 && this.f43410j1 == 0) {
            Projection projection = this.W0.getMap().getProjection();
            this.f43410j1 = (int) (projection.getVisibleRegion().latLngBounds.southwest.latitude - projection.getVisibleRegion().latLngBounds.northeast.latitude);
            this.f43413k1 = (int) (projection.getVisibleRegion().latLngBounds.southwest.longitude - projection.getVisibleRegion().latLngBounds.northeast.longitude);
            com.qzone.album.env.common.a.m().b("[PhotoAlbum] QZoneAlbumHeaderView TraveMapFunction", "getLatitudeSpan:", Integer.valueOf(this.f43410j1), " getLongitudeSpan:", Integer.valueOf(this.f43413k1));
        }
        if (this.f43410j1 > 0) {
            final double abs = Math.abs(this.X0 - this.Z0);
            final double abs2 = Math.abs(this.Y0 - this.f43378a1);
            if (abs * 1000000.0d * 1.5d < this.f43410j1 && 1000000.0d * abs2 * 1.5d < this.f43413k1) {
                this.f43388d1 = (this.Z0 + this.X0) / 2.0d;
                this.f43392e1 = (this.Y0 + this.f43378a1) / 2.0d;
                com.qzone.album.env.common.a.m().b("[PhotoAlbum] QZoneAlbumHeaderView TraveMapFunction", "in the world centerLat:", Double.valueOf(this.f43388d1), " centerLng:", Double.valueOf(this.f43392e1));
                this.f43390e.runOnUiThread(new Runnable() { // from class: com.qzone.album.business.photolist.ui.header.QZoneAlbumHeaderView.25
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            TencentMap map = QZoneAlbumHeaderView.this.W0.getMap();
                            QZoneAlbumHeaderView qZoneAlbumHeaderView = QZoneAlbumHeaderView.this;
                            map.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(qZoneAlbumHeaderView.f43388d1, qZoneAlbumHeaderView.f43392e1)));
                            TencentMap map2 = QZoneAlbumHeaderView.this.W0.getMap();
                            QZoneAlbumHeaderView qZoneAlbumHeaderView2 = QZoneAlbumHeaderView.this;
                            LatLng latLng = new LatLng(qZoneAlbumHeaderView2.X0 + abs, qZoneAlbumHeaderView2.f43378a1 - abs2);
                            QZoneAlbumHeaderView qZoneAlbumHeaderView3 = QZoneAlbumHeaderView.this;
                            map2.moveCamera(CameraUpdateFactory.newLatLngBounds(new LatLngBounds(latLng, new LatLng(qZoneAlbumHeaderView3.Z0 - abs, qZoneAlbumHeaderView3.Y0 + abs2)), 0));
                        } catch (Throwable th5) {
                            QZLog.e("[PhotoAlbum] QZoneAlbumHeaderView", "exception:", th5);
                        }
                    }
                });
                return;
            }
            P(list);
            final double abs3 = Math.abs(this.X0 - this.Z0);
            final double abs4 = Math.abs(this.Y0 - this.f43378a1);
            if (this.X0 != -2.147483648E9d && this.Y0 != -2.147483648E9d && this.Z0 != 2.147483647E9d && this.f43378a1 != 2.147483647E9d) {
                com.qzone.album.env.common.a.m().b("[PhotoAlbum] QZoneAlbumHeaderView TraveMapFunction", "out the world centerLat:", Double.valueOf(this.f43388d1), " centerLng:", Double.valueOf(this.f43392e1));
                this.f43390e.runOnUiThread(new Runnable() { // from class: com.qzone.album.business.photolist.ui.header.QZoneAlbumHeaderView.27
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            TencentMap map = QZoneAlbumHeaderView.this.W0.getMap();
                            QZoneAlbumHeaderView qZoneAlbumHeaderView = QZoneAlbumHeaderView.this;
                            map.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(qZoneAlbumHeaderView.f43388d1, qZoneAlbumHeaderView.f43392e1)));
                            TencentMap map2 = QZoneAlbumHeaderView.this.W0.getMap();
                            QZoneAlbumHeaderView qZoneAlbumHeaderView2 = QZoneAlbumHeaderView.this;
                            LatLng latLng = new LatLng(qZoneAlbumHeaderView2.X0 + abs3, qZoneAlbumHeaderView2.f43378a1 - abs4);
                            QZoneAlbumHeaderView qZoneAlbumHeaderView3 = QZoneAlbumHeaderView.this;
                            map2.moveCamera(CameraUpdateFactory.newLatLngBounds(new LatLngBounds(latLng, new LatLng(qZoneAlbumHeaderView3.Z0 - abs3, qZoneAlbumHeaderView3.Y0 + abs4)), 0));
                        } catch (Throwable th5) {
                            QZLog.e("[PhotoAlbum] QZoneAlbumHeaderView", "exception:", th5);
                        }
                    }
                });
            } else {
                com.qzone.album.env.common.a.m().b("[PhotoAlbum] QZoneAlbumHeaderView TraveMapFunction", "out the world maxPhotoLat:", Double.valueOf(this.f43381b1), " maxPhotoLng:", Double.valueOf(this.f43384c1));
                this.f43390e.runOnUiThread(new Runnable() { // from class: com.qzone.album.business.photolist.ui.header.QZoneAlbumHeaderView.26
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            TencentMap map = QZoneAlbumHeaderView.this.W0.getMap();
                            QZoneAlbumHeaderView qZoneAlbumHeaderView = QZoneAlbumHeaderView.this;
                            map.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(qZoneAlbumHeaderView.f43381b1, qZoneAlbumHeaderView.f43384c1)));
                            QZoneAlbumHeaderView.this.W0.getMap().moveCamera(CameraUpdateFactory.zoomTo(6.0f));
                        } catch (Throwable th5) {
                            QZLog.e("[PhotoAlbum] QZoneAlbumHeaderView", "exception:", th5);
                        }
                    }
                });
            }
        }
    }

    public void X0() {
        AlbumCacheData albumCacheData;
        View view;
        if (this.f43394f || (albumCacheData = this.f43405i) == null || !albumCacheData.isSharingAlbum()) {
            return;
        }
        if ((u5.b.H(this.f43405i.albumid, 0, LoginData.getInstance().getUin()) == 1) && f43375x2) {
            AlbumCacheData albumCacheData2 = this.f43405i;
            if (albumCacheData2.albumnum > 0) {
                if (albumCacheData2.albumtype != 11) {
                    TextView textView = this.f43425o0;
                    view = (textView == null || textView.getVisibility() != 0) ? null : this.f43425o0;
                } else {
                    view = this.f43453x1;
                }
                View view2 = view;
                String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumInviteMember", "\u9080\u8bf7\u597d\u53cb \u4e00\u8d77\u4e0a\u4f20\u7167\u7247");
                if (view2 != null) {
                    QzoneGuideBubbleHelper.g().k(this.f43390e, view2, config, 0, 14.0f, 5.0d, 10.0d, 4000L, -15550475, false, true, ViewUtils.dpToPx(4.0f));
                }
                f43375x2 = false;
                u5.b.o0("key_first_time_create_share_album", false);
                u5.b.r0(this.f43405i.albumid, 0, LoginData.getInstance().getUin());
            }
        }
    }

    public void a1(AlbumCacheData albumCacheData) {
        if (albumCacheData == null || this.f43422n0 == null || this.f43419m0 == null) {
            return;
        }
        ArrayList<Long> sharedMemberUins = albumCacheData.getSharedMemberUins();
        if (!this.f43394f) {
            if (albumCacheData.getConfirmedSharingOwnersNumber() > 1) {
                Z0(sharedMemberUins, 6);
                U0();
                if (this.f43405i.isInviteFunctionOpen()) {
                    P0();
                    return;
                } else {
                    this.f43419m0.setVisibility(8);
                    return;
                }
            }
            sharedMemberUins.clear();
            sharedMemberUins.add(Long.valueOf(LoginData.getInstance().getUin()));
            Z0(sharedMemberUins, 6);
            if (this.f43405i.isInviteFunctionOpen()) {
                P0();
                return;
            } else {
                this.f43419m0.setVisibility(8);
                return;
            }
        }
        if (albumCacheData.getConfirmedSharingOwnersNumber() > 1) {
            Z0(sharedMemberUins, 6);
            if (albumCacheData.getShareUinAttr() != null && (albumCacheData.getShareUinAttr().status == 2 || albumCacheData.getShareUinAttr().status == 1)) {
                U0();
                return;
            }
            if (albumCacheData.getShareUinAttr() != null && albumCacheData.getShareUinAttr().status == 6) {
                T0(true, k0(albumCacheData));
                return;
            } else if (albumCacheData.isApplyFunctionOpen() && !this.f43448v2 && albumCacheData.getConfirmedSharingOwnersNumber() < albumCacheData.getMaxCount()) {
                T0(true, false);
                return;
            } else {
                U0();
                return;
            }
        }
        if (albumCacheData.isApplyFunctionOpen() && !albumCacheData.isShareInvitePanding() && !this.f43448v2) {
            sharedMemberUins.clear();
            sharedMemberUins.add(Long.valueOf(this.f43405i.ownerUin));
            Z0(sharedMemberUins, 6);
            if (albumCacheData.getShareUinAttr() != null && albumCacheData.getShareUinAttr().status == 6) {
                T0(false, k0(albumCacheData));
                return;
            } else {
                T0(false, false);
                return;
            }
        }
        this.f43419m0.setVisibility(8);
    }

    public void setCoverText(String str) {
        if (str != null) {
            String trim = str.trim();
            com.qzone.album.env.common.a.m().b("[PhotoAlbum] QZoneAlbumHeaderView", "setCoverText | mAlbumType:", Integer.valueOf(this.f43401h), " coverText:", trim);
            int i3 = this.f43401h;
            if (i3 == 8) {
                if (this.P0 != null) {
                    if (!TextUtils.isEmpty(trim)) {
                        this.P0.setText(trim);
                        this.P0.setVisibility(0);
                        return;
                    } else {
                        this.P0.setVisibility(8);
                        return;
                    }
                }
                return;
            }
            if (i3 == 9) {
                CellTextView cellTextView = this.V0;
                if (cellTextView != null) {
                    cellTextView.setTextColor(getResources().getColorStateList(R.color.a_j));
                    if (!TextUtils.isEmpty(trim)) {
                        this.V0.setText(trim);
                        this.V0.setVisibility(0);
                        return;
                    } else {
                        this.V0.setVisibility(8);
                        return;
                    }
                }
                return;
            }
            if (i3 != 11) {
                if (!com.qzone.album.util.b.f(this.f43405i) && this.U != null) {
                    if (!TextUtils.isEmpty(trim)) {
                        this.U.setText(trim);
                        this.U.setVisibility(0);
                    } else {
                        this.U.setVisibility(8);
                    }
                }
                E0();
                return;
            }
            if (this.f43441t1 != null) {
                if (!TextUtils.isEmpty(trim)) {
                    this.f43441t1.setText(trim);
                    this.f43441t1.setVisibility(0);
                } else {
                    this.f43441t1.setVisibility(8);
                }
            }
        }
    }

    public void x0(AlbumCacheData albumCacheData) {
        if (albumCacheData == null) {
            com.qzone.album.env.common.a.m().i("[PhotoAlbum] QZoneAlbumHeaderView", "refreshQzoneAlbumHeaderView | albumCacheData == null");
            return;
        }
        this.f43405i = albumCacheData;
        this.f43401h = albumCacheData.albumtype;
        com.qzone.album.env.common.a.m().b("[PhotoAlbum] QZoneAlbumHeaderView", "refreshQzoneAlbumHeaderView | mAlbumType:", this.f43405i.albumtype + " | albumname:" + this.f43405i.albumname);
        V();
        AlbumCacheData albumCacheData2 = this.f43405i;
        if (albumCacheData2 != null) {
            switch (this.f43401h) {
                case 8:
                    w0();
                    break;
                case 9:
                    z0();
                    break;
                case 10:
                default:
                    if (com.qzone.album.util.b.f(albumCacheData2)) {
                        y0();
                        break;
                    } else {
                        v0();
                        break;
                    }
                case 11:
                    s0();
                    break;
                case 12:
                    u0();
                    break;
            }
            TextView textView = this.f43383c0;
            if (textView != null) {
                textView.setOnClickListener(this.f43414k2);
            }
            RelativeLayout relativeLayout = this.f43398g0;
            if (relativeLayout != null) {
                relativeLayout.setOnClickListener(this.f43424n2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class j implements TencentMap.OnMarkerClickListener {
        j() {
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerClickListener
        public boolean onMarkerClick(Marker marker) {
            if (marker == null) {
                return false;
            }
            QZoneAlbumHeaderView.this.f43408i2 = marker;
            if (((Integer) marker.getTag()).intValue() < QZoneAlbumHeaderView.this.f43404h2.size()) {
                marker.setTitle((String) QZoneAlbumHeaderView.this.f43404h2.get(((Integer) marker.getTag()).intValue()));
            }
            QQMapActivity.showInfoWindow(marker);
            return true;
        }
    }

    private void F0(QZonePhotoListRequest.a aVar) {
        ArrayList<PhotoCacheData> arrayList;
        if (aVar != null && (arrayList = aVar.f43967i) != null && arrayList.size() > 0 && aVar.f43967i.get(0) != null && aVar.f43967i.get(0).picItem != null && aVar.f43967i.get(0).picItem.currentUrl != null) {
            this.I0.setAsyncImage(aVar.f43967i.get(0).picItem.currentUrl.url);
        }
        this.H0.setInAnimation(null);
        this.H0.setOutAnimation(null);
        this.H0.setDisplayedChild(0);
        if (((IAEEditorManagerForQzone) QRoute.api(IAEEditorManagerForQzone.class)).isCameraResReady()) {
            this.G0.setVisibility(0);
            LpReportInfo_pf00064.allReport(326, 20, 1);
        } else {
            this.f43385c2 = false;
            RFWThreadManager.getUIHandler().postDelayed(this.f43393e2, 1000L);
        }
    }

    private View.OnClickListener S(int i3) {
        if (i3 == 1) {
            return new n();
        }
        if (i3 == 2) {
            return new o();
        }
        return null;
    }

    private void Y(View view) {
        if (view == null) {
            return;
        }
        if (this.O1 != this.f43401h || this.N0 == null) {
            this.N0 = new com.qzone.album.ui.widget.d(view.findViewById(R.id.f166139eg1));
            this.O1 = this.f43401h;
        }
    }

    private void b0(View view) {
        this.f43419m0 = (RelativeLayout) view.findViewById(R.id.ire);
        this.f43422n0 = (SharingOwnersListBar) view.findViewById(R.id.irj);
        this.f43428p0 = (ImageView) view.findViewById(R.id.irh);
        this.f43425o0 = (TextView) view.findViewById(R.id.irf);
        this.f43431q0 = view.findViewById(R.id.m8p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(Drawable drawable, int i3) {
        if (i3 == 1) {
            this.Q1 = drawable;
        }
        if (i3 == 2) {
            this.R1 = drawable;
        }
        if (this.Q1 == null || this.R1 == null) {
            return;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawable2 = this.Q1;
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, this.R1);
        stateListDrawable.addState(new int[0], drawable2);
        this.f43437s0.setBackground(stateListDrawable);
    }

    private void L0(TextView textView, String str) {
        if (textView != null) {
            textView.setTextSize(26.0f);
            float measureText = (float) (((int) textView.getPaint().measureText(str)) / (u4.a.z().o(250.0f) * 1.0d));
            textView.setTextSize(measureText <= 1.0f ? 26 : measureText <= 2.0f ? 23 : 20);
        }
    }

    private int O(ArrayList<PhotoPoiArea> arrayList, List<Marker> list, int i3) {
        this.f43403h1 = new ArrayList<>();
        this.Y0 = -500.0d;
        this.X0 = -500.0d;
        this.f43378a1 = 500.0d;
        this.Z0 = 500.0d;
        double d16 = 0.0d;
        this.f43392e1 = 0.0d;
        this.f43388d1 = 0.0d;
        this.f43384c1 = 0.0d;
        this.f43381b1 = 0.0d;
        long j3 = 0;
        int i16 = 0;
        int i17 = i3;
        while (i16 < arrayList.size()) {
            String str = arrayList.get(i16).sceneryName;
            this.f43404h2.add(str);
            String str2 = arrayList.get(i16).poiInfo.poiX;
            String str3 = arrayList.get(i16).poiInfo.poiY;
            this.f43403h1.add(Long.valueOf(arrayList.get(i16).photoNum));
            if (str2 != null && str3 != null && !TextUtils.isEmpty(str2.trim()) && !TextUtils.isEmpty(str3.trim())) {
                double parseDouble = Double.parseDouble(str3);
                double parseDouble2 = Double.parseDouble(str2);
                if (parseDouble != d16 || parseDouble2 != d16) {
                    if (Math.abs(parseDouble2) > 180.0d || Math.abs(parseDouble) > 90.0d) {
                        Double valueOf = Double.valueOf(parseDouble2 / 1000000.0d);
                        parseDouble2 = parseDouble / 1000000.0d;
                        parseDouble = valueOf.doubleValue();
                    }
                    if (Math.abs(parseDouble2) <= 180.0d && Math.abs(parseDouble) <= 90.0d) {
                        com.qzone.album.env.common.a.m().b("[PhotoAlbum] QZoneAlbumHeaderView TraveMapFunction", "currentLng:", Double.valueOf(parseDouble2), " currentLat:", Double.valueOf(parseDouble), " title:", str);
                        Marker addMarker = this.W0.getMap().addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.fwq)).position(new LatLng(parseDouble, parseDouble2)).tag(Integer.valueOf(i16)).snippet(""));
                        QQMapActivity.showInfoWindow(addMarker);
                        list.add(addMarker);
                        if (parseDouble > this.X0) {
                            this.X0 = parseDouble;
                        }
                        if (parseDouble < this.Z0) {
                            this.Z0 = parseDouble;
                        }
                        if (parseDouble2 > this.Y0) {
                            this.Y0 = parseDouble2;
                        }
                        if (parseDouble2 < this.f43378a1) {
                            this.f43378a1 = parseDouble2;
                        }
                        if (arrayList.get(i16).poiPhotoNum >= j3) {
                            j3 = arrayList.get(i16).poiPhotoNum;
                            this.f43381b1 = parseDouble;
                            this.f43384c1 = parseDouble2;
                            this.f43396f1 = i17;
                        }
                        i17++;
                        i16++;
                        d16 = 0.0d;
                    }
                }
            }
            i16++;
            d16 = 0.0d;
        }
        return i17;
    }

    private void O0(final List<Marker> list, int i3) {
        if (i3 != 0 && list != null && list.size() > 0) {
            this.W0.getMap().setOnMarkerClickListener(new j());
            this.W0.getMap().setOnMapClickListener(new k());
            this.W0.getMap().setOnMapLoadedCallback(new TencentMap.OnMapLoadedCallback() { // from class: com.qzone.album.business.photolist.ui.header.QZoneAlbumHeaderView.22
                @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLoadedCallback
                public void onMapLoaded() {
                    try {
                        com.qzone.album.env.common.a.m().b("[PhotoAlbum] QZoneAlbumHeaderView TraveMapFunction", "onMapLoadedForOld");
                        QZoneAlbumHeaderView qZoneAlbumHeaderView = QZoneAlbumHeaderView.this;
                        qZoneAlbumHeaderView.f43407i1 = true;
                        if (qZoneAlbumHeaderView.W0 != null && QZoneAlbumHeaderView.this.W0.getMap() != null && QZoneAlbumHeaderView.this.W0.getMap().getProjection() != null) {
                            Projection projection = QZoneAlbumHeaderView.this.W0.getMap().getProjection();
                            QZoneAlbumHeaderView.this.f43410j1 = (int) ((projection.getVisibleRegion().latLngBounds.northeast.latitude * 1000000.0d) - (projection.getVisibleRegion().latLngBounds.southwest.latitude * 1000000.0d));
                            QZoneAlbumHeaderView.this.f43413k1 = (int) ((projection.getVisibleRegion().latLngBounds.northeast.longitude * 1000000.0d) - (projection.getVisibleRegion().latLngBounds.southwest.longitude * 1000000.0d));
                        }
                        com.qzone.album.env.common.a.m().H(new Runnable() { // from class: com.qzone.album.business.photolist.ui.header.QZoneAlbumHeaderView.22.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    AnonymousClass22 anonymousClass22 = AnonymousClass22.this;
                                    QZoneAlbumHeaderView.this.t0(list);
                                } catch (Throwable th5) {
                                    QZLog.e("[PhotoAlbum] QZoneAlbumHeaderView", "onMapLoaded exception:", th5);
                                }
                            }
                        });
                    } catch (Throwable th5) {
                        QZLog.e("[PhotoAlbum] QZoneAlbumHeaderView", "exception:", th5);
                    }
                }
            });
            this.W0.getMap().setOnCameraChangeListener(new l());
            if (this.f43407i1) {
                com.qzone.album.env.common.a.m().b("[PhotoAlbum] QZoneAlbumHeaderView TraveMapFunction", "refreshMapForOld needRefreshMap:", Boolean.valueOf(this.f43407i1));
                t0(list);
                return;
            }
            return;
        }
        this.f43390e.runOnUiThread(new Runnable() { // from class: com.qzone.album.business.photolist.ui.header.QZoneAlbumHeaderView.24
            @Override // java.lang.Runnable
            public void run() {
                if (QZoneAlbumHeaderView.this.W0 != null && QZoneAlbumHeaderView.this.W0.getMap() != null) {
                    QZoneAlbumHeaderView.this.W0.getMap().clear();
                }
                QZoneAlbumHeaderView.this.f43407i1 = true;
            }
        });
    }

    private void a0(View view) {
        if (view != null) {
            this.f43387d0 = (ImageView) view.findViewById(R.id.f166687hd0);
            this.f43383c0 = (TextView) view.findViewById(R.id.f166688hd1);
            this.f43391e0 = (TextView) view.findViewById(R.id.boh);
            this.f43395f0 = (LinearLayout) view.findViewById(R.id.f166162ej4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class l implements TencentMap.OnCameraChangeListener {

        /* renamed from: d, reason: collision with root package name */
        CameraPosition f43510d = null;

        l() {
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener
        public void onCameraChangeFinished(CameraPosition cameraPosition) {
            if (this.f43510d == null) {
                this.f43510d = cameraPosition;
            }
            if (this.f43510d.target.getLongitude() != cameraPosition.target.getLongitude() || this.f43510d.target.getLatitude() != cameraPosition.target.getLatitude()) {
                com.qzone.album.env.common.a.m().R("368", "28", "3");
            }
            if (this.f43510d.zoom != cameraPosition.zoom) {
                com.qzone.album.env.common.a.m().R("368", "29", "3");
            }
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener
        public void onCameraChange(CameraPosition cameraPosition) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class q implements AsyncImageable.AsyncImageListener {
        q() {
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageLoaded(AsyncImageable asyncImageable) {
            QZoneAlbumHeaderView.this.N0();
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

    public static void setImageProcessor(AsyncImageView asyncImageView, int i3, int i16, float f16, float f17, int i17, int i18) {
        if (i17 <= 0 || i18 <= 0) {
            return;
        }
        float f18 = i17;
        float f19 = i18;
        float f26 = f18 / f19;
        int i19 = (int) (f18 * f17);
        if (i3 > 0 && i16 > 0) {
            float f27 = i16;
            float f28 = f17 * f27;
            int i26 = (int) f28;
            asyncImageView.setAsyncClipSize(i19, i26);
            float f29 = i3;
            if (f29 / f27 <= 1.0f) {
                float f36 = f29 / f26;
                asyncImageView.setAsyncImageProcessor(new SpecifiedSizeCropByPivotProcessor(i19, (int) (f17 * f19), 0.5f, (((f27 - f36) * f16) + (f36 / 2.0f)) / f27));
                return;
            }
            asyncImageView.setAsyncImageProcessor(new SpecifiedSizeCropByPivotProcessor((int) (f28 * f26), i26, 0.5f, 0.5f));
            return;
        }
        asyncImageView.setAsyncClipSize(-1, -1);
        asyncImageView.setAsyncImageProcessor(null);
    }

    private void b1(int i3) {
    }

    public QZoneAlbumHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f43386d = false;
        this.f43394f = false;
        this.f43418m = false;
        this.N = true;
        this.W0 = null;
        this.X0 = -500.0d;
        this.Y0 = -500.0d;
        this.Z0 = 500.0d;
        this.f43378a1 = 500.0d;
        this.f43381b1 = 0.0d;
        this.f43384c1 = 0.0d;
        this.f43388d1 = 0.0d;
        this.f43392e1 = 0.0d;
        this.f43396f1 = 0;
        this.f43407i1 = false;
        this.f43410j1 = 0;
        this.f43413k1 = 0;
        this.f43416l1 = FilterEnum.MIC_PTU_TRANS_XINXIAN;
        this.C1 = false;
        this.D1 = false;
        this.E1 = false;
        this.F1 = 0;
        this.K1 = 86400;
        this.N1 = false;
        this.O1 = -1;
        this.P1 = "";
        this.Q1 = null;
        this.R1 = null;
        this.U1 = new ArrayList();
        this.V1 = 1;
        this.W1 = 1;
        this.f43389d2 = new g(Looper.getMainLooper());
        this.f43393e2 = new Runnable() { // from class: com.qzone.album.business.photolist.ui.header.QZoneAlbumHeaderView.18
            @Override // java.lang.Runnable
            public void run() {
                if (((IAEEditorManagerForQzone) QRoute.api(IAEEditorManagerForQzone.class)).isCameraResReady()) {
                    QZoneAlbumHeaderView.this.G0.setVisibility(0);
                    LpReportInfo_pf00064.allReport(326, 20, 1);
                } else {
                    if (QZoneAlbumHeaderView.this.f43385c2) {
                        return;
                    }
                    RFWThreadManager.getUIHandler().postDelayed(QZoneAlbumHeaderView.this.f43393e2, 1000L);
                }
            }
        };
        this.f43397f2 = new h();
        this.f43404h2 = new ArrayList();
        this.f43442t2 = false;
        this.f43445u2 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumSomeoneInviteYouToJoin", "%s\u9080\u8bf7\u4f60\u52a0\u5165\u76f8\u518c\uff0c\u4e00\u8d77\u4e0a\u4f20\u7167\u7247/\u89c6\u9891");
        this.f43448v2 = false;
        this.f43451w2 = false;
    }

    public QZoneAlbumHeaderView(Context context, int i3, boolean z16, u4.h hVar, boolean z17) {
        super(context);
        this.f43386d = false;
        this.f43394f = false;
        this.f43418m = false;
        this.N = true;
        this.W0 = null;
        this.X0 = -500.0d;
        this.Y0 = -500.0d;
        this.Z0 = 500.0d;
        this.f43378a1 = 500.0d;
        this.f43381b1 = 0.0d;
        this.f43384c1 = 0.0d;
        this.f43388d1 = 0.0d;
        this.f43392e1 = 0.0d;
        this.f43396f1 = 0;
        this.f43407i1 = false;
        this.f43410j1 = 0;
        this.f43413k1 = 0;
        this.f43416l1 = FilterEnum.MIC_PTU_TRANS_XINXIAN;
        this.C1 = false;
        this.D1 = false;
        this.E1 = false;
        this.F1 = 0;
        this.K1 = 86400;
        this.N1 = false;
        this.O1 = -1;
        this.P1 = "";
        this.Q1 = null;
        this.R1 = null;
        this.U1 = new ArrayList();
        this.V1 = 1;
        this.W1 = 1;
        this.f43389d2 = new g(Looper.getMainLooper());
        this.f43393e2 = new Runnable() { // from class: com.qzone.album.business.photolist.ui.header.QZoneAlbumHeaderView.18
            @Override // java.lang.Runnable
            public void run() {
                if (((IAEEditorManagerForQzone) QRoute.api(IAEEditorManagerForQzone.class)).isCameraResReady()) {
                    QZoneAlbumHeaderView.this.G0.setVisibility(0);
                    LpReportInfo_pf00064.allReport(326, 20, 1);
                } else {
                    if (QZoneAlbumHeaderView.this.f43385c2) {
                        return;
                    }
                    RFWThreadManager.getUIHandler().postDelayed(QZoneAlbumHeaderView.this.f43393e2, 1000L);
                }
            }
        };
        this.f43397f2 = new h();
        this.f43404h2 = new ArrayList();
        this.f43442t2 = false;
        this.f43445u2 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumSomeoneInviteYouToJoin", "%s\u9080\u8bf7\u4f60\u52a0\u5165\u76f8\u518c\uff0c\u4e00\u8d77\u4e0a\u4f20\u7167\u7247/\u89c6\u9891");
        this.f43448v2 = false;
        this.f43451w2 = false;
        com.qzone.album.env.common.a.m().b("[PhotoAlbum] QZoneAlbumHeaderView", "init QZoneAlbumHeaderView | albumType:", Integer.valueOf(i3), " isGuest:", Boolean.valueOf(z16));
        this.f43390e = (Activity) context;
        this.f43401h = i3;
        this.f43394f = z16;
        this.J1 = hVar;
        this.K1 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_SHARE_ALBUM_JOIN_TIME, 86400);
        i0(context);
        D0();
        N();
        this.f43386d = z17;
    }
}
