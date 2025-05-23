package com.tencent.biz.pubaccount.weishi.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a {
    public static Intent a(String str, String str2) {
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(str));
        if (!TextUtils.isEmpty(str2)) {
            intent.setPackage(str2);
        }
        intent.setFlags(536870912);
        intent.putExtra("big_brother_source_key", "biz_src_jc_gzh_weishi");
        return intent;
    }

    public static void b(Context context) {
        String i3 = iz.a.g().i();
        String a16 = iz.a.g().a();
        x.f("AppMarketUtils", "goAppMarket :\npackageName = " + a16 + "\nurl = " + i3);
        try {
            Intent a17 = a(i3, a16);
            if (!(context instanceof Activity)) {
                a17.addFlags(268435456);
            }
            context.startActivity(a17);
        } catch (Exception e16) {
            x.f("AppMarketUtils", "goAppMarket error messaage = " + e16.getMessage());
        }
    }

    public static boolean c(Context context) {
        return iz.a.g().t() && d(context);
    }

    public static boolean d(Context context) {
        if (context == null) {
            x.f("AppMarketUtils", "tryGoAppMarket:context = null");
            return false;
        }
        String i3 = iz.a.g().i();
        x.l("AppMarketUtils", "goAppMarket:\nappStorePackageName = " + iz.a.g().a() + "\nappStoreVendorId =" + iz.a.g().b() + "\nappStoreScheme =" + i3);
        return (TextUtils.isEmpty(i3) || i3.startsWith("http")) ? false : true;
    }
}
