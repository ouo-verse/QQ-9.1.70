package com.tencent.mobileqq.activity.aio.stickerbubble.frame;

import android.graphics.Bitmap;
import com.tencent.image.NativeGifImage;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c extends NativeGifImage implements d {
    public c(File file, boolean z16) throws IOException {
        super(file, z16);
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.frame.d
    public Bitmap a() {
        return this.mCurrentFrameBitmap;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.frame.d
    public void b() {
        getNextFrame();
        applyNextFrame();
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.frame.d
    public int getCurrentFrameIndex() {
        return this.mCurrentFrameIndex;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.frame.d
    public int getFrameCount() {
        return this.mMetaData[NativeGifImage.FRAME_COUNT_INDEX];
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.frame.d
    public int getFrameDelay() {
        return this.mMetaData[NativeGifImage.POST_INVALIDATION_TIME_INDEX];
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.frame.d
    public void complete() {
    }
}
