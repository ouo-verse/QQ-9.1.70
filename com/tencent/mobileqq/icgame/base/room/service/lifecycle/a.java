package com.tencent.mobileqq.icgame.base.room.service.lifecycle;

import android.content.Context;
import i22.ActivityLifecycleEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016R\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/icgame/base/room/service/lifecycle/a;", "", "Lcom/tencent/mobileqq/icgame/base/room/service/lifecycle/c;", "Landroid/content/Context;", "context", "", h.F, "a", "f", "e", "c", "g", "b", "d", "Lg32/h;", "Lg32/h;", "trigger", "Lcom/tencent/mobileqq/icgame/base/room/service/lifecycle/ActivityLifecycle;", "Lcom/tencent/mobileqq/icgame/base/room/service/lifecycle/ActivityLifecycle;", "currentLifecycle", "Landroid/content/Context;", "<init>", "(Lg32/h;)V", "ic-game-room-base_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final g32.h trigger;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ActivityLifecycle currentLifecycle;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Context context;

    public a(@NotNull g32.h trigger) {
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        this.trigger = trigger;
        this.currentLifecycle = ActivityLifecycle.NONE;
    }

    public void a() {
        ActivityLifecycle activityLifecycle = ActivityLifecycle.ON_CREATE;
        this.currentLifecycle = activityLifecycle;
        this.trigger.w0(new ActivityLifecycleEvent(activityLifecycle));
    }

    public void b() {
        ActivityLifecycle activityLifecycle = ActivityLifecycle.ON_DESTROY;
        this.currentLifecycle = activityLifecycle;
        this.trigger.w0(new ActivityLifecycleEvent(activityLifecycle));
    }

    public void c() {
        ActivityLifecycle activityLifecycle = ActivityLifecycle.ON_PAUSE;
        this.currentLifecycle = activityLifecycle;
        this.trigger.w0(new ActivityLifecycleEvent(activityLifecycle));
    }

    @Override // com.tencent.mobileqq.icgame.base.room.service.lifecycle.c
    @NotNull
    public Context d() {
        Context context = this.context;
        Intrinsics.checkNotNull(context);
        return context;
    }

    public void e() {
        ActivityLifecycle activityLifecycle = ActivityLifecycle.ON_RESUME;
        this.currentLifecycle = activityLifecycle;
        this.trigger.w0(new ActivityLifecycleEvent(activityLifecycle));
    }

    public void f() {
        ActivityLifecycle activityLifecycle = ActivityLifecycle.ON_START;
        this.currentLifecycle = activityLifecycle;
        this.trigger.w0(new ActivityLifecycleEvent(activityLifecycle));
    }

    public void g() {
        ActivityLifecycle activityLifecycle = ActivityLifecycle.ON_STOP;
        this.currentLifecycle = activityLifecycle;
        this.trigger.w0(new ActivityLifecycleEvent(activityLifecycle));
    }

    public void h(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }
}
