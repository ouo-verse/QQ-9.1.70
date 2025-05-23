package com.tencent.mobileqq.bigbrother;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class g {
    static IPatchRedirector $redirector_;

    public static void a(Activity activity, String str, String str2, int i3) throws ActivityNotFoundException {
        Intent intent = new Intent();
        intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        intent.putExtra("big_brother_source_key", str2);
        intent.putExtra("key_callback_id", i3);
        intent.setData(Uri.parse(str));
        activity.startActivity(intent);
    }
}
