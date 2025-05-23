package com.tencent.icgame.game.liveroom.impl.room.floatwindow;

import android.app.Activity;
import android.app.Application;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.icgame.game.liveroom.impl.room.floatwindow.q;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.Foreground;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0002\u000f\u0012B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u0004R\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/q;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "j", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/q$b;", "listener", "i", "", tl.h.F, "f", "Lmqq/util/WeakReference;", "a", "Lmqq/util/WeakReference;", "activityRef", "b", "Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/q$b;", "permissionListener", "Landroid/app/Application$ActivityLifecycleCallbacks;", "c", "Landroid/app/Application$ActivityLifecycleCallbacks;", "activityCallback", "<init>", "()V", "d", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<Activity> activityRef;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b permissionListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Application.ActivityLifecycleCallbacks activityCallback = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/q$b;", "", "", "from", "", "grant", "", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public interface b {
        void a(@NotNull String from, boolean grant);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/icgame/game/liveroom/impl/room/floatwindow/q$c", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onActivityCreated", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "outState", "onActivitySaveInstanceState", "onActivityDestroyed", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class c implements Application.ActivityLifecycleCallbacks {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static final void b(q this$0, Activity activity) {
            Activity activity2;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(activity, "$activity");
            WeakReference weakReference = this$0.activityRef;
            if (weakReference != null) {
                activity2 = (Activity) weakReference.get();
            } else {
                activity2 = null;
            }
            if (activity2 == null || activity2 == activity) {
                this$0.m();
                boolean b16 = com.tencent.icgame.game.utils.e.b(BaseApplication.getContext());
                b bVar = this$0.permissionListener;
                if (bVar != null) {
                    bVar.a("confirmButton", b16);
                    return;
                }
                return;
            }
            rt0.a.INSTANCE.k("ICGameAudience|ICGamePermissionHandler", "activityCallback", "not current activity, curActivity:" + activity2 + ", activity:" + activity);
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
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NotNull final Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final q qVar = q.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.icgame.game.liveroom.impl.room.floatwindow.r
                @Override // java.lang.Runnable
                public final void run() {
                    q.c.b(q.this, activity);
                }
            });
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
    }

    private final void g() {
        BaseApplication.getContext().registerActivityLifecycleCallbacks(this.activityCallback);
    }

    private final void j(Activity activity) {
        Activity activity2;
        if (activity == null) {
            activity2 = QBaseActivity.sTopActivity;
        } else {
            activity2 = activity;
        }
        if (activity2 != null && !activity2.isFinishing() && !activity2.isDestroyed()) {
            this.activityRef = new WeakReference<>(activity);
            g();
            com.tencent.icgame.game.utils.e.e(Foreground.getTopActivity(), new DialogInterface.OnClickListener() { // from class: com.tencent.icgame.game.liveroom.impl.room.floatwindow.o
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    q.k(dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.icgame.game.liveroom.impl.room.floatwindow.p
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    q.l(q.this, dialogInterface, i3);
                }
            });
            return;
        }
        rt0.a.INSTANCE.h("ICGameAudience|ICGamePermissionHandler", "showPermissionDialog", "failed, context is null or invalid");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(DialogInterface dialogInterface, int i3) {
        rt0.a.INSTANCE.k("ICGameAudience|ICGamePermissionHandler", "showPermissionDialog", "click go setting.");
        dialogInterface.dismiss();
        if (!com.tencent.icgame.game.utils.e.b(BaseApplication.getContext())) {
            com.tencent.icgame.game.utils.e.d(BaseApplication.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(q this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        rt0.a.INSTANCE.k("ICGameAudience|ICGamePermissionHandler", "showPermissionDialog", "click cancel.");
        dialogInterface.dismiss();
        boolean b16 = com.tencent.icgame.game.utils.e.b(BaseApplication.getContext());
        b bVar = this$0.permissionListener;
        if (bVar != null) {
            bVar.a("Cancel button.", b16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        BaseApplication.getContext().unregisterActivityLifecycleCallbacks(this.activityCallback);
    }

    public final void f() {
        m();
        this.permissionListener = null;
    }

    public final boolean h() {
        boolean b16 = com.tencent.icgame.game.utils.e.b(BaseApplication.getContext());
        if (!b16) {
            j(Foreground.getTopActivity());
        }
        return b16;
    }

    public final void i(@Nullable b listener) {
        this.permissionListener = listener;
    }
}
