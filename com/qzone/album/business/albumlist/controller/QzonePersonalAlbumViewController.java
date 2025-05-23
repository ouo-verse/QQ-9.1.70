package com.qzone.album.business.albumlist.controller;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.qzone.album.base.AlbumPersonalizeManager;
import com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment;
import com.qzone.album.business.albumlist.fragment.AlbumListTabFragment;
import com.qzone.album.business.albumlist.fragment.AlbumMultiTabFragment;
import com.qzone.album.business.albumlist.fragment.AlbumRecentTabFragment;
import com.qzone.album.business.albumlist.fragment.AlbumVideoTabFragment;
import com.qzone.album.business.photolist.adapter.QZonePersonalAlbumRecentAdapter;
import com.qzone.album.business.photolist.adapter.ab;
import com.qzone.album.business.photolist.adapter.v;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.ui.widget.AlbumTimeLineView;
import com.qzone.app.QZoneFeedAlertService;
import com.qzone.business.qboss.QbossAdvDesc;
import com.qzone.common.account.LoginData;
import com.qzone.preview.event.QZoneAlbumCategoryDeletePhotoEvent;
import com.qzone.proxy.vipcomponent.adapter.VipEnv;
import com.qzone.reborn.albumx.qzone.event.QZoneAlbumSwitchTabEvent;
import com.qzone.reborn.albumx.qzone.fragment.QZoneLocalPhotoRecommendFragment;
import com.qzone.reborn.albumx.qzone.vas.event.QZonePhotoDegradeEvent;
import com.qzone.reborn.feedx.activity.QZoneFriendFeedXActivity;
import com.qzone.reborn.repair.bean.QZonePhotoRepairMainInitBean;
import com.qzone.reborn.repair.bean.QZonePhotoRepairTaskInitBean;
import com.qzone.reborn.repair.event.QZonePhotoRepairQueryStatusEvent;
import com.qzone.reborn.repair.event.QZonePhotoRepairTaskStateChangeEvent;
import com.qzone.reborn.repair.utils.QZonePhotoRepairTaskQueueManger;
import com.qzone.reborn.widget.QZoneAlbumAvatarLoopView;
import com.qzone.util.ai;
import com.qzone.widget.QzoneGuideBubbleHelper;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.image.URLDrawable;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.tianshu.api.IQbossReportManager;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.VasQzoneYellowThread;
import com.tencent.mobileqq.vas.api.IVasYellowDiamondPay;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.troop.e;
import com.tencent.mobileqq.widget.tip.a;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qzonehub.api.IQZoneMMKVApi;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.AnimateUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.RDMEtraMsgCollector;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.report.lp.QZoneLoginReportHelper;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.QZonePermission;
import cooperation.qzone.util.SystemUtil;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import cooperation.vip.pb.TianShuAccess;
import eo.c;
import h4.a;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes39.dex */
public class QzonePersonalAlbumViewController extends i4.a implements v, SimpleEventReceiver {
    public static String I0 = "ALBUM_KEY_PRE_SELECTED_TAB_INDEX";
    private static String[] J0;
    private static final Long K0 = 3600000L;
    private static boolean L0 = ar.a("anzaihuang", "2024-07-18", "vas_qzone_photo_refresh_vip").isEnable(true);
    protected View.OnClickListener A0;
    protected View.OnClickListener B0;
    private String C;
    private AlbumTimeLineView C0;
    private String D;
    private RecyclerView D0;
    private String E;
    private ab E0;
    protected int F;
    private List<ab.a> F0;
    public int G;
    private ImageView G0;
    protected TextView H;
    private Animation.AnimationListener H0;
    protected TextView I;
    protected TextView J;
    protected ViewGroup K;
    private ViewGroup L;
    private ViewGroup M;
    protected LinearLayout N;
    protected ProgressBar P;
    protected View Q;
    private View R;
    protected TextView S;
    private RadioGroup T;
    private ViewPager U;
    public ArrayList<Fragment> V;
    private int W;
    private int X;
    private s Y;
    int Z;

    /* renamed from: a0, reason: collision with root package name */
    private List<ab.a> f42170a0;

    /* renamed from: b0, reason: collision with root package name */
    public SystemBarCompact f42171b0;

    /* renamed from: c0, reason: collision with root package name */
    private Handler f42172c0;

    /* renamed from: d0, reason: collision with root package name */
    private long f42173d0;

    /* renamed from: e0, reason: collision with root package name */
    private RelativeLayout f42174e0;

    /* renamed from: f, reason: collision with root package name */
    private final String f42175f;

    /* renamed from: f0, reason: collision with root package name */
    ImageView f42176f0;

    /* renamed from: g0, reason: collision with root package name */
    private Animation f42177g0;

    /* renamed from: h, reason: collision with root package name */
    protected String f42178h;

    /* renamed from: h0, reason: collision with root package name */
    private Animation f42179h0;

    /* renamed from: i, reason: collision with root package name */
    private View f42180i;

    /* renamed from: i0, reason: collision with root package name */
    private com.qzone.album.ui.widget.f f42181i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f42182j0;

    /* renamed from: k0, reason: collision with root package name */
    private Long f42183k0;

    /* renamed from: l0, reason: collision with root package name */
    protected boolean f42184l0;

    /* renamed from: m, reason: collision with root package name */
    private String f42185m;

    /* renamed from: m0, reason: collision with root package name */
    protected boolean f42186m0;

    /* renamed from: n0, reason: collision with root package name */
    private Animation.AnimationListener f42187n0;

    /* renamed from: o0, reason: collision with root package name */
    private View f42188o0;

    /* renamed from: p0, reason: collision with root package name */
    private View f42189p0;

    /* renamed from: q0, reason: collision with root package name */
    private View f42190q0;

    /* renamed from: r0, reason: collision with root package name */
    private ImageView f42191r0;

    /* renamed from: s0, reason: collision with root package name */
    private final com.qzone.album.business.albumlist.fragment.e f42192s0;

    /* renamed from: t0, reason: collision with root package name */
    private boolean f42193t0;

    /* renamed from: u0, reason: collision with root package name */
    private TianShuGetAdvCallback f42194u0;

    /* renamed from: v0, reason: collision with root package name */
    private QbossAdvDesc f42195v0;

    /* renamed from: w0, reason: collision with root package name */
    protected int f42196w0;

    /* renamed from: x0, reason: collision with root package name */
    protected int f42197x0;

    /* renamed from: y0, reason: collision with root package name */
    int f42198y0;

    /* renamed from: z0, reason: collision with root package name */
    protected int f42199z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qzone.album.business.albumlist.controller.QzonePersonalAlbumViewController$22, reason: invalid class name */
    /* loaded from: classes39.dex */
    public class AnonymousClass22 implements Runnable {
        AnonymousClass22() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Drawable loadImage = ImageLoader.getInstance().loadImage("https://qzonestyle.gtimg.cn/aoi/sola/20180328150434_mlHcsh0Vpy.png", new ImageLoader.ImageLoadListener() { // from class: com.qzone.album.business.albumlist.controller.QzonePersonalAlbumViewController.22.1
                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageLoaded(String str, final Drawable drawable, ImageLoader.Options options) {
                    if (((i4.a) QzonePersonalAlbumViewController.this).f407174e != null) {
                        ((i4.a) QzonePersonalAlbumViewController.this).f407174e.runOnUiThread(new Runnable() { // from class: com.qzone.album.business.albumlist.controller.QzonePersonalAlbumViewController.22.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (QzonePersonalAlbumViewController.this.G0 != null) {
                                    QzonePersonalAlbumViewController.this.G0.setImageDrawable(drawable);
                                }
                            }
                        });
                    }
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
            if (loadImage != null) {
                QzonePersonalAlbumViewController.this.G0.setImageDrawable(loadImage);
            }
            int width = QzonePersonalAlbumViewController.this.D0.getWidth();
            QzonePersonalAlbumViewController.this.D0.getHeight();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) QzonePersonalAlbumViewController.this.G0.getLayoutParams();
            layoutParams.topMargin = com.qzone.util.ar.e(16.0f);
            layoutParams.leftMargin = (width / 2) + com.qzone.util.ar.e(20.0f);
            layoutParams.width = com.qzone.util.ar.e(79.0f);
            layoutParams.height = com.qzone.util.ar.e(28.0f);
            QzonePersonalAlbumViewController.this.G0.requestLayout();
        }
    }

    /* loaded from: classes39.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            RDMEtraMsgCollector.getInstance().addNoramlClickAction(QzonePersonalAlbumViewController.this.f42178h, view);
            QzonePersonalAlbumViewController.this.b2();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes39.dex */
    class d implements View.OnClickListener {

        /* loaded from: classes39.dex */
        class a extends QQPermission.BasePermissionsListener {
            a() {
            }

            @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
            public void onAllGranted() {
                super.onAllGranted();
                d.this.b();
            }
        }

        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            QzonePersonalAlbumViewController qzonePersonalAlbumViewController = QzonePersonalAlbumViewController.this;
            if (qzonePersonalAlbumViewController.G == 2) {
                qzonePersonalAlbumViewController.k2();
            } else {
                qzonePersonalAlbumViewController.h2();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            eo.c.f396879a.b();
            if (((i4.a) QzonePersonalAlbumViewController.this).f407174e == null || QZonePermission.requestStoragePermission(((i4.a) QzonePersonalAlbumViewController.this).f407174e, new a(), QQPermissionConstants.Business.SCENE.QQ_QZONE_SHUOSHUO_ALBUM_OPEN_MEDIA)) {
                b();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QzonePersonalAlbumViewController.this.a2();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class f implements a.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.widget.tip.a f42212a;

        f(com.tencent.mobileqq.widget.tip.a aVar) {
            this.f42212a = aVar;
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onClick(View view) {
            QLog.d("[PhotoAlbum]QzonePersonalAlbumViewController", 1, "initShowPhotoRepairBubbleTip onClick");
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onDismiss() {
            QLog.d("[PhotoAlbum]QzonePersonalAlbumViewController", 1, "initShowPhotoRepairBubbleTip onDismiss");
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onShow() {
            QLog.d("[PhotoAlbum]QzonePersonalAlbumViewController", 1, "initShowPhotoRepairBubbleTip onShow");
            com.qzone.reborn.repair.utils.a.f59293a.e();
            HashMap hashMap = new HashMap();
            hashMap.put("bubbletips_type", "1");
            fo.c.g("em_qz_tool_box_remind_bubble", "pg_qz_space_album_list", this.f42212a.v(), hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class g implements a.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f42214a;

        g(int i3) {
            this.f42214a = i3;
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onShow() {
            QLog.d("[PhotoAlbum]QzonePersonalAlbumViewController", 1, "initAIEliminateBubbleTip onShow");
            ((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).saveLong(QQWinkConstants.KEY_SHOW_ELIMINATE_BUBBLE_TIME, System.currentTimeMillis());
            ((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).saveInt(QQWinkConstants.KEY_SHOW_ELIMINATE_BUBBLE_COUNT, this.f42214a + 1);
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onClick(View view) {
            QLog.d("[PhotoAlbum]QzonePersonalAlbumViewController", 1, "initAIEliminateBubbleTip onClick");
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onDismiss() {
            QLog.d("[PhotoAlbum]QzonePersonalAlbumViewController", 1, "initAIEliminateBubbleTip onDismiss");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view != null && view.getContext() != null) {
                ho.i.y().c(view.getContext());
            } else {
                QZLog.e("[PhotoAlbum]QzonePersonalAlbumViewController", 1, "[onClick] right desc click, view or context is null");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view != null && view.getContext() != null) {
                ho.i.v().c(view.getContext(), new QZonePhotoRepairTaskInitBean());
            } else {
                QZLog.e("[PhotoAlbum]QzonePersonalAlbumViewController", 1, "[onClick] right desc click, view or context is null");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes39.dex */
    class j extends AnimateUtils.AnimationAdapter {
        j() {
        }

        @Override // com.tencent.util.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            QzonePersonalAlbumViewController.this.f42174e0.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class k implements View.OnTouchListener {
        k() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (QzonePersonalAlbumViewController.this.f42174e0.getVisibility() == 0 && motionEvent.getAction() == 1) {
                QzonePersonalAlbumViewController.this.m1();
            }
            return true;
        }
    }

    /* loaded from: classes39.dex */
    class l extends AnimateUtils.AnimationAdapter {
        l() {
        }

        @Override // com.tencent.util.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            QzonePersonalAlbumViewController.this.b1();
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
            LpReportInfo_pf00064.allReport(82, 6, 2);
            Intent intent = new Intent();
            intent.setClass(((i4.a) QzonePersonalAlbumViewController.this).f407174e, QZoneFriendFeedXActivity.class);
            intent.putExtra("qzone_uin", LoginData.getInstance().getUin());
            dh.a aVar = dh.a.f393805d;
            if (aVar.c()) {
                aVar.k(false);
                aVar.b();
                intent.putExtra("force_refresh", true);
            }
            QZoneHelper.forwardToQZoneFriendFeedActivity(((i4.a) QzonePersonalAlbumViewController.this).f407174e, intent, false);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class o implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a.C10411a f42223d;

        o(a.C10411a c10411a) {
            this.f42223d = c10411a;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if ("1".equals(this.f42223d.f404274a)) {
                yo.d.d(this.f42223d.f404275b, view.getContext(), null);
                h4.a.c().g(102, this.f42223d);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class p implements ai.b {
        p() {
        }

        @Override // com.qzone.util.ai.b
        public void a(boolean z16, String str, String str2) {
            QzonePersonalAlbumViewController.this.j1(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class q implements IPicLoadStateListener {
        q() {
        }

        @Override // com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            if (loadState.isFinishSuccess() && (option.getAnimatable() instanceof r01.c)) {
                QLog.d("[PhotoAlbum]QzonePersonalAlbumViewController", 1, "initTitleRightRepairProgressLayout anim load success");
                r01.c cVar = (r01.c) option.getAnimatable();
                cVar.setLoopCount(10000);
                cVar.start();
                return;
            }
            QLog.d("[PhotoAlbum]QzonePersonalAlbumViewController", 1, "initTitleRightRepairProgressLayout anim load error");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class r implements View.OnClickListener {
        r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QzonePersonalAlbumViewController.this.J1()) {
                QzonePersonalAlbumViewController.this.C0.q();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes39.dex */
    public class s extends y4.e {
        public s(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            return QzonePersonalAlbumViewController.this.V.size();
        }

        @Override // y4.e
        public Fragment getItem(int i3) {
            return QzonePersonalAlbumViewController.this.V.get(i3);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return obj instanceof AlbumListTabFragment ? -2 : -1;
        }
    }

    public QzonePersonalAlbumViewController(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        this.f42175f = "[PhotoAlbum]QzonePersonalAlbumViewController";
        this.f42178h = getClass().getSimpleName();
        this.G = 0;
        this.V = new ArrayList<>();
        this.Z = 0;
        this.f42173d0 = 1L;
        this.f42182j0 = false;
        this.f42184l0 = false;
        this.f42186m0 = false;
        this.f42187n0 = new j();
        this.f42192s0 = new m();
        this.f42193t0 = false;
        this.f42194u0 = new TianShuGetAdvCallback() { // from class: com.qzone.album.business.albumlist.controller.QzonePersonalAlbumViewController.3
            @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
            public void onGetAdvs(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
                if (QZLog.isColorLevel()) {
                    QZLog.i("[PhotoAlbum]QzonePersonalAlbumViewController", "onGetAdvs isSucc:" + z16);
                }
                if (z16) {
                    final a.C10411a b16 = h4.a.c().b(z16, getAdsRsp);
                    QzonePersonalAlbumViewController qzonePersonalAlbumViewController = QzonePersonalAlbumViewController.this;
                    qzonePersonalAlbumViewController.R = qzonePersonalAlbumViewController.F(R.id.yi_);
                    QzonePersonalAlbumViewController.this.R.post(new Runnable() { // from class: com.qzone.album.business.albumlist.controller.QzonePersonalAlbumViewController.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.C10411a c10411a = b16;
                            if (c10411a != null) {
                                QzonePersonalAlbumViewController qzonePersonalAlbumViewController2 = QzonePersonalAlbumViewController.this;
                                qzonePersonalAlbumViewController2.D2(c10411a, qzonePersonalAlbumViewController2.R);
                            } else {
                                QzonePersonalAlbumViewController qzonePersonalAlbumViewController3 = QzonePersonalAlbumViewController.this;
                                qzonePersonalAlbumViewController3.H2(qzonePersonalAlbumViewController3.R);
                            }
                        }
                    });
                }
            }
        };
        this.A0 = new c();
        this.B0 = new d();
        this.H0 = new l();
    }

    private void A1() {
        if (this.H == null) {
            this.K = (ViewGroup) F(R.id.f166673ha1);
            this.N = (LinearLayout) F(R.id.asq);
            ViewGroup viewGroup = this.K;
            if (viewGroup != null) {
                viewGroup.post(new Runnable() { // from class: com.qzone.album.business.albumlist.controller.QzonePersonalAlbumViewController.7
                    @Override // java.lang.Runnable
                    public void run() {
                        QzonePersonalAlbumViewController.this.A2();
                    }
                });
            }
            d2(this.K, this.N);
            y2(this.K);
            f2();
            e2();
            g2();
            z2(G());
            X0();
        }
        if (Z1()) {
            x1();
            QZonePhotoRepairTaskQueueManger.q();
            SimpleEventBus.getInstance().dispatchEvent(new QZonePhotoRepairQueryStatusEvent(), true);
        } else {
            w1();
        }
        if (X1()) {
            C1();
        }
    }

    private void B2() {
        if (QQTheme.isNowThemeIsNightForQzone()) {
            this.f42188o0.setBackgroundResource(R.drawable.nwm);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f42188o0.getLayoutParams();
            layoutParams.width = SystemUtil.dp2px(54);
            layoutParams.height = SystemUtil.dp2px(54);
            layoutParams.rightMargin = SystemUtil.dp2px(20);
            layoutParams.bottomMargin = SystemUtil.dp2px(70);
        }
    }

    private void C1() {
        ViewGroup viewGroup = this.K;
        if (viewGroup != null && this.f42189p0 == null) {
            View findViewById = viewGroup.findViewById(R.id.xz6);
            if (findViewById instanceof ViewStub) {
                View inflate = ((ViewStub) findViewById).inflate();
                this.f42189p0 = inflate;
                ImageView imageView = (ImageView) inflate.findViewById(R.id.f69883jy);
                if (!AlbumPersonalizeManager.L().P() && !AlbumPersonalizeManager.L().X()) {
                    imageView.setImageResource(R.drawable.qui_question_mark_circle);
                    FragmentActivity fragmentActivity = this.f407174e;
                    if (fragmentActivity != null && fragmentActivity.getResources() != null) {
                        com.tencent.mobileqq.qzone.picload.c.a().m(imageView, this.f407174e.getResources().getColor(R.color.qzone_skin_album_main_text_color));
                    }
                } else {
                    imageView.setImageResource(R.drawable.qui_question_mark_circle_icon_white);
                    FragmentActivity fragmentActivity2 = this.f407174e;
                    if (fragmentActivity2 != null && fragmentActivity2.getResources() != null) {
                        com.tencent.mobileqq.qzone.picload.c.a().m(imageView, this.f407174e.getResources().getColor(R.color.f158017al3));
                    }
                }
                this.f42189p0.setOnClickListener(new h());
            }
        }
        View view = this.f42189p0;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void C2() {
        if (this.U == null) {
            this.U = (ViewPager) F(R.id.f164261pc);
        }
        this.U.setOnPageChangeListener(new a());
        this.T.setOnCheckedChangeListener(new b());
    }

    private void D1() {
        ViewGroup viewGroup = this.K;
        if (viewGroup == null || this.f42190q0 != null) {
            return;
        }
        View findViewById = viewGroup.findViewById(R.id.xzb);
        if (findViewById instanceof ViewStub) {
            View inflate = ((ViewStub) findViewById).inflate();
            this.f42190q0 = inflate;
            this.f42191r0 = (ImageView) inflate.findViewById(R.id.f69483iv);
            this.f42190q0.setOnClickListener(new i());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E2() {
        ImageView imageView;
        if (this.f42195v0 == null || (imageView = this.G0) == null) {
            return;
        }
        imageView.setVisibility(0);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.0f, 1, 0.5f);
        scaleAnimation.setDuration(280L);
        scaleAnimation.setStartOffset(80L);
        this.G0.startAnimation(scaleAnimation);
        VasQzoneYellowThread.INSTANCE.execJob(new Runnable() { // from class: com.qzone.album.business.albumlist.controller.b
            @Override // java.lang.Runnable
            public final void run() {
                QzonePersonalAlbumViewController.this.U1();
            }
        });
        this.f42176f0.postDelayed(new Runnable() { // from class: com.qzone.album.business.albumlist.controller.QzonePersonalAlbumViewController.23
            @Override // java.lang.Runnable
            public void run() {
                QzonePersonalAlbumViewController.this.l1();
            }
        }, 2400L);
    }

    private void F2() {
        String str;
        this.f42174e0.setVisibility(0);
        this.f42176f0.setContentDescription(getResources().getString(R.string.gqf));
        this.D0.startAnimation(AnimationUtils.loadAnimation(BaseApplication.getContext(), R.anim.f154787cm));
        F(R.id.i6r).startAnimation(AnimationUtils.loadAnimation(BaseApplication.getContext(), R.anim.f154775cf));
        String f16 = f1();
        if (!TextUtils.isEmpty(f16)) {
            if (f16.equals(QzoneVideoBeaconReport.EVENT_ALBUM_BANNER)) {
                str = QzoneVideoBeaconReport.EVENT_ALBUM_BANNER_ADD;
            } else if (f16.equals(QzoneVideoBeaconReport.EVENT_ALBUM_LIST)) {
                str = QzoneVideoBeaconReport.EVENT_ALBUM_LIST_ADD;
            } else {
                str = QzoneVideoBeaconReport.EVENT_ALBUM_OTHER_ADD;
            }
        } else {
            str = "";
        }
        QzoneVideoBeaconReport.reportAlbumEvent(LoginData.getInstance().getUinString(), str);
        com.qzone.album.env.common.a.m().Q(4, "getApplist", 326, 1, 12);
        this.f42176f0.postDelayed(new Runnable() { // from class: com.qzone.album.business.albumlist.controller.QzonePersonalAlbumViewController.19
            @Override // java.lang.Runnable
            public void run() {
                QzonePersonalAlbumViewController.this.E2();
            }
        }, 500L);
        RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: com.qzone.album.business.albumlist.controller.QzonePersonalAlbumViewController.20
            @Override // java.lang.Runnable
            public void run() {
                VideoReport.traversePage(QzonePersonalAlbumViewController.this.D0);
            }
        }, 200L);
    }

    private boolean G1() {
        return this.G == 3;
    }

    private void G2() {
        String str;
        if (this.Q == null || this.S == null) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) F(R.id.f68183fc);
        QZoneCountInfo singleUnReadItem = QZoneFeedAlertService.getInstance().getSingleUnReadItem(2);
        QLog.i("[PhotoAlbum]QzonePersonalAlbumViewController", 1, "showQZoneEntranceView countInfo=" + singleUnReadItem);
        if (singleUnReadItem != null && singleUnReadItem.uCount > 0) {
            this.X = 2;
            frameLayout.setVisibility(0);
            this.Q.setVisibility(8);
            QZoneAlbumAvatarLoopView qZoneAlbumAvatarLoopView = new QZoneAlbumAvatarLoopView(this.f407174e);
            frameLayout.removeAllViews();
            frameLayout.addView(qZoneAlbumAvatarLoopView);
            qZoneAlbumAvatarLoopView.setData(singleUnReadItem);
            if (singleUnReadItem.uCount > 99) {
                str = "99+";
            } else {
                str = singleUnReadItem.uCount + "";
            }
            this.S.setText(String.format(com.qzone.reborn.configx.g.f53821a.b().A0(), str));
        } else {
            this.X = 1;
            frameLayout.setVisibility(8);
            this.Q.setVisibility(0);
            this.S.setText(com.qzone.reborn.configx.g.f53821a.b().B0());
        }
        s2();
    }

    private boolean H1() {
        return P2() && QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.KEY_SHOW_TIME_LINE_FOR_GUEST_IN_RECENT_PHOTO_TAB, 1) == 1;
    }

    private boolean I1() {
        return !P2() && QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.KEY_SHOW_TIME_LINE_FOR_HOST_IN_RECENT_PHOTO_TAB, 1) == 1;
    }

    private void I2() {
        QLog.d("[PhotoAlbum]QzonePersonalAlbumViewController", 1, hashCode() + " startRepairingAnimLoading, mIsRepairingAnimShowing: " + this.f42193t0);
        if (this.f42193t0) {
            return;
        }
        this.f42193t0 = true;
        if (this.f42190q0 == null) {
            D1();
        }
        QQPicLoader.f201806a.e(Option.obtain().setPreferDecoder(com.tencent.libra.extension.a.class).setNeedShowLoadingDrawable(false).setUrl("https://qzonestyle.gtimg.cn/qzone/client/mqq/photo-album/taskloading48.zip").setTargetView(this.f42191r0), new q());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean J1() {
        return this.G == 1;
    }

    private void J2() {
        QLog.d("[PhotoAlbum]QzonePersonalAlbumViewController", 1, hashCode() + " stopRepairingAnimLoading, mIsRepairingAnimShowing: " + this.f42193t0);
        this.f42193t0 = false;
        View view = this.f42190q0;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L1(ImageView imageView, int i3) {
        com.tencent.mobileqq.widget.tip.a r16 = com.tencent.mobileqq.widget.tip.a.r(imageView.getContext());
        r16.S(imageView).k0(2).R(0).o0(com.qzone.util.l.a(R.string.f133877a)).j0(10.0f, 8.0f, 10.0f, 8.0f).W(imageView.getResources().getColor(R.color.qui_common_bg_top_dark)).f(new g(i3));
        r16.s0();
    }

    private void L2(QZoneAlbumSwitchTabEvent qZoneAlbumSwitchTabEvent) {
        if (qZoneAlbumSwitchTabEvent.getTabType() != 4 || this.V == null) {
            return;
        }
        for (int i3 = 0; i3 < this.V.size(); i3++) {
            if (this.V.get(i3) instanceof QZoneLocalPhotoRecommendFragment) {
                this.U.setCurrentItem(i3);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M1() {
        this.f42195v0 = m5.a.H().J(LoginData.getInstance().getUin(), 2657);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N1(ImageView imageView) {
        com.tencent.mobileqq.widget.tip.a r16 = com.tencent.mobileqq.widget.tip.a.r(imageView.getContext());
        r16.S(imageView).k0(2).R(0).o0(com.qzone.util.l.a(R.string.f169561wa0)).j0(10.0f, 8.0f, 10.0f, 8.0f).W(imageView.getResources().getColor(R.color.qui_common_bg_top_dark)).f(new f(r16));
        r16.s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean P2() {
        return com.qzone.album.env.common.a.m().s() != this.f42183k0.longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit Q1(HashMap hashMap, Boolean bool) {
        hashMap.put("action_type", "click");
        hashMap.put("btn_type", 1);
        hashMap.put("is_tick", Integer.valueOf(bool.booleanValue() ? 1 : 0));
        if (bool.booleanValue()) {
            na.e.f419543a.d(3);
        }
        fo.c.c("ev_qz_yellowdiamond_demotion_pop", hashMap);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit R1(HashMap hashMap, Boolean bool) {
        hashMap.put("action_type", "click");
        hashMap.put("btn_type", 2);
        hashMap.put("is_tick", Integer.valueOf(bool.booleanValue() ? 1 : 0));
        if (bool.booleanValue()) {
            na.e.f419543a.d(3);
        }
        fo.c.c("ev_qz_yellowdiamond_demotion_pop", hashMap);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S1(e.DialogData dialogData) {
        final HashMap hashMap = new HashMap();
        hashMap.put("belong_app", 1);
        new com.tencent.mobileqq.vas.troop.e(this.L.getContext(), dialogData, new Function1() { // from class: com.qzone.album.business.albumlist.controller.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit Q1;
                Q1 = QzonePersonalAlbumViewController.Q1(hashMap, (Boolean) obj);
                return Q1;
            }
        }, new Function1() { // from class: com.qzone.album.business.albumlist.controller.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit R1;
                R1 = QzonePersonalAlbumViewController.R1(hashMap, (Boolean) obj);
                return R1;
            }
        }).j();
        hashMap.put("action_type", "imp");
        fo.c.c("ev_qz_yellowdiamond_demotion_pop", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit T1(final e.DialogData dialogData) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.qzone.album.business.albumlist.controller.f
            @Override // java.lang.Runnable
            public final void run() {
                QzonePersonalAlbumViewController.this.S1(dialogData);
            }
        });
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U1() {
        LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(225, 1, 5), false, false);
        ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportExpose(this.f42195v0.res_traceinfo, LoginData.getInstance().getUinString());
        m5.a.H().C(LoginData.getInstance().getUinString(), 2657);
        this.f42195v0 = null;
    }

    private void V1() {
        ab.a aVar;
        List<ab.a> list = this.F0;
        if (list != null) {
            boolean z16 = false;
            list.get(0).f42670c = getResources().getDrawable(R.drawable.g_2);
            this.F0.get(1).f42670c = getResources().getDrawable(R.drawable.nxh);
            if (this.F0.get(2) != null) {
                ab.a aVar2 = this.F0.get(2);
                aVar2.f42670c = getResources().getDrawable(R.drawable.ny_);
                aVar2.f42673f = com.qzone.reborn.repair.utils.a.f59293a.b();
                z16 = true;
            }
            if (z16) {
                aVar = this.F0.get(3);
            } else {
                aVar = this.F0.get(2);
            }
            aVar.f42670c = getResources().getDrawable(R.drawable.f16248u);
            aVar.f42672e = "mqzone://arouse/openqqpublish/mood?target=23&source=1";
            aVar.f42673f = !F1();
            this.E0.notifyDataSetChanged();
        }
        if (F(R.id.f0g) != null) {
            if (QQTheme.isNowThemeIsNightForQzone()) {
                F(R.id.f0g).setBackgroundColor(-16777216);
            } else {
                F(R.id.f0g).setBackgroundColor(-788742);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean W1() {
        if (this.V.get(this.G) instanceof com.qzone.album.business.albumlist.fragment.d) {
            return ((com.qzone.album.business.albumlist.fragment.d) this.V.get(this.G)).I6(this.f42173d0);
        }
        return false;
    }

    private void X0() {
        ViewGroup viewGroup = this.K;
        if (viewGroup != null && (viewGroup.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            int dpToPx = ImmersiveUtils.dpToPx(47.0f);
            ViewGroup.LayoutParams layoutParams = this.K.getLayoutParams();
            layoutParams.height = dpToPx;
            this.K.setLayoutParams(layoutParams);
        }
    }

    private boolean X1() {
        boolean c16 = com.qzone.reborn.albumx.qzone.local.g.f52662a.c();
        boolean P2 = P2();
        QZLog.d("[PhotoAlbum]QzonePersonalAlbumViewController", 1, "[isNeedShowLocalPhotoTab] isNeedShowLocalPhotoTab = " + c16 + ", isGuest = " + P2);
        return !P2 && c16;
    }

    private void a1() {
        if (!AlbumPersonalizeManager.L().P() && !AlbumPersonalizeManager.L().X()) {
            AlbumPersonalizeManager.F(this.f407174e, true);
        } else {
            AlbumPersonalizeManager.F(this.f407174e, false);
        }
        AlbumPersonalizeManager.L().V(this.f407174e, this.G, F(R.id.f164260pa), F(R.id.dwl), F(R.id.dyp), F(R.id.dyn), F(R.id.dvk), (RadioButton) this.T.getChildAt(0), (RadioButton) this.T.getChildAt(1), (RadioButton) this.T.getChildAt(2), (RadioButton) this.T.getChildAt(3));
        if (AlbumPersonalizeManager.L().J() != null) {
            V1();
            if (AlbumPersonalizeManager.L().Q()) {
                if (com.tencent.mobileqq.simpleui.b.c()) {
                    this.K.setBackgroundColor(SimpleUIUtil.getSimpleUiBgColor());
                    this.M.setBackgroundColor(SimpleUIUtil.getSimpleUiBgColor());
                } else {
                    this.K.setBackgroundColor(-1);
                    this.M.setBackgroundColor(-1);
                }
                s5.a.i(this.K);
                this.L.setBackgroundColor(-1);
                View view = this.f42180i;
                if (view != null) {
                    view.setVisibility(0);
                }
            } else {
                this.K.setBackgroundColor(16777215);
                this.M.setBackgroundColor(16777215);
                AlbumPersonalizeManager.L().W(H(), "bg@2x.png", this.L);
                View view2 = this.f42180i;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
            }
            if (Z1()) {
                x1();
            } else {
                w1();
            }
            if (this.V != null) {
                for (int i3 = 0; i3 < this.V.size(); i3++) {
                    if (this.V.get(i3) instanceof AlbumBaseTabFragment) {
                        ((AlbumBaseTabFragment) this.V.get(i3)).gi();
                    }
                }
            }
        }
        V1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a2() {
        if (!this.f42182j0) {
            u1();
            this.f42182j0 = true;
        }
        RelativeLayout relativeLayout = this.f42174e0;
        if (relativeLayout != null) {
            if (relativeLayout.getVisibility() != 0) {
                F2();
            } else {
                m1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b1() {
        ImageView imageView = this.G0;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    private boolean c1() {
        int i3 = Build.VERSION.SDK_INT;
        return i3 == 26 || i3 == 27 || i3 == 28;
    }

    private void c2(View view) {
        ho.i.v().b(view.getContext(), new QZonePhotoRepairMainInitBean(1));
        com.qzone.reborn.repair.utils.a aVar = com.qzone.reborn.repair.utils.a.f59293a;
        aVar.f();
        if (this.F0.get(2) != null) {
            this.F0.get(2).f42673f = aVar.b();
            this.E0.notifyDataSetChanged();
        }
    }

    private AlbumRecentTabFragment g1() {
        if (this.V.get(this.G) instanceof AlbumRecentTabFragment) {
            return (AlbumRecentTabFragment) this.V.get(this.G);
        }
        return null;
    }

    private void i1(ab.a aVar) {
        v2();
        if (aVar != null) {
            aVar.f42673f = !F1();
            this.E0.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j1(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            QZLog.e("[PhotoAlbum]QzonePersonalAlbumViewController", "qbossData: " + str);
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                int color = getResources().getColor(R.color.a8m);
                if (QQTheme.isNowThemeIsNightForQzone()) {
                    color = getResources().getColor(R.color.a8h);
                }
                this.f42170a0 = new ArrayList();
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    ab.a aVar = new ab.a(jSONObject.getString("icon_name"), color, jSONObject.getString("icon_pic"), jSONObject.getString("icon_url"));
                    if (!TextUtils.isEmpty(aVar.f42668a) && !TextUtils.isEmpty(aVar.f42671d) && !TextUtils.isEmpty(aVar.f42672e)) {
                        this.f42170a0.add(aVar);
                    }
                }
            }
        } catch (Exception e16) {
            QZLog.e("[PhotoAlbum]QzonePersonalAlbumViewController", "parse qboss Json Error: ", e16);
        }
    }

    private boolean k1() {
        if (this.V.get(0) instanceof AlbumListTabFragment) {
            return ((AlbumListTabFragment) this.V.get(0)).vj();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l1() {
        if (this.G0 != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.0f, 1, 0.5f);
            scaleAnimation.setDuration(280L);
            scaleAnimation.setStartOffset(80L);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setAnimationListener(this.H0);
            this.G0.startAnimation(scaleAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m1() {
        this.f42176f0.setContentDescription(getResources().getString(R.string.gqo));
        ImageView imageView = this.G0;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        this.D0.startAnimation(this.f42177g0);
        F(R.id.i6r).startAnimation(this.f42179h0);
        com.qzone.album.env.common.a.m().Q(4, "getApplist", 326, 1, 13);
    }

    private void n2() {
        Intent G = G();
        if (G != null) {
            String stringExtra = G.getStringExtra(QZoneHelper.QZoneAlbumConstants.KEY_LEFT_TAB_TITLE);
            this.f42185m = stringExtra;
            if (TextUtils.isEmpty(stringExtra)) {
                this.f42185m = I(R.string.gaz);
            }
            String stringExtra2 = G.getStringExtra("key_middle_tab_title");
            this.C = stringExtra2;
            if (TextUtils.isEmpty(stringExtra2)) {
                this.C = I(R.string.gbe);
            }
            String stringExtra3 = G.getStringExtra(QZoneHelper.QZoneAlbumConstants.KEY_RIGHT_TAB_TITLE);
            this.D = stringExtra3;
            if (TextUtils.isEmpty(stringExtra3)) {
                this.D = I(R.string.gcb);
            }
            String stringExtra4 = G.getStringExtra("key_four_tab_title");
            this.E = stringExtra4;
            if (TextUtils.isEmpty(stringExtra4)) {
                this.E = I(R.string.gaw);
            }
            boolean z16 = false;
            this.F = G.getIntExtra(QZoneHelper.QZoneAlbumConstants.KEY_SELECTED_TAB, 0);
            this.f42183k0 = Long.valueOf(t4.a.N().c(this.f407174e, G));
            if (5 == G.getIntExtra(QZoneLoginReportHelper.KEY_LOGIN_FROM_MQQ, -1) && QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.KEY_SHOW_ENTRANCE_GUIDE, 1) == 1) {
                z16 = true;
            }
            this.f42184l0 = z16;
        }
    }

    private void o1(final ImageView imageView) {
        if (dh.a.f393805d.h()) {
            QLog.w("QZ_QFS_[PhotoAlbum]QzonePersonalAlbumViewController", 1, "initAIEliminateBubbleTip, isShowQcircleEntranceGuideBubble");
            return;
        }
        if (com.qzone.reborn.repair.utils.a.f59293a.a()) {
            QLog.i("[PhotoAlbum]QzonePersonalAlbumViewController", 1, "photo repair bubble show");
            return;
        }
        final int intValue = ((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).getIntValue(QQWinkConstants.KEY_SHOW_ELIMINATE_BUBBLE_COUNT, 0);
        if (intValue < 3 && ((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).getLongValue(QQWinkConstants.KEY_SHOW_ELIMINATE_BUBBLE_TIME, -1L) + (K0.longValue() * 168) < System.currentTimeMillis()) {
            RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: com.qzone.album.business.albumlist.controller.h
                @Override // java.lang.Runnable
                public final void run() {
                    QzonePersonalAlbumViewController.this.L1(imageView, intValue);
                }
            }, 1000L);
        }
    }

    private void o2() {
        Fragment fragment;
        ArrayList<Fragment> arrayList = this.V;
        if (arrayList == null) {
            return;
        }
        if (arrayList.get(0) instanceof AlbumMultiTabFragment) {
            fragment = ((AlbumMultiTabFragment) this.V.get(0)).getMAlbumListMultiTabPart().H9();
        } else {
            fragment = this.V.get(0) instanceof AlbumListTabFragment ? (AlbumListTabFragment) this.V.get(0) : null;
        }
        if (fragment == null || !(fragment instanceof AlbumListTabFragment)) {
            return;
        }
        LpReportInfo_pf00064.allReport(326, 1, 42);
        yo.d.b(H(), new yo.g(((AlbumListTabFragment) fragment).rj()));
    }

    private void p1() {
        if (!xe.a.f447839a.b() && !c1()) {
            this.V.add(new AlbumMultiTabFragment());
        } else {
            this.V.add(new AlbumListTabFragment());
        }
        this.V.add(new AlbumRecentTabFragment());
        this.V.add(new AlbumVideoTabFragment());
        boolean X1 = X1();
        QZLog.d("[PhotoAlbum]QzonePersonalAlbumViewController", 1, "[initData] isNeedShowLocalPhotoTab = " + X1);
        if (X1) {
            this.V.add(new QZoneLocalPhotoRecommendFragment());
            J0 = new String[]{this.f42185m, this.C, this.D, this.E};
            F(R.id.j_f).setVisibility(0);
        } else {
            J0 = new String[]{this.f42185m, this.C, this.D};
            F(R.id.j_f).setVisibility(8);
        }
        if (this.f42183k0.longValue() == LoginData.getInstance().getUin()) {
            QZoneFeedAlertService.getInstance().clearSingleUnreadCount(19);
        }
        s1();
        q1();
        ai.c(2664, new p(), QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_LOCAL_PHOTO_HEAD_REQUEST_QBOSS, 72) * 60 * 60 * 1000);
        Long l3 = this.f42183k0;
        if (l3 != null && l3.longValue() == LoginData.getInstance().getUin()) {
            u2();
        }
        if (!L0 || LoginData.getInstance().isQzoneVip()) {
            return;
        }
        VipEnv.refreshYellowDiamondInfo();
    }

    private void p2() {
        View view = this.R;
        if (view == null) {
            return;
        }
        VideoReport.setPageId(view, "pg_qz_space_album_list");
        HashMap hashMap = new HashMap();
        hashMap.put(IFileBrowserService.FILE_BROWSER_PAGE_FROM, 1);
        VideoReport.setPageParams(this.R, new fo.a().d("[PhotoAlbum]QzonePersonalAlbumViewController", hashMap));
    }

    private void q2() {
        VideoReport.setPageId(this.D0, "pg_qz_tool_box_float");
        VideoReport.setPageParams(this.D0, new fo.a().d("[PhotoAlbum]QzonePersonalAlbumViewController", null));
    }

    private void r1() {
        h4.a.c().f(this.f42194u0);
    }

    private void s1() {
        VasQzoneYellowThread.INSTANCE.execJob(new Runnable() { // from class: com.qzone.album.business.albumlist.controller.c
            @Override // java.lang.Runnable
            public final void run() {
                QzonePersonalAlbumViewController.this.M1();
            }
        });
    }

    private void s2() {
        HashMap hashMap = new HashMap();
        hashMap.put("entry_style", Integer.valueOf(this.X));
        fo.c.o(this.R, "em_qz_space_entry_column", new fo.b().l(hashMap));
    }

    private void t1() {
        File imageFile = ImageLoader.getInstance().getImageFile("https://qzonestyle.gtimg.cn/aoi/sola/20180328150434_mlHcsh0Vpy.png");
        File imageFile2 = ImageLoader.getInstance().getImageFile("https://qzonestyle.gtimg.cn/aoi/sola/20180328150434_Z0ALPzltCO.png");
        if (imageFile != null && imageFile.exists() && imageFile2 != null && imageFile2.exists()) {
            this.G0 = (ImageView) F(R.id.hd_);
            this.f42176f0.postDelayed(new AnonymousClass22(), 500L);
        } else {
            ImageLoader.getInstance().loadImage("https://qzonestyle.gtimg.cn/aoi/sola/20180328150434_Z0ALPzltCO.png", (ImageLoader.ImageLoadListener) null, (ImageLoader.Options) null);
            ImageLoader.getInstance().loadImage("https://qzonestyle.gtimg.cn/aoi/sola/20180328150434_mlHcsh0Vpy.png", (ImageLoader.ImageLoadListener) null, (ImageLoader.Options) null);
        }
    }

    private void t2() {
        fo.b bVar = new fo.b();
        HashMap hashMap = new HashMap();
        hashMap.put("dt_pgid", "pg_qz_space_album_list");
        bVar.l(hashMap);
        bVar.h(new c.a());
        fo.c.o(this.f42188o0, "em_qz_plus_suspend", bVar);
    }

    private void u2() {
        ((IVasYellowDiamondPay) QRoute.api(IVasYellowDiamondPay.class)).addPayCallback(new IVasYellowDiamondPay.a() { // from class: com.qzone.album.business.albumlist.controller.d
            @Override // com.tencent.mobileqq.vas.api.IVasYellowDiamondPay.a
            public final void onResult(boolean z16, int i3, String str) {
                QzonePersonalAlbumViewController.P1(z16, i3, str);
            }
        });
        na.e.f419543a.b(3, new Function1() { // from class: com.qzone.album.business.albumlist.controller.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit T1;
                T1 = QzonePersonalAlbumViewController.this.T1((e.DialogData) obj);
                return T1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w1() {
        try {
            View findViewById = this.f407174e.findViewById(R.id.dsj);
            this.f42176f0 = (ImageView) this.f407174e.findViewById(R.id.dsr);
            if (J1() && this.C0 == null && g1() != null) {
                AlbumTimeLineView albumTimeLineView = new AlbumTimeLineView(this.f407174e, g1().getRootView(), g1(), this.f42183k0.longValue(), this.f42192s0);
                this.C0 = albumTimeLineView;
                albumTimeLineView.u(g1().Z0);
            }
            N2();
            findViewById.setOnClickListener(new r());
            y2(findViewById);
        } catch (Exception e16) {
            QZLog.e("[PhotoAlbum]QzonePersonalAlbumViewController", "initRightView ", e16);
        }
    }

    private void w2(boolean z16) {
        Fragment fragment = this.V.get(0);
        if (fragment instanceof AlbumListTabFragment) {
            ((AlbumListTabFragment) fragment).G0 = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x017e A[Catch: Exception -> 0x019d, TryCatch #0 {Exception -> 0x019d, blocks: (B:2:0x0000, B:4:0x002f, B:6:0x0033, B:8:0x0039, B:9:0x0060, B:10:0x0091, B:12:0x009e, B:15:0x00a9, B:16:0x0113, B:19:0x018e, B:24:0x017e, B:25:0x00e0, B:26:0x0079), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void x1() {
        View findViewById;
        TextView textView;
        try {
            findViewById = this.f407174e.findViewById(R.id.dsj);
            findViewById.setVisibility(0);
            this.f42176f0 = (ImageView) this.f407174e.findViewById(R.id.dsr);
            textView = (TextView) this.f407174e.findViewById(R.id.ivTitleBtnLeft);
            if (J1()) {
                if (this.C0 == null && g1() != null) {
                    AlbumTimeLineView albumTimeLineView = new AlbumTimeLineView(this.f407174e, g1().getRootView(), g1(), this.f42183k0.longValue(), this.f42192s0);
                    this.C0 = albumTimeLineView;
                    albumTimeLineView.u(g1().Z0);
                }
                this.f42176f0.getLayoutParams().width = com.qzone.util.ar.d(28.0f);
                ((RelativeLayout.LayoutParams) findViewById.getLayoutParams()).rightMargin = com.qzone.util.ar.d(4.0f);
            } else {
                this.f42176f0.getLayoutParams().width = com.qzone.util.ar.d(28.0f);
                ((RelativeLayout.LayoutParams) findViewById.getLayoutParams()).rightMargin = com.qzone.util.ar.d(4.0f);
            }
        } catch (Exception e16) {
            QZLog.e("[PhotoAlbum]QzonePersonalAlbumViewController", "initRightView ", e16);
        }
        if (!AlbumPersonalizeManager.L().P() && !AlbumPersonalizeManager.L().X()) {
            this.f42176f0.setImageResource(R.drawable.qzone_skin_album_tool_icon);
            textView.setTextColor(this.f407174e.getResources().getColor(R.color.black));
            textView.setBackgroundResource(R.drawable.hij);
            ((TextView) this.f407174e.findViewById(R.id.hdf)).setTextColor(this.f407174e.getResources().getColor(R.color.qzone_skin_album_main_text_color));
            AlbumPersonalizeManager.L().U((TextView) this.f407174e.findViewById(R.id.hda), this.f407174e.getResources());
            AlbumPersonalizeManager.L().U((TextView) this.f407174e.findViewById(R.id.hdb), this.f407174e.getResources());
            AlbumPersonalizeManager.L().U((TextView) this.f407174e.findViewById(R.id.hdc), this.f407174e.getResources());
            this.f42176f0.setMaxHeight((int) getResources().getDimension(R.dimen.f158719n9));
            this.f42176f0.setVisibility(0);
            this.f42176f0.setFocusable(true);
            if (J1()) {
                AccessibilityUtil.p(this.f42176f0, getResources().getString(R.string.gqo));
            }
            N2();
            findViewById.setOnClickListener(new e());
            y2(findViewById);
            o1(this.f42176f0);
            y1(this.f42176f0);
        }
        this.f42176f0.setImageResource(R.drawable.bhu);
        textView.setTextColor(this.f407174e.getResources().getColor(R.color.f158017al3));
        textView.setBackgroundResource(R.drawable.b5b);
        ((TextView) this.f407174e.findViewById(R.id.hdf)).setTextColor(this.f407174e.getResources().getColor(R.color.f158017al3));
        AlbumPersonalizeManager.L().U((TextView) this.f407174e.findViewById(R.id.hda), this.f407174e.getResources());
        AlbumPersonalizeManager.L().U((TextView) this.f407174e.findViewById(R.id.hdb), this.f407174e.getResources());
        AlbumPersonalizeManager.L().U((TextView) this.f407174e.findViewById(R.id.hdc), this.f407174e.getResources());
        this.f42176f0.setMaxHeight((int) getResources().getDimension(R.dimen.f158719n9));
        this.f42176f0.setVisibility(0);
        this.f42176f0.setFocusable(true);
        if (J1()) {
        }
        N2();
        findViewById.setOnClickListener(new e());
        y2(findViewById);
        o1(this.f42176f0);
        y1(this.f42176f0);
    }

    private void y1(final ImageView imageView) {
        if (dh.a.f393805d.h()) {
            QLog.w("QZ_QFS_[PhotoAlbum]QzonePersonalAlbumViewController", 1, "initShowPhotoRepairBubbleTip, isShowQcircleEntranceGuideBubble");
        } else if (com.qzone.reborn.repair.utils.a.f59293a.a()) {
            RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: com.qzone.album.business.albumlist.controller.g
                @Override // java.lang.Runnable
                public final void run() {
                    QzonePersonalAlbumViewController.this.N1(imageView);
                }
            }, 1000L);
        }
    }

    private void z1() {
        if (this.T == null) {
            this.T = (RadioGroup) F(R.id.f164287qz);
        }
        this.T.removeAllViews();
        for (int i3 = 0; i3 < J0.length; i3++) {
            RadioButton radioButton = new RadioButton(this.f407174e);
            radioButton.setId(i3);
            radioButton.setButtonDrawable((Drawable) null);
            radioButton.setText(J0[i3]);
            radioButton.setGravity(17);
            radioButton.setTextColor(Color.parseColor("#34394C"));
            radioButton.setTextSize(10.0f);
            radioButton.setPadding(0, x.c(this.f407174e, 30.0f), 0, 0);
            com.qzone.album.util.n.a(radioButton);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(0, -1);
            layoutParams.weight = 1.0f;
            radioButton.setLayoutParams(layoutParams);
            this.T.addView(radioButton);
        }
        C2();
        ((RadioButton) this.T.getChildAt(this.F)).performClick();
    }

    private void z2(Intent intent) {
        TextView textView = this.H;
        if (textView == null || !(textView instanceof TextView) || intent == null || intent.getExtras() == null) {
            return;
        }
        TextView textView2 = this.H;
        I(R.string.button_back);
        textView2.setText("");
    }

    protected void A2() {
        int notchHeight = SystemUtil.getNotchHeight(BaseApplication.getContext(), H());
        int i3 = 0;
        QZLog.d("[PhotoAlbum]QzonePersonalAlbumViewController", 2, "notchHeight:", Integer.valueOf(notchHeight));
        if (notchHeight != 0) {
            ViewGroup viewGroup = this.K;
            if (viewGroup != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewGroup.getLayoutParams();
                marginLayoutParams.topMargin = notchHeight;
                i3 = marginLayoutParams.height + notchHeight;
                this.K.setLayoutParams(marginLayoutParams);
            }
            ViewGroup viewGroup2 = this.M;
            if (viewGroup2 != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) viewGroup2.getLayoutParams();
                if (i3 == 0) {
                    i3 = this.f42198y0 + notchHeight;
                }
                marginLayoutParams2.height = i3;
                this.M.setLayoutParams(marginLayoutParams2);
            }
        }
    }

    boolean F1() {
        return ((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).getBooleanValue("QZONE_ALBUM_PHOTO_AI_ELIMINATE_ENTRANCE_IS_CLICKED", false);
    }

    @Override // i4.a
    public void J(s8.b bVar) {
        super.J(bVar);
        if ("WriteOperation".equals(bVar.a())) {
            int c16 = bVar.c();
            if (c16 == 8 || c16 == 11 || c16 == 34 || c16 == 45) {
                this.f42173d0++;
                O2();
                return;
            }
            return;
        }
        if ("QzoneAlbum".equals(bVar.a())) {
            int c17 = bVar.c();
            if (c17 != 4 && c17 != 5) {
                if (c17 != 1002) {
                    switch (c17) {
                        case 17:
                            break;
                        case 18:
                            Object b16 = bVar.b();
                            if (b16 instanceof int[]) {
                                Q2((int[]) b16);
                                return;
                            }
                            return;
                        case 19:
                            a1();
                            return;
                        default:
                            return;
                    }
                } else {
                    this.f42173d0++;
                    O2();
                    return;
                }
            }
            this.f42173d0++;
            O2();
            return;
        }
        if ("LocalPhotoCardView".equals(bVar.a())) {
            if (bVar.c() != 5) {
                return;
            }
            QZLog.e("[PhotoAlbum]QzonePersonalAlbumViewController", "[onEventUIThread] receive EVENT_UPDATE_GROUP -> receive EVENT_UPDATE_GROUP notification");
        } else if ("UnRead".equals(bVar.a()) && bVar.c() == 1) {
            QLog.d("[PhotoAlbum]QzonePersonalAlbumViewController", 1, "receive unread change event:" + this.f42184l0);
            if (this.f42186m0) {
                G2();
            }
        }
    }

    public final boolean K1() {
        ProgressBar progressBar = this.P;
        return progressBar != null && progressBar.getVisibility() == 0;
    }

    public void M2(int i3, int i16, int i17) {
        com.qzone.album.business.photolist.adapter.c Jh;
        PhotoCacheData photoCacheData;
        AlbumTimeLineView albumTimeLineView;
        Fragment fragment = this.V.get(this.G);
        if (fragment instanceof AlbumBaseTabFragment) {
            AlbumBaseTabFragment albumBaseTabFragment = (AlbumBaseTabFragment) fragment;
            if ((albumBaseTabFragment instanceof AlbumRecentTabFragment) && (Jh = albumBaseTabFragment.Jh()) != null && Jh.getCount() > 0) {
                if (i3 >= Jh.getCount()) {
                    i3 = Jh.getCount() - 1;
                }
                if (i3 < 0) {
                    i3 = 0;
                }
                if (Jh.getItem(i3) != null) {
                    QZonePersonalAlbumRecentAdapter.g gVar = (QZonePersonalAlbumRecentAdapter.g) Jh.getItem(i3);
                    if (gVar == null || (photoCacheData = gVar.f42627a) == null || (albumTimeLineView = this.C0) == null) {
                        return;
                    }
                    albumTimeLineView.s(photoCacheData.uploadtime);
                    return;
                }
                com.qzone.album.env.common.a.m().b("recentPhotoTimeLine", "syncTimeLineSelection getBaseAdapter().getItem(syncTime) == null || ((PhotoCacheData[])getBaseAdapter().getItem(syncTime))[0] == null and syncTime = ", Integer.valueOf(i3));
            }
        }
    }

    @Override // i4.a
    public void N(Activity activity) {
        SimpleEventBus.getInstance().registerReceiver(this);
        t4.a.N().h(G());
        com.qzone.proxy.feedcomponent.b.a("[PhotoAlbum]QzonePersonalAlbumViewController", "onShellActivityCreate");
        x2(h1(activity, R.layout.bho));
        com.qzone.album.base.Service.a.W().R0();
        n2();
        if (!Z1()) {
            AlbumPersonalizeManager.L().N();
        }
        if (!AlbumPersonalizeManager.L().Q()) {
            if (AlbumPersonalizeManager.L().R()) {
                AlbumPersonalizeManager.L().O();
            } else {
                AlbumPersonalizeManager.L().N();
            }
        }
        this.f42172c0 = new Handler();
        p1();
        E1();
        Z0();
        this.G = this.F;
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.album.business.albumlist.controller.a
            @Override // java.lang.Runnable
            public final void run() {
                QzonePersonalAlbumViewController.this.O1();
            }
        });
        this.f42182j0 = false;
        if (com.tencent.mobileqq.simpleui.b.c()) {
            this.K.setBackgroundColor(SimpleUIUtil.getSimpleUiBgColor());
            this.M.setBackgroundColor(SimpleUIUtil.getSimpleUiBgColor());
        } else {
            this.K.setBackgroundColor(getResources().getColor(R.color.qzone_skin_common_white2black_color));
            this.M.setBackgroundColor(getResources().getColor(R.color.qzone_skin_common_white2black_color));
        }
        this.L.setBackgroundColor(getResources().getColor(R.color.f158017al3));
    }

    public void N2() {
        if (J1() && (I1() || H1())) {
            this.f42176f0.setVisibility(8);
            if (this.C0 != null) {
                if (g1().Z0 != null && g1().Z0.size() > 0) {
                    this.C0.p(0);
                    return;
                }
                if (!P2()) {
                    this.f42176f0.setVisibility(0);
                }
                this.C0.p(8);
                return;
            }
            return;
        }
        if (G1()) {
            this.f42176f0.setVisibility(8);
        } else {
            this.f42176f0.setVisibility(0);
        }
        AlbumTimeLineView albumTimeLineView = this.C0;
        if (albumTimeLineView != null) {
            albumTimeLineView.p(8);
        }
    }

    @Override // i4.a
    public void O(Activity activity) {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        com.qzone.album.base.Service.a.W().S0();
        r2();
        Handler handler = this.f42172c0;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (!Z1()) {
            AlbumPersonalizeManager.L().N();
        }
        QzoneGuideBubbleHelper.g().f();
    }

    protected void O2() {
        if (this.V.get(this.G) instanceof com.qzone.album.business.albumlist.fragment.d) {
            ((com.qzone.album.business.albumlist.fragment.d) this.V.get(this.G)).update();
        }
    }

    @Override // i4.a
    public void P(Activity activity) {
        super.P(activity);
    }

    @Override // i4.a
    public void Q(Activity activity, Bundle bundle) {
        super.Q(activity, bundle);
        if (bundle != null) {
            int i3 = bundle.getInt(I0, this.F);
            RadioGroup radioGroup = this.T;
            if (radioGroup == null || radioGroup.getChildAt(i3) == null || i3 == this.G) {
                return;
            }
            ((RadioButton) this.T.getChildAt(i3)).performClick();
        }
    }

    protected void Q2(int[] iArr) {
        com.qzone.album.ui.widget.f fVar = this.f42181i0;
        if (fVar != null) {
            fVar.b(iArr, this.G);
        }
    }

    @Override // i4.a
    public void S(Activity activity) {
        super.S(activity);
        r1();
        if (com.tencent.mobileqq.simpleui.b.c()) {
            this.f42171b0 = com.tencent.mobileqq.simpleui.b.b(this.f42171b0, activity, false, SimpleUIUtil.useDarkResource());
        } else if (ImmersiveUtils.isSupporImmersive() == 1) {
            activity.getWindow().addFlags(67108864);
            ImmersiveUtils.clearCoverForStatus(activity.getWindow(), true);
            if (this.f42171b0 == null) {
                SystemBarCompact systemBarCompact = new SystemBarCompact(activity, true, getResources().getColor(R.color.qzone_skin_common_white2black_color));
                this.f42171b0 = systemBarCompact;
                systemBarCompact.init();
            }
            if (ImmersiveUtils.couldSetStatusTextColor()) {
                ImmersiveUtils.setStatusTextColor(!QQTheme.isNowThemeIsNightForQzone(), activity.getWindow());
            } else {
                this.f42171b0.setStatusBarColor(SimpleUIUtil.SIMPLE_UI_STATUS_BAR_COLOR_PRE_M);
            }
        }
        Y0();
    }

    @Override // i4.a
    public void T(Activity activity, Bundle bundle) {
        super.T(activity, bundle);
        if (bundle != null) {
            bundle.putInt(I0, this.G);
        }
    }

    public void Y0() {
        if (AlbumPersonalizeManager.L().Q()) {
            s5.a.i(this.U);
            s5.a.h(F(R.id.f164260pa));
            s5.a.h(F(R.id.yi_));
            B2();
        }
    }

    protected void Z0() {
        t4.a.N().a(this.f407174e);
    }

    protected boolean Z1() {
        return this.f42183k0.longValue() == com.qzone.album.env.common.a.m().s();
    }

    public boolean b2() {
        this.f407174e.finish();
        return false;
    }

    public AlbumTimeLineView d1() {
        return this.C0;
    }

    public long e1() {
        return this.f42173d0;
    }

    public String f1() {
        Intent G = G();
        if (G != null) {
            String stringExtra = G.getStringExtra("refer");
            if (!TextUtils.isEmpty(stringExtra)) {
                if (stringExtra.equals("getActiveFeeds")) {
                    return QzoneVideoBeaconReport.EVENT_ALBUM_BANNER;
                }
                if (stringExtra.equals(QZoneHelper.QZoneAppConstants.REFER_QQ_SETTING)) {
                    return QzoneVideoBeaconReport.EVENT_ALBUM_LIST;
                }
                return QzoneVideoBeaconReport.EVENT_ALBUM_OTHER;
            }
        }
        return "";
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QZoneAlbumCategoryDeletePhotoEvent.class);
        arrayList.add(QZoneAlbumSwitchTabEvent.class);
        arrayList.add(QZonePhotoRepairTaskStateChangeEvent.class);
        return arrayList;
    }

    protected void h2() {
        String str;
        FragmentActivity fragmentActivity = this.f407174e;
        if (fragmentActivity == null || QZonePermission.requestStoragePermission(fragmentActivity, QQPermissionConstants.Business.SCENE.QQ_QZONE_SHUOSHUO_ALBUM_OPEN_MEDIA)) {
            w2(false);
            t4.a.N().e(this.f407174e);
            String f16 = f1();
            if (!TextUtils.isEmpty(f16)) {
                if (f16.equals(QzoneVideoBeaconReport.EVENT_ALBUM_BANNER)) {
                    str = QzoneVideoBeaconReport.EVENT_ALBUM_BANNER_ADD_ALBUM;
                } else if (f16.equals(QzoneVideoBeaconReport.EVENT_ALBUM_LIST)) {
                    str = QzoneVideoBeaconReport.EVENT_ALBUM_LIST_ADD_ALBUM;
                } else {
                    str = QzoneVideoBeaconReport.EVENT_ALBUM_OTHER_ADD_ALBUM;
                }
            } else {
                str = "";
            }
            QzoneVideoBeaconReport.reportAlbumEvent(LoginData.getInstance().getUinString(), str);
            com.qzone.album.env.common.a.m().P(Integer.valueOf("326").intValue(), Integer.valueOf("1").intValue(), "19", true, String.valueOf(this.G));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void j2(boolean z16) {
        try {
            Fragment fragment = this.V.get(this.G);
            if (fragment instanceof com.qzone.album.business.albumlist.fragment.d) {
                ((com.qzone.album.business.albumlist.fragment.d) fragment).Y4(fragment, z16, this.f42192s0);
            }
        } catch (Exception e16) {
            QZLog.e("[PhotoAlbum]QzonePersonalAlbumViewController", "onFragmentSelected exception.", e16);
        }
    }

    protected void k2() {
        FragmentActivity fragmentActivity = this.f407174e;
        if (fragmentActivity == null || QZonePermission.requestStoragePermission(fragmentActivity, QQPermissionConstants.Business.SCENE.QQ_QZONE_SHUOSHUO_ALBUM_OPEN_MEDIA)) {
            t4.a.N().g(this.f407174e);
            com.qzone.album.env.common.a.m().P(Integer.valueOf("326").intValue(), Integer.valueOf("1").intValue(), "20", true, new String[0]);
        }
    }

    public void m2(boolean z16) {
        AlbumPersonalizeManager.L().V(this.f407174e, this.G, F(R.id.f164260pa), F(R.id.dwl), F(R.id.dyp), F(R.id.dyn), F(R.id.dvk), (RadioButton) this.T.getChildAt(0), (RadioButton) this.T.getChildAt(1), (RadioButton) this.T.getChildAt(2), (RadioButton) this.T.getChildAt(3));
        if (this.V.get(this.G) instanceof com.qzone.album.business.albumlist.fragment.d) {
            ((com.qzone.album.business.albumlist.fragment.d) this.V.get(this.G)).onWindowFocusChanged();
        }
    }

    public void n1() {
        ImageView imageView = this.f42176f0;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        AlbumTimeLineView albumTimeLineView = this.C0;
        if (albumTimeLineView != null) {
            albumTimeLineView.p(8);
        }
    }

    @Override // com.qzone.album.business.photolist.adapter.v
    public void onItemClick(View view, int i3) {
        m1();
        if (i3 == 0) {
            i2();
            return;
        }
        if (i3 == 1) {
            o2();
            return;
        }
        if (i3 != 2) {
            if (i3 == 3) {
                i1(this.E0.i0(i3));
                eo.c.f396879a.b();
            }
            ab.a i06 = this.E0.i0(i3);
            if (i06 == null || TextUtils.isEmpty(i06.f42672e)) {
                return;
            }
            yo.d.b(H(), new yo.g(i06.f42672e));
            return;
        }
        c2(view);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QZoneAlbumCategoryDeletePhotoEvent) {
            this.f42173d0++;
            O2();
            return;
        }
        if (simpleBaseEvent instanceof QZoneAlbumSwitchTabEvent) {
            L2((QZoneAlbumSwitchTabEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QZonePhotoRepairTaskStateChangeEvent) {
            QZonePhotoRepairTaskStateChangeEvent qZonePhotoRepairTaskStateChangeEvent = (QZonePhotoRepairTaskStateChangeEvent) simpleBaseEvent;
            RFWLog.d("[PhotoAlbum]QzonePersonalAlbumViewController", RFWLog.USR, "onReceiveEvent, QZonePhotoRepairTaskStateChangeEvent: " + qZonePhotoRepairTaskStateChangeEvent.getHasRepairingTask());
            if (qZonePhotoRepairTaskStateChangeEvent.getHasRepairingTask()) {
                I2();
            } else {
                J2();
            }
        }
    }

    protected void q1() {
        this.f42196w0 = getResources().getDimensionPixelSize(R.dimen.azx);
        this.f42197x0 = getResources().getDimensionPixelSize(R.dimen.azw);
        this.f42198y0 = getResources().getDimensionPixelSize(R.dimen.title_bar_height);
        this.f42199z0 = getResources().getDimensionPixelSize(R.dimen.f159598b01);
    }

    protected void r2() {
        t4.a.N().d(this.f407174e);
    }

    void v2() {
        ((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).saveBoolean("QZONE_ALBUM_PHOTO_AI_ELIMINATE_ENTRANCE_IS_CLICKED", true);
    }

    public void x2(View view) {
        View inflate = LayoutInflater.from(this.f407174e).inflate(R.layout.bjq, (ViewGroup) null);
        this.L = (ViewGroup) inflate.findViewById(R.id.jqh);
        this.K = (ViewGroup) inflate.findViewById(R.id.f166673ha1);
        this.M = (ViewGroup) inflate.findViewById(R.id.f166672ha0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(3, R.id.f166673ha1);
        this.L.addView(view, layoutParams);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            ((RelativeLayout.LayoutParams) this.K.getLayoutParams()).setMargins(0, com.qzone.util.ar.d(25.0f), 0, 0);
        }
        try {
            if (ImmersiveUtils.isSupporImmersive() == 1) {
                this.f42180i = new View(BaseApplication.getContext());
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.qzone.util.ar.l(), ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()));
                layoutParams2.addRule(10);
                this.f42180i.setLayoutParams(layoutParams2);
                this.f42180i.setBackgroundColor(getResources().getColor(R.color.f156964ga));
                this.L.addView(this.f42180i);
            }
        } catch (Exception e16) {
            QZLog.e("[PhotoAlbum]QzonePersonalAlbumViewController", "set statusBar mask exception.", e16);
        }
        this.f407174e.setContentView(this.L);
        this.f407174e.getWindow().setBackgroundDrawable(null);
    }

    /* loaded from: classes39.dex */
    class m implements com.qzone.album.business.albumlist.fragment.e {
        m() {
        }

        @Override // com.qzone.album.business.albumlist.fragment.e
        public void b(boolean z16) {
            if (QzonePersonalAlbumViewController.this.f42189p0 != null) {
                QzonePersonalAlbumViewController.this.f42189p0.setVisibility(z16 ? 0 : 8);
            }
        }

        @Override // com.qzone.album.business.albumlist.fragment.e
        public void c(boolean z16) {
            if (QzonePersonalAlbumViewController.this.f42188o0 != null) {
                QzonePersonalAlbumViewController.this.f42188o0.setVisibility((!z16 || QzonePersonalAlbumViewController.this.P2()) ? 8 : 0);
            }
        }

        @Override // com.qzone.album.business.albumlist.fragment.e
        public void d(boolean z16) {
            if (QzonePersonalAlbumViewController.this.f42181i0 != null) {
                QzonePersonalAlbumViewController.this.f42181i0.c(z16);
            }
        }

        @Override // com.qzone.album.business.albumlist.fragment.e
        public void a(boolean z16) {
            if (z16) {
                QzonePersonalAlbumViewController.this.N2();
            } else {
                QzonePersonalAlbumViewController.this.n1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D2(a.C10411a c10411a, View view) {
        QZLog.d("[PhotoAlbum]QzonePersonalAlbumViewController", 1, "initDragMgr... showAnnouncement:", "");
        View F = F(R.id.dgv);
        TextView textView = (TextView) F(R.id.eay);
        F.setBackgroundDrawable(URLDrawable.getDrawable(c10411a.f404276c));
        textView.setText(c10411a.f404277d);
        view.setVisibility(0);
        view.setOnClickListener(new o(c10411a));
        h4.a.c().g(101, c10411a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H2(View view) {
        QZLog.d("[PhotoAlbum]QzonePersonalAlbumViewController", 1, "initDragMgr... showQzoneEntrace:", Boolean.valueOf(this.f42184l0));
        if (this.f42184l0) {
            p2();
            v1();
            view.setVisibility(0);
            view.setOnClickListener(new n());
            return;
        }
        view.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O1() {
        j2(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void P1(boolean z16, int i3, String str) {
        if (z16) {
            QZonePhotoDegradeEvent qZonePhotoDegradeEvent = new QZonePhotoDegradeEvent();
            qZonePhotoDegradeEvent.setForceClose(true);
            SimpleEventBus.getInstance().dispatchEvent(qZonePhotoDegradeEvent);
        }
    }

    public void B1(View view) {
        if (view != null) {
            this.f42181i0 = new com.qzone.album.ui.widget.f(view, this.f407174e);
        }
    }

    private void E1() {
        this.T = (RadioGroup) F(R.id.f164287qz);
        this.U = (ViewPager) F(R.id.f164261pc);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.f407174e.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.W = displayMetrics.widthPixels / J0.length;
        s sVar = new s(this.f407174e.getSupportFragmentManager());
        this.Y = sVar;
        this.U.setAdapter(sVar);
        this.U.setOffscreenPageLimit(3);
        A1();
        z1();
        K2();
        View F = F(R.id.der);
        this.f42188o0 = F;
        AccessibilityUtil.p(F, com.qzone.util.l.a(R.string.f2202868p));
        if (this.f42188o0 != null) {
            if (P2()) {
                this.f42188o0.setVisibility(8);
            } else {
                this.f42188o0.setVisibility(0);
            }
            this.f42188o0.setOnClickListener(this.B0);
        }
        t2();
        Y0();
    }

    private View h1(Activity activity, int i3) {
        if (activity != null) {
            return LayoutInflater.from(activity).inflate(i3, (ViewGroup) null);
        }
        QZLog.e("[PhotoAlbum]QzonePersonalAlbumViewController", "initRootView activity null");
        return null;
    }

    private void u1() {
        ((ViewStub) F(R.id.f0h)).inflate();
        this.D0 = (RecyclerView) F(R.id.f0g);
        ab abVar = new ab(this.f407174e);
        this.E0 = abVar;
        abVar.m0(this);
        this.F0 = new ArrayList();
        int color = getResources().getColor(R.color.a8m);
        if (QQTheme.isNowThemeIsNightForQzone()) {
            color = getResources().getColor(R.color.a8h);
        }
        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumRecycleBin", "\u76f8\u518c\u56de\u6536\u7ad9");
        QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumDynamicPhoto", "\u505a\u540c\u6b3e");
        String config2 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumPersonal", QzoneConfig.DefaultValue.USERHOME_BAR_PERSONALIZE_NAME);
        String config3 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumPhotoRepair", "AI\u4fee\u590d");
        String config4 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumAIEliminate", "AI\u6d88\u9664");
        this.F0.add(new ab.a(config2, color, getResources().getDrawable(R.drawable.g9z)));
        this.F0.add(new ab.a(config, color, getResources().getDrawable(R.drawable.g9z)));
        this.F0.add(new ab.a(config3, color, getResources().getDrawable(R.drawable.g9z)));
        this.F0.add(new ab.a(config4, color, getResources().getDrawable(R.drawable.g9z)));
        List<ab.a> list = this.f42170a0;
        if (list != null) {
            this.F0.addAll(list);
        }
        this.E0.l0(this.F0);
        this.D0.setAdapter(this.E0);
        t1();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(H(), 3);
        gridLayoutManager.setAutoMeasureEnabled(true);
        this.D0.setLayoutManager(gridLayoutManager);
        this.f42174e0 = (RelativeLayout) F(R.id.a4f);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f407174e, R.anim.f154790co);
        this.f42177g0 = loadAnimation;
        loadAnimation.setAnimationListener(this.f42187n0);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.f407174e, R.anim.f154776cg);
        this.f42179h0 = loadAnimation2;
        loadAnimation2.setAnimationListener(this.f42187n0);
        V1();
        F(R.id.i6r).setOnTouchListener(new k());
        q2();
    }

    private void v1() {
        this.Q = F(R.id.dgv);
        this.S = (TextView) F(R.id.eay);
        this.Q.setBackgroundResource(R.drawable.g5i);
        this.f42186m0 = true;
        if (QZoneFeedAlertService.getInstance().getSingleUnReadItem(2) != null) {
            G2();
        } else {
            QZoneFeedAlertService.getInstance().ensureLoadUnread();
        }
    }

    protected View e2() {
        this.I = (TextView) F(R.id.ivTitleName);
        if (!AlbumPersonalizeManager.L().P() && !AlbumPersonalizeManager.L().X()) {
            ((TextView) this.f407174e.findViewById(R.id.hdf)).setTextColor(this.f407174e.getResources().getColor(R.color.qzone_skin_album_main_text_color));
        } else {
            ((TextView) this.f407174e.findViewById(R.id.hdf)).setTextColor(this.f407174e.getResources().getColor(R.color.f158017al3));
        }
        AlbumPersonalizeManager.L().U((TextView) this.f407174e.findViewById(R.id.hda), this.f407174e.getResources());
        AlbumPersonalizeManager.L().U((TextView) this.f407174e.findViewById(R.id.hdb), this.f407174e.getResources());
        AlbumPersonalizeManager.L().U((TextView) this.f407174e.findViewById(R.id.hdc), this.f407174e.getResources());
        return this.I;
    }

    protected View f2() {
        TextView textView = (TextView) F(R.id.ivTitleBtnLeft);
        this.H = textView;
        textView.setOnClickListener(this.A0);
        y2(this.H);
        if (!AlbumPersonalizeManager.L().P() && !AlbumPersonalizeManager.L().X()) {
            this.H.setTextColor(this.f407174e.getResources().getColor(R.color.black));
            this.H.setBackgroundResource(R.drawable.hij);
        } else {
            this.H.setTextColor(this.f407174e.getResources().getColor(R.color.f158017al3));
            this.H.setBackgroundResource(R.drawable.b5b);
        }
        AccessibilityUtil.p(this.H, com.qzone.util.l.a(R.string.f2201668d));
        return this.H;
    }

    protected View g2() {
        TextView textView = (TextView) F(R.id.ivTitleBtnRightText);
        this.J = textView;
        y2(textView);
        return this.J;
    }

    protected void d2(View view, View view2) {
        if (view2 != null) {
            view2.setVisibility(8);
        }
        B1(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class b implements RadioGroup.OnCheckedChangeListener {
        b() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i3) {
            String str;
            EventCollector.getInstance().onRadioGroupCheckedBefore(radioGroup, i3);
            if (QzonePersonalAlbumViewController.this.T != null && QzonePersonalAlbumViewController.this.T.getChildAt(i3) != null && QzonePersonalAlbumViewController.this.G != i3) {
                QzonePersonalAlbumViewController qzonePersonalAlbumViewController = QzonePersonalAlbumViewController.this;
                TranslateAnimation translateAnimation = new TranslateAnimation(qzonePersonalAlbumViewController.Z, qzonePersonalAlbumViewController.W * i3, 0.0f, 0.0f);
                translateAnimation.setInterpolator(new LinearInterpolator());
                translateAnimation.setDuration(100L);
                translateAnimation.setFillAfter(true);
                QzonePersonalAlbumViewController.this.U.setCurrentItem(i3);
                QzonePersonalAlbumViewController qzonePersonalAlbumViewController2 = QzonePersonalAlbumViewController.this;
                qzonePersonalAlbumViewController2.Z = qzonePersonalAlbumViewController2.W * i3;
                QzonePersonalAlbumViewController.this.j2(false);
                QzonePersonalAlbumViewController qzonePersonalAlbumViewController3 = QzonePersonalAlbumViewController.this;
                qzonePersonalAlbumViewController3.G = i3;
                if (qzonePersonalAlbumViewController3.f42188o0 != null) {
                    if (QzonePersonalAlbumViewController.this.P2()) {
                        QzonePersonalAlbumViewController.this.f42188o0.setVisibility(8);
                    } else {
                        QzonePersonalAlbumViewController.this.f42188o0.setVisibility(0);
                    }
                }
                if (QzonePersonalAlbumViewController.this.f42181i0 != null) {
                    QzonePersonalAlbumViewController qzonePersonalAlbumViewController4 = QzonePersonalAlbumViewController.this;
                    int i16 = qzonePersonalAlbumViewController4.G;
                    if (i16 == 0) {
                        str = qzonePersonalAlbumViewController4.f42185m;
                        com.qzone.album.env.common.a.m().d("[PhotoAlbum]AlbumPerformance", "TAB_ALBUM_LIST onCheckedChanged start");
                        u4.c.a().r("326", "1", "35");
                    } else if (i16 == 1) {
                        str = qzonePersonalAlbumViewController4.C;
                        com.qzone.album.env.common.a.m().d("[PhotoAlbum]AlbumPerformance", "TAB_ALBUM_RECENT onCheckedChanged start");
                        u4.c.a().r("326", "2", "23");
                    } else if (i16 == 2) {
                        str = qzonePersonalAlbumViewController4.D;
                        com.qzone.album.env.common.a.m().d("[PhotoAlbum]AlbumPerformance", "TAB_ALBUM_VIDEO onCheckedChanged start");
                        u4.c.a().r("326", "4", "1");
                    } else if (i16 == 3) {
                        str = qzonePersonalAlbumViewController4.E;
                        com.qzone.album.env.common.a.m().d("[PhotoAlbum]AlbumPerformance", "TAG_ALBUM_LOCAL_PHOTO onCheckedChanged start");
                        if (QzonePersonalAlbumViewController.this.f42188o0 != null) {
                            QzonePersonalAlbumViewController.this.f42188o0.setVisibility(8);
                        }
                    } else {
                        str = "";
                    }
                    AlbumPersonalizeManager L = AlbumPersonalizeManager.L();
                    FragmentActivity fragmentActivity = ((i4.a) QzonePersonalAlbumViewController.this).f407174e;
                    QzonePersonalAlbumViewController qzonePersonalAlbumViewController5 = QzonePersonalAlbumViewController.this;
                    L.V(fragmentActivity, qzonePersonalAlbumViewController5.G, qzonePersonalAlbumViewController5.F(R.id.f164260pa), QzonePersonalAlbumViewController.this.F(R.id.dwl), QzonePersonalAlbumViewController.this.F(R.id.dyp), QzonePersonalAlbumViewController.this.F(R.id.dyn), QzonePersonalAlbumViewController.this.F(R.id.dvk), (RadioButton) QzonePersonalAlbumViewController.this.T.getChildAt(0), (RadioButton) QzonePersonalAlbumViewController.this.T.getChildAt(1), (RadioButton) QzonePersonalAlbumViewController.this.T.getChildAt(2), (RadioButton) QzonePersonalAlbumViewController.this.T.getChildAt(3));
                    QzonePersonalAlbumViewController.this.f42181i0.e(QzonePersonalAlbumViewController.this.G, str);
                    if (QzonePersonalAlbumViewController.this.Z1()) {
                        QzonePersonalAlbumViewController.this.x1();
                    } else {
                        QzonePersonalAlbumViewController.this.w1();
                    }
                }
                if (QzonePersonalAlbumViewController.this.W1()) {
                    QzonePersonalAlbumViewController.this.O2();
                }
                QzonePersonalAlbumViewController.this.j2(true);
            }
            EventCollector.getInstance().onRadioGroupChecked(radioGroup, i3);
        }
    }

    public static void y2(View view) {
        if (view == null) {
            return;
        }
        view.setLayerType(0, null);
    }

    protected void i2() {
        LpReportInfo_pf00064.allReport(326, 1, 39);
        yo.d.d("https://h5.qzone.qq.com/albumSkinStore/index", H(), null);
    }

    public Pair<Boolean, Boolean> l2(Activity activity, int i3, KeyEvent keyEvent) {
        boolean z16 = true;
        boolean z17 = false;
        if (i3 == 4 && keyEvent.getRepeatCount() == 0 && t4.a.N().E(activity) != null && k1()) {
            z17 = true;
            z16 = false;
        }
        return new Pair<>(Boolean.valueOf(z16), Boolean.valueOf(z17));
    }

    @Override // i4.a
    public void R(Activity activity, int i3, int i16, Intent intent) {
        if (i16 == -1) {
            if (i3 != 0 && i3 != 1 && i3 != 2) {
                if (i3 == 3 && intent.getBooleanExtra("isNeedFinishItself", false)) {
                    this.f407174e.finish();
                    return;
                }
                return;
            }
            int i17 = this.G;
            if (i17 == 0) {
                if (this.V.get(i17) instanceof com.qzone.album.business.albumlist.fragment.d) {
                    ((com.qzone.album.business.albumlist.fragment.d) this.V.get(this.G)).update();
                    return;
                }
                return;
            }
            this.f42173d0++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements ViewPager.OnPageChangeListener {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            if (QzonePersonalAlbumViewController.this.T == null || QzonePersonalAlbumViewController.this.T.getChildCount() <= i3) {
                return;
            }
            ((RadioButton) QzonePersonalAlbumViewController.this.T.getChildAt(i3)).performClick();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
        }
    }

    protected void K2() {
    }
}
