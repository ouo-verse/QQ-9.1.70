package com.tencent.mobileqq.guild.discover.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildMineLightView extends View {
    private int C;
    private int D;
    private ValueAnimator E;
    private float F;
    private float G;
    private boolean H;

    /* renamed from: d, reason: collision with root package name */
    private Paint f216562d;

    /* renamed from: e, reason: collision with root package name */
    private Bitmap f216563e;

    /* renamed from: f, reason: collision with root package name */
    private Rect f216564f;

    /* renamed from: h, reason: collision with root package name */
    private RectF f216565h;

    /* renamed from: i, reason: collision with root package name */
    private float f216566i;

    /* renamed from: m, reason: collision with root package name */
    private int f216567m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<GuildMineLightView> f216568d;

        public a(GuildMineLightView guildMineLightView) {
            this.f216568d = new WeakReference<>(guildMineLightView);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WeakReference<GuildMineLightView> weakReference = this.f216568d;
            if (weakReference != null && weakReference.get() != null) {
                GuildMineLightView guildMineLightView = this.f216568d.get();
                guildMineLightView.G = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                guildMineLightView.postInvalidate();
            }
        }
    }

    public GuildMineLightView(@NonNull Context context) {
        super(context);
        this.f216567m = 80;
        this.C = 186;
        this.D = TVKQQLiveAssetPlayerMsg.PLAYER_INFO_REFRESH_PLAYER_WITH_REOPEN_START;
        this.H = false;
        d();
    }

    private Bitmap c() {
        GradientDrawable gradientDrawable = (GradientDrawable) getContext().getResources().getDrawable(R.drawable.guild_mine_light_bg);
        Bitmap createBitmap = Bitmap.createBitmap(this.C * 1, this.D * 1, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        gradientDrawable.setBounds(0, 0, this.C * 1, this.D * 1);
        gradientDrawable.draw(canvas);
        return createBitmap;
    }

    private void d() {
        this.f216563e = c();
        this.f216564f = new Rect(0, 0, this.f216563e.getWidth(), this.f216563e.getHeight());
        this.f216565h = new RectF();
        float f16 = -this.f216563e.getHeight();
        this.F = f16;
        this.G = f16;
        Paint paint = new Paint(1);
        this.f216562d = paint;
        paint.setDither(true);
    }

    private void e() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.F, this.f216566i);
        this.E = ofFloat;
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        this.E.setDuration(2000L);
        this.E.setRepeatCount(-1);
        this.E.addUpdateListener(new a(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        if (this.H) {
            return;
        }
        ValueAnimator valueAnimator = this.E;
        if (valueAnimator == null) {
            e();
        } else if (valueAnimator.isRunning()) {
            return;
        }
        this.E.start();
    }

    public void g() {
        this.H = false;
        post(new Runnable() { // from class: com.tencent.mobileqq.guild.discover.widget.b
            @Override // java.lang.Runnable
            public final void run() {
                GuildMineLightView.this.f();
            }
        });
    }

    public void h() {
        this.H = true;
        ValueAnimator valueAnimator = this.E;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.E.removeAllListeners();
            this.E.removeAllUpdateListeners();
            this.E.cancel();
        }
        this.G = this.F;
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.rotate(-this.f216567m);
        canvas.translate((-getWidth()) / 2, this.G);
        canvas.drawBitmap(this.f216563e, this.f216564f, this.f216565h, this.f216562d);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        double d16 = i3;
        this.f216566i = (float) (Math.sin(Math.atan(i16 / d16)) * d16 * 2.0d);
        if (i3 <= i16) {
            i3 = i16;
        }
        this.f216565h.set(-i3, 0.0f, i3 * 2, this.f216563e.getHeight());
    }

    public GuildMineLightView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        d();
    }

    public GuildMineLightView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f216567m = 80;
        this.C = 186;
        this.D = TVKQQLiveAssetPlayerMsg.PLAYER_INFO_REFRESH_PLAYER_WITH_REOPEN_START;
        this.H = false;
        d();
    }
}
