package com.tencent.biz.qqcircle.immersive.views.banner.bottom;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QFSFeedCommentInfo;
import com.tencent.biz.qqcircle.events.QFSAddFakeCommentOrReplyEvent;
import com.tencent.biz.qqcircle.immersive.views.banner.g;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.biz.qqcircle.utils.QFSFriendCommentGuideUtil;
import com.tencent.biz.qqcircle.utils.bg;
import com.tencent.biz.qqcircle.utils.bh;
import com.tencent.biz.qqcircle.utils.cu;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.tav.core.ExportErrorStatus;
import com.tencent.view.FilterEnum;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StReply;
import feedcloud.FeedCloudMeta$StUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFeedFriendCommentGuideView extends com.tencent.biz.qqcircle.immersive.views.banner.bottom.c implements View.OnClickListener {
    private static final int[][] N = {new int[]{-223, -252, 56}, new int[]{67, ExportErrorStatus.STOP_AUDIO_ENCODE, 56}, new int[]{66, -322, 48}, new int[]{308, -145, 48}, new int[]{-84, -215, 50}, new int[]{-142, -429, 56}, new int[]{369, -321, 48}, new int[]{229, -226, 56}};
    private FrameLayout D;
    private FrameLayout E;
    private ImageView F;
    private TextView G;
    private View H;
    private String I;
    private RecyclerView J;
    private com.tencent.biz.qqcircle.immersive.views.banner.g K;
    private final List<ImageView> L;
    private ParabolaAnimRunnable M;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class ParabolaAnimRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final Drawable f90571d;

        public ParabolaAnimRunnable(Drawable drawable) {
            this.f90571d = drawable;
        }

        @Override // java.lang.Runnable
        public void run() {
            QFSFeedFriendCommentGuideView.this.L(this.f90571d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends LinearLayoutManager {
        a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            return false;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements g.a {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.banner.g.a
        public void a(int i3) {
            QFSFeedFriendCommentGuideView.this.D(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ PathMeasure f90577d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float[] f90578e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ImageView f90579f;

        e(PathMeasure pathMeasure, float[] fArr, ImageView imageView) {
            this.f90577d = pathMeasure;
            this.f90578e = fArr;
            this.f90579f = imageView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f90577d.getPosTan(((Float) valueAnimator.getAnimatedValue()).floatValue(), this.f90578e, null);
            this.f90579f.setX(this.f90578e[0]);
            this.f90579f.setY(this.f90578e[1]);
        }
    }

    public QFSFeedFriendCommentGuideView(com.tencent.biz.qqcircle.immersive.views.banner.bottom.a aVar) {
        super(aVar);
        this.L = new ArrayList();
    }

    private void A() {
        if (this.D != null && this.f90601d != null) {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.putAll(ua0.c.d(this.f90601d));
            buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
            VideoReport.setElementId(this.D, QCircleDaTongConstant.ElementId.EM_XSJ_COMMENT_BOX_BAR);
            VideoReport.setElementParams(this.D, buildElementParams);
            VideoReport.setElementReuseIdentifier(this.D, QCircleDaTongConstant.ElementId.EM_XSJ_COMMENT_BOX_BAR + this.f90601d.g().f398449id.get());
            VideoReport.setElementExposePolicy(this.D, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(this.D, EndExposurePolicy.REPORT_ALL);
        }
    }

    private void B() {
        String dtPageId;
        if (this.I == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        String[] split = this.I.split(",");
        for (int i3 = 0; i3 < 3; i3++) {
            int c16 = cu.c(split[i3], -1);
            if (c16 != -1) {
                arrayList.add(Integer.valueOf(QQSysFaceUtil.convertToLocal(c16)));
            }
        }
        if (this.K == null) {
            G();
        }
        this.K.o0(this.f90601d);
        com.tencent.biz.qqcircle.immersive.views.banner.g gVar = this.K;
        if (p() == null) {
            dtPageId = "0";
        } else {
            dtPageId = p().getDtPageId();
        }
        gVar.p0(dtPageId);
        this.K.setData(arrayList);
        this.I = null;
    }

    private String C(String str, int i3) {
        StringBuilder sb5 = new StringBuilder();
        for (int i16 = 0; i16 < i3; i16++) {
            sb5.append(str);
        }
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(int i3) {
        K(QQSysFaceUtil.getFaceDrawable(i3));
        Q(i3);
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        if (feedCloudMeta$StFeed != null) {
            QFSFriendCommentGuideUtil.f(feedCloudMeta$StFeed.f398449id.get());
        }
    }

    private void E() {
        if (this.J == null) {
            QLog.d("QFSFeedFriendCommentGuideView", 1, "recyclerview is null");
            return;
        }
        a aVar = new a(j());
        aVar.setOrientation(0);
        this.J.setLayoutManager(aVar);
        com.tencent.biz.qqcircle.immersive.views.banner.g gVar = new com.tencent.biz.qqcircle.immersive.views.banner.g();
        this.K = gVar;
        gVar.q0(new b());
        this.J.setAdapter(this.K);
        B();
    }

    private boolean F() {
        QCircleReportBean p16;
        if (this.f90602e == null || (p16 = p()) == null) {
            return false;
        }
        int pageId = p16.getPageId();
        if ((pageId != 503 && pageId != 504) || !this.f90602e.opMask2.get().contains(49) || QFSFriendCommentGuideUtil.i(this.f90602e.f398449id.get())) {
            return false;
        }
        return true;
    }

    private void G() {
        if (this.D != null) {
            QLog.d("QFSFeedFriendCommentGuideView", 1, "mLayout has inflate");
            return;
        }
        ViewStub viewStub = (ViewStub) this.f90604h.findViewById(R.id.f42211j6);
        if (viewStub == null) {
            return;
        }
        View inflate = viewStub.inflate();
        this.D = (FrameLayout) inflate.findViewById(R.id.f42191j4);
        this.G = (TextView) inflate.findViewById(R.id.f42201j5);
        this.J = (RecyclerView) inflate.findViewById(R.id.f42171j2);
        View findViewById = inflate.findViewById(R.id.f42181j3);
        this.H = findViewById;
        findViewById.setOnClickListener(this);
        this.H.setVisibility(8);
        this.G.setOnClickListener(this);
        E();
    }

    private void H() {
        QFSFeedCommentInfo qFSFeedCommentInfo = new QFSFeedCommentInfo(this.f90602e, null);
        qFSFeedCommentInfo.showSuccessToast = true;
        QFSCommentHelper.L().y0((Activity) j(), qFSFeedCommentInfo, new c(), false, p());
    }

    private void I(int i3, ImageView imageView, long j3) {
        boolean z16;
        if (i3 % 2 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        PathInterpolator pathInterpolator = new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f);
        PathInterpolator pathInterpolator2 = new PathInterpolator(0.4f, 0.0f, 0.68f, 0.06f);
        int[][] iArr = N;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "translationX", 0.0f, iArr[i3][0]);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "translationY", 0.0f, iArr[i3][1]);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "translationY", iArr[i3][1], r11 + 120);
        ofFloat.setInterpolator(pathInterpolator);
        ofFloat2.setInterpolator(pathInterpolator);
        ofFloat3.setInterpolator(pathInterpolator);
        ofFloat.setDuration(160L);
        ofFloat2.setDuration(160L);
        if (!z16) {
            pathInterpolator = pathInterpolator2;
        }
        ofFloat3.setInterpolator(pathInterpolator);
        ofFloat3.setDuration(840L);
        ofFloat3.setStartDelay(80L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setStartDelay(j3);
        animatorSet.play(ofFloat).with(ofFloat2).before(ofFloat3);
        animatorSet.start();
    }

    private void J(ImageView imageView, int i3) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        ofFloat.setDuration(200L);
        ofFloat2.setDuration(40L);
        ofFloat2.setStartDelay((i3 * 40) + FilterEnum.MIC_PTU_TRANS_XINXIAN);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).before(ofFloat2);
        animatorSet.start();
        if (i3 != 2) {
            return;
        }
        animatorSet.addListener(new f());
    }

    private void K(Drawable drawable) {
        this.H.setVisibility(0);
        FrameLayout frameLayout = (FrameLayout) this.f90604h.findViewById(R.id.f40881fk);
        this.E = frameLayout;
        if (frameLayout == null) {
            return;
        }
        for (int i3 = 0; i3 < 8; i3++) {
            ImageView imageView = new ImageView(j());
            int dpToPx = ImmersiveUtils.dpToPx(N[i3][2]);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dpToPx, dpToPx, 80);
            layoutParams.leftMargin = (int) (this.D.getX() + (this.D.getWidth() / 2));
            layoutParams.bottomMargin = this.D.getHeight();
            imageView.setLayoutParams(layoutParams);
            imageView.setImageDrawable(drawable);
            this.E.addView(imageView);
            imageView.setAlpha(0.0f);
            this.L.add(imageView);
            long j3 = (i3 / 4) * 120;
            I(i3, imageView, j3);
            P(imageView, j3);
            O(i3, imageView, j3);
        }
        if (this.M == null) {
            this.M = new ParabolaAnimRunnable(drawable);
        }
        this.E.postDelayed(this.M, 320L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(Drawable drawable) {
        ImageView imageView = (ImageView) this.f90604h.findViewById(R.id.v_l);
        this.F = imageView;
        if (imageView == null) {
            return;
        }
        y(drawable);
        S();
    }

    private void M(ImageView imageView, int i3) {
        int[] iArr = new int[2];
        int[] iArr2 = {ImmersiveUtils.dpToPx(170.0f), ImmersiveUtils.getScreenHeight() - ImmersiveUtils.dpToPx(200.0f)};
        this.F.getLocationInWindow(iArr);
        int[] iArr3 = {iArr[0] - ImmersiveUtils.dpToPx(5.0f), iArr[1] - this.F.getHeight()};
        int i16 = iArr2[0];
        int[] iArr4 = {i16 + ((iArr3[0] - i16) / 2), (int) (iArr2[1] - ((iArr3[0] - iArr2[0]) * 1.5d))};
        Path path = new Path();
        path.moveTo(iArr2[0], iArr2[1]);
        path.quadTo(iArr4[0], iArr4[1], iArr3[0], iArr3[1]);
        PathMeasure pathMeasure = new PathMeasure();
        pathMeasure.setPath(path, false);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, pathMeasure.getLength());
        ofFloat.setInterpolator(new PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f));
        ofFloat.setDuration(480L);
        ofFloat.setStartDelay(i3 * 40);
        ofFloat.addUpdateListener(new e(pathMeasure, new float[2], imageView));
        ofFloat.start();
    }

    private void N(ImageView imageView, int i3) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, BasicAnimation.KeyPath.SCALE_X, 1.0f, 0.2f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 0.2f);
        ofFloat.setDuration(280L);
        ofFloat2.setDuration(280L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setStartDelay((i3 * 40) + 200);
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.start();
    }

    private void O(int i3, ImageView imageView, long j3) {
        boolean z16;
        float f16;
        if (i3 % 2 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            f16 = 1.0f;
        } else {
            f16 = 0.7f;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, f16);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, com.tencent.luggage.wxa.c8.c.f123400v, f16, 0.0f);
        ofFloat.setDuration(40L);
        ofFloat2.setDuration(920L);
        ofFloat2.setStartDelay(120L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setStartDelay(j3);
        animatorSet.play(ofFloat).before(ofFloat2);
        animatorSet.start();
    }

    private void P(ImageView imageView, long j3) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, BasicAnimation.KeyPath.SCALE_X, 0.5f, 1.0f);
        ofFloat.setDuration(160L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, BasicAnimation.KeyPath.SCALE_Y, 0.5f, 1.0f);
        ofFloat2.setDuration(160L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, BasicAnimation.KeyPath.SCALE_X, 1.0f, 0.0f);
        ofFloat3.setDuration(920L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 0.0f);
        ofFloat4.setDuration(920L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setStartDelay(j3);
        animatorSet.play(ofFloat).with(ofFloat2).before(ofFloat3).before(ofFloat4);
        animatorSet.start();
    }

    private void Q(int i3) {
        int hashCode;
        if (this.f90602e == null) {
            return;
        }
        String b16 = bg.b(i3);
        FeedCloudMeta$StComment feedCloudMeta$StComment = new FeedCloudMeta$StComment();
        feedCloudMeta$StComment.f398447id.set(QFSCommentHelper.H());
        feedCloudMeta$StComment.content.set(C(b16, 3));
        feedCloudMeta$StComment.createTime.set((int) (System.currentTimeMillis() / 1000));
        FeedCloudMeta$StUser m3 = QCirclePluginGlobalInfo.m();
        if (QCircleHostGlobalInfo.getStUserInfo() != null) {
            m3.iconDecorate.set(QCircleHostGlobalInfo.getStUserInfo().iconDecorate.get());
        }
        feedCloudMeta$StComment.postUser.set(m3);
        com.tencent.biz.qqcircle.comment.h G = com.tencent.biz.qqcircle.comment.h.G();
        if (j() == null) {
            hashCode = 0;
        } else {
            hashCode = j().hashCode();
        }
        G.o(hashCode, this.f90602e, feedCloudMeta$StComment, false, true, QCirclePluginUtil.getQCircleInitBean(j()));
        SimpleEventBus.getInstance().dispatchEvent(new QFSAddFakeCommentOrReplyEvent(this.f90602e.f398449id.get(), feedCloudMeta$StComment));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(boolean z16, boolean z17) {
        float f16;
        int i3 = 8;
        if (z16) {
            this.H.setVisibility(8);
        }
        FrameLayout frameLayout = this.D;
        if (frameLayout == null) {
            return;
        }
        float f17 = 1.0f;
        if (!z17) {
            frameLayout.setAlpha(1.0f);
            FrameLayout frameLayout2 = this.D;
            if (z16) {
                i3 = 0;
            }
            frameLayout2.setVisibility(i3);
            return;
        }
        float[] fArr = new float[2];
        if (z16) {
            f16 = 0.0f;
        } else {
            f16 = 1.0f;
        }
        fArr[0] = f16;
        if (!z16) {
            f17 = 0.0f;
        }
        fArr[1] = f17;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(frameLayout, com.tencent.luggage.wxa.c8.c.f123400v, fArr);
        ofFloat.setDuration(280L);
        ofFloat.addListener(new d(z16));
        ofFloat.start();
    }

    private void S() {
        ImageView imageView = this.F;
        if (imageView == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, BasicAnimation.KeyPath.SCALE_X, 1.0f, 1.1f, 0.9f);
        ofFloat.setDuration(160L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.F, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 1.1f, 0.9f);
        ofFloat2.setDuration(160L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.F, BasicAnimation.KeyPath.SCALE_X, 0.9f, 1.05f);
        ofFloat3.setDuration(120L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.F, BasicAnimation.KeyPath.SCALE_Y, 0.9f, 1.05f);
        ofFloat4.setDuration(120L);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.F, BasicAnimation.KeyPath.SCALE_X, 1.05f, 1.0f);
        ofFloat5.setDuration(200L);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.F, BasicAnimation.KeyPath.SCALE_Y, 1.05f, 1.0f);
        ofFloat6.setDuration(200L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setStartDelay(680L);
        animatorSet.play(ofFloat3).with(ofFloat4).after(ofFloat).after(ofFloat2).before(ofFloat5).before(ofFloat6);
        animatorSet.start();
    }

    private void y(Drawable drawable) {
        FrameLayout frameLayout = (FrameLayout) this.f90604h.findViewById(R.id.f40881fk);
        this.E = frameLayout;
        if (frameLayout == null) {
            return;
        }
        for (int i3 = 0; i3 < 3; i3++) {
            ImageView imageView = new ImageView(j());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ImmersiveUtils.dpToPx(26.0f), ImmersiveUtils.dpToPx(26.0f), 80);
            layoutParams.leftMargin = ImmersiveUtils.dpToPx(170.0f);
            layoutParams.bottomMargin = ImmersiveUtils.dpToPx(130.0f);
            imageView.setLayoutParams(layoutParams);
            imageView.setImageDrawable(drawable);
            imageView.setAlpha(0.0f);
            this.E.addView(imageView);
            this.L.add(imageView);
            M(imageView, i3);
            N(imageView, i3);
            J(imageView, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str) {
        if (this.G != null && this.f90601d != null && p() != null) {
            VideoReport.setElementId(this.G, QCircleDaTongConstant.ElementId.EM_XSJ_COMMENT_BOX_BAR_INPUT_AREA);
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_COMMENT_BOX_BAR_INPUT_AREA);
            buildElementParams.put("xsj_custom_pgid", p().getDtPageId());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ACTION_VIDEO_LOCATION, Long.valueOf(w20.a.j().b()));
            buildElementParams.put("xsj_action_type", "cmt");
            buildElementParams.putAll(ua0.c.d(this.f90601d));
            VideoReport.reportEvent(str, this.G, buildElementParams);
        }
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 110;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c, com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void h(e30.b bVar, int i3) {
        super.h(bVar, i3);
        String d16 = bh.d(bVar.g().feedTextInfo.get(), "comment_hint");
        String d17 = bh.d(bVar.g().feedTextInfo.get(), "comment_hint_emoji");
        if (this.G != null && !TextUtils.isEmpty(d16)) {
            this.G.setText(d16);
        }
        if (!TextUtils.isEmpty(d17)) {
            this.I = d17;
        }
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        return F();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f42201j5) {
            H();
            z("ev_xsj_abnormal_clck");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        G();
        R(true, false);
        QFSFriendCommentGuideUtil.c(this.f90602e.f398449id.get());
        A();
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        R(false, false);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void r() {
        FrameLayout frameLayout = this.E;
        if (frameLayout == null) {
            return;
        }
        frameLayout.removeCallbacks(this.M);
        Iterator<ImageView> it = this.L.iterator();
        while (it.hasNext()) {
            this.E.removeView(it.next());
        }
        this.L.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements QFSCommentHelper.b {
        c() {
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSCommentHelper.b
        public void c(FeedCloudMeta$StComment feedCloudMeta$StComment, o20.d dVar) {
            QFSFeedFriendCommentGuideView.this.R(false, false);
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = QFSFeedFriendCommentGuideView.this.f90602e;
            if (feedCloudMeta$StFeed != null) {
                QFSFriendCommentGuideUtil.f(feedCloudMeta$StFeed.f398449id.get());
                SimpleEventBus.getInstance().dispatchEvent(new QFSAddFakeCommentOrReplyEvent(QFSFeedFriendCommentGuideView.this.f90602e.f398449id.get(), feedCloudMeta$StComment));
            }
            QFSFeedFriendCommentGuideView.this.z(QCircleDaTongConstant.EventId.EV_XSJ_CMT_ACTION);
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSCommentHelper.b
        public void a(int i3) {
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSCommentHelper.b
        public void b(FeedCloudMeta$StReply feedCloudMeta$StReply, o20.d dVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f90575d;

        d(boolean z16) {
            this.f90575d = z16;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            int i3;
            FrameLayout frameLayout = QFSFeedFriendCommentGuideView.this.D;
            if (this.f90575d) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            frameLayout.setVisibility(i3);
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
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class f implements Animator.AnimatorListener {
        f() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QFSFeedFriendCommentGuideView.this.R(false, true);
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

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void q() {
    }
}
