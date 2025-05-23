package com.tencent.mobileqq.qqlive.sail.ui.orientation;

import android.provider.Settings;
import android.view.OrientationEventListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.common.api.AegisLogger;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\b*\u0001\u0017\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001dB\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\f\u001a\u00020\nR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/orientation/a;", "", "", "g", "i", "", "roomId", "Lcom/tencent/mobileqq/qqlive/sail/ui/orientation/a$a;", "listener", "j", "", "k", h.F, "", "b", "I", "tempOrientation", "c", "currentOrientation", "Ljava/util/concurrent/ConcurrentHashMap;", "d", "Ljava/util/concurrent/ConcurrentHashMap;", "listeners", "com/tencent/mobileqq/qqlive/sail/ui/orientation/a$b", "e", "Lcom/tencent/mobileqq/qqlive/sail/ui/orientation/a$b;", "orientationEventListener", "<init>", "()V", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f272983a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int tempOrientation;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int currentOrientation;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Long, InterfaceC8398a> listeners;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final b orientationEventListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/orientation/a$a;", "", "", "orientation", "", DomainData.DOMAIN_NAME, "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.orientation.a$a, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public interface InterfaceC8398a {
        void n(int orientation);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/orientation/a$b", "Landroid/view/OrientationEventListener;", "", "orientation", "", "onOrientationChanged", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends OrientationEventListener {
        static IPatchRedirector $redirector_;

        b(BaseApplication baseApplication) {
            super(baseApplication, 3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseApplication);
            }
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int orientation) {
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, orientation);
                return;
            }
            if (orientation == -1) {
                return;
            }
            boolean z26 = true;
            if (330 <= orientation && orientation < 361) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 || (orientation >= 0 && orientation < 31)) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                a.tempOrientation = 1;
            } else {
                if (60 <= orientation && orientation < 121) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    a.tempOrientation = 8;
                } else {
                    if (150 <= orientation && orientation < 211) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    if (!z19) {
                        if (240 > orientation || orientation >= 301) {
                            z26 = false;
                        }
                        if (z26) {
                            a.tempOrientation = 0;
                        }
                    }
                }
            }
            if (a.currentOrientation != a.tempOrientation && a.f272983a.i()) {
                a.currentOrientation = a.tempOrientation;
                AegisLogger.INSTANCE.i("Audience|OrientationChecker", "onOrientationChanged", "orientation changed to: " + a.currentOrientation + ", listeners size: " + a.listeners.size());
                for (Map.Entry entry : a.listeners.entrySet()) {
                    AegisLogger.Companion companion = AegisLogger.INSTANCE;
                    if (companion.isDevelopLevel()) {
                        companion.d("Audience|OrientationChecker", "onOrientationChanged", "notify to roomId=" + entry.getKey());
                    }
                    ((InterfaceC8398a) entry.getValue()).n(a.currentOrientation);
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52637);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f272983a = new a();
        listeners = new ConcurrentHashMap<>();
        orientationEventListener = new b(BaseApplication.context);
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean g() {
        if (ht3.a.e("qqlive_enable_auto_switch_screen", true) && orientationEventListener.canDetectOrientation()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean i() {
        int i3;
        try {
            i3 = Settings.System.getInt(BaseApplication.context.getContentResolver(), "accelerometer_rotation");
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("Audience|OrientationChecker", "isScreenAutoRotate", "error, ", e16);
            i3 = 0;
        }
        if (i3 != 1) {
            return false;
        }
        return true;
    }

    public final void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        AegisLogger.INSTANCE.i("Audience|OrientationChecker", QCircleLpReportDc05507.KEY_CLEAR);
        listeners.clear();
        orientationEventListener.disable();
    }

    public final boolean j(long roomId, @Nullable InterfaceC8398a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, Long.valueOf(roomId), listener)).booleanValue();
        }
        boolean g16 = g();
        AegisLogger.INSTANCE.i("Audience|OrientationChecker", "startWatch", "roomId=" + roomId + ", canCheck=" + g16);
        if (!g16 || listener == null) {
            return false;
        }
        listeners.put(Long.valueOf(roomId), listener);
        orientationEventListener.enable();
        return true;
    }

    public final void k(long roomId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, roomId);
            return;
        }
        AegisLogger.INSTANCE.i("Audience|OrientationChecker", "stopWatch", "roomId=" + roomId);
        listeners.remove(Long.valueOf(roomId));
    }
}
