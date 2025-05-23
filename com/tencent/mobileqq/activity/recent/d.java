package com.tencent.mobileqq.activity.recent;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.PopupMenuDialog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    public static PopupMenuDialog.MenuItem f185382g;

    /* renamed from: h, reason: collision with root package name */
    public static PopupMenuDialog.MenuItem f185383h;

    /* renamed from: i, reason: collision with root package name */
    public static PopupMenuDialog.MenuItem f185384i;

    /* renamed from: a, reason: collision with root package name */
    public Activity f185385a;

    /* renamed from: b, reason: collision with root package name */
    private List<PopupMenuDialog.MenuItem> f185386b;

    /* renamed from: c, reason: collision with root package name */
    private PopupMenuDialog.OnDismissListener f185387c;

    /* renamed from: d, reason: collision with root package name */
    private PopupMenuDialog.OnClickActionListener f185388d;

    /* renamed from: e, reason: collision with root package name */
    private PopupMenuDialog f185389e;

    /* renamed from: f, reason: collision with root package name */
    RedTouch f185390f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69136);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f185382g = new PopupMenuDialog.MenuItem(R.id.azr, BaseApplication.getContext().getString(R.string.hxl), BaseApplication.getContext().getString(R.string.hxl), R.drawable.e_7);
        f185383h = new PopupMenuDialog.MenuItem(R.id.azs, BaseApplication.getContext().getString(R.string.hxm), BaseApplication.getContext().getString(R.string.hxm), R.drawable.e_6);
        f185384i = new PopupMenuDialog.MenuItem(R.id.azp, BaseApplication.getContext().getString(R.string.hxk), BaseApplication.getContext().getString(R.string.hxk), R.drawable.e_5);
    }

    public d(Activity activity, List<PopupMenuDialog.MenuItem> list, PopupMenuDialog.OnClickActionListener onClickActionListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, list, onClickActionListener);
            return;
        }
        this.f185390f = null;
        this.f185385a = activity;
        this.f185386b = list;
        this.f185388d = onClickActionListener;
    }

    private void b() {
        ArrayList arrayList = new ArrayList();
        List<PopupMenuDialog.MenuItem> list = this.f185386b;
        if (list != null && list.size() > 0) {
            for (int i3 = 0; i3 < this.f185386b.size(); i3++) {
                arrayList.add(this.f185386b.get(i3));
            }
        }
        this.f185389e = PopupMenuDialog.build(this.f185385a, arrayList, this.f185388d, this.f185387c);
    }

    @NonNull
    private boolean c() {
        PopupMenuDialog popupMenuDialog = this.f185389e;
        if (popupMenuDialog != null && popupMenuDialog.isShowing()) {
            return true;
        }
        return false;
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else if (c()) {
            this.f185389e.dismiss();
        }
    }

    public void d(View view, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, view, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            e(view, i3, i16, -1);
        }
    }

    public void e(View view, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        if (this.f185389e == null) {
            b();
        }
        this.f185389e.showAsDropDown(view, i3, i16);
    }
}
