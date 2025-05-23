package com.tencent.mobileqq.groupvideo.bridgeengine;

import android.content.Context;
import androidx.annotation.Keep;
import com.tencent.bugly.crashreport.BuglyLog;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J&\u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u000b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J&\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u0012\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u0013\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/groupvideo/bridgeengine/CrashService;", "Lcom/tencent/mobileqq/groupvideo/bridgeengine/ICrashService;", "()V", "d", "", "tag", "", "msg", "e", "throwable", "", "i", "postCatchedException", "putUserData", "context", "Landroid/content/Context;", "key", "value", "v", "w", "group-video-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class CrashService implements ICrashService {
    static IPatchRedirector $redirector_;

    public CrashService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ICrashService
    public void d(@Nullable String tag, @Nullable String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) tag, (Object) msg2);
        } else {
            BuglyLog.d(tag, msg2);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ICrashService
    public void e(@Nullable String tag, @Nullable String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            BuglyLog.e(tag, msg2);
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) tag, (Object) msg2);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ICrashService
    public void i(@Nullable String tag, @Nullable String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) tag, (Object) msg2);
        } else {
            BuglyLog.i(tag, msg2);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ICrashService
    public void postCatchedException(@Nullable Throwable throwable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) throwable);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ICrashService
    public void putUserData(@Nullable Context context, @Nullable String key, @Nullable String value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, context, key, value);
        } else {
            CrashReport.putUserData(context, key, value);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ICrashService
    public void v(@Nullable String tag, @Nullable String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) tag, (Object) msg2);
        } else {
            BuglyLog.v(tag, msg2);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ICrashService
    public void w(@Nullable String tag, @Nullable String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) tag, (Object) msg2);
        } else {
            BuglyLog.w(tag, msg2);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ICrashService
    public void e(@Nullable String tag, @Nullable String msg2, @Nullable Throwable throwable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            BuglyLog.e(tag, msg2, throwable);
        } else {
            iPatchRedirector.redirect((short) 7, this, tag, msg2, throwable);
        }
    }
}
