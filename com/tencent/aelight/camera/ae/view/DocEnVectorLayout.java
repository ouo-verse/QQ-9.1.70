package com.tencent.aelight.camera.ae.view;

import android.content.Context;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes32.dex */
public class DocEnVectorLayout extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private View f65885d;

    /* renamed from: e, reason: collision with root package name */
    private View f65886e;

    public DocEnVectorLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        View view = this.f65885d;
        if (view != null && view.animate() != null) {
            this.f65885d.animate().cancel();
        }
        View view2 = this.f65886e;
        if (view2 == null || view2.animate() == null) {
            return;
        }
        this.f65886e.animate().cancel();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i3) {
        super.onVisibilityChanged(view, i3);
        if (i3 == 0) {
            Drawable background = getBackground();
            if (background instanceof AnimatedVectorDrawable) {
                ((AnimatedVectorDrawable) background).start();
                this.f65885d = findViewById(R.id.rvr);
                View findViewById = findViewById(R.id.s3k);
                this.f65886e = findViewById;
                View view2 = this.f65885d;
                if (view2 == null || findViewById == null) {
                    return;
                }
                view2.setAlpha(0.0f);
                this.f65886e.setAlpha(0.0f);
                this.f65885d.animate().alpha(1.0f).setDuration(200L).setStartDelay(360L).start();
                this.f65886e.animate().alpha(1.0f).setDuration(160L).setStartDelay(400L).start();
            }
        }
    }

    public DocEnVectorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DocEnVectorLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
