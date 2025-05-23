package com.qzone.personalize.music.ui;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import cooperation.qzone.util.QZLog;

/* loaded from: classes39.dex */
public class MiniMusicPlayerDIYBar extends MusicPlayerDIYBar {

    /* renamed from: s0, reason: collision with root package name */
    public static final int f49429s0 = ViewUtils.getScreenWidth() - ViewUtils.dpToPx(66.0f);

    /* renamed from: t0, reason: collision with root package name */
    public static final int f49430t0 = ViewUtils.getScreenHeight() - ViewUtils.dpToPx(150.0f);

    /* renamed from: i0, reason: collision with root package name */
    private int f49431i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f49432j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f49433k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f49434l0;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f49435m0;

    /* renamed from: n0, reason: collision with root package name */
    float f49436n0;

    /* renamed from: o0, reason: collision with root package name */
    float f49437o0;

    /* renamed from: p0, reason: collision with root package name */
    float f49438p0;

    /* renamed from: q0, reason: collision with root package name */
    float f49439q0;

    /* renamed from: r0, reason: collision with root package name */
    boolean f49440r0;

    public MiniMusicPlayerDIYBar(Context context, long j3) {
        super(context, j3);
        this.f49433k0 = f49429s0;
        this.f49434l0 = f49430t0;
        this.f49435m0 = true;
        this.f49437o0 = 0.0f;
        this.f49438p0 = 0.0f;
        this.f49439q0 = 0.0f;
        this.f49440r0 = false;
        setBackgroundDrawable(null);
    }

    private void U(MotionEvent motionEvent) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f49438p0 = x16;
            this.f49439q0 = y16;
            this.f49440r0 = false;
            QZLog.i("MiniMusicPlayerDIYBar", 4, "dispatchTouchEvent ACTION_DOWN ");
            return;
        }
        if (action == 1) {
            QZLog.i("MiniMusicPlayerDIYBar", 4, "dispatchTouchEvent ACTION_UP ");
            if (Math.abs(this.f49438p0 - x16) > ViewConfiguration.getTouchSlop() || Math.abs(this.f49439q0 - y16) > ViewConfiguration.getTouchSlop() || this.f49440r0) {
                return;
            }
            d();
            playSoundEffect(0);
            return;
        }
        if (action != 2) {
            return;
        }
        QZLog.i("MiniMusicPlayerDIYBar", 4, "dispatchTouchEvent ACTION_MOVE ");
        float f16 = this.f49438p0;
        if (f16 == x16 && this.f49439q0 == y16) {
            return;
        }
        this.f49440r0 = true;
        float f17 = x16 - f16;
        this.f49436n0 = f17;
        float f18 = y16 - this.f49439q0;
        this.f49437o0 = f18;
        int i3 = (int) (this.f49433k0 + f17);
        this.f49433k0 = i3;
        this.f49434l0 = (int) (this.f49434l0 + f18);
        if (i3 < 0) {
            this.f49433k0 = 0;
        }
        if (this.f49433k0 > ViewUtils.getScreenWidth() - ViewUtils.dpToPx(48.0f)) {
            this.f49433k0 = ViewUtils.getScreenWidth() - ViewUtils.dpToPx(48.0f);
        }
        if (this.f49434l0 < ViewUtils.dpToPx(75.0f)) {
            this.f49434l0 = ViewUtils.dpToPx(75.0f);
        }
        if (this.f49434l0 > ViewUtils.getScreenHeight() - ViewUtils.dpToPx(48.0f)) {
            this.f49434l0 = ViewUtils.getScreenHeight() - ViewUtils.dpToPx(48.0f);
        }
        setTranslationX(this.f49433k0);
        setTranslationY(this.f49434l0);
    }

    @Override // com.qzone.personalize.music.ui.MusicPlayerDIYBar, com.qzone.personalize.music.ui.HomepageMusicPlayerBar
    protected int G() {
        return R.layout.f169006bk4;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.f49435m0) {
            U(motionEvent);
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setInitLocation(int i3, int i16) {
        this.f49431i0 = i3;
        this.f49432j0 = i16;
        setTranslationX(i3);
        setTranslationY(i16);
    }

    public void V() {
        this.f49435m0 = false;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationX", this.f49431i0, this.f49433k0);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "translationY", this.f49432j0, this.f49434l0);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.start();
    }
}
