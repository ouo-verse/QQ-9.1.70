package dm0;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.ad.tangram.downloader.AdDownloadConstants;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {
    private static Intent b(Context context, String str) {
        return InstalledAppListMonitor.getLaunchIntentForPackage(context.getPackageManager(), str);
    }

    private static Intent c(String str, Uri uri) {
        Intent intent = new Intent();
        if (uri != null) {
            intent.setData(uri);
        }
        intent.addFlags(268435456);
        intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        return intent;
    }

    public static boolean d(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        Uri parse = Uri.parse(str2);
        if ("http".equalsIgnoreCase(parse.getScheme()) || "https".equalsIgnoreCase(parse.getScheme())) {
            return false;
        }
        return context.getPackageManager().resolveActivity(c(str, parse), 65536) != null;
    }

    public static void a(Intent intent, String str) {
        if (intent != null) {
            intent.putExtra("big_brother_source_key", AdDownloadConstants.DOWNLOAD_SOURCE_AD);
            intent.putExtra(LaunchParam.KEY_REF_ID, str);
        }
    }

    public static boolean e(Context context, String str, String str2) {
        Intent b16;
        if (context != null && !TextUtils.isEmpty(str) && (b16 = b(context, str)) != null) {
            try {
                a(b16, str2);
                context.startActivity(b16);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean f(Context context, String str, String str2, String str3) {
        Intent c16;
        if (context != null && !TextUtils.isEmpty(str2) && d(context, str, str2) && (c16 = c(str, Uri.parse(str2))) != null) {
            try {
                a(c16, str3);
                context.startActivity(c16);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
