package com.tenpay.form;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.method.DialerKeyListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.FragmentActivity;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.QQToastUtil;
import com.tenpay.api.MyKeyboardWindow;
import com.tenpay.idverify.model.IdVerifyAddressBean;
import com.tenpay.lcation.LocationInputFragment;
import com.tenpay.proxy.dlg.ScrollSelectDlg;
import com.tenpay.proxy.dlg.age.AgeSelDlg;
import com.tenpay.sdk.activity.JobSelectionActivity;
import com.tenpay.sdk.util.UIUtils;
import com.tenpay.sdk.view.ClearableEditText;
import com.tenpay.util.Utils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0005H\u0002J\u0006\u0010+\u001a\u00020\u0005J\b\u0010,\u001a\u00020)H\u0002JM\u0010-\u001a\u00020)2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\b\b\u0002\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012%\b\u0002\u00103\u001a\u001f\u0012\u0013\u0012\u00110/\u00a2\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020)\u0018\u000104H\u0007J7\u00107\u001a\u00020)2\b\b\u0002\u00100\u001a\u0002012%\b\u0002\u00108\u001a\u001f\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020)\u0018\u000104JS\u0010:\u001a\u00020)2\u0006\u0010;\u001a\u0002012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\b\b\u0002\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012%\b\u0002\u00103\u001a\u001f\u0012\u0013\u0012\u00110/\u00a2\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020)\u0018\u000104JW\u0010<\u001a\u00020)2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010/2\b\b\u0002\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012%\b\u0002\u00103\u001a\u001f\u0012\u0013\u0012\u00110/\u00a2\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020)\u0018\u000104J(\u0010>\u001a\u00020)2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010/2\b\b\u0002\u00100\u001a\u000201JC\u0010?\u001a\u00020)2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\b\b\u0002\u00100\u001a\u0002012%\b\u0002\u00108\u001a\u001f\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020)\u0018\u000104JW\u0010@\u001a\u00020)2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010/2\b\b\u0002\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012%\b\u0002\u00103\u001a\u001f\u0012\u0013\u0012\u00110/\u00a2\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020)\u0018\u000104JK\u0010A\u001a\u00020)2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\b\b\u0002\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012%\b\u0002\u00103\u001a\u001f\u0012\u0013\u0012\u00110/\u00a2\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020)\u0018\u000104JW\u0010B\u001a\u00020)2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010/2\b\b\u0002\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012%\b\u0002\u00103\u001a\u001f\u0012\u0013\u0012\u00110/\u00a2\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020)\u0018\u000104J\u001e\u0010C\u001a\u00020)2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010/2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010/J\u0010\u0010F\u001a\u0002012\b\u0010G\u001a\u0004\u0018\u00010/R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n \u001a*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006H"}, d2 = {"Lcom/tenpay/form/QWalletBaseIdFormVC;", "", "fragment", "Lcom/tencent/mobileqq/base/QWalletBaseFragment;", "contentView", "Landroid/view/View;", "(Lcom/tencent/mobileqq/base/QWalletBaseFragment;Landroid/view/View;)V", "addressArrow", "Landroid/widget/ImageView;", "addressContent", "Landroid/widget/TextView;", "addressRoot", "confirmBtn", "Landroid/widget/Button;", "dateBeginArrow", "dateBeginContent", "dateBeginRoot", "dateEndArrow", "dateEndContent", "dateEndRoot", "idContent", "Lcom/tenpay/sdk/view/ClearableEditText;", "idRoot", "idTypeContent", "idTypeRoot", "idVerifyInfoRoot", "kotlin.jvm.PlatformType", "linkTextBtn", "nameContent", "nameRoot", "professionArrow", "professionContent", "professionRoot", "safeKeyboard", "Lcom/tenpay/api/MyKeyboardWindow;", "sexArrow", "sexContent", "sexRoot", "subTitleView", "titleView", "clearOtherFocus", "", "currentView", "getInfoRootView", "hideKeyBoard", "setAddressData", "content", "", NodeProps.VISIBLE, "", "changeable", "onTextChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "setConfirmBtnDate", NodeProps.ON_CLICK, "view", "setDate", "isBeginTime", "setIdData", "hint", "setIdTypeData", "setLinkTextDate", "setNameData", "setProfessionDate", "setSexData", "setTitle", "title", QQWinkConstants.TAB_SUBTITLE, "validateId", "idNum", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@SuppressLint({"ClickableViewAccessibility"})
/* loaded from: classes27.dex */
public final class QWalletBaseIdFormVC {

    @NotNull
    private final ImageView addressArrow;

    @NotNull
    private final TextView addressContent;

    @NotNull
    private final View addressRoot;

    @NotNull
    private final Button confirmBtn;

    @NotNull
    private final ImageView dateBeginArrow;

    @NotNull
    private final TextView dateBeginContent;

    @NotNull
    private final View dateBeginRoot;

    @NotNull
    private final ImageView dateEndArrow;

    @NotNull
    private final TextView dateEndContent;

    @NotNull
    private final View dateEndRoot;

    @NotNull
    private final QWalletBaseFragment fragment;

    @NotNull
    private final ClearableEditText idContent;

    @NotNull
    private final View idRoot;

    @NotNull
    private final TextView idTypeContent;

    @NotNull
    private final View idTypeRoot;
    private final View idVerifyInfoRoot;

    @NotNull
    private final TextView linkTextBtn;

    @NotNull
    private final ClearableEditText nameContent;

    @NotNull
    private final View nameRoot;

    @NotNull
    private final ImageView professionArrow;

    @NotNull
    private final TextView professionContent;

    @NotNull
    private final View professionRoot;

    @NotNull
    private MyKeyboardWindow safeKeyboard;

    @NotNull
    private final ImageView sexArrow;

    @NotNull
    private final TextView sexContent;

    @NotNull
    private final View sexRoot;

    @NotNull
    private final TextView subTitleView;

    @NotNull
    private final TextView titleView;

    public QWalletBaseIdFormVC(@NotNull QWalletBaseFragment fragment, @NotNull View contentView) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        this.fragment = fragment;
        View findViewById = contentView.findViewById(R.id.xgm);
        this.idVerifyInfoRoot = findViewById;
        View findViewById2 = contentView.findViewById(R.id.xgs);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "contentView.findViewById\u2026.id.id_verify_info_title)");
        this.titleView = (TextView) findViewById2;
        View findViewById3 = contentView.findViewById(R.id.xgr);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "contentView.findViewById\u2026id_verify_info_sub_title)");
        this.subTitleView = (TextView) findViewById3;
        View findViewById4 = contentView.findViewById(R.id.xgg);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "contentView.findViewById\u2026id_verify_info_name_root)");
        this.nameRoot = findViewById4;
        View findViewById5 = contentView.findViewById(R.id.xgf);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "contentView.findViewById\u2026verify_info_name_content)");
        this.nameContent = (ClearableEditText) findViewById5;
        View findViewById6 = contentView.findViewById(R.id.xgd);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "contentView.findViewById\u2026verify_info_id_type_root)");
        this.idTypeRoot = findViewById6;
        View findViewById7 = contentView.findViewById(R.id.xgc);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "contentView.findViewById\u2026ify_info_id_type_content)");
        this.idTypeContent = (TextView) findViewById7;
        View findViewById8 = contentView.findViewById(R.id.xga);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "contentView.findViewById\u2026d.id_verify_info_id_root)");
        this.idRoot = findViewById8;
        View findViewById9 = contentView.findViewById(R.id.xg_);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "contentView.findViewById\u2026d_verify_info_id_content)");
        this.idContent = (ClearableEditText) findViewById9;
        View findViewById10 = contentView.findViewById(R.id.xgp);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "contentView.findViewById\u2026.id_verify_info_sex_root)");
        this.sexRoot = findViewById10;
        View findViewById11 = contentView.findViewById(R.id.xgo);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "contentView.findViewById\u2026_verify_info_sex_content)");
        this.sexContent = (TextView) findViewById11;
        View findViewById12 = contentView.findViewById(R.id.xgn);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "contentView.findViewById\u2026id_verify_info_sex_arrow)");
        this.sexArrow = (ImageView) findViewById12;
        View findViewById13 = contentView.findViewById(R.id.f165744xg4);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "contentView.findViewById\u2026ify_info_date_begin_root)");
        this.dateBeginRoot = findViewById13;
        View findViewById14 = contentView.findViewById(R.id.f165743xg3);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "contentView.findViewById\u2026_info_date_begin_content)");
        this.dateBeginContent = (TextView) findViewById14;
        View findViewById15 = contentView.findViewById(R.id.f165742xg2);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "contentView.findViewById\u2026fy_info_date_begin_arrow)");
        this.dateBeginArrow = (ImageView) findViewById15;
        View findViewById16 = contentView.findViewById(R.id.xg8);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "contentView.findViewById\u2026erify_info_date_end_root)");
        this.dateEndRoot = findViewById16;
        View findViewById17 = contentView.findViewById(R.id.xg7);
        Intrinsics.checkNotNullExpressionValue(findViewById17, "contentView.findViewById\u2026fy_info_date_end_content)");
        this.dateEndContent = (TextView) findViewById17;
        View findViewById18 = contentView.findViewById(R.id.xg6);
        Intrinsics.checkNotNullExpressionValue(findViewById18, "contentView.findViewById\u2026rify_info_date_end_arrow)");
        this.dateEndArrow = (ImageView) findViewById18;
        View findViewById19 = contentView.findViewById(R.id.xgk);
        Intrinsics.checkNotNullExpressionValue(findViewById19, "contentView.findViewById\u2026ify_info_profession_root)");
        this.professionRoot = findViewById19;
        View findViewById20 = contentView.findViewById(R.id.xgj);
        Intrinsics.checkNotNullExpressionValue(findViewById20, "contentView.findViewById\u2026_info_profession_content)");
        this.professionContent = (TextView) findViewById20;
        View findViewById21 = contentView.findViewById(R.id.xgi);
        Intrinsics.checkNotNullExpressionValue(findViewById21, "contentView.findViewById\u2026fy_info_profession_arrow)");
        this.professionArrow = (ImageView) findViewById21;
        View findViewById22 = contentView.findViewById(R.id.xfz);
        Intrinsics.checkNotNullExpressionValue(findViewById22, "contentView.findViewById\u2026verify_info_address_root)");
        this.addressRoot = findViewById22;
        View findViewById23 = contentView.findViewById(R.id.xfy);
        Intrinsics.checkNotNullExpressionValue(findViewById23, "contentView.findViewById\u2026ify_info_address_content)");
        this.addressContent = (TextView) findViewById23;
        View findViewById24 = contentView.findViewById(R.id.xfx);
        Intrinsics.checkNotNullExpressionValue(findViewById24, "contentView.findViewById\u2026erify_info_address_arrow)");
        this.addressArrow = (ImageView) findViewById24;
        View findViewById25 = contentView.findViewById(R.id.f165741xg1);
        Intrinsics.checkNotNullExpressionValue(findViewById25, "contentView.findViewById\u2026_verify_info_btn_confirm)");
        this.confirmBtn = (Button) findViewById25;
        View findViewById26 = contentView.findViewById(R.id.xf7);
        Intrinsics.checkNotNullExpressionValue(findViewById26, "contentView.findViewById\u2026id_form_bottom_link_text)");
        this.linkTextBtn = (TextView) findViewById26;
        View findViewById27 = contentView.findViewById(R.id.xf6);
        Intrinsics.checkNotNullExpressionValue(findViewById27, "contentView.findViewById\u2026.id_form_bottom_keyboard)");
        this.safeKeyboard = (MyKeyboardWindow) findViewById27;
        contentView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tenpay.form.h
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean _init_$lambda$0;
                _init_$lambda$0 = QWalletBaseIdFormVC._init_$lambda$0(QWalletBaseIdFormVC.this, view, motionEvent);
                return _init_$lambda$0;
            }
        });
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.form.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QWalletBaseIdFormVC._init_$lambda$1(QWalletBaseIdFormVC.this, view);
            }
        });
    }

    public static final boolean _init_$lambda$0(QWalletBaseIdFormVC this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hideKeyBoard();
        return false;
    }

    public static final void _init_$lambda$1(QWalletBaseIdFormVC this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hideKeyBoard();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void clearOtherFocus(View currentView) {
        if (!Intrinsics.areEqual(this.nameContent, currentView)) {
            this.nameContent.clearFocus();
        }
        if (!Intrinsics.areEqual(this.idTypeContent, currentView)) {
            this.idTypeContent.clearFocus();
        }
        if (!Intrinsics.areEqual(this.idContent, currentView)) {
            this.idContent.clearFocus();
        }
    }

    private final void hideKeyBoard() {
        Object obj;
        InputMethodManager inputMethodManager;
        Context context = this.fragment.getContext();
        IBinder iBinder = null;
        if (context != null) {
            obj = context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        } else {
            obj = null;
        }
        if (obj instanceof InputMethodManager) {
            inputMethodManager = (InputMethodManager) obj;
        } else {
            inputMethodManager = null;
        }
        if (inputMethodManager == null) {
            return;
        }
        View currentFocus = this.fragment.requireActivity().getWindow().getCurrentFocus();
        if (currentFocus != null) {
            iBinder = currentFocus.getWindowToken();
        }
        if (iBinder == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(iBinder, 0);
        this.safeKeyboard.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setAddressData$default(QWalletBaseIdFormVC qWalletBaseIdFormVC, String str, boolean z16, boolean z17, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        if ((i3 & 8) != 0) {
            function1 = null;
        }
        qWalletBaseIdFormVC.setAddressData(str, z16, z17, function1);
    }

    public static final void setAddressData$lambda$23$lambda$22(final QWalletBaseIdFormVC this$0, final Function1 function1, View view) {
        final IdVerifyAddressBean idVerifyAddressBean;
        String str;
        String str2;
        String str3;
        String str4;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object tag = this$0.addressContent.getTag();
        ActivityResultLauncher activityResultLauncher = null;
        if (tag instanceof IdVerifyAddressBean) {
            idVerifyAddressBean = (IdVerifyAddressBean) tag;
        } else {
            idVerifyAddressBean = null;
        }
        Intent intent = new Intent();
        intent.setClass(this$0.fragment.requireContext(), LocationInputFragment.class);
        if (idVerifyAddressBean != null) {
            str = idVerifyAddressBean.getProvince();
        } else {
            str = null;
        }
        intent.putExtra(LocationInputFragment.KEY_ADDRESS_PROVINCE, str);
        if (idVerifyAddressBean != null) {
            str2 = idVerifyAddressBean.getCity();
        } else {
            str2 = null;
        }
        intent.putExtra(LocationInputFragment.KEY_ADDRESS_CITY, str2);
        if (idVerifyAddressBean != null) {
            str3 = idVerifyAddressBean.getDistrict();
        } else {
            str3 = null;
        }
        intent.putExtra(LocationInputFragment.KEY_ADDRESS_DISTRICT, str3);
        if (idVerifyAddressBean != null) {
            str4 = idVerifyAddressBean.getDetailAddress();
        } else {
            str4 = null;
        }
        intent.putExtra(LocationInputFragment.KEY_DETAIL_ADDRESS, str4);
        FragmentActivity activity = this$0.fragment.getActivity();
        if (activity != null) {
            activityResultLauncher = activity.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.tenpay.form.o
                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(Object obj) {
                    QWalletBaseIdFormVC.setAddressData$lambda$23$lambda$22$lambda$21(IdVerifyAddressBean.this, this$0, function1, (ActivityResult) obj);
                }
            });
        }
        if (activityResultLauncher != null) {
            activityResultLauncher.launch(intent);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public static final void setAddressData$lambda$23$lambda$22$lambda$21(IdVerifyAddressBean idVerifyAddressBean, QWalletBaseIdFormVC this$0, Function1 function1, ActivityResult activityResult) {
        Intent data;
        String str;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (activityResult.getResultCode() != -1 || (data = activityResult.getData()) == null) {
            return;
        }
        String stringExtra = data.getStringExtra(LocationInputFragment.KEY_ADDRESS_PROVINCE);
        String stringExtra2 = data.getStringExtra(LocationInputFragment.KEY_ADDRESS_CITY);
        String stringExtra3 = data.getStringExtra(LocationInputFragment.KEY_ADDRESS_DISTRICT);
        String stringExtra4 = data.getStringExtra(LocationInputFragment.KEY_DETAIL_ADDRESS);
        String str4 = "";
        if (idVerifyAddressBean != null) {
            if (stringExtra == null) {
                str3 = "";
            } else {
                str3 = stringExtra;
            }
            idVerifyAddressBean.setProvince(str3);
        }
        if (idVerifyAddressBean != null) {
            if (stringExtra2 == null) {
                str2 = "";
            } else {
                str2 = stringExtra2;
            }
            idVerifyAddressBean.setCity(str2);
        }
        if (idVerifyAddressBean != null) {
            if (stringExtra3 == null) {
                str = "";
            } else {
                str = stringExtra3;
            }
            idVerifyAddressBean.setDistrict(str);
        }
        if (idVerifyAddressBean != null) {
            if (stringExtra4 != null) {
                str4 = stringExtra4;
            }
            idVerifyAddressBean.setDetailAddress(str4);
        }
        this$0.addressContent.setText(stringExtra + " " + stringExtra2 + " " + stringExtra3 + " " + stringExtra4);
        if (function1 != null) {
            function1.invoke(this$0.addressContent.getText().toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setConfirmBtnDate$default(QWalletBaseIdFormVC qWalletBaseIdFormVC, boolean z16, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        if ((i3 & 2) != 0) {
            function1 = null;
        }
        qWalletBaseIdFormVC.setConfirmBtnDate(z16, function1);
    }

    public static final void setConfirmBtnDate$lambda$24(Function1 function1, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        function1.invoke(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    public static /* synthetic */ void setDate$default(QWalletBaseIdFormVC qWalletBaseIdFormVC, boolean z16, String str, boolean z17, boolean z18, Function1 function1, int i3, Object obj) {
        String str2;
        Function1 function12;
        if ((i3 & 2) != 0) {
            str2 = null;
        } else {
            str2 = str;
        }
        if ((i3 & 4) != 0) {
            z17 = true;
        }
        boolean z19 = z17;
        if ((i3 & 16) != 0) {
            function12 = null;
        } else {
            function12 = function1;
        }
        qWalletBaseIdFormVC.setDate(z16, str2, z19, z18, function12);
    }

    public static final void setDate$lambda$15$lambda$14(QWalletBaseIdFormVC this$0, boolean z16, final TextView contentView, final Function1 function1, View clickView) {
        EventCollector.getInstance().onViewClickedBefore(clickView);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(contentView, "$contentView");
        Intrinsics.checkNotNullExpressionValue(clickView, "clickView");
        this$0.clearOtherFocus(clickView);
        AgeSelDlg ageSelDlg = new AgeSelDlg(this$0.fragment.getContext(), z16);
        ageSelDlg.setOnDateSelectListener(new AgeSelDlg.OnDateSelectListener() { // from class: com.tenpay.form.QWalletBaseIdFormVC$setDate$1$1$1
            @Override // com.tenpay.proxy.dlg.age.AgeSelDlg.OnDateSelectListener
            public void dateSelectListener(int year, int month, int day) {
                String formatDate;
                TextView textView = contentView;
                if (year == 9999) {
                    formatDate = AgeSelDlg.LONG_YEAR_TXT;
                } else {
                    formatDate = Utils.formatDate(year, month, day);
                }
                textView.setText(formatDate);
                Function1<String, Unit> function12 = function1;
                if (function12 != null) {
                    function12.invoke(contentView.getText().toString());
                }
            }

            @Override // com.tenpay.proxy.dlg.age.AgeSelDlg.OnDateSelectListener
            public void dateSelectNotValid() {
                contentView.setText((CharSequence) null);
                Function1<String, Unit> function12 = function1;
                if (function12 != null) {
                    function12.invoke("");
                }
            }
        });
        ageSelDlg.popupPickerView(R.id.f163936cz, contentView.getText().toString());
        EventCollector.getInstance().onViewClicked(clickView);
    }

    public static /* synthetic */ void setIdData$default(QWalletBaseIdFormVC qWalletBaseIdFormVC, String str, String str2, boolean z16, boolean z17, Function1 function1, int i3, Object obj) {
        String str3;
        String str4;
        Function1 function12;
        if ((i3 & 1) != 0) {
            str3 = null;
        } else {
            str3 = str;
        }
        if ((i3 & 2) != 0) {
            str4 = null;
        } else {
            str4 = str2;
        }
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        boolean z18 = z16;
        if ((i3 & 16) != 0) {
            function12 = null;
        } else {
            function12 = function1;
        }
        qWalletBaseIdFormVC.setIdData(str3, str4, z18, z17, function12);
    }

    public static final void setIdData$lambda$13$lambda$10(QWalletBaseIdFormVC this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UIUtils.handleFocusChange(this$0.safeKeyboard, view, true, 1);
        EventCollector.getInstance().onViewClicked(view);
    }

    public static final void setIdData$lambda$13$lambda$12$lambda$11(ClearableEditText it, QWalletBaseIdFormVC this$0, Function1 onTextChange) {
        boolean z16;
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(onTextChange, "$onTextChange");
        String obj = it.getText().toString();
        Button button = this$0.confirmBtn;
        if (obj.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        button.setEnabled(z16);
        onTextChange.invoke(obj);
    }

    public static final void setIdData$lambda$13$lambda$9(QWalletBaseIdFormVC this$0, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UIUtils.handleFocusChange(this$0.safeKeyboard, view, z16, 1);
    }

    public static /* synthetic */ void setIdTypeData$default(QWalletBaseIdFormVC qWalletBaseIdFormVC, String str, String str2, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        if ((i3 & 2) != 0) {
            str2 = null;
        }
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        qWalletBaseIdFormVC.setIdTypeData(str, str2, z16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setLinkTextDate$default(QWalletBaseIdFormVC qWalletBaseIdFormVC, String str, boolean z16, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        if ((i3 & 4) != 0) {
            function1 = null;
        }
        qWalletBaseIdFormVC.setLinkTextDate(str, z16, function1);
    }

    public static final void setLinkTextDate$lambda$25(Function1 function1, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        function1.invoke(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    public static /* synthetic */ void setNameData$default(QWalletBaseIdFormVC qWalletBaseIdFormVC, String str, String str2, boolean z16, boolean z17, Function1 function1, int i3, Object obj) {
        String str3;
        String str4;
        Function1 function12;
        if ((i3 & 1) != 0) {
            str3 = null;
        } else {
            str3 = str;
        }
        if ((i3 & 2) != 0) {
            str4 = null;
        } else {
            str4 = str2;
        }
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        boolean z18 = z16;
        if ((i3 & 16) != 0) {
            function12 = null;
        } else {
            function12 = function1;
        }
        qWalletBaseIdFormVC.setNameData(str3, str4, z18, z17, function12);
    }

    public static final void setNameData$lambda$4$lambda$3$lambda$2(Function1 onTextChange, ClearableEditText it) {
        Intrinsics.checkNotNullParameter(onTextChange, "$onTextChange");
        Intrinsics.checkNotNullParameter(it, "$it");
        onTextChange.invoke(it.getText().toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setProfessionDate$default(QWalletBaseIdFormVC qWalletBaseIdFormVC, String str, boolean z16, boolean z17, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        if ((i3 & 8) != 0) {
            function1 = null;
        }
        qWalletBaseIdFormVC.setProfessionDate(str, z16, z17, function1);
    }

    public static final void setProfessionDate$lambda$19$lambda$18(QWalletBaseIdFormVC this$0, final Function1 function1, View view) {
        ActivityResultLauncher activityResultLauncher;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CharSequence text = this$0.professionContent.getText();
        Intent intent = new Intent();
        intent.setClass(this$0.fragment.requireContext(), JobSelectionActivity.class);
        intent.putExtra(JobSelectionActivity.PARAM_SELECTED_JOB, text);
        FragmentActivity activity = this$0.fragment.getActivity();
        if (activity != null) {
            activityResultLauncher = activity.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.tenpay.form.f
                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(Object obj) {
                    QWalletBaseIdFormVC.setProfessionDate$lambda$19$lambda$18$lambda$17(QWalletBaseIdFormVC.this, function1, (ActivityResult) obj);
                }
            });
        } else {
            activityResultLauncher = null;
        }
        if (activityResultLauncher != null) {
            activityResultLauncher.launch(intent);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public static final void setProfessionDate$lambda$19$lambda$18$lambda$17(QWalletBaseIdFormVC this$0, Function1 function1, ActivityResult activityResult) {
        Intent data;
        String stringExtra;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (activityResult.getResultCode() == -1 && (data = activityResult.getData()) != null && (stringExtra = data.getStringExtra(JobSelectionActivity.PARAM_SELECTED_JOB)) != null) {
            this$0.professionContent.setText(stringExtra);
            if (function1 != null) {
                function1.invoke(stringExtra);
            }
        }
    }

    public static /* synthetic */ void setSexData$default(QWalletBaseIdFormVC qWalletBaseIdFormVC, String str, String str2, boolean z16, boolean z17, Function1 function1, int i3, Object obj) {
        String str3;
        String str4;
        Function1 function12;
        if ((i3 & 1) != 0) {
            str3 = null;
        } else {
            str3 = str;
        }
        if ((i3 & 2) != 0) {
            str4 = null;
        } else {
            str4 = str2;
        }
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        boolean z18 = z16;
        if ((i3 & 16) != 0) {
            function12 = null;
        } else {
            function12 = function1;
        }
        qWalletBaseIdFormVC.setSexData(str3, str4, z18, z17, function12);
    }

    public static final void setSexData$lambda$7$lambda$6(QWalletBaseIdFormVC this$0, List scrollData, final Function1 function1, View clickView) {
        EventCollector.getInstance().onViewClickedBefore(clickView);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(scrollData, "$scrollData");
        Intrinsics.checkNotNullExpressionValue(clickView, "clickView");
        this$0.clearOtherFocus(clickView);
        ScrollSelectDlg.with(this$0.fragment.getContext()).appendColumn(scrollData).setPickerListener(new ScrollSelectDlg.IPickerListener() { // from class: com.tenpay.form.g
            @Override // com.tenpay.proxy.dlg.ScrollSelectDlg.IPickerListener
            public final void onChoice(String str) {
                QWalletBaseIdFormVC.setSexData$lambda$7$lambda$6$lambda$5(QWalletBaseIdFormVC.this, function1, str);
            }
        }).show();
        EventCollector.getInstance().onViewClicked(clickView);
    }

    public static final void setSexData$lambda$7$lambda$6$lambda$5(QWalletBaseIdFormVC this$0, Function1 function1, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sexContent.setText(str);
        if (function1 != null) {
            function1.invoke(this$0.sexContent.getText().toString());
        }
    }

    public static /* synthetic */ void setTitle$default(QWalletBaseIdFormVC qWalletBaseIdFormVC, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        if ((i3 & 2) != 0) {
            str2 = null;
        }
        qWalletBaseIdFormVC.setTitle(str, str2);
    }

    @NotNull
    public final View getInfoRootView() {
        View idVerifyInfoRoot = this.idVerifyInfoRoot;
        Intrinsics.checkNotNullExpressionValue(idVerifyInfoRoot, "idVerifyInfoRoot");
        return idVerifyInfoRoot;
    }

    @SuppressLint({"SetTextI18n"})
    public final void setAddressData(@Nullable String content, boolean r95, boolean changeable, @Nullable final Function1<? super String, Unit> onTextChange) {
        int i3 = 8;
        if (!r95) {
            this.addressRoot.setVisibility(8);
            return;
        }
        this.addressRoot.setVisibility(0);
        ImageView imageView = this.addressArrow;
        if (changeable) {
            i3 = 0;
        }
        imageView.setVisibility(i3);
        TextView textView = this.addressContent;
        textView.setText(content);
        if (changeable) {
            this.addressContent.setTag(new IdVerifyAddressBean(null, null, null, null, 15, null));
            this.addressContent.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.form.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QWalletBaseIdFormVC.setAddressData$lambda$23$lambda$22(QWalletBaseIdFormVC.this, onTextChange, view);
                }
            });
        } else {
            textView.setEnabled(false);
        }
    }

    public final void setConfirmBtnDate(boolean r26, @Nullable final Function1<? super View, Unit> r36) {
        View.OnClickListener onClickListener;
        if (!r26) {
            this.confirmBtn.setVisibility(8);
            return;
        }
        this.confirmBtn.setVisibility(0);
        Button button = this.confirmBtn;
        if (r36 != null) {
            onClickListener = new View.OnClickListener() { // from class: com.tenpay.form.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QWalletBaseIdFormVC.setConfirmBtnDate$lambda$24(Function1.this, view);
                }
            };
        } else {
            onClickListener = null;
        }
        button.setOnClickListener(onClickListener);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0033, code lost:
    
        if (r0 == true) goto L56;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setDate(final boolean isBeginTime, @Nullable String content, boolean r75, boolean changeable, @Nullable final Function1<? super String, Unit> onTextChange) {
        View view;
        final TextView textView;
        ImageView imageView;
        boolean z16;
        boolean startsWith$default;
        if (isBeginTime) {
            view = this.dateBeginRoot;
        } else {
            view = this.dateEndRoot;
        }
        if (isBeginTime) {
            textView = this.dateBeginContent;
        } else {
            textView = this.dateEndContent;
        }
        if (isBeginTime) {
            imageView = this.dateBeginArrow;
        } else {
            imageView = this.dateEndArrow;
        }
        int i3 = 8;
        if (!r75) {
            view.setVisibility(8);
            return;
        }
        view.setVisibility(0);
        if (changeable) {
            i3 = 0;
        }
        imageView.setVisibility(i3);
        if (content != null) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(content, "9999", false, 2, null);
            z16 = true;
        }
        z16 = false;
        if (z16) {
            textView.setText(AgeSelDlg.LONG_YEAR_TXT);
        } else {
            textView.setText(content);
        }
        if (changeable) {
            this.sexContent.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.form.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    QWalletBaseIdFormVC.setDate$lambda$15$lambda$14(QWalletBaseIdFormVC.this, isBeginTime, textView, onTextChange, view2);
                }
            });
        } else {
            textView.setEnabled(false);
        }
    }

    public final void setIdData(@Nullable String content, @Nullable String hint, boolean r46, boolean changeable, @Nullable final Function1<? super String, Unit> onTextChange) {
        if (!r46) {
            this.idRoot.setVisibility(8);
            return;
        }
        this.idRoot.setVisibility(0);
        this.idContent.setShowSoftInputOnFocus(false);
        final ClearableEditText clearableEditText = this.idContent;
        if (!changeable) {
            clearableEditText.setFocusable(false);
            clearableEditText.setFocusableInTouchMode(false);
            clearableEditText.setCursorVisible(false);
            clearableEditText.setEnabled(false);
        } else {
            clearableEditText.setKeyListener(new DialerKeyListener() { // from class: com.tenpay.form.QWalletBaseIdFormVC$setIdData$1$1
                @Override // android.text.method.DialerKeyListener, android.text.method.NumberKeyListener
                @NotNull
                protected char[] getAcceptedChars() {
                    char[] charArray = "0123456789xX".toCharArray();
                    Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
                    return charArray;
                }

                @Override // android.text.method.DialerKeyListener, android.text.method.KeyListener
                public int getInputType() {
                    return 1;
                }
            });
            clearableEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tenpay.form.k
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z16) {
                    QWalletBaseIdFormVC.setIdData$lambda$13$lambda$9(QWalletBaseIdFormVC.this, view, z16);
                }
            });
            clearableEditText.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.form.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QWalletBaseIdFormVC.setIdData$lambda$13$lambda$10(QWalletBaseIdFormVC.this, view);
                }
            });
            if (onTextChange != null) {
                clearableEditText.setOnTextChangedListener(new ClearableEditText.OnTextChangedListener() { // from class: com.tenpay.form.m
                    @Override // com.tenpay.sdk.view.ClearableEditText.OnTextChangedListener
                    public final void onTextChanged() {
                        QWalletBaseIdFormVC.setIdData$lambda$13$lambda$12$lambda$11(ClearableEditText.this, this, onTextChange);
                    }
                });
            }
        }
        clearableEditText.setEnableAutoChangeColor(false);
        clearableEditText.setText(content);
        clearableEditText.setHint(hint);
    }

    public final void setIdTypeData(@Nullable String content, @Nullable String hint, boolean r46) {
        if (!r46) {
            this.idTypeRoot.setVisibility(8);
            return;
        }
        this.idTypeRoot.setVisibility(0);
        TextView textView = this.idTypeContent;
        textView.setText(content);
        textView.setHint(hint);
        textView.setEnabled(false);
    }

    public final void setLinkTextDate(@Nullable String content, boolean r36, @Nullable final Function1<? super View, Unit> r46) {
        View.OnClickListener onClickListener;
        if (!r36) {
            this.linkTextBtn.setVisibility(8);
            return;
        }
        this.linkTextBtn.setVisibility(0);
        this.linkTextBtn.setText(content);
        TextView textView = this.linkTextBtn;
        if (r46 != null) {
            onClickListener = new View.OnClickListener() { // from class: com.tenpay.form.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QWalletBaseIdFormVC.setLinkTextDate$lambda$25(Function1.this, view);
                }
            };
        } else {
            onClickListener = null;
        }
        textView.setOnClickListener(onClickListener);
    }

    public final void setNameData(@Nullable String content, @Nullable String hint, boolean r46, boolean changeable, @Nullable final Function1<? super String, Unit> onTextChange) {
        if (!r46) {
            this.nameRoot.setVisibility(8);
            return;
        }
        this.nameRoot.setVisibility(0);
        final ClearableEditText clearableEditText = this.nameContent;
        if (!changeable) {
            clearableEditText.setFocusable(false);
            clearableEditText.setFocusableInTouchMode(false);
            clearableEditText.setCursorVisible(false);
            clearableEditText.setEnabled(false);
        } else if (onTextChange != null) {
            clearableEditText.setOnTextChangedListener(new ClearableEditText.OnTextChangedListener() { // from class: com.tenpay.form.a
                @Override // com.tenpay.sdk.view.ClearableEditText.OnTextChangedListener
                public final void onTextChanged() {
                    QWalletBaseIdFormVC.setNameData$lambda$4$lambda$3$lambda$2(Function1.this, clearableEditText);
                }
            });
        }
        clearableEditText.setEnableAutoChangeColor(false);
        clearableEditText.setText(content);
        clearableEditText.setHint(hint);
    }

    public final void setProfessionDate(@Nullable String content, boolean r46, boolean changeable, @Nullable final Function1<? super String, Unit> onTextChange) {
        int i3 = 8;
        if (!r46) {
            this.professionRoot.setVisibility(8);
            return;
        }
        this.professionRoot.setVisibility(0);
        ImageView imageView = this.professionArrow;
        if (changeable) {
            i3 = 0;
        }
        imageView.setVisibility(i3);
        TextView textView = this.professionContent;
        textView.setText(content);
        if (changeable) {
            this.professionContent.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.form.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QWalletBaseIdFormVC.setProfessionDate$lambda$19$lambda$18(QWalletBaseIdFormVC.this, onTextChange, view);
                }
            });
        } else {
            textView.setEnabled(false);
        }
    }

    public final void setSexData(@Nullable String content, @Nullable String hint, boolean r56, boolean changeable, @Nullable final Function1<? super String, Unit> onTextChange) {
        final List listOf;
        int i3 = 8;
        if (!r56) {
            this.sexRoot.setVisibility(8);
            return;
        }
        this.sexRoot.setVisibility(0);
        ImageView imageView = this.sexArrow;
        if (changeable) {
            i3 = 0;
        }
        imageView.setVisibility(i3);
        TextView textView = this.sexContent;
        textView.setText(content);
        textView.setHint(hint);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"\u7537", "\u5973"});
        if (changeable) {
            this.sexContent.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.form.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QWalletBaseIdFormVC.setSexData$lambda$7$lambda$6(QWalletBaseIdFormVC.this, listOf, onTextChange, view);
                }
            });
        } else {
            textView.setEnabled(false);
        }
    }

    public final void setTitle(@Nullable String title, @Nullable String r65) {
        boolean z16;
        boolean z17 = true;
        if (title != null && title.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            this.titleView.setVisibility(4);
        } else {
            this.titleView.setVisibility(0);
            this.titleView.setText(title);
        }
        if (r65 != null && r65.length() != 0) {
            z17 = false;
        }
        if (z17) {
            this.subTitleView.setVisibility(4);
        } else {
            this.subTitleView.setVisibility(0);
            this.subTitleView.setText(r65);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
    
        if (com.tenpay.util.Utils.invalidateID(r6) == false) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean validateId(@Nullable String idNum) {
        boolean contains$default;
        if (idNum == null) {
            return false;
        }
        int length = idNum.length();
        if (length >= 18 || length == 15) {
            if (length == 18) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) idNum, (CharSequence) "*", false, 2, (Object) null);
                if (!contains$default) {
                    String upperCase = idNum.toUpperCase();
                    Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase()");
                }
            }
            return true;
        }
        QQToastUtil.showQQToast(1, R.string.f171346e91);
        this.idContent.requestFocus();
        return false;
    }
}
