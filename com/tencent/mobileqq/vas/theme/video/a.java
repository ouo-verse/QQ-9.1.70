package com.tencent.mobileqq.vas.theme.video;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.vas.theme.ThemeVideoController;
import com.tencent.mobileqq.vas.theme.api.IThemeVideoController;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import mqq.app.QActivityLifecycleCallbacks;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a implements IThemeVideoController, QActivityLifecycleCallbacks {

    /* renamed from: d, reason: collision with root package name */
    protected b f310939d;

    /* renamed from: e, reason: collision with root package name */
    protected b f310940e;

    /* renamed from: f, reason: collision with root package name */
    protected b f310941f;

    private void a() {
        if (MobileQQ.sProcessId == 1) {
            QLog.d("BaseVideoController", 1, "addAppForegroundCallback");
            Foreground.addActivityLifeCallback(this);
        }
    }

    @Override // com.tencent.mobileqq.vas.theme.api.IThemeVideoController
    public void init(ViewGroup viewGroup) {
        a();
    }

    @Override // com.tencent.mobileqq.vas.theme.api.IThemeVideoController
    public boolean isSameFile(String str) {
        return false;
    }

    public void onProcessBackground() {
        QLog.d("BaseVideoController", 1, "onProcessBackground pause");
        pause();
    }

    public void onProcessForeground() {
        QLog.d("BaseVideoController", 1, "onProcessForeground resume");
        resume();
    }

    @Override // com.tencent.mobileqq.vas.theme.api.IThemeVideoController
    public void pause() {
        QLog.d("BaseVideoController", 1, "pause");
    }

    @Override // com.tencent.mobileqq.vas.theme.api.IThemeVideoController
    public void release() {
        this.f310941f = null;
        this.f310940e = null;
        this.f310939d = null;
        Foreground.removeActivityLifeCallback(this);
        ThemeVideoController.destroy();
    }

    @Override // com.tencent.mobileqq.vas.theme.api.IThemeVideoController
    public void resume() {
        QLog.d("BaseVideoController", 1, "resume");
    }

    @Override // com.tencent.mobileqq.vas.theme.api.IThemeVideoController
    public void playAioAnimation() {
    }

    @Override // com.tencent.mobileqq.vas.theme.api.IThemeVideoController
    public void playDrawerAnimation() {
    }

    @Override // com.tencent.mobileqq.vas.theme.api.IThemeVideoController
    public void playExitAnimation() {
    }

    @Override // com.tencent.mobileqq.vas.theme.api.IThemeVideoController
    public void playMainAnimation() {
    }

    @Override // com.tencent.mobileqq.vas.theme.api.IThemeVideoController
    public void releaseAioBg() {
    }

    @Override // com.tencent.mobileqq.vas.theme.api.IThemeVideoController
    public void initAio(View view) {
    }

    @Override // com.tencent.mobileqq.vas.theme.api.IThemeVideoController
    public void initDrawer(View view) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NonNull Activity activity) {
    }

    public void onActivityPaused(@NonNull Activity activity) {
    }

    public void onActivityResumed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }
}
