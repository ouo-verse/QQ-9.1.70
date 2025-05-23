package com.tencent.mobileqq.qwallet.api.impl;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.qwallet.api.IQWalletDebugApi;
import com.tencent.mobileqq.qwallet.home.pop.QWalletHomeKuiklyPopFragment;
import com.tencent.mobileqq.qwallet.pay.k;
import com.tencent.mobileqq.qwallet.utils.g;
import com.tencent.qqnt.qwallet.db.QWalletDBManager;
import com.tenpay.sdk.net.core.comm.CftSKeyCacheUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J \u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\rH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qwallet/api/impl/QWalletDebugApiImpl;", "Lcom/tencent/mobileqq/qwallet/api/IQWalletDebugApi;", "()V", "clearCftSKey", "", "dropAioPaymentMsgDb", "getPayChannelHeightRate", "", "default", "testPaySuccess", "context", "Landroid/content/Context;", "bargainerId", "", "offerId", "testTransKuiklyPage", "path", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class QWalletDebugApiImpl implements IQWalletDebugApi {
    @Override // com.tencent.mobileqq.qwallet.api.IQWalletDebugApi
    public void clearCftSKey() {
        CftSKeyCacheUtils.INSTANCE.clearCftSKey(com.tencent.mobileqq.base.a.c());
    }

    @Override // com.tencent.mobileqq.qwallet.api.IQWalletDebugApi
    public void dropAioPaymentMsgDb() {
        QWalletDBManager.f361825a.n();
    }

    @Override // com.tencent.mobileqq.qwallet.api.IQWalletDebugApi
    public void testPaySuccess(@NotNull Context context, @NotNull String bargainerId, @NotNull String offerId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bargainerId, "bargainerId");
        Intrinsics.checkNotNullParameter(offerId, "offerId");
        Intent intent = new Intent();
        intent.putExtra("bargainor_id", bargainerId);
        intent.putExtra("offer_id", offerId);
        intent.putExtra("ad_display", 1);
        intent.putExtra("show_native_paysucc", true);
        intent.putExtra("goods_name", "\u624b\u673a\u5145\u503c");
        intent.putExtra("total_fee", "200");
        intent.putExtra("isShowFinanceAd", true);
        intent.putExtra("enableRequest", g.b("qwallet_key_pay_success_with_ad"));
        k.a(context, intent);
    }

    @Override // com.tencent.mobileqq.qwallet.api.IQWalletDebugApi
    public void testTransKuiklyPage(@NotNull Context context, @NotNull String path) {
        FragmentActivity fragmentActivity;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(path, "path");
        QWalletHomeKuiklyPopFragment.Companion companion = QWalletHomeKuiklyPopFragment.INSTANCE;
        if (context instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) context;
        } else {
            fragmentActivity = null;
        }
        QWalletHomeKuiklyPopFragment.Companion.c(companion, fragmentActivity, path, null, null, 12, null);
    }

    @Override // com.tencent.mobileqq.qwallet.api.IQWalletDebugApi
    public double getPayChannelHeightRate(double r16) {
        return r16;
    }
}
