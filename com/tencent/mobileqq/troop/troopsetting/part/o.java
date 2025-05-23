package com.tencent.mobileqq.troop.troopsetting.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopsetting.modules.jubao.TroopJuBaoUtils;
import com.tencent.mobileqq.utils.eu;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016\u00a2\u0006\u0004\b\t\u0010\nR\u0018\u0010\r\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/part/o;", "Lcom/tencent/mobileqq/troop/troopsetting/part/h;", "", "J9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "G9", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "e", "Lcom/tencent/mobileqq/widget/listitem/Group;", VipFunCallConstants.KEY_GROUP, "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class o extends h {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Group group;

    public o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void J9() {
        final TroopInfoData T2 = B9().T2();
        TextView textView = new TextView(getActivity());
        textView.setGravity(1);
        textView.setTextColor(getContext().getResources().getColor(R.color.qui_common_text_link_selector, null));
        textView.setTextSize(1, 14.0f);
        textView.setText(R.string.f234647_i);
        com.tencent.mobileqq.troop.troopsetting.customconfig.b bVar = new com.tencent.mobileqq.troop.troopsetting.customconfig.b(textView);
        bVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.troop.troopsetting.part.m
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                o.K9(view);
            }
        });
        bVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o.L9(o.this, T2, view);
            }
        });
        this.group = new Group(bVar);
        eu.g("Grp_set_new", "grpData_admin", "tipoff_exp", 0, 0, T2.troopUin);
        VideoReport.setElementId(textView, "em_group_report_btn");
        HashMap hashMap = new HashMap();
        hashMap.put("group_btn_location", 1);
        com.tencent.mobileqq.troop.troopsetting.report.c.f301449a.B(textView, "em_group_report_btn", hashMap, ExposurePolicy.REPORT_ALL, ClickPolicy.REPORT_ALL, EndExposurePolicy.REPORT_NONE, T2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.setBackground(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(o this$0, TroopInfoData mTroopInfoData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mTroopInfoData, "$mTroopInfoData");
        Bundle arguments = this$0.getPartHost().getArguments();
        int i3 = -1;
        if (arguments != null) {
            i3 = arguments.getInt("t_s_f", -1);
        }
        Activity activity = this$0.getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
        TroopJuBaoUtils.c((QBaseActivity) activity, i3, mTroopInfoData);
        eu.g("Grp_set_new", "grpData_admin", "tipoff_click", 0, 0, mTroopInfoData.troopUin);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.troop.troopsetting.part.h
    @NotNull
    public Group[] G9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Group[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Group group = this.group;
        if (group != null) {
            return new Group[]{group};
        }
        return new Group[0];
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
        } else {
            super.onInitView(rootView);
            J9();
        }
    }
}
