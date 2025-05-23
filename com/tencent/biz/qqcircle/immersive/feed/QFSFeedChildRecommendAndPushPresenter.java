package com.tencent.biz.qqcircle.immersive.feed;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QFSQZoneVideoGuideAuthInfo;
import com.tencent.biz.qqcircle.bizparts.QCircleLightInteractListPart;
import com.tencent.biz.qqcircle.events.QCircleUndoPushUpdateEvent;
import com.tencent.biz.qqcircle.events.QFSPushParabolaAnimEvent;
import com.tencent.biz.qqcircle.events.QFSQZoneVideoWindowStatusSetSuccessEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSLikeStateChangeEvent;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarListView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StCommInfo;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StPushList;
import feedcloud.FeedCloudMeta$StUser;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleFeedBase$StFeedBusiReqData;

/* loaded from: classes4.dex */
public class QFSFeedChildRecommendAndPushPresenter extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements View.OnClickListener {

    /* renamed from: f0, reason: collision with root package name */
    private static final int f85177f0 = com.tencent.biz.qqcircle.utils.cx.a(192.0f);

    /* renamed from: g0, reason: collision with root package name */
    private static String f85178g0;
    private View I;
    private View J;
    private TextView K;
    private TextView L;
    private TextView M;
    private ImageView N;
    private QCircleAvatarListView P;
    private TextView Q;
    private TextView R;
    private ImageView S;
    private View T;
    private QCircleAvatarView U;
    private QCircleAvatarListView V;
    private TextView W;
    private TextView X;
    private ImageView Y;

    /* renamed from: b0, reason: collision with root package name */
    private Runnable f85180b0;

    /* renamed from: c0, reason: collision with root package name */
    private Runnable f85181c0;

    /* renamed from: d0, reason: collision with root package name */
    private QFSQZoneVideoGuideAuthInfo f85182d0;
    private final int[] Z = new int[2];

    /* renamed from: a0, reason: collision with root package name */
    private int f85179a0 = 0;

    /* renamed from: e0, reason: collision with root package name */
    private final Runnable f85183e0 = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.bf
        @Override // java.lang.Runnable
        public final void run() {
            QFSFeedChildRecommendAndPushPresenter.this.F2();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ PathMeasure f85186d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float[] f85187e;

        c(PathMeasure pathMeasure, float[] fArr) {
            this.f85186d = pathMeasure;
            this.f85187e = fArr;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f85186d.getPosTan(((Float) valueAnimator.getAnimatedValue()).floatValue(), this.f85187e, null);
            QFSFeedChildRecommendAndPushPresenter.this.U.setX(this.f85187e[0]);
            QFSFeedChildRecommendAndPushPresenter.this.U.setY(this.f85187e[1]);
        }
    }

    private void A2() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.U, BasicAnimation.KeyPath.SCALE_X, 0.0f, 1.5f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.U, BasicAnimation.KeyPath.SCALE_Y, 0.0f, 1.5f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.U, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f);
        ofFloat.setDuration(120L);
        ofFloat2.setDuration(120L);
        ofFloat3.setDuration(120L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        animatorSet.addListener(new d(animatorSet));
        animatorSet.start();
    }

    private void B2(int i3) {
        int J1 = J1(i3);
        if (this.f85180b0 == null) {
            this.f85180b0 = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildRecommendAndPushPresenter.1
                @Override // java.lang.Runnable
                public void run() {
                    QFSFeedChildRecommendAndPushPresenter.this.C2();
                }
            };
        }
        if (this.f85181c0 == null) {
            this.f85181c0 = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildRecommendAndPushPresenter.2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    QFSFeedChildRecommendAndPushPresenter qFSFeedChildRecommendAndPushPresenter = QFSFeedChildRecommendAndPushPresenter.this;
                    qFSFeedChildRecommendAndPushPresenter.d2((FeedCloudMeta$StFeed) qFSFeedChildRecommendAndPushPresenter.f85017h);
                }
            };
        }
        x0().removeCallbacks(this.f85180b0);
        x0().removeCallbacks(this.f85181c0);
        x0().postDelayed(this.f85180b0, J1);
        x0().postDelayed(this.f85181c0, J1 + 600);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C2() {
        j2();
        this.U.setX(this.Z[0] - (ImmersiveUtils.dpToPx(16.0f) / 2));
        this.U.setY(this.Z[1] - (ImmersiveUtils.dpToPx(16.0f) / 2));
        this.U.setVisibility(0);
        A2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D2(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        I1(this.I, QCircleDaTongConstant.ElementId.EM_XSJ_RECOM_REASON, R1(feedCloudMeta$StFeed));
    }

    private void E2() {
        this.E.o("key_has_show_recommend_add_friend_anim", Boolean.TRUE);
        if (uq3.n.e(uq3.k.a().f("key_last_show_add_friend_anim_time", 0L))) {
            uq3.k.a().m("key_show_add_friend_anim_count", uq3.k.a().e("key_show_add_friend_anim_count", 0) + 1);
        } else {
            uq3.k.a().m("key_show_add_friend_anim_count", 1);
        }
        uq3.k.a().n("key_last_show_add_friend_anim_time", System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F2() {
        E2();
        G2();
        H2();
    }

    private void G1() {
        int i3 = 0;
        this.V.measure(0, 0);
        float measureText = this.X.getPaint().measureText(this.X.getText().toString());
        if (this.Y.getVisibility() == 0) {
            i3 = com.tencent.biz.qqcircle.utils.cx.a(14.0f);
        }
        this.W.setMaxWidth((int) (((((ImmersiveUtils.getScreenWidth() * 0.54d) - com.tencent.biz.qqcircle.utils.cx.a(6.0f)) - measureText) - this.V.getMeasuredWidth()) - i3));
    }

    private void G2() {
        int width = this.J.getWidth();
        this.L.setVisibility(4);
        this.M.setVisibility(4);
        this.N.setVisibility(4);
        this.J.measure(0, 0);
        ValueAnimator ofInt = ValueAnimator.ofInt(width, this.J.getMeasuredWidth());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.bh
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                QFSFeedChildRecommendAndPushPresenter.this.p2(valueAnimator);
            }
        });
        ofInt.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
        ofInt.setDuration(240L);
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H1() {
        int i3 = 0;
        this.P.measure(0, 0);
        float measureText = this.Q.getPaint().measureText(this.Q.getText().toString());
        if (this.S.getVisibility() == 0) {
            i3 = com.tencent.biz.qqcircle.utils.cx.a(14.0f);
        }
        this.R.setMaxWidth((int) (((((ImmersiveUtils.getScreenWidth() * 0.54d) - com.tencent.biz.qqcircle.utils.cx.a(6.0f)) - measureText) - this.P.getMeasuredWidth()) - i3));
    }

    private void H2() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addListener(new a());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.bg
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                QFSFeedChildRecommendAndPushPresenter.this.q2(valueAnimator);
            }
        });
        ofFloat.setDuration(120L);
        ofFloat.setStartDelay(120L);
        ofFloat.start();
    }

    private void I1(View view, String str, Map<String, Object> map) {
        String str2;
        e30.b bVar = this.E;
        if (bVar != null && bVar.g() != null && view != null && !TextUtils.isEmpty(str)) {
            VideoReport.setElementId(view, str);
            HashMap hashMap = new HashMap();
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(this.f85018i + 1));
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_MUSIC_TYPE, Integer.valueOf(this.E.g().musicInfo.scene.get()));
            if (map != null && map.size() > 0) {
                hashMap.putAll(map);
            }
            if (this.E.g().opMask2.get() != null) {
                if (this.E.g().opMask2.get().contains(40)) {
                    str2 = "original";
                } else {
                    str2 = WinkDaTongReportConstant.ElementParamValue.REPRINT;
                }
                hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_FEED_LABEL_NAME, str2);
            }
            VideoReport.setElementReuseIdentifier(view, str + this.E.g().f398449id.get());
            VideoReport.setElementParams(view, hashMap);
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        }
    }

    private void I2(FeedCloudMeta$StPushList feedCloudMeta$StPushList) {
        l2();
        View view = this.I;
        if (view == null) {
            return;
        }
        view.setVisibility(0);
        this.P.setVisibility(0);
        this.R.setVisibility(0);
        this.Q.setVisibility(0);
        this.S.setVisibility(0);
        this.J.setVisibility(8);
        this.P.setData(com.tencent.biz.qqcircle.utils.o.c(feedCloudMeta$StPushList.vecUser.get(), 3));
        this.R.setText(com.tencent.biz.qqcircle.utils.o.b(feedCloudMeta$StPushList.vecUser.get(), 3));
        this.Q.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f1903841y));
    }

    private int J1(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 5) {
                        if (i3 != 6) {
                            return 0;
                        }
                        return 1000;
                    }
                    return 600;
                }
                return 1400;
            }
            return 720;
        }
        return 400;
    }

    private void J2(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        l2();
        if (this.I == null) {
            return;
        }
        D2(feedCloudMeta$StFeed);
        this.I.setVisibility(0);
        this.Q.setVisibility(8);
        this.P.setVisibility(8);
        this.R.setVisibility(8);
        this.S.setVisibility(8);
        this.J.setVisibility(0);
        this.K.setMaxWidth(Integer.MAX_VALUE);
        this.L.setVisibility(8);
        this.M.setVisibility(8);
        this.N.setVisibility(0);
        QFSQZoneVideoGuideAuthInfo P1 = P1();
        this.f85182d0 = P1;
        this.K.setText(P1.getBannerTxt());
        com.tencent.biz.qqcircle.widgets.dialog.f.j0(this.f85182d0.getPicUrl());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private e30.b K1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        MutableLiveData globalData;
        if (feedCloudMeta$StFeed == null || (globalData = w20.a.j().getGlobalData(e30.b.class, feedCloudMeta$StFeed.f398449id.get())) == null) {
            return null;
        }
        if (globalData.getValue() == 0) {
            return this.E;
        }
        return (e30.b) globalData.getValue();
    }

    private void K2(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        l2();
        View view = this.I;
        if (view == null) {
            return;
        }
        int i3 = 0;
        view.setVisibility(0);
        D2(feedCloudMeta$StFeed);
        if (g2(feedCloudMeta$StFeed)) {
            U1(feedCloudMeta$StFeed);
            return;
        }
        if (com.tencent.biz.qqcircle.immersive.utils.r.X(this.E)) {
            this.Q.setVisibility(8);
            this.P.setVisibility(8);
            this.R.setVisibility(8);
            this.S.setVisibility(8);
            this.J.setVisibility(0);
            this.K.setMaxWidth(f85177f0);
            this.L.setVisibility(0);
            this.M.setVisibility(0);
            this.N.setVisibility(0);
            this.K.setText(Q1(feedCloudMeta$StFeed));
            return;
        }
        if (feedCloudMeta$StFeed.recomInfo.recomReasonV2.recomUserInfo.size() == 0) {
            this.Q.setVisibility(8);
            this.P.setVisibility(8);
            this.R.setVisibility(8);
            this.S.setVisibility(8);
            this.J.setVisibility(0);
            this.K.setMaxWidth(f85177f0);
            this.L.setVisibility(8);
            this.M.setVisibility(8);
            this.N.setVisibility(8);
            this.K.setText(Q1(feedCloudMeta$StFeed));
            return;
        }
        this.Q.setVisibility(0);
        this.P.setVisibility(0);
        this.R.setVisibility(0);
        ImageView imageView = this.S;
        if (!n2(feedCloudMeta$StFeed) && !o2(feedCloudMeta$StFeed) && !h2(feedCloudMeta$StFeed)) {
            i3 = 8;
        }
        imageView.setVisibility(i3);
        this.J.setVisibility(8);
        this.P.setData(com.tencent.biz.qqcircle.utils.o.c(feedCloudMeta$StFeed.recomInfo.recomReasonV2.recomUserInfo.get(), 3));
        this.Q.setText(Q1(feedCloudMeta$StFeed));
        this.R.setText(com.tencent.biz.qqcircle.utils.o.b(feedCloudMeta$StFeed.recomInfo.recomReasonV2.recomUserInfo.get(), 3));
        H1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String L1() {
        FeedCloudMeta$StUser m3 = QCirclePluginGlobalInfo.m();
        if (m3 == null) {
            return HostDataTransUtils.getAccount();
        }
        if (TextUtils.isEmpty(m3.icon.iconUrl.get())) {
            return m3.f398463id.get();
        }
        return m3.icon.iconUrl.get();
    }

    private void L2(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        boolean u26 = u2(feedCloudMeta$StFeed);
        boolean r26 = r2(feedCloudMeta$StFeed);
        boolean s26 = s2(feedCloudMeta$StFeed);
        QLog.d("QFSFeedChildRecommendAndPushPresenter", 1, "[updatePushReasonView] needShowRecommendReason : " + u26 + ", needShowPushList : " + r26 + ", needShowQZoneVideoGuideAuthBanner : " + s26);
        if (s26) {
            J2(feedCloudMeta$StFeed);
            return;
        }
        if (u26) {
            K2(feedCloudMeta$StFeed);
        } else if (r26) {
            I2(N1(feedCloudMeta$StFeed));
        } else {
            i2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String M1(int i3) {
        if (i3 == 0) {
            return com.tencent.biz.qqcircle.utils.h.a(R.string.f1903841y);
        }
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f1903841y) + i3 + com.tencent.biz.qqcircle.utils.h.a(R.string.f194244bd);
    }

    @NonNull
    private FeedCloudMeta$StPushList N1(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StPushList f16 = QCirclePushInfoManager.e().f(feedCloudMeta$StFeed.f398449id.get());
        if (f16 != null && f16.has()) {
            return f16;
        }
        QQCircleFeedBase$StFeedBusiReqData busiData = QCirclePluginUtil.getBusiData(this.E);
        QCirclePushInfoManager.e().p(feedCloudMeta$StFeed.f398449id.get(), busiData.pushList.get());
        return busiData.pushList.get();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String O1() {
        T t16;
        if (com.tencent.biz.qqcircle.l.b() && (t16 = this.f85017h) != 0) {
            int i3 = N1((FeedCloudMeta$StFeed) t16).hasClickCount.get();
            if (i3 == 0) {
                return com.tencent.biz.qqcircle.utils.h.a(R.string.f1903841y);
            }
            return M1(i3);
        }
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f1903841y);
    }

    private QFSQZoneVideoGuideAuthInfo P1() {
        HashMap hashMap = new HashMap();
        hashMap.put("qfs_qzone_feed_auth_dialog_pic", "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/shipinyitihua/qvideo_skin_shiping_changjing.png");
        hashMap.put("qfs_qzone_feed_auth_dialog_auth", "\u7acb\u5373\u5f00\u542f");
        hashMap.put("qfs_qzone_feed_auth_banner_txt", "\u89c6\u9891\u53d1\u8868\u81ea\u7a7a\u95f4\uff0c\u514d\u8d39\u5f00\u542f\u76f8\u540c\u529f\u80fd");
        hashMap.put("qfs_qzone_feed_auth_dialog_success_toast", "\u5df2\u66f4\u65b0QQ\u77ed\u89c6\u9891\u53d1\u8868\u80fd\u529b");
        Map<String, String> M = uq3.o.M("101829", hashMap);
        return new QFSQZoneVideoGuideAuthInfo(QCircleSkinHelper.getInstance().getUrl(M.get("qfs_qzone_feed_auth_dialog_pic")), M.get("qfs_qzone_feed_auth_dialog_auth"), M.get("qfs_qzone_feed_auth_banner_txt"), M.get("qfs_qzone_feed_auth_dialog_success_toast"));
    }

    private String Q1(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        int size;
        String str = feedCloudMeta$StFeed.recomInfo.recomReasonV2.recomReason.get();
        if (TextUtils.equals(str, com.tencent.biz.qqcircle.utils.h.a(R.string.f19306497)) && (size = feedCloudMeta$StFeed.recomInfo.recomReasonV2.recomUserInfo.size()) >= 3) {
            return com.tencent.biz.qqcircle.utils.h.a(R.string.f1903941z) + size + com.tencent.biz.qqcircle.utils.h.a(R.string.f19040420) + str;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public Map<String, Object> R1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_RECOM_SHOW_STYLE, Integer.valueOf(com.tencent.biz.qqcircle.immersive.utils.r.E(this.E)));
        if (s2(feedCloudMeta$StFeed)) {
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_SCENE, QCircleDaTongConstant.ElementParamValue.VIDEO_UNITE);
            FeedCloudMeta$StUser feedCloudMeta$StUser = feedCloudMeta$StFeed.poster;
            if (feedCloudMeta$StUser != null) {
                hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_QQ_FRI, Integer.valueOf(QCirclePluginUtil.isFriend(feedCloudMeta$StUser.f398463id.get()) ? 1 : 0));
            }
        }
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSI_RECOM_REASON_TYPE, Integer.valueOf(feedCloudMeta$StFeed.recomInfo.recomReasonType.get()));
        return hashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void S1(long j3) {
        if (t2((FeedCloudMeta$StFeed) this.f85017h)) {
            x0().removeCallbacks(this.f85183e0);
            x0().postDelayed(this.f85183e0, j3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void T1() {
        if (this.f85017h == 0) {
            return;
        }
        QCircleHostLauncher.startAddFriend(m0(), 5, ((FeedCloudMeta$StFeed) this.f85017h).poster.f398463id.get(), ((FeedCloudMeta$StFeed) this.f85017h).poster.nick.get(), false, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void U1(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.Q.setVisibility(0);
        this.P.setVisibility(0);
        this.R.setVisibility(0);
        this.S.setVisibility(0);
        this.J.setVisibility(8);
        if (!n2(feedCloudMeta$StFeed)) {
            this.P.setData(Collections.singletonList(L1()));
        } else {
            List<String> c16 = com.tencent.biz.qqcircle.utils.o.c(((FeedCloudMeta$StFeed) this.f85017h).recomInfo.recomReasonV2.recomUserInfo.get(), 3);
            if (c16.size() >= 3) {
                c16.add(2, L1());
            } else {
                c16.add(L1());
            }
            this.P.setData(c16);
        }
        this.R.setText(uq3.c.F2());
        this.Q.setText(O1());
        H1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void V1(@NonNull QFSLikeStateChangeEvent qFSLikeStateChangeEvent) {
        if (qFSLikeStateChangeEvent.getIsLike() && this.f85017h != 0 && TextUtils.equals(qFSLikeStateChangeEvent.getFeedId(), ((FeedCloudMeta$StFeed) this.f85017h).f398449id.get())) {
            S1(400L);
        }
    }

    private void W1(View view) {
        if (view == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        ofFloat.setDuration(120L);
        ofFloat.addListener(new f(view));
        ofFloat.start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void X1(@NonNull QFSPushParabolaAnimEvent qFSPushParabolaAnimEvent) {
        e30.b K1;
        if (this.f85017h == 0 || !TextUtils.equals(qFSPushParabolaAnimEvent.getTargetFeedId(), ((FeedCloudMeta$StFeed) this.f85017h).f398449id.get())) {
            return;
        }
        if (!HostNetworkUtils.isNetworkAvailable()) {
            QLog.d(getTAG(), 1, "handlePushAnimationEvent net error.");
            return;
        }
        if (s2((FeedCloudMeta$StFeed) this.f85017h)) {
            QLog.d(getTAG(), 1, "handlePushAnimationEvent need show qzone video guide auth banner");
            return;
        }
        if ((g2((FeedCloudMeta$StFeed) this.f85017h) && !com.tencent.biz.qqcircle.l.b()) || (K1 = K1((FeedCloudMeta$StFeed) this.f85017h)) == null) {
            return;
        }
        K1.o("recommend_reason_has_faked", Boolean.TRUE);
        this.Z[0] = qFSPushParabolaAnimEvent.getPushIconLocation()[0];
        this.Z[1] = qFSPushParabolaAnimEvent.getPushIconLocation()[1];
        this.f85179a0 = qFSPushParabolaAnimEvent.getHasPushCount();
        B2(qFSPushParabolaAnimEvent.getPushType());
    }

    private void Z1() {
        k2();
        View view = this.T;
        if (view == null) {
            return;
        }
        view.setVisibility(0);
        this.V.setData(Collections.singletonList(L1()));
        this.W.setText(uq3.c.F2());
        this.X.setText(M1(this.f85179a0));
        G1();
        this.W.setAlpha(0.0f);
        this.X.setAlpha(0.0f);
        this.Y.setAlpha(0.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.V, BasicAnimation.KeyPath.SCALE_X, 0.0f, 1.4f, 1.0f);
        ofFloat.setDuration(480L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.V, BasicAnimation.KeyPath.SCALE_Y, 0.0f, 1.4f, 1.0f);
        ofFloat2.setDuration(480L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.W, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ofFloat3.setDuration(120L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.X, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ofFloat4.setDuration(120L);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.Y, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ofFloat5.setDuration(120L);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.W, "translationX", -com.tencent.biz.qqcircle.utils.cx.a(12.0f), com.tencent.biz.qqcircle.utils.cx.a(6.0f), 0.0f);
        ofFloat6.setDuration(480L);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.X, "translationX", -com.tencent.biz.qqcircle.utils.cx.a(12.0f), com.tencent.biz.qqcircle.utils.cx.a(6.0f), 0.0f);
        ofFloat7.setDuration(480L);
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.Y, "translationX", -com.tencent.biz.qqcircle.utils.cx.a(12.0f), com.tencent.biz.qqcircle.utils.cx.a(6.0f), 0.0f);
        ofFloat8.setDuration(480L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new b());
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat6).with(ofFloat7).with(ofFloat8);
        animatorSet.play(ofFloat3).with(ofFloat4).with(ofFloat5).after(120L);
        animatorSet.start();
    }

    private void a2() {
        k2();
        l2();
        View view = this.T;
        if (view != null && this.I != null) {
            view.setVisibility(0);
            ((LinearLayout.LayoutParams) this.V.getLayoutParams()).leftMargin = this.P.getWidth() - com.tencent.biz.qqcircle.utils.cx.a(8.5f);
            this.V.setData(Collections.singletonList(L1()));
            this.W.setText(uq3.c.F2());
            this.X.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f1903841y));
            G1();
            this.W.setAlpha(0.0f);
            this.X.setAlpha(0.0f);
            this.Y.setAlpha(0.0f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.V, BasicAnimation.KeyPath.SCALE_X, 0.0f, 1.4f, 1.0f);
            ofFloat.setDuration(480L);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.V, BasicAnimation.KeyPath.SCALE_Y, 0.0f, 1.4f, 1.0f);
            ofFloat2.setDuration(480L);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.W, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
            ofFloat3.setDuration(200L);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.X, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
            ofFloat4.setDuration(200L);
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.Y, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
            ofFloat5.setDuration(200L);
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.W, "translationX", -com.tencent.biz.qqcircle.utils.cx.a(12.0f), com.tencent.biz.qqcircle.utils.cx.a(6.0f), 0.0f);
            ofFloat6.setDuration(480L);
            ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.X, "translationX", -com.tencent.biz.qqcircle.utils.cx.a(12.0f), com.tencent.biz.qqcircle.utils.cx.a(6.0f), 0.0f);
            ofFloat7.setDuration(480L);
            ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.Y, "translationX", -com.tencent.biz.qqcircle.utils.cx.a(12.0f), com.tencent.biz.qqcircle.utils.cx.a(6.0f), 0.0f);
            ofFloat8.setDuration(480L);
            ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.R, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
            ofFloat9.setDuration(120L);
            ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.Q, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
            ofFloat10.setDuration(120L);
            ObjectAnimator ofFloat11 = ObjectAnimator.ofFloat(this.S, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
            ofFloat11.setDuration(120L);
            ObjectAnimator ofFloat12 = ObjectAnimator.ofFloat(this.R, "translationX", 0.0f, com.tencent.biz.qqcircle.utils.cx.a(18.0f), com.tencent.biz.qqcircle.utils.cx.a(12.0f));
            ofFloat12.setDuration(480L);
            ObjectAnimator ofFloat13 = ObjectAnimator.ofFloat(this.Q, "translationX", 0.0f, com.tencent.biz.qqcircle.utils.cx.a(18.0f), com.tencent.biz.qqcircle.utils.cx.a(12.0f));
            ofFloat13.setDuration(480L);
            ObjectAnimator ofFloat14 = ObjectAnimator.ofFloat(this.S, "translationX", 0.0f, com.tencent.biz.qqcircle.utils.cx.a(18.0f), com.tencent.biz.qqcircle.utils.cx.a(12.0f));
            ofFloat14.setDuration(480L);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new e());
            animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat6).with(ofFloat7).with(ofFloat8).with(ofFloat12).with(ofFloat13).with(ofFloat14);
            animatorSet.play(ofFloat3).with(ofFloat4).with(ofFloat5).with(ofFloat9).with(ofFloat10).with(ofFloat11).after(120L);
            animatorSet.start();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void c2() {
        f85178g0 = com.tencent.biz.qqcircle.immersive.utils.r.q() + "_1";
        QLog.d(getTAG(), 1, "[handleQZoneVideoWindowStatusSetSuccessEvent] sHasAuthQZoneVideo = " + f85178g0);
        T t16 = this.f85017h;
        if (t16 != 0) {
            L2((FeedCloudMeta$StFeed) t16);
        } else {
            i2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d2(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        boolean r26 = r2(feedCloudMeta$StFeed);
        boolean u26 = u2(feedCloudMeta$StFeed);
        QLog.d("QFSFeedChildRecommendAndPushPresenter", 1, "[handleRecommendReasonAnimation] needShowPushList : " + r26 + "needShowRecommendReason : " + u26);
        if (!r26 && !u26) {
            Z1();
            return;
        }
        if (u26 && n2(feedCloudMeta$StFeed)) {
            a2();
            return;
        }
        if (r26) {
            Z1();
            W1(this.I);
        } else if (u26) {
            Z1();
            W1(this.I);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void e2() {
        T t16 = this.f85017h;
        if (t16 == 0) {
            return;
        }
        boolean n26 = n2((FeedCloudMeta$StFeed) t16);
        String str = ((FeedCloudMeta$StFeed) this.f85017h).recomInfo.recomReasonV2.recomSchema.get();
        boolean r26 = r2((FeedCloudMeta$StFeed) this.f85017h);
        boolean g26 = g2((FeedCloudMeta$StFeed) this.f85017h);
        boolean s26 = s2((FeedCloudMeta$StFeed) this.f85017h);
        boolean o26 = o2((FeedCloudMeta$StFeed) this.f85017h);
        QLog.d("QFSFeedChildRecommendAndPushPresenter", 1, "[handleRecommendWrapperClick] pushType : " + n26 + " schema: " + str + "needShowPushList : " + r26 + ", hasFaked : " + g26 + ", needShowQZoneVideoGuideAuthBanner : " + s26);
        if (s26) {
            x2();
            return;
        }
        if (!n26 && !r26 && !g26) {
            if (com.tencent.biz.qqcircle.immersive.utils.r.X(this.E)) {
                T1();
                return;
            } else if (h2((FeedCloudMeta$StFeed) this.f85017h)) {
                QCircleSchemeLauncher.d(m0(), ((FeedCloudMeta$StFeed) this.f85017h).recomInfo.recomReasonV2.recomSchema.get());
                return;
            } else {
                if (o26) {
                    w2(10);
                    return;
                }
                return;
            }
        }
        w2(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void f2(QCircleUndoPushUpdateEvent qCircleUndoPushUpdateEvent) {
        e30.b K1;
        T t16 = this.f85017h;
        if (t16 == 0 || !TextUtils.equals(qCircleUndoPushUpdateEvent.mTargetFeedId, ((FeedCloudMeta$StFeed) t16).f398449id.get()) || (K1 = K1((FeedCloudMeta$StFeed) this.f85017h)) == null) {
            return;
        }
        K1.o("recommend_reason_has_faked", Boolean.FALSE);
        L2((FeedCloudMeta$StFeed) this.f85017h);
    }

    private boolean g2(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        e30.b K1 = K1(feedCloudMeta$StFeed);
        if (K1 == null) {
            return false;
        }
        Object b16 = K1.b("recommend_reason_has_faked");
        if (!(b16 instanceof Boolean)) {
            return false;
        }
        return ((Boolean) b16).booleanValue();
    }

    private boolean h2(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        return !TextUtils.isEmpty(feedCloudMeta$StFeed.recomInfo.recomReasonV2.recomSchema.get());
    }

    private void i2() {
        View view = this.I;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    private void j2() {
        if (this.U != null) {
            return;
        }
        this.U = (QCircleAvatarView) ((ViewStub) this.C.findViewById(R.id.f41071g3)).inflate().findViewById(R.id.f41061g2);
        this.U.setUser(QCirclePluginGlobalInfo.m(), com.tencent.biz.qqcircle.immersive.utils.n.a(m0(), R.dimen.d4g));
    }

    private void k2() {
        if (this.T != null) {
            return;
        }
        View inflate = ((ViewStub) this.C.findViewById(R.id.f41171gc)).inflate();
        this.T = inflate;
        this.V = (QCircleAvatarListView) inflate.findViewById(R.id.f39181az);
        this.W = (TextView) this.T.findViewById(R.id.f39201b1);
        this.X = (TextView) this.T.findViewById(R.id.f39191b0);
        this.Y = (ImageView) this.T.findViewById(R.id.f39171ay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l2() {
        if (this.I != null) {
            return;
        }
        View inflate = ((ViewStub) this.C.findViewById(R.id.f41281gn)).inflate();
        this.I = inflate;
        inflate.setOnClickListener(this);
        this.J = this.I.findViewById(R.id.f41271gm);
        this.K = (TextView) this.I.findViewById(R.id.f41251gk);
        this.L = (TextView) this.I.findViewById(R.id.f41161gb);
        this.M = (TextView) this.I.findViewById(R.id.f41151ga);
        this.N = (ImageView) this.I.findViewById(R.id.f41261gl);
        this.P = (QCircleAvatarListView) this.I.findViewById(R.id.f41191ge);
        this.Q = (TextView) this.I.findViewById(R.id.f41221gh);
        this.R = (TextView) this.I.findViewById(R.id.f41241gj);
        this.S = (ImageView) this.I.findViewById(R.id.f41181gd);
    }

    private boolean m2(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null || !QCirclePluginUtil.isOwner(feedCloudMeta$StFeed.poster.f398463id.get()) || !QCircleDaTongConstant.PageId.PG_XSJ_LAYER_PAGE.equals(r0())) {
            return false;
        }
        return true;
    }

    private boolean n2(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed.recomInfo.recomReasonTypeForClinet.get() == 1 && feedCloudMeta$StFeed.recomInfo.recomReasonV2.recomUserInfo.size() > 0) {
            return true;
        }
        return false;
    }

    private boolean o2(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed.recomInfo.recomReasonTypeForClinet.get() == 4 && feedCloudMeta$StFeed.recomInfo.recomReasonV2.recomUserInfo.size() > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p2(ValueAnimator valueAnimator) {
        ViewGroup.LayoutParams layoutParams = this.J.getLayoutParams();
        layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.J.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q2(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.L.setAlpha(floatValue);
        this.M.setAlpha(floatValue);
        this.N.setAlpha(floatValue);
    }

    private boolean r2(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StPushList N1 = N1(feedCloudMeta$StFeed);
        if (!u2(feedCloudMeta$StFeed) && !m2(feedCloudMeta$StFeed) && !c40.d.g(this.E) && N1.count.get() > 0 && N1.vecUser.size() > 0) {
            return true;
        }
        return false;
    }

    private boolean s2(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StCommInfo feedCloudMeta$StCommInfo = feedCloudMeta$StFeed.commonInfo;
        if (feedCloudMeta$StCommInfo != null && feedCloudMeta$StCommInfo.show_qzone_auth_banner.get()) {
            if (!TextUtils.equals(f85178g0, com.tencent.biz.qqcircle.immersive.utils.r.q() + "_1")) {
                return true;
            }
        }
        return false;
    }

    private boolean t2(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return false;
        }
        QLog.d("QFSFeedChildRecommendAndPushPresenter", 1, "[needShowRecommendAddFriendAnim] recomReasonTypeForClinet:" + feedCloudMeta$StFeed.recomInfo.recomReasonTypeForClinet.get());
        if (feedCloudMeta$StFeed.recomInfo.recomReasonTypeForClinet.get() != 2 || !u2(feedCloudMeta$StFeed) || com.tencent.biz.qqcircle.immersive.utils.r.X(this.E)) {
            return false;
        }
        if (uq3.n.e(uq3.k.a().f("key_last_show_add_friend_anim_time", 0L)) && uq3.k.a().e("key_show_add_friend_anim_count", 0) >= 3) {
            return false;
        }
        return true;
    }

    private boolean u2(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (TextUtils.isEmpty(feedCloudMeta$StFeed.recomInfo.recomReasonV2.recomReason.get()) && feedCloudMeta$StFeed.recomInfo.recomReasonV2.recomUserInfo.size() == 0 && !g2(feedCloudMeta$StFeed)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void w2(int i3) {
        if (s0() == null) {
            QLog.d("QFSFeedChildRecommendAndPushPresenter", 1, "[openSharePanel] feed ioc should not be null.");
            return;
        }
        QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(ua0.c.a((FeedCloudMeta$StFeed) this.f85017h).setActionType(43).setSubActionType(2).setIndex(this.f85018i).setPageId(y0())));
        QCircleLightInteractListPart.g gVar = new QCircleLightInteractListPart.g();
        gVar.f82701a = this.E;
        gVar.f82702b = (FeedCloudMeta$StFeed) this.f85017h;
        gVar.f82704d = this.f85018i;
        gVar.f82705e = i3;
        s0().onHandlerMessage("event_open_friend_push_panel", gVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void x2() {
        if (this.f85182d0 == null) {
            QLog.e(getTAG(), 1, "[openQZoneVideoAuthGuideDialog] mQZoneAuthInfo == null");
        } else {
            new com.tencent.biz.qqcircle.widgets.dialog.f(m0(), this.I, this.f85182d0, (FeedCloudMeta$StFeed) this.f85017h).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y2() {
        int[] iArr = {this.Z[0] - (ImmersiveUtils.dpToPx(16.0f) / 2), this.Z[1] - (ImmersiveUtils.dpToPx(16.0f) / 2)};
        int screenHeight = ImmersiveUtils.getScreenHeight() - ImmersiveUtils.dpToPx(238.0f);
        int[] iArr2 = {ImmersiveUtils.dpToPx(32.0f), screenHeight};
        int[] iArr3 = {(iArr2[0] + iArr[0]) / 2, screenHeight - (iArr[0] - iArr2[0])};
        Path path = new Path();
        path.moveTo(iArr[0], iArr[1]);
        path.quadTo(iArr3[0], iArr3[1], iArr2[0], iArr2[1]);
        PathMeasure pathMeasure = new PathMeasure();
        pathMeasure.setPath(path, false);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, pathMeasure.getLength());
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(640L);
        ofFloat.addUpdateListener(new c(pathMeasure, new float[2]));
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z2() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.U, BasicAnimation.KeyPath.SCALE_X, 1.5f, 1.8f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.U, BasicAnimation.KeyPath.SCALE_Y, 1.5f, 1.8f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.U, BasicAnimation.KeyPath.SCALE_X, 1.8f, 0.8f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.U, BasicAnimation.KeyPath.SCALE_Y, 1.8f, 0.8f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.U, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        ofFloat.setDuration(320L);
        ofFloat2.setDuration(320L);
        ofFloat3.setDuration(240L);
        ofFloat4.setDuration(240L);
        ofFloat5.setDuration(120L);
        ofFloat3.setStartDelay(320L);
        ofFloat4.setStartDelay(320L);
        ofFloat5.setStartDelay(520L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5);
        animatorSet.start();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QFSPushParabolaAnimEvent.class);
        eventClass.add(QCircleUndoPushUpdateEvent.class);
        eventClass.add(QFSQZoneVideoWindowStatusSetSuccessEvent.class);
        eventClass.add(QFSLikeStateChangeEvent.class);
        return eventClass;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f41291go) {
            e2();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        T t16 = this.f85017h;
        if (t16 == 0) {
            QLog.d("QFSFeedChildRecommendAndPushPresenter", 1, "[onFeedSelected] mData == null");
        } else {
            L2((FeedCloudMeta$StFeed) t16);
            S1(3000L);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedUnSelected(rFWFeedSelectInfo);
        if (this.f85180b0 != null) {
            x0().removeCallbacks(this.f85180b0);
        }
        if (this.f85181c0 != null) {
            x0().removeCallbacks(this.f85181c0);
        }
        x0().removeCallbacks(this.f85183e0);
        this.f85179a0 = 0;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        QLog.d("QFSFeedChildRecommendAndPushPresenter", 1, "[onReceiveEvent] feed ioc should not be null." + simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSPushParabolaAnimEvent) {
            X1((QFSPushParabolaAnimEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QCircleUndoPushUpdateEvent) {
            f2((QCircleUndoPushUpdateEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSQZoneVideoWindowStatusSetSuccessEvent) {
            c2();
        } else if (simpleBaseEvent instanceof QFSLikeStateChangeEvent) {
            V1((QFSLikeStateChangeEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: v2, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        if (feedCloudMeta$StFeed == null) {
            QLog.d("QFSFeedChildRecommendAndPushPresenter", 1, "[onBindData] data should not be null.");
            return;
        }
        QLog.d("QFSFeedChildRecommendAndPushPresenter", 1, "[onBindData] recomReasonTypeForClinet:" + feedCloudMeta$StFeed.recomInfo.recomReasonTypeForClinet.get() + " schema:" + feedCloudMeta$StFeed.recomInfo.recomReasonV2.recomSchema.get());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildRecommendAndPushPresenter";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements Animator.AnimatorListener {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ViewGroup.LayoutParams layoutParams = QFSFeedChildRecommendAndPushPresenter.this.J.getLayoutParams();
            layoutParams.width = -2;
            QFSFeedChildRecommendAndPushPresenter.this.J.setLayoutParams(layoutParams);
            QFSFeedChildRecommendAndPushPresenter qFSFeedChildRecommendAndPushPresenter = QFSFeedChildRecommendAndPushPresenter.this;
            qFSFeedChildRecommendAndPushPresenter.D2((FeedCloudMeta$StFeed) qFSFeedChildRecommendAndPushPresenter.f85017h);
            View view = QFSFeedChildRecommendAndPushPresenter.this.I;
            QFSFeedChildRecommendAndPushPresenter qFSFeedChildRecommendAndPushPresenter2 = QFSFeedChildRecommendAndPushPresenter.this;
            VideoReport.reportEvent("imp", view, qFSFeedChildRecommendAndPushPresenter2.R1((FeedCloudMeta$StFeed) qFSFeedChildRecommendAndPushPresenter2.f85017h));
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QFSFeedChildRecommendAndPushPresenter.this.L.setVisibility(0);
            QFSFeedChildRecommendAndPushPresenter.this.M.setVisibility(0);
            QFSFeedChildRecommendAndPushPresenter.this.N.setVisibility(0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QFSFeedChildRecommendAndPushPresenter.this.l2();
            if (QFSFeedChildRecommendAndPushPresenter.this.I == null) {
                return;
            }
            QFSFeedChildRecommendAndPushPresenter.this.T.setVisibility(8);
            QFSFeedChildRecommendAndPushPresenter.this.I.setVisibility(0);
            QFSFeedChildRecommendAndPushPresenter.this.J.setVisibility(8);
            QFSFeedChildRecommendAndPushPresenter.this.Q.setVisibility(0);
            QFSFeedChildRecommendAndPushPresenter.this.P.setVisibility(0);
            QFSFeedChildRecommendAndPushPresenter.this.R.setVisibility(0);
            QFSFeedChildRecommendAndPushPresenter.this.S.setVisibility(0);
            QFSFeedChildRecommendAndPushPresenter.this.P.setData(Collections.singletonList(QFSFeedChildRecommendAndPushPresenter.this.L1()));
            QFSFeedChildRecommendAndPushPresenter.this.R.setText(uq3.c.F2());
            TextView textView = QFSFeedChildRecommendAndPushPresenter.this.Q;
            QFSFeedChildRecommendAndPushPresenter qFSFeedChildRecommendAndPushPresenter = QFSFeedChildRecommendAndPushPresenter.this;
            textView.setText(qFSFeedChildRecommendAndPushPresenter.M1(qFSFeedChildRecommendAndPushPresenter.f85179a0));
            QFSFeedChildRecommendAndPushPresenter.this.H1();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AnimatorSet f85189d;

        d(AnimatorSet animatorSet) {
            this.f85189d = animatorSet;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QFSFeedChildRecommendAndPushPresenter.this.y2();
            QFSFeedChildRecommendAndPushPresenter.this.z2();
            AnimatorSet animatorSet = this.f85189d;
            if (animatorSet != null) {
                animatorSet.removeAllListeners();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e implements Animator.AnimatorListener {
        e() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QFSFeedChildRecommendAndPushPresenter qFSFeedChildRecommendAndPushPresenter = QFSFeedChildRecommendAndPushPresenter.this;
            if (qFSFeedChildRecommendAndPushPresenter.f85017h == 0) {
                return;
            }
            qFSFeedChildRecommendAndPushPresenter.T.setVisibility(8);
            ((LinearLayout.LayoutParams) QFSFeedChildRecommendAndPushPresenter.this.V.getLayoutParams()).leftMargin = 0;
            QFSFeedChildRecommendAndPushPresenter.this.R.setAlpha(1.0f);
            QFSFeedChildRecommendAndPushPresenter.this.Q.setAlpha(1.0f);
            QFSFeedChildRecommendAndPushPresenter.this.S.setAlpha(1.0f);
            QFSFeedChildRecommendAndPushPresenter.this.R.setTranslationX(0.0f);
            QFSFeedChildRecommendAndPushPresenter.this.Q.setTranslationX(0.0f);
            QFSFeedChildRecommendAndPushPresenter.this.S.setTranslationX(0.0f);
            List<String> c16 = com.tencent.biz.qqcircle.utils.o.c(((FeedCloudMeta$StFeed) QFSFeedChildRecommendAndPushPresenter.this.f85017h).recomInfo.recomReasonV2.recomUserInfo.get(), 3);
            if (c16.size() >= 3) {
                c16.add(2, QFSFeedChildRecommendAndPushPresenter.this.L1());
            } else {
                c16.add(QFSFeedChildRecommendAndPushPresenter.this.L1());
            }
            QFSFeedChildRecommendAndPushPresenter.this.P.setData(c16);
            QFSFeedChildRecommendAndPushPresenter.this.R.setText(uq3.c.F2());
            QFSFeedChildRecommendAndPushPresenter.this.Q.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f1903841y));
            QFSFeedChildRecommendAndPushPresenter.this.H1();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class f implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f85192d;

        f(View view) {
            this.f85192d = view;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            View view = this.f85192d;
            if (view != null) {
                view.setAlpha(1.0f);
                this.f85192d.setVisibility(8);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
