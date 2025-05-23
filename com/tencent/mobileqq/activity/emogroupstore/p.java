package com.tencent.mobileqq.activity.emogroupstore;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.ao;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class p extends Drawable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private int f182160a;

    /* renamed from: b, reason: collision with root package name */
    private int f182161b;

    /* renamed from: c, reason: collision with root package name */
    private List<Drawable> f182162c;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f182163d;

    public p(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f182163d = qQAppInterface;
        }
    }

    public void a(List<Drawable> list, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list, i3);
            return;
        }
        this.f182162c = list;
        this.f182160a = i3;
        this.f182161b = i3 * 2;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) canvas);
            return;
        }
        Iterator<Drawable> it = this.f182162c.iterator();
        while (it.hasNext()) {
            Drawable a16 = ((ao) this.f182163d.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).f308430h.a(it.next(), this.f182160a);
            if (a16 != null) {
                int i3 = this.f182161b;
                a16.setBounds(0, 0, i3, i3);
                a16.draw(canvas);
                canvas.translate(this.f182160a, 0.0f);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) colorFilter);
        }
    }
}
