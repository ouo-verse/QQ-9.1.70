package com.tencent.mobileqq.aio.helper;

import a81.b;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.aio.msglist.holder.component.ark.ArkAppContainerEvent;
import com.tencent.mobileqq.aio.msglist.holder.component.ark.view.ArkAppContainer;
import com.tencent.mobileqq.aio.msglist.z;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qqnt.aio.adapter.api.IArkApi;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0007*\u0001*\b\u0007\u0018\u0000 \n2\u00020\u00012\u00020\u0002:\u00017B\u0007\u00a2\u0006\u0004\b5\u00106J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0004\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0002J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0010H\u0016J\u001c\u0010!\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eJ\u0010\u0010\"\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\r\u001a\u00020\fJ\u001c\u0010#\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eJ\u0010\u0010$\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010%\u001a\u00020\u0007J\u0006\u0010&\u001a\u00020\u0007J\u0014\u0010'\u001a\u00020\u00072\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eR\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010,\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R&\u00103\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u00102R&\u00104\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u00102\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/t;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "j", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "", "messageId", "g", tl.h.F, "", "type", "t", "v", "getId", "", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/ark/view/ArkAppContainer;", "arkAppContainerWeakReference", "r", "o", ReportConstant.COSTREPORT_PREFIX, "p", "u", "c", "e", "d", "Lcom/tencent/aio/main/businesshelper/b;", "com/tencent/mobileqq/aio/helper/t$b", "Lcom/tencent/mobileqq/aio/helper/t$b;", "mActionR", "La81/c;", "f", "La81/c;", "arkAppContainerMRUUpdater", "", "Ljava/util/Map;", "arkAppContainerMap", "arkAppContainerShotMap", "<init>", "()V", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes10.dex */
public final class t implements com.tencent.aio.main.businesshelper.h, com.tencent.mvi.base.route.g {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.main.businesshelper.b param;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mActionR;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a81.c arkAppContainerMRUUpdater;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Long, WeakReference<ArkAppContainer>> arkAppContainerMap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Long, WeakReference<ArkAppContainer>> arkAppContainerShotMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001e\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u001e\u0010\t\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u001e\u0010\n\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u001e\u0010\u000b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/t$a;", "", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/ark/view/ArkAppContainer;", "weakRef", "", "d", "c", "e", "a", "Lcom/tencent/mobileqq/aio/helper/t;", "b", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.helper.t$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                return;
            }
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) defaultConstructorMarker);
        }

        public final void a(@Nullable com.tencent.aio.api.runtime.a aioContext, @NotNull WeakReference<ArkAppContainer> weakRef) {
            t b16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) aioContext, (Object) weakRef);
                return;
            }
            Intrinsics.checkNotNullParameter(weakRef, "weakRef");
            if (aioContext != null && aioContext.e() != null && (b16 = b(aioContext)) != null) {
                b16.e(weakRef);
            }
        }

        @Nullable
        public final t b(@Nullable com.tencent.aio.api.runtime.a aioContext) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (t) iPatchRedirector.redirect((short) 6, (Object) this, (Object) aioContext);
            }
            if (aioContext != null && aioContext.e() != null) {
                com.tencent.mvi.base.route.k k3 = aioContext.e().k(ArkAppContainerEvent.ArkContainerHelper.f190674d);
                if (k3 != null) {
                    return ((b.a) k3).getArkContainerHelper();
                }
            }
            return null;
        }

        public final void c(@Nullable com.tencent.aio.api.runtime.a aioContext, @NotNull WeakReference<ArkAppContainer> weakRef) {
            t b16;
            a81.c cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) aioContext, (Object) weakRef);
                return;
            }
            Intrinsics.checkNotNullParameter(weakRef, "weakRef");
            if (aioContext != null && aioContext.e() != null && (b16 = b(aioContext)) != null && (cVar = b16.arkAppContainerMRUUpdater) != null) {
                cVar.o(weakRef);
            }
        }

        public final void d(@Nullable com.tencent.aio.api.runtime.a aioContext, @NotNull WeakReference<ArkAppContainer> weakRef) {
            t b16;
            a81.c cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aioContext, (Object) weakRef);
                return;
            }
            Intrinsics.checkNotNullParameter(weakRef, "weakRef");
            if (aioContext != null && aioContext.e() != null && (b16 = b(aioContext)) != null && (cVar = b16.arkAppContainerMRUUpdater) != null) {
                cVar.n(weakRef);
            }
        }

        public final void e(@Nullable com.tencent.aio.api.runtime.a aioContext, @NotNull WeakReference<ArkAppContainer> weakRef) {
            t b16;
            a81.c cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) aioContext, (Object) weakRef);
                return;
            }
            Intrinsics.checkNotNullParameter(weakRef, "weakRef");
            if (aioContext != null && aioContext.e() != null && (b16 = b(aioContext)) != null && (cVar = b16.arkAppContainerMRUUpdater) != null) {
                cVar.p(weakRef);
            }
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/helper/t$b", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements com.tencent.mvi.base.route.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) t.this);
            }
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public com.tencent.mvi.base.route.k call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.mvi.base.route.k) iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            }
            Intrinsics.checkNotNullParameter(i3, "i");
            return t.this.q(i3);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49747);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mActionR = new b();
        this.arkAppContainerMRUUpdater = new a81.c();
        this.arkAppContainerMap = new HashMap();
        this.arkAppContainerShotMap = new HashMap();
    }

    private final void g(long messageId) {
        ArkAppContainer arkAppContainer;
        WeakReference<ArkAppContainer> weakReference = this.arkAppContainerMap.get(Long.valueOf(messageId));
        if (weakReference != null) {
            arkAppContainer = weakReference.get();
        } else {
            arkAppContainer = null;
        }
        if (arkAppContainer == null) {
            return;
        }
        ArkAppContainer arkAppContainer2 = weakReference.get();
        if (arkAppContainer2 != null) {
            arkAppContainer2.doOnEvent(2);
        }
        if (arkAppContainer2 != null) {
            arkAppContainer2.j(null);
        }
    }

    private final void h(long messageId) {
        ArkAppContainer arkAppContainer;
        WeakReference<ArkAppContainer> weakReference = this.arkAppContainerShotMap.get(Long.valueOf(messageId));
        if (weakReference != null) {
            arkAppContainer = weakReference.get();
        } else {
            arkAppContainer = null;
        }
        if (arkAppContainer == null) {
            return;
        }
        ArkAppContainer arkAppContainer2 = weakReference.get();
        if (arkAppContainer2 != null) {
            arkAppContainer2.doOnEvent(2);
        }
        if (arkAppContainer2 != null) {
            arkAppContainer2.j(null);
        }
    }

    private final void i(int type) {
        Iterator<Map.Entry<Long, WeakReference<ArkAppContainer>>> it = this.arkAppContainerMap.entrySet().iterator();
        while (it.hasNext()) {
            ArkAppContainer arkAppContainer = it.next().getValue().get();
            if (arkAppContainer != null) {
                arkAppContainer.doOnEvent(type);
            }
        }
    }

    private final void j() {
        a81.e.INSTANCE.s();
    }

    private final void k() {
        c();
        v();
        a81.e.INSTANCE.u();
    }

    private final void m() {
        ((IArkApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IArkApi.class)).stopArkSilkAudio();
        i(0);
    }

    private final void n() {
        i(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mvi.base.route.k q(MsgIntent i3) {
        if (i3 instanceof ArkAppContainerEvent.ArkContainerHelper) {
            return new b.a(this);
        }
        return z.k.f192765a;
    }

    private final void t() {
        com.tencent.aio.main.businesshelper.b bVar = this.param;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar = null;
        }
        bVar.a().e().l(this, this.mActionR);
    }

    private final void v() {
        com.tencent.aio.main.businesshelper.b bVar = this.param;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar = null;
        }
        bVar.a().e().e(this);
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        Iterator<Map.Entry<Long, WeakReference<ArkAppContainer>>> it = this.arkAppContainerMap.entrySet().iterator();
        while (it.hasNext()) {
            g(it.next().getKey().longValue());
        }
        this.arkAppContainerMap.clear();
        Iterator<Map.Entry<Long, WeakReference<ArkAppContainer>>> it5 = this.arkAppContainerShotMap.entrySet().iterator();
        while (it5.hasNext()) {
            h(it5.next().getKey().longValue());
        }
        this.arkAppContainerShotMap.clear();
        this.arkAppContainerMRUUpdater.f();
    }

    public final void e(@NotNull WeakReference<ArkAppContainer> arkAppContainerWeakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) arkAppContainerWeakReference);
            return;
        }
        Intrinsics.checkNotNullParameter(arkAppContainerWeakReference, "arkAppContainerWeakReference");
        Iterator<Map.Entry<Long, WeakReference<ArkAppContainer>>> it = this.arkAppContainerMap.entrySet().iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next().getValue(), arkAppContainerWeakReference)) {
                it.remove();
                return;
            }
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 4;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Set) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return new HashSet();
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (Set) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.msglist.holder.component.ark.ArkAppContainerEvent.ArkContainerHelper");
        return hashSet;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "ArkContainerHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (int[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new int[]{0, 3, 8, 12};
    }

    @Nullable
    public final ArkAppContainer o(long messageId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ArkAppContainer) iPatchRedirector.redirect((short) 8, (Object) this, messageId);
        }
        WeakReference<ArkAppContainer> weakReference = this.arkAppContainerMap.get(Long.valueOf(messageId));
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        this.param = param;
        t();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            h.a.b(this);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, state);
            return;
        }
        if (state != 0) {
            if (state != 3) {
                if (state != 8) {
                    if (state == 12) {
                        k();
                        return;
                    }
                    return;
                }
                m();
                return;
            }
            n();
            return;
        }
        j();
    }

    @Nullable
    public final ArkAppContainer p(long messageId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ArkAppContainer) iPatchRedirector.redirect((short) 10, (Object) this, messageId);
        }
        WeakReference<ArkAppContainer> weakReference = this.arkAppContainerShotMap.get(Long.valueOf(messageId));
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final void r(long messageId, @NotNull WeakReference<ArkAppContainer> arkAppContainerWeakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Long.valueOf(messageId), arkAppContainerWeakReference);
        } else {
            Intrinsics.checkNotNullParameter(arkAppContainerWeakReference, "arkAppContainerWeakReference");
            this.arkAppContainerMap.put(Long.valueOf(messageId), arkAppContainerWeakReference);
        }
    }

    public final void s(long messageId, @NotNull WeakReference<ArkAppContainer> arkAppContainerWeakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Long.valueOf(messageId), arkAppContainerWeakReference);
        } else {
            Intrinsics.checkNotNullParameter(arkAppContainerWeakReference, "arkAppContainerWeakReference");
            this.arkAppContainerShotMap.put(Long.valueOf(messageId), arkAppContainerWeakReference);
        }
    }

    public final void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        Iterator<Map.Entry<Long, WeakReference<ArkAppContainer>>> it = this.arkAppContainerMap.entrySet().iterator();
        while (it.hasNext()) {
            ArkAppContainer arkAppContainer = it.next().getValue().get();
            if (arkAppContainer != null) {
                arkAppContainer.needRefresh = true;
            }
        }
        Iterator<Map.Entry<Long, WeakReference<ArkAppContainer>>> it5 = this.arkAppContainerShotMap.entrySet().iterator();
        while (it5.hasNext()) {
            ArkAppContainer arkAppContainer2 = it5.next().getValue().get();
            if (arkAppContainer2 != null) {
                arkAppContainer2.needRefresh = true;
            }
        }
    }
}
