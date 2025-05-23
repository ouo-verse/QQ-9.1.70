package com.tencent.mobileqq.vas.theme.video;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Foreground;

/* compiled from: P */
/* loaded from: classes20.dex */
public class LoopVideoController extends a {

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.vas.theme.api.a f310936h;

    /* renamed from: i, reason: collision with root package name */
    private final String f310937i;

    public LoopVideoController(String str, Drawable drawable, ViewGroup viewGroup) {
        QLog.d("LoopVideoController", 1, "play=" + str + ",view=" + viewGroup + ",this=" + this);
        b bVar = new b(str, drawable);
        this.f310937i = str;
        this.f310936h = new k(bVar);
        init(viewGroup);
    }

    @Override // com.tencent.mobileqq.vas.theme.video.a, com.tencent.mobileqq.vas.theme.api.IThemeVideoController
    public void init(ViewGroup viewGroup) {
        super.init(viewGroup);
        com.tencent.mobileqq.vas.theme.api.a aVar = this.f310936h;
        if (aVar == null || aVar.c(viewGroup)) {
            return;
        }
        this.f310936h.release();
        this.f310936h.init(viewGroup);
    }

    @Override // com.tencent.mobileqq.vas.theme.video.a, com.tencent.mobileqq.vas.theme.api.IThemeVideoController
    public boolean isSameFile(String str) {
        return str.equals(this.f310937i);
    }

    @Override // com.tencent.mobileqq.vas.theme.video.a, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NonNull Activity activity) {
        super.onActivityPaused(activity);
        if (this.f310936h.b(activity)) {
            QLog.d("LoopVideoController", 1, "pause " + this);
            this.f310936h.pause();
        }
    }

    @Override // com.tencent.mobileqq.vas.theme.video.a, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NonNull Activity activity) {
        super.onActivityResumed(activity);
        if (this.f310936h.b(activity)) {
            QLog.d("LoopVideoController", 1, "resume " + this);
            this.f310936h.resume();
        }
    }

    @Override // com.tencent.mobileqq.vas.theme.video.a, com.tencent.mobileqq.vas.theme.api.IThemeVideoController
    public void pause() {
        QLog.d("LoopVideoController", 1, "pause " + this);
        super.pause();
        this.f310936h.pause();
    }

    @Override // com.tencent.mobileqq.vas.theme.video.a, com.tencent.mobileqq.vas.theme.api.IThemeVideoController
    public void release() {
        QLog.d("LoopVideoController", 1, "release " + this);
        this.f310936h.release();
        try {
            Foreground.removeActivityLifeCallback(this);
        } catch (Exception e16) {
            QLog.e("LoopVideoController", 1, "release error", e16);
        }
        this.f310936h = null;
    }

    @Override // com.tencent.mobileqq.vas.theme.video.a, com.tencent.mobileqq.vas.theme.api.IThemeVideoController
    public void releaseAioBg() {
        com.tencent.mobileqq.vas.theme.api.a aVar = this.f310936h;
        if (aVar != null && !aVar.e()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.theme.video.LoopVideoController.1
                @Override // java.lang.Runnable
                public void run() {
                    if (LoopVideoController.this.f310936h != null) {
                        LoopVideoController.this.f310936h.release();
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.vas.theme.video.a, com.tencent.mobileqq.vas.theme.api.IThemeVideoController
    public void resume() {
        QLog.d("LoopVideoController", 1, "resume " + this);
        super.resume();
        this.f310936h.resume();
    }

    @Override // com.tencent.mobileqq.vas.theme.video.a, mqq.app.QActivityLifecycleCallbacks
    public void onProcessBackground() {
    }

    @Override // com.tencent.mobileqq.vas.theme.video.a, mqq.app.QActivityLifecycleCallbacks
    public void onProcessForeground() {
    }
}
