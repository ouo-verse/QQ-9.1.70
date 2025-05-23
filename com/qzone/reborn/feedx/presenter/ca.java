package com.qzone.reborn.feedx.presenter;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellMallInfo;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.reborn.feedx.presenter.ca;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasDynamicDrawableCache;
import com.tencent.mobileqq.vas.ui.IVipFrameDrawable;
import com.tencent.mobileqq.vip.api.IVipIconUtils;
import com.tencent.mobileqq.vip.api.IVipIconUtilsForQzone;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable;
import common.config.service.QzoneConfig;
import cooperation.vip.vipcomponent.QQUnionIconInfo;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ca extends vg.a implements View.OnClickListener {
    public static final float R = FeedGlobalEnv.g().getScreenWidth() / 720.0f;
    private static String S = "";
    private ImageView F;
    private ImageView G;
    private ImageView H;
    private FrameLayout I;
    private ImageView J;
    private ImageView K;
    private ImageView L;
    private ImageView M;
    private Drawable N;
    private IVipFrameDrawable P;
    private String Q = "";

    private void L() {
        ImageView imageView = this.L;
        if (imageView != null) {
            imageView.setImageDrawable(null);
            this.L.setVisibility(8);
        }
    }

    private void M(final User user) {
        if (TextUtils.isEmpty(user.feedAvatarDecorationUrl)) {
            this.G.setVisibility(8);
            this.G.setClickable(false);
            return;
        }
        this.G.setVisibility(0);
        com.tencent.mobileqq.qzone.picload.c.a().h(Option.obtain().setTargetView(this.G).setNeedShowLoadingDrawable(false).setUrl(user.feedAvatarDecorationUrl));
        if (o() == 3) {
            this.G.setClickable(true);
            this.G.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.presenter.bv
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ca.this.S(user, view);
                }
            });
        } else {
            this.G.setClickable(false);
        }
    }

    private void N(User user) {
        CellMallInfo.CellSweetVip cellSweetVip;
        if (user.isSweetVip != 0 && user.vipShowType != 4 && !this.f441565h.getFeedCommInfo().isBizRecomFeeds()) {
            this.M.setVisibility(0);
            String m06 = com.qzone.adapter.feedcomponent.i.H().m0(user.uin + "");
            if (TextUtils.isEmpty(m06)) {
                CellMallInfo cellMallInfo = this.f441565h.cellMallInfo;
                if (cellMallInfo != null && (cellSweetVip = cellMallInfo.cellSweetVip) != null && !TextUtils.isEmpty(cellSweetVip.iconPicUrl)) {
                    m06 = this.f441565h.cellMallInfo.cellSweetVip.iconPicUrl;
                } else {
                    if (TextUtils.isEmpty(S)) {
                        S = QzoneConfig.instance.getConfig("QZoneSetting", "sweetIconRUL", "https://qzonestyle.gtimg.cn/aoi/sola/20170905110724_aew14oIQKq.png");
                    }
                    m06 = S;
                }
            }
            if (TextUtils.isEmpty(m06)) {
                return;
            }
            FastDynamicDrawable a16 = com.tencent.cachedrawable.dynamicdrawable.api.a.a().k(m06).l(VasDynamicDrawableCache.INSTANCE).a();
            this.M.setImageDrawable(a16);
            a16.c0(new Function1() { // from class: com.qzone.reborn.feedx.presenter.bw
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit T;
                    T = ca.this.T((com.tencent.cachedrawable.dynamicdrawable.d) obj);
                    return T;
                }
            });
            return;
        }
        this.M.setVisibility(8);
    }

    private void O() {
        QQUnionIconInfo qQUnionIconInfo;
        if (!(!this.f441565h.getFeedCommInfo().isBizRecomFeeds() && (this.f441565h.isQQUnionVip() || this.f441565h.isQQNewVip()))) {
            L();
            return;
        }
        if (this.f441565h.isQQNewVip()) {
            qQUnionIconInfo = com.qzone.adapter.feedcomponent.i.H().w0(-1, QQUnionIconInfo.convertToQQUnionIconMap(this.f441565h.cellMallInfo.cellQQNewVip.qqNewVipIconMap));
        } else if (this.f441565h.isQQUnionVip()) {
            com.qzone.adapter.feedcomponent.i H = com.qzone.adapter.feedcomponent.i.H();
            CellMallInfo.CellQQUionVip cellQQUionVip = this.f441565h.cellMallInfo.cellQQUionVip;
            qQUnionIconInfo = H.w0(cellQQUionVip.iLevel, QQUnionIconInfo.convertToQQUnionIconMap(cellQQUionVip.qqUnionIconMap));
        } else {
            qQUnionIconInfo = null;
        }
        if (qQUnionIconInfo != null && !TextUtils.isEmpty(qQUnionIconInfo.mIconUrl)) {
            String str = qQUnionIconInfo.mIconUrl;
            String carouselUrls = QQUnionIconInfo.getCarouselUrls(qQUnionIconInfo);
            if (!TextUtils.isEmpty(carouselUrls)) {
                W(carouselUrls);
            } else {
                String tenYellowId = QQUnionIconInfo.getTenYellowId(qQUnionIconInfo);
                RFWLog.d("QZoneFeedVipPresenter", RFWLog.USR, "vip icon url: " + str);
                if (!this.Q.equals(str)) {
                    if (!TextUtils.isEmpty(tenYellowId)) {
                        Y(tenYellowId, str, qQUnionIconInfo.mIconHeight);
                    } else {
                        X(str);
                    }
                    this.Q = str;
                }
            }
            if (qQUnionIconInfo.mIconWidth > 0 && qQUnionIconInfo.mIconHeight > 0) {
                ViewGroup.LayoutParams layoutParams = this.L.getLayoutParams();
                layoutParams.width = ViewUtils.dpToPx(qQUnionIconInfo.mIconWidth / 2);
                layoutParams.height = ViewUtils.dpToPx(qQUnionIconInfo.mIconHeight / 2);
            }
            this.I.setVisibility(0);
            this.J.setVisibility(8);
            this.K.setVisibility(8);
            this.L.setVisibility(0);
            this.L.setScaleType(ImageView.ScaleType.FIT_XY);
            this.L.setContentDescription("\u94ed\u724c");
            return;
        }
        L();
    }

    private void P(User user) {
        if (user.isCanShowStarVip()) {
            Drawable D0 = com.qzone.adapter.feedcomponent.i.H().D0(user, new a());
            if (D0 != null) {
                this.H.setVisibility(0);
                this.H.setImageDrawable(D0);
                com.qzone.adapter.feedcomponent.i.H().h2();
                return;
            }
            this.H.setVisibility(8);
            return;
        }
        this.H.setVisibility(8);
    }

    private void R(User user) {
        int i3 = user.vip;
        boolean z16 = user.isCustomDiamond;
        if (!z16 && i3 == 2) {
            if (!TextUtils.isEmpty(user.yellowDiamondUrl)) {
                com.tencent.mobileqq.qzone.picload.c.a().h(Option.obtain().setUrl(user.yellowDiamondUrl).setTargetView(this.K));
            } else {
                this.K.setVisibility(8);
            }
        } else {
            this.K.setVisibility(8);
        }
        Drawable M0 = com.qzone.adapter.feedcomponent.i.H().M0(user, null);
        if (M0 != null) {
            com.qzone.adapter.feedcomponent.i.H().r2(this.f441565h);
            this.J.setVisibility(0);
            this.J.setImageDrawable(M0);
            this.J.setScaleType(ImageView.ScaleType.MATRIX);
            if (!z16 && i3 == 2 && (M0 instanceof m15.a)) {
                m15.a aVar = (m15.a) M0;
                aVar.b();
                aVar.c();
                this.K.getLayoutParams();
                BusinessFeedData businessFeedData = this.f441565h;
                if (businessFeedData != null && businessFeedData.getCellUserInfo().getLuckyMoneyPics() != null && this.f441565h.getCellUserInfo().getLuckyMoneyPics().size() > 0) {
                    this.K.setVisibility(0);
                } else {
                    this.K.setVisibility(0);
                }
            }
            this.J.setContentDescription("vip" + user.vipLevel);
            return;
        }
        this.K.setVisibility(8);
        this.I.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(User user, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        V(user);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit T(com.tencent.cachedrawable.dynamicdrawable.d dVar) {
        BusinessFeedData businessFeedData = this.f441565h;
        CellFeedCommInfo feedCommInfo = businessFeedData == null ? null : businessFeedData.getFeedCommInfo();
        if (feedCommInfo != null) {
            com.qzone.adapter.feedcomponent.i.H().d2(feedCommInfo.feedsType);
        }
        return null;
    }

    private void V(User user) {
        if (user.avatarDecorationType == 2) {
            String str = user.feedAvatarDecorationJumpUrl;
            if (str != null) {
                vo.c.o(this.C, str);
            } else {
                vo.c.n(this.C);
            }
            ClickReport.m("606", "2", "2");
            return;
        }
        String str2 = user.feedAvatarDecorationJumpUrl;
        if (str2 != null) {
            vo.c.e(this.C, str2, user.avatarDecorationId + "", QzoneCoverConst.REFER_USERHOME, user.uin);
        } else {
            vo.c.d(this.C, user.avatarDecorationId + "", QzoneCoverConst.REFER_USERHOME, user.uin);
        }
        ClickReport.m("606", "2", "1");
    }

    private void W(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        IVipFrameDrawable iVipFrameDrawable = this.P;
        if (iVipFrameDrawable != null) {
            Z(iVipFrameDrawable.getDrawable());
        } else {
            ((IVipIconUtils) QRoute.api(IVipIconUtils.class)).getQzoneNamePlateDrawable(str, new Function1() { // from class: com.qzone.reborn.feedx.presenter.bx
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit U;
                    U = ca.this.U((IVipFrameDrawable) obj);
                    return U;
                }
            });
        }
    }

    private void X(String str) {
        if (!TextUtils.isEmpty(str) && (this.N == null || !str.equals(((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).getAnimationResZipUrl(this.N)))) {
            if (this.N == null) {
                this.N = ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).getZipAnimationDrawable();
            }
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setAnimationRes(this.N, str, 10);
        }
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setScale(this.N, R);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).clearFirstFrame(this.N);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setRepeatAnimation(this.N, true);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setShowLastFrameWhenStop(this.N, true);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).start(this.N);
        this.L.setImageDrawable(this.N);
    }

    private void Y(String str, String str2, int i3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.L.setImageDrawable(((IVipIconUtilsForQzone) QRoute.api(IVipIconUtilsForQzone.class)).getQzoneLetterSwitchIcon(str2, Arrays.asList(str.split("#")), "bg.png", "fc.png", ViewUtils.dpToPx(i3)));
    }

    private void Z(Drawable drawable) {
        ViewGroup.LayoutParams layoutParams = this.L.getLayoutParams();
        layoutParams.width = (drawable.getIntrinsicWidth() * ViewUtils.dip2px(20.0f)) / drawable.getIntrinsicHeight();
        layoutParams.height = ViewUtils.dip2px(20.0f);
        this.L.setLayoutParams(layoutParams);
        this.L.setImageDrawable(drawable);
    }

    @Override // vg.a
    protected void A(BusinessFeedData businessFeedData) {
        if (businessFeedData.isFakeFeed()) {
            this.H.setVisibility(8);
            this.I.setVisibility(8);
            this.G.setVisibility(8);
            this.F.setVisibility(8);
            this.M.setVisibility(8);
            return;
        }
        if (ef.b.j(businessFeedData)) {
            M(this.f441565h.getUser());
            this.H.setVisibility(8);
            this.I.setVisibility(8);
            this.F.setVisibility(8);
            this.M.setVisibility(8);
            return;
        }
        User user = this.f441565h.getUser();
        M(user);
        P(user);
        Q(user);
        N(user);
    }

    @Override // vg.a
    /* renamed from: k */
    protected String getTAG() {
        return "QZoneFeedVipPresenter";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.nd8) {
            com.qzone.adapter.feedcomponent.i.H().q(view.getContext(), this.f441565h);
        } else if (view.getId() == R.id.f162928nd3) {
            com.qzone.adapter.feedcomponent.i.H().p(view.getContext());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // vg.a
    protected int s() {
        return R.id.nog;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    private void Q(User user) {
        if (!user.isEnableShowIcon(1L)) {
            this.I.setVisibility(8);
        } else {
            this.I.setVisibility(0);
            R(user);
        }
        O();
    }

    @Override // vg.a
    protected void C(View view) {
        this.F = (ImageView) view.findViewById(R.id.mxo);
        this.G = (ImageView) view.findViewById(R.id.ncc);
        this.H = (ImageView) view.findViewById(R.id.f162928nd3);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.nd8);
        this.I = frameLayout;
        this.J = (ImageView) frameLayout.findViewById(R.id.nd9);
        this.K = (ImageView) this.I.findViewById(R.id.nd7);
        this.M = (ImageView) view.findViewById(R.id.f162926nd1);
        this.L = (ImageView) this.I.findViewById(R.id.nd5);
        this.I.setOnClickListener(this);
        this.M.setOnClickListener(this);
        this.F.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit U(IVipFrameDrawable iVipFrameDrawable) {
        if (iVipFrameDrawable == null) {
            return null;
        }
        Drawable drawable = iVipFrameDrawable.getDrawable();
        if (drawable.getIntrinsicHeight() > 0 && drawable.getIntrinsicWidth() > 0) {
            this.P = iVipFrameDrawable;
            Z(drawable);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements s8.j {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(Drawable drawable) {
            ca.this.H.setImageDrawable(drawable);
        }

        @Override // cooperation.vip.vipcomponent.util.VipResourcesListener
        public void onLoaded(final Drawable drawable) {
            ca.this.H.post(new Runnable() { // from class: com.qzone.reborn.feedx.presenter.bz
                @Override // java.lang.Runnable
                public final void run() {
                    ca.a.this.b(drawable);
                }
            });
        }

        @Override // cooperation.vip.vipcomponent.util.VipResourcesListener
        public void onFailed() {
        }
    }
}
