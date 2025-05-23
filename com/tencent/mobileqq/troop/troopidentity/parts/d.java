package com.tencent.mobileqq.troop.troopidentity.parts;

import android.view.View;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/parts/d;", "Lcom/tencent/mobileqq/troop/troopidentity/parts/TroopIdentityIconBasePart;", "Landroid/view/View$OnClickListener;", "G9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class d extends TroopIdentityIconBasePart {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final View.OnClickListener G9() {
        return new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopidentity.parts.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.H9(d.this, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.A9().l2()) {
            this$0.A9().n2(true);
        }
        QRoute.createNavigator(this$0.getActivity(), RouterConstants.UI_ROUTE_BROWSER).withString("url", ((ITroopLinkApi) QRoute.api(ITroopLinkApi.class)).getTroopHonorUrl(this$0.A9().g2(), 1) + "&isNewPage=1").request();
        com.tencent.mobileqq.troop.troopidentity.util.a.c(this$0.z9(), "em_group_view_all_member", null, 2, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        if (rootView != null && (textView = (TextView) rootView.findViewById(R.id.slt)) != null) {
            textView.setOnClickListener(G9());
        }
        com.tencent.mobileqq.troop.troopidentity.util.a.e(z9(), "em_group_view_all_member", null, 2, null);
    }
}
