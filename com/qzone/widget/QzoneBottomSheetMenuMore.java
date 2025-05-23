package com.qzone.widget;

import NS_MOBILE_FEEDS.s_droplist_option;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.business.favorite.service.QzoneFavoriteService;
import com.qzone.common.account.LoginData;
import com.qzone.feed.utils.QZoneFeedUtil;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.util.ToastUtil;
import com.qzone.util.an;
import com.qzone.util.ap;
import com.qzone.widget.f;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.avcore.jni.codec.HWColorFormat;
import com.tencent.component.animation.rebound.SpringConfig;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.widget.immersive.ImmersiveUtils;
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
public class QzoneBottomSheetMenuMore extends ReportDialog implements com.qzone.widget.f {
    private static Drawable G0;
    private static Drawable H0;
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

    /* renamed from: b1, reason: collision with root package name */
    private static Drawable f60493b1;
    private String A0;
    private String B0;
    private Activity C;
    private String C0;
    private BusinessFeedData D;
    private String D0;
    private int E;
    private j E0;
    private boolean F;
    private int G;
    private int H;
    private boolean I;
    private int J;
    private int K;
    private int L;
    private int M;
    public boolean N;
    private Handler P;
    private ViewGroup Q;
    private View R;
    private View S;
    private View T;
    private RecyclerView U;
    private h V;
    private int W;
    private int X;
    private View.OnTouchListener Y;
    public f.c Z;

    /* renamed from: a0, reason: collision with root package name */
    public f.c f60498a0;

    /* renamed from: b0, reason: collision with root package name */
    public f.c f60499b0;

    /* renamed from: c0, reason: collision with root package name */
    public f.c f60500c0;

    /* renamed from: d0, reason: collision with root package name */
    public f.c f60501d0;

    /* renamed from: e0, reason: collision with root package name */
    public f.c f60502e0;

    /* renamed from: f0, reason: collision with root package name */
    public f.c f60503f0;

    /* renamed from: g0, reason: collision with root package name */
    public f.c f60504g0;

    /* renamed from: h0, reason: collision with root package name */
    public f.c f60505h0;

    /* renamed from: i0, reason: collision with root package name */
    public f.c f60506i0;

    /* renamed from: j0, reason: collision with root package name */
    public f.c f60507j0;

    /* renamed from: k0, reason: collision with root package name */
    public f.c f60508k0;

    /* renamed from: l0, reason: collision with root package name */
    public f.c f60509l0;

    /* renamed from: m0, reason: collision with root package name */
    public f.c f60510m0;

    /* renamed from: n0, reason: collision with root package name */
    public f.c f60511n0;

    /* renamed from: o0, reason: collision with root package name */
    public f.c f60512o0;

    /* renamed from: p0, reason: collision with root package name */
    public f.c f60513p0;

    /* renamed from: q0, reason: collision with root package name */
    public f.c f60514q0;

    /* renamed from: r0, reason: collision with root package name */
    public f.b f60515r0;

    /* renamed from: s0, reason: collision with root package name */
    public f.c f60516s0;

    /* renamed from: t0, reason: collision with root package name */
    public f.d f60517t0;

    /* renamed from: u0, reason: collision with root package name */
    public f.c f60518u0;

    /* renamed from: v0, reason: collision with root package name */
    public f.c f60519v0;

    /* renamed from: w0, reason: collision with root package name */
    public f.c f60520w0;

    /* renamed from: x0, reason: collision with root package name */
    public f.c f60521x0;

    /* renamed from: y0, reason: collision with root package name */
    private String f60522y0;

    /* renamed from: z0, reason: collision with root package name */
    private String f60523z0;
    private static final Drawable F0 = new ColorDrawable(HWColorFormat.COLOR_FormatVendorStartUnused);
    private static final Drawable Z0 = h2(R.drawable.qzone_skin_dropdown_btm_bg);

    /* renamed from: a1, reason: collision with root package name */
    private static final Drawable f60492a1 = h2(R.drawable.qzone_skin_dropdown_top_bg);

    /* renamed from: c1, reason: collision with root package name */
    private static Drawable f60494c1 = h2(R.drawable.qzone_skin_feed_dropmenu_icon_check_dress);

    /* renamed from: d1, reason: collision with root package name */
    private static Drawable f60495d1 = h2(R.drawable.qzone_skin_feed_dropmenu_icon_send_msg);

    /* renamed from: e1, reason: collision with root package name */
    private static final SpringConfig f60496e1 = SpringConfig.fromOrigamiTensionAndFriction(60.0d, 8.0d);

    /* renamed from: f1, reason: collision with root package name */
    private static int f60497f1 = 123;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != QzoneBottomSheetMenuMore.f60497f1 || QzoneBottomSheetMenuMore.this.V == null) {
                return;
            }
            QzoneBottomSheetMenuMore.this.V.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ap.f59791b.e(39, 1, 0, QzoneBottomSheetMenuMore.this.D);
            QzoneBottomSheetMenuMore.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QzoneBottomSheetMenuMore.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ap.f59791b.e(70, 1, 0, QzoneBottomSheetMenuMore.this.D);
            QzoneBottomSheetMenuMore.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class e implements View.OnTouchListener {

        /* compiled from: P */
        /* loaded from: classes37.dex */
        class a extends AnimatorListenerAdapter {
            a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                QzoneBottomSheetMenuMore.this.T.setAlpha(0.0f);
                QzoneBottomSheetMenuMore.this.k1();
            }
        }

        e() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 1) {
                int top = QzoneBottomSheetMenuMore.this.T.getTop();
                if (top > QzoneBottomSheetMenuMore.this.X) {
                    top = QzoneBottomSheetMenuMore.this.X;
                }
                float f16 = top;
                float f17 = f16 / QzoneBottomSheetMenuMore.this.X;
                AnimatorSet animatorSet = new AnimatorSet();
                if (f17 < 0.25f) {
                    long j3 = (1.0f - f17) * 200.0f;
                    QzoneBottomSheetMenuMore.this.T.layout(QzoneBottomSheetMenuMore.this.T.getLeft(), 0, QzoneBottomSheetMenuMore.this.T.getRight(), QzoneBottomSheetMenuMore.this.X);
                    QzoneBottomSheetMenuMore.this.R.setAlpha(0.5f);
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(QzoneBottomSheetMenuMore.this.T, (Property<View, Float>) View.TRANSLATION_Y, f16, 0.0f);
                    ofFloat.setDuration(j3);
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(QzoneBottomSheetMenuMore.this.R, (Property<View, Float>) View.ALPHA, 0.5f);
                    ofFloat2.setDuration(j3);
                    animatorSet.playTogether(ofFloat, ofFloat2);
                    animatorSet.start();
                } else {
                    long j16 = f17 * 200.0f;
                    ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(QzoneBottomSheetMenuMore.this.T, (Property<View, Float>) View.TRANSLATION_Y, f16, QzoneBottomSheetMenuMore.this.X);
                    ofFloat3.setDuration(j16);
                    ofFloat3.addListener(new a());
                    ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(QzoneBottomSheetMenuMore.this.R, (Property<View, Float>) View.ALPHA, 0.0f);
                    ofFloat4.setDuration(j16);
                    animatorSet.playTogether(ofFloat3, ofFloat4);
                    animatorSet.start();
                }
                QzoneBottomSheetMenuMore.this.W = -1;
            } else if (action == 2) {
                if (QzoneBottomSheetMenuMore.this.W == -1) {
                    QzoneBottomSheetMenuMore.this.W = (int) motionEvent.getRawY();
                } else {
                    int rawY = ((int) motionEvent.getRawY()) - QzoneBottomSheetMenuMore.this.W;
                    int left = QzoneBottomSheetMenuMore.this.T.getLeft();
                    int right = QzoneBottomSheetMenuMore.this.T.getRight();
                    int top2 = QzoneBottomSheetMenuMore.this.T.getTop();
                    int bottom = QzoneBottomSheetMenuMore.this.T.getBottom();
                    int i3 = top2 + rawY;
                    if (i3 >= 0) {
                        QzoneBottomSheetMenuMore.this.T.layout(left, i3, right, bottom + rawY);
                        QzoneBottomSheetMenuMore.this.W = (int) motionEvent.getRawY();
                    }
                    float f18 = ((QzoneBottomSheetMenuMore.this.X - top2) - rawY) / QzoneBottomSheetMenuMore.this.X;
                    if (f18 <= 1.0d) {
                        QzoneBottomSheetMenuMore.this.R.setAlpha(f18 * 0.5f);
                    }
                }
            }
            return view.getId() == R.id.f166018bg4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class g implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f60533d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ BusinessFeedData f60534e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ f.a f60535f;

        g(int i3, BusinessFeedData businessFeedData, f.a aVar) {
            this.f60533d = i3;
            this.f60534e = businessFeedData;
            this.f60535f = aVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QzoneBottomSheetMenuMore.this.K2(this.f60533d, this.f60534e, this.f60535f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class i extends RecyclerView.ViewHolder {
        public f.a E;
        public TextView F;
        public TextView G;
        public AsyncImageView H;
        public FrameLayout I;
        public FrameLayout J;
        public FrameLayout K;
        public TextView L;
        public CommonLine M;

        public i(View view) {
            super(view);
            this.F = (TextView) view.findViewById(R.id.eq7);
            this.H = (AsyncImageView) view.findViewById(R.id.e7j);
            this.G = (TextView) view.findViewById(R.id.f166043e81);
            this.I = (FrameLayout) view.findViewById(R.id.bqh);
            this.J = (FrameLayout) view.findViewById(R.id.bqi);
            this.K = (FrameLayout) view.findViewById(R.id.bqg);
            this.L = (TextView) view.findViewById(R.id.iah);
            this.M = (CommonLine) view.findViewById(R.id.bqe);
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface j {
        boolean a(CellFeedCommInfo cellFeedCommInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class k implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        private f.a f60538d;

        public k(f.a aVar) {
            this.f60538d = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (this.f60538d != null) {
                if (view.getId() == R.id.bqh) {
                    QzoneBottomSheetMenuMore qzoneBottomSheetMenuMore = QzoneBottomSheetMenuMore.this;
                    qzoneBottomSheetMenuMore.I2(qzoneBottomSheetMenuMore.M, QzoneBottomSheetMenuMore.this.D);
                    QzoneBottomSheetMenuMore qzoneBottomSheetMenuMore2 = QzoneBottomSheetMenuMore.this;
                    qzoneBottomSheetMenuMore2.Z1(qzoneBottomSheetMenuMore2.M, QzoneBottomSheetMenuMore.this.D, this.f60538d, 33, false);
                    QzoneBottomSheetMenuMore.this.dismiss();
                } else if (view.getId() == R.id.bqi) {
                    QzoneBottomSheetMenuMore qzoneBottomSheetMenuMore3 = QzoneBottomSheetMenuMore.this;
                    qzoneBottomSheetMenuMore3.J2(qzoneBottomSheetMenuMore3.M, QzoneBottomSheetMenuMore.this.D);
                    QzoneBottomSheetMenuMore qzoneBottomSheetMenuMore4 = QzoneBottomSheetMenuMore.this;
                    qzoneBottomSheetMenuMore4.Z1(qzoneBottomSheetMenuMore4.M, QzoneBottomSheetMenuMore.this.D, this.f60538d, 34, false);
                    QzoneBottomSheetMenuMore.this.dismiss();
                } else if (view.getId() != R.id.bqg) {
                    QzoneBottomSheetMenuMore.this.G2(this.f60538d);
                } else {
                    QzoneBottomSheetMenuMore qzoneBottomSheetMenuMore5 = QzoneBottomSheetMenuMore.this;
                    qzoneBottomSheetMenuMore5.H2(qzoneBottomSheetMenuMore5.M, QzoneBottomSheetMenuMore.this.D);
                    QzoneBottomSheetMenuMore qzoneBottomSheetMenuMore6 = QzoneBottomSheetMenuMore.this;
                    qzoneBottomSheetMenuMore6.Z1(qzoneBottomSheetMenuMore6.M, QzoneBottomSheetMenuMore.this.D, this.f60538d, 35, false);
                    QzoneBottomSheetMenuMore.this.dismiss();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private boolean A2() {
        BusinessFeedData businessFeedData = this.D;
        return (businessFeedData == null || businessFeedData.getUser() == null || this.D.getUser().uin == LoginData.getInstance().getUin()) ? false : true;
    }

    private void B1(s_droplist_option s_droplist_optionVar) {
        String str;
        f.a a16 = f.a.a();
        a16.f60854a = 6;
        if (s_droplist_optionVar == null) {
            str = m2(6);
        } else {
            str = s_droplist_optionVar.optext;
        }
        a16.f60856c = str;
        a16.f60857d = s_droplist_optionVar;
        this.V.i0(a16);
    }

    private boolean B2() {
        BusinessFeedData businessFeedData;
        return (w2() || (businessFeedData = this.D) == null || businessFeedData.isSecretFeed() || this.D.isFrdLikeMiniAppContainer() || this.D.isQQLiveFeed() || this.D.isFakeFeedSafe()) ? false : true;
    }

    private boolean D2(CellFeedCommInfo cellFeedCommInfo) {
        j jVar = this.E0;
        if (jVar == null) {
            return cellFeedCommInfo != null && cellFeedCommInfo.isTopFeed();
        }
        return jVar.a(cellFeedCommInfo);
    }

    private void E1(s_droplist_option s_droplist_optionVar) {
        String str;
        f.a a16 = f.a.a();
        a16.f60854a = 18;
        if (s_droplist_optionVar == null) {
            str = this.f60522y0;
        } else {
            str = s_droplist_optionVar.optext;
        }
        a16.f60856c = str;
        a16.f60857d = s_droplist_optionVar;
        this.V.i0(a16);
    }

    private void F2(int i3, BusinessFeedData businessFeedData) {
        f.c cVar = this.f60512o0;
        if (cVar != null) {
            cVar.a(i3, businessFeedData);
        }
    }

    private void G1(s_droplist_option s_droplist_optionVar) {
        String str;
        f.a a16 = f.a.a();
        a16.f60857d = s_droplist_optionVar;
        a16.f60854a = 15;
        if (s_droplist_optionVar != null) {
            str = s_droplist_optionVar.optext;
        } else {
            str = this.f60523z0;
        }
        a16.f60856c = str;
        this.V.i0(a16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G2(f.a aVar) {
        switch (aVar.f60854a) {
            case 1:
                e2(this.M, this.D);
                break;
            case 2:
                V1(this.M, this.D);
                break;
            case 3:
                T1(this.M, this.D, aVar);
                break;
            case 4:
                s2(this.M, this.D);
                break;
            case 5:
                int i3 = this.M;
                BusinessFeedData businessFeedData = this.D;
                if (businessFeedData.isSubFeed) {
                    i3 = businessFeedData.containerIndex;
                }
                r2(i3, businessFeedData);
                break;
            case 6:
                N2(this.M, this.D, aVar);
                break;
            case 7:
                P2(this.M, this.D);
                break;
            case 8:
                V2(this.M, this.D);
                break;
            case 9:
                W2(this.M, this.D);
                break;
            case 10:
                T2(this.M, this.D);
                break;
            case 11:
                F2(this.M, this.D);
                break;
            case 12:
                S1(this.M, this.D);
                break;
            case 13:
                a2(this.M, this.D);
                break;
            case 14:
                Z1(this.M, this.D, aVar, -1, false);
                break;
            case 15:
                c2(this.M, this.D);
                break;
            case 16:
                q2(this.M, this.D);
                break;
            case 18:
                L2(this.M, this.D, aVar);
                break;
            case 19:
                Q2(this.M, this.D);
                break;
            case 21:
                BusinessFeedData businessFeedData2 = this.D;
                if (businessFeedData2 == null || !businessFeedData2.hasDropdownFinishedAddFriend) {
                    w1(this.M, businessFeedData2);
                    break;
                }
                break;
            case 22:
                S2(this.M, this.D);
                break;
            case 23:
                M1(this.M, this.D);
                break;
            case 24:
                M2(this.M, this.D);
                break;
        }
        dismiss();
    }

    private void K1(s_droplist_option s_droplist_optionVar) {
        String str;
        f.a a16 = f.a.a();
        a16.f60857d = s_droplist_optionVar;
        a16.f60854a = 11;
        if (s_droplist_optionVar != null) {
            str = s_droplist_optionVar.optext;
        } else {
            str = this.A0;
        }
        a16.f60856c = str;
        this.V.i0(a16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean O1(int i3) {
        if (this.D == null) {
            return false;
        }
        return com.qzone.proxy.feedcomponent.util.d.j(r0.getFeedCommInfo().operatemask, i3);
    }

    private boolean P1(int i3) {
        return com.qzone.proxy.feedcomponent.util.d.j(this.D.getFeedCommInfo().operatemask2, i3);
    }

    private static boolean Q1(int i3, int i16) {
        if ((i3 & (1 << i16)) != 0) {
            return true;
        }
        return false;
    }

    private void Q2(int i3, BusinessFeedData businessFeedData) {
        f.c cVar = this.f60518u0;
        if (cVar != null) {
            cVar.a(i3, businessFeedData);
        }
    }

    private boolean R1(int i3) {
        return com.qzone.proxy.feedcomponent.util.d.j(this.D.getFeedCommInfo().operatemask3, i3);
    }

    private void S1(int i3, BusinessFeedData businessFeedData) {
        f.c cVar = this.f60513p0;
        if (cVar != null) {
            cVar.a(i3, businessFeedData);
        }
    }

    private void T2(int i3, BusinessFeedData businessFeedData) {
        f.c cVar = this.f60508k0;
        if (cVar != null) {
            cVar.a(i3, businessFeedData);
        }
    }

    private void U1() {
        int i3;
        if (this.C == null || this.D == null) {
            return;
        }
        this.F = y2();
        this.E = k2();
        boolean q16 = com.qzone.proxy.feedcomponent.util.d.q(this.C, this.D);
        BusinessFeedData businessFeedData = this.D;
        boolean z16 = false;
        if (businessFeedData.isEventTagFeed) {
            q16 = false;
        }
        if (this.V == null || this.U == null) {
            return;
        }
        int i16 = businessFeedData.getFeedCommInfo().operatemask;
        int i17 = this.D.getFeedCommInfo().operatemask2;
        int i18 = this.D.getPermissionInfo().permission_visit;
        if (this.E < 0 && this.G == i16 && this.H == i17 && i18 == this.J && q16 == this.I && !this.D.hasCustomDropList()) {
            return;
        }
        this.V.clear();
        VideoInfo videoInfo = this.D.getVideoInfo();
        if (videoInfo != null && ((i3 = videoInfo.videoStatus) == 4 || i3 == 7)) {
            z16 = true;
        }
        I1();
        if (Q1(i17, 10)) {
            f.a a16 = f.a.a();
            a16.f60854a = 21;
            a16.f60856c = m2(21);
            this.V.i0(a16);
        }
        v1(z16, q16);
        y1();
        n1();
        F1();
        z1();
        x1();
        if (!z2()) {
            l1();
        }
        u1();
        J1();
        t1();
        A1();
        r1();
        L1();
        m1();
        C1();
        if (z2() && !this.D.isFrdLikeVideoContainer() && !this.D.isFriendLikeVerticalSlideContainer() && !this.D.isPublicAccountContainer() && !this.D.isPublicAccountContent() && !this.D.isFriendPlayingFeed()) {
            l1();
        }
        if (this.D.hasCustomDropList()) {
            u2(z16);
        }
        this.I = q16;
        this.G = i16;
        this.H = i17;
        this.J = i18;
        this.V.notifyDataSetChanged();
    }

    private void a2(int i3, BusinessFeedData businessFeedData) {
        f.c cVar = this.f60514q0;
        if (cVar != null) {
            cVar.a(i3, businessFeedData);
        }
    }

    private void c2(int i3, BusinessFeedData businessFeedData) {
        f.c cVar = this.f60516s0;
        if (cVar != null) {
            cVar.a(i3, businessFeedData);
        }
    }

    private Drawable d2(int i3, String str, int i16) {
        return ResDownloadManger.getmInstance().getDrawableAsync(i3, str, new f());
    }

    private Drawable f2() {
        if (com.qzone.adapter.feedcomponent.i.H().p1()) {
            return new ColorDrawable(-14145496);
        }
        return new ColorDrawable(-1);
    }

    private Drawable g2() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        boolean p16 = com.qzone.adapter.feedcomponent.i.H().p1();
        GradientDrawable gradientDrawable = new GradientDrawable();
        int i3 = AreaConst.dp6;
        gradientDrawable.setCornerRadius(i3);
        gradientDrawable.setColor(p16 ? -16777216 : -2828580);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius(i3);
        gradientDrawable2.setColor(p16 ? -16777216 : -1184779);
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, gradientDrawable);
        stateListDrawable.addState(new int[0], gradientDrawable2);
        return stateListDrawable;
    }

    public static Drawable h2(int i3) {
        try {
            FeedGlobalEnv.g();
            return FeedGlobalEnv.getApplication().getResources().getDrawable(i3);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String i2() {
        if (!this.F) {
            return n2(R.string.gfa);
        }
        return n2(R.string.gfb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String j2() {
        BusinessFeedData businessFeedData = this.D;
        if (businessFeedData != null && D2(businessFeedData.getFeedCommInfo())) {
            return n2(R.string.gf_);
        }
        return n2(R.string.gfk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k1() {
        try {
            super.dismiss();
        } catch (Exception unused) {
        } catch (Throwable th5) {
            sy3.a.a(this);
            throw th5;
        }
        sy3.a.a(this);
    }

    private int k2() {
        BusinessFeedData businessFeedData;
        BusinessFeedData businessFeedData2;
        BusinessFeedData businessFeedData3 = this.D;
        boolean z16 = (businessFeedData3 == null || (businessFeedData2 = businessFeedData3.parentFeedData) == null || (!businessFeedData2.isFriendLikeContainer() && !this.D.parentFeedData.isFrdLikeMiniAppContainer())) ? false : true;
        BusinessFeedData businessFeedData4 = this.D;
        boolean z17 = (businessFeedData4 == null || (businessFeedData = businessFeedData4.parentFeedData) == null || !businessFeedData.isCardSpecialFollowMoreRecommendContainerFeed()) ? false : true;
        if (z16 || z17) {
            return -1;
        }
        if (O1(27) || O1(20)) {
            return this.D.getFeedCommInfo().isFollowed ? 9 : 8;
        }
        return -1;
    }

    private void l1() {
        if (B2()) {
            f.a a16 = f.a.a();
            a16.f60854a = 23;
            a16.f60856c = m2(23);
            this.V.i0(a16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable l2() {
        ColorDrawable colorDrawable;
        ColorDrawable colorDrawable2;
        StateListDrawable stateListDrawable = new StateListDrawable();
        boolean p16 = com.qzone.adapter.feedcomponent.i.H().p1();
        int[] iArr = {android.R.attr.state_pressed};
        if (p16) {
            colorDrawable = new ColorDrawable(-14869219);
        } else {
            colorDrawable = new ColorDrawable(-1315339);
        }
        stateListDrawable.addState(iArr, colorDrawable);
        int[] iArr2 = new int[0];
        if (p16) {
            colorDrawable2 = new ColorDrawable(-14145496);
        } else {
            colorDrawable2 = new ColorDrawable(-1);
        }
        stateListDrawable.addState(iArr2, colorDrawable2);
        return stateListDrawable;
    }

    public static String n2(int i3) {
        try {
            FeedGlobalEnv.g();
            return FeedGlobalEnv.getApplication().getResources().getString(i3);
        } catch (Exception unused) {
            return "";
        }
    }

    private void o1(s_droplist_option s_droplist_optionVar) {
        String str;
        f.a a16 = f.a.a();
        a16.f60854a = 3;
        if (s_droplist_optionVar == null) {
            str = i2();
        } else {
            str = s_droplist_optionVar.optext;
        }
        a16.f60856c = str;
        a16.f60857d = s_droplist_optionVar;
        this.V.i0(a16);
    }

    private void p1(s_droplist_option s_droplist_optionVar) {
        f.a a16 = f.a.a();
        a16.f60854a = 14;
        a16.f60856c = s_droplist_optionVar == null ? null : s_droplist_optionVar.optext;
        a16.f60857d = s_droplist_optionVar;
        int i3 = this.L;
        if (i3 != -1) {
            a16.f60858e = i3;
        }
        this.V.i0(a16);
    }

    private Drawable p2() {
        boolean p16 = com.qzone.adapter.feedcomponent.i.H().p1();
        GradientDrawable gradientDrawable = new GradientDrawable();
        int i3 = AreaConst.dp6;
        gradientDrawable.setCornerRadii(new float[]{i3, i3, i3, i3, 0.0f, 0.0f, 0.0f, 0.0f});
        gradientDrawable.setColor(p16 ? -14145496 : -1);
        return gradientDrawable;
    }

    private void q2(int i3, BusinessFeedData businessFeedData) {
        f.c cVar = this.f60502e0;
        if (cVar != null) {
            cVar.a(i3, businessFeedData);
        }
    }

    private void r1() {
        if (this.E < 0) {
            return;
        }
        if (O1(27) || O1(20)) {
            f.a a16 = f.a.a();
            int i3 = this.E;
            a16.f60854a = i3;
            a16.f60856c = m2(i3);
            this.V.i0(a16);
        }
    }

    private void t2() {
        h hVar = new h(this.C);
        this.V = hVar;
        this.U.setAdapter(hVar);
    }

    private void u2(boolean z16) {
        Iterator<s_droplist_option> it = this.D.getFeedCommInfo().customDroplist.iterator();
        int i3 = -1;
        while (it.hasNext()) {
            s_droplist_option next = it.next();
            i3++;
            if (this.V == null) {
                this.V = new h(this.C);
            }
            if (next != null) {
                this.L = i3;
                if (next.actiontype != 38 || z16) {
                    if (!C2(next)) {
                        int i16 = next.actiontype;
                        if (i16 == 39) {
                            o1(next);
                        } else if (i16 == 41) {
                            B1(next);
                        } else if (i16 == 42) {
                            K1(next);
                        } else if (i16 == 43) {
                            G1(next);
                        } else {
                            p1(next);
                        }
                    } else {
                        E1(next);
                    }
                }
            }
        }
    }

    private void v2() {
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_LEBA_NEW, 4, "qzonepouwindow:\u5f00\u59cb\u521d\u59cb\u5316");
        }
        M0 = d2(ResDownloadManger.getQzoneSkinFeedDropMenuResId(), "qzone_skin_feed_dropmenu_reprinted", 1);
        S0 = d2(ResDownloadManger.getQzoneSkinFeedDropMenuResId(), "qzone_skin_feed_dropmenu_yellow_diamond", 2);
        G0 = d2(ResDownloadManger.getQzoneSkinFeedDropMenuResId(), "qzone_skin_feed_dropmenu_edit", 3);
        H0 = d2(ResDownloadManger.getQzoneSkinFeedDropMenuResId(), "qzone_skin_feed_dropmenu_icon_delete", 4);
        I0 = d2(ResDownloadManger.getQzoneSkinFeedDropMenuResId(), "qzone_skin_feed_dropmenu_report", 5);
        J0 = d2(ResDownloadManger.getQzoneSkinFeedDropMenuResId(), "qzone_skin_feed_dropmenu_share", 6);
        K0 = d2(ResDownloadManger.getQzoneSkinFeedDropMenuResId(), "qzone_skin_feed_dropmenu_collect", 7);
        L0 = d2(ResDownloadManger.getQzoneSkinFeedDropMenuResId(), "qzone_skin_feed_dropmenu_collect_cancel", 8);
        P0 = d2(ResDownloadManger.getQzoneSkinFeedDropMenuResId(), "qzone_skin_feed_dropmenu_hide", 9);
        Q0 = d2(ResDownloadManger.getQzoneSkinFeedDropMenuResId(), "qzone_skin_feed_dropmenu_not_see", 10);
        R0 = d2(ResDownloadManger.getQzoneSkinFeedDropMenuResId(), "qzone_skin_feed_dropmenu_top", 11);
        V0 = d2(ResDownloadManger.getQzoneSkinFeedDropMenuResId(), "qzone_skin_feed_dropmenu_not_see", 12);
        T0 = d2(ResDownloadManger.getQzoneSkinFeedDropMenuResId(), "qzone_skin_feed_dropmenu_not_interested", 13);
        U0 = d2(ResDownloadManger.getQzoneSkinFeedDropMenuResId(), "qzone_skin_feed_dropmenu_close_feed", 14);
        O0 = d2(ResDownloadManger.getQzoneSkinFeedDropMenuResId(), "qzone_skin_feed_dropmenu_unsubscribe", 15);
        N0 = d2(ResDownloadManger.getQzoneSkinFeedDropMenuResId(), "qzone_skin_feed_dropmenu_subscribe", 16);
        W0 = d2(ResDownloadManger.getQzoneSkinFeedDropMenuResId(), "qzone_skin_feed_dropmenu_add_friend", 17);
        X0 = d2(ResDownloadManger.getQzoneSkinFeedDropMenuResId(), "qzone_skin_feed_dropmenu_already_add_friend", 18);
        f60493b1 = d2(ResDownloadManger.getQzoneSkinFeedDropMenuResId(), "qzone_skin_feed_dropmenu_download", 19);
        Y0 = d2(ResDownloadManger.getQzoneSkinFeedDropMenuResId(), "qzone_skin_feed_dropmenu_set_private", 20);
        h hVar = this.V;
        if (hVar != null) {
            hVar.notifyDataSetChanged();
        }
    }

    private void y1() {
        if (Q1(this.D.getFeedCommInfo().operatemask2, 6)) {
            f.a a16 = f.a.a();
            a16.f60854a = 16;
            a16.f60856c = m2(16);
            this.V.i0(a16);
        }
    }

    private boolean y2() {
        String str;
        BusinessFeedData businessFeedData = this.D;
        if (businessFeedData == null) {
            QZLog.w("QzoneBottomSheetMenuMore", "[isFavorited] mFeedData is null");
            return false;
        }
        if (!businessFeedData.isFriendLikeVerticalSlideContainer() && !this.D.isFrdLikeVideoContainer()) {
            if (this.D.getFeedCommInfo() == null) {
                return false;
            }
            return QzoneFavoriteService.M().R(this.D.getFeedCommInfo().ugckey);
        }
        ArrayList<BusinessFeedData> recBusinessFeedDatas = this.D.getRecBusinessFeedDatas();
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
                    QZLog.d("QzoneBottomSheetMenuMore", 2, str);
                }
            } else if (businessFeedData2.getFeedCommInfo() == null || !QzoneFavoriteService.M().R(businessFeedData2.getFeedCommInfo().ugckey)) {
                if (!QZLog.isColorLevel()) {
                    return false;
                }
                QZLog.d("QzoneBottomSheetMenuMore", 2, "[isFavorited] feed:" + businessFeedData2.getFeedCommInfo().ugckey + " not favorite");
                return false;
            }
        }
        return true;
    }

    private boolean z2() {
        BusinessFeedData businessFeedData = this.D;
        return businessFeedData == null || businessFeedData.getUser().uin != LoginData.getInstance().getUin();
    }

    @Override // com.qzone.widget.f
    public void H(int i3, f.d dVar) {
        this.f60517t0 = dVar;
    }

    public boolean N1(int i3, int i16) {
        if ((i3 & i16) != 0) {
            return true;
        }
        return false;
    }

    public void U2(j jVar) {
        this.E0 = jVar;
    }

    @Override // com.qzone.widget.f
    public boolean j() {
        return isShowing();
    }

    @Override // com.qzone.widget.f
    public BusinessFeedData o() {
        return this.D;
    }

    @Override // com.qzone.widget.f
    public void p() {
        dismiss();
    }

    @Override // com.qzone.widget.f
    public void w(int i3, f.b bVar) {
        this.f60515r0 = bVar;
    }

    public boolean w2() {
        CellFeedCommInfo feedCommInfo;
        BusinessFeedData businessFeedData = this.D;
        return (businessFeedData == null || businessFeedData.getFeedCommInfo() == null || (feedCommInfo = this.D.getFeedCommInfo()) == null || (!feedCommInfo.isVideoAdv() && !feedCommInfo.isAppAdvFeed() && !feedCommInfo.isFamousRecommAdvFeed() && !feedCommInfo.isVideoAdvShareFeed())) ? false : true;
    }

    private void C1() {
        if (P1(2)) {
            f.a a16 = f.a.a();
            a16.f60854a = 13;
            a16.f60856c = m2(13);
            this.V.i0(a16);
        }
    }

    private void F1() {
        if (O1(7) && A2()) {
            f.a a16 = f.a.a();
            a16.f60854a = 7;
            a16.f60856c = m2(7);
            this.V.i0(a16);
        }
    }

    private void I1() {
        if (R1(2)) {
            f.a a16 = f.a.a();
            a16.f60854a = 24;
            a16.f60856c = m2(24);
            this.V.i0(a16);
        }
    }

    private void init() {
        QZLog.d("QzoneBottomSheetMenuMore", 4, "init");
        LayoutInflater from = LayoutInflater.from(this.C);
        Window window = getWindow();
        if (window != null) {
            ImmersiveUtils.clearCoverForStatus(window, true);
        }
        ViewGroup viewGroup = (ViewGroup) from.inflate(R.layout.any, (ViewGroup) null);
        this.Q = viewGroup;
        setContentView(viewGroup);
        v2();
        this.R = this.Q.findViewById(R.id.f166008bf3);
        this.S = this.Q.findViewById(R.id.e38);
        this.T = this.Q.findViewById(R.id.f166018bg4);
        RecyclerView recyclerView = (RecyclerView) this.Q.findViewById(R.id.f166069ec1);
        this.U = recyclerView;
        recyclerView.setNestedScrollingEnabled(false);
        this.U.setLayoutManager(new LinearLayoutManager(this.C));
        Button button = (Button) this.Q.findViewById(R.id.afr);
        button.setOnClickListener(new b());
        View findViewById = findViewById(R.id.jmz);
        View findViewById2 = findViewById(R.id.e3y);
        View findViewById3 = findViewById(R.id.f166009gg2);
        button.setBackground(g2());
        findViewById.setBackground(p2());
        findViewById3.setBackground(f2());
        findViewById2.setBackground(f2());
        findViewById(R.id.f165911ba4).setOnClickListener(new c());
        ((View) this.Q.getParent()).setOnClickListener(new d());
        e eVar = new e();
        this.Y = eVar;
        this.T.setOnTouchListener(eVar);
        this.U.setOnTouchListener(this.Y);
    }

    private void m1() {
        if (P1(0)) {
            f.a a16 = f.a.a();
            a16.f60854a = 12;
            a16.f60856c = m2(12);
            this.V.i0(a16);
        }
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        QZLog.d("QzoneBottomSheetMenuMore", 4, "dismiss");
        this.P.postDelayed(new Runnable() { // from class: com.qzone.widget.QzoneBottomSheetMenuMore.7

            /* compiled from: P */
            /* renamed from: com.qzone.widget.QzoneBottomSheetMenuMore$7$a */
            /* loaded from: classes37.dex */
            class a extends AnimatorListenerAdapter {
                a() {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    QzoneBottomSheetMenuMore.this.T.setAlpha(0.0f);
                    QzoneBottomSheetMenuMore.this.k1();
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                AnimatorSet animatorSet = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(QzoneBottomSheetMenuMore.this.T, (Property<View, Float>) View.TRANSLATION_Y, 0.0f, QzoneBottomSheetMenuMore.this.T.getHeight());
                ofFloat.setDuration(200L);
                ofFloat.addListener(new a());
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(QzoneBottomSheetMenuMore.this.R, (Property<View, Float>) View.ALPHA, 0.5f, 0.0f);
                ofFloat2.setDuration(200L);
                animatorSet.playTogether(ofFloat, ofFloat2);
                animatorSet.start();
            }
        }, 0L);
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        QZLog.d("QzoneBottomSheetMenuMore", 4, "show");
        this.T.setAlpha(0.0f);
        this.S.setVisibility(0);
        super.show();
        U1();
        this.P.postDelayed(new Runnable() { // from class: com.qzone.widget.QzoneBottomSheetMenuMore.6

            /* compiled from: P */
            /* renamed from: com.qzone.widget.QzoneBottomSheetMenuMore$6$a */
            /* loaded from: classes37.dex */
            class a extends AnimatorListenerAdapter {
                a() {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    QzoneBottomSheetMenuMore.this.T.setAlpha(1.0f);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                AnimatorSet animatorSet = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(QzoneBottomSheetMenuMore.this.T, (Property<View, Float>) View.TRANSLATION_Y, QzoneBottomSheetMenuMore.this.T.getHeight(), 0.0f);
                ofFloat.setDuration(200L);
                ofFloat.addListener(new a());
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(QzoneBottomSheetMenuMore.this.R, (Property<View, Float>) View.ALPHA, 0.0f, 0.5f);
                ofFloat2.setDuration(200L);
                animatorSet.playTogether(ofFloat, ofFloat2);
                animatorSet.start();
                QzoneBottomSheetMenuMore qzoneBottomSheetMenuMore = QzoneBottomSheetMenuMore.this;
                qzoneBottomSheetMenuMore.X = qzoneBottomSheetMenuMore.T.getHeight();
            }
        }, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class h extends RecyclerView.Adapter<i> {
        private LayoutInflater C;
        private List<f.a> D = new ArrayList();

        /* renamed from: m, reason: collision with root package name */
        private Context f60537m;

        public h(Context context) {
            this.f60537m = context;
            this.C = LayoutInflater.from(context);
        }

        private void m0(f.a aVar, i iVar) {
            s_droplist_option s_droplist_optionVar = aVar.f60857d;
            Drawable drawable = null;
            if (s_droplist_optionVar != null && !TextUtils.isEmpty(s_droplist_optionVar.iconurl)) {
                iVar.H.setAsyncImage(an.a(aVar.f60857d.iconurl));
                iVar.F.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                iVar.H.setVisibility(0);
                return;
            }
            iVar.F.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            switch (aVar.f60854a) {
                case 0:
                    drawable = QzoneBottomSheetMenuMore.J0;
                    break;
                case 1:
                    drawable = QzoneBottomSheetMenuMore.G0;
                    break;
                case 2:
                    drawable = QzoneBottomSheetMenuMore.H0;
                    break;
                case 3:
                    drawable = QzoneBottomSheetMenuMore.this.F ? QzoneBottomSheetMenuMore.L0 : QzoneBottomSheetMenuMore.K0;
                    break;
                case 4:
                    drawable = QzoneBottomSheetMenuMore.P0;
                    break;
                case 5:
                    drawable = QzoneBottomSheetMenuMore.Q0;
                    break;
                case 6:
                    drawable = QzoneBottomSheetMenuMore.I0;
                    break;
                case 7:
                    drawable = QzoneBottomSheetMenuMore.M0;
                    break;
                case 8:
                    drawable = QzoneBottomSheetMenuMore.N0;
                    break;
                case 9:
                    drawable = QzoneBottomSheetMenuMore.O0;
                    break;
                case 10:
                    iVar.F.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, QzoneBottomSheetMenuMore.S0, (Drawable) null);
                    drawable = QzoneBottomSheetMenuMore.R0;
                    break;
                case 11:
                    drawable = QzoneBottomSheetMenuMore.T0;
                    break;
                case 12:
                    drawable = QzoneBottomSheetMenuMore.U0;
                    break;
                case 13:
                    drawable = QzoneBottomSheetMenuMore.Q0;
                    break;
                case 15:
                    drawable = QzoneBottomSheetMenuMore.Q0;
                    break;
                case 16:
                    drawable = QzoneBottomSheetMenuMore.V0;
                    break;
                case 19:
                    drawable = QzoneBottomSheetMenuMore.f60493b1;
                    break;
                case 21:
                    if (QzoneBottomSheetMenuMore.this.D == null || !QzoneBottomSheetMenuMore.this.D.hasDropdownFinishedAddFriend) {
                        drawable = QzoneBottomSheetMenuMore.W0;
                        break;
                    } else {
                        drawable = QzoneBottomSheetMenuMore.X0;
                        break;
                    }
                    break;
                case 22:
                    drawable = QzoneBottomSheetMenuMore.Y0;
                    break;
                case 23:
                    drawable = QzoneBottomSheetMenuMore.f60494c1;
                    break;
                case 24:
                    drawable = QzoneBottomSheetMenuMore.f60495d1;
                    break;
            }
            if (drawable != null) {
                iVar.H.setImageDrawable(drawable);
                iVar.H.setVisibility(0);
            }
        }

        public void clear() {
            Iterator<f.a> it = this.D.iterator();
            while (it.hasNext()) {
                f.a.b(it.next());
            }
            this.D.clear();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.D.size();
        }

        public List<f.a> j0() {
            return this.D;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(i iVar, int i3) {
            iVar.itemView.setBackground(QzoneBottomSheetMenuMore.this.l2());
            if (i3 == getItemCount() - 1) {
                iVar.M.setVisibility(8);
            }
            f.a aVar = j0().get(i3);
            if (aVar == null) {
                return;
            }
            int i16 = aVar.f60854a;
            if ((i16 == 8 || i16 == 9) && QzoneBottomSheetMenuMore.this.E >= 0) {
                int i17 = QzoneBottomSheetMenuMore.this.E;
                aVar.f60854a = i17;
                aVar.f60856c = QzoneBottomSheetMenuMore.this.m2(i17);
            }
            k kVar = new k(aVar);
            iVar.E = aVar;
            iVar.F.setText(aVar.f60856c);
            if (aVar.f60854a == 0) {
                iVar.I.setVisibility(0);
                iVar.J.setVisibility(0);
                iVar.K.setVisibility(0);
                iVar.G.setVisibility(0);
                iVar.L.setVisibility(0);
                iVar.I.setOnClickListener(kVar);
                iVar.J.setOnClickListener(kVar);
                iVar.K.setOnClickListener(kVar);
                iVar.I.setContentDescription("\u5206\u4eab\u5230QQ");
                iVar.J.setContentDescription(com.qzone.util.l.a(R.string.s4z));
                iVar.K.setContentDescription(com.qzone.util.l.a(R.string.f172562s50));
                ViewUtils.setViewBackground(iVar.itemView, null);
                iVar.itemView.setOnClickListener(null);
                if (QzoneBottomSheetMenuMore.this.O1(14)) {
                    QzoneBottomSheetMenuMore.this.R2(iVar.I, 1.0f);
                } else {
                    QzoneBottomSheetMenuMore.this.R2(iVar.I, 0.3f);
                }
                if (QzoneBottomSheetMenuMore.this.D != null && QzoneBottomSheetMenuMore.this.D.getVideoInfo() != null) {
                    QzoneBottomSheetMenuMore.this.D.getLocalInfo();
                }
                if (QzoneBottomSheetMenuMore.this.O1(13)) {
                    QzoneBottomSheetMenuMore.this.R2(iVar.J, 1.0f);
                    QzoneBottomSheetMenuMore.this.R2(iVar.K, 1.0f);
                } else {
                    QzoneBottomSheetMenuMore.this.R2(iVar.J, 0.3f);
                    QzoneBottomSheetMenuMore.this.R2(iVar.K, 0.3f);
                }
            } else {
                iVar.I.setVisibility(8);
                iVar.J.setVisibility(8);
                iVar.K.setVisibility(8);
                iVar.G.setVisibility(8);
                iVar.L.setVisibility(8);
                iVar.I.setOnClickListener(null);
                iVar.J.setOnClickListener(null);
                iVar.K.setOnClickListener(null);
                iVar.itemView.setOnClickListener(kVar);
            }
            s_droplist_option s_droplist_optionVar = aVar.f60857d;
            if (s_droplist_optionVar == null || s_droplist_optionVar.iconurl == null) {
                iVar.H.setVisibility(8);
            }
            int i18 = aVar.f60854a;
            if (i18 == 3) {
                iVar.F.setText(QzoneBottomSheetMenuMore.this.i2());
            } else if (i18 == 10) {
                iVar.F.setText(QzoneBottomSheetMenuMore.this.j2());
            }
            m0(aVar, iVar);
            if (aVar.f60854a == 21) {
                if (QzoneBottomSheetMenuMore.this.D != null && QzoneBottomSheetMenuMore.this.D.hasDropdownFinishedAddFriend) {
                    iVar.F.setAlpha(0.3f);
                    iVar.F.setText("");
                } else {
                    iVar.F.setAlpha(1.0f);
                }
                iVar.F.setText(QzoneBottomSheetMenuMore.this.m2(aVar.f60854a));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: l0, reason: merged with bridge method [inline-methods] */
        public i onCreateViewHolder(ViewGroup viewGroup, int i3) {
            return new i(this.C.inflate(R.layout.buj, viewGroup, false));
        }

        public void i0(f.a aVar) {
            if (aVar == null) {
                return;
            }
            this.D.add(aVar);
        }
    }

    private void A1() {
        if (O1(21)) {
            f.a a16 = f.a.a();
            a16.f60854a = 6;
            a16.f60856c = m2(6);
            this.V.i0(a16);
        }
    }

    private void J1() {
        if (!P1(27) || this.D.getPermissionInfo().permission_visit == 3) {
            return;
        }
        f.a a16 = f.a.a();
        a16.f60854a = 22;
        a16.f60856c = m2(22);
        this.V.i0(a16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K2(int i3, BusinessFeedData businessFeedData, f.a aVar) {
        if (businessFeedData == null || aVar.f60857d == null) {
            return;
        }
        if (!NetworkUtil.isNetworkAvailable(this.C)) {
            ToastUtil.r(n2(R.string.f171139ci4));
        }
        f.d dVar = this.f60517t0;
        if (dVar != null) {
            dVar.a(this.M, this.D, aVar.f60857d);
        }
        s_droplist_option s_droplist_optionVar = aVar.f60857d;
        int i16 = s_droplist_optionVar.actiontype;
        if (i16 != 2) {
            if (i16 == 3) {
                yo.d.d(s_droplist_optionVar.jumpurl, this.C, null);
                return;
            }
            if (i16 != 23) {
                if (i16 == 41) {
                    N2(this.M, this.D, aVar);
                    return;
                } else {
                    if (i16 != 42) {
                        return;
                    }
                    F2(i3, businessFeedData);
                    return;
                }
            }
        }
        yo.d.d(s_droplist_optionVar.jumpurl, this.C, null);
    }

    private void L1() {
        if (O1(30)) {
            f.a a16 = f.a.a();
            a16.f60854a = 11;
            a16.f60856c = m2(11);
            this.V.i0(a16);
        }
    }

    private void M2(int i3, BusinessFeedData businessFeedData) {
        f.c cVar;
        if (businessFeedData == null || (cVar = this.f60521x0) == null) {
            return;
        }
        cVar.a(i3, businessFeedData);
        ap.f59791b.e(220, 1, i3, businessFeedData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z1(int i3, BusinessFeedData businessFeedData, f.a aVar, int i16, boolean z16) {
        s_droplist_option s_droplist_optionVar;
        f.b bVar;
        if (aVar == null || (s_droplist_optionVar = aVar.f60857d) == null || (bVar = this.f60515r0) == null) {
            return;
        }
        bVar.a(i3, businessFeedData, s_droplist_optionVar, i16, z16);
        int i17 = aVar.f60858e;
        if (i17 == -1 || i17 > 2) {
            return;
        }
        ClickReport.q("584", "19", (aVar.f60858e + 12) + "", true);
    }

    private void n1() {
        if (O1(17)) {
            f.a a16 = f.a.a();
            a16.f60854a = 3;
            a16.f60856c = i2();
            this.V.i0(a16);
        }
    }

    private void t1() {
        if (O1(10)) {
            f.a a16 = f.a.a();
            a16.f60854a = 2;
            a16.f60856c = m2(2);
            this.V.i0(a16);
        }
    }

    private void u1() {
        if (O1(9)) {
            f.a a16 = f.a.a();
            a16.f60854a = 1;
            a16.f60856c = m2(1);
            this.V.i0(a16);
        }
    }

    private void x1() {
        if (O1(25)) {
            f.a a16 = f.a.a();
            a16.f60854a = 5;
            a16.f60856c = m2(5);
            this.V.i0(a16);
        }
    }

    private void z1() {
        if (O1(24)) {
            f.a a16 = f.a.a();
            a16.f60854a = 4;
            a16.f60856c = m2(4);
            this.V.i0(a16);
        }
    }

    public void L2(int i3, BusinessFeedData businessFeedData, f.a aVar) {
        s_droplist_option s_droplist_optionVar;
        if (aVar == null || (s_droplist_optionVar = aVar.f60857d) == null) {
            return;
        }
        if (N1(s_droplist_optionVar.action_detail, 1)) {
            Map<String, String> map = aVar.f60857d.extend_info;
            String str = map.get(AECameraConstants.KEY_CONFIRM_TEXT);
            String str2 = map.get("ok_text");
            String str3 = map.get("cancel_text");
            if (TextUtils.isEmpty(str2)) {
                str2 = n2(R.string.a8j);
            }
            String str4 = str2;
            if (TextUtils.isEmpty(str3)) {
                str3 = n2(R.string.cancel);
            }
            new com.qzone.component.e().h(this.C, str, "", str4, str3, new g(i3, businessFeedData, aVar), null);
            return;
        }
        K2(i3, businessFeedData, aVar);
    }

    public boolean x2(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getUser() == null) {
            return false;
        }
        return businessFeedData.getUser().isCanShowFamousIcon();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class f implements ResDownloadManger.ResLoadListener {
        f() {
        }

        @Override // cooperation.qzone.util.ResDownloadManger.ResLoadListener
        public void onDownloaded(int i3, String str, Bitmap bitmap) {
            if (bitmap != null) {
                bitmap.setDensity(320);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                bitmapDrawable.setTargetDensity((int) ViewUtils.getDensityDpi());
                if (TextUtils.equals("qzone_skin_feed_dropmenu_reprinted", str)) {
                    QzoneBottomSheetMenuMore.M0 = bitmapDrawable;
                } else if (TextUtils.equals("qzone_skin_feed_dropmenu_yellow_diamond", str)) {
                    QzoneBottomSheetMenuMore.S0 = bitmapDrawable;
                } else if (TextUtils.equals("qzone_skin_feed_dropmenu_edit", str)) {
                    QzoneBottomSheetMenuMore.G0 = bitmapDrawable;
                } else if (TextUtils.equals("qzone_skin_feed_dropmenu_icon_delete", str)) {
                    QzoneBottomSheetMenuMore.H0 = bitmapDrawable;
                } else if (TextUtils.equals("qzone_skin_feed_dropmenu_report", str)) {
                    QzoneBottomSheetMenuMore.I0 = bitmapDrawable;
                } else if (TextUtils.equals("qzone_skin_feed_dropmenu_share", str)) {
                    QzoneBottomSheetMenuMore.J0 = bitmapDrawable;
                } else if (TextUtils.equals("qzone_skin_feed_dropmenu_collect", str)) {
                    QzoneBottomSheetMenuMore.K0 = bitmapDrawable;
                } else if (TextUtils.equals("qzone_skin_feed_dropmenu_collect_cancel", str)) {
                    QzoneBottomSheetMenuMore.L0 = bitmapDrawable;
                } else if (TextUtils.equals("qzone_skin_feed_dropmenu_hide", str)) {
                    QzoneBottomSheetMenuMore.P0 = bitmapDrawable;
                } else if (TextUtils.equals("qzone_skin_feed_dropmenu_not_see", str)) {
                    QzoneBottomSheetMenuMore.Q0 = bitmapDrawable;
                    QzoneBottomSheetMenuMore.V0 = bitmapDrawable;
                } else if (TextUtils.equals("qzone_skin_feed_dropmenu_top", str)) {
                    QzoneBottomSheetMenuMore.R0 = bitmapDrawable;
                } else if (TextUtils.equals("qzone_skin_feed_dropmenu_not_interested", str)) {
                    QzoneBottomSheetMenuMore.T0 = bitmapDrawable;
                } else if (TextUtils.equals("qzone_skin_feed_dropmenu_close_feed", str)) {
                    QzoneBottomSheetMenuMore.U0 = bitmapDrawable;
                } else if (TextUtils.equals("qzone_skin_feed_dropmenu_unsubscribe", str)) {
                    QzoneBottomSheetMenuMore.O0 = bitmapDrawable;
                } else if (TextUtils.equals("qzone_skin_feed_dropmenu_subscribe", str)) {
                    QzoneBottomSheetMenuMore.N0 = bitmapDrawable;
                } else if (TextUtils.equals("qzone_skin_feed_dropmenu_add_friend", str)) {
                    QzoneBottomSheetMenuMore.W0 = bitmapDrawable;
                } else if (TextUtils.equals("qzone_skin_feed_dropmenu_already_add_friend", str)) {
                    QzoneBottomSheetMenuMore.X0 = bitmapDrawable;
                } else if (TextUtils.equals("qzone_skin_feed_dropmenu_download", str)) {
                    QzoneBottomSheetMenuMore.f60493b1 = bitmapDrawable;
                } else if (TextUtils.equals("qzone_skin_feed_dropmenu_set_private", str)) {
                    QzoneBottomSheetMenuMore.Y0 = bitmapDrawable;
                }
                if (QzoneBottomSheetMenuMore.this.P != null) {
                    Message message = new Message();
                    message.what = QzoneBottomSheetMenuMore.f60497f1;
                    QzoneBottomSheetMenuMore.this.P.sendMessage(message);
                }
            }
        }

        @Override // cooperation.qzone.util.ResDownloadManger.ResLoadListener
        public void onFailed(int i3, String str) {
        }
    }

    public QzoneBottomSheetMenuMore(Activity activity, BusinessFeedData businessFeedData) {
        super(activity, R.style.MenuDialogStyle);
        this.E = -1;
        this.F = true;
        this.G = 0;
        this.H = 0;
        this.I = false;
        this.J = -1;
        this.K = -1;
        this.L = -1;
        this.M = -1;
        this.N = false;
        this.W = -1;
        this.Z = null;
        this.f60498a0 = null;
        this.f60499b0 = null;
        this.f60500c0 = null;
        this.f60501d0 = null;
        this.f60502e0 = null;
        this.f60503f0 = null;
        this.f60504g0 = null;
        this.f60505h0 = null;
        this.f60506i0 = null;
        this.f60507j0 = null;
        this.f60508k0 = null;
        this.f60509l0 = null;
        this.f60510m0 = null;
        this.f60511n0 = null;
        this.f60512o0 = null;
        this.f60513p0 = null;
        this.f60514q0 = null;
        this.f60515r0 = null;
        this.f60516s0 = null;
        this.f60517t0 = null;
        this.f60518u0 = null;
        this.f60519v0 = null;
        this.f60520w0 = null;
        this.f60521x0 = null;
        this.f60522y0 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewMenu", "\u83dc\u5355");
        this.f60523z0 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewReduceRecommend", "\u51cf\u5c11\u6b64\u4eba\u63a8\u8350");
        this.A0 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewNotInterestAndHide", "\u4e0d\u611f\u5174\u8da3\u5e76\u9690\u85cf");
        this.B0 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewHadSendApply", "\u5df2\u53d1\u9001\u597d\u53cb\u7533\u8bf7");
        this.C0 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewAddFriend", "\u6dfb\u52a0\u597d\u53cb");
        this.D0 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewNotShowAnyMore", "\u4e0d\u518d\u663e\u793a");
        this.C = activity;
        this.D = businessFeedData;
        this.P = new a(Looper.getMainLooper());
        init();
        t2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H2(int i3, BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        f.c cVar = this.f60511n0;
        if (cVar != null) {
            cVar.a(i3, businessFeedData);
        }
        com.qzone.proxy.feedcomponent.i uiInterface = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface();
        com.qzone.adapter.feedcomponent.i.H();
        uiInterface.doFloatViewActionReport(14);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I2(int i3, BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        f.c cVar = this.f60505h0;
        if (cVar != null) {
            cVar.a(i3, businessFeedData);
        }
        com.qzone.proxy.feedcomponent.i uiInterface = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface();
        com.qzone.adapter.feedcomponent.i.H();
        uiInterface.doFloatViewActionReport(12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J2(int i3, BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        f.c cVar = this.f60510m0;
        if (cVar != null) {
            cVar.a(i3, businessFeedData);
        }
        com.qzone.proxy.feedcomponent.i uiInterface = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface();
        com.qzone.adapter.feedcomponent.i.H();
        uiInterface.doFloatViewActionReport(13);
    }

    private void M1(int i3, BusinessFeedData businessFeedData) {
        f.c cVar;
        if (businessFeedData == null || (cVar = this.f60520w0) == null) {
            return;
        }
        cVar.a(i3, businessFeedData);
    }

    private void N2(int i3, BusinessFeedData businessFeedData, f.a aVar) {
        if (businessFeedData == null) {
            return;
        }
        if (businessFeedData.isAdFeeds()) {
            Z1(i3, businessFeedData, aVar, -1, false);
        }
        f.c cVar = this.f60503f0;
        if (cVar != null) {
            cVar.a(i3, businessFeedData);
        }
        com.qzone.proxy.feedcomponent.i uiInterface = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface();
        com.qzone.adapter.feedcomponent.i.H();
        uiInterface.doFloatViewActionReport(22);
        ap.f59791b.e(47, 1, i3, businessFeedData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R2(View view, float f16) {
        if (view == null) {
            return;
        }
        view.setAlpha(f16);
    }

    private void S2(int i3, BusinessFeedData businessFeedData) {
        f.c cVar;
        if (businessFeedData == null || (cVar = this.f60519v0) == null) {
            return;
        }
        cVar.a(i3, businessFeedData);
    }

    private void V1(int i3, BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        f.c cVar = this.f60501d0;
        if (cVar != null) {
            cVar.a(i3, businessFeedData);
        }
        com.qzone.proxy.feedcomponent.i uiInterface = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface();
        com.qzone.adapter.feedcomponent.i.H();
        uiInterface.doFloatViewActionReport(21);
    }

    private void e2(int i3, BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        f.c cVar = this.f60500c0;
        if (cVar != null) {
            cVar.a(i3, businessFeedData);
        }
        com.qzone.proxy.feedcomponent.i uiInterface = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface();
        com.qzone.adapter.feedcomponent.i.H();
        uiInterface.doFloatViewActionReport(20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String m2(int i3) {
        switch (i3) {
            case 0:
                return n2(R.string.gfm);
            case 1:
                return n2(R.string.gfe);
            case 2:
                return n2(R.string.gfc);
            case 3:
                return i2();
            case 4:
                return n2(R.string.gfh);
            case 5:
                return n2(R.string.gfg);
            case 6:
                return n2(R.string.gfi);
            case 7:
                if (this.D.getFeedCommInfo().appid == 2) {
                    return n2(R.string.gfj);
                }
                return n2(R.string.f173011gg4);
            case 8:
                return n2(R.string.gfn);
            case 9:
                return n2(R.string.gfo);
            case 10:
                return j2();
            case 11:
                return n2(R.string.gi6);
            case 12:
                return n2(R.string.gd_);
            case 13:
                return this.D0;
            case 14:
            case 15:
            case 17:
            case 18:
            case 20:
            default:
                return "";
            case 16:
                return n2(R.string.gff);
            case 19:
                return n2(R.string.gfd);
            case 21:
                if (this.D.hasDropdownFinishedAddFriend) {
                    return this.B0;
                }
                return this.C0;
            case 22:
                return n2(R.string.gfl);
            case 23:
                if (z2()) {
                    return "\u67e5\u770bTa\u7684\u88c5\u626e";
                }
                return com.qzone.util.l.a(R.string.s4y);
            case 24:
                return n2(R.string.gh_);
        }
    }

    private void r2(int i3, BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        f.c cVar = this.f60498a0;
        if (cVar != null) {
            cVar.a(i3, businessFeedData);
        }
        com.qzone.proxy.feedcomponent.i uiInterface = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface();
        com.qzone.adapter.feedcomponent.i.H();
        uiInterface.doFloatViewActionReport(19);
        ap.f59791b.e(46, 1, i3, businessFeedData);
    }

    private void s2(int i3, BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        f.c cVar = this.f60499b0;
        if (cVar != null) {
            cVar.a(i3, businessFeedData);
        }
        com.qzone.proxy.feedcomponent.i uiInterface = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface();
        com.qzone.adapter.feedcomponent.i.H();
        uiInterface.doFloatViewActionReport(18);
        ap.f59791b.e(45, 1, i3, businessFeedData);
    }

    private void w1(int i3, BusinessFeedData businessFeedData) {
        f.c cVar;
        if (businessFeedData == null || (cVar = this.Z) == null) {
            return;
        }
        cVar.a(i3, businessFeedData);
    }

    public void P2(int i3, BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        f.c cVar = this.f60506i0;
        if (cVar != null) {
            cVar.a(i3, businessFeedData);
        }
        com.qzone.proxy.feedcomponent.i uiInterface = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface();
        com.qzone.adapter.feedcomponent.i.H();
        uiInterface.doFloatViewActionReport(17);
        ap.f59791b.e(51, 1, i3, businessFeedData);
    }

    public void T1(int i3, BusinessFeedData businessFeedData, f.a aVar) {
        if (businessFeedData == null) {
            return;
        }
        boolean y26 = y2();
        f.c cVar = this.f60504g0;
        if (cVar != null) {
            cVar.a(i3, businessFeedData);
        }
        Z1(i3, businessFeedData, aVar, -1, y26);
        if (!y26) {
            com.qzone.proxy.feedcomponent.i uiInterface = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface();
            com.qzone.adapter.feedcomponent.i.H();
            uiInterface.doFloatViewActionReport(15);
            ap.f59791b.e(43, 1, i3, businessFeedData);
            return;
        }
        com.qzone.proxy.feedcomponent.i uiInterface2 = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface();
        com.qzone.adapter.feedcomponent.i.H();
        uiInterface2.doFloatViewActionReport(16);
        ap.f59791b.e(44, 1, i3, businessFeedData);
    }

    public void V2(int i3, BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        f.c cVar = this.f60507j0;
        if (cVar != null) {
            cVar.a(i3, businessFeedData);
        }
        LpReportInfo_pf00064.allReport(302, 549, x2(businessFeedData) ? 1 : 2);
        com.qzone.proxy.feedcomponent.i uiInterface = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface();
        com.qzone.adapter.feedcomponent.i.H();
        uiInterface.doFloatViewActionReport(23);
    }

    public void W2(int i3, BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        f.c cVar = this.f60509l0;
        if (cVar != null) {
            cVar.a(i3, businessFeedData);
        }
        LpReportInfo_pf00064.allReport(302, 550, x2(businessFeedData) ? 1 : 2);
        com.qzone.proxy.feedcomponent.i uiInterface = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface();
        com.qzone.adapter.feedcomponent.i.H();
        uiInterface.doFloatViewActionReport(24);
    }

    private boolean C2(s_droplist_option s_droplist_optionVar) {
        if (s_droplist_optionVar == null) {
            return false;
        }
        int i3 = s_droplist_optionVar.reporttypeV2;
        return i3 == 4 || i3 == 5;
    }

    private void v1(boolean z16, boolean z17) {
        if (z16 || !z17) {
            return;
        }
        f.a a16 = f.a.a();
        a16.f60854a = 10;
        a16.f60856c = j2();
        this.V.i0(a16);
    }

    @Override // com.qzone.widget.f
    public void z(int i3, f.c cVar) {
        switch (i3) {
            case 1:
                this.Z = cVar;
                return;
            case 2:
                this.f60498a0 = cVar;
                return;
            case 3:
                this.f60499b0 = cVar;
                return;
            case 4:
                this.f60500c0 = cVar;
                return;
            case 5:
                this.f60501d0 = cVar;
                return;
            case 6:
                this.f60502e0 = cVar;
                return;
            case 7:
                this.f60503f0 = cVar;
                return;
            case 8:
                this.f60504g0 = cVar;
                return;
            case 9:
                this.f60505h0 = cVar;
                return;
            case 10:
                this.f60506i0 = cVar;
                return;
            case 11:
                this.f60507j0 = cVar;
                return;
            case 12:
                this.f60508k0 = cVar;
                return;
            case 13:
                this.f60509l0 = cVar;
                return;
            case 14:
                this.f60510m0 = cVar;
                return;
            case 15:
                this.f60511n0 = cVar;
                return;
            case 16:
                this.f60512o0 = cVar;
                return;
            case 17:
                this.f60513p0 = cVar;
                return;
            case 18:
                this.f60514q0 = cVar;
                return;
            case 19:
            case 21:
            default:
                return;
            case 20:
                this.f60516s0 = cVar;
                return;
            case 22:
                this.f60518u0 = cVar;
                return;
            case 23:
                this.f60519v0 = cVar;
                return;
            case 24:
                this.f60520w0 = cVar;
                return;
            case 25:
                this.f60521x0 = cVar;
                return;
        }
    }
}
