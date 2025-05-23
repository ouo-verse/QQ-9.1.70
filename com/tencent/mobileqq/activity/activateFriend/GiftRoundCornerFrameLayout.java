package com.tencent.mobileqq.activity.activateFriend;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes9.dex */
public class GiftRoundCornerFrameLayout extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private Path f177851d;

    /* renamed from: e, reason: collision with root package name */
    private RectF f177852e;

    /* renamed from: f, reason: collision with root package name */
    private float f177853f;

    public GiftRoundCornerFrameLayout(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f177853f = ViewUtils.dpToPx(4.0f);
            a();
        }
    }

    private void a() {
        this.f177851d = new Path();
        this.f177852e = new RectF();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas);
            return;
        }
        this.f177851d.reset();
        this.f177852e.set(0.0f, 0.0f, getWidth(), getHeight());
        Path path = this.f177851d;
        RectF rectF = this.f177852e;
        float f16 = this.f177853f;
        path.addRoundRect(rectF, f16, f16, Path.Direction.CW);
        canvas.clipPath(this.f177851d);
        super.dispatchDraw(canvas);
    }

    public GiftRoundCornerFrameLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.f177853f = ViewUtils.dpToPx(4.0f);
            a();
        }
    }

    public GiftRoundCornerFrameLayout(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.f177853f = ViewUtils.dpToPx(4.0f);
            a();
        }
    }
}
