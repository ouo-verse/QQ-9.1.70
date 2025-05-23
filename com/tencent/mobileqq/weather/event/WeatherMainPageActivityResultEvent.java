package com.tencent.mobileqq.weather.event;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qzone.QzoneIPCModule;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\nR\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/weather/event/WeatherMainPageActivityResultEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "weakActivity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "requestCode", "", QzoneIPCModule.RESULT_CODE, "data", "Landroid/content/Intent;", "(Ljava/lang/ref/WeakReference;IILandroid/content/Intent;)V", "getData", "()Landroid/content/Intent;", "getRequestCode", "()I", "getResultCode", "getWeakActivity", "()Ljava/lang/ref/WeakReference;", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class WeatherMainPageActivityResultEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;

    @Nullable
    private final Intent data;
    private final int requestCode;
    private final int resultCode;

    @NotNull
    private final WeakReference<Activity> weakActivity;

    public WeatherMainPageActivityResultEvent(@NotNull WeakReference<Activity> weakActivity, int i3, int i16, @Nullable Intent intent) {
        Intrinsics.checkNotNullParameter(weakActivity, "weakActivity");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, weakActivity, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        this.weakActivity = weakActivity;
        this.requestCode = i3;
        this.resultCode = i16;
        this.data = intent;
    }

    @Nullable
    public final Intent getData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Intent) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.data;
    }

    public final int getRequestCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.requestCode;
    }

    public final int getResultCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.resultCode;
    }

    @NotNull
    public final WeakReference<Activity> getWeakActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (WeakReference) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.weakActivity;
    }
}
