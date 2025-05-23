package com.tencent.mobileqq.troop.troopsquare.home.part;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.utils.h;
import com.tencent.mobileqq.utils.TriggerRunnerKt;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/home/part/k;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "d", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "searchLayout", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class k extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QUISearchBar searchLayout;

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z9(k this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).openTroopSearchHistoryPageFromTroopSquare(this$0.getActivity());
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        QUISearchBar qUISearchBar;
        QUISearchBar qUISearchBar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.f81044d4);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.search_layout)");
        QUISearchBar qUISearchBar3 = (QUISearchBar) findViewById;
        this.searchLayout = qUISearchBar3;
        com.tencent.mobileqq.troop.troopsquare.common.c cVar = com.tencent.mobileqq.troop.troopsquare.common.c.f301578a;
        if (qUISearchBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchLayout");
            qUISearchBar = null;
        } else {
            qUISearchBar = qUISearchBar3;
        }
        h.a.m(cVar, qUISearchBar, "em_group_search_box", ExposurePolicy.REPORT_NONE, ClickPolicy.REPORT_ALL, null, null, 48, null);
        QUISearchBar qUISearchBar4 = this.searchLayout;
        if (qUISearchBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchLayout");
            qUISearchBar2 = null;
        } else {
            qUISearchBar2 = qUISearchBar4;
        }
        TriggerRunnerKt.c(qUISearchBar2, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsquare.home.part.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k.z9(k.this, view);
            }
        }, 1, null);
    }
}
