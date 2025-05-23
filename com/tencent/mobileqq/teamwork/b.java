package com.tencent.mobileqq.teamwork;

import android.text.TextUtils;
import com.tencent.av.video.effect.utils.CommonUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Random;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static String f292028a = "tencentdoc_url_config";

    /* renamed from: b, reason: collision with root package name */
    public static String f292029b = "tencentdoc_pre_img_url_doc";

    /* renamed from: c, reason: collision with root package name */
    public static String f292030c = "tencentdoc_pre_img_url_sheet";

    /* renamed from: d, reason: collision with root package name */
    public static String f292031d = "tencentdoc_pre_img_url_miniproj_doc";

    /* renamed from: e, reason: collision with root package name */
    public static String f292032e = "tencentdoc_pre_img_url_miniproj_sheet";

    public static Long a() {
        return Long.valueOf((((int) (System.currentTimeMillis() / 1000)) << 32) | Math.abs(new Random().nextInt()));
    }

    public static String b(TeamWorkFileImportInfo teamWorkFileImportInfo) {
        if (teamWorkFileImportInfo.f292070d == 1) {
            return teamWorkFileImportInfo.C;
        }
        return teamWorkFileImportInfo.f292073e0;
    }

    public static String c(String str) {
        int lastIndexOf;
        if (str != null && str.length() > 0 && (lastIndexOf = str.lastIndexOf(46)) > -1 && lastIndexOf < str.length()) {
            return str.substring(0, lastIndexOf);
        }
        return str;
    }

    public static String d(String str) {
        int indexOf;
        if (!TextUtils.isEmpty(str) && (indexOf = str.indexOf(":")) > 0) {
            return str.substring(0, indexOf).toLowerCase();
        }
        return "";
    }

    public static boolean e(Collection collection) {
        if (collection != null && !collection.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void f(AppInterface appInterface) {
        if (appInterface == null) {
            if (QLog.isColorLevel()) {
                QLog.d(CommonUtils.TAG, 2, "voice input helper preInit invalid app");
                return;
            }
            return;
        }
        MobileQQ application = appInterface.getApplication();
        if (application != null) {
            ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).soLibraryCheckerExecute(application.getApplicationContext());
            if (QLog.isColorLevel()) {
                QLog.d(CommonUtils.TAG, 2, "voice input helper preInit doing");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(CommonUtils.TAG, 2, "voice input helper preInit app.getApplication() is empty");
        }
    }
}
