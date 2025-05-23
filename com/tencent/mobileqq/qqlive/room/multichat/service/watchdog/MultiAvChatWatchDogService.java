package com.tencent.mobileqq.qqlive.room.multichat.service.watchdog;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes17.dex */
public class MultiAvChatWatchDogService extends com.tencent.mobileqq.qqlive.room.multichat.service.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static boolean f271660a;

    /* renamed from: b, reason: collision with root package name */
    private static int f271661b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f271662c;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqlive.room.multichat.service.watchdog.MultiAvChatWatchDogService$1, reason: invalid class name */
    /* loaded from: classes17.dex */
    class AnonymousClass1 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ MultiAvChatWatchDogService this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                if (MultiAvChatWatchDogService.a(null)) {
                    return;
                }
                MultiAvChatWatchDogService.b(null);
                ThreadManagerV2.getUIHandlerV2().postDelayed(MultiAvChatWatchDogService.c(null), MultiAvChatWatchDogService.f271661b * 1000);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public interface a {
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56229);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        f271660a = true;
        f271661b = 10;
        f271662c = false;
        e();
    }

    static /* bridge */ /* synthetic */ boolean a(MultiAvChatWatchDogService multiAvChatWatchDogService) {
        throw null;
    }

    static /* bridge */ /* synthetic */ a b(MultiAvChatWatchDogService multiAvChatWatchDogService) {
        throw null;
    }

    static /* bridge */ /* synthetic */ Runnable c(MultiAvChatWatchDogService multiAvChatWatchDogService) {
        throw null;
    }

    private static void e() {
        if (f271662c) {
            return;
        }
        f271662c = true;
        try {
            JSONObject jsonString = VasToggle.QQLIVE_MULTI_CHAT_UPDATE_LOOP_CONFIG.getJsonString();
            if (jsonString == null) {
                QLog.e("MultiChatWatchDog", 1, "parseConfig fail! json is null!");
                return;
            }
            QLog.i("MultiChatWatchDog", 1, "json =: " + jsonString);
            f271660a = jsonString.optBoolean("enable_open", true);
            f271661b = jsonString.optInt("loop_interval", 10);
            QLog.i("MultiChatWatchDog", 1, "sEnableOpenWatchDog: " + f271660a + " sLoopInterval:" + f271661b);
        } catch (Exception e16) {
            QLog.e("MultiChatWatchDog", 1, "parse config fail!", e16);
        }
    }
}
