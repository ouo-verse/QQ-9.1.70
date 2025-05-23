package com.tencent.mobileqq.troop.troopcard.reborn.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopShareApi;
import com.tencent.mobileqq.troop.troopcard.api.ITroopInfoActivityApi;
import com.tencent.mobileqq.troop.troopcard.reborn.uimodel.a;
import com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel;
import com.tencent.mobileqq.troop.troopsetting.share.troopsetting.TroopSettingShareManager;
import com.tencent.mobileqq.troop.troopshare.tempapi.ITroopShareUtility;
import com.tencent.mobileqq.utils.TriggerRunnerKt;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/a;", "kotlin.jvm.PlatformType", "btnType", "", "invoke", "(Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/a;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes19.dex */
final class TroopInfoCardBottomPart$onInitView$1 extends Lambda implements Function1<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.a, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ TroopInfoCardBottomPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopInfoCardBottomPart$onInitView$1(TroopInfoCardBottomPart troopInfoCardBottomPart) {
        super(1);
        this.this$0 = troopInfoCardBottomPart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopInfoCardBottomPart);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(TroopInfoCardBottomPart this$0, com.tencent.mobileqq.troop.troopcard.reborn.uimodel.a btnType, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(btnType, "btnType");
        this$0.ba((a.AbstractC8794a) btnType);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(TroopInfoCardBottomPart this$0, com.tencent.mobileqq.troop.troopcard.reborn.uimodel.a btnType, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(btnType, "btnType");
        this$0.ba((a.AbstractC8794a) btnType);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(TroopInfoCardBottomPart this$0, View view) {
        TroopBasicInfoViewModel troopBasicInfoViewModel;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        troopBasicInfoViewModel = this$0.basicInfoViewModel;
        if (troopBasicInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
            troopBasicInfoViewModel = null;
        }
        com.tencent.mobileqq.troop.data.v D2 = troopBasicInfoViewModel.D2();
        if (D2 != null) {
            this$0.ja(D2);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(TroopInfoCardBottomPart this$0, View view) {
        TroopBasicInfoViewModel troopBasicInfoViewModel;
        QBaseActivity qBaseActivity;
        ITroopShareUtility iTroopShareUtility;
        TroopSettingShareManager ia5;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        troopBasicInfoViewModel = this$0.basicInfoViewModel;
        ITroopShareUtility iTroopShareUtility2 = null;
        if (troopBasicInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
            troopBasicInfoViewModel = null;
        }
        com.tencent.mobileqq.troop.data.v D2 = troopBasicInfoViewModel.D2();
        if (D2 != null) {
            Activity activity = this$0.getActivity();
            if (activity instanceof QBaseActivity) {
                qBaseActivity = (QBaseActivity) activity;
            } else {
                qBaseActivity = null;
            }
            if (qBaseActivity != null) {
                if (((ITroopShareApi) QRoute.api(ITroopShareApi.class)).useNewSharePanel("group_idcard")) {
                    ia5 = this$0.ia();
                    ia5.F(new com.tencent.mobileqq.troop.troopsetting.share.b(qBaseActivity, com.tencent.mobileqq.troop.data.w.d(D2)), "group_idcard");
                } else {
                    iTroopShareUtility = this$0.troopShareUtil;
                    if (iTroopShareUtility == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("troopShareUtil");
                    } else {
                        iTroopShareUtility2 = iTroopShareUtility;
                    }
                    com.tencent.mobileqq.troop.troopcard.reborn.ktx.a.b(iTroopShareUtility2, qBaseActivity, this$0.ha(), D2);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(TroopInfoCardBottomPart this$0, View view) {
        TroopBasicInfoViewModel troopBasicInfoViewModel;
        TroopBasicInfoViewModel troopBasicInfoViewModel2;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        troopBasicInfoViewModel = this$0.basicInfoViewModel;
        TroopBasicInfoViewModel troopBasicInfoViewModel3 = null;
        if (troopBasicInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
            troopBasicInfoViewModel = null;
        }
        com.tencent.mobileqq.troop.data.v D2 = troopBasicInfoViewModel.D2();
        if (D2 != null) {
            troopBasicInfoViewModel2 = this$0.basicInfoViewModel;
            if (troopBasicInfoViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
            } else {
                troopBasicInfoViewModel3 = troopBasicInfoViewModel2;
            }
            if (troopBasicInfoViewModel3.P2()) {
                com.tencent.mobileqq.troop.utils.ab.c(this$0.getActivity());
            } else {
                Bundle c16 = com.tencent.mobileqq.troop.utils.aq.c(D2.i().getTroopUin(), 3, D2.i().troopLat, D2.i().troopLon, 0, D2.i().strLocation);
                Intrinsics.checkNotNullExpressionValue(c16, "getTroopProfileExtra(\n  \u2026er.troopInfo.strLocation)");
                c16.putInt(AppConstants.Key.TROOP_INFO_TROOP_TYPE_EX, D2.i().troopTypeExt);
                c16.putInt("PARAM_EXIT_ANIMATION", 2);
                ((ITroopInfoActivityApi) QRoute.api(ITroopInfoActivityApi.class)).openTroopProfileForResult(this$0.getActivity(), c16, 20);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.troopcard.reborn.uimodel.a aVar) {
        invoke2(aVar);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x017c, code lost:
    
        if (r11.isOwnerOrAdmin() == true) goto L80;
     */
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void invoke2(final com.tencent.mobileqq.troop.troopcard.reborn.uimodel.a aVar) {
        QUIButton qUIButton;
        QUIButton qUIButton2;
        QUIButton qUIButton3;
        TroopBasicInfoViewModel troopBasicInfoViewModel;
        boolean z16;
        QUIButton qUIButton4;
        QUIButton qUIButton5;
        QUIButton qUIButton6;
        QUIButton qUIButton7;
        QUIButton qUIButton8;
        QUIButton qUIButton9;
        QUIButton qUIButton10;
        QUIButton qUIButton11;
        QUIButton qUIButton12;
        QUIButton qUIButton13;
        QUIButton qUIButton14;
        QUIButton qUIButton15;
        QUIButton qUIButton16;
        QUIButton qUIButton17;
        QUIButton qUIButton18;
        QUIButton qUIButton19;
        QUIButton qUIButton20;
        QUIButton qUIButton21;
        QUIButton qUIButton22;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            return;
        }
        QUIButton qUIButton23 = null;
        if (aVar instanceof a.AbstractC8794a.C8795a) {
            qUIButton16 = this.this$0.joinTroopBtn;
            if (qUIButton16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("joinTroopBtn");
                qUIButton16 = null;
            }
            qUIButton16.setVisibility(0);
            qUIButton17 = this.this$0.sendMsgBtn;
            if (qUIButton17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sendMsgBtn");
                qUIButton17 = null;
            }
            qUIButton17.setVisibility(8);
            qUIButton18 = this.this$0.shareBtn;
            if (qUIButton18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareBtn");
                qUIButton18 = null;
            }
            qUIButton18.setVisibility(8);
            qUIButton19 = this.this$0.editInfoBtn;
            if (qUIButton19 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editInfoBtn");
                qUIButton19 = null;
            }
            qUIButton19.setVisibility(8);
            qUIButton20 = this.this$0.joinTroopBtn;
            if (qUIButton20 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("joinTroopBtn");
                qUIButton20 = null;
            }
            qUIButton21 = this.this$0.joinTroopBtn;
            if (qUIButton21 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("joinTroopBtn");
                qUIButton21 = null;
            }
            qUIButton20.setText(qUIButton21.getContext().getResources().getString(R.string.f171052c04));
            qUIButton22 = this.this$0.joinTroopBtn;
            if (qUIButton22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("joinTroopBtn");
            } else {
                qUIButton23 = qUIButton22;
            }
            final TroopInfoCardBottomPart troopInfoCardBottomPart = this.this$0;
            TriggerRunnerKt.b(qUIButton23, 1000L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.ag
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TroopInfoCardBottomPart$onInitView$1.f(TroopInfoCardBottomPart.this, aVar, view);
                }
            });
            return;
        }
        if (aVar instanceof a.AbstractC8794a.b) {
            qUIButton9 = this.this$0.joinTroopBtn;
            if (qUIButton9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("joinTroopBtn");
                qUIButton9 = null;
            }
            qUIButton9.setVisibility(0);
            qUIButton10 = this.this$0.sendMsgBtn;
            if (qUIButton10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sendMsgBtn");
                qUIButton10 = null;
            }
            qUIButton10.setVisibility(8);
            qUIButton11 = this.this$0.shareBtn;
            if (qUIButton11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareBtn");
                qUIButton11 = null;
            }
            qUIButton11.setVisibility(8);
            qUIButton12 = this.this$0.editInfoBtn;
            if (qUIButton12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editInfoBtn");
                qUIButton12 = null;
            }
            qUIButton12.setVisibility(8);
            qUIButton13 = this.this$0.joinTroopBtn;
            if (qUIButton13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("joinTroopBtn");
                qUIButton13 = null;
            }
            qUIButton14 = this.this$0.joinTroopBtn;
            if (qUIButton14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("joinTroopBtn");
                qUIButton14 = null;
            }
            qUIButton13.setText(qUIButton14.getContext().getResources().getString(R.string.f2059156w));
            qUIButton15 = this.this$0.joinTroopBtn;
            if (qUIButton15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("joinTroopBtn");
            } else {
                qUIButton23 = qUIButton15;
            }
            final TroopInfoCardBottomPart troopInfoCardBottomPart2 = this.this$0;
            TriggerRunnerKt.b(qUIButton23, 1000L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.ah
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TroopInfoCardBottomPart$onInitView$1.g(TroopInfoCardBottomPart.this, aVar, view);
                }
            });
            return;
        }
        if (Intrinsics.areEqual(aVar, a.b.f299747a)) {
            qUIButton = this.this$0.joinTroopBtn;
            if (qUIButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("joinTroopBtn");
                qUIButton = null;
            }
            qUIButton.setVisibility(8);
            qUIButton2 = this.this$0.sendMsgBtn;
            if (qUIButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sendMsgBtn");
                qUIButton2 = null;
            }
            qUIButton2.setVisibility(0);
            qUIButton3 = this.this$0.shareBtn;
            if (qUIButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareBtn");
                qUIButton3 = null;
            }
            qUIButton3.setVisibility(0);
            troopBasicInfoViewModel = this.this$0.basicInfoViewModel;
            if (troopBasicInfoViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
                troopBasicInfoViewModel = null;
            }
            com.tencent.mobileqq.troop.data.v D2 = troopBasicInfoViewModel.D2();
            if (D2 != null && (r11 = D2.i()) != null) {
                z16 = true;
            }
            z16 = false;
            if (z16) {
                qUIButton8 = this.this$0.editInfoBtn;
                if (qUIButton8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("editInfoBtn");
                    qUIButton8 = null;
                }
                qUIButton8.setVisibility(0);
            } else {
                qUIButton4 = this.this$0.editInfoBtn;
                if (qUIButton4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("editInfoBtn");
                    qUIButton4 = null;
                }
                qUIButton4.setVisibility(8);
            }
            qUIButton5 = this.this$0.sendMsgBtn;
            if (qUIButton5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sendMsgBtn");
                qUIButton5 = null;
            }
            final TroopInfoCardBottomPart troopInfoCardBottomPart3 = this.this$0;
            TriggerRunnerKt.b(qUIButton5, 1000L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.ai
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TroopInfoCardBottomPart$onInitView$1.h(TroopInfoCardBottomPart.this, view);
                }
            });
            qUIButton6 = this.this$0.shareBtn;
            if (qUIButton6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareBtn");
                qUIButton6 = null;
            }
            final TroopInfoCardBottomPart troopInfoCardBottomPart4 = this.this$0;
            TriggerRunnerKt.b(qUIButton6, 1000L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.aj
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TroopInfoCardBottomPart$onInitView$1.i(TroopInfoCardBottomPart.this, view);
                }
            });
            qUIButton7 = this.this$0.editInfoBtn;
            if (qUIButton7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editInfoBtn");
            } else {
                qUIButton23 = qUIButton7;
            }
            final TroopInfoCardBottomPart troopInfoCardBottomPart5 = this.this$0;
            TriggerRunnerKt.b(qUIButton23, 1000L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.ak
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TroopInfoCardBottomPart$onInitView$1.j(TroopInfoCardBottomPart.this, view);
                }
            });
        }
    }
}
