package com.qzone.reborn.share;

import NS_MOBILE_FEEDS.s_droplist_option;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
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
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.business.favorite.service.QzoneFavoriteService;
import com.qzone.common.account.LoginData;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.reborn.feedx.util.n;
import com.qzone.reborn.feedx.util.y;
import com.qzone.reborn.share.c;
import com.qzone.util.ToastUtil;
import com.qzone.util.an;
import com.qzone.util.ap;
import com.qzone.util.l;
import com.qzone.widget.AsyncImageView;
import com.qzone.widget.CommonLine;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.component.animation.rebound.SpringConfig;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QZoneConfigHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import lg.r;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneFeedXBottomSheetMenuMore extends ReportDialog implements com.qzone.reborn.share.c {

    /* renamed from: e1, reason: collision with root package name */
    private static final SpringConfig f59416e1 = SpringConfig.fromOrigamiTensionAndFriction(60.0d, 8.0d);

    /* renamed from: f1, reason: collision with root package name */
    private static int f59417f1 = 123;
    private Drawable A0;
    private Drawable B0;
    private Activity C;
    private Drawable C0;
    private BusinessFeedData D;
    private Drawable D0;
    private int E;
    private Drawable E0;
    private boolean F;
    private Drawable F0;
    private int G;
    private Drawable G0;
    private int H;
    private Drawable H0;
    private boolean I;
    private Drawable I0;
    private int J;
    private Drawable J0;
    private int K;
    private Drawable K0;
    private int L;
    private Drawable L0;
    private int M;
    private Drawable M0;
    public boolean N;
    private Drawable N0;
    private Drawable O0;
    private Handler P;
    private Drawable P0;
    private ViewGroup Q;
    private Drawable Q0;
    private View R;
    private Drawable R0;
    private View S;
    private Drawable S0;
    private View T;
    private Drawable T0;
    private RecyclerView U;
    private Drawable U0;
    private g V;
    private Drawable V0;
    private int W;
    private Drawable W0;
    private int X;
    private String X0;
    private View.OnTouchListener Y;
    private String Y0;
    public c.InterfaceC0499c Z;
    private String Z0;

    /* renamed from: a0, reason: collision with root package name */
    public c.InterfaceC0499c f59418a0;

    /* renamed from: a1, reason: collision with root package name */
    private String f59419a1;

    /* renamed from: b0, reason: collision with root package name */
    public c.InterfaceC0499c f59420b0;

    /* renamed from: b1, reason: collision with root package name */
    private String f59421b1;

    /* renamed from: c0, reason: collision with root package name */
    public c.InterfaceC0499c f59422c0;

    /* renamed from: c1, reason: collision with root package name */
    private String f59423c1;

    /* renamed from: d0, reason: collision with root package name */
    public c.InterfaceC0499c f59424d0;

    /* renamed from: d1, reason: collision with root package name */
    private i f59425d1;

    /* renamed from: e0, reason: collision with root package name */
    public c.InterfaceC0499c f59426e0;

    /* renamed from: f0, reason: collision with root package name */
    public c.InterfaceC0499c f59427f0;

    /* renamed from: g0, reason: collision with root package name */
    public c.InterfaceC0499c f59428g0;

    /* renamed from: h0, reason: collision with root package name */
    public c.InterfaceC0499c f59429h0;

    /* renamed from: i0, reason: collision with root package name */
    public c.InterfaceC0499c f59430i0;

    /* renamed from: j0, reason: collision with root package name */
    public c.InterfaceC0499c f59431j0;

    /* renamed from: k0, reason: collision with root package name */
    public c.InterfaceC0499c f59432k0;

    /* renamed from: l0, reason: collision with root package name */
    public c.InterfaceC0499c f59433l0;

    /* renamed from: m0, reason: collision with root package name */
    public c.InterfaceC0499c f59434m0;

    /* renamed from: n0, reason: collision with root package name */
    public c.InterfaceC0499c f59435n0;

    /* renamed from: o0, reason: collision with root package name */
    public c.InterfaceC0499c f59436o0;

    /* renamed from: p0, reason: collision with root package name */
    public c.InterfaceC0499c f59437p0;

    /* renamed from: q0, reason: collision with root package name */
    public c.InterfaceC0499c f59438q0;

    /* renamed from: r0, reason: collision with root package name */
    public c.b f59439r0;

    /* renamed from: s0, reason: collision with root package name */
    public c.InterfaceC0499c f59440s0;

    /* renamed from: t0, reason: collision with root package name */
    public c.d f59441t0;

    /* renamed from: u0, reason: collision with root package name */
    public c.InterfaceC0499c f59442u0;

    /* renamed from: v0, reason: collision with root package name */
    public c.InterfaceC0499c f59443v0;

    /* renamed from: w0, reason: collision with root package name */
    public c.InterfaceC0499c f59444w0;

    /* renamed from: x0, reason: collision with root package name */
    public c.InterfaceC0499c f59445x0;

    /* renamed from: y0, reason: collision with root package name */
    private c.InterfaceC0499c f59446y0;

    /* renamed from: z0, reason: collision with root package name */
    private Drawable f59447z0;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != QZoneFeedXBottomSheetMenuMore.f59417f1 || QZoneFeedXBottomSheetMenuMore.this.V == null) {
                return;
            }
            QZoneFeedXBottomSheetMenuMore.this.V.notifyDataSetChanged();
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class b implements QzoneFavoriteService.d {
        b() {
        }

        @Override // com.qzone.business.favorite.service.QzoneFavoriteService.d
        public void a(String str, boolean z16) {
            QZoneFeedXBottomSheetMenuMore.this.F = z16;
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
            QZoneFeedXBottomSheetMenuMore.this.dismiss();
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
            ap.f59791b.e(70, 1, 0, QZoneFeedXBottomSheetMenuMore.this.D);
            QZoneFeedXBottomSheetMenuMore.this.dismiss();
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
                QZoneFeedXBottomSheetMenuMore.this.T.setAlpha(0.0f);
                QZoneFeedXBottomSheetMenuMore.this.J0();
            }
        }

        e() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 1) {
                int top = QZoneFeedXBottomSheetMenuMore.this.T.getTop();
                if (top > QZoneFeedXBottomSheetMenuMore.this.X) {
                    top = QZoneFeedXBottomSheetMenuMore.this.X;
                }
                float f16 = top;
                float f17 = f16 / QZoneFeedXBottomSheetMenuMore.this.X;
                AnimatorSet animatorSet = new AnimatorSet();
                if (f17 < 0.25f) {
                    long j3 = (1.0f - f17) * 200.0f;
                    QZoneFeedXBottomSheetMenuMore.this.T.layout(QZoneFeedXBottomSheetMenuMore.this.T.getLeft(), 0, QZoneFeedXBottomSheetMenuMore.this.T.getRight(), QZoneFeedXBottomSheetMenuMore.this.X);
                    QZoneFeedXBottomSheetMenuMore.this.R.setAlpha(0.5f);
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(QZoneFeedXBottomSheetMenuMore.this.T, (Property<View, Float>) View.TRANSLATION_Y, f16, 0.0f);
                    ofFloat.setDuration(j3);
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(QZoneFeedXBottomSheetMenuMore.this.R, (Property<View, Float>) View.ALPHA, 0.5f);
                    ofFloat2.setDuration(j3);
                    animatorSet.playTogether(ofFloat, ofFloat2);
                    animatorSet.start();
                } else {
                    long j16 = f17 * 200.0f;
                    ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(QZoneFeedXBottomSheetMenuMore.this.T, (Property<View, Float>) View.TRANSLATION_Y, f16, QZoneFeedXBottomSheetMenuMore.this.X);
                    ofFloat3.setDuration(j16);
                    ofFloat3.addListener(new a());
                    ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(QZoneFeedXBottomSheetMenuMore.this.R, (Property<View, Float>) View.ALPHA, 0.0f);
                    ofFloat4.setDuration(j16);
                    animatorSet.playTogether(ofFloat3, ofFloat4);
                    animatorSet.start();
                }
                QZoneFeedXBottomSheetMenuMore.this.W = -1;
            } else if (action == 2) {
                if (QZoneFeedXBottomSheetMenuMore.this.W == -1) {
                    QZoneFeedXBottomSheetMenuMore.this.W = (int) motionEvent.getRawY();
                } else {
                    int rawY = ((int) motionEvent.getRawY()) - QZoneFeedXBottomSheetMenuMore.this.W;
                    int left = QZoneFeedXBottomSheetMenuMore.this.T.getLeft();
                    int right = QZoneFeedXBottomSheetMenuMore.this.T.getRight();
                    int top2 = QZoneFeedXBottomSheetMenuMore.this.T.getTop();
                    int bottom = QZoneFeedXBottomSheetMenuMore.this.T.getBottom();
                    int i3 = top2 + rawY;
                    if (i3 >= 0) {
                        QZoneFeedXBottomSheetMenuMore.this.T.layout(left, i3, right, bottom + rawY);
                        QZoneFeedXBottomSheetMenuMore.this.W = (int) motionEvent.getRawY();
                    }
                    float f18 = ((QZoneFeedXBottomSheetMenuMore.this.X - top2) - rawY) / QZoneFeedXBottomSheetMenuMore.this.X;
                    if (f18 <= 1.0d) {
                        QZoneFeedXBottomSheetMenuMore.this.R.setAlpha(f18 * 0.5f);
                    }
                }
            }
            return view.getId() == R.id.m3x;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class f implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f59456d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ BusinessFeedData f59457e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ c.a f59458f;

        f(int i3, BusinessFeedData businessFeedData, c.a aVar) {
            this.f59456d = i3;
            this.f59457e = businessFeedData;
            this.f59458f = aVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QZoneFeedXBottomSheetMenuMore.this.d2(this.f59456d, this.f59457e, this.f59458f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class h extends RecyclerView.ViewHolder {
        public c.a E;
        public TextView F;
        public AsyncImageView G;
        public CommonLine H;

        public h(View view) {
            super(view);
            this.F = (TextView) view.findViewById(R.id.mgy);
            this.G = (AsyncImageView) view.findViewById(R.id.mbx);
            this.H = (CommonLine) view.findViewById(R.id.f20518l);
            AccessibilityUtil.n(this.G, false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface i {
        void a(int i3, BusinessFeedData businessFeedData, c.a aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class j implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        private c.a f59461d;

        public j(c.a aVar) {
            this.f59461d = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            c.a aVar = this.f59461d;
            if (aVar != null) {
                QZoneFeedXBottomSheetMenuMore.this.a2(aVar);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String B1() {
        if (!this.F) {
            return G1(R.string.gfa);
        }
        return G1(R.string.gfb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String C1() {
        BusinessFeedData businessFeedData = this.D;
        if (businessFeedData != null && r.f414520a.b(businessFeedData)) {
            return G1(R.string.gf_);
        }
        return G1(R.string.gfk);
    }

    private int E1() {
        BusinessFeedData businessFeedData;
        BusinessFeedData businessFeedData2;
        BusinessFeedData businessFeedData3 = this.D;
        boolean z16 = (businessFeedData3 == null || (businessFeedData2 = businessFeedData3.parentFeedData) == null || (!businessFeedData2.isFriendLikeContainer() && !this.D.parentFeedData.isFrdLikeMiniAppContainer())) ? false : true;
        BusinessFeedData businessFeedData4 = this.D;
        boolean z17 = (businessFeedData4 == null || (businessFeedData = businessFeedData4.parentFeedData) == null || !businessFeedData.isCardSpecialFollowMoreRecommendContainerFeed()) ? false : true;
        if (z16 || z17) {
            return -1;
        }
        if (l1(27) || l1(20)) {
            return this.D.getFeedCommInfo().isFollowed ? 9 : 8;
        }
        return -1;
    }

    public static String G1(int i3) {
        try {
            FeedGlobalEnv.g();
            return FeedGlobalEnv.getApplication().getResources().getString(i3);
        } catch (Exception unused) {
            return "";
        }
    }

    private Drawable I1() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        int i3 = AreaConst.dp6;
        gradientDrawable.setCornerRadii(new float[]{i3, i3, i3, i3, 0.0f, 0.0f, 0.0f, 0.0f});
        gradientDrawable.setColor(getContext().getColor(R.color.qui_common_bg_middle_light));
        return gradientDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0() {
        try {
            super.dismiss();
        } catch (Exception unused) {
        } catch (Throwable th5) {
            sy3.a.a(this);
            throw th5;
        }
        sy3.a.a(this);
    }

    private void J1(int i3, BusinessFeedData businessFeedData) {
        c.InterfaceC0499c interfaceC0499c = this.f59426e0;
        if (interfaceC0499c != null) {
            interfaceC0499c.a(i3, businessFeedData);
        }
    }

    private void K0() {
        if (U1()) {
            c.a a16 = c.a.a();
            a16.f59484a = 23;
            a16.f59486c = F1(23);
            this.V.i0(a16);
        }
    }

    private void M1() {
        g gVar = new g(this.C);
        this.V = gVar;
        this.U.setAdapter(gVar);
    }

    private void N0(s_droplist_option s_droplist_optionVar) {
        String str;
        if (y.f(this.D)) {
            c.a a16 = c.a.a();
            a16.f59484a = 3;
            if (s_droplist_optionVar == null) {
                str = B1();
            } else {
                str = s_droplist_optionVar.optext;
            }
            a16.f59486c = str;
            a16.f59487d = s_droplist_optionVar;
            this.V.i0(a16);
        }
    }

    private void N1(boolean z16) {
        Iterator<s_droplist_option> it = this.D.getFeedCommInfo().customDroplist.iterator();
        int i3 = -1;
        while (it.hasNext()) {
            s_droplist_option next = it.next();
            i3++;
            if (this.V == null) {
                this.V = new g(this.C);
            }
            if (next != null) {
                this.L = i3;
                if (next.actiontype != 38 || z16) {
                    if (!V1(next)) {
                        int i16 = next.actiontype;
                        if (i16 == 39) {
                            N0(next);
                        } else if (i16 == 41) {
                            Y0(next);
                        } else if (i16 == 42) {
                            h1(next);
                        } else if (i16 == 43) {
                            e1(next);
                        } else {
                            O0(next);
                        }
                    } else {
                        c1(next);
                    }
                }
            }
        }
    }

    private void O0(s_droplist_option s_droplist_optionVar) {
        c.a a16 = c.a.a();
        a16.f59484a = 14;
        a16.f59486c = s_droplist_optionVar == null ? null : s_droplist_optionVar.optext;
        a16.f59487d = s_droplist_optionVar;
        int i3 = this.L;
        if (i3 != -1) {
            a16.f59488e = i3;
        }
        this.V.i0(a16);
    }

    private void P0() {
        if (this.E < 0) {
            return;
        }
        if (l1(27) || l1(20)) {
            c.a a16 = c.a.a();
            int i3 = this.E;
            a16.f59484a = i3;
            a16.f59486c = F1(i3);
            this.V.i0(a16);
        }
    }

    private boolean R1() {
        BusinessFeedData businessFeedData = this.D;
        if (businessFeedData == null) {
            QZLog.w("QZoneFeedXBottomSheetMenuMore", "[isFavorited] mFeedData is null");
            return false;
        }
        if (businessFeedData.getFeedCommInfo() == null) {
            return false;
        }
        return QzoneFavoriteService.M().R(this.D.getFeedCommInfo().ugckey);
    }

    private boolean S1() {
        BusinessFeedData businessFeedData = this.D;
        return businessFeedData == null || businessFeedData.getUser().uin != LoginData.getInstance().getUin();
    }

    private boolean T1() {
        BusinessFeedData businessFeedData = this.D;
        return (businessFeedData == null || businessFeedData.getUser() == null || this.D.getUser().uin == LoginData.getInstance().getUin()) ? false : true;
    }

    private boolean U1() {
        BusinessFeedData businessFeedData;
        return (P1() || (businessFeedData = this.D) == null || businessFeedData.isSecretFeed() || this.D.isFrdLikeMiniAppContainer() || this.D.isQQLiveFeed() || this.D.isFakeFeedSafe() || this.D.isPYMKFeed()) ? false : true;
    }

    private void V0() {
        if (n1(this.D.getFeedCommInfo().operatemask2, 6)) {
            c.a a16 = c.a.a();
            a16.f59484a = 16;
            a16.f59486c = F1(16);
            this.V.i0(a16);
        }
    }

    private void Y0(s_droplist_option s_droplist_optionVar) {
        String str;
        c.a a16 = c.a.a();
        a16.f59484a = 6;
        if (s_droplist_optionVar == null) {
            str = F1(6);
        } else {
            str = s_droplist_optionVar.optext;
        }
        a16.f59486c = str;
        a16.f59487d = s_droplist_optionVar;
        this.V.i0(a16);
    }

    private void Z0() {
        if (TextUtils.isEmpty(n.d(this.D))) {
            return;
        }
        c.a a16 = c.a.a();
        a16.f59484a = 25;
        a16.f59486c = F1(25);
        this.V.i0(a16);
        fo.c.c("ev_qz_feed_settings_page_imp", null);
    }

    private void Z1(int i3, BusinessFeedData businessFeedData) {
        c.InterfaceC0499c interfaceC0499c = this.f59436o0;
        if (interfaceC0499c != null) {
            interfaceC0499c.a(i3, businessFeedData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a2(c.a aVar) {
        switch (aVar.f59484a) {
            case 1:
                y1(this.M, this.D);
                break;
            case 2:
                u1(this.M, this.D);
                break;
            case 3:
                r1(this.M, this.D, aVar);
                break;
            case 4:
                L1(this.M, this.D);
                break;
            case 5:
                int i3 = this.M;
                BusinessFeedData businessFeedData = this.D;
                if (businessFeedData.isSubFeed) {
                    i3 = businessFeedData.containerIndex;
                }
                K1(i3, businessFeedData);
                break;
            case 6:
                g2(this.M, this.D, aVar);
                break;
            case 7:
                h2(this.M, this.D);
                break;
            case 8:
                m2(this.M, this.D);
                break;
            case 9:
                n2(this.M, this.D);
                break;
            case 10:
                k2(this.M, this.D);
                break;
            case 11:
                Z1(this.M, this.D);
                break;
            case 12:
                p1(this.M, this.D);
                break;
            case 13:
                w1(this.M, this.D);
                break;
            case 14:
                v1(this.M, this.D, aVar, -1, false);
                break;
            case 15:
                x1(this.M, this.D);
                break;
            case 16:
                J1(this.M, this.D);
                break;
            case 18:
                e2(this.M, this.D, aVar);
                break;
            case 19:
                i2(this.M, this.D);
                break;
            case 21:
                BusinessFeedData businessFeedData2 = this.D;
                if (businessFeedData2 == null || !businessFeedData2.hasDropdownFinishedAddFriend) {
                    T0(this.M, businessFeedData2);
                    break;
                }
                break;
            case 22:
                j2(this.M, this.D);
                break;
            case 23:
                j1(this.M, this.D);
                break;
            case 24:
                f2(this.M, this.D);
                break;
            case 25:
                c2(this.M, this.D);
                break;
        }
        i iVar = this.f59425d1;
        if (iVar != null) {
            iVar.a(this.M, this.D, aVar);
        }
        dismiss();
    }

    private void c1(s_droplist_option s_droplist_optionVar) {
        String str;
        c.a a16 = c.a.a();
        a16.f59484a = 18;
        if (s_droplist_optionVar == null) {
            str = this.X0;
        } else {
            str = s_droplist_optionVar.optext;
        }
        a16.f59486c = str;
        a16.f59487d = s_droplist_optionVar;
        this.V.i0(a16);
    }

    private void e1(s_droplist_option s_droplist_optionVar) {
        String str;
        c.a a16 = c.a.a();
        a16.f59487d = s_droplist_optionVar;
        a16.f59484a = 15;
        if (s_droplist_optionVar != null) {
            str = s_droplist_optionVar.optext;
        } else {
            str = this.Y0;
        }
        a16.f59486c = str;
        this.V.i0(a16);
    }

    private void h1(s_droplist_option s_droplist_optionVar) {
        String str;
        c.a a16 = c.a.a();
        a16.f59487d = s_droplist_optionVar;
        a16.f59484a = 11;
        if (s_droplist_optionVar != null) {
            str = s_droplist_optionVar.optext;
        } else {
            str = this.Z0;
        }
        a16.f59486c = str;
        this.V.i0(a16);
    }

    private void i2(int i3, BusinessFeedData businessFeedData) {
        c.InterfaceC0499c interfaceC0499c = this.f59442u0;
        if (interfaceC0499c != null) {
            interfaceC0499c.a(i3, businessFeedData);
        }
    }

    private void k2(int i3, BusinessFeedData businessFeedData) {
        c.InterfaceC0499c interfaceC0499c = this.f59432k0;
        if (interfaceC0499c != null) {
            interfaceC0499c.a(i3, businessFeedData);
        }
    }

    private boolean l1(int i3) {
        if (this.D == null) {
            return false;
        }
        return com.qzone.proxy.feedcomponent.util.d.j(r0.getFeedCommInfo().operatemask, i3);
    }

    private boolean m1(int i3) {
        return com.qzone.proxy.feedcomponent.util.d.j(this.D.getFeedCommInfo().operatemask2, i3);
    }

    private static boolean n1(int i3, int i16) {
        if ((i3 & (1 << i16)) != 0) {
            return true;
        }
        return false;
    }

    private boolean o1(int i3) {
        return com.qzone.proxy.feedcomponent.util.d.j(this.D.getFeedCommInfo().operatemask3, i3);
    }

    private void p1(int i3, BusinessFeedData businessFeedData) {
        c.InterfaceC0499c interfaceC0499c = this.f59437p0;
        if (interfaceC0499c != null) {
            interfaceC0499c.a(i3, businessFeedData);
        }
    }

    private void t1() {
        int i3;
        if (this.C == null || this.D == null) {
            return;
        }
        this.F = R1();
        this.E = E1();
        boolean d16 = r.f414520a.d(this.D);
        if (this.V == null || this.U == null) {
            return;
        }
        int i16 = this.D.getFeedCommInfo().operatemask;
        int i17 = this.D.getFeedCommInfo().operatemask2;
        int i18 = this.D.getPermissionInfo().permission_visit;
        if (this.E < 0 && this.G == i16 && this.H == i17 && i18 == this.J && d16 == this.I && !this.D.hasCustomDropList()) {
            return;
        }
        this.V.clear();
        VideoInfo videoInfo = this.D.getVideoInfo();
        boolean z16 = videoInfo != null && ((i3 = videoInfo.videoStatus) == 4 || i3 == 7);
        Z0();
        f1();
        if (n1(i17, 10)) {
            c.a a16 = c.a.a();
            a16.f59484a = 21;
            a16.f59486c = F1(21);
            this.V.i0(a16);
        }
        S0(z16, d16);
        V0();
        M0();
        d1();
        W0();
        U0();
        if (!S1()) {
            K0();
        }
        R0();
        g1();
        Q0();
        X0();
        P0();
        i1();
        L0();
        b1();
        if (S1() && !this.D.isFrdLikeVideoContainer() && !this.D.isFriendLikeVerticalSlideContainer() && !this.D.isPublicAccountContainer() && !this.D.isPublicAccountContent() && !this.D.isFriendPlayingFeed()) {
            K0();
        }
        if (this.D.hasCustomDropList()) {
            N1(z16);
        }
        this.I = d16;
        this.G = i16;
        this.H = i17;
        this.J = i18;
        this.V.notifyDataSetChanged();
    }

    private void w1(int i3, BusinessFeedData businessFeedData) {
        c.InterfaceC0499c interfaceC0499c = this.f59438q0;
        if (interfaceC0499c != null) {
            interfaceC0499c.a(i3, businessFeedData);
        }
    }

    private void x1(int i3, BusinessFeedData businessFeedData) {
        c.InterfaceC0499c interfaceC0499c = this.f59440s0;
        if (interfaceC0499c != null) {
            interfaceC0499c.a(i3, businessFeedData);
        }
    }

    private Drawable z1() {
        return new ColorDrawable(getContext().getColor(R.color.qui_common_bg_middle_light));
    }

    @Override // com.qzone.reborn.share.c
    public void B(int i3, c.d dVar) {
        this.f59441t0 = dVar;
    }

    @Override // com.qzone.reborn.share.c
    public void I(int i3, c.b bVar) {
        this.f59439r0 = bVar;
    }

    public boolean P1() {
        CellFeedCommInfo feedCommInfo;
        BusinessFeedData businessFeedData = this.D;
        return (businessFeedData == null || businessFeedData.getFeedCommInfo() == null || (feedCommInfo = this.D.getFeedCommInfo()) == null || (!feedCommInfo.isVideoAdv() && !feedCommInfo.isAppAdvFeed() && !feedCommInfo.isFamousRecommAdvFeed() && !feedCommInfo.isVideoAdvShareFeed())) ? false : true;
    }

    @Override // com.qzone.reborn.share.c
    public boolean j() {
        return isShowing();
    }

    public boolean k1(int i3, int i16) {
        if ((i3 & i16) != 0) {
            return true;
        }
        return false;
    }

    public void l2(i iVar) {
        this.f59425d1 = iVar;
    }

    private void L0() {
        if (m1(0)) {
            c.a a16 = c.a.a();
            a16.f59484a = 12;
            a16.f59486c = F1(12);
            this.V.i0(a16);
        }
    }

    private void b1() {
        if (m1(2)) {
            c.a a16 = c.a.a();
            a16.f59484a = 13;
            a16.f59486c = F1(13);
            this.V.i0(a16);
        }
    }

    private void d1() {
        if (l1(7) && T1()) {
            c.a a16 = c.a.a();
            a16.f59484a = 7;
            a16.f59486c = F1(7);
            this.V.i0(a16);
        }
    }

    private void f1() {
        if (o1(2)) {
            c.a a16 = c.a.a();
            a16.f59484a = 24;
            a16.f59486c = F1(24);
            this.V.i0(a16);
        }
    }

    private void init() {
        QZLog.d("QZoneFeedXBottomSheetMenuMore", 4, "init");
        LayoutInflater from = LayoutInflater.from(this.C);
        Window window = getWindow();
        if (window != null) {
            ImmersiveUtils.clearCoverForStatus(window, true);
            QUIImmersiveHelper.u(window, true, true);
        }
        ViewGroup viewGroup = (ViewGroup) from.inflate(R.layout.aur, (ViewGroup) null);
        this.Q = viewGroup;
        setContentView(viewGroup);
        this.R = this.Q.findViewById(R.id.m1g);
        this.S = this.Q.findViewById(R.id.m1i);
        this.T = this.Q.findViewById(R.id.m3x);
        RecyclerView recyclerView = (RecyclerView) this.Q.findViewById(R.id.mdc);
        this.U = recyclerView;
        recyclerView.setNestedScrollingEnabled(false);
        this.U.setLayoutManager(new LinearLayoutManager(this.C));
        View findViewById = findViewById(R.id.f162973nm3);
        View findViewById2 = findViewById(R.id.m3p);
        findViewById.setBackground(I1());
        findViewById2.setBackground(z1());
        findViewById(R.id.kug).setOnClickListener(new c());
        ((View) this.Q.getParent()).setOnClickListener(new d());
        e eVar = new e();
        this.Y = eVar;
        this.T.setOnTouchListener(eVar);
        this.U.setOnTouchListener(this.Y);
    }

    public Drawable A1(int i3) {
        try {
            Activity activity = this.C;
            if (activity != null) {
                return activity.getResources().getDrawable(i3);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        QZLog.d("QZoneFeedXBottomSheetMenuMore", 4, "dismiss");
        this.P.postDelayed(new Runnable() { // from class: com.qzone.reborn.share.QZoneFeedXBottomSheetMenuMore.7

            /* compiled from: P */
            /* renamed from: com.qzone.reborn.share.QZoneFeedXBottomSheetMenuMore$7$a */
            /* loaded from: classes37.dex */
            class a extends AnimatorListenerAdapter {
                a() {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    QZoneFeedXBottomSheetMenuMore.this.T.setAlpha(0.0f);
                    QZoneFeedXBottomSheetMenuMore.this.J0();
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                AnimatorSet animatorSet = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(QZoneFeedXBottomSheetMenuMore.this.T, (Property<View, Float>) View.TRANSLATION_Y, 0.0f, QZoneFeedXBottomSheetMenuMore.this.T.getHeight());
                ofFloat.setDuration(200L);
                ofFloat.addListener(new a());
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(QZoneFeedXBottomSheetMenuMore.this.R, (Property<View, Float>) View.ALPHA, 0.5f, 0.0f);
                ofFloat2.setDuration(200L);
                animatorSet.playTogether(ofFloat, ofFloat2);
                animatorSet.start();
            }
        }, 0L);
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        QZLog.d("QZoneFeedXBottomSheetMenuMore", 4, "show");
        this.T.setAlpha(0.0f);
        this.S.setVisibility(0);
        super.show();
        t1();
        this.P.postDelayed(new Runnable() { // from class: com.qzone.reborn.share.QZoneFeedXBottomSheetMenuMore.6

            /* compiled from: P */
            /* renamed from: com.qzone.reborn.share.QZoneFeedXBottomSheetMenuMore$6$a */
            /* loaded from: classes37.dex */
            class a extends AnimatorListenerAdapter {
                a() {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    QZoneFeedXBottomSheetMenuMore.this.T.setAlpha(1.0f);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                AnimatorSet animatorSet = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(QZoneFeedXBottomSheetMenuMore.this.T, (Property<View, Float>) View.TRANSLATION_Y, QZoneFeedXBottomSheetMenuMore.this.T.getHeight(), 0.0f);
                ofFloat.setDuration(200L);
                ofFloat.addListener(new a());
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(QZoneFeedXBottomSheetMenuMore.this.R, (Property<View, Float>) View.ALPHA, 0.0f, 0.5f);
                ofFloat2.setDuration(200L);
                animatorSet.playTogether(ofFloat, ofFloat2);
                animatorSet.start();
                QZoneFeedXBottomSheetMenuMore qZoneFeedXBottomSheetMenuMore = QZoneFeedXBottomSheetMenuMore.this;
                qZoneFeedXBottomSheetMenuMore.X = qZoneFeedXBottomSheetMenuMore.T.getHeight();
            }
        }, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class g extends RecyclerView.Adapter<h> {
        private LayoutInflater C;
        private List<c.a> D = new ArrayList();

        /* renamed from: m, reason: collision with root package name */
        private Context f59460m;

        public g(Context context) {
            this.f59460m = context;
            this.C = LayoutInflater.from(context);
        }

        private void m0(c.a aVar, h hVar) {
            s_droplist_option s_droplist_optionVar = aVar.f59487d;
            Drawable drawable = null;
            if (s_droplist_optionVar != null && !TextUtils.isEmpty(s_droplist_optionVar.iconurl)) {
                s_droplist_option s_droplist_optionVar2 = aVar.f59487d;
                int i3 = s_droplist_optionVar2.actiontype;
                if (i3 == 40) {
                    hVar.G.setImageDrawable(QZoneFeedXBottomSheetMenuMore.this.U0);
                } else if (i3 == 2) {
                    hVar.G.setImageDrawable(QZoneFeedXBottomSheetMenuMore.this.V0);
                } else {
                    hVar.G.setAsyncImage(an.a(s_droplist_optionVar2.iconurl));
                }
                hVar.F.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                hVar.G.setVisibility(0);
                return;
            }
            hVar.F.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            switch (aVar.f59484a) {
                case 1:
                    drawable = QZoneFeedXBottomSheetMenuMore.this.f59447z0;
                    break;
                case 2:
                    drawable = QZoneFeedXBottomSheetMenuMore.this.A0;
                    break;
                case 3:
                    drawable = QZoneFeedXBottomSheetMenuMore.this.F ? QZoneFeedXBottomSheetMenuMore.this.D0 : QZoneFeedXBottomSheetMenuMore.this.C0;
                    break;
                case 4:
                    drawable = QZoneFeedXBottomSheetMenuMore.this.H0;
                    break;
                case 5:
                    drawable = QZoneFeedXBottomSheetMenuMore.this.I0;
                    break;
                case 6:
                    drawable = QZoneFeedXBottomSheetMenuMore.this.B0;
                    break;
                case 7:
                    drawable = QZoneFeedXBottomSheetMenuMore.this.E0;
                    break;
                case 8:
                    drawable = QZoneFeedXBottomSheetMenuMore.this.F0;
                    break;
                case 9:
                    drawable = QZoneFeedXBottomSheetMenuMore.this.G0;
                    break;
                case 10:
                    hVar.F.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, QZoneFeedXBottomSheetMenuMore.this.K0, (Drawable) null);
                    drawable = QZoneFeedXBottomSheetMenuMore.this.J0;
                    break;
                case 11:
                    drawable = QZoneFeedXBottomSheetMenuMore.this.L0;
                    break;
                case 12:
                    drawable = QZoneFeedXBottomSheetMenuMore.this.M0;
                    break;
                case 13:
                    drawable = QZoneFeedXBottomSheetMenuMore.this.I0;
                    break;
                case 15:
                    drawable = QZoneFeedXBottomSheetMenuMore.this.I0;
                    break;
                case 16:
                    drawable = QZoneFeedXBottomSheetMenuMore.this.N0;
                    break;
                case 19:
                    drawable = QZoneFeedXBottomSheetMenuMore.this.R0;
                    break;
                case 21:
                    if (QZoneFeedXBottomSheetMenuMore.this.D == null || !QZoneFeedXBottomSheetMenuMore.this.D.hasDropdownFinishedAddFriend) {
                        drawable = QZoneFeedXBottomSheetMenuMore.this.O0;
                        break;
                    } else {
                        drawable = QZoneFeedXBottomSheetMenuMore.this.P0;
                        break;
                    }
                    break;
                case 22:
                    drawable = QZoneFeedXBottomSheetMenuMore.this.Q0;
                    break;
                case 23:
                    drawable = QZoneFeedXBottomSheetMenuMore.this.S0;
                    break;
                case 24:
                    drawable = QZoneFeedXBottomSheetMenuMore.this.T0;
                    break;
                case 25:
                    drawable = QZoneFeedXBottomSheetMenuMore.this.W0;
                    break;
            }
            if (drawable != null) {
                hVar.G.setImageDrawable(drawable);
                hVar.G.setVisibility(0);
            }
        }

        public void clear() {
            Iterator<c.a> it = this.D.iterator();
            while (it.hasNext()) {
                c.a.b(it.next());
            }
            this.D.clear();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return this.D.size();
        }

        public List<c.a> j0() {
            return this.D;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(h hVar, int i3) {
            c.a aVar = j0().get(i3);
            if (aVar == null) {
                return;
            }
            int i16 = aVar.f59484a;
            if ((i16 == 8 || i16 == 9) && QZoneFeedXBottomSheetMenuMore.this.E >= 0) {
                int i17 = QZoneFeedXBottomSheetMenuMore.this.E;
                aVar.f59484a = i17;
                aVar.f59486c = QZoneFeedXBottomSheetMenuMore.this.F1(i17);
            }
            j jVar = new j(aVar);
            hVar.E = aVar;
            hVar.F.setText(aVar.f59486c);
            hVar.itemView.setOnClickListener(jVar);
            s_droplist_option s_droplist_optionVar = aVar.f59487d;
            if (s_droplist_optionVar == null || s_droplist_optionVar.iconurl == null) {
                hVar.G.setVisibility(8);
            }
            int i18 = aVar.f59484a;
            if (i18 == 3) {
                hVar.F.setText(QZoneFeedXBottomSheetMenuMore.this.B1());
            } else if (i18 == 10) {
                hVar.F.setText(QZoneFeedXBottomSheetMenuMore.this.C1());
            }
            m0(aVar, hVar);
            if (aVar.f59484a == 21) {
                if (QZoneFeedXBottomSheetMenuMore.this.D != null && QZoneFeedXBottomSheetMenuMore.this.D.hasDropdownFinishedAddFriend) {
                    hVar.F.setAlpha(0.3f);
                    hVar.F.setText("");
                } else {
                    hVar.F.setAlpha(1.0f);
                }
                hVar.F.setText(QZoneFeedXBottomSheetMenuMore.this.F1(aVar.f59484a));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: l0, reason: merged with bridge method [inline-methods] */
        public h onCreateViewHolder(ViewGroup viewGroup, int i3) {
            return new h(this.C.inflate(R.layout.f167266ax0, viewGroup, false));
        }

        public void i0(c.a aVar) {
            if (aVar == null) {
                return;
            }
            this.D.add(aVar);
        }
    }

    private void M0() {
        if (l1(17) && y.f(this.D)) {
            c.a a16 = c.a.a();
            a16.f59484a = 3;
            a16.f59486c = B1();
            this.V.i0(a16);
        }
    }

    private void Q0() {
        if (l1(10)) {
            c.a a16 = c.a.a();
            a16.f59484a = 2;
            a16.f59486c = F1(2);
            this.V.i0(a16);
        }
    }

    private void R0() {
        if (l1(9)) {
            c.a a16 = c.a.a();
            a16.f59484a = 1;
            a16.f59486c = F1(1);
            this.V.i0(a16);
        }
    }

    private void U0() {
        if (l1(25)) {
            c.a a16 = c.a.a();
            a16.f59484a = 5;
            a16.f59486c = F1(5);
            this.V.i0(a16);
        }
    }

    private void W0() {
        if (l1(24)) {
            c.a a16 = c.a.a();
            a16.f59484a = 4;
            a16.f59486c = F1(4);
            this.V.i0(a16);
        }
    }

    private void X0() {
        if (l1(21)) {
            c.a a16 = c.a.a();
            a16.f59484a = 6;
            a16.f59486c = F1(6);
            this.V.i0(a16);
        }
    }

    private void c2(int i3, BusinessFeedData businessFeedData) {
        c.InterfaceC0499c interfaceC0499c;
        if (businessFeedData == null || (interfaceC0499c = this.f59446y0) == null) {
            return;
        }
        interfaceC0499c.a(i3, businessFeedData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d2(int i3, BusinessFeedData businessFeedData, c.a aVar) {
        if (businessFeedData == null || aVar.f59487d == null) {
            return;
        }
        if (!NetworkUtil.isNetworkAvailable(this.C)) {
            ToastUtil.r(G1(R.string.f171139ci4));
        }
        c.d dVar = this.f59441t0;
        if (dVar != null) {
            dVar.a(this.M, this.D, aVar.f59487d);
        }
        s_droplist_option s_droplist_optionVar = aVar.f59487d;
        int i16 = s_droplist_optionVar.actiontype;
        if (i16 != 2) {
            if (i16 == 3) {
                yo.d.d(s_droplist_optionVar.jumpurl, this.C, null);
                return;
            }
            if (i16 != 23) {
                if (i16 == 41) {
                    g2(this.M, this.D, aVar);
                    return;
                } else {
                    if (i16 != 42) {
                        return;
                    }
                    Z1(i3, businessFeedData);
                    return;
                }
            }
        }
        yo.d.d(s_droplist_optionVar.jumpurl, this.C, null);
    }

    private void f2(int i3, BusinessFeedData businessFeedData) {
        c.InterfaceC0499c interfaceC0499c;
        if (businessFeedData == null || (interfaceC0499c = this.f59445x0) == null) {
            return;
        }
        interfaceC0499c.a(i3, businessFeedData);
        ap.f59791b.e(220, 1, i3, businessFeedData);
    }

    private void g1() {
        if (!m1(27) || this.D.getPermissionInfo().permission_visit == 3) {
            return;
        }
        c.a a16 = c.a.a();
        a16.f59484a = 22;
        a16.f59486c = F1(22);
        this.V.i0(a16);
    }

    private void i1() {
        if (l1(30)) {
            c.a a16 = c.a.a();
            a16.f59484a = 11;
            a16.f59486c = F1(11);
            this.V.i0(a16);
        }
    }

    private void v1(int i3, BusinessFeedData businessFeedData, c.a aVar, int i16, boolean z16) {
        s_droplist_option s_droplist_optionVar;
        c.b bVar;
        if (aVar == null || (s_droplist_optionVar = aVar.f59487d) == null || (bVar = this.f59439r0) == null) {
            return;
        }
        bVar.a(i3, businessFeedData, s_droplist_optionVar, i16, z16);
        int i17 = aVar.f59488e;
        if (i17 == -1 || i17 > 2) {
            return;
        }
        ClickReport.q("584", "19", (aVar.f59488e + 12) + "", true);
    }

    public boolean Q1(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getUser() == null) {
            return false;
        }
        return businessFeedData.getUser().isCanShowFamousIcon();
    }

    public void e2(int i3, BusinessFeedData businessFeedData, c.a aVar) {
        s_droplist_option s_droplist_optionVar;
        if (aVar == null || (s_droplist_optionVar = aVar.f59487d) == null) {
            return;
        }
        if (k1(s_droplist_optionVar.action_detail, 1)) {
            Map<String, String> map = aVar.f59487d.extend_info;
            String str = map.get(AECameraConstants.KEY_CONFIRM_TEXT);
            String str2 = map.get("ok_text");
            String str3 = map.get("cancel_text");
            if (TextUtils.isEmpty(str2)) {
                str2 = G1(R.string.a8j);
            }
            String str4 = str2;
            if (TextUtils.isEmpty(str3)) {
                str3 = G1(R.string.cancel);
            }
            new com.qzone.component.e().h(this.C, str, "", str4, str3, new f(i3, businessFeedData, aVar), null);
            return;
        }
        d2(i3, businessFeedData, aVar);
    }

    public QZoneFeedXBottomSheetMenuMore(Activity activity, BusinessFeedData businessFeedData) {
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
        this.f59418a0 = null;
        this.f59420b0 = null;
        this.f59422c0 = null;
        this.f59424d0 = null;
        this.f59426e0 = null;
        this.f59427f0 = null;
        this.f59428g0 = null;
        this.f59429h0 = null;
        this.f59430i0 = null;
        this.f59431j0 = null;
        this.f59432k0 = null;
        this.f59433l0 = null;
        this.f59434m0 = null;
        this.f59435n0 = null;
        this.f59436o0 = null;
        this.f59437p0 = null;
        this.f59438q0 = null;
        this.f59439r0 = null;
        this.f59440s0 = null;
        this.f59441t0 = null;
        this.f59442u0 = null;
        this.f59443v0 = null;
        this.f59444w0 = null;
        this.f59445x0 = null;
        this.f59446y0 = null;
        this.X0 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewMenu", "\u83dc\u5355");
        this.Y0 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewReduceRecommend", "\u51cf\u5c11\u6b64\u4eba\u63a8\u8350");
        this.Z0 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewNotInterestAndHide", "\u4e0d\u611f\u5174\u8da3\u5e76\u9690\u85cf");
        this.f59419a1 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewHadSendApply", "\u5df2\u53d1\u9001\u597d\u53cb\u7533\u8bf7");
        this.f59421b1 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewAddFriend", "\u6dfb\u52a0\u597d\u53cb");
        this.f59423c1 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewNotShowAnyMore", "\u4e0d\u518d\u663e\u793a");
        this.C = activity;
        this.D = businessFeedData;
        this.P = new a(Looper.getMainLooper());
        O1();
        init();
        M1();
        lg.e.f414458a.a(this.D, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String F1(int i3) {
        switch (i3) {
            case 0:
                return G1(R.string.f21965670);
            case 1:
                return G1(R.string.gfe);
            case 2:
                return G1(R.string.gfc);
            case 3:
                return B1();
            case 4:
                return G1(R.string.gfh);
            case 5:
                return G1(R.string.gfg);
            case 6:
                return G1(R.string.gfi);
            case 7:
                if (this.D.getFeedCommInfo().appid == 2) {
                    return G1(R.string.gfj);
                }
                return G1(R.string.f173011gg4);
            case 8:
                return G1(R.string.gfn);
            case 9:
                return G1(R.string.gfo);
            case 10:
                return C1();
            case 11:
                return G1(R.string.gi6);
            case 12:
                return G1(R.string.gd_);
            case 13:
                return this.f59423c1;
            case 14:
            case 15:
            case 17:
            case 18:
            case 20:
            default:
                return "";
            case 16:
                return G1(R.string.gff);
            case 19:
                return G1(R.string.gfd);
            case 21:
                if (this.D.hasDropdownFinishedAddFriend) {
                    return this.f59419a1;
                }
                return this.f59421b1;
            case 22:
                return G1(R.string.gfl);
            case 23:
                if (S1()) {
                    return "\u67e5\u770bTa\u7684\u88c5\u626e";
                }
                return l.a(R.string.s4y);
            case 24:
                return G1(R.string.gh_);
            case 25:
                return G1(R.string.f2196266x) + QZoneConfigHelper.W();
        }
    }

    private void K1(int i3, BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        c.InterfaceC0499c interfaceC0499c = this.f59418a0;
        if (interfaceC0499c != null) {
            interfaceC0499c.a(i3, businessFeedData);
        }
        com.qzone.proxy.feedcomponent.i uiInterface = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface();
        com.qzone.adapter.feedcomponent.i.H();
        uiInterface.doFloatViewActionReport(19);
        ap.f59791b.e(46, 1, i3, businessFeedData);
    }

    private void L1(int i3, BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        c.InterfaceC0499c interfaceC0499c = this.f59420b0;
        if (interfaceC0499c != null) {
            interfaceC0499c.a(i3, businessFeedData);
        }
        com.qzone.proxy.feedcomponent.i uiInterface = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface();
        com.qzone.adapter.feedcomponent.i.H();
        uiInterface.doFloatViewActionReport(18);
        ap.f59791b.e(45, 1, i3, businessFeedData);
    }

    private void O1() {
        this.f59447z0 = A1(R.drawable.qui_edit_plus);
        this.A0 = A1(R.drawable.qui_delete);
        this.B0 = A1(R.drawable.qui_complaint);
        this.C0 = A1(R.drawable.qui_collection);
        this.D0 = A1(R.drawable.qui_collection_off);
        this.E0 = A1(R.drawable.qui_image);
        this.F0 = A1(R.drawable.qui_subtitle_on);
        this.G0 = A1(R.drawable.qui_subtitle_off);
        this.H0 = A1(R.drawable.qui_hide_state);
        this.I0 = A1(R.drawable.qui_eye_off);
        this.J0 = A1(R.drawable.qui_set_top);
        this.O0 = A1(R.drawable.qui_add_friend);
        this.Q0 = A1(R.drawable.qui_lock);
        this.R0 = A1(R.drawable.qui_download);
        this.S0 = A1(R.drawable.qui_special_effect);
        this.T0 = A1(R.drawable.qui_greeting);
        this.U0 = A1(R.drawable.qui_close_circle);
        this.V0 = A1(R.drawable.qui_feedback);
        this.W0 = A1(R.drawable.qui_intimates_space);
    }

    private void T0(int i3, BusinessFeedData businessFeedData) {
        c.InterfaceC0499c interfaceC0499c;
        if (businessFeedData == null || (interfaceC0499c = this.Z) == null) {
            return;
        }
        interfaceC0499c.a(i3, businessFeedData);
    }

    private void g2(int i3, BusinessFeedData businessFeedData, c.a aVar) {
        if (businessFeedData == null) {
            return;
        }
        if (businessFeedData.isAdFeeds()) {
            v1(i3, businessFeedData, aVar, -1, false);
        }
        c.InterfaceC0499c interfaceC0499c = this.f59427f0;
        if (interfaceC0499c != null) {
            interfaceC0499c.a(i3, businessFeedData);
        }
        com.qzone.proxy.feedcomponent.i uiInterface = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface();
        com.qzone.adapter.feedcomponent.i.H();
        uiInterface.doFloatViewActionReport(22);
        ap.f59791b.e(47, 1, i3, businessFeedData);
    }

    private void j1(int i3, BusinessFeedData businessFeedData) {
        c.InterfaceC0499c interfaceC0499c;
        if (businessFeedData == null || (interfaceC0499c = this.f59444w0) == null) {
            return;
        }
        interfaceC0499c.a(i3, businessFeedData);
    }

    private void j2(int i3, BusinessFeedData businessFeedData) {
        c.InterfaceC0499c interfaceC0499c;
        if (businessFeedData == null || (interfaceC0499c = this.f59443v0) == null) {
            return;
        }
        interfaceC0499c.a(i3, businessFeedData);
    }

    private void u1(int i3, BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        c.InterfaceC0499c interfaceC0499c = this.f59424d0;
        if (interfaceC0499c != null) {
            interfaceC0499c.a(i3, businessFeedData);
        }
        com.qzone.proxy.feedcomponent.i uiInterface = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface();
        com.qzone.adapter.feedcomponent.i.H();
        uiInterface.doFloatViewActionReport(21);
    }

    private void y1(int i3, BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        c.InterfaceC0499c interfaceC0499c = this.f59422c0;
        if (interfaceC0499c != null) {
            interfaceC0499c.a(i3, businessFeedData);
        }
        com.qzone.proxy.feedcomponent.i uiInterface = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface();
        com.qzone.adapter.feedcomponent.i.H();
        uiInterface.doFloatViewActionReport(20);
    }

    public void h2(int i3, BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        c.InterfaceC0499c interfaceC0499c = this.f59430i0;
        if (interfaceC0499c != null) {
            interfaceC0499c.a(i3, businessFeedData);
        }
        com.qzone.proxy.feedcomponent.i uiInterface = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface();
        com.qzone.adapter.feedcomponent.i.H();
        uiInterface.doFloatViewActionReport(17);
        ap.f59791b.e(51, 1, i3, businessFeedData);
    }

    public void m2(int i3, BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        c.InterfaceC0499c interfaceC0499c = this.f59431j0;
        if (interfaceC0499c != null) {
            interfaceC0499c.a(i3, businessFeedData);
        }
        LpReportInfo_pf00064.allReport(302, 549, Q1(businessFeedData) ? 1 : 2);
        com.qzone.proxy.feedcomponent.i uiInterface = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface();
        com.qzone.adapter.feedcomponent.i.H();
        uiInterface.doFloatViewActionReport(23);
    }

    public void n2(int i3, BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        c.InterfaceC0499c interfaceC0499c = this.f59433l0;
        if (interfaceC0499c != null) {
            interfaceC0499c.a(i3, businessFeedData);
        }
        LpReportInfo_pf00064.allReport(302, 550, Q1(businessFeedData) ? 1 : 2);
        com.qzone.proxy.feedcomponent.i uiInterface = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface();
        com.qzone.adapter.feedcomponent.i.H();
        uiInterface.doFloatViewActionReport(24);
    }

    public void r1(int i3, BusinessFeedData businessFeedData, c.a aVar) {
        if (businessFeedData == null) {
            return;
        }
        boolean R1 = R1();
        c.InterfaceC0499c interfaceC0499c = this.f59428g0;
        if (interfaceC0499c != null) {
            interfaceC0499c.a(i3, businessFeedData);
        }
        v1(i3, businessFeedData, aVar, -1, R1);
        if (!R1) {
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

    private void S0(boolean z16, boolean z17) {
        if (z16 || !z17) {
            return;
        }
        c.a a16 = c.a.a();
        a16.f59484a = 10;
        a16.f59486c = C1();
        this.V.i0(a16);
    }

    private boolean V1(s_droplist_option s_droplist_optionVar) {
        if (s_droplist_optionVar == null) {
            return false;
        }
        int i3 = s_droplist_optionVar.reporttypeV2;
        return i3 == 4 || i3 == 5;
    }

    @Override // com.qzone.reborn.share.c
    public void m(int i3, c.InterfaceC0499c interfaceC0499c) {
        switch (i3) {
            case 1:
                this.Z = interfaceC0499c;
                return;
            case 2:
                this.f59418a0 = interfaceC0499c;
                return;
            case 3:
                this.f59420b0 = interfaceC0499c;
                return;
            case 4:
                this.f59422c0 = interfaceC0499c;
                return;
            case 5:
                this.f59424d0 = interfaceC0499c;
                return;
            case 6:
                this.f59426e0 = interfaceC0499c;
                return;
            case 7:
                this.f59427f0 = interfaceC0499c;
                return;
            case 8:
                this.f59428g0 = interfaceC0499c;
                return;
            case 9:
                this.f59429h0 = interfaceC0499c;
                return;
            case 10:
                this.f59430i0 = interfaceC0499c;
                return;
            case 11:
                this.f59431j0 = interfaceC0499c;
                return;
            case 12:
                this.f59432k0 = interfaceC0499c;
                return;
            case 13:
                this.f59433l0 = interfaceC0499c;
                return;
            case 14:
                this.f59434m0 = interfaceC0499c;
                return;
            case 15:
                this.f59435n0 = interfaceC0499c;
                return;
            case 16:
                this.f59436o0 = interfaceC0499c;
                return;
            case 17:
                this.f59437p0 = interfaceC0499c;
                return;
            case 18:
                this.f59438q0 = interfaceC0499c;
                return;
            case 19:
            case 21:
            case 26:
            default:
                return;
            case 20:
                this.f59440s0 = interfaceC0499c;
                return;
            case 22:
                this.f59442u0 = interfaceC0499c;
                return;
            case 23:
                this.f59443v0 = interfaceC0499c;
                return;
            case 24:
                this.f59444w0 = interfaceC0499c;
                return;
            case 25:
                this.f59445x0 = interfaceC0499c;
                return;
            case 27:
                this.f59446y0 = interfaceC0499c;
                return;
        }
    }
}
