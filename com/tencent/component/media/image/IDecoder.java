package com.tencent.component.media.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.File;
import java.io.FileInputStream;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface IDecoder {
    Bitmap decodeBitmap(File file, int i3, int i16, Bitmap bitmap);

    Bitmap decodeFile(File file, BitmapFactory.Options options);

    BitmapReference decodeImage(File file, BitmapFactory.Options options);

    BitmapReference decodeImage(FileInputStream fileInputStream, BitmapFactory.Options options);

    BitmapReference decodeImage(byte[] bArr, int i3, int i16, BitmapFactory.Options options, int i17, int i18);
}
