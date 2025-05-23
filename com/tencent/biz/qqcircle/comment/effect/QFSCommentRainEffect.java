package com.tencent.biz.qqcircle.comment.effect;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.text.TextUtils;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.qqcircle.events.QFSCommentKeywordHighlightDismissEvent;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.Random;
import org.light.LightConstants;
import qqcircle.QQCircleEnvHub$CommentActivityInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCommentRainEffect extends c {
    private static final int K = cx.a(48.0f);
    private static final int L = cx.a(120.0f);
    private final Interpolator G;

    @NonNull
    private final Random H;
    private long I;

    @NonNull
    private final Runnable J;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends QCirclePicStateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageView f83561d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f83562e;

        a(ImageView imageView, boolean z16) {
            this.f83561d = imageView;
            this.f83562e = z16;
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            if (loadState.isFinishSuccess()) {
                int nextInt = (int) (((QFSCommentRainEffect.this.H.nextInt(20) + 90) / 100.0f) * QFSCommentRainEffect.K);
                QFSCommentRainEffect.this.f83573f.addView(this.f83561d, nextInt, nextInt);
                QFSCommentRainEffect.this.x(this.f83561d, nextInt, this.f83562e);
            }
        }
    }

    public QFSCommentRainEffect(@NonNull QQCircleEnvHub$CommentActivityInfo qQCircleEnvHub$CommentActivityInfo, @NonNull FrameLayout frameLayout, @NonNull RelativeLayout relativeLayout, String str, @NonNull String str2) {
        super(qQCircleEnvHub$CommentActivityInfo, frameLayout, relativeLayout, str, str2);
        this.G = new AccelerateInterpolator();
        this.H = new Random();
        this.J = new Runnable() { // from class: com.tencent.biz.qqcircle.comment.effect.QFSCommentRainEffect.1
            @Override // java.lang.Runnable
            public void run() {
                if (QFSCommentRainEffect.this.u()) {
                    return;
                }
                QFSCommentRainEffect.this.I += 100;
                QFSCommentRainEffect qFSCommentRainEffect = QFSCommentRainEffect.this;
                qFSCommentRainEffect.t(qFSCommentRainEffect.u());
                RFWThreadManager.getUIHandler().postDelayed(this, 100L);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(boolean z16) {
        ImageView imageView = new ImageView(this.f83573f.getContext());
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(this.f83571d.expressionURLs.get(this.H.nextInt(this.f83571d.expressionURLs.size()))).setTargetView(imageView), new a(imageView, z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u() {
        if (this.I > 2500) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(int i3, boolean z16) {
        if (b() && z16) {
            RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.effect.QFSCommentRainEffect.5
                @Override // java.lang.Runnable
                public void run() {
                    if (QFSCommentRainEffect.this.u()) {
                        SimpleEventBus.getInstance().dispatchEvent(new QFSCommentKeywordHighlightDismissEvent());
                    }
                }
            }, i3 - 200);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(int i3, boolean z16) {
        if (!z16) {
            return;
        }
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.effect.QFSCommentRainEffect.4
            @Override // java.lang.Runnable
            public void run() {
                if (QFSCommentRainEffect.this.u()) {
                    QFSCommentRainEffect.this.i(true);
                }
            }
        }, i3 + LightConstants.ErrorCode.TEMPLATE_JSON_EMPTY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(ImageView imageView, int i3, boolean z16) {
        int i16;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, BasicAnimation.KeyPath.ROTATION, this.H.nextInt(90) - 45, 180.0f);
        int nextFloat = (int) (new Random().nextFloat() * this.f83573f.getWidth());
        if (this.H.nextBoolean()) {
            i16 = 1;
        } else {
            i16 = -1;
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "translationX", nextFloat, (i16 * L) + nextFloat);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "translationY", -i3, this.f83573f.getHeight() + i3);
        ofFloat3.setInterpolator(this.G);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        int nextInt = this.H.nextInt(500) + 2000;
        animatorSet.setDuration(nextInt);
        animatorSet.addListener(new b(nextInt, z16, imageView, animatorSet));
        this.D.add(animatorSet);
        animatorSet.start();
    }

    @Override // com.tencent.biz.qqcircle.comment.effect.c, com.tencent.biz.qqcircle.comment.effect.a
    public boolean b() {
        return !TextUtils.isEmpty(this.f83571d.keyWordHighLightInfo.keywordHighlightResURL.get());
    }

    @Override // com.tencent.biz.qqcircle.comment.effect.c, com.tencent.biz.qqcircle.comment.effect.a
    public boolean isRunning() {
        return this.E;
    }

    @Override // com.tencent.biz.qqcircle.comment.effect.c, com.tencent.biz.qqcircle.comment.effect.a
    public void start() {
        super.start();
        RFWThreadManager.getUIHandler().post(this.J);
    }

    @Override // com.tencent.biz.qqcircle.comment.effect.c, com.tencent.biz.qqcircle.comment.effect.a
    public void stop() {
        super.stop();
        RFWThreadManager.getUIHandler().removeCallbacks(this.J);
        this.I = 0L;
        i(false);
        SimpleEventBus.getInstance().dispatchEvent(new QFSCommentKeywordHighlightDismissEvent());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f83564d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f83565e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ImageView f83566f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ AnimatorSet f83567h;

        b(int i3, boolean z16, ImageView imageView, AnimatorSet animatorSet) {
            this.f83564d = i3;
            this.f83565e = z16;
            this.f83566f = imageView;
            this.f83567h = animatorSet;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            QFSCommentRainEffect.this.f83573f.removeView(this.f83566f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QFSCommentRainEffect.this.f83573f.removeView(this.f83566f);
            QFSCommentRainEffect.this.D.remove(this.f83567h);
            if (this.f83565e) {
                QFSCommentRainEffect.this.E = false;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QFSCommentRainEffect.this.w(this.f83564d, this.f83565e);
            QFSCommentRainEffect.this.v(this.f83564d, this.f83565e);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
