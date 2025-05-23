package com.tencent.mobileqq.troopmanage.component;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troopmanage.event.TroopManageTransferTroopMembersEvent;
import com.tencent.mobileqq.troopmanage.repo.TroopManageViewModel;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\n\u001a\u00020\u00042\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/component/TransferGroupComponent;", "Lcom/tencent/mobileqq/troopmanage/component/bv;", "Landroid/view/View$OnClickListener;", "D", "", "I", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "transferTroopMembers", "K", "Lcom/tencent/mobileqq/widget/listitem/Group;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;", "viewModel", "dtReportPgId", "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;Ljava/lang/String;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TransferGroupComponent extends bv {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransferGroupComponent(@NotNull QBaseActivity activity, @NotNull QUIListItemAdapter adapter, @NotNull LifecycleOwner lifecycleOwner, @NotNull TroopManageViewModel viewModel, @NotNull String dtReportPgId) {
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

    private final View.OnClickListener D() {
        return new View.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.component.be
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TransferGroupComponent.E(TransferGroupComponent.this, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(TransferGroupComponent this$0, View view) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.g().i().bOwner) {
            if (this$0.g().h().wMemberNum <= 1) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16 && this$0.h().j2()) {
                this$0.h().X1().i();
            } else if (z16) {
                QQToast.makeText(this$0.b(), 1, R.string.cjm, 0).show();
            } else {
                this$0.I();
            }
            bv.l(this$0, "em_group_transfer", null, 2, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(TransferGroupComponent this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        bv.n(this$0, "em_group_transfer", null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I() {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(b(), 230);
        createCustomDialog.setMessage(R.string.i65).setPositiveButton(R.string.hsi, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.component.bf
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                TransferGroupComponent.J(dialogInterface, i3);
            }
        }).setTitle(R.string.i7p);
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(ArrayList<String> transferTroopMembers) {
        Intent intent = new Intent(b(), (Class<?>) TroopTransferActivity.class);
        intent.putExtra(AppConstants.Key.TROOP_INFO_FLAG_EXT, g().i().dwGroupFlagExt);
        intent.putExtra(AppConstants.LeftViewText.LEFTVIEWTEXT, b().getResources().getString(R.string.i7o));
        intent.putStringArrayListExtra("troopVipMembers", transferTroopMembers);
        intent.putExtra("troop_uin", g().j());
        intent.putExtra(AppConstants.Key.TROOP_CODE, g().j());
        intent.putExtra("uinname", g().i().troopName);
        intent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
        b().startActivityForResult(intent, 21);
    }

    @NotNull
    public Group F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Group) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (i()) {
            com.tencent.mobileqq.widget.listitem.x v3 = bv.v(this, R.string.z8z, "", null, null, 12, null);
            v3.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.troopmanage.component.bc
                @Override // com.tencent.mobileqq.widget.listitem.g
                public final void M(View view) {
                    TransferGroupComponent.G(TransferGroupComponent.this, view);
                }
            });
            v3.x(D());
            MutableLiveData<TroopManageTransferTroopMembersEvent> e26 = h().e2();
            LifecycleOwner e16 = e();
            final Function1<TroopManageTransferTroopMembersEvent, Unit> function1 = new Function1<TroopManageTransferTroopMembersEvent, Unit>() { // from class: com.tencent.mobileqq.troopmanage.component.TransferGroupComponent$getComponentGroup$1$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TransferGroupComponent.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TroopManageTransferTroopMembersEvent troopManageTransferTroopMembersEvent) {
                    invoke2(troopManageTransferTroopMembersEvent);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(TroopManageTransferTroopMembersEvent troopManageTransferTroopMembersEvent) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) troopManageTransferTroopMembersEvent);
                        return;
                    }
                    if (troopManageTransferTroopMembersEvent.getTransferResult()) {
                        ArrayList<String> transferTroopMembers = troopManageTransferTroopMembersEvent.getTransferTroopMembers();
                        if (transferTroopMembers == null || transferTroopMembers.isEmpty()) {
                            TransferGroupComponent.this.I();
                            return;
                        } else {
                            TransferGroupComponent.this.K(troopManageTransferTroopMembersEvent.getTransferTroopMembers());
                            return;
                        }
                    }
                    com.tencent.mobileqq.troopmanage.base.g gVar = com.tencent.mobileqq.troopmanage.base.g.f303036a;
                    String string = TransferGroupComponent.this.b().getResources().getString(R.string.f173227i61);
                    Intrinsics.checkNotNullExpressionValue(string, "activity.resources.getSt\u2026ng_transable_member_fail)");
                    gVar.b(string);
                }
            };
            e26.observe(e16, new Observer() { // from class: com.tencent.mobileqq.troopmanage.component.bd
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    TransferGroupComponent.H(Function1.this, obj);
                }
            });
            Unit unit = Unit.INSTANCE;
            return new Group(v3);
        }
        return new Group(new com.tencent.mobileqq.widget.listitem.a[0]);
    }
}
