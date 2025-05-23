package com.tencent.mobileqq.activity.newsetting.custom.item;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b extends d<ImageView> {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f183663f;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.newsetting.custom.item.d
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.a();
        Drawable drawable = this.f183663f;
        if (drawable != null) {
            i(drawable);
        }
    }

    public void i(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) drawable);
            return;
        }
        T t16 = this.f183667a;
        if (t16 != 0) {
            ((ImageView) t16).setImageDrawable(this.f183663f);
        }
        this.f183663f = drawable;
    }
}
