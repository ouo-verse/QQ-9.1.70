package com.xiaomi.push;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ch implements Application.ActivityLifecycleCallbacks {

    /* renamed from: d, reason: collision with root package name */
    private String f388410d;

    /* renamed from: e, reason: collision with root package name */
    private String f388411e;

    /* renamed from: f, reason: collision with root package name */
    private Context f388412f;

    public ch(Context context, String str) {
        this.f388412f = context;
        this.f388410d = str;
    }

    private void a(String str) {
        gn gnVar = new gn();
        gnVar.a(str);
        gnVar.a(System.currentTimeMillis());
        gnVar.a(gh.ActivityActiveTimeStamp);
        dl.g(this.f388412f, gnVar);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (!TextUtils.isEmpty(this.f388410d) && !TextUtils.isEmpty(localClassName)) {
            this.f388411e = "";
            if (!TextUtils.isEmpty("") && !TextUtils.equals(this.f388411e, localClassName)) {
                this.f388410d = "";
                return;
            }
            a(this.f388412f.getPackageName() + "|" + localClassName + ":" + this.f388410d + "," + String.valueOf(System.currentTimeMillis() / 1000));
            this.f388410d = "";
            this.f388411e = "";
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (TextUtils.isEmpty(this.f388411e)) {
            this.f388411e = activity.getLocalClassName();
        }
        this.f388410d = String.valueOf(System.currentTimeMillis() / 1000);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
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
