package com.tencent.mobileqq.kandian.base.utils.api.impl;

import com.tencent.mobileqq.kandian.base.msf.c;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyOidbHelper;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J.\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J2\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0014\u0010\u0012\u001a\u0010\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u0013\u0018\u00010\u0013H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/kandian/base/utils/api/impl/ReadInJoyOidbHelperImpl;", "Lcom/tencent/mobileqq/kandian/base/utils/api/IReadInJoyOidbHelper;", "()V", "createToServiceMsg", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "cmd", "", "makeOIDBPkg", "command", "", "serviceType", "bodyByte", "", "parseOIDBPkg", "res", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "data", "Ljava/lang/Object;", "msg", "Lcom/tencent/mobileqq/pb/MessageMicro;", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class ReadInJoyOidbHelperImpl implements IReadInJoyOidbHelper {
    @Override // com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyOidbHelper
    public ToServiceMsg createToServiceMsg(String cmd) {
        return c.a(cmd);
    }

    @Override // com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyOidbHelper
    public ToServiceMsg makeOIDBPkg(String cmd, int command, int serviceType, byte[] bodyByte) {
        return c.b(cmd, command, serviceType, bodyByte);
    }

    @Override // com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyOidbHelper
    public int parseOIDBPkg(FromServiceMsg res, Object data, MessageMicro<? extends MessageMicro<?>> msg2) {
        return c.c(res, data, msg2);
    }
}
