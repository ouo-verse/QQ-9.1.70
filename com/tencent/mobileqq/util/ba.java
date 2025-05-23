package com.tencent.mobileqq.util;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ba {
    public static boolean a(Context context, AppInterface appInterface) {
        if (SettingCloneUtil.readValue(context, appInterface.getCurrentAccountUin(), context.getString(R.string.h4s), AppConstants.QQSETTING_NOTIFY_BLNCONTROL_KEY, true) && ((appInterface.isBackgroundPause || !ca.b(BaseApplication.getContext())) && !az.b(context))) {
            return true;
        }
        return false;
    }
}
