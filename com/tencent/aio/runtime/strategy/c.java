package com.tencent.aio.runtime.strategy;

import com.tencent.aio.data.AIOParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.runtime.strategy.IStrategyFetcher;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J*\u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016J%\u0010\t\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u001c\u0010\f\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016R$\u0010\u0010\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/aio/runtime/strategy/c;", "Lcom/tencent/mvi/runtime/strategy/b;", "T", "Ljava/lang/Class;", "clazz", "Lcom/tencent/mvi/runtime/strategy/IStrategyFetcher;", "fetcher", "", "c", "b", "(Ljava/lang/Class;)Ljava/lang/Object;", "", "a", "", "", "Ljava/util/Map;", "servicePool", "Lcom/tencent/aio/api/factory/g;", "Lcom/tencent/aio/api/factory/g;", "aioFactory", "Lcom/tencent/aio/data/AIOParam;", "mAioParam", "<init>", "(Lcom/tencent/aio/api/factory/g;Lcom/tencent/aio/data/AIOParam;)V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class c implements com.tencent.mvi.runtime.strategy.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Map<Class<?>, Object> servicePool;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.aio.api.factory.g aioFactory;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/aio/runtime/strategy/c$a", "Lcom/tencent/mvi/runtime/strategy/IStrategyFetcher;", "Lcom/tencent/aio/api/factory/c;", "c", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class a extends IStrategyFetcher<com.tencent.aio.api.factory.c> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.mvi.runtime.strategy.IStrategyFetcher
        @Nullable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.tencent.aio.api.factory.c a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (com.tencent.aio.api.factory.c) iPatchRedirector.redirect((short) 1, (Object) this);
            }
            return c.this.aioFactory.buildPanelArea();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/aio/runtime/strategy/c$b", "Lcom/tencent/mvi/runtime/strategy/IStrategyFetcher;", "Lcom/tencent/aio/api/factory/a;", "c", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class b extends IStrategyFetcher<com.tencent.aio.api.factory.a> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.mvi.runtime.strategy.IStrategyFetcher
        @Nullable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.tencent.aio.api.factory.a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (com.tencent.aio.api.factory.a) iPatchRedirector.redirect((short) 1, (Object) this);
            }
            return c.this.aioFactory.buildFullBackgroundLevel();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/aio/runtime/strategy/c$c", "Lcom/tencent/mvi/runtime/strategy/IStrategyFetcher;", "Lcom/tencent/aio/runtime/strategy/b;", "c", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.runtime.strategy.c$c, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0658c extends IStrategyFetcher<com.tencent.aio.runtime.strategy.b> {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AIOParam f69847b;

        C0658c(AIOParam aIOParam) {
            this.f69847b = aIOParam;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aIOParam);
            }
        }

        @Override // com.tencent.mvi.runtime.strategy.IStrategyFetcher
        @Nullable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.tencent.aio.runtime.strategy.b a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (com.tencent.aio.runtime.strategy.b) iPatchRedirector.redirect((short) 1, (Object) this);
            }
            return new com.tencent.aio.runtime.strategy.a(this.f69847b);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/aio/runtime/strategy/c$d", "Lcom/tencent/mvi/runtime/strategy/IStrategyFetcher;", "Lcom/tencent/aio/api/factory/j;", "c", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class d extends IStrategyFetcher<com.tencent.aio.api.factory.j> {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.mvi.runtime.strategy.IStrategyFetcher
        @NotNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.tencent.aio.api.factory.j a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (com.tencent.aio.api.factory.j) iPatchRedirector.redirect((short) 1, (Object) this);
            }
            return c.this.aioFactory.buildMsgLevel();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/aio/runtime/strategy/c$e", "Lcom/tencent/mvi/runtime/strategy/IStrategyFetcher;", "Lcom/tencent/aio/api/factory/d;", "c", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class e extends IStrategyFetcher<com.tencent.aio.api.factory.d> {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.mvi.runtime.strategy.IStrategyFetcher
        @Nullable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.tencent.aio.api.factory.d a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (com.tencent.aio.api.factory.d) iPatchRedirector.redirect((short) 1, (Object) this);
            }
            return c.this.aioFactory.buildReserve1Level();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/aio/runtime/strategy/c$f", "Lcom/tencent/mvi/runtime/strategy/IStrategyFetcher;", "Lcom/tencent/aio/api/factory/f;", "c", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class f extends IStrategyFetcher<com.tencent.aio.api.factory.f> {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.mvi.runtime.strategy.IStrategyFetcher
        @NotNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.tencent.aio.api.factory.f a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (com.tencent.aio.api.factory.f) iPatchRedirector.redirect((short) 1, (Object) this);
            }
            return c.this.aioFactory.buildBusinessLevel();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/aio/runtime/strategy/c$g", "Lcom/tencent/mvi/runtime/strategy/IStrategyFetcher;", "Lcom/tencent/aio/api/factory/e;", "c", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class g extends IStrategyFetcher<com.tencent.aio.api.factory.e> {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.mvi.runtime.strategy.IStrategyFetcher
        @Nullable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.tencent.aio.api.factory.e a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (com.tencent.aio.api.factory.e) iPatchRedirector.redirect((short) 1, (Object) this);
            }
            return c.this.aioFactory.buildReserve2Level();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/aio/runtime/strategy/c$h", "Lcom/tencent/mvi/runtime/strategy/IStrategyFetcher;", "Lcom/tencent/aio/part/root/panel/mvx/config/a;", "c", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class h extends IStrategyFetcher<com.tencent.aio.part.root.panel.mvx.config.a> {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.mvi.runtime.strategy.IStrategyFetcher
        @Nullable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.tencent.aio.part.root.panel.mvx.config.a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (com.tencent.aio.part.root.panel.mvx.config.a) iPatchRedirector.redirect((short) 1, (Object) this);
            }
            return c.this.aioFactory.getPanelFactory();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/aio/runtime/strategy/c$i", "Lcom/tencent/mvi/runtime/strategy/IStrategyFetcher;", "Ldt/b;", "c", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class i extends IStrategyFetcher<dt.b> {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.mvi.runtime.strategy.IStrategyFetcher
        @Nullable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public dt.b a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (dt.b) iPatchRedirector.redirect((short) 1, (Object) this);
            }
            return c.this.aioFactory.getBottomDialogFactory();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/aio/runtime/strategy/c$j", "Lcom/tencent/mvi/runtime/strategy/IStrategyFetcher;", "Lcom/tencent/aio/api/help/d;", "c", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class j extends IStrategyFetcher<com.tencent.aio.api.help.d> {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.mvi.runtime.strategy.IStrategyFetcher
        @NotNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.tencent.aio.api.help.d a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (com.tencent.aio.api.help.d) iPatchRedirector.redirect((short) 1, (Object) this);
            }
            return c.this.aioFactory.buildHelperProvider();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/aio/runtime/strategy/c$k", "Lcom/tencent/mvi/runtime/strategy/IStrategyFetcher;", "Lcom/tencent/aio/msgservice/a;", "c", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class k extends IStrategyFetcher<com.tencent.aio.msgservice.a> {
        static IPatchRedirector $redirector_;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.mvi.runtime.strategy.IStrategyFetcher
        @Nullable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.tencent.aio.msgservice.a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (com.tencent.aio.msgservice.a) iPatchRedirector.redirect((short) 1, (Object) this);
            }
            return c.this.aioFactory.buildAIOMsgService();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/aio/runtime/strategy/c$l", "Lcom/tencent/mvi/runtime/strategy/IStrategyFetcher;", "Lcom/tencent/aio/base/log/f;", "c", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class l extends IStrategyFetcher<com.tencent.aio.base.log.f> {
        static IPatchRedirector $redirector_;

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.mvi.runtime.strategy.IStrategyFetcher
        @Nullable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.tencent.aio.base.log.f a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (com.tencent.aio.base.log.f) iPatchRedirector.redirect((short) 1, (Object) this);
            }
            return c.this.aioFactory.buildAIOLogger();
        }
    }

    public c(@NotNull com.tencent.aio.api.factory.g aioFactory, @NotNull AIOParam mAioParam) {
        Intrinsics.checkNotNullParameter(aioFactory, "aioFactory");
        Intrinsics.checkNotNullParameter(mAioParam, "mAioParam");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aioFactory, (Object) mAioParam);
            return;
        }
        this.aioFactory = aioFactory;
        this.servicePool = new LinkedHashMap();
        c(com.tencent.aio.api.factory.j.class, new d());
        c(com.tencent.aio.api.factory.d.class, new e());
        c(com.tencent.aio.api.factory.f.class, new f());
        c(com.tencent.aio.api.factory.e.class, new g());
        c(com.tencent.aio.part.root.panel.mvx.config.a.class, new h());
        c(dt.b.class, new i());
        c(com.tencent.aio.api.help.d.class, new j());
        c(com.tencent.aio.msgservice.a.class, new k());
        c(com.tencent.aio.base.log.f.class, new l());
        c(com.tencent.aio.api.factory.c.class, new a());
        c(com.tencent.aio.api.factory.a.class, new b());
        c(com.tencent.aio.runtime.strategy.b.class, new C0658c(mAioParam));
    }

    @Override // com.tencent.mvi.runtime.strategy.b
    public <T> boolean a(@NotNull Class<T> clazz) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) clazz)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (this.servicePool.containsKey(clazz) && b(clazz) != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mvi.runtime.strategy.b
    @Nullable
    public <T> T b(@NotNull Class<T> clazz) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (T) iPatchRedirector.redirect((short) 2, (Object) this, (Object) clazz);
        }
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Object obj = this.servicePool.get(clazz);
        if (!(obj instanceof IStrategyFetcher)) {
            obj = null;
        }
        IStrategyFetcher iStrategyFetcher = (IStrategyFetcher) obj;
        if (iStrategyFetcher == null) {
            return null;
        }
        return (T) iStrategyFetcher.b();
    }

    @Override // com.tencent.mvi.runtime.strategy.b
    public <T> void c(@NotNull Class<T> clazz, @NotNull IStrategyFetcher<T> fetcher) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) clazz, (Object) fetcher);
            return;
        }
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(fetcher, "fetcher");
        this.servicePool.put(clazz, fetcher);
    }
}
