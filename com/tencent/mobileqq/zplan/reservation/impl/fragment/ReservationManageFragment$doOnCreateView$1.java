package com.tencent.mobileqq.zplan.reservation.impl.fragment;

import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.sqshow.zootopia.usercenter.friend.ui.ZPlanUserCenterEmptyView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mqq.app.MobileQQ;
import pv4.j;
import qv4.ad;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lqv4/ad;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lqv4/ad;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes34.dex */
final class ReservationManageFragment$doOnCreateView$1 extends Lambda implements Function1<ad, Unit> {
    final /* synthetic */ ReservationManageFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReservationManageFragment$doOnCreateView$1(ReservationManageFragment reservationManageFragment) {
        super(1);
        this.this$0 = reservationManageFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(j jVar, View view) {
        Intent intent = new Intent();
        intent.putExtra("reserve_id", jVar.f427619b);
        intent.putExtra("reserve_type", jVar.f427618a);
        QPublicFragmentActivity.start(MobileQQ.sMobileQQ, intent, ReservationManagerDetailFragment.class);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ad adVar) {
        invoke2(adVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ad adVar) {
        FormSimpleItem uh5;
        if (adVar != null) {
            ReservationManageFragment reservationManageFragment = this.this$0;
            j[] jVarArr = adVar.f429902a;
            Intrinsics.checkNotNullExpressionValue(jVarArr, "it.itemList");
            if (!(jVarArr.length == 0)) {
                reservationManageFragment.xh().setVisibility(0);
                reservationManageFragment.wh().setVisibility(8);
                reservationManageFragment.xh().removeAllViews();
                j[] jVarArr2 = adVar.f429902a;
                Intrinsics.checkNotNullExpressionValue(jVarArr2, "it.itemList");
                for (final j jVar : jVarArr2) {
                    uh5 = reservationManageFragment.uh();
                    uh5.c().setText(jVar.f427621d.f427630a);
                    uh5.h(true);
                    uh5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.reservation.impl.fragment.b
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ReservationManageFragment$doOnCreateView$1.b(j.this, view);
                        }
                    });
                    reservationManageFragment.xh().addView(uh5);
                }
                return;
            }
            reservationManageFragment.xh().setVisibility(8);
            reservationManageFragment.wh().setVisibility(0);
            reservationManageFragment.wh().setText(R.string.xbq);
            ZPlanUserCenterEmptyView emptyView = reservationManageFragment.wh();
            Intrinsics.checkNotNullExpressionValue(emptyView, "emptyView");
            ZPlanUserCenterEmptyView.setMode$default(emptyView, ZPlanUserCenterEmptyView.MODE.MODE_EMPTY_CONTENT, false, null, 4, null);
        }
    }
}
