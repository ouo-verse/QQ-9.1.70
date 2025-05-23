package com.tencent.mobileqq.filemanager.api.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.api.IFileThumbGeneratorApi;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J \u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J(\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J \u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J \u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u0005H\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/filemanager/api/impl/FileThumbGeneratorApiImpl;", "Lcom/tencent/mobileqq/filemanager/api/IFileThumbGeneratorApi;", "", "rootPrefix", "path", "", "maxSize", "generatePicThumb", "sourceFilePath", "dstFilePath", "preferMaxLen", CustomImageProps.QUALITY, "", "resizeImageWithQuality", "generateVideoThumb", "", "checkThumbRootDir", "generateThumb", "videoPath", "size", "Landroid/graphics/Bitmap;", "generateViewThumbBitmap", "<init>", "()V", "Companion", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FileThumbGeneratorApiImpl implements IFileThumbGeneratorApi {

    @NotNull
    private static final String TAG = "FileThumbGeneratorApiImpl";

    private final void checkThumbRootDir() {
        File file = new File(AppConstants.SDCARD_FILE_SAVE_THUMB_PATH);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    private final String generatePicThumb(String rootPrefix, String path, int maxSize) {
        byte[] bytes = path.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        UUID nameUUIDFromBytes = UUID.nameUUIDFromBytes(bytes);
        String str = AppConstants.SDCARD_FILE_SAVE_THUMB_PATH + rootPrefix + "-" + nameUUIDFromBytes + ".png";
        if (!FileUtils.fileExistsAndNotEmpty(path)) {
            return "";
        }
        if (FileUtils.fileExistsAndNotEmpty(str)) {
            return str;
        }
        String str2 = str + ".ttmp";
        FileUtils.deleteFile(str2);
        VFSFile vFSFile = new VFSFile(str2);
        try {
            vFSFile.createNewFile();
            resizeImageWithQuality(path, str2, maxSize, 80);
            ah.x1(vFSFile, new VFSFile(str));
            return str;
        } catch (IOException e16) {
            QLog.d(TAG, 1, e16, new Object[0]);
            return "";
        }
    }

    private final String generateVideoThumb(String rootPrefix, String path, int maxSize) {
        String str;
        try {
            byte[] bytes = path.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            UUID nameUUIDFromBytes = UUID.nameUUIDFromBytes(bytes);
            QLog.d(TAG, 1, "generateVideoThumb path: " + path + ", uuid: " + nameUUIDFromBytes);
            str = AppConstants.SDCARD_FILE_SAVE_THUMB_PATH + rootPrefix + "-" + nameUUIDFromBytes + ".png";
        } catch (Exception e16) {
            QLog.d(TAG, 1, e16, new Object[0]);
        }
        if (!FileUtils.fileExistsAndNotEmpty(path)) {
            return "";
        }
        if (FileUtils.fileExistsAndNotEmpty(str)) {
            return str;
        }
        String str2 = str + ".ttmp";
        BufferedOutputStream bufferedOutputStream = null;
        Bitmap videoThumbnail = ShortVideoUtils.getVideoThumbnail(null, path, maxSize);
        if (videoThumbnail != null) {
            FileUtils.deleteFile(str2);
            VFSFile vFSFile = new VFSFile(str2);
            try {
                try {
                    vFSFile.createNewFile();
                    try {
                        BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str2));
                        try {
                            videoThumbnail.compress(Bitmap.CompressFormat.PNG, 100, bufferedOutputStream2);
                            videoThumbnail.recycle();
                            bufferedOutputStream2.flush();
                            ah.x1(vFSFile, new VFSFile(str));
                            try {
                                bufferedOutputStream2.close();
                            } catch (Exception e17) {
                                QLog.d(TAG, 1, e17, new Object[0]);
                            }
                            return str;
                        } catch (FileNotFoundException e18) {
                            e = e18;
                            bufferedOutputStream = bufferedOutputStream2;
                            QLog.d(TAG, 1, e, new Object[0]);
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (Exception e19) {
                                    QLog.d(TAG, 1, e19, new Object[0]);
                                }
                            }
                            return "";
                        } catch (Throwable th5) {
                            th = th5;
                            bufferedOutputStream = bufferedOutputStream2;
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (Exception e26) {
                                    QLog.d(TAG, 1, e26, new Object[0]);
                                }
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException e27) {
                        e = e27;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (IOException e28) {
                QLog.d(TAG, 1, e28, new Object[0]);
                return "";
            }
        }
        return "";
    }

    private final boolean resizeImageWithQuality(String sourceFilePath, String dstFilePath, int preferMaxLen, int quality) {
        int i3;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(sourceFilePath, options);
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap d16 = com.tencent.mobileqq.wink.utils.f.d(sourceFilePath, options2);
        if (d16 == null) {
            return false;
        }
        if (options.outWidth <= preferMaxLen && options.outHeight <= preferMaxLen) {
            File u16 = com.tencent.mobileqq.wink.utils.f.u(dstFilePath, d16, quality);
            if (!d16.isRecycled()) {
                d16.recycle();
            }
            if (u16 != null) {
                return true;
            }
            return false;
        }
        if (d16.getWidth() > d16.getHeight()) {
            i3 = (int) ((d16.getHeight() * preferMaxLen) / d16.getWidth());
        } else {
            i3 = preferMaxLen;
            preferMaxLen = (int) ((d16.getWidth() * preferMaxLen) / d16.getHeight());
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(d16, (int) (preferMaxLen * 1.5d), (int) (i3 * 1.5d), true);
        File u17 = com.tencent.mobileqq.wink.utils.f.u(dstFilePath, createScaledBitmap, quality);
        if (!d16.isRecycled()) {
            d16.recycle();
        }
        if (createScaledBitmap != null && !createScaledBitmap.isRecycled()) {
            createScaledBitmap.recycle();
        }
        if (u17 != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileThumbGeneratorApi
    @NotNull
    public String generateThumb(@NotNull String rootPrefix, @NotNull String path, int maxSize) {
        Intrinsics.checkNotNullParameter(rootPrefix, "rootPrefix");
        Intrinsics.checkNotNullParameter(path, "path");
        checkThumbRootDir();
        QLog.d(TAG, 1, "generateThumb path: " + path + ",fileName: " + ah.h0(path));
        int o06 = ah.o0(path);
        if (o06 != 0) {
            if (o06 != 2) {
                return "";
            }
            return generateVideoThumb(rootPrefix, path, maxSize);
        }
        return generatePicThumb(rootPrefix, path, maxSize);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileThumbGeneratorApi
    @Nullable
    public Bitmap generateViewThumbBitmap(@Nullable String videoPath, int size) {
        return ShortVideoUtils.getVideoThumbnail(null, videoPath, size, 0L);
    }
}
