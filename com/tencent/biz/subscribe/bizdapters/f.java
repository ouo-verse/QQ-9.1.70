package com.tencent.biz.subscribe.bizdapters;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$StGetFeedDetailRsp;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.bizdapters.c;
import com.tencent.biz.subscribe.fragments.SubscribeVideoDetailFragment;
import com.tencent.biz.subscribe.part.block.MultiViewBlock;
import com.tencent.biz.subscribe.part.block.a;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.biz.subscribe.widget.SubscribeFollowInfoView;
import com.tencent.biz.subscribe.widget.SubscribeShareHelper;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeVideoHeadItemView;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import com.tencent.widget.itemtouchhelper.GestureDetectorCompat;
import common.config.service.QzoneConfig;
import java.util.List;
import java.util.Stack;

/* compiled from: P */
/* loaded from: classes5.dex */
public class f extends DetailBaseBlock implements bf0.b {
    public static final int E0 = (ImmersiveUtils.getScreenHeight() * 2) / 3;
    private ViewGroup A0;
    private View B0;
    private View C0;
    private boolean D0;

    /* renamed from: e0, reason: collision with root package name */
    private SystemBarCompact f95803e0;

    /* renamed from: f0, reason: collision with root package name */
    private VideoPlayerView f95804f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f95805g0;

    /* renamed from: h0, reason: collision with root package name */
    private int f95806h0;

    /* renamed from: i0, reason: collision with root package name */
    private Stack<CertifiedAccountMeta$StFeed> f95807i0;

    /* renamed from: j0, reason: collision with root package name */
    private RelativeVideoHeadItemView f95808j0;

    /* renamed from: k0, reason: collision with root package name */
    private long f95809k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f95810l0;

    /* renamed from: m0, reason: collision with root package name */
    private int f95811m0;

    /* renamed from: n0, reason: collision with root package name */
    private int f95812n0;

    /* renamed from: o0, reason: collision with root package name */
    private int f95813o0;

    /* renamed from: p0, reason: collision with root package name */
    private ImageView f95814p0;

    /* renamed from: q0, reason: collision with root package name */
    private RelativeLayout f95815q0;

    /* renamed from: r0, reason: collision with root package name */
    private ImageView f95816r0;

    /* renamed from: s0, reason: collision with root package name */
    private ImageView f95817s0;

    /* renamed from: t0, reason: collision with root package name */
    private SubscribeFollowInfoView f95818t0;

    /* renamed from: u0, reason: collision with root package name */
    private boolean f95819u0;

    /* renamed from: v0, reason: collision with root package name */
    private GestureDetectorCompat f95820v0;

    /* renamed from: w0, reason: collision with root package name */
    private int f95821w0;

    /* renamed from: x0, reason: collision with root package name */
    private int f95822x0;

    /* renamed from: y0, reason: collision with root package name */
    private int f95823y0;

    /* renamed from: z0, reason: collision with root package name */
    private int f95824z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!hf0.a.a("SUB_ENTER_FLOAT_MODE") && f.this.f95804f0 != null) {
                f.this.f95804f0.o1();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CertifiedAccountMeta$StFeed v16;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!DetailBaseBlock.isFastClick() && (v16 = f.this.v1()) != null) {
                f.this.D1(v16);
                if (f.this.w1() != null) {
                    f.this.w1().L0(v16);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (f.this.w1() != null) {
                CertifiedAccountMeta$StFeed J0 = f.this.w1().J0();
                if (J0 != null) {
                    f.this.D1(J0);
                } else {
                    QQToast.makeText(f.this.y(), 1, HardCodeUtil.qqStr(R.string.txe), 0).show();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class d implements c.d {
        d() {
        }

        @Override // com.tencent.biz.subscribe.bizdapters.c.d
        public void a(View view, CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
            f.this.D1(certifiedAccountMeta$StFeed);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.subscribe.bizdapters.f$f, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class ViewOnTouchListenerC0963f implements View.OnTouchListener {
        ViewOnTouchListenerC0963f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                f.this.f95822x0 = 0;
            }
            if (f.this.f95820v0 != null) {
                f.this.f95820v0.onTouchEvent(motionEvent);
                return true;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class g extends GestureDetector.SimpleOnGestureListener {
        g() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            int i3;
            int i16;
            float y16 = motionEvent2.getY() - f.this.f95822x0;
            if (f.this.f95811m0 < f.this.f95810l0) {
                return false;
            }
            if (y16 > 0.0f && f.this.f95813o0 < f.this.f95812n0) {
                float abs = f.this.f95813o0 + Math.abs(y16);
                f fVar = f.this;
                if (abs > fVar.f95812n0) {
                    i16 = f.this.f95812n0;
                } else {
                    i16 = (int) abs;
                }
                fVar.f95813o0 = i16;
            } else if (y16 < 0.0f && f.this.f95813o0 > f.this.f95806h0) {
                float abs2 = f.this.f95813o0 - Math.abs(y16);
                f fVar2 = f.this;
                if (abs2 < fVar2.f95806h0) {
                    i3 = f.this.f95806h0;
                } else {
                    i3 = (int) abs2;
                }
                fVar2.f95813o0 = i3;
            }
            if (f.this.f95804f0 != null) {
                f.this.f95804f0.getLayoutParams().height = f.this.f95813o0;
                f.this.f95804f0.requestLayout();
            }
            return super.onScroll(motionEvent, motionEvent2, f16, f17);
        }
    }

    public f(Bundle bundle) {
        super(bundle);
        boolean z16;
        int screenWidth = ImmersiveUtils.getScreenWidth();
        this.f95805g0 = screenWidth;
        this.f95806h0 = (screenWidth * 9) / 16;
        if (Integer.parseInt(QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QQ_SUBSCRIBE_SETTING, QzoneConfig.SECONDARY_SHOW_FLOAT_ENTRANCE, "1")) > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f95819u0 = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A1(MotionEvent motionEvent) {
        int i3;
        if (this.f95811m0 < this.f95810l0) {
            return false;
        }
        if (K() != null && (K().getLayoutManager() instanceof StaggeredGridLayoutManager)) {
            int[] iArr = new int[K().getLayoutManager().getColumnCountForAccessibility(null, null)];
            ((StaggeredGridLayoutManager) K().getLayoutManager()).findFirstCompletelyVisibleItemPositions(iArr);
            i3 = iArr[0];
        } else {
            i3 = 0;
        }
        int action = motionEvent.getAction();
        int actionIndex = motionEvent.getActionIndex();
        if (action != 0) {
            if (action != 2) {
                return false;
            }
            int x16 = (int) (motionEvent.getX() + 0.5f);
            int y16 = (int) (motionEvent.getY() + 0.5f);
            int i16 = x16 - this.f95823y0;
            int i17 = (int) ((y16 - this.f95822x0) * 0.6f);
            if (Math.abs(i16) > this.f95821w0 && Math.abs(i16) >= Math.abs(i17)) {
                return false;
            }
            float y17 = motionEvent.getY() - this.f95822x0;
            if (y17 < 0.0f && this.f95813o0 > this.f95806h0) {
                return true;
            }
            if (y17 > 0.0f && this.f95813o0 < this.f95812n0 && i3 == 0) {
                return true;
            }
        } else {
            this.f95823y0 = (int) (motionEvent.getX() + 0.5f);
            this.f95822x0 = (int) (motionEvent.getY() + 0.5f);
            this.f95824z0 = MotionEventCompat.findPointerIndex(motionEvent, actionIndex);
        }
        return false;
    }

    private void B1(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        if (StringUtil.isEmpty(certifiedAccountMeta$StFeed.video.fileId.get())) {
            QLog.w(DetailBaseBlock.f95725c0, 1, "video fileId is empty");
            return;
        }
        if (StringUtil.isEmpty(certifiedAccountMeta$StFeed.video.playUrl.get())) {
            QLog.w(DetailBaseBlock.f95725c0, 1, "video playUrl is empty");
            return;
        }
        VideoPlayerView videoPlayerView = this.f95804f0;
        if (videoPlayerView != null) {
            this.D0 = true;
            videoPlayerView.setVideoViewCover(certifiedAccountMeta$StFeed.cover.url.get());
            this.f95804f0.setVideoFeeds(certifiedAccountMeta$StFeed);
        }
    }

    private void C1(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        if (this.f95807i0 == null) {
            this.f95807i0 = new Stack<>();
        }
        this.f95807i0.push(certifiedAccountMeta$StFeed);
        VideoPlayerView videoPlayerView = this.f95804f0;
        if (videoPlayerView != null) {
            boolean z16 = true;
            if (this.f95807i0.size() <= 1) {
                z16 = false;
            }
            videoPlayerView.X1(z16);
        }
    }

    private void E1() {
        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = this.N;
        if (certifiedAccountMeta$StFeed == null) {
            return;
        }
        this.f95810l0 = certifiedAccountMeta$StFeed.video.width.get();
        this.f95811m0 = this.N.video.height.get();
        QLog.i(DetailBaseBlock.f95725c0, 1, "resetVideoHW width:" + this.f95810l0 + ", height:" + this.f95811m0);
        if (this.f95810l0 <= 0) {
            this.f95810l0 = 1920;
            this.f95811m0 = 1080;
        }
        int x16 = (int) (this.f95805g0 * x1());
        int i3 = E0;
        if (x16 > i3) {
            x16 = i3;
        }
        this.f95812n0 = x16;
        this.f95813o0 = x16;
    }

    private void G1() {
        E1();
        VideoPlayerView videoPlayerView = this.f95804f0;
        if (videoPlayerView != null) {
            videoPlayerView.k1(new int[]{this.f95805g0, this.f95812n0});
            if (!this.f95804f0.z1()) {
                this.f95804f0.getLayoutParams().height = this.f95812n0;
                this.f95804f0.requestLayout();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CertifiedAccountMeta$StFeed v1() {
        Stack<CertifiedAccountMeta$StFeed> stack = this.f95807i0;
        if (stack == null || stack.empty()) {
            return null;
        }
        this.f95807i0.pop();
        if (this.f95807i0.empty()) {
            return null;
        }
        return this.f95807i0.pop();
    }

    private float x1() {
        return this.f95811m0 / this.f95810l0;
    }

    private void y1() {
        this.f95817s0.setOnClickListener(new a());
        this.f95804f0.setPreviewVideoClickListener(new b());
        this.f95804f0.setNextVideoClickListener(new c());
        if (w1() != null) {
            w1().N0(new d());
        }
        K().addOnItemTouchListener(new e());
        this.f95818t0.setOnTouchListener(new ViewOnTouchListenerC0963f());
    }

    private void z1(View view) {
        this.f95804f0 = (VideoPlayerView) view.findViewById(R.id.mfu);
        View findViewById = view.findViewById(R.id.lqn);
        this.B0 = findViewById;
        this.C0 = findViewById.findViewById(R.id.lpl);
        this.f95804f0.setWifiAutoPlay(true);
        this.f95804f0.setNeedWifiTips(true);
        this.f95804f0.setHostFragment((SubscribeVideoDetailFragment) J());
        this.f95804f0.j1(this.L);
        this.f95804f0.X1(false);
        this.f95804f0.i1(this.f95815q0);
        this.f95820v0 = new GestureDetectorCompat(y(), new g());
        this.f95821w0 = ViewConfiguration.get(y()).getScaledTouchSlop();
        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = this.N;
        if (certifiedAccountMeta$StFeed != null) {
            this.f95804f0.setVideoViewCover(certifiedAccountMeta$StFeed.cover.url.get());
            if (!this.N.video.fileId.get().equals("") || !this.N.video.playUrl.get().equals("")) {
                B1(this.N);
            }
        }
        this.f95804f0.setExtraTypeInfo(D());
    }

    public void D1(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        if (certifiedAccountMeta$StFeed != null && System.currentTimeMillis() - this.f95809k0 >= 500) {
            this.f95809k0 = System.currentTimeMillis();
            VSReporter.n(certifiedAccountMeta$StFeed.poster.f24929id.get(), "auth_" + SubscribeShareHelper.s(D()), "clk_recom", 0, 0, "", "", certifiedAccountMeta$StFeed.f24925id.get(), certifiedAccountMeta$StFeed.title.get());
            if (!com.tencent.biz.subscribe.d.h(certifiedAccountMeta$StFeed.type.get())) {
                com.tencent.biz.subscribe.d.o(y(), certifiedAccountMeta$StFeed);
                if (y() != null) {
                    y().finish();
                    return;
                }
                return;
            }
            VideoPlayerView videoPlayerView = this.f95804f0;
            if (videoPlayerView != null) {
                videoPlayerView.e0();
            }
            this.N = certifiedAccountMeta$StFeed;
            C1(certifiedAccountMeta$StFeed);
            G1();
            this.D0 = false;
            B1(this.N);
            this.L.t(certifiedAccountMeta$StFeed);
            f0("share_key_subscribe_feeds_update", new a.d(certifiedAccountMeta$StFeed, true));
            if (K() != null) {
                K().scrollToPosition(0);
            }
        }
    }

    public void F1(ViewGroup viewGroup) {
        this.A0 = viewGroup;
    }

    @Override // com.tencent.biz.subscribe.bizdapters.DetailBaseBlock
    protected void L0(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        view.setLayoutParams(layoutParams);
        this.A0.addView(view, layoutParams);
    }

    @Override // com.tencent.biz.subscribe.bizdapters.DetailBaseBlock
    protected View S0() {
        return this.C0;
    }

    @Override // com.tencent.biz.subscribe.bizdapters.DetailBaseBlock
    protected void T0(CertifiedAccountRead$StGetFeedDetailRsp certifiedAccountRead$StGetFeedDetailRsp, boolean z16) {
        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = certifiedAccountRead$StGetFeedDetailRsp.feed.get();
        if (this.f95804f0 != null && certifiedAccountMeta$StFeed != null && com.tencent.biz.subscribe.d.h(certifiedAccountMeta$StFeed.type.get())) {
            RelativeVideoHeadItemView relativeVideoHeadItemView = this.f95808j0;
            if (relativeVideoHeadItemView != null) {
                relativeVideoHeadItemView.setData(certifiedAccountMeta$StFeed);
            }
            SubscribeFollowInfoView subscribeFollowInfoView = this.f95818t0;
            if (subscribeFollowInfoView != null) {
                subscribeFollowInfoView.setData(certifiedAccountMeta$StFeed);
            }
            ImageView imageView = this.f95817s0;
            if (imageView != null && this.f95819u0) {
                imageView.setVisibility(0);
            }
            ImageView imageView2 = this.f95816r0;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            if (!this.D0) {
                B1(certifiedAccountMeta$StFeed);
            } else {
                QLog.i(DetailBaseBlock.f95725c0, 1, "has init played");
            }
            if (this.B0.getVisibility() == 8) {
                this.B0.setVisibility(0);
            }
        }
    }

    @Override // com.tencent.biz.subscribe.bizdapters.DetailBaseBlock, com.tencent.biz.subscribe.part.block.MultiViewBlock
    public boolean X() {
        VideoPlayerView videoPlayerView = this.f95804f0;
        if (videoPlayerView != null && videoPlayerView.E1()) {
            return true;
        }
        return super.X();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.subscribe.bizdapters.DetailBaseBlock
    public void X0(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        VideoPlayerView videoPlayerView;
        super.X0(certifiedAccountMeta$StFeed);
        if (this.L != null && (videoPlayerView = this.f95804f0) != null && videoPlayerView.z1()) {
            this.L.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.subscribe.bizdapters.DetailBaseBlock
    public void Y0(long j3, String str) {
        super.Y0(j3, str);
        ImageView imageView = this.f95817s0;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        ImageView imageView2 = this.f95816r0;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        if (this.B0 != null) {
            VideoPlayerView videoPlayerView = this.f95804f0;
            if (videoPlayerView != null) {
                videoPlayerView.e0();
            }
            this.B0.setVisibility(8);
        }
    }

    @Override // com.tencent.biz.subscribe.bizdapters.DetailBaseBlock, com.tencent.biz.subscribe.part.block.MultiViewBlock
    public void a0(Bundle bundle) {
        SystemBarCompact systemBarCompact;
        super.a0(bundle);
        this.f95803e0 = SystemBarActivityModule.getSystemBarComp((PublicFragmentActivity) y());
        if (!SimpleUIUtil.getSimpleUISwitch() && (systemBarCompact = this.f95803e0) != null) {
            systemBarCompact.setStatusBarDrawable(new ColorDrawable(-16777216));
        }
        if (this.f95807i0 == null) {
            Stack<CertifiedAccountMeta$StFeed> stack = new Stack<>();
            this.f95807i0 = stack;
            CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = this.N;
            if (certifiedAccountMeta$StFeed != null) {
                stack.push(certifiedAccountMeta$StFeed);
            }
        }
        SubscribeFollowInfoView subscribeFollowInfoView = (SubscribeFollowInfoView) this.A0.findViewById(R.id.lq9);
        this.f95818t0 = subscribeFollowInfoView;
        subscribeFollowInfoView.setHostActivity(y());
        this.f95818t0.setExtraTypeInfo(D());
        this.f95814p0 = (ImageView) this.A0.findViewById(R.id.ln8);
        this.f95815q0 = (RelativeLayout) this.A0.findViewById(R.id.loe);
        this.f95816r0 = (ImageView) this.A0.findViewById(R.id.loj);
        this.f95817s0 = (ImageView) this.A0.findViewById(R.id.lnl);
        if (y() != null) {
            LiuHaiUtils.initLiuHaiProperty(y());
            LiuHaiUtils.enableNotch(y());
        }
        if (!this.f95819u0) {
            this.f95817s0.setVisibility(8);
        }
        z1(this.A0);
        G1();
        y1();
    }

    @Override // bf0.b
    public void b() {
        VideoPlayerView videoPlayerView = this.f95804f0;
        if (videoPlayerView != null) {
            videoPlayerView.setAlpha(1.0f);
        }
    }

    @Override // bf0.b
    public void e() {
        VideoPlayerView videoPlayerView = this.f95804f0;
        if (videoPlayerView != null) {
            videoPlayerView.setAlpha(1.0f);
        }
    }

    @Override // bf0.b
    public void h() {
        VideoPlayerView videoPlayerView = this.f95804f0;
        if (videoPlayerView != null) {
            videoPlayerView.setAlpha(0.0f);
        }
    }

    @Override // we0.a
    protected BaseWidgetView i0(ViewGroup viewGroup, MultiViewBlock multiViewBlock) {
        RelativeVideoHeadItemView relativeVideoHeadItemView = new RelativeVideoHeadItemView(y());
        this.f95808j0 = relativeVideoHeadItemView;
        return relativeVideoHeadItemView;
    }

    @Override // bf0.b
    public void m() {
        QLog.d(DetailBaseBlock.f95725c0, 1, "onTransAnimateInit disableLoading!");
        N0();
        VideoPlayerView videoPlayerView = this.f95804f0;
        if (videoPlayerView != null) {
            videoPlayerView.setAlpha(0.0f);
        }
    }

    @Override // we0.a, android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        super.onBindViewHolder(viewHolder, i3);
        RelativeVideoHeadItemView relativeVideoHeadItemView = this.f95808j0;
        if (relativeVideoHeadItemView != null) {
            relativeVideoHeadItemView.setData(this.N);
        }
        SubscribeFollowInfoView subscribeFollowInfoView = this.f95818t0;
        if (subscribeFollowInfoView != null) {
            subscribeFollowInfoView.u(this.N);
        }
        EventCollector.getInstance().onRecyclerBindViewHolder(viewHolder, i3, getItemId(i3));
    }

    @Override // com.tencent.biz.subscribe.bizdapters.DetailBaseBlock, com.tencent.biz.subscribe.part.block.MultiViewBlock, com.tencent.biz.subscribe.part.block.base.a, android.support.v7.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        Stack<CertifiedAccountMeta$StFeed> stack = this.f95807i0;
        if (stack != null) {
            stack.clear();
        }
        VideoPlayerView videoPlayerView = this.f95804f0;
        if (videoPlayerView != null) {
            videoPlayerView.T();
        }
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock, com.tencent.biz.subscribe.part.block.a.e
    public void r2(String str, a.d dVar) {
        VideoPlayerView videoPlayerView;
        if ("share_key_continue_feeds".equals(str) && dVar != null && (videoPlayerView = this.f95804f0) != null) {
            videoPlayerView.setContinueFeeds((List) dVar.f96169a);
        }
    }

    public boolean t1() {
        if (this.f95804f0 == null) {
            return true;
        }
        return !r0.B1();
    }

    public View u1() {
        return this.f95818t0;
    }

    public com.tencent.biz.subscribe.bizdapters.c w1() {
        return (com.tencent.biz.subscribe.bizdapters.c) A().Z("RELATIVE_ADAPTER_UNIQUE_KEY");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class e implements RecyclerView.OnItemTouchListener {
        e() {
        }

        @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            return f.this.A1(motionEvent);
        }

        @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            if (f.this.f95820v0 != null) {
                f.this.f95820v0.onTouchEvent(motionEvent);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z16) {
        }
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
    public void U(com.tencent.biz.subscribe.part.block.base.b bVar) {
    }
}
