package com.tenpay.pay.friendpay;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.richframework.compat.f;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import com.tencent.mobileqq.base.a;
import com.tencent.mobileqq.base.c;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.impl.ApiInterfaceImpl;
import com.tenpay.pay.model.PayChannelBean;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \b2\u00020\u0001:\u0002\b\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tenpay/pay/friendpay/FriendPayProxyFragment;", "Lcom/tencent/mobileqq/base/QWalletBaseFragment;", "()V", "onCreate", "", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "sendFriendPayRequest", "Companion", "FriendPayReceiver", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class FriendPayProxyFragment extends QWalletBaseFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_PAY_DATA = "KEY_PAY_DATA";

    @NotNull
    private static final String TAG = "CFT-sdk-FriendPayProxyFragment";

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tenpay/pay/friendpay/FriendPayProxyFragment$Companion;", "", "()V", FriendPayProxyFragment.KEY_PAY_DATA, "", "TAG", "start", "", "data", "Lcom/tenpay/pay/model/PayChannelBean$FriendPay;", WadlProxyConsts.EXTRA_DATA, "Landroid/os/Bundle;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@NotNull PayChannelBean.FriendPay data, @NotNull Bundle extraData) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(extraData, "extraData");
            Intent intent = new Intent();
            intent.putExtra(FriendPayProxyFragment.KEY_PAY_DATA, data);
            intent.putExtras(extraData);
            intent.addFlags(268435456);
            c.f(MobileQQ.sMobileQQ, intent, FriendPayProxyFragment.class, false, 8, null);
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014R\u001c\u0010\u0006\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00040\u00040\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tenpay/pay/friendpay/FriendPayProxyFragment$FriendPayReceiver;", "Landroid/os/ResultReceiver;", "realResultReceiver", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroid/os/ResultReceiver;Landroidx/fragment/app/Fragment;)V", "fragmentRef", "Lmqq/util/WeakReference;", "kotlin.jvm.PlatformType", "onReceiveResult", "", QzoneIPCModule.RESULT_CODE, "", "resultData", "Landroid/os/Bundle;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class FriendPayReceiver extends ResultReceiver {

        @NotNull
        private final WeakReference<Fragment> fragmentRef;

        @Nullable
        private final ResultReceiver realResultReceiver;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FriendPayReceiver(@Nullable ResultReceiver resultReceiver, @NotNull Fragment fragment) {
            super(ThreadManagerV2.getUIHandlerV2());
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            this.realResultReceiver = resultReceiver;
            this.fragmentRef = new WeakReference<>(fragment);
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int resultCode, @Nullable Bundle resultData) {
            Boolean bool;
            Fragment fragment = this.fragmentRef.get();
            if (fragment != null && !fragment.isRemoving()) {
                ResultReceiver resultReceiver = this.realResultReceiver;
                if (resultReceiver != null) {
                    resultReceiver.send(resultCode, resultData);
                }
                FragmentActivity activity = fragment.getActivity();
                if (activity != null) {
                    activity.finish();
                    return;
                }
                return;
            }
            if (fragment != null) {
                bool = Boolean.valueOf(fragment.isRemoving());
            } else {
                bool = null;
            }
            QLog.w(FriendPayProxyFragment.TAG, 1, "onReceiveResult but activity finish! isRemoving=" + bool);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0079 A[Catch: Exception -> 0x0093, TRY_LEAVE, TryCatch #0 {Exception -> 0x0093, blocks: (B:13:0x002d, B:15:0x006d, B:20:0x0079), top: B:12:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void sendFriendPayRequest() {
        Bundle extras;
        PayChannelBean.FriendPay friendPay;
        boolean z16;
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            Parcelable parcelable = extras.getParcelable(KEY_PAY_DATA);
            if (parcelable instanceof PayChannelBean.FriendPay) {
                friendPay = (PayChannelBean.FriendPay) parcelable;
            } else {
                friendPay = null;
            }
            if (friendPay == null) {
                QLog.e(TAG, 1, "payData is null");
                finish();
                return;
            }
            try {
                ArrayList<String> stringArrayList = extras.getStringArrayList("choose_friend_uins");
                String string = extras.getString("choose_friend_feedback");
                ResultReceiver resultReceiver = (ResultReceiver) extras.getParcelable("callback");
                QLog.i(TAG, 1, "onReceiveResult, uins=" + stringArrayList + ", message=" + string + " callback=" + resultReceiver);
                if (stringArrayList != null && !stringArrayList.isEmpty()) {
                    z16 = false;
                    if (z16) {
                        new ApiInterfaceImpl().sendFriendPayRequest(getContext(), friendPay.getPayTokenId(), a.c(), stringArrayList, string, new FriendPayReceiver(resultReceiver, this));
                        return;
                    }
                    return;
                }
                z16 = true;
                if (z16) {
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, "onReceiveResult:", e16);
            }
        } else {
            QLog.e(TAG, 1, "resultData is null");
            finish();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sendFriendPayRequest();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
