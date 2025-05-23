package cc2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.base.f;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavUtil;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f30639a = "a";

    private static boolean a(Activity activity) {
        if (activity == null) {
            return false;
        }
        if (NetworkUtil.isNetworkAvailable(activity.getApplication())) {
            return true;
        }
        QfavUtil.Q(activity, R.string.f170702lr, 1);
        return false;
    }

    public static boolean b(Activity activity, String str, long j3, String str2, String str3, String str4) {
        if (!a(activity)) {
            return false;
        }
        if (!TextUtils.isEmpty(str) && str.startsWith("mqqapi://")) {
            return c(activity, str);
        }
        return c(activity, "mqqapi://vaslive/watch?roomid=" + j3 + "&source=" + str2 + "&from=" + str3 + "&platform=" + str4);
    }

    public static boolean c(Activity activity, String str) {
        if (QLog.isColorLevel()) {
            f.e(f30639a, "enter now live room. mqqapi= " + str);
        }
        try {
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(str));
            intent.putExtra("big_brother_source_key", "biz_src_now");
            activity.startActivity(intent);
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                f.e(f30639a, "enter now live room error: " + e16.getMessage());
                return false;
            }
            return false;
        }
    }
}
