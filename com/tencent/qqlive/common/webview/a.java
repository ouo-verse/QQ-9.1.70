package com.tencent.qqlive.common.webview;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    public static String a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                return str + ContainerUtils.FIELD_DELIMITER + str2;
            }
            return str + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + str2;
        }
        return str;
    }

    private static Intent b(Context context, String str, Bundle bundle, Class<? extends QQBrowserActivity> cls, int[] iArr, Integer num, String str2) {
        Intent intent = new Intent(context, cls);
        String h16 = h(str);
        if (!TextUtils.isEmpty(str2)) {
            h16 = a(h16, "qqlivestream_sdk_app_id=" + str2);
        }
        intent.putExtra("url", h16);
        intent.setData(Uri.parse(h16));
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (iArr != null) {
            for (int i3 : iArr) {
                intent.addFlags(i3);
            }
        }
        if (num != null) {
            intent.setFlags(num.intValue());
        }
        return intent;
    }

    public static boolean c() {
        e();
        return d().getBoolean("openTde", false);
    }

    private static SharedPreferences d() {
        return QMMKV.fromSpAdapter(BaseApplication.getContext(), "QQLiveCommonSp", QMMKVFile.FILE_QQLIVE);
    }

    private static void e() {
        SharedPreferences d16 = d();
        if (d16.getBoolean("sp_key_has_migrate_QQLiveCommonSp", false)) {
            return;
        }
        QMMKV.migrate(BaseApplication.getContext(), QMMKVFile.FILE_QQLIVE, BaseApplication.getContext().getSharedPreferences("QQLiveCommonSp", 0));
        d16.edit().putBoolean("sp_key_has_migrate_QQLiveCommonSp", true).apply();
    }

    public static void f(Context context, String str, Bundle bundle, Class<? extends QQBrowserActivity> cls, int[] iArr, Integer num) {
        g(context, str, bundle, cls, iArr, num, "");
    }

    public static void g(Context context, String str, Bundle bundle, Class<? extends QQBrowserActivity> cls, int[] iArr, Integer num, String str2) {
        context.startActivity(b(context, str, bundle, cls, iArr, num, str2));
    }

    public static String h(String str) {
        BaseApplication context = BaseApplication.getContext();
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.title_bar_height);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            dimensionPixelSize += ImmersiveUtils.getStatusBarHeight(context);
        }
        String b16 = HtmlOffline.b(str, "_titleBarHeight=" + ((int) ((dimensionPixelSize - 0.5f) / context.getResources().getDisplayMetrics().density)));
        if (c()) {
            if (b16.startsWith("http://")) {
                String substring = b16.substring(7);
                if (!substring.startsWith("tde.")) {
                    return "http://tde." + substring;
                }
            } else if (b16.startsWith("https://")) {
                String substring2 = b16.substring(8);
                if (!substring2.startsWith("tde.")) {
                    return "https://tde." + substring2;
                }
            } else if (!b16.startsWith("tde.")) {
                return "tde." + b16;
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("QQLiveWebViewUtils", 4, "parseUrl url:" + b16);
        }
        return b16;
    }
}
