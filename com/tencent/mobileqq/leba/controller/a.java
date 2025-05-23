package com.tencent.mobileqq.leba.controller;

import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.leba.Leba;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nR\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0011R\u001c\u0010\u0015\u001a\n \u0013*\u0004\u0018\u00010\u00070\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u000e\u0010\u0018\"\u0004\b\u0014\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/leba/controller/a;", "", "Lcom/tencent/mobileqq/app/FrameFragment;", "frameFragment", "", "c", "a", "", "clz", "e", "", "type", "f", "Lmqq/util/WeakReference;", "b", "Lmqq/util/WeakReference;", "mFrameFragment", "Ljava/lang/String;", "mQZoneFrameTag", "kotlin.jvm.PlatformType", "d", "mLebaFrameTag", "", "Z", "()Z", "(Z)V", "mNeedShowQZoneFrame", "<init>", "()V", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f240329a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static WeakReference<FrameFragment> mFrameFragment;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String mQZoneFrameTag;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final String mLebaFrameTag;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean mNeedShowQZoneFrame;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17224);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f240329a = new a();
            mLebaFrameTag = Leba.class.getName();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final FrameFragment a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (FrameFragment) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        WeakReference<FrameFragment> weakReference = mFrameFragment;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return mNeedShowQZoneFrame;
    }

    public final void c(@NotNull FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) frameFragment);
        } else {
            Intrinsics.checkNotNullParameter(frameFragment, "frameFragment");
            mFrameFragment = new WeakReference<>(frameFragment);
        }
    }

    public final void d(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            mNeedShowQZoneFrame = z16;
        }
    }

    public final void e(@NotNull String clz) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) clz);
        } else {
            Intrinsics.checkNotNullParameter(clz, "clz");
            mQZoneFrameTag = clz;
        }
    }

    public final void f(int type) {
        FrameFragment frameFragment;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, type);
            return;
        }
        WeakReference<FrameFragment> weakReference = mFrameFragment;
        if (weakReference != null) {
            frameFragment = weakReference.get();
        } else {
            frameFragment = null;
        }
        if (frameFragment == null) {
            QLog.e("LebaSettingController", 1, "frameFragment is null");
            return;
        }
        ((ITabFrameController) QRoute.api(ITabFrameController.class)).setFrames(frameFragment, false, 3);
        if (type == 2) {
            QLog.i("LebaSettingController", 1, "switchToQZoneFrame");
            str = mQZoneFrameTag;
        } else {
            QLog.i("LebaSettingController", 1, "switchToLebaFrame");
            str = mLebaFrameTag;
        }
        FrameFragment.d dVar = frameFragment.mTabIndicator;
        if (dVar != null) {
            dVar.setCurrentTabByTag(str);
        }
    }
}
