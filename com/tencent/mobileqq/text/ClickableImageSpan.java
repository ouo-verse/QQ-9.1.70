package com.tencent.mobileqq.text;

import android.R;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.StateSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ClickableImageSpan extends OffsetableImageSpan {
    static IPatchRedirector $redirector_;
    private static final int[] statePressed;
    private boolean beEnable;
    private ClickableImageSpanListener mClickListener;
    private Drawable mDrawable;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface ClickableImageSpanListener {
        void onClick(ClickableImageSpan clickableImageSpan);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51283);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            statePressed = new int[]{R.attr.state_pressed};
        }
    }

    public ClickableImageSpan(Drawable drawable, Drawable drawable2) {
        super(null, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) drawable, (Object) drawable2);
            return;
        }
        this.beEnable = true;
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(statePressed, drawable2);
        stateListDrawable.addState(StateSet.WILD_CARD, drawable);
        this.mDrawable = stateListDrawable;
        stateListDrawable.setBounds(0, 0, drawable2.getBounds().right, drawable2.getBounds().bottom);
    }

    @Override // android.text.style.ImageSpan, android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Drawable) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mDrawable;
    }

    public boolean isEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.beEnable;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action;
        ClickableImageSpanListener clickableImageSpanListener;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
        if (!this.beEnable || (action = motionEvent.getAction()) == 2) {
            return false;
        }
        if (action == 0) {
            this.mDrawable.setState(statePressed);
        } else {
            this.mDrawable.setState(StateSet.WILD_CARD);
        }
        if (action == 1 && (clickableImageSpanListener = this.mClickListener) != null) {
            clickableImageSpanListener.onClick(this);
        }
        view.invalidate();
        return true;
    }

    public void setClickListener(ClickableImageSpanListener clickableImageSpanListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) clickableImageSpanListener);
        } else {
            this.mClickListener = clickableImageSpanListener;
        }
    }

    public void setDisselected(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else {
            this.mDrawable.setState(StateSet.WILD_CARD);
            view.invalidate();
        }
    }

    public void setEnable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.beEnable = z16;
        }
    }

    public void setSelected(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        } else {
            this.mDrawable.setState(statePressed);
            view.invalidate();
        }
    }
}
