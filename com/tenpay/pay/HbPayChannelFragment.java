package com.tenpay.pay;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
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
import com.qwallet.utils.QWalletUtils;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.QWalletBottomSheetDialogFragment;
import com.tencent.mobileqq.qwallet.api.IQWalletDebugApi;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.QQToastUtil;
import com.tenpay.pay.PayTypeItemViewHolder;
import com.tenpay.pay.model.PayChannelBean;
import com.tenpay.pay.model.SelectedPayChannelBean;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.fakeurl.FakeUrlDialogBuilder;
import com.tenpay.sdk.fakeurl.QWalletFakeUrlHandler;
import com.tenpay.sdk.net.NetSender;
import com.tenpay.sdk.paynet.Net;
import com.tenpay.sdk.paynet.NetSenderDelegate;
import com.tenpay.util.Utils;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0001?B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J\u0012\u0010\u0017\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u001c\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u001c\u001a\u00020\u0015H\u0002J\u0012\u0010\u001d\u001a\u00020\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010 \u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J&\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020*H\u0016J\u0018\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020.H\u0016J\u0018\u0010/\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u00192\u0006\u00100\u001a\u000201H\u0016J\u001c\u00102\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u00020\u0015H\u0016J\u001a\u00106\u001a\u00020\u00152\u0006\u00107\u001a\u00020#2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u00108\u001a\u00020\u0015H\u0002J\u001a\u00109\u001a\u00020\u00152\u0006\u0010:\u001a\u00020\u00112\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0007J\u001a\u0010;\u001a\u00020\u00152\u0006\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006@"}, d2 = {"Lcom/tenpay/pay/HbPayChannelFragment;", "Lcom/tencent/mobileqq/qwallet/QWalletBottomSheetDialogFragment;", "Lcom/tenpay/pay/PayTypeItemViewHolder$IPayChannelItemClickListener;", "()V", "adapter", "Lcom/tenpay/pay/PayChannelAdapter;", "comFrom", "", "confirmButton", "Landroid/widget/Button;", "hbPackChannels", "Lorg/json/JSONArray;", "payChannelRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "priceView", "Landroid/widget/TextView;", "qpayGateJSON", "Lorg/json/JSONObject;", "titleView", "tokenId", "addReport", "", "action", "callbackResult", "payChannel", "Lcom/tenpay/pay/model/PayChannelBean;", "initBankList", "newBindBankSerial", "onConfirmClick", "onCreate", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onItemClick", "payChannelBean", "position", "", "onMiniAppClick", "miniApp", "Lcom/tenpay/pay/model/PayChannelBean$MiniApp;", "onPayChannelChosen", "needDismiss", "", "onStart", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "view", "refreshQPayGate", "renderQPayGate", "data", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class HbPayChannelFragment extends QWalletBottomSheetDialogFragment implements PayTypeItemViewHolder.IPayChannelItemClickListener {

    @NotNull
    public static final String KEY_COME_FROM = "come_from";

    @NotNull
    public static final String KEY_PAY_CHANNELS = "pay_channels";

    @NotNull
    public static final String KEY_QPAY_GATE = "qpay_gate";

    @NotNull
    public static final String KEY_TOKEN_ID = "token_id";

    @NotNull
    public static final String REQUEST_KEY_SELECT_HB_CHANNEL_FINISH = "select_hb_channel_finish";

    @NotNull
    public static final String RET_KEY_CHANNEL = "ret_channel";

    @NotNull
    public static final String TAG = "CFT-sdk-HbPayChannelFragment";
    private PayChannelAdapter adapter;
    private String comFrom;
    private Button confirmButton;
    private JSONArray hbPackChannels;
    private RecyclerView payChannelRecyclerView;
    private TextView priceView;
    private JSONObject qpayGateJSON;
    private TextView titleView;
    private String tokenId;

    private final void addReport(String action) {
        com.tencent.mobileqq.qwallet.c.e(action, "", "", "", AppSetting.f99551k);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void callbackResult(PayChannelBean payChannel) {
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
        com.tencent.mobileqq.qwallet.utils.f.b(TAG, "callbackResult: " + payChannel);
        FragmentKt.setFragmentResult(this, "select_hb_channel_finish", bundle);
    }

    private final void initBankList(JSONObject qpayGateJSON, String newBindBankSerial) {
        PayChannelAdapter payChannelAdapter;
        Gson create = new GsonBuilder().create();
        List<PayChannelBean.Bank> createList = PayChannelBean.Bank.INSTANCE.createList(qpayGateJSON, create);
        JSONArray jSONArray = this.hbPackChannels;
        if (jSONArray == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hbPackChannels");
            jSONArray = null;
        }
        int length = jSONArray.length();
        int i3 = 0;
        PayChannelBean.QQHeader qQHeader = null;
        PayChannelBean.Wx wx5 = null;
        for (int i16 = 0; i16 < length; i16++) {
            JSONArray jSONArray2 = this.hbPackChannels;
            if (jSONArray2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hbPackChannels");
                jSONArray2 = null;
            }
            JSONObject jSONObject = jSONArray2.getJSONObject(i16);
            int optInt = jSONObject.optInt("type");
            if (optInt != 0) {
                if (optInt == 1) {
                    wx5 = (PayChannelBean.Wx) create.fromJson(jSONObject.toString(), PayChannelBean.Wx.class);
                    String str = this.tokenId;
                    if (str == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tokenId");
                        str = null;
                    }
                    wx5.setTokenId(str);
                    String str2 = this.comFrom;
                    if (str2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("comFrom");
                        str2 = null;
                    }
                    wx5.setComeFrom(str2);
                }
            } else {
                qQHeader = (PayChannelBean.QQHeader) create.fromJson(jSONObject.toString(), PayChannelBean.QQHeader.class);
            }
        }
        if (qQHeader != null && wx5 != null) {
            PayChannelBean.Balance create2 = PayChannelBean.Balance.INSTANCE.create(qpayGateJSON, create);
            PayChannelBean.AddMore.Companion companion = PayChannelBean.AddMore.INSTANCE;
            String string = getString(R.string.e4b);
            Intrinsics.checkNotNullExpressionValue(string, "getString(com.tencent.mo\u2026_tenpay_chose_other_bank)");
            String str3 = this.tokenId;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tokenId");
                str3 = null;
            }
            PayChannelBean.AddMore create3 = companion.create(qpayGateJSON, R.drawable.n9_, string, str3);
            SelectedPayChannelBean recommendPayChannel = PayChannelUtils.INSTANCE.getRecommendPayChannel(qpayGateJSON, newBindBankSerial);
            QLog.i(TAG, 1, "recommendChannel: " + recommendPayChannel);
            if (recommendPayChannel == null) {
                com.tencent.mobileqq.qwallet.c.c("extra.cantpay.record", null);
            }
            PayChannelAdapter payChannelAdapter2 = this.adapter;
            if (payChannelAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                payChannelAdapter = null;
            } else {
                payChannelAdapter = payChannelAdapter2;
            }
            PayChannelAdapter.setData$default(payChannelAdapter, qQHeader, create2, createList, wx5, create3, null, null, recommendPayChannel, false, com.tencent.luggage.wxa.rf.g.CTRL_INDEX, null);
            Button button = this.confirmButton;
            if (button == null) {
                Intrinsics.throwUninitializedPropertyAccessException("confirmButton");
                button = null;
            }
            PayChannelAdapter payChannelAdapter3 = this.adapter;
            if (payChannelAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                payChannelAdapter3 = null;
            }
            if (!payChannelAdapter3.hasAnyChannelCanUse()) {
                i3 = 8;
            }
            button.setVisibility(i3);
            return;
        }
        QLog.w(TAG, 1, "data error: qqHeader=" + qQHeader + " wxChannel=" + wx5);
    }

    static /* synthetic */ void initBankList$default(HbPayChannelFragment hbPayChannelFragment, JSONObject jSONObject, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = null;
        }
        hbPayChannelFragment.initBankList(jSONObject, str);
    }

    private final void onConfirmClick() {
        PayChannelAdapter payChannelAdapter = this.adapter;
        if (payChannelAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            payChannelAdapter = null;
        }
        PayChannelBean selectedChannel = payChannelAdapter.getSelectedChannel();
        if (selectedChannel == null) {
            QLog.w(TAG, 1, "onConfirmClick but no selected channel");
            return;
        }
        if ((selectedChannel instanceof PayChannelBean.Balance) || (selectedChannel instanceof PayChannelBean.Bank)) {
            QLog.i(TAG, 1, "onConfirmClick: " + selectedChannel);
            onPayChannelChosen$default(this, selectedChannel, false, 2, null);
        }
    }

    private final void onPayChannelChosen(PayChannelBean payChannel, boolean needDismiss) {
        callbackResult(payChannel);
        if (needDismiss) {
            dismissAllowingStateLoss();
        }
    }

    static /* synthetic */ void onPayChannelChosen$default(HbPayChannelFragment hbPayChannelFragment, PayChannelBean payChannelBean, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        hbPayChannelFragment.onPayChannelChosen(payChannelBean, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(HbPayChannelFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$4$lambda$3(HbPayChannelFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onConfirmClick();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void refreshQPayGate() {
        String str;
        Map mapOf;
        Map mutableMap;
        boolean z16;
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to("uin", com.tencent.mobileqq.base.a.c());
        String str2 = this.tokenId;
        String str3 = null;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tokenId");
            str2 = null;
        }
        pairArr[1] = TuplesKt.to("token_id", str2);
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString(PayEntryFragment.IN_KEY_COME_FROM);
        } else {
            str = null;
        }
        pairArr[2] = TuplesKt.to("come_from", str);
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : mapOf.entrySet()) {
            if (entry.getValue() != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        mutableMap = MapsKt__MapsKt.toMutableMap(linkedHashMap);
        NetSenderDelegate with = NetSender.with(getContext(), Cgi.URI_PAY_GATE, mutableMap, com.tencent.mobileqq.base.a.c());
        String str4 = this.tokenId;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tokenId");
            str4 = null;
        }
        NetSenderDelegate netSenderDelegate = with.tokenID(str4);
        String str5 = this.comFrom;
        if (str5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("comFrom");
        } else {
            str3 = str5;
        }
        netSenderDelegate.comeFrom(str3).request(new Net.NetAdapter() { // from class: com.tenpay.pay.HbPayChannelFragment$refreshQPayGate$1
            @Override // com.tenpay.sdk.paynet.Net.NetAdapter, com.tenpay.sdk.paynet.Net.NetListener
            public void onBlError(@Nullable String requestUrl, @Nullable JSONObject data) {
                if (HbPayChannelFragment.this.getContext() != null && data != null && HbPayChannelFragment.this.isVisible()) {
                    if (!new QWalletFakeUrlHandler(HbPayChannelFragment.this.getContext(), com.tencent.mobileqq.base.a.c()).handle(requestUrl, data, (FakeUrlDialogBuilder.OnClickButtonListener) null)) {
                        QQToastUtil.showQQToast(1, R.string.e_t);
                        return;
                    }
                    return;
                }
                QLog.w(HbPayChannelFragment.TAG, 1, "onBlError: context is null, early return");
            }

            @Override // com.tenpay.sdk.paynet.Net.NetAdapter, com.tenpay.sdk.paynet.Net.NetListener
            public void onSuccess(@Nullable String requestUrl, @Nullable JSONObject data) {
                if (!HbPayChannelFragment.this.isVisible()) {
                    return;
                }
                if (data == null) {
                    QQToastUtil.showQQToast(1, R.string.e_t);
                } else {
                    HbPayChannelFragment.renderQPayGate$default(HbPayChannelFragment.this, data, null, 2, null);
                }
            }
        });
    }

    public static /* synthetic */ void renderQPayGate$default(HbPayChannelFragment hbPayChannelFragment, JSONObject jSONObject, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = null;
        }
        hbPayChannelFragment.renderQPayGate(jSONObject, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0098, code lost:
    
        if (r0 != false) goto L32;
     */
    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Unit unit;
        boolean z16;
        boolean z17;
        boolean z18;
        super.onCreate(savedInstanceState);
        com.tencent.mobileqq.qwallet.utils.f.b(TAG, "onCreate: " + getArguments());
        com.tencent.mobileqq.qwallet.c.c("pay.choose.show", null);
        Bundle arguments = getArguments();
        boolean z19 = true;
        if (arguments != null) {
            String string = arguments.getString("token_id");
            String str = "";
            if (string == null) {
                string = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(string, "it.getString(KEY_TOKEN_ID) ?: \"\"");
            }
            this.tokenId = string;
            String string2 = arguments.getString("come_from");
            if (string2 != null) {
                Intrinsics.checkNotNullExpressionValue(string2, "it.getString(KEY_COME_FROM) ?: \"\"");
                str = string2;
            }
            this.comFrom = str;
            try {
                this.hbPackChannels = new JSONArray(arguments.getString(KEY_PAY_CHANNELS));
                z16 = false;
            } catch (JSONException unused) {
                QLog.e(TAG, 1, "onAttach: invalid payChannels in arguments");
                z16 = true;
            }
            String str2 = this.tokenId;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tokenId");
                str2 = null;
            }
            if (str2.length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                String str3 = this.comFrom;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("comFrom");
                    str3 = null;
                }
                if (str3.length() == 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
            }
            z16 = true;
            unit = Unit.INSTANCE;
        } else {
            unit = null;
            z16 = false;
        }
        if (unit != null) {
            z19 = z16;
        }
        if (z19) {
            onPayChannelChosen$default(this, null, false, 2, null);
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNullExpressionValue(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
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

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        callbackResult(null);
    }

    @Override // com.tenpay.pay.PayTypeItemViewHolder.IPayChannelItemClickListener
    public void onItemClick(@NotNull PayChannelBean payChannelBean, int position) {
        Intrinsics.checkNotNullParameter(payChannelBean, "payChannelBean");
        com.tencent.mobileqq.qwallet.utils.f.b(TAG, "onItemClick: " + payChannelBean + " position=" + position);
        PayChannelAdapter payChannelAdapter = null;
        if (payChannelBean instanceof PayChannelBean.Balance) {
            PayChannelAdapter payChannelAdapter2 = this.adapter;
            if (payChannelAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                payChannelAdapter = payChannelAdapter2;
            }
            payChannelAdapter.setSelectedChannel(payChannelBean, position);
            addReport("selectpay.send.click");
            return;
        }
        if (payChannelBean instanceof PayChannelBean.AddMore) {
            onPayChannelChosen(payChannelBean, false);
            return;
        }
        if (payChannelBean instanceof PayChannelBean.Wx) {
            onPayChannelChosen$default(this, payChannelBean, false, 2, null);
            addReport("selectwxpay.send.click");
            return;
        }
        if (payChannelBean instanceof PayChannelBean.More) {
            PayChannelAdapter payChannelAdapter3 = this.adapter;
            if (payChannelAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                payChannelAdapter = payChannelAdapter3;
            }
            payChannelAdapter.setMode(false);
            return;
        }
        if (payChannelBean instanceof PayChannelBean.Bank) {
            PayChannelAdapter payChannelAdapter4 = this.adapter;
            if (payChannelAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                payChannelAdapter = payChannelAdapter4;
            }
            payChannelAdapter.setSelectedChannel(payChannelBean, position);
            addReport("selectpay.send.click");
        }
    }

    @Override // com.tenpay.pay.PayTypeItemViewHolder.IPayChannelItemClickListener
    public void onMiniAppClick(@NotNull PayChannelBean payChannelBean, @NotNull PayChannelBean.MiniApp miniApp) {
        Intrinsics.checkNotNullParameter(payChannelBean, "payChannelBean");
        Intrinsics.checkNotNullParameter(miniApp, "miniApp");
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
            view2.setBackgroundResource(R.color.ajr);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        String str;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ((ImageView) view.findViewById(R.id.f164995uj2)).setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.pay.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HbPayChannelFragment.onViewCreated$lambda$2(HbPayChannelFragment.this, view2);
            }
        });
        View findViewById = view.findViewById(R.id.f27860hd);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.prodution_title_txt)");
        this.titleView = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.f166540fz1);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.price_txt)");
        TextView textView = (TextView) findViewById2;
        this.priceView = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("priceView");
            textView = null;
        }
        textView.setTypeface(QWalletUtils.c(getContext()));
        View findViewById3 = view.findViewById(R.id.f227504k);
        Button button = (Button) findViewById3;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.pay.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HbPayChannelFragment.onViewCreated$lambda$4$lambda$3(HbPayChannelFragment.this, view2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById<Button\u2026onfirmClick() }\n        }");
        this.confirmButton = button;
        this.adapter = new PayChannelAdapter(this, this);
        View findViewById4 = view.findViewById(R.id.f227904o);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.pay_channel_recycler_view)");
        RecyclerView recyclerView = (RecyclerView) findViewById4;
        this.payChannelRecyclerView = recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payChannelRecyclerView");
            recyclerView = null;
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        boolean z16 = true;
        linearLayoutManager.setOrientation(1);
        linearLayoutManager.setAutoMeasureEnabled(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        PayChannelAdapter payChannelAdapter = this.adapter;
        if (payChannelAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            payChannelAdapter = null;
        }
        recyclerView.setAdapter(payChannelAdapter);
        ((NestedScrollView) view.findViewById(R.id.f71893pd)).setNestedScrollingEnabled(false);
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString("qpay_gate");
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        }
        if (z16) {
            refreshQPayGate();
        } else {
            renderQPayGate$default(this, new JSONObject(str), null, 2, null);
        }
    }

    public final void renderQPayGate(@NotNull JSONObject data, @Nullable String newBindBankSerial) {
        Intrinsics.checkNotNullParameter(data, "data");
        QLog.i(TAG, 1, "renderQPayGate");
        this.qpayGateJSON = data;
        TextView textView = this.titleView;
        if (textView == null) {
            QLog.w(TAG, 1, "renderView but view is not initialized");
            dismissAllowingStateLoss();
            return;
        }
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            textView = null;
        }
        textView.setText(data.optString("desc"));
        TextView textView3 = this.priceView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("priceView");
        } else {
            textView2 = textView3;
        }
        textView2.setText(Utils.transformToMoney(data.optString("real_fee"), 0));
        initBankList(data, newBindBankSerial);
    }

    @Override // com.tencent.mobileqq.qwallet.QWalletBottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public void show(@NotNull FragmentManager manager, @Nullable String tag) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        try {
            super.show(manager, tag);
            addReport("selectpay.send.show");
        } catch (IllegalStateException e16) {
            QLog.e(TAG, 1, "show error", e16);
        }
    }
}
