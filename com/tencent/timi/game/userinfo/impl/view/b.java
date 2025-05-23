package com.tencent.timi.game.userinfo.impl.view;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.tencent.timi.game.userinfo.impl.loader.UserRoleInfoAutoLoader;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import jo4.g;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b extends co4.a {
    private IResultListener<bo4.c> C;
    tg4.b D;
    private IResultListener<bo4.c> E;

    /* renamed from: d, reason: collision with root package name */
    private boolean f380254d;

    /* renamed from: e, reason: collision with root package name */
    private co4.c f380255e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private CommonOuterClass$QQUserId f380256f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f380257h;

    /* renamed from: i, reason: collision with root package name */
    private LifecycleRegistry f380258i;

    /* renamed from: m, reason: collision with root package name */
    private int f380259m;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements IResultListener<bo4.c> {
        a() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(bo4.c cVar) {
            if (!cVar.e(b.this.d())) {
                b.this.l();
            } else {
                b.this.f380255e.f(cVar);
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
            b.this.l();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.timi.game.userinfo.impl.view.b$b, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    class C9988b implements tg4.b<bo4.c> {
        C9988b() {
        }

        @Override // tg4.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable bo4.c cVar) {
            if (cVar != null && cVar.e(b.this.f380256f)) {
                b.this.f380255e.f(cVar);
            }
        }
    }

    public b(co4.c cVar) {
        super(cVar);
        this.f380254d = false;
        this.f380257h = true;
        this.f380259m = 0;
        this.C = new a();
        this.D = new C9988b();
        this.E = new c();
        this.f380255e = cVar;
        this.f380258i = new LifecycleRegistry(this);
    }

    private void k() {
        if (this.f380257h && !this.f380254d && this.f380256f != null) {
            fo4.c.INSTANCE.a().a(this.D);
            this.f380254d = true;
            g.f410756a.m(this.f380256f, this.f380259m, this.E);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.f380256f != null) {
            l.b("UserRoleViewWrapperImpl", "onUserInfoError ");
            UserRoleInfoAutoLoader.INSTANCE.a().m(this.f380256f, this.f380259m);
        }
        this.f380255e.d();
    }

    private void m() {
        if (!this.f380257h) {
            return;
        }
        fo4.c.INSTANCE.a().e(this.D);
        this.f380254d = false;
    }

    @Override // co4.a
    public void a() {
        this.f380256f = null;
        m();
    }

    @Override // co4.a
    @Nullable
    public CommonOuterClass$QQUserId d() {
        return this.f380256f;
    }

    @Override // co4.a
    public void e() {
        this.f380258i.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        this.f380258i.handleLifecycleEvent(Lifecycle.Event.ON_START);
        k();
    }

    @Override // co4.a
    public void f() {
        this.f380258i.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        m();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.f380258i;
    }

    public void n(CommonOuterClass$QQUserId commonOuterClass$QQUserId, int i3) {
        o(commonOuterClass$QQUserId, i3, true);
    }

    public void o(CommonOuterClass$QQUserId commonOuterClass$QQUserId, int i3, boolean z16) {
        if (commonOuterClass$QQUserId == null) {
            this.f380256f = null;
            this.f380255e.a();
            return;
        }
        this.f380259m = i3;
        boolean z17 = !ll4.b.a(this.f380256f, commonOuterClass$QQUserId);
        l.i("UserRoleViewWrapperImpl", "setUserIdWithInitUserInfo " + z17 + "," + this.f380255e.c());
        if (z17 || this.f380255e.c()) {
            this.f380256f = commonOuterClass$QQUserId;
            this.f380257h = z16;
            k();
            g.f410756a.m(this.f380256f, i3, this.C);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class c implements IResultListener<bo4.c> {
        c() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(bo4.c cVar) {
            if (cVar.e(b.this.d())) {
                b.this.f380255e.f(cVar);
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
        }
    }
}
