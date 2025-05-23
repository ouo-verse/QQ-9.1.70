package com.tencent.mobileqq.emoticon.api;

import android.content.Context;
import android.widget.PopupWindow;
import com.tencent.mobileqq.activity.richmedia.i;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IAniStickerUtils extends QRouteApi {
    public static final int ANI_STICKER_TYPE_EMOJI = 1;

    boolean checkIsNeedShowAniStickerPreGuide();

    PopupWindow createAniStickerPreGuideView(Context context);

    i getAniStickerPreGuideViewSize();

    void notifyAniStickerPreGuideShow();
}
