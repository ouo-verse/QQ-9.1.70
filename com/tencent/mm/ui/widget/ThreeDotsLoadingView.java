package com.tencent.mm.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ThreeDotsLoadingView extends FrameLayout {

    /* renamed from: i, reason: collision with root package name */
    public static int f152725i = -16777216;

    /* renamed from: a, reason: collision with root package name */
    public int f152726a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f152727b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f152728c;

    /* renamed from: d, reason: collision with root package name */
    public ViewGroup f152729d;

    /* renamed from: e, reason: collision with root package name */
    public ImageView f152730e;

    /* renamed from: f, reason: collision with root package name */
    public ImageView f152731f;

    /* renamed from: g, reason: collision with root package name */
    public ImageView f152732g;

    /* renamed from: h, reason: collision with root package name */
    public final Runnable f152733h;

    public ThreeDotsLoadingView(@NonNull Context context) {
        super(context);
        this.f152726a = f152725i;
        this.f152727b = false;
        this.f152728c = false;
        this.f152733h = new Runnable() { // from class: com.tencent.mm.ui.widget.ThreeDotsLoadingView.1
            @Override // java.lang.Runnable
            public void run() {
                ThreeDotsLoadingView.this.b();
                ((AnimationDrawable) ThreeDotsLoadingView.this.f152730e.getDrawable()).start();
                ((AnimationDrawable) ThreeDotsLoadingView.this.f152731f.getDrawable()).start();
                ((AnimationDrawable) ThreeDotsLoadingView.this.f152732g.getDrawable()).start();
            }
        };
        a(context, (AttributeSet) null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f152728c) {
            this.f152728c = false;
            startLoadingAnimation();
        }
    }

    @Override // android.view.View
    public void setAlpha(float f16) {
        this.f152730e.setAlpha(f16);
        this.f152731f.setAlpha(f16);
        this.f152732g.setAlpha(f16);
        if (getBackground() != null) {
            getBackground().setAlpha(Math.round(f16 * 255.0f));
        }
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        if (8 == i3 || 4 == i3) {
            stopLoadingAnimation();
        }
        super.setVisibility(i3);
    }

    public void startLoadingAnimation() {
        if (!ViewCompat.isAttachedToWindow(this)) {
            this.f152728c = true;
        } else {
            if (this.f152727b) {
                return;
            }
            this.f152727b = true;
            a();
            postDelayed(this.f152733h, 300L);
        }
    }

    public void stopLoadingAnimation() {
        this.f152728c = false;
        if (!this.f152727b) {
            return;
        }
        this.f152727b = false;
        removeCallbacks(this.f152733h);
        if (this.f152730e.getDrawable() instanceof AnimationDrawable) {
            ((AnimationDrawable) this.f152730e.getDrawable()).stop();
            ((AnimationDrawable) this.f152731f.getDrawable()).stop();
            ((AnimationDrawable) this.f152732g.getDrawable()).stop();
        }
    }

    public final void a(Context context, AttributeSet attributeSet) {
        this.f152729d = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.ffo, (ViewGroup) this, true);
        int color = context.getResources().getColor(R.color.b98);
        f152725i = color;
        this.f152726a = color;
        this.f152730e = (ImageView) this.f152729d.findViewById(R.id.ysj);
        this.f152731f = (ImageView) this.f152729d.findViewById(R.id.ysk);
        this.f152732g = (ImageView) this.f152729d.findViewById(R.id.ysl);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable.ThreeDotsLoadingView);
            this.f152726a = obtainStyledAttributes.getColor(com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable.ThreeDotsLoadingView_dotColor, f152725i);
            obtainStyledAttributes.recycle();
        }
        a();
    }

    public final void b() {
        this.f152730e.setImageDrawable(a(this.f152726a, new float[]{0.4f, 0.3f, 0.5f}));
        this.f152731f.setImageDrawable(a(this.f152726a, new float[]{0.5f, 0.4f, 0.3f}));
        this.f152732g.setImageDrawable(a(this.f152726a, new float[]{0.3f, 0.5f, 0.4f}));
    }

    public ThreeDotsLoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f152726a = f152725i;
        this.f152727b = false;
        this.f152728c = false;
        this.f152733h = new Runnable() { // from class: com.tencent.mm.ui.widget.ThreeDotsLoadingView.1
            @Override // java.lang.Runnable
            public void run() {
                ThreeDotsLoadingView.this.b();
                ((AnimationDrawable) ThreeDotsLoadingView.this.f152730e.getDrawable()).start();
                ((AnimationDrawable) ThreeDotsLoadingView.this.f152731f.getDrawable()).start();
                ((AnimationDrawable) ThreeDotsLoadingView.this.f152732g.getDrawable()).start();
            }
        };
        a(context, attributeSet);
    }

    public final void a() {
        this.f152730e.setImageDrawable(a(this.f152726a, 0.5f));
        this.f152731f.setImageDrawable(a(this.f152726a, 0.4f));
        this.f152732g.setImageDrawable(a(this.f152726a, 0.3f));
    }

    public ThreeDotsLoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i3) {
        super(context, attributeSet, i3);
        this.f152726a = f152725i;
        this.f152727b = false;
        this.f152728c = false;
        this.f152733h = new Runnable() { // from class: com.tencent.mm.ui.widget.ThreeDotsLoadingView.1
            @Override // java.lang.Runnable
            public void run() {
                ThreeDotsLoadingView.this.b();
                ((AnimationDrawable) ThreeDotsLoadingView.this.f152730e.getDrawable()).start();
                ((AnimationDrawable) ThreeDotsLoadingView.this.f152731f.getDrawable()).start();
                ((AnimationDrawable) ThreeDotsLoadingView.this.f152732g.getDrawable()).start();
            }
        };
        a(context, attributeSet);
    }

    public final AnimationDrawable a(int i3, float[] fArr) {
        AnimationDrawable animationDrawable = new AnimationDrawable();
        w.d("ThreeDotsLoadingView", "AnimationDrawable hash:" + animationDrawable.hashCode());
        animationDrawable.setOneShot(false);
        for (float f16 : fArr) {
            animationDrawable.addFrame(a(i3, f16), 300);
        }
        return animationDrawable;
    }

    @TargetApi(21)
    public ThreeDotsLoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i3, @StyleRes int i16) {
        super(context, attributeSet, i3, i16);
        this.f152726a = f152725i;
        this.f152727b = false;
        this.f152728c = false;
        this.f152733h = new Runnable() { // from class: com.tencent.mm.ui.widget.ThreeDotsLoadingView.1
            @Override // java.lang.Runnable
            public void run() {
                ThreeDotsLoadingView.this.b();
                ((AnimationDrawable) ThreeDotsLoadingView.this.f152730e.getDrawable()).start();
                ((AnimationDrawable) ThreeDotsLoadingView.this.f152731f.getDrawable()).start();
                ((AnimationDrawable) ThreeDotsLoadingView.this.f152732g.getDrawable()).start();
            }
        };
        a(context, attributeSet);
    }

    public final Drawable a(int i3, float f16) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.setIntrinsicHeight(32);
        shapeDrawable.setIntrinsicWidth(32);
        shapeDrawable.getPaint().setColor(i3);
        shapeDrawable.getPaint().setAlpha((int) (f16 * 255.0f));
        return shapeDrawable;
    }
}
