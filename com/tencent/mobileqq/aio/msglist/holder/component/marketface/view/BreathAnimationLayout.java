package com.tencent.mobileqq.aio.msglist.holder.component.marketface.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.RemoteViews;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@RemoteViews.RemoteView
/* loaded from: classes11.dex */
public class BreathAnimationLayout extends RelativeLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private boolean f191157d;

    /* renamed from: e, reason: collision with root package name */
    private long f191158e;

    public BreathAnimationLayout(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f191157d = false;
            this.f191158e = -1L;
        }
    }

    @Override // android.view.View
    @TargetApi(21)
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        if (this.f191157d) {
            Drawable background = getBackground();
            if (background != null) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                if (this.f191158e == -1) {
                    this.f191158e = currentAnimationTimeMillis;
                }
                int min = Math.min(255, (int) ((((Math.sin((((currentAnimationTimeMillis - this.f191158e) % 1600) / 1600.0d) * 6.283185307179586d) + 1.0d) / 2.0d) * 255.0d) + 0.5d));
                background.setBounds(0, 0, getWidth(), getHeight());
                background.setState(View.PRESSED_ENABLED_STATE_SET);
                background.draw(canvas);
                int saveLayerAlpha = canvas.saveLayerAlpha(0.0f, 0.0f, getWidth(), getHeight(), min);
                background.setState(View.EMPTY_STATE_SET);
                background.draw(canvas);
                canvas.restoreToCount(saveLayerAlpha);
                return;
            }
            return;
        }
        super.draw(canvas);
    }

    public void setAnimating(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        if (this.f191157d != z16) {
            this.f191157d = z16;
            this.f191158e = -1L;
            if (!z16) {
                refreshDrawableState();
            }
            invalidate();
        }
    }

    public BreathAnimationLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.f191157d = false;
            this.f191158e = -1L;
        }
    }

    public BreathAnimationLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.f191157d = false;
            this.f191158e = -1L;
        }
    }
}
