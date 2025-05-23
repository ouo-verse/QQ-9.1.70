package com.tencent.mobileqq.guild.media.thirdapp.container.vb;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.base.api.data.BaseParam;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.g;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVB;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \"2.\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00060\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0007:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\t\u001a\u00020\bH\u0003J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016JJ\u0010\u0012\u001a<\u00128\u00126\u0012\u0006\b\u0001\u0012\u00020\u0010\u0012\u0006\b\u0001\u0012\u00020\u0011\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00060\u0001j\u0012\u0012\u0006\b\u0001\u0012\u00020\u0010\u0012\u0006\b\u0001\u0012\u00020\u0011`\u00070\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001f\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/vb/GuildStandAloneRootVB;", "Lcom/tencent/mvi/mvvm/BaseVB;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/g;", "", "Lcom/tencent/base/api/runtime/a;", "Lcom/tencent/base/api/data/BaseParam;", "Lcom/tencent/base/api/runtime/BaseContext;", "Lcom/tencent/base/mvvm/BaseVB;", "", "f1", "bindViewAndData", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/vm/d;", "d1", "Landroid/view/View;", "hostView", "", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Landroid/view/ViewGroup;", "d", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/widget/FrameLayout;", "e", "Lkotlin/Lazy;", "e1", "()Landroid/widget/FrameLayout;", "dragBarView", "<init>", "()V", "f", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildStandAloneRootVB extends BaseVB<com.tencent.mobileqq.guild.media.thirdapp.container.intent.g, Object, com.tencent.base.api.runtime.a<BaseParam>> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ViewGroup rootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy dragBarView;

    public GuildStandAloneRootVB() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.mobileqq.guild.media.thirdapp.container.vb.GuildStandAloneRootVB$dragBarView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                ViewGroup viewGroup;
                viewGroup = GuildStandAloneRootVB.this.rootView;
                if (viewGroup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                    viewGroup = null;
                }
                return (FrameLayout) viewGroup.findViewById(R.id.f165708xb0);
            }
        });
        this.dragBarView = lazy;
    }

    private final FrameLayout e1() {
        Object value = this.dragBarView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-dragBarView>(...)");
        return (FrameLayout) value;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void f1() {
        e1().setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.guild.media.thirdapp.container.vb.h
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean g16;
                g16 = GuildStandAloneRootVB.g1(GuildStandAloneRootVB.this, view, motionEvent);
                return g16;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g1(GuildStandAloneRootVB this$0, View view, MotionEvent motionEvent) {
        Integer num;
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent != null) {
            num = Integer.valueOf(motionEvent.getAction());
        } else {
            num = null;
        }
        boolean z17 = true;
        if (num != null && num.intValue() == 0) {
            this$0.sendIntent(new g.UpdateDragBar(true));
        } else {
            if ((num != null && num.intValue() == 1) || (num != null && num.intValue() == 4)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 && (num == null || num.intValue() != 3)) {
                z17 = false;
            }
            if (z17) {
                this$0.sendIntent(new g.UpdateDragBar(false));
            }
        }
        return false;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        Logger.f235387a.d().d("QGMC.MediaMiniApp.GuildStandAloneRootVB", 1, "[bindViewAndData] ");
        f1();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.guild.media.thirdapp.container.vm.d createVM() {
        return new com.tencent.mobileqq.guild.media.thirdapp.container.vm.d();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<BaseVB<? extends ol3.b, ? extends MviUIState, com.tencent.base.api.runtime.a<BaseParam>>> initializeChildVB(@NotNull View hostView) {
        List<BaseVB<? extends ol3.b, ? extends MviUIState, com.tencent.base.api.runtime.a<BaseParam>>> listOf;
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new BaseVB[]{new i(), new g()});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        Logger.f235387a.d().d("QGMC.MediaMiniApp.GuildStandAloneRootVB", 1, "[onCreateView] ");
        View inflate = LayoutInflater.from(createViewParams.a()).inflate(R.layout.f168130ez2, createViewParams.b(), false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) inflate;
        this.rootView = viewGroup;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            return null;
        }
        return viewGroup;
    }
}
