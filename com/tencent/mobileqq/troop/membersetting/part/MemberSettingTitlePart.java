package com.tencent.mobileqq.troop.membersetting.part;

import android.app.Activity;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.utils.eu;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/troop/membersetting/part/MemberSettingTitlePart;", "Lcom/tencent/mobileqq/troop/membersetting/part/t;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "e", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "navbar", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class MemberSettingTitlePart extends t {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QUISecNavBar navbar;

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.f18202c);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.title_bar)");
        QUISecNavBar qUISecNavBar = (QUISecNavBar) findViewById;
        this.navbar = qUISecNavBar;
        if (qUISecNavBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navbar");
            qUISecNavBar = null;
        }
        qUISecNavBar.setAutoAdaptTransparent(true);
        qUISecNavBar.setBaseViewDescription(BaseAction.ACTION_CENTER_TEXT, " " + qUISecNavBar.getContext().getString(R.string.f131901z));
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        qUISecNavBar.R(activity);
        qUISecNavBar.setOnBaseTitleBarClickListener(new Function2<View, BaseAction, Unit>() { // from class: com.tencent.mobileqq.troop.membersetting.part.MemberSettingTitlePart$onInitView$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, BaseAction baseAction) {
                invoke2(view, baseAction);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view, BaseAction baseAction) {
                if (baseAction == BaseAction.ACTION_LEFT_BUTTON) {
                    ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).popBack(MemberSettingTitlePart.this.getActivity());
                }
            }
        });
        eu.g("Grp_set_new", "grpData_admin", "share_exp", 0, 0, C9().Q1().getTroopUin());
    }
}
