package com.tencent.mobileqq.troopmanage.component;

import android.content.Intent;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.troopbindguild.api.ITroopBindGuildApi;
import com.tencent.mobileqq.troop.troopmanager.guildmanage.bindsetting.TroopBindGuildSettingFragment;
import com.tencent.mobileqq.troop.troopmanager.guildmanage.guildlist.TroopBindGuildListFragment;
import com.tencent.mobileqq.troopmanage.repo.TroopManageViewModel;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/component/bi;", "Lcom/tencent/mobileqq/troopmanage/component/bv;", "Lcom/tencent/mobileqq/widget/listitem/Group;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;", "viewModel", "", "dtReportPgId", "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;Ljava/lang/String;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class bi extends bv {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bi(@NotNull QBaseActivity activity, @NotNull QUIListItemAdapter adapter, @NotNull LifecycleOwner lifecycleOwner, @NotNull TroopManageViewModel viewModel, @NotNull String dtReportPgId) {
        super(activity, adapter, lifecycleOwner, viewModel, dtReportPgId);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(dtReportPgId, "dtReportPgId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, adapter, lifecycleOwner, viewModel, dtReportPgId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(bi this$0, String str, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QBaseActivity b16 = this$0.b();
        Intent intent = new Intent();
        intent.putExtra("troop_uin", str);
        QPublicFragmentActivity.start(b16, intent, TroopBindGuildListFragment.class);
        bv.l(this$0, "em_group_channel_show", null, 2, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(String troopUin, bi this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TroopBindGuildSettingFragment.Companion companion = TroopBindGuildSettingFragment.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(troopUin, "troopUin");
        companion.a(troopUin);
        bv.l(this$0, "em_group_channel_bind_set", null, 2, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    @NotNull
    public Group z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Group) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (!i()) {
            return new Group(new com.tencent.mobileqq.widget.listitem.a[0]);
        }
        final String str = h().X1().m().i().troopUin;
        ArrayList arrayList = new ArrayList();
        if (((ITroopBindGuildApi) QRoute.api(ITroopBindGuildApi.class)).getAIOShowBindGuildSwitch()) {
            com.tencent.mobileqq.widget.listitem.x v3 = bv.v(this, R.string.f235667c_, "", null, new View.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.component.bg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    bi.A(bi.this, str, view);
                }
            }, 4, null);
            bv.n(this, "em_group_channel_show", null, 2, null);
            arrayList.add(v3);
        }
        com.tencent.mobileqq.widget.listitem.x v16 = bv.v(this, R.string.f2336077p, "", null, new View.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.component.bh
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bi.B(str, this, view);
            }
        }, 4, null);
        bv.n(this, "em_group_channel_bind_set", null, 2, null);
        arrayList.add(v16);
        Object[] array = arrayList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        return new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length));
    }
}
