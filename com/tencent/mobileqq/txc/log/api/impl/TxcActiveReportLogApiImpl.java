package com.tencent.mobileqq.txc.log.api.impl;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.txc.log.api.ITxcActiveReportLogApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oy2.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/txc/log/api/impl/TxcActiveReportLogApiImpl;", "Lcom/tencent/mobileqq/txc/log/api/ITxcActiveReportLogApi;", "()V", "getIPCModule", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class TxcActiveReportLogApiImpl implements ITxcActiveReportLogApi {
    @Override // com.tencent.mobileqq.txc.log.api.ITxcActiveReportLogApi
    public QIPCModule getIPCModule() {
        a b16 = a.b();
        Intrinsics.checkNotNullExpressionValue(b16, "getInstance()");
        return b16;
    }
}
