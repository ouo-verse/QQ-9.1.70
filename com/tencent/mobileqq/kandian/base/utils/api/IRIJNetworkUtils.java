package com.tencent.mobileqq.kandian.base.utils.api;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u001c\u0010\u0006\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/kandian/base/utils/api/IRIJNetworkUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "debugReceivePb", "", "reply", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "debugSendPb", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "data", "", "cmd", "", "kandian-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IRIJNetworkUtils extends QRouteApi {
    void debugReceivePb(@Nullable FromServiceMsg reply);

    void debugSendPb(@Nullable ToServiceMsg request);

    void debugSendPb(@Nullable byte[] data, @Nullable String cmd);
}
