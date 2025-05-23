package com.tencent.qqmusic.mediaplayer.codec.ffmpeg;

import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.FileInputStream;
import java.io.IOException;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes23.dex */
public class FfmpegRecognition implements IAudioRecognition {
    private static final String SO_AUDIO_COMMON = "audio_common";
    private static final String SO_BASE_NAME = "FFmpeg";
    private static final String SO_NAME = "ffmpeg_decoder";
    private static final String SO_NEON_BASE_NAME = "FFmpeg_v7a";
    private static final String SO_NEON_NAME = "ffmpeg_decoder_v7a";
    private static final String TAG = "FfmpegRecognition";

    public static boolean isM4a(IDataSource iDataSource) {
        byte[] bArr = new byte[4];
        try {
            iDataSource.readAt(4L, bArr, 0, 4);
        } catch (IOException unused) {
        }
        if (bArr[0] != 102 || bArr[1] != 116 || bArr[2] != 121 || bArr[3] != 112) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0075 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AudioFormat.AudioType getAudioType(String str, byte[] bArr) {
        FileInputStream fileInputStream;
        String str2;
        byte b16;
        if (bArr != null && bArr.length != 0) {
            str2 = new String(bArr);
        } else {
            FileInputStream fileInputStream2 = null;
            try {
                fileInputStream = new FileInputStream(str);
            } catch (Exception e16) {
                e = e16;
                fileInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                }
                throw th;
            }
            try {
                byte[] bArr2 = new byte[64];
                fileInputStream.read(bArr2);
                String str3 = new String(bArr2);
                try {
                    fileInputStream.close();
                } catch (Exception e17) {
                    Logger.e(TAG, e17);
                }
                str2 = str3;
            } catch (Exception e18) {
                e = e18;
                try {
                    Logger.e(TAG, e);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e19) {
                            Logger.e(TAG, e19);
                        }
                    }
                    str2 = null;
                    if (str2 == null) {
                    }
                    if (bArr != null) {
                        b16 = bArr[1];
                        if ((b16 & 240) == 240) {
                            return AudioFormat.AudioType.M4A;
                        }
                    }
                    return AudioFormat.AudioType.UNSUPPORT;
                } catch (Throwable th6) {
                    th = th6;
                    fileInputStream2 = fileInputStream;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e26) {
                            Logger.e(TAG, e26);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
                if (fileInputStream != null) {
                }
                throw th;
            }
        }
        if (str2 == null && str2.contains("ftyp")) {
            return AudioFormat.AudioType.M4A;
        }
        if (bArr != null && bArr.length > 2 && bArr[0] == -1) {
            b16 = bArr[1];
            if ((b16 & 240) == 240 && (b16 & RegisterType.DOUBLE_HI & 6) == 0) {
                return AudioFormat.AudioType.M4A;
            }
        }
        return AudioFormat.AudioType.UNSUPPORT;
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition
    public AudioFormat.AudioType guessAudioType(String str) {
        return getAudioType(str, null);
    }
}
