package com.tencent.liteav.base.util;

import android.net.Uri;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.JNINamespace;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
@JNINamespace("liteav")
/* loaded from: classes7.dex */
public class UrlReader {
    private static final int AVSEEK_SIZE = 65536;
    private static final int SEEK_CUR = 1;
    private static final int SEEK_END = 2;
    private static final int SEEK_SET = 0;
    private static final String TAG = "UrlReader";
    private int mFileSize;
    private long mOffset;
    private InputStream mStream;
    private Uri mUri;

    public UrlReader(String str) {
        this.mUri = Uri.parse(str);
        open();
    }

    private void open() {
        try {
            InputStream openInputStream = ContextUtils.getApplicationContext().getContentResolver().openInputStream(this.mUri);
            this.mStream = openInputStream;
            this.mFileSize = openInputStream.available();
        } catch (FileNotFoundException unused) {
            Log.e(TAG, "Fail to open uri " + this.mUri.toString(), new Object[0]);
            this.mStream = null;
        } catch (IOException e16) {
            Log.e(TAG, "Fail to get file size " + e16.getMessage(), new Object[0]);
            this.mStream = null;
        }
    }

    private long seekFromBegin(long j3) {
        if (j3 < 0) {
            return -1L;
        }
        close();
        open();
        InputStream inputStream = this.mStream;
        if (inputStream == null) {
            return -1L;
        }
        try {
            long skip = inputStream.skip(j3);
            this.mOffset = skip;
            return skip;
        } catch (IOException e16) {
            Log.e(TAG, "Fail to seek " + j3 + " exception " + e16.getMessage(), new Object[0]);
            return -1L;
        }
    }

    private long seekFromCurrent(long j3) {
        if (j3 < 0) {
            return seekFromBegin(this.mOffset + j3);
        }
        try {
            long skip = this.mOffset + this.mStream.skip(j3);
            this.mOffset = skip;
            return skip;
        } catch (IOException e16) {
            Log.e(TAG, "Fail to seek " + j3 + " exception " + e16.getMessage(), new Object[0]);
            return -1L;
        }
    }

    private long seekFromEnd(long j3) {
        if (j3 > 0) {
            return -1L;
        }
        long j16 = this.mFileSize + j3;
        if (j16 < 0) {
            return -1L;
        }
        long j17 = this.mOffset;
        if (j16 < j17) {
            return seekFromBegin(j16);
        }
        try {
            long skip = j17 + this.mStream.skip(j16 - j17);
            this.mOffset = skip;
            return skip;
        } catch (IOException e16) {
            Log.e(TAG, "Fail to seek " + j3 + " exception " + e16.getMessage(), new Object[0]);
            return -1L;
        }
    }

    public void close() {
        InputStream inputStream = this.mStream;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e16) {
                Log.e(TAG, "Close exception " + e16.getMessage(), new Object[0]);
            }
        }
        this.mStream = null;
        this.mOffset = 0L;
        this.mFileSize = 0;
    }

    public int read(byte[] bArr, int i3) {
        InputStream inputStream = this.mStream;
        int i16 = -1;
        if (inputStream == null) {
            return -1;
        }
        try {
            i16 = inputStream.read(bArr, 0, i3);
            this.mOffset += i16;
            return i16;
        } catch (IOException e16) {
            Log.e(TAG, "Read exception " + e16.getMessage(), new Object[0]);
            return i16;
        }
    }

    public long seek(long j3, int i3) {
        if (this.mStream == null) {
            return -1L;
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 65536) {
                        return -1L;
                    }
                    return this.mFileSize;
                }
                return seekFromEnd(j3);
            }
            return seekFromCurrent(j3);
        }
        return seekFromBegin(j3);
    }
}
