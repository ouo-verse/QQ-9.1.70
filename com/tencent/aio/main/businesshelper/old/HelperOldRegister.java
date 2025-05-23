package com.tencent.aio.main.businesshelper.old;

import android.util.Log;
import androidx.collection.SparseArrayCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.aio.data.AIOSession;
import com.tencent.aio.main.businesshelper.e;
import com.tencent.aio.main.businesshelper.f;
import com.tencent.aio.main.businesshelper.g;
import com.tencent.aio.pref.annotation.HookMethodTrace;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
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
@Deprecated(message = "\u5e9f\u5f03")
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u0000 62\u00020\u0001:\u00017B\u0011\u0012\b\u00103\u001a\u0004\u0018\u000100\u00a2\u0006\u0004\b4\u00105J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001d\u0010\r\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0003\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0013H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\f\u0010\u0018\u001a\u00020\u0004*\u00020\u0002H\u0002J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\f\u0010\u001d\u001a\u00020\u001c*\u00020\u0006H\u0002J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0017J\b\u0010 \u001a\u00020\u0004H\u0016J\u0018\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016R\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010%R\u0016\u0010(\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010'R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00110)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010*R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020,0)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010*R \u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130)0)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010*R\u0016\u0010/\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010%R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00068"}, d2 = {"Lcom/tencent/aio/main/businesshelper/old/HelperOldRegister;", "Lcom/tencent/aio/main/businesshelper/f;", "", "state", "", "j", "Lcom/tencent/aio/api/runtime/a;", "aioContext", DomainData.DOMAIN_NAME, "o", "", "Lcom/tencent/aio/main/businesshelper/h;", "helpers", "i", "([Lcom/tencent/aio/main/businesshelper/h;)V", "helper", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aio/main/businesshelper/e;", "k", "Lcom/tencent/aio/main/businesshelper/g;", "l", "e", "f", "g", "d", "Landroidx/lifecycle/Lifecycle$Event;", "event", h.F, "Lcom/tencent/aio/api/help/a;", "c", "onCreate", "V", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroidx/lifecycle/LifecycleOwner;", "source", "onStateChanged", "", "Z", "DEBUG", "Lcom/tencent/aio/api/runtime/a;", "mAioContext", "Landroidx/collection/SparseArrayCompat;", "Landroidx/collection/SparseArrayCompat;", "mHelpers", "Lcom/tencent/aio/api/help/b;", "mAsyncHelpers", "mLifecycleObservers", "mUseCache", "Lcom/tencent/aio/main/businesshelper/old/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/aio/main/businesshelper/old/b;", "mHelperProvider", "<init>", "(Lcom/tencent/aio/main/businesshelper/old/b;)V", "D", "a", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class HelperOldRegister implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private b mHelperProvider;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean DEBUG;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAioContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final SparseArrayCompat<e> mHelpers;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final SparseArrayCompat<com.tencent.aio.api.help.b> mAsyncHelpers;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final SparseArrayCompat<SparseArrayCompat<g>> mLifecycleObservers;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mUseCache;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/main/businesshelper/old/HelperOldRegister$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.main.businesshelper.old.HelperOldRegister$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43089);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public HelperOldRegister(@Nullable b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bVar);
            return;
        }
        this.mHelperProvider = bVar;
        this.DEBUG = com.tencent.aio.base.a.f69150c.a();
        this.mHelpers = new SparseArrayCompat<>();
        this.mAsyncHelpers = new SparseArrayCompat<>();
        this.mLifecycleObservers = new SparseArrayCompat<>(12);
    }

    public static final /* synthetic */ com.tencent.aio.api.runtime.a a(HelperOldRegister helperOldRegister) {
        com.tencent.aio.api.runtime.a aVar = helperOldRegister.mAioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAioContext");
        }
        return aVar;
    }

    private final com.tencent.aio.api.help.a c(com.tencent.aio.api.runtime.a aVar) {
        com.tencent.aio.api.help.a aVar2 = new com.tencent.aio.api.help.a(AIOSession.b(aVar.g().r(), null, 1, null));
        aVar2.c(aVar.g());
        return aVar2;
    }

    private final void d(int i3) {
        SparseArrayCompat<g> sparseArrayCompat = this.mLifecycleObservers.get(i3);
        if (sparseArrayCompat != null) {
            Intrinsics.checkNotNullExpressionValue(sparseArrayCompat, "mLifecycleObservers.get(this) ?: return");
            int size = sparseArrayCompat.size();
            for (int i16 = 0; i16 < size; i16++) {
                g valueAt = sparseArrayCompat.valueAt(i16);
                Intrinsics.checkNotNullExpressionValue(valueAt, "observers.valueAt(i)");
                valueAt.onMoveToState(i3);
            }
        }
    }

    @HookMethodTrace(tag = "HelperRegister#dispatchLifeOnCreate")
    private final void e(int state) {
        d(state);
    }

    @HookMethodTrace(tag = "HelperRegister#dispatchLifeOnResume")
    private final void f(int state) {
        d(state);
    }

    @HookMethodTrace(tag = "HelperRegister#dispatchLifeOnStart")
    private final void g(int state) {
        d(state);
    }

    private final int h(Lifecycle.Event event) {
        switch (a.f69375a[event.ordinal()]) {
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

    @HookMethodTrace(tag = "HelperRegister#handleHelperOnCreate")
    private final void i(com.tencent.aio.main.businesshelper.h[] helpers) {
        for (com.tencent.aio.main.businesshelper.h hVar : helpers) {
            m(hVar);
        }
    }

    private final void j(int state) {
        SparseArrayCompat<g> sparseArrayCompat = this.mLifecycleObservers.get(state);
        if (sparseArrayCompat != null) {
            Intrinsics.checkNotNullExpressionValue(sparseArrayCompat, "mLifecycleObservers.get(state) ?: return");
            int size = sparseArrayCompat.size();
            for (int i3 = 0; i3 < size; i3++) {
                g valueAt = sparseArrayCompat.valueAt(i3);
                Intrinsics.checkNotNullExpressionValue(valueAt, "observers.valueAt(i)");
                valueAt.onMoveToState(state);
            }
        }
    }

    private final void k(e helper) {
        boolean z16;
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
        com.tencent.aio.api.runtime.a aVar = this.mAioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAioContext");
        }
        com.tencent.aio.main.businesshelper.p000new.b.a(helper, new com.tencent.aio.main.businesshelper.b(aVar, false, 2, null));
        this.mHelpers.put(helper.getId(), helper);
        if (helper instanceof com.tencent.aio.api.help.b) {
            this.mAsyncHelpers.put(helper.getId(), helper);
            com.tencent.aio.api.runtime.a aVar2 = this.mAioContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAioContext");
            }
            LifecycleOwner d16 = aVar2.d();
            Intrinsics.checkNotNullExpressionValue(d16, "mAioContext.lifecycleOwner");
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(d16), Dispatchers.getDefault(), null, new HelperOldRegister$register$2(this, helper, null), 2, null);
        }
    }

    private final void l(g helper) {
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

    private final void m(com.tencent.aio.main.businesshelper.h helper) {
        if (helper != null) {
            k(helper);
            l(helper);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.aio.main.businesshelper.IHelper");
    }

    private final void n(com.tencent.aio.api.runtime.a aioContext) {
        com.tencent.aio.main.businesshelper.h[] b16;
        b bVar = this.mHelperProvider;
        if (bVar != null && (b16 = bVar.b(c(aioContext))) != null) {
            i(b16);
        }
    }

    private final void o(com.tencent.aio.api.runtime.a aioContext) {
        e[] c16;
        b bVar = this.mHelperProvider;
        if (bVar != null && (c16 = bVar.c(c(aioContext))) != null) {
            for (e eVar : c16) {
                k(eVar);
            }
        }
    }

    @Override // com.tencent.aio.main.businesshelper.f
    @HookMethodTrace(tag = "HelperRegister#delayLoad")
    public void V(@NotNull com.tencent.aio.api.runtime.a aioContext) {
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
                o(aioContext);
            } else {
                aVar.b("registerNormalHelper");
                String str = "AIO#registerNormalHelper";
                if (!aVar.h()) {
                    o(aioContext);
                    Unit unit = Unit.INSTANCE;
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    o(aioContext);
                    Unit unit2 = Unit.INSTANCE;
                    Log.w("AIO#", str + " spend " + (System.currentTimeMillis() - currentTimeMillis));
                }
                aVar.e();
            }
        }
        j(4);
    }

    @Override // com.tencent.aio.main.businesshelper.f
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a aioContext) {
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
            n(aioContext);
            return;
        }
        this.mUseCache = true;
        SparseArrayCompat<e> sparseArrayCompat = this.mHelpers;
        int size = sparseArrayCompat.size();
        for (int i3 = 0; i3 < size; i3++) {
            sparseArrayCompat.keyAt(i3);
            com.tencent.aio.main.businesshelper.p000new.b.a(sparseArrayCompat.valueAt(i3), new com.tencent.aio.main.businesshelper.b(aioContext, false, 2, null));
        }
        if (!this.mAsyncHelpers.isEmpty()) {
            LifecycleOwner d16 = aioContext.d();
            Intrinsics.checkNotNullExpressionValue(d16, "aioContext.lifecycleOwner");
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(d16), Dispatchers.getDefault(), null, new HelperOldRegister$onCreate$3(this, aioContext, null), 2, null);
        }
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
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getDefault(), null, new HelperOldRegister$onDestroy$2(this, null), 2, null);
        SparseArrayCompat<e> sparseArrayCompat = this.mHelpers;
        int size = sparseArrayCompat.size();
        for (int i3 = 0; i3 < size; i3++) {
            sparseArrayCompat.keyAt(i3);
            e valueAt = sparseArrayCompat.valueAt(i3);
            valueAt.onDestroy();
            b bVar = this.mHelperProvider;
            if (bVar != null) {
                bVar.a(valueAt);
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
        int h16 = h(event);
        if (h16 != 0) {
            if (h16 != 1) {
                if (h16 != 3) {
                    d(h16);
                    return;
                } else {
                    f(h16);
                    return;
                }
            }
            g(h16);
            return;
        }
        e(h16);
    }
}
