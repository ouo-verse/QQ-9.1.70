package com.tencent.biz.qqcircle.immersive.utils;

import android.content.Context;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$PushBrokeToast;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ar {
    public static void a(Context context, View view, FeedCloudMeta$PushBrokeToast feedCloudMeta$PushBrokeToast, String str) {
        if (feedCloudMeta$PushBrokeToast != null && feedCloudMeta$PushBrokeToast.should_toast.get()) {
            new com.tencent.biz.qqcircle.push.h(context, feedCloudMeta$PushBrokeToast, str).h(view);
            QLog.d("QFSPushRocketDialogUtils", 1, "Should Show bankruptcy Dialog, bonus: " + feedCloudMeta$PushBrokeToast.give_rocket_num.get());
            return;
        }
        QLog.d("QFSPushRocketDialogUtils", 1, "not need show bankruptcy Dialog.");
    }
}
