package com.tencent.qqnt.aio.adapter.api.impl;

import com.tencent.mobileqq.pic.api.IPicUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.aio.adapter.api.IAIOIncompatiblePicAdapterApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOIncompatiblePicAdapterApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOIncompatiblePicAdapterApi;", "", "filePath", "generateCompatiblePic", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AIOIncompatiblePicAdapterApiImpl implements IAIOIncompatiblePicAdapterApi {
    public static final String TAG = "AIOIncompatiblePicAdapterApi";

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOIncompatiblePicAdapterApi
    public String generateCompatiblePic(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        String generateCompatiblePic = ((IPicUtil) QRoute.api(IPicUtil.class)).generateCompatiblePic(filePath);
        Intrinsics.checkNotNullExpressionValue(generateCompatiblePic, "api(IPicUtil::class.java\u2026teCompatiblePic(filePath)");
        return generateCompatiblePic;
    }
}
