package com.tencent.mobileqq.pic.api;

import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.k;
import com.tencent.mobileqq.pic.t;
import com.tencent.mobileqq.pic.v;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.net.URL;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IPicHelper extends QRouteApi {
    void cachePicToDisk(MessageForPic messageForPic);

    void cachePicToDisk(MessageForPic messageForPic, String str);

    String getBiggestFilePath(MessageForPic messageForPic);

    URLDrawable getDrawable(t tVar, int i3, String str, URLDrawable.URLDrawableOptions uRLDrawableOptions);

    int getFileSizeType(String str, boolean z16);

    String getMsgSummaryForAnimationPic(MessageForPic messageForPic);

    URL getURL(k kVar, int i3, String str);

    URL getURL(t tVar, int i3, String str);

    URL getURL(v vVar, int i3, String str);

    URL getURL(String str, int i3);

    boolean isEmotion(MessageForPic messageForPic);

    boolean isImageExpired(String str);

    void parseDbMsgOldVersion(MessageForPic messageForPic, String str);
}
