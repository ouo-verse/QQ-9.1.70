package com.tencent.icgame.game.liveroom.impl.room.floatwindow;

import android.app.Activity;
import android.content.ComponentName;
import android.os.Bundle;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.Foreground;
import mqq.app.QActivityLifecycleCallbacks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rt0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000+\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0006*\u0001\u0013\u0018\u0000 \t2\u00020\u0001:\u0002\n\rB\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0004R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/a;", "", "", "liveRoomActivityName", "", "f", "Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/a$b;", "callback", "d", "e", "a", "Ljava/lang/String;", "Landroid/app/Activity;", "b", "Landroid/app/Activity;", "pauseActivity", "c", "Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/a$b;", "detectionCallback", "com/tencent/icgame/game/liveroom/impl/room/floatwindow/a$c", "Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/a$c;", "lifecycleCallbacks", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String liveRoomActivityName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Activity pauseActivity;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b detectionCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c lifecycleCallbacks = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/a$b;", "", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public interface b {
    }

    public final void d(@NotNull b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.detectionCallback = callback;
        Foreground.addActivityLifeCallback(this.lifecycleCallbacks);
    }

    public final void e() {
        this.detectionCallback = null;
        Foreground.removeActivityLifeCallback(this.lifecycleCallbacks);
    }

    public final void f(@NotNull String liveRoomActivityName) {
        Intrinsics.checkNotNullParameter(liveRoomActivityName, "liveRoomActivityName");
        this.liveRoomActivityName = liveRoomActivityName;
        rt0.a.INSTANCE.k("ICGameAudience|ICGameFloatWindowChanceDetector", "setLiveRoomActivityName", "\u76f4\u64adactivity:" + liveRoomActivityName);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/icgame/game/liveroom/impl/room/floatwindow/a$c", "Lmqq/app/QActivityLifecycleCallbacks;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onActivityCreated", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "outState", "onActivitySaveInstanceState", "onActivityDestroyed", "onProcessForeground", "onProcessBackground", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class c implements QActivityLifecycleCallbacks {
        c() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            a.this.pauseActivity = activity;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NotNull Activity activity) {
            String str;
            String str2;
            ComponentName componentName;
            ComponentName componentName2;
            Intrinsics.checkNotNullParameter(activity, "activity");
            Activity topActivity = Foreground.getTopActivity();
            a.Companion companion = rt0.a.INSTANCE;
            String str3 = null;
            if (topActivity != null) {
                str = topActivity.getLocalClassName();
            } else {
                str = null;
            }
            Activity activity2 = a.this.pauseActivity;
            if (activity2 != null && (componentName2 = activity2.getComponentName()) != null) {
                str2 = componentName2.getClassName();
            } else {
                str2 = null;
            }
            companion.k("ICGameAudience|ICGameFloatWindowChanceDetector", "onActivityResumed", "roomId:" + str + ", pauseActivity:" + str2 + "\uff0c liveRoom:" + a.this.liveRoomActivityName);
            if (topActivity instanceof QQBrowserActivity) {
                Activity activity3 = a.this.pauseActivity;
                if (activity3 != null && (componentName = activity3.getComponentName()) != null) {
                    str3 = componentName.getClassName();
                }
                if (Intrinsics.areEqual(str3, a.this.liveRoomActivityName)) {
                    a.this.e();
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle outState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(outState, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // mqq.app.QActivityLifecycleCallbacks
        public void onProcessBackground() {
        }

        @Override // mqq.app.QActivityLifecycleCallbacks
        public void onProcessForeground() {
        }
    }
}
