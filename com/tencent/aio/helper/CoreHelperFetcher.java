package com.tencent.aio.helper;

import android.util.Log;
import com.tencent.aio.exception.AIOException;
import com.tencent.aio.main.businesshelper.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0016B\u0011\b\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\f\u0010\f\u001a\u00020\u000b*\u00020\bH\u0002J;\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000b0\u000fH\u0016J;\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000b0\u000fH\u0016J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\bH\u0016R\u001b\u0010\u001b\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0012\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001d\u00a8\u0006 "}, d2 = {"Lcom/tencent/aio/helper/CoreHelperFetcher;", "Lcom/tencent/aio/helper/d;", "Lcom/tencent/aio/api/help/a;", "param", "", "Lcom/tencent/aio/main/businesshelper/h;", "g", "(Lcom/tencent/aio/api/help/a;)[Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/aio/main/businesshelper/e;", h.F, "(Lcom/tencent/aio/api/help/a;)[Lcom/tencent/aio/main/businesshelper/e;", "", "i", "Lcom/tencent/mvi/api/runtime/a;", QAdVrReport.ElementID.AD_POSTER, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "helper", "helperCreator", "c", "b", "a", "Lcom/tencent/aio/base/mvvm/recycler/b;", "Lkotlin/Lazy;", "f", "()Lcom/tencent/aio/base/mvvm/recycler/b;", "helperRecycler", "Lcom/tencent/aio/api/help/d;", "Lcom/tencent/aio/api/help/d;", "<init>", "(Lcom/tencent/aio/api/help/d;)V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class CoreHelperFetcher implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy helperRecycler;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.aio.api.help.d helper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/aio/helper/CoreHelperFetcher$a;", "", "Lcom/tencent/aio/api/help/d;", "helper", "Lcom/tencent/aio/helper/d;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.helper.CoreHelperFetcher$a, reason: from kotlin metadata */
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

        @Nullable
        public final d a(@Nullable com.tencent.aio.api.help.d helper) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (d) iPatchRedirector.redirect((short) 1, (Object) this, (Object) helper);
            }
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (helper == null) {
                return null;
            }
            return new CoreHelperFetcher(helper, defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37987);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    CoreHelperFetcher(com.tencent.aio.api.help.d dVar) {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) dVar);
            return;
        }
        this.helper = dVar;
        lazy = LazyKt__LazyJVMKt.lazy(CoreHelperFetcher$helperRecycler$2.INSTANCE);
        this.helperRecycler = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.aio.base.mvvm.recycler.b f() {
        return (com.tencent.aio.base.mvvm.recycler.b) this.helperRecycler.getValue();
    }

    private final com.tencent.aio.main.businesshelper.h[] g(com.tencent.aio.api.help.a param) {
        boolean z16;
        com.tencent.aio.main.businesshelper.h[] lifeCycleHelper = this.helper.getLifeCycleHelper(param);
        if (lifeCycleHelper != null) {
            com.tencent.aio.main.businesshelper.h[] lifeCycleHelper2 = this.helper.getLifeCycleHelper();
            boolean z17 = true;
            if (lifeCycleHelper2 != null) {
                if (lifeCycleHelper2.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    z17 = false;
                }
            }
            if (!z17) {
                throw new AIOException("can not both set getLifeCycleHelper(param) and getLifeCycleHelper !! ");
            }
            return lifeCycleHelper;
        }
        return this.helper.getLifeCycleHelper();
    }

    private final e[] h(com.tencent.aio.api.help.a param) {
        boolean z16;
        e[] normalHelper = this.helper.getNormalHelper(param);
        if (normalHelper != null) {
            e[] normalHelper2 = this.helper.getNormalHelper();
            boolean z17 = true;
            if (normalHelper2 != null) {
                if (normalHelper2.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    z17 = false;
                }
            }
            if (!z17) {
                throw new AIOException("can not both set getNormalHelper(param) and getNormalHelper !! ");
            }
            return normalHelper;
        }
        return this.helper.getNormalHelper();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(e eVar) {
        if (eVar instanceof c) {
            ((c) eVar).f(true);
            return;
        }
        throw new AIOException("cur " + eVar + "  please use CoreRecycleHelper");
    }

    @Override // com.tencent.aio.helper.d
    public void a(@NotNull e helper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) helper);
            return;
        }
        Intrinsics.checkNotNullParameter(helper, "helper");
        if ((helper instanceof c) && com.tencent.aio.base.a.f69150c.a()) {
            com.tencent.aio.base.log.a.f69187b.d("CoreHelperFetcher", "recycleHelper " + helper);
            f().b(((c) helper).getToken(), helper);
        }
    }

    @Override // com.tencent.aio.helper.d
    public void b(@NotNull com.tencent.aio.api.help.a param, @NotNull final com.tencent.mvi.api.runtime.a poster, @NotNull final Function1<? super e, Unit> helperCreator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, param, poster, helperCreator);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(poster, "poster");
        Intrinsics.checkNotNullParameter(helperCreator, "helperCreator");
        Map<String, Function0<e>> normalHelperCreator = this.helper.getNormalHelperCreator(param);
        if (normalHelperCreator == null) {
            e[] h16 = h(param);
            if (h16 != null) {
                for (final e eVar : h16) {
                    poster.f(new Runnable(poster, helperCreator) { // from class: com.tencent.aio.helper.CoreHelperFetcher$getCoreNormalHelper$$inlined$forEach$lambda$1
                        static IPatchRedirector $redirector_;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ com.tencent.mvi.api.runtime.a f69321e;

                        /* renamed from: f, reason: collision with root package name */
                        final /* synthetic */ Function1 f69322f;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.f69321e = poster;
                            this.f69322f = helperCreator;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, e.this, poster, helperCreator);
                            }
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                this.f69322f.invoke(e.this);
                            }
                        }
                    });
                }
                return;
            }
            return;
        }
        if (!normalHelperCreator.isEmpty()) {
            for (final Map.Entry<String, Function0<e>> entry : normalHelperCreator.entrySet()) {
                poster.f(new Runnable(entry, this, poster, helperCreator) { // from class: com.tencent.aio.helper.CoreHelperFetcher$getCoreNormalHelper$$inlined$handleCreateHelper$1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ Map.Entry f69323d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ com.tencent.mvi.api.runtime.a f69324e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ Function1 f69325f;
                    final /* synthetic */ CoreHelperFetcher this$0;

                    {
                        this.f69323d = entry;
                        this.this$0 = this;
                        this.f69324e = poster;
                        this.f69325f = helperCreator;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, entry, this, poster, helperCreator);
                        }
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        com.tencent.aio.base.mvvm.recycler.b f16;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            f16 = this.this$0.f();
                            e a16 = f16.a((String) this.f69323d.getKey());
                            if (a16 instanceof e) {
                                this.this$0.i(a16);
                            } else {
                                String str = ((String) this.f69323d.getKey()) + "Helper#new";
                                com.tencent.aio.pref.a aVar = com.tencent.aio.pref.a.f69788j;
                                if (!aVar.g()) {
                                    a16 = new b((String) this.f69323d.getKey(), (e) ((Function0) this.f69323d.getValue()).invoke(), false, 4, null);
                                } else {
                                    aVar.b(str);
                                    String str2 = "AIO#" + str;
                                    if (!aVar.h()) {
                                        a16 = new b((String) this.f69323d.getKey(), (e) ((Function0) this.f69323d.getValue()).invoke(), false, 4, null);
                                    } else {
                                        long currentTimeMillis = System.currentTimeMillis();
                                        b bVar = new b((String) this.f69323d.getKey(), (e) ((Function0) this.f69323d.getValue()).invoke(), false, 4, null);
                                        Log.w("AIO#", str2 + " spend " + (System.currentTimeMillis() - currentTimeMillis));
                                        a16 = bVar;
                                    }
                                    aVar.e();
                                }
                            }
                            this.f69325f.invoke(a16);
                            return;
                        }
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                });
            }
        }
    }

    @Override // com.tencent.aio.helper.d
    public void c(@NotNull com.tencent.aio.api.help.a param, @NotNull final com.tencent.mvi.api.runtime.a poster, @NotNull final Function1<? super com.tencent.aio.main.businesshelper.h, Unit> helperCreator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, param, poster, helperCreator);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(poster, "poster");
        Intrinsics.checkNotNullParameter(helperCreator, "helperCreator");
        Map<String, Function0<com.tencent.aio.main.businesshelper.h>> lifeCycleHelperCreator = this.helper.getLifeCycleHelperCreator(param);
        if (lifeCycleHelperCreator == null) {
            com.tencent.aio.main.businesshelper.h[] g16 = g(param);
            if (g16 != null) {
                for (final com.tencent.aio.main.businesshelper.h hVar : g16) {
                    poster.f(new Runnable(poster, helperCreator) { // from class: com.tencent.aio.helper.CoreHelperFetcher$getCoreLifeCycleHelper$$inlined$forEach$lambda$1
                        static IPatchRedirector $redirector_;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ com.tencent.mvi.api.runtime.a f69306e;

                        /* renamed from: f, reason: collision with root package name */
                        final /* synthetic */ Function1 f69307f;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.f69306e = poster;
                            this.f69307f = helperCreator;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, com.tencent.aio.main.businesshelper.h.this, poster, helperCreator);
                            }
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                this.f69307f.invoke(com.tencent.aio.main.businesshelper.h.this);
                            }
                        }
                    });
                }
                return;
            }
            return;
        }
        if (!lifeCycleHelperCreator.isEmpty()) {
            for (final Map.Entry<String, Function0<com.tencent.aio.main.businesshelper.h>> entry : lifeCycleHelperCreator.entrySet()) {
                poster.f(new Runnable(entry, this, poster, helperCreator) { // from class: com.tencent.aio.helper.CoreHelperFetcher$getCoreLifeCycleHelper$$inlined$handleCreateHelper$1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ Map.Entry f69308d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ com.tencent.mvi.api.runtime.a f69309e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ Function1 f69310f;
                    final /* synthetic */ CoreHelperFetcher this$0;

                    /* compiled from: P */
                    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0011\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0001J\t\u0010\u0007\u001a\u00020\u0005H\u0096\u0001\u00a8\u0006\b\u00b8\u0006\u0000"}, d2 = {"com/tencent/aio/helper/CoreHelperFetcher$getCoreLifeCycleHelper$2$1", "Lcom/tencent/aio/helper/a;", "Lcom/tencent/aio/api/help/b;", "Lcom/tencent/aio/main/businesshelper/b;", "param", "", h.F, "i", "sdk_debug"}, k = 1, mv = {1, 4, 2})
                    /* loaded from: classes3.dex */
                    public static final class a extends com.tencent.aio.helper.a implements com.tencent.aio.api.help.b {
                        static IPatchRedirector $redirector_;

                        /* renamed from: h, reason: collision with root package name */
                        private final /* synthetic */ com.tencent.aio.api.help.b f69311h;

                        /* renamed from: i, reason: collision with root package name */
                        final /* synthetic */ String f69312i;

                        /* renamed from: m, reason: collision with root package name */
                        final /* synthetic */ com.tencent.aio.main.businesshelper.h f69313m;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        a(String str, com.tencent.aio.main.businesshelper.h hVar, String str2, com.tencent.aio.main.businesshelper.h hVar2) {
                            super(str2, hVar2, false, 4, null);
                            this.f69312i = str;
                            this.f69313m = hVar;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, this, str, hVar, str2, hVar2);
                            } else {
                                this.f69311h = (com.tencent.aio.api.help.b) hVar;
                            }
                        }

                        @Override // com.tencent.aio.api.help.b
                        public void h(@NotNull com.tencent.aio.main.businesshelper.b param) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this, (Object) param);
                            } else {
                                Intrinsics.checkNotNullParameter(param, "param");
                                this.f69311h.h(param);
                            }
                        }

                        @Override // com.tencent.aio.api.help.b
                        public void i() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                                iPatchRedirector.redirect((short) 3, (Object) this);
                            } else {
                                this.f69311h.i();
                            }
                        }
                    }

                    /* compiled from: P */
                    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0011\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0001J\t\u0010\u0007\u001a\u00020\u0005H\u0096\u0001\u00a8\u0006\b\u00b8\u0006\u0000"}, d2 = {"com/tencent/aio/helper/CoreHelperFetcher$getCoreLifeCycleHelper$2$1", "Lcom/tencent/aio/helper/a;", "Lcom/tencent/aio/api/help/b;", "Lcom/tencent/aio/main/businesshelper/b;", "param", "", h.F, "i", "sdk_debug"}, k = 1, mv = {1, 4, 2})
                    /* loaded from: classes3.dex */
                    public static final class b extends com.tencent.aio.helper.a implements com.tencent.aio.api.help.b {
                        static IPatchRedirector $redirector_;

                        /* renamed from: h, reason: collision with root package name */
                        private final /* synthetic */ com.tencent.aio.api.help.b f69314h;

                        /* renamed from: i, reason: collision with root package name */
                        final /* synthetic */ String f69315i;

                        /* renamed from: m, reason: collision with root package name */
                        final /* synthetic */ com.tencent.aio.main.businesshelper.h f69316m;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        b(String str, com.tencent.aio.main.businesshelper.h hVar, String str2, com.tencent.aio.main.businesshelper.h hVar2) {
                            super(str2, hVar2, false, 4, null);
                            this.f69315i = str;
                            this.f69316m = hVar;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, this, str, hVar, str2, hVar2);
                            } else {
                                this.f69314h = (com.tencent.aio.api.help.b) hVar;
                            }
                        }

                        @Override // com.tencent.aio.api.help.b
                        public void h(@NotNull com.tencent.aio.main.businesshelper.b param) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this, (Object) param);
                            } else {
                                Intrinsics.checkNotNullParameter(param, "param");
                                this.f69314h.h(param);
                            }
                        }

                        @Override // com.tencent.aio.api.help.b
                        public void i() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                                iPatchRedirector.redirect((short) 3, (Object) this);
                            } else {
                                this.f69314h.i();
                            }
                        }
                    }

                    /* compiled from: P */
                    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0011\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0001J\t\u0010\u0007\u001a\u00020\u0005H\u0096\u0001\u00a8\u0006\b\u00b8\u0006\u0000"}, d2 = {"com/tencent/aio/helper/CoreHelperFetcher$getCoreLifeCycleHelper$2$1", "Lcom/tencent/aio/helper/a;", "Lcom/tencent/aio/api/help/b;", "Lcom/tencent/aio/main/businesshelper/b;", "param", "", h.F, "i", "sdk_debug"}, k = 1, mv = {1, 4, 2})
                    /* loaded from: classes3.dex */
                    public static final class c extends com.tencent.aio.helper.a implements com.tencent.aio.api.help.b {
                        static IPatchRedirector $redirector_;

                        /* renamed from: h, reason: collision with root package name */
                        private final /* synthetic */ com.tencent.aio.api.help.b f69317h;

                        /* renamed from: i, reason: collision with root package name */
                        final /* synthetic */ String f69318i;

                        /* renamed from: m, reason: collision with root package name */
                        final /* synthetic */ com.tencent.aio.main.businesshelper.h f69319m;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        c(String str, com.tencent.aio.main.businesshelper.h hVar, String str2, com.tencent.aio.main.businesshelper.h hVar2) {
                            super(str2, hVar2, false, 4, null);
                            this.f69318i = str;
                            this.f69319m = hVar;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, this, str, hVar, str2, hVar2);
                            } else {
                                this.f69317h = (com.tencent.aio.api.help.b) hVar;
                            }
                        }

                        @Override // com.tencent.aio.api.help.b
                        public void h(@NotNull com.tencent.aio.main.businesshelper.b param) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this, (Object) param);
                            } else {
                                Intrinsics.checkNotNullParameter(param, "param");
                                this.f69317h.h(param);
                            }
                        }

                        @Override // com.tencent.aio.api.help.b
                        public void i() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                                iPatchRedirector.redirect((short) 3, (Object) this);
                            } else {
                                this.f69317h.i();
                            }
                        }
                    }

                    {
                        this.f69308d = entry;
                        this.this$0 = this;
                        this.f69309e = poster;
                        this.f69310f = helperCreator;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, entry, this, poster, helperCreator);
                        }
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        com.tencent.aio.base.mvvm.recycler.b f16;
                        e aVar;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            f16 = this.this$0.f();
                            e a16 = f16.a((String) this.f69308d.getKey());
                            if (a16 instanceof com.tencent.aio.main.businesshelper.h) {
                                this.this$0.i(a16);
                            } else {
                                String str = ((String) this.f69308d.getKey()) + "Helper#new";
                                com.tencent.aio.pref.a aVar2 = com.tencent.aio.pref.a.f69788j;
                                if (!aVar2.g()) {
                                    com.tencent.aio.main.businesshelper.h hVar2 = (com.tencent.aio.main.businesshelper.h) ((e) ((Function0) this.f69308d.getValue()).invoke());
                                    String str2 = (String) this.f69308d.getKey();
                                    if (hVar2 instanceof com.tencent.aio.api.help.b) {
                                        a16 = new a(str2, hVar2, str2, hVar2);
                                    } else {
                                        a16 = new com.tencent.aio.helper.a(str2, hVar2, false, 4, null);
                                    }
                                } else {
                                    aVar2.b(str);
                                    String str3 = "AIO#" + str;
                                    if (!aVar2.h()) {
                                        com.tencent.aio.main.businesshelper.h hVar3 = (com.tencent.aio.main.businesshelper.h) ((e) ((Function0) this.f69308d.getValue()).invoke());
                                        String str4 = (String) this.f69308d.getKey();
                                        if (hVar3 instanceof com.tencent.aio.api.help.b) {
                                            a16 = new b(str4, hVar3, str4, hVar3);
                                        } else {
                                            a16 = new com.tencent.aio.helper.a(str4, hVar3, false, 4, null);
                                        }
                                    } else {
                                        long currentTimeMillis = System.currentTimeMillis();
                                        com.tencent.aio.main.businesshelper.h hVar4 = (com.tencent.aio.main.businesshelper.h) ((e) ((Function0) this.f69308d.getValue()).invoke());
                                        String str5 = (String) this.f69308d.getKey();
                                        if (hVar4 instanceof com.tencent.aio.api.help.b) {
                                            aVar = new c(str5, hVar4, str5, hVar4);
                                        } else {
                                            aVar = new com.tencent.aio.helper.a(str5, hVar4, false, 4, null);
                                        }
                                        Log.w("AIO#", str3 + " spend " + (System.currentTimeMillis() - currentTimeMillis));
                                        a16 = aVar;
                                    }
                                    aVar2.e();
                                }
                            }
                            this.f69310f.invoke(a16);
                            return;
                        }
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                });
            }
        }
    }

    public /* synthetic */ CoreHelperFetcher(com.tencent.aio.api.help.d dVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(dVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, (Object) this, (Object) dVar, (Object) defaultConstructorMarker);
    }
}
