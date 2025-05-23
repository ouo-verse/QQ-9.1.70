package cooperation.qzone.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* compiled from: P */
/* loaded from: classes28.dex */
public class FileTypeUtils {
    public static final String TAG = "FileTypeUtils";

    public static boolean isSevenZip(String str) throws IOException {
        FileInputStream fileInputStream;
        Throwable th5;
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th6) {
            fileInputStream = null;
            th5 = th6;
        }
        try {
            FileChannel channel = fileInputStream.getChannel();
            byte[] bArr = new byte[6];
            channel.position(0L);
            channel.read(ByteBuffer.wrap(bArr));
            if (bArr[0] == 55 && bArr[1] == 122 && bArr[2] == -68 && bArr[3] == -81 && bArr[4] == 39) {
                if (bArr[5] == 28) {
                    fileInputStream.close();
                    return true;
                }
            }
            fileInputStream.close();
            return false;
        } catch (Throwable th7) {
            th5 = th7;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th5;
        }
    }
}
