package com.tencent.mobileqq.zplan.aigc.helper;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.zplan.aigc.view.dialog.CustomColorSuitListDialogView;
import com.tencent.mobileqq.zplan.aigc.vm.SuitCustomColorVewModel;
import com.tencent.qphone.base.util.QLog;
import ga4.h;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 '2\u00020\u0001:\u0001\u000eB)\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u0012\b\u0010#\u001a\u0004\u0018\u00010\u001f\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0003\u001a\u00020\u0002H\u0002J0\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\nR\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010#\u001a\u0004\u0018\u00010\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b \u0010\"R$\u0010)\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b$\u0010&\"\u0004\b'\u0010(R\"\u0010,\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0018\u00102\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u00101\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/helper/ZPlanUgcDyingSuitListDialogHelper;", "", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "g", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "Lzv4/c;", "", "onSuitCardClick", "Lkotlin/Function0;", "onHintIconClick", "j", "Landroid/view/ViewGroup;", "a", "Landroid/view/ViewGroup;", "getContainer", "()Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Lcom/tencent/mobileqq/zplan/aigc/vm/SuitCustomColorVewModel;", "b", "Lcom/tencent/mobileqq/zplan/aigc/vm/SuitCustomColorVewModel;", "f", "()Lcom/tencent/mobileqq/zplan/aigc/vm/SuitCustomColorVewModel;", "vm", "Landroidx/lifecycle/LifecycleOwner;", "c", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lzd3/a;", "d", "Lzd3/a;", "()Lzd3/a;", "dtReporter", "e", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "()Lcom/tencent/sqshow/zootopia/nativeui/data/j;", tl.h.F, "(Lcom/tencent/sqshow/zootopia/nativeui/data/j;)V", "mChannel", "", "Z", "isShowing", "()Z", "i", "(Z)V", "Lga4/h;", "Lga4/h;", "dismissListener", "<init>", "(Landroid/view/ViewGroup;Lcom/tencent/mobileqq/zplan/aigc/vm/SuitCustomColorVewModel;Landroidx/lifecycle/LifecycleOwner;Lzd3/a;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanUgcDyingSuitListDialogHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ViewGroup container;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final SuitCustomColorVewModel vm;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final zd3.a dtReporter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.sqshow.zootopia.nativeui.data.j mChannel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isShowing;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private ga4.h dismissListener;

    public ZPlanUgcDyingSuitListDialogHelper(ViewGroup container, SuitCustomColorVewModel vm5, LifecycleOwner lifecycleOwner, zd3.a aVar) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(vm5, "vm");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.container = container;
        this.vm = vm5;
        this.lifecycleOwner = lifecycleOwner;
        this.dtReporter = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.sqshow.zootopia.nativeui.data.j g() {
        ga4.i iVar = new ga4.i(this.container);
        com.tencent.sqshow.zootopia.nativeui.data.repo.i iVar2 = new com.tencent.sqshow.zootopia.nativeui.data.repo.i();
        com.tencent.sqshow.zootopia.nativeui.data.j jVar = new com.tencent.sqshow.zootopia.nativeui.data.j(null, iVar);
        jVar.Z(this.lifecycleOwner);
        jVar.T(iVar2);
        return jVar;
    }

    /* renamed from: d, reason: from getter */
    public final zd3.a getDtReporter() {
        return this.dtReporter;
    }

    /* renamed from: e, reason: from getter */
    public final com.tencent.sqshow.zootopia.nativeui.data.j getMChannel() {
        return this.mChannel;
    }

    /* renamed from: f, reason: from getter */
    public final SuitCustomColorVewModel getVm() {
        return this.vm;
    }

    public final void h(com.tencent.sqshow.zootopia.nativeui.data.j jVar) {
        this.mChannel = jVar;
    }

    public final void i(boolean z16) {
        this.isShowing = z16;
    }

    public final void j(final Context context, final Function1<? super zv4.c, Unit> onSuitCardClick, final Function0<Unit> onHintIconClick) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onSuitCardClick, "onSuitCardClick");
        Intrinsics.checkNotNullParameter(onHintIconClick, "onHintIconClick");
        t74.l.f435563a.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.helper.ZPlanUgcDyingSuitListDialogHelper$showSuitListDialog$1

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zplan/aigc/helper/ZPlanUgcDyingSuitListDialogHelper$showSuitListDialog$1$a", "Lga4/h;", "Lga4/g;", "panelDialog", "", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes35.dex */
            public static final class a implements ga4.h {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ ZPlanUgcDyingSuitListDialogHelper f330250a;

                a(ZPlanUgcDyingSuitListDialogHelper zPlanUgcDyingSuitListDialogHelper) {
                    this.f330250a = zPlanUgcDyingSuitListDialogHelper;
                }

                @Override // ga4.h
                public void a(ga4.g panelDialog) {
                    Intrinsics.checkNotNullParameter(panelDialog, "panelDialog");
                    QLog.i("ZPlanUgcDyingSuitListDialogHelper", 1, "SuitListDialog panel onDismiss");
                    this.f330250a.i(false);
                }

                @Override // ga4.h
                public void b(ga4.g panelDialog) {
                    Intrinsics.checkNotNullParameter(panelDialog, "panelDialog");
                    h.a.a(this, panelDialog);
                    QLog.i("ZPlanUgcDyingSuitListDialogHelper", 1, "SuitListDialog panel onShow");
                    this.f330250a.i(true);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                com.tencent.sqshow.zootopia.nativeui.data.j g16;
                ga4.f dialogController;
                ga4.h hVar;
                ZPlanUgcDyingSuitListDialogHelper zPlanUgcDyingSuitListDialogHelper = ZPlanUgcDyingSuitListDialogHelper.this;
                g16 = zPlanUgcDyingSuitListDialogHelper.g();
                zPlanUgcDyingSuitListDialogHelper.h(g16);
                com.tencent.sqshow.zootopia.nativeui.data.j mChannel = ZPlanUgcDyingSuitListDialogHelper.this.getMChannel();
                Intrinsics.checkNotNull(mChannel);
                CustomColorSuitListDialogView customColorSuitListDialogView = new CustomColorSuitListDialogView(context, null, 0, mChannel, onSuitCardClick, onHintIconClick, ZPlanUgcDyingSuitListDialogHelper.this.getVm(), ZPlanUgcDyingSuitListDialogHelper.this.getDtReporter(), 6, null);
                ZPlanUgcDyingSuitListDialogHelper zPlanUgcDyingSuitListDialogHelper2 = ZPlanUgcDyingSuitListDialogHelper.this;
                zPlanUgcDyingSuitListDialogHelper2.dismissListener = new a(zPlanUgcDyingSuitListDialogHelper2);
                com.tencent.sqshow.zootopia.nativeui.data.j mChannel2 = ZPlanUgcDyingSuitListDialogHelper.this.getMChannel();
                if (mChannel2 != null && (dialogController = mChannel2.getDialogController()) != null) {
                    hVar = ZPlanUgcDyingSuitListDialogHelper.this.dismissListener;
                    dialogController.c(new WeakReference<>(hVar));
                }
                customColorSuitListDialogView.show();
            }
        });
    }
}
