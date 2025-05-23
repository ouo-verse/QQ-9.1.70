package com.tencent.mm.graphics;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import androidx.annotation.Keep;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class MMBitmapFactory {

    /* compiled from: P */
    @Keep
    /* loaded from: classes9.dex */
    public static class Options extends BitmapFactory.Options {

        @Keep
        public boolean inUseSmoothSample = true;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a {
        void loadLibrary(String str);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static abstract class b {
    }

    public static void a(a aVar) {
        MMBitmapFactoryImpl.setNativeLibraryLoader(aVar);
    }

    public static Bitmap a(Resources resources, int i3) {
        return MMBitmapFactoryImpl.getInstance().decodeResource(resources, i3);
    }

    public static Bitmap a(String str) {
        return MMBitmapFactoryImpl.getInstance().decodeFile(str);
    }

    public static Bitmap a(String str, BitmapFactory.Options options) {
        return MMBitmapFactoryImpl.getInstance().decodeFile(str, options);
    }

    public static Bitmap a(InputStream inputStream) {
        return MMBitmapFactoryImpl.getInstance().decodeStream(inputStream);
    }

    public static Bitmap a(InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        return MMBitmapFactoryImpl.getInstance().decodeStream(inputStream, rect, options);
    }
}
