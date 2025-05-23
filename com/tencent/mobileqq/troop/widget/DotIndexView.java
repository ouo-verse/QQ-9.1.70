package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class DotIndexView extends LinearLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected LinearLayout f302292d;

    /* renamed from: e, reason: collision with root package name */
    protected int f302293e;

    /* renamed from: f, reason: collision with root package name */
    protected Context f302294f;

    /* renamed from: h, reason: collision with root package name */
    protected int f302295h;

    /* renamed from: i, reason: collision with root package name */
    protected int f302296i;

    public DotIndexView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f302293e = R.drawable.a7z;
        this.f302295h = 0;
        this.f302296i = 8;
        LinearLayout linearLayout = new LinearLayout(context);
        this.f302292d = linearLayout;
        this.f302294f = linearLayout.getContext();
    }

    public void setDotDrawable(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        if (this.f302293e != i3) {
            this.f302293e = i3;
            if (this.f302292d != null && this.f302295h != 0) {
                Drawable drawable = this.f302294f.getResources().getDrawable(this.f302293e);
                for (int i16 = 0; i16 < this.f302295h; i16++) {
                    View childAt = this.f302292d.getChildAt(i16);
                    if (childAt != null && (childAt instanceof ImageView)) {
                        ((ImageView) childAt).setImageDrawable(drawable);
                    }
                }
            }
        }
    }

    public void setDotSelected(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (this.f302292d == null) {
            return;
        }
        if (z16) {
            for (int i16 = 0; i16 < this.f302295h; i16++) {
                if (this.f302292d.getChildAt(i16) != null) {
                    this.f302292d.getChildAt(i16).setSelected(false);
                }
            }
        }
        if (this.f302292d.getChildAt(i3) != null) {
            this.f302292d.getChildAt(i3).setSelected(z16);
        }
    }

    public void setMargin(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.f302296i = i3;
        }
    }

    public DotIndexView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        this.f302293e = R.drawable.a7z;
        this.f302295h = 0;
        this.f302296i = 8;
        LinearLayout linearLayout = new LinearLayout(context);
        this.f302292d = linearLayout;
        this.f302294f = linearLayout.getContext();
    }
}
