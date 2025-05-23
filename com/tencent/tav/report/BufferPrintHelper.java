package com.tencent.tav.report;

import android.util.Log;
import androidx.annotation.Nullable;
import com.tencent.tav.decoder.logger.Logger;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: classes26.dex */
public class BufferPrintHelper {
    public static final String SDCARD_TAVKIT_DEMO_INFO = "/sdcard/tavkit_demo/info/";
    private static final String TAG = "DebugUtils";
    private boolean clearOldFile;
    private int ignoreCount;
    private long waitMs;
    private long startTimeMs = 0;
    private String startName = "";
    private boolean printStarted = false;
    private int maxPrintCount = 0;
    private long startIndex = 0;
    private List<String> list = new ArrayList();

    /* loaded from: classes26.dex */
    private static class Instance {
        private static BufferPrintHelper INSTANCE = new BufferPrintHelper();

        Instance() {
        }
    }

    private static void clearFiles() {
        File file = new File(SDCARD_TAVKIT_DEMO_INFO);
        if (file.exists()) {
            deleteAllFiles(file);
        }
    }

    public static ByteBuffer clone(ByteBuffer byteBuffer) {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.capacity());
        byteBuffer.rewind();
        allocate.put(byteBuffer);
        byteBuffer.rewind();
        allocate.flip();
        return allocate;
    }

    public static File createNewFile(String str, String str2) {
        File file = new File(str);
        if (!file.exists() && !file.mkdirs()) {
            return null;
        }
        File file2 = new File(file, str2);
        try {
            if (file2.delete()) {
                Log.d(TAG, "export: \u6587\u4ef6\u5df2\u5b58\u5728\uff0c\u5220\u9664");
            }
            if (!file2.createNewFile()) {
                Log.e(TAG, "export: \u521b\u5efa\u8f93\u51fa\u6587\u4ef6\u5931\u8d25:" + file2.getAbsolutePath());
                return null;
            }
            return file2;
        } catch (IOException e16) {
            e16.printStackTrace();
            Log.e(TAG, "export: \u521b\u5efa\u8f93\u51fa\u6587\u4ef6\u5931\u8d25, e = ", e16);
            return null;
        }
    }

    private static void deleteAllFiles(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                deleteAllFiles(file2);
                file2.delete();
            } else if (file2.exists()) {
                deleteAllFiles(file2);
                file2.delete();
            }
        }
    }

    public static BufferPrintHelper getInstance() {
        return Instance.INSTANCE;
    }

    @Nullable
    private File newFile(String str) {
        String str2;
        long j3 = this.startIndex + 1;
        this.startIndex = j3;
        if (j3 > this.ignoreCount && System.currentTimeMillis() >= this.startTimeMs + this.waitMs) {
            this.printStarted = true;
        }
        if (this.printStarted && !this.list.contains(str)) {
            int i3 = this.maxPrintCount - 1;
            this.maxPrintCount = i3;
            if (i3 >= 0) {
                this.list.add(str);
                if (this.clearOldFile) {
                    str2 = "";
                } else {
                    str2 = this.startName + "-";
                }
                File createNewFile = createNewFile(SDCARD_TAVKIT_DEMO_INFO, str2 + str + ".tavfile");
                if (createNewFile == null) {
                    return null;
                }
                return createNewFile;
            }
        }
        return null;
    }

    public static void reset() {
        BufferPrintHelper unused = Instance.INSTANCE = new BufferPrintHelper();
    }

    public void init(long j3, int i3, int i16, boolean z16) {
        this.waitMs = j3;
        this.ignoreCount = i3;
        this.maxPrintCount = i16;
        this.clearOldFile = z16;
        this.startTimeMs = System.currentTimeMillis();
        this.startName = new SimpleDateFormat("HHmmss").format(new Date(this.startTimeMs));
        if (z16) {
            clearFiles();
        }
    }

    public void printByteBuffer(String str, ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            Logger.e(TAG, "saveByteBuffer: buffer is null");
        } else {
            printByteBuffer(str, clone(byteBuffer).array());
        }
    }

    public void printShortBuffer(String str, ShortBuffer shortBuffer) {
        printShortBuffer(str, clone(shortBuffer).array());
    }

    public void printShotBuffer(String str, ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            Logger.e(TAG, "saveByteBuffer: buffer is null");
        } else {
            printShortBuffer(str, clone(byteBuffer).asShortBuffer());
        }
    }

    public void saveByteBuffer(String str, ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            Logger.e(TAG, "saveByteBuffer: buffer is null");
        } else {
            saveByteBuffer(str, clone(byteBuffer).array());
        }
    }

    public void printShortBuffer(String str, short[] sArr) {
        File newFile = newFile(str);
        if (newFile == null) {
            return;
        }
        try {
            PrintStream printStream = new PrintStream(newFile);
            for (short s16 : sArr) {
                printStream.println((int) s16);
            }
            printStream.close();
        } catch (IOException e16) {
            Logger.e(TAG, "printShortBuffer: ", e16);
        }
    }

    public void printByteBuffer(String str, byte[] bArr) {
        File newFile = newFile(str);
        if (newFile == null) {
            return;
        }
        try {
            PrintStream printStream = new PrintStream(newFile);
            for (byte b16 : bArr) {
                printStream.println((int) b16);
            }
            printStream.close();
        } catch (IOException e16) {
            Logger.e(TAG, "printBuffer: ", e16);
        }
    }

    public void saveByteBuffer(String str, byte[] bArr) {
        File newFile = newFile(str);
        if (newFile == null) {
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(newFile);
            fileOutputStream.write(bArr);
            fileOutputStream.close();
        } catch (IOException e16) {
            Logger.e(TAG, "printBuffer: ", e16);
        }
    }

    public static ShortBuffer clone(ShortBuffer shortBuffer) {
        ShortBuffer allocate = ShortBuffer.allocate(shortBuffer.capacity());
        shortBuffer.rewind();
        allocate.put(shortBuffer);
        shortBuffer.rewind();
        allocate.flip();
        return allocate;
    }
}
