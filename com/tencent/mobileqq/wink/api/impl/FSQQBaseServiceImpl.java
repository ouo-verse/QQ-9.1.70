package com.tencent.mobileqq.wink.api.impl;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.flashshow.api.hybird.FSPublishHybirdFragment;
import com.tencent.mobileqq.webview.constants.QQBrowserActivityConstants;
import com.tencent.mobileqq.wink.api.IFSQQBaseService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes21.dex */
public class FSQQBaseServiceImpl implements IFSQQBaseService {
    private static final String TAG = "FSQQBaseServiceImpl";
    private ConditionSearchManager mSearchManager;

    @Override // com.tencent.mobileqq.wink.api.IFSQQBaseService
    public Intent handleFSPublishHybirdActivityIntent(Context context, String str, Intent intent, int i3) {
        if (TextUtils.isEmpty(str)) {
            QLog.i(TAG, 1, "handleFSHybirdActivityIntent url isEmpty");
            return intent;
        }
        if (context == null) {
            context = MobileQQ.sMobileQQ.getApplicationContext();
        }
        if (intent == null) {
            intent = new Intent();
        }
        intent.putExtra("url", str);
        com.tencent.mobileqq.flashshow.api.hybird.a.c(intent, str);
        intent.putExtra("titleBarStyle", 6);
        intent.putExtra(QQBrowserActivityConstants.KEY_TITLE_STYLE, com.tencent.mobileqq.flashshow.api.hybird.a.b().d(context, str));
        if (com.tencent.mobileqq.flashshow.api.hybird.a.e(str)) {
            intent.putExtra("fromOneCLickCLose", false);
            intent.setClass(context, QQTranslucentBrowserActivity.class);
        } else {
            intent.putExtra("fromOneCLickCLose", true);
            intent.setClass(context, QQBrowserActivity.class);
        }
        intent.putExtra("fragment_class", FSPublishHybirdFragment.class.getCanonicalName());
        if (i3 != -1) {
            intent.putExtra("fragment_class", FSPublishHybirdFragment.class.getCanonicalName());
        } else {
            intent.addFlags(268435456);
        }
        return intent;
    }
}
