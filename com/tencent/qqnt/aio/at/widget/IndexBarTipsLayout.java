package com.tencent.qqnt.aio.at.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.x;

/* compiled from: P */
/* loaded from: classes23.dex */
public class IndexBarTipsLayout extends RelativeLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private IndexBarTipView f349498d;

    public IndexBarTipsLayout(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void b(Context context, AttributeSet attributeSet) {
        this.f349498d = new IndexBarTipView(context, attributeSet);
        addView(this.f349498d, new RelativeLayout.LayoutParams(-1, -2));
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        IndexBarTipView indexBarTipView = this.f349498d;
        if (indexBarTipView != null) {
            return indexBarTipView.c();
        }
        return "";
    }

    public void setText(String str, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Float.valueOf(f16));
            return;
        }
        this.f349498d.setText(str);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f349498d.getLayoutParams();
        layoutParams.topMargin = (int) ((f16 - (getWidth() / 2.0d)) + x.c(getContext(), 20.0f));
        this.f349498d.setLayoutParams(layoutParams);
    }

    public IndexBarTipsLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public IndexBarTipsLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            b(context, attributeSet);
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
