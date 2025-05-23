package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.transfile.EmotionConstants;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class SimpleRemoteEmoticon extends BaseEmoticonExposure implements IStickerRecEmoticon {
    public static final String TAG = "SimpleRemoteEmoticon";

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IEmoticonSort
    public int getBusinessType() {
        return 1;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public URL getProtocolURL() {
        URL url;
        try {
            url = new URL("sticker_recommended_pic", EmotionConstants.FROM_AIO, ((StickerRecData) this).getURL());
        } catch (MalformedURLException e16) {
            QLog.e(TAG, 1, "getURL create url exception e = " + e16.getMessage());
            url = null;
        }
        if (url == null) {
            QLog.e(TAG, 1, "getURL url = null");
            return null;
        }
        return url;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public String getReportEventPrefix() {
        return "z-";
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public URLDrawable getURLDrawable(URL url, URLDrawable.URLDrawableOptions uRLDrawableOptions) {
        if (url == null) {
            return null;
        }
        URLDrawable drawable = URLDrawable.getDrawable(url, uRLDrawableOptions);
        drawable.setTag(new int[]{0, 0, (int) uRLDrawableOptions.mGifRoundCorner});
        return drawable;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public URLDrawable.URLDrawableOptions getURLDrawableOptions() {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mExtraInfo = this;
        return obtain;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public boolean isStickerRecFromLocal() {
        return false;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public void onEmoticonWillShow(BaseQQAppInterface baseQQAppInterface, int i3) {
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon
    public void sendEmoticon(BaseQQAppInterface baseQQAppInterface, Context context, com.tencent.mobileqq.activity.aio.p pVar) {
    }
}
