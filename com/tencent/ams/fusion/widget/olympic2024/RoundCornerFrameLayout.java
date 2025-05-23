package com.tencent.ams.fusion.widget.olympic2024;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class RoundCornerFrameLayout extends FrameLayout {
    static IPatchRedirector $redirector_;
    private boolean mHasSetOutlineProvider;
    private final Path mPath;
    private float mRadius;

    public RoundCornerFrameLayout(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mRadius = 50.0f;
        this.mPath = new Path();
        this.mHasSetOutlineProvider = false;
    }

    private void updateCorner() {
        setOutlineProvider(new RoundViewOutlineProvider(this.mRadius));
        setClipToOutline(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas);
            return;
        }
        if (!this.mHasSetOutlineProvider) {
            int save = canvas.save();
            canvas.clipPath(this.mPath);
            super.dispatchDraw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            super.onSizeChanged(i3, i16, i17, i18);
            updateCorner();
        }
    }

    @Override // android.view.View
    public void setOutlineProvider(ViewOutlineProvider viewOutlineProvider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) viewOutlineProvider);
        } else {
            this.mHasSetOutlineProvider = true;
            super.setOutlineProvider(viewOutlineProvider);
        }
    }

    public void setRadius(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16));
            return;
        }
        this.mRadius = f16;
        updateCorner();
        invalidate();
    }
}
