package i05;

import android.text.TextUtils;
import com.tencent.open.base.g;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.utils.l;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f407013a = {" ", "<", ">", "|", ":", "/", "\\", "\""};

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        l.i("DownloadUtils_", "[filterUnSupportStr] before = " + str);
        for (String str2 : f407013a) {
            str = str.replace(str2, "_");
        }
        l.i("DownloadUtils_", "[filterUnSupportStr] end = " + str);
        return str;
    }

    public static String b(String str) {
        l.i("DownloadUtils_", "[genFileNameFromUrl] url = " + str);
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String a16 = a(g.d(str));
        l.i("DownloadUtils_", "[genFileNameFromUrl] fileName = " + a16);
        return a16;
    }

    public static String c() {
        BaseApplication context = BaseApplication.getContext();
        if (context == null) {
            return null;
        }
        return context.getFilesDir().getAbsolutePath() + "/yoloesports/download/";
    }
}
