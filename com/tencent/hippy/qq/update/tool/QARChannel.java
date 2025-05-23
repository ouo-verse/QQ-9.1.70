package com.tencent.hippy.qq.update.tool;

import com.tencent.hippy.qq.update.qarchive.tools.zip.ZipEntry;
import com.tencent.hippy.qq.update.qarchive.tools.zip.ZipOutputStream;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import cooperation.qzone.QZoneHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.Pipe;
import java.nio.channels.WritableByteChannel;

/* compiled from: P */
/* loaded from: classes7.dex */
public class QARChannel {

    /* compiled from: P */
    /* loaded from: classes7.dex */
    private static class ZipStreamWriter extends BaseThread {
        WritableByteChannel channel;

        ZipStreamWriter(WritableByteChannel writableByteChannel) {
            this.channel = writableByteChannel;
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                ZipOutputStream zipOutputStream = new ZipOutputStream(Channels.newOutputStream(this.channel));
                try {
                    zipOutputStream.putNextEntry(new ZipEntry("test.txt"));
                    zipOutputStream.write("This is test file content".getBytes());
                    zipOutputStream.closeEntry();
                    zipOutputStream.close();
                    this.channel.close();
                } catch (Throwable th5) {
                    zipOutputStream.close();
                    this.channel.close();
                    throw th5;
                }
            } catch (Exception unused) {
            }
        }
    }

    public static long forTransfer(File file, File file2) throws Exception {
        int i3;
        long currentTimeMillis = System.currentTimeMillis();
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        FileChannel channel = fileInputStream.getChannel();
        FileChannel channel2 = fileOutputStream.getChannel();
        while (channel.position() != channel.size()) {
            if (channel.size() - channel.position() < QZoneHelper.Constants.NO_WIFI_UPLOAD_VIDEO_MAX_SIZE_DEFAULT) {
                i3 = (int) (channel.size() - channel.position());
            } else {
                i3 = 20971520;
            }
            long j3 = i3;
            channel.transferTo(channel.position(), j3, channel2);
            channel.position(channel.position() + j3);
        }
        channel.close();
        channel2.close();
        return System.currentTimeMillis() - currentTimeMillis;
    }

    public static void main(String[] strArr) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\tmp\\1.zip");
        try {
            Pipe open = Pipe.open();
            WritableByteChannel newChannel = Channels.newChannel(fileOutputStream);
            new ZipStreamWriter(open.sink()).start();
            Pipe.SourceChannel source = open.source();
            ByteBuffer allocate = ByteBuffer.allocate(8192);
            while (source.read(allocate) >= 0) {
                allocate.flip();
                newChannel.write(allocate);
                allocate.clear();
            }
        } finally {
            fileOutputStream.close();
        }
    }
}
