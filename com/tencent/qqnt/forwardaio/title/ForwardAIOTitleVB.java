package com.tencent.qqnt.forwardaio.title;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.forwardaio.title.ForwardAIOTitleUIState;
import com.tencent.qqnt.forwardaio.title.d;
import com.tencent.widget.FadeIconImageView;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import w71.aa;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\u0016\u0010\u0017\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00160\u0015H\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001b\u0010!\u001a\u00020\u001c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/qqnt/forwardaio/title/ForwardAIOTitleVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/qqnt/forwardaio/title/d;", "Lcom/tencent/qqnt/forwardaio/title/ForwardAIOTitleUIState;", "", "i1", "l1", "Landroid/view/View;", "view", "", "scale", "d1", "f1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Lcom/tencent/qqnt/forwardaio/title/g;", "e1", "bindViewAndData", "state", "h1", "", "Ljava/lang/Class;", "getObserverStates", "", "d", "Z", "inMember", "Lw71/aa;", "e", "Lkotlin/Lazy;", "g1", "()Lw71/aa;", "mBinding", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class ForwardAIOTitleVB extends com.tencent.aio.base.mvvm.a<d, ForwardAIOTitleUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean inMember;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mBinding;

    public ForwardAIOTitleVB() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<aa>() { // from class: com.tencent.qqnt.forwardaio.title.ForwardAIOTitleVB$mBinding$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ForwardAIOTitleVB.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final aa invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? aa.g(LayoutInflater.from(ForwardAIOTitleVB.this.getMContext())) : (aa) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.mBinding = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void d1(View view, float scale) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        float f16 = 18 / scale;
        layoutParams.width = ViewUtils.dip2px(f16);
        layoutParams.height = ViewUtils.dip2px(f16);
    }

    private final void f1() {
        if (!QQTheme.isNowThemeIsNight()) {
            return;
        }
        float dip2px = ViewUtils.dip2px(8.0f);
        LinearLayout linearLayout = g1().f444715e;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#ff262626"));
        gradientDrawable.setCornerRadii(new float[]{dip2px, dip2px, dip2px, dip2px, 0.0f, 0.0f, 0.0f, 0.0f});
        linearLayout.setBackgroundDrawable(gradientDrawable);
        g1().f444713c.setBackgroundColor(Color.parseColor("#ff1a1a1a"));
        g1().f444716f.setTextColor(Color.parseColor("#ffffffff"));
        FadeIconImageView fadeIconImageView = g1().f444712b;
        fadeIconImageView.getLayoutParams().height = ViewUtils.dip2px(28.0f);
        fadeIconImageView.getLayoutParams().width = ViewUtils.dip2px(15.0f);
        fadeIconImageView.setImageDrawable(fadeIconImageView.getContext().getResources().getDrawable(R.drawable.jnq));
    }

    private final aa g1() {
        return (aa) this.mBinding.getValue();
    }

    private final void i1() {
        this.inMember = false;
        g1().f444714d.setVisibility(0);
        g1().getRoot().setBackgroundResource(R.drawable.skin_mni_aio_bg_2);
        sendIntent(d.b.f356768d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(ForwardAIOTitleVB this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.inMember) {
            this$0.i1();
        } else {
            this$0.sendIntent(d.a.f356767d);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(ForwardAIOTitleVB this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.l1();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void l1() {
        this.inMember = true;
        g1().f444714d.setVisibility(4);
        g1().getRoot().setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg_corner_6);
        sendIntent(d.C9624d.f356770d);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            sendIntent(d.c.f356769d);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: e1, reason: merged with bridge method [inline-methods] */
    public g createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (g) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new g();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends ForwardAIOTitleUIState>> getObserverStates() {
        List<Class<? extends ForwardAIOTitleUIState>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{ForwardAIOTitleUIState.UpdateTitle.class, ForwardAIOTitleUIState.UpdateMemBtn.class});
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 6, (Object) this);
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: h1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull ForwardAIOTitleUIState state) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof ForwardAIOTitleUIState.UpdateTitle) {
            g1().f444716f.setText(((ForwardAIOTitleUIState.UpdateTitle) state).a());
            return;
        }
        if (state instanceof ForwardAIOTitleUIState.UpdateMemBtn) {
            FadeIconImageView fadeIconImageView = g1().f444714d;
            if (((ForwardAIOTitleUIState.UpdateMemBtn) state).a()) {
                i3 = 0;
            } else {
                i3 = 4;
            }
            fadeIconImageView.setVisibility(i3);
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        LinearLayout root = g1().getRoot();
        root.setLayoutParams(new ViewGroup.LayoutParams(-1, root.getContext().getResources().getDimensionPixelSize(R.dimen.bzh)));
        FadeIconImageView fadeIconImageView = g1().f444712b;
        Intrinsics.checkNotNullExpressionValue(fadeIconImageView, "mBinding.backArrow");
        d1(fadeIconImageView, 0.78f);
        FadeIconImageView fadeIconImageView2 = g1().f444714d;
        Intrinsics.checkNotNullExpressionValue(fadeIconImageView2, "mBinding.memberBtn");
        d1(fadeIconImageView2, 0.78f);
        g1().f444716f.setTextSize(16 / 0.78f);
        g1().f444712b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.forwardaio.title.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForwardAIOTitleVB.j1(ForwardAIOTitleVB.this, view);
            }
        });
        g1().f444712b.setContentDescription(getMContext().getResources().getString(R.string.f170549u3));
        g1().f444714d.setVisibility(4);
        g1().f444714d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.forwardaio.title.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForwardAIOTitleVB.k1(ForwardAIOTitleVB.this, view);
            }
        });
        f1();
        LinearLayout root2 = g1().getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "mBinding.root");
        return root2;
    }
}
