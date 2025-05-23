package com.tencent.rmonitor.metrics.looper;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.rmonitor.common.lifecycle.LifecycleCallback;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b implements com.tencent.rmonitor.common.lifecycle.b {

    /* renamed from: d, reason: collision with root package name */
    private String f365768d = null;

    /* renamed from: e, reason: collision with root package name */
    private final a f365769e;

    public b(@NotNull a aVar) {
        this.f365769e = aVar;
    }

    private String a(Activity activity) {
        return activity.getClass().getSimpleName();
    }

    public void b() {
        LifecycleCallback.r(this);
    }

    public void c() {
        LifecycleCallback.s(this);
    }

    @Override // com.tencent.rmonitor.common.lifecycle.b
    public void onBackground() {
        this.f365769e.onBackground();
    }

    @Override // com.tencent.rmonitor.common.lifecycle.b
    public void onDestroy(@NotNull Activity activity) {
        if (TextUtils.equals(a(activity), this.f365768d)) {
            this.f365768d = null;
        }
        this.f365769e.b(this.f365768d);
    }

    @Override // com.tencent.rmonitor.common.lifecycle.b
    public void onForeground() {
        this.f365769e.onForeground();
    }

    @Override // com.tencent.rmonitor.common.lifecycle.b
    public void onResume(@NotNull Activity activity) {
        String a16 = a(activity);
        this.f365768d = a16;
        this.f365769e.b(a16);
    }

    @Override // com.tencent.rmonitor.common.lifecycle.b
    public void onCreate(@NotNull Activity activity) {
    }

    @Override // com.tencent.rmonitor.common.lifecycle.b
    public void onPause(@NotNull Activity activity) {
    }

    @Override // com.tencent.rmonitor.common.lifecycle.b
    public void onPostCreate(@NonNull Activity activity) {
    }

    @Override // com.tencent.rmonitor.common.lifecycle.b
    public void onStart(@NotNull Activity activity) {
    }

    @Override // com.tencent.rmonitor.common.lifecycle.b
    public void onStop(@NotNull Activity activity) {
    }
}
