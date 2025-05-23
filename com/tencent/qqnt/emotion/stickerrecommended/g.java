package com.tencent.qqnt.emotion.stickerrecommended;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface g extends e, d, com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp.c {
    String a();

    void d(BaseQQAppInterface baseQQAppInterface, com.tencent.aio.api.runtime.a aVar);

    String g();

    String getImgMd5();

    String getImgUrl();

    URL getProtocolURL();

    String getReportEventPrefix();

    String getThumbUrl();

    URLDrawable getURLDrawable(URL url, URLDrawable.URLDrawableOptions uRLDrawableOptions);

    URLDrawable.URLDrawableOptions getURLDrawableOptions();

    boolean isClicked();

    boolean isExposed();

    boolean isStickerRecFromLocal();

    void onEmoticonWillShow(BaseQQAppInterface baseQQAppInterface, int i3);
}
