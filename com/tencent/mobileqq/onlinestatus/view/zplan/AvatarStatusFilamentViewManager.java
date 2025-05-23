package com.tencent.mobileqq.onlinestatus.view.zplan;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.msg.api.IFeatureSwitch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016R\u0016\u0010\u0017\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0018R0\u0010\u001e\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001b0\u001aj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001b`\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusFilamentViewManager;", "", "", "g", "Lcom/tencent/mobileqq/onlinestatus/view/zplan/k;", ParseCommon.CONTAINER, "", "b", "k", "l", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/onlinestatus/view/zplan/j;", "f", "d", "i", "e", "c", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", tl.h.F, "a", "Z", "reuseFilamentView", "Lcom/tencent/mobileqq/onlinestatus/view/zplan/j;", "filamentView", "Ljava/util/ArrayList;", "Lmqq/util/WeakReference;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "containers", "Lcom/tencent/mobileqq/onlinestatus/view/zplan/k;", "currentContainer", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class AvatarStatusFilamentViewManager {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final Lazy<AvatarStatusFilamentViewManager> f256774f;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private j filamentView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private k currentContainer;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean reuseFilamentView = g();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<WeakReference<k>> containers = new ArrayList<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusFilamentViewManager$a;", "", "Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusFilamentViewManager;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusFilamentViewManager;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.onlinestatus.view.zplan.AvatarStatusFilamentViewManager$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AvatarStatusFilamentViewManager a() {
            return (AvatarStatusFilamentViewManager) AvatarStatusFilamentViewManager.f256774f.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<AvatarStatusFilamentViewManager> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AvatarStatusFilamentViewManager>() { // from class: com.tencent.mobileqq.onlinestatus.view.zplan.AvatarStatusFilamentViewManager$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AvatarStatusFilamentViewManager invoke() {
                return new AvatarStatusFilamentViewManager();
            }
        });
        f256774f = lazy;
    }

    private final void b(k container) {
        e();
        synchronized (this.containers) {
            l();
            Iterator<WeakReference<k>> it = this.containers.iterator();
            while (it.hasNext()) {
                if (it.next().get() == container) {
                    return;
                }
            }
            this.containers.add(new WeakReference<>(container));
        }
    }

    private final void d() {
        synchronized (this.containers) {
            l();
            if (this.containers.isEmpty()) {
                i();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void e() {
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            QLog.i("AvatarStatus.FilamentViewManager", 1, "[checkCallingThread] callstack=" + QLog.getStackTraceString(new RuntimeException()));
        }
    }

    private final j f(Context context) {
        Integer num;
        if (!this.reuseFilamentView) {
            AvatarStatusFilamentView avatarStatusFilamentView = new AvatarStatusFilamentView(context);
            QLog.i("AvatarStatus.FilamentViewManager", 1, "[initFilamentView] no reuse, create new instance, filamentView=" + avatarStatusFilamentView.hashCode());
            return avatarStatusFilamentView;
        }
        j jVar = this.filamentView;
        ViewGroup viewGroup = null;
        if (jVar == null) {
            AvatarStatusFilamentView avatarStatusFilamentView2 = new AvatarStatusFilamentView(context);
            this.filamentView = avatarStatusFilamentView2;
            QLog.i("AvatarStatus.FilamentViewManager", 1, "[initFilamentView], create new, filamentView=" + Integer.valueOf(avatarStatusFilamentView2.hashCode()));
        } else {
            if (jVar != null) {
                num = Integer.valueOf(jVar.hashCode());
            } else {
                num = null;
            }
            QLog.i("AvatarStatus.FilamentViewManager", 1, "[initFilamentView], reuse, filamentView=" + num);
        }
        j jVar2 = this.filamentView;
        Intrinsics.checkNotNull(jVar2);
        View view = jVar2.getView();
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        }
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        return jVar2;
    }

    private final boolean g() {
        return ((IFeatureSwitch) QRoute.api(IFeatureSwitch.class)).isFeatureSwitchEnable("online_status_avatar_reuse_filament_view");
    }

    private final void i() {
        j jVar = this.filamentView;
        if (jVar != null) {
            QLog.i("AvatarStatus.FilamentViewManager", 1, "[releaseFilamentView] release filament view, filamentView=" + jVar.hashCode());
            jVar.b(null);
            jVar.release();
        }
        this.filamentView = null;
        this.currentContainer = null;
    }

    private final void k(k container) {
        synchronized (this.containers) {
            l();
            Iterator<WeakReference<k>> it = this.containers.iterator();
            while (it.hasNext()) {
                WeakReference<k> next = it.next();
                if (next.get() == container) {
                    this.containers.remove(next);
                    return;
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void l() {
        Iterator<WeakReference<k>> it = this.containers.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "containers.iterator()");
        while (it.hasNext()) {
            WeakReference<k> next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "it.next()");
            if (next.get() == null) {
                it.remove();
            }
        }
    }

    @NotNull
    public j c(@NotNull Context context, @NotNull k container) {
        Integer num;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(container, "container");
        b(container);
        k kVar = this.currentContainer;
        if (kVar == container) {
            QLog.i("AvatarStatus.FilamentViewManager", 1, "[bindView] already bound, should not happen, container=" + container.hashCode());
        } else {
            if (kVar != null) {
                num = Integer.valueOf(kVar.hashCode());
            } else {
                num = null;
            }
            QLog.i("AvatarStatus.FilamentViewManager", 1, "[bindView] attach, container=" + num + "->" + container.hashCode());
            k kVar2 = this.currentContainer;
            if (kVar2 != null) {
                kVar2.a();
            }
            this.currentContainer = container;
        }
        return f(context);
    }

    public void h() {
        e();
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("force_release_filament_view", true)) {
            return;
        }
        BaseApplication context = BaseApplication.getContext();
        synchronized (this.containers) {
            Iterator it = new ArrayList(this.containers).iterator();
            while (it.hasNext()) {
                k kVar = (k) ((WeakReference) it.next()).get();
                if (kVar != null) {
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    j(context, kVar);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public void j(@NotNull Context context, @NotNull k container) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(container, "container");
        e();
        m(context, container);
        k(container);
        d();
        if (QLog.isColorLevel()) {
            QLog.i("AvatarStatus.FilamentViewManager", 1, "[releaseView] container=" + container.hashCode() + ", size=" + this.containers.size());
        }
    }

    public void m(@NotNull Context context, @NotNull k container) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(container, "container");
        if (this.currentContainer != container) {
            if (QLog.isColorLevel()) {
                QLog.i("AvatarStatus.FilamentViewManager", 2, "[unbindView] container not bound, container=" + container.hashCode() + ", containerCount=" + this.containers.size());
                return;
            }
            return;
        }
        this.currentContainer = null;
    }
}
