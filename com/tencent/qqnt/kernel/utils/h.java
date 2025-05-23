package com.tencent.qqnt.kernel.utils;

import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007R\u0016\u0010\f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/kernel/utils/h;", "", "", "b", "a", "d", "c", "", "dataSize", "e", "", "J", "mKernelStartTime", "mLocalRecentStartTime", "mMsgEndStartTime", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f359261a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long mKernelStartTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static long mLocalRecentStartTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static long mMsgEndStartTime;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54658);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f359261a = new h();
        }
    }

    h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (mKernelStartTime > 0) {
            QLog.d("NtStartupMonitor", 1, "KernelMonitor startSession complete cost:", Long.valueOf(SystemClock.uptimeMillis() - mKernelStartTime));
        }
        mKernelStartTime = 0L;
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        mKernelStartTime = uptimeMillis;
        mLocalRecentStartTime = uptimeMillis;
        mMsgEndStartTime = uptimeMillis;
        QLog.d("NtStartupMonitor", 1, "KernelMonitor onKernelStart:", Long.valueOf(uptimeMillis));
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (mMsgEndStartTime > 0) {
            QLog.d("NtStartupMonitor", 1, "KernelMonitor msgSyncAll complete cost:", Long.valueOf(SystemClock.uptimeMillis() - mMsgEndStartTime));
        }
        mMsgEndStartTime = 0L;
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else if (mMsgEndStartTime > 0) {
            QLog.d("NtStartupMonitor", 1, "KernelMonitor msgSyncFirst complete cost:", Long.valueOf(SystemClock.uptimeMillis() - mMsgEndStartTime));
        }
    }

    public final void e(int dataSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, dataSize);
            return;
        }
        if (mLocalRecentStartTime > 0) {
            QLog.d("NtStartupMonitor", 1, "KernelMonitor localRecentData first return size:", Integer.valueOf(dataSize), ", cost:", Long.valueOf(SystemClock.uptimeMillis() - mLocalRecentStartTime));
        }
        mLocalRecentStartTime = 0L;
    }
}
