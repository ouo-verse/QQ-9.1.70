package com.tencent.biz.qqcircle.helpers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.events.QFSKuiklyEvent;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.qphone.base.util.BaseApplication;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes4.dex */
public class o {

    /* renamed from: b, reason: collision with root package name */
    private static volatile o f84644b;

    /* renamed from: a, reason: collision with root package name */
    private final BroadcastReceiver f84645a = new a();

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String a16 = com.tencent.kuikly.core.render.android.expand.module.l.a(intent);
            if (!TextUtils.isEmpty(a16) && a16.startsWith("qvideo")) {
                JSONObject b16 = com.tencent.kuikly.core.render.android.expand.module.l.b(intent);
                RFWLog.d("QFSKuiklyHelper", RFWLog.USR, "onReceive event:" + a16 + ",eventParams:" + b16);
                SimpleEventBus.getInstance().dispatchEvent(new QFSKuiklyEvent(a16, b16));
            }
        }
    }

    public static o a() {
        if (f84644b == null) {
            synchronized (o.class) {
                if (f84644b == null) {
                    f84644b = new o();
                }
            }
        }
        return f84644b;
    }

    public void b() {
        com.tencent.kuikly.core.render.android.expand.module.l.c(BaseApplication.getContext().getApplicationContext(), this.f84645a);
    }
}
