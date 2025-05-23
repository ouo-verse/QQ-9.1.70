package com.tencent.ams.mosaic.jsengine.component.image;

import android.graphics.Movie;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f71166a;

    /* renamed from: b, reason: collision with root package name */
    public Movie f71167b;

    public b(String str, Movie movie) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) movie);
        } else {
            this.f71166a = str;
            this.f71167b = movie;
        }
    }

    public Movie a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Movie) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f71167b;
    }

    @NonNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "url = " + this.f71166a;
    }
}
