package com.tencent.libra.extension.avif;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.libavif.AvifFormat;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a {
    @NonNull
    public static AvifFormat a(@Nullable InputStream inputStream) {
        byte[] bArr;
        if (inputStream == null) {
            return AvifFormat.FORMAT_INVAILD;
        }
        try {
            try {
                bArr = new byte[12];
                inputStream.read(bArr);
            } finally {
            }
        } catch (IOException e16) {
            RFWLog.e("AvifUtil", RFWLog.USR, "[getAvifFormat] error", e16);
        }
        if (b(bArr)) {
            AvifFormat avifFormat = AvifFormat.FORMAT_AVIF;
            inputStream.close();
            return avifFormat;
        }
        if (c(bArr)) {
            AvifFormat avifFormat2 = AvifFormat.FORMAT_AVIS;
            inputStream.close();
            return avifFormat2;
        }
        inputStream.close();
        return AvifFormat.FORMAT_INVAILD;
    }

    public static boolean b(@NonNull byte[] bArr) {
        if (bArr.length < 12 || bArr[0] != 0 || bArr[4] != 102 || bArr[5] != 116 || bArr[6] != 121 || bArr[7] != 112 || bArr[8] != 97 || bArr[9] != 118 || bArr[10] != 105 || bArr[11] != 102) {
            return false;
        }
        return true;
    }

    public static boolean c(@NonNull byte[] bArr) {
        if (bArr.length < 12 || bArr[0] != 0 || bArr[4] != 102 || bArr[5] != 116 || bArr[6] != 121 || bArr[7] != 112 || bArr[8] != 97 || bArr[9] != 118 || bArr[10] != 105 || bArr[11] != 115) {
            return false;
        }
        return true;
    }
}
