package com.tencent.timi.game.liveroom.impl.room.view.subscript;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewDebug;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;

/* compiled from: P */
/* loaded from: classes26.dex */
public class AnchorSubscriptMarqueeTextView extends AppCompatTextView implements Runnable {
    private boolean C;
    private int D;
    private int E;
    private a F;

    /* renamed from: h, reason: collision with root package name */
    private int f378899h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f378900i;

    /* renamed from: m, reason: collision with root package name */
    private int f378901m;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface a {
        void a();
    }

    public AnchorSubscriptMarqueeTextView(Context context) {
        this(context, null);
    }

    private void h() {
        this.f378900i = false;
        removeCallbacks(this);
        invalidate();
        this.f378899h = 0;
        postDelayed(this, 1200L);
    }

    public int e() {
        return (int) getPaint().measureText(getText().toString());
    }

    public void f() {
        this.f378900i = false;
        this.f378899h = 0;
        this.f378901m = 0;
        this.C = false;
        scrollTo(0, 0);
        if (getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
            if (layoutParams != null) {
                layoutParams.setMargins(0, 0, 0, 0);
                setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        if (getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.setMargins(0, 0, 0, 0);
                setLayoutParams(layoutParams2);
                return;
            }
            return;
        }
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.setMargins(0, 0, 0, 0);
            setLayoutParams(layoutParams3);
        }
    }

    public void g() {
        this.f378899h = 0;
        h();
    }

    @Override // android.view.View
    @ViewDebug.ExportedProperty(category = WSPublicAccReport.SOP_NAME_FOCUS)
    public boolean isFocused() {
        return false;
    }

    @Override // android.view.View
    @ViewDebug.ExportedProperty
    public boolean isSelected() {
        return false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this);
        this.f378900i = true;
        this.f378899h = 0;
        this.F = null;
        super.onDetachedFromWindow();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.C) {
            this.f378901m = e();
            this.C = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z16, int i3, Rect rect) {
        super.onFocusChanged(z16, i3, rect);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f378901m <= getWidth()) {
            a aVar = this.F;
            if (aVar != null) {
                aVar.a();
                return;
            }
            return;
        }
        if (this.f378900i) {
            return;
        }
        int i3 = this.f378899h + this.E;
        this.f378899h = i3;
        scrollTo(i3, 0);
        int width = getWidth();
        if (this.f378901m != 0 && getScrollX() >= this.f378901m - width) {
            this.f378900i = true;
            this.f378899h = 0;
            if (getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.setMargins(width - this.f378901m, 0, 0, 0);
                    setLayoutParams(layoutParams);
                    scrollTo(this.f378899h, 0);
                }
            } else if (getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.setMargins(width - this.f378901m, 0, 0, 0);
                    setLayoutParams(layoutParams2);
                    scrollTo(this.f378899h, 0);
                }
            } else {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) getLayoutParams();
                if (layoutParams3 != null) {
                    layoutParams3.setMargins(width - this.f378901m, 0, 0, 0);
                    setLayoutParams(layoutParams3);
                    scrollTo(this.f378899h, 0);
                }
            }
            a aVar2 = this.F;
            if (aVar2 != null) {
                aVar2.a();
                return;
            }
            return;
        }
        postDelayed(this, 42L);
    }

    public void setMarqueeVelocity(int i3) {
        this.E = i3;
    }

    public void setOnMarqueeCompleteListener(a aVar) {
        this.F = aVar;
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z16) {
        super.setSelected(z16);
    }

    public void stop() {
        removeCallbacks(this);
        this.f378900i = true;
        this.f378899h = 0;
        scrollTo(0, 0);
    }

    public AnchorSubscriptMarqueeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AnchorSubscriptMarqueeTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f378900i = false;
        this.C = false;
        this.D = 1;
        this.E = 1;
        this.D = getMarqueeRepeatLimit();
    }
}
