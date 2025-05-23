package com.tencent.mobileqq.zplan.minixwconnected.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.zplan.minixwconnected.c;
import com.tencent.mobileqq.zplan.minixwconnected.controller.MiniHomeConnectedController;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000  2\u00020\u0001:\u0001\bB\u001d\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016R\u0017\u0010\u000b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001a\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0019R\u001b\u0010\u001c\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001b\u0010\u0019R\u001b\u0010\u001d\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectFunctionBtnComponent;", "Lcom/tencent/mobileqq/zplan/minixwconnected/c;", "", HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW, "Landroid/view/View;", "f", "destroy", "Landroid/content/Context;", "a", "Landroid/content/Context;", "()Landroid/content/Context;", "context", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/zplan/minixwconnected/controller/MiniHomeConnectedController;", "b", "Lmqq/util/WeakReference;", "()Lmqq/util/WeakReference;", "controllerRef", "Landroid/widget/RelativeLayout;", "c", "Landroid/widget/RelativeLayout;", "funtionBtnLayout", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectIconLayout;", "d", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectIconLayout;", "neighborIconLayout", "e", "strangerVisitIconLayout", "plantingIconLayout", "<init>", "(Landroid/content/Context;Lmqq/util/WeakReference;)V", "g", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MiniHomeConnectFunctionBtnComponent implements com.tencent.mobileqq.zplan.minixwconnected.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final WeakReference<MiniHomeConnectedController> controllerRef;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout funtionBtnLayout;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy neighborIconLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy strangerVisitIconLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy plantingIconLayout;

    public MiniHomeConnectFunctionBtnComponent(Context context, WeakReference<MiniHomeConnectedController> controllerRef) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(controllerRef, "controllerRef");
        this.context = context;
        this.controllerRef = controllerRef;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MiniHomeConnectIconLayout>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectFunctionBtnComponent$neighborIconLayout$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MiniHomeConnectIconLayout invoke() {
                boolean z16 = false;
                MiniHomeConnectIconLayout miniHomeConnectIconLayout = new MiniHomeConnectIconLayout(MiniHomeConnectFunctionBtnComponent.this.getContext(), c.b(MiniHomeConnectFunctionBtnComponent.this.getContext(), R.drawable.qui_intimate, 0, 4, null), "\u90bb\u5c45");
                MiniHomeConnectFunctionBtnComponent miniHomeConnectFunctionBtnComponent = MiniHomeConnectFunctionBtnComponent.this;
                miniHomeConnectIconLayout.setTag("neighborIcon");
                ViewGroup.LayoutParams layoutParams = miniHomeConnectIconLayout.getLayoutParams();
                RelativeLayout.LayoutParams layoutParams2 = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
                if (layoutParams2 != null) {
                    MiniHomeConnectedController miniHomeConnectedController = miniHomeConnectFunctionBtnComponent.b().get();
                    if (miniHomeConnectedController != null && miniHomeConnectedController.L()) {
                        z16 = true;
                    }
                    layoutParams2.addRule(z16 ? 13 : 11);
                }
                return miniHomeConnectIconLayout;
            }
        });
        this.neighborIconLayout = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<MiniHomeConnectIconLayout>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectFunctionBtnComponent$strangerVisitIconLayout$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MiniHomeConnectIconLayout invoke() {
                MiniHomeConnectIconLayout miniHomeConnectIconLayout = new MiniHomeConnectIconLayout(MiniHomeConnectFunctionBtnComponent.this.getContext(), c.b(MiniHomeConnectFunctionBtnComponent.this.getContext(), R.drawable.qui_search_new_devices, 0, 4, null), "\u4e32\u95e8");
                miniHomeConnectIconLayout.setTag("strangerVisitIcon");
                ViewGroup.LayoutParams layoutParams = miniHomeConnectIconLayout.getLayoutParams();
                RelativeLayout.LayoutParams layoutParams2 = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
                if (layoutParams2 != null) {
                    layoutParams2.addRule(9);
                }
                return miniHomeConnectIconLayout;
            }
        });
        this.strangerVisitIconLayout = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<MiniHomeConnectIconLayout>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectFunctionBtnComponent$plantingIconLayout$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MiniHomeConnectIconLayout invoke() {
                MiniHomeConnectIconLayout miniHomeConnectIconLayout = new MiniHomeConnectIconLayout(MiniHomeConnectFunctionBtnComponent.this.getContext(), MiniHomeConnectFunctionBtnComponent.this.getContext().getDrawable(R.drawable.igw), "\u79cd\u82b1");
                miniHomeConnectIconLayout.setTag("plantingIcon");
                ViewGroup.LayoutParams layoutParams = miniHomeConnectIconLayout.getLayoutParams();
                RelativeLayout.LayoutParams layoutParams2 = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
                if (layoutParams2 != null) {
                    layoutParams2.addRule(11);
                }
                return miniHomeConnectIconLayout;
            }
        });
        this.plantingIconLayout = lazy3;
    }

    private final MiniHomeConnectIconLayout c() {
        return (MiniHomeConnectIconLayout) this.neighborIconLayout.getValue();
    }

    private final MiniHomeConnectIconLayout d() {
        return (MiniHomeConnectIconLayout) this.plantingIconLayout.getValue();
    }

    private final MiniHomeConnectIconLayout e() {
        return (MiniHomeConnectIconLayout) this.strangerVisitIconLayout.getValue();
    }

    /* renamed from: a, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    public final WeakReference<MiniHomeConnectedController> b() {
        return this.controllerRef;
    }

    @Override // com.tencent.mobileqq.zplan.minixwconnected.c
    public void create(Object obj) {
        c.a.a(this, obj);
    }

    @Override // com.tencent.mobileqq.zplan.minixwconnected.c
    public void createView() {
        QLog.i("MiniHomeConnectNeighborComponent", 1, HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW);
        if (this.funtionBtnLayout != null) {
            QLog.i("MiniHomeConnectNeighborComponent", 1, "createView, funtionBtnLayout exists.");
            return;
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.context);
        MiniHomeConnectedController miniHomeConnectedController = this.controllerRef.get();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.tencent.sqshow.zootopia.utils.i.b(miniHomeConnectedController != null && miniHomeConnectedController.L() ? 267 : 170), com.tencent.sqshow.zootopia.utils.i.b(76));
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = com.tencent.sqshow.zootopia.utils.i.b(48);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.addView(e());
        relativeLayout.addView(c());
        MiniHomeConnectedController miniHomeConnectedController2 = this.controllerRef.get();
        if (miniHomeConnectedController2 != null && miniHomeConnectedController2.L()) {
            relativeLayout.addView(d());
        }
        this.funtionBtnLayout = relativeLayout;
    }

    @Override // com.tencent.mobileqq.zplan.minixwconnected.c
    public void destroy() {
        QLog.i("MiniHomeConnectNeighborComponent", 1, "destroy, funtionBtnLayout: " + this.funtionBtnLayout);
        RelativeLayout relativeLayout = this.funtionBtnLayout;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        this.funtionBtnLayout = null;
    }

    public View f() {
        QLog.i("MiniHomeConnectNeighborComponent", 1, "getView, funtionBtnLayout: " + this.funtionBtnLayout);
        return this.funtionBtnLayout;
    }

    @Override // com.tencent.mobileqq.zplan.minixwconnected.c
    public void pause() {
        c.a.d(this);
    }

    @Override // com.tencent.mobileqq.zplan.minixwconnected.c
    public void resume() {
        c.a.e(this);
    }
}
