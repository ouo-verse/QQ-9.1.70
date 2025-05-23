package com.tencent.qqnt.indicators.magicindicator.buildins.commonnavigator.titles.badge;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.indicators.magicindicator.buildins.commonnavigator.abs.b;
import com.tencent.qqnt.indicators.magicindicator.buildins.commonnavigator.abs.c;

/* loaded from: classes24.dex */
public class BadgePagerTitleView extends FrameLayout implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private c f357099d;

    /* renamed from: e, reason: collision with root package name */
    private View f357100e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f357101f;

    public BadgePagerTitleView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f357101f = true;
        }
    }

    @Override // com.tencent.qqnt.indicators.magicindicator.buildins.commonnavigator.abs.b
    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        if (this.f357099d instanceof b) {
            return getLeft() + ((b) this.f357099d).a();
        }
        return getRight();
    }

    @Override // com.tencent.qqnt.indicators.magicindicator.buildins.commonnavigator.abs.b
    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        c cVar = this.f357099d;
        if (cVar instanceof b) {
            return ((b) cVar).b();
        }
        return getBottom();
    }

    @Override // com.tencent.qqnt.indicators.magicindicator.buildins.commonnavigator.abs.b
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        if (this.f357099d instanceof b) {
            return getLeft() + ((b) this.f357099d).c();
        }
        return getLeft();
    }

    @Override // com.tencent.qqnt.indicators.magicindicator.buildins.commonnavigator.abs.b
    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        c cVar = this.f357099d;
        if (cVar instanceof b) {
            return ((b) cVar).d();
        }
        return getTop();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        Object obj = this.f357099d;
        if ((obj instanceof View) && this.f357100e != null) {
            int[] iArr = new int[14];
            View view = (View) obj;
            iArr[0] = view.getLeft();
            iArr[1] = view.getTop();
            iArr[2] = view.getRight();
            iArr[3] = view.getBottom();
            c cVar = this.f357099d;
            if (cVar instanceof b) {
                b bVar = (b) cVar;
                iArr[4] = bVar.c();
                iArr[5] = bVar.d();
                iArr[6] = bVar.a();
                iArr[7] = bVar.b();
            } else {
                for (int i19 = 4; i19 < 8; i19++) {
                    iArr[i19] = iArr[i19 - 4];
                }
            }
            iArr[8] = view.getWidth() / 2;
            iArr[9] = view.getHeight() / 2;
            iArr[10] = iArr[4] / 2;
            iArr[11] = iArr[5] / 2;
            int i26 = iArr[6];
            iArr[12] = i26 + ((iArr[2] - i26) / 2);
            int i27 = iArr[7];
            iArr[13] = i27 + ((iArr[3] - i27) / 2);
        }
    }

    public void setAutoCancelBadge(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
        } else {
            this.f357101f = z16;
        }
    }

    public void setBadgeView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
            return;
        }
        if (this.f357100e == view) {
            return;
        }
        this.f357100e = view;
        removeAllViews();
        if (this.f357099d instanceof View) {
            addView((View) this.f357099d, new FrameLayout.LayoutParams(-1, -1));
        }
        if (this.f357100e != null) {
            addView(this.f357100e, new FrameLayout.LayoutParams(-2, -2));
        }
    }

    public void setInnerPagerTitleView(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) cVar);
            return;
        }
        if (this.f357099d == cVar) {
            return;
        }
        this.f357099d = cVar;
        removeAllViews();
        if (this.f357099d instanceof View) {
            addView((View) this.f357099d, new FrameLayout.LayoutParams(-1, -1));
        }
        if (this.f357100e != null) {
            addView(this.f357100e, new FrameLayout.LayoutParams(-2, -2));
        }
    }

    public void setXBadgeRule(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) aVar);
        }
    }

    public void setYBadgeRule(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) aVar);
        }
    }
}
