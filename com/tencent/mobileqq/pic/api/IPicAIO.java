package com.tencent.mobileqq.pic.api;

import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {""})
/* loaded from: classes16.dex */
public interface IPicAIO extends QRouteApi {
    public static final float AIO_IMAGE_ROUND_CORNER = 8.0f;

    float getAioImageRoundCorner(DownloadParams downloadParams);

    String getReceivePicFailedTip(URLDrawable uRLDrawable);

    String getSendPicFailedTip(MessageForPic messageForPic);

    int getThumbMaxPx(boolean z16, boolean z17, int i3);

    int getThumbMinPx(boolean z16, boolean z17, int i3);

    int getThumbMinPxForFileWidth(int i3);

    ThumbWidthHeightDP getThumbWidthHeightDP(MessageForPic messageForPic, boolean z16);

    ThumbWidthHeightDP getThumbWidthHeightDP(boolean z16, boolean z17, int i3);

    ThumbWidthHeightDP getThumbWidthHeightDPForFile(int i3);

    void initAioThumbSize();

    void reportNormalPicMsgClickEvent(MessageForPic messageForPic);
}
