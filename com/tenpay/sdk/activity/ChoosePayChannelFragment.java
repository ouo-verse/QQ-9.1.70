package com.tenpay.sdk.activity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qwallet.WeakFragmentReceiver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tenpay.api.BankImageUtil;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.helper.WechatPayHelper;
import com.tenpay.sdk.net.NetSender;
import com.tenpay.sdk.paynet.NetSenderDelegate;
import java.util.List;
import java.util.Map;
import java.util.Random;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u000f\u0018\u0000 -2\u00020\u0001:\u0001-B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u0012H\u0016J\u0010\u0010#\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u000bH\u0002J\b\u0010$\u001a\u00020\u0012H\u0016J\u001a\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010'\u001a\u00020\u0012H\u0002J\u001a\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010,\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0010\u00a8\u0006."}, d2 = {"Lcom/tenpay/sdk/activity/ChoosePayChannelFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "callback", "Landroid/os/ResultReceiver;", "comFrom", "", "payChannels", "Lorg/json/JSONArray;", "tokenId", "transSeq", "", "wechatPayHelper", "Lcom/tenpay/sdk/helper/WechatPayHelper;", "wxPayCallback", "com/tenpay/sdk/activity/ChoosePayChannelFragment$wxPayCallback$1", "Lcom/tenpay/sdk/activity/ChoosePayChannelFragment$wxPayCallback$1;", "addReport", "", "action", "initWeChatPay", "payChannel", "Lorg/json/JSONObject;", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onPayChannelChosen", "onStart", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "view", "registerWxPayCallback", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "startWeChatPay", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class ChoosePayChannelFragment extends BottomSheetDialogFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_CALLBACK = "callback";

    @NotNull
    private static final String KEY_COME_FROM = "come_from";

    @NotNull
    private static final String KEY_PAY_CHANNELS = "pay_channels";

    @NotNull
    private static final String KEY_TOKEN_ID = "token_id";

    @NotNull
    private static final String TAG = "ChoosePayChannelFragment";

    @Nullable
    private ResultReceiver callback;
    private String comFrom;
    private JSONArray payChannels;
    private String tokenId;

    @NotNull
    private final WechatPayHelper wechatPayHelper = new WechatPayHelper();
    private final int transSeq = Math.abs(new Random().nextInt()) % 16;

    @NotNull
    private final ChoosePayChannelFragment$wxPayCallback$1 wxPayCallback = new WeakFragmentReceiver<ChoosePayChannelFragment>(this) { // from class: com.tenpay.sdk.activity.ChoosePayChannelFragment$wxPayCallback$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(this);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@Nullable Context context, @Nullable Intent intent) {
            String action;
            if (intent != null && (action = intent.getAction()) != null) {
                QLog.i("ChoosePayChannelFragment", 1, "receive wx callback: " + action);
                if (Intrinsics.areEqual("broadcast_wx_pay_callback", action)) {
                    int intExtra = intent.getIntExtra("errCode", -1);
                    QLog.i("ChoosePayChannelFragment", 1, "wx callback retCode: " + intExtra);
                    if (intExtra == 0) {
                        MobileQQ.sMobileQQ.sendBroadcast(new Intent("com.tencent.mobileqq.qwallet.send.message"));
                    }
                }
                if (context != null) {
                    try {
                        context.unregisterReceiver(this);
                    } catch (Exception e16) {
                        QLog.w("ChoosePayChannelFragment", 1, "unregisterReceiver error:", e16);
                    }
                }
            }
        }
    };

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tenpay/sdk/activity/ChoosePayChannelFragment$Companion;", "", "()V", "KEY_CALLBACK", "", "KEY_COME_FROM", "KEY_PAY_CHANNELS", "KEY_TOKEN_ID", "TAG", "newInstance", "Landroidx/fragment/app/DialogFragment;", "payChannels", "Lorg/json/JSONArray;", "tokenId", "comFrom", "callback", "Landroid/os/ResultReceiver;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DialogFragment newInstance(@NotNull JSONArray payChannels, @NotNull String tokenId, @NotNull String comFrom, @NotNull ResultReceiver callback) {
            Intrinsics.checkNotNullParameter(payChannels, "payChannels");
            Intrinsics.checkNotNullParameter(tokenId, "tokenId");
            Intrinsics.checkNotNullParameter(comFrom, "comFrom");
            Intrinsics.checkNotNullParameter(callback, "callback");
            ChoosePayChannelFragment choosePayChannelFragment = new ChoosePayChannelFragment();
            Bundle bundle = new Bundle();
            bundle.putString("pay_channels", payChannels.toString());
            bundle.putString("token_id", tokenId);
            bundle.putString("come_from", comFrom);
            bundle.putParcelable("callback", callback);
            choosePayChannelFragment.setArguments(bundle);
            return choosePayChannelFragment;
        }

        Companion() {
        }
    }

    private final void addReport(String action) {
        com.tencent.mobileqq.qwallet.c.e(action, "", "", "", AppSetting.f99551k);
    }

    private final void initWeChatPay(JSONObject payChannel) {
        this.wechatPayHelper.registerApp(payChannel.optString("appid"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onPayChannelChosen(int payChannel) {
        ResultReceiver resultReceiver = this.callback;
        if (resultReceiver != null) {
            resultReceiver.send(payChannel, null);
        }
        dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(ChoosePayChannelFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$5$lambda$4$lambda$3(int i3, ChoosePayChannelFragment this$0, JSONObject payChannel, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != 0) {
            if (i3 == 1) {
                Intrinsics.checkNotNullExpressionValue(payChannel, "payChannel");
                this$0.startWeChatPay(payChannel);
                this$0.addReport("selectwxpay.send.click");
            }
        } else {
            this$0.onPayChannelChosen(i3);
            this$0.addReport("selectqqpay.send.click");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerWxPayCallback() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("broadcast_wx_pay_callback");
        try {
            Context context = getContext();
            if (context != null) {
                context.registerReceiver(this.wxPayCallback, intentFilter);
            }
        } catch (Exception e16) {
            QLog.w(TAG, 1, "registerWxPayCallback error:", e16);
        }
    }

    private final void startWeChatPay(JSONObject payChannel) {
        Map mutableMapOf;
        String optString = payChannel.optString("info");
        String optString2 = payChannel.optString("url");
        if (!TextUtils.isEmpty(optString2) && this.wechatPayHelper.canJumpToWxMiniProgram()) {
            com.tencent.mobileqq.qwallet.utils.k.h(getActivity(), optString2);
            onPayChannelChosen(1);
            return;
        }
        String c16 = com.tencent.mobileqq.base.a.c();
        Pair[] pairArr = new Pair[4];
        String str = this.comFrom;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("comFrom");
            str = null;
        }
        pairArr[0] = TuplesKt.to("come_from", str);
        String str3 = this.tokenId;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tokenId");
            str3 = null;
        }
        pairArr[1] = TuplesKt.to("token_id", str3);
        pairArr[2] = TuplesKt.to("wxpay_auth", optString);
        pairArr[3] = TuplesKt.to("uin", c16);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        NetSenderDelegate with = NetSender.with(getContext(), Cgi.URI_QPAY_HB_WXPACK, mutableMapOf, c16);
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
            str2 = str5;
        }
        netSenderDelegate.comeFrom(str2).request(new ChoosePayChannelFragment$startWeChatPay$1(this));
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x008f, code lost:
    
        if (r6.callback != null) goto L36;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onAttach(@NotNull Context context) {
        boolean z16;
        byte b16;
        byte b17;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        Bundle arguments = getArguments();
        Unit unit = null;
        String str = null;
        boolean z17 = true;
        if (arguments != null) {
            this.callback = (ResultReceiver) arguments.getParcelable("callback");
            String string = arguments.getString("token_id");
            String str2 = "";
            if (string == null) {
                string = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(string, "it.getString(KEY_TOKEN_ID) ?: \"\"");
            }
            this.tokenId = string;
            String string2 = arguments.getString("come_from");
            if (string2 != null) {
                Intrinsics.checkNotNullExpressionValue(string2, "it.getString(KEY_COME_FROM) ?: \"\"");
                str2 = string2;
            }
            this.comFrom = str2;
            try {
                this.payChannels = new JSONArray(arguments.getString("pay_channels"));
                z16 = false;
            } catch (JSONException unused) {
                QLog.e(TAG, 1, "onAttach: invalid payChannels in arguments");
                z16 = true;
            }
            String str3 = this.tokenId;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tokenId");
                str3 = null;
            }
            if (str3.length() == 0) {
                b16 = true;
            } else {
                b16 = false;
            }
            if (b16 == false) {
                String str4 = this.comFrom;
                if (str4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("comFrom");
                } else {
                    str = str4;
                }
                if (str.length() == 0) {
                    b17 = true;
                } else {
                    b17 = false;
                }
                if (b17 == false) {
                }
            }
            z16 = true;
            unit = Unit.INSTANCE;
        } else {
            z16 = false;
        }
        if (unit != null) {
            z17 = z16;
        }
        if (z17) {
            onPayChannelChosen(0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fy7, container, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.wechatPayHelper.release();
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
        List listOf;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ((ImageView) view.findViewById(R.id.f164995uj2)).setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ChoosePayChannelFragment.onViewCreated$lambda$2(ChoosePayChannelFragment.this, view2);
            }
        });
        int i3 = 0;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.id.f227604l), Integer.valueOf(R.id.f227704m)});
        for (Object obj : listOf) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            int intValue = ((Number) obj).intValue();
            JSONArray jSONArray = this.payChannels;
            if (jSONArray == null) {
                Intrinsics.throwUninitializedPropertyAccessException("payChannels");
                jSONArray = null;
            }
            final JSONObject payChannel = jSONArray.getJSONObject(i3);
            final int optInt = payChannel.optInt("type");
            if (optInt == 1) {
                Intrinsics.checkNotNullExpressionValue(payChannel, "payChannel");
                initWeChatPay(payChannel);
            }
            View findViewById = view.findViewById(intValue);
            ((TextView) findViewById.findViewById(R.id.title)).setText(payChannel.optString("title"));
            BankImageUtil.getInstance(findViewById.getContext()).setBankImage(payChannel.optString("logo_id"), (ImageView) findViewById.findViewById(R.id.f166149eh4));
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.aa
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ChoosePayChannelFragment.onViewCreated$lambda$5$lambda$4$lambda$3(optInt, this, payChannel, view2);
                }
            });
            i3 = i16;
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(@NotNull FragmentManager manager, @Nullable String tag) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        super.show(manager, tag);
        addReport("selectpay.send.show");
    }
}
