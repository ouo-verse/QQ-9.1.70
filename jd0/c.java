package jd0;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c {
    public static final String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = vc0.a.f441366f;
            File file = new File(str2);
            if (!file.exists() || !file.isDirectory()) {
                file.mkdirs();
            }
            String str3 = str2 + com.tencent.securitysdk.utils.c.b(str) + "." + com.tencent.biz.qqstory.utils.d.l(str);
            if (QLog.isColorLevel()) {
                QLog.d("zivonchen", 2, "createMusicFilePath destPath = " + str3);
            }
            return str3;
        }
        throw new NullPointerException("MusicComposeDialog.createMusicFilePath() musicUrl is null");
    }
}
