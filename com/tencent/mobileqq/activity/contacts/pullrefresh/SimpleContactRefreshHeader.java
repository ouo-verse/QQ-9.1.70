package com.tencent.mobileqq.activity.contacts.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.SimpleLottiePullRefreshHeader;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class SimpleContactRefreshHeader extends SimpleLottiePullRefreshHeader implements b, c {
    static IPatchRedirector $redirector_;
    private boolean D;
    private int E;
    private int F;

    public SimpleContactRefreshHeader(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void p(boolean z16) {
        this.D = z16;
    }

    @Override // com.tencent.mobileqq.activity.contacts.pullrefresh.c
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.pullrefresh.c
    public void e(int i3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17));
        } else if (!z16 && !this.D) {
            int i16 = this.E;
            j(3, Float.valueOf(((i3 - i16) / (this.F - i16)) / 2.0f));
        }
    }

    @Override // com.tencent.mobileqq.widget.SimpleLottiePullRefreshHeader, com.tencent.mobileqq.widget.q
    public Object f(int i3, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this, i3, obj);
        }
        Object f16 = super.f(i3, obj);
        if (f16 != null) {
            return f16;
        }
        if (i3 == 25) {
            return Integer.valueOf(this.F);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.widget.SimpleLottiePullRefreshHeader, com.tencent.mobileqq.widget.q
    public void j(int i3, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3, obj);
            return;
        }
        super.j(i3, obj);
        if (i3 == 18) {
            p(((Boolean) obj).booleanValue());
        } else if (i3 == 26) {
            onSpringBack();
        } else if (i3 == 3) {
            o(((Float) obj).floatValue());
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.pullrefresh.c
    public void onPrepare() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.pullrefresh.b
    public void onRefresh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.pullrefresh.c
    public void onRelease() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else if (!this.D) {
            this.D = true;
            h(0L);
        }
    }

    public SimpleContactRefreshHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public SimpleContactRefreshHeader(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.D = false;
        this.E = ViewUtils.dpToPx(26.0f);
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101640", false);
        if (QLog.isColorLevel()) {
            QLog.i("SimpleContactRefreshHeader", 1, "useNewPullRefreshView: " + isSwitchOn);
        }
        this.F = ViewUtils.dpToPx(isSwitchOn ? 82.0f : 60.0f);
        setBackgroundColor(getResources().getColor(R.color.skin_refresh_background));
    }
}
