package com.tencent.qqmusic.mediaplayer.codec.mp3;

import com.tencent.qqmusic.mediaplayer.util.Logger;
import cooperation.qzone.QZoneHelper;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.jf.dexlib2.analysis.RegisterType;

/* loaded from: classes23.dex */
public class MP3FileCheck {
    private static final String TAG = "MP3FileCheck";
    private int endPos;
    private boolean eof;
    private int frameCount;
    private int headerMask;
    private String mFilePath;
    private int pos;
    private int skipped;
    private boolean sync;
    private boolean hasCheck = false;
    private RandomAccessFile mRandomAccessFile = null;
    private int mID3V2Size = -1;
    private boolean hasID3V2 = false;
    private MP3Header header = new MP3Header();
    private byte[] buf = new byte[8192];
    private boolean isMP3 = false;

    public MP3FileCheck(String str) {
        this.mFilePath = null;
        this.mFilePath = str;
    }

    private boolean available(int i3, int i16) {
        int i17;
        if ((i3 & i16) == i16 && ((i3 >> 19) & 3) != 1 && ((i3 >> 17) & 3) != 0 && (i17 = (i3 >> 12) & 15) != 15 && i17 != 0 && ((i3 >> 10) & 3) != 3) {
            return true;
        }
        return false;
    }

    private int byte2int(byte[] bArr, int i3) {
        return (bArr[i3 + 3] & 255) | (bArr[i3] << 24) | ((bArr[i3 + 1] & 255) << 16) | ((bArr[i3 + 2] & 255) << 8);
    }

    private boolean checkAndSeekID3V2Tag() {
        byte[] bArr = new byte[10];
        int fillBuffer = fillBuffer(bArr, 0, 10);
        if (fillBuffer <= 0) {
            return false;
        }
        if (bArr[0] == 73 && bArr[1] == 68 && bArr[2] == 51) {
            int i3 = (bArr[6] << QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER) + (bArr[7] << RegisterType.DOUBLE_LO) + (bArr[8] << 7) + bArr[9];
            this.mID3V2Size = i3;
            this.hasID3V2 = true;
            seekTo(i3 - fillBuffer);
            Logger.d(TAG, "\u6709ID3V2\uff0cID3V2\u5927\u5c0f = " + this.mID3V2Size);
        } else {
            closeFileStream();
            Logger.d(TAG, "\u6ca1\u6709\u6709ID3V2");
        }
        return this.hasID3V2;
    }

    private void closeFileStream() {
        RandomAccessFile randomAccessFile = this.mRandomAccessFile;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (IOException e16) {
                Logger.e(TAG, e16);
            }
            this.mRandomAccessFile = null;
        }
    }

    private int fillBuffer(byte[] bArr, int i3, int i16) {
        try {
            if (this.mRandomAccessFile == null) {
                this.mRandomAccessFile = new RandomAccessFile(this.mFilePath, "r");
            }
            return this.mRandomAccessFile.read(bArr, i3, i16);
        } catch (Exception unused) {
            return -1;
        }
    }

    public static boolean isMp3File(String str) {
        return new MP3FileCheck(str).isMp3File();
    }

    private void nextFrameHeader() {
        int i3 = 0;
        while (!this.eof && !syncFrame()) {
            int i16 = this.endPos;
            int i17 = this.pos;
            int i18 = i16 - i17;
            if (i18 > 0) {
                byte[] bArr = this.buf;
                System.arraycopy(bArr, i17, bArr, 0, i18);
            }
            int fillBuffer = fillBuffer(this.buf, i18, this.pos) + i18;
            this.endPos = fillBuffer;
            if (fillBuffer <= i18 || (i3 = i3 + this.pos) > 65536) {
                this.eof = true;
            }
            this.pos = 0;
        }
    }

    private void seekTo(int i3) {
        try {
            this.mRandomAccessFile.seek(i3);
        } catch (Exception e16) {
            Logger.e(TAG, e16);
        }
    }

    private boolean syncFrame() {
        int i3 = this.pos;
        if (this.endPos - i3 <= 4) {
            return false;
        }
        int byte2int = byte2int(this.buf, i3);
        this.pos += 4;
        System.out.println(this.frameCount);
        while (true) {
            if (this.eof) {
                break;
            }
            while (!available(byte2int, this.headerMask)) {
                byte[] bArr = this.buf;
                int i16 = this.pos;
                int i17 = i16 + 1;
                this.pos = i17;
                byte2int = (byte2int << 8) | (bArr[i16] & 255);
                if (i17 == this.endPos) {
                    int i18 = this.skipped;
                    int i19 = i17 - 4;
                    this.pos = i19;
                    this.skipped = i18 + (i19 - i3);
                    return false;
                }
            }
            int i26 = this.pos;
            if (i26 > i3 + 4) {
                this.sync = false;
                this.skipped += (i26 - 4) - i3;
            }
            this.header.decode(byte2int);
            int frameSize = this.header.getFrameSize();
            int i27 = this.pos;
            int i28 = i27 + frameSize;
            int i29 = this.endPos;
            if (i28 > i29 + 4) {
                int i36 = this.skipped;
                int i37 = i27 - 4;
                this.pos = i37;
                this.skipped = i36 + (i37 - i3);
                return false;
            }
            if (this.sync) {
                break;
            }
            if (i28 > i29) {
                int i38 = this.skipped;
                int i39 = i27 - 4;
                this.pos = i39;
                this.skipped = i38 + (i39 - i3);
                return false;
            }
            int i46 = (1572864 & byte2int) | (-2097152) | (393216 & byte2int) | (byte2int & 3072);
            if (available(byte2int(this.buf, (i27 - 4) + frameSize), i46)) {
                if (this.headerMask == -2097152) {
                    this.headerMask = i46;
                }
                this.sync = true;
            } else {
                byte[] bArr2 = this.buf;
                int i47 = this.pos;
                this.pos = i47 + 1;
                byte2int = (byte2int << 8) | (bArr2[i47] & 255);
            }
        }
        if (this.header.isProtected()) {
            this.pos += 2;
        }
        this.frameCount++;
        int i48 = this.skipped;
        if (i48 > 0 || (i48 == 0 && this.sync)) {
            this.isMP3 = true;
            this.skipped = 0;
        }
        return true;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x003a -> B:7:0x003d). Please report as a decompilation issue!!! */
    public void fileCheck() {
        try {
            try {
                try {
                    this.hasCheck = true;
                    checkAndSeekID3V2Tag();
                    this.headerMask = -2097152;
                    this.sync = false;
                    this.eof = false;
                    this.frameCount = 0;
                    int length = this.buf.length;
                    this.pos = length;
                    this.endPos = length;
                    this.header.initialize();
                    nextFrameHeader();
                    RandomAccessFile randomAccessFile = this.mRandomAccessFile;
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                } catch (Throwable th5) {
                    RandomAccessFile randomAccessFile2 = this.mRandomAccessFile;
                    if (randomAccessFile2 != null) {
                        try {
                            randomAccessFile2.close();
                        } catch (Exception e16) {
                            Logger.e(TAG, e16);
                        }
                    }
                    throw th5;
                }
            } catch (Exception e17) {
                Logger.e(TAG, e17);
                RandomAccessFile randomAccessFile3 = this.mRandomAccessFile;
                if (randomAccessFile3 != null) {
                    randomAccessFile3.close();
                }
            }
        } catch (Exception e18) {
            Logger.e(TAG, e18);
        }
    }

    public int getFrameSize() {
        MP3Header mP3Header = this.header;
        if (mP3Header != null) {
            return mP3Header.getFrameSize();
        }
        return -1;
    }

    private boolean isMp3File() {
        if (!this.hasCheck) {
            fileCheck();
        }
        return this.isMP3;
    }
}
