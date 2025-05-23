package com.tencent.mobileqq.troop.troopsetting.part;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasZplanGroupApi;
import com.tencent.mobileqq.vas.data.SmallHomeGroupSettingData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "smallHomeGroupSettingData", "Lcom/tencent/mobileqq/vas/data/SmallHomeGroupSettingData;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class TroopSettingSmallHomePart$updateSmallHomeState$1 extends Lambda implements Function1<SmallHomeGroupSettingData, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ TroopSettingSmallHomePart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopSettingSmallHomePart$updateSmallHomeState$1(TroopSettingSmallHomePart troopSettingSmallHomePart) {
        super(1);
        this.this$0 = troopSettingSmallHomePart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopSettingSmallHomePart);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final TroopSettingSmallHomePart this$0, SmallHomeGroupSettingData smallHomeGroupSettingData, View view) {
        com.tencent.mobileqq.widget.listitem.x xVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IVasZplanGroupApi iVasZplanGroupApi = (IVasZplanGroupApi) QRoute.api(IVasZplanGroupApi.class);
        Activity activity = this$0.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        iVasZplanGroupApi.openSmallHomeGroupSettingPage(activity, smallHomeGroupSettingData);
        xVar = this$0.troopSmallConfig;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopSmallConfig");
            xVar = null;
        }
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.cg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TroopSettingSmallHomePart$updateSmallHomeState$1.d(TroopSettingSmallHomePart.this, view2);
            }
        });
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(TroopSettingSmallHomePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SmallHomeGroupSettingData smallHomeGroupSettingData = new SmallHomeGroupSettingData(0L, 0, 0, 0, 0, 31, null);
        IVasZplanGroupApi iVasZplanGroupApi = (IVasZplanGroupApi) QRoute.api(IVasZplanGroupApi.class);
        Activity activity = this$0.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        iVasZplanGroupApi.openSmallHomeGroupSettingPage(activity, smallHomeGroupSettingData);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SmallHomeGroupSettingData smallHomeGroupSettingData) {
        invoke2(smallHomeGroupSettingData);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable final SmallHomeGroupSettingData smallHomeGroupSettingData) {
        com.tencent.mobileqq.widget.listitem.x xVar;
        com.tencent.mobileqq.widget.listitem.x xVar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) smallHomeGroupSettingData);
            return;
        }
        boolean z16 = false;
        if (smallHomeGroupSettingData != null && smallHomeGroupSettingData.needSettingShow()) {
            z16 = true;
        }
        if (z16) {
            xVar = this.this$0.troopSmallConfig;
            com.tencent.mobileqq.widget.listitem.x xVar3 = null;
            if (xVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopSmallConfig");
                xVar = null;
            }
            final TroopSettingSmallHomePart troopSettingSmallHomePart = this.this$0;
            xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.cf
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TroopSettingSmallHomePart$updateSmallHomeState$1.c(TroopSettingSmallHomePart.this, smallHomeGroupSettingData, view);
                }
            });
            TroopSettingSmallHomePart troopSettingSmallHomePart2 = this.this$0;
            xVar2 = troopSettingSmallHomePart2.troopSmallConfig;
            if (xVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopSmallConfig");
            } else {
                xVar3 = xVar2;
            }
            troopSettingSmallHomePart2.E9(xVar3, true);
        }
    }
}
