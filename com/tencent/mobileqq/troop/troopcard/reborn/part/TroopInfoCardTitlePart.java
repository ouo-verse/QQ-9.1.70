package com.tencent.mobileqq.troop.troopcard.reborn.part;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.api.ITroopShareApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel;
import com.tencent.mobileqq.troop.troopcard.utils.TroopCardDtHelper;
import com.tencent.mobileqq.troop.troopsetting.modules.jubao.TroopJuBaoUtils;
import com.tencent.mobileqq.troop.troopsetting.share.troopsetting.TroopSettingShareManager;
import com.tencent.mobileqq.troop.troopshare.tempapi.ITroopShareUtility;
import com.tencent.mobileqq.utils.TriggerRunnerKt;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u001c\u0010\t\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\"\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u001b\u00104\u001a\u00020/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/part/TroopInfoCardTitlePart;", "Lcom/tencent/biz/richframework/part/Part;", "", "E9", "I9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "onPartDestroy", "Lcom/tencent/common/app/AppInterface;", "d", "Lcom/tencent/common/app/AppInterface;", "getAppInterface", "()Lcom/tencent/common/app/AppInterface;", "appInterface", "e", "Landroid/view/View;", "immersiveTitleBar", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "navTitleTv", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "backBtn", "i", "moreBtn", "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopBasicInfoViewModel;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopBasicInfoViewModel;", "basicInfoViewModel", "Lcom/tencent/mobileqq/troop/troopshare/tempapi/ITroopShareUtility;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/troopshare/tempapi/ITroopShareUtility;", "troopShareUtil", "Lcom/tencent/mobileqq/troop/troopsetting/share/troopsetting/TroopSettingShareManager;", "D", "Lkotlin/Lazy;", "D9", "()Lcom/tencent/mobileqq/troop/troopsetting/share/troopsetting/TroopSettingShareManager;", "shareManager", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopInfoCardTitlePart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private ITroopShareUtility troopShareUtil;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy shareManager;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AppInterface appInterface;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View immersiveTitleBar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView navTitleTv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView backBtn;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView moreBtn;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TroopBasicInfoViewModel basicInfoViewModel;

    public TroopInfoCardTitlePart(@NotNull AppInterface appInterface) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
            return;
        }
        this.appInterface = appInterface;
        lazy = LazyKt__LazyJVMKt.lazy(TroopInfoCardTitlePart$shareManager$2.INSTANCE);
        this.shareManager = lazy;
    }

    private final TroopSettingShareManager D9() {
        return (TroopSettingShareManager) this.shareManager.getValue();
    }

    private final void E9() {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3 = this.backBtn;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backBtn");
            imageView = null;
        } else {
            imageView = imageView3;
        }
        TriggerRunnerKt.c(imageView, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.bh
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopInfoCardTitlePart.F9(TroopInfoCardTitlePart.this, view);
            }
        }, 1, null);
        ImageView imageView4 = this.moreBtn;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moreBtn");
            imageView2 = null;
        } else {
            imageView2 = imageView4;
        }
        TriggerRunnerKt.c(imageView2, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.bi
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopInfoCardTitlePart.G9(TroopInfoCardTitlePart.this, view);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(TroopInfoCardTitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(TroopInfoCardTitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void I9() {
        final QBaseActivity qBaseActivity;
        Bundle bundle;
        Intent intent;
        TroopBasicInfoViewModel troopBasicInfoViewModel = this.basicInfoViewModel;
        TroopInfoData troopInfoData = null;
        if (troopBasicInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
            troopBasicInfoViewModel = null;
        }
        final com.tencent.mobileqq.troop.data.v D2 = troopBasicInfoViewModel.D2();
        if (D2 == null) {
            return;
        }
        Activity activity = getActivity();
        if (activity instanceof QBaseActivity) {
            qBaseActivity = (QBaseActivity) activity;
        } else {
            qBaseActivity = null;
        }
        if (qBaseActivity == null) {
            return;
        }
        Dialog createDialog = ActionSheetHelper.createDialog(qBaseActivity, null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        if (!D2.i().isMember()) {
            actionSheet.addButton(new ActionMenuItem(qBaseActivity.getString(R.string.dsx), 9, 0), 5);
        }
        actionSheet.addButton(new ActionMenuItem(qBaseActivity.getString(R.string.h1u), 10, 0), 5);
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.bj
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                TroopInfoCardTitlePart.J9(ActionSheet.this, this, qBaseActivity, D2, view, i3);
            }
        });
        actionSheet.show();
        Activity activity2 = getActivity();
        if (activity2 != null && (intent = activity2.getIntent()) != null) {
            bundle = intent.getExtras();
        } else {
            bundle = null;
        }
        TroopBasicInfoViewModel troopBasicInfoViewModel2 = this.basicInfoViewModel;
        if (troopBasicInfoViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
            troopBasicInfoViewModel2 = null;
        }
        com.tencent.mobileqq.troop.data.v D22 = troopBasicInfoViewModel2.D2();
        if (D22 != null) {
            troopInfoData = com.tencent.mobileqq.troop.data.w.d(D22);
        }
        TroopCardDtHelper.b(actionSheet, bundle, troopInfoData, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(ActionSheet this_apply, TroopInfoCardTitlePart this$0, QBaseActivity qBaseActivity, com.tencent.mobileqq.troop.data.v troopInfoWrapper, View view, int i3) {
        Bundle arguments;
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(qBaseActivity, "$qBaseActivity");
        Intrinsics.checkNotNullParameter(troopInfoWrapper, "$troopInfoWrapper");
        ActionMenuItem actionMenuItem = this_apply.getActionMenuItem(i3);
        if (actionMenuItem == null) {
            return;
        }
        int i16 = actionMenuItem.action;
        if (i16 != 9) {
            if (i16 == 10) {
                Fragment hostFragment = this$0.getHostFragment();
                int i17 = -1;
                if (hostFragment != null && (arguments = hostFragment.getArguments()) != null) {
                    i17 = arguments.getInt("t_s_f", -1);
                }
                TroopJuBaoUtils.d(qBaseActivity, i17, troopInfoWrapper.i().getTroopUin(), troopInfoWrapper.i().isMember());
            }
        } else if (((ITroopShareApi) QRoute.api(ITroopShareApi.class)).useNewSharePanel("group_idcard")) {
            this$0.D9().F(new com.tencent.mobileqq.troop.troopsetting.share.b(qBaseActivity, com.tencent.mobileqq.troop.data.w.d(troopInfoWrapper)), "group_idcard");
        } else {
            ITroopShareUtility iTroopShareUtility = this$0.troopShareUtil;
            if (iTroopShareUtility == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopShareUtil");
                iTroopShareUtility = null;
            }
            com.tencent.mobileqq.troop.troopcard.reborn.ktx.a.b(iTroopShareUtility, qBaseActivity, this$0.appInterface, troopInfoWrapper);
        }
        this_apply.dismiss();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != 3 || resultCode != -1) {
            return;
        }
        ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).handleARKAppShareAction(this.appInterface, getActivity(), data);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.zmd);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.nav_title_layout)");
        this.immersiveTitleBar = findViewById;
        View findViewById2 = rootView.findViewById(R.id.f102925z8);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.troop_name_nav_tv)");
        this.navTitleTv = (TextView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.a47);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.back_btn)");
        ImageView imageView = (ImageView) findViewById3;
        this.backBtn = imageView;
        TroopBasicInfoViewModel troopBasicInfoViewModel = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backBtn");
            imageView = null;
        }
        imageView.setAccessibilityTraversalBefore(R.id.ezy);
        View findViewById4 = rootView.findViewById(R.id.ezy);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.more_btn)");
        ImageView imageView2 = (ImageView) findViewById4;
        this.moreBtn = imageView2;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moreBtn");
            imageView2 = null;
        }
        imageView2.setAccessibilityTraversalBefore(R.id.a38);
        E9();
        View view = this.immersiveTitleBar;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("immersiveTitleBar");
            view = null;
        }
        View view2 = this.immersiveTitleBar;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("immersiveTitleBar");
            view2 = null;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            marginLayoutParams.height = com.tencent.mobileqq.utils.am.a(44.0f) + ImmersiveUtils.getStatusBarHeight(rootView.getContext());
        } else {
            marginLayoutParams = null;
        }
        view.setLayoutParams(marginLayoutParams);
        View view3 = this.immersiveTitleBar;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("immersiveTitleBar");
            view3 = null;
        }
        view3.setPadding(com.tencent.mobileqq.utils.am.a(16.0f), ImmersiveUtils.getStatusBarHeight(rootView.getContext()), com.tencent.mobileqq.utils.am.a(16.0f), 0);
        TroopBasicInfoViewModel troopBasicInfoViewModel2 = this.basicInfoViewModel;
        if (troopBasicInfoViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
        } else {
            troopBasicInfoViewModel = troopBasicInfoViewModel2;
        }
        LiveData<String> I2 = troopBasicInfoViewModel.I2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardTitlePart$onInitView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopInfoCardTitlePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                TextView textView;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) str);
                    return;
                }
                textView = TroopInfoCardTitlePart.this.navTitleTv;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navTitleTv");
                    textView = null;
                }
                textView.setText(((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).getSpannableStringFromColorNickText(str, 16));
            }
        };
        I2.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.bg
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopInfoCardTitlePart.H9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        QRouteApi api = QRoute.api(ITroopShareUtility.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ITroopShareUtility::class.java)");
        this.troopShareUtil = (ITroopShareUtility) api;
        ViewModel viewModel = getViewModel(TroopBasicInfoViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(TroopBasicInfoViewModel::class.java)");
        this.basicInfoViewModel = (TroopBasicInfoViewModel) viewModel;
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        ITroopShareUtility iTroopShareUtility = this.troopShareUtil;
        if (iTroopShareUtility == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopShareUtil");
            iTroopShareUtility = null;
        }
        iTroopShareUtility.onDestroy();
    }
}
