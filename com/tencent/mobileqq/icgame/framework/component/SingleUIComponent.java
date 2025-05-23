package com.tencent.mobileqq.icgame.framework.component;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.icgame.framework.component.SingleUIComponent$uiComponentProxy$2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0015\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\b\u001a\u00020\u0007J\r\u0010\t\u001a\u00028\u0000\u00a2\u0006\u0004\b\t\u0010\u0006J\u0006\u0010\n\u001a\u00020\u0007J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0010\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0006\u0010\u0014\u001a\u00020\u000bR!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\r\u001a\u00028\u00008DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0017\u001a\u0004\b\u001b\u0010\u0006\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/icgame/framework/component/SingleUIComponent;", "Landroid/view/View;", "V", "Lcom/tencent/mobileqq/icgame/framework/component/b;", "Lcom/tencent/mobileqq/icgame/framework/component/i;", "l", "()Landroid/view/View;", "", "d", "g", tl.h.F, "", "c", "view", "r", "(Landroid/view/View;)V", DomainData.DOMAIN_NAME, "a", "Landroid/view/ViewGroup$LayoutParams;", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "com/tencent/mobileqq/icgame/framework/component/SingleUIComponent$uiComponentProxy$2$a", "e", "Lkotlin/Lazy;", "o", "()Lcom/tencent/mobileqq/icgame/framework/component/SingleUIComponent$uiComponentProxy$2$a;", "uiComponentProxy", "p", "Lf32/a;", "componentContext", "<init>", "(Lf32/a;)V", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public abstract class SingleUIComponent<V extends View> extends b implements i<V> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy uiComponentProxy;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleUIComponent(@NotNull f32.a componentContext) {
        super(componentContext);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(componentContext, "componentContext");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SingleUIComponent$uiComponentProxy$2.a>(this) { // from class: com.tencent.mobileqq.icgame.framework.component.SingleUIComponent$uiComponentProxy$2
            final /* synthetic */ SingleUIComponent<V> this$0;

            /* JADX INFO: Add missing generic type declarations: [V] */
            @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/icgame/framework/component/SingleUIComponent$uiComponentProxy$2$a", "Lcom/tencent/mobileqq/icgame/framework/component/UIComponentProxy;", "e", "()Landroid/view/View;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/ViewGroup$LayoutParams;", "f", "", "c", "view", DomainData.DOMAIN_NAME, "(Landroid/view/View;)V", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes15.dex */
            public static final class a<V> extends UIComponentProxy<V> {

                /* renamed from: m, reason: collision with root package name */
                final /* synthetic */ SingleUIComponent<V> f237307m;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(SingleUIComponent<V> singleUIComponent) {
                    super(singleUIComponent);
                    this.f237307m = singleUIComponent;
                }

                @Override // com.tencent.mobileqq.icgame.framework.component.UIComponentProxy
                public void c() {
                    this.f237307m.c();
                }

                /* JADX WARN: Incorrect return type in method signature: ()TV; */
                @Override // com.tencent.mobileqq.icgame.framework.component.UIComponentProxy
                @NotNull
                public View e() {
                    return this.f237307m.n();
                }

                @Override // com.tencent.mobileqq.icgame.framework.component.i
                @Nullable
                public ViewGroup.LayoutParams f() {
                    return this.f237307m.f();
                }

                @Override // com.tencent.mobileqq.icgame.framework.component.i
                public int m() {
                    return this.f237307m.m();
                }

                /* JADX WARN: Incorrect types in method signature: (TV;)V */
                @Override // com.tencent.mobileqq.icgame.framework.component.UIComponentProxy
                public void n(@NotNull View view) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    this.f237307m.r(view);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(this.this$0);
            }
        });
        this.uiComponentProxy = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<V>(this) { // from class: com.tencent.mobileqq.icgame.framework.component.SingleUIComponent$view$2
            final /* synthetic */ SingleUIComponent<V> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Incorrect return type in method signature: ()TV; */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                SingleUIComponent$uiComponentProxy$2.a o16;
                o16 = this.this$0.o();
                return o16.i();
            }
        });
        this.view = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SingleUIComponent$uiComponentProxy$2.a o() {
        return (SingleUIComponent$uiComponentProxy$2.a) this.uiComponentProxy.getValue();
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.i
    public boolean a() {
        return true;
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.i
    /* renamed from: d */
    public final boolean getViewLoadStatus() {
        return o().getViewLoadStatus();
    }

    @Nullable
    public ViewGroup.LayoutParams f() {
        return null;
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.i
    @NotNull
    public final V g() {
        return (V) o().g();
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.i
    /* renamed from: h */
    public final boolean getRequestLoadView() {
        return o().getRequestLoadView();
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.i
    @Nullable
    public final V l() {
        if (getViewLoadStatus()) {
            return p();
        }
        return null;
    }

    @NotNull
    public abstract V n();

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final V p() {
        return (V) this.view.getValue();
    }

    public final void q() {
        o().j();
    }

    public void r(@NotNull V view) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    public void c() {
    }
}
