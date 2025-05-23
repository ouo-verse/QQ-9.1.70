package com.tencent.mobileqq.triton.utils;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.filesystem.GameDataFileSystem;
import com.tencent.mobileqq.triton.filesystem.TemporaryFile;
import com.tencent.mobileqq.triton.internal.utils.FileUtils;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;

/* compiled from: P */
@TritonKeep
/* loaded from: classes19.dex */
public class CanvasRecorder {
    public static final String TAG = "CanvasRecorder";
    private TTEngine mTritonEngine;

    public CanvasRecorder(TTEngine tTEngine) {
        this.mTritonEngine = tTEngine;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x004a  */
    @TritonKeep
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String canvasToTempFilePathSync(byte[] bArr, int i3, int i16, int i17, int i18, String str, int i19, boolean z16) {
        Bitmap createBitmap;
        String lowerCase;
        FileOutputStream fileOutputStream;
        Bitmap.CompressFormat compressFormat;
        Closeable closeable = null;
        if (bArr != null) {
            try {
                createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
                createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(bArr));
                if (i17 > 0 && i18 > 0) {
                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(createBitmap, i17, i18, false);
                    createBitmap.recycle();
                    createBitmap = createScaledBitmap;
                }
            } catch (Throwable th5) {
                Logger.e(TAG, "canvasToTempFilePathSync: ", th5);
            }
            if (createBitmap != null) {
                return null;
            }
            if (z16) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                if (createBitmap.compress(Bitmap.CompressFormat.PNG, i19, byteArrayOutputStream)) {
                    String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                    Logger.d(TAG, "convertBitmapToBase64String: success, base64 png format");
                    return encodeToString;
                }
                Logger.e(TAG, "convertBitmapToBase64String: fail");
                return null;
            }
            if (TextUtils.isEmpty(str)) {
                lowerCase = "png";
            } else {
                lowerCase = str.toLowerCase();
            }
            GameDataFileSystem dataFileSystem = this.mTritonEngine.getEngineContext().getDataFileSystem();
            TemporaryFile newTempFile = dataFileSystem.newTempFile(null, lowerCase);
            try {
                try {
                    fileOutputStream = new FileOutputStream(newTempFile.getFile());
                } catch (FileNotFoundException e16) {
                    e = e16;
                    fileOutputStream = null;
                } catch (Throwable th6) {
                    th = th6;
                    FileUtils.closeQuietly(closeable);
                    throw th;
                }
                try {
                    if ("jpg".equalsIgnoreCase(str)) {
                        compressFormat = Bitmap.CompressFormat.JPEG;
                    } else {
                        compressFormat = Bitmap.CompressFormat.PNG;
                    }
                    if (createBitmap.compress(compressFormat, i19, fileOutputStream)) {
                        Logger.d(TAG, "canvasToTempFilePathSync: save to file " + newTempFile.getFile());
                        String pathInGame = newTempFile.getPathInGame();
                        FileUtils.closeQuietly(fileOutputStream);
                        return pathInGame;
                    }
                    Logger.e(TAG, "canvasToTempFilePathSync: save to file fail");
                    FileUtils.closeQuietly(fileOutputStream);
                    return null;
                } catch (FileNotFoundException e17) {
                    e = e17;
                    Logger.e(TAG, "canvasToTempFilePathSync: ", e);
                    FileUtils.closeQuietly(fileOutputStream);
                    return null;
                }
            } catch (Throwable th7) {
                th = th7;
                closeable = dataFileSystem;
                FileUtils.closeQuietly(closeable);
                throw th;
            }
        }
        Logger.e(TAG, "canvasToTempFilePathSync: invalid parameter originalWidth = " + i3 + " originalHeight = " + i16);
        createBitmap = null;
        if (createBitmap != null) {
        }
    }
}
