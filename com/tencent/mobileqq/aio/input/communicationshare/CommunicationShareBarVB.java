package com.tencent.mobileqq.aio.input.communicationshare;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.input.communicationshare.CommunicationShareUIState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.widget.SelectTouchBarView;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 -2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0014\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\rH\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016J\u0006\u0010\u0017\u001a\u00020\u0006R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010 \u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u001cR\u001b\u0010%\u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010\u001a\u001a\u0004\b#\u0010$R\u001b\u0010*\u001a\u00020&8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010\u001a\u001a\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/aio/input/communicationshare/CommunicationShareBarVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/mobileqq/aio/input/communicationshare/a;", "Lcom/tencent/mobileqq/aio/input/communicationshare/CommunicationShareUIState;", "Landroid/view/View$OnClickListener;", "", "", "count", "", "l1", "bindViewAndData", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "e1", "state", "k1", "v", NodeProps.ON_CLICK, "N", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "f1", "Landroid/widget/LinearLayout;", "d", "Lkotlin/Lazy;", "g1", "()Landroid/widget/LinearLayout;", "mCommunicationShareBar", "e", "i1", "mConfirmButtonBg", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "f", "h1", "()Lcom/tencent/biz/qui/quibutton/QUIButton;", "mConfirmButton", "Lcom/tencent/qqnt/aio/widget/SelectTouchBarView;", h.F, "j1", "()Lcom/tencent/qqnt/aio/widget/SelectTouchBarView;", "mTouchBar", "<init>", "()V", "i", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class CommunicationShareBarVB extends com.tencent.aio.base.mvvm.a<a, CommunicationShareUIState> implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mCommunicationShareBar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mConfirmButtonBg;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mConfirmButton;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mTouchBar;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/input/communicationshare/CommunicationShareBarVB$a;", "", "", "CONFIRM_BUTTON_TEXT", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.communicationshare.CommunicationShareBarVB$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54369);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public CommunicationShareBarVB() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.aio.input.communicationshare.CommunicationShareBarVB$mCommunicationShareBar$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CommunicationShareBarVB.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final LinearLayout invoke() {
                    SelectTouchBarView j16;
                    LinearLayout i16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (LinearLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    LinearLayout linearLayout = new LinearLayout(CommunicationShareBarVB.this.getMContext());
                    CommunicationShareBarVB communicationShareBarVB = CommunicationShareBarVB.this;
                    linearLayout.setOrientation(1);
                    linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, ViewUtils.dip2px(150.0f)));
                    j16 = communicationShareBarVB.j1();
                    linearLayout.addView(j16);
                    i16 = communicationShareBarVB.i1();
                    linearLayout.addView(i16);
                    return linearLayout;
                }
            });
            this.mCommunicationShareBar = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.aio.input.communicationshare.CommunicationShareBarVB$mConfirmButtonBg$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CommunicationShareBarVB.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final LinearLayout invoke() {
                    QUIButton h16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (LinearLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    LinearLayout linearLayout = new LinearLayout(CommunicationShareBarVB.this.getMContext());
                    CommunicationShareBarVB communicationShareBarVB = CommunicationShareBarVB.this;
                    linearLayout.setOrientation(1);
                    linearLayout.setBackgroundColor(linearLayout.getResources().getColor(R.color.qui_common_bg_nav_bottom_aio));
                    linearLayout.setGravity(17);
                    linearLayout.setOrientation(1);
                    linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, ViewUtils.dip2px(90.0f)));
                    h16 = communicationShareBarVB.h1();
                    linearLayout.addView(h16);
                    return linearLayout;
                }
            });
            this.mConfirmButtonBg = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(new CommunicationShareBarVB$mConfirmButton$2(this));
            this.mConfirmButton = lazy3;
            lazy4 = LazyKt__LazyJVMKt.lazy(new CommunicationShareBarVB$mTouchBar$2(this));
            this.mTouchBar = lazy4;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final LinearLayout g1() {
        return (LinearLayout) this.mCommunicationShareBar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QUIButton h1() {
        return (QUIButton) this.mConfirmButton.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinearLayout i1() {
        return (LinearLayout) this.mConfirmButtonBg.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SelectTouchBarView j1() {
        return (SelectTouchBarView) this.mTouchBar.getValue();
    }

    private final void l1(int count) {
        if (count > 0) {
            h1().setType(0);
            j1().setVisibility(0);
            TextView textView = (TextView) j1().findViewById(R.id.l9j);
            if (textView != null) {
                textView.setText(getMContext().getResources().getString(R.string.f211635lc, Integer.valueOf(count)));
            }
            j1().g();
            j1().C = count;
            com.tencent.mobileqq.aio.utils.b.f194119a.p("em_bas_aio_multi_selection_selector");
            return;
        }
        h1().setBackgroundDisabled();
        j1().setVisibility(4);
        j1().C = 0;
        com.tencent.mobileqq.aio.utils.b.f194119a.s("em_bas_aio_multi_selection_selector");
    }

    public int N() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        int[] iArr = new int[2];
        j1().getLocationInWindow(iArr);
        View findViewById = j1().findViewById(R.id.l9i);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mTouchBar.findViewById(c\u2026_to_bottom_btn_container)");
        return iArr[1] + (((RelativeLayout) findViewById).getHeight() / 2);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.bindViewAndData();
        if (com.tencent.qqnt.aio.utils.multiForward.a.f352306a.b()) {
            i1().setBackground(ContextCompat.getDrawable(getMContext(), R.drawable.qui_common_bg_nav_bottom_aio_bg));
        } else {
            i1().setBackgroundColor(getMContext().getColor(R.color.emoview_aio_emoji_bkg));
        }
        j1().f();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: e1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<a, CommunicationShareUIState> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.aio.base.mvvm.b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new d(this);
    }

    public final int f1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return i1().getMeasuredHeight();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: k1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull CommunicationShareUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof CommunicationShareUIState.UpdateSelectCount) {
            l1(((CommunicationShareUIState.UpdateSelectCount) state).a());
        } else if (state instanceof CommunicationShareUIState.SetTouchBarVisibility) {
            j1().setVisibility(((CommunicationShareUIState.SetTouchBarVisibility) state).a());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) v3);
        } else {
            Intrinsics.checkNotNullParameter(v3, "v");
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        HashMap hashMap = new HashMap();
        hashMap.put("session_count", Integer.valueOf(j1().C));
        com.tencent.mobileqq.aio.utils.b.q("em_bas_dialog_image_confirm", hashMap);
        return g1();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onDestroy();
        SelectTouchBarView j16 = j1();
        if (j16.C != 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("selection_bars_number", Integer.valueOf(j16.C));
            com.tencent.mobileqq.aio.utils.b.t("em_bas_aio_multi_selection_selector", hashMap);
        }
    }
}
