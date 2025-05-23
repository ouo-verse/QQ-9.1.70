package com.tencent.mobileqq.avifcodec.api.impl;

import android.graphics.Bitmap;
import android.graphics.YuvImage;
import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.avifcodec.api.IAvifCodecApi;
import com.tencent.mobileqq.avifcodec.b;
import com.tencent.mobileqq.avifcodec.decoder.data.d;
import com.tencent.mobileqq.avifcodec.util.AvifImageHeaderParser$AvifImageType;
import com.tencent.mobileqq.avifcodec.util.Reader;
import com.tencent.mobileqq.avifcodec.util.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes11.dex */
public class AvifCodecApiImpl implements IAvifCodecApi {
    static IPatchRedirector $redirector_ = null;
    private static final int AVIF_AVIF = 1635150182;
    private static final int AVIF_AVIS = 1635150195;
    private static final int AVIF_FTYP = 1718909296;
    private static final String TAG = "AvifImageUtil";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final int f200165a;

        /* renamed from: b, reason: collision with root package name */
        public final int f200166b;

        /* renamed from: c, reason: collision with root package name */
        public final int f200167c;

        /* renamed from: d, reason: collision with root package name */
        public final int[] f200168d;

        a(int i3, int i16, int i17, int[] iArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), iArr);
                return;
            }
            this.f200165a = i3;
            this.f200166b = i16;
            this.f200167c = i17;
            this.f200168d = iArr;
        }

        public AvifImageHeaderParser$AvifImageType a() {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (AvifImageHeaderParser$AvifImageType) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            boolean z17 = false;
            if (this.f200166b != 1635150195 && !b(1635150195)) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return AvifImageHeaderParser$AvifImageType.AVIF_AVIS;
            }
            if (this.f200166b == 1635150182 || b(1635150182)) {
                z17 = true;
            }
            if (z17) {
                return AvifImageHeaderParser$AvifImageType.AVIF_AVIF;
            }
            return AvifImageHeaderParser$AvifImageType.UNKNOWN;
        }

        public boolean b(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, i3)).booleanValue();
            }
            for (int i16 : this.f200168d) {
                if (i16 == i3) {
                    return true;
                }
            }
            return false;
        }
    }

    public AvifCodecApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private int getInt32BE(byte[] bArr, int i3) {
        return bArr[i3 + 3] | (bArr[i3] << 24) | (bArr[i3 + 1] << RegisterType.UNINIT_REF) | (bArr[i3 + 2] << 8);
    }

    private a parseRawType(Reader reader) {
        try {
            int int32BE = reader.getInt32BE();
            int int32BE2 = reader.getInt32BE();
            if (int32BE2 != 1718909296) {
                return null;
            }
            int int32BE3 = reader.getInt32BE();
            int int32BE4 = reader.getInt32BE();
            int i3 = int32BE - 16;
            if (i3 % 4 != 0) {
                return null;
            }
            byte[] bArr = new byte[i3];
            if (reader.read(bArr, i3) != i3) {
                return null;
            }
            int i16 = i3 / 4;
            int[] iArr = new int[i16];
            for (int i17 = 0; i17 < i16; i17++) {
                iArr[i17] = getInt32BE(bArr, i17 * 4);
            }
            return new a(int32BE2, int32BE3, int32BE4, iArr);
        } catch (IOException e16) {
            QLog.e(TAG, 1, "parseRawType, e:" + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.avifcodec.api.IAvifCodecApi
    public Bitmap getBitmapFromAvifImage(String str) {
        FileInputStream fileInputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Bitmap) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        Bitmap bitmap = null;
        if (!TextUtils.isEmpty(str) && b.b().c()) {
            File file = new File(str);
            if (!file.exists()) {
                QLog.e(TAG, 1, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_IMAGE_NOT_EXIST);
                return null;
            }
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th5) {
                th = th5;
                fileInputStream = null;
            }
            try {
                d decode = com.tencent.mobileqq.avifcodec.decoder.a.a(2).decode(fileInputStream);
                if (decode != null) {
                    bitmap = (Bitmap) decode.get();
                }
                try {
                    fileInputStream.close();
                } catch (IOException e16) {
                    QLog.e(TAG, 1, "safeClose e:", e16);
                }
                return bitmap;
            } catch (Throwable th6) {
                th = th6;
                try {
                    QLog.e(TAG, 1, "exception e:", th);
                    return null;
                } finally {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e17) {
                            QLog.e(TAG, 1, "safeClose e:", e17);
                        }
                    }
                }
            }
        }
        QLog.e(TAG, 1, "file path is empty or so loaded fail");
        return null;
    }

    @Override // com.tencent.mobileqq.avifcodec.api.IAvifCodecApi
    public com.tencent.mobileqq.avifcodec.decoder.b getDecodeOptions(String str) {
        FileInputStream fileInputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.avifcodec.decoder.b) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        if (!TextUtils.isEmpty(str) && b.b().c()) {
            File file = new File(str);
            if (!file.exists()) {
                QLog.e(TAG, 1, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_IMAGE_NOT_EXIST);
                return null;
            }
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th5) {
                th = th5;
                fileInputStream = null;
            }
            try {
                com.tencent.mobileqq.avifcodec.decoder.b a16 = com.tencent.mobileqq.avifcodec.decoder.a.a(2).a(fileInputStream);
                try {
                    fileInputStream.close();
                } catch (IOException e16) {
                    QLog.e(TAG, 1, "safeClose e:", e16);
                }
                return a16;
            } catch (Throwable th6) {
                th = th6;
                try {
                    QLog.e(TAG, 1, "IOException e:", th);
                    return null;
                } finally {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e17) {
                            QLog.e(TAG, 1, "safeClose e:", e17);
                        }
                    }
                }
            }
        }
        QLog.e(TAG, 1, "file path is empty or so loaded fail");
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0069 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.mobileqq.avifcodec.api.IAvifCodecApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AvifImageHeaderParser$AvifImageType getType(String str) {
        Throwable th5;
        FileInputStream fileInputStream;
        IOException e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AvifImageHeaderParser$AvifImageType) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return AvifImageHeaderParser$AvifImageType.UNKNOWN;
        }
        File file = new File(str);
        if (!file.exists()) {
            QLog.e(TAG, 1, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_IMAGE_NOT_EXIST);
            return AvifImageHeaderParser$AvifImageType.UNKNOWN;
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (IOException e17) {
                fileInputStream = null;
                e16 = e17;
            } catch (Throwable th6) {
                th5 = th6;
                if (0 != 0) {
                }
                throw th5;
            }
            try {
                AvifImageHeaderParser$AvifImageType type = getType(fileInputStream);
                try {
                    fileInputStream.close();
                } catch (IOException e18) {
                    QLog.e(TAG, 1, "ioException stage 2", e18);
                }
                return type;
            } catch (IOException e19) {
                e16 = e19;
                QLog.e(TAG, 1, "ioException stage 1", e16);
                AvifImageHeaderParser$AvifImageType avifImageHeaderParser$AvifImageType = AvifImageHeaderParser$AvifImageType.UNKNOWN;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e26) {
                        QLog.e(TAG, 1, "ioException stage 2", e26);
                    }
                }
                return avifImageHeaderParser$AvifImageType;
            }
        } catch (Throwable th7) {
            th5 = th7;
            if (0 != 0) {
                try {
                    fileInputStream2.close();
                } catch (IOException e27) {
                    QLog.e(TAG, 1, "ioException stage 2", e27);
                }
            }
            throw th5;
        }
    }

    @Override // com.tencent.mobileqq.avifcodec.api.IAvifCodecApi
    public YuvImage getYuvImageFromAvifImage(String str) {
        FileInputStream fileInputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (YuvImage) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
        YuvImage yuvImage = null;
        if (!TextUtils.isEmpty(str) && b.b().c()) {
            File file = new File(str);
            if (!file.exists()) {
                QLog.e(TAG, 1, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_IMAGE_NOT_EXIST);
                return null;
            }
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    d decode = com.tencent.mobileqq.avifcodec.decoder.a.a(3).decode(fileInputStream);
                    if (decode != null) {
                        yuvImage = (YuvImage) decode.get();
                    }
                    try {
                        fileInputStream.close();
                    } catch (IOException e16) {
                        QLog.e(TAG, 1, "safeClose e:", e16);
                    }
                    return yuvImage;
                } catch (Throwable th5) {
                    th = th5;
                    try {
                        QLog.e(TAG, 1, "IOException e:", th);
                        return null;
                    } finally {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e17) {
                                QLog.e(TAG, 1, "safeClose e:", e17);
                            }
                        }
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                fileInputStream = null;
            }
        } else {
            QLog.e(TAG, 1, "file path is empty or so loaded fail");
            return null;
        }
    }

    @Override // com.tencent.mobileqq.avifcodec.api.IAvifCodecApi
    public boolean saveAvifImageAsJPG(String str, String str2, @IntRange(from = 0, to = 100) int i3) {
        FileOutputStream fileOutputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, str, str2, Integer.valueOf(i3))).booleanValue();
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && b.b().c()) {
            Bitmap bitmapFromAvifImage = getBitmapFromAvifImage(str);
            if (bitmapFromAvifImage == null) {
                QLog.e(TAG, 1, "bitmap null");
                return false;
            }
            File file = new File(str2);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (file.exists()) {
                return false;
            }
            try {
                file.createNewFile();
            } catch (IOException e16) {
                QLog.e(TAG, 1, "createNewFile fail e:", e16);
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (FileNotFoundException e17) {
                    e = e17;
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    bitmapFromAvifImage.compress(Bitmap.CompressFormat.JPEG, i3, fileOutputStream);
                    fileOutputStream.flush();
                    try {
                        fileOutputStream.close();
                    } catch (IOException e18) {
                        QLog.e(TAG, 1, "finally IOException ", e18);
                    }
                    return true;
                } catch (FileNotFoundException e19) {
                    e = e19;
                    fileOutputStream2 = fileOutputStream;
                    QLog.e(TAG, 1, "FileNotFoundException ", e);
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e26) {
                            QLog.e(TAG, 1, "finally IOException ", e26);
                        }
                    }
                    return false;
                } catch (Throwable th6) {
                    th = th6;
                    fileOutputStream2 = fileOutputStream;
                    QLog.e(TAG, 1, "IOException ", th);
                    return false;
                }
            } finally {
                if (0 != 0) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e27) {
                        QLog.e(TAG, 1, "finally IOException ", e27);
                    }
                }
            }
        }
        QLog.e(TAG, 1, "file path is empty or so loaded fail");
        return false;
    }

    @Override // com.tencent.mobileqq.avifcodec.api.IAvifCodecApi
    public AvifImageHeaderParser$AvifImageType getType(@NonNull InputStream inputStream) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? getType(new com.tencent.mobileqq.avifcodec.util.d(inputStream)) : (AvifImageHeaderParser$AvifImageType) iPatchRedirector.redirect((short) 3, (Object) this, (Object) inputStream);
    }

    @Override // com.tencent.mobileqq.avifcodec.api.IAvifCodecApi
    public AvifImageHeaderParser$AvifImageType getType(@NonNull ByteBuffer byteBuffer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? getType(new c(byteBuffer)) : (AvifImageHeaderParser$AvifImageType) iPatchRedirector.redirect((short) 4, (Object) this, (Object) byteBuffer);
    }

    private AvifImageHeaderParser$AvifImageType getType(Reader reader) {
        a parseRawType = parseRawType(reader);
        return parseRawType == null ? AvifImageHeaderParser$AvifImageType.UNKNOWN : parseRawType.a();
    }
}
