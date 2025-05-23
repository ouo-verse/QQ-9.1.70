package com.tencent.mobileqq.guild.media.core.logic.trtc;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildTRTCFocusApi;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes14.dex */
public class TRTCFocusManager {

    /* renamed from: h, reason: collision with root package name */
    private static TRTCFocusManager f228518h;

    /* renamed from: b, reason: collision with root package name */
    private volatile WeakReference<IGuildTRTCFocusApi.a> f228520b;

    /* renamed from: c, reason: collision with root package name */
    private volatile IGuildTRTCFocusApi.a f228521c;

    /* renamed from: d, reason: collision with root package name */
    private volatile IGuildTRTCFocusApi.b f228522d;

    /* renamed from: e, reason: collision with root package name */
    private volatile Handler f228523e;

    /* renamed from: a, reason: collision with root package name */
    private volatile int f228519a = 0;

    /* renamed from: f, reason: collision with root package name */
    private final Runnable f228524f = new Runnable() { // from class: com.tencent.mobileqq.guild.media.core.logic.trtc.TRTCFocusManager.1
        @Override // java.lang.Runnable
        public void run() {
            if (TRTCFocusManager.this.f228520b != null && TRTCFocusManager.this.f228520b.get() != 0) {
                TRTCFocusManager tRTCFocusManager = TRTCFocusManager.this;
                tRTCFocusManager.l((IGuildTRTCFocusApi.a) tRTCFocusManager.f228520b.get());
                return;
            }
            QLog.e("QGMC.TRTCFocusManager", 1, "curFocusListenerReference is null. requestingFocusCallback:" + TRTCFocusManager.this.f228522d);
            if (TRTCFocusManager.this.f228522d != null) {
                TRTCFocusManager tRTCFocusManager2 = TRTCFocusManager.this;
                tRTCFocusManager2.k(tRTCFocusManager2.f228522d, null);
            }
        }
    };

    /* renamed from: g, reason: collision with root package name */
    private Runnable f228525g = null;

    TRTCFocusManager() {
    }

    public static synchronized TRTCFocusManager j() {
        TRTCFocusManager tRTCFocusManager;
        synchronized (TRTCFocusManager.class) {
            if (f228518h == null) {
                f228518h = new TRTCFocusManager();
            }
            tRTCFocusManager = f228518h;
        }
        return tRTCFocusManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(@NonNull final IGuildTRTCFocusApi.b bVar, @Nullable Handler handler) {
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.guild.media.core.logic.trtc.TRTCFocusManager.2
            @Override // java.lang.Runnable
            public void run() {
                if (TRTCFocusManager.this.f228519a != 1) {
                    QLog.e("QGMC.TRTCFocusManager", 1, "illegal state,now state is " + TRTCFocusManager.this.f228519a);
                    return;
                }
                if (bVar == TRTCFocusManager.this.f228522d) {
                    TRTCFocusManager.this.f228519a = 2;
                    TRTCFocusManager.this.f228520b = new WeakReference(TRTCFocusManager.this.f228521c);
                    TRTCFocusManager.this.f228522d = null;
                    TRTCFocusManager.this.f228523e = null;
                    bVar.a(true);
                    return;
                }
                QLog.e("QGMC.TRTCFocusManager", 1, "requestingFocusCallback has changed,just return");
            }
        };
        if (handler != null) {
            handler.post(runnable);
        } else {
            ThreadManagerV2.excute(runnable, 16, null, false);
        }
    }

    public void l(@NonNull IGuildTRTCFocusApi.a aVar) {
        if (this.f228520b != null && this.f228520b.get() == aVar) {
            if (this.f228519a == 1) {
                k(this.f228522d, this.f228523e);
                return;
            }
            if (this.f228519a == 2) {
                this.f228520b = null;
                this.f228519a = 0;
                QLog.i("QGMC.TRTCFocusManager", 1, "set curState STATE_IDLE.");
                return;
            } else {
                QLog.e("QGMC.TRTCFocusManager", 1, "illegal onReleaseTRTCFocus,curState is " + this.f228519a);
                return;
            }
        }
        QLog.e("QGMC.TRTCFocusManager", 1, "illegal onReleaseTRTCFocus,focusListener not match");
    }

    public void m(@NonNull IGuildTRTCFocusApi.a aVar, @NonNull IGuildTRTCFocusApi.b bVar, @Nullable Handler handler) {
        QLog.i("QGMC.TRTCFocusManager", 1, "start requestTRTCFocus,focusListener:" + aVar + ", curState:" + this.f228519a);
        if (this.f228519a == 0) {
            this.f228519a = 1;
            this.f228521c = aVar;
            this.f228522d = bVar;
            k(bVar, handler);
            return;
        }
        if (this.f228519a == 1) {
            Runnable runnable = this.f228525g;
            if (runnable != null) {
                ThreadManagerV2.removeJob(runnable, 16);
            }
            if (this.f228522d != null) {
                this.f228522d.a(false);
            }
        }
        this.f228519a = 1;
        this.f228521c = aVar;
        this.f228522d = bVar;
        if (this.f228520b != null) {
            IGuildTRTCFocusApi.a aVar2 = this.f228520b.get();
            if (aVar2 == null) {
                k(bVar, handler);
                return;
            }
            QLog.i("QGMC.TRTCFocusManager", 1, "executeDelay timeoutRunnable4Del.");
            this.f228523e = handler;
            aVar2.s();
            this.f228525g = ThreadManagerV2.executeDelay(this.f228524f, 16, null, false, 3000L);
            return;
        }
        QLog.e("QGMC.TRTCFocusManager", 1, "curFocusListenerReference is null.");
        k(bVar, handler);
    }
}
