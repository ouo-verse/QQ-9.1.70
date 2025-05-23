package com.tencent.mobileqq.zootopia.ipc;

import com.tencent.mobileqq.zplan.ipc.annotation.ServletImpl;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&JH\u0010\u000f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u000eH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ipc/al;", "", "", "appId", "Lcom/tencent/mobileqq/zootopia/ipc/t;", "callback", "", "fetchWxCode", "", "timestamp", PayProxy.Source.PAY_REQUEST_NONCE_STR_KEY, "packageStr", PayProxy.Source.PAY_REQUEST_SIGN_TYPE_KEY, PayProxy.Source.PAY_REQUEST_PAY_SIGN_KEY, "Lcom/tencent/mobileqq/zootopia/ipc/am;", "requestWxPay", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
@ServletImpl(impl = ZootopiaWxMiniApiForZplanProcessIPCImpl.class)
/* loaded from: classes35.dex */
public interface al {
    void fetchWxCode(String appId, t callback);

    void requestWxPay(String appId, long timestamp, String nonceStr, String packageStr, String signType, String paySign, am callback);
}
