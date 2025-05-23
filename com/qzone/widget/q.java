package com.qzone.widget;

import NS_MOBILE_FEEDS.s_droplist_option;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.business.favorite.service.QzoneFavoriteService;
import com.qzone.common.account.LoginData;
import com.qzone.feed.utils.QZoneFeedUtil;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.util.ToastUtil;
import com.qzone.util.an;
import com.qzone.widget.f;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.avcore.jni.codec.HWColorFormat;
import com.tencent.component.animation.rebound.SimpleSpringListener;
import com.tencent.component.animation.rebound.Spring;
import com.tencent.component.animation.rebound.SpringConfig;
import com.tencent.component.animation.rebound.SpringSystem;
import com.tencent.component.animation.rebound.SpringUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.ResDownloadManger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes37.dex */
public class q extends PopupWindow implements com.qzone.widget.f {
    private static Drawable I0;
    private static Drawable J0;
    private static Drawable K0;
    private static Drawable L0;
    private static Drawable M0;
    private static Drawable N0;
    private static Drawable O0;
    private static Drawable P0;
    private static Drawable Q0;
    private static Drawable R0;
    private static Drawable S0;
    private static Drawable T0;
    private static Drawable U0;
    private static Drawable V0;
    private static Drawable W0;
    private static Drawable X0;
    private static Drawable Y0;
    private static Drawable Z0;

    /* renamed from: a1, reason: collision with root package name */
    private static Drawable f60968a1;

    /* renamed from: d1, reason: collision with root package name */
    private static Drawable f60971d1;
    private String A0;
    private String B0;
    private i C;
    private String C0;
    private boolean D;
    private Handler D0;
    private int E;
    private View.OnKeyListener E0;
    private int F;
    private View.OnTouchListener F0;
    private int G;
    private View.OnClickListener G0;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private float M;
    private float N;
    private boolean P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private BusinessFeedData T;
    public boolean U;
    public Activity V;
    private int W;
    private int X;
    public f.c Y;
    public f.c Z;

    /* renamed from: a0, reason: collision with root package name */
    public f.c f60976a0;

    /* renamed from: b0, reason: collision with root package name */
    public f.c f60977b0;

    /* renamed from: c0, reason: collision with root package name */
    public f.c f60978c0;

    /* renamed from: d, reason: collision with root package name */
    private int f60979d;

    /* renamed from: d0, reason: collision with root package name */
    public f.c f60980d0;

    /* renamed from: e, reason: collision with root package name */
    private int f60981e;

    /* renamed from: e0, reason: collision with root package name */
    public f.c f60982e0;

    /* renamed from: f, reason: collision with root package name */
    private Spring f60983f;

    /* renamed from: f0, reason: collision with root package name */
    public f.c f60984f0;

    /* renamed from: g0, reason: collision with root package name */
    public f.c f60985g0;

    /* renamed from: h, reason: collision with root package name */
    private ListView f60986h;

    /* renamed from: h0, reason: collision with root package name */
    public f.c f60987h0;

    /* renamed from: i, reason: collision with root package name */
    private RelativeLayout f60988i;

    /* renamed from: i0, reason: collision with root package name */
    public f.c f60989i0;

    /* renamed from: j0, reason: collision with root package name */
    public f.c f60990j0;

    /* renamed from: k0, reason: collision with root package name */
    public f.c f60991k0;

    /* renamed from: l0, reason: collision with root package name */
    public f.c f60992l0;

    /* renamed from: m, reason: collision with root package name */
    private LayoutInflater f60993m;

    /* renamed from: m0, reason: collision with root package name */
    public f.c f60994m0;

    /* renamed from: n0, reason: collision with root package name */
    public f.c f60995n0;

    /* renamed from: o0, reason: collision with root package name */
    public f.c f60996o0;

    /* renamed from: p0, reason: collision with root package name */
    public f.c f60997p0;

    /* renamed from: q0, reason: collision with root package name */
    public f.b f60998q0;

    /* renamed from: r0, reason: collision with root package name */
    public f.c f60999r0;

    /* renamed from: s0, reason: collision with root package name */
    public f.d f61000s0;

    /* renamed from: t0, reason: collision with root package name */
    public f.c f61001t0;

    /* renamed from: u0, reason: collision with root package name */
    public f.c f61002u0;

    /* renamed from: v0, reason: collision with root package name */
    public f.c f61003v0;

    /* renamed from: w0, reason: collision with root package name */
    public f.c f61004w0;

    /* renamed from: x0, reason: collision with root package name */
    private String f61005x0;

    /* renamed from: y0, reason: collision with root package name */
    private String f61006y0;

    /* renamed from: z0, reason: collision with root package name */
    private String f61007z0;
    private static final Drawable H0 = new ColorDrawable(HWColorFormat.COLOR_FormatVendorStartUnused);

    /* renamed from: b1, reason: collision with root package name */
    private static final Drawable f60969b1 = h1(R.drawable.qzone_skin_dropdown_btm_bg);

    /* renamed from: c1, reason: collision with root package name */
    private static final Drawable f60970c1 = h1(R.drawable.qzone_skin_dropdown_top_bg);

    /* renamed from: e1, reason: collision with root package name */
    private static Drawable f60972e1 = h1(R.drawable.qzone_skin_feed_dropmenu_icon_check_dress);

    /* renamed from: f1, reason: collision with root package name */
    private static Drawable f60973f1 = h1(R.drawable.qzone_skin_feed_dropmenu_icon_send_msg);

    /* renamed from: g1, reason: collision with root package name */
    private static final SpringConfig f60974g1 = SpringConfig.fromOrigamiTensionAndFriction(60.0d, 8.0d);

    /* renamed from: h1, reason: collision with root package name */
    private static int f60975h1 = 123;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != q.f60975h1 || q.this.C == null) {
                return;
            }
            q.this.C.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b extends SimpleSpringListener {
        b() {
        }

        @Override // com.tencent.component.animation.rebound.SimpleSpringListener, com.tencent.component.animation.rebound.SpringListener
        public void onSpringUpdate(Spring spring) {
            q.this.O1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class c implements View.OnTouchListener {
        c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return motionEvent.getAction() == 2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class e implements View.OnKeyListener {
        e() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i3, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0 && i3 == 4) {
                q.this.K1();
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class f implements View.OnTouchListener {
        f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                q.this.K1();
                return true;
            }
            if (motionEvent.getAction() == 4) {
                q.this.K1();
                return true;
            }
            return view.onTouchEvent(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class g implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f61014d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ BusinessFeedData f61015e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ f.a f61016f;

        g(int i3, BusinessFeedData businessFeedData, f.a aVar) {
            this.f61014d = i3;
            this.f61015e = businessFeedData;
            this.f61016f = aVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            q.this.L1(this.f61014d, this.f61015e, this.f61016f);
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view != null) {
                f.a aVar = q.this.W >= 0 ? (f.a) q.this.C.getItem(q.this.W) : null;
                if (view.getId() == R.id.bqh) {
                    q qVar = q.this;
                    qVar.H1(qVar.H, q.this.T);
                    q qVar2 = q.this;
                    qVar2.b1(qVar2.H, q.this.T, aVar, 33, false);
                    q.this.p();
                } else if (view.getId() == R.id.bqi) {
                    q qVar3 = q.this;
                    qVar3.I1(qVar3.H, q.this.T);
                    q qVar4 = q.this;
                    qVar4.b1(qVar4.H, q.this.T, aVar, 34, false);
                    q.this.p();
                } else if (view.getId() != R.id.bqg) {
                    q.this.F1(view);
                } else {
                    q qVar5 = q.this;
                    qVar5.G1(qVar5.H, q.this.T);
                    q qVar6 = q.this;
                    qVar6.b1(qVar6.H, q.this.T, aVar, 35, false);
                    q.this.p();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class j {

        /* renamed from: a, reason: collision with root package name */
        public f.a f61023a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f61024b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f61025c;

        /* renamed from: d, reason: collision with root package name */
        public AsyncImageView f61026d;

        /* renamed from: e, reason: collision with root package name */
        public FrameLayout f61027e;

        /* renamed from: f, reason: collision with root package name */
        public FrameLayout f61028f;

        /* renamed from: g, reason: collision with root package name */
        public FrameLayout f61029g;

        /* renamed from: h, reason: collision with root package name */
        public TextView f61030h;

        /* renamed from: i, reason: collision with root package name */
        public CommonLine f61031i;

        public j() {
        }
    }

    public q(Activity activity) {
        super(activity);
        this.f60979d = 0;
        this.f60981e = 0;
        this.f60983f = null;
        this.f60986h = null;
        this.f60988i = null;
        this.f60993m = null;
        this.C = null;
        this.D = false;
        this.E = -1;
        this.F = 0;
        this.G = 0;
        this.H = -1;
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.L = -1;
        this.M = 0.1f;
        this.N = 0.0f;
        this.P = false;
        this.Q = true;
        this.R = true;
        this.S = true;
        this.T = null;
        this.U = false;
        this.W = -1;
        this.X = -1;
        this.Y = null;
        this.Z = null;
        this.f60976a0 = null;
        this.f60977b0 = null;
        this.f60978c0 = null;
        this.f60980d0 = null;
        this.f60982e0 = null;
        this.f60984f0 = null;
        this.f60985g0 = null;
        this.f60987h0 = null;
        this.f60989i0 = null;
        this.f60990j0 = null;
        this.f60991k0 = null;
        this.f60992l0 = null;
        this.f60994m0 = null;
        this.f60995n0 = null;
        this.f60996o0 = null;
        this.f60997p0 = null;
        this.f60998q0 = null;
        this.f60999r0 = null;
        this.f61000s0 = null;
        this.f61001t0 = null;
        this.f61002u0 = null;
        this.f61003v0 = null;
        this.f61004w0 = null;
        this.f61005x0 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewMenu", "\u83dc\u5355");
        this.f61006y0 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewReduceRecommend", "\u51cf\u5c11\u6b64\u4eba\u63a8\u8350");
        this.f61007z0 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewNotInterestAndHide", "\u4e0d\u611f\u5174\u8da3\u5e76\u9690\u85cf");
        this.A0 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewHadSendApply", "\u5df2\u53d1\u9001\u597d\u53cb\u7533\u8bf7");
        this.B0 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewAddFriend", "\u6dfb\u52a0\u597d\u53cb");
        this.C0 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewNotShowAnyMore", "\u4e0d\u518d\u663e\u793a");
        this.D0 = new a(Looper.getMainLooper());
        this.E0 = new e();
        this.F0 = new f();
        this.G0 = new h();
        this.V = activity;
        J1();
    }

    private boolean A1() {
        BusinessFeedData businessFeedData = this.T;
        return businessFeedData == null || businessFeedData.getUser().uin != LoginData.getInstance().getUin();
    }

    private boolean B1() {
        BusinessFeedData businessFeedData = this.T;
        return (businessFeedData == null || businessFeedData.getUser() == null || this.T.getUser().uin == LoginData.getInstance().getUin()) ? false : true;
    }

    private boolean C1() {
        BusinessFeedData businessFeedData;
        return (x1() || (businessFeedData = this.T) == null || businessFeedData.isSecretFeed()) ? false : true;
    }

    private void D0() {
        if (T0(this.T.getFeedCommInfo().operatemask2, 6)) {
            f.a a16 = f.a.a();
            a16.f60854a = 16;
            a16.f60856c = m1(16);
            this.C.a(a16);
        }
    }

    private void E1(int i3, BusinessFeedData businessFeedData) {
        f.c cVar = this.f60995n0;
        if (cVar != null) {
            cVar.a(i3, businessFeedData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F1(View view) {
        j jVar = (j) view.getTag();
        if (jVar == null || jVar.f61023a == null) {
            return;
        }
        p();
        f.a aVar = jVar.f61023a;
        switch (aVar.f60854a) {
            case 1:
                f1(this.H, this.T);
                return;
            case 2:
                a1(this.H, this.T);
                return;
            case 3:
                X0(this.H, this.T, aVar);
                return;
            case 4:
                u1(this.H, this.T);
                return;
            case 5:
                int i3 = this.H;
                BusinessFeedData businessFeedData = this.T;
                if (businessFeedData.isSubFeed) {
                    i3 = businessFeedData.containerIndex;
                }
                t1(i3, businessFeedData);
                return;
            case 6:
                P1(this.H, this.T, aVar);
                return;
            case 7:
                Q1(this.H, this.T);
                return;
            case 8:
                b2(this.H, this.T);
                return;
            case 9:
                c2(this.H, this.T);
                return;
            case 10:
                Y1(this.H, this.T);
                return;
            case 11:
                E1(this.H, this.T);
                return;
            case 12:
                V0(this.H, this.T);
                return;
            case 13:
                c1(this.H, this.T);
                return;
            case 14:
                b1(this.H, this.T, aVar, -1, false);
                return;
            case 15:
                d1(this.H, this.T);
                return;
            case 16:
                s1(this.H, this.T);
                return;
            case 17:
            case 20:
            default:
                return;
            case 18:
                M1(this.H, this.T, aVar);
                return;
            case 19:
                R1(this.H, this.T);
                p();
                return;
            case 21:
                BusinessFeedData businessFeedData2 = this.T;
                if (businessFeedData2 == null || !businessFeedData2.hasDropdownFinishedAddFriend) {
                    B0(this.H, businessFeedData2);
                    p();
                    return;
                }
                return;
            case 22:
                X1(this.H, this.T);
                p();
                return;
            case 23:
                P0(this.H, this.T);
                p();
                return;
            case 24:
                N1(this.H, this.T);
                p();
                return;
        }
    }

    private void G0(s_droplist_option s_droplist_optionVar) {
        String str;
        f.a a16 = f.a.a();
        a16.f60854a = 6;
        if (s_droplist_optionVar == null) {
            str = m1(6);
        } else {
            str = s_droplist_optionVar.optext;
        }
        a16.f60856c = str;
        a16.f60857d = s_droplist_optionVar;
        this.C.a(a16);
    }

    private void I0(s_droplist_option s_droplist_optionVar) {
        String str;
        f.a a16 = f.a.a();
        a16.f60854a = 18;
        if (s_droplist_optionVar == null) {
            str = this.f61005x0;
        } else {
            str = s_droplist_optionVar.optext;
        }
        a16.f60856c = str;
        a16.f60857d = s_droplist_optionVar;
        this.C.a(a16);
    }

    private void K0(s_droplist_option s_droplist_optionVar) {
        String str;
        f.a a16 = f.a.a();
        a16.f60857d = s_droplist_optionVar;
        a16.f60854a = 15;
        if (s_droplist_optionVar != null) {
            str = s_droplist_optionVar.optext;
        } else {
            str = this.f61006y0;
        }
        a16.f60856c = str;
        this.C.a(a16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K1() {
        p();
        com.qzone.proxy.feedcomponent.i uiInterface = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface();
        com.qzone.adapter.feedcomponent.i.H();
        uiInterface.doFloatViewActionReport(11);
    }

    private void N0(s_droplist_option s_droplist_optionVar) {
        String str;
        f.a a16 = f.a.a();
        a16.f60857d = s_droplist_optionVar;
        a16.f60854a = 11;
        if (s_droplist_optionVar != null) {
            str = s_droplist_optionVar.optext;
        } else {
            str = this.f61007z0;
        }
        a16.f60856c = str;
        this.C.a(a16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O1() {
        float f16;
        Spring spring = this.f60983f;
        if (spring == null) {
            return;
        }
        float currentValue = (float) spring.getCurrentValue();
        float mapValueFromRangeToRange = (float) SpringUtil.mapValueFromRangeToRange(currentValue, 0.0d, 1.0d, 0.0d, 1.0d);
        if (currentValue < 0.0f) {
            this.P = true;
        }
        if (this.P) {
            mapValueFromRangeToRange = (float) this.f60983f.getEndValue();
            f16 = (float) this.f60983f.getEndValue();
        } else if (this.R) {
            float f17 = this.N;
            float f18 = this.M + f17;
            this.N = f18;
            if (f18 > 1.0f) {
                this.N = 1.0f;
            }
            mapValueFromRangeToRange = f17;
            f16 = mapValueFromRangeToRange;
        } else {
            f16 = mapValueFromRangeToRange;
        }
        S1(this.f60988i, mapValueFromRangeToRange);
        S1(this.f60986h, 1.0f);
        ViewUtils.setScaleX(this.f60986h, f16);
        ViewUtils.setScaleY(this.f60986h, f16);
        if (this.S) {
            ViewUtils.setPivotY(this.f60986h, 0.0f);
            ViewUtils.setPivotX(this.f60986h, this.f60979d);
        } else {
            ViewUtils.setPivotY(this.f60986h, this.f60981e);
            ViewUtils.setPivotX(this.f60986h, this.f60979d);
        }
        if (this.R || f16 != 0.0f) {
            return;
        }
        W0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean R0(int i3) {
        if (this.T == null) {
            return false;
        }
        return com.qzone.proxy.feedcomponent.util.d.j(r0.getFeedCommInfo().operatemask, i3);
    }

    private void R1(int i3, BusinessFeedData businessFeedData) {
        f.c cVar = this.f61001t0;
        if (cVar != null) {
            cVar.a(i3, businessFeedData);
        }
    }

    private boolean S0(int i3) {
        return com.qzone.proxy.feedcomponent.util.d.j(this.T.getFeedCommInfo().operatemask2, i3);
    }

    private static boolean T0(int i3, int i16) {
        if ((i3 & (1 << i16)) != 0) {
            return true;
        }
        return false;
    }

    private boolean U0(int i3) {
        return com.qzone.proxy.feedcomponent.util.d.j(this.T.getFeedCommInfo().operatemask3, i3);
    }

    private void V0(int i3, BusinessFeedData businessFeedData) {
        f.c cVar = this.f60996o0;
        if (cVar != null) {
            cVar.a(i3, businessFeedData);
        }
    }

    private void V1(int i3) {
        if (this.f60993m == null) {
            Activity g16 = g1();
            if (g16 == null) {
                return;
            } else {
                this.f60993m = LayoutInflater.from(g16);
            }
        }
        if (this.f60988i == null) {
            RelativeLayout relativeLayout = (RelativeLayout) this.f60993m.inflate(i3, (ViewGroup) null);
            this.f60988i = relativeLayout;
            if (relativeLayout == null) {
                return;
            }
        }
        S1(this.f60988i, 0.0f);
        this.f60988i.setFocusable(true);
        this.f60988i.setFocusableInTouchMode(true);
        this.f60988i.setOnKeyListener(this.E0);
        this.f60988i.setOnTouchListener(this.F0);
        ViewUtils.setViewBackground(this.f60988i, H0);
        super.setContentView(this.f60988i);
    }

    private void W0() {
        super.dismiss();
    }

    private void Y1(int i3, BusinessFeedData businessFeedData) {
        f.c cVar = this.f60990j0;
        if (cVar != null) {
            cVar.a(i3, businessFeedData);
        }
    }

    private void Z0() {
        int i3;
        if (g1() == null || this.T == null) {
            return;
        }
        this.Q = z1();
        this.L = k1();
        boolean q16 = com.qzone.proxy.feedcomponent.util.d.q(this.V, this.T);
        BusinessFeedData businessFeedData = this.T;
        if (businessFeedData.isEventTagFeed) {
            q16 = false;
        }
        if (this.C == null || this.f60986h == null) {
            return;
        }
        int i16 = businessFeedData.getFeedCommInfo().operatemask;
        int i17 = this.T.getFeedCommInfo().operatemask2;
        int i18 = this.T.getPermissionInfo().permission_visit;
        if (this.L < 0 && this.F == i16 && this.G == i17 && i18 == this.E && q16 == this.D && !this.T.hasCustomDropList()) {
            return;
        }
        this.C.b();
        VideoInfo videoInfo = this.T.getVideoInfo();
        boolean z16 = videoInfo != null && ((i3 = videoInfo.videoStatus) == 4 || i3 == 7);
        if (!z16 && !this.T.isFriendAnniversaryFeed() && !this.T.isCardFollowMoreRecommendContainerFeed()) {
            this.T.isRecommendFeed();
        }
        L0();
        if (T0(i17, 10)) {
            f.a a16 = f.a.a();
            a16.f60854a = 21;
            a16.f60856c = m1(21);
            this.C.a(a16);
        }
        A0(z16, q16);
        D0();
        u0();
        J0();
        E0();
        C0();
        if (!A1()) {
            s0();
        }
        z0();
        M0();
        y0();
        F0();
        x0();
        O0();
        t0();
        H0();
        if (A1() && !this.T.isFrdLikeVideoContainer() && !this.T.isFriendLikeVerticalSlideContainer() && !this.T.isPublicAccountContainer() && !this.T.isPublicAccountContent() && !this.T.isFriendPlayingFeed()) {
            s0();
        }
        if (this.T.hasCustomDropList()) {
            v1(z16);
        }
        this.D = q16;
        this.F = i16;
        this.G = i17;
        this.E = i18;
        this.C.notifyDataSetChanged();
        int i19 = 0;
        for (int i26 = 0; i26 < this.C.getCount(); i26++) {
            View view = this.C.getView(i26, null, this.f60986h);
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            i19 += view.getMeasuredHeight();
        }
        this.K = i19 + com.qzone.proxy.feedcomponent.util.g.a(9.0f);
    }

    private void c1(int i3, BusinessFeedData businessFeedData) {
        f.c cVar = this.f60997p0;
        if (cVar != null) {
            cVar.a(i3, businessFeedData);
        }
    }

    private void d1(int i3, BusinessFeedData businessFeedData) {
        f.c cVar = this.f60999r0;
        if (cVar != null) {
            cVar.a(i3, businessFeedData);
        }
    }

    private Drawable e1(int i3, String str, int i16) {
        return ResDownloadManger.getmInstance().getDrawableAsync(i3, str, new d());
    }

    public static Drawable h1(int i3) {
        try {
            FeedGlobalEnv.g();
            return FeedGlobalEnv.getApplication().getResources().getDrawable(i3);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String i1() {
        if (!this.Q) {
            return n1(R.string.gfa);
        }
        return n1(R.string.gfb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String j1() {
        BusinessFeedData businessFeedData = this.T;
        if (businessFeedData != null && businessFeedData.getFeedCommInfo().isTopFeed()) {
            return n1(R.string.gf_);
        }
        return n1(R.string.gfk);
    }

    private int k1() {
        BusinessFeedData businessFeedData;
        BusinessFeedData businessFeedData2;
        BusinessFeedData businessFeedData3 = this.T;
        boolean z16 = (businessFeedData3 == null || (businessFeedData2 = businessFeedData3.parentFeedData) == null || !businessFeedData2.isFriendLikeContainer()) ? false : true;
        BusinessFeedData businessFeedData4 = this.T;
        boolean z17 = (businessFeedData4 == null || (businessFeedData = businessFeedData4.parentFeedData) == null || !businessFeedData.isCardSpecialFollowMoreRecommendContainerFeed()) ? false : true;
        if (z16 || z17) {
            return -1;
        }
        if (R0(27) || R0(20)) {
            return this.T.getFeedCommInfo().isFollowed ? 9 : 8;
        }
        return -1;
    }

    public static String n1(int i3) {
        try {
            FeedGlobalEnv.g();
            return FeedGlobalEnv.getApplication().getResources().getString(i3);
        } catch (Exception unused) {
            return "";
        }
    }

    private int p1() {
        if (g1() == null) {
            return 0;
        }
        Rect rect = new Rect();
        g1().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i3 = rect.top;
        return i3 > 0 ? i3 : FeedGlobalEnv.g().getScreenHeight() - rect.height();
    }

    private void s0() {
        if (C1()) {
            f.a a16 = f.a.a();
            a16.f60854a = 23;
            a16.f60856c = m1(23);
            this.C.a(a16);
        }
    }

    private void s1(int i3, BusinessFeedData businessFeedData) {
        f.c cVar = this.f60980d0;
        if (cVar != null) {
            cVar.a(i3, businessFeedData);
        }
    }

    private void v0(s_droplist_option s_droplist_optionVar) {
        String str;
        f.a a16 = f.a.a();
        a16.f60854a = 3;
        if (s_droplist_optionVar == null) {
            str = i1();
        } else {
            str = s_droplist_optionVar.optext;
        }
        a16.f60856c = str;
        a16.f60857d = s_droplist_optionVar;
        this.C.a(a16);
    }

    private void v1(boolean z16) {
        Iterator<s_droplist_option> it = this.T.getFeedCommInfo().customDroplist.iterator();
        int i3 = -1;
        while (it.hasNext()) {
            s_droplist_option next = it.next();
            i3++;
            if (this.C == null) {
                this.C = new i(g1());
            }
            if (next != null) {
                this.X = i3;
                if (next.actiontype != 38 || z16) {
                    if (!D1(next)) {
                        int i16 = next.actiontype;
                        if (i16 == 39) {
                            v0(next);
                        } else if (i16 == 41) {
                            G0(next);
                        } else if (i16 == 42) {
                            N0(next);
                        } else if (i16 == 43) {
                            K0(next);
                        } else {
                            w0(next);
                        }
                    } else {
                        I0(next);
                    }
                }
            }
        }
    }

    private void w0(s_droplist_option s_droplist_optionVar) {
        f.a a16 = f.a.a();
        a16.f60854a = 14;
        a16.f60856c = s_droplist_optionVar == null ? null : s_droplist_optionVar.optext;
        a16.f60857d = s_droplist_optionVar;
        int i3 = this.X;
        if (i3 != -1) {
            a16.f60858e = i3;
        }
        this.C.a(a16);
    }

    private void w1() {
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_LEBA_NEW, 4, "qzonepouwindow:\u5f00\u59cb\u521d\u59cb\u5316");
        }
        O0 = e1(ResDownloadManger.getQzoneSkinFeedDropMenuResId(), "qzone_skin_feed_dropmenu_reprinted", 1);
        U0 = e1(ResDownloadManger.getQzoneSkinFeedDropMenuResId(), "qzone_skin_feed_dropmenu_yellow_diamond", 2);
        I0 = e1(ResDownloadManger.getQzoneSkinFeedDropMenuResId(), "qzone_skin_feed_dropmenu_edit", 3);
        J0 = e1(ResDownloadManger.getQzoneSkinFeedDropMenuResId(), "qzone_skin_feed_dropmenu_icon_delete", 4);
        K0 = e1(ResDownloadManger.getQzoneSkinFeedDropMenuResId(), "qzone_skin_feed_dropmenu_report", 5);
        L0 = e1(ResDownloadManger.getQzoneSkinFeedDropMenuResId(), "qzone_skin_feed_dropmenu_share", 6);
        M0 = e1(ResDownloadManger.getQzoneSkinFeedDropMenuResId(), "qzone_skin_feed_dropmenu_collect", 7);
        N0 = e1(ResDownloadManger.getQzoneSkinFeedDropMenuResId(), "qzone_skin_feed_dropmenu_collect_cancel", 8);
        R0 = e1(ResDownloadManger.getQzoneSkinFeedDropMenuResId(), "qzone_skin_feed_dropmenu_hide", 9);
        S0 = e1(ResDownloadManger.getQzoneSkinFeedDropMenuResId(), "qzone_skin_feed_dropmenu_not_see", 10);
        T0 = e1(ResDownloadManger.getQzoneSkinFeedDropMenuResId(), "qzone_skin_feed_dropmenu_top", 11);
        X0 = e1(ResDownloadManger.getQzoneSkinFeedDropMenuResId(), "qzone_skin_feed_dropmenu_not_see", 12);
        V0 = e1(ResDownloadManger.getQzoneSkinFeedDropMenuResId(), "qzone_skin_feed_dropmenu_not_interested", 13);
        W0 = e1(ResDownloadManger.getQzoneSkinFeedDropMenuResId(), "qzone_skin_feed_dropmenu_close_feed", 14);
        Q0 = e1(ResDownloadManger.getQzoneSkinFeedDropMenuResId(), "qzone_skin_feed_dropmenu_unsubscribe", 15);
        P0 = e1(ResDownloadManger.getQzoneSkinFeedDropMenuResId(), "qzone_skin_feed_dropmenu_subscribe", 16);
        Y0 = e1(ResDownloadManger.getQzoneSkinFeedDropMenuResId(), "qzone_skin_feed_dropmenu_add_friend", 17);
        Z0 = e1(ResDownloadManger.getQzoneSkinFeedDropMenuResId(), "qzone_skin_feed_dropmenu_already_add_friend", 18);
        f60971d1 = e1(ResDownloadManger.getQzoneSkinFeedDropMenuResId(), "qzone_skin_feed_dropmenu_download", 19);
        f60968a1 = e1(ResDownloadManger.getQzoneSkinFeedDropMenuResId(), "qzone_skin_feed_dropmenu_set_private", 20);
        i iVar = this.C;
        if (iVar != null) {
            iVar.notifyDataSetChanged();
        }
    }

    private void x0() {
        if (this.L < 0) {
            return;
        }
        if (R0(27) || R0(20)) {
            f.a a16 = f.a.a();
            int i3 = this.L;
            a16.f60854a = i3;
            a16.f60856c = m1(i3);
            this.C.a(a16);
        }
    }

    private boolean z1() {
        String str;
        BusinessFeedData businessFeedData = this.T;
        if (businessFeedData == null) {
            QZLog.w("QZonePopupWindow", "[isFavorited] mFeedData is null");
            return false;
        }
        if (!businessFeedData.isFriendLikeVerticalSlideContainer() && !this.T.isFrdLikeVideoContainer()) {
            if (this.T.getFeedCommInfo() == null) {
                return false;
            }
            return QzoneFavoriteService.M().R(this.T.getFeedCommInfo().ugckey);
        }
        ArrayList<BusinessFeedData> recBusinessFeedDatas = this.T.getRecBusinessFeedDatas();
        if (recBusinessFeedDatas == null || recBusinessFeedDatas.size() == 0) {
            return false;
        }
        for (BusinessFeedData businessFeedData2 : recBusinessFeedDatas) {
            if (!QZoneFeedUtil.f(businessFeedData2)) {
                if (QZLog.isColorLevel()) {
                    if (("[isCollected] " + businessFeedData2.getFeedCommInfo()) == null) {
                        str = "null";
                    } else {
                        str = businessFeedData2.getFeedCommInfo().ugckey + " can not collect";
                    }
                    QZLog.d("QZonePopupWindow", 2, str);
                }
            } else if (businessFeedData2.getFeedCommInfo() == null || !QzoneFavoriteService.M().R(businessFeedData2.getFeedCommInfo().ugckey)) {
                if (!QZLog.isColorLevel()) {
                    return false;
                }
                QZLog.d("QZonePopupWindow", 2, "[isFavorited] feed:" + businessFeedData2.getFeedCommInfo().ugckey + " not favorite");
                return false;
            }
        }
        return true;
    }

    @Override // com.qzone.widget.f
    public void H(int i3, f.d dVar) {
        this.f61000s0 = dVar;
    }

    public boolean Q0(int i3, int i16) {
        if ((i3 & i16) != 0) {
            return true;
        }
        return false;
    }

    public void T1(int i3) {
        this.J = i3;
    }

    public void U1(int i3) {
        this.I = i3;
    }

    public void W1(int i3, BusinessFeedData businessFeedData) {
        this.H = i3;
        this.T = businessFeedData;
        if (businessFeedData != null && businessFeedData.getFeedCommInfo() != null) {
            if (g1() == null) {
                return;
            }
            Z0();
        } else {
            this.H = -1;
            this.T = null;
        }
    }

    public boolean Y0(int i3, int i16) {
        if (this.f60988i == null || this.f60986h == null) {
            return false;
        }
        int screenWidth = FeedGlobalEnv.g().getScreenWidth() - (this.f60988i.getPaddingRight() * 2);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f60986h.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(screenWidth, this.K);
        }
        int q16 = i16 - q1();
        layoutParams.width = screenWidth;
        layoutParams.height = this.K;
        layoutParams.topMargin = q16;
        this.f60986h.setLayoutParams(layoutParams);
        this.f60981e = this.K;
        this.f60979d = screenWidth - ((this.I / 2) - this.f60988i.getPaddingRight());
        return true;
    }

    public void Z1() {
        if (isShowing()) {
            return;
        }
        this.N = 0.0f;
        this.P = false;
        this.R = true;
        this.S = true;
        S1(this.f60988i, 0.0f);
        ViewUtils.setViewBackground(this.f60986h, f60970c1);
        super.showAtLocation(o1(), 17, 0, 0);
        r1();
    }

    public void a2() {
        if (isShowing()) {
            return;
        }
        this.N = 0.0f;
        this.P = false;
        this.R = true;
        this.S = false;
        S1(this.f60988i, 0.0f);
        ViewUtils.setViewBackground(this.f60986h, f60969b1);
        super.showAtLocation(o1(), 17, 0, 0);
        r1();
    }

    public Activity g1() {
        return this.V;
    }

    @Override // com.qzone.widget.f
    public boolean j() {
        return isShowing();
    }

    public int l1() {
        return this.K;
    }

    @Override // com.qzone.widget.f
    public BusinessFeedData o() {
        return this.T;
    }

    public View o1() {
        return g1().findViewById(android.R.id.content).getRootView();
    }

    @Override // com.qzone.widget.f
    public void p() {
        dismiss();
    }

    public int q1() {
        int screenHeight;
        if (this.f60988i.getHeight() > 0 && (screenHeight = FeedGlobalEnv.g().getScreenHeight() - this.f60988i.getHeight()) <= com.qzone.proxy.feedcomponent.util.g.a(25.0f)) {
            return screenHeight;
        }
        int p16 = p1();
        return p16 <= 0 ? com.qzone.proxy.feedcomponent.util.g.a(25.0f) : p16;
    }

    public void r1() {
        Spring spring = this.f60983f;
        if (spring != null && spring.getCurrentValue() == this.f60983f.getEndValue()) {
            if (this.f60983f.getEndValue() == 0.0d) {
                this.f60983f.setEndValue(1.0d);
            } else {
                this.f60983f.setEndValue(0.0d);
            }
        }
    }

    @Override // com.qzone.widget.f
    public void w(int i3, f.b bVar) {
        this.f60998q0 = bVar;
    }

    public boolean x1() {
        CellFeedCommInfo feedCommInfo;
        BusinessFeedData businessFeedData = this.T;
        return (businessFeedData == null || businessFeedData.getFeedCommInfo() == null || (feedCommInfo = this.T.getFeedCommInfo()) == null || (!feedCommInfo.isVideoAdv() && !feedCommInfo.isAppAdvFeed() && !feedCommInfo.isFamousRecommAdvFeed() && !feedCommInfo.isVideoAdvShareFeed())) ? false : true;
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class i extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        private Context f61019d;

        /* renamed from: e, reason: collision with root package name */
        private LayoutInflater f61020e;

        /* renamed from: f, reason: collision with root package name */
        private List<f.a> f61021f = new ArrayList();

        public i(Context context) {
            this.f61019d = context;
        }

        private View c() {
            return d().inflate(R.layout.buj, (ViewGroup) null);
        }

        private LayoutInflater d() {
            if (this.f61020e == null) {
                this.f61020e = LayoutInflater.from(this.f61019d);
            }
            return this.f61020e;
        }

        private void e(f.a aVar, j jVar) {
            s_droplist_option s_droplist_optionVar = aVar.f60857d;
            Drawable drawable = null;
            if (s_droplist_optionVar != null && !TextUtils.isEmpty(s_droplist_optionVar.iconurl)) {
                jVar.f61026d.setAsyncImage(an.a(aVar.f60857d.iconurl));
                jVar.f61024b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                jVar.f61026d.setVisibility(0);
                return;
            }
            jVar.f61024b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            switch (aVar.f60854a) {
                case 0:
                    drawable = q.L0;
                    break;
                case 1:
                    drawable = q.I0;
                    break;
                case 2:
                    drawable = q.J0;
                    break;
                case 3:
                    drawable = q.this.Q ? q.N0 : q.M0;
                    break;
                case 4:
                    drawable = q.R0;
                    break;
                case 5:
                    drawable = q.S0;
                    break;
                case 6:
                    drawable = q.K0;
                    break;
                case 7:
                    drawable = q.O0;
                    break;
                case 8:
                    drawable = q.P0;
                    break;
                case 9:
                    drawable = q.Q0;
                    break;
                case 10:
                    jVar.f61024b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, q.U0, (Drawable) null);
                    drawable = q.T0;
                    break;
                case 11:
                    drawable = q.V0;
                    break;
                case 12:
                    drawable = q.W0;
                    break;
                case 13:
                    drawable = q.S0;
                    break;
                case 15:
                    drawable = q.S0;
                    break;
                case 16:
                    drawable = q.X0;
                    break;
                case 19:
                    drawable = q.f60971d1;
                    break;
                case 21:
                    if (q.this.T == null || !q.this.T.hasDropdownFinishedAddFriend) {
                        drawable = q.Y0;
                        break;
                    } else {
                        drawable = q.Z0;
                        break;
                    }
                    break;
                case 22:
                    drawable = q.f60968a1;
                    break;
                case 23:
                    drawable = q.f60972e1;
                    break;
                case 24:
                    drawable = q.f60973f1;
                    break;
            }
            if (drawable != null) {
                jVar.f61026d.setImageDrawable(drawable);
                jVar.f61026d.setVisibility(0);
            }
        }

        public void b() {
            Iterator<f.a> it = this.f61021f.iterator();
            while (it.hasNext()) {
                f.a.b(it.next());
            }
            this.f61021f.clear();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<f.a> list = this.f61021f;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            return this.f61021f.get(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            j jVar;
            if (view == null) {
                jVar = new j();
                View c16 = c();
                jVar.f61024b = (TextView) c16.findViewById(R.id.eq7);
                jVar.f61026d = (AsyncImageView) c16.findViewById(R.id.e7j);
                jVar.f61025c = (TextView) c16.findViewById(R.id.f166043e81);
                jVar.f61027e = (FrameLayout) c16.findViewById(R.id.bqh);
                jVar.f61028f = (FrameLayout) c16.findViewById(R.id.bqi);
                jVar.f61029g = (FrameLayout) c16.findViewById(R.id.bqg);
                jVar.f61030h = (TextView) c16.findViewById(R.id.iah);
                jVar.f61031i = (CommonLine) c16.findViewById(R.id.bqe);
                c16.setTag(jVar);
                view2 = c16;
            } else {
                view2 = view;
                jVar = (j) view.getTag();
            }
            if (jVar != null) {
                if (getCount() <= 1) {
                    jVar.f61031i.setVisibility(8);
                    view2.setBackgroundResource(R.drawable.b0t);
                } else if (i3 <= 0) {
                    jVar.f61031i.setVisibility(0);
                    view2.setBackgroundResource(R.drawable.b0t);
                } else if (i3 < getCount() - 1) {
                    jVar.f61031i.setVisibility(0);
                    view2.setBackgroundResource(R.drawable.b0s);
                } else {
                    jVar.f61031i.setVisibility(8);
                    view2.setBackgroundResource(R.drawable.b0r);
                }
                f.a aVar = (f.a) getItem(i3);
                if (aVar != null) {
                    int i16 = aVar.f60854a;
                    if ((i16 == 8 || i16 == 9) && q.this.L >= 0) {
                        int i17 = q.this.L;
                        aVar.f60854a = i17;
                        aVar.f60856c = q.this.m1(i17);
                    }
                    jVar.f61023a = aVar;
                    jVar.f61024b.setText(aVar.f60856c);
                    if (aVar.f60854a == 0) {
                        jVar.f61027e.setVisibility(0);
                        jVar.f61028f.setVisibility(0);
                        jVar.f61029g.setVisibility(0);
                        jVar.f61025c.setVisibility(0);
                        jVar.f61030h.setVisibility(0);
                        jVar.f61027e.setOnClickListener(q.this.G0);
                        jVar.f61028f.setOnClickListener(q.this.G0);
                        jVar.f61029g.setOnClickListener(q.this.G0);
                        jVar.f61027e.setContentDescription("\u5206\u4eab\u5230QQ");
                        jVar.f61028f.setContentDescription(com.qzone.util.l.a(R.string.s4z));
                        jVar.f61029g.setContentDescription(com.qzone.util.l.a(R.string.f172562s50));
                        ViewUtils.setViewBackground(view2, null);
                        view2.setOnClickListener(null);
                        if (q.this.R0(14)) {
                            q.this.S1(jVar.f61027e, 1.0f);
                        } else {
                            q.this.S1(jVar.f61027e, 0.3f);
                        }
                        if (q.this.T != null && q.this.T.getVideoInfo() != null) {
                            q.this.T.getLocalInfo();
                        }
                        if (q.this.R0(13)) {
                            q.this.S1(jVar.f61028f, 1.0f);
                            q.this.S1(jVar.f61029g, 1.0f);
                        } else {
                            q.this.S1(jVar.f61028f, 0.3f);
                            q.this.S1(jVar.f61029g, 0.3f);
                        }
                    } else {
                        jVar.f61027e.setVisibility(8);
                        jVar.f61028f.setVisibility(8);
                        jVar.f61029g.setVisibility(8);
                        jVar.f61025c.setVisibility(8);
                        jVar.f61030h.setVisibility(8);
                        jVar.f61027e.setOnClickListener(null);
                        jVar.f61028f.setOnClickListener(null);
                        jVar.f61029g.setOnClickListener(null);
                        view2.setOnClickListener(q.this.G0);
                    }
                    s_droplist_option s_droplist_optionVar = aVar.f60857d;
                    if (s_droplist_optionVar == null || s_droplist_optionVar.iconurl == null) {
                        jVar.f61026d.setVisibility(8);
                    }
                    int i18 = aVar.f60854a;
                    if (i18 == 3) {
                        jVar.f61024b.setText(q.this.i1());
                    } else if (i18 == 10) {
                        jVar.f61024b.setText(q.this.j1());
                    }
                    e(aVar, jVar);
                    if (aVar.f60854a == 21) {
                        if (q.this.T != null && q.this.T.hasDropdownFinishedAddFriend) {
                            jVar.f61024b.setAlpha(0.3f);
                            jVar.f61024b.setText("");
                        } else {
                            jVar.f61024b.setAlpha(1.0f);
                        }
                        jVar.f61024b.setText(q.this.m1(aVar.f60854a));
                    }
                }
            }
            EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
            return view2;
        }

        public void a(f.a aVar) {
            if (aVar == null) {
                return;
            }
            this.f61021f.add(aVar);
        }
    }

    private void H0() {
        if (S0(2)) {
            f.a a16 = f.a.a();
            a16.f60854a = 13;
            a16.f60856c = m1(13);
            this.C.a(a16);
        }
    }

    private void J0() {
        if (R0(7) && B1()) {
            f.a a16 = f.a.a();
            a16.f60854a = 7;
            a16.f60856c = m1(7);
            this.C.a(a16);
        }
    }

    private void L0() {
        if (U0(2)) {
            f.a a16 = f.a.a();
            a16.f60854a = 24;
            a16.f60856c = m1(24);
            this.C.a(a16);
        }
    }

    private void t0() {
        if (S0(0)) {
            f.a a16 = f.a.a();
            a16.f60854a = 12;
            a16.f60856c = m1(12);
            this.C.a(a16);
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        this.R = false;
        r1();
    }

    private void C0() {
        if (R0(25)) {
            f.a a16 = f.a.a();
            a16.f60854a = 5;
            a16.f60856c = m1(5);
            this.C.a(a16);
        }
    }

    private void E0() {
        if (R0(24)) {
            f.a a16 = f.a.a();
            a16.f60854a = 4;
            a16.f60856c = m1(4);
            this.C.a(a16);
        }
    }

    private void F0() {
        if (R0(21)) {
            f.a a16 = f.a.a();
            a16.f60854a = 6;
            a16.f60856c = m1(6);
            this.C.a(a16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L1(int i3, BusinessFeedData businessFeedData, f.a aVar) {
        if (businessFeedData == null || aVar.f60857d == null) {
            return;
        }
        if (!NetworkUtil.isNetworkAvailable(g1())) {
            ToastUtil.r(n1(R.string.f171139ci4));
        }
        f.d dVar = this.f61000s0;
        if (dVar != null) {
            dVar.a(this.H, this.T, aVar.f60857d);
        }
        s_droplist_option s_droplist_optionVar = aVar.f60857d;
        int i16 = s_droplist_optionVar.actiontype;
        if (i16 != 2) {
            if (i16 == 3) {
                yo.d.d(s_droplist_optionVar.jumpurl, g1(), null);
                return;
            }
            if (i16 != 23) {
                if (i16 == 41) {
                    P1(this.H, this.T, aVar);
                    return;
                } else {
                    if (i16 != 42) {
                        return;
                    }
                    E1(i3, businessFeedData);
                    return;
                }
            }
        }
        yo.d.d(s_droplist_optionVar.jumpurl, g1(), null);
    }

    private void M0() {
        if (!S0(27) || this.T.getPermissionInfo().permission_visit == 3) {
            return;
        }
        f.a a16 = f.a.a();
        a16.f60854a = 22;
        a16.f60856c = m1(22);
        this.C.a(a16);
    }

    private void N1(int i3, BusinessFeedData businessFeedData) {
        f.c cVar;
        if (businessFeedData == null || (cVar = this.f61004w0) == null) {
            return;
        }
        cVar.a(i3, businessFeedData);
    }

    private void O0() {
        if (R0(30)) {
            f.a a16 = f.a.a();
            a16.f60854a = 11;
            a16.f60856c = m1(11);
            this.C.a(a16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b1(int i3, BusinessFeedData businessFeedData, f.a aVar, int i16, boolean z16) {
        s_droplist_option s_droplist_optionVar;
        f.b bVar;
        if (aVar == null || (s_droplist_optionVar = aVar.f60857d) == null || (bVar = this.f60998q0) == null) {
            return;
        }
        bVar.a(i3, businessFeedData, s_droplist_optionVar, i16, z16);
        int i17 = aVar.f60858e;
        if (i17 == -1 || i17 > 2) {
            return;
        }
        ClickReport.q("584", "19", (aVar.f60858e + 12) + "", true);
    }

    private void u0() {
        if (R0(17)) {
            f.a a16 = f.a.a();
            a16.f60854a = 3;
            a16.f60856c = i1();
            this.C.a(a16);
        }
    }

    private void y0() {
        if (R0(10)) {
            f.a a16 = f.a.a();
            a16.f60854a = 2;
            a16.f60856c = m1(2);
            this.C.a(a16);
        }
    }

    private void z0() {
        if (R0(9)) {
            f.a a16 = f.a.a();
            a16.f60854a = 1;
            a16.f60856c = m1(1);
            this.C.a(a16);
        }
    }

    public void M1(int i3, BusinessFeedData businessFeedData, f.a aVar) {
        s_droplist_option s_droplist_optionVar;
        if (aVar == null || (s_droplist_optionVar = aVar.f60857d) == null) {
            return;
        }
        if (Q0(s_droplist_optionVar.action_detail, 1)) {
            Map<String, String> map = aVar.f60857d.extend_info;
            String str = map.get(AECameraConstants.KEY_CONFIRM_TEXT);
            String str2 = map.get("ok_text");
            String str3 = map.get("cancel_text");
            if (TextUtils.isEmpty(str2)) {
                str2 = n1(R.string.a8j);
            }
            String str4 = str2;
            if (TextUtils.isEmpty(str3)) {
                str3 = n1(R.string.cancel);
            }
            new com.qzone.component.e().h(g1(), str, "", str4, str3, new g(i3, businessFeedData, aVar), null);
            return;
        }
        L1(i3, businessFeedData, aVar);
    }

    public boolean y1(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getUser() == null) {
            return false;
        }
        return businessFeedData.getUser().isCanShowFamousIcon();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class d implements ResDownloadManger.ResLoadListener {
        d() {
        }

        @Override // cooperation.qzone.util.ResDownloadManger.ResLoadListener
        public void onDownloaded(int i3, String str, Bitmap bitmap) {
            if (bitmap != null) {
                bitmap.setDensity(320);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                bitmapDrawable.setTargetDensity((int) ViewUtils.getDensityDpi());
                if (TextUtils.equals("qzone_skin_feed_dropmenu_reprinted", str)) {
                    q.O0 = bitmapDrawable;
                } else if (TextUtils.equals("qzone_skin_feed_dropmenu_yellow_diamond", str)) {
                    q.U0 = bitmapDrawable;
                } else if (TextUtils.equals("qzone_skin_feed_dropmenu_edit", str)) {
                    q.I0 = bitmapDrawable;
                } else if (TextUtils.equals("qzone_skin_feed_dropmenu_icon_delete", str)) {
                    q.J0 = bitmapDrawable;
                } else if (TextUtils.equals("qzone_skin_feed_dropmenu_report", str)) {
                    q.K0 = bitmapDrawable;
                } else if (TextUtils.equals("qzone_skin_feed_dropmenu_share", str)) {
                    q.L0 = bitmapDrawable;
                } else if (TextUtils.equals("qzone_skin_feed_dropmenu_collect", str)) {
                    q.M0 = bitmapDrawable;
                } else if (TextUtils.equals("qzone_skin_feed_dropmenu_collect_cancel", str)) {
                    q.N0 = bitmapDrawable;
                } else if (TextUtils.equals("qzone_skin_feed_dropmenu_hide", str)) {
                    q.R0 = bitmapDrawable;
                } else if (TextUtils.equals("qzone_skin_feed_dropmenu_not_see", str)) {
                    q.S0 = bitmapDrawable;
                    q.X0 = bitmapDrawable;
                } else if (TextUtils.equals("qzone_skin_feed_dropmenu_top", str)) {
                    q.T0 = bitmapDrawable;
                } else if (TextUtils.equals("qzone_skin_feed_dropmenu_not_interested", str)) {
                    q.V0 = bitmapDrawable;
                } else if (TextUtils.equals("qzone_skin_feed_dropmenu_close_feed", str)) {
                    q.W0 = bitmapDrawable;
                } else if (TextUtils.equals("qzone_skin_feed_dropmenu_unsubscribe", str)) {
                    q.Q0 = bitmapDrawable;
                } else if (TextUtils.equals("qzone_skin_feed_dropmenu_subscribe", str)) {
                    q.P0 = bitmapDrawable;
                } else if (TextUtils.equals("qzone_skin_feed_dropmenu_add_friend", str)) {
                    q.Y0 = bitmapDrawable;
                } else if (TextUtils.equals("qzone_skin_feed_dropmenu_already_add_friend", str)) {
                    q.Z0 = bitmapDrawable;
                } else if (TextUtils.equals("qzone_skin_feed_dropmenu_download", str)) {
                    q.f60971d1 = bitmapDrawable;
                } else if (TextUtils.equals("qzone_skin_feed_dropmenu_set_private", str)) {
                    q.f60968a1 = bitmapDrawable;
                }
                if (q.this.D0 != null) {
                    Message message = new Message();
                    message.what = q.f60975h1;
                    q.this.D0.sendMessage(message);
                }
            }
        }

        @Override // cooperation.qzone.util.ResDownloadManger.ResLoadListener
        public void onFailed(int i3, String str) {
        }
    }

    private void B0(int i3, BusinessFeedData businessFeedData) {
        f.c cVar;
        if (businessFeedData == null || (cVar = this.Y) == null) {
            return;
        }
        cVar.a(i3, businessFeedData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G1(int i3, BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        f.c cVar = this.f60994m0;
        if (cVar != null) {
            cVar.a(i3, businessFeedData);
        }
        com.qzone.proxy.feedcomponent.i uiInterface = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface();
        com.qzone.adapter.feedcomponent.i.H();
        uiInterface.doFloatViewActionReport(14);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H1(int i3, BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        f.c cVar = this.f60985g0;
        if (cVar != null) {
            cVar.a(i3, businessFeedData);
        }
        com.qzone.proxy.feedcomponent.i uiInterface = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface();
        com.qzone.adapter.feedcomponent.i.H();
        uiInterface.doFloatViewActionReport(12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I1(int i3, BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        f.c cVar = this.f60992l0;
        if (cVar != null) {
            cVar.a(i3, businessFeedData);
        }
        com.qzone.proxy.feedcomponent.i uiInterface = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface();
        com.qzone.adapter.feedcomponent.i.H();
        uiInterface.doFloatViewActionReport(13);
    }

    private void J1() {
        V1(R.layout.buk);
        setFocusable(true);
        setBackgroundDrawable(null);
        setWidth(-1);
        setHeight(-1);
        w1();
        this.f60983f = SpringSystem.create().createSpring().setSpringConfig(f60974g1).addListener(new b());
        this.C = new i(g1());
        ListView listView = (ListView) this.f60988i.findViewById(R.id.bqf);
        this.f60986h = listView;
        listView.setFooterDividersEnabled(false);
        this.f60986h.setHeaderDividersEnabled(false);
        this.f60986h.setAdapter((ListAdapter) this.C);
        this.f60986h.setOnTouchListener(new c());
    }

    private void P0(int i3, BusinessFeedData businessFeedData) {
        f.c cVar;
        if (businessFeedData == null || (cVar = this.f61003v0) == null) {
            return;
        }
        cVar.a(i3, businessFeedData);
    }

    private void P1(int i3, BusinessFeedData businessFeedData, f.a aVar) {
        if (businessFeedData == null) {
            return;
        }
        if (businessFeedData.isAdFeeds()) {
            b1(i3, businessFeedData, aVar, -1, false);
        }
        f.c cVar = this.f60982e0;
        if (cVar != null) {
            cVar.a(i3, businessFeedData);
        }
        com.qzone.proxy.feedcomponent.i uiInterface = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface();
        com.qzone.adapter.feedcomponent.i.H();
        uiInterface.doFloatViewActionReport(22);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S1(View view, float f16) {
        if (view == null) {
            return;
        }
        view.setAlpha(f16);
    }

    private void X1(int i3, BusinessFeedData businessFeedData) {
        f.c cVar;
        if (businessFeedData == null || (cVar = this.f61002u0) == null) {
            return;
        }
        cVar.a(i3, businessFeedData);
    }

    private void a1(int i3, BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        f.c cVar = this.f60978c0;
        if (cVar != null) {
            cVar.a(i3, businessFeedData);
        }
        com.qzone.proxy.feedcomponent.i uiInterface = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface();
        com.qzone.adapter.feedcomponent.i.H();
        uiInterface.doFloatViewActionReport(21);
    }

    private void f1(int i3, BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        f.c cVar = this.f60977b0;
        if (cVar != null) {
            cVar.a(i3, businessFeedData);
        }
        com.qzone.proxy.feedcomponent.i uiInterface = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface();
        com.qzone.adapter.feedcomponent.i.H();
        uiInterface.doFloatViewActionReport(20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String m1(int i3) {
        switch (i3) {
            case 0:
                return n1(R.string.gfm);
            case 1:
                return n1(R.string.gfe);
            case 2:
                return n1(R.string.gfc);
            case 3:
                return i1();
            case 4:
                return n1(R.string.gfh);
            case 5:
                return n1(R.string.gfg);
            case 6:
                return n1(R.string.gfi);
            case 7:
                if (this.T.getFeedCommInfo().appid == 2) {
                    return n1(R.string.gfj);
                }
                return n1(R.string.f173011gg4);
            case 8:
                return n1(R.string.gfn);
            case 9:
                return n1(R.string.gfo);
            case 10:
                return j1();
            case 11:
                return n1(R.string.gi6);
            case 12:
                return n1(R.string.gd_);
            case 13:
                return this.C0;
            case 14:
            case 15:
            case 17:
            case 18:
            case 20:
            default:
                return "";
            case 16:
                return n1(R.string.gff);
            case 19:
                return n1(R.string.gfd);
            case 21:
                if (this.T.hasDropdownFinishedAddFriend) {
                    return this.A0;
                }
                return this.B0;
            case 22:
                return n1(R.string.gfl);
            case 23:
                if (A1()) {
                    return "\u67e5\u770bTa\u7684\u88c5\u626e";
                }
                return com.qzone.util.l.a(R.string.s4y);
            case 24:
                return n1(R.string.gh_);
        }
    }

    private void t1(int i3, BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        f.c cVar = this.Z;
        if (cVar != null) {
            cVar.a(i3, businessFeedData);
        }
        com.qzone.proxy.feedcomponent.i uiInterface = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface();
        com.qzone.adapter.feedcomponent.i.H();
        uiInterface.doFloatViewActionReport(19);
    }

    private void u1(int i3, BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        f.c cVar = this.f60976a0;
        if (cVar != null) {
            cVar.a(i3, businessFeedData);
        }
        com.qzone.proxy.feedcomponent.i uiInterface = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface();
        com.qzone.adapter.feedcomponent.i.H();
        uiInterface.doFloatViewActionReport(18);
    }

    public void Q1(int i3, BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        f.c cVar = this.f60987h0;
        if (cVar != null) {
            cVar.a(i3, businessFeedData);
        }
        com.qzone.proxy.feedcomponent.i uiInterface = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface();
        com.qzone.adapter.feedcomponent.i.H();
        uiInterface.doFloatViewActionReport(17);
    }

    public void X0(int i3, BusinessFeedData businessFeedData, f.a aVar) {
        if (businessFeedData == null) {
            return;
        }
        boolean z16 = z1();
        f.c cVar = this.f60984f0;
        if (cVar != null) {
            cVar.a(i3, businessFeedData);
        }
        b1(i3, businessFeedData, aVar, -1, z16);
        if (!z16) {
            com.qzone.proxy.feedcomponent.i uiInterface = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface();
            com.qzone.adapter.feedcomponent.i.H();
            uiInterface.doFloatViewActionReport(15);
        } else {
            com.qzone.proxy.feedcomponent.i uiInterface2 = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface();
            com.qzone.adapter.feedcomponent.i.H();
            uiInterface2.doFloatViewActionReport(16);
        }
    }

    public void b2(int i3, BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        f.c cVar = this.f60989i0;
        if (cVar != null) {
            cVar.a(i3, businessFeedData);
        }
        LpReportInfo_pf00064.allReport(302, 549, y1(businessFeedData) ? 1 : 2);
        com.qzone.proxy.feedcomponent.i uiInterface = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface();
        com.qzone.adapter.feedcomponent.i.H();
        uiInterface.doFloatViewActionReport(23);
    }

    public void c2(int i3, BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        f.c cVar = this.f60991k0;
        if (cVar != null) {
            cVar.a(i3, businessFeedData);
        }
        LpReportInfo_pf00064.allReport(302, 550, y1(businessFeedData) ? 1 : 2);
        com.qzone.proxy.feedcomponent.i uiInterface = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface();
        com.qzone.adapter.feedcomponent.i.H();
        uiInterface.doFloatViewActionReport(24);
    }

    private void A0(boolean z16, boolean z17) {
        if (z16 || !z17) {
            return;
        }
        f.a a16 = f.a.a();
        a16.f60854a = 10;
        a16.f60856c = j1();
        this.C.a(a16);
    }

    private boolean D1(s_droplist_option s_droplist_optionVar) {
        if (s_droplist_optionVar == null) {
            return false;
        }
        int i3 = s_droplist_optionVar.reporttypeV2;
        return i3 == 4 || i3 == 5;
    }

    @Override // com.qzone.widget.f
    public void z(int i3, f.c cVar) {
        switch (i3) {
            case 1:
                this.Y = cVar;
                return;
            case 2:
                this.Z = cVar;
                return;
            case 3:
                this.f60976a0 = cVar;
                return;
            case 4:
                this.f60977b0 = cVar;
                return;
            case 5:
                this.f60978c0 = cVar;
                return;
            case 6:
                this.f60980d0 = cVar;
                return;
            case 7:
                this.f60982e0 = cVar;
                return;
            case 8:
                this.f60984f0 = cVar;
                return;
            case 9:
                this.f60985g0 = cVar;
                return;
            case 10:
                this.f60987h0 = cVar;
                return;
            case 11:
                this.f60989i0 = cVar;
                return;
            case 12:
                this.f60990j0 = cVar;
                return;
            case 13:
                this.f60991k0 = cVar;
                return;
            case 14:
                this.f60992l0 = cVar;
                return;
            case 15:
                this.f60994m0 = cVar;
                return;
            case 16:
                this.f60995n0 = cVar;
                return;
            case 17:
                this.f60996o0 = cVar;
                return;
            case 18:
                this.f60997p0 = cVar;
                return;
            case 19:
            case 21:
            default:
                return;
            case 20:
                this.f60999r0 = cVar;
                return;
            case 22:
                this.f61001t0 = cVar;
                return;
            case 23:
                this.f61002u0 = cVar;
                return;
            case 24:
                this.f61003v0 = cVar;
                return;
            case 25:
                this.f61004w0 = cVar;
                return;
        }
    }
}
