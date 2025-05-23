package com.tencent.qqnt.chats.core.ui;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006R\u0016\u0010\u000b\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\nR\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/chats/core/ui/g;", "", "", "type", "", "c", "", "isTimeOut", "b", "", "J", "recordTime", "I", "refreshType", "Ljava/lang/Runnable;", "d", "Ljava/lang/Runnable;", "timeoutRunnable", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f354937a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long recordTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int refreshType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Runnable timeoutRunnable;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46848);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f354937a = new g();
            timeoutRunnable = new Runnable() { // from class: com.tencent.qqnt.chats.core.ui.f
                @Override // java.lang.Runnable
                public final void run() {
                    g.d();
                }
            };
        }
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d() {
        f354937a.b(true);
    }

    public final void b(boolean isTimeOut) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, isTimeOut);
            return;
        }
        if (recordTime <= 0) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(timeoutRunnable);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - recordTime;
        recordTime = 0L;
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(timeoutRunnable);
        QLog.d("ChatsDataLoadTimeoutHelper", 1, "tagEnd: isTimeout=" + isTimeOut + ", spend=" + currentTimeMillis);
    }

    public final void c(int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, type);
            return;
        }
        recordTime = System.currentTimeMillis();
        refreshType = type;
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        Runnable runnable = timeoutRunnable;
        uIHandlerV2.removeCallbacks(runnable);
        ThreadManagerV2.getUIHandlerV2().postDelayed(runnable, 10000L);
        QLog.d("ChatsDataLoadTimeoutHelper", 1, "tagStart: type: " + type);
    }
}
