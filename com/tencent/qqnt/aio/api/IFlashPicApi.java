package com.tencent.qqnt.aio.api;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH&J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/aio/api/IFlashPicApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "enterFlashPicPreview", "", "flashPic", "Landroid/widget/ImageView;", "msgId", "", "peerUid", "", DTConstants.TAG.ELEMENT, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "isSelf", "", "thumbPath", "getMosaicBitmap", "Landroid/graphics/Bitmap;", "bmp", "blockSize", "", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IFlashPicApi extends QRouteApi {
    void enterFlashPicPreview(@NotNull ImageView flashPic, long msgId, @NotNull String peerUid, @NotNull MsgElement element, boolean isSelf, @NotNull String thumbPath);

    @NotNull
    Bitmap getMosaicBitmap(@NotNull Bitmap bmp, int blockSize);
}
