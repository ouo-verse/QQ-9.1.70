package com.tencent.mobileqq.aio.utils;

import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pad.SplitViewState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xweb.FileReaderHelper;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\u0007J\u0006\u0010\u000e\u001a\u00020\u0007J\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fR\u001e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0014R\u0016\u0010\u001b\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001cR\u0014\u0010 \u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/aio/utils/e;", "", "", FileReaderHelper.OPEN_FILE_FROM_FORCE, "", tl.h.F, "a", "", "f", "e", "Landroid/view/View;", "view", "g", "d", "b", "", "c", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "aioRootViewWr", "I", "aioWidth", "aioHeight", "screenHeight", "screenWidth", "", UserInfo.SEX_FEMALE, "density", "Z", "isInit", "i", "Ljava/lang/Object;", JoinPoint.SYNCHRONIZATION_LOCK, "Ljava/util/concurrent/atomic/AtomicBoolean;", "j", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isUpdating", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f194142a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static WeakReference<View> aioRootViewWr;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int aioWidth;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int aioHeight;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static int screenHeight;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static int screenWidth;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static float density;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static boolean isInit;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Object lock;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final AtomicBoolean isUpdating;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/aio/utils/e$a", "Landroid/content/ComponentCallbacks;", "Landroid/content/res/Configuration;", "newConfig", "", "onConfigurationChanged", "onLowMemory", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a implements ComponentCallbacks {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(@NotNull Configuration newConfig) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) newConfig);
                return;
            }
            Intrinsics.checkNotNullParameter(newConfig, "newConfig");
            QLog.d("AIOPadCompatUtils", 1, "onConfigurationChanged");
            e.f194142a.h(true);
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49814);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        f194142a = new e();
        aioWidth = -1;
        aioHeight = -1;
        screenHeight = -1;
        screenWidth = -1;
        density = -1.0f;
        lock = new Object();
        isUpdating = new AtomicBoolean(false);
        MobileQQ.sMobileQQ.registerComponentCallbacks(new a());
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        try {
            if (com.tencent.mobileqq.pad.e.a() != SplitViewState.STATE_FLAT) {
                return false;
            }
            if (!(QBaseActivity.sTopActivity instanceof com.tencent.mobileqq.pad.l)) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final int b() {
        Integer num;
        int i3;
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        WeakReference<View> weakReference = aioRootViewWr;
        if (weakReference != null && (view = weakReference.get()) != null) {
            num = Integer.valueOf(view.getHeight());
        } else {
            num = null;
        }
        int i16 = aioHeight;
        if (num == null || num.intValue() != i16) {
            if (num != null) {
                i3 = num.intValue();
            } else {
                i3 = -1;
            }
            aioHeight = i3;
        }
        if (num != null && num.intValue() > 0) {
            return num.intValue();
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("AIOPadCompatUtils", 4, "[getAIOHeight]: fail, use screenHeight");
        }
        return e();
    }

    @Nullable
    public final int[] c() {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (int[]) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        WeakReference<View> weakReference = aioRootViewWr;
        if (weakReference != null && (view = weakReference.get()) != null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            return iArr;
        }
        return null;
    }

    public final int d() {
        Integer num;
        int i3;
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        WeakReference<View> weakReference = aioRootViewWr;
        if (weakReference != null && (view = weakReference.get()) != null) {
            num = Integer.valueOf(view.getWidth());
        } else {
            num = null;
        }
        int i16 = aioWidth;
        if (num == null || num.intValue() != i16) {
            if (num != null) {
                i3 = num.intValue();
            } else {
                i3 = -1;
            }
            aioWidth = i3;
        }
        if (num != null && num.intValue() > 0) {
            return num.intValue();
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("AIOPadCompatUtils", 4, "[getAIOWidth]: fail, use screenWidth");
        }
        return f();
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        h(false);
        return screenHeight;
    }

    public final int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        h(false);
        return screenWidth;
    }

    public final void g(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "view");
            aioRootViewWr = new WeakReference<>(view);
        }
    }

    public final void h(boolean force) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, force);
            return;
        }
        AtomicBoolean atomicBoolean = isUpdating;
        if (!atomicBoolean.get() && isInit && !force) {
            return;
        }
        synchronized (lock) {
            if (isInit && !force) {
                return;
            }
            if (atomicBoolean.compareAndSet(false, true)) {
                DisplayMetrics displayMetrics = BaseApplication.context.getResources().getDisplayMetrics();
                density = displayMetrics.density;
                e eVar = f194142a;
                if (eVar.a()) {
                    i3 = (int) (displayMetrics.widthPixels * com.tencent.mobileqq.pad.e.g());
                } else {
                    i3 = displayMetrics.widthPixels;
                }
                screenWidth = i3;
                screenHeight = displayMetrics.heightPixels;
                QLog.d("AIOPadCompatUtils", 1, "mode: " + eVar.a() + ", width: " + screenWidth);
                atomicBoolean.set(false);
            }
            isInit = true;
            Unit unit = Unit.INSTANCE;
        }
    }
}
