package com.tencent.icgame.game.initer.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.icgame.game.utils.g;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.timi.game.app.event.AppBecomeBackgroundEvent;
import com.tencent.timi.game.app.event.AppBecomeForegroundEvent;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
/* loaded from: classes7.dex */
public class TGQQAppLifecycleReceiver extends BroadcastReceiver {
    private void a(Context context, boolean z16) {
        if (!z16) {
            if (!BaseGesturePWDUtil.isAppOnForeground(context)) {
                b();
                return;
            }
            g.d("ICGameTGQQAppLifecycleReceiver", "onReceive ACTION_QQ_BACKGROUND but AppOnForeground - " + bu0.a.b());
            return;
        }
        if (BaseGesturePWDUtil.isAppOnForeground(context)) {
            c();
            return;
        }
        g.d("ICGameTGQQAppLifecycleReceiver", "onReceive ACTION_QQ_FOREGROUND but !isAppOnForeground - " + bu0.a.b());
    }

    private void b() {
        g.h("ICGameTGQQAppLifecycleReceiver", "postEvent - AppBecomeBackgroundEvent");
        SimpleEventBus.getInstance().dispatchEvent(new AppBecomeBackgroundEvent());
    }

    private void c() {
        g.h("ICGameTGQQAppLifecycleReceiver", "postEvent - AppBecomeForegroundEvent");
        SimpleEventBus.getInstance().dispatchEvent(new AppBecomeForegroundEvent());
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction() != null) {
            String stringExtra = intent.getStringExtra("process_name");
            g.h("ICGameTGQQAppLifecycleReceiver", "onReceive processName=" + stringExtra + ", action: " + intent.getAction());
            boolean z16 = false;
            if (IECScreenReceiver.ACTION_QQ_BACKGROUND.equals(intent.getAction())) {
                if (stringExtra != null && stringExtra.equals("com.tencent.mobileqq")) {
                    a(context, false);
                    return;
                }
                return;
            }
            if (IECScreenReceiver.ACTION_QQ_FOREGROUND.equals(intent.getAction())) {
                if (stringExtra != null && stringExtra.contains(ProcessConstant.OPEN_SDK)) {
                    z16 = true;
                }
                if (!z16) {
                    a(context, true);
                }
            }
        }
    }
}
