package com.tenpay.payment.grouppay;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.ResultReceiver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.gson.GsonBuilder;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qwallet.utils.QWalletUtils;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.compat.f;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qwallet.utils.k;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.QQToastUtil;
import com.tenpay.payment.ChooseFriendsParser;
import com.tenpay.payment.QWalletPaymentExtKt;
import com.tenpay.sdk.activity.NetBaseActivity;
import cooperation.qzone.QzoneIPCModule;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0002\u0014\u0015B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0002J&\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tenpay/payment/grouppay/GroupPaymentFragment;", "Lcom/tenpay/sdk/activity/NetBaseActivity;", "()V", "chooseFriendReceiver", "Lcom/tenpay/payment/grouppay/GroupPaymentFragment$ChooseFriendReceiver;", "contentRoot", "Landroid/view/View;", "chooseGroupReceiver", "", "initTitleBar", "view", "initView", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "ChooseFriendReceiver", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class GroupPaymentFragment extends NetBaseActivity {

    @NotNull
    private static final String URL_GROUP_PAYMENT_RECEIVE_INDEX = "https://mqq.tenpay.com/mqq/groupreceipts/index.shtml?_wv=1027&_wvx=4&from=1";

    @NotNull
    private static final String URL_RECEIVE_RECORD = "https://mqq.tenpay.com/mqq/groupreceipts/record.shtml?_wv=1027&_wvx=4&_vacf=qw";

    @Nullable
    private ChooseFriendReceiver chooseFriendReceiver;
    private View contentRoot;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014\u00a8\u0006\n"}, d2 = {"Lcom/tenpay/payment/grouppay/GroupPaymentFragment$ChooseFriendReceiver;", "Landroid/os/ResultReceiver;", "()V", "onReceiveResult", "", QzoneIPCModule.RESULT_CODE, "", "resultData", "Landroid/os/Bundle;", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class ChooseFriendReceiver extends ResultReceiver {

        @NotNull
        private static final String CHOOSE_ERROR_TIP;

        static {
            String string = BaseApplication.context.getString(R.string.f21781621);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026payment_tips_no_receiver)");
            CHOOSE_ERROR_TIP = string;
        }

        public ChooseFriendReceiver() {
            super(ThreadManagerV2.getUIHandlerV2());
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int resultCode, @Nullable Bundle resultData) {
            List<Integer> listOf;
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            super.onReceiveResult(resultCode, resultData);
            if (resultCode == 0 && resultData != null) {
                ChooseFriendsParser chooseFriendsParser = ChooseFriendsParser.INSTANCE;
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{4, 8});
                ChooseFriendsParser.ChooseFriendResult parseResult = chooseFriendsParser.parseResult(resultData, listOf);
                QLog.i(QWalletPaymentExtKt.getPaymentTag(this), 1, "ChooseFriends result: " + parseResult);
                if (parseResult == null) {
                    QQToastUtil.showQQToast(1, CHOOSE_ERROR_TIP);
                    return;
                }
                List<ChooseFriendsParser.Friend> friends = parseResult.getFriends();
                if (friends != null && !friends.isEmpty()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    List<ChooseFriendsParser.Group> groups = parseResult.getGroups();
                    if (groups != null && !groups.isEmpty()) {
                        z19 = false;
                    } else {
                        z19 = true;
                    }
                    if (z19) {
                        QLog.w(QWalletPaymentExtKt.getPaymentTag(this), 1, "ChooseFriendReceiver onReceiveResult: data error");
                        return;
                    }
                }
                if (parseResult.getGroups() != null && (!r10.isEmpty())) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    ChooseFriendsParser.Group group = parseResult.getGroups().get(0);
                    StringBuilder sb5 = new StringBuilder(GroupPaymentFragment.URL_GROUP_PAYMENT_RECEIVE_INDEX);
                    try {
                        JSONObject jSONObject = new JSONObject(new GsonBuilder().create().toJson(group));
                        Iterator keys = jSONObject.keys();
                        Intrinsics.checkNotNullExpressionValue(keys, "keys");
                        while (keys.hasNext()) {
                            String str = (String) keys.next();
                            sb5.append(ContainerUtils.FIELD_DELIMITER);
                            sb5.append(str);
                            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                            sb5.append(URLEncoder.encode(jSONObject.optString(str), "utf-8"));
                        }
                        k.h(BaseApplication.context, sb5.toString());
                        return;
                    } catch (Exception e16) {
                        QLog.w(QWalletPaymentExtKt.getPaymentTag(this), 1, "receive group error", e16);
                    }
                }
                if (parseResult.getFriends() != null && (!r10.isEmpty())) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    ChooseFriendsParser.Friend friend = parseResult.getFriends().get(0);
                    StringBuilder sb6 = new StringBuilder(GroupPaymentFragment.URL_GROUP_PAYMENT_RECEIVE_INDEX);
                    sb6.append("&frienduin=");
                    sb6.append(friend.getUin());
                    sb6.append("&name=");
                    sb6.append(URLEncoder.encode(friend.getName(), "utf-8"));
                    QLog.i(QWalletPaymentExtKt.getPaymentTag(this), 1, "choose friend finish: " + ((Object) sb6));
                    k.h(BaseApplication.context, sb6.toString());
                    return;
                }
                QQToastUtil.showQQToast(1, CHOOSE_ERROR_TIP);
            }
        }
    }

    private final void chooseGroupReceiver() {
        try {
            ChooseFriendReceiver chooseFriendReceiver = this.chooseFriendReceiver;
            if (chooseFriendReceiver == null) {
                chooseFriendReceiver = new ChooseFriendReceiver();
                this.chooseFriendReceiver = chooseFriendReceiver;
            }
            Parcel obtain = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
            chooseFriendReceiver.writeToParcel(obtain, 0);
            obtain.setDataPosition(0);
            ResultReceiver resultReceiver = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(obtain);
            OaidMonitor.parcelRecycle(obtain);
            Intent intent = new Intent();
            intent.putExtra("forward_type", 15);
            intent.putExtra("choose_friend_title", "\u9009\u62e9\u53c2\u4e0e\u4eba");
            intent.putExtra("choose_friend_is_qqfriends", true);
            intent.putExtra("choose_friend_is_groupchats", true);
            intent.putExtra("choose_friend_is_create_group_chat", true);
            intent.putExtra("choose_friend_callback", resultReceiver);
            intent.putExtra("choose_friend_businessType", 0);
            intent.putExtra("choose_friend_businessSubType", 0);
            RouteUtils.startActivity(getOutActivity(), intent, RouterConstants.UI_ROUTE_JUMP_FORWARD_RECENT);
        } catch (Exception e16) {
            QLog.e(QWalletPaymentExtKt.getPaymentTag(this), 1, "chooseGroupReceiver error", e16);
        }
    }

    private final void initTitleBar(View view) {
        TextView textView = (TextView) view.findViewById(R.id.ivTitleName);
        textView.setText(getString(R.string.f21782622));
        textView.setTextColor(-1);
        TextView textView2 = (TextView) view.findViewById(R.id.ivTitleBtnLeft);
        textView2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ap5, 0, 0, 0);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.payment.grouppay.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GroupPaymentFragment.initTitleBar$lambda$2$lambda$1(GroupPaymentFragment.this, view2);
            }
        });
        TextView textView3 = (TextView) view.findViewById(R.id.ivTitleBtnRightText);
        textView3.setVisibility(0);
        textView3.setBackground(null);
        textView3.setText(getString(R.string.f2177961z));
        textView3.setTextColor(-1);
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.payment.grouppay.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GroupPaymentFragment.initTitleBar$lambda$4$lambda$3(GroupPaymentFragment.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTitleBar$lambda$2$lambda$1(GroupPaymentFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.doOnBackPressed();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTitleBar$lambda$4$lambda$3(GroupPaymentFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        k.h(this$0.getOutActivity(), URL_RECEIVE_RECORD);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void initView(View view) {
        View findViewById = view.findViewById(R.id.f230305b);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.payment_content_container)");
        this.contentRoot = findViewById;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentRoot");
            findViewById = null;
        }
        QWalletUtils.v(findViewById, 8.0f);
        ((Button) view.findViewById(R.id.f230405c)).setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.payment.grouppay.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GroupPaymentFragment.initView$lambda$6$lambda$5(GroupPaymentFragment.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6$lambda$5(GroupPaymentFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.chooseGroupReceiver();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fye, container, false);
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
