package com.tencent.aio.frame.engine;

import android.R;
import androidx.fragment.app.FragmentManager;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.frame.api.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0002\u0003\bB+\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\b\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0013\u001a\u0004\b\u000e\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/aio/frame/engine/a;", "", "Lcom/tencent/aio/data/AIOParam;", "a", "Lcom/tencent/aio/data/AIOParam;", "()Lcom/tencent/aio/data/AIOParam;", "aioParam", "Landroidx/fragment/app/FragmentManager;", "b", "Landroidx/fragment/app/FragmentManager;", "d", "()Landroidx/fragment/app/FragmentManager;", "fm", "", "c", "I", "()I", "containerId", "Lcom/tencent/aio/frame/api/c;", "Lcom/tencent/aio/frame/api/c;", "()Lcom/tencent/aio/frame/api/c;", "drawerProvider", "<init>", "(Lcom/tencent/aio/data/AIOParam;Landroidx/fragment/app/FragmentManager;ILcom/tencent/aio/frame/api/c;)V", "e", "core-frame-ktx_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AIOParam aioParam;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FragmentManager fm;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int containerId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c drawerProvider;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b \u0010!J\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0013\u0010\u0017R$\u0010\u001f\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001a\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/aio/frame/engine/a$a;", "", "Lcom/tencent/aio/frame/engine/a;", "a", "Lcom/tencent/aio/data/AIOParam;", "Lcom/tencent/aio/data/AIOParam;", "getAioParam", "()Lcom/tencent/aio/data/AIOParam;", "b", "(Lcom/tencent/aio/data/AIOParam;)V", "aioParam", "Landroidx/fragment/app/FragmentManager;", "Landroidx/fragment/app/FragmentManager;", "getFm", "()Landroidx/fragment/app/FragmentManager;", "e", "(Landroidx/fragment/app/FragmentManager;)V", "fm", "", "c", "I", "getContainerId", "()I", "(I)V", "containerId", "Lcom/tencent/aio/frame/api/c;", "d", "Lcom/tencent/aio/frame/api/c;", "getDrawerProvider", "()Lcom/tencent/aio/frame/api/c;", "(Lcom/tencent/aio/frame/api/c;)V", "drawerProvider", "<init>", "()V", "core-frame-ktx_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.frame.engine.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0630a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private AIOParam aioParam;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private FragmentManager fm;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int containerId;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private c drawerProvider;

        public C0630a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this);
            } else {
                this.containerId = R.id.content;
            }
        }

        @NotNull
        public final a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (a) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            AIOParam aIOParam = this.aioParam;
            if (aIOParam != null) {
                FragmentManager fragmentManager = this.fm;
                if (fragmentManager != null) {
                    int i3 = this.containerId;
                    c cVar = this.drawerProvider;
                    if (cVar != null) {
                        return new a(aIOParam, fragmentManager, i3, cVar, null);
                    }
                    throw new IllegalStateException("must set IDrawerFrameProvider".toString());
                }
                throw new IllegalStateException("must set FragmentManager".toString());
            }
            throw new IllegalStateException("must set aioParm".toString());
        }

        public final void b(@Nullable AIOParam aIOParam) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aIOParam);
            } else {
                this.aioParam = aIOParam;
            }
        }

        public final void c(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, i3);
            } else {
                this.containerId = i3;
            }
        }

        public final void d(@Nullable c cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) cVar);
            } else {
                this.drawerProvider = cVar;
            }
        }

        public final void e(@Nullable FragmentManager fragmentManager) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) fragmentManager);
            } else {
                this.fm = fragmentManager;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/aio/frame/engine/a$b;", "", "<init>", "()V", "core-frame-ktx_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.frame.engine.a$b, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11161);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    a(AIOParam aIOParam, FragmentManager fragmentManager, int i3, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, aIOParam, fragmentManager, Integer.valueOf(i3), cVar);
            return;
        }
        this.aioParam = aIOParam;
        this.fm = fragmentManager;
        this.containerId = i3;
        this.drawerProvider = cVar;
    }

    @NotNull
    public final AIOParam a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (AIOParam) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.aioParam;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.containerId;
    }

    @NotNull
    public final c c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (c) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.drawerProvider;
    }

    @NotNull
    public final FragmentManager d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (FragmentManager) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.fm;
    }

    public /* synthetic */ a(AIOParam aIOParam, FragmentManager fragmentManager, int i3, c cVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(aIOParam, fragmentManager, i3, cVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, this, aIOParam, fragmentManager, Integer.valueOf(i3), cVar, defaultConstructorMarker);
    }
}
