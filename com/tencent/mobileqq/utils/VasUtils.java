package com.tencent.mobileqq.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class VasUtils {

    /* renamed from: a, reason: collision with root package name */
    public static String f307364a = "VasUtils";

    /* renamed from: b, reason: collision with root package name */
    private static int f307365b = 1000;

    private static void a() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.utils.VasUtils.1
            @Override // java.lang.Runnable
            public void run() {
                QQToastUtil.showQQToast(0, R.string.f167672dk);
            }
        });
    }

    public static boolean b() {
        if (StudyModeManager.t()) {
            QLog.i(f307364a, 1, "study mode, can not start by link");
            a();
            return true;
        }
        return false;
    }

    public static void c(AppInterface appInterface) {
        MqqHandler handler = appInterface.getHandler(ChatActivity.class);
        if (handler != null) {
            if (QLog.isColorLevel()) {
                QLog.d(f307364a, 2, "refreshAIO");
            }
            handler.removeMessages(16711697);
            handler.sendMessageDelayed(handler.obtainMessage(16711697), f307365b);
        }
        MqqHandler handler2 = appInterface.getHandler(MiniChatActivity.class);
        if (handler2 != null) {
            if (QLog.isColorLevel()) {
                QLog.d(f307364a, 2, "refresh miniAIO");
            }
            handler2.removeMessages(8);
            handler2.sendMessageDelayed(handler2.obtainMessage(8), f307365b);
        }
    }
}
