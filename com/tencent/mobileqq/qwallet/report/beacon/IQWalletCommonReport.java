package com.tencent.mobileqq.qwallet.report.beacon;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRemote;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\tH&J<\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\f2\u0006\u0010\r\u001a\u00020\u000eH'\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/report/beacon/IQWalletCommonReport;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "report", "", "eventCode", "", "reportBean", "", "params", "", "reportRemote", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "sampleRate", "", "qqpay-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQWalletCommonReport extends QRouteApi {
    void report(@NotNull String eventCode, @NotNull Object reportBean);

    void report(@NotNull String eventCode, @NotNull Map<String, String> params);

    @QRemote
    void reportRemote(@NotNull String eventCode, @NotNull HashMap<String, String> params, int sampleRate);
}
