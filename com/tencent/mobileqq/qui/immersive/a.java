package com.tencent.mobileqq.qui.immersive;

import android.util.Pair;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public WeakReference<Window> f276874a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f276875b;

    /* renamed from: c, reason: collision with root package name */
    public List<WeakReference<View>> f276876c;

    /* renamed from: d, reason: collision with root package name */
    public Pair<Boolean, Integer> f276877d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f276878e;

    /* renamed from: f, reason: collision with root package name */
    public List<WeakReference<View>> f276879f;

    /* renamed from: g, reason: collision with root package name */
    public Pair<Boolean, Integer> f276880g;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
