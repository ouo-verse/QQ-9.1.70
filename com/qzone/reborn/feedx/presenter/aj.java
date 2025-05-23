package com.qzone.reborn.feedx.presenter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.common.account.LoginData;
import com.qzone.feed.utils.QZoneFeedUtil;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedSignature;
import com.qzone.proxy.feedcomponent.model.CellPermissionInfo;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.UserMedal;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.text.TextCellLayout;
import com.qzone.reborn.feedx.event.QZoneFeedxDetailAnimEvent;
import com.qzone.reborn.feedx.presenter.aj;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.qzone.reborn.feedx.widget.QZoneNickNameView;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.qzone.reborn.feedx.widget.countdown.QZoneTimeCountDownView;
import com.qzone.widget.QzoneZipAnimateUtil;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qzone.picload.c;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vip.api.IVipIconUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.zipanimate.AnimationDrawableLoadedListener;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes37.dex */
public class aj extends vg.a implements View.OnClickListener, SimpleEventReceiver<QZoneFeedxDetailAnimEvent> {
    private QZoneUserAvatarView F;
    private ImageView G;
    private QZoneNickNameView H;
    protected TextView I;
    protected ImageView J;
    protected View K;
    private ImageView L;
    private com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k N;
    private ImageView P;
    private LinearLayout Q;
    private QZoneRichTextView R;
    private QZoneTimeCountDownView S;
    private ViewGroup T;
    private TextView U;
    private AnimationDrawable V;
    private ImageView W;
    private ImageView X;
    private gf.h Y;
    private boolean M = VasNormalToggle.VAS_QZONE_SIGNATURE_CHANGE_CACHE_DRAWABLE.isEnable(true);
    private final Runnable Z = new Runnable() { // from class: com.qzone.reborn.feedx.presenter.af
        @Override // java.lang.Runnable
        public final void run() {
            aj.this.v0();
        }
    };

    /* renamed from: a0, reason: collision with root package name */
    private final Runnable f55527a0 = new Runnable() { // from class: com.qzone.reborn.feedx.presenter.ag
        @Override // java.lang.Runnable
        public final void run() {
            aj.this.s0();
        }
    };

    /* renamed from: b0, reason: collision with root package name */
    private final AnimationDrawableLoadedListener f55528b0 = new e();

    /* renamed from: c0, reason: collision with root package name */
    private final Drawable.Callback f55529c0 = new f();

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements QZoneUserAvatarView.a {
        a() {
        }

        @Override // com.qzone.reborn.feedx.widget.QZoneUserAvatarView.a
        public void a(View view) {
            com.qzone.util.ap.f59791b.e(17, 1, ((vg.a) aj.this).f441567m, ((vg.a) aj.this).f441565h);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class d implements TextCellLayout.OnCellClickListener {
        d() {
        }

        @Override // com.qzone.proxy.feedcomponent.text.TextCellLayout.OnCellClickListener
        public void onClick(TextCell textCell, View view) {
            if (TextUtils.isEmpty(textCell.getUrl())) {
                return;
            }
            yo.d.d(textCell.getUrl(), aj.this.R.getContext(), null);
        }

        @Override // com.qzone.proxy.feedcomponent.text.TextCellLayout.OnCellClickListener
        public boolean onLongClick(View view, CellTextView.OnTextOperater onTextOperater) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class e extends AnimationDrawableLoadedListener {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            aj.this.t0();
        }

        @Override // cooperation.qzone.zipanimate.AnimationDrawableLoadedListener
        public void onLoadedSuccess(AnimationDrawable animationDrawable) {
            aj.this.V = animationDrawable;
            aj.this.L.post(new Runnable() { // from class: com.qzone.reborn.feedx.presenter.ak
                @Override // java.lang.Runnable
                public final void run() {
                    aj.e.this.b();
                }
            });
            super.onLoadedSuccess(animationDrawable);
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class f implements Drawable.Callback {
        f() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            if (aj.this.L != null) {
                aj.this.L.invalidate();
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
            if (aj.this.L != null) {
                aj.this.L.scheduleDrawable(drawable, runnable, j3);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            if (aj.this.L != null) {
                aj.this.L.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    private boolean U(BusinessFeedData businessFeedData) {
        return (businessFeedData.getUser() == null || TextUtils.isEmpty(businessFeedData.getUser().qzoneDesc)) ? false : true;
    }

    private boolean V(BusinessFeedData businessFeedData) {
        return o0(businessFeedData.getPermissionInfoV2());
    }

    private void X() {
        final String a16 = ef.b.a(this.f441565h);
        RFWIocAbilityProvider.g().getIoc(gf.e.class).originView(this.f441563e).done(new OnPromiseResolved() { // from class: com.qzone.reborn.feedx.presenter.ah
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                aj.this.p0(a16, (gf.e) obj);
            }
        }).run();
        Y();
    }

    private void Y() {
        if (this.W == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("feed_channellist_alert", Integer.valueOf((!TextUtils.isEmpty(com.qzone.reborn.feedx.util.n.d(this.f441565h)) || com.qzone.reborn.configx.g.f53821a.h().k()) ? 1 : 0));
        fo.c.o(this.W, "em_qz_on_the_feed_entrance", new fo.b().i(ef.b.a(this.f441565h)).l(hashMap));
    }

    private void Z(String str) {
        if (this.f441565h == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(fh.b.INSTANCE.a(this.f441565h));
        hashMap.put("permission_type", str);
        fo.c.o(this.K, "em_qz_feed_permission_modification_entry", new fo.b().l(hashMap).k(ExposurePolicy.REPORT_ALL).g(ClickPolicy.REPORT_ALL).j(EndExposurePolicy.REPORT_NONE));
    }

    private gf.h a0() {
        if (this.Y == null) {
            this.Y = (gf.h) j(gf.h.class);
        }
        return this.Y;
    }

    private void b0() {
        a0().h2(this.f441565h, this.f441567m, null);
    }

    private void c0(QZoneFeedxDetailAnimEvent qZoneFeedxDetailAnimEvent) {
        if (qZoneFeedxDetailAnimEvent.getIsAnimPlaying()) {
            this.H.setEnableFlash(false);
        } else {
            this.H.setEnableFlash(true);
        }
    }

    private void d0() {
        BusinessFeedData businessFeedData;
        Activity activity = this.C;
        if (activity == null || (businessFeedData = this.f441565h) == null) {
            return;
        }
        ho.h.b(activity, businessFeedData.getUser().uin);
        com.qzone.util.ap.f59791b.e(17, 1, this.f441567m, this.f441565h);
    }

    private void f0(User user) {
        UserMedal userMedal;
        if (user.isCanShowFamousIcon() && (userMedal = user.famousSpaceMedal) != null && !TextUtils.isEmpty(userMedal.picUrl)) {
            this.G.setVisibility(0);
            com.tencent.mobileqq.qzone.picload.c.a().h(Option.obtain().setUrl(user.famousSpaceMedal.picUrl).setTargetView(this.G).setNeedShowLoadingDrawable(false).setFailDrawable(com.qzone.adapter.feedcomponent.i.H().a0()));
        } else {
            this.G.setVisibility(8);
        }
    }

    private void g0(User user) {
        QZoneUserAvatarView qZoneUserAvatarView = this.F;
        if (qZoneUserAvatarView == null) {
            return;
        }
        qZoneUserAvatarView.setVisibility(0);
        this.F.setUser(user);
        AccessibilityUtil.s(this.F, user.nickName + com.qzone.util.l.a(R.string.gqz));
    }

    private void i0(BusinessFeedData businessFeedData) {
        if (this.H.getPaint() != null) {
            this.H.getPaint().setShader(null);
        }
        this.H.setData(businessFeedData, this.H.getResources().getColor(R.color.qui_common_text_primary));
    }

    private void j0(BusinessFeedData businessFeedData) {
        CellPermissionInfo permissionInfoV2 = businessFeedData.getPermissionInfoV2();
        this.K.setVisibility(0);
        ViewGroup.MarginLayoutParams marginLayoutParams = null;
        boolean b16 = com.qzone.reborn.a.f52169a.b("exp_qzone_feed_permission_entry", null);
        if (!TextUtils.isEmpty(permissionInfoV2.permission_info)) {
            int f06 = com.qzone.adapter.feedcomponent.i.H().f0(permissionInfoV2.permission_visit);
            if (f06 != 0) {
                Drawable drawable = FeedGlobalEnv.getContext().getResources().getDrawable(f06);
                this.J.setVisibility(0);
                this.J.setImageDrawable(drawable);
                com.tencent.mobileqq.qzone.picload.c a16 = com.tencent.mobileqq.qzone.picload.c.a();
                ImageView imageView = this.J;
                a16.m(imageView, imageView.getContext().getResources().getColor(R.color.qui_common_icon_secondary));
            } else {
                this.J.setVisibility(8);
            }
            this.I.setText(permissionInfoV2.permission_info);
            ViewGroup viewGroup = this.T;
            if (viewGroup != null && (viewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) this.T.getLayoutParams();
            }
            if (b16 && !TextUtils.isEmpty(permissionInfoV2.permission_jumpurl)) {
                Z(permissionInfoV2.permission_info);
                this.K.setBackgroundResource(R.drawable.f15233u);
                boolean j3 = ef.b.j(this.f441565h);
                int dpToPx = ViewUtils.dpToPx(j3 ? 1.5f : 2.0f);
                this.K.setPadding(ViewUtils.dpToPx(6.0f), dpToPx, ViewUtils.dpToPx(6.0f), dpToPx);
                if (marginLayoutParams != null) {
                    marginLayoutParams.topMargin = ViewUtils.dpToPx(j3 ? 7.0f : 5.0f);
                    return;
                }
                return;
            }
            this.K.setBackgroundResource(0);
            this.K.setPadding(0, 0, 0, 0);
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = ViewUtils.dpToPx(5.0f);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(permissionInfoV2.status_info)) {
            return;
        }
        this.I.setText(permissionInfoV2.status_info);
    }

    private void k0(BusinessFeedData businessFeedData) {
        this.K.setVisibility(8);
        this.L.setVisibility(8);
        this.R.setVisibility(8);
        this.P.setVisibility(8);
        if (V(businessFeedData)) {
            j0(businessFeedData);
        } else if (W(businessFeedData)) {
            m0(businessFeedData);
        } else if (U(businessFeedData)) {
            l0(businessFeedData);
        }
    }

    private void n0() {
        this.S.setVisibility(8);
        this.U.setVisibility(8);
        if (r0()) {
            if (this.f441565h.isDeleteOnTimeFeed() && LoginData.getInstance().getUin() == this.f441565h.getUser().uin) {
                this.Q.setPadding(0, ViewUtils.dpToPx(1.0f), 0, 0);
                this.S.setVisibility(0);
                this.U.setVisibility(8);
                this.S.setData(this.f441565h);
                return;
            }
            this.Q.setPadding(0, 0, 0, 0);
            this.S.setVisibility(8);
            String g16 = com.qzone.reborn.feedx.util.n.g(this.f441565h);
            if (!TextUtils.isEmpty(g16)) {
                this.U.setVisibility(0);
                this.U.setText(g16);
                this.U.setContentDescription(g16);
                return;
            }
            this.U.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(String str, gf.e eVar) {
        eVar.k5(this.F, "em_qz_avatar", str, this.f441565h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(BusinessFeedData businessFeedData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        yo.d.c(businessFeedData.cellFeedSignature.strJumpUrl, this.L.getContext());
        EventCollector.getInstance().onViewClicked(view);
    }

    private boolean r0() {
        return (this.f441565h.getFeedCommInfo().needAdvReport() || this.f441565h.getFeedCommInfo().isBizRecomFamousFeeds() || this.f441565h.getFeedCommInfo().isLikeRecommFamousFeed() || (this.f441565h.getFeedCommInfo().isBizRecomFeeds() && this.f441565h.getFeedCommInfo().recomtype != 7 && !this.f441565h.getFeedCommInfo().isPicUpLayout())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        if (this.W == null || this.X == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(getTAG(), 2, "[startAlienatedToNormalIconAnim] hashCode = " + hashCode());
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.X, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.W, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f));
        animatorSet.setDuration(200L);
        animatorSet.addListener(new c());
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0() {
        AnimationDrawable animationDrawable;
        try {
            ImageView imageView = this.L;
            if (imageView == null || (animationDrawable = this.V) == null) {
                return;
            }
            imageView.setImageDrawable(animationDrawable);
            this.V.setOneShot(false);
            this.V.setCallback(this.f55529c0);
            this.V.start();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void u0() {
        if (com.qzone.reborn.feedx.util.x.f55790a.c(o())) {
            return;
        }
        w0();
        if (TextUtils.isEmpty(com.qzone.reborn.feedx.util.n.d(this.f441565h)) || !com.qzone.reborn.configx.g.f53821a.h().k()) {
            return;
        }
        RFWThreadManager.getInstance().runOnUiThread(this.Z, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0() {
        if (this.W == null || this.X == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(getTAG(), 2, "[startNormalToAlienatedIconAnim] hashCode = " + hashCode());
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.W, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.X, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f));
        animatorSet.setDuration(200L);
        animatorSet.addListener(new b());
        animatorSet.start();
    }

    private void w0() {
        if (com.qzone.reborn.feedx.util.x.f55790a.c(o())) {
            return;
        }
        RFWThreadManager.getUIHandler().removeCallbacks(this.Z);
        RFWThreadManager.getUIHandler().removeCallbacks(this.f55527a0);
        ImageView imageView = this.W;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.W.setAlpha(1.0f);
        }
        ImageView imageView2 = this.X;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
            this.X.setAlpha(0.0f);
        }
    }

    @Override // vg.a
    protected void A(BusinessFeedData businessFeedData) {
        User user = this.f441565h.getUser();
        g0(user);
        f0(user);
        k0(businessFeedData);
        n0();
        i0(businessFeedData);
        X();
        if (com.qzone.reborn.feedx.util.x.f55790a.g(o())) {
            this.F.setIsShieldJumpToMainPage(true);
            this.H.setClickEnable(false);
        }
    }

    @Override // vg.a
    public void B() {
        super.B();
        w0();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<QZoneFeedxDetailAnimEvent>> getEventClass() {
        ArrayList<Class<QZoneFeedxDetailAnimEvent>> arrayList = new ArrayList<>();
        arrayList.add(QZoneFeedxDetailAnimEvent.class);
        return arrayList;
    }

    @Override // vg.a
    /* renamed from: k */
    protected String getTAG() {
        return "QZoneFeedHeadPresenter";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        switch (view.getId()) {
            case R.id.n87 /* 1745225238 */:
                d0();
                break;
            case R.id.nbo /* 1745225404 */:
            case R.id.nbp /* 1745225405 */:
                b0();
                break;
            case R.id.nbt /* 1745225409 */:
                e0(view);
                break;
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // vg.a, vg.c
    public void onDestroy() {
        super.onDestroy();
        QZoneTimeCountDownView qZoneTimeCountDownView = this.S;
        if (qZoneTimeCountDownView != null) {
            qZoneTimeCountDownView.h();
        }
        QZoneNickNameView qZoneNickNameView = this.H;
        if (qZoneNickNameView != null) {
            qZoneNickNameView.j();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QZoneFeedxDetailAnimEvent) {
            c0((QZoneFeedxDetailAnimEvent) simpleBaseEvent);
        }
    }

    @Override // vg.a
    protected int s() {
        return R.id.nog;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    @Override // vg.a
    public void z() {
        super.z();
        u0();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private boolean W(BusinessFeedData businessFeedData) {
        CellFeedSignature cellFeedSignature;
        return (businessFeedData == null || (cellFeedSignature = businessFeedData.cellFeedSignature) == null || TextUtils.isEmpty(cellFeedSignature.strUrl)) ? false : true;
    }

    private void e0(View view) {
        BusinessFeedData businessFeedData;
        if (view == null || (businessFeedData = this.f441565h) == null || businessFeedData.getFeedCommInfo() == null || TextUtils.isEmpty(this.f441565h.getFeedCommInfo().ugcRightKey) || this.f441565h.getPermissionInfoV2() == null) {
            return;
        }
        String str = this.f441565h.getFeedCommInfo().ugcRightKey;
        int g16 = com.qzone.feed.utils.h.g(this.f441565h.getPermissionInfoV2().permission_visit);
        int i3 = this.f441565h.getFeedCommInfo().appid;
        boolean b16 = com.qzone.reborn.a.f52169a.b("exp_qzone_feed_permission_entry", null);
        if (i3 != 4 && b16 && a0() != null) {
            a0().y5(this.f441565h);
        } else if (com.qzone.feed.utils.h.h(g16)) {
            QZoneFeedUtil.b0(view.getContext(), str, g16, i3);
        }
    }

    private boolean o0(CellPermissionInfo cellPermissionInfo) {
        return (cellPermissionInfo == null || (TextUtils.isEmpty(cellPermissionInfo.status_info) && TextUtils.isEmpty(cellPermissionInfo.permission_info))) ? false : true;
    }

    private void l0(BusinessFeedData businessFeedData) {
        cooperation.vip.c.b(140, 1);
        this.R.setVisibility(0);
        this.P.setVisibility(0);
        com.tencent.mobileqq.qzone.picload.c.a().j(this.P, new c.C8489c().h(this.f441565h.getUser().descToken).f("").e(R.color.qui_common_text_secondary));
        this.R.setRichText(this.f441565h.getUser().qzoneDesc);
        this.R.setContentDescription(this.f441565h.getUser().qzoneDesc);
        this.R.setOnCellClickListener(new d());
    }

    private void m0(final BusinessFeedData businessFeedData) {
        cooperation.vip.c.b(141, 1);
        this.L.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = this.L.getLayoutParams();
        layoutParams.width = ViewUtils.dpToPx(this.f441565h.cellFeedSignature.iWidth);
        layoutParams.height = ViewUtils.dpToPx(this.f441565h.cellFeedSignature.iHeight);
        this.L.setLayoutParams(layoutParams);
        this.L.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.presenter.ai
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                aj.this.q0(businessFeedData, view);
            }
        });
        String str = businessFeedData.cellFeedSignature.strUrl;
        if (this.M) {
            if (this.N == null) {
                com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k kVar = new com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k();
                kVar.B(100);
                kVar.C(20);
                this.N = kVar;
            }
            this.L.setImageDrawable(((IVipIconUtils) QRoute.api(IVipIconUtils.class)).getQzoneFrameDrawable(str, "", this.N, 0).getDrawable());
            return;
        }
        QzoneZipAnimateUtil.j(str, "vip_signature", str.hashCode() + "", -1, -1, 100, this.f55528b0);
    }

    @Override // vg.a
    protected void C(View view) {
        this.F = (QZoneUserAvatarView) view.findViewById(R.id.nby);
        this.G = (ImageView) view.findViewById(R.id.nbx);
        QZoneNickNameView qZoneNickNameView = (QZoneNickNameView) view.findViewById(R.id.n87);
        this.H = qZoneNickNameView;
        qZoneNickNameView.setMaxWidth(QZoneFeedxViewUtils.g(i(), false));
        this.H.setOnClickListener(this);
        this.K = view.findViewById(R.id.nbt);
        this.J = (ImageView) view.findViewById(R.id.nbs);
        this.I = (TextView) view.findViewById(R.id.nbr);
        this.K.setOnClickListener(this);
        this.T = (ViewGroup) view.findViewById(R.id.nbj);
        this.U = (TextView) view.findViewById(R.id.nbi);
        this.S = (QZoneTimeCountDownView) view.findViewById(R.id.nbh);
        this.Q = (LinearLayout) view.findViewById(R.id.f162923nc3);
        this.R = (QZoneRichTextView) view.findViewById(R.id.f162929nd4);
        this.P = (ImageView) view.findViewById(R.id.mtz);
        int color = view.getResources().getColor(R.color.qui_common_text_secondary);
        this.R.setTextColor(color);
        this.R.setTextColorLink(color);
        this.L = (ImageView) view.findViewById(R.id.nd6);
        this.W = (ImageView) view.findViewById(R.id.nbp);
        this.X = (ImageView) view.findViewById(R.id.nbo);
        int dpToPx = ImmersiveUtils.dpToPx(10.0f);
        QZoneFeedxViewUtils.a(this.W, dpToPx, dpToPx, dpToPx, dpToPx);
        QZoneFeedxViewUtils.a(this.X, dpToPx, dpToPx, dpToPx, dpToPx);
        this.W.setOnClickListener(this);
        this.X.setOnClickListener(this);
        if (com.qzone.reborn.feedx.util.x.f55790a.c(o())) {
            gf.j m3 = m();
            if (m3 != null && m3.y1()) {
                this.W.setVisibility(0);
            } else {
                this.W.setVisibility(8);
            }
        }
        this.F.setOnClickHookListener(new a());
        AccessibilityUtil.s(this.W, com.qzone.util.l.a(R.string.f2202268j));
        AccessibilityUtil.s(this.X, com.qzone.util.l.a(R.string.f2202268j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (aj.this.W != null) {
                aj.this.W.setVisibility(8);
            }
            RFWThreadManager.getInstance().runOnUiThread(aj.this.f55527a0, 2000L);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (aj.this.X != null) {
                aj.this.X.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class c implements Animator.AnimatorListener {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (aj.this.X != null) {
                aj.this.X.setVisibility(8);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (aj.this.W != null) {
                aj.this.W.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
