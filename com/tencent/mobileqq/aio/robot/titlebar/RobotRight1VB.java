package com.tencent.mobileqq.aio.robot.titlebar;

import android.view.View;
import com.tencent.mobileqq.aio.event.ZPlanMsgEvent;
import com.tencent.mobileqq.aio.robot.titlebar.RobotRight1UIState;
import com.tencent.mobileqq.aio.robot.titlebar.i;
import com.tencent.mobileqq.aio.title.af;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.aio.widget.RedDotImageView;
import com.tencent.mobileqq.utils.x;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.QQToastUtil;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00130\u001f\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0014\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0003H\u0016R\u001b\u0010\u001e\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/aio/robot/titlebar/RobotRight1VB;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/mobileqq/aio/robot/titlebar/i;", "Lcom/tencent/mobileqq/aio/robot/titlebar/RobotRight1UIState;", "", "show", "", "k1", "Lcom/tencent/mobileqq/aio/title/af;", "data", "l1", "Lcom/tencent/mobileqq/aio/event/ZPlanMsgEvent$a;", "h1", "", "text", "i1", "j1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Lcom/tencent/mobileqq/aio/widget/RedDotImageView;", "g1", "Lcom/tencent/aio/base/mvvm/b;", "d1", "bindViewAndData", "state", "f1", "d", "Lkotlin/Lazy;", "e1", "()Lcom/tencent/mobileqq/aio/widget/RedDotImageView;", "right1Iv", "Lkotlin/Function0;", "get", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class RobotRight1VB extends com.tencent.aio.base.mvvm.a<i, RobotRight1UIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy right1Iv;

    public RobotRight1VB(@NotNull final Function0<? extends RedDotImageView> get) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(get, "get");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RedDotImageView>() { // from class: com.tencent.mobileqq.aio.robot.titlebar.RobotRight1VB$right1Iv$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RedDotImageView invoke() {
                return get.invoke();
            }
        });
        this.right1Iv = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c1(RobotRight1VB this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(i.a.f193651d);
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

    private final void i1(String text) {
        QQToastUtil.showQQToastInUiThread(1, text);
    }

    private final void j1(String text) {
        QQToastUtil.showQQToastInUiThread(2, text);
    }

    private final void k1(boolean show) {
        e1().setShowRedDot(show);
        e1().setVisibility(0);
    }

    private final void l1(af data) {
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
        super.bindViewAndData();
        e1().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.robot.titlebar.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RobotRight1VB.c1(RobotRight1VB.this, view);
            }
        });
        AIOUtil.f194084a.e(e1(), x.a(7.0f), x.a(7.0f), x.a(4.0f), x.a(8.0f));
        sendIntent(i.b.f193652d);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<i, RobotRight1UIState> getViewModel() {
        return new RobotRight1VM();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: f1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull RobotRight1UIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof RobotRight1UIState.UpdateDataUIState) {
            l1(((RobotRight1UIState.UpdateDataUIState) state).getData());
            return;
        }
        if (state instanceof RobotRight1UIState.UpdateRedPointUIState) {
            k1(((RobotRight1UIState.UpdateRedPointUIState) state).getData());
            return;
        }
        if (state instanceof RobotRight1UIState.ShowBubbleTipUIState) {
            h1(((RobotRight1UIState.ShowBubbleTipUIState) state).getData());
        } else if (state instanceof RobotRight1UIState.ShowErrorToast) {
            i1(((RobotRight1UIState.ShowErrorToast) state).getText());
        } else if (state instanceof RobotRight1UIState.ShowSuccessToast) {
            j1(((RobotRight1UIState.ShowSuccessToast) state).getText());
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public RedDotImageView onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        return e1();
    }
}
