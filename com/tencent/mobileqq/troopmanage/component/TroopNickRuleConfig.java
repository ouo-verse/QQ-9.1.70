package com.tencent.mobileqq.troopmanage.component;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.activity.TroopNickRuleFragment;
import com.tencent.mobileqq.troopmanage.repo.TroopManageViewModel;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/component/TroopNickRuleConfig;", "Lcom/tencent/mobileqq/troopmanage/component/bv;", "", UserInfo.SEX_FEMALE, "Landroid/view/View$OnClickListener;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "G", "Lcom/tencent/mobileqq/widget/listitem/Group;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;", "viewModel", "dtReportPgId", "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;Ljava/lang/String;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopNickRuleConfig extends bv {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopNickRuleConfig(QBaseActivity activity, QUIListItemAdapter adapter, LifecycleOwner lifecycleOwner, TroopManageViewModel viewModel, String dtReportPgId) {
        super(activity, adapter, lifecycleOwner, viewModel, dtReportPgId);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(dtReportPgId, "dtReportPgId");
    }

    private final View.OnClickListener A() {
        return new View.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.component.bz
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopNickRuleConfig.B(TroopNickRuleConfig.this, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(TroopNickRuleConfig this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent();
        intent.putExtra(TroopNickRuleFragment.Q, this$0.g().j());
        intent.putExtra(TroopNickRuleFragment.R, this$0.g().h().groupCardPrefixIntro);
        intent.putStringArrayListExtra(TroopNickRuleFragment.S, this$0.g().h().groupCardPrefix);
        intent.putExtra(TroopNickRuleFragment.T, "2");
        PublicFragmentActivity.b.d(this$0.b(), intent, PublicFragmentActivity.class, TroopNickRuleFragment.class, 26);
        bv.l(this$0, "em_group_nickname_rules", null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(TroopNickRuleConfig this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        bv.n(this$0, "em_group_nickname_rules", null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final String F() {
        if (TextUtils.isEmpty(g().h().groupCardPrefixIntro) && g().h().groupCardPrefix.isEmpty()) {
            String string = b().getResources().getString(R.string.eqt);
            Intrinsics.checkNotNullExpressionValue(string, "{\n            activity.r\u2026r_card_not_set)\n        }");
            return string;
        }
        String string2 = b().getResources().getString(R.string.f180883c_);
        Intrinsics.checkNotNullExpressionValue(string2, "{\n            activity.r\u2026r_card_has_set)\n        }");
        return string2;
    }

    private final boolean G() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105932", true);
    }

    public Group C() {
        if (!G()) {
            return new Group(new com.tencent.mobileqq.widget.listitem.a[0]);
        }
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = new com.tencent.mobileqq.widget.listitem.a[1];
        final com.tencent.mobileqq.widget.listitem.x v3 = bv.v(this, R.string.z9n, F(), null, null, 12, null);
        v3.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.troopmanage.component.bw
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                TroopNickRuleConfig.D(TroopNickRuleConfig.this, view);
            }
        });
        v3.p((g().e() || g().d()) ? false : true);
        v3.x(A());
        MutableLiveData<String> h26 = h().h2();
        LifecycleOwner e16 = e();
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.troopmanage.component.TroopNickRuleConfig$getComponentGroup$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                x.c.g O = v3.O();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                O.h(it);
                this.c().l0(v3);
            }
        };
        h26.observe(e16, new Observer() { // from class: com.tencent.mobileqq.troopmanage.component.bx
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopNickRuleConfig.E(Function1.this, obj);
            }
        });
        Unit unit = Unit.INSTANCE;
        aVarArr[0] = v3;
        return new Group(aVarArr);
    }
}
