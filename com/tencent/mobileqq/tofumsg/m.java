package com.tencent.mobileqq.tofumsg;

import android.os.Looper;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.activity.aio.q;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.TofuProcessSimpleEvent;

/* compiled from: P */
/* loaded from: classes18.dex */
public class m {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b() {
        SimpleEventBus.getInstance().dispatchEvent(new TofuProcessSimpleEvent(true));
    }

    public static void c(QQAppInterface qQAppInterface, String str) {
        if (QLog.isColorLevel()) {
            QLog.i("Tofu_TofuHelper", 2, "onDelFriend " + str);
        }
        ((q) qQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER)).j(str);
    }

    public static void d() {
        QLog.i("Tofu_TofuHelper", 1, "sendTofuProcessEndMsg");
        if (Looper.myLooper() != Looper.getMainLooper()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.tofumsg.l
                @Override // java.lang.Runnable
                public final void run() {
                    m.b();
                }
            });
        } else {
            SimpleEventBus.getInstance().dispatchEvent(new TofuProcessSimpleEvent(true));
        }
    }
}
