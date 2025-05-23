package com.tenpay.idverify.guardian;

import android.text.method.DialerKeyListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.luggage.wxa.l6.o;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tenpay.api.MyKeyboardWindow;
import com.tenpay.api.QWalletUtils;
import com.tenpay.proxy.dlg.ScrollSelectDlg;
import com.tenpay.sdk.util.UIUtils;
import com.tenpay.sdk.view.ClearableEditText;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\fH\u0002J\u0006\u0010!\u001a\u00020\fJ6\u0010\"\u001a\u00020\u001f2\b\b\u0002\u0010#\u001a\u00020$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010(2\u0006\u0010)\u001a\u00020*J_\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020&2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010&2\u0006\u0010/\u001a\u00020$2\b\b\u0002\u0010#\u001a\u00020$2%\b\u0002\u00100\u001a\u001f\u0012\u0013\u0012\u00110&\u00a2\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u001f\u0018\u000101J_\u00104\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020&2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010&2\u0006\u0010/\u001a\u00020$2\b\b\u0002\u0010#\u001a\u00020$2%\b\u0002\u00100\u001a\u001f\u0012\u0013\u0012\u00110&\u00a2\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u001f\u0018\u000101J_\u00105\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020&2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010&2\u0006\u0010/\u001a\u00020$2\b\b\u0002\u0010#\u001a\u00020$2%\b\u0002\u00100\u001a\u001f\u0012\u0013\u0012\u00110&\u00a2\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u001f\u0018\u000101J\u000e\u00106\u001a\u00020\u001f2\u0006\u00107\u001a\u00020&J\u000e\u00108\u001a\u00020\u001f2\u0006\u00109\u001a\u00020&Jq\u0010:\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020&2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010&2\u0006\u0010/\u001a\u00020$2\u0010\b\u0002\u0010;\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010<2\b\b\u0002\u0010#\u001a\u00020$2%\b\u0002\u00100\u001a\u001f\u0012\u0013\u0012\u00110&\u00a2\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u001f\u0018\u000101R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n \u001b*\u0004\u0018\u00010\f0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006="}, d2 = {"Lcom/tenpay/idverify/guardian/GuardianInputChildVC;", "", "fragment", "Lcom/tencent/mobileqq/base/QWalletBaseFragment;", "(Lcom/tencent/mobileqq/base/QWalletBaseFragment;)V", "confirmBtn", "Landroid/widget/Button;", "getFragment", "()Lcom/tencent/mobileqq/base/QWalletBaseFragment;", "idCardContent", "Lcom/tenpay/sdk/view/ClearableEditText;", "idCardRoot", "Landroid/view/View;", "idCardTitle", "Landroid/widget/TextView;", "idTypeContent", "idTypeRoot", "idTypeTitle", "nameContent", "nameRoot", "nameTitle", "pageDesc", VasWebviewConstants.KEY_PAGE_TITLE, "roleContent", "roleRoot", "roleTitle", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "kotlin.jvm.PlatformType", "safeKeyboardWindow", "Lcom/tenpay/api/MyKeyboardWindow;", "clearOtherFocus", "", "currentView", "getRootView", "setConfirmBtn", NodeProps.VISIBLE, "", "btnDesc", "", "enableObservable", "Landroidx/lifecycle/LiveData;", "clickListener", "Landroid/view/View$OnClickListener;", "setIdCardItem", "title", "content", "hint", "changeable", "onTextChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "setIdTypeItem", "setNameItem", "setPageDesc", "pageDescText", o.NAME, "pageTitleText", "setRoleItem", "scrollData", "", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class GuardianInputChildVC {

    @NotNull
    private final Button confirmBtn;

    @NotNull
    private final QWalletBaseFragment fragment;

    @NotNull
    private final ClearableEditText idCardContent;

    @NotNull
    private final View idCardRoot;

    @NotNull
    private final TextView idCardTitle;

    @NotNull
    private final ClearableEditText idTypeContent;

    @NotNull
    private final View idTypeRoot;

    @NotNull
    private final TextView idTypeTitle;

    @NotNull
    private final ClearableEditText nameContent;

    @NotNull
    private final View nameRoot;

    @NotNull
    private final TextView nameTitle;

    @NotNull
    private final TextView pageDesc;

    @NotNull
    private final TextView pageTitle;

    @NotNull
    private final TextView roleContent;

    @NotNull
    private final View roleRoot;

    @NotNull
    private final TextView roleTitle;
    private final View rootView;

    @NotNull
    private final MyKeyboardWindow safeKeyboardWindow;

    public GuardianInputChildVC(@NotNull QWalletBaseFragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.fragment = fragment;
        View inflate = fragment.getLayoutInflater().inflate(R.layout.fyg, (ViewGroup) null, false);
        this.rootView = inflate;
        View findViewById = inflate.findViewById(R.id.vv_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.guardian_input_title)");
        this.pageTitle = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.vux);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.guardian_input_desc)");
        this.pageDesc = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.vv5);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026guardian_input_name_root)");
        this.nameRoot = findViewById3;
        View findViewById4 = inflate.findViewById(R.id.vv6);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026uardian_input_name_title)");
        this.nameTitle = (TextView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.f165413vv4);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.\u2026rdian_input_name_content)");
        this.nameContent = (ClearableEditText) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.f165411vv2);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.\u2026rdian_input_id_type_root)");
        this.idTypeRoot = findViewById6;
        View findViewById7 = inflate.findViewById(R.id.f165412vv3);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.\u2026dian_input_id_type_title)");
        this.idTypeTitle = (TextView) findViewById7;
        View findViewById8 = inflate.findViewById(R.id.f165410vv1);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "rootView.findViewById(R.\u2026an_input_id_type_content)");
        this.idTypeContent = (ClearableEditText) findViewById8;
        View findViewById9 = inflate.findViewById(R.id.vuz);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "rootView.findViewById(R.id.guardian_input_id_root)");
        this.idCardRoot = findViewById9;
        View findViewById10 = inflate.findViewById(R.id.f165409vv0);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "rootView.findViewById(R.\u2026.guardian_input_id_title)");
        this.idCardTitle = (TextView) findViewById10;
        View findViewById11 = inflate.findViewById(R.id.vuy);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "rootView.findViewById(R.\u2026uardian_input_id_content)");
        this.idCardContent = (ClearableEditText) findViewById11;
        View findViewById12 = inflate.findViewById(R.id.vv8);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "rootView.findViewById(R.\u2026guardian_input_role_root)");
        this.roleRoot = findViewById12;
        View findViewById13 = inflate.findViewById(R.id.vv9);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "rootView.findViewById(R.\u2026uardian_input_role_title)");
        this.roleTitle = (TextView) findViewById13;
        View findViewById14 = inflate.findViewById(R.id.vv7);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "rootView.findViewById(R.\u2026rdian_input_role_content)");
        this.roleContent = (TextView) findViewById14;
        View findViewById15 = inflate.findViewById(R.id.vuw);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "rootView.findViewById(R.\u2026ian_input_confirm_button)");
        this.confirmBtn = (Button) findViewById15;
        View findViewById16 = inflate.findViewById(R.id.vuv);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "rootView.findViewById(R.\u2026guardian_input__keyboard)");
        this.safeKeyboardWindow = (MyKeyboardWindow) findViewById16;
    }

    private final void clearOtherFocus(View currentView) {
        if (!Intrinsics.areEqual(this.nameContent, currentView)) {
            this.nameContent.clearFocus();
        }
        if (!Intrinsics.areEqual(this.idTypeContent, currentView)) {
            this.idTypeContent.clearFocus();
        }
        if (!Intrinsics.areEqual(this.idCardContent, currentView)) {
            this.idCardContent.clearFocus();
        }
        if (!Intrinsics.areEqual(this.roleContent, currentView)) {
            this.roleContent.clearFocus();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setConfirmBtn$default(GuardianInputChildVC guardianInputChildVC, boolean z16, String str, LiveData liveData, View.OnClickListener onClickListener, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        if ((i3 & 2) != 0) {
            str = null;
        }
        if ((i3 & 4) != 0) {
            liveData = null;
        }
        guardianInputChildVC.setConfirmBtn(z16, str, liveData, onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setConfirmBtn$lambda$14(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static /* synthetic */ void setIdCardItem$default(GuardianInputChildVC guardianInputChildVC, String str, String str2, String str3, boolean z16, boolean z17, Function1 function1, int i3, Object obj) {
        String str4;
        String str5;
        boolean z18;
        Function1 function12;
        if ((i3 & 2) != 0) {
            str4 = null;
        } else {
            str4 = str2;
        }
        if ((i3 & 4) != 0) {
            str5 = null;
        } else {
            str5 = str3;
        }
        if ((i3 & 16) != 0) {
            z18 = true;
        } else {
            z18 = z17;
        }
        if ((i3 & 32) != 0) {
            function12 = null;
        } else {
            function12 = function1;
        }
        guardianInputChildVC.setIdCardItem(str, str4, str5, z16, z18, function12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setIdCardItem$lambda$10(GuardianInputChildVC this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.idCardContent.clearFocus();
        view.performClick();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setIdCardItem$lambda$9$lambda$7$lambda$6(Function1 onTextChange, ClearableEditText it) {
        Intrinsics.checkNotNullParameter(onTextChange, "$onTextChange");
        Intrinsics.checkNotNullParameter(it, "$it");
        String obj = it.getText().toString();
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String upperCase = obj.toUpperCase(US);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        onTextChange.invoke(upperCase);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setIdCardItem$lambda$9$lambda$8(GuardianInputChildVC this$0, ClearableEditText it, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.clearOtherFocus(it);
        UIUtils.handleFocusChange(this$0.safeKeyboardWindow, view, z16, 1);
    }

    public static /* synthetic */ void setIdTypeItem$default(GuardianInputChildVC guardianInputChildVC, String str, String str2, String str3, boolean z16, boolean z17, Function1 function1, int i3, Object obj) {
        String str4;
        String str5;
        boolean z18;
        Function1 function12;
        if ((i3 & 2) != 0) {
            str4 = null;
        } else {
            str4 = str2;
        }
        if ((i3 & 4) != 0) {
            str5 = null;
        } else {
            str5 = str3;
        }
        if ((i3 & 16) != 0) {
            z18 = true;
        } else {
            z18 = z17;
        }
        if ((i3 & 32) != 0) {
            function12 = null;
        } else {
            function12 = function1;
        }
        guardianInputChildVC.setIdTypeItem(str, str4, str5, z16, z18, function12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setIdTypeItem$lambda$5$lambda$4$lambda$3(Function1 onTextChange, ClearableEditText it) {
        Intrinsics.checkNotNullParameter(onTextChange, "$onTextChange");
        Intrinsics.checkNotNullParameter(it, "$it");
        onTextChange.invoke(it.getText().toString());
    }

    public static /* synthetic */ void setNameItem$default(GuardianInputChildVC guardianInputChildVC, String str, String str2, String str3, boolean z16, boolean z17, Function1 function1, int i3, Object obj) {
        String str4;
        String str5;
        boolean z18;
        Function1 function12;
        if ((i3 & 2) != 0) {
            str4 = null;
        } else {
            str4 = str2;
        }
        if ((i3 & 4) != 0) {
            str5 = null;
        } else {
            str5 = str3;
        }
        if ((i3 & 16) != 0) {
            z18 = true;
        } else {
            z18 = z17;
        }
        if ((i3 & 32) != 0) {
            function12 = null;
        } else {
            function12 = function1;
        }
        guardianInputChildVC.setNameItem(str, str4, str5, z16, z18, function12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setNameItem$lambda$2$lambda$1$lambda$0(Function1 onTextChange, ClearableEditText it) {
        Intrinsics.checkNotNullParameter(onTextChange, "$onTextChange");
        Intrinsics.checkNotNullParameter(it, "$it");
        onTextChange.invoke(it.getText().toString());
    }

    public static /* synthetic */ void setRoleItem$default(GuardianInputChildVC guardianInputChildVC, String str, String str2, String str3, boolean z16, List list, boolean z17, Function1 function1, int i3, Object obj) {
        String str4;
        String str5;
        List list2;
        boolean z18;
        Function1 function12;
        if ((i3 & 2) != 0) {
            str4 = null;
        } else {
            str4 = str2;
        }
        if ((i3 & 4) != 0) {
            str5 = null;
        } else {
            str5 = str3;
        }
        if ((i3 & 16) != 0) {
            list2 = null;
        } else {
            list2 = list;
        }
        if ((i3 & 32) != 0) {
            z18 = true;
        } else {
            z18 = z17;
        }
        if ((i3 & 64) != 0) {
            function12 = null;
        } else {
            function12 = function1;
        }
        guardianInputChildVC.setRoleItem(str, str4, str5, z16, list2, z18, function12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setRoleItem$lambda$13$lambda$12(GuardianInputChildVC this$0, List list, final TextView roleContent, final Function1 function1, View clickView) {
        EventCollector.getInstance().onViewClickedBefore(clickView);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(roleContent, "$roleContent");
        Intrinsics.checkNotNullExpressionValue(clickView, "clickView");
        this$0.clearOtherFocus(clickView);
        ScrollSelectDlg.with(this$0.fragment.getContext()).appendColumn(list).setPickerListener(new ScrollSelectDlg.IPickerListener() { // from class: com.tenpay.idverify.guardian.d
            @Override // com.tenpay.proxy.dlg.ScrollSelectDlg.IPickerListener
            public final void onChoice(String str) {
                GuardianInputChildVC.setRoleItem$lambda$13$lambda$12$lambda$11(roleContent, function1, str);
            }
        }).show();
        EventCollector.getInstance().onViewClicked(clickView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setRoleItem$lambda$13$lambda$12$lambda$11(TextView roleContent, Function1 function1, String str) {
        Intrinsics.checkNotNullParameter(roleContent, "$roleContent");
        roleContent.setText(str);
        if (function1 != null) {
            function1.invoke(roleContent.getText().toString());
        }
    }

    @NotNull
    public final QWalletBaseFragment getFragment() {
        return this.fragment;
    }

    @NotNull
    public final View getRootView() {
        View rootView = this.rootView;
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        return rootView;
    }

    public final void setConfirmBtn(boolean visible, @Nullable String btnDesc, @Nullable LiveData<Boolean> enableObservable, @NotNull View.OnClickListener clickListener) {
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        if (!visible) {
            this.confirmBtn.setVisibility(8);
            return;
        }
        this.confirmBtn.setVisibility(0);
        this.confirmBtn.setText(btnDesc);
        this.confirmBtn.setOnClickListener(clickListener);
        if (enableObservable != null) {
            LifecycleOwner viewLifecycleOwner = this.fragment.getViewLifecycleOwner();
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tenpay.idverify.guardian.GuardianInputChildVC$setConfirmBtn$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean enable) {
                    Button button;
                    button = GuardianInputChildVC.this.confirmBtn;
                    Intrinsics.checkNotNullExpressionValue(enable, "enable");
                    button.setEnabled(enable.booleanValue());
                }
            };
            enableObservable.observe(viewLifecycleOwner, new Observer() { // from class: com.tenpay.idverify.guardian.c
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    GuardianInputChildVC.setConfirmBtn$lambda$14(Function1.this, obj);
                }
            });
        }
    }

    public final void setIdCardItem(@NotNull String title, @Nullable String content, @Nullable String hint, boolean changeable, boolean visible, @Nullable final Function1<? super String, Unit> onTextChange) {
        Intrinsics.checkNotNullParameter(title, "title");
        if (!visible) {
            this.idCardRoot.setVisibility(8);
            return;
        }
        this.idCardRoot.setVisibility(0);
        this.idCardTitle.setText(title);
        QWalletUtils.hideSysKeyBorad(this.idCardContent);
        final ClearableEditText clearableEditText = this.idCardContent;
        clearableEditText.setText(content);
        clearableEditText.setHint(hint);
        if (!changeable) {
            clearableEditText.setFocusable(false);
            clearableEditText.setFocusableInTouchMode(false);
            clearableEditText.setCursorVisible(false);
        } else {
            if (onTextChange != null) {
                clearableEditText.setOnTextChangedListener(new ClearableEditText.OnTextChangedListener() { // from class: com.tenpay.idverify.guardian.e
                    @Override // com.tenpay.sdk.view.ClearableEditText.OnTextChangedListener
                    public final void onTextChanged() {
                        GuardianInputChildVC.setIdCardItem$lambda$9$lambda$7$lambda$6(Function1.this, clearableEditText);
                    }
                });
            }
            clearableEditText.setKeyListener(new DialerKeyListener() { // from class: com.tenpay.idverify.guardian.GuardianInputChildVC$setIdCardItem$1$2
                @Override // android.text.method.DialerKeyListener, android.text.method.NumberKeyListener
                @NotNull
                protected char[] getAcceptedChars() {
                    return new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'x', 'X'};
                }

                @Override // android.text.method.DialerKeyListener, android.text.method.KeyListener
                public int getInputType() {
                    return 1;
                }
            });
            clearableEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tenpay.idverify.guardian.f
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z16) {
                    GuardianInputChildVC.setIdCardItem$lambda$9$lambda$8(GuardianInputChildVC.this, clearableEditText, view, z16);
                }
            });
        }
        this.rootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tenpay.idverify.guardian.g
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean idCardItem$lambda$10;
                idCardItem$lambda$10 = GuardianInputChildVC.setIdCardItem$lambda$10(GuardianInputChildVC.this, view, motionEvent);
                return idCardItem$lambda$10;
            }
        });
    }

    public final void setIdTypeItem(@NotNull String title, @Nullable String content, @Nullable String hint, boolean changeable, boolean visible, @Nullable final Function1<? super String, Unit> onTextChange) {
        Intrinsics.checkNotNullParameter(title, "title");
        if (!visible) {
            this.idTypeRoot.setVisibility(8);
            return;
        }
        this.idTypeRoot.setVisibility(0);
        this.idTypeTitle.setText(title);
        final ClearableEditText clearableEditText = this.idTypeContent;
        clearableEditText.setText(content);
        clearableEditText.setHint(hint);
        if (!changeable) {
            clearableEditText.setFocusable(false);
            clearableEditText.setFocusableInTouchMode(false);
            clearableEditText.setCursorVisible(false);
        } else if (onTextChange != null) {
            clearableEditText.setOnTextChangedListener(new ClearableEditText.OnTextChangedListener() { // from class: com.tenpay.idverify.guardian.b
                @Override // com.tenpay.sdk.view.ClearableEditText.OnTextChangedListener
                public final void onTextChanged() {
                    GuardianInputChildVC.setIdTypeItem$lambda$5$lambda$4$lambda$3(Function1.this, clearableEditText);
                }
            });
        }
    }

    public final void setNameItem(@NotNull String title, @Nullable String content, @Nullable String hint, boolean changeable, boolean visible, @Nullable final Function1<? super String, Unit> onTextChange) {
        Intrinsics.checkNotNullParameter(title, "title");
        if (!visible) {
            this.nameRoot.setVisibility(8);
            return;
        }
        this.nameRoot.setVisibility(0);
        this.nameTitle.setText(title);
        final ClearableEditText clearableEditText = this.nameContent;
        clearableEditText.setText(content);
        clearableEditText.setHint(hint);
        if (!changeable) {
            clearableEditText.setFocusable(false);
            clearableEditText.setFocusableInTouchMode(false);
            clearableEditText.setCursorVisible(false);
        } else if (onTextChange != null) {
            clearableEditText.setOnTextChangedListener(new ClearableEditText.OnTextChangedListener() { // from class: com.tenpay.idverify.guardian.a
                @Override // com.tenpay.sdk.view.ClearableEditText.OnTextChangedListener
                public final void onTextChanged() {
                    GuardianInputChildVC.setNameItem$lambda$2$lambda$1$lambda$0(Function1.this, clearableEditText);
                }
            });
        }
    }

    public final void setPageDesc(@NotNull String pageDescText) {
        Intrinsics.checkNotNullParameter(pageDescText, "pageDescText");
        this.pageDesc.setText(pageDescText);
        this.pageDesc.setVisibility(0);
    }

    public final void setPageTitle(@NotNull String pageTitleText) {
        Intrinsics.checkNotNullParameter(pageTitleText, "pageTitleText");
        this.pageTitle.setText(pageTitleText);
        this.pageTitle.setVisibility(0);
    }

    public final void setRoleItem(@NotNull String title, @Nullable String content, @Nullable String hint, boolean changeable, @Nullable final List<String> scrollData, boolean visible, @Nullable final Function1<? super String, Unit> onTextChange) {
        Intrinsics.checkNotNullParameter(title, "title");
        if (!visible) {
            this.roleRoot.setVisibility(8);
            return;
        }
        boolean z16 = false;
        this.roleRoot.setVisibility(0);
        this.roleTitle.setText(title);
        final TextView textView = this.roleContent;
        textView.setText(content);
        textView.setHint(hint);
        if (changeable) {
            if (scrollData != null && !scrollData.isEmpty()) {
                z16 = true;
            }
            if (z16) {
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.idverify.guardian.h
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        GuardianInputChildVC.setRoleItem$lambda$13$lambda$12(GuardianInputChildVC.this, scrollData, textView, onTextChange, view);
                    }
                });
            }
        }
    }
}
