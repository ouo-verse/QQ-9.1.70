package com.tencent.qqnt.indicators.magicindicator.buildins.commonnavigator.titles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes24.dex */
public class CommonPagerTitleView extends FrameLayout implements com.tencent.qqnt.indicators.magicindicator.buildins.commonnavigator.abs.b {
    static IPatchRedirector $redirector_;

    /* loaded from: classes24.dex */
    public interface a {
    }

    /* loaded from: classes24.dex */
    public interface b {
    }

    public CommonPagerTitleView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    @Override // com.tencent.qqnt.indicators.magicindicator.buildins.commonnavigator.abs.b
    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return getRight();
    }

    @Override // com.tencent.qqnt.indicators.magicindicator.buildins.commonnavigator.abs.b
    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return getBottom();
    }

    @Override // com.tencent.qqnt.indicators.magicindicator.buildins.commonnavigator.abs.b
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return getLeft();
    }

    @Override // com.tencent.qqnt.indicators.magicindicator.buildins.commonnavigator.abs.b
    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return getTop();
    }

    public void setContentPositionDataProvider(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) aVar);
        }
    }

    public void setContentView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            setContentView(view, null);
        } else {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view);
        }
    }

    public void setOnPagerTitleChangeListener(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) bVar);
        }
    }

    public void setContentView(View view, FrameLayout.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view, (Object) layoutParams);
            return;
        }
        removeAllViews();
        if (view != null) {
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            addView(view, layoutParams);
        }
    }

    public void setContentView(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            setContentView(LayoutInflater.from(getContext()).inflate(i3, (ViewGroup) null), null);
        } else {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        }
    }
}
