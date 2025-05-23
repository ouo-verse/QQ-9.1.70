package com.tencent.qqnt.compress.api;

import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/compress/api/IPicCompressApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "compressPic", "", CustomImageProps.QUALITY, "", "originPath", "generateThumbPic", "compress_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface IPicCompressApi extends QRouteApi {
    @NotNull
    String compressPic(boolean quality, @NotNull String originPath);

    @NotNull
    String generateThumbPic(@NotNull String originPath);
}
