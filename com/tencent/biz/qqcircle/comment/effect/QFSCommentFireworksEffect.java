package com.tencent.biz.qqcircle.comment.effect;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.drawable.Animatable;
import android.text.TextUtils;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.qqcircle.beans.QFSFakeCommentAvatarUpdateEvent;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.ArrayList;
import qqcircle.QQCircleEnvHub$CommentActivityInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCommentFireworksEffect extends com.tencent.biz.qqcircle.comment.effect.c implements SimpleEventReceiver {
    private static final int I = cx.a(66.0f);
    private static final int J = cx.a(87.0f);
    private final ImageView G;
    private final ImageView H;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends QCirclePicStateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int[] f83544d;

        a(int[] iArr) {
            this.f83544d = iArr;
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            super.onStateChange(loadState, option);
            if (loadState.isFinishSuccess()) {
                QFSCommentFireworksEffect.this.q(this.f83544d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ PathMeasure f83546d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float[] f83547e;

        b(PathMeasure pathMeasure, float[] fArr) {
            this.f83546d = pathMeasure;
            this.f83547e = fArr;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f83546d.getPosTan(((Float) valueAnimator.getAnimatedValue()).floatValue(), this.f83547e, null);
            QFSCommentFireworksEffect.this.G.setX(this.f83547e[0]);
            QFSCommentFireworksEffect.this.G.setY(this.f83547e[1]);
        }
    }

    public QFSCommentFireworksEffect(@NonNull QQCircleEnvHub$CommentActivityInfo qQCircleEnvHub$CommentActivityInfo, @NonNull FrameLayout frameLayout, @NonNull RelativeLayout relativeLayout, String str, @NonNull String str2) {
        super(qQCircleEnvHub$CommentActivityInfo, frameLayout, relativeLayout, str, str2);
        this.G = (ImageView) this.f83572e.findViewById(R.id.y8j);
        this.H = (ImageView) this.f83572e.findViewById(R.id.y37);
    }

    @NonNull
    private TimeInterpolator o(int i3) {
        if (i3 < 314) {
            return new lc0.a(0.0f, 0.0f, 1.0f, 1.0f);
        }
        if (i3 < 365) {
            return new lc0.a(0.19f, 0.38f, 0.79f, 1.0f);
        }
        if (i3 < 416) {
            return new lc0.a(0.19f, 0.46f, 0.77f, 1.0f);
        }
        if (i3 < 467) {
            return new lc0.a(0.19f, 0.46f, 0.63f, 1.0f);
        }
        if (i3 < 518) {
            return new lc0.a(0.13f, 0.47f, 0.61f, 1.0f);
        }
        if (i3 < 569) {
            return new lc0.a(0.16f, 0.45f, 0.65f, 1.0f);
        }
        if (i3 < 620) {
            return new lc0.a(0.13f, 0.57f, 0.56f, 1.0f);
        }
        if (i3 < 671) {
            return new lc0.a(0.14f, 0.62f, 0.48f, 1.0f);
        }
        return new lc0.a(0.11f, 0.62f, 0.41f, 1.0f);
    }

    private void p(QFSFakeCommentAvatarUpdateEvent qFSFakeCommentAvatarUpdateEvent) {
        if (TextUtils.equals(qFSFakeCommentAvatarUpdateEvent.getFakeId(), this.f83576m)) {
            s(qFSFakeCommentAvatarUpdateEvent.getLocation());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int[] iArr) {
        this.G.setVisibility(0);
        Object drawable = this.G.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
        int i3 = iArr[0];
        int i16 = I;
        int[] iArr2 = {i3 - (i16 / 2), iArr[1] - (i16 / 2)};
        int c16 = (cx.c(this.f83572e.getContext()) / 2) - (i16 / 2);
        int[] iArr3 = {c16, J};
        int[] iArr4 = {c16, iArr2[1]};
        Path path = new Path();
        path.moveTo(iArr2[0], iArr2[1]);
        path.quadTo(iArr4[0], iArr4[1], iArr3[0], iArr3[1]);
        PathMeasure pathMeasure = new PathMeasure();
        pathMeasure.setPath(path, false);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, pathMeasure.getLength());
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new b(pathMeasure, new float[2]));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.G, BasicAnimation.KeyPath.ROTATION, 0.0f, -90.0f);
        ofFloat2.setInterpolator(o(iArr2[1] + i16));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.setDuration(320L);
        animatorSet.addListener(new c(animatorSet));
        animatorSet.start();
        this.D.add(animatorSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        String str = this.f83571d.expressionURLs.get(1);
        int g16 = cx.g();
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(str).setRequestWidth(g16).setRequestHeight((int) this.H.getContext().getResources().getDimension(R.dimen.d0n)).setNeedShowLoadingDrawable(false).setTargetView(this.H), new QCirclePicStateListener() { // from class: com.tencent.biz.qqcircle.comment.effect.QFSCommentFireworksEffect.4
            @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
            public void onStateChange(LoadState loadState, Option option) {
                if (loadState.isFinishSuccess() && (option.getAnimatable() instanceof r01.c)) {
                    QFSCommentFireworksEffect.this.H.setVisibility(0);
                    Object drawable = QFSCommentFireworksEffect.this.H.getDrawable();
                    if (drawable instanceof Animatable) {
                        ((Animatable) drawable).start();
                    }
                    int duration = ((r01.c) option.getAnimatable()).getDuration();
                    QFSCommentFireworksEffect.this.H.postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.effect.QFSCommentFireworksEffect.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QFSCommentFireworksEffect.this.i(true);
                        }
                    }, duration - 120);
                    QFSCommentFireworksEffect.this.H.postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.effect.QFSCommentFireworksEffect.4.2
                        @Override // java.lang.Runnable
                        public void run() {
                            QFSCommentFireworksEffect.this.H.setVisibility(8);
                            QFSCommentFireworksEffect.this.E = false;
                        }
                    }, duration);
                }
            }
        });
    }

    private void s(int[] iArr) {
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(this.f83571d.expressionURLs.get(0)).setTargetView(this.G), new a(iArr));
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSFakeCommentAvatarUpdateEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSFakeCommentAvatarUpdateEvent) {
            p((QFSFakeCommentAvatarUpdateEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.comment.effect.c, com.tencent.biz.qqcircle.comment.effect.a
    public void start() {
        if (this.f83571d.expressionURLs.size() < 2) {
            RFWLog.d("QFSCommentFireworksEffect", RFWLog.USR, "start return: expressionURLs size invalid, activityId=", this.f83571d.activityID, "\uff0ccontent=" + this.C);
            return;
        }
        super.start();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.comment.effect.c, com.tencent.biz.qqcircle.comment.effect.a
    public void stop() {
        super.stop();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        i(false);
        this.G.setVisibility(8);
        this.H.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AnimatorSet f83549d;

        c(AnimatorSet animatorSet) {
            this.f83549d = animatorSet;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QFSCommentFireworksEffect.this.G.setVisibility(8);
            QFSCommentFireworksEffect.this.r();
            QFSCommentFireworksEffect.this.D.remove(this.f83549d);
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
