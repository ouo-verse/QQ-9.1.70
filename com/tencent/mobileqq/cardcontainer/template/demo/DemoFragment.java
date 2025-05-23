package com.tencent.mobileqq.cardcontainer.template.demo;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.cardcontainer.data.ContainerData;
import com.tencent.mobileqq.cardcontainer.framework.CardContainerView;
import com.tencent.mobileqq.cardcontainer.framework.CardsViewModelImpl;
import com.tencent.mobileqq.cardcontainer.j;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/template/demo/DemoFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "getContentLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Landroid/widget/LinearLayout;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/LinearLayout;", "root", "Lcom/tencent/mobileqq/cardcontainer/framework/CardContainerView;", "D", "Lcom/tencent/mobileqq/cardcontainer/framework/CardContainerView;", "cardContainerView", "Lcom/tencent/mobileqq/cardcontainer/g;", "E", "Lcom/tencent/mobileqq/cardcontainer/g;", "model", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class DemoFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private LinearLayout root;

    /* renamed from: D, reason: from kotlin metadata */
    private CardContainerView cardContainerView;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.cardcontainer.g model;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/template/demo/DemoFragment$a;", "", "Landroid/content/Context;", "context", "", "a", "<init>", "()V", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.cardcontainer.template.demo.DemoFragment$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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

        public final void a(@NotNull Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            } else {
                Intrinsics.checkNotNullParameter(context, "context");
                QPublicFragmentActivity.start(context, DemoFragment.class);
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J$\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\"\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/cardcontainer/template/demo/DemoFragment$b", "Lcom/tencent/mobileqq/cardcontainer/j;", "", "elementId", "", "", "params", "", "b", "c", "Lcom/tencent/mobileqq/cardcontainer/data/ContainerData;", "cardData", "", AdMetricTag.Report.TYPE, "customData", "a", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements j {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.cardcontainer.j
        public void a(@NotNull ContainerData cardData, int reportType, @Nullable String customData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, cardData, Integer.valueOf(reportType), customData);
            } else {
                Intrinsics.checkNotNullParameter(cardData, "cardData");
            }
        }

        @Override // com.tencent.mobileqq.cardcontainer.j
        public void b(@NotNull String elementId, @NotNull Map<String, ? extends Object> params) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) elementId, (Object) params);
            } else {
                Intrinsics.checkNotNullParameter(elementId, "elementId");
                Intrinsics.checkNotNullParameter(params, "params");
            }
        }

        @Override // com.tencent.mobileqq.cardcontainer.j
        public void c(@NotNull String elementId, @NotNull Map<String, ? extends Object> params) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) elementId, (Object) params);
            } else {
                Intrinsics.checkNotNullParameter(elementId, "elementId");
                Intrinsics.checkNotNullParameter(params, "params");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41302);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public DemoFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.model = DemoDataRepo.INSTANCE.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.e9m;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.root);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.root)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        this.root = linearLayout;
        CardContainerView cardContainerView = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            linearLayout = null;
        }
        linearLayout.setBackgroundColor(-12303292);
        LinearLayout linearLayout2 = this.root;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            linearLayout2 = null;
        }
        linearLayout2.setPadding(0, 150, 0, 0);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        com.tencent.mobileqq.cardcontainer.g gVar = this.model;
        Intrinsics.checkNotNull(gVar, "null cannot be cast to non-null type com.tencent.mobileqq.cardcontainer.framework.CardsViewModelImpl");
        CardsViewModelImpl cardsViewModelImpl = (CardsViewModelImpl) gVar;
        cardsViewModelImpl.P1(true);
        Unit unit = Unit.INSTANCE;
        CardContainerView cardContainerView2 = new CardContainerView(requireContext, cardsViewModelImpl, this, new b());
        this.cardContainerView = cardContainerView2;
        cardContainerView2.setBackgroundColor(-3355444);
        LinearLayout linearLayout3 = this.root;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            linearLayout3 = null;
        }
        CardContainerView cardContainerView3 = this.cardContainerView;
        if (cardContainerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardContainerView");
        } else {
            cardContainerView = cardContainerView3;
        }
        linearLayout3.addView(cardContainerView, new LinearLayout.LayoutParams(-1, 600));
    }
}
