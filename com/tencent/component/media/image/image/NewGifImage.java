package com.tencent.component.media.image.image;

import android.graphics.drawable.Drawable;
import android.util.Log;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.gif.NewGifDecoder;
import com.tencent.component.media.gif.NewGifDrawable;
import com.tencent.component.media.gif.SharpPNewGifDecoder;
import com.tencent.component.media.image.ImageKey;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes5.dex */
public class NewGifImage extends Image {
    private Drawable mDrawable;
    private String url;

    public NewGifImage(String str) {
        try {
            this.mDrawable = new NewGifDrawable(str, (NewGifDecoder.Options) null);
        } catch (IOException unused) {
        }
    }

    public Drawable getDrawable() {
        return this.mDrawable;
    }

    @Override // com.tencent.component.media.image.image.Image
    public boolean isRecycled() {
        Drawable drawable = this.mDrawable;
        if (drawable != null && (drawable instanceof NewGifDrawable)) {
            return ((NewGifDrawable) drawable).isRecycled();
        }
        return false;
    }

    @Override // com.tencent.component.media.image.image.Image
    public void recycle() {
        Drawable drawable = this.mDrawable;
        if (drawable != null && (drawable instanceof NewGifDrawable)) {
            ((NewGifDrawable) drawable).recycle();
        }
    }

    @Override // com.tencent.component.media.image.image.Image
    public int size() {
        Drawable drawable = this.mDrawable;
        if (drawable != null && (drawable instanceof NewGifDrawable)) {
            return drawable.getIntrinsicWidth() * this.mDrawable.getIntrinsicHeight() * 4;
        }
        return 0;
    }

    public NewGifImage(ImageKey imageKey, int i3, int i16) {
        try {
            NewGifDecoder.Options options = new NewGifDecoder.Options();
            options.inPreferWidth = i3;
            options.inPreferHeight = i16;
            this.mDrawable = new NewGifDrawable(imageKey.filePath, options, imageKey.url);
            ImageManagerEnv.getLogger().d("NewGifImage", "create NewGifImage url: " + imageKey.url);
        } catch (Throwable th5) {
            ImageManagerEnv.getLogger().e("NewGifImage", Log.getStackTraceString(th5));
        }
    }

    public NewGifImage(String str, int i3, int i16, float f16) {
        this.mDrawable = new NewGifDrawable(new SharpPNewGifDecoder(str, (int) (i3 / f16), (int) (i16 / f16)));
    }

    public NewGifImage(String str, int i3, int i16, float f16, String str2) {
        this.mDrawable = new NewGifDrawable(new SharpPNewGifDecoder(str, (int) (i3 / f16), (int) (i16 / f16)), str2);
    }
}
