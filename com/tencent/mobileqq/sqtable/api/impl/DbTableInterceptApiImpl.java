package com.tencent.mobileqq.sqtable.api.impl;

import com.tencent.mobileqq.sqtable.QProxyManagerTableInterceptor;
import com.tencent.mobileqq.sqtable.api.IDbTableInterceptApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/sqtable/api/impl/DbTableInterceptApiImpl;", "Lcom/tencent/mobileqq/sqtable/api/IDbTableInterceptApi;", "()V", "getReportClassName", "", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class DbTableInterceptApiImpl implements IDbTableInterceptApi {
    @Override // com.tencent.mobileqq.sqtable.api.IDbTableInterceptApi
    public String getReportClassName() {
        String name = QProxyManagerTableInterceptor.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "QProxyManagerTableInterceptor::class.java.name");
        return name;
    }
}
