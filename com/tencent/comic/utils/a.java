package com.tencent.comic.utils;

import android.app.Activity;
import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a {
    public static AppRuntime a() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    public static Application b() {
        return MobileQQ.sMobileQQ;
    }

    public static void c(Activity activity, String str, String str2, int i3) throws ActivityNotFoundException {
        Intent intent = new Intent();
        intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        intent.putExtra("big_brother_source_key", str2);
        intent.putExtra("key_callback_id", i3);
        intent.setData(Uri.parse(str));
        activity.startActivity(intent);
    }
}
