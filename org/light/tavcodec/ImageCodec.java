package org.light.tavcodec;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.light.device.LightDeviceProperty;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImageCodec {
    private static final int ALPHA_8 = 1;
    private static final int ARGB_8888_PREMULTIPLIED = 2;
    private static final int ARGB_8888_UNPREMULTIPLIED = 3;

    private static Bitmap CreateBitmapFromBytes(ByteBuffer byteBuffer, int i3) {
        try {
            return BitmapFactory.decodeStream(new ByteBufferInputStream(byteBuffer), null, MakeOptions(i3));
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private static Bitmap CreateBitmapFromPath(String str, int i3) {
        try {
            return BitmapFactory.decodeFile(str, MakeOptions(i3));
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private static int GetOrientationFromBytes(ByteBuffer byteBuffer) {
        try {
            if (LightDeviceProperty.VERSION.SDK_INT < 24) {
                return 1;
            }
            return new ExifInterface(new ByteBufferInputStream(byteBuffer)).getAttributeInt("Orientation", 1);
        } catch (IOException e16) {
            e16.printStackTrace();
            return 1;
        }
    }

    private static int GetOrientationFromPath(String str) {
        try {
            return new ExifInterface(str).getAttributeInt("Orientation", 1);
        } catch (IOException e16) {
            e16.printStackTrace();
            return 1;
        }
    }

    private static int[] GetSizeFromBytes(ByteBuffer byteBuffer) {
        int[] iArr = {0, 0};
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeStream(new ByteBufferInputStream(byteBuffer), null, options);
            iArr[0] = options.outWidth;
            iArr[1] = options.outHeight;
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return iArr;
    }

    private static int[] GetSizeFromPath(String str) {
        int[] iArr = {0, 0};
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeFile(str, options);
            iArr[0] = options.outWidth;
            iArr[1] = options.outHeight;
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return iArr;
    }

    private static BitmapFactory.Options MakeOptions(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3 && LightDeviceProperty.VERSION.SDK_INT >= 19) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                    options.inPremultiplied = false;
                    return options;
                }
                return null;
            }
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inPreferredConfig = Bitmap.Config.ARGB_8888;
            return options2;
        }
        BitmapFactory.Options options3 = new BitmapFactory.Options();
        options3.inPreferredConfig = Bitmap.Config.ALPHA_8;
        return options3;
    }
}
