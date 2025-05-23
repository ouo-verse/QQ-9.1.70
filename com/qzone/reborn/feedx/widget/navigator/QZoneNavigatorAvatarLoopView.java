package com.qzone.reborn.feedx.widget.navigator;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.qzone.reborn.widget.QZoneAvatarLoopView;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder;
import com.tencent.util.ArrayUtils;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneNavigatorAvatarLoopView extends QZoneBaseWidgetView<List<Long>> {
    private boolean C;
    private boolean D;

    /* renamed from: e, reason: collision with root package name */
    private QZoneAvatarLoopView f56441e;

    /* renamed from: f, reason: collision with root package name */
    private QZoneUserAvatarView f56442f;

    /* renamed from: h, reason: collision with root package name */
    private final Runnable f56443h;

    /* renamed from: i, reason: collision with root package name */
    private final Runnable f56444i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f56445m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements Animator.AnimatorListener {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            QZoneNavigatorAvatarLoopView.this.C = false;
            QZoneNavigatorAvatarLoopView.this.f56445m = false;
            if (QZoneNavigatorAvatarLoopView.this.f56442f != null) {
                QZoneNavigatorAvatarLoopView.this.f56442f.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QLog.d("QZoneNavigatorAvatarLoopView", 1, "[stopLoopAvatar] stopAnim");
            if (QZoneNavigatorAvatarLoopView.this.f56441e != null) {
                QZoneNavigatorAvatarLoopView.this.f56441e.setVisibility(8);
            }
            QZoneNavigatorAvatarLoopView.this.C = false;
            QZoneNavigatorAvatarLoopView.this.f56445m = false;
            if (QZoneNavigatorAvatarLoopView.this.f56442f != null) {
                QZoneNavigatorAvatarLoopView.this.f56442f.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QLog.d("QZoneNavigatorAvatarLoopView", 1, "[stopLoopAvatar] startAnim");
            if (QZoneNavigatorAvatarLoopView.this.f56442f != null) {
                QZoneNavigatorAvatarLoopView.this.f56442f.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    public QZoneNavigatorAvatarLoopView(Context context) {
        super(context);
        this.f56443h = new Runnable() { // from class: com.qzone.reborn.feedx.widget.navigator.e
            @Override // java.lang.Runnable
            public final void run() {
                QZoneNavigatorAvatarLoopView.this.v0();
            }
        };
        this.f56444i = new Runnable() { // from class: com.qzone.reborn.feedx.widget.navigator.f
            @Override // java.lang.Runnable
            public final void run() {
                QZoneNavigatorAvatarLoopView.this.u0();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0() {
        this.f56441e.J();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f56441e, "translationX", 0.0f, -100.0f);
        he0.b.m(ofFloat, R.anim.f154982up, 3.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f56441e, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        he0.b.m(ofFloat2, R.anim.f154982up, 3.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f56442f, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        he0.b.m(ofFloat3, R.anim.f154982up, 3.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        animatorSet.addListener(new a());
        animatorSet.start();
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f167308cm2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public void bindData(List<Long> list, int i3) {
        RFWThreadManager.getUIHandler().removeCallbacks(this.f56443h);
        if (this.f56441e == null || this.f56442f == null || ArrayUtils.isOutOfArrayIndex(0, list)) {
            return;
        }
        QLog.i("QZoneNavigatorAvatarLoopView", 1, "is loop playing is " + this.f56445m + ", is single playing " + this.C + ", is prevent playing " + this.D);
        if (!this.f56445m && !this.C && !this.D) {
            QLog.d("QZoneNavigatorAvatarLoopView", 1, "loop avatar is playing");
            this.D = true;
            RFWThreadManager.getInstance().runOnUiThread(this.f56444i, 500L);
            this.f56441e.K(list);
            this.f56441e.setVisibility(RFSafeListUtils.isEmpty(list) ? 8 : 0);
            this.f56441e.setTranslationX(0.0f);
            this.f56441e.setAlpha(1.0f);
            this.f56442f.setVisibility(8);
        }
        if (list == null || list.size() < 3) {
            return;
        }
        QLog.d("QZoneNavigatorAvatarLoopView", 1, "stop loop avatar is playing");
        this.C = true;
        QZoneUserAvatarView.b bVar = new QZoneUserAvatarView.b();
        bVar.f55960b = false;
        this.f56442f.setUser(list.get(0).longValue(), bVar);
        RFWThreadManager.getInstance().runOnUiThread(this.f56443h, 3400L);
    }

    public void s0() {
        if (this.f56443h != null) {
            RFWThreadManager.getInstance().remove(this.f56443h);
        }
        if (this.f56444i != null) {
            RFWThreadManager.getInstance().remove(this.f56444i);
        }
    }

    public void u0() {
        QLog.d("QZoneNavigatorAvatarLoopView", 1, "resetLoopAnimState");
        this.D = false;
    }

    public QZoneNavigatorAvatarLoopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f56443h = new Runnable() { // from class: com.qzone.reborn.feedx.widget.navigator.e
            @Override // java.lang.Runnable
            public final void run() {
                QZoneNavigatorAvatarLoopView.this.v0();
            }
        };
        this.f56444i = new Runnable() { // from class: com.qzone.reborn.feedx.widget.navigator.f
            @Override // java.lang.Runnable
            public final void run() {
                QZoneNavigatorAvatarLoopView.this.u0();
            }
        };
        initView();
    }

    private void initView() {
        QZoneAvatarLoopView qZoneAvatarLoopView = (QZoneAvatarLoopView) findViewById(R.id.f19034l);
        this.f56441e = qZoneAvatarLoopView;
        qZoneAvatarLoopView.setNeedAvatarClick(false);
        this.f56441e.setMaxAvatarCount(3);
        this.f56441e.setLoopWhenAudiencePositionEqualsAudienceCount(true);
        this.f56441e.setLoopDelayMs(ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID);
        this.f56441e.setLoopAnimationDuration(500);
        QZoneUserAvatarView qZoneUserAvatarView = (QZoneUserAvatarView) findViewById(R.id.f19044m);
        this.f56442f = qZoneUserAvatarView;
        qZoneUserAvatarView.setOnClickListener(null);
        this.f56442f.setClickable(false);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f56442f.getLayoutParams();
        layoutParams.gravity = 17;
        this.f56442f.setLayoutParams(layoutParams);
    }

    public QZoneNavigatorAvatarLoopView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f56443h = new Runnable() { // from class: com.qzone.reborn.feedx.widget.navigator.e
            @Override // java.lang.Runnable
            public final void run() {
                QZoneNavigatorAvatarLoopView.this.v0();
            }
        };
        this.f56444i = new Runnable() { // from class: com.qzone.reborn.feedx.widget.navigator.f
            @Override // java.lang.Runnable
            public final void run() {
                QZoneNavigatorAvatarLoopView.this.u0();
            }
        };
        initView();
    }
}
