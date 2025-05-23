package com.tencent.mobileqq.aio;

import com.tencent.aio.api.factory.g;
import com.tencent.aio.api.factory.j;
import com.tencent.aio.base.log.f;
import com.tencent.aio.base.mvi.part.Reserve1UIState;
import com.tencent.aio.base.mvi.part.Reserve2UIState;
import com.tencent.mobileqq.aio.background.FullBackgroundVB;
import com.tencent.mobileqq.aio.factory.AIOMsgAdornApiImpl;
import com.tencent.mobileqq.aio.factory.AIOThirdLevelFactory;
import com.tencent.mobileqq.aio.helper.provider.DefaultAIOHelperProvider;
import com.tencent.mobileqq.aio.msg.service.AIOMsgService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.base.mvi.MviUIState;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0016\u0018\u0000 \u001c2\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/aio/AIOFactory;", "Lcom/tencent/aio/api/factory/g;", "Lcom/tencent/mobileqq/aio/msg/service/AIOMsgService;", "a", "Lcom/tencent/mobileqq/aio/b;", "b", "Lcom/tencent/aio/api/factory/f;", "buildBusinessLevel", "Lcom/tencent/aio/api/factory/e;", "buildReserve2Level", "Lcom/tencent/aio/api/help/d;", "buildHelperProvider", "Lcom/tencent/aio/api/factory/j;", "buildMsgLevel", "Lcom/tencent/aio/api/factory/d;", "buildReserve1Level", "Lcom/tencent/aio/api/factory/c;", "buildPanelArea", "", "isDebugModel", "Lcom/tencent/aio/base/log/f;", "buildAIOLogger", "Lcom/tencent/aio/api/factory/a;", "buildFullBackgroundLevel", "", "c", "<init>", "()V", "d", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public class AIOFactory implements g {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/AIOFactory$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.AIOFactory$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/AIOFactory$b", "Lcom/tencent/aio/api/factory/a;", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements com.tencent.aio.api.factory.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.aio.api.factory.a
        @NotNull
        public com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new FullBackgroundVB();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/AIOFactory$c", "Lcom/tencent/aio/api/factory/c;", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c implements com.tencent.aio.api.factory.c {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.aio.api.factory.c
        @NotNull
        public com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new com.tencent.mobileqq.aio.input.panel.adapter.b().j1(new com.tencent.mobileqq.aio.input.panel.adapter.a());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/AIOFactory$d", "Lcom/tencent/aio/api/factory/d;", "Lcom/tencent/aio/base/mvvm/a;", "Lat/d;", "Lcom/tencent/aio/base/mvi/part/Reserve1UIState;", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class d implements com.tencent.aio.api.factory.d {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.aio.api.factory.d
        @NotNull
        public com.tencent.aio.base.mvvm.a<? extends at.d, ? extends Reserve1UIState> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new com.tencent.mobileqq.aio.reserve1.b();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/AIOFactory$e", "Lcom/tencent/aio/api/factory/e;", "Lcom/tencent/aio/base/mvvm/a;", "Lat/d;", "Lcom/tencent/aio/base/mvi/part/Reserve2UIState;", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class e implements com.tencent.aio.api.factory.e {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.aio.api.factory.e
        @NotNull
        public com.tencent.aio.base.mvvm.a<? extends at.d, ? extends Reserve2UIState> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new com.tencent.mobileqq.aio.foreground.a();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30068);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.aio.api.factory.g
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AIOMsgService buildAIOMsgService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AIOMsgService) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return AIOMsgService.f190196a;
    }

    @Override // com.tencent.aio.api.factory.g
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.aio.b buildActivityJumpService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.aio.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return com.tencent.mobileqq.aio.b.f188187a;
    }

    @Override // com.tencent.aio.api.factory.g
    @Nullable
    public f buildAIOLogger() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (f) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return com.tencent.mobileqq.aio.factory.d.f188788a;
    }

    @Override // com.tencent.aio.api.factory.g
    @NotNull
    public com.tencent.aio.api.factory.f buildBusinessLevel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.aio.api.factory.f) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new AIOThirdLevelFactory(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.aio.api.factory.g
    @Nullable
    public com.tencent.aio.api.factory.a buildFullBackgroundLevel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (com.tencent.aio.api.factory.a) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return new b();
    }

    @Override // com.tencent.aio.api.help.c
    @NotNull
    public com.tencent.aio.api.help.d buildHelperProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.aio.api.help.d) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new DefaultAIOHelperProvider();
    }

    @Override // com.tencent.aio.api.factory.g
    @NotNull
    public j buildMsgLevel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (j) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return new AIOMsgAdornApiImpl(null, null, null, null, new AIOFactory$buildMsgLevel$1(this), 15, null);
    }

    @Override // com.tencent.aio.api.factory.g
    @Nullable
    public com.tencent.aio.api.factory.c buildPanelArea() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.aio.api.factory.c) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return new c();
    }

    @Override // com.tencent.aio.api.factory.g
    @Nullable
    public com.tencent.aio.api.factory.d buildReserve1Level() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.aio.api.factory.d) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return new d();
    }

    @Override // com.tencent.aio.api.factory.g
    @Nullable
    public com.tencent.aio.api.factory.e buildReserve2Level() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.aio.api.factory.e) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new e();
    }

    @Nullable
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.aio.api.factory.g
    @Nullable
    public dt.b getBottomDialogFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (dt.b) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return g.a.g(this);
    }

    @Override // com.tencent.aio.api.factory.g
    @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "buildPanelArea", imports = {}))
    @Nullable
    public com.tencent.aio.part.root.panel.mvx.config.a getPanelFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (com.tencent.aio.part.root.panel.mvx.config.a) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return g.a.h(this);
    }

    @Override // com.tencent.aio.api.factory.g
    public boolean isDebugModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return com.tencent.qqnt.util.b.f362976b.isDebugVersion();
    }
}
