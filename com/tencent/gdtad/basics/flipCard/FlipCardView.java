package com.tencent.gdtad.basics.flipCard;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.gdtad.basics.adshake.RotationSensor;
import com.tencent.gdtad.basics.adshake.animatorview.AnimatorView;
import com.tencent.gdtad.basics.flipCard.FlipCardInteractiveListener;

/* compiled from: P */
/* loaded from: classes6.dex */
public class FlipCardView extends FrameLayout implements RotationSensor.OnRotationChangeListener {
    private boolean C;

    @FlipCardInteractiveListener.FailReason
    private int D;
    private final Handler E;

    /* renamed from: d, reason: collision with root package name */
    private final RotationSensor f108788d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private final AnimatorView f108789e;

    /* renamed from: f, reason: collision with root package name */
    private float f108790f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f108791h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f108792i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f108793m;

    /* compiled from: P */
    /* renamed from: com.tencent.gdtad.basics.flipCard.FlipCardView$3, reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass3 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ lm0.a f108794d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f108795e;
        final /* synthetic */ FlipCardView this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.f108794d.postRotationY(this.f108795e);
            throw null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            sendEmptyMessageDelayed(0, 1000L);
        }
    }

    public FlipCardView(@NonNull Context context) {
        super(context);
        this.f108790f = 0.0f;
        this.D = 0;
        this.E = new a(Looper.getMainLooper());
        AnimatorView animatorView = new AnimatorView(context);
        this.f108789e = animatorView;
        addView(animatorView, new ViewGroup.LayoutParams(-1, -1));
        this.f108788d = new RotationSensor(context);
    }

    private boolean a(float f16, float f17) {
        return false;
    }

    public void b() {
        com.tencent.xaction.log.b.a("FlipCardView", 1, "start " + getWidth() + " " + getHeight());
        com.tencent.xaction.log.b.a("FlipCardView", 1, "start failed: card info not set");
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f108793m) {
            boolean a16 = a(motionEvent.getX(), motionEvent.getY());
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    boolean z16 = this.C;
                }
            } else if (a16) {
                this.C = true;
                return true;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f108788d.setOnRotationChangeListener(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f108788d.setOnRotationChangeListener(null);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        com.tencent.xaction.log.b.a("FlipCardView", 1, "onSizeChanged w:" + i3 + ", h:" + i16 + ", oldw:" + i17 + ", oldh:" + i18);
        super.onSizeChanged(i3, i16, i17, i18);
        if (this.f108789e.isUserStarted() && !this.f108792i) {
            b();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f108792i) {
            return super.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setFlipCardInfo(FlipCardInfo flipCardInfo) {
        this.f108791h = com.tencent.gdtad.basics.flipCard.a.b(flipCardInfo);
    }

    @Override // com.tencent.gdtad.basics.adshake.RotationSensor.OnRotationChangeListener
    public void onError() {
    }

    public void setBonusPageClickListener(b bVar) {
    }

    public void setInteractiveListener(FlipCardInteractiveListener flipCardInteractiveListener) {
    }

    @Override // com.tencent.gdtad.basics.adshake.RotationSensor.OnRotationChangeListener
    public void onChanged(float f16, float f17, float f18) {
    }
}
