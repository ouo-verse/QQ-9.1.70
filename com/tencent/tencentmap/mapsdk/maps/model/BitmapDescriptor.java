package com.tencent.tencentmap.mapsdk.maps.model;

import android.content.Context;
import android.graphics.Bitmap;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class BitmapDescriptor {
    private final BitmapFormator bitmapFormator;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface BitmapFormator {

        /* compiled from: P */
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes26.dex */
        public @interface BitmapFormatType {
            public static final int FORMAT_ASSET = 2;
            public static final int FORMAT_BITMAP = 7;
            public static final int FORMAT_BITMAPS = 10;
            public static final int FORMAT_DEFAULT = 5;
            public static final int FORMAT_DEFAULT_F = 6;
            public static final int FORMAT_FILE = 3;
            public static final int FORMAT_FONT_TEXT = 9;
            public static final int FORMAT_NONE = -1;
            public static final int FORMAT_PATH = 4;
            public static final int FORMAT_RESOURCE = 1;
            public static final int FORMAT_URL = 8;
        }

        int activeSize();

        Bitmap getBitmap(Context context);

        String getBitmapId();

        int getFormateType();

        int getHeight();

        int getWidth();

        int nextActiveIndex();

        void recycle();

        void setScale(int i3);
    }

    public BitmapDescriptor(BitmapFormator bitmapFormator) {
        this.bitmapFormator = bitmapFormator;
    }

    public final String getBDId() {
        return this.bitmapFormator.getBitmapId();
    }

    public final Bitmap getBitmap(Context context) {
        BitmapFormator bitmapFormator = this.bitmapFormator;
        if (bitmapFormator == null) {
            return null;
        }
        return bitmapFormator.getBitmap(context);
    }

    public final BitmapFormator getFormater() {
        return this.bitmapFormator;
    }

    public final int getHeight() {
        BitmapFormator bitmapFormator = this.bitmapFormator;
        if (bitmapFormator == null) {
            return 0;
        }
        return bitmapFormator.getHeight();
    }

    public final int getWidth() {
        BitmapFormator bitmapFormator = this.bitmapFormator;
        if (bitmapFormator == null) {
            return 0;
        }
        return bitmapFormator.getWidth();
    }
}
