package com.tencent.mobileqq.troopmanage.component;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.TroopGagActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troopmanage.TroopSubManageAuthorityManageFragment;
import com.tencent.mobileqq.troopmanage.activity.SpeechLimitSettingActivity;
import com.tencent.mobileqq.troopmanage.event.TroopManageSpeechLimitEvent;
import com.tencent.mobileqq.troopmanage.repo.TroopManageViewModel;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016R$\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/component/AuthorityManageComponent;", "Lcom/tencent/mobileqq/troopmanage/component/bv;", "", "key", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/view/View$OnClickListener;", UserInfo.SEX_FEMALE, "J", "H", "Lcom/tencent/mobileqq/widget/listitem/Group;", "L", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "g", "Lcom/tencent/mobileqq/widget/listitem/x;", "speechFrequencyLimitConfig", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;", "viewModel", "", "dtReportPgId", "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;Ljava/lang/String;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class AuthorityManageComponent extends bv {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> speechFrequencyLimitConfig;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthorityManageComponent(@NotNull QBaseActivity activity, @NotNull QUIListItemAdapter adapter, @NotNull LifecycleOwner lifecycleOwner, @NotNull TroopManageViewModel viewModel, @NotNull String dtReportPgId) {
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

    private final View.OnClickListener F() {
        return new View.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.component.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuthorityManageComponent.G(AuthorityManageComponent.this, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(AuthorityManageComponent this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Bundle bundle = new Bundle();
        bundle.putString("req_troop_uin", this$0.g().j());
        this$0.h().T1().getTroopManageRemoteHandler().g(3, bundle, null);
        Intent intent = new Intent(this$0.b(), (Class<?>) TroopGagActivity.class);
        intent.putExtra(AppConstants.LeftViewText.LEFTVIEWTEXT, this$0.b().getString(R.string.i7o));
        intent.putExtra("uin", this$0.g().b());
        intent.putExtra("troopuin", this$0.g().j());
        intent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
        this$0.b().startActivity(intent);
        bv.l(this$0, "em_group_mute", null, 2, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final View.OnClickListener H() {
        return new View.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.component.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuthorityManageComponent.I(AuthorityManageComponent.this, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(AuthorityManageComponent this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent f16 = this$0.f();
        f16.putExtra(AppConstants.LeftViewText.LEFTVIEWTEXT, this$0.b().getString(R.string.i7o));
        f16.putExtra("troop_uin", this$0.g().j());
        f16.putExtra("uin", this$0.g().b());
        f16.putExtra(AppConstants.Key.KEY_QIDIAN_PRIVATE_TROOP, this$0.g().e());
        QPublicFragmentActivity.start(this$0.b(), f16, TroopSubManageAuthorityManageFragment.class);
        bv.l(this$0, "em_group_members_permission", null, 2, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final View.OnClickListener J() {
        return new View.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.component.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuthorityManageComponent.K(AuthorityManageComponent.this, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(AuthorityManageComponent this$0, View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent();
        intent.putExtra("troop_uin", this$0.g().j());
        intent.putExtra(AppConstants.Key.LIMIT_FREQ, this$0.g().h().nMsgLimitFreq);
        if (this$0.g().i().bOwner) {
            str = "0";
        } else {
            str = "1";
        }
        intent.putExtra("role", str);
        QPublicFragmentActivity.startForResult(this$0.b(), intent, (Class<? extends QPublicBaseFragment>) SpeechLimitSettingActivity.class, 24);
        bv.l(this$0, "em_group_message_rate_limit", null, 2, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(AuthorityManageComponent this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        bv.n(this$0, "em_group_mute", null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(AuthorityManageComponent this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        bv.n(this$0, "em_group_message_rate_limit", null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(AuthorityManageComponent this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        bv.n(this$0, "em_group_members_permission", null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q(int key) {
        String string;
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar = this.speechFrequencyLimitConfig;
        if (xVar == null) {
            return;
        }
        x.c.g O = xVar.O();
        if (key != 0) {
            if (key != 5) {
                if (key != 10) {
                    string = "";
                } else {
                    string = b().getString(R.string.evi);
                    Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str\u2026p_speech_limit_option_10)");
                }
            } else {
                string = b().getString(R.string.evj);
                Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str\u2026op_speech_limit_option_5)");
            }
        } else {
            string = b().getString(R.string.f181233d8);
            Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str\u2026ch_limit_option_no_limit)");
        }
        O.h(string);
        c().l0(xVar);
    }

    @NotNull
    public Group L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Group) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        String string = b().getString(R.string.z8y);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str\u2026uthority_manage_top_desc)");
        com.tencent.mobileqq.widget.listitem.x v3 = bv.v(this, R.string.z95, "", null, null, 12, null);
        v3.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.troopmanage.component.i
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                AuthorityManageComponent.M(AuthorityManageComponent.this, view);
            }
        });
        v3.x(F());
        Unit unit = Unit.INSTANCE;
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> v16 = bv.v(this, R.string.z9q, "", null, null, 12, null);
        v16.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.troopmanage.component.j
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                AuthorityManageComponent.N(AuthorityManageComponent.this, view);
            }
        });
        this.speechFrequencyLimitConfig = v16;
        v16.p(g().g());
        Q(g().h().nMsgLimitFreq);
        v16.x(J());
        MutableLiveData<TroopManageSpeechLimitEvent> d26 = h().d2();
        LifecycleOwner e16 = e();
        final Function1<TroopManageSpeechLimitEvent, Unit> function1 = new Function1<TroopManageSpeechLimitEvent, Unit>() { // from class: com.tencent.mobileqq.troopmanage.component.AuthorityManageComponent$getComponentGroup$2$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AuthorityManageComponent.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TroopManageSpeechLimitEvent troopManageSpeechLimitEvent) {
                invoke2(troopManageSpeechLimitEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TroopManageSpeechLimitEvent troopManageSpeechLimitEvent) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    AuthorityManageComponent.this.Q(troopManageSpeechLimitEvent.getMsgLimitFreq());
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) troopManageSpeechLimitEvent);
                }
            }
        };
        d26.observe(e16, new Observer() { // from class: com.tencent.mobileqq.troopmanage.component.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AuthorityManageComponent.O(Function1.this, obj);
            }
        });
        com.tencent.mobileqq.widget.listitem.x u16 = bv.u(this, R.string.z9p, R.string.z9s, null, null, 12, null);
        u16.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.troopmanage.component.l
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                AuthorityManageComponent.P(AuthorityManageComponent.this, view);
            }
        });
        u16.p(g().i().bOwner);
        u16.x(H());
        return new Group(string, v3, v16, u16);
    }
}
