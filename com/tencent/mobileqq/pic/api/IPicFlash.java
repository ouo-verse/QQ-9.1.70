package com.tencent.mobileqq.pic.api;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.image.DownloadParams;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IPicFlash extends QRouteApi {
    public static final int FLASH_PIC_BUBBLE_HEIGHT = 102;
    public static final int FLASH_PIC_BUBBLE_WIDTH = 130;

    DownloadParams.DecodeHandler getFlashPicDecodeHandler();

    Drawable getFlashPicReadedDrawable();

    Bitmap getMosaicBitmap(Bitmap bitmap, int i3);

    boolean isFlashPicMsg(MessageRecord messageRecord);

    boolean isFlashPicMsgReaded(MessageRecord messageRecord);

    void setFlashPicFlag(MessageRecord messageRecord, boolean z16);

    void setFlashPicMsgReaded(MessageRecord messageRecord);

    boolean showFlashPicOption(int i3, String str);
}
