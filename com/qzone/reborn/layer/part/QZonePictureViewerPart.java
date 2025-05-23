package com.qzone.reborn.layer.part;

import NS_MOBILE_FEEDS.cell_comment;
import NS_MOBILE_FEEDS.cnst.UNIVERSAL_MALL_QUAL;
import NS_MOBILE_FEEDS.s_commment;
import NS_MOBILE_FEEDS.s_user;
import NS_MOBILE_PHOTO.EditPhoto;
import NS_MOBILE_PHOTO.get_photo_comment_rsp;
import android.app.Activity;
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
import com.qzone.common.business.result.QZoneResult;
import com.qzone.detail.ui.comment.CommentListBaseController;
import com.qzone.detail.ui.comment.CommentListLayout;
import com.qzone.feed.panorama.PanoramaLayout;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.preview.BasePictureViewer;
import com.qzone.preview.QzoneGalleryScene;
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

/* loaded from: classes37.dex */
public class QZonePictureViewerPart extends QZoneBasePictureViewerPart implements View.OnClickListener {
    private View A0;
    private WindowManager.LayoutParams A1;
    private View B0;
    private View B1;
    private View C0;
    private boolean C1;
    private RelativeLayout D0;
    private boolean D1;
    private View E0;
    private int E1;
    private View F0;
    private boolean F1;
    private View G0;
    private PhotoDanmakuManager G1;
    private CellTextView H0;
    private PhotoDanmakuDataSource H1;
    private ImageView I0;
    private PhotoDanmakuFactory I1;
    private TextView J0;
    private TextureView J1;
    private TextView K0;
    private ArrayList<PhotoDanmakuModel> K1;
    private TextView L0;
    private PhotoDanmakuModel L1;
    private ImageView M0;
    private boolean M1;
    private ImageView N0;
    private String N1;
    private View O0;
    private boolean O1;
    private View P0;
    private boolean P1;
    private View Q0;
    private boolean Q1;
    private ImageView R0;
    private int R1;
    private TranslateAnimation S0;
    private long S1;
    private TranslateAnimation T0;
    private boolean T1;
    private TranslateAnimation U0;
    private int U1;
    private TranslateAnimation V0;
    private String V1;
    private String W1;
    private String X1;
    private long Y1;
    private ImageView Z0;
    protected View Z1;

    /* renamed from: a1, reason: collision with root package name */
    private AsyncImageView f57868a1;

    /* renamed from: a2, reason: collision with root package name */
    protected CommentListBaseController f57869a2;

    /* renamed from: b1, reason: collision with root package name */
    private RelativeLayout f57870b1;

    /* renamed from: b2, reason: collision with root package name */
    private Runnable f57871b2;

    /* renamed from: c1, reason: collision with root package name */
    private TextView f57872c1;

    /* renamed from: c2, reason: collision with root package name */
    private Runnable f57873c2;

    /* renamed from: d1, reason: collision with root package name */
    private TextView f57874d1;

    /* renamed from: d2, reason: collision with root package name */
    private boolean f57875d2;

    /* renamed from: e1, reason: collision with root package name */
    private TextView f57876e1;

    /* renamed from: e2, reason: collision with root package name */
    private int f57877e2;

    /* renamed from: f1, reason: collision with root package name */
    private TextView f57878f1;

    /* renamed from: f2, reason: collision with root package name */
    private volatile String f57879f2;

    /* renamed from: g1, reason: collision with root package name */
    private LinearLayout f57880g1;

    /* renamed from: g2, reason: collision with root package name */
    private int f57881g2;

    /* renamed from: h1, reason: collision with root package name */
    private LinearLayout f57882h1;

    /* renamed from: h2, reason: collision with root package name */
    private int f57883h2;

    /* renamed from: i1, reason: collision with root package name */
    private Button f57884i1;

    /* renamed from: i2, reason: collision with root package name */
    b.c f57885i2;

    /* renamed from: j2, reason: collision with root package name */
    private int f57887j2;

    /* renamed from: k2, reason: collision with root package name */
    private BasePicureViewController.f f57889k2;

    /* renamed from: l2, reason: collision with root package name */
    private final Callback f57891l2;

    /* renamed from: m2, reason: collision with root package name */
    Runnable f57893m2;

    /* renamed from: n2, reason: collision with root package name */
    AlphaAnimation f57895n2;

    /* renamed from: o1, reason: collision with root package name */
    private CellTextView f57896o1;

    /* renamed from: o2, reason: collision with root package name */
    AlphaAnimation f57897o2;

    /* renamed from: p1, reason: collision with root package name */
    private ImageView f57898p1;

    /* renamed from: p2, reason: collision with root package name */
    HdAsync f57899p2;

    /* renamed from: q1, reason: collision with root package name */
    private q f57900q1;

    /* renamed from: u1, reason: collision with root package name */
    private AvatarImageView f57904u1;

    /* renamed from: v0, reason: collision with root package name */
    private View f57905v0;

    /* renamed from: v1, reason: collision with root package name */
    private TextView f57906v1;

    /* renamed from: w0, reason: collision with root package name */
    private TextView f57907w0;

    /* renamed from: w1, reason: collision with root package name */
    private long f57908w1;

    /* renamed from: x0, reason: collision with root package name */
    private TextView f57909x0;

    /* renamed from: y0, reason: collision with root package name */
    private TextView f57911y0;

    /* renamed from: z0, reason: collision with root package name */
    private View f57913z0;

    /* renamed from: z1, reason: collision with root package name */
    private WindowManager f57914z1;
    private int W0 = 300;
    private boolean X0 = true;
    private int Y0 = -1;

    /* renamed from: j1, reason: collision with root package name */
    private boolean f57886j1 = false;

    /* renamed from: k1, reason: collision with root package name */
    private int f57888k1 = 0;

    /* renamed from: l1, reason: collision with root package name */
    private boolean f57890l1 = false;

    /* renamed from: m1, reason: collision with root package name */
    private boolean f57892m1 = false;

    /* renamed from: n1, reason: collision with root package name */
    private boolean f57894n1 = false;

    /* renamed from: r1, reason: collision with root package name */
    private String f57901r1 = null;

    /* renamed from: s1, reason: collision with root package name */
    private String f57902s1 = null;

    /* renamed from: t1, reason: collision with root package name */
    private String f57903t1 = null;

    /* renamed from: x1, reason: collision with root package name */
    private Runnable f57910x1 = null;

    /* renamed from: y1, reason: collision with root package name */
    private boolean f57912y1 = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ClickReport.e(4, "", 301, 16, 2);
            yo.d.l(QZonePictureViewerPart.this.getActivity(), QzoneConfig.getInstance().getConfig("H5Url", "EasterEgg", "https://h5.qzone.qq.com/mood/photoselector?_wv=2097155&_proxy=1&qua={qua}"), 200, null);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class d implements ImageLoader.ImageLoadListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f57947d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ PhotoInfo f57948e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f57949f;

        d(boolean z16, PhotoInfo photoInfo, int i3) {
            this.f57947d = z16;
            this.f57948e = photoInfo;
            this.f57949f = i3;
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
            Message obtain = Message.obtain();
            obtain.obj = new QZoneResult(QZonePictureViewerPart.this.tc(this.f57949f));
            QZonePictureViewerPart.this.getHandler().sendMessage(obtain);
            QZLog.d("[PhotoAlbum]QzonePictureViewer", 1, "onImageCancel url", str);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
            Message obtain = Message.obtain();
            obtain.obj = new QZoneResult(QZonePictureViewerPart.this.tc(this.f57949f));
            QZonePictureViewerPart.this.getHandler().sendMessage(obtain);
            QZLog.d("[PhotoAlbum]QzonePictureViewer", 1, "onImageFailed url", str);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            this.f57948e.setImageDrawable(drawable);
            Message obtain = Message.obtain();
            obtain.obj = new QZoneResult(QZonePictureViewerPart.this.uc(this.f57949f));
            QZonePictureViewerPart.this.getHandler().sendMessage(obtain);
            QZLog.d("[PhotoAlbum]QzonePictureViewer", 1, "onImageLoaded url", str);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
            if (this.f57947d) {
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
                QZonePictureViewerPart.this.getHandler().sendMessage(obtain);
            }
        }
    }

    /* loaded from: classes37.dex */
    class e implements BasePicureViewController.f {
        e() {
        }

        @Override // com.qzone.preview.business.BasePicureViewController.f
        public void a(int i3) {
            QZonePictureViewerPart.this.f57894n1 = false;
            QZonePictureViewerPart.this.oc();
            QZonePictureViewerPart.this.getHandler().removeCallbacks(QZonePictureViewerPart.this.f57871b2);
            QZonePictureViewerPart.this.getHandler().removeCallbacks(QZonePictureViewerPart.this.f57873c2);
            QZLog.i("[PhotoAlbum]QzonePictureViewer", 4, "QzonePictureViewer load getMore count = " + QZonePictureViewerPart.this.T);
            if (QZonePictureViewerPart.this.f57875d2) {
                QZonePictureViewerPart qZonePictureViewerPart = QZonePictureViewerPart.this;
                if (qZonePictureViewerPart.T != 0) {
                    int i16 = qZonePictureViewerPart.U + (i3 - qZonePictureViewerPart.f57877e2);
                    int i17 = i16 + 1;
                    QZonePictureViewerPart qZonePictureViewerPart2 = QZonePictureViewerPart.this;
                    if (i17 <= qZonePictureViewerPart2.T) {
                        if (i16 < qZonePictureViewerPart2.f57887j2) {
                            PictureManager.getInstance().getSender().getMorePhotoDataList(1, QZonePictureViewerPart.this.getHandler());
                            QZonePictureViewerPart.this.f57887j2 -= QZoneBasePictureViewerPart.f57772t0;
                            return;
                        }
                        return;
                    }
                    PictureManager.getInstance().getSender().getMorePhotoDataList(2, QZonePictureViewerPart.this.getHandler());
                    QZonePictureViewerPart.this.T += QZoneBasePictureViewerPart.f57772t0;
                }
            }
        }
    }

    /* loaded from: classes37.dex */
    class f implements DialogInterface.OnClickListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* loaded from: classes37.dex */
    class g implements DialogInterface.OnClickListener {
        g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            QZonePictureViewerPart.this.Wc();
        }
    }

    /* loaded from: classes37.dex */
    class h implements d.g {
        h() {
        }

        @Override // n5.d.g
        public void a(BusinessAlbumInfo businessAlbumInfo) {
            Intent x16 = com.qzone.common.activities.base.ak.x(QZonePictureViewerPart.this.getActivity(), QZonePictureViewerPart.this.getContext().getResources().getString(R.string.gng), 0);
            if (businessAlbumInfo != null) {
                x16.putExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_DEFAULT_ALBUM_ID, businessAlbumInfo.mAlbumId);
            }
            QZonePictureViewerPart.this.getActivity().startActivityForResult(x16, QZoneContant.QZ_SELECT_ALBUM);
        }
    }

    /* loaded from: classes37.dex */
    class i implements QzoneFavoriteService.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f57955a;

        i(String str) {
            this.f57955a = str;
        }

        @Override // com.qzone.business.favorite.service.QzoneFavoriteService.d
        public void a(String str, boolean z16) {
            if (!NetworkState.isNetSupport()) {
                if (!z16) {
                    ToastUtil.n(R.string.ger);
                } else {
                    ToastUtil.o(R.string.gex, 4);
                }
                QZonePictureViewerPart.this.ga();
                return;
            }
            if (!QZonePictureViewerPart.this.H.d0(this.f57955a)) {
                ToastUtil.o(R.string.gfq, 4);
                QZonePictureViewerPart.this.ga();
                return;
            }
            QZonePictureViewerPart qZonePictureViewerPart = QZonePictureViewerPart.this;
            qZonePictureViewerPart.H.N0(!z16, qZonePictureViewerPart.getHandler());
            QZonePictureViewerPart.this.H.F0(null, this.f57955a, true);
            QZonePictureViewerPart.this.T1 = !z16;
            QZonePictureViewerPart.this.ga();
            ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "5", "3", true);
        }
    }

    /* loaded from: classes37.dex */
    class j implements Callback {
        j() {
        }

        @Override // cooperation.qzone.remote.Callback
        public void onResult(Object obj) {
            QZonePictureViewerPart.this.bd((QZoneResult) obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
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
                QZonePictureViewerPart.this.getContext().startActivity(intent);
            } catch (Exception unused) {
                ToastUtil.n(R.string.d0_);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
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
            PhotoInfo b16 = QZonePictureViewerPart.this.H.b();
            if (!TextUtils.isEmpty(b16.bigUrl)) {
                QZLog.d("[PhotoAlbum]QzonePictureViewer", 1, "decodeFile result call... currentPhotoInfo.bigUrl:", b16.bigUrl);
                file2 = imageLoader.getImageFile(b16.bigUrl);
            }
            if (file2 == null) {
                QZLog.w("[PhotoAlbum]QzonePictureViewer", 1, "decodeFile result call... currentFile == null");
                return doNext(false);
            }
            if (file.getAbsolutePath().equals(file2.getAbsolutePath())) {
                QZLog.d("[PhotoAlbum]QzonePictureViewer", 1, "decodeFile result call... photoInfo.hasQQCode:", photoInfo.hasQQCode, " !isVideoViewer():", Boolean.valueOf(!QZonePictureViewerPart.this.Ta()));
                if (photoInfo.hasQQCode.booleanValue()) {
                    QZonePictureViewerPart.this.nb(23);
                    LpReportInfo_pf00064.allReport(301, 5, 1);
                    QZonePictureViewerPart.this.Z9(2, 56, R.string.bg9, R.drawable.cn_, photoInfo.hasQQCode.booleanValue() && !QZonePictureViewerPart.this.Ta());
                } else {
                    QZonePictureViewerPart.this.Z9(2, 23, R.string.gkj, R.drawable.g9q, photoInfo.hasQRCode.booleanValue() && !QZonePictureViewerPart.this.Ta());
                }
                com.qzone.detail.ui.component.g gVar = QZonePictureViewerPart.this.f57784h;
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
    /* loaded from: classes37.dex */
    public class m extends HdAsyncAction {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PhotoInfo f57960a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(Looper looper, PhotoInfo photoInfo) {
            super(looper);
            this.f57960a = photoInfo;
        }

        @Override // com.tencent.component.hdasync.HdAsyncAction, com.tencent.component.hdasync.BaseAction
        public HdAsyncResult call(Object obj) {
            Boolean bool;
            PhotoInfo photoInfo = this.f57960a;
            if (photoInfo != null && ((bool = photoInfo.hasQRCode) == null || !bool.booleanValue())) {
                ScannerResult scannerResult = null;
                File imageFile = !TextUtils.isEmpty(this.f57960a.bigUrl) ? ImageLoader.getInstance().getImageFile(this.f57960a.bigUrl) : null;
                if (imageFile == null) {
                    QZLog.w("[PhotoAlbum]QzonePictureViewer", 1, "decodeFile call... file == null");
                    return doNext(false);
                }
                if (!com.tencent.qzone.avif.a.b(this.f57960a.bigUrl) && !com.tencent.qzone.avif.a.a(imageFile)) {
                    boolean isSharpP = SharpPUtils.isSharpP(imageFile);
                    Uri parse = Uri.parse("file://" + imageFile.getAbsolutePath());
                    QZLog.d("[PhotoAlbum]QzonePictureViewer", 1, "decodeFile call... isSharpP:", Boolean.valueOf(isSharpP), " getAbsolutePath:", imageFile.getAbsolutePath());
                    scannerResult = ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).decodeQQCodeFromFile(parse, QZonePictureViewerPart.this.getActivity(), 3, isSharpP);
                } else if (QZoneConfigHelper.j()) {
                    scannerResult = QZonePictureViewerPart.this.nd(imageFile, this.f57960a.bigUrl);
                } else {
                    QZLog.d("[PhotoAlbum]QzonePictureViewer", 1, "avif scan qr code is disable");
                }
                if (scannerResult == null) {
                    return doNext(false);
                }
                this.f57960a.hasQRCode = Boolean.valueOf(scannerResult.l());
                this.f57960a.hasQQCode = Boolean.valueOf(scannerResult.j());
                return doNext(true, this.f57960a);
            }
            return doNext(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class n implements View.OnClickListener {
        n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!QZonePictureViewerPart.this.C1) {
                QZonePictureViewerPart.this.Oc();
                LocalMultiProcConfig.putBool(LocalMultiProcConfig.Constants.KEY_PHOTO_COMMENT_DANMAKU_SWITCH + LoginData.getInstance().getUinString(), true);
                LpReportInfo_pf00064.allReport(301, 30, 2, true);
            } else {
                QZonePictureViewerPart.this.Z0.setImageResource(R.drawable.bvx);
                QZonePictureViewerPart.this.C1 = false;
                QZonePictureViewerPart.this.ld();
                LocalMultiProcConfig.putBool(LocalMultiProcConfig.Constants.KEY_PHOTO_COMMENT_DANMAKU_SWITCH + LoginData.getInstance().getUinString(), false);
                LpReportInfo_pf00064.allReport(301, 30, 3, true);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class o implements CommentListBaseController.n {
        o() {
        }

        @Override // com.qzone.detail.ui.comment.CommentListBaseController.n
        public void a() {
            QZonePictureViewerPart.this.M1 = true;
        }

        @Override // com.qzone.detail.ui.comment.CommentListBaseController.n
        public void b() {
            QZonePictureViewerPart.this.M1 = false;
        }

        @Override // com.qzone.detail.ui.comment.CommentListBaseController.n
        public void c() {
            QZonePictureViewerPart.this.zd();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class p implements CommentListBaseController.o {
        p() {
        }

        @Override // com.qzone.detail.ui.comment.CommentListBaseController.o
        public void a() {
            QZonePictureViewerPart qZonePictureViewerPart = QZonePictureViewerPart.this;
            qZonePictureViewerPart.rd(qZonePictureViewerPart.f57869a2.L());
            QZonePictureViewerPart.this.H.F().commentCount = QZonePictureViewerPart.this.f57869a2.L();
            if (QZonePictureViewerPart.this.H.G().appid != 4) {
                QZonePictureViewerPart.this.H.G().commentNum = QZonePictureViewerPart.this.f57869a2.L();
            }
            QZonePictureViewerPart.this.o5();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes37.dex */
    public static class q {

        /* renamed from: a, reason: collision with root package name */
        private View f57965a;

        /* renamed from: b, reason: collision with root package name */
        private Handler f57966b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes37.dex */
        public class a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f57967d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f57968e;

            a(String str, String str2) {
                this.f57967d = str;
                this.f57968e = str2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (!TextUtils.isEmpty(this.f57967d)) {
                    yo.d.d(this.f57967d, q.this.f57965a.getContext(), null);
                    PictureManager.getInstance().getSender().sendReportExposeOrClick(this.f57968e, String.valueOf(LoginData.getInstance().getUin()), false, q.this.f57966b);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        q(Context context, Handler handler) {
            this.f57965a = LayoutInflater.from(context).inflate(R.layout.bqh, (ViewGroup) null);
            this.f57966b = handler;
        }

        View c() {
            return this.f57965a;
        }

        void d(String str, String str2, String str3, boolean z16) {
            QZLog.i("[PhotoAlbum]QzonePictureViewer", "showOrHideNamingAdv logo:" + str2 + " traceInfo:" + str + " url:" + str3 + " isPhotoItem:" + z16);
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            LinearLayout linearLayout = (LinearLayout) this.f57965a.findViewById(R.id.h9p);
            if (z16) {
                linearLayout.setVisibility(0);
                PictureManager.getInstance().getSender().sendReportExposeOrClick(str, String.valueOf(LoginData.getInstance().getUin()), true, this.f57966b);
                linearLayout.setOnClickListener(new a(str3, str));
                int screenWidth = ViewUtils.getScreenWidth();
                int i3 = (int) (((screenWidth * 1.0d) / 750.0d) * 98.0d);
                ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
                layoutParams.height = i3;
                linearLayout.setLayoutParams(layoutParams);
                AsyncImageView asyncImageView = (AsyncImageView) this.f57965a.findViewById(R.id.h9q);
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

    public QZonePictureViewerPart() {
        this.C1 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PICTURE_VIEWER_DANMAKU_DEFAULT_SWITCH, 0) == 1;
        this.D1 = true;
        this.E1 = -1;
        this.F1 = false;
        this.M1 = false;
        this.P1 = false;
        this.Q1 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_GALLERY_RECOM_ALBUM_BACK_PRESS_FINISH, 0) > 0;
        this.S1 = 0L;
        this.U1 = -1;
        this.V1 = null;
        this.W1 = null;
        this.X1 = null;
        this.Y1 = 0L;
        this.f57871b2 = new Runnable() { // from class: com.qzone.reborn.layer.part.QZonePictureViewerPart.11
            @Override // java.lang.Runnable
            public void run() {
                if (QZonePictureViewerPart.this.f57872c1 != null) {
                    QZonePictureViewerPart.this.f57872c1.setText(R.string.s3r);
                }
            }
        };
        this.f57873c2 = new Runnable() { // from class: com.qzone.reborn.layer.part.QZonePictureViewerPart.12
            @Override // java.lang.Runnable
            public void run() {
                QZonePictureViewerPart.this.Hd(false);
            }
        };
        this.f57875d2 = false;
        this.f57877e2 = -1;
        this.f57881g2 = 4;
        this.f57883h2 = 4;
        this.f57885i2 = null;
        this.f57887j2 = 0;
        this.f57889k2 = new e();
        this.f57891l2 = new j();
        this.f57893m2 = new Runnable() { // from class: com.qzone.reborn.layer.part.QZonePictureViewerPart.37
            @Override // java.lang.Runnable
            public void run() {
                if (QZonePictureViewerPart.this.f57907w0 == null) {
                    return;
                }
                QZonePictureViewerPart.this.f57907w0.startAnimation(QZonePictureViewerPart.this.f57897o2);
            }
        };
        this.f57895n2 = new AlphaAnimation(0.0f, 1.0f);
        this.f57897o2 = new AlphaAnimation(1.0f, 0.0f);
        this.f57899p2 = null;
    }

    private void Ac() {
        boolean Pc = Pc();
        this.D1 = Pc;
        if (Pc && BasePicureViewController.f0()) {
            PhotoParam photoParam = this.H.f49877g;
            if (photoParam.qzoneUserType != 0 || photoParam.appid == 202 || photoParam.isSharedFeeds || !PhotoDanmakuUtil.getInstance().isEnablePhotoDanmakuFunc()) {
                return;
            }
            Ad();
        }
    }

    private void Ad() {
        ImageView imageView = new ImageView(getContext());
        this.Z0 = imageView;
        imageView.setImageResource(R.drawable.bvx);
        this.Z0.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.Z0.setAdjustViewBounds(true);
        this.Z0.setMaxWidth(ViewUtils.dpToPx(24.0f));
        this.Z0.setMaxHeight(ViewUtils.dpToPx(24.0f));
        this.Z0.setId(R.id.fsz);
        U9(this.Z0);
        boolean bool = LocalMultiProcConfig.getBool(LocalMultiProcConfig.Constants.KEY_PHOTO_COMMENT_DANMAKU_SWITCH + LoginData.getInstance().getUinString(), this.C1);
        this.C1 = bool;
        if (bool) {
            Oc();
        } else {
            this.Z0.setImageResource(R.drawable.bvx);
        }
        this.Z0.setOnClickListener(new n());
        if (!u5.b.D("key_first_time_enter_picture_viewer", true) || this.C1 || this.H.f49877g.commentNum <= 0) {
            return;
        }
        u5.b.o0("key_first_time_enter_picture_viewer", false);
        this.Z0.post(new Runnable() { // from class: com.qzone.reborn.layer.part.QZonePictureViewerPart.5
            @Override // java.lang.Runnable
            public void run() {
                QzoneGuideBubbleHelper.g().n(QZonePictureViewerPart.this.getHostActivity(), QZonePictureViewerPart.this.Z0, QZonePictureViewerPart.this.getContext().getString(R.string.gjw), 1, 16.0f, 5.0d, 10.0d, 5000L, -16669697, false, true, 0, null, 0, true, 1.0f, null);
            }
        });
    }

    private void Bc() {
        WindowManager windowManager;
        this.f57914z1 = (WindowManager) getContext().getSystemService("window");
        View inflate = this.f57777d.inflate(R.layout.bqi, (ViewGroup) null);
        this.B1 = inflate;
        this.J1 = (TextureView) inflate.findViewById(R.id.j8n);
        this.G1 = new PhotoDanmakuManager(getContext(), this.J1, 1);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.A1 = layoutParams;
        layoutParams.gravity = 48;
        layoutParams.type = 2;
        layoutParams.format = 1;
        layoutParams.flags = 1080;
        layoutParams.width = -1;
        layoutParams.height = -1;
        if (!getHostActivity().isFinishing() && (windowManager = this.f57914z1) != null) {
            windowManager.addView(this.B1, this.A1);
        }
        this.H1 = this.G1.getDanmakuDataSource();
        this.I1 = this.G1.getDanmakuFactory();
        this.F1 = true;
    }

    private void Cc(boolean z16) {
        if (this.G0 != null) {
            if (z16) {
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, this.G0.getHeight());
                this.V0 = translateAnimation;
                translateAnimation.setDuration(this.W0);
                this.V0.setAnimationListener(new Animation.AnimationListener() { // from class: com.qzone.reborn.layer.part.QZonePictureViewerPart.15
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        QZonePictureViewerPart.this.getHandler().post(new Runnable() { // from class: com.qzone.reborn.layer.part.QZonePictureViewerPart.15.1
                            @Override // java.lang.Runnable
                            public void run() {
                                QZonePictureViewerPart.this.G0.setVisibility(4);
                                QZonePictureViewerPart.this.F0.setVisibility(4);
                            }
                        });
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        QZonePictureViewerPart.this.G0.setVisibility(4);
                        QZonePictureViewerPart.this.F0.setVisibility(4);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                return;
            }
            TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, this.G0.getHeight(), 0.0f);
            this.U0 = translateAnimation2;
            translateAnimation2.setDuration(this.W0);
            this.U0.setAnimationListener(new c());
        }
    }

    private void Cd() {
        PhotoInfo b16 = this.H.b();
        Intent intent = new Intent(getActivity(), (Class<?>) FeedActionPanelActivity.class);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.FEED_TEXT_AUTOFILL_INTENT_KEY, b16.desc);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.NEEDTRANSEMOJ, 1);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_CACHE_UNIKEY, LoginData.getInstance().getUin() + "_" + b16.albumId + "_" + b16.lloc);
        intent.putExtra("inputmax", 200);
        intent.putExtra("showaticon", 0);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_IS_SYSTEM_TRANSPARENTBAR, 0);
        intent.putExtra("canVertical", true);
        com.qzone.feed.utils.b.f(getActivity(), intent, 7);
        ClickReport.m("368", "7", "");
    }

    private void Dc(boolean z16) {
        if (this.f57905v0 != null) {
            if (z16) {
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, -this.f57905v0.getHeight(), 0.0f);
                this.T0 = translateAnimation;
                translateAnimation.setDuration(this.W0);
                this.T0.setAnimationListener(new b());
                return;
            }
            TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, 0.0f, -this.f57905v0.getHeight());
            this.S0 = translateAnimation2;
            translateAnimation2.setDuration(this.W0);
            this.S0.setAnimationListener(new Animation.AnimationListener() { // from class: com.qzone.reborn.layer.part.QZonePictureViewerPart.14
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    QZonePictureViewerPart.this.getHandler().post(new Runnable() { // from class: com.qzone.reborn.layer.part.QZonePictureViewerPart.14.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QZonePictureViewerPart.this.f57905v0.setVisibility(4);
                        }
                    });
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    QZonePictureViewerPart.this.f57905v0.setVisibility(4);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    private boolean Dd() {
        BasePicureViewController basePicureViewController = this.H;
        return (basePicureViewController == null || basePicureViewController.A != 1 || basePicureViewController.b() == null || this.H.b().mFaceList == null || this.H.b().mFaceList.size() <= 0 || this.H.b().videoflag == 1 || this.H.b().isPanorama()) ? false : true;
    }

    private void Ec() {
        try {
            this.f57905v0 = this.f57777d.inflate(R.layout.bqk, (ViewGroup) null);
            Bd();
            RelativeLayout relativeLayout = (RelativeLayout) this.f57905v0.findViewById(R.id.ftv);
            int notchHeight = SystemUtil.getNotchHeight(getContext(), getActivity());
            relativeLayout.getLayoutParams().height = relativeLayout.getLayoutParams().height + notchHeight + ViewUtils.dip2px(10.0f);
            relativeLayout.setPadding(relativeLayout.getPaddingLeft(), relativeLayout.getPaddingTop() + notchHeight, relativeLayout.getPaddingRight(), relativeLayout.getPaddingBottom());
            AsyncImageView asyncImageView = (AsyncImageView) this.f57905v0.findViewById(R.id.fu7);
            this.f57868a1 = asyncImageView;
            asyncImageView.setOnClickListener(this);
            if (BasePicureViewController.n0()) {
                this.f57913z0 = relativeLayout;
                TextView textView = (TextView) this.f57905v0.findViewById(R.id.ftt);
                textView.setOnClickListener(this);
                textView.setVisibility(0);
                this.f57905v0.findViewById(R.id.kxq).setVisibility(8);
                this.f57905v0.findViewById(R.id.f166524fu4).setVisibility(0);
                this.f57907w0 = (TextView) this.f57905v0.findViewById(R.id.kxr);
                this.f57909x0 = (TextView) this.f57905v0.findViewById(R.id.kxv);
                this.f57911y0 = (TextView) this.f57905v0.findViewById(R.id.kxw);
            } else if (BasePicureViewController.g0()) {
                View findViewById = this.f57905v0.findViewById(R.id.ftp);
                this.B0 = findViewById;
                findViewById.setVisibility(0);
                this.f57904u1 = (AvatarImageView) this.B0.findViewById(R.id.ftn);
                this.f57906v1 = (TextView) this.B0.findViewById(R.id.ftq);
                ((Button) this.B0.findViewById(R.id.fto)).setOnClickListener(this);
                this.f57904u1.setOnClickListener(this);
                TextView textView2 = (TextView) this.f57905v0.findViewById(R.id.kxq);
                this.f57907w0 = textView2;
                textView2.setVisibility(8);
                this.f57907w0 = null;
                relativeLayout.setBackgroundColor(0);
            } else {
                this.f57913z0 = relativeLayout;
                this.f57907w0 = (TextView) this.f57905v0.findViewById(R.id.kxq);
                this.f57895n2.setDuration(300L);
                this.f57897o2.setDuration(300L);
                this.f57895n2.setFillAfter(true);
                this.f57897o2.setFillAfter(true);
            }
            this.A0 = this.f57905v0.findViewById(R.id.ftc);
            ((TextView) this.f57905v0.findViewById(R.id.ftu)).setOnClickListener(this);
            this.R0 = (ImageView) this.f57905v0.findViewById(R.id.fu5);
            W9(this.f57905v0);
        } catch (Throwable th5) {
            QZLog.w(th5);
        }
    }

    private void Ed(boolean z16) {
        if (this.H.e0() || this.H.j0()) {
            return;
        }
        PhotoInfo b16 = this.H.b();
        super.w1();
        boolean z17 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PHOTOVIEW_CAN_SHOW_DELETE_BUTTON, 1) == 1;
        boolean Fd = Fd();
        boolean z18 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PHOTOVIEW_CAN_SHOW_FACE_BUTTON, 1) == 1;
        if (!Ic(106)) {
            Z9(2, 106, R.string.gk9, R.drawable.qzone_more_menu_photo_face, z18 && Dd());
        }
        if (!Ic(40)) {
            Z9(2, 40, R.string.gk8, R.drawable.qzone_more_menu_delete, (BasePicureViewController.a0() || BasePicureViewController.b0() || BasePicureViewController.f0()) && (this.H.q0() || this.H.k0() || this.H.p0()) && BasePicureViewController.e(this.H.b()) && z17);
        }
        Pair<Boolean, Boolean> Kc = Kc();
        if (Kc != null) {
            QZLog.d("[PhotoAlbum]QzonePictureViewer", 1, "showMoreActionMenu... qrCode.first:", Kc.first, " qrCode.second:", Kc.second);
            if (!Ic(56)) {
                Z9(2, 56, R.string.bg9, R.drawable.cn_, ((Boolean) Kc.second).booleanValue());
            }
            if (((Boolean) Kc.second).booleanValue()) {
                LpReportInfo_pf00064.allReport(301, 5, 1);
            }
            if (!Ic(23)) {
                Z9(2, 23, R.string.gkj, R.drawable.g9q, ((Boolean) Kc.first).booleanValue());
            }
        }
        if (this.H.h0() && this.f57780e0 == 0 && !Ic(100)) {
            Z9(1, 100, R.string.f173011gg4, R.drawable.qzone_icon_action_sheet_forward, (Ta() || BasePicureViewController.i0()) ? false : true);
            mb(100, this.H.f());
        }
        if (!BasePicureViewController.o0() && this.f57780e0 != 1 && !this.H.f49894x && !Ic(107)) {
            Z9(2, 107, R.string.gkl, R.drawable.qzone_more_menu_cover, !Ta());
        }
        if (this.f57780e0 != 1 && !Ic(52)) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null && !TextUtils.isEmpty(LoginData.getInstance().getUinString())) {
                String uinString = LoginData.getInstance().getUinString();
                if (!TextUtils.isEmpty(uinString)) {
                    Z9(2, 52, R.string.gkb, R.drawable.qzone_icon_action_sheet_ocr, Fd && !((!((IOCRService) peekAppRuntime.getRuntimeService(IOCRService.class, "")).isQZoneSupportOcr(uinString) && !BasePicureViewController.o0()) || Ta() || Ma()));
                }
            } else {
                QLog.w("[PhotoAlbum]QzonePictureViewer", 1, "uin is null, cannot get IOCRService");
                return;
            }
        }
        if (!Ic(11)) {
            Z9(2, 11, R.string.gka, R.drawable.qzone_detail_panel_report, this.H.k());
        }
        if ((Ta() || BasePicureViewController.i0() || BasePicureViewController.o0() || this.f57908w1 != 0) && !this.H.g()) {
            nb(6);
            nb(84);
        }
        if (BasePicureViewController.o0()) {
            nb(9);
        }
        mb(2, aa(false));
        mb(203, BasePicureViewController.o0() && aa(false));
        mb(9, aa(true) && Ha());
        mb(6, (b16.photoOpmask & 16) == 0);
        ja();
        if (z16) {
            ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "6", "", true);
        }
        if (this.f57784h != null) {
            if (this.f57900q1 == null) {
                this.f57900q1 = new q(getContext(), getHandler());
            }
            this.f57784h.setAdvView(this.f57900q1.c(), new RelativeLayout.LayoutParams(-1, -2));
            this.f57900q1.d(this.f57901r1, this.f57902s1, this.f57903t1, !Ta());
        }
    }

    private boolean Fd() {
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

    private void Gc(PhotoInfo photoInfo) {
        if (this.f57880g1 == null || this.f57882h1 == null || photoInfo == null || photoInfo.videodata == null) {
            return;
        }
        if (com.qzone.util.ae.b() != null && com.qzone.util.ae.b().snapshot() != null) {
            QLog.i("[PhotoAlbum]QzonePictureViewer", 1, "original map is " + com.qzone.util.ae.b().snapshot().size());
        }
        if (photoInfo.videodata.actionUrl.equals("")) {
            if (com.qzone.util.ae.b().snapshot().containsKey(photoInfo.lloc) && !this.f57894n1) {
                QLog.i("[PhotoAlbum]QzonePictureViewer", 1, "photo info id " + photoInfo.lloc + " map contains id");
                this.f57880g1.setVisibility(0);
            } else {
                QLog.i("[PhotoAlbum]QzonePictureViewer", 1, "photo info id " + photoInfo.lloc + " map not contains id");
                this.f57880g1.setVisibility(8);
            }
            this.f57882h1.setVisibility(8);
            return;
        }
        VideoPlayInfo a16 = com.qzone.util.ae.a(photoInfo.videodata);
        if (a16.videoId != null && BaseVideoManagerUtils.getOriginalVideoMap().containsKey(a16.videoId)) {
            QLog.i("[PhotoAlbum]QzonePictureViewer", 1, "video info id " + photoInfo.lloc + " map contains id");
            this.f57882h1.setVisibility(0);
        } else {
            QLog.i("[PhotoAlbum]QzonePictureViewer", 1, "video info id " + photoInfo.lloc + " map not contains id");
            this.f57882h1.setVisibility(8);
        }
        this.f57880g1.setVisibility(8);
    }

    private void Hc() {
        Button button = new Button(getContext());
        this.f57884i1 = button;
        button.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.gbi));
        this.f57884i1.setText(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewFoundMorePicture", "\u53d1\u73b0\u66f4\u591a\u7cbe\u7f8e\u914d\u56fe"));
        this.f57884i1.setTextColor(getContext().getResources().getColor(R.color.f158017al3));
        this.f57884i1.setTextSize(15.0f);
        this.f57884i1.setOnClickListener(new a());
        this.f57884i1.setPadding(ViewUtils.dip2px(20.0f), ViewUtils.dip2px(2.0f), ViewUtils.dip2px(20.0f), ViewUtils.dip2px(2.0f));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(14, -1);
        layoutParams.bottomMargin = (int) (ViewUtils.getScreenHeight() * 0.2d);
        this.f57884i1.setVisibility(4);
        this.f57776c0.k().g().addView(this.f57884i1, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hd(boolean z16) {
        if (this.f57870b1 == null) {
            return;
        }
        boolean Mc = Mc();
        boolean z17 = z16 && Mc;
        int i3 = z17 ? 0 : 8;
        if (this.f57870b1.getVisibility() != i3) {
            QLog.d("[PhotoAlbum]QzonePictureViewer", 2, "[showOriginalImageBtnLayout] isSelfPicture: " + Mc + " | isShowOriginButton: " + z17);
        }
        this.f57870b1.setVisibility(i3);
    }

    private boolean Ic(int i3) {
        String str;
        ShareActionSheetBuilder.ActionSheetItem build = ShareActionSheetBuilder.ActionSheetItem.build(i3);
        List<ShareActionSheetBuilder.ActionSheetItem> list = this.f57791m;
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

    private void Id() {
        TextView textView = this.f57872c1;
        if (textView != null) {
            textView.setText(R.string.f214675tj);
        }
    }

    private Pair<Boolean, Boolean> Kc() {
        if (this.E1 == -1) {
            this.E1 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.QZONE_CONFIG_SECONDARY_KEY_IS_QRCODE_SCAN, 1);
        }
        if (this.E1 == 0) {
            QZLog.d("[PhotoAlbum]QzonePictureViewer", 1, "isNeedOpenQRCode... isQrcodeScanOpen == 0");
            Boolean bool = Boolean.FALSE;
            return new Pair<>(bool, bool);
        }
        if (!Ta()) {
            return xc(this.H.b());
        }
        Boolean bool2 = Boolean.FALSE;
        return new Pair<>(bool2, bool2);
    }

    public static boolean Kd() {
        return id() ? AppSetting.b("7.3.5") >= 0 : QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PHOTOVIEW_CAN_SHOW_PITU_BUTTON, 0) == 1;
    }

    private boolean Nc() {
        return this.H.F().videoflag == 1 && (this.H.F().videodata.videoStatus == 1 || this.H.F().videodata.videoStatus == 0);
    }

    private boolean Pc() {
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
    public void Qc(File file) {
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
        ((IOCR) QRoute.api(IOCR.class)).startOcrPerformFragment(getActivity(), str3, 2, -1009, null, false);
    }

    private void Rd() {
        String str;
        TextView textView;
        if (this.f57907w0 != null) {
            if (!BasePicureViewController.a0() && !BasePicureViewController.b0() && !BasePicureViewController.o0()) {
                if (this.H.getCount() > 1) {
                    String str2 = (this.H.getSelectedIndex() + 1) + " / " + this.H.getCount();
                    if (!TextUtils.isEmpty(str2) && (textView = this.f57907w0) != null && textView.getText() != null && !str2.equals(this.f57907w0.getText().toString())) {
                        this.f57907w0.setText(str2);
                        if (BasePicureViewController.f0()) {
                            Qd();
                        } else if (this.f57907w0.getVisibility() == 4) {
                            this.f57907w0.setVisibility(0);
                        }
                    }
                } else {
                    this.f57907w0.setText("");
                    this.f57907w0.setVisibility(4);
                }
            } else {
                PhotoInfo b16 = this.H.b();
                if (b16.uploadtime > 0) {
                    String format = new SimpleDateFormat("yyyy\u5e74M\u6708d\u65e5").format(new Date(b16.uploadtime * 1000));
                    if (!TextUtils.isEmpty(format)) {
                        if ((this.H.f49877g.isShareAlbum && BasePicureViewController.a0()) || BasePicureViewController.o0()) {
                            int config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PICTURE_VIEWER_NICK_MAX_LENGTH, 10);
                            String str3 = b16.uploadOwner;
                            if (str3.length() > config) {
                                str3 = str3.substring(0, config) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                            }
                            this.f57907w0.setText(format + com.qzone.util.l.a(R.string.s3z) + str3 + com.qzone.util.l.a(R.string.f172559s43));
                        } else {
                            this.f57907w0.setText(format);
                        }
                        this.f57907w0.setVisibility(0);
                    } else {
                        this.f57907w0.setVisibility(4);
                    }
                } else {
                    this.f57907w0.setVisibility(4);
                }
            }
        }
        int i3 = this.U1;
        if (i3 >= 0 && i3 != this.H.getSelectedIndex()) {
            ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "18", "", true);
        }
        this.U1 = this.H.getSelectedIndex();
        PhotoInfo b17 = this.H.b();
        if (this.C1 && this.W1 != null && this.X1 != null && (str = this.V1) != null && !str.equals(b17.busi_param.get(21))) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.qzone.reborn.layer.part.QZonePictureViewerPart.7
                @Override // java.lang.Runnable
                public void run() {
                    QZonePictureViewerPart qZonePictureViewerPart = QZonePictureViewerPart.this;
                    qZonePictureViewerPart.H.O(qZonePictureViewerPart.getHandler());
                }
            });
        }
        this.V1 = b17.busi_param.get(21);
        this.W1 = b17.albumId;
        this.X1 = b17.lloc;
    }

    private void Tc(PhotoInfo photoInfo) {
        if (photoInfo != null && !TextUtils.isEmpty(photoInfo.appAdSchema)) {
            yo.d.b(getActivity(), new yo.g(photoInfo.appAdSchema));
            if (QZLog.isColorLevel()) {
                QZLog.d("[PhotoAlbum]QzonePictureViewer", 2, "QzonePictureViewer forward ad = " + photoInfo.appAdSchema);
            }
            LpReportInfo_pf00064.allReport(301, 33, 2);
            return;
        }
        QZLog.e("[PhotoAlbum]QzonePictureViewer", "QzonePictureViewer forward ad fail .");
    }

    private void Td() {
        this.N0.setImageResource(this.D ? R.drawable.gbz : R.drawable.gby);
    }

    private void Ud() {
        BasePicureViewController basePicureViewController = this.H;
        if (basePicureViewController != null) {
            basePicureViewController.q();
            this.H.L0();
        }
    }

    private void Xc(QZoneResult qZoneResult) {
        if (!qZoneResult.getSucceed() || !(qZoneResult.getData() instanceof Bundle)) {
            ToastUtil.s(qZoneResult.getMessage(), 4);
        }
        Bundle bundle = qZoneResult.getBundle();
        this.H.b1((FaceData) bundle.getSerializable(PictureConst.PARAM_FACE_DATA), bundle.getInt(PictureConst.PARAM_MARKFACE_INDEX, -1), bundle.getString(PictureConst.PARAM_MARKFACE_UNIKEY, ""));
    }

    private void Yc() {
        String E = this.H.E();
        wb(getContext(), 3, getContext().getResources().getString(R.string.gle), null, E);
    }

    private void Zc(PhotoInfo photoInfo) {
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
            ImageLoader.getInstance().loadImageAsync(str, new ImageLoader.ImageLoadListener() { // from class: com.qzone.reborn.layer.part.QZonePictureViewerPart.35
                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageLoaded(String str2, Drawable drawable, ImageLoader.Options options) {
                    final File imageFile = ImageManager.getInstance().getImageFile(str2, options);
                    if (imageFile == null && !TextUtils.isEmpty(str2) && !ImageManager.isNetworkUrl(str2)) {
                        imageFile = new File(str2);
                    }
                    if (imageFile != null && imageFile.exists()) {
                        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.reborn.layer.part.QZonePictureViewerPart.35.1
                            @Override // java.lang.Runnable
                            public void run() {
                                QZonePictureViewerPart.this.Qc(imageFile);
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

    private void ad() {
        if (getActivity().getResources().getConfiguration().orientation == 2) {
            QLog.i("[PhotoAlbum]QzonePictureViewer", 1, "--current orientation is landscape,try rotate to portrait");
            getActivity().setRequestedOrientation(1);
        }
        yd();
    }

    private void cd() {
        if (this.X0) {
            this.X0 = false;
            try {
                AnimationDrawable animationDrawable = new AnimationDrawable();
                animationDrawable.addFrame(getContext().getResources().getDrawable(R.drawable.gbm), 55);
                animationDrawable.addFrame(getContext().getResources().getDrawable(R.drawable.gbn), 55);
                animationDrawable.addFrame(getContext().getResources().getDrawable(R.drawable.gbo), 55);
                animationDrawable.addFrame(getContext().getResources().getDrawable(R.drawable.gbp), 55);
                animationDrawable.addFrame(getContext().getResources().getDrawable(R.drawable.gbq), 55);
                animationDrawable.addFrame(getContext().getResources().getDrawable(R.drawable.gbr), 55);
                animationDrawable.addFrame(getContext().getResources().getDrawable(R.drawable.gbl), 55);
                animationDrawable.setOneShot(true);
                animationDrawable.setDither(false);
                ImageView imageView = this.R0;
                if (imageView != null) {
                    imageView.setImageDrawable(animationDrawable);
                    animationDrawable.start();
                }
            } catch (Exception e16) {
                QLog.e("[PhotoAlbum]QzonePictureViewer", 2, "onPicInfoIconClick exception " + e16.toString());
            }
            getHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.layer.part.QZonePictureViewerPart.40
                @Override // java.lang.Runnable
                public void run() {
                    long j3;
                    try {
                        PhotoInfo b16 = QZonePictureViewerPart.this.H.b();
                        String config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PICTURE_VIEWER_PIC_INFO_URL, QzoneConfig.DefaultValue.DEFAULT_PICTURE_VIEWER_PIC_INFO_URL);
                        String uinString = LoginData.getInstance().getUinString();
                        if (BasePicureViewController.o0()) {
                            uinString = b16.uploaduin + "";
                        }
                        Uri.Builder appendQueryParameter = Uri.parse(config.replace("{uin}", uinString).replace("{album_id}", b16.albumId).replace("{photo_id}", b16.lloc)).buildUpon().appendQueryParameter("u", uinString).appendQueryParameter("aid", b16.albumId).appendQueryParameter("pid", b16.lloc);
                        if (com.qzone.util.z.b(b16)) {
                            j3 = b16.videodata.originVideoSize;
                        } else {
                            j3 = b16.fileSize;
                        }
                        String builder = appendQueryParameter.appendQueryParameter("psize", String.valueOf(j3)).appendQueryParameter("t", String.valueOf(b16.imageResolution)).appendQueryParameter("_wv", String.valueOf(131072)).appendQueryParameter("_fv", String.valueOf(0)).appendQueryParameter("_proxy", String.valueOf(1)).toString();
                        if (BasePicureViewController.o0()) {
                            builder = builder + "&groupid=" + QZonePictureViewerPart.this.H.f49877g.qunid;
                        }
                        yo.d.n(QZonePictureViewerPart.this.getActivity(), builder, true, R.anim.f155031h7, Color.parseColor("#E5000000"), 9);
                        LpReportInfo_pf00064.allReport(301, 31, 1);
                        QLog.d("[PhotoAlbum]QzonePictureViewer", 2, "jump pic info url " + builder);
                    } catch (Exception e17) {
                        QLog.e("[PhotoAlbum]QzonePictureViewer", 2, "jump pic info exception " + e17.toString());
                    }
                }
            }, 150L);
        }
    }

    private void dd() {
        String str;
        PhotoInfo b16 = this.H.b();
        if (b16 != null) {
            boolean s16 = this.H.s();
            Sd(s16);
            this.H.w(b16);
            this.H.E0(getHandler());
            gb();
            if (s16 && this.H.f49877g.isFriendPhotoBizFeed) {
                com.qzone.adapter.feedcomponent.i H = com.qzone.adapter.feedcomponent.i.H();
                int i3 = this.H.f49877g.businessPhotoFeedIndex;
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
    public void ed(PhotoInfo photoInfo, int i3) {
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
                            basePicureViewController = this.H;
                            if (basePicureViewController != null) {
                                str = String.valueOf(photoParam.ownerUin);
                            }
                            intent.putExtra("report_params", ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).buildQRScanReportParams(null, photoInfo.bigUrl, null, str, String.valueOf(LoginData.getInstance().getUin()), 6));
                            RouteUtils.startActivity(getActivity(), intent, "/qrscan/scanner");
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
        basePicureViewController = this.H;
        if (basePicureViewController != null && (photoParam = basePicureViewController.f49877g) != null) {
            str = String.valueOf(photoParam.ownerUin);
        }
        intent2.putExtra("report_params", ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).buildQRScanReportParams(null, photoInfo.bigUrl, null, str, String.valueOf(LoginData.getInstance().getUin()), 6));
        RouteUtils.startActivity(getActivity(), intent2, "/qrscan/scanner");
    }

    private void gd() {
        Button button = this.f57884i1;
        if (button != null) {
            button.setVisibility(4);
        }
        com.qzone.detail.ui.component.g gVar = this.f57784h;
        if (gVar != null) {
            gVar.updateUI();
        }
        TextView textView = this.J0;
        if (textView != null) {
            textView.setGravity(17);
        }
    }

    private void hd() {
        if (this.f57884i1 != null) {
            gb();
        }
        com.qzone.detail.ui.component.g gVar = this.f57784h;
        if (gVar != null) {
            gVar.updateUI();
        }
        TextView textView = this.J0;
        if (textView != null) {
            textView.setGravity(19);
        }
    }

    public static boolean id() {
        return PackageUtil.isPackageInstalled(MobileQQ.sMobileQQ.getApplicationContext(), "com.tencent.ttpic");
    }

    private void jd() {
        if (this.f57872c1 == null || getHandler() == null) {
            return;
        }
        Hd(true);
        getHandler().postDelayed(this.f57871b2, 2000L);
        getHandler().postDelayed(this.f57873c2, 5000L);
    }

    private void kd(final ArrayList<PhotoDanmakuModel> arrayList) {
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
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.reborn.layer.part.QZonePictureViewerPart.20
                @Override // java.lang.Runnable
                public void run() {
                    QzoneAlbumPicDownloadService.o().n(QZonePictureViewerPart.this.getContext(), System.currentTimeMillis() + "", arrayList2, new a());
                }

                /* renamed from: com.qzone.reborn.layer.part.QZonePictureViewerPart$20$a */
                /* loaded from: classes37.dex */
                class a implements QzoneAlbumPicDownloadService.c {
                    a() {
                    }

                    @Override // com.qzone.album.base.Service.QzoneAlbumPicDownloadService.c
                    public void a(String str, ArrayList<String> arrayList) {
                        AnonymousClass20 anonymousClass20 = AnonymousClass20.this;
                        QZonePictureViewerPart.this.Jd(arrayList);
                    }

                    @Override // com.qzone.album.base.Service.QzoneAlbumPicDownloadService.c
                    public void onDownloadFailed(String str) {
                    }
                }
            });
        } else {
            Jd(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ld() {
        if (this.F1) {
            PhotoDanmakuManager photoDanmakuManager = this.G1;
            if (photoDanmakuManager != null && photoDanmakuManager.isPlaying()) {
                this.G1.quit();
                this.G1.clear();
                this.G1.release();
                View view = this.B1;
                if (view != null) {
                    view.setVisibility(8);
                }
                WindowManager windowManager = this.f57914z1;
                if (windowManager != null) {
                    try {
                        windowManager.removeViewImmediate(this.B1);
                    } catch (Throwable th5) {
                        QLog.e("[PhotoAlbum]QzonePictureViewer", 1, "[releaseDanmakuResAndStop] error: ", th5);
                    }
                }
            }
            this.F1 = false;
        }
    }

    private void md() {
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
    public ScannerResult nd(File file, String str) {
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
    public void oc() {
        if (this.f57870b1 == null || this.f57874d1 == null) {
            return;
        }
        Hd(false);
        this.f57874d1.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pd(PhotoInfo photoInfo) {
        TextView textView;
        TextView textView2;
        int N = this.H.N();
        int D = this.H.D();
        if (N <= 0 && D <= 0) {
            this.K0.setText("");
            this.L0.setText("");
            this.I0.setImageResource(R.drawable.gbe);
            this.M0.setImageResource(R.drawable.gb_);
        } else {
            if (N > 0) {
                String p16 = tk.h.p(N);
                this.K0.setText(p16);
                this.K0.setContentDescription(com.qzone.util.l.a(R.string.s3q) + p16);
            } else {
                this.K0.setText("");
            }
            rd(D);
        }
        if (this.H.s()) {
            this.K0.setTextColor(getContext().getResources().getColor(R.color.a8w));
            this.I0.setImageResource(R.drawable.gbf);
            this.I0.setContentDescription(com.qzone.util.l.a(R.string.s3u));
        } else {
            this.K0.setTextColor(-1);
            if (N > 0) {
                this.I0.setImageResource(R.drawable.gbd);
            } else {
                this.I0.setImageResource(R.drawable.gbe);
            }
            this.I0.setContentDescription(com.qzone.util.l.a(R.string.f172561s45));
        }
        if (!BasePicureViewController.a0() && !BasePicureViewController.b0()) {
            this.f57896o1.setVisibility(8);
            this.H0.setVisibility(8);
        } else if (TextUtils.isEmpty(photoInfo.desc)) {
            this.H0.setVisibility(8);
        } else {
            this.H0.setRichText(photoInfo.desc);
            this.H0.setVisibility(0);
        }
        if (!BasePicureViewController.a0() && !BasePicureViewController.b0() && !BasePicureViewController.g0()) {
            this.f57896o1.setVisibility(8);
            this.H0.setVisibility(8);
        } else if (LoginData.getInstance().getUin() == this.H.f49877g.ownerUin && photoInfo.appid != 311) {
            if (TextUtils.isEmpty(photoInfo.desc)) {
                td(this.f57896o1, com.qzone.util.l.a(R.string.s46));
            } else {
                td(this.f57896o1, photoInfo.desc);
            }
            this.f57896o1.setVisibility(0);
            this.H0.setVisibility(8);
        } else {
            this.f57896o1.setVisibility(8);
        }
        od(photoInfo);
        wd(photoInfo);
        xd(photoInfo);
        Gc(photoInfo);
        if (this.f57909x0 == null || (textView = this.f57911y0) == null) {
            return;
        }
        textView.setVisibility(8);
        if (TextUtils.isEmpty(photoInfo.albumName)) {
            this.f57909x0.setText("");
            return;
        }
        String str = photoInfo.albumName;
        this.f57909x0.setMaxWidth(com.qzone.util.ar.e(QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PICTURE_VIEWER_TITLE_MAX_LENGTH_WITHOUT_PAGENUM, 200)));
        if (this.H.getCount() <= 1 && !BasePicureViewController.a0()) {
            this.f57909x0.setText(str);
            return;
        }
        String str2 = "(" + (this.H.getSelectedIndex() + 1) + "/" + this.H.H() + ")";
        if (!TextUtils.isEmpty(str2) && (textView2 = this.f57907w0) != null && textView2.getText() != null && !str2.equals(this.f57907w0.getText().toString())) {
            this.f57909x0.setMaxWidth(com.qzone.util.ar.e(QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PICTURE_VIEWER_TITLE_MAX_LENGTH_WITH_PAGENUM, 144)));
            this.f57909x0.setText(str);
            if (BasePicureViewController.b0()) {
                this.f57911y0.setVisibility(8);
            } else {
                this.f57911y0.setVisibility(0);
                this.f57911y0.setText(str2);
            }
            if (this.f57875d2) {
                return;
            }
            this.f57875d2 = true;
            this.f57877e2 = this.H.getSelectedIndex();
            return;
        }
        this.f57909x0.setText(str);
    }

    private void rc() {
        b.c cVar;
        try {
            if (getActivity() == null || getActivity().isFinishing() || (cVar = this.f57885i2) == null || !cVar.isShowing()) {
                return;
            }
            this.f57885i2.dismiss();
        } catch (Exception e16) {
            QZLog.w(e16);
        }
    }

    private void sc(Bundle bundle) {
        String string = bundle.getString("trace_info");
        String string2 = bundle.getString("logo_pic");
        String string3 = bundle.getString("jump_url");
        if (!TextUtils.isEmpty(string)) {
            this.f57901r1 = string;
        }
        if (!TextUtils.isEmpty(string2)) {
            this.f57902s1 = string2;
        }
        if (!TextUtils.isEmpty(string3)) {
            this.f57903t1 = string3;
        }
        QZLog.i("[PhotoAlbum]QzonePictureViewer", "filledWithAdData success trace_info: " + string + " logo: " + string2 + " url: " + string3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int tc(int i3) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public int uc(int i3) {
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

    private void ud() {
        int selectedIndex = this.H.getSelectedIndex();
        int i3 = this.Y0;
        if (i3 != selectedIndex && this.H.getItem(i3) != null) {
            this.H.getItem(this.Y0).showGifState = PhotoInfo.SHOW_STATIC_PHOTO;
        }
        this.Y0 = selectedIndex;
        if (this.H.X0() && !Nc()) {
            if ((BasePicureViewController.n0() || BasePicureViewController.f0() || BasePicureViewController.g0() || BasePicureViewController.o0()) && this.f57905v0 == null) {
                Ec();
                Ac();
            }
            if (this.C0 == null) {
                yc();
            }
            PanoramaLayout panoramaLayout = this.R;
            if (panoramaLayout != null && panoramaLayout.F()) {
                this.R.bringToFront();
            }
            final PhotoInfo b16 = this.H.b();
            if (b16 == null) {
                return;
            }
            if (!com.qzone.util.z.b(b16)) {
                S7(false);
            }
            if (!BasePicureViewController.n0() && !BasePicureViewController.g0()) {
                if (b16.unikey != null) {
                    View view = this.C0;
                    if (view != null && view.getVisibility() == 0) {
                        pd(b16);
                    } else if (this.f57890l1) {
                        qd(b16, this.f57888k1);
                    } else {
                        QZoneConfigHelper.h0(new QZoneConfigHelper.a() { // from class: com.qzone.reborn.layer.part.QZonePictureViewerPart.21
                            @Override // common.config.service.QZoneConfigHelper.a
                            public void a(final int i16) {
                                QZonePictureViewerPart.this.f57888k1 = i16;
                                QZonePictureViewerPart.this.f57890l1 = true;
                                QZonePictureViewerPart.this.runOnActivityUiThread(new Runnable() { // from class: com.qzone.reborn.layer.part.QZonePictureViewerPart.21.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        AnonymousClass21 anonymousClass21 = AnonymousClass21.this;
                                        QZonePictureViewerPart.this.qd(b16, i16);
                                    }
                                });
                            }
                        });
                    }
                } else {
                    this.C0.setVisibility(8);
                }
                View view2 = this.P0;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
                View view3 = this.Q0;
                if (view3 != null) {
                    view3.setVisibility(0);
                    return;
                }
                return;
            }
            pd(b16);
            return;
        }
        View view4 = this.P0;
        if (view4 != null) {
            view4.setVisibility(8);
        }
        View view5 = this.Q0;
        if (view5 != null) {
            view5.setVisibility(8);
        }
    }

    private void xd(PhotoInfo photoInfo) {
        if (this.R0 == null || photoInfo == null) {
            return;
        }
        if ((QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PICTURE_VIEWER_SHOW_PIC_INFO, 1) > 0) && photoInfo.picInfoOpen && (BasePicureViewController.a0() || BasePicureViewController.o0())) {
            this.R0.setVisibility(0);
            this.R0.setOnClickListener(this);
            LpReportInfo_pf00064.allReport(301, 31, 3);
            return;
        }
        this.R0.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zd() {
        if (this.L1 != null && this.C1 && BasePicureViewController.f0()) {
            PhotoParam photoParam = this.H.f49877g;
            if (photoParam.qzoneUserType != 0 || photoParam.appid == 202 || photoParam.isSharedFeeds) {
                return;
            }
            if (!this.F1) {
                Bc();
            }
            PhotoDanmakuModel photoDanmakuModel = this.L1;
            this.L1 = null;
            if (this.K1 == null) {
                this.K1 = new ArrayList<>();
            }
            this.K1.add(0, photoDanmakuModel);
            if (this.G1.isPlaying()) {
                AbsDanmaku createDanmaku = this.I1.createDanmaku(1, 0L, photoDanmakuModel.nickName, photoDanmakuModel.content, getContext().getResources().getColor(R.color.a8r), 10.0f, getContext().getResources().getColor(R.color.a8q));
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
                    createDanmaku.setTextSize(TypedValue.applyDimension(2, 14.0f, getContext().getResources().getDisplayMetrics()));
                    createDanmaku.setUserLogoByUin(photoDanmakuModel.userUin);
                    createDanmaku.setLeftImageShape(1);
                    createDanmaku.setBorderRadio(60.0f);
                    this.I1.measureDanmaku(createDanmaku);
                    this.H1.addNow(createDanmaku);
                    return;
                } catch (NumberFormatException unused) {
                    QZLog.e("[PhotoAlbum]QzonePictureViewer", "Integer.parseInt(curDanmakuModel.fontId) - NumberFormatException");
                    return;
                }
            }
            Jd(this.K1);
        }
    }

    @Override // com.qzone.reborn.layer.part.QZoneBasePictureViewerPart, com.qzone.preview.b
    public void H0(int i3) {
        cb(i3, this.H.F());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.part.QZoneBasePictureViewerPart
    public void La(Activity activity, Intent intent) {
        super.La(activity, intent);
        BasePicureViewController basePicureViewController = this.H;
        if (basePicureViewController != null) {
            this.H.F0(null, basePicureViewController.U(), false);
        }
        LocalMultiProcConfig.putBool(LocalMultiProcConfig.Constants.KEY_HAS_ENTER_PICTURE_VIEWER, true);
        md();
        if (activity.getResources().getConfiguration() != null) {
            this.R1 = activity.getResources().getConfiguration().orientation;
        } else {
            this.R1 = 1;
        }
    }

    public boolean Mc() {
        if (BasePicureViewController.o0()) {
            return true;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(LoginData.getInstance().getUin());
        String str = "";
        sb5.append("");
        String sb6 = sb5.toString();
        BasePicureViewController basePicureViewController = this.H;
        long L = basePicureViewController == null ? 0L : basePicureViewController.L();
        if (L != 0) {
            str = String.valueOf(L);
        }
        return !TextUtils.isEmpty(str) && TextUtils.equals(sb6, str);
    }

    protected void Nd() {
        if (!PictureManager.getInstance().checkNetworkConnect()) {
            ToastUtil.n(R.string.gdc);
            return;
        }
        if (this.f57885i2 == null) {
            this.f57885i2 = com.qzone.widget.util.b.d(getContext());
        }
        this.f57885i2.show();
    }

    public void Od(boolean z16) {
        BasePicureViewController basePicureViewController = this.H;
        if (basePicureViewController == null || !basePicureViewController.o()) {
            return;
        }
        if (z16 && this.f57884i1 == null) {
            Hc();
        }
        if (z16) {
            if (getContext().getResources().getConfiguration().orientation != 2) {
                Button button = this.f57884i1;
                if (button != null) {
                    button.setVisibility(0);
                }
                ClickReport.e(4, "", 301, 16, 1);
                return;
            }
            return;
        }
        Button button2 = this.f57884i1;
        if (button2 != null) {
            button2.setVisibility(4);
        }
    }

    public void Qd() {
        TextView textView = this.f57907w0;
        if (textView == null) {
            return;
        }
        if (textView.getVisibility() == 4) {
            this.f57907w0.startAnimation(this.f57895n2);
            this.f57907w0.postDelayed(this.f57893m2, 2000L);
        } else {
            this.f57907w0.removeCallbacks(this.f57893m2);
            this.f57907w0.clearAnimation();
            this.f57907w0.postDelayed(this.f57893m2, 2000L);
        }
    }

    public void Rc() {
        if (id()) {
            Intent intent = new Intent();
            intent.setData(Uri.parse("ttpic://TTPTBEAUTIFY/?refer=qzone"));
            yo.b.a(intent);
            getActivity().startActivity(intent);
            return;
        }
        new com.qzone.component.e().f(getContext(), 230, getContext().getString(R.string.gke), getContext().getString(R.string.gkd), getContext().getString(R.string.f170582ur), getContext().getString(R.string.cancel), new k(), null);
    }

    @Override // com.qzone.reborn.layer.part.QZoneBasePictureViewerPart, com.qzone.preview.b
    public void S0(boolean z16) {
        View view;
        super.S0(z16);
        View view2 = this.f57913z0;
        if (BasePicureViewController.g0()) {
            view2 = this.B0;
        }
        if (view2 != null && this.A0 != null) {
            this.f57881g2 = view2.getVisibility();
            view2.setVisibility(8);
            this.A0.setVisibility(0);
        }
        if (this.F0 != null && (view = this.G0) != null && this.D0 != null) {
            this.f57883h2 = view.getVisibility();
            this.F0.setVisibility(4);
            this.G0.setVisibility(4);
            this.D0.setVisibility(0);
            View view3 = this.E0;
            if (view3 != null) {
                if (z16) {
                    view3.setVisibility(0);
                } else {
                    view3.setVisibility(8);
                }
            }
        }
        sd(8);
        getActivity().setRequestedOrientation(1);
        this.P1 = true;
    }

    @Override // com.qzone.reborn.layer.part.QZoneBasePictureViewerPart, com.qzone.preview.b
    public void S7(boolean z16) {
        super.S7(z16);
        View view = this.O0;
        if (view != null) {
            view.setVisibility(z16 ? 0 : 8);
        }
        View view2 = this.P0;
        if (view2 != null) {
            view2.setVisibility((z16 || Nc()) ? 8 : 0);
        }
    }

    @Override // com.qzone.reborn.layer.part.QZoneBasePictureViewerPart
    protected boolean Sa() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_QZONE_PICTURE_OPT_SCALE, 1) == 1;
    }

    public void Sc(long j3) {
        ho.i.z().r(getActivity(), j3);
    }

    @Override // com.qzone.reborn.layer.part.QZoneBasePictureViewerPart, com.qzone.preview.b
    public void U7() {
        super.U7();
        CommentListBaseController commentListBaseController = this.f57869a2;
        if (commentListBaseController == null || !commentListBaseController.k0()) {
            return;
        }
        this.f57869a2.v();
    }

    protected void Wc() {
        if (!PictureManager.getInstance().checkNetworkConnect()) {
            ToastUtil.n(R.string.gdc);
            return;
        }
        if (this.f57885i2 == null) {
            this.f57885i2 = com.qzone.widget.util.b.d(getContext());
        }
        this.f57885i2.show();
        Xa();
        ib();
        this.H.t(getHandler());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.part.QZoneBasePictureViewerPart
    public void Y9() {
        super.Y9();
        PhotoParam photoParam = this.H.f49877g;
        if (photoParam != null && photoParam.ownerUin == 0 && TextUtils.isEmpty(photoParam.albumid)) {
            return;
        }
        if (this.T1) {
            Z9(2, 84, R.string.gk5, R.drawable.qzone_detail_panel_unfav, (Ta() || BasePicureViewController.i0()) ? false : true);
        } else {
            Z9(2, 6, R.string.gk_, R.drawable.qzone_detail_panel_faved, (Ta() || BasePicureViewController.i0()) ? false : true);
        }
        mb(6, this.H.i(BasePictureViewer.X0));
        mb(84, this.H.i(BasePictureViewer.X0));
        if (!Kd() || Ta()) {
            return;
        }
        Z9(2, 105, R.string.gkc, R.drawable.qzone_detail_panel_pitu, true);
        mb(105, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.part.QZoneBasePictureViewerPart
    public boolean ab() {
        BasePicureViewController basePicureViewController;
        if (!this.Q1 && this.P1 && (basePicureViewController = this.H) != null) {
            basePicureViewController.a(basePicureViewController.getSelectedIndex());
            notifyDataSetChanged();
            return true;
        }
        if (BasePicureViewController.g0() && this.H != null) {
            Intent intent = new Intent();
            this.H.R0(intent);
            getActivity().setResult(-1, intent);
        }
        return super.ab();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void finish() {
        super.finish();
        PictureManager.getInstance().getSender().startDownloadVideo(getHandler());
        getHostActivity().overridePendingTransition(0, 0);
    }

    @Override // com.qzone.reborn.layer.part.QZoneBasePictureViewerPart
    protected void gb() {
        try {
            ud();
            Dd();
            if (BasePicureViewController.g0() && this.f57905v0 != null) {
                PhotoInfo F = this.H.F();
                this.f57904u1.j(F.uploaduin);
                this.f57906v1.setText(F.uploadOwner);
            }
        } catch (Exception e16) {
            QZLog.w(e16);
        }
        Rd();
    }

    @Override // com.qzone.preview.b
    public View h8() {
        return this.O0;
    }

    @Override // com.qzone.reborn.layer.part.QZoneBasePictureViewerPart
    public void ma(int i3, final PhotoInfo photoInfo, boolean z16) {
        final d dVar = new d(z16, photoInfo, i3);
        final ImageLoader.Options obtain = ImageLoader.Options.obtain();
        obtain.justCover = false;
        obtain.needShowGifAnimation = true;
        obtain.type = AppConstants.HTTP_TYPE_QZONE_DOWNLOAD_BIG_PIC;
        obtain.needCallBackProcessPercent = true;
        obtain.isNeedPieceLoad = true;
        if (i3 != 1 && i3 != 3 && i3 != 4 && i3 != 5) {
            if (i3 == 2) {
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.reborn.layer.part.QZonePictureViewerPart.27
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ImageLoader.getInstance().getImageFile(photoInfo.orgUrl) == null) {
                            QZonePictureViewerPart.this.getHandler().post(new Runnable() { // from class: com.qzone.reborn.layer.part.QZonePictureViewerPart.27.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    QZonePictureViewerPart.this.Md(true);
                                }
                            });
                        }
                        QZonePictureViewerPart qZonePictureViewerPart = QZonePictureViewerPart.this;
                        qZonePictureViewerPart.H.y(qZonePictureViewerPart.getHandler(), dVar, obtain, 1000063, photoInfo);
                    }
                });
                return;
            }
            return;
        }
        if (this.f57780e0 != 1) {
            Md(true);
        }
        if (i3 == 3 || i3 == 4 || i3 == 5) {
            photoInfo.showGifState = PhotoInfo.SHOW_NEITHER_GIF_NOR_PLAY;
            if (this.U == this.H.P().length - 1) {
                notifyDataSetChanged();
            }
        }
        this.H.x(getHandler(), dVar, obtain, uc(i3), photoInfo, z16);
    }

    @Override // com.qzone.reborn.layer.part.QZoneBasePictureViewerPart, com.qzone.preview.b
    public Callback n7() {
        return this.f57891l2;
    }

    @Override // com.qzone.reborn.layer.part.QZoneBasePictureViewerPart, com.qzone.preview.b
    public TextView o3() {
        return this.f57874d1;
    }

    @Override // com.qzone.reborn.layer.part.QZoneBasePictureViewerPart, com.qzone.preview.b
    public void o5() {
        View view = this.f57905v0;
        if (view != null) {
            if (view.getVisibility() == 0) {
                if (this.S0 == null) {
                    Dc(false);
                }
                this.f57905v0.startAnimation(this.S0);
            } else {
                if (this.T0 == null) {
                    Dc(true);
                }
                this.f57905v0.startAnimation(this.T0);
            }
        }
        View view2 = this.F0;
        if (view2 != null) {
            if (view2.getVisibility() == 0) {
                if (this.V0 == null) {
                    Cc(true);
                }
                this.G0.startAnimation(this.V0);
            } else {
                if (this.U0 == null) {
                    Cc(false);
                }
                this.G0.startAnimation(this.U0);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x02ff  */
    @Override // com.qzone.reborn.layer.part.QZoneBasePictureViewerPart, com.tencent.biz.richframework.part.Part
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
        super.onActivityResult(i3, i16, intent);
        if (intent == null) {
            QLog.e("[PhotoAlbum]QzonePictureViewer", 1, "[onActivityResult] current data should not be null. error: ", new Exception());
            return;
        }
        if (i3 == 2) {
            this.M1 = false;
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
                if (!this.C1 || TextUtils.isEmpty(stringExtra)) {
                    str4 = "extra_key_barrage_effect_info";
                } else {
                    str4 = "extra_key_barrage_effect_info";
                    this.L1 = new PhotoDanmakuModel(LoginData.getInstance().getNickName(com.qzone.util.l.a(R.string.s3y)), LoginData.getInstance().getUin(), stringExtra, superFontInfo, String.valueOf(i17), String.valueOf(0), "", stringExtra3 != null ? QzoneBarrageEffectData.BarrageEffectInfo.fromJson(stringExtra3) : null);
                }
                this.H.r(stringExtra, stringArrayListExtra, stringExtra2, booleanExtra, getHandler(), str2, str3, stringExtra3);
                if (this.f57869a2 == null) {
                    intent.putExtra("position", this.H.getSelectedIndex());
                    if (i3 == 1207 && this.C1) {
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
                            this.L1 = new PhotoDanmakuModel(LoginData.getInstance().getNickName(com.qzone.util.l.a(R.string.s3w)), LoginData.getInstance().getUin(), stringExtra4, fromJson, String.valueOf(i18), String.valueOf(0), "", stringExtra5 != null ? QzoneBarrageEffectData.BarrageEffectInfo.fromJson(stringExtra5) : null);
                        }
                    }
                    this.f57869a2.n0(i3, i16, intent);
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
                                PhotoInfo b16 = this.H.b();
                                if (stringExtra6 != null && b16 != null && stringExtra6.equals(b16.lloc)) {
                                    if (intent.getBooleanExtra(PictureConst.PHOTO_DELETED, false)) {
                                        Vc();
                                    } else {
                                        boolean booleanExtra2 = intent.getBooleanExtra(PictureConst.PHOTO_MYLIKE, false);
                                        int intExtra3 = intent.getIntExtra(PictureConst.PHOTO_LIKE_NUM, 0);
                                        int intExtra4 = intent.getIntExtra(PictureConst.PHOTO_COMMENT_NUM, 0);
                                        if (!this.H.B0(b16, booleanExtra2, intExtra3, intExtra4)) {
                                            b16.hasPraise = booleanExtra2;
                                            b16.praiseCount = intExtra3;
                                            b16.commentCount = intExtra4;
                                        }
                                        gb();
                                    }
                                } else if (BasePicureViewController.g0() && b16 != null) {
                                    if (intent.getBooleanExtra(PictureConst.PHOTO_DELETED, false)) {
                                        Vc();
                                    } else {
                                        boolean booleanExtra3 = intent.getBooleanExtra(PictureConst.PHOTO_MYLIKE, false);
                                        int intExtra5 = intent.getIntExtra(PictureConst.PHOTO_LIKE_NUM, 0);
                                        int intExtra6 = intent.getIntExtra(PictureConst.PHOTO_COMMENT_NUM, 0);
                                        if (!this.H.B0(b16, booleanExtra3, intExtra5, intExtra6)) {
                                            b16.hasPraise = booleanExtra3;
                                            b16.praiseCount = intExtra5;
                                            b16.commentCount = intExtra6;
                                        }
                                        gb();
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
                    PhotoInfo b17 = this.H.b();
                    if (b17 == null) {
                        return;
                    }
                    arrayList.add(b17.lloc);
                    b17.desc = stringExtra7;
                    EditPhoto editPhoto = new EditPhoto();
                    editPhoto.desc = stringExtra7;
                    Nd();
                    pd(b17);
                    this.H.z(getHandler(), b17.albumId, arrayList, editPhoto, 2, null, stringExtra8);
                }
            } else if (i16 == 293) {
                finish();
                return;
            }
            if (i16 == -1) {
                Intent A = com.qzone.common.activities.base.ak.A(getContext(), 0, false, "[PhotoAlbum]QzonePictureViewer", 23, false);
                A.putExtra("mood_web_pic_url", intent.getStringExtra("mood_web_pic_url"));
                A.putExtra("key_need_save_draft", false);
                getActivity().startActivity(A);
                getActivity().finish();
                return;
            }
        } else if (i16 == -1) {
            this.H.C(intent.getStringExtra("contentIntentKey"), intent.getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_CACHE_UNIKEY), getHandler());
        }
        str4 = "extra_key_barrage_effect_info";
        if (this.f57869a2 == null) {
        }
        super.onActivityResult(i3, i16, intent);
    }

    @Override // com.qzone.reborn.layer.part.QZoneBasePictureViewerPart, com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        BasePicureViewController basePicureViewController;
        if (!this.Q1 && this.P1 && (basePicureViewController = this.H) != null) {
            basePicureViewController.a(basePicureViewController.getSelectedIndex());
            notifyDataSetChanged();
            return true;
        }
        this.O1 = true;
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f166522fu2) {
            dd();
        } else if (id5 == R.id.ftw) {
            Uc();
        } else if (id5 == R.id.fu8) {
            fd();
        } else if (id5 == R.id.ffk) {
            BasePicureViewController basePicureViewController = this.H;
            if (basePicureViewController != null && basePicureViewController.F() != null && this.H.F().appAdShow) {
                Tc(this.H.F());
            } else {
                H0(1);
                QLog.d("[PhotoAlbum]QzonePictureViewer", 1, "origin_btn click");
                ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "12", "", true);
            }
        } else if (id5 == R.id.cuq) {
            H0(2);
        } else if (id5 == R.id.ftx) {
            if (BasePicureViewController.o0()) {
                BasePicureViewController basePicureViewController2 = this.H;
                if (basePicureViewController2 == null) {
                    QLog.e("[PhotoAlbum]QzonePictureViewer", 1, "[onClick] pictureViewController == null", new Exception());
                } else {
                    PhotoParam G = basePicureViewController2.G();
                    PhotoInfo F = this.H.F();
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
                        QZoneHelper.forwardToBrowser(getActivity(), str.replace("{uploadtime}", F.uploadtime + "").replace("{qua}", QUA.getQUA3() + "") + "&fromPic=1", 0, null, "");
                    }
                }
            } else {
                ad();
            }
        } else if (id5 == R.id.ftt) {
            ClickReport.m(ProfileCardTemplate.PROFILE_COMMON_VERSION, "4", "");
            getHostActivity().finish();
        } else if (id5 == R.id.ftu) {
            BasePicureViewController basePicureViewController3 = this.H;
            if (basePicureViewController3 instanceof com.qzone.preview.business.d) {
                LpReportInfo_pf00064.allReport(301, 24, 2);
            } else if (basePicureViewController3 instanceof com.qzone.preview.business.b) {
                LpReportInfo_pf00064.allReport(301, 24, 1);
            }
            if (this.Q1) {
                getHostActivity().finish();
            } else {
                BasePicureViewController basePicureViewController4 = this.H;
                if (basePicureViewController4 != null) {
                    basePicureViewController4.a(basePicureViewController4.getSelectedIndex());
                    notifyDataSetChanged();
                }
            }
        } else if (id5 == R.id.fu6) {
            Ed(false);
            ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "14", "", true);
        } else if (id5 == R.id.kxm) {
            Cd();
        } else if (id5 == R.id.fto) {
            Intent intent = new Intent();
            this.H.R0(intent);
            getActivity().setResult(-1, intent);
            getActivity().finish();
            QZLog.i("[PhotoAlbum]QzonePictureViewer", 1, "pictureviewer_friend_video_close_btn clicked.");
        } else if (id5 == R.id.ftn) {
            Sc(this.H.b().uploaduin);
            QZLog.i("[PhotoAlbum]QzonePictureViewer", 1, "pictureviewer_friend_video_avatar clicked.");
        } else if (id5 == R.id.ftd) {
            BasePicureViewController basePicureViewController5 = this.H;
            if (basePicureViewController5 != null) {
                basePicureViewController5.s0(getActivity());
                BasePicureViewController basePicureViewController6 = this.H;
                if (basePicureViewController6 instanceof com.qzone.preview.business.d) {
                    LpReportInfo_pf00064.allReport(301, 23, 2);
                } else if (basePicureViewController6 instanceof com.qzone.preview.business.b) {
                    LpReportInfo_pf00064.allReport(301, 23, 1);
                }
            }
        } else if (id5 == R.id.fu5) {
            cd();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.qzone.reborn.layer.part.QZoneBasePictureViewerPart, com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i3 = this.R1;
        int i16 = configuration.orientation;
        if (i3 != i16) {
            if (i16 == 1) {
                hd();
            }
            if (configuration.orientation == 2) {
                gd();
            }
            this.R1 = configuration.orientation;
        }
    }

    @Override // com.qzone.reborn.layer.part.QZoneBasePictureViewerPart
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
                sc((Bundle) unpack.getData());
                return;
            case 1000038:
                rc();
                if (unpack.getSucceed()) {
                    Vc();
                    return;
                } else {
                    ToastUtil.s(unpack.getMessage(), 4);
                    return;
                }
            case 1000118:
                rc();
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
                Xc(unpack);
                if (unpack.getSucceed()) {
                    return;
                }
                ToastUtil.s(unpack.getMessage(), 4);
                return;
            case 1000199:
                wc(unpack);
                return;
            default:
                switch (i16) {
                    case 999905:
                        if (unpack.getSucceed()) {
                            ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastCommentSuccess", "\u8bc4\u8bba\u6210\u529f"), 5);
                            BasePicureViewController basePicureViewController = this.H;
                            basePicureViewController.u(basePicureViewController.b());
                            gb();
                            zd();
                            return;
                        }
                        ToastUtil.s(unpack.getMessage(), 4);
                        com.qzone.util.o.d(getContext(), unpack.getReturnCode());
                        return;
                    case 999906:
                        if (unpack.getSucceed()) {
                            return;
                        }
                        BasePicureViewController basePicureViewController2 = this.H;
                        basePicureViewController2.w(basePicureViewController2.b());
                        gb();
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
                                    com.qzone.util.o.d(getContext(), unpack.getReturnCode());
                                    return;
                                }
                            case 999909:
                                rc();
                                if (unpack.getSucceed()) {
                                    Vc();
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
                                        this.H.H0(str);
                                        if (unpack.getSucceed()) {
                                            QfavHelper.B(getContext(), LoginData.getInstance().getUinString(), true, null, false);
                                            return;
                                        }
                                        this.H.a1(str);
                                        if (TextUtils.isEmpty(unpack.getMessage())) {
                                            return;
                                        }
                                        ToastUtil.s(unpack.getMessage(), 4);
                                        return;
                                    case 1000029:
                                        String str2 = (String) unpack.getData();
                                        this.H.H0(str2);
                                        if (QZLog.isDevelopLevel()) {
                                            QZLog.d("[PhotoAlbum]QzonePictureViewer", 4, "del,key=" + str2);
                                        }
                                        if (unpack.getSucceed()) {
                                            ToastUtil.s(getContext().getString(R.string.gfr), 5);
                                            return;
                                        }
                                        this.H.a1(str2);
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
                                                Id();
                                                return;
                                            case 1000061:
                                                BasePicureViewController basePicureViewController3 = this.H;
                                                if (basePicureViewController3 != null) {
                                                    PhotoInfo b16 = basePicureViewController3.b();
                                                    if (b16 != null) {
                                                        b16.hasLoaded = true;
                                                        b16.hasLocalOrgFile = Boolean.valueOf(ImageLoader.getInstance().getImageFile(b16.orgUrl) != null);
                                                        this.f57894n1 = true;
                                                        if (b16.lloc != null) {
                                                            com.qzone.util.ae.b().put(b16.lloc, Boolean.TRUE);
                                                        }
                                                    }
                                                    jd();
                                                    QZLog.d("[PhotoAlbum]QzonePictureViewer", 1, "photo original picture download successfully");
                                                }
                                                Ld(false);
                                                Md(false);
                                                notifyDataSetChanged();
                                                return;
                                            case 1000062:
                                                ToastUtil.n(R.string.d0c);
                                                Ld(true);
                                                Md(false);
                                                return;
                                            case 1000063:
                                                this.H.b().showGifState = PhotoInfo.SHOW_GIF;
                                                Md(false);
                                                notifyDataSetChanged();
                                                return;
                                            case 1000064:
                                                this.H.b().showGifState = PhotoInfo.SHOW_STATIC_PHOTO;
                                                Md(false);
                                                return;
                                            case 1000065:
                                                this.H.b().showGifState = PhotoInfo.SHOW_STATIC_PHOTO;
                                                this.H.b().hasLoaded = true;
                                                if (this.H.P() != null && this.U < this.H.P().length) {
                                                    PhotoInfo[] P = this.H.P();
                                                    int i17 = this.U;
                                                    PhotoInfo photoInfo = P[i17];
                                                    if (photoInfo != null) {
                                                        photoInfo.showGifState = PhotoInfo.SHOW_STATIC_PHOTO;
                                                        photoInfo.hasLoaded = true;
                                                    }
                                                    this.U = i17 + 1;
                                                }
                                                Md(false);
                                                jb();
                                                if (this.f57780e0 != 1 || this.U == this.H.P().length - 1) {
                                                    notifyDataSetChanged();
                                                    return;
                                                }
                                                return;
                                            case 1000066:
                                            case 1000068:
                                            case IChannelType.APP_SUB_CHANNEL_TYPE_CODM /* 1000070 */:
                                                ToastUtil.n(R.string.d0c);
                                                this.H.b().showGifState = PhotoInfo.SHOW_STATIC_PHOTO;
                                                Md(false);
                                                notifyDataSetChanged();
                                                return;
                                            case 1000067:
                                                this.H.b().showGifState = PhotoInfo.SHOW_STATIC_PHOTO;
                                                this.H.b().hasLoaded = true;
                                                if (this.U < this.H.P().length) {
                                                    this.U++;
                                                }
                                                Md(false);
                                                pa();
                                                if (this.U == this.H.P().length - 1) {
                                                    notifyDataSetChanged();
                                                    return;
                                                }
                                                return;
                                            case 1000069:
                                                this.H.b().showGifState = PhotoInfo.SHOW_STATIC_PHOTO;
                                                this.H.b().hasLoaded = true;
                                                if (this.U < this.H.P().length) {
                                                    PhotoInfo[] P2 = this.H.P();
                                                    int i18 = this.U;
                                                    PhotoInfo photoInfo2 = P2[i18];
                                                    if (photoInfo2 == null) {
                                                        QLog.e("[PhotoAlbum]QzonePictureViewer", 1, "[onHandleMessage] photoInfo == null, error stack: ", new Exception());
                                                        return;
                                                    } else {
                                                        photoInfo2.showGifState = PhotoInfo.SHOW_STATIC_PHOTO;
                                                        photoInfo2.hasLoaded = true;
                                                        this.U = i18 + 1;
                                                    }
                                                }
                                                Md(false);
                                                qa();
                                                if (this.U == this.H.P().length - 1) {
                                                    notifyDataSetChanged();
                                                    return;
                                                }
                                                return;
                                            default:
                                                switch (i16) {
                                                    case 1000083:
                                                        Ia(unpack);
                                                        return;
                                                    case 1000084:
                                                        Ja(unpack);
                                                        return;
                                                    default:
                                                        bd(unpack);
                                                        return;
                                                }
                                        }
                                }
                        }
                }
        }
    }

    @Override // com.qzone.reborn.layer.part.QZoneBasePictureViewerPart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        this.S1 = System.currentTimeMillis();
        Intent intent = activity.getIntent();
        this.f57908w1 = intent.getLongExtra(PictureConst.KEY_FEED_DELETE_TIME, 0L);
        getHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.layer.part.QZonePictureViewerPart.1
            @Override // java.lang.Runnable
            public void run() {
                ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "1", "", true);
            }
        }, 500L);
        if (Build.VERSION.SDK_INT >= 27) {
            WindowManager.LayoutParams attributes = getActivity().getWindow().getAttributes();
            Field field = JarReflectUtil.getField(attributes, "layoutInDisplayCutoutMode");
            if (field != null) {
                try {
                    field.setInt(attributes, 1);
                } catch (IllegalAccessException e16) {
                    e16.printStackTrace();
                }
            }
            getActivity().getWindow().setAttributes(attributes);
        }
        if (intent.getExtras() != null) {
            this.N1 = intent.getExtras().getString("recommend_report_uuid");
        }
        ((IQQFloatingWindowBroadcast) QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(getActivity(), false, 5);
    }

    @Override // com.qzone.reborn.layer.part.QZoneBasePictureViewerPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        if (this.f57910x1 != null) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.FeedDeleteOnTimeThread).removeTask(this.f57910x1);
        }
        Ud();
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.reborn.layer.part.QZonePictureViewerPart.17
            @Override // java.lang.Runnable
            public void run() {
                BasePicureViewController basePicureViewController = QZonePictureViewerPart.this.H;
                if (basePicureViewController != null) {
                    basePicureViewController.G0();
                }
            }
        });
        CommentListBaseController commentListBaseController = this.f57869a2;
        if (commentListBaseController != null) {
            commentListBaseController.p0();
        }
        ld();
        ((IQQFloatingWindowBroadcast) QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(getActivity(), true, 0);
        getHandler().removeCallbacks(this.f57871b2);
        getHandler().removeCallbacks(this.f57873c2);
    }

    @Override // com.qzone.reborn.layer.part.QZoneBasePictureViewerPart, com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        com.tencent.common.galleryactivity.m k3;
        super.onPartPause(activity);
        this.f57912y1 = false;
        View view = this.B1;
        if (view != null && !this.M1) {
            view.setVisibility(8);
        }
        com.qzone.misc.network.ttt.a.c().h(this.N1);
        if (this.O1) {
            com.qzone.misc.network.ttt.a.c().f(this.N1);
        }
        GalleryManager galleryManager = this.f57776c0;
        if (galleryManager == null || (k3 = galleryManager.k()) == null) {
            return;
        }
        k3.m();
    }

    @Override // com.qzone.reborn.layer.part.QZoneBasePictureViewerPart, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        PhotoDanmakuManager photoDanmakuManager;
        super.onPartResume(activity);
        this.f57912y1 = true;
        if (this.f57910x1 != null) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.FeedDeleteOnTimeThread).removeTask(this.f57910x1);
        }
        long j3 = this.f57908w1;
        if (j3 > 0) {
            long currentTimeMillis = j3 - (System.currentTimeMillis() / 1000);
            long j16 = currentTimeMillis > 0 ? currentTimeMillis : 0L;
            if (this.f57910x1 == null) {
                this.f57910x1 = new Runnable() { // from class: com.qzone.reborn.layer.part.QZonePictureViewerPart.2
                    @Override // java.lang.Runnable
                    public void run() {
                        BasePicureViewController basePicureViewController = QZonePictureViewerPart.this.H;
                        if (basePicureViewController == null || TextUtils.isEmpty(basePicureViewController.E())) {
                            return;
                        }
                        if (QZonePictureViewerPart.this.f57912y1) {
                            Intent intent = new Intent();
                            intent.setAction("com.qzone.hide_feed_actionpanel");
                            intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_CACHE_UNIKEY, QZonePictureViewerPart.this.H.E());
                            intent.putExtra("extra_key_need_showtoast", false);
                            QZonePictureViewerPart.this.getActivity().sendBroadcast(intent);
                            ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastDeleteMsg", "\u8be5\u5185\u5bb9\u5df2\u88ab\u5220\u9664"), 4);
                        }
                        QZonePictureViewerPart.this.getActivity().finish();
                    }
                };
            }
            if (this.f57910x1 != null) {
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.FeedDeleteOnTimeThread).postDelayed(this.f57910x1, j16 * 1000);
            }
        }
        BasePicureViewController basePicureViewController = this.H;
        if (basePicureViewController != null) {
            basePicureViewController.W0(this.f57889k2);
        }
        View view = this.B1;
        if (view != null && view.getVisibility() == 8 && (photoDanmakuManager = this.G1) != null && photoDanmakuManager.isPlaying()) {
            this.B1.setVisibility(0);
        }
        if (this.R0 != null) {
            this.R0.setImageDrawable(getContext().getResources().getDrawable(R.drawable.gbm));
            this.X0 = true;
        }
        com.qzone.misc.network.ttt.a.c().e(this.N1);
        GalleryManager galleryManager = this.f57776c0;
        if (galleryManager != null) {
            com.tencent.common.galleryactivity.m k3 = galleryManager.k();
            if (k3 instanceof QzoneGalleryScene) {
                ((QzoneGalleryScene) k3).n();
            }
        }
    }

    @Override // com.qzone.reborn.layer.part.QZoneBasePictureViewerPart, com.tencent.biz.richframework.part.Part
    public void onPartSaveInstanceState(Activity activity, Bundle bundle) {
        super.onPartSaveInstanceState(activity, bundle);
        View view = this.B1;
        if (view == null || this.M1) {
            return;
        }
        view.setVisibility(8);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(Activity activity) {
        super.onPartStop(activity);
        this.f57912y1 = false;
    }

    @Override // com.qzone.reborn.layer.part.QZoneBasePictureViewerPart, com.tencent.biz.richframework.part.Part
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        if (z16) {
            QZLog.d("[PhotoAlbum]AlbumPerformance[PhotoAlbum]QzonePictureViewer", 1, "[PhotoAlbum]QzonePictureViewer onWindowFocusChanged cost:" + (System.currentTimeMillis() - this.S1));
        }
    }

    protected void wc(QZoneResult qZoneResult) {
        get_photo_comment_rsp get_photo_comment_rspVar;
        cell_comment cell_commentVar;
        ArrayList<s_commment> arrayList;
        Bundle bundle = qZoneResult.getBundle();
        if (bundle != null && (get_photo_comment_rspVar = (get_photo_comment_rsp) bundle.getSerializable("response")) != null && (cell_commentVar = get_photo_comment_rspVar.comment) != null && (arrayList = cell_commentVar.commments) != null) {
            ArrayList<PhotoDanmakuModel> arrayList2 = this.K1;
            if (arrayList2 == null) {
                this.K1 = new ArrayList<>();
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
                    this.K1.add(new PhotoDanmakuModel(str2, j3, str, (str3 == null || TextUtils.isEmpty(str3)) ? null : QzoneSuperPersonalFontData.SuperFontInfo.fromJson(str3), str4, str5, str6, fromFeedsJceData));
                }
            }
        }
        ArrayList<PhotoDanmakuModel> arrayList3 = this.K1;
        if (arrayList3 == null || arrayList3.size() <= 0) {
            return;
        }
        kd(this.K1);
    }

    public void wd(final PhotoInfo photoInfo) {
        if (this.f57870b1 == null || photoInfo == null) {
            return;
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.qzone.reborn.layer.part.QZonePictureViewerPart.23
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
                    QZonePictureViewerPart.this.getHandler().post(new Runnable() { // from class: com.qzone.reborn.layer.part.QZonePictureViewerPart.23.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QZonePictureViewerPart.this.Ld(false);
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
                    if ((z16 & (!(photoInfo.videoflag != 1))) && !QZonePictureViewerPart.this.f57894n1 && !com.qzone.util.ae.b().snapshot().containsKey(photoInfo.lloc)) {
                        z17 = true;
                    }
                    QZonePictureViewerPart.this.getHandler().post(new Runnable() { // from class: com.qzone.reborn.layer.part.QZonePictureViewerPart.23.2
                        @Override // java.lang.Runnable
                        public void run() {
                            QZonePictureViewerPart.this.Ld(z17);
                        }
                    });
                }
                z16 = true;
                if (z16 & (!(photoInfo.videoflag != 1))) {
                    z17 = true;
                }
                QZonePictureViewerPart.this.getHandler().post(new Runnable() { // from class: com.qzone.reborn.layer.part.QZonePictureViewerPart.23.2
                    @Override // java.lang.Runnable
                    public void run() {
                        QZonePictureViewerPart.this.Ld(z17);
                    }
                });
            }
        });
    }

    @Override // com.qzone.reborn.layer.part.QZoneBasePictureViewerPart, com.qzone.preview.b
    public void y1() {
        super.y1();
        View view = this.f57913z0;
        if (BasePicureViewController.g0()) {
            view = this.B0;
        }
        if (view != null && this.A0 != null) {
            view.setVisibility(this.f57881g2);
            this.A0.setVisibility(8);
        }
        View view2 = this.F0;
        if (view2 != null && this.G0 != null && this.D0 != null) {
            view2.setVisibility(this.f57883h2);
            this.G0.setVisibility(this.f57883h2);
            this.D0.setVisibility(8);
        }
        sd(0);
        getActivity().setRequestedOrientation(4);
        this.P1 = false;
    }

    @Override // com.qzone.reborn.layer.part.QZoneBasePictureViewerPart
    protected void yb() {
        if (this.H.i(BasePictureViewer.X0) && this.f57784h != null) {
            this.H.F0(new QzoneFavoriteService.d() { // from class: com.qzone.reborn.layer.part.QZonePictureViewerPart.18
                @Override // com.qzone.business.favorite.service.QzoneFavoriteService.d
                public void a(String str, final boolean z16) {
                    QZonePictureViewerPart qZonePictureViewerPart = QZonePictureViewerPart.this;
                    if (qZonePictureViewerPart.f57784h != null) {
                        qZonePictureViewerPart.runOnActivityUiThread(new Runnable() { // from class: com.qzone.reborn.layer.part.QZonePictureViewerPart.18.1
                            @Override // java.lang.Runnable
                            public void run() {
                                boolean q06;
                                QZonePictureViewerPart.this.T1 = z16;
                                if (z16) {
                                    q06 = QZonePictureViewerPart.this.f57784h.q0(6, 84);
                                } else {
                                    q06 = QZonePictureViewerPart.this.f57784h.q0(84, 6);
                                }
                                if (q06) {
                                    QZonePictureViewerPart.this.f57784h.refresh();
                                }
                            }
                        });
                    }
                }
            }, this.H.U(), false);
        }
    }

    protected void yc() {
        BasePicureViewController basePicureViewController;
        View inflate = this.f57777d.inflate(R.layout.bqj, (ViewGroup) null);
        this.C0 = inflate;
        this.F0 = inflate.findViewById(R.id.fth);
        this.G0 = this.C0.findViewById(R.id.fti);
        RelativeLayout relativeLayout = (RelativeLayout) this.C0.findViewById(R.id.fte);
        this.D0 = relativeLayout;
        relativeLayout.setPadding(relativeLayout.getPaddingLeft(), this.D0.getPaddingTop(), this.D0.getPaddingRight(), ViewUtils.dpToPx(20.0f));
        View findViewById = this.C0.findViewById(R.id.ftd);
        this.E0 = findViewById;
        findViewById.setOnClickListener(this);
        this.H0 = (CellTextView) this.C0.findViewById(R.id.ftl);
        this.f57870b1 = (RelativeLayout) this.C0.findViewById(R.id.ftj);
        this.f57872c1 = (TextView) this.C0.findViewById(R.id.ffk);
        this.f57874d1 = (TextView) this.C0.findViewById(R.id.ffm);
        this.f57872c1.setOnClickListener(this);
        this.f57874d1.setVisibility(8);
        this.f57876e1 = (TextView) this.C0.findViewById(R.id.f215501b);
        this.f57878f1 = (TextView) this.C0.findViewById(R.id.f215701d);
        this.f57880g1 = (LinearLayout) this.C0.findViewById(R.id.f215601c);
        this.f57882h1 = (LinearLayout) this.C0.findViewById(R.id.f215801e);
        this.O0 = this.C0.findViewById(R.id.ftk);
        this.P0 = this.C0.findViewById(R.id.ftg);
        this.Q0 = this.C0.findViewById(R.id.f166521fu1);
        this.J0 = (TextView) this.C0.findViewById(R.id.ftw);
        this.K0 = (TextView) this.C0.findViewById(R.id.f166724hn1);
        this.I0 = (ImageView) this.C0.findViewById(R.id.f166522fu2);
        this.M0 = (ImageView) this.C0.findViewById(R.id.ftx);
        this.L0 = (TextView) this.C0.findViewById(R.id.hmz);
        this.N0 = (ImageView) this.C0.findViewById(R.id.fu8);
        this.f57898p1 = (ImageView) this.C0.findViewById(R.id.fu6);
        BasePicureViewController basePicureViewController2 = this.H;
        if (basePicureViewController2 != null && basePicureViewController2.j0()) {
            this.f57898p1.setVisibility(4);
        } else {
            this.f57898p1.setOnClickListener(this);
        }
        this.f57896o1 = (CellTextView) this.C0.findViewById(R.id.kxm);
        if ((BasePicureViewController.a0() || BasePicureViewController.b0()) && this.H != null && LoginData.getInstance().getUin() == this.H.f49877g.ownerUin) {
            this.f57896o1.setVisibility(0);
            this.H0.setVisibility(8);
        } else {
            this.f57896o1.setVisibility(8);
        }
        this.f57896o1.setCellClickable(false);
        this.f57896o1.setOnClickListener(this);
        if (!BasePicureViewController.a0() && !BasePicureViewController.b0()) {
            this.f57896o1.setMaxLine(1);
            this.H0.setMaxLine(1);
        } else {
            this.f57896o1.setMaxLine(3);
            this.H0.setMaxLine(3);
        }
        if (!BasePicureViewController.n0() && ((basePicureViewController = this.H) == null || !basePicureViewController.c0())) {
            this.G0.setVisibility(4);
            this.F0.setVisibility(4);
            this.C0.setVisibility(8);
        }
        this.J0.setOnClickListener(this);
        if (this.R1 == 2) {
            this.J0.setGravity(17);
        }
        this.N0.setOnClickListener(this);
        this.I0.setOnClickListener(this);
        this.M0.setOnClickListener(this);
        this.H0.setCellClickable(false);
        this.H0.setOnClickListener(this);
        this.F0.setPadding(0, 0, 0, 0);
        BasePicureViewController basePicureViewController3 = this.H;
        if (basePicureViewController3 != null && basePicureViewController3.h() && !this.H.j0()) {
            V9(this.C0);
        }
        zc();
    }

    protected void yd() {
        PhotoParam G = this.H.G();
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
            PhotoInfo F = this.H.F();
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
        this.f57869a2.C0(bundle);
        if (this.f57869a2.T() != null && this.f57869a2.T().g0() != null) {
            this.f57869a2.T().g0().setLoadingBackgroundColor(-16777216);
        }
        this.f57869a2.G0();
        o5();
    }

    @Override // com.qzone.reborn.layer.part.QZoneBasePictureViewerPart, com.qzone.preview.b
    public boolean z0() {
        CommentListBaseController commentListBaseController = this.f57869a2;
        if (commentListBaseController != null) {
            return commentListBaseController.k0();
        }
        return false;
    }

    protected void zc() {
        if (this.f57869a2 == null) {
            CommentListBaseController s16 = CommentListBaseController.s(getActivity(), 2);
            this.f57869a2 = s16;
            s16.B0(new o());
            CommentListLayout M = this.f57869a2.M();
            this.Z1 = M;
            T9(M);
            this.f57869a2.v();
            this.f57869a2.E0(new p());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oc() {
        this.C1 = true;
        this.Z0.setImageResource(R.drawable.bvy);
        ArrayList<PhotoDanmakuModel> arrayList = this.K1;
        if (arrayList != null && arrayList.size() != 0) {
            kd(this.K1);
        } else {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.qzone.reborn.layer.part.QZonePictureViewerPart.6
                @Override // java.lang.Runnable
                public void run() {
                    QZonePictureViewerPart qZonePictureViewerPart = QZonePictureViewerPart.this;
                    qZonePictureViewerPart.H.O(qZonePictureViewerPart.getHandler());
                }
            });
        }
    }

    private void Uc() {
        String str;
        this.M1 = true;
        String E = this.H.E();
        vb(getContext(), 2, QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "SaySomething", "\u8bf4\u70b9\u4ec0\u4e48\u5427..."), null, E);
        if (BasePicureViewController.a0()) {
            str = ProfileCardTemplate.PROFILE_COMMON_VERSION;
        } else {
            str = "582";
        }
        ClickReport.m(str, "2", "");
        ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "3", "", true);
    }

    private void Vc() {
        this.E = false;
        this.H.v();
        if (this.H.getCount() == 0) {
            ab();
        } else {
            notifyDataSetChanged();
        }
    }

    private void fd() {
        this.f57892m1 = true;
        boolean z16 = true ^ this.D;
        this.D = z16;
        this.H.Z0(z16);
        Td();
    }

    @Override // com.qzone.reborn.layer.part.QZoneBasePictureViewerPart
    public void cb(int i3, PhotoInfo photoInfo) {
        ma(i3, photoInfo, true);
    }

    public void qc(PhotoInfo photoInfo) {
        QZLog.d("[PhotoAlbum]QzonePictureViewer", 1, "decodeFile...");
        this.f57899p2 = HdAsync.with(this).then(new m(QzoneHandlerThreadFactory.getHandlerThreadLooper(QzoneHandlerThreadFactory.NormalThread), photoInfo)).then(new l(Looper.getMainLooper())).call();
    }

    @Override // com.qzone.reborn.layer.part.QZoneBasePictureViewerPart, com.qzone.preview.b
    public void w1() {
        Ed(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jd(ArrayList<PhotoDanmakuModel> arrayList) {
        long j3;
        if (this.f57912y1) {
            ld();
            Bc();
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
                AbsDanmaku createDanmaku = this.I1.createDanmaku(1, j16, photoDanmakuModel.nickName, photoDanmakuModel.content, getContext().getResources().getColor(R.color.a8r), 10.0f, getContext().getResources().getColor(R.color.a8q));
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
                    createDanmaku.setTextSize(TypedValue.applyDimension(2, 14.0f, getContext().getResources().getDisplayMetrics()));
                    createDanmaku.setUserLogoByUin(photoDanmakuModel.userUin);
                    createDanmaku.setLeftImageShape(1);
                    createDanmaku.setBorderRadio(60.0f);
                    this.I1.measureDanmaku(createDanmaku);
                    arrayList2.add(createDanmaku);
                } catch (NumberFormatException unused) {
                    QZLog.e("[PhotoAlbum]QzonePictureViewer", "Integer.parseInt(curDanmakuModel.fontId) - NumberFormatException");
                    return;
                }
            }
            this.H1.addLastAll(arrayList2);
            this.G1.start(this.Y1);
            this.B1.setVisibility(0);
            RetentionReport.report(3);
        }
    }

    private void Sd(boolean z16) {
        if (!z16) {
            this.I0.setImageResource(R.drawable.gbf);
            return;
        }
        BasePicureViewController basePicureViewController = this.H;
        if (basePicureViewController != null && basePicureViewController.N() > 0) {
            this.I0.setImageResource(R.drawable.gbd);
        } else {
            this.I0.setImageResource(R.drawable.gbe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qd(final PhotoInfo photoInfo, int i3) {
        if (i3 == 0) {
            this.C0.setVisibility(0);
            pd(photoInfo);
        } else {
            if (this.f57781f) {
                return;
            }
            this.f57781f = true;
            getHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.layer.part.QZonePictureViewerPart.22
                @Override // java.lang.Runnable
                public void run() {
                    QZonePictureViewerPart.this.C0.setVisibility(0);
                    QZonePictureViewerPart.this.pd(photoInfo);
                }
            }, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rd(int i3) {
        if (i3 > 0) {
            String p16 = tk.h.p(i3);
            this.L0.setText(p16);
            this.L0.setContentDescription(com.qzone.util.l.a(R.string.s3x) + p16);
            this.M0.setImageResource(R.drawable.gb9);
            return;
        }
        this.M0.setImageResource(R.drawable.gb_);
        this.L0.setText("");
    }

    private Pair<Boolean, Boolean> xc(PhotoInfo photoInfo) {
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
        qc(photoInfo);
        Boolean bool4 = Boolean.FALSE;
        return new Pair<>(bool4, bool4);
    }

    public void Ld(boolean z16) {
        TextView textView;
        if (z16) {
            PhotoInfo F = this.H.F();
            if (F != null && F.appAdShow) {
                QLog.i("[PhotoAlbum]QzonePictureViewer", 1, "photoInfo app show is " + F.appAdShow);
                this.f57872c1.setText(F.appAdText);
                Hd(true);
                this.f57874d1.setVisibility(8);
                LpReportInfo_pf00064.allReport(301, 33, 1);
            } else if (F != null) {
                long j3 = F.originSize;
                if (j3 > 0 && this.f57872c1 != null && this.f57870b1 != null) {
                    QLog.i("[PhotoAlbum]QzonePictureViewer", 1, "photo info origin size " + vc(j3));
                    this.f57872c1.setText(com.qzone.util.l.a(R.string.f172556s40));
                    Hd(true);
                    this.f57874d1.setVisibility(8);
                }
            }
            ImageView imageView = this.N0;
            if (imageView != null) {
                imageView.setVisibility(8);
                return;
            }
            return;
        }
        if (this.f57870b1 == null || (textView = this.f57872c1) == null || textView.getText().equals(com.qzone.util.l.a(R.string.f214675tj)) || this.f57872c1.getText().equals(com.qzone.util.l.a(R.string.s3r))) {
            return;
        }
        Hd(false);
    }

    public void Md(boolean z16) {
        TextView textView;
        if (!z16 || (textView = this.f57872c1) == null || this.f57870b1 == null) {
            return;
        }
        textView.setVisibility(0);
        Hd(true);
        BasePicureViewController.n0();
    }

    protected void bd(final QZoneResult qZoneResult) {
        if (qZoneResult != null) {
            getHandler().post(new Runnable() { // from class: com.qzone.reborn.layer.part.QZonePictureViewerPart.19
                @Override // java.lang.Runnable
                public void run() {
                    BasePicureViewController basePicureViewController = QZonePictureViewerPart.this.H;
                    basePicureViewController.C0(qZoneResult, basePicureViewController.getSelectedIndex());
                    BasePicureViewController basePicureViewController2 = QZonePictureViewerPart.this.H;
                    basePicureViewController2.c1(basePicureViewController2.b());
                    QZonePictureViewerPart.this.notifyDataSetChanged();
                }
            });
        }
    }

    public String vc(long j3) {
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

    private void td(CellTextView cellTextView, String str) {
        if (cellTextView == null) {
            return;
        }
        if (TextUtils.isEmpty(this.f57879f2)) {
            int dpToPx = ViewUtils.dpToPx(14.0f);
            this.f57879f2 = "{img:" + URLEncoder.encode("https://ctc.qzonestyle.gtimg.cn/qzone/em/e10034.gif") + ",w:" + dpToPx + ",h:" + dpToPx + "}  ";
        }
        cellTextView.setRichText(this.f57879f2 + str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Finally extract failed */
    @Override // com.qzone.reborn.layer.part.QZoneBasePictureViewerPart
    public boolean bb(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        String string;
        final int i3 = actionSheetItem != null ? actionSheetItem.action : 0;
        if (i3 != 3) {
            if (i3 != 6) {
                if (i3 != 11) {
                    if (i3 != 23) {
                        if (i3 != 40) {
                            if (i3 == 52) {
                                Zc(this.H.b());
                                ga();
                                ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "5", WadlProxyConsts.OPER_TYPE_APK_SIGN, true);
                            } else if (i3 == 56) {
                                LpReportInfo_pf00064.allReport(301, 5, 2);
                            } else if (i3 != 84) {
                                if (i3 != 100) {
                                    switch (i3) {
                                        case 105:
                                            Rc();
                                            ga();
                                            break;
                                        case 106:
                                            BasePicureViewController basePicureViewController = this.H;
                                            if (basePicureViewController.f49896z) {
                                                basePicureViewController.f49896z = false;
                                                this.f57776c0.l().K();
                                                this.f57776c0.l().h();
                                                LpReportInfo_pf00064.allReport(301, 25, 2);
                                            } else {
                                                basePicureViewController.f49896z = true;
                                                if (BasePictureViewer.X0 == 2 && basePicureViewController.G().appid == 311) {
                                                    this.H.Q(this.f57891l2);
                                                }
                                                this.f57776c0.l().K();
                                                this.f57776c0.l().h();
                                                LpReportInfo_pf00064.allReport(301, 25, 1);
                                            }
                                            ga();
                                            break;
                                        case 107:
                                            ga();
                                            vo.c.D(getActivity(), this.H.F().bigUrl);
                                            ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "5", "36", true);
                                            return true;
                                    }
                                } else {
                                    this.H.J0(getActivity(), new h());
                                    ga();
                                    ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "5", "6", true);
                                    return true;
                                }
                            }
                            return super.bb(actionSheetItem);
                        }
                        String string2 = getContext().getResources().getString(R.string.gdq);
                        if (Ta()) {
                            string2 = getContext().getResources().getString(R.string.gdr);
                            string = "";
                        } else if (LoginData.getInstance().isQzoneVip()) {
                            string = getContext().getResources().getString(R.string.gf5);
                        } else {
                            string = getContext().getResources().getString(R.string.f173008gf4);
                        }
                        DialogUtil.createCustomDialog(getContext(), 230).setTitle(string2).setMessage(string).setPositiveButton(com.qzone.util.l.a(R.string.f172558s42), getContext().getResources().getColor(R.color.f157028hz), new g()).setNegativeButton(com.qzone.util.l.a(R.string.j6l), new f()).show();
                        ga();
                        ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "5", "5", true);
                        return true;
                    }
                    Pair<Boolean, Boolean> Kc = Kc();
                    if (!((Boolean) Kc.first).booleanValue() && !((Boolean) Kc.second).booleanValue()) {
                        QZLog.e("[PhotoAlbum]QzonePictureViewer", "[MORE_SAN_QRCODE] this function is closed and not suposed to show!");
                        return true;
                    }
                    QZLog.d("[PhotoAlbum]QzonePictureViewer", 1, "onMoreItemClick... QRCode:", Kc.first, " QQCode:", Kc.second);
                    QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.reborn.layer.part.QZonePictureViewerPart.31
                        @Override // java.lang.Runnable
                        public void run() {
                            QZonePictureViewerPart qZonePictureViewerPart = QZonePictureViewerPart.this;
                            qZonePictureViewerPart.ed(qZonePictureViewerPart.H.b(), i3);
                        }
                    });
                    ga();
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
                        ga();
                        return true;
                    }
                    this.H.r0(getContext());
                    ga();
                    ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "5", "28", true);
                    return true;
                } catch (Throwable th5) {
                    ga();
                    throw th5;
                }
            }
            String U = this.H.U();
            this.H.F0(new i(U), U, false);
            return true;
        }
        Yc();
        ga();
        return true;
    }

    public void od(final PhotoInfo photoInfo) {
        if (photoInfo == null) {
            return;
        }
        getHandler().post(new Runnable() { // from class: com.qzone.reborn.layer.part.QZonePictureViewerPart.24
            @Override // java.lang.Runnable
            public void run() {
                PhotoInfo photoInfo2 = photoInfo;
                if (photoInfo2.photoType == 2 && !TextUtils.isEmpty(photoInfo2.orgUrl)) {
                    QZonePictureViewerPart.this.N0.setVisibility(8);
                    QZonePictureViewerPart.this.D = false;
                } else {
                    if (QzoneConfig.getInstance().getConfig("EasterEgg", QzoneConfig.SECONDARY_SHOW_DELICACY_PICTURE, 1) == 1) {
                        QZonePictureViewerPart.this.Od(photoInfo.isWebPic());
                    }
                    QZonePictureViewerPart.this.N0.setVisibility(8);
                    QZonePictureViewerPart.this.D = false;
                }
            }
        });
    }

    private void sd(int i3) {
        PhotoDanmakuManager photoDanmakuManager;
        PhotoDanmakuManager photoDanmakuManager2;
        if (i3 == 0 || i3 == 8) {
            ImageView imageView = this.Z0;
            if (imageView != null && imageView.getVisibility() != i3) {
                this.Z0.setVisibility(i3);
            }
            if (i3 == 8 && this.B1 != null && (photoDanmakuManager2 = this.G1) != null && photoDanmakuManager2.isPlaying()) {
                this.G1.pause();
                this.B1.setVisibility(8);
            } else {
                if (i3 != 0 || this.B1 == null || (photoDanmakuManager = this.G1) == null || photoDanmakuManager.isPlaying()) {
                    return;
                }
                this.G1.resume();
                this.B1.setVisibility(0);
            }
        }
    }

    @Override // com.qzone.reborn.layer.part.QZoneBasePictureViewerPart
    protected void eb(AbsListView absListView, int i3) {
        View view;
        if (i3 != 0) {
            if ((i3 == 1 || i3 == 2) && (view = this.C0) != null && view.getVisibility() == 0) {
                this.C0.setVisibility(8);
                return;
            }
            return;
        }
        View view2 = this.C0;
        if (view2 == null || view2.getVisibility() != 8) {
            return;
        }
        this.C0.setVisibility(0);
    }

    private void Bd() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            QZonePictureViewerPart.this.f57905v0.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class c implements Animation.AnimationListener {
        c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            QZonePictureViewerPart.this.G0.setVisibility(0);
            QZonePictureViewerPart.this.F0.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    @Override // com.qzone.reborn.layer.part.QZoneBasePictureViewerPart, com.qzone.preview.b
    public void d1(boolean z16) {
    }
}
