package com.tencent.mobileqq.kandian.base.utils.api;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J.\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J2\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0014\u0010\u0011\u001a\u0010\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u0012\u0018\u00010\u0012H&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/kandian/base/utils/api/IReadInJoyOidbHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createToServiceMsg", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "cmd", "", "makeOIDBPkg", "command", "", "serviceType", "bodyByte", "", "parseOIDBPkg", "res", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "data", "Ljava/lang/Object;", "msg", "Lcom/tencent/mobileqq/pb/MessageMicro;", "kandian-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IReadInJoyOidbHelper extends QRouteApi {
    @Nullable
    ToServiceMsg createToServiceMsg(@Nullable String cmd);

    @Nullable
    ToServiceMsg makeOIDBPkg(@Nullable String cmd, int command, int serviceType, @Nullable byte[] bodyByte);

    int parseOIDBPkg(@Nullable FromServiceMsg res, @Nullable Object data, @Nullable MessageMicro<? extends MessageMicro<?>> msg2);
}
