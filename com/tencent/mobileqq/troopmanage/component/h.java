package com.tencent.mobileqq.troopmanage.component;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.CompoundButton;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.shortcut.api.ITroopShortcutApi;
import com.tencent.mobileqq.troopmanage.repo.TroopManageViewModel;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u001c\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/component/h;", "Lcom/tencent/mobileqq/troopmanage/component/bv;", "", "troopUin", "", "B", "isChecked", "", "D", BdhLogUtil.LogTag.Tag_Conn, "", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/widget/listitem/Group;", "y", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;", "viewModel", "dtReportPgId", "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;Ljava/lang/String;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class h extends bv {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(QBaseActivity activity, QUIListItemAdapter adapter, LifecycleOwner lifecycleOwner, TroopManageViewModel viewModel, String dtReportPgId) {
        super(activity, adapter, lifecycleOwner, viewModel, dtReportPgId);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(dtReportPgId, "dtReportPgId");
    }

    private final Map<String, Object> A(boolean isChecked) {
        HashMap hashMap = new HashMap();
        hashMap.put("group_quick_application_switch", Integer.valueOf(isChecked ? 1 : 0));
        return hashMap;
    }

    private final boolean B(String troopUin) {
        Long longOrNull;
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
        if (longOrNull == null) {
            return false;
        }
        return !((ITroopShortcutApi) QRoute.api(ITroopShortcutApi.class)).getDisableCapsule(longOrNull.longValue());
    }

    private final boolean C() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(b());
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String account = peekAppRuntime != null ? peekAppRuntime.getAccount() : null;
        if (account == null) {
            account = "";
        }
        String str = "troopapp_aio_shortcut_bar_guide" + account;
        boolean z16 = defaultSharedPreferences.getBoolean(str, true);
        if (z16) {
            SharedPreferences.Editor edit = defaultSharedPreferences.edit();
            edit.putBoolean(str, false);
            edit.apply();
        }
        return z16;
    }

    private final void D(String troopUin, boolean isChecked) {
        ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).setAppShortCutBarSwitch(com.tencent.mobileqq.troop.utils.bg.e(), troopUin, !isChecked ? 1 : 0, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(h this$0, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.D(this$0.g().j(), z16);
        if (z16 && this$0.C() && this$0.g().h().isOwnerOrAdmin()) {
            new com.tencent.mobileqq.troop.troopapps.i(this$0.b()).show();
        }
        this$0.k("em_group_quick_application_switch", this$0.A(z16));
    }

    public Group y() {
        ArrayList arrayList = new ArrayList();
        if (wt2.a.f446500a.a(g().h())) {
            com.tencent.mobileqq.widget.listitem.x xVar = new com.tencent.mobileqq.widget.listitem.x(new x.b.d("\u5728\u804a\u5929\u5feb\u6377\u680f\u5c55\u793a\u7fa4\u5e94\u7528"), new x.c.f(B(g().j()), new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.troopmanage.component.g
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    h.z(h.this, compoundButton, z16);
                }
            }));
            m("em_group_quick_application_switch", A(((x.c.f) xVar.O()).getIsChecked()));
            arrayList.add(xVar);
        }
        Object[] array = arrayList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        return new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length));
    }
}
