package com.tencent.biz.pubaccount.weishi.verticalvideo.holder;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import com.tencent.biz.pubaccount.weishi.combo.home.rightpager.WSComboVerticalVideoProgressManager;
import com.tencent.biz.pubaccount.weishi.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSPlayerControlBar;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalVideoRelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

/* loaded from: classes32.dex */
public class WSVerticalItemVideoProgressController extends com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> {
    private static final int J = ScreenUtil.dip2px(2.5f);
    private static final int K = ScreenUtil.dip2px(5.5f);
    private WSVerticalVideoRelativeLayout C;
    private au D;
    private FrameLayout E;
    private WSPlayerControlBar F;
    private WSPlayerManager G;
    private boolean H;
    private final SeekBar.OnSeekBarChangeListener I;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements WSVerticalVideoRelativeLayout.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f82093a;

        a(Runnable runnable) {
            this.f82093a = runnable;
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0053, code lost:
        
            if (r14.getY() <= (r0.bottom + r4)) goto L16;
         */
        @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalVideoRelativeLayout.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            float f16;
            if (WSVerticalItemVideoProgressController.this.F != null) {
                Rect rect = new Rect();
                WSVerticalItemVideoProgressController.this.F.b(rect);
                if (!WSVerticalItemVideoProgressController.this.H) {
                    if (motionEvent.getAction() == 0 && motionEvent.getX() > rect.left && motionEvent.getX() < rect.right) {
                        float y16 = motionEvent.getY();
                        int i3 = rect.top;
                        int i16 = ba.f81734i;
                        if (y16 >= i3 - i16) {
                        }
                    }
                }
                if (!WSVerticalItemVideoProgressController.this.H) {
                    WSVerticalItemVideoProgressController.this.H = true;
                    WSVerticalItemVideoProgressController.this.F.f(this.f82093a);
                    WSVerticalItemVideoProgressController.this.F.setSeekBarActivated(true);
                    WSVerticalItemVideoProgressController.this.F.setThumb(WSVerticalItemVideoProgressController.this.e().getDrawable(R.drawable.n5u));
                    WSVerticalItemVideoProgressController.this.C.requestDisallowInterceptTouchEvent(true);
                }
                float height = rect.top + (rect.height() / 2.0f);
                float x16 = motionEvent.getX() - rect.left;
                if (x16 < 0.0f) {
                    f16 = 0.0f;
                } else {
                    f16 = x16 > ((float) rect.width()) ? rect.width() : x16;
                }
                MotionEvent obtain = MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), motionEvent.getAction(), f16, height, motionEvent.getMetaState());
                if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    WSVerticalItemVideoProgressController.this.F.postDelayed(this.f82093a, 400L);
                    WSVerticalItemVideoProgressController.this.H = false;
                    WSVerticalItemVideoProgressController.this.C.requestDisallowInterceptTouchEvent(false);
                }
                WSVerticalItemVideoProgressController.this.F.a(obtain);
                return true;
            }
            return false;
        }
    }

    public WSVerticalItemVideoProgressController(Context context, au auVar, WSVerticalVideoRelativeLayout wSVerticalVideoRelativeLayout) {
        super(context);
        WSVerticalPageFragment wSVerticalPageFragment;
        this.I = new b();
        this.D = auVar;
        this.C = wSVerticalVideoRelativeLayout;
        if (auVar == null || (wSVerticalPageFragment = auVar.f82128e) == null) {
            return;
        }
        this.G = wSVerticalPageFragment.U0();
    }

    private void C() {
        WSVerticalPageFragment wSVerticalPageFragment;
        au auVar = this.D;
        if (auVar == null || (wSVerticalPageFragment = auVar.f82128e) == null || wSVerticalPageFragment.getPresenter().t0()) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.F.getLayoutParams();
        layoutParams.bottomMargin = 0;
        this.F.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.E.getLayoutParams();
        layoutParams2.bottomMargin = -J;
        layoutParams2.height = K;
        this.E.setLayoutParams(layoutParams2);
    }

    private void F() {
        if (this.C == null) {
            return;
        }
        this.C.setDispatchTouchEventListener(new a(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.holder.WSVerticalItemVideoProgressController.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (WSVerticalItemVideoProgressController.this.F != null) {
                        WSVerticalItemVideoProgressController.this.F.setThumb(WSVerticalItemVideoProgressController.this.e().getDrawable(R.drawable.n5t));
                    }
                } catch (Exception e16) {
                    com.tencent.biz.pubaccount.weishi.util.x.f("WS_VIDEO_seekBar", "seekBar un active runnable error:" + e16);
                }
            }
        }));
    }

    public WSPlayerControlBar D() {
        return this.F;
    }

    public void E() {
        WSPlayerControlBar wSPlayerControlBar = this.F;
        if (wSPlayerControlBar != null) {
            wSPlayerControlBar.c();
        }
    }

    public boolean G() {
        return this.H || WSComboVerticalVideoProgressManager.INSTANCE.a().e();
    }

    public void H(float f16) {
        WSPlayerControlBar wSPlayerControlBar = this.F;
        if (wSPlayerControlBar != null) {
            wSPlayerControlBar.setProgress(f16);
        }
    }

    public void I() {
        WSPlayerControlBar wSPlayerControlBar = this.F;
        if (wSPlayerControlBar != null) {
            wSPlayerControlBar.g();
        }
    }

    public void J() {
        WSPlayerControlBar wSPlayerControlBar = this.F;
        if (wSPlayerControlBar != null) {
            wSPlayerControlBar.h();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
        J();
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.fwu;
    }

    /* loaded from: classes32.dex */
    class b implements SeekBar.OnSeekBarChangeListener {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar;
            if (seekBar == null || WSVerticalItemVideoProgressController.this.G == null || WSVerticalItemVideoProgressController.this.D == null || (jVar = (com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) WSVerticalItemVideoProgressController.this.D.f82129f) == null || jVar.e() == null) {
                return;
            }
            float progress = seekBar.getProgress();
            int i3 = jVar.e().video.duration;
            int i16 = (int) ((progress / 1000.0f) * i3);
            com.tencent.biz.pubaccount.weishi.util.x.i("WS_VIDEO_seekBar", "WSVerticalItemVideoProgressController onStopTrackingTouch() progress:" + progress + ", videoDuration:" + i3 + ", position:" + i16);
            WSVerticalItemVideoProgressController.this.G.P0(i16, true);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i3, boolean z16) {
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void h() {
        H(0.0f);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected void s() {
        this.E = (FrameLayout) p(R.id.f1182873q);
        WSPlayerControlBar wSPlayerControlBar = (WSPlayerControlBar) p(R.id.f1181873g);
        this.F = wSPlayerControlBar;
        wSPlayerControlBar.setSeekBarChangeListener(this.I);
        F();
        C();
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void g() {
    }
}
