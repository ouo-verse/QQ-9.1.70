package com.tencent.icgame.game.userinfo.impl.view;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.tencent.icgame.game.userinfo.api.IUserInfo;
import com.tencent.icgame.game.userinfo.impl.loader.UserInfoAutoLoader;
import com.tencent.icgame.game.utils.g;
import com.tencent.icgame.trpc.yes.common.CommonOuterClass$QQUserId;
import com.tencent.timi.game.utils.IResultListener;
import fy0.d;
import ly0.k;
import ly0.n;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a extends d {
    qu0.b C;
    private IResultListener<IUserInfo> D;

    /* renamed from: d, reason: collision with root package name */
    private boolean f116048d;

    /* renamed from: e, reason: collision with root package name */
    private fy0.b f116049e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f116050f;

    /* renamed from: h, reason: collision with root package name */
    private LifecycleRegistry f116051h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private CommonOuterClass$QQUserId f116052i;

    /* renamed from: m, reason: collision with root package name */
    private IResultListener<IUserInfo> f116053m;

    /* compiled from: P */
    /* renamed from: com.tencent.icgame.game.userinfo.impl.view.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    class C5847a implements IResultListener<IUserInfo> {
        C5847a() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(IUserInfo iUserInfo) {
            if (!iUserInfo.e(a.this.d())) {
                a.this.m();
            } else {
                a.this.f116049e.f(iUserInfo);
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
            a.this.m();
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class b implements qu0.b<IUserInfo> {
        b() {
        }

        @Override // qu0.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable IUserInfo iUserInfo) {
            if (iUserInfo != null && iUserInfo.e(a.this.f116052i)) {
                a.this.f116049e.f(iUserInfo);
            }
        }
    }

    public a(fy0.b bVar) {
        super(bVar);
        this.f116048d = false;
        this.f116050f = true;
        this.f116053m = new C5847a();
        this.C = new b();
        this.D = new c();
        this.f116049e = bVar;
        this.f116051h = new LifecycleRegistry(this);
    }

    private void k() {
        if (this.f116050f && !this.f116048d && this.f116052i != null) {
            n.f415773a.f(this.C);
            this.f116048d = true;
            k.f415769a.s(this.f116052i, this.D);
        }
    }

    public static boolean l(@Nullable CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.f116052i != null) {
            g.a("ICGameUserInfoViewWrapperImpl", "onUserInfoError ");
            UserInfoAutoLoader.INSTANCE.a().l(this.f116052i);
        }
        this.f116049e.d();
    }

    private void o() {
        if (!this.f116050f) {
            return;
        }
        n.f415773a.i(this.C);
        this.f116048d = false;
    }

    @Override // fy0.a
    public void a() {
        this.f116052i = null;
        o();
    }

    @Override // fy0.a
    @Nullable
    public CommonOuterClass$QQUserId d() {
        return this.f116052i;
    }

    @Override // fy0.a
    public void e() {
        this.f116051h.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        this.f116051h.handleLifecycleEvent(Lifecycle.Event.ON_START);
        k();
    }

    @Override // fy0.a
    public void f() {
        this.f116051h.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        o();
    }

    @Override // fy0.a
    public void g(@Nullable CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
        p(commonOuterClass$QQUserId, null, true);
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.f116051h;
    }

    public void p(@Nullable CommonOuterClass$QQUserId commonOuterClass$QQUserId, IUserInfo iUserInfo, boolean z16) {
        if (commonOuterClass$QQUserId == null) {
            this.f116052i = null;
            this.f116049e.a();
            return;
        }
        boolean z17 = !mx0.b.a(this.f116052i, commonOuterClass$QQUserId);
        g.h("ICGameUserInfoViewWrapperImpl", "setUserIdWithInitUserInfo " + z17 + "," + this.f116049e.c());
        if (z17 || this.f116049e.c()) {
            this.f116052i = commonOuterClass$QQUserId;
            this.f116050f = z16;
            k();
            if (l(commonOuterClass$QQUserId)) {
                this.f116049e.b();
            } else {
                k.f415769a.s(this.f116052i, this.f116053m);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class c implements IResultListener<IUserInfo> {
        c() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(IUserInfo iUserInfo) {
            if (iUserInfo.e(a.this.d())) {
                a.this.f116049e.f(iUserInfo);
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
        }
    }
}
