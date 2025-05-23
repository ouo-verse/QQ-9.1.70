package com.tencent.mobileqq.qwallet.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J \u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\fH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qwallet/api/IQWalletDebugApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "clearCftSKey", "", "dropAioPaymentMsgDb", "getPayChannelHeightRate", "", "default", "testPaySuccess", "context", "Landroid/content/Context;", "bargainerId", "", "offerId", "testTransKuiklyPage", "path", "qwallet-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQWalletDebugApi extends QRouteApi {
    void clearCftSKey();

    void dropAioPaymentMsgDb();

    double getPayChannelHeightRate(double r16);

    void testPaySuccess(@NotNull Context context, @NotNull String bargainerId, @NotNull String offerId);

    void testTransKuiklyPage(@NotNull Context context, @NotNull String path);
}
