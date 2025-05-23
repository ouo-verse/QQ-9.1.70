package com.qzone.preview;

import NS_MOBILE_FEEDS.cell_comment;
import NS_MOBILE_FEEDS.cnst.UNIVERSAL_MALL_QUAL;
import NS_MOBILE_FEEDS.s_commment;
import NS_MOBILE_FEEDS.s_user;
import NS_MOBILE_PHOTO.EditPhoto;
import NS_MOBILE_PHOTO.get_photo_comment_rsp;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.album.base.Service.QzoneAlbumPicDownloadService;
import com.qzone.business.favorite.service.QzoneFavoriteService;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.FeedActionPanelActivity;
import com.qzone.common.activities.base.ak;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.detail.ui.comment.CommentListBaseController;
import com.qzone.detail.ui.comment.CommentListLayout;
import com.qzone.feed.panorama.PanoramaLayout;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.preview.business.BasePicureViewController;
import com.qzone.preview.photodanmaku.core.PhotoDanmakuDataSource;
import com.qzone.preview.photodanmaku.core.PhotoDanmakuFactory;
import com.qzone.preview.photodanmaku.core.PhotoDanmakuManager;
import com.qzone.preview.photodanmaku.entity.AbsDanmaku;
import com.qzone.preview.photodanmaku.entity.PhotoDanmakuModel;
import com.qzone.preview.service.PictureManager;
import com.qzone.preview.service.base.PictureConst;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.publish.ui.model.QzoneBarrageEffectData;
import com.qzone.publish.ui.model.QzoneSuperPersonalFontData;
import com.qzone.util.ToastUtil;
import com.qzone.util.ae;
import com.qzone.util.ar;
import com.qzone.util.z;
import com.qzone.widget.AsyncImageView;
import com.qzone.widget.AvatarImageView;
import com.qzone.widget.QzoneGuideBubbleHelper;
import com.qzone.widget.util.b;
import com.tencent.common.config.AppSetting;
import com.tencent.common.galleryactivity.GalleryManager;
import com.tencent.component.hdasync.HdAsync;
import com.tencent.component.hdasync.HdAsyncAction;
import com.tencent.component.hdasync.HdAsyncResult;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.processor.ScaleProcessor;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.ocr.api.IOCR;
import com.tencent.mobileqq.ocr.api.IOCRService;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qqguildsdk.data.type.IChannelType;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoManagerUtils;
import com.tencent.mobileqq.qzoneplayer.video.VideoPlayInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.ThemeSwitchUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.sharpP.SharpPUtils;
import com.tencent.util.pm.PackageUtil;
import com.tencent.widget.AbsListView;
import common.config.service.QZoneConfigHelper;
import common.config.service.QzoneConfig;
import cooperation.qqfav.QfavHelper;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.api.QZoneContant;
import cooperation.qzone.font.SimpleFontInfo;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.model.FaceData;
import cooperation.qzone.model.MapParcelable;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.remote.Callback;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.retention.RetentionReport;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.JarReflectUtil;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.PhotoDanmakuUtil;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.SystemUtil;
import java.io.File;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import n5.d;

/* loaded from: classes39.dex */
public class QzonePictureViewer extends BasePictureViewer implements View.OnClickListener {
    private String A2;
    private String B2;
    private long C2;
    private ImageView D1;
    protected View D2;
    private AsyncImageView E1;
    protected CommentListBaseController E2;
    private RelativeLayout F1;
    private Runnable F2;
    private TextView G1;
    private Runnable G2;
    private TextView H1;
    private boolean H2;
    private TextView I1;
    private int I2;
    private TextView J1;
    private volatile String J2;
    private LinearLayout K1;
    private int K2;
    private LinearLayout L1;
    private int L2;
    private Button M1;
    b.c M2;
    private int N2;
    private BasePicureViewController.f O2;
    private Callback P2;
    Runnable Q2;
    AlphaAnimation R2;
    private CellTextView S1;
    AlphaAnimation S2;
    private ImageView T1;
    HdAsync T2;
    private q U1;
    private AvatarImageView Y1;
    private View Z0;
    private TextView Z1;

    /* renamed from: a1, reason: collision with root package name */
    private TextView f49763a1;

    /* renamed from: a2, reason: collision with root package name */
    private long f49764a2;

    /* renamed from: b1, reason: collision with root package name */
    private TextView f49765b1;

    /* renamed from: c1, reason: collision with root package name */
    private TextView f49767c1;

    /* renamed from: d1, reason: collision with root package name */
    private View f49769d1;

    /* renamed from: d2, reason: collision with root package name */
    private WindowManager f49770d2;

    /* renamed from: e1, reason: collision with root package name */
    private View f49771e1;

    /* renamed from: e2, reason: collision with root package name */
    private WindowManager.LayoutParams f49772e2;

    /* renamed from: f1, reason: collision with root package name */
    private View f49773f1;

    /* renamed from: f2, reason: collision with root package name */
    private View f49774f2;

    /* renamed from: g1, reason: collision with root package name */
    private View f49775g1;

    /* renamed from: g2, reason: collision with root package name */
    private boolean f49776g2;

    /* renamed from: h1, reason: collision with root package name */
    private RelativeLayout f49777h1;

    /* renamed from: h2, reason: collision with root package name */
    private boolean f49778h2;

    /* renamed from: i1, reason: collision with root package name */
    private View f49779i1;

    /* renamed from: i2, reason: collision with root package name */
    private int f49780i2;

    /* renamed from: j1, reason: collision with root package name */
    private View f49781j1;

    /* renamed from: j2, reason: collision with root package name */
    private boolean f49782j2;

    /* renamed from: k1, reason: collision with root package name */
    private View f49783k1;

    /* renamed from: k2, reason: collision with root package name */
    private PhotoDanmakuManager f49784k2;

    /* renamed from: l1, reason: collision with root package name */
    private CellTextView f49785l1;

    /* renamed from: l2, reason: collision with root package name */
    private PhotoDanmakuDataSource f49786l2;

    /* renamed from: m1, reason: collision with root package name */
    private ImageView f49787m1;

    /* renamed from: m2, reason: collision with root package name */
    private PhotoDanmakuFactory f49788m2;

    /* renamed from: n1, reason: collision with root package name */
    private TextView f49789n1;

    /* renamed from: n2, reason: collision with root package name */
    private TextureView f49790n2;

    /* renamed from: o1, reason: collision with root package name */
    private TextView f49791o1;

    /* renamed from: o2, reason: collision with root package name */
    private ArrayList<PhotoDanmakuModel> f49792o2;

    /* renamed from: p1, reason: collision with root package name */
    private TextView f49793p1;

    /* renamed from: p2, reason: collision with root package name */
    private PhotoDanmakuModel f49794p2;

    /* renamed from: q1, reason: collision with root package name */
    private ImageView f49795q1;

    /* renamed from: q2, reason: collision with root package name */
    private boolean f49796q2;

    /* renamed from: r1, reason: collision with root package name */
    private ImageView f49797r1;

    /* renamed from: r2, reason: collision with root package name */
    private String f49798r2;

    /* renamed from: s1, reason: collision with root package name */
    private View f49799s1;

    /* renamed from: s2, reason: collision with root package name */
    private boolean f49800s2;

    /* renamed from: t1, reason: collision with root package name */
    private View f49801t1;

    /* renamed from: t2, reason: collision with root package name */
    private boolean f49802t2;

    /* renamed from: u1, reason: collision with root package name */
    private View f49803u1;

    /* renamed from: u2, reason: collision with root package name */
    private boolean f49804u2;

    /* renamed from: v1, reason: collision with root package name */
    private ImageView f49805v1;

    /* renamed from: v2, reason: collision with root package name */
    private int f49806v2;

    /* renamed from: w1, reason: collision with root package name */
    private TranslateAnimation f49807w1;

    /* renamed from: w2, reason: collision with root package name */
    private long f49808w2;

    /* renamed from: x1, reason: collision with root package name */
    private TranslateAnimation f49809x1;

    /* renamed from: x2, reason: collision with root package name */
    private boolean f49810x2;

    /* renamed from: y1, reason: collision with root package name */
    private TranslateAnimation f49811y1;

    /* renamed from: y2, reason: collision with root package name */
    private int f49812y2;

    /* renamed from: z1, reason: collision with root package name */
    private TranslateAnimation f49813z1;

    /* renamed from: z2, reason: collision with root package name */
    private String f49814z2;
    private int A1 = 300;
    private boolean B1 = true;
    private int C1 = -1;
    private boolean N1 = false;
    private int O1 = 0;
    private boolean P1 = false;
    private boolean Q1 = false;
    private boolean R1 = false;
    private String V1 = null;
    private String W1 = null;
    private String X1 = null;

    /* renamed from: b2, reason: collision with root package name */
    private Runnable f49766b2 = null;

    /* renamed from: c2, reason: collision with root package name */
    private boolean f49768c2 = false;

    /* renamed from: com.qzone.preview.QzonePictureViewer$20, reason: invalid class name */
    /* loaded from: classes39.dex */
    class AnonymousClass20 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Animation f49822d;
        final /* synthetic */ QzonePictureViewer this$0;

        @Override // java.lang.Runnable
        public void run() {
            if (this.this$0.F1 != null) {
                this.this$0.F1.setAnimation(this.f49822d);
                this.this$0.F1.startAnimation(this.f49822d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ClickReport.e(4, "", 301, 16, 2);
            yo.d.l(QzonePictureViewer.this, QzoneConfig.getInstance().getConfig("H5Url", "EasterEgg", "https://h5.qzone.qq.com/mood/photoselector?_wv=2097155&_proxy=1&qua={qua}"), 200, null);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class d implements ImageLoader.ImageLoadListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f49848d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ PhotoInfo f49849e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f49850f;

        d(boolean z16, PhotoInfo photoInfo, int i3) {
            this.f49848d = z16;
            this.f49849e = photoInfo;
            this.f49850f = i3;
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
            Message obtain = Message.obtain();
            obtain.obj = new QZoneResult(QzonePictureViewer.this.W5(this.f49850f));
            QzonePictureViewer.this.getHandler().sendMessage(obtain);
            QZLog.d("[PhotoAlbum]QzonePictureViewer", 1, "onImageCancel url", str);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
            Message obtain = Message.obtain();
            obtain.obj = new QZoneResult(QzonePictureViewer.this.W5(this.f49850f));
            QzonePictureViewer.this.getHandler().sendMessage(obtain);
            QZLog.d("[PhotoAlbum]QzonePictureViewer", 1, "onImageFailed url", str);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            this.f49849e.setImageDrawable(drawable);
            Message obtain = Message.obtain();
            obtain.obj = new QZoneResult(QzonePictureViewer.this.Y5(this.f49850f));
            QzonePictureViewer.this.getHandler().sendMessage(obtain);
            QZLog.d("[PhotoAlbum]QzonePictureViewer", 1, "onImageLoaded url", str);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
            if (this.f49848d) {
                int i3 = (int) (f16 * 100.0f);
                if (i3 > 99) {
                    i3 = 99;
                }
                Message obtain = Message.obtain();
                QZoneResult qZoneResult = new QZoneResult(1000060);
                Bundle bundle = new Bundle();
                bundle.putInt("progress", i3);
                bundle.putLong("totalSize", Long.valueOf(options != null ? options.totalSize : 0L).longValue());
                qZoneResult.setData(bundle);
                obtain.obj = qZoneResult;
                QzonePictureViewer.this.getHandler().sendMessage(obtain);
            }
        }
    }

    /* loaded from: classes39.dex */
    class e implements BasePicureViewController.f {
        e() {
        }

        @Override // com.qzone.preview.business.BasePicureViewController.f
        public void a(int i3) {
            QzonePictureViewer.this.R1 = false;
            QzonePictureViewer.this.R5();
            QzonePictureViewer.this.getHandler().removeCallbacks(QzonePictureViewer.this.F2);
            QzonePictureViewer.this.getHandler().removeCallbacks(QzonePictureViewer.this.G2);
            QZLog.i("[PhotoAlbum]QzonePictureViewer", 4, "QzonePictureViewer load getMore count = " + QzonePictureViewer.this.f49494w0);
            if (QzonePictureViewer.this.H2) {
                QzonePictureViewer qzonePictureViewer = QzonePictureViewer.this;
                if (qzonePictureViewer.f49494w0 != 0) {
                    int i16 = qzonePictureViewer.f49495x0 + (i3 - qzonePictureViewer.I2);
                    int i17 = i16 + 1;
                    QzonePictureViewer qzonePictureViewer2 = QzonePictureViewer.this;
                    if (i17 <= qzonePictureViewer2.f49494w0) {
                        if (i16 < qzonePictureViewer2.N2) {
                            PictureManager.getInstance().getSender().getMorePhotoDataList(1, QzonePictureViewer.this.getHandler());
                            QzonePictureViewer.this.N2 -= QzonePictureViewer.this.E0;
                            return;
                        }
                        return;
                    }
                    PictureManager.getInstance().getSender().getMorePhotoDataList(2, QzonePictureViewer.this.getHandler());
                    QzonePictureViewer qzonePictureViewer3 = QzonePictureViewer.this;
                    qzonePictureViewer3.f49494w0 += qzonePictureViewer3.E0;
                }
            }
        }
    }

    /* loaded from: classes39.dex */
    class f implements DialogInterface.OnClickListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* loaded from: classes39.dex */
    class g implements DialogInterface.OnClickListener {
        g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            QzonePictureViewer.this.C6();
        }
    }

    /* loaded from: classes39.dex */
    class h implements d.g {
        h() {
        }

        @Override // n5.d.g
        public void a(BusinessAlbumInfo businessAlbumInfo) {
            QzonePictureViewer qzonePictureViewer = QzonePictureViewer.this;
            Intent x16 = ak.x(qzonePictureViewer, qzonePictureViewer.getResources().getString(R.string.gng), 0);
            if (businessAlbumInfo != null) {
                x16.putExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_DEFAULT_ALBUM_ID, businessAlbumInfo.mAlbumId);
            }
            QzonePictureViewer.this.startActivityForResult(x16, QZoneContant.QZ_SELECT_ALBUM);
        }
    }

    /* loaded from: classes39.dex */
    class i implements QzoneFavoriteService.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f49856a;

        i(String str) {
            this.f49856a = str;
        }

        @Override // com.qzone.business.favorite.service.QzoneFavoriteService.d
        public void a(String str, boolean z16) {
            if (!NetworkState.isNetSupport()) {
                if (!z16) {
                    ToastUtil.n(R.string.ger);
                } else {
                    ToastUtil.o(R.string.gex, 4);
                }
                QzonePictureViewer.this.z3();
                return;
            }
            if (!QzonePictureViewer.this.f49483l0.d0(this.f49856a)) {
                ToastUtil.o(R.string.gfq, 4);
                QzonePictureViewer.this.z3();
                return;
            }
            QzonePictureViewer qzonePictureViewer = QzonePictureViewer.this;
            qzonePictureViewer.f49483l0.N0(!z16, qzonePictureViewer.getHandler());
            QzonePictureViewer.this.f49483l0.F0(null, this.f49856a, true);
            QzonePictureViewer.this.f49810x2 = !z16;
            QzonePictureViewer.this.z3();
            ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "5", "3", true);
        }
    }

    /* loaded from: classes39.dex */
    class j implements Callback {
        j() {
        }

        @Override // cooperation.qzone.remote.Callback
        public void onResult(Object obj) {
            QzonePictureViewer.this.I6((QZoneResult) obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class k implements DialogInterface.OnClickListener {
        k() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            try {
                ComponentName componentName = new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.QQBrowserActivity");
                Intent intent = new Intent();
                intent.putExtra("url", "https://tu.qq.com/websites/guide/sticker.html");
                intent.setComponent(componentName);
                QzonePictureViewer.this.startActivity(intent);
            } catch (Exception unused) {
                ToastUtil.n(R.string.d0_);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class l extends HdAsyncAction {
        l(Looper looper) {
            super(looper);
        }

        @Override // com.tencent.component.hdasync.HdAsyncAction, com.tencent.component.hdasync.BaseAction
        public HdAsyncResult call(Object obj) {
            File file;
            PhotoInfo photoInfo = (PhotoInfo) obj;
            ImageLoader imageLoader = ImageLoader.getInstance();
            File file2 = null;
            if (TextUtils.isEmpty(photoInfo.bigUrl)) {
                file = null;
            } else {
                QZLog.d("[PhotoAlbum]QzonePictureViewer", 1, "decodeFile result call... photoInfo.bigUrl:", photoInfo.bigUrl);
                file = imageLoader.getImageFile(photoInfo.bigUrl);
            }
            if (file == null) {
                QZLog.w("[PhotoAlbum]QzonePictureViewer", 1, "decodeFile result call... file == null");
                return doNext(false);
            }
            PhotoInfo b16 = QzonePictureViewer.this.f49483l0.b();
            if (!TextUtils.isEmpty(b16.bigUrl)) {
                QZLog.d("[PhotoAlbum]QzonePictureViewer", 1, "decodeFile result call... currentPhotoInfo.bigUrl:", b16.bigUrl);
                file2 = imageLoader.getImageFile(b16.bigUrl);
            }
            if (file2 == null) {
                QZLog.w("[PhotoAlbum]QzonePictureViewer", 1, "decodeFile result call... currentFile == null");
                return doNext(false);
            }
            if (file.getAbsolutePath().equals(file2.getAbsolutePath())) {
                QZLog.d("[PhotoAlbum]QzonePictureViewer", 1, "decodeFile result call... photoInfo.hasQQCode:", photoInfo.hasQQCode, " !isVideoViewer():", Boolean.valueOf(!QzonePictureViewer.this.o4()));
                if (photoInfo.hasQQCode.booleanValue()) {
                    QzonePictureViewer.this.L4(23);
                    LpReportInfo_pf00064.allReport(301, 5, 1);
                    QzonePictureViewer.this.s3(2, 56, R.string.bg9, R.drawable.cn_, photoInfo.hasQQCode.booleanValue() && !QzonePictureViewer.this.o4());
                } else {
                    QzonePictureViewer.this.s3(2, 23, R.string.gkj, R.drawable.g9q, photoInfo.hasQRCode.booleanValue() && !QzonePictureViewer.this.o4());
                }
                com.qzone.detail.ui.component.g gVar = QzonePictureViewer.this.f49475d0;
                if (gVar != null) {
                    gVar.refresh();
                }
            } else {
                QZLog.w("[PhotoAlbum]QzonePictureViewer", "decodeFile result call... file.getAbsolutePath():" + file.getAbsolutePath() + " currentFile:" + file2.getAbsolutePath());
            }
            return doNext(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class m extends HdAsyncAction {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PhotoInfo f49861a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(Looper looper, PhotoInfo photoInfo) {
            super(looper);
            this.f49861a = photoInfo;
        }

        @Override // com.tencent.component.hdasync.HdAsyncAction, com.tencent.component.hdasync.BaseAction
        public HdAsyncResult call(Object obj) {
            Boolean bool;
            PhotoInfo photoInfo = this.f49861a;
            if (photoInfo != null && ((bool = photoInfo.hasQRCode) == null || !bool.booleanValue())) {
                ScannerResult scannerResult = null;
                File imageFile = !TextUtils.isEmpty(this.f49861a.bigUrl) ? ImageLoader.getInstance().getImageFile(this.f49861a.bigUrl) : null;
                if (imageFile == null) {
                    QZLog.w("[PhotoAlbum]QzonePictureViewer", 1, "decodeFile call... file == null");
                    return doNext(false);
                }
                if (!com.tencent.qzone.avif.a.b(this.f49861a.bigUrl) && !com.tencent.qzone.avif.a.a(imageFile)) {
                    boolean isSharpP = SharpPUtils.isSharpP(imageFile);
                    Uri parse = Uri.parse("file://" + imageFile.getAbsolutePath());
                    QZLog.d("[PhotoAlbum]QzonePictureViewer", 1, "decodeFile call... isSharpP:", Boolean.valueOf(isSharpP), " getAbsolutePath:", imageFile.getAbsolutePath());
                    scannerResult = ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).decodeQQCodeFromFile(parse, QzonePictureViewer.this.getActivity(), 3, isSharpP);
                } else if (QZoneConfigHelper.j()) {
                    scannerResult = QzonePictureViewer.this.X6(imageFile, this.f49861a.bigUrl);
                } else {
                    QZLog.d("[PhotoAlbum]QzonePictureViewer", 1, "avif scan qr code is disable");
                }
                if (scannerResult == null) {
                    return doNext(false);
                }
                this.f49861a.hasQRCode = Boolean.valueOf(scannerResult.l());
                this.f49861a.hasQQCode = Boolean.valueOf(scannerResult.j());
                return doNext(true, this.f49861a);
            }
            return doNext(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class n implements View.OnClickListener {
        n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!QzonePictureViewer.this.f49776g2) {
                QzonePictureViewer.this.t6();
                LocalMultiProcConfig.putBool(LocalMultiProcConfig.Constants.KEY_PHOTO_COMMENT_DANMAKU_SWITCH + LoginData.getInstance().getUinString(), true);
                LpReportInfo_pf00064.allReport(301, 30, 2, true);
            } else {
                QzonePictureViewer.this.D1.setImageResource(R.drawable.bvx);
                QzonePictureViewer.this.f49776g2 = false;
                QzonePictureViewer.this.V6();
                LocalMultiProcConfig.putBool(LocalMultiProcConfig.Constants.KEY_PHOTO_COMMENT_DANMAKU_SWITCH + LoginData.getInstance().getUinString(), false);
                LpReportInfo_pf00064.allReport(301, 30, 3, true);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class o implements CommentListBaseController.n {
        o() {
        }

        @Override // com.qzone.detail.ui.comment.CommentListBaseController.n
        public void a() {
            QzonePictureViewer.this.f49796q2 = true;
        }

        @Override // com.qzone.detail.ui.comment.CommentListBaseController.n
        public void b() {
            QzonePictureViewer.this.f49796q2 = false;
        }

        @Override // com.qzone.detail.ui.comment.CommentListBaseController.n
        public void c() {
            QzonePictureViewer.this.j7();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class p implements CommentListBaseController.o {
        p() {
        }

        @Override // com.qzone.detail.ui.comment.CommentListBaseController.o
        public void a() {
            QzonePictureViewer qzonePictureViewer = QzonePictureViewer.this;
            qzonePictureViewer.b7(qzonePictureViewer.E2.L());
            QzonePictureViewer.this.f49483l0.F().commentCount = QzonePictureViewer.this.E2.L();
            if (QzonePictureViewer.this.f49483l0.G().appid != 4) {
                QzonePictureViewer.this.f49483l0.G().commentNum = QzonePictureViewer.this.E2.L();
            }
            QzonePictureViewer.this.o5();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes39.dex */
    public static class q {

        /* renamed from: a, reason: collision with root package name */
        private View f49866a;

        /* renamed from: b, reason: collision with root package name */
        private Handler f49867b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes39.dex */
        public class a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f49868d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f49869e;

            a(String str, String str2) {
                this.f49868d = str;
                this.f49869e = str2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (!TextUtils.isEmpty(this.f49868d)) {
                    yo.d.d(this.f49868d, q.this.f49866a.getContext(), null);
                    PictureManager.getInstance().getSender().sendReportExposeOrClick(this.f49869e, String.valueOf(LoginData.getInstance().getUin()), false, q.this.f49867b);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        q(Context context, Handler handler) {
            this.f49866a = LayoutInflater.from(context).inflate(R.layout.bqh, (ViewGroup) null);
            this.f49867b = handler;
        }

        View c() {
            return this.f49866a;
        }

        void d(String str, String str2, String str3, boolean z16) {
            QZLog.i("[PhotoAlbum]QzonePictureViewer", "showOrHideNamingAdv logo:" + str2 + " traceInfo:" + str + " url:" + str3 + " isPhotoItem:" + z16);
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            LinearLayout linearLayout = (LinearLayout) this.f49866a.findViewById(R.id.h9p);
            if (z16) {
                linearLayout.setVisibility(0);
                PictureManager.getInstance().getSender().sendReportExposeOrClick(str, String.valueOf(LoginData.getInstance().getUin()), true, this.f49867b);
                linearLayout.setOnClickListener(new a(str3, str));
                int screenWidth = ViewUtils.getScreenWidth();
                int i3 = (int) (((screenWidth * 1.0d) / 750.0d) * 98.0d);
                ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
                layoutParams.height = i3;
                linearLayout.setLayoutParams(layoutParams);
                AsyncImageView asyncImageView = (AsyncImageView) this.f49866a.findViewById(R.id.h9q);
                ViewGroup.LayoutParams layoutParams2 = asyncImageView.getLayoutParams();
                layoutParams2.width = screenWidth;
                layoutParams2.height = i3;
                asyncImageView.setLayoutParams(layoutParams2);
                asyncImageView.setAsyncImageProcessor(new ScaleProcessor(screenWidth, i3));
                asyncImageView.setAsyncImage(str2);
                return;
            }
            linearLayout.setVisibility(8);
        }
    }

    public QzonePictureViewer() {
        this.f49776g2 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PICTURE_VIEWER_DANMAKU_DEFAULT_SWITCH, 0) == 1;
        this.f49778h2 = true;
        this.f49780i2 = -1;
        this.f49782j2 = false;
        this.f49796q2 = false;
        this.f49802t2 = false;
        this.f49804u2 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_GALLERY_RECOM_ALBUM_BACK_PRESS_FINISH, 0) > 0;
        this.f49808w2 = 0L;
        this.f49812y2 = -1;
        this.f49814z2 = null;
        this.A2 = null;
        this.B2 = null;
        this.C2 = 0L;
        this.F2 = new Runnable() { // from class: com.qzone.preview.QzonePictureViewer.11
            @Override // java.lang.Runnable
            public void run() {
                if (QzonePictureViewer.this.G1 != null) {
                    QzonePictureViewer.this.G1.setText(R.string.s3r);
                }
            }
        };
        this.G2 = new Runnable() { // from class: com.qzone.preview.QzonePictureViewer.12
            @Override // java.lang.Runnable
            public void run() {
                QzonePictureViewer.this.r7(false);
            }
        };
        this.H2 = false;
        this.I2 = -1;
        this.K2 = 4;
        this.L2 = 4;
        this.M2 = null;
        this.N2 = 0;
        this.O2 = new e();
        this.P2 = new j();
        this.Q2 = new Runnable() { // from class: com.qzone.preview.QzonePictureViewer.39
            @Override // java.lang.Runnable
            public void run() {
                if (QzonePictureViewer.this.f49763a1 == null) {
                    return;
                }
                QzonePictureViewer.this.f49763a1.startAnimation(QzonePictureViewer.this.S2);
            }
        };
        this.R2 = new AlphaAnimation(0.0f, 1.0f);
        this.S2 = new AlphaAnimation(1.0f, 0.0f);
        this.T2 = null;
    }

    private void B7() {
        String str;
        TextView textView;
        if (this.f49763a1 != null) {
            if (!BasePicureViewController.a0() && !BasePicureViewController.b0() && !BasePicureViewController.o0()) {
                if (this.f49483l0.getCount() > 1) {
                    String str2 = (this.f49483l0.getSelectedIndex() + 1) + " / " + this.f49483l0.getCount();
                    if (!TextUtils.isEmpty(str2) && (textView = this.f49763a1) != null && textView.getText() != null && !str2.equals(this.f49763a1.getText().toString())) {
                        this.f49763a1.setText(str2);
                        if (BasePicureViewController.f0()) {
                            A7();
                        } else if (this.f49763a1.getVisibility() == 4) {
                            this.f49763a1.setVisibility(0);
                        }
                    }
                } else {
                    this.f49763a1.setText("");
                    this.f49763a1.setVisibility(4);
                }
            } else {
                PhotoInfo b16 = this.f49483l0.b();
                if (b16.uploadtime > 0) {
                    String format = new SimpleDateFormat("yyyy\u5e74M\u6708d\u65e5").format(new Date(b16.uploadtime * 1000));
                    if (!TextUtils.isEmpty(format)) {
                        if ((this.f49483l0.f49877g.isShareAlbum && BasePicureViewController.a0()) || BasePicureViewController.o0()) {
                            int config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PICTURE_VIEWER_NICK_MAX_LENGTH, 10);
                            String str3 = b16.uploadOwner;
                            if (str3.length() > config) {
                                str3 = str3.substring(0, config) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                            }
                            this.f49763a1.setText(format + com.qzone.util.l.a(R.string.s3z) + str3 + com.qzone.util.l.a(R.string.f172559s43));
                        } else {
                            this.f49763a1.setText(format);
                        }
                        this.f49763a1.setVisibility(0);
                    } else {
                        this.f49763a1.setVisibility(4);
                    }
                } else {
                    this.f49763a1.setVisibility(4);
                }
            }
        }
        int i3 = this.f49812y2;
        if (i3 >= 0 && i3 != this.f49483l0.getSelectedIndex()) {
            ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "18", "", true);
        }
        this.f49812y2 = this.f49483l0.getSelectedIndex();
        PhotoInfo b17 = this.f49483l0.b();
        if (this.f49776g2 && this.A2 != null && this.B2 != null && (str = this.f49814z2) != null && !str.equals(b17.busi_param.get(21))) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.qzone.preview.QzonePictureViewer.7
                @Override // java.lang.Runnable
                public void run() {
                    QzonePictureViewer qzonePictureViewer = QzonePictureViewer.this;
                    qzonePictureViewer.f49483l0.O(qzonePictureViewer.getHandler());
                }
            });
        }
        this.f49814z2 = b17.busi_param.get(21);
        this.A2 = b17.albumId;
        this.B2 = b17.lloc;
    }

    private void D6(QZoneResult qZoneResult) {
        if (!qZoneResult.getSucceed() || !(qZoneResult.getData() instanceof Bundle)) {
            ToastUtil.s(qZoneResult.getMessage(), 4);
        }
        Bundle bundle = qZoneResult.getBundle();
        this.f49483l0.b1((FaceData) bundle.getSerializable(PictureConst.PARAM_FACE_DATA), bundle.getInt(PictureConst.PARAM_MARKFACE_INDEX, -1), bundle.getString(PictureConst.PARAM_MARKFACE_UNIKEY, ""));
    }

    private void D7() {
        this.f49797r1.setImageResource(this.f49479h0 ? R.drawable.gbz : R.drawable.gby);
    }

    private void E6() {
        V4(this, 3, getResources().getString(R.string.gle), null, this.f49483l0.E());
    }

    private void E7() {
        BasePicureViewController basePicureViewController = this.f49483l0;
        if (basePicureViewController != null) {
            basePicureViewController.q();
            this.f49483l0.L0();
        }
    }

    private void F6(PhotoInfo photoInfo) {
        String str;
        if (QZLog.isColorLevel()) {
            QZLog.i("[PhotoAlbum]QzonePictureViewer", "onOcrClick");
        }
        if (photoInfo == null) {
            QZLog.e("[PhotoAlbum]QzonePictureViewer", "onOcrClick photoInfo == null");
            return;
        }
        if (!TextUtils.isEmpty(photoInfo.bigUrl)) {
            str = photoInfo.bigUrl;
        } else {
            str = !TextUtils.isEmpty(photoInfo.currentUrl) ? photoInfo.currentUrl : null;
        }
        if (!TextUtils.isEmpty(str)) {
            ImageLoader.getInstance().loadImageAsync(str, new ImageLoader.ImageLoadListener() { // from class: com.qzone.preview.QzonePictureViewer.37
                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageLoaded(String str2, Drawable drawable, ImageLoader.Options options) {
                    final File imageFile = ImageManager.getInstance().getImageFile(str2, options);
                    if (imageFile == null && !TextUtils.isEmpty(str2) && !ImageManager.isNetworkUrl(str2)) {
                        imageFile = new File(str2);
                    }
                    if (imageFile != null && imageFile.exists()) {
                        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.preview.QzonePictureViewer.37.1
                            @Override // java.lang.Runnable
                            public void run() {
                                QzonePictureViewer.this.w6(imageFile);
                            }
                        });
                    } else {
                        QZLog.e("[PhotoAlbum]QzonePictureViewer", 2, "loadImageAsync onImageLoaded file not exist .. ", str2);
                    }
                }

                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageCanceled(String str2, ImageLoader.Options options) {
                    QZLog.w("[PhotoAlbum]QzonePictureViewer", 2, "loadImageAsync onImageCanceled", str2);
                }

                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageFailed(String str2, ImageLoader.Options options) {
                    QZLog.e("[PhotoAlbum]QzonePictureViewer", 2, "loadImageAsync onImageFailed", str2);
                }

                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageProgress(String str2, float f16, ImageLoader.Options options) {
                }
            }, null);
        } else {
            QZLog.e("[PhotoAlbum]QzonePictureViewer", 2, "onOcrClick image url is empty");
            ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastTextIdentifyFail", "\u6587\u5b57\u8bc6\u522b\u5931\u8d25"), 4);
        }
    }

    private void G6() {
        if (getOutActivity().getResources().getConfiguration().orientation == 2) {
            QLog.i("[PhotoAlbum]QzonePictureViewer", 1, "--current orientation is landscape,try rotate to portrait");
            getOutActivity().setRequestedOrientation(1);
        }
        i7();
    }

    private void J6() {
        if (this.B1) {
            this.B1 = false;
            try {
                AnimationDrawable animationDrawable = new AnimationDrawable();
                animationDrawable.addFrame(getResources().getDrawable(R.drawable.gbm), 55);
                animationDrawable.addFrame(getResources().getDrawable(R.drawable.gbn), 55);
                animationDrawable.addFrame(getResources().getDrawable(R.drawable.gbo), 55);
                animationDrawable.addFrame(getResources().getDrawable(R.drawable.gbp), 55);
                animationDrawable.addFrame(getResources().getDrawable(R.drawable.gbq), 55);
                animationDrawable.addFrame(getResources().getDrawable(R.drawable.gbr), 55);
                animationDrawable.addFrame(getResources().getDrawable(R.drawable.gbl), 55);
                animationDrawable.setOneShot(true);
                animationDrawable.setDither(false);
                ImageView imageView = this.f49805v1;
                if (imageView != null) {
                    imageView.setImageDrawable(animationDrawable);
                    animationDrawable.start();
                }
            } catch (Exception e16) {
                QLog.e("[PhotoAlbum]QzonePictureViewer", 2, "onPicInfoIconClick exception " + e16.toString());
            }
            getHandler().postDelayed(new Runnable() { // from class: com.qzone.preview.QzonePictureViewer.42
                @Override // java.lang.Runnable
                public void run() {
                    long j3;
                    try {
                        PhotoInfo b16 = QzonePictureViewer.this.f49483l0.b();
                        String config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PICTURE_VIEWER_PIC_INFO_URL, QzoneConfig.DefaultValue.DEFAULT_PICTURE_VIEWER_PIC_INFO_URL);
                        String uinString = LoginData.getInstance().getUinString();
                        if (BasePicureViewController.o0()) {
                            uinString = b16.uploaduin + "";
                        }
                        Uri.Builder appendQueryParameter = Uri.parse(config.replace("{uin}", uinString).replace("{album_id}", b16.albumId).replace("{photo_id}", b16.lloc)).buildUpon().appendQueryParameter("u", uinString).appendQueryParameter("aid", b16.albumId).appendQueryParameter("pid", b16.lloc);
                        if (z.b(b16)) {
                            j3 = b16.videodata.originVideoSize;
                        } else {
                            j3 = b16.fileSize;
                        }
                        String builder = appendQueryParameter.appendQueryParameter("psize", String.valueOf(j3)).appendQueryParameter("t", String.valueOf(b16.imageResolution)).appendQueryParameter("_wv", String.valueOf(131072)).appendQueryParameter("_fv", String.valueOf(0)).appendQueryParameter("_proxy", String.valueOf(1)).toString();
                        if (BasePicureViewController.o0()) {
                            builder = builder + "&groupid=" + QzonePictureViewer.this.f49483l0.f49877g.qunid;
                        }
                        yo.d.n(QzonePictureViewer.this.getOutActivity(), builder, true, R.anim.f155031h7, Color.parseColor("#E5000000"), 9);
                        LpReportInfo_pf00064.allReport(301, 31, 1);
                        QLog.d("[PhotoAlbum]QzonePictureViewer", 2, "jump pic info url " + builder);
                    } catch (Exception e17) {
                        QLog.e("[PhotoAlbum]QzonePictureViewer", 2, "jump pic info exception " + e17.toString());
                    }
                }
            }, 150L);
        }
    }

    private void K6() {
        String str;
        PhotoInfo b16 = this.f49483l0.b();
        if (b16 != null) {
            boolean s16 = this.f49483l0.s();
            C7(s16);
            this.f49483l0.w(b16);
            this.f49483l0.E0(getHandler());
            C4();
            if (s16 && this.f49483l0.f49877g.isFriendPhotoBizFeed) {
                com.qzone.adapter.feedcomponent.i H = com.qzone.adapter.feedcomponent.i.H();
                int i3 = this.f49483l0.f49877g.businessPhotoFeedIndex;
                com.qzone.adapter.feedcomponent.i.H();
                H.U1(i3, "3");
            }
            if (BasePicureViewController.a0()) {
                str = ProfileCardTemplate.PROFILE_COMMON_VERSION;
            } else {
                str = "582";
            }
            ClickReport.m(str, "1", "");
            if (s16) {
                ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "10", "", true);
            } else {
                ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "2", "", true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void M6(PhotoInfo photoInfo, int i3) {
        Bitmap b16;
        BasePicureViewController basePicureViewController;
        PhotoParam photoParam;
        if (photoInfo == null) {
            return;
        }
        String str = null;
        File imageFile = !TextUtils.isEmpty(photoInfo.bigUrl) ? ImageLoader.getInstance().getImageFile(photoInfo.bigUrl) : null;
        if (imageFile == null) {
            return;
        }
        String absolutePath = imageFile.getAbsolutePath();
        if (SharpPUtils.isSharpP(imageFile) || com.tencent.qzone.avif.a.a(imageFile)) {
            try {
                if (SharpPUtils.isSharpP(imageFile)) {
                    b16 = SharpPUtils.decodeSharpP(imageFile.getAbsolutePath());
                } else {
                    b16 = com.tencent.qzone.avif.a.a(imageFile) ? com.tencent.qzone.image.api.a.c().b(imageFile.getAbsolutePath(), photoInfo.bigUrl, 0, 0) : null;
                }
                if (b16 != null) {
                    String str2 = String.valueOf(System.currentTimeMillis()) + ".jpeg";
                    String str3 = AppConstants.SDCARD_IMG_SAVE;
                    File file = new File(VFSAssistantUtils.getSDKPrivatePath(str3));
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(str3 + str2);
                    if (com.qzone.util.image.c.V(b16, sDKPrivatePath, Bitmap.CompressFormat.JPEG, 90, true)) {
                        try {
                            QZLog.i("[PhotoAlbum]QzonePictureViewer", "------before jump to ScannerActivity,sharpp file save success:" + str2);
                            absolutePath = sDKPrivatePath;
                        } catch (Throwable th5) {
                            th = th5;
                            absolutePath = sDKPrivatePath;
                            QZLog.e("[PhotoAlbum]QzonePictureViewer", "catch an exception: ", th);
                            Intent intent = new Intent();
                            intent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", absolutePath);
                            intent.putExtra("fromPicQRDecode", true);
                            intent.putExtra("detectType", i3 == 56 ? 2 : 1);
                            basePicureViewController = this.f49483l0;
                            if (basePicureViewController != null) {
                                str = String.valueOf(photoParam.ownerUin);
                            }
                            intent.putExtra("report_params", ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).buildQRScanReportParams(null, photoInfo.bigUrl, null, str, String.valueOf(LoginData.getInstance().getUin()), 6));
                            getOutActivity().startActivity(intent);
                            RouteUtils.startActivity(getOutActivity(), intent, "/qrscan/scanner");
                        }
                    }
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
        Intent intent2 = new Intent();
        intent2.putExtra("PhotoConst.SINGLE_PHOTO_PATH", absolutePath);
        intent2.putExtra("fromPicQRDecode", true);
        intent2.putExtra("detectType", i3 == 56 ? 2 : 1);
        basePicureViewController = this.f49483l0;
        if (basePicureViewController != null && (photoParam = basePicureViewController.f49877g) != null) {
            str = String.valueOf(photoParam.ownerUin);
        }
        intent2.putExtra("report_params", ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).buildQRScanReportParams(null, photoInfo.bigUrl, null, str, String.valueOf(LoginData.getInstance().getUin()), 6));
        getOutActivity().startActivity(intent2);
        RouteUtils.startActivity(getOutActivity(), intent2, "/qrscan/scanner");
    }

    private void O6() {
        Button button = this.M1;
        if (button != null) {
            button.setVisibility(4);
        }
        com.qzone.detail.ui.component.g gVar = this.f49475d0;
        if (gVar != null) {
            gVar.updateUI();
        }
        TextView textView = this.f49789n1;
        if (textView != null) {
            textView.setGravity(17);
        }
    }

    private void P6() {
        if (this.M1 != null) {
            C4();
        }
        com.qzone.detail.ui.component.g gVar = this.f49475d0;
        if (gVar != null) {
            gVar.updateUI();
        }
        TextView textView = this.f49789n1;
        if (textView != null) {
            textView.setGravity(19);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R5() {
        if (this.F1 == null || this.H1 == null) {
            return;
        }
        r7(false);
        this.H1.setVisibility(8);
    }

    private void T6() {
        if (this.G1 == null || getHandler() == null) {
            return;
        }
        r7(true);
        getHandler().postDelayed(this.F2, 2000L);
        getHandler().postDelayed(this.G2, 5000L);
    }

    private void U5() {
        b.c cVar;
        try {
            if (isFinishing() || (cVar = this.M2) == null || !cVar.isShowing()) {
                return;
            }
            this.M2.dismiss();
        } catch (Exception e16) {
            QZLog.w(e16);
        }
    }

    private void U6(final ArrayList<PhotoDanmakuModel> arrayList) {
        final ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            PhotoDanmakuModel photoDanmakuModel = arrayList.get(i3);
            long j3 = photoDanmakuModel.userUin;
            if (j3 > 0) {
                arrayList3.add(Long.valueOf(j3));
            }
            QzoneBarrageEffectData.BarrageEffectInfo barrageEffectInfo = photoDanmakuModel.barrageEffectInfo;
            if (barrageEffectInfo != null && !TextUtils.isEmpty(barrageEffectInfo.strIosBgUrl)) {
                arrayList2.add(photoDanmakuModel.barrageEffectInfo.strIosBgUrl);
            }
        }
        if (arrayList2.size() > 0) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.preview.QzonePictureViewer.22
                @Override // java.lang.Runnable
                public void run() {
                    QzoneAlbumPicDownloadService.o().n(QzonePictureViewer.this, System.currentTimeMillis() + "", arrayList2, new a());
                }

                /* renamed from: com.qzone.preview.QzonePictureViewer$22$a */
                /* loaded from: classes39.dex */
                class a implements QzoneAlbumPicDownloadService.c {
                    a() {
                    }

                    @Override // com.qzone.album.base.Service.QzoneAlbumPicDownloadService.c
                    public void a(String str, ArrayList<String> arrayList) {
                        AnonymousClass22 anonymousClass22 = AnonymousClass22.this;
                        QzonePictureViewer.this.t7(arrayList);
                    }

                    @Override // com.qzone.album.base.Service.QzoneAlbumPicDownloadService.c
                    public void onDownloadFailed(String str) {
                    }
                }
            });
        } else {
            t7(arrayList);
        }
    }

    private void V5(Bundle bundle) {
        String string = bundle.getString("trace_info");
        String string2 = bundle.getString("logo_pic");
        String string3 = bundle.getString("jump_url");
        if (!TextUtils.isEmpty(string)) {
            this.V1 = string;
        }
        if (!TextUtils.isEmpty(string2)) {
            this.W1 = string2;
        }
        if (!TextUtils.isEmpty(string3)) {
            this.X1 = string3;
        }
        QZLog.i("[PhotoAlbum]QzonePictureViewer", "filledWithAdData success trace_info: " + string + " logo: " + string2 + " url: " + string3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V6() {
        if (this.f49782j2) {
            PhotoDanmakuManager photoDanmakuManager = this.f49784k2;
            if (photoDanmakuManager != null && photoDanmakuManager.isPlaying()) {
                this.f49784k2.quit();
                this.f49784k2.clear();
                this.f49784k2.release();
                View view = this.f49774f2;
                if (view != null) {
                    view.setVisibility(8);
                }
                WindowManager windowManager = this.f49770d2;
                if (windowManager != null) {
                    try {
                        windowManager.removeViewImmediate(this.f49774f2);
                    } catch (Throwable th5) {
                        QLog.e("[PhotoAlbum]QzonePictureViewer", 1, "[releaseDanmakuResAndStop] error: ", th5);
                    }
                }
            }
            this.f49782j2 = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int W5(int i3) {
        if (i3 == 1) {
            return 1000062;
        }
        if (i3 == 2) {
            return 1000064;
        }
        if (i3 == 3) {
            return 1000066;
        }
        if (i3 == 4) {
            return 1000068;
        }
        return IChannelType.APP_SUB_CHANNEL_TYPE_CODM;
    }

    private void W6() {
        QZLog.i("[PhotoAlbum]QzonePictureViewer", "QzonePictureViewer requestAdData ");
        PictureManager.getInstance().getSender().getBigPhotoAdList(1, 2541, getHandler());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x005f, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005c, code lost:
    
        if (r3 == null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ScannerResult X6(File file, String str) {
        Bitmap bitmap;
        try {
            bitmap = com.tencent.qzone.image.api.a.c().a(file, str, 0, 0);
            try {
                QLog.d("[PhotoAlbum]QzonePictureViewer", 1, "parseQQCodeForAvif bmp:" + bitmap + ", file: " + file.getAbsolutePath() + ", url: " + str);
                r2 = bitmap != null ? ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).decodeQQCodeFromBmp(bitmap, 3) : null;
            } catch (Throwable th5) {
                th = th5;
                try {
                    th.printStackTrace();
                    QLog.w("[PhotoAlbum]QzonePictureViewer", 1, "parseQQCodeForAvif error:", th);
                } finally {
                    if (bitmap != null) {
                        bitmap.recycle();
                    }
                }
            }
        } catch (Throwable th6) {
            th = th6;
            bitmap = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Y5(int i3) {
        if (i3 == 1) {
            return 1000061;
        }
        if (i3 == 2) {
            return 1000063;
        }
        if (i3 == 3) {
            return 1000065;
        }
        if (i3 == 4) {
            return 1000067;
        }
        return 1000069;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z6(PhotoInfo photoInfo) {
        TextView textView;
        TextView textView2;
        int N = this.f49483l0.N();
        int D = this.f49483l0.D();
        TextView textView3 = this.f49791o1;
        if (textView3 == null || this.f49793p1 == null || this.f49787m1 == null || this.f49795q1 == null) {
            return;
        }
        if (N <= 0 && D <= 0) {
            textView3.setText("");
            this.f49793p1.setText("");
            this.f49787m1.setImageResource(R.drawable.gbe);
            this.f49795q1.setImageResource(R.drawable.gb_);
        } else {
            if (N > 0) {
                String b65 = b6(N);
                this.f49791o1.setText(b65);
                this.f49791o1.setContentDescription(com.qzone.util.l.a(R.string.s3q) + b65);
            } else {
                textView3.setText("");
            }
            b7(D);
        }
        if (this.f49483l0.s()) {
            this.f49791o1.setTextColor(getResources().getColor(R.color.a8w));
            this.f49787m1.setImageResource(R.drawable.gbf);
            this.f49787m1.setContentDescription(com.qzone.util.l.a(R.string.s3u));
        } else {
            this.f49791o1.setTextColor(-1);
            if (N > 0) {
                this.f49787m1.setImageResource(R.drawable.gbd);
            } else {
                this.f49787m1.setImageResource(R.drawable.gbe);
            }
            this.f49787m1.setContentDescription(com.qzone.util.l.a(R.string.f172561s45));
        }
        if (!BasePicureViewController.a0() && !BasePicureViewController.b0()) {
            this.S1.setVisibility(8);
            this.f49785l1.setVisibility(8);
        } else if (TextUtils.isEmpty(photoInfo.desc)) {
            this.f49785l1.setVisibility(8);
        } else {
            this.f49785l1.setRichText(photoInfo.desc);
            this.f49785l1.setVisibility(0);
        }
        if (!BasePicureViewController.a0() && !BasePicureViewController.b0() && !BasePicureViewController.g0()) {
            this.S1.setVisibility(8);
            this.f49785l1.setVisibility(8);
        } else if (LoginData.getInstance().getUin() == this.f49483l0.f49877g.ownerUin && photoInfo.appid != 311) {
            if (TextUtils.isEmpty(photoInfo.desc)) {
                d7(this.S1, com.qzone.util.l.a(R.string.s46));
            } else {
                d7(this.S1, photoInfo.desc);
            }
            this.S1.setVisibility(0);
            this.f49785l1.setVisibility(8);
        } else {
            this.S1.setVisibility(8);
        }
        Y6(photoInfo);
        f7(photoInfo);
        g7(photoInfo);
        l6(photoInfo);
        if (this.f49765b1 == null || (textView = this.f49767c1) == null) {
            return;
        }
        textView.setVisibility(8);
        if (TextUtils.isEmpty(photoInfo.albumName)) {
            this.f49765b1.setText("");
            return;
        }
        String str = photoInfo.albumName;
        this.f49765b1.setMaxWidth(ar.e(QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PICTURE_VIEWER_TITLE_MAX_LENGTH_WITHOUT_PAGENUM, 200)));
        if (this.f49483l0.getCount() <= 1 && !BasePicureViewController.a0()) {
            this.f49765b1.setText(str);
            return;
        }
        String str2 = "(" + (this.f49483l0.getSelectedIndex() + 1) + "/" + this.f49483l0.H() + ")";
        if (!TextUtils.isEmpty(str2) && (textView2 = this.f49763a1) != null && textView2.getText() != null && !str2.equals(this.f49763a1.getText().toString())) {
            this.f49765b1.setMaxWidth(ar.e(QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PICTURE_VIEWER_TITLE_MAX_LENGTH_WITH_PAGENUM, 144)));
            this.f49765b1.setText(str);
            if (BasePicureViewController.b0()) {
                this.f49767c1.setVisibility(8);
            } else {
                this.f49767c1.setVisibility(0);
                this.f49767c1.setText(str2);
            }
            if (this.H2) {
                return;
            }
            this.H2 = true;
            this.I2 = this.f49483l0.getSelectedIndex();
            return;
        }
        this.f49765b1.setText(str);
    }

    private TopGestureLayout a6() {
        View childAt;
        if (getWindow() == null || getWindow().getDecorView() == null) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
        if (viewGroup.getChildCount() == 0 || (childAt = viewGroup.getChildAt(0)) == null || !(childAt instanceof TopGestureLayout)) {
            return null;
        }
        return (TopGestureLayout) childAt;
    }

    private String b6(int i3) {
        if (i3 <= 0) {
            return "";
        }
        String str = i3 + "";
        if (i3 <= 9999) {
            return str;
        }
        if (i3 > 99999999) {
            return (i3 / 100000000) + com.qzone.util.l.a(R.string.s3s);
        }
        if (i3 > 9999999) {
            return (i3 / 10000000) + com.qzone.util.l.a(R.string.s3v);
        }
        return (i3 / 10000) + com.qzone.util.l.a(R.string.s3m);
    }

    private void e7() {
        TopGestureLayout a65 = a6();
        if (a65 != null) {
            a65.setInterceptScrollLRFlag(false);
        }
        int selectedIndex = this.f49483l0.getSelectedIndex();
        int i3 = this.C1;
        if (i3 != selectedIndex && this.f49483l0.getItem(i3) != null) {
            this.f49483l0.getItem(this.C1).showGifState = PhotoInfo.SHOW_STATIC_PHOTO;
        }
        this.C1 = selectedIndex;
        if (this.f49483l0.X0() && !s6()) {
            if ((BasePicureViewController.n0() || BasePicureViewController.f0() || BasePicureViewController.g0() || BasePicureViewController.o0()) && this.Z0 == null) {
                k6();
                h6();
            }
            if (this.f49775g1 == null) {
                f6();
            }
            PanoramaLayout panoramaLayout = this.f49492u0;
            if (panoramaLayout != null && panoramaLayout.F()) {
                this.f49492u0.bringToFront();
            }
            final PhotoInfo b16 = this.f49483l0.b();
            if (b16 == null) {
                return;
            }
            if (!z.b(b16)) {
                S7(false);
            }
            if (!BasePicureViewController.n0() && !BasePicureViewController.g0()) {
                if (b16.unikey != null) {
                    View view = this.f49775g1;
                    if (view != null && view.getVisibility() == 0) {
                        Z6(b16);
                    } else if (this.P1) {
                        a7(b16, this.O1);
                    } else {
                        QZoneConfigHelper.h0(new QZoneConfigHelper.a() { // from class: com.qzone.preview.QzonePictureViewer.23
                            @Override // common.config.service.QZoneConfigHelper.a
                            public void a(final int i16) {
                                QzonePictureViewer.this.O1 = i16;
                                QzonePictureViewer.this.P1 = true;
                                QzonePictureViewer.this.runOnUiThread(new Runnable() { // from class: com.qzone.preview.QzonePictureViewer.23.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        AnonymousClass23 anonymousClass23 = AnonymousClass23.this;
                                        QzonePictureViewer.this.a7(b16, i16);
                                    }
                                });
                            }
                        });
                    }
                } else {
                    this.f49775g1.setVisibility(8);
                }
                View view2 = this.f49801t1;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
                View view3 = this.f49803u1;
                if (view3 != null) {
                    view3.setVisibility(0);
                    return;
                }
                return;
            }
            Z6(b16);
            return;
        }
        View view4 = this.f49801t1;
        if (view4 != null) {
            view4.setVisibility(8);
        }
        View view5 = this.f49803u1;
        if (view5 != null) {
            view5.setVisibility(8);
        }
    }

    private void g7(PhotoInfo photoInfo) {
        if (this.f49805v1 == null || photoInfo == null) {
            return;
        }
        if ((QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PICTURE_VIEWER_SHOW_PIC_INFO, 1) > 0) && photoInfo.picInfoOpen && (BasePicureViewController.a0() || BasePicureViewController.o0())) {
            this.f49805v1.setVisibility(0);
            this.f49805v1.setOnClickListener(this);
            LpReportInfo_pf00064.allReport(301, 31, 3);
            return;
        }
        this.f49805v1.setVisibility(8);
    }

    private void h6() {
        boolean v65 = v6();
        this.f49778h2 = v65;
        if (v65 && BasePicureViewController.f0()) {
            PhotoParam photoParam = this.f49483l0.f49877g;
            if (photoParam.qzoneUserType != 0 || photoParam.appid == 202 || photoParam.isSharedFeeds || !PhotoDanmakuUtil.getInstance().isEnablePhotoDanmakuFunc()) {
                return;
            }
            k7();
        }
    }

    private void i6() {
        WindowManager windowManager;
        this.f49770d2 = (WindowManager) getSystemService("window");
        View inflate = this.f49472a0.inflate(R.layout.bqi, (ViewGroup) null);
        this.f49774f2 = inflate;
        TextureView textureView = (TextureView) inflate.findViewById(R.id.j8n);
        this.f49790n2 = textureView;
        this.f49784k2 = new PhotoDanmakuManager(this, textureView, 1);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f49772e2 = layoutParams;
        layoutParams.gravity = 48;
        layoutParams.type = 2;
        layoutParams.format = 1;
        layoutParams.flags = 1080;
        layoutParams.width = -1;
        layoutParams.height = -1;
        if (!isFinishing() && (windowManager = this.f49770d2) != null) {
            windowManager.addView(this.f49774f2, this.f49772e2);
        }
        this.f49786l2 = this.f49784k2.getDanmakuDataSource();
        this.f49788m2 = this.f49784k2.getDanmakuFactory();
        this.f49782j2 = true;
    }

    private void initFooterAnimation(boolean z16) {
        if (this.f49783k1 != null) {
            if (z16) {
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, this.f49783k1.getHeight());
                this.f49813z1 = translateAnimation;
                translateAnimation.setDuration(this.A1);
                this.f49813z1.setAnimationListener(new Animation.AnimationListener() { // from class: com.qzone.preview.QzonePictureViewer.15
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        QzonePictureViewer.this.getHandler().post(new Runnable() { // from class: com.qzone.preview.QzonePictureViewer.15.1
                            @Override // java.lang.Runnable
                            public void run() {
                                QzonePictureViewer.this.f49783k1.setVisibility(4);
                                QzonePictureViewer.this.f49781j1.setVisibility(4);
                            }
                        });
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        QzonePictureViewer.this.f49783k1.setVisibility(4);
                        QzonePictureViewer.this.f49781j1.setVisibility(4);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                return;
            }
            TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, this.f49783k1.getHeight(), 0.0f);
            this.f49811y1 = translateAnimation2;
            translateAnimation2.setDuration(this.A1);
            this.f49811y1.setAnimationListener(new c());
        }
    }

    private void j6(boolean z16) {
        if (this.Z0 != null) {
            if (z16) {
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, -this.Z0.getHeight(), 0.0f);
                this.f49809x1 = translateAnimation;
                translateAnimation.setDuration(this.A1);
                this.f49809x1.setAnimationListener(new b());
                return;
            }
            TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, 0.0f, -this.Z0.getHeight());
            this.f49807w1 = translateAnimation2;
            translateAnimation2.setDuration(this.A1);
            this.f49807w1.setAnimationListener(new Animation.AnimationListener() { // from class: com.qzone.preview.QzonePictureViewer.14
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    QzonePictureViewer.this.getHandler().post(new Runnable() { // from class: com.qzone.preview.QzonePictureViewer.14.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QzonePictureViewer.this.Z0.setVisibility(4);
                        }
                    });
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    QzonePictureViewer.this.Z0.setVisibility(4);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j7() {
        if (this.f49794p2 != null && this.f49776g2 && BasePicureViewController.f0()) {
            PhotoParam photoParam = this.f49483l0.f49877g;
            if (photoParam.qzoneUserType != 0 || photoParam.appid == 202 || photoParam.isSharedFeeds) {
                return;
            }
            if (!this.f49782j2) {
                i6();
            }
            PhotoDanmakuModel photoDanmakuModel = this.f49794p2;
            this.f49794p2 = null;
            if (this.f49792o2 == null) {
                this.f49792o2 = new ArrayList<>();
            }
            this.f49792o2.add(0, photoDanmakuModel);
            if (this.f49784k2.isPlaying()) {
                AbsDanmaku createDanmaku = this.f49788m2.createDanmaku(1, 0L, photoDanmakuModel.nickName, photoDanmakuModel.content, getResources().getColor(R.color.a8r), 10.0f, getResources().getColor(R.color.a8q));
                createDanmaku.isPostImmediatelyDanmaku = true;
                QzoneBarrageEffectData.BarrageEffectInfo barrageEffectInfo = photoDanmakuModel.barrageEffectInfo;
                if (barrageEffectInfo != null) {
                    String str = barrageEffectInfo.strAndBgUrl;
                    String str2 = barrageEffectInfo.strTextColor;
                    createDanmaku.setBackgroundImageUrl(str);
                    createDanmaku.setTextColor(Color.parseColor("#" + str2));
                }
                try {
                    String str3 = photoDanmakuModel.fontId;
                    if (str3 != null && !TextUtils.isEmpty(str3)) {
                        createDanmaku.setFontId(Integer.parseInt(photoDanmakuModel.fontId));
                        createDanmaku.setFontType(Integer.parseInt(photoDanmakuModel.fontType));
                        createDanmaku.setFontUrl(photoDanmakuModel.fontUrl);
                    }
                    createDanmaku.setSuperFontInfo(photoDanmakuModel.superFontInfo);
                    createDanmaku.setTextSize(TypedValue.applyDimension(2, 14.0f, getResources().getDisplayMetrics()));
                    createDanmaku.setUserLogoByUin(photoDanmakuModel.userUin);
                    createDanmaku.setLeftImageShape(1);
                    createDanmaku.setBorderRadio(60.0f);
                    this.f49788m2.measureDanmaku(createDanmaku);
                    this.f49786l2.addNow(createDanmaku);
                    return;
                } catch (NumberFormatException unused) {
                    QZLog.e("[PhotoAlbum]QzonePictureViewer", "Integer.parseInt(curDanmakuModel.fontId) - NumberFormatException");
                    return;
                }
            }
            t7(this.f49792o2);
        }
    }

    private void k6() {
        try {
            this.Z0 = this.f49472a0.inflate(R.layout.bqk, (ViewGroup) null);
            l7();
            RelativeLayout relativeLayout = (RelativeLayout) this.Z0.findViewById(R.id.ftv);
            int notchHeight = SystemUtil.getNotchHeight(getOutActivity(), this);
            relativeLayout.getLayoutParams().height = relativeLayout.getLayoutParams().height + notchHeight + ViewUtils.dip2px(10.0f);
            relativeLayout.setPadding(relativeLayout.getPaddingLeft(), relativeLayout.getPaddingTop() + notchHeight, relativeLayout.getPaddingRight(), relativeLayout.getPaddingBottom());
            AsyncImageView asyncImageView = (AsyncImageView) this.Z0.findViewById(R.id.fu7);
            this.E1 = asyncImageView;
            asyncImageView.setOnClickListener(this);
            if (BasePicureViewController.n0()) {
                this.f49769d1 = relativeLayout;
                TextView textView = (TextView) this.Z0.findViewById(R.id.ftt);
                textView.setOnClickListener(this);
                textView.setVisibility(0);
                this.Z0.findViewById(R.id.kxq).setVisibility(8);
                this.Z0.findViewById(R.id.f166524fu4).setVisibility(0);
                this.f49763a1 = (TextView) this.Z0.findViewById(R.id.kxr);
                this.f49765b1 = (TextView) this.Z0.findViewById(R.id.kxv);
                this.f49767c1 = (TextView) this.Z0.findViewById(R.id.kxw);
            } else if (BasePicureViewController.g0()) {
                View findViewById = this.Z0.findViewById(R.id.ftp);
                this.f49773f1 = findViewById;
                findViewById.setVisibility(0);
                this.Y1 = (AvatarImageView) this.f49773f1.findViewById(R.id.ftn);
                this.Z1 = (TextView) this.f49773f1.findViewById(R.id.ftq);
                ((Button) this.f49773f1.findViewById(R.id.fto)).setOnClickListener(this);
                this.Y1.setOnClickListener(this);
                TextView textView2 = (TextView) this.Z0.findViewById(R.id.kxq);
                this.f49763a1 = textView2;
                textView2.setVisibility(8);
                this.f49763a1 = null;
                relativeLayout.setBackgroundColor(0);
            } else {
                this.f49769d1 = relativeLayout;
                this.f49763a1 = (TextView) this.Z0.findViewById(R.id.kxq);
                this.R2.setDuration(300L);
                this.S2.setDuration(300L);
                this.R2.setFillAfter(true);
                this.S2.setFillAfter(true);
            }
            View findViewById2 = this.Z0.findViewById(R.id.ftc);
            this.f49771e1 = findViewById2;
            findViewById2.getLayoutParams().height = this.f49771e1.getLayoutParams().height + notchHeight + ViewUtils.dip2px(10.0f);
            View view = this.f49771e1;
            view.setPadding(view.getPaddingLeft(), this.f49771e1.getPaddingTop() + notchHeight, this.f49771e1.getPaddingRight(), this.f49771e1.getPaddingBottom());
            ((TextView) this.Z0.findViewById(R.id.ftu)).setOnClickListener(this);
            this.f49805v1 = (ImageView) this.Z0.findViewById(R.id.fu5);
            n3(this.Z0);
        } catch (Throwable th5) {
            QZLog.w(th5);
        }
    }

    private void k7() {
        ImageView imageView = new ImageView(this);
        this.D1 = imageView;
        imageView.setImageResource(R.drawable.bvx);
        this.D1.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.D1.setAdjustViewBounds(true);
        this.D1.setMaxWidth(ViewUtils.dpToPx(24.0f));
        this.D1.setMaxHeight(ViewUtils.dpToPx(24.0f));
        this.D1.setId(R.id.fsz);
        j3(this.D1);
        boolean bool = LocalMultiProcConfig.getBool(LocalMultiProcConfig.Constants.KEY_PHOTO_COMMENT_DANMAKU_SWITCH + LoginData.getInstance().getUinString(), this.f49776g2);
        this.f49776g2 = bool;
        if (bool) {
            t6();
        } else {
            this.D1.setImageResource(R.drawable.bvx);
        }
        this.D1.setOnClickListener(new n());
        if (!u5.b.D("key_first_time_enter_picture_viewer", true) || this.f49776g2 || this.f49483l0.f49877g.commentNum <= 0) {
            return;
        }
        u5.b.o0("key_first_time_enter_picture_viewer", false);
        this.D1.post(new Runnable() { // from class: com.qzone.preview.QzonePictureViewer.5
            @Override // java.lang.Runnable
            public void run() {
                QzoneGuideBubbleHelper.g().n(QzonePictureViewer.this.getOutActivity(), QzonePictureViewer.this.D1, QzonePictureViewer.this.getString(R.string.gjw), 1, 16.0f, 5.0d, 10.0d, 5000L, -16669697, false, true, 0, null, 0, true, 1.0f, null);
            }
        });
    }

    private void l6(PhotoInfo photoInfo) {
        if (this.K1 == null || this.L1 == null || photoInfo == null || photoInfo.videodata == null) {
            return;
        }
        if (ae.b() != null && ae.b().snapshot() != null) {
            QLog.i("[PhotoAlbum]QzonePictureViewer", 1, "original map is " + ae.b().snapshot().size());
        }
        if (photoInfo.videodata.actionUrl.equals("")) {
            if (ae.b().snapshot().containsKey(photoInfo.lloc) && !this.R1) {
                QLog.i("[PhotoAlbum]QzonePictureViewer", 1, "photo info id " + photoInfo.lloc + " map contains id");
                this.K1.setVisibility(0);
            } else {
                QLog.i("[PhotoAlbum]QzonePictureViewer", 1, "photo info id " + photoInfo.lloc + " map not contains id");
                this.K1.setVisibility(8);
            }
            this.L1.setVisibility(8);
            return;
        }
        VideoPlayInfo a16 = ae.a(photoInfo.videodata);
        if (a16.videoId != null && BaseVideoManagerUtils.getOriginalVideoMap().containsKey(a16.videoId)) {
            QLog.i("[PhotoAlbum]QzonePictureViewer", 1, "video info id " + photoInfo.lloc + " map contains id");
            this.L1.setVisibility(0);
        } else {
            QLog.i("[PhotoAlbum]QzonePictureViewer", 1, "video info id " + photoInfo.lloc + " map not contains id");
            this.L1.setVisibility(8);
        }
        this.K1.setVisibility(8);
    }

    private void m6() {
        Button button = new Button(this);
        this.M1 = button;
        button.setBackgroundDrawable(getResources().getDrawable(R.drawable.gbi));
        this.M1.setText(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewFoundMorePicture", "\u53d1\u73b0\u66f4\u591a\u7cbe\u7f8e\u914d\u56fe"));
        this.M1.setTextColor(getResources().getColor(R.color.f158017al3));
        this.M1.setTextSize(15.0f);
        this.M1.setOnClickListener(new a());
        this.M1.setPadding(ViewUtils.dip2px(20.0f), ViewUtils.dip2px(2.0f), ViewUtils.dip2px(20.0f), ViewUtils.dip2px(2.0f));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(14, -1);
        layoutParams.bottomMargin = (int) (ViewUtils.getScreenHeight() * 0.2d);
        this.M1.setVisibility(4);
        this.G0.k().g().addView(this.M1, layoutParams);
    }

    private void m7() {
        PhotoInfo b16 = this.f49483l0.b();
        Intent intent = new Intent(this, (Class<?>) FeedActionPanelActivity.class);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.FEED_TEXT_AUTOFILL_INTENT_KEY, b16.desc);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.NEEDTRANSEMOJ, 1);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_CACHE_UNIKEY, LoginData.getInstance().getUin() + "_" + b16.albumId + "_" + b16.lloc);
        intent.putExtra("inputmax", 200);
        intent.putExtra("showaticon", 0);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_IS_SYSTEM_TRANSPARENTBAR, 0);
        intent.putExtra("canVertical", true);
        com.qzone.feed.utils.b.f(this, intent, 7);
        ClickReport.m("368", "7", "");
    }

    private boolean n6(int i3) {
        String str;
        ShareActionSheetBuilder.ActionSheetItem build = ShareActionSheetBuilder.ActionSheetItem.build(i3);
        List<ShareActionSheetBuilder.ActionSheetItem> list = this.f49477f0;
        if (list == null) {
            return false;
        }
        for (ShareActionSheetBuilder.ActionSheetItem actionSheetItem : list) {
            if (actionSheetItem != null && build != null && (str = actionSheetItem.label) != null && str.equals(build.label)) {
                return true;
            }
        }
        return false;
    }

    private boolean o6() {
        BasePicureViewController basePicureViewController = this.f49483l0;
        if (basePicureViewController != null && basePicureViewController.getSelectedIndex() > 0) {
            return (this.f49483l0.getSelectedIndex() < this.f49494w0 || this.f49483l0.getSelectedIndex() < this.f49483l0.getCount()) && !this.N1;
        }
        return false;
    }

    private boolean o7() {
        BasePicureViewController basePicureViewController = this.f49483l0;
        return (basePicureViewController == null || basePicureViewController.A != 1 || basePicureViewController.b() == null || this.f49483l0.b().mFaceList == null || this.f49483l0.b().mFaceList.size() <= 0 || this.f49483l0.b().videoflag == 1 || this.f49483l0.b().isPanorama()) ? false : true;
    }

    private void p7(boolean z16) {
        AppRuntime peekAppRuntime;
        if (this.f49483l0.e0() || this.f49483l0.j0()) {
            return;
        }
        PhotoInfo b16 = this.f49483l0.b();
        super.w1();
        boolean z17 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PHOTOVIEW_CAN_SHOW_DELETE_BUTTON, 1) == 1;
        boolean q75 = q7();
        boolean z18 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PHOTOVIEW_CAN_SHOW_FACE_BUTTON, 1) == 1;
        if (!n6(106)) {
            s3(2, 106, R.string.gk9, R.drawable.qzone_more_menu_photo_face, z18 && o7());
        }
        if (!n6(40)) {
            s3(2, 40, R.string.gk8, R.drawable.qzone_more_menu_delete, (BasePicureViewController.a0() || BasePicureViewController.b0() || BasePicureViewController.f0()) && (this.f49483l0.q0() || this.f49483l0.k0() || this.f49483l0.p0()) && BasePicureViewController.e(this.f49483l0.b()) && z17);
        }
        Pair<Boolean, Boolean> q65 = q6();
        if (q65 != null) {
            QZLog.d("[PhotoAlbum]QzonePictureViewer", 1, "showMoreActionMenu... qrCode.first:", q65.first, " qrCode.second:", q65.second);
            if (!n6(56)) {
                s3(2, 56, R.string.bg9, R.drawable.cn_, ((Boolean) q65.second).booleanValue());
            }
            if (((Boolean) q65.second).booleanValue()) {
                LpReportInfo_pf00064.allReport(301, 5, 1);
            }
            if (!n6(23)) {
                s3(2, 23, R.string.gkj, R.drawable.g9q, ((Boolean) q65.first).booleanValue());
            }
        }
        if (this.f49483l0.h0() && this.I0 == 0 && !n6(100)) {
            s3(1, 100, R.string.f173011gg4, R.drawable.qzone_icon_action_sheet_forward, (o4() || BasePicureViewController.i0()) ? false : true);
            J4(100, this.f49483l0.f());
        }
        if (!BasePicureViewController.o0() && this.I0 != 1 && !this.f49483l0.f49894x && !n6(107)) {
            s3(2, 107, R.string.gkl, R.drawable.qzone_more_menu_cover, !o4());
        }
        if (this.I0 != 1 && !n6(52) && (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) != null) {
            String currentAccountUin = peekAppRuntime.getCurrentAccountUin();
            if (!TextUtils.isEmpty(currentAccountUin)) {
                s3(2, 52, R.string.gkb, R.drawable.qzone_icon_action_sheet_ocr, q75 && !((!((IOCRService) peekAppRuntime.getRuntimeService(IOCRService.class, "qzone")).isQZoneSupportOcr(currentAccountUin) && !BasePicureViewController.o0()) || o4() || g4()));
            }
        }
        if (!n6(11)) {
            s3(2, 11, R.string.gka, R.drawable.qzone_detail_panel_report, this.f49483l0.k());
        }
        if ((o4() || BasePicureViewController.i0() || BasePicureViewController.o0() || this.f49764a2 != 0) && !this.f49483l0.g()) {
            L4(6);
            L4(84);
        }
        if (BasePicureViewController.o0()) {
            L4(9);
        }
        J4(2, u3(false));
        J4(203, u3(false));
        J4(9, u3(true) && c4());
        J4(6, (b16.photoOpmask & 16) == 0);
        C3();
        if (z16) {
            ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "6", "", true);
        }
        if (this.f49475d0 != null) {
            if (this.U1 == null) {
                this.U1 = new q(this, getHandler());
            }
            this.f49475d0.setAdvView(this.U1.c(), new RelativeLayout.LayoutParams(-1, -2));
            this.U1.d(this.V1, this.W1, this.X1, !o4());
        }
    }

    private Pair<Boolean, Boolean> q6() {
        if (this.f49780i2 == -1) {
            this.f49780i2 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.QZONE_CONFIG_SECONDARY_KEY_IS_QRCODE_SCAN, 1);
        }
        if (this.f49780i2 == 0) {
            QZLog.d("[PhotoAlbum]QzonePictureViewer", 1, "isNeedOpenQRCode... isQrcodeScanOpen == 0");
            Boolean bool = Boolean.FALSE;
            return new Pair<>(bool, bool);
        }
        if (!o4()) {
            return e6(this.f49483l0.b());
        }
        Boolean bool2 = Boolean.FALSE;
        return new Pair<>(bool2, bool2);
    }

    private boolean q7() {
        String[] split;
        String config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PHOTOVIEW_CAN_SHOW_OCR_BUTTON, QzoneConfig.DefaultValue.DEFAULT_SHOW_OCR_BUTTON);
        int[] iArr = new int[2];
        if (!TextUtils.isEmpty(config) && (split = config.split("-")) != null && split.length >= 2) {
            iArr[0] = Integer.parseInt(split[0]);
            iArr[1] = Integer.parseInt(split[1]);
        }
        long uin = LoginData.getInstance().getUin() % 100;
        return uin >= ((long) iArr[0]) && uin < ((long) iArr[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r7(boolean z16) {
        if (this.F1 == null) {
            return;
        }
        boolean r65 = r6();
        boolean z17 = z16 && r65;
        int i3 = z17 ? 0 : 8;
        if (this.F1.getVisibility() != i3) {
            QLog.d("[PhotoAlbum]QzonePictureViewer", 2, "[showOriginalImageBtnLayout] isSelfPicture: " + r65 + " | isShowOriginButton: " + z17);
        }
        this.F1.setVisibility(i3);
    }

    private boolean s6() {
        return this.f49483l0.F().videoflag == 1 && (this.f49483l0.F().videodata.videoStatus == 1 || this.f49483l0.F().videodata.videoStatus == 0);
    }

    private void s7() {
        TextView textView = this.G1;
        if (textView != null) {
            textView.setText(R.string.f214675tj);
        }
    }

    private boolean v6() {
        String[] split;
        String config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PICTURE_VIEWER_DANMAKU_GARY_RANGE, QzoneConfig.DEFAULT_PICTURE_VIEWER_DANMAKU_GARY_RANGE);
        int[] iArr = new int[2];
        if (!TextUtils.isEmpty(config) && (split = config.split("-")) != null && split.length >= 2) {
            iArr[0] = Integer.parseInt(split[0]);
            iArr[1] = Integer.parseInt(split[1]);
        }
        long uin = LoginData.getInstance().getUin() % 100;
        return uin >= ((long) iArr[0]) && uin < ((long) iArr[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w6(File file) {
        Bitmap a16;
        String absolutePath = file.getAbsolutePath();
        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastTextIdentifyFail", "\u6587\u5b57\u8bc6\u522b\u5931\u8d25");
        if (SharpPUtils.isSharpP(file) || com.tencent.qzone.avif.a.a(file)) {
            try {
                if (SharpPUtils.isSharpP(file)) {
                    a16 = SharpPUtils.decodeSharpP(file.getAbsolutePath());
                } else {
                    a16 = (com.tencent.qzone.avif.a.a(file) && QZoneConfigHelper.i()) ? com.tencent.qzone.image.api.a.c().a(file, absolutePath, 0, 0) : null;
                }
                if (a16 != null) {
                    String str = String.valueOf(System.currentTimeMillis()) + ".jpeg";
                    String str2 = AppConstants.SDCARD_IMG_SAVE;
                    File file2 = new File(VFSAssistantUtils.getSDKPrivatePath(str2));
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    absolutePath = VFSAssistantUtils.getSDKPrivatePath(str2 + str);
                    if (com.qzone.util.image.c.V(a16, absolutePath, Bitmap.CompressFormat.JPEG, 90, true)) {
                        if (QZLog.isColorLevel()) {
                            QZLog.i("[PhotoAlbum]QzonePictureViewer", "onOcrClick sharpp file save success:" + absolutePath);
                        }
                    } else {
                        ToastUtil.s(config, 4);
                        QZLog.e("[PhotoAlbum]QzonePictureViewer", "onOcrClick ImageUtil.saveBitmapToFile return false");
                        return;
                    }
                } else {
                    ToastUtil.s(config, 4);
                    QZLog.e("[PhotoAlbum]QzonePictureViewer", "onOcrClick SharpPUtils.decodeSharpP return null");
                    return;
                }
            } catch (Throwable th5) {
                ToastUtil.s(config, 4);
                QZLog.e("[PhotoAlbum]QzonePictureViewer", "onOcrClick catch an exception: ", th5);
                return;
            }
        }
        String str3 = absolutePath;
        if (QZLog.isColorLevel()) {
            QZLog.i("[PhotoAlbum]QzonePictureViewer", "onOcrClick jump to scan ocr " + str3);
        }
        ((IOCR) QRoute.api(IOCR.class)).startOcrPerformFragment(getOutActivity(), str3, 2, -1009, null, false);
    }

    private void z6(PhotoInfo photoInfo) {
        if (photoInfo != null && !TextUtils.isEmpty(photoInfo.appAdSchema)) {
            yo.d.b(this, new yo.g(photoInfo.appAdSchema));
            if (QZLog.isColorLevel()) {
                QZLog.d("[PhotoAlbum]QzonePictureViewer", 2, "QzonePictureViewer forward ad = " + photoInfo.appAdSchema);
            }
            LpReportInfo_pf00064.allReport(301, 33, 2);
            return;
        }
        QZLog.e("[PhotoAlbum]QzonePictureViewer", "QzonePictureViewer forward ad fail .");
    }

    public void A7() {
        TextView textView = this.f49763a1;
        if (textView == null) {
            return;
        }
        if (textView.getVisibility() == 4) {
            this.f49763a1.startAnimation(this.R2);
            this.f49763a1.postDelayed(this.Q2, 2000L);
        } else {
            this.f49763a1.removeCallbacks(this.Q2);
            this.f49763a1.clearAnimation();
            this.f49763a1.postDelayed(this.Q2, 2000L);
        }
    }

    @Override // com.qzone.preview.BasePictureViewer
    protected void C4() {
        try {
            e7();
            o7();
            if (BasePicureViewController.g0() && this.Z0 != null) {
                PhotoInfo F = this.f49483l0.F();
                this.Y1.j(F.uploaduin);
                this.Z1.setText(F.uploadOwner);
            }
        } catch (Exception e16) {
            QZLog.w(e16);
        }
        B7();
    }

    protected void C6() {
        if (!PictureManager.getInstance().checkNetworkConnect()) {
            ToastUtil.n(R.string.gdc);
            return;
        }
        if (this.M2 == null) {
            this.M2 = com.qzone.widget.util.b.d(this);
        }
        this.M2.show();
        t4();
        F4();
        this.f49483l0.t(getHandler());
    }

    @Override // com.qzone.preview.BasePictureViewer
    public void E3(int i3, final PhotoInfo photoInfo, boolean z16) {
        final d dVar = new d(z16, photoInfo, i3);
        final ImageLoader.Options obtain = ImageLoader.Options.obtain();
        obtain.justCover = false;
        obtain.needShowGifAnimation = true;
        obtain.type = AppConstants.HTTP_TYPE_QZONE_DOWNLOAD_BIG_PIC;
        obtain.needCallBackProcessPercent = true;
        obtain.isNeedPieceLoad = true;
        if (i3 != 1 && i3 != 3 && i3 != 4 && i3 != 5) {
            if (i3 == 2) {
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.preview.QzonePictureViewer.29
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ImageLoader.getInstance().getImageFile(photoInfo.orgUrl) == null) {
                            QzonePictureViewer.this.getHandler().post(new Runnable() { // from class: com.qzone.preview.QzonePictureViewer.29.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    QzonePictureViewer.this.x7(true);
                                }
                            });
                        }
                        QzonePictureViewer qzonePictureViewer = QzonePictureViewer.this;
                        qzonePictureViewer.f49483l0.y(qzonePictureViewer.getHandler(), dVar, obtain, 1000063, photoInfo);
                    }
                });
                return;
            }
            return;
        }
        if (this.I0 != 1) {
            x7(true);
        }
        if (i3 == 3 || i3 == 4 || i3 == 5) {
            photoInfo.showGifState = PhotoInfo.SHOW_NEITHER_GIF_NOR_PLAY;
            if (this.f49495x0 == this.f49483l0.P().length - 1) {
                notifyDataSetChanged();
            }
        }
        this.f49483l0.x(getHandler(), dVar, obtain, Y5(i3), photoInfo, z16);
    }

    @Override // com.qzone.preview.BasePictureViewer, com.qzone.preview.b
    public void H0(int i3) {
        y4(i3, this.f49483l0.F());
    }

    public boolean R6() {
        return PackageUtil.isPackageInstalled(getApplicationContext(), "com.tencent.ttpic");
    }

    @Override // com.qzone.preview.BasePictureViewer, com.qzone.preview.b
    public void S0(boolean z16) {
        View view;
        super.S0(z16);
        View view2 = this.f49769d1;
        if (BasePicureViewController.g0()) {
            view2 = this.f49773f1;
        }
        if (view2 != null && this.f49771e1 != null) {
            this.K2 = view2.getVisibility();
            view2.setVisibility(8);
            this.f49771e1.setVisibility(0);
        }
        if (this.f49781j1 != null && (view = this.f49783k1) != null && this.f49777h1 != null) {
            this.L2 = view.getVisibility();
            this.f49781j1.setVisibility(4);
            this.f49783k1.setVisibility(4);
            this.f49777h1.setVisibility(0);
            View view3 = this.f49779i1;
            if (view3 != null) {
                if (z16) {
                    view3.setVisibility(0);
                } else {
                    view3.setVisibility(8);
                }
            }
        }
        c7(8);
        if (!pl.a.f426446a.y() && getOutActivity() != null) {
            getOutActivity().setRequestedOrientation(1);
        }
        this.f49802t2 = true;
    }

    @Override // com.qzone.preview.BasePictureViewer, com.qzone.preview.b
    public void S7(boolean z16) {
        super.S7(z16);
        View view = this.f49799s1;
        if (view != null) {
            view.setVisibility(z16 ? 0 : 8);
        }
        View view2 = this.f49801t1;
        if (view2 != null) {
            view2.setVisibility((z16 || s6()) ? 8 : 0);
        }
    }

    @Override // com.qzone.preview.BasePictureViewer, com.qzone.preview.b
    public void U7() {
        super.U7();
        CommentListBaseController commentListBaseController = this.E2;
        if (commentListBaseController == null || !commentListBaseController.k0()) {
            return;
        }
        this.E2.v();
    }

    @Override // com.qzone.preview.BasePictureViewer
    protected void Y4() {
        if (this.f49483l0.i(BasePictureViewer.X0) && this.f49475d0 != null) {
            this.f49483l0.F0(new QzoneFavoriteService.d() { // from class: com.qzone.preview.QzonePictureViewer.18
                @Override // com.qzone.business.favorite.service.QzoneFavoriteService.d
                public void a(String str, final boolean z16) {
                    QzonePictureViewer qzonePictureViewer = QzonePictureViewer.this;
                    if (qzonePictureViewer.f49475d0 != null) {
                        qzonePictureViewer.runOnUiThread(new Runnable() { // from class: com.qzone.preview.QzonePictureViewer.18.1
                            @Override // java.lang.Runnable
                            public void run() {
                                boolean q06;
                                QzonePictureViewer.this.f49810x2 = z16;
                                if (z16) {
                                    q06 = QzonePictureViewer.this.f49475d0.q0(6, 84);
                                } else {
                                    q06 = QzonePictureViewer.this.f49475d0.q0(84, 6);
                                }
                                if (q06) {
                                    QzonePictureViewer.this.f49475d0.refresh();
                                }
                            }
                        });
                    }
                }
            }, this.f49483l0.U(), false);
        }
    }

    protected void d6(QZoneResult qZoneResult) {
        get_photo_comment_rsp get_photo_comment_rspVar;
        cell_comment cell_commentVar;
        ArrayList<s_commment> arrayList;
        Bundle bundle = qZoneResult.getBundle();
        if (bundle != null && (get_photo_comment_rspVar = (get_photo_comment_rsp) bundle.getSerializable("response")) != null && (cell_commentVar = get_photo_comment_rspVar.comment) != null && (arrayList = cell_commentVar.commments) != null) {
            ArrayList<PhotoDanmakuModel> arrayList2 = this.f49792o2;
            if (arrayList2 == null) {
                this.f49792o2 = new ArrayList<>();
            } else {
                arrayList2.clear();
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                s_commment s_commmentVar = arrayList.get(i3);
                QzoneBarrageEffectData.BarrageEffectInfo fromFeedsJceData = QzoneBarrageEffectData.BarrageEffectInfo.fromFeedsJceData(s_commmentVar.binaryExtInfo.get(UNIVERSAL_MALL_QUAL.value));
                String str = s_commmentVar.content;
                s_user s_userVar = s_commmentVar.user;
                long j3 = s_userVar.uin;
                String str2 = s_userVar.nickname;
                String str3 = s_commmentVar.extendInfo.get("sparkle_json");
                String str4 = s_commmentVar.extendInfo.get("diy_font_id");
                String str5 = s_commmentVar.extendInfo.get("diy_font_type");
                String str6 = s_commmentVar.extendInfo.get("diy_font_url");
                if (!TextUtils.isEmpty(str)) {
                    this.f49792o2.add(new PhotoDanmakuModel(str2, j3, str, (str3 == null || TextUtils.isEmpty(str3)) ? null : QzoneSuperPersonalFontData.SuperFontInfo.fromJson(str3), str4, str5, str6, fromFeedsJceData));
                }
            }
        }
        ArrayList<PhotoDanmakuModel> arrayList3 = this.f49792o2;
        if (arrayList3 == null || arrayList3.size() <= 0) {
            return;
        }
        U6(this.f49792o2);
    }

    protected void f6() {
        BasePicureViewController basePicureViewController;
        View inflate = this.f49472a0.inflate(R.layout.bqj, (ViewGroup) null);
        this.f49775g1 = inflate;
        this.f49781j1 = inflate.findViewById(R.id.fth);
        this.f49783k1 = this.f49775g1.findViewById(R.id.fti);
        RelativeLayout relativeLayout = (RelativeLayout) this.f49775g1.findViewById(R.id.fte);
        this.f49777h1 = relativeLayout;
        relativeLayout.setPadding(relativeLayout.getPaddingLeft(), this.f49777h1.getPaddingTop(), this.f49777h1.getPaddingRight(), ViewUtils.dpToPx(20.0f));
        View findViewById = this.f49775g1.findViewById(R.id.ftd);
        this.f49779i1 = findViewById;
        findViewById.setOnClickListener(this);
        this.f49785l1 = (CellTextView) this.f49775g1.findViewById(R.id.ftl);
        this.F1 = (RelativeLayout) this.f49775g1.findViewById(R.id.ftj);
        this.G1 = (TextView) this.f49775g1.findViewById(R.id.ffk);
        this.H1 = (TextView) this.f49775g1.findViewById(R.id.ffm);
        this.G1.setOnClickListener(this);
        this.H1.setVisibility(8);
        this.I1 = (TextView) this.f49775g1.findViewById(R.id.f215501b);
        this.J1 = (TextView) this.f49775g1.findViewById(R.id.f215701d);
        this.K1 = (LinearLayout) this.f49775g1.findViewById(R.id.f215601c);
        this.L1 = (LinearLayout) this.f49775g1.findViewById(R.id.f215801e);
        this.f49799s1 = this.f49775g1.findViewById(R.id.ftk);
        this.f49801t1 = this.f49775g1.findViewById(R.id.ftg);
        this.f49803u1 = this.f49775g1.findViewById(R.id.f166521fu1);
        this.f49789n1 = (TextView) this.f49775g1.findViewById(R.id.ftw);
        this.f49791o1 = (TextView) this.f49775g1.findViewById(R.id.f166724hn1);
        this.f49787m1 = (ImageView) this.f49775g1.findViewById(R.id.f166522fu2);
        this.f49795q1 = (ImageView) this.f49775g1.findViewById(R.id.ftx);
        this.f49793p1 = (TextView) this.f49775g1.findViewById(R.id.hmz);
        this.f49797r1 = (ImageView) this.f49775g1.findViewById(R.id.fu8);
        this.T1 = (ImageView) this.f49775g1.findViewById(R.id.fu6);
        BasePicureViewController basePicureViewController2 = this.f49483l0;
        if (basePicureViewController2 != null && basePicureViewController2.j0()) {
            this.T1.setVisibility(4);
        } else {
            this.T1.setOnClickListener(this);
        }
        this.S1 = (CellTextView) this.f49775g1.findViewById(R.id.kxm);
        if ((BasePicureViewController.a0() || BasePicureViewController.b0()) && this.f49483l0 != null && LoginData.getInstance().getUin() == this.f49483l0.f49877g.ownerUin) {
            this.S1.setVisibility(0);
            this.f49785l1.setVisibility(8);
        } else {
            this.S1.setVisibility(8);
        }
        this.S1.setCellClickable(false);
        this.S1.setOnClickListener(this);
        if (!BasePicureViewController.a0() && !BasePicureViewController.b0()) {
            this.S1.setMaxLine(1);
            this.f49785l1.setMaxLine(1);
        } else {
            this.S1.setMaxLine(3);
            this.f49785l1.setMaxLine(3);
        }
        if (!BasePicureViewController.n0() && ((basePicureViewController = this.f49483l0) == null || !basePicureViewController.c0())) {
            this.f49783k1.setVisibility(4);
            this.f49781j1.setVisibility(4);
            this.f49775g1.setVisibility(8);
        }
        this.f49789n1.setOnClickListener(this);
        if (this.f49806v2 == 2) {
            this.f49789n1.setGravity(17);
        }
        this.f49797r1.setOnClickListener(this);
        this.f49787m1.setOnClickListener(this);
        this.f49795q1.setOnClickListener(this);
        this.f49785l1.setCellClickable(false);
        this.f49785l1.setOnClickListener(this);
        this.f49781j1.setPadding(0, 0, 0, 0);
        BasePicureViewController basePicureViewController3 = this.f49483l0;
        if (basePicureViewController3 != null && basePicureViewController3.h() && !this.f49483l0.j0()) {
            l3(this.f49775g1);
        }
        g6();
    }

    public void f7(final PhotoInfo photoInfo) {
        if (this.F1 == null || photoInfo == null) {
            return;
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.qzone.preview.QzonePictureViewer.25
            /* JADX WARN: Code restructure failed: missing block: B:18:0x004d, code lost:
            
                if (r2.isPanorama() == false) goto L21;
             */
            /* JADX WARN: Removed duplicated region for block: B:22:0x005e  */
            /* JADX WARN: Removed duplicated region for block: B:32:0x0060  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                boolean z16;
                PhotoInfo photoInfo2 = photoInfo;
                if (photoInfo2 == null) {
                    return;
                }
                if (photoInfo2.photoType == 2 && !TextUtils.isEmpty(photoInfo2.orgUrl)) {
                    QzonePictureViewer.this.getHandler().post(new Runnable() { // from class: com.qzone.preview.QzonePictureViewer.25.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QzonePictureViewer.this.w7(false);
                        }
                    });
                    return;
                }
                final boolean z17 = false;
                if (!TextUtils.isEmpty(photoInfo.orgUrl)) {
                    PhotoInfo photoInfo3 = photoInfo;
                    if (!photoInfo3.orgUrl.equals(photoInfo3.bigUrl)) {
                        if (ImageLoader.getInstance().getImageFile(photoInfo.orgUrl) == null) {
                        }
                    }
                }
                if (!photoInfo.appAdShow) {
                    z16 = false;
                    if ((z16 & (!(photoInfo.videoflag != 1))) && !QzonePictureViewer.this.R1 && !ae.b().snapshot().containsKey(photoInfo.lloc)) {
                        z17 = true;
                    }
                    QzonePictureViewer.this.getHandler().post(new Runnable() { // from class: com.qzone.preview.QzonePictureViewer.25.2
                        @Override // java.lang.Runnable
                        public void run() {
                            QzonePictureViewer.this.w7(z17);
                        }
                    });
                }
                z16 = true;
                if (z16 & (!(photoInfo.videoflag != 1))) {
                    z17 = true;
                }
                QzonePictureViewer.this.getHandler().post(new Runnable() { // from class: com.qzone.preview.QzonePictureViewer.25.2
                    @Override // java.lang.Runnable
                    public void run() {
                        QzonePictureViewer.this.w7(z17);
                    }
                });
            }
        });
    }

    @Override // com.qzone.common.activities.base.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        PictureManager.getInstance().getSender().startDownloadVideo(getHandler());
        overridePendingTransition(0, 0);
    }

    protected void g6() {
        if (this.E2 == null) {
            CommentListBaseController s16 = CommentListBaseController.s(this, 1);
            this.E2 = s16;
            s16.B0(new o());
            CommentListLayout M = this.E2.M();
            this.D2 = M;
            i3(M);
            this.E2.v();
            this.E2.E0(new p());
        }
    }

    @Override // com.qzone.preview.BasePictureViewer, com.qzone.preview.b
    public View h8() {
        return this.f49799s1;
    }

    protected void i7() {
        PhotoParam G = this.f49483l0.G();
        Bundle bundle = new Bundle();
        if (BasePicureViewController.g0()) {
            bundle.putString(PictureConst.CELL_ID, G.cell_id);
            bundle.putLong("uin", G.feedUin);
            bundle.putString("sub_id", G.cell_subId);
            bundle.putInt("appid", G.appid);
            bundle.putString(QZoneResult.UGC_KEY, G.ugcKey);
            bundle.putString("feed_id", G.feedId);
            bundle.putParcelable("business_params", new MapParcelable(G.busi_param));
        } else if (BasePicureViewController.f0() || BasePicureViewController.a0() || BasePicureViewController.b0()) {
            PhotoInfo F = this.f49483l0.F();
            Map map = G.busi_param;
            if (map == null) {
                map = new HashMap();
            }
            if (!TextUtils.isEmpty(F.lloc)) {
                map.put(2, F.lloc);
                map.put(1, F.lloc);
            }
            map.put(7, "1");
            if (G.appid == 4) {
                bundle.putLong("uin", G.ownerUin);
            } else {
                bundle.putLong("uin", G.feedUin);
            }
            bundle.putString(PictureConst.CELL_ID, G.cell_id);
            bundle.putInt("appid", G.appid);
            bundle.putString(QZoneResult.UGC_KEY, G.ugcKey);
            bundle.putParcelable("business_params", new MapParcelable(map));
        }
        this.E2.C0(bundle);
        if (this.E2.T() != null && this.E2.T().g0() != null) {
            this.E2.T().g0().setLoadingBackgroundColor(-16777216);
        }
        this.E2.G0();
        o5();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.preview.BasePictureViewer
    public void initData() {
        super.initData();
        BasePicureViewController basePicureViewController = this.f49483l0;
        if (basePicureViewController != null) {
            this.f49483l0.F0(null, basePicureViewController.U(), false);
        }
        LocalMultiProcConfig.putBool(LocalMultiProcConfig.Constants.KEY_HAS_ENTER_PICTURE_VIEWER, true);
        W6();
        if (getResources() != null && getResources().getConfiguration() != null) {
            this.f49806v2 = getResources().getConfiguration().orientation;
        } else {
            this.f49806v2 = 1;
        }
    }

    @Override // com.qzone.preview.BasePictureViewer
    protected boolean n4() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_QZONE_PICTURE_OPT_SCALE, 1) == 1;
    }

    @Override // com.qzone.preview.BasePictureViewer, com.qzone.preview.b
    public Callback n7() {
        return this.P2;
    }

    @Override // com.qzone.preview.BasePictureViewer, com.qzone.preview.b
    public TextView o3() {
        return this.H1;
    }

    @Override // com.qzone.preview.BasePictureViewer, com.qzone.preview.b
    public void o5() {
        View view = this.Z0;
        if (view != null) {
            if (view.getVisibility() == 0) {
                if (this.f49807w1 == null) {
                    j6(false);
                }
                this.Z0.startAnimation(this.f49807w1);
            } else {
                if (this.f49809x1 == null) {
                    j6(true);
                }
                this.Z0.startAnimation(this.f49809x1);
            }
        }
        View view2 = this.f49781j1;
        if (view2 != null) {
            if (view2.getVisibility() == 0) {
                if (this.f49813z1 == null) {
                    initFooterAnimation(true);
                }
                this.f49783k1.startAnimation(this.f49813z1);
            } else {
                if (this.f49811y1 == null) {
                    initFooterAnimation(false);
                }
                this.f49783k1.startAnimation(this.f49811y1);
            }
        }
    }

    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        BasePicureViewController basePicureViewController;
        if (o6()) {
            QLog.d("[PhotoAlbum]QzonePictureViewer", 1, "is left smooth");
            return;
        }
        if (!this.f49804u2 && this.f49802t2 && (basePicureViewController = this.f49483l0) != null) {
            basePicureViewController.a(basePicureViewController.getSelectedIndex());
            notifyDataSetChanged();
        } else {
            this.f49800s2 = true;
            super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f166522fu2) {
            K6();
        } else if (id5 == R.id.ftw) {
            A6();
        } else if (id5 == R.id.fu8) {
            N6();
        } else if (id5 == R.id.ffk) {
            BasePicureViewController basePicureViewController = this.f49483l0;
            if (basePicureViewController != null && basePicureViewController.F() != null && this.f49483l0.F().appAdShow) {
                z6(this.f49483l0.F());
            } else {
                H0(1);
                QLog.d("[PhotoAlbum]QzonePictureViewer", 1, "origin_btn click");
                ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "12", "", true);
            }
        } else if (id5 == R.id.cuq) {
            H0(2);
        } else if (id5 == R.id.ftx) {
            if (BasePicureViewController.o0()) {
                BasePicureViewController basePicureViewController2 = this.f49483l0;
                if (basePicureViewController2 == null) {
                    QLog.e("[PhotoAlbum]QzonePictureViewer", 1, "[onClick] pictureViewController == null", new Exception());
                } else {
                    PhotoParam G = basePicureViewController2.G();
                    PhotoInfo F = this.f49483l0.F();
                    if (F == null) {
                        QLog.e("[PhotoAlbum]QzonePictureViewer", 1, "[onClick] photoInfo == null", new Exception());
                    } else if (G == null) {
                        QLog.e("[PhotoAlbum]QzonePictureViewer", 1, "[onClick] photo param should not be null", new Exception());
                    } else {
                        boolean isEmpty = TextUtils.isEmpty(G.qunid);
                        String str = QzoneConfig.DEFAULT_QZONE_QUN_DETAIL;
                        if (!isEmpty) {
                            str = QzoneConfig.DEFAULT_QZONE_QUN_DETAIL.replace("{qunid}", G.qunid);
                        }
                        if (!TextUtils.isEmpty(F.albumId)) {
                            str = str.replace("{albumid}", F.albumId);
                        }
                        if (!TextUtils.isEmpty(F.lloc)) {
                            str = str.replace("{lloc}", F.lloc);
                        }
                        QZoneHelper.forwardToBrowser(this, str.replace("{uploadtime}", F.uploadtime + "").replace("{qua}", QUA.getQUA3() + "") + "&fromPic=1", 0, null, "");
                    }
                }
            } else {
                G6();
            }
        } else if (id5 == R.id.ftt) {
            ClickReport.m(ProfileCardTemplate.PROFILE_COMMON_VERSION, "4", "");
            finish();
        } else if (id5 == R.id.ftu) {
            BasePicureViewController basePicureViewController3 = this.f49483l0;
            if (basePicureViewController3 instanceof com.qzone.preview.business.d) {
                LpReportInfo_pf00064.allReport(301, 24, 2);
            } else if (basePicureViewController3 instanceof com.qzone.preview.business.b) {
                LpReportInfo_pf00064.allReport(301, 24, 1);
            }
            if (this.f49804u2) {
                finish();
            } else {
                BasePicureViewController basePicureViewController4 = this.f49483l0;
                if (basePicureViewController4 != null) {
                    basePicureViewController4.a(basePicureViewController4.getSelectedIndex());
                    notifyDataSetChanged();
                }
            }
        } else if (id5 == R.id.fu6) {
            p7(false);
            ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "14", "", true);
        } else if (id5 == R.id.kxm) {
            m7();
        } else if (id5 == R.id.fto) {
            Intent intent = new Intent();
            this.f49483l0.R0(intent);
            setResult(-1, intent);
            finish();
            QZLog.i("[PhotoAlbum]QzonePictureViewer", 1, "pictureviewer_friend_video_close_btn clicked.");
        } else if (id5 == R.id.ftn) {
            y6(this.f49483l0.b().uploaduin);
            QZLog.i("[PhotoAlbum]QzonePictureViewer", 1, "pictureviewer_friend_video_avatar clicked.");
        } else if (id5 == R.id.ftd) {
            BasePicureViewController basePicureViewController5 = this.f49483l0;
            if (basePicureViewController5 != null) {
                basePicureViewController5.s0(this);
                BasePicureViewController basePicureViewController6 = this.f49483l0;
                if (basePicureViewController6 instanceof com.qzone.preview.business.d) {
                    LpReportInfo_pf00064.allReport(301, 23, 2);
                } else if (basePicureViewController6 instanceof com.qzone.preview.business.b) {
                    LpReportInfo_pf00064.allReport(301, 23, 1);
                }
            }
        } else if (id5 == R.id.fu5) {
            J6();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.qzone.preview.BasePictureViewer, com.qzone.common.activities.base.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i3 = this.f49806v2;
        int i16 = configuration.orientation;
        if (i3 != i16) {
            if (i16 == 1) {
                P6();
            }
            if (configuration.orientation == 2) {
                O6();
            }
            this.f49806v2 = configuration.orientation;
        }
    }

    @Override // com.qzone.preview.BasePictureViewer, com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.f49808w2 = System.currentTimeMillis();
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.f49764a2 = intent.getLongExtra(PictureConst.KEY_FEED_DELETE_TIME, 0L);
        com.qzone.proxy.feedcomponent.e.c(this, getApplication());
        getHandler().postDelayed(new Runnable() { // from class: com.qzone.preview.QzonePictureViewer.1
            @Override // java.lang.Runnable
            public void run() {
                ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "1", "", true);
            }
        }, 500L);
        if (Build.VERSION.SDK_INT >= 27) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            Field field = JarReflectUtil.getField(attributes, "layoutInDisplayCutoutMode");
            if (field != null) {
                try {
                    field.setInt(attributes, 1);
                } catch (IllegalAccessException e16) {
                    e16.printStackTrace();
                }
            }
            getWindow().setAttributes(attributes);
        }
        if (intent.getExtras() != null) {
            this.f49798r2 = intent.getExtras().getString("recommend_report_uuid");
        }
        ((IQQFloatingWindowBroadcast) QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(getOutActivity(), false, 5);
    }

    @Override // com.qzone.preview.BasePictureViewer, com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.f49766b2 != null) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.FeedDeleteOnTimeThread).removeTask(this.f49766b2);
        }
        E7();
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.preview.QzonePictureViewer.17
            @Override // java.lang.Runnable
            public void run() {
                BasePicureViewController basePicureViewController = QzonePictureViewer.this.f49483l0;
                if (basePicureViewController != null) {
                    basePicureViewController.G0();
                }
            }
        });
        CommentListBaseController commentListBaseController = this.E2;
        if (commentListBaseController != null) {
            commentListBaseController.p0();
        }
        V6();
        ((IQQFloatingWindowBroadcast) QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(getOutActivity(), true, 0);
        getHandler().removeCallbacks(this.F2);
        getHandler().removeCallbacks(this.G2);
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        HdAsync hdAsync = this.T2;
        if (hdAsync == null || hdAsync.isDone()) {
            return;
        }
        this.T2.cancel();
    }

    @Override // com.qzone.preview.BasePictureViewer, com.qzone.common.activities.base.BaseActivity
    public void onHandleMessage(Message message) {
        QZoneResult unpack = QZoneResult.unpack(message);
        if (unpack == null) {
            return;
        }
        int i3 = message.what;
        if (i3 == 999908 || i3 == 999909 || i3 == 1000199) {
            unpack.what = i3;
        }
        int i16 = unpack.what;
        switch (i16) {
            case 2541:
                V5((Bundle) unpack.getData());
                return;
            case 1000038:
                U5();
                if (unpack.getSucceed()) {
                    B6();
                    return;
                } else {
                    ToastUtil.s(unpack.getMessage(), 4);
                    return;
                }
            case 1000118:
                U5();
                if (unpack.getSucceed()) {
                    ToastUtil.o(R.string.gjh, 5);
                    return;
                } else if (!TextUtils.isEmpty(unpack.getMessage())) {
                    ToastUtil.r(unpack.getMessage());
                    return;
                } else {
                    ToastUtil.o(R.string.gjg, 4);
                    return;
                }
            case 1000185:
                if (unpack.getSucceed()) {
                    return;
                }
                ToastUtil.s(unpack.getMessage(), 4);
                return;
            case 1000192:
                QZLog.d("[PhotoAlbum]FaceFuntion", 1, "message:", unpack.getMessage(), " ret:", Boolean.valueOf(unpack.getSucceed()));
                D6(unpack);
                if (unpack.getSucceed()) {
                    return;
                }
                ToastUtil.s(unpack.getMessage(), 4);
                return;
            case 1000199:
                d6(unpack);
                return;
            default:
                switch (i16) {
                    case 999905:
                        if (unpack.getSucceed()) {
                            ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastCommentSuccess", "\u8bc4\u8bba\u6210\u529f"), 5);
                            BasePicureViewController basePicureViewController = this.f49483l0;
                            basePicureViewController.u(basePicureViewController.b());
                            C4();
                            j7();
                            return;
                        }
                        ToastUtil.s(unpack.getMessage(), 4);
                        com.qzone.util.o.d(this, unpack.getReturnCode());
                        return;
                    case 999906:
                        if (unpack.getSucceed()) {
                            return;
                        }
                        BasePicureViewController basePicureViewController2 = this.f49483l0;
                        basePicureViewController2.w(basePicureViewController2.b());
                        C4();
                        if (unpack.getMessage() == null || unpack.getMessage().length() <= 0) {
                            return;
                        }
                        ToastUtil.s(unpack.getMessage(), 4);
                        return;
                    default:
                        switch (i16) {
                            case 999908:
                                if (unpack.getSucceed()) {
                                    ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastShareSuccess", "\u5206\u4eab\u6210\u529f"), 5);
                                    return;
                                } else {
                                    ToastUtil.s(unpack.getMessage(), 4);
                                    com.qzone.util.o.d(this, unpack.getReturnCode());
                                    return;
                                }
                            case 999909:
                                U5();
                                if (unpack.getSucceed()) {
                                    B6();
                                    return;
                                } else {
                                    ToastUtil.s(unpack.getMessage(), 4);
                                    return;
                                }
                            default:
                                switch (i16) {
                                    case 1000028:
                                        String str = (String) unpack.getData();
                                        if (QZLog.isDevelopLevel()) {
                                            QZLog.d("[PhotoAlbum]QzonePictureViewer", 4, "add,key=" + str);
                                        }
                                        this.f49483l0.H0(str);
                                        if (unpack.getSucceed()) {
                                            QfavHelper.B(this, LoginData.getInstance().getUinString(), true, null, false);
                                            return;
                                        }
                                        this.f49483l0.a1(str);
                                        if (TextUtils.isEmpty(unpack.getMessage())) {
                                            return;
                                        }
                                        ToastUtil.s(unpack.getMessage(), 4);
                                        return;
                                    case 1000029:
                                        String str2 = (String) unpack.getData();
                                        this.f49483l0.H0(str2);
                                        if (QZLog.isDevelopLevel()) {
                                            QZLog.d("[PhotoAlbum]QzonePictureViewer", 4, "del,key=" + str2);
                                        }
                                        if (unpack.getSucceed()) {
                                            ToastUtil.s(getString(R.string.gfr), 5);
                                            return;
                                        }
                                        this.f49483l0.a1(str2);
                                        if (TextUtils.isEmpty(unpack.getMessage())) {
                                            return;
                                        }
                                        ToastUtil.s(unpack.getMessage(), 4);
                                        return;
                                    case 1000030:
                                        return;
                                    default:
                                        switch (i16) {
                                            case 1000060:
                                                s7();
                                                return;
                                            case 1000061:
                                                BasePicureViewController basePicureViewController3 = this.f49483l0;
                                                if (basePicureViewController3 != null) {
                                                    PhotoInfo b16 = basePicureViewController3.b();
                                                    if (b16 != null) {
                                                        b16.hasLoaded = true;
                                                        b16.hasLocalOrgFile = Boolean.valueOf(ImageLoader.getInstance().getImageFile(b16.orgUrl) != null);
                                                        this.R1 = true;
                                                        if (b16.lloc != null) {
                                                            ae.b().put(b16.lloc, Boolean.TRUE);
                                                        }
                                                    }
                                                    T6();
                                                    QZLog.d("[PhotoAlbum]QzonePictureViewer", 1, "photo original picture download successfully");
                                                }
                                                w7(false);
                                                x7(false);
                                                notifyDataSetChanged();
                                                return;
                                            case 1000062:
                                                ToastUtil.n(R.string.d0c);
                                                w7(true);
                                                x7(false);
                                                return;
                                            case 1000063:
                                                this.f49483l0.b().showGifState = PhotoInfo.SHOW_GIF;
                                                x7(false);
                                                notifyDataSetChanged();
                                                return;
                                            case 1000064:
                                                this.f49483l0.b().showGifState = PhotoInfo.SHOW_STATIC_PHOTO;
                                                x7(false);
                                                return;
                                            case 1000065:
                                                this.f49483l0.b().showGifState = PhotoInfo.SHOW_STATIC_PHOTO;
                                                this.f49483l0.b().hasLoaded = true;
                                                if (this.f49483l0.P() != null && this.f49495x0 < this.f49483l0.P().length) {
                                                    PhotoInfo[] P = this.f49483l0.P();
                                                    int i17 = this.f49495x0;
                                                    PhotoInfo photoInfo = P[i17];
                                                    if (photoInfo != null) {
                                                        photoInfo.showGifState = PhotoInfo.SHOW_STATIC_PHOTO;
                                                        photoInfo.hasLoaded = true;
                                                    }
                                                    this.f49495x0 = i17 + 1;
                                                }
                                                x7(false);
                                                G4();
                                                if (this.I0 != 1 || this.f49495x0 == this.f49483l0.P().length - 1) {
                                                    notifyDataSetChanged();
                                                    return;
                                                }
                                                return;
                                            case 1000066:
                                            case 1000068:
                                            case IChannelType.APP_SUB_CHANNEL_TYPE_CODM /* 1000070 */:
                                                ToastUtil.n(R.string.d0c);
                                                this.f49483l0.b().showGifState = PhotoInfo.SHOW_STATIC_PHOTO;
                                                x7(false);
                                                notifyDataSetChanged();
                                                return;
                                            case 1000067:
                                                this.f49483l0.b().showGifState = PhotoInfo.SHOW_STATIC_PHOTO;
                                                this.f49483l0.b().hasLoaded = true;
                                                if (this.f49495x0 < this.f49483l0.P().length) {
                                                    this.f49495x0++;
                                                }
                                                x7(false);
                                                H3();
                                                if (this.f49495x0 == this.f49483l0.P().length - 1) {
                                                    notifyDataSetChanged();
                                                    return;
                                                }
                                                return;
                                            case 1000069:
                                                this.f49483l0.b().showGifState = PhotoInfo.SHOW_STATIC_PHOTO;
                                                this.f49483l0.b().hasLoaded = true;
                                                if (this.f49495x0 < this.f49483l0.P().length) {
                                                    PhotoInfo[] P2 = this.f49483l0.P();
                                                    int i18 = this.f49495x0;
                                                    PhotoInfo photoInfo2 = P2[i18];
                                                    if (photoInfo2 == null) {
                                                        QLog.e("[PhotoAlbum]QzonePictureViewer", 1, "[onHandleMessage] photoInfo == null, error stack: ", new Exception());
                                                        return;
                                                    } else {
                                                        photoInfo2.showGifState = PhotoInfo.SHOW_STATIC_PHOTO;
                                                        photoInfo2.hasLoaded = true;
                                                        this.f49495x0 = i18 + 1;
                                                    }
                                                }
                                                x7(false);
                                                I3();
                                                if (this.f49495x0 == this.f49483l0.P().length - 1) {
                                                    notifyDataSetChanged();
                                                    return;
                                                }
                                                return;
                                            default:
                                                switch (i16) {
                                                    case 1000083:
                                                        d4(unpack);
                                                        return;
                                                    case 1000084:
                                                        e4(unpack);
                                                        return;
                                                    default:
                                                        I6(unpack);
                                                        return;
                                                }
                                        }
                                }
                        }
                }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.preview.BasePictureViewer, com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f49768c2 = false;
        View view = this.f49774f2;
        if (view != null && !this.f49796q2) {
            view.setVisibility(8);
        }
        com.qzone.misc.network.ttt.a.c().h(this.f49798r2);
        if (this.f49800s2) {
            com.qzone.misc.network.ttt.a.c().f(this.f49798r2);
        }
        GalleryManager galleryManager = this.G0;
        if (galleryManager != null) {
            com.tencent.common.galleryactivity.m k3 = galleryManager.k();
            if (k3 instanceof QzoneGalleryScene) {
                ((QzoneGalleryScene) k3).m();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.preview.BasePictureViewer, com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        PhotoDanmakuManager photoDanmakuManager;
        super.onResume();
        this.f49768c2 = true;
        if (this.f49766b2 != null) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.FeedDeleteOnTimeThread).removeTask(this.f49766b2);
        }
        long j3 = this.f49764a2;
        if (j3 > 0) {
            long currentTimeMillis = j3 - (System.currentTimeMillis() / 1000);
            long j16 = currentTimeMillis > 0 ? currentTimeMillis : 0L;
            if (this.f49766b2 == null) {
                this.f49766b2 = new Runnable() { // from class: com.qzone.preview.QzonePictureViewer.2
                    @Override // java.lang.Runnable
                    public void run() {
                        BasePicureViewController basePicureViewController = QzonePictureViewer.this.f49483l0;
                        if (basePicureViewController == null || TextUtils.isEmpty(basePicureViewController.E())) {
                            return;
                        }
                        if (QzonePictureViewer.this.f49768c2) {
                            Intent intent = new Intent();
                            intent.setAction("com.qzone.hide_feed_actionpanel");
                            intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_CACHE_UNIKEY, QzonePictureViewer.this.f49483l0.E());
                            intent.putExtra("extra_key_need_showtoast", false);
                            QzonePictureViewer.this.sendBroadcast(intent);
                            ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastDeleteMsg", "\u8be5\u5185\u5bb9\u5df2\u88ab\u5220\u9664"), 4);
                        }
                        QzonePictureViewer.this.finish();
                    }
                };
            }
            if (this.f49766b2 != null) {
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.FeedDeleteOnTimeThread).postDelayed(this.f49766b2, j16 * 1000);
            }
        }
        BasePicureViewController basePicureViewController = this.f49483l0;
        if (basePicureViewController != null) {
            basePicureViewController.W0(this.O2);
        }
        View view = this.f49774f2;
        if (view != null && view.getVisibility() == 8 && (photoDanmakuManager = this.f49784k2) != null && photoDanmakuManager.isPlaying()) {
            this.f49774f2.setVisibility(0);
        }
        if (this.f49805v1 != null) {
            this.f49805v1.setImageDrawable(getResources().getDrawable(R.drawable.gbm));
            this.B1 = true;
        }
        com.qzone.misc.network.ttt.a.c().e(this.f49798r2);
        GalleryManager galleryManager = this.G0;
        if (galleryManager != null) {
            com.tencent.common.galleryactivity.m k3 = galleryManager.k();
            if (k3 instanceof QzoneGalleryScene) {
                ((QzoneGalleryScene) k3).n();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.preview.BasePictureViewer, mqq.app.AppActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        View view = this.f49774f2;
        if (view == null || this.f49796q2) {
            return;
        }
        view.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.f49768c2 = false;
    }

    @Override // com.qzone.preview.BasePictureViewer, com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        if (z16) {
            QZLog.d("[PhotoAlbum]AlbumPerformance[PhotoAlbum]QzonePictureViewer", 1, "[PhotoAlbum]QzonePictureViewer onWindowFocusChanged cost:" + (System.currentTimeMillis() - this.f49808w2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.preview.BasePictureViewer
    public void r3() {
        super.r3();
        PhotoParam photoParam = this.f49483l0.f49877g;
        if (photoParam != null && photoParam.ownerUin == 0 && TextUtils.isEmpty(photoParam.albumid)) {
            return;
        }
        if (this.f49810x2) {
            s3(2, 84, R.string.gk5, R.drawable.qzone_detail_panel_unfav, (o4() || BasePicureViewController.i0()) ? false : true);
        } else {
            s3(2, 6, R.string.gk_, R.drawable.qzone_detail_panel_faved, (o4() || BasePicureViewController.i0()) ? false : true);
        }
        J4(6, this.f49483l0.i(BasePictureViewer.X0));
        J4(84, this.f49483l0.i(BasePictureViewer.X0));
        if (!u7() || o4()) {
            return;
        }
        s3(2, 105, R.string.gkc, R.drawable.qzone_detail_panel_pitu, true);
        J4(105, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r6() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(LoginData.getInstance().getUin());
        String str = "";
        sb5.append("");
        String sb6 = sb5.toString();
        BasePicureViewController basePicureViewController = this.f49483l0;
        long L = basePicureViewController == null ? 0L : basePicureViewController.L();
        if (L != 0) {
            str = String.valueOf(L);
        }
        return !TextUtils.isEmpty(str) && TextUtils.equals(sb6, str);
    }

    public boolean u7() {
        if (R6()) {
            if (AppSetting.b("7.3.5") >= 0) {
                return true;
            }
        } else if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PHOTOVIEW_CAN_SHOW_PITU_BUTTON, 0) == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.preview.BasePictureViewer
    public boolean w4() {
        BasePicureViewController basePicureViewController;
        if (!this.f49804u2 && this.f49802t2 && (basePicureViewController = this.f49483l0) != null) {
            basePicureViewController.a(basePicureViewController.getSelectedIndex());
            notifyDataSetChanged();
            return true;
        }
        if (BasePicureViewController.g0() && this.f49483l0 != null) {
            Intent intent = new Intent();
            this.f49483l0.R0(intent);
            setResult(-1, intent);
        }
        return super.w4();
    }

    public void x6() {
        if (R6()) {
            Intent intent = new Intent();
            intent.setData(Uri.parse("ttpic://TTPTBEAUTIFY/?refer=qzone"));
            yo.b.a(intent);
            startActivity(intent);
            return;
        }
        new com.qzone.component.e().f(this, 230, getString(R.string.gke), getString(R.string.gkd), getString(R.string.f170582ur), getString(R.string.cancel), new k(), null);
    }

    @Override // com.qzone.preview.BasePictureViewer, com.qzone.preview.b
    public void y1() {
        super.y1();
        View view = this.f49769d1;
        if (BasePicureViewController.g0()) {
            view = this.f49773f1;
        }
        if (view != null && this.f49771e1 != null) {
            view.setVisibility(this.K2);
            this.f49771e1.setVisibility(8);
        }
        View view2 = this.f49781j1;
        if (view2 != null && this.f49783k1 != null && this.f49777h1 != null) {
            view2.setVisibility(this.L2);
            this.f49783k1.setVisibility(this.L2);
            this.f49777h1.setVisibility(8);
        }
        c7(0);
        getOutActivity().setRequestedOrientation(4);
        this.f49802t2 = false;
    }

    public void y6(long j3) {
        ho.i.z().r(this, j3);
    }

    protected void y7() {
        if (!PictureManager.getInstance().checkNetworkConnect()) {
            ToastUtil.n(R.string.gdc);
            return;
        }
        if (this.M2 == null) {
            this.M2 = com.qzone.widget.util.b.d(this);
        }
        this.M2.show();
    }

    @Override // com.qzone.preview.BasePictureViewer, com.qzone.preview.b
    public boolean z0() {
        CommentListBaseController commentListBaseController = this.E2;
        if (commentListBaseController != null) {
            return commentListBaseController.k0();
        }
        return false;
    }

    public void z7(boolean z16) {
        BasePicureViewController basePicureViewController = this.f49483l0;
        if (basePicureViewController == null || !basePicureViewController.o()) {
            return;
        }
        if (z16 && this.M1 == null) {
            m6();
        }
        if (z16) {
            if (getResources().getConfiguration().orientation != 2) {
                Button button = this.M1;
                if (button != null) {
                    button.setVisibility(0);
                }
                ClickReport.e(4, "", 301, 16, 1);
                return;
            }
            return;
        }
        Button button2 = this.M1;
        if (button2 != null) {
            button2.setVisibility(4);
        }
    }

    private void A6() {
        String str;
        this.f49796q2 = true;
        U4(this, 2, QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "SaySomething", "\u8bf4\u70b9\u4ec0\u4e48\u5427..."), null, this.f49483l0.E());
        if (BasePicureViewController.a0()) {
            str = ProfileCardTemplate.PROFILE_COMMON_VERSION;
        } else {
            str = "582";
        }
        ClickReport.m(str, "2", "");
        ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "3", "", true);
    }

    private void B6() {
        this.f49480i0 = false;
        this.f49483l0.v();
        if (this.f49483l0.getCount() == 0) {
            w4();
        } else {
            notifyDataSetChanged();
        }
    }

    private void N6() {
        this.Q1 = true;
        boolean z16 = true ^ this.f49479h0;
        this.f49479h0 = z16;
        this.f49483l0.Z0(z16);
        D7();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t6() {
        this.f49776g2 = true;
        this.D1.setImageResource(R.drawable.bvy);
        ArrayList<PhotoDanmakuModel> arrayList = this.f49792o2;
        if (arrayList != null && arrayList.size() != 0) {
            U6(this.f49792o2);
        } else {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.qzone.preview.QzonePictureViewer.6
                @Override // java.lang.Runnable
                public void run() {
                    QzonePictureViewer qzonePictureViewer = QzonePictureViewer.this;
                    qzonePictureViewer.f49483l0.O(qzonePictureViewer.getHandler());
                }
            });
        }
    }

    public void S5() {
        QZLog.i("[PhotoAlbum]QzonePictureViewer", 4, "currentVideoPlayComplete");
    }

    public void T5(PhotoInfo photoInfo) {
        QZLog.d("[PhotoAlbum]QzonePictureViewer", 1, "decodeFile...");
        this.T2 = HdAsync.with(this).then(new m(QzoneHandlerThreadFactory.getHandlerThreadLooper(QzoneHandlerThreadFactory.NormalThread), photoInfo)).then(new l(Looper.getMainLooper())).call();
    }

    @Override // com.qzone.preview.BasePictureViewer, com.qzone.preview.b
    public void w1() {
        p7(true);
    }

    @Override // com.qzone.preview.BasePictureViewer
    public void y4(int i3, PhotoInfo photoInfo) {
        E3(i3, photoInfo, true);
    }

    private void C7(boolean z16) {
        if (!z16) {
            this.f49787m1.setImageResource(R.drawable.gbf);
            return;
        }
        BasePicureViewController basePicureViewController = this.f49483l0;
        if (basePicureViewController != null && basePicureViewController.N() > 0) {
            this.f49787m1.setImageResource(R.drawable.gbd);
        } else {
            this.f49787m1.setImageResource(R.drawable.gbe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a7(final PhotoInfo photoInfo, int i3) {
        if (i3 == 0) {
            this.f49775g1.setVisibility(0);
            Z6(photoInfo);
        } else {
            if (this.f49474c0) {
                return;
            }
            this.f49474c0 = true;
            getHandler().postDelayed(new Runnable() { // from class: com.qzone.preview.QzonePictureViewer.24
                @Override // java.lang.Runnable
                public void run() {
                    QzonePictureViewer.this.f49775g1.setVisibility(0);
                    QzonePictureViewer.this.Z6(photoInfo);
                }
            }, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b7(int i3) {
        if (i3 > 0) {
            String b65 = b6(i3);
            this.f49793p1.setText(b65);
            this.f49793p1.setContentDescription(com.qzone.util.l.a(R.string.s3x) + b65);
            this.f49795q1.setImageResource(R.drawable.gb9);
            return;
        }
        this.f49795q1.setImageResource(R.drawable.gb_);
        this.f49793p1.setText("");
    }

    private Pair<Boolean, Boolean> e6(PhotoInfo photoInfo) {
        if (photoInfo == null) {
            Boolean bool = Boolean.FALSE;
            return new Pair<>(bool, bool);
        }
        Boolean bool2 = photoInfo.hasQQCode;
        if (bool2 != null && bool2.booleanValue()) {
            return new Pair<>(Boolean.FALSE, Boolean.TRUE);
        }
        Boolean bool3 = photoInfo.hasQRCode;
        if (bool3 != null && bool3.booleanValue()) {
            return new Pair<>(Boolean.TRUE, Boolean.FALSE);
        }
        T5(photoInfo);
        Boolean bool4 = Boolean.FALSE;
        return new Pair<>(bool4, bool4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t7(ArrayList<PhotoDanmakuModel> arrayList) {
        long j3;
        if (this.f49768c2) {
            V6();
            i6();
            ArrayList arrayList2 = new ArrayList();
            long j16 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (i3 > 0) {
                    if (i3 >= 2) {
                        AbsDanmaku absDanmaku = (AbsDanmaku) arrayList2.get(i3 - 2);
                        float contentWidth = absDanmaku.getContentWidth();
                        j16 = absDanmaku.getTime();
                        j3 = (int) (((8000.0f * contentWidth) / (ViewUtils.getScreenWidth() + contentWidth)) + 800.0f);
                    } else {
                        j3 = 800;
                    }
                    j16 += j3;
                }
                PhotoDanmakuModel photoDanmakuModel = arrayList.get(i3);
                AbsDanmaku createDanmaku = this.f49788m2.createDanmaku(1, j16, photoDanmakuModel.nickName, photoDanmakuModel.content, getResources().getColor(R.color.a8r), 10.0f, getResources().getColor(R.color.a8q));
                QzoneBarrageEffectData.BarrageEffectInfo barrageEffectInfo = photoDanmakuModel.barrageEffectInfo;
                if (barrageEffectInfo != null) {
                    String str = barrageEffectInfo.strAndBgUrl;
                    String str2 = barrageEffectInfo.strTextColor;
                    createDanmaku.setBackgroundImageUrl(str);
                    createDanmaku.setTextColor(Color.parseColor("#" + str2));
                }
                try {
                    String str3 = photoDanmakuModel.fontId;
                    if (str3 != null && !TextUtils.isEmpty(str3)) {
                        createDanmaku.setFontId(Integer.parseInt(photoDanmakuModel.fontId));
                        createDanmaku.setFontType(Integer.parseInt(photoDanmakuModel.fontType));
                        createDanmaku.setFontUrl(photoDanmakuModel.fontUrl);
                    }
                    createDanmaku.setSuperFontInfo(photoDanmakuModel.superFontInfo);
                    createDanmaku.setTextSize(TypedValue.applyDimension(2, 14.0f, getResources().getDisplayMetrics()));
                    createDanmaku.setUserLogoByUin(photoDanmakuModel.userUin);
                    createDanmaku.setLeftImageShape(1);
                    createDanmaku.setBorderRadio(60.0f);
                    this.f49788m2.measureDanmaku(createDanmaku);
                    arrayList2.add(createDanmaku);
                } catch (NumberFormatException unused) {
                    QZLog.e("[PhotoAlbum]QzonePictureViewer", "Integer.parseInt(curDanmakuModel.fontId) - NumberFormatException");
                    return;
                }
            }
            this.f49786l2.addLastAll(arrayList2);
            this.f49784k2.start(this.C2);
            this.f49774f2.setVisibility(0);
            RetentionReport.report(3);
        }
    }

    protected void I6(final QZoneResult qZoneResult) {
        if (qZoneResult != null) {
            getHandler().post(new Runnable() { // from class: com.qzone.preview.QzonePictureViewer.21
                @Override // java.lang.Runnable
                public void run() {
                    BasePicureViewController basePicureViewController = QzonePictureViewer.this.f49483l0;
                    basePicureViewController.C0(qZoneResult, basePicureViewController.getSelectedIndex());
                    BasePicureViewController basePicureViewController2 = QzonePictureViewer.this.f49483l0;
                    basePicureViewController2.c1(basePicureViewController2.b());
                    QzonePictureViewer.this.notifyDataSetChanged();
                }
            });
        }
    }

    public String c6(long j3) {
        long j16 = j3 / 1024;
        DecimalFormat decimalFormat = new DecimalFormat("##0.0");
        if (j16 <= 1024) {
            return j16 + "K";
        }
        float f16 = ((float) j16) / 1024.0f;
        if (f16 > 1024.0f) {
            return decimalFormat.format(f16 / 1024.0f) + "G";
        }
        return decimalFormat.format(f16) + "M";
    }

    public void w7(boolean z16) {
        TextView textView;
        if (z16) {
            PhotoInfo F = this.f49483l0.F();
            if (F != null && F.appAdShow) {
                QLog.i("[PhotoAlbum]QzonePictureViewer", 1, "photoInfo app show is " + F.appAdShow);
                this.G1.setText(F.appAdText);
                r7(true);
                this.H1.setVisibility(8);
                LpReportInfo_pf00064.allReport(301, 33, 1);
            } else if (F != null) {
                long j3 = F.originSize;
                if (j3 > 0 && this.G1 != null && this.F1 != null) {
                    QLog.i("[PhotoAlbum]QzonePictureViewer", 1, "photo info origin size " + c6(j3));
                    this.G1.setText(com.qzone.util.l.a(R.string.f172556s40));
                    r7(true);
                    this.H1.setVisibility(8);
                }
            }
            ImageView imageView = this.f49797r1;
            if (imageView != null) {
                imageView.setVisibility(8);
                return;
            }
            return;
        }
        if (this.F1 == null || (textView = this.G1) == null || textView.getText().equals(com.qzone.util.l.a(R.string.f214675tj)) || this.G1.getText().equals(com.qzone.util.l.a(R.string.s3r))) {
            return;
        }
        r7(false);
    }

    public void x7(boolean z16) {
        TextView textView;
        if (!z16 || (textView = this.G1) == null || this.F1 == null) {
            return;
        }
        textView.setVisibility(0);
        r7(true);
        BasePicureViewController.n0();
    }

    private void d7(CellTextView cellTextView, String str) {
        if (cellTextView == null) {
            return;
        }
        if (TextUtils.isEmpty(this.J2)) {
            int dpToPx = ViewUtils.dpToPx(14.0f);
            this.J2 = "{img:" + URLEncoder.encode("https://ctc.qzonestyle.gtimg.cn/qzone/em/e10034.gif") + ",w:" + dpToPx + ",h:" + dpToPx + "}  ";
        }
        cellTextView.setRichText(this.J2 + str);
    }

    public void Y6(final PhotoInfo photoInfo) {
        if (photoInfo == null) {
            return;
        }
        getHandler().post(new Runnable() { // from class: com.qzone.preview.QzonePictureViewer.26
            @Override // java.lang.Runnable
            public void run() {
                PhotoInfo photoInfo2 = photoInfo;
                if (photoInfo2.photoType == 2 && !TextUtils.isEmpty(photoInfo2.orgUrl)) {
                    QzonePictureViewer.this.f49797r1.setVisibility(8);
                    QzonePictureViewer.this.f49479h0 = false;
                } else {
                    if (QzoneConfig.getInstance().getConfig("EasterEgg", QzoneConfig.SECONDARY_SHOW_DELICACY_PICTURE, 1) == 1) {
                        QzonePictureViewer.this.z7(photoInfo.isWebPic());
                    }
                    QzonePictureViewer.this.f49797r1.setVisibility(8);
                    QzonePictureViewer.this.f49479h0 = false;
                }
            }
        });
    }

    @Override // com.qzone.preview.BasePictureViewer, com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        CommentListBaseController commentListBaseController;
        if (i3 == 4 && (commentListBaseController = this.E2) != null && (commentListBaseController.j0() || this.E2.o0())) {
            return true;
        }
        return super.onKeyDown(i3, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Finally extract failed */
    @Override // com.qzone.preview.BasePictureViewer
    public boolean x4(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        String string;
        final int i3 = actionSheetItem != null ? actionSheetItem.action : 0;
        if (i3 != 3) {
            if (i3 != 6) {
                if (i3 != 11) {
                    if (i3 != 23) {
                        if (i3 != 40) {
                            if (i3 == 52) {
                                F6(this.f49483l0.b());
                                z3();
                                ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "5", WadlProxyConsts.OPER_TYPE_APK_SIGN, true);
                            } else if (i3 == 56) {
                                LpReportInfo_pf00064.allReport(301, 5, 2);
                            } else if (i3 != 84) {
                                if (i3 != 100) {
                                    switch (i3) {
                                        case 105:
                                            x6();
                                            z3();
                                            break;
                                        case 106:
                                            BasePicureViewController basePicureViewController = this.f49483l0;
                                            if (basePicureViewController.f49896z) {
                                                basePicureViewController.f49896z = false;
                                                this.G0.l().K();
                                                this.G0.l().h();
                                                LpReportInfo_pf00064.allReport(301, 25, 2);
                                            } else {
                                                basePicureViewController.f49896z = true;
                                                if (BasePictureViewer.X0 == 2 && basePicureViewController.G().appid == 311) {
                                                    this.f49483l0.Q(this.P2);
                                                }
                                                this.G0.l().K();
                                                this.G0.l().h();
                                                LpReportInfo_pf00064.allReport(301, 25, 1);
                                            }
                                            z3();
                                            break;
                                        case 107:
                                            z3();
                                            vo.c.D(getOutActivity(), this.f49483l0.F().bigUrl);
                                            ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "5", "36", true);
                                            return true;
                                    }
                                } else {
                                    this.f49483l0.J0(this, new h());
                                    z3();
                                    ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "5", "6", true);
                                    return true;
                                }
                            }
                            return super.x4(actionSheetItem);
                        }
                        String string2 = getResources().getString(R.string.gdq);
                        if (o4()) {
                            string2 = getResources().getString(R.string.gdr);
                            string = "";
                        } else if (LoginData.getInstance().isQzoneVip()) {
                            string = getResources().getString(R.string.gf5);
                        } else {
                            string = getResources().getString(R.string.f173008gf4);
                        }
                        DialogUtil.createCustomDialog(this, 230).setTitle(string2).setMessage(string).setPositiveButton(com.qzone.util.l.a(R.string.f172558s42), getResources().getColor(R.color.f157028hz), new g()).setNegativeButton(com.qzone.util.l.a(R.string.j6l), new f()).show();
                        z3();
                        ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "5", "5", true);
                        return true;
                    }
                    Pair<Boolean, Boolean> q65 = q6();
                    if (!((Boolean) q65.first).booleanValue() && !((Boolean) q65.second).booleanValue()) {
                        QZLog.e("[PhotoAlbum]QzonePictureViewer", "[MORE_SAN_QRCODE] this function is closed and not suposed to show!");
                        return true;
                    }
                    QZLog.d("[PhotoAlbum]QzonePictureViewer", 1, "onMoreItemClick... QRCode:", q65.first, " QQCode:", q65.second);
                    QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.preview.QzonePictureViewer.33
                        @Override // java.lang.Runnable
                        public void run() {
                            QzonePictureViewer qzonePictureViewer = QzonePictureViewer.this;
                            qzonePictureViewer.M6(qzonePictureViewer.f49483l0.b(), i3);
                        }
                    });
                    z3();
                    if (BasePicureViewController.n0()) {
                        ClickReport.m(ThemeSwitchUtil.FROM_LOGIN_RESULT, "5", "23");
                    } else {
                        ClickReport.m(ThemeSwitchUtil.FROM_LOGIN_RESULT, "5", "22");
                    }
                    ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "5", "31", true);
                    return true;
                }
                try {
                    if (!NetworkState.isNetSupport()) {
                        ToastUtil.n(R.string.ghi);
                        z3();
                        return true;
                    }
                    this.f49483l0.r0(this);
                    z3();
                    ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "5", "28", true);
                    return true;
                } catch (Throwable th5) {
                    z3();
                    throw th5;
                }
            }
            String U = this.f49483l0.U();
            this.f49483l0.F0(new i(U), U, false);
            return true;
        }
        E6();
        z3();
        return true;
    }

    private void c7(int i3) {
        PhotoDanmakuManager photoDanmakuManager;
        PhotoDanmakuManager photoDanmakuManager2;
        if (i3 == 0 || i3 == 8) {
            ImageView imageView = this.D1;
            if (imageView != null && imageView.getVisibility() != i3) {
                this.D1.setVisibility(i3);
            }
            if (i3 == 8 && this.f49774f2 != null && (photoDanmakuManager2 = this.f49784k2) != null && photoDanmakuManager2.isPlaying()) {
                this.f49784k2.pause();
                this.f49774f2.setVisibility(8);
            } else {
                if (i3 != 0 || this.f49774f2 == null || (photoDanmakuManager = this.f49784k2) == null || photoDanmakuManager.isPlaying()) {
                    return;
                }
                this.f49784k2.resume();
                this.f49774f2.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:25:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x02ef  */
    @Override // com.qzone.preview.BasePictureViewer, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onActivityResult(int i3, int i16, Intent intent) {
        String str;
        String str2;
        int i17;
        String str3;
        QzoneSuperPersonalFontData.SuperFontInfo superFontInfo;
        String str4;
        String str5;
        int i18;
        BusinessAlbumInfo businessAlbumInfo;
        if (intent == null) {
            QLog.e("[PhotoAlbum]QzonePictureViewer", 1, "[onActivityResult] current data should not be null. error: ", new Exception());
            return;
        }
        if (i3 == 2) {
            this.f49796q2 = false;
            if (i16 == -1) {
                String stringExtra = intent.getStringExtra("contentIntentKey");
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_IMAGELIST_CONTENT_INTENT);
                String stringExtra2 = intent.getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_CACHE_UNIKEY);
                boolean booleanExtra = intent.getBooleanExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_PRIVATE_COMMENT, false);
                if (TextUtils.isEmpty(intent.getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_URL))) {
                    str = "";
                    str2 = str;
                    i17 = 0;
                } else {
                    SimpleFontInfo simpleFontInfo = new SimpleFontInfo();
                    str = "";
                    int intExtra = intent.getIntExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_ID, 0);
                    simpleFontInfo.fontId = intExtra;
                    i17 = intExtra;
                    simpleFontInfo.formatType = intent.getIntExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_FORMAT_TYPE, 0);
                    simpleFontInfo.fontUrl = intent.getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_URL);
                    str2 = simpleFontInfo.toString();
                }
                if (TextUtils.isEmpty(intent.getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SUPER_FONT_INFO))) {
                    str3 = str;
                    superFontInfo = null;
                } else {
                    str3 = intent.getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SUPER_FONT_INFO);
                    superFontInfo = QzoneSuperPersonalFontData.SuperFontInfo.fromJson(str3);
                }
                String stringExtra3 = intent.getStringExtra("extra_key_barrage_effect_info");
                if (!this.f49776g2 || TextUtils.isEmpty(stringExtra)) {
                    str4 = "extra_key_barrage_effect_info";
                } else {
                    str4 = "extra_key_barrage_effect_info";
                    this.f49794p2 = new PhotoDanmakuModel(LoginData.getInstance().getNickName(com.qzone.util.l.a(R.string.s3y)), LoginData.getInstance().getUin(), stringExtra, superFontInfo, String.valueOf(i17), String.valueOf(0), "", stringExtra3 != null ? QzoneBarrageEffectData.BarrageEffectInfo.fromJson(stringExtra3) : null);
                }
                this.f49483l0.r(stringExtra, stringArrayListExtra, stringExtra2, booleanExtra, getHandler(), str2, str3, stringExtra3);
                if (this.E2 == null) {
                    intent.putExtra("position", this.f49483l0.getSelectedIndex());
                    if (i3 == 1207 && this.f49776g2) {
                        String stringExtra4 = intent.getStringExtra("contentIntentKey");
                        if (!TextUtils.isEmpty(stringExtra4)) {
                            QzoneSuperPersonalFontData.SuperFontInfo fromJson = !TextUtils.isEmpty(intent.getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SUPER_FONT_INFO)) ? QzoneSuperPersonalFontData.SuperFontInfo.fromJson(intent.getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SUPER_FONT_INFO)) : null;
                            if (TextUtils.isEmpty(intent.getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_URL))) {
                                str5 = str4;
                                i18 = 0;
                            } else {
                                SimpleFontInfo simpleFontInfo2 = new SimpleFontInfo();
                                int intExtra2 = intent.getIntExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_ID, 0);
                                simpleFontInfo2.fontId = intExtra2;
                                simpleFontInfo2.formatType = intent.getIntExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_FORMAT_TYPE, 0);
                                simpleFontInfo2.fontUrl = intent.getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_URL);
                                i18 = intExtra2;
                                str5 = str4;
                            }
                            String stringExtra5 = intent.getStringExtra(str5);
                            this.f49794p2 = new PhotoDanmakuModel(LoginData.getInstance().getNickName(com.qzone.util.l.a(R.string.s3w)), LoginData.getInstance().getUin(), stringExtra4, fromJson, String.valueOf(i18), String.valueOf(0), "", stringExtra5 != null ? QzoneBarrageEffectData.BarrageEffectInfo.fromJson(stringExtra5) : null);
                        }
                    }
                    this.E2.n0(i3, i16, intent);
                }
                super.onActivityResult(i3, i16, intent);
            }
        } else if (i3 != 3) {
            if (i3 != 5) {
                if (i3 != 7) {
                    if (i3 != 9) {
                        if (i3 != 200) {
                            if (i3 == 20230) {
                                String stringExtra6 = intent.getStringExtra("lloc");
                                PhotoInfo b16 = this.f49483l0.b();
                                if (stringExtra6 != null && b16 != null && stringExtra6.equals(b16.lloc)) {
                                    if (intent.getBooleanExtra(PictureConst.PHOTO_DELETED, false)) {
                                        B6();
                                    } else {
                                        boolean booleanExtra2 = intent.getBooleanExtra(PictureConst.PHOTO_MYLIKE, false);
                                        int intExtra3 = intent.getIntExtra(PictureConst.PHOTO_LIKE_NUM, 0);
                                        int intExtra4 = intent.getIntExtra(PictureConst.PHOTO_COMMENT_NUM, 0);
                                        if (!this.f49483l0.B0(b16, booleanExtra2, intExtra3, intExtra4)) {
                                            b16.hasPraise = booleanExtra2;
                                            b16.praiseCount = intExtra3;
                                            b16.commentCount = intExtra4;
                                        }
                                        C4();
                                    }
                                } else if (BasePicureViewController.g0() && b16 != null) {
                                    if (intent.getBooleanExtra(PictureConst.PHOTO_DELETED, false)) {
                                        B6();
                                    } else {
                                        boolean booleanExtra3 = intent.getBooleanExtra(PictureConst.PHOTO_MYLIKE, false);
                                        int intExtra5 = intent.getIntExtra(PictureConst.PHOTO_LIKE_NUM, 0);
                                        int intExtra6 = intent.getIntExtra(PictureConst.PHOTO_COMMENT_NUM, 0);
                                        if (!this.f49483l0.B0(b16, booleanExtra3, intExtra5, intExtra6)) {
                                            b16.hasPraise = booleanExtra3;
                                            b16.praiseCount = intExtra5;
                                            b16.commentCount = intExtra6;
                                        }
                                        C4();
                                    }
                                }
                            } else if (i3 == 37679 && (businessAlbumInfo = (BusinessAlbumInfo) intent.getParcelableExtra(QZoneHelper.QZoneAlbumConstants.KEY_SELECTED_ALBUMINFO)) != null) {
                                n5.d.l().v(businessAlbumInfo);
                            }
                        }
                    } else if (i16 == -1) {
                        LpReportInfo_pf00064.allReport(301, 31, 2);
                    }
                } else if (i16 == -1) {
                    String stringExtra7 = intent.getStringExtra("contentIntentKey");
                    String stringExtra8 = intent.getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_CACHE_UNIKEY);
                    ArrayList<String> arrayList = new ArrayList<>();
                    PhotoInfo b17 = this.f49483l0.b();
                    if (b17 == null) {
                        return;
                    }
                    arrayList.add(b17.lloc);
                    b17.desc = stringExtra7;
                    EditPhoto editPhoto = new EditPhoto();
                    editPhoto.desc = stringExtra7;
                    y7();
                    Z6(b17);
                    this.f49483l0.z(getHandler(), b17.albumId, arrayList, editPhoto, 2, null, stringExtra8);
                }
            } else if (i16 == 293) {
                finish();
                return;
            }
            if (i16 == -1) {
                Intent A = ak.A(this, 0, false, "[PhotoAlbum]QzonePictureViewer", 23, false);
                A.putExtra("mood_web_pic_url", intent.getStringExtra("mood_web_pic_url"));
                A.putExtra("key_need_save_draft", false);
                startActivity(A);
                finish();
                return;
            }
        } else if (i16 == -1) {
            this.f49483l0.C(intent.getStringExtra("contentIntentKey"), intent.getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_CACHE_UNIKEY), getHandler());
        }
        str4 = "extra_key_barrage_effect_info";
        if (this.E2 == null) {
        }
        super.onActivityResult(i3, i16, intent);
    }

    @Override // com.qzone.preview.BasePictureViewer
    protected void B4(AbsListView absListView, int i3) {
        View view;
        if (i3 != 0) {
            if ((i3 == 1 || i3 == 2) && (view = this.f49775g1) != null && view.getVisibility() == 0) {
                this.f49775g1.setVisibility(8);
                return;
            }
            return;
        }
        View view2 = this.f49775g1;
        if (view2 == null || view2.getVisibility() != 8) {
            return;
        }
        this.f49775g1.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            QzonePictureViewer.this.Z0.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class c implements Animation.AnimationListener {
        c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            QzonePictureViewer.this.f49783k1.setVisibility(0);
            QzonePictureViewer.this.f49781j1.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    private void l7() {
    }

    @Override // com.qzone.preview.BasePictureViewer, com.qzone.preview.b
    public void d1(boolean z16) {
    }
}
