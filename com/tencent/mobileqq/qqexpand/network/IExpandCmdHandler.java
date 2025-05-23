package com.tencent.mobileqq.qqexpand.network;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J.\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH&J.\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/network/IExpandCmdHandler;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "appInterface", "", "cmdString", "", "buffer", "Lcom/tencent/mobileqq/qqexpand/network/d;", "callback", "", "sendSSORequest", "sendDirectConnectSSORequest", "qqexpand-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IExpandCmdHandler extends QRouteApi {
    void sendDirectConnectSSORequest(@NotNull BaseQQAppInterface appInterface, @Nullable String cmdString, @Nullable byte[] buffer, @Nullable d callback);

    void sendSSORequest(@NotNull BaseQQAppInterface appInterface, @Nullable String cmdString, @Nullable byte[] buffer, @Nullable d callback);
}
