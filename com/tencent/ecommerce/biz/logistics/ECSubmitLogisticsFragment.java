package com.tencent.ecommerce.biz.logistics;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.list.IStateCenterView;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.base.ui.SoftKeyboardStateHelper;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.stateview.ECStateCenterView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.AuthDevOpenUgActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 =2\u00020\u0001:\u0001>B\u0007\u00a2\u0006\u0004\b;\u0010<J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u00020\bH\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\u001a\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0016R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010\u001dR\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00103R\u0016\u00108\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00103R\u0016\u0010:\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00103\u00a8\u0006?"}, d2 = {"Lcom/tencent/ecommerce/biz/logistics/ECSubmitLogisticsFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "", "actionId", "Landroid/view/KeyEvent;", "event", "", "Vh", "", "Uh", "Wh", "", "msg", UIJsPlugin.EVENT_SHOW_TOAST, UIJsPlugin.EVENT_SHOW_LOADING, UIJsPlugin.EVENT_HIDE_LOADING, "getContentLayoutId", "getBusinessDescription", "Bh", "Eh", "Dh", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onBackPressed", "Landroid/widget/EditText;", "P", "Landroid/widget/EditText;", "submitPhoneText", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "submitExpressNumberText", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/TextView;", "selectExpressCompanyText", ExifInterface.LATITUDE_SOUTH, "Landroid/view/View;", "submitExpressCompanyLayout", "T", "submitExpressCompanyText", "Landroid/widget/Button;", "U", "Landroid/widget/Button;", "submitBtn", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "V", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "stateView", "W", "Ljava/lang/String;", "afterSalesId", "X", "processId", "Y", "phoneNum", "Z", "expressCompanyCode", "<init>", "()V", "a0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECSubmitLogisticsFragment extends ECBaseFragment {

    /* renamed from: P, reason: from kotlin metadata */
    private EditText submitPhoneText;

    /* renamed from: Q, reason: from kotlin metadata */
    private EditText submitExpressNumberText;

    /* renamed from: R, reason: from kotlin metadata */
    private TextView selectExpressCompanyText;

    /* renamed from: S, reason: from kotlin metadata */
    private View submitExpressCompanyLayout;

    /* renamed from: T, reason: from kotlin metadata */
    private EditText submitExpressCompanyText;

    /* renamed from: U, reason: from kotlin metadata */
    private Button submitBtn;

    /* renamed from: V, reason: from kotlin metadata */
    private ECStateCenterView stateView;

    /* renamed from: W, reason: from kotlin metadata */
    private String afterSalesId;

    /* renamed from: X, reason: from kotlin metadata */
    private String processId;

    /* renamed from: Y, reason: from kotlin metadata */
    private String phoneNum;

    /* renamed from: Z, reason: from kotlin metadata */
    private String expressCompanyCode = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"com/tencent/ecommerce/biz/logistics/ECSubmitLogisticsFragment$launchSelectExpressPage$1$1", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "Lorg/json/JSONObject;", "data", "", "onCallbackFinished", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements IECSchemeCallback {
        b() {
        }

        @Override // com.tencent.ecommerce.base.router.api.IECSchemeCallback
        public void onCallbackFinished(JSONObject data) {
            if (data.optInt("SELECTED_RETURN_CODE") == 1) {
                String optString = data.optString("SELECTED_EXPRESS_NAME");
                ECSubmitLogisticsFragment.this.expressCompanyCode = data.optString("SELECTED_EXPRESS_CODE");
                if (optString.length() > 0) {
                    ECSubmitLogisticsFragment.Mh(ECSubmitLogisticsFragment.this).setText(optString);
                }
                if (Intrinsics.areEqual(optString, ECSelectExpressFragment.INSTANCE.c().name)) {
                    ECSubmitLogisticsFragment.Nh(ECSubmitLogisticsFragment.this).setVisibility(0);
                } else {
                    ECSubmitLogisticsFragment.Nh(ECSubmitLogisticsFragment.this).setVisibility(8);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            SoftKeyboardStateHelper.INSTANCE.d(ECSubmitLogisticsFragment.this.yh());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "v", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "event", "Landroid/view/KeyEvent;", "onEditorAction"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class d implements TextView.OnEditorActionListener {
        d() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
            boolean Vh = ECSubmitLogisticsFragment.this.Vh(i3, keyEvent);
            EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
            return Vh;
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECSubmitLogisticsFragment.this.Uh();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECSubmitLogisticsFragment.this.Wh();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public static final /* synthetic */ TextView Mh(ECSubmitLogisticsFragment eCSubmitLogisticsFragment) {
        TextView textView = eCSubmitLogisticsFragment.selectExpressCompanyText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectExpressCompanyText");
        }
        return textView;
    }

    public static final /* synthetic */ View Nh(ECSubmitLogisticsFragment eCSubmitLogisticsFragment) {
        View view = eCSubmitLogisticsFragment.submitExpressCompanyLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("submitExpressCompanyLayout");
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Uh() {
        cg0.a.b("SubmitLogisticsFragment", "launchSelectExpressPage");
        Context context = getContext();
        if (context != null) {
            yi0.a.p(context, ECSelectExpressFragment.class, new Bundle(), 0, new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Wh() {
        String str;
        EditText editText = this.submitPhoneText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("submitPhoneText");
        }
        String obj = editText.getText().toString();
        EditText editText2 = this.submitExpressNumberText;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("submitExpressNumberText");
        }
        String obj2 = editText2.getText().toString();
        TextView textView = this.selectExpressCompanyText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectExpressCompanyText");
        }
        String obj3 = textView.getText().toString();
        EditText editText3 = this.submitExpressCompanyText;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("submitExpressCompanyText");
        }
        String obj4 = editText3.getText().toString();
        View view = this.submitExpressCompanyLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("submitExpressCompanyLayout");
        }
        boolean z16 = view.getVisibility() == 0;
        if (z16) {
            obj3 = obj4;
        }
        if (z16) {
            str = "";
        } else {
            str = this.expressCompanyCode;
        }
        String str2 = str;
        if (obj.length() == 0) {
            showToast("\u8bf7\u8f93\u5165\u7535\u8bdd\u53f7\u7801");
            return;
        }
        if (obj2.length() == 0) {
            showToast("\u8bf7\u8f93\u5165\u5feb\u9012\u5355\u53f7");
            return;
        }
        if (obj3.length() == 0) {
            showToast("\u8bf7\u9009\u62e9\u5feb\u9012\u516c\u53f8");
            return;
        }
        showLoading();
        String str3 = this.afterSalesId;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("afterSalesId");
        }
        String str4 = this.processId;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("processId");
        }
        com.tencent.ecommerce.base.network.service.a.b("trpc.ecom.after_sales_svr.AfterSales", "/trpc.ecom.after_sales_svr.AfterSales/SubmitLogisticsInfo", new g(str3, obj2, str2, obj3, obj, str4, z16), new h(), new ECSubmitLogisticsFragment$submit$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideLoading() {
        ECStateCenterView eCStateCenterView = this.stateView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateView");
        }
        eCStateCenterView.setSucceededState();
    }

    private final void showLoading() {
        ECStateCenterView eCStateCenterView = this.stateView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateView");
        }
        IStateCenterView.a.c(eCStateCenterView, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showToast(String msg2) {
        com.tencent.ecommerce.base.ui.i.f101155b.d(msg2, ECToastIcon.ICON_NONE, 0);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Bh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Dh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "SubmitLogisticsFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cus;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, com.tencent.ecommerce.base.ui.api.IECFragmentApi
    public boolean onBackPressed() {
        ECStateCenterView eCStateCenterView = this.stateView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateView");
        }
        if (eCStateCenterView.getVisibility() == 0) {
            ECStateCenterView eCStateCenterView2 = this.stateView;
            if (eCStateCenterView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stateView");
            }
            eCStateCenterView2.setSucceededState();
            return true;
        }
        return super.onBackPressed();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        String str;
        String str2;
        String string;
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        String str3 = "";
        if (arguments == null || (str = arguments.getString("after_sales_id")) == null) {
            str = "";
        }
        this.afterSalesId = str;
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (str2 = arguments2.getString(CrashHianalyticsData.PROCESS_ID)) == null) {
            str2 = "";
        }
        this.processId = str2;
        Bundle arguments3 = getArguments();
        if (arguments3 != null && (string = arguments3.getString(AuthDevOpenUgActivity.KEY_PHONE_NUM)) != null) {
            str3 = string;
        }
        this.phoneNum = str3;
        this.submitPhoneText = (EditText) view.findViewById(R.id.obf);
        this.submitExpressNumberText = (EditText) view.findViewById(R.id.obd);
        this.selectExpressCompanyText = (TextView) view.findViewById(R.id.obj);
        this.submitExpressCompanyLayout = view.findViewById(R.id.obh);
        this.submitExpressCompanyText = (EditText) view.findViewById(R.id.obe);
        this.submitBtn = (Button) view.findViewById(R.id.obc);
        ECStateCenterView eCStateCenterView = (ECStateCenterView) view.findViewById(R.id.obi);
        this.stateView = eCStateCenterView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateView");
        }
        eCStateCenterView.setSucceededState();
        setTitle(R.string.wtt);
        View view2 = this.submitExpressCompanyLayout;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("submitExpressCompanyLayout");
        }
        view2.setVisibility(8);
        String str4 = this.phoneNum;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("phoneNum");
        }
        if (str4.length() > 0) {
            EditText editText = this.submitPhoneText;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("submitPhoneText");
            }
            String str5 = this.phoneNum;
            if (str5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("phoneNum");
            }
            editText.setText(str5);
        }
        yh().setOnClickListener(new c());
        EditText editText2 = this.submitExpressNumberText;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("submitExpressNumberText");
        }
        editText2.setOnEditorActionListener(new d());
        TextView textView = this.selectExpressCompanyText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectExpressCompanyText");
        }
        textView.setOnClickListener(new e());
        Button button = this.submitBtn;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("submitBtn");
        }
        button.setOnClickListener(new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Vh(int actionId, KeyEvent event) {
        if (actionId == 6) {
            EditText editText = this.submitExpressNumberText;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("submitExpressNumberText");
            }
            String obj = editText.getText().toString();
            TextView textView = this.selectExpressCompanyText;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectExpressCompanyText");
            }
            CharSequence text = textView.getText();
            if (text != null) {
                if (text.length() == 0) {
                    com.tencent.ecommerce.base.network.service.a.b("trpc.ecom.after_sales_svr.AfterSales", "/trpc.ecom.after_sales_svr.AfterSales/QueryLogisticsCompany", new com.tencent.ecommerce.biz.logistics.e(obj), new com.tencent.ecommerce.biz.logistics.f(), new ECSubmitLogisticsFragment$onSoftInputAction$1(this));
                    return true;
                }
            }
        }
        return false;
    }
}
