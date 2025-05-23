package com.tencent.qqnt.chats.perf;

import android.os.SystemClock;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.trace.perf.c;
import com.tencent.qqnt.trace.perf.data.b;
import com.tencent.qqnt.trace.r;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\tJ\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\tJ\u0006\u0010\u0012\u001a\u00020\tR\u0016\u0010\u0014\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0013R\u0016\u0010\u0019\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0013R\u0016\u0010\u001b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0013R\u0016\u0010\u0010\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0013\u00a8\u0006\""}, d2 = {"Lcom/tencent/qqnt/chats/perf/a;", "", "", "g", "f", "", "node", "", "a", "", "isStart", "isSnapshot", "b", "Landroid/view/View;", "view", "d", "isDataEmpty", "e", h.F, "Z", "isDataReqFirst", "c", "isDataRespFirst", "isFirstDataProcessFinish", "isFirstDataToScreenFinish", "isDataHandlerFirstTime", "J", "processStartTime", "toScreenStartTime", "i", "isLocalSnapShot", "j", "<init>", "()V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f355516a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean isDataReqFirst;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean isDataRespFirst;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static boolean isFirstDataProcessFinish;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean isFirstDataToScreenFinish;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static boolean isDataHandlerFirstTime;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static long processStartTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static long toScreenStartTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static boolean isLocalSnapShot;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static boolean isDataEmpty;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45797);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        f355516a = new a();
        isDataReqFirst = true;
        isDataRespFirst = true;
        isFirstDataProcessFinish = true;
        isFirstDataToScreenFinish = true;
        isDataHandlerFirstTime = true;
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final long a(String node) {
        return r.f362387a.findStream("MESSAGE_PAGE").nodeTime(node);
    }

    public static /* synthetic */ void c(a aVar, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z17 = false;
        }
        aVar.b(z16, z17);
    }

    private final void f() {
        c.INSTANCE.a().d(new b(0L, a("SHOW_LIST") - a("FETCH_DATA"), 1, null));
    }

    private final void g() {
        c.INSTANCE.a().d(new b(a("SHOW_SNAP_SHOT_LIST") - a("FETCH_SNAPSHOT_DATA"), 0L, 2, null));
    }

    public final void b(boolean isStart, boolean isSnapshot) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(isStart), Boolean.valueOf(isSnapshot));
            return;
        }
        if (isStart && isFirstDataProcessFinish) {
            isFirstDataProcessFinish = false;
            processStartTime = SystemClock.uptimeMillis();
            if (isSnapshot) {
                r.f362387a.findStream("MESSAGE_PAGE").tagNode("FETCH_SNAPSHOT_DATA");
                isLocalSnapShot = true;
            } else {
                r.f362387a.findStream("MESSAGE_PAGE").tagNode("FETCH_DATA");
            }
        }
        if (!isStart && processStartTime != 0) {
            QLog.d("NtStartupMonitor", 1, "first data process: " + (SystemClock.uptimeMillis() - processStartTime));
            processStartTime = 0L;
        }
    }

    public final void d(boolean isStart, @Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(isStart), view);
            return;
        }
        if (isStart && isFirstDataToScreenFinish && !isFirstDataProcessFinish) {
            isFirstDataToScreenFinish = false;
            toScreenStartTime = SystemClock.uptimeMillis();
            if (isLocalSnapShot) {
                r.f362387a.findStream("MESSAGE_PAGE").tagNode("TRANSFORM_SNAPSHOT_DATA");
            } else {
                r.f362387a.findStream("MESSAGE_PAGE").tagNode("TRANSFORM_DATA");
            }
        }
        if (!isStart && toScreenStartTime != 0) {
            QLog.d("NtStartupMonitor", 1, "first to screen: " + (SystemClock.uptimeMillis() - toScreenStartTime));
            toScreenStartTime = 0L;
            if (isLocalSnapShot) {
                r.f362387a.findStream("MESSAGE_PAGE").tagNode("SHOW_SNAP_SHOT_LIST");
                g();
            } else {
                r.f362387a.findStream("MESSAGE_PAGE").tagNode("SHOW_LIST");
                f();
            }
            r.f362387a.findStream("MESSAGE_PAGE").tagNode("MESSAGE_LIST_FIRST_FIN");
        }
    }

    public final void e(boolean isDataEmpty2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, isDataEmpty2);
            return;
        }
        if (isDataHandlerFirstTime) {
            QLog.d("NtStartupMonitor", 1, "onFirstHandleUiState, isDataEmpty: " + isDataEmpty2);
            isDataEmpty = isDataEmpty2;
            isDataHandlerFirstTime = false;
        }
        c.INSTANCE.a().d(new com.tencent.qqnt.trace.perf.data.a());
    }

    public final boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return !isDataEmpty;
    }
}
