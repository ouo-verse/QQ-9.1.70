package com.tencent.av.ui.effect.view;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes3.dex */
public class EffectMaterialBaseImageView extends ImageView {

    /* renamed from: d, reason: collision with root package name */
    protected boolean f75580d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f75581e;

    /* renamed from: f, reason: collision with root package name */
    protected Paint f75582f;

    /* renamed from: h, reason: collision with root package name */
    protected int f75583h;

    /* renamed from: i, reason: collision with root package name */
    protected int f75584i;

    /* renamed from: m, reason: collision with root package name */
    protected int f75585m;

    public EffectMaterialBaseImageView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 0) {
            setAlpha(0.5f);
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            setAlpha(1.0f);
        }
        return true;
    }

    public void setDimmed(boolean z16) {
        this.f75581e = z16;
        invalidate();
    }

    public void setDimmedColor(int i3) {
        this.f75585m = i3;
    }

    public void setHighlight(boolean z16) {
        this.f75580d = z16;
        invalidate();
    }

    public EffectMaterialBaseImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EffectMaterialBaseImageView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f75580d = false;
        this.f75581e = false;
        this.f75583h = 3;
        this.f75584i = 3;
        this.f75585m = -15550475;
        this.f75582f = new Paint();
    }
}
