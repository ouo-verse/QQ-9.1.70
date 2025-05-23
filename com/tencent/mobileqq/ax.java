package com.tencent.mobileqq;

import android.app.Activity;
import android.os.Handler;
import android.util.Log;
import com.tencent.mobileqq.DebugTrace;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ax;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/ax;", "", "a", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class ax {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    @JvmField
    public static int f200192b;

    /* renamed from: c, reason: collision with root package name */
    @JvmField
    @NotNull
    public static String f200193c;

    /* renamed from: d, reason: collision with root package name */
    @JvmField
    @NotNull
    public static Class<?> f200194d;

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\tR\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u000fR\u0016\u0010\u001a\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\t\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/ax$a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "c", "b", "", "KEY_KILL_SELF", "Ljava/lang/String;", "KEY_MULTI_PROCESS", "KEY_OPEN_PERF", "TAG", "", "TYPE_COLD_START", "I", "TYPE_HOT_START", "TYPE_NONE", "Ljava/lang/Class;", "activityClass", "Ljava/lang/Class;", "", "openMultiProcess", "Z", "openPerf", "runType", "url", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.ax$a, reason: from kotlin metadata */
    /* loaded from: classes9.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                return;
            }
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(int i3, Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "$activity");
            DebugTrace.Companion companion = DebugTrace.INSTANCE;
            DebugTrace.Step step = DebugTrace.Step.step_end;
            companion.j(step);
            companion.g(step);
            if (i3 == 2) {
                Log.i("WVPerf.DebugTrace_Test", "finish");
                activity.finish();
            }
        }

        @JvmStatic
        public final void b(@NotNull Activity activity) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity);
                return;
            }
            Intrinsics.checkNotNullParameter(activity, "activity");
            int intExtra = activity.getIntent().getIntExtra("KEY_KILL_SELF", 0);
            DebugTrace.Companion companion = DebugTrace.INSTANCE;
            if (1 == intExtra) {
                str = "coldStart";
            } else {
                str = "warmStart";
            }
            companion.i(str);
        }

        @JvmStatic
        public final void c(@NotNull final Activity activity) {
            long j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
                return;
            }
            Intrinsics.checkNotNullParameter(activity, "activity");
            final int intExtra = activity.getIntent().getIntExtra("KEY_KILL_SELF", 0);
            if (activity.getIntent() != null && intExtra != 0) {
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.aw
                    @Override // java.lang.Runnable
                    public final void run() {
                        ax.Companion.d(intExtra, activity);
                    }
                };
                if (((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion()) {
                    j3 = 10000;
                } else {
                    j3 = 5000;
                }
                uIHandlerV2.postDelayed(runnable, j3);
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36116);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        INSTANCE = new Companion(null);
        f200192b = 1;
        f200193c = "";
        f200194d = QQBrowserActivity.class;
    }

    @JvmStatic
    public static final void a(@NotNull Activity activity) {
        INSTANCE.b(activity);
    }

    @JvmStatic
    public static final void b(@NotNull Activity activity) {
        INSTANCE.c(activity);
    }
}
