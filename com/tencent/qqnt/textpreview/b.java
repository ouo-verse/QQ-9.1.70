package com.tencent.qqnt.textpreview;

import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.selectable.g;
import com.tencent.qqnt.selectable.i;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static final int f362311b;

    /* renamed from: c, reason: collision with root package name */
    private static final int f362312c;

    /* renamed from: d, reason: collision with root package name */
    private static final int f362313d;

    /* renamed from: e, reason: collision with root package name */
    private static final int f362314e;

    /* renamed from: a, reason: collision with root package name */
    public int f362315a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30947);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f362311b = Color.rgb(123, 113, 30);
        f362312c = Color.argb(64, 125, 113, 30);
        f362313d = Color.rgb(162, 116, 4);
        f362314e = Color.argb(64, 213, 185, 118);
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f362315a = 0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private g a(View view) {
        if (view == 0) {
            return null;
        }
        if (view.getParent() instanceof g) {
            return (g) view.getParent();
        }
        if (!(view instanceof g)) {
            return null;
        }
        return (g) view;
    }

    public void b(View view, com.tencent.qqnt.textpreview.inject.a aVar, Integer num) {
        i c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, view, aVar, num);
            return;
        }
        g a16 = a(view);
        if (a16 != null && (c16 = a16.c()) != null && c16.c() && !a16.hasSelected()) {
            int i3 = this.f362315a;
            if (i3 == 2) {
                c16.a(f362313d);
                c16.e(f362314e);
            } else if (i3 == 1) {
                c16.a(f362311b);
                c16.e(f362312c);
            } else {
                Resources resources = view.getResources();
                int defaultColor = resources.getColorStateList(R.color.skin_aio_cursor_friend_color).getDefaultColor();
                int defaultColor2 = resources.getColorStateList(R.color.skin_aio_highlight_friend_color).getDefaultColor();
                c16.a(defaultColor);
                if (num != null) {
                    c16.e(num.intValue());
                } else {
                    c16.e(defaultColor2);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ChatAdapterSelectableHelper", 2, "Load Select color, cursor=" + defaultColor + ", component=" + defaultColor2);
                }
            }
            c16.g(aVar);
            a16.l(null);
        }
    }
}
