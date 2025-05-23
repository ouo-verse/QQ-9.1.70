package com.tencent.mobileqq.ark.component;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.ark.ArkPlayer;
import com.tencent.ark.ark;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import mqq.app.Foreground;
import mqq.app.QActivityLifecycleCallbacks;

/* loaded from: classes11.dex */
public class ArkMediaPlayer extends ArkPlayer {
    private static final Set<WeakReference<ArkMediaPlayer>> D;
    static final QActivityLifecycleCallbacks E;
    public static final ark.PlayerStubFactory F;

    /* renamed from: d, reason: collision with root package name */
    private boolean f199237d = true;

    /* renamed from: e, reason: collision with root package name */
    private final int f199238e = 0;

    /* renamed from: f, reason: collision with root package name */
    private final int f199239f = 1;

    /* renamed from: h, reason: collision with root package name */
    private final int f199240h = 2;

    /* renamed from: i, reason: collision with root package name */
    private final int f199241i = 3;

    /* renamed from: m, reason: collision with root package name */
    private final int f199242m = 4;
    private int C = 0;

    /* loaded from: classes11.dex */
    class b implements ark.PlayerStubFactory {
        b() {
        }

        @Override // com.tencent.ark.ark.PlayerStubFactory
        public ark.PlayerStub CreateStub() {
            return new ArkMediaPlayer();
        }
    }

    static {
        a aVar = new a();
        E = aVar;
        D = Collections.synchronizedSet(new HashSet());
        Foreground.addActivityLifeCallback(aVar);
        F = new b();
    }

    protected ArkMediaPlayer() {
        D.add(new WeakReference<>(this));
        QLog.i("Ark.ArkMediaPlayer", 1, String.format("ArkMediaPlayer.create.%h", this));
    }

    public static void g() {
        ArkMediaPlayer arkMediaPlayer;
        QLog.i("Ark.ArkMediaPlayer", 1, "onBackground");
        Set<WeakReference<ArkMediaPlayer>> set = D;
        synchronized (set) {
            for (WeakReference<ArkMediaPlayer> weakReference : set) {
                if (weakReference != null && (arkMediaPlayer = weakReference.get()) != null) {
                    arkMediaPlayer.e();
                }
            }
        }
    }

    public static void h() {
        ArkMediaPlayer arkMediaPlayer;
        QLog.i("Ark.ArkMediaPlayer", 1, "onForeground");
        Set<WeakReference<ArkMediaPlayer>> set = D;
        synchronized (set) {
            for (WeakReference<ArkMediaPlayer> weakReference : set) {
                if (weakReference != null && (arkMediaPlayer = weakReference.get()) != null) {
                    arkMediaPlayer.f();
                }
            }
        }
    }

    @Override // com.tencent.ark.ArkPlayer, com.tencent.ark.ark.PlayerStub
    public boolean Pause() {
        if (!this.f199237d) {
            this.C = 3;
        }
        return super.Pause();
    }

    @Override // com.tencent.ark.ArkPlayer, com.tencent.ark.ark.PlayerStub
    public boolean Play() {
        if (!this.f199237d) {
            this.C = 1;
        }
        return super.Play();
    }

    @Override // com.tencent.ark.ArkPlayer, com.tencent.ark.ark.PlayerStub
    public boolean Resume() {
        if (!this.f199237d) {
            this.C = 4;
        }
        return super.Resume();
    }

    @Override // com.tencent.ark.ArkPlayer, com.tencent.ark.ark.PlayerStub
    public boolean Stop() {
        if (!this.f199237d) {
            this.C = 2;
        }
        return super.Stop();
    }

    public void e() {
        ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToAppThread(this.mQueueKey, new Runnable() { // from class: com.tencent.mobileqq.ark.component.ArkMediaPlayer.4
            @Override // java.lang.Runnable
            public void run() {
                ArkMediaPlayer.this.f199237d = false;
                if (ArkMediaPlayer.this.Pause()) {
                    ArkMediaPlayer.this.C = 4;
                }
            }
        });
    }

    public void f() {
        ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToAppThread(this.mQueueKey, new Runnable() { // from class: com.tencent.mobileqq.ark.component.ArkMediaPlayer.3
            @Override // java.lang.Runnable
            public void run() {
                if (!ArkMediaPlayer.this.f199237d) {
                    ArkMediaPlayer.this.f199237d = true;
                    if (ArkMediaPlayer.this.C == 1) {
                        ArkMediaPlayer.this.Play();
                    } else if (ArkMediaPlayer.this.C == 2) {
                        ArkMediaPlayer.this.Stop();
                    } else if (ArkMediaPlayer.this.C == 4) {
                        ArkMediaPlayer.this.Resume();
                    } else if (ArkMediaPlayer.this.C == 3) {
                        ArkMediaPlayer.this.Pause();
                    }
                    ArkMediaPlayer.this.C = 0;
                }
            }
        });
    }

    /* loaded from: classes11.dex */
    class a implements QActivityLifecycleCallbacks {
        a() {
        }

        @Override // mqq.app.QActivityLifecycleCallbacks
        public void onProcessBackground() {
            ArkMediaPlayer.g();
        }

        @Override // mqq.app.QActivityLifecycleCallbacks
        public void onProcessForeground() {
            ArkMediaPlayer.h();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
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
}
