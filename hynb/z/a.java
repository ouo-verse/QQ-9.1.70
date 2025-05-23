package hynb.z;

import android.content.Context;
import hynb.p.g;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public Context f406921a;

    public a(Context context) {
        this.f406921a = context;
    }

    public void a(String str, String str2) {
        try {
            FileOutputStream openFileOutput = this.f406921a.openFileOutput(str, 0);
            openFileOutput.write(str2.getBytes());
            openFileOutput.close();
        } catch (Exception e16) {
            e16.printStackTrace();
            g.f406799a.info("FileUtil", "writeFileString error:" + e16.getMessage());
        }
    }

    public String a(String str) {
        try {
            FileInputStream openFileInput = this.f406921a.openFileInput(str);
            byte[] bArr = new byte[64];
            StringBuilder sb5 = new StringBuilder("");
            while (true) {
                int read = openFileInput.read(bArr);
                if (read > 0) {
                    sb5.append(new String(bArr, 0, read));
                } else {
                    openFileInput.close();
                    return sb5.toString();
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            g.f406799a.info("FileUtil", "readFileString error:" + e16.getMessage());
            return "";
        }
    }
}
