package com.tencent.mobileqq.kandian.base.utils.api.impl;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.kandian.base.utils.a;
import com.tencent.mobileqq.kandian.base.utils.api.IRIJNetworkUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\u0007\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/kandian/base/utils/api/impl/RIJNetworkUtilsImpl;", "Lcom/tencent/mobileqq/kandian/base/utils/api/IRIJNetworkUtils;", "()V", "debugReceivePb", "", "reply", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "debugSendPb", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "data", "", "cmd", "", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class RIJNetworkUtilsImpl implements IRIJNetworkUtils {
    @Override // com.tencent.mobileqq.kandian.base.utils.api.IRIJNetworkUtils
    public void debugReceivePb(FromServiceMsg reply) {
        a.a(reply);
    }

    @Override // com.tencent.mobileqq.kandian.base.utils.api.IRIJNetworkUtils
    public void debugSendPb(byte[] data, String cmd) {
        a.c(data, cmd);
    }

    @Override // com.tencent.mobileqq.kandian.base.utils.api.IRIJNetworkUtils
    public void debugSendPb(ToServiceMsg request) {
        a.b(request);
    }
}
