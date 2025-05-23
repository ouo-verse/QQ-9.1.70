package com.tencent.qqnt.aio.helper.api.impl;

import com.tencent.aio.main.businesshelper.h;
import com.tencent.qqnt.aio.helper.ac;
import com.tencent.qqnt.aio.helper.api.IAIOGetHandlerClzApi;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\f\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/aio/helper/api/impl/AIOGetHandlerClzApiImpl;", "Lcom/tencent/qqnt/aio/helper/api/IAIOGetHandlerClzApi;", "Ljava/lang/Class;", "getC2CDelFriendHelperClz", "Lcom/tencent/aio/main/businesshelper/h;", "getC2CDelFriendHelper", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AIOGetHandlerClzApiImpl implements IAIOGetHandlerClzApi {
    @Override // com.tencent.qqnt.aio.helper.api.IAIOGetHandlerClzApi
    public h getC2CDelFriendHelper() {
        return new ac();
    }

    @Override // com.tencent.qqnt.aio.helper.api.IAIOGetHandlerClzApi
    public Class<?> getC2CDelFriendHelperClz() {
        return ac.class;
    }
}
