package fs;

import android.os.Process;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;

/* compiled from: P */
/* loaded from: classes38.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    private static int f400468a;

    public static String b(int i3) {
        String str = AppConstants.SDCARD_FILE_SAVE_TMP_PATH + "edit_video/business_" + i3 + "/" + c(i3) + "/";
        FileUtils.createFileIfNotExits(str + ".nomedia");
        d(str);
        return str;
    }

    private static String c(int i3) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("T");
        sb5.append(System.currentTimeMillis());
        sb5.append("B");
        sb5.append(i3);
        sb5.append("P");
        sb5.append(Process.myPid());
        sb5.append("T");
        sb5.append(Process.myTid());
        sb5.append("I");
        int i16 = f400468a;
        f400468a = i16 + 1;
        sb5.append(i16);
        return sb5.toString();
    }

    private static void d(String str) {
        File file = new File(str);
        if (file.isFile()) {
            hd0.c.t("Q.qqstory.publish.edit.PublishFileManager", "delete file : " + file.delete());
        }
        if (file.exists()) {
            return;
        }
        hd0.c.t("Q.qqstory.publish.edit.PublishFileManager", "create folder : " + file.mkdirs());
    }

    public static String a(int i3, String str, String str2) {
        if (str != null) {
            if (!str.endsWith("/")) {
                str = str + "/";
            }
            return str + System.currentTimeMillis() + "_" + c(i3) + str2;
        }
        throw new IllegalArgumentException("folderPath should not be null");
    }
}
