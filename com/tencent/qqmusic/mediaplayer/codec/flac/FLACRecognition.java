package com.tencent.qqmusic.mediaplayer.codec.flac;

import android.text.TextUtils;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;
import com.tencent.qqmusic.mediaplayer.codec.NativeDecoder;
import com.tencent.qqmusic.mediaplayer.upstream.FileDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.IOException;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes23.dex */
public class FLACRecognition implements IAudioRecognition {
    public static final String TAG = "FLACRecognition";

    private boolean checkFormatBySoftDecoder(String str) {
        NativeDecoder nativeDecoder = new NativeDecoder();
        boolean z16 = false;
        try {
            try {
            } catch (Throwable th5) {
                try {
                    Logger.e(TAG, th5);
                    nativeDecoder.release();
                } finally {
                    try {
                        nativeDecoder.release();
                    } catch (Throwable th6) {
                        Logger.e(TAG, th6);
                    }
                }
            }
        } catch (Throwable th7) {
            Logger.e(TAG, th7);
        }
        if (nativeDecoder.init(str, false) == 0) {
            AudioInformation audioInformation = nativeDecoder.getAudioInformation();
            if (audioInformation != null) {
                if (audioInformation.getAudioType() == AudioFormat.AudioType.FLAC) {
                    z16 = true;
                }
            }
            return z16;
        }
        nativeDecoder.release();
        return false;
    }

    public static boolean isFlac(IDataSource iDataSource) {
        IDataSource iDataSource2;
        int i3;
        boolean z16;
        int i16;
        byte[] bArr = new byte[10];
        try {
            iDataSource.readAt(0L, bArr, 0, 10);
        } catch (IOException unused) {
        }
        if (bArr[0] == 73 && bArr[1] == 68 && bArr[2] == 51) {
            int i17 = ((bArr[6] & Byte.MAX_VALUE) << 21) + ((bArr[7] & Byte.MAX_VALUE) << 14) + ((bArr[8] & Byte.MAX_VALUE) << 7) + (bArr[9] & Byte.MAX_VALUE);
            if ((bArr[5] & RegisterType.UNINIT_REF) > 0) {
                i3 = i17 + 20;
                z16 = true;
            } else {
                i3 = i17 + 10;
                z16 = false;
            }
            if (!z16) {
                byte[] bArr2 = new byte[1];
                try {
                    i16 = iDataSource.readAt(i3, bArr2, 0, 1);
                } catch (IOException unused2) {
                    i16 = 0;
                }
                while (bArr2[0] == 0 && i16 == 1) {
                    i3++;
                    try {
                        i16 = iDataSource.readAt(i3, bArr2, 0, 1);
                    } catch (IOException unused3) {
                    }
                }
            }
            iDataSource2 = iDataSource;
        } else {
            iDataSource2 = iDataSource;
            i3 = 0;
        }
        byte[] bArr3 = new byte[4];
        try {
            iDataSource2.readAt(i3, bArr3, 0, 4);
        } catch (IOException unused4) {
        }
        if (bArr3[0] != 102 || bArr3[1] != 76 || bArr3[2] != 97 || bArr3[3] != 67) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition
    public AudioFormat.AudioType getAudioType(String str, byte[] bArr) {
        if (bArr != null && bArr.length > 0 && new String(bArr).startsWith("flaC")) {
            return AudioFormat.AudioType.FLAC;
        }
        if (checkFormatBySoftDecoder(str)) {
            return AudioFormat.AudioType.FLAC;
        }
        return AudioFormat.AudioType.UNSUPPORT;
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition
    public AudioFormat.AudioType guessAudioType(String str) {
        boolean z16;
        if (!TextUtils.isEmpty(str)) {
            if (str.toLowerCase().contains(".flac")) {
                return AudioFormat.AudioType.FLAC;
            }
            FileDataSource fileDataSource = new FileDataSource(str);
            try {
                fileDataSource.open();
                z16 = isFlac(fileDataSource);
                try {
                    fileDataSource.close();
                } catch (IOException unused) {
                }
            } catch (IOException unused2) {
                z16 = false;
            }
            if (z16) {
                return AudioFormat.AudioType.FLAC;
            }
        }
        return AudioFormat.AudioType.UNSUPPORT;
    }
}
