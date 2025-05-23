package com.xiaomi.mipush.sdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.push.de;
import com.xiaomi.push.df;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
@TargetApi(14)
/* loaded from: classes28.dex */
public class r implements Application.ActivityLifecycleCallbacks {

    /* renamed from: d, reason: collision with root package name */
    private Set<String> f388088d = new HashSet();

    private static void a(Application application) {
        application.registerActivityLifecycleCallbacks(new r());
    }

    public static void b(Context context) {
        a((Application) context.getApplicationContext());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        try {
            Intent intent = activity.getIntent();
            if (intent == null) {
                return;
            }
            String stringExtra = intent.getStringExtra("messageId");
            int intExtra = intent.getIntExtra("eventMessageType", -1);
            if (!TextUtils.isEmpty(stringExtra) && intExtra > 0 && !this.f388088d.contains(stringExtra)) {
                this.f388088d.add(stringExtra);
                if (intExtra == 3000) {
                    df.a(activity.getApplicationContext()).f(activity.getPackageName(), de.e(intExtra), stringExtra, 3008, null);
                } else if (intExtra == 1000) {
                    df.a(activity.getApplicationContext()).f(activity.getPackageName(), de.e(intExtra), stringExtra, 1008, null);
                }
            }
        } catch (Throwable th5) {
            jz4.c.B("An error occurred in onActivityResumed method: " + th5);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
