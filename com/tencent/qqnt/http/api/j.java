package com.tencent.qqnt.http.api;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0016\u0010\u000eJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&R\"\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/http/api/j;", "", "Lcom/tencent/qqnt/http/api/b;", "task", "", "writeLength", "contentLength", "", "onProgress", "notifyIntervalTime", "J", "getNotifyIntervalTime", "()J", "setNotifyIntervalTime", "(J)V", "", "progressRate", UserInfo.SEX_FEMALE, "getProgressRate", "()F", "setProgressRate", "(F)V", "<init>", "http_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public abstract class j {
    static IPatchRedirector $redirector_;
    private long notifyIntervalTime;
    private float progressRate;

    public j() {
        this(0L, 1, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this);
    }

    public final long getNotifyIntervalTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.notifyIntervalTime;
    }

    public final float getProgressRate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Float) iPatchRedirector.redirect((short) 5, (Object) this)).floatValue();
        }
        return this.progressRate;
    }

    public abstract void onProgress(@NotNull b task, long writeLength, long contentLength);

    public final void setNotifyIntervalTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
        } else {
            this.notifyIntervalTime = j3;
        }
    }

    public final void setProgressRate(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16));
        } else {
            this.progressRate = f16;
        }
    }

    public j(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.notifyIntervalTime = j3;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, j3);
        }
    }

    public /* synthetic */ j(long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 500L : j3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Integer.valueOf(i3), defaultConstructorMarker);
    }
}
