package com.tenpay.payment.qrcodehb;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.qwallet.utils.QWalletUtils;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.qwallet.data.SendQrCodeHbResult;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.browser.BrowserPlugin;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.util.QQToastUtil;
import com.tenpay.payment.PaymentUtils;
import com.tenpay.payment.QWalletPaymentExtKt;
import com.tenpay.payment.qrcodehb.QrCodeHbInfo;
import com.tenpay.proxy.QUIProxy;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.activity.HbListActivity;
import com.tenpay.sdk.activity.NetBaseActivity;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@RoutePage(desc = "QQ\u94b1\u5305-\u9762\u5bf9\u9762\u7ea2\u5305\u5f15\u5bfc\u754c\u9762", path = "/qwallet/redpacket/qrcodeHb")
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 J2\u00020\u0001:\u0001JB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u001dH\u0002J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010$\u001a\u00020%H\u0014J\"\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J&\u0010+\u001a\u0004\u0018\u00010\"2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u000e2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u00020\u001dH\u0016J\b\u00102\u001a\u00020\u001dH\u0016J\u0012\u00103\u001a\u00020\u001d2\b\u0010)\u001a\u0004\u0018\u000104H\u0002J\b\u00105\u001a\u00020\u001dH\u0016J\b\u00106\u001a\u00020\u001dH\u0016J\u001c\u00107\u001a\u00020\u001d2\b\u00108\u001a\u0004\u0018\u00010\u00062\b\u0010)\u001a\u0004\u0018\u000104H\u0016J\u001a\u00109\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0010\u0010:\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020<H\u0016J\u001a\u0010=\u001a\n\u0012\u0004\u0012\u00020?\u0018\u00010>2\b\u0010@\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010A\u001a\u00020\u001d2\u0006\u0010B\u001a\u00020%H\u0002J\u0010\u0010C\u001a\u00020\u001d2\u0006\u0010B\u001a\u00020%H\u0002J\b\u0010D\u001a\u00020\u001dH\u0002J\u0012\u0010E\u001a\u00020\u001d2\b\b\u0002\u0010F\u001a\u00020%H\u0002J\b\u0010G\u001a\u00020\u001dH\u0002J\u0010\u0010H\u001a\u00020\u001d2\u0006\u0010I\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006K"}, d2 = {"Lcom/tenpay/payment/qrcodehb/QrCodeHbFragment;", "Lcom/tenpay/sdk/activity/NetBaseActivity;", "()V", "codeController", "Lcom/tenpay/payment/qrcodehb/QrCodeHbCodeController;", "currentQrToken", "", "currentStatus", "", "guideBgQrCodeMask", "Landroid/widget/ImageView;", "guideConfirmBtn", "Landroid/widget/Button;", "guideContainer", "Landroid/view/ViewGroup;", "guideLogoView", "guideSubTitleView", "Landroid/widget/TextView;", "guideTitleView", "lastRefreshTimeMs", "", "maxHbCountLimit", "packNextRoot", "pushController", "Lcom/tenpay/payment/qrcodehb/QrCodeHbPushController;", "qrCodeValidTimeMs", "refreshAction", "Ljava/lang/Runnable;", "gotoPackHb", "", "initData", "initQrData", "initTitleBar", "view", "Landroid/view/View;", "initView", "isSDKActivity", "", "onActivityResult", "requestCode", QzoneIPCModule.RESULT_CODE, "data", "Landroid/content/Intent;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onDestroyView", "onGetQrCodeHbSuccess", "Lorg/json/JSONObject;", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onResume", "onSuccess", BrowserPlugin.KEY_REQUEST_URL, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "operateWindow", "window", "Landroid/view/Window;", "parseQrCodeListData", "", "Lcom/tenpay/payment/qrcodehb/QrCodeHbInfo;", "qrCodeListStr", "renderGuideStatus", "show", "renderQrCodeStatus", "requestQrCodeList", "scheduleRefreshCode", "scheduleNext", "showHintTips", "updateUIStatus", "newStatus", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class QrCodeHbFragment extends NetBaseActivity {
    private static final int DEFAULT_MAX_HB_COUNT_LIMIT = 6;
    private static final int DEFAULT_VALID_TIME_SECONDS = 60;

    @NotNull
    public static final String KEY_IN_NEED_CALLBACK_ON_DESTROY = "callback_on_destroy";

    @NotNull
    public static final String KEY_IN_QR_DATA = "qrData";

    @NotNull
    public static final String KEY_IN_QR_TOKEN = "qrToken";
    private static final int REQUEST_CODE_SEND_QRCODE_HB = 10001;
    private static final int STATUS_GUIDE = 1;
    private static final int STATUS_QRCODE = 2;
    private static final int STATUS_UNKNOWN = 0;

    @NotNull
    private final QrCodeHbCodeController codeController;

    @Nullable
    private String currentQrToken;
    private int currentStatus;
    private ImageView guideBgQrCodeMask;
    private Button guideConfirmBtn;
    private ViewGroup guideContainer;
    private ImageView guideLogoView;
    private TextView guideSubTitleView;
    private TextView guideTitleView;
    private long lastRefreshTimeMs;
    private int maxHbCountLimit;
    private ViewGroup packNextRoot;

    @NotNull
    private final QrCodeHbPushController pushController;
    private long qrCodeValidTimeMs;

    @NotNull
    private final Runnable refreshAction;

    public QrCodeHbFragment() {
        QrCodeHbCodeController qrCodeHbCodeController = new QrCodeHbCodeController(this);
        this.codeController = qrCodeHbCodeController;
        this.pushController = new QrCodeHbPushController(this, qrCodeHbCodeController);
        this.maxHbCountLimit = 6;
        this.qrCodeValidTimeMs = 60000L;
        this.refreshAction = new Runnable() { // from class: com.tenpay.payment.qrcodehb.f
            @Override // java.lang.Runnable
            public final void run() {
                QrCodeHbFragment.refreshAction$lambda$0(QrCodeHbFragment.this);
            }
        };
    }

    private final void gotoPackHb() {
        Intent intent = new Intent();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(WadlProxyConsts.CHANNEL, 2048);
        jSONObject.put("recv_uin", com.tencent.mobileqq.base.a.c());
        intent.putExtra("extra_data", jSONObject.toString());
        intent.putExtra("come_from", 2);
        intent.addFlags(536870912);
        RouteUtils.startActivityForResult(requireContext(), intent, "/qwallet/redpacket/sendhb", 10001);
        QrCodeHbUtils qrCodeHbUtils = QrCodeHbUtils.INSTANCE;
        boolean z16 = true;
        if (this.currentStatus != 1) {
            z16 = false;
        }
        qrCodeHbUtils.reportFace2Face(z16, ResourceAttributes.TelemetrySdkLanguageValues.GO);
    }

    private final void initData() {
        initQrData();
        requestQrCodeList();
    }

    private final void initQrData() {
        boolean z16;
        String str;
        boolean z17;
        Intent intent = getIntent();
        boolean z18 = false;
        if (intent != null) {
            z16 = intent.getBooleanExtra(KEY_IN_NEED_CALLBACK_ON_DESTROY, false);
        } else {
            z16 = false;
        }
        this.hasTopCallback = z16;
        Intent intent2 = getIntent();
        String str2 = null;
        if (intent2 != null) {
            str = intent2.getStringExtra(KEY_IN_QR_TOKEN);
        } else {
            str = null;
        }
        this.currentQrToken = str;
        if (str != null && str.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            this.currentQrToken = QrCodeHbManager.INSTANCE.readQrCodeHbToken();
        }
        Intent intent3 = getIntent();
        if (intent3 != null) {
            str2 = intent3.getStringExtra(KEY_IN_QR_DATA);
        }
        List<QrCodeHbInfo> parseQrCodeListData = parseQrCodeListData(str2);
        QLog.i(QWalletPaymentExtKt.getPaymentTag(this), 2, "initQrData token=" + this.currentQrToken + ", " + parseQrCodeListData);
        List<QrCodeHbInfo> list = parseQrCodeListData;
        if (list == null || list.isEmpty()) {
            z18 = true;
        }
        if (z18) {
            return;
        }
        this.codeController.setDataList(parseQrCodeListData);
        updateUIStatus(2);
    }

    private final void initTitleBar(View view) {
        TextView textView = (TextView) view.findViewById(R.id.ivTitleName);
        textView.setText(getString(R.string.f2184363p));
        textView.setTextColor(-1);
        TextView textView2 = (TextView) view.findViewById(R.id.ivTitleBtnLeft);
        textView2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ap5, 0, 0, 0);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.payment.qrcodehb.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QrCodeHbFragment.initTitleBar$lambda$3$lambda$2(QrCodeHbFragment.this, view2);
            }
        });
        final TextView textView3 = (TextView) view.findViewById(R.id.ivTitleBtnRightText);
        textView3.setVisibility(0);
        textView3.setBackground(null);
        textView3.setText(getString(R.string.f2183763j));
        textView3.setTextColor(-1);
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.payment.qrcodehb.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QrCodeHbFragment.initTitleBar$lambda$6$lambda$5(textView3, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTitleBar$lambda$3$lambda$2(QrCodeHbFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.doOnBackPressed();
        QrCodeHbUtils qrCodeHbUtils = QrCodeHbUtils.INSTANCE;
        boolean z16 = true;
        if (this$0.currentStatus != 1) {
            z16 = false;
        }
        qrCodeHbUtils.reportFace2Face(z16, "back");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTitleBar$lambda$6$lambda$5(TextView textView, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Context context = textView.getContext();
        Intent intent = new Intent();
        intent.putExtra("from_out", true);
        com.tencent.mobileqq.base.c.f(context, intent, HbListActivity.class, false, 8, null);
        com.tencent.mobileqq.qwallet.c.f("face2face.detail.record", null, null, null, null, 30, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void initView(View view) {
        QWalletUtils.v(view.findViewById(R.id.f652038a), 8.0f);
        View findViewById = view.findViewById(R.id.f652538f);
        ViewGroup viewGroup = (ViewGroup) findViewById;
        QWalletUtils.v(viewGroup, 8.0f);
        viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.payment.qrcodehb.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QrCodeHbFragment.initView$lambda$9$lambda$8(QrCodeHbFragment.this, view2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById<ViewGr\u2026 gotoPackHb() }\n        }");
        this.packNextRoot = viewGroup;
        View findViewById2 = view.findViewById(R.id.f2300059);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.p\u2026ment_common_content_root)");
        this.guideContainer = (ViewGroup) findViewById2;
        View findViewById3 = view.findViewById(R.id.f2296055);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.p\u2026ment_common_content_icon)");
        this.guideLogoView = (ImageView) findViewById3;
        View findViewById4 = view.findViewById(R.id.f2293052);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.payment_common_content_bg)");
        this.guideBgQrCodeMask = (ImageView) findViewById4;
        View findViewById5 = view.findViewById(R.id.f230205a);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.p\u2026ent_common_content_title)");
        this.guideTitleView = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.f230105_);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.p\u2026common_content_sub_title)");
        this.guideSubTitleView = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.f2294053);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.p\u2026nt_common_content_button)");
        this.guideConfirmBtn = (Button) findViewById7;
        ((ImageView) view.findViewById(R.id.f2296055)).setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.n9f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$9$lambda$8(QrCodeHbFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.gotoPackHb();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void onGetQrCodeHbSuccess(JSONObject data) {
        boolean z16;
        if (data != null && data.optInt("retcode") == 0) {
            this.maxHbCountLimit = data.optInt("max_num", 6);
            this.qrCodeValidTimeMs = data.optInt("valid_seconds", 60) * 1000;
            JSONArray optJSONArray = data.optJSONArray("qr_list");
            if (optJSONArray == null) {
                QQToastUtil.showQQToast(1, R.string.e_t);
                return;
            }
            List<QrCodeHbInfo> parseQrCodeListData = parseQrCodeListData(optJSONArray.toString());
            List<QrCodeHbInfo> list = parseQrCodeListData;
            if (list != null && !list.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                updateUIStatus(1);
                return;
            } else {
                this.codeController.setDataList(parseQrCodeListData);
                updateUIStatus(2);
                return;
            }
        }
        QQToastUtil.showQQToast(1, R.string.e_t);
    }

    private final List<QrCodeHbInfo> parseQrCodeListData(String qrCodeListStr) {
        boolean z16;
        if (qrCodeListStr != null && qrCodeListStr.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        JSONArray jSONArray = new JSONArray(qrCodeListStr);
        ArrayList arrayList = new ArrayList();
        Gson create = new GsonBuilder().create();
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i3);
            if (jSONObject != null) {
                SendQrCodeHbResult item = (SendQrCodeHbResult) create.fromJson(jSONObject.toString(), SendQrCodeHbResult.class);
                QrCodeHbInfo.Companion companion = QrCodeHbInfo.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(item, "item");
                arrayList.add(companion.fromSendHbResult(item));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshAction$lambda$0(QrCodeHbFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i(QWalletPaymentExtKt.getPaymentTag(this$0), 1, "do refreshAction");
        this$0.requestQrCodeList();
        scheduleRefreshCode$default(this$0, false, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v24, types: [android.view.ViewGroup] */
    private final void renderGuideStatus(boolean show) {
        ImageView imageView = null;
        if (!show) {
            ?? r65 = this.guideContainer;
            if (r65 == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("guideContainer");
            } else {
                imageView = r65;
            }
            imageView.setVisibility(8);
            return;
        }
        ViewGroup viewGroup = this.guideContainer;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guideContainer");
            viewGroup = null;
        }
        viewGroup.setVisibility(0);
        viewGroup.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.f158017al3));
        ImageView imageView2 = this.guideLogoView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guideLogoView");
            imageView2 = null;
        }
        imageView2.setVisibility(8);
        TextView textView = this.guideTitleView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guideTitleView");
            textView = null;
        }
        textView.setVisibility(8);
        TextView textView2 = this.guideSubTitleView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guideSubTitleView");
            textView2 = null;
        }
        textView2.setVisibility(0);
        textView2.setText(getString(R.string.f2183563h));
        Button button = this.guideConfirmBtn;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guideConfirmBtn");
            button = null;
        }
        button.setVisibility(0);
        button.setText(getString(R.string.f2183463g));
        button.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.kcf));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.payment.qrcodehb.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QrCodeHbFragment.renderGuideStatus$lambda$14$lambda$13(QrCodeHbFragment.this, view);
            }
        });
        ImageView imageView3 = this.guideBgQrCodeMask;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guideBgQrCodeMask");
        } else {
            imageView = imageView3;
        }
        imageView.setVisibility(0);
        imageView.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.nps));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void renderGuideStatus$lambda$14$lambda$13(QrCodeHbFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.gotoPackHb();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void renderQrCodeStatus(boolean show) {
        this.codeController.changeVisible(show);
        ViewGroup viewGroup = null;
        if (show && this.codeController.getQrCodeHbCount() < this.maxHbCountLimit) {
            ViewGroup viewGroup2 = this.packNextRoot;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("packNextRoot");
            } else {
                viewGroup = viewGroup2;
            }
            viewGroup.setVisibility(0);
            return;
        }
        ViewGroup viewGroup3 = this.packNextRoot;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("packNextRoot");
        } else {
            viewGroup = viewGroup3;
        }
        viewGroup.setVisibility(8);
    }

    private final void requestQrCodeList() {
        boolean z16;
        if (isFinishing()) {
            return;
        }
        long j3 = this.lastRefreshTimeMs;
        if (j3 != 0 && j3 + this.qrCodeValidTimeMs >= System.currentTimeMillis()) {
            QLog.i(QWalletPaymentExtKt.getPaymentTag(this), 1, "requestQrCodeList ignored: " + (this.lastRefreshTimeMs + this.qrCodeValidTimeMs));
            return;
        }
        this.lastRefreshTimeMs = System.currentTimeMillis();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str = this.currentQrToken;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 && !QrCodeHbUtils.INSTANCE.signQrCode(linkedHashMap)) {
            QLog.w(QWalletPaymentExtKt.getPaymentTag(this), 1, "sign fail: " + linkedHashMap);
            return;
        }
        linkedHashMap.put("uin", com.tencent.mobileqq.base.a.c());
        String str2 = this.currentQrToken;
        if (str2 != null) {
            linkedHashMap.put("qr_token", str2);
        }
        httpRequest(Cgi.URI_GET_QRCODE_HB, linkedHashMap);
    }

    private final void scheduleRefreshCode(boolean scheduleNext) {
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.refreshAction);
        if (scheduleNext) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(this.refreshAction, this.qrCodeValidTimeMs);
        }
    }

    static /* synthetic */ void scheduleRefreshCode$default(QrCodeHbFragment qrCodeHbFragment, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        qrCodeHbFragment.scheduleRefreshCode(z16);
    }

    private final void showHintTips() {
        if (com.tencent.mobileqq.qwallet.utils.g.c("is_qrcode_hb_hint_shown_" + this.mUin, false)) {
            return;
        }
        QUIProxy.createCustomDialog(getContext(), 230, "\u6e29\u99a8\u63d0\u793a", getString(R.string.f2183663i), getString(R.string.ead), null, null, new DialogInterface.OnClickListener() { // from class: com.tenpay.payment.qrcodehb.k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QrCodeHbFragment.showHintTips$lambda$22(QrCodeHbFragment.this, dialogInterface, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showHintTips$lambda$22(QrCodeHbFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.qwallet.utils.g.l("is_qrcode_hb_hint_shown_" + this$0.mUin, true);
    }

    private final void updateUIStatus(int newStatus) {
        boolean z16;
        QLog.i(QWalletPaymentExtKt.getPaymentTag(this), 1, "updateUIStatus: newStatus=" + newStatus);
        if (this.currentStatus != newStatus) {
            QrCodeHbUtils qrCodeHbUtils = QrCodeHbUtils.INSTANCE;
            if (newStatus == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            qrCodeHbUtils.reportFace2Face(z16, "show");
        }
        this.currentStatus = newStatus;
        if (newStatus != 1) {
            if (newStatus == 2) {
                renderGuideStatus(false);
                renderQrCodeStatus(true);
                showHintTips();
                scheduleRefreshCode$default(this, false, 1, null);
                return;
            }
            return;
        }
        renderGuideStatus(true);
        renderQrCodeStatus(false);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity
    protected boolean isSDKActivity() {
        return false;
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        SendQrCodeHbResult sendQrCodeHbResult;
        super.onActivityResult(requestCode, resultCode, data);
        if (10001 == requestCode) {
            if (data != null) {
                sendQrCodeHbResult = (SendQrCodeHbResult) data.getParcelableExtra("KEY_SEND_QRCODE_HB_RESULT");
            } else {
                sendQrCodeHbResult = null;
            }
            QLog.i(QWalletPaymentExtKt.getPaymentTag(this), 1, "onActivityResult: " + sendQrCodeHbResult);
            if (sendQrCodeHbResult == null) {
                return;
            }
            QrCodeHbInfo fromSendHbResult = QrCodeHbInfo.INSTANCE.fromSendHbResult(sendQrCodeHbResult);
            this.currentQrToken = sendQrCodeHbResult.getQrToken();
            this.codeController.receiveNewQrCodeHb(fromSendHbResult);
            updateUIStatus(2);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fz4, container, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hasTopCallback) {
            callBackReceiver();
        }
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.pushController.onDestroyView();
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        scheduleRefreshCode(false);
        PaymentUtils.INSTANCE.setScreenBrightness(this, false);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        scheduleRefreshCode$default(this, false, 1, null);
        PaymentUtils.INSTANCE.setScreenBrightness(this, true);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(@Nullable String requestUrl, @Nullable JSONObject data) {
        super.onSuccess(requestUrl, data);
        if (!isFinishing() && Intrinsics.areEqual(requestUrl, Cgi.URI_GET_QRCODE_HB)) {
            onGetQrCodeHbSuccess(data);
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initTitleBar(view);
        initView(view);
        this.codeController.initView(view);
        updateUIStatus(1);
        initData();
        this.pushController.onViewCreated();
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    public void operateWindow(@NotNull Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        super.operateWindow(window);
        window.addFlags(8192);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
