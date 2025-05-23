package com.tencent.mobileqq.matchfriend.aio.background;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.ui.IVasPagViewApi;
import com.tencent.mobileqq.vas.ui.VasPagImageView;
import com.tencent.mobileqq.vas.ui.VasPagView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.libpag.PAGComposition;
import org.libpag.PAGImageView;
import org.libpag.PAGView;
import tl.h;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0003\u0015\u0012\u0011B'\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010#\u001a\u00020\"\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u000e\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u0002J\u0006\u0010\t\u001a\u00020\u0005J \u0010\r\u001a\u00020\u00052\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\nJ\u0016\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u0014\u0010\u0017\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001c\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/background/PAGViewDelegate;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/matchfriend/aio/background/d;", "", h.F, "", "d", "Lcom/tencent/mobileqq/vas/ui/IVasPagViewApi;", "e", "f", "Lkotlin/Function2;", "Landroid/view/View;", "block", "g", "view", "Lcom/tencent/mobileqq/matchfriend/aio/background/PAGViewDelegate$b;", "listener", "c", "b", "Lorg/libpag/PAGComposition;", "composition", "a", "Z", "usePAGImageView", "Lcom/tencent/mobileqq/vas/ui/VasPagView;", "Lcom/tencent/mobileqq/vas/ui/VasPagView;", "pagView", "Lcom/tencent/mobileqq/vas/ui/VasPagImageView;", "Lcom/tencent/mobileqq/vas/ui/VasPagImageView;", "pagImageView", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class PAGViewDelegate extends FrameLayout implements d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean usePAGImageView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private VasPagView pagView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private VasPagImageView pagImageView;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/background/PAGViewDelegate$a;", "Lorg/libpag/PAGImageView$PAGImageViewListener;", "Lorg/libpag/PAGImageView;", "view", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "onAnimationUpdate", "Lcom/tencent/mobileqq/matchfriend/aio/background/PAGViewDelegate$b;", "d", "Lcom/tencent/mobileqq/matchfriend/aio/background/PAGViewDelegate$b;", "listener", "<init>", "(Lcom/tencent/mobileqq/matchfriend/aio/background/PAGViewDelegate$b;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    private static final class a implements PAGImageView.PAGImageViewListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final b listener;

        public a(b listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.listener = listener;
        }

        @Override // org.libpag.PAGImageView.PAGImageViewListener
        public void onAnimationCancel(PAGImageView view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.listener.onAnimationCancel(view);
        }

        @Override // org.libpag.PAGImageView.PAGImageViewListener
        public void onAnimationEnd(PAGImageView view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.listener.onAnimationEnd(view);
        }

        @Override // org.libpag.PAGImageView.PAGImageViewListener
        public void onAnimationRepeat(PAGImageView view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.listener.a(view);
        }

        @Override // org.libpag.PAGImageView.PAGImageViewListener
        public void onAnimationStart(PAGImageView view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.listener.onAnimationStart(view);
        }

        @Override // org.libpag.PAGImageView.PAGImageViewListener
        public void onAnimationUpdate(PAGImageView view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.listener.onAnimationUpdate(view);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/background/PAGViewDelegate$b;", "", "Landroid/view/View;", "view", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "a", "onAnimationUpdate", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public interface b {
        void a(View view);

        void onAnimationCancel(View view);

        void onAnimationEnd(View view);

        void onAnimationStart(View view);

        void onAnimationUpdate(View view);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/background/PAGViewDelegate$c;", "Lorg/libpag/PAGView$PAGViewListener;", "Lorg/libpag/PAGView;", "view", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "onAnimationUpdate", "Lcom/tencent/mobileqq/matchfriend/aio/background/PAGViewDelegate$b;", "d", "Lcom/tencent/mobileqq/matchfriend/aio/background/PAGViewDelegate$b;", "listener", "<init>", "(Lcom/tencent/mobileqq/matchfriend/aio/background/PAGViewDelegate$b;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    private static final class c implements PAGView.PAGViewListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final b listener;

        public c(b listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.listener = listener;
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationCancel(PAGView view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.listener.onAnimationCancel(view);
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationEnd(PAGView view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.listener.onAnimationEnd(view);
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationRepeat(PAGView view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.listener.a(view);
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationStart(PAGView view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.listener.onAnimationStart(view);
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationUpdate(PAGView view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.listener.onAnimationUpdate(view);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PAGViewDelegate(Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    private final void d() {
        if (this.usePAGImageView) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            VasPagImageView vasPagImageView = new VasPagImageView(context);
            this.pagImageView = vasPagImageView;
            addView(vasPagImageView, new FrameLayout.LayoutParams(-1, -1));
            return;
        }
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        VasPagView vasPagView = new VasPagView(context2);
        this.pagView = vasPagView;
        addView(vasPagView, new FrameLayout.LayoutParams(-1, -1));
    }

    private final IVasPagViewApi<?> e() {
        if (this.usePAGImageView) {
            VasPagImageView vasPagImageView = this.pagImageView;
            if (vasPagImageView != null) {
                return vasPagImageView.api();
            }
            return null;
        }
        VasPagView vasPagView = this.pagView;
        if (vasPagView != null) {
            return vasPagView.api();
        }
        return null;
    }

    private final boolean h() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqstranger_9090_129192509_use_pag_imageview", true);
    }

    @Override // com.tencent.mobileqq.matchfriend.aio.background.d
    public void a(View view, PAGComposition composition) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(composition, "composition");
        if (view instanceof PAGView) {
            PAGView pAGView = (PAGView) view;
            pAGView.setComposition(composition);
            pAGView.play();
        } else if (view instanceof PAGImageView) {
            PAGImageView pAGImageView = (PAGImageView) view;
            pAGImageView.setComposition(composition);
            pAGImageView.play();
        }
    }

    @Override // com.tencent.mobileqq.matchfriend.aio.background.d
    public void b(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view instanceof PAGView) {
            ((PAGView) view).stop();
        } else if (view instanceof PAGImageView) {
            ((PAGImageView) view).pause();
        }
    }

    public final void c(View view, b listener) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (view instanceof PAGView) {
            ((PAGView) view).addListener(new c(listener));
        } else if (view instanceof PAGImageView) {
            ((PAGImageView) view).addListener(new a(listener));
        }
    }

    public final void f() {
        IVasPagViewApi<?> e16 = e();
        if (e16 == null || e16.isBuild()) {
            return;
        }
        e16.build();
    }

    public final void g(final Function2<? super d, ? super View, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        IVasPagViewApi<?> e16 = e();
        if (e16 == null) {
            return;
        }
        e16.postAction(new Function1<View, Unit>() { // from class: com.tencent.mobileqq.matchfriend.aio.background.PAGViewDelegate$postAction$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                block.invoke(this, it);
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PAGViewDelegate(Context ctx, AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ PAGViewDelegate(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PAGViewDelegate(Context ctx, AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.usePAGImageView = h();
        d();
    }
}
