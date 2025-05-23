package n1;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.mobileqq.R;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static Random f417977a = new Random(SystemClock.uptimeMillis());

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f417978b = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");

    public static boolean a(Context context, String str, long j3, boolean z16) {
        return b(context, new File(c(context, str)), j3, z16);
    }

    public static boolean b(Context context, File file, long j3, boolean z16) {
        if (file.exists()) {
            if (j3 != 0 && file.length() != j3) {
                if (z16) {
                    file.delete();
                    return false;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    public static String c(Context context, String str) {
        return h(context) + File.separator + str;
    }

    public static long d(File file) {
        StatFs statFs = new StatFs(file.getPath());
        return statFs.getBlockSize() * (statFs.getAvailableBlocks() - 4);
    }

    public static String e(long j3, long j16) {
        if (j16 == 0) {
            return "";
        }
        return String.format("%.2f", Float.valueOf(((float) j3) / 1048576.0f)) + "MB /" + String.format("%.2f", Float.valueOf(((float) j16) / 1048576.0f)) + "MB";
    }

    public static int f(int i3) {
        switch (i3) {
            case 1:
                return R.string.f228336tg;
            case 2:
                return R.string.f228326tf;
            case 3:
                return R.string.f228246t8;
            case 4:
                return R.string.f228256t9;
            case 5:
                return R.string.f228236t7;
            case 6:
                return R.string.f228386tl;
            case 7:
                return R.string.f228366tj;
            case 8:
                return R.string.f228416to;
            case 9:
                return R.string.f228426tp;
            case 10:
                return R.string.f228416to;
            case 11:
                return R.string.f228426tp;
            case 12:
                return R.string.f228396tm;
            case 13:
                return R.string.f228376tk;
            case 14:
                return R.string.f228406tn;
            case 15:
                return R.string.f228316te;
            case 16:
                return R.string.f228296tc;
            case 17:
                return R.string.f228306td;
            case 18:
                return R.string.f228286tb;
            default:
                return R.string.f228436tq;
        }
    }

    public static File g(String str) {
        File downloadCacheDirectory = Environment.getDownloadCacheDirectory();
        if (str.startsWith(downloadCacheDirectory.getPath())) {
            return downloadCacheDirectory;
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (str.startsWith(externalStorageDirectory.getPath())) {
            return externalStorageDirectory;
        }
        throw new IllegalArgumentException("Cannot determine filesystem root for " + str);
    }

    public static String h(Context context) {
        return Environment.getExternalStorageDirectory().toString() + a.f417971a + context.getPackageName();
    }

    public static String i(long j3) {
        SimpleDateFormat simpleDateFormat;
        if (j3 > 3600000) {
            simpleDateFormat = new SimpleDateFormat(DateUtil.DATE_FORMAT_HOUR, Locale.getDefault());
        } else {
            simpleDateFormat = new SimpleDateFormat("mm:ss", Locale.getDefault());
        }
        return simpleDateFormat.format(new Date(j3 - TimeZone.getDefault().getRawOffset()));
    }

    public static boolean j() {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return false;
        }
        return true;
    }

    public static boolean k(String str) {
        String replaceFirst = str.replaceFirst("/+", "/");
        if (!replaceFirst.startsWith(Environment.getDownloadCacheDirectory().toString()) && !replaceFirst.startsWith(Environment.getExternalStorageDirectory().toString())) {
            return false;
        }
        return true;
    }
}
