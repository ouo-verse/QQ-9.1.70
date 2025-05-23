package mqq.util;

import android.graphics.Bitmap;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.DataOutputStream;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes28.dex */
public class NativeUtil {
    private static boolean sLoadSO;

    static {
        try {
            System.loadLibrary("mqq");
            sLoadSO = true;
        } catch (Throwable th5) {
            th5.printStackTrace();
            QLog.e("mqq", 2, "load mqq.so error!", th5);
        }
    }

    private static native byte[] getFrameBuffer();

    private static native int getHeight();

    private static native int getWidth();

    public static Bitmap screenshot() {
        if (!sLoadSO) {
            return null;
        }
        try {
            byte[] frameBuffer = getFrameBuffer();
            if (frameBuffer == null) {
                final Process exec = RuntimeMonitor.exec(Runtime.getRuntime(), "su");
                DataOutputStream dataOutputStream = new DataOutputStream(exec.getOutputStream());
                dataOutputStream.writeBytes("chmod 666 /dev/graphics/fb0\n");
                dataOutputStream.writeBytes("exit\n");
                dataOutputStream.flush();
                new BaseThread() { // from class: mqq.util.NativeUtil.1
                    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            exec.waitFor();
                        } catch (InterruptedException e16) {
                            e16.printStackTrace();
                        }
                    }
                }.start();
                frameBuffer = getFrameBuffer();
            }
            if (frameBuffer == null) {
                return null;
            }
            int width = getWidth();
            int height = getHeight();
            ByteBuffer wrap = ByteBuffer.wrap(frameBuffer);
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(wrap);
            return createBitmap;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }
}
