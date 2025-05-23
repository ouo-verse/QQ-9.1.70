package com.tencent.tav.core.audio;

import com.tencent.tav.decoder.logger.Logger;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: P */
/* loaded from: classes26.dex */
class EncoderUtils {
    private static final int FREQ_IDX = 4;
    public static final int INDEX_START = 1;
    private static final int PROFILE = 2;
    private static final String TAG = "EncoderUtils";

    EncoderUtils() {
    }

    public static void addADTStoPacket(byte[] bArr, int i3) {
        byte[] generateADTSHeader = generateADTSHeader(bArr.length, i3);
        System.arraycopy(generateADTSHeader, 0, bArr, 0, generateADTSHeader.length);
    }

    public static void close(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th5) {
            Logger.e(TAG, "close: ", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void deleteAllTmpFiles(String str, int i3, String str2) {
        Logger.d(TAG, "deleteAllTmpFiles " + i3 + " sessionId = " + str2);
        for (int i16 = 1; i16 <= i3; i16++) {
            File file = new File(getAudioOutSaveFilePath(str, i16, str2));
            Logger.d(TAG, "delete file " + file.getAbsolutePath() + " deleteResult = " + file.delete());
        }
    }

    public static byte[] generateADTSHeader(int i3, int i16) {
        return new byte[]{-1, -7, (byte) ((i16 >> 2) + 80), (byte) (((i16 & 3) << 6) + (i3 >> 11)), (byte) ((i3 & 2047) >> 3), (byte) (((i3 & 7) << 5) + 31), -4};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getAudioOutSaveFilePath(String str, int i3, String str2) {
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf > 0) {
            return str.substring(0, lastIndexOf) + "_" + str2 + "_" + i3 + str.substring(lastIndexOf);
        }
        return str + "_" + str2 + "_" + i3;
    }

    private static boolean isValidFile(File file) throws IOException {
        if (!file.createNewFile() && (!file.exists() || !file.isFile())) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean mergeAllFiles(String str, int i3, String str2) {
        Logger.d(TAG, "mergeAllFiles " + i3 + " sessionId = " + str2);
        try {
            File file = new File(str);
            file.delete();
            if (isValidFile(file)) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                for (int i16 = 1; i16 <= i3; i16++) {
                    randomAccessFile.write(readFromFile(getAudioOutSaveFilePath(str, i16, str2)));
                }
                close(randomAccessFile);
                return true;
            }
            return false;
        } catch (Exception e16) {
            Logger.e(TAG, "mergeAllFiles: ", e16);
            return false;
        }
    }

    private static byte[] readFromFile(String str) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(str);
        try {
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            return bArr;
        } finally {
            close(fileInputStream);
        }
    }
}
