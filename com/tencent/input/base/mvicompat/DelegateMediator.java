package com.tencent.input.base.mvicompat;

import com.tencent.input.base.mvicompat.a;
import com.tencent.input.base.mvicompat.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0013\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u000e\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u0003*\u001a\b\u0003\u0010\u0006*\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00052\u00020\u0007B\u000f\u0012\u0006\u0010\u0018\u001a\u00028\u0002\u00a2\u0006\u0004\b!\u0010\"J+\u0010\r\u001a\u00020\f2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u00030\b2\u0006\u0010\u000b\u001a\u00028\u0003H$\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00030\u00102\b\b\u0002\u0010\u000f\u001a\u00028\u0002H&\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00028\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00028\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R'\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u00030\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR!\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00030\u00108DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u001a\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/input/base/mvicompat/DelegateMediator;", "TypeToHost", "TypeToDelegate", "Lcom/tencent/input/base/mvicompat/b;", "H", "Lcom/tencent/input/base/mvicompat/a;", "D", "", "", "", "table", "delegate", "", "k", "(Ljava/util/Map;Lcom/tencent/input/base/mvicompat/a;)V", "host", "", "i", "(Lcom/tencent/input/base/mvicompat/b;)Ljava/util/List;", SemanticAttributes.DbCassandraConsistencyLevelValues.ANY, "f", "(Ljava/lang/Object;)V", "d", "Lcom/tencent/input/base/mvicompat/b;", "mHost", "e", "Lkotlin/Lazy;", "g", "()Ljava/util/Map;", "mActionTable", tl.h.F, "()Ljava/util/List;", "mDelegateList", "<init>", "(Lcom/tencent/input/base/mvicompat/b;)V", "input-base_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public abstract class DelegateMediator<TypeToHost, TypeToDelegate, H extends b<TypeToHost>, D extends a<TypeToHost, TypeToDelegate, H>> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final H mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mActionTable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mDelegateList;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12152);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        }
    }

    public DelegateMediator(@NotNull H mHost) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mHost);
            return;
        }
        this.mHost = mHost;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<Map<String, D>>(this) { // from class: com.tencent.input.base.mvicompat.DelegateMediator$mActionTable$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ DelegateMediator<TypeToHost, TypeToDelegate, H, D> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<String, D> invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Map) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                Map<String, D> linkedHashMap = new LinkedHashMap<>();
                DelegateMediator<TypeToHost, TypeToDelegate, H, D> delegateMediator = this.this$0;
                Iterator it = delegateMediator.h().iterator();
                while (it.hasNext()) {
                    delegateMediator.k(linkedHashMap, (a) it.next());
                }
                return linkedHashMap;
            }
        });
        this.mActionTable = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<List<? extends D>>(this) { // from class: com.tencent.input.base.mvicompat.DelegateMediator$mDelegateList$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ DelegateMediator<TypeToHost, TypeToDelegate, H, D> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<D> invoke() {
                b bVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (List) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                List<D> j3 = DelegateMediator.j(this.this$0, null, 1, null);
                DelegateMediator<TypeToHost, TypeToDelegate, H, D> delegateMediator = this.this$0;
                for (D d16 : j3) {
                    bVar = ((DelegateMediator) delegateMediator).mHost;
                    d16.L0(bVar);
                }
                return j3;
            }
        });
        this.mDelegateList = lazy2;
    }

    private final Map<String, D> g() {
        return (Map) this.mActionTable.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List j(DelegateMediator delegateMediator, b bVar, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                bVar = delegateMediator.mHost;
            }
            return delegateMediator.i(bVar);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initializeDelegates");
    }

    public final void f(TypeToDelegate any) {
        String canonicalName;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) any);
            return;
        }
        Map<String, D> g16 = g();
        Intrinsics.checkNotNull(any);
        Class<? super Object> superclass = any.getClass().getSuperclass();
        String str = "";
        if (superclass == null || (canonicalName = superclass.getCanonicalName()) == null) {
            canonicalName = "";
        }
        D d16 = g16.get(canonicalName);
        if (d16 == null) {
            Map<String, D> g17 = g();
            String canonicalName2 = any.getClass().getCanonicalName();
            if (canonicalName2 != null) {
                str = canonicalName2;
            }
            d16 = g17.get(str);
        }
        if (d16 != null) {
            d16.accept(any);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final List<D> h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return (List) this.mDelegateList.getValue();
    }

    @NotNull
    public abstract List<D> i(@NotNull H host);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void k(@NotNull Map<String, D> table, @NotNull D delegate);
}
