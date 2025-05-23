package com.tencent.icgame.game.userinfo.impl.view;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.tencent.icgame.game.userinfo.impl.loader.UserRoleInfoAutoLoader;
import com.tencent.icgame.trpc.yes.common.CommonOuterClass$QQUserId;
import com.tencent.timi.game.utils.IResultListener;
import my0.g;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes7.dex */
public class b extends fy0.a {
    private IResultListener<ey0.c> C;
    qu0.b D;
    private IResultListener<ey0.c> E;

    /* renamed from: d, reason: collision with root package name */
    private boolean f116057d;

    /* renamed from: e, reason: collision with root package name */
    private fy0.c f116058e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private CommonOuterClass$QQUserId f116059f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f116060h;

    /* renamed from: i, reason: collision with root package name */
    private LifecycleRegistry f116061i;

    /* renamed from: m, reason: collision with root package name */
    private int f116062m;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class a implements IResultListener<ey0.c> {
        a() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(ey0.c cVar) {
            if (!cVar.e(b.this.d())) {
                b.this.l();
            } else {
                b.this.f116058e.e(cVar);
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
            b.this.l();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.icgame.game.userinfo.impl.view.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    class C5848b implements qu0.b<ey0.c> {
        C5848b() {
        }

        @Override // qu0.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable ey0.c cVar) {
            if (cVar != null && cVar.e(b.this.f116059f)) {
                b.this.f116058e.e(cVar);
            }
        }
    }

    public b(fy0.c cVar) {
        super(cVar);
        this.f116057d = false;
        this.f116060h = true;
        this.f116062m = 0;
        this.C = new a();
        this.D = new C5848b();
        this.E = new c();
        this.f116058e = cVar;
        this.f116061i = new LifecycleRegistry(this);
    }

    private void k() {
        if (this.f116060h && !this.f116057d && this.f116059f != null) {
            iy0.c.INSTANCE.a().a(this.D);
            this.f116057d = true;
            g.f417775a.l(this.f116059f, this.f116062m, this.E);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.f116059f != null) {
            com.tencent.icgame.game.utils.g.a("ICGameUserRoleViewWrapperImpl", "onUserInfoError ");
            UserRoleInfoAutoLoader.INSTANCE.a().m(this.f116059f, this.f116062m);
        }
        this.f116058e.d();
    }

    private void m() {
        if (!this.f116060h) {
            return;
        }
        iy0.c.INSTANCE.a().e(this.D);
        this.f116057d = false;
    }

    @Override // fy0.a
    public void a() {
        this.f116059f = null;
        m();
    }

    @Override // fy0.a
    @Nullable
    public CommonOuterClass$QQUserId d() {
        return this.f116059f;
    }

    @Override // fy0.a
    public void e() {
        this.f116061i.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        this.f116061i.handleLifecycleEvent(Lifecycle.Event.ON_START);
        k();
    }

    @Override // fy0.a
    public void f() {
        this.f116061i.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        m();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.f116061i;
    }

    public void n(CommonOuterClass$QQUserId commonOuterClass$QQUserId, int i3) {
        o(commonOuterClass$QQUserId, i3, true);
    }

    public void o(CommonOuterClass$QQUserId commonOuterClass$QQUserId, int i3, boolean z16) {
        if (commonOuterClass$QQUserId == null) {
            this.f116059f = null;
            this.f116058e.a();
            return;
        }
        this.f116062m = i3;
        boolean z17 = !mx0.b.a(this.f116059f, commonOuterClass$QQUserId);
        com.tencent.icgame.game.utils.g.h("ICGameUserRoleViewWrapperImpl", "setUserIdWithInitUserInfo " + z17 + "," + this.f116058e.c());
        if (z17 || this.f116058e.c()) {
            this.f116059f = commonOuterClass$QQUserId;
            this.f116060h = z16;
            k();
            g.f417775a.l(this.f116059f, i3, this.C);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class c implements IResultListener<ey0.c> {
        c() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(ey0.c cVar) {
            if (cVar.e(b.this.d())) {
                b.this.f116058e.e(cVar);
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
        }
    }
}
