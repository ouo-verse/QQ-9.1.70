package com.tencent.mobileqq.icgame.framework.component;

import android.view.View;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import k32.a;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u0005B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0006\u001a\u00028\u0001H&\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00028\u0001H\u0000\u00a2\u0006\u0004\b\b\u0010\u0007J\u0006\u0010\n\u001a\u00020\tJ\u0015\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00028\u0000\u00a2\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00028\u00012\u0006\u0010\u000b\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0011\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016R\u001b\u0010\u000e\u001a\u00028\u00018DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/icgame/framework/component/MultiMVVMComponent;", "Landroid/view/View;", "V", "Lk32/a;", "VM", "Lcom/tencent/mobileqq/icgame/framework/component/MultiUiComponent;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lk32/a;", "u", "", "c", "view", "p", "(Landroid/view/View;)V", "vm", ReportConstant.COSTREPORT_PREFIX, "(Lk32/a;Landroid/view/View;)V", "t", "k", "i", tl.h.F, "Lkotlin/Lazy;", "r", "Lf32/a;", "componentContext", "<init>", "(Lf32/a;)V", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public abstract class MultiMVVMComponent<V extends View, VM extends k32.a> extends MultiUiComponent<V> {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy vm;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiMVVMComponent(@NotNull f32.a componentContext) {
        super(componentContext);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(componentContext, "componentContext");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<VM>(this) { // from class: com.tencent.mobileqq.icgame.framework.component.MultiMVVMComponent$vm$2
            final /* synthetic */ MultiMVVMComponent<V, VM> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Incorrect return type in method signature: ()TVM; */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final k32.a invoke() {
                return this.this$0.q();
            }
        });
        this.vm = lazy;
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.MultiUiComponent
    public final void c() {
        t();
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void i() {
        r().M1();
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.MultiUiComponent
    public final void p(@NotNull V view) {
        Intrinsics.checkNotNullParameter(view, "view");
        s(r(), view);
    }

    @NotNull
    public abstract VM q();

    @NotNull
    protected final VM r() {
        return (VM) this.vm.getValue();
    }

    public abstract void s(@NotNull VM vm5, @NotNull V view);

    @NotNull
    public final VM u() {
        return r();
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void k() {
    }

    public void t() {
    }
}
