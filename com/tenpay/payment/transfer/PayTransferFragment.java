package com.tenpay.payment.transfer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.ResultReceiver;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.qwallet.utils.QWalletUtils;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.compat.f;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.qwallet.utils.k;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tenpay.payment.ChooseFriendsParser;
import com.tenpay.payment.QWalletPaymentExtKt;
import com.tenpay.sdk.QWalletFakeUrl;
import com.tenpay.sdk.activity.NetBaseActivity;
import cooperation.qzone.QzoneIPCModule;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import qk2.QrcodeConfig;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0019B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001c\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J&\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/tenpay/payment/transfer/PayTransferFragment;", "Lcom/tenpay/sdk/activity/NetBaseActivity;", "()V", "confirmBtn", "Landroid/widget/Button;", "receiverUinEdit", "Landroid/widget/EditText;", "chooseFriendForTransfer", "", "initTitleBar", "view", "Landroid/view/View;", "initView", "jumpToTransactionActivity", "uin", "", "nickName", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "ChooseQQFriendForTransferReceiver", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class PayTransferFragment extends NetBaseActivity {
    private Button confirmBtn;
    private EditText receiverUinEdit;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00030\u00030\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/tenpay/payment/transfer/PayTransferFragment$ChooseQQFriendForTransferReceiver;", "Landroid/os/ResultReceiver;", "fragment", "Lcom/tenpay/payment/transfer/PayTransferFragment;", "(Lcom/tenpay/payment/transfer/PayTransferFragment;)V", "fragmentRef", "Lmqq/util/WeakReference;", "kotlin.jvm.PlatformType", "onReceiveResult", "", QzoneIPCModule.RESULT_CODE, "", "resultData", "Landroid/os/Bundle;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class ChooseQQFriendForTransferReceiver extends ResultReceiver {

        @NotNull
        private final WeakReference<PayTransferFragment> fragmentRef;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChooseQQFriendForTransferReceiver(@NotNull PayTransferFragment fragment) {
            super(ThreadManagerV2.getUIHandlerV2());
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            this.fragmentRef = new WeakReference<>(fragment);
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int resultCode, @Nullable Bundle resultData) {
            ChooseFriendsParser.ChooseFriendResult parseResult$default;
            boolean z16;
            super.onReceiveResult(resultCode, resultData);
            if (resultCode == 0 && resultData != null && (parseResult$default = ChooseFriendsParser.parseResult$default(ChooseFriendsParser.INSTANCE, resultData, null, 2, null)) != null) {
                List<ChooseFriendsParser.Friend> friends = parseResult$default.getFriends();
                if (friends != null && !friends.isEmpty()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    ChooseFriendsParser.Friend friend = parseResult$default.getFriends().get(0);
                    PayTransferFragment payTransferFragment = this.fragmentRef.get();
                    if (payTransferFragment != null) {
                        payTransferFragment.jumpToTransactionActivity(friend.getUin(), friend.getName());
                    }
                }
            }
        }
    }

    private final void chooseFriendForTransfer() {
        ChooseQQFriendForTransferReceiver chooseQQFriendForTransferReceiver = new ChooseQQFriendForTransferReceiver(this);
        Parcel obtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
        chooseQQFriendForTransferReceiver.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        ResultReceiver resultReceiver = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(obtain);
        OaidMonitor.parcelRecycle(obtain);
        Intent intent = new Intent();
        intent.putExtra("forward_type", 15);
        intent.putExtra("choose_friend_title", getString(R.string.f2177561v));
        intent.putExtra("choose_friend_is_qqfriends", true);
        intent.putExtra("choose_friend_is_contacts", false);
        intent.putExtra("choose_friend_callback", resultReceiver);
        RouteUtils.startActivity(getOutActivity(), intent, RouterConstants.UI_ROUTE_JUMP_FORWARD_RECENT);
    }

    private final void initTitleBar(View view) {
        TextView textView = (TextView) view.findViewById(R.id.ivTitleName);
        textView.setText(getString(R.string.f21891650));
        textView.setTextColor(-1);
        ol2.b.f(textView, 0, false, 6, null);
        TextView textView2 = (TextView) view.findViewById(R.id.ivTitleBtnLeft);
        textView2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ap5, 0, 0, 0);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.payment.transfer.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PayTransferFragment.initTitleBar$lambda$2$lambda$1(PayTransferFragment.this, view2);
            }
        });
        final TextView textView3 = (TextView) view.findViewById(R.id.ivTitleBtnRightText);
        textView3.setVisibility(0);
        textView3.setBackground(null);
        textView3.setText(getString(R.string.f2177661w));
        textView3.setTextColor(-1);
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.payment.transfer.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PayTransferFragment.initTitleBar$lambda$4$lambda$3(textView3, view2);
            }
        });
        ol2.b.f(textView3, 0, false, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTitleBar$lambda$2$lambda$1(PayTransferFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.doOnBackPressed();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTitleBar$lambda$4$lambda$3(TextView textView, View view) {
        boolean z16;
        String transferRecordUrl;
        EventCollector.getInstance().onViewClickedBefore(view);
        QrcodeConfig qrcodeConfig = (QrcodeConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig("qwallet_qrcode_config", new QrcodeConfig(null, null, null, null, null, 31, null));
        String transferRecordUrl2 = qrcodeConfig.getTransferRecordUrl();
        if (transferRecordUrl2 != null && transferRecordUrl2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            transferRecordUrl = "https://myun.tenpay.com/mqq/myun/trade/record.shtml?_wv=2&_wwv=4&_wvx=10&_disablePadCompact=1&jump_type=payment";
        } else {
            transferRecordUrl = qrcodeConfig.getTransferRecordUrl();
        }
        k.h(textView.getContext(), transferRecordUrl);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void initView(View view) {
        View it = view.findViewById(R.id.f230305b);
        QWalletUtils.v(it, 8.0f);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        ol2.b.b(it, 0, false, 6, null);
        ol2.b.f(view.findViewById(R.id.f234206d), 20, false, 4, null);
        View findViewById = view.findViewById(R.id.f234006b);
        final Button button = (Button) findViewById;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.payment.transfer.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PayTransferFragment.initView$lambda$8$lambda$7(PayTransferFragment.this, button, view2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById<Button\u2026)\n            }\n        }");
        this.confirmBtn = button;
        View findViewById2 = view.findViewById(R.id.f234106c);
        EditText editText = (EditText) findViewById2;
        editText.addTextChangedListener(new TextWatcher() { // from class: com.tenpay.payment.transfer.PayTransferFragment$initView$4$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable s16) {
                int i3;
                Button button2;
                Button button3;
                String str;
                boolean z16 = false;
                if (s16 != null) {
                    i3 = s16.length();
                } else {
                    i3 = 0;
                }
                if (i3 > 4) {
                    z16 = true;
                }
                button2 = PayTransferFragment.this.confirmBtn;
                Button button4 = null;
                if (button2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
                    button2 = null;
                }
                button2.setEnabled(z16);
                button3 = PayTransferFragment.this.confirmBtn;
                if (button3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
                } else {
                    button4 = button3;
                }
                button4.setClickable(z16);
                if (z16) {
                    str = "transfer.qqid.enable";
                } else {
                    str = "transfer.qqid.disable";
                }
                com.tencent.mobileqq.qwallet.c.f(str, null, null, null, null, 30, null);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById<EditTe\u2026\n            })\n        }");
        this.receiverUinEdit = editText;
        View it5 = view.findViewById(R.id.f233906a);
        Intrinsics.checkNotNullExpressionValue(it5, "it");
        ol2.b.b(it5, 0, false, 6, null);
        QWalletUtils.v(it5, 8.0f);
        it5.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.payment.transfer.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PayTransferFragment.initView$lambda$11$lambda$10(PayTransferFragment.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$11$lambda$10(PayTransferFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.chooseFriendForTransfer();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8$lambda$7(PayTransferFragment this$0, Button initView$lambda$8$lambda$7, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EditText editText = this$0.receiverUinEdit;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("receiverUinEdit");
            editText = null;
        }
        String obj = editText.getText().toString();
        Intrinsics.checkNotNullExpressionValue(initView$lambda$8$lambda$7, "initView$lambda$8$lambda$7");
        boolean z16 = true;
        QLog.i(QWalletPaymentExtKt.getPaymentTag(initView$lambda$8$lambda$7), 1, "confirm transfer: " + obj);
        if (obj.length() != 0) {
            z16 = false;
        }
        if (!z16) {
            jumpToTransactionActivity$default(this$0, obj, null, 2, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void jumpToTransactionActivity(String uin, String nickName) {
        QLog.i(QWalletPaymentExtKt.getPaymentTag(this), 1, "start trans activity uin = " + uin);
        FragmentActivity outActivity = getOutActivity();
        if (outActivity != null && !outActivity.isFinishing()) {
            Intent intent = new Intent();
            intent.putExtra("tag", QWalletFakeUrl.FAKEURL_TRANSFERINPUT);
            intent.putExtra("avoidInput", true);
            intent.putExtra("isJumpToH5", true);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(IProfileProtocolConst.PARAM_TARGET_UIN, uin);
                if (nickName != null) {
                    jSONObject.put("targetNickname", nickName);
                }
                intent.putExtra("extra_data", jSONObject.toString());
                RouteUtils.startActivity(outActivity, intent, "/qwallet/transaction");
                return;
            } catch (JSONException e16) {
                QLog.e(QWalletPaymentExtKt.getPaymentTag(this), 1, "gotoTransPage", e16);
                return;
            }
        }
        QLog.w(QWalletPaymentExtKt.getPaymentTag(this), 1, "start trans activity fail");
    }

    static /* synthetic */ void jumpToTransactionActivity$default(PayTransferFragment payTransferFragment, String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = null;
        }
        payTransferFragment.jumpToTransactionActivity(str, str2);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fyv, container, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initTitleBar(view);
        initView(view);
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
