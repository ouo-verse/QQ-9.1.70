package com.tencent.timi.game.userinfo.impl.view;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import co4.d;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.userinfo.impl.loader.UserInfoAutoLoader;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import io4.k;
import io4.n;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a extends d {
    tg4.b C;
    private IResultListener<IUserInfo> D;

    /* renamed from: d, reason: collision with root package name */
    private boolean f380245d;

    /* renamed from: e, reason: collision with root package name */
    private co4.b f380246e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f380247f;

    /* renamed from: h, reason: collision with root package name */
    private LifecycleRegistry f380248h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private CommonOuterClass$QQUserId f380249i;

    /* renamed from: m, reason: collision with root package name */
    private IResultListener<IUserInfo> f380250m;

    /* compiled from: P */
    /* renamed from: com.tencent.timi.game.userinfo.impl.view.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    class C9987a implements IResultListener<IUserInfo> {
        C9987a() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(IUserInfo iUserInfo) {
            if (!iUserInfo.e(a.this.d())) {
                a.this.m();
            } else {
                a.this.f380246e.e(iUserInfo);
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
            a.this.m();
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class b implements tg4.b<IUserInfo> {
        b() {
        }

        @Override // tg4.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable IUserInfo iUserInfo) {
            if (iUserInfo != null && iUserInfo.e(a.this.f380249i)) {
                a.this.f380246e.e(iUserInfo);
            }
        }
    }

    public a(co4.b bVar) {
        super(bVar);
        this.f380245d = false;
        this.f380247f = true;
        this.f380250m = new C9987a();
        this.C = new b();
        this.D = new c();
        this.f380246e = bVar;
        this.f380248h = new LifecycleRegistry(this);
    }

    private void k() {
        if (this.f380247f && !this.f380245d && this.f380249i != null) {
            n.f408123a.g(this.C);
            this.f380245d = true;
            k.f408119a.s(this.f380249i, this.D);
        }
    }

    public static boolean l(@Nullable CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.f380249i != null) {
            l.b("UserInfoViewWrapperImpl", "onUserInfoError ");
            UserInfoAutoLoader.INSTANCE.a().l(this.f380249i);
        }
        this.f380246e.d();
    }

    private void o() {
        if (!this.f380247f) {
            return;
        }
        n.f408123a.j(this.C);
        this.f380245d = false;
    }

    @Override // co4.a
    public void a() {
        this.f380249i = null;
        o();
    }

    @Override // co4.a
    @Nullable
    public CommonOuterClass$QQUserId d() {
        return this.f380249i;
    }

    @Override // co4.a
    public void e() {
        this.f380248h.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        this.f380248h.handleLifecycleEvent(Lifecycle.Event.ON_START);
        k();
    }

    @Override // co4.a
    public void f() {
        this.f380248h.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        o();
    }

    @Override // co4.a
    public void g(@Nullable CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
        p(commonOuterClass$QQUserId, null, true);
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.f380248h;
    }

    public void p(@Nullable CommonOuterClass$QQUserId commonOuterClass$QQUserId, IUserInfo iUserInfo, boolean z16) {
        if (commonOuterClass$QQUserId == null) {
            this.f380249i = null;
            this.f380246e.a();
            return;
        }
        boolean z17 = !ll4.b.a(this.f380249i, commonOuterClass$QQUserId);
        l.i("UserInfoViewWrapperImpl", "setUserIdWithInitUserInfo " + z17 + "," + this.f380246e.c());
        if (z17 || this.f380246e.c()) {
            this.f380249i = commonOuterClass$QQUserId;
            this.f380247f = z16;
            k();
            if (l(commonOuterClass$QQUserId)) {
                this.f380246e.b();
            } else {
                k.f408119a.s(this.f380249i, this.f380250m);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class c implements IResultListener<IUserInfo> {
        c() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(IUserInfo iUserInfo) {
            if (iUserInfo.e(a.this.d())) {
                a.this.f380246e.e(iUserInfo);
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
        }
    }
}
