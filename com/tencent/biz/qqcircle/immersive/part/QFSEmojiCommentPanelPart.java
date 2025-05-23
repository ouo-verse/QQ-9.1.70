package com.tencent.biz.qqcircle.immersive.part;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.events.QFSAddFakeCommentOrReplyEvent;
import com.tencent.biz.qqcircle.immersive.adapter.c;
import com.tencent.biz.qqcircle.immersive.events.QFSShowEmojiCommentPanelEvent;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qcircle.api.event.QCircleSeekAreaEvent;
import com.tencent.mobileqq.qcircle.api.event.QCircleSelectTabEvent;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* loaded from: classes4.dex */
public class QFSEmojiCommentPanelPart extends com.tencent.biz.qqcircle.bizparts.b implements SimpleEventReceiver, View.OnClickListener {
    private static final int[] H = {356, 319, 299, 294};
    private static final int[] I = {0, 21, 337, 320};
    private static final int[] J = {338, 271, 166, 161};
    private static final int[] K = {265, 268, 24, 32};
    private static final int L = ImmersiveUtils.dpToPx(36.0f);
    private static final int M = ImmersiveUtils.dpToPx(48.0f);
    private static final int N = ImmersiveUtils.dpToPx(10.0f);
    private e30.b C;
    private int D;
    private int E;
    private int F;
    private String G;

    /* renamed from: d, reason: collision with root package name */
    private View f87358d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f87359e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f87360f;

    /* renamed from: h, reason: collision with root package name */
    private RecyclerView f87361h;

    /* renamed from: i, reason: collision with root package name */
    private ViewGroup f87362i;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.biz.qqcircle.immersive.adapter.c f87363m;

    private AnimatorSet E9(boolean z16) {
        float f16;
        float f17;
        RecyclerView recyclerView = this.f87361h;
        float[] fArr = new float[2];
        float f18 = 1.0f;
        float f19 = 0.0f;
        if (z16) {
            f16 = 0.0f;
        } else {
            f16 = 1.0f;
        }
        fArr[0] = f16;
        if (!z16) {
            f18 = 0.0f;
        }
        fArr[1] = f18;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(recyclerView, com.tencent.luggage.wxa.c8.c.f123400v, fArr);
        int dpToPx = ImmersiveUtils.dpToPx(22.0f);
        RecyclerView recyclerView2 = this.f87361h;
        float[] fArr2 = new float[2];
        if (z16) {
            f17 = dpToPx;
        } else {
            f17 = 0.0f;
        }
        fArr2[0] = f17;
        if (!z16) {
            f19 = dpToPx;
        }
        fArr2[1] = f19;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(recyclerView2, "translationX", fArr2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(200L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        return animatorSet;
    }

    private void F9(int i3, Drawable drawable) {
        if (this.f87362i == null) {
            return;
        }
        List<ImageView> arrayList = new ArrayList<>();
        int[] iArr = new int[2];
        this.f87362i.getLocationInWindow(iArr);
        this.F = iArr[0];
        for (int i16 = 0; i16 < 3; i16++) {
            ImageView imageView = new ImageView(getContext());
            int i17 = L;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i17, i17, 48);
            int dpToPx = this.D - ((M * (4 - i3)) - ImmersiveUtils.dpToPx(5.0f));
            int dpToPx2 = this.E + ImmersiveUtils.dpToPx(18.0f);
            layoutParams.leftMargin = dpToPx;
            layoutParams.topMargin = dpToPx2;
            imageView.setLayoutParams(layoutParams);
            imageView.setImageDrawable(drawable);
            imageView.setAlpha(0.0f);
            this.f87362i.addView(imageView);
            arrayList.add(imageView);
            P9(imageView, i16, dpToPx, dpToPx2);
            Q9(imageView, i16);
            O9(imageView, i16, drawable, arrayList);
        }
    }

    private int G9(int[] iArr) {
        return iArr[new Random().nextInt(iArr.length)];
    }

    private String H9(String str, int i3) {
        StringBuilder sb5 = new StringBuilder();
        for (int i16 = 0; i16 < i3; i16++) {
            sb5.append(str);
        }
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I9(int i3, int i16) {
        J9();
        F9(i16, QQSysFaceUtil.getFaceDrawable(i3));
        R9(i3);
    }

    private void J9() {
        View view = this.f87358d;
        if (view != null && view.getVisibility() != 8) {
            AnimatorSet E9 = E9(false);
            E9.addListener(new a());
            E9.start();
        }
    }

    private void K9() {
        startInit();
        S9();
    }

    private void L9(@NonNull QCircleSeekAreaEvent qCircleSeekAreaEvent) {
        if (qCircleSeekAreaEvent.getEvent().getAction() == 2) {
            J9();
        }
    }

    private void M9(@NonNull QFSShowEmojiCommentPanelEvent qFSShowEmojiCommentPanelEvent) {
        if (qFSShowEmojiCommentPanelEvent.getHashCode() != getContext().hashCode()) {
            return;
        }
        this.C = qFSShowEmojiCommentPanelEvent.getFeedBlockData();
        this.G = qFSShowEmojiCommentPanelEvent.getPageId();
        this.f87359e = qFSShowEmojiCommentPanelEvent.getAnchor();
        K9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N9(PathMeasure pathMeasure, float[] fArr, ImageView imageView, ValueAnimator valueAnimator) {
        pathMeasure.getPosTan(((Float) valueAnimator.getAnimatedValue()).floatValue(), fArr, null);
        imageView.setX(fArr[0] - this.F);
        imageView.setY(fArr[1]);
    }

    private void O9(ImageView imageView, int i3, final Drawable drawable, final List<ImageView> list) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        ofFloat.setDuration(340L);
        ofFloat2.setDuration(70L);
        ofFloat2.setStartDelay((i3 * 70) + 480);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).before(ofFloat2);
        animatorSet.start();
        if (i3 != 2) {
            return;
        }
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSEmojiCommentPanelPart.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (QFSEmojiCommentPanelPart.this.f87359e == null) {
                    return;
                }
                QFSEmojiCommentPanelPart.this.f87359e.setImageDrawable(drawable);
                RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSEmojiCommentPanelPart.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QFSEmojiCommentPanelPart.this.f87359e.setImageResource(com.tencent.biz.qqcircle.k.c());
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            QFSEmojiCommentPanelPart.this.f87362i.removeView((ImageView) it.next());
                        }
                        list.clear();
                    }
                }, 1000L);
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
        });
    }

    private void P9(final ImageView imageView, int i3, int i16, int i17) {
        final float[] fArr = new float[2];
        int i18 = this.D;
        int i19 = N;
        int i26 = i18 + i19;
        int[] iArr = {i26, this.E + i19};
        int i27 = new int[]{i16, i17}[0];
        int[] iArr2 = {i27 + ((i26 - i27) / 2), (int) (r2[1] - ((iArr[0] - r2[0]) * 1.5d))};
        Path path = new Path();
        path.moveTo(r2[0], r2[1]);
        path.quadTo(iArr2[0], iArr2[1], iArr[0], iArr[1]);
        final PathMeasure pathMeasure = new PathMeasure();
        pathMeasure.setPath(path, false);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, pathMeasure.getLength());
        ofFloat.setInterpolator(new PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f));
        ofFloat.setDuration(820L);
        ofFloat.setStartDelay(i3 * 70);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.part.be
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                QFSEmojiCommentPanelPart.this.N9(pathMeasure, fArr, imageView, valueAnimator);
            }
        });
        ofFloat.start();
    }

    private void Q9(ImageView imageView, int i3) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, BasicAnimation.KeyPath.SCALE_X, 1.0f, 0.2f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 0.2f);
        ofFloat.setDuration(480L);
        ofFloat2.setDuration(480L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setStartDelay((i3 * 70) + 340);
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.start();
    }

    private void R9(int i3) {
        FeedCloudMeta$StFeed g16;
        int hashCode;
        e30.b bVar = this.C;
        if (bVar == null || (g16 = bVar.g()) == null) {
            return;
        }
        String a16 = com.tencent.biz.qqcircle.utils.bg.a(i3);
        FeedCloudMeta$StComment feedCloudMeta$StComment = new FeedCloudMeta$StComment();
        feedCloudMeta$StComment.f398447id.set(QFSCommentHelper.H());
        feedCloudMeta$StComment.content.set(H9(a16, 3));
        feedCloudMeta$StComment.createTime.set((int) (System.currentTimeMillis() / 1000));
        FeedCloudMeta$StUser m3 = QCirclePluginGlobalInfo.m();
        if (QCircleHostGlobalInfo.getStUserInfo() != null) {
            m3.iconDecorate.set(QCircleHostGlobalInfo.getStUserInfo().iconDecorate.get());
        }
        feedCloudMeta$StComment.postUser.set(m3);
        Context context = getContext();
        com.tencent.biz.qqcircle.comment.h G = com.tencent.biz.qqcircle.comment.h.G();
        if (context == null) {
            hashCode = 0;
        } else {
            hashCode = context.hashCode();
        }
        G.o(hashCode, g16, feedCloudMeta$StComment, false, true, QCirclePluginUtil.getQCircleInitBean(context));
        SimpleEventBus.getInstance().dispatchEvent(new QFSAddFakeCommentOrReplyEvent(g16.f398449id.get(), feedCloudMeta$StComment));
    }

    private void S9() {
        com.tencent.biz.qqcircle.utils.ce.e(true, this.f87359e.getParent());
        this.f87363m.l0(this.C);
        this.f87363m.n0(this.G);
        this.f87363m.setDatas(Arrays.asList(Integer.valueOf(G9(H)), Integer.valueOf(G9(I)), Integer.valueOf(G9(J)), Integer.valueOf(G9(K))));
        this.f87358d.setVisibility(0);
        int[] iArr = new int[2];
        this.f87359e.getLocationInWindow(iArr);
        this.D = iArr[0];
        this.E = iArr[1];
        QLog.d("QFSEmojiCommentPanelPart", 1, "[showPanel] mAnchorX:" + this.D + " mAnchorY:" + this.E);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f87361h.getLayoutParams();
        layoutParams.rightMargin = this.f87359e.getWidth() - ImmersiveUtils.dpToPx(5.0f);
        layoutParams.topMargin = iArr[1] + ImmersiveUtils.dpToPx(13.0f);
        this.f87361h.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f87360f.getLayoutParams();
        layoutParams2.leftMargin = iArr[0];
        layoutParams2.topMargin = iArr[1];
        this.f87360f.setLayoutParams(layoutParams2);
        this.f87360f.setVisibility(0);
        AnimatorSet E9 = E9(true);
        E9.addListener(new b());
        E9.start();
        SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(38, com.tencent.biz.qqcircle.utils.bj.g(com.tencent.biz.qqcircle.utils.bj.f(this.C)), true));
    }

    private boolean isShow() {
        View view = this.f87358d;
        if (view != null && view.getVisibility() != 8) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSShowEmojiCommentPanelEvent.class);
        arrayList.add(QCircleConfigChangeEvent.class);
        arrayList.add(QCircleSelectTabEvent.class);
        arrayList.add(QCircleSeekAreaEvent.class);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        return R.id.f370816a;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        QLog.d("QFSEmojiCommentPanelPart", 1, "EmojiCommentPanel_onBackEvent");
        if (isShow()) {
            J9();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f3706169) {
            J9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        View findViewById = view.findViewById(R.id.f3706169);
        this.f87358d = findViewById;
        this.f87362i = (ViewGroup) findViewById.getParent();
        this.f87360f = (ImageView) view.findViewById(R.id.f370716_);
        this.f87361h = (RecyclerView) view.findViewById(R.id.f371216e);
        this.f87358d.setOnClickListener(this);
        this.f87361h.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        com.tencent.biz.qqcircle.immersive.adapter.c cVar = new com.tencent.biz.qqcircle.immersive.adapter.c();
        this.f87363m = cVar;
        cVar.m0(new c.b() { // from class: com.tencent.biz.qqcircle.immersive.part.bd
            @Override // com.tencent.biz.qqcircle.immersive.adapter.c.b
            public final void a(int i3, int i16) {
                QFSEmojiCommentPanelPart.this.I9(i3, i16);
            }
        });
        this.f87361h.setAdapter(this.f87363m);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, @Nullable Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSShowEmojiCommentPanelEvent) {
            M9((QFSShowEmojiCommentPanelEvent) simpleBaseEvent);
            return;
        }
        if (!(simpleBaseEvent instanceof QCircleSelectTabEvent) && !(simpleBaseEvent instanceof QCircleConfigChangeEvent)) {
            if (simpleBaseEvent instanceof QCircleSeekAreaEvent) {
                L9((QCircleSeekAreaEvent) simpleBaseEvent);
                return;
            }
            return;
        }
        J9();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements Animator.AnimatorListener {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            com.tencent.biz.qqcircle.utils.ce.e(false, QFSEmojiCommentPanelPart.this.f87359e.getParent());
            if (QFSEmojiCommentPanelPart.this.f87358d != null) {
                QFSEmojiCommentPanelPart.this.f87358d.setVisibility(8);
            }
            SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(38, com.tencent.biz.qqcircle.utils.bj.g(com.tencent.biz.qqcircle.utils.bj.f(QFSEmojiCommentPanelPart.this.C)), false));
            VideoReport.traversePage(QFSEmojiCommentPanelPart.this.f87358d);
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
    public class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            VideoReport.traversePage(QFSEmojiCommentPanelPart.this.f87358d);
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
