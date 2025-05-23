package com.tencent.videocut.utils;

import android.graphics.PointF;
import android.view.MotionEvent;
import com.tencent.mobileqq.app.MessageHandlerConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\u0007\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/videocut/utils/h;", "", "Landroid/graphics/PointF;", "p1", "p2", "", "a", "c", "Landroid/view/MotionEvent;", "event", "d", "", "deltaX", "deltaY", "b", "<init>", "()V", "lib_utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f384240a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(MessageHandlerConstants.NOTIFY_TYPE_REQ_INSERT_BLACKLIST_PB);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f384240a = new h();
        }
    }

    h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    public final float a(@Nullable PointF p16, @Nullable PointF p26) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Float) iPatchRedirector.redirect((short) 1, (Object) this, (Object) p16, (Object) p26)).floatValue();
        }
        if (p16 != null && p26 != null) {
            float f16 = p16.x - p26.x;
            double d16 = p16.y - p26.y;
            return (float) Math.sqrt((f16 * f16) + (d16 * d16));
        }
        return 0.0f;
    }

    public final float b(double deltaX, double deltaY) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Float) iPatchRedirector.redirect((short) 5, this, Double.valueOf(deltaX), Double.valueOf(deltaY))).floatValue();
        }
        return (float) Math.toDegrees(Math.atan2(deltaY, deltaX));
    }

    public final float c(@Nullable PointF p16, @Nullable PointF p26) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Float) iPatchRedirector.redirect((short) 3, (Object) this, (Object) p16, (Object) p26)).floatValue();
        }
        if (p16 != null && p26 != null) {
            return b(p16.x - p26.x, p16.y - p26.y);
        }
        return 0.0f;
    }

    public final float d(@NotNull MotionEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Float) iPatchRedirector.redirect((short) 4, (Object) this, (Object) event)).floatValue();
        }
        Intrinsics.checkNotNullParameter(event, "event");
        return b(event.getX(1) - event.getX(0), event.getY(1) - event.getY(0));
    }
}
