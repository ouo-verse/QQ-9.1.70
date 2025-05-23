package com.tencent.tencentmap.mapsdk.maps;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Parcelable;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.MyLocationStyle;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface TencentMapResource {

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface ResourceFrom {
        public static final int ASSET = -1;
        public static final int FILE = 2;
        public static final int JSON = 3;
        public static final int RAW = 1;
    }

    BitmapDescriptor createBitmapDescriptor(float f16, int i3);

    BitmapDescriptor createBitmapDescriptor(int i3);

    BitmapDescriptor createBitmapDescriptor(int i3, int i16);

    BitmapDescriptor createBitmapDescriptor(Bitmap bitmap, int i3);

    BitmapDescriptor createBitmapDescriptor(Parcelable parcelable, int i3);

    BitmapDescriptor createBitmapDescriptor(String str, int i3);

    BitmapDescriptor createBitmapDescriptor(Bitmap[] bitmapArr, int i3);

    MyLocationStyle getDefaultMyLocationStyle();

    int getScreenPixels();

    Typeface getTypeface();
}
