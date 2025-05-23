package com.tencent.icgame.game.liveroom.impl.room.view.subscript;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ViewFlipper;
import com.tencent.icgame.game.liveroom.impl.room.view.subscript.AnchorSubscriptMarqueeTextView;
import com.tencent.icgame.trpc.yes.common.PendantOuterClass$PendantMsgSubscript;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes7.dex */
public class AnchorSubscriptViewFlipper extends FrameLayout {
    private boolean C;
    private Runnable D;
    private Animation.AnimationListener E;
    private Animation.AnimationListener F;
    AnchorSubscriptMarqueeTextView.a G;

    /* renamed from: d, reason: collision with root package name */
    private Context f115778d;

    /* renamed from: e, reason: collision with root package name */
    private View f115779e;

    /* renamed from: f, reason: collision with root package name */
    private ViewFlipper f115780f;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<AnchorSubscriptMarqueeTextView> f115781h;

    /* renamed from: i, reason: collision with root package name */
    private AnchorSubscriptMarqueeTextView f115782i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f115783m;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class c implements AnchorSubscriptMarqueeTextView.a {
        c() {
        }

        @Override // com.tencent.icgame.game.liveroom.impl.room.view.subscript.AnchorSubscriptMarqueeTextView.a
        public void a() {
            if (AnchorSubscriptViewFlipper.this.f115780f != null) {
                AnchorSubscriptViewFlipper.this.g();
            }
        }
    }

    public AnchorSubscriptViewFlipper(Context context) {
        super(context);
        this.f115781h = new ArrayList<>();
        this.f115783m = false;
        this.C = false;
        this.D = new Runnable() { // from class: com.tencent.icgame.game.liveroom.impl.room.view.subscript.AnchorSubscriptViewFlipper.1
            @Override // java.lang.Runnable
            public void run() {
                if (AnchorSubscriptViewFlipper.this.f115780f != null) {
                    AnchorSubscriptViewFlipper.this.f115780f.showNext();
                }
            }
        };
        this.E = new a();
        this.F = new b();
        this.G = new c();
        this.f115778d = context;
        e();
    }

    private AnchorSubscriptMarqueeTextView d() {
        AnchorSubscriptMarqueeTextView anchorSubscriptMarqueeTextView = new AnchorSubscriptMarqueeTextView(getContext());
        anchorSubscriptMarqueeTextView.setSingleLine(true);
        anchorSubscriptMarqueeTextView.setTextColor(-1);
        anchorSubscriptMarqueeTextView.setTextSize(1, 10.0f);
        anchorSubscriptMarqueeTextView.setMinWidth(ViewUtils.dip2px(30.0f));
        anchorSubscriptMarqueeTextView.setGravity(16);
        anchorSubscriptMarqueeTextView.setFocusableInTouchMode(true);
        anchorSubscriptMarqueeTextView.setFocusable(true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 16;
        anchorSubscriptMarqueeTextView.setLayoutParams(layoutParams);
        return anchorSubscriptMarqueeTextView;
    }

    private void e() {
        Context context = this.f115778d;
        if (context == null) {
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.fac, (ViewGroup) this, true);
        this.f115779e = inflate;
        ViewFlipper viewFlipper = (ViewFlipper) inflate.findViewById(R.id.kwa);
        this.f115780f = viewFlipper;
        viewFlipper.getInAnimation().setAnimationListener(this.E);
        this.f115780f.getOutAnimation().setAnimationListener(this.F);
    }

    private void f(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.f115778d == null) {
            return;
        }
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.D);
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.D, 2000L);
    }

    public void c() {
        h();
        this.f115778d = null;
        this.f115779e = null;
        ViewFlipper viewFlipper = this.f115780f;
        if (viewFlipper != null) {
            viewFlipper.getInAnimation().setAnimationListener(null);
            this.f115780f.getOutAnimation().setAnimationListener(null);
        }
        this.f115780f = null;
        this.f115781h.clear();
    }

    public void h() {
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.D);
        AnchorSubscriptMarqueeTextView anchorSubscriptMarqueeTextView = this.f115782i;
        if (anchorSubscriptMarqueeTextView != null) {
            anchorSubscriptMarqueeTextView.stop();
        }
        ViewFlipper viewFlipper = this.f115780f;
        if (viewFlipper != null) {
            viewFlipper.stopFlipping();
        }
        this.C = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        this.f115783m = false;
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f115783m = true;
        c();
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.D);
        super.onDetachedFromWindow();
    }

    public void setData(PendantOuterClass$PendantMsgSubscript pendantOuterClass$PendantMsgSubscript) {
        AnchorSubscriptMarqueeTextView d16;
        if (this.f115778d != null && pendantOuterClass$PendantMsgSubscript != null) {
            h();
            int i3 = 0;
            while (i3 < pendantOuterClass$PendantMsgSubscript.text_list.size()) {
                String str = pendantOuterClass$PendantMsgSubscript.text_list.get(i3);
                int i16 = i3 + 1;
                if (this.f115781h.size() > i16) {
                    d16 = this.f115781h.get(i3);
                    f(d16);
                } else {
                    d16 = d();
                    this.f115781h.add(d16);
                }
                d16.setText(str);
                setTextMarquee(d16);
                this.f115780f.addView(d16);
                if (i3 == 0) {
                    this.f115782i = d16;
                }
                i3 = i16;
            }
            if (this.f115781h.size() > pendantOuterClass$PendantMsgSubscript.text_list.size()) {
                for (int size = pendantOuterClass$PendantMsgSubscript.text_list.size(); size < this.f115781h.size(); size++) {
                    f(this.f115781h.get(size));
                }
            }
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        ViewFlipper viewFlipper = this.f115780f;
        if (viewFlipper != null) {
            viewFlipper.setOnClickListener(onClickListener);
        }
    }

    public void setTextMarquee(AnchorSubscriptMarqueeTextView anchorSubscriptMarqueeTextView) {
        if (anchorSubscriptMarqueeTextView != null) {
            anchorSubscriptMarqueeTextView.setSingleLine(true);
            anchorSubscriptMarqueeTextView.setOnMarqueeCompleteListener(this.G);
        }
    }

    public AnchorSubscriptViewFlipper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f115781h = new ArrayList<>();
        this.f115783m = false;
        this.C = false;
        this.D = new Runnable() { // from class: com.tencent.icgame.game.liveroom.impl.room.view.subscript.AnchorSubscriptViewFlipper.1
            @Override // java.lang.Runnable
            public void run() {
                if (AnchorSubscriptViewFlipper.this.f115780f != null) {
                    AnchorSubscriptViewFlipper.this.f115780f.showNext();
                }
            }
        };
        this.E = new a();
        this.F = new b();
        this.G = new c();
        this.f115778d = context;
        e();
    }

    public AnchorSubscriptViewFlipper(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f115781h = new ArrayList<>();
        this.f115783m = false;
        this.C = false;
        this.D = new Runnable() { // from class: com.tencent.icgame.game.liveroom.impl.room.view.subscript.AnchorSubscriptViewFlipper.1
            @Override // java.lang.Runnable
            public void run() {
                if (AnchorSubscriptViewFlipper.this.f115780f != null) {
                    AnchorSubscriptViewFlipper.this.f115780f.showNext();
                }
            }
        };
        this.E = new a();
        this.F = new b();
        this.G = new c();
        this.f115778d = context;
        e();
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            AnchorSubscriptMarqueeTextView anchorSubscriptMarqueeTextView;
            if (AnchorSubscriptViewFlipper.this.f115780f != null && (anchorSubscriptMarqueeTextView = (AnchorSubscriptMarqueeTextView) AnchorSubscriptViewFlipper.this.f115780f.getCurrentView()) != null) {
                anchorSubscriptMarqueeTextView.g();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (AnchorSubscriptViewFlipper.this.f115780f == null) {
                return;
            }
            int displayedChild = AnchorSubscriptViewFlipper.this.f115780f.getDisplayedChild() - 1;
            if (displayedChild < 0) {
                displayedChild = 2;
            }
            AnchorSubscriptMarqueeTextView anchorSubscriptMarqueeTextView = (AnchorSubscriptMarqueeTextView) AnchorSubscriptViewFlipper.this.f115780f.getChildAt(displayedChild);
            if (anchorSubscriptMarqueeTextView != null) {
                anchorSubscriptMarqueeTextView.f();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
