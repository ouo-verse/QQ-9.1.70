package com.tencent.libra.util;

import android.annotation.TargetApi;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.util.RFWIOUtil;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.base.model.Model;
import com.tencent.libra.base.model.UriModel;
import com.tencent.libra.h;
import com.tencent.libra.request.Option;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes7.dex */
public class LibraImageUtil {
    private static final String TAG = "LibraImageUtil";
    private static final Map<String, Integer> sMineTypePicTypeMap;

    static {
        ArrayMap arrayMap = new ArrayMap();
        sMineTypePicTypeMap = arrayMap;
        arrayMap.put("image/webp", 6);
        arrayMap.put(ImageContentType.MIME_TYPE_JPG, 4);
        arrayMap.put("image/png", 5);
    }

    @TargetApi(19)
    public static int getBitmapByteSize(@NonNull Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
                return bitmap.getHeight() * bitmap.getRowBytes();
            }
        }
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + HippyTKDListViewAdapter.X + bitmap.getHeight() + "] " + bitmap.getConfig());
    }

    @NonNull
    public static String getFileExtension(String str) {
        int lastIndexOf = str.lastIndexOf(47);
        if (lastIndexOf >= 0) {
            str = str.substring(lastIndexOf + 1);
        }
        int lastIndexOf2 = str.lastIndexOf(46);
        if (lastIndexOf2 >= 0) {
            return str.substring(lastIndexOf2);
        }
        return "";
    }

    public static String getRealPathFromUri(Uri uri) {
        Cursor query = ContactsMonitor.query(RFWApplication.getApplication().getContentResolver(), uri, new String[]{"_data"}, null, null, null);
        try {
            int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
            query.moveToFirst();
            String string = query.getString(columnIndexOrThrow);
            query.close();
            return string;
        } catch (Throwable th5) {
            if (query != null) {
                try {
                    query.close();
                } catch (Throwable th6) {
                    th5.addSuppressed(th6);
                }
            }
            throw th5;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r6v11, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.io.Closeable[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getRotateDegree(Option option) {
        ?? r65;
        int i3;
        String localPath;
        ExifInterface exifInterface;
        ExifInterface exifInterface2 = null;
        try {
            Model<?> model = option.getModel();
            if (Build.VERSION.SDK_INT >= 24) {
                r65 = h.f118788a.a(model, new File(option.getLocalPath()));
                try {
                    exifInterface = new ExifInterface((InputStream) r65);
                    exifInterface2 = r65;
                } catch (Throwable th5) {
                    th = th5;
                    try {
                        LibraLogUtil.INSTANCE.e(TAG, RFWLog.USR, option, "[getRotateDegree] failed filePath = ", Boolean.FALSE, ",e:", th);
                        RFWIOUtil.closeAll(new Closeable[]{r65});
                        if (exifInterface2 != null) {
                        }
                    } catch (Throwable th6) {
                        RFWIOUtil.closeAll(new Closeable[]{r65});
                        throw th6;
                    }
                }
            } else {
                if (model instanceof UriModel) {
                    localPath = getRealPathFromUri(((UriModel) model).a());
                } else {
                    localPath = option.getLocalPath();
                }
                exifInterface = new ExifInterface(localPath);
            }
            RFWIOUtil.closeAll(new Closeable[]{exifInterface2});
            exifInterface2 = exifInterface;
        } catch (Throwable th7) {
            th = th7;
            r65 = 0;
        }
        if (exifInterface2 != null) {
            return 0;
        }
        try {
            i3 = exifInterface2.getAttributeInt("Orientation", -1);
        } catch (Throwable th8) {
            LibraLogUtil.INSTANCE.e(TAG, RFWLog.USR, option, "[getRotateDegree] getAttributeInt failed e:", th8);
            i3 = 0;
        }
        if (i3 == -1) {
            return 0;
        }
        if (i3 != 3) {
            if (i3 != 6) {
                if (i3 != 8) {
                    return 0;
                }
                return 270;
            }
            return 90;
        }
        return 180;
    }

    public static <T> List<T> getSnapshot(@NonNull Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t16 : collection) {
            if (t16 != null) {
                arrayList.add(t16);
            }
        }
        return arrayList;
    }

    public static int mimeType2PicType(String str) {
        Integer num = sMineTypePicTypeMap.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }
}
