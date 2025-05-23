package com.tencent.qphone.base.util.log.utils;

import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MmapUtil {
    public static MappedByteBuffer getMmapFileByPath(String str, int i3) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "rw");
        FileChannel channel = randomAccessFile.getChannel();
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0L, i3);
        try {
            randomAccessFile.close();
            channel.close();
        } catch (IOException e16) {
            QLog.e("MmapUtil", 1, "Close In error: ", e16);
        }
        return map;
    }
}
