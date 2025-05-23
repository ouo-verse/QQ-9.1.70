package com.tencent.biz.subscribe.bizdapters;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StShare;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$StGetFeedDetailRsp;
import android.content.DialogInterface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.animation.PopViewAnimationDrawableHelper;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.bizdapters.AnimationDrawableFactory;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.biz.subscribe.comment.CommentPresenter;
import com.tencent.biz.subscribe.comment.n;
import com.tencent.biz.subscribe.fragments.SubscribeBaseFragment;
import com.tencent.biz.subscribe.part.block.a;
import com.tencent.biz.subscribe.utils.TimeAndCountHelper;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.biz.subscribe.widget.SubscribeShareHelper;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.File;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class DetailBaseBlock extends we0.a implements CommentPresenter.g, n {

    /* renamed from: c0, reason: collision with root package name */
    protected static final String f95725c0 = "DetailBaseBlock";

    /* renamed from: d0, reason: collision with root package name */
    private static long f95726d0;
    protected CommentBottomBar L;
    private StatusView M;
    protected CertifiedAccountMeta$StFeed N;
    protected ExtraTypeInfo P;
    private CertifiedAccountMeta$StShare Q;
    private String R;
    private CertifiedAccountMeta$StShare S;
    protected com.tencent.biz.subscribe.utils.c T;
    protected PopupWindow U;
    private SystemBarCompact V;
    private PopViewAnimationDrawableHelper W;
    private boolean X;
    private boolean Y;
    private boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    private View f95727a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f95728b0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.subscribe.bizdapters.DetailBaseBlock$3, reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass3 implements AnimationDrawableFactory.a {
        AnonymousClass3() {
        }

        @Override // com.tencent.biz.subscribe.bizdapters.AnimationDrawableFactory.a
        public void a(boolean z16, Drawable drawable) {
            if (z16 && (drawable instanceof AnimationDrawable)) {
                final AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
                if (DetailBaseBlock.this.y() != null) {
                    DetailBaseBlock.this.y().runOnUiThread(new Runnable() { // from class: com.tencent.biz.subscribe.bizdapters.DetailBaseBlock.3.1

                        /* compiled from: P */
                        /* renamed from: com.tencent.biz.subscribe.bizdapters.DetailBaseBlock$3$1$a */
                        /* loaded from: classes5.dex */
                        class a implements PopViewAnimationDrawableHelper.c {
                            a() {
                            }

                            @Override // com.tencent.biz.subscribe.animation.PopViewAnimationDrawableHelper.c
                            public void onEnd() {
                                QLog.d(DetailBaseBlock.f95725c0, 2, "dismiss popupWindow followTipView");
                                PopupWindow popupWindow = DetailBaseBlock.this.U;
                                if (popupWindow != null) {
                                    popupWindow.dismiss();
                                }
                            }

                            @Override // com.tencent.biz.subscribe.animation.PopViewAnimationDrawableHelper.c
                            public void onStart() {
                                QLog.d(DetailBaseBlock.f95725c0, 2, "showFollowTipView");
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            CommentBottomBar commentBottomBar;
                            int i3;
                            try {
                                View inflate = LayoutInflater.from(DetailBaseBlock.this.y()).inflate(R.layout.aom, (ViewGroup) null, false);
                                inflate.measure(0, 0);
                                inflate.getMeasuredWidth();
                                int measuredHeight = inflate.getMeasuredHeight();
                                ImageView imageView = (ImageView) inflate.findViewById(R.id.g09);
                                DetailBaseBlock.this.W = new PopViewAnimationDrawableHelper(animationDrawable);
                                DetailBaseBlock.this.W.k(new a());
                                animationDrawable.setOneShot(true);
                                imageView.setImageDrawable(animationDrawable);
                                DetailBaseBlock.this.U = new PopupWindow(inflate, -2, -2);
                                DetailBaseBlock.this.U.setOutsideTouchable(true);
                                DetailBaseBlock.this.U.setTouchable(true);
                                int[] iArr = new int[2];
                                if (DetailBaseBlock.this.f95727a0 != null && (commentBottomBar = DetailBaseBlock.this.L) != null) {
                                    if (!commentBottomBar.r() && !DetailBaseBlock.this.L.p()) {
                                        DetailBaseBlock.this.f95727a0.getLocationOnScreen(iArr);
                                        animationDrawable.setOneShot(true);
                                        if (DetailBaseBlock.this.f95728b0) {
                                            i3 = (iArr[1] - measuredHeight) + UIUtils.b(DetailBaseBlock.this.y(), 100.0f);
                                        } else {
                                            i3 = iArr[1];
                                        }
                                        DetailBaseBlock detailBaseBlock = DetailBaseBlock.this;
                                        detailBaseBlock.U.showAtLocation(detailBaseBlock.f95727a0, 53, 0, i3);
                                        DetailBaseBlock.this.W.l();
                                        DetailBaseBlock.this.Z = false;
                                        TimeAndCountHelper.d().f(DetailBaseBlock.this.y(), "subscribe_sp_key_show_follow_guide", 1);
                                        TimeAndCountHelper.d().f(DetailBaseBlock.this.y(), "subscribe_freshman_interaction_guide", 1);
                                        AnimationDrawableFactory.f().c(com.tencent.biz.subscribe.b.f95700h.get("follow_guide_pics"));
                                        return;
                                    }
                                    DetailBaseBlock.this.Z = true;
                                    QLog.i(DetailBaseBlock.f95725c0, 1, "isShowCommentList or isAddCommentMode");
                                }
                            } catch (Exception e16) {
                                e16.printStackTrace();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            QLog.d(DetailBaseBlock.f95725c0, 2, "showFollowTipView error, create animationDrawable error");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.subscribe.bizdapters.DetailBaseBlock$4, reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass4 implements AnimationDrawableFactory.a {
        AnonymousClass4() {
        }

        @Override // com.tencent.biz.subscribe.bizdapters.AnimationDrawableFactory.a
        public void a(boolean z16, Drawable drawable) {
            if (z16 && (drawable instanceof AnimationDrawable)) {
                final AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
                if (DetailBaseBlock.this.y() != null) {
                    DetailBaseBlock.this.y().runOnUiThread(new Runnable() { // from class: com.tencent.biz.subscribe.bizdapters.DetailBaseBlock.4.1

                        /* compiled from: P */
                        /* renamed from: com.tencent.biz.subscribe.bizdapters.DetailBaseBlock$4$1$a */
                        /* loaded from: classes5.dex */
                        class a implements PopViewAnimationDrawableHelper.c {
                            a() {
                            }

                            @Override // com.tencent.biz.subscribe.animation.PopViewAnimationDrawableHelper.c
                            public void onEnd() {
                                QLog.d(DetailBaseBlock.f95725c0, 2, "dismiss popupWindow priseTipView");
                                PopupWindow popupWindow = DetailBaseBlock.this.U;
                                if (popupWindow != null) {
                                    popupWindow.dismiss();
                                }
                            }

                            @Override // com.tencent.biz.subscribe.animation.PopViewAnimationDrawableHelper.c
                            public void onStart() {
                                QLog.d(DetailBaseBlock.f95725c0, 2, "showPraiseTipView");
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                View inflate = LayoutInflater.from(DetailBaseBlock.this.y()).inflate(R.layout.aoo, (ViewGroup) null, false);
                                inflate.measure(0, 0);
                                inflate.getMeasuredWidth();
                                int measuredHeight = inflate.getMeasuredHeight();
                                ImageView imageView = (ImageView) inflate.findViewById(R.id.g0f);
                                DetailBaseBlock.this.W = new PopViewAnimationDrawableHelper(animationDrawable);
                                DetailBaseBlock.this.W.k(new a());
                                animationDrawable.setOneShot(true);
                                imageView.setImageDrawable(animationDrawable);
                                DetailBaseBlock.this.U = new PopupWindow(inflate, -2, -2);
                                DetailBaseBlock.this.U.setOutsideTouchable(true);
                                DetailBaseBlock.this.U.setTouchable(true);
                                CommentBottomBar commentBottomBar = DetailBaseBlock.this.L;
                                if (commentBottomBar != null) {
                                    if (commentBottomBar.q()) {
                                        QLog.i(DetailBaseBlock.f95725c0, 1, "mCommentBottomBar.isPraised");
                                        return;
                                    }
                                    if (!DetailBaseBlock.this.L.r() && !DetailBaseBlock.this.L.p()) {
                                        int l3 = UIUtils.l(DetailBaseBlock.this.y());
                                        DetailBaseBlock detailBaseBlock = DetailBaseBlock.this;
                                        detailBaseBlock.U.showAtLocation(detailBaseBlock.L, 53, -UIUtils.b(detailBaseBlock.y(), 32.0f), ((l3 - measuredHeight) - DetailBaseBlock.this.L.getMeasuredHeight()) + x.c(DetailBaseBlock.this.y(), 10.0f));
                                        DetailBaseBlock.this.W.l();
                                        DetailBaseBlock.this.Y = false;
                                        TimeAndCountHelper.d().f(DetailBaseBlock.this.y(), "subscribe_sp_key_show_praise_guide", 1);
                                        AnimationDrawableFactory.f().c(com.tencent.biz.subscribe.b.f95700h.get("praise_guide_pics"));
                                        return;
                                    }
                                    DetailBaseBlock.this.Y = true;
                                    QLog.i(DetailBaseBlock.f95725c0, 1, "isShowCommentList or isAddCommentMode");
                                }
                            } catch (Exception e16) {
                                e16.printStackTrace();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            QLog.d(DetailBaseBlock.f95725c0, 2, "showFollowTipView error, create animationDrawable error");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (DetailBaseBlock.this.J() instanceof SubscribeBaseFragment) {
                ((SubscribeBaseFragment) DetailBaseBlock.this.J()).Eh(DetailBaseBlock.this.R0(2));
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements CommentPresenter.h {
        b() {
        }

        @Override // com.tencent.biz.subscribe.comment.CommentPresenter.h
        public void a(CertifiedAccountRead$StGetFeedDetailRsp certifiedAccountRead$StGetFeedDetailRsp, boolean z16, long j3, String str) {
            Object valueOf;
            if (certifiedAccountRead$StGetFeedDetailRsp == null) {
                QLog.e(DetailBaseBlock.f95725c0, 1, "onFeedResponse rsp is null");
                return;
            }
            CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = certifiedAccountRead$StGetFeedDetailRsp.feed.get();
            String str2 = DetailBaseBlock.f95725c0;
            QLog.d(str2, 1, "onFeedResponse hideLoadingView!");
            DetailBaseBlock.this.U0();
            boolean W0 = DetailBaseBlock.this.W0(j3, certifiedAccountMeta$StFeed);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("isInterceptRspByFeedStatus ");
            sb5.append(W0);
            sb5.append(",status ");
            if (certifiedAccountMeta$StFeed == null) {
                valueOf = "none";
            } else {
                valueOf = Integer.valueOf(certifiedAccountMeta$StFeed.status.get());
            }
            sb5.append(valueOf);
            QLog.i(str2, 2, sb5.toString());
            if (W0) {
                DetailBaseBlock.this.Y0(j3, str);
                return;
            }
            DetailBaseBlock.this.X0(certifiedAccountMeta$StFeed);
            DetailBaseBlock.this.Q = certifiedAccountRead$StGetFeedDetailRsp.share;
            DetailBaseBlock.this.R = certifiedAccountRead$StGetFeedDetailRsp.detailUrl.get();
            DetailBaseBlock.this.S = certifiedAccountRead$StGetFeedDetailRsp.share;
            DetailBaseBlock.this.f1(certifiedAccountMeta$StFeed);
            QLog.i(str2, 1, "isFinish:" + certifiedAccountRead$StGetFeedDetailRsp.isFinish.get() + " | recommend feeds size:" + certifiedAccountRead$StGetFeedDetailRsp.vecRcmdFeed.get().size());
            DetailBaseBlock.this.T0(certifiedAccountRead$StGetFeedDetailRsp, z16);
            if (!z16) {
                VSReporter.n(DetailBaseBlock.this.N.poster.f24929id.get(), "auth_" + SubscribeShareHelper.s(DetailBaseBlock.this.D()), "exp", 0, 0, "", "", certifiedAccountMeta$StFeed.f24925id.get(), certifiedAccountMeta$StFeed.title.get());
            }
            DetailBaseBlock.this.W(true);
        }

        @Override // com.tencent.biz.subscribe.comment.CommentPresenter.h
        public void b(int i3) {
            CommentBottomBar commentBottomBar = DetailBaseBlock.this.L;
            if (commentBottomBar != null) {
                commentBottomBar.E(i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c implements TimeAndCountHelper.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CertifiedAccountMeta$StFeed f95741a;

        c(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
            this.f95741a = certifiedAccountMeta$StFeed;
        }

        @Override // com.tencent.biz.subscribe.utils.TimeAndCountHelper.a
        public void a(int i3) {
            QLog.d(DetailBaseBlock.f95725c0, 2, "count:" + i3);
            if (DetailBaseBlock.this.y() != null && i3 == 1) {
                if (TimeAndCountHelper.d().c(DetailBaseBlock.this.y(), "subscribe_sp_key_show_praise_guide") == 0) {
                    CommentBottomBar commentBottomBar = DetailBaseBlock.this.L;
                    if (commentBottomBar != null && !commentBottomBar.q()) {
                        DetailBaseBlock.this.e1();
                        return;
                    }
                    return;
                }
                if (TimeAndCountHelper.d().c(DetailBaseBlock.this.y(), "subscribe_sp_key_show_follow_guide") == 0 && !SubscribeUtils.l(this.f95741a)) {
                    DetailBaseBlock.this.d1();
                }
            }
        }
    }

    public DetailBaseBlock(Bundle bundle) {
        super(bundle);
        this.X = false;
        this.Y = false;
        this.Z = false;
    }

    private String Q0(ExtraTypeInfo extraTypeInfo) {
        if (extraTypeInfo != null) {
            int i3 = extraTypeInfo.pageType;
            if (i3 != 7000) {
                if (i3 == 7002) {
                    return "certified_account_personal_preload_loading";
                }
                return "certified_account_preload_pic";
            }
            return "certified_account_preload_video";
        }
        return "certified_account_preload_pic";
    }

    private void V0() {
        this.L = new CommentBottomBar(J().getBaseActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ImmersiveUtils.dpToPx(50.0f));
        layoutParams.gravity = 80;
        this.L.setLayoutParams(layoutParams);
        a1();
        if (J() instanceof SubscribeBaseFragment) {
            this.L.setShareClickListener(new a());
        }
        ViewStub viewStub = new ViewStub(J().getBaseActivity());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 80;
        layoutParams2.setMargins(0, -ImmersiveUtils.dpToPx(50.0f), 0, 0);
        viewStub.setLayoutParams(layoutParams2);
        viewStub.setFitsSystemWindows(true);
        if (this.L.k() != null) {
            this.L.k().q1(viewStub);
        }
        L0(viewStub);
        L0(this.L);
        K().setPadding(0, 0, 0, ImmersiveUtils.dpToPx(50.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean W0(long j3, CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        if (j3 != 0 || certifiedAccountMeta$StFeed == null || this.G) {
            return true;
        }
        if (SubscribeUtils.r(certifiedAccountMeta$StFeed.status.get())) {
            return false;
        }
        return !SubscribeUtils.o(certifiedAccountMeta$StFeed.poster.attr.get());
    }

    public static boolean isFastClick() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f95726d0 <= 200) {
            if (QLog.isColorLevel()) {
                QLog.d(f95725c0, 2, "click too fast");
            }
            f95726d0 = currentTimeMillis;
            return true;
        }
        f95726d0 = currentTimeMillis;
        return false;
    }

    protected void L0(View view) {
        x(view);
    }

    public void M0(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        QLog.d(f95725c0, 2, "is not own startCount");
        if (!SubscribeUtils.o(certifiedAccountMeta$StFeed.poster.attr.get()) && y() != null) {
            TimeAndCountHelper.d().g(y(), "subscribe_freshman_interaction_guide", 5000, new c(certifiedAccountMeta$StFeed));
            y().runOnUiThread(new Runnable() { // from class: com.tencent.biz.subscribe.bizdapters.DetailBaseBlock.6
                @Override // java.lang.Runnable
                public void run() {
                    CommentBottomBar commentBottomBar = DetailBaseBlock.this.L;
                    if (commentBottomBar != null) {
                        commentBottomBar.w();
                    }
                }
            });
            TimeAndCountHelper.d().g(y(), "subscribe_freshman_share_guide", 10000, new TimeAndCountHelper.a() { // from class: com.tencent.biz.subscribe.bizdapters.DetailBaseBlock.7
                @Override // com.tencent.biz.subscribe.utils.TimeAndCountHelper.a
                public void a(int i3) {
                    if (DetailBaseBlock.this.y() != null) {
                        DetailBaseBlock.this.y().runOnUiThread(new Runnable() { // from class: com.tencent.biz.subscribe.bizdapters.DetailBaseBlock.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                CommentBottomBar commentBottomBar = DetailBaseBlock.this.L;
                                if (commentBottomBar != null) {
                                    commentBottomBar.A();
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void N0() {
        this.X = true;
    }

    public CertifiedAccountMeta$StFeed O0() {
        return this.N;
    }

    public com.tencent.biz.subscribe.utils.c P0() {
        return this.T;
    }

    public ve0.b R0(int i3) {
        ve0.b bVar = new ve0.b();
        bVar.f441502b = this.N;
        bVar.f441503c = this.R;
        bVar.f441504d = this.S;
        boolean z16 = true;
        if (i3 != 1) {
            z16 = false;
        }
        bVar.f441506f = z16;
        bVar.f441501a = i3;
        return bVar;
    }

    protected View S0() {
        return null;
    }

    protected void U0() {
        StatusView statusView = this.M;
        if (statusView != null) {
            statusView.u();
        }
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
    public boolean X() {
        CommentBottomBar commentBottomBar = this.L;
        if (commentBottomBar != null && commentBottomBar.s()) {
            return true;
        }
        return super.X();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void X0(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        int i3;
        StatusView statusView = this.M;
        if (statusView != null) {
            statusView.t();
        }
        if (S0() != null && S0().getVisibility() == 0) {
            S0().setVisibility(8);
        }
        if (S0() != null && this.N != null) {
            View S0 = S0();
            if (certifiedAccountMeta$StFeed.status.get() == 3) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            S0.setVisibility(i3);
        }
        CommentBottomBar commentBottomBar = this.L;
        if (commentBottomBar != null && commentBottomBar.getVisibility() == 8) {
            this.L.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Y0(long j3, String str) {
        if (S0() != null && S0().getVisibility() == 0) {
            S0().setVisibility(8);
        }
        if (this.M != null) {
            if ((str != null && str.trim().length() == 0) || VSNetworkHelper.isProtocolCache(str)) {
                str = null;
            }
            this.M.x(str);
        }
        CommentBottomBar commentBottomBar = this.L;
        if (commentBottomBar != null) {
            commentBottomBar.setVisibility(8);
        }
    }

    public void Z0() {
        PopViewAnimationDrawableHelper popViewAnimationDrawableHelper = this.W;
        if (popViewAnimationDrawableHelper != null) {
            popViewAnimationDrawableHelper.j();
        }
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
    public void a0(Bundle bundle) {
        if (bundle != null) {
            CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = new CertifiedAccountMeta$StFeed();
            this.N = certifiedAccountMeta$StFeed;
            try {
                this.N = certifiedAccountMeta$StFeed.mergeFrom(bundle.getByteArray("bundle_key_subscribe_feed_bytes_array"));
                this.P = (ExtraTypeInfo) bundle.getSerializable("bundle_key_feed_extra_type_info");
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            f0("share_key_subscribe_feeds_update", new a.d(this.N));
        }
        if (!this.X) {
            this.M = z().h();
            this.M.B(SubscribeUtils.j() + File.separator + Q0(D()) + ".png");
            QLog.d(f95725c0, 1, "showLoadingView!");
        }
        V0();
        this.T = new com.tencent.biz.subscribe.utils.c(y());
    }

    protected void a1() {
        CommentBottomBar commentBottomBar = this.L;
        if (commentBottomBar == null) {
            return;
        }
        commentBottomBar.m(J().getBaseActivity(), this.N, new b(), this.P);
        if (this.L.k() != null) {
            this.L.k().r1(this);
            this.L.k().o1(this);
        }
    }

    public void b1(View view, boolean z16) {
        this.f95727a0 = view;
        this.f95728b0 = z16;
    }

    public void c1(SystemBarCompact systemBarCompact) {
        this.V = systemBarCompact;
    }

    @Override // com.tencent.biz.subscribe.comment.n
    public void d() {
        if (this.Y) {
            e1();
        }
        if (this.Z) {
            d1();
        }
    }

    public void d1() {
        AnimationDrawableFactory.f().d(com.tencent.biz.subscribe.b.f95700h.get("follow_guide_pics"), 4000, new AnonymousClass3(), true);
    }

    public void e1() {
        AnimationDrawableFactory.f().d(com.tencent.biz.subscribe.b.f95700h.get("praise_guide_pics"), 4000, new AnonymousClass4(), true);
    }

    public void f1(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        this.N = certifiedAccountMeta$StFeed;
        CommentBottomBar commentBottomBar = this.L;
        if (commentBottomBar != null) {
            commentBottomBar.setCurrentFeed(certifiedAccountMeta$StFeed);
        }
        f0("share_key_subscribe_feeds_update", new a.d(certifiedAccountMeta$StFeed));
        if (J() instanceof SubscribeBaseFragment) {
            ((SubscribeBaseFragment) J()).Fh(certifiedAccountMeta$StFeed);
        }
        com.tencent.biz.subscribe.utils.c cVar = this.T;
        if (cVar != null) {
            cVar.c(certifiedAccountMeta$StFeed.poster);
        }
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock, com.tencent.biz.subscribe.part.block.base.a, android.support.v7.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        CommentBottomBar commentBottomBar = this.L;
        if (commentBottomBar != null) {
            commentBottomBar.u();
        }
    }

    @Override // com.tencent.biz.subscribe.comment.CommentPresenter.g
    public void onDismiss() {
        if (this.Y) {
            e1();
        }
        if (this.Z) {
            d1();
        }
    }

    @Override // com.tencent.biz.subscribe.comment.CommentPresenter.g
    public void onShow() {
    }

    @Override // com.tencent.biz.subscribe.comment.n
    public void f(DialogInterface dialogInterface) {
    }

    protected void T0(CertifiedAccountRead$StGetFeedDetailRsp certifiedAccountRead$StGetFeedDetailRsp, boolean z16) {
    }
}
