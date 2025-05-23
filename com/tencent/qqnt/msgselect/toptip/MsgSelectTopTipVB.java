package com.tencent.qqnt.msgselect.toptip;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.x;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.widget.MutliSeletedBottomLine;
import com.tencent.qqnt.msgselect.toptip.MsgSelectTopTipUIState;
import com.tencent.qqnt.msgselect.toptip.a;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0003H\u0016J\u001c\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010\u0014\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0016R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R#\u0010 \u001a\n \u001c*\u0004\u0018\u00010\u001b0\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/qqnt/msgselect/toptip/MsgSelectTopTipVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/qqnt/msgselect/toptip/a;", "Lcom/tencent/qqnt/msgselect/toptip/MsgSelectTopTipUIState;", "Landroid/view/View$OnClickListener;", "", "c1", "msgSize", "", "g1", "state", "f1", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "createVM", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "v", NodeProps.ON_CLICK, "Landroid/widget/RelativeLayout;", "d", "Lkotlin/Lazy;", "d1", "()Landroid/widget/RelativeLayout;", "selectBelowContent", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "e", "e1", "()Landroid/widget/TextView;", "selectBelowText", "<init>", "()V", "f", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class MsgSelectTopTipVB extends com.tencent.aio.base.mvvm.a<a, MsgSelectTopTipUIState> implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final String f359762h;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy selectBelowContent;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy selectBelowText;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/msgselect/toptip/MsgSelectTopTipVB$a;", "", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.msgselect.toptip.MsgSelectTopTipVB$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65821);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
            f359762h = "MsgSelectTopTipVB";
        }
    }

    public MsgSelectTopTipVB() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<RelativeLayout>() { // from class: com.tencent.qqnt.msgselect.toptip.MsgSelectTopTipVB$selectBelowContent$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MsgSelectTopTipVB.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final RelativeLayout invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (RelativeLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    View inflate = LayoutInflater.from(MsgSelectTopTipVB.this.getMContext()).inflate(R.layout.hzq, (ViewGroup) null);
                    Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.RelativeLayout");
                    RelativeLayout relativeLayout = (RelativeLayout) inflate;
                    MsgSelectTopTipVB msgSelectTopTipVB = MsgSelectTopTipVB.this;
                    int c16 = x.c(msgSelectTopTipVB.getMContext(), 59.0f);
                    int c17 = x.c(msgSelectTopTipVB.getMContext(), 42.0f);
                    MutliSeletedBottomLine mutliSeletedBottomLine = new MutliSeletedBottomLine(msgSelectTopTipVB.getMContext(), c16, c17, false);
                    MutliSeletedBottomLine mutliSeletedBottomLine2 = new MutliSeletedBottomLine(msgSelectTopTipVB.getMContext(), c16, c17, true);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(c16, -2);
                    layoutParams.addRule(9);
                    relativeLayout.addView(mutliSeletedBottomLine, layoutParams);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(c16, -2);
                    layoutParams2.addRule(11);
                    relativeLayout.addView(mutliSeletedBottomLine2, layoutParams2);
                    ((LinearLayout) relativeLayout.findViewById(R.id.svx)).setOnClickListener(MsgSelectTopTipVB.this);
                    return relativeLayout;
                }
            });
            this.selectBelowContent = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.qqnt.msgselect.toptip.MsgSelectTopTipVB$selectBelowText$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MsgSelectTopTipVB.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final TextView invoke() {
                    RelativeLayout d16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (TextView) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    d16 = MsgSelectTopTipVB.this.d1();
                    return (TextView) d16.findViewById(R.id.f82134g2);
                }
            });
            this.selectBelowText = lazy2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final int c1() {
        int[] iArr = new int[2];
        d1().getLocationInWindow(iArr);
        View findViewById = d1().findViewById(R.id.f82044ft);
        Intrinsics.checkNotNullExpressionValue(findViewById, "selectBelowContent.findViewById(R.id.select_below)");
        return iArr[1] + (((RelativeLayout) findViewById).getHeight() / 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RelativeLayout d1() {
        return (RelativeLayout) this.selectBelowContent.getValue();
    }

    private final TextView e1() {
        return (TextView) this.selectBelowText.getValue();
    }

    private final void g1(int msgSize) {
        if (msgSize > 0) {
            e1().setText(getMContext().getString(R.string.f234927a_, Integer.valueOf(msgSize)));
        } else {
            e1().setText(R.string.f234897a7);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    public BaseVM<a, MsgSelectTopTipUIState, com.tencent.aio.api.runtime.a> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BaseVM) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new b();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: f1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull MsgSelectTopTipUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof MsgSelectTopTipUIState.UpdateSeletedMsg) {
            g1(((MsgSelectTopTipUIState.UpdateSeletedMsg) state).a());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) v3);
        } else {
            if (QLog.isColorLevel()) {
                QLog.i(f359762h, 2, "select to bottom");
            }
            sendIntent(new a.C9658a(c1()));
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        return d1();
    }
}
