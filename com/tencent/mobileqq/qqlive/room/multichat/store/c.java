package com.tencent.mobileqq.qqlive.room.multichat.store;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes17.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Map<Integer, Pair<Drawable, Drawable>> f271666a;

    /* renamed from: b, reason: collision with root package name */
    private Map<Integer, Drawable> f271667b;

    /* renamed from: c, reason: collision with root package name */
    private URLDrawable.URLDrawableOptions f271668c;

    public c(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f271666a = new HashMap();
        this.f271667b = new HashMap();
        c(context);
    }

    private void c(Context context) {
        this.f271668c = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = context.getResources().getDrawable(R.drawable.lk6);
        URLDrawable.URLDrawableOptions uRLDrawableOptions = this.f271668c;
        uRLDrawableOptions.mFailedDrawable = drawable;
        uRLDrawableOptions.mLoadingDrawable = drawable;
    }

    public Drawable a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Drawable) iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        return this.f271667b.get(Integer.valueOf(i3));
    }

    public Pair<Drawable, Drawable> b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Pair) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        return this.f271666a.get(Integer.valueOf(i3));
    }
}
