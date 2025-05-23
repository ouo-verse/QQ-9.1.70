package cooperation.qzone.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes38.dex */
public class QZoneImageUtils {
    public static final String KEY_DATA = "data";
    public static final String KEY_IMAGE_ID = "imageID";
    public static final String KEY_MATCH = "match";
    public static final String KEY_THUMB_DATA = "thumbData";
    public static final String KEY_VIDEO_ID = "videoID";
    private static final String TAG = "QZoneImageUtils";

    public static String compressPic(String str, int i3) {
        CompressInfo compressInfo = new CompressInfo(str, i3, 1035);
        ((ICompressOperator) QRoute.api(ICompressOperator.class)).start(compressInfo);
        return compressInfo.H;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0052 -> B:9:0x0055). Please report as a decompilation issue!!! */
    public static JSONObject getVideoThumbObj(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        Bitmap videoThumbnail = ShortVideoUtils.getVideoThumbnail(null, str);
        StringBuilder sb5 = new StringBuilder("data:image/jpeg;base64,");
        if (videoThumbnail != null) {
            videoThumbnail.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
            videoThumbnail.recycle();
        }
        sb5.append(PluginBaseInfoHelper.Base64Helper.encodeToString(byteArrayOutputStream.toByteArray(), 2));
        JSONObject jSONObject = new JSONObject();
        try {
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        try {
            try {
                jSONObject.put(KEY_THUMB_DATA, sb5);
                jSONObject.put("videoID", str);
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
            } catch (JSONException e17) {
                e17.printStackTrace();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
            }
            return jSONObject;
        } catch (Throwable th5) {
            try {
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
            } catch (IOException e18) {
                e18.printStackTrace();
            }
            throw th5;
        }
    }

    public static JSONObject packImageObjectV2(String str, int i3) throws JSONException, IOException, InterruptedException, OutOfMemoryError {
        StringBuilder sb5;
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        File file = new File(str);
        if (file.length() >= 3) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i16 = options.outWidth;
            int i17 = options.outHeight;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "packImageObjectV2 realWidth: " + i16 + ", realHeight: " + i17 + ", realSize: " + file.length());
            }
            if (i16 >= 0 && i17 >= 0) {
                String compressPic = compressPic(str, i3);
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = false;
                Bitmap decodeFile = BitmapFactory.decodeFile(compressPic, options2);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "packImageObjectV2 curWidth: " + options2.outWidth + ", curHeight: " + options2.outHeight + ", realSize: " + new File(compressPic).length());
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                String str2 = options2.outMimeType;
                if (!"image/png".equalsIgnoreCase(str2) && !"image/gif".equals(str2) && !MimeHelper.IMAGE_BMP.equals(str2)) {
                    sb5 = new StringBuilder("data:image/jpeg;base64,");
                    decodeFile.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
                } else {
                    sb5 = new StringBuilder("data:image/png;base64,");
                    decodeFile.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                }
                decodeFile.recycle();
                sb5.append(PluginBaseInfoHelper.Base64Helper.encodeToString(byteArrayOutputStream.toByteArray(), 2));
                jSONObject.put(KEY_MATCH, 0);
                jSONObject.put("data", sb5);
                jSONObject.put(KEY_IMAGE_ID, str);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "packImageObjectV2 time: " + (System.currentTimeMillis() - currentTimeMillis));
                }
                return jSONObject;
            }
            throw new IOException();
        }
        throw new IOException();
    }

    public static JSONObject packImageObject(String str, int i3, int i16, int i17, int i18) throws JSONException, IOException, InterruptedException, OutOfMemoryError {
        float f16;
        int height;
        StringBuilder sb5;
        FileInputStream fileInputStream;
        StringBuilder sb6;
        JSONObject jSONObject = new JSONObject();
        File file = new File(str);
        if (file.length() >= 3) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i19 = options.outWidth;
            int i26 = options.outHeight;
            if (i19 < 0 || i26 < 0) {
                throw new IOException();
            }
            if (i19 < i3 || i26 < i16) {
                jSONObject.put(KEY_MATCH, 1);
            } else if (i19 <= i17 && i26 <= i18) {
                FileInputStream fileInputStream2 = null;
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    int read = fileInputStream.read();
                    int read2 = fileInputStream.read();
                    int read3 = fileInputStream.read();
                    if (read == 255 && read2 == 216) {
                        sb6 = new StringBuilder("data:image/jpeg;base64,");
                    } else if (read == 66 && read2 == 77) {
                        sb6 = new StringBuilder("data:image/bmp;base64,");
                    } else if (read == 137 && read2 == 80) {
                        sb6 = new StringBuilder("data:image/png;base64,");
                    } else if (read == 71 && read2 == 73) {
                        sb6 = new StringBuilder("data:image/gif;base64,");
                    } else {
                        sb6 = new StringBuilder("data:base64,");
                    }
                    sb6.append(PluginBaseInfoHelper.Base64Helper.encodeToString(new byte[]{(byte) read, (byte) read2, (byte) read3}, 2));
                    byte[] bArr = new byte[30720];
                    while (true) {
                        int read4 = fileInputStream.read(bArr);
                        if (read4 != -1) {
                            if (Thread.currentThread().isInterrupted()) {
                                throw new InterruptedException();
                            }
                            if (read4 < 30720) {
                                byte[] bArr2 = new byte[read4];
                                System.arraycopy(bArr, 0, bArr2, 0, read4);
                                sb6.append(PluginBaseInfoHelper.Base64Helper.encodeToString(bArr2, 2));
                            } else {
                                sb6.append(PluginBaseInfoHelper.Base64Helper.encodeToString(bArr, 2));
                            }
                        } else {
                            jSONObject.put(KEY_MATCH, 0);
                            jSONObject.put("data", sb6);
                            jSONObject.put(KEY_IMAGE_ID, str);
                            fileInputStream.close();
                            break;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    throw th;
                }
            } else {
                int max = Math.max(i19 / i17, i26 / i18);
                options.inJustDecodeBounds = false;
                int i27 = max | (max >>> 1);
                int i28 = i27 | (i27 >>> 2);
                int i29 = i28 | (i28 >>> 4);
                int i36 = i29 | (i29 >>> 8);
                options.inSampleSize = ((i36 | (i36 >>> 16)) + 1) >>> 1;
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                if (decodeFile != null) {
                    if (i19 * i18 > i26 * i17) {
                        f16 = i17;
                        height = decodeFile.getWidth();
                    } else {
                        f16 = i18;
                        height = decodeFile.getHeight();
                    }
                    float f17 = f16 / height;
                    Matrix matrix = new Matrix();
                    switch (JpegExifReader.readOrientation(str)) {
                        case 2:
                            matrix.setScale(-f17, f17);
                            break;
                        case 3:
                            matrix.setScale(f17, f17);
                            matrix.postRotate(180.0f);
                            break;
                        case 4:
                            matrix.setScale(f17, -f17);
                            break;
                        case 5:
                            matrix.setScale(f17, -f17);
                            matrix.postRotate(90.0f);
                            break;
                        case 6:
                            matrix.setScale(f17, f17);
                            matrix.postRotate(90.0f);
                            break;
                        case 7:
                            matrix.setScale(-f17, f17);
                            matrix.postRotate(90.0f);
                            break;
                        case 8:
                            matrix.setScale(f17, f17);
                            matrix.postRotate(270.0f);
                            break;
                        default:
                            matrix.setScale(f17, f17);
                            break;
                    }
                    Bitmap createBitmap = Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true);
                    if (decodeFile != createBitmap) {
                        decodeFile.recycle();
                    }
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                    String str2 = options.outMimeType;
                    if (!"image/png".equalsIgnoreCase(str2) && !"image/gif".equals(str2) && !MimeHelper.IMAGE_BMP.equals(str2)) {
                        sb5 = new StringBuilder("data:image/jpeg;base64,");
                        createBitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
                    } else {
                        sb5 = new StringBuilder("data:image/png;base64,");
                        createBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    }
                    createBitmap.recycle();
                    sb5.append(PluginBaseInfoHelper.Base64Helper.encodeToString(byteArrayOutputStream.toByteArray(), 2));
                    jSONObject.put(KEY_MATCH, 0);
                    jSONObject.put("data", sb5);
                    jSONObject.put(KEY_IMAGE_ID, str);
                } else {
                    throw new IOException();
                }
            }
            return jSONObject;
        }
        throw new IOException();
    }
}
