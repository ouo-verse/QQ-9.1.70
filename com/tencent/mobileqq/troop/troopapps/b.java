package com.tencent.mobileqq.troop.troopapps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class b {
    static IPatchRedirector $redirector_;
    protected boolean C;
    protected boolean D;
    protected int E;

    /* renamed from: d, reason: collision with root package name */
    protected long f299402d;

    /* renamed from: e, reason: collision with root package name */
    protected long f299403e;

    /* renamed from: f, reason: collision with root package name */
    protected SessionInfo f299404f;

    /* renamed from: h, reason: collision with root package name */
    protected TroopAppShortcutContainer f299405h;

    /* renamed from: i, reason: collision with root package name */
    protected Context f299406i;

    /* renamed from: m, reason: collision with root package name */
    protected Activity f299407m;

    public b(Context context, Activity activity, TroopAppShortcutContainer troopAppShortcutContainer, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, activity, troopAppShortcutContainer, bundle);
            return;
        }
        this.f299402d = 0L;
        this.f299403e = 0L;
        this.C = false;
        this.D = false;
        this.E = 0;
        this.f299406i = context;
        this.f299407m = activity;
        this.f299405h = troopAppShortcutContainer;
        if (bundle != null) {
            this.f299404f = (SessionInfo) bundle.getParcelable("sessionInfo");
            this.f299402d = bundle.getLong("troopUin", 0L);
            this.f299403e = bundle.getLong("troopClassExt", 0L);
            this.C = bundle.getBoolean("isNight", false);
            this.D = bundle.getBoolean("isAdminOrOwner", false);
            this.E = bundle.getInt("reportFrom");
        }
    }

    public abstract Object c();

    public abstract int d();

    public abstract View e(int i3, View view, ViewGroup viewGroup);

    public abstract void f(Object obj);
}
