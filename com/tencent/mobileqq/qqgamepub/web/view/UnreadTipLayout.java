package com.tencent.mobileqq.qqgamepub.web.view;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes16.dex */
public class UnreadTipLayout extends TextView {
    static IPatchRedirector $redirector_;

    public UnreadTipLayout(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            a();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private void a() {
        setBackgroundDrawable(getResources().getDrawable(R.drawable.l0y));
        setVisibility(4);
    }

    public long b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationX", 0.0f, 20.0f, 0.0f);
        ofFloat.setDuration(400L);
        ofFloat.setRepeatCount(5);
        ofFloat.setRepeatMode(1);
        ofFloat.start();
        return ofFloat.getDuration() * ofFloat.getRepeatCount();
    }

    public void setUnreadNum(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            setText(String.format(getContext().getString(R.string.f1766131q), Integer.valueOf(i3)));
        }
    }

    public UnreadTipLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            a();
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public UnreadTipLayout(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            a();
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
