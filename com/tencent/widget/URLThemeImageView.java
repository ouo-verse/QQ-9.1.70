package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.widget.ThemeImageWrapper;

/* compiled from: P */
/* loaded from: classes27.dex */
public class URLThemeImageView extends URLImageView implements ThemeImageWrapper.DrawInterface {
    static IPatchRedirector $redirector_;
    public ThemeImageWrapper themeImageWrapper;

    public URLThemeImageView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    protected void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            setSupportMaskView(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) canvas);
            return;
        }
        ThemeImageWrapper themeImageWrapper = this.themeImageWrapper;
        if (themeImageWrapper != null) {
            themeImageWrapper.onDraw(canvas, this);
        } else {
            super.onDraw(canvas);
        }
    }

    public void setSupportMaskView(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        if (z16) {
            if (this.themeImageWrapper == null) {
                this.themeImageWrapper = new ThemeImageWrapper();
            }
            this.themeImageWrapper.setSupportMaskView(true);
        } else {
            ThemeImageWrapper themeImageWrapper = this.themeImageWrapper;
            if (themeImageWrapper != null) {
                themeImageWrapper.setSupportMaskView(false);
            }
        }
    }

    @Override // com.tencent.widget.ThemeImageWrapper.DrawInterface
    public void superOnDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
        } else {
            super.onDraw(canvas);
        }
    }

    public URLThemeImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public URLThemeImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            init();
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
