package com.tencent.mobileqq.qqexpand.chat;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes35.dex */
public class LimitChatDamon {

    /* renamed from: d, reason: collision with root package name */
    private static volatile LimitChatDamon f263511d;

    /* renamed from: a, reason: collision with root package name */
    private Runnable f263512a = null;

    /* renamed from: b, reason: collision with root package name */
    private Handler f263513b = null;

    /* renamed from: c, reason: collision with root package name */
    private long f263514c = -1;

    LimitChatDamon() {
    }

    public static LimitChatDamon b() {
        if (f263511d == null) {
            synchronized (LimitChatDamon.class) {
                if (f263511d == null) {
                    f263511d = new LimitChatDamon();
                }
            }
        }
        return f263511d;
    }

    public void c(final QQAppInterface qQAppInterface, final String str) {
        if (qQAppInterface == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LimitChatDamon", 2, "sendMessageReadConfirm invoke, uin:" + str);
        }
        synchronized (this) {
            if (this.f263512a != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("LimitChatDamon", 2, "sendMessageReadConfirm last request do not finish");
                }
            } else {
                Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.qqexpand.chat.LimitChatDamon.1
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (LimitChatDamon.this) {
                            LimitChatDamon.this.f263512a = null;
                        }
                        SessionInfo sessionInfo = new SessionInfo();
                        String str2 = str;
                        sessionInfo.f179557e = str2;
                        sessionInfo.f179559f = str2;
                        sessionInfo.f179555d = 1044;
                        ChatActivityFacade.Q0(qQAppInterface, sessionInfo);
                        if (QLog.isColorLevel()) {
                            QLog.d("LimitChatDamon", 2, "sendMessageReadConfirm , real send:" + str);
                        }
                    }
                };
                this.f263512a = runnable;
                ThreadManagerV2.executeDelay(runnable, 16, null, true, 60000L);
            }
        }
    }
}
