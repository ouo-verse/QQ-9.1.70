package com.tencent.qqmini.sdk.utils;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.ThumbnailUtils;
import android.util.Base64;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class ScreenShotUtil {
    public static final int EDGE_LEFT_RIGHT = 10;
    public static final String TAG = "ScreenShotUtil";

    public static String bitmapTobase64(Bitmap bitmap, int i3, int i16) throws IOException {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        while (true) {
            if (width <= i3 && height <= i16) {
                Bitmap extractThumbnail = ThumbnailUtils.extractThumbnail(bitmap, width, height);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                extractThumbnail.compress(Bitmap.CompressFormat.JPEG, 40, byteArrayOutputStream);
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
            }
            width /= 2;
            height /= 2;
        }
    }

    public static boolean checkIfWhiteScreen(Bitmap bitmap, BaseRuntime baseRuntime) throws JSONException {
        if (bitmap != null && baseRuntime != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            NativeViewRequestEvent nativeViewRequestEvent = new NativeViewRequestEvent();
            nativeViewRequestEvent.dispatchTarget = 3;
            nativeViewRequestEvent.event = "getMenuButtonBoundingClientRect";
            int optInt = (new JSONObject(baseRuntime.getPage().dispatchEventToNativeView(nativeViewRequestEvent)).optInt("bottom") * ((int) DisplayUtil.getDensity(baseRuntime.getAttachActivity()))) + DisplayUtil.getStatusBarHeight(baseRuntime.getAttachActivity());
            QMLog.i(TAG, "--- checkIfWhiteScreen:width:" + width + " height:" + height);
            int imageRowRgb = getImageRowRgb(bitmap, width, optInt + 5);
            int imageRowRgb2 = getImageRowRgb(bitmap, width, height / 2);
            int imageRowRgb3 = getImageRowRgb(bitmap, width, (height - optInt) + (-5));
            int imageColRgb = getImageColRgb(bitmap, width / 2, height);
            if (imageRowRgb != -1 && imageRowRgb == imageRowRgb2 && imageRowRgb2 == imageRowRgb3 && imageRowRgb3 == imageColRgb) {
                QMLog.i(TAG, "--- checkIfWhiteScreen:rgb1:" + imageRowRgb + " rgb2:" + imageRowRgb2 + " rgb3:" + imageRowRgb3 + " rgb4:" + imageColRgb);
                return true;
            }
            QMLog.i(TAG, "--- checkIfWhiteScreen:rgb1:" + imageRowRgb + " rgb2:" + imageRowRgb2 + " rgb3:" + imageRowRgb3 + " rgb4:" + imageColRgb);
        }
        return false;
    }

    private static int getImageColRgb(Bitmap bitmap, int i3, int i16) {
        int blue;
        if (bitmap == null) {
            return -1;
        }
        int i17 = i16 / 4;
        int pixel = bitmap.getPixel(i3, i17);
        int red = Color.red(pixel);
        int green = Color.green(pixel);
        int blue2 = Color.blue(pixel);
        do {
            i17++;
            if (i17 < (i16 * 3) / 4) {
                int pixel2 = bitmap.getPixel(i3, i17);
                int red2 = Color.red(pixel2);
                int green2 = Color.green(pixel2);
                blue = Color.blue(pixel2);
                if (red2 != red || green2 != green) {
                    break;
                }
            } else {
                return red * green * blue2;
            }
        } while (blue == blue2);
        return -1;
    }

    private static int getImageRowRgb(Bitmap bitmap, int i3, int i16) {
        if (bitmap == null) {
            return -1;
        }
        int pixel = bitmap.getPixel(10, i16);
        int red = Color.red(pixel);
        int green = Color.green(pixel);
        int blue = Color.blue(pixel);
        for (int i17 = 11; i17 < i3 - 10; i17++) {
            int pixel2 = bitmap.getPixel(i17, i16);
            int red2 = Color.red(pixel2);
            int green2 = Color.green(pixel2);
            int blue2 = Color.blue(pixel2);
            if (red2 != red || green2 != green || blue2 != blue) {
                return -1;
            }
        }
        return red * green * blue;
    }
}
