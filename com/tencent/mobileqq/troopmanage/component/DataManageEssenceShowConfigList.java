package com.tencent.mobileqq.troopmanage.component;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troopmanage.event.TroopManageSetTroopEssenceMsgShowEvent;
import com.tencent.mobileqq.troopmanage.repo.TroopManageViewModel;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/component/DataManageEssenceShowConfigList;", "Lcom/tencent/mobileqq/troopmanage/component/bv;", "Lcom/tencent/mobileqq/widget/listitem/Group;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;", "viewModel", "", "dtReportPgId", "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;Ljava/lang/String;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class DataManageEssenceShowConfigList extends bv {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataManageEssenceShowConfigList(@NotNull QBaseActivity activity, @NotNull QUIListItemAdapter adapter, @NotNull LifecycleOwner lifecycleOwner, @NotNull TroopManageViewModel viewModel, @NotNull String dtReportPgId) {
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
    public static final void A(com.tencent.mobileqq.widget.listitem.x this_apply, DataManageEssenceShowConfigList this$0, View view) {
        int i3;
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        HashMap hashMap = new HashMap();
        if (((x.c.f) this_apply.O()).getIsChecked()) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        hashMap.put("after_click_state", Integer.valueOf(i3));
        this$0.m("em_group_show_essence", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @NotNull
    public Group z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Group) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        boolean z16 = true;
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = new com.tencent.mobileqq.widget.listitem.a[1];
        final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> p16 = p(R.string.z8g, new Function2<com.tencent.mobileqq.widget.listitem.x<?, x.c.f>, Boolean, Unit>() { // from class: com.tencent.mobileqq.troopmanage.component.DataManageEssenceShowConfigList$getComponentGroup$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DataManageEssenceShowConfigList.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.widget.listitem.x<?, x.c.f> xVar, Boolean bool) {
                invoke(xVar, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull com.tencent.mobileqq.widget.listitem.x<?, x.c.f> xVar, boolean z17) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, xVar, Boolean.valueOf(z17));
                    return;
                }
                Intrinsics.checkNotNullParameter(xVar, "<anonymous parameter 0>");
                DataManageEssenceShowConfigList.this.h().l2(z17);
                HashMap hashMap = new HashMap();
                hashMap.put("after_click_state", Integer.valueOf(z17 ? 1 : 2));
                DataManageEssenceShowConfigList.this.k("em_group_show_essence", hashMap);
            }
        });
        p16.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.troopmanage.component.v
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                DataManageEssenceShowConfigList.A(com.tencent.mobileqq.widget.listitem.x.this, this, view);
            }
        });
        x.c.f O = p16.O();
        if (g().h().groupExt.essentialMsgSwitch == 0) {
            z16 = false;
        }
        O.f(z16);
        MutableLiveData<TroopManageSetTroopEssenceMsgShowEvent> b26 = h().b2();
        LifecycleOwner e16 = e();
        final Function1<TroopManageSetTroopEssenceMsgShowEvent, Unit> function1 = new Function1<TroopManageSetTroopEssenceMsgShowEvent, Unit>(p16, this) { // from class: com.tencent.mobileqq.troopmanage.component.DataManageEssenceShowConfigList$getComponentGroup$2$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> $this_apply;
            final /* synthetic */ DataManageEssenceShowConfigList this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$this_apply = p16;
                this.this$0 = this;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) p16, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TroopManageSetTroopEssenceMsgShowEvent troopManageSetTroopEssenceMsgShowEvent) {
                invoke2(troopManageSetTroopEssenceMsgShowEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TroopManageSetTroopEssenceMsgShowEvent troopManageSetTroopEssenceMsgShowEvent) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) troopManageSetTroopEssenceMsgShowEvent);
                } else {
                    this.$this_apply.O().f(troopManageSetTroopEssenceMsgShowEvent.getResult());
                    this.this$0.c().l0(this.$this_apply);
                }
            }
        };
        b26.observe(e16, new Observer() { // from class: com.tencent.mobileqq.troopmanage.component.w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DataManageEssenceShowConfigList.B(Function1.this, obj);
            }
        });
        Unit unit = Unit.INSTANCE;
        aVarArr[0] = p16;
        return new Group(aVarArr);
    }
}
