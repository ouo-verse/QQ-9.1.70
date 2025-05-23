package oicq.wlogin_sdk.report;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class report_t implements Serializable {
    public static String FILE_NAME = "wtlogin_report_data";
    private static final long serialVersionUID = 1;

    public static synchronized void delete_file(Context context) {
        synchronized (report_t.class) {
            File file = new File(context.getFilesDir(), FILE_NAME);
            if (file.exists() && file.isFile()) {
                file.delete();
            }
        }
    }

    public static synchronized Reporter read_fromfile(Context context) {
        Reporter reporter;
        synchronized (report_t.class) {
            try {
                FileInputStream fileInputStream = new FileInputStream(new File(context.getFilesDir(), FILE_NAME));
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                reporter = (Reporter) new ObjectInputStream(bufferedInputStream).readObject();
                bufferedInputStream.close();
                fileInputStream.close();
            } catch (Exception unused) {
                util.LOGI("read " + FILE_NAME + "failed");
                return null;
            }
        }
        return reporter;
    }

    public static synchronized int write_tofile(Reporter reporter, Context context) {
        synchronized (report_t.class) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(reporter);
                objectOutputStream.flush();
                objectOutputStream.close();
                FileOutputStream fileOutputStream = new FileOutputStream(new File(context.getFilesDir(), FILE_NAME));
                byteArrayOutputStream.writeTo(fileOutputStream);
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                fileOutputStream.close();
            } catch (Exception e16) {
                util.LOGI(e16.getStackTrace().toString());
                return -1;
            }
        }
        return 0;
    }
}
