package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.widget.o;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopAppFormItem extends RelativeLayout {
    static IPatchRedirector $redirector_;
    String C;
    String D;
    int E;
    boolean F;

    /* renamed from: d, reason: collision with root package name */
    TextView f302440d;

    /* renamed from: e, reason: collision with root package name */
    TextView f302441e;

    /* renamed from: f, reason: collision with root package name */
    ImageView f302442f;

    /* renamed from: h, reason: collision with root package name */
    View f302443h;

    /* renamed from: i, reason: collision with root package name */
    RoundCornerImageView f302444i;

    /* renamed from: m, reason: collision with root package name */
    ImageView f302445m;

    public TroopAppFormItem(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        this.C = "";
        this.D = "";
        this.E = 0;
        this.F = true;
        b();
    }

    protected Drawable a(Resources resources, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Drawable) iPatchRedirector.redirect((short) 9, (Object) this, (Object) resources, i3);
        }
        return o.h(resources, i3, false, this.F);
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ahe, this);
        this.f302440d = (TextView) inflate.findViewById(R.id.f5e);
        this.f302441e = (TextView) inflate.findViewById(R.id.f166930j63);
        this.f302442f = (ImageView) inflate.findViewById(R.id.f166044e83);
        this.f302443h = inflate.findViewById(R.id.iaj);
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) inflate.findViewById(R.id.image);
        this.f302444i = roundCornerImageView;
        roundCornerImageView.setCorner(x.c(getContext(), 4.0f));
        this.f302445m = (ImageView) inflate.findViewById(R.id.dec);
    }

    public void setBgType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            if (i3 != 0 && i3 != 1 && i3 != 2 && i3 != 3) {
                throw new RuntimeException("Parameter bgType is illegal!");
            }
            setBackgroundDrawable(a(getResources(), i3));
        }
    }

    public void setUseCardStyleUI(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.F = z16;
        }
    }
}
