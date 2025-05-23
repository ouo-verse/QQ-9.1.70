package com.tencent.mobileqq.troop.troopsetting.bizconfig;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.CompoundButton;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msg.api.IFeatureSwitch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.troopsetting.event.a;
import com.tencent.mobileqq.troop.troopsetting.vm.TroopSettingViewModel;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.eu;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\u0006\u0010\f\u001a\u00020\u0006R\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/bizconfig/k;", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$f;", "", "isChecked", "", "h0", "g0", "isCheck", "b0", "d0", "e0", "Landroid/app/Activity;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "r", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "getAdapter", "()Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "Lcom/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel;", "getViewModel", "()Lcom/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel;", "viewModel", "<init>", "(Landroid/app/Activity;Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;Lcom/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class k extends x<x.b.d, x.c.f> {
    static IPatchRedirector $redirector_;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Activity activity;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final QUIListItemAdapter adapter;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TroopSettingViewModel viewModel;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public k(@NotNull Activity activity, @Nullable QUIListItemAdapter qUIListItemAdapter, @NotNull TroopSettingViewModel viewModel) {
        super(new x.b.d(r1), new x.c.f(false, null, 2, null));
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        String string = activity.getResources().getString(R.string.iwm);
        Intrinsics.checkNotNullExpressionValue(string, "activity.resources.getSt\u2026ring.qb_hiddenchat_title)");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, qUIListItemAdapter, viewModel);
            return;
        }
        this.activity = activity;
        this.adapter = qUIListItemAdapter;
        this.viewModel = viewModel;
        viewModel.F3(false);
        O().f(viewModel.z2());
        O().h(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.troop.troopsetting.bizconfig.h
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                k.Z(k.this, compoundButton, z16);
            }
        });
        Intent intent = activity.getIntent();
        if (intent != null && intent.getBooleanExtra("KEY_IS_FROM_SCALE_CHAT", false)) {
            p(false);
        }
        w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.troop.troopsetting.bizconfig.i
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                k.a0(k.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(k this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h0(z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(k this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        com.tencent.mobileqq.troop.troopsetting.report.c.f301449a.m(this$0.viewModel.T2());
    }

    private final boolean b0(boolean isCheck) {
        if (!((IFeatureSwitch) QRoute.api(IFeatureSwitch.class)).isFeatureSwitchEnable(ITroopUtilApi.HIDDEN_CHAT_DISABLE_OPEN_ON_STUDY_MODE, false) || !isCheck || !d0()) {
            return false;
        }
        QQToast.makeText(this.activity, 0, R.string.f2050054f, 0).show();
        x.c.f O = O();
        O.h(null);
        O.f(false);
        O.h(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.troop.troopsetting.bizconfig.j
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                k.c0(k.this, compoundButton, z16);
            }
        });
        QUIListItemAdapter qUIListItemAdapter = this.adapter;
        if (qUIListItemAdapter != null) {
            qUIListItemAdapter.l0(this);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(k this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h0(z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private final boolean d0() {
        return ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).isStudyMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(k this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h0(z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private final void g0() {
        boolean z26 = this.viewModel.z2();
        this.viewModel.b4(new a.q(!z26));
        boolean z16 = false;
        if (!z26) {
            eu.g("Grp_set_new", "grpData_admin", "Grp_msg_exp", 0, 0, this.viewModel.T2().troopUin);
        }
        TroopSettingViewModel troopSettingViewModel = this.viewModel;
        if (!z26 && !troopSettingViewModel.Q2()) {
            z16 = true;
        }
        troopSettingViewModel.b4(new a.p(z16));
    }

    private final void h0(boolean isChecked) {
        AppInterface appInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface == null) {
            return;
        }
        this.viewModel.F3(isChecked);
        String troopUin = this.viewModel.S2().getTroopUin();
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            com.tencent.mobileqq.troop.troopsetting.activity.a.f301056a.g(this.activity, R.string.b3j, 1);
            e0();
        } else {
            if (b0(isChecked)) {
                return;
            }
            if (isChecked) {
                ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).hiddenChatShowGuideDialog(appInterface, this.activity);
            }
            ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).setGroupMsgMaskV2_4(troopUin, appInterface.getCurrentUid(), isChecked ? 1 : 0, 512, (int) NetConnInfoCenter.getServerTime(), null, null);
            g0();
            com.tencent.mobileqq.troop.troopsetting.report.c.f301449a.p(appInterface, isChecked, this.viewModel.T2().troopUin);
        }
    }

    public final void e0() {
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface == null) {
            return;
        }
        TroopInfo findTroopInfo = ((ITroopInfoService) appInterface.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(this.viewModel.T2().troopUin);
        if (findTroopInfo != null) {
            this.viewModel.R3(findTroopInfo);
        }
        long j3 = this.viewModel.S2().cmdUinFlagEx2;
        if (QLog.isColorLevel()) {
            QLog.d("TroopSettingPersonalAndOtherPart", 2, "mTroopInfo.mask=" + j3);
        }
        this.viewModel.F3(TroopInfo.isCmdUinFlagEx2Open(j3, 512));
        x.c.f O = O();
        O.h(null);
        O.f(this.viewModel.z2());
        g0();
        O.h(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.troop.troopsetting.bizconfig.g
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                k.f0(k.this, compoundButton, z16);
            }
        });
        QUIListItemAdapter qUIListItemAdapter = this.adapter;
        if (qUIListItemAdapter != null) {
            qUIListItemAdapter.l0(this);
        }
    }
}
