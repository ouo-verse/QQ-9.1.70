package com.tencent.tdf.view;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public class NativeViewDelegate implements INativeViewDelegate {
    static IPatchRedirector $redirector_;
    private View mTargetView;

    public NativeViewDelegate(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
        } else {
            this.mTargetView = view;
        }
    }

    @Override // com.tencent.tdf.view.INativeViewDelegate
    public void deleteView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            ((ViewGroup) this.mTargetView).removeView(view);
        }
    }

    @Override // com.tencent.tdf.view.INativeViewDelegate
    public Rect getLayoutRect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Rect) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new Rect(this.mTargetView.getLeft(), this.mTargetView.getTop(), this.mTargetView.getWidth(), this.mTargetView.getHeight());
    }

    @Override // com.tencent.tdf.view.INativeViewDelegate
    public void insertView(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, i3);
        } else {
            ((ViewGroup) this.mTargetView).addView(view, i3);
        }
    }

    @Override // com.tencent.tdf.view.INativeViewDelegate
    public void onDispose() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // com.tencent.tdf.view.INativeViewDelegate
    public void updateLayoutParams(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mTargetView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(i17, i18);
        } else {
            layoutParams.width = i17;
            layoutParams.height = i18;
        }
        layoutParams.leftMargin = i3;
        layoutParams.topMargin = i16;
        this.mTargetView.setLayoutParams(layoutParams);
    }
}
