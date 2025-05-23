package com.tencent.luggage.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.MotionEvent;
import com.tencent.luggage.wxa.f6.c;
import com.tencent.luggage.wxa.fa.b;
import com.tencent.luggage.wxa.h1.e;
import com.tencent.luggage.wxa.i3.t;
import com.tencent.luggage.wxa.k0.d;
import com.tencent.luggage.wxa.l3.j;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \b2\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\t"}, d2 = {"Lcom/tencent/luggage/ui/WxaLaunchProxyActivity;", "Lcom/tencent/luggage/wxa/f6/c;", "Landroid/content/Intent;", "intent", "", "a", "<init>", "()V", "b", "luggage-standalone-mode-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes2.dex */
public class WxaLaunchProxyActivity extends c {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: com.tencent.luggage.ui.WxaLaunchProxyActivity$a, reason: from kotlin metadata */
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, j startParams) {
            Intrinsics.checkNotNullParameter(startParams, "startParams");
            if (context != null) {
                Intent intent = new Intent(context, (Class<?>) WxaLaunchProxyActivity.class);
                intent.putExtra("intentForStartWxa", true);
                intent.putExtra("startParams", startParams);
                b.a(context, intent);
                context.startActivity(intent);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.f6.c
    public void a(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        j jVar = (j) intent.getParcelableExtra("startParams");
        if (jVar == null) {
            w.b("Luggage.WxaLaunchProxyActivity", "onCreate get empty appid from intent.");
        } else {
            d.a(e.a(com.tencent.luggage.wxa.p6.c.class));
            t.a(this, jVar);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
