package com.tencent.qqmusic.mediaplayer.codec.wav;

import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes23.dex */
public class WaveReader {
    private static final String TAG = "WaveReader";
    private static final int WAV_FORMAT = 1463899717;
    private static final int WAV_FORMAT_CHUNK_ID = 1718449184;
    private static final int WAV_HEADER_CHUNK_ID = 1380533830;
    private static final int WAV_HEADER_SIZE = 50;

    private static short byteToShortLE(byte b16, byte b17) {
        return (short) ((b16 & 255) | ((b17 & 255) << 8));
    }

    public static boolean isWavFormat(String str) {
        FileInputStream fileInputStream;
        byte[] bArr = new byte[50];
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(str);
                try {
                    int readUnsignedInt = readUnsignedInt(bArr, 0);
                    if (readUnsignedInt != WAV_HEADER_CHUNK_ID) {
                        Logger.i(TAG, "isWavFormat Invalid WAVE header chunk ID = " + readUnsignedInt);
                        try {
                            fileInputStream.close();
                        } catch (Exception e16) {
                            Logger.e(TAG, e16);
                        }
                        return false;
                    }
                    int readUnsignedInt2 = readUnsignedInt(bArr, 8);
                    if (readUnsignedInt2 != WAV_FORMAT) {
                        Logger.i(TAG, "isWavFormat Invalid WAVE format = " + readUnsignedInt2);
                        try {
                            fileInputStream.close();
                        } catch (Exception e17) {
                            Logger.e(TAG, e17);
                        }
                        return false;
                    }
                    int readUnsignedInt3 = readUnsignedInt(bArr, 12);
                    if (readUnsignedInt3 != WAV_FORMAT_CHUNK_ID) {
                        Logger.i(TAG, "isWavFormat Invalid WAVE format chunk ID formatId = " + readUnsignedInt3);
                        try {
                            fileInputStream.close();
                        } catch (Exception e18) {
                            Logger.e(TAG, e18);
                        }
                        return false;
                    }
                    Logger.i(TAG, "isWavFormat formatSize = " + readUnsignedIntLE(bArr, 16));
                    Logger.i(TAG, "isWavFormat mAudioFormat = " + ((int) readUnsignedShortLE(bArr, 20)));
                    try {
                        fileInputStream.close();
                        return true;
                    } catch (Exception e19) {
                        Logger.e(TAG, e19);
                        return true;
                    }
                } catch (Exception e26) {
                    e = e26;
                    fileInputStream2 = fileInputStream;
                    Logger.e(TAG, e);
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception e27) {
                            Logger.e(TAG, e27);
                        }
                    }
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e28) {
                            Logger.e(TAG, e28);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                fileInputStream = fileInputStream2;
            }
        } catch (Exception e29) {
            e = e29;
        }
    }

    private static int readUnsignedInt(byte[] bArr, int i3) throws IOException {
        if (i3 + 4 > bArr.length) {
            return -1;
        }
        return (bArr[i3 + 3] & 255) | ((bArr[i3] & 255) << 24) | ((bArr[i3 + 1] & 255) << 16) | ((bArr[i3 + 2] & 255) << 8);
    }

    private static int readUnsignedIntLE(byte[] bArr, int i3) throws IOException {
        if (i3 + 4 > bArr.length) {
            return -1;
        }
        return ((bArr[i3 + 3] & 255) << 24) | (bArr[0] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16);
    }

    private static short readUnsignedShortLE(byte[] bArr, int i3) throws IOException {
        if (i3 + 2 > bArr.length) {
            return (short) -1;
        }
        return byteToShortLE(bArr[i3], bArr[i3 + 1]);
    }
}
