package com.tencent.qphone.base.util.log.utils;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MappedLogWriter {
    private static final String TAG = "MappedLogWriter";
    FileOutputStream fileOutputStream;

    public MappedLogWriter(String str) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            file.createNewFile();
        }
        this.fileOutputStream = new FileOutputStream(file, true);
    }

    public void close() throws IOException {
        FileOutputStream fileOutputStream = this.fileOutputStream;
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
    }

    public void writeThroughByteArray(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            try {
                this.fileOutputStream.getChannel().write(ByteBuffer.wrap(bArr));
            } catch (Throwable th5) {
                Log.e(TAG, "writeThroughByteArray failed. ", th5);
            }
        }
    }

    public void writeThroughMmapBuffer(MappedByteBuffer mappedByteBuffer) {
        try {
            this.fileOutputStream.getChannel().write(mappedByteBuffer);
        } catch (IOException e16) {
            e16.printStackTrace();
        }
    }
}
