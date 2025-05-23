package c.t.m.g;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes.dex */
public class l3 {
    public static void a(byte[] bArr, File file, boolean z16) throws IOException {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file, z16));
                try {
                    bufferedOutputStream2.write(bArr);
                    bufferedOutputStream2.flush();
                    v3.a(bufferedOutputStream2);
                } catch (IOException e16) {
                } catch (Throwable th5) {
                    th = th5;
                    bufferedOutputStream = bufferedOutputStream2;
                    v3.a(bufferedOutputStream);
                    throw th;
                }
            } catch (IOException e17) {
                throw e17;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static void a(byte[] bArr, File file) throws IOException {
        a(bArr, file, true);
    }
}
