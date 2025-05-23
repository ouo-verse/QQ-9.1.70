package com.tencent.tav.report;

import android.os.Build;
import com.tencent.qcircle.weseevideo.model.MediaConfig;
import com.tencent.tav.decoder.logger.Logger;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes26.dex */
public class DebugBufferWriter {
    private static final String DIR = "/sdcard/tavkit_demo/buffers/";
    private final String TAG;
    private long lastTime;
    private Path path;

    public DebugBufferWriter() {
        this("");
    }

    public void write(byte[] bArr) {
        StandardOpenOption standardOpenOption;
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        Logger.v(this.TAG, "write() called with: bytes = [" + Arrays.toString(bArr) + "]");
        try {
            Path path = this.path;
            standardOpenOption = StandardOpenOption.APPEND;
            Files.write(path, bArr, standardOpenOption);
        } catch (IOException e16) {
            Logger.e(this.TAG, "write: ", e16);
        }
    }

    public DebugBufferWriter(String str) {
        this(DIR, str + "-" + Long.toHexString(System.nanoTime()) + MediaConfig.AUDIO_PCM_FILE_POSTFIX);
    }

    public DebugBufferWriter(String str, String str2) {
        Path path;
        String str3 = "DebugBufferWriter@" + Integer.toHexString(hashCode());
        this.TAG = str3;
        this.lastTime = -10086L;
        if (Build.VERSION.SDK_INT < 26) {
            Logger.e(str3, "DebugBufferWriter: Android O \u53ef\u7528");
            return;
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str2);
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e16) {
                Logger.e(this.TAG, "DebugBufferWriter: ", e16);
            }
        }
        path = file2.toPath();
        this.path = path;
    }

    public void write(ByteBuffer byteBuffer, long j3) {
        Logger.v(this.TAG, "write() called with: buffer = [" + byteBuffer + "], timeUs = [" + j3 + "]");
        if (j3 - this.lastTime < 100) {
            return;
        }
        this.lastTime = j3;
        write(byteBuffer);
    }

    public void write(ByteBuffer byteBuffer) {
        Logger.v(this.TAG, "write() called with: buffer = [" + byteBuffer + "]");
        if (byteBuffer == null) {
            return;
        }
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.limit());
        byteBuffer.rewind();
        allocate.put(byteBuffer);
        byteBuffer.rewind();
        allocate.flip();
        write(allocate.array());
    }
}
