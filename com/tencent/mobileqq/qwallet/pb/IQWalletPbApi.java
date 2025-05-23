package com.tencent.mobileqq.qwallet.pb;

import android.os.Bundle;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pb/IQWalletPbApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "requestWxQrcodePayToken", "", WadlProxyConsts.CHANNEL, "", "receiver", "Lkotlin/Function2;", "Landroid/os/Bundle;", "qqpay-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQWalletPbApi extends QRouteApi {
    void requestWxQrcodePayToken(int channel, @NotNull Function2<? super Integer, ? super Bundle, Unit> receiver);
}
