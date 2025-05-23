package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.mvp.IStickerModel;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes10.dex */
public interface IStickerRecEmoticon extends IEmoticonSort, IEmoticonExposure, IStickerModel {
    String getImgMd5();

    String getImgUrl();

    URL getProtocolURL();

    int getRecType();

    String getReportEventPrefix();

    String getThumbUrl();

    URLDrawable getURLDrawable(URL url, URLDrawable.URLDrawableOptions uRLDrawableOptions);

    URLDrawable.URLDrawableOptions getURLDrawableOptions();

    boolean isClicked();

    boolean isExposed();

    boolean isStickerRecFromLocal();

    void onEmoticonWillShow(BaseQQAppInterface baseQQAppInterface, int i3);

    void sendEmoticon(BaseQQAppInterface baseQQAppInterface, Context context, com.tencent.mobileqq.activity.aio.p pVar);
}
