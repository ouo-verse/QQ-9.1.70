package com.tencent.mobileqq.qqlive.room.multichat.view.entrance;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ChooseSeatItemView extends RelativeLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f271698d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f271699e;

    /* renamed from: f, reason: collision with root package name */
    private int f271700f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.qqlive.room.multichat.store.c f271701h;

    public ChooseSeatItemView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            c();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private void c() {
        View.inflate(getContext(), R.layout.h_6, this);
        this.f271698d = (ImageView) findViewById(R.id.f81424e5);
        this.f271699e = (TextView) findViewById(R.id.f81544eg);
    }

    public void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
            return;
        }
        setSelected(z16);
        if (z16) {
            this.f271699e.setTextColor(-1);
            this.f271698d.setImageDrawable((Drawable) this.f271701h.b(this.f271700f).second);
        } else {
            this.f271699e.setTextColor(822083583);
            this.f271698d.setImageDrawable((Drawable) this.f271701h.b(this.f271700f).first);
        }
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f271700f;
    }

    public void setSeatNo(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.f271700f = i3;
        }
    }

    public ChooseSeatItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            c();
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public ChooseSeatItemView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            c();
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
