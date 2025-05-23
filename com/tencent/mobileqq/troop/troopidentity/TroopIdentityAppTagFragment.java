package com.tencent.mobileqq.troop.troopidentity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.troopidentity.util.TroopIdentityHonorUtil;
import com.tencent.mobileqq.troop.troopidentity.view.c;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.kernel.nativeinterface.GroupIdentityAppTag;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 22\u00020\u0001:\u00013B\u0007\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u001c\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u001c\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001c\u001a\u00020\u0019H\u0016R\u0016\u0010\u001f\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0016\u0010+\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010\"R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/TroopIdentityAppTagFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "yh", "Bh", "initNavBar", "Landroid/view/View$OnClickListener;", "uh", OcrConfig.CHINESE, "Lcom/tencent/qqnt/kernel/nativeinterface/GroupIdentityAppTag;", "data", "", "", "", "xh", "wh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "", "onBackEvent", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "needImmersive", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/widget/ImageView;", "D", "Landroid/widget/ImageView;", "appIconIv", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "appIconInfoTv", UserInfo.SEX_FEMALE, "wearStatusTv", "G", "wearIconIv", "Lcom/tencent/mobileqq/troop/troopidentity/TroopIdentityAppIconVM;", "H", "Lcom/tencent/mobileqq/troop/troopidentity/TroopIdentityAppIconVM;", "viewModel", "<init>", "()V", "I", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopIdentityAppTagFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView appIconIv;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView appIconInfoTv;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView wearStatusTv;

    /* renamed from: G, reason: from kotlin metadata */
    private ImageView wearIconIv;

    /* renamed from: H, reason: from kotlin metadata */
    private TroopIdentityAppIconVM viewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J.\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/TroopIdentityAppTagFragment$a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "troopUin", "memberUin", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupIdentityAppTag;", "appIconInfo", "", "requestCode", "", "a", "IDENTITY_APP_ICON_INFO", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopidentity.TroopIdentityAppTagFragment$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        public final void a(@NotNull Activity activity, @NotNull String troopUin, @NotNull String memberUin, @NotNull GroupIdentityAppTag appIconInfo, int requestCode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, activity, troopUin, memberUin, appIconInfo, Integer.valueOf(requestCode));
                return;
            }
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            Intrinsics.checkNotNullParameter(memberUin, "memberUin");
            Intrinsics.checkNotNullParameter(appIconInfo, "appIconInfo");
            Intent intent = new Intent();
            intent.putExtra("troop_uin", troopUin);
            intent.putExtra("member_uin", memberUin);
            intent.putExtra("identity_app_icon_info", appIconInfo);
            QPublicFragmentActivity.startForResult(activity, intent, (Class<? extends QPublicBaseFragment>) TroopIdentityAppTagFragment.class, requestCode);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/troop/troopidentity/TroopIdentityAppTagFragment$b", "Lcom/tencent/mobileqq/troop/troopidentity/dialog/a;", "", "isSelected", "", "onSelected", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements com.tencent.mobileqq.troop.troopidentity.dialog.a {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GroupIdentityAppTag f300320b;

        b(GroupIdentityAppTag groupIdentityAppTag) {
            this.f300320b = groupIdentityAppTag;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopIdentityAppTagFragment.this, (Object) groupIdentityAppTag);
            }
        }

        @Override // com.tencent.mobileqq.troop.troopidentity.dialog.a
        public void onSelected(boolean isSelected) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                TroopIdentityAppIconVM troopIdentityAppIconVM = TroopIdentityAppTagFragment.this.viewModel;
                TroopIdentityAppIconVM troopIdentityAppIconVM2 = null;
                if (troopIdentityAppIconVM == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    troopIdentityAppIconVM = null;
                }
                troopIdentityAppIconVM.U1(isSelected);
                TroopIdentityAppIconVM troopIdentityAppIconVM3 = TroopIdentityAppTagFragment.this.viewModel;
                if (troopIdentityAppIconVM3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    troopIdentityAppIconVM2 = troopIdentityAppIconVM3;
                }
                troopIdentityAppIconVM2.Q1().b("em_group_app_identity_pop", TroopIdentityAppTagFragment.this.wh(this.f300320b));
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, isSelected);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57687);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopIdentityAppTagFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ah(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Bh() {
        int i3;
        TroopIdentityAppIconVM troopIdentityAppIconVM = this.viewModel;
        TroopIdentityAppIconVM troopIdentityAppIconVM2 = null;
        if (troopIdentityAppIconVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            troopIdentityAppIconVM = null;
        }
        GroupIdentityAppTag P1 = troopIdentityAppIconVM.P1();
        if (P1 == null) {
            return;
        }
        TroopIdentityHonorUtil troopIdentityHonorUtil = TroopIdentityHonorUtil.f300410a;
        ImageView imageView = this.appIconIv;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appIconIv");
            imageView = null;
        }
        troopIdentityHonorUtil.i(imageView, P1.icon);
        TextView textView = this.appIconInfoTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appIconInfoTv");
            textView = null;
        }
        textView.setText(P1.name);
        TextView textView2 = this.wearStatusTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("wearStatusTv");
            textView2 = null;
        }
        int i16 = 0;
        if (P1.status) {
            i3 = 0;
        } else {
            i3 = 4;
        }
        textView2.setVisibility(i3);
        ImageView imageView2 = this.wearIconIv;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("wearIconIv");
            imageView2 = null;
        }
        if (!P1.status) {
            i16 = 4;
        }
        imageView2.setVisibility(i16);
        ImageView imageView3 = this.wearIconIv;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("wearIconIv");
            imageView3 = null;
        }
        troopIdentityHonorUtil.i(imageView3, "https://downv6.qq.com/extendfriend/mutual_tag_peidai.png");
        TroopIdentityAppIconVM troopIdentityAppIconVM3 = this.viewModel;
        if (troopIdentityAppIconVM3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            troopIdentityAppIconVM2 = troopIdentityAppIconVM3;
        }
        troopIdentityAppIconVM2.Q1().d("em_group_app_nteract_logo", xh(P1));
    }

    private final void initNavBar() {
        View view = this.rootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        QUISecNavBar qUISecNavBar = (QUISecNavBar) view.findViewById(R.id.jo9);
        qUISecNavBar.setOnBaseTitleBarClickListener(new Function2<View, BaseAction, Unit>() { // from class: com.tencent.mobileqq.troop.troopidentity.TroopIdentityAppTagFragment$initNavBar$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopIdentityAppTagFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view2, BaseAction baseAction) {
                invoke2(view2, baseAction);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View view2, @NotNull BaseAction baseAction) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view2, (Object) baseAction);
                    return;
                }
                Intrinsics.checkNotNullParameter(view2, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(baseAction, "baseAction");
                if (baseAction == BaseAction.ACTION_LEFT_BUTTON) {
                    TroopIdentityAppTagFragment.this.onBackEvent();
                }
            }
        });
        FragmentActivity activity = getActivity();
        if (activity != null) {
            qUISecNavBar.R(activity);
        }
        qUISecNavBar.findViewById(R.id.f81564ei).setAlpha(0.0f);
    }

    private final View.OnClickListener uh() {
        return new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopidentity.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopIdentityAppTagFragment.vh(TroopIdentityAppTagFragment.this, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vh(TroopIdentityAppTagFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        if (context != null) {
            TroopIdentityAppIconVM troopIdentityAppIconVM = this$0.viewModel;
            TroopIdentityAppIconVM troopIdentityAppIconVM2 = null;
            if (troopIdentityAppIconVM == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                troopIdentityAppIconVM = null;
            }
            GroupIdentityAppTag P1 = troopIdentityAppIconVM.P1();
            if (P1 != null) {
                String str = P1.appTagId;
                Intrinsics.checkNotNullExpressionValue(str, "appIconInfo.appTagId");
                String str2 = P1.name;
                Intrinsics.checkNotNullExpressionValue(str2, "appIconInfo.name");
                String str3 = P1.icon;
                Intrinsics.checkNotNullExpressionValue(str3, "appIconInfo.icon");
                com.tencent.mobileqq.troop.troopidentity.dialog.b bVar = new com.tencent.mobileqq.troop.troopidentity.dialog.b(str, str2, str3, "", true, P1.status);
                TroopIdentityAppIconVM troopIdentityAppIconVM3 = this$0.viewModel;
                if (troopIdentityAppIconVM3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    troopIdentityAppIconVM3 = null;
                }
                new com.tencent.mobileqq.troop.troopidentity.dialog.h(context, troopIdentityAppIconVM3.S1(), bVar, new b(P1)).show();
                TroopIdentityAppIconVM troopIdentityAppIconVM4 = this$0.viewModel;
                if (troopIdentityAppIconVM4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    troopIdentityAppIconVM4 = null;
                }
                troopIdentityAppIconVM4.Q1().d("em_group_app_identity_pop", this$0.wh(P1));
                TroopIdentityAppIconVM troopIdentityAppIconVM5 = this$0.viewModel;
                if (troopIdentityAppIconVM5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    troopIdentityAppIconVM2 = troopIdentityAppIconVM5;
                }
                troopIdentityAppIconVM2.Q1().b("em_group_app_nteract_logo", this$0.xh(P1));
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> wh(GroupIdentityAppTag data) {
        Map<String, Object> mapOf;
        int i3 = 2;
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("group_app_id", data.appTagId);
        if (!data.status) {
            i3 = 1;
        }
        pairArr[1] = TuplesKt.to("group_btn_type", Integer.valueOf(i3));
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        return mapOf;
    }

    private final Map<String, Object> xh(GroupIdentityAppTag data) {
        Map<String, Object> mapOf;
        int i3 = 2;
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("group_app_id", data.appTagId);
        if (data.status) {
            i3 = 1;
        }
        pairArr[1] = TuplesKt.to("group_identity_situa", Integer.valueOf(i3));
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        return mapOf;
    }

    private final void yh() {
        View view = this.rootView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        View findViewById = view.findViewById(R.id.f164379vi);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.app_icon)");
        this.appIconIv = (ImageView) findViewById;
        View view3 = this.rootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view3 = null;
        }
        View findViewById2 = view3.findViewById(R.id.f165727xe1);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.icon_info_tv)");
        this.appIconInfoTv = (TextView) findViewById2;
        View view4 = this.rootView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view4 = null;
        }
        View findViewById3 = view4.findViewById(R.id.f120757_e);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.wear_status_tv)");
        this.wearStatusTv = (TextView) findViewById3;
        View view5 = this.rootView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view5 = null;
        }
        View findViewById4 = view5.findViewById(R.id.f120747_d);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.wear_icon)");
        this.wearIconIv = (ImageView) findViewById4;
        View view6 = this.rootView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view6 = null;
        }
        ((ConstraintLayout) view6.findViewById(R.id.stl)).setOnClickListener(uh());
        Context context = getContext();
        if (context != null) {
            View view7 = this.rootView;
            if (view7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            } else {
                view2 = view7;
            }
            ((ConstraintLayout) view2.findViewById(R.id.ste)).setBackground(QUIListItemBackgroundType.AllRound.getBackground(context, 1000));
        }
    }

    private final void zh() {
        TroopIdentityAppIconVM troopIdentityAppIconVM = this.viewModel;
        if (troopIdentityAppIconVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            troopIdentityAppIconVM = null;
        }
        LiveData<com.tencent.mobileqq.troop.troopidentity.view.c> T1 = troopIdentityAppIconVM.T1();
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        final Function1<com.tencent.mobileqq.troop.troopidentity.view.c, Unit> function1 = new Function1<com.tencent.mobileqq.troop.troopidentity.view.c, Unit>() { // from class: com.tencent.mobileqq.troop.troopidentity.TroopIdentityAppTagFragment$initObserver$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopIdentityAppTagFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.troopidentity.view.c cVar) {
                invoke2(cVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.troop.troopidentity.view.c cVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
                } else if (cVar instanceof c.a) {
                    TroopIdentityAppTagFragment.this.Bh();
                }
            }
        };
        T1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.troopidentity.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopIdentityAppTagFragment.Ah(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        Bundle bundle = new Bundle();
        Intent intent = new Intent();
        TroopIdentityAppIconVM troopIdentityAppIconVM = this.viewModel;
        if (troopIdentityAppIconVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            troopIdentityAppIconVM = null;
        }
        bundle.putSerializable("identity_app_icon_info", troopIdentityAppIconVM.P1());
        intent.putExtras(bundle);
        FragmentKt.setFragmentResult(this, "identity_app_icon_info", bundle);
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null) {
            qBaseActivity.setResult(-1, intent);
        }
        QBaseActivity qBaseActivity2 = getQBaseActivity();
        if (qBaseActivity2 != null) {
            qBaseActivity2.finish();
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        ViewModel viewModel = getViewModel(TroopIdentityAppIconVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(TroopIdentityAppIconVM::class.java)");
        TroopIdentityAppIconVM troopIdentityAppIconVM = (TroopIdentityAppIconVM) viewModel;
        this.viewModel = troopIdentityAppIconVM;
        if (troopIdentityAppIconVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            troopIdentityAppIconVM = null;
        }
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        troopIdentityAppIconVM.init(arguments);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            view = (View) iPatchRedirector.redirect((short) 3, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            View inflate = inflater.inflate(R.layout.hzf, container, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026layout, container, false)");
            this.rootView = inflate;
            initNavBar();
            yh();
            Bh();
            zh();
            TroopIdentityAppIconVM troopIdentityAppIconVM = this.viewModel;
            if (troopIdentityAppIconVM == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                troopIdentityAppIconVM = null;
            }
            troopIdentityAppIconVM.Q1().f(true);
            view = this.rootView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                view = null;
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onDestroy();
        TroopIdentityAppIconVM troopIdentityAppIconVM = this.viewModel;
        TroopIdentityAppIconVM troopIdentityAppIconVM2 = null;
        if (troopIdentityAppIconVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            troopIdentityAppIconVM = null;
        }
        troopIdentityAppIconVM.onDestroy();
        TroopIdentityAppIconVM troopIdentityAppIconVM3 = this.viewModel;
        if (troopIdentityAppIconVM3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            troopIdentityAppIconVM2 = troopIdentityAppIconVM3;
        }
        troopIdentityAppIconVM2.Q1().f(false);
    }
}
