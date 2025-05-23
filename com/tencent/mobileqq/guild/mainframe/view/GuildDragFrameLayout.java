package com.tencent.mobileqq.guild.mainframe.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.guild.theme.QuiBitmapResourceObtainColorHelper;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.QLog;
import kotlin.g;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildDragFrameLayout extends DragFrameLayout {
    private final int C;
    private final int D;
    private final int E;
    private RectF F;
    private RectF G;
    private RectF H;
    private RectF I;
    private boolean J;
    private boolean K;
    private final Observer<Integer> L;

    /* renamed from: e, reason: collision with root package name */
    private final Paint f227730e;

    /* renamed from: f, reason: collision with root package name */
    private int f227731f;

    /* renamed from: h, reason: collision with root package name */
    private final int f227732h;

    /* renamed from: i, reason: collision with root package name */
    private final int f227733i;

    /* renamed from: m, reason: collision with root package name */
    private final int f227734m;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements Observer<Integer> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Integer num) {
            int i3 = GuildDragFrameLayout.this.f227731f;
            if (num != null) {
                GuildDragFrameLayout.this.f227731f = g.a(num.intValue(), 90);
                QLog.i("GuildDragFrameLayout", 1, "bg_bottom_standard(res:" + R.drawable.qui_common_bg_bottom_standard_bg + "):" + Integer.toHexString(num.intValue()));
            } else {
                GuildDragFrameLayout guildDragFrameLayout = GuildDragFrameLayout.this;
                guildDragFrameLayout.f227731f = guildDragFrameLayout.getResources().getColor(R.color.qui_common_fill_light_primary);
                QLog.i("GuildDragFrameLayout", 1, "fill_light_primary:" + Integer.toHexString(GuildDragFrameLayout.this.f227731f));
            }
            if (i3 != GuildDragFrameLayout.this.f227731f) {
                GuildDragFrameLayout.this.invalidate();
            }
        }
    }

    public GuildDragFrameLayout(Context context) {
        this(context, null, 0);
    }

    private int h() {
        LiveData<Integer> g16 = QuiBitmapResourceObtainColorHelper.g(getContext(), R.drawable.qui_common_bg_bottom_standard_bg);
        if (g16.getValue() != null) {
            return g.a(g16.getValue().intValue(), 90);
        }
        return getResources().getColor(R.color.qui_common_fill_light_primary);
    }

    private void i() {
        RectF rectF = this.I;
        if (rectF == null) {
            RectF rectF2 = this.F;
            float f16 = rectF2.right;
            int i3 = this.f227732h;
            float f17 = rectF2.bottom;
            this.I = new RectF(f16 - i3, f17 - i3, f16, f17);
            return;
        }
        RectF rectF3 = this.F;
        float f18 = rectF3.right;
        int i16 = this.f227732h;
        rectF.left = f18 - i16;
        float f19 = rectF3.bottom;
        rectF.top = f19 - i16;
        rectF.right = f18;
        rectF.bottom = f19;
    }

    private void j() {
        RectF rectF = this.H;
        if (rectF == null) {
            RectF rectF2 = this.F;
            float f16 = rectF2.left;
            float f17 = rectF2.bottom;
            int i3 = this.f227732h;
            this.H = new RectF(f16, f17 - i3, i3 + f16, f17);
            return;
        }
        RectF rectF3 = this.F;
        rectF.left = rectF3.left;
        float f18 = rectF3.bottom;
        int i16 = this.f227732h;
        rectF.top = f18 - i16;
        rectF.right = rectF3.left + i16;
        rectF.bottom = f18;
    }

    private void k() {
        RectF rectF = this.G;
        if (rectF == null) {
            RectF rectF2 = this.F;
            float f16 = rectF2.right;
            int i3 = this.f227732h;
            this.G = new RectF(f16 - i3, this.f227734m, f16, rectF2.top + i3);
            return;
        }
        RectF rectF3 = this.F;
        float f17 = rectF3.right;
        int i16 = this.f227732h;
        rectF.left = f17 - i16;
        rectF.top = this.f227734m;
        rectF.right = f17;
        rectF.bottom = rectF3.top + i16;
    }

    public void l() {
        this.F = null;
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        QuiBitmapResourceObtainColorHelper.g(getContext(), R.drawable.qui_common_bg_bottom_standard_bg).observeForever(this.L);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        QuiBitmapResourceObtainColorHelper.g(getContext(), R.drawable.qui_common_bg_bottom_standard_bg).removeObserver(this.L);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.J) {
            return;
        }
        if (!this.K) {
            this.f227730e.setColor(this.f227731f);
            canvas.drawRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), this.f227730e);
            return;
        }
        if (this.F == null) {
            this.F = new RectF(this.f227733i, this.f227734m, getWidth() - this.C, getHeight());
        }
        this.f227730e.setShader(null);
        this.f227730e.setColor(this.f227731f);
        this.f227730e.setShadowLayer(this.D, 0.0f, 0.0f, this.E);
        RectF rectF = this.F;
        int i3 = this.f227732h;
        canvas.drawRoundRect(rectF, i3, i3, this.f227730e);
        this.f227730e.reset();
        this.f227730e.setColor(this.f227731f);
        j();
        k();
        i();
        canvas.drawRect(this.G, this.f227730e);
        canvas.drawRect(this.H, this.f227730e);
        canvas.drawRect(this.I, this.f227730e);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        RectF rectF = this.F;
        if (rectF != null) {
            rectF.right = i3 - this.C;
            rectF.bottom = i16;
        }
        com.tencent.mobileqq.guild.mainframe.helper.a.d(i3);
    }

    public void setIsNeedDrawClip(boolean z16) {
        this.K = z16;
    }

    public void setNeedDrawCommonBg(boolean z16) {
        this.J = z16;
        invalidate();
    }

    public GuildDragFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GuildDragFrameLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.J = true;
        this.K = true;
        this.L = new a();
        Paint paint = new Paint();
        this.f227730e = paint;
        paint.setAntiAlias(true);
        this.f227732h = x.c(context, 8.0f);
        this.f227733i = x.c(context, 72.0f);
        this.C = 0;
        this.f227734m = x.c(context, 44.0f);
        this.D = x.c(context, 8.0f);
        this.E = Color.parseColor("#07000000");
        this.f227731f = h();
    }
}
