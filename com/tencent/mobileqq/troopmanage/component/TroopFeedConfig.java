package com.tencent.mobileqq.troopmanage.component;

import android.content.Intent;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedConfigAPi;
import com.tencent.mobileqq.troop.activity.TroopFeedSettingFragment;
import com.tencent.mobileqq.troopmanage.event.TroopManageTroopFeedEvent;
import com.tencent.mobileqq.troopmanage.repo.TroopManageViewModel;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/component/TroopFeedConfig;", "Lcom/tencent/mobileqq/troopmanage/component/bv;", "", "troopFeedSwitch", "", "troopFeedTalkPermission", "", "G", "Landroid/view/View$OnClickListener;", "B", "Lcom/tencent/mobileqq/widget/listitem/Group;", "D", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;", "viewModel", "dtReportPgId", "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;Ljava/lang/String;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopFeedConfig extends bv {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopFeedConfig(QBaseActivity activity, QUIListItemAdapter adapter, LifecycleOwner lifecycleOwner, TroopManageViewModel viewModel, String dtReportPgId) {
        super(activity, adapter, lifecycleOwner, viewModel, dtReportPgId);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(dtReportPgId, "dtReportPgId");
    }

    private final View.OnClickListener B() {
        return new View.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.component.bl
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopFeedConfig.C(TroopFeedConfig.this, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(TroopFeedConfig this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent();
        intent.putExtra("PARAM_UIN", this$0.g().j());
        intent.putExtra(IGuildFeedConfigAPi.PARAM_GUILD_ID, this$0.g().i().troopGuildId);
        intent.putExtra("PARAM_OPTION_SELECTED", this$0.g().i().troopFeedTalkPermission);
        intent.putExtra("PARAM_OPTION_SWITCH", this$0.g().i().troopFeedSwitch);
        PublicFragmentActivity.b.d(this$0.b(), intent, PublicFragmentActivity.class, TroopFeedSettingFragment.class, 27);
        bv.l(this$0, "em_sgrp_group_set_manage_forum", null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(TroopFeedConfig this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        bv.n(this$0, "em_sgrp_group_set_manage_forum", null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public Group D() {
        final com.tencent.mobileqq.widget.listitem.x v3 = bv.v(this, R.string.f170507z90, G(g().i().troopFeedSwitch, g().i().troopFeedTalkPermission), null, null, 12, null);
        v3.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.troopmanage.component.bj
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                TroopFeedConfig.E(TroopFeedConfig.this, view);
            }
        });
        v3.p(h().k2());
        v3.x(B());
        MutableLiveData<TroopManageTroopFeedEvent> f26 = h().f2();
        LifecycleOwner e16 = e();
        final Function1<TroopManageTroopFeedEvent, Unit> function1 = new Function1<TroopManageTroopFeedEvent, Unit>() { // from class: com.tencent.mobileqq.troopmanage.component.TroopFeedConfig$getComponentGroup$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TroopManageTroopFeedEvent troopManageTroopFeedEvent) {
                invoke2(troopManageTroopFeedEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TroopManageTroopFeedEvent troopManageTroopFeedEvent) {
                String G;
                x.c.g O = v3.O();
                G = this.G(troopManageTroopFeedEvent.getTroopFeedSwitch(), troopManageTroopFeedEvent.getTroopFeedTalkPermission());
                O.h(G);
                this.c().l0(v3);
            }
        };
        f26.observe(e16, new Observer() { // from class: com.tencent.mobileqq.troopmanage.component.bk
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopFeedConfig.F(Function1.this, obj);
            }
        });
        Unit unit = Unit.INSTANCE;
        return new Group(v3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String G(boolean troopFeedSwitch, int troopFeedTalkPermission) {
        if (!troopFeedSwitch) {
            String string = b().getResources().getString(R.string.f180203af);
            Intrinsics.checkNotNullExpressionValue(string, "activity.resources.getSt\u2026_troop_feed_switch_close)");
            return string;
        }
        if (troopFeedTalkPermission == 2) {
            String string2 = b().getResources().getString(R.string.f180103a6);
            Intrinsics.checkNotNullExpressionValue(string2, "activity.resources.getSt\u2026troop_feed_setting_admin)");
            return string2;
        }
        if (troopFeedTalkPermission == 1) {
            String string3 = b().getResources().getString(R.string.f180123a8);
            Intrinsics.checkNotNullExpressionValue(string3, "activity.resources.getSt\u2026b_troop_feed_setting_all)");
            return string3;
        }
        return "";
    }
}
