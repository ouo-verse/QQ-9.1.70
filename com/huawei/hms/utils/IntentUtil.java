package com.huawei.hms.utils;

import android.content.Intent;
import com.huawei.hms.support.api.entity.common.CommonConstant;

/* compiled from: P */
/* loaded from: classes2.dex */
public class IntentUtil {
    public static Intent modifyIntentBehaviorsSafe(Intent intent) {
        if (intent == null) {
            return null;
        }
        String action = intent.getAction();
        if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action) || "android.media.action.IMAGE_CAPTURE".equals(action) || "android.media.action.IMAGE_CAPTURE_SECURE".equals(action) || "android.media.action.VIDEO_CAPTURE".equals(action)) {
            intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        }
        intent.setFlags(intent.getFlags() & (-129) & (-65) & (-2) & (-3));
        return intent;
    }
}
