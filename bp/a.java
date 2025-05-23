package bp;

import android.content.Context;
import android.media.AudioManager;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.util.QZLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public static String f28738b;

    /* renamed from: a, reason: collision with root package name */
    public static Context f28737a = BaseApplication.getContext();

    /* renamed from: c, reason: collision with root package name */
    public static long f28739c = -1;

    public static void a() {
        try {
            ((AudioManager) BaseApplication.getContext().getSystemService("audio")).requestAudioFocus(null, 3, 1);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static boolean b(long j3) {
        long j16 = f28739c;
        if (j16 > 0 && j16 == j3) {
            return true;
        }
        String d16 = com.qzone.video.mediadevice.a.c().d();
        if (TextUtils.isEmpty(d16)) {
            return false;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(d16);
        String str = File.separator;
        sb5.append(str);
        sb5.append("cover");
        sb5.append(str);
        sb5.append(j3);
        f28738b = sb5.toString();
        File file = new File(f28738b);
        if (file.mkdirs() || file.isDirectory()) {
            return true;
        }
        QZLog.e("GloableValue", "make cover dir: " + f28738b + " failed.");
        return false;
    }

    public static void c() {
        try {
            ((AudioManager) BaseApplication.getContext().getSystemService("audio")).abandonAudioFocus(null);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
