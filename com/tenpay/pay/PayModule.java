package com.tenpay.pay;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J>\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tenpay/pay/PayModule;", "", "()V", "TAG", "", "startHbPay", "", "context", "Landroid/content/Context;", "payChannels", "Lorg/json/JSONArray;", "payTokenId", "comeFrom", "sourceId", "requestCode", "", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class PayModule {

    @NotNull
    public static final PayModule INSTANCE = new PayModule();

    @NotNull
    public static final String TAG = "CFT-sdk-";

    PayModule() {
    }

    public final void startHbPay(@NotNull Context context, @Nullable JSONArray payChannels, @Nullable String payTokenId, @Nullable String comeFrom, @Nullable String sourceId, int requestCode) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        if (payChannels != null) {
            str = payChannels.toString();
        } else {
            str = null;
        }
        intent.putExtra(PayEntryFragment.IN_KEY_PAY_CHANNEL, str);
        intent.putExtra(PayEntryFragment.IN_KEY_TOKEN_ID, payTokenId);
        intent.putExtra(PayEntryFragment.IN_KEY_COME_FROM, comeFrom);
        intent.putExtra(PayEntryFragment.IN_KEY_SOURCE_ID, sourceId);
        com.tencent.mobileqq.base.c.i(context, intent, PayEntryFragment.class, requestCode, false, 16, null);
    }
}
