package com.tencent.mobileqq.troop.membersetting.part;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ys2.MemberSettingUIModel;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J&\u0010\t\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0002J\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/troop/membersetting/part/w;", "Lcom/tencent/mobileqq/troop/membersetting/part/t;", "", "K9", "N9", "", "mTroopUin", "mMemberUin", "currentAccountUin", "O9", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "H9", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "e", "[Lcom/tencent/mobileqq/widget/listitem/Group;", "groups", "Lys2/a;", "f", "Lys2/a;", "uiModel", "<init>", "()V", tl.h.F, "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class w extends t {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Group[] groups = new Group[0];

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private MemberSettingUIModel uiModel;

    private final void K9() {
        TextView textView = new TextView(getActivity());
        textView.setGravity(1);
        textView.setTextColor(getContext().getResources().getColor(R.color.qui_common_text_link_selector, null));
        textView.setTextSize(1, 14.0f);
        textView.setText(R.string.f169994bz);
        us2.b bVar = new us2.b(textView);
        bVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.troop.membersetting.part.u
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                w.L9(view);
            }
        });
        bVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.membersetting.part.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                w.M9(w.this, view);
            }
        });
        this.groups = new Group[]{new Group(bVar)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.setBackground(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(w this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.N9();
    }

    private final void O9(String mTroopUin, String mMemberUin, String currentAccountUin) {
        MemberSettingUIModel memberSettingUIModel = this.uiModel;
        if (memberSettingUIModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel = null;
        }
        TroopMemberCard troopMemberCard = memberSettingUIModel.getTroopMemberCard();
        boolean z16 = false;
        if (troopMemberCard != null && troopMemberCard.memberRole == 0) {
            z16 = true;
        }
        if (z16) {
            mTroopUin = "";
        }
        if (!TextUtils.isEmpty(mMemberUin) && !TextUtils.isEmpty(currentAccountUin)) {
            getActivity().startActivity(new Intent(getActivity(), (Class<?>) JumpActivity.class).setData(Uri.parse("mqq://group/report/?troopUin=" + mTroopUin + "&evilUin=" + mMemberUin + "&selfUin=" + currentAccountUin + "&scene=20008")));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FrdProfileCard_troopMemberCardMoreInfo", 2, "safetyReport param null");
        }
    }

    @Override // com.tencent.mobileqq.troop.membersetting.part.t
    /* renamed from: H9, reason: from getter */
    public Group[] getGroups() {
        return this.groups;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        this.uiModel = C9().Q1();
        K9();
    }

    private final void N9() {
        String troopUin;
        String str;
        if (!NetworkUtil.isNetSupport(getContext())) {
            QQToast.makeText(getContext(), R.string.f171139ci4, 0).show();
            return;
        }
        com.tencent.biz.webviewplugin.ad adVar = com.tencent.biz.webviewplugin.ad.f97536a;
        MemberSettingUIModel memberSettingUIModel = null;
        if (adVar.a()) {
            QLog.i("MemberSettingBottomReportPart", 1, "personalInGroupSafetyReport");
            MemberSettingUIModel memberSettingUIModel2 = this.uiModel;
            if (memberSettingUIModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel2 = null;
            }
            String str2 = "0";
            if (TextUtils.isEmpty(memberSettingUIModel2.getTroopUin())) {
                troopUin = "0";
            } else {
                MemberSettingUIModel memberSettingUIModel3 = this.uiModel;
                if (memberSettingUIModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                    memberSettingUIModel3 = null;
                }
                troopUin = memberSettingUIModel3.getTroopUin();
            }
            MemberSettingUIModel memberSettingUIModel4 = this.uiModel;
            if (memberSettingUIModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel4 = null;
            }
            TroopMemberCard troopMemberCard = memberSettingUIModel4.getTroopMemberCard();
            if (troopMemberCard != null) {
                if (troopMemberCard.isFriend) {
                    str2 = "1";
                }
                str = str2;
            } else {
                str = null;
            }
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            MemberSettingUIModel memberSettingUIModel5 = this.uiModel;
            if (memberSettingUIModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel5 = null;
            }
            String memberUin = memberSettingUIModel5.getMemberUin();
            MemberSettingUIModel memberSettingUIModel6 = this.uiModel;
            if (memberSettingUIModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel6 = null;
            }
            adVar.b(activity, "10097", memberUin, str, troopUin, memberSettingUIModel6.getMemberUin(), troopUin, "1", "");
        } else {
            MemberSettingUIModel memberSettingUIModel7 = this.uiModel;
            if (memberSettingUIModel7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel7 = null;
            }
            String troopUin2 = memberSettingUIModel7.getTroopUin();
            MemberSettingUIModel memberSettingUIModel8 = this.uiModel;
            if (memberSettingUIModel8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiModel");
                memberSettingUIModel8 = null;
            }
            O9(troopUin2, memberSettingUIModel8.getMemberUin(), z9().getCurrentAccountUin());
        }
        AppInterface z95 = z9();
        MemberSettingUIModel memberSettingUIModel9 = this.uiModel;
        if (memberSettingUIModel9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel9 = null;
        }
        String troopUin3 = memberSettingUIModel9.getTroopUin();
        xs2.c cVar = xs2.c.f448459a;
        MemberSettingUIModel memberSettingUIModel10 = this.uiModel;
        if (memberSettingUIModel10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
            memberSettingUIModel10 = null;
        }
        ReportController.o(z95, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_report", 0, 0, troopUin3, cVar.d(memberSettingUIModel10.getMyRole()), "", "");
        com.tencent.mobileqq.statistics.q d16 = new com.tencent.mobileqq.statistics.q(null).i("dc00899").a("Grp_mem_card").f("more").d("report_clk");
        String[] strArr = new String[1];
        MemberSettingUIModel memberSettingUIModel11 = this.uiModel;
        if (memberSettingUIModel11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiModel");
        } else {
            memberSettingUIModel = memberSettingUIModel11;
        }
        strArr[0] = memberSettingUIModel.getTroopUin();
        d16.b(strArr).g();
    }
}
