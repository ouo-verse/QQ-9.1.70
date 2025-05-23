package com.tencent.mobileqq.troop.troopsetting.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.api.ITroopShareApi;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingFragmentV2;
import com.tencent.mobileqq.troop.troopsetting.share.troopsetting.TroopSettingShareManager;
import com.tencent.mobileqq.troop.troopsetting.vm.TroopSettingViewModel;
import com.tencent.mobileqq.troop.troopshare.tempapi.ITroopShareUtility;
import com.tencent.mobileqq.utils.eu;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/part/TroopSettingTitlePart;", "Lcom/tencent/mobileqq/troop/troopsetting/part/h;", "", "N9", "M9", "L9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartDestroy", "", "onBackEvent", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "e", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "navbar", "Lcom/tencent/biz/qui/quisecnavbar/a;", "f", "Lcom/tencent/biz/qui/quisecnavbar/a;", "shareActionBtn", "Lcom/tencent/mobileqq/troop/troopsetting/share/troopsetting/TroopSettingShareManager;", tl.h.F, "Lkotlin/Lazy;", "K9", "()Lcom/tencent/mobileqq/troop/troopsetting/share/troopsetting/TroopSettingShareManager;", "shareManager", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSettingTitlePart extends h {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QUISecNavBar navbar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.biz.qui.quisecnavbar.a shareActionBtn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy shareManager;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/troop/troopsetting/part/TroopSettingTitlePart$a", "Lcom/tencent/biz/qui/quisecnavbar/a;", "", "b", "Landroid/view/View;", "view", "", "a", "", "getDrawable", "()I", "drawable", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a extends com.tencent.biz.qui.quisecnavbar.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSettingTitlePart.this);
            }
        }

        @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
        public void a(@Nullable View view) {
            QBaseActivity qBaseActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
                return;
            }
            if (!((ITroopShareApi) QRoute.api(ITroopShareApi.class)).useNewSharePanel("group_idcard") || !(TroopSettingTitlePart.this.getActivity() instanceof QBaseActivity)) {
                TroopSettingTitlePart.this.M9();
                return;
            }
            Activity activity = TroopSettingTitlePart.this.getActivity();
            if (activity instanceof QBaseActivity) {
                qBaseActivity = (QBaseActivity) activity;
            } else {
                qBaseActivity = null;
            }
            if (qBaseActivity == null) {
                return;
            }
            TroopSettingTitlePart.this.K9().F(new com.tencent.mobileqq.troop.troopsetting.share.b(qBaseActivity, TroopSettingTitlePart.this.B9().T2()), "group_idcard");
        }

        @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
        @NotNull
        public String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            String string = TroopSettingTitlePart.this.getContext().getString(R.string.iqy);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.te\u2026ng.info_card_share_troop)");
            return string;
        }

        @Override // com.tencent.biz.qui.quisecnavbar.b
        public int getDrawable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return R.drawable.qui_share_icon_nav_secondary;
        }
    }

    public TroopSettingTitlePart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(TroopSettingTitlePart$shareManager$2.INSTANCE);
            this.shareManager = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopSettingShareManager K9() {
        return (TroopSettingShareManager) this.shareManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L9() {
        Boolean bool;
        TroopSettingViewModel B9 = B9();
        Bundle arguments = getPartHost().getArguments();
        if (arguments != null) {
            bool = Boolean.valueOf(arguments.getBoolean("from_newer_guide", false));
        } else {
            bool = null;
        }
        if (B9.H2() == null && Intrinsics.areEqual(bool, Boolean.TRUE)) {
            B9.L3(new Intent());
            Intent H2 = B9.H2();
            if (H2 != null) {
                H2.putExtra("uin", B9.T2().troopUin);
            }
        }
        Intent H22 = B9().H2();
        if (B9().E2()) {
            if (H22 == null) {
                H22 = new Intent();
            }
            H22.putExtra("KEY_SHOULD_SHOW_KEYBOARD", true);
            B9().J3(false);
        }
        getActivity().setResult(-1, H22);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M9() {
        String str;
        String str2;
        ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).troopShareUtilityDestroy();
        B9().T2().userFrom = "pg_group_set";
        Bundle bundle = new Bundle();
        bundle.putBoolean(ITroopShareUtility.START_ACTIVITY_BY_FTAGMENT, true);
        IChatSettingForTroopApi iChatSettingForTroopApi = (IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class);
        Activity activity = getActivity();
        TroopSettingFragmentV2 partHost = getPartHost();
        if (!(partHost instanceof QBaseFragment)) {
            partHost = null;
        }
        iChatSettingForTroopApi.initTroopShareUtility(activity, partHost, B9().T2(), MobileQQ.sMobileQQ.peekAppRuntime(), bundle);
        eu.g("Grp_set_new", "grpData_admin", "share_click", 0, 0, B9().T2().troopUin);
        if (B9().T2().isMember) {
            str = "grpData_admin";
        } else {
            str = "grpData_visitor";
        }
        String str3 = str;
        String[] strArr = new String[2];
        strArr[0] = B9().T2().troopUin;
        if (B9().T2().isMember) {
            str2 = eu.c(B9().T2());
        } else {
            str2 = "0";
        }
        strArr[1] = str2;
        eu.g("Grp_set_new", str3, "clk_upright", 0, 0, strArr);
    }

    private final void N9() {
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new TroopSettingTitlePart$initObserver$1(this, null), 3, null);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        L9();
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.jo9);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.title_bar)");
        this.navbar = (QUISecNavBar) findViewById;
        this.shareActionBtn = new a();
        QUISecNavBar qUISecNavBar = this.navbar;
        com.tencent.biz.qui.quisecnavbar.a aVar = null;
        if (qUISecNavBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navbar");
            qUISecNavBar = null;
        }
        qUISecNavBar.setAutoAdaptTransparent(true);
        qUISecNavBar.setBaseViewDescription(BaseAction.ACTION_CENTER_TEXT, B9().T2().newTroopName + " " + qUISecNavBar.getContext().getString(R.string.im5));
        com.tencent.biz.qui.quisecnavbar.a aVar2 = this.shareActionBtn;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareActionBtn");
            aVar2 = null;
        }
        qUISecNavBar.d(aVar2);
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        qUISecNavBar.R(activity);
        qUISecNavBar.setOnBaseTitleBarClickListener(new Function2<View, BaseAction, Unit>() { // from class: com.tencent.mobileqq.troop.troopsetting.part.TroopSettingTitlePart$onInitView$2$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSettingTitlePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, BaseAction baseAction) {
                invoke2(view, baseAction);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view, @Nullable BaseAction baseAction) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view, (Object) baseAction);
                } else if (baseAction == BaseAction.ACTION_LEFT_BUTTON) {
                    TroopSettingTitlePart.this.L9();
                    ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).popBack(TroopSettingTitlePart.this.getActivity());
                }
            }
        });
        N9();
        eu.g("Grp_set_new", "grpData_admin", "share_exp", 0, 0, B9().T2().troopUin);
        QUISecNavBar qUISecNavBar2 = this.navbar;
        if (qUISecNavBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navbar");
            qUISecNavBar2 = null;
        }
        com.tencent.biz.qui.quisecnavbar.a aVar3 = this.shareActionBtn;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareActionBtn");
        } else {
            aVar = aVar3;
        }
        View h16 = qUISecNavBar2.h(aVar);
        if (h16 != null) {
            com.tencent.mobileqq.troop.troopsetting.report.c.f301449a.B(h16, "em_group_share_entrance", null, ExposurePolicy.REPORT_NONE, ClickPolicy.REPORT_ALL, EndExposurePolicy.REPORT_NONE, B9().T2());
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
            ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).troopShareUtilityDestroy();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        Window window;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            return;
        }
        super.onPartResume(activity);
        if (activity != null) {
            window = activity.getWindow();
        } else {
            window = null;
        }
        ImmersiveUtils.setStatusTextColorNew(false, window);
    }
}
