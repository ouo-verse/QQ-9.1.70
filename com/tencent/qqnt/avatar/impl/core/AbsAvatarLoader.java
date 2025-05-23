package com.tencent.qqnt.avatar.impl.core;

import androidx.annotation.CallSuper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import com.tencent.qqnt.avatar.b;
import com.tencent.qqnt.avatar.e;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import uv3.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b \u0018\u0000 \u0014*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001%B\u001b\u0012\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00028\u00000\u0015\u00a2\u0006\u0004\b#\u0010$J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ \u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0015R#\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00028\u00000\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u000b\u001a\u00020\n8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006&"}, d2 = {"Lcom/tencent/qqnt/avatar/impl/core/AbsAvatarLoader;", "T", "Lcom/tencent/qqnt/avatar/e;", "Luv3/b;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "result", "", "i", "(Lkotlinx/coroutines/CoroutineScope;Ljava/lang/Object;)V", "Lcom/tencent/qqnt/avatar/b;", "option", "e", "", "uid", "", "uin", "d", "groupCode", "b", h.F, "Luv3/a;", "Luv3/a;", "j", "()Luv3/a;", DownloadInfo.spKey_Config, "Lcom/tencent/qqnt/avatar/b;", "k", "()Lcom/tencent/qqnt/avatar/b;", "setOption", "(Lcom/tencent/qqnt/avatar/b;)V", "Lcom/tencent/qqnt/avatar/impl/engine/a;", "f", "Lcom/tencent/qqnt/avatar/impl/engine/a;", EnginePathProvider.ENGINE_DIR, "<init>", "(Luv3/a;)V", "a", "avatar_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public abstract class AbsAvatarLoader<T> implements e, b<T> {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final a f352844h;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final uv3.a<String, T> config;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.qqnt.avatar.b option;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.avatar.impl.engine.a<String, T> engine;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/avatar/impl/core/AbsAvatarLoader$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "avatar_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27684);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f352844h = new a(null);
        }
    }

    public AbsAvatarLoader(@NotNull uv3.a<String, T> config) {
        Intrinsics.checkNotNullParameter(config, "config");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) config);
            return;
        }
        this.config = config;
        b.Companion companion = com.tencent.qqnt.avatar.b.INSTANCE;
        this.option = new b.a().a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(CoroutineScope scope, T result) {
        BuildersKt__Builders_commonKt.launch$default(scope, Dispatchers.getMain().getImmediate(), null, new AbsAvatarLoader$dispatchComplete$1(this, result, null), 2, null);
    }

    @Override // com.tencent.qqnt.avatar.e
    public void b(final long groupCode, @NotNull final CoroutineScope scope) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Long.valueOf(groupCode), scope);
            return;
        }
        Intrinsics.checkNotNullParameter(scope, "scope");
        vv3.a.a("AvatarLoaderManager", "loadAvatarByGroupCode " + groupCode);
        a();
        h();
        ThreadManagerV2.excute(new Runnable(groupCode, scope) { // from class: com.tencent.qqnt.avatar.impl.core.AbsAvatarLoader$loadAvatarByGroupCode$$inlined$Runnable$1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f352848d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ CoroutineScope f352849e;

            {
                this.f352848d = groupCode;
                this.f352849e = scope;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, AbsAvatarLoader.this, Long.valueOf(groupCode), scope);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                com.tencent.qqnt.avatar.impl.engine.a a16 = AbsAvatarLoader.this.j().a(AbsAvatarLoader.this.k());
                AbsAvatarLoader.this.engine = a16;
                AbsAvatarLoader.this.i(this.f352849e, a16.b(String.valueOf(this.f352848d), AbsAvatarLoader.this.j().c()));
            }
        }, 240, null, false);
    }

    @Override // com.tencent.qqnt.avatar.e
    public void d(@NotNull String uid, final long uin, @NotNull final CoroutineScope scope) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, uid, Long.valueOf(uin), scope);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(scope, "scope");
        a();
        h();
        ThreadManagerV2.excute(new Runnable(uin, scope) { // from class: com.tencent.qqnt.avatar.impl.core.AbsAvatarLoader$loadAvatarByUid$$inlined$Runnable$1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f352850d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ CoroutineScope f352851e;

            {
                this.f352850d = uin;
                this.f352851e = scope;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, AbsAvatarLoader.this, Long.valueOf(uin), scope);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                com.tencent.qqnt.avatar.impl.engine.a a16 = AbsAvatarLoader.this.j().a(AbsAvatarLoader.this.k());
                AbsAvatarLoader.this.engine = a16;
                AbsAvatarLoader.this.i(this.f352851e, a16.a(String.valueOf(this.f352850d), AbsAvatarLoader.this.j().c()));
            }
        }, 240, null, false);
    }

    @Override // com.tencent.qqnt.avatar.e
    @NotNull
    public final e e(@NotNull com.tencent.qqnt.avatar.b option) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (e) iPatchRedirector.redirect((short) 5, (Object) this, (Object) option);
        }
        Intrinsics.checkNotNullParameter(option, "option");
        this.option = option;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        try {
            com.tencent.qqnt.avatar.impl.engine.a<String, T> aVar = this.engine;
            if (aVar != null) {
                aVar.release();
            }
        } catch (CancellationException e16) {
            vv3.a.a("AvatarLoaderManager", " \u6b63\u5e38\u5f02\u5e38  cancel " + e16);
        }
    }

    @NotNull
    public final uv3.a<String, T> j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (uv3.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.config;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final com.tencent.qqnt.avatar.b k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.qqnt.avatar.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.option;
    }
}
