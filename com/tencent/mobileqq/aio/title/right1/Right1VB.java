package com.tencent.mobileqq.aio.title.right1;

import android.view.View;
import com.tencent.mobileqq.aio.event.ZPlanMsgEvent;
import com.tencent.mobileqq.aio.title.af;
import com.tencent.mobileqq.aio.title.right1.Right1UIState;
import com.tencent.mobileqq.aio.title.right1.a;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.aio.widget.RedDotImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.x;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0014\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0003H\u0016R\u001b\u0010\u001a\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/aio/title/right1/Right1VB;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/mobileqq/aio/title/right1/a;", "Lcom/tencent/mobileqq/aio/title/right1/Right1UIState;", "", "show", "", "i1", "Lcom/tencent/mobileqq/aio/title/af;", "data", "j1", "Lcom/tencent/mobileqq/aio/event/ZPlanMsgEvent$a;", "h1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Lcom/tencent/mobileqq/aio/widget/RedDotImageView;", "g1", "Lcom/tencent/aio/base/mvvm/b;", "d1", "bindViewAndData", "state", "f1", "d", "Lkotlin/Lazy;", "e1", "()Lcom/tencent/mobileqq/aio/widget/RedDotImageView;", "right1Iv", "Lkotlin/Function0;", "get", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class Right1VB extends com.tencent.aio.base.mvvm.a<a, Right1UIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy right1Iv;

    public Right1VB(@NotNull final Function0<? extends RedDotImageView> get) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(get, "get");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<RedDotImageView>(get) { // from class: com.tencent.mobileqq.aio.title.right1.Right1VB$right1Iv$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ Function0<RedDotImageView> $get;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                    this.$get = get;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) get);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final RedDotImageView invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? this.$get.invoke() : (RedDotImageView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.right1Iv = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) get);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c1(Right1VB this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(a.C7364a.f194012d);
        com.tencent.mobileqq.aio.utils.b.f194119a.k("em_setting_banner_aio_pg");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final RedDotImageView e1() {
        return (RedDotImageView) this.right1Iv.getValue();
    }

    private final void h1(ZPlanMsgEvent.a data) {
        com.tencent.mobileqq.widget.tip.a r16 = com.tencent.mobileqq.widget.tip.a.r(getMContext());
        r16.S(e1());
        r16.k0(1);
        r16.R(0);
        r16.o0(data.c());
        r16.p0(data.d());
        r16.q0(data.e());
        r16.b0(data.b());
        r16.f0(false);
        r16.W(data.a());
        r16.j0(10.0f, 8.0f, 10.0f, 8.0f);
        r16.s0();
    }

    private final void i1(boolean show) {
        e1().setShowRedDot(show);
        e1().setVisibility(0);
    }

    private final void j1(af data) {
        int i3;
        e1().setShowRedDot(data.d());
        RedDotImageView e16 = e1();
        if (data.f()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        e16.setVisibility(i3);
        e1().setContentDescription(data.c());
        e1().setImageDrawable(data.e());
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.bindViewAndData();
        e1().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.title.right1.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Right1VB.c1(Right1VB.this, view);
            }
        });
        AIOUtil.f194084a.e(e1(), x.a(7.0f), x.a(7.0f), x.a(4.0f), x.a(8.0f));
        sendIntent(a.b.f194013d);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<a, Right1UIState> getViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.aio.base.mvvm.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new c();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: f1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull Right1UIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof Right1UIState.UpdateDataUIState) {
            j1(((Right1UIState.UpdateDataUIState) state).a());
        } else if (state instanceof Right1UIState.UpdateRedPointUIState) {
            i1(((Right1UIState.UpdateRedPointUIState) state).a());
        } else if (state instanceof Right1UIState.ShowBubbleTipUIState) {
            h1(((Right1UIState.ShowBubbleTipUIState) state).a());
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public RedDotImageView onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RedDotImageView) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        return e1();
    }
}
