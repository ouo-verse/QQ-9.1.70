package com.tencent.biz.qqcircle.drawer;

import java.util.List;
import trpcprotocol.feedcloud.sidebar.Drawer;
import trpcprotocol.feedcloud.sidebar.DrawerType;
import trpcprotocol.feedcloud.sidebar.JumpInfo;
import trpcprotocol.feedcloud.sidebar.Navbar;
import trpcprotocol.feedcloud.sidebar.RedInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final Drawer f84394a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f84395b = false;

    public f(Drawer drawer) {
        this.f84394a = drawer;
    }

    public Drawer a() {
        return this.f84394a;
    }

    public DrawerType b() {
        Drawer drawer = this.f84394a;
        if (drawer == null) {
            return null;
        }
        return drawer.type;
    }

    public JumpInfo c() {
        Drawer drawer = this.f84394a;
        if (drawer == null) {
            return null;
        }
        return drawer.jumpInfo;
    }

    public List<Navbar> d() {
        Drawer drawer = this.f84394a;
        if (drawer == null) {
            return null;
        }
        return drawer.navbar;
    }

    public RedInfo e() {
        Drawer drawer = this.f84394a;
        if (drawer == null) {
            return null;
        }
        return drawer.redInfo;
    }

    public boolean f() {
        return this.f84395b;
    }

    public void g(boolean z16) {
        this.f84395b = z16;
    }
}
