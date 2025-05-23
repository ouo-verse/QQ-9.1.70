package com.tencent.aio.main.businesshelper.p000new;

import android.util.Log;
import androidx.collection.SparseArrayCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.aio.api.help.b;
import com.tencent.aio.api.runtime.a;
import com.tencent.aio.data.AIOSession;
import com.tencent.aio.helper.d;
import com.tencent.aio.main.businesshelper.e;
import com.tencent.aio.main.businesshelper.f;
import com.tencent.aio.main.businesshelper.g;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 /2\u00020\u0001:\u00010B\u0011\u0012\b\u0010,\u001a\u0004\u0018\u00010)\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\f\u0010\u0013\u001a\u00020\u0012*\u00020\u0002H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\"R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020$0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\"R \u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0!0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\"R\u0016\u0010(\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010\u001cR\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lcom/tencent/aio/main/businesshelper/new/HelperRegister;", "Lcom/tencent/aio/main/businesshelper/f;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "j", "l", "Lcom/tencent/aio/main/businesshelper/e;", "helper", "k", "Lcom/tencent/aio/main/businesshelper/g;", "i", "", "state", h.F, "Landroidx/lifecycle/Lifecycle$Event;", "event", "g", "Lcom/tencent/aio/api/help/a;", "f", "onCreate", "V", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroidx/lifecycle/LifecycleOwner;", "source", "onStateChanged", "", "d", "Z", "DEBUG", "e", "Lcom/tencent/aio/api/runtime/a;", "mAioContext", "Landroidx/collection/SparseArrayCompat;", "Landroidx/collection/SparseArrayCompat;", "mHelpers", "Lcom/tencent/aio/api/help/b;", "mAsyncHelpers", "mLifecycleObservers", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mUseCache", "Lcom/tencent/aio/helper/d;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/aio/helper/d;", "mHelperProvider", "<init>", "(Lcom/tencent/aio/helper/d;)V", "D", "a", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class HelperRegister implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private d mHelperProvider;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean DEBUG;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private a mAioContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final SparseArrayCompat<e> mHelpers;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final SparseArrayCompat<b> mAsyncHelpers;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final SparseArrayCompat<SparseArrayCompat<g>> mLifecycleObservers;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mUseCache;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/main/businesshelper/new/HelperRegister$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.main.businesshelper.new.HelperRegister$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43051);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public HelperRegister(@Nullable d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) dVar);
            return;
        }
        this.mHelperProvider = dVar;
        this.DEBUG = com.tencent.aio.base.a.f69150c.a();
        this.mHelpers = new SparseArrayCompat<>();
        this.mAsyncHelpers = new SparseArrayCompat<>();
        this.mLifecycleObservers = new SparseArrayCompat<>(12);
    }

    public static final /* synthetic */ a a(HelperRegister helperRegister) {
        a aVar = helperRegister.mAioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAioContext");
        }
        return aVar;
    }

    private final com.tencent.aio.api.help.a f(a aVar) {
        com.tencent.aio.api.help.a aVar2 = new com.tencent.aio.api.help.a(AIOSession.b(aVar.g().r(), null, 1, null));
        aVar2.c(aVar.g());
        return aVar2;
    }

    private final int g(Lifecycle.Event event) {
        switch (a.f69361a[event.ordinal()]) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 3;
            case 4:
                return 8;
            case 5:
                return 9;
            case 6:
                return 12;
            default:
                return -1;
        }
    }

    private final void h(final int state) {
        a aVar = this.mAioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAioContext");
        }
        aVar.a().f(new Runnable(state) { // from class: com.tencent.aio.main.businesshelper.new.HelperRegister$onStateChanged$1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f69357d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f69357d = state;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) HelperRegister.this, state);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                SparseArrayCompat sparseArrayCompat;
                com.tencent.mvi.api.runtime.a aVar2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                    sparseArrayCompat = HelperRegister.this.mLifecycleObservers;
                    SparseArrayCompat sparseArrayCompat2 = (SparseArrayCompat) sparseArrayCompat.get(this.f69357d);
                    if (sparseArrayCompat2 != null) {
                        Intrinsics.checkNotNullExpressionValue(sparseArrayCompat2, "mLifecycleObservers.get(state) ?: return@enqueue");
                        int size = sparseArrayCompat2.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            a a16 = HelperRegister.a(HelperRegister.this);
                            if (a16 != null) {
                                aVar2 = a16.a();
                            } else {
                                aVar2 = null;
                            }
                            aVar2.f(new Runnable(sparseArrayCompat2, i3) { // from class: com.tencent.aio.main.businesshelper.new.HelperRegister$onStateChanged$1.1
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ SparseArrayCompat f69358d;

                                /* renamed from: e, reason: collision with root package name */
                                final /* synthetic */ int f69359e;

                                {
                                    this.f69358d = sparseArrayCompat2;
                                    this.f69359e = i3;
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                        iPatchRedirector2.redirect((short) 2, this, HelperRegister$onStateChanged$1.this, sparseArrayCompat2, Integer.valueOf(i3));
                                    }
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, (Object) this);
                                        return;
                                    }
                                    Object valueAt = this.f69358d.valueAt(this.f69359e);
                                    Intrinsics.checkNotNullExpressionValue(valueAt, "observers.valueAt(i)");
                                    ((g) valueAt).onMoveToState(HelperRegister$onStateChanged$1.this.f69357d);
                                }
                            });
                        }
                        return;
                    }
                    return;
                }
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(g helper, a aioContext) {
        boolean z16;
        int id5 = helper.getId();
        for (int i3 : helper.interestedIn()) {
            SparseArrayCompat<g> sparseArrayCompat = this.mLifecycleObservers.get(i3);
            if (sparseArrayCompat == null) {
                sparseArrayCompat = new SparseArrayCompat<>();
                this.mLifecycleObservers.put(i3, sparseArrayCompat);
            }
            if (sparseArrayCompat.get(id5) == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                sparseArrayCompat.put(id5, helper);
            } else {
                throw new IllegalArgumentException(("helper already exist with id: " + id5).toString());
            }
        }
    }

    private final void j(final a aioContext) {
        d dVar = this.mHelperProvider;
        if (dVar != null) {
            com.tencent.aio.api.help.a f16 = f(aioContext);
            com.tencent.mvi.api.runtime.a a16 = aioContext.a();
            Intrinsics.checkNotNullExpressionValue(a16, "aioContext.aioPoster");
            dVar.c(f16, a16, new Function1<com.tencent.aio.main.businesshelper.h, Unit>(aioContext) { // from class: com.tencent.aio.main.businesshelper.new.HelperRegister$registerLifeCycleHelper$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ a $aioContext;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$aioContext = aioContext;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) HelperRegister.this, (Object) aioContext);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.aio.main.businesshelper.h hVar) {
                    invoke2(hVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull com.tencent.aio.main.businesshelper.h it) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    HelperRegister.this.k(it, this.$aioContext);
                    HelperRegister.this.i(it, this.$aioContext);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(e helper, a aioContext) {
        boolean z16;
        com.tencent.aio.base.log.b.a(com.tencent.aio.base.log.a.f69187b).d("HelperRegister", "register " + helper.getTag());
        if (this.DEBUG) {
            if (this.mHelpers.get(helper.getId()) == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                throw new IllegalArgumentException(("helper already exist with id: " + helper.getId() + "  " + helper + TokenParser.SP + this.mHelpers.get(helper.getId())).toString());
            }
        }
        a aVar = this.mAioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAioContext");
        }
        b.a(helper, new com.tencent.aio.main.businesshelper.b(aVar, false, 2, null));
        this.mHelpers.put(helper.getId(), helper);
        if (helper instanceof b) {
            this.mAsyncHelpers.put(helper.getId(), helper);
            a aVar2 = this.mAioContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAioContext");
            }
            LifecycleOwner d16 = aVar2.d();
            Intrinsics.checkNotNullExpressionValue(d16, "mAioContext.lifecycleOwner");
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(d16), Dispatchers.getDefault(), null, new HelperRegister$registerNormal$2(this, helper, null), 2, null);
        }
    }

    private final void l(final a aioContext) {
        d dVar = this.mHelperProvider;
        if (dVar != null) {
            com.tencent.aio.api.help.a f16 = f(aioContext);
            com.tencent.mvi.api.runtime.a a16 = aioContext.a();
            Intrinsics.checkNotNullExpressionValue(a16, "aioContext.aioPoster");
            dVar.b(f16, a16, new Function1<e, Unit>(aioContext) { // from class: com.tencent.aio.main.businesshelper.new.HelperRegister$registerNormalHelper$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ a $aioContext;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$aioContext = aioContext;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) HelperRegister.this, (Object) aioContext);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(e eVar) {
                    invoke2(eVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull e it) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) it);
                    } else {
                        Intrinsics.checkNotNullParameter(it, "it");
                        HelperRegister.this.k(it, this.$aioContext);
                    }
                }
            });
        }
    }

    @Override // com.tencent.aio.main.businesshelper.f
    public void V(@NotNull a aioContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aioContext);
            return;
        }
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        if (com.tencent.aio.base.a.f69150c.a()) {
            com.tencent.aio.base.log.a.f69187b.d("HelperRegister", "delayLoad mUseCache=" + this.mUseCache);
        }
        if (!this.mUseCache) {
            com.tencent.aio.pref.a aVar = com.tencent.aio.pref.a.f69788j;
            if (!aVar.g()) {
                l(aioContext);
            } else {
                aVar.b("registerNormalHelper");
                String str = "AIO#registerNormalHelper";
                if (!aVar.h()) {
                    l(aioContext);
                    Unit unit = Unit.INSTANCE;
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    l(aioContext);
                    Unit unit2 = Unit.INSTANCE;
                    Log.w("AIO#", str + " spend " + (System.currentTimeMillis() - currentTimeMillis));
                }
                aVar.e();
            }
        }
        h(4);
    }

    @Override // com.tencent.aio.main.businesshelper.f
    public void onCreate(@NotNull a aioContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aioContext);
            return;
        }
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        if (com.tencent.aio.base.a.f69150c.a()) {
            com.tencent.aio.base.log.a aVar = com.tencent.aio.base.log.a.f69187b;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onCreate mUseCache=");
            sb5.append(!this.mHelpers.isEmpty());
            aVar.d("HelperRegister", sb5.toString());
        }
        this.mAioContext = aioContext;
        if (this.mHelpers.isEmpty()) {
            com.tencent.aio.pref.a aVar2 = com.tencent.aio.pref.a.f69788j;
            if (!aVar2.g()) {
                j(aioContext);
                return;
            }
            aVar2.b("registerLifeCycleHelper");
            String str = "AIO#registerLifeCycleHelper";
            if (!aVar2.h()) {
                j(aioContext);
                Unit unit = Unit.INSTANCE;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                j(aioContext);
                Unit unit2 = Unit.INSTANCE;
                Log.w("AIO#", str + " spend " + (System.currentTimeMillis() - currentTimeMillis));
            }
            aVar2.e();
            return;
        }
        this.mUseCache = true;
        SparseArrayCompat<e> sparseArrayCompat = this.mHelpers;
        int size = sparseArrayCompat.size();
        for (int i3 = 0; i3 < size; i3++) {
            sparseArrayCompat.keyAt(i3);
            b.a(sparseArrayCompat.valueAt(i3), new com.tencent.aio.main.businesshelper.b(aioContext, false, 2, null));
        }
        if (!this.mAsyncHelpers.isEmpty()) {
            LifecycleOwner d16 = aioContext.d();
            Intrinsics.checkNotNullExpressionValue(d16, "aioContext.lifecycleOwner");
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(d16), Dispatchers.getDefault(), null, new HelperRegister$onCreate$4(this, aioContext, null), 2, null);
        }
        com.tencent.aio.base.log.b.a(com.tencent.aio.base.log.a.f69187b).d("HelperRegister", "register complete  helperSize  " + this.mHelpers.size());
    }

    @Override // com.tencent.aio.main.businesshelper.f
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (com.tencent.aio.base.a.f69150c.a()) {
            com.tencent.aio.base.log.a.f69187b.d("HelperRegister", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getDefault(), null, new HelperRegister$onDestroy$2(this, null), 2, null);
        SparseArrayCompat<e> sparseArrayCompat = this.mHelpers;
        int size = sparseArrayCompat.size();
        for (int i3 = 0; i3 < size; i3++) {
            sparseArrayCompat.keyAt(i3);
            e valueAt = sparseArrayCompat.valueAt(i3);
            valueAt.onDestroy();
            d dVar = this.mHelperProvider;
            if (dVar != null) {
                dVar.a(valueAt);
            }
        }
        this.mLifecycleObservers.clear();
        this.mHelpers.clear();
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) source, (Object) event);
            return;
        }
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        int g16 = g(event);
        a aVar = this.mAioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAioContext");
        }
        aVar.a().f(new HelperRegister$onStateChanged$2(this, g16));
    }
}
