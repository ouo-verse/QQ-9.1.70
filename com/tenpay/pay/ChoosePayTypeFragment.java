package com.tenpay.pay;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.qwallet.QWalletBottomSheetDialogFragment;
import com.tencent.mobileqq.qwallet.WeakFragmentReceiver;
import com.tencent.mobileqq.qwallet.api.IQWalletDebugApi;
import com.tencent.mobileqq.qwallet.utils.k;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tenpay.pay.FriendPayController;
import com.tenpay.pay.PayTypeItemViewHolder;
import com.tenpay.pay.model.PayChannelBean;
import com.tenpay.pay.model.SelectedPayChannelBean;
import com.tenpay.util.Utils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u009b\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0019\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0001CB\u0005\u00a2\u0006\u0002\u0010\u0003J\u001c\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\u001cH\u0002J\u0010\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u000eH\u0002J\u0012\u0010$\u001a\u00020\u001c2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0012\u0010'\u001a\u00020(2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J&\u0010)\u001a\u0004\u0018\u00010\u000e2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010.\u001a\u00020\u001cH\u0016J\u0010\u0010/\u001a\u00020\u001c2\u0006\u00100\u001a\u000201H\u0016J\u0018\u00102\u001a\u00020\u001c2\u0006\u00103\u001a\u00020\u001e2\u0006\u00104\u001a\u00020\u0015H\u0016J\u0018\u00105\u001a\u00020\u001c2\u0006\u00103\u001a\u00020\u001e2\u0006\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u00020\u001cH\u0016J\u001a\u00109\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u000e2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010:\u001a\u00020\u001cH\u0002J\b\u0010;\u001a\u00020\u001cH\u0002J\u0012\u0010<\u001a\u00020\u001c2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0013J\u001a\u0010>\u001a\u00020\u001c2\u0006\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001a\u00a8\u0006D"}, d2 = {"Lcom/tenpay/pay/ChoosePayTypeFragment;", "Lcom/tencent/mobileqq/qwallet/QWalletBottomSheetDialogFragment;", "Lcom/tenpay/pay/PayTypeItemViewHolder$IPayChannelItemClickListener;", "()V", "adapter", "Lcom/tenpay/pay/PayChannelAdapter;", "backBtn", "Landroid/widget/ImageView;", "closeBtn", "friendPayController", "Lcom/tenpay/pay/FriendPayController;", "payChannelRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "priceRoot", "Landroid/view/View;", "priceView", "Landroid/widget/TextView;", "produtionTitleView", "qpayGateJSON", "Lorg/json/JSONObject;", "selectedPayChannelIndex", "", "selectedPayType", "titleView", "wxPayCallback", "com/tenpay/pay/ChoosePayTypeFragment$wxPayCallback$1", "Lcom/tenpay/pay/ChoosePayTypeFragment$wxPayCallback$1;", "callbackResult", "", "payChannel", "Lcom/tenpay/pay/model/PayChannelBean;", "isNewBalance", "", "initData", "initView", "view", "onCreate", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onItemClick", "payChannelBean", "position", "onMiniAppClick", "miniApp", "Lcom/tenpay/pay/model/PayChannelBean$MiniApp;", "onStart", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onWxRechargeCallback", "registerWxPayCallback", "renderView", "inQpayGateJSON", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class ChoosePayTypeFragment extends QWalletBottomSheetDialogFragment implements PayTypeItemViewHolder.IPayChannelItemClickListener {

    @NotNull
    public static final String KEY_FIREND_PAY_FROM = "friend_pay_from";

    @NotNull
    public static final String KEY_FIREND_PAY_TOKEN_ID = "friend_pay_token_id";

    @NotNull
    public static final String KEY_FIREND_PROCESS_FLAG = "friend_pay_process_flag";

    @NotNull
    public static final String KEY_PROCESS_TYPE = "ProcessType";

    @NotNull
    public static final String KEY_QPAY_GATE = "qpay_gate";

    @NotNull
    public static final String KEY_SELECTED_PAY_INDEX = "selected_bank_index";

    @NotNull
    public static final String KEY_SELECTED_PAY_TYPE = "selected_pay_type";

    @NotNull
    public static final String REQUEST_KEY_SELECT_HB_CHANNEL_FINISH = "select_hb_channel_finish";

    @NotNull
    public static final String RET_KEY_CHANNEL = "ret_channel";

    @NotNull
    public static final String RET_KEY_NEW_BALANCE = "new_balance";

    @NotNull
    public static final String TAG = "CFT-sdk-ChoosePayTypeFragment";
    private ImageView backBtn;
    private ImageView closeBtn;
    private RecyclerView payChannelRecyclerView;
    private View priceRoot;
    private TextView priceView;
    private TextView produtionTitleView;
    private JSONObject qpayGateJSON;
    private int selectedPayChannelIndex;
    private TextView titleView;

    @NotNull
    private PayChannelAdapter adapter = new PayChannelAdapter(this, this);
    private int selectedPayType = -1;

    @NotNull
    private final FriendPayController friendPayController = new FriendPayController();

    @NotNull
    private final ChoosePayTypeFragment$wxPayCallback$1 wxPayCallback = new WeakFragmentReceiver<ChoosePayTypeFragment>() { // from class: com.tenpay.pay.ChoosePayTypeFragment$wxPayCallback$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(ChoosePayTypeFragment.this);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@Nullable Context context, @Nullable Intent intent) {
            String action;
            boolean z16;
            if (intent != null && (action = intent.getAction()) != null) {
                QLog.i(ChoosePayTypeFragment.TAG, 1, "receive wx callback: " + action);
                if (Intrinsics.areEqual("com.tencent.mobileqq.action.ACTION_WECHAT_RESPONSE", action)) {
                    WXLaunchMiniProgram.Resp resp = new WXLaunchMiniProgram.Resp();
                    resp.fromBundle(intent.getExtras());
                    QLog.i(ChoosePayTypeFragment.TAG, 1, "wx callback resp: " + resp);
                    if (resp.errCode == 0) {
                        String str = resp.errStr;
                        if (str != null && str.length() != 0) {
                            z16 = false;
                        } else {
                            z16 = true;
                        }
                        if (z16) {
                            ChoosePayTypeFragment.this.onWxRechargeCallback();
                        }
                    }
                }
                if (context != null) {
                    try {
                        context.unregisterReceiver(this);
                    } catch (Exception e16) {
                        QLog.w(ChoosePayTypeFragment.TAG, 1, "unregisterReceiver error:", e16);
                    }
                }
            }
        }
    };

    /* JADX WARN: Multi-variable type inference failed */
    private final void callbackResult(PayChannelBean payChannel, boolean isNewBalance) {
        Parcelable parcelable;
        Bundle bundle = new Bundle();
        if (payChannel instanceof Parcelable) {
            parcelable = (Parcelable) payChannel;
        } else {
            parcelable = null;
        }
        if (parcelable != null) {
            bundle.putParcelable("ret_channel", parcelable);
        }
        bundle.putBoolean(RET_KEY_NEW_BALANCE, isNewBalance);
        QLog.i(TAG, 1, "callbackResult: " + payChannel + ", " + isNewBalance);
        FragmentKt.setFragmentResult(this, "select_hb_channel_finish", bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void callbackResult$default(ChoosePayTypeFragment choosePayTypeFragment, PayChannelBean payChannelBean, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        choosePayTypeFragment.callbackResult(payChannelBean, z16);
    }

    private final void initData() {
        PayChannelBean.FriendPay friendPay;
        Integer num;
        SelectedPayChannelBean selectedPayChannelBean;
        int i3;
        int i16;
        String str;
        Gson create = new GsonBuilder().create();
        PayChannelBean.Bank.Companion companion = PayChannelBean.Bank.INSTANCE;
        JSONObject jSONObject = this.qpayGateJSON;
        SelectedPayChannelBean selectedPayChannelBean2 = null;
        if (jSONObject == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qpayGateJSON");
            jSONObject = null;
        }
        List<PayChannelBean.Bank> createList = companion.createList(jSONObject, create);
        PayChannelBean.Balance.Companion companion2 = PayChannelBean.Balance.INSTANCE;
        JSONObject jSONObject2 = this.qpayGateJSON;
        if (jSONObject2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qpayGateJSON");
            jSONObject2 = null;
        }
        PayChannelBean.Balance create2 = companion2.create(jSONObject2, create);
        PayChannelBean.AddMore.Companion companion3 = PayChannelBean.AddMore.INSTANCE;
        JSONObject jSONObject3 = this.qpayGateJSON;
        if (jSONObject3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qpayGateJSON");
            jSONObject3 = null;
        }
        String string = getString(R.string.e4b);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.tencent.mo\u2026_tenpay_chose_other_bank)");
        PayChannelBean.AddMore create3 = companion3.create(jSONObject3, R.drawable.n9_, string, null);
        PayChannelBean.FriendPay.Companion companion4 = PayChannelBean.FriendPay.INSTANCE;
        JSONObject jSONObject4 = this.qpayGateJSON;
        if (jSONObject4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qpayGateJSON");
            jSONObject4 = null;
        }
        PayChannelBean.FriendPay create4 = companion4.create(jSONObject4, create);
        if (create4 != null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                i3 = arguments.getInt(KEY_FIREND_PAY_FROM, -1);
            } else {
                i3 = -1;
            }
            create4.setIPayFrom(i3);
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                i16 = Integer.valueOf(arguments2.getInt(KEY_FIREND_PROCESS_FLAG, -1));
            } else {
                i16 = -1;
            }
            create4.setProcessFlag(i16);
            Bundle arguments3 = getArguments();
            if (arguments3 != null) {
                str = arguments3.getString(KEY_FIREND_PAY_TOKEN_ID);
            } else {
                str = null;
            }
            create4.setPayTokenId(str);
            friendPay = create4;
        } else {
            friendPay = null;
        }
        PayChannelBean.AutoPayCard.Companion companion5 = PayChannelBean.AutoPayCard.INSTANCE;
        JSONObject jSONObject5 = this.qpayGateJSON;
        if (jSONObject5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qpayGateJSON");
            jSONObject5 = null;
        }
        List<PayChannelBean.AutoPayCard> createList2 = companion5.createList(jSONObject5, create);
        int i17 = this.selectedPayType;
        if (i17 == 0) {
            selectedPayChannelBean = new SelectedPayChannelBean(0, null, null, null, 0, 30, null);
        } else {
            if (i17 == 5 && this.selectedPayChannelIndex >= 0) {
                int size = createList2.size();
                int i18 = this.selectedPayChannelIndex;
                if (size > i18) {
                    selectedPayChannelBean2 = SelectedPayChannelBean.INSTANCE.fromAutoPay(createList2.get(i18));
                    selectedPayChannelBean = selectedPayChannelBean2;
                }
            }
            if (this.selectedPayChannelIndex >= 0) {
                int size2 = createList.size();
                int i19 = this.selectedPayChannelIndex;
                if (size2 > i19) {
                    selectedPayChannelBean2 = SelectedPayChannelBean.INSTANCE.fromBank(createList.get(i19));
                    selectedPayChannelBean = selectedPayChannelBean2;
                }
            }
            Bundle arguments4 = getArguments();
            if (arguments4 != null) {
                num = Integer.valueOf(arguments4.getInt(KEY_PROCESS_TYPE));
            } else {
                num = null;
            }
            com.tencent.mobileqq.qwallet.c.c("extra.cantpay.record", num);
            selectedPayChannelBean = selectedPayChannelBean2;
        }
        QLog.i(TAG, 1, "recommendChannel: " + selectedPayChannelBean);
        PayChannelAdapter.setData$default(this.adapter, null, create2, createList, null, create3, friendPay, createList2, selectedPayChannelBean, false, 9, null);
    }

    private final void initView(View view) {
        View findViewById = view.findViewById(R.id.jqb);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.title_view)");
        this.titleView = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.svv);
        ImageView imageView = (ImageView) findViewById2;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.pay.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ChoosePayTypeFragment.initView$lambda$1$lambda$0(ChoosePayTypeFragment.this, view2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById<ImageV\u2026ngStateLoss() }\n        }");
        this.backBtn = imageView;
        View findViewById3 = view.findViewById(R.id.f164995uj2);
        ImageView imageView2 = (ImageView) findViewById3;
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.pay.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ChoosePayTypeFragment.initView$lambda$3$lambda$2(ChoosePayTypeFragment.this, view2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById<ImageV\u2026ngStateLoss() }\n        }");
        this.closeBtn = imageView2;
        View findViewById4 = view.findViewById(R.id.f27860hd);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.prodution_title_txt)");
        this.produtionTitleView = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.f166539fz0);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.price_layout)");
        this.priceRoot = findViewById5;
        View findViewById6 = view.findViewById(R.id.f166540fz1);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.price_txt)");
        this.priceView = (TextView) findViewById6;
        ((Button) view.findViewById(R.id.f227504k)).setVisibility(8);
        View findViewById7 = view.findViewById(R.id.f227904o);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.pay_channel_recycler_view)");
        RecyclerView recyclerView = (RecyclerView) findViewById7;
        this.payChannelRecyclerView = recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payChannelRecyclerView");
            recyclerView = null;
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        linearLayoutManager.setAutoMeasureEnabled(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(this.adapter);
        ((NestedScrollView) view.findViewById(R.id.f71893pd)).setNestedScrollingEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1$lambda$0(ChoosePayTypeFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3$lambda$2(ChoosePayTypeFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onWxRechargeCallback() {
        callbackResult(null, true);
    }

    private final void registerWxPayCallback() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mobileqq.action.ACTION_WECHAT_RESPONSE");
        try {
            Context context = getContext();
            if (context != null) {
                context.registerReceiver(this.wxPayCallback, intentFilter);
            }
        } catch (Exception e16) {
            QLog.d(TAG, 2, "registerWxPayCallback error:", e16);
        }
    }

    public static /* synthetic */ void renderView$default(ChoosePayTypeFragment choosePayTypeFragment, JSONObject jSONObject, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            jSONObject = null;
        }
        choosePayTypeFragment.renderView(jSONObject);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Integer num;
        String str;
        boolean z16;
        int i3;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        JSONObject jSONObject = null;
        if (arguments != null) {
            num = Integer.valueOf(arguments.getInt(KEY_PROCESS_TYPE));
        } else {
            num = null;
        }
        com.tencent.mobileqq.qwallet.c.c("pay.choose.show", num);
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            str = arguments2.getString("qpay_gate");
        } else {
            str = null;
        }
        int i16 = 0;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.i(TAG, 1, "onCreate fail, qpayGateJSONString is null");
            callbackResult$default(this, null, false, 2, null);
            dismissAllowingStateLoss();
            return;
        }
        this.qpayGateJSON = new JSONObject(str);
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            i16 = arguments3.getInt(KEY_SELECTED_PAY_INDEX);
        }
        this.selectedPayChannelIndex = i16;
        Bundle arguments4 = getArguments();
        if (arguments4 != null) {
            i3 = arguments4.getInt(KEY_SELECTED_PAY_TYPE);
        } else {
            i3 = -1;
        }
        this.selectedPayType = i3;
        int i17 = this.selectedPayChannelIndex;
        JSONObject jSONObject2 = this.qpayGateJSON;
        if (jSONObject2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qpayGateJSON");
        } else {
            jSONObject = jSONObject2;
        }
        QLog.i(TAG, 1, "onCreate: selectedPayChannelIndex=" + i17 + " selectedPayType=" + i3 + " " + jSONObject);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNullExpressionValue(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        Window window = onCreateDialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.color.ajr);
        }
        QUIImmersiveHelper.t(onCreateDialog.getWindow(), false, null, true, getView());
        onCreateDialog.setCanceledOnTouchOutside(false);
        if (onCreateDialog instanceof com.google.android.material.bottomsheet.a) {
            com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
            aVar.getBehavior().setState(3);
            aVar.getBehavior().setDraggable(false);
            aVar.getBehavior().setPeekHeight(-1);
            aVar.getBehavior().setMaxHeight((int) (x.f(aVar.getContext()).a() * ((IQWalletDebugApi) QRoute.api(IQWalletDebugApi.class)).getPayChannelHeightRate(0.9d)));
        }
        return onCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fyh, container, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        try {
            Context context = getContext();
            if (context != null) {
                context.unregisterReceiver(this.wxPayCallback);
            }
        } catch (Exception e16) {
            QLog.d(TAG, 2, "registerWxPayCallback error:", e16);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        callbackResult$default(this, null, false, 2, null);
    }

    @Override // com.tenpay.pay.PayTypeItemViewHolder.IPayChannelItemClickListener
    public void onItemClick(@NotNull final PayChannelBean payChannelBean, int position) {
        Intrinsics.checkNotNullParameter(payChannelBean, "payChannelBean");
        QLog.i(TAG, 1, "onItemClick: " + payChannelBean + " position=" + position);
        if (payChannelBean instanceof PayChannelBean.FriendPay) {
            this.friendPayController.startPay(this, (PayChannelBean.FriendPay) payChannelBean, new FriendPayController.IFriendPayCallback() { // from class: com.tenpay.pay.ChoosePayTypeFragment$onItemClick$1
                @Override // com.tenpay.pay.FriendPayController.IFriendPayCallback
                public void onPayFinish(@Nullable FriendPayController.FriendPayResult result) {
                    ((PayChannelBean.FriendPay) PayChannelBean.this).setPayResult(result);
                    ChoosePayTypeFragment.callbackResult$default(this, PayChannelBean.this, false, 2, null);
                }
            });
        } else {
            callbackResult$default(this, payChannelBean, false, 2, null);
        }
    }

    @Override // com.tenpay.pay.PayTypeItemViewHolder.IPayChannelItemClickListener
    public void onMiniAppClick(@NotNull PayChannelBean payChannelBean, @NotNull PayChannelBean.MiniApp miniApp) {
        Intrinsics.checkNotNullParameter(payChannelBean, "payChannelBean");
        Intrinsics.checkNotNullParameter(miniApp, "miniApp");
        k.h(getContext(), miniApp.getUrl());
        if (payChannelBean instanceof PayChannelBean.Balance) {
            registerWxPayCallback();
            PayChannelBean.Balance balance = (PayChannelBean.Balance) payChannelBean;
            Long balance2 = balance.getBalance();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(balance2);
            String sb6 = sb5.toString();
            Long totalFee = balance.getTotalFee();
            StringBuilder sb7 = new StringBuilder();
            sb7.append(totalFee);
            com.tencent.mobileqq.qwallet.c.e("paysdk.wx2qq.click", sb6, sb7.toString(), "", "");
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        ViewParent viewParent;
        super.onStart();
        View view = getView();
        View view2 = null;
        if (view != null) {
            viewParent = view.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent instanceof View) {
            view2 = (View) viewParent;
        }
        if (view2 != null) {
            view2.setBackgroundResource(17170445);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        renderView$default(this, null, 1, null);
    }

    public final void renderView(@Nullable JSONObject inQpayGateJSON) {
        if (inQpayGateJSON != null) {
            this.qpayGateJSON = inQpayGateJSON;
        }
        initData();
        boolean hasAnyChannelCanUse = this.adapter.hasAnyChannelCanUse();
        if (this.titleView != null && getView() != null) {
            JSONObject jSONObject = null;
            TextView textView = null;
            if (hasAnyChannelCanUse) {
                TextView textView2 = this.titleView;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleView");
                    textView2 = null;
                }
                textView2.setVisibility(0);
                ImageView imageView = this.backBtn;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("backBtn");
                    imageView = null;
                }
                imageView.setVisibility(0);
                ImageView imageView2 = this.closeBtn;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("closeBtn");
                    imageView2 = null;
                }
                imageView2.setVisibility(8);
                View view = this.priceRoot;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("priceRoot");
                    view = null;
                }
                view.setVisibility(8);
                TextView textView3 = this.produtionTitleView;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("produtionTitleView");
                } else {
                    textView = textView3;
                }
                textView.setVisibility(8);
                return;
            }
            TextView textView4 = this.titleView;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleView");
                textView4 = null;
            }
            textView4.setVisibility(8);
            ImageView imageView3 = this.backBtn;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backBtn");
                imageView3 = null;
            }
            imageView3.setVisibility(8);
            ImageView imageView4 = this.closeBtn;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("closeBtn");
                imageView4 = null;
            }
            imageView4.setVisibility(0);
            View view2 = this.priceRoot;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("priceRoot");
                view2 = null;
            }
            view2.setVisibility(0);
            TextView textView5 = this.produtionTitleView;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("produtionTitleView");
                textView5 = null;
            }
            textView5.setVisibility(0);
            TextView textView6 = this.produtionTitleView;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("produtionTitleView");
                textView6 = null;
            }
            JSONObject jSONObject2 = this.qpayGateJSON;
            if (jSONObject2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qpayGateJSON");
                jSONObject2 = null;
            }
            textView6.setText(jSONObject2.optString("desc"));
            TextView textView7 = this.priceView;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("priceView");
                textView7 = null;
            }
            JSONObject jSONObject3 = this.qpayGateJSON;
            if (jSONObject3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qpayGateJSON");
            } else {
                jSONObject = jSONObject3;
            }
            textView7.setText(Utils.transformToMoney(jSONObject.optString("real_fee"), 0));
            return;
        }
        dismissAllowingStateLoss();
        QLog.w(TAG, 1, "renderView but view is not initialized");
    }

    @Override // com.tencent.mobileqq.qwallet.QWalletBottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public void show(@NotNull FragmentManager manager, @Nullable String tag) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        try {
            super.show(manager, tag);
        } catch (IllegalStateException e16) {
            QLog.e(TAG, 1, "show error", e16);
        }
    }
}
