package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class b extends BaseEmoticonExposure implements IStickerRecEmoticon {

    /* renamed from: a, reason: collision with root package name */
    private boolean f179907a;

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public int getRecType() {
        return 0;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public String getThumbUrl() {
        return null;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public URLDrawable getURLDrawable(URL url, URLDrawable.URLDrawableOptions uRLDrawableOptions) {
        if (url == null) {
            return null;
        }
        return URLDrawable.getDrawable(url, uRLDrawableOptions);
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public URLDrawable.URLDrawableOptions getURLDrawableOptions() {
        return URLDrawable.URLDrawableOptions.obtain();
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public boolean isClicked() {
        return this.f179907a;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public boolean isExposed() {
        return true;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public boolean isStickerRecFromLocal() {
        return true;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public void sendEmoticon(BaseQQAppInterface baseQQAppInterface, Context context, com.tencent.mobileqq.activity.aio.p pVar) {
        this.f179907a = true;
    }
}
