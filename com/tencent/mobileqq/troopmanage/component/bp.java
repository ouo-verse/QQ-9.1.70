package com.tencent.mobileqq.troopmanage.component;

import android.content.Intent;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi;
import com.tencent.mobileqq.troopmanage.base.TroopManageRemoteHandler;
import com.tencent.mobileqq.troopmanage.repo.TroopManageViewModel;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\f\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0016R$\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/component/bp;", "Lcom/tencent/mobileqq/troopmanage/component/bv;", "Lcom/tencent/mobileqq/widget/listitem/a;", UserInfo.SEX_FEMALE, "Landroid/view/View$OnClickListener;", BdhLogUtil.LogTag.Tag_Conn, "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/widget/listitem/Group;", "E", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "g", "Lcom/tencent/mobileqq/widget/listitem/x;", "troopLevelConfig", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;", "viewModel", "", "dtReportPgId", "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;Ljava/lang/String;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class bp extends bv {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> troopLevelConfig;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bp(QBaseActivity activity, QUIListItemAdapter adapter, LifecycleOwner lifecycleOwner, TroopManageViewModel viewModel, String dtReportPgId) {
        super(activity, adapter, lifecycleOwner, viewModel, dtReportPgId);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(dtReportPgId, "dtReportPgId");
    }

    private final void A() {
        h().T1().getTroopManageRemoteHandler().g(1, null, new TroopManageRemoteHandler.c() { // from class: com.tencent.mobileqq.troopmanage.component.bo
            @Override // com.tencent.mobileqq.troopmanage.base.TroopManageRemoteHandler.c
            public final void a(int i3, Object obj) {
                bp.B(bp.this, i3, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(bp this$0, int i3, Object obj) {
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if ((obj instanceof Integer) && (xVar = this$0.troopLevelConfig) != null && (((Number) obj).intValue() & 1) == 0 && Intrinsics.areEqual("5.5.0", AppSetting.f99551k)) {
            x.c.g O = xVar.O();
            x.c.g gVar = O instanceof x.c.g ? O : null;
            if (gVar != null) {
                String string = this$0.b().getString(R.string.ds8);
                Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.string.qb_group_new)");
                gVar.h(string);
            }
        }
    }

    private final View.OnClickListener C() {
        return new View.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.component.bn
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bp.D(bp.this, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(bp this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String troopHonorSettingUrl = ((ITroopLinkApi) QRoute.api(ITroopLinkApi.class)).getTroopHonorSettingUrl(this$0.g().j(), this$0.g().f());
        QLog.i("TroopSubManageFeatureFragment.FeatureConfigList", 1, "[createTroopLevelListener] onClick. url:" + troopHonorSettingUrl);
        Intent intent = new Intent(this$0.b(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
        intent.putExtra("url", troopHonorSettingUrl);
        intent.putExtra("uin", this$0.g().b());
        intent.putExtra("portraitOnly", true);
        intent.putExtra("hide_more_button", true);
        intent.putExtra("hide_operation_bar", true);
        this$0.b().startActivity(intent);
        if (this$0.g().f()) {
            bv.l(this$0, "em_group_honor", null, 2, null);
        }
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> F() {
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> v3 = bv.v(this, g().f() ? R.string.z9_ : R.string.z9r, "", null, null, 12, null);
        v3.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.troopmanage.component.bm
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                bp.G(bp.this, view);
            }
        });
        this.troopLevelConfig = v3;
        v3.x(C());
        A();
        return v3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(bp this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        if (this$0.g().f()) {
            bv.n(this$0, "em_group_honor", null, 2, null);
        }
    }

    public Group E() {
        return new Group(F());
    }
}
