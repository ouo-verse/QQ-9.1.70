package com.tencent.mobileqq.guild.feed.part;

import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\b\u0010\u0001\u001a\u00020\u0000H\u0002\u001a\b\u0010\u0002\u001a\u00020\u0000H\u0002\u00a8\u0006\u0003"}, d2 = {"", "d", "c", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void c() {
        QLog.d("GifAutoPlayPart", 1, "Gif_Pause");
        AbstractGifImage.pauseAll();
        ApngImage.pauseAll();
        URLDrawable.pause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d() {
        QLog.d("GifAutoPlayPart", 1, "Gif_Resume");
        AbstractGifImage.resumeAll();
        try {
            ApngImage.resumeAll();
        } catch (Exception e16) {
            QLog.e("GifAutoPlayPart", 1, "gifResume exception: " + e16.getMessage());
        }
        URLDrawable.resume();
    }
}
