package com.qzone.common.activities;

import NS_MOBILE_FEEDS.s_droplist_option;
import NS_MOBILE_OPERATION.PicInfo;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.provider.Settings;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.business.qboss.QbossAdvDesc;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.QZoneFeedOperateLogic;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.common.friend.business.model.Friend;
import com.qzone.component.PokeLikeWizard;
import com.qzone.component.StickerBubbleAnimationView;
import com.qzone.detail.business.service.QZoneDetailService;
import com.qzone.feed.utils.QZoneFeedUtil;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.PolymorphicPraiseData;
import com.qzone.proxy.feedcomponent.model.PolymorphicPraiseEmotionData;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.vipcomponent.VipComponentProxy;
import com.qzone.publish.ui.model.PersonalFontData;
import com.qzone.publish.ui.model.QzoneBarrageEffectData;
import com.qzone.publish.ui.model.QzoneSuperPersonalFontData;
import com.qzone.util.ToastUtil;
import com.qzone.util.ao;
import com.qzone.util.ap;
import com.qzone.util.ar;
import com.qzone.widget.EditPositionBag;
import com.qzone.widget.EmoEditPanel;
import com.qzone.widget.FrameAnimView;
import com.qzone.widget.util.ZipLoadBitmapGenerator;
import com.tencent.avcore.jni.codec.HWColorFormat;
import com.tencent.biz.richframework.compat.RFWThemeUtil;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageUrl;
import com.tencent.component.network.utils.thread.PriorityThreadPool;
import com.tencent.component.network.utils.thread.ThreadPool;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qzonehub.api.webview.IQZoneFeedActionJsPlugin;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import common.config.service.QZoneConfigHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.Lbs.QzoneLbsConstant;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.RDMEtraMsgCollector;
import cooperation.qzone.api.QZoneContant;
import cooperation.qzone.media.QZoneMediaBusiness;
import cooperation.qzone.report.lp.LpReportInfo_dc00321;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.QZonePermission;
import cooperation.qzone.webviewplugin.ugcsetting.UgcSettingUtil;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppActivity;

/* loaded from: classes39.dex */
public class FeedActionPanelActivity extends AppActivity implements EmoEditPanel.ai, EmoEditPanel.ah, IObserver.main, Handler.Callback, ap.a, com.tencent.mobileqq.gesturelock.b {
    protected static final String H1 = "FeedActionPanelActivity";
    public static int I1 = -1;
    public static int J1 = 0;
    public static int K1 = 1;
    public static int L1 = -1;
    public static int M1 = 1;
    static boolean N1 = false;
    private static final int O1 = ar.e(48.0f);
    private static int P1;
    public static int Q1;
    public static final Pattern R1;
    private int A0;
    private boolean D0;
    private QZoneFeedOperateLogic E0;
    private int E1;
    private boolean F0;
    private boolean G0;
    private String H0;
    private String I0;
    protected EmoEditPanel M0;
    protected EmoEditPanel.ak N0;
    private SystemBarCompact O0;

    /* renamed from: a0, reason: collision with root package name */
    private Parcelable f44900a0;

    /* renamed from: b0, reason: collision with root package name */
    private Serializable f44902b0;

    /* renamed from: c0, reason: collision with root package name */
    private Bundle f44904c0;

    /* renamed from: c1, reason: collision with root package name */
    private String f44905c1;

    /* renamed from: d0, reason: collision with root package name */
    private int f44906d0;

    /* renamed from: d1, reason: collision with root package name */
    private int f44907d1;

    /* renamed from: e0, reason: collision with root package name */
    private String f44908e0;

    /* renamed from: f0, reason: collision with root package name */
    private String f44910f0;

    /* renamed from: f1, reason: collision with root package name */
    private FrameLayout f44911f1;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f44912g0;

    /* renamed from: g1, reason: collision with root package name */
    private View f44913g1;

    /* renamed from: h0, reason: collision with root package name */
    private String f44914h0;

    /* renamed from: h1, reason: collision with root package name */
    private ViewGroup f44915h1;

    /* renamed from: i0, reason: collision with root package name */
    private String f44916i0;

    /* renamed from: i1, reason: collision with root package name */
    private RecyclerView f44917i1;

    /* renamed from: j0, reason: collision with root package name */
    private String f44918j0;

    /* renamed from: j1, reason: collision with root package name */
    private m f44919j1;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f44920k0;

    /* renamed from: k1, reason: collision with root package name */
    private StickerBubbleAnimationView f44921k1;

    /* renamed from: l1, reason: collision with root package name */
    private boolean f44923l1;

    /* renamed from: m1, reason: collision with root package name */
    private ViewTreeObserver.OnGlobalLayoutListener f44925m1;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f44926n0;

    /* renamed from: n1, reason: collision with root package name */
    private int f44927n1;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f44928o0;

    /* renamed from: o1, reason: collision with root package name */
    private boolean f44929o1;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f44930p0;

    /* renamed from: p1, reason: collision with root package name */
    private boolean f44931p1;

    /* renamed from: q1, reason: collision with root package name */
    private Map<String, String> f44933q1;

    /* renamed from: r1, reason: collision with root package name */
    private boolean f44935r1;

    /* renamed from: s0, reason: collision with root package name */
    private Handler f44936s0;

    /* renamed from: s1, reason: collision with root package name */
    private int f44937s1;

    /* renamed from: t0, reason: collision with root package name */
    private Bundle f44938t0;

    /* renamed from: t1, reason: collision with root package name */
    private int f44939t1;

    /* renamed from: u0, reason: collision with root package name */
    BusinessFeedData f44940u0;

    /* renamed from: v0, reason: collision with root package name */
    BusinessFeedData f44942v0;

    /* renamed from: w0, reason: collision with root package name */
    private BusinessFeedData f44944w0;

    /* renamed from: x0, reason: collision with root package name */
    private boolean f44946x0;

    /* renamed from: y1, reason: collision with root package name */
    public String f44949y1;

    /* renamed from: z1, reason: collision with root package name */
    public String f44951z1;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f44922l0 = false;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f44924m0 = true;

    /* renamed from: q0, reason: collision with root package name */
    private int f44932q0 = -1;

    /* renamed from: r0, reason: collision with root package name */
    private int f44934r0 = -1;

    /* renamed from: y0, reason: collision with root package name */
    private int f44948y0 = 0;

    /* renamed from: z0, reason: collision with root package name */
    private int f44950z0 = 0;
    private ViewGroup B0 = null;
    private ViewTreeObserver.OnGlobalLayoutListener C0 = null;
    private int J0 = -1;
    private int K0 = I1;
    private int L0 = L1;
    protected int P0 = 1;
    private boolean Q0 = false;
    private boolean R0 = true;
    private boolean S0 = false;
    private int T0 = 0;
    private boolean U0 = false;
    private boolean V0 = false;
    private int W0 = 1;
    private int X0 = 1;
    private int Y0 = 1;
    private int Z0 = 0;

    /* renamed from: a1, reason: collision with root package name */
    private boolean f44901a1 = false;

    /* renamed from: b1, reason: collision with root package name */
    private boolean f44903b1 = false;

    /* renamed from: e1, reason: collision with root package name */
    private boolean f44909e1 = false;

    /* renamed from: u1, reason: collision with root package name */
    BroadcastReceiver f44941u1 = new g();

    /* renamed from: v1, reason: collision with root package name */
    public int f44943v1 = 1;

    /* renamed from: w1, reason: collision with root package name */
    public ArrayList<String> f44945w1 = null;

    /* renamed from: x1, reason: collision with root package name */
    private String f44947x1 = UgcSettingUtil.getPrivacyDescriptionForShuoShuo(1);
    private final xk.d A1 = new xk.d(new c());
    private boolean B1 = false;
    boolean C1 = true;
    private boolean D1 = false;
    boolean F1 = true;
    private Handler G1 = new e();

    /* loaded from: classes39.dex */
    class a extends QQPermission.BasePermissionsListener {
        a() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            if (FeedActionPanelActivity.this.M0 != null) {
                com.qzone.common.business.service.b f16 = com.qzone.common.business.service.b.f();
                FeedActionPanelActivity feedActionPanelActivity = FeedActionPanelActivity.this;
                f16.o(feedActionPanelActivity, feedActionPanelActivity.M0.E0(), 3, false, 1, QZoneMediaBusiness.QZONE_COMMENT_ADD_PIC);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
        }
    }

    /* loaded from: classes39.dex */
    class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            FeedActionPanelActivity.this.B3();
        }
    }

    /* loaded from: classes39.dex */
    class e extends Handler {
        e() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3;
            int i16 = message.what;
            if (i16 == 1) {
                FeedActionPanelActivity.this.G1.removeMessages(1);
                if (!FeedActionPanelActivity.this.b4() || (i3 = FeedActionPanelActivity.this.E1) <= 0) {
                    return;
                }
                FeedActionPanelActivity.this.x3();
                FeedActionPanelActivity.this.G1.sendEmptyMessageDelayed(3, 1000L);
                QZLog.d("ZQ", 2, "ky show panel bottom : " + i3);
                return;
            }
            if (i16 == 2) {
                if (FeedActionPanelActivity.this.G1.hasMessages(1)) {
                    FeedActionPanelActivity.this.G1.removeMessages(1);
                }
                if (FeedActionPanelActivity.this.G1.hasMessages(3)) {
                    FeedActionPanelActivity.this.G1.removeMessages(3);
                }
                FeedActionPanelActivity.this.n4();
                QZLog.d("ZQ", 2, "Ky hide");
                return;
            }
            if (i16 != 3) {
                return;
            }
            if (FeedActionPanelActivity.this.G1.hasMessages(3)) {
                FeedActionPanelActivity.this.G1.removeMessages(3);
            }
            FeedActionPanelActivity feedActionPanelActivity = FeedActionPanelActivity.this;
            if (feedActionPanelActivity.M0 == null || !feedActionPanelActivity.b4()) {
                return;
            }
            FeedActionPanelActivity feedActionPanelActivity2 = FeedActionPanelActivity.this;
            feedActionPanelActivity2.C3(feedActionPanelActivity2.M0.J0());
            QZLog.d("ZQ", 2, "checkQuickCommentEmotion called");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class f implements ViewTreeObserver.OnGlobalLayoutListener {
        f() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i3;
            Rect rect = new Rect();
            FeedActionPanelActivity.this.B0.getWindowVisibleDisplayFrame(rect);
            int height = FeedActionPanelActivity.this.B0.getHeight();
            int height2 = FeedActionPanelActivity.this.B0.getRootView().getHeight();
            FeedActionPanelActivity.this.f44950z0 = height2 - rect.bottom;
            FeedActionPanelActivity feedActionPanelActivity = FeedActionPanelActivity.this;
            feedActionPanelActivity.f44946x0 = FeedActionPanelActivity.i4(feedActionPanelActivity);
            QZLog.d(FeedActionPanelActivity.H1, 2, "Navbar height : " + FeedActionPanelActivity.this.A0 + "inputMethodHeight height : " + FeedActionPanelActivity.this.f44950z0 + " hasNavi : " + FeedActionPanelActivity.this.f44946x0);
            if (FeedActionPanelActivity.this.f44948y0 == FeedActionPanelActivity.this.f44950z0) {
                return;
            }
            if (cu.f()) {
                FeedActionPanelActivity.this.f44950z0 += FeedActionPanelActivity.this.M3();
            }
            FeedActionPanelActivity feedActionPanelActivity2 = FeedActionPanelActivity.this;
            feedActionPanelActivity2.f44948y0 = feedActionPanelActivity2.f44950z0;
            if (FeedActionPanelActivity.this.f44946x0) {
                i3 = FeedActionPanelActivity.this.f44950z0 + height;
                height = FeedActionPanelActivity.this.A0;
            } else {
                i3 = FeedActionPanelActivity.this.f44950z0;
            }
            int i16 = i3 + height;
            QZLog.d(FeedActionPanelActivity.H1, 2, "inputMethodHeight = " + FeedActionPanelActivity.this.f44950z0 + " totalHeight height : " + i16);
            FeedActionPanelActivity.this.s4(i16);
            if (FeedActionPanelActivity.this.b4()) {
                if (FeedActionPanelActivity.this.f44950z0 != 0) {
                    if (FeedActionPanelActivity.this.f44950z0 > 0) {
                        FeedActionPanelActivity feedActionPanelActivity3 = FeedActionPanelActivity.this;
                        feedActionPanelActivity3.F1 = false;
                        feedActionPanelActivity3.G1.sendEmptyMessageDelayed(1, 200L);
                        FeedActionPanelActivity.this.E1 = height2 - i16;
                        if (FeedActionPanelActivity.this.f44946x0) {
                            FeedActionPanelActivity.this.E1 += FeedActionPanelActivity.this.A0;
                            return;
                        }
                        return;
                    }
                    return;
                }
                FeedActionPanelActivity feedActionPanelActivity4 = FeedActionPanelActivity.this;
                feedActionPanelActivity4.F1 = true;
                feedActionPanelActivity4.G1.removeMessages(1);
                FeedActionPanelActivity.this.G1.sendEmptyMessage(2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class h implements View.OnTouchListener {
        h() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            EmoEditPanel emoEditPanel;
            if ((motionEvent.getAction() != 0 && motionEvent.getAction() != 1) || (emoEditPanel = FeedActionPanelActivity.this.M0) == null || !emoEditPanel.q1()) {
                return false;
            }
            if (FeedActionPanelActivity.this.M0.z1()) {
                LpReportInfo_pf00064.allReport(85, 5);
            }
            FeedActionPanelActivity.this.M0.Y0(false, false);
            return true;
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
            if (!u5.a.e()) {
                RDMEtraMsgCollector.getInstance().addNoramlClickAction(FeedActionPanelActivity.H1, view);
                if (FeedActionPanelActivity.this.M0.z1()) {
                    LpReportInfo_pf00064.allReport(85, 5);
                }
                FeedActionPanelActivity.this.M0.Y0(false, false);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class j implements ViewTreeObserver.OnGlobalLayoutListener {
        j() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            FeedActionPanelActivity.this.h4();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class k extends Handler {
        k() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            FeedActionPanelActivity.this.E0.handleGetShareUrl(QZoneResult.unpack(message));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class l implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BusinessFeedData f44969d;

        l(BusinessFeedData businessFeedData) {
            this.f44969d = businessFeedData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            int id5 = view.getId();
            if (id5 == R.id.f163924ci) {
                FeedActionPanelActivity.this.E0.onShareToQQ();
                if (this.f44969d.isRegisterAnniversaryFeed()) {
                    LpReportInfo_pf00064.allReport(109, 3, 2);
                } else {
                    LpReportInfo_pf00064.allReport(85, 2);
                }
                ap.f59791b.e(40, 1, 0, this.f44969d);
            } else if (id5 == R.id.f163925cj) {
                FeedActionPanelActivity.this.E0.onShareToWeixin();
                FeedActionPanelActivity.this.V0 = true;
                if (!this.f44969d.isRegisterAnniversaryFeed()) {
                    int Q3 = FeedActionPanelActivity.this.Q3(this.f44969d);
                    if (Q3 != -1) {
                        LpReportInfo_pf00064.allReport(85, 3, Q3);
                    } else {
                        LpReportInfo_pf00064.allReport(85, 3);
                    }
                } else {
                    LpReportInfo_pf00064.allReport(109, 3, 3);
                }
                ap.f59791b.e(41, 1, 0, this.f44969d);
            } else if (id5 == R.id.f163926ck) {
                FeedActionPanelActivity.this.E0.onShareToWxMoments();
                FeedActionPanelActivity.this.V0 = true;
                if (this.f44969d.isRegisterAnniversaryFeed()) {
                    LpReportInfo_pf00064.allReport(109, 3, 4);
                } else {
                    LpReportInfo_pf00064.allReport(85, 4);
                }
                ap.f59791b.e(42, 1, 0, this.f44969d);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes39.dex */
    public class m extends RecyclerView.Adapter<n> {
        private LayoutInflater C;
        private int D = (ar.l() - (AreaConst.dp32 * 6)) / 12;
        private List<FrameAnimView> E = new ArrayList();

        /* renamed from: m, reason: collision with root package name */
        private ArrayList<PolymorphicPraiseEmotionData> f44971m;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes39.dex */
        public class a implements View.OnTouchListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f44972d;

            a(int i3) {
                this.f44972d = i3;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 0) {
                    FeedActionPanelActivity.this.f44929o1 = true;
                    FeedActionPanelActivity.this.f44931p1 = true;
                    FeedActionPanelActivity.this.f44936s0.sendMessageDelayed(FeedActionPanelActivity.this.f44936s0.obtainMessage(1, Integer.valueOf(this.f44972d)), 300L);
                } else if (actionMasked == 1 || actionMasked == 3 || actionMasked == 4) {
                    FeedActionPanelActivity.this.f44929o1 = false;
                    FeedActionPanelActivity.this.f44936s0.removeMessages(1);
                    if (!FeedActionPanelActivity.this.f44931p1) {
                        if (FeedActionPanelActivity.this.f44921k1 != null) {
                            FeedActionPanelActivity.this.f44921k1.m();
                            int k3 = FeedActionPanelActivity.this.f44921k1.k();
                            int j3 = FeedActionPanelActivity.this.f44921k1.j();
                            FeedActionPanelActivity.this.f44921k1.o();
                            FeedActionPanelActivity.this.t4(this.f44972d, k3);
                            FeedActionPanelActivity.this.o4(this.f44972d, j3);
                        }
                    } else {
                        FeedActionPanelActivity.this.l4(this.f44972d, false);
                        FeedActionPanelActivity.this.t4(this.f44972d, 1);
                        FeedActionPanelActivity.this.o4(this.f44972d, 1);
                    }
                }
                return true;
            }
        }

        public m(Context context) {
            this.C = LayoutInflater.from(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            ArrayList<PolymorphicPraiseEmotionData> arrayList = this.f44971m;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }

        public List<FrameAnimView> i0() {
            return this.E;
        }

        public ArrayList<PolymorphicPraiseEmotionData> j0() {
            return this.f44971m;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(n nVar, int i3) {
            ZipLoadBitmapGenerator pokeLikeAnimItem = PokeLikeWizard.INSTANCE.getPokeLikeAnimItem(this.f44971m.get(i3).strPraiseZip);
            nVar.E.setAnimImage(pokeLikeAnimItem.getBitmapIdList(), pokeLikeAnimItem, 25);
            nVar.E.f(true);
            this.E.add(i3, nVar.E);
            nVar.E.setOnTouchListener(new a(i3));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: l0, reason: merged with bridge method [inline-methods] */
        public n onCreateViewHolder(ViewGroup viewGroup, int i3) {
            View inflate = this.C.inflate(R.layout.afn, viewGroup, false);
            int i16 = this.D;
            inflate.setPadding(i16, 0, i16, 0);
            return new n(inflate);
        }

        public void m0(ArrayList<PolymorphicPraiseEmotionData> arrayList) {
            this.f44971m = arrayList;
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes39.dex */
    public class n extends RecyclerView.ViewHolder {
        FrameAnimView E;

        public n(View view) {
            super(view);
            this.E = (FrameAnimView) view.findViewById(R.id.bjn);
        }
    }

    /* loaded from: classes39.dex */
    static class o implements ThreadPool.Job<Object> {
        o() {
        }

        @Override // com.tencent.component.network.utils.thread.ThreadPool.Job
        public Object run(ThreadPool.JobContext jobContext) {
            QzoneEmotionUtils.loadEmoDrawable();
            return null;
        }
    }

    private void A3() {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
        a4();
        ViewTreeObserver viewTreeObserver = this.M0.getViewTreeObserver();
        if (viewTreeObserver == null || (onGlobalLayoutListener = this.C0) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B3() {
        EmoEditPanel emoEditPanel = this.M0;
        if (emoEditPanel == null) {
            return;
        }
        emoEditPanel.g2();
        if (this.M0.y1()) {
            this.M0.setPrivateIconChecked(false);
        } else {
            this.M0.setPrivateIconChecked(true);
        }
    }

    private void B4(boolean z16) {
        if (this.C1) {
            this.C1 = false;
            String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "HuangzuanPaySuccess", "\u652f\u4ed8\u6210\u529f\uff0c\u53ef\u4ee5\u4f7f\u7528\u79c1\u5bc6\u8bc4\u8bba");
            String string = getString(R.string.god);
            Intent intent = new Intent();
            intent.putExtra("aid", "jhan_simipinglun");
            intent.putExtra("direct_go", false);
            intent.putExtra("dialog_title", string);
            intent.putExtra("success_tips", config);
            intent.putExtra("dialog_msg", getString(R.string.god));
            intent.putExtra("pay_directgo", z16);
            VipComponentProxy.f50997g.getUiInterface().goOpenYellowVip(this, intent, Q1);
        }
    }

    private static void G3(Activity activity, String str, Bundle bundle, int i3) {
        Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", str);
        intent.putExtra("fromQZone", true);
        intent.putExtra("injectrecommend", true);
        intent.setData(Uri.parse(str));
        QZoneHelper.openWebSecurityVerify(intent);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        yo.b.a(intent);
        activity.startActivityForResult(intent, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H3(BusinessFeedData businessFeedData, String str) {
        if (this.J0 == -1) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.M0.F0().i(str);
            return;
        }
        if (businessFeedData == null || businessFeedData.getFeedCommInfo() == null || this.M0 == null || TextUtils.isEmpty(businessFeedData.getFeedCommInfo().ugckey)) {
            return;
        }
        if (this.J0 == 1207 && businessFeedData.getFeedCommInfo().appid == 4 && this.f44916i0 == null && this.f44918j0 == null && businessFeedData.getPictureInfo() != null && businessFeedData.getPictureInfo().pics != null && businessFeedData.getPictureInfo().pics.size() == 1) {
            String str2 = businessFeedData.getPictureInfo().pics.get(0).lloc;
            if (businessFeedData.getUser().uin >= 10001 && !TextUtils.isEmpty(businessFeedData.getPictureInfo().albumid) && !TextUtils.isEmpty(str2)) {
                this.M0.F0().i(businessFeedData.getUser().uin + "_" + businessFeedData.getPictureInfo().albumid + "_" + str2);
                return;
            }
        }
        String str3 = new String(businessFeedData.getFeedCommInfo().ugckey);
        switch (this.J0) {
            case 1205:
                str3 = str3 + "_SHARE";
                this.M0.setAllowEmpty(true);
                this.M0.setPicCommentVisiblity(false);
                break;
            case 1206:
                str3 = str3 + "_FORWARD";
                this.M0.setAllowEmpty(businessFeedData.getUser().uin != LoginData.getInstance().getUin());
                this.M0.setAllowEmpty(true);
                this.M0.setPicCommentVisiblity(false);
                break;
            case 1207:
                if (businessFeedData.getFeedCommInfo().appid == 4) {
                    if (!TextUtils.isEmpty(this.f44916i0)) {
                        str3 = str3 + "_" + this.f44916i0;
                    }
                    if (!TextUtils.isEmpty(this.f44918j0)) {
                        str3 = str3 + "_" + this.f44918j0;
                    }
                }
                this.M0.setAllowEmpty(false);
                break;
            case 1208:
                if (businessFeedData.getFeedCommInfo().appid != 334) {
                    if (!TextUtils.isEmpty(this.f44916i0)) {
                        str3 = str3 + "_" + this.f44916i0;
                    }
                    if (!TextUtils.isEmpty(this.f44918j0)) {
                        str3 = str3 + "_" + this.f44918j0;
                    }
                }
                this.M0.setAllowEmpty(false);
                this.M0.setPicCommentVisiblity(false);
                break;
            default:
                this.M0.setAllowEmpty(this.S0);
                this.M0.setPicCommentVisiblity(false);
                break;
        }
        this.M0.F0().i(str3);
    }

    private FrameLayout J3() {
        if (this.f44911f1 == null) {
            try {
                this.f44911f1 = (FrameLayout) findViewById(android.R.id.content);
            } catch (Throwable th5) {
                QZLog.w(H1, "getContentLayout: ", th5);
            }
        }
        return this.f44911f1;
    }

    private boolean K3(String str, boolean z16) {
        Intent intent = getIntent();
        if (intent == null) {
            return false;
        }
        return intent.getBooleanExtra(str, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int M3() {
        try {
            Resources resources = getResources();
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return resources.getDimensionPixelSize(Integer.parseInt(cls.getField("mz_action_button_min_height").get(cls.newInstance()).toString()));
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    private String P3(String str) {
        Map<String, String> map;
        if (TextUtils.isEmpty(str) || (map = this.f44933q1) == null || !map.containsKey(str)) {
            return null;
        }
        return this.f44933q1.get(str);
    }

    private void R3() {
        EmoEditPanel emoEditPanel = this.M0;
        if (emoEditPanel == null || emoEditPanel.getContext() == null || this.M0.L0() == null) {
            return;
        }
        ao.a(this.M0.getContext(), this.M0.L0());
    }

    private void T3() {
        int identifier = getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        this.A0 = identifier > 0 ? getResources().getDimensionPixelSize(identifier) : 0;
        QZLog.d(H1, 2, "Navbar height : " + this.A0);
    }

    private void U3() {
        ArrayList<PolymorphicPraiseEmotionData> arrayList;
        boolean z16;
        if (u4()) {
            BusinessFeedData businessFeedData = this.f44944w0;
            if (businessFeedData == null || businessFeedData.isCommentPokeLike()) {
                this.f44913g1 = this.M0.findViewById(R.id.bgj);
                this.f44917i1 = (RecyclerView) this.M0.findViewById(R.id.f166064bk3);
                this.M0.findViewById(R.id.jta).setBackgroundColor(getResources().getColor(R.color.qzone_skin_comment_top_divide_color));
                PokeLikeWizard pokeLikeWizard = PokeLikeWizard.INSTANCE;
                PolymorphicPraiseData globalPokeData = !pokeLikeWizard.isGlobalPokeItemDataEmpty() ? pokeLikeWizard.getGlobalPokeData() : null;
                if (globalPokeData == null || (arrayList = globalPokeData.emotionDatas) == null || arrayList.isEmpty()) {
                    return;
                }
                Iterator<PolymorphicPraiseEmotionData> it = globalPokeData.emotionDatas.iterator();
                while (it.hasNext()) {
                    ZipLoadBitmapGenerator pokeLikeAnimItem = PokeLikeWizard.INSTANCE.getPokeLikeAnimItem(it.next().strPraiseZip);
                    if (pokeLikeAnimItem.isDownload()) {
                        if (pokeLikeAnimItem.isLoadFailed()) {
                            pokeLikeAnimItem.reLoad();
                        }
                    }
                    z16 = false;
                }
                z16 = true;
                if (z16) {
                    X3(globalPokeData.emotionDatas);
                    this.f44913g1.setVisibility(0);
                    ViewGroup viewGroup = this.f44915h1;
                    if (viewGroup != null) {
                        viewGroup.setBackgroundResource(R.drawable.qui_common_fill_light_secondary_bg);
                    }
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                    linearLayoutManager.setOrientation(0);
                    this.f44917i1.setLayoutManager(linearLayoutManager);
                    m mVar = new m(this);
                    this.f44919j1 = mVar;
                    this.f44917i1.setAdapter(mVar);
                    this.f44919j1.m0(globalPokeData.emotionDatas);
                    V3();
                    LpReportInfo_pf00064.allReport(431, 16, 1);
                }
            }
        }
    }

    private void V3() {
        this.f44921k1 = new StickerBubbleAnimationView(this);
        if (Settings.canDrawOverlays(this)) {
            z3();
        } else {
            y3();
        }
    }

    private void W3() {
        boolean booleanExtra = getIntent().getBooleanExtra("statustextusedark", true);
        RFWThemeUtil.setStatusBarColor(this, 0);
        if (getWindow() != null) {
            RFWThemeUtil.setStatusTextColor(booleanExtra, getWindow());
            com.tencent.mobileqq.theme.a.d(getWindow());
        }
    }

    private void a4() {
        this.C0 = new f();
    }

    private void dismissPluginLoading() {
        Intent intent = new Intent("action_launch_completed");
        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "FriendFeed", "QQ\u7a7a\u95f4");
        intent.putExtra("plugin_apk", "qzone_plugin.apk");
        intent.putExtra("plugin_name", config);
        sendBroadcast(intent);
    }

    public static boolean f4(int i3) {
        if (i3 != 16 && i3 != 128) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h4() {
        StickerBubbleAnimationView stickerBubbleAnimationView;
        Rect rect = new Rect();
        FrameLayout J3 = J3();
        if (J3 == null) {
            return;
        }
        J3.getWindowVisibleDisplayFrame(rect);
        int height = (J3.getRootView().getHeight() - (rect.bottom - rect.top)) - ImmersiveUtils.getStatusBarHeight(this);
        if (this.f44923l1 || (stickerBubbleAnimationView = this.f44921k1) == null) {
            return;
        }
        stickerBubbleAnimationView.getLayoutParams().height = J3.getMeasuredHeight() - height;
    }

    private void m4() {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
        try {
            ViewTreeObserver viewTreeObserver = this.M0.getViewTreeObserver();
            if (viewTreeObserver == null || (onGlobalLayoutListener = this.C0) == null) {
                return;
            }
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n4() {
        EmoEditPanel emoEditPanel = this.M0;
        if (emoEditPanel == null || !this.D0) {
            return;
        }
        emoEditPanel.u0();
    }

    private void p4(Intent intent) {
        intent.setAction("FeedActionPanelActivity.content");
        sendBroadcast(intent);
    }

    private void r4() {
        sendBroadcast(new Intent("FeedActionPanelActivity.inputpanel_closed"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s4(int i3) {
        sendBroadcast(new Intent().setAction("FeedActionPanelActivity.inputpanel_height").putExtra("panel_height", x.h(this, i3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t4(int i3, int i16) {
        PolymorphicPraiseEmotionData polymorphicPraiseEmotionData;
        ImageUrl imageUrl;
        m mVar = this.f44919j1;
        if (mVar == null || mVar.j0() == null || this.f44919j1.j0().size() <= i3 || (polymorphicPraiseEmotionData = this.f44919j1.j0().get(i3)) == null || (imageUrl = polymorphicPraiseEmotionData.strPraiseImageUrl) == null) {
            return;
        }
        this.M0.setLikeComment(imageUrl.url, i16);
    }

    private void u3() {
        EventCenter.getInstance().addUIObserver(this, "FontQbossGifShow", 1);
    }

    private boolean u4() {
        return false;
    }

    private void w4(String str) {
        EmoEditPanel emoEditPanel = this.M0;
        if (emoEditPanel != null) {
            emoEditPanel.W1(str, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x3() {
        EmoEditPanel emoEditPanel = this.M0;
        if (emoEditPanel == null || !this.D0) {
            return;
        }
        emoEditPanel.setTextOutSideWatcher(new d());
    }

    private void y3() {
        FrameLayout J3 = J3();
        if (J3 == null) {
            return;
        }
        J3.addView(this.f44921k1);
        this.f44923l1 = false;
        if (this.f44925m1 == null) {
            this.f44925m1 = new j();
            J3.getViewTreeObserver().addOnGlobalLayoutListener(this.f44925m1);
        }
    }

    private void y4(BusinessFeedData businessFeedData, EmoEditPanel emoEditPanel) {
        s_droplist_option s_droplist_optionVar;
        int i3;
        emoEditPanel.n0(this);
        VideoInfo videoInfo = businessFeedData.getVideoInfo();
        if (!(videoInfo != null && ((i3 = videoInfo.videoStatus) == 4 || i3 == 7)) && !businessFeedData.isFriendAnniversaryFeed() && !businessFeedData.isCardFollowMoreRecommendContainerFeed() && !businessFeedData.isAdFeeds() && !businessFeedData.isGDTAdvFeed()) {
            ArrayList<s_droplist_option> arrayList = businessFeedData.getFeedCommInfo().customDroplist;
            if (arrayList != null && arrayList.size() > 0 && (s_droplist_optionVar = arrayList.get(0)) != null && s_droplist_optionVar.actiontype != 38) {
                this.M0.U0();
                return;
            }
            this.M0.f2();
            emoEditPanel.setShareIconAlpha(businessFeedData);
            QZoneFeedOperateLogic qZoneFeedOperateLogic = new QZoneFeedOperateLogic(new k(), this, "feed");
            this.E0 = qZoneFeedOperateLogic;
            qZoneFeedOperateLogic.setFeedData(businessFeedData);
            emoEditPanel.setOnShareClickCallBack(new l(businessFeedData));
            return;
        }
        this.M0.U0();
    }

    private void z3() {
        try {
            ((WindowManager) getSystemService("window")).addView(this.f44921k1, new WindowManager.LayoutParams(-1, -1, Build.VERSION.SDK_INT >= 26 ? 2038 : 2010, 824, -2));
            this.f44923l1 = true;
        } catch (Exception e16) {
            QZLog.w(H1, "addViewByWM: " + e16.getMessage(), e16);
            y3();
        }
    }

    private void z4() {
        try {
            if (this.O0 == null || !QQTheme.isNowThemeIsNightForQzone()) {
                return;
            }
            this.O0.setStatusBarMask(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP));
        } catch (Exception e16) {
            QZLog.e(H1, "catch an exception when set the NightMode for StatusBar.", e16);
        }
    }

    protected void C3(String str) {
        if (b4()) {
            TextUtils.isEmpty(str);
        }
    }

    protected String C4(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length();
        StringBuilder sb5 = new StringBuilder(length);
        Matcher matcher = R1.matcher(str);
        int i3 = 0;
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (start > i3) {
                sb5.append(str.substring(i3, start));
            }
            String emCodeToQQcode = QzoneEmotionUtils.emCodeToQQcode(str.substring(start, end));
            if (!TextUtils.isEmpty(emCodeToQQcode)) {
                sb5.append(emCodeToQQcode);
            } else {
                sb5.append(str.substring(start, end));
            }
            i3 = end;
        }
        if (length > i3) {
            sb5.append(str.substring(i3));
        }
        return sb5.toString();
    }

    public void D3() {
        EmoEditPanel emoEditPanel = this.M0;
        if (emoEditPanel == null) {
            return;
        }
        if (this.W0 == 0) {
            emoEditPanel.setForbiddenInputAt(true);
            this.M0.V0();
        } else {
            emoEditPanel.setForbiddenInputAt(false);
            this.M0.T1();
        }
    }

    public void D4() {
        String privacyDescriptionForShuoShuo = UgcSettingUtil.getPrivacyDescriptionForShuoShuo(this.f44943v1);
        this.f44947x1 = privacyDescriptionForShuoShuo;
        this.M0.setPrivData(privacyDescriptionForShuoShuo);
    }

    public void E3() {
        EmoEditPanel emoEditPanel = this.M0;
        if (emoEditPanel == null) {
            return;
        }
        if (this.X0 == 0) {
            emoEditPanel.Z0();
        } else {
            emoEditPanel.X1();
        }
    }

    public void F3() {
        EmoEditPanel emoEditPanel = this.M0;
        if (emoEditPanel == null) {
            return;
        }
        if (this.Y0 == 0) {
            emoEditPanel.i1();
        } else {
            emoEditPanel.h2();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x005b, code lost:
    
        if (r1 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x005d, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x006b, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0068, code lost:
    
        if (r1 != null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String L3(String str) {
        String str2 = "";
        Cursor cursor = null;
        try {
            cursor = ContactsMonitor.query(getApplicationContext().getContentResolver(), Uri.parse("content://qq.friendlist/friendlist/" + str), null, "uin=?", new String[]{str}, null);
            if (cursor != null && cursor.moveToFirst()) {
                String string = cursor.getString(cursor.getColumnIndex("name"));
                if (!TextUtils.isEmpty(string)) {
                    str2 = SecurityUtile.decode(new String(string.getBytes(), "utf-8"));
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th5) {
            if (cursor != null) {
                cursor.close();
            }
            throw th5;
        }
    }

    @Override // com.qzone.widget.EmoEditPanel.ah
    public void O() {
        if (QZonePermission.requestStoragePermissionForPluginActivity(this, new a(), QQPermissionConstants.Business.SCENE.QQ_QZONE_PIC_COMMENT_OPEN_MEDIA) && this.M0 != null) {
            com.qzone.common.business.service.b.f().o(this, this.M0.E0(), 3, false, 1, QZoneMediaBusiness.QZONE_COMMENT_ADD_PIC);
        }
    }

    @Override // com.qzone.widget.EmoEditPanel.ah
    public void Q1() {
        if (K1 == this.K0) {
            ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastPrivateSetting", "\u79c1\u5bc6\u56de\u590d\u4e0d\u53ef\u8bbe\u7f6e\u516c\u5f00"));
            return;
        }
        if (!LoginData.getInstance().isQzoneVip()) {
            B4(false);
        } else if (!u5.b.D("private_comment_is_ever_used", false)) {
            u5.b.o0("private_comment_is_ever_used", true);
            DialogUtil.createCustomDialog(this, 230, (String) null, getResources().getString(R.string.goe), (String) null, com.qzone.util.l.a(R.string.f171965mf1), new b(), (DialogInterface.OnClickListener) null).show();
        } else {
            B3();
        }
    }

    protected void S3(Bundle bundle) {
        this.f44935r1 = getIntent().getBooleanExtra("jump_from_main_process", false);
        if (bundle == null) {
            this.f44902b0 = getIntent().getSerializableExtra("extraIntentKey");
            this.f44900a0 = getIntent().getParcelableExtra("extraIntentKeyParcelable");
            this.f44904c0 = getIntent().getBundleExtra("extra_key_bundle_within_intent");
            this.f44914h0 = getIntent().getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.AUTOSAVE_STORAGE_KEY);
            this.f44916i0 = getIntent().getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_COMMENT_ID);
            this.f44918j0 = getIntent().getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_REPLY_ID);
            this.G0 = getIntent().getBooleanExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_IS_QUN, false);
            this.H0 = getIntent().getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_QUN_ID);
            this.I0 = getIntent().getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_QUN_NAME);
        } else {
            this.f44902b0 = getIntent().getSerializableExtra("extraIntentKey");
            this.f44900a0 = bundle.getParcelable("extraIntentKeyParcelable");
            this.f44904c0 = getIntent().getBundleExtra("extra_key_bundle_within_intent");
            this.f44914h0 = getIntent().getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.AUTOSAVE_STORAGE_KEY);
            this.f44916i0 = getIntent().getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_COMMENT_ID);
            this.f44918j0 = getIntent().getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_REPLY_ID);
            this.G0 = getIntent().getBooleanExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_IS_QUN, false);
            this.H0 = getIntent().getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_QUN_ID);
            this.I0 = getIntent().getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_QUN_NAME);
        }
        String stringExtra = getIntent().getStringExtra("cache_feeddata");
        if (!TextUtils.isEmpty(stringExtra)) {
            BusinessFeedData businessFeedData = QZoneFeedUtil.f47421a.get(stringExtra);
            this.f44940u0 = businessFeedData;
            this.f44900a0 = ParcelableWrapper.obtain(businessFeedData);
        }
        this.f44908e0 = getIntent().getStringExtra("extra_key_cur_like_key");
        this.f44910f0 = getIntent().getStringExtra("extra_key_ugc_key");
        this.f44912g0 = getIntent().getBooleanExtra("extra_key_is_op_comment_poke_like", false);
        this.D0 = getIntent().getBooleanExtra("enable_quick_comment_recommend", false);
        this.f44905c1 = getIntent().getStringExtra("cache_feedkey");
        this.Q0 = "BasePictureViewer".equals(getIntent().getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_REFER_ACTIVITY));
        this.L0 = getIntent().getIntExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SHOW_PICCOMMENT, L1);
        this.K0 = getIntent().getIntExtra(QZoneHelper.QzoneFeedActionPanelConstants.SHOW_KEY_ICON, I1);
        this.J0 = getIntent().getIntExtra("extraRequestCode", -1);
        QZLog.i(H1, "initUI: req code = " + this.J0);
        this.P0 = getIntent().getIntExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_IS_SYSTEM_TRANSPARENTBAR, 1);
        this.f44906d0 = getIntent().getIntExtra("extra_key_from_scene", -1);
        this.f44939t1 = getIntent().getIntExtra("from_ttt_page_id", -1);
        int i3 = this.f44906d0;
        if (i3 == 5 || i3 == 10) {
            this.f44930p0 = true;
        }
        this.W0 = getIntent().getIntExtra("showaticon", 1);
        this.X0 = getIntent().getIntExtra("showemotionicon", 1);
        this.Y0 = getIntent().getIntExtra(QZoneHelper.QzoneFeedActionPanelConstants.SHOW_XUANQU, 1);
        this.Z0 = getIntent().getIntExtra(QZoneHelper.QzoneFeedActionPanelConstants.SHOW_FONT_ICON, 0);
        this.f44901a1 = getIntent().getBooleanExtra(QZoneHelper.QzoneFeedActionPanelConstants.SHOW_SUPER_FONT, true);
        this.f44903b1 = getIntent().getBooleanExtra("show_barrage_effect_icon", false);
        this.f44920k0 = getIntent().getBooleanExtra("is_live_mode", false);
        this.f44922l0 = getIntent().getBooleanExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_VIDEO_EDIT_MODE, false);
        this.f44926n0 = getIntent().getBooleanExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_IS_TOPIC, false);
        this.f44928o0 = getIntent().getBooleanExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_IS_TOPIC_SYNC_QZONE, false);
        this.f44932q0 = getIntent().getIntExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_ID, -1);
        this.f44934r0 = getIntent().getIntExtra("extra_key_barrage_effect_id", -1);
        this.S0 = getIntent().getBooleanExtra("input_text_allow_empty", false);
        this.T0 = getIntent().getIntExtra("refer", 1);
        this.U0 = getIntent().getBooleanExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_IS_SHARE, false);
        this.F0 = getIntent().getBooleanExtra("is_qun_album", false);
        this.f44909e1 = getIntent().getBooleanExtra("action_show_font_gif", false);
        if (this.f44922l0) {
            Bundle bundleExtra = getIntent().getBundleExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_PRIV_DATA);
            this.f44938t0 = bundleExtra;
            if (bundleExtra != null) {
                k4(bundleExtra);
            }
        }
        this.f44907d1 = getIntent().getIntExtra("action_area_open_from", 0);
        T3();
        if (this.f44909e1) {
            m5.a.H().F(2749, false);
        }
    }

    protected boolean b4() {
        return this.D0;
    }

    public boolean c4() {
        return K3("catchClosePanel", false);
    }

    public boolean d4() {
        return K3("catchHeightChange", false);
    }

    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EmoEditPanel emoEditPanel = this.M0;
        if (emoEditPanel != null && emoEditPanel.x1()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnPause() {
        super.doOnPause();
        ap.g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        ap.h(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnStop() {
        super.doOnStop();
        if (com.qzone.reborn.configx.g.f53821a.b().E1()) {
            return;
        }
        R3();
    }

    public boolean e4() {
        return K3("disableAutoClose", false);
    }

    @Override // android.app.Activity
    public void finish() {
        if (com.qzone.feed.business.model.e.c().e()) {
            com.qzone.feed.business.model.e.c().f47156a = true;
        }
        if (this.D1) {
            return;
        }
        this.D1 = true;
        if (this.f44922l0) {
            Intent intent = new Intent();
            intent.putExtra("extraIntentKey", this.f44902b0);
            intent.putExtra("extraIntentKeyParcelable", this.f44900a0);
            intent.putExtra("extra_key_bundle_within_intent", this.f44904c0);
            intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_BUNDLE_PRIV_KEY, this.f44938t0);
            EmoEditPanel emoEditPanel = this.M0;
            if (emoEditPanel != null) {
                String P0 = emoEditPanel.P0();
                intent.putExtra("contentIntentKey", P0);
                intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_CONTENT_INTENT_VIDEO_EDIT_EMO, this.M0.J0());
                intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_CACHE_UNIKEY, this.M0.F0().f());
                intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_PRIVATE_COMMENT, this.M0.y1());
                intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FORWARDANDCOMMENT, !TextUtils.isEmpty(P0) && this.M0.u1());
                intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_IMAGELIST_CONTENT_INTENT, this.M0.E0());
                intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_IS_TOPIC_SYNC_QZONE, this.M0.A1());
                PersonalFontData.FontInfo R0 = this.M0.R0();
                if (R0 != null) {
                    intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_ID, R0.f51895id);
                    intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_FORMAT_TYPE, R0.fontFormatType);
                    intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_URL, R0.fontUrl);
                }
                QzoneSuperPersonalFontData.SuperFontInfo S0 = this.M0.S0();
                if (S0 != null) {
                    intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SUPER_FONT_ID, S0.f51897id);
                    intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SUPER_FONT_INFO, S0.toJson());
                }
                QzoneBarrageEffectData.BarrageEffectInfo Q0 = this.M0.Q0();
                if (Q0 != null) {
                    intent.putExtra("extra_key_barrage_effect_id", Q0.f51896id);
                    intent.putExtra("extra_key_barrage_effect_info", Q0.toJson());
                }
                if (this.f44920k0) {
                    t5.a.b(this.M0.F0().f());
                }
            }
            setResult(-1, intent);
        }
        super.finish();
        overridePendingTransition(0, 0);
    }

    public boolean g4() {
        return this.B1;
    }

    @Override // com.qzone.util.ap.a
    public int getReportPageId() {
        return this.f44939t1;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        if (this.f44929o1) {
            int intValue = ((Integer) message.obj).intValue();
            if (this.f44931p1) {
                this.f44931p1 = false;
            }
            l4(intValue, true);
            this.f44936s0.sendMessageDelayed(this.f44936s0.obtainMessage(1, Integer.valueOf(intValue)), 80L);
        }
        return true;
    }

    protected void initUI() {
        boolean z16;
        int i3;
        BusinessFeedData businessFeedData;
        BusinessFeedData businessFeedData2;
        this.f44936s0 = new Handler(Looper.getMainLooper(), this);
        if (this.f44922l0) {
            setContentView(R.layout.bga);
        } else {
            setContentView(R.layout.bkx);
        }
        findViewById(R.id.h9j).setOnTouchListener(new h());
        Object obj = this.f44900a0;
        if (obj instanceof ParcelableWrapper) {
            obj = ((ParcelableWrapper) obj).getData();
        }
        if (obj instanceof BusinessFeedData) {
            this.f44944w0 = (BusinessFeedData) obj;
            BusinessFeedData businessFeedData3 = QZoneFeedUtil.f47421a.get("current_forward_key");
            this.f44942v0 = businessFeedData3;
            if (businessFeedData3 == null) {
                this.f44942v0 = this.f44944w0;
            }
            BusinessFeedData businessFeedData4 = this.f44942v0;
            if (businessFeedData4 != null && QZoneFeedUtil.f47422b) {
                z16 = businessFeedData4.isFeedCommentInsertImage();
            } else {
                z16 = this.L0 == M1;
            }
            if (QZLog.isDevelopLevel()) {
                QZLog.d("FeedCommentInsertImage", 4, "enable=" + z16);
            }
        } else {
            z16 = this.L0 == M1;
        }
        boolean booleanExtra = getIntent().getBooleanExtra("extrauserapidcomment", true);
        boolean booleanExtra2 = getIntent().getBooleanExtra("show_favorites_emoticon", true);
        boolean z17 = z16 && !this.G0;
        EmoEditPanel emoEditPanel = (EmoEditPanel) findViewById(R.id.h9f);
        this.M0 = emoEditPanel;
        emoEditPanel.setIsShowFont(this.f44909e1);
        if (this.F0) {
            this.M0.setAtqunUser(true);
        }
        boolean z18 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QQ_EMOTICON_COMMENT, QzoneConfig.SECONDARY_USE_QQ_EMOTICON_COMMENT, 0) == 0;
        boolean z19 = z17 && this.J0 == 1207;
        QZLog.d(H1, 1, "initUI: useRapidComment = " + booleanExtra + ", needShowFavoritesEmo = " + booleanExtra2 + ", showPicComment = " + z17 + ", usePicComment = " + z19 + ", mActivityReuqestCode = " + this.J0);
        this.M0.o1(this, z19 && booleanExtra && !z18, z19 && z18, booleanExtra2, this.U0);
        this.M0.setEmoMaxLength(getIntent().getIntExtra("inputmax", 0));
        if (this.f44922l0) {
            this.M0.setVideoEditMode(true, this.f44926n0, this.f44928o0);
        }
        int i16 = I1;
        int i17 = this.K0;
        if (i16 == i17) {
            this.M0.g1();
        } else if (K1 == i17) {
            this.M0.e2();
            this.M0.setPrivateIconChecked(true);
        }
        D3();
        E3();
        F3();
        boolean K3 = K3("isFromDIY", false);
        if (!K3 && this.Z0 == 0) {
            this.M0.b1();
        } else {
            this.M0.setNeedSuperFont(K3 ? false : this.f44901a1);
            this.M0.Z1(this.f44932q0, this.f44922l0, K3);
        }
        int i18 = this.J0;
        if (i18 == 1207 || i18 == 2) {
            if (this.K0 != I1 && this.Z0 != 0 && this.f44903b1) {
                this.M0.setCanShowGuideAdv(0);
            } else {
                this.M0.setCanShowGuideAdv(1);
            }
        }
        if (this.f44903b1) {
            this.M0.U1(this.f44934r0, this.f44922l0);
        } else {
            this.M0.W0();
        }
        this.M0.setAllowEmpty(this.S0);
        D4();
        String stringExtra = getIntent().getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_SENDBTN_TEXT);
        if (!TextUtils.isEmpty(stringExtra)) {
            this.M0.setSendBtnText(stringExtra);
        }
        this.M0.setPicCommentVisiblity(z17);
        if (this.U0) {
            this.M0.b2();
            this.M0.g1();
        } else {
            this.M0.d1();
        }
        this.M0.setOnCancelCallback(this);
        this.M0.setOnPanelClickCallBack(this);
        this.M0.setOnClickListener(new i());
        if (getIntent().hasExtra("exoticPositionBagKey")) {
            int intExtra = getIntent().getIntExtra("exoticPositionBagKey", 0);
            this.f44937s1 = intExtra;
            this.N0 = new com.qzone.widget.e(intExtra);
        } else {
            int intExtra2 = getIntent().getIntExtra(QZoneHelper.Constants.KEY_DETAIL_EPBAG, 0);
            this.f44937s1 = intExtra2;
            this.N0 = EditPositionBag.h(intExtra2);
        }
        if (this.f44922l0) {
            this.M0.setStateChangeCallback(new EmoEditPanel.ak() { // from class: com.qzone.common.activities.FeedActionPanelActivity.4
                @Override // com.qzone.widget.EmoEditPanel.ak
                public void onHide() {
                    if (FeedActionPanelActivity.this.f44924m0 && FeedActionPanelActivity.this.f44936s0 != null) {
                        FeedActionPanelActivity.this.f44936s0.postDelayed(new Runnable() { // from class: com.qzone.common.activities.FeedActionPanelActivity.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                EmoEditPanel emoEditPanel2 = FeedActionPanelActivity.this.M0;
                                if (emoEditPanel2 == null || emoEditPanel2.D0() + ar.e(50.0f) < ar.k()) {
                                    return;
                                }
                                FeedActionPanelActivity.this.finish();
                            }
                        }, 200L);
                    }
                    if (FeedActionPanelActivity.this.f44924m0 || FeedActionPanelActivity.this.f44936s0 == null) {
                        return;
                    }
                    FeedActionPanelActivity.this.f44936s0.postDelayed(new Runnable() { // from class: com.qzone.common.activities.FeedActionPanelActivity.4.2
                        @Override // java.lang.Runnable
                        public void run() {
                            FeedActionPanelActivity.this.f44924m0 = true;
                        }
                    }, 300L);
                }

                @Override // com.qzone.widget.EmoEditPanel.ak
                public void a(int i19) {
                }
            });
        } else {
            EmoEditPanel.ak akVar = this.N0;
            if (akVar != null) {
                this.M0.setStateChangeCallback(akVar);
            }
        }
        String stringExtra2 = getIntent().getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_CACHE_UNIKEY);
        String stringExtra3 = getIntent().getStringExtra("cache_feeddata");
        if (!TextUtils.isEmpty(stringExtra3)) {
            BusinessFeedData businessFeedData5 = QZoneFeedUtil.f47421a.get(stringExtra3);
            this.f44940u0 = businessFeedData5;
            this.f44900a0 = ParcelableWrapper.obtain(businessFeedData5);
        }
        Object obj2 = this.f44900a0;
        if (obj2 instanceof ParcelableWrapper) {
            obj2 = ((ParcelableWrapper) obj2).getData();
        }
        if (obj2 instanceof BusinessFeedData) {
            QZoneFeedUtil.f47421a.get("current_forward_key");
            if (this.U0 && QZoneFeedUtil.f47422b) {
                businessFeedData2 = QZoneFeedUtil.f47421a.get("current_forward_key");
            } else {
                businessFeedData2 = (BusinessFeedData) obj2;
            }
            H3(businessFeedData2, stringExtra2);
        } else if (obj2 instanceof QZoneDetailService.DetailFeedDataKeys) {
            final QZoneDetailService.DetailFeedDataKeys detailFeedDataKeys = (QZoneDetailService.DetailFeedDataKeys) obj2;
            if (detailFeedDataKeys != null) {
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.common.activities.FeedActionPanelActivity.5
                    @Override // java.lang.Runnable
                    public void run() {
                        QZoneDetailService U = QZoneDetailService.U();
                        QZoneDetailService.DetailFeedDataKeys detailFeedDataKeys2 = detailFeedDataKeys;
                        final BusinessFeedData W = U.W(detailFeedDataKeys2.ugcKey, detailFeedDataKeys2.feedsKey);
                        U.close();
                        FeedActionPanelActivity.this.runOnUiThread(new Runnable() { // from class: com.qzone.common.activities.FeedActionPanelActivity.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                FeedActionPanelActivity.this.H3(W, null);
                                FeedActionPanelActivity.this.M0.P1();
                            }
                        });
                    }
                });
            }
        } else {
            if (!TextUtils.isEmpty(stringExtra2)) {
                this.M0.F0().i(stringExtra2);
            } else if (!TextUtils.isEmpty(this.f44910f0)) {
                this.M0.F0().i(this.f44910f0);
            }
            if (obj2 == null && ((i3 = this.J0) == 1205 || i3 == 1206)) {
                this.M0.setAllowEmpty(true);
            }
        }
        boolean P12 = this.M0.P1();
        String stringExtra4 = getIntent().getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.FEED_TEXT_HINT_INTENT_KEY);
        if (TextUtils.isEmpty(stringExtra4)) {
            w4(getResources().getString(R.string.glb));
        } else {
            w4(stringExtra4);
        }
        String stringExtra5 = getIntent().getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.FEED_TEXT_AUTOFILL_INTENT_KEY);
        if (getIntent().getIntExtra(QZoneHelper.QzoneFeedActionPanelConstants.NEEDTRANSEMOJ, 0) == 1) {
            stringExtra5 = C4(stringExtra5);
        }
        if (!TextUtils.isEmpty(stringExtra5) && !P12) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(stringExtra5);
            ArrayList<User> n3 = com.qzone.widget.x.n(this, spannableStringBuilder, -11184811, null);
            if (n3 != null && n3.size() > 0) {
                int size = n3.size();
                for (int i19 = 0; i19 < size; i19++) {
                    User user = n3.get(i19);
                    try {
                        Friend friend = new Friend();
                        String str = user.nickName;
                        friend.mName = str;
                        friend.mNickName = str;
                        friend.mRemark = str;
                        friend.mUin = user.uin;
                        this.M0.setFriendOnly(friend);
                    } catch (Exception unused) {
                    }
                }
            }
            this.M0.L0().setText(spannableStringBuilder);
            if (this.M0.L0().getEditableText() != null) {
                this.M0.L0().setSelection(this.M0.L0().getEditableText().length());
            }
        }
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            this.M0.setFitsSystemWindows(true);
        }
        QZoneFeedUtil.f47422b = false;
        this.B0 = (ViewGroup) this.M0.findViewById(R.id.h8v);
        this.f44915h1 = (ViewGroup) this.M0.findViewById(R.id.f67743e6);
        this.M0.z0(e4());
        if (d4() || b4()) {
            A3();
        }
        if (getIntent().getBooleanExtra("show_sharepanel", false) && (businessFeedData = this.f44944w0) != null && businessFeedData.getFeedCommInfo() != null) {
            y4(this.f44942v0, this.M0);
        } else {
            RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.common.activities.FeedActionPanelActivity.6
                @Override // java.lang.Runnable
                public void run() {
                    FeedActionPanelActivity.this.M0.L0().requestFocus();
                    FeedActionPanelActivity.this.M0.L0().setFocusable(true);
                    FeedActionPanelActivity.this.M0.L0().setFocusableInTouchMode(true);
                    FeedActionPanelActivity.this.M0.g2();
                }
            }, com.qzone.reborn.configx.g.f53821a.k().n());
        }
        U3();
    }

    public void l4(int i3, boolean z16) {
        m mVar;
        if (this.f44921k1 == null || (mVar = this.f44919j1) == null || mVar.j0() == null || this.f44919j1.i0() == null) {
            return;
        }
        FrameAnimView frameAnimView = this.f44919j1.i0().size() > i3 ? this.f44919j1.i0().get(i3) : null;
        if (frameAnimView == null) {
            return;
        }
        int[] iArr = new int[2];
        frameAnimView.getLocationOnScreen(iArr);
        Point point = new Point((frameAnimView.getWidth() / 2) + iArr[0], iArr[1] - I3());
        PolymorphicPraiseEmotionData polymorphicPraiseEmotionData = this.f44919j1.j0().get(i3);
        String str = polymorphicPraiseEmotionData.strPraiseZip;
        int i16 = this.f44927n1;
        this.f44927n1 = i16 + 1;
        StickerBubbleAnimationView.a a16 = com.qzone.component.f.a(point, str, i16);
        String str2 = polymorphicPraiseEmotionData.strPraiseImageUrl.url;
        if (str2 == null) {
            return;
        }
        if (str2.equals(this.M0.I0())) {
            this.f44921k1.d(a16, z16, this.M0.H0());
        } else {
            this.f44921k1.c(a16, z16);
        }
        this.f44921k1.setVisibility(0);
        if (z16) {
            this.f44921k1.p((point.y + frameAnimView.getHeight()) - O1);
        } else {
            this.f44921k1.m();
        }
    }

    @Override // com.qzone.widget.EmoEditPanel.ai
    public void onCancel(String str) {
        if (this.U0) {
            LpReportInfo_dc00321.report(15, this.T0, 2, com.qzone.business.lbsv2.business.c.g(QzoneLbsConstant.BUSINESS_ID_QZONE_FOR_REPORT).c());
            setResult(0, new Intent());
        }
        if (!this.f44922l0) {
            setResult(0, new Intent());
        }
        finish();
    }

    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i3 = configuration.orientation;
        if ((i3 == 1 || i3 == 2) && i3 != P1) {
            P1 = i3;
            EmoEditPanel emoEditPanel = this.M0;
            if (emoEditPanel != null) {
                emoEditPanel.G1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() == null) {
            QZLog.e(QZLog.TO_DEVICE_TAG, "FeedActionPanelActivity--onCreate getIntent is null");
            finish();
        }
        try {
            ImageManagerEnv.g();
        } catch (Throwable unused) {
            finish();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.qzone.hide_feed_actionpanel");
        registerReceiver(this.f44941u1, intentFilter);
        u3();
        S3(bundle);
        getWindow().setSoftInputMode(52);
        if (this.f44920k0) {
            getWindow().setFlags(1024, 1024);
        }
        W3();
        initUI();
    }

    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (b4()) {
            this.D0 = false;
            if (this.G1.hasMessages(1)) {
                this.G1.removeMessages(1);
            }
            if (this.G1.hasMessages(3)) {
                this.G1.removeMessages(3);
            }
            n4();
            QZLog.d("ZQ", 2, "Ky hide onDestory");
        }
        unregisterReceiver(this.f44941u1);
        LocalMultiProcConfig.putBool(IQZoneFeedActionJsPlugin.UNIQUE_KEY_FEEDACTION_ACTIVE, false);
        if (c4()) {
            r4();
        }
        m4();
        this.M0.u0();
        this.M0.x0();
        if (this.f44921k1 != null) {
            if (this.f44923l1) {
                try {
                    ((WindowManager) getSystemService("window")).removeView(this.f44921k1);
                } catch (Exception e16) {
                    QZLog.d(H1, 4, "remove view: " + e16.getMessage(), e16);
                }
            } else {
                FrameLayout J3 = J3();
                if (J3 != null) {
                    J3.removeView(this.f44921k1);
                }
            }
            this.f44921k1 = null;
        }
        if (this.f44925m1 != null) {
            FrameLayout J32 = J3();
            if (J32 != null) {
                J32.getViewTreeObserver().removeOnGlobalLayoutListener(this.f44925m1);
            }
            this.f44925m1 = null;
        }
        if (this.N0 instanceof EditPositionBag) {
            EditPositionBag.q(this.f44937s1);
            EmoEditPanel.ak akVar = this.N0;
            ((EditPositionBag) akVar).f60222e = null;
            ((EditPositionBag) akVar).f60223f = null;
            this.N0 = null;
        }
        super.onDestroy();
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        QbossAdvDesc qbossAdvDesc;
        if ("FontQbossGifShow".equals(event.source.getName()) && event.what == 1 && this.M0 != null && (qbossAdvDesc = (QbossAdvDesc) event.params) != null) {
            QZLog.i(H1, "FontQbossGif to mEditEmoPanel");
            this.M0.k1(qbossAdvDesc);
        }
        if (b4()) {
            return;
        }
        QZLog.d(H1, 2, "onEventUIThread check quickComment state : " + this.D0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent == null || this.A1.a(intent)) {
            return;
        }
        w3(intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.B1 = false;
        EmoEditPanel emoEditPanel = this.M0;
        if (emoEditPanel != null) {
            emoEditPanel.F1();
        }
        if (ImmersiveUtils.isSupporImmersive() == 1 && !this.f44920k0) {
            if (com.tencent.mobileqq.simpleui.b.c()) {
                if (this.P0 == 1) {
                    this.O0 = com.tencent.mobileqq.simpleui.b.b(this.O0, this, false, SimpleUIUtil.useDarkResource());
                } else {
                    getWindow().addFlags(ImmersiveUtils.FLAG_TRANSLUCENT_STATUS);
                }
            } else if (this.P0 == 1 && !this.f44922l0 && !this.f44930p0) {
                getWindow().addFlags(ImmersiveUtils.FLAG_TRANSLUCENT_STATUS);
                ImmersiveUtils.clearCoverForStatus(getWindow(), true);
                if (this.O0 != null) {
                    return;
                }
                SystemBarCompact systemBarCompact = new SystemBarCompact((Activity) this, true, getResources().getColor(R.color.skin_color_title_immersive_bar));
                this.O0 = systemBarCompact;
                systemBarCompact.setStatusBarDrawable(getResources().getDrawable(R.drawable.qq_title_immersive_bar));
                this.O0.init();
                z4();
            } else {
                getWindow().addFlags(ImmersiveUtils.FLAG_TRANSLUCENT_STATUS);
            }
        }
        StickerBubbleAnimationView stickerBubbleAnimationView = this.f44921k1;
        if (stickerBubbleAnimationView != null) {
            stickerBubbleAnimationView.setVisibility(0);
        }
        if (this.U0 && this.V0) {
            this.V0 = false;
            R3();
        }
    }

    @Override // com.qzone.widget.EmoEditPanel.ah
    public void onSend(String str) {
        Intent intent = new Intent();
        intent.putExtra("contentIntentKey", str);
        intent.putExtra("extraIntentKey", this.f44902b0);
        if (QZoneFeedUtil.M(this.f44900a0)) {
            BusinessFeedData businessFeedData = this.f44940u0;
            if (businessFeedData != null) {
                QZoneFeedUtil.f47421a.put("activity_result_ahare_to_qzone_key", businessFeedData);
            }
        } else {
            intent.putExtra("extraIntentKeyParcelable", this.f44900a0);
        }
        intent.putExtra("extra_key_bundle_within_intent", this.f44904c0);
        EmoEditPanel emoEditPanel = this.M0;
        if (emoEditPanel != null) {
            intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_CACHE_UNIKEY, emoEditPanel.F0().f());
            intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_PRIVATE_COMMENT, this.M0.y1());
            intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FORWARDANDCOMMENT, !TextUtils.isEmpty(str) && this.M0.u1());
            intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_IMAGELIST_CONTENT_INTENT, this.M0.E0());
            PersonalFontData.FontInfo R0 = this.M0.R0();
            if (R0 != null) {
                intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_ID, R0.f51895id);
                intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_FORMAT_TYPE, R0.fontFormatType);
                intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_URL, R0.fontUrl);
            }
            QzoneSuperPersonalFontData.SuperFontInfo S0 = this.M0.S0();
            if (S0 != null) {
                intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SUPER_FONT_ID, S0.f51897id);
                intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SUPER_FONT_INFO, S0.toJson());
            }
            QzoneBarrageEffectData.BarrageEffectInfo Q0 = this.M0.Q0();
            if (Q0 != null) {
                intent.putExtra("extra_key_barrage_effect_id", Q0.f51896id);
                intent.putExtra("extra_key_barrage_effect_info", Q0.toJson());
            }
            int H0 = this.M0.H0();
            String P3 = P3(this.M0.I0());
            if (!TextUtils.isEmpty(this.f44908e0) && H0 > 0 && !TextUtils.isEmpty(P3)) {
                intent.putExtra("extra_key_poke_emoji", P3);
                intent.putExtra("extra_key_poke_count", String.valueOf(H0));
                intent.putExtra("extra_key_cur_like_key", this.f44908e0);
                LpReportInfo_pf00064.allReport(431, 16, 4, (String) null, P3, String.valueOf(H0));
            }
            if (this.f44920k0) {
                t5.a.b(this.M0.F0().f());
            }
        }
        if (this.U0) {
            LpReportInfo_dc00321.report(15, this.T0, TextUtils.isEmpty(str) ? 3 : 4, com.qzone.business.lbsv2.business.c.g(QzoneLbsConstant.BUSINESS_ID_QZONE_FOR_REPORT).c());
            EmoEditPanel emoEditPanel2 = this.M0;
            LpReportInfo_pf00064.report(431, 15, 1, Integer.toString((emoEditPanel2 == null || !emoEditPanel2.u1()) ? 0 : 1));
        }
        if (!TextUtils.isEmpty(this.f44905c1)) {
            intent.putExtra("cache_feedkey", this.f44905c1);
        }
        if (e4()) {
            p4(intent);
        } else {
            EmoEditPanel emoEditPanel3 = this.M0;
            if (emoEditPanel3 != null) {
                emoEditPanel3.s0();
            }
            setResult(-1, intent);
            finish();
        }
        BusinessFeedData businessFeedData2 = this.f44940u0;
        if (businessFeedData2 != null && businessFeedData2.isEventTagFeed && !this.U0) {
            LpReportInfo_pf00064.allReport(Integer.valueOf("629").intValue(), 9);
        }
        BusinessFeedData businessFeedData3 = this.f44940u0;
        if (businessFeedData3 == null || businessFeedData3.getFeedCommInfo().extendInfo == null) {
            return;
        }
        String str2 = this.f44940u0.getFeedCommInfo().extendInfo.get("liked_appid");
        String str3 = this.f44940u0.getFeedCommInfo().extendInfo.get("liked_mtypeid");
        if ("217".equals(str2) && "10".equals(str3)) {
            LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(694, 2, 1), false, true);
        }
    }

    @Override // mqq.app.AppActivity, android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        Intent intent;
        super.onWindowFocusChanged(z16);
        boolean z17 = this.R0;
        if (z17) {
            if (z16 && z17 && (intent = getIntent()) != null && intent.getBooleanExtra("QZoneExtra.Plugin.isloading", false)) {
                dismissPluginLoading();
            }
            this.R0 = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class d implements EmoEditPanel.am {
        d() {
        }

        @Override // com.qzone.widget.EmoEditPanel.am
        public void a(CharSequence charSequence, int i3, int i16, int i17) {
            if (charSequence == null || !FeedActionPanelActivity.this.D0) {
                return;
            }
            FeedActionPanelActivity.this.C3(charSequence.toString());
        }
    }

    /* loaded from: classes39.dex */
    class g extends BroadcastReceiver {
        g() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            EmoEditPanel emoEditPanel;
            if (intent == null || !"com.qzone.hide_feed_actionpanel".equals(intent.getAction())) {
                return;
            }
            String stringExtra = intent.getStringExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_CACHE_UNIKEY);
            String stringExtra2 = intent.getStringExtra("cache_feedkey");
            boolean booleanExtra = intent.getBooleanExtra("extra_key_need_showtoast", false);
            boolean z16 = true;
            if (TextUtils.isEmpty(stringExtra) || (emoEditPanel = FeedActionPanelActivity.this.M0) == null || emoEditPanel.F0() == null ? stringExtra2 == null || !stringExtra2.equals(FeedActionPanelActivity.this.f44905c1) : !stringExtra.equals(FeedActionPanelActivity.this.M0.F0().f())) {
                z16 = false;
            }
            if (z16) {
                if (booleanExtra) {
                    ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastDeleteMsg", "\u8be5\u5185\u5bb9\u5df2\u88ab\u5220\u9664"), 4);
                }
                EmoEditPanel emoEditPanel2 = FeedActionPanelActivity.this.M0;
                if (emoEditPanel2 == null || !emoEditPanel2.q1()) {
                    return;
                }
                FeedActionPanelActivity.this.M0.Y0(false, false);
                FeedActionPanelActivity.this.finish();
            }
        }
    }

    private int I3() {
        int[] iArr = new int[2];
        this.f44921k1.getLocationInWindow(iArr);
        return iArr[1];
    }

    public static boolean i4(Activity activity) {
        try {
            WindowManager windowManager = activity.getWindowManager();
            if (windowManager == null) {
                return true;
            }
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            int i3 = displayMetrics.heightPixels;
            int i16 = displayMetrics.widthPixels;
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics2);
            return i16 - displayMetrics2.widthPixels > 0 || i3 - displayMetrics2.heightPixels > 0;
        } catch (Exception e16) {
            e16.printStackTrace();
            return true;
        }
    }

    @Override // com.qzone.widget.EmoEditPanel.ah
    public void f2() {
        this.f44924m0 = false;
        if (this.G0) {
            Intent intent = new Intent();
            intent.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_TROOP_MEMBER, true);
            intent.putExtra(ISelectMemberActivityConstants.PARAM_MIN, 1);
            intent.putExtra(ISelectMemberActivityConstants.PARAM_MAX, QZoneConfigHelper.L());
            intent.putExtra("group_uin", this.H0);
            intent.putExtra("group_name", this.I0);
            ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(this, intent, QZoneContant.QZ_SEARCH_LOCAL_REQUEST_CODE);
            return;
        }
        Intent intent2 = new Intent();
        intent2.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_FRIENDS, true);
        intent2.putExtra(ISelectMemberActivityConstants.PARAM_MIN, 1);
        intent2.putExtra(ISelectMemberActivityConstants.PARAM_MAX, QZoneConfigHelper.L());
        ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(this, intent2, QZoneContant.QZ_SEARCH_LOCAL_REQUEST_CODE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        this.B1 = true;
        StickerBubbleAnimationView stickerBubbleAnimationView = this.f44921k1;
        if (stickerBubbleAnimationView != null) {
            stickerBubbleAnimationView.setVisibility(8);
        }
        super.onPause();
        if (com.qzone.reborn.configx.g.f53821a.b().E1()) {
            R3();
        }
    }

    @Override // com.qzone.widget.EmoEditPanel.ah
    public void p1() {
        this.f44924m0 = false;
        String replace = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_UGC_PERMIT_SETTING, QZoneHelper.Constants.UGC_PERMIT_SETTING_PAGE).replace("{uin}", LoginData.getInstance().getUin() + "").replace("{qua}", QUA.getQUA3());
        Bundle bundle = new Bundle();
        bundle.putInt(UgcSettingUtil.KEY_PERMISSION_CODE, this.f44943v1);
        ArrayList<String> arrayList = this.f44945w1;
        if (arrayList != null && arrayList.size() > 0) {
            bundle.putStringArrayList("uin_list", this.f44945w1);
            ArrayList<String> arrayList2 = new ArrayList<>(this.f44945w1.size());
            Iterator<String> it = this.f44945w1.iterator();
            while (it.hasNext()) {
                arrayList2.add(L3(it.next()));
            }
            bundle.putStringArrayList(UgcSettingUtil.KEY_NICKNAMES, arrayList2);
        }
        if (f4(this.f44943v1) && !TextUtils.isEmpty(this.f44951z1)) {
            bundle.putString(UgcSettingUtil.KEY_UGC_SETTING_RAW_JSON, this.f44951z1);
        }
        G3(this, replace, bundle, 1002);
    }

    static {
        if (!N1) {
            PriorityThreadPool.getDefault().submit(new o());
            N1 = true;
        }
        P1 = -1;
        Q1 = 1;
        R1 = Pattern.compile("\\[em\\]e\\d{1,}\\[/em\\]", 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w3(ArrayList<String> arrayList) {
        SystemBarCompact systemBarCompact;
        if (arrayList == null || arrayList.isEmpty() || this.M0 == null) {
            return;
        }
        findViewById(R.id.f166479fi1).setBackgroundColor(HWColorFormat.COLOR_FormatVendorStartUnused);
        if (ImmersiveUtils.isSupporImmersive() == 1 && (systemBarCompact = this.O0) != null) {
            systemBarCompact.setgetStatusBarVisible(false, 0);
        }
        this.M0.d2(arrayList);
        this.M0.setAllowEmpty(true);
    }

    @Override // com.qzone.widget.EmoEditPanel.ah
    public void V(boolean z16) {
        this.f44924m0 = !z16;
    }

    @Override // com.qzone.widget.EmoEditPanel.ah
    public void r(boolean z16) {
        this.f44924m0 = !z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Q3(BusinessFeedData businessFeedData) {
        BusinessFeedData originalInfo;
        int i3 = -1;
        if (businessFeedData == null) {
            return -1;
        }
        if (businessFeedData.getFeedCommInfo() != null && businessFeedData.getFeedCommInfo().appid == 4) {
            i3 = businessFeedData.isForwardFeed() ? 3 : 1;
        }
        if (businessFeedData.isForwardFeed() && businessFeedData.getPictureInfo() == null && (originalInfo = businessFeedData.getOriginalInfo()) != null && originalInfo.getFeedCommInfo() != null && originalInfo.getFeedCommInfo().appid == 4) {
            return 2;
        }
        return i3;
    }

    private void X3(ArrayList<PolymorphicPraiseEmotionData> arrayList) {
        if (arrayList == null) {
            return;
        }
        this.f44933q1 = new HashMap();
        Iterator<PolymorphicPraiseEmotionData> it = arrayList.iterator();
        while (it.hasNext()) {
            PolymorphicPraiseEmotionData next = it.next();
            this.f44933q1.put(next.strPraiseImageUrl.url, next.strEmotion);
            if (next.strPraiseImageUrl != null && ImageLoader.getInstance().loadImageSync(next.strPraiseImageUrl.url) == null) {
                ImageLoader.getInstance().loadImageAsync(next.strPraiseImageUrl.url, null);
            }
        }
    }

    private void k4(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (bundle.containsKey(UgcSettingUtil.KEY_PERMISSION_CODE)) {
            this.f44943v1 = bundle.getInt(UgcSettingUtil.KEY_PERMISSION_CODE);
        }
        if (bundle.containsKey("uin_list")) {
            if (this.f44945w1 == null) {
                this.f44945w1 = new ArrayList<>();
            }
            this.f44945w1.clear();
            ArrayList<String> stringArrayList = bundle.getStringArrayList("uin_list");
            if (stringArrayList != null) {
                this.f44945w1.addAll(stringArrayList);
            }
        }
        if (f4(this.f44943v1)) {
            this.f44951z1 = bundle.getString(UgcSettingUtil.KEY_UGC_SETTING_RAW_JSON);
            this.f44949y1 = bundle.getString(UgcSettingUtil.KEY_TAG_INFO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v3(LocalMediaInfo localMediaInfo) {
        if (localMediaInfo == null) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(localMediaInfo.path);
        w3(arrayList);
    }

    @Override // mqq.app.AppActivity, android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.f44902b0 = bundle.getSerializable("extraIntentKey");
        this.f44900a0 = bundle.getParcelable("extraIntentKeyParcelable");
        this.f44904c0 = getIntent().getBundleExtra("extra_key_bundle_within_intent");
        this.f44914h0 = bundle.getString(QZoneHelper.QzoneFeedActionPanelConstants.AUTOSAVE_STORAGE_KEY);
        this.f44916i0 = bundle.getString(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_COMMENT_ID);
        this.f44918j0 = bundle.getString(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_REPLY_ID);
        this.G0 = bundle.getBoolean(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_IS_QUN);
        this.H0 = bundle.getString(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_QUN_ID);
        this.I0 = bundle.getString(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_QUN_NAME);
        super.onRestoreInstanceState(bundle);
    }

    @Override // mqq.app.AppActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.putSerializable("extraIntentKey", this.f44902b0);
        bundle.putParcelable("extraIntentKeyParcelable", this.f44900a0);
        bundle.putBundle("extra_key_bundle_within_intent", this.f44904c0);
        String str = this.f44914h0;
        if (str != null) {
            bundle.putString(QZoneHelper.QzoneFeedActionPanelConstants.AUTOSAVE_STORAGE_KEY, str);
        }
        String str2 = this.f44916i0;
        if (str2 != null) {
            bundle.putString(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_COMMENT_ID, str2);
        }
        String str3 = this.f44918j0;
        if (str3 != null) {
            bundle.putString(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_REPLY_ID, str3);
        }
        boolean z16 = this.G0;
        if (z16) {
            bundle.putBoolean(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_IS_QUN, z16);
        }
        String str4 = this.H0;
        if (str4 != null) {
            bundle.putString(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_QUN_ID, str4);
        }
        String str5 = this.I0;
        if (str5 != null) {
            bundle.putString(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_QUN_NAME, str5);
        }
        super.onSaveInstanceState(bundle);
    }

    public static boolean v4(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getFeedCommInfoV2() == null || (businessFeedData.getOriginalInfo() != null && businessFeedData.getOriginalInfo().getOriginalInfo() != null && businessFeedData.getOriginalInfo().getUser().uin > 0)) {
            return false;
        }
        int i3 = businessFeedData.getFeedCommInfoV2().appid;
        return i3 == 4 || i3 == 202 || i3 == 311;
    }

    public static int x4(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getFeedCommInfoV2() == null || (businessFeedData.getOriginalInfo() != null && businessFeedData.getOriginalInfo().getOriginalInfo() != null && businessFeedData.getOriginalInfo().getUser().uin > 0)) {
            return 0;
        }
        int i3 = businessFeedData.getFeedCommInfoV2().appid;
        return (i3 == 4 || i3 == 311) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        if (20221 == i3) {
            if (i16 == -1) {
                EmoEditPanel emoEditPanel = this.M0;
                if (emoEditPanel != null) {
                    emoEditPanel.E1(intent);
                    EmoEditPanel.ak akVar = this.N0;
                    if (akVar != null) {
                        akVar.onHide();
                        return;
                    }
                    return;
                }
                return;
            }
            EmoEditPanel emoEditPanel2 = this.M0;
            if (emoEditPanel2 != null) {
                emoEditPanel2.E0 = false;
                return;
            }
            return;
        }
        if (Q1 == i3) {
            this.C1 = true;
            if (i3 != -1) {
                return;
            }
            EmoEditPanel emoEditPanel3 = this.M0;
            if (emoEditPanel3 != null) {
                emoEditPanel3.setPrivateIconChecked(true);
            }
        }
        if (1002 == i3) {
            if (i16 == -1) {
                Bundle extras = intent.getExtras();
                this.f44938t0 = extras;
                k4(extras);
                D4();
            }
            if (getIntent().getBundleExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_PRIV_DATA) == null || !getIntent().getBundleExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_PRIV_DATA).getBoolean("is_need_auto_close_from_pri", false)) {
                return;
            }
            finish();
            return;
        }
        super.onActivityResult(i3, i16, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o4(int i3, int i16) {
        PolymorphicPraiseEmotionData polymorphicPraiseEmotionData;
        if (i16 <= 0) {
            return;
        }
        int i17 = i16 == 1 ? 2 : 3;
        m mVar = this.f44919j1;
        String str = (mVar == null || mVar.j0() == null || this.f44919j1.j0().size() <= i3 || (polymorphicPraiseEmotionData = this.f44919j1.j0().get(i3)) == null) ? null : polymorphicPraiseEmotionData.strEmotion;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        LpReportInfo_pf00064.allReport(431, 16, i17, (String) null, str, String.valueOf(i16));
    }

    /* loaded from: classes39.dex */
    class c implements xk.a {
        c() {
        }

        @Override // xk.a
        public void a(ArrayList<String> arrayList, List<LocalMediaInfo> list, HashMap<String, PicInfo> hashMap, Intent intent) {
            FeedActionPanelActivity.this.w3(xk.c.a(list));
        }

        @Override // xk.a
        public void c(LocalMediaInfo localMediaInfo, Intent intent) {
            FeedActionPanelActivity.this.v3(localMediaInfo);
        }

        @Override // xk.a
        public void d(LocalMediaInfo localMediaInfo, Intent intent) {
            FeedActionPanelActivity.this.v3(localMediaInfo);
        }

        @Override // xk.a
        public void b() {
        }
    }
}
