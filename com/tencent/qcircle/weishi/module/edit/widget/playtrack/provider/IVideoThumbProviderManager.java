package com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider;

import android.graphics.Bitmap;
import com.tencent.qcircle.weseevideo.model.resource.MediaResourceModel;
import com.tencent.tavkit.composition.TAVSource;

/* loaded from: classes22.dex */
public interface IVideoThumbProviderManager {
    Bitmap getBitmapByTime(long j3, Object obj, String str);

    long getCacheSize();

    void initWidthAndHeight(int i3, int i16);

    void pause();

    void registerListener(VideoThumbListener videoThumbListener);

    void release(String str);

    void reset(MediaResourceModel mediaResourceModel, String str);

    void reset(TAVSource tAVSource, String str, String str2);

    void resume();

    void setDefaultBitmap(Bitmap bitmap);

    void unRegisterListener(VideoThumbListener videoThumbListener);
}
