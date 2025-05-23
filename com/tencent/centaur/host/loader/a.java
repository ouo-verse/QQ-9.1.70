package com.tencent.centaur.host.loader;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Environment;
import android.os.Process;
import android.util.Log;
import androidx.annotation.NonNull;
import com.tencent.centaur.host.loader.inject.CentaurInjectFailException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a implements ComponentCallbacks {
    static IPatchRedirector $redirector_;
    private static volatile a C;

    /* renamed from: d, reason: collision with root package name */
    private final Set<Object> f99075d;

    /* renamed from: e, reason: collision with root package name */
    private final Set<Object> f99076e;

    /* renamed from: f, reason: collision with root package name */
    private final List<String> f99077f;

    /* renamed from: h, reason: collision with root package name */
    private final Set<String> f99078h;

    /* renamed from: i, reason: collision with root package name */
    private final Map<Integer, WeakReference<Activity>> f99079i;

    /* renamed from: m, reason: collision with root package name */
    private final Set<Integer> f99080m;

    /* compiled from: P */
    /* renamed from: com.tencent.centaur.host.loader.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1008a {
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f99075d = new LinkedHashSet();
        this.f99076e = new LinkedHashSet();
        this.f99077f = new ArrayList();
        this.f99078h = new HashSet();
        this.f99079i = new HashMap();
        this.f99080m = new HashSet();
        Log.i("CentaurLoader", "android.os.Process.myPid():" + Process.myPid());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ InterfaceC1008a a(a aVar) {
        aVar.getClass();
        return null;
    }

    public static a c() {
        if (C == null) {
            synchronized (a.class) {
                if (C == null) {
                    C = new a();
                }
            }
        }
        return C;
    }

    private void f(Context context) {
        try {
            b();
            e(context, new ArrayList(this.f99078h));
            e(context, new ArrayList(this.f99077f));
        } catch (Exception e16) {
            Log.e("CentaurLoader", "inject resources before plugin error: " + e16);
        }
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return false;
        }
        File file = new File(new File(Environment.getExternalStorageDirectory(), b.f99083b), "res.apk");
        if (!file.exists()) {
            return false;
        }
        this.f99078h.add(file.getAbsolutePath());
        return true;
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.f99077f.size();
    }

    public void e(Context context, List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context, (Object) list);
            return;
        }
        if (list != null && !list.isEmpty()) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                com.tencent.centaur.host.loader.inject.a.c(context, list);
                Log.i("CentaurLoader", "[resources] inject df plugin time cost: " + (System.currentTimeMillis() - currentTimeMillis));
            } catch (CentaurInjectFailException e16) {
                Log.e("CentaurLoader", "inject plugin resource error: ", e16);
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) configuration);
            return;
        }
        Iterator<WeakReference<Activity>> it = this.f99079i.values().iterator();
        while (it.hasNext()) {
            Activity activity = it.next().get();
            if (activity != null) {
                f(activity);
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        }
    }
}
