package com.tencent.biz.qqcircle.immersive.views.banner.bottom;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.PathInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSSeekEvent;
import com.tencent.biz.qqcircle.richframework.widget.SquareImageView;
import com.tencent.biz.qqcircle.utils.bh;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarListView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.libra.LoadState;
import com.tencent.libra.decode.LibraRequestKey;
import com.tencent.libra.download.LibraDownloadKey;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ae extends com.tencent.biz.qqcircle.immersive.views.banner.bottom.c implements View.OnClickListener, SimpleEventReceiver {
    private static final int U = cx.a(32.0f);
    private static final byte[] V = {1, 2, 2, 3, 32, 0, 0, 0, 40, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 48, 0, 0, 0, 97, 0, 0, 0, 101, 0, 0, 0, 0, 0, 0, 0, 87, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0};
    private View D;
    private View E;
    private View F;
    private QCircleAvatarListView G;
    private TextView H;
    private ImageView I;
    private ImageView J;
    private TextView K;
    private View L;
    private TextView M;
    private ImageView N;
    private LinearLayout P;
    private View Q;
    private TextView R;
    private View S;
    private Runnable T;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends QCirclePicStateListener {
        a() {
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            Bitmap resultBitMap;
            if (loadState == LoadState.STATE_SUCCESS && (resultBitMap = option.getResultBitMap()) != null) {
                resultBitMap.setDensity(320);
                ae.this.Q.setBackgroundDrawable(new NinePatchDrawable(resultBitMap, ae.V, new Rect(), ""));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StUser f90591d;

        b(FeedCloudMeta$StUser feedCloudMeta$StUser) {
            this.f90591d = feedCloudMeta$StUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            com.tencent.biz.qqcircle.launcher.c.g(view.getContext(), this.f90591d.jumpUrl.get());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c extends CharacterStyle {
        c() {
        }

        @Override // android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ae.this.j().getColor(R.color.ck8));
        }
    }

    public ae(com.tencent.biz.qqcircle.immersive.views.banner.bottom.a aVar) {
        super(aVar);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private void C() {
        SquareImageView squareImageView = new SquareImageView(j());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(cx.a(32.0f), cx.a(32.0f));
        layoutParams.leftMargin = cx.a(4.0f);
        layoutParams.rightMargin = cx.a(4.0f);
        squareImageView.setLayoutParams(layoutParams);
        squareImageView.setRoundRect(90);
        squareImageView.setImageResource(R.drawable.oqp);
        squareImageView.setBackgroundColor(j().getColor(R.color.ckr));
        this.P.addView(squareImageView);
    }

    private void D(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        QCircleAvatarView qCircleAvatarView = new QCircleAvatarView(j());
        qCircleAvatarView.setStrokes(cx.a(0.5f), j().getColor(R.color.ck8), 0, 0);
        qCircleAvatarView.setUser(feedCloudMeta$StUser, com.tencent.biz.qqcircle.immersive.utils.n.a(j(), R.dimen.f158718n8));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(cx.a(32.0f), cx.a(32.0f));
        layoutParams.leftMargin = cx.a(4.0f);
        layoutParams.rightMargin = cx.a(4.0f);
        qCircleAvatarView.setLayoutParams(layoutParams);
        qCircleAvatarView.setOnClickListener(new b(feedCloudMeta$StUser));
        this.P.addView(qCircleAvatarView);
        H(qCircleAvatarView, "em_xsj_author_avatar", feedCloudMeta$StUser.f398463id.get());
    }

    private void E() {
        View view = this.D;
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = (int) (bz.i(j()) * 0.72f);
        QLog.d("QFSFeedTeamActivityView", 1, "[adjustContainerSize] width: " + layoutParams.width);
        this.D.setLayoutParams(layoutParams);
    }

    private void F() {
        if (this.T != null) {
            n().removeCallbacks(this.T);
        }
    }

    private void G(QFSSeekEvent qFSSeekEvent) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.buttomBanner.style_type.get() == 6 && this.D != null && TextUtils.equals(qFSSeekEvent.mFeedId, this.f90602e.f398449id.get())) {
            if (qFSSeekEvent.mIsOnSeek) {
                this.D.setVisibility(8);
                this.S.setVisibility(4);
                return;
            }
            this.D.setVisibility(0);
            if (J()) {
                this.S.setVisibility(4);
            } else {
                this.S.setVisibility(0);
            }
        }
    }

    private void H(View view, String str, String str2) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        String str3;
        if (this.f90601d != null && (feedCloudMeta$StFeed = this.f90602e) != null && view != null) {
            String d16 = bh.d(feedCloudMeta$StFeed.buttomBanner.extInfo.get(), "xsj_operation_activity_id");
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.putAll(ua0.c.d(this.f90601d));
            buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ACTIVITY_ID, d16);
            if (com.tencent.biz.qqcircle.immersive.utils.r.u0(this.f90602e.poster.get())) {
                str3 = "host";
            } else {
                str3 = QCircleDaTongConstant.ElementParamValue.PROFILE_GUEST_TYPE;
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PROFILE_HOST_GUEST_TYPE, str3);
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TEAM_ACTIVITY_STAGE, Integer.valueOf(I(this.f90602e)));
            if (!TextUtils.isEmpty(str2)) {
                buildElementParams.put("xsj_target_qq", str2);
            }
            VideoReport.setElementId(view, str);
            VideoReport.setElementParams(view, buildElementParams);
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        }
    }

    private int I(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        List<FeedCloudMeta$StUser> list = feedCloudMeta$StFeed.buttomBanner.vecUser.get();
        if (list.size() >= 5) {
            return 7;
        }
        if (L(QCirclePluginGlobalInfo.m(), list)) {
            return 2;
        }
        return 1;
    }

    private boolean J() {
        e30.b bVar = this.f90601d;
        if (bVar == null) {
            return false;
        }
        Object b16 = bVar.b("team_activity_has_expand");
        if (!(b16 instanceof Boolean)) {
            return false;
        }
        return ((Boolean) b16).booleanValue();
    }

    private void K() {
        this.E.setOnClickListener(this);
        this.L.setOnClickListener(this);
        this.N.setOnClickListener(this);
    }

    private boolean L(@NonNull FeedCloudMeta$StUser feedCloudMeta$StUser, @NonNull List<FeedCloudMeta$StUser> list) {
        Iterator<FeedCloudMeta$StUser> it = list.iterator();
        while (it.hasNext()) {
            if (feedCloudMeta$StUser.f398463id.get().equals(it.next().f398463id.get())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M() {
        if (J()) {
            return;
        }
        Q();
    }

    private void N(@NotNull View view) {
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.f41451h4);
        if (viewStub == null) {
            return;
        }
        this.S = view.findViewById(R.id.v_p);
        View inflate = viewStub.inflate();
        this.D = inflate;
        this.F = inflate.findViewById(R.id.f55112h1);
        View findViewById = this.D.findViewById(R.id.f55232hc);
        this.E = findViewById;
        findViewById.setOnClickListener(this);
        this.G = (QCircleAvatarListView) this.D.findViewById(R.id.f55222hb);
        this.H = (TextView) this.D.findViewById(R.id.f55212ha);
        this.I = (ImageView) this.D.findViewById(R.id.f55182h8);
        this.J = (ImageView) this.D.findViewById(R.id.f55192h9);
        this.K = (TextView) this.D.findViewById(R.id.f55202h_);
        this.L = this.D.findViewById(R.id.f55172h7);
        this.M = (TextView) this.D.findViewById(R.id.f55152h5);
        this.N = (ImageView) this.D.findViewById(R.id.f55142h4);
        this.P = (LinearLayout) this.D.findViewById(R.id.f55162h6);
        this.Q = this.D.findViewById(R.id.f55132h3);
        this.R = (TextView) this.D.findViewById(R.id.f55122h2);
        K();
        E();
        this.T = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.ad
            @Override // java.lang.Runnable
            public final void run() {
                ae.this.M();
            }
        };
    }

    private void O(View view) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        if (QCirclePluginUtil.isOwner(feedCloudMeta$StFeed.poster.get()) && this.f90602e.buttomBanner.vecUser.size() < 5) {
            P(this.f90602e);
        } else {
            com.tencent.biz.qqcircle.launcher.c.g(view.getContext(), this.f90602e.buttomBanner.button.jump_url.get());
        }
    }

    private void P(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        QCircleShareInfo qCircleShareInfo = new QCircleShareInfo();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = new FeedCloudMeta$StFeed();
        feedCloudMeta$StFeed2.f398449id.set(feedCloudMeta$StFeed.f398449id.get());
        feedCloudMeta$StFeed2.buttomBanner.set(feedCloudMeta$StFeed.buttomBanner.get());
        feedCloudMeta$StFeed2.share.set(feedCloudMeta$StFeed.share.get());
        qCircleShareInfo.feed = feedCloudMeta$StFeed2;
        qCircleShareInfo.feedBlockData = new e30.b(feedCloudMeta$StFeed);
        qCircleShareInfo.shareStyleType = 8;
        o().onHandlerMessage("event_open_share", qCircleShareInfo);
    }

    private void Q() {
        e30.b bVar = this.f90601d;
        if (bVar == null) {
            return;
        }
        bVar.o("team_activity_has_expand", Boolean.TRUE);
        V();
    }

    private void R() {
        e30.b bVar = this.f90601d;
        if (bVar == null) {
            return;
        }
        bVar.o("team_activity_has_expand", Boolean.FALSE);
        T();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        if (this.L == null) {
            return;
        }
        this.D.setBackgroundResource(R.drawable.l9s);
        this.F.setBackground(null);
        this.L.setVisibility(0);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(200L);
        this.L.startAnimation(alphaAnimation);
        VideoReport.traversePage(this.L);
    }

    private void T() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(200L);
        alphaAnimation.setAnimationListener(new f());
        this.L.startAnimation(alphaAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        if (this.L != null && this.F != null) {
            this.D.setBackground(null);
            this.F.setBackgroundResource(R.drawable.l9s);
            this.L.setVisibility(8);
            W();
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.0f, 3.875f, 1.0f, 0.0f, U);
            scaleAnimation.setDuration(300L);
            scaleAnimation.setInterpolator(new PathInterpolator(0.06f, 0.68f, 0.0f, 0.4f));
            this.F.startAnimation(scaleAnimation);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(100L);
            alphaAnimation.setStartOffset(200L);
            alphaAnimation.setAnimationListener(new g());
            this.E.startAnimation(alphaAnimation);
            this.S.startAnimation(alphaAnimation);
        }
    }

    private void V() {
        this.D.setBackground(null);
        this.F.setBackgroundResource(R.drawable.l9s);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.0f, 1.0f, 3.875f, 0.0f, U);
        scaleAnimation.setDuration(300L);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setInterpolator(new PathInterpolator(0.4f, 0.0f, 0.68f, 0.06f));
        scaleAnimation.setAnimationListener(new d());
        this.F.startAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(100L);
        alphaAnimation.setAnimationListener(new e());
        this.E.startAnimation(alphaAnimation);
        this.S.startAnimation(alphaAnimation);
    }

    private void W() {
        View view = this.F;
        if (view == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.height = U;
        this.F.setLayoutParams(layoutParams);
    }

    private void X(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        String d16 = bh.d(feedCloudMeta$StFeed.buttomBanner.extInfo.get(), "title");
        int indexOf = d16.indexOf("|");
        if (indexOf < 0) {
            return;
        }
        String substring = d16.substring(0, indexOf);
        String substring2 = d16.substring(indexOf + 1);
        Drawable drawable = j().getResources().getDrawable(R.drawable.nrq);
        drawable.setBounds(new Rect(0, 0, ImmersiveUtils.dpToPx(16.0f), ImmersiveUtils.dpToPx(16.0f)));
        nb0.d dVar = new nb0.d(drawable, 0);
        dVar.a(0, ImmersiveUtils.dpToPx(2.0f));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(substring);
        spannableStringBuilder.append((CharSequence) " ");
        spannableStringBuilder.append((CharSequence) "|");
        spannableStringBuilder.setSpan(new c(), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
        spannableStringBuilder.setSpan(dVar, spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
        spannableStringBuilder.append((CharSequence) "  ");
        spannableStringBuilder.setSpan(dVar, spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
        spannableStringBuilder.append((CharSequence) substring2);
        this.M.setText(spannableStringBuilder);
    }

    private void Y(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        X(feedCloudMeta$StFeed);
        String d16 = bh.d(feedCloudMeta$StFeed.buttomBanner.extInfo.get(), "button_url");
        QLog.d("QFSFeedTeamActivityView", 1, "updateLargeCardView url: " + d16);
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(d16).setPredecode(true).setCacheKey(new LibraRequestKey.Builder(new LibraDownloadKey(d16)).build()), new a());
        this.R.setText(bh.d(feedCloudMeta$StFeed.buttomBanner.extInfo.get(), QZoneAdTianshuFeedData.KEY_BUTTON_TEXT));
        a0(feedCloudMeta$StFeed);
        H(this.L, QCircleDaTongConstant.ElementId.EM_XSJ_UNFOLD_MAKE_TEAM_GUIDE_BAR, "");
    }

    private void Z(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.H.setText(feedCloudMeta$StFeed.buttomBanner.title.get());
        this.K.setText(feedCloudMeta$StFeed.buttomBanner.button.text.get());
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(bh.d(feedCloudMeta$StFeed.buttomBanner.extInfo.get(), "sub_icon_url")).setTargetView(this.J).setPredecode(true).setRequestWidth(this.J.getLayoutParams().width).setRequestHeight(this.J.getLayoutParams().height), null);
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(feedCloudMeta$StFeed.buttomBanner.button.button_url.get()).setTargetView(this.I).setPredecode(true).setRequestWidth(this.I.getLayoutParams().width).setRequestHeight(this.I.getLayoutParams().height), null);
        if (QCirclePluginUtil.isOwner(feedCloudMeta$StFeed.poster.get()) && feedCloudMeta$StFeed.buttomBanner.vecUser.size() >= 5) {
            this.G.setVisibility(0);
            this.G.setData(com.tencent.biz.qqcircle.utils.o.c(feedCloudMeta$StFeed.buttomBanner.vecUser.get(), 5));
        } else {
            this.G.setVisibility(8);
        }
        H(this.E, QCircleDaTongConstant.ElementId.EM_XSJ_DEFAULT_MAKE_TEAM_GUIDE_BAR, "");
    }

    private void a0(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        int size = feedCloudMeta$StFeed.buttomBanner.vecUser.size();
        QLog.d("QFSFeedTeamActivityView", 1, "updateUserView size: " + size);
        this.P.removeAllViews();
        for (int i3 = 0; i3 < 5; i3++) {
            if (i3 < size) {
                D(feedCloudMeta$StFeed.buttomBanner.vecUser.get(i3));
            } else {
                C();
            }
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSSeekEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 105;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        if (this.f90602e == null) {
            return false;
        }
        QLog.d("QFSFeedTeamActivityView", 1, "isElementCanActivate style_type: " + this.f90602e.buttomBanner.style_type.get());
        if (this.f90602e.buttomBanner.style_type.get() != 6) {
            return false;
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 != R.id.f55232hc && id5 != R.id.f55172h7) {
            if (id5 == R.id.f55142h4) {
                R();
            }
        } else {
            O(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c, com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        F();
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        N(this.f90604h);
        View view = this.D;
        if (view == null || this.f90602e == null) {
            return;
        }
        view.setVisibility(0);
        Z(this.f90602e);
        Y(this.f90602e);
        this.S.setVisibility(0);
        this.L.setVisibility(8);
        this.E.setVisibility(0);
        this.F.setBackground(null);
        this.D.setBackgroundResource(R.drawable.l9s);
        W();
        F();
        n().postDelayed(this.T, 2000L);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        QLog.d("QFSFeedTeamActivityView", 1, "[onElementInactivated]");
        F();
        View view = this.D;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSSeekEvent) {
            G((QFSSeekEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QCircleConfigChangeEvent) {
            E();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void r() {
        F();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d implements Animation.AnimationListener {
        d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            ae.this.S();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class e implements Animation.AnimationListener {
        e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (ae.this.S != null && ae.this.E != null) {
                ae.this.S.setVisibility(4);
                ae.this.E.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class f implements Animation.AnimationListener {
        f() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            ae.this.U();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class g implements Animation.AnimationListener {
        g() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (ae.this.D != null && ae.this.F != null) {
                ae.this.F.setBackground(null);
                ae.this.D.setBackgroundResource(R.drawable.l9s);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (ae.this.S != null && ae.this.E != null) {
                ae.this.S.setVisibility(0);
                ae.this.E.setVisibility(0);
                VideoReport.traversePage(ae.this.E);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void q() {
    }
}
