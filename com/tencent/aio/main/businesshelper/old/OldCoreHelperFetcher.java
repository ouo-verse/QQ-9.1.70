package com.tencent.aio.main.businesshelper.old;

import android.util.Log;
import com.tencent.aio.api.help.d;
import com.tencent.aio.exception.AIOException;
import com.tencent.aio.helper.c;
import com.tencent.aio.main.businesshelper.e;
import com.tencent.aio.pref.annotation.HookMethodTrace;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u0000 \u001d2\u00020\u0001:\u0001\u000fB\u001b\b\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\f\u0010\f\u001a\u00020\u000b*\u00020\bH\u0002J\u001f\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017\u00a2\u0006\u0004\b\r\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u001f\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0010\u0010\nR\u001b\u0010\u0015\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u000e\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/aio/main/businesshelper/old/OldCoreHelperFetcher;", "Lcom/tencent/aio/main/businesshelper/old/b;", "Lcom/tencent/aio/api/help/a;", "param", "", "Lcom/tencent/aio/main/businesshelper/h;", "g", "(Lcom/tencent/aio/api/help/a;)[Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/aio/main/businesshelper/e;", h.F, "(Lcom/tencent/aio/api/help/a;)[Lcom/tencent/aio/main/businesshelper/e;", "", "i", "b", "helper", "a", "c", "Lcom/tencent/aio/base/mvvm/recycler/b;", "Lkotlin/Lazy;", "f", "()Lcom/tencent/aio/base/mvvm/recycler/b;", "helperRecycler", "Lcom/tencent/aio/api/help/d;", "Lcom/tencent/aio/api/help/d;", "", "Z", "checkRecycleHelper", "<init>", "(Lcom/tencent/aio/api/help/d;Z)V", "d", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class OldCoreHelperFetcher implements com.tencent.aio.main.businesshelper.old.b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy helperRecycler;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final d helper;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean checkRecycleHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/aio/main/businesshelper/old/OldCoreHelperFetcher$a;", "", "Lcom/tencent/aio/api/help/d;", "helper", "", "checkRecycleHelper", "Lcom/tencent/aio/main/businesshelper/old/b;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.main.businesshelper.old.OldCoreHelperFetcher$a, reason: from kotlin metadata */
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
        public final com.tencent.aio.main.businesshelper.old.b a(@Nullable d helper, boolean checkRecycleHelper) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (com.tencent.aio.main.businesshelper.old.b) iPatchRedirector.redirect((short) 1, this, helper, Boolean.valueOf(checkRecycleHelper));
            }
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (helper == null) {
                return null;
            }
            return new OldCoreHelperFetcher(helper, checkRecycleHelper, defaultConstructorMarker);
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0011\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0001J\t\u0010\u0007\u001a\u00020\u0005H\u0096\u0001\u00a8\u0006\b"}, d2 = {"com/tencent/aio/main/businesshelper/old/OldCoreHelperFetcher$b", "Lcom/tencent/aio/helper/a;", "Lcom/tencent/aio/api/help/b;", "Lcom/tencent/aio/main/businesshelper/b;", "param", "", h.F, "i", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class b extends com.tencent.aio.helper.a implements com.tencent.aio.api.help.b {
        static IPatchRedirector $redirector_;

        /* renamed from: h, reason: collision with root package name */
        private final /* synthetic */ com.tencent.aio.api.help.b f69372h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f69373i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ com.tencent.aio.main.businesshelper.h f69374m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, com.tencent.aio.main.businesshelper.h hVar, String str2, com.tencent.aio.main.businesshelper.h hVar2) {
            super(str2, hVar2, false, 4, null);
            this.f69373i = str;
            this.f69374m = hVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, hVar, str2, hVar2);
            } else {
                this.f69372h = (com.tencent.aio.api.help.b) hVar;
            }
        }

        @Override // com.tencent.aio.api.help.b
        public void h(@NotNull com.tencent.aio.main.businesshelper.b param) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) param);
            } else {
                Intrinsics.checkNotNullParameter(param, "param");
                this.f69372h.h(param);
            }
        }

        @Override // com.tencent.aio.api.help.b
        public void i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                this.f69372h.i();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44771);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    OldCoreHelperFetcher(d dVar, boolean z16) {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, dVar, Boolean.valueOf(z16));
            return;
        }
        this.helper = dVar;
        this.checkRecycleHelper = z16;
        lazy = LazyKt__LazyJVMKt.lazy(OldCoreHelperFetcher$helperRecycler$2.INSTANCE);
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

    @Override // com.tencent.aio.main.businesshelper.old.b
    public void a(@NotNull e helper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) helper);
            return;
        }
        Intrinsics.checkNotNullParameter(helper, "helper");
        if ((helper instanceof c) && this.checkRecycleHelper) {
            f().b(((c) helper).getToken(), helper);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.old.b
    @HookMethodTrace(tag = "HelperRegister#createLifeHelper")
    @Nullable
    public com.tencent.aio.main.businesshelper.h[] b(@NotNull com.tencent.aio.api.help.a param) {
        e[] eVarArr;
        com.tencent.aio.main.businesshelper.h aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (com.tencent.aio.main.businesshelper.h[]) iPatchRedirector.redirect((short) 1, (Object) this, (Object) param);
        }
        Intrinsics.checkNotNullParameter(param, "param");
        Map<String, Function0<com.tencent.aio.main.businesshelper.h>> lifeCycleHelperCreator = this.helper.getLifeCycleHelperCreator(param);
        if (lifeCycleHelperCreator != null) {
            if (!lifeCycleHelperCreator.isEmpty()) {
                z16 = false;
            }
            if (z16) {
                eVarArr = null;
            } else {
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<String, Function0<com.tencent.aio.main.businesshelper.h>> entry : lifeCycleHelperCreator.entrySet()) {
                    e a16 = f().a(entry.getKey());
                    if (a16 instanceof com.tencent.aio.main.businesshelper.h) {
                        String str = entry.getKey() + "resumeHelper";
                        com.tencent.aio.pref.a aVar2 = com.tencent.aio.pref.a.f69788j;
                        if (!aVar2.g()) {
                            i(a16);
                            Unit unit = Unit.INSTANCE;
                            arrayList.add(a16);
                        } else {
                            aVar2.b(str);
                            String str2 = "AIO#" + str;
                            if (!aVar2.h()) {
                                i(a16);
                                Unit unit2 = Unit.INSTANCE;
                                arrayList.add(a16);
                            } else {
                                long currentTimeMillis = System.currentTimeMillis();
                                i(a16);
                                Unit unit3 = Unit.INSTANCE;
                                arrayList.add(a16);
                                Log.w("AIO#", str2 + " spend " + (System.currentTimeMillis() - currentTimeMillis));
                            }
                            aVar2.e();
                        }
                    } else {
                        String str3 = entry.getKey() + "Helper#new";
                        com.tencent.aio.pref.a aVar3 = com.tencent.aio.pref.a.f69788j;
                        if (!aVar3.g()) {
                            com.tencent.aio.main.businesshelper.h invoke = entry.getValue().invoke();
                            String key = entry.getKey();
                            if (invoke instanceof com.tencent.aio.api.help.b) {
                                aVar = new b(key, invoke, key, invoke);
                            } else {
                                aVar = new com.tencent.aio.helper.a(key, invoke, false, 4, null);
                            }
                        } else {
                            aVar3.b(str3);
                            String str4 = "AIO#" + str3;
                            if (!aVar3.h()) {
                                com.tencent.aio.main.businesshelper.h invoke2 = entry.getValue().invoke();
                                String key2 = entry.getKey();
                                if (invoke2 instanceof com.tencent.aio.api.help.b) {
                                    aVar = new b(key2, invoke2, key2, invoke2);
                                } else {
                                    aVar = new com.tencent.aio.helper.a(key2, invoke2, false, 4, null);
                                }
                            } else {
                                long currentTimeMillis2 = System.currentTimeMillis();
                                com.tencent.aio.main.businesshelper.h invoke3 = entry.getValue().invoke();
                                String key3 = entry.getKey();
                                if (invoke3 instanceof com.tencent.aio.api.help.b) {
                                    aVar = new b(key3, invoke3, key3, invoke3);
                                } else {
                                    aVar = new com.tencent.aio.helper.a(key3, invoke3, false, 4, null);
                                }
                                Log.w("AIO#", str4 + " spend " + (System.currentTimeMillis() - currentTimeMillis2));
                                Unit unit4 = Unit.INSTANCE;
                            }
                            aVar3.e();
                        }
                        arrayList.add(aVar);
                        Unit unit5 = Unit.INSTANCE;
                    }
                }
                Object[] array = arrayList.toArray(new com.tencent.aio.main.businesshelper.h[0]);
                if (array != null) {
                    eVarArr = (e[]) array;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
            return (com.tencent.aio.main.businesshelper.h[]) eVarArr;
        }
        return g(param);
    }

    @Override // com.tencent.aio.main.businesshelper.old.b
    @Nullable
    public e[] c(@NotNull com.tencent.aio.api.help.a param) {
        boolean z16;
        com.tencent.aio.helper.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (e[]) iPatchRedirector.redirect((short) 3, (Object) this, (Object) param);
        }
        Intrinsics.checkNotNullParameter(param, "param");
        if (this.helper.getNormalHelperCreator(param) == null) {
            return h(param);
        }
        Map<String, Function0<e>> normalHelperCreator = this.helper.getNormalHelperCreator(param);
        if (normalHelperCreator != null && !normalHelperCreator.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Function0<e>> entry : normalHelperCreator.entrySet()) {
            e a16 = f().a(entry.getKey());
            if (a16 instanceof e) {
                String str = entry.getKey() + "resumeHelper";
                com.tencent.aio.pref.a aVar = com.tencent.aio.pref.a.f69788j;
                if (!aVar.g()) {
                    i(a16);
                    Unit unit = Unit.INSTANCE;
                    arrayList.add(a16);
                } else {
                    aVar.b(str);
                    String str2 = "AIO#" + str;
                    if (!aVar.h()) {
                        i(a16);
                        Unit unit2 = Unit.INSTANCE;
                        arrayList.add(a16);
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        i(a16);
                        Unit unit3 = Unit.INSTANCE;
                        arrayList.add(a16);
                        Log.w("AIO#", str2 + " spend " + (System.currentTimeMillis() - currentTimeMillis));
                    }
                    aVar.e();
                }
            } else {
                String str3 = entry.getKey() + "Helper#new";
                com.tencent.aio.pref.a aVar2 = com.tencent.aio.pref.a.f69788j;
                if (!aVar2.g()) {
                    bVar = new com.tencent.aio.helper.b(entry.getKey(), entry.getValue().invoke(), false, 4, null);
                } else {
                    aVar2.b(str3);
                    String str4 = "AIO#" + str3;
                    if (!aVar2.h()) {
                        bVar = new com.tencent.aio.helper.b(entry.getKey(), entry.getValue().invoke(), false, 4, null);
                    } else {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        bVar = new com.tencent.aio.helper.b(entry.getKey(), entry.getValue().invoke(), false, 4, null);
                        Log.w("AIO#", str4 + " spend " + (System.currentTimeMillis() - currentTimeMillis2));
                    }
                    aVar2.e();
                }
                arrayList.add(bVar);
            }
        }
        Object[] array = arrayList.toArray(new e[0]);
        if (array != null) {
            return (e[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public /* synthetic */ OldCoreHelperFetcher(d dVar, boolean z16, DefaultConstructorMarker defaultConstructorMarker) {
        this(dVar, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, this, dVar, Boolean.valueOf(z16), defaultConstructorMarker);
    }
}
