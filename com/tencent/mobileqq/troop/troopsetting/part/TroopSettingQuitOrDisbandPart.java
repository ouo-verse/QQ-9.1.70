package com.tencent.mobileqq.troop.troopsetting.part;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopsetting.event.a;
import com.tencent.mobileqq.troop.troopsetting.vm.TroopSettingViewModel;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.eu;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.ActionSheet;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 (2\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\u001a\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\u0012\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0015\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u001b\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\"\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/part/TroopSettingQuitOrDisbandPart;", "Lcom/tencent/mobileqq/troop/troopsetting/part/h;", "", "R9", "U9", "da", "aa", "ha", "", "holdMsg", "X9", "Q9", "", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "W9", "V9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "G9", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "requestCode", "onActivityResult", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "e", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "quitBtn", "Lcom/tencent/mobileqq/troop/troopsetting/customconfig/b;", "f", "Lcom/tencent/mobileqq/troop/troopsetting/customconfig/b;", "quitConfig", "<init>", "()V", tl.h.F, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSettingQuitOrDisbandPart extends h {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QUIButton quitBtn;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.troop.troopsetting.customconfig.b<View> quitConfig;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/part/TroopSettingQuitOrDisbandPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsetting.part.TroopSettingQuitOrDisbandPart$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60888);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopSettingQuitOrDisbandPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void Q9() {
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new TroopSettingQuitOrDisbandPart$initObserver$1(this, null), 3, null);
    }

    private final void R9() {
        View btnWrapper = View.inflate(getActivity(), R.layout.h6t, null);
        Intrinsics.checkNotNullExpressionValue(btnWrapper, "btnWrapper");
        com.tencent.mobileqq.troop.troopsetting.customconfig.b<View> bVar = new com.tencent.mobileqq.troop.troopsetting.customconfig.b<>(btnWrapper);
        this.quitConfig = bVar;
        bVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.troop.troopsetting.part.bw
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                TroopSettingQuitOrDisbandPart.S9(view);
            }
        });
        View findViewById = btnWrapper.findViewById(R.id.f66713bd);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type com.tencent.biz.qui.quibutton.QUIButton");
        QUIButton qUIButton = (QUIButton) findViewById;
        this.quitBtn = qUIButton;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quitBtn");
            qUIButton = null;
        }
        QUIListItemBackgroundType qUIListItemBackgroundType = QUIListItemBackgroundType.AllRound;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        qUIButton.setBackground(qUIListItemBackgroundType.getBackground(context, 1000));
        QUIButton qUIButton2 = this.quitBtn;
        if (qUIButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quitBtn");
            qUIButton2 = null;
        }
        ViewGroup.LayoutParams layoutParams = qUIButton2.getLayoutParams();
        layoutParams.height = getContext().getResources().getDimensionPixelSize(R.dimen.dar);
        QUIButton qUIButton3 = this.quitBtn;
        if (qUIButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quitBtn");
            qUIButton3 = null;
        }
        qUIButton3.setLayoutParams(layoutParams);
        final TroopInfoData T2 = B9().T2();
        if (T2.bOwner) {
            QUIButton qUIButton4 = this.quitBtn;
            if (qUIButton4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("quitBtn");
                qUIButton4 = null;
            }
            qUIButton4.setText(R.string.arx);
        } else {
            QUIButton qUIButton5 = this.quitBtn;
            if (qUIButton5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("quitBtn");
                qUIButton5 = null;
            }
            qUIButton5.setText(R.string.g3n);
        }
        QUIButton qUIButton6 = this.quitBtn;
        if (qUIButton6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quitBtn");
            qUIButton6 = null;
        }
        qUIButton6.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.bx
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopSettingQuitOrDisbandPart.T9(TroopSettingQuitOrDisbandPart.this, T2, view);
            }
        });
        com.tencent.mobileqq.troop.troopsetting.report.c cVar = com.tencent.mobileqq.troop.troopsetting.report.c.f301449a;
        QUIButton qUIButton7 = this.quitBtn;
        if (qUIButton7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quitBtn");
            qUIButton7 = null;
        }
        cVar.A(qUIButton7, "em_group_quit", B9().T2(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.setBackground(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(TroopSettingQuitOrDisbandPart this$0, TroopInfoData mTroopInfoData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mTroopInfoData, "$mTroopInfoData");
        this$0.U9();
        eu.g("Grp_set_new", "grpData_admin", "clk_quitgrp", 0, 0, mTroopInfoData.troopUin, eu.c(mTroopInfoData));
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void U9() {
        String str;
        TroopInfoData T2 = B9().T2();
        if (QLog.isColorLevel()) {
            QLog.d("TroopQuitOrDisbandPart", 2, "ChatSettingForTroop quitTroop mTroopInfoData.bOwner = " + T2.bOwner);
        }
        IRuntimeService runtimeService = z9().getRuntimeService(ITroopInfoService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026va, ProcessConstant.MAIN)");
        TroopSettingViewModel B9 = B9();
        TroopInfo findTroopInfo = ((ITroopInfoService) runtimeService).findTroopInfo(T2.troopUin);
        if (findTroopInfo == null) {
            findTroopInfo = new TroopInfo(T2.troopUin);
        }
        B9.R3(findTroopInfo);
        if (T2.bOwner) {
            if ((T2.dwGroupFlagExt & 2048) != 0) {
                aa();
            } else {
                ha();
            }
        } else {
            da();
        }
        if (T2.bOwner) {
            str = "0";
        } else if (T2.bAdmin) {
            str = "1";
        } else {
            str = "2";
        }
        com.tencent.mobileqq.troop.troopsetting.report.c cVar = com.tencent.mobileqq.troop.troopsetting.report.c.f301449a;
        AppInterface z95 = z9();
        String str2 = T2.troopUin;
        Intrinsics.checkNotNullExpressionValue(str2, "mTroopInfoData.troopUin");
        cVar.c(z95, "dc00899", "Grp_set", "", "Grp_data", "Clk_quitgrp", 0, 0, str2, str, "", "");
    }

    private final void V9() {
        B9().m4();
        B9().b4(a.w.f301136a);
    }

    private final void W9(int resultCode, Intent data) {
        if (resultCode == -1 && data != null) {
            boolean booleanExtra = data.getBooleanExtra(AppConstants.Key.IS_NEED_FINISH, false);
            String stringExtra = data.getStringExtra(AppConstants.Key.FIN_TIP_MSG);
            String stringExtra2 = data.getStringExtra("uin");
            if (QLog.isColorLevel()) {
                QLog.i(LogTag.TROOP_DISBAND, 2, "ChatSettingActivity|onActivityResult|REQUEST_FOR_TROOP_DISBAND|isNeedFinish = " + booleanExtra + ", strTip = " + stringExtra);
            }
            if (!TextUtils.isEmpty(stringExtra) && booleanExtra) {
                com.tencent.mobileqq.troop.troopsetting.activity.a aVar = com.tencent.mobileqq.troop.troopsetting.activity.a.f301056a;
                Activity activity = getActivity();
                if (stringExtra == null) {
                    stringExtra = "";
                }
                aVar.j(activity, 5, stringExtra, 1000);
                return;
            }
            if (!TextUtils.isEmpty(stringExtra)) {
                if (!TextUtils.isEmpty(stringExtra2)) {
                    B9().T2().updateTroopOwner(stringExtra2, z9().getCurrentAccountUin());
                }
                V9();
                B9().p2();
                Context context = getContext();
                if (stringExtra == null) {
                    stringExtra = "";
                }
                QQToast.makeText(context, 2, stringExtra, 0).show();
                return;
            }
            if (booleanExtra) {
                Intent intent = new Intent();
                intent.putExtra(AppConstants.Key.IS_NEED_FINISH, true);
                getActivity().setResult(-1, intent);
                com.tencent.mobileqq.troop.troopsetting.activity.a aVar2 = com.tencent.mobileqq.troop.troopsetting.activity.a.f301056a;
                Activity activity2 = getActivity();
                Intrinsics.checkNotNullExpressionValue(activity2, "activity");
                aVar2.h(activity2);
            }
        }
    }

    private final void X9(final boolean holdMsg) {
        final ArrayList<String> arrayList = new ArrayList<>();
        String string = getContext().getResources().getString(R.string.a8r);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026ng.confirm_disband_troop)");
        final ActionSheet create = ActionSheet.create(getContext());
        create.setMainTitle(string);
        String string2 = getContext().getResources().getString(R.string.a8q);
        Intrinsics.checkNotNullExpressionValue(string2, "context.resources.getStr\u2026R.string.confirm_disband)");
        create.addButton(string2, 3);
        final String string3 = getContext().getResources().getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string3, "context.resources.getStr\u2026eqq.qqui.R.string.cancel)");
        create.addCancelButton(string3);
        arrayList.add(string2);
        arrayList.add(string3);
        create.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.cb
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                TroopSettingQuitOrDisbandPart.Y9(TroopSettingQuitOrDisbandPart.this, holdMsg, arrayList, create, view, i3);
            }
        });
        create.setOnBottomCancelListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.cc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopSettingQuitOrDisbandPart.Z9(TroopSettingQuitOrDisbandPart.this, string3, create, view);
            }
        });
        create.show();
        ReportController.o(null, "CliOper", "", "", "Grp", "Clk_dismiss_grp", 0, 0, "", "", "", "");
        com.tencent.mobileqq.troop.troopsetting.report.c.f301449a.h(z9(), B9().T2(), arrayList, "dissolve");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(TroopSettingQuitOrDisbandPart this$0, boolean z16, ArrayList reportTabNames, ActionSheet actionSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reportTabNames, "$reportTabNames");
        if (i3 == 0 && !com.tencent.mobileqq.troop.trooptodo.a.a("TroopQuitOrDisbandPart showDisbandDialog")) {
            if (NetworkUtil.isNetSupport(this$0.getContext())) {
                this$0.B9().r2(z16, i.a(this$0));
            } else {
                com.tencent.mobileqq.troop.troopsetting.activity.a aVar = com.tencent.mobileqq.troop.troopsetting.activity.a.f301056a;
                Activity activity = this$0.getActivity();
                String string = this$0.getContext().getResources().getString(R.string.cjm);
                Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026o_net_pls_tryagain_later)");
                aVar.j(activity, 2, string, 1500);
            }
            com.tencent.mobileqq.troop.troopsetting.report.c cVar = com.tencent.mobileqq.troop.troopsetting.report.c.f301449a;
            cVar.c(this$0.z9(), "CliOper", "", "", "Grp", "Dismiss_grp_OK", 0, 0, "", "", "", "");
            cVar.g(this$0.z9(), this$0.B9().T2(), (String) reportTabNames.get(i3), "dissolve");
            actionSheet.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(TroopSettingQuitOrDisbandPart this$0, String cancelMsg, ActionSheet actionSheet, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cancelMsg, "$cancelMsg");
        com.tencent.mobileqq.troop.troopsetting.report.c.f301449a.g(this$0.z9(), this$0.B9().T2(), cancelMsg, "dissolve");
        actionSheet.cancel();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void aa() {
        if (QLog.isColorLevel()) {
            QLog.d("TroopQuitOrDisbandPart", 2, "ChatSettingForTroop showDisbandTroopAlertWindow");
        }
        final ReportDialog reportDialog = new ReportDialog(getActivity(), R.style.qZoneInputDialog);
        reportDialog.setContentView(R.layout.atf);
        View findViewById = reportDialog.findViewById(R.id.bkh);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById).setVisibility(8);
        View findViewById2 = reportDialog.findViewById(R.id.bk8);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById2;
        View findViewById3 = reportDialog.findViewById(R.id.bk5);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView2 = (TextView) findViewById3;
        View findViewById4 = reportDialog.findViewById(R.id.bka);
        Intrinsics.checkNotNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView3 = (TextView) findViewById4;
        String qqStr = HardCodeUtil.qqStr(R.string.kgz);
        textView.setText(getContext().getResources().getString(R.string.a8s, qqStr, qqStr));
        textView.setGravity(8388611);
        textView2.setText(R.string.f171151ok);
        textView3.setText(R.string.cancel);
        reportDialog.setCanceledOnTouchOutside(false);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.cd
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopSettingQuitOrDisbandPart.ba(reportDialog, this, view);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.ce
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopSettingQuitOrDisbandPart.ca(reportDialog, view);
            }
        });
        try {
            reportDialog.show();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ba(Dialog dialog, TroopSettingQuitOrDisbandPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (dialog.isShowing() && dialog.getWindow() != null) {
            dialog.dismiss();
        }
        this$0.ha();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ca(Dialog dialog, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        if (dialog.isShowing() && dialog.getWindow() != null) {
            dialog.dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void da() {
        final ActionSheet create = ActionSheet.create(getContext());
        create.setMainTitle(R.string.a8y);
        final ArrayList<String> arrayList = new ArrayList<>();
        String string = getContext().getResources().getString(R.string.f170901b10);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026ileqq.qqui.R.string.exit)");
        arrayList.add(string);
        create.addButton(string);
        String string2 = getContext().getResources().getString(R.string.f23232749);
        Intrinsics.checkNotNullExpressionValue(string2, "context.resources.getStr\u2026quit_troop_and_clear_msg)");
        create.addButton(string2, 3);
        arrayList.add(string2);
        create.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.bz
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                TroopSettingQuitOrDisbandPart.ea(TroopSettingQuitOrDisbandPart.this, arrayList, create, view, i3);
            }
        });
        final String string3 = getContext().getResources().getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string3, "context.resources.getStr\u2026eqq.qqui.R.string.cancel)");
        create.addCancelButton(string3);
        create.setOnBottomCancelListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.ca
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopSettingQuitOrDisbandPart.ga(TroopSettingQuitOrDisbandPart.this, string3, create, view);
            }
        });
        arrayList.add(string3);
        create.show();
        com.tencent.mobileqq.troop.troopsetting.report.c.f301449a.h(z9(), B9().T2(), arrayList, "exit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ea(TroopSettingQuitOrDisbandPart this$0, ArrayList reportTabNames, ActionSheet actionSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reportTabNames, "$reportTabNames");
        if (this$0.C9()) {
            return;
        }
        boolean z16 = true;
        if (i3 == 0 || i3 == 1) {
            if (NetworkUtil.isNetSupport(this$0.z9().getApp().getApplicationContext())) {
                com.tencent.mobileqq.troop.troopsetting.activity.a aVar = com.tencent.mobileqq.troop.troopsetting.activity.a.f301056a;
                Activity activity = this$0.getActivity();
                String string = this$0.getContext().getResources().getString(R.string.b1b);
                Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026pi.R.string.exit_loading)");
                aVar.j(activity, 0, string, 0);
                TroopSettingViewModel B9 = this$0.B9();
                if (i3 != 0) {
                    z16 = false;
                }
                B9.z3(z16, i.a(this$0));
            } else {
                com.tencent.mobileqq.troop.troopsetting.activity.a aVar2 = com.tencent.mobileqq.troop.troopsetting.activity.a.f301056a;
                Activity activity2 = this$0.getActivity();
                String string2 = this$0.getContext().getResources().getString(R.string.cjm);
                Intrinsics.checkNotNullExpressionValue(string2, "context.resources.getStr\u2026o_net_pls_tryagain_later)");
                aVar2.j(activity2, 2, string2, 1500);
            }
            com.tencent.mobileqq.troop.troopsetting.report.c cVar = com.tencent.mobileqq.troop.troopsetting.report.c.f301449a;
            cVar.c(this$0.z9(), "CliOper", "", "", "Grp", "Dismiss_grp_OK", 0, 0, "", "", "", "");
            cVar.g(this$0.z9(), this$0.B9().T2(), (String) reportTabNames.get(i3), "exit");
            actionSheet.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ga(TroopSettingQuitOrDisbandPart this$0, String cancelMsg, ActionSheet actionSheet, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cancelMsg, "$cancelMsg");
        com.tencent.mobileqq.troop.troopsetting.report.c.f301449a.g(this$0.z9(), this$0.B9().T2(), cancelMsg, "exit");
        actionSheet.cancel();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void ha() {
        X9(true);
    }

    @Override // com.tencent.mobileqq.troop.troopsetting.part.h
    @NotNull
    public Group[] G9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Group[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        com.tencent.mobileqq.troop.troopsetting.customconfig.b<View> bVar = this.quitConfig;
        if (bVar != null) {
            return new Group[]{new Group(bVar)};
        }
        return new Group[0];
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 4 || requestCode == 8) {
            W9(resultCode, data);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        Q9();
        R9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
            com.tencent.mobileqq.troop.troopsetting.activity.a.f301056a.a();
        }
    }
}
