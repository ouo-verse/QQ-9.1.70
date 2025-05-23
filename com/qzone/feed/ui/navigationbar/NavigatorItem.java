package com.qzone.feed.ui.navigationbar;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.business.tianshu.h;
import com.qzone.business.tianshu.model.QZoneBubbleInfo;
import com.qzone.common.account.LoginData;
import com.qzone.feed.utils.QZoneGalleryEntranceLoopAnimManager;
import com.qzone.personalize.model.CustomFriendNaviData;
import com.qzone.reborn.feedx.widget.navigator.QZoneNavigatorAvatarLoopView;
import com.qzone.util.ar;
import com.qzone.widget.AsyncImageView;
import com.qzone.widget.AsyncImageable;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.biz.richframework.widget.RFWSquareImageView;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.IQCircleIPCApi;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IQbossReportManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class NavigatorItem extends FrameLayout implements SimpleEventReceiver {
    private String C;
    private String D;
    private int E;
    private String F;
    public int G;
    public String H;
    public AsyncImageView I;
    public String J;
    public String K;
    private View L;
    private Drawable M;
    protected com.qzone.feed.ui.navigationbar.b N;
    private TextView P;
    private RFWSquareImageView Q;
    private RFWSquareImageView R;
    private RFWSquareImageView S;
    private View T;
    private boolean U;
    private boolean V;
    private boolean W;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f47356a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f47357b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f47358c0;

    /* renamed from: d, reason: collision with root package name */
    public String f47359d;

    /* renamed from: d0, reason: collision with root package name */
    private QZoneGalleryEntranceLoopAnimManager f47360d0;

    /* renamed from: e, reason: collision with root package name */
    private TextView f47361e;

    /* renamed from: e0, reason: collision with root package name */
    private Object f47362e0;

    /* renamed from: f, reason: collision with root package name */
    public ImageView f47363f;

    /* renamed from: f0, reason: collision with root package name */
    private Runnable f47364f0;

    /* renamed from: g0, reason: collision with root package name */
    private AsyncImageable.AsyncImageListener f47365g0;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f47366h;

    /* renamed from: i, reason: collision with root package name */
    private QZoneNavigatorAvatarLoopView f47367i;

    /* renamed from: m, reason: collision with root package name */
    private CustomFriendNaviData f47368m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QLog.isColorLevel()) {
                NavigatorItem navigatorItem = NavigatorItem.this;
                QLog.d(navigatorItem.f47359d, 2, navigatorItem.F);
            }
            NavigatorItem navigatorItem2 = NavigatorItem.this;
            com.qzone.feed.ui.navigationbar.b bVar = navigatorItem2.N;
            if (bVar != null) {
                String str = navigatorItem2.C;
                NavigatorItem navigatorItem3 = NavigatorItem.this;
                bVar.a(1, str, navigatorItem3, Integer.valueOf(navigatorItem3.G), null);
                if (NavigatorItem.this.I.getVisibility() == 0) {
                    if (NavigatorItem.this.M != null) {
                        NavigatorItem navigatorItem4 = NavigatorItem.this;
                        navigatorItem4.I.setImageDrawable(navigatorItem4.M);
                    } else if (!TextUtils.isEmpty(NavigatorItem.this.D)) {
                        NavigatorItem navigatorItem5 = NavigatorItem.this;
                        navigatorItem5.I.setAsyncImage(navigatorItem5.D);
                    }
                    NavigatorItem navigatorItem6 = NavigatorItem.this;
                    navigatorItem6.I(navigatorItem6.J, 2);
                    if (!TextUtils.isEmpty(NavigatorItem.this.K)) {
                        ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportClick(NavigatorItem.this.K, null);
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class d implements IPicLoadStateListener {
        d() {
        }

        @Override // com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            if (!loadState.isFinishSuccess() || option.getAnimatable() == null) {
                return;
            }
            option.getAnimatable().start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class e implements QZoneGalleryEntranceLoopAnimManager.b {
        e() {
        }

        @Override // com.qzone.feed.utils.QZoneGalleryEntranceLoopAnimManager.b
        public void a() {
            NavigatorItem.this.K(false);
            if (NavigatorItem.this.f47360d0 == null) {
                return;
            }
            NavigatorItem.this.f47360d0.j();
        }
    }

    public NavigatorItem(Context context, CustomFriendNaviData customFriendNaviData) {
        super(context);
        this.f47359d = "NavigatorBar.NavigatorItem";
        this.M = null;
        this.f47364f0 = new Runnable() { // from class: com.qzone.feed.ui.navigationbar.NavigatorItem.1
            @Override // java.lang.Runnable
            public void run() {
                NavigatorItem navigatorItem = NavigatorItem.this;
                navigatorItem.n(navigatorItem.f47363f, navigatorItem.I);
            }
        };
        this.f47365g0 = new a();
        this.f47368m = customFriendNaviData;
        A(context);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(LoadState loadState, Option option) {
        if (loadState == LoadState.STATE_SUCCESS) {
            if (this.M != null) {
                QLog.d(this.f47359d, 1, "load navi item url success but replace by custom drawable: " + this.D);
                this.f47363f.setImageDrawable(this.M);
                return;
            }
            com.tencent.mobileqq.qzone.picload.c.a().m(this.f47363f, getContext().getResources().getColor(R.color.qui_common_icon_primary));
            QLog.d(this.f47359d, 1, "load navi item url success: " + this.D);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(String str, int i3) {
        u5.b.r0("reddoticon_config:" + str, i3, LoginData.getInstance().getUin());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(boolean z16) {
        J(this.T, z16);
        J(this.Q, z16);
        J(this.R, z16);
        J(this.S, z16);
    }

    private void M(int i3) {
        if (this.P == null || this.f47366h == null || i3 <= 0) {
            return;
        }
        String valueOf = String.valueOf(i3);
        if (TextUtils.isEmpty(valueOf)) {
            QLog.d(this.f47359d, 1, "num is null");
            return;
        }
        if (i3 > 99) {
            this.P.setText(getResources().getString(R.string.w_k));
        } else {
            this.P.setText(valueOf);
        }
        this.P.setVisibility(0);
        this.f47366h.setVisibility(8);
    }

    private void N() {
        TextView textView = this.P;
        if (textView == null || this.f47366h == null) {
            return;
        }
        textView.setVisibility(8);
        this.f47366h.setVisibility(0);
    }

    private int u(String str) {
        return u5.b.H("reddoticon_config:" + str, -1, LoginData.getInstance().getUin());
    }

    private void y() {
        TextView textView = this.P;
        if (textView == null || this.f47366h == null) {
            return;
        }
        textView.setVisibility(8);
        this.f47366h.setVisibility(8);
    }

    protected void A(Context context) {
        this.L = LayoutInflater.from(context).inflate(R.layout.bnr, this);
        this.f47363f = (ImageView) findViewById(R.id.dpe);
        this.I = (AsyncImageView) findViewById(R.id.dpf);
        this.f47361e = (TextView) findViewById(R.id.dq7);
        this.f47366h = (ImageView) findViewById(R.id.dpg);
        this.f47367i = (QZoneNavigatorAvatarLoopView) findViewById(R.id.zmf);
        this.P = (TextView) findViewById(R.id.vhe);
        View findViewById = findViewById(R.id.f68593gg);
        this.T = findViewById;
        this.Q = (RFWSquareImageView) findViewById.findViewById(R.id.yuv);
        this.R = (RFWSquareImageView) this.T.findViewById(R.id.yuw);
        this.S = (RFWSquareImageView) this.T.findViewById(R.id.yux);
        this.L.setOnClickListener(new b());
    }

    public void C() {
        if (QZLog.isColorLevel()) {
            QZLog.i(this.f47359d, "invalidRedDotIcon");
        }
        if (this.I.getVisibility() == 0) {
            return;
        }
        this.I.removeCallbacks(this.f47364f0);
    }

    public boolean D() {
        AsyncImageView asyncImageView = this.I;
        return asyncImageView != null && asyncImageView.getVisibility() == 0;
    }

    public boolean E() {
        ImageView imageView = this.f47366h;
        return imageView != null && imageView.getVisibility() == 0;
    }

    public void H() {
        QZoneNavigatorAvatarLoopView qZoneNavigatorAvatarLoopView = this.f47367i;
        if (qZoneNavigatorAvatarLoopView == null) {
            return;
        }
        qZoneNavigatorAvatarLoopView.u0();
    }

    public void O() {
        ImageView imageView = this.f47363f;
        if (imageView != null) {
            imageView.setPadding(0, 0, 0, 0);
            Drawable drawable = this.M;
            if (drawable != null) {
                this.f47363f.setImageDrawable(drawable);
            } else if (!TextUtils.isEmpty(this.D)) {
                com.tencent.mobileqq.qzone.picload.c.a().i(Option.obtain().setUrl(this.D).setTargetView(this.f47363f).setNeedShowLoadingDrawable(false), new IPicLoadStateListener() { // from class: com.qzone.feed.ui.navigationbar.a
                    @Override // com.tencent.libra.listener.IPicLoadStateListener
                    public final void onStateChange(LoadState loadState, Option option) {
                        NavigatorItem.this.F(loadState, option);
                    }
                });
            } else if (this.E != 0) {
                int d16 = ar.d(4.0f);
                this.f47363f.setPadding(d16, d16, d16, d16);
                this.f47363f.setImageResource(this.E);
            }
            if (this.I.getVisibility() != 0 && this.f47367i.getVisibility() != 0) {
                this.f47363f.setVisibility(0);
            } else {
                this.f47363f.setVisibility(8);
            }
        }
    }

    public void P() {
        if (this.I.getVisibility() == 0) {
            return;
        }
        if (E()) {
            if (QZLog.isColorLevel()) {
                QZLog.i(this.f47359d, "reddot is visible ,not show reddoticon");
            }
        } else {
            if (TextUtils.isEmpty(this.J)) {
                return;
            }
            int u16 = u(this.J);
            if (u16 == 1) {
                this.I.setAsyncImage(this.J);
                this.I.setVisibility(0);
                this.f47363f.setVisibility(4);
            } else {
                if (u16 == 2) {
                    return;
                }
                this.I.setAsyncImageListener(this.f47365g0);
                this.I.setAsyncImage(this.J);
            }
        }
    }

    public void Q(int i3, int i16) {
        if (E() || D() || o()) {
            return;
        }
        this.f47366h.setImageResource(i3);
        this.f47366h.setVisibility(0);
        if (TextUtils.isEmpty(this.H)) {
            return;
        }
        ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportExpose(this.H, null);
    }

    public void R(List<Long> list) {
        QLog.d(this.f47359d, 1, "uin list size is " + list.size());
        if (RFSafeListUtils.isEmpty(list)) {
            this.f47367i.setVisibility(8);
            this.f47363f.setVisibility(0);
        } else {
            this.f47367i.setVisibility(0);
            this.f47363f.setVisibility(8);
        }
        this.f47367i.setData(list);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QZoneUpdateGalleryEntranceRedPointEvent.class);
        return arrayList;
    }

    public boolean o() {
        if (TextUtils.isEmpty(this.J)) {
            return false;
        }
        int u16 = u(this.J);
        return u16 == -1 || u16 == 1;
    }

    public void onDestroy() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        QZoneNavigatorAvatarLoopView qZoneNavigatorAvatarLoopView = this.f47367i;
        if (qZoneNavigatorAvatarLoopView != null) {
            qZoneNavigatorAvatarLoopView.s0();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QZoneUpdateGalleryEntranceRedPointEvent) {
            x((QZoneUpdateGalleryEntranceRedPointEvent) simpleBaseEvent);
        }
    }

    public Object q() {
        return this.f47362e0;
    }

    public int r() {
        if (this.V) {
            return 2;
        }
        return this.W ? 1 : 0;
    }

    public int s() {
        if (this.U) {
            return 2;
        }
        return this.f47356a0 ? 1 : 0;
    }

    public void setDrawableIcon(Drawable drawable) {
        this.M = drawable;
        O();
    }

    public void setElementClickListener(com.qzone.feed.ui.navigationbar.b bVar) {
        this.N = bVar;
    }

    public void setExt(Object obj) {
        this.f47362e0 = obj;
    }

    public void setIconRes(int i3) {
        this.E = i3;
    }

    public void setIconUrl(String str) {
        this.D = str;
    }

    public void setQbossIcon(String str) {
        this.J = str;
    }

    public void setQbossIconTraceinfo(String str) {
        this.K = str;
    }

    public void setReportValue(int i3) {
        this.G = i3;
    }

    public void setSchema(String str) {
        this.C = str;
    }

    public void setText(String str) {
        this.F = str;
        TextView textView = this.f47361e;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setTextColor(String str) {
        TextView textView = this.f47361e;
        if (textView != null) {
            try {
                textView.setTextColor(Color.parseColor(str));
            } catch (Exception unused) {
            }
        }
    }

    public void setYellowVipDrawableIcon(Drawable drawable) {
        this.M = drawable;
        O();
    }

    public void t() {
        if (this.f47357b0) {
            return;
        }
        this.f47357b0 = true;
        h.l().r(new c());
        h.l().f(1140);
    }

    public String v() {
        return this.F;
    }

    public String w() {
        return this.f47358c0;
    }

    public void z() {
        if (!E() || this.f47356a0) {
            return;
        }
        this.f47366h.setVisibility(8);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements AsyncImageable.AsyncImageListener {
        a() {
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageLoaded(AsyncImageable asyncImageable) {
            AsyncImageView asyncImageView;
            if (asyncImageable == null || (asyncImageView = NavigatorItem.this.I) == null) {
                return;
            }
            asyncImageView.setImageDrawable(asyncImageable.getDrawable());
            NavigatorItem navigatorItem = NavigatorItem.this;
            navigatorItem.I.removeCallbacks(navigatorItem.f47364f0);
            NavigatorItem navigatorItem2 = NavigatorItem.this;
            navigatorItem2.I.postDelayed(navigatorItem2.f47364f0, 2000L);
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageFailed(AsyncImageable asyncImageable) {
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageStarted(AsyncImageable asyncImageable) {
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageProgress(AsyncImageable asyncImageable, float f16) {
        }
    }

    private ObjectAnimator p(View view, String str, float f16, float f17, long j3, long j16) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, str, f16, f17);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setDuration(j3);
        ofFloat.setStartDelay(j16);
        return ofFloat;
    }

    public void G() {
        L(0, 0);
        QIPCClientHelper.getInstance().callServer(IQCircleIPCApi.MODULE_NAME, IQCircleIPCApi.ACTION_READ_GALLERY_RED_POINT_INFO, null, null);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c implements h.a {
        c() {
        }

        @Override // com.qzone.business.tianshu.h.a
        public void a(QZoneBubbleInfo qZoneBubbleInfo) {
            if (qZoneBubbleInfo == null) {
                return;
            }
            if (h.l().m(qZoneBubbleInfo) > qZoneBubbleInfo.getMaxTimes()) {
                QLog.d(NavigatorItem.this.f47359d, 2, "up to max time, not show pic list");
                return;
            }
            h.l().o(qZoneBubbleInfo);
            if (qZoneBubbleInfo.getType().equals("lunbo")) {
                NavigatorItem.this.V = true;
            } else {
                NavigatorItem.this.W = true;
            }
            NavigatorItem.this.f47358c0 = qZoneBubbleInfo.getId();
            NavigatorItem.this.B(qZoneBubbleInfo.getLoopPicList());
        }
    }

    public void B(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() != 3) {
            return;
        }
        S(this.Q, arrayList.get(0), ImmersiveUtils.dpToPx(34.0f), ImmersiveUtils.dpToPx(34.0f));
        S(this.R, arrayList.get(1), ImmersiveUtils.dpToPx(28.0f), ImmersiveUtils.dpToPx(28.0f));
        S(this.S, arrayList.get(2), ImmersiveUtils.dpToPx(28.0f), ImmersiveUtils.dpToPx(28.0f));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.Q);
        arrayList2.add(this.R);
        arrayList2.add(this.S);
        K(true);
        if (this.f47360d0 == null) {
            this.f47360d0 = new QZoneGalleryEntranceLoopAnimManager(arrayList2);
        }
        this.f47360d0.k(new e());
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.qzone.feed.ui.navigationbar.NavigatorItem.7
            @Override // java.lang.Runnable
            public void run() {
                if (NavigatorItem.this.f47360d0 == null) {
                    return;
                }
                NavigatorItem.this.f47360d0.l();
            }
        }, 2000L);
    }

    private void S(RFWSquareImageView rFWSquareImageView, String str, int i3, int i16) {
        if (rFWSquareImageView == null) {
            return;
        }
        rFWSquareImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        com.tencent.mobileqq.qzone.picload.c.a().i(Option.obtain().setUrl(str).setTargetView(rFWSquareImageView).setFromPreLoad(false).setPredecode(true).setSupportRecycler(true).setRequestWidth(i3).setRequestHeight(i16).setLoadingDrawableColor(getContext().getResources().getColor(R.color.f156918f7)).setFailedDrawableId(R.drawable.fux), new d());
    }

    private void x(QZoneUpdateGalleryEntranceRedPointEvent qZoneUpdateGalleryEntranceRedPointEvent) {
        if (qZoneUpdateGalleryEntranceRedPointEvent != null && this.G == 65) {
            int redPointType = qZoneUpdateGalleryEntranceRedPointEvent.getRedPointType();
            int redPointNum = qZoneUpdateGalleryEntranceRedPointEvent.getRedPointNum();
            QLog.d(this.f47359d, 1, "qzone navigator gallery entrance red point type is " + redPointType + " red point num is " + redPointNum);
            L(redPointType, redPointNum);
        }
    }

    public NavigatorItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f47359d = "NavigatorBar.NavigatorItem";
        this.M = null;
        this.f47364f0 = new Runnable() { // from class: com.qzone.feed.ui.navigationbar.NavigatorItem.1
            @Override // java.lang.Runnable
            public void run() {
                NavigatorItem navigatorItem = NavigatorItem.this;
                navigatorItem.n(navigatorItem.f47363f, navigatorItem.I);
            }
        };
        this.f47365g0 = new a();
    }

    private void J(View view, boolean z16) {
        if (view == null) {
            return;
        }
        view.setVisibility(z16 ? 0 : 8);
    }

    public void L(int i3, int i16) {
        if (i3 == 0) {
            y();
            return;
        }
        if (i3 == 1) {
            this.f47356a0 = true;
            N();
        } else {
            if (i3 != 2) {
                return;
            }
            this.U = true;
            M(i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(View view, final View view2) {
        if (view == null || view2 == null || !view.isShown() || view2.isShown()) {
            return;
        }
        ObjectAnimator p16 = p(view, BasicAnimation.KeyPath.SCALE_X, 1.0f, 1.15f, 120L, 0L);
        ObjectAnimator p17 = p(view, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 1.15f, 120L, 0L);
        ObjectAnimator p18 = p(view, BasicAnimation.KeyPath.ROTATION, 0.0f, 90.0f, 280L, 120L);
        ObjectAnimator p19 = p(view, BasicAnimation.KeyPath.SCALE_X, 1.15f, 0.0f, 280L, 120L);
        ObjectAnimator p26 = p(view, BasicAnimation.KeyPath.SCALE_Y, 1.15f, 0.0f, 280L, 120L);
        final ObjectAnimator p27 = p(view2, BasicAnimation.KeyPath.ROTATION, -90.0f, 0.0f, 280L, 0L);
        final ObjectAnimator p28 = p(view2, "ScaleX", 0.0f, 1.15f, 280L, 0L);
        final ObjectAnimator p29 = p(view2, "ScaleY", 0.0f, 1.15f, 280L, 0L);
        final ObjectAnimator p36 = p(view2, "ScaleX", 1.15f, 0.96f, 160L, 280L);
        final ObjectAnimator p37 = p(view2, "ScaleY", 1.15f, 0.96f, 160L, 280L);
        final ObjectAnimator p38 = p(view2, "ScaleX", 0.96f, 1.05f, 120L, 440L);
        final ObjectAnimator p39 = p(view2, "ScaleY", 0.96f, 1.05f, 120L, 440L);
        final ObjectAnimator p46 = p(view2, "ScaleX", 1.05f, 1.0f, 120L, 560L);
        final ObjectAnimator p47 = p(view2, "ScaleY", 1.05f, 1.0f, 120L, 560L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(p16).with(p17).with(p18).with(p19).with(p26);
        animatorSet.start();
        view2.postDelayed(new Runnable() { // from class: com.qzone.feed.ui.navigationbar.NavigatorItem.8
            @Override // java.lang.Runnable
            public void run() {
                view2.setVisibility(0);
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.play(p27).with(p28).with(p29).with(p36).with(p37).with(p38).with(p39).with(p46).with(p47);
                animatorSet2.start();
            }
        }, 320L);
        I(this.J, 1);
    }
}
