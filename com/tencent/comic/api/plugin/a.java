package com.tencent.comic.api.plugin;

import com.tencent.comic.api.IQQComicPluginUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    private static final ConcurrentHashMap<Integer, a> f99246i;

    /* renamed from: a, reason: collision with root package name */
    private final int f99247a;

    /* renamed from: b, reason: collision with root package name */
    private final int f99248b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f99249c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f99250d;

    /* renamed from: e, reason: collision with root package name */
    private int f99251e;

    /* renamed from: f, reason: collision with root package name */
    private int f99252f;

    /* renamed from: g, reason: collision with root package name */
    private String f99253g;

    /* renamed from: h, reason: collision with root package name */
    public com.tencent.mobileqq.hitrate.b f99254h;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33771);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f99246i = new ConcurrentHashMap<>();
        }
    }

    private void a() {
        if (!this.f99249c) {
            return;
        }
        ((IQQComicPluginUtil) QRoute.api(IQQComicPluginUtil.class)).reportHitRate(!this.f99250d ? 1 : 0, this.f99247a, this.f99248b, this.f99251e, this.f99253g, String.valueOf(this.f99252f));
        d();
    }

    public static a b(int i3) {
        return f99246i.get(Integer.valueOf(i3));
    }

    private void d() {
        this.f99249c = false;
        this.f99250d = false;
        this.f99251e = 0;
        this.f99253g = null;
        this.f99252f = 0;
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            if (!this.f99249c) {
                return;
            }
            this.f99250d = true;
            a();
        }
    }
}
